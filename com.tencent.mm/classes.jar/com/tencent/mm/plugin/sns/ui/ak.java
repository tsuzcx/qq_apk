package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class ak
  implements ab
{
  private String appId;
  private String appName;
  MMActivity imP;
  private String mSessionId;
  private int wLo;
  private int xlZ;
  private d xmf;
  private String xmg;
  private boolean xnv;
  private boolean xnw;
  private WXMediaMessage xnx;
  private String xoO;
  private boolean xoP;
  ak.b xqA;
  x xqB;
  Map<String, Exif.a> xqC;
  private Map<String, cvq> xqD;
  private int xqE;
  private boolean xqF;
  bmn xqG;
  
  public ak(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98173);
    this.xqA = new ak.b(this);
    this.xoP = false;
    this.xqC = new HashMap();
    this.xqD = new HashMap();
    this.xqE = 0;
    this.xnv = false;
    this.xqF = false;
    this.xnw = false;
    this.xnx = null;
    this.xmf = null;
    this.wLo = 1;
    this.xmg = "";
    this.imP = paramMMActivity;
    AppMethodBeat.o(98173);
  }
  
  private static ba a(ba paramba, List<p> paramList)
  {
    AppMethodBeat.i(98181);
    paramba.fr(paramList);
    AppMethodBeat.o(98181);
    return paramba;
  }
  
  private boolean ah(Bundle paramBundle)
  {
    AppMethodBeat.i(98176);
    if (paramBundle == null)
    {
      AppMethodBeat.o(98176);
      return false;
    }
    paramBundle = paramBundle.getStringArrayList("sns_media_latlong_list");
    if (paramBundle == null)
    {
      AppMethodBeat.o(98176);
      return false;
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      String[] arrayOfString = ((String)paramBundle.next()).split("\n");
      if (3 != arrayOfString.length)
      {
        ad.e("MicroMsg.PicWidget", "invalid params");
        AppMethodBeat.o(98176);
        return true;
      }
      try
      {
        this.xqC.put(arrayOfString[0].trim(), new Exif.a(bt.getDouble(arrayOfString[1], 0.0D), bt.getDouble(arrayOfString[2], 0.0D), 0.0D));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ad.e("MicroMsg.PicWidget", localNumberFormatException.toString());
      }
    }
    AppMethodBeat.o(98176);
    return true;
  }
  
  final void Nk(int paramInt)
  {
    AppMethodBeat.i(98188);
    cl localcl = new cl().QD();
    localcl.dRw = paramInt;
    localcl.jf(this.xoO).aBj();
    AppMethodBeat.o(98188);
  }
  
  public final View a(View paramView1, View paramView2, DynamicGridView paramDynamicGridView, View paramView3)
  {
    AppMethodBeat.i(98179);
    boolean bool;
    if (this.xqB == null)
    {
      MMActivity localMMActivity = this.imP;
      ArrayList localArrayList = this.xqA.xqL;
      ak.1 local1 = new ak.1(this);
      ak.2 local2 = new ak.2(this);
      if (!this.xqF)
      {
        bool = true;
        this.xqB = new com.tencent.mm.plugin.sns.ui.previewimageview.e(paramView1, paramView2, paramView3, localMMActivity, localArrayList, paramDynamicGridView, local1, local2, bool);
      }
    }
    for (;;)
    {
      paramView1 = this.xqB.getView();
      AppMethodBeat.o(98179);
      return paramView1;
      bool = false;
      break;
      this.xqB.setList$22875ea3(this.xqA.xqL);
    }
  }
  
  final void a(ba paramba)
  {
    AppMethodBeat.i(98182);
    int i = paramba.commit();
    if (this.xmf != null)
    {
      this.xmf.oG(i);
      com.tencent.mm.plugin.sns.k.h.wRM.c(this.xmf);
    }
    if ((this.xqA != null) && (this.xqA.xqL != null) && (u.dyB())) {
      com.tencent.mm.plugin.report.service.h.vKh.f(12834, new Object[] { Integer.valueOf(this.xqA.xqL.size()) });
    }
    paramba = new Intent();
    paramba.putExtra("sns_local_id", i);
    this.imP.setResult(-1, paramba);
    this.imP.finish();
    AppMethodBeat.o(98182);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98183);
    paramLinkedList = new LinkedList();
    paramString2 = this.xqA.xqL.iterator();
    int i = 0;
    Object localObject1;
    Object localObject2;
    label109:
    Object localObject3;
    if (paramString2.hasNext())
    {
      localObject1 = (String)paramString2.next();
      localObject2 = new p((String)localObject1, 2);
      ((p)localObject2).type = 2;
      ((p)localObject2).wBm = paramInt1;
      int j;
      if (i == 0)
      {
        ((p)localObject2).wBl = paramInt2;
        if (parami != null)
        {
          ((p)localObject2).wBn = parami.token;
          ((p)localObject2).wBo = parami.DNx;
        }
        localObject3 = this.xqA;
        if (!((ak.b)localObject3).xqN.containsKey(localObject1)) {
          break label248;
        }
        j = ((Integer)((ak.b)localObject3).xqN.get(localObject1)).intValue();
        label150:
        ((p)localObject2).wBk = j;
        ((p)localObject2).desc = paramString1;
        localObject3 = this.xqA;
        if ((bt.isNullOrNil((String)localObject1)) || (!((ak.b)localObject3).xqM.containsKey(localObject1))) {
          break label254;
        }
      }
      label248:
      label254:
      for (boolean bool = ((Boolean)((ak.b)localObject3).xqM.get(localObject1)).booleanValue();; bool = false)
      {
        ((p)localObject2).wBq = bool;
        paramLinkedList.add(localObject2);
        i += 1;
        break;
        ((p)localObject2).wBl = 0;
        break label109;
        j = 0;
        break label150;
      }
    }
    paramString2 = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      localObject1 = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject2 = (String)paramList1.next();
        if (!((List)localObject1).contains(localObject2))
        {
          localObject3 = new cwk();
          ((cwk)localObject3).mAQ = ((String)localObject2);
          paramString2.add(localObject3);
        }
      }
    }
    paramList1 = new ba(1);
    paramPInt.value = paramList1.aTB;
    if (parami != null) {
      paramList1.iI(parami.token, parami.DNx);
    }
    if (paramInt3 > a.wzN) {
      paramList1.Ms(3);
    }
    paramList1.aoS(paramString1).a(parambmn).aM(paramString2).Mu(paramInt1).Mv(paramInt2);
    if (paramBoolean) {
      paramList1.Mx(1);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.appId)) {
        paramList1.aoY(this.appId);
      }
      if (!bt.isNullOrNil(this.appName)) {
        paramList1.aoZ(bt.by(this.appName, ""));
      }
      paramList1.Mw(this.xlZ);
      if (this.xnv) {
        paramList1.Mw(5);
      }
      if ((this.xnw) && (this.xnx != null))
      {
        paramList1.aoT(this.xnx.mediaTagName);
        paramList1.au(this.appId, this.xnx.messageExt, this.xnx.messageAction);
      }
      paramList1.g(null, null, null, paramInt4, paramInt5);
      paramList1.bR(this.wLo, this.xmg);
      paramList1.fq(paramList2);
      paramList1.setSessionId(this.mSessionId);
      if ((parambmn != null) && (parambmn.score != 0))
      {
        paramInt1 = parambmn.score;
        parami = parambmn.DlE;
        paramList1.wLi.DNF = new cuk();
        paramList1.wLi.DNF.Emm = paramInt1;
        paramList1.wLi.DNF.Emk = parami;
      }
      ad.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.xqE) });
      com.tencent.mm.plugin.report.service.h.vKh.f(11602, new Object[] { Integer.valueOf(this.xqE), Integer.valueOf(paramLinkedList.size()) });
      parami = paramLinkedList.iterator();
      while (parami.hasNext())
      {
        paramString1 = (p)parami.next();
        ad.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[] { paramString1.path, Long.valueOf(com.tencent.mm.vfs.i.aMN(paramString1.path)) });
      }
      paramList1.Mx(0);
    }
    paramString1 = paramLinkedList.iterator();
    if (paramString1.hasNext())
    {
      parambmn = ((p)paramString1.next()).path;
      parami = (cvq)this.xqD.get(parambmn);
      if (parami != null) {
        break label1356;
      }
      parami = new cvq();
    }
    label957:
    label1356:
    for (;;)
    {
      if ((this.xqG != null) && ((this.xqG.COJ != 0.0F) || (this.xqG.COI != 0.0F)))
      {
        parami.Enp = this.xqG.COJ;
        parami.Enq = this.xqG.COI;
        parami.xoi = this.xqG.xoi;
        parami.bQL = this.xqG.bQL;
        parambmn = (Exif.a)this.xqC.get(parambmn);
        if ((parambmn == null) || ((parambmn.latitude == 0.0D) && (parambmn.longitude == 0.0D))) {
          break label1263;
        }
        parami.Enn = ((float)parambmn.latitude);
      }
      for (parami.Eno = ((float)parambmn.longitude);; parami.Eno = -1000.0F)
      {
        parambmn = new StringBuffer();
        parambmn.append("||index: " + paramList1.wLi.DNA.size());
        parambmn.append("||item poi lat " + parami.Enp + " " + parami.Enq);
        parambmn.append("||item pic lat " + parami.Enn + " " + parami.Eno);
        parambmn.append("||item exitime:" + parami.Ens + " filetime: " + parami.Ent);
        parambmn.append("||item source: " + parami.Enr);
        ad.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + parambmn.toString());
        paramList1.wLi.DNA.add(parami);
        break;
        parami.Enp = -1000.0F;
        parami.Enq = -1000.0F;
        break label957;
        label1263:
        parami.Enn = -1000.0F;
      }
      if (paramLinkedList.size() <= 1)
      {
        a(paramList1, paramLinkedList);
        a(paramList1);
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.afE().ax(new ak.4(this));
        AppMethodBeat.o(98183);
        return true;
        new a(paramList1, paramLinkedList).v(new String[] { "" });
      }
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(98174);
    this.xmf = d.w(this.imP.getIntent());
    this.xoP = this.imP.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.appId = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.xnv = this.imP.getIntent().getBooleanExtra("KThrid_app", false);
    this.xqF = this.imP.getIntent().getBooleanExtra("KBlockAdd", false);
    this.xnw = this.imP.getIntent().getBooleanExtra("KSnsAction", false);
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = bt.by(this.imP.getIntent().getStringExtra("reportSessionId"), "");
    this.xoO = this.imP.getIntent().getStringExtra("KSessionID");
    Object localObject1 = this.imP.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (localObject1 != null) {
      this.xnx = new SendMessageToWX.Req((Bundle)localObject1).message;
    }
    Object localObject3 = this.imP.getIntent().getStringExtra("sns_kemdia_path");
    Object localObject4 = this.imP.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = localObject4;
      if (this.xnx != null)
      {
        localObject1 = localObject4;
        if (this.xnx.mediaObject != null)
        {
          localObject1 = localObject4;
          if ((this.xnx.mediaObject instanceof WXImageObject)) {
            localObject1 = ((WXImageObject)this.xnx.mediaObject).imageData;
          }
        }
      }
    }
    if ((bt.isNullOrNil((String)localObject3)) && (!bt.cw((byte[])localObject1)))
    {
      localObject3 = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
      com.tencent.mm.vfs.i.deleteFile((String)localObject3);
      com.tencent.mm.vfs.i.f((String)localObject3, (byte[])localObject1, localObject1.length);
    }
    label497:
    label756:
    Object localObject2;
    for (localObject1 = localObject3;; localObject2 = localObject3)
    {
      int j = this.imP.getIntent().getIntExtra("KFilterId", 0);
      boolean bool;
      if (paramBundle == null)
      {
        localObject3 = null;
        ah(paramBundle);
        bool = ah(this.imP.getIntent().getExtras());
        this.xqE = 0;
        if (bt.isNullOrNil((String)localObject3)) {
          break label538;
        }
        this.xqA.aqw((String)localObject3);
      }
      for (;;)
      {
        if (this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
        {
          this.wLo = 1;
          this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
          AppMethodBeat.o(98174);
          return;
          localObject3 = paramBundle.getString("sns_kemdia_path_list");
          break;
          label538:
          paramBundle = this.imP.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
          if (!bt.gL(paramBundle))
          {
            paramBundle = paramBundle.iterator();
            label564:
            if (paramBundle.hasNext())
            {
              localObject1 = (String)paramBundle.next();
              ad.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(localObject1)));
              this.xqA.q((String)localObject1, j, false);
              if (!bool)
              {
                localObject3 = Exif.fromFile((String)localObject1).getLocation();
                if (localObject3 != null) {
                  this.xqC.put(localObject1, localObject3);
                }
              }
            }
            for (;;)
            {
              try
              {
                localObject3 = new com.tencent.mm.vfs.e((String)localObject1);
                localObject4 = new cvq();
                if (!this.xoP) {
                  break label756;
                }
                i = 1;
                ((cvq)localObject4).Enr = i;
                ((cvq)localObject4).Ent = (((com.tencent.mm.vfs.e)localObject3).lastModified() / 1000L);
                ((cvq)localObject4).Ens = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
                this.xqD.put(localObject1, localObject4);
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
              }
              break label564;
              break;
              i = 2;
            }
          }
          if (!bt.isNullOrNil(localException))
          {
            paramBundle = af.getAccSnsTmpPath() + "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(localException.getBytes());
            com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(paramBundle));
            com.tencent.mm.vfs.i.lC(localException, paramBundle);
            if (j != -1) {
              break label992;
            }
          }
        }
      }
      label979:
      label992:
      for (int i = 0;; i = j)
      {
        this.xqA.q(paramBundle, i, this.xoP);
        if (!bool)
        {
          localObject3 = Exif.fromFile(localException).getLocation();
          if (localObject3 != null) {
            this.xqC.put(paramBundle, localObject3);
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = new com.tencent.mm.vfs.e(localException);
            localObject4 = new cvq();
            if (!this.xoP) {
              break label979;
            }
            i = 1;
            ((cvq)localObject4).Enr = i;
            ((cvq)localObject4).Ent = (((com.tencent.mm.vfs.e)localObject3).lastModified() / 1000L);
            ((cvq)localObject4).Ens = Exif.fromFile(localException).getUxtimeDatatimeOriginal();
            this.xqD.put(paramBundle, localObject4);
          }
          catch (Exception paramBundle)
          {
            ad.e("MicroMsg.PicWidget", "get report info error " + paramBundle.getMessage());
          }
          break;
          i = 2;
        }
        this.wLo = 0;
        break label497;
      }
    }
  }
  
  public final void ag(Bundle paramBundle)
  {
    AppMethodBeat.i(98177);
    paramBundle.putString("sns_kemdia_path_list", this.xqA.toString());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.xqC.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(String.format("%s\n%f\n%f", new Object[] { localEntry.getKey(), Double.valueOf(((Exif.a)localEntry.getValue()).latitude), Double.valueOf(((Exif.a)localEntry.getValue()).longitude) }));
    }
    paramBundle.putStringArrayList("sns_media_latlong_list", localArrayList);
    paramBundle.getString("contentdesc");
    AppMethodBeat.o(98177);
  }
  
  public final boolean b(List<String> paramList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98185);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.i("MicroMsg.PicWidget", "no image selected");
      AppMethodBeat.o(98185);
      return true;
    }
    if (this.xqA.xqL.size() >= 9)
    {
      AppMethodBeat.o(98185);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (String)paramList.next();
      if (com.tencent.mm.vfs.i.eK((String)localObject1))
      {
        String str = "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append((String)localObject1).append(System.currentTimeMillis()).toString().getBytes());
        u.ax(af.getAccSnsTmpPath(), (String)localObject1, str);
        Object localObject2 = b.vtE;
        b.alR((String)localObject1);
        ad.d("MicroMsg.PicWidget", "newPath " + af.getAccSnsTmpPath() + str);
        this.xqA.q(af.getAccSnsTmpPath() + str, paramInt, paramBoolean);
        ((com.tencent.mm.plugin.sns.ui.previewimageview.e)this.xqB).NR(this.xqA.xqL.size());
        this.xqB.setList$22875ea3(this.xqA.xqL);
        this.imP.getIntent().putExtra("sns_kemdia_path_list", this.xqA.xqL);
        for (;;)
        {
          try
          {
            localObject2 = new com.tencent.mm.vfs.e((String)localObject1);
            cvq localcvq = new cvq();
            if (!paramBoolean) {
              continue;
            }
            i = 1;
            localcvq.Enr = i;
            localcvq.Ent = (((com.tencent.mm.vfs.e)localObject2).lastModified() / 1000L);
            localcvq.Ens = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
            this.xqD.put(af.getAccSnsTmpPath() + str, localcvq);
          }
          catch (Exception localException)
          {
            int i;
            ad.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
            continue;
          }
          localObject1 = Exif.fromFile((String)localObject1).getLocation();
          if (localObject1 == null) {
            break;
          }
          this.xqC.put(af.getAccSnsTmpPath() + str, localObject1);
          break;
          i = 2;
        }
      }
    }
    AppMethodBeat.o(98185);
    return true;
  }
  
  public final Map<String, Boolean> dAa()
  {
    AppMethodBeat.i(98189);
    Object localObject = new HashMap();
    if ((this.xqA != null) && (!this.xqA.xqL.isEmpty()))
    {
      Iterator localIterator = this.xqA.xqL.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((Boolean)this.xqA.xqM.get(str) != null) {
          ((Map)localObject).put(str, this.xqA.xqM.get(str));
        }
      }
    }
    if (this.xqA != null)
    {
      localObject = this.xqA.xqM;
      AppMethodBeat.o(98189);
      return localObject;
    }
    AppMethodBeat.o(98189);
    return null;
  }
  
  public final boolean dyU()
  {
    AppMethodBeat.i(98178);
    if (this.xqA != null)
    {
      ak.b localb = this.xqA;
      if ((localb.xqL != null) && (localb.xqL.size() > 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(98178);
        return true;
      }
    }
    AppMethodBeat.o(98178);
    return false;
  }
  
  public final View dyV()
  {
    AppMethodBeat.i(98180);
    this.xqB = new PreviewImageView(this.imP);
    if (this.xqF) {
      this.xqB.setIsShowAddImage(false);
    }
    this.xqB.setImageClick(new ak.3(this));
    this.xqB.setList$22875ea3(this.xqA.xqL);
    View localView = this.xqB.getView();
    AppMethodBeat.o(98180);
    return localView;
  }
  
  public final boolean dyW()
  {
    AppMethodBeat.i(98187);
    if (this.xqB != null) {
      this.xqB.clean();
    }
    this.xqC.clear();
    this.xqD.clear();
    AppMethodBeat.o(98187);
    return false;
  }
  
  public final int dzY()
  {
    AppMethodBeat.i(98175);
    int i = this.xqA.xqL.size();
    AppMethodBeat.o(98175);
    return i;
  }
  
  protected final boolean dzZ()
  {
    AppMethodBeat.i(98184);
    com.tencent.mm.kernel.g.afC();
    if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      t.g(this.imP, null);
      AppMethodBeat.o(98184);
      return false;
    }
    if (this.xqA.xqL.size() >= 9)
    {
      com.tencent.mm.ui.base.h.j(this.imP, 2131764057, 2131755906);
      AppMethodBeat.o(98184);
      return false;
    }
    try
    {
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.imP, 1, false);
      locale.HrX = new ak.5(this);
      locale.HrY = new ak.6(this);
      locale.csG();
      label114:
      AppMethodBeat.o(98184);
      return true;
    }
    catch (Exception localException)
    {
      break label114;
    }
  }
  
  /* Error */
  public final boolean j(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 998
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+53 -> 60, 2:+61->68, 3:+163->170, 4:+1360->1367, 5:+53->60, 6:+53->60, 7:+1740->1747, 8:+53->60, 9:+485->492, 10:+53->60, 11:+1126->1133
    //   61: iconst_0
    //   62: <illegal opcode>
    //   63: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iconst_0
    //   67: ireturn
    //   68: ldc 144
    //   70: ldc_w 1000
    //   73: invokestatic 800	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_2
    //   77: ifnonnull +11 -> 88
    //   80: ldc_w 998
    //   83: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_0
    //   87: ireturn
    //   88: ldc 144
    //   90: ldc_w 1002
    //   93: invokestatic 800	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 276	android/content/Intent
    //   99: dup
    //   100: invokespecial 277	android/content/Intent:<init>	()V
    //   103: astore 4
    //   105: aload 4
    //   107: ldc_w 1004
    //   110: iconst_4
    //   111: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload 4
    //   117: ldc_w 1006
    //   120: iconst_1
    //   121: invokevirtual 1009	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   124: pop
    //   125: aload 4
    //   127: ldc_w 1011
    //   130: iconst_1
    //   131: invokevirtual 1009	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   134: pop
    //   135: getstatic 1015	com/tencent/mm/plugin/sns/d/a:hYt	Lcom/tencent/mm/pluginsdk/l;
    //   138: aload_0
    //   139: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   142: aload_2
    //   143: aload 4
    //   145: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   148: iconst_4
    //   149: new 1017	com/tencent/mm/plugin/sns/ui/ak$7
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 1018	com/tencent/mm/plugin/sns/ui/ak$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/ak;)V
    //   157: invokeinterface 1023 7 0
    //   162: ldc_w 998
    //   165: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_1
    //   169: ireturn
    //   170: ldc 144
    //   172: ldc_w 1025
    //   175: invokestatic 800	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   182: invokevirtual 1029	com/tencent/mm/ui/MMActivity:getApplicationContext	()Landroid/content/Context;
    //   185: aload_2
    //   186: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   189: invokestatic 1035	com/tencent/mm/pluginsdk/ui/tools/q:h	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_2
    //   193: aload_2
    //   194: ifnonnull +11 -> 205
    //   197: ldc_w 998
    //   200: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iconst_1
    //   204: ireturn
    //   205: new 276	android/content/Intent
    //   208: dup
    //   209: invokespecial 277	android/content/Intent:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: ldc_w 1004
    //   219: iconst_4
    //   220: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   223: pop
    //   224: aload 4
    //   226: ldc_w 1011
    //   229: iconst_1
    //   230: invokevirtual 1009	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   233: pop
    //   234: aload 4
    //   236: ldc_w 1006
    //   239: iconst_1
    //   240: invokevirtual 1009	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   243: pop
    //   244: aload 4
    //   246: ldc_w 1037
    //   249: aload_2
    //   250: invokevirtual 1040	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   253: pop
    //   254: new 573	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   261: aload_2
    //   262: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokestatic 745	java/lang/System:currentTimeMillis	()J
    //   268: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 749	java/lang/String:getBytes	()[B
    //   277: invokestatic 755	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   280: astore 5
    //   282: aload 4
    //   284: ldc_w 1042
    //   287: new 573	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   294: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   297: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 5
    //   302: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 1040	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   311: pop
    //   312: aload_2
    //   313: invokestatic 810	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   316: invokevirtual 814	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   319: astore 6
    //   321: aload 6
    //   323: ifnull +70 -> 393
    //   326: aload_0
    //   327: getfield 69	com/tencent/mm/plugin/sns/ui/ak:xqC	Ljava/util/Map;
    //   330: new 573	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   337: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   340: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 5
    //   345: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: aload 6
    //   353: invokeinterface 173 3 0
    //   358: pop
    //   359: ldc 144
    //   361: ldc_w 1044
    //   364: iconst_2
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload 6
    //   372: getfield 559	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   375: invokestatic 871	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: aload 6
    //   383: getfield 562	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   386: invokestatic 871	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   389: aastore
    //   390: invokestatic 1046	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: new 531	com/tencent/mm/protocal/protobuf/cvq
    //   396: dup
    //   397: invokespecial 532	com/tencent/mm/protocal/protobuf/cvq:<init>	()V
    //   400: astore 6
    //   402: aload 6
    //   404: iconst_1
    //   405: putfield 620	com/tencent/mm/protocal/protobuf/cvq:Enr	I
    //   408: aload 6
    //   410: invokestatic 745	java/lang/System:currentTimeMillis	()J
    //   413: putfield 615	com/tencent/mm/protocal/protobuf/cvq:Ent	J
    //   416: aload 6
    //   418: aload_2
    //   419: invokestatic 810	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   422: getfield 1049	com/tencent/mm/compatible/util/Exif:dateTime	Ljava/lang/String;
    //   425: invokestatic 1052	com/tencent/mm/sdk/platformtools/bt:aGi	(Ljava/lang/String;)J
    //   428: putfield 607	com/tencent/mm/protocal/protobuf/cvq:Ens	J
    //   431: aload_0
    //   432: getfield 71	com/tencent/mm/plugin/sns/ui/ak:xqD	Ljava/util/Map;
    //   435: new 573	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   442: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   445: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 5
    //   450: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: aload 6
    //   458: invokeinterface 173 3 0
    //   463: pop
    //   464: getstatic 1015	com/tencent/mm/plugin/sns/d/a:hYt	Lcom/tencent/mm/pluginsdk/l;
    //   467: aload_0
    //   468: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   471: aload 4
    //   473: iconst_4
    //   474: invokeinterface 1055 4 0
    //   479: aload_0
    //   480: iconst_1
    //   481: putfield 64	com/tencent/mm/plugin/sns/ui/ak:xoP	Z
    //   484: ldc_w 998
    //   487: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: iconst_1
    //   491: ireturn
    //   492: aload_2
    //   493: ldc_w 1057
    //   496: invokevirtual 704	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   499: astore 4
    //   501: aload 4
    //   503: ifnull +131 -> 634
    //   506: aload 4
    //   508: ldc_w 1059
    //   511: invokevirtual 1062	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   514: ifnull +120 -> 634
    //   517: aload 4
    //   519: ldc_w 1064
    //   522: invokevirtual 1062	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   525: ifnull +109 -> 634
    //   528: ldc 144
    //   530: ldc_w 1066
    //   533: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload_0
    //   537: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   540: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   543: invokevirtual 769	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   546: invokevirtual 1067	android/os/Bundle:clear	()V
    //   549: aload_0
    //   550: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   553: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   556: ldc_w 670
    //   559: iconst_0
    //   560: invokevirtual 1009	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   563: pop
    //   564: aload_0
    //   565: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   568: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   571: ldc_w 1069
    //   574: iconst_1
    //   575: invokevirtual 1009	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   578: pop
    //   579: aload_0
    //   580: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   583: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   586: ldc_w 1071
    //   589: bipush 14
    //   591: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   594: pop
    //   595: aload_0
    //   596: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   599: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   602: ldc_w 1057
    //   605: aload_2
    //   606: ldc_w 1057
    //   609: invokevirtual 704	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   612: invokevirtual 1074	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   615: pop
    //   616: aload_0
    //   617: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   620: checkcast 1076	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   623: invokevirtual 1079	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   626: ldc_w 998
    //   629: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   632: iconst_1
    //   633: ireturn
    //   634: aload_2
    //   635: ldc_w 1081
    //   638: invokevirtual 785	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   641: astore 4
    //   643: aload 4
    //   645: ifnull +11 -> 656
    //   648: aload 4
    //   650: invokevirtual 264	java/util/ArrayList:size	()I
    //   653: ifgt +16 -> 669
    //   656: aload_2
    //   657: ldc_w 1083
    //   660: invokevirtual 680	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokestatic 349	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   666: ifne +393 -> 1059
    //   669: aload 4
    //   671: ifnull +126 -> 797
    //   674: aload 4
    //   676: invokevirtual 264	java/util/ArrayList:size	()I
    //   679: ifle +118 -> 797
    //   682: aload 4
    //   684: iconst_0
    //   685: invokevirtual 1086	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   688: checkcast 136	java/lang/String
    //   691: astore 4
    //   693: aload_2
    //   694: ldc_w 1088
    //   697: invokevirtual 680	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   700: astore 6
    //   702: aload 6
    //   704: invokestatic 349	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   707: ifne +15 -> 722
    //   710: aload 6
    //   712: astore 5
    //   714: aload 6
    //   716: invokestatic 890	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   719: ifne +184 -> 903
    //   722: new 573	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   729: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   732: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 4
    //   737: invokestatic 1091	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
    //   740: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: astore 5
    //   748: new 1093	com/tencent/mm/compatible/h/d
    //   751: dup
    //   752: invokespecial 1094	com/tencent/mm/compatible/h/d:<init>	()V
    //   755: astore 6
    //   757: aload 6
    //   759: aload 4
    //   761: invokevirtual 1099	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   764: aload 6
    //   766: lconst_0
    //   767: invokevirtual 1103	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   770: astore 7
    //   772: aload 7
    //   774: ifnonnull +35 -> 809
    //   777: ldc 144
    //   779: ldc_w 1105
    //   782: invokestatic 152	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 6
    //   787: invokevirtual 1108	android/media/MediaMetadataRetriever:release	()V
    //   790: goto -730 -> 60
    //   793: astore_2
    //   794: goto -734 -> 60
    //   797: aload_2
    //   798: ldc_w 1083
    //   801: invokevirtual 680	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   804: astore 4
    //   806: goto -113 -> 693
    //   809: ldc 144
    //   811: ldc_w 1110
    //   814: iconst_2
    //   815: anewarray 4	java/lang/Object
    //   818: dup
    //   819: iconst_0
    //   820: aload 7
    //   822: invokevirtual 1115	android/graphics/Bitmap:getWidth	()I
    //   825: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: aastore
    //   829: dup
    //   830: iconst_1
    //   831: aload 7
    //   833: invokevirtual 1118	android/graphics/Bitmap:getHeight	()I
    //   836: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   839: aastore
    //   840: invokestatic 513	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   843: aload 7
    //   845: bipush 80
    //   847: getstatic 1124	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   850: aload 5
    //   852: iconst_1
    //   853: invokestatic 1129	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   856: pop
    //   857: aload 5
    //   859: invokestatic 1133	com/tencent/mm/sdk/platformtools/f:aFf	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   862: astore 7
    //   864: ldc 144
    //   866: ldc_w 1135
    //   869: iconst_2
    //   870: anewarray 4	java/lang/Object
    //   873: dup
    //   874: iconst_0
    //   875: aload 7
    //   877: getfield 1140	android/graphics/BitmapFactory$Options:outWidth	I
    //   880: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: aload 7
    //   888: getfield 1143	android/graphics/BitmapFactory$Options:outHeight	I
    //   891: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   894: aastore
    //   895: invokestatic 513	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   898: aload 6
    //   900: invokevirtual 1108	android/media/MediaMetadataRetriever:release	()V
    //   903: ldc 144
    //   905: ldc_w 1145
    //   908: iconst_4
    //   909: anewarray 4	java/lang/Object
    //   912: dup
    //   913: iconst_0
    //   914: aload 4
    //   916: aastore
    //   917: dup
    //   918: iconst_1
    //   919: aload 5
    //   921: aastore
    //   922: dup
    //   923: iconst_2
    //   924: aload 4
    //   926: invokestatic 524	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   929: invokestatic 529	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   932: aastore
    //   933: dup
    //   934: iconst_3
    //   935: aload 5
    //   937: invokestatic 524	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   940: invokestatic 529	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   943: aastore
    //   944: invokestatic 513	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: aload 4
    //   949: invokestatic 1091	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
    //   952: astore 6
    //   954: aload_0
    //   955: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   958: instanceof 1076
    //   961: ifeq +41 -> 1002
    //   964: aload_2
    //   965: ldc_w 1147
    //   968: invokevirtual 680	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   971: invokestatic 1152	com/tencent/mm/plugin/sns/data/q:anU	(Ljava/lang/String;)V
    //   974: aload_0
    //   975: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   978: checkcast 1076	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   981: aload 4
    //   983: aload 5
    //   985: aload 6
    //   987: aconst_null
    //   988: iconst_0
    //   989: invokevirtual 1155	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   992: aload_0
    //   993: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   996: checkcast 1076	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   999: invokevirtual 1079	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   1002: ldc_w 998
    //   1005: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1008: iconst_1
    //   1009: ireturn
    //   1010: astore 7
    //   1012: ldc 144
    //   1014: ldc_w 1157
    //   1017: iconst_1
    //   1018: anewarray 4	java/lang/Object
    //   1021: dup
    //   1022: iconst_0
    //   1023: aload 7
    //   1025: invokevirtual 830	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1028: aastore
    //   1029: invokestatic 1159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1032: aload 6
    //   1034: invokevirtual 1108	android/media/MediaMetadataRetriever:release	()V
    //   1037: goto -134 -> 903
    //   1040: astore 6
    //   1042: goto -139 -> 903
    //   1045: astore_2
    //   1046: aload 6
    //   1048: invokevirtual 1108	android/media/MediaMetadataRetriever:release	()V
    //   1051: ldc_w 998
    //   1054: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1057: aload_2
    //   1058: athrow
    //   1059: aload_2
    //   1060: ldc_w 1161
    //   1063: invokevirtual 785	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1066: astore 4
    //   1068: aload_2
    //   1069: ldc_w 1163
    //   1072: iconst_0
    //   1073: invokevirtual 694	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1076: istore_1
    //   1077: aload_2
    //   1078: ldc_w 1165
    //   1081: iconst_0
    //   1082: invokevirtual 674	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1085: istore_3
    //   1086: ldc_w 1167
    //   1089: invokestatic 1171	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1092: checkcast 1167	com/tencent/mm/plugin/expt/a/b
    //   1095: getstatic 1177	com/tencent/mm/plugin/expt/a/b$a:pqy	Lcom/tencent/mm/plugin/expt/a/b$a;
    //   1098: iconst_1
    //   1099: invokeinterface 1180 3 0
    //   1104: ifeq +12 -> 1116
    //   1107: getstatic 899	com/tencent/mm/plugin/recordvideo/e/b:vtE	Lcom/tencent/mm/plugin/recordvideo/e/b;
    //   1110: astore_2
    //   1111: aload 4
    //   1113: invokestatic 1184	com/tencent/mm/plugin/recordvideo/e/b:aj	(Ljava/util/ArrayList;)V
    //   1116: aload_0
    //   1117: aload 4
    //   1119: iload_1
    //   1120: iload_3
    //   1121: invokevirtual 1186	com/tencent/mm/plugin/sns/ui/ak:b	(Ljava/util/List;IZ)Z
    //   1124: istore_3
    //   1125: ldc_w 998
    //   1128: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1131: iload_3
    //   1132: ireturn
    //   1133: aload_2
    //   1134: ldc_w 1188
    //   1137: invokevirtual 1192	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1140: checkcast 1194	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   1143: astore 5
    //   1145: aload 5
    //   1147: ifnull -1087 -> 60
    //   1150: aload 5
    //   1152: getfield 1197	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAP	Z
    //   1155: ifeq +65 -> 1220
    //   1158: aload 5
    //   1160: getfield 1200	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAX	Ljava/lang/String;
    //   1163: astore_2
    //   1164: aload_2
    //   1165: invokestatic 349	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1168: ifne -1108 -> 60
    //   1171: ldc_w 1167
    //   1174: invokestatic 1171	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1177: checkcast 1167	com/tencent/mm/plugin/expt/a/b
    //   1180: getstatic 1177	com/tencent/mm/plugin/expt/a/b$a:pqy	Lcom/tencent/mm/plugin/expt/a/b$a;
    //   1183: iconst_1
    //   1184: invokeinterface 1180 3 0
    //   1189: ifeq +12 -> 1201
    //   1192: getstatic 899	com/tencent/mm/plugin/recordvideo/e/b:vtE	Lcom/tencent/mm/plugin/recordvideo/e/b;
    //   1195: astore 4
    //   1197: aload_2
    //   1198: invokestatic 1203	com/tencent/mm/plugin/recordvideo/e/b:alQ	(Ljava/lang/String;)V
    //   1201: aload_0
    //   1202: aload_2
    //   1203: invokestatic 1209	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   1206: iconst_0
    //   1207: iconst_1
    //   1208: invokevirtual 1186	com/tencent/mm/plugin/sns/ui/ak:b	(Ljava/util/List;IZ)Z
    //   1211: istore_3
    //   1212: ldc_w 998
    //   1215: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1218: iload_3
    //   1219: ireturn
    //   1220: aload 5
    //   1222: getfield 1212	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAR	Ljava/lang/String;
    //   1225: astore 6
    //   1227: aload 5
    //   1229: getfield 1215	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAS	Ljava/lang/String;
    //   1232: astore 7
    //   1234: aconst_null
    //   1235: astore 4
    //   1237: aload_0
    //   1238: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1241: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1244: ldc_w 1217
    //   1247: aload 5
    //   1249: getfield 1215	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAS	Ljava/lang/String;
    //   1252: invokevirtual 1040	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1255: pop
    //   1256: aload 5
    //   1258: getfield 1220	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAU	Ljava/lang/String;
    //   1261: invokestatic 349	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1264: ifne +69 -> 1333
    //   1267: aload 5
    //   1269: getfield 1220	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAU	Ljava/lang/String;
    //   1272: astore_2
    //   1273: aload 5
    //   1275: getfield 1224	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAW	Lcom/tencent/mm/protocal/protobuf/boj;
    //   1278: invokevirtual 1229	com/tencent/mm/protocal/protobuf/boj:toByteArray	()[B
    //   1281: astore 5
    //   1283: aload 5
    //   1285: astore 4
    //   1287: aload_0
    //   1288: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1291: instanceof 1076
    //   1294: ifeq +31 -> 1325
    //   1297: aload_0
    //   1298: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1301: checkcast 1076	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1304: aload 6
    //   1306: aload 7
    //   1308: aload_2
    //   1309: aload 4
    //   1311: iconst_1
    //   1312: invokevirtual 1155	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   1315: aload_0
    //   1316: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1319: checkcast 1076	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1322: invokevirtual 1079	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   1325: ldc_w 998
    //   1328: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1331: iconst_1
    //   1332: ireturn
    //   1333: aload 6
    //   1335: invokestatic 1091	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
    //   1338: astore_2
    //   1339: goto -66 -> 1273
    //   1342: astore 5
    //   1344: ldc 144
    //   1346: ldc_w 1231
    //   1349: iconst_1
    //   1350: anewarray 4	java/lang/Object
    //   1353: dup
    //   1354: iconst_0
    //   1355: aload 5
    //   1357: invokevirtual 830	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1360: aastore
    //   1361: invokestatic 513	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1364: goto -77 -> 1287
    //   1367: ldc 144
    //   1369: ldc_w 1233
    //   1372: invokestatic 800	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload_2
    //   1376: ifnonnull +11 -> 1387
    //   1379: ldc_w 998
    //   1382: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1385: iconst_1
    //   1386: ireturn
    //   1387: aload_2
    //   1388: ldc_w 1042
    //   1391: invokevirtual 680	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1394: astore 4
    //   1396: ldc 144
    //   1398: ldc_w 1235
    //   1401: aload 4
    //   1403: invokestatic 794	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1406: invokevirtual 797	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1409: invokestatic 800	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1412: aload 4
    //   1414: ifnonnull +11 -> 1425
    //   1417: ldc_w 998
    //   1420: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1423: iconst_1
    //   1424: ireturn
    //   1425: aload 4
    //   1427: invokestatic 890	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   1430: ifne +11 -> 1441
    //   1433: ldc_w 998
    //   1436: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1439: iconst_1
    //   1440: ireturn
    //   1441: aload_0
    //   1442: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1445: getfield 206	com/tencent/mm/plugin/sns/ui/ak$b:xqL	Ljava/util/ArrayList;
    //   1448: invokevirtual 264	java/util/ArrayList:size	()I
    //   1451: bipush 9
    //   1453: if_icmplt +11 -> 1464
    //   1456: ldc_w 998
    //   1459: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1462: iconst_1
    //   1463: ireturn
    //   1464: aload_2
    //   1465: ldc_w 1163
    //   1468: iconst_0
    //   1469: invokevirtual 694	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1472: istore_1
    //   1473: new 573	java/lang/StringBuilder
    //   1476: dup
    //   1477: ldc_w 832
    //   1480: invokespecial 577	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1483: new 573	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   1490: aload 4
    //   1492: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokestatic 745	java/lang/System:currentTimeMillis	()J
    //   1498: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1501: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: invokevirtual 749	java/lang/String:getBytes	()[B
    //   1507: invokestatic 755	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   1510: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: astore_2
    //   1517: ldc 144
    //   1519: new 573	java/lang/StringBuilder
    //   1522: dup
    //   1523: ldc_w 1237
    //   1526: invokespecial 577	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1529: aload 4
    //   1531: invokestatic 524	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   1534: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1537: ldc_w 597
    //   1540: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload 4
    //   1545: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload 4
    //   1556: new 573	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   1563: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   1566: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload_2
    //   1570: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokestatic 842	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   1579: pop2
    //   1580: aload_0
    //   1581: getfield 69	com/tencent/mm/plugin/sns/ui/ak:xqC	Ljava/util/Map;
    //   1584: aload 4
    //   1586: invokeinterface 332 2 0
    //   1591: ifeq +44 -> 1635
    //   1594: aload_0
    //   1595: getfield 69	com/tencent/mm/plugin/sns/ui/ak:xqC	Ljava/util/Map;
    //   1598: new 573	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   1605: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   1608: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload_2
    //   1612: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: aload_0
    //   1619: getfield 69	com/tencent/mm/plugin/sns/ui/ak:xqC	Ljava/util/Map;
    //   1622: aload 4
    //   1624: invokeinterface 336 2 0
    //   1629: invokeinterface 173 3 0
    //   1634: pop
    //   1635: new 573	java/lang/StringBuilder
    //   1638: dup
    //   1639: invokespecial 734	java/lang/StringBuilder:<init>	()V
    //   1642: invokestatic 739	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   1645: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: aload_2
    //   1649: invokevirtual 600	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: astore_2
    //   1656: ldc 144
    //   1658: ldc_w 791
    //   1661: aload_2
    //   1662: invokestatic 794	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1665: invokevirtual 797	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1668: invokestatic 800	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1671: aload_0
    //   1672: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1675: aload_2
    //   1676: iload_1
    //   1677: iconst_0
    //   1678: invokevirtual 804	com/tencent/mm/plugin/sns/ui/ak$b:q	(Ljava/lang/String;IZ)Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1681: pop
    //   1682: aload_0
    //   1683: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1686: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1689: ldc_w 779
    //   1692: aload_0
    //   1693: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1696: getfield 206	com/tencent/mm/plugin/sns/ui/ak$b:xqL	Ljava/util/ArrayList;
    //   1699: invokevirtual 908	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1702: pop
    //   1703: aload_0
    //   1704: getfield 202	com/tencent/mm/plugin/sns/ui/ak:xqB	Lcom/tencent/mm/plugin/sns/ui/x;
    //   1707: checkcast 214	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1710: aload_0
    //   1711: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1714: getfield 206	com/tencent/mm/plugin/sns/ui/ak$b:xqL	Ljava/util/ArrayList;
    //   1717: invokevirtual 264	java/util/ArrayList:size	()I
    //   1720: invokevirtual 905	com/tencent/mm/plugin/sns/ui/previewimageview/e:NR	(I)V
    //   1723: aload_0
    //   1724: getfield 202	com/tencent/mm/plugin/sns/ui/ak:xqB	Lcom/tencent/mm/plugin/sns/ui/x;
    //   1727: aload_0
    //   1728: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1731: getfield 206	com/tencent/mm/plugin/sns/ui/ak$b:xqL	Ljava/util/ArrayList;
    //   1734: invokeinterface 226 2 0
    //   1739: ldc_w 998
    //   1742: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1745: iconst_1
    //   1746: ireturn
    //   1747: aload_2
    //   1748: ifnonnull +11 -> 1759
    //   1751: ldc_w 998
    //   1754: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1757: iconst_1
    //   1758: ireturn
    //   1759: aload_0
    //   1760: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1763: aload_2
    //   1764: ldc_w 1239
    //   1767: invokevirtual 785	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1770: invokevirtual 1242	com/tencent/mm/plugin/sns/ui/ak$b:ao	(Ljava/util/ArrayList;)V
    //   1773: aload_0
    //   1774: getfield 91	com/tencent/mm/plugin/sns/ui/ak:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1777: invokevirtual 664	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1780: ldc_w 779
    //   1783: aload_0
    //   1784: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1787: getfield 206	com/tencent/mm/plugin/sns/ui/ak$b:xqL	Ljava/util/ArrayList;
    //   1790: invokevirtual 908	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1793: pop
    //   1794: aload_0
    //   1795: getfield 202	com/tencent/mm/plugin/sns/ui/ak:xqB	Lcom/tencent/mm/plugin/sns/ui/x;
    //   1798: checkcast 214	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1801: aload_0
    //   1802: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1805: getfield 206	com/tencent/mm/plugin/sns/ui/ak$b:xqL	Ljava/util/ArrayList;
    //   1808: invokevirtual 264	java/util/ArrayList:size	()I
    //   1811: invokevirtual 905	com/tencent/mm/plugin/sns/ui/previewimageview/e:NR	(I)V
    //   1814: aload_0
    //   1815: getfield 202	com/tencent/mm/plugin/sns/ui/ak:xqB	Lcom/tencent/mm/plugin/sns/ui/x;
    //   1818: aload_0
    //   1819: getfield 62	com/tencent/mm/plugin/sns/ui/ak:xqA	Lcom/tencent/mm/plugin/sns/ui/ak$b;
    //   1822: getfield 206	com/tencent/mm/plugin/sns/ui/ak$b:xqL	Ljava/util/ArrayList;
    //   1825: invokeinterface 226 2 0
    //   1830: aload_0
    //   1831: aload_2
    //   1832: ldc_w 1244
    //   1835: iconst_0
    //   1836: invokevirtual 694	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1839: putfield 73	com/tencent/mm/plugin/sns/ui/ak:xqE	I
    //   1842: ldc_w 998
    //   1845: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1848: iconst_1
    //   1849: ireturn
    //   1850: astore 6
    //   1852: goto -949 -> 903
    //   1855: astore 4
    //   1857: goto -806 -> 1051
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1860	0	this	ak
    //   0	1860	1	paramInt	int
    //   0	1860	2	paramIntent	Intent
    //   1085	134	3	bool	boolean
    //   103	1520	4	localObject1	Object
    //   1855	1	4	localException1	Exception
    //   280	1004	5	localObject2	Object
    //   1342	14	5	localException2	Exception
    //   319	714	6	localObject3	Object
    //   1040	7	6	localException3	Exception
    //   1225	109	6	str1	String
    //   1850	1	6	localException4	Exception
    //   770	117	7	localObject4	Object
    //   1010	14	7	localException5	Exception
    //   1232	75	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   785	790	793	java/lang/Exception
    //   757	772	1010	java/lang/Exception
    //   777	785	1010	java/lang/Exception
    //   809	898	1010	java/lang/Exception
    //   1032	1037	1040	java/lang/Exception
    //   757	772	1045	finally
    //   777	785	1045	finally
    //   809	898	1045	finally
    //   1012	1032	1045	finally
    //   1273	1283	1342	java/lang/Exception
    //   898	903	1850	java/lang/Exception
    //   1046	1051	1855	java/lang/Exception
  }
  
  final class a
    extends com.tencent.mm.plugin.sns.model.g<String, Integer, Boolean>
  {
    private ProgressDialog fpP;
    private ba xpc;
    private List<p> xqI;
    
    public a(List<p> paramList)
    {
      AppMethodBeat.i(98164);
      this.fpP = null;
      this.xpc = paramList;
      Object localObject;
      this.xqI = localObject;
      paramList = ak.this.imP;
      ak.this.imP.getString(2131755906);
      this.fpP = com.tencent.mm.ui.base.h.b(paramList, ak.this.imP.getString(2131755805), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      AppMethodBeat.o(98164);
    }
    
    public final ExecutorService dnm()
    {
      AppMethodBeat.i(179157);
      ExecutorService localExecutorService = af.dth();
      AppMethodBeat.o(179157);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */