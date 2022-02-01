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
  public static final Point Ebi;
  private int Ebe;
  private a Ebj;
  private a Ebk;
  private b Ebl;
  private ValueAnimator Ebm;
  private boolean Ebn;
  private int Ebo;
  private Point Ebp;
  private float maxValue;
  private Path xT;
  
  static
  {
    AppMethodBeat.i(96360);
    Ebi = new Point(0, 0);
    AppMethodBeat.o(96360);
  }
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(96349);
    this.Ebl = new b();
    this.Ebn = true;
    this.Ebe = 4;
    this.Ebo = 80;
    this.Ebp = Ebi;
    this.maxValue = 1.0F;
    this.xT = new Path();
    this.maxValue = paramFloat;
    this.Ebl = parama.Ear;
    this.Ebe = parama.size();
    this.Ebj = parama;
    paramContext = parama.Eas;
    long l = parama.duration;
    if (l > 0L)
    {
      this.Ebm = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Ebk = new a();
      this.Ebm.setDuration(l);
      this.Ebm.setInterpolator(paramContext);
      this.Ebm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.Ebl = new b();
    this.Ebn = true;
    this.Ebe = 4;
    this.Ebo = 80;
    this.Ebp = Ebi;
    this.maxValue = 1.0F;
    this.xT = new Path();
    fcR();
    AppMethodBeat.o(96347);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96348);
    this.Ebl = new b();
    this.Ebn = true;
    this.Ebe = 4;
    this.Ebo = 80;
    this.Ebp = Ebi;
    this.maxValue = 1.0F;
    this.xT = new Path();
    fcR();
    AppMethodBeat.o(96348);
  }
  
  private void fcR()
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
    localPaint.setColor(this.Ebl.Eau);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.Ebl.Eav);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96353);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    AppMethodBeat.i(96355);
    Paint localPaint = new Paint();
    localPaint.setColor(this.Ebl.Eay);
    AppMethodBeat.o(96355);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    AppMethodBeat.i(96352);
    Paint localPaint = new Paint();
    b localb = this.Ebl;
    if (localb.Eaw == -1) {}
    for (int i = localb.Eau;; i = localb.Eaw)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.Ebl.Eax);
      AppMethodBeat.o(96352);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    AppMethodBeat.i(96354);
    Paint localPaint = new Paint();
    localPaint.setColor(this.Ebl.Eau);
    localPaint.setStrokeWidth(this.Ebl.Eav);
    AppMethodBeat.o(96354);
    return localPaint;
  }
  
  public final int fcO()
  {
    return this.Ebo * 2;
  }
  
  public final int fcP()
  {
    return this.Ebo * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96351);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.Ebo = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.Ebp.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.Ebj == null)
    {
      paramCanvas = new RuntimeException("Error: NullPointerException at data.");
      AppMethodBeat.o(96351);
      throw paramCanvas;
    }
    if (this.Ebj != null)
    {
      Object localObject;
      label120:
      float f1;
      float f2;
      if (this.Ebk == null)
      {
        localObject = this.Ebj.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label332;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.Ebp.x - ((Float)localEntry.getValue()).floatValue() / this.maxValue * this.Ebo * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.Ebe));
        f2 = (float)(this.Ebp.y - ((Float)localEntry.getValue()).floatValue() / this.maxValue * this.Ebo * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.Ebe));
        if (i != 0) {
          break label320;
        }
        this.xT.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.Ebn) {
          paramCanvas.drawCircle(f1, f2, this.Ebl.Eaz, getPaintLayerDotPoint());
        }
        i += 1;
        break label120;
        localObject = this.Ebk.entrySet();
        break;
        label320:
        this.xT.lineTo(f1, f2);
      }
      label332:
      this.xT.close();
      paramCanvas.drawPath(this.xT, getPaintLayerFilling());
      paramCanvas.drawPath(this.xT, getPaintLayerBorder());
      this.xT.reset();
    }
    AppMethodBeat.o(96351);
  }
  
  public void setData(a parama)
  {
    AppMethodBeat.i(96357);
    this.Ebj = parama;
    invalidate();
    AppMethodBeat.o(96357);
  }
  
  public void setGlobalMax(float paramFloat)
  {
    AppMethodBeat.i(96356);
    this.maxValue = paramFloat;
    invalidate();
    AppMethodBeat.o(96356);
  }
  
  public void setLayerStyle(b paramb)
  {
    AppMethodBeat.i(96358);
    this.Ebl = paramb;
    invalidate();
    AppMethodBeat.o(96358);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96359);
    this.maxValue = paramFloat;
    invalidate();
    AppMethodBeat.o(96359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer
 * JD-Core Version:    0.7.0.1
 */