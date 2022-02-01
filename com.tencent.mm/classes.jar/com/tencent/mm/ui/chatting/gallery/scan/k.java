package com.tencent.mm.ui.chatting.gallery.scan;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "alphaAnimators", "Ljava/util/HashMap;", "", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/HashMap;", "isRunningAnimation", "", "pendingAnimationType", "addAnimation", "", "view", "Landroid/view/View;", "show", "cancelAnimation", "doAlphaAnimation", "finishAnimation", "getViewIdName", "hideAnimation", "release", "releaseAllAnimators", "releaseViewAnimator", "runNextAnimation", "showAnimation", "Type", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k aeHm;
  private static HashMap<Integer, Integer> aeHn;
  private static HashMap<Integer, Boolean> aeHo;
  private static HashMap<Integer, ValueAnimator> aeHp;
  
  static
  {
    AppMethodBeat.i(254879);
    aeHm = new k();
    aeHn = new HashMap();
    aeHo = new HashMap();
    aeHp = new HashMap();
    AppMethodBeat.o(254879);
  }
  
  private static void L(View paramView, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(254833);
    Boolean localBoolean = (Boolean)aeHo.get(Integer.valueOf(paramView.hashCode()));
    Object localObject = localBoolean;
    if (localBoolean == null) {
      localObject = Boolean.FALSE;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo addAnimation view: %s, isRunning: %b, show: %b", new Object[] { paramView, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (!bool)
    {
      M(paramView, paramBoolean);
      AppMethodBeat.o(254833);
      return;
    }
    localObject = (Map)aeHn;
    int j = paramView.hashCode();
    if (paramBoolean) {}
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(254833);
      return;
      i = 0;
    }
  }
  
  private static void M(View paramView, final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(254842);
    ((Map)aeHo).put(Integer.valueOf(paramView.hashCode()), Boolean.TRUE);
    float f1;
    label39:
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label213;
      }
      localValueAnimator = (ValueAnimator)aeHp.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        break label218;
      }
      localValueAnimator = new ValueAnimator();
      ((Map)aeHp).put(Integer.valueOf(paramView.hashCode()), localValueAnimator);
    }
    label213:
    label218:
    for (;;)
    {
      Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), getViewIdName(paramView) });
      localValueAnimator.removeAllListeners();
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.setFloatValues(new float[] { f1, f2 });
      localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
      localValueAnimator.setDuration(150L);
      localValueAnimator.addUpdateListener(new k..ExternalSyntheticLambda0(paramView));
      localValueAnimator.addListener((Animator.AnimatorListener)new a(paramView, paramBoolean));
      localValueAnimator.start();
      AppMethodBeat.o(254842);
      return;
      f1 = 1.0F;
      break;
      f2 = 0.0F;
      break label39;
    }
  }
  
  private static final void f(View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(254861);
    s.u(paramView, "$view");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(254861);
      throw paramView;
    }
    paramView.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(254861);
  }
  
  private static String getViewIdName(View paramView)
  {
    AppMethodBeat.i(254855);
    paramView = paramView.getResources().getResourceEntryName(paramView.getId());
    if (paramView == null)
    {
      AppMethodBeat.o(254855);
      return "";
    }
    AppMethodBeat.o(254855);
    return paramView;
  }
  
  public static final void ll(View paramView)
  {
    AppMethodBeat.i(254816);
    s.u(paramView, "view");
    L(paramView, true);
    AppMethodBeat.o(254816);
  }
  
  public static final void lm(View paramView)
  {
    AppMethodBeat.i(254819);
    s.u(paramView, "view");
    L(paramView, false);
    AppMethodBeat.o(254819);
  }
  
  public static final void ln(View paramView)
  {
    AppMethodBeat.i(254829);
    Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo cancelAnimation view: %s", new Object[] { paramView });
    if (paramView != null)
    {
      aeHn.remove(Integer.valueOf(paramView.hashCode()));
      ValueAnimator localValueAnimator = (ValueAnimator)aeHp.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      lo(paramView);
    }
    AppMethodBeat.o(254829);
  }
  
  private static void lo(View paramView)
  {
    AppMethodBeat.i(254846);
    paramView = (ValueAnimator)aeHp.get(Integer.valueOf(paramView.hashCode()));
    if (paramView != null)
    {
      paramView.removeAllUpdateListeners();
      paramView.removeAllListeners();
    }
    AppMethodBeat.o(254846);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(254825);
    Iterator localIterator = ((Map)aeHp).entrySet().iterator();
    while (localIterator.hasNext())
    {
      ValueAnimator localValueAnimator = (ValueAnimator)((Map.Entry)localIterator.next()).getValue();
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.removeAllListeners();
    }
    aeHp.clear();
    aeHn.clear();
    aeHo.clear();
    AppMethodBeat.o(254825);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    private boolean isCancelled;
    
    a(View paramView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(254847);
      super.onAnimationCancel(paramAnimator);
      this.isCancelled = true;
      this.$view.setVisibility(8);
      this.$view.setAlpha(1.0F);
      Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation cancel, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), this.$view });
      paramAnimator = k.aeHm;
      k.lp(this.$view);
      AppMethodBeat.o(254847);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(254839);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.$view;
      if ((paramBoolean) && (!this.isCancelled)) {}
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        this.$view.setAlpha(1.0F);
        Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation end, show: %b, cancelled: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.isCancelled), this.$view });
        paramAnimator = k.aeHm;
        k.lp(this.$view);
        paramAnimator = k.aeHm;
        k.lq(this.$view);
        AppMethodBeat.o(254839);
        return;
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(254843);
      super.onAnimationStart(paramAnimator);
      Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation start, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), this.$view });
      AppMethodBeat.o(254843);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.scan.k
 * JD-Core Version:    0.7.0.1
 */