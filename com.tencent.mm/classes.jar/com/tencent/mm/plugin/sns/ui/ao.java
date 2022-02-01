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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xr;
import com.tencent.mm.autogen.a.xr.b;
import com.tencent.mm.autogen.mmdata.rpt.nj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.util.g.a;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.h.a.b;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.ui.f.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.s;

public final class ao
  implements ag, a.a
{
  private boolean QCV;
  private int Qog;
  private int QzF;
  private List<String> Rbq;
  private l RcD;
  private String RcE;
  private int Rcy;
  private boolean Rei;
  private boolean Rej;
  private WXMediaMessage Rek;
  SightPlayImageView RfL;
  private ImageView RfM;
  boolean RfN;
  private Bitmap RfO;
  private dmb RfP;
  private String RfQ;
  private boolean RfR;
  boolean RfS;
  private int RfT;
  private MediaMetadataRetriever RfU;
  private int RfV;
  private int RfW;
  private int RfX;
  private Pair<Integer, Integer> RfY;
  private Bitmap RfZ;
  boolean Rga;
  private boolean Rgb;
  com.tencent.mm.plugin.sns.ui.f.a Rgc;
  private com.tencent.mm.ad.i Rgd;
  private boolean Rge;
  bg Rgf;
  private int Rgg;
  private int Rgh;
  private org.b.d.i Rgi;
  private String Rgj;
  private djv Rgk;
  private int Rgl;
  private List<String> Rgm;
  private PInt Rgn;
  private int Rgo;
  private int Rgp;
  Runnable Rgq;
  Runnable Rgr;
  private String appId;
  private String appName;
  private String canvasInfo;
  String desc;
  private View doN;
  private boolean hEn;
  ProgressDialog lzP;
  MMActivity lzt;
  String mOI;
  private String mSessionId;
  String md5;
  private LinkedList<Long> miW;
  String nRr;
  private IListener qmO;
  private w rYw;
  String thumbPath;
  String videoPath;
  
  public ao(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97999);
    this.doN = null;
    this.RfM = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.hEn = false;
    this.RfN = false;
    this.RfO = null;
    this.RcD = null;
    this.RfP = new dmb();
    this.Rei = false;
    this.Rej = false;
    this.Rek = null;
    this.RfR = false;
    this.RfS = false;
    this.RfT = 0;
    this.RfU = new com.tencent.mm.compatible.i.d();
    this.RfV = 0;
    this.RfW = 0;
    this.RfX = 90;
    this.RfY = null;
    this.RfZ = null;
    this.Rga = false;
    this.Rgb = false;
    this.QzF = 1;
    this.RcE = "";
    this.Rge = true;
    this.qmO = new NewSightWidget.1(this, com.tencent.mm.app.f.hfK);
    this.Rgf = null;
    this.Rgg = 0;
    this.desc = "";
    this.lzP = null;
    this.Rgq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97993);
        ao.a(ao.this);
        AppMethodBeat.o(97993);
      }
    };
    this.Rgr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97995);
        Log.i("MicroMsg.SightWidget", "showProgress");
        ao localao = ao.this;
        MMActivity localMMActivity = ao.this.lzt;
        ao.this.lzt.getString(b.j.app_tip);
        localao.lzP = k.a(localMMActivity, ao.this.lzt.getString(b.j.sns_sight_send_wait), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(97994);
            ao.this.Rgf = null;
            ao.this.RfN = false;
            MMHandlerThread.removeRunnable(ao.this.Rgq);
            AppMethodBeat.o(97994);
          }
        });
        AppMethodBeat.o(97995);
      }
    };
    this.lzt = paramMMActivity;
    this.Rgc = new com.tencent.mm.plugin.sns.ui.f.a(paramMMActivity, this);
    AppMethodBeat.o(97999);
  }
  
  private void M(String paramString, Object paramObject)
  {
    AppMethodBeat.i(308437);
    if (this.Rgd != null) {
      try
      {
        this.Rgd.n(paramString, paramObject);
        AppMethodBeat.o(308437);
        return;
      }
      catch (com.tencent.mm.ad.g paramString)
      {
        Log.e("MicroMsg.SightWidget", "put SecondCut JSON Error");
      }
    }
    AppMethodBeat.o(308437);
  }
  
  private void a(SightCaptureResult paramSightCaptureResult)
  {
    AppMethodBeat.i(308439);
    this.RfS = false;
    this.lzt.getIntent().putExtra("KSightDeleted", this.RfS);
    if ((this.lzt instanceof SnsUploadUI)) {
      ((SnsUploadUI)this.lzt).b(paramSightCaptureResult);
    }
    AppMethodBeat.o(308439);
  }
  
  private void alI(int paramInt)
  {
    AppMethodBeat.i(98007);
    nj localnj = new nj().aIU();
    localnj.jeX = paramInt;
    localnj.vH(this.RfQ).bMH();
    AppMethodBeat.o(98007);
  }
  
  private void lq(boolean paramBoolean)
  {
    AppMethodBeat.i(98004);
    this.videoPath = "";
    this.thumbPath = "";
    this.RfS = paramBoolean;
    if (paramBoolean)
    {
      this.lzt.getIntent().putExtra("KSightThumbPath", this.thumbPath);
      this.lzt.getIntent().putExtra("KSightPath", this.videoPath);
    }
    this.lzt.getIntent().putExtra("KSightDeleted", this.RfS);
    this.RfX = 90;
    if (com.tencent.mm.plugin.sns.data.t.S(this.RfZ))
    {
      this.RfZ.recycle();
      this.RfZ = null;
    }
    AppMethodBeat.o(98004);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98003);
    if (!this.Rgc.OnI) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.rYw = k.a(this.lzt, this.lzt.getString(b.j.remux_loading_tips), true, null);
      this.Rgh = paramInt1;
      this.Qog = paramInt2;
      this.Rgi = parami;
      this.Rgj = paramString1;
      this.Rbq = paramList1;
      this.Rgk = paramdjv;
      this.miW = paramLinkedList;
      this.Rgl = paramInt3;
      this.QCV = paramBoolean;
      this.Rgm = paramList2;
      this.Rgn = paramPInt;
      this.canvasInfo = paramString2;
      this.Rgo = paramInt4;
      this.Rgp = paramInt5;
      ((SnsUploadUI)this.lzt).RDQ = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (!y.ZC(this.videoPath))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97991);
          com.tencent.mm.ui.base.aa.makeText(ao.this.lzt, b.j.sendrequest_send_fail, 0).show();
          AppMethodBeat.o(97991);
        }
      });
      ((SnsUploadUI)this.lzt).RDQ = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.Rgf != null)
    {
      ((SnsUploadUI)this.lzt).RDQ = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.RfN)
    {
      AppMethodBeat.o(98003);
      return true;
    }
    this.RfN = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if ((paramLinkedList != null) && (!paramLinkedList.contains(paramString2)))
        {
          ffw localffw = new ffw();
          localffw.UserName = paramString2;
          parami.add(localffw);
        }
      }
    }
    this.Rgf = new bg(15, this.lzt);
    paramPInt.value = this.Rgf.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      this.Rgf.akL(3);
    }
    paramString1 = this.Rgf.aYM(paramString1);
    new LinkedList();
    paramString1.a(paramdjv).bU(parami).akO(paramInt1).akP(paramInt2).kB(paramList2);
    if (paramBoolean)
    {
      this.Rgf.akR(1);
      this.Rgf.df(this.QzF, this.RcE);
      this.Rgf.kB(paramList2);
      this.Rgf.akQ(this.Rcy);
      if (this.lzt.getIntent().hasExtra("KSnsVideoTempalteInfo"))
      {
        paramString1 = new ffv();
        parami = this.lzt.getIntent().getByteArrayExtra("KSnsVideoTempalteInfo");
        if ((parami == null) || (parami.length <= 0)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString1.parseFrom(parami);
        if (TextUtils.isEmpty(paramString1.nSg)) {
          continue;
        }
        this.Rgf.QzA.videoTemplate = paramString1;
        this.RfP.aaSm = true;
        com.tencent.mm.plugin.comm.b.e.xfd.f("SnsPublishProcess", "egID", paramString1.nSg);
        paramList1 = com.tencent.mm.plugin.comm.b.e.xfd;
        if (paramString1.musicId == null) {
          continue;
        }
        parami = paramString1.musicId;
        paramList1.f("SnsPublishProcess", "musicID", parami);
        Log.i("MicroMsg.SightWidget", "set video template info: " + paramString1.nSg);
      }
      catch (IOException parami)
      {
        Log.printErrStackTrace("MicroMsg.SightWidget", parami, "parse error", new Object[0]);
        continue;
        paramInt1 = 0;
        continue;
        paramInt2 = 0;
        continue;
        if (paramInt2 == 0) {
          continue;
        }
        paramInt1 = 2;
        continue;
        paramInt1 = 3;
        continue;
      }
      this.Rgf.icl = this.RfP;
      this.Rgf.i(null, null, null, paramInt4, paramInt5);
      this.Rgf.setSessionId(this.mSessionId);
      if (this.lzt.getIntent().getBooleanExtra("is_tiger2022", false)) {
        this.Rgf.kLL();
      }
      if ((!Util.isNullOrNil(this.appId)) && (this.Rge)) {
        this.Rgf.aYS(this.appId);
      }
      if ((!Util.isNullOrNil(this.appName)) && (this.Rge)) {
        this.Rgf.aYT(Util.nullAs(this.appName, ""));
      }
      if (this.Rei) {
        this.Rgf.akQ(5);
      }
      if ((this.Rej) && (this.Rek != null))
      {
        this.Rgf.aYN(this.Rek.mediaTagName);
        this.Rgf.aY(this.appId, this.Rek.messageExt, this.Rek.messageAction);
      }
      if (this.lzt.getIntent().getIntExtra("KSnsFrom", 0) != 17) {
        continue;
      }
      paramInt1 = 1;
      if (this.lzt.getIntent().getIntExtra("KSnsFrom", 0) != 14) {
        continue;
      }
      paramInt2 = 1;
      parami = com.tencent.mm.plugin.sns.statistics.h.QFO;
      if (paramInt1 == 0) {
        continue;
      }
      paramInt1 = 1;
      parami = this.videoPath;
      s.u(parami, "videoPath");
      com.tencent.mm.plugin.comm.b.e.xfd.f("SnsPublishProcess", "mediaSource_", String.valueOf(paramInt1));
      paramString1 = com.tencent.mm.plugin.comm.b.e.xfd;
      e.a.a("SnsPublishProcess", "mediaMD5_", (kotlin.g.a.a)new h.a.b(parami));
      com.tencent.mm.plugin.comm.b.e.xfd.f("SnsPublishProcess", "firstEditPageMedia", Integer.valueOf(1));
      com.tencent.mm.plugin.comm.b.e.xfd.f("SnsPublishProcess", "endSessionMedia", Integer.valueOf(1));
      MMHandlerThread.postToMainThreadDelayed(this.Rgr, 700L);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97992);
          ao localao = ao.this;
          long l = System.currentTimeMillis();
          bg localbg;
          String str4;
          Object localObject2;
          Object localObject1;
          String str1;
          String str2;
          String str3;
          Object localObject3;
          if ((!TextUtils.isEmpty(localao.mOI)) && (!TextUtils.isEmpty(localao.nRr)))
          {
            localbg = localao.Rgf;
            str4 = localao.videoPath;
            localObject2 = localao.thumbPath;
            localObject1 = localao.desc;
            str1 = localao.md5;
            str2 = localao.mOI;
            str3 = localao.nRr;
            localObject3 = com.tencent.mm.plugin.recordvideo.util.g.Obu;
            localObject3 = com.tencent.mm.plugin.recordvideo.util.g.aTF(str4);
            if (localObject3 == null) {
              break label577;
            }
            Log.i("MicroMsg.UploadPackHelper", "addSightObjectByUrl commit video_info:".concat(String.valueOf(localObject3)));
          }
          label535:
          label561:
          label577:
          for (float f = ((g.a)localObject3).duration / 1000.0F;; f = 0.0F)
          {
            localObject3 = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str4.getBytes());
            bg.aYW((String)localObject3);
            y.O(str4, (String)localObject3, false);
            str4 = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
            y.O((String)localObject2, str4, false);
            localObject2 = bg.d("", (String)localObject3, str4, str1, str2, str3);
            int i;
            if (localObject2 == null)
            {
              Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
              i = 0;
              if (i != 0) {
                break label535;
              }
              Log.i("MicroMsg.SightWidget", "commitInThread videopath " + y.bEl(localao.videoPath) + " thumb: " + y.bEl(localao.thumbPath) + ",cdnUrl " + localao.mOI + "cdnThubmUrl " + localao.nRr);
              MMHandlerThread.postToMainThread(new ao.6(localao));
            }
            for (;;)
            {
              Log.i("MicroMsg.SightWidget", "removeRunnable showProgress");
              MMHandlerThread.removeRunnable(ao.this.Rgr);
              if (ao.this.Rgf != null) {
                break label561;
              }
              AppMethodBeat.o(97992);
              return;
              ((dmz)localObject2).IGG = ((String)localObject1);
              if (Util.isNullOrNil(((dmz)localObject2).hAP)) {
                ((dmz)localObject2).hAP = ((String)localObject1);
              }
              ((dmz)localObject2).aaTF = f;
              localbg.QzA.ContentObj.Zpr.add(localObject2);
              localObject1 = new djp();
              ((djp)localObject1).aaPC = ((dmz)localObject2).icg;
              localbg.QzB.aaTI.add(localObject1);
              i = 1;
              break;
              if (!localao.Rgf.K(localao.videoPath, localao.thumbPath, localao.desc, localao.md5))
              {
                Log.i("MicroMsg.SightWidget", "commitInThread videopath " + y.bEl(localao.videoPath) + " thumb: " + y.bEl(localao.thumbPath));
                MMHandlerThread.postToMainThread(new ao.7(localao));
              }
              else
              {
                Log.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            MMHandlerThread.postToMainThread(ao.this.Rgq);
            AppMethodBeat.o(97992);
            return;
          }
        }
      }, "sight_send_ready");
      AppMethodBeat.o(98003);
      return true;
      this.Rgf.akR(0);
      break;
      parami = "";
      continue;
      Log.e("MicroMsg.SightWidget", "get template info error");
    }
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(98000);
    this.RcD = l.y(this.lzt.getIntent());
    this.mOI = Util.nullAs(this.lzt.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.nRr = Util.nullAs(this.lzt.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Rei = this.lzt.getIntent().getBooleanExtra("KThrid_app", false);
    this.Rej = this.lzt.getIntent().getBooleanExtra("KSnsAction", false);
    this.RfR = this.lzt.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.Rga = this.lzt.getIntent().getBooleanExtra("KBlockAdd", false);
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = Util.nullAs(this.lzt.getIntent().getStringExtra("reportSessionId"), "");
    this.RfQ = this.lzt.getIntent().getStringExtra("KSessionID");
    this.Rgb = this.lzt.getIntent().getBooleanExtra("KSnsUploadFromSkipCompress", false);
    Log.i("MicroMsg.SightWidget", "mIsFromSkipCompress:%s, appId:%s", new Object[] { Boolean.valueOf(this.Rgb), this.appId });
    paramBundle = this.Rgc;
    Object localObject1 = this.lzt;
    Log.i("MicroMsg.SnsFakeVLogHelper", "resetFakeData");
    Bundle localBundle = ((MMActivity)localObject1).getIntent().getBundleExtra("key_extra_data");
    if ((localBundle == null) || (localBundle.getByteArray("key_bg_generate_pb") == null) || (localBundle.getByteArray("key_bg_generate_extra_config") == null)) {}
    for (;;)
    {
      paramBundle = this.lzt.getIntent().getBundleExtra("Ksnsupload_timeline");
      if (paramBundle != null) {
        this.Rek = new SendMessageToWX.Req(paramBundle).message;
      }
      this.thumbPath = this.lzt.getIntent().getStringExtra("KSightThumbPath");
      this.videoPath = this.lzt.getIntent().getStringExtra("KSightPath");
      this.RfS = this.lzt.getIntent().getBooleanExtra("KSightDeleted", false);
      this.md5 = this.lzt.getIntent().getStringExtra("sight_md5");
      paramBundle = this.lzt.getIntent().getByteArrayExtra("KMMSightExtInfo");
      if (paramBundle != null) {}
      try
      {
        this.RfP.parseFrom(paramBundle);
        if (this.RfP == null)
        {
          this.RfP = new dmb();
          this.RfP.aaSg = this.RfR;
        }
        this.RfP.appid = this.mSessionId;
        this.RfP.aaSk = this.Rgb;
        this.RfP.aaSl = this.appId;
        paramBundle = new xr();
        paramBundle.iba.type = 2;
        paramBundle.publish();
        if (Util.isNullOrNil(this.videoPath))
        {
          this.videoPath = Util.nullAs(paramBundle.ibb.ibf, "");
          Log.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
        }
        if (Util.isNullOrNil(this.md5))
        {
          paramBundle = Util.nullAs(paramBundle.ibb.ibd, "");
          this.md5 = paramBundle;
          Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
          this.qmO.alive();
          if (this.RfT != 0) {
            break label958;
          }
          al.hgq();
          i = com.tencent.mm.plugin.sns.storage.aa.getScreenWidth();
          if (i != 0) {
            break label919;
          }
          AppMethodBeat.o(98000);
          return;
          localObject2 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightThumbPath");
          localObject3 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightPath");
          if ((y.ZC((String)localObject2)) && (y.ZC((String)localObject3)))
          {
            Log.i("MicroMsg.SnsFakeVLogHelper", "jump generate");
            continue;
          }
          Log.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper go bg generate");
          paramBundle.OnI = false;
          localObject2 = com.tencent.mm.plugin.recordvideo.background.a.NDM;
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
            paramBundle.RVv = ((ami)new ami().parseFrom((byte[])localObject2));
            paramBundle.RVw = ((VideoMixer.MixConfig)localBundle.getParcelable("key_bg_generate_mix_config"));
            paramBundle.RVx = ((apw)new apw().parseFrom((byte[])localObject3));
            label846:
            ((MMActivity)localObject1).getIntent().putExtra("KSightThumbPath", paramBundle.RVv.thumbPath);
            paramBundle = paramBundle.RVw;
            localObject1 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
            com.tencent.mm.plugin.recordvideo.background.e.a((byte[])localObject2, paramBundle, (byte[])localObject3, 7);
            break;
            paramBundle = paramBundle;
            Log.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
            continue;
            paramBundle = this.md5;
          }
          label919:
          this.RfT = ((i - this.lzt.getResources().getDimensionPixelSize(b.d.sns_upload_previewimg_view_margin) * 4 - this.lzt.getResources().getDimensionPixelSize(b.d.LargerPadding) * 2) / 3);
          label958:
          if (this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.QzF = 1;
          }
          for (;;)
          {
            this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
            this.Rge = this.lzt.getIntent().getBooleanExtra("KSnsUploadShowAppName", true);
            if ((this.Rei) && (this.appId.equals("wxa5e0de08d96cc09d")) && (this.Rek != null)) {
              paramBundle = this.Rek.messageExt;
            }
            try
            {
              this.Rgd = new com.tencent.mm.ad.i(paramBundle);
              Log.i("MicroMsg.SightWidget", "SecondCut thumbPath: " + this.thumbPath + ">>cdnThumbPath:" + this.nRr + ">>videoPath:" + this.videoPath + ">>cdnPath:" + this.mOI);
              AppMethodBeat.o(98000);
              return;
              this.QzF = 0;
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
          break label846;
        }
      }
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final void e(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(98002);
    this.videoPath = paramCaptureVideoNormalModel.videoPath;
    this.thumbPath = paramCaptureVideoNormalModel.thumbPath;
    this.lzt.getIntent().putExtra("KSightThumbPath", this.thumbPath);
    this.lzt.getIntent().putExtra("KSightPath", this.videoPath);
    this.md5 = y.bub(paramCaptureVideoNormalModel.videoPath);
    if ((this.rYw != null) && (this.rYw.isShowing()))
    {
      this.rYw.dismiss();
      a(this.Rgh, this.Qog, this.Rgi, this.Rgj, this.Rbq, this.Rgk, this.miW, this.Rgl, this.QCV, this.Rgm, this.Rgn, this.canvasInfo, this.Rgo, this.Rgp);
    }
    AppMethodBeat.o(98002);
  }
  
  public final boolean hlP()
  {
    return !this.RfS;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(98001);
    this.doN = View.inflate(this.lzt, b.g.upload_new_sight_widget, null);
    this.RfL = ((SightPlayImageView)this.doN.findViewById(b.f.thumb_iv));
    this.RfM = ((ImageView)this.doN.findViewById(b.f.status_btn));
    Object localObject = new DisplayMetrics();
    this.lzt.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.RfW = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 100);
    this.RfV = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 100);
    if ((!TextUtils.isEmpty(this.thumbPath)) && (y.ZC(this.thumbPath)))
    {
      Log.i("MicroMsg.SightWidget", "getBitmapNative thumbPath:%s", new Object[] { this.thumbPath });
      this.RfZ = BitmapUtil.getBitmapNative(this.thumbPath);
      M("isPreviewExit", Integer.valueOf(1));
    }
    if (this.RfZ == null)
    {
      M("isPreviewExit", Integer.valueOf(0));
      Log.i("MicroMsg.SightWidget", "getVideoThumb videoPath:%s", new Object[] { this.videoPath });
      this.RfZ = com.tencent.mm.plugin.mmsight.d.Pf(this.videoPath);
    }
    int i;
    boolean bool;
    if (this.RfZ != null)
    {
      this.RfW = this.RfZ.getHeight();
      this.RfV = this.RfZ.getWidth();
      localObject = this.RfZ;
      int n = this.RfV;
      int i1 = this.RfW;
      i = ((Bitmap)localObject).getPixel(n / 4, i1 / 4);
      int j = ((Bitmap)localObject).getPixel(n / 4, i1 / 3);
      int k = ((Bitmap)localObject).getPixel(n / 3, i1 / 3);
      int m = ((Bitmap)localObject).getPixel(n / 3, i1 / 4);
      n = ((Bitmap)localObject).getPixel(n / 2, i1 / 2);
      if ((i != -16777216) || (j != -16777216) || (k != -16777216) || (m != -16777216) || (n != -16777216)) {
        break label804;
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
        M("isPreviewBlack", Integer.valueOf(i));
        Log.i("MicroMsg.SightWidget", "isPreviewBitmapBlack:%b", new Object[] { Boolean.valueOf(bool) });
        Log.i("MicroMsg.SightWidget", "mSightHeight:%s", new Object[] { Integer.valueOf(this.RfW) });
        Log.i("MicroMsg.SightWidget", "mSightWidth:%s", new Object[] { Integer.valueOf(this.RfV) });
        this.RfY = o.a(this.RfV, this.RfW, this.lzt, false);
        Log.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.RfV), Integer.valueOf(this.RfW), this.RfY.first, this.RfY.second, Integer.valueOf(this.RfX) });
        hmq();
        this.RfL.setScaleType(QImageView.a.afVc);
        this.RfL.PGE = true;
        this.RfL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(97990);
            Object localObject = new b();
            ((b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
            if (ao.this.RfS)
            {
              com.tencent.mm.kernel.h.baF();
              if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
              {
                com.tencent.mm.ui.base.aa.j(ao.this.lzt, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
                return;
              }
              if (SnsTimeLineUI.hpL()) {
                ao.this.hmp();
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
                return;
                ao.b(ao.this);
              }
            }
            localObject = new int[2];
            int j;
            int i;
            if (paramAnonymousView != null)
            {
              paramAnonymousView.getLocationInWindow((int[])localObject);
              j = paramAnonymousView.getWidth();
              i = paramAnonymousView.getHeight();
            }
            for (;;)
            {
              if (ao.this.Rgc.aa(localObject[0], localObject[1], j, i))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
                return;
              }
              if (!y.ZC(ao.this.videoPath))
              {
                Log.i("MicroMsg.SightWidget", "click videopath is not exist " + ao.this.videoPath);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
                return;
              }
              paramAnonymousView = new Intent(ao.this.lzt, SnsOnlineVideoActivity.class);
              paramAnonymousView.putExtra("intent_videopath", ao.this.videoPath);
              paramAnonymousView.putExtra("intent_thumbpath", ao.this.thumbPath);
              paramAnonymousView.putExtra("intent_isad", false);
              paramAnonymousView.putExtra("intent_ispreview", true);
              paramAnonymousView.putExtra("KBlockAdd", ao.this.Rga);
              paramAnonymousView.putExtra("sns_video_scene", 6);
              paramAnonymousView.putExtra("img_gallery_left", localObject[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject[1]);
              paramAnonymousView.putExtra("img_gallery_width", j);
              paramAnonymousView.putExtra("img_gallery_height", i);
              ao.this.lzt.startActivityForResult(paramAnonymousView, 12);
              ao.this.lzt.overridePendingTransition(0, 0);
              break;
              i = 0;
              j = 0;
            }
          }
        });
        Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + y.bEl(this.videoPath) + " " + y.bEl(this.thumbPath));
        if (y.ZC(this.videoPath)) {
          Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
        }
        if (this.Rgd != null)
        {
          localObject = j.QFS;
          locali = this.Rgd;
          i = locali.optInt("page");
          str = locali.optString("from");
        }
      }
      try
      {
        ((j)localObject).QGK.ixB = Long.parseLong(str);
        ((j)localObject).QGK.jbR = i;
        ((j)localObject).QGK.jbS = locali.optInt("isPreviewExit");
        ((j)localObject).QGK.jbT = locali.optInt("isPreviewBlack");
        this.Rgd = null;
        localObject = this.doN;
        AppMethodBeat.o(98001);
        return localObject;
        label804:
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
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(98006);
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    this.qmO.dead();
    if (com.tencent.mm.plugin.sns.data.t.S(this.RfO)) {
      this.RfO.recycle();
    }
    com.tencent.mm.plugin.sns.ui.f.a locala = this.Rgc;
    Log.i("MicroMsg.SnsFakeVLogHelper", "release");
    com.tencent.mm.plugin.recordvideo.background.a locala1 = com.tencent.mm.plugin.recordvideo.background.a.NDM;
    com.tencent.mm.plugin.recordvideo.background.a.b(7, locala);
    lq(false);
    AppMethodBeat.o(98006);
    return false;
  }
  
  final void hmp()
  {
    boolean bool1 = false;
    AppMethodBeat.i(308478);
    Object localObject = this.lzt.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
    long l = cn.bDv();
    com.tencent.mm.plugin.report.service.h.OAn.b(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.t.heR(), Long.valueOf(l) });
    if (((String)localObject).equalsIgnoreCase("0"))
    {
      com.tencent.mm.pluginsdk.ui.tools.t.g(this.lzt, SnsTimeLineUI.hpL());
      alI(2);
      AppMethodBeat.o(308478);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.bIg().bIk().duration);
    boolean bool2 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yWw, false);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acWc, 0) == 1) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bool1 = true;
      }
      ((Intent)localObject).putExtra("key_can_select_video_and_pic", bool1);
      ((Intent)localObject).putExtra("key_check_third_party_video", true);
      com.tencent.mm.pluginsdk.ui.tools.t.a(this.lzt, 9, 9, 4, 3, SnsTimeLineUI.hpL(), (Intent)localObject);
      break;
    }
  }
  
  final void hmq()
  {
    AppMethodBeat.i(98008);
    if ((this.RfZ != null) && (!this.RfZ.isRecycled()))
    {
      this.RfL.setImageBitmap(this.RfZ);
      this.RfL.ld(((Integer)this.RfY.first).intValue(), ((Integer)this.RfY.second).intValue());
    }
    AppMethodBeat.o(98008);
  }
  
  final void hmr()
  {
    AppMethodBeat.i(98009);
    this.RfM.setVisibility(8);
    this.RfL.PGy.clear();
    this.RfL.ld(com.tencent.mm.cd.a.fromDPToPix(this.lzt, 100), com.tencent.mm.cd.a.fromDPToPix(this.lzt, 100));
    this.RfL.setBackgroundResource(b.c.sns_upload_add_bg);
    this.RfL.setImageResource(b.i.album_post_add_picture_btn);
    this.RfL.setContentDescription(this.RfL.getContext().getString(b.j.sns_add_video));
    int i = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 100) * 35 / 100;
    this.RfL.setPadding(i, i, i, i);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yVQ, true))
    {
      com.tencent.mm.plugin.recordvideo.util.f localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      com.tencent.mm.plugin.recordvideo.util.f.aTt(this.videoPath);
      localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      com.tencent.mm.plugin.recordvideo.util.f.aTt(this.thumbPath);
    }
    AppMethodBeat.o(98009);
  }
  
  public final boolean hms()
  {
    if (this.RfP != null) {
      return this.RfP.aaSg;
    }
    return false;
  }
  
  /* Error */
  public final boolean n(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1609
    //   3: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+29 -> 36, 9:+266->273, 10:+29->36, 11:+142->149, 12:+37->44
    //   37: iconst_3
    //   38: dstore_2
    //   39: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_2
    //   45: ifnull -9 -> 36
    //   48: aload_0
    //   49: aload_2
    //   50: ldc_w 1611
    //   53: iconst_0
    //   54: invokevirtual 378	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   57: putfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   60: aload_0
    //   61: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   64: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc_w 277
    //   70: aload_0
    //   71: getfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   74: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   77: pop
    //   78: aload_0
    //   79: getfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   82: ifeq +59 -> 141
    //   85: aload_0
    //   86: getfield 244	com/tencent/mm/plugin/sns/ui/ao:Rgc	Lcom/tencent/mm/plugin/sns/ui/f/a;
    //   89: astore_2
    //   90: ldc_w 1069
    //   93: ldc_w 1613
    //   96: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic 1154	com/tencent/mm/plugin/recordvideo/background/a:NDM	Lcom/tencent/mm/plugin/recordvideo/background/a;
    //   102: astore 4
    //   104: bipush 7
    //   106: aload_2
    //   107: invokestatic 1453	com/tencent/mm/plugin/recordvideo/background/a:b	(ILcom/tencent/mm/plugin/recordvideo/background/b;)V
    //   110: aload_2
    //   111: getfield 1616	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   114: invokestatic 858	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +15 -> 132
    //   120: getstatic 1192	com/tencent/mm/plugin/recordvideo/background/e:NDU	Lcom/tencent/mm/plugin/recordvideo/background/e;
    //   123: astore 4
    //   125: aload_2
    //   126: getfield 1616	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   129: invokestatic 1619	com/tencent/mm/plugin/recordvideo/background/e:aSR	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual 1621	com/tencent/mm/plugin/sns/ui/ao:hmr	()V
    //   136: aload_0
    //   137: iconst_1
    //   138: invokespecial 1455	com/tencent/mm/plugin/sns/ui/ao:lq	(Z)V
    //   141: ldc_w 1609
    //   144: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_2
    //   150: ldc_w 1623
    //   153: invokevirtual 1626	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   156: checkcast 1628	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull -127 -> 36
    //   166: aload 4
    //   168: getfield 1631	com/tencent/mm/plugin/mmsight/SightCaptureResult:KTL	Z
    //   171: ifne +17 -> 188
    //   174: aload_0
    //   175: aload 4
    //   177: invokespecial 1633	com/tencent/mm/plugin/sns/ui/ao:a	(Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;)V
    //   180: ldc_w 1609
    //   183: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: iconst_1
    //   187: ireturn
    //   188: aload_0
    //   189: iconst_1
    //   190: putfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   193: aload_0
    //   194: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   197: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   200: ldc_w 277
    //   203: aload_0
    //   204: getfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   207: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   210: pop
    //   211: aload_2
    //   212: ldc_w 1635
    //   215: iconst_0
    //   216: invokevirtual 963	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   219: istore_1
    //   220: aload 4
    //   222: getfield 1638	com/tencent/mm/plugin/mmsight/SightCaptureResult:KTT	Ljava/lang/String;
    //   225: astore_2
    //   226: aload_0
    //   227: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   230: instanceof 285
    //   233: ifeq +32 -> 265
    //   236: aload_0
    //   237: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   240: checkcast 285	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   243: aload_2
    //   244: iconst_1
    //   245: iload_1
    //   246: aconst_null
    //   247: aconst_null
    //   248: aload_0
    //   249: getfield 830	com/tencent/mm/plugin/sns/ui/ao:Rcy	I
    //   252: invokevirtual 1641	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   255: aload_0
    //   256: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   259: checkcast 285	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   262: invokevirtual 1644	com/tencent/mm/plugin/sns/ui/SnsUploadUI:hqu	()V
    //   265: ldc_w 1609
    //   268: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: iconst_1
    //   272: ireturn
    //   273: aload_2
    //   274: ldc_w 1073
    //   277: invokevirtual 1077	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   280: astore 4
    //   282: aload 4
    //   284: ifnull +148 -> 432
    //   287: aload 4
    //   289: ldc_w 1079
    //   292: invokevirtual 1084	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   295: ifnull +137 -> 432
    //   298: aload 4
    //   300: ldc_w 1086
    //   303: invokevirtual 1084	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   306: ifnull +126 -> 432
    //   309: ldc_w 259
    //   312: ldc_w 1646
    //   315: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload_0
    //   319: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   322: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   325: invokevirtual 1650	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   328: invokevirtual 1651	android/os/Bundle:clear	()V
    //   331: aload_0
    //   332: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   335: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   338: ldc_w 1047
    //   341: iconst_0
    //   342: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   345: pop
    //   346: aload_0
    //   347: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   350: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   353: ldc_w 1653
    //   356: iconst_1
    //   357: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   360: pop
    //   361: aload_0
    //   362: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   365: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   368: ldc_w 1655
    //   371: bipush 14
    //   373: invokevirtual 1500	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   376: pop
    //   377: aload_0
    //   378: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   381: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   384: ldc_w 1073
    //   387: aload_2
    //   388: ldc_w 1073
    //   391: invokevirtual 1077	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   394: invokevirtual 1658	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   397: pop
    //   398: getstatic 1664	com/tencent/mm/plugin/recordvideo/util/l:ObI	Lcom/tencent/mm/plugin/recordvideo/util/l;
    //   401: astore 4
    //   403: aload_0
    //   404: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   407: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   410: aload_2
    //   411: invokestatic 1667	com/tencent/mm/plugin/recordvideo/util/l:c	(Landroid/content/Intent;Landroid/content/Intent;)V
    //   414: aload_0
    //   415: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   418: checkcast 285	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   421: invokevirtual 1644	com/tencent/mm/plugin/sns/ui/SnsUploadUI:hqu	()V
    //   424: ldc_w 1609
    //   427: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: iconst_1
    //   431: ireturn
    //   432: aload_2
    //   433: ldc_w 1669
    //   436: invokevirtual 1673	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   439: astore 4
    //   441: aload 4
    //   443: ifnull +11 -> 454
    //   446: aload 4
    //   448: invokevirtual 1678	java/util/ArrayList:size	()I
    //   451: ifgt +16 -> 467
    //   454: aload_2
    //   455: ldc_w 1680
    //   458: invokevirtual 1031	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   461: invokestatic 927	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   464: ifne +409 -> 873
    //   467: aload_0
    //   468: iconst_0
    //   469: putfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   472: aload_0
    //   473: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   476: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   479: ldc_w 277
    //   482: aload_0
    //   483: getfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   486: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   489: pop
    //   490: aload 4
    //   492: ifnull +125 -> 617
    //   495: aload 4
    //   497: invokevirtual 1678	java/util/ArrayList:size	()I
    //   500: ifle +117 -> 617
    //   503: aload 4
    //   505: iconst_0
    //   506: invokevirtual 1683	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   509: checkcast 329	java/lang/String
    //   512: astore 4
    //   514: aload_2
    //   515: ldc_w 1685
    //   518: invokevirtual 1031	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 5
    //   523: aload 5
    //   525: invokestatic 927	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   528: ifne +14 -> 542
    //   531: aload 5
    //   533: astore_2
    //   534: aload 5
    //   536: invokestatic 737	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   539: ifne +184 -> 723
    //   542: new 894	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 1686	java/lang/StringBuilder:<init>	()V
    //   549: invokestatic 1689	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   552: invokevirtual 903	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 4
    //   557: invokestatic 1245	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   560: invokevirtual 903	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 906	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: astore_2
    //   567: new 185	com/tencent/mm/compatible/i/d
    //   570: dup
    //   571: invokespecial 186	com/tencent/mm/compatible/i/d:<init>	()V
    //   574: astore 5
    //   576: aload 5
    //   578: aload 4
    //   580: invokevirtual 1694	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   583: aload 5
    //   585: lconst_0
    //   586: invokevirtual 1698	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   589: astore 6
    //   591: aload 6
    //   593: ifnonnull +36 -> 629
    //   596: ldc_w 259
    //   599: ldc_w 1700
    //   602: invokestatic 266	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: aload 5
    //   607: invokevirtual 1702	android/media/MediaMetadataRetriever:release	()V
    //   610: goto -574 -> 36
    //   613: astore_2
    //   614: goto -578 -> 36
    //   617: aload_2
    //   618: ldc_w 1680
    //   621: invokevirtual 1031	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   624: astore 4
    //   626: goto -112 -> 514
    //   629: ldc_w 259
    //   632: ldc_w 1704
    //   635: iconst_2
    //   636: anewarray 4	java/lang/Object
    //   639: dup
    //   640: iconst_0
    //   641: aload 6
    //   643: invokevirtual 1338	android/graphics/Bitmap:getWidth	()I
    //   646: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   649: aastore
    //   650: dup
    //   651: iconst_1
    //   652: aload 6
    //   654: invokevirtual 1335	android/graphics/Bitmap:getHeight	()I
    //   657: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: aastore
    //   661: invokestatic 1067	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   664: aload 6
    //   666: bipush 80
    //   668: getstatic 1710	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   671: aload_2
    //   672: iconst_1
    //   673: invokestatic 1714	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   676: pop
    //   677: aload_2
    //   678: invokestatic 1718	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   681: astore 6
    //   683: ldc_w 259
    //   686: ldc_w 1720
    //   689: iconst_2
    //   690: anewarray 4	java/lang/Object
    //   693: dup
    //   694: iconst_0
    //   695: aload 6
    //   697: getfield 1725	android/graphics/BitmapFactory$Options:outWidth	I
    //   700: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   703: aastore
    //   704: dup
    //   705: iconst_1
    //   706: aload 6
    //   708: getfield 1728	android/graphics/BitmapFactory$Options:outHeight	I
    //   711: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   714: aastore
    //   715: invokestatic 1067	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   718: aload 5
    //   720: invokevirtual 1702	android/media/MediaMetadataRetriever:release	()V
    //   723: aload_0
    //   724: aload 4
    //   726: invokestatic 1245	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   729: putfield 158	com/tencent/mm/plugin/sns/ui/ao:md5	Ljava/lang/String;
    //   732: ldc_w 259
    //   735: ldc_w 1730
    //   738: iconst_4
    //   739: anewarray 4	java/lang/Object
    //   742: dup
    //   743: iconst_0
    //   744: aload 4
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: aload_2
    //   750: aastore
    //   751: dup
    //   752: iconst_2
    //   753: aload 4
    //   755: invokestatic 1401	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   758: invokestatic 526	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   761: aastore
    //   762: dup
    //   763: iconst_3
    //   764: aload_2
    //   765: invokestatic 1401	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   768: invokestatic 526	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   771: aastore
    //   772: invokestatic 1067	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   775: aload_0
    //   776: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   779: instanceof 285
    //   782: ifeq +33 -> 815
    //   785: aload_0
    //   786: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   789: checkcast 285	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   792: aload 4
    //   794: aload_2
    //   795: aload_0
    //   796: getfield 158	com/tencent/mm/plugin/sns/ui/ao:md5	Ljava/lang/String;
    //   799: aconst_null
    //   800: iconst_0
    //   801: iconst_0
    //   802: invokevirtual 1733	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZZ)V
    //   805: aload_0
    //   806: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   809: checkcast 285	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   812: invokevirtual 1644	com/tencent/mm/plugin/sns/ui/SnsUploadUI:hqu	()V
    //   815: ldc_w 1609
    //   818: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   821: iconst_1
    //   822: ireturn
    //   823: astore 6
    //   825: ldc_w 259
    //   828: ldc_w 1735
    //   831: iconst_1
    //   832: anewarray 4	java/lang/Object
    //   835: dup
    //   836: iconst_0
    //   837: aload 6
    //   839: invokevirtual 1200	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   842: aastore
    //   843: invokestatic 1125	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   846: aload 5
    //   848: invokevirtual 1702	android/media/MediaMetadataRetriever:release	()V
    //   851: goto -128 -> 723
    //   854: astore 5
    //   856: goto -133 -> 723
    //   859: astore_2
    //   860: aload 5
    //   862: invokevirtual 1702	android/media/MediaMetadataRetriever:release	()V
    //   865: ldc_w 1609
    //   868: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   871: aload_2
    //   872: athrow
    //   873: aload_2
    //   874: ldc_w 1623
    //   877: invokevirtual 1626	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   880: checkcast 1628	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   883: astore 4
    //   885: aload 4
    //   887: ifnull +25 -> 912
    //   890: aload 4
    //   892: getfield 1631	com/tencent/mm/plugin/mmsight/SightCaptureResult:KTL	Z
    //   895: ifne +17 -> 912
    //   898: aload_0
    //   899: aload 4
    //   901: invokespecial 1633	com/tencent/mm/plugin/sns/ui/ao:a	(Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;)V
    //   904: ldc_w 1609
    //   907: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   910: iconst_1
    //   911: ireturn
    //   912: aload_0
    //   913: iconst_1
    //   914: putfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   917: aload_0
    //   918: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   921: invokevirtual 275	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   924: ldc_w 277
    //   927: aload_0
    //   928: getfield 181	com/tencent/mm/plugin/sns/ui/ao:RfS	Z
    //   931: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   934: pop
    //   935: aload_2
    //   936: ldc_w 1737
    //   939: invokevirtual 1673	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   942: astore 4
    //   944: aload 4
    //   946: ifnull +11 -> 957
    //   949: aload 4
    //   951: invokevirtual 1678	java/util/ArrayList:size	()I
    //   954: ifne +20 -> 974
    //   957: ldc_w 259
    //   960: ldc_w 1739
    //   963: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   966: ldc_w 1609
    //   969: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   972: iconst_0
    //   973: ireturn
    //   974: new 1675	java/util/ArrayList
    //   977: dup
    //   978: invokespecial 1740	java/util/ArrayList:<init>	()V
    //   981: astore 5
    //   983: aload 4
    //   985: invokevirtual 1741	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   988: astore 6
    //   990: aload 6
    //   992: invokeinterface 764 1 0
    //   997: ifeq +76 -> 1073
    //   1000: aload 6
    //   1002: invokeinterface 768 1 0
    //   1007: checkcast 329	java/lang/String
    //   1010: astore 7
    //   1012: aload 7
    //   1014: invokestatic 1747	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1017: invokevirtual 1751	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1020: astore 8
    //   1022: aload 8
    //   1024: ifnull -34 -> 990
    //   1027: aload 5
    //   1029: ldc_w 1753
    //   1032: iconst_3
    //   1033: anewarray 4	java/lang/Object
    //   1036: dup
    //   1037: iconst_0
    //   1038: aload 7
    //   1040: aastore
    //   1041: dup
    //   1042: iconst_1
    //   1043: aload 8
    //   1045: getfield 1759	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1048: invokestatic 1764	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1051: aastore
    //   1052: dup
    //   1053: iconst_2
    //   1054: aload 8
    //   1056: getfield 1767	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1059: invokestatic 1764	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1062: aastore
    //   1063: invokestatic 1771	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1066: invokevirtual 1772	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1069: pop
    //   1070: goto -80 -> 990
    //   1073: aload_2
    //   1074: ldc_w 1774
    //   1077: iconst_0
    //   1078: invokevirtual 378	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1081: istore_3
    //   1082: aload_2
    //   1083: ldc_w 1635
    //   1086: iconst_0
    //   1087: invokevirtual 963	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1090: istore_1
    //   1091: aload_0
    //   1092: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1095: instanceof 285
    //   1098: ifeq -1062 -> 36
    //   1101: aload_0
    //   1102: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1105: checkcast 285	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1108: aconst_null
    //   1109: iload_3
    //   1110: iload_1
    //   1111: aload 4
    //   1113: aload 5
    //   1115: aload_0
    //   1116: getfield 830	com/tencent/mm/plugin/sns/ui/ao:Rcy	I
    //   1119: invokevirtual 1641	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   1122: aload_0
    //   1123: getfield 237	com/tencent/mm/plugin/sns/ui/ao:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   1126: checkcast 285	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1129: invokevirtual 1644	com/tencent/mm/plugin/sns/ui/SnsUploadUI:hqu	()V
    //   1132: goto -1096 -> 36
    //   1135: astore 5
    //   1137: goto -414 -> 723
    //   1140: astore 4
    //   1142: goto -277 -> 865
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1145	0	this	ao
    //   0	1145	1	paramInt	int
    //   0	1145	2	paramIntent	Intent
    //   1081	29	3	bool	boolean
    //   102	1010	4	localObject1	Object
    //   1140	1	4	localException1	Exception
    //   521	326	5	localObject2	Object
    //   854	7	5	localException2	Exception
    //   981	133	5	localArrayList	java.util.ArrayList
    //   1135	1	5	localException3	Exception
    //   589	118	6	localObject3	Object
    //   823	15	6	localException4	Exception
    //   988	13	6	localIterator	Iterator
    //   1010	29	7	str	String
    //   1020	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   605	610	613	java/lang/Exception
    //   576	591	823	java/lang/Exception
    //   596	605	823	java/lang/Exception
    //   629	718	823	java/lang/Exception
    //   846	851	854	java/lang/Exception
    //   576	591	859	finally
    //   596	605	859	finally
    //   629	718	859	finally
    //   825	846	859	finally
    //   718	723	1135	java/lang/Exception
    //   860	865	1140	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ao
 * JD-Core Version:    0.7.0.1
 */