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
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.f.b.a.kp;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.c.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.ejk;
import com.tencent.mm.protocal.protobuf.eks;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class as
  implements af
{
  private int KCP;
  private l KCV;
  private String KCW;
  private boolean KEH;
  private boolean KEI;
  private WXMediaMessage KEJ;
  private String KGq;
  private boolean KGr;
  private int KIA;
  private boolean KIB;
  cst KIC;
  b KIw;
  ab KIx;
  Map<String, Exif.a> KIy;
  private Map<String, eks> KIz;
  private int Kcp;
  private String appId;
  private String appName;
  protected MMActivity iXq;
  private String mSessionId;
  
  public as(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(98173);
    this.KIw = new b();
    this.KGr = false;
    this.KIy = new HashMap();
    this.KIz = new HashMap();
    this.KIA = 0;
    this.KEH = false;
    this.KIB = false;
    this.KEI = false;
    this.KEJ = null;
    this.KCV = null;
    this.Kcp = 1;
    this.KCW = "";
    this.iXq = paramMMActivity;
    AppMethodBeat.o(98173);
  }
  
  private static be a(be parambe, List<com.tencent.mm.plugin.sns.data.s> paramList)
  {
    AppMethodBeat.i(98181);
    parambe.hB(paramList);
    AppMethodBeat.o(98181);
    return parambe;
  }
  
  private boolean aA(Bundle paramBundle)
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
        this.KIy.put(arrayOfString[0].trim(), new Exif.a(Util.getDouble(arrayOfString[1], 0.0D), Util.getDouble(arrayOfString[2], 0.0D), 0.0D));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e("MicroMsg.PicWidget", localNumberFormatException.toString());
      }
    }
    AppMethodBeat.o(98176);
    return true;
  }
  
  private void b(be parambe)
  {
    AppMethodBeat.i(98182);
    int i = parambe.in();
    if (this.KCV != null)
    {
      this.KCV.wQ(i);
      com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
    }
    if ((this.KIw != null) && (this.KIw.KIH != null) && (r.fTa())) {
      com.tencent.mm.plugin.report.service.h.IzE.a(12834, new Object[] { Integer.valueOf(this.KIw.KIH.size()) });
    }
    parambe = new Intent();
    parambe.putExtra("sns_local_id", i);
    this.iXq.setResult(-1, parambe);
    this.iXq.finish();
    aj.fOE().fNd();
    AppMethodBeat.o(98182);
  }
  
  public final View a(View paramView1, View paramView2, DynamicGridView paramDynamicGridView, View paramView3)
  {
    AppMethodBeat.i(98179);
    boolean bool;
    if (this.KIx == null)
    {
      MMActivity localMMActivity = this.iXq;
      ArrayList localArrayList = this.KIw.KIH;
      ab.a local1 = new ab.a()
      {
        public final void Si(int paramAnonymousInt)
        {
          AppMethodBeat.i(98155);
          Log.d("MicroMsg.PicWidget", "I click");
          if (paramAnonymousInt < 0)
          {
            as.this.fUN();
            AppMethodBeat.o(98155);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.setClass(as.this.iXq, SnsUploadBrowseUI.class);
          localIntent.putExtra("sns_gallery_position", paramAnonymousInt);
          localIntent.putExtra("sns_gallery_temp_paths", as.this.KIw.KIH);
          localIntent.putExtra("key_from_scene", 7);
          as.this.iXq.startActivityForResult(localIntent, 7);
          AppMethodBeat.o(98155);
        }
      };
      c.a local2 = new c.a()
      {
        public final void jT(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(98156);
          as.b localb = as.this.KIw;
          String str;
          if ((paramAnonymousInt1 != paramAnonymousInt2) && (localb.KIH.size() > paramAnonymousInt1))
          {
            str = (String)localb.KIH.remove(paramAnonymousInt1);
            if (paramAnonymousInt2 >= localb.KIH.size()) {
              break label95;
            }
            localb.KIH.add(paramAnonymousInt2, str);
          }
          for (;;)
          {
            as.this.iXq.getIntent().putExtra("sns_kemdia_path_list", as.this.KIw.KIH);
            AppMethodBeat.o(98156);
            return;
            label95:
            localb.KIH.add(str);
          }
        }
        
        public final void removeItem(int paramAnonymousInt)
        {
          AppMethodBeat.i(98157);
          as.b localb = as.this.KIw;
          if (localb.KIH.size() > paramAnonymousInt) {
            localb.KIH.remove(paramAnonymousInt);
          }
          if ((as.this.iXq instanceof SnsUploadUI)) {
            ((SnsUploadUI)as.this.iXq).fXY();
          }
          as.this.iXq.getIntent().putExtra("sns_kemdia_path_list", as.this.KIw.KIH);
          as.this.iXq.getIntent().putExtra("sns_kemdia_path", "");
          ((com.tencent.mm.plugin.sns.ui.previewimageview.e)as.this.KIx).ahC(as.this.KIw.KIH.size());
          AppMethodBeat.o(98157);
        }
      };
      if (!this.KIB)
      {
        bool = true;
        this.KIx = new com.tencent.mm.plugin.sns.ui.previewimageview.e(paramView1, paramView2, paramView3, localMMActivity, localArrayList, paramDynamicGridView, local1, local2, bool);
      }
    }
    for (;;)
    {
      paramView1 = this.KIx.getView();
      AppMethodBeat.o(98179);
      return paramView1;
      bool = false;
      break;
      this.KIx.hJ(this.KIw.KIH);
    }
  }
  
  protected void a(be parambe) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98183);
    paramLinkedList = new LinkedList();
    paramString2 = this.KIw.KIH.iterator();
    int i = 0;
    Object localObject1;
    Object localObject2;
    label109:
    Object localObject3;
    if (paramString2.hasNext())
    {
      localObject1 = (String)paramString2.next();
      localObject2 = new com.tencent.mm.plugin.sns.data.s((String)localObject1, 2);
      ((com.tencent.mm.plugin.sns.data.s)localObject2).type = 2;
      ((com.tencent.mm.plugin.sns.data.s)localObject2).JRw = paramInt1;
      int j;
      if (i == 0)
      {
        ((com.tencent.mm.plugin.sns.data.s)localObject2).JRv = paramInt2;
        if (parami != null)
        {
          ((com.tencent.mm.plugin.sns.data.s)localObject2).JRx = parami.token;
          ((com.tencent.mm.plugin.sns.data.s)localObject2).JRy = parami.TEk;
        }
        localObject3 = this.KIw;
        if (!((b)localObject3).KIJ.containsKey(localObject1)) {
          break label248;
        }
        j = ((Integer)((b)localObject3).KIJ.get(localObject1)).intValue();
        label150:
        ((com.tencent.mm.plugin.sns.data.s)localObject2).JRu = j;
        ((com.tencent.mm.plugin.sns.data.s)localObject2).desc = paramString1;
        localObject3 = this.KIw;
        if ((Util.isNullOrNil((String)localObject1)) || (!((b)localObject3).KII.containsKey(localObject1))) {
          break label254;
        }
      }
      label248:
      label254:
      for (boolean bool = ((Boolean)((b)localObject3).KII.get(localObject1)).booleanValue();; bool = false)
      {
        ((com.tencent.mm.plugin.sns.data.s)localObject2).JRA = bool;
        paramLinkedList.add(localObject2);
        i += 1;
        break;
        ((com.tencent.mm.plugin.sns.data.s)localObject2).JRv = 0;
        break label109;
        j = 0;
        break label150;
      }
    }
    paramString2 = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      localObject1 = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject2 = (String)paramList1.next();
        if (!((List)localObject1).contains(localObject2))
        {
          localObject3 = new elm();
          ((elm)localObject3).UserName = ((String)localObject2);
          paramString2.add(localObject3);
        }
      }
    }
    paramList1 = new be(1, this.iXq);
    paramPInt.value = paramList1.aOl;
    if (parami != null) {
      paramList1.kG(parami.token, parami.TEk);
    }
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramList1.afW(3);
    }
    paramList1.bas(paramString1).a(paramcst).bL(paramString2).afZ(paramInt1).aga(paramInt2);
    if (paramBoolean) {
      paramList1.agc(1);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.appId)) {
        paramList1.bay(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        paramList1.baz(Util.nullAs(this.appName, ""));
      }
      paramList1.agb(this.KCP);
      if (this.KEH) {
        paramList1.agb(5);
      }
      if ((this.KEI) && (this.KEJ != null))
      {
        paramList1.bat(this.KEJ.mediaTagName);
        paramList1.aI(this.appId, this.KEJ.messageExt, this.KEJ.messageAction);
      }
      paramList1.i(null, null, null, paramInt4, paramInt5);
      paramList1.ct(this.Kcp, this.KCW);
      paramList1.hA(paramList2);
      paramList1.setSessionId(this.mSessionId);
      a(paramList1);
      if ((paramcst != null) && (paramcst.score != 0))
      {
        paramInt1 = paramcst.score;
        parami = paramcst.SOz;
        paramList1.Kcl.TEs = new ejk();
        paramList1.Kcl.TEs.Ulz = paramInt1;
        paramList1.Kcl.TEs.Ulx = parami;
      }
      Log.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.KIA) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11602, new Object[] { Integer.valueOf(this.KIA), Integer.valueOf(paramLinkedList.size()) });
      parami = paramLinkedList.iterator();
      while (parami.hasNext())
      {
        paramString1 = (com.tencent.mm.plugin.sns.data.s)parami.next();
        Log.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[] { paramString1.path, Long.valueOf(com.tencent.mm.vfs.u.bBQ(paramString1.path)) });
      }
      paramList1.agc(0);
    }
    paramString1 = paramLinkedList.iterator();
    if (paramString1.hasNext())
    {
      paramcst = ((com.tencent.mm.plugin.sns.data.s)paramString1.next()).path;
      parami = (eks)this.KIz.get(paramcst);
      if (parami != null) {
        break label1366;
      }
      parami = new eks();
    }
    label967:
    label1366:
    for (;;)
    {
      if ((this.KIC != null) && ((this.KIC.ScP != 0.0F) || (this.KIC.ScO != 0.0F)))
      {
        parami.UmE = this.KIC.ScP;
        parami.UmF = this.KIC.ScO;
        parami.KFz = this.KIC.KFz;
        parami.KFy = this.KIC.KFy;
        paramcst = (Exif.a)this.KIy.get(paramcst);
        if ((paramcst == null) || ((paramcst.latitude == 0.0D) && (paramcst.longitude == 0.0D))) {
          break label1273;
        }
        parami.UmC = ((float)paramcst.latitude);
      }
      for (parami.UmD = ((float)paramcst.longitude);; parami.UmD = -1000.0F)
      {
        paramcst = new StringBuffer();
        paramcst.append("||index: " + paramList1.Kcl.TEn.size());
        paramcst.append("||item poi lat " + parami.UmE + " " + parami.UmF);
        paramcst.append("||item pic lat " + parami.UmC + " " + parami.UmD);
        paramcst.append("||item exitime:" + parami.UmH + " filetime: " + parami.UmI);
        paramcst.append("||item source: " + parami.UmG);
        Log.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + paramcst.toString());
        paramList1.Kcl.TEn.add(parami);
        break;
        parami.UmE = -1000.0F;
        parami.UmF = -1000.0F;
        break label967;
        label1273:
        parami.UmC = -1000.0F;
      }
      if (paramLinkedList.size() <= 1)
      {
        a(paramList1, paramLinkedList);
        b(paramList1);
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98159);
            long l = System.currentTimeMillis();
            Iterator localIterator = as.this.KIw.KIH.iterator();
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
              com.tencent.mm.plugin.report.service.h.IzE.a(15523, new Object[] { Integer.valueOf(i), str2, Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) });
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
  
  final void agP(int paramInt)
  {
    AppMethodBeat.i(98188);
    kp localkp = new kp().amB();
    localkp.gOI = paramInt;
    localkp.BF(this.KGq).bpa();
    AppMethodBeat.o(98188);
  }
  
  public void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(98174);
    this.KCV = l.x(this.iXq.getIntent());
    this.KGr = this.iXq.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.appId = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.KEH = this.iXq.getIntent().getBooleanExtra("KThrid_app", false);
    this.KIB = this.iXq.getIntent().getBooleanExtra("KBlockAdd", false);
    this.KEI = this.iXq.getIntent().getBooleanExtra("KSnsAction", false);
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = Util.nullAs(this.iXq.getIntent().getStringExtra("reportSessionId"), "");
    this.KGq = this.iXq.getIntent().getStringExtra("KSessionID");
    Object localObject1 = this.iXq.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (localObject1 != null) {
      this.KEJ = new SendMessageToWX.Req((Bundle)localObject1).message;
    }
    Object localObject3 = this.iXq.getIntent().getStringExtra("sns_kemdia_path");
    Object localObject4 = this.iXq.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = localObject4;
      if (this.KEJ != null)
      {
        localObject1 = localObject4;
        if (this.KEJ.mediaObject != null)
        {
          localObject1 = localObject4;
          if ((this.KEJ.mediaObject instanceof WXImageObject)) {
            localObject1 = ((WXImageObject)this.KEJ.mediaObject).imageData;
          }
        }
      }
    }
    if ((Util.isNullOrNil((String)localObject3)) && (!Util.isNullOrNil((byte[])localObject1)))
    {
      localObject3 = aj.getAccSnsTmpPath() + g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
      com.tencent.mm.vfs.u.deleteFile((String)localObject3);
      com.tencent.mm.vfs.u.f((String)localObject3, (byte[])localObject1, localObject1.length);
    }
    label497:
    label756:
    Object localObject2;
    for (localObject1 = localObject3;; localObject2 = localObject3)
    {
      int j = this.iXq.getIntent().getIntExtra("KFilterId", 0);
      boolean bool;
      if (paramBundle == null)
      {
        localObject3 = null;
        aA(paramBundle);
        bool = aA(this.iXq.getIntent().getExtras());
        this.KIA = 0;
        if (Util.isNullOrNil((String)localObject3)) {
          break label538;
        }
        this.KIw.bbY((String)localObject3);
      }
      for (;;)
      {
        if (this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
        {
          this.Kcp = 1;
          this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
          AppMethodBeat.o(98174);
          return;
          localObject3 = paramBundle.getString("sns_kemdia_path_list");
          break;
          label538:
          paramBundle = this.iXq.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
          if (!Util.isNullOrNil(paramBundle))
          {
            paramBundle = paramBundle.iterator();
            label564:
            if (paramBundle.hasNext())
            {
              localObject1 = (String)paramBundle.next();
              Log.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(localObject1)));
              this.KIw.x((String)localObject1, j, false);
              if (!bool)
              {
                localObject3 = Exif.fromFile((String)localObject1).getLocation();
                if (localObject3 != null) {
                  this.KIy.put(localObject1, localObject3);
                }
              }
            }
            for (;;)
            {
              try
              {
                localObject3 = new q((String)localObject1);
                localObject4 = new eks();
                if (!this.KGr) {
                  break label756;
                }
                i = 1;
                ((eks)localObject4).UmG = i;
                ((eks)localObject4).UmI = (((q)localObject3).lastModified() / 1000L);
                ((eks)localObject4).UmH = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
                this.KIz.put(localObject1, localObject4);
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
            paramBundle = aj.getAccSnsTmpPath() + "pre_temp_sns_pic" + g.getMessageDigest(localException.getBytes());
            com.tencent.mm.vfs.u.bBD(com.tencent.mm.vfs.u.bBT(paramBundle));
            com.tencent.mm.vfs.u.on(localException, paramBundle);
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
        this.KIw.x(paramBundle, i, this.KGr);
        if (!bool)
        {
          localObject3 = Exif.fromFile(localException).getLocation();
          if (localObject3 != null) {
            this.KIy.put(paramBundle, localObject3);
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = new q(localException);
            localObject4 = new eks();
            if (!this.KGr) {
              break label979;
            }
            i = 1;
            ((eks)localObject4).UmG = i;
            ((eks)localObject4).UmI = (((q)localObject3).lastModified() / 1000L);
            ((eks)localObject4).UmH = Exif.fromFile(localException).getUxtimeDatatimeOriginal();
            this.KIz.put(paramBundle, localObject4);
          }
          catch (Exception paramBundle)
          {
            Log.e("MicroMsg.PicWidget", "get report info error " + paramBundle.getMessage());
          }
          break;
          i = 2;
        }
        this.Kcp = 0;
        break label497;
      }
    }
  }
  
  public final void az(Bundle paramBundle)
  {
    AppMethodBeat.i(98177);
    paramBundle.putString("sns_kemdia_path_list", this.KIw.toString());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.KIy.entrySet().iterator();
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
    if (this.KIw.KIH.size() >= 9)
    {
      AppMethodBeat.o(98185);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (String)paramList.next();
      if (com.tencent.mm.vfs.u.agG((String)localObject1))
      {
        String str = "pre_temp_sns_pic" + g.getMessageDigest(new StringBuilder().append((String)localObject1).append(System.currentTimeMillis()).toString().getBytes());
        r.aL(aj.getAccSnsTmpPath(), (String)localObject1, str);
        Object localObject2 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        com.tencent.mm.plugin.recordvideo.e.d.aWj((String)localObject1);
        Log.d("MicroMsg.PicWidget", "newPath " + aj.getAccSnsTmpPath() + str);
        this.KIw.x(aj.getAccSnsTmpPath() + str, paramInt, paramBoolean);
        ((com.tencent.mm.plugin.sns.ui.previewimageview.e)this.KIx).ahC(this.KIw.KIH.size());
        this.KIx.hJ(this.KIw.KIH);
        this.iXq.getIntent().putExtra("sns_kemdia_path_list", this.KIw.KIH);
        for (;;)
        {
          try
          {
            localObject2 = new q((String)localObject1);
            eks localeks = new eks();
            if (!paramBoolean) {
              continue;
            }
            i = 1;
            localeks.UmG = i;
            localeks.UmI = (((q)localObject2).lastModified() / 1000L);
            localeks.UmH = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
            this.KIz.put(aj.getAccSnsTmpPath() + str, localeks);
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
          this.KIy.put(aj.getAccSnsTmpPath() + str, localObject1);
          break;
          i = 2;
        }
      }
    }
    AppMethodBeat.o(98185);
    return true;
  }
  
  public final boolean fTA()
  {
    AppMethodBeat.i(98187);
    if (this.KIx != null) {
      this.KIx.clean();
    }
    this.KIy.clear();
    this.KIz.clear();
    AppMethodBeat.o(98187);
    return false;
  }
  
  public final boolean fTw()
  {
    AppMethodBeat.i(98178);
    if (this.KIw != null)
    {
      b localb = this.KIw;
      if ((localb.KIH != null) && (localb.KIH.size() > 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(98178);
        return true;
      }
    }
    AppMethodBeat.o(98178);
    return false;
  }
  
  public View fTx()
  {
    AppMethodBeat.i(98180);
    this.KIx = new PreviewImageView(this.iXq);
    if (this.KIB) {
      this.KIx.setIsShowAddImage(false);
    }
    this.KIx.setImageClick(new ab.a()
    {
      public final void Si(int paramAnonymousInt)
      {
        AppMethodBeat.i(98158);
        Log.d("MicroMsg.PicWidget", "I click");
        if (paramAnonymousInt < 0)
        {
          as.this.fUN();
          AppMethodBeat.o(98158);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.setClass(as.this.iXq, SnsUploadBrowseUI.class);
        localIntent.putExtra("sns_gallery_position", paramAnonymousInt);
        localIntent.putExtra("key_from_scene", 7);
        localIntent.putExtra("sns_gallery_temp_paths", as.this.KIw.KIH);
        as.this.iXq.startActivityForResult(localIntent, 7);
        AppMethodBeat.o(98158);
      }
    });
    this.KIx.hJ(this.KIw.KIH);
    View localView = this.KIx.getView();
    AppMethodBeat.o(98180);
    return localView;
  }
  
  public final boolean fTy()
  {
    AppMethodBeat.i(255432);
    if ((this.KIw != null) && (!Util.isNullOrNil(this.KIw.KIH)))
    {
      Iterator localIterator = this.KIw.KIH.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (com.tencent.mm.vfs.u.agG((String)localIterator.next()));
    }
    for (boolean bool = false;; bool = true)
    {
      if (!bool) {
        com.tencent.mm.ui.base.h.p(this.iXq, i.j.sns_upload_media_not_exist, i.j.app_tip);
      }
      AppMethodBeat.o(255432);
      return bool;
    }
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  public final int fUM()
  {
    AppMethodBeat.i(98175);
    int i = this.KIw.KIH.size();
    AppMethodBeat.o(98175);
    return i;
  }
  
  protected final boolean fUN()
  {
    AppMethodBeat.i(98184);
    com.tencent.mm.kernel.h.aHH();
    if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
    {
      w.g(this.iXq, null);
      AppMethodBeat.o(98184);
      return false;
    }
    if (this.KIw.KIH.size() >= 9)
    {
      com.tencent.mm.ui.base.h.p(this.iXq, i.j.sns_upload_litmit, i.j.app_tip);
      AppMethodBeat.o(98184);
      return false;
    }
    try
    {
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.iXq, 1, false);
      locale.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(98160);
          if (!ac.mGL) {
            paramAnonymouso.d(0, as.this.iXq.getString(i.j.app_field_mmsight));
          }
          paramAnonymouso.d(1, as.this.iXq.getString(i.j.app_field_select_new_pic));
          AppMethodBeat.o(98160);
        }
      };
      locale.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          boolean bool1 = true;
          AppMethodBeat.i(98161);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(98161);
            return;
          case 0: 
            as.this.fUO();
            AppMethodBeat.o(98161);
            return;
          }
          int i = 9 - as.this.KIw.KIH.size();
          if (i <= 0)
          {
            Log.e("MicroMsg.PicWidget", "has select the max image count");
            AppMethodBeat.o(98161);
            return;
          }
          paramAnonymousMenuItem = as.this.iXq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
          long l = cm.bfD();
          com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), t.fNp(), Long.valueOf(l) });
          if (paramAnonymousMenuItem.equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.u.bd(as.this.iXq);
          }
          for (;;)
          {
            as.this.agP(2);
            break;
            if (i >= 9) {
              break label231;
            }
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("key_can_select_video_and_pic", true);
            com.tencent.mm.pluginsdk.ui.tools.u.a(as.this.iXq, 9, i, 4, 1, paramAnonymousMenuItem);
          }
          label231:
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.bkp().bks().duration);
          boolean bool2 = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGB, false);
          if ((com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vut, 0) == 1) || (bool2))
          {
            paramAnonymousInt = 1;
            label298:
            if (paramAnonymousInt != 0) {
              break label335;
            }
          }
          for (;;)
          {
            paramAnonymousMenuItem.putExtra("key_can_select_video_and_pic", bool1);
            com.tencent.mm.pluginsdk.ui.tools.u.a(as.this.iXq, 9, i, 4, 3, paramAnonymousMenuItem);
            break;
            paramAnonymousInt = 0;
            break label298;
            label335:
            bool1 = false;
          }
        }
      };
      locale.eik();
      label114:
      AppMethodBeat.o(98184);
      return true;
    }
    catch (Exception localException)
    {
      break label114;
    }
  }
  
  public final void fUO()
  {
    AppMethodBeat.i(255452);
    int i = 9 - this.KIw.KIH.size();
    if (i <= 0)
    {
      Log.e("MicroMsg.PicWidget", "has select the max image count");
      AppMethodBeat.o(255452);
      return;
    }
    Object localObject1 = new SightParams(2, 0);
    com.tencent.mm.modelvideo.s.bqA();
    Object localObject2 = com.tencent.mm.plugin.mmsight.d.aPt(com.tencent.mm.modelvideo.s.getAccVideoPath());
    localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.mmsight.d.aPv((String)localObject2), ((SightParams)localObject1).lgX, ((SightParams)localObject1).lgX.duration * 1000, 2);
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFL, false)) {
      ((RecordConfigProvider)localObject1).remuxType = 2;
    }
    localObject2 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject2).wwk = 7;
    ((RecordConfigProvider)localObject1).HLk = ((VideoCaptureReportInfo)localObject2);
    localObject2 = new as.8(this);
    long l = cm.bfD();
    if (i < 9)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), t.fNp(), Long.valueOf(l) });
      ((RecordConfigProvider)localObject1).HKY = Boolean.FALSE;
      CaptureDataManager.HKJ.HKI = ((CaptureDataManager.b)localObject2);
      if (!((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFJ, true)) {
        break label317;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(this.iXq, 11, i.a.sight_slide_bottom_in, i.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
    }
    for (;;)
    {
      agP(1);
      AppMethodBeat.o(255452);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), t.fNp(), Long.valueOf(l) });
      break;
      label317:
      if (i < 9)
      {
        localObject1 = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.u.a(this.iXq, 11, (Intent)localObject1, 2, 2);
      }
      else
      {
        localObject1 = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.u.a(this.iXq, 11, (Intent)localObject1, 2, 0);
      }
    }
  }
  
  public final Map<String, Boolean> fUP()
  {
    AppMethodBeat.i(98189);
    Object localObject = new HashMap();
    if ((this.KIw != null) && (!this.KIw.KIH.isEmpty()))
    {
      Iterator localIterator = this.KIw.KIH.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((Boolean)this.KIw.KII.get(str) != null) {
          ((Map)localObject).put(str, this.KIw.KII.get(str));
        }
      }
    }
    if (this.KIw != null)
    {
      localObject = this.KIw.KII;
      AppMethodBeat.o(98189);
      return localObject;
    }
    AppMethodBeat.o(98189);
    return null;
  }
  
  /* Error */
  public boolean k(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1150
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+53 -> 60, 2:+61->68, 3:+163->170, 4:+1360->1367, 5:+53->60, 6:+53->60, 7:+1740->1747, 8:+53->60, 9:+485->492, 10:+53->60, 11:+1126->1133
    //   61: iconst_1
    //   62: iand
    //   63: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iconst_0
    //   67: ireturn
    //   68: ldc 164
    //   70: ldc_w 1152
    //   73: invokestatic 820	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_2
    //   77: ifnonnull +11 -> 88
    //   80: ldc_w 1150
    //   83: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_0
    //   87: ireturn
    //   88: ldc 164
    //   90: ldc_w 1154
    //   93: invokestatic 820	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 248	android/content/Intent
    //   99: dup
    //   100: invokespecial 249	android/content/Intent:<init>	()V
    //   103: astore 4
    //   105: aload 4
    //   107: ldc_w 1156
    //   110: iconst_4
    //   111: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload 4
    //   117: ldc_w 1158
    //   120: iconst_1
    //   121: invokevirtual 1161	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   124: pop
    //   125: aload 4
    //   127: ldc_w 1163
    //   130: iconst_1
    //   131: invokevirtual 1161	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   134: pop
    //   135: getstatic 1167	com/tencent/mm/plugin/sns/c/a:mIG	Lcom/tencent/mm/pluginsdk/m;
    //   138: aload_0
    //   139: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   142: aload_2
    //   143: aload 4
    //   145: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   148: iconst_4
    //   149: new 20	com/tencent/mm/plugin/sns/ui/as$7
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 1168	com/tencent/mm/plugin/sns/ui/as$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/as;)V
    //   157: invokeinterface 1173 7 0
    //   162: ldc_w 1150
    //   165: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_1
    //   169: ireturn
    //   170: ldc 164
    //   172: ldc_w 1175
    //   175: invokestatic 820	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   182: invokevirtual 1179	com/tencent/mm/ui/MMActivity:getApplicationContext	()Landroid/content/Context;
    //   185: aload_2
    //   186: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   189: invokestatic 1182	com/tencent/mm/pluginsdk/ui/tools/u:g	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_2
    //   193: aload_2
    //   194: ifnonnull +11 -> 205
    //   197: ldc_w 1150
    //   200: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iconst_1
    //   204: ireturn
    //   205: new 248	android/content/Intent
    //   208: dup
    //   209: invokespecial 249	android/content/Intent:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: ldc_w 1156
    //   219: iconst_4
    //   220: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   223: pop
    //   224: aload 4
    //   226: ldc_w 1163
    //   229: iconst_1
    //   230: invokevirtual 1161	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   233: pop
    //   234: aload 4
    //   236: ldc_w 1158
    //   239: iconst_1
    //   240: invokevirtual 1161	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   243: pop
    //   244: aload 4
    //   246: ldc_w 1184
    //   249: aload_2
    //   250: invokevirtual 1187	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   253: pop
    //   254: new 578	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   261: aload_2
    //   262: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokestatic 765	java/lang/System:currentTimeMillis	()J
    //   268: invokevirtual 616	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 769	java/lang/String:getBytes	()[B
    //   277: invokestatic 775	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   280: astore 5
    //   282: aload 4
    //   284: ldc_w 1189
    //   287: new 578	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   294: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   297: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 5
    //   302: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 1187	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   311: pop
    //   312: aload_2
    //   313: invokestatic 829	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   316: invokevirtual 833	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   319: astore 6
    //   321: aload 6
    //   323: ifnull +70 -> 393
    //   326: aload_0
    //   327: getfield 84	com/tencent/mm/plugin/sns/ui/as:KIy	Ljava/util/Map;
    //   330: new 578	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   337: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   340: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 5
    //   345: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: aload 6
    //   353: invokeinterface 193 3 0
    //   358: pop
    //   359: ldc 164
    //   361: ldc_w 1191
    //   364: iconst_2
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload 6
    //   372: getfield 564	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   375: invokestatic 890	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: aload 6
    //   383: getfield 567	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   386: invokestatic 890	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   389: aastore
    //   390: invokestatic 1193	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: new 536	com/tencent/mm/protocal/protobuf/eks
    //   396: dup
    //   397: invokespecial 537	com/tencent/mm/protocal/protobuf/eks:<init>	()V
    //   400: astore 6
    //   402: aload 6
    //   404: iconst_1
    //   405: putfield 626	com/tencent/mm/protocal/protobuf/eks:UmG	I
    //   408: aload 6
    //   410: invokestatic 765	java/lang/System:currentTimeMillis	()J
    //   413: putfield 621	com/tencent/mm/protocal/protobuf/eks:UmI	J
    //   416: aload 6
    //   418: aload_2
    //   419: invokestatic 829	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   422: getfield 1196	com/tencent/mm/compatible/util/Exif:dateTime	Ljava/lang/String;
    //   425: invokestatic 1199	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   428: putfield 613	com/tencent/mm/protocal/protobuf/eks:UmH	J
    //   431: aload_0
    //   432: getfield 86	com/tencent/mm/plugin/sns/ui/as:KIz	Ljava/util/Map;
    //   435: new 578	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   442: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   445: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 5
    //   450: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: aload 6
    //   458: invokeinterface 193 3 0
    //   463: pop
    //   464: getstatic 1167	com/tencent/mm/plugin/sns/c/a:mIG	Lcom/tencent/mm/pluginsdk/m;
    //   467: aload_0
    //   468: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   471: aload 4
    //   473: iconst_4
    //   474: invokeinterface 1202 4 0
    //   479: aload_0
    //   480: iconst_1
    //   481: putfield 79	com/tencent/mm/plugin/sns/ui/as:KGr	Z
    //   484: ldc_w 1150
    //   487: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: iconst_1
    //   491: ireturn
    //   492: aload_2
    //   493: ldc_w 1204
    //   496: invokevirtual 727	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   499: astore 4
    //   501: aload 4
    //   503: ifnull +131 -> 634
    //   506: aload 4
    //   508: ldc_w 1206
    //   511: invokevirtual 1209	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   514: ifnull +120 -> 634
    //   517: aload 4
    //   519: ldc_w 1211
    //   522: invokevirtual 1209	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   525: ifnull +109 -> 634
    //   528: ldc 164
    //   530: ldc_w 1213
    //   533: invokestatic 633	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload_0
    //   537: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   540: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   543: invokevirtual 790	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   546: invokevirtual 1214	android/os/Bundle:clear	()V
    //   549: aload_0
    //   550: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   553: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   556: ldc_w 693
    //   559: iconst_0
    //   560: invokevirtual 1161	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   563: pop
    //   564: aload_0
    //   565: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   568: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   571: ldc_w 1216
    //   574: iconst_1
    //   575: invokevirtual 1161	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   578: pop
    //   579: aload_0
    //   580: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   583: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   586: ldc_w 1218
    //   589: bipush 14
    //   591: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   594: pop
    //   595: aload_0
    //   596: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   599: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   602: ldc_w 1204
    //   605: aload_2
    //   606: ldc_w 1204
    //   609: invokevirtual 727	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   612: invokevirtual 1221	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   615: pop
    //   616: aload_0
    //   617: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   620: checkcast 1223	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   623: invokevirtual 1226	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   626: ldc_w 1150
    //   629: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   632: iconst_1
    //   633: ireturn
    //   634: aload_2
    //   635: ldc_w 1228
    //   638: invokevirtual 806	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   641: astore 4
    //   643: aload 4
    //   645: ifnull +11 -> 656
    //   648: aload 4
    //   650: invokevirtual 237	java/util/ArrayList:size	()I
    //   653: ifgt +16 -> 669
    //   656: aload_2
    //   657: ldc_w 1230
    //   660: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokestatic 352	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   666: ifne +393 -> 1059
    //   669: aload 4
    //   671: ifnull +126 -> 797
    //   674: aload 4
    //   676: invokevirtual 237	java/util/ArrayList:size	()I
    //   679: ifle +118 -> 797
    //   682: aload 4
    //   684: iconst_0
    //   685: invokevirtual 1233	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   688: checkcast 156	java/lang/String
    //   691: astore 4
    //   693: aload_2
    //   694: ldc_w 1235
    //   697: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   700: astore 6
    //   702: aload 6
    //   704: invokestatic 352	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   707: ifne +15 -> 722
    //   710: aload 6
    //   712: astore 5
    //   714: aload 6
    //   716: invokestatic 908	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   719: ifne +184 -> 903
    //   722: new 578	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   729: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   732: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 4
    //   737: invokestatic 1238	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   740: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: astore 5
    //   748: new 1240	com/tencent/mm/compatible/i/d
    //   751: dup
    //   752: invokespecial 1241	com/tencent/mm/compatible/i/d:<init>	()V
    //   755: astore 6
    //   757: aload 6
    //   759: aload 4
    //   761: invokevirtual 1246	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   764: aload 6
    //   766: lconst_0
    //   767: invokevirtual 1250	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   770: astore 7
    //   772: aload 7
    //   774: ifnonnull +35 -> 809
    //   777: ldc 164
    //   779: ldc_w 1252
    //   782: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload 6
    //   787: invokevirtual 1255	android/media/MediaMetadataRetriever:release	()V
    //   790: goto -730 -> 60
    //   793: astore_2
    //   794: goto -734 -> 60
    //   797: aload_2
    //   798: ldc_w 1230
    //   801: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   804: astore 4
    //   806: goto -113 -> 693
    //   809: ldc 164
    //   811: ldc_w 1257
    //   814: iconst_2
    //   815: anewarray 4	java/lang/Object
    //   818: dup
    //   819: iconst_0
    //   820: aload 7
    //   822: invokevirtual 1262	android/graphics/Bitmap:getWidth	()I
    //   825: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: aastore
    //   829: dup
    //   830: iconst_1
    //   831: aload 7
    //   833: invokevirtual 1265	android/graphics/Bitmap:getHeight	()I
    //   836: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   839: aastore
    //   840: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   843: aload 7
    //   845: bipush 80
    //   847: getstatic 1271	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   850: aload 5
    //   852: iconst_1
    //   853: invokestatic 1277	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   856: pop
    //   857: aload 5
    //   859: invokestatic 1281	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   862: astore 7
    //   864: ldc 164
    //   866: ldc_w 1283
    //   869: iconst_2
    //   870: anewarray 4	java/lang/Object
    //   873: dup
    //   874: iconst_0
    //   875: aload 7
    //   877: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   880: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: aload 7
    //   888: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   891: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   894: aastore
    //   895: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   898: aload 6
    //   900: invokevirtual 1255	android/media/MediaMetadataRetriever:release	()V
    //   903: ldc 164
    //   905: ldc_w 1293
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
    //   926: invokestatic 529	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   929: invokestatic 534	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   932: aastore
    //   933: dup
    //   934: iconst_3
    //   935: aload 5
    //   937: invokestatic 529	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   940: invokestatic 534	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   943: aastore
    //   944: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: aload 4
    //   949: invokestatic 1238	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   952: astore 6
    //   954: aload_0
    //   955: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   958: instanceof 1223
    //   961: ifeq +41 -> 1002
    //   964: aload_2
    //   965: ldc_w 1295
    //   968: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   971: invokestatic 1298	com/tencent/mm/plugin/sns/data/t:aZv	(Ljava/lang/String;)V
    //   974: aload_0
    //   975: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   978: checkcast 1223	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   981: aload 4
    //   983: aload 5
    //   985: aload 6
    //   987: aconst_null
    //   988: iconst_0
    //   989: invokevirtual 1301	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   992: aload_0
    //   993: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   996: checkcast 1223	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   999: invokevirtual 1226	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   1002: ldc_w 1150
    //   1005: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1008: iconst_1
    //   1009: ireturn
    //   1010: astore 7
    //   1012: ldc 164
    //   1014: ldc_w 1303
    //   1017: iconst_1
    //   1018: anewarray 4	java/lang/Object
    //   1021: dup
    //   1022: iconst_0
    //   1023: aload 7
    //   1025: invokevirtual 849	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1028: aastore
    //   1029: invokestatic 1305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1032: aload 6
    //   1034: invokevirtual 1255	android/media/MediaMetadataRetriever:release	()V
    //   1037: goto -134 -> 903
    //   1040: astore 6
    //   1042: goto -139 -> 903
    //   1045: astore_2
    //   1046: aload 6
    //   1048: invokevirtual 1255	android/media/MediaMetadataRetriever:release	()V
    //   1051: ldc_w 1150
    //   1054: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1057: aload_2
    //   1058: athrow
    //   1059: aload_2
    //   1060: ldc_w 1307
    //   1063: invokevirtual 806	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1066: astore 4
    //   1068: aload_2
    //   1069: ldc_w 1309
    //   1072: iconst_0
    //   1073: invokevirtual 717	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1076: istore_1
    //   1077: aload_2
    //   1078: ldc_w 1311
    //   1081: iconst_0
    //   1082: invokevirtual 697	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1085: istore_3
    //   1086: ldc_w 1057
    //   1089: invokestatic 1061	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1092: checkcast 1057	com/tencent/mm/plugin/expt/b/b
    //   1095: getstatic 1314	com/tencent/mm/plugin/expt/b/b$a:vGi	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   1098: iconst_1
    //   1099: invokeinterface 1070 3 0
    //   1104: ifeq +12 -> 1116
    //   1107: getstatic 918	com/tencent/mm/plugin/recordvideo/e/d:IeU	Lcom/tencent/mm/plugin/recordvideo/e/d;
    //   1110: astore_2
    //   1111: aload 4
    //   1113: invokestatic 1318	com/tencent/mm/plugin/recordvideo/e/d:aS	(Ljava/util/ArrayList;)V
    //   1116: aload_0
    //   1117: aload 4
    //   1119: iload_1
    //   1120: iload_3
    //   1121: invokevirtual 1320	com/tencent/mm/plugin/sns/ui/as:c	(Ljava/util/List;IZ)Z
    //   1124: istore_3
    //   1125: ldc_w 1150
    //   1128: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1131: iload_3
    //   1132: ireturn
    //   1133: aload_2
    //   1134: ldc_w 1322
    //   1137: invokevirtual 1326	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1140: checkcast 1328	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   1143: astore 5
    //   1145: aload 5
    //   1147: ifnull -1087 -> 60
    //   1150: aload 5
    //   1152: getfield 1331	com/tencent/mm/plugin/mmsight/SightCaptureResult:EXZ	Z
    //   1155: ifeq +65 -> 1220
    //   1158: aload 5
    //   1160: getfield 1334	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYh	Ljava/lang/String;
    //   1163: astore_2
    //   1164: aload_2
    //   1165: invokestatic 352	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1168: ifne -1108 -> 60
    //   1171: ldc_w 1057
    //   1174: invokestatic 1061	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1177: checkcast 1057	com/tencent/mm/plugin/expt/b/b
    //   1180: getstatic 1314	com/tencent/mm/plugin/expt/b/b$a:vGi	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   1183: iconst_1
    //   1184: invokeinterface 1070 3 0
    //   1189: ifeq +12 -> 1201
    //   1192: getstatic 918	com/tencent/mm/plugin/recordvideo/e/d:IeU	Lcom/tencent/mm/plugin/recordvideo/e/d;
    //   1195: astore 4
    //   1197: aload_2
    //   1198: invokestatic 1337	com/tencent/mm/plugin/recordvideo/e/d:aWi	(Ljava/lang/String;)V
    //   1201: aload_0
    //   1202: aload_2
    //   1203: invokestatic 1343	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   1206: iconst_0
    //   1207: iconst_1
    //   1208: invokevirtual 1320	com/tencent/mm/plugin/sns/ui/as:c	(Ljava/util/List;IZ)Z
    //   1211: istore_3
    //   1212: ldc_w 1150
    //   1215: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1218: iload_3
    //   1219: ireturn
    //   1220: aload 5
    //   1222: getfield 1346	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYb	Ljava/lang/String;
    //   1225: astore 6
    //   1227: aload 5
    //   1229: getfield 1349	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYc	Ljava/lang/String;
    //   1232: astore 7
    //   1234: aconst_null
    //   1235: astore 4
    //   1237: aload_0
    //   1238: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1241: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1244: ldc_w 1351
    //   1247: aload 5
    //   1249: getfield 1349	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYc	Ljava/lang/String;
    //   1252: invokevirtual 1187	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1255: pop
    //   1256: aload 5
    //   1258: getfield 1354	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYe	Ljava/lang/String;
    //   1261: invokestatic 352	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1264: ifne +69 -> 1333
    //   1267: aload 5
    //   1269: getfield 1354	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYe	Ljava/lang/String;
    //   1272: astore_2
    //   1273: aload 5
    //   1275: getfield 1358	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYg	Lcom/tencent/mm/protocal/protobuf/cuv;
    //   1278: invokevirtual 1363	com/tencent/mm/protocal/protobuf/cuv:toByteArray	()[B
    //   1281: astore 5
    //   1283: aload 5
    //   1285: astore 4
    //   1287: aload_0
    //   1288: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1291: instanceof 1223
    //   1294: ifeq +31 -> 1325
    //   1297: aload_0
    //   1298: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1301: checkcast 1223	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1304: aload 6
    //   1306: aload 7
    //   1308: aload_2
    //   1309: aload 4
    //   1311: iconst_1
    //   1312: invokevirtual 1301	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   1315: aload_0
    //   1316: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1319: checkcast 1223	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1322: invokevirtual 1226	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   1325: ldc_w 1150
    //   1328: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1331: iconst_1
    //   1332: ireturn
    //   1333: aload 6
    //   1335: invokestatic 1238	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   1338: astore_2
    //   1339: goto -66 -> 1273
    //   1342: astore 5
    //   1344: ldc 164
    //   1346: ldc_w 1365
    //   1349: iconst_1
    //   1350: anewarray 4	java/lang/Object
    //   1353: dup
    //   1354: iconst_0
    //   1355: aload 5
    //   1357: invokevirtual 849	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1360: aastore
    //   1361: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1364: goto -77 -> 1287
    //   1367: ldc 164
    //   1369: ldc_w 1367
    //   1372: invokestatic 820	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload_2
    //   1376: ifnonnull +11 -> 1387
    //   1379: ldc_w 1150
    //   1382: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1385: iconst_1
    //   1386: ireturn
    //   1387: aload_2
    //   1388: ldc_w 1189
    //   1391: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1394: astore 4
    //   1396: ldc 164
    //   1398: ldc_w 1369
    //   1401: aload 4
    //   1403: invokestatic 814	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1406: invokevirtual 817	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1409: invokestatic 820	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1412: aload 4
    //   1414: ifnonnull +11 -> 1425
    //   1417: ldc_w 1150
    //   1420: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1423: iconst_1
    //   1424: ireturn
    //   1425: aload 4
    //   1427: invokestatic 908	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   1430: ifne +11 -> 1441
    //   1433: ldc_w 1150
    //   1436: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1439: iconst_1
    //   1440: ireturn
    //   1441: aload_0
    //   1442: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1445: getfield 223	com/tencent/mm/plugin/sns/ui/as$b:KIH	Ljava/util/ArrayList;
    //   1448: invokevirtual 237	java/util/ArrayList:size	()I
    //   1451: bipush 9
    //   1453: if_icmplt +11 -> 1464
    //   1456: ldc_w 1150
    //   1459: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1462: iconst_1
    //   1463: ireturn
    //   1464: aload_2
    //   1465: ldc_w 1309
    //   1468: iconst_0
    //   1469: invokevirtual 717	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1472: istore_1
    //   1473: new 578	java/lang/StringBuilder
    //   1476: dup
    //   1477: ldc_w 851
    //   1480: invokespecial 582	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1483: new 578	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   1490: aload 4
    //   1492: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokestatic 765	java/lang/System:currentTimeMillis	()J
    //   1498: invokevirtual 616	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1501: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: invokevirtual 769	java/lang/String:getBytes	()[B
    //   1507: invokestatic 775	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   1510: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: astore_2
    //   1517: ldc 164
    //   1519: new 578	java/lang/StringBuilder
    //   1522: dup
    //   1523: ldc_w 1371
    //   1526: invokespecial 582	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1529: aload 4
    //   1531: invokestatic 529	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   1534: invokevirtual 616	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1537: ldc_w 602
    //   1540: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload 4
    //   1545: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 633	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload 4
    //   1556: new 578	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   1563: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   1566: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload_2
    //   1570: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokestatic 861	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1579: pop2
    //   1580: aload_0
    //   1581: getfield 84	com/tencent/mm/plugin/sns/ui/as:KIy	Ljava/util/Map;
    //   1584: aload 4
    //   1586: invokeinterface 335 2 0
    //   1591: ifeq +44 -> 1635
    //   1594: aload_0
    //   1595: getfield 84	com/tencent/mm/plugin/sns/ui/as:KIy	Ljava/util/Map;
    //   1598: new 578	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   1605: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   1608: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload_2
    //   1612: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: aload_0
    //   1619: getfield 84	com/tencent/mm/plugin/sns/ui/as:KIy	Ljava/util/Map;
    //   1622: aload 4
    //   1624: invokeinterface 339 2 0
    //   1629: invokeinterface 193 3 0
    //   1634: pop
    //   1635: new 578	java/lang/StringBuilder
    //   1638: dup
    //   1639: invokespecial 756	java/lang/StringBuilder:<init>	()V
    //   1642: invokestatic 759	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   1645: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: aload_2
    //   1649: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: astore_2
    //   1656: ldc 164
    //   1658: ldc_w 811
    //   1661: aload_2
    //   1662: invokestatic 814	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1665: invokevirtual 817	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1668: invokestatic 820	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1671: aload_0
    //   1672: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1675: aload_2
    //   1676: iload_1
    //   1677: iconst_0
    //   1678: invokevirtual 823	com/tencent/mm/plugin/sns/ui/as$b:x	(Ljava/lang/String;IZ)Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1681: pop
    //   1682: aload_0
    //   1683: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1686: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1689: ldc_w 800
    //   1692: aload_0
    //   1693: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1696: getfield 223	com/tencent/mm/plugin/sns/ui/as$b:KIH	Ljava/util/ArrayList;
    //   1699: invokevirtual 927	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1702: pop
    //   1703: aload_0
    //   1704: getfield 279	com/tencent/mm/plugin/sns/ui/as:KIx	Lcom/tencent/mm/plugin/sns/ui/ab;
    //   1707: checkcast 283	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1710: aload_0
    //   1711: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1714: getfield 223	com/tencent/mm/plugin/sns/ui/as$b:KIH	Ljava/util/ArrayList;
    //   1717: invokevirtual 237	java/util/ArrayList:size	()I
    //   1720: invokevirtual 924	com/tencent/mm/plugin/sns/ui/previewimageview/e:ahC	(I)V
    //   1723: aload_0
    //   1724: getfield 279	com/tencent/mm/plugin/sns/ui/as:KIx	Lcom/tencent/mm/plugin/sns/ui/ab;
    //   1727: aload_0
    //   1728: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1731: getfield 223	com/tencent/mm/plugin/sns/ui/as$b:KIH	Ljava/util/ArrayList;
    //   1734: invokeinterface 295 2 0
    //   1739: ldc_w 1150
    //   1742: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1745: iconst_1
    //   1746: ireturn
    //   1747: aload_2
    //   1748: ifnonnull +11 -> 1759
    //   1751: ldc_w 1150
    //   1754: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1757: iconst_1
    //   1758: ireturn
    //   1759: aload_0
    //   1760: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1763: aload_2
    //   1764: ldc_w 1373
    //   1767: invokevirtual 806	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1770: invokevirtual 1376	com/tencent/mm/plugin/sns/ui/as$b:be	(Ljava/util/ArrayList;)V
    //   1773: aload_0
    //   1774: getfield 106	com/tencent/mm/plugin/sns/ui/as:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1777: invokevirtual 687	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1780: ldc_w 800
    //   1783: aload_0
    //   1784: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1787: getfield 223	com/tencent/mm/plugin/sns/ui/as$b:KIH	Ljava/util/ArrayList;
    //   1790: invokevirtual 927	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1793: pop
    //   1794: aload_0
    //   1795: getfield 279	com/tencent/mm/plugin/sns/ui/as:KIx	Lcom/tencent/mm/plugin/sns/ui/ab;
    //   1798: checkcast 283	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1801: aload_0
    //   1802: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1805: getfield 223	com/tencent/mm/plugin/sns/ui/as$b:KIH	Ljava/util/ArrayList;
    //   1808: invokevirtual 237	java/util/ArrayList:size	()I
    //   1811: invokevirtual 924	com/tencent/mm/plugin/sns/ui/previewimageview/e:ahC	(I)V
    //   1814: aload_0
    //   1815: getfield 279	com/tencent/mm/plugin/sns/ui/as:KIx	Lcom/tencent/mm/plugin/sns/ui/ab;
    //   1818: aload_0
    //   1819: getfield 77	com/tencent/mm/plugin/sns/ui/as:KIw	Lcom/tencent/mm/plugin/sns/ui/as$b;
    //   1822: getfield 223	com/tencent/mm/plugin/sns/ui/as$b:KIH	Ljava/util/ArrayList;
    //   1825: invokeinterface 295 2 0
    //   1830: aload_0
    //   1831: aload_2
    //   1832: ldc_w 1378
    //   1835: iconst_0
    //   1836: invokevirtual 717	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1839: putfield 88	com/tencent/mm/plugin/sns/ui/as:KIA	I
    //   1842: ldc_w 1150
    //   1845: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1848: iconst_1
    //   1849: ireturn
    //   1850: astore 6
    //   1852: goto -949 -> 903
    //   1855: astore 4
    //   1857: goto -806 -> 1051
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1860	0	this	as
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
    private be KGE;
    private List<com.tencent.mm.plugin.sns.data.s> KIE;
    private ProgressDialog iXX;
    
    public a(List<com.tencent.mm.plugin.sns.data.s> paramList)
    {
      AppMethodBeat.i(98164);
      this.iXX = null;
      this.KGE = paramList;
      Object localObject;
      this.KIE = localObject;
      paramList = as.this.iXq;
      as.this.iXq.getString(i.j.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(paramList, as.this.iXq.getString(i.j.app_loading_data), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      AppMethodBeat.o(98164);
    }
    
    public final ExecutorService fsl()
    {
      AppMethodBeat.i(179157);
      ExecutorService localExecutorService = aj.fOv();
      AppMethodBeat.o(179157);
      return localExecutorService;
    }
  }
  
  final class b
  {
    ArrayList<String> KIH;
    Map<String, Boolean> KII;
    Map<String, Integer> KIJ;
    
    b()
    {
      AppMethodBeat.i(98168);
      this.KIH = new ArrayList();
      this.KII = new HashMap();
      this.KIJ = new HashMap();
      AppMethodBeat.o(98168);
    }
    
    public final b bbY(String paramString)
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
          this.KIH.add(arrayOfString[0]);
          this.KIJ.put(arrayOfString[0], Integer.valueOf(Util.getInt(arrayOfString[1], 0)));
          i += 1;
        }
        return this;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(98172);
      }
    }
    
    public final void be(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(98170);
      this.KII.clear();
      if (paramArrayList == null)
      {
        this.KIH = new ArrayList();
        AppMethodBeat.o(98170);
        return;
      }
      this.KIH = paramArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.KII.put(str, Boolean.FALSE);
      }
      AppMethodBeat.o(98170);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(98171);
      Iterator localIterator = this.KIH.iterator();
      String str2;
      int i;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "," + i + ";")
      {
        str2 = (String)localIterator.next();
        i = 0;
        if (this.KIJ != null) {
          i = ((Integer)this.KIJ.get(str2)).intValue();
        }
      }
      AppMethodBeat.o(98171);
      return str1;
    }
    
    public final b x(String paramString, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(98169);
      this.KIH.add(paramString);
      this.KIJ.put(paramString, Integer.valueOf(paramInt));
      this.KII.put(paramString, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(98169);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as
 * JD-Core Version:    0.7.0.1
 */