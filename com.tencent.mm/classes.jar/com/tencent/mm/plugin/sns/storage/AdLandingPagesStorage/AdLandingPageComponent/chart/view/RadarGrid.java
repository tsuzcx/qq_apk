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
  public static final Point run;
  private Rect mRect;
  private Path ou;
  private int rui;
  private int ruj;
  private float rul;
  private c rum;
  private int rut;
  private Point ruu;
  private Spannable[] ruw;
  private List<PointF> rux;
  
  static
  {
    AppMethodBeat.i(37012);
    run = new Point(0, 0);
    AppMethodBeat.o(37012);
  }
  
  public RadarGrid(Context paramContext, int paramInt1, int paramInt2, float paramFloat, Spannable[] paramArrayOfSpannable, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(36982);
    this.rui = 4;
    this.ruj = 4;
    this.rul = 1.0F;
    this.rut = 80;
    this.ruu = run;
    this.ou = new Path();
    this.mRect = new Rect();
    this.rul = paramFloat;
    this.rui = paramInt1;
    this.ruj = paramInt2;
    this.rul = paramFloat;
    this.ruw = paramArrayOfSpannable;
    this.rum = paramc;
    AppMethodBeat.o(36982);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(36980);
    this.rui = 4;
    this.ruj = 4;
    this.rul = 1.0F;
    this.rut = 80;
    this.ruu = run;
    this.ou = new Path();
    this.mRect = new Rect();
    cqJ();
    AppMethodBeat.o(36980);
  }
  
  public RadarGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(36981);
    this.rui = 4;
    this.ruj = 4;
    this.rul = 1.0F;
    this.rut = 80;
    this.ruu = run;
    this.ou = new Path();
    this.mRect = new Rect();
    cqJ();
    AppMethodBeat.o(36981);
  }
  
  private List<PointF> ba(float paramFloat)
  {
    AppMethodBeat.i(36984);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.rui)
    {
      PointF localPointF = new PointF();
      localPointF.set((float)(this.ruu.x - this.rut * paramFloat * Math.sin(i * 2 * 3.141592653589793D / this.rui)), (float)(this.ruu.y - this.rut * paramFloat * Math.cos(i * 2 * 3.141592653589793D / this.rui)));
      localArrayList.add(localPointF);
      i += 1;
    }
    AppMethodBeat.o(36984);
    return localArrayList;
  }
  
  private void cqJ()
  {
    AppMethodBeat.i(36983);
    setMinimumHeight(160);
    setMinimumWidth(160);
    AppMethodBeat.o(36983);
  }
  
  private int getGridDotRadius()
  {
    return this.rum.rtX;
  }
  
  private Paint getPaintGLabelFont()
  {
    AppMethodBeat.i(36991);
    Paint localPaint = new Paint();
    localPaint.setColor(this.rum.rtO);
    localPaint.setTextSize(this.rum.rtP);
    AppMethodBeat.o(36991);
    return localPaint;
  }
  
  private Paint getPaintGScaleFont()
  {
    AppMethodBeat.i(36993);
    Paint localPaint = new Paint();
    c localc = this.rum;
    if (localc.rtR == -1) {}
    for (int i = localc.rtO;; i = localc.rtR)
    {
      localPaint.setColor(i);
      localPaint.setTextSize(this.rum.rtS);
      AppMethodBeat.o(36993);
      return localPaint;
    }
  }
  
  private Paint getPaintGridBorder()
  {
    AppMethodBeat.i(36987);
    Paint localPaint = new Paint();
    c localc = this.rum;
    int i;
    if (localc.rtJ == -1)
    {
      i = localc.rtK;
      localPaint.setColor(i);
      localPaint.setStyle(Paint.Style.STROKE);
      localc = this.rum;
      if (localc.rtN != -1.0F) {
        break label95;
      }
    }
    label95:
    for (float f = localc.rtM;; f = localc.rtN)
    {
      localPaint.setStrokeWidth(f);
      localPaint.setAntiAlias(true);
      AppMethodBeat.o(36987);
      return localPaint;
      i = localc.rtJ;
      break;
    }
  }
  
  private Paint getPaintGridDot()
  {
    AppMethodBeat.i(36989);
    Paint localPaint = new Paint();
    localPaint.setColor(this.rum.rtW);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(36989);
    return localPaint;
  }
  
  private Paint getPaintGridFill()
  {
    AppMethodBeat.i(36986);
    Paint localPaint = new Paint();
    localPaint.setColor(this.rum.backgroundColor);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(36986);
    return localPaint;
  }
  
  private Paint getPaintGridLatitude()
  {
    AppMethodBeat.i(36988);
    Paint localPaint = new Paint();
    localPaint.setColor(this.rum.rtK);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.rum.rtM);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(36988);
    return localPaint;
  }
  
  private Paint getPaintGridLongitude()
  {
    AppMethodBeat.i(36990);
    Paint localPaint = new Paint();
    localPaint.setColor(this.rum.rtL);
    localPaint.setStrokeWidth(this.rum.rtM);
    AppMethodBeat.o(36990);
    return localPaint;
  }
  
  private TextPaint getTextPaintGLabelFont()
  {
    AppMethodBeat.i(36992);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setColor(this.rum.rtO);
    localTextPaint.setTextSize(this.rum.rtP);
    AppMethodBeat.o(36992);
    return localTextPaint;
  }
  
  public final int cqG()
  {
    return this.rut * 2;
  }
  
  public final int cqH()
  {
    return this.rut * 2;
  }
  
  public c getGridStyle()
  {
    return this.rum;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(36985);
    super.onDraw(paramCanvas);
    int j = getHeight();
    int i = getWidth();
    this.rut = ((int)(Math.min(j, i) / 2.0F * 0.8D));
    this.ruu.set((int)(i / 2.0F), (int)(j / 2.0F));
    if (this.rum.rtY != null)
    {
      i = (int)(i / 2.0F);
      j = (int)(j / 2.0F);
      int k = (int)(this.rut * 2 + this.rum.rtV * 2.0F);
      int m = this.rum.rtY.getWidth() * k / this.rum.rtY.getHeight();
      if (this.rum.rtY != null) {
        paramCanvas.drawBitmap(Bitmap.createScaledBitmap(this.rum.rtY, m, k, false), i - (m >>> 1), j - (k >>> 1), null);
      }
    }
    if (this.rum.rtF) {
      switch (this.rum.rtE)
      {
      }
    }
    Object localObject;
    while (this.rum.rtG)
    {
      this.rux = ba(1.0F);
      i = 0;
      while (i < this.rui)
      {
        localObject = (PointF)this.rux.get(i);
        paramCanvas.drawLine(this.ruu.x, this.ruu.y, ((PointF)localObject).x, ((PointF)localObject).y, getPaintGridLongitude());
        i += 1;
      }
      paramCanvas.drawCircle(this.ruu.x, this.ruu.y, this.rut, getPaintGridFill());
      continue;
      this.rux = ba(1.0F);
      i = 0;
      if (i < this.rui)
      {
        localObject = (PointF)this.rux.get(i);
        if (i == 0) {
          this.ou.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
        for (;;)
        {
          i += 1;
          break;
          this.ou.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      this.ou.close();
      if ((this.rum.backgroundColor != 0) && (this.rum.rtY == null)) {
        paramCanvas.drawPath(this.ou, getPaintGridFill());
      }
    }
    if (this.rum.rtF) {
      switch (this.rum.rtE)
      {
      }
    }
    float f1;
    label887:
    float f2;
    for (;;)
    {
      if ((this.ruw != null) && (this.rum.rtI)) {
        if (this.ruw.length != this.rui)
        {
          paramCanvas = new RuntimeException("Labels array length not matches longitude lines number.");
          AppMethodBeat.o(36985);
          throw paramCanvas;
          paramCanvas.drawCircle(this.ruu.x, this.ruu.y, this.rut, getPaintGridBorder());
          i = 1;
          while (i < this.ruj)
          {
            paramCanvas.drawCircle(this.ruu.x, this.ruu.y, this.rut * (i * 1.0F / this.ruj), getPaintGridLatitude());
            i += 1;
          }
          paramCanvas.drawPath(this.ou, getPaintGridBorder());
          this.ou.reset();
          i = 1;
          while (i < this.ruj)
          {
            this.rux = ba(i * 1.0F / this.ruj);
            j = 0;
            if (j < this.rui)
            {
              localObject = (PointF)this.rux.get(j);
              if (j == 0) {
                this.ou.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
              for (;;)
              {
                paramCanvas.drawCircle(((PointF)localObject).x, ((PointF)localObject).y, getGridDotRadius(), getPaintGridDot());
                j += 1;
                break;
                this.ou.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
              }
            }
            this.ou.close();
            paramCanvas.drawPath(this.ou, getPaintGridLatitude());
            this.ou.reset();
            i += 1;
          }
        }
        else
        {
          i = 0;
          if (i < this.rui)
          {
            localObject = this.ruw[i];
            if (!localObject.equals(null))
            {
              if ((i != 0) && (i != this.rui >>> 1)) {
                break label1071;
              }
              f1 = 0.5F;
              if (i != 0) {
                break label1097;
              }
              f2 = this.rum.rtQ;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StaticLayout((CharSequence)localObject, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0F, 0.0F, false);
      f1 = (float)(this.ruu.x - ((StaticLayout)localObject).getLineWidth(0) * f1 - (this.rut + this.rum.rtQ) * Math.sin(6.283185307179586D - i * 2 * 3.141592653589793D / this.rui));
      f2 = (float)(this.ruu.y - ((StaticLayout)localObject).getHeight() / 2 - (this.rut + this.rum.rtQ) * Math.cos(6.283185307179586D - i * 2 * 3.141592653589793D / this.rui) - f2);
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      ((StaticLayout)localObject).draw(paramCanvas);
      paramCanvas.restore();
      i += 1;
      break;
      label1071:
      if ((i > 0) && (i < this.rui >>> 1))
      {
        f1 = 0.0F;
        break label887;
      }
      f1 = 1.0F;
      break label887;
      label1097:
      if (i == this.rui >>> 1)
      {
        f2 = -this.rum.rtQ;
        continue;
        AppMethodBeat.o(36985);
      }
      else
      {
        f2 = 0.0F;
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(37000);
    this.rum.backgroundColor = paramInt;
    invalidate();
    AppMethodBeat.o(37000);
  }
  
  public void setGridBorderColor(int paramInt)
  {
    AppMethodBeat.i(37001);
    this.rum.rtJ = paramInt;
    invalidate();
    AppMethodBeat.o(37001);
  }
  
  public void setGridBorderStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(37005);
    this.rum.rtN = paramFloat;
    invalidate();
    AppMethodBeat.o(37005);
  }
  
  public void setGridChartType(int paramInt)
  {
    AppMethodBeat.i(36994);
    this.rum.rtE = paramInt;
    invalidate();
    AppMethodBeat.o(36994);
  }
  
  public void setGridLabelColor(int paramInt)
  {
    AppMethodBeat.i(37006);
    this.rum.rtO = paramInt;
    invalidate();
    AppMethodBeat.o(37006);
  }
  
  public void setGridLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(37008);
    this.rum.rtQ = paramFloat;
    invalidate();
    AppMethodBeat.o(37008);
  }
  
  public void setGridLabelSize(float paramFloat)
  {
    AppMethodBeat.i(37007);
    this.rum.rtP = paramFloat;
    invalidate();
    AppMethodBeat.o(37007);
  }
  
  public void setGridLatitudeColor(int paramInt)
  {
    AppMethodBeat.i(37002);
    this.rum.rtK = paramInt;
    invalidate();
    AppMethodBeat.o(37002);
  }
  
  public void setGridLongitudeColor(int paramInt)
  {
    AppMethodBeat.i(37003);
    this.rum.rtL = paramInt;
    invalidate();
    AppMethodBeat.o(37003);
  }
  
  public void setGridScaleColor(int paramInt)
  {
    AppMethodBeat.i(37009);
    this.rum.rtR = paramInt;
    invalidate();
    AppMethodBeat.o(37009);
  }
  
  public void setGridScaleLabelPadding(float paramFloat)
  {
    AppMethodBeat.i(37011);
    this.rum.rtT = paramFloat;
    invalidate();
    AppMethodBeat.o(37011);
  }
  
  public void setGridScaleSize(float paramFloat)
  {
    AppMethodBeat.i(37010);
    this.rum.rtS = paramFloat;
    invalidate();
    AppMethodBeat.o(37010);
  }
  
  public void setGridStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(37004);
    this.rum.rtM = paramFloat;
    invalidate();
    AppMethodBeat.o(37004);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(36999);
    this.rum = paramc;
    invalidate();
    AppMethodBeat.o(36999);
  }
  
  public void setLabelsArray(Spannable[] paramArrayOfSpannable)
  {
    AppMethodBeat.i(36998);
    this.ruw = paramArrayOfSpannable;
    invalidate();
    AppMethodBeat.o(36998);
  }
  
  public void setLatNum(int paramInt)
  {
    AppMethodBeat.i(36996);
    this.ruj = paramInt;
    invalidate();
    AppMethodBeat.o(36996);
  }
  
  public void setLonNum(int paramInt)
  {
    AppMethodBeat.i(36995);
    this.rui = paramInt;
    invalidate();
    AppMethodBeat.o(36995);
  }
  
  public void setMaxValue(float paramFloat)
  {
    AppMethodBeat.i(36997);
    this.rul = paramFloat;
    invalidate();
    AppMethodBeat.o(36997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid
 * JD-Core Version:    0.7.0.1
 */