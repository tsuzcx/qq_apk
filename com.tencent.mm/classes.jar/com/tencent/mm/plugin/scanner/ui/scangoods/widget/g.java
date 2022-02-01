package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.e;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "context", "Landroid/content/Context;", "dotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "alphaAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animationListener", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "animatorListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1;", "animatorSet", "Landroid/animation/AnimatorSet;", "centerCount", "", "getCenterCount", "()I", "setCenterCount", "(I)V", "centerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanPoint;", "Lkotlin/collections/ArrayList;", "getCenterList", "()Ljava/util/ArrayList;", "setCenterList", "(Ljava/util/ArrayList;)V", "duration", "", "isAnimating", "", "paint", "Landroid/graphics/Paint;", "radius", "", "sizeAnimator", "viewHeight", "getViewHeight", "setViewHeight", "viewWidth", "getViewWidth", "setViewWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onViewSizeChanged", "width", "height", "release", "setAnimationDots", "points", "", "pointCount", "([Lcom/tencent/mm/plugin/scanner/model/ScanPoint;I)V", "setDuration", "startAnimation", "listener", "stopAnimation", "updateViewSize", "forceUpdateDotsCenter", "Companion", "plugin-scan_release"})
public final class g
  implements c
{
  public static final g.c xhM;
  private long duration;
  private int fMt;
  private int fMu;
  private boolean isAnimating;
  private Paint paint;
  private float radius;
  private final ValueAnimator xhE;
  private final ValueAnimator xhF;
  private AnimatorSet xhG;
  private d xhH;
  private c.a xhI;
  private int xhJ;
  private ArrayList<ScanPoint> xhK;
  private final d xhL;
  
  static
  {
    AppMethodBeat.i(52274);
    xhM = new g.c((byte)0);
    AppMethodBeat.o(52274);
  }
  
  public g(Context paramContext, d paramd)
  {
    AppMethodBeat.i(52273);
    this.xhL = paramd;
    this.radius = paramContext.getResources().getDimension(2131166764);
    paramd = ValueAnimator.ofFloat(new float[] { 0.0F, this.radius });
    paramd.setInterpolator((TimeInterpolator)new LinearInterpolator());
    paramd.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
    this.xhE = paramd;
    paramd = ValueAnimator.ofFloat(new float[] { -1.0F, 1.0F });
    paramd.setInterpolator((TimeInterpolator)new LinearInterpolator());
    paramd.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this));
    this.xhF = paramd;
    paramd = new Paint();
    paramd.setColor(paramContext.getResources().getColor(2131099828));
    paramd.setStyle(Paint.Style.FILL);
    paramd.setAntiAlias(true);
    this.paint = paramd;
    this.xhH = new d(this);
    this.xhK = new ArrayList();
    this.duration = 700L;
    AppMethodBeat.o(52273);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(52270);
    k.h(parama, "listener");
    ac.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo startAnimation %d", new Object[] { Integer.valueOf(hashCode()) });
    this.xhI = parama;
    this.xhG = new AnimatorSet();
    parama = this.xhG;
    if (parama == null) {
      k.fOy();
    }
    parama.setDuration(this.duration);
    parama.removeAllListeners();
    parama.addListener((Animator.AnimatorListener)this.xhH);
    parama.playTogether(new Animator[] { (Animator)this.xhE, (Animator)this.xhF });
    parama.start();
    AppMethodBeat.o(52270);
  }
  
  public final void a(ScanPoint[] paramArrayOfScanPoint, int paramInt)
  {
    AppMethodBeat.i(52269);
    k.h(paramArrayOfScanPoint, "points");
    this.xhJ = paramInt;
    int i = this.xhJ;
    paramInt = 0;
    ScanPoint localScanPoint2;
    ScanPoint localScanPoint1;
    if (paramInt < i)
    {
      localScanPoint2 = (ScanPoint)e.f(paramArrayOfScanPoint, paramInt);
      localScanPoint1 = (ScanPoint)j.C((List)this.xhK, paramInt);
      if (localScanPoint1 != null) {
        break label152;
      }
      localScanPoint1 = new ScanPoint();
      this.xhK.add(localScanPoint1);
    }
    label140:
    label152:
    for (;;)
    {
      if (localScanPoint2 != null)
      {
        f = localScanPoint2.getXFactor();
        label93:
        localScanPoint1.setXFactor(f);
        if (localScanPoint2 == null) {
          break label140;
        }
      }
      for (float f = localScanPoint2.getYFactor();; f = 0.0F)
      {
        localScanPoint1.setYFactor(f);
        localScanPoint1.setX(0.0F);
        localScanPoint1.setY(0.0F);
        paramInt += 1;
        break;
        f = 0.0F;
        break label93;
      }
      AppMethodBeat.o(52269);
      return;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(52267);
    if (!this.isAnimating)
    {
      AppMethodBeat.o(52267);
      return;
    }
    int j = this.xhJ;
    int i = 0;
    while (i < j)
    {
      ScanPoint localScanPoint = (ScanPoint)j.C((List)this.xhK, i);
      if (localScanPoint == null)
      {
        AppMethodBeat.o(52267);
        return;
      }
      if (paramCanvas != null) {
        paramCanvas.drawCircle(localScanPoint.getX(), localScanPoint.getY(), this.radius, this.paint);
      }
      i += 1;
    }
    AppMethodBeat.o(52267);
  }
  
  public final boolean isAnimating()
  {
    return this.isAnimating;
  }
  
  public final void release()
  {
    AppMethodBeat.i(52272);
    this.xhJ = 0;
    this.xhK.clear();
    AppMethodBeat.o(52272);
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(52271);
    ac.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo stopAnimation");
    AnimatorSet localAnimatorSet = this.xhG;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.cancel();
      AppMethodBeat.o(52271);
      return;
    }
    AppMethodBeat.o(52271);
  }
  
  public final void v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(52268);
    ac.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo setViewSize width: %d, height: %d, forceUpdateDotsCenter: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if (((this.fMt != paramInt1) || (this.fMu != paramInt2) || (paramBoolean)) && (paramInt1 != 0) && (paramInt2 != 0)) {}
    for (int i = 1;; i = 0)
    {
      this.fMt = paramInt1;
      this.fMu = paramInt2;
      if (i == 0) {
        break;
      }
      paramInt2 = this.fMt;
      i = this.fMu;
      int j = this.xhJ;
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        ScanPoint localScanPoint2 = (ScanPoint)j.C((List)this.xhK, paramInt1);
        ScanPoint localScanPoint1 = localScanPoint2;
        if (localScanPoint2 == null)
        {
          localScanPoint1 = new ScanPoint();
          this.xhK.add(localScanPoint1);
        }
        localScanPoint1.setX(paramInt2 * localScanPoint1.getXFactor());
        localScanPoint1.setY(i * localScanPoint1.getYFactor());
        ac.d("MicroMsg.ScanAnimationDotsGroupView", "alvinluo onViewSizeChanged i: %d, %f, %f", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(localScanPoint1.getX()), Float.valueOf(localScanPoint1.getY()) });
        paramInt1 += 1;
      }
    }
    AppMethodBeat.o(52268);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$sizeAnimator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(g paramg) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52262);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52262);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      g.a(this.xhN, f);
      g.a(this.xhN).refreshView();
      AppMethodBeat.o(52262);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$alphaAnimator$1$1"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(g paramg) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52263);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52263);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      if (f <= 0.0F) {
        g.b(this.xhN).setAlpha((int)((f + 1.0F) * 255.0F));
      }
      for (;;)
      {
        g.a(this.xhN).refreshView();
        AppMethodBeat.o(52263);
        return;
        g.b(this.xhN).setAlpha((int)((1.0F - f) * 255.0F));
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(52265);
      g.a(this.xhN, false);
      AppMethodBeat.o(52265);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52264);
      g.a(this.xhN, false);
      paramAnimator = g.c(this.xhN);
      if (paramAnimator != null)
      {
        paramAnimator.a((c)this.xhN);
        AppMethodBeat.o(52264);
        return;
      }
      AppMethodBeat.o(52264);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52266);
      g.a(this.xhN, true);
      g.c(this.xhN);
      AppMethodBeat.o(52266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.g
 * JD-Core Version:    0.7.0.1
 */