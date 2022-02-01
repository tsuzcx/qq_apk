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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.g;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeViewHelper;", "", "()V", "TAG", "", "vibrator", "Landroid/os/Vibrator;", "animateScanCodeSuccessView", "", "successView", "Landroid/view/View;", "transX", "", "transY", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "getTopBitmap", "Landroid/graphics/Bitmap;", "bitmap", "viewWidth", "", "viewHeight", "handleCode", "context", "Landroid/content/Context;", "currentView", "codeResult", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "viewModel", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeViewModel;", "codeHandler", "Lcom/tencent/mm/ui/chatting/gallery/scan/IImageScanCodeHandler;", "needShowScanCodeSuccessView", "", "point", "Landroid/graphics/PointF;", "successViewSize", "vibrate", "app_release"})
public final class o
{
  public static final o KqZ;
  private static Vibrator nQa;
  
  static
  {
    AppMethodBeat.i(188360);
    KqZ = new o();
    AppMethodBeat.o(188360);
  }
  
  public static void a(Context paramContext, View paramView, final n paramn, k paramk, d paramd)
  {
    AppMethodBeat.i(188357);
    p.h(paramContext, "context");
    p.h(paramn, "codeResult");
    n.a locala;
    int i;
    int k;
    if ((paramn.KqU) && (paramn.KqT != null))
    {
      locala = paramn.KqT;
      if (locala == null) {
        p.gkB();
      }
      p.h(paramContext, "context");
      if (nQa == null)
      {
        localObject = paramContext.getSystemService("vibrator");
        if (localObject == null)
        {
          paramContext = new v("null cannot be cast to non-null type android.os.Vibrator");
          AppMethodBeat.o(188357);
          throw paramContext;
        }
        nQa = (Vibrator)localObject;
      }
      Object localObject = nQa;
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(10L);
      }
      i = aq.ay(paramContext, 2131166772);
      k = 0;
      if (!(paramView instanceof g)) {
        break label442;
      }
      k = ((g)paramView).getImageWidth();
    }
    label442:
    for (int j = ((g)paramView).getImageHeight();; j = 0)
    {
      if ((k > 0) && (j > 0))
      {
        if (paramView == null)
        {
          paramContext = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
          AppMethodBeat.o(188357);
          throw paramContext;
        }
        paramContext = ((g)paramView).a(locala.KqW, locala.KqX, locala.KqY);
        paramContext.x -= i / 2.0F;
        paramContext.y -= i / 2.0F;
        int m = paramView.getMeasuredWidth();
        int n = paramView.getMeasuredHeight();
        if (paramContext == null) {
          i = 0;
        }
        while (i != 0)
        {
          ae.i("MicroMsg.ScanCodeViewHelper", "alvinluo handleCode codePoint: %s, dstPoint: %s, imageWidth: %d, imageHeight: %d", new Object[] { locala.KqW, paramContext, Integer.valueOf(k), Integer.valueOf(j) });
          p.g(paramContext, "dstPoint");
          paramk.a(paramContext, (AnimatorListenerAdapter)new a(paramd, paramn));
          AppMethodBeat.o(188357);
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
        paramd.a(paramn);
        AppMethodBeat.o(188357);
        return;
        paramd.a(paramn);
      }
      AppMethodBeat.o(188357);
      return;
    }
  }
  
  public static final void a(View paramView, float paramFloat1, float paramFloat2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(188358);
    if (paramView == null)
    {
      AppMethodBeat.o(188358);
      return;
    }
    paramView.setVisibility(0);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    paramView.setAlpha(0.0F);
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    paramView.animate().setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)paramAnimatorListenerAdapter).setUpdateListener(null).setDuration(300L).alpha(1.0F).scaleX(1.0F).scaleY(1.0F).start();
    AppMethodBeat.o(188358);
  }
  
  public static final Bitmap i(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188359);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(188359);
      return null;
    }
    ae.v("MicroMsg.ScanCodeViewHelper", "getTopBitmap viewWidth: %d, viewHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    float f = 1.0F * paramInt1 / paramBitmap.getWidth();
    paramInt1 = Math.min((int)(paramInt2 / f), paramBitmap.getHeight());
    paramBitmap = h.b(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramInt1));
    AppMethodBeat.o(188359);
    return paramBitmap;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/chatting/gallery/scan/ScanCodeViewHelper$handleCode$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(d paramd, n paramn) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(188356);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.Kra;
      if (paramAnimator != null)
      {
        paramAnimator.a(paramn);
        AppMethodBeat.o(188356);
        return;
      }
      AppMethodBeat.o(188356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.o
 * JD-Core Version:    0.7.0.1
 */