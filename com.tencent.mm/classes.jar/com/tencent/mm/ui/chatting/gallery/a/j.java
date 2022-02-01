package com.tencent.mm.ui.chatting.gallery.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeViewHelper;", "", "()V", "TAG", "", "vibrator", "Landroid/os/Vibrator;", "animateScanCodeSuccessView", "", "successView", "Landroid/view/View;", "transX", "", "transY", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "getTopBitmap", "Landroid/graphics/Bitmap;", "bitmap", "viewWidth", "", "viewHeight", "handleCode", "context", "Landroid/content/Context;", "currentView", "codeResult", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "viewModel", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeViewModel;", "codeHandler", "Lcom/tencent/mm/ui/chatting/gallery/scan/IImageScanCodeHandler;", "needShowScanCodeSuccessView", "", "point", "Landroid/graphics/PointF;", "successViewSize", "vibrate", "app_release"})
public final class j
{
  public static final j JUS;
  private static Vibrator nKv;
  
  static
  {
    AppMethodBeat.i(194914);
    JUS = new j();
    AppMethodBeat.o(194914);
  }
  
  public static void a(Context paramContext, View paramView, final i parami, h paramh, a parama)
  {
    AppMethodBeat.i(194911);
    p.h(paramContext, "context");
    p.h(parami, "codeResult");
    i.a locala;
    int i;
    int k;
    if ((parami.JUN) && (parami.JUM != null))
    {
      locala = parami.JUM;
      if (locala == null) {
        p.gfZ();
      }
      p.h(paramContext, "context");
      if (nKv == null)
      {
        localObject = paramContext.getSystemService("vibrator");
        if (localObject == null)
        {
          paramContext = new v("null cannot be cast to non-null type android.os.Vibrator");
          AppMethodBeat.o(194911);
          throw paramContext;
        }
        nKv = (Vibrator)localObject;
      }
      Object localObject = nKv;
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(10L);
      }
      i = aq.ay(paramContext, 2131166772);
      k = 0;
      if (!(paramView instanceof com.tencent.mm.ui.base.g)) {
        break label442;
      }
      k = ((com.tencent.mm.ui.base.g)paramView).getImageWidth();
    }
    label442:
    for (int j = ((com.tencent.mm.ui.base.g)paramView).getImageHeight();; j = 0)
    {
      if ((k > 0) && (j > 0))
      {
        if (paramView == null)
        {
          paramContext = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
          AppMethodBeat.o(194911);
          throw paramContext;
        }
        paramContext = ((com.tencent.mm.ui.base.g)paramView).a(locala.JUP, locala.JUQ, locala.JUR);
        paramContext.x -= i / 2.0F;
        paramContext.y -= i / 2.0F;
        int m = paramView.getMeasuredWidth();
        int n = paramView.getMeasuredHeight();
        if (paramContext == null) {
          i = 0;
        }
        while (i != 0)
        {
          ad.i("MicroMsg.ScanCodeViewHelper", "alvinluo handleCode codePoint: %s, dstPoint: %s, imageWidth: %d, imageHeight: %d", new Object[] { locala.JUP, paramContext, Integer.valueOf(k), Integer.valueOf(j) });
          p.g(paramContext, "dstPoint");
          paramh.a(paramContext, (AnimatorListenerAdapter)new a(parama, parami));
          AppMethodBeat.o(194911);
          return;
          if ((paramContext.x >= -i / 2.0F) && (paramContext.x <= m + i / 2.0F) && (paramContext.y >= -i / 2.0F))
          {
            float f1 = paramContext.y;
            float f2 = n;
            if (f1 <= i / 2.0F + f2) {}
          }
          else
          {
            i = 0;
            continue;
          }
          i = 1;
        }
        parama.a(parami);
        AppMethodBeat.o(194911);
        return;
        parama.a(parami);
      }
      AppMethodBeat.o(194911);
      return;
    }
  }
  
  public static final void a(View paramView, float paramFloat1, float paramFloat2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(194912);
    if (paramView == null)
    {
      AppMethodBeat.o(194912);
      return;
    }
    paramView.setVisibility(0);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    paramView.setAlpha(0.0F);
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    paramView.animate().setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)paramAnimatorListenerAdapter).setUpdateListener(null).setDuration(300L).alpha(1.0F).scaleX(1.0F).scaleY(1.0F).start();
    AppMethodBeat.o(194912);
  }
  
  public static final Bitmap i(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194913);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(194913);
      return null;
    }
    ad.v("MicroMsg.ScanCodeViewHelper", "getTopBitmap viewWidth: %d, viewHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    float f = 1.0F * paramInt1 / paramBitmap.getWidth();
    paramInt1 = Math.min((int)(paramInt2 / f), paramBitmap.getHeight());
    paramBitmap = com.tencent.mm.sdk.platformtools.g.b(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramInt1));
    AppMethodBeat.o(194913);
    return paramBitmap;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/chatting/gallery/scan/ScanCodeViewHelper$handleCode$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(a parama, i parami) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(194910);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.JUT;
      if (paramAnimator != null)
      {
        paramAnimator.a(parami);
        AppMethodBeat.o(194910);
        return;
      }
      AppMethodBeat.o(194910);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.j
 * JD-Core Version:    0.7.0.1
 */