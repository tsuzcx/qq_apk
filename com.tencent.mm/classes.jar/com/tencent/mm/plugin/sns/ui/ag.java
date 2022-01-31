package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.a.a;
import com.tencent.xweb.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ag
  extends a
{
  private String appId;
  private String appName;
  MMActivity cmc;
  private String mSessionId;
  private int rGd;
  private com.tencent.mm.modelsns.b rGj;
  private boolean rHD;
  private boolean rHE;
  private WXMediaMessage rHF;
  private String rIA;
  private boolean rIB;
  ag.b rJW;
  v rJX;
  Map<String, Exif.a> rJY;
  private Map<String, cet> rJZ;
  private int rKa;
  private boolean rKb;
  bap rKc;
  
  public ag(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(38493);
    this.rJW = new ag.b(this);
    this.rIB = false;
    this.rJY = new HashMap();
    this.rJZ = new HashMap();
    this.rKa = 0;
    this.rHD = false;
    this.rKb = false;
    this.rHE = false;
    this.rHF = null;
    this.rGj = null;
    this.cmc = paramMMActivity;
    AppMethodBeat.o(38493);
  }
  
  private boolean X(Bundle paramBundle)
  {
    AppMethodBeat.i(38496);
    if (paramBundle == null)
    {
      AppMethodBeat.o(38496);
      return false;
    }
    paramBundle = paramBundle.getStringArrayList("sns_media_latlong_list");
    if (paramBundle == null)
    {
      AppMethodBeat.o(38496);
      return false;
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      String[] arrayOfString = ((String)paramBundle.next()).split("\n");
      if (3 != arrayOfString.length)
      {
        ab.e("MicroMsg.PicWidget", "invalid params");
        AppMethodBeat.o(38496);
        return true;
      }
      try
      {
        this.rJY.put(arrayOfString[0].trim(), new Exif.a(bo.getDouble(arrayOfString[1], 0.0D), bo.getDouble(arrayOfString[2], 0.0D), 0.0D));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ab.e("MicroMsg.PicWidget", localNumberFormatException.toString());
      }
    }
    AppMethodBeat.o(38496);
    return true;
  }
  
  private static com.tencent.mm.plugin.sns.model.ay a(com.tencent.mm.plugin.sns.model.ay paramay, List<com.tencent.mm.plugin.sns.data.h> paramList)
  {
    AppMethodBeat.i(38501);
    paramay.dd(paramList);
    AppMethodBeat.o(38501);
    return paramay;
  }
  
  final void EG(int paramInt)
  {
    AppMethodBeat.i(38508);
    am localam = new am().Fn();
    localam.cUF = paramInt;
    localam.fR(this.rIA).ake();
    AppMethodBeat.o(38508);
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(38494);
    this.rGj = com.tencent.mm.modelsns.b.w(this.cmc.getIntent());
    this.rIB = this.cmc.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.appId = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rHD = this.cmc.getIntent().getBooleanExtra("KThrid_app", false);
    this.rKb = this.cmc.getIntent().getBooleanExtra("KBlockAdd", false);
    this.rHE = this.cmc.getIntent().getBooleanExtra("KSnsAction", false);
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = bo.bf(this.cmc.getIntent().getStringExtra("reportSessionId"), "");
    this.rIA = this.cmc.getIntent().getStringExtra("KSessionID");
    Object localObject1 = this.cmc.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (localObject1 != null) {
      this.rHF = new SendMessageToWX.Req((Bundle)localObject1).message;
    }
    Object localObject3 = this.cmc.getIntent().getStringExtra("sns_kemdia_path");
    Object localObject4 = this.cmc.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = localObject4;
      if (this.rHF != null)
      {
        localObject1 = localObject4;
        if (this.rHF.mediaObject != null)
        {
          localObject1 = localObject4;
          if ((this.rHF.mediaObject instanceof WXImageObject)) {
            localObject1 = ((WXImageObject)this.rHF.mediaObject).imageData;
          }
        }
      }
    }
    if ((bo.isNullOrNil((String)localObject3)) && (!bo.ce((byte[])localObject1)))
    {
      localObject3 = com.tencent.mm.plugin.sns.model.ag.getAccSnsTmpPath() + com.tencent.mm.a.g.w(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
      com.tencent.mm.vfs.e.deleteFile((String)localObject3);
      com.tencent.mm.vfs.e.b((String)localObject3, (byte[])localObject1, localObject1.length);
    }
    label700:
    Object localObject2;
    for (localObject1 = localObject3;; localObject2 = localObject3)
    {
      int j = this.cmc.getIntent().getIntExtra("KFilterId", 0);
      if (paramBundle == null) {}
      boolean bool;
      for (localObject3 = null;; localObject3 = paramBundle.getString("sns_kemdia_path_list"))
      {
        X(paramBundle);
        bool = X(this.cmc.getIntent().getExtras());
        this.rKa = 0;
        if (bo.isNullOrNil((String)localObject3)) {
          break;
        }
        this.rJW.ace((String)localObject3);
        AppMethodBeat.o(38494);
        return;
      }
      paramBundle = this.cmc.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
      if (!bo.es(paramBundle))
      {
        paramBundle = paramBundle.iterator();
        if (paramBundle.hasNext())
        {
          localObject1 = (String)paramBundle.next();
          ab.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(localObject1)));
          this.rJW.q((String)localObject1, j, false);
          if (!bool)
          {
            localObject3 = Exif.fromFile((String)localObject1).getLocation();
            if (localObject3 != null) {
              this.rJY.put(localObject1, localObject3);
            }
          }
          for (;;)
          {
            try
            {
              localObject3 = new com.tencent.mm.vfs.b((String)localObject1);
              localObject4 = new cet();
              if (!this.rIB) {
                break label700;
              }
              i = 1;
              ((cet)localObject4).xPl = i;
              ((cet)localObject4).xPn = (((com.tencent.mm.vfs.b)localObject3).lastModified() / 1000L);
              ((cet)localObject4).xPm = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
              this.rJZ.put(localObject1, localObject4);
            }
            catch (Exception localException)
            {
              ab.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
            }
            break;
            i = 2;
          }
        }
        AppMethodBeat.o(38494);
        return;
      }
      if (!bo.isNullOrNil(localException))
      {
        paramBundle = com.tencent.mm.plugin.sns.model.ag.getAccSnsTmpPath() + "pre_temp_sns_pic" + com.tencent.mm.a.g.w(localException.getBytes());
        com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(paramBundle));
        com.tencent.mm.vfs.e.C(localException, paramBundle);
        if (j != -1) {
          break label940;
        }
      }
      label940:
      for (int i = 0;; i = j)
      {
        this.rJW.q(paramBundle, i, this.rIB);
        if (!bool)
        {
          localObject3 = Exif.fromFile(localException).getLocation();
          if (localObject3 != null) {
            this.rJY.put(paramBundle, localObject3);
          }
        }
        try
        {
          localObject3 = new com.tencent.mm.vfs.b(localException);
          localObject4 = new cet();
          if (this.rIB) {}
          for (i = 1;; i = 2)
          {
            ((cet)localObject4).xPl = i;
            ((cet)localObject4).xPn = (((com.tencent.mm.vfs.b)localObject3).lastModified() / 1000L);
            ((cet)localObject4).xPm = Exif.fromFile(localException).getUxtimeDatatimeOriginal();
            this.rJZ.put(paramBundle, localObject4);
            AppMethodBeat.o(38494);
            return;
          }
          AppMethodBeat.o(38494);
        }
        catch (Exception paramBundle)
        {
          ab.e("MicroMsg.PicWidget", "get report info error " + paramBundle.getMessage());
        }
        return;
      }
    }
  }
  
  public final void W(Bundle paramBundle)
  {
    AppMethodBeat.i(38497);
    paramBundle.putString("sns_kemdia_path_list", this.rJW.toString());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.rJY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(String.format("%s\n%f\n%f", new Object[] { localEntry.getKey(), Double.valueOf(((Exif.a)localEntry.getValue()).latitude), Double.valueOf(((Exif.a)localEntry.getValue()).longitude) }));
    }
    paramBundle.putStringArrayList("sns_media_latlong_list", localArrayList);
    paramBundle.getString("contentdesc");
    AppMethodBeat.o(38497);
  }
  
  public final View a(View paramView1, View paramView2, DynamicGridView paramDynamicGridView, View paramView3)
  {
    AppMethodBeat.i(38499);
    boolean bool;
    if (this.rJX == null)
    {
      MMActivity localMMActivity = this.cmc;
      ArrayList localArrayList = this.rJW.rKh;
      ag.1 local1 = new ag.1(this);
      ag.2 local2 = new ag.2(this);
      if (!this.rKb)
      {
        bool = true;
        this.rJX = new com.tencent.mm.plugin.sns.ui.previewimageview.e(paramView1, paramView2, paramView3, localMMActivity, localArrayList, paramDynamicGridView, local1, local2, bool);
      }
    }
    for (;;)
    {
      paramView1 = this.rJX.getView();
      AppMethodBeat.o(38499);
      return paramView1;
      bool = false;
      break;
      this.rJX.setList$22875ea3(this.rJW.rKh);
    }
  }
  
  final void a(com.tencent.mm.plugin.sns.model.ay paramay)
  {
    AppMethodBeat.i(38502);
    int i = paramay.commit();
    if (this.rGj != null)
    {
      this.rGj.lX(i);
      com.tencent.mm.plugin.sns.i.g.roZ.c(this.rGj);
    }
    if ((this.rJW != null) && (this.rJW.rKh != null) && (s.cth())) {
      com.tencent.mm.plugin.report.service.h.qsU.e(12834, new Object[] { Integer.valueOf(this.rJW.rKh.size()) });
    }
    paramay = new Intent();
    paramay.putExtra("sns_local_id", i);
    this.cmc.setResult(-1, paramay);
    this.cmc.finish();
    AppMethodBeat.o(38502);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(38503);
    paramString2 = new LinkedList();
    Object localObject1 = this.rJW.rKh.iterator();
    int i = 0;
    Object localObject2;
    Object localObject3;
    label109:
    Object localObject4;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new com.tencent.mm.plugin.sns.data.h((String)localObject2, 2);
      ((com.tencent.mm.plugin.sns.data.h)localObject3).type = 2;
      ((com.tencent.mm.plugin.sns.data.h)localObject3).rbr = paramInt1;
      int j;
      if (i == 0)
      {
        ((com.tencent.mm.plugin.sns.data.h)localObject3).rbq = paramInt2;
        if (parami != null)
        {
          ((com.tencent.mm.plugin.sns.data.h)localObject3).rbs = parami.token;
          ((com.tencent.mm.plugin.sns.data.h)localObject3).rbt = parami.xsy;
        }
        localObject4 = this.rJW;
        if (!((ag.b)localObject4).rKj.containsKey(localObject2)) {
          break label248;
        }
        j = ((Integer)((ag.b)localObject4).rKj.get(localObject2)).intValue();
        label150:
        ((com.tencent.mm.plugin.sns.data.h)localObject3).filterId = j;
        ((com.tencent.mm.plugin.sns.data.h)localObject3).desc = paramString1;
        localObject4 = this.rJW;
        if ((bo.isNullOrNil((String)localObject2)) || (!((ag.b)localObject4).rKi.containsKey(localObject2))) {
          break label254;
        }
      }
      label248:
      label254:
      for (boolean bool = ((Boolean)((ag.b)localObject4).rKi.get(localObject2)).booleanValue();; bool = false)
      {
        ((com.tencent.mm.plugin.sns.data.h)localObject3).rbv = bool;
        paramString2.add(localObject3);
        i += 1;
        break;
        ((com.tencent.mm.plugin.sns.data.h)localObject3).rbq = 0;
        break label109;
        j = 0;
        break label150;
      }
    }
    localObject1 = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      localObject2 = com.tencent.mm.model.t.aac();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject3 = (String)paramList1.next();
        if (!((List)localObject2).contains(localObject3))
        {
          localObject4 = new cfm();
          ((cfm)localObject4).jJA = ((String)localObject3);
          ((LinkedList)localObject1).add(localObject4);
        }
      }
    }
    paramList1 = new com.tencent.mm.plugin.sns.model.ay(1);
    paramPInt.value = paramList1.ayi;
    if (parami != null) {
      paramList1.go(parami.token, parami.xsy);
    }
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.raX) {
      paramList1.DS(3);
    }
    paramList1.aaL(paramString1).a(parambap).av((LinkedList)localObject1).DU(paramInt1).DV(paramInt2);
    if (paramBoolean) {
      paramList1.DX(1);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.appId)) {
        paramList1.aaR(this.appId);
      }
      if (!bo.isNullOrNil(this.appName)) {
        paramList1.aaS(bo.bf(this.appName, ""));
      }
      paramList1.DW(this.rGd);
      if (this.rHD) {
        paramList1.DW(5);
      }
      if ((this.rHE) && (this.rHF != null))
      {
        paramList1.aaM(this.rHF.mediaTagName);
        paramList1.aj(this.appId, this.rHF.messageExt, this.rHF.messageAction);
      }
      paramList1.g(null, null, null, paramInt4, paramInt5);
      paramList1.dc(paramList2);
      paramList1.setSessionId(this.mSessionId);
      if ((parambap != null) && (parambap.score != 0))
      {
        paramInt1 = parambap.score;
        parami = parambap.xpN;
        paramList1.rjs.xsG = new cdo();
        paramList1.rjs.xsG.xOj = paramInt1;
        paramList1.rjs.xsG.xOg = parami;
      }
      ab.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[] { Integer.valueOf(paramString2.size()), Integer.valueOf(this.rKa) });
      com.tencent.mm.plugin.report.service.h.qsU.e(11602, new Object[] { Integer.valueOf(this.rKa), Integer.valueOf(paramString2.size()) });
      parami = paramString2.iterator();
      while (parami.hasNext())
      {
        paramString1 = (com.tencent.mm.plugin.sns.data.h)parami.next();
        ab.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[] { paramString1.path, Long.valueOf(com.tencent.mm.vfs.e.avI(paramString1.path)) });
      }
      paramList1.DX(0);
    }
    paramString1 = paramString2.iterator();
    if (paramString1.hasNext())
    {
      parambap = ((com.tencent.mm.plugin.sns.data.h)paramString1.next()).path;
      parami = (cet)this.rJZ.get(parambap);
      if (parami != null) {
        break label1342;
      }
      parami = new cet();
    }
    label943:
    label1342:
    for (;;)
    {
      if ((this.rKc != null) && ((this.rKc.wDi != 0.0F) || (this.rKc.wDh != 0.0F)))
      {
        parami.xPj = this.rKc.wDi;
        parami.xPk = this.rKc.wDh;
        parami.rIi = this.rKc.rIi;
        parami.boo = this.rKc.boo;
        parambap = (Exif.a)this.rJY.get(parambap);
        if ((parambap == null) || ((parambap.latitude == 0.0D) && (parambap.longitude == 0.0D))) {
          break label1249;
        }
        parami.xPh = ((float)parambap.latitude);
      }
      for (parami.xPi = ((float)parambap.longitude);; parami.xPi = -1000.0F)
      {
        parambap = new StringBuffer();
        parambap.append("||index: " + paramList1.rjs.xsB.size());
        parambap.append("||item poi lat " + parami.xPj + " " + parami.xPk);
        parambap.append("||item pic lat " + parami.xPh + " " + parami.xPi);
        parambap.append("||item exitime:" + parami.xPm + " filetime: " + parami.xPn);
        parambap.append("||item source: " + parami.xPl);
        ab.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + parambap.toString());
        paramList1.rjs.xsB.add(parami);
        break;
        parami.xPj = -1000.0F;
        parami.xPk = -1000.0F;
        break label943;
        label1249:
        parami.xPh = -1000.0F;
      }
      if (paramString2.size() <= 1)
      {
        a(paramList1, paramString2);
        a(paramList1);
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.RO().ac(new ag.4(this));
        AppMethodBeat.o(38503);
        return true;
        new ag.a(this, paramList1, paramString2).v(new String[] { "" });
      }
    }
  }
  
  public final boolean ctu()
  {
    AppMethodBeat.i(38498);
    if (this.rJW != null)
    {
      ag.b localb = this.rJW;
      if ((localb.rKh != null) && (localb.rKh.size() > 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(38498);
        return true;
      }
    }
    AppMethodBeat.o(38498);
    return false;
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(38500);
    this.rJX = new PreviewImageView(this.cmc);
    if (this.rKb) {
      this.rJX.setIsShowAddImage(false);
    }
    this.rJX.setImageClick(new ag.3(this));
    this.rJX.setList$22875ea3(this.rJW.rKh);
    View localView = this.rJX.getView();
    AppMethodBeat.o(38500);
    return localView;
  }
  
  public final boolean ctw()
  {
    AppMethodBeat.i(38507);
    if (this.rJX != null) {
      this.rJX.clean();
    }
    this.rJY.clear();
    this.rJZ.clear();
    AppMethodBeat.o(38507);
    return false;
  }
  
  public final int cup()
  {
    AppMethodBeat.i(38495);
    int i = this.rJW.rKh.size();
    AppMethodBeat.o(38495);
    return i;
  }
  
  protected final boolean cuq()
  {
    AppMethodBeat.i(38504);
    com.tencent.mm.kernel.g.RM();
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(this.cmc);
      AppMethodBeat.o(38504);
      return false;
    }
    if (this.rJW.rKh.size() >= 9)
    {
      com.tencent.mm.ui.base.h.h(this.cmc, 2131304036, 2131297087);
      AppMethodBeat.o(38504);
      return false;
    }
    try
    {
      ay localay = new ay(this.cmc);
      localay.sao = new ag.5(this);
      localay.sap = new ag.6(this);
      localay.cwt();
      label112:
      AppMethodBeat.o(38504);
      return true;
    }
    catch (Exception localException)
    {
      break label112;
    }
  }
  
  public final boolean d(List<String> paramList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38505);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.i("MicroMsg.PicWidget", "no image selected");
      AppMethodBeat.o(38505);
      return true;
    }
    if (this.rJW.rKh.size() >= 9)
    {
      AppMethodBeat.o(38505);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      if (com.tencent.mm.vfs.e.cN((String)localObject))
      {
        String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.w(new StringBuilder().append((String)localObject).append(System.currentTimeMillis()).toString().getBytes());
        s.an(com.tencent.mm.plugin.sns.model.ag.getAccSnsTmpPath(), (String)localObject, str);
        ab.d("MicroMsg.PicWidget", "newPath " + com.tencent.mm.plugin.sns.model.ag.getAccSnsTmpPath() + str);
        this.rJW.q(com.tencent.mm.plugin.sns.model.ag.getAccSnsTmpPath() + str, paramInt, paramBoolean);
        ((com.tencent.mm.plugin.sns.ui.previewimageview.e)this.rJX).Fm(this.rJW.rKh.size());
        this.rJX.setList$22875ea3(this.rJW.rKh);
        this.cmc.getIntent().putExtra("sns_kemdia_path_list", this.rJW.rKh);
        for (;;)
        {
          try
          {
            com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b((String)localObject);
            cet localcet = new cet();
            if (!paramBoolean) {
              continue;
            }
            i = 1;
            localcet.xPl = i;
            localcet.xPn = (localb.lastModified() / 1000L);
            localcet.xPm = Exif.fromFile((String)localObject).getUxtimeDatatimeOriginal();
            this.rJZ.put(com.tencent.mm.plugin.sns.model.ag.getAccSnsTmpPath() + str, localcet);
          }
          catch (Exception localException)
          {
            int i;
            ab.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
            continue;
          }
          localObject = Exif.fromFile((String)localObject).getLocation();
          if (localObject == null) {
            break;
          }
          this.rJY.put(com.tencent.mm.plugin.sns.model.ag.getAccSnsTmpPath() + str, localObject);
          break;
          i = 2;
        }
      }
    }
    AppMethodBeat.o(38505);
    return true;
  }
  
  /* Error */
  public final boolean j(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 969
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+53 -> 60, 2:+61->68, 3:+163->170, 4:+1132->1139, 5:+53->60, 6:+53->60, 7:+1512->1519, 8:+53->60, 9:+485->492, 10:+53->60, 11:+928->935
    //   61: iconst_0
    //   62: jsr_w 184 0 85 3
    //   67: ireturn
    //   68: ldc 125
    //   70: ldc_w 971
    //   73: invokestatic 375	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_2
    //   77: ifnonnull +11 -> 88
    //   80: ldc_w 969
    //   83: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_0
    //   87: ireturn
    //   88: ldc 125
    //   90: ldc_w 973
    //   93: invokestatic 375	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 211	android/content/Intent
    //   99: dup
    //   100: invokespecial 554	android/content/Intent:<init>	()V
    //   103: astore 4
    //   105: aload 4
    //   107: ldc_w 975
    //   110: iconst_4
    //   111: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload 4
    //   117: ldc_w 977
    //   120: iconst_1
    //   121: invokevirtual 980	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   124: pop
    //   125: aload 4
    //   127: ldc_w 982
    //   130: iconst_1
    //   131: invokevirtual 980	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   134: pop
    //   135: getstatic 986	com/tencent/mm/plugin/sns/c/a:gmO	Lcom/tencent/mm/pluginsdk/n;
    //   138: aload_0
    //   139: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   142: aload_2
    //   143: aload 4
    //   145: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   148: iconst_4
    //   149: new 6	com/tencent/mm/plugin/sns/ui/ag$7
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 987	com/tencent/mm/plugin/sns/ui/ag$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/ag;)V
    //   157: invokeinterface 992 7 0
    //   162: ldc_w 969
    //   165: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_1
    //   169: ireturn
    //   170: ldc 125
    //   172: ldc_w 994
    //   175: invokestatic 375	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   182: invokevirtual 998	com/tencent/mm/ui/MMActivity:getApplicationContext	()Landroid/content/Context;
    //   185: aload_2
    //   186: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   189: invokestatic 1003	com/tencent/mm/pluginsdk/ui/tools/n:h	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_2
    //   193: aload_2
    //   194: ifnonnull +11 -> 205
    //   197: ldc_w 969
    //   200: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iconst_1
    //   204: ireturn
    //   205: new 211	android/content/Intent
    //   208: dup
    //   209: invokespecial 554	android/content/Intent:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: ldc_w 975
    //   219: iconst_4
    //   220: invokevirtual 560	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   223: pop
    //   224: aload 4
    //   226: ldc_w 982
    //   229: iconst_1
    //   230: invokevirtual 980	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   233: pop
    //   234: aload 4
    //   236: ldc_w 977
    //   239: iconst_1
    //   240: invokevirtual 980	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   243: pop
    //   244: aload 4
    //   246: ldc_w 1005
    //   249: aload_2
    //   250: invokevirtual 1008	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   253: pop
    //   254: new 296	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   261: aload_2
    //   262: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokestatic 317	java/lang/System:currentTimeMillis	()J
    //   268: invokevirtual 320	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 325	java/lang/String:getBytes	()[B
    //   277: invokestatic 330	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   280: astore 5
    //   282: aload 4
    //   284: ldc_w 1010
    //   287: new 296	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   294: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   297: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 5
    //   302: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 1008	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   311: pop
    //   312: aload_2
    //   313: invokestatic 385	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   316: invokevirtual 389	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   319: astore 6
    //   321: aload 6
    //   323: ifnull +70 -> 393
    //   326: aload_0
    //   327: getfield 66	com/tencent/mm/plugin/sns/ui/ag:rJY	Ljava/util/Map;
    //   330: new 296	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   337: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   340: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 5
    //   345: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: aload 6
    //   353: invokeinterface 154 3 0
    //   358: pop
    //   359: ldc 125
    //   361: ldc_w 1012
    //   364: iconst_2
    //   365: anewarray 449	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload 6
    //   372: getfield 459	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   375: invokestatic 464	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: aload 6
    //   383: getfield 467	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   386: invokestatic 464	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   389: aastore
    //   390: invokestatic 1014	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: new 394	com/tencent/mm/protocal/protobuf/cet
    //   396: dup
    //   397: invokespecial 395	com/tencent/mm/protocal/protobuf/cet:<init>	()V
    //   400: astore 6
    //   402: aload 6
    //   404: iconst_1
    //   405: putfield 398	com/tencent/mm/protocal/protobuf/cet:xPl	I
    //   408: aload 6
    //   410: invokestatic 317	java/lang/System:currentTimeMillis	()J
    //   413: putfield 406	com/tencent/mm/protocal/protobuf/cet:xPn	J
    //   416: aload 6
    //   418: aload_2
    //   419: invokestatic 385	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   422: getfield 1017	com/tencent/mm/compatible/util/Exif:dateTime	Ljava/lang/String;
    //   425: invokestatic 1020	com/tencent/mm/sdk/platformtools/bo:apW	(Ljava/lang/String;)J
    //   428: putfield 412	com/tencent/mm/protocal/protobuf/cet:xPm	J
    //   431: aload_0
    //   432: getfield 68	com/tencent/mm/plugin/sns/ui/ag:rJZ	Ljava/util/Map;
    //   435: new 296	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   442: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   445: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 5
    //   450: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: aload 6
    //   458: invokeinterface 154 3 0
    //   463: pop
    //   464: getstatic 986	com/tencent/mm/plugin/sns/c/a:gmO	Lcom/tencent/mm/pluginsdk/n;
    //   467: aload_0
    //   468: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   471: aload 4
    //   473: iconst_4
    //   474: invokeinterface 1023 4 0
    //   479: aload_0
    //   480: iconst_1
    //   481: putfield 61	com/tencent/mm/plugin/sns/ui/ag:rIB	Z
    //   484: ldc_w 969
    //   487: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: iconst_1
    //   491: ireturn
    //   492: aload_2
    //   493: ldc_w 1025
    //   496: invokevirtual 359	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   499: astore 4
    //   501: aload 4
    //   503: ifnull +11 -> 514
    //   506: aload 4
    //   508: invokevirtual 545	java/util/ArrayList:size	()I
    //   511: ifgt +16 -> 527
    //   514: aload_2
    //   515: ldc_w 1027
    //   518: invokevirtual 221	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   521: invokestatic 290	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   524: ifne +375 -> 899
    //   527: aload 4
    //   529: ifnull +124 -> 653
    //   532: aload 4
    //   534: invokevirtual 545	java/util/ArrayList:size	()I
    //   537: ifle +116 -> 653
    //   540: aload 4
    //   542: iconst_0
    //   543: invokevirtual 1030	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   546: checkcast 117	java/lang/String
    //   549: astore 4
    //   551: aload_2
    //   552: ldc_w 1032
    //   555: invokevirtual 221	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   558: astore 5
    //   560: aload 5
    //   562: invokestatic 290	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   565: ifne +14 -> 579
    //   568: aload 5
    //   570: astore_2
    //   571: aload 5
    //   573: invokestatic 955	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   576: ifne +180 -> 756
    //   579: new 296	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   586: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   589: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload 4
    //   594: invokestatic 1035	com/tencent/mm/a/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   597: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: astore_2
    //   604: new 1037	android/media/MediaMetadataRetriever
    //   607: dup
    //   608: invokespecial 1038	android/media/MediaMetadataRetriever:<init>	()V
    //   611: astore 5
    //   613: aload 5
    //   615: aload 4
    //   617: invokevirtual 1041	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   620: aload 5
    //   622: lconst_0
    //   623: invokevirtual 1045	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   626: astore 6
    //   628: aload 6
    //   630: ifnonnull +35 -> 665
    //   633: ldc 125
    //   635: ldc_w 1047
    //   638: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: aload 5
    //   643: invokevirtual 1050	android/media/MediaMetadataRetriever:release	()V
    //   646: goto -586 -> 60
    //   649: astore_2
    //   650: goto -590 -> 60
    //   653: aload_2
    //   654: ldc_w 1027
    //   657: invokevirtual 221	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   660: astore 4
    //   662: goto -111 -> 551
    //   665: ldc 125
    //   667: ldc_w 1052
    //   670: iconst_2
    //   671: anewarray 449	java/lang/Object
    //   674: dup
    //   675: iconst_0
    //   676: aload 6
    //   678: invokevirtual 1057	android/graphics/Bitmap:getWidth	()I
    //   681: invokestatic 550	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   684: aastore
    //   685: dup
    //   686: iconst_1
    //   687: aload 6
    //   689: invokevirtual 1060	android/graphics/Bitmap:getHeight	()I
    //   692: invokestatic 550	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   695: aastore
    //   696: invokestatic 762	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   699: aload 6
    //   701: bipush 80
    //   703: getstatic 1066	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   706: aload_2
    //   707: iconst_1
    //   708: invokestatic 1071	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   711: aload_2
    //   712: invokestatic 1075	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   715: astore 6
    //   717: ldc 125
    //   719: ldc_w 1077
    //   722: iconst_2
    //   723: anewarray 449	java/lang/Object
    //   726: dup
    //   727: iconst_0
    //   728: aload 6
    //   730: getfield 1082	android/graphics/BitmapFactory$Options:outWidth	I
    //   733: invokestatic 550	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   736: aastore
    //   737: dup
    //   738: iconst_1
    //   739: aload 6
    //   741: getfield 1085	android/graphics/BitmapFactory$Options:outHeight	I
    //   744: invokestatic 550	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   747: aastore
    //   748: invokestatic 762	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   751: aload 5
    //   753: invokevirtual 1050	android/media/MediaMetadataRetriever:release	()V
    //   756: ldc 125
    //   758: ldc_w 1087
    //   761: iconst_4
    //   762: anewarray 449	java/lang/Object
    //   765: dup
    //   766: iconst_0
    //   767: aload 4
    //   769: aastore
    //   770: dup
    //   771: iconst_1
    //   772: aload_2
    //   773: aastore
    //   774: dup
    //   775: iconst_2
    //   776: aload 4
    //   778: invokestatic 771	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   781: invokestatic 776	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   784: aastore
    //   785: dup
    //   786: iconst_3
    //   787: aload_2
    //   788: invokestatic 771	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   791: invokestatic 776	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   794: aastore
    //   795: invokestatic 762	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   798: aload 4
    //   800: invokestatic 1035	com/tencent/mm/a/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   803: astore 5
    //   805: aload_0
    //   806: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   809: instanceof 1089
    //   812: ifeq +30 -> 842
    //   815: aload_0
    //   816: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   819: checkcast 1089	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   822: aload 4
    //   824: aload_2
    //   825: aload 5
    //   827: aconst_null
    //   828: iconst_0
    //   829: invokevirtual 1092	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   832: aload_0
    //   833: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   836: checkcast 1089	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   839: invokevirtual 1095	com/tencent/mm/plugin/sns/ui/SnsUploadUI:cwE	()V
    //   842: ldc_w 969
    //   845: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   848: iconst_1
    //   849: ireturn
    //   850: astore 6
    //   852: ldc 125
    //   854: ldc_w 1097
    //   857: iconst_1
    //   858: anewarray 449	java/lang/Object
    //   861: dup
    //   862: iconst_0
    //   863: aload 6
    //   865: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   868: aastore
    //   869: invokestatic 1099	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   872: aload 5
    //   874: invokevirtual 1050	android/media/MediaMetadataRetriever:release	()V
    //   877: goto -121 -> 756
    //   880: astore 5
    //   882: goto -126 -> 756
    //   885: astore_2
    //   886: aload 5
    //   888: invokevirtual 1050	android/media/MediaMetadataRetriever:release	()V
    //   891: ldc_w 969
    //   894: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   897: aload_2
    //   898: athrow
    //   899: aload_0
    //   900: aload_2
    //   901: ldc_w 1101
    //   904: invokevirtual 359	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   907: aload_2
    //   908: ldc_w 1103
    //   911: iconst_0
    //   912: invokevirtual 245	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   915: aload_2
    //   916: ldc_w 1105
    //   919: iconst_0
    //   920: invokevirtual 215	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   923: invokevirtual 1107	com/tencent/mm/plugin/sns/ui/ag:d	(Ljava/util/List;IZ)Z
    //   926: istore_3
    //   927: ldc_w 969
    //   930: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   933: iload_3
    //   934: ireturn
    //   935: aload_2
    //   936: ldc_w 1109
    //   939: invokevirtual 1113	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   942: checkcast 1115	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   945: astore 5
    //   947: aload 5
    //   949: ifnull -889 -> 60
    //   952: aload 5
    //   954: getfield 1118	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFG	Z
    //   957: ifeq +35 -> 992
    //   960: aload 5
    //   962: getfield 1121	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFO	Ljava/lang/String;
    //   965: astore_2
    //   966: aload_2
    //   967: invokestatic 290	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   970: ifne -910 -> 60
    //   973: aload_0
    //   974: aload_2
    //   975: invokestatic 1127	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   978: iconst_0
    //   979: iconst_1
    //   980: invokevirtual 1107	com/tencent/mm/plugin/sns/ui/ag:d	(Ljava/util/List;IZ)Z
    //   983: istore_3
    //   984: ldc_w 969
    //   987: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   990: iload_3
    //   991: ireturn
    //   992: aload 5
    //   994: getfield 1130	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFI	Ljava/lang/String;
    //   997: astore 6
    //   999: aload 5
    //   1001: getfield 1133	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFJ	Ljava/lang/String;
    //   1004: astore 7
    //   1006: aconst_null
    //   1007: astore 4
    //   1009: aload_0
    //   1010: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   1013: invokevirtual 201	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1016: ldc_w 1135
    //   1019: aload 5
    //   1021: getfield 1133	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFJ	Ljava/lang/String;
    //   1024: invokevirtual 1008	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1027: pop
    //   1028: aload 5
    //   1030: getfield 1138	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFL	Ljava/lang/String;
    //   1033: invokestatic 290	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   1036: ifne +69 -> 1105
    //   1039: aload 5
    //   1041: getfield 1138	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFL	Ljava/lang/String;
    //   1044: astore_2
    //   1045: aload 5
    //   1047: getfield 1142	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFN	Lcom/tencent/mm/protocal/protobuf/bby;
    //   1050: invokevirtual 1147	com/tencent/mm/protocal/protobuf/bby:toByteArray	()[B
    //   1053: astore 5
    //   1055: aload 5
    //   1057: astore 4
    //   1059: aload_0
    //   1060: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   1063: instanceof 1089
    //   1066: ifeq +31 -> 1097
    //   1069: aload_0
    //   1070: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   1073: checkcast 1089	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1076: aload 6
    //   1078: aload 7
    //   1080: aload_2
    //   1081: aload 4
    //   1083: iconst_1
    //   1084: invokevirtual 1092	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   1087: aload_0
    //   1088: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   1091: checkcast 1089	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1094: invokevirtual 1095	com/tencent/mm/plugin/sns/ui/SnsUploadUI:cwE	()V
    //   1097: ldc_w 969
    //   1100: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1103: iconst_1
    //   1104: ireturn
    //   1105: aload 6
    //   1107: invokestatic 1035	com/tencent/mm/a/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   1110: astore_2
    //   1111: goto -66 -> 1045
    //   1114: astore 5
    //   1116: ldc 125
    //   1118: ldc_w 1149
    //   1121: iconst_1
    //   1122: anewarray 449	java/lang/Object
    //   1125: dup
    //   1126: iconst_0
    //   1127: aload 5
    //   1129: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1132: aastore
    //   1133: invokestatic 762	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1136: goto -77 -> 1059
    //   1139: ldc 125
    //   1141: ldc_w 1151
    //   1144: invokestatic 375	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1147: aload_2
    //   1148: ifnonnull +11 -> 1159
    //   1151: ldc_w 969
    //   1154: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1157: iconst_1
    //   1158: ireturn
    //   1159: aload_2
    //   1160: ldc_w 1010
    //   1163: invokevirtual 221	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1166: astore 4
    //   1168: ldc 125
    //   1170: ldc_w 1153
    //   1173: aload 4
    //   1175: invokestatic 369	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1178: invokevirtual 372	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1181: invokestatic 375	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1184: aload 4
    //   1186: ifnonnull +11 -> 1197
    //   1189: ldc_w 969
    //   1192: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1195: iconst_1
    //   1196: ireturn
    //   1197: aload 4
    //   1199: invokestatic 955	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   1202: ifne +11 -> 1213
    //   1205: ldc_w 969
    //   1208: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1211: iconst_1
    //   1212: ireturn
    //   1213: aload_0
    //   1214: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1217: getfield 489	com/tencent/mm/plugin/sns/ui/ag$b:rKh	Ljava/util/ArrayList;
    //   1220: invokevirtual 545	java/util/ArrayList:size	()I
    //   1223: bipush 9
    //   1225: if_icmplt +11 -> 1236
    //   1228: ldc_w 969
    //   1231: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1234: iconst_1
    //   1235: ireturn
    //   1236: aload_2
    //   1237: ldc_w 1103
    //   1240: iconst_0
    //   1241: invokevirtual 245	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1244: istore_1
    //   1245: new 296	java/lang/StringBuilder
    //   1248: dup
    //   1249: ldc_w 419
    //   1252: invokespecial 311	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1255: new 296	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1262: aload 4
    //   1264: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokestatic 317	java/lang/System:currentTimeMillis	()J
    //   1270: invokevirtual 320	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1273: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1276: invokevirtual 325	java/lang/String:getBytes	()[B
    //   1279: invokestatic 330	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   1282: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: astore_2
    //   1289: ldc 125
    //   1291: new 296	java/lang/StringBuilder
    //   1294: dup
    //   1295: ldc_w 1155
    //   1298: invokespecial 311	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1301: aload 4
    //   1303: invokestatic 771	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   1306: invokevirtual 320	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1309: ldc_w 308
    //   1312: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: aload 4
    //   1317: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1323: invokestatic 841	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1326: aload 4
    //   1328: new 296	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1335: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   1338: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: aload_2
    //   1342: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1348: invokestatic 429	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   1351: pop2
    //   1352: aload_0
    //   1353: getfield 66	com/tencent/mm/plugin/sns/ui/ag:rJY	Ljava/util/Map;
    //   1356: aload 4
    //   1358: invokeinterface 606 2 0
    //   1363: ifeq +44 -> 1407
    //   1366: aload_0
    //   1367: getfield 66	com/tencent/mm/plugin/sns/ui/ag:rJY	Ljava/util/Map;
    //   1370: new 296	java/lang/StringBuilder
    //   1373: dup
    //   1374: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1377: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   1380: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: aload_2
    //   1384: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1390: aload_0
    //   1391: getfield 66	com/tencent/mm/plugin/sns/ui/ag:rJY	Ljava/util/Map;
    //   1394: aload 4
    //   1396: invokeinterface 610 2 0
    //   1401: invokeinterface 154 3 0
    //   1406: pop
    //   1407: new 296	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1414: invokestatic 302	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   1417: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: aload_2
    //   1421: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1427: astore_2
    //   1428: ldc 125
    //   1430: ldc_w 365
    //   1433: aload_2
    //   1434: invokestatic 369	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1437: invokevirtual 372	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1440: invokestatic 375	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1443: aload_0
    //   1444: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1447: aload_2
    //   1448: iload_1
    //   1449: iconst_0
    //   1450: invokevirtual 379	com/tencent/mm/plugin/sns/ui/ag$b:q	(Ljava/lang/String;IZ)Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1453: pop
    //   1454: aload_0
    //   1455: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   1458: invokevirtual 201	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1461: ldc_w 353
    //   1464: aload_0
    //   1465: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1468: getfield 489	com/tencent/mm/plugin/sns/ui/ag$b:rKh	Ljava/util/ArrayList;
    //   1471: invokevirtual 965	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1474: pop
    //   1475: aload_0
    //   1476: getfield 485	com/tencent/mm/plugin/sns/ui/ag:rJX	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1479: checkcast 497	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1482: aload_0
    //   1483: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1486: getfield 489	com/tencent/mm/plugin/sns/ui/ag$b:rKh	Ljava/util/ArrayList;
    //   1489: invokevirtual 545	java/util/ArrayList:size	()I
    //   1492: invokevirtual 962	com/tencent/mm/plugin/sns/ui/previewimageview/e:Fm	(I)V
    //   1495: aload_0
    //   1496: getfield 485	com/tencent/mm/plugin/sns/ui/ag:rJX	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1499: aload_0
    //   1500: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1503: getfield 489	com/tencent/mm/plugin/sns/ui/ag$b:rKh	Ljava/util/ArrayList;
    //   1506: invokeinterface 509 2 0
    //   1511: ldc_w 969
    //   1514: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1517: iconst_1
    //   1518: ireturn
    //   1519: aload_2
    //   1520: ifnonnull +11 -> 1531
    //   1523: ldc_w 969
    //   1526: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1529: iconst_1
    //   1530: ireturn
    //   1531: aload_0
    //   1532: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1535: aload_2
    //   1536: ldc_w 1157
    //   1539: invokevirtual 359	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1542: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/ag$b:R	(Ljava/util/ArrayList;)V
    //   1545: aload_0
    //   1546: getfield 82	com/tencent/mm/plugin/sns/ui/ag:cmc	Lcom/tencent/mm/ui/MMActivity;
    //   1549: invokevirtual 201	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1552: ldc_w 353
    //   1555: aload_0
    //   1556: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1559: getfield 489	com/tencent/mm/plugin/sns/ui/ag$b:rKh	Ljava/util/ArrayList;
    //   1562: invokevirtual 965	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1565: pop
    //   1566: aload_0
    //   1567: getfield 485	com/tencent/mm/plugin/sns/ui/ag:rJX	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1570: checkcast 497	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1573: aload_0
    //   1574: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1577: getfield 489	com/tencent/mm/plugin/sns/ui/ag$b:rKh	Ljava/util/ArrayList;
    //   1580: invokevirtual 545	java/util/ArrayList:size	()I
    //   1583: invokevirtual 962	com/tencent/mm/plugin/sns/ui/previewimageview/e:Fm	(I)V
    //   1586: aload_0
    //   1587: getfield 485	com/tencent/mm/plugin/sns/ui/ag:rJX	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1590: aload_0
    //   1591: getfield 59	com/tencent/mm/plugin/sns/ui/ag:rJW	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1594: getfield 489	com/tencent/mm/plugin/sns/ui/ag$b:rKh	Ljava/util/ArrayList;
    //   1597: invokeinterface 509 2 0
    //   1602: aload_0
    //   1603: aload_2
    //   1604: ldc_w 1163
    //   1607: iconst_0
    //   1608: invokevirtual 245	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1611: putfield 70	com/tencent/mm/plugin/sns/ui/ag:rKa	I
    //   1614: ldc_w 969
    //   1617: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1620: iconst_1
    //   1621: ireturn
    //   1622: astore 5
    //   1624: goto -868 -> 756
    //   1627: astore 4
    //   1629: goto -738 -> 891
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1632	0	this	ag
    //   0	1632	1	paramInt	int
    //   0	1632	2	paramIntent	Intent
    //   926	65	3	bool	boolean
    //   103	1292	4	localObject1	Object
    //   1627	1	4	localException1	Exception
    //   280	593	5	localObject2	Object
    //   880	7	5	localException2	Exception
    //   945	111	5	localObject3	Object
    //   1114	14	5	localException3	Exception
    //   1622	1	5	localException4	Exception
    //   319	421	6	localObject4	Object
    //   850	14	6	localException5	Exception
    //   997	109	6	str1	String
    //   1004	75	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   641	646	649	java/lang/Exception
    //   613	628	850	java/lang/Exception
    //   633	641	850	java/lang/Exception
    //   665	751	850	java/lang/Exception
    //   872	877	880	java/lang/Exception
    //   613	628	885	finally
    //   633	641	885	finally
    //   665	751	885	finally
    //   852	872	885	finally
    //   1045	1055	1114	java/lang/Exception
    //   751	756	1622	java/lang/Exception
    //   886	891	1627	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag
 * JD-Core Version:    0.7.0.1
 */