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
  public static final Point QMK;
  private int QMG;
  private int QMH;
  private c QMJ;
  private int QMQ;
  private Point QMR;
  private Spannable[] QMT;
  private List<PointF> QMU;
  private Path cja;
  private Rect mRect;
  private float maxValue;
  
  static
  {
    AppMethodBeat.i(96393);
    QMK = new Point(0, 0);
    AppMethodBeat.o(96393);
  }
  
  public RadarGrid(Context paramContext, int paramInt1, int paramInt2, float paramFloat, Spannable[] paramArrayOfSpannable, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(96363);
    this.QMG = 4;
    this.QMH = 4;
    this.maxValue = 1.0F;
    this.QMQ = 80;
    this.QMR = QMK;
    this.cja = new Path();
    this.mRect = new Rect();
    this.maxValue = paramFloat;
    this.QMG = paramInt1;
    this.QMH = paramInt2;
    this.maxValue = paramFloat;
    this.QMT = paramArrayOfSpannable;
    this.QMJ = paramc;
    AppMethodBeat.o(96363);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96361);
    this.QMG = 4;
    this.QMH = 4;
    this.maxValue = 1.0F;
    this.QMQ = 80;
    this.QMR = QMK;
    this.cja = new Path();
    this.mRect = new Rect();
    ghu();
    AppMethodBeat.o(96361);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96362);
    this.QMG = 4;
    this.QMH = 4;
    this.maxValue = 1.0F;
    this.QMQ = 80;
    this.QMR = QMK;
    this.cja = new Path();
    this.mRect = new Rect();
    ghu();
    AppMethodBeat.o(96362);
  }
  
  private List<PointF> dk(float paramFloat)
  {
    AppMethodBeat.i(96365);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.QMG)
    {
      PointF localPointF = new PointF();
      localPointF.set((float)(this.QMR.x - this.QMQ * paramFloat * Math.sin(i * 2 * 3.141592653589793D / this.QMG)), (float)(this.QMR.y - this.QMQ * paramFloat * Math.cos(i * 2 * 3.141592653589793D / this.QMG)));
      localArrayList.add(localPointF);
      i += 1;
    }
    AppMethodBeat.o(96365);
    return localArrayList;
  }
  
  private int getGridDotRadius()
  {
    return this.QMJ.QMv;
  }
  
  private Paint getPaintGLabelFont()
  {
    AppMethodBeat.i(96372);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMJ.QMm);
    localPaint.setTextSize(this.QMJ.QMn);
    AppMethodBeat.o(96372);
    return localPaint;
  }
  
  private Paint getPaintGScaleFont()
  {
    AppMethodBeat.i(96374);
    Paint localPaint = new Paint();
    c localc = this.QMJ;
    if (localc.QMp == -1) {}
    for (int i = localc.QMm;; i = localc.QMp)
    {
      localPaint.setColor(i);
      localPaint.setTextSize(this.QMJ.QMq);
      AppMethodBeat.o(96374);
      return localPaint;
    }
  }
  
  private Paint getPaintGridBorder()
  {
    AppMethodBeat.i(96368);
    Paint localPaint = new Paint();
    c localc = this.QMJ;
    int i;
    if (localc.QMh == -1)
    {
      i = localc.QMi;
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.STROKE);
      localc = this.QMJ;
      if (localc.QMl != -1.0F) {
        break label95;
      }
    }
    label95:
    for (float f = localc.QMk;; f = localc.QMl)
    {
      localPaint.setStrokeWidth(f);
      localPaint.setAntiAlias(true);
      AppMethodBeat.o(96368);
      return localPaint;
      i = localc.QMh;
      break;
    }
  }
  
  private Paint getPaintGridDot()
  {
    AppMethodBeat.i(96370);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMJ.QMu);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96370);
    return localPaint;
  }
  
  private Paint getPaintGridFill()
  {
    AppMethodBeat.i(96367);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMJ.backgroundColor);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96367);
    return localPaint;
  }
  
  private Paint getPaintGridLatitude()
  {
    AppMethodBeat.i(96369);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMJ.QMi);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.QMJ.QMk);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96369);
    return localPaint;
  }
  
  private Paint getPaintGridLongitude()
  {
    AppMethodBeat.i(96371);
    Paint localPaint = new Paint();
    localPaint.setColor(this.QMJ.QMj);
    localPaint.setStrokeWidth(this.QMJ.QMk);
    AppMethodBeat.o(96371);
    return localPaint;
  }
  
  private TextPaint getTextPaintGLabelFont()
  {
    AppMethodBeat.i(96373);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(this.QMJ.QMm);
    localTextPaint.setTextSize(this.QMJ.QMn);
    AppMethodBeat.o(96373);
    return localTextPaint;
  }
  
  private void ghu()
  {
    AppMethodBeat.i(96364);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(96364);
  }
  
  public c getGridStyle()
  {
    return this.QMJ;
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
    AppMethodBeat.i(96366);
    super.onDraw(paramCanvas);
    int j = getHeight();
    int i = getWidth();
    this.QMQ = ((int)(Math.min(j, i) / 2.0F * 0.8D));
    this.QMR.set((int)(i / 2.0F), (int)(j / 2.0F));
    if (this.QMJ.QMw != null)
    {
      i = (int)(i / 2.0F);
      j = (int)(j / 2.0F);
      int k = (int)(this.QMQ * 2 + this.QMJ.QMt * 2.0F);
      int m = this.QMJ.QMw.getWidth() * k / this.QMJ.QMw.getHeight();
      if (this.QMJ.QMw != null) {
        paramCanvas.drawBitmap(Bitmap.createScaledBitmap(this.QMJ.QMw, m, k, false), i - (m >>> 1), j - (k >>> 1), null);
      }
    }
    if (this.QMJ.QMd) {
      switch (this.QMJ.QMc)
      {
      }
    }
    Object localObject;
    while (this.QMJ.QMe)
    {
      this.QMU = dk(1.0F);
      i = 0;
      while (i < this.QMG)
      {
        localObject = (PointF)this.QMU.get(i);
        paramCanvas.drawLine(this.QMR.x, this.QMR.y, ((PointF)localObject).x, ((PointF)localObject).y, getPaintGridLongitude());
        i += 1;
      }
      paramCanvas.drawCircle(this.QMR.x, this.QMR.y, this.QMQ, getPaintGridFill());
      continue;
      this.QMU = dk(1.0F);
      i = 0;
      if (i < this.QMG)
      {
        localObject = (PointF)this.QMU.get(i);
        if (i == 0) {
          this.cja.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
        for (;;)
        {
          i += 1;
          break;
          this.cja.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      this.cja.close();
      if ((this.QMJ.backgroundColor != 0) && (this.QMJ.QMw == null)) {
        paramCanvas.drawPath(this.cja, getPaintGridFill());
      }
    }
    if (this.QMJ.QMd) {
      switch (this.QMJ.QMc)
      {
      }
    }
    float f1;
    label887:
    float f2;
    for (;;)
    {
      if ((this.QMT != null) && (this.QMJ.QMg)) {
        if (this.QMT.length != this.QMG)
        {
          paramCanvas = new RuntimeException("Labels array length not matches longitude lines number.");
          AppMethodBeat.o(96366);
          throw paramCanvas;
          paramCanvas.drawCircle(this.QMR.x, this.QMR.y, this.QMQ, getPaintGridBorder());
          i = 1;
          while (i < this.QMH)
          {
            paramCanvas.drawCircle(this.QMR.x, this.QMR.y, this.QMQ * (i * 1.0F / this.QMH), getPaintGridLatitude());
            i += 1;
          }
          paramCanvas.drawPath(this.cja, getPaintGridBorder());
          this.cja.reset();
          i = 1;
          while (i < this.QMH)
          {
            this.QMU = dk(i * 1.0F / this.QMH);
            j = 0;
            if (j < this.QMG)
            {
              localObject = (PointF)this.QMU.get(j);
              if (j == 0) {
                this.cja.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
              for (;;)
              {
                paramCanvas.drawCircle(((PointF)localObject).x, ((PointF)localObject).y, getGridDotRadius(), getPaintGridDot());
                j += 1;
                break;
                this.cja.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
            }
            this.cja.close();
            paramCanvas.drawPath(this.cja, getPaintGridLatitude());
            this.cja.reset();
            i += 1;
          }
        }
        else
        {
          i = 0;
          if (i < this.QMG)
          {
            localObject = this.QMT[i];
            if (!localObject.equals(null))
            {
              if ((i != 0) && (i != this.QMG >>> 1)) {
                break label1071;
              }
              f1 = 0.5F;
              if (i != 0) {
                break label1097;
              }
              f2 = this.QMJ.QMo;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StaticLayout((CharSequence)localObject, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, false);
      f1 = (float)(this.QMR.x - ((StaticLayout)localObject).getLineWidth(0) * f1 - (this.QMQ + this.QMJ.QMo) * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.QMG));
      f2 = (float)(this.QMR.y - ((StaticLayout)localObject).getHeight() / 2 - (this.QMQ + this.QMJ.QMo) * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.QMG) - f2);
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      ((StaticLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      i += 1;
      break;
      label1071:
      if ((i > 0) && (i < this.QMG >>> 1))
      {
        f1 = 0.0F;
        break label887;
      }
      f1 = 1.0F;
      break label887;
      label1097:
      if (i == this.QMG >>> 1)
      {
        f2 = -this.QMJ.QMo;
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
    this.QMJ.backgroundColor = paramInt;
    invalidate();
    AppMethodBeat.o(96381);
  }
  
  public void setGridBorderColor(int paramInt)
  {
    AppMethodBeat.i(96382);
    this.QMJ.QMh = paramInt;
    invalidate();
    AppMethodBeat.o(96382);
  }
  
  public void setGridBorderStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96386);
    this.QMJ.QMl = paramFloat;
    invalidate();
    AppMethodBeat.o(96386);
  }
  
  public void setGridChartType(int paramInt)
  {
    AppMethodBeat.i(96375);
    this.QMJ.QMc = paramInt;
    invalidate();
    AppMethodBeat.o(96375);
  }
  
  public void setGridLabelColor(int paramInt)
  {
    AppMethodBeat.i(96387);
    this.QMJ.QMm = paramInt;
    invalidate();
    AppMethodBeat.o(96387);
  }
  
  public void setGridLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96389);
    this.QMJ.QMo = paramFloat;
    invalidate();
    AppMethodBeat.o(96389);
  }
  
  public void setGridLabelSize(float paramFloat)
  {
    AppMethodBeat.i(96388);
    this.QMJ.QMn = paramFloat;
    invalidate();
    AppMethodBeat.o(96388);
  }
  
  public void setGridLatitudeColor(int paramInt)
  {
    AppMethodBeat.i(96383);
    this.QMJ.QMi = paramInt;
    invalidate();
    AppMethodBeat.o(96383);
  }
  
  public void setGridLongitudeColor(int paramInt)
  {
    AppMethodBeat.i(96384);
    this.QMJ.QMj = paramInt;
    invalidate();
    AppMethodBeat.o(96384);
  }
  
  public void setGridScaleColor(int paramInt)
  {
    AppMethodBeat.i(96390);
    this.QMJ.QMp = paramInt;
    invalidate();
    AppMethodBeat.o(96390);
  }
  
  public void setGridScaleLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96392);
    this.QMJ.QMr = paramFloat;
    invalidate();
    AppMethodBeat.o(96392);
  }
  
  public void setGridScaleSize(float paramFloat)
  {
    AppMethodBeat.i(96391);
    this.QMJ.QMq = paramFloat;
    invalidate();
    AppMethodBeat.o(96391);
  }
  
  public void setGridStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96385);
    this.QMJ.QMk = paramFloat;
    invalidate();
    AppMethodBeat.o(96385);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96380);
    this.QMJ = paramc;
    invalidate();
    AppMethodBeat.o(96380);
  }
  
  public void setLabelsArray(Spannable[] paramArrayOfSpannable)
  {
    AppMethodBeat.i(96379);
    this.QMT = paramArrayOfSpannable;
    invalidate();
    AppMethodBeat.o(96379);
  }
  
  public void setLatNum(int paramInt)
  {
    AppMethodBeat.i(96377);
    this.QMH = paramInt;
    invalidate();
    AppMethodBeat.o(96377);
  }
  
  public void setLonNum(int paramInt)
  {
    AppMethodBeat.i(96376);
    this.QMG = paramInt;
    invalidate();
    AppMethodBeat.o(96376);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96378);
    this.maxValue = paramFloat;
    invalidate();
    AppMethodBeat.o(96378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid
 * JD-Core Version:    0.7.0.1
 */