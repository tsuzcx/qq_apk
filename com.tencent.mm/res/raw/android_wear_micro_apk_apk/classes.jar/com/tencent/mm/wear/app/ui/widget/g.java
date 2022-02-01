package com.tencent.mm.wear.app.ui.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.a.f.a;
import java.util.HashMap;

public final class g
{
  private Paint CA;
  private int aip;
  private int aiq;
  private int ama;
  private int amb;
  private int amc;
  private RectF amd;
  private double ame = 0.15D;
  private double amf;
  private HashMap<Double, Double> amg = new HashMap();
  private double amh = 5.0D;
  private double ami = this.amh;
  private int amj;
  private int amk;
  private int aml = 0;
  
  public g(int paramInt1, int paramInt2)
  {
    d.c("MicroMsg.SiriWave", "Create Siri Wave screenWidth=%d screenHeight=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.aiq = paramInt1;
    this.aip = paramInt2;
    this.amj = this.aiq;
    this.ama = (this.aiq / 2);
    this.amb = (this.aiq / 4);
    this.amc = (this.aip / 2 + 35);
    this.amd = new RectF();
    this.CA = new Paint();
    this.CA.setAntiAlias(true);
    this.CA.setStrokeWidth(2.0F);
    this.CA.setStyle(Paint.Style.STROKE);
    float f = paramInt1;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { 0, -9502781, -12744449, 0 }, new float[] { 0.0F, 0.2F, 0.8F, 1.0F }, (Shader.TileMode)localObject);
    this.CA.setShader((Shader)localObject);
  }
  
  private int a(double paramDouble)
  {
    return (int)(this.ama + this.amb * paramDouble);
  }
  
  private int a(double paramDouble1, double paramDouble2, int paramInt)
  {
    double d = this.amc;
    if (!this.amg.containsKey(Double.valueOf(paramDouble2))) {
      this.amg.put(Double.valueOf(paramDouble2), Double.valueOf(Math.pow(4.0D / (Math.pow(paramDouble2, 4.0D) + 4.0D), 2.0D)));
    }
    return (int)(((Double)this.amg.get(Double.valueOf(paramDouble2))).doubleValue() * paramDouble1 * Math.sin(paramInt * paramDouble2 - this.amf) + d) - 10;
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, double paramDouble, int paramInt1, int paramInt2)
  {
    int i = 0;
    double d = -2.0D;
    Path localPath = new Path();
    int j = this.ama;
    int k = paramInt2 / 2;
    int m = this.ama;
    int n = paramInt2 / 2;
    paramInt2 = i;
    if (d <= 2.0D)
    {
      int i1 = a(d);
      i = paramInt2;
      if (i1 >= j - k)
      {
        i = paramInt2;
        if (i1 <= m + n)
        {
          i = a(paramDouble, d, paramInt1);
          if (paramInt2 != 0) {
            break label135;
          }
          localPath.moveTo(i1, i);
        }
      }
      for (i = 1;; i = paramInt2)
      {
        d += 0.005D;
        paramInt2 = i;
        break;
        label135:
        localPath.lineTo(i1, i);
      }
    }
    paramCanvas.drawPath(localPath, paramPaint);
  }
  
  private void ot()
  {
    this.amf = ((this.amf + 3.141592653589793D * this.ame) % 6.283185307179586D);
  }
  
  public final void a(Canvas paramCanvas, int paramInt)
  {
    if (paramInt == 4) {
      if (this.amj > 0)
      {
        this.ame = 0.15D;
        ot();
        this.amj -= 20;
        this.ami = a.a(this.amh, this.ami);
        a(paramCanvas, this.CA, this.ami, 2, this.amj);
        this.CA.setAlpha(255);
      }
    }
    while ((paramInt != 2) && (paramInt != 3))
    {
      return;
      if (this.amk < 40) {
        this.amk += 4;
      }
      Paint localPaint = this.CA;
      this.amd.set(this.ama - this.amk, this.amc - this.amk, this.ama + this.amk, this.amc + this.amk);
      Path localPath = new Path();
      localPath.addArc(this.amd, this.aml, 356.0F);
      paramCanvas.drawPath(localPath, localPaint);
      this.aml += 5;
      this.aml %= 360;
      return;
    }
    this.amj = this.aiq;
    this.ame = 0.15D;
    ot();
    this.ami = a.a(this.amh, this.ami);
    a(paramCanvas, this.CA, this.ami, 2, this.amj);
    double d1 = this.ami;
    double d2 = this.ami;
    this.CA.setAlpha(100);
    a(paramCanvas, this.CA, d1 * 0.6D, 2, this.amj);
    this.CA.setAlpha(40);
    a(paramCanvas, this.CA, -(d2 * 0.2D), 4, this.amj);
    this.CA.setAlpha(255);
  }
  
  public final void cz(int paramInt)
  {
    this.amh = (paramInt * 50.0D / 3000.0D);
    if (this.amh > 50.0D) {
      this.amh = 50.0D;
    }
    while (this.amh >= 5.0D) {
      return;
    }
    this.amh = 5.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */