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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "alphaAnimators", "Ljava/util/HashMap;", "", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/HashMap;", "isRunningAnimation", "", "pendingAnimationType", "addAnimation", "", "view", "Landroid/view/View;", "show", "cancelAnimation", "doAlphaAnimation", "finishAnimation", "getViewIdName", "hideAnimation", "release", "releaseAllAnimators", "releaseViewAnimator", "runNextAnimation", "showAnimation", "Type", "app_release"})
public final class m
{
  private static HashMap<Integer, Integer> KqM;
  private static HashMap<Integer, Boolean> KqN;
  private static HashMap<Integer, ValueAnimator> KqO;
  public static final m KqP;
  
  static
  {
    AppMethodBeat.i(188351);
    KqP = new m();
    KqM = new HashMap();
    KqN = new HashMap();
    KqO = new HashMap();
    AppMethodBeat.o(188351);
  }
  
  private static void B(View paramView, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(188347);
    Boolean localBoolean = (Boolean)KqN.get(Integer.valueOf(paramView.hashCode()));
    Object localObject = localBoolean;
    if (localBoolean == null) {
      localObject = Boolean.FALSE;
    }
    p.g(localObject, "isRunningAnimation[view.hashCode()] ?: false");
    boolean bool = ((Boolean)localObject).booleanValue();
    ae.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo addAnimation view: %s, isRunning: %b, show: %b", new Object[] { paramView, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (!bool)
    {
      C(paramView, paramBoolean);
      AppMethodBeat.o(188347);
      return;
    }
    localObject = (Map)KqM;
    int j = paramView.hashCode();
    if (paramBoolean) {}
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(188347);
      return;
      i = 0;
    }
  }
  
  private static void C(final View paramView, final boolean paramBoolean)
  {
    final float f2 = 1.0F;
    AppMethodBeat.i(188348);
    ((Map)KqN).put(Integer.valueOf(paramView.hashCode()), Boolean.TRUE);
    float f1;
    label39:
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label221;
      }
      localValueAnimator = (ValueAnimator)KqO.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        break label226;
      }
      localValueAnimator = new ValueAnimator();
      ((Map)KqO).put(Integer.valueOf(paramView.hashCode()), localValueAnimator);
    }
    label221:
    label226:
    for (;;)
    {
      ae.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), getViewIdName(paramView) });
      localValueAnimator.removeAllListeners();
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.setFloatValues(new float[] { f1, f2 });
      localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
      localValueAnimator.setDuration(150L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new m.a(f1, f2, paramView, paramBoolean));
      localValueAnimator.addListener((Animator.AnimatorListener)new b(f1, f2, paramView, paramBoolean));
      localValueAnimator.start();
      AppMethodBeat.o(188348);
      return;
      f1 = 1.0F;
      break;
      f2 = 0.0F;
      break label39;
    }
  }
  
  private static String getViewIdName(View paramView)
  {
    AppMethodBeat.i(188350);
    String str = paramView.getResources().getResourceEntryName(paramView.getId());
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    AppMethodBeat.o(188350);
    return paramView;
  }
  
  public static final void gm(View paramView)
  {
    AppMethodBeat.i(188343);
    p.h(paramView, "view");
    B(paramView, true);
    AppMethodBeat.o(188343);
  }
  
  public static final void gn(View paramView)
  {
    AppMethodBeat.i(188344);
    p.h(paramView, "view");
    B(paramView, false);
    AppMethodBeat.o(188344);
  }
  
  public static final void go(View paramView)
  {
    AppMethodBeat.i(188346);
    ae.d("MicroMsg.QuickButtonAnimationHelper", "alvinluo cancelAnimation view: %s", new Object[] { paramView });
    if (paramView != null)
    {
      KqM.remove(Integer.valueOf(paramView.hashCode()));
      ValueAnimator localValueAnimator = (ValueAnimator)KqO.get(Integer.valueOf(paramView.hashCode()));
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      gp(paramView);
      AppMethodBeat.o(188346);
      return;
    }
    AppMethodBeat.o(188346);
  }
  
  private static void gp(View paramView)
  {
    AppMethodBeat.i(188349);
    paramView = (ValueAnimator)KqO.get(Integer.valueOf(paramView.hashCode()));
    if (paramView != null)
    {
      paramView.removeAllUpdateListeners();
      paramView.removeAllListeners();
      AppMethodBeat.o(188349);
      return;
    }
    AppMethodBeat.o(188349);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(188345);
    Iterator localIterator = ((Map)KqO).entrySet().iterator();
    while (localIterator.hasNext())
    {
      ValueAnimator localValueAnimator = (ValueAnimator)((Map.Entry)localIterator.next()).getValue();
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.removeAllListeners();
    }
    KqO.clear();
    KqM.clear();
    KqN.clear();
    AppMethodBeat.o(188345);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/chatting/gallery/scan/QuickButtonAnimationHelper$doAlphaAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "isCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "app_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    private boolean isCancelled;
    
    b(float paramFloat1, float paramFloat2, View paramView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(188342);
      super.onAnimationCancel(paramAnimator);
      this.isCancelled = true;
      paramView.setVisibility(8);
      paramView.setAlpha(1.0F);
      ae.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation cancel, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
      paramAnimator = m.KqP;
      m.gq(paramView);
      AppMethodBeat.o(188342);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(188340);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = paramView;
      if ((paramBoolean) && (!this.isCancelled)) {}
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        paramView.setAlpha(1.0F);
        ae.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation end, show: %b, cancelled: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.isCancelled), paramView });
        paramAnimator = m.KqP;
        m.gq(paramView);
        paramAnimator = m.KqP;
        m.gr(paramView);
        AppMethodBeat.o(188340);
        return;
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(188341);
      super.onAnimationStart(paramAnimator);
      ae.v("MicroMsg.QuickButtonAnimationHelper", "alvinluo doAlphaAnimation start, show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
      AppMethodBeat.o(188341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.m
 * JD-Core Version:    0.7.0.1
 */