package com.tencent.mm.plugin.multitask.ui.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.animation.c.a.d.a;
import com.tencent.mm.plugin.multitask.c.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.c.a.b.a;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "HIDE_DURATION", "", "HIDE_LOADING", "LoadingHandler", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1;", "SHOW_DURATION", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;)V", "checkShowSnapshotIfNeed", "", "size", "forceHide", "taskInfo", "forceShow", "getDefaultBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "onlyBg", "getLayoutId", "getMultiTaskInfo", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getViewHeight", "getViewWidth", "hideSnapshotUIC", "", "hideloading", "isShow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "info", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPanelSlide", "panel", "slideOffset", "", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "showSnapshotUIC", "showloading", "startEnterAnim", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"})
public final class SnapShotMultiTaskUIC
  extends MultiTaskUIComponent
{
  public static final SnapShotMultiTaskUIC.a Agz;
  com.tencent.mm.plugin.multitask.animation.a.a Agt;
  MultiTaskInfo Agu;
  private final int Agv;
  private final int Agw;
  private final int Agx;
  private final b Agy;
  
  static
  {
    AppMethodBeat.i(236727);
    Agz = new SnapShotMultiTaskUIC.a((byte)0);
    AppMethodBeat.o(236727);
  }
  
  public SnapShotMultiTaskUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(236726);
    this.Agw = 10000;
    this.Agx = 1000;
    this.Agy = new b(this, Looper.getMainLooper());
    AppMethodBeat.o(236726);
  }
  
  public SnapShotMultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(236725);
    this.Agw = 10000;
    this.Agx = 1000;
    this.Agy = new b(this, Looper.getMainLooper());
    AppMethodBeat.o(236725);
  }
  
  private final void a(final View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(236721);
    if ((paramView == null) || (paramMultiTaskInfo == null))
    {
      paramc.RL(0);
      AppMethodBeat.o(236721);
      return;
    }
    final z.f localf = new z.f();
    if (paramMultiTaskInfo.erh().MwT) {}
    Object localObject;
    for (localf.SYG = ex(paramView.findViewById(2131305006)); ((Bitmap)localf.SYG == null) || (((Bitmap)localf.SYG).isRecycled()) || (((Bitmap)localf.SYG).getWidth() == 0) || (((Bitmap)localf.SYG).getHeight() == 0); localf.SYG = com.tencent.mm.plugin.multitask.f.a.aGR((String)localObject))
    {
      Log.w("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, page get bitmap is null");
      paramc.RL(0);
      AppMethodBeat.o(236721);
      return;
      localObject = com.tencent.mm.plugin.multitask.h.zZn;
      localObject = com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo);
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.AgJ;
    }
    ((ImageView)getRootView().findViewById(2131305000)).setImageBitmap(null);
    if (this.Agt != null)
    {
      localObject = this.Agt;
      if (localObject != null) {
        localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent();
      }
      while (p.j(localObject, getRootView()))
      {
        localObject = getRootView();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(236721);
          throw paramView;
          localObject = null;
        }
        else
        {
          ((FrameLayout)localObject).removeView((View)this.Agt);
        }
      }
    }
    final int i = getViewWidth();
    final int j = getViewHeight();
    int k;
    int m;
    if (paramMultiTaskInfo.erh().MwT)
    {
      paramMultiTaskInfo = com.tencent.mm.ui.n.a.hn(paramView.findViewById(2131305010));
      this.Agt = ((com.tencent.mm.plugin.multitask.animation.a.a)new com.tencent.mm.plugin.multitask.animation.a.b(paramView.getContext(), (Bitmap)localf.SYG, paramMultiTaskInfo));
      if (paramMultiTaskInfo != null)
      {
        k = (i - paramMultiTaskInfo.getWidth()) / 2;
        m = (j - paramMultiTaskInfo.getHeight()) / 2;
        paramView = this.Agt;
        if (paramView != null) {
          paramView.setDefaultDstRect(new Rect(k, m, paramMultiTaskInfo.getWidth() + k, paramMultiTaskInfo.getHeight() + m));
        }
      }
    }
    for (;;)
    {
      paramView = this.Agt;
      if (paramView != null) {
        paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      }
      paramView = getRootView();
      if (paramView != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(236721);
      throw paramView;
      this.Agt = ((com.tencent.mm.plugin.multitask.animation.a.a)new com.tencent.mm.plugin.multitask.animation.a.c(paramView.getContext(), (Bitmap)localf.SYG));
    }
    ((FrameLayout)paramView).addView((View)this.Agt, 0);
    if (paramcrq != null) {}
    for (;;)
    {
      try
      {
        paramView = paramcrq.lcm;
        if (Util.isNullOrNil(paramView)) {
          break label639;
        }
        if (paramView == null) {
          break label613;
        }
        paramView = (CharSequence)paramView;
        paramView = new k(",").q(paramView, 0);
        if (paramView == null) {
          break label613;
        }
        paramView = ((Collection)paramView).toArray(new String[0]);
        if (paramView != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(236721);
        throw paramView;
      }
      catch (Exception paramView)
      {
        paramc.RL(0);
        Log.e("MicroMsg.SnapShotMultiTaskUIC", "get pos value failed, %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(236721);
        return;
      }
      paramView = null;
    }
    paramView = (String[])paramView;
    if (paramView == null) {
      label613:
      paramView = null;
    }
    for (;;)
    {
      if ((paramView == null) || (paramView.length != 4))
      {
        paramc.RL(0);
        AppMethodBeat.o(236721);
        return;
        label639:
        paramc.RL(0);
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, snapPos is null or empty");
        AppMethodBeat.o(236721);
        return;
      }
      getRootView().setVisibility(0);
      paramMultiTaskInfo = new Rect(0, 0, i, j);
      paramcrq = Integer.valueOf((String)paramView[0]);
      p.g(paramcrq, "Integer.valueOf(posVec.get(0))");
      k = paramcrq.intValue();
      paramcrq = Integer.valueOf((String)paramView[1]);
      p.g(paramcrq, "Integer.valueOf(posVec.get(1))");
      m = paramcrq.intValue();
      paramcrq = Integer.valueOf((String)paramView[2]);
      p.g(paramcrq, "Integer.valueOf(posVec.get(2))");
      int n = paramcrq.intValue();
      paramView = Integer.valueOf((String)paramView[3]);
      p.g(paramView, "Integer.valueOf(posVec.get(3))");
      paramView = new Rect(k, m, n, paramView.intValue());
      n = paramView.left;
      int i1 = paramView.width() / 2;
      k = paramView.top;
      m = paramView.height() / 2;
      float f2 = paramMultiTaskInfo.left + paramMultiTaskInfo.width() / 2 - (n + i1);
      n = paramMultiTaskInfo.top;
      float f3 = paramMultiTaskInfo.height() / 2 + n - (k + m);
      final float f1 = paramView.width() / i;
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setTranslationX(-f2);
      }
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setTranslationY(-f3);
      }
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setScaleX(f1);
      }
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setScaleY(f1);
      }
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setDstRect(new Rect(0, 0, i, j));
      }
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.hk(i, j);
      }
      f2 = (j * f1 - paramView.height()) / 2.0F * (1.0F / f1);
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.m(f2, i, j - f2);
      }
      paramMultiTaskInfo = this.Agt;
      if (paramMultiTaskInfo != null)
      {
        paramcrq = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        f2 = com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() / f1;
        paramcrq = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        f3 = com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() / f1;
        paramcrq = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        float f4 = com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() / f1;
        paramcrq = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        paramMultiTaskInfo.m(f2, f3, f4, com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() / f1);
      }
      com.tencent.mm.ui.c.a.a.gu((View)this.Agt).cn(0.0F).co(0.0F).cp(1.0F).cq(1.0F).a((b.a)new f(this, i, j, f1, paramView)).c((Interpolator)new DecelerateInterpolator()).aK((Runnable)new g(paramc, localf)).aJ((Runnable)new h(paramc)).gKg().start();
      AppMethodBeat.o(236721);
      return;
    }
  }
  
  private static Bitmap ex(View paramView)
  {
    AppMethodBeat.i(236722);
    if (paramView != null) {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        paramView = paramView.getBackground();
        if (paramView != null) {
          paramView.draw(localCanvas);
        }
        AppMethodBeat.o(236722);
        return localBitmap;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SnapShotMultiTaskUIC", "%s", new Object[] { Util.stackTraceToString((Throwable)paramView) });
      }
    }
    AppMethodBeat.o(236722);
    return null;
  }
  
  private int getViewHeight()
  {
    AppMethodBeat.i(236724);
    AppCompatActivity localAppCompatActivity = getActivity();
    Object localObject = localAppCompatActivity;
    if (!(localAppCompatActivity instanceof MMActivity)) {
      localObject = null;
    }
    localObject = (MMActivity)localObject;
    if (localObject != null)
    {
      localObject = ((MMActivity)localObject).getBodyView();
      if (localObject != null)
      {
        i = ((View)localObject).getHeight();
        AppMethodBeat.o(236724);
        return i;
      }
    }
    localObject = getActivity().getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "activity.window.decorView");
    int i = ((View)localObject).getHeight();
    AppMethodBeat.o(236724);
    return i;
  }
  
  private int getViewWidth()
  {
    AppMethodBeat.i(236723);
    AppCompatActivity localAppCompatActivity = getActivity();
    Object localObject = localAppCompatActivity;
    if (!(localAppCompatActivity instanceof MMActivity)) {
      localObject = null;
    }
    localObject = (MMActivity)localObject;
    if (localObject != null)
    {
      localObject = ((MMActivity)localObject).getBodyView();
      if (localObject != null)
      {
        i = ((View)localObject).getWidth();
        AppMethodBeat.o(236723);
        return i;
      }
    }
    localObject = getActivity().getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "activity.window.decorView");
    int i = ((View)localObject).getWidth();
    AppMethodBeat.o(236723);
    return i;
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 1048576;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, final Object paramObject)
  {
    AppMethodBeat.i(236714);
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    this.Agu = paramMultiTaskInfo;
    a(paramView, paramMultiTaskInfo, paramcrq, (com.tencent.mm.plugin.multitask.c.c)new d(this, paramObject));
    AppMethodBeat.o(236714);
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(236720);
    if (getRootView().getVisibility() == 0)
    {
      AppMethodBeat.o(236720);
      return true;
    }
    AppMethodBeat.o(236720);
    return false;
  }
  
  public final void dk(Object paramObject)
  {
    AppMethodBeat.i(236713);
    getRootView().setOnClickListener((View.OnClickListener)SnapShotMultiTaskUIC.c.AgB);
    AppMethodBeat.o(236713);
  }
  
  public final void dkr()
  {
    AppMethodBeat.i(236710);
    esB();
    esA();
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = getRootView().getContext();
    p.g(localObject, "rootView.context");
    ((MultiTaskUIC)com.tencent.mm.ui.component.a.ko((Context)localObject).get(MultiTaskUIC.class)).hx(true);
    AppMethodBeat.o(236710);
  }
  
  public final a.b dks()
  {
    return a.b.Aci;
  }
  
  public final void erV()
  {
    AppMethodBeat.i(236717);
    m(this.Agu);
    AppMethodBeat.o(236717);
  }
  
  public final void esA()
  {
    AppMethodBeat.i(236716);
    ProgressBar localProgressBar = (ProgressBar)getRootView().findViewById(2131305001);
    p.g(localProgressBar, "loadingView");
    localProgressBar.setVisibility(8);
    this.Agy.removeMessages(this.Agx);
    this.Agy.removeMessages(this.Agv);
    AppMethodBeat.o(236716);
  }
  
  public final void esB()
  {
    AppMethodBeat.i(236719);
    if (getRootView().getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "hideSnapshotUIC, isInVisible:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(236719);
      return;
    }
    getRootView().setVisibility(8);
    Object localObject = getRootView();
    com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.AgJ;
    ((View)localObject).setTranslationX(0.0F - com.tencent.mm.plugin.multitask.f.a.esC());
    ((ImageView)getRootView().findViewById(2131305000)).setImageBitmap(null);
    if (this.Agt != null)
    {
      localObject = this.Agt;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent();
        if (!p.j(localObject, getRootView())) {
          break label198;
        }
        localObject = this.Agt;
        if (localObject == null) {
          break label174;
        }
      }
      label174:
      for (localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent();; localObject = null)
      {
        if (localObject != null) {
          break label179;
        }
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(236719);
        throw ((Throwable)localObject);
        localObject = null;
        break;
      }
      label179:
      ((ViewGroup)localObject).removeView((View)this.Agt);
      this.Agt = null;
    }
    label198:
    AppMethodBeat.o(236719);
  }
  
  public final void esz()
  {
    AppMethodBeat.i(236715);
    this.Agy.removeMessages(this.Agx);
    this.Agy.sendEmptyMessageDelayed(this.Agx, this.Agx);
    this.Agy.removeMessages(this.Agv);
    this.Agy.sendEmptyMessageDelayed(this.Agv, this.Agw);
    AppMethodBeat.o(236715);
  }
  
  public final int getLayoutId()
  {
    return 2131495489;
  }
  
  public final void m(final MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(236718);
    if (getRootView().getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "showSnapshotUIC, isVisible:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(236718);
      return;
    }
    esA();
    getRootView().setVisibility(0);
    View localView = getRootView();
    Object localObject = MultiTaskUIC.Ago;
    int i = MultiTaskUIC.esq();
    localObject = com.tencent.mm.plugin.multitask.f.a.AgJ;
    localView.setTranslationX(0.0F - (i + com.tencent.mm.plugin.multitask.f.a.esC()));
    com.tencent.f.h.RTc.aZ((Runnable)new e(this, paramMultiTaskInfo));
    AppMethodBeat.o(236718);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(236709);
    p.h(paramConfiguration, "newConfig");
    AppMethodBeat.o(236709);
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236711);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(236711);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236712);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(236712);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236708);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(236708);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "ui-multitask_release"})
  public static final class b
    extends MMHandler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(236696);
      p.h(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == SnapShotMultiTaskUIC.a(this.AgA))
      {
        paramMessage = (ProgressBar)this.AgA.getRootView().findViewById(2131305001);
        p.g(paramMessage, "loadingView");
        paramMessage.setVisibility(0);
        AppMethodBeat.o(236696);
        return;
      }
      if (i == SnapShotMultiTaskUIC.b(this.AgA))
      {
        this.AgA.esA();
        this.AgA.esB();
        paramMessage = com.tencent.mm.ui.component.a.PRN;
        paramMessage = this.AgA.getRootView().getContext();
        p.g(paramMessage, "rootView.context");
        ((MultiTaskUIC)com.tencent.mm.ui.component.a.ko(paramMessage).get(MultiTaskUIC.class)).hx(true);
        paramMessage = g.aAh();
        p.g(paramMessage, "MMKernel.storage()");
        paramMessage.azQ().set(ar.a.Oot, "");
      }
      AppMethodBeat.o(236696);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskItemClick$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "ui-multitask_release"})
  public static final class d
    implements com.tencent.mm.plugin.multitask.c.c
  {
    d(Object paramObject) {}
    
    public final void RL(int paramInt)
    {
      AppMethodBeat.i(236699);
      if ((paramObject instanceof com.tencent.mm.plugin.multitask.c.c)) {
        ((com.tencent.mm.plugin.multitask.c.c)paramObject).RL(0);
      }
      this.AgA.esA();
      Object localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = this.AgA.getRootView().getContext();
      p.g(localObject, "rootView.context");
      ((MultiTaskUIC)com.tencent.mm.ui.component.a.ko((Context)localObject).get(MultiTaskUIC.class)).hx(true);
      AppMethodBeat.o(236699);
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(236700);
      if ((paramObject instanceof com.tencent.mm.plugin.multitask.c.c)) {
        c.a.a((com.tencent.mm.plugin.multitask.c.c)paramObject, paramBitmap, false, 6);
      }
      this.AgA.esA();
      this.AgA.getRootView().setTranslationX(0.0F);
      paramBitmap = com.tencent.mm.ui.component.a.PRN;
      paramBitmap = this.AgA.getRootView().getContext();
      p.g(paramBitmap, "rootView.context");
      ((MultiTaskUIC)com.tencent.mm.ui.component.a.ko(paramBitmap).get(MultiTaskUIC.class)).hx(false);
      AppMethodBeat.o(236700);
    }
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(236701);
      this.AgA.esz();
      if ((paramObject instanceof com.tencent.mm.plugin.multitask.c.c)) {
        c.a.a((com.tencent.mm.plugin.multitask.c.c)paramObject, paramBitmap);
      }
      AppMethodBeat.o(236701);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(SnapShotMultiTaskUIC paramSnapShotMultiTaskUIC, MultiTaskInfo paramMultiTaskInfo) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(236704);
      Object localObject1 = com.tencent.mm.plugin.multitask.h.zZn;
      localObject1 = com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo);
      Object localObject2 = com.tencent.mm.plugin.multitask.f.a.AgJ;
      Object localObject4 = com.tencent.mm.plugin.multitask.f.a.aGR((String)localObject1);
      if (localObject4 != null)
      {
        localObject1 = Integer.valueOf(((Bitmap)localObject4).getWidth());
        if (localObject4 == null) {
          break label218;
        }
        localObject2 = Integer.valueOf(((Bitmap)localObject4).getHeight());
        label58:
        if ((localObject1 == null) || (localObject2 == null)) {
          break label223;
        }
        final int i = ((Number)localObject2).intValue();
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(((Number)localObject1).intValue(), i, this, (Bitmap)localObject4));
        localObject1 = x.SXb;
        label102:
        if (localObject1 == null)
        {
          localObject2 = new StringBuilder("showSnapshotUIC, error! id:");
          localObject1 = paramMultiTaskInfo;
          if (localObject1 == null) {
            break label228;
          }
        }
      }
      label218:
      label223:
      label228:
      for (localObject1 = ((MultiTaskInfo)localObject1).field_id;; localObject1 = null)
      {
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", title:");
        localObject4 = paramMultiTaskInfo;
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((MultiTaskInfo)localObject4).erh();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((cru)localObject4).title;
          }
        }
        Log.i("MicroMsg.SnapShotMultiTaskUIC", (String)localObject1);
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this));
        localObject1 = x.SXb;
        AppMethodBeat.o(236704);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label58;
        localObject1 = null;
        break label102;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$showSnapshotUIC$1$2$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(SnapShotMultiTaskUIC.e parame)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$showSnapshotUIC$1$1$1"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(int paramInt1, int paramInt2, SnapShotMultiTaskUIC.e parame, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "onUpdate"})
  static final class f
    implements b.a
  {
    f(SnapShotMultiTaskUIC paramSnapShotMultiTaskUIC, int paramInt1, int paramInt2, float paramFloat, Rect paramRect) {}
    
    public final void by(float paramFloat)
    {
      AppMethodBeat.i(236705);
      float f1 = i;
      float f2 = (j * f1 - paramView.height()) / 2.0F * (1.0F - paramFloat) * (1.0F / f1);
      float f3 = j;
      com.tencent.mm.plugin.multitask.animation.a.a locala = this.AgA.Agt;
      if (locala != null) {
        locala.setMaskAlpha((int)(255.0F * (1.0F - paramFloat)));
      }
      locala = this.AgA.Agt;
      if (locala != null) {
        locala.m(f2, f1, f3 - f2);
      }
      locala = this.AgA.Agt;
      if (locala != null)
      {
        d.a locala1 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        f1 = com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() * (1.0F - paramFloat) / f1;
        locala1 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        f2 = com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() * (1.0F - paramFloat) / f1;
        locala1 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        f3 = com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() * (1.0F - paramFloat) / f1;
        locala1 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
        locala.m(f1, f2, f3, com.tencent.mm.plugin.multitask.animation.c.a.d.eqK() * (1.0F - paramFloat) / f1);
      }
      locala = this.AgA.Agt;
      if (locala != null)
      {
        locala.postInvalidate();
        AppMethodBeat.o(236705);
        return;
      }
      AppMethodBeat.o(236705);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(com.tencent.mm.plugin.multitask.c.c paramc, z.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(236706);
      com.tencent.mm.plugin.multitask.c.c localc = this.zZX;
      if (localc != null)
      {
        c.a.a(localc, (Bitmap)localf.SYG, false, 6);
        AppMethodBeat.o(236706);
        return;
      }
      AppMethodBeat.o(236706);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(com.tencent.mm.plugin.multitask.c.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(236707);
      com.tencent.mm.plugin.multitask.c.c localc = this.zZX;
      if (localc != null)
      {
        c.a.a(localc, null);
        AppMethodBeat.o(236707);
        return;
      }
      AppMethodBeat.o(236707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */