package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "context", "Landroid/content/Context;", "dotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "alphaAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animationListener", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "animatorListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1;", "animatorSet", "Landroid/animation/AnimatorSet;", "centerCount", "", "getCenterCount", "()I", "setCenterCount", "(I)V", "centerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanPoint;", "Lkotlin/collections/ArrayList;", "getCenterList", "()Ljava/util/ArrayList;", "setCenterList", "(Ljava/util/ArrayList;)V", "duration", "", "isAnimating", "", "paint", "Landroid/graphics/Paint;", "radius", "", "sizeAnimator", "viewHeight", "getViewHeight", "setViewHeight", "viewWidth", "getViewWidth", "setViewWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onViewSizeChanged", "width", "height", "release", "setAnimationDots", "points", "", "pointCount", "([Lcom/tencent/mm/plugin/scanner/model/ScanPoint;I)V", "setDuration", "startAnimation", "listener", "stopAnimation", "updateViewSize", "forceUpdateDotsCenter", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements c
{
  public static final g.a PdQ;
  private AnimatorSet Div;
  private final d PdR;
  private final ValueAnimator PdS;
  private final ValueAnimator PdT;
  private b PdU;
  private c.a PdV;
  private int PdW;
  private ArrayList<ScanPoint> PdX;
  private long duration;
  private boolean isAnimating;
  private int mbM;
  private int mbN;
  private Paint paint;
  private float radius;
  
  static
  {
    AppMethodBeat.i(52274);
    PdQ = new g.a((byte)0);
    AppMethodBeat.o(52274);
  }
  
  public g(Context paramContext, d paramd)
  {
    AppMethodBeat.i(52273);
    this.PdR = paramd;
    this.radius = paramContext.getResources().getDimension(l.d.OIg);
    paramd = ValueAnimator.ofFloat(new float[] { 0.0F, this.radius });
    paramd.setInterpolator((TimeInterpolator)new LinearInterpolator());
    paramd.addUpdateListener(new g..ExternalSyntheticLambda0(this));
    ah localah = ah.aiuX;
    this.PdS = paramd;
    paramd = ValueAnimator.ofFloat(new float[] { -1.0F, 1.0F });
    paramd.setInterpolator((TimeInterpolator)new LinearInterpolator());
    paramd.addUpdateListener(new g..ExternalSyntheticLambda1(this));
    localah = ah.aiuX;
    this.PdT = paramd;
    paramd = new Paint();
    paramd.setColor(paramContext.getResources().getColor(l.c.White));
    paramd.setStyle(Paint.Style.FILL);
    paramd.setAntiAlias(true);
    paramContext = ah.aiuX;
    this.paint = paramd;
    this.PdU = new b(this);
    this.PdX = new ArrayList();
    this.duration = 700L;
    AppMethodBeat.o(52273);
  }
  
  private static final void a(g paramg, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314635);
    s.u(paramg, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314635);
      throw paramg;
    }
    paramg.radius = ((Float)paramValueAnimator).floatValue();
    paramg.PdR.refreshView();
    AppMethodBeat.o(314635);
  }
  
  private static final void b(g paramg, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314641);
    s.u(paramg, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314641);
      throw paramg;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    if (f <= 0.0F) {
      paramg.paint.setAlpha((int)((f + 1.0F) * 255.0F));
    }
    for (;;)
    {
      paramg.PdR.refreshView();
      AppMethodBeat.o(314641);
      return;
      paramg.paint.setAlpha((int)((1.0F - f) * 255.0F));
    }
  }
  
  public final void L(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(52268);
    Log.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo setViewSize width: %d, height: %d, forceUpdateDotsCenter: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    int i;
    int j;
    int k;
    if (((this.mbM != paramInt1) || (this.mbN != paramInt2) || (paramBoolean)) && (paramInt1 != 0) && (paramInt2 != 0))
    {
      i = 1;
      this.mbM = paramInt1;
      this.mbN = paramInt2;
      if (i != 0)
      {
        i = this.mbM;
        j = this.mbN;
        k = this.PdW;
        if (k <= 0) {}
      }
    }
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1 + 1;
      ScanPoint localScanPoint2 = (ScanPoint)p.ae((List)this.PdX, paramInt1);
      ScanPoint localScanPoint1 = localScanPoint2;
      if (localScanPoint2 == null)
      {
        localScanPoint1 = new ScanPoint();
        this.PdX.add(localScanPoint1);
      }
      localScanPoint1.setX(i * localScanPoint1.getXFactor());
      localScanPoint1.setY(j * localScanPoint1.getYFactor());
      Log.d("MicroMsg.ScanAnimationDotsGroupView", "alvinluo onViewSizeChanged i: %d, %f, %f", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(localScanPoint1.getX()), Float.valueOf(localScanPoint1.getY()) });
      if (paramInt2 >= k)
      {
        AppMethodBeat.o(52268);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(52270);
    s.u(parama, "listener");
    Log.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo startAnimation %d", new Object[] { Integer.valueOf(hashCode()) });
    this.PdV = parama;
    this.Div = new AnimatorSet();
    parama = this.Div;
    s.checkNotNull(parama);
    parama.setDuration(this.duration);
    parama.removeAllListeners();
    parama.addListener((Animator.AnimatorListener)this.PdU);
    parama.playTogether(new Animator[] { (Animator)this.PdS, (Animator)this.PdT });
    parama.start();
    AppMethodBeat.o(52270);
  }
  
  public final void a(ScanPoint[] paramArrayOfScanPoint, int paramInt)
  {
    AppMethodBeat.i(52269);
    s.u(paramArrayOfScanPoint, "points");
    this.PdW = paramInt;
    int j = this.PdW;
    int i;
    ScanPoint localScanPoint2;
    ScanPoint localScanPoint1;
    if (j > 0)
    {
      paramInt = 0;
      i = paramInt + 1;
      localScanPoint2 = (ScanPoint)k.m(paramArrayOfScanPoint, paramInt);
      localScanPoint1 = (ScanPoint)p.ae((List)this.PdX, paramInt);
      if (localScanPoint1 != null) {
        break label162;
      }
      localScanPoint1 = new ScanPoint();
      this.PdX.add(localScanPoint1);
    }
    label147:
    label156:
    label162:
    for (;;)
    {
      if (localScanPoint2 == null)
      {
        f = 0.0F;
        localScanPoint1.setXFactor(f);
        if (localScanPoint2 != null) {
          break label147;
        }
      }
      for (float f = 0.0F;; f = localScanPoint2.getYFactor())
      {
        localScanPoint1.setYFactor(f);
        localScanPoint1.setX(0.0F);
        localScanPoint1.setY(0.0F);
        if (i < j) {
          break label156;
        }
        AppMethodBeat.o(52269);
        return;
        f = localScanPoint2.getXFactor();
        break;
      }
      paramInt = i;
      break;
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
    int k = this.PdW;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ScanPoint localScanPoint = (ScanPoint)p.ae((List)this.PdX, i);
      if (localScanPoint == null)
      {
        AppMethodBeat.o(52267);
        return;
      }
      if (paramCanvas != null) {
        paramCanvas.drawCircle(localScanPoint.getX(), localScanPoint.getY(), this.radius, this.paint);
      }
      if (j >= k)
      {
        AppMethodBeat.o(52267);
        return;
      }
    }
  }
  
  public final boolean gTd()
  {
    return this.isAnimating;
  }
  
  public final void release()
  {
    AppMethodBeat.i(52272);
    this.PdW = 0;
    this.PdX.clear();
    AppMethodBeat.o(52272);
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(52271);
    Log.v("MicroMsg.ScanAnimationDotsGroupView", "alvinluo stopAnimation");
    AnimatorSet localAnimatorSet = this.Div;
    if (localAnimatorSet != null) {
      localAnimatorSet.cancel();
    }
    AppMethodBeat.o(52271);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsGroupView$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(g paramg) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(52265);
      g.a(this.PdY, false);
      AppMethodBeat.o(52265);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52264);
      g.a(this.PdY, false);
      paramAnimator = g.a(this.PdY);
      if (paramAnimator != null) {
        paramAnimator.a((c)this.PdY);
      }
      AppMethodBeat.o(52264);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52266);
      g.a(this.PdY, true);
      g.a(this.PdY);
      AppMethodBeat.o(52266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.g
 * JD-Core Version:    0.7.0.1
 */