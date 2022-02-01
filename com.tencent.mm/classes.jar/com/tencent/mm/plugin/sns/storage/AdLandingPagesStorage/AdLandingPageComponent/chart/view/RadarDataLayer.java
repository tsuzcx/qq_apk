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
  public static final Point yli;
  private Path vU;
  private int yld;
  private float ylg;
  private a ylj;
  private a ylk;
  private b yll;
  private ValueAnimator ylm;
  private boolean yln;
  private int ylo;
  private Point ylp;
  
  static
  {
    AppMethodBeat.i(96360);
    yli = new Point(0, 0);
    AppMethodBeat.o(96360);
  }
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(96349);
    this.yll = new b();
    this.yln = true;
    this.yld = 4;
    this.ylo = 80;
    this.ylp = yli;
    this.ylg = 1.0F;
    this.vU = new Path();
    this.ylg = paramFloat;
    this.yll = parama.ykq;
    this.yld = parama.size();
    this.ylj = parama;
    paramContext = parama.ykr;
    long l = parama.duration;
    if (l > 0L)
    {
      this.ylm = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.ylk = new a();
      this.ylm.setDuration(l);
      this.ylm.setInterpolator(paramContext);
      this.ylm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.yll = new b();
    this.yln = true;
    this.yld = 4;
    this.ylo = 80;
    this.ylp = yli;
    this.ylg = 1.0F;
    this.vU = new Path();
    dKh();
    AppMethodBeat.o(96347);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96348);
    this.yll = new b();
    this.yln = true;
    this.yld = 4;
    this.ylo = 80;
    this.ylp = yli;
    this.ylg = 1.0F;
    this.vU = new Path();
    dKh();
    AppMethodBeat.o(96348);
  }
  
  private void dKh()
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
    localPaint.setColor(this.yll.ykt);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.yll.yku);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96353);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    AppMethodBeat.i(96355);
    Paint localPaint = new Paint();
    localPaint.setColor(this.yll.ykx);
    AppMethodBeat.o(96355);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    AppMethodBeat.i(96352);
    Paint localPaint = new Paint();
    b localb = this.yll;
    if (localb.ykv == -1) {}
    for (int i = localb.ykt;; i = localb.ykv)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.yll.ykw);
      AppMethodBeat.o(96352);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    AppMethodBeat.i(96354);
    Paint localPaint = new Paint();
    localPaint.setColor(this.yll.ykt);
    localPaint.setStrokeWidth(this.yll.yku);
    AppMethodBeat.o(96354);
    return localPaint;
  }
  
  public final int dKe()
  {
    return this.ylo * 2;
  }
  
  public final int dKf()
  {
    return this.ylo * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96351);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.ylo = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.ylp.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.ylj == null)
    {
      paramCanvas = new RuntimeException("Error: NullPointerException at data.");
      AppMethodBeat.o(96351);
      throw paramCanvas;
    }
    if (this.ylj != null)
    {
      Object localObject;
      label120:
      float f1;
      float f2;
      if (this.ylk == null)
      {
        localObject = this.ylj.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label332;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.ylp.x - ((Float)localEntry.getValue()).floatValue() / this.ylg * this.ylo * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.yld));
        f2 = (float)(this.ylp.y - ((Float)localEntry.getValue()).floatValue() / this.ylg * this.ylo * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.yld));
        if (i != 0) {
          break label320;
        }
        this.vU.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.yln) {
          paramCanvas.drawCircle(f1, f2, this.yll.yky, getPaintLayerDotPoint());
        }
        i += 1;
        break label120;
        localObject = this.ylk.entrySet();
        break;
        label320:
        this.vU.lineTo(f1, f2);
      }
      label332:
      this.vU.close();
      paramCanvas.drawPath(this.vU, getPaintLayerFilling());
      paramCanvas.drawPath(this.vU, getPaintLayerBorder());
      this.vU.reset();
    }
    AppMethodBeat.o(96351);
  }
  
  public void setData(a parama)
  {
    AppMethodBeat.i(96357);
    this.ylj = parama;
    invalidate();
    AppMethodBeat.o(96357);
  }
  
  public void setGlobalMax(float paramFloat)
  {
    AppMethodBeat.i(96356);
    this.ylg = paramFloat;
    invalidate();
    AppMethodBeat.o(96356);
  }
  
  public void setLayerStyle(b paramb)
  {
    AppMethodBeat.i(96358);
    this.yll = paramb;
    invalidate();
    AppMethodBeat.o(96358);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96359);
    this.ylg = paramFloat;
    invalidate();
    AppMethodBeat.o(96359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer
 * JD-Core Version:    0.7.0.1
 */