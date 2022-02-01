package com.tencent.mm.ui.chatting.gallery.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "alphaAnimators", "Ljava/util/HashMap;", "", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/HashMap;", "isRunningAnimation", "", "pendingAnimationType", "addAnimation", "", "view", "Landroid/view/View;", "show", "cancelAnimation", "doAlphaAnimation", "finishAnimation", "getViewIdName", "hideAnimation", "release", "releaseAllAnimators", "releaseViewAnimator", "runNextAnimation", "showAnimation", "Type", "app_release"})
public final class k
{
  private static HashMap<Integer, Integer> WXM;
  private static HashMap<Integer, Boolean> WXN;
  private static HashMap<Integer, ValueAnimator> WXO;
  public static final k WXP;
  
  static
  {
    AppMethodBeat.i(284669);
    WXP = new k();
    WXM = new HashMap();
    WXN = new HashMap();
    WXO = new HashMap();
    AppMethodBeat.o(284669);
  }
  
  private static void F(View paramView, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(284664);
    Boolean localBoolean = (Boolean)WXN.get(Integer.valueOf(paramView.hashCode()));
    Object localObject = localBoolean;
    if (localBoolean == null) {
      localObject = Boolean.FALSE;
    }
    p.j(localObject, "isRunningAnimation[view.hashCode()] ?: false");
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo addAnimation view: %s, isRunning: %b, show: %b", new Object[] { paramView, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (!bool)
    {
      G(paramView, paramBoolean);
      AppMethodBeat.o(284664);
      return;
    }
    localObject = (Map)WXM;
    int j = paramView.hashCode();
    if (paramBoolean) {}
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(284664);
      return;
      i = 0;
    }
  }
  
  private static void G(final View paramView, final boolean paramBoolean)
  {
    final float f2 = 1.0F;
    AppMethodBeat.i(284665);
    ((Map)WXN).put(Integer.valueOf(paramView.hashCode()), Boolean.TRUE);
    float f1;
    label39:
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label221;
      }
      localValueAnimator = (ValueAnimator)WXO.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        break label226;
      }
      localValueAnimator = new ValueAnimator();
      ((Map)WXO).put(Integer.valueOf(paramView.hashCode()), localValueAnimator);
    }
    label221:
    label226:
    for (;;)
    {
      Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), getViewIdName(paramView) });
      localValueAnimator.removeAllListeners();
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.setFloatValues(new float[] { f1, f2 });
      localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
      localValueAnimator.setDuration(150L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(f1, f2, paramView, paramBoolean));
      localValueAnimator.addListener((Animator.AnimatorListener)new b(f1, f2, paramView, paramBoolean));
      localValueAnimator.start();
      AppMethodBeat.o(284665);
      return;
      f1 = 1.0F;
      break;
      f2 = 0.0F;
      break label39;
    }
  }
  
  private static String getViewIdName(View paramView)
  {
    AppMethodBeat.i(284667);
    String str = paramView.getResources().getResourceEntryName(paramView.getId());
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    AppMethodBeat.o(284667);
    return paramView;
  }
  
  public static final void hP(View paramView)
  {
    AppMethodBeat.i(284657);
    p.k(paramView, "view");
    F(paramView, true);
    AppMethodBeat.o(284657);
  }
  
  public static final void hQ(View paramView)
  {
    AppMethodBeat.i(284658);
    p.k(paramView, "view");
    F(paramView, false);
    AppMethodBeat.o(284658);
  }
  
  public static final void hR(View paramView)
  {
    AppMethodBeat.i(284663);
    Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo cancelAnimation view: %s", new Object[] { paramView });
    if (paramView != null)
    {
      WXM.remove(Integer.valueOf(paramView.hashCode()));
      ValueAnimator localValueAnimator = (ValueAnimator)WXO.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      hS(paramView);
      AppMethodBeat.o(284663);
      return;
    }
    AppMethodBeat.o(284663);
  }
  
  private static void hS(View paramView)
  {
    AppMethodBeat.i(284666);
    paramView = (ValueAnimator)WXO.get(Integer.valueOf(paramView.hashCode()));
    if (paramView != null)
    {
      paramView.removeAllUpdateListeners();
      paramView.removeAllListeners();
      AppMethodBeat.o(284666);
      return;
    }
    AppMethodBeat.o(284666);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(284661);
    Iterator localIterator = ((Map)WXO).entrySet().iterator();
    while (localIterator.hasNext())
    {
      ValueAnimator localValueAnimator = (ValueAnimator)((Map.Entry)localIterator.next()).getValue();
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.removeAllListeners();
    }
    WXO.clear();
    WXM.clear();
    WXN.clear();
    AppMethodBeat.o(284661);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "listener", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(287817);
      View localView = paramView;
      p.j(paramValueAnimator, "listener");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(287817);
        throw paramValueAnimator;
      }
      localView.setAlpha(((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(287817);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "app_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    private boolean isCancelled;
    
    b(float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(276570);
      super.onAnimationCancel(paramAnimator);
      this.isCancelled = true;
      paramView.setVisibility(8);
      paramView.setAlpha(1.0F);
      Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation cancel, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
      paramAnimator = k.WXP;
      k.hT(paramView);
      AppMethodBeat.o(276570);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(276568);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = paramView;
      if ((paramBoolean) && (!this.isCancelled)) {}
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        paramView.setAlpha(1.0F);
        Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation end, show: %b, cancelled: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.isCancelled), paramView });
        paramAnimator = k.WXP;
        k.hT(paramView);
        paramAnimator = k.WXP;
        k.hU(paramView);
        AppMethodBeat.o(276568);
        return;
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(276569);
      super.onAnimationStart(paramAnimator);
      Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation start, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
      AppMethodBeat.o(276569);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.k
 * JD-Core Version:    0.7.0.1
 */