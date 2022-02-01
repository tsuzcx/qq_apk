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
  public static final Point yli;
  private Rect mRect;
  private Path vU;
  private int yld;
  private int yle;
  private float ylg;
  private c ylh;
  private int ylo;
  private Point ylp;
  private Spannable[] ylr;
  private List<PointF> yls;
  
  static
  {
    AppMethodBeat.i(96393);
    yli = new Point(0, 0);
    AppMethodBeat.o(96393);
  }
  
  public RadarGrid(Context paramContext, int paramInt1, int paramInt2, float paramFloat, Spannable[] paramArrayOfSpannable, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(96363);
    this.yld = 4;
    this.yle = 4;
    this.ylg = 1.0F;
    this.ylo = 80;
    this.ylp = yli;
    this.vU = new Path();
    this.mRect = new Rect();
    this.ylg = paramFloat;
    this.yld = paramInt1;
    this.yle = paramInt2;
    this.ylg = paramFloat;
    this.ylr = paramArrayOfSpannable;
    this.ylh = paramc;
    AppMethodBeat.o(96363);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96361);
    this.yld = 4;
    this.yle = 4;
    this.ylg = 1.0F;
    this.ylo = 80;
    this.ylp = yli;
    this.vU = new Path();
    this.mRect = new Rect();
    dKh();
    AppMethodBeat.o(96361);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96362);
    this.yld = 4;
    this.yle = 4;
    this.ylg = 1.0F;
    this.ylo = 80;
    this.ylp = yli;
    this.vU = new Path();
    this.mRect = new Rect();
    dKh();
    AppMethodBeat.o(96362);
  }
  
  private List<PointF> by(float paramFloat)
  {
    AppMethodBeat.i(96365);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.yld)
    {
      PointF localPointF = new PointF();
      localPointF.set((float)(this.ylp.x - this.ylo * paramFloat * Math.sin(i * 2 * 3.141592653589793D / this.yld)), (float)(this.ylp.y - this.ylo * paramFloat * Math.cos(i * 2 * 3.141592653589793D / this.yld)));
      localArrayList.add(localPointF);
      i += 1;
    }
    AppMethodBeat.o(96365);
    return localArrayList;
  }
  
  private void dKh()
  {
    AppMethodBeat.i(96364);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(96364);
  }
  
  private int getGridDotRadius()
  {
    return this.ylh.ykS;
  }
  
  private Paint getPaintGLabelFont()
  {
    AppMethodBeat.i(96372);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ylh.ykJ);
    localPaint.setTextSize(this.ylh.ykK);
    AppMethodBeat.o(96372);
    return localPaint;
  }
  
  private Paint getPaintGScaleFont()
  {
    AppMethodBeat.i(96374);
    Paint localPaint = new Paint();
    c localc = this.ylh;
    if (localc.ykM == -1) {}
    for (int i = localc.ykJ;; i = localc.ykM)
    {
      localPaint.setColor(i);
      localPaint.setTextSize(this.ylh.ykN);
      AppMethodBeat.o(96374);
      return localPaint;
    }
  }
  
  private Paint getPaintGridBorder()
  {
    AppMethodBeat.i(96368);
    Paint localPaint = new Paint();
    c localc = this.ylh;
    int i;
    if (localc.ykE == -1)
    {
      i = localc.ykF;
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.STROKE);
      localc = this.ylh;
      if (localc.ykI != -1.0F) {
        break label95;
      }
    }
    label95:
    for (float f = localc.ykH;; f = localc.ykI)
    {
      localPaint.setStrokeWidth(f);
      localPaint.setAntiAlias(true);
      AppMethodBeat.o(96368);
      return localPaint;
      i = localc.ykE;
      break;
    }
  }
  
  private Paint getPaintGridDot()
  {
    AppMethodBeat.i(96370);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ylh.ykR);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96370);
    return localPaint;
  }
  
  private Paint getPaintGridFill()
  {
    AppMethodBeat.i(96367);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ylh.backgroundColor);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96367);
    return localPaint;
  }
  
  private Paint getPaintGridLatitude()
  {
    AppMethodBeat.i(96369);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ylh.ykF);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.ylh.ykH);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(96369);
    return localPaint;
  }
  
  private Paint getPaintGridLongitude()
  {
    AppMethodBeat.i(96371);
    Paint localPaint = new Paint();
    localPaint.setColor(this.ylh.ykG);
    localPaint.setStrokeWidth(this.ylh.ykH);
    AppMethodBeat.o(96371);
    return localPaint;
  }
  
  private TextPaint getTextPaintGLabelFont()
  {
    AppMethodBeat.i(96373);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(this.ylh.ykJ);
    localTextPaint.setTextSize(this.ylh.ykK);
    AppMethodBeat.o(96373);
    return localTextPaint;
  }
  
  public final int dKe()
  {
    return this.ylo * 2;
  }
  
  public final int dKf()
  {
    return this.ylo * 2;
  }
  
  public c getGridStyle()
  {
    return this.ylh;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96366);
    super.onDraw(paramCanvas);
    int j = getHeight();
    int i = getWidth();
    this.ylo = ((int)(Math.min(j, i) / 2.0F * 0.8D));
    this.ylp.set((int)(i / 2.0F), (int)(j / 2.0F));
    if (this.ylh.ykT != null)
    {
      i = (int)(i / 2.0F);
      j = (int)(j / 2.0F);
      int k = (int)(this.ylo * 2 + this.ylh.ykQ * 2.0F);
      int m = this.ylh.ykT.getWidth() * k / this.ylh.ykT.getHeight();
      if (this.ylh.ykT != null) {
        paramCanvas.drawBitmap(Bitmap.createScaledBitmap(this.ylh.ykT, m, k, false), i - (m >>> 1), j - (k >>> 1), null);
      }
    }
    if (this.ylh.ykA) {
      switch (this.ylh.ykz)
      {
      }
    }
    Object localObject;
    while (this.ylh.ykB)
    {
      this.yls = by(1.0F);
      i = 0;
      while (i < this.yld)
      {
        localObject = (PointF)this.yls.get(i);
        paramCanvas.drawLine(this.ylp.x, this.ylp.y, ((PointF)localObject).x, ((PointF)localObject).y, getPaintGridLongitude());
        i += 1;
      }
      paramCanvas.drawCircle(this.ylp.x, this.ylp.y, this.ylo, getPaintGridFill());
      continue;
      this.yls = by(1.0F);
      i = 0;
      if (i < this.yld)
      {
        localObject = (PointF)this.yls.get(i);
        if (i == 0) {
          this.vU.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
        for (;;)
        {
          i += 1;
          break;
          this.vU.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      this.vU.close();
      if ((this.ylh.backgroundColor != 0) && (this.ylh.ykT == null)) {
        paramCanvas.drawPath(this.vU, getPaintGridFill());
      }
    }
    if (this.ylh.ykA) {
      switch (this.ylh.ykz)
      {
      }
    }
    float f1;
    label887:
    float f2;
    for (;;)
    {
      if ((this.ylr != null) && (this.ylh.ykD)) {
        if (this.ylr.length != this.yld)
        {
          paramCanvas = new RuntimeException("Labels array length not matches longitude lines number.");
          AppMethodBeat.o(96366);
          throw paramCanvas;
          paramCanvas.drawCircle(this.ylp.x, this.ylp.y, this.ylo, getPaintGridBorder());
          i = 1;
          while (i < this.yle)
          {
            paramCanvas.drawCircle(this.ylp.x, this.ylp.y, this.ylo * (i * 1.0F / this.yle), getPaintGridLatitude());
            i += 1;
          }
          paramCanvas.drawPath(this.vU, getPaintGridBorder());
          this.vU.reset();
          i = 1;
          while (i < this.yle)
          {
            this.yls = by(i * 1.0F / this.yle);
            j = 0;
            if (j < this.yld)
            {
              localObject = (PointF)this.yls.get(j);
              if (j == 0) {
                this.vU.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
              for (;;)
              {
                paramCanvas.drawCircle(((PointF)localObject).x, ((PointF)localObject).y, getGridDotRadius(), getPaintGridDot());
                j += 1;
                break;
                this.vU.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
            }
            this.vU.close();
            paramCanvas.drawPath(this.vU, getPaintGridLatitude());
            this.vU.reset();
            i += 1;
          }
        }
        else
        {
          i = 0;
          if (i < this.yld)
          {
            localObject = this.ylr[i];
            if (!localObject.equals(null))
            {
              if ((i != 0) && (i != this.yld >>> 1)) {
                break label1071;
              }
              f1 = 0.5F;
              if (i != 0) {
                break label1097;
              }
              f2 = this.ylh.ykL;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StaticLayout((CharSequence)localObject, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, false);
      f1 = (float)(this.ylp.x - ((StaticLayout)localObject).getLineWidth(0) * f1 - (this.ylo + this.ylh.ykL) * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.yld));
      f2 = (float)(this.ylp.y - ((StaticLayout)localObject).getHeight() / 2 - (this.ylo + this.ylh.ykL) * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.yld) - f2);
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      ((StaticLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      i += 1;
      break;
      label1071:
      if ((i > 0) && (i < this.yld >>> 1))
      {
        f1 = 0.0F;
        break label887;
      }
      f1 = 1.0F;
      break label887;
      label1097:
      if (i == this.yld >>> 1)
      {
        f2 = -this.ylh.ykL;
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
    this.ylh.backgroundColor = paramInt;
    invalidate();
    AppMethodBeat.o(96381);
  }
  
  public void setGridBorderColor(int paramInt)
  {
    AppMethodBeat.i(96382);
    this.ylh.ykE = paramInt;
    invalidate();
    AppMethodBeat.o(96382);
  }
  
  public void setGridBorderStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96386);
    this.ylh.ykI = paramFloat;
    invalidate();
    AppMethodBeat.o(96386);
  }
  
  public void setGridChartType(int paramInt)
  {
    AppMethodBeat.i(96375);
    this.ylh.ykz = paramInt;
    invalidate();
    AppMethodBeat.o(96375);
  }
  
  public void setGridLabelColor(int paramInt)
  {
    AppMethodBeat.i(96387);
    this.ylh.ykJ = paramInt;
    invalidate();
    AppMethodBeat.o(96387);
  }
  
  public void setGridLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96389);
    this.ylh.ykL = paramFloat;
    invalidate();
    AppMethodBeat.o(96389);
  }
  
  public void setGridLabelSize(float paramFloat)
  {
    AppMethodBeat.i(96388);
    this.ylh.ykK = paramFloat;
    invalidate();
    AppMethodBeat.o(96388);
  }
  
  public void setGridLatitudeColor(int paramInt)
  {
    AppMethodBeat.i(96383);
    this.ylh.ykF = paramInt;
    invalidate();
    AppMethodBeat.o(96383);
  }
  
  public void setGridLongitudeColor(int paramInt)
  {
    AppMethodBeat.i(96384);
    this.ylh.ykG = paramInt;
    invalidate();
    AppMethodBeat.o(96384);
  }
  
  public void setGridScaleColor(int paramInt)
  {
    AppMethodBeat.i(96390);
    this.ylh.ykM = paramInt;
    invalidate();
    AppMethodBeat.o(96390);
  }
  
  public void setGridScaleLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(96392);
    this.ylh.ykO = paramFloat;
    invalidate();
    AppMethodBeat.o(96392);
  }
  
  public void setGridScaleSize(float paramFloat)
  {
    AppMethodBeat.i(96391);
    this.ylh.ykN = paramFloat;
    invalidate();
    AppMethodBeat.o(96391);
  }
  
  public void setGridStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(96385);
    this.ylh.ykH = paramFloat;
    invalidate();
    AppMethodBeat.o(96385);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96380);
    this.ylh = paramc;
    invalidate();
    AppMethodBeat.o(96380);
  }
  
  public void setLabelsArray(Spannable[] paramArrayOfSpannable)
  {
    AppMethodBeat.i(96379);
    this.ylr = paramArrayOfSpannable;
    invalidate();
    AppMethodBeat.o(96379);
  }
  
  public void setLatNum(int paramInt)
  {
    AppMethodBeat.i(96377);
    this.yle = paramInt;
    invalidate();
    AppMethodBeat.o(96377);
  }
  
  public void setLonNum(int paramInt)
  {
    AppMethodBeat.i(96376);
    this.yld = paramInt;
    invalidate();
    AppMethodBeat.o(96376);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(96378);
    this.ylg = paramFloat;
    invalidate();
    AppMethodBeat.o(96378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid
 * JD-Core Version:    0.7.0.1
 */