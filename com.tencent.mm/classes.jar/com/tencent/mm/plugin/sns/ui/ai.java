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
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tx.b;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.f.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.QImageView.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ai
  implements ac, a.a
{
  private String appId;
  private String appName;
  String desc;
  private boolean doF;
  MMActivity fLP;
  ProgressDialog fMu;
  String gHx;
  private LinkedList<Long> glo;
  String hAe;
  private p mCn;
  private String mSessionId;
  String md5;
  private com.tencent.mm.sdk.b.c rVT;
  private View rY;
  String thumbPath;
  String videoPath;
  private List<String> zOW;
  private int zQd;
  private com.tencent.mm.modelsns.e zQj;
  private String zQk;
  private boolean zRC;
  private boolean zRD;
  private WXMediaMessage zRE;
  SightPlayImageView zSU;
  private ImageView zSV;
  boolean zSW;
  private Bitmap zSX;
  private bxm zSY;
  private String zSZ;
  private boolean zTa;
  boolean zTb;
  private int zTc;
  private MediaMetadataRetriever zTd;
  private int zTe;
  private int zTf;
  private int zTg;
  private Pair<Integer, Integer> zTh;
  private Bitmap zTi;
  boolean zTj;
  private boolean zTk;
  com.tencent.mm.plugin.sns.ui.f.a zTl;
  bc zTm;
  private int zTn;
  private int zTo;
  private org.b.d.i zTp;
  private String zTq;
  private bvq zTr;
  private int zTs;
  private List<String> zTt;
  private PInt zTu;
  private String zTv;
  private int zTw;
  private int zTx;
  Runnable zTy;
  Runnable zTz;
  private int zdA;
  private int znT;
  private boolean zqP;
  
  public ai(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97999);
    this.rY = null;
    this.zSV = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.doF = false;
    this.zSW = false;
    this.zSX = null;
    this.zQj = null;
    this.zSY = new bxm();
    this.zRC = false;
    this.zRD = false;
    this.zRE = null;
    this.zTa = false;
    this.zTb = false;
    this.zTc = 0;
    this.zTd = new com.tencent.mm.compatible.h.d();
    this.zTe = 0;
    this.zTf = 0;
    this.zTg = 90;
    this.zTh = null;
    this.zTi = null;
    this.zTj = false;
    this.zTk = false;
    this.znT = 1;
    this.zQk = "";
    this.rVT = new com.tencent.mm.sdk.b.c() {};
    this.zTm = null;
    this.zTn = 0;
    this.desc = "";
    this.fMu = null;
    this.zTy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97993);
        ai.a(ai.this);
        AppMethodBeat.o(97993);
      }
    };
    this.zTz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97995);
        ad.i("MicroMsg.SightWidget", "showProgress");
        ai localai = ai.this;
        MMActivity localMMActivity = ai.this.fLP;
        ai.this.fLP.getString(2131755906);
        localai.fMu = com.tencent.mm.ui.base.h.b(localMMActivity, ai.this.fLP.getString(2131763977), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(97994);
            ai.this.zTm = null;
            ai.this.zSW = false;
            aq.aA(ai.this.zTy);
            AppMethodBeat.o(97994);
          }
        });
        AppMethodBeat.o(97995);
      }
    };
    this.fLP = paramMMActivity;
    this.zTl = new com.tencent.mm.plugin.sns.ui.f.a(paramMMActivity, this);
    AppMethodBeat.o(97999);
  }
  
  private void rI(boolean paramBoolean)
  {
    AppMethodBeat.i(98004);
    this.videoPath = "";
    this.thumbPath = "";
    this.zTb = paramBoolean;
    if (paramBoolean)
    {
      this.fLP.getIntent().putExtra("KSightThumbPath", this.thumbPath);
      this.fLP.getIntent().putExtra("KSightPath", this.videoPath);
    }
    this.fLP.getIntent().putExtra("KSightDeleted", this.zTb);
    this.zTg = 90;
    if (com.tencent.mm.plugin.sns.data.q.I(this.zTi))
    {
      this.zTi.recycle();
      this.zTi = null;
    }
    AppMethodBeat.o(98004);
  }
  
  final void QV(int paramInt)
  {
    AppMethodBeat.i(98007);
    ex localex = new ex().Tm();
    localex.ejx = paramInt;
    localex.of(this.zSZ).aLk();
    AppMethodBeat.o(98007);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98003);
    if (this.zTl.eeR())
    {
      this.mCn = com.tencent.mm.ui.base.h.b(this.fLP, this.fLP.getString(2131762543), true, null);
      this.zTo = paramInt1;
      this.zdA = paramInt2;
      this.zTp = parami;
      this.zTq = paramString1;
      this.zOW = paramList1;
      this.zTr = parambvq;
      this.glo = paramLinkedList;
      this.zTs = paramInt3;
      this.zqP = paramBoolean;
      this.zTt = paramList2;
      this.zTu = paramPInt;
      this.zTv = paramString2;
      this.zTw = paramInt4;
      this.zTx = paramInt5;
      ((SnsUploadUI)this.fLP).AoR = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (!com.tencent.mm.vfs.i.fv(this.videoPath))
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97991);
          t.makeText(ai.this.fLP, 2131763075, 0).show();
          AppMethodBeat.o(97991);
        }
      });
      ((SnsUploadUI)this.fLP).AoR = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.zTm != null)
    {
      ((SnsUploadUI)this.fLP).AoR = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.zSW)
    {
      AppMethodBeat.o(98003);
      return true;
    }
    this.zSW = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.i.d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          dhj localdhj = new dhj();
          localdhj.nDo = paramString2;
          parami.add(localdhj);
        }
      }
    }
    this.zTm = new bc(15);
    paramPInt.value = this.zTm.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zbZ) {
      this.zTm.Qb(3);
    }
    paramString1 = this.zTm.azj(paramString1);
    new LinkedList();
    paramString1.a(parambvq).aU(parami).Qe(paramInt1).Qf(paramInt2).fL(paramList2);
    if (paramBoolean) {
      this.zTm.Qh(1);
    }
    for (;;)
    {
      this.zTm.cc(this.znT, this.zQk);
      this.zTm.fL(paramList2);
      this.zTm.Qg(this.zQd);
      this.zTm.dJi = this.zSY;
      this.zTm.g(null, null, null, paramInt4, paramInt5);
      this.zTm.setSessionId(this.mSessionId);
      if (!bt.isNullOrNil(this.appId)) {
        this.zTm.azp(this.appId);
      }
      if (!bt.isNullOrNil(this.appName)) {
        this.zTm.azq(bt.bI(this.appName, ""));
      }
      if (this.zRC) {
        this.zTm.Qg(5);
      }
      if ((this.zRD) && (this.zRE != null))
      {
        this.zTm.azk(this.zRE.mediaTagName);
        this.zTm.aD(this.appId, this.zRE.messageExt, this.zRE.messageAction);
      }
      aq.o(this.zTz, 700L);
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97992);
          ai localai = ai.this;
          long l = System.currentTimeMillis();
          bc localbc;
          String str4;
          Object localObject2;
          Object localObject1;
          String str1;
          String str2;
          String str3;
          Object localObject3;
          if ((!TextUtils.isEmpty(localai.gHx)) && (!TextUtils.isEmpty(localai.hAe)))
          {
            localbc = localai.zTm;
            str4 = localai.videoPath;
            localObject2 = localai.thumbPath;
            localObject1 = localai.desc;
            str1 = localai.md5;
            str2 = localai.gHx;
            str3 = localai.hAe;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.c.xRv;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.c.awc(str4);
            if (localObject3 == null) {
              break label575;
            }
            ad.i("MicroMsg.UploadPackHelper", "addSightObjectByUrl commit video_info:".concat(String.valueOf(localObject3)));
          }
          label533:
          label559:
          label575:
          for (float f = ((c.a)localObject3).duration / 1000.0F;; f = 0.0F)
          {
            localObject3 = ag.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str4.getBytes());
            bc.azt((String)localObject3);
            com.tencent.mm.vfs.i.mz(str4, (String)localObject3);
            str4 = ag.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
            com.tencent.mm.vfs.i.mz((String)localObject2, str4);
            localObject2 = bc.b("", (String)localObject3, str4, str1, str2, str3);
            int i;
            if (localObject2 == null)
            {
              ad.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
              i = 0;
              if (i != 0) {
                break label533;
              }
              ad.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.i.aYo(localai.videoPath) + " thumb: " + com.tencent.mm.vfs.i.aYo(localai.thumbPath) + ",cdnUrl " + localai.gHx + "cdnThubmUrl " + localai.hAe);
              aq.f(new ai.7(localai));
            }
            for (;;)
            {
              ad.i("MicroMsg.SightWidget", "removeRunnable showProgress");
              aq.aA(ai.this.zTz);
              if (ai.this.zTm != null) {
                break label559;
              }
              AppMethodBeat.o(97992);
              return;
              ((byn)localObject2).Desc = ((String)localObject1);
              if (bt.isNullOrNil(((byn)localObject2).Title)) {
                ((byn)localObject2).Title = ((String)localObject1);
              }
              ((byn)localObject2).GTe = f;
              localbc.znM.HAT.GaQ.add(localObject2);
              localObject1 = new bvk();
              ((bvk)localObject1).GPE = ((byn)localObject2).dJd;
              localbc.znN.GTh.add(localObject1);
              i = 1;
              break;
              if (!localai.zTm.z(localai.videoPath, localai.thumbPath, localai.desc, localai.md5))
              {
                ad.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.i.aYo(localai.videoPath) + " thumb: " + com.tencent.mm.vfs.i.aYo(localai.thumbPath));
                aq.f(new ai.8(localai));
              }
              else
              {
                ad.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            aq.f(ai.this.zTy);
            AppMethodBeat.o(97992);
            return;
          }
        }
      }, "sight_send_ready");
      AppMethodBeat.o(98003);
      return true;
      this.zTm.Qh(0);
    }
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(98000);
    this.zQj = com.tencent.mm.modelsns.e.w(this.fLP.getIntent());
    this.gHx = bt.bI(this.fLP.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.hAe = bt.bI(this.fLP.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.zRC = this.fLP.getIntent().getBooleanExtra("KThrid_app", false);
    this.zRD = this.fLP.getIntent().getBooleanExtra("KSnsAction", false);
    this.zTa = this.fLP.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.zTj = this.fLP.getIntent().getBooleanExtra("KBlockAdd", false);
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = bt.bI(this.fLP.getIntent().getStringExtra("reportSessionId"), "");
    this.zSZ = this.fLP.getIntent().getStringExtra("KSessionID");
    this.zTk = this.fLP.getIntent().getBooleanExtra("KSnsUploadFromSkipCompress", false);
    ad.i("MicroMsg.SightWidget", "mIsFromSkipCompress:%s, appId:%s", new Object[] { Boolean.valueOf(this.zTk), this.appId });
    paramBundle = this.zTl;
    Object localObject1 = this.fLP;
    ad.i("MicroMsg.SnsFakeVLogHelper", "resetFakeData");
    Bundle localBundle = ((MMActivity)localObject1).getIntent().getBundleExtra("key_extra_data");
    if ((localBundle == null) || (localBundle.getByteArray("key_bg_generate_pb") == null) || (localBundle.getByteArray("key_bg_generate_extra_config") == null)) {}
    for (;;)
    {
      paramBundle = this.fLP.getIntent().getBundleExtra("Ksnsupload_timeline");
      if (paramBundle != null) {
        this.zRE = new SendMessageToWX.Req(paramBundle).message;
      }
      this.thumbPath = this.fLP.getIntent().getStringExtra("KSightThumbPath");
      this.videoPath = this.fLP.getIntent().getStringExtra("KSightPath");
      this.zTb = this.fLP.getIntent().getBooleanExtra("KSightDeleted", false);
      this.md5 = this.fLP.getIntent().getStringExtra("sight_md5");
      paramBundle = this.fLP.getIntent().getByteArrayExtra("KMMSightExtInfo");
      if (paramBundle != null) {}
      try
      {
        this.zSY.parseFrom(paramBundle);
        if (this.zSY == null)
        {
          this.zSY = new bxm();
          this.zSY.GRA = this.zTa;
        }
        this.zSY.duW = this.mSessionId;
        this.zSY.GRE = this.zTk;
        this.zSY.GRF = this.appId;
        paramBundle = new tx();
        paramBundle.dIp.type = 2;
        com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
        if (bt.isNullOrNil(this.videoPath))
        {
          this.videoPath = bt.bI(paramBundle.dIq.dIu, "");
          ad.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
        }
        if (bt.isNullOrNil(this.md5))
        {
          paramBundle = bt.bI(paramBundle.dIq.dIs, "");
          this.md5 = paramBundle;
          ad.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
          com.tencent.mm.sdk.b.a.IbL.c(this.rVT);
          if (this.zTc != 0) {
            break label961;
          }
          ag.dTT();
          i = u.getScreenWidth();
          if (i != 0) {
            break label922;
          }
          AppMethodBeat.o(98000);
          return;
          localObject2 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightThumbPath");
          localObject3 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightPath");
          if ((com.tencent.mm.vfs.i.fv((String)localObject2)) && (com.tencent.mm.vfs.i.fv((String)localObject3)))
          {
            ad.i("MicroMsg.SnsFakeVLogHelper", "jump generate");
            continue;
          }
          ad.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper go bg generate");
          paramBundle.ycd = false;
          localObject2 = com.tencent.mm.plugin.recordvideo.background.a.xua;
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
            paramBundle.ABG = ((afy)new afy().parseFrom((byte[])localObject2));
            paramBundle.ABH = ((VideoMixer.MixConfig)localBundle.getParcelable("key_bg_generate_mix_config"));
            paramBundle.ABI = ((aif)new aif().parseFrom((byte[])localObject3));
            label850:
            ((MMActivity)localObject1).getIntent().putExtra("KSightThumbPath", paramBundle.ABG.thumbPath);
            paramBundle = paramBundle.ABH;
            localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
            com.tencent.mm.plugin.recordvideo.background.e.a((byte[])localObject2, paramBundle, (byte[])localObject3, 7);
            break;
            paramBundle = paramBundle;
            ad.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
            continue;
            paramBundle = this.md5;
          }
          label922:
          this.zTc = ((i - this.fLP.getResources().getDimensionPixelSize(2131166845) * 4 - this.fLP.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
          label961:
          if (this.fLP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
          for (this.znT = 1;; this.znT = 0)
          {
            this.zQk = bt.bI(this.fLP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
            AppMethodBeat.o(98000);
            return;
          }
        }
        catch (IOException localIOException)
        {
          break label850;
        }
      }
    }
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(98002);
    this.videoPath = paramCaptureVideoNormalModel.videoPath;
    this.thumbPath = paramCaptureVideoNormalModel.thumbPath;
    this.fLP.getIntent().putExtra("KSightThumbPath", this.thumbPath);
    this.fLP.getIntent().putExtra("KSightPath", this.videoPath);
    this.md5 = com.tencent.mm.vfs.i.aPK(paramCaptureVideoNormalModel.videoPath);
    if ((this.mCn != null) && (this.mCn.isShowing()))
    {
      this.mCn.dismiss();
      a(this.zTo, this.zdA, this.zTp, this.zTq, this.zOW, this.zTr, this.glo, this.zTs, this.zqP, this.zTt, this.zTu, this.zTv, this.zTw, this.zTx);
    }
    AppMethodBeat.o(98002);
  }
  
  public final boolean dZG()
  {
    return !this.zTb;
  }
  
  public final View dZH()
  {
    AppMethodBeat.i(98001);
    this.rY = View.inflate(this.fLP, 2131495818, null);
    this.zSU = ((SightPlayImageView)this.rY.findViewById(2131305798));
    this.zSV = ((ImageView)this.rY.findViewById(2131305196));
    Object localObject = new DisplayMetrics();
    this.fLP.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.zTf = com.tencent.mm.cc.a.fromDPToPix(this.fLP, 100);
    this.zTe = com.tencent.mm.cc.a.fromDPToPix(this.fLP, 100);
    if ((!TextUtils.isEmpty(this.thumbPath)) && (com.tencent.mm.vfs.i.fv(this.thumbPath)))
    {
      ad.i("MicroMsg.SightWidget", "getBitmapNative thumbPath:%s", new Object[] { this.thumbPath });
      this.zTi = com.tencent.mm.sdk.platformtools.g.aQf(this.thumbPath);
    }
    if (this.zTi == null)
    {
      ad.i("MicroMsg.SightWidget", "getVideoThumb videoPath:%s", new Object[] { this.videoPath });
      this.zTi = com.tencent.mm.plugin.mmsight.d.Gq(this.videoPath);
    }
    if (this.zTi != null)
    {
      this.zTf = this.zTi.getHeight();
      this.zTe = this.zTi.getWidth();
      ad.i("MicroMsg.SightWidget", "mSightHeight:%s", new Object[] { Integer.valueOf(this.zTf) });
      ad.i("MicroMsg.SightWidget", "mSightWidth:%s", new Object[] { Integer.valueOf(this.zTe) });
    }
    this.zTh = com.tencent.mm.modelsns.h.a(this.zTe, this.zTf, this.fLP, false);
    ad.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.zTe), Integer.valueOf(this.zTf), this.zTh.first, this.zTh.second, Integer.valueOf(this.zTg) });
    eab();
    this.zSU.setScaleType(QImageView.a.KTb);
    this.zSU.ySy = true;
    this.zSU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97990);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (ai.this.zTb)
        {
          com.tencent.mm.kernel.g.ajD();
          if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
          {
            t.g(ai.this.fLP, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97990);
            return;
          }
        }
        try
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.a.e(ai.this.fLP, 1, false);
          paramAnonymousView.KJy = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(97988);
              if (!com.tencent.mm.platformtools.ac.iPN) {
                paramAnonymous2l.c(0, ai.this.fLP.getString(2131755747));
              }
              paramAnonymous2l.c(1, ai.this.fLP.getString(2131755754));
              AppMethodBeat.o(97988);
            }
          };
          paramAnonymousView.KJz = new n.e()
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
                paramAnonymous2MenuItem = ai.this;
                paramAnonymous2MenuItem.QV(1);
                long l = cf.aCL();
                com.tencent.mm.plugin.report.service.g.yhR.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.q.dSP(), Long.valueOf(l) });
                Object localObject1 = new SightParams(2, 0);
                o.aMI();
                Object localObject2 = com.tencent.mm.plugin.mmsight.d.aqJ(o.getAccVideoPath());
                localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.mmsight.d.aqL((String)localObject2), ((SightParams)localObject1).hvh, ((SightParams)localObject1).hvh.duration * 1000, 2);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyw, false)) {
                  ((RecordConfigProvider)localObject1).remuxType = 2;
                }
                localObject2 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject2).rgD = 7;
                ((RecordConfigProvider)localObject1).xyB = ((VideoCaptureReportInfo)localObject2);
                localObject2 = new ai.9(paramAnonymous2MenuItem);
                CaptureDataManager.xxY.xxX = ((CaptureDataManager.b)localObject2);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyu, true))
                {
                  localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
                  com.tencent.mm.plugin.recordvideo.jumper.a.a(paramAnonymous2MenuItem.fLP, 11, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
                  AppMethodBeat.o(97989);
                  return;
                }
                localObject1 = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.q.a(paramAnonymous2MenuItem.fLP, 11, (Intent)localObject1, 2, 0);
                AppMethodBeat.o(97989);
                return;
                paramAnonymous2MenuItem = ai.this.fLP.getSharedPreferences(aj.fkC(), 0).getString("gallery", "1");
                l = cf.aCL();
                com.tencent.mm.plugin.report.service.g.yhR.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.q.dSP(), Long.valueOf(l) });
                if (!paramAnonymous2MenuItem.equalsIgnoreCase("0")) {
                  break;
                }
                com.tencent.mm.pluginsdk.ui.tools.q.aR(ai.this.fLP);
                ai.this.QV(2);
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.aGQ().aGT().duration);
              boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzh, false);
              if ((com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IDh, 0) == 1) || (bool2))
              {
                paramAnonymous2Int = 1;
                label474:
                if (paramAnonymous2Int != 0) {
                  break label515;
                }
              }
              for (;;)
              {
                paramAnonymous2MenuItem.putExtra("key_can_select_video_and_pic", bool1);
                com.tencent.mm.pluginsdk.ui.tools.q.a(ai.this.fLP, 9, 9, 4, 3, paramAnonymous2MenuItem);
                break;
                paramAnonymous2Int = 0;
                break label474;
                label515:
                bool1 = false;
              }
            }
          };
          paramAnonymousView.cMW();
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
            if (ai.this.zTl.L(localObject[0], localObject[1], j, i))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(97990);
              return;
            }
            if (!com.tencent.mm.vfs.i.fv(ai.this.videoPath))
            {
              ad.i("MicroMsg.SightWidget", "click videopath is not exist " + ai.this.videoPath);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(97990);
              return;
            }
            paramAnonymousView = new Intent(ai.this.fLP, SnsOnlineVideoActivity.class);
            paramAnonymousView.putExtra("intent_videopath", ai.this.videoPath);
            paramAnonymousView.putExtra("intent_thumbpath", ai.this.thumbPath);
            paramAnonymousView.putExtra("intent_isad", false);
            paramAnonymousView.putExtra("intent_ispreview", true);
            paramAnonymousView.putExtra("KBlockAdd", ai.this.zTj);
            paramAnonymousView.putExtra("sns_video_scene", 6);
            paramAnonymousView.putExtra("img_gallery_left", localObject[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject[1]);
            paramAnonymousView.putExtra("img_gallery_width", j);
            paramAnonymousView.putExtra("img_gallery_height", i);
            ai.this.fLP.startActivityForResult(paramAnonymousView, 12);
            ai.this.fLP.overridePendingTransition(0, 0);
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
    ad.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.i.aYo(this.videoPath) + " " + com.tencent.mm.vfs.i.aYo(this.thumbPath));
    if (com.tencent.mm.vfs.i.fv(this.videoPath)) {
      ad.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    localObject = this.rY;
    AppMethodBeat.o(98001);
    return localObject;
  }
  
  public final boolean dZI()
  {
    AppMethodBeat.i(98006);
    if (this.fMu != null) {
      this.fMu.dismiss();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
    if (com.tencent.mm.plugin.sns.data.q.I(this.zSX)) {
      this.zSX.recycle();
    }
    com.tencent.mm.plugin.sns.ui.f.a locala = this.zTl;
    ad.i("MicroMsg.SnsFakeVLogHelper", "release");
    com.tencent.mm.plugin.recordvideo.background.a locala1 = com.tencent.mm.plugin.recordvideo.background.a.xua;
    com.tencent.mm.plugin.recordvideo.background.a.b(7, locala);
    rI(false);
    AppMethodBeat.o(98006);
    return false;
  }
  
  final void eab()
  {
    AppMethodBeat.i(98008);
    if ((this.zTi != null) && (!this.zTi.isRecycled()))
    {
      this.zSU.setImageBitmap(this.zTi);
      this.zSU.hw(((Integer)this.zTh.first).intValue(), ((Integer)this.zTh.second).intValue());
    }
    AppMethodBeat.o(98008);
  }
  
  final void eac()
  {
    AppMethodBeat.i(98009);
    this.zSV.setVisibility(8);
    this.zSU.ySq.clear();
    this.zSU.hw(com.tencent.mm.cc.a.fromDPToPix(this.fLP, 100), com.tencent.mm.cc.a.fromDPToPix(this.fLP, 100));
    this.zSU.setBackgroundResource(2131100938);
    this.zSU.setImageResource(2131689536);
    this.zSU.setContentDescription(this.zSU.getContext().getString(2131763774));
    int i = com.tencent.mm.cc.a.fromDPToPix(this.fLP, 100) * 35 / 100;
    this.zSU.setPadding(i, i, i, i);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyR, true))
    {
      com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      com.tencent.mm.plugin.recordvideo.e.b.avT(this.videoPath);
      localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      com.tencent.mm.plugin.recordvideo.e.b.avT(this.thumbPath);
    }
    AppMethodBeat.o(98009);
  }
  
  public final boolean ead()
  {
    if (this.zSY != null) {
      return this.zSY.GRA;
    }
    return false;
  }
  
  /* Error */
  public final boolean k(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1123
    //   3: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+29 -> 36, 9:+380->387, 10:+29->36, 11:+142->149, 12:+37->44
    //   37: iconst_1
    //   38: dadd
    //   39: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_2
    //   45: ifnull -9 -> 36
    //   48: aload_0
    //   49: aload_2
    //   50: ldc_w 1125
    //   53: iconst_0
    //   54: invokevirtual 310	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   57: putfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   60: aload_0
    //   61: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   64: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc_w 391
    //   70: aload_0
    //   71: getfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   74: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   77: pop
    //   78: aload_0
    //   79: getfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   82: ifeq +59 -> 141
    //   85: aload_0
    //   86: getfield 215	com/tencent/mm/plugin/sns/ui/ai:zTl	Lcom/tencent/mm/plugin/sns/ui/f/a;
    //   89: astore_2
    //   90: ldc_w 703
    //   93: ldc_w 1127
    //   96: invokestatic 235	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic 797	com/tencent/mm/plugin/recordvideo/background/a:xua	Lcom/tencent/mm/plugin/recordvideo/background/a;
    //   102: astore 4
    //   104: bipush 7
    //   106: aload_2
    //   107: invokestatic 1038	com/tencent/mm/plugin/recordvideo/background/a:b	(ILcom/tencent/mm/plugin/recordvideo/background/b;)V
    //   110: aload_2
    //   111: getfield 1130	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   114: invokestatic 935	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +15 -> 132
    //   120: getstatic 835	com/tencent/mm/plugin/recordvideo/background/e:xuo	Lcom/tencent/mm/plugin/recordvideo/background/e;
    //   123: astore 4
    //   125: aload_2
    //   126: getfield 1130	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   129: invokestatic 1133	com/tencent/mm/plugin/recordvideo/background/e:avA	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual 1135	com/tencent/mm/plugin/sns/ui/ai:eac	()V
    //   136: aload_0
    //   137: iconst_1
    //   138: invokespecial 1040	com/tencent/mm/plugin/sns/ui/ai:rI	(Z)V
    //   141: ldc_w 1123
    //   144: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_2
    //   150: ldc_w 1137
    //   153: invokevirtual 1140	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   156: checkcast 1142	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull -127 -> 36
    //   166: aload 4
    //   168: getfield 1145	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMs	Z
    //   171: ifne +131 -> 302
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   179: aload_0
    //   180: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   183: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   186: ldc_w 391
    //   189: aload_0
    //   190: getfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   193: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   196: pop
    //   197: aload_0
    //   198: aload 4
    //   200: getfield 1148	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMu	Ljava/lang/String;
    //   203: putfield 137	com/tencent/mm/plugin/sns/ui/ai:videoPath	Ljava/lang/String;
    //   206: aload_0
    //   207: aload 4
    //   209: getfield 1151	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMv	Ljava/lang/String;
    //   212: putfield 135	com/tencent/mm/plugin/sns/ui/ai:thumbPath	Ljava/lang/String;
    //   215: aload 4
    //   217: getfield 1154	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMx	Ljava/lang/String;
    //   220: invokestatic 598	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   223: ifne +64 -> 287
    //   226: aload_0
    //   227: aload 4
    //   229: getfield 1154	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMx	Ljava/lang/String;
    //   232: putfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   235: aload_0
    //   236: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   239: instanceof 471
    //   242: ifeq +37 -> 279
    //   245: aload_0
    //   246: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   249: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   252: aload_0
    //   253: getfield 137	com/tencent/mm/plugin/sns/ui/ai:videoPath	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 135	com/tencent/mm/plugin/sns/ui/ai:thumbPath	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   264: aconst_null
    //   265: iconst_1
    //   266: invokevirtual 1157	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   269: aload_0
    //   270: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   273: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   276: invokevirtual 1160	com/tencent/mm/plugin/sns/ui/SnsUploadUI:edF	()V
    //   279: ldc_w 1123
    //   282: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_1
    //   286: ireturn
    //   287: aload_0
    //   288: aload 4
    //   290: getfield 1148	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMu	Ljava/lang/String;
    //   293: invokestatic 871	com/tencent/mm/vfs/i:aPK	(Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   299: goto -64 -> 235
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   307: aload_0
    //   308: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   311: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   314: ldc_w 391
    //   317: aload_0
    //   318: getfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   321: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   324: pop
    //   325: aload_2
    //   326: ldc_w 1162
    //   329: iconst_0
    //   330: invokevirtual 684	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   333: istore_1
    //   334: aload 4
    //   336: getfield 1165	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMA	Ljava/lang/String;
    //   339: astore_2
    //   340: aload_0
    //   341: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   344: instanceof 471
    //   347: ifeq +32 -> 379
    //   350: aload_0
    //   351: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   354: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   357: aload_2
    //   358: iconst_1
    //   359: iload_1
    //   360: aconst_null
    //   361: aconst_null
    //   362: aload_0
    //   363: getfield 575	com/tencent/mm/plugin/sns/ui/ai:zQd	I
    //   366: invokevirtual 1168	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   369: aload_0
    //   370: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   373: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   376: invokevirtual 1160	com/tencent/mm/plugin/sns/ui/SnsUploadUI:edF	()V
    //   379: ldc_w 1123
    //   382: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: iconst_1
    //   386: ireturn
    //   387: aload_2
    //   388: ldc_w 707
    //   391: invokevirtual 711	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   394: astore 4
    //   396: aload 4
    //   398: ifnull +131 -> 529
    //   401: aload 4
    //   403: ldc_w 713
    //   406: invokevirtual 719	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   409: ifnull +120 -> 529
    //   412: aload 4
    //   414: ldc_w 721
    //   417: invokevirtual 719	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   420: ifnull +109 -> 529
    //   423: ldc 228
    //   425: ldc_w 1170
    //   428: invokestatic 235	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   435: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   438: invokevirtual 1174	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   441: invokevirtual 1175	android/os/Bundle:clear	()V
    //   444: aload_0
    //   445: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   448: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   451: ldc_w 676
    //   454: iconst_0
    //   455: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   463: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   466: ldc_w 1177
    //   469: iconst_1
    //   470: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   478: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   481: ldc_w 1179
    //   484: bipush 14
    //   486: invokevirtual 1182	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   489: pop
    //   490: aload_0
    //   491: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   494: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   497: ldc_w 707
    //   500: aload_2
    //   501: ldc_w 707
    //   504: invokevirtual 711	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   507: invokevirtual 1185	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   510: pop
    //   511: aload_0
    //   512: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   515: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   518: invokevirtual 1160	com/tencent/mm/plugin/sns/ui/SnsUploadUI:edF	()V
    //   521: ldc_w 1123
    //   524: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: iconst_1
    //   528: ireturn
    //   529: aload_2
    //   530: ldc_w 1187
    //   533: invokevirtual 1191	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   536: astore 4
    //   538: aload 4
    //   540: ifnull +11 -> 551
    //   543: aload 4
    //   545: invokevirtual 1196	java/util/ArrayList:size	()I
    //   548: ifgt +16 -> 564
    //   551: aload_2
    //   552: ldc_w 1198
    //   555: invokevirtual 660	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   558: invokestatic 598	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   561: ifne +403 -> 964
    //   564: aload_0
    //   565: iconst_0
    //   566: putfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   569: aload_0
    //   570: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   573: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   576: ldc_w 391
    //   579: aload_0
    //   580: getfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   583: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   586: pop
    //   587: aload 4
    //   589: ifnull +124 -> 713
    //   592: aload 4
    //   594: invokevirtual 1196	java/util/ArrayList:size	()I
    //   597: ifle +116 -> 713
    //   600: aload 4
    //   602: iconst_0
    //   603: invokevirtual 1201	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   606: checkcast 513	java/lang/String
    //   609: astore 4
    //   611: aload_2
    //   612: ldc_w 1203
    //   615: invokevirtual 660	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   618: astore 5
    //   620: aload 5
    //   622: invokestatic 598	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   625: ifne +14 -> 639
    //   628: aload 5
    //   630: astore_2
    //   631: aload 5
    //   633: invokestatic 480	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   636: ifne +181 -> 817
    //   639: new 1006	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 1204	java/lang/StringBuilder:<init>	()V
    //   646: invokestatic 1207	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   649: invokevirtual 1014	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 4
    //   654: invokestatic 871	com/tencent/mm/vfs/i:aPK	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokevirtual 1014	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 1028	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: astore_2
    //   664: new 166	com/tencent/mm/compatible/h/d
    //   667: dup
    //   668: invokespecial 167	com/tencent/mm/compatible/h/d:<init>	()V
    //   671: astore 5
    //   673: aload 5
    //   675: aload 4
    //   677: invokevirtual 1212	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   680: aload 5
    //   682: lconst_0
    //   683: invokevirtual 1216	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   686: astore 6
    //   688: aload 6
    //   690: ifnonnull +35 -> 725
    //   693: ldc 228
    //   695: ldc_w 1218
    //   698: invokestatic 1220	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload 5
    //   703: invokevirtual 1222	android/media/MediaMetadataRetriever:release	()V
    //   706: goto -670 -> 36
    //   709: astore_2
    //   710: goto -674 -> 36
    //   713: aload_2
    //   714: ldc_w 1198
    //   717: invokevirtual 660	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   720: astore 4
    //   722: goto -111 -> 611
    //   725: ldc 228
    //   727: ldc_w 1224
    //   730: iconst_2
    //   731: anewarray 4	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload 6
    //   738: invokevirtual 956	android/graphics/Bitmap:getWidth	()I
    //   741: invokestatic 963	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: aload 6
    //   749: invokevirtual 953	android/graphics/Bitmap:getHeight	()I
    //   752: invokestatic 963	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: invokestatic 701	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: aload 6
    //   761: bipush 80
    //   763: getstatic 1230	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   766: aload_2
    //   767: iconst_1
    //   768: invokestatic 1233	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   771: pop
    //   772: aload_2
    //   773: invokestatic 1237	com/tencent/mm/sdk/platformtools/g:aQc	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   776: astore 6
    //   778: ldc 228
    //   780: ldc_w 1239
    //   783: iconst_2
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload 6
    //   791: getfield 1244	android/graphics/BitmapFactory$Options:outWidth	I
    //   794: invokestatic 963	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: aastore
    //   798: dup
    //   799: iconst_1
    //   800: aload 6
    //   802: getfield 1247	android/graphics/BitmapFactory$Options:outHeight	I
    //   805: invokestatic 963	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: aastore
    //   809: invokestatic 701	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: aload 5
    //   814: invokevirtual 1222	android/media/MediaMetadataRetriever:release	()V
    //   817: aload_0
    //   818: aload 4
    //   820: invokestatic 871	com/tencent/mm/vfs/i:aPK	(Ljava/lang/String;)Ljava/lang/String;
    //   823: putfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   826: ldc 228
    //   828: ldc_w 1249
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
    //   848: invokestatic 1022	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   851: invokestatic 1254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   854: aastore
    //   855: dup
    //   856: iconst_3
    //   857: aload_2
    //   858: invokestatic 1022	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   861: invokestatic 1254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   864: aastore
    //   865: invokestatic 701	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   868: aload_0
    //   869: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   872: instanceof 471
    //   875: ifeq +32 -> 907
    //   878: aload_0
    //   879: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   882: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   885: aload 4
    //   887: aload_2
    //   888: aload_0
    //   889: getfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   892: aconst_null
    //   893: iconst_0
    //   894: invokevirtual 1157	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   897: aload_0
    //   898: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   901: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   904: invokevirtual 1160	com/tencent/mm/plugin/sns/ui/SnsUploadUI:edF	()V
    //   907: ldc_w 1123
    //   910: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   913: iconst_1
    //   914: ireturn
    //   915: astore 6
    //   917: ldc 228
    //   919: ldc_w 1256
    //   922: iconst_1
    //   923: anewarray 4	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: aload 6
    //   930: invokevirtual 844	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   933: aastore
    //   934: invokestatic 767	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: aload 5
    //   939: invokevirtual 1222	android/media/MediaMetadataRetriever:release	()V
    //   942: goto -125 -> 817
    //   945: astore 5
    //   947: goto -130 -> 817
    //   950: astore_2
    //   951: aload 5
    //   953: invokevirtual 1222	android/media/MediaMetadataRetriever:release	()V
    //   956: ldc_w 1123
    //   959: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   962: aload_2
    //   963: athrow
    //   964: aload_0
    //   965: iconst_1
    //   966: putfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   969: aload_0
    //   970: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   973: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   976: ldc_w 391
    //   979: aload_0
    //   980: getfield 162	com/tencent/mm/plugin/sns/ui/ai:zTb	Z
    //   983: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   986: pop
    //   987: aload_2
    //   988: ldc_w 1258
    //   991: invokevirtual 1191	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   994: astore 4
    //   996: aload 4
    //   998: ifnull +11 -> 1009
    //   1001: aload 4
    //   1003: invokevirtual 1196	java/util/ArrayList:size	()I
    //   1006: ifne +19 -> 1025
    //   1009: ldc 228
    //   1011: ldc_w 1260
    //   1014: invokestatic 235	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1017: ldc_w 1123
    //   1020: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1023: iconst_0
    //   1024: ireturn
    //   1025: new 1193	java/util/ArrayList
    //   1028: dup
    //   1029: invokespecial 1261	java/util/ArrayList:<init>	()V
    //   1032: astore 5
    //   1034: aload 4
    //   1036: invokevirtual 1262	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1039: astore 6
    //   1041: aload 6
    //   1043: invokeinterface 507 1 0
    //   1048: ifeq +76 -> 1124
    //   1051: aload 6
    //   1053: invokeinterface 511 1 0
    //   1058: checkcast 513	java/lang/String
    //   1061: astore 7
    //   1063: aload 7
    //   1065: invokestatic 1268	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1068: invokevirtual 1272	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1071: astore 8
    //   1073: aload 8
    //   1075: ifnull -34 -> 1041
    //   1078: aload 5
    //   1080: ldc_w 1274
    //   1083: iconst_3
    //   1084: anewarray 4	java/lang/Object
    //   1087: dup
    //   1088: iconst_0
    //   1089: aload 7
    //   1091: aastore
    //   1092: dup
    //   1093: iconst_1
    //   1094: aload 8
    //   1096: getfield 1280	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1099: invokestatic 1285	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1102: aastore
    //   1103: dup
    //   1104: iconst_2
    //   1105: aload 8
    //   1107: getfield 1288	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1110: invokestatic 1285	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1113: aastore
    //   1114: invokestatic 1292	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1117: invokevirtual 1293	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1120: pop
    //   1121: goto -80 -> 1041
    //   1124: aload_2
    //   1125: ldc_w 1295
    //   1128: iconst_0
    //   1129: invokevirtual 310	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1132: istore_3
    //   1133: aload_2
    //   1134: ldc_w 1162
    //   1137: iconst_0
    //   1138: invokevirtual 684	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1141: istore_1
    //   1142: aload_0
    //   1143: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   1146: instanceof 471
    //   1149: ifeq -1113 -> 36
    //   1152: aload_0
    //   1153: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   1156: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1159: aconst_null
    //   1160: iload_3
    //   1161: iload_1
    //   1162: aload 4
    //   1164: aload 5
    //   1166: aload_0
    //   1167: getfield 575	com/tencent/mm/plugin/sns/ui/ai:zQd	I
    //   1170: invokevirtual 1168	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   1173: aload_0
    //   1174: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   1177: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1180: invokevirtual 1160	com/tencent/mm/plugin/sns/ui/SnsUploadUI:edF	()V
    //   1183: goto -1147 -> 36
    //   1186: astore 5
    //   1188: goto -371 -> 817
    //   1191: astore 4
    //   1193: goto -237 -> 956
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1196	0	this	ai
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ai
 * JD-Core Version:    0.7.0.1
 */