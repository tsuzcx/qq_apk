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
  public static final Point zSZ;
  private Rect mRect;
  private Path xN;
  private int zSU;
  private int zSV;
  private float zSX;
  private c zSY;
  private int zTf;
  private Point zTg;
  private Spannable[] zTi;
  private List<PointF> zTj;
  
  static
  {
    AppMethodBeat.i(96393);
    zSZ = new Point(0, 0);
    AppMethodBeat.o(96393);
  }
  
  public RadarGrid(Context paramContext, int paramInt1, int paramInt2, float paramFloat, Spannable[] paramArrayOfSpannable, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(96363);
    this.zSU = 4;
    this.zSV = 4;
    this.zSX = 1.0F;
    this.zTf = 80;
    this.zTg = zSZ;
    this.xN = new Path();
    this.mRect = new Rect();
    this.zSX = paramFloat;
    this.zSU = paramInt1;
    this.zSV = paramInt2;
    this.zSX = paramFloat;
    this.zTi = paramArrayOfSpannable;
    this.zSY = paramc;
    AppMethodBeat.o(96363);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96361);
    this.zSU = 4;
    this.zSV = 4;
    this.zSX = 1.0F;
    this.zTf = 80;
    this.zTg = zSZ;
    this.xN = new Path();
    this.mRect = new Rect();
    dZX();
    AppMethodBeat.o(96361);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96362);
    this.zSU = 4;
    this.zSV = 4;
    this.zSX = 1.0F;
    this.zTf = 80;
    this.zTg = zSZ;
    this.xN = new Path();
    this.mRect = new Rect();
    dZX();
    AppMethodBeat.o(96362);
  }
  
  private List<PointF> bz(float paramFloat)
  {
    AppMethodBeat.i(96365);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.zSU)
    {
      PointF localPointF = new PointF();
      localPointF.set((float)(this.zTg.x - this.zTf * paramFloat * Math.sin(i * 2 * 3.141592653589793D / this.zSU)), (float)(this.zTg.y - this.zTf * paramFloat * Math.cos(i * 2 * 3.141592653589793D / this.zSU)));
      localArrayList.add(localPointF);
      i += 1;
    }
    AppMethodBeat.o(96365);
    return localArrayList;
  }
  
  private void dZX()
  {
    AppMethodBeat.i(96364);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(96364);
  }
  
  private int getGridDotRadius()
  {
    return this.zSY.zSJ;
  }
  
  private Paint getPaintGLabelFont()
  {
    AppMethodBeat.i(96372);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zSY.zSA);
    localPaint.setTextSize(this.zSY.zSB);
    AppMethodBeat.o(96372);
    return localPaint;
  }
  
  private Paint getPaintGScaleFont()
  {
    AppMethodBeat.i(96374);
    Paint localPaint = new Paint();
    c localc = this.zSY;
    if (localc.zSD == -1) {}
    for (int i = localc.zSA;; i = localc.zSD)
    {
      localPaint.setColor(i);
      localPaint.setTextSize(this.zSY.zSE);
      AppMethodBeat.o(96374);
      return localPaint;
    }
  }
  
  private Paint getPaintGridBorder()
  {
    AppMethodBeat.i(96368);
    Paint localPaint = new Paint();
    c localc = this.zSY;
    int i;
    if (localc.zSv == -1)
    {
      i = localc.zSw;
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.STROKE);
      localc = this.zSY;
      if (localc.zSz != -1.0F) {
        break label95;
      }
    }
    label95:
    for (float f = localc.zSy;; f = localc.zSz)
    {
      localPaint.setStrokeWidth(f);
      localPaint.setAntiAlias(true);
      AppMethodBeat.o(96368);
      return localPaint;
      i = localc.zSv;
      break;
    }
  }
  
  private Paint getPaintGridDot()
  {
    AppMethodBeat.i(96370);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zSY.zSI);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96370);
    return localPaint;
  }
  
  private Paint getPaintGridFill()
  {
    AppMethodBeat.i(96367);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zSY.backgroundColor);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96367);
    return localPaint;
  }
  
  private Paint getPaintGridLatitude()
  {
    AppMethodBeat.i(96369);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zSY.zSw);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.zSY.zSy);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96369);
    return localPaint;
  }
  
  private Paint getPaintGridLongitude()
  {
    AppMethodBeat.i(96371);
    Paint localPaint = new Paint();
    localPaint.setColor(this.zSY.zSx);
    localPaint.setStrokeWidth(this.zSY.zSy);
    AppMethodBeat.o(96371);
    return localPaint;
  }
  
  private TextPaint getTextPaintGLabelFont()
  {
    AppMethodBeat.i(96373);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(this.zSY.zSA);
    localTextPaint.setTextSize(this.zSY.zSB);
    AppMethodBeat.o(96373);
    return localTextPaint;
  }
  
  public final int dZU()
  {
    return this.zTf * 2;
  }
  
  public final int dZV()
  {
    return this.zTf * 2;
  }
  
  public c getGridStyle()
  {
    return this.zSY;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96366);
    super.onDraw(paramCanvas);
    int j = getHeight();
    int i = getWidth();
    this.zTf = ((int)(Math.min(j, i) / 2.0F * 0.8D));
    this.zTg.set((int)(i / 2.0F), (int)(j / 2.0F));
    if (this.zSY.zSK != null)
    {
      i = (int)(i / 2.0F);
      j = (int)(j / 2.0F);
      int k = (int)(this.zTf * 2 + this.zSY.zSH * 2.0F);
      int m = this.zSY.zSK.getWidth() * k / this.zSY.zSK.getHeight();
      if (this.zSY.zSK != null) {
        paramCanvas.drawBitmap(Bitmap.createScaledBitmap(this.zSY.zSK, m, k, false), i - (m >>> 1), j - (k >>> 1), null);
      }
    }
    if (this.zSY.zSr) {
      switch (this.zSY.zSq)
      {
      }
    }
    Object localObject;
    while (this.zSY.zSs)
    {
      this.zTj = bz(1.0F);
      i = 0;
      while (i < this.zSU)
      {
        localObject = (PointF)this.zTj.get(i);
        paramCanvas.drawLine(this.zTg.x, this.zTg.y, ((PointF)localObject).x, ((PointF)localObject).y, getPaintGridLongitude());
        i += 1;
      }
      paramCanvas.drawCircle(this.zTg.x, this.zTg.y, this.zTf, getPaintGridFill());
      continue;
      this.zTj = bz(1.0F);
      i = 0;
      if (i < this.zSU)
      {
        localObject = (PointF)this.zTj.get(i);
        if (i == 0) {
          this.xN.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
        for (;;)
        {
          i += 1;
          break;
          this.xN.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      this.xN.close();
      if ((this.zSY.backgroundColor != 0) && (this.zSY.zSK == null)) {
        paramCanvas.drawPath(this.xN, getPaintGridFill());
      }
    }
    if (this.zSY.zSr) {
      switch (this.zSY.zSq)
      {
      }
    }
    float f1;
    label887:
    float f2;
    for (;;)
    {
      if ((this.zTi != null) && (this.zSY.zSu)) {
        if (this.zTi.length != this.zSU)
        {
          paramCanvas = new RuntimeException("Labels array length not matches longitude lines number.");
          AppMethodBeat.o(96366);
          throw paramCanvas;
          paramCanvas.drawCircle(this.zTg.x, this.zTg.y, this.zTf, getPaintGridBorder());
          i = 1;
          while (i < this.zSV)
          {
            paramCanvas.drawCircle(this.zTg.x, this.zTg.y, this.zTf * (i * 1.0F / this.zSV), getPaintGridLatitude());
            i += 1;
          }
          paramCanvas.drawPath(this.xN, getPaintGridBorder());
          this.xN.reset();
          i = 1;
          while (i < this.zSV)
          {
            this.zTj = bz(i * 1.0F / this.zSV);
            j = 0;
            if (j < this.zSU)
            {
              localObject = (PointF)this.zTj.get(j);
              if (j == 0) {
                this.xN.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
              for (;;)
              {
                paramCanvas.drawCircle(((PointF)localObject).x, ((PointF)localObject).y, getGridDotRadius(), getPaintGridDot());
                j += 1;
                break;
                this.xN.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
            }
            this.xN.close();
            paramCanvas.drawPath(this.xN, getPaintGridLatitude());
            this.xN.reset();
            i += 1;
          }
        }
        else
        {
          i = 0;
          if (i < this.zSU)
          {
            localObject = this.zTi[i];
            if (!localObject.equals(null))
            {
              if ((i != 0) && (i != this.zSU >>> 1)) {
                break label1071;
              }
              f1 = 0.5F;
              if (i != 0) {
                break label1097;
              }
              f2 = this.zSY.zSC;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StaticLayout((CharSequence)localObject, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, false);
      f1 = (float)(this.zTg.x - ((StaticLayout)localObject).getLineWidth(0) * f1 - (this.zTf + this.zSY.zSC) * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.zSU));
      f2 = (float)(this.zTg.y - ((StaticLayout)localObject).getHeight() / 2 - (this.zTf + this.zSY.zSC) * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.zSU) - f2);
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      ((StaticLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      i += 1;
      break;
      label1071:
      if ((i > 0) && (i < this.zSU >>> 1))
      {
        f1 = 0.0F;
        break label887;
      }
      f1 = 1.0F;
      break label887;
      label1097:
      if (i == this.zSU >>> 1)
      {
        f2 = -this.zSY.zSC;
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
    this.zSY.backgroundColor = paramInt;
    invalidate();
    AppMethodBeat.o(96381);
  }
  
  public void setGridBorderColor(int paramInt)
  {
    AppMethodBeat.i(96382);
    this.zSY.zSv = paramInt;
    invalidate();
    AppMethodBeat.o(96382);
  }
  
  public void setGridBorderStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96386);
    this.zSY.zSz = paramFloat;
    invalidate();
    AppMethodBeat.o(96386);
  }
  
  public void setGridChartType(int paramInt)
  {
    AppMethodBeat.i(96375);
    this.zSY.zSq = paramInt;
    invalidate();
    AppMethodBeat.o(96375);
  }
  
  public void setGridLabelColor(int paramInt)
  {
    AppMethodBeat.i(96387);
    this.zSY.zSA = paramInt;
    invalidate();
    AppMethodBeat.o(96387);
  }
  
  public void setGridLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96389);
    this.zSY.zSC = paramFloat;
    invalidate();
    AppMethodBeat.o(96389);
  }
  
  public void setGridLabelSize(float paramFloat)
  {
    AppMethodBeat.i(96388);
    this.zSY.zSB = paramFloat;
    invalidate();
    AppMethodBeat.o(96388);
  }
  
  public void setGridLatitudeColor(int paramInt)
  {
    AppMethodBeat.i(96383);
    this.zSY.zSw = paramInt;
    invalidate();
    AppMethodBeat.o(96383);
  }
  
  public void setGridLongitudeColor(int paramInt)
  {
    AppMethodBeat.i(96384);
    this.zSY.zSx = paramInt;
    invalidate();
    AppMethodBeat.o(96384);
  }
  
  public void setGridScaleColor(int paramInt)
  {
    AppMethodBeat.i(96390);
    this.zSY.zSD = paramInt;
    invalidate();
    AppMethodBeat.o(96390);
  }
  
  public void setGridScaleLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96392);
    this.zSY.zSF = paramFloat;
    invalidate();
    AppMethodBeat.o(96392);
  }
  
  public void setGridScaleSize(float paramFloat)
  {
    AppMethodBeat.i(96391);
    this.zSY.zSE = paramFloat;
    invalidate();
    AppMethodBeat.o(96391);
  }
  
  public void setGridStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96385);
    this.zSY.zSy = paramFloat;
    invalidate();
    AppMethodBeat.o(96385);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96380);
    this.zSY = paramc;
    invalidate();
    AppMethodBeat.o(96380);
  }
  
  public void setLabelsArray(Spannable[] paramArrayOfSpannable)
  {
    AppMethodBeat.i(96379);
    this.zTi = paramArrayOfSpannable;
    invalidate();
    AppMethodBeat.o(96379);
  }
  
  public void setLatNum(int paramInt)
  {
    AppMethodBeat.i(96377);
    this.zSV = paramInt;
    invalidate();
    AppMethodBeat.o(96377);
  }
  
  public void setLonNum(int paramInt)
  {
    AppMethodBeat.i(96376);
    this.zSU = paramInt;
    invalidate();
    AppMethodBeat.o(96376);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96378);
    this.zSX = paramFloat;
    invalidate();
    AppMethodBeat.o(96378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid
 * JD-Core Version:    0.7.0.1
 */