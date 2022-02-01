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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "alphaAnimators", "Ljava/util/HashMap;", "", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/HashMap;", "isRunningAnimation", "", "pendingAnimationType", "addAnimation", "", "view", "Landroid/view/View;", "show", "cancelAnimation", "doAlphaAnimation", "finishAnimation", "getViewIdName", "hideAnimation", "release", "releaseAllAnimators", "releaseViewAnimator", "runNextAnimation", "showAnimation", "Type", "app_release"})
public final class m
{
  private static HashMap<Integer, Integer> PCV;
  private static HashMap<Integer, Boolean> PCW;
  private static HashMap<Integer, ValueAnimator> PCX;
  public static final m PCY;
  
  static
  {
    AppMethodBeat.i(231304);
    PCY = new m();
    PCV = new HashMap();
    PCW = new HashMap();
    PCX = new HashMap();
    AppMethodBeat.o(231304);
  }
  
  private static void D(View paramView, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(231300);
    Boolean localBoolean = (Boolean)PCW.get(Integer.valueOf(paramView.hashCode()));
    Object localObject = localBoolean;
    if (localBoolean == null) {
      localObject = Boolean.FALSE;
    }
    p.g(localObject, "isRunningAnimation[view.hashCode()] ?: false");
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo addAnimation view: %s, isRunning: %b, show: %b", new Object[] { paramView, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (!bool)
    {
      E(paramView, paramBoolean);
      AppMethodBeat.o(231300);
      return;
    }
    localObject = (Map)PCV;
    int j = paramView.hashCode();
    if (paramBoolean) {}
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(231300);
      return;
      i = 0;
    }
  }
  
  private static void E(final View paramView, final boolean paramBoolean)
  {
    final float f2 = 1.0F;
    AppMethodBeat.i(231301);
    ((Map)PCW).put(Integer.valueOf(paramView.hashCode()), Boolean.TRUE);
    float f1;
    label39:
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label221;
      }
      localValueAnimator = (ValueAnimator)PCX.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        break label226;
      }
      localValueAnimator = new ValueAnimator();
      ((Map)PCX).put(Integer.valueOf(paramView.hashCode()), localValueAnimator);
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
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new m.a(f1, f2, paramView, paramBoolean));
      localValueAnimator.addListener((Animator.AnimatorListener)new b(f1, f2, paramView, paramBoolean));
      localValueAnimator.start();
      AppMethodBeat.o(231301);
      return;
      f1 = 1.0F;
      break;
      f2 = 0.0F;
      break label39;
    }
  }
  
  public static final void gE(View paramView)
  {
    AppMethodBeat.i(231296);
    p.h(paramView, "view");
    D(paramView, true);
    AppMethodBeat.o(231296);
  }
  
  public static final void gF(View paramView)
  {
    AppMethodBeat.i(231297);
    p.h(paramView, "view");
    D(paramView, false);
    AppMethodBeat.o(231297);
  }
  
  public static final void gG(View paramView)
  {
    AppMethodBeat.i(231299);
    Log.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo cancelAnimation view: %s", new Object[] { paramView });
    if (paramView != null)
    {
      PCV.remove(Integer.valueOf(paramView.hashCode()));
      ValueAnimator localValueAnimator = (ValueAnimator)PCX.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      gH(paramView);
      AppMethodBeat.o(231299);
      return;
    }
    AppMethodBeat.o(231299);
  }
  
  private static void gH(View paramView)
  {
    AppMethodBeat.i(231302);
    paramView = (ValueAnimator)PCX.get(Integer.valueOf(paramView.hashCode()));
    if (paramView != null)
    {
      paramView.removeAllUpdateListeners();
      paramView.removeAllListeners();
      AppMethodBeat.o(231302);
      return;
    }
    AppMethodBeat.o(231302);
  }
  
  private static String getViewIdName(View paramView)
  {
    AppMethodBeat.i(231303);
    String str = paramView.getResources().getResourceEntryName(paramView.getId());
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    AppMethodBeat.o(231303);
    return paramView;
  }
  
  public static final void release()
  {
    AppMethodBeat.i(231298);
    Iterator localIterator = ((Map)PCX).entrySet().iterator();
    while (localIterator.hasNext())
    {
      ValueAnimator localValueAnimator = (ValueAnimator)((Map.Entry)localIterator.next()).getValue();
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.removeAllListeners();
    }
    PCX.clear();
    PCV.clear();
    PCW.clear();
    AppMethodBeat.o(231298);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "app_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    private boolean isCancelled;
    
    b(float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(231295);
      super.onAnimationCancel(paramAnimator);
      this.isCancelled = true;
      paramView.setVisibility(8);
      paramView.setAlpha(1.0F);
      Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation cancel, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
      paramAnimator = m.PCY;
      m.gI(paramView);
      AppMethodBeat.o(231295);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(231293);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = paramView;
      if ((paramBoolean) && (!this.isCancelled)) {}
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        paramView.setAlpha(1.0F);
        Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation end, show: %b, cancelled: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.isCancelled), paramView });
        paramAnimator = m.PCY;
        m.gI(paramView);
        paramAnimator = m.PCY;
        m.gJ(paramView);
        AppMethodBeat.o(231293);
        return;
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(231294);
      super.onAnimationStart(paramAnimator);
      Log.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation start, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
      AppMethodBeat.o(231294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.m
 * JD-Core Version:    0.7.0.1
 */