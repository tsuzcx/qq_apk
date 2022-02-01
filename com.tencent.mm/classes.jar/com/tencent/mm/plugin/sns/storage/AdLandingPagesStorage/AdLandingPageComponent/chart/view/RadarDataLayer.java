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
  public static final Point zSZ;
  private Path xN;
  private int zSU;
  private float zSX;
  private a zTa;
  private a zTb;
  private b zTc;
  private ValueAnimator zTd;
  private boolean zTe;
  private int zTf;
  private Point zTg;
  
  static
  {
    AppMethodBeat.i(96360);
    zSZ = new Point(0, 0);
    AppMethodBeat.o(96360);
  }
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(96349);
    this.zTc = new b();
    this.zTe = true;
    this.zSU = 4;
    this.zTf = 80;
    this.zTg = zSZ;
    this.zSX = 1.0F;
    this.xN = new Path();
    this.zSX = paramFloat;
    this.zTc = parama.zSh;
    this.zSU = parama.size();
    this.zTa = parama;
    paramContext = parama.zSi;
    long l = parama.duration;
    if (l > 0L)
    {
      this.zTd = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zTb = new a();
      this.zTd.setDuration(l);
      this.zTd.setInterpolator(paramContext);
      this.zTd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.zTc = new b();
    this.zTe = true;
    this.zSU = 4;
    this.zTf = 80;
    this.zTg = zSZ;
    this.zSX = 1.0F;
    this.xN = new Path();
    dZX();
    AppMethodBeat.o(96347);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96348);
    this.zTc = new b();
    this.zTe = true;
    this.zSU = 4;
    this.zTf = 80;
    this.zTg = zSZ;
    this.zSX = 1.0F;
    this.xN = new Path();
    dZX();
    AppMethodBeat.o(96348);
  }
  
  private void dZX()
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
    localPaint.setColor(this.zTc.zSk);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.zTc.zSl);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96353);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    AppMethodBeat.i(96355);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zTc.zSo);
    AppMethodBeat.o(96355);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    AppMethodBeat.i(96352);
    Paint localPaint = new Paint();
    b localb = this.zTc;
    if (localb.zSm == -1) {}
    for (int i = localb.zSk;; i = localb.zSm)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.zTc.zSn);
      AppMethodBeat.o(96352);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    AppMethodBeat.i(96354);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zTc.zSk);
    localPaint.setStrokeWidth(this.zTc.zSl);
    AppMethodBeat.o(96354);
    return localPaint;
  }
  
  public final int dZU()
  {
    return this.zTf * 2;
  }
  
  public final int dZV()
  {
    return this.zTf * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96351);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.zTf = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.zTg.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.zTa == null)
    {
      paramCanvas = new RuntimeException("Error: NullPointerException at data.");
      AppMethodBeat.o(96351);
      throw paramCanvas;
    }
    if (this.zTa != null)
    {
      Object localObject;
      label120:
      float f1;
      float f2;
      if (this.zTb == null)
      {
        localObject = this.zTa.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label332;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.zTg.x - ((Float)localEntry.getValue()).floatValue() / this.zSX * this.zTf * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.zSU));
        f2 = (float)(this.zTg.y - ((Float)localEntry.getValue()).floatValue() / this.zSX * this.zTf * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.zSU));
        if (i != 0) {
          break label320;
        }
        this.xN.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.zTe) {
          paramCanvas.drawCircle(f1, f2, this.zTc.zSp, getPaintLayerDotPoint());
        }
        i += 1;
        break label120;
        localObject = this.zTb.entrySet();
        break;
        label320:
        this.xN.lineTo(f1, f2);
      }
      label332:
      this.xN.close();
      paramCanvas.drawPath(this.xN, getPaintLayerFilling());
      paramCanvas.drawPath(this.xN, getPaintLayerBorder());
      this.xN.reset();
    }
    AppMethodBeat.o(96351);
  }
  
  public void setData(a parama)
  {
    AppMethodBeat.i(96357);
    this.zTa = parama;
    invalidate();
    AppMethodBeat.o(96357);
  }
  
  public void setGlobalMax(float paramFloat)
  {
    AppMethodBeat.i(96356);
    this.zSX = paramFloat;
    invalidate();
    AppMethodBeat.o(96356);
  }
  
  public void setLayerStyle(b paramb)
  {
    AppMethodBeat.i(96358);
    this.zTc = paramb;
    invalidate();
    AppMethodBeat.o(96358);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96359);
    this.zSX = paramFloat;
    invalidate();
    AppMethodBeat.o(96359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer
 * JD-Core Version:    0.7.0.1
 */