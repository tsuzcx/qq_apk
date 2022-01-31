package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class RadarDataLayer
  extends DataLayerView
{
  public static final Point oEM = new Point(0, 0);
  private Path nw = new Path();
  private int oEH = 4;
  private float oEK = 1.0F;
  private a oEN;
  private a oEO;
  private b oEP = new b();
  private ValueAnimator oEQ;
  private boolean oER = true;
  private int oES = 80;
  private Point oET = oEM;
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    this.oEK = paramFloat;
    this.oEP = parama.oDU;
    this.oEH = parama.size();
    this.oEN = parama;
    paramContext = parama.oDV;
    long l = parama.duration;
    if (l > 0L)
    {
      this.oEQ = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.oEO = new a();
      this.oEQ.setDuration(l);
      this.oEQ.setInterpolator(paramContext);
      this.oEQ.addUpdateListener(new RadarDataLayer.1(this));
    }
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bFc();
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bFc();
  }
  
  private void bFc()
  {
    setMinimumHeight(160);
    setMinimumWidth(160);
  }
  
  private Paint getPaintLayerBorder()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEP.oDX);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.oEP.oDY);
    localPaint.setAntiAlias(true);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEP.oEb);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    Paint localPaint = new Paint();
    b localb = this.oEP;
    if (localb.oDZ == -1) {}
    for (int i = localb.oDX;; i = localb.oDZ)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.oEP.oEa);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEP.oDX);
    localPaint.setStrokeWidth(this.oEP.oDY);
    return localPaint;
  }
  
  protected final int bEZ()
  {
    return this.oES * 2;
  }
  
  protected final int bFa()
  {
    return this.oES * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.oES = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.oET.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.oEN == null) {
      throw new RuntimeException("Error: NullPointerException at data.");
    }
    if (this.oEN != null)
    {
      Object localObject;
      label108:
      float f1;
      float f2;
      if (this.oEO == null)
      {
        localObject = this.oEN.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label320;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.oET.x - ((Float)localEntry.getValue()).floatValue() / this.oEK * this.oES * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.oEH));
        f2 = (float)(this.oET.y - ((Float)localEntry.getValue()).floatValue() / this.oEK * this.oES * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.oEH));
        if (i != 0) {
          break label308;
        }
        this.nw.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.oER) {
          paramCanvas.drawCircle(f1, f2, this.oEP.oEc, getPaintLayerDotPoint());
        }
        i += 1;
        break label108;
        localObject = this.oEO.entrySet();
        break;
        label308:
        this.nw.lineTo(f1, f2);
      }
      label320:
      this.nw.close();
      paramCanvas.drawPath(this.nw, getPaintLayerFilling());
      paramCanvas.drawPath(this.nw, getPaintLayerBorder());
      this.nw.reset();
    }
  }
  
  public void setData(a parama)
  {
    this.oEN = parama;
    invalidate();
  }
  
  public void setGlobalMax(float paramFloat)
  {
    this.oEK = paramFloat;
    invalidate();
  }
  
  public void setLayerStyle(b paramb)
  {
    this.oEP = paramb;
    invalidate();
  }
  
  public void setMaxValue(float paramFloat)
  {
    this.oEK = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer
 * JD-Core Version:    0.7.0.1
 */