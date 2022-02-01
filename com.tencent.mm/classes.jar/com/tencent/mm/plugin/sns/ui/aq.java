package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.g.b.a.ii;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.c.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class aq
  implements ad
{
  private int DPi;
  private int EpG;
  private k EpM;
  private String EpN;
  private boolean Ero;
  private boolean Erp;
  private WXMediaMessage Erq;
  private String EsT;
  private boolean EsU;
  b EuF;
  z EuG;
  Map<String, Exif.a> EuH;
  private Map<String, eas> EuI;
  private int EuJ;
  private boolean EuK;
  cjy EuL;
  private String appId;
  private String appName;
  MMActivity gte;
  private String mSessionId;
  
  public aq(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98173);
    this.EuF = new b();
    this.EsU = false;
    this.EuH = new HashMap();
    this.EuI = new HashMap();
    this.EuJ = 0;
    this.Ero = false;
    this.EuK = false;
    this.Erp = false;
    this.Erq = null;
    this.EpM = null;
    this.DPi = 1;
    this.EpN = "";
    this.gte = paramMMActivity;
    AppMethodBeat.o(98173);
  }
  
  private static bf a(bf parambf, List<q> paramList)
  {
    AppMethodBeat.i(98181);
    parambf.gS(paramList);
    AppMethodBeat.o(98181);
    return parambf;
  }
  
  private boolean aE(Bundle paramBundle)
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
        Log.e("MicroMsg.PicWidget", "invalid params");
        AppMethodBeat.o(98176);
        return true;
      }
      try
      {
        this.EuH.put(arrayOfString[0].trim(), new Exif.a(Util.getDouble(arrayOfString[1], 0.0D), Util.getDouble(arrayOfString[2], 0.0D), 0.0D));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e("MicroMsg.PicWidget", localNumberFormatException.toString());
      }
    }
    AppMethodBeat.o(98176);
    return true;
  }
  
  final void Zy(int paramInt)
  {
    AppMethodBeat.i(98188);
    ii localii = new ii().ahh();
    localii.eOC = paramInt;
    localii.wg(this.EsT).bfK();
    AppMethodBeat.o(98188);
  }
  
  public final View a(View paramView1, View paramView2, DynamicGridView paramDynamicGridView, View paramView3)
  {
    AppMethodBeat.i(98179);
    boolean bool;
    if (this.EuG == null)
    {
      MMActivity localMMActivity = this.gte;
      ArrayList localArrayList = this.EuF.EuQ;
      z.a local1 = new z.a()
      {
        public final void Lc(int paramAnonymousInt)
        {
          AppMethodBeat.i(98155);
          Log.d("MicroMsg.PicWidget", "I click");
          if (paramAnonymousInt < 0)
          {
            aq.this.fgH();
            AppMethodBeat.o(98155);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.setClass(aq.this.gte, SnsUploadBrowseUI.class);
          localIntent.putExtra("sns_gallery_position", paramAnonymousInt);
          localIntent.putExtra("sns_gallery_temp_paths", aq.this.EuF.EuQ);
          localIntent.putExtra("key_from_scene", 7);
          aq.this.gte.startActivityForResult(localIntent, 7);
          AppMethodBeat.o(98155);
        }
      };
      c.a local2 = new c.a()
      {
        public final void iK(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(98156);
          aq.b localb = aq.this.EuF;
          String str;
          if ((paramAnonymousInt1 != paramAnonymousInt2) && (localb.EuQ.size() > paramAnonymousInt1))
          {
            str = (String)localb.EuQ.remove(paramAnonymousInt1);
            if (paramAnonymousInt2 >= localb.EuQ.size()) {
              break label95;
            }
            localb.EuQ.add(paramAnonymousInt2, str);
          }
          for (;;)
          {
            aq.this.gte.getIntent().putExtra("sns_kemdia_path_list", aq.this.EuF.EuQ);
            AppMethodBeat.o(98156);
            return;
            label95:
            localb.EuQ.add(str);
          }
        }
        
        public final void removeItem(int paramAnonymousInt)
        {
          AppMethodBeat.i(98157);
          aq.b localb = aq.this.EuF;
          if (localb.EuQ.size() > paramAnonymousInt) {
            localb.EuQ.remove(paramAnonymousInt);
          }
          if ((aq.this.gte instanceof SnsUploadUI)) {
            ((SnsUploadUI)aq.this.gte).fjN();
          }
          aq.this.gte.getIntent().putExtra("sns_kemdia_path_list", aq.this.EuF.EuQ);
          aq.this.gte.getIntent().putExtra("sns_kemdia_path", "");
          ((com.tencent.mm.plugin.sns.ui.previewimageview.e)aq.this.EuG).aah(aq.this.EuF.EuQ.size());
          AppMethodBeat.o(98157);
        }
      };
      if (!this.EuK)
      {
        bool = true;
        this.EuG = new com.tencent.mm.plugin.sns.ui.previewimageview.e(paramView1, paramView2, paramView3, localMMActivity, localArrayList, paramDynamicGridView, local1, local2, bool);
      }
    }
    for (;;)
    {
      paramView1 = this.EuG.getView();
      AppMethodBeat.o(98179);
      return paramView1;
      bool = false;
      break;
      this.EuG.setList$22875ea3(this.EuF.EuQ);
    }
  }
  
  final void a(bf parambf)
  {
    AppMethodBeat.i(98182);
    int i = parambf.commit();
    if (this.EpM != null)
    {
      this.EpM.tQ(i);
      com.tencent.mm.plugin.sns.k.g.DVR.c(this.EpM);
    }
    if ((this.EuF != null) && (this.EuF.EuQ != null) && (com.tencent.mm.plugin.sns.storage.r.fff())) {
      com.tencent.mm.plugin.report.service.h.CyF.a(12834, new Object[] { Integer.valueOf(this.EuF.EuQ.size()) });
    }
    parambf = new Intent();
    parambf.putExtra("sns_local_id", i);
    this.gte.setResult(-1, parambf);
    this.gte.finish();
    aj.faK().eZn();
    AppMethodBeat.o(98182);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98183);
    paramLinkedList = new LinkedList();
    paramString2 = this.EuF.EuQ.iterator();
    int i = 0;
    Object localObject1;
    Object localObject2;
    label109:
    Object localObject3;
    if (paramString2.hasNext())
    {
      localObject1 = (String)paramString2.next();
      localObject2 = new q((String)localObject1, 2);
      ((q)localObject2).type = 2;
      ((q)localObject2).DEB = paramInt1;
      int j;
      if (i == 0)
      {
        ((q)localObject2).DEA = paramInt2;
        if (parami != null)
        {
          ((q)localObject2).DEC = parami.token;
          ((q)localObject2).DED = parami.Mte;
        }
        localObject3 = this.EuF;
        if (!((b)localObject3).EuS.containsKey(localObject1)) {
          break label248;
        }
        j = ((Integer)((b)localObject3).EuS.get(localObject1)).intValue();
        label150:
        ((q)localObject2).DEz = j;
        ((q)localObject2).desc = paramString1;
        localObject3 = this.EuF;
        if ((Util.isNullOrNil((String)localObject1)) || (!((b)localObject3).EuR.containsKey(localObject1))) {
          break label254;
        }
      }
      label248:
      label254:
      for (boolean bool = ((Boolean)((b)localObject3).EuR.get(localObject1)).booleanValue();; bool = false)
      {
        ((q)localObject2).DEF = bool;
        paramLinkedList.add(localObject2);
        i += 1;
        break;
        ((q)localObject2).DEA = 0;
        break label109;
        j = 0;
        break label150;
      }
    }
    paramString2 = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      localObject1 = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject2 = (String)paramList1.next();
        if (!((List)localObject1).contains(localObject2))
        {
          localObject3 = new ebm();
          ((ebm)localObject3).UserName = ((String)localObject2);
          paramString2.add(localObject3);
        }
      }
    }
    paramList1 = new bf(1, this.gte);
    paramPInt.value = paramList1.beK;
    if (parami != null) {
      paramList1.kl(parami.token, parami.Mte);
    }
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramList1.YF(3);
    }
    paramList1.aPw(paramString1).a(paramcjy).bq(paramString2).YI(paramInt1).YJ(paramInt2);
    if (paramBoolean) {
      paramList1.YL(1);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.appId)) {
        paramList1.aPC(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        paramList1.aPD(Util.nullAs(this.appName, ""));
      }
      paramList1.YK(this.EpG);
      if (this.Ero) {
        paramList1.YK(5);
      }
      if ((this.Erp) && (this.Erq != null))
      {
        paramList1.aPx(this.Erq.mediaTagName);
        paramList1.aO(this.appId, this.Erq.messageExt, this.Erq.messageAction);
      }
      paramList1.g(null, null, null, paramInt4, paramInt5);
      paramList1.ct(this.DPi, this.EpN);
      paramList1.gR(paramList2);
      paramList1.setSessionId(this.mSessionId);
      if ((paramcjy != null) && (paramcjy.score != 0))
      {
        paramInt1 = paramcjy.score;
        parami = paramcjy.LIb;
        paramList1.DPe.Mtm = new dzk();
        paramList1.DPe.Mtm.MZf = paramInt1;
        paramList1.DPe.Mtm.MZd = parami;
      }
      Log.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.EuJ) });
      com.tencent.mm.plugin.report.service.h.CyF.a(11602, new Object[] { Integer.valueOf(this.EuJ), Integer.valueOf(paramLinkedList.size()) });
      parami = paramLinkedList.iterator();
      while (parami.hasNext())
      {
        paramString1 = (q)parami.next();
        Log.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[] { paramString1.path, Long.valueOf(com.tencent.mm.vfs.s.boW(paramString1.path)) });
      }
      paramList1.YL(0);
    }
    paramString1 = paramLinkedList.iterator();
    if (paramString1.hasNext())
    {
      paramcjy = ((q)paramString1.next()).path;
      parami = (eas)this.EuI.get(paramcjy);
      if (parami != null) {
        break label1360;
      }
      parami = new eas();
    }
    label961:
    label1360:
    for (;;)
    {
      if ((this.EuL != null) && ((this.EuL.LbD != 0.0F) || (this.EuL.LbC != 0.0F)))
      {
        parami.Nak = this.EuL.LbD;
        parami.Nal = this.EuL.LbC;
        parami.Esd = this.EuL.Esd;
        parami.cjn = this.EuL.cjn;
        paramcjy = (Exif.a)this.EuH.get(paramcjy);
        if ((paramcjy == null) || ((paramcjy.latitude == 0.0D) && (paramcjy.longitude == 0.0D))) {
          break label1267;
        }
        parami.Nai = ((float)paramcjy.latitude);
      }
      for (parami.Naj = ((float)paramcjy.longitude);; parami.Naj = -1000.0F)
      {
        paramcjy = new StringBuffer();
        paramcjy.append("||index: " + paramList1.DPe.Mth.size());
        paramcjy.append("||item poi lat " + parami.Nak + " " + parami.Nal);
        paramcjy.append("||item pic lat " + parami.Nai + " " + parami.Naj);
        paramcjy.append("||item exitime:" + parami.Nan + " filetime: " + parami.Nao);
        paramcjy.append("||item source: " + parami.Nam);
        Log.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + paramcjy.toString());
        paramList1.DPe.Mth.add(parami);
        break;
        parami.Nak = -1000.0F;
        parami.Nal = -1000.0F;
        break label961;
        label1267:
        parami.Nai = -1000.0F;
      }
      if (paramLinkedList.size() <= 1)
      {
        a(paramList1, paramLinkedList);
        a(paramList1);
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98159);
            long l = System.currentTimeMillis();
            Iterator localIterator = aq.this.EuF.EuQ.iterator();
            Exif localExif;
            int i;
            label78:
            String str2;
            int k;
            int j;
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              localExif = Exif.fromFile(str1);
              if ((localExif.latitude >= 0.0D) && (localExif.longitude >= 0.0D))
              {
                i = 1;
                str2 = localExif.model;
                k = localExif.imageWidth;
                j = localExif.imageHeight;
                if ((k > 0) && (j > 0)) {
                  break label235;
                }
                BitmapFactory.Options localOptions = new BitmapFactory.Options();
                localOptions.inJustDecodeBounds = true;
                BitmapUtil.decodeFile(str1, localOptions);
                k = localOptions.outWidth;
                j = localOptions.outHeight;
              }
            }
            label235:
            for (;;)
            {
              int m = (int)localExif.getUxtimeDatatimeOriginal();
              com.tencent.mm.plugin.report.service.h.CyF.a(15523, new Object[] { Integer.valueOf(i), str2, Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) });
              break;
              i = 0;
              break label78;
              Log.d("MicroMsg.PicWidget", "report photo info cost " + (System.currentTimeMillis() - l));
              AppMethodBeat.o(98159);
              return;
            }
          }
        });
        AppMethodBeat.o(98183);
        return true;
        new a(paramList1, paramLinkedList).y(new String[] { "" });
      }
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(98174);
    this.EpM = k.w(this.gte.getIntent());
    this.EsU = this.gte.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
    this.EuK = this.gte.getIntent().getBooleanExtra("KBlockAdd", false);
    this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
    this.EsT = this.gte.getIntent().getStringExtra("KSessionID");
    Object localObject1 = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (localObject1 != null) {
      this.Erq = new SendMessageToWX.Req((Bundle)localObject1).message;
    }
    Object localObject3 = this.gte.getIntent().getStringExtra("sns_kemdia_path");
    Object localObject4 = this.gte.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = localObject4;
      if (this.Erq != null)
      {
        localObject1 = localObject4;
        if (this.Erq.mediaObject != null)
        {
          localObject1 = localObject4;
          if ((this.Erq.mediaObject instanceof WXImageObject)) {
            localObject1 = ((WXImageObject)this.Erq.mediaObject).imageData;
          }
        }
      }
    }
    if ((Util.isNullOrNil((String)localObject3)) && (!Util.isNullOrNil((byte[])localObject1)))
    {
      localObject3 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
      com.tencent.mm.vfs.s.deleteFile((String)localObject3);
      com.tencent.mm.vfs.s.f((String)localObject3, (byte[])localObject1, localObject1.length);
    }
    label497:
    label756:
    Object localObject2;
    for (localObject1 = localObject3;; localObject2 = localObject3)
    {
      int j = this.gte.getIntent().getIntExtra("KFilterId", 0);
      boolean bool;
      if (paramBundle == null)
      {
        localObject3 = null;
        aE(paramBundle);
        bool = aE(this.gte.getIntent().getExtras());
        this.EuJ = 0;
        if (Util.isNullOrNil((String)localObject3)) {
          break label538;
        }
        this.EuF.aQY((String)localObject3);
      }
      for (;;)
      {
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
        {
          this.DPi = 1;
          this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
          AppMethodBeat.o(98174);
          return;
          localObject3 = paramBundle.getString("sns_kemdia_path_list");
          break;
          label538:
          paramBundle = this.gte.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
          if (!Util.isNullOrNil(paramBundle))
          {
            paramBundle = paramBundle.iterator();
            label564:
            if (paramBundle.hasNext())
            {
              localObject1 = (String)paramBundle.next();
              Log.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(localObject1)));
              this.EuF.t((String)localObject1, j, false);
              if (!bool)
              {
                localObject3 = Exif.fromFile((String)localObject1).getLocation();
                if (localObject3 != null) {
                  this.EuH.put(localObject1, localObject3);
                }
              }
            }
            for (;;)
            {
              try
              {
                localObject3 = new com.tencent.mm.vfs.o((String)localObject1);
                localObject4 = new eas();
                if (!this.EsU) {
                  break label756;
                }
                i = 1;
                ((eas)localObject4).Nam = i;
                ((eas)localObject4).Nao = (((com.tencent.mm.vfs.o)localObject3).lastModified() / 1000L);
                ((eas)localObject4).Nan = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
                this.EuI.put(localObject1, localObject4);
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
              }
              break label564;
              break;
              i = 2;
            }
          }
          if (!Util.isNullOrNil(localException))
          {
            paramBundle = aj.getAccSnsTmpPath() + "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(localException.getBytes());
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(paramBundle));
            com.tencent.mm.vfs.s.nw(localException, paramBundle);
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
        this.EuF.t(paramBundle, i, this.EsU);
        if (!bool)
        {
          localObject3 = Exif.fromFile(localException).getLocation();
          if (localObject3 != null) {
            this.EuH.put(paramBundle, localObject3);
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = new com.tencent.mm.vfs.o(localException);
            localObject4 = new eas();
            if (!this.EsU) {
              break label979;
            }
            i = 1;
            ((eas)localObject4).Nam = i;
            ((eas)localObject4).Nao = (((com.tencent.mm.vfs.o)localObject3).lastModified() / 1000L);
            ((eas)localObject4).Nan = Exif.fromFile(localException).getUxtimeDatatimeOriginal();
            this.EuI.put(paramBundle, localObject4);
          }
          catch (Exception paramBundle)
          {
            Log.e("MicroMsg.PicWidget", "get report info error " + paramBundle.getMessage());
          }
          break;
          i = 2;
        }
        this.DPi = 0;
        break label497;
      }
    }
  }
  
  public final void aD(Bundle paramBundle)
  {
    AppMethodBeat.i(98177);
    paramBundle.putString("sns_kemdia_path_list", this.EuF.toString());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.EuH.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(String.format("%s\n%f\n%f", new Object[] { localEntry.getKey(), Double.valueOf(((Exif.a)localEntry.getValue()).latitude), Double.valueOf(((Exif.a)localEntry.getValue()).longitude) }));
    }
    paramBundle.putStringArrayList("sns_media_latlong_list", localArrayList);
    paramBundle.getString("contentdesc");
    AppMethodBeat.o(98177);
  }
  
  public final boolean c(List<String> paramList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98185);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.i("MicroMsg.PicWidget", "no image selected");
      AppMethodBeat.o(98185);
      return true;
    }
    if (this.EuF.EuQ.size() >= 9)
    {
      AppMethodBeat.o(98185);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (String)paramList.next();
      if (com.tencent.mm.vfs.s.YS((String)localObject1))
      {
        String str = "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append((String)localObject1).append(System.currentTimeMillis()).toString().getBytes());
        com.tencent.mm.plugin.sns.storage.r.aR(aj.getAccSnsTmpPath(), (String)localObject1, str);
        Object localObject2 = c.Cic;
        c.aLF((String)localObject1);
        Log.d("MicroMsg.PicWidget", "newPath " + aj.getAccSnsTmpPath() + str);
        this.EuF.t(aj.getAccSnsTmpPath() + str, paramInt, paramBoolean);
        ((com.tencent.mm.plugin.sns.ui.previewimageview.e)this.EuG).aah(this.EuF.EuQ.size());
        this.EuG.setList$22875ea3(this.EuF.EuQ);
        this.gte.getIntent().putExtra("sns_kemdia_path_list", this.EuF.EuQ);
        for (;;)
        {
          try
          {
            localObject2 = new com.tencent.mm.vfs.o((String)localObject1);
            eas localeas = new eas();
            if (!paramBoolean) {
              continue;
            }
            i = 1;
            localeas.Nam = i;
            localeas.Nao = (((com.tencent.mm.vfs.o)localObject2).lastModified() / 1000L);
            localeas.Nan = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
            this.EuI.put(aj.getAccSnsTmpPath() + str, localeas);
          }
          catch (Exception localException)
          {
            int i;
            Log.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
            continue;
          }
          localObject1 = Exif.fromFile((String)localObject1).getLocation();
          if (localObject1 == null) {
            break;
          }
          this.EuH.put(aj.getAccSnsTmpPath() + str, localObject1);
          break;
          i = 2;
        }
      }
    }
    AppMethodBeat.o(98185);
    return true;
  }
  
  public final boolean ffA()
  {
    AppMethodBeat.i(98178);
    if (this.EuF != null)
    {
      b localb = this.EuF;
      if ((localb.EuQ != null) && (localb.EuQ.size() > 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(98178);
        return true;
      }
    }
    AppMethodBeat.o(98178);
    return false;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(98180);
    this.EuG = new PreviewImageView(this.gte);
    if (this.EuK) {
      this.EuG.setIsShowAddImage(false);
    }
    this.EuG.setImageClick(new z.a()
    {
      public final void Lc(int paramAnonymousInt)
      {
        AppMethodBeat.i(98158);
        Log.d("MicroMsg.PicWidget", "I click");
        if (paramAnonymousInt < 0)
        {
          aq.this.fgH();
          AppMethodBeat.o(98158);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.setClass(aq.this.gte, SnsUploadBrowseUI.class);
        localIntent.putExtra("sns_gallery_position", paramAnonymousInt);
        localIntent.putExtra("key_from_scene", 7);
        localIntent.putExtra("sns_gallery_temp_paths", aq.this.EuF.EuQ);
        aq.this.gte.startActivityForResult(localIntent, 7);
        AppMethodBeat.o(98158);
      }
    });
    this.EuG.setList$22875ea3(this.EuF.EuQ);
    View localView = this.EuG.getView();
    AppMethodBeat.o(98180);
    return localView;
  }
  
  public final boolean ffC()
  {
    AppMethodBeat.i(203355);
    if ((this.EuF != null) && (!Util.isNullOrNil(this.EuF.EuQ)))
    {
      Iterator localIterator = this.EuF.EuQ.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (com.tencent.mm.vfs.s.YS((String)localIterator.next()));
    }
    for (boolean bool = false;; bool = true)
    {
      if (!bool) {
        com.tencent.mm.ui.base.h.n(this.gte, 2131766297, 2131755998);
      }
      AppMethodBeat.o(203355);
      return bool;
    }
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(98187);
    if (this.EuG != null) {
      this.EuG.clean();
    }
    this.EuH.clear();
    this.EuI.clear();
    AppMethodBeat.o(98187);
    return false;
  }
  
  public final int fgG()
  {
    AppMethodBeat.i(98175);
    int i = this.EuF.EuQ.size();
    AppMethodBeat.o(98175);
    return i;
  }
  
  protected final boolean fgH()
  {
    AppMethodBeat.i(98184);
    com.tencent.mm.kernel.g.aAi();
    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
    {
      u.g(this.gte, null);
      AppMethodBeat.o(98184);
      return false;
    }
    if (this.EuF.EuQ.size() >= 9)
    {
      com.tencent.mm.ui.base.h.n(this.gte, 2131766296, 2131755998);
      AppMethodBeat.o(98184);
      return false;
    }
    try
    {
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.gte, 1, false);
      locale.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(98160);
          if (!ac.jPB) {
            paramAnonymousm.d(0, aq.this.gte.getString(2131755822));
          }
          paramAnonymousm.d(1, aq.this.gte.getString(2131755831));
          AppMethodBeat.o(98160);
        }
      };
      locale.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(98161);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(98161);
            return;
          case 0: 
            paramAnonymousMenuItem = aq.this;
            paramAnonymousInt = 9 - paramAnonymousMenuItem.EuF.EuQ.size();
            if (paramAnonymousInt <= 0)
            {
              Log.e("MicroMsg.PicWidget", "has select the max image count");
              AppMethodBeat.o(98161);
              return;
            }
            Object localObject1 = new SightParams(2, 0);
            com.tencent.mm.modelvideo.o.bhi();
            Object localObject2 = d.aFj(com.tencent.mm.modelvideo.o.getAccVideoPath());
            localObject1 = RecordConfigProvider.a((String)localObject2, d.aFl((String)localObject2), ((SightParams)localObject1).irT, ((SightParams)localObject1).irT.duration * 1000, 2);
            if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rYO, false)) {
              ((RecordConfigProvider)localObject1).remuxType = 2;
            }
            localObject2 = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject2).sQn = 7;
            ((RecordConfigProvider)localObject1).BOE = ((VideoCaptureReportInfo)localObject2);
            localObject2 = new aq.8(paramAnonymousMenuItem);
            l = cl.aWz();
            if (paramAnonymousInt < 9)
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(l) });
              ((RecordConfigProvider)localObject1).BOs = Boolean.FALSE;
              CaptureDataManager.BOb.BOa = ((CaptureDataManager.b)localObject2);
              if (!((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rYM, true)) {
                break label350;
              }
              localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(paramAnonymousMenuItem.gte, 11, 2130772161, 2130772162, (RecordConfigProvider)localObject1);
            }
            for (;;)
            {
              paramAnonymousMenuItem.Zy(1);
              AppMethodBeat.o(98161);
              return;
              com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(l) });
              break;
              label350:
              if (paramAnonymousInt < 9)
              {
                localObject1 = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.s.a(paramAnonymousMenuItem.gte, 11, (Intent)localObject1, 2, 2);
              }
              else
              {
                localObject1 = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.s.a(paramAnonymousMenuItem.gte, 11, (Intent)localObject1, 2, 0);
              }
            }
          }
          int i = 9 - aq.this.EuF.EuQ.size();
          if (i <= 0)
          {
            Log.e("MicroMsg.PicWidget", "has select the max image count");
            AppMethodBeat.o(98161);
            return;
          }
          paramAnonymousMenuItem = aq.this.gte.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
          long l = cl.aWz();
          com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(l) });
          if (paramAnonymousMenuItem.equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.s.aY(aq.this.gte);
          }
          for (;;)
          {
            aq.this.Zy(2);
            break;
            if (i >= 9) {
              break label584;
            }
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("key_can_select_video_and_pic", true);
            com.tencent.mm.pluginsdk.ui.tools.s.a(aq.this.gte, 9, i, 4, 1, paramAnonymousMenuItem);
          }
          label584:
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.baZ().bbc().duration);
          boolean bool = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rZB, false);
          if ((com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ogd, 0) == 1) || (bool))
          {
            paramAnonymousInt = 1;
            label652:
            if (paramAnonymousInt != 0) {
              break label692;
            }
          }
          label692:
          for (bool = true;; bool = false)
          {
            paramAnonymousMenuItem.putExtra("key_can_select_video_and_pic", bool);
            com.tencent.mm.pluginsdk.ui.tools.s.a(aq.this.gte, 9, i, 4, 3, paramAnonymousMenuItem);
            break;
            paramAnonymousInt = 0;
            break label652;
          }
        }
      };
      locale.dGm();
      label114:
      AppMethodBeat.o(98184);
      return true;
    }
    catch (Exception localException)
    {
      break label114;
    }
  }
  
  public final Map<String, Boolean> fgI()
  {
    AppMethodBeat.i(98189);
    Object localObject = new HashMap();
    if ((this.EuF != null) && (!this.EuF.EuQ.isEmpty()))
    {
      Iterator localIterator = this.EuF.EuQ.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((Boolean)this.EuF.EuR.get(str) != null) {
          ((Map)localObject).put(str, this.EuF.EuR.get(str));
        }
      }
    }
    if (this.EuF != null)
    {
      localObject = this.EuF.EuR;
      AppMethodBeat.o(98189);
      return localObject;
    }
    AppMethodBeat.o(98189);
    return null;
  }
  
  /* Error */
  public final boolean k(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1014
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+53 -> 60, 2:+61->68, 3:+163->170, 4:+1360->1367, 5:+53->60, 6:+53->60, 7:+1740->1747, 8:+53->60, 9:+485->492, 10:+53->60, 11:+1126->1133
    //   61: iconst_0
    //   62: <illegal opcode>
    //   63: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iconst_0
    //   67: ireturn
    //   68: ldc 159
    //   70: ldc_w 1016
    //   73: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_2
    //   77: ifnonnull +11 -> 88
    //   80: ldc_w 1014
    //   83: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_0
    //   87: ireturn
    //   88: ldc 159
    //   90: ldc_w 1018
    //   93: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 286	android/content/Intent
    //   99: dup
    //   100: invokespecial 287	android/content/Intent:<init>	()V
    //   103: astore 4
    //   105: aload 4
    //   107: ldc_w 1020
    //   110: iconst_4
    //   111: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload 4
    //   117: ldc_w 1022
    //   120: iconst_1
    //   121: invokevirtual 1025	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   124: pop
    //   125: aload 4
    //   127: ldc_w 1027
    //   130: iconst_1
    //   131: invokevirtual 1025	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   134: pop
    //   135: getstatic 1031	com/tencent/mm/plugin/sns/c/a:jRt	Lcom/tencent/mm/pluginsdk/m;
    //   138: aload_0
    //   139: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   142: aload_2
    //   143: aload 4
    //   145: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   148: iconst_4
    //   149: new 20	com/tencent/mm/plugin/sns/ui/aq$7
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 1032	com/tencent/mm/plugin/sns/ui/aq$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/aq;)V
    //   157: invokeinterface 1037 7 0
    //   162: ldc_w 1014
    //   165: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_1
    //   169: ireturn
    //   170: ldc 159
    //   172: ldc_w 1039
    //   175: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   182: invokevirtual 1043	com/tencent/mm/ui/MMActivity:getApplicationContext	()Landroid/content/Context;
    //   185: aload_2
    //   186: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   189: invokestatic 1049	com/tencent/mm/pluginsdk/ui/tools/s:h	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_2
    //   193: aload_2
    //   194: ifnonnull +11 -> 205
    //   197: ldc_w 1014
    //   200: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iconst_1
    //   204: ireturn
    //   205: new 286	android/content/Intent
    //   208: dup
    //   209: invokespecial 287	android/content/Intent:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: ldc_w 1020
    //   219: iconst_4
    //   220: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   223: pop
    //   224: aload 4
    //   226: ldc_w 1027
    //   229: iconst_1
    //   230: invokevirtual 1025	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   233: pop
    //   234: aload 4
    //   236: ldc_w 1022
    //   239: iconst_1
    //   240: invokevirtual 1025	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   243: pop
    //   244: aload 4
    //   246: ldc_w 1051
    //   249: aload_2
    //   250: invokevirtual 1054	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   253: pop
    //   254: new 595	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   261: aload_2
    //   262: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokestatic 762	java/lang/System:currentTimeMillis	()J
    //   268: invokevirtual 632	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 766	java/lang/String:getBytes	()[B
    //   277: invokestatic 772	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   280: astore 5
    //   282: aload 4
    //   284: ldc_w 1056
    //   287: new 595	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   294: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   297: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 5
    //   302: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 1054	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   311: pop
    //   312: aload_2
    //   313: invokestatic 827	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   316: invokevirtual 831	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   319: astore 6
    //   321: aload 6
    //   323: ifnull +70 -> 393
    //   326: aload_0
    //   327: getfield 84	com/tencent/mm/plugin/sns/ui/aq:EuH	Ljava/util/Map;
    //   330: new 595	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   337: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   340: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 5
    //   345: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: aload 6
    //   353: invokeinterface 188 3 0
    //   358: pop
    //   359: ldc 159
    //   361: ldc_w 1058
    //   364: iconst_2
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload 6
    //   372: getfield 581	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   375: invokestatic 888	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: aload 6
    //   383: getfield 584	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   386: invokestatic 888	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   389: aastore
    //   390: invokestatic 1060	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: new 553	com/tencent/mm/protocal/protobuf/eas
    //   396: dup
    //   397: invokespecial 554	com/tencent/mm/protocal/protobuf/eas:<init>	()V
    //   400: astore 6
    //   402: aload 6
    //   404: iconst_1
    //   405: putfield 642	com/tencent/mm/protocal/protobuf/eas:Nam	I
    //   408: aload 6
    //   410: invokestatic 762	java/lang/System:currentTimeMillis	()J
    //   413: putfield 637	com/tencent/mm/protocal/protobuf/eas:Nao	J
    //   416: aload 6
    //   418: aload_2
    //   419: invokestatic 827	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   422: getfield 1063	com/tencent/mm/compatible/util/Exif:dateTime	Ljava/lang/String;
    //   425: invokestatic 1066	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   428: putfield 629	com/tencent/mm/protocal/protobuf/eas:Nan	J
    //   431: aload_0
    //   432: getfield 86	com/tencent/mm/plugin/sns/ui/aq:EuI	Ljava/util/Map;
    //   435: new 595	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   442: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   445: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 5
    //   450: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: aload 6
    //   458: invokeinterface 188 3 0
    //   463: pop
    //   464: getstatic 1031	com/tencent/mm/plugin/sns/c/a:jRt	Lcom/tencent/mm/pluginsdk/m;
    //   467: aload_0
    //   468: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   471: aload 4
    //   473: iconst_4
    //   474: invokeinterface 1069 4 0
    //   479: aload_0
    //   480: iconst_1
    //   481: putfield 79	com/tencent/mm/plugin/sns/ui/aq:EsU	Z
    //   484: ldc_w 1014
    //   487: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: iconst_1
    //   491: ireturn
    //   492: aload_2
    //   493: ldc_w 1071
    //   496: invokevirtual 724	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   499: astore 4
    //   501: aload 4
    //   503: ifnull +131 -> 634
    //   506: aload 4
    //   508: ldc_w 1073
    //   511: invokevirtual 1076	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   514: ifnull +120 -> 634
    //   517: aload 4
    //   519: ldc_w 1078
    //   522: invokevirtual 1076	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   525: ifnull +109 -> 634
    //   528: ldc 159
    //   530: ldc_w 1080
    //   533: invokestatic 649	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload_0
    //   537: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   540: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   543: invokevirtual 787	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   546: invokevirtual 1081	android/os/Bundle:clear	()V
    //   549: aload_0
    //   550: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   553: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   556: ldc_w 690
    //   559: iconst_0
    //   560: invokevirtual 1025	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   563: pop
    //   564: aload_0
    //   565: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   568: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   571: ldc_w 1083
    //   574: iconst_1
    //   575: invokevirtual 1025	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   578: pop
    //   579: aload_0
    //   580: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   583: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   586: ldc_w 1085
    //   589: bipush 14
    //   591: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   594: pop
    //   595: aload_0
    //   596: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   599: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   602: ldc_w 1071
    //   605: aload_2
    //   606: ldc_w 1071
    //   609: invokevirtual 724	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   612: invokevirtual 1088	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   615: pop
    //   616: aload_0
    //   617: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   620: checkcast 1090	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   623: invokevirtual 1093	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   626: ldc_w 1014
    //   629: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   632: iconst_1
    //   633: ireturn
    //   634: aload_2
    //   635: ldc_w 1095
    //   638: invokevirtual 803	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   641: astore 4
    //   643: aload 4
    //   645: ifnull +11 -> 656
    //   648: aload 4
    //   650: invokevirtual 275	java/util/ArrayList:size	()I
    //   653: ifgt +16 -> 669
    //   656: aload_2
    //   657: ldc_w 1097
    //   660: invokevirtual 700	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   666: ifne +393 -> 1059
    //   669: aload 4
    //   671: ifnull +126 -> 797
    //   674: aload 4
    //   676: invokevirtual 275	java/util/ArrayList:size	()I
    //   679: ifle +118 -> 797
    //   682: aload 4
    //   684: iconst_0
    //   685: invokevirtual 1100	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   688: checkcast 151	java/lang/String
    //   691: astore 4
    //   693: aload_2
    //   694: ldc_w 1102
    //   697: invokevirtual 700	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   700: astore 6
    //   702: aload 6
    //   704: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   707: ifne +15 -> 722
    //   710: aload 6
    //   712: astore 5
    //   714: aload 6
    //   716: invokestatic 906	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   719: ifne +184 -> 903
    //   722: new 595	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   729: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   732: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 4
    //   737: invokestatic 1105	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   740: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: astore 5
    //   748: new 1107	com/tencent/mm/compatible/i/d
    //   751: dup
    //   752: invokespecial 1108	com/tencent/mm/compatible/i/d:<init>	()V
    //   755: astore 6
    //   757: aload 6
    //   759: aload 4
    //   761: invokevirtual 1113	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   764: aload 6
    //   766: lconst_0
    //   767: invokevirtual 1117	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   770: astore 7
    //   772: aload 7
    //   774: ifnonnull +35 -> 809
    //   777: ldc 159
    //   779: ldc_w 1119
    //   782: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 6
    //   787: invokevirtual 1122	android/media/MediaMetadataRetriever:release	()V
    //   790: goto -730 -> 60
    //   793: astore_2
    //   794: goto -734 -> 60
    //   797: aload_2
    //   798: ldc_w 1097
    //   801: invokevirtual 700	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   804: astore 4
    //   806: goto -113 -> 693
    //   809: ldc 159
    //   811: ldc_w 1124
    //   814: iconst_2
    //   815: anewarray 4	java/lang/Object
    //   818: dup
    //   819: iconst_0
    //   820: aload 7
    //   822: invokevirtual 1129	android/graphics/Bitmap:getWidth	()I
    //   825: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: aastore
    //   829: dup
    //   830: iconst_1
    //   831: aload 7
    //   833: invokevirtual 1132	android/graphics/Bitmap:getHeight	()I
    //   836: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   839: aastore
    //   840: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   843: aload 7
    //   845: bipush 80
    //   847: getstatic 1138	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   850: aload 5
    //   852: iconst_1
    //   853: invokestatic 1144	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   856: pop
    //   857: aload 5
    //   859: invokestatic 1148	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   862: astore 7
    //   864: ldc 159
    //   866: ldc_w 1150
    //   869: iconst_2
    //   870: anewarray 4	java/lang/Object
    //   873: dup
    //   874: iconst_0
    //   875: aload 7
    //   877: getfield 1155	android/graphics/BitmapFactory$Options:outWidth	I
    //   880: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: aload 7
    //   888: getfield 1158	android/graphics/BitmapFactory$Options:outHeight	I
    //   891: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   894: aastore
    //   895: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   898: aload 6
    //   900: invokevirtual 1122	android/media/MediaMetadataRetriever:release	()V
    //   903: ldc 159
    //   905: ldc_w 1160
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
    //   926: invokestatic 546	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   929: invokestatic 551	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   932: aastore
    //   933: dup
    //   934: iconst_3
    //   935: aload 5
    //   937: invokestatic 546	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   940: invokestatic 551	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   943: aastore
    //   944: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: aload 4
    //   949: invokestatic 1105	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   952: astore 6
    //   954: aload_0
    //   955: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   958: instanceof 1090
    //   961: ifeq +41 -> 1002
    //   964: aload_2
    //   965: ldc_w 1162
    //   968: invokevirtual 700	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   971: invokestatic 1167	com/tencent/mm/plugin/sns/data/r:aOz	(Ljava/lang/String;)V
    //   974: aload_0
    //   975: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   978: checkcast 1090	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   981: aload 4
    //   983: aload 5
    //   985: aload 6
    //   987: aconst_null
    //   988: iconst_0
    //   989: invokevirtual 1170	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   992: aload_0
    //   993: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   996: checkcast 1090	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   999: invokevirtual 1093	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   1002: ldc_w 1014
    //   1005: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1008: iconst_1
    //   1009: ireturn
    //   1010: astore 7
    //   1012: ldc 159
    //   1014: ldc_w 1172
    //   1017: iconst_1
    //   1018: anewarray 4	java/lang/Object
    //   1021: dup
    //   1022: iconst_0
    //   1023: aload 7
    //   1025: invokevirtual 847	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1028: aastore
    //   1029: invokestatic 1174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1032: aload 6
    //   1034: invokevirtual 1122	android/media/MediaMetadataRetriever:release	()V
    //   1037: goto -134 -> 903
    //   1040: astore 6
    //   1042: goto -139 -> 903
    //   1045: astore_2
    //   1046: aload 6
    //   1048: invokevirtual 1122	android/media/MediaMetadataRetriever:release	()V
    //   1051: ldc_w 1014
    //   1054: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1057: aload_2
    //   1058: athrow
    //   1059: aload_2
    //   1060: ldc_w 1176
    //   1063: invokevirtual 803	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1066: astore 4
    //   1068: aload_2
    //   1069: ldc_w 1178
    //   1072: iconst_0
    //   1073: invokevirtual 714	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1076: istore_1
    //   1077: aload_2
    //   1078: ldc_w 1180
    //   1081: iconst_0
    //   1082: invokevirtual 694	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1085: istore_3
    //   1086: ldc_w 1182
    //   1089: invokestatic 1186	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1092: checkcast 1182	com/tencent/mm/plugin/expt/b/b
    //   1095: getstatic 1192	com/tencent/mm/plugin/expt/b/b$a:rZk	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   1098: iconst_1
    //   1099: invokeinterface 1195 3 0
    //   1104: ifeq +12 -> 1116
    //   1107: getstatic 916	com/tencent/mm/plugin/recordvideo/e/c:Cic	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   1110: astore_2
    //   1111: aload 4
    //   1113: invokestatic 1199	com/tencent/mm/plugin/recordvideo/e/c:aL	(Ljava/util/ArrayList;)V
    //   1116: aload_0
    //   1117: aload 4
    //   1119: iload_1
    //   1120: iload_3
    //   1121: invokevirtual 1201	com/tencent/mm/plugin/sns/ui/aq:c	(Ljava/util/List;IZ)Z
    //   1124: istore_3
    //   1125: ldc_w 1014
    //   1128: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1131: iload_3
    //   1132: ireturn
    //   1133: aload_2
    //   1134: ldc_w 1203
    //   1137: invokevirtual 1207	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1140: checkcast 1209	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   1143: astore 5
    //   1145: aload 5
    //   1147: ifnull -1087 -> 60
    //   1150: aload 5
    //   1152: getfield 1212	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsy	Z
    //   1155: ifeq +65 -> 1220
    //   1158: aload 5
    //   1160: getfield 1215	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsG	Ljava/lang/String;
    //   1163: astore_2
    //   1164: aload_2
    //   1165: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1168: ifne -1108 -> 60
    //   1171: ldc_w 1182
    //   1174: invokestatic 1186	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1177: checkcast 1182	com/tencent/mm/plugin/expt/b/b
    //   1180: getstatic 1192	com/tencent/mm/plugin/expt/b/b$a:rZk	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   1183: iconst_1
    //   1184: invokeinterface 1195 3 0
    //   1189: ifeq +12 -> 1201
    //   1192: getstatic 916	com/tencent/mm/plugin/recordvideo/e/c:Cic	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   1195: astore 4
    //   1197: aload_2
    //   1198: invokestatic 1218	com/tencent/mm/plugin/recordvideo/e/c:aLE	(Ljava/lang/String;)V
    //   1201: aload_0
    //   1202: aload_2
    //   1203: invokestatic 1224	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   1206: iconst_0
    //   1207: iconst_1
    //   1208: invokevirtual 1201	com/tencent/mm/plugin/sns/ui/aq:c	(Ljava/util/List;IZ)Z
    //   1211: istore_3
    //   1212: ldc_w 1014
    //   1215: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1218: iload_3
    //   1219: ireturn
    //   1220: aload 5
    //   1222: getfield 1227	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsA	Ljava/lang/String;
    //   1225: astore 6
    //   1227: aload 5
    //   1229: getfield 1230	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsB	Ljava/lang/String;
    //   1232: astore 7
    //   1234: aconst_null
    //   1235: astore 4
    //   1237: aload_0
    //   1238: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1241: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1244: ldc_w 1232
    //   1247: aload 5
    //   1249: getfield 1230	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsB	Ljava/lang/String;
    //   1252: invokevirtual 1054	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1255: pop
    //   1256: aload 5
    //   1258: getfield 1235	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsD	Ljava/lang/String;
    //   1261: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1264: ifne +69 -> 1333
    //   1267: aload 5
    //   1269: getfield 1235	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsD	Ljava/lang/String;
    //   1272: astore_2
    //   1273: aload 5
    //   1275: getfield 1239	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsF	Lcom/tencent/mm/protocal/protobuf/cly;
    //   1278: invokevirtual 1244	com/tencent/mm/protocal/protobuf/cly:toByteArray	()[B
    //   1281: astore 5
    //   1283: aload 5
    //   1285: astore 4
    //   1287: aload_0
    //   1288: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1291: instanceof 1090
    //   1294: ifeq +31 -> 1325
    //   1297: aload_0
    //   1298: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1301: checkcast 1090	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1304: aload 6
    //   1306: aload 7
    //   1308: aload_2
    //   1309: aload 4
    //   1311: iconst_1
    //   1312: invokevirtual 1170	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   1315: aload_0
    //   1316: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1319: checkcast 1090	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1322: invokevirtual 1093	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   1325: ldc_w 1014
    //   1328: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1331: iconst_1
    //   1332: ireturn
    //   1333: aload 6
    //   1335: invokestatic 1105	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   1338: astore_2
    //   1339: goto -66 -> 1273
    //   1342: astore 5
    //   1344: ldc 159
    //   1346: ldc_w 1246
    //   1349: iconst_1
    //   1350: anewarray 4	java/lang/Object
    //   1353: dup
    //   1354: iconst_0
    //   1355: aload 5
    //   1357: invokevirtual 847	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1360: aastore
    //   1361: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1364: goto -77 -> 1287
    //   1367: ldc 159
    //   1369: ldc_w 1248
    //   1372: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload_2
    //   1376: ifnonnull +11 -> 1387
    //   1379: ldc_w 1014
    //   1382: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1385: iconst_1
    //   1386: ireturn
    //   1387: aload_2
    //   1388: ldc_w 1056
    //   1391: invokevirtual 700	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1394: astore 4
    //   1396: ldc 159
    //   1398: ldc_w 1250
    //   1401: aload 4
    //   1403: invokestatic 811	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1406: invokevirtual 814	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1409: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1412: aload 4
    //   1414: ifnonnull +11 -> 1425
    //   1417: ldc_w 1014
    //   1420: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1423: iconst_1
    //   1424: ireturn
    //   1425: aload 4
    //   1427: invokestatic 906	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   1430: ifne +11 -> 1441
    //   1433: ldc_w 1014
    //   1436: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1439: iconst_1
    //   1440: ireturn
    //   1441: aload_0
    //   1442: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1445: getfield 221	com/tencent/mm/plugin/sns/ui/aq$b:EuQ	Ljava/util/ArrayList;
    //   1448: invokevirtual 275	java/util/ArrayList:size	()I
    //   1451: bipush 9
    //   1453: if_icmplt +11 -> 1464
    //   1456: ldc_w 1014
    //   1459: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1462: iconst_1
    //   1463: ireturn
    //   1464: aload_2
    //   1465: ldc_w 1178
    //   1468: iconst_0
    //   1469: invokevirtual 714	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1472: istore_1
    //   1473: new 595	java/lang/StringBuilder
    //   1476: dup
    //   1477: ldc_w 849
    //   1480: invokespecial 599	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1483: new 595	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   1490: aload 4
    //   1492: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokestatic 762	java/lang/System:currentTimeMillis	()J
    //   1498: invokevirtual 632	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1501: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: invokevirtual 766	java/lang/String:getBytes	()[B
    //   1507: invokestatic 772	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   1510: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: astore_2
    //   1517: ldc 159
    //   1519: new 595	java/lang/StringBuilder
    //   1522: dup
    //   1523: ldc_w 1252
    //   1526: invokespecial 599	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1529: aload 4
    //   1531: invokestatic 546	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   1534: invokevirtual 632	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1537: ldc_w 619
    //   1540: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload 4
    //   1545: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 649	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload 4
    //   1556: new 595	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   1563: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   1566: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload_2
    //   1570: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokestatic 859	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   1579: pop2
    //   1580: aload_0
    //   1581: getfield 84	com/tencent/mm/plugin/sns/ui/aq:EuH	Ljava/util/Map;
    //   1584: aload 4
    //   1586: invokeinterface 353 2 0
    //   1591: ifeq +44 -> 1635
    //   1594: aload_0
    //   1595: getfield 84	com/tencent/mm/plugin/sns/ui/aq:EuH	Ljava/util/Map;
    //   1598: new 595	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   1605: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   1608: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload_2
    //   1612: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: aload_0
    //   1619: getfield 84	com/tencent/mm/plugin/sns/ui/aq:EuH	Ljava/util/Map;
    //   1622: aload 4
    //   1624: invokeinterface 357 2 0
    //   1629: invokeinterface 188 3 0
    //   1634: pop
    //   1635: new 595	java/lang/StringBuilder
    //   1638: dup
    //   1639: invokespecial 753	java/lang/StringBuilder:<init>	()V
    //   1642: invokestatic 756	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   1645: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: aload_2
    //   1649: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: invokevirtual 609	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: astore_2
    //   1656: ldc 159
    //   1658: ldc_w 808
    //   1661: aload_2
    //   1662: invokestatic 811	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1665: invokevirtual 814	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1668: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1671: aload_0
    //   1672: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1675: aload_2
    //   1676: iload_1
    //   1677: iconst_0
    //   1678: invokevirtual 821	com/tencent/mm/plugin/sns/ui/aq$b:t	(Ljava/lang/String;IZ)Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1681: pop
    //   1682: aload_0
    //   1683: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1686: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1689: ldc_w 797
    //   1692: aload_0
    //   1693: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1696: getfield 221	com/tencent/mm/plugin/sns/ui/aq$b:EuQ	Ljava/util/ArrayList;
    //   1699: invokevirtual 925	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1702: pop
    //   1703: aload_0
    //   1704: getfield 217	com/tencent/mm/plugin/sns/ui/aq:EuG	Lcom/tencent/mm/plugin/sns/ui/z;
    //   1707: checkcast 225	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1710: aload_0
    //   1711: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1714: getfield 221	com/tencent/mm/plugin/sns/ui/aq$b:EuQ	Ljava/util/ArrayList;
    //   1717: invokevirtual 275	java/util/ArrayList:size	()I
    //   1720: invokevirtual 922	com/tencent/mm/plugin/sns/ui/previewimageview/e:aah	(I)V
    //   1723: aload_0
    //   1724: getfield 217	com/tencent/mm/plugin/sns/ui/aq:EuG	Lcom/tencent/mm/plugin/sns/ui/z;
    //   1727: aload_0
    //   1728: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1731: getfield 221	com/tencent/mm/plugin/sns/ui/aq$b:EuQ	Ljava/util/ArrayList;
    //   1734: invokeinterface 237 2 0
    //   1739: ldc_w 1014
    //   1742: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1745: iconst_1
    //   1746: ireturn
    //   1747: aload_2
    //   1748: ifnonnull +11 -> 1759
    //   1751: ldc_w 1014
    //   1754: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1757: iconst_1
    //   1758: ireturn
    //   1759: aload_0
    //   1760: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1763: aload_2
    //   1764: ldc_w 1254
    //   1767: invokevirtual 803	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1770: invokevirtual 1257	com/tencent/mm/plugin/sns/ui/aq$b:aQ	(Ljava/util/ArrayList;)V
    //   1773: aload_0
    //   1774: getfield 106	com/tencent/mm/plugin/sns/ui/aq:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1777: invokevirtual 684	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1780: ldc_w 797
    //   1783: aload_0
    //   1784: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1787: getfield 221	com/tencent/mm/plugin/sns/ui/aq$b:EuQ	Ljava/util/ArrayList;
    //   1790: invokevirtual 925	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1793: pop
    //   1794: aload_0
    //   1795: getfield 217	com/tencent/mm/plugin/sns/ui/aq:EuG	Lcom/tencent/mm/plugin/sns/ui/z;
    //   1798: checkcast 225	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1801: aload_0
    //   1802: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1805: getfield 221	com/tencent/mm/plugin/sns/ui/aq$b:EuQ	Ljava/util/ArrayList;
    //   1808: invokevirtual 275	java/util/ArrayList:size	()I
    //   1811: invokevirtual 922	com/tencent/mm/plugin/sns/ui/previewimageview/e:aah	(I)V
    //   1814: aload_0
    //   1815: getfield 217	com/tencent/mm/plugin/sns/ui/aq:EuG	Lcom/tencent/mm/plugin/sns/ui/z;
    //   1818: aload_0
    //   1819: getfield 77	com/tencent/mm/plugin/sns/ui/aq:EuF	Lcom/tencent/mm/plugin/sns/ui/aq$b;
    //   1822: getfield 221	com/tencent/mm/plugin/sns/ui/aq$b:EuQ	Ljava/util/ArrayList;
    //   1825: invokeinterface 237 2 0
    //   1830: aload_0
    //   1831: aload_2
    //   1832: ldc_w 1259
    //   1835: iconst_0
    //   1836: invokevirtual 714	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1839: putfield 88	com/tencent/mm/plugin/sns/ui/aq:EuJ	I
    //   1842: ldc_w 1014
    //   1845: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1848: iconst_1
    //   1849: ireturn
    //   1850: astore 6
    //   1852: goto -949 -> 903
    //   1855: astore 4
    //   1857: goto -806 -> 1051
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1860	0	this	aq
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
    extends com.tencent.mm.plugin.sns.model.h<String, Integer, Boolean>
  {
    private bf Eth;
    private List<q> EuN;
    private ProgressDialog gtM;
    
    public a(List<q> paramList)
    {
      AppMethodBeat.i(98164);
      this.gtM = null;
      this.Eth = paramList;
      Object localObject;
      this.EuN = localObject;
      paramList = aq.this.gte;
      aq.this.gte.getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(paramList, aq.this.gte.getString(2131755887), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      AppMethodBeat.o(98164);
    }
    
    public final ExecutorService eGk()
    {
      AppMethodBeat.i(179157);
      ExecutorService localExecutorService = aj.faB();
      AppMethodBeat.o(179157);
      return localExecutorService;
    }
  }
  
  final class b
  {
    ArrayList<String> EuQ;
    Map<String, Boolean> EuR;
    Map<String, Integer> EuS;
    
    b()
    {
      AppMethodBeat.i(98168);
      this.EuQ = new ArrayList();
      this.EuR = new HashMap();
      this.EuS = new HashMap();
      AppMethodBeat.o(98168);
    }
    
    public final void aQ(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(98170);
      this.EuR.clear();
      if (paramArrayList == null)
      {
        this.EuQ = new ArrayList();
        AppMethodBeat.o(98170);
        return;
      }
      this.EuQ = paramArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.EuR.put(str, Boolean.FALSE);
      }
      AppMethodBeat.o(98170);
    }
    
    public final b aQY(String paramString)
    {
      int i = 0;
      AppMethodBeat.i(98172);
      try
      {
        paramString = paramString.split(";");
        int j = paramString.length;
        while (i < j)
        {
          String[] arrayOfString = paramString[i].split(",");
          this.EuQ.add(arrayOfString[0]);
          this.EuS.put(arrayOfString[0], Integer.valueOf(Util.getInt(arrayOfString[1], 0)));
          i += 1;
        }
        return this;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(98172);
      }
    }
    
    public final b t(String paramString, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(98169);
      this.EuQ.add(paramString);
      this.EuS.put(paramString, Integer.valueOf(paramInt));
      this.EuR.put(paramString, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(98169);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(98171);
      Iterator localIterator = this.EuQ.iterator();
      String str2;
      int i;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "," + i + ";")
      {
        str2 = (String)localIterator.next();
        i = 0;
        if (this.EuS != null) {
          i = ((Integer)this.EuS.get(str2)).intValue();
        }
      }
      AppMethodBeat.o(98171);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aq
 * JD-Core Version:    0.7.0.1
 */