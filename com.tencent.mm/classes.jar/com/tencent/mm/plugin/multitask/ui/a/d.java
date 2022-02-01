package com.tencent.mm.plugin.multitask.ui.a;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.c.a.b.a;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.Collection;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "HIDE_DURATION", "", "HIDE_LOADING", "LoadingHandler", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1;", "SHOW_DURATION", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;)V", "checkShowSnapshotIfNeed", "", "size", "forceHide", "taskInfo", "forceShow", "getDefaultBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "onlyBg", "getLayoutId", "getMultiTaskInfo", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getViewHeight", "getViewWidth", "hideSnapshotUIC", "", "hideloading", "isShow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "info", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPanelSlide", "panel", "slideOffset", "", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "showSnapshotUIC", "showloading", "startEnterAnim", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"})
public final class d
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final d.a FNn;
  com.tencent.mm.plugin.multitask.animation.a.a FNh;
  MultiTaskInfo FNi;
  private final int FNj;
  private final int FNk;
  private final int FNl;
  private final b FNm;
  
  static
  {
    AppMethodBeat.i(196621);
    FNn = new d.a((byte)0);
    AppMethodBeat.o(196621);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(196618);
    this.FNk = 10000;
    this.FNl = 1000;
    this.FNm = new b(this, Looper.getMainLooper());
    AppMethodBeat.o(196618);
  }
  
  public d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(196620);
    this.FNk = 10000;
    this.FNl = 1000;
    this.FNm = new b(this, Looper.getMainLooper());
    AppMethodBeat.o(196620);
  }
  
  private final void a(final View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(196610);
    if ((paramView == null) || (paramMultiTaskInfo == null))
    {
      paramc.Yb(0);
      AppMethodBeat.o(196610);
      return;
    }
    final aa.f localf = new aa.f();
    if (paramMultiTaskInfo.fbc().TIi) {}
    Object localObject;
    for (localf.aaBC = fx(paramView.findViewById(e.c.multi_task_item_bg)); ((Bitmap)localf.aaBC == null) || (((Bitmap)localf.aaBC).isRecycled()) || (((Bitmap)localf.aaBC).getWidth() == 0) || (((Bitmap)localf.aaBC).getHeight() == 0); localf.aaBC = com.tencent.mm.plugin.multitask.f.a.aRg((String)localObject))
    {
      Log.w("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, page get bitmap is null");
      paramc.Yb(0);
      AppMethodBeat.o(196610);
      return;
      localObject = com.tencent.mm.plugin.multitask.h.FFb;
      localObject = com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo);
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.FNz;
    }
    ((ImageView)getRootView().findViewById(e.c.FIB)).setImageBitmap(null);
    if (this.FNh != null)
    {
      localObject = this.FNh;
      if (localObject != null) {
        localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent();
      }
      while (p.h(localObject, getRootView()))
      {
        localObject = getRootView();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(196610);
          throw paramView;
          localObject = null;
        }
        else
        {
          ((FrameLayout)localObject).removeView((View)this.FNh);
        }
      }
    }
    final int i = getViewWidth();
    final int j = getViewHeight();
    int k;
    int m;
    if (paramMultiTaskInfo.fbc().TIi)
    {
      paramMultiTaskInfo = com.tencent.mm.ui.p.a.iC(paramView.findViewById(e.c.FIL));
      this.FNh = ((com.tencent.mm.plugin.multitask.animation.a.a)new com.tencent.mm.plugin.multitask.animation.a.b(paramView.getContext(), (Bitmap)localf.aaBC, paramMultiTaskInfo));
      if (paramMultiTaskInfo != null)
      {
        k = (i - paramMultiTaskInfo.getWidth()) / 2;
        m = (j - paramMultiTaskInfo.getHeight()) / 2;
        paramView = this.FNh;
        if (paramView != null) {
          paramView.setDefaultDstRect(new Rect(k, m, paramMultiTaskInfo.getWidth() + k, paramMultiTaskInfo.getHeight() + m));
        }
      }
    }
    for (;;)
    {
      paramView = this.FNh;
      if (paramView != null) {
        paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      }
      paramView = getRootView();
      if (paramView != null) {
        break;
      }
      paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(196610);
      throw paramView;
      this.FNh = ((com.tencent.mm.plugin.multitask.animation.a.a)new com.tencent.mm.plugin.multitask.animation.a.c(paramView.getContext(), (Bitmap)localf.aaBC));
    }
    ((FrameLayout)paramView).addView((View)this.FNh, 0);
    if (paramdal != null) {}
    for (;;)
    {
      try
      {
        paramView = paramdal.nWv;
        if (Util.isNullOrNil(paramView)) {
          break label640;
        }
        if (paramView == null) {
          break label614;
        }
        paramView = (CharSequence)paramView;
        paramView = new k(",").u(paramView, 0);
        if (paramView == null) {
          break label614;
        }
        paramView = ((Collection)paramView).toArray(new String[0]);
        if (paramView != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(196610);
        throw paramView;
      }
      catch (Exception paramView)
      {
        paramc.Yb(0);
        Log.e("MicroMsg.SnapShotMultiTaskUIC", "get pos value failed, %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(196610);
        return;
      }
      paramView = null;
    }
    paramView = (String[])paramView;
    if (paramView == null) {
      label614:
      paramView = null;
    }
    for (;;)
    {
      if ((paramView == null) || (paramView.length != 4))
      {
        paramc.Yb(0);
        AppMethodBeat.o(196610);
        return;
        label640:
        paramc.Yb(0);
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, snapPos is null or empty");
        AppMethodBeat.o(196610);
        return;
      }
      getRootView().setVisibility(0);
      paramMultiTaskInfo = new Rect(0, 0, i, j);
      paramdal = Integer.valueOf((String)paramView[0]);
      p.j(paramdal, "Integer.valueOf(posVec.get(0))");
      k = paramdal.intValue();
      paramdal = Integer.valueOf((String)paramView[1]);
      p.j(paramdal, "Integer.valueOf(posVec.get(1))");
      m = paramdal.intValue();
      paramdal = Integer.valueOf((String)paramView[2]);
      p.j(paramdal, "Integer.valueOf(posVec.get(2))");
      int n = paramdal.intValue();
      paramView = Integer.valueOf((String)paramView[3]);
      p.j(paramView, "Integer.valueOf(posVec.get(3))");
      paramView = new Rect(k, m, n, paramView.intValue());
      n = paramView.left;
      int i1 = paramView.width() / 2;
      k = paramView.top;
      m = paramView.height() / 2;
      float f2 = paramMultiTaskInfo.left + paramMultiTaskInfo.width() / 2 - (n + i1);
      n = paramMultiTaskInfo.top;
      float f3 = paramMultiTaskInfo.height() / 2 + n - (k + m);
      final float f1 = paramView.width() / i;
      paramMultiTaskInfo = this.FNh;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setTranslationX(-f2);
      }
      paramMultiTaskInfo = this.FNh;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setTranslationY(-f3);
      }
      paramMultiTaskInfo = this.FNh;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setScaleX(f1);
      }
      paramMultiTaskInfo = this.FNh;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.setScaleY(f1);
      }
      if (!ar.hII())
      {
        paramMultiTaskInfo = this.FNh;
        if (paramMultiTaskInfo != null) {
          paramMultiTaskInfo.setDstRect(new Rect(0, 0, i, j));
        }
        paramMultiTaskInfo = this.FNh;
        if (paramMultiTaskInfo != null) {
          paramMultiTaskInfo.ip(i, j);
        }
      }
      f2 = (j * f1 - paramView.height()) / 2.0F * (1.0F / f1);
      paramMultiTaskInfo = this.FNh;
      if (paramMultiTaskInfo != null) {
        paramMultiTaskInfo.n(f2, i, j - f2);
      }
      paramMultiTaskInfo = this.FNh;
      if (paramMultiTaskInfo != null)
      {
        paramdal = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        f2 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() / f1;
        paramdal = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        f3 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() / f1;
        paramdal = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        float f4 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() / f1;
        paramdal = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        paramMultiTaskInfo.n(f2, f3, f4, com.tencent.mm.plugin.multitask.animation.c.a.c.faB() / f1);
      }
      com.tencent.mm.ui.c.a.a.hF((View)this.FNh).cF(0.0F).cG(0.0F).cH(1.0F).cI(1.0F).a((b.a)new f(this, i, j, f1, paramView)).c((Interpolator)new DecelerateInterpolator()).aQ((Runnable)new g(paramc, localf)).aP((Runnable)new h(paramc)).Vw(250L).start();
      AppMethodBeat.o(196610);
      return;
    }
  }
  
  private static Bitmap fx(View paramView)
  {
    AppMethodBeat.i(196611);
    if (paramView != null) {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        paramView = paramView.getBackground();
        if (paramView != null) {
          paramView.draw(localCanvas);
        }
        AppMethodBeat.o(196611);
        return localBitmap;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SnapShotMultiTaskUIC", "%s", new Object[] { Util.stackTraceToString((Throwable)paramView) });
      }
    }
    AppMethodBeat.o(196611);
    return null;
  }
  
  private int getViewHeight()
  {
    AppMethodBeat.i(196617);
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
        AppMethodBeat.o(196617);
        return i;
      }
    }
    localObject = getActivity().getWindow();
    p.j(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "activity.window.decorView");
    int i = ((View)localObject).getHeight();
    AppMethodBeat.o(196617);
    return i;
  }
  
  private int getViewWidth()
  {
    AppMethodBeat.i(196614);
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
        AppMethodBeat.o(196614);
        return i;
      }
    }
    localObject = getActivity().getWindow();
    p.j(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "activity.window.decorView");
    int i = ((View)localObject).getWidth();
    AppMethodBeat.o(196614);
    return i;
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 1048576;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, final Object paramObject)
  {
    AppMethodBeat.i(196588);
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    this.FNi = paramMultiTaskInfo;
    a(paramView, paramMultiTaskInfo, paramdal, (com.tencent.mm.plugin.multitask.c.c)new d(this, paramObject));
    AppMethodBeat.o(196588);
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(196601);
    if (getRootView().getVisibility() == 0)
    {
      AppMethodBeat.o(196601);
      return true;
    }
    AppMethodBeat.o(196601);
    return false;
  }
  
  public final void dKo()
  {
    AppMethodBeat.i(196582);
    fcL();
    fcK();
    Object localObject = g.Xox;
    localObject = getRootView().getContext();
    p.j(localObject, "rootView.context");
    ((c)g.lm((Context)localObject).i(c.class)).in(true);
    AppMethodBeat.o(196582);
  }
  
  public final a.b dKp()
  {
    return a.b.FHY;
  }
  
  public final void dp(Object paramObject)
  {
    AppMethodBeat.i(196586);
    getRootView().setOnClickListener((View.OnClickListener)d.c.FNp);
    AppMethodBeat.o(196586);
  }
  
  public final void fcJ()
  {
    AppMethodBeat.i(196591);
    this.FNm.removeMessages(this.FNl);
    this.FNm.sendEmptyMessageDelayed(this.FNl, this.FNl);
    this.FNm.removeMessages(this.FNj);
    this.FNm.sendEmptyMessageDelayed(this.FNj, this.FNk);
    AppMethodBeat.o(196591);
  }
  
  public final void fcK()
  {
    AppMethodBeat.i(196592);
    ProgressBar localProgressBar = (ProgressBar)getRootView().findViewById(e.c.FIC);
    p.j(localProgressBar, "loadingView");
    localProgressBar.setVisibility(8);
    this.FNm.removeMessages(this.FNl);
    this.FNm.removeMessages(this.FNj);
    AppMethodBeat.o(196592);
  }
  
  public final void fcL()
  {
    AppMethodBeat.i(196600);
    if (getRootView().getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "hideSnapshotUIC, isInVisible:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(196600);
      return;
    }
    getRootView().setVisibility(8);
    Object localObject = getRootView();
    com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.FNz;
    ((View)localObject).setTranslationX(0.0F - com.tencent.mm.plugin.multitask.f.a.fcM());
    ((ImageView)getRootView().findViewById(e.c.FIB)).setImageBitmap(null);
    if (this.FNh != null)
    {
      localObject = this.FNh;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent();
        if (!p.h(localObject, getRootView())) {
          break label198;
        }
        localObject = this.FNh;
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
        AppMethodBeat.o(196600);
        throw ((Throwable)localObject);
        localObject = null;
        break;
      }
      label179:
      ((ViewGroup)localObject).removeView((View)this.FNh);
      this.FNh = null;
    }
    label198:
    AppMethodBeat.o(196600);
  }
  
  public final void fcd()
  {
    AppMethodBeat.i(196593);
    l(this.FNi);
    AppMethodBeat.o(196593);
  }
  
  public final int getLayoutId()
  {
    return e.d.FIY;
  }
  
  public final void l(final MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(196596);
    if (getRootView().getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "showSnapshotUIC, isVisible:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(196596);
      return;
    }
    fcK();
    getRootView().setVisibility(0);
    View localView = getRootView();
    Object localObject = c.FNc;
    int i = c.fcy();
    localObject = com.tencent.mm.plugin.multitask.f.a.FNz;
    int j = com.tencent.mm.plugin.multitask.f.a.fcM();
    localObject = c.FNc;
    localView.setTranslationX(0.0F - (i + j + c.fcC()));
    com.tencent.e.h.ZvG.bg((Runnable)new e(this, paramMultiTaskInfo));
    AppMethodBeat.o(196596);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(196575);
    p.k(paramConfiguration, "newConfig");
    AppMethodBeat.o(196575);
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196583);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(196583);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196585);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(196585);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196573);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(196573);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "ui-multitask_release"})
  public static final class b
    extends MMHandler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(196364);
      p.k(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == d.a(this.FNo))
      {
        paramMessage = (ProgressBar)this.FNo.getRootView().findViewById(e.c.FIC);
        p.j(paramMessage, "loadingView");
        paramMessage.setVisibility(0);
        AppMethodBeat.o(196364);
        return;
      }
      if (i == d.b(this.FNo))
      {
        this.FNo.fcK();
        this.FNo.fcL();
        paramMessage = g.Xox;
        paramMessage = this.FNo.getRootView().getContext();
        p.j(paramMessage, "rootView.context");
        ((c)g.lm(paramMessage).i(c.class)).in(true);
        paramMessage = com.tencent.mm.kernel.h.aHG();
        p.j(paramMessage, "MMKernel.storage()");
        paramMessage.aHp().set(ar.a.VDR, "");
      }
      AppMethodBeat.o(196364);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskItemClick$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "ui-multitask_release"})
  public static final class d
    implements com.tencent.mm.plugin.multitask.c.c
  {
    d(Object paramObject) {}
    
    public final void Yb(int paramInt)
    {
      AppMethodBeat.i(196232);
      if ((paramObject instanceof com.tencent.mm.plugin.multitask.c.c)) {
        ((com.tencent.mm.plugin.multitask.c.c)paramObject).Yb(0);
      }
      this.FNo.fcK();
      Object localObject = g.Xox;
      localObject = this.FNo.getRootView().getContext();
      p.j(localObject, "rootView.context");
      ((c)g.lm((Context)localObject).i(c.class)).in(true);
      AppMethodBeat.o(196232);
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(196233);
      if ((paramObject instanceof com.tencent.mm.plugin.multitask.c.c)) {
        com.tencent.mm.plugin.multitask.c.c.a.a((com.tencent.mm.plugin.multitask.c.c)paramObject, paramBitmap, false, 6);
      }
      this.FNo.fcK();
      this.FNo.getRootView().setTranslationX(0.0F);
      paramBitmap = g.Xox;
      paramBitmap = this.FNo.getRootView().getContext();
      p.j(paramBitmap, "rootView.context");
      ((c)g.lm(paramBitmap).i(c.class)).in(false);
      AppMethodBeat.o(196233);
    }
    
    public final void h(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(196234);
      this.FNo.fcJ();
      if ((paramObject instanceof com.tencent.mm.plugin.multitask.c.c)) {
        com.tencent.mm.plugin.multitask.c.c.a.a((com.tencent.mm.plugin.multitask.c.c)paramObject, paramBitmap);
      }
      AppMethodBeat.o(196234);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(d paramd, MultiTaskInfo paramMultiTaskInfo) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(196085);
      Object localObject1 = com.tencent.mm.plugin.multitask.h.FFb;
      localObject1 = com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo);
      Object localObject2 = com.tencent.mm.plugin.multitask.f.a.FNz;
      Object localObject4 = com.tencent.mm.plugin.multitask.f.a.aRg((String)localObject1);
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
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(((Number)localObject1).intValue(), i, this, (Bitmap)localObject4));
        localObject1 = x.aazN;
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
          localObject4 = ((MultiTaskInfo)localObject4).fbc();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((dar)localObject4).title;
          }
        }
        Log.i("MicroMsg.SnapShotMultiTaskUIC", (String)localObject1);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
        localObject1 = x.aazN;
        AppMethodBeat.o(196085);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label58;
        localObject1 = null;
        break label102;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$showSnapshotUIC$1$2$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(d.e parame)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$showSnapshotUIC$1$1$1"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(int paramInt1, int paramInt2, d.e parame, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "onUpdate"})
  static final class f
    implements b.a
  {
    f(d paramd, int paramInt1, int paramInt2, float paramFloat, Rect paramRect) {}
    
    public final void bB(float paramFloat)
    {
      AppMethodBeat.i(196561);
      float f1 = i;
      float f2 = (j * f1 - paramView.height()) / 2.0F * (1.0F - paramFloat) * (1.0F / f1);
      float f3 = j;
      com.tencent.mm.plugin.multitask.animation.a.a locala = this.FNo.FNh;
      if (locala != null) {
        locala.setMaskAlpha((int)(255.0F * (1.0F - paramFloat)));
      }
      locala = this.FNo.FNh;
      if (locala != null) {
        locala.n(f2, f1, f3 - f2);
      }
      locala = this.FNo.FNh;
      if (locala != null)
      {
        com.tencent.mm.plugin.multitask.animation.c.a.c.a locala1 = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        f1 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * (1.0F - paramFloat) / f1;
        locala1 = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        f2 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * (1.0F - paramFloat) / f1;
        locala1 = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        f3 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * (1.0F - paramFloat) / f1;
        locala1 = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        locala.n(f1, f2, f3, com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * (1.0F - paramFloat) / f1);
      }
      locala = this.FNo.FNh;
      if (locala != null)
      {
        locala.postInvalidate();
        AppMethodBeat.o(196561);
        return;
      }
      AppMethodBeat.o(196561);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(com.tencent.mm.plugin.multitask.c.c paramc, aa.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(197335);
      com.tencent.mm.plugin.multitask.c.c localc = this.FFN;
      if (localc != null)
      {
        com.tencent.mm.plugin.multitask.c.c.a.a(localc, (Bitmap)localf.aaBC, false, 6);
        AppMethodBeat.o(197335);
        return;
      }
      AppMethodBeat.o(197335);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(com.tencent.mm.plugin.multitask.c.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(196137);
      com.tencent.mm.plugin.multitask.c.c localc = this.FFN;
      if (localc != null)
      {
        com.tencent.mm.plugin.multitask.c.c.a.a(localc, null);
        AppMethodBeat.o(196137);
        return;
      }
      AppMethodBeat.o(196137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.d
 * JD-Core Version:    0.7.0.1
 */