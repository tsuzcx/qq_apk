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
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.a.ty.b;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
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
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.f.a.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
import org.b.d.i;

public final class ai
  implements ac, a.a
{
  private List<String> Agd;
  private int Ahk;
  private com.tencent.mm.modelsns.e Ahq;
  private String Ahr;
  private boolean AiJ;
  private boolean AiK;
  private WXMediaMessage AiL;
  private List<String> AkA;
  private PInt AkB;
  private String AkC;
  private int AkD;
  private int AkE;
  Runnable AkF;
  Runnable AkG;
  SightPlayImageView Akb;
  private ImageView Akc;
  boolean Akd;
  private Bitmap Ake;
  private byg Akf;
  private String Akg;
  private boolean Akh;
  boolean Aki;
  private int Akj;
  private MediaMetadataRetriever Akk;
  private int Akl;
  private int Akm;
  private int Akn;
  private Pair<Integer, Integer> Ako;
  private Bitmap Akp;
  boolean Akq;
  private boolean Akr;
  com.tencent.mm.plugin.sns.ui.f.a Aks;
  bd Akt;
  private int Aku;
  private int Akv;
  private i Akw;
  private String Akx;
  private bwk Aky;
  private int Akz;
  private String appId;
  private String appName;
  String desc;
  private boolean dpK;
  MMActivity fNT;
  ProgressDialog fOC;
  String gKg;
  private LinkedList<Long> gnJ;
  String hCS;
  private p mHs;
  private String mSessionId;
  String md5;
  private View rY;
  private com.tencent.mm.sdk.b.c seA;
  String thumbPath;
  String videoPath;
  private int zFi;
  private boolean zIe;
  private int zuq;
  
  public ai(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97999);
    this.rY = null;
    this.Akc = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.dpK = false;
    this.Akd = false;
    this.Ake = null;
    this.Ahq = null;
    this.Akf = new byg();
    this.AiJ = false;
    this.AiK = false;
    this.AiL = null;
    this.Akh = false;
    this.Aki = false;
    this.Akj = 0;
    this.Akk = new com.tencent.mm.compatible.h.d();
    this.Akl = 0;
    this.Akm = 0;
    this.Akn = 90;
    this.Ako = null;
    this.Akp = null;
    this.Akq = false;
    this.Akr = false;
    this.zFi = 1;
    this.Ahr = "";
    this.seA = new com.tencent.mm.sdk.b.c() {};
    this.Akt = null;
    this.Aku = 0;
    this.desc = "";
    this.fOC = null;
    this.AkF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97993);
        ai.a(ai.this);
        AppMethodBeat.o(97993);
      }
    };
    this.AkG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97995);
        ae.i("MicroMsg.SightWidget", "showProgress");
        ai localai = ai.this;
        MMActivity localMMActivity = ai.this.fNT;
        ai.this.fNT.getString(2131755906);
        localai.fOC = com.tencent.mm.ui.base.h.b(localMMActivity, ai.this.fNT.getString(2131763977), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(97994);
            ai.this.Akt = null;
            ai.this.Akd = false;
            ar.ay(ai.this.AkF);
            AppMethodBeat.o(97994);
          }
        });
        AppMethodBeat.o(97995);
      }
    };
    this.fNT = paramMMActivity;
    this.Aks = new com.tencent.mm.plugin.sns.ui.f.a(paramMMActivity, this);
    AppMethodBeat.o(97999);
  }
  
  private void rP(boolean paramBoolean)
  {
    AppMethodBeat.i(98004);
    this.videoPath = "";
    this.thumbPath = "";
    this.Aki = paramBoolean;
    if (paramBoolean)
    {
      this.fNT.getIntent().putExtra("KSightThumbPath", this.thumbPath);
      this.fNT.getIntent().putExtra("KSightPath", this.videoPath);
    }
    this.fNT.getIntent().putExtra("KSightDeleted", this.Aki);
    this.Akn = 90;
    if (r.J(this.Akp))
    {
      this.Akp.recycle();
      this.Akp = null;
    }
    AppMethodBeat.o(98004);
  }
  
  final void RC(int paramInt)
  {
    AppMethodBeat.i(98007);
    ez localez = new ez().Ts();
    localez.ele = paramInt;
    localez.oA(this.Akg).aLH();
    AppMethodBeat.o(98007);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98003);
    if (this.Aks.eiy())
    {
      this.mHs = com.tencent.mm.ui.base.h.b(this.fNT, this.fNT.getString(2131762543), true, null);
      this.Akv = paramInt1;
      this.zuq = paramInt2;
      this.Akw = parami;
      this.Akx = paramString1;
      this.Agd = paramList1;
      this.Aky = parambwk;
      this.gnJ = paramLinkedList;
      this.Akz = paramInt3;
      this.zIe = paramBoolean;
      this.AkA = paramList2;
      this.AkB = paramPInt;
      this.AkC = paramString2;
      this.AkD = paramInt4;
      this.AkE = paramInt5;
      ((SnsUploadUI)this.fNT).AGe = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (!com.tencent.mm.vfs.o.fB(this.videoPath))
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97991);
          t.makeText(ai.this.fNT, 2131763075, 0).show();
          AppMethodBeat.o(97991);
        }
      });
      ((SnsUploadUI)this.fNT).AGe = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.Akt != null)
    {
      ((SnsUploadUI)this.fNT).AGe = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.Akd)
    {
      AppMethodBeat.o(98003);
      return true;
    }
    this.Akd = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.i.d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          did localdid = new did();
          localdid.nIJ = paramString2;
          parami.add(localdid);
        }
      }
    }
    this.Akt = new bd(15);
    paramPInt.value = this.Akt.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zsC) {
      this.Akt.QI(3);
    }
    paramString1 = this.Akt.aAA(paramString1);
    new LinkedList();
    paramString1.a(parambwk).aV(parami).QL(paramInt1).QM(paramInt2).fU(paramList2);
    if (paramBoolean) {
      this.Akt.QO(1);
    }
    for (;;)
    {
      this.Akt.cc(this.zFi, this.Ahr);
      this.Akt.fU(paramList2);
      this.Akt.QN(this.Ahk);
      this.Akt.dKw = this.Akf;
      this.Akt.g(null, null, null, paramInt4, paramInt5);
      this.Akt.setSessionId(this.mSessionId);
      if (!bu.isNullOrNil(this.appId)) {
        this.Akt.aAG(this.appId);
      }
      if (!bu.isNullOrNil(this.appName)) {
        this.Akt.aAH(bu.bI(this.appName, ""));
      }
      if (this.AiJ) {
        this.Akt.QN(5);
      }
      if ((this.AiK) && (this.AiL != null))
      {
        this.Akt.aAB(this.AiL.mediaTagName);
        this.Akt.aD(this.appId, this.AiL.messageExt, this.AiL.messageAction);
      }
      ar.o(this.AkG, 700L);
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97992);
          ai localai = ai.this;
          long l = System.currentTimeMillis();
          bd localbd;
          String str4;
          Object localObject2;
          Object localObject1;
          String str1;
          String str2;
          String str3;
          Object localObject3;
          if ((!TextUtils.isEmpty(localai.gKg)) && (!TextUtils.isEmpty(localai.hCS)))
          {
            localbd = localai.Akt;
            str4 = localai.videoPath;
            localObject2 = localai.thumbPath;
            localObject1 = localai.desc;
            str1 = localai.md5;
            str2 = localai.gKg;
            str3 = localai.hCS;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.c.yho;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.c.axr(str4);
            if (localObject3 == null) {
              break label575;
            }
            ae.i("MicroMsg.UploadPackHelper", "addSightObjectByUrl commit video_info:".concat(String.valueOf(localObject3)));
          }
          label533:
          label559:
          label575:
          for (float f = ((c.a)localObject3).duration / 1000.0F;; f = 0.0F)
          {
            localObject3 = ah.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str4.getBytes());
            bd.aAK((String)localObject3);
            com.tencent.mm.vfs.o.mF(str4, (String)localObject3);
            str4 = ah.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
            com.tencent.mm.vfs.o.mF((String)localObject2, str4);
            localObject2 = bd.b("", (String)localObject3, str4, str1, str2, str3);
            int i;
            if (localObject2 == null)
            {
              ae.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
              i = 0;
              if (i != 0) {
                break label533;
              }
              ae.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.o.aZR(localai.videoPath) + " thumb: " + com.tencent.mm.vfs.o.aZR(localai.thumbPath) + ",cdnUrl " + localai.gKg + "cdnThubmUrl " + localai.hCS);
              ar.f(new ai.7(localai));
            }
            for (;;)
            {
              ae.i("MicroMsg.SightWidget", "removeRunnable showProgress");
              ar.ay(ai.this.AkG);
              if (ai.this.Akt != null) {
                break label559;
              }
              AppMethodBeat.o(97992);
              return;
              ((bzh)localObject2).Desc = ((String)localObject1);
              if (bu.isNullOrNil(((bzh)localObject2).Title)) {
                ((bzh)localObject2).Title = ((String)localObject1);
              }
              ((bzh)localObject2).HmF = f;
              localbd.zFb.HUG.Gtx.add(localObject2);
              localObject1 = new bwe();
              ((bwe)localObject1).Hjg = ((bzh)localObject2).dKr;
              localbd.zFc.HmI.add(localObject1);
              i = 1;
              break;
              if (!localai.Akt.z(localai.videoPath, localai.thumbPath, localai.desc, localai.md5))
              {
                ae.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.o.aZR(localai.videoPath) + " thumb: " + com.tencent.mm.vfs.o.aZR(localai.thumbPath));
                ar.f(new ai.8(localai));
              }
              else
              {
                ae.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            ar.f(ai.this.AkF);
            AppMethodBeat.o(97992);
            return;
          }
        }
      }, "sight_send_ready");
      AppMethodBeat.o(98003);
      return true;
      this.Akt.QO(0);
    }
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(98000);
    this.Ahq = com.tencent.mm.modelsns.e.w(this.fNT.getIntent());
    this.gKg = bu.bI(this.fNT.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.hCS = bu.bI(this.fNT.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.AiJ = this.fNT.getIntent().getBooleanExtra("KThrid_app", false);
    this.AiK = this.fNT.getIntent().getBooleanExtra("KSnsAction", false);
    this.Akh = this.fNT.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.Akq = this.fNT.getIntent().getBooleanExtra("KBlockAdd", false);
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = bu.bI(this.fNT.getIntent().getStringExtra("reportSessionId"), "");
    this.Akg = this.fNT.getIntent().getStringExtra("KSessionID");
    this.Akr = this.fNT.getIntent().getBooleanExtra("KSnsUploadFromSkipCompress", false);
    ae.i("MicroMsg.SightWidget", "mIsFromSkipCompress:%s, appId:%s", new Object[] { Boolean.valueOf(this.Akr), this.appId });
    paramBundle = this.Aks;
    Object localObject1 = this.fNT;
    ae.i("MicroMsg.SnsFakeVLogHelper", "resetFakeData");
    Bundle localBundle = ((MMActivity)localObject1).getIntent().getBundleExtra("key_extra_data");
    if ((localBundle == null) || (localBundle.getByteArray("key_bg_generate_pb") == null) || (localBundle.getByteArray("key_bg_generate_extra_config") == null)) {}
    for (;;)
    {
      paramBundle = this.fNT.getIntent().getBundleExtra("Ksnsupload_timeline");
      if (paramBundle != null) {
        this.AiL = new SendMessageToWX.Req(paramBundle).message;
      }
      this.thumbPath = this.fNT.getIntent().getStringExtra("KSightThumbPath");
      this.videoPath = this.fNT.getIntent().getStringExtra("KSightPath");
      this.Aki = this.fNT.getIntent().getBooleanExtra("KSightDeleted", false);
      this.md5 = this.fNT.getIntent().getStringExtra("sight_md5");
      paramBundle = this.fNT.getIntent().getByteArrayExtra("KMMSightExtInfo");
      if (paramBundle != null) {}
      try
      {
        this.Akf.parseFrom(paramBundle);
        if (this.Akf == null)
        {
          this.Akf = new byg();
          this.Akf.Hlb = this.Akh;
        }
        this.Akf.dwb = this.mSessionId;
        this.Akf.Hlf = this.Akr;
        this.Akf.Hlg = this.appId;
        paramBundle = new ty();
        paramBundle.dJt.type = 2;
        com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
        if (bu.isNullOrNil(this.videoPath))
        {
          this.videoPath = bu.bI(paramBundle.dJu.dJy, "");
          ae.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
        }
        if (bu.isNullOrNil(this.md5))
        {
          paramBundle = bu.bI(paramBundle.dJu.dJw, "");
          this.md5 = paramBundle;
          ae.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
          com.tencent.mm.sdk.b.a.IvT.c(this.seA);
          if (this.Akj != 0) {
            break label961;
          }
          ah.dXt();
          i = u.getScreenWidth();
          if (i != 0) {
            break label922;
          }
          AppMethodBeat.o(98000);
          return;
          localObject2 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightThumbPath");
          localObject3 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightPath");
          if ((com.tencent.mm.vfs.o.fB((String)localObject2)) && (com.tencent.mm.vfs.o.fB((String)localObject3)))
          {
            ae.i("MicroMsg.SnsFakeVLogHelper", "jump generate");
            continue;
          }
          ae.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper go bg generate");
          paramBundle.yrU = false;
          localObject2 = com.tencent.mm.plugin.recordvideo.background.a.xJX;
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
            paramBundle.ATh = ((agh)new agh().parseFrom((byte[])localObject2));
            paramBundle.ATi = ((VideoMixer.MixConfig)localBundle.getParcelable("key_bg_generate_mix_config"));
            paramBundle.ATj = ((aip)new aip().parseFrom((byte[])localObject3));
            label850:
            ((MMActivity)localObject1).getIntent().putExtra("KSightThumbPath", paramBundle.ATh.thumbPath);
            paramBundle = paramBundle.ATi;
            localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
            com.tencent.mm.plugin.recordvideo.background.e.a((byte[])localObject2, paramBundle, (byte[])localObject3, 7);
            break;
            paramBundle = paramBundle;
            ae.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
            continue;
            paramBundle = this.md5;
          }
          label922:
          this.Akj = ((i - this.fNT.getResources().getDimensionPixelSize(2131166845) * 4 - this.fNT.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
          label961:
          if (this.fNT.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
          for (this.zFi = 1;; this.zFi = 0)
          {
            this.Ahr = bu.bI(this.fNT.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
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
  
  public final void ar(Bundle paramBundle) {}
  
  public final void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(98002);
    this.videoPath = paramCaptureVideoNormalModel.videoPath;
    this.thumbPath = paramCaptureVideoNormalModel.thumbPath;
    this.fNT.getIntent().putExtra("KSightThumbPath", this.thumbPath);
    this.fNT.getIntent().putExtra("KSightPath", this.videoPath);
    this.md5 = com.tencent.mm.vfs.o.aRh(paramCaptureVideoNormalModel.videoPath);
    if ((this.mHs != null) && (this.mHs.isShowing()))
    {
      this.mHs.dismiss();
      a(this.Akv, this.zuq, this.Akw, this.Akx, this.Agd, this.Aky, this.gnJ, this.Akz, this.zIe, this.AkA, this.AkB, this.AkC, this.AkD, this.AkE);
    }
    AppMethodBeat.o(98002);
  }
  
  final void edH()
  {
    AppMethodBeat.i(98008);
    if ((this.Akp != null) && (!this.Akp.isRecycled()))
    {
      this.Akb.setImageBitmap(this.Akp);
      this.Akb.hy(((Integer)this.Ako.first).intValue(), ((Integer)this.Ako.second).intValue());
    }
    AppMethodBeat.o(98008);
  }
  
  final void edI()
  {
    AppMethodBeat.i(98009);
    this.Akc.setVisibility(8);
    this.Akb.ziA.clear();
    this.Akb.hy(com.tencent.mm.cb.a.fromDPToPix(this.fNT, 100), com.tencent.mm.cb.a.fromDPToPix(this.fNT, 100));
    this.Akb.setBackgroundResource(2131100938);
    this.Akb.setImageResource(2131689536);
    this.Akb.setContentDescription(this.Akb.getContext().getString(2131763774));
    int i = com.tencent.mm.cb.a.fromDPToPix(this.fNT, 100) * 35 / 100;
    this.Akb.setPadding(i, i, i, i);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFX, true))
    {
      com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      com.tencent.mm.plugin.recordvideo.e.b.axi(this.videoPath);
      localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      com.tencent.mm.plugin.recordvideo.e.b.axi(this.thumbPath);
    }
    AppMethodBeat.o(98009);
  }
  
  public final boolean edJ()
  {
    if (this.Akf != null) {
      return this.Akf.Hlb;
    }
    return false;
  }
  
  public final boolean edl()
  {
    return !this.Aki;
  }
  
  public final View edm()
  {
    AppMethodBeat.i(98001);
    this.rY = View.inflate(this.fNT, 2131495818, null);
    this.Akb = ((SightPlayImageView)this.rY.findViewById(2131305798));
    this.Akc = ((ImageView)this.rY.findViewById(2131305196));
    Object localObject = new DisplayMetrics();
    this.fNT.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.Akm = com.tencent.mm.cb.a.fromDPToPix(this.fNT, 100);
    this.Akl = com.tencent.mm.cb.a.fromDPToPix(this.fNT, 100);
    if ((!TextUtils.isEmpty(this.thumbPath)) && (com.tencent.mm.vfs.o.fB(this.thumbPath)))
    {
      ae.i("MicroMsg.SightWidget", "getBitmapNative thumbPath:%s", new Object[] { this.thumbPath });
      this.Akp = com.tencent.mm.sdk.platformtools.h.aRC(this.thumbPath);
    }
    if (this.Akp == null)
    {
      ae.i("MicroMsg.SightWidget", "getVideoThumb videoPath:%s", new Object[] { this.videoPath });
      this.Akp = com.tencent.mm.plugin.mmsight.d.GS(this.videoPath);
    }
    if (this.Akp != null)
    {
      this.Akm = this.Akp.getHeight();
      this.Akl = this.Akp.getWidth();
      ae.i("MicroMsg.SightWidget", "mSightHeight:%s", new Object[] { Integer.valueOf(this.Akm) });
      ae.i("MicroMsg.SightWidget", "mSightWidth:%s", new Object[] { Integer.valueOf(this.Akl) });
    }
    this.Ako = com.tencent.mm.modelsns.h.a(this.Akl, this.Akm, this.fNT, false);
    ae.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.Akl), Integer.valueOf(this.Akm), this.Ako.first, this.Ako.second, Integer.valueOf(this.Akn) });
    edH();
    this.Akb.setScaleType(QImageView.a.Lpz);
    this.Akb.ziI = true;
    this.Akb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97990);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (ai.this.Aki)
        {
          com.tencent.mm.kernel.g.ajS();
          if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
          {
            t.g(ai.this.fNT, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97990);
            return;
          }
        }
        try
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.a.e(ai.this.fNT, 1, false);
          paramAnonymousView.LfS = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(97988);
              if (!com.tencent.mm.platformtools.ac.iSG) {
                paramAnonymous2l.d(0, ai.this.fNT.getString(2131755747));
              }
              paramAnonymous2l.d(1, ai.this.fNT.getString(2131755754));
              AppMethodBeat.o(97988);
            }
          };
          paramAnonymousView.LfT = new n.e()
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
                paramAnonymous2MenuItem.RC(1);
                long l = ch.aDb();
                com.tencent.mm.plugin.report.service.g.yxI.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), r.dWp(), Long.valueOf(l) });
                Object localObject1 = new SightParams(2, 0);
                com.tencent.mm.modelvideo.o.aNg();
                Object localObject2 = com.tencent.mm.plugin.mmsight.d.arO(com.tencent.mm.modelvideo.o.getAccVideoPath());
                localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.mmsight.d.arQ((String)localObject2), ((SightParams)localObject1).hxV, ((SightParams)localObject1).hxV.duration * 1000, 2);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFC, false)) {
                  ((RecordConfigProvider)localObject1).remuxType = 2;
                }
                localObject2 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject2).roH = 7;
                ((RecordConfigProvider)localObject1).xOx = ((VideoCaptureReportInfo)localObject2);
                localObject2 = new ai.9(paramAnonymous2MenuItem);
                CaptureDataManager.xNV.xNU = ((CaptureDataManager.b)localObject2);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFA, true))
                {
                  localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
                  com.tencent.mm.plugin.recordvideo.jumper.a.a(paramAnonymous2MenuItem.fNT, 11, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
                  AppMethodBeat.o(97989);
                  return;
                }
                localObject1 = new Intent();
                q.a(paramAnonymous2MenuItem.fNT, 11, (Intent)localObject1, 2, 0);
                AppMethodBeat.o(97989);
                return;
                paramAnonymous2MenuItem = ai.this.fNT.getSharedPreferences(ak.fow(), 0).getString("gallery", "1");
                l = ch.aDb();
                com.tencent.mm.plugin.report.service.g.yxI.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), r.dWp(), Long.valueOf(l) });
                if (!paramAnonymous2MenuItem.equalsIgnoreCase("0")) {
                  break;
                }
                q.aS(ai.this.fNT);
                ai.this.RC(2);
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.aHh().aHk().duration);
              boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGn, false);
              if ((com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IXH, 0) == 1) || (bool2))
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
                q.a(ai.this.fNT, 9, 9, 4, 3, paramAnonymous2MenuItem);
                break;
                paramAnonymous2Int = 0;
                break label474;
                label515:
                bool1 = false;
              }
            }
          };
          paramAnonymousView.cPF();
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
            if (ai.this.Aks.L(localObject[0], localObject[1], j, i))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(97990);
              return;
            }
            if (!com.tencent.mm.vfs.o.fB(ai.this.videoPath))
            {
              ae.i("MicroMsg.SightWidget", "click videopath is not exist " + ai.this.videoPath);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(97990);
              return;
            }
            paramAnonymousView = new Intent(ai.this.fNT, SnsOnlineVideoActivity.class);
            paramAnonymousView.putExtra("intent_videopath", ai.this.videoPath);
            paramAnonymousView.putExtra("intent_thumbpath", ai.this.thumbPath);
            paramAnonymousView.putExtra("intent_isad", false);
            paramAnonymousView.putExtra("intent_ispreview", true);
            paramAnonymousView.putExtra("KBlockAdd", ai.this.Akq);
            paramAnonymousView.putExtra("sns_video_scene", 6);
            paramAnonymousView.putExtra("img_gallery_left", localObject[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject[1]);
            paramAnonymousView.putExtra("img_gallery_width", j);
            paramAnonymousView.putExtra("img_gallery_height", i);
            ai.this.fNT.startActivityForResult(paramAnonymousView, 12);
            ai.this.fNT.overridePendingTransition(0, 0);
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
    ae.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.o.aZR(this.videoPath) + " " + com.tencent.mm.vfs.o.aZR(this.thumbPath));
    if (com.tencent.mm.vfs.o.fB(this.videoPath)) {
      ae.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
    }
    localObject = this.rY;
    AppMethodBeat.o(98001);
    return localObject;
  }
  
  public final boolean edn()
  {
    return true;
  }
  
  public final boolean edo()
  {
    AppMethodBeat.i(98006);
    if (this.fOC != null) {
      this.fOC.dismiss();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.seA);
    if (r.J(this.Ake)) {
      this.Ake.recycle();
    }
    com.tencent.mm.plugin.sns.ui.f.a locala = this.Aks;
    ae.i("MicroMsg.SnsFakeVLogHelper", "release");
    com.tencent.mm.plugin.recordvideo.background.a locala1 = com.tencent.mm.plugin.recordvideo.background.a.xJX;
    com.tencent.mm.plugin.recordvideo.background.a.b(7, locala);
    rP(false);
    AppMethodBeat.o(98006);
    return false;
  }
  
  /* Error */
  public final boolean k(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1124
    //   3: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+29 -> 36, 9:+380->387, 10:+29->36, 11:+142->149, 12:+37->44
    //   37: iconst_1
    //   38: isub
    //   39: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_2
    //   45: ifnull -9 -> 36
    //   48: aload_0
    //   49: aload_2
    //   50: ldc_w 1126
    //   53: iconst_0
    //   54: invokevirtual 310	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   57: putfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   60: aload_0
    //   61: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   64: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc_w 391
    //   70: aload_0
    //   71: getfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   74: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   77: pop
    //   78: aload_0
    //   79: getfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   82: ifeq +59 -> 141
    //   85: aload_0
    //   86: getfield 215	com/tencent/mm/plugin/sns/ui/ai:Aks	Lcom/tencent/mm/plugin/sns/ui/f/a;
    //   89: astore_2
    //   90: ldc_w 703
    //   93: ldc_w 1128
    //   96: invokestatic 235	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic 797	com/tencent/mm/plugin/recordvideo/background/a:xJX	Lcom/tencent/mm/plugin/recordvideo/background/a;
    //   102: astore 4
    //   104: bipush 7
    //   106: aload_2
    //   107: invokestatic 1119	com/tencent/mm/plugin/recordvideo/background/a:b	(ILcom/tencent/mm/plugin/recordvideo/background/b;)V
    //   110: aload_2
    //   111: getfield 1131	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   114: invokestatic 1027	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +15 -> 132
    //   120: getstatic 835	com/tencent/mm/plugin/recordvideo/background/e:xKl	Lcom/tencent/mm/plugin/recordvideo/background/e;
    //   123: astore 4
    //   125: aload_2
    //   126: getfield 1131	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   129: invokestatic 1134	com/tencent/mm/plugin/recordvideo/background/e:awP	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual 1136	com/tencent/mm/plugin/sns/ui/ai:edI	()V
    //   136: aload_0
    //   137: iconst_1
    //   138: invokespecial 1121	com/tencent/mm/plugin/sns/ui/ai:rP	(Z)V
    //   141: ldc_w 1124
    //   144: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_2
    //   150: ldc_w 1138
    //   153: invokevirtual 1141	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   156: checkcast 1143	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull -127 -> 36
    //   166: aload 4
    //   168: getfield 1146	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYw	Z
    //   171: ifne +131 -> 302
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   179: aload_0
    //   180: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   183: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   186: ldc_w 391
    //   189: aload_0
    //   190: getfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   193: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   196: pop
    //   197: aload_0
    //   198: aload 4
    //   200: getfield 1149	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYy	Ljava/lang/String;
    //   203: putfield 137	com/tencent/mm/plugin/sns/ui/ai:videoPath	Ljava/lang/String;
    //   206: aload_0
    //   207: aload 4
    //   209: getfield 1152	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYz	Ljava/lang/String;
    //   212: putfield 135	com/tencent/mm/plugin/sns/ui/ai:thumbPath	Ljava/lang/String;
    //   215: aload 4
    //   217: getfield 1155	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYB	Ljava/lang/String;
    //   220: invokestatic 598	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   223: ifne +64 -> 287
    //   226: aload_0
    //   227: aload 4
    //   229: getfield 1155	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYB	Ljava/lang/String;
    //   232: putfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   235: aload_0
    //   236: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   239: instanceof 471
    //   242: ifeq +37 -> 279
    //   245: aload_0
    //   246: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   249: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   252: aload_0
    //   253: getfield 137	com/tencent/mm/plugin/sns/ui/ai:videoPath	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 135	com/tencent/mm/plugin/sns/ui/ai:thumbPath	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   264: aconst_null
    //   265: iconst_1
    //   266: invokevirtual 1158	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   269: aload_0
    //   270: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   273: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   276: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/SnsUploadUI:ehm	()V
    //   279: ldc_w 1124
    //   282: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_1
    //   286: ireturn
    //   287: aload_0
    //   288: aload 4
    //   290: getfield 1149	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYy	Ljava/lang/String;
    //   293: invokestatic 871	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   299: goto -64 -> 235
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   307: aload_0
    //   308: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   311: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   314: ldc_w 391
    //   317: aload_0
    //   318: getfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   321: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   324: pop
    //   325: aload_2
    //   326: ldc_w 1163
    //   329: iconst_0
    //   330: invokevirtual 684	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   333: istore_1
    //   334: aload 4
    //   336: getfield 1166	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYE	Ljava/lang/String;
    //   339: astore_2
    //   340: aload_0
    //   341: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   344: instanceof 471
    //   347: ifeq +32 -> 379
    //   350: aload_0
    //   351: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   354: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   357: aload_2
    //   358: iconst_1
    //   359: iload_1
    //   360: aconst_null
    //   361: aconst_null
    //   362: aload_0
    //   363: getfield 575	com/tencent/mm/plugin/sns/ui/ai:Ahk	I
    //   366: invokevirtual 1169	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   369: aload_0
    //   370: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   373: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   376: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/SnsUploadUI:ehm	()V
    //   379: ldc_w 1124
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
    //   425: ldc_w 1171
    //   428: invokestatic 235	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   435: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   438: invokevirtual 1175	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   441: invokevirtual 1176	android/os/Bundle:clear	()V
    //   444: aload_0
    //   445: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   448: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   451: ldc_w 676
    //   454: iconst_0
    //   455: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   463: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   466: ldc_w 1178
    //   469: iconst_1
    //   470: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   478: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   481: ldc_w 1180
    //   484: bipush 14
    //   486: invokevirtual 1183	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   489: pop
    //   490: aload_0
    //   491: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   494: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   497: ldc_w 707
    //   500: aload_2
    //   501: ldc_w 707
    //   504: invokevirtual 711	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   507: invokevirtual 1186	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   510: pop
    //   511: aload_0
    //   512: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   515: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   518: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/SnsUploadUI:ehm	()V
    //   521: ldc_w 1124
    //   524: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: iconst_1
    //   528: ireturn
    //   529: aload_2
    //   530: ldc_w 1188
    //   533: invokevirtual 1192	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   536: astore 4
    //   538: aload 4
    //   540: ifnull +11 -> 551
    //   543: aload 4
    //   545: invokevirtual 1197	java/util/ArrayList:size	()I
    //   548: ifgt +16 -> 564
    //   551: aload_2
    //   552: ldc_w 1199
    //   555: invokevirtual 660	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   558: invokestatic 598	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   561: ifne +403 -> 964
    //   564: aload_0
    //   565: iconst_0
    //   566: putfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   569: aload_0
    //   570: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   573: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   576: ldc_w 391
    //   579: aload_0
    //   580: getfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   583: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   586: pop
    //   587: aload 4
    //   589: ifnull +124 -> 713
    //   592: aload 4
    //   594: invokevirtual 1197	java/util/ArrayList:size	()I
    //   597: ifle +116 -> 713
    //   600: aload 4
    //   602: iconst_0
    //   603: invokevirtual 1202	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   606: checkcast 513	java/lang/String
    //   609: astore 4
    //   611: aload_2
    //   612: ldc_w 1204
    //   615: invokevirtual 660	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   618: astore 5
    //   620: aload 5
    //   622: invokestatic 598	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   625: ifne +14 -> 639
    //   628: aload 5
    //   630: astore_2
    //   631: aload 5
    //   633: invokestatic 480	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   636: ifne +181 -> 817
    //   639: new 1086	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 1205	java/lang/StringBuilder:<init>	()V
    //   646: invokestatic 1208	com/tencent/mm/plugin/sns/model/ah:getAccSnsTmpPath	()Ljava/lang/String;
    //   649: invokevirtual 1094	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 4
    //   654: invokestatic 871	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokevirtual 1094	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 1108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: astore_2
    //   664: new 166	com/tencent/mm/compatible/h/d
    //   667: dup
    //   668: invokespecial 167	com/tencent/mm/compatible/h/d:<init>	()V
    //   671: astore 5
    //   673: aload 5
    //   675: aload 4
    //   677: invokevirtual 1213	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   680: aload 5
    //   682: lconst_0
    //   683: invokevirtual 1217	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   686: astore 6
    //   688: aload 6
    //   690: ifnonnull +35 -> 725
    //   693: ldc 228
    //   695: ldc_w 1219
    //   698: invokestatic 1221	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload 5
    //   703: invokevirtual 1223	android/media/MediaMetadataRetriever:release	()V
    //   706: goto -670 -> 36
    //   709: astore_2
    //   710: goto -674 -> 36
    //   713: aload_2
    //   714: ldc_w 1199
    //   717: invokevirtual 660	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   720: astore 4
    //   722: goto -111 -> 611
    //   725: ldc 228
    //   727: ldc_w 1225
    //   730: iconst_2
    //   731: anewarray 4	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload 6
    //   738: invokevirtual 1048	android/graphics/Bitmap:getWidth	()I
    //   741: invokestatic 1053	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: aload 6
    //   749: invokevirtual 1045	android/graphics/Bitmap:getHeight	()I
    //   752: invokestatic 1053	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: invokestatic 701	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: aload 6
    //   761: bipush 80
    //   763: getstatic 1231	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   766: aload_2
    //   767: iconst_1
    //   768: invokestatic 1234	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   771: pop
    //   772: aload_2
    //   773: invokestatic 1238	com/tencent/mm/sdk/platformtools/h:aRz	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   776: astore 6
    //   778: ldc 228
    //   780: ldc_w 1240
    //   783: iconst_2
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload 6
    //   791: getfield 1245	android/graphics/BitmapFactory$Options:outWidth	I
    //   794: invokestatic 1053	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: aastore
    //   798: dup
    //   799: iconst_1
    //   800: aload 6
    //   802: getfield 1248	android/graphics/BitmapFactory$Options:outHeight	I
    //   805: invokestatic 1053	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: aastore
    //   809: invokestatic 701	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: aload 5
    //   814: invokevirtual 1223	android/media/MediaMetadataRetriever:release	()V
    //   817: aload_0
    //   818: aload 4
    //   820: invokestatic 871	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
    //   823: putfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   826: ldc 228
    //   828: ldc_w 1250
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
    //   848: invokestatic 1102	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   851: invokestatic 1255	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   854: aastore
    //   855: dup
    //   856: iconst_3
    //   857: aload_2
    //   858: invokestatic 1102	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   861: invokestatic 1255	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   864: aastore
    //   865: invokestatic 701	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   868: aload_0
    //   869: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   872: instanceof 471
    //   875: ifeq +32 -> 907
    //   878: aload_0
    //   879: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   882: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   885: aload 4
    //   887: aload_2
    //   888: aload_0
    //   889: getfield 139	com/tencent/mm/plugin/sns/ui/ai:md5	Ljava/lang/String;
    //   892: aconst_null
    //   893: iconst_0
    //   894: invokevirtual 1158	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   897: aload_0
    //   898: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   901: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   904: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/SnsUploadUI:ehm	()V
    //   907: ldc_w 1124
    //   910: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   913: iconst_1
    //   914: ireturn
    //   915: astore 6
    //   917: ldc 228
    //   919: ldc_w 1257
    //   922: iconst_1
    //   923: anewarray 4	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: aload 6
    //   930: invokevirtual 844	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   933: aastore
    //   934: invokestatic 767	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: aload 5
    //   939: invokevirtual 1223	android/media/MediaMetadataRetriever:release	()V
    //   942: goto -125 -> 817
    //   945: astore 5
    //   947: goto -130 -> 817
    //   950: astore_2
    //   951: aload 5
    //   953: invokevirtual 1223	android/media/MediaMetadataRetriever:release	()V
    //   956: ldc_w 1124
    //   959: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   962: aload_2
    //   963: athrow
    //   964: aload_0
    //   965: iconst_1
    //   966: putfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   969: aload_0
    //   970: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   973: invokevirtual 302	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   976: ldc_w 391
    //   979: aload_0
    //   980: getfield 162	com/tencent/mm/plugin/sns/ui/ai:Aki	Z
    //   983: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   986: pop
    //   987: aload_2
    //   988: ldc_w 1259
    //   991: invokevirtual 1192	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   994: astore 4
    //   996: aload 4
    //   998: ifnull +11 -> 1009
    //   1001: aload 4
    //   1003: invokevirtual 1197	java/util/ArrayList:size	()I
    //   1006: ifne +19 -> 1025
    //   1009: ldc 228
    //   1011: ldc_w 1261
    //   1014: invokestatic 235	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1017: ldc_w 1124
    //   1020: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1023: iconst_0
    //   1024: ireturn
    //   1025: new 1194	java/util/ArrayList
    //   1028: dup
    //   1029: invokespecial 1262	java/util/ArrayList:<init>	()V
    //   1032: astore 5
    //   1034: aload 4
    //   1036: invokevirtual 1263	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1039: astore 6
    //   1041: aload 6
    //   1043: invokeinterface 507 1 0
    //   1048: ifeq +76 -> 1124
    //   1051: aload 6
    //   1053: invokeinterface 511 1 0
    //   1058: checkcast 513	java/lang/String
    //   1061: astore 7
    //   1063: aload 7
    //   1065: invokestatic 1269	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1068: invokevirtual 1273	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1071: astore 8
    //   1073: aload 8
    //   1075: ifnull -34 -> 1041
    //   1078: aload 5
    //   1080: ldc_w 1275
    //   1083: iconst_3
    //   1084: anewarray 4	java/lang/Object
    //   1087: dup
    //   1088: iconst_0
    //   1089: aload 7
    //   1091: aastore
    //   1092: dup
    //   1093: iconst_1
    //   1094: aload 8
    //   1096: getfield 1281	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1099: invokestatic 1286	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1102: aastore
    //   1103: dup
    //   1104: iconst_2
    //   1105: aload 8
    //   1107: getfield 1289	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1110: invokestatic 1286	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1113: aastore
    //   1114: invokestatic 1293	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1117: invokevirtual 1294	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1120: pop
    //   1121: goto -80 -> 1041
    //   1124: aload_2
    //   1125: ldc_w 1296
    //   1128: iconst_0
    //   1129: invokevirtual 310	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1132: istore_3
    //   1133: aload_2
    //   1134: ldc_w 1163
    //   1137: iconst_0
    //   1138: invokevirtual 684	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1141: istore_1
    //   1142: aload_0
    //   1143: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   1146: instanceof 471
    //   1149: ifeq -1113 -> 36
    //   1152: aload_0
    //   1153: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   1156: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1159: aconst_null
    //   1160: iload_3
    //   1161: iload_1
    //   1162: aload 4
    //   1164: aload 5
    //   1166: aload_0
    //   1167: getfield 575	com/tencent/mm/plugin/sns/ui/ai:Ahk	I
    //   1170: invokevirtual 1169	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   1173: aload_0
    //   1174: getfield 208	com/tencent/mm/plugin/sns/ui/ai:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   1177: checkcast 471	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1180: invokevirtual 1161	com/tencent/mm/plugin/sns/ui/SnsUploadUI:ehm	()V
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