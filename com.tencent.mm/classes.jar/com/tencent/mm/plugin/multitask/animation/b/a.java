package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.c.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper;", "", "()V", "TAG", "", "doMaskAnimation", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "ballPos", "Landroid/graphics/Point;", "snapBlt", "Landroid/graphics/Bitmap;", "isManual", "", "lastSwipePosX", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "doTransform", "startTransform", "plugin-multitask_release"})
public final class a
{
  public static final a zZV;
  
  static
  {
    AppMethodBeat.i(200399);
    zZV = new a();
    AppMethodBeat.o(200399);
  }
  
  public static void a(final com.tencent.mm.plugin.multitask.a.a parama, final Point paramPoint, final Bitmap paramBitmap, final boolean paramBoolean, final float paramFloat, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(200398);
    PlaySound.play(MMApplicationContext.getContext(), 2131768604);
    if (parama.bCI())
    {
      parama.a((com.tencent.mm.plugin.multitask.a.a.b)new b(paramc, paramPoint, parama, paramBitmap, paramBoolean, paramFloat));
      AppMethodBeat.o(200398);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new c(paramc));
    AppMethodBeat.o(200398);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doMaskAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(c paramc, com.tencent.mm.plugin.multitask.c.c paramc1, Bitmap paramBitmap) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200392);
      p.h(paramAnimator, "animation");
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      paramAnimator = this.zZX;
      if (paramAnimator != null)
      {
        c.a.a(paramAnimator, this.zZY);
        AppMethodBeat.o(200392);
        return;
      }
      AppMethodBeat.o(200392);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(200393);
      p.h(paramAnimator, "animation");
      paramAnimator = this.zZX;
      if (paramAnimator != null)
      {
        c.a.a(paramAnimator, this.zZY, false, 6);
        AppMethodBeat.o(200393);
        return;
      }
      AppMethodBeat.o(200393);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(200391);
        if (this.zZZ.zZW.getParent() != null)
        {
          Object localObject = this.zZZ.zZW.getParent();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(200391);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView((View)this.zZZ.zZW);
        }
        AppMethodBeat.o(200391);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBSwipeTransformationHelper$doTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"})
  public static final class b
    implements com.tencent.mm.plugin.multitask.a.a.b
  {
    b(com.tencent.mm.plugin.multitask.c.c paramc, Point paramPoint, com.tencent.mm.plugin.multitask.a.a parama, Bitmap paramBitmap, boolean paramBoolean, float paramFloat) {}
    
    public final void ei(boolean paramBoolean)
    {
      AppMethodBeat.i(200396);
      if (!paramBoolean)
      {
        Log.i("MicroMsg.MultiTaskFBSwipeTransformationHelper", "doTransform, convertToTranslucent not complete");
        MMHandlerThread.postToMainThread((Runnable)new a(this));
        AppMethodBeat.o(200396);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new b(this));
      AppMethodBeat.o(200396);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(200394);
        com.tencent.mm.plugin.multitask.c.c localc = this.Aae.zZX;
        if (localc != null)
        {
          localc.RL(0);
          AppMethodBeat.o(200394);
          return;
        }
        AppMethodBeat.o(200394);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(200395);
        if (this.Aae.Aaa != null)
        {
          localObject = a.zZV;
          a.b(this.Aae.Aab, this.Aae.Aaa, this.Aae.Aac, this.Aae.vcf, this.Aae.Aad, this.Aae.zZX);
          AppMethodBeat.o(200395);
          return;
        }
        Object localObject = this.Aae.zZX;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(0);
          AppMethodBeat.o(200395);
          return;
        }
        AppMethodBeat.o(200395);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(com.tencent.mm.plugin.multitask.c.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(200397);
      com.tencent.mm.plugin.multitask.c.c localc = this.zZX;
      if (localc != null)
      {
        localc.RL(0);
        AppMethodBeat.o(200397);
        return;
      }
      AppMethodBeat.o(200397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.b.a
 * JD-Core Version:    0.7.0.1
 */