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
  public static final Point KoD;
  private int KoA;
  private c KoC;
  private int KoJ;
  private Point KoK;
  private Spannable[] KoM;
  private List<PointF> KoN;
  private int Koz;
  private Path auD;
  private Rect mRect;
  private float maxValue;
  
  static
  {
    AppMethodBeat.i(96393);
    KoD = new Point(0, 0);
    AppMethodBeat.o(96393);
  }
  
  public RadarGrid(Context paramContext, int paramInt1, int paramInt2, float paramFloat, Spannable[] paramArrayOfSpannable, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(96363);
    this.Koz = 4;
    this.KoA = 4;
    this.maxValue = 1.0F;
    this.KoJ = 80;
    this.KoK = KoD;
    this.auD = new Path();
    this.mRect = new Rect();
    this.maxValue = paramFloat;
    this.Koz = paramInt1;
    this.KoA = paramInt2;
    this.maxValue = paramFloat;
    this.KoM = paramArrayOfSpannable;
    this.KoC = paramc;
    AppMethodBeat.o(96363);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96361);
    this.Koz = 4;
    this.KoA = 4;
    this.maxValue = 1.0F;
    this.KoJ = 80;
    this.KoK = KoD;
    this.auD = new Path();
    this.mRect = new Rect();
    eYz();
    AppMethodBeat.o(96361);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96362);
    this.Koz = 4;
    this.KoA = 4;
    this.maxValue = 1.0F;
    this.KoJ = 80;
    this.KoK = KoD;
    this.auD = new Path();
    this.mRect = new Rect();
    eYz();
    AppMethodBeat.o(96362);
  }
  
  private List<PointF> cb(float paramFloat)
  {
    AppMethodBeat.i(96365);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.Koz)
    {
      PointF localPointF = new PointF();
      localPointF.set((float)(this.KoK.x - this.KoJ * paramFloat * Math.sin(i * 2 * 3.141592653589793D / this.Koz)), (float)(this.KoK.y - this.KoJ * paramFloat * Math.cos(i * 2 * 3.141592653589793D / this.Koz)));
      localArrayList.add(localPointF);
      i += 1;
    }
    AppMethodBeat.o(96365);
    return localArrayList;
  }
  
  private void eYz()
  {
    AppMethodBeat.i(96364);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(96364);
  }
  
  private int getGridDotRadius()
  {
    return this.KoC.Koo;
  }
  
  private Paint getPaintGLabelFont()
  {
    AppMethodBeat.i(96372);
    Paint localPaint = new Paint();
    localPaint.setColor(this.KoC.Kof);
    localPaint.setTextSize(this.KoC.Kog);
    AppMethodBeat.o(96372);
    return localPaint;
  }
  
  private Paint getPaintGScaleFont()
  {
    AppMethodBeat.i(96374);
    Paint localPaint = new Paint();
    c localc = this.KoC;
    if (localc.Koi == -1) {}
    for (int i = localc.Kof;; i = localc.Koi)
    {
      localPaint.setColor(i);
      localPaint.setTextSize(this.KoC.Koj);
      AppMethodBeat.o(96374);
      return localPaint;
    }
  }
  
  private Paint getPaintGridBorder()
  {
    AppMethodBeat.i(96368);
    Paint localPaint = new Paint();
    c localc = this.KoC;
    int i;
    if (localc.Koa == -1)
    {
      i = localc.Kob;
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.STROKE);
      localc = this.KoC;
      if (localc.Koe != -1.0F) {
        break label95;
      }
    }
    label95:
    for (float f = localc.Kod;; f = localc.Koe)
    {
      localPaint.setStrokeWidth(f);
      localPaint.setAntiAlias(true);
      AppMethodBeat.o(96368);
      return localPaint;
      i = localc.Koa;
      break;
    }
  }
  
  private Paint getPaintGridDot()
  {
    AppMethodBeat.i(96370);
    Paint localPaint = new Paint();
    localPaint.setColor(this.KoC.Kon);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96370);
    return localPaint;
  }
  
  private Paint getPaintGridFill()
  {
    AppMethodBeat.i(96367);
    Paint localPaint = new Paint();
    localPaint.setColor(this.KoC.backgroundColor);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96367);
    return localPaint;
  }
  
  private Paint getPaintGridLatitude()
  {
    AppMethodBeat.i(96369);
    Paint localPaint = new Paint();
    localPaint.setColor(this.KoC.Kob);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.KoC.Kod);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96369);
    return localPaint;
  }
  
  private Paint getPaintGridLongitude()
  {
    AppMethodBeat.i(96371);
    Paint localPaint = new Paint();
    localPaint.setColor(this.KoC.Koc);
    localPaint.setStrokeWidth(this.KoC.Kod);
    AppMethodBeat.o(96371);
    return localPaint;
  }
  
  private TextPaint getTextPaintGLabelFont()
  {
    AppMethodBeat.i(96373);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(this.KoC.Kof);
    localTextPaint.setTextSize(this.KoC.Kog);
    AppMethodBeat.o(96373);
    return localTextPaint;
  }
  
  public final int fQG()
  {
    return this.KoJ * 2;
  }
  
  public final int fQH()
  {
    return this.KoJ * 2;
  }
  
  public c getGridStyle()
  {
    return this.KoC;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96366);
    super.onDraw(paramCanvas);
    int j = getHeight();
    int i = getWidth();
    this.KoJ = ((int)(Math.min(j, i) / 2.0F * 0.8D));
    this.KoK.set((int)(i / 2.0F), (int)(j / 2.0F));
    if (this.KoC.Kop != null)
    {
      i = (int)(i / 2.0F);
      j = (int)(j / 2.0F);
      int k = (int)(this.KoJ * 2 + this.KoC.Kom * 2.0F);
      int m = this.KoC.Kop.getWidth() * k / this.KoC.Kop.getHeight();
      if (this.KoC.Kop != null) {
        paramCanvas.drawBitmap(Bitmap.createScaledBitmap(this.KoC.Kop, m, k, false), i - (m >>> 1), j - (k >>> 1), null);
      }
    }
    if (this.KoC.KnW) {
      switch (this.KoC.KnV)
      {
      }
    }
    Object localObject;
    while (this.KoC.KnX)
    {
      this.KoN = cb(1.0F);
      i = 0;
      while (i < this.Koz)
      {
        localObject = (PointF)this.KoN.get(i);
        paramCanvas.drawLine(this.KoK.x, this.KoK.y, ((PointF)localObject).x, ((PointF)localObject).y, getPaintGridLongitude());
        i += 1;
      }
      paramCanvas.drawCircle(this.KoK.x, this.KoK.y, this.KoJ, getPaintGridFill());
      continue;
      this.KoN = cb(1.0F);
      i = 0;
      if (i < this.Koz)
      {
        localObject = (PointF)this.KoN.get(i);
        if (i == 0) {
          this.auD.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
        for (;;)
        {
          i += 1;
          break;
          this.auD.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      this.auD.close();
      if ((this.KoC.backgroundColor != 0) && (this.KoC.Kop == null)) {
        paramCanvas.drawPath(this.auD, getPaintGridFill());
      }
    }
    if (this.KoC.KnW) {
      switch (this.KoC.KnV)
      {
      }
    }
    float f1;
    label887:
    float f2;
    for (;;)
    {
      if ((this.KoM != null) && (this.KoC.KnZ)) {
        if (this.KoM.length != this.Koz)
        {
          paramCanvas = new RuntimeException("Labels array length not matches longitude lines number.");
          AppMethodBeat.o(96366);
          throw paramCanvas;
          paramCanvas.drawCircle(this.KoK.x, this.KoK.y, this.KoJ, getPaintGridBorder());
          i = 1;
          while (i < this.KoA)
          {
            paramCanvas.drawCircle(this.KoK.x, this.KoK.y, this.KoJ * (i * 1.0F / this.KoA), getPaintGridLatitude());
            i += 1;
          }
          paramCanvas.drawPath(this.auD, getPaintGridBorder());
          this.auD.reset();
          i = 1;
          while (i < this.KoA)
          {
            this.KoN = cb(i * 1.0F / this.KoA);
            j = 0;
            if (j < this.Koz)
            {
              localObject = (PointF)this.KoN.get(j);
              if (j == 0) {
                this.auD.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
              for (;;)
              {
                paramCanvas.drawCircle(((PointF)localObject).x, ((PointF)localObject).y, getGridDotRadius(), getPaintGridDot());
                j += 1;
                break;
                this.auD.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
            }
            this.auD.close();
            paramCanvas.drawPath(this.auD, getPaintGridLatitude());
            this.auD.reset();
            i += 1;
          }
        }
        else
        {
          i = 0;
          if (i < this.Koz)
          {
            localObject = this.KoM[i];
            if (!localObject.equals(null))
            {
              if ((i != 0) && (i != this.Koz >>> 1)) {
                break label1071;
              }
              f1 = 0.5F;
              if (i != 0) {
                break label1097;
              }
              f2 = this.KoC.Koh;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StaticLayout((CharSequence)localObject, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, false);
      f1 = (float)(this.KoK.x - ((StaticLayout)localObject).getLineWidth(0) * f1 - (this.KoJ + this.KoC.Koh) * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.Koz));
      f2 = (float)(this.KoK.y - ((StaticLayout)localObject).getHeight() / 2 - (this.KoJ + this.KoC.Koh) * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.Koz) - f2);
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      ((StaticLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      i += 1;
      break;
      label1071:
      if ((i > 0) && (i < this.Koz >>> 1))
      {
        f1 = 0.0F;
        break label887;
      }
      f1 = 1.0F;
      break label887;
      label1097:
      if (i == this.Koz >>> 1)
      {
        f2 = -this.KoC.Koh;
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
    this.KoC.backgroundColor = paramInt;
    invalidate();
    AppMethodBeat.o(96381);
  }
  
  public void setGridBorderColor(int paramInt)
  {
    AppMethodBeat.i(96382);
    this.KoC.Koa = paramInt;
    invalidate();
    AppMethodBeat.o(96382);
  }
  
  public void setGridBorderStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96386);
    this.KoC.Koe = paramFloat;
    invalidate();
    AppMethodBeat.o(96386);
  }
  
  public void setGridChartType(int paramInt)
  {
    AppMethodBeat.i(96375);
    this.KoC.KnV = paramInt;
    invalidate();
    AppMethodBeat.o(96375);
  }
  
  public void setGridLabelColor(int paramInt)
  {
    AppMethodBeat.i(96387);
    this.KoC.Kof = paramInt;
    invalidate();
    AppMethodBeat.o(96387);
  }
  
  public void setGridLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96389);
    this.KoC.Koh = paramFloat;
    invalidate();
    AppMethodBeat.o(96389);
  }
  
  public void setGridLabelSize(float paramFloat)
  {
    AppMethodBeat.i(96388);
    this.KoC.Kog = paramFloat;
    invalidate();
    AppMethodBeat.o(96388);
  }
  
  public void setGridLatitudeColor(int paramInt)
  {
    AppMethodBeat.i(96383);
    this.KoC.Kob = paramInt;
    invalidate();
    AppMethodBeat.o(96383);
  }
  
  public void setGridLongitudeColor(int paramInt)
  {
    AppMethodBeat.i(96384);
    this.KoC.Koc = paramInt;
    invalidate();
    AppMethodBeat.o(96384);
  }
  
  public void setGridScaleColor(int paramInt)
  {
    AppMethodBeat.i(96390);
    this.KoC.Koi = paramInt;
    invalidate();
    AppMethodBeat.o(96390);
  }
  
  public void setGridScaleLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96392);
    this.KoC.Kok = paramFloat;
    invalidate();
    AppMethodBeat.o(96392);
  }
  
  public void setGridScaleSize(float paramFloat)
  {
    AppMethodBeat.i(96391);
    this.KoC.Koj = paramFloat;
    invalidate();
    AppMethodBeat.o(96391);
  }
  
  public void setGridStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96385);
    this.KoC.Kod = paramFloat;
    invalidate();
    AppMethodBeat.o(96385);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96380);
    this.KoC = paramc;
    invalidate();
    AppMethodBeat.o(96380);
  }
  
  public void setLabelsArray(Spannable[] paramArrayOfSpannable)
  {
    AppMethodBeat.i(96379);
    this.KoM = paramArrayOfSpannable;
    invalidate();
    AppMethodBeat.o(96379);
  }
  
  public void setLatNum(int paramInt)
  {
    AppMethodBeat.i(96377);
    this.KoA = paramInt;
    invalidate();
    AppMethodBeat.o(96377);
  }
  
  public void setLonNum(int paramInt)
  {
    AppMethodBeat.i(96376);
    this.Koz = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid
 * JD-Core Version:    0.7.0.1
 */