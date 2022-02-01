package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class RadarDataLayer
  extends DataLayerView
{
  public static final Point wYu;
  private Path uW;
  private int wYA;
  private Point wYB;
  private int wYp;
  private float wYs;
  private a wYv;
  private a wYw;
  private b wYx;
  private ValueAnimator wYy;
  private boolean wYz;
  
  static
  {
    AppMethodBeat.i(96360);
    wYu = new Point(0, 0);
    AppMethodBeat.o(96360);
  }
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(96349);
    this.wYx = new b();
    this.wYz = true;
    this.wYp = 4;
    this.wYA = 80;
    this.wYB = wYu;
    this.wYs = 1.0F;
    this.uW = new Path();
    this.wYs = paramFloat;
    this.wYx = parama.wXC;
    this.wYp = parama.size();
    this.wYv = parama;
    paramContext = parama.wXD;
    long l = parama.duration;
    if (l > 0L)
    {
      this.wYy = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.wYw = new a();
      this.wYy.setDuration(l);
      this.wYy.setInterpolator(paramContext);
      this.wYy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(96346);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = RadarDataLayer.a(RadarDataLayer.this).entrySet().iterator();
          while (paramAnonymousValueAnimator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramAnonymousValueAnimator.next();
            RadarDataLayer.b(RadarDataLayer.this).put(localEntry.getKey(), Float.valueOf(((Float)localEntry.getValue()).floatValue() * f));
            RadarDataLayer.this.invalidate();
          }
          AppMethodBeat.o(96346);
        }
      });
    }
    AppMethodBeat.o(96349);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96347);
    this.wYx = new b();
    this.wYz = true;
    this.wYp = 4;
    this.wYA = 80;
    this.wYB = wYu;
    this.wYs = 1.0F;
    this.uW = new Path();
    dvI();
    AppMethodBeat.o(96347);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96348);
    this.wYx = new b();
    this.wYz = true;
    this.wYp = 4;
    this.wYA = 80;
    this.wYB = wYu;
    this.wYs = 1.0F;
    this.uW = new Path();
    dvI();
    AppMethodBeat.o(96348);
  }
  
  private void dvI()
  {
    AppMethodBeat.i(96350);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(96350);
  }
  
  private Paint getPaintLayerBorder()
  {
    AppMethodBeat.i(96353);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYx.wXF);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.wYx.wXG);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96353);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    AppMethodBeat.i(96355);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYx.wXJ);
    AppMethodBeat.o(96355);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    AppMethodBeat.i(96352);
    Paint localPaint = new Paint();
    b localb = this.wYx;
    if (localb.wXH == -1) {}
    for (int i = localb.wXF;; i = localb.wXH)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.wYx.wXI);
      AppMethodBeat.o(96352);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    AppMethodBeat.i(96354);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYx.wXF);
    localPaint.setStrokeWidth(this.wYx.wXG);
    AppMethodBeat.o(96354);
    return localPaint;
  }
  
  public final int dvF()
  {
    return this.wYA * 2;
  }
  
  public final int dvG()
  {
    return this.wYA * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96351);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.wYA = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.wYB.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.wYv == null)
    {
      paramCanvas = new RuntimeException("Error: NullPointerException at data.");
      AppMethodBeat.o(96351);
      throw paramCanvas;
    }
    if (this.wYv != null)
    {
      Object localObject;
      label120:
      float f1;
      float f2;
      if (this.wYw == null)
      {
        localObject = this.wYv.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label332;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.wYB.x - ((Float)localEntry.getValue()).floatValue() / this.wYs * this.wYA * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.wYp));
        f2 = (float)(this.wYB.y - ((Float)localEntry.getValue()).floatValue() / this.wYs * this.wYA * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.wYp));
        if (i != 0) {
          break label320;
        }
        this.uW.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.wYz) {
          paramCanvas.drawCircle(f1, f2, this.wYx.wXK, getPaintLayerDotPoint());
        }
        i += 1;
        break label120;
        localObject = this.wYw.entrySet();
        break;
        label320:
        this.uW.lineTo(f1, f2);
      }
      label332:
      this.uW.close();
      paramCanvas.drawPath(this.uW, getPaintLayerFilling());
      paramCanvas.drawPath(this.uW, getPaintLayerBorder());
      this.uW.reset();
    }
    AppMethodBeat.o(96351);
  }
  
  public void setData(a parama)
  {
    AppMethodBeat.i(96357);
    this.wYv = parama;
    invalidate();
    AppMethodBeat.o(96357);
  }
  
  public void setGlobalMax(float paramFloat)
  {
    AppMethodBeat.i(96356);
    this.wYs = paramFloat;
    invalidate();
    AppMethodBeat.o(96356);
  }
  
  public void setLayerStyle(b paramb)
  {
    AppMethodBeat.i(96358);
    this.wYx = paramb;
    invalidate();
    AppMethodBeat.o(96358);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96359);
    this.wYs = paramFloat;
    invalidate();
    AppMethodBeat.o(96359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer
 * JD-Core Version:    0.7.0.1
 */