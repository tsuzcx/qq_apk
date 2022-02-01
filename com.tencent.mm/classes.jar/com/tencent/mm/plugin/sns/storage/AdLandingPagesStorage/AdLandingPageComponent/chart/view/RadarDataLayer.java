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
  public static final Point zBX;
  private Path xN;
  private int zBS;
  private float zBV;
  private a zBY;
  private a zBZ;
  private b zCa;
  private ValueAnimator zCb;
  private boolean zCc;
  private int zCd;
  private Point zCe;
  
  static
  {
    AppMethodBeat.i(96360);
    zBX = new Point(0, 0);
    AppMethodBeat.o(96360);
  }
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(96349);
    this.zCa = new b();
    this.zCc = true;
    this.zBS = 4;
    this.zCd = 80;
    this.zCe = zBX;
    this.zBV = 1.0F;
    this.xN = new Path();
    this.zBV = paramFloat;
    this.zCa = parama.zBf;
    this.zBS = parama.size();
    this.zBY = parama;
    paramContext = parama.zBg;
    long l = parama.duration;
    if (l > 0L)
    {
      this.zCb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.zBZ = new a();
      this.zCb.setDuration(l);
      this.zCb.setInterpolator(paramContext);
      this.zCb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.zCa = new b();
    this.zCc = true;
    this.zBS = 4;
    this.zCd = 80;
    this.zCe = zBX;
    this.zBV = 1.0F;
    this.xN = new Path();
    dWv();
    AppMethodBeat.o(96347);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96348);
    this.zCa = new b();
    this.zCc = true;
    this.zBS = 4;
    this.zCd = 80;
    this.zCe = zBX;
    this.zBV = 1.0F;
    this.xN = new Path();
    dWv();
    AppMethodBeat.o(96348);
  }
  
  private void dWv()
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
    localPaint.setColor(this.zCa.zBi);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.zCa.zBj);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96353);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    AppMethodBeat.i(96355);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zCa.zBm);
    AppMethodBeat.o(96355);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    AppMethodBeat.i(96352);
    Paint localPaint = new Paint();
    b localb = this.zCa;
    if (localb.zBk == -1) {}
    for (int i = localb.zBi;; i = localb.zBk)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.zCa.zBl);
      AppMethodBeat.o(96352);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    AppMethodBeat.i(96354);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zCa.zBi);
    localPaint.setStrokeWidth(this.zCa.zBj);
    AppMethodBeat.o(96354);
    return localPaint;
  }
  
  public final int dWs()
  {
    return this.zCd * 2;
  }
  
  public final int dWt()
  {
    return this.zCd * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96351);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.zCd = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.zCe.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.zBY == null)
    {
      paramCanvas = new RuntimeException("Error: NullPointerException at data.");
      AppMethodBeat.o(96351);
      throw paramCanvas;
    }
    if (this.zBY != null)
    {
      Object localObject;
      label120:
      float f1;
      float f2;
      if (this.zBZ == null)
      {
        localObject = this.zBY.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label332;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.zCe.x - ((Float)localEntry.getValue()).floatValue() / this.zBV * this.zCd * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.zBS));
        f2 = (float)(this.zCe.y - ((Float)localEntry.getValue()).floatValue() / this.zBV * this.zCd * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.zBS));
        if (i != 0) {
          break label320;
        }
        this.xN.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.zCc) {
          paramCanvas.drawCircle(f1, f2, this.zCa.zBn, getPaintLayerDotPoint());
        }
        i += 1;
        break label120;
        localObject = this.zBZ.entrySet();
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
    this.zBY = parama;
    invalidate();
    AppMethodBeat.o(96357);
  }
  
  public void setGlobalMax(float paramFloat)
  {
    AppMethodBeat.i(96356);
    this.zBV = paramFloat;
    invalidate();
    AppMethodBeat.o(96356);
  }
  
  public void setLayerStyle(b paramb)
  {
    AppMethodBeat.i(96358);
    this.zCa = paramb;
    invalidate();
    AppMethodBeat.o(96358);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96359);
    this.zBV = paramFloat;
    invalidate();
    AppMethodBeat.o(96359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer
 * JD-Core Version:    0.7.0.1
 */