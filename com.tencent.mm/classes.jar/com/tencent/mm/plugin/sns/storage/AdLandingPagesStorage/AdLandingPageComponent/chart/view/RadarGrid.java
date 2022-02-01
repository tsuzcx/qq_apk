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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid
  extends ChartGridView
{
  public static final Point wYu;
  private Rect mRect;
  private Path uW;
  private int wYA;
  private Point wYB;
  private Spannable[] wYD;
  private List<PointF> wYE;
  private int wYp;
  private int wYq;
  private float wYs;
  private c wYt;
  
  static
  {
    AppMethodBeat.i(96393);
    wYu = new Point(0, 0);
    AppMethodBeat.o(96393);
  }
  
  public RadarGrid(Context paramContext, int paramInt1, int paramInt2, float paramFloat, Spannable[] paramArrayOfSpannable, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(96363);
    this.wYp = 4;
    this.wYq = 4;
    this.wYs = 1.0F;
    this.wYA = 80;
    this.wYB = wYu;
    this.uW = new Path();
    this.mRect = new Rect();
    this.wYs = paramFloat;
    this.wYp = paramInt1;
    this.wYq = paramInt2;
    this.wYs = paramFloat;
    this.wYD = paramArrayOfSpannable;
    this.wYt = paramc;
    AppMethodBeat.o(96363);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96361);
    this.wYp = 4;
    this.wYq = 4;
    this.wYs = 1.0F;
    this.wYA = 80;
    this.wYB = wYu;
    this.uW = new Path();
    this.mRect = new Rect();
    dvI();
    AppMethodBeat.o(96361);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96362);
    this.wYp = 4;
    this.wYq = 4;
    this.wYs = 1.0F;
    this.wYA = 80;
    this.wYB = wYu;
    this.uW = new Path();
    this.mRect = new Rect();
    dvI();
    AppMethodBeat.o(96362);
  }
  
  private List<PointF> bq(float paramFloat)
  {
    AppMethodBeat.i(96365);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.wYp)
    {
      PointF localPointF = new PointF();
      localPointF.set((float)(this.wYB.x - this.wYA * paramFloat * Math.sin(i * 2 * 3.141592653589793D / this.wYp)), (float)(this.wYB.y - this.wYA * paramFloat * Math.cos(i * 2 * 3.141592653589793D / this.wYp)));
      localArrayList.add(localPointF);
      i += 1;
    }
    AppMethodBeat.o(96365);
    return localArrayList;
  }
  
  private void dvI()
  {
    AppMethodBeat.i(96364);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(96364);
  }
  
  private int getGridDotRadius()
  {
    return this.wYt.wYe;
  }
  
  private Paint getPaintGLabelFont()
  {
    AppMethodBeat.i(96372);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYt.wXV);
    localPaint.setTextSize(this.wYt.wXW);
    AppMethodBeat.o(96372);
    return localPaint;
  }
  
  private Paint getPaintGScaleFont()
  {
    AppMethodBeat.i(96374);
    Paint localPaint = new Paint();
    c localc = this.wYt;
    if (localc.wXY == -1) {}
    for (int i = localc.wXV;; i = localc.wXY)
    {
      localPaint.setColor(i);
      localPaint.setTextSize(this.wYt.wXZ);
      AppMethodBeat.o(96374);
      return localPaint;
    }
  }
  
  private Paint getPaintGridBorder()
  {
    AppMethodBeat.i(96368);
    Paint localPaint = new Paint();
    c localc = this.wYt;
    int i;
    if (localc.wXQ == -1)
    {
      i = localc.wXR;
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.STROKE);
      localc = this.wYt;
      if (localc.wXU != -1.0F) {
        break label95;
      }
    }
    label95:
    for (float f = localc.wXT;; f = localc.wXU)
    {
      localPaint.setStrokeWidth(f);
      localPaint.setAntiAlias(true);
      AppMethodBeat.o(96368);
      return localPaint;
      i = localc.wXQ;
      break;
    }
  }
  
  private Paint getPaintGridDot()
  {
    AppMethodBeat.i(96370);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYt.wYd);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96370);
    return localPaint;
  }
  
  private Paint getPaintGridFill()
  {
    AppMethodBeat.i(96367);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYt.backgroundColor);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96367);
    return localPaint;
  }
  
  private Paint getPaintGridLatitude()
  {
    AppMethodBeat.i(96369);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYt.wXR);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.wYt.wXT);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96369);
    return localPaint;
  }
  
  private Paint getPaintGridLongitude()
  {
    AppMethodBeat.i(96371);
    Paint localPaint = new Paint();
    localPaint.setColor(this.wYt.wXS);
    localPaint.setStrokeWidth(this.wYt.wXT);
    AppMethodBeat.o(96371);
    return localPaint;
  }
  
  private TextPaint getTextPaintGLabelFont()
  {
    AppMethodBeat.i(96373);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(this.wYt.wXV);
    localTextPaint.setTextSize(this.wYt.wXW);
    AppMethodBeat.o(96373);
    return localTextPaint;
  }
  
  public final int dvF()
  {
    return this.wYA * 2;
  }
  
  public final int dvG()
  {
    return this.wYA * 2;
  }
  
  public c getGridStyle()
  {
    return this.wYt;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96366);
    super.onDraw(paramCanvas);
    int j = getHeight();
    int i = getWidth();
    this.wYA = ((int)(Math.min(j, i) / 2.0F * 0.8D));
    this.wYB.set((int)(i / 2.0F), (int)(j / 2.0F));
    if (this.wYt.wYf != null)
    {
      i = (int)(i / 2.0F);
      j = (int)(j / 2.0F);
      int k = (int)(this.wYA * 2 + this.wYt.wYc * 2.0F);
      int m = this.wYt.wYf.getWidth() * k / this.wYt.wYf.getHeight();
      if (this.wYt.wYf != null) {
        paramCanvas.drawBitmap(Bitmap.createScaledBitmap(this.wYt.wYf, m, k, false), i - (m >>> 1), j - (k >>> 1), null);
      }
    }
    if (this.wYt.wXM) {
      switch (this.wYt.wXL)
      {
      }
    }
    Object localObject;
    while (this.wYt.wXN)
    {
      this.wYE = bq(1.0F);
      i = 0;
      while (i < this.wYp)
      {
        localObject = (PointF)this.wYE.get(i);
        paramCanvas.drawLine(this.wYB.x, this.wYB.y, ((PointF)localObject).x, ((PointF)localObject).y, getPaintGridLongitude());
        i += 1;
      }
      paramCanvas.drawCircle(this.wYB.x, this.wYB.y, this.wYA, getPaintGridFill());
      continue;
      this.wYE = bq(1.0F);
      i = 0;
      if (i < this.wYp)
      {
        localObject = (PointF)this.wYE.get(i);
        if (i == 0) {
          this.uW.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
        for (;;)
        {
          i += 1;
          break;
          this.uW.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      this.uW.close();
      if ((this.wYt.backgroundColor != 0) && (this.wYt.wYf == null)) {
        paramCanvas.drawPath(this.uW, getPaintGridFill());
      }
    }
    if (this.wYt.wXM) {
      switch (this.wYt.wXL)
      {
      }
    }
    float f1;
    label887:
    float f2;
    for (;;)
    {
      if ((this.wYD != null) && (this.wYt.wXP)) {
        if (this.wYD.length != this.wYp)
        {
          paramCanvas = new RuntimeException("Labels array length not matches longitude lines number.");
          AppMethodBeat.o(96366);
          throw paramCanvas;
          paramCanvas.drawCircle(this.wYB.x, this.wYB.y, this.wYA, getPaintGridBorder());
          i = 1;
          while (i < this.wYq)
          {
            paramCanvas.drawCircle(this.wYB.x, this.wYB.y, this.wYA * (i * 1.0F / this.wYq), getPaintGridLatitude());
            i += 1;
          }
          paramCanvas.drawPath(this.uW, getPaintGridBorder());
          this.uW.reset();
          i = 1;
          while (i < this.wYq)
          {
            this.wYE = bq(i * 1.0F / this.wYq);
            j = 0;
            if (j < this.wYp)
            {
              localObject = (PointF)this.wYE.get(j);
              if (j == 0) {
                this.uW.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
              for (;;)
              {
                paramCanvas.drawCircle(((PointF)localObject).x, ((PointF)localObject).y, getGridDotRadius(), getPaintGridDot());
                j += 1;
                break;
                this.uW.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
            }
            this.uW.close();
            paramCanvas.drawPath(this.uW, getPaintGridLatitude());
            this.uW.reset();
            i += 1;
          }
        }
        else
        {
          i = 0;
          if (i < this.wYp)
          {
            localObject = this.wYD[i];
            if (!localObject.equals(null))
            {
              if ((i != 0) && (i != this.wYp >>> 1)) {
                break label1071;
              }
              f1 = 0.5F;
              if (i != 0) {
                break label1097;
              }
              f2 = this.wYt.wXX;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StaticLayout((CharSequence)localObject, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, false);
      f1 = (float)(this.wYB.x - ((StaticLayout)localObject).getLineWidth(0) * f1 - (this.wYA + this.wYt.wXX) * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.wYp));
      f2 = (float)(this.wYB.y - ((StaticLayout)localObject).getHeight() / 2 - (this.wYA + this.wYt.wXX) * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.wYp) - f2);
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      ((StaticLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      i += 1;
      break;
      label1071:
      if ((i > 0) && (i < this.wYp >>> 1))
      {
        f1 = 0.0F;
        break label887;
      }
      f1 = 1.0F;
      break label887;
      label1097:
      if (i == this.wYp >>> 1)
      {
        f2 = -this.wYt.wXX;
        continue;
        AppMethodBeat.o(96366);
      }
      else
      {
        f2 = 0.0F;
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(96381);
    this.wYt.backgroundColor = paramInt;
    invalidate();
    AppMethodBeat.o(96381);
  }
  
  public void setGridBorderColor(int paramInt)
  {
    AppMethodBeat.i(96382);
    this.wYt.wXQ = paramInt;
    invalidate();
    AppMethodBeat.o(96382);
  }
  
  public void setGridBorderStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96386);
    this.wYt.wXU = paramFloat;
    invalidate();
    AppMethodBeat.o(96386);
  }
  
  public void setGridChartType(int paramInt)
  {
    AppMethodBeat.i(96375);
    this.wYt.wXL = paramInt;
    invalidate();
    AppMethodBeat.o(96375);
  }
  
  public void setGridLabelColor(int paramInt)
  {
    AppMethodBeat.i(96387);
    this.wYt.wXV = paramInt;
    invalidate();
    AppMethodBeat.o(96387);
  }
  
  public void setGridLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96389);
    this.wYt.wXX = paramFloat;
    invalidate();
    AppMethodBeat.o(96389);
  }
  
  public void setGridLabelSize(float paramFloat)
  {
    AppMethodBeat.i(96388);
    this.wYt.wXW = paramFloat;
    invalidate();
    AppMethodBeat.o(96388);
  }
  
  public void setGridLatitudeColor(int paramInt)
  {
    AppMethodBeat.i(96383);
    this.wYt.wXR = paramInt;
    invalidate();
    AppMethodBeat.o(96383);
  }
  
  public void setGridLongitudeColor(int paramInt)
  {
    AppMethodBeat.i(96384);
    this.wYt.wXS = paramInt;
    invalidate();
    AppMethodBeat.o(96384);
  }
  
  public void setGridScaleColor(int paramInt)
  {
    AppMethodBeat.i(96390);
    this.wYt.wXY = paramInt;
    invalidate();
    AppMethodBeat.o(96390);
  }
  
  public void setGridScaleLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96392);
    this.wYt.wYa = paramFloat;
    invalidate();
    AppMethodBeat.o(96392);
  }
  
  public void setGridScaleSize(float paramFloat)
  {
    AppMethodBeat.i(96391);
    this.wYt.wXZ = paramFloat;
    invalidate();
    AppMethodBeat.o(96391);
  }
  
  public void setGridStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96385);
    this.wYt.wXT = paramFloat;
    invalidate();
    AppMethodBeat.o(96385);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96380);
    this.wYt = paramc;
    invalidate();
    AppMethodBeat.o(96380);
  }
  
  public void setLabelsArray(Spannable[] paramArrayOfSpannable)
  {
    AppMethodBeat.i(96379);
    this.wYD = paramArrayOfSpannable;
    invalidate();
    AppMethodBeat.o(96379);
  }
  
  public void setLatNum(int paramInt)
  {
    AppMethodBeat.i(96377);
    this.wYq = paramInt;
    invalidate();
    AppMethodBeat.o(96377);
  }
  
  public void setLonNum(int paramInt)
  {
    AppMethodBeat.i(96376);
    this.wYp = paramInt;
    invalidate();
    AppMethodBeat.o(96376);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96378);
    this.wYs = paramFloat;
    invalidate();
    AppMethodBeat.o(96378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid
 * JD-Core Version:    0.7.0.1
 */