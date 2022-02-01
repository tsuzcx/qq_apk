package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.c.c.a;
import com.tencent.mm.plugin.multitask.j.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper;", "", "()V", "TAG", "", "doMaskAnimation", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "ballPos", "Landroid/graphics/Point;", "snapBlt", "Landroid/graphics/Bitmap;", "isManual", "", "lastSwipePosX", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "doTransform", "startTransform", "plugin-multitask_release"})
public final class a
{
  public static final a FFL;
  
  static
  {
    AppMethodBeat.i(249157);
    FFL = new a();
    AppMethodBeat.o(249157);
  }
  
  public static void a(final com.tencent.mm.plugin.multitask.a.a parama, final Point paramPoint, final Bitmap paramBitmap, final boolean paramBoolean, final float paramFloat, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(249155);
    PlaySound.play(MMApplicationContext.getContext(), j.h.webview_minimize_sound_path);
    if (parama.bOd())
    {
      parama.a((com.tencent.mm.plugin.multitask.a.a.b)new b(paramc, paramPoint, parama, paramBitmap, paramBoolean, paramFloat));
      AppMethodBeat.o(249155);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new c(paramc));
    AppMethodBeat.o(249155);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doMaskAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(c paramc, com.tencent.mm.plugin.multitask.c.c paramc1, Bitmap paramBitmap) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247838);
      p.k(paramAnimator, "animation");
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      paramAnimator = this.FFN;
      if (paramAnimator != null)
      {
        c.a.a(paramAnimator, this.FFO);
        AppMethodBeat.o(247838);
        return;
      }
      AppMethodBeat.o(247838);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(247839);
      p.k(paramAnimator, "animation");
      paramAnimator = this.FFN;
      if (paramAnimator != null)
      {
        c.a.a(paramAnimator, this.FFO, false, 6);
        AppMethodBeat.o(247839);
        return;
      }
      AppMethodBeat.o(247839);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(247595);
        if (this.FFP.FFM.getParent() != null)
        {
          Object localObject = this.FFP.FFM.getParent();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(247595);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView((View)this.FFP.FFM);
        }
        AppMethodBeat.o(247595);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"})
  public static final class b
    implements com.tencent.mm.plugin.multitask.a.a.b
  {
    b(com.tencent.mm.plugin.multitask.c.c paramc, Point paramPoint, com.tencent.mm.plugin.multitask.a.a parama, Bitmap paramBitmap, boolean paramBoolean, float paramFloat) {}
    
    public final void eG(boolean paramBoolean)
    {
      AppMethodBeat.i(249087);
      if (!paramBoolean)
      {
        Log.i("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doTransform, convertToTranslucent not complete");
        MMHandlerThread.postToMainThread((Runnable)new a(this));
        AppMethodBeat.o(249087);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new b(this));
      AppMethodBeat.o(249087);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(247770);
        com.tencent.mm.plugin.multitask.c.c localc = this.FFU.FFN;
        if (localc != null)
        {
          localc.Yb(0);
          AppMethodBeat.o(247770);
          return;
        }
        AppMethodBeat.o(247770);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(247670);
        if (this.FFU.FFQ != null)
        {
          localObject = a.FFL;
          a.b(this.FFU.FFR, this.FFU.FFQ, this.FFU.FFS, this.FFU.zSF, this.FFU.FFT, this.FFU.FFN);
          AppMethodBeat.o(247670);
          return;
        }
        Object localObject = this.FFU.FFN;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(0);
          AppMethodBeat.o(247670);
          return;
        }
        AppMethodBeat.o(247670);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(com.tencent.mm.plugin.multitask.c.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(249169);
      com.tencent.mm.plugin.multitask.c.c localc = this.FFN;
      if (localc != null)
      {
        localc.Yb(0);
        AppMethodBeat.o(249169);
        return;
      }
      AppMethodBeat.o(249169);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.a
 * JD-Core Version:    0.7.0.1
 */