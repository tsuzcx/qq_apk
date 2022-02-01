package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.multitask.c.c.a;
import com.tencent.mm.plugin.multitask.j.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper;", "", "()V", "TAG", "", "doMaskAnimation", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "ballPos", "Landroid/graphics/Point;", "snapBlt", "Landroid/graphics/Bitmap;", "isManual", "", "lastSwipePosX", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "doTransform", "startTransform", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LBH;
  
  static
  {
    AppMethodBeat.i(303966);
    LBH = new a();
    AppMethodBeat.o(303966);
  }
  
  public static void a(com.tencent.mm.plugin.multitask.a.a parama, Point paramPoint, Bitmap paramBitmap, float paramFloat, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(303928);
    s.u(parama, "pageAdapter");
    a(parama, paramPoint, paramBitmap, false, paramFloat, paramc);
    AppMethodBeat.o(303928);
  }
  
  private static void a(final com.tencent.mm.plugin.multitask.a.a parama, final Point paramPoint, final Bitmap paramBitmap, final boolean paramBoolean, final float paramFloat, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(303936);
    PlaySound.play(MMApplicationContext.getContext(), j.h.webview_minimize_sound_path);
    if (parama.cor())
    {
      parama.a((com.tencent.mm.plugin.multitask.a.a.b)new b(paramc, paramPoint, parama, paramBitmap, paramBoolean, paramFloat));
      AppMethodBeat.o(303936);
      return;
    }
    MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda0(paramc));
    AppMethodBeat.o(303936);
  }
  
  public static void a(com.tencent.mm.plugin.multitask.a.a parama, Point paramPoint, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(303918);
    s.u(parama, "pageAdapter");
    a(parama, paramPoint, null, true, -1.0F, paramc);
    AppMethodBeat.o(303918);
  }
  
  private static final void a(com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(303945);
    if (paramc != null) {
      paramc.aco(0);
    }
    AppMethodBeat.o(303945);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doMaskAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, c paramc1) {}
    
    private static final void a(c paramc)
    {
      AppMethodBeat.i(303983);
      s.u(paramc, "$maskView");
      if (paramc.getParent() != null)
      {
        ViewParent localViewParent = paramc.getParent();
        if (localViewParent == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(303983);
          throw paramc;
        }
        ((ViewGroup)localViewParent).removeView((View)paramc);
      }
      AppMethodBeat.o(303983);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(303995);
      s.u(paramAnimator, "animation");
      MMHandlerThread.postToMainThread(new a.a..ExternalSyntheticLambda0(this.LBK));
      paramAnimator = this.LBI;
      if (paramAnimator != null) {
        c.a.a(paramAnimator, this.LBJ);
      }
      AppMethodBeat.o(303995);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(304004);
      s.u(paramAnimator, "animation");
      paramAnimator = this.LBI;
      if (paramAnimator != null) {
        c.a.a(paramAnimator, this.LBJ, false, 6);
      }
      AppMethodBeat.o(304004);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.multitask.a.a.b
  {
    b(com.tencent.mm.plugin.multitask.c.c paramc, Point paramPoint, com.tencent.mm.plugin.multitask.a.a parama, Bitmap paramBitmap, boolean paramBoolean, float paramFloat) {}
    
    private static final void b(com.tencent.mm.plugin.multitask.c.c paramc)
    {
      AppMethodBeat.i(303998);
      if (paramc != null) {
        paramc.aco(0);
      }
      AppMethodBeat.o(303998);
    }
    
    public final void onComplete(boolean paramBoolean)
    {
      AppMethodBeat.i(304019);
      if (!paramBoolean)
      {
        Log.i("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doTransform, convertToTranslucent not complete");
        MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda0(this.LBI));
        AppMethodBeat.o(304019);
        return;
      }
      d.uiThread((kotlin.g.a.a)new a(paramPoint, parama, paramBitmap, paramBoolean, paramFloat, this.LBI));
      AppMethodBeat.o(304019);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(Point paramPoint, com.tencent.mm.plugin.multitask.a.a parama, Bitmap paramBitmap, boolean paramBoolean, float paramFloat, com.tencent.mm.plugin.multitask.c.c paramc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.a
 * JD-Core Version:    0.7.0.1
 */