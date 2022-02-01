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
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.b;
import com.tencent.mm.g.b.a.ii;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.e.d.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.ui.f.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.ebm;
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
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.QImageView.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  implements ad, a.a
{
  private int DEA;
  private int DPi;
  private boolean DSg;
  private List<String> Eoz;
  private int EpG;
  private k EpM;
  private String EpN;
  private boolean Ero;
  private boolean Erp;
  private WXMediaMessage Erq;
  SightPlayImageView EsO;
  private ImageView EsP;
  boolean EsQ;
  private Bitmap EsR;
  private cly EsS;
  private String EsT;
  private boolean EsU;
  boolean EsV;
  private int EsW;
  private MediaMetadataRetriever EsX;
  private int EsY;
  private int EsZ;
  private int Eta;
  private Pair<Integer, Integer> Etb;
  private Bitmap Etc;
  boolean Etd;
  private boolean Ete;
  com.tencent.mm.plugin.sns.ui.f.a Etf;
  private com.tencent.mm.ab.i Etg;
  bf Eth;
  private int Eti;
  private int Etj;
  private org.b.d.i Etk;
  private String Etl;
  private cjy Etm;
  private int Etn;
  private List<String> Eto;
  private PInt Etp;
  private int Etq;
  private int Etr;
  Runnable Ets;
  Runnable Ett;
  private String appId;
  private String appName;
  private String canvasInfo;
  private boolean dGX;
  String desc;
  private LinkedList<Long> gYE;
  ProgressDialog gtM;
  MMActivity gte;
  String iwX;
  private String mSessionId;
  String md5;
  private q nUq;
  String pkK;
  private View sc;
  private IListener tOh;
  String thumbPath;
  String videoPath;
  
  public al(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97999);
    this.sc = null;
    this.EsP = null;
    this.thumbPath = "";
    this.videoPath = "";
    this.md5 = "";
    this.dGX = false;
    this.EsQ = false;
    this.EsR = null;
    this.EpM = null;
    this.EsS = new cly();
    this.Ero = false;
    this.Erp = false;
    this.Erq = null;
    this.EsU = false;
    this.EsV = false;
    this.EsW = 0;
    this.EsX = new com.tencent.mm.compatible.i.d();
    this.EsY = 0;
    this.EsZ = 0;
    this.Eta = 90;
    this.Etb = null;
    this.Etc = null;
    this.Etd = false;
    this.Ete = false;
    this.DPi = 1;
    this.EpN = "";
    this.tOh = new IListener() {};
    this.Eth = null;
    this.Eti = 0;
    this.desc = "";
    this.gtM = null;
    this.Ets = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97993);
        al.a(al.this);
        AppMethodBeat.o(97993);
      }
    };
    this.Ett = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97995);
        Log.i("MicroMsg.SightWidget", "showProgress");
        al localal = al.this;
        MMActivity localMMActivity = al.this.gte;
        al.this.gte.getString(2131755998);
        localal.gtM = com.tencent.mm.ui.base.h.a(localMMActivity, al.this.gte.getString(2131766215), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(97994);
            al.this.Eth = null;
            al.this.EsQ = false;
            MMHandlerThread.removeRunnable(al.this.Ets);
            AppMethodBeat.o(97994);
          }
        });
        AppMethodBeat.o(97995);
      }
    };
    this.gte = paramMMActivity;
    this.Etf = new com.tencent.mm.plugin.sns.ui.f.a(paramMMActivity, this);
    AppMethodBeat.o(97999);
  }
  
  private void B(String paramString, Object paramObject)
  {
    AppMethodBeat.i(203315);
    if (this.Etg != null) {
      try
      {
        this.Etg.i(paramString, paramObject);
        AppMethodBeat.o(203315);
        return;
      }
      catch (com.tencent.mm.ab.g paramString)
      {
        Log.e("MicroMsg.SightWidget", "put SecondCut JSON Error");
      }
    }
    AppMethodBeat.o(203315);
  }
  
  private void vl(boolean paramBoolean)
  {
    AppMethodBeat.i(98004);
    this.videoPath = "";
    this.thumbPath = "";
    this.EsV = paramBoolean;
    if (paramBoolean)
    {
      this.gte.getIntent().putExtra("KSightThumbPath", this.thumbPath);
      this.gte.getIntent().putExtra("KSightPath", this.videoPath);
    }
    this.gte.getIntent().putExtra("KSightDeleted", this.EsV);
    this.Eta = 90;
    if (com.tencent.mm.plugin.sns.data.r.M(this.Etc))
    {
      this.Etc.recycle();
      this.Etc = null;
    }
    AppMethodBeat.o(98004);
  }
  
  final void Zy(int paramInt)
  {
    AppMethodBeat.i(98007);
    ii localii = new ii().ahh();
    localii.eOC = paramInt;
    localii.wg(this.EsT).bfK();
    AppMethodBeat.o(98007);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98003);
    if (this.Etf.fkY())
    {
      this.nUq = com.tencent.mm.ui.base.h.a(this.gte, this.gte.getString(2131764610), true, null);
      this.Etj = paramInt1;
      this.DEA = paramInt2;
      this.Etk = parami;
      this.Etl = paramString1;
      this.Eoz = paramList1;
      this.Etm = paramcjy;
      this.gYE = paramLinkedList;
      this.Etn = paramInt3;
      this.DSg = paramBoolean;
      this.Eto = paramList2;
      this.Etp = paramPInt;
      this.canvasInfo = paramString2;
      this.Etq = paramInt4;
      this.Etr = paramInt5;
      ((SnsUploadUI)this.gte).EPM = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (!com.tencent.mm.vfs.s.YS(this.videoPath))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97991);
          u.makeText(al.this.gte, 2131765235, 0).show();
          AppMethodBeat.o(97991);
        }
      });
      ((SnsUploadUI)this.gte).EPM = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.Eth != null)
    {
      ((SnsUploadUI)this.gte).EPM = false;
      AppMethodBeat.o(98003);
      return false;
    }
    if (this.EsQ)
    {
      AppMethodBeat.o(98003);
      return true;
    }
    this.EsQ = true;
    this.desc = paramString1;
    parami = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramLinkedList.contains(paramString2))
        {
          ebm localebm = new ebm();
          localebm.UserName = paramString2;
          parami.add(localebm);
        }
      }
    }
    this.Eth = new bf(15, this.gte);
    paramPInt.value = this.Eth.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      this.Eth.YF(3);
    }
    paramString1 = this.Eth.aPw(paramString1);
    new LinkedList();
    paramString1.a(paramcjy).bq(parami).YI(paramInt1).YJ(paramInt2).gR(paramList2);
    if (paramBoolean) {
      this.Eth.YL(1);
    }
    for (;;)
    {
      this.Eth.ct(this.DPi, this.EpN);
      this.Eth.gR(paramList2);
      this.Eth.YK(this.EpG);
      this.Eth.eck = this.EsS;
      this.Eth.g(null, null, null, paramInt4, paramInt5);
      this.Eth.setSessionId(this.mSessionId);
      if (!Util.isNullOrNil(this.appId)) {
        this.Eth.aPC(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        this.Eth.aPD(Util.nullAs(this.appName, ""));
      }
      if (this.Ero) {
        this.Eth.YK(5);
      }
      if ((this.Erp) && (this.Erq != null))
      {
        this.Eth.aPx(this.Erq.mediaTagName);
        this.Eth.aO(this.appId, this.Erq.messageExt, this.Erq.messageAction);
      }
      MMHandlerThread.postToMainThreadDelayed(this.Ett, 700L);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97992);
          al localal = al.this;
          long l = System.currentTimeMillis();
          bf localbf;
          String str4;
          Object localObject2;
          Object localObject1;
          String str1;
          String str2;
          String str3;
          Object localObject3;
          if ((!TextUtils.isEmpty(localal.pkK)) && (!TextUtils.isEmpty(localal.iwX)))
          {
            localbf = localal.Eth;
            str4 = localal.videoPath;
            localObject2 = localal.thumbPath;
            localObject1 = localal.desc;
            str1 = localal.md5;
            str2 = localal.pkK;
            str3 = localal.iwX;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.d.Cin;
            localObject3 = com.tencent.mm.plugin.recordvideo.e.d.aLQ(str4);
            if (localObject3 == null) {
              break label575;
            }
            Log.i("MicroMsg.UploadPackHelper", "addSightObjectByUrl commit video_info:".concat(String.valueOf(localObject3)));
          }
          label533:
          label559:
          label575:
          for (float f = ((d.a)localObject3).duration / 1000.0F;; f = 0.0F)
          {
            localObject3 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str4.getBytes());
            bf.aPG((String)localObject3);
            com.tencent.mm.vfs.s.nw(str4, (String)localObject3);
            str4 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
            com.tencent.mm.vfs.s.nw((String)localObject2, str4);
            localObject2 = bf.b("", (String)localObject3, str4, str1, str2, str3);
            int i;
            if (localObject2 == null)
            {
              Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
              i = 0;
              if (i != 0) {
                break label533;
              }
              Log.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.s.boW(localal.videoPath) + " thumb: " + com.tencent.mm.vfs.s.boW(localal.thumbPath) + ",cdnUrl " + localal.pkK + "cdnThubmUrl " + localal.iwX);
              MMHandlerThread.postToMainThread(new al.7(localal));
            }
            for (;;)
            {
              Log.i("MicroMsg.SightWidget", "removeRunnable showProgress");
              MMHandlerThread.removeRunnable(al.this.Ett);
              if (al.this.Eth != null) {
                break label559;
              }
              AppMethodBeat.o(97992);
              return;
              ((cnb)localObject2).Desc = ((String)localObject1);
              if (Util.isNullOrNil(((cnb)localObject2).Title)) {
                ((cnb)localObject2).Title = ((String)localObject1);
              }
              ((cnb)localObject2).MsT = f;
              localbf.DPd.ContentObj.LoV.add(localObject2);
              localObject1 = new cjs();
              ((cjs)localObject1).Mpj = ((cnb)localObject2).ecf;
              localbf.DPe.MsW.add(localObject1);
              i = 1;
              break;
              if (!localal.Eth.D(localal.videoPath, localal.thumbPath, localal.desc, localal.md5))
              {
                Log.i("MicroMsg.SightWidget", "commitInThread videopath " + com.tencent.mm.vfs.s.boW(localal.videoPath) + " thumb: " + com.tencent.mm.vfs.s.boW(localal.thumbPath));
                MMHandlerThread.postToMainThread(new al.8(localal));
              }
              else
              {
                Log.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              }
            }
            MMHandlerThread.postToMainThread(al.this.Ets);
            AppMethodBeat.o(97992);
            return;
          }
        }
      }, "sight_send_ready");
      AppMethodBeat.o(98003);
      return true;
      this.Eth.YL(0);
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(98000);
    this.EpM = k.w(this.gte.getIntent());
    this.pkK = Util.nullAs(this.gte.getIntent().getStringExtra("KSightCdnUrl"), "");
    this.iwX = Util.nullAs(this.gte.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
    this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
    this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
    this.EsU = this.gte.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.Etd = this.gte.getIntent().getBooleanExtra("KBlockAdd", false);
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
    this.EsT = this.gte.getIntent().getStringExtra("KSessionID");
    this.Ete = this.gte.getIntent().getBooleanExtra("KSnsUploadFromSkipCompress", false);
    Log.i("MicroMsg.SightWidget", "mIsFromSkipCompress:%s, appId:%s", new Object[] { Boolean.valueOf(this.Ete), this.appId });
    paramBundle = this.Etf;
    Object localObject1 = this.gte;
    Log.i("MicroMsg.SnsFakeVLogHelper", "resetFakeData");
    Bundle localBundle = ((MMActivity)localObject1).getIntent().getBundleExtra("key_extra_data");
    if ((localBundle == null) || (localBundle.getByteArray("key_bg_generate_pb") == null) || (localBundle.getByteArray("key_bg_generate_extra_config") == null)) {}
    for (;;)
    {
      paramBundle = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
      if (paramBundle != null) {
        this.Erq = new SendMessageToWX.Req(paramBundle).message;
      }
      this.thumbPath = this.gte.getIntent().getStringExtra("KSightThumbPath");
      this.videoPath = this.gte.getIntent().getStringExtra("KSightPath");
      this.EsV = this.gte.getIntent().getBooleanExtra("KSightDeleted", false);
      this.md5 = this.gte.getIntent().getStringExtra("sight_md5");
      paramBundle = this.gte.getIntent().getByteArrayExtra("KMMSightExtInfo");
      if (paramBundle != null) {}
      try
      {
        this.EsS.parseFrom(paramBundle);
        if (this.EsS == null)
        {
          this.EsS = new cly();
          this.EsS.Mrn = this.EsU;
        }
        this.EsS.dNI = this.mSessionId;
        this.EsS.Mrr = this.Ete;
        this.EsS.Mrs = this.appId;
        paramBundle = new uw();
        paramBundle.ebg.type = 2;
        EventCenter.instance.publish(paramBundle);
        if (Util.isNullOrNil(this.videoPath))
        {
          this.videoPath = Util.nullAs(paramBundle.ebh.ebl, "");
          Log.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[] { this.videoPath });
        }
        if (Util.isNullOrNil(this.md5))
        {
          paramBundle = Util.nullAs(paramBundle.ebh.ebj, "");
          this.md5 = paramBundle;
          Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[] { this.thumbPath, this.videoPath, this.md5 });
          EventCenter.instance.addListener(this.tOh);
          if (this.EsW != 0) {
            break label961;
          }
          aj.faD();
          i = com.tencent.mm.plugin.sns.storage.r.getScreenWidth();
          if (i != 0) {
            break label922;
          }
          AppMethodBeat.o(98000);
          return;
          localObject2 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightThumbPath");
          localObject3 = ((MMActivity)localObject1).getIntent().getStringExtra("KSightPath");
          if ((com.tencent.mm.vfs.s.YS((String)localObject2)) && (com.tencent.mm.vfs.s.YS((String)localObject3)))
          {
            Log.i("MicroMsg.SnsFakeVLogHelper", "jump generate");
            continue;
          }
          Log.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper go bg generate");
          paramBundle.CsL = false;
          localObject2 = com.tencent.mm.plugin.recordvideo.background.a.BKb;
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
            paramBundle.FdN = ((aio)new aio().parseFrom((byte[])localObject2));
            paramBundle.FdO = ((VideoMixer.MixConfig)localBundle.getParcelable("key_bg_generate_mix_config"));
            paramBundle.FdP = ((ald)new ald().parseFrom((byte[])localObject3));
            label850:
            ((MMActivity)localObject1).getIntent().putExtra("KSightThumbPath", paramBundle.FdN.thumbPath);
            paramBundle = paramBundle.FdO;
            localObject1 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            com.tencent.mm.plugin.recordvideo.background.e.a((byte[])localObject2, paramBundle, (byte[])localObject3, 7);
            break;
            paramBundle = paramBundle;
            Log.i("MicroMsg.SightWidget", "error %s", new Object[] { paramBundle.getMessage() });
            continue;
            paramBundle = this.md5;
          }
          label922:
          this.EsW = ((i - this.gte.getResources().getDimensionPixelSize(2131166972) * 4 - this.gte.getResources().getDimensionPixelSize(2131165501) * 2) / 3);
          label961:
          if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
          }
          for (;;)
          {
            this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
            if ((this.Ero) && (this.appId.equals("wxa5e0de08d96cc09d")) && (this.Erq != null)) {
              paramBundle = this.Erq.messageExt;
            }
            try
            {
              this.Etg = new com.tencent.mm.ab.i(paramBundle);
              Log.i("MicroMsg.SightWidget", "SecondCut thumbPath: " + this.thumbPath + ">>cdnThumbPath:" + this.iwX + ">>videoPath:" + this.videoPath + ">>cdnPath:" + this.pkK);
              AppMethodBeat.o(98000);
              return;
              this.DPi = 0;
            }
            catch (com.tencent.mm.ab.g paramBundle)
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
  
  public final void aD(Bundle paramBundle) {}
  
  public final void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(98002);
    this.videoPath = paramCaptureVideoNormalModel.videoPath;
    this.thumbPath = paramCaptureVideoNormalModel.thumbPath;
    this.gte.getIntent().putExtra("KSightThumbPath", this.thumbPath);
    this.gte.getIntent().putExtra("KSightPath", this.videoPath);
    this.md5 = com.tencent.mm.vfs.s.bhK(paramCaptureVideoNormalModel.videoPath);
    if ((this.nUq != null) && (this.nUq.isShowing()))
    {
      this.nUq.dismiss();
      a(this.Etj, this.DEA, this.Etk, this.Etl, this.Eoz, this.Etm, this.gYE, this.Etn, this.DSg, this.Eto, this.Etp, this.canvasInfo, this.Etq, this.Etr);
    }
    AppMethodBeat.o(98002);
  }
  
  public final boolean ffA()
  {
    return !this.EsV;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(98001);
    this.sc = View.inflate(this.gte, 2131496781, null);
    this.EsO = ((SightPlayImageView)this.sc.findViewById(2131309073));
    this.EsP = ((ImageView)this.sc.findViewById(2131308392));
    Object localObject = new DisplayMetrics();
    this.gte.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.EsZ = com.tencent.mm.cb.a.fromDPToPix(this.gte, 100);
    this.EsY = com.tencent.mm.cb.a.fromDPToPix(this.gte, 100);
    if ((!TextUtils.isEmpty(this.thumbPath)) && (com.tencent.mm.vfs.s.YS(this.thumbPath)))
    {
      Log.i("MicroMsg.SightWidget", "getBitmapNative thumbPath:%s", new Object[] { this.thumbPath });
      this.Etc = BitmapUtil.getBitmapNative(this.thumbPath);
      B("isPreviewExit", Integer.valueOf(1));
    }
    if (this.Etc == null)
    {
      B("isPreviewExit", Integer.valueOf(0));
      Log.i("MicroMsg.SightWidget", "getVideoThumb videoPath:%s", new Object[] { this.videoPath });
      this.Etc = com.tencent.mm.plugin.mmsight.d.PF(this.videoPath);
    }
    int i;
    boolean bool;
    if (this.Etc != null)
    {
      this.EsZ = this.Etc.getHeight();
      this.EsY = this.Etc.getWidth();
      localObject = this.Etc;
      int n = this.EsY;
      int i1 = this.EsZ;
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
      com.tencent.mm.ab.i locali;
      String str;
      if (bool)
      {
        i = 1;
        B("isPreviewBlack", Integer.valueOf(i));
        Log.i("MicroMsg.SightWidget", "isPreviewBitmapBlack:%b", new Object[] { Boolean.valueOf(bool) });
        Log.i("MicroMsg.SightWidget", "mSightHeight:%s", new Object[] { Integer.valueOf(this.EsZ) });
        Log.i("MicroMsg.SightWidget", "mSightWidth:%s", new Object[] { Integer.valueOf(this.EsY) });
        this.Etb = n.a(this.EsY, this.EsZ, this.gte, false);
        Log.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", new Object[] { Integer.valueOf(this.EsY), Integer.valueOf(this.EsZ), this.Etb.first, this.Etb.second, Integer.valueOf(this.Eta) });
        ffZ();
        this.EsO.setScaleType(QImageView.a.QEL);
        this.EsO.Dnz = true;
        this.EsO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(97990);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if (al.this.EsV)
            {
              com.tencent.mm.kernel.g.aAi();
              if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
              {
                u.g(al.this.gte, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
                return;
              }
            }
            try
            {
              paramAnonymousView = new com.tencent.mm.ui.widget.a.e(al.this.gte, 1, false);
              paramAnonymousView.HLX = new o.f()
              {
                public final void onCreateMMMenu(m paramAnonymous2m)
                {
                  AppMethodBeat.i(97988);
                  if (!ac.jPB) {
                    paramAnonymous2m.d(0, al.this.gte.getString(2131755822));
                  }
                  paramAnonymous2m.d(1, al.this.gte.getString(2131755831));
                  AppMethodBeat.o(97988);
                }
              };
              paramAnonymousView.HLY = new o.g()
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
                    paramAnonymous2MenuItem = al.this;
                    paramAnonymous2MenuItem.Zy(1);
                    long l = cl.aWz();
                    com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(l) });
                    Object localObject1 = new SightParams(2, 0);
                    o.bhi();
                    Object localObject2 = com.tencent.mm.plugin.mmsight.d.aFj(o.getAccVideoPath());
                    localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.mmsight.d.aFl((String)localObject2), ((SightParams)localObject1).irT, ((SightParams)localObject1).irT.duration * 1000, 2);
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYO, false)) {
                      ((RecordConfigProvider)localObject1).remuxType = 2;
                    }
                    localObject2 = new VideoCaptureReportInfo();
                    ((VideoCaptureReportInfo)localObject2).sQn = 7;
                    ((RecordConfigProvider)localObject1).BOE = ((VideoCaptureReportInfo)localObject2);
                    localObject2 = new al.9(paramAnonymous2MenuItem);
                    CaptureDataManager.BOb.BOa = ((CaptureDataManager.b)localObject2);
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYM, true))
                    {
                      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                      com.tencent.mm.plugin.recordvideo.jumper.a.a(paramAnonymous2MenuItem.gte, 11, 2130772161, 2130772162, (RecordConfigProvider)localObject1);
                      AppMethodBeat.o(97989);
                      return;
                    }
                    localObject1 = new Intent();
                    com.tencent.mm.pluginsdk.ui.tools.s.a(paramAnonymous2MenuItem.gte, 11, (Intent)localObject1, 2, 0);
                    AppMethodBeat.o(97989);
                    return;
                    paramAnonymous2MenuItem = al.this.gte.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
                    l = cl.aWz();
                    com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(l) });
                    if (!paramAnonymous2MenuItem.equalsIgnoreCase("0")) {
                      break;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.s.aY(al.this.gte);
                    al.this.Zy(2);
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.baZ().bbc().duration);
                  boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZB, false);
                  if ((com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ogd, 0) == 1) || (bool2))
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
                    com.tencent.mm.pluginsdk.ui.tools.s.a(al.this.gte, 9, 9, 4, 3, paramAnonymous2MenuItem);
                    break;
                    paramAnonymous2Int = 0;
                    break label474;
                    label515:
                    bool1 = false;
                  }
                }
              };
              paramAnonymousView.dGm();
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
                if (al.this.Etf.M(localObject[0], localObject[1], j, i))
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(97990);
                  return;
                }
                if (!com.tencent.mm.vfs.s.YS(al.this.videoPath))
                {
                  Log.i("MicroMsg.SightWidget", "click videopath is not exist " + al.this.videoPath);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(97990);
                  return;
                }
                paramAnonymousView = new Intent(al.this.gte, SnsOnlineVideoActivity.class);
                paramAnonymousView.putExtra("intent_videopath", al.this.videoPath);
                paramAnonymousView.putExtra("intent_thumbpath", al.this.thumbPath);
                paramAnonymousView.putExtra("intent_isad", false);
                paramAnonymousView.putExtra("intent_ispreview", true);
                paramAnonymousView.putExtra("KBlockAdd", al.this.Etd);
                paramAnonymousView.putExtra("sns_video_scene", 6);
                paramAnonymousView.putExtra("img_gallery_left", localObject[0]);
                paramAnonymousView.putExtra("img_gallery_top", localObject[1]);
                paramAnonymousView.putExtra("img_gallery_width", j);
                paramAnonymousView.putExtra("img_gallery_height", i);
                al.this.gte.startActivityForResult(paramAnonymousView, 12);
                al.this.gte.overridePendingTransition(0, 0);
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
        Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + com.tencent.mm.vfs.s.boW(this.videoPath) + " " + com.tencent.mm.vfs.s.boW(this.thumbPath));
        if (com.tencent.mm.vfs.s.YS(this.videoPath)) {
          Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[] { this.videoPath, this.md5 });
        }
        if (this.Etg != null)
        {
          localObject = com.tencent.mm.plugin.sns.k.e.DUQ;
          locali = this.Etg;
          i = locali.optInt("page");
          str = locali.optString("from");
        }
      }
      try
      {
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVG.erY = Long.parseLong(str);
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVG.eMr = i;
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVG.eMs = locali.optInt("isPreviewExit");
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVG.eMt = locali.optInt("isPreviewBlack");
        this.Etg = null;
        localObject = this.sc;
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
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(98006);
    if (this.gtM != null) {
      this.gtM.dismiss();
    }
    EventCenter.instance.removeListener(this.tOh);
    if (com.tencent.mm.plugin.sns.data.r.M(this.EsR)) {
      this.EsR.recycle();
    }
    com.tencent.mm.plugin.sns.ui.f.a locala = this.Etf;
    Log.i("MicroMsg.SnsFakeVLogHelper", "release");
    com.tencent.mm.plugin.recordvideo.background.a locala1 = com.tencent.mm.plugin.recordvideo.background.a.BKb;
    com.tencent.mm.plugin.recordvideo.background.a.b(7, locala);
    vl(false);
    AppMethodBeat.o(98006);
    return false;
  }
  
  final void ffZ()
  {
    AppMethodBeat.i(98008);
    if ((this.Etc != null) && (!this.Etc.isRecycled()))
    {
      this.EsO.setImageBitmap(this.Etc);
      this.EsO.im(((Integer)this.Etb.first).intValue(), ((Integer)this.Etb.second).intValue());
    }
    AppMethodBeat.o(98008);
  }
  
  final void fga()
  {
    AppMethodBeat.i(98009);
    this.EsP.setVisibility(8);
    this.EsO.Dnr.clear();
    this.EsO.im(com.tencent.mm.cb.a.fromDPToPix(this.gte, 100), com.tencent.mm.cb.a.fromDPToPix(this.gte, 100));
    this.EsO.setBackgroundResource(2131101156);
    this.EsO.setImageResource(2131689539);
    this.EsO.setContentDescription(this.EsO.getContext().getString(2131765996));
    int i = com.tencent.mm.cb.a.fromDPToPix(this.gte, 100) * 35 / 100;
    this.EsO.setPadding(i, i, i, i);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZk, true))
    {
      c localc = c.Cic;
      c.aLG(this.videoPath);
      localc = c.Cic;
      c.aLG(this.thumbPath);
    }
    AppMethodBeat.o(98009);
  }
  
  public final boolean fgb()
  {
    if (this.EsS != null) {
      return this.EsS.Mrn;
    }
    return false;
  }
  
  /* Error */
  public final boolean k(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1227
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
    //   50: ldc_w 1229
    //   53: iconst_0
    //   54: invokevirtual 348	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   57: putfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   60: aload_0
    //   61: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   64: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   67: ldc_w 429
    //   70: aload_0
    //   71: getfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   74: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   77: pop
    //   78: aload_0
    //   79: getfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   82: ifeq +59 -> 141
    //   85: aload_0
    //   86: getfield 217	com/tencent/mm/plugin/sns/ui/al:Etf	Lcom/tencent/mm/plugin/sns/ui/f/a;
    //   89: astore_2
    //   90: ldc_w 739
    //   93: ldc_w 1231
    //   96: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: getstatic 833	com/tencent/mm/plugin/recordvideo/background/a:BKb	Lcom/tencent/mm/plugin/recordvideo/background/a;
    //   102: astore 4
    //   104: bipush 7
    //   106: aload_2
    //   107: invokestatic 1142	com/tencent/mm/plugin/recordvideo/background/a:b	(ILcom/tencent/mm/plugin/recordvideo/background/b;)V
    //   110: aload_2
    //   111: getfield 1234	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   114: invokestatic 995	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +15 -> 132
    //   120: getstatic 871	com/tencent/mm/plugin/recordvideo/background/e:BKp	Lcom/tencent/mm/plugin/recordvideo/background/e;
    //   123: astore 4
    //   125: aload_2
    //   126: getfield 1234	com/tencent/mm/plugin/sns/ui/f/a:taskId	Ljava/lang/String;
    //   129: invokestatic 1237	com/tencent/mm/plugin/recordvideo/background/e:aLh	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual 1239	com/tencent/mm/plugin/sns/ui/al:fga	()V
    //   136: aload_0
    //   137: iconst_1
    //   138: invokespecial 1144	com/tencent/mm/plugin/sns/ui/al:vl	(Z)V
    //   141: ldc_w 1227
    //   144: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_2
    //   150: ldc_w 1241
    //   153: invokevirtual 1244	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   156: checkcast 1246	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull -127 -> 36
    //   166: aload 4
    //   168: getfield 1249	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsy	Z
    //   171: ifne +131 -> 302
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   179: aload_0
    //   180: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   183: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   186: ldc_w 429
    //   189: aload_0
    //   190: getfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   193: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   196: pop
    //   197: aload_0
    //   198: aload 4
    //   200: getfield 1252	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsA	Ljava/lang/String;
    //   203: putfield 139	com/tencent/mm/plugin/sns/ui/al:videoPath	Ljava/lang/String;
    //   206: aload_0
    //   207: aload 4
    //   209: getfield 1255	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsB	Ljava/lang/String;
    //   212: putfield 137	com/tencent/mm/plugin/sns/ui/al:thumbPath	Ljava/lang/String;
    //   215: aload 4
    //   217: getfield 1258	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsD	Ljava/lang/String;
    //   220: invokestatic 632	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   223: ifne +64 -> 287
    //   226: aload_0
    //   227: aload 4
    //   229: getfield 1258	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsD	Ljava/lang/String;
    //   232: putfield 141	com/tencent/mm/plugin/sns/ui/al:md5	Ljava/lang/String;
    //   235: aload_0
    //   236: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   239: instanceof 509
    //   242: ifeq +37 -> 279
    //   245: aload_0
    //   246: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   249: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   252: aload_0
    //   253: getfield 139	com/tencent/mm/plugin/sns/ui/al:videoPath	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 137	com/tencent/mm/plugin/sns/ui/al:thumbPath	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 141	com/tencent/mm/plugin/sns/ui/al:md5	Ljava/lang/String;
    //   264: aconst_null
    //   265: iconst_1
    //   266: invokevirtual 1261	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   269: aload_0
    //   270: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   273: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   276: invokevirtual 1264	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   279: ldc_w 1227
    //   282: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_1
    //   286: ireturn
    //   287: aload_0
    //   288: aload 4
    //   290: getfield 1252	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsA	Ljava/lang/String;
    //   293: invokestatic 929	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 141	com/tencent/mm/plugin/sns/ui/al:md5	Ljava/lang/String;
    //   299: goto -64 -> 235
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   307: aload_0
    //   308: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   311: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   314: ldc_w 429
    //   317: aload_0
    //   318: getfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   321: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   324: pop
    //   325: aload_2
    //   326: ldc_w 1266
    //   329: iconst_0
    //   330: invokevirtual 720	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   333: istore_1
    //   334: aload 4
    //   336: getfield 1269	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsG	Ljava/lang/String;
    //   339: astore_2
    //   340: aload_0
    //   341: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   344: instanceof 509
    //   347: ifeq +32 -> 379
    //   350: aload_0
    //   351: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   354: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   357: aload_2
    //   358: iconst_1
    //   359: iload_1
    //   360: aconst_null
    //   361: aconst_null
    //   362: aload_0
    //   363: getfield 611	com/tencent/mm/plugin/sns/ui/al:EpG	I
    //   366: invokevirtual 1272	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   369: aload_0
    //   370: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   373: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   376: invokevirtual 1264	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   379: ldc_w 1227
    //   382: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: iconst_1
    //   386: ireturn
    //   387: aload_2
    //   388: ldc_w 743
    //   391: invokevirtual 747	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   394: astore 4
    //   396: aload 4
    //   398: ifnull +131 -> 529
    //   401: aload 4
    //   403: ldc_w 749
    //   406: invokevirtual 755	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   409: ifnull +120 -> 529
    //   412: aload 4
    //   414: ldc_w 757
    //   417: invokevirtual 755	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   420: ifnull +109 -> 529
    //   423: ldc 235
    //   425: ldc_w 1274
    //   428: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   435: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   438: invokevirtual 1278	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   441: invokevirtual 1279	android/os/Bundle:clear	()V
    //   444: aload_0
    //   445: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   448: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   451: ldc_w 712
    //   454: iconst_0
    //   455: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   463: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   466: ldc_w 1281
    //   469: iconst_1
    //   470: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   478: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   481: ldc_w 1283
    //   484: bipush 14
    //   486: invokevirtual 1286	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   489: pop
    //   490: aload_0
    //   491: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   494: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   497: ldc_w 743
    //   500: aload_2
    //   501: ldc_w 743
    //   504: invokevirtual 747	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   507: invokevirtual 1289	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   510: pop
    //   511: aload_0
    //   512: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   515: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   518: invokevirtual 1264	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   521: ldc_w 1227
    //   524: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: iconst_1
    //   528: ireturn
    //   529: aload_2
    //   530: ldc_w 1291
    //   533: invokevirtual 1295	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   536: astore 4
    //   538: aload 4
    //   540: ifnull +11 -> 551
    //   543: aload 4
    //   545: invokevirtual 1300	java/util/ArrayList:size	()I
    //   548: ifgt +16 -> 564
    //   551: aload_2
    //   552: ldc_w 1302
    //   555: invokevirtual 696	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   558: invokestatic 632	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   561: ifne +403 -> 964
    //   564: aload_0
    //   565: iconst_0
    //   566: putfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   569: aload_0
    //   570: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   573: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   576: ldc_w 429
    //   579: aload_0
    //   580: getfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   583: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   586: pop
    //   587: aload 4
    //   589: ifnull +124 -> 713
    //   592: aload 4
    //   594: invokevirtual 1300	java/util/ArrayList:size	()I
    //   597: ifle +116 -> 713
    //   600: aload 4
    //   602: iconst_0
    //   603: invokevirtual 1305	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   606: checkcast 291	java/lang/String
    //   609: astore 4
    //   611: aload_2
    //   612: ldc_w 1307
    //   615: invokevirtual 696	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   618: astore 5
    //   620: aload 5
    //   622: invokestatic 632	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   625: ifne +14 -> 639
    //   628: aload 5
    //   630: astore_2
    //   631: aload 5
    //   633: invokestatic 518	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   636: ifne +181 -> 817
    //   639: new 900	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   646: invokestatic 1311	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   649: invokevirtual 907	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 4
    //   654: invokestatic 929	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   657: invokevirtual 907	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 916	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: astore_2
    //   664: new 168	com/tencent/mm/compatible/i/d
    //   667: dup
    //   668: invokespecial 169	com/tencent/mm/compatible/i/d:<init>	()V
    //   671: astore 5
    //   673: aload 5
    //   675: aload 4
    //   677: invokevirtual 1316	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   680: aload 5
    //   682: lconst_0
    //   683: invokevirtual 1320	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   686: astore 6
    //   688: aload 6
    //   690: ifnonnull +35 -> 725
    //   693: ldc 235
    //   695: ldc_w 1322
    //   698: invokestatic 243	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload 5
    //   703: invokevirtual 1324	android/media/MediaMetadataRetriever:release	()V
    //   706: goto -670 -> 36
    //   709: astore_2
    //   710: goto -674 -> 36
    //   713: aload_2
    //   714: ldc_w 1302
    //   717: invokevirtual 696	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   720: astore 4
    //   722: goto -111 -> 611
    //   725: ldc 235
    //   727: ldc_w 1326
    //   730: iconst_2
    //   731: anewarray 4	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: aload 6
    //   738: invokevirtual 1025	android/graphics/Bitmap:getWidth	()I
    //   741: invokestatic 1010	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: aload 6
    //   749: invokevirtual 1022	android/graphics/Bitmap:getHeight	()I
    //   752: invokestatic 1010	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: invokestatic 737	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: aload 6
    //   761: bipush 80
    //   763: getstatic 1332	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   766: aload_2
    //   767: iconst_1
    //   768: invokestatic 1336	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   771: pop
    //   772: aload_2
    //   773: invokestatic 1340	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   776: astore 6
    //   778: ldc 235
    //   780: ldc_w 1342
    //   783: iconst_2
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload 6
    //   791: getfield 1347	android/graphics/BitmapFactory$Options:outWidth	I
    //   794: invokestatic 1010	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: aastore
    //   798: dup
    //   799: iconst_1
    //   800: aload 6
    //   802: getfield 1350	android/graphics/BitmapFactory$Options:outHeight	I
    //   805: invokestatic 1010	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: aastore
    //   809: invokestatic 737	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: aload 5
    //   814: invokevirtual 1324	android/media/MediaMetadataRetriever:release	()V
    //   817: aload_0
    //   818: aload 4
    //   820: invokestatic 929	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   823: putfield 141	com/tencent/mm/plugin/sns/ui/al:md5	Ljava/lang/String;
    //   826: ldc 235
    //   828: ldc_w 1352
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
    //   848: invokestatic 1087	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   851: invokestatic 1355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   854: aastore
    //   855: dup
    //   856: iconst_3
    //   857: aload_2
    //   858: invokestatic 1087	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   861: invokestatic 1355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   864: aastore
    //   865: invokestatic 737	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   868: aload_0
    //   869: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   872: instanceof 509
    //   875: ifeq +32 -> 907
    //   878: aload_0
    //   879: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   882: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   885: aload 4
    //   887: aload_2
    //   888: aload_0
    //   889: getfield 141	com/tencent/mm/plugin/sns/ui/al:md5	Ljava/lang/String;
    //   892: aconst_null
    //   893: iconst_0
    //   894: invokevirtual 1261	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   897: aload_0
    //   898: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   901: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   904: invokevirtual 1264	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   907: ldc_w 1227
    //   910: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   913: iconst_1
    //   914: ireturn
    //   915: astore 6
    //   917: ldc 235
    //   919: ldc_w 1357
    //   922: iconst_1
    //   923: anewarray 4	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: aload 6
    //   930: invokevirtual 880	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   933: aastore
    //   934: invokestatic 802	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: aload 5
    //   939: invokevirtual 1324	android/media/MediaMetadataRetriever:release	()V
    //   942: goto -125 -> 817
    //   945: astore 5
    //   947: goto -130 -> 817
    //   950: astore_2
    //   951: aload 5
    //   953: invokevirtual 1324	android/media/MediaMetadataRetriever:release	()V
    //   956: ldc_w 1227
    //   959: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   962: aload_2
    //   963: athrow
    //   964: aload_0
    //   965: iconst_1
    //   966: putfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   969: aload_0
    //   970: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   973: invokevirtual 340	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   976: ldc_w 429
    //   979: aload_0
    //   980: getfield 164	com/tencent/mm/plugin/sns/ui/al:EsV	Z
    //   983: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   986: pop
    //   987: aload_2
    //   988: ldc_w 1359
    //   991: invokevirtual 1295	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   994: astore 4
    //   996: aload 4
    //   998: ifnull +11 -> 1009
    //   1001: aload 4
    //   1003: invokevirtual 1300	java/util/ArrayList:size	()I
    //   1006: ifne +19 -> 1025
    //   1009: ldc 235
    //   1011: ldc_w 1361
    //   1014: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1017: ldc_w 1227
    //   1020: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1023: iconst_0
    //   1024: ireturn
    //   1025: new 1297	java/util/ArrayList
    //   1028: dup
    //   1029: invokespecial 1362	java/util/ArrayList:<init>	()V
    //   1032: astore 5
    //   1034: aload 4
    //   1036: invokevirtual 1363	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1039: astore 6
    //   1041: aload 6
    //   1043: invokeinterface 545 1 0
    //   1048: ifeq +76 -> 1124
    //   1051: aload 6
    //   1053: invokeinterface 549 1 0
    //   1058: checkcast 291	java/lang/String
    //   1061: astore 7
    //   1063: aload 7
    //   1065: invokestatic 1369	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1068: invokevirtual 1373	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1071: astore 8
    //   1073: aload 8
    //   1075: ifnull -34 -> 1041
    //   1078: aload 5
    //   1080: ldc_w 1375
    //   1083: iconst_3
    //   1084: anewarray 4	java/lang/Object
    //   1087: dup
    //   1088: iconst_0
    //   1089: aload 7
    //   1091: aastore
    //   1092: dup
    //   1093: iconst_1
    //   1094: aload 8
    //   1096: getfield 1381	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1099: invokestatic 1386	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1102: aastore
    //   1103: dup
    //   1104: iconst_2
    //   1105: aload 8
    //   1107: getfield 1389	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1110: invokestatic 1386	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1113: aastore
    //   1114: invokestatic 1393	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1117: invokevirtual 1394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1120: pop
    //   1121: goto -80 -> 1041
    //   1124: aload_2
    //   1125: ldc_w 1396
    //   1128: iconst_0
    //   1129: invokevirtual 348	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1132: istore_3
    //   1133: aload_2
    //   1134: ldc_w 1266
    //   1137: iconst_0
    //   1138: invokevirtual 720	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1141: istore_1
    //   1142: aload_0
    //   1143: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1146: instanceof 509
    //   1149: ifeq -1113 -> 36
    //   1152: aload_0
    //   1153: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1156: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1159: aconst_null
    //   1160: iload_3
    //   1161: iload_1
    //   1162: aload 4
    //   1164: aload 5
    //   1166: aload_0
    //   1167: getfield 611	com/tencent/mm/plugin/sns/ui/al:EpG	I
    //   1170: invokevirtual 1272	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;I)V
    //   1173: aload_0
    //   1174: getfield 210	com/tencent/mm/plugin/sns/ui/al:gte	Lcom/tencent/mm/ui/MMActivity;
    //   1177: checkcast 509	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1180: invokevirtual 1264	com/tencent/mm/plugin/sns/ui/SnsUploadUI:fjO	()V
    //   1183: goto -1147 -> 36
    //   1186: astore 5
    //   1188: goto -371 -> 817
    //   1191: astore 4
    //   1193: goto -237 -> 956
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1196	0	this	al
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.al
 * JD-Core Version:    0.7.0.1
 */