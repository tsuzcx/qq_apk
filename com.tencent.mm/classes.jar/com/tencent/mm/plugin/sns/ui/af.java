package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sw.b;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.f.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.QImageView.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class af
  implements ab, a.a
{
  private String appId;
  private String appName;
  String desc;
  private boolean dfO;
  private LinkedList<Long> fOc;
  ProgressDialog fpP;
  String gHu;
  MMActivity imP;
  private p lAj;
  private String mSessionId;
  String md5;
  private View pf;
  String syH;
  String thumbPath;
  String videoPath;
  private int wBl;
  private int wLo;
  private boolean wOm;
  private List<String> xkS;
  private int xlZ;
  private com.tencent.mm.modelsns.d xmf;
  private String xmg;
  private boolean xnv;
  private boolean xnw;
  private WXMediaMessage xnx;
  SightPlayImageView xoJ;
  private ImageView xoK;
  boolean xoL;
  private Bitmap xoM;
  private boj xoN;
  private String xoO;
  private boolean xoP;
  boolean xoQ;
  private int xoR;
  private MediaMetadataRetriever xoS;
  private int xoT;
  private int xoU;
  private int xoV;
  private Pair<Integer, Integer> xoW;
  private Bitmap xoX;
  boolean xoY;
  private boolean xoZ;
  com.tencent.mm.plugin.sns.ui.f.a xpa;
  private com.tencent.mm.sdk.b.c xpb;
  ba xpc;
  private int xpd;
  private int xpe;
  private org.b.d.i xpf;
  private String xpg;
  private bmn xph;
  private int xpi;
  private List<String> xpj;
  private PInt xpk;
  private String xpl;
  private int xpm;
  private int xpn;
  Runnable xpo;
  Runnable xpp;
  
  public af(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97999);
    this.pf = null;
    this.xoK = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.dfO = false;
    this.xoL = false;
    this.xoM = null;
    this.xmf = null;
    this.xoN = new boj();
    this.xnv = false;
    this.xnw = false;
    this.xnx = null;
    this.xoP = false;
    this.xoQ = false;
    this.xoR = 0;
    this.xoS = new com.tencent.mm.compatible.h.d();
    this.xoT = 0;
    this.xoU = 0;
    this.xoV = 90;
    this.xoW = null;
    this.xoX = null;
    this.xoY = false;
    this.xoZ = false;
    this.wLo = 1;
    this.xmg = "";
    this.xpb = new com.tencent.mm.sdk.b.c() {};
    this.xpc = null;
    this.xpd = 0;
    this.desc = "";
    this.fpP = null;
    this.xpo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97993);
        af.a(af.this);
        AppMethodBeat.o(97993);
      }
    };
    this.xpp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97995);
        ad.i("MicroMsg.SightWidget", "showProgress");
        af localaf = af.this;
        MMActivity localMMActivity = af.this.imP;
        af.this.imP.getString(2131755906);
        localaf.fpP = h.b(localMMActivity, af.this.imP.getString(2131763977), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(97994);
            af.this.xpc = null;
            af.this.xoL = false;
            aq.az(af.this.xpo);
            AppMethodBeat.o(97994);
          }
        });
        AppMethodBeat.o(97995);
      }
    };
    this.imP = paramMMActivity;
    this.xpa = new com.tencent.mm.plugin.sns.ui.f.a(paramMMActivity, this);
    AppMethodBeat.o(97999);
  }
  
  private void qf(boolean paramBoolean)
  {
    AppMethodBeat.i(98004);
    this.videoPath = "";
    this.thumbPath = "";
    this.xoQ = paramBoolean;
    if (paramBoolean)
    {
      this.imP.getIntent().putExtra("KSightThumbPath", this.thumbPath);
      this.imP.getIntent().putExtra("KSightPath", this.videoPath);
    }
    this.imP.getIntent().putExtra("KSightDeleted", this.xoQ);
    this.xoV = 90;
    if (q.I(this.xoX))
    {
      this.xoX.recycle();
      this.xoX = null;
    }
    AppMethodBeat.o(98004);
  }
  
  final void Nk(int paramInt)
  {
    AppMethodBeat.i(98007);
    cl localcl = new cl().QD();
    localcl.dRw = paramInt;
    localcl.jf(this.xoO).aBj();
    AppMethodBeat.o(98007);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98003);
    if (this.xpa.dDZ())
    {
      this.lAj = h.b(this.imP, this.imP.getString(2131762543), true, null);
      this.xpe = paramInt1;
      this.wBl = paramInt2;
      this.xpf = parami;
      this.xpg = paramString1;
      this.xkS = paramList1;
      this.xph = parambmn;
      this.fOc = paramLinkedList;
      this.xpi = paramInt3;
      this.wOm = paramBoolean;
      this.xpj = paramList2;
      this.xpk = paramPInt;
      this.xpl = paramString2;
      this.xpm = paramInt4;
      this.xpn = paramInt5;
      ((SnsUploadUI)this.imP).xKr = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (!com.tencent.mm.vfs.i.eK(this.videoPath))
    {
      aq.f(new af.3(this));
      ((SnsUploadUI)this.imP).xKr = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.xpc != null)
    {
      ((SnsUploadUI)this.imP).xKr = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.xoL)
    {
      AppMethodBeat.o(98003);
      return true;
    }
    this.xoL = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          cwk localcwk = new cwk();
          localcwk.mAQ = paramString2;
          parami.add(localcwk);
        }
      }
    }
    this.xpc = new ba(15);
    paramPInt.value = this.xpc.aTB;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.wzN) {
      this.xpc.Ms(3);
    }
    paramString1 = this.xpc.aoS(paramString1);
    new LinkedList();
    paramString1.a(parambmn).aM(parami).Mu(paramInt1).Mv(paramInt2).fq(paramList2);
    if (paramBoolean) {
      this.xpc.Mx(1);
    }
    for (;;)
    {
      this.xpc.bR(this.wLo, this.xmg);
      this.xpc.fq(paramList2);
      this.xpc.Mw(this.xlZ);
      this.xpc.dzk = this.xoN;
      this.xpc.g(null, null, null, paramInt4, paramInt5);
      this.xpc.setSessionId(this.mSessionId);
      if (!bt.isNullOrNil(this.appId)) {
        this.xpc.aoY(this.appId);
      }
      if (!bt.isNullOrNil(this.appName)) {
        this.xpc.aoZ(bt.by(this.appName, ""));
      }
      if (this.xnv) {
        this.xpc.Mw(5);
      }
      if ((this.xnw) && (this.xnx != null))
      {
        this.xpc.aoT(this.xnx.mediaTagName);
        this.xpc.au(this.appId, this.xnx.messageExt, this.xnx.messageAction);
      }
      aq.n(this.xpp, 700L);
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97992);
          af localaf = af.this;
          long l = System.currentTimeMillis();
          Object localObject1;
          String str4;
          Object localObject3;
          Object localObject2;
          String str1;
          String str2;
          String str3;
          Object localObject4;
          if ((!TextUtils.isEmpty(localaf.syH)) && (!TextUtils.isEmpty(localaf.gHu)))
          {
            localObject1 = localaf.xpc;
            str4 = localaf.videoPath;
            localObject3 = localaf.thumbPath;
            localObject2 = localaf.desc;
            str1 = localaf.md5;
            str2 = localaf.syH;
            str3 = localaf.gHu;
            localObject4 = com.tencent.mm.plugin.recordvideo.e.c.vtL;
            localObject4 = com.tencent.mm.plugin.recordvideo.e.c.alZ(str4);
            if (localObject4 == null) {
              break label622;
            }
            ad.i("MicroMsg.UploadPackHelper", "addSightObjectByUrl commit video_info:".concat(String.valueOf(localObject4)));
          }
          label533:
          label606:
          label622:
          for (float f = ((c.a)localObject4).duration / 1000.0F;; f = 0.0F)
          {
            localObject4 = com.tencent.mm.plugin.sns.model.af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str4.getBytes());
            ba.apc((String)localObject4);
            com.tencent.mm.vfs.i.lC(str4, (String)localObject4);
            str4 = com.tencent.mm.plugin.sns.model.af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(((String)localObject3).getBytes());
            com.tencent.mm.vfs.i.lC((String)localObject3, str4);
            localObject3 = ba.b("", (String)localObject4, str4, str1, str2, str3);
            int i;
            if (localObject3 == null)
            {
              ad.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
              i = 0;
              if (i != 0) {
                break label533;
              }
              ad.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.i.aMN(localaf.videoPath) + " thumb: " + com.tencent.mm.vfs.i.aMN(localaf.thumbPath) + ",cdnUrl " + localaf.syH + "cdnThubmUrl " + localaf.gHu);
              aq.f(new af.7(localaf));
            }
            for (;;)
            {
              ad.i("MicroMsg.SightWidget", "removeRunnable showProgress");
              aq.az(af.this.xpp);
              if (af.this.xpc != null) {
                break label606;
              }
              AppMethodBeat.o(97992);
              return;
              ((bpi)localObject3).Desc = ((String)localObject2);
              if (bt.isNullOrNil(((bpi)localObject3).Title)) {
                ((bpi)localObject3).Title = ((String)localObject2);
              }
              ((bpi)localObject3).DNm = f;
              ((ba)localObject1).wLh.Etm.DaC.add(localObject3);
              localObject2 = new bmh();
              ((bmh)localObject2).DJN = ((bpi)localObject3).dzf;
              ((ba)localObject1).wLi.DNp.add(localObject2);
              i = 1;
              break;
              if (!localaf.xpc.w(localaf.videoPath, localaf.thumbPath, localaf.desc, localaf.md5))
              {
                ad.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.i.aMN(localaf.videoPath) + " thumb: " + com.tencent.mm.vfs.i.aMN(localaf.thumbPath));
                aq.f(new af.8(localaf));
              }
              else
              {
                if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqy, true))
                {
                  localObject1 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
                  com.tencent.mm.plugin.recordvideo.e.b.alS(localaf.videoPath);
                  localObject1 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
                  com.tencent.mm.plugin.recordvideo.e.b.alS(localaf.thumbPath);
                }
                ad.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            aq.f(af.this.xpo);
            AppMethodBeat.o(97992);
            return;
          }
        }
      }, "sight_send_ready");
      AppMethodBeat.o(98003);
      return true;
      this.xpc.Mx(0);
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(98000);
    this.xmf = com.tencent.mm.modelsns.d.w(this.imP.getIntent());
    this.syH = bt.by(this.imP.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.gHu = bt.by(this.imP.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.xnv = this.imP.getIntent().getBooleanExtra("KThrid_app", false);
    this.xnw = this.imP.getIntent().getBooleanExtra("KSnsAction", false);
    this.xoP = this.imP.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.xoY = this.imP.getIntent().getBooleanExtra("KBlockAdd", false);
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = bt.by(this.imP.getIntent().getStringExtra("reportSessionId"), "");
    this.xoO = this.imP.getIntent().getStringExtra("KSessionID");
    this.xoZ = this.imP.getIntent().getBooleanExtra("KSnsUploadFromSkipCompress", false);
    ad.i("MicroMsg.SightWidget", "mIsFromSkipCompress:%s, appId:%s", new Object[] { Boolean.valueOf(this.xoZ), this.appId });
    paramBundle = this.xpa;
    Object localObject1 = this.imP;
    ad.i("MicroMsg.SnsFakeVLogHelper", "resetFakeData");
    Bundle localBundle = ((MMActivity)localObject1).getIntent().getBundleExtra("key_extra_data");
    if ((localBundle == null) || (localBundle.getByteArray("key_bg_generate_pb") == null) || (localBundle.getByteArray("key_bg_generate_extra_config") == null)) {}
    for (;;)
    {
      paramBundle = this.imP.getIntent().getBundleExtra("Ksnsupload_timeline");
      if (paramBundle != null) {
        this.xnx = new SendMessageToWX.Req(paramBundle).message;
      }
      this.thumbPath = this.imP.getIntent().getStringExtra("KSightThumbPath");
      this.videoPath = this.imP.getIntent().getStringExtra("KSightPath");
      this.xoQ = this.imP.getIntent().getBooleanExtra("KSightDeleted", false);
      this.md5 = this.imP.getIntent().getStringExtra("sight_md5");
      paramBundle = this.imP.getIntent().getByteArrayExtra("KMMSightExtInfo");
      if (paramBundle != null) {}
      try
      {
        this.xoN.parseFrom(paramBundle);
        if (this.xoN == null)
        {
          this.xoN = new boj();
          this.xoN.DLK = this.xoP;
        }
        this.xoN.dlB = this.mSessionId;
        this.xoN.DLO = this.xoZ;
        this.xoN.DLP = this.appId;
        paramBundle = new sw();
        paramBundle.dyt.type = 2;
        com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
        if (bt.isNullOrNil(this.videoPath))
        {
          this.videoPath = bt.by(paramBundle.dyu.dyy, "");
          ad.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
        }
        if (bt.isNullOrNil(this.md5))
        {
          paramBundle = bt.by(paramBundle.dyu.dyw, "");
          this.md5 = paramBundle;
          ad.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
          com.tencent.mm.sdk.b.a.ESL.c(this.xpb);
          if (this.xoR != 0) {
            break label961;
          }
          com.tencent.mm.plugin.sns.model.af.dtj();
          i = u.getScreenWidth();
          if (i != 0) {
            break label922;
          }
          AppMethodBeat.o(98000);
          return;
          localObject2 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightThumbPath");
          localObject3 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightPath");
          if ((com.tencent.mm.vfs.i.eK((String)localObject2)) && (com.tencent.mm.vfs.i.eK((String)localObject3)))
          {
            ad.i("MicroMsg.SnsFakeVLogHelper", "jump generate");
            continue;
          }
          ad.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper go bg generate");
          paramBundle.vEq = false;
          localObject2 = com.tencent.mm.plugin.recordvideo.background.a.vdo;
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
            paramBundle.xWK = ((acq)new acq().parseFrom((byte[])localObject2));
            paramBundle.xWL = ((VideoMixer.MixConfig)localBundle.getParcelable("key_bg_generate_mix_config"));
            paramBundle.xWM = ((aer)new aer().parseFrom((byte[])localObject3));
            label850:
            ((MMActivity)localObject1).getIntent().putExtra("KSightThumbPath", paramBundle.xWK.thumbPath);
            paramBundle = paramBundle.xWL;
            localObject1 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
            com.tencent.mm.plugin.recordvideo.background.f.a((byte[])localObject2, paramBundle, (byte[])localObject3, 7);
            break;
            paramBundle = paramBundle;
            ad.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
            continue;
            paramBundle = this.md5;
          }
          label922:
          this.xoR = ((i - this.imP.getResources().getDimensionPixelSize(2131166845) * 4 - this.imP.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
          label961:
          if (this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
          for (this.wLo = 1;; this.wLo = 0)
          {
            this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
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
  
  public final void ag(Bundle paramBundle) {}
  
  public final boolean dyU()
  {
    return !this.xoQ;
  }
  
  public final View dyV()
  {
    AppMethodBeat.i(98001);
    this.pf = View.inflate(this.imP, 2131495818, null);
    this.xoJ = ((SightPlayImageView)this.pf.findViewById(2131305798));
    this.xoK = ((ImageView)this.pf.findViewById(2131305196));
    Object localObject = new DisplayMetrics();
    this.imP.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.xoU = com.tencent.mm.cd.a.fromDPToPix(this.imP, 100);
    this.xoT = com.tencent.mm.cd.a.fromDPToPix(this.imP, 100);
    if ((!TextUtils.isEmpty(this.thumbPath)) && (com.tencent.mm.vfs.i.eK(this.thumbPath)))
    {
      ad.i("MicroMsg.SightWidget", "getBitmapNative thumbPath:%s", new Object[] { this.thumbPath });
      this.xoX = com.tencent.mm.sdk.platformtools.f.aFi(this.thumbPath);
    }
    if (this.xoX == null)
    {
      ad.i("MicroMsg.SightWidget", "getVideoThumb videoPath:%s", new Object[] { this.videoPath });
      this.xoX = com.tencent.mm.plugin.mmsight.d.zg(this.videoPath);
    }
    if (this.xoX != null)
    {
      this.xoU = this.xoX.getHeight();
      this.xoT = this.xoX.getWidth();
      ad.i("MicroMsg.SightWidget", "mSightHeight:%s", new Object[] { Integer.valueOf(this.xoU) });
      ad.i("MicroMsg.SightWidget", "mSightWidth:%s", new Object[] { Integer.valueOf(this.xoT) });
    }
    this.xoW = com.tencent.mm.modelsns.g.a(this.xoT, this.xoU, this.imP, false);
    ad.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.xoT), Integer.valueOf(this.xoU), this.xoW.first, this.xoW.second, Integer.valueOf(this.xoV) });
    dzr();
    this.xoJ.setScaleType(QImageView.a.HBy);
    this.xoJ.wsy = true;
    this.xoJ.setOnClickListener(new af.2(this));
    ad.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.i.aMN(this.videoPath) + " " + com.tencent.mm.vfs.i.aMN(this.thumbPath));
    if (com.tencent.mm.vfs.i.eK(this.videoPath)) {
      ad.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    localObject = this.pf;
    AppMethodBeat.o(98001);
    return localObject;
  }
  
  public final boolean dyW()
  {
    AppMethodBeat.i(98006);
    if (this.fpP != null) {
      this.fpP.dismiss();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.xpb);
    if (q.I(this.xoM)) {
      this.xoM.recycle();
    }
    com.tencent.mm.plugin.sns.ui.f.a locala = this.xpa;
    ad.i("MicroMsg.SnsFakeVLogHelper", "release");
    com.tencent.mm.plugin.recordvideo.background.a locala1 = com.tencent.mm.plugin.recordvideo.background.a.vdo;
    com.tencent.mm.plugin.recordvideo.background.a.b(7, locala);
    qf(false);
    AppMethodBeat.o(98006);
    return false;
  }
  
  final void dzr()
  {
    AppMethodBeat.i(98008);
    if ((this.xoX != null) && (!this.xoX.isRecycled()))
    {
      this.xoJ.setImageBitmap(this.xoX);
      this.xoJ.gW(((Integer)this.xoW.first).intValue(), ((Integer)this.xoW.second).intValue());
    }
    AppMethodBeat.o(98008);
  }
  
  final void dzs()
  {
    AppMethodBeat.i(98009);
    this.xoK.setVisibility(8);
    this.xoJ.wsq.clear();
    this.xoJ.gW(com.tencent.mm.cd.a.fromDPToPix(this.imP, 100), com.tencent.mm.cd.a.fromDPToPix(this.imP, 100));
    this.xoJ.setBackgroundResource(2131100938);
    this.xoJ.setImageResource(2131689536);
    this.xoJ.setContentDescription(this.xoJ.getContext().getString(2131763774));
    int i = com.tencent.mm.cd.a.fromDPToPix(this.imP, 100) * 35 / 100;
    this.xoJ.setPadding(i, i, i, i);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqy, true))
    {
      com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      com.tencent.mm.plugin.recordvideo.e.b.alS(this.videoPath);
      localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      com.tencent.mm.plugin.recordvideo.e.b.alS(this.thumbPath);
    }
    AppMethodBeat.o(98009);
  }
  
  public final boolean dzt()
  {
    if (this.xoN != null) {
      return this.xoN.DLK;
    }
    return false;
  }
  
  public final void e(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(98002);
    this.videoPath = paramCaptureVideoNormalModel.videoPath;
    this.thumbPath = paramCaptureVideoNormalModel.thumbPath;
    this.imP.getIntent().putExtra("KSightThumbPath", this.thumbPath);
    this.imP.getIntent().putExtra("KSightPath", this.videoPath);
    this.md5 = com.tencent.mm.vfs.i.aEN(paramCaptureVideoNormalModel.videoPath);
    if ((this.lAj != null) && (this.lAj.isShowing()))
    {
      this.lAj.dismiss();
      a(this.xpe, this.wBl, this.xpf, this.xpg, this.xkS, this.xph, this.fOc, this.xpi, this.wOm, this.xpj, this.xpk, this.xpl, this.xpm, this.xpn);
    }
    AppMethodBeat.o(98002);
  }
  
  /* Error */
  public final boolean j(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1116
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+29 -> 36, 9:+380->387, 10:+29->36, 11:+142->149, 12:+37->44
    //   37: iconst_1
    //   38: dup2
    //   39: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_2
    //   45: ifnull -9 -> 36
    //   48: aload_0
    //   49: aload_2
    //   50: ldc_w 1118
    //   53: iconst_0
    //   54: invokevirtual 298	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   57: putfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   60: aload_0
    //   61: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   64: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc_w 379
    //   70: aload_0
    //   71: getfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   74: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   77: pop
    //   78: aload_0
    //   79: getfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   82: ifeq +59 -> 141
    //   85: aload_0
    //   86: getfield 203	com/tencent/mm/plugin/sns/ui/af:xpa	Lcom/tencent/mm/plugin/sns/ui/f/a;
    //   89: astore_2
    //   90: ldc_w 694
    //   93: ldc_w 1120
    //   96: invokestatic 223	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic 788	com/tencent/mm/plugin/recordvideo/background/a:vdo	Lcom/tencent/mm/plugin/recordvideo/background/a;
    //   102: astore 4
    //   104: bipush 7
    //   106: aload_2
    //   107: invokestatic 1014	com/tencent/mm/plugin/recordvideo/background/a:b	(ILcom/tencent/mm/plugin/recordvideo/background/b;)V
    //   110: aload_2
    //   111: getfield 1123	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   114: invokestatic 908	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +15 -> 132
    //   120: getstatic 826	com/tencent/mm/plugin/recordvideo/background/f:vdH	Lcom/tencent/mm/plugin/recordvideo/background/f;
    //   123: astore 4
    //   125: aload_2
    //   126: getfield 1123	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   129: invokestatic 1126	com/tencent/mm/plugin/recordvideo/background/f:alB	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual 1128	com/tencent/mm/plugin/sns/ui/af:dzs	()V
    //   136: aload_0
    //   137: iconst_1
    //   138: invokespecial 1016	com/tencent/mm/plugin/sns/ui/af:qf	(Z)V
    //   141: ldc_w 1116
    //   144: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_2
    //   150: ldc_w 1130
    //   153: invokevirtual 1133	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   156: checkcast 1135	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull -127 -> 36
    //   166: aload 4
    //   168: getfield 1138	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAP	Z
    //   171: ifne +131 -> 302
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   179: aload_0
    //   180: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   183: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   186: ldc_w 379
    //   189: aload_0
    //   190: getfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   193: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   196: pop
    //   197: aload_0
    //   198: aload 4
    //   200: getfield 1141	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAR	Ljava/lang/String;
    //   203: putfield 125	com/tencent/mm/plugin/sns/ui/af:videoPath	Ljava/lang/String;
    //   206: aload_0
    //   207: aload 4
    //   209: getfield 1144	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAS	Ljava/lang/String;
    //   212: putfield 123	com/tencent/mm/plugin/sns/ui/af:thumbPath	Ljava/lang/String;
    //   215: aload 4
    //   217: getfield 1147	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAU	Ljava/lang/String;
    //   220: invokestatic 588	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   223: ifne +64 -> 287
    //   226: aload_0
    //   227: aload 4
    //   229: getfield 1147	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAU	Ljava/lang/String;
    //   232: putfield 127	com/tencent/mm/plugin/sns/ui/af:md5	Ljava/lang/String;
    //   235: aload_0
    //   236: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   239: instanceof 459
    //   242: ifeq +37 -> 279
    //   245: aload_0
    //   246: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   249: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   252: aload_0
    //   253: getfield 125	com/tencent/mm/plugin/sns/ui/af:videoPath	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 123	com/tencent/mm/plugin/sns/ui/af:thumbPath	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 127	com/tencent/mm/plugin/sns/ui/af:md5	Ljava/lang/String;
    //   264: aconst_null
    //   265: iconst_1
    //   266: invokevirtual 1150	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   269: aload_0
    //   270: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   273: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   276: invokevirtual 1153	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   279: ldc_w 1116
    //   282: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_1
    //   286: ireturn
    //   287: aload_0
    //   288: aload 4
    //   290: getfield 1141	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAR	Ljava/lang/String;
    //   293: invokestatic 1105	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 127	com/tencent/mm/plugin/sns/ui/af:md5	Ljava/lang/String;
    //   299: goto -64 -> 235
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   307: aload_0
    //   308: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   311: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   314: ldc_w 379
    //   317: aload_0
    //   318: getfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   321: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   324: pop
    //   325: aload_2
    //   326: ldc_w 1155
    //   329: iconst_0
    //   330: invokevirtual 675	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   333: istore_1
    //   334: aload 4
    //   336: getfield 1158	com/tencent/mm/plugin/mmsight/SightCaptureResult:tAX	Ljava/lang/String;
    //   339: astore_2
    //   340: aload_0
    //   341: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   344: instanceof 459
    //   347: ifeq +32 -> 379
    //   350: aload_0
    //   351: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   354: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   357: aload_2
    //   358: iconst_1
    //   359: iload_1
    //   360: aconst_null
    //   361: aconst_null
    //   362: aload_0
    //   363: getfield 565	com/tencent/mm/plugin/sns/ui/af:xlZ	I
    //   366: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   369: aload_0
    //   370: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   373: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   376: invokevirtual 1153	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   379: ldc_w 1116
    //   382: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: iconst_1
    //   386: ireturn
    //   387: aload_2
    //   388: ldc_w 698
    //   391: invokevirtual 702	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   394: astore 4
    //   396: aload 4
    //   398: ifnull +131 -> 529
    //   401: aload 4
    //   403: ldc_w 704
    //   406: invokevirtual 710	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   409: ifnull +120 -> 529
    //   412: aload 4
    //   414: ldc_w 712
    //   417: invokevirtual 710	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   420: ifnull +109 -> 529
    //   423: ldc 216
    //   425: ldc_w 1163
    //   428: invokestatic 223	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   435: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   438: invokevirtual 1167	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   441: invokevirtual 1168	android/os/Bundle:clear	()V
    //   444: aload_0
    //   445: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   448: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   451: ldc_w 667
    //   454: iconst_0
    //   455: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   463: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   466: ldc_w 1170
    //   469: iconst_1
    //   470: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   478: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   481: ldc_w 1172
    //   484: bipush 14
    //   486: invokevirtual 1175	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   489: pop
    //   490: aload_0
    //   491: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   494: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   497: ldc_w 698
    //   500: aload_2
    //   501: ldc_w 698
    //   504: invokevirtual 702	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   507: invokevirtual 1178	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   510: pop
    //   511: aload_0
    //   512: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   515: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   518: invokevirtual 1153	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   521: ldc_w 1116
    //   524: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: iconst_1
    //   528: ireturn
    //   529: aload_2
    //   530: ldc_w 1180
    //   533: invokevirtual 1184	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   536: astore 4
    //   538: aload 4
    //   540: ifnull +11 -> 551
    //   543: aload 4
    //   545: invokevirtual 1189	java/util/ArrayList:size	()I
    //   548: ifgt +16 -> 564
    //   551: aload_2
    //   552: ldc_w 1191
    //   555: invokevirtual 651	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   558: invokestatic 588	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   561: ifne +403 -> 964
    //   564: aload_0
    //   565: iconst_0
    //   566: putfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   569: aload_0
    //   570: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   573: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   576: ldc_w 379
    //   579: aload_0
    //   580: getfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   583: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   586: pop
    //   587: aload 4
    //   589: ifnull +124 -> 713
    //   592: aload 4
    //   594: invokevirtual 1189	java/util/ArrayList:size	()I
    //   597: ifle +116 -> 713
    //   600: aload 4
    //   602: iconst_0
    //   603: invokevirtual 1194	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   606: checkcast 503	java/lang/String
    //   609: astore 4
    //   611: aload_2
    //   612: ldc_w 1196
    //   615: invokevirtual 651	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   618: astore 5
    //   620: aload 5
    //   622: invokestatic 588	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   625: ifne +14 -> 639
    //   628: aload 5
    //   630: astore_2
    //   631: aload 5
    //   633: invokestatic 468	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   636: ifne +181 -> 817
    //   639: new 982	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 1197	java/lang/StringBuilder:<init>	()V
    //   646: invokestatic 1200	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   649: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 4
    //   654: invokestatic 1105	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 1004	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: astore_2
    //   664: new 154	com/tencent/mm/compatible/h/d
    //   667: dup
    //   668: invokespecial 155	com/tencent/mm/compatible/h/d:<init>	()V
    //   671: astore 5
    //   673: aload 5
    //   675: aload 4
    //   677: invokevirtual 1205	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   680: aload 5
    //   682: lconst_0
    //   683: invokevirtual 1209	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   686: astore 6
    //   688: aload 6
    //   690: ifnonnull +35 -> 725
    //   693: ldc 216
    //   695: ldc_w 1211
    //   698: invokestatic 1213	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload 5
    //   703: invokevirtual 1215	android/media/MediaMetadataRetriever:release	()V
    //   706: goto -670 -> 36
    //   709: astore_2
    //   710: goto -674 -> 36
    //   713: aload_2
    //   714: ldc_w 1191
    //   717: invokevirtual 651	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   720: astore 4
    //   722: goto -111 -> 611
    //   725: ldc 216
    //   727: ldc_w 1217
    //   730: iconst_2
    //   731: anewarray 4	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload 6
    //   738: invokevirtual 929	android/graphics/Bitmap:getWidth	()I
    //   741: invokestatic 936	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: aload 6
    //   749: invokevirtual 926	android/graphics/Bitmap:getHeight	()I
    //   752: invokestatic 936	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: invokestatic 692	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: aload 6
    //   761: bipush 80
    //   763: getstatic 1223	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   766: aload_2
    //   767: iconst_1
    //   768: invokestatic 1226	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   771: pop
    //   772: aload_2
    //   773: invokestatic 1230	com/tencent/mm/sdk/platformtools/f:aFf	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   776: astore 6
    //   778: ldc 216
    //   780: ldc_w 1232
    //   783: iconst_2
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload 6
    //   791: getfield 1237	android/graphics/BitmapFactory$Options:outWidth	I
    //   794: invokestatic 936	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: aastore
    //   798: dup
    //   799: iconst_1
    //   800: aload 6
    //   802: getfield 1240	android/graphics/BitmapFactory$Options:outHeight	I
    //   805: invokestatic 936	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: aastore
    //   809: invokestatic 692	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: aload 5
    //   814: invokevirtual 1215	android/media/MediaMetadataRetriever:release	()V
    //   817: aload_0
    //   818: aload 4
    //   820: invokestatic 1105	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
    //   823: putfield 127	com/tencent/mm/plugin/sns/ui/af:md5	Ljava/lang/String;
    //   826: ldc 216
    //   828: ldc_w 1242
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
    //   848: invokestatic 998	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   851: invokestatic 1247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   854: aastore
    //   855: dup
    //   856: iconst_3
    //   857: aload_2
    //   858: invokestatic 998	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   861: invokestatic 1247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   864: aastore
    //   865: invokestatic 692	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   868: aload_0
    //   869: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   872: instanceof 459
    //   875: ifeq +32 -> 907
    //   878: aload_0
    //   879: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   882: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   885: aload 4
    //   887: aload_2
    //   888: aload_0
    //   889: getfield 127	com/tencent/mm/plugin/sns/ui/af:md5	Ljava/lang/String;
    //   892: aconst_null
    //   893: iconst_0
    //   894: invokevirtual 1150	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   897: aload_0
    //   898: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   901: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   904: invokevirtual 1153	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   907: ldc_w 1116
    //   910: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   913: iconst_1
    //   914: ireturn
    //   915: astore 6
    //   917: ldc 216
    //   919: ldc_w 1249
    //   922: iconst_1
    //   923: anewarray 4	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: aload 6
    //   930: invokevirtual 835	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   933: aastore
    //   934: invokestatic 758	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: aload 5
    //   939: invokevirtual 1215	android/media/MediaMetadataRetriever:release	()V
    //   942: goto -125 -> 817
    //   945: astore 5
    //   947: goto -130 -> 817
    //   950: astore_2
    //   951: aload 5
    //   953: invokevirtual 1215	android/media/MediaMetadataRetriever:release	()V
    //   956: ldc_w 1116
    //   959: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   962: aload_2
    //   963: athrow
    //   964: aload_0
    //   965: iconst_1
    //   966: putfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   969: aload_0
    //   970: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   973: invokevirtual 290	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   976: ldc_w 379
    //   979: aload_0
    //   980: getfield 150	com/tencent/mm/plugin/sns/ui/af:xoQ	Z
    //   983: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   986: pop
    //   987: aload_2
    //   988: ldc_w 1251
    //   991: invokevirtual 1184	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   994: astore 4
    //   996: aload 4
    //   998: ifnull +11 -> 1009
    //   1001: aload 4
    //   1003: invokevirtual 1189	java/util/ArrayList:size	()I
    //   1006: ifne +19 -> 1025
    //   1009: ldc 216
    //   1011: ldc_w 1253
    //   1014: invokestatic 223	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1017: ldc_w 1116
    //   1020: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1023: iconst_0
    //   1024: ireturn
    //   1025: new 1186	java/util/ArrayList
    //   1028: dup
    //   1029: invokespecial 1254	java/util/ArrayList:<init>	()V
    //   1032: astore 5
    //   1034: aload 4
    //   1036: invokevirtual 1255	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1039: astore 6
    //   1041: aload 6
    //   1043: invokeinterface 497 1 0
    //   1048: ifeq +76 -> 1124
    //   1051: aload 6
    //   1053: invokeinterface 501 1 0
    //   1058: checkcast 503	java/lang/String
    //   1061: astore 7
    //   1063: aload 7
    //   1065: invokestatic 1261	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1068: invokevirtual 1265	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1071: astore 8
    //   1073: aload 8
    //   1075: ifnull -34 -> 1041
    //   1078: aload 5
    //   1080: ldc_w 1267
    //   1083: iconst_3
    //   1084: anewarray 4	java/lang/Object
    //   1087: dup
    //   1088: iconst_0
    //   1089: aload 7
    //   1091: aastore
    //   1092: dup
    //   1093: iconst_1
    //   1094: aload 8
    //   1096: getfield 1273	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1099: invokestatic 1278	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1102: aastore
    //   1103: dup
    //   1104: iconst_2
    //   1105: aload 8
    //   1107: getfield 1281	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1110: invokestatic 1278	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1113: aastore
    //   1114: invokestatic 1285	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1117: invokevirtual 1286	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1120: pop
    //   1121: goto -80 -> 1041
    //   1124: aload_2
    //   1125: ldc_w 1288
    //   1128: iconst_0
    //   1129: invokevirtual 298	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1132: istore_3
    //   1133: aload_2
    //   1134: ldc_w 1155
    //   1137: iconst_0
    //   1138: invokevirtual 675	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1141: istore_1
    //   1142: aload_0
    //   1143: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1146: instanceof 459
    //   1149: ifeq -1113 -> 36
    //   1152: aload_0
    //   1153: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1156: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1159: aconst_null
    //   1160: iload_3
    //   1161: iload_1
    //   1162: aload 4
    //   1164: aload 5
    //   1166: aload_0
    //   1167: getfield 565	com/tencent/mm/plugin/sns/ui/af:xlZ	I
    //   1170: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   1173: aload_0
    //   1174: getfield 196	com/tencent/mm/plugin/sns/ui/af:imP	Lcom/tencent/mm/ui/MMActivity;
    //   1177: checkcast 459	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1180: invokevirtual 1153	com/tencent/mm/plugin/sns/ui/SnsUploadUI:dCP	()V
    //   1183: goto -1147 -> 36
    //   1186: astore 5
    //   1188: goto -371 -> 817
    //   1191: astore 4
    //   1193: goto -237 -> 956
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1196	0	this	af
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.af
 * JD-Core Version:    0.7.0.1
 */