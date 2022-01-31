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
  private Paint AL;
  private int aeN;
  private int aeO;
  private int aiA;
  private RectF aiB;
  private double aiC = 0.15D;
  private double aiD;
  private HashMap<Double, Double> aiE = new HashMap();
  private double aiF = 5.0D;
  private double aiG = this.aiF;
  private int aiH;
  private int aiI;
  private int aiJ = 0;
  private int aiy;
  private int aiz;
  
  public g(int paramInt1, int paramInt2)
  {
    d.c("MicroMsg.SiriWave", "Create Siri Wave screenWidth=%d screenHeight=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.aeO = paramInt1;
    this.aeN = paramInt2;
    this.aiH = this.aeO;
    this.aiy = (this.aeO / 2);
    this.aiz = (this.aeO / 4);
    this.aiA = (this.aeN / 2 + 35);
    this.aiB = new RectF();
    this.AL = new Paint();
    this.AL.setAntiAlias(true);
    this.AL.setStrokeWidth(2.0F);
    this.AL.setStyle(Paint.Style.STROKE);
    float f = paramInt1;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { 0, -9502781, -12744449, 0 }, new float[] { 0.0F, 0.2F, 0.8F, 1.0F }, (Shader.TileMode)localObject);
    this.AL.setShader((Shader)localObject);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, double paramDouble, int paramInt1, int paramInt2)
  {
    int i = 0;
    double d1 = -2.0D;
    Path localPath = new Path();
    int j = this.aiy;
    int k = paramInt2 / 2;
    int m = this.aiy;
    int n = paramInt2 / 2;
    paramInt2 = i;
    if (d1 <= 2.0D)
    {
      i = (int)(this.aiy + this.aiz * d1);
      int i1;
      if ((i >= j - k) && (i <= n + m))
      {
        double d2 = this.aiA;
        if (!this.aiE.containsKey(Double.valueOf(d1))) {
          this.aiE.put(Double.valueOf(d1), Double.valueOf(Math.pow(4.0D / (4.0D + Math.pow(d1, 4.0D)), 2.0D)));
        }
        i1 = (int)(d2 + ((Double)this.aiE.get(Double.valueOf(d1))).doubleValue() * paramDouble * Math.sin(paramInt1 * d1 - this.aiD)) - 10;
        if (paramInt2 == 0)
        {
          localPath.moveTo(i, i1);
          paramInt2 = 1;
        }
      }
      for (;;)
      {
        d1 += 0.005D;
        break;
        localPath.lineTo(i, i1);
      }
    }
    paramCanvas.drawPath(localPath, paramPaint);
  }
  
  private void nF()
  {
    this.aiD = ((this.aiD + 3.141592653589793D * this.aiC) % 6.283185307179586D);
  }
  
  public final void a(Canvas paramCanvas, int paramInt)
  {
    if (paramInt == 4) {
      if (this.aiH > 0)
      {
        this.aiC = 0.15D;
        nF();
        this.aiH -= 20;
        this.aiG = a.a(this.aiF, this.aiG);
        a(paramCanvas, this.AL, this.aiG, 2, this.aiH);
        this.AL.setAlpha(255);
      }
    }
    while ((paramInt != 2) && (paramInt != 3))
    {
      return;
      if (this.aiI < 40) {
        this.aiI += 4;
      }
      Paint localPaint = this.AL;
      this.aiB.set(this.aiy - this.aiI, this.aiA - this.aiI, this.aiy + this.aiI, this.aiA + this.aiI);
      Path localPath = new Path();
      localPath.addArc(this.aiB, this.aiJ, 356.0F);
      paramCanvas.drawPath(localPath, localPaint);
      this.aiJ += 5;
      this.aiJ %= 360;
      return;
    }
    this.aiH = this.aeO;
    this.aiC = 0.15D;
    nF();
    this.aiG = a.a(this.aiF, this.aiG);
    a(paramCanvas, this.AL, this.aiG, 2, this.aiH);
    double d1 = this.aiG;
    double d2 = this.aiG;
    this.AL.setAlpha(100);
    a(paramCanvas, this.AL, d1 * 0.6D, 2, this.aiH);
    this.AL.setAlpha(40);
    a(paramCanvas, this.AL, -(d2 * 0.2D), 4, this.aiH);
    this.AL.setAlpha(255);
  }
  
  public final void cd(int paramInt)
  {
    this.aiF = (paramInt * 50.0D / 3000.0D);
    if (this.aiF > 50.0D) {
      this.aiF = 50.0D;
    }
    while (this.aiF >= 5.0D) {
      return;
    }
    this.aiF = 5.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */