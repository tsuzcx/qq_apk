package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.y;

public class WebViewBagBgView
  extends View
{
  private RectF fS;
  int mDuration;
  private Paint mPaint = new Paint();
  long mStartTime;
  int pyx;
  private int rsi = -7829368;
  private int rsj = -65536;
  private float rsk = 0.0F;
  private float rsl;
  private float rsm;
  private int rsn;
  private int rso;
  boolean rsp;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint.setAntiAlias(true);
    this.rso = -1;
  }
  
  final void gT(long paramLong)
  {
    if (this.rso < 0)
    {
      y.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.rso) });
      return;
    }
    this.rsk = (this.rso * 2 / (this.mDuration / this.pyx));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.rso;
      this.rsl = f;
      if (this.rso - this.rsl >= this.rsn) {
        break label173;
      }
    }
    label173:
    for (float f = this.rso;; f = this.rsl + this.rsn)
    {
      this.rsm = f;
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.pyx);
      this.rsl = (this.rso - (i + 1) * this.rsk);
      if (this.rsl < -this.rsn)
      {
        f = -this.rsn;
        break;
      }
      f = this.rsl;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.rsl;
    float f2 = this.rsm;
    int i = this.rsi;
    int j = this.rsj;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.fS, this.mPaint);
    if ((this.rsp) && (this.rsm > 0.0F))
    {
      this.rsl -= this.rsk;
      if (this.rsl >= -this.rsn) {
        break label178;
      }
      f1 = -this.rsn;
      this.rsl = f1;
      if (this.rso - this.rsl >= this.rsn) {
        break label186;
      }
    }
    label178:
    label186:
    for (f1 = this.rso;; f1 = this.rsl + this.rsn)
    {
      this.rsm = f1;
      postInvalidateDelayed(this.pyx);
      return;
      f1 = this.rsl;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.rso = View.MeasureSpec.getSize(paramInt1);
    this.fS = new RectF(0.0F, 0.0F, this.rso, this.rso);
    this.rsn = (this.rso / 2);
    gT(System.currentTimeMillis());
  }
  
  public void setAngryColor(int paramInt)
  {
    this.rsj = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.rsi = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */