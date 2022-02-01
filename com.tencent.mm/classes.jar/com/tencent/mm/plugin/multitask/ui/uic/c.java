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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.model.cn;
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
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.drw;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionEnterType", "", "getActionEnterType", "()I", "setActionEnterType", "(I)V", "actionExitType", "getActionExitType", "setActionExitType", "callback", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "getCallback", "()Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "setCallback", "(Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;)V", "canReportEnterTips", "", "currentTabIndex", "delayHideDynamicBgRunnable", "Ljava/lang/Runnable;", "delayShowEnterTipsRunnable", "dynamicBgContainer", "Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "eduExitType", "getEduExitType", "setEduExitType", "enterTipsView", "Landroid/view/View;", "gradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "homeTabChangedListener", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1;", "isDynamicBgShow", "launcherContainer", "getLauncherContainer", "()Landroid/view/View;", "setLauncherContainer", "(Landroid/view/View;)V", "listEduType", "getListEduType", "setListEduType", "mOriention", "getMOriention", "setMOriention", "multiTaskIcon", "Landroid/widget/ImageView;", "getMultiTaskIcon", "()Landroid/widget/ImageView;", "setMultiTaskIcon", "(Landroid/widget/ImageView;)V", "onCreateInstanceState", "Landroid/os/Bundle;", "panelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "getPanelView", "()Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "setPanelView", "(Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;)V", "parentPanelLayoutWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "getParentPanelLayoutWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "setParentPanelLayoutWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "parentViewPager", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getParentViewPager", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setParentViewPager", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "playSound", "getPlaySound", "setPlaySound", "realPanelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "tipsViewShow", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkEnterTipsIfNeed", "", "checkShowLoading", "checkShowSnapshotIfNeed", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "size", "forceHide", "forceShow", "checkTeenMode", "multiTaskType", "createMultiTaskPanelView", "createPanelView", "delayHideDynamicBg", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "enableExpand", "enableScroll", "enable", "enterFullScreenMode", "exitFullScreenMode", "getMultiTaskItemPosition", "", "id", "curPos", "way", "hasCurrentMultiInfo", "hideDynamicBg", "hideSnapshotUIC", "remove", "inMultiTaskPanel", "initEnterEduReport", "eduType", "initEnterReport", "initExitEduReport", "initExitReport", "isDataEmpty", "isShowSnapshotUIC", "jumpSnapshotUIC", "markEduReportStat", "resume", "markWechatForeground", "foreground", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "onKeyUp", "onMultiTaskPageSelected", "position", "onPanelItemSelected", "panel", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPause", "onPlaySound", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "requestOrientation", "saveHomeSnapBlt", "showEnterTipsAnim", "showHome", "smoothScroll", "fromClick", "fromSwipe", "fromFullSwipe", "fromSysClick", "fromFadeClick", "fromDeleteAll", "fromBlankClick", "showPanel", "showSnapshotUIC", "switchToDynamicBg", "switchToStaticBg", "delay", "updateLoadingMode", "loadingMode", "Companion", "MultiTaskCallback", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
  implements PluginMultiTask.b, com.tencent.mm.plugin.multitask.ui.base.b.b
{
  private static int LHI;
  private static int LHJ;
  private static int LHK;
  private static int LHL;
  private static int LHM;
  private static int LHN;
  private static int LHO;
  private static int LHP;
  private static int LHQ;
  private static int LHR;
  private static int LHS;
  private static int LHT;
  private static int LHU;
  private static int LHV;
  private static int LHW;
  private static int LHX;
  private static int LHY;
  private static int LHZ;
  public static final a LHl;
  private static int LIa;
  private static int LIb;
  private static int LIc;
  private static float LId;
  private static float LIe;
  private static float LIf;
  public static final String TAG;
  private static int _2A;
  private static int dpX;
  private static int pvg;
  private static int sJv;
  private static float scale;
  private static int wLI;
  private GradientColorBackgroundView LFu;
  private Bundle LGo;
  private View LHA;
  private Runnable LHB;
  private boolean LHC;
  private boolean LHD;
  private DynamicBgContainer LHE;
  private final MultiTaskUIC.homeTabChangedListener.1 LHF;
  private Runnable LHG;
  private boolean LHH;
  public CustomViewPager LHm;
  public com.tencent.mm.plugin.multitask.ui.base.b LHn;
  private View LHo;
  public com.tencent.mm.plugin.multitask.ui.panel.b LHp;
  private ImageView LHq;
  public int LHr;
  private int LHs;
  private int LHt;
  private int LHu;
  private b LHv;
  private int LHw;
  private int LHx;
  private int LHy;
  public MultiTaskContainerView LHz;
  private final MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(304746);
    LHl = new a((byte)0);
    TAG = "MicroMsg.MultiTask.MultiTaskUIC";
    LId = 0.2F;
    LIe = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
    scale = 1.666667F;
    LIf = 1.333333F;
    AppMethodBeat.o(304746);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(304338);
    this.LHr = 6;
    this.LHs = 6;
    this.LHt = 9;
    this.LHu = 3;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.LHF = new MultiTaskUIC.homeTabChangedListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(304338);
  }
  
  private static final void a(c paramc)
  {
    int k = 0;
    AppMethodBeat.i(304433);
    s.u(paramc, "this$0");
    Object localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
    com.tencent.mm.plugin.multitask.e.b.zF(false);
    localObject = paramc.LHv;
    if (localObject != null)
    {
      if (((b)localObject).glL())
      {
        Log.i(TAG, "[enterTips]chatting is foreground, skip!, step 2");
        AppMethodBeat.o(304433);
        return;
      }
      if (((b)localObject).glK())
      {
        Log.i(TAG, "[enterTips]header is open, skip!, step 2");
        AppMethodBeat.o(304433);
        return;
      }
      if (((b)localObject).getCurrentTabIndex() != 0)
      {
        Log.i(TAG, "[enterTips]tab is not mainUI, skip!, step 2");
        AppMethodBeat.o(304433);
        return;
      }
    }
    if (paramc.gkZ())
    {
      Log.i(TAG, "[enterTips]inMultiTaskPanel, skip!, step 2");
      AppMethodBeat.o(304433);
      return;
    }
    localObject = paramc.LHn;
    int j = k;
    if (localObject != null) {
      if (((com.tencent.mm.plugin.multitask.ui.base.b)localObject).getPanelState() != b.c.LFd) {
        break label190;
      }
    }
    label190:
    for (int i = 1;; i = 0)
    {
      j = k;
      if (i == 0) {
        j = 1;
      }
      if (j == 0) {
        break;
      }
      Log.i(TAG, "[enterTips]is not collapsed, skip!, step 2");
      AppMethodBeat.o(304433);
      return;
    }
    if (paramc.isDataEmpty())
    {
      Log.i(TAG, "[enterTips]data is empty, skip!, step 2");
      AppMethodBeat.o(304433);
      return;
    }
    Log.i(TAG, "[enterTips] show!");
    if (paramc.LHA != null)
    {
      LIc = kotlin.h.a.eH(sJv * LId);
      paramc.LHC = true;
      paramc.LHD = true;
      localObject = paramc.LHn;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).setAnchorPoint(LId);
      }
      localObject = paramc.LHn;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).a(b.c.LFe, 300L, true);
      }
      localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
      com.tencent.mm.plugin.multitask.e.b.gko();
      paramc.acy(1);
    }
    AppMethodBeat.o(304433);
  }
  
  public static boolean acA(int paramInt)
  {
    AppMethodBeat.i(304415);
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    int i = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr();
    int j = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEq();
    int k = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD();
    Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d, bizAcctOption: %d, finderOption: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if ((bool) && (((i == 2) && (paramInt == 1)) || ((j == 2) && (paramInt == 2)) || ((k == 2) && (paramInt == 22))))
    {
      AppMethodBeat.o(304415);
      return true;
    }
    AppMethodBeat.o(304415);
    return false;
  }
  
  private static final void b(c paramc)
  {
    AppMethodBeat.i(304439);
    s.u(paramc, "this$0");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = paramc.LHp;
    if (localb != null)
    {
      g localg = g.LBa;
      localb.aNV(g.gjs());
    }
    paramc.jr(true);
    AppMethodBeat.o(304439);
  }
  
  private final void gla()
  {
    AppMethodBeat.i(304344);
    if (!gkZ())
    {
      SharedPreferences localSharedPreferences = getActivity().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      s.s(localSharedPreferences, "activity.getSharedPrefer…faultPreferencePath(), 0)");
      Log.i(TAG, "set ScreenOrientation，now is ： %s", new Object[] { Boolean.valueOf(localSharedPreferences.getBoolean("settings_landscape_mode", false)) });
      if (localSharedPreferences.getBoolean("settings_landscape_mode", false))
      {
        getActivity().setRequestedOrientation(-1);
        AppMethodBeat.o(304344);
        return;
      }
      getActivity().setRequestedOrientation(1);
      AppMethodBeat.o(304344);
      return;
    }
    getActivity().setRequestedOrientation(1);
    AppMethodBeat.o(304344);
  }
  
  private boolean glb()
  {
    AppMethodBeat.i(304349);
    if (!gkZ())
    {
      AppMethodBeat.o(304349);
      return true;
    }
    AppMethodBeat.o(304349);
    return false;
  }
  
  private void gld()
  {
    AppMethodBeat.i(304355);
    if (!this.LHH)
    {
      AppMethodBeat.o(304355);
      return;
    }
    Log.i(TAG, "virbg: switchToStaticBg");
    this.LHH = false;
    if ((this.LHE != null) && (!DynamicBgContainer.gkF())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        GradientColorBackgroundView localGradientColorBackgroundView = this.LFu;
        if (localGradientColorBackgroundView != null) {
          localGradientColorBackgroundView.setVisibility(0);
        }
        localGradientColorBackgroundView = this.LFu;
        if (localGradientColorBackgroundView != null) {
          localGradientColorBackgroundView.setAlpha(1.0F);
        }
      }
      gle();
      AppMethodBeat.o(304355);
      return;
    }
  }
  
  private final void gle()
  {
    AppMethodBeat.i(304377);
    DynamicBgContainer localDynamicBgContainer = this.LHE;
    if (localDynamicBgContainer != null) {
      localDynamicBgContainer.gkI();
    }
    AppMethodBeat.o(304377);
  }
  
  private void glh()
  {
    Object localObject1 = null;
    AppMethodBeat.i(304397);
    Object localObject2 = this.LHp;
    if (localObject2 == null) {}
    g localg;
    do
    {
      if (localObject1 == null) {
        zG(false);
      }
      AppMethodBeat.o(304397);
      return;
      localg = g.LBa;
      localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).aNW(g.gjs());
    } while (localObject2 == null);
    localObject1 = this.LHp;
    if (localObject1 != null)
    {
      localg = g.LBa;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
      if (localObject1 != null)
      {
        if (!b.a((b)localObject1, ((d)localObject2).LIj, false)) {
          break label119;
        }
        ((d)localObject2).glh();
      }
    }
    for (;;)
    {
      ((d)localObject2).glN();
      jr(true);
      localObject1 = ah.aiuX;
      break;
      label119:
      zG(false);
    }
  }
  
  private void gli()
  {
    AppMethodBeat.i(304407);
    try
    {
      Object localObject1 = this.LHo;
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.ui.p.a.a(this.LHo, ((View)localObject1).getWidth(), ((View)localObject1).getHeight(), true, Bitmap.Config.RGB_565);
        if (localObject1 != null)
        {
          Object localObject3 = com.tencent.mm.plugin.multitask.h.LBd;
          localObject3 = com.tencent.mm.plugin.multitask.h.gjv();
          if (y.ZC((String)localObject3)) {
            y.deleteFile((String)localObject3);
          }
          BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
        }
        AppMethodBeat.o(304407);
        return;
      }
    }
    finally
    {
      Log.e(TAG, "snapshot bitmap failed", new Object[] { localObject2 });
      AppMethodBeat.o(304407);
    }
  }
  
  private void zH(boolean paramBoolean)
  {
    AppMethodBeat.i(304426);
    if (gkZ())
    {
      Object localObject;
      drv localdrv;
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
        if (localObject != null)
        {
          localdrv = ((dry)localObject).aaXM;
          if (localdrv != null)
          {
            localdrv.aaXv = cn.bDw();
            localdrv.AMQ = true;
          }
          localdrv = ((dry)localObject).aaXL;
          if (localdrv != null)
          {
            localdrv.aaXv = cn.bDw();
            localdrv.AMQ = true;
          }
          localObject = ((dry)localObject).aaXN;
          if (localObject != null)
          {
            ((drv)localObject).aaXv = cn.bDw();
            ((drv)localObject).AMQ = true;
          }
          AppMethodBeat.o(304426);
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
        if (localObject != null)
        {
          localdrv = ((dry)localObject).aaXM;
          if ((localdrv != null) && (cn.bDw() >= localdrv.aaXv) && (!((dry)localObject).aaXK) && (localdrv.AMQ))
          {
            localdrv.duration += cn.bDw() - localdrv.aaXv;
            localdrv.aaXv = cn.bDw();
          }
          localdrv = ((dry)localObject).aaXL;
          if ((localdrv != null) && (cn.bDw() >= localdrv.aaXv) && (!((dry)localObject).aaXK))
          {
            localdrv.duration += cn.bDw() - localdrv.aaXv;
            localdrv.aaXv = cn.bDw();
          }
          localdrv = ((dry)localObject).aaXN;
          if ((localdrv != null) && (cn.bDw() >= localdrv.aaXv) && (!((dry)localObject).aaXK))
          {
            localdrv.duration += cn.bDw() - localdrv.aaXv;
            localdrv.aaXv = cn.bDw();
          }
        }
      }
    }
    AppMethodBeat.o(304426);
  }
  
  public final View a(View arg1, DynamicBgContainer paramDynamicBgContainer, b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(304760);
    s.u(???, "launcherContainer");
    Log.i(TAG, "create panel launcher");
    this.LHo = ???;
    this.LHE = paramDynamicBgContainer;
    this.LFu = paramDynamicBgContainer.getGradientBgView();
    paramDynamicBgContainer = this.LHE;
    if (paramDynamicBgContainer != null) {
      paramDynamicBgContainer.gkE();
    }
    this.LHv = paramb;
    paramDynamicBgContainer = getActivity().getSupportActionBar();
    if (paramDynamicBgContainer == null) {
      paramDynamicBgContainer = null;
    }
    for (;;)
    {
      this.LHq = paramDynamicBgContainer;
      ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).registerMultiTaskUIC(2, e.class);
      ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).registerMultiTaskUIC(0, b.class);
      ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).registerMultiTaskUIC(1, a.class);
      ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).registerMultiTaskUIC(1048576, d.class);
      paramDynamicBgContainer = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramDynamicBgContainer = com.tencent.mm.plugin.secdata.ui.a.a.jC((Context)getActivity());
      if (paramDynamicBgContainer != null) {
        paramDynamicBgContainer.a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.b(p.listOf(new String[] { "WebViewUI", "WebviewMpUI", "FinderLongVideoTimelineUI", "NoteEditorUI", "MiniQBReaderUI", "AppAttachDownloadUI", "ChooseMsgFileShowUI", "TopStoryFSVideoUI", "TopStoryMultiTaskListVideoUI", "LuggageGameWebViewUI" }), dry.class));
      }
      ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).setListener((PluginMultiTask.b)this);
      if (this.LHn != null) {
        break label982;
      }
      paramb = new com.tencent.mm.plugin.multitask.ui.base.b((Context)getActivity());
      paramb.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      Log.i(TAG, "create panel view");
      a.glJ();
      if (this.LHp == null) {
        this.LHp = new com.tencent.mm.plugin.multitask.ui.panel.b(getActivity(), this.LGo);
      }
      paramDynamicBgContainer = getActivity().getLayoutInflater().inflate(e.d.LEn, null);
      if (paramDynamicBgContainer != null) {
        break;
      }
      ??? = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(304760);
      throw ???;
      paramDynamicBgContainer = paramDynamicBgContainer.getCustomView();
      if (paramDynamicBgContainer == null) {
        paramDynamicBgContainer = null;
      } else {
        paramDynamicBgContainer = (ImageView)paramDynamicBgContainer.findViewById(e.c.actionbar_up_indicator_btn);
      }
    }
    Object localObject2 = (FrameLayout)paramDynamicBgContainer;
    paramDynamicBgContainer = ((FrameLayout)localObject2).findViewById(e.c.LEe);
    if (paramDynamicBgContainer == null)
    {
      ??? = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView");
      AppMethodBeat.o(304760);
      throw ???;
    }
    this.LHz = ((MultiTaskContainerView)paramDynamicBgContainer);
    ((FrameLayout)localObject2).setDrawingCacheEnabled(false);
    paramDynamicBgContainer = this.LHz;
    label488:
    int i;
    if (paramDynamicBgContainer == null)
    {
      paramDynamicBgContainer = null;
      this.LHA = paramDynamicBgContainer;
      paramDynamicBgContainer = this.LHp;
      if (paramDynamicBgContainer != null) {
        break label760;
      }
      paramDynamicBgContainer = null;
      ((FrameLayout)localObject2).addView(paramDynamicBgContainer, new ViewGroup.LayoutParams(-1, -1));
      paramDynamicBgContainer = (View)localObject2;
      if (paramDynamicBgContainer == null) {
        break label967;
      }
      localObject2 = com.tencent.mm.plugin.multitask.f.c.LIw;
      f = com.tencent.mm.plugin.multitask.f.c.glR();
      Log.i(TAG, s.X("slideFractor: ", Float.valueOf(f)));
      i = (int)(f * (sJv - LHY));
      paramDynamicBgContainer.setPadding(0, 0, i, 0);
      if ((paramDynamicBgContainer != null) && (??? != null))
      {
        paramb.addView(???, 0, new ViewGroup.LayoutParams(-1, -1));
        paramb.addView(paramDynamicBgContainer, 1, new ViewGroup.LayoutParams(-1, -1));
      }
      ??? = AnimationUtils.loadInterpolator(paramb.getContext(), com.tencent.mm.ah.a.a.mm_decelerate_interpolator);
      paramDynamicBgContainer = com.tencent.mm.plugin.multitask.animation.c.a.b.LCd;
      paramDynamicBgContainer = (ViewGroup)paramb;
      localObject2 = (com.tencent.mm.plugin.multitask.animation.c.a.b.a)new b.d(paramb);
      s.s(???, "interpolator");
      paramb.LCo = com.tencent.mm.plugin.multitask.animation.c.a.b.b.a(paramDynamicBgContainer, (com.tencent.mm.plugin.multitask.animation.c.a.b.a)localObject2, ???);
      ??? = paramb.getContext();
      if (??? != null) {
        break label834;
      }
      ??? = localObject1;
      label664:
      if (??? != null) {
        break label869;
      }
    }
    label834:
    label869:
    for (float f = com.tencent.mm.cd.a.getDensity(paramb.getContext());; f = ???.floatValue())
    {
      ??? = paramb.LCo;
      if (??? != null) {
        ???.LCf = (100.0F * f);
      }
      ??? = paramb.LCo;
      if (??? != null) {
        ???.uDV = (f * 300.0F);
      }
      ??? = paramb.getContext().getSystemService("vibrator");
      if (??? != null) {
        break label878;
      }
      ??? = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(304760);
      throw ???;
      paramDynamicBgContainer = paramDynamicBgContainer.findViewById(e.c.LDO);
      break;
      label760:
      if (paramDynamicBgContainer.LGq == null)
      {
        View localView = paramDynamicBgContainer.activity.getLayoutInflater().inflate(e.d.LEo, null);
        paramDynamicBgContainer.LGp = ((MultiTaskPanelContainer)localView.findViewById(e.c.LDK));
        Object localObject3 = paramDynamicBgContainer.LGp;
        if (localObject3 != null) {
          paramDynamicBgContainer.a((MultiTaskPanelContainer)localObject3);
        }
        localObject3 = ah.aiuX;
        paramDynamicBgContainer.LGq = localView;
      }
      paramDynamicBgContainer = paramDynamicBgContainer.LGq;
      break label488;
      paramDynamicBgContainer = ???.getResources();
      ??? = localObject1;
      if (paramDynamicBgContainer == null) {
        break label664;
      }
      paramDynamicBgContainer = paramDynamicBgContainer.getDisplayMetrics();
      ??? = localObject1;
      if (paramDynamicBgContainer == null) {
        break label664;
      }
      ??? = Float.valueOf(paramDynamicBgContainer.density);
      break label664;
    }
    label878:
    paramb.cqQ = ((Vibrator)???);
    paramb.setSlideLeft(false);
    paramb.setPanelWidth(sJv);
    paramb.setPanelExpose(LHY);
    paramb.setExtraSlideRange(i);
    if (aw.isDarkMode()) {
      paramb.setCoveredFadeColor(5066061);
    }
    for (;;)
    {
      paramb.setOverlayed(true);
      paramDynamicBgContainer = (com.tencent.mm.plugin.multitask.ui.base.b.b)this;
      synchronized (paramb.LEE)
      {
        paramb.LEE.add(paramDynamicBgContainer);
        paramb.setFadeOnClickListener((View.OnClickListener)new c(this));
        label967:
        paramb.setCurrentItem(1, false);
        ??? = ah.aiuX;
        this.LHn = paramb;
        label982:
        ??? = (View)this.LHn;
        AppMethodBeat.o(304760);
        return ???;
        paramb.setCoveredFadeColor(3618127);
      }
    }
  }
  
  public final void a(b.c paramc1, b.c paramc2)
  {
    AppMethodBeat.i(304792);
    Log.d(TAG, "onPanelStateChanged, previousState:" + paramc1 + ", newState:" + paramc2);
    Object localObject;
    int i;
    if ((paramc2 != paramc1) && (paramc2 == b.c.LFg))
    {
      if ((!gkZ()) && (!glg()) && (paramc1 == b.c.LFd)) {
        glf();
      }
      localObject = this.LHv;
      if (localObject != null)
      {
        if (!gkZ()) {
          break label245;
        }
        i = 0;
        ((b)localObject).acZ(i);
      }
    }
    if ((paramc2 != paramc1) && (paramc2 == b.c.LFd))
    {
      paramc1 = this.LHE;
      if (paramc1 != null) {
        paramc1.gkE();
      }
      gld();
      LIc = 0;
    }
    paramc1 = this.LHp;
    if (paramc1 == null)
    {
      paramc1 = null;
      label148:
      if (!(paramc1 instanceof b)) {
        break label267;
      }
    }
    label267:
    for (paramc1 = (b)paramc1;; paramc1 = null)
    {
      if ((paramc2 != b.c.LFd) || (isDataEmpty())) {
        break label272;
      }
      paramc2 = this.LHq;
      if (paramc2 != null) {
        paramc2.setAlpha(1.0F);
      }
      paramc2 = this.LHz;
      if (paramc2 != null) {
        paramc2.cK(0.0F);
      }
      LIc = 0;
      if (paramc1 != null) {
        paramc1.aI(0.0F, 0.0F);
      }
      if (!this.LHD) {
        break label343;
      }
      this.LHt = 3;
      acz(1);
      this.LHD = false;
      AppMethodBeat.o(304792);
      return;
      label245:
      i = 1;
      break;
      localObject = g.LBa;
      paramc1 = paramc1.cq(0, g.gjr());
      break label148;
    }
    label272:
    if (paramc2 == b.c.LFc)
    {
      paramc2 = this.LHq;
      if (paramc2 != null) {
        paramc2.setAlpha(0.0F);
      }
      paramc2 = this.LHz;
      if (paramc2 != null) {
        paramc2.cK(1.0F);
      }
      LIc = 0;
      if (paramc1 != null) {
        paramc1.aI(1.0F, 0.0F);
      }
      if (this.LHD)
      {
        this.LHt = 4;
        acz(1);
        this.LHD = false;
      }
    }
    label343:
    AppMethodBeat.o(304792);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    AppMethodBeat.i(304807);
    Log.i(TAG, "showHome, smoothScrool:" + paramBoolean1 + ", fromClick:" + paramBoolean2 + ", fromSwipe:" + paramBoolean2 + ", fromFullSwipe:" + paramBoolean4 + ", fromSysClick:" + paramBoolean5 + ", fromFadeClick:" + paramBoolean6 + ", fromDeleteAll:" + paramBoolean7);
    if (paramBoolean2) {
      if (paramBoolean5)
      {
        this.LHs = 8;
        if (!paramBoolean5) {
          break label227;
        }
        this.LHt = 8;
      }
    }
    for (;;)
    {
      Object localObject = this.LFu;
      if (localObject != null) {
        ((GradientColorBackgroundView)localObject).setVisibility(0);
      }
      localObject = this.LFu;
      if (localObject != null) {
        ((GradientColorBackgroundView)localObject).setAlpha(1.0F);
      }
      localObject = this.LHn;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).setCurrentItem(1, paramBoolean1);
      }
      if (!paramBoolean1) {
        glh();
      }
      AppMethodBeat.o(304807);
      return;
      if (paramBoolean8)
      {
        this.LHs = 2;
        break;
      }
      this.LHs = 4;
      break;
      if (paramBoolean3)
      {
        this.LHs = 1;
        break;
      }
      this.LHs = 3;
      break;
      label227:
      if (paramBoolean6) {
        this.LHt = 2;
      } else if (paramBoolean8) {
        this.LHt = 5;
      } else if (paramBoolean4) {
        this.LHt = 7;
      } else if (paramBoolean7) {
        this.LHt = 6;
      } else if (paramBoolean2) {
        this.LHt = 1;
      } else if (paramBoolean3) {
        this.LHt = 3;
      } else {
        this.LHt = 9;
      }
    }
  }
  
  public final boolean aNQ(String paramString)
  {
    AppMethodBeat.i(304805);
    s.u(paramString, "id");
    Object localObject1 = this.LHp;
    int i;
    boolean bool;
    if (localObject1 != null)
    {
      Object localObject2 = g.LBa;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
      if (localObject1 != null)
      {
        localObject1 = (b)localObject1;
        s.u(paramString, "id");
        localObject1 = ((Iterable)((b)localObject1).LGW).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            p.kkW();
          }
          if (((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject2).LGa.field_id.equals(paramString)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      Log.i(TAG, "hasCurrentMultiInfo, id:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(304805);
      return bool;
      i += 1;
      break;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void acu(int paramInt)
  {
    AppMethodBeat.i(304798);
    Log.i(TAG, s.X("onPanelItemSelected, position:", Integer.valueOf(paramInt)));
    Object localObject1;
    Object localObject2;
    label120:
    boolean bool;
    switch (paramInt)
    {
    default: 
      if (paramInt == 0)
      {
        localObject1 = this.LHp;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).gkQ();
        }
        if (!glg())
        {
          localObject1 = this.LHp;
          if (localObject1 != null)
          {
            localObject2 = g.LBa;
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
            if (localObject1 != null)
            {
              ((b)localObject1).gkV();
              Log.i(TAG, "triggerExposed!");
            }
          }
        }
        localObject1 = this.LHv;
        if (localObject1 != null) {
          ((b)localObject1).acY(paramInt);
        }
        if (gkZ()) {
          break label988;
        }
        localObject1 = this.LHE;
        if (localObject1 != null) {
          ((DynamicBgContainer)localObject1).gkE();
        }
        gld();
        glh();
        localObject1 = this.LHp;
        if (localObject1 != null) {
          break label958;
        }
        localObject1 = null;
        label184:
        if (!(localObject1 instanceof b)) {
          break label977;
        }
        localObject1 = (b)localObject1;
        label199:
        if (localObject1 != null) {
          ((b)localObject1).gkW();
        }
        if (localObject1 != null)
        {
          if ((this.LHt != 1) && (this.LHt != 3)) {
            break label983;
          }
          bool = true;
          label232:
          ((b)localObject1).aF(false, bool);
        }
      }
      break;
    }
    label927:
    label958:
    label977:
    label983:
    label1115:
    for (;;)
    {
      com.tencent.mm.ae.d.a(250L, (kotlin.g.a.a)new d(this));
      this.LHr = 6;
      this.LHs = 6;
      this.LHt = 9;
      this.LHu = 3;
      AppMethodBeat.o(304798);
      return;
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.multitask.d.a.LDj;
      com.tencent.mm.plugin.multitask.d.a.clear();
      localObject2 = com.tencent.mm.plugin.multitask.d.a.LDj;
      ((dry)localObject1).zIO = com.tencent.mm.plugin.multitask.d.a.gkk();
      ((dry)localObject1).AxK = cn.bDw();
      ((dry)localObject1).aaXH = new drs();
      ((dry)localObject1).aaXG = new dru();
      ((dry)localObject1).aaXI = new drw();
      ((dry)localObject1).aaXI.mwI = 1L;
      if (this.LHr == 6) {
        this.LHr = 1;
      }
      ((dry)localObject1).aaXI.aaXz = this.LHr;
      localObject2 = this.LHv;
      Object localObject3;
      Object localObject4;
      if (localObject2 != null)
      {
        localObject3 = ((dry)localObject1).aaXI;
        localObject4 = com.tencent.mm.plugin.multitask.d.a.LDj;
        ((drw)localObject3).nAz = com.tencent.mm.plugin.multitask.d.a.acr(((b)localObject2).getCurrentTabIndex());
      }
      localObject2 = ((dry)localObject1).aaXI;
      if (glg()) {}
      for (long l = 1L;; l = 2L)
      {
        ((drw)localObject2).aaXA = l;
        ((dry)localObject1).aaXI.duration = 0L;
        localObject2 = this.LHp;
        if (localObject2 != null)
        {
          localObject3 = g.LBa;
          localObject2 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).cq(0, g.gjr());
          if (localObject2 != null) {
            ((dry)localObject1).aaXI.aaXB = ((b)localObject2).gkY();
          }
        }
        localObject2 = com.tencent.mm.plugin.multitask.d.a.LDj;
        com.tencent.mm.plugin.multitask.d.a.b((dry)localObject1);
        Log.d(TAG, "report pageEnterAction, contextid:%s, action:%d, useraction:%d, scene:%d, fullscreen:%d, duration:%d", new Object[] { ((dry)localObject1).zIO, Long.valueOf(((dry)localObject1).aaXI.mwI), Long.valueOf(((dry)localObject1).aaXI.aaXz), Long.valueOf(((dry)localObject1).aaXI.nAz), Long.valueOf(((dry)localObject1).aaXI.aaXA), Long.valueOf(((dry)localObject1).aaXI.duration) });
        break;
      }
      Log.i(TAG, "initExitReport, start");
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
      if (localObject1 != null)
      {
        localObject2 = ((dry)localObject1).aaXI;
        if (localObject2 != null)
        {
          ((drw)localObject2).mwI = 2L;
          if (this.LHs == 6) {
            this.LHs = 1;
          }
          ((drw)localObject2).aaXz = this.LHs;
          localObject3 = this.LHp;
          if (localObject3 != null)
          {
            localObject4 = g.LBa;
            localObject3 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject3).cq(0, g.gjr());
            if (localObject3 != null) {
              ((drw)localObject2).aaXB = ((b)localObject3).gkY();
            }
          }
          if (cn.bDw() < ((dry)localObject1).AxK) {
            break label927;
          }
          ((drw)localObject2).duration += cn.bDw() - ((dry)localObject1).AxK;
          Log.i(TAG, "report pageExitAction, contextid:%s, action:%d, useraction:%d, scene:%d, fullscreen:%d, duration:%d", new Object[] { ((dry)localObject1).zIO, Long.valueOf(((dry)localObject1).aaXI.mwI), Long.valueOf(((dry)localObject1).aaXI.aaXz), Long.valueOf(((dry)localObject1).aaXI.nAz), Long.valueOf(((dry)localObject1).aaXI.aaXA), Long.valueOf(((dry)localObject1).aaXI.duration) });
          ((dry)localObject1).AxK = cn.bDw();
        }
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.multitask.d.a.LDj;
        com.tencent.mm.plugin.multitask.d.a.b((dry)localObject1);
        acz(3);
        acz(2);
        break;
        Log.i(TAG, "report pageExitAction, error");
      }
      localObject1 = this.LHp;
      if (localObject1 == null) {
        break label120;
      }
      ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).eDd();
      break label120;
      localObject2 = g.LBa;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
      break label184;
      localObject1 = null;
      break label199;
      bool = false;
      break label232;
      label988:
      if (gkZ())
      {
        localObject1 = this.LHq;
        if (localObject1 != null) {
          ((ImageView)localObject1).setAlpha(0.0F);
        }
        localObject1 = this.LHp;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            localObject1 = this.LHp;
            if (localObject1 != null) {
              break label1817;
            }
            localObject1 = null;
            if (localObject1 == a.b.LDp)
            {
              localObject1 = this.LHp;
              if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).LGr instanceof b != true)) {
                break label1845;
              }
              paramInt = 1;
              if (paramInt == 0) {}
            }
            else
            {
              glf();
            }
          }
          localObject1 = this.LHp;
          if (localObject1 != null) {
            break label1850;
          }
          localObject1 = null;
          if (!(localObject1 instanceof b)) {
            break label1869;
          }
          localObject1 = (b)localObject1;
          if (localObject1 != null) {
            ((b)localObject1).gkW();
          }
          if (localObject1 != null) {
            b.a((b)localObject1);
          }
          localObject2 = com.tencent.mm.plugin.multitask.e.b.LDn;
          if (com.tencent.mm.plugin.multitask.e.b.gks()) {
            continue;
          }
          if ((localObject1 == null) || (((b)localObject1).gkY() != 1L)) {
            break label1875;
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1878;
          }
          acy(3);
          localObject1 = com.tencent.mm.plugin.multitask.e.b.LDn;
          com.tencent.mm.plugin.multitask.e.b.gkr();
          break;
          localObject2 = g.LBa;
          localObject3 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(1048576, g.gjs());
          if (localObject3 == null)
          {
            localObject1 = null;
            break label1026;
          }
          if (!((d)localObject3).cvt())
          {
            Log.i(TAG, "jumpSnapshotUIC, is already hide");
            localObject1 = this.LHp;
            if (localObject1 == null)
            {
              localObject1 = null;
              label1246:
              if (localObject1 == a.b.LDp)
              {
                localObject1 = this.LHp;
                if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).LGr instanceof b != true)) {
                  break label1318;
                }
              }
            }
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt == 0) {
                break label1321;
              }
              glf();
              break;
              localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).LGr;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label1246;
              }
              localObject1 = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).eDe();
              break label1246;
            }
            break label1086;
          }
          localObject1 = this.LHp;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = null)
          {
            if (localObject1 == null)
            {
              ((d)localObject3).glO();
              ((d)localObject3).glN();
              jr(true);
              glf();
              Log.i(TAG, "jumpSnapshotUIC, hide now!");
            }
            localObject1 = ah.aiuX;
            break;
            localObject2 = g.LBa;
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
            if (localObject1 != null) {
              break label1411;
            }
          }
          ((d)localObject3).glM();
          localObject4 = (b)localObject1;
          Object localObject5 = ((d)localObject3).LIj;
          if (((b)localObject4).LGW.size() == 0) {
            Log.i(b.TAG, "jumpUICFormSnapshot, empty data");
          }
          label1531:
          label1663:
          do
          {
            do
            {
              do
              {
                jr(false);
                Log.i(TAG, "jumpSnapshotUIC, show now!");
                localObject1 = ah.aiuX;
                break;
                if (((b)localObject4).LGW.size() != 1) {
                  break label1632;
                }
                localObject1 = ((b)localObject4).LGW.get(0);
                s.s(localObject1, "multiTaskInfoList.get(0)");
                localObject5 = (com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject1;
                localObject1 = ((b)localObject4).AZd;
                if (localObject1 != null) {
                  break label1580;
                }
                localObject2 = null;
                localObject4 = ((b)localObject4).LHb;
              } while (localObject4 == null);
              if (localObject2 == null)
              {
                localObject1 = null;
                if (localObject2 != null) {
                  break label1622;
                }
              }
              for (localObject2 = null;; localObject2 = ((RecyclerView.v)localObject2).caK)
              {
                ((b.b)localObject4).a((View)localObject1, (View)localObject2, 0, ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject5).LGa, false);
                break;
                localObject2 = ((WxRecyclerView)localObject1).fU(1);
                break label1531;
                localObject1 = ((RecyclerView.v)localObject2).caK;
                if (localObject1 == null)
                {
                  localObject1 = null;
                  break label1551;
                }
                localObject1 = ((View)localObject1).findViewById(e.c.multi_task_item_bg);
                break label1551;
              }
            } while (localObject5 == null);
            paramInt = ((b)localObject4).aNX(((MultiTaskInfo)localObject5).field_id);
            localObject1 = ((b)localObject4).AZd;
            if (localObject1 != null) {
              break label1728;
            }
            localObject2 = null;
            if (((b)localObject4).LGW.size() > 2) {
              break label1791;
            }
            localObject1 = ((b)localObject4).AZd;
            if (localObject1 != null) {
              break label1741;
            }
            localObject1 = null;
            localObject4 = ((b)localObject4).LHb;
          } while (localObject4 == null);
          label1632:
          if (localObject2 == null) {}
          for (localObject2 = null;; localObject2 = ((RecyclerView.v)localObject2).caK)
          {
            ((b.b)localObject4).a((View)localObject1, (View)localObject2, paramInt, (MultiTaskInfo)localObject5, false);
            break;
            localObject2 = ((WxRecyclerView)localObject1).fU(paramInt + 1);
            break label1663;
            localObject1 = ((WxRecyclerView)localObject1).fU(1);
            if (localObject1 == null)
            {
              localObject1 = null;
              break label1690;
            }
            localObject1 = ((RecyclerView.v)localObject1).caK;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label1690;
            }
            localObject1 = ((View)localObject1).findViewById(e.c.multi_task_item_bg);
            break label1690;
            label1791:
            localObject1 = ((b)localObject4).getRootView().findViewById(e.c.LDN);
            break label1690;
          }
          localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.a)localObject1).LGr;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label1045;
          }
          localObject1 = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).eDe();
          break label1045;
          paramInt = 0;
          break label1078;
          localObject2 = g.LBa;
          localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
          break label1100;
          localObject1 = null;
          break label1115;
        }
      }
    }
  }
  
  public final void acx(int paramInt)
  {
    AppMethodBeat.i(304808);
    Log.i(TAG, s.X("updateLoadingMode, loadingMode:", Integer.valueOf(paramInt)));
    MultiTaskContainerView localMultiTaskContainerView = this.LHz;
    if (localMultiTaskContainerView != null) {
      localMultiTaskContainerView.acx(paramInt);
    }
    AppMethodBeat.o(304808);
  }
  
  public final void acy(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(304765);
    boolean bool3 = glg();
    Log.d(TAG, "initEnterEduReport, eduType:" + paramInt + ", isShow:" + bool3);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
    if (localObject != null) {}
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(304765);
      return;
    case 1: 
      ((dry)localObject).aaXL = new drv();
      ((dry)localObject).aaXL.aaXw = paramInt;
      ((dry)localObject).aaXL.aaXv = cn.bDw();
      localObject = ((dry)localObject).aaXL;
      if (!bool3) {}
      for (bool1 = true;; bool1 = false)
      {
        ((drv)localObject).AMQ = bool1;
        AppMethodBeat.o(304765);
        return;
      }
    case 2: 
      ((dry)localObject).aaXM = new drv();
      ((dry)localObject).aaXM.aaXw = paramInt;
      ((dry)localObject).aaXM.aaXv = cn.bDw();
      localObject = ((dry)localObject).aaXM;
      if (!bool3) {}
      for (;;)
      {
        ((drv)localObject).AMQ = bool1;
        AppMethodBeat.o(304765);
        return;
        bool1 = false;
      }
    }
    ((dry)localObject).aaXN = new drv();
    ((dry)localObject).aaXN.aaXw = paramInt;
    ((dry)localObject).aaXN.aaXv = cn.bDw();
    localObject = ((dry)localObject).aaXN;
    if (!bool3) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((drv)localObject).AMQ = bool1;
      break;
    }
  }
  
  public final void acz(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(304769);
    if (this.LHt == 9) {
      this.LHt = 3;
    }
    Object localObject1 = this.LHp;
    label49:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof b)) {
        break label200;
      }
      localObject1 = (b)localObject1;
      if ((localObject1 == null) || (((b)localObject1).gkY() != 1L)) {
        break label205;
      }
      i = 1;
      label64:
      if (i == 0) {
        break label210;
      }
      i = 2;
      label70:
      this.LHu = i;
      Log.d(TAG, "initExitEduReport, eduType:" + paramInt + ", eduExitType:" + this.LHt + ", listEduType:" + this.LHu);
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
      if (localObject1 != null) {
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(304769);
      return;
      g localg = g.LBa;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
      break;
      label200:
      localObject1 = null;
      break label49;
      label205:
      i = 0;
      break label64;
      label210:
      i = 1;
      break label70;
      localObject3 = ((dry)localObject1).aaXL;
      if (localObject3 == null) {}
      for (localObject1 = localObject2; localObject1 != null; localObject1 = ah.aiuX)
      {
        AppMethodBeat.o(304769);
        return;
        ((drv)localObject3).aaXw = paramInt;
        ((drv)localObject3).aaXy = this.LHu;
        ((drv)localObject3).aaXx = this.LHt;
        if (cn.bDw() >= ((drv)localObject3).aaXv)
        {
          ((drv)localObject3).duration += cn.bDw() - ((drv)localObject3).aaXv;
          ((drv)localObject3).aaXv = cn.bDw();
        }
        localObject2 = com.tencent.mm.plugin.multitask.d.a.LDj;
        com.tencent.mm.plugin.multitask.d.a.a((drv)localObject3);
        ((dry)localObject1).aaXL = null;
      }
      localObject2 = ((dry)localObject1).aaXM;
      if (localObject2 == null) {}
      for (localObject1 = localObject3; localObject1 != null; localObject1 = ah.aiuX)
      {
        AppMethodBeat.o(304769);
        return;
        if (!((drv)localObject2).AMQ)
        {
          Log.i(TAG, "EduTypeEnterReport is skip");
          AppMethodBeat.o(304769);
          return;
        }
        ((drv)localObject2).aaXw = paramInt;
        ((drv)localObject2).aaXy = this.LHu;
        ((drv)localObject2).aaXx = this.LHt;
        if ((this.LHt != 7) && (cn.bDw() >= ((drv)localObject2).aaXv))
        {
          ((drv)localObject2).duration += cn.bDw() - ((drv)localObject2).aaXv;
          ((drv)localObject2).aaXv = cn.bDw();
        }
        localObject3 = com.tencent.mm.plugin.multitask.d.a.LDj;
        com.tencent.mm.plugin.multitask.d.a.a((drv)localObject2);
        ((dry)localObject1).aaXM = null;
      }
      localObject2 = ((dry)localObject1).aaXN;
      if (localObject2 != null)
      {
        ((drv)localObject2).aaXw = paramInt;
        ((drv)localObject2).aaXy = this.LHu;
        ((drv)localObject2).aaXx = this.LHt;
        if (cn.bDw() >= ((drv)localObject2).aaXv)
        {
          ((drv)localObject2).duration += cn.bDw() - ((drv)localObject2).aaXv;
          ((drv)localObject2).aaXv = cn.bDw();
        }
        localObject3 = com.tencent.mm.plugin.multitask.d.a.LDj;
        com.tencent.mm.plugin.multitask.d.a.a((drv)localObject2);
        ((dry)localObject1).aaXN = null;
        localObject1 = ah.aiuX;
      }
    }
  }
  
  public final void cI(float paramFloat)
  {
    b localb = null;
    int k = 1;
    int j = 1;
    float f2 = 0.0F;
    AppMethodBeat.i(304778);
    Object localObject1 = this.LHp;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = g.LBa;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aNW(g.gjs());
      if ((localObject1 != null) && ((localObject1 instanceof d)))
      {
        localObject1 = (d)localObject1;
        if (((d)localObject1).cvt())
        {
          i = LHY;
          localObject2 = com.tencent.mm.plugin.multitask.f.a.LIu;
          f1 = 1.0F - (i + com.tencent.mm.plugin.multitask.f.a.glP() + LIc) / ((d)localObject1).getRootView().getWidth();
          if (paramFloat < f1) {
            break label817;
          }
        }
      }
    }
    label258:
    label558:
    label817:
    for (float f1 = (paramFloat - f1) / (1.0F - f1);; f1 = 0.0F)
    {
      i = LHY;
      localObject2 = com.tencent.mm.plugin.multitask.f.a.LIu;
      float f3 = -(i + com.tencent.mm.plugin.multitask.f.a.glP() + LIc);
      i = LHY;
      localObject2 = com.tencent.mm.plugin.multitask.f.a.LIu;
      float f4 = i + com.tencent.mm.plugin.multitask.f.a.glP() + LIc;
      ((d)localObject1).getRootView().setTranslationX(f3 + f4 * f1);
      Log.d("MicroMsg.SnapShotMultiTaskUIC", "onPanelSlide, factor: %f", new Object[] { Float.valueOf(f1) });
      localObject1 = this.LHz;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label603;
        }
        i = sJv;
        label225:
        f4 = i * LId;
        localObject1 = this.LHz;
        if (localObject1 != null) {
          break label613;
        }
        localObject1 = null;
        label248:
        if (localObject1 != null) {
          break label626;
        }
        i = sJv;
        float f5 = f4 / (i - LHY);
        if (!this.LHC) {
          break label721;
        }
        if ((paramFloat > f5) || (0.0F > paramFloat)) {
          break label667;
        }
        localObject1 = this.LHA;
        if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0)) {
          break label636;
        }
        i = j;
        label313:
        if (i == 0)
        {
          localObject1 = this.LHA;
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        f3 = (paramFloat - 0.0F) / (f5 - 0.0F);
        if (f3 >= 0.0F) {
          break label642;
        }
        f1 = 0.0F;
        label354:
        localObject1 = this.LHA;
        if (localObject1 != null)
        {
          localObject2 = this.LHA;
          if (localObject2 != null) {
            break label657;
          }
          i = 0;
          label379:
          ((View)localObject1).setTranslationX(-((0 - i) / 2 + (f4 - 0.0F) * f1 / 2.0F));
        }
        Log.d(TAG, "checkShowEnterTips,show now!, transFractor:" + f1 + ", minslide:0, maxslide:" + f5 + ", slideOffset:" + paramFloat);
        label445:
        localObject1 = this.LHp;
        if (localObject1 != null) {
          break label774;
        }
        localObject1 = null;
        label459:
        if ((localObject1 instanceof b)) {
          localb = (b)localObject1;
        }
        f1 = 1.0F - f5;
        if (paramFloat < f1) {
          break label812;
        }
      }
      for (f1 = (paramFloat - f1) / (1.0F - f1);; f1 = 0.0F)
      {
        if (localb != null) {
          localb.aI(paramFloat, f1);
        }
        localObject1 = this.LHz;
        if (localObject1 != null)
        {
          f1 = ((MultiTaskContainerView)localObject1).getWidth() * 0.18F;
          paramFloat = (((MultiTaskContainerView)localObject1).getWidth() - LHY) * paramFloat;
          if (paramFloat >= f1) {
            break label793;
          }
          paramFloat /= f1;
          paramFloat = 1.0F - paramFloat * (paramFloat * paramFloat);
          localObject1 = this.LHq;
          if (localObject1 != null)
          {
            if (paramFloat >= 0.0F) {
              break label798;
            }
            paramFloat = f2;
          }
        }
        for (;;)
        {
          ((ImageView)localObject1).setAlpha(paramFloat);
          AppMethodBeat.o(304778);
          return;
          localObject1 = Integer.valueOf(((MultiTaskContainerView)localObject1).getWidth());
          break;
          label603:
          i = ((Integer)localObject1).intValue();
          break label225;
          label613:
          localObject1 = Integer.valueOf(((MultiTaskContainerView)localObject1).getWidth());
          break label248;
          label626:
          i = ((Integer)localObject1).intValue();
          break label258;
          label636:
          i = 0;
          break label313;
          f1 = f3;
          if (f3 <= 1.0F) {
            break label354;
          }
          f1 = 1.0F;
          break label354;
          i = ((View)localObject2).getWidth();
          break label379;
          localObject1 = this.LHA;
          if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0)) {}
          for (i = k;; i = 0)
          {
            if (i == 0) {
              break label719;
            }
            localObject1 = this.LHA;
            if (localObject1 == null) {
              break;
            }
            ((View)localObject1).setVisibility(4);
            break;
          }
          label719:
          break label445;
          label721:
          localObject1 = this.LHA;
          if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label772;
            }
            localObject1 = this.LHA;
            if (localObject1 == null) {
              break;
            }
            ((View)localObject1).setVisibility(4);
            break;
          }
          break label445;
          localObject2 = g.LBa;
          localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
          break label459;
          paramFloat = 0.0F;
          break label558;
          if (paramFloat > 1.0F) {
            paramFloat = 1.0F;
          }
        }
      }
    }
  }
  
  public final void cJ(float paramFloat)
  {
    AppMethodBeat.i(304782);
    if (this.LHC)
    {
      AppMethodBeat.o(304782);
      return;
    }
    if (glb())
    {
      MultiTaskContainerView localMultiTaskContainerView = this.LHz;
      if (localMultiTaskContainerView != null) {
        localMultiTaskContainerView.cK(paramFloat);
      }
    }
    AppMethodBeat.o(304782);
  }
  
  public final String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(304803);
    s.u(paramString, "id");
    Object localObject1 = this.LHp;
    if (localObject1 != null)
    {
      g localg = g.LBa;
      localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).cq(0, g.gjr());
      if (localObject1 != null)
      {
        localObject1 = (b)localObject1;
        s.u(paramString, "id");
        int i = ((b)localObject1).aNX(paramString);
        if ((paramInt1 != i) && (i >= 0) && (i < ((b)localObject1).LGW.size()))
        {
          if (paramInt2 == 4)
          {
            if (((b)localObject1).LGW.size() <= 2)
            {
              paramString = ((b)localObject1).AZd;
              if (paramString == null) {
                paramString = null;
              }
            }
            for (;;)
            {
              localObject1 = com.tencent.mm.plugin.multitask.f.c.LIw;
              paramString = com.tencent.mm.plugin.multitask.f.c.il(paramString);
              AppMethodBeat.o(304803);
              return paramString;
              paramString = paramString.fU(1);
              if (paramString == null)
              {
                paramString = null;
              }
              else
              {
                paramString = paramString.caK;
                if (paramString == null)
                {
                  paramString = null;
                }
                else
                {
                  paramString = paramString.findViewById(e.c.multi_task_item_bg);
                  continue;
                  paramString = ((b)localObject1).getRootView().findViewById(e.c.LDN);
                }
              }
            }
          }
          paramString = ((b)localObject1).AZd;
          if (paramString == null) {}
          for (localObject1 = null;; localObject1 = paramString.fU(i + 1))
          {
            paramString = localObject2;
            if (localObject1 == null) {
              break;
            }
            paramString = ((RecyclerView.v)localObject1).caK;
            break;
          }
        }
        AppMethodBeat.o(304803);
        return "";
      }
    }
    AppMethodBeat.o(304803);
    return "";
  }
  
  public final void gkA()
  {
    AppMethodBeat.i(304787);
    this.LHC = false;
    Object localObject = this.LHn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.ui.base.b)localObject).gkt();
    }
    if (!glb())
    {
      localObject = this.LHz;
      if (localObject != null) {
        ((MultiTaskContainerView)localObject).acx(0);
      }
    }
    localObject = this.LHp;
    if (localObject != null)
    {
      g localg = g.LBa;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).cq(0, g.gjr());
      if (localObject != null) {
        ((b)localObject).gkX();
      }
    }
    AppMethodBeat.o(304787);
  }
  
  public final void gkB()
  {
    AppMethodBeat.i(304784);
    MultiTaskContainerView localMultiTaskContainerView = this.LHz;
    if (localMultiTaskContainerView != null) {
      localMultiTaskContainerView.acx(0);
    }
    AppMethodBeat.o(304784);
  }
  
  public final void gkC()
  {
    AppMethodBeat.i(304773);
    this.LHy += 1;
    Log.d(TAG, "playsound count: %d", new Object[] { Integer.valueOf(this.LHy) });
    AppMethodBeat.o(304773);
  }
  
  public final boolean gkD()
  {
    AppMethodBeat.i(304770);
    if ((isDataEmpty()) && (!gkZ()))
    {
      Log.d(TAG, "needExpand, false!");
      AppMethodBeat.o(304770);
      return false;
    }
    AppMethodBeat.o(304770);
    return true;
  }
  
  public final boolean gkZ()
  {
    AppMethodBeat.i(304761);
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.LHn;
    if ((localb != null) && (localb.getCurItem() == 0))
    {
      AppMethodBeat.o(304761);
      return true;
    }
    AppMethodBeat.o(304761);
    return false;
  }
  
  public final void glc()
  {
    AppMethodBeat.i(304774);
    Object localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
    if (com.tencent.mm.plugin.multitask.e.b.gkn())
    {
      Log.i(TAG, "[enterTips]is already show, skip!, step 1");
      AppMethodBeat.o(304774);
      return;
    }
    localObject = this.LHv;
    if ((localObject != null) && (((b)localObject).glL()))
    {
      Log.i(TAG, "[enterTips]chatting is foreground, skip!, step 1");
      AppMethodBeat.o(304774);
      return;
    }
    if (2 == this.LHw) {
      Log.i(TAG, "[enterTips]is landscape mode, skip!, step 1");
    }
    localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
    long l = com.tencent.mm.plugin.multitask.e.b.gkq();
    localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
    if ((!com.tencent.mm.plugin.multitask.e.b.gkp()) || (Math.abs(System.currentTimeMillis() - l) > 1800000L))
    {
      Log.i(TAG, "[enterTips] not show, skip!, step 1");
      localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
      com.tencent.mm.plugin.multitask.e.b.zF(false);
      AppMethodBeat.o(304774);
      return;
    }
    if (this.LHB != null)
    {
      this.mRi.removeCallbacks(this.LHB);
      this.LHB = null;
    }
    this.LHB = new c..ExternalSyntheticLambda1(this);
    this.mRi.postDelayed(this.LHB, 500L);
    AppMethodBeat.o(304774);
  }
  
  public final void glf()
  {
    AppMethodBeat.i(304801);
    if ((this.LHH) || (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zua, 0) == 1))
    {
      AppMethodBeat.o(304801);
      return;
    }
    Log.i(TAG, "virbg: switchToDynamicBg");
    this.LHH = true;
    if (this.LHG != null)
    {
      this.mRi.removeCallbacks(this.LHG);
      this.LHG = null;
    }
    DynamicBgContainer localDynamicBgContainer = this.LHE;
    if (localDynamicBgContainer != null) {
      localDynamicBgContainer.gkJ();
    }
    AppMethodBeat.o(304801);
  }
  
  public final boolean glg()
  {
    AppMethodBeat.i(304815);
    Object localObject = this.LHp;
    if (localObject != null)
    {
      g localg = g.LBa;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).cq(1048576, g.gjs());
      if (localObject != null)
      {
        boolean bool = ((d)localObject).cvt();
        AppMethodBeat.o(304815);
        return bool;
      }
    }
    AppMethodBeat.o(304815);
    return false;
  }
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(304785);
    Object localObject = this.LHp;
    if (localObject != null)
    {
      g localg = g.LBa;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).cq(0, g.gjr());
      if (localObject != null)
      {
        boolean bool = ((b)localObject).isDataEmpty();
        AppMethodBeat.o(304785);
        return bool;
      }
    }
    AppMethodBeat.o(304785);
    return true;
  }
  
  public final void jV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304753);
    a.jW(paramInt1, paramInt2);
    Object localObject = this.LHp;
    if (localObject != null)
    {
      g localg = g.LBa;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).cq(0, g.gjr());
      if (localObject != null) {
        ((b)localObject).exz();
      }
    }
    AppMethodBeat.o(304753);
  }
  
  public final void jr(boolean paramBoolean)
  {
    int i = 1;
    boolean bool3 = false;
    AppMethodBeat.i(304811);
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.LHn;
    boolean bool4;
    if (localb != null)
    {
      bool4 = localb.getCanSlide();
      Log.i(TAG, "enableScroll: " + paramBoolean + ", canSlide:" + bool4 + ", orientation:" + this.LHw + ", currentTabIndex:" + this.LHx);
      if (((this.LHw != 2) && (!isDataEmpty()) && (this.LHx == 0)) || (gkZ())) {
        break label246;
      }
      Log.i(TAG, s.X("enableScroll false, isDataEmpty: ", Boolean.valueOf(isDataEmpty())));
    }
    label240:
    label246:
    for (boolean bool1 = false;; bool1 = paramBoolean)
    {
      boolean bool2 = bool1;
      if (glg())
      {
        bool2 = bool1;
        if (gkZ())
        {
          Log.i(TAG, "enableScroll false, showSnapshot Already");
          bool2 = false;
        }
      }
      b localb1 = this.LHv;
      if ((localb1 != null) && (localb1.glK() == true))
      {
        if (i == 0) {
          break label240;
        }
        Log.i(TAG, "enableScroll false, isHeaderOpen");
      }
      for (bool1 = bool3;; bool1 = bool2)
      {
        if (bool4 == paramBoolean)
        {
          AppMethodBeat.o(304811);
          return;
          i = 0;
          break;
        }
        localb.setCanSlide(bool1);
        AppMethodBeat.o(304811);
        return;
      }
    }
  }
  
  public final void k(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304813);
    s.u(paramMultiTaskInfo, "taskInfo");
    gli();
    gld();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adgS, paramMultiTaskInfo.field_id + '|' + cn.bDw());
    Log.i(TAG, s.X("enterFullScreenMode, id:", paramMultiTaskInfo.field_id));
    AppMethodBeat.o(304813);
  }
  
  public final void mh(boolean paramBoolean)
  {
    AppMethodBeat.i(304828);
    if (gkZ())
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
        if (localObject != null)
        {
          if (((dry)localObject).aaXI != null) {
            ((dry)localObject).AxK = cn.bDw();
          }
          AppMethodBeat.o(304828);
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (dry)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)getActivity(), 5, dry.class);
        if (localObject != null)
        {
          drw localdrw = ((dry)localObject).aaXI;
          if ((localdrw != null) && (cn.bDw() >= ((dry)localObject).AxK) && (!((dry)localObject).aaXK))
          {
            localdrw.duration += cn.bDw() - ((dry)localObject).AxK;
            ((dry)localObject).AxK = cn.bDw();
          }
        }
      }
    }
    AppMethodBeat.o(304828);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(304832);
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if (localb != null) {
      localb.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(304832);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(304835);
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if ((localb != null) && (localb.onBackPressed() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(304835);
      return true;
    }
    AppMethodBeat.o(304835);
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(304839);
    Log.i(TAG, "onBeforeFinish");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if (localb != null) {
      localb.onBeforeFinish(paramIntent);
    }
    AppMethodBeat.o(304839);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(304834);
    s.u(paramConfiguration, "newConfig");
    a.glJ();
    this.LHw = paramConfiguration.orientation;
    Object localObject;
    int i;
    if ((paramConfiguration.orientation == 2) && (!gkZ()))
    {
      jr(false);
      localObject = this.LHn;
      if ((localObject != null) && (((com.tencent.mm.plugin.multitask.ui.base.b)localObject).gku() == true))
      {
        i = 1;
        if (i != 0) {
          a(this, false, false, false, false, false, true, false, 192);
        }
      }
    }
    for (;;)
    {
      localObject = this.LHp;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).onConfigurationChanged(paramConfiguration);
      }
      AppMethodBeat.o(304834);
      return;
      i = 0;
      break;
      jr(true);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(304820);
    super.onCreate(paramBundle);
    this.LHF.alive();
    AppMethodBeat.o(304820);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(304818);
    Log.i(TAG, "onCreateBefore");
    this.LGo = paramBundle;
    AppMethodBeat.o(304818);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(304831);
    Log.i(TAG, "onDestroy, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(gkZ()) });
    ??? = this.LHp;
    if (??? != null) {
      ((com.tencent.mm.plugin.multitask.ui.panel.b)???).onDestroy();
    }
    this.LHF.dead();
    com.tencent.mm.plugin.multitask.ui.base.b localb = this.LHn;
    com.tencent.mm.plugin.multitask.ui.base.b.b localb1;
    if (localb != null) {
      localb1 = (com.tencent.mm.plugin.multitask.ui.base.b.b)this;
    }
    synchronized (localb.LEE)
    {
      localb.LEE.remove(localb1);
      ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).setListener(null);
      ??? = this.LHE;
      if (??? != null) {
        ((DynamicBgContainer)???).release();
      }
      this.mRi.removeCallbacksAndMessages(null);
      AppMethodBeat.o(304831);
      return;
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304836);
    s.u(paramKeyEvent, "event");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if ((localb != null) && (localb.onKeyDown(paramInt, paramKeyEvent) == true)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(304836);
      return true;
    }
    AppMethodBeat.o(304836);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304837);
    s.u(paramKeyEvent, "event");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if ((localb != null) && (localb.onKeyUp(paramInt, paramKeyEvent) == true)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(304837);
      return true;
    }
    AppMethodBeat.o(304837);
    return false;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(304829);
    Log.i(TAG, "onPause, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(gkZ()) });
    if (gkZ())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
      if (localb != null) {
        localb.onPause();
      }
      gld();
    }
    zH(false);
    AppMethodBeat.o(304829);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(304833);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if (localb != null) {
      localb.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(304833);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(304825);
    Log.i(TAG, "onRestoreInstanceState");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if (localb != null) {
      localb.onRestoreInstanceState(paramBundle);
    }
    AppMethodBeat.o(304825);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(304827);
    Log.i(TAG, "onResume, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(gkZ()) });
    int i;
    if (gkZ())
    {
      Object localObject = this.LHp;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).onResume();
      }
      if (this.LHp != null)
      {
        i = 1;
        if ((i != 0) && (!glg())) {
          glf();
        }
        localObject = this.LHp;
        if (localObject != null)
        {
          g localg = g.LBa;
          localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).cq(0, g.gjr());
          if (localObject != null) {
            ((b)localObject).gkV();
          }
        }
        gla();
      }
    }
    for (;;)
    {
      zH(true);
      AppMethodBeat.o(304827);
      return;
      i = 0;
      break;
      glh();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(304824);
    Log.i(TAG, "onSaveInstanceState");
    com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
    if (localb != null) {
      localb.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(304824);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(304826);
    Log.i(TAG, "onStart, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(gkZ()) });
    if (gkZ())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
      if (localb != null) {
        localb.onStart();
      }
    }
    AppMethodBeat.o(304826);
  }
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop()
  {
    AppMethodBeat.i(304830);
    Log.i(TAG, "onStop, isMultiTaskPanel:%b", new Object[] { Boolean.valueOf(gkZ()) });
    if (gkZ())
    {
      com.tencent.mm.plugin.multitask.ui.panel.b localb = this.LHp;
      if (localb != null) {
        localb.onStop();
      }
      gld();
    }
    AppMethodBeat.o(304830);
  }
  
  public final void zG(boolean paramBoolean)
  {
    AppMethodBeat.i(304817);
    Log.i(TAG, s.X("hideSnapshotUIC, remove:", Boolean.valueOf(paramBoolean)));
    Object localObject = this.LHp;
    if (localObject != null)
    {
      g localg = g.LBa;
      localObject = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject).cq(1048576, g.gjs());
      if ((localObject != null) && ((localObject instanceof d)))
      {
        ((d)localObject).glO();
        ((d)localObject).glN();
        if (paramBoolean) {
          com.tencent.threadpool.h.ahAA.bk(new c..ExternalSyntheticLambda0(this));
        }
      }
    }
    AppMethodBeat.o(304817);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$Companion;", "", "()V", "HOME_EXPOSE_WIDTH", "", "getHOME_EXPOSE_WIDTH", "()I", "setHOME_EXPOSE_WIDTH", "(I)V", "MIN_ENTER_DRAG_TIP_SHOW_FRACTOR", "", "getMIN_ENTER_DRAG_TIP_SHOW_FRACTOR", "()F", "setMIN_ENTER_DRAG_TIP_SHOW_FRACTOR", "(F)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TIPS_TRANS_WIDTH", "getTIPS_TRANS_WIDTH", "setTIPS_TRANS_WIDTH", "_2A", "get_2A", "set_2A", "_2_5A", "get_2_5A", "set_2_5A", "canvasHeight", "getCanvasHeight", "setCanvasHeight", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "font_size", "getFont_size", "setFont_size", "image_scale", "getImage_scale", "setImage_scale", "itemButtomPadding", "getItemButtomPadding", "setItemButtomPadding", "itemHeaderHeight", "getItemHeaderHeight", "setItemHeaderHeight", "itemHeight", "getItemHeight", "setItemHeight", "itemHoritonalPadding", "getItemHoritonalPadding", "setItemHoritonalPadding", "itemImgHeight", "getItemImgHeight", "setItemImgHeight", "itemImgWidth", "getItemImgWidth", "setItemImgWidth", "itemTitleHeight", "getItemTitleHeight", "setItemTitleHeight", "itemWidth", "getItemWidth", "setItemWidth", "oneItemContentHeight", "getOneItemContentHeight", "setOneItemContentHeight", "oneItemContentWidth", "getOneItemContentWidth", "setOneItemContentWidth", "oneItemFromLeft", "getOneItemFromLeft", "setOneItemFromLeft", "oneItemFromTop", "getOneItemFromTop", "setOneItemFromTop", "oneItemImgHeight", "getOneItemImgHeight", "setOneItemImgHeight", "oneItemImgWidth", "getOneItemImgWidth", "setOneItemImgWidth", "portraitHeight", "getPortraitHeight", "setPortraitHeight", "portraitWidth", "getPortraitWidth", "setPortraitWidth", "scale", "getScale", "setScale", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "twoItemFromLeft", "getTwoItemFromLeft", "setTwoItemFromLeft", "twoItemFromTop", "getTwoItemFromTop", "setTwoItemFromTop", "initMultiTaskViewParams", "", "screenSizeW", "screenSizeH", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void glJ()
    {
      AppMethodBeat.i(304257);
      jW(com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()), com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()));
      AppMethodBeat.o(304257);
    }
    
    public static void jW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(304268);
      com.tencent.mm.plugin.multitask.ui.base.b.a locala = com.tencent.mm.plugin.multitask.ui.base.b.LEA;
      c.acV(com.tencent.mm.plugin.multitask.ui.base.b.gkz());
      c.acD(paramInt1);
      c.acE(paramInt2);
      c.acB(Math.min(c.gll(), c.glm()));
      c.acC(Math.max(c.gll(), c.glm()));
      c.acF(c.gll() * 2 - c.glB());
      c.acG(c.glm());
      c.cL(bd.fromDPToPix(MMApplicationContext.getContext(), 59) / c.glj());
      c.acH(bd.fromDPToPix(MMApplicationContext.getContext(), 12));
      c.acI(bd.fromDPToPix(MMApplicationContext.getContext(), 14));
      c.acJ(bd.fromDPToPix(MMApplicationContext.getContext(), 20));
      c.acX(bd.fromDPToPix(MMApplicationContext.getContext(), 44));
      c.acW(bd.fromDPToPix(MMApplicationContext.getContext(), 32) - c.access$get_2A$cp());
      c.acK(kotlin.h.a.eH((c.glj() - c.glB() - c.gln() * 2) / 2.0F));
      c.acO(c.glp() - c.access$get_2A$cp());
      c.acP(kotlin.h.a.eH(c.glt() * c.glI()));
      c.cM((c.glu() + c.access$get_2A$cp() + c.glC() + c.glD() * c.glG() + bd.fromDPToPix(MMApplicationContext.getContext(), 16)) / c.glp());
      c.acL(kotlin.h.a.eH(c.glp() * c.glH()));
      c.acM(kotlin.h.a.eH(c.glp() * 1.5F));
      c.acN(kotlin.h.a.eH(c.glr() * c.glH()));
      c.acQ(c.glr() - c.access$get_2A$cp());
      c.acR(kotlin.h.a.eH(c.glv() * c.glI()));
      c.acS(kotlin.h.a.ah((c.glk() - c.gls() - c.access$get_2A$cp() * 6) / 2.0D));
      if (c.glx() < 0) {
        c.acS(0);
      }
      c.acT(kotlin.h.a.ah((c.glj() - c.glB() - c.glr()) / 2.0D - c.gln()));
      c.glz();
      c.acU(kotlin.h.a.ah((c.glk() - c.glq() - c.access$get_2A$cp() * 8) / 2.0D));
      Log.i(c.access$getTAG$cp(), "initMultiTaskViewParams width:" + c.glp() + " height:" + c.glq() + " oneItemContentWidth:" + c.glr() + " oneItemContentHeight:" + c.gls());
      AppMethodBeat.o(304268);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "", "getCurrentTabIndex", "", "isChattingForeground", "", "isHeaderOpen", "multiTaskStateChanged", "", "state", "curIndex", "multiTaskTabChanged", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void acY(int paramInt);
    
    public abstract void acZ(int paramInt);
    
    public abstract int getCurrentTabIndex();
    
    public abstract boolean glK();
    
    public abstract boolean glL();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$1$1$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(304260);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = this.LIg.LHn;
      int i;
      boolean bool2;
      if ((paramView != null) && (paramView.gku() == true))
      {
        i = 1;
        if (i == 0) {
          break label120;
        }
        bool2 = true;
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        this.LIg.a(true, true, false, false, false, bool1, false, bool2);
        if (bool2) {
          this.LIg.acz(1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(304260);
        return;
        i = 0;
        break;
        label120:
        bool2 = false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.c
 * JD-Core Version:    0.7.0.1
 */