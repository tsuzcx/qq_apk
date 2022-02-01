package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.text.Spannable;
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
  public static final Point QMK;
  private int QMG;
  private a QML;
  private a QMM;
  private b QMN;
  private ValueAnimator QMO;
  private boolean QMP;
  private int QMQ;
  private Point QMR;
  private Path cja;
  private float maxValue;
  
  static
  {
    AppMethodBeat.i(96360);
    QMK = new Point(0, 0);
    AppMethodBeat.o(96360);
  }
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(96349);
    this.QMN = new b();
    this.QMP = true;
    this.QMG = 4;
    this.QMQ = 80;
    this.QMR = QMK;
    this.maxValue = 1.0F;
    this.cja = new Path();
    this.maxValue = paramFloat;
    this.QMN = parama.QLT;
    this.QMG = parama.size();
    this.QML = parama;
    paramContext = parama.QLU;
    long l = parama.duration;
    if (l > 0L)
    {
      this.QMO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.QMM = new a();
      this.QMO.setDuration(l);
      this.QMO.setInterpolator(paramContext);
      this.QMO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(96346);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = RadarDataLayer.a(RadarDataLayer.this).entrySet().iterator();
          while (paramAnonymousValueAnimator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramAnonymousValueAnimator.next();
            RadarDataLayer.b(RadarDataLayer.this).put((Spannable)localEntry.getKey(), Float.valueOf(((Float)localEntry.getValue()).floatValue() * f));
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
    this.QMN = new b();
    this.QMP = true;
    this.QMG = 4;
    this.QMQ = 80;
    this.QMR = QMK;
    this.maxValue = 1.0F;
    this.cja = new Path();
    ghu();
    AppMethodBeat.o(96347);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96348);
    this.QMN = new b();
    this.QMP = true;
    this.QMG = 4;
    this.QMQ = 80;
    this.QMR = QMK;
    this.maxValue = 1.0F;
    this.cja = new Path();
    ghu();
    AppMethodBeat.o(96348);
  }
  
  private Paint getPaintLayerBorder()
  {
    AppMethodBeat.i(96353);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMN.QLW);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.QMN.QLX);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96353);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    AppMethodBeat.i(96355);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMN.QMa);
    AppMethodBeat.o(96355);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    AppMethodBeat.i(96352);
    Paint localPaint = new Paint();
    b localb = this.QMN;
    if (localb.QLY == -1) {}
    for (int i = localb.QLW;; i = localb.QLY)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.QMN.QLZ);
      AppMethodBeat.o(96352);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    AppMethodBeat.i(96354);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMN.QLW);
    localPaint.setStrokeWidth(this.QMN.QLX);
    AppMethodBeat.o(96354);
    return localPaint;
  }
  
  private void ghu()
  {
    AppMethodBeat.i(96350);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(96350);
  }
  
  public final int hiE()
  {
    return this.QMQ * 2;
  }
  
  public final int hiF()
  {
    return this.QMQ * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96351);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.QMQ = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.QMR.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.QML == null)
    {
      paramCanvas = new RuntimeException("Error: NullPointerException at data.");
      AppMethodBeat.o(96351);
      throw paramCanvas;
    }
    if (this.QML != null)
    {
      Object localObject;
      label120:
      float f1;
      float f2;
      if (this.QMM == null)
      {
        localObject = this.QML.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label332;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.QMR.x - ((Float)localEntry.getValue()).floatValue() / this.maxValue * this.QMQ * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.QMG));
        f2 = (float)(this.QMR.y - ((Float)localEntry.getValue()).floatValue() / this.maxValue * this.QMQ * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.QMG));
        if (i != 0) {
          break label320;
        }
        this.cja.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.QMP) {
          paramCanvas.drawCircle(f1, f2, this.QMN.QMb, getPaintLayerDotPoint());
        }
        i += 1;
        break label120;
        localObject = this.QMM.entrySet();
        break;
        label320:
        this.cja.lineTo(f1, f2);
      }
      label332:
      this.cja.close();
      paramCanvas.drawPath(this.cja, getPaintLayerFilling());
      paramCanvas.drawPath(this.cja, getPaintLayerBorder());
      this.cja.reset();
    }
    AppMethodBeat.o(96351);
  }
  
  public void setData(a parama)
  {
    AppMethodBeat.i(96357);
    this.QML = parama;
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
    this.QMN = paramb;
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