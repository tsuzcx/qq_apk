package com.tencent.mm.plugin.multitask.ui.uic;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "HIDE_DURATION", "", "HIDE_LOADING", "LoadingHandler", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1;", "SHOW_DURATION", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;)V", "checkShowSnapshotIfNeed", "", "size", "forceHide", "taskInfo", "forceShow", "getDefaultBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "onlyBg", "getLayoutId", "getMultiTaskInfo", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getViewHeight", "getViewWidth", "hideSnapshotUIC", "", "hideloading", "isShow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "info", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPanelSlide", "panel", "slideOffset", "", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "showSnapshotUIC", "showloading", "startEnterAnim", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final d.a LIh;
  private com.tencent.mm.plugin.multitask.animation.a.a LIi;
  MultiTaskInfo LIj;
  private final int LIk;
  private final int LIl;
  private final int LIm;
  private final b LIn;
  
  static
  {
    AppMethodBeat.i(304388);
    LIh = new d.a((byte)0);
    AppMethodBeat.o(304388);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(304285);
    this.LIl = 10000;
    this.LIm = 1000;
    this.LIn = new b(this, Looper.getMainLooper());
    AppMethodBeat.o(304285);
  }
  
  public d(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(304292);
    this.LIl = 10000;
    this.LIm = 1000;
    this.LIn = new b(this, Looper.getMainLooper());
    AppMethodBeat.o(304292);
  }
  
  private static final void a(int paramInt1, int paramInt2, float paramFloat1, Rect paramRect, d paramd, float paramFloat2)
  {
    AppMethodBeat.i(304358);
    s.u(paramRect, "$potision");
    s.u(paramd, "this$0");
    float f1 = paramInt1;
    float f2 = (paramInt2 * paramFloat1 - paramRect.height()) / 2.0F * (1.0F - paramFloat2) * (1.0F / paramFloat1);
    float f3 = paramInt2;
    paramRect = paramd.LIi;
    if (paramRect != null) {
      paramRect.setMaskAlpha((int)(255.0F * (1.0F - paramFloat2)));
    }
    paramRect = paramd.LIi;
    if (paramRect != null) {
      paramRect.r(f2, f1, f3 - f2);
    }
    paramRect = paramd.LIi;
    if (paramRect != null)
    {
      com.tencent.mm.plugin.multitask.animation.c.a.c.a locala = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      f1 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * (1.0F - paramFloat2) / paramFloat1;
      locala = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      f2 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * (1.0F - paramFloat2) / paramFloat1;
      locala = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      f3 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * (1.0F - paramFloat2) / paramFloat1;
      locala = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      paramRect.r(f1, f2, f3, com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * (1.0F - paramFloat2) / paramFloat1);
    }
    paramRect = paramd.LIi;
    if (paramRect != null) {
      paramRect.postInvalidate();
    }
    AppMethodBeat.o(304358);
  }
  
  private final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(304317);
    if ((paramView == null) || (paramMultiTaskInfo == null))
    {
      paramc.aco(0);
      AppMethodBeat.o(304317);
      return;
    }
    ah.f localf = new ah.f();
    if (paramMultiTaskInfo.gkh().aaXR) {}
    Object localObject;
    for (localf.aqH = ij(paramView.findViewById(e.c.multi_task_item_bg)); (localf.aqH == null) || (((Bitmap)localf.aqH).isRecycled()) || (((Bitmap)localf.aqH).getWidth() == 0) || (((Bitmap)localf.aqH).getHeight() == 0); localf.aqH = com.tencent.mm.plugin.multitask.f.a.aNY((String)localObject))
    {
      Log.w("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, page get bitmap is null");
      paramc.aco(0);
      AppMethodBeat.o(304317);
      return;
      localObject = com.tencent.mm.plugin.multitask.h.LBd;
      localObject = com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo);
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.LIu;
    }
    ((ImageView)getRootView().findViewById(e.c.LDL)).setImageBitmap(null);
    if (this.LIi != null)
    {
      localObject = this.LIi;
      if (localObject != null) {
        break label444;
      }
      localObject = null;
      if (s.p(localObject, getRootView())) {
        ((FrameLayout)getRootView()).removeView((View)this.LIi);
      }
    }
    int i = getViewWidth();
    int j = getViewHeight();
    int k;
    int m;
    if (paramMultiTaskInfo.gkh().aaXR)
    {
      paramMultiTaskInfo = com.tencent.mm.ui.p.a.a(paramView.findViewById(e.c.LDV), Bitmap.Config.ARGB_8888);
      this.LIi = ((com.tencent.mm.plugin.multitask.animation.a.a)new com.tencent.mm.plugin.multitask.animation.a.b(paramView.getContext(), (Bitmap)localf.aqH, paramMultiTaskInfo));
      if (paramMultiTaskInfo != null)
      {
        k = (i - paramMultiTaskInfo.getWidth()) / 2;
        m = (j - paramMultiTaskInfo.getHeight()) / 2;
        paramView = this.LIi;
        if (paramView != null) {
          paramView.setDefaultDstRect(new Rect(k, m, paramMultiTaskInfo.getWidth() + k, paramMultiTaskInfo.getHeight() + m));
        }
      }
      label357:
      paramView = this.LIi;
      if (paramView != null) {
        paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      }
      ((FrameLayout)getRootView()).addView((View)this.LIi, 0);
      if (paramdrt != null) {
        break label483;
      }
      paramView = null;
    }
    for (;;)
    {
      try
      {
        boolean bool = Util.isNullOrNil(paramView);
        if (bool) {
          break label606;
        }
        if (paramView == null)
        {
          paramView = null;
          if ((paramView != null) && (paramView.length == 4)) {
            break label629;
          }
          paramc.aco(0);
          AppMethodBeat.o(304317);
          return;
          label444:
          localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent();
          break;
          this.LIi = ((com.tencent.mm.plugin.multitask.animation.a.a)new com.tencent.mm.plugin.multitask.animation.a.c(paramView.getContext(), (Bitmap)localf.aqH));
          break label357;
          label483:
          paramView = paramdrt.qWi;
          continue;
        }
        paramView = (CharSequence)paramView;
        paramView = new kotlin.n.k(",").o(paramView, 0);
        if (paramView == null)
        {
          paramView = null;
          continue;
        }
        paramView = ((Collection)paramView).toArray(new String[0]);
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(304317);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        paramc.aco(0);
        Log.e("MicroMsg.SnapShotMultiTaskUIC", "get pos value failed, %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(304317);
        return;
      }
      paramView = (String[])paramView;
      if (paramView == null)
      {
        paramView = null;
        continue;
        label606:
        paramc.aco(0);
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, snapPos is null or empty");
        AppMethodBeat.o(304317);
        return;
        label629:
        getRootView().setVisibility(0);
        paramMultiTaskInfo = new Rect(0, 0, i, j);
        paramdrt = Integer.valueOf(paramView[0]);
        s.s(paramdrt, "valueOf(posVec.get(0))");
        k = ((Number)paramdrt).intValue();
        paramdrt = Integer.valueOf(paramView[1]);
        s.s(paramdrt, "valueOf(posVec.get(1))");
        m = ((Number)paramdrt).intValue();
        paramdrt = Integer.valueOf(paramView[2]);
        s.s(paramdrt, "valueOf(posVec.get(2))");
        int n = ((Number)paramdrt).intValue();
        paramView = Integer.valueOf(paramView[3]);
        s.s(paramView, "valueOf(posVec.get(3))");
        paramView = new Rect(k, m, n, ((Number)paramView).intValue());
        n = paramView.left;
        int i1 = paramView.width() / 2;
        k = paramView.top;
        m = paramView.height() / 2;
        float f2 = paramMultiTaskInfo.left + paramMultiTaskInfo.width() / 2 - (n + i1);
        n = paramMultiTaskInfo.top;
        float f3 = paramMultiTaskInfo.height() / 2 + n - (k + m);
        float f1 = paramView.width() / i;
        paramMultiTaskInfo = this.LIi;
        if (paramMultiTaskInfo != null) {
          paramMultiTaskInfo.setTranslationX(-f2);
        }
        paramMultiTaskInfo = this.LIi;
        if (paramMultiTaskInfo != null) {
          paramMultiTaskInfo.setTranslationY(-f3);
        }
        paramMultiTaskInfo = this.LIi;
        if (paramMultiTaskInfo != null) {
          paramMultiTaskInfo.setScaleX(f1);
        }
        paramMultiTaskInfo = this.LIi;
        if (paramMultiTaskInfo != null) {
          paramMultiTaskInfo.setScaleY(f1);
        }
        if (!aw.jkT())
        {
          paramMultiTaskInfo = this.LIi;
          if (paramMultiTaskInfo != null) {
            paramMultiTaskInfo.setDstRect(new Rect(0, 0, i, j));
          }
          paramMultiTaskInfo = this.LIi;
          if (paramMultiTaskInfo != null) {
            paramMultiTaskInfo.ef(i, j);
          }
        }
        f2 = (j * f1 - paramView.height()) / 2.0F * (1.0F / f1);
        paramMultiTaskInfo = this.LIi;
        if (paramMultiTaskInfo != null) {
          paramMultiTaskInfo.r(f2, i, j - f2);
        }
        paramMultiTaskInfo = this.LIi;
        if (paramMultiTaskInfo != null)
        {
          paramdrt = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
          f2 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() / f1;
          paramdrt = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
          f3 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() / f1;
          paramdrt = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
          float f4 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() / f1;
          paramdrt = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
          paramMultiTaskInfo.r(f2, f3, f4, com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() / f1);
        }
        com.tencent.mm.ui.anim.a.a.kY((View)this.LIi).dS(0.0F).dT(0.0F).dU(1.0F).dV(1.0F).a(new d..ExternalSyntheticLambda1(i, j, f1, paramView, this)).d((Interpolator)new DecelerateInterpolator()).aY(new d..ExternalSyntheticLambda3(paramc, localf)).aX(new d..ExternalSyntheticLambda2(paramc)).zE(250L).start();
        AppMethodBeat.o(304317);
        return;
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.multitask.c.c paramc, ah.f paramf)
  {
    AppMethodBeat.i(304364);
    s.u(paramf, "$contentViewBitmap");
    if (paramc != null) {
      com.tencent.mm.plugin.multitask.c.c.a.a(paramc, (Bitmap)paramf.aqH, false, 6);
    }
    AppMethodBeat.o(304364);
  }
  
  private static final void a(final MultiTaskInfo paramMultiTaskInfo, d paramd)
  {
    Object localObject3 = null;
    AppMethodBeat.i(304350);
    s.u(paramd, "this$0");
    Object localObject1 = com.tencent.mm.plugin.multitask.h.LBd;
    localObject1 = com.tencent.mm.plugin.multitask.h.g(paramMultiTaskInfo);
    Object localObject2 = com.tencent.mm.plugin.multitask.f.a.LIu;
    final Bitmap localBitmap = com.tencent.mm.plugin.multitask.f.a.aNY((String)localObject1);
    if (localBitmap == null)
    {
      localObject1 = null;
      if (localBitmap != null) {
        break label186;
      }
      localObject2 = null;
      label50:
      if ((localObject1 == null) || (localObject2 == null)) {
        break label199;
      }
      final int i = ((Number)localObject2).intValue();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramd, ((Number)localObject1).intValue(), paramMultiTaskInfo, i, localBitmap));
      localObject1 = ah.aiuX;
      label97:
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder("showSnapshotUIC, error! id:");
        if (paramMultiTaskInfo != null) {
          break label204;
        }
        localObject1 = null;
        label119:
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", title:");
        if (paramMultiTaskInfo != null) {
          break label212;
        }
        paramMultiTaskInfo = localObject3;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", paramMultiTaskInfo);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d.e(paramd));
      AppMethodBeat.o(304350);
      return;
      localObject1 = Integer.valueOf(localBitmap.getWidth());
      break;
      label186:
      localObject2 = Integer.valueOf(localBitmap.getHeight());
      break label50;
      label199:
      localObject1 = null;
      break label97;
      label204:
      localObject1 = paramMultiTaskInfo.field_id;
      break label119;
      label212:
      localObject2 = paramMultiTaskInfo.gkh();
      paramMultiTaskInfo = localObject3;
      if (localObject2 != null) {
        paramMultiTaskInfo = ((drz)localObject2).title;
      }
    }
  }
  
  private static final void c(com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(304370);
    if (paramc != null) {
      com.tencent.mm.plugin.multitask.c.c.a.a(paramc, null);
    }
    AppMethodBeat.o(304370);
  }
  
  private int getViewHeight()
  {
    AppMethodBeat.i(304337);
    Object localObject = getActivity();
    if ((localObject instanceof MMActivity))
    {
      localObject = (MMActivity)localObject;
      if (localObject != null) {
        break label60;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label85;
      }
      i = getActivity().getWindow().getDecorView().getHeight();
      AppMethodBeat.o(304337);
      return i;
      localObject = null;
      break;
      label60:
      localObject = ((MMActivity)localObject).getBodyView();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((View)localObject).getHeight());
      }
    }
    label85:
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(304337);
    return i;
  }
  
  private int getViewWidth()
  {
    AppMethodBeat.i(304330);
    Object localObject = getActivity();
    if ((localObject instanceof MMActivity))
    {
      localObject = (MMActivity)localObject;
      if (localObject != null) {
        break label60;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label85;
      }
      i = getActivity().getWindow().getDecorView().getWidth();
      AppMethodBeat.o(304330);
      return i;
      localObject = null;
      break;
      label60:
      localObject = ((MMActivity)localObject).getBodyView();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((View)localObject).getWidth());
      }
    }
    label85:
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(304330);
    return i;
  }
  
  private static Bitmap ij(View paramView)
  {
    AppMethodBeat.i(304323);
    if (paramView != null) {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        paramView = paramView.getBackground();
        if (paramView != null) {
          paramView.draw(localCanvas);
        }
        AppMethodBeat.o(304323);
        return localBitmap;
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SnapShotMultiTaskUIC", "%s", new Object[] { Util.stackTraceToString((Throwable)paramView) });
      }
    }
    AppMethodBeat.o(304323);
    return null;
  }
  
  private static final void ik(View paramView)
  {
    AppMethodBeat.i(304341);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    Log.d("MicroMsg.SnapShotMultiTaskUIC", "snapshotview onClick!");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304341);
  }
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 1048576;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    AppMethodBeat.i(304555);
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
    this.LIj = paramMultiTaskInfo;
    a(paramView, paramMultiTaskInfo, paramdrt, (com.tencent.mm.plugin.multitask.c.c)new c(paramObject, this));
    AppMethodBeat.o(304555);
  }
  
  public final boolean cvt()
  {
    AppMethodBeat.i(304601);
    if (getRootView().getVisibility() == 0)
    {
      AppMethodBeat.o(304601);
      return true;
    }
    AppMethodBeat.o(304601);
    return false;
  }
  
  public final void eDd()
  {
    AppMethodBeat.i(304521);
    glO();
    glN();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = getRootView().getContext();
    s.s(localObject, "rootView.context");
    ((c)com.tencent.mm.ui.component.k.nq((Context)localObject).q(c.class)).jr(true);
    AppMethodBeat.o(304521);
  }
  
  public final a.b eDe()
  {
    return a.b.LDr;
  }
  
  public final void fw(Object paramObject)
  {
    AppMethodBeat.i(304549);
    getRootView().setOnClickListener(d..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(304549);
  }
  
  public final int getLayoutId()
  {
    return e.d.LEj;
  }
  
  public final void glM()
  {
    AppMethodBeat.i(304567);
    this.LIn.removeMessages(this.LIm);
    this.LIn.sendEmptyMessageDelayed(this.LIm, this.LIm);
    this.LIn.removeMessages(this.LIk);
    this.LIn.sendEmptyMessageDelayed(this.LIk, this.LIl);
    AppMethodBeat.o(304567);
  }
  
  public final void glN()
  {
    AppMethodBeat.i(304574);
    ((ProgressBar)getRootView().findViewById(e.c.LDM)).setVisibility(8);
    this.LIn.removeMessages(this.LIm);
    this.LIn.removeMessages(this.LIk);
    AppMethodBeat.o(304574);
  }
  
  public final void glO()
  {
    AppMethodBeat.i(304598);
    if (getRootView().getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "hideSnapshotUIC, isInVisible:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(304598);
      return;
    }
    getRootView().setVisibility(8);
    Object localObject = getRootView();
    com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.LIu;
    ((View)localObject).setTranslationX(0.0F - com.tencent.mm.plugin.multitask.f.a.glP());
    ((ImageView)getRootView().findViewById(e.c.LDL)).setImageBitmap(null);
    if (this.LIi != null)
    {
      localObject = this.LIi;
      if (localObject == null)
      {
        localObject = null;
        if (!s.p(localObject, getRootView())) {
          break label199;
        }
        localObject = this.LIi;
        if (localObject != null) {
          break label172;
        }
      }
      label172:
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent())
      {
        if (localObject != null) {
          break label180;
        }
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(304598);
        throw ((Throwable)localObject);
        localObject = ((com.tencent.mm.plugin.multitask.animation.a.a)localObject).getParent();
        break;
      }
      label180:
      ((ViewGroup)localObject).removeView((View)this.LIi);
      this.LIi = null;
    }
    label199:
    AppMethodBeat.o(304598);
  }
  
  public final void glh()
  {
    AppMethodBeat.i(304581);
    l(this.LIj);
    AppMethodBeat.o(304581);
  }
  
  public final void l(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304590);
    if (getRootView().getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "showSnapshotUIC, isVisible:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(304590);
      return;
    }
    glN();
    getRootView().setVisibility(0);
    View localView = getRootView();
    Object localObject = c.LHl;
    int i = c.glB();
    localObject = com.tencent.mm.plugin.multitask.f.a.LIu;
    int j = com.tencent.mm.plugin.multitask.f.a.glP();
    localObject = c.LHl;
    localView.setTranslationX(0.0F - (i + j + c.glF()));
    com.tencent.threadpool.h.ahAA.bo(new d..ExternalSyntheticLambda4(paramMultiTaskInfo, this));
    AppMethodBeat.o(304590);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(304501);
    s.u(paramConfiguration, "newConfig");
    AppMethodBeat.o(304501);
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304525);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(304525);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304530);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(304530);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(304495);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(304495);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(d paramd, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(304318);
      s.u(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == d.a(this.LIo))
      {
        ((ProgressBar)this.LIo.getRootView().findViewById(e.c.LDM)).setVisibility(0);
        AppMethodBeat.o(304318);
        return;
      }
      if (i == d.b(this.LIo))
      {
        this.LIo.glN();
        this.LIo.glO();
        paramMessage = com.tencent.mm.ui.component.k.aeZF;
        paramMessage = this.LIo.getRootView().getContext();
        s.s(paramMessage, "rootView.context");
        ((c)com.tencent.mm.ui.component.k.nq(paramMessage).q(c.class)).jr(true);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgS, "");
      }
      AppMethodBeat.o(304318);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskItemClick$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.multitask.c.c
  {
    c(Object paramObject, d paramd) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(304329);
      if ((this.LIp instanceof com.tencent.mm.plugin.multitask.c.c)) {
        com.tencent.mm.plugin.multitask.c.c.a.a((com.tencent.mm.plugin.multitask.c.c)this.LIp, paramBitmap, false, 6);
      }
      jdField_this.glN();
      jdField_this.getRootView().setTranslationX(0.0F);
      paramBitmap = com.tencent.mm.ui.component.k.aeZF;
      paramBitmap = jdField_this.getRootView().getContext();
      s.s(paramBitmap, "rootView.context");
      ((c)com.tencent.mm.ui.component.k.nq(paramBitmap).q(c.class)).jr(false);
      AppMethodBeat.o(304329);
    }
    
    public final void aco(int paramInt)
    {
      AppMethodBeat.i(304322);
      if ((this.LIp instanceof com.tencent.mm.plugin.multitask.c.c)) {
        ((com.tencent.mm.plugin.multitask.c.c)this.LIp).aco(0);
      }
      jdField_this.glN();
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = jdField_this.getRootView().getContext();
      s.s(localObject, "rootView.context");
      ((c)com.tencent.mm.ui.component.k.nq((Context)localObject).q(c.class)).jr(true);
      AppMethodBeat.o(304322);
    }
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(304336);
      jdField_this.glM();
      if ((this.LIp instanceof com.tencent.mm.plugin.multitask.c.c)) {
        com.tencent.mm.plugin.multitask.c.c.a.a((com.tencent.mm.plugin.multitask.c.c)this.LIp, paramBitmap);
      }
      AppMethodBeat.o(304336);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(d paramd, int paramInt1, MultiTaskInfo paramMultiTaskInfo, int paramInt2, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.d
 * JD-Core Version:    0.7.0.1
 */