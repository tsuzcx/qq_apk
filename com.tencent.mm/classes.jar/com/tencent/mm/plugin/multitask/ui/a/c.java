package com.tencent.mm.plugin.multitask.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.f.a.lk;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.PluginMultiTask.b;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.base.b.c;
import com.tencent.mm.plugin.multitask.ui.base.b.d;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.u;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionEnterType", "", "getActionEnterType", "()I", "setActionEnterType", "(I)V", "actionExitType", "getActionExitType", "setActionExitType", "callback", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "getCallback", "()Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "setCallback", "(Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;)V", "canReportEnterTips", "", "currentTabIndex", "delayHideDynamicBgRunnable", "Ljava/lang/Runnable;", "delayShowEnterTipsRunnable", "dynamicBgContainer", "Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "eduExitType", "getEduExitType", "setEduExitType", "enterTipsView", "Landroid/view/View;", "gradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "homeTabChangedListener", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1;", "isDynamicBgShow", "launcherContainer", "getLauncherContainer", "()Landroid/view/View;", "setLauncherContainer", "(Landroid/view/View;)V", "listEduType", "getListEduType", "setListEduType", "mOriention", "getMOriention", "setMOriention", "multiTaskIcon", "Landroid/widget/ImageView;", "getMultiTaskIcon", "()Landroid/widget/ImageView;", "setMultiTaskIcon", "(Landroid/widget/ImageView;)V", "onCreateInstanceState", "Landroid/os/Bundle;", "panelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "getPanelView", "()Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "setPanelView", "(Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;)V", "parentPanelLayoutWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "getParentPanelLayoutWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "setParentPanelLayoutWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "parentViewPager", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getParentViewPager", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setParentViewPager", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "playSound", "getPlaySound", "setPlaySound", "realPanelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "tipsViewShow", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkEnterTipsIfNeed", "", "checkShowLoading", "checkShowSnapshotIfNeed", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "size", "forceHide", "forceShow", "checkTeenMode", "multiTaskType", "createMultiTaskPanelView", "createPanelView", "delayHideDynamicBg", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "enableExpand", "enableScroll", "enable", "enterFullScreenMode", "exitFullScreenMode", "getMultiTaskItemPosition", "", "id", "curPos", "way", "hasCurrentMultiInfo", "hideDynamicBg", "hideSnapshotUIC", "remove", "inMultiTaskPanel", "initEnterEduReport", "eduType", "initEnterReport", "initExitEduReport", "initExitReport", "isDataEmpty", "isShowSnapshotUIC", "jumpSnapshotUIC", "markEduReportStat", "resume", "markWechatForeground", "foreground", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "onKeyUp", "onMultiTaskPageSelected", "position", "onPanelItemSelected", "panel", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPause", "onPlaySound", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "requestOrientation", "saveHomeSnapBlt", "showEnterTipsAnim", "showHome", "smoothScroll", "fromClick", "fromSwipe", "fromFullSwipe", "fromSysClick", "fromFadeClick", "fromDeleteAll", "fromBlankClick", "showPanel", "showSnapshotUIC", "switchToDynamicBg", "switchToStaticBg", "delay", "updateLoadingMode", "loadingMode", "Companion", "MultiTaskCallback", "ui-multitask_release"})
public final class c
  extends UIComponent
  implements PluginMultiTask.b, com.tencent.mm.plugin.multitask.ui.base.b.b
{
  private static int FMD = 0;
  private static int FME = 0;
  private static int FMF = 0;
  private static int FMG = 0;
  private static int FMH = 0;
  private static int FMI = 0;
  private static int FMJ = 0;
  private static int FMK = 0;
  private static int FML = 0;
  private static int FMM = 0;
  private static int FMN = 0;
  private static int FMO = 0;
  private static int FMP = 0;
  private static int FMQ = 0;
  private static int FMR = 0;
  private static int FMS = 0;
  private static int FMT = 0;
  private static int FMU = 0;
  private static int FMV = 0;
  private static int FMW = 0;
  private static int FMX = 0;
  static int FMY = 0;
  static float FMZ = 0.0F;
  private static float FNa = 0.0F;
  private static float FNb = 0.0F;
  public static final a FNc;
  public static final String TAG = "MicroMsg.MultiTask.MultiTaskUIC";
  private static int bwU;
  static int pEj;
  private static int pEk;
  private static float scale;
  private static int tHY;
  private GradientColorBackgroundView FKd;
  private Bundle FLl;
  private final f FMA;
  private Runnable FMB;
  private boolean FMC;
  public CustomViewPager FMh;
  public com.tencent.mm.plugin.multitask.ui.base.b FMi;
  private View FMj;
  public com.tencent.mm.plugin.multitask.ui.panel.b FMk;
  private ImageView FMl;
  public int FMm;
  private int FMn;
  private int FMo;
  private int FMp;
  public b FMq;
  public int FMr;
  private int FMs;
  private int FMt;
  public MultiTaskContainerView FMu;
  View FMv;
  public Runnable FMw;
  boolean FMx;
  boolean FMy;
  private DynamicBgContainer FMz;
  public final MMHandler knk;
  
  static
  {
    AppMethodBeat.i(197190);
    FNc = new a((byte)0);
    TAG = "MicroMsg.MultiTask.MultiTaskUIC";
    FMZ = 0.2F;
    FNa = com.tencent.mm.ci.a.ez(MMApplicationContext.getContext());
    scale = 1.666667F;
    FNb = 1.333333F;
    AppMethodBeat.o(197190);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(197188);
    this.FMm = 6;
    this.FMn = 6;
    this.FMo = 9;
    this.FMp = 3;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.FMA = new f(this);
    AppMethodBeat.o(197188);
  }
  
  public static boolean Yo(int paramInt)
  {
    AppMethodBeat.i(197143);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)locala).ZM();
    locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    int i = ((com.tencent.mm.plugin.teenmode.a.b)locala).gks();
    locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    int j = ((com.tencent.mm.plugin.teenmode.a.b)locala).gkr();
    locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    int k = ((com.tencent.mm.plugin.teenmode.a.b)locala).dYS();
    Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d, bizAcctOption: %d, finderOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if ((bool) && (((i == 2) && (paramInt == 1)) || ((j == 2) && (paramInt == 2)) || ((k == 2) && (paramInt == 22))))
    {
      AppMethodBeat.o(197143);
      return true;
    }
    AppMethodBeat.o(197143);
    return false;
  }
  
  private final void fbX()
  {
    AppMethodBeat.i(197012);
    if (!fbW())
    {
      SharedPreferences localSharedPreferences = getActivity().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      p.j(localSharedPreferences, "activity.getSharedPrefer…faultPreferencePath(), 0)");
      Log.i(TAG, "set ScreenOrientation，now is ： %s", new Object[] { Boolean.valueOf(localSharedPreferences.getBoolean("settings_landscape_mode", false)) });
      if (localSharedPreferences.getBoolean("settings_landscape_mode", false))
      {
        getActivity().setRequestedOrientation(-1);
        AppMethodBeat.o(197012);
        return;
      }
      getActivity().setRequestedOrientation(1);
      AppMethodBeat.o(197012);
      return;
    }
    getActivity().setRequestedOrientation(1);
    AppMethodBeat.o(197012);
  }
  
  private boolean fbY()
  {
    AppMethodBeat.i(197016);
    if (!fbW())
    {
      AppMethodBeat.o(197016);
      return true;
    }
    AppMethodBeat.o(197016);
    return false;
  }
  
  private void fbZ()
  {
    AppMethodBeat.i(197080);
    if (!this.FMC)
    {
      AppMethodBeat.o(197080);
      return;
    }
    Log.i(TAG, "virbg: switchToStaticBg");
    this.FMC = false;
    if ((this.FMz != null) && (!DynamicBgContainer.fbB()))
    {
      GradientColorBackgroundView localGradientColorBackgroundView = this.FKd;
      if (localGradientColorBackgroundView != null) {
        localGradientColorBackgroundView.setVisibility(0);
      }
      localGradientColorBackgroundView = this.FKd;
      if (localGradientColorBackgroundView != null) {
        localGradientColorBackgroundView.setAlpha(1.0F);
      }
    }
    fca();
    AppMethodBeat.o(197080);
  }
  
  private final void fca()
  {
    AppMethodBeat.i(197083);
    DynamicBgContainer localDynamicBgContainer = this.FMz;
    if (localDynamicBgContainer != null)
    {
      localDynamicBgContainer.fbE();
      AppMethodBeat.o(197083);
      return;
    }
    AppMethodBeat.o(197083);
  }
  
  private void fcd()
  {
    AppMethodBeat.i(197127);
    Object localObject1 = this.FMk;
    if (localObject1 != null)
    {
      Object localObject2 = g.FEX;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aRe(g.fan());
      if (localObject1 != null)
      {
        localObject2 = this.FMk;
        if (localObject2 != null)
        {
          g localg = g.FEX;
          localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).bI(0, g.fam());
          if (localObject2 != null)
          {
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
              AppMethodBeat.o(197127);
              throw ((Throwable)localObject1);
            }
            localObject2 = (b)localObject2;
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
              AppMethodBeat.o(197127);
              throw ((Throwable)localObject1);
            }
            if (!b.a((b)localObject2, ((d)localObject1).FNi, false)) {
              break label153;
            }
            ((d)localObject1).fcd();
          }
        }
        while (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
          AppMethodBeat.o(197127);
          throw ((Throwable)localObject1);
          label153:
          vo(false);
        }
        ((d)localObject1).fcK();
        in(true);
        AppMethodBeat.o(197127);
        return;
      }
    }
    vo(false);
    AppMethodBeat.o(197127);
  }
  
  private void fce()
  {
    AppMethodBeat.i(197135);
    try
    {
      Object localObject1 = this.FMj;
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.ui.p.a.a(this.FMj, ((View)localObject1).getWidth(), ((View)localObject1).getHeight(), Bitmap.Config.RGB_565);
        if (localObject1 != null)
        {
          Object localObject2 = com.tencent.mm.plugin.multitask.h.FFb;
          localObject2 = com.tencent.mm.plugin.multitask.h.faq();
          if (u.agG((String)localObject2)) {
            u.deleteFile((String)localObject2);
          }
          BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.JPEG, (String)localObject2, true);
        }
        AppMethodBeat.o(197135);
        return;
      }
      AppMethodBeat.o(197135);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "snapshot bitmap failed", new Object[] { localThrowable });
      AppMethodBeat.o(197135);
    }
  }
  
  private void vp(boolean paramBoolean)
  {
    AppMethodBeat.i(197153);
    if (fbW())
    {
      dan localdan;
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
        if (localObject != null)
        {
          localdan = ((daq)localObject).TId;
          if (localdan != null)
          {
            localdan.THM = cm.bfE();
            localdan.xpx = true;
          }
          localdan = ((daq)localObject).TIc;
          if (localdan != null)
          {
            localdan.THM = cm.bfE();
            localdan.xpx = true;
          }
          localObject = ((daq)localObject).TIe;
          if (localObject != null)
          {
            ((dan)localObject).THM = cm.bfE();
            ((dan)localObject).xpx = true;
            AppMethodBeat.o(197153);
            return;
          }
          AppMethodBeat.o(197153);
          return;
        }
        AppMethodBeat.o(197153);
        return;
      }
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
      if (localObject != null)
      {
        localdan = ((daq)localObject).TId;
        if ((localdan != null) && (cm.bfE() >= localdan.THM) && (!((daq)localObject).TIb) && (localdan.xpx))
        {
          localdan.duration += cm.bfE() - localdan.THM;
          localdan.THM = cm.bfE();
        }
        localdan = ((daq)localObject).TIc;
        if ((localdan != null) && (cm.bfE() >= localdan.THM) && (!((daq)localObject).TIb))
        {
          localdan.duration += cm.bfE() - localdan.THM;
          localdan.THM = cm.bfE();
        }
        localdan = ((daq)localObject).TIe;
        if (localdan != null)
        {
          if ((cm.bfE() >= localdan.THM) && (!((daq)localObject).TIb))
          {
            localdan.duration += cm.bfE() - localdan.THM;
            localdan.THM = cm.bfE();
          }
          AppMethodBeat.o(197153);
          return;
        }
        AppMethodBeat.o(197153);
        return;
      }
    }
    AppMethodBeat.o(197153);
  }
  
  public final void Yi(int paramInt)
  {
    AppMethodBeat.i(197075);
    Log.i(TAG, "onPanelItemSelected, position:".concat(String.valueOf(paramInt)));
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramInt == 0)
    {
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject1 = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.clear();
        localObject2 = com.tencent.mm.plugin.multitask.d.a.FHO;
        ((daq)localObject1).wmL = com.tencent.mm.plugin.multitask.d.a.fbf();
        ((daq)localObject1).zUF = cm.bfE();
        ((daq)localObject1).THY = new dak();
        ((daq)localObject1).THX = new dam();
        ((daq)localObject1).THZ = new dao();
        ((daq)localObject1).THZ.jWO = 1L;
        if (this.FMm == 6) {
          this.FMm = 1;
        }
        ((daq)localObject1).THZ.THQ = this.FMm;
        localObject2 = this.FMq;
        if (localObject2 != null)
        {
          localObject3 = ((daq)localObject1).THZ;
          localObject4 = com.tencent.mm.plugin.multitask.d.a.FHO;
          ((dao)localObject3).kVd = com.tencent.mm.plugin.multitask.d.a.Ye(((b)localObject2).getCurrentTabIndex());
        }
        localObject2 = ((daq)localObject1).THZ;
        if (fcc()) {}
        for (long l = 1L;; l = 2L)
        {
          ((dao)localObject2).THR = l;
          ((daq)localObject1).THZ.duration = 0L;
          localObject2 = this.FMk;
          if (localObject2 == null) {
            break label310;
          }
          localObject3 = g.FEX;
          localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).bI(0, g.fam());
          if (localObject2 == null) {
            break label310;
          }
          localObject3 = ((daq)localObject1).THZ;
          if (localObject2 != null) {
            break;
          }
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(197075);
          throw ((Throwable)localObject1);
        }
        ((dao)localObject3).THS = ((b)localObject2).fbV();
        label310:
        localObject2 = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.b((daq)localObject1);
        Log.d(TAG, "report pageEnterAction, contextid:%s, action:%d, useraction:%d, scene:%d, fullscreen:%d, duration:%d", new Object[] { ((daq)localObject1).wmL, Long.valueOf(((daq)localObject1).THZ.jWO), Long.valueOf(((daq)localObject1).THZ.THQ), Long.valueOf(((daq)localObject1).THZ.kVd), Long.valueOf(((daq)localObject1).THZ.THR), Long.valueOf(((daq)localObject1).THZ.duration) });
      }
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        localObject1 = this.FMk;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).fbN();
        }
        if (!fcc())
        {
          localObject1 = this.FMk;
          if (localObject1 != null)
          {
            localObject2 = g.FEX;
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(0, g.fam());
            if (localObject1 != null)
            {
              if (localObject1 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                AppMethodBeat.o(197075);
                throw ((Throwable)localObject1);
                if (paramInt != 1) {
                  continue;
                }
                Log.i(TAG, "initExitReport, start");
                localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
                localObject1 = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
                if (localObject1 != null)
                {
                  localObject2 = ((daq)localObject1).THZ;
                  if (localObject2 != null)
                  {
                    ((dao)localObject2).jWO = 2L;
                    if (this.FMn == 6) {
                      this.FMn = 1;
                    }
                    ((dao)localObject2).THQ = this.FMn;
                    localObject3 = this.FMk;
                    if (localObject3 != null)
                    {
                      localObject4 = g.FEX;
                      localObject3 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject3).bI(0, g.fam());
                      if (localObject3 != null)
                      {
                        if (localObject3 == null)
                        {
                          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                          AppMethodBeat.o(197075);
                          throw ((Throwable)localObject1);
                        }
                        ((dao)localObject2).THS = ((b)localObject3).fbV();
                      }
                    }
                    if (cm.bfE() < ((daq)localObject1).zUF) {
                      break label810;
                    }
                    ((dao)localObject2).duration += cm.bfE() - ((daq)localObject1).zUF;
                    Log.i(TAG, "report pageExitAction, contextid:%s, action:%d, useraction:%d, scene:%d, fullscreen:%d, duration:%d", new Object[] { ((daq)localObject1).wmL, Long.valueOf(((daq)localObject1).THZ.jWO), Long.valueOf(((daq)localObject1).THZ.THQ), Long.valueOf(((daq)localObject1).THZ.kVd), Long.valueOf(((daq)localObject1).THZ.THR), Long.valueOf(((daq)localObject1).THZ.duration) });
                    ((daq)localObject1).zUF = cm.bfE();
                  }
                }
                for (;;)
                {
                  localObject2 = com.tencent.mm.plugin.multitask.d.a.FHO;
                  com.tencent.mm.plugin.multitask.d.a.b((daq)localObject1);
                  Yn(3);
                  Yn(2);
                  break;
                  label810:
                  Log.i(TAG, "report pageExitAction, error");
                }
              }
              ((b)localObject1).fbS();
              Log.i(TAG, "triggerExposed!");
            }
          }
        }
        localObject1 = this.FMq;
        if (localObject1 != null) {
          ((b)localObject1).YM(paramInt);
        }
        if (fbW()) {
          break label1058;
        }
        localObject1 = this.FMz;
        if (localObject1 != null) {
          ((DynamicBgContainer)localObject1).fbA();
        }
        fbZ();
        fcd();
        localObject1 = this.FMk;
        if (localObject1 == null) {
          break label1046;
        }
        localObject2 = g.FEX;
        localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(0, g.fam());
        localObject2 = localObject1;
        if (!(localObject1 instanceof b)) {
          localObject2 = null;
        }
        localObject1 = (b)localObject2;
        if (localObject1 != null) {
          ((b)localObject1).fbT();
        }
        if (localObject1 != null)
        {
          if ((this.FMo != 1) && (this.FMo != 3)) {
            break label1052;
          }
          bool = true;
          ((b)localObject1).al(false, bool);
        }
      }
    }
    label1046:
    label1052:
    label1058:
    while (!fbW()) {
      for (;;)
      {
        com.tencent.mm.ae.d.a(250L, (kotlin.g.a.a)new g(this));
        this.FMm = 6;
        this.FMn = 6;
        this.FMo = 9;
        this.FMp = 3;
        AppMethodBeat.o(197075);
        return;
        localObject1 = this.FMk;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).dKo();
        break;
        localObject1 = null;
        continue;
        boolean bool = false;
      }
    }
    Object localObject1 = this.FMl;
    if (localObject1 != null) {
      ((ImageView)localObject1).setAlpha(0.0F);
    }
    localObject1 = this.FMk;
    if (localObject1 != null)
    {
      localObject2 = g.FEX;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(1048576, g.fan());
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
          AppMethodBeat.o(197075);
          throw ((Throwable)localObject1);
        }
        if (!((d)localObject1).bVd())
        {
          Log.i(TAG, "jumpSnapshotUIC, is already hide");
          localObject1 = this.FMk;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).FLj;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).dKp();
              label1192:
              if (localObject1 == a.b.FHW)
              {
                localObject1 = this.FMk;
                if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).FLj instanceof b != true)) {}
              }
              else
              {
                fcb();
              }
              label1227:
              localObject1 = this.FMk;
              if (localObject1 == null) {
                break label1896;
              }
              localObject2 = g.FEX;
            }
          }
        }
      }
    }
    label1561:
    label1594:
    label1606:
    label1612:
    label1751:
    label1757:
    label1763:
    label1896:
    for (localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(0, g.fam());; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof b)) {
        localObject2 = null;
      }
      localObject1 = (b)localObject2;
      if (localObject1 != null) {
        ((b)localObject1).fbT();
      }
      if (localObject1 != null) {
        b.a((b)localObject1);
      }
      localObject2 = com.tencent.mm.plugin.multitask.e.b.FHS;
      if ((com.tencent.mm.plugin.multitask.e.b.fbn()) || (localObject1 == null) || (((b)localObject1).fbV() != 1L)) {
        break;
      }
      Ym(3);
      localObject1 = com.tencent.mm.plugin.multitask.e.b.FHS;
      com.tencent.mm.plugin.multitask.e.b.fbm();
      break;
      localObject1 = null;
      break label1192;
      localObject2 = this.FMk;
      if (localObject2 != null)
      {
        localObject3 = g.FEX;
        localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).bI(0, g.fam());
        if (localObject2 != null)
        {
          ((d)localObject1).fcJ();
          if (localObject2 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
            AppMethodBeat.o(197075);
            throw ((Throwable)localObject1);
          }
          localObject3 = (b)localObject2;
          localObject4 = ((d)localObject1).FNi;
          if (((b)localObject3).FLR.size() == 0) {
            Log.i(b.TAG, "jumpUICFormSnapshot, empty data");
          }
          label1522:
          label1650:
          do
          {
            do
            {
              do
              {
                in(false);
                Log.i(TAG, "jumpSnapshotUIC, show now!");
                break;
                if (((b)localObject3).FLR.size() != 1) {
                  break label1612;
                }
                localObject1 = ((b)localObject3).FLR.get(0);
                p.j(localObject1, "multiTaskInfoList.get(0)");
                localObject4 = (com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject1;
                localObject1 = ((b)localObject3).xUj;
                if (localObject1 == null) {
                  break label1594;
                }
                localObject1 = ((WxRecyclerView)localObject1).cK(1);
                localObject3 = ((b)localObject3).FLW;
              } while (localObject3 == null);
              if (localObject1 != null)
              {
                localObject2 = ((RecyclerView.v)localObject1).amk;
                if (localObject2 != null)
                {
                  localObject2 = ((View)localObject2).findViewById(e.c.multi_task_item_bg);
                  if (localObject1 == null) {
                    break label1606;
                  }
                }
              }
              for (localObject1 = ((RecyclerView.v)localObject1).amk;; localObject1 = null)
              {
                ((b.b)localObject3).a((View)localObject2, (View)localObject1, 0, ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject4).FKP, false);
                break;
                localObject1 = null;
                break label1522;
                localObject2 = null;
                break label1561;
              }
            } while (localObject4 == null);
            paramInt = ((b)localObject3).aRf(((MultiTaskInfo)localObject4).field_id);
            localObject1 = ((b)localObject3).xUj;
            if (localObject1 == null) {
              break label1751;
            }
            localObject2 = ((WxRecyclerView)localObject1).cK(paramInt + 1);
            if (((b)localObject3).FLR.size() > 2) {
              break label1763;
            }
            localObject1 = ((b)localObject3).xUj;
            if (localObject1 == null) {
              break label1757;
            }
            localObject1 = ((WxRecyclerView)localObject1).cK(1);
            if (localObject1 == null) {
              break label1757;
            }
            localObject1 = ((RecyclerView.v)localObject1).amk;
            if (localObject1 == null) {
              break label1757;
            }
            localObject1 = ((View)localObject1).findViewById(e.c.multi_task_item_bg);
            localObject3 = ((b)localObject3).FLW;
          } while (localObject3 == null);
          if (localObject2 != null) {}
          for (localObject2 = ((RecyclerView.v)localObject2).amk;; localObject2 = null)
          {
            ((b.b)localObject3).a((View)localObject1, (View)localObject2, paramInt, (MultiTaskInfo)localObject4, false);
            break;
            localObject2 = null;
            break label1650;
            localObject1 = null;
            break label1709;
            localObject1 = ((b)localObject3).getRootView().findViewById(e.c.FID);
            break label1709;
          }
        }
      }
      ((d)localObject1).fcL();
      ((d)localObject1).fcK();
      in(true);
      fcb();
      Log.i(TAG, "jumpSnapshotUIC, hide now!");
      break label1227;
      localObject1 = this.FMk;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).FLj;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).dKp();; localObject1 = null)
      {
        if (localObject1 == a.b.FHW)
        {
          localObject1 = this.FMk;
          if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).FLj instanceof b != true)) {
            break;
          }
        }
        fcb();
        break;
      }
    }
  }
  
  public final void Yl(int paramInt)
  {
    AppMethodBeat.i(197110);
    Log.i(TAG, "updateLoadingMode, loadingMode:".concat(String.valueOf(paramInt)));
    MultiTaskContainerView localMultiTaskContainerView = this.FMu;
    if (localMultiTaskContainerView != null)
    {
      localMultiTaskContainerView.Yl(paramInt);
      AppMethodBeat.o(197110);
      return;
    }
    AppMethodBeat.o(197110);
  }
  
  public final void Ym(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(197000);
    boolean bool3 = fcc();
    Log.d(TAG, "initEnterEduReport, eduType:" + paramInt + ", isShow:" + bool3);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
    if (localObject != null)
    {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197000);
        return;
      case 1: 
        ((daq)localObject).TIc = new dan();
        ((daq)localObject).TIc.THN = paramInt;
        ((daq)localObject).TIc.THM = cm.bfE();
        localObject = ((daq)localObject).TIc;
        if (!bool3) {}
        for (bool1 = true;; bool1 = false)
        {
          ((dan)localObject).xpx = bool1;
          AppMethodBeat.o(197000);
          return;
        }
      case 2: 
        ((daq)localObject).TId = new dan();
        ((daq)localObject).TId.THN = paramInt;
        ((daq)localObject).TId.THM = cm.bfE();
        localObject = ((daq)localObject).TId;
        if (!bool3) {}
        for (;;)
        {
          ((dan)localObject).xpx = bool1;
          AppMethodBeat.o(197000);
          return;
          bool1 = false;
        }
      }
      ((daq)localObject).TIe = new dan();
      ((daq)localObject).TIe.THN = paramInt;
      ((daq)localObject).TIe.THM = cm.bfE();
      localObject = ((daq)localObject).TIe;
      if (!bool3) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((dan)localObject).xpx = bool1;
        break;
      }
    }
    AppMethodBeat.o(197000);
  }
  
  public final void Yn(int paramInt)
  {
    AppMethodBeat.i(197009);
    if (this.FMo == 9) {
      this.FMo = 3;
    }
    Object localObject1 = this.FMk;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = g.FEX;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(0, g.fam());
      localObject2 = localObject1;
      if (!(localObject1 instanceof b)) {
        localObject2 = null;
      }
      localObject1 = (b)localObject2;
      if ((localObject1 == null) || (((b)localObject1).fbV() != 1L)) {
        break label196;
      }
      i = 2;
      label77:
      this.FMp = i;
      Log.d(TAG, "initExitEduReport, eduType:" + paramInt + ", eduExitType:" + this.FMo + ", listEduType:" + this.FMp);
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject1 = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
      if (localObject1 == null) {
        break label548;
      }
      switch (paramInt)
      {
      }
    }
    label196:
    do
    {
      AppMethodBeat.o(197009);
      return;
      localObject1 = null;
      break;
      i = 1;
      break label77;
      localObject2 = ((daq)localObject1).TIc;
      if (localObject2 != null)
      {
        ((dan)localObject2).THN = paramInt;
        ((dan)localObject2).THP = this.FMp;
        ((dan)localObject2).THO = this.FMo;
        if (cm.bfE() >= ((dan)localObject2).THM)
        {
          ((dan)localObject2).duration += cm.bfE() - ((dan)localObject2).THM;
          ((dan)localObject2).THM = cm.bfE();
        }
        locala = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.a((dan)localObject2);
        ((daq)localObject1).TIc = null;
        AppMethodBeat.o(197009);
        return;
      }
      AppMethodBeat.o(197009);
      return;
      localObject2 = ((daq)localObject1).TId;
      if (localObject2 != null)
      {
        if (!((dan)localObject2).xpx)
        {
          Log.i(TAG, "EduTypeEnterReport is skip");
          AppMethodBeat.o(197009);
          return;
        }
        ((dan)localObject2).THN = paramInt;
        ((dan)localObject2).THP = this.FMp;
        ((dan)localObject2).THO = this.FMo;
        if ((this.FMo != 7) && (cm.bfE() >= ((dan)localObject2).THM))
        {
          ((dan)localObject2).duration += cm.bfE() - ((dan)localObject2).THM;
          ((dan)localObject2).THM = cm.bfE();
        }
        locala = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.a((dan)localObject2);
        ((daq)localObject1).TId = null;
        AppMethodBeat.o(197009);
        return;
      }
      AppMethodBeat.o(197009);
      return;
      localObject2 = ((daq)localObject1).TIe;
    } while (localObject2 == null);
    ((dan)localObject2).THN = paramInt;
    ((dan)localObject2).THP = this.FMp;
    ((dan)localObject2).THO = this.FMo;
    if (cm.bfE() >= ((dan)localObject2).THM)
    {
      ((dan)localObject2).duration += cm.bfE() - ((dan)localObject2).THM;
      ((dan)localObject2).THM = cm.bfE();
    }
    com.tencent.mm.plugin.multitask.d.a locala = com.tencent.mm.plugin.multitask.d.a.FHO;
    com.tencent.mm.plugin.multitask.d.a.a((dan)localObject2);
    ((daq)localObject1).TIe = null;
    AppMethodBeat.o(197009);
    return;
    label548:
    AppMethodBeat.o(197009);
  }
  
  public final View a(final View paramView, DynamicBgContainer arg2, b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(196989);
    p.k(paramView, "launcherContainer");
    Log.i(TAG, "create panel launcher");
    this.FMj = paramView;
    this.FMz = ???;
    this.FKd = ???.getGradientBgView();
    ??? = this.FMz;
    if (??? != null) {
      ???.fbA();
    }
    this.FMq = paramb;
    ??? = getActivity().getSupportActionBar();
    if (??? != null)
    {
      ??? = ???.getCustomView();
      if (??? == null) {}
    }
    for (??? = (ImageView)???.findViewById(e.c.actionbar_up_indicator_btn);; ??? = null)
    {
      this.FMl = ???;
      ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).registerMultiTaskUIC(2, e.class);
      ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).registerMultiTaskUIC(0, b.class);
      ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).registerMultiTaskUIC(1, a.class);
      ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).registerMultiTaskUIC(1048576, d.class);
      ??? = com.tencent.mm.plugin.secdata.ui.a.JbV;
      ??? = com.tencent.mm.plugin.secdata.ui.a.a.hU((Context)getActivity());
      if (??? != null) {
        ???.a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.b(j.listOf(new String[] { "WebViewUI", "WebviewMpUI", "FinderLongVideoTimelineUI", "NoteEditorUI", "MiniQBReaderUI", "AppAttachDownloadUI", "ChooseMsgFileShowUI", "TopStoryFSVideoUI", "TopStoryMultiTaskListVideoUI", "LuggageGameWebViewUI" }), daq.class));
      }
      ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).setListener((PluginMultiTask.b)this);
      if (this.FMi != null) {
        break label955;
      }
      paramb = new com.tencent.mm.plugin.multitask.ui.base.b((Context)getActivity());
      paramb.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      Log.i(TAG, "create panel view");
      a.fcG();
      if (this.FMk == null) {
        this.FMk = new com.tencent.mm.plugin.multitask.ui.panel.b(getActivity(), this.FLl);
      }
      ??? = getActivity().getLayoutInflater().inflate(e.d.FJc, null);
      if (??? != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(196989);
      throw paramView;
    }
    Object localObject2 = (FrameLayout)???;
    ??? = ((FrameLayout)localObject2).findViewById(e.c.FIS);
    if (??? == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView");
      AppMethodBeat.o(196989);
      throw paramView;
    }
    this.FMu = ((MultiTaskContainerView)???);
    ((FrameLayout)localObject2).setDrawingCacheEnabled(false);
    ??? = this.FMu;
    int i;
    if (??? != null)
    {
      ??? = ???.findViewById(e.c.FIE);
      this.FMv = ???;
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
      ??? = (DynamicBgContainer)localObject1;
      if (localb != null)
      {
        if (localb.FLi == null)
        {
          ??? = localb.xGq.getLayoutInflater().inflate(e.d.FJd, null);
          localb.FLh = ((MultiTaskPanelContainer)???.findViewById(e.c.FIA));
          localObject1 = localb.FLh;
          if (localObject1 != null) {
            localb.a((MultiTaskPanelContainer)localObject1);
          }
          localb.FLi = ???;
        }
        ??? = localb.FLi;
      }
      ((FrameLayout)localObject2).addView(???, new ViewGroup.LayoutParams(-1, -1));
      ??? = (View)localObject2;
      if (??? == null) {
        break label944;
      }
      localObject1 = com.tencent.mm.plugin.multitask.f.c.FNB;
      f = com.tencent.mm.plugin.multitask.f.c.fcO();
      Log.i(TAG, "slideFractor: ".concat(String.valueOf(f)));
      i = (int)(f * (pEj - FMU));
      ???.setPadding(0, 0, i, 0);
      if ((??? != null) && (paramView != null))
      {
        paramb.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
        paramb.addView(???, 1, new ViewGroup.LayoutParams(-1, -1));
      }
      ??? = AnimationUtils.loadInterpolator(paramb.getContext(), com.tencent.mm.ah.a.a.mm_decelerate_interpolator);
      localObject1 = com.tencent.mm.plugin.multitask.animation.c.a.b.FGp;
      localObject1 = (ViewGroup)paramb;
      localObject2 = (com.tencent.mm.plugin.multitask.animation.c.a.b.a)new b.d(paramb);
      p.j(???, "interpolator");
      paramb.FGv = com.tencent.mm.plugin.multitask.animation.c.a.b.b.a((ViewGroup)localObject1, (com.tencent.mm.plugin.multitask.animation.c.a.b.a)localObject2, ???);
      ??? = paramb.getContext();
      if (??? == null) {
        break label839;
      }
      ??? = ???.getResources();
      if (??? == null) {
        break label839;
      }
      ??? = ???.getDisplayMetrics();
      if (??? == null) {
        break label839;
      }
    }
    label839:
    for (float f = ???.density;; f = com.tencent.mm.ci.a.getDensity(paramb.getContext()))
    {
      ??? = paramb.FGv;
      if (??? != null) {
        ???.FGk = (100.0F * f);
      }
      ??? = paramb.FGv;
      if (??? != null) {
        ???.rti = (f * 300.0F);
      }
      ??? = paramb.getContext().getSystemService("vibrator");
      if (??? != null) {
        break label851;
      }
      paramView = new t("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(196989);
      throw paramView;
      ??? = null;
      break;
    }
    label851:
    paramb.rqy = ((Vibrator)???);
    paramb.setSlideLeft(false);
    paramb.setPanelWidth(pEj);
    paramb.setPanelExpose(FMU);
    paramb.setExtraSlideRange(i);
    if (ar.isDarkMode()) {
      paramb.setCoveredFadeColor(5066061);
    }
    for (;;)
    {
      paramb.setOverlayed(true);
      localObject1 = (com.tencent.mm.plugin.multitask.ui.base.b.b)this;
      synchronized (paramb.FJn)
      {
        paramb.FJn.add(localObject1);
        paramb.setFadeOnClickListener((View.OnClickListener)new d(paramb, this, paramView));
        label944:
        paramb.setCurrentItem(1, false);
        this.FMi = paramb;
        label955:
        paramView = (View)this.FMi;
        AppMethodBeat.o(196989);
        return paramView;
        paramb.setCoveredFadeColor(3618127);
      }
    }
  }
  
  public final void a(b.c paramc1, b.c paramc2)
  {
    AppMethodBeat.i(197054);
    Log.d(TAG, "onPanelStateChanged, previousState:" + paramc1 + ", newState:" + paramc2);
    Object localObject;
    int i;
    if ((paramc2 != paramc1) && (paramc2 == b.c.FJQ))
    {
      if ((!fbW()) && (!fcc()) && (paramc1 == b.c.FJN)) {
        fcb();
      }
      localObject = this.FMq;
      if (localObject != null)
      {
        if (!fbW()) {
          break label264;
        }
        i = 0;
        ((b)localObject).YN(i);
      }
    }
    if ((paramc2 != paramc1) && (paramc2 == b.c.FJN))
    {
      paramc1 = this.FMz;
      if (paramc1 != null) {
        paramc1.fbA();
      }
      fbZ();
      FMY = 0;
    }
    paramc1 = this.FMk;
    if (paramc1 != null) {
      localObject = g.FEX;
    }
    for (paramc1 = paramc1.bI(0, g.fam());; paramc1 = null)
    {
      localObject = paramc1;
      if (!(paramc1 instanceof b)) {
        localObject = null;
      }
      paramc1 = (b)localObject;
      if ((paramc2 != b.c.FJN) || (isDataEmpty())) {
        break label274;
      }
      paramc2 = this.FMl;
      if (paramc2 != null) {
        paramc2.setAlpha(1.0F);
      }
      paramc2 = this.FMu;
      if (paramc2 != null) {
        paramc2.bG(0.0F);
      }
      FMY = 0;
      if (paramc1 != null) {
        paramc1.ad(0.0F, 0.0F);
      }
      if (!this.FMy) {
        break label345;
      }
      this.FMo = 3;
      Yn(1);
      this.FMy = false;
      AppMethodBeat.o(197054);
      return;
      label264:
      i = 1;
      break;
    }
    label274:
    if (paramc2 == b.c.FJM)
    {
      paramc2 = this.FMl;
      if (paramc2 != null) {
        paramc2.setAlpha(0.0F);
      }
      paramc2 = this.FMu;
      if (paramc2 != null) {
        paramc2.bG(1.0F);
      }
      FMY = 0;
      if (paramc1 != null) {
        paramc1.ad(1.0F, 0.0F);
      }
      if (this.FMy)
      {
        this.FMo = 4;
        Yn(1);
        this.FMy = false;
      }
    }
    label345:
    AppMethodBeat.o(197054);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    AppMethodBeat.i(197107);
    Log.i(TAG, "showHome, smoothScrool:" + paramBoolean1 + ", fromClick:" + paramBoolean2 + ", fromSwipe:" + paramBoolean2 + ", fromFullSwipe:" + paramBoolean4 + ", fromSysClick:" + paramBoolean5 + ", fromFadeClick:" + paramBoolean6 + ", fromDeleteAll:" + paramBoolean7);
    if (paramBoolean2) {
      if (paramBoolean5)
      {
        this.FMn = 8;
        if (!paramBoolean5) {
          break label227;
        }
        this.FMo = 8;
      }
    }
    for (;;)
    {
      Object localObject = this.FKd;
      if (localObject != null) {
        ((GradientColorBackgroundView)localObject).setVisibility(0);
      }
      localObject = this.FKd;
      if (localObject != null) {
        ((GradientColorBackgroundView)localObject).setAlpha(1.0F);
      }
      localObject = this.FMi;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).setCurrentItem(1, paramBoolean1);
      }
      if (!paramBoolean1) {
        fcd();
      }
      AppMethodBeat.o(197107);
      return;
      if (paramBoolean8)
      {
        this.FMn = 2;
        break;
      }
      this.FMn = 4;
      break;
      if (paramBoolean3)
      {
        this.FMn = 1;
        break;
      }
      this.FMn = 3;
      break;
      label227:
      if (paramBoolean6) {
        this.FMo = 2;
      } else if (paramBoolean8) {
        this.FMo = 5;
      } else if (paramBoolean4) {
        this.FMo = 7;
      } else if (paramBoolean7) {
        this.FMo = 6;
      } else if (paramBoolean2) {
        this.FMo = 1;
      } else if (paramBoolean3) {
        this.FMo = 3;
      } else {
        this.FMo = 9;
      }
    }
  }
  
  public final boolean aQY(String paramString)
  {
    AppMethodBeat.i(197104);
    p.k(paramString, "id");
    Object localObject1 = this.FMk;
    int i;
    boolean bool;
    if (localObject1 != null)
    {
      Object localObject2 = g.FEX;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(0, g.fam());
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(197104);
          throw paramString;
        }
        localObject1 = (b)localObject1;
        p.k(paramString, "id");
        localObject1 = ((Iterable)((b)localObject1).FLR).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            j.iBO();
          }
          if (((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject2).FKP.field_id.equals(paramString)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      Log.i(TAG, "hasCurrentMultiInfo, id:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(197104);
      return bool;
      i += 1;
      break;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void bE(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(197028);
    Object localObject1 = this.FMk;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = g.FEX;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aRe(g.fan());
      if ((localObject1 != null) && ((localObject1 instanceof d)))
      {
        localObject1 = (d)localObject1;
        if (((d)localObject1).bVd())
        {
          i = FMU;
          localObject2 = com.tencent.mm.plugin.multitask.f.a.FNz;
          f1 = 1.0F - (i + com.tencent.mm.plugin.multitask.f.a.fcM() + FMY) / ((d)localObject1).getRootView().getWidth();
          if (paramFloat < f1) {
            break label743;
          }
        }
      }
    }
    label324:
    label353:
    label738:
    label743:
    for (float f1 = (paramFloat - f1) / (1.0F - f1);; f1 = 0.0F)
    {
      i = FMU;
      localObject2 = com.tencent.mm.plugin.multitask.f.a.FNz;
      float f3 = -(i + com.tencent.mm.plugin.multitask.f.a.fcM() + FMY);
      i = FMU;
      localObject2 = com.tencent.mm.plugin.multitask.f.a.FNz;
      float f4 = i + com.tencent.mm.plugin.multitask.f.a.fcM() + FMY;
      ((d)localObject1).getRootView().setTranslationX(f3 + f4 * f1);
      Log.d("MicroMsg.SnapShotMultiTaskUIC", "onPanelSlide, factor: %f", new Object[] { Float.valueOf(f1) });
      localObject1 = this.FMu;
      if (localObject1 != null)
      {
        i = ((MultiTaskContainerView)localObject1).getWidth();
        f4 = i * FMZ;
        localObject1 = this.FMu;
        if (localObject1 == null) {
          break label592;
        }
        i = ((MultiTaskContainerView)localObject1).getWidth();
        label237:
        float f5 = f4 / (i - FMU);
        if (!this.FMx) {
          break label660;
        }
        if ((paramFloat > f5) || (0.0F > paramFloat)) {
          break label621;
        }
        localObject1 = this.FMv;
        if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0))
        {
          localObject1 = this.FMv;
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        f3 = (paramFloat - 0.0F) / (f5 - 0.0F);
        if (f3 >= 0.0F) {
          break label600;
        }
        f1 = 0.0F;
        localObject1 = this.FMv;
        if (localObject1 != null)
        {
          localObject2 = this.FMv;
          if (localObject2 == null) {
            break label615;
          }
          i = ((View)localObject2).getWidth();
          ((View)localObject1).setTranslationX(-((0 - i) / 2 + (f4 - 0.0F) * f1 / 2.0F));
        }
        Log.d(TAG, "checkShowEnterTips,show now!, transFractor:" + f1 + ", minslide:0, maxslide:" + f5 + ", slideOffset:" + paramFloat);
        localObject1 = this.FMk;
        if (localObject1 == null) {
          break label699;
        }
        localObject2 = g.FEX;
        localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(0, g.fam());
        localObject2 = localObject1;
        if (!(localObject1 instanceof b)) {
          localObject2 = null;
        }
        localObject1 = (b)localObject2;
        f1 = 1.0F - f5;
        if (paramFloat < f1) {
          break label738;
        }
      }
      for (f1 = (paramFloat - f1) / (1.0F - f1);; f1 = 0.0F)
      {
        if (localObject1 != null) {
          ((b)localObject1).ad(paramFloat, f1);
        }
        localObject1 = this.FMu;
        if (localObject1 != null)
        {
          f1 = ((MultiTaskContainerView)localObject1).getWidth() * 0.18F;
          paramFloat = (((MultiTaskContainerView)localObject1).getWidth() - FMU) * paramFloat;
          if (paramFloat < f1)
          {
            paramFloat /= f1;
            paramFloat = 1.0F - paramFloat * (paramFloat * paramFloat);
            localObject1 = this.FMl;
            if (localObject1 == null) {
              break label724;
            }
            if (paramFloat >= 0.0F) {
              break label710;
            }
            paramFloat = f2;
          }
          for (;;)
          {
            ((ImageView)localObject1).setAlpha(paramFloat);
            AppMethodBeat.o(197028);
            return;
            i = pEj;
            break;
            i = pEj;
            break label237;
            f1 = f3;
            if (f3 <= 1.0F) {
              break label324;
            }
            f1 = 1.0F;
            break label324;
            label615:
            i = 0;
            break label353;
            label621:
            localObject1 = this.FMv;
            if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0)) {
              break label419;
            }
            localObject1 = this.FMv;
            if (localObject1 == null) {
              break label419;
            }
            ((View)localObject1).setVisibility(4);
            break label419;
            localObject1 = this.FMv;
            if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0)) {
              break label419;
            }
            localObject1 = this.FMv;
            if (localObject1 == null) {
              break label419;
            }
            ((View)localObject1).setVisibility(4);
            break label419;
            localObject1 = null;
            break label446;
            paramFloat = 0.0F;
            break label552;
            if (paramFloat > 1.0F) {
              paramFloat = 1.0F;
            }
          }
          AppMethodBeat.o(197028);
          return;
        }
        AppMethodBeat.o(197028);
        return;
      }
    }
  }
  
  public final void bF(float paramFloat)
  {
    AppMethodBeat.i(197029);
    if (this.FMx)
    {
      AppMethodBeat.o(197029);
      return;
    }
    if (fbY())
    {
      MultiTaskContainerView localMultiTaskContainerView = this.FMu;
      if (localMultiTaskContainerView != null)
      {
        localMultiTaskContainerView.bG(paramFloat);
        AppMethodBeat.o(197029);
        return;
      }
    }
    AppMethodBeat.o(197029);
  }
  
  public final boolean fbW()
  {
    AppMethodBeat.i(196991);
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.FMi;
    if ((localb != null) && (localb.getCurItem() == 0))
    {
      AppMethodBeat.o(196991);
      return true;
    }
    AppMethodBeat.o(196991);
    return false;
  }
  
  public final void fbw()
  {
    AppMethodBeat.i(197042);
    this.FMx = false;
    Object localObject = this.FMi;
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).fbp();
    }
    if (!fbY())
    {
      localObject = this.FMu;
      if (localObject != null) {
        ((MultiTaskContainerView)localObject).Yl(0);
      }
    }
    localObject = this.FMk;
    if (localObject != null)
    {
      g localg = g.FEX;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bI(0, g.fam());
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(197042);
          throw ((Throwable)localObject);
        }
        ((b)localObject).fbU();
        AppMethodBeat.o(197042);
        return;
      }
    }
    AppMethodBeat.o(197042);
  }
  
  public final void fbx()
  {
    AppMethodBeat.i(197033);
    MultiTaskContainerView localMultiTaskContainerView = this.FMu;
    if (localMultiTaskContainerView != null)
    {
      localMultiTaskContainerView.Yl(0);
      AppMethodBeat.o(197033);
      return;
    }
    AppMethodBeat.o(197033);
  }
  
  public final void fby()
  {
    AppMethodBeat.i(197017);
    this.FMt += 1;
    Log.d(TAG, "playsound count: %d", new Object[] { Integer.valueOf(this.FMt) });
    AppMethodBeat.o(197017);
  }
  
  public final boolean fbz()
  {
    AppMethodBeat.i(197014);
    if ((isDataEmpty()) && (!fbW()))
    {
      Log.d(TAG, "needExpand, false!");
      AppMethodBeat.o(197014);
      return false;
    }
    AppMethodBeat.o(197014);
    return true;
  }
  
  public final void fcb()
  {
    AppMethodBeat.i(197088);
    if ((this.FMC) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.way, 0) == 1))
    {
      AppMethodBeat.o(197088);
      return;
    }
    Log.i(TAG, "virbg: switchToDynamicBg");
    this.FMC = true;
    if (this.FMB != null)
    {
      this.knk.removeCallbacks(this.FMB);
      this.FMB = null;
    }
    DynamicBgContainer localDynamicBgContainer = this.FMz;
    if (localDynamicBgContainer != null)
    {
      localDynamicBgContainer.fbF();
      AppMethodBeat.o(197088);
      return;
    }
    AppMethodBeat.o(197088);
  }
  
  public final boolean fcc()
  {
    AppMethodBeat.i(197120);
    Object localObject = this.FMk;
    if (localObject != null)
    {
      g localg = g.FEX;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bI(1048576, g.fan());
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
          AppMethodBeat.o(197120);
          throw ((Throwable)localObject);
        }
        boolean bool = ((d)localObject).bVd();
        AppMethodBeat.o(197120);
        return bool;
      }
    }
    AppMethodBeat.o(197120);
    return false;
  }
  
  public final String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(197102);
    p.k(paramString, "id");
    Object localObject1 = this.FMk;
    if (localObject1 != null)
    {
      g localg = g.FEX;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bI(0, g.fam());
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(197102);
          throw paramString;
        }
        localObject1 = (b)localObject1;
        p.k(paramString, "id");
        int i = ((b)localObject1).aRf(paramString);
        if ((paramInt1 != i) && (i >= 0) && (i < ((b)localObject1).FLR.size()))
        {
          if (paramInt2 == 4)
          {
            if (((b)localObject1).FLR.size() <= 2)
            {
              paramString = ((b)localObject1).xUj;
              if (paramString != null)
              {
                paramString = paramString.cK(1);
                if (paramString != null)
                {
                  paramString = paramString.amk;
                  if (paramString != null) {
                    paramString = paramString.findViewById(e.c.multi_task_item_bg);
                  }
                }
              }
            }
            for (;;)
            {
              localObject1 = com.tencent.mm.plugin.multitask.f.c.FNB;
              paramString = com.tencent.mm.plugin.multitask.f.c.fy(paramString);
              AppMethodBeat.o(197102);
              return paramString;
              paramString = null;
              continue;
              paramString = ((b)localObject1).getRootView().findViewById(e.c.FID);
            }
          }
          paramString = ((b)localObject1).xUj;
          if (paramString != null) {}
          for (localObject1 = paramString.cK(i + 1);; localObject1 = null)
          {
            paramString = localObject2;
            if (localObject1 == null) {
              break;
            }
            paramString = ((RecyclerView.v)localObject1).amk;
            break;
          }
        }
        AppMethodBeat.o(197102);
        return "";
      }
    }
    AppMethodBeat.o(197102);
    return "";
  }
  
  public final void in(boolean paramBoolean)
  {
    AppMethodBeat.i(197113);
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.FMi;
    boolean bool3;
    if (localb != null)
    {
      bool3 = localb.getCanSlide();
      Log.i(TAG, "enableScroll: " + paramBoolean + ", canSlide:" + bool3 + ", orientation:" + this.FMr + ", currentTabIndex:" + this.FMs);
      if (((this.FMr != 2) && (!isDataEmpty()) && (this.FMs == 0)) || (fbW())) {
        break label240;
      }
      Log.i(TAG, "enableScroll false, isDataEmpty: " + isDataEmpty());
    }
    label240:
    for (boolean bool2 = false;; bool2 = paramBoolean)
    {
      boolean bool1 = bool2;
      if (fcc())
      {
        bool1 = bool2;
        if (fbW())
        {
          Log.i(TAG, "enableScroll false, showSnapshot Already");
          bool1 = false;
        }
      }
      b localb1 = this.FMq;
      bool2 = bool1;
      if (localb1 != null)
      {
        bool2 = bool1;
        if (localb1.fcH() == true)
        {
          Log.i(TAG, "enableScroll false, isHeaderOpen");
          bool2 = false;
        }
      }
      if (bool3 == paramBoolean)
      {
        AppMethodBeat.o(197113);
        return;
      }
      localb.setCanSlide(bool2);
      AppMethodBeat.o(197113);
      return;
      AppMethodBeat.o(197113);
      return;
    }
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196962);
    a.is(paramInt1, paramInt2);
    Object localObject = this.FMk;
    if (localObject != null)
    {
      g localg = g.FEX;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bI(0, g.fam());
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(196962);
          throw ((Throwable)localObject);
        }
        ((b)localObject).dGn();
        AppMethodBeat.o(196962);
        return;
      }
    }
    AppMethodBeat.o(196962);
  }
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(197036);
    Object localObject = this.FMk;
    if (localObject != null)
    {
      g localg = g.FEX;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bI(0, g.fam());
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(197036);
          throw ((Throwable)localObject);
        }
        boolean bool = ((b)localObject).isDataEmpty();
        AppMethodBeat.o(197036);
        return bool;
      }
    }
    AppMethodBeat.o(197036);
    return true;
  }
  
  public final void k(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(197117);
    p.k(paramMultiTaskInfo, "taskInfo");
    fce();
    fbZ();
    f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VDR, paramMultiTaskInfo.field_id + "|" + cm.bfE());
    Log.i(TAG, "enterFullScreenMode, id:" + paramMultiTaskInfo.field_id);
    AppMethodBeat.o(197117);
  }
  
  public final void kU(boolean paramBoolean)
  {
    AppMethodBeat.i(197157);
    if (fbW())
    {
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
        if (localObject != null)
        {
          if (((daq)localObject).THZ != null) {
            ((daq)localObject).zUF = cm.bfE();
          }
          AppMethodBeat.o(197157);
          return;
        }
        AppMethodBeat.o(197157);
        return;
      }
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject = (daq)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, daq.class);
      if (localObject != null)
      {
        dao localdao = ((daq)localObject).THZ;
        if (localdao != null)
        {
          if ((cm.bfE() >= ((daq)localObject).zUF) && (!((daq)localObject).TIb))
          {
            localdao.duration += cm.bfE() - ((daq)localObject).zUF;
            ((daq)localObject).zUF = cm.bfE();
          }
          AppMethodBeat.o(197157);
          return;
        }
        AppMethodBeat.o(197157);
        return;
      }
    }
    AppMethodBeat.o(197157);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(197169);
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if (localb != null)
    {
      localb.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(197169);
      return;
    }
    AppMethodBeat.o(197169);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(197178);
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if ((localb != null) && (localb.onBackPressed() == true))
    {
      AppMethodBeat.o(197178);
      return true;
    }
    AppMethodBeat.o(197178);
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(197185);
    Log.i(TAG, "onBeforeFinish");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if (localb != null)
    {
      localb.onBeforeFinish(paramIntent);
      AppMethodBeat.o(197185);
      return;
    }
    AppMethodBeat.o(197185);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(197176);
    p.k(paramConfiguration, "newConfig");
    a.fcG();
    this.FMr = paramConfiguration.orientation;
    Object localObject;
    if ((paramConfiguration.orientation == 2) && (!fbW()))
    {
      in(false);
      localObject = this.FMi;
      if ((localObject != null) && (((com.tencent.mm.plugin.multitask.ui.base.b)localObject).fbq() == true)) {
        a(this, false, false, false, false, false, true, false, 192);
      }
    }
    for (;;)
    {
      localObject = this.FMk;
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(197176);
      return;
      in(true);
    }
    AppMethodBeat.o(197176);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197146);
    super.onCreate(paramBundle);
    this.FMA.alive();
    AppMethodBeat.o(197146);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(197145);
    Log.i(TAG, "onCreateBefore");
    this.FLl = paramBundle;
    AppMethodBeat.o(197145);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(197166);
    Log.i(TAG, "onDestroy, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(fbW()) });
    ??? = this.FMk;
    if (??? != null) {
      ((com.tencent.mm.plugin.multitask.ui.panel.b)???).onDestroy();
    }
    this.FMA.dead();
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.FMi;
    com.tencent.mm.plugin.multitask.ui.base.b.b localb1;
    if (localb != null) {
      localb1 = (com.tencent.mm.plugin.multitask.ui.base.b.b)this;
    }
    synchronized (localb.FJn)
    {
      localb.FJn.remove(localb1);
      ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).setListener(null);
      ??? = this.FMz;
      if (??? != null) {
        ((DynamicBgContainer)???).release();
      }
      this.knk.removeCallbacksAndMessages(null);
      AppMethodBeat.o(197166);
      return;
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(197179);
    p.k(paramKeyEvent, "event");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if ((localb != null) && (localb.onKeyDown(paramInt, paramKeyEvent) == true))
    {
      AppMethodBeat.o(197179);
      return true;
    }
    AppMethodBeat.o(197179);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(197181);
    p.k(paramKeyEvent, "event");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if ((localb != null) && (localb.onKeyUp(paramInt, paramKeyEvent) == true))
    {
      AppMethodBeat.o(197181);
      return true;
    }
    AppMethodBeat.o(197181);
    return false;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(197159);
    Log.i(TAG, "onPause, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(fbW()) });
    if (fbW())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
      if (localb != null) {
        localb.onPause();
      }
      fbZ();
    }
    vp(false);
    AppMethodBeat.o(197159);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(197170);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if (localb != null)
    {
      localb.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(197170);
      return;
    }
    AppMethodBeat.o(197170);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(197148);
    Log.i(TAG, "onRestoreInstanceState");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if (localb != null)
    {
      localb.onRestoreInstanceState(paramBundle);
      AppMethodBeat.o(197148);
      return;
    }
    AppMethodBeat.o(197148);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(197152);
    Log.i(TAG, "onResume, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(fbW()) });
    if (fbW())
    {
      Object localObject = this.FMk;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).onResume();
      }
      if ((this.FMk != null) && (!fcc())) {
        fcb();
      }
      localObject = this.FMk;
      if (localObject != null)
      {
        g localg = g.FEX;
        localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bI(0, g.fam());
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
            AppMethodBeat.o(197152);
            throw ((Throwable)localObject);
          }
          ((b)localObject).fbS();
        }
      }
      fbX();
    }
    for (;;)
    {
      vp(true);
      AppMethodBeat.o(197152);
      return;
      fcd();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(197147);
    Log.i(TAG, "onSaveInstanceState");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
    if (localb != null)
    {
      localb.onSaveInstanceState(paramBundle);
      AppMethodBeat.o(197147);
      return;
    }
    AppMethodBeat.o(197147);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(197149);
    Log.i(TAG, "onStart, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(fbW()) });
    if (fbW())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
      if (localb != null)
      {
        localb.onStart();
        AppMethodBeat.o(197149);
        return;
      }
    }
    AppMethodBeat.o(197149);
  }
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop()
  {
    AppMethodBeat.i(197162);
    Log.i(TAG, "onStop, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(fbW()) });
    if (fbW())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FMk;
      if (localb != null) {
        localb.onStop();
      }
      fbZ();
    }
    AppMethodBeat.o(197162);
  }
  
  public final void vo(final boolean paramBoolean)
  {
    AppMethodBeat.i(197132);
    Log.i(TAG, "hideSnapshotUIC, remove:".concat(String.valueOf(paramBoolean)));
    Object localObject = this.FMk;
    if (localObject != null)
    {
      g localg = g.FEX;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bI(1048576, g.fan());
      if (localObject != null)
      {
        if ((localObject instanceof d))
        {
          ((d)localObject).fcL();
          ((d)localObject).fcK();
          if (paramBoolean) {
            com.tencent.e.h.ZvG.bc((Runnable)new e(this, paramBoolean));
          }
        }
        AppMethodBeat.o(197132);
        return;
      }
    }
    AppMethodBeat.o(197132);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$Companion;", "", "()V", "HOME_EXPOSE_WIDTH", "", "getHOME_EXPOSE_WIDTH", "()I", "setHOME_EXPOSE_WIDTH", "(I)V", "MIN_ENTER_DRAG_TIP_SHOW_FRACTOR", "", "getMIN_ENTER_DRAG_TIP_SHOW_FRACTOR", "()F", "setMIN_ENTER_DRAG_TIP_SHOW_FRACTOR", "(F)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TIPS_TRANS_WIDTH", "getTIPS_TRANS_WIDTH", "setTIPS_TRANS_WIDTH", "_2A", "get_2A", "set_2A", "_2_5A", "get_2_5A", "set_2_5A", "canvasHeight", "getCanvasHeight", "setCanvasHeight", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "font_size", "getFont_size", "setFont_size", "image_scale", "getImage_scale", "setImage_scale", "itemButtomPadding", "getItemButtomPadding", "setItemButtomPadding", "itemHeaderHeight", "getItemHeaderHeight", "setItemHeaderHeight", "itemHeight", "getItemHeight", "setItemHeight", "itemHoritonalPadding", "getItemHoritonalPadding", "setItemHoritonalPadding", "itemImgHeight", "getItemImgHeight", "setItemImgHeight", "itemImgWidth", "getItemImgWidth", "setItemImgWidth", "itemTitleHeight", "getItemTitleHeight", "setItemTitleHeight", "itemWidth", "getItemWidth", "setItemWidth", "oneItemContentHeight", "getOneItemContentHeight", "setOneItemContentHeight", "oneItemContentWidth", "getOneItemContentWidth", "setOneItemContentWidth", "oneItemFromLeft", "getOneItemFromLeft", "setOneItemFromLeft", "oneItemFromTop", "getOneItemFromTop", "setOneItemFromTop", "oneItemImgHeight", "getOneItemImgHeight", "setOneItemImgHeight", "oneItemImgWidth", "getOneItemImgWidth", "setOneItemImgWidth", "portraitHeight", "getPortraitHeight", "setPortraitHeight", "portraitWidth", "getPortraitWidth", "setPortraitWidth", "scale", "getScale", "setScale", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "twoItemFromLeft", "getTwoItemFromLeft", "setTwoItemFromLeft", "twoItemFromTop", "getTwoItemFromTop", "setTwoItemFromTop", "initMultiTaskViewParams", "", "screenSizeW", "screenSizeH", "ui-multitask_release"})
  public static final class a
  {
    public static void fcG()
    {
      AppMethodBeat.i(196895);
      is(com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()), com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()));
      AppMethodBeat.o(196895);
    }
    
    public static void is(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196901);
      com.tencent.mm.plugin.multitask.ui.base.b.a locala = com.tencent.mm.plugin.multitask.ui.base.b.FJL;
      c.YJ(com.tencent.mm.plugin.multitask.ui.base.b.fbv());
      c.Yr(paramInt1);
      c.Ys(paramInt2);
      c.Yp(Math.min(c.fch(), c.fci()));
      c.Yq(Math.max(c.fch(), c.fci()));
      c.Yt(c.fch() * 2 - c.fcy());
      c.Yu(c.fci());
      c.bH(aw.fromDPToPix(MMApplicationContext.getContext(), 59) / c.fcf());
      c.Yv(aw.fromDPToPix(MMApplicationContext.getContext(), 12));
      c.Yw(aw.fromDPToPix(MMApplicationContext.getContext(), 14));
      c.Yx(aw.fromDPToPix(MMApplicationContext.getContext(), 20));
      c.YL(aw.fromDPToPix(MMApplicationContext.getContext(), 44));
      c.YK(aw.fromDPToPix(MMApplicationContext.getContext(), 32) - c.fcj());
      c.Yy(kotlin.h.a.dm((c.fcf() - c.fcy() - c.fck() * 2) / 2.0F));
      c.YC(c.fcm() - c.fcj());
      c.YD(kotlin.h.a.dm(c.fcq() * c.fcF()));
      c.bI((c.fcr() + c.fcj() + c.fcz() + c.fcA() * c.fcD() + aw.fromDPToPix(MMApplicationContext.getContext(), 16)) / c.fcm());
      c.Yz(kotlin.h.a.dm(c.fcm() * c.fcE()));
      c.YA(kotlin.h.a.dm(c.fcm() * 1.5F));
      c.YB(kotlin.h.a.dm(c.fco() * c.fcE()));
      c.YE(c.fco() - c.fcj());
      c.YF(kotlin.h.a.dm(c.fcs() * c.fcF()));
      c.YG(kotlin.h.a.M((c.fcg() - c.fcp() - c.fcj() * 6) / 2.0D));
      if (c.fcu() < 0) {
        c.YG(0);
      }
      c.YH(kotlin.h.a.M((c.fcf() - c.fcy() - c.fco()) / 2.0D - c.fck()));
      c.fcw();
      c.YI(kotlin.h.a.M((c.fcg() - c.fcn() - c.fcj() * 8) / 2.0D));
      Log.i(c.access$getTAG$cp(), "initMultiTaskViewParams width:" + c.fcm() + " height:" + c.fcn() + " oneItemContentWidth:" + c.fco() + " oneItemContentHeight:" + c.fcp());
      AppMethodBeat.o(196901);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "", "getCurrentTabIndex", "", "isChattingForeground", "", "isHeaderOpen", "multiTaskStateChanged", "", "state", "curIndex", "multiTaskTabChanged", "ui-multitask_release"})
  public static abstract interface b
  {
    public abstract void YM(int paramInt);
    
    public abstract void YN(int paramInt);
    
    public abstract boolean fcH();
    
    public abstract boolean fcI();
    
    public abstract int getCurrentTabIndex();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(c paramc) {}
    
    public final void run()
    {
      int i = 0;
      AppMethodBeat.i(197474);
      c localc = this.FNd;
      Object localObject = com.tencent.mm.plugin.multitask.e.b.FHS;
      com.tencent.mm.plugin.multitask.e.b.vn(false);
      localObject = localc.FMq;
      if (localObject != null)
      {
        if (((c.b)localObject).fcI())
        {
          Log.i(c.TAG, "[enterTips]chatting is foreground, skip!, step 2");
          AppMethodBeat.o(197474);
          return;
        }
        if (((c.b)localObject).fcH())
        {
          Log.i(c.TAG, "[enterTips]header is open, skip!, step 2");
          AppMethodBeat.o(197474);
          return;
        }
        if (((c.b)localObject).getCurrentTabIndex() != 0)
        {
          Log.i(c.TAG, "[enterTips]tab is not mainUI, skip!, step 2");
          AppMethodBeat.o(197474);
          return;
        }
      }
      if (localc.fbW())
      {
        Log.i(c.TAG, "[enterTips]inMultiTaskPanel, skip!, step 2");
        AppMethodBeat.o(197474);
        return;
      }
      localObject = localc.FMi;
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.multitask.ui.base.b)localObject).getPanelState() == b.c.FJN) {
          i = 1;
        }
        if (i == 0)
        {
          Log.i(c.TAG, "[enterTips]is not collapsed, skip!, step 2");
          AppMethodBeat.o(197474);
          return;
        }
      }
      if (localc.isDataEmpty())
      {
        Log.i(c.TAG, "[enterTips]data is empty, skip!, step 2");
        AppMethodBeat.o(197474);
        return;
      }
      Log.i(c.TAG, "[enterTips] show!");
      if (localc.FMv != null)
      {
        c.FMY = kotlin.h.a.dm(c.pEj * c.FMZ);
        localc.FMx = true;
        localc.FMy = true;
        localObject = localc.FMi;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).setAnchorPoint(c.FMZ);
        }
        localObject = localc.FMi;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).a(b.c.FJO, 300L, true);
        }
        localObject = com.tencent.mm.plugin.multitask.e.b.FHS;
        com.tencent.mm.plugin.multitask.e.b.fbj();
        localc.Ym(1);
      }
      AppMethodBeat.o(197474);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$1$1$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "ui-multitask_release", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$$special$$inlined$let$lambda$1"})
  public static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.plugin.multitask.ui.base.b paramb, c paramc, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197485);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = jdField_this.FMi;
      boolean bool2;
      boolean bool1;
      if (paramView != null)
      {
        if (paramView.fbq() != true) {
          break label113;
        }
        bool2 = true;
        bool1 = false;
      }
      for (;;)
      {
        jdField_this.a(true, true, false, false, false, bool1, false, bool2);
        if (bool2) {
          jdField_this.Yn(1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(197485);
        return;
        bool2 = false;
        bool1 = true;
        continue;
        label113:
        bool2 = false;
        bool1 = true;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$hideSnapshotUIC$1$1"})
  static final class e
    implements Runnable
  {
    e(c paramc, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(197558);
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.FNd.FMk;
      if (localb != null)
      {
        g localg = g.FEX;
        localb.aRd(g.fan());
      }
      this.FNd.in(true);
      AppMethodBeat.o(197558);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "ui-multitask_release"})
  public static final class f
    extends IListener<lk>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.c
 * JD-Core Version:    0.7.0.1
 */