package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wa;
import com.tencent.mm.f.a.wa.b;
import com.tencent.mm.f.b.a.kp;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.e.e.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.f.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.QImageView.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class an
  implements af, a.a
{
  private int JRv;
  private List<String> KBI;
  private int KCP;
  private l KCV;
  private String KCW;
  private boolean KEH;
  private boolean KEI;
  private WXMediaMessage KEJ;
  boolean KGA;
  private boolean KGB;
  com.tencent.mm.plugin.sns.ui.f.a KGC;
  private com.tencent.mm.ad.i KGD;
  be KGE;
  private int KGF;
  private int KGG;
  private org.b.d.i KGH;
  private String KGI;
  private cst KGJ;
  private int KGK;
  private List<String> KGL;
  private PInt KGM;
  private int KGN;
  private int KGO;
  Runnable KGP;
  Runnable KGQ;
  SightPlayImageView KGl;
  private ImageView KGm;
  boolean KGn;
  private Bitmap KGo;
  private cuv KGp;
  private String KGq;
  private boolean KGr;
  boolean KGs;
  private int KGt;
  private MediaMetadataRetriever KGu;
  private int KGv;
  private int KGw;
  private int KGx;
  private Pair<Integer, Integer> KGy;
  private Bitmap KGz;
  private int Kcp;
  private boolean Kfo;
  private String appId;
  private String appName;
  private View bvK;
  private String canvasInfo;
  String desc;
  private boolean fzO;
  ProgressDialog iXX;
  MMActivity iXq;
  private LinkedList<Long> jJE;
  String lmm;
  private String mSessionId;
  String md5;
  private com.tencent.mm.ui.base.s oTk;
  String smT;
  String thumbPath;
  String videoPath;
  private IListener xyI;
  
  public an(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97999);
    this.bvK = null;
    this.KGm = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.fzO = false;
    this.KGn = false;
    this.KGo = null;
    this.KCV = null;
    this.KGp = new cuv();
    this.KEH = false;
    this.KEI = false;
    this.KEJ = null;
    this.KGr = false;
    this.KGs = false;
    this.KGt = 0;
    this.KGu = new com.tencent.mm.compatible.i.d();
    this.KGv = 0;
    this.KGw = 0;
    this.KGx = 90;
    this.KGy = null;
    this.KGz = null;
    this.KGA = false;
    this.KGB = false;
    this.Kcp = 1;
    this.KCW = "";
    this.xyI = new IListener() {};
    this.KGE = null;
    this.KGF = 0;
    this.desc = "";
    this.iXX = null;
    this.KGP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97993);
        an.a(an.this);
        AppMethodBeat.o(97993);
      }
    };
    this.KGQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97995);
        Log.i("MicroMsg.SightWidget", "showProgress");
        an localan = an.this;
        MMActivity localMMActivity = an.this.iXq;
        an.this.iXq.getString(i.j.app_tip);
        localan.iXX = com.tencent.mm.ui.base.h.a(localMMActivity, an.this.iXq.getString(i.j.sns_sight_send_wait), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(97994);
            an.this.KGE = null;
            an.this.KGn = false;
            MMHandlerThread.removeRunnable(an.this.KGP);
            AppMethodBeat.o(97994);
          }
        });
        AppMethodBeat.o(97995);
      }
    };
    this.iXq = paramMMActivity;
    this.KGC = new com.tencent.mm.plugin.sns.ui.f.a(paramMMActivity, this);
    AppMethodBeat.o(97999);
  }
  
  private void A(String paramString, Object paramObject)
  {
    AppMethodBeat.i(194143);
    if (this.KGD != null) {
      try
      {
        this.KGD.h(paramString, paramObject);
        AppMethodBeat.o(194143);
        return;
      }
      catch (com.tencent.mm.ad.g paramString)
      {
        Log.e("MicroMsg.SightWidget", "put SecondCut JSON Error");
      }
    }
    AppMethodBeat.o(194143);
  }
  
  private void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(98004);
    this.videoPath = "";
    this.thumbPath = "";
    this.KGs = paramBoolean;
    if (paramBoolean)
    {
      this.iXq.getIntent().putExtra("KSightThumbPath", this.thumbPath);
      this.iXq.getIntent().putExtra("KSightPath", this.videoPath);
    }
    this.iXq.getIntent().putExtra("KSightDeleted", this.KGs);
    this.KGx = 90;
    if (t.K(this.KGz))
    {
      this.KGz.recycle();
      this.KGz = null;
    }
    AppMethodBeat.o(98004);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98003);
    if (this.KGC.fZs())
    {
      this.oTk = com.tencent.mm.ui.base.h.a(this.iXq, this.iXq.getString(i.j.remux_loading_tips), true, null);
      this.KGG = paramInt1;
      this.JRv = paramInt2;
      this.KGH = parami;
      this.KGI = paramString1;
      this.KBI = paramList1;
      this.KGJ = paramcst;
      this.jJE = paramLinkedList;
      this.KGK = paramInt3;
      this.Kfo = paramBoolean;
      this.KGL = paramList2;
      this.KGM = paramPInt;
      this.canvasInfo = paramString2;
      this.KGN = paramInt4;
      this.KGO = paramInt5;
      ((SnsUploadUI)this.iXq).LdH = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (!com.tencent.mm.vfs.u.agG(this.videoPath))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97991);
          w.makeText(an.this.iXq, i.j.sendrequest_send_fail, 0).show();
          AppMethodBeat.o(97991);
        }
      });
      ((SnsUploadUI)this.iXq).LdH = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.KGE != null)
    {
      ((SnsUploadUI)this.iXq).LdH = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.KGn)
    {
      AppMethodBeat.o(98003);
      return true;
    }
    this.KGn = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          elm localelm = new elm();
          localelm.UserName = paramString2;
          parami.add(localelm);
        }
      }
    }
    this.KGE = new be(15, this.iXq);
    paramPInt.value = this.KGE.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      this.KGE.afW(3);
    }
    paramString1 = this.KGE.bas(paramString1);
    new LinkedList();
    paramString1.a(paramcst).bL(parami).afZ(paramInt1).aga(paramInt2).hA(paramList2);
    if (paramBoolean) {
      this.KGE.agc(1);
    }
    for (;;)
    {
      this.KGE.ct(this.Kcp, this.KCW);
      this.KGE.hA(paramList2);
      this.KGE.agb(this.KCP);
      this.KGE.fWm = this.KGp;
      this.KGE.i(null, null, null, paramInt4, paramInt5);
      this.KGE.setSessionId(this.mSessionId);
      if (!Util.isNullOrNil(this.appId)) {
        this.KGE.bay(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        this.KGE.baz(Util.nullAs(this.appName, ""));
      }
      if (this.KEH) {
        this.KGE.agb(5);
      }
      if ((this.KEI) && (this.KEJ != null))
      {
        this.KGE.bat(this.KEJ.mediaTagName);
        this.KGE.aI(this.appId, this.KEJ.messageExt, this.KEJ.messageAction);
      }
      MMHandlerThread.postToMainThreadDelayed(this.KGQ, 700L);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97992);
          an localan = an.this;
          long l = System.currentTimeMillis();
          be localbe;
          String str4;
          Object localObject2;
          Object localObject1;
          String str1;
          String str2;
          String str3;
          Object localObject3;
          if ((!TextUtils.isEmpty(localan.smT)) && (!TextUtils.isEmpty(localan.lmm)))
          {
            localbe = localan.KGE;
            str4 = localan.videoPath;
            localObject2 = localan.thumbPath;
            localObject1 = localan.desc;
            str1 = localan.md5;
            str2 = localan.smT;
            str3 = localan.lmm;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.e.Ife;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.e.aWt(str4);
            if (localObject3 == null) {
              break label575;
            }
            Log.i("MicroMsg.UploadPackHelper", "addSightObjectByUrl commit video_info:".concat(String.valueOf(localObject3)));
          }
          label533:
          label559:
          label575:
          for (float f = ((e.a)localObject3).duration / 1000.0F;; f = 0.0F)
          {
            localObject3 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str4.getBytes());
            be.baC((String)localObject3);
            com.tencent.mm.vfs.u.on(str4, (String)localObject3);
            str4 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
            com.tencent.mm.vfs.u.on((String)localObject2, str4);
            localObject2 = be.b("", (String)localObject3, str4, str1, str2, str3);
            int i;
            if (localObject2 == null)
            {
              Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
              i = 0;
              if (i != 0) {
                break label533;
              }
              Log.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.u.bBQ(localan.videoPath) + " thumb: " + com.tencent.mm.vfs.u.bBQ(localan.thumbPath) + ",cdnUrl " + localan.smT + "cdnThubmUrl " + localan.lmm);
              MMHandlerThread.postToMainThread(new an.7(localan));
            }
            for (;;)
            {
              Log.i("MicroMsg.SightWidget", "removeRunnable showProgress");
              MMHandlerThread.removeRunnable(an.this.KGQ);
              if (an.this.KGE != null) {
                break label559;
              }
              AppMethodBeat.o(97992);
              return;
              ((cvt)localObject2).CMB = ((String)localObject1);
              if (Util.isNullOrNil(((cvt)localObject2).fwr)) {
                ((cvt)localObject2).fwr = ((String)localObject1);
              }
              ((cvt)localObject2).TDZ = f;
              localbe.Kck.ContentObj.Sqr.add(localObject2);
              localObject1 = new csn();
              ((csn)localObject1).TAo = ((cvt)localObject2).fWh;
              localbe.Kcl.TEc.add(localObject1);
              i = 1;
              break;
              if (!localan.KGE.I(localan.videoPath, localan.thumbPath, localan.desc, localan.md5))
              {
                Log.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.u.bBQ(localan.videoPath) + " thumb: " + com.tencent.mm.vfs.u.bBQ(localan.thumbPath));
                MMHandlerThread.postToMainThread(new an.8(localan));
              }
              else
              {
                Log.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            MMHandlerThread.postToMainThread(an.this.KGP);
            AppMethodBeat.o(97992);
            return;
          }
        }
      }, "sight_send_ready");
      AppMethodBeat.o(98003);
      return true;
      this.KGE.agc(0);
    }
  }
  
  final void agP(int paramInt)
  {
    AppMethodBeat.i(98007);
    kp localkp = new kp().amB();
    localkp.gOI = paramInt;
    localkp.BF(this.KGq).bpa();
    AppMethodBeat.o(98007);
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(98000);
    this.KCV = l.x(this.iXq.getIntent());
    this.smT = Util.nullAs(this.iXq.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.lmm = Util.nullAs(this.iXq.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.KEH = this.iXq.getIntent().getBooleanExtra("KThrid_app", false);
    this.KEI = this.iXq.getIntent().getBooleanExtra("KSnsAction", false);
    this.KGr = this.iXq.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.KGA = this.iXq.getIntent().getBooleanExtra("KBlockAdd", false);
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = Util.nullAs(this.iXq.getIntent().getStringExtra("reportSessionId"), "");
    this.KGq = this.iXq.getIntent().getStringExtra("KSessionID");
    this.KGB = this.iXq.getIntent().getBooleanExtra("KSnsUploadFromSkipCompress", false);
    Log.i("MicroMsg.SightWidget", "mIsFromSkipCompress:%s, appId:%s", new Object[] { Boolean.valueOf(this.KGB), this.appId });
    paramBundle = this.KGC;
    Object localObject1 = this.iXq;
    Log.i("MicroMsg.SnsFakeVLogHelper", "resetFakeData");
    Bundle localBundle = ((MMActivity)localObject1).getIntent().getBundleExtra("key_extra_data");
    if ((localBundle == null) || (localBundle.getByteArray("key_bg_generate_pb") == null) || (localBundle.getByteArray("key_bg_generate_extra_config") == null)) {}
    for (;;)
    {
      paramBundle = this.iXq.getIntent().getBundleExtra("Ksnsupload_timeline");
      if (paramBundle != null) {
        this.KEJ = new SendMessageToWX.Req(paramBundle).message;
      }
      this.thumbPath = this.iXq.getIntent().getStringExtra("KSightThumbPath");
      this.videoPath = this.iXq.getIntent().getStringExtra("KSightPath");
      this.KGs = this.iXq.getIntent().getBooleanExtra("KSightDeleted", false);
      this.md5 = this.iXq.getIntent().getStringExtra("sight_md5");
      paramBundle = this.iXq.getIntent().getByteArrayExtra("KMMSightExtInfo");
      if (paramBundle != null) {}
      try
      {
        this.KGp.parseFrom(paramBundle);
        if (this.KGp == null)
        {
          this.KGp = new cuv();
          this.KGp.TCA = this.KGr;
        }
        this.KGp.appid = this.mSessionId;
        this.KGp.TCE = this.KGB;
        this.KGp.TCF = this.appId;
        paramBundle = new wa();
        paramBundle.fVd.type = 2;
        EventCenter.instance.publish(paramBundle);
        if (Util.isNullOrNil(this.videoPath))
        {
          this.videoPath = Util.nullAs(paramBundle.fVe.fVi, "");
          Log.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
        }
        if (Util.isNullOrNil(this.md5))
        {
          paramBundle = Util.nullAs(paramBundle.fVe.fVg, "");
          this.md5 = paramBundle;
          Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
          EventCenter.instance.addListener(this.xyI);
          if (this.KGt != 0) {
            break label961;
          }
          aj.fOx();
          i = r.getScreenWidth();
          if (i != 0) {
            break label922;
          }
          AppMethodBeat.o(98000);
          return;
          localObject2 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightThumbPath");
          localObject3 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightPath");
          if ((com.tencent.mm.vfs.u.agG((String)localObject2)) && (com.tencent.mm.vfs.u.agG((String)localObject3)))
          {
            Log.i("MicroMsg.SnsFakeVLogHelper", "jump generate");
            continue;
          }
          Log.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper go bg generate");
          paramBundle.Iqp = false;
          localObject2 = com.tencent.mm.plugin.recordvideo.background.a.HGl;
          com.tencent.mm.plugin.recordvideo.background.a.a(7, paramBundle);
          localObject2 = localBundle.getByteArray("key_bg_generate_pb");
          localObject3 = localBundle.getByteArray("key_bg_generate_extra_config");
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          int i;
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            paramBundle.Lss = ((ajd)new ajd().parseFrom((byte[])localObject2));
            paramBundle.Lst = ((VideoMixer.MixConfig)localBundle.getParcelable("key_bg_generate_mix_config"));
            paramBundle.Lsu = ((ame)new ame().parseFrom((byte[])localObject3));
            label850:
            ((MMActivity)localObject1).getIntent().putExtra("KSightThumbPath", paramBundle.Lss.thumbPath);
            paramBundle = paramBundle.Lst;
            localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
            com.tencent.mm.plugin.recordvideo.background.e.a((byte[])localObject2, paramBundle, (byte[])localObject3, 7);
            break;
            paramBundle = paramBundle;
            Log.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
            continue;
            paramBundle = this.md5;
          }
          label922:
          this.KGt = ((i - this.iXq.getResources().getDimensionPixelSize(i.d.sns_upload_previewimg_view_margin) * 4 - this.iXq.getResources().getDimensionPixelSize(i.d.LargerPadding) * 2) / 3);
          label961:
          if (this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.Kcp = 1;
          }
          for (;;)
          {
            this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
            if ((this.KEH) && (this.appId.equals("wxa5e0de08d96cc09d")) && (this.KEJ != null)) {
              paramBundle = this.KEJ.messageExt;
            }
            try
            {
              this.KGD = new com.tencent.mm.ad.i(paramBundle);
              Log.i("MicroMsg.SightWidget", "SecondCut thumbPath: " + this.thumbPath + ">>cdnThumbPath:" + this.lmm + ">>videoPath:" + this.videoPath + ">>cdnPath:" + this.smT);
              AppMethodBeat.o(98000);
              return;
              this.Kcp = 0;
            }
            catch (com.tencent.mm.ad.g paramBundle)
            {
              for (;;)
              {
                Log.e("MicroMsg.SightWidget", "get SecondCut JSON Error");
              }
            }
          }
        }
        catch (IOException localIOException)
        {
          break label850;
        }
      }
    }
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(98002);
    this.videoPath = paramCaptureVideoNormalModel.videoPath;
    this.thumbPath = paramCaptureVideoNormalModel.thumbPath;
    this.iXq.getIntent().putExtra("KSightThumbPath", this.thumbPath);
    this.iXq.getIntent().putExtra("KSightPath", this.videoPath);
    this.md5 = com.tencent.mm.vfs.u.buc(paramCaptureVideoNormalModel.videoPath);
    if ((this.oTk != null) && (this.oTk.isShowing()))
    {
      this.oTk.dismiss();
      a(this.KGG, this.JRv, this.KGH, this.KGI, this.KBI, this.KGJ, this.jJE, this.KGK, this.Kfo, this.KGL, this.KGM, this.canvasInfo, this.KGN, this.KGO);
    }
    AppMethodBeat.o(98002);
  }
  
  public final boolean fTA()
  {
    AppMethodBeat.i(98006);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    EventCenter.instance.removeListener(this.xyI);
    if (t.K(this.KGo)) {
      this.KGo.recycle();
    }
    com.tencent.mm.plugin.sns.ui.f.a locala = this.KGC;
    Log.i("MicroMsg.SnsFakeVLogHelper", "release");
    com.tencent.mm.plugin.recordvideo.background.a locala1 = com.tencent.mm.plugin.recordvideo.background.a.HGl;
    com.tencent.mm.plugin.recordvideo.background.a.b(7, locala);
    kg(false);
    AppMethodBeat.o(98006);
    return false;
  }
  
  final void fTW()
  {
    AppMethodBeat.i(98008);
    if ((this.KGz != null) && (!this.KGz.isRecycled()))
    {
      this.KGl.setImageBitmap(this.KGz);
      this.KGl.ju(((Integer)this.KGy.first).intValue(), ((Integer)this.KGy.second).intValue());
    }
    AppMethodBeat.o(98008);
  }
  
  final void fTX()
  {
    AppMethodBeat.i(98009);
    this.KGm.setVisibility(8);
    this.KGl.JsW.clear();
    this.KGl.ju(com.tencent.mm.ci.a.fromDPToPix(this.iXq, 100), com.tencent.mm.ci.a.fromDPToPix(this.iXq, 100));
    this.KGl.setBackgroundResource(i.c.sns_upload_add_bg);
    this.KGl.setImageResource(i.i.album_post_add_picture_btn);
    this.KGl.setContentDescription(this.KGl.getContext().getString(i.j.sns_add_video));
    int i = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 100) * 35 / 100;
    this.KGl.setPadding(i, i, i, i);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGi, true))
    {
      com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      com.tencent.mm.plugin.recordvideo.e.d.aWk(this.videoPath);
      locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      com.tencent.mm.plugin.recordvideo.e.d.aWk(this.thumbPath);
    }
    AppMethodBeat.o(98009);
  }
  
  public final boolean fTY()
  {
    if (this.KGp != null) {
      return this.KGp.TCA;
    }
    return false;
  }
  
  public final boolean fTw()
  {
    return !this.KGs;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(98001);
    this.bvK = View.inflate(this.iXq, i.g.upload_new_sight_widget, null);
    this.KGl = ((SightPlayImageView)this.bvK.findViewById(i.f.thumb_iv));
    this.KGm = ((ImageView)this.bvK.findViewById(i.f.status_btn));
    Object localObject = new DisplayMetrics();
    this.iXq.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.KGw = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 100);
    this.KGv = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 100);
    if ((!TextUtils.isEmpty(this.thumbPath)) && (com.tencent.mm.vfs.u.agG(this.thumbPath)))
    {
      Log.i("MicroMsg.SightWidget", "getBitmapNative thumbPath:%s", new Object[] { this.thumbPath });
      this.KGz = BitmapUtil.getBitmapNative(this.thumbPath);
      A("isPreviewExit", Integer.valueOf(1));
    }
    if (this.KGz == null)
    {
      A("isPreviewExit", Integer.valueOf(0));
      Log.i("MicroMsg.SightWidget", "getVideoThumb videoPath:%s", new Object[] { this.videoPath });
      this.KGz = com.tencent.mm.plugin.mmsight.d.Xd(this.videoPath);
    }
    int i;
    boolean bool;
    if (this.KGz != null)
    {
      this.KGw = this.KGz.getHeight();
      this.KGv = this.KGz.getWidth();
      localObject = this.KGz;
      int n = this.KGv;
      int i1 = this.KGw;
      i = ((Bitmap)localObject).getPixel(n / 4, i1 / 4);
      int j = ((Bitmap)localObject).getPixel(n / 4, i1 / 3);
      int k = ((Bitmap)localObject).getPixel(n / 3, i1 / 3);
      int m = ((Bitmap)localObject).getPixel(n / 3, i1 / 4);
      n = ((Bitmap)localObject).getPixel(n / 2, i1 / 2);
      if ((i != -16777216) || (j != -16777216) || (k != -16777216) || (m != -16777216) || (n != -16777216)) {
        break label796;
      }
      bool = true;
    }
    for (;;)
    {
      com.tencent.mm.ad.i locali;
      String str;
      if (bool)
      {
        i = 1;
        A("isPreviewBlack", Integer.valueOf(i));
        Log.i("MicroMsg.SightWidget", "isPreviewBitmapBlack:%b", new Object[] { Boolean.valueOf(bool) });
        Log.i("MicroMsg.SightWidget", "mSightHeight:%s", new Object[] { Integer.valueOf(this.KGw) });
        Log.i("MicroMsg.SightWidget", "mSightWidth:%s", new Object[] { Integer.valueOf(this.KGv) });
        this.KGy = com.tencent.mm.modelsns.o.a(this.KGv, this.KGw, this.iXq, false);
        Log.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.KGv), Integer.valueOf(this.KGw), this.KGy.first, this.KGy.second, Integer.valueOf(this.KGx) });
        fTW();
        this.KGl.setScaleType(QImageView.a.Ydm);
        this.KGl.Jte = true;
        this.KGl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(97990);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if (an.this.KGs)
            {
              com.tencent.mm.kernel.h.aHH();
              if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
              {
                w.g(an.this.iXq, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
                return;
              }
            }
            try
            {
              paramAnonymousView = new com.tencent.mm.ui.widget.a.e(an.this.iXq, 1, false);
              paramAnonymousView.ODT = new q.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                {
                  AppMethodBeat.i(97988);
                  if (!ac.mGL) {
                    paramAnonymous2o.d(0, an.this.iXq.getString(i.j.app_field_mmsight));
                  }
                  paramAnonymous2o.d(1, an.this.iXq.getString(i.j.app_field_select_new_pic));
                  AppMethodBeat.o(97988);
                }
              };
              paramAnonymousView.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  boolean bool1 = true;
                  AppMethodBeat.i(97989);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(97989);
                    return;
                    paramAnonymous2MenuItem = an.this;
                    paramAnonymous2MenuItem.agP(1);
                    long l = cm.bfD();
                    com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), t.fNp(), Long.valueOf(l) });
                    Object localObject1 = new SightParams(2, 0);
                    com.tencent.mm.modelvideo.s.bqA();
                    Object localObject2 = com.tencent.mm.plugin.mmsight.d.aPt(com.tencent.mm.modelvideo.s.getAccVideoPath());
                    String str = com.tencent.mm.plugin.mmsight.d.aPv((String)localObject2);
                    c localc = c.KfL;
                    localObject1 = c.a((String)localObject2, str, ((SightParams)localObject1).lgX, ((SightParams)localObject1).lgX.duration * 1000);
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFL, false)) {
                      ((RecordConfigProvider)localObject1).remuxType = 2;
                    }
                    localObject2 = new VideoCaptureReportInfo();
                    ((VideoCaptureReportInfo)localObject2).wwk = 7;
                    ((RecordConfigProvider)localObject1).HLk = ((VideoCaptureReportInfo)localObject2);
                    localObject2 = new an.9(paramAnonymous2MenuItem);
                    CaptureDataManager.HKJ.HKI = ((CaptureDataManager.b)localObject2);
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFJ, true))
                    {
                      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
                      com.tencent.mm.plugin.recordvideo.jumper.a.a(paramAnonymous2MenuItem.iXq, 11, i.a.sight_slide_bottom_in, i.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
                      AppMethodBeat.o(97989);
                      return;
                    }
                    localObject1 = new Intent();
                    com.tencent.mm.pluginsdk.ui.tools.u.a(paramAnonymous2MenuItem.iXq, 11, (Intent)localObject1, 2, 0);
                    AppMethodBeat.o(97989);
                    return;
                    paramAnonymous2MenuItem = an.this.iXq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
                    l = cm.bfD();
                    com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), t.fNp(), Long.valueOf(l) });
                    if (!paramAnonymous2MenuItem.equalsIgnoreCase("0")) {
                      break;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.u.bd(an.this.iXq);
                    an.this.agP(2);
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.bkp().bks().duration);
                  boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGB, false);
                  if ((com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vut, 0) == 1) || (bool2))
                  {
                    paramAnonymous2Int = 1;
                    label484:
                    if (paramAnonymous2Int != 0) {
                      break label525;
                    }
                  }
                  for (;;)
                  {
                    paramAnonymous2MenuItem.putExtra("key_can_select_video_and_pic", bool1);
                    com.tencent.mm.pluginsdk.ui.tools.u.a(an.this.iXq, 9, 9, 4, 3, paramAnonymous2MenuItem);
                    break;
                    paramAnonymous2Int = 0;
                    break label484;
                    label525:
                    bool1 = false;
                  }
                }
              };
              paramAnonymousView.eik();
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
                return;
                localObject = new int[2];
                if (paramAnonymousView == null) {
                  break;
                }
                paramAnonymousView.getLocationInWindow((int[])localObject);
                j = paramAnonymousView.getWidth();
                i = paramAnonymousView.getHeight();
                if (an.this.KGC.R(localObject[0], localObject[1], j, i))
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(97990);
                  return;
                }
                if (!com.tencent.mm.vfs.u.agG(an.this.videoPath))
                {
                  Log.i("MicroMsg.SightWidget", "click videopath is not exist " + an.this.videoPath);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(97990);
                  return;
                }
                paramAnonymousView = new Intent(an.this.iXq, SnsOnlineVideoActivity.class);
                paramAnonymousView.putExtra("intent_videopath", an.this.videoPath);
                paramAnonymousView.putExtra("intent_thumbpath", an.this.thumbPath);
                paramAnonymousView.putExtra("intent_isad", false);
                paramAnonymousView.putExtra("intent_ispreview", true);
                paramAnonymousView.putExtra("KBlockAdd", an.this.KGA);
                paramAnonymousView.putExtra("sns_video_scene", 6);
                paramAnonymousView.putExtra("img_gallery_left", localObject[0]);
                paramAnonymousView.putExtra("img_gallery_top", localObject[1]);
                paramAnonymousView.putExtra("img_gallery_width", j);
                paramAnonymousView.putExtra("img_gallery_height", i);
                an.this.iXq.startActivityForResult(paramAnonymousView, 12);
                an.this.iXq.overridePendingTransition(0, 0);
              }
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                continue;
                int i = 0;
                int j = 0;
              }
            }
          }
        });
        Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.u.bBQ(this.videoPath) + " " + com.tencent.mm.vfs.u.bBQ(this.thumbPath));
        if (com.tencent.mm.vfs.u.agG(this.videoPath)) {
          Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
        }
        if (this.KGD != null)
        {
          localObject = com.tencent.mm.plugin.sns.k.g.Kia;
          locali = this.KGD;
          i = locali.optInt("page");
          str = locali.optString("from");
        }
      }
      try
      {
        ((com.tencent.mm.plugin.sns.k.g)localObject).KiQ.goe = Long.parseLong(str);
        ((com.tencent.mm.plugin.sns.k.g)localObject).KiQ.gMg = i;
        ((com.tencent.mm.plugin.sns.k.g)localObject).KiQ.gMh = locali.optInt("isPreviewExit");
        ((com.tencent.mm.plugin.sns.k.g)localObject).KiQ.gMi = locali.optInt("isPreviewBlack");
        this.KGD = null;
        localObject = this.bvK;
        AppMethodBeat.o(98001);
        return localObject;
        label796:
        bool = false;
        continue;
        i = 0;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SnsReportHelper", "SecondCut set report shareType error");
        }
      }
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  /* Error */
  public final boolean k(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1257
    //   3: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+29 -> 36, 9:+380->387, 10:+29->36, 11:+142->149, 12:+37->44
    //   37: iconst_1
    //   38: <illegal opcode>
    //   39: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_2
    //   45: ifnull -9 -> 36
    //   48: aload_0
    //   49: aload_2
    //   50: ldc_w 1259
    //   53: iconst_0
    //   54: invokevirtual 349	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   57: putfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   60: aload_0
    //   61: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   64: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc_w 431
    //   70: aload_0
    //   71: getfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   74: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   77: pop
    //   78: aload_0
    //   79: getfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   82: ifeq +59 -> 141
    //   85: aload_0
    //   86: getfield 217	com/tencent/mm/plugin/sns/ui/an:KGC	Lcom/tencent/mm/plugin/sns/ui/f/a;
    //   89: astore_2
    //   90: ldc_w 744
    //   93: ldc_w 1261
    //   96: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic 838	com/tencent/mm/plugin/recordvideo/background/a:HGl	Lcom/tencent/mm/plugin/recordvideo/background/a;
    //   102: astore 4
    //   104: bipush 7
    //   106: aload_2
    //   107: invokestatic 957	com/tencent/mm/plugin/recordvideo/background/a:b	(ILcom/tencent/mm/plugin/recordvideo/background/b;)V
    //   110: aload_2
    //   111: getfield 1264	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   114: invokestatic 1129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +15 -> 132
    //   120: getstatic 876	com/tencent/mm/plugin/recordvideo/background/e:HGz	Lcom/tencent/mm/plugin/recordvideo/background/e;
    //   123: astore 4
    //   125: aload_2
    //   126: getfield 1264	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   129: invokestatic 1267	com/tencent/mm/plugin/recordvideo/background/e:aVJ	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual 1269	com/tencent/mm/plugin/sns/ui/an:fTX	()V
    //   136: aload_0
    //   137: iconst_1
    //   138: invokespecial 959	com/tencent/mm/plugin/sns/ui/an:kg	(Z)V
    //   141: ldc_w 1257
    //   144: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_2
    //   150: ldc_w 1271
    //   153: invokevirtual 1274	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   156: checkcast 1276	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull -127 -> 36
    //   166: aload 4
    //   168: getfield 1279	com/tencent/mm/plugin/mmsight/SightCaptureResult:EXZ	Z
    //   171: ifne +131 -> 302
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   179: aload_0
    //   180: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   183: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   186: ldc_w 431
    //   189: aload_0
    //   190: getfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   193: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   196: pop
    //   197: aload_0
    //   198: aload 4
    //   200: getfield 1282	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYb	Ljava/lang/String;
    //   203: putfield 139	com/tencent/mm/plugin/sns/ui/an:videoPath	Ljava/lang/String;
    //   206: aload_0
    //   207: aload 4
    //   209: getfield 1285	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYc	Ljava/lang/String;
    //   212: putfield 137	com/tencent/mm/plugin/sns/ui/an:thumbPath	Ljava/lang/String;
    //   215: aload 4
    //   217: getfield 1288	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYe	Ljava/lang/String;
    //   220: invokestatic 616	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   223: ifne +64 -> 287
    //   226: aload_0
    //   227: aload 4
    //   229: getfield 1288	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYe	Ljava/lang/String;
    //   232: putfield 141	com/tencent/mm/plugin/sns/ui/an:md5	Ljava/lang/String;
    //   235: aload_0
    //   236: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   239: instanceof 494
    //   242: ifeq +37 -> 279
    //   245: aload_0
    //   246: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   249: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   252: aload_0
    //   253: getfield 139	com/tencent/mm/plugin/sns/ui/an:videoPath	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 137	com/tencent/mm/plugin/sns/ui/an:thumbPath	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 141	com/tencent/mm/plugin/sns/ui/an:md5	Ljava/lang/String;
    //   264: aconst_null
    //   265: iconst_1
    //   266: invokevirtual 1291	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   269: aload_0
    //   270: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   273: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   276: invokevirtual 1294	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   279: ldc_w 1257
    //   282: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_1
    //   286: ireturn
    //   287: aload_0
    //   288: aload 4
    //   290: getfield 1282	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYb	Ljava/lang/String;
    //   293: invokestatic 940	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 141	com/tencent/mm/plugin/sns/ui/an:md5	Ljava/lang/String;
    //   299: goto -64 -> 235
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   307: aload_0
    //   308: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   311: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   314: ldc_w 431
    //   317: aload_0
    //   318: getfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   321: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   324: pop
    //   325: aload_2
    //   326: ldc_w 1296
    //   329: iconst_0
    //   330: invokevirtual 725	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   333: istore_1
    //   334: aload 4
    //   336: getfield 1299	com/tencent/mm/plugin/mmsight/SightCaptureResult:EYh	Ljava/lang/String;
    //   339: astore_2
    //   340: aload_0
    //   341: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   344: instanceof 494
    //   347: ifeq +32 -> 379
    //   350: aload_0
    //   351: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   354: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   357: aload_2
    //   358: iconst_1
    //   359: iload_1
    //   360: aconst_null
    //   361: aconst_null
    //   362: aload_0
    //   363: getfield 596	com/tencent/mm/plugin/sns/ui/an:KCP	I
    //   366: invokevirtual 1302	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   369: aload_0
    //   370: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   373: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   376: invokevirtual 1294	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   379: ldc_w 1257
    //   382: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: iconst_1
    //   386: ireturn
    //   387: aload_2
    //   388: ldc_w 748
    //   391: invokevirtual 752	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   394: astore 4
    //   396: aload 4
    //   398: ifnull +131 -> 529
    //   401: aload 4
    //   403: ldc_w 754
    //   406: invokevirtual 760	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   409: ifnull +120 -> 529
    //   412: aload 4
    //   414: ldc_w 762
    //   417: invokevirtual 760	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   420: ifnull +109 -> 529
    //   423: ldc 236
    //   425: ldc_w 1304
    //   428: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   435: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   438: invokevirtual 1308	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   441: invokevirtual 1309	android/os/Bundle:clear	()V
    //   444: aload_0
    //   445: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   448: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   451: ldc_w 717
    //   454: iconst_0
    //   455: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   463: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   466: ldc_w 1311
    //   469: iconst_1
    //   470: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   478: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   481: ldc_w 1313
    //   484: bipush 14
    //   486: invokevirtual 1316	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   489: pop
    //   490: aload_0
    //   491: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   494: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   497: ldc_w 748
    //   500: aload_2
    //   501: ldc_w 748
    //   504: invokevirtual 752	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   507: invokevirtual 1319	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   510: pop
    //   511: aload_0
    //   512: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   515: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   518: invokevirtual 1294	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   521: ldc_w 1257
    //   524: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: iconst_1
    //   528: ireturn
    //   529: aload_2
    //   530: ldc_w 1321
    //   533: invokevirtual 1325	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   536: astore 4
    //   538: aload 4
    //   540: ifnull +11 -> 551
    //   543: aload 4
    //   545: invokevirtual 1330	java/util/ArrayList:size	()I
    //   548: ifgt +16 -> 564
    //   551: aload_2
    //   552: ldc_w 1332
    //   555: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   558: invokestatic 616	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   561: ifne +403 -> 964
    //   564: aload_0
    //   565: iconst_0
    //   566: putfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   569: aload_0
    //   570: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   573: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   576: ldc_w 431
    //   579: aload_0
    //   580: getfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   583: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   586: pop
    //   587: aload 4
    //   589: ifnull +124 -> 713
    //   592: aload 4
    //   594: invokevirtual 1330	java/util/ArrayList:size	()I
    //   597: ifle +116 -> 713
    //   600: aload 4
    //   602: iconst_0
    //   603: invokevirtual 1335	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   606: checkcast 292	java/lang/String
    //   609: astore 4
    //   611: aload_2
    //   612: ldc_w 1337
    //   615: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   618: astore 5
    //   620: aload 5
    //   622: invokestatic 616	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   625: ifne +14 -> 639
    //   628: aload 5
    //   630: astore_2
    //   631: aload 5
    //   633: invokestatic 503	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   636: ifne +181 -> 817
    //   639: new 911	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 1338	java/lang/StringBuilder:<init>	()V
    //   646: invokestatic 1341	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   649: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 4
    //   654: invokestatic 940	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 927	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: astore_2
    //   664: new 168	com/tencent/mm/compatible/i/d
    //   667: dup
    //   668: invokespecial 169	com/tencent/mm/compatible/i/d:<init>	()V
    //   671: astore 5
    //   673: aload 5
    //   675: aload 4
    //   677: invokevirtual 1346	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   680: aload 5
    //   682: lconst_0
    //   683: invokevirtual 1350	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   686: astore 6
    //   688: aload 6
    //   690: ifnonnull +35 -> 725
    //   693: ldc 236
    //   695: ldc_w 1352
    //   698: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload 5
    //   703: invokevirtual 1354	android/media/MediaMetadataRetriever:release	()V
    //   706: goto -670 -> 36
    //   709: astore_2
    //   710: goto -674 -> 36
    //   713: aload_2
    //   714: ldc_w 1332
    //   717: invokevirtual 701	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   720: astore 4
    //   722: goto -111 -> 611
    //   725: ldc 236
    //   727: ldc_w 1356
    //   730: iconst_2
    //   731: anewarray 4	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload 6
    //   738: invokevirtual 1157	android/graphics/Bitmap:getWidth	()I
    //   741: invokestatic 1142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: aload 6
    //   749: invokevirtual 1154	android/graphics/Bitmap:getHeight	()I
    //   752: invokestatic 1142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: invokestatic 742	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: aload 6
    //   761: bipush 80
    //   763: getstatic 1362	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   766: aload_2
    //   767: iconst_1
    //   768: invokestatic 1366	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   771: pop
    //   772: aload_2
    //   773: invokestatic 1370	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   776: astore 6
    //   778: ldc 236
    //   780: ldc_w 1372
    //   783: iconst_2
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload 6
    //   791: getfield 1377	android/graphics/BitmapFactory$Options:outWidth	I
    //   794: invokestatic 1142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: aastore
    //   798: dup
    //   799: iconst_1
    //   800: aload 6
    //   802: getfield 1380	android/graphics/BitmapFactory$Options:outHeight	I
    //   805: invokestatic 1142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: aastore
    //   809: invokestatic 742	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: aload 5
    //   814: invokevirtual 1354	android/media/MediaMetadataRetriever:release	()V
    //   817: aload_0
    //   818: aload 4
    //   820: invokestatic 940	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   823: putfield 141	com/tencent/mm/plugin/sns/ui/an:md5	Ljava/lang/String;
    //   826: ldc 236
    //   828: ldc_w 1382
    //   831: iconst_4
    //   832: anewarray 4	java/lang/Object
    //   835: dup
    //   836: iconst_0
    //   837: aload 4
    //   839: aastore
    //   840: dup
    //   841: iconst_1
    //   842: aload_2
    //   843: aastore
    //   844: dup
    //   845: iconst_2
    //   846: aload 4
    //   848: invokestatic 1209	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   851: invokestatic 1385	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   854: aastore
    //   855: dup
    //   856: iconst_3
    //   857: aload_2
    //   858: invokestatic 1209	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   861: invokestatic 1385	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   864: aastore
    //   865: invokestatic 742	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   868: aload_0
    //   869: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   872: instanceof 494
    //   875: ifeq +32 -> 907
    //   878: aload_0
    //   879: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   882: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   885: aload 4
    //   887: aload_2
    //   888: aload_0
    //   889: getfield 141	com/tencent/mm/plugin/sns/ui/an:md5	Ljava/lang/String;
    //   892: aconst_null
    //   893: iconst_0
    //   894: invokevirtual 1291	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   897: aload_0
    //   898: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   901: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   904: invokevirtual 1294	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   907: ldc_w 1257
    //   910: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   913: iconst_1
    //   914: ireturn
    //   915: astore 6
    //   917: ldc 236
    //   919: ldc_w 1387
    //   922: iconst_1
    //   923: anewarray 4	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: aload 6
    //   930: invokevirtual 885	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   933: aastore
    //   934: invokestatic 807	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: aload 5
    //   939: invokevirtual 1354	android/media/MediaMetadataRetriever:release	()V
    //   942: goto -125 -> 817
    //   945: astore 5
    //   947: goto -130 -> 817
    //   950: astore_2
    //   951: aload 5
    //   953: invokevirtual 1354	android/media/MediaMetadataRetriever:release	()V
    //   956: ldc_w 1257
    //   959: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   962: aload_2
    //   963: athrow
    //   964: aload_0
    //   965: iconst_1
    //   966: putfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   969: aload_0
    //   970: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   973: invokevirtual 341	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   976: ldc_w 431
    //   979: aload_0
    //   980: getfield 164	com/tencent/mm/plugin/sns/ui/an:KGs	Z
    //   983: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   986: pop
    //   987: aload_2
    //   988: ldc_w 1389
    //   991: invokevirtual 1325	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   994: astore 4
    //   996: aload 4
    //   998: ifnull +11 -> 1009
    //   1001: aload 4
    //   1003: invokevirtual 1330	java/util/ArrayList:size	()I
    //   1006: ifne +19 -> 1025
    //   1009: ldc 236
    //   1011: ldc_w 1391
    //   1014: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1017: ldc_w 1257
    //   1020: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1023: iconst_0
    //   1024: ireturn
    //   1025: new 1327	java/util/ArrayList
    //   1028: dup
    //   1029: invokespecial 1392	java/util/ArrayList:<init>	()V
    //   1032: astore 5
    //   1034: aload 4
    //   1036: invokevirtual 1393	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1039: astore 6
    //   1041: aload 6
    //   1043: invokeinterface 530 1 0
    //   1048: ifeq +76 -> 1124
    //   1051: aload 6
    //   1053: invokeinterface 534 1 0
    //   1058: checkcast 292	java/lang/String
    //   1061: astore 7
    //   1063: aload 7
    //   1065: invokestatic 1399	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1068: invokevirtual 1403	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1071: astore 8
    //   1073: aload 8
    //   1075: ifnull -34 -> 1041
    //   1078: aload 5
    //   1080: ldc_w 1405
    //   1083: iconst_3
    //   1084: anewarray 4	java/lang/Object
    //   1087: dup
    //   1088: iconst_0
    //   1089: aload 7
    //   1091: aastore
    //   1092: dup
    //   1093: iconst_1
    //   1094: aload 8
    //   1096: getfield 1411	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1099: invokestatic 1416	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1102: aastore
    //   1103: dup
    //   1104: iconst_2
    //   1105: aload 8
    //   1107: getfield 1419	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1110: invokestatic 1416	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1113: aastore
    //   1114: invokestatic 1423	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1117: invokevirtual 1424	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1120: pop
    //   1121: goto -80 -> 1041
    //   1124: aload_2
    //   1125: ldc_w 1426
    //   1128: iconst_0
    //   1129: invokevirtual 349	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1132: istore_3
    //   1133: aload_2
    //   1134: ldc_w 1296
    //   1137: iconst_0
    //   1138: invokevirtual 725	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1141: istore_1
    //   1142: aload_0
    //   1143: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1146: instanceof 494
    //   1149: ifeq -1113 -> 36
    //   1152: aload_0
    //   1153: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1156: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1159: aconst_null
    //   1160: iload_3
    //   1161: iload_1
    //   1162: aload 4
    //   1164: aload 5
    //   1166: aload_0
    //   1167: getfield 596	com/tencent/mm/plugin/sns/ui/an:KCP	I
    //   1170: invokevirtual 1302	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   1173: aload_0
    //   1174: getfield 210	com/tencent/mm/plugin/sns/ui/an:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   1177: checkcast 494	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1180: invokevirtual 1294	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fXZ	()V
    //   1183: goto -1147 -> 36
    //   1186: astore 5
    //   1188: goto -371 -> 817
    //   1191: astore 4
    //   1193: goto -237 -> 956
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1196	0	this	an
    //   0	1196	1	paramInt	int
    //   0	1196	2	paramIntent	Intent
    //   1132	29	3	bool	boolean
    //   102	1061	4	localObject1	Object
    //   1191	1	4	localException1	Exception
    //   618	320	5	localObject2	Object
    //   945	7	5	localException2	Exception
    //   1032	133	5	localArrayList	java.util.ArrayList
    //   1186	1	5	localException3	Exception
    //   686	115	6	localObject3	Object
    //   915	14	6	localException4	Exception
    //   1039	13	6	localIterator	Iterator
    //   1061	29	7	str	String
    //   1071	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   701	706	709	java/lang/Exception
    //   673	688	915	java/lang/Exception
    //   693	701	915	java/lang/Exception
    //   725	812	915	java/lang/Exception
    //   937	942	945	java/lang/Exception
    //   673	688	950	finally
    //   693	701	950	finally
    //   725	812	950	finally
    //   917	937	950	finally
    //   812	817	1186	java/lang/Exception
    //   951	956	1191	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.an
 * JD-Core Version:    0.7.0.1
 */