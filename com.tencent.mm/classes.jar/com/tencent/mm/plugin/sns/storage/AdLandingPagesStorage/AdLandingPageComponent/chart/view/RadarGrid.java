package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid
  extends ChartGridView
{
  public static final Point oEM = new Point(0, 0);
  private Rect mRect = new Rect();
  private Path nw = new Path();
  private int oEH = 4;
  private int oEI = 4;
  private float oEK = 1.0F;
  private c oEL;
  private int oES = 80;
  private Point oET = oEM;
  private Spannable[] oEV;
  private List<PointF> oEW;
  
  public RadarGrid(Context paramContext, int paramInt1, int paramInt2, float paramFloat, Spannable[] paramArrayOfSpannable, c paramc)
  {
    super(paramContext);
    this.oEK = paramFloat;
    this.oEH = paramInt1;
    this.oEI = paramInt2;
    this.oEK = paramFloat;
    this.oEV = paramArrayOfSpannable;
    this.oEL = paramc;
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bFc();
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bFc();
  }
  
  private List<PointF> aC(float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.oEH)
    {
      PointF localPointF = new PointF();
      localPointF.set((float)(this.oET.x - this.oES * paramFloat * Math.sin(i * 2 * 3.141592653589793D / this.oEH)), (float)(this.oET.y - this.oES * paramFloat * Math.cos(i * 2 * 3.141592653589793D / this.oEH)));
      localArrayList.add(localPointF);
      i += 1;
    }
    return localArrayList;
  }
  
  private void bFc()
  {
    setMinimumHeight(160);
    setMinimumWidth(160);
  }
  
  private int getGridDotRadius()
  {
    return this.oEL.oEw;
  }
  
  private Paint getPaintGLabelFont()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEL.oEn);
    localPaint.setTextSize(this.oEL.oEo);
    return localPaint;
  }
  
  private Paint getPaintGScaleFont()
  {
    Paint localPaint = new Paint();
    c localc = this.oEL;
    if (localc.oEq == -1) {}
    for (int i = localc.oEn;; i = localc.oEq)
    {
      localPaint.setColor(i);
      localPaint.setTextSize(this.oEL.oEr);
      return localPaint;
    }
  }
  
  private Paint getPaintGridBorder()
  {
    Paint localPaint = new Paint();
    c localc = this.oEL;
    int i;
    if (localc.oEi == -1)
    {
      i = localc.oEj;
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.STROKE);
      localc = this.oEL;
      if (localc.oEm != -1.0F) {
        break label85;
      }
    }
    label85:
    for (float f = localc.oEl;; f = localc.oEm)
    {
      localPaint.setStrokeWidth(f);
      localPaint.setAntiAlias(true);
      return localPaint;
      i = localc.oEi;
      break;
    }
  }
  
  private Paint getPaintGridDot()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEL.oEv);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    return localPaint;
  }
  
  private Paint getPaintGridFill()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEL.backgroundColor);
    localPaint.setAntiAlias(true);
    return localPaint;
  }
  
  private Paint getPaintGridLatitude()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEL.oEj);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.oEL.oEl);
    localPaint.setAntiAlias(true);
    return localPaint;
  }
  
  private Paint getPaintGridLongitude()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.oEL.oEk);
    localPaint.setStrokeWidth(this.oEL.oEl);
    return localPaint;
  }
  
  private TextPaint getTextPaintGLabelFont()
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(this.oEL.oEn);
    localTextPaint.setTextSize(this.oEL.oEo);
    return localTextPaint;
  }
  
  protected final int bEZ()
  {
    return this.oES * 2;
  }
  
  protected final int bFa()
  {
    return this.oES * 2;
  }
  
  public c getGridStyle()
  {
    return this.oEL;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getHeight();
    int i = getWidth();
    this.oES = ((int)(Math.min(j, i) / 2.0F * 0.8D));
    this.oET.set((int)(i / 2.0F), (int)(j / 2.0F));
    if (this.oEL.oEx != null)
    {
      i = (int)(i / 2.0F);
      j = (int)(j / 2.0F);
      int k = (int)(this.oES * 2 + this.oEL.oEu * 2.0F);
      int m = this.oEL.oEx.getWidth() * k / this.oEL.oEx.getHeight();
      if (this.oEL.oEx != null) {
        paramCanvas.drawBitmap(Bitmap.createScaledBitmap(this.oEL.oEx, m, k, false), i - (m >>> 1), j - (k >>> 1), null);
      }
    }
    if (this.oEL.oEe) {
      switch (this.oEL.oEd)
      {
      }
    }
    Object localObject;
    while (this.oEL.oEf)
    {
      this.oEW = aC(1.0F);
      i = 0;
      while (i < this.oEH)
      {
        localObject = (PointF)this.oEW.get(i);
        paramCanvas.drawLine(this.oET.x, this.oET.y, ((PointF)localObject).x, ((PointF)localObject).y, getPaintGridLongitude());
        i += 1;
      }
      paramCanvas.drawCircle(this.oET.x, this.oET.y, this.oES, getPaintGridFill());
      continue;
      this.oEW = aC(1.0F);
      i = 0;
      if (i < this.oEH)
      {
        localObject = (PointF)this.oEW.get(i);
        if (i == 0) {
          this.nw.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
        for (;;)
        {
          i += 1;
          break;
          this.nw.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      this.nw.close();
      if ((this.oEL.backgroundColor != 0) && (this.oEL.oEx == null)) {
        paramCanvas.drawPath(this.nw, getPaintGridFill());
      }
    }
    if (this.oEL.oEe) {
      switch (this.oEL.oEd)
      {
      }
    }
    float f1;
    label872:
    float f2;
    for (;;)
    {
      if ((this.oEV != null) && (this.oEL.oEh)) {
        if (this.oEV.length != this.oEH)
        {
          throw new RuntimeException("Labels array length not matches longitude lines number.");
          paramCanvas.drawCircle(this.oET.x, this.oET.y, this.oES, getPaintGridBorder());
          i = 1;
          while (i < this.oEI)
          {
            paramCanvas.drawCircle(this.oET.x, this.oET.y, this.oES * (i * 1.0F / this.oEI), getPaintGridLatitude());
            i += 1;
          }
          paramCanvas.drawPath(this.nw, getPaintGridBorder());
          this.nw.reset();
          i = 1;
          while (i < this.oEI)
          {
            this.oEW = aC(i * 1.0F / this.oEI);
            j = 0;
            if (j < this.oEH)
            {
              localObject = (PointF)this.oEW.get(j);
              if (j == 0) {
                this.nw.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
              for (;;)
              {
                paramCanvas.drawCircle(((PointF)localObject).x, ((PointF)localObject).y, getGridDotRadius(), getPaintGridDot());
                j += 1;
                break;
                this.nw.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
            }
            this.nw.close();
            paramCanvas.drawPath(this.nw, getPaintGridLatitude());
            this.nw.reset();
            i += 1;
          }
        }
        else
        {
          i = 0;
          if (i < this.oEH)
          {
            localObject = this.oEV[i];
            if (!localObject.equals(null))
            {
              if ((i != 0) && (i != this.oEH >>> 1)) {
                break label1056;
              }
              f1 = 0.5F;
              if (i != 0) {
                break label1082;
              }
              f2 = this.oEL.oEp;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StaticLayout((CharSequence)localObject, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, false);
      f1 = (float)(this.oET.x - ((StaticLayout)localObject).getLineWidth(0) * f1 - (this.oES + this.oEL.oEp) * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.oEH));
      f2 = (float)(this.oET.y - ((StaticLayout)localObject).getHeight() / 2 - (this.oES + this.oEL.oEp) * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.oEH) - f2);
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      ((StaticLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      i += 1;
      break;
      label1056:
      if ((i > 0) && (i < this.oEH >>> 1))
      {
        f1 = 0.0F;
        break label872;
      }
      f1 = 1.0F;
      break label872;
      label1082:
      if (i == this.oEH >>> 1) {
        f2 = -this.oEL.oEp;
      } else {
        f2 = 0.0F;
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.oEL.backgroundColor = paramInt;
    invalidate();
  }
  
  public void setGridBorderColor(int paramInt)
  {
    this.oEL.oEi = paramInt;
    invalidate();
  }
  
  public void setGridBorderStrokeWidth(float paramFloat)
  {
    this.oEL.oEm = paramFloat;
    invalidate();
  }
  
  public void setGridChartType(int paramInt)
  {
    this.oEL.oEd = paramInt;
    invalidate();
  }
  
  public void setGridLabelColor(int paramInt)
  {
    this.oEL.oEn = paramInt;
    invalidate();
  }
  
  public void setGridLabelPadding(float paramFloat)
  {
    this.oEL.oEp = paramFloat;
    invalidate();
  }
  
  public void setGridLabelSize(float paramFloat)
  {
    this.oEL.oEo = paramFloat;
    invalidate();
  }
  
  public void setGridLatitudeColor(int paramInt)
  {
    this.oEL.oEj = paramInt;
    invalidate();
  }
  
  public void setGridLongitudeColor(int paramInt)
  {
    this.oEL.oEk = paramInt;
    invalidate();
  }
  
  public void setGridScaleColor(int paramInt)
  {
    this.oEL.oEq = paramInt;
    invalidate();
  }
  
  public void setGridScaleLabelPadding(float paramFloat)
  {
    this.oEL.oEs = paramFloat;
    invalidate();
  }
  
  public void setGridScaleSize(float paramFloat)
  {
    this.oEL.oEr = paramFloat;
    invalidate();
  }
  
  public void setGridStrokeWidth(float paramFloat)
  {
    this.oEL.oEl = paramFloat;
    invalidate();
  }
  
  public void setGridStyle(c paramc)
  {
    this.oEL = paramc;
    invalidate();
  }
  
  public void setLabelsArray(Spannable[] paramArrayOfSpannable)
  {
    this.oEV = paramArrayOfSpannable;
    invalidate();
  }
  
  public void setLatNum(int paramInt)
  {
    this.oEI = paramInt;
    invalidate();
  }
  
  public void setLonNum(int paramInt)
  {
    this.oEH = paramInt;
    invalidate();
  }
  
  public void setMaxValue(float paramFloat)
  {
    this.oEK = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid
 * JD-Core Version:    0.7.0.1
 */