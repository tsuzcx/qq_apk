package com.tencent.mm.plugin.multitask.ui.uic;

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
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.PluginMultiTask.b;
import com.tencent.mm.plugin.multitask.animation.c.a.c.a;
import com.tencent.mm.plugin.multitask.animation.c.a.c.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.base.b.b;
import com.tencent.mm.plugin.multitask.ui.base.b.c;
import com.tencent.mm.plugin.multitask.ui.base.b.d;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.s;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionEnterType", "", "getActionEnterType", "()I", "setActionEnterType", "(I)V", "actionExitType", "getActionExitType", "setActionExitType", "callback", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "getCallback", "()Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "setCallback", "(Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;)V", "currentTabIndex", "delayHideDynamicBgRunnable", "Ljava/lang/Runnable;", "dynamicBgContainer", "Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "gradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "homeTabChangedListener", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1;", "isDynamicBgShow", "", "launcherContainer", "Landroid/view/View;", "getLauncherContainer", "()Landroid/view/View;", "setLauncherContainer", "(Landroid/view/View;)V", "mOriention", "getMOriention", "setMOriention", "multiTaskIcon", "Landroid/widget/ImageView;", "getMultiTaskIcon", "()Landroid/widget/ImageView;", "setMultiTaskIcon", "(Landroid/widget/ImageView;)V", "onCreateInstanceState", "Landroid/os/Bundle;", "panelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "getPanelView", "()Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "setPanelView", "(Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;)V", "parentPanelLayoutWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "getParentPanelLayoutWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "setParentPanelLayoutWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "parentViewPager", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getParentViewPager", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setParentViewPager", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "playSound", "getPlaySound", "setPlaySound", "realPanelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkShowLoading", "checkShowSnapshotIfNeed", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "size", "forceHide", "forceShow", "checkTeenMode", "multiTaskType", "createMultiTaskPanelView", "createPanelView", "delayHideDynamicBg", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "enableExpand", "enableScroll", "enable", "enterFullScreenMode", "exitFullScreenMode", "getMultiTaskItemPosition", "", "id", "curPos", "way", "hasCurrentMultiInfo", "hideDynamicBg", "hideSnapshotUIC", "remove", "inMultiTaskPanel", "initEnterReport", "initExitReport", "isDataEmpty", "isShowSnapshotUIC", "jumpSnapshotUIC", "markWechatForeground", "foreground", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "onKeyUp", "onMultiTaskPageSelected", "position", "onPanelItemSelected", "panel", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPause", "onPlaySound", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "requestOrientation", "saveHomeSnapBlt", "showHome", "smoothScroll", "fromClick", "fromSwipe", "showPanel", "showSnapshotUIC", "switchToDynamicBg", "switchToStaticBg", "delay", "updateLoadingMode", "loadingMode", "Companion", "MultiTaskCallback", "ui-multitask_release"})
public final class MultiTaskUIC
  extends UIComponent
  implements PluginMultiTask.b, b.b
{
  private static int AfR = 0;
  private static int AfS = 0;
  private static int AfT = 0;
  private static int AfU = 0;
  private static int AfV = 0;
  private static int AfW = 0;
  private static int AfX = 0;
  private static int AfY = 0;
  private static int AfZ = 0;
  private static int Aga = 0;
  private static int Agb = 0;
  private static int Agc = 0;
  private static int Agd = 0;
  private static int Age = 0;
  private static int Agf = 0;
  private static int Agg = 0;
  private static int Agh = 0;
  private static int Agi = 0;
  private static int Agj = 0;
  private static int Agk = 0;
  private static int Agl = 0;
  private static float Agm = 0.0F;
  private static float Agn = 0.0F;
  public static final a Ago;
  public static final String TAG = "MicroMsg.MultiTask.MultiTaskUIC";
  private static int kn;
  private static int mEX;
  private static int mEY;
  private static int qmd;
  private static float scale;
  private GradientColorBackgroundView AdB;
  private Bundle AeI;
  public CustomViewPager AfB;
  public com.tencent.mm.plugin.multitask.ui.base.b AfC;
  private View AfD;
  public com.tencent.mm.plugin.multitask.ui.panel.b AfE;
  private ImageView AfF;
  public int AfG;
  private int AfH;
  private b AfI;
  private int AfJ;
  private int AfK;
  private int AfL;
  public MultiTaskContainerView AfM;
  private DynamicBgContainer AfN;
  private final MultiTaskUIC.e AfO;
  private Runnable AfP;
  private boolean AfQ;
  private final MMHandler hAk;
  
  static
  {
    AppMethodBeat.i(236694);
    Ago = new a((byte)0);
    TAG = "MicroMsg.MultiTask.MultiTaskUIC";
    Agm = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
    scale = 1.666667F;
    Agn = 1.333333F;
    AppMethodBeat.o(236694);
  }
  
  public MultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(236693);
    this.AfG = 4;
    this.AfH = 4;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.AfO = new MultiTaskUIC.e(this);
    AppMethodBeat.o(236693);
  }
  
  public static boolean RU(int paramInt)
  {
    AppMethodBeat.i(236677);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)locala).Vt();
    locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    int i = ((com.tencent.mm.plugin.teenmode.a.b)locala).fvp();
    locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    int j = ((com.tencent.mm.plugin.teenmode.a.b)locala).fvo();
    locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    int k = ((com.tencent.mm.plugin.teenmode.a.b)locala).dxW();
    Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d, bizAcctOption: %d, finderOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if ((bool) && (((i == 2) && (paramInt == 1)) || ((j == 2) && (paramInt == 2)) || ((k == 2) && (paramInt == 22))))
    {
      AppMethodBeat.o(236677);
      return true;
    }
    AppMethodBeat.o(236677);
    return false;
  }
  
  private final void erP()
  {
    AppMethodBeat.i(236652);
    if (!erO())
    {
      SharedPreferences localSharedPreferences = getActivity().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      p.g(localSharedPreferences, "activity.getSharedPrefer…faultPreferencePath(), 0)");
      Log.i(TAG, "set ScreenOrientation，now is ： %s", new Object[] { Boolean.valueOf(localSharedPreferences.getBoolean("settings_landscape_mode", false)) });
      if (localSharedPreferences.getBoolean("settings_landscape_mode", false))
      {
        getActivity().setRequestedOrientation(-1);
        AppMethodBeat.o(236652);
        return;
      }
      getActivity().setRequestedOrientation(1);
      AppMethodBeat.o(236652);
      return;
    }
    getActivity().setRequestedOrientation(1);
    AppMethodBeat.o(236652);
  }
  
  private boolean erQ()
  {
    AppMethodBeat.i(236654);
    if (!erO())
    {
      AppMethodBeat.o(236654);
      return true;
    }
    AppMethodBeat.o(236654);
    return false;
  }
  
  private void erR()
  {
    AppMethodBeat.i(236663);
    if (!this.AfQ)
    {
      AppMethodBeat.o(236663);
      return;
    }
    Log.i(TAG, "virbg: switchToStaticBg");
    this.AfQ = false;
    if ((this.AfN != null) && (!DynamicBgContainer.erw()))
    {
      GradientColorBackgroundView localGradientColorBackgroundView = this.AdB;
      if (localGradientColorBackgroundView != null) {
        localGradientColorBackgroundView.setVisibility(0);
      }
      localGradientColorBackgroundView = this.AdB;
      if (localGradientColorBackgroundView != null) {
        localGradientColorBackgroundView.setAlpha(1.0F);
      }
    }
    erS();
    AppMethodBeat.o(236663);
  }
  
  private final void erS()
  {
    AppMethodBeat.i(236664);
    DynamicBgContainer localDynamicBgContainer = this.AfN;
    if (localDynamicBgContainer != null)
    {
      localDynamicBgContainer.ery();
      AppMethodBeat.o(236664);
      return;
    }
    AppMethodBeat.o(236664);
  }
  
  private void erV()
  {
    AppMethodBeat.i(236674);
    Object localObject1 = this.AfE;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aGP(com.tencent.mm.plugin.multitask.g.eqx());
      if (localObject1 != null)
      {
        localObject2 = this.AfE;
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
          localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
          if (localObject2 != null)
          {
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
              AppMethodBeat.o(236674);
              throw ((Throwable)localObject1);
            }
            localObject2 = (MultiTaskMinusScreenUIC)localObject2;
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
              AppMethodBeat.o(236674);
              throw ((Throwable)localObject1);
            }
            if (!MultiTaskMinusScreenUIC.a((MultiTaskMinusScreenUIC)localObject2, ((SnapShotMultiTaskUIC)localObject1).Agu, false)) {
              break label153;
            }
            ((SnapShotMultiTaskUIC)localObject1).erV();
          }
        }
        while (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
          AppMethodBeat.o(236674);
          throw ((Throwable)localObject1);
          label153:
          sk(false);
        }
        ((SnapShotMultiTaskUIC)localObject1).esA();
        hx(true);
        AppMethodBeat.o(236674);
        return;
      }
    }
    sk(false);
    AppMethodBeat.o(236674);
  }
  
  private void erW()
  {
    AppMethodBeat.i(236676);
    try
    {
      Object localObject1 = this.AfD;
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.ui.n.a.a(this.AfD, ((View)localObject1).getWidth(), ((View)localObject1).getHeight(), Bitmap.Config.RGB_565);
        if (localObject1 != null)
        {
          Object localObject2 = com.tencent.mm.plugin.multitask.h.zZn;
          localObject2 = com.tencent.mm.plugin.multitask.h.eqA();
          if (s.YS((String)localObject2)) {
            s.deleteFile((String)localObject2);
          }
          BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.JPEG, (String)localObject2, true);
        }
        AppMethodBeat.o(236676);
        return;
      }
      AppMethodBeat.o(236676);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(TAG, "snapshot bitmap failed", new Object[] { localThrowable });
      AppMethodBeat.o(236676);
    }
  }
  
  public final void RQ(int paramInt)
  {
    AppMethodBeat.i(236662);
    Log.i(TAG, "onPanelItemSelected, position:".concat(String.valueOf(paramInt)));
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramInt == 0) {
      if (this.AfE != null)
      {
        localObject1 = SecDataUIC.CWq;
        localObject1 = (crt)SecDataUIC.a.a((Context)getActivity(), 5, crt.class);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
          com.tencent.mm.plugin.multitask.d.a.clear();
          localObject2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
          ((crt)localObject1).sGQ = com.tencent.mm.plugin.multitask.d.a.erj();
          ((crt)localObject1).viC = cl.aWA();
          ((crt)localObject1).MwO = new crp();
          ((crt)localObject1).MwN = new crr();
          ((crt)localObject1).MwP = new crs();
          ((crt)localObject1).MwP.hlf = 1L;
          if (this.AfG == 4) {
            this.AfG = 1;
          }
          ((crt)localObject1).MwP.MwJ = this.AfG;
          localObject2 = this.AfI;
          if (localObject2 != null)
          {
            localObject3 = ((crt)localObject1).MwP;
            localObject4 = com.tencent.mm.plugin.multitask.d.a.AbZ;
            ((crs)localObject3).igp = com.tencent.mm.plugin.multitask.d.a.RN(((b)localObject2).getCurrentTabIndex());
          }
          localObject2 = ((crt)localObject1).MwP;
          if (erU()) {}
          for (long l = 1L;; l = 2L)
          {
            ((crs)localObject2).MwK = l;
            ((crt)localObject1).MwP.duration = 0L;
            localObject2 = this.AfE;
            if (localObject2 == null) {
              break label316;
            }
            localObject3 = com.tencent.mm.plugin.multitask.g.zZj;
            localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
            if (localObject2 == null) {
              break label316;
            }
            localObject3 = ((crt)localObject1).MwP;
            if (localObject2 != null) {
              break;
            }
            localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
            AppMethodBeat.o(236662);
            throw ((Throwable)localObject1);
          }
          ((crs)localObject3).MwL = ((MultiTaskMinusScreenUIC)localObject2).getTaskCount();
          label316:
          localObject2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
          com.tencent.mm.plugin.multitask.d.a.b((crt)localObject1);
          Log.d(TAG, "report pageEnterAction, contextid:%s, action:%d, useraction:%d, scene:%d, fullscreen:%d, duration:%d", new Object[] { ((crt)localObject1).sGQ, Long.valueOf(((crt)localObject1).MwP.hlf), Long.valueOf(((crt)localObject1).MwP.MwJ), Long.valueOf(((crt)localObject1).MwP.igp), Long.valueOf(((crt)localObject1).MwP.MwK), Long.valueOf(((crt)localObject1).MwP.duration) });
          this.AfG = 4;
        }
      }
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        localObject1 = this.AfE;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).erG();
        }
        if (!erU())
        {
          localObject1 = this.AfE;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
            if (localObject1 != null)
            {
              if (localObject1 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                AppMethodBeat.o(236662);
                throw ((Throwable)localObject1);
                if (paramInt != 1) {
                  continue;
                }
                localObject1 = this.AfE;
                if (localObject1 == null) {
                  continue;
                }
                Log.i(TAG, "initExitReport, start");
                localObject2 = SecDataUIC.CWq;
                localObject1 = (crt)SecDataUIC.a.a((Context)((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).tUQ, 5, crt.class);
                if (localObject1 == null) {
                  continue;
                }
                localObject2 = ((crt)localObject1).MwP;
                if (localObject2 == null) {
                  continue;
                }
                ((crs)localObject2).hlf = 2L;
                if (this.AfH == 4) {
                  this.AfH = 1;
                }
                ((crs)localObject2).MwJ = this.AfH;
                localObject3 = this.AfE;
                if (localObject3 != null)
                {
                  localObject4 = com.tencent.mm.plugin.multitask.g.zZj;
                  localObject3 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject3).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
                  if (localObject3 != null)
                  {
                    if (localObject3 == null)
                    {
                      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                      AppMethodBeat.o(236662);
                      throw ((Throwable)localObject1);
                    }
                    ((crs)localObject2).MwL = ((MultiTaskMinusScreenUIC)localObject3).getTaskCount();
                  }
                }
                if (cl.aWA() >= ((crt)localObject1).viC)
                {
                  ((crs)localObject2).duration += cl.aWA() - ((crt)localObject1).viC;
                  localObject2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                  com.tencent.mm.plugin.multitask.d.a.b((crt)localObject1);
                  Log.i(TAG, "report pageExitAction, contextid:%s, action:%d, useraction:%d, scene:%d, fullscreen:%d, duration:%d", new Object[] { ((crt)localObject1).sGQ, Long.valueOf(((crt)localObject1).MwP.hlf), Long.valueOf(((crt)localObject1).MwP.MwJ), Long.valueOf(((crt)localObject1).MwP.igp), Long.valueOf(((crt)localObject1).MwP.MwK), Long.valueOf(((crt)localObject1).MwP.duration) });
                }
                for (;;)
                {
                  this.AfH = 4;
                  break;
                  Log.i(TAG, "report pageExitAction, error");
                }
              }
              ((MultiTaskMinusScreenUIC)localObject1).erK();
              Log.i(TAG, "triggerExposed!");
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.AfI;
      if (localObject1 != null) {
        ((b)localObject1).akq(paramInt);
      }
      if (erO()) {
        break label1007;
      }
      localObject1 = this.AfN;
      if (localObject1 != null) {
        ((DynamicBgContainer)localObject1).erv();
      }
      erR();
      erV();
      localObject1 = this.AfE;
      if (localObject1 == null) {
        break label983;
      }
      localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
      if (localObject1 == null) {
        break label983;
      }
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
      AppMethodBeat.o(236662);
      throw ((Throwable)localObject1);
      localObject1 = this.AfE;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).dkr();
      }
    }
    ((MultiTaskMinusScreenUIC)localObject1).erL();
    label983:
    label1502:
    label1508:
    for (;;)
    {
      d.a(250L, (kotlin.g.a.a)new f(this));
      AppMethodBeat.o(236662);
      return;
      label1007:
      if (erO())
      {
        localObject1 = this.AfF;
        if (localObject1 != null) {
          ((ImageView)localObject1).setAlpha(0.0F);
        }
        localObject1 = this.AfE;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
          localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bK(1048576, com.tencent.mm.plugin.multitask.g.eqx());
          if (localObject1 != null)
          {
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
              AppMethodBeat.o(236662);
              throw ((Throwable)localObject1);
            }
            if (!((SnapShotMultiTaskUIC)localObject1).bJw())
            {
              Log.i(TAG, "jumpSnapshotUIC, is already hide");
              localObject1 = this.AfE;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).AeG;
                if (localObject1 != null)
                {
                  localObject1 = ((MultiTaskUIComponent)localObject1).dks();
                  label1141:
                  if (localObject1 == a.b.Acg)
                  {
                    localObject1 = this.AfE;
                    if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).AeG instanceof MultiTaskMinusScreenUIC != true)) {}
                  }
                  else
                  {
                    erT();
                  }
                }
              }
            }
            for (;;)
            {
              localObject1 = this.AfE;
              if (localObject1 == null) {
                break;
              }
              localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
              localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
              if (localObject1 == null) {
                break;
              }
              if (localObject1 != null) {
                break label1792;
              }
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
              AppMethodBeat.o(236662);
              throw ((Throwable)localObject1);
              localObject1 = null;
              break label1141;
              localObject2 = this.AfE;
              if (localObject2 != null)
              {
                localObject3 = com.tencent.mm.plugin.multitask.g.zZj;
                localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
                if (localObject2 != null)
                {
                  ((SnapShotMultiTaskUIC)localObject1).esz();
                  if (localObject2 == null)
                  {
                    localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                    AppMethodBeat.o(236662);
                    throw ((Throwable)localObject1);
                  }
                  localObject3 = (MultiTaskMinusScreenUIC)localObject2;
                  localObject4 = ((SnapShotMultiTaskUIC)localObject1).Agu;
                  if (((MultiTaskMinusScreenUIC)localObject3).Afn.size() == 0) {
                    Log.i(MultiTaskMinusScreenUIC.TAG, "jumpUICFormSnapshot, empty data");
                  }
                  do
                  {
                    do
                    {
                      do
                      {
                        hx(false);
                        Log.i(TAG, "jumpSnapshotUIC, show now!");
                        break;
                        if (((MultiTaskMinusScreenUIC)localObject3).Afn.size() != 1) {
                          break label1508;
                        }
                        localObject1 = ((MultiTaskMinusScreenUIC)localObject3).Afn.get(0);
                        p.g(localObject1, "multiTaskInfoList.get(0)");
                        localObject4 = (com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject1;
                        localObject1 = ((MultiTaskMinusScreenUIC)localObject3).ufR;
                        if (localObject1 == null) {
                          break label1490;
                        }
                        localObject1 = ((WxRecyclerView)localObject1).ch(1);
                        localObject3 = ((MultiTaskMinusScreenUIC)localObject3).Afp;
                      } while (localObject3 == null);
                      if (localObject1 != null)
                      {
                        localObject2 = ((RecyclerView.v)localObject1).aus;
                        if (localObject2 != null)
                        {
                          localObject2 = ((View)localObject2).findViewById(2131305006);
                          if (localObject1 == null) {
                            break label1502;
                          }
                        }
                      }
                      for (localObject1 = ((RecyclerView.v)localObject1).aus;; localObject1 = null)
                      {
                        ((MultiTaskMinusScreenUIC.b)localObject3).a((View)localObject2, (View)localObject1, 0, ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject4).Aen, false);
                        break;
                        localObject1 = null;
                        break label1418;
                        localObject2 = null;
                        break label1457;
                      }
                    } while (localObject4 == null);
                    paramInt = ((MultiTaskMinusScreenUIC)localObject3).aGQ(((MultiTaskInfo)localObject4).field_id);
                    localObject1 = ((MultiTaskMinusScreenUIC)localObject3).ufR;
                    if (localObject1 == null) {
                      break label1647;
                    }
                    localObject2 = ((WxRecyclerView)localObject1).ch(paramInt + 1);
                    if (((MultiTaskMinusScreenUIC)localObject3).Afn.size() > 2) {
                      break label1659;
                    }
                    localObject1 = ((MultiTaskMinusScreenUIC)localObject3).ufR;
                    if (localObject1 == null) {
                      break label1653;
                    }
                    localObject1 = ((WxRecyclerView)localObject1).ch(1);
                    if (localObject1 == null) {
                      break label1653;
                    }
                    localObject1 = ((RecyclerView.v)localObject1).aus;
                    if (localObject1 == null) {
                      break label1653;
                    }
                    localObject1 = ((View)localObject1).findViewById(2131305006);
                    localObject3 = ((MultiTaskMinusScreenUIC)localObject3).Afp;
                  } while (localObject3 == null);
                  if (localObject2 != null) {}
                  for (localObject2 = ((RecyclerView.v)localObject2).aus;; localObject2 = null)
                  {
                    ((MultiTaskMinusScreenUIC.b)localObject3).a((View)localObject1, (View)localObject2, paramInt, (MultiTaskInfo)localObject4, false);
                    break;
                    label1647:
                    localObject2 = null;
                    break label1546;
                    label1653:
                    localObject1 = null;
                    break label1605;
                    label1659:
                    localObject1 = ((MultiTaskMinusScreenUIC)localObject3).getRootView().findViewById(2131305002);
                    break label1605;
                  }
                }
              }
              ((SnapShotMultiTaskUIC)localObject1).esB();
              ((SnapShotMultiTaskUIC)localObject1).esA();
              hx(true);
              erT();
              Log.i(TAG, "jumpSnapshotUIC, hide now!");
            }
          }
        }
        localObject1 = this.AfE;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).AeG;
          if (localObject1 == null) {}
        }
        for (localObject1 = ((MultiTaskUIComponent)localObject1).dks();; localObject1 = null)
        {
          if (localObject1 == a.b.Acg)
          {
            localObject1 = this.AfE;
            if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).AeG instanceof MultiTaskMinusScreenUIC != true)) {
              break;
            }
          }
          erT();
          break;
        }
        ((MultiTaskMinusScreenUIC)localObject1).erL();
      }
    }
  }
  
  public final void RT(int paramInt)
  {
    AppMethodBeat.i(236670);
    Log.i(TAG, "updateLoadingMode, loadingMode:".concat(String.valueOf(paramInt)));
    MultiTaskContainerView localMultiTaskContainerView = this.AfM;
    if (localMultiTaskContainerView != null)
    {
      localMultiTaskContainerView.RT(paramInt);
      AppMethodBeat.o(236670);
      return;
    }
    AppMethodBeat.o(236670);
  }
  
  public final View a(View paramView, DynamicBgContainer arg2, b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(236650);
    p.h(paramView, "launcherContainer");
    Log.i(TAG, "create panel launcher");
    this.AfD = paramView;
    this.AfN = ???;
    this.AdB = ???.getGradientBgView();
    ??? = this.AfN;
    if (??? != null) {
      ???.erv();
    }
    this.AfI = paramb;
    ??? = getActivity().getSupportActionBar();
    if (??? != null)
    {
      ??? = ???.getCustomView();
      if (??? == null) {}
    }
    for (??? = (ImageView)???.findViewById(2131296449);; ??? = null)
    {
      this.AfF = ???;
      ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).registerMultiTaskUIC(2, WebMultiTaskUIC.class);
      ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).registerMultiTaskUIC(0, MultiTaskMinusScreenUIC.class);
      ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).registerMultiTaskUIC(1, AppBrandMultiTaskUIC.class);
      ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).registerMultiTaskUIC(1048576, SnapShotMultiTaskUIC.class);
      ??? = SecDataUIC.CWq;
      ??? = SecDataUIC.a.gU((Context)getActivity());
      if (??? != null) {
        ???.a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.b(j.listOf(new String[] { "WebViewUI", "WebviewMpUI", "FinderLongVideoTimelineUI", "NoteEditorUI", "MiniQBReaderUI", "AppAttachDownloadUI", "ChooseMsgFileShowUI", "TopStoryFSVideoUI", "TopStoryMultiTaskListVideoUI", "LuggageGameWebViewUI" }), crt.class));
      }
      ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).setListener((PluginMultiTask.b)this);
      if (this.AfC != null) {
        break label928;
      }
      paramb = new com.tencent.mm.plugin.multitask.ui.base.b((Context)getActivity());
      paramb.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      Log.i(TAG, "create panel view");
      a.esx();
      if (this.AfE == null) {
        this.AfE = new com.tencent.mm.plugin.multitask.ui.panel.b(getActivity(), this.AeI);
      }
      ??? = getActivity().getLayoutInflater().inflate(2131495763, null);
      if (??? != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(236650);
      throw paramView;
    }
    Object localObject2 = (FrameLayout)???;
    ??? = ((FrameLayout)localObject2).findViewById(2131305077);
    if (??? == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView");
      AppMethodBeat.o(236650);
      throw paramView;
    }
    this.AfM = ((MultiTaskContainerView)???);
    ((FrameLayout)localObject2).setDrawingCacheEnabled(false);
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.AfE;
    ??? = (DynamicBgContainer)localObject1;
    if (localb != null)
    {
      if (localb.AeF == null)
      {
        ??? = localb.tUQ.getLayoutInflater().inflate(2131495764, null);
        localb.AeE = ((MultiTaskPanelContainer)???.findViewById(2131304999));
        localObject1 = localb.AeE;
        if (localObject1 != null) {
          localb.a((MultiTaskPanelContainer)localObject1);
        }
        localb.AeF = ???;
      }
      ??? = localb.AeF;
    }
    ((FrameLayout)localObject2).addView(???, new ViewGroup.LayoutParams(-1, -1));
    ??? = (View)localObject2;
    if (??? != null)
    {
      localObject1 = com.tencent.mm.plugin.multitask.f.c.AgL;
      float f = com.tencent.mm.plugin.multitask.f.c.esE();
      Log.i(TAG, "slideFractor: ".concat(String.valueOf(f)));
      int i = (int)(f * (mEX - Agi));
      ???.setPadding(0, 0, i, 0);
      if ((??? != null) && (paramView != null))
      {
        paramb.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
        paramb.addView(???, 1, new ViewGroup.LayoutParams(-1, -1));
      }
      ??? = AnimationUtils.loadInterpolator(paramb.getContext(), 2130772093);
      localObject1 = com.tencent.mm.plugin.multitask.animation.c.a.c.Aaz;
      localObject1 = (ViewGroup)paramb;
      localObject2 = (c.a)new b.d(paramb);
      p.g(???, "interpolator");
      paramb.AaG = c.b.a((ViewGroup)localObject1, (c.a)localObject2, ???);
      ??? = paramb.getContext();
      if (??? != null)
      {
        ??? = ???.getResources();
        if (??? != null)
        {
          ??? = ???.getDisplayMetrics();
          if (??? == null) {}
        }
      }
      for (f = ???.density;; f = com.tencent.mm.cb.a.getDensity(paramb.getContext()))
      {
        ??? = paramb.AaG;
        if (??? != null) {
          ???.Aau = (100.0F * f);
        }
        ??? = paramb.AaG;
        if (??? != null) {
          ???.Aat = (f * 300.0F);
        }
        ??? = paramb.getContext().getSystemService("vibrator");
        if (??? != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type android.os.Vibrator");
        AppMethodBeat.o(236650);
        throw paramView;
      }
      paramb.ooM = ((Vibrator)???);
      paramb.setSlideLeft(false);
      paramb.setPanelWidth(mEX);
      paramb.setPanelExpose(Agi);
      paramb.setExtraSlideRange(i);
      if (!com.tencent.mm.ui.ao.isDarkMode()) {
        break label944;
      }
      paramb.setCoveredFadeColor(5066061);
    }
    for (;;)
    {
      paramb.setOverlayed(true);
      localObject1 = (b.b)this;
      synchronized (paramb.AcI)
      {
        paramb.AcI.add(localObject1);
        paramb.setFadeOnClickListener((View.OnClickListener)new MultiTaskUIC.c(paramb, this, paramView));
        paramb.setCurrentItem(1, false);
        this.AfC = paramb;
        label928:
        paramView = (View)this.AfC;
        AppMethodBeat.o(236650);
        return paramView;
        label944:
        paramb.setCoveredFadeColor(3618127);
      }
    }
  }
  
  public final void a(b.c paramc1, b.c paramc2)
  {
    AppMethodBeat.i(236661);
    Log.d(TAG, "onPanelStateChanged, previousState:" + paramc1 + ", newState:" + paramc2);
    int i;
    if ((paramc2 != paramc1) && (paramc2 == b.c.Adl))
    {
      if ((!erO()) && (!erU()) && (paramc1 == b.c.Adi)) {
        erT();
      }
      b localb = this.AfI;
      if (localb != null)
      {
        if (!erO()) {
          break label168;
        }
        i = 0;
        localb.aws(i);
      }
    }
    if ((paramc2 != paramc1) && (paramc2 == b.c.Adi))
    {
      paramc1 = this.AfN;
      if (paramc1 != null) {
        paramc1.erv();
      }
      erR();
    }
    for (;;)
    {
      if ((paramc2 == b.c.Adi) && (!isDataEmpty()))
      {
        paramc1 = this.AfF;
        if (paramc1 != null)
        {
          paramc1.setAlpha(1.0F);
          AppMethodBeat.o(236661);
          return;
          label168:
          i = 1;
          break;
          if (paramc2 == paramc1) {
            continue;
          }
          paramc1 = b.c.Adh;
          continue;
        }
        AppMethodBeat.o(236661);
        return;
      }
    }
    if (paramc2 == b.c.Adh)
    {
      paramc1 = this.AfF;
      if (paramc1 != null)
      {
        paramc1.setAlpha(0.0F);
        AppMethodBeat.o(236661);
        return;
      }
    }
    AppMethodBeat.o(236661);
  }
  
  public final boolean aGK(String paramString)
  {
    AppMethodBeat.i(236667);
    p.h(paramString, "id");
    Object localObject1 = this.AfE;
    int i;
    boolean bool;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(236667);
          throw paramString;
        }
        localObject1 = (MultiTaskMinusScreenUIC)localObject1;
        p.h(paramString, "id");
        localObject1 = ((Iterable)((MultiTaskMinusScreenUIC)localObject1).Afn).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            j.hxH();
          }
          if (((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject2).Aen.field_id.equals(paramString)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      Log.i(TAG, "hasCurrentMultiInfo, id:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(236667);
      return bool;
      i += 1;
      break;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void bB(float paramFloat)
  {
    AppMethodBeat.i(236656);
    Object localObject1 = this.AfE;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aGP(com.tencent.mm.plugin.multitask.g.eqx());
      if (localObject1 != null)
      {
        if ((localObject1 instanceof SnapShotMultiTaskUIC))
        {
          localObject1 = (SnapShotMultiTaskUIC)localObject1;
          if (((SnapShotMultiTaskUIC)localObject1).bJw())
          {
            int i = Agi;
            localObject2 = com.tencent.mm.plugin.multitask.f.a.AgJ;
            float f2 = 1.0F - (i + com.tencent.mm.plugin.multitask.f.a.esC()) / ((SnapShotMultiTaskUIC)localObject1).getRootView().getWidth();
            float f1 = 0.0F;
            if (paramFloat >= f2) {
              f1 = (paramFloat - f2) / (1.0F - f2);
            }
            i = Agi;
            localObject2 = com.tencent.mm.plugin.multitask.f.a.AgJ;
            paramFloat = -(i + com.tencent.mm.plugin.multitask.f.a.esC());
            i = Agi;
            localObject2 = com.tencent.mm.plugin.multitask.f.a.AgJ;
            f2 = i + com.tencent.mm.plugin.multitask.f.a.esC();
            ((SnapShotMultiTaskUIC)localObject1).getRootView().setTranslationX(paramFloat + f2 * f1);
            Log.d("MicroMsg.SnapShotMultiTaskUIC", "onPanelSlide, factor: %f", new Object[] { Float.valueOf(f1) });
          }
          AppMethodBeat.o(236656);
          return;
        }
        AppMethodBeat.o(236656);
        return;
      }
    }
    AppMethodBeat.o(236656);
  }
  
  public final void bC(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(236657);
    Object localObject = this.AfM;
    float f1;
    if (localObject != null)
    {
      f1 = ((MultiTaskContainerView)localObject).getWidth() * 0.18F;
      float f3 = (((MultiTaskContainerView)localObject).getWidth() - Agi) * paramFloat;
      if (f3 >= f1) {
        break label123;
      }
      f1 = f3 / f1;
      f1 = 1.0F - f1 * f1;
      localObject = this.AfF;
      if (localObject != null)
      {
        if (f1 >= 0.0F) {
          break label128;
        }
        f1 = f2;
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setAlpha(f1);
      if (!erQ()) {
        break label142;
      }
      localObject = this.AfM;
      if (localObject == null) {
        break label142;
      }
      ((MultiTaskContainerView)localObject).Vm = paramFloat;
      ((MultiTaskContainerView)localObject).invalidate();
      AppMethodBeat.o(236657);
      return;
      label123:
      f1 = 0.0F;
      break;
      label128:
      if (f1 > 1.0F) {
        f1 = 1.0F;
      }
    }
    label142:
    AppMethodBeat.o(236657);
  }
  
  public final boolean erO()
  {
    AppMethodBeat.i(236651);
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.AfC;
    if ((localb != null) && (localb.getCurItem() == 0))
    {
      AppMethodBeat.o(236651);
      return true;
    }
    AppMethodBeat.o(236651);
    return false;
  }
  
  public final void erT()
  {
    AppMethodBeat.i(236665);
    if ((this.AfQ) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.soT, 0) == 1))
    {
      AppMethodBeat.o(236665);
      return;
    }
    Log.i(TAG, "virbg: switchToDynamicBg");
    this.AfQ = true;
    if (this.AfP != null)
    {
      this.hAk.removeCallbacks(this.AfP);
      this.AfP = null;
    }
    DynamicBgContainer localDynamicBgContainer = this.AfN;
    if (localDynamicBgContainer != null)
    {
      localDynamicBgContainer.erz();
      AppMethodBeat.o(236665);
      return;
    }
    AppMethodBeat.o(236665);
  }
  
  public final boolean erU()
  {
    AppMethodBeat.i(236673);
    Object localObject = this.AfE;
    if (localObject != null)
    {
      com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bK(1048576, com.tencent.mm.plugin.multitask.g.eqx());
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
          AppMethodBeat.o(236673);
          throw ((Throwable)localObject);
        }
        boolean bool = ((SnapShotMultiTaskUIC)localObject).bJw();
        AppMethodBeat.o(236673);
        return bool;
      }
    }
    AppMethodBeat.o(236673);
    return false;
  }
  
  public final void err()
  {
    AppMethodBeat.i(236660);
    if (!erQ())
    {
      localObject = this.AfM;
      if (localObject != null) {
        ((MultiTaskContainerView)localObject).RT(0);
      }
    }
    Object localObject = this.AfE;
    if (localObject != null)
    {
      com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(236660);
          throw ((Throwable)localObject);
        }
        ((MultiTaskMinusScreenUIC)localObject).erM();
        AppMethodBeat.o(236660);
        return;
      }
    }
    AppMethodBeat.o(236660);
  }
  
  public final void ers()
  {
    AppMethodBeat.i(236658);
    MultiTaskContainerView localMultiTaskContainerView = this.AfM;
    if (localMultiTaskContainerView != null)
    {
      localMultiTaskContainerView.RT(0);
      AppMethodBeat.o(236658);
      return;
    }
    AppMethodBeat.o(236658);
  }
  
  public final void ert()
  {
    AppMethodBeat.i(236655);
    this.AfL += 1;
    Log.d(TAG, "playsound count: %d", new Object[] { Integer.valueOf(this.AfL) });
    AppMethodBeat.o(236655);
  }
  
  public final boolean eru()
  {
    AppMethodBeat.i(236653);
    if ((isDataEmpty()) && (!erO()))
    {
      Log.d(TAG, "needExpand, false!");
      AppMethodBeat.o(236653);
      return false;
    }
    AppMethodBeat.o(236653);
    return true;
  }
  
  public final String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(236666);
    p.h(paramString, "id");
    Object localObject1 = this.AfE;
    if (localObject1 != null)
    {
      com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(236666);
          throw paramString;
        }
        localObject1 = (MultiTaskMinusScreenUIC)localObject1;
        p.h(paramString, "id");
        int i = ((MultiTaskMinusScreenUIC)localObject1).aGQ(paramString);
        if ((paramInt1 != i) && (i >= 0) && (i < ((MultiTaskMinusScreenUIC)localObject1).Afn.size()))
        {
          if (paramInt2 == 4)
          {
            if (((MultiTaskMinusScreenUIC)localObject1).Afn.size() <= 2)
            {
              paramString = ((MultiTaskMinusScreenUIC)localObject1).ufR;
              if (paramString != null)
              {
                paramString = paramString.ch(1);
                if (paramString != null)
                {
                  paramString = paramString.aus;
                  if (paramString != null) {
                    paramString = paramString.findViewById(2131305006);
                  }
                }
              }
            }
            for (;;)
            {
              localObject1 = com.tencent.mm.plugin.multitask.f.c.AgL;
              paramString = com.tencent.mm.plugin.multitask.f.c.ey(paramString);
              AppMethodBeat.o(236666);
              return paramString;
              paramString = null;
              continue;
              paramString = ((MultiTaskMinusScreenUIC)localObject1).getRootView().findViewById(2131305002);
            }
          }
          paramString = ((MultiTaskMinusScreenUIC)localObject1).ufR;
          if (paramString != null) {}
          for (localObject1 = paramString.ch(i + 1);; localObject1 = null)
          {
            paramString = localObject2;
            if (localObject1 == null) {
              break;
            }
            paramString = ((RecyclerView.v)localObject1).aus;
            break;
          }
        }
        AppMethodBeat.o(236666);
        return "";
      }
    }
    AppMethodBeat.o(236666);
    return "";
  }
  
  public final void hm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236649);
    a.hn(paramInt1, paramInt2);
    AppMethodBeat.o(236649);
  }
  
  public final void hx(boolean paramBoolean)
  {
    AppMethodBeat.i(236671);
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.AfC;
    boolean bool3;
    if (localb != null)
    {
      bool3 = localb.getCanSlide();
      Log.i(TAG, "enableScroll: " + paramBoolean + ", canSlide:" + bool3 + ", orientation:" + this.AfJ + ", currentTabIndex:" + this.AfK);
      if (((this.AfJ != 2) && (!isDataEmpty()) && (this.AfK == 0)) || (erO())) {
        break label240;
      }
      Log.i(TAG, "enableScroll false, isDataEmpty: " + isDataEmpty());
    }
    label240:
    for (boolean bool2 = false;; bool2 = paramBoolean)
    {
      boolean bool1 = bool2;
      if (erU())
      {
        bool1 = bool2;
        if (erO())
        {
          Log.i(TAG, "enableScroll false, showSnapshot Already");
          bool1 = false;
        }
      }
      b localb1 = this.AfI;
      bool2 = bool1;
      if (localb1 != null)
      {
        bool2 = bool1;
        if (localb1.esy() == true)
        {
          Log.i(TAG, "enableScroll false, isHeaderOpen");
          bool2 = false;
        }
      }
      if (bool3 == paramBoolean)
      {
        AppMethodBeat.o(236671);
        return;
      }
      localb.setCanSlide(bool2);
      AppMethodBeat.o(236671);
      return;
      AppMethodBeat.o(236671);
      return;
    }
  }
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(236659);
    Object localObject = this.AfE;
    if (localObject != null)
    {
      com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
          AppMethodBeat.o(236659);
          throw ((Throwable)localObject);
        }
        boolean bool = ((MultiTaskMinusScreenUIC)localObject).isDataEmpty();
        AppMethodBeat.o(236659);
        return bool;
      }
    }
    AppMethodBeat.o(236659);
    return true;
  }
  
  public final void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(236684);
    if (erO())
    {
      if (paramBoolean)
      {
        localObject = SecDataUIC.CWq;
        localObject = (crt)SecDataUIC.a.a((Context)getActivity(), 5, crt.class);
        if (localObject != null)
        {
          crs localcrs = ((crt)localObject).MwP;
          if (localcrs != null)
          {
            if (cl.aWA() >= ((crt)localObject).viC) {
              localcrs.duration += cl.aWA() - ((crt)localObject).viC;
            }
            AppMethodBeat.o(236684);
            return;
          }
          AppMethodBeat.o(236684);
          return;
        }
        AppMethodBeat.o(236684);
        return;
      }
      Object localObject = SecDataUIC.CWq;
      localObject = (crt)SecDataUIC.a.a((Context)getActivity(), 5, crt.class);
      if (localObject != null)
      {
        if ((((crt)localObject).MwP != null) && (cl.aWA() >= ((crt)localObject).viC)) {
          ((crt)localObject).viC = cl.aWA();
        }
        AppMethodBeat.o(236684);
        return;
      }
    }
    AppMethodBeat.o(236684);
  }
  
  public final void l(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(236672);
    p.h(paramMultiTaskInfo, "taskInfo");
    erW();
    erR();
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Oot, paramMultiTaskInfo.field_id + "|" + cl.aWA());
    Log.i(TAG, "enterFullScreenMode, id:" + paramMultiTaskInfo.field_id);
    AppMethodBeat.o(236672);
  }
  
  public final void m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(236668);
    Log.i(TAG, "showHome, smoothScrool:" + paramBoolean1 + ", fromClick:" + paramBoolean2 + ", fromSwipe:" + paramBoolean2);
    if (paramBoolean2) {
      this.AfH = 2;
    }
    for (;;)
    {
      Object localObject = this.AdB;
      if (localObject != null) {
        ((GradientColorBackgroundView)localObject).setVisibility(0);
      }
      localObject = this.AdB;
      if (localObject != null) {
        ((GradientColorBackgroundView)localObject).setAlpha(1.0F);
      }
      localObject = this.AfC;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).setCurrentItem(1, paramBoolean1);
      }
      if (!paramBoolean1) {
        erV();
      }
      AppMethodBeat.o(236668);
      return;
      if (paramBoolean3) {
        this.AfH = 1;
      } else {
        this.AfH = 3;
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(236692);
    Log.i(TAG, "onBeforeFinish");
    AppMethodBeat.o(236692);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(236689);
    p.h(paramConfiguration, "newConfig");
    a.esx();
    this.AfJ = paramConfiguration.orientation;
    if ((paramConfiguration.orientation == 2) && (!erO())) {
      hx(false);
    }
    Object localObject;
    for (;;)
    {
      localObject = this.AfE;
      if (localObject == null) {
        break label130;
      }
      p.h(paramConfiguration, "newConfig");
      com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.a)localObject).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
      if (localObject == null) {
        break label123;
      }
      if (localObject != null) {
        break;
      }
      paramConfiguration = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
      AppMethodBeat.o(236689);
      throw paramConfiguration;
      hx(true);
    }
    ((MultiTaskMinusScreenUIC)localObject).onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(236689);
    return;
    label123:
    AppMethodBeat.o(236689);
    return;
    label130:
    AppMethodBeat.o(236689);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(236679);
    super.onCreate(paramBundle);
    this.AfO.alive();
    AppMethodBeat.o(236679);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(236678);
    Log.i(TAG, "onCreateBefore");
    this.AeI = paramBundle;
    AppMethodBeat.o(236678);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(236687);
    Log.i(TAG, "onDestroy, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(erO()) });
    ??? = this.AfE;
    if (??? != null) {
      ((com.tencent.mm.plugin.multitask.ui.panel.b)???).onDestroy();
    }
    this.AfO.dead();
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.AfC;
    b.b localb1;
    if (localb != null) {
      localb1 = (b.b)this;
    }
    synchronized (localb.AcI)
    {
      localb.AcI.remove(localb1);
      ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).setListener(null);
      AppMethodBeat.o(236687);
      return;
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236690);
    p.h(paramKeyEvent, "event");
    if (this.AfE != null) {
      com.tencent.mm.plugin.multitask.ui.panel.b.e(paramKeyEvent);
    }
    AppMethodBeat.o(236690);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236691);
    p.h(paramKeyEvent, "event");
    if (this.AfE != null) {
      p.h(paramKeyEvent, "event");
    }
    AppMethodBeat.o(236691);
    return false;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(236685);
    Log.i(TAG, "onPause, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(erO()) });
    if (erO())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.AfE;
      if (localb != null) {
        Log.i(localb.TAG, "onPause");
      }
      erR();
    }
    AppMethodBeat.o(236685);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236688);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (this.AfE != null)
    {
      p.h(paramArrayOfString, "permissions");
      p.h(paramArrayOfInt, "grantResults");
    }
    AppMethodBeat.o(236688);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(236681);
    Log.i(TAG, "onRestoreInstanceState");
    AppMethodBeat.o(236681);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(236683);
    Log.i(TAG, "onResume, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(erO()) });
    if (erO())
    {
      Object localObject = this.AfE;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).onResume();
      }
      if ((this.AfE != null) && (!erU())) {
        erT();
      }
      localObject = this.AfE;
      if (localObject != null)
      {
        com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
        localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bK(0, com.tencent.mm.plugin.multitask.g.eqw());
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
            AppMethodBeat.o(236683);
            throw ((Throwable)localObject);
          }
          ((MultiTaskMinusScreenUIC)localObject).erK();
        }
      }
      erP();
      AppMethodBeat.o(236683);
      return;
    }
    erV();
    AppMethodBeat.o(236683);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(236680);
    Log.i(TAG, "onSaveInstanceState");
    AppMethodBeat.o(236680);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(236682);
    Log.i(TAG, "onStart, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(erO()) });
    if (erO())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.AfE;
      if (localb != null)
      {
        localb.onStart();
        AppMethodBeat.o(236682);
        return;
      }
    }
    AppMethodBeat.o(236682);
  }
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop()
  {
    AppMethodBeat.i(236686);
    Log.i(TAG, "onStop, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(erO()) });
    if (erO())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.AfE;
      if (localb != null) {
        Log.i(localb.TAG, "onStop");
      }
      erR();
    }
    AppMethodBeat.o(236686);
  }
  
  public final void sk(boolean paramBoolean)
  {
    AppMethodBeat.i(236675);
    Log.i(TAG, "hideSnapshotUIC, remove:".concat(String.valueOf(paramBoolean)));
    Object localObject = this.AfE;
    if (localObject != null)
    {
      com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).bK(1048576, com.tencent.mm.plugin.multitask.g.eqx());
      if (localObject != null)
      {
        if ((localObject instanceof SnapShotMultiTaskUIC))
        {
          ((SnapShotMultiTaskUIC)localObject).esB();
          ((SnapShotMultiTaskUIC)localObject).esA();
          if (paramBoolean) {
            com.tencent.f.h.RTc.aV((Runnable)new MultiTaskUIC.d(this, paramBoolean));
          }
        }
        AppMethodBeat.o(236675);
        return;
      }
    }
    AppMethodBeat.o(236675);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$Companion;", "", "()V", "HOME_EXPOSE_WIDTH", "", "getHOME_EXPOSE_WIDTH", "()I", "setHOME_EXPOSE_WIDTH", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "_2A", "get_2A", "set_2A", "_2_5A", "get_2_5A", "set_2_5A", "canvasHeight", "getCanvasHeight", "setCanvasHeight", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "font_size", "", "getFont_size", "()F", "setFont_size", "(F)V", "image_scale", "getImage_scale", "setImage_scale", "itemButtomPadding", "getItemButtomPadding", "setItemButtomPadding", "itemHeaderHeight", "getItemHeaderHeight", "setItemHeaderHeight", "itemHeight", "getItemHeight", "setItemHeight", "itemHoritonalPadding", "getItemHoritonalPadding", "setItemHoritonalPadding", "itemImgHeight", "getItemImgHeight", "setItemImgHeight", "itemImgWidth", "getItemImgWidth", "setItemImgWidth", "itemTitleHeight", "getItemTitleHeight", "setItemTitleHeight", "itemWidth", "getItemWidth", "setItemWidth", "oneItemContentHeight", "getOneItemContentHeight", "setOneItemContentHeight", "oneItemContentWidth", "getOneItemContentWidth", "setOneItemContentWidth", "oneItemFromLeft", "getOneItemFromLeft", "setOneItemFromLeft", "oneItemFromTop", "getOneItemFromTop", "setOneItemFromTop", "oneItemImgHeight", "getOneItemImgHeight", "setOneItemImgHeight", "oneItemImgWidth", "getOneItemImgWidth", "setOneItemImgWidth", "portraitHeight", "getPortraitHeight", "setPortraitHeight", "portraitWidth", "getPortraitWidth", "setPortraitWidth", "scale", "getScale", "setScale", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "twoItemFromLeft", "getTwoItemFromLeft", "setTwoItemFromLeft", "twoItemFromTop", "getTwoItemFromTop", "setTwoItemFromTop", "initMultiTaskViewParams", "", "screenSizeW", "screenSizeH", "ui-multitask_release"})
  public static final class a
  {
    public static void esx()
    {
      AppMethodBeat.i(236643);
      hn(com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()), com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
      AppMethodBeat.o(236643);
    }
    
    public static void hn(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(236644);
      com.tencent.mm.plugin.multitask.ui.base.b.a locala = com.tencent.mm.plugin.multitask.ui.base.b.Adg;
      MultiTaskUIC.Sp(com.tencent.mm.plugin.multitask.ui.base.b.erq());
      MultiTaskUIC.RX(paramInt1);
      MultiTaskUIC.RY(paramInt2);
      MultiTaskUIC.RV(Math.min(MultiTaskUIC.erZ(), MultiTaskUIC.esa()));
      MultiTaskUIC.RW(Math.max(MultiTaskUIC.erZ(), MultiTaskUIC.esa()));
      MultiTaskUIC.RZ(MultiTaskUIC.erZ() * 2 - MultiTaskUIC.esq());
      MultiTaskUIC.Sa(MultiTaskUIC.esa());
      MultiTaskUIC.Sb(at.fromDPToPix(MMApplicationContext.getContext(), 12));
      MultiTaskUIC.Sc(at.fromDPToPix(MMApplicationContext.getContext(), 14));
      MultiTaskUIC.Sd(at.fromDPToPix(MMApplicationContext.getContext(), 20));
      MultiTaskUIC.Sr(at.fromDPToPix(MMApplicationContext.getContext(), 44));
      MultiTaskUIC.Sq(at.fromDPToPix(MMApplicationContext.getContext(), 32) - MultiTaskUIC.esb());
      MultiTaskUIC.Se(kotlin.h.a.cR((MultiTaskUIC.erX() - MultiTaskUIC.esq() - MultiTaskUIC.esc() * 2) / 2.0F));
      MultiTaskUIC.Si(MultiTaskUIC.ese() - MultiTaskUIC.esb());
      MultiTaskUIC.Sj(kotlin.h.a.cR(MultiTaskUIC.esi() * MultiTaskUIC.esw()));
      MultiTaskUIC.bD((MultiTaskUIC.esj() + MultiTaskUIC.esb() + MultiTaskUIC.esr() + MultiTaskUIC.ess() * MultiTaskUIC.esu() + at.fromDPToPix(MMApplicationContext.getContext(), 16)) / MultiTaskUIC.ese());
      MultiTaskUIC.Sf(kotlin.h.a.cR(MultiTaskUIC.ese() * MultiTaskUIC.esv()));
      MultiTaskUIC.Sg(kotlin.h.a.cR(MultiTaskUIC.ese() * 1.5F));
      MultiTaskUIC.Sh(kotlin.h.a.cR(MultiTaskUIC.esg() * MultiTaskUIC.esv()));
      MultiTaskUIC.Sk(MultiTaskUIC.esg() - MultiTaskUIC.esb());
      MultiTaskUIC.Sl(kotlin.h.a.cR(MultiTaskUIC.esk() * MultiTaskUIC.esw()));
      MultiTaskUIC.Sm(kotlin.h.a.K((MultiTaskUIC.erY() - MultiTaskUIC.esh() - MultiTaskUIC.esb() * 6) / 2.0D));
      MultiTaskUIC.Sn(kotlin.h.a.K((MultiTaskUIC.erX() - MultiTaskUIC.esq() - MultiTaskUIC.esg()) / 2.0D - MultiTaskUIC.esc()));
      MultiTaskUIC.eso();
      MultiTaskUIC.So(kotlin.h.a.K((MultiTaskUIC.erY() - MultiTaskUIC.esf() - MultiTaskUIC.esb() * 8) / 2.0D));
      Log.i(MultiTaskUIC.access$getTAG$cp(), "initMultiTaskViewParams width:" + MultiTaskUIC.ese() + " height:" + MultiTaskUIC.esf() + " oneItemContentWidth:" + MultiTaskUIC.esg() + " oneItemContentHeight:" + MultiTaskUIC.esh());
      AppMethodBeat.o(236644);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "", "getCurrentTabIndex", "", "isHeaderOpen", "", "multiTaskStateChanged", "", "state", "curIndex", "multiTaskTabChanged", "ui-multitask_release"})
  public static abstract interface b
  {
    public abstract void akq(int paramInt);
    
    public abstract void aws(int paramInt);
    
    public abstract boolean esy();
    
    public abstract int getCurrentTabIndex();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(MultiTaskUIC paramMultiTaskUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */