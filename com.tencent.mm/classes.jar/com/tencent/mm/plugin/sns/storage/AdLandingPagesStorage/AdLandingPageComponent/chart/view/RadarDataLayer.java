package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
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
  public static final Point run;
  private Path ou;
  private int rui;
  private float rul;
  private a ruo;
  private a rup;
  private b ruq;
  private ValueAnimator rur;
  private boolean rus;
  private int rut;
  private Point ruu;
  
  static
  {
    AppMethodBeat.i(36979);
    run = new Point(0, 0);
    AppMethodBeat.o(36979);
  }
  
  public RadarDataLayer(Context paramContext, float paramFloat, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(36968);
    this.ruq = new b();
    this.rus = true;
    this.rui = 4;
    this.rut = 80;
    this.ruu = run;
    this.rul = 1.0F;
    this.ou = new Path();
    this.rul = paramFloat;
    this.ruq = parama.rtv;
    this.rui = parama.size();
    this.ruo = parama;
    paramContext = parama.rtw;
    long l = parama.duration;
    if (l > 0L)
    {
      this.rur = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.rup = new a();
      this.rur.setDuration(l);
      this.rur.setInterpolator(paramContext);
      this.rur.addUpdateListener(new RadarDataLayer.1(this));
    }
    AppMethodBeat.o(36968);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(36966);
    this.ruq = new b();
    this.rus = true;
    this.rui = 4;
    this.rut = 80;
    this.ruu = run;
    this.rul = 1.0F;
    this.ou = new Path();
    cqJ();
    AppMethodBeat.o(36966);
  }
  
  public RadarDataLayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(36967);
    this.ruq = new b();
    this.rus = true;
    this.rui = 4;
    this.rut = 80;
    this.ruu = run;
    this.rul = 1.0F;
    this.ou = new Path();
    cqJ();
    AppMethodBeat.o(36967);
  }
  
  private void cqJ()
  {
    AppMethodBeat.i(36969);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(36969);
  }
  
  private Paint getPaintLayerBorder()
  {
    AppMethodBeat.i(36972);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ruq.rty);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.ruq.rtz);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(36972);
    return localPaint;
  }
  
  private Paint getPaintLayerDotPoint()
  {
    AppMethodBeat.i(36974);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ruq.rtC);
    AppMethodBeat.o(36974);
    return localPaint;
  }
  
  private Paint getPaintLayerFilling()
  {
    AppMethodBeat.i(36971);
    Paint localPaint = new Paint();
    b localb = this.ruq;
    if (localb.rtA == -1) {}
    for (int i = localb.rty;; i = localb.rtA)
    {
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      localPaint.setAlpha(this.ruq.rtB);
      AppMethodBeat.o(36971);
      return localPaint;
    }
  }
  
  private Paint getPaintLayerPoint()
  {
    AppMethodBeat.i(36973);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ruq.rty);
    localPaint.setStrokeWidth(this.ruq.rtz);
    AppMethodBeat.o(36973);
    return localPaint;
  }
  
  public final int cqG()
  {
    return this.rut * 2;
  }
  
  public final int cqH()
  {
    return this.rut * 2;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(36970);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    this.rut = ((int)(Math.min(i, j) / 2.0F * 0.8D));
    this.ruu.set((int)(j / 2.0F), (int)(i / 2.0F));
    if (this.ruo == null)
    {
      paramCanvas = new RuntimeException("Error: NullPointerException at data.");
      AppMethodBeat.o(36970);
      throw paramCanvas;
    }
    if (this.ruo != null)
    {
      Object localObject;
      label120:
      float f1;
      float f2;
      if (this.rup == null)
      {
        localObject = this.ruo.entrySet();
        localObject = ((Set)localObject).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label332;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        f1 = (float)(this.ruu.x - ((Float)localEntry.getValue()).floatValue() / this.rul * this.rut * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.rui));
        f2 = (float)(this.ruu.y - ((Float)localEntry.getValue()).floatValue() / this.rul * this.rut * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.rui));
        if (i != 0) {
          break label320;
        }
        this.ou.moveTo(f1, f2);
      }
      for (;;)
      {
        if (this.rus) {
          paramCanvas.drawCircle(f1, f2, this.ruq.rtD, getPaintLayerDotPoint());
        }
        i += 1;
        break label120;
        localObject = this.rup.entrySet();
        break;
        label320:
        this.ou.lineTo(f1, f2);
      }
      label332:
      this.ou.close();
      paramCanvas.drawPath(this.ou, getPaintLayerFilling());
      paramCanvas.drawPath(this.ou, getPaintLayerBorder());
      this.ou.reset();
    }
    AppMethodBeat.o(36970);
  }
  
  public void setData(a parama)
  {
    AppMethodBeat.i(36976);
    this.ruo = parama;
    invalidate();
    AppMethodBeat.o(36976);
  }
  
  public void setGlobalMax(float paramFloat)
  {
    AppMethodBeat.i(36975);
    this.rul = paramFloat;
    invalidate();
    AppMethodBeat.o(36975);
  }
  
  public void setLayerStyle(b paramb)
  {
    AppMethodBeat.i(36977);
    this.ruq = paramb;
    invalidate();
    AppMethodBeat.o(36977);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(36978);
    this.rul = paramFloat;
    invalidate();
    AppMethodBeat.o(36978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer
 * JD-Core Version:    0.7.0.1
 */