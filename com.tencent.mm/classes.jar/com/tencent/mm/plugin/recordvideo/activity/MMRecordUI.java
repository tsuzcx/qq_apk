package com.tencent.mm.plugin.recordvideo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.activity.a.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.b.c;
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
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "isLargeScreen", "", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "root", "Landroid/view/ViewGroup;", "uiRouter", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "checkScreenSize", "", "finish", "finishWithCancel", "getForceOrientation", "", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setWindowStyle", "Companion", "plugin-recordvideo_release"})
public class MMRecordUI
  extends MMActivity
{
  public static final MMRecordUI.a BJu;
  private com.tencent.mm.plugin.recordvideo.a.b BJq;
  private com.tencent.mm.plugin.recordvideo.activity.a.a BJr;
  private com.tencent.mm.plugin.recordvideo.activity.a.b BJs;
  private boolean BJt;
  private ViewGroup hwr;
  private RecordConfigProvider wdm;
  
  static
  {
    AppMethodBeat.i(75063);
    BJu = new MMRecordUI.a((byte)0);
    AppMethodBeat.o(75063);
  }
  
  public MMRecordUI()
  {
    AppMethodBeat.i(75062);
    this.BJr = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    AppMethodBeat.o(75062);
  }
  
  private final void eIE()
  {
    AppMethodBeat.i(75054);
    if (com.tencent.mm.ui.ao.gJI())
    {
      localObject = this.wdm;
      if ((localObject != null) && (((RecordConfigProvider)localObject).BOI == true))
      {
        localObject = getContext();
        p.g(localObject, "context");
        localObject = ((AppCompatActivity)localObject).getWindow();
        p.g(localObject, "context.window");
        ((Window)localObject).getDecorView().setBackgroundColor(com.tencent.mm.cb.a.n((Context)getContext(), 2131100042));
        int i = au.az((Context)getContext()).y;
        int j = (int)(i * 0.5625F);
        localObject = this.hwr;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject != null)
          {
            ((ViewGroup.LayoutParams)localObject).width = j;
            ((ViewGroup.LayoutParams)localObject).height = i;
            if (!(localObject instanceof LinearLayout.LayoutParams)) {
              break label156;
            }
            ((LinearLayout.LayoutParams)localObject).gravity = 17;
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.recordvideo.model.a.BOO;
          com.tencent.mm.plugin.recordvideo.model.a.VA(j);
          localObject = com.tencent.mm.plugin.recordvideo.model.a.BOO;
          com.tencent.mm.plugin.recordvideo.model.a.BC(i);
          AppMethodBeat.o(75054);
          return;
          label156:
          if ((localObject instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams)localObject).gravity = 17;
          } else if ((localObject instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject).addRule(13);
          }
        }
      }
    }
    Object localObject = this.hwr;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
    }
    localObject = this.hwr;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
    localObject = com.tencent.mm.plugin.recordvideo.model.a.BOO;
    com.tencent.mm.plugin.recordvideo.model.a.VA(au.az((Context)getContext()).x);
    localObject = com.tencent.mm.plugin.recordvideo.model.a.BOO;
    com.tencent.mm.plugin.recordvideo.model.a.BC(au.az((Context)getContext()).y);
    AppMethodBeat.o(75054);
  }
  
  public final void eIF()
  {
    AppMethodBeat.i(237236);
    Object localObject = new Intent();
    com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    ((Intent)localObject).putExtra("report", (Parcelable)com.tencent.mm.plugin.recordvideo.d.c.eKW());
    setResult(0, (Intent)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.d.g.BXY;
    com.tencent.mm.plugin.recordvideo.d.g.ax(2, 3L);
    finish();
    AppMethodBeat.o(237236);
  }
  
  public void finish()
  {
    AppMethodBeat.i(75061);
    Log.i("MicroMsg.MMRecordUI", "finish  " + hashCode());
    super.finish();
    Object localObject = com.tencent.mm.plugin.recordvideo.e.e.Cit;
    com.tencent.mm.plugin.recordvideo.e.e.eMN();
    CaptureDataManager.BOb.a(null);
    localObject = com.tencent.mm.plugin.recordvideo.b.g.BNx;
    com.tencent.mm.plugin.recordvideo.b.g.unInit();
    localObject = com.tencent.mm.plugin.recordvideo.background.f.BKw;
    com.tencent.mm.plugin.recordvideo.background.f.eIY();
    localObject = this.BJs;
    if (localObject != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "finish " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw);
      ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).isFinishing = true;
      MMHandlerThread.postToMainThread((Runnable)new b.b((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject));
    }
    if ((getIntent() != null) && (getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1) != -1)) {
      overridePendingTransition(-1, getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1));
    }
    AppMethodBeat.o(75061);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496071;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75060);
    Log.i("MicroMsg.MMRecordUI", "requestCode : " + paramInt1 + " resultCode:" + paramInt2 + "  " + hashCode());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      localObject = this.BJq;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.a.b)localObject).an((Context)this, paramIntent);
        AppMethodBeat.o(75060);
        return;
      }
      AppMethodBeat.o(75060);
      return;
    }
    Object localObject = this.BJs;
    if (localObject != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "onActivityResult " + paramInt1 + ' ' + paramInt2 + ' ' + paramIntent);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw;
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
    Object localObject = this.BJs;
    RecordConfigProvider localRecordConfigProvider;
    if (localObject != null)
    {
      localRecordConfigProvider = this.wdm;
      if (localRecordConfigProvider == null) {
        break label126;
      }
    }
    label126:
    for (int i = localRecordConfigProvider.scene;; i = 0)
    {
      Log.i("MicroMsg.RecordUIRouter", "onBackPressed ".concat(String.valueOf(i)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw;
      if (localObject != null) {
        bool = ((BasePluginLayout)localObject).onBackPress();
      }
      if (!bool)
      {
        localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VI(14);
        localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VK(i);
      }
      if (bool != true) {
        eIF();
      }
      AppMethodBeat.o(75059);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(75055);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (((paramConfiguration.screenLayout & 0x3) != 0) && ((paramConfiguration.screenLayout & 0x10) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.BJt)
      {
        this.BJt = bool;
        eIE();
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
    com.tencent.mm.plugin.mmsight.d.rb(true);
    getWindow().setFormat(-3);
    setLightNavigationbarIcon();
    this.hwr = ((ViewGroup)findViewById(2131306746));
    paramBundle = com.tencent.mm.plugin.recordvideo.e.e.Cit;
    com.tencent.mm.plugin.recordvideo.e.e.eMN();
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
        localObject1 = new kotlin.o(localObject1, Integer.valueOf(i));
        paramBundle = (RecordConfigProvider)((kotlin.o)localObject1).first;
        k = ((Number)((kotlin.o)localObject1).second).intValue();
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
        CaptureDataManager.BOb.a((CaptureDataManager.b)new com.tencent.mm.plugin.recordvideo.a.a());
        break;
        if (paramBundle.intValue() == 11) {
          break;
        }
      }
      this.BJq = new com.tencent.mm.plugin.recordvideo.a.b();
      CaptureDataManager.BOb.a((CaptureDataManager.b)this.BJq);
      break label192;
      if (k == 2)
      {
        j = com.tencent.mm.plugin.recordvideo.activity.a.a.aLc(paramBundle.BOz);
        i = j;
        if (j == 999)
        {
          localObject1 = paramBundle.BOz;
          p.g(localObject1, "configProvider.inputVideoPath");
          j = com.tencent.mm.plugin.recordvideo.activity.a.a.aLd((String)localObject1);
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
    Object localObject2 = this.hwr;
    if (localObject2 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75053);
      throw paramBundle;
    }
    if (paramBundle == null) {
      p.hyc();
    }
    this.BJs = new com.tencent.mm.plugin.recordvideo.activity.a.b((Context)localObject1, (ViewGroup)localObject2, paramBundle, k);
    this.wdm = paramBundle;
    localObject1 = com.tencent.mm.plugin.recordvideo.e.d.Cin;
    com.tencent.mm.plugin.recordvideo.e.d.h(paramBundle);
    localObject1 = getResources();
    p.g(localObject1, "resources");
    boolean bool;
    long l3;
    if (((Resources)localObject1).getConfiguration() != null)
    {
      localObject1 = getResources();
      p.g(localObject1, "resources");
      if ((((Resources)localObject1).getConfiguration().screenLayout & 0x3) != 0)
      {
        localObject1 = getResources();
        p.g(localObject1, "resources");
        if ((((Resources)localObject1).getConfiguration().screenLayout & 0x10) != 0)
        {
          bool = true;
          this.BJt = bool;
          eIE();
          localObject1 = this.BJs;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).a(k, com.tencent.mm.plugin.recordvideo.activity.a.a.b(paramBundle));
          }
          Log.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate finish");
          CaptureDataManager.BOb.eJF();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.a(paramBundle.BOE);
          l1 = NetStatusUtil.getIOSNetType((Context)getContext());
          l3 = System.currentTimeMillis();
          localObject1 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
          com.tencent.mm.plugin.recordvideo.e.c.eMH();
          localObject1 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPL, 14);
          Log.i("MicroMsg.MediaFileUtil", "deleteExpiredFile " + i + " days");
          if (i >= 0)
          {
            long l4 = com.tencent.mm.plugin.music.cache.b.duQ.longValue() * i;
            p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
            localObject1 = s.boZ(com.tencent.mm.modelvideo.o.getAccVideoPath());
            if (localObject1 == null) {
              p.hyc();
            }
            com.tencent.mm.plugin.recordvideo.e.c.n((String)localObject1, "videovsg", l4);
            p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
            localObject1 = com.tencent.mm.modelvideo.o.getAccVideoPath();
            p.g(localObject1, "SubCoreVideo.getCore().accVideoPath");
            com.tencent.mm.plugin.recordvideo.e.c.n((String)localObject1, "vsg", l4);
            p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
            localObject1 = com.tencent.mm.modelvideo.o.getAccVideoPath();
            p.g(localObject1, "SubCoreVideo.getCore().accVideoPath");
            com.tencent.mm.plugin.recordvideo.e.c.n((String)localObject1, "send", l4);
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.x("KEY_NET_TYPE_INT", Long.valueOf(l1));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ENTER_TIME_MS_LONG", Long.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          localObject1 = paramBundle.BOE;
          if (localObject1 == null) {
            break label1215;
          }
          i = ((VideoCaptureReportInfo)localObject1).sQn;
          label895:
          com.tencent.mm.plugin.recordvideo.d.g.VM(i);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.VL((int)l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKX().ru(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKX().wC(String.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKX();
          localObject2 = paramBundle.BOE;
          if (localObject2 == null) {
            break label1220;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).rna;
          label970:
          ((jf)localObject1).rv(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKX().rw(l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKX();
          localObject2 = paramBundle.BOE;
          if (localObject2 == null) {
            break label1226;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).twG;
          label1020:
          ((jf)localObject1).rF(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKY().sB(NetStatusUtil.getIOSNetType((Context)getContext()));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKY();
          localObject2 = new StringBuilder();
          com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
          p.g(locale, "MMKernel.storage()");
          ((jq)localObject1).wV(locale.azQ().get(2).toString() + l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKY();
          localObject2 = paramBundle.BOE;
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
    for (long l1 = ((VideoCaptureReportInfo)localObject2).rna;; l1 = 0L)
    {
      ((jq)localObject1).sC(l1);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.eKY().sD(l3);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKY();
      paramBundle = paramBundle.BOE;
      l1 = l2;
      if (paramBundle != null) {
        l1 = paramBundle.twG;
      }
      ((jq)localObject1).sI(l1);
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
    Object localObject1 = this.BJs;
    if (localObject1 != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "onDestroy " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).BJw);
      MMHandlerThread.postToMainThread((Runnable)new b.c((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1));
      if ((((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).BJw instanceof RecordPluginLayout))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject1 = new com.tencent.mm.g.b.a.ao();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.d.c.eKW();
      Object localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_NET_TYPE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cf(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_FROM_SCENE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cg(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ENTER_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).ch(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_EXIT_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).ci(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_MEDIA_SOURCE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cj(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_MEDIA_TYPE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).ck(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_START_RECORD_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cl(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cm(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ORIGIN_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cn(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ORIGIN_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).co(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cp(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cq(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cr(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_EMOJI_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cs(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ADD_EMOJI_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).ct(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_TEXT_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cu(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ADD_TEXT_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cv(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_DOODLE_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cw(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ADD_DOODLE_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cx(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ADD_DOODLE_COLOR_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cy(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_MOSAIC_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cz(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_BRUSH_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cA(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ADD_MOSAIC_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cB(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_CROP_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cC(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CROP_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cE(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CROP_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cD(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_ROTATE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_ROTATE_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cF(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_MUSIC_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cG(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_MUSIC_ID_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cH(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_MUSIC_INDEX_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cI(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_SELECT_MUSIC_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cJ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_SELECT_ORIGIN_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cK(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_MUSIC_REQ_ID_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cL(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_SEARCH_MUSIC_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cM(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_CLICK_VIDEO_CROP_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cN(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_VIDEO_CROP_DURATION_MS_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cO(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_AFTER_EDIT_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cP(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_EDIT_PUBLISHID_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cQ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_IS_SHOW_WESEE_BTN", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_IS_SHOW_WESEE_BTN, 0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cR(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_IS_CLICK_WESEE_BTN", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_IS_CLICK_WESEE_BTN, 0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cS(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).y("KEY_IS_INSTALL_WESEE", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_IS_INSTALL_WESEE, 0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cT(((Number)localObject3).longValue());
      localObject2 = ((RecordMediaReportInfo)localObject2).y("KEY_WESEE_DIALOG_OPERATION", Long.valueOf(0L));
      p.g(localObject2, "info.getReportValue(KEY_WESEE_DIALOG_OPERATION, 0)");
      ((com.tencent.mm.g.b.a.ao)localObject1).cU(((Number)localObject2).longValue());
      ((com.tencent.mm.g.b.a.ao)localObject1).is(com.tencent.mm.plugin.recordvideo.d.c.BXA.eKV());
      ((com.tencent.mm.g.b.a.ao)localObject1).bfK();
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.e.e.Cit;
    com.tencent.mm.plugin.recordvideo.e.e.eMN();
    if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
      ab.diQ.Uo().Un();
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
    Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport");
    com.tencent.mm.plugin.recordvideo.d.g.BXV.vQ(com.tencent.mm.plugin.recordvideo.d.g.eLg());
    if ((com.tencent.mm.plugin.recordvideo.d.g.BXV.ahc() != 0L) && (com.tencent.mm.plugin.recordvideo.d.g.BXW != 0L)) {
      com.tencent.mm.plugin.recordvideo.d.g.BXV.bfK();
    }
    com.tencent.mm.plugin.recordvideo.d.g.BXW = 0L;
    com.tencent.mm.media.g.c.igu.aMA();
    AppMethodBeat.o(75058);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(75057);
    Log.i("MicroMsg.MMRecordUI", "MMRecordUI onPause  isFinishing  : " + isFinishing() + "  " + hashCode() + "  ");
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.cji();
    if (isFinishing())
    {
      AppMethodBeat.o(75057);
      return;
    }
    Object localObject = this.BJs;
    if (localObject != null)
    {
      Log.i("MicroMsg.RecordUIRouter", "onPause " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw;
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
    AppMethodBeat.i(237237);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    Log.i("MicroMsg.MMRecordUI", "onRequestPermissionsResult, requestCode:".concat(String.valueOf(paramInt)));
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Object localObject = this.BJs;
    if (localObject != null)
    {
      p.h(paramArrayOfString, "permissions");
      p.h(paramArrayOfInt, "grantResults");
      Log.i("MicroMsg.RecordUIRouter", "onRequestPermissionsResult ".concat(String.valueOf(paramInt)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw;
      if (localObject != null)
      {
        ((BasePluginLayout)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(237237);
        return;
      }
      AppMethodBeat.o(237237);
      return;
    }
    AppMethodBeat.o(237237);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(75056);
    try
    {
      super.onResume();
      com.tencent.mm.plugin.ball.f.f.cjj();
      Object localObject = this.BJs;
      if (localObject != null)
      {
        Log.i("MicroMsg.RecordUIRouter", "onResume " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw);
        localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).BJw;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI
 * JD-Core Version:    0.7.0.1
 */