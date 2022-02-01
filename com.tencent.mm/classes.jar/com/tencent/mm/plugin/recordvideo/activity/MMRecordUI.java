package com.tencent.mm.plugin.recordvideo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.b;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.recordvideo.activity.a.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.b.c;
import com.tencent.mm.plugin.recordvideo.background.h;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;
import d.o;
import d.v;

@com.tencent.mm.ui.base.a(3)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "isLargeScreen", "", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "root", "Landroid/view/ViewGroup;", "uiRouter", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "checkScreenSize", "", "finish", "finishWithCancel", "getForceOrientation", "", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setWindowStyle", "Companion", "plugin-recordvideo_release"})
public class MMRecordUI
  extends MMActivity
{
  public static final MMRecordUI.a wly;
  private ViewGroup gnb;
  private RecordConfigProvider rRi;
  private com.tencent.mm.plugin.recordvideo.a.b wlu;
  private com.tencent.mm.plugin.recordvideo.activity.a.a wlv;
  private com.tencent.mm.plugin.recordvideo.activity.a.b wlw;
  private boolean wlx;
  
  static
  {
    AppMethodBeat.i(75063);
    wly = new MMRecordUI.a((byte)0);
    AppMethodBeat.o(75063);
  }
  
  public MMRecordUI()
  {
    AppMethodBeat.i(75062);
    this.wlv = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    AppMethodBeat.o(75062);
  }
  
  private final void dud()
  {
    AppMethodBeat.i(75054);
    if (aj.fhA())
    {
      localObject = this.rRi;
      if ((localObject != null) && (((RecordConfigProvider)localObject).wqO == true))
      {
        int i = com.tencent.mm.ui.ap.cl((Context)getContext()).y;
        int j = (int)(i * 0.5625F);
        localObject = this.gnb;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject != null)
          {
            ((ViewGroup.LayoutParams)localObject).width = j;
            ((ViewGroup.LayoutParams)localObject).height = i;
            if (!(localObject instanceof LinearLayout.LayoutParams)) {
              break label115;
            }
            ((LinearLayout.LayoutParams)localObject).gravity = 17;
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.recordvideo.model.a.wra;
          com.tencent.mm.plugin.recordvideo.model.a.Mg(j);
          localObject = com.tencent.mm.plugin.recordvideo.model.a.wra;
          com.tencent.mm.plugin.recordvideo.model.a.xn(i);
          AppMethodBeat.o(75054);
          return;
          label115:
          if ((localObject instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams)localObject).gravity = 17;
          } else if ((localObject instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject).addRule(13);
          }
        }
      }
    }
    Object localObject = this.gnb;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
    }
    localObject = this.gnb;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
    localObject = com.tencent.mm.plugin.recordvideo.model.a.wra;
    com.tencent.mm.plugin.recordvideo.model.a.Mg(com.tencent.mm.ui.ap.cl((Context)getContext()).x);
    localObject = com.tencent.mm.plugin.recordvideo.model.a.wra;
    com.tencent.mm.plugin.recordvideo.model.a.xn(com.tencent.mm.ui.ap.cl((Context)getContext()).y);
    AppMethodBeat.o(75054);
  }
  
  public final void due()
  {
    AppMethodBeat.i(199257);
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    localIntent.putExtra("report", (Parcelable)com.tencent.mm.plugin.recordvideo.d.c.dwq());
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(199257);
  }
  
  public void finish()
  {
    AppMethodBeat.i(75061);
    ac.i("MicroMsg.MMRecordUI", "finish  " + hashCode());
    super.finish();
    Object localObject = com.tencent.mm.plugin.recordvideo.e.d.wDU;
    com.tencent.mm.plugin.recordvideo.e.d.dxg();
    CaptureDataManager.wqi.a(null);
    localObject = com.tencent.mm.plugin.recordvideo.b.g.wpE;
    com.tencent.mm.plugin.recordvideo.b.g.unInit();
    localObject = h.wmI;
    h.duy();
    localObject = this.wlw;
    if (localObject != null)
    {
      ac.i("MicroMsg.RecordUIRouter", "finish " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).wlA);
      ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).isFinishing = true;
      com.tencent.mm.sdk.platformtools.ap.f((Runnable)new b.b((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject));
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
    return 2131495225;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75060);
    ac.i("MicroMsg.MMRecordUI", "requestCode : " + paramInt1 + " resultCode:" + paramInt2 + "  " + hashCode());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      localObject = this.wlu;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.a.b)localObject).Z((Context)this, paramIntent);
        AppMethodBeat.o(75060);
        return;
      }
      AppMethodBeat.o(75060);
      return;
    }
    Object localObject = this.wlw;
    if (localObject != null)
    {
      ac.i("MicroMsg.RecordUIRouter", "onActivityResult " + paramInt1 + ' ' + paramInt2 + ' ' + paramIntent);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).wlA;
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
    ac.i("MicroMsg.MMRecordUI", "onBackPressed  " + hashCode());
    Object localObject = this.wlw;
    RecordConfigProvider localRecordConfigProvider;
    if (localObject != null)
    {
      localRecordConfigProvider = this.rRi;
      if (localRecordConfigProvider == null) {
        break label126;
      }
    }
    label126:
    for (int i = localRecordConfigProvider.scene;; i = 0)
    {
      ac.i("MicroMsg.RecordUIRouter", "onBackPressed ".concat(String.valueOf(i)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).wlA;
      if (localObject != null) {
        bool = ((BasePluginLayout)localObject).alO();
      }
      if (!bool)
      {
        localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.Mo(14);
        localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.Mq(i);
      }
      if (bool != true) {
        due();
      }
      AppMethodBeat.o(75059);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(75055);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration != null) && ((paramConfiguration.screenLayout & 0x3) != 0) && ((paramConfiguration.screenLayout & 0x10) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.wlx)
      {
        this.wlx = bool;
        dud();
      }
      AppMethodBeat.o(75055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l2 = 0L;
    AppMethodBeat.i(75053);
    ac.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate  " + hashCode());
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.nX(true);
    getWindow().setFormat(-3);
    setLightNavigationbarIcon();
    this.gnb = ((ViewGroup)findViewById(2131303905));
    paramBundle = com.tencent.mm.plugin.recordvideo.e.d.wDU;
    com.tencent.mm.plugin.recordvideo.e.d.dxg();
    paramBundle = (RecordConfigProvider)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    int i = getIntent().getIntExtra("KEY_PARAMS_TO_WHERE", -1);
    int k;
    switch (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1))
    {
    default: 
      ac.i("MicroMsg.MMRecordUI", "onCreate configProvider : " + paramBundle + "    toWhere:" + i);
      localObject1 = new o(paramBundle, Integer.valueOf(i));
      paramBundle = (RecordConfigProvider)((o)localObject1).first;
      k = ((Number)((o)localObject1).second).intValue();
      if (paramBundle == null) {
        i = 2000;
      }
      break;
    }
    for (;;)
    {
      ac.i("MicroMsg.MMRecordUI", " checkConfigProvider:  ".concat(String.valueOf(i)));
      if (i == 999) {
        break label395;
      }
      setResult(i);
      finish();
      AppMethodBeat.o(75053);
      return;
      CaptureDataManager.wqi.a((CaptureDataManager.b)new com.tencent.mm.plugin.recordvideo.a.a());
      break;
      this.wlu = new com.tencent.mm.plugin.recordvideo.a.b();
      CaptureDataManager.wqi.a((CaptureDataManager.b)this.wlu);
      break;
      if (k == 2)
      {
        int j = com.tencent.mm.plugin.recordvideo.activity.a.a.aqv(paramBundle.wqF);
        i = j;
        if (j == 999)
        {
          localObject1 = paramBundle.wqF;
          k.g(localObject1, "configProvider.inputVideoPath");
          j = com.tencent.mm.plugin.recordvideo.activity.a.a.aqw((String)localObject1);
          i = j;
          if (j != 999) {}
        }
      }
      else
      {
        i = 999;
      }
    }
    label395:
    Object localObject1 = (Context)this;
    Object localObject2 = this.gnb;
    if (localObject2 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75053);
      throw paramBundle;
    }
    if (paramBundle == null) {
      k.fOy();
    }
    this.wlw = new com.tencent.mm.plugin.recordvideo.activity.a.b((Context)localObject1, (ViewGroup)localObject2, paramBundle, k);
    this.rRi = paramBundle;
    localObject1 = com.tencent.mm.plugin.recordvideo.e.c.wDO;
    com.tencent.mm.plugin.recordvideo.e.c.h(paramBundle);
    localObject1 = getResources();
    k.g(localObject1, "resources");
    boolean bool;
    long l3;
    if (((Resources)localObject1).getConfiguration() != null)
    {
      localObject1 = getResources();
      k.g(localObject1, "resources");
      if ((((Resources)localObject1).getConfiguration().screenLayout & 0x3) != 0)
      {
        localObject1 = getResources();
        k.g(localObject1, "resources");
        if ((((Resources)localObject1).getConfiguration().screenLayout & 0x10) != 0)
        {
          bool = true;
          this.wlx = bool;
          dud();
          localObject1 = this.wlw;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).a(k, com.tencent.mm.plugin.recordvideo.activity.a.a.b(paramBundle));
          }
          ac.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate finish");
          CaptureDataManager.wqi.dvg();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.a(paramBundle.wqK);
          l1 = ax.iI((Context)getContext());
          l3 = System.currentTimeMillis();
          localObject1 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
          com.tencent.mm.plugin.recordvideo.e.b.dxa();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_NET_TYPE_INT", Long.valueOf(l1));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_TIME_MS_LONG", Long.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dwr().iv(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dwr().ml(String.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dwr();
          localObject2 = paramBundle.wqK;
          if (localObject2 == null) {
            break label971;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).plW;
          label726:
          ((eq)localObject1).iw(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dwr().ix(l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dwr();
          localObject2 = paramBundle.wqK;
          if (localObject2 == null) {
            break label977;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).wqS;
          label776:
          ((eq)localObject1).iG(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.dws().jC(ax.iI((Context)getContext()));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dws();
          localObject2 = new StringBuilder();
          e locale = com.tencent.mm.kernel.g.agR();
          k.g(locale, "MMKernel.storage()");
          ((fb)localObject1).mE(locale.agA().get(2).toString() + l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dws();
          localObject2 = paramBundle.wqK;
          if (localObject2 == null) {
            break label983;
          }
        }
      }
    }
    label971:
    label977:
    label983:
    for (long l1 = ((VideoCaptureReportInfo)localObject2).plW;; l1 = 0L)
    {
      ((fb)localObject1).jD(l1);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.dws().jE(l3);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dws();
      paramBundle = paramBundle.wqK;
      l1 = l2;
      if (paramBundle != null) {
        l1 = paramBundle.wqS;
      }
      ((fb)localObject1).jJ(l1);
      AppMethodBeat.o(75053);
      return;
      bool = false;
      break;
      l1 = 0L;
      break label726;
      l1 = 0L;
      break label776;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(75058);
    ac.i("MicroMsg.MMRecordUI", "MMRecordUI onDestroy " + hashCode());
    super.onDestroy();
    Object localObject1 = this.wlw;
    if (localObject1 != null)
    {
      ac.i("MicroMsg.RecordUIRouter", "onDestroy " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).wlA);
      com.tencent.mm.sdk.platformtools.ap.f((Runnable)new b.c((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1));
      if ((((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).wlA instanceof RecordPluginLayout))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      localObject1 = new t();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.d.c.dwq();
      Object localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_NET_TYPE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
      ((t)localObject1).bq(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_FROM_SCENE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
      ((t)localObject1).br(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ENTER_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
      ((t)localObject1).bs(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
      ((t)localObject1).bt(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MEDIA_SOURCE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
      ((t)localObject1).bu(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MEDIA_TYPE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
      ((t)localObject1).bv(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_START_RECORD_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
      ((t)localObject1).bw(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
      ((t)localObject1).bx(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ORIGIN_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
      ((t)localObject1).by(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ORIGIN_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
      ((t)localObject1).bz(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((t)localObject1).bA(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((t)localObject1).bB(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
      ((t)localObject1).bC(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_EMOJI_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
      ((t)localObject1).bD(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_EMOJI_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
      ((t)localObject1).bE(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_TEXT_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
      ((t)localObject1).bF(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_TEXT_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
      ((t)localObject1).bG(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_DOODLE_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
      ((t)localObject1).bH(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_DOODLE_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
      ((t)localObject1).bI(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_DOODLE_COLOR_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
      ((t)localObject1).bJ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_MOSAIC_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
      ((t)localObject1).bK(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_BRUSH_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
      ((t)localObject1).bL(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ADD_MOSAIC_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
      ((t)localObject1).bM(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_CROP_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
      ((t)localObject1).bN(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CROP_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
      ((t)localObject1).bP(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CROP_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
      ((t)localObject1).bO(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_ROTATE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_ROTATE_INT,-1)");
      ((t)localObject1).bQ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_MUSIC_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
      ((t)localObject1).bR(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MUSIC_ID_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
      ((t)localObject1).bS(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MUSIC_INDEX_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
      ((t)localObject1).bT(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_SELECT_MUSIC_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
      ((t)localObject1).bU(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_SELECT_ORIGIN_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
      ((t)localObject1).bV(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_MUSIC_REQ_ID_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
      ((t)localObject1).bW(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_SEARCH_MUSIC_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
      ((t)localObject1).bX(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_CLICK_VIDEO_CROP_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
      ((t)localObject1).bY(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_VIDEO_CROP_DURATION_MS_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
      ((t)localObject1).bZ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_AFTER_EDIT_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
      ((t)localObject1).ca(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_EDIT_PUBLISHID_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
      ((t)localObject1).cb(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_IS_SHOW_WESEE_BTN", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_IS_SHOW_WESEE_BTN, 0)");
      ((t)localObject1).cc(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_IS_CLICK_WESEE_BTN", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_IS_CLICK_WESEE_BTN, 0)");
      ((t)localObject1).cd(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).x("KEY_IS_INSTALL_WESEE", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_IS_INSTALL_WESEE, 0)");
      ((t)localObject1).ce(((Number)localObject3).longValue());
      localObject2 = ((RecordMediaReportInfo)localObject2).x("KEY_WESEE_DIALOG_OPERATION", Long.valueOf(0L));
      k.g(localObject2, "info.getReportValue(KEY_WESEE_DIALOG_OPERATION, 0)");
      ((t)localObject1).cf(((Number)localObject2).longValue());
      ((t)localObject1).fN(com.tencent.mm.plugin.recordvideo.d.c.wya.dwp());
      ((t)localObject1).aHZ();
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.e.d.wDU;
    com.tencent.mm.plugin.recordvideo.e.d.dxg();
    if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
      y.cGI.Ix().Iw();
    }
    com.tencent.mm.media.f.c.gRV.aqV();
    AppMethodBeat.o(75058);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(75057);
    ac.i("MicroMsg.MMRecordUI", "MMRecordUI onPause  isFinishing  : " + isFinishing() + "  " + hashCode() + "  ");
    super.onPause();
    f.bHl();
    if (isFinishing())
    {
      AppMethodBeat.o(75057);
      return;
    }
    Object localObject = this.wlw;
    if (localObject != null)
    {
      ac.i("MicroMsg.RecordUIRouter", "onPause " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).wlA);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).wlA;
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
  
  public void onResume()
  {
    AppMethodBeat.i(75056);
    try
    {
      super.onResume();
      f.bHm();
      Object localObject = this.wlw;
      if (localObject != null)
      {
        ac.i("MicroMsg.RecordUIRouter", "onResume " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).wlA);
        localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).wlA;
        if (localObject != null) {
          ((BasePluginLayout)localObject).onResume();
        }
      }
      ac.i("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode() + "  ");
      AppMethodBeat.o(75056);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode());
      ac.printErrStackTrace("MicroMsg.MMRecordUI", (Throwable)localException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI
 * JD-Core Version:    0.7.0.1
 */