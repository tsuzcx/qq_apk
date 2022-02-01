package com.tencent.mm.plugin.recordvideo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.f.b.a.aw;
import com.tencent.mm.f.b.a.km;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.f.b.a.lz;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.activity.a.b.c;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.d.g;
import com.tencent.mm.plugin.recordvideo.e.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "isLargeScreen", "", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "root", "Landroid/view/ViewGroup;", "uiRouter", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "checkScreenSize", "", "finish", "finishWithCancel", "getForceOrientation", "", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setWindowStyle", "Companion", "plugin-recordvideo_release"})
public class MMRecordUI
  extends MMActivity
{
  public static final a HFE;
  private RecordConfigProvider ALV;
  private com.tencent.mm.plugin.recordvideo.a.b HFA;
  private com.tencent.mm.plugin.recordvideo.activity.a.a HFB;
  private com.tencent.mm.plugin.recordvideo.activity.a.b HFC;
  private boolean HFD;
  private ViewGroup kiF;
  
  static
  {
    AppMethodBeat.i(75063);
    HFE = new a((byte)0);
    AppMethodBeat.o(75063);
  }
  
  public MMRecordUI()
  {
    AppMethodBeat.i(75062);
    this.HFB = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    AppMethodBeat.o(75062);
  }
  
  private final void fuJ()
  {
    AppMethodBeat.i(75054);
    if (ar.hIF())
    {
      localObject = this.ALV;
      if ((localObject != null) && (((RecordConfigProvider)localObject).HLo == true))
      {
        localObject = getContext();
        p.j(localObject, "context");
        localObject = ((AppCompatActivity)localObject).getWindow();
        p.j(localObject, "context.window");
        ((Window)localObject).getDecorView().setBackgroundColor(com.tencent.mm.ci.a.w((Context)getContext(), com.tencent.mm.plugin.recordvideo.b.b.black));
        int i = ax.au((Context)getContext()).y;
        int j = (int)(i * 0.5625F);
        localObject = this.kiF;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject != null)
          {
            ((ViewGroup.LayoutParams)localObject).width = j;
            ((ViewGroup.LayoutParams)localObject).height = i;
            if (!(localObject instanceof LinearLayout.LayoutParams)) {
              break label157;
            }
            ((LinearLayout.LayoutParams)localObject).gravity = 17;
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.recordvideo.model.a.HLt;
          com.tencent.mm.plugin.recordvideo.model.a.acj(j);
          localObject = com.tencent.mm.plugin.recordvideo.model.a.HLt;
          com.tencent.mm.plugin.recordvideo.model.a.Fd(i);
          AppMethodBeat.o(75054);
          return;
          label157:
          if ((localObject instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams)localObject).gravity = 17;
          } else if ((localObject instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject).addRule(13);
          }
        }
      }
    }
    Object localObject = this.kiF;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
    }
    localObject = this.kiF;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
    localObject = com.tencent.mm.plugin.recordvideo.model.a.HLt;
    com.tencent.mm.plugin.recordvideo.model.a.acj(ax.au((Context)getContext()).x);
    localObject = com.tencent.mm.plugin.recordvideo.model.a.HLt;
    com.tencent.mm.plugin.recordvideo.model.a.Fd(ax.au((Context)getContext()).y);
    AppMethodBeat.o(75054);
  }
  
  public void finish()
  {
    AppMethodBeat.i(75061);
    Log.i("MicroMsg.MMRecordUI", "finish  " + hashCode());
    super.finish();
    Object localObject = com.tencent.mm.plugin.recordvideo.e.f.Ifk;
    com.tencent.mm.plugin.recordvideo.e.f.fzy();
    CaptureDataManager.HKJ.a(null);
    localObject = com.tencent.mm.plugin.recordvideo.b.h.HKf;
    com.tencent.mm.plugin.recordvideo.b.h.unInit();
    localObject = com.tencent.mm.plugin.recordvideo.background.f.HGG;
    com.tencent.mm.plugin.recordvideo.background.f.fvc();
    localObject = this.HFC;
    if (localObject != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "finish " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG);
      ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).isFinishing = true;
      MMHandlerThread.postToMainThread((Runnable)new com.tencent.mm.plugin.recordvideo.activity.a.b.b((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject));
    }
    if ((getIntent() != null) && (getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1) != -1)) {
      overridePendingTransition(-1, getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1));
    }
    AppMethodBeat.o(75061);
  }
  
  public final void fuK()
  {
    AppMethodBeat.i(216650);
    Object localObject = new Intent();
    com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    ((Intent)localObject).putExtra("report", (Parcelable)com.tencent.mm.plugin.recordvideo.d.c.fxp());
    setResult(0, (Intent)localObject);
    localObject = g.HUM;
    g.aJ(2, 3L);
    finish();
    AppMethodBeat.o(216650);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.record_ui_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75060);
    Log.i("MicroMsg.MMRecordUI", "requestCode : " + paramInt1 + " resultCode:" + paramInt2 + "  " + hashCode());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      localObject = this.HFA;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.a.b)localObject).aw((Context)this, paramIntent);
        AppMethodBeat.o(75060);
        return;
      }
      AppMethodBeat.o(75060);
      return;
    }
    Object localObject = this.HFC;
    if (localObject != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "onActivityResult " + paramInt1 + ' ' + paramInt2 + ' ' + paramIntent);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG;
      if (localObject != null)
      {
        ((BasePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(75060);
        return;
      }
      AppMethodBeat.o(75060);
      return;
    }
    AppMethodBeat.o(75060);
  }
  
  public void onBackPressed()
  {
    boolean bool = false;
    AppMethodBeat.i(75059);
    Log.i("MicroMsg.MMRecordUI", "onBackPressed  " + hashCode());
    Object localObject = this.HFC;
    RecordConfigProvider localRecordConfigProvider;
    if (localObject != null)
    {
      localRecordConfigProvider = this.ALV;
      if (localRecordConfigProvider == null) {
        break label126;
      }
    }
    label126:
    for (int i = localRecordConfigProvider.scene;; i = 0)
    {
      Log.i("MicroMsg.RecordUIRouter", "onBackPressed ".concat(String.valueOf(i)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG;
      if (localObject != null) {
        bool = ((BasePluginLayout)localObject).onBackPress();
      }
      if (!bool)
      {
        localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.acr(14);
        localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.act(i);
      }
      if (bool != true) {
        fuK();
      }
      AppMethodBeat.o(75059);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(75055);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (((paramConfiguration.screenLayout & 0x3) != 0) && ((paramConfiguration.screenLayout & 0x10) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.HFD)
      {
        this.HFD = bool;
        fuJ();
      }
      AppMethodBeat.o(75055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l2 = 0L;
    AppMethodBeat.i(75053);
    Log.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate  " + hashCode());
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ue(true);
    getWindow().setFormat(-3);
    setLightNavigationbarIcon();
    this.kiF = ((ViewGroup)findViewById(b.e.record_ui_root));
    paramBundle = com.tencent.mm.plugin.recordvideo.e.f.Ifk;
    com.tencent.mm.plugin.recordvideo.e.f.fzy();
    Object localObject1 = (RecordConfigProvider)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    int i = getIntent().getIntExtra("KEY_PARAMS_TO_WHERE", -1);
    int j = getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1);
    label192:
    int k;
    if (localObject1 != null)
    {
      paramBundle = Integer.valueOf(((RecordConfigProvider)localObject1).scene);
      switch (j)
      {
      default: 
        Log.i("MicroMsg.MMRecordUI", "onCreate configProvider : " + localObject1 + "    toWhere:" + i);
        localObject1 = new o(localObject1, Integer.valueOf(i));
        paramBundle = (RecordConfigProvider)((o)localObject1).Mx;
        k = ((Number)((o)localObject1).My).intValue();
        if (paramBundle == null) {
          i = 2000;
        }
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MMRecordUI", " checkConfigProvider:  ".concat(String.valueOf(i)));
      if (i == 999) {
        break label434;
      }
      setResult(i);
      finish();
      AppMethodBeat.o(75053);
      return;
      paramBundle = null;
      break;
      if (paramBundle == null) {}
      for (;;)
      {
        CaptureDataManager.HKJ.a((CaptureDataManager.b)new com.tencent.mm.plugin.recordvideo.a.a());
        break;
        if (paramBundle.intValue() == 11) {
          break;
        }
      }
      this.HFA = new com.tencent.mm.plugin.recordvideo.a.b();
      CaptureDataManager.HKJ.a((CaptureDataManager.b)this.HFA);
      break label192;
      if (k == 2)
      {
        j = com.tencent.mm.plugin.recordvideo.activity.a.a.aVE(paramBundle.HLf);
        i = j;
        if (j == 999)
        {
          localObject1 = paramBundle.HLf;
          p.j(localObject1, "configProvider.inputVideoPath");
          j = com.tencent.mm.plugin.recordvideo.activity.a.a.aVF((String)localObject1);
          i = j;
          if (j != 999) {}
        }
      }
      else
      {
        i = 999;
      }
    }
    label434:
    localObject1 = (Context)this;
    Object localObject2 = this.kiF;
    if (localObject2 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75053);
      throw paramBundle;
    }
    if (paramBundle == null) {
      p.iCn();
    }
    this.HFC = new com.tencent.mm.plugin.recordvideo.activity.a.b((Context)localObject1, (ViewGroup)localObject2, paramBundle, k);
    this.ALV = paramBundle;
    localObject1 = e.Ife;
    e.j(paramBundle);
    localObject1 = getResources();
    p.j(localObject1, "resources");
    boolean bool;
    long l3;
    if (((Resources)localObject1).getConfiguration() != null)
    {
      localObject1 = getResources();
      p.j(localObject1, "resources");
      if ((((Resources)localObject1).getConfiguration().screenLayout & 0x3) != 0)
      {
        localObject1 = getResources();
        p.j(localObject1, "resources");
        if ((((Resources)localObject1).getConfiguration().screenLayout & 0x10) != 0)
        {
          bool = true;
          this.HFD = bool;
          fuJ();
          localObject1 = this.HFC;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).a(k, com.tencent.mm.plugin.recordvideo.activity.a.a.d(paramBundle));
          }
          Log.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate finish");
          CaptureDataManager.HKJ.fvQ();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.a(paramBundle.HLk);
          l1 = NetStatusUtil.getIOSNetType((Context)getContext());
          l3 = System.currentTimeMillis();
          localObject1 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
          com.tencent.mm.plugin.recordvideo.e.d.fzt();
          localObject1 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvW, 14);
          Log.i("MicroMsg.MediaFileUtil", "deleteExpiredFile " + i + " days");
          if (i >= 0)
          {
            long l4 = com.tencent.mm.plugin.music.cache.b.fny.longValue() * i;
            p.j(s.bqA(), "SubCoreVideo.getCore()");
            localObject1 = u.bBT(s.getAccVideoPath());
            if (localObject1 == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.recordvideo.e.d.p((String)localObject1, "videovsg", l4);
            p.j(s.bqA(), "SubCoreVideo.getCore()");
            localObject1 = s.getAccVideoPath();
            p.j(localObject1, "SubCoreVideo.getCore().accVideoPath");
            com.tencent.mm.plugin.recordvideo.e.d.p((String)localObject1, "vsg", l4);
            p.j(s.bqA(), "SubCoreVideo.getCore()");
            localObject1 = s.getAccVideoPath();
            p.j(localObject1, "SubCoreVideo.getCore().accVideoPath");
            com.tencent.mm.plugin.recordvideo.e.d.p((String)localObject1, "send", l4);
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_NET_TYPE_INT", Long.valueOf(l1));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_TIME_MS_LONG", Long.valueOf(l3));
          localObject1 = g.HUM;
          localObject1 = paramBundle.HLk;
          if (localObject1 == null) {
            break label1215;
          }
          i = ((VideoCaptureReportInfo)localObject1).wwk;
          label895:
          g.acv(i);
          localObject1 = g.HUM;
          g.acu((int)l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxq().vw(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxq().Cd(String.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxq();
          localObject2 = paramBundle.HLk;
          if (localObject2 == null) {
            break label1220;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).uQm;
          label970:
          ((lo)localObject1).vx(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxq().vy(l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxq();
          localObject2 = paramBundle.HLk;
          if (localObject2 == null) {
            break label1226;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).HLs;
          label1020:
          ((lo)localObject1).vH(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fxr().wD(NetStatusUtil.getIOSNetType((Context)getContext()));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxr();
          localObject2 = new StringBuilder();
          com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
          p.j(localf, "MMKernel.storage()");
          ((lz)localObject1).Cw(localf.aHp().get(2).toString() + l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxr();
          localObject2 = paramBundle.HLk;
          if (localObject2 == null) {
            break label1232;
          }
        }
      }
    }
    label1215:
    label1220:
    label1226:
    label1232:
    for (long l1 = ((VideoCaptureReportInfo)localObject2).uQm;; l1 = 0L)
    {
      ((lz)localObject1).wE(l1);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.fxr().wF(l3);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.fxr();
      paramBundle = paramBundle.HLk;
      l1 = l2;
      if (paramBundle != null) {
        l1 = paramBundle.HLs;
      }
      ((lz)localObject1).wJ(l1);
      AppMethodBeat.o(75053);
      return;
      bool = false;
      break;
      i = 0;
      break label895;
      l1 = 0L;
      break label970;
      l1 = 0L;
      break label1020;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(75058);
    Log.i("MicroMsg.MMRecordUI", "MMRecordUI onDestroy " + hashCode());
    super.onDestroy();
    Object localObject1 = this.HFC;
    if (localObject1 != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "onDestroy " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).HFG);
      MMHandlerThread.postToMainThread((Runnable)new b.c((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1));
      if ((((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).HFG instanceof RecordPluginLayout))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      localObject1 = new aw();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.d.c.fxp();
      Object localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_NET_TYPE_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
      ((aw)localObject1).cK(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_FROM_SCENE_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
      ((aw)localObject1).cL(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ENTER_TIME_MS_LONG", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
      ((aw)localObject1).cM(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
      ((aw)localObject1).cN(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MEDIA_SOURCE_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
      ((aw)localObject1).cO(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MEDIA_TYPE_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
      ((aw)localObject1).cP(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_START_RECORD_MS_LONG", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
      ((aw)localObject1).cQ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
      ((aw)localObject1).cR(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ORIGIN_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
      ((aw)localObject1).cS(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ORIGIN_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
      ((aw)localObject1).cT(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((aw)localObject1).cU(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((aw)localObject1).cV(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
      ((aw)localObject1).cW(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_EMOJI_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
      ((aw)localObject1).cX(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_EMOJI_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
      ((aw)localObject1).cY(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_TEXT_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
      ((aw)localObject1).cZ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_TEXT_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
      ((aw)localObject1).da(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_DOODLE_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
      ((aw)localObject1).db(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_DOODLE_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
      ((aw)localObject1).dc(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_DOODLE_COLOR_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
      ((aw)localObject1).dd(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_MOSAIC_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
      ((aw)localObject1).de(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_BRUSH_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
      ((aw)localObject1).df(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_MOSAIC_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
      ((aw)localObject1).dg(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_CROP_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
      ((aw)localObject1).dh(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CROP_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
      ((aw)localObject1).dj(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CROP_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
      ((aw)localObject1).di(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ROTATE_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_ROTATE_INT,-1)");
      ((aw)localObject1).dk(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_MUSIC_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
      ((aw)localObject1).dl(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MUSIC_ID_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
      ((aw)localObject1).dm(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MUSIC_INDEX_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
      ((aw)localObject1).dn(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_SELECT_MUSIC_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
      ((aw)localObject1).jdMethod_do(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_SELECT_ORIGIN_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
      ((aw)localObject1).dp(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MUSIC_REQ_ID_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
      ((aw)localObject1).dq(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_SEARCH_MUSIC_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
      ((aw)localObject1).dr(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_VIDEO_CROP_COUNT_INT", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
      ((aw)localObject1).ds(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_VIDEO_CROP_DURATION_MS_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
      ((aw)localObject1).dt(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_AFTER_EDIT_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
      ((aw)localObject1).du(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_EDIT_PUBLISHID_INT", Long.valueOf(-1L));
      p.j(localObject3, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
      ((aw)localObject1).dv(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_IS_SHOW_WESEE_BTN", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_IS_SHOW_WESEE_BTN, 0)");
      ((aw)localObject1).dw(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_IS_CLICK_WESEE_BTN", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_IS_CLICK_WESEE_BTN, 0)");
      ((aw)localObject1).dx(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_IS_INSTALL_WESEE", Long.valueOf(0L));
      p.j(localObject3, "info.getReportValue(KEY_IS_INSTALL_WESEE, 0)");
      ((aw)localObject1).dy(((Number)localObject3).longValue());
      localObject2 = ((RecordMediaReportInfo)localObject2).x("KEY_WESEE_DIALOG_OPERATION", Long.valueOf(0L));
      p.j(localObject2, "info.getReportValue(KEY_WESEE_DIALOG_OPERATION, 0)");
      ((aw)localObject1).dz(((Number)localObject2).longValue());
      ((aw)localObject1).jt(com.tencent.mm.plugin.recordvideo.d.c.HUo.fxo());
      ((aw)localObject1).bpa();
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.e.f.Ifk;
    com.tencent.mm.plugin.recordvideo.e.f.fzy();
    if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
      ab.fax.YG().YF();
    }
    localObject1 = g.HUM;
    Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport");
    g.HUJ.Bp(g.fxz());
    if ((g.HUJ.amw() != 0L) && (g.HUK != 0L)) {
      g.HUJ.bpa();
    }
    g.HUK = 0L;
    com.tencent.mm.media.g.c.kVi.aUQ();
    AppMethodBeat.o(75058);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(75057);
    Log.i("MicroMsg.MMRecordUI", "MMRecordUI onPause  isFinishing  : " + isFinishing() + "  " + hashCode() + "  ");
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.cwA();
    if (isFinishing())
    {
      AppMethodBeat.o(75057);
      return;
    }
    Object localObject = this.HFC;
    if (localObject != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "onPause " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG;
      if (localObject != null)
      {
        ((BasePluginLayout)localObject).onPause();
        AppMethodBeat.o(75057);
        return;
      }
      AppMethodBeat.o(75057);
      return;
    }
    AppMethodBeat.o(75057);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(216653);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    Log.i("MicroMsg.MMRecordUI", "onRequestPermissionsResult, requestCode:".concat(String.valueOf(paramInt)));
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Object localObject = this.HFC;
    if (localObject != null)
    {
      p.k(paramArrayOfString, "permissions");
      p.k(paramArrayOfInt, "grantResults");
      Log.i("MicroMsg.RecordUIRouter", "onRequestPermissionsResult ".concat(String.valueOf(paramInt)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG;
      if (localObject != null)
      {
        ((BasePluginLayout)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(216653);
        return;
      }
      AppMethodBeat.o(216653);
      return;
    }
    AppMethodBeat.o(216653);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(75056);
    try
    {
      super.onResume();
      com.tencent.mm.plugin.ball.f.f.cwB();
      Object localObject = this.HFC;
      if (localObject != null)
      {
        Log.i("MicroMsg.RecordUIRouter", "onResume " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG);
        localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).HFG;
        if (localObject != null) {
          ((BasePluginLayout)localObject).onResume();
        }
      }
      Log.i("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode() + "  ");
      AppMethodBeat.o(75056);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode());
      Log.printErrStackTrace("MicroMsg.MMRecordUI", (Throwable)localException, "", new Object[0]);
      finish();
      AppMethodBeat.o(75056);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI$Companion;", "", "()V", "REQUEST_CODE_LABEL_SELECT", "", "REQUEST_CODE_LOCATION", "REQUEST_CODE_START", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI
 * JD-Core Version:    0.7.0.1
 */