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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class WebViewBagBgView
  extends View
{
  boolean BjA;
  private RectF BjB;
  private int Bjt;
  private int Bju;
  private float Bjv;
  private float Bjw;
  private float Bjx;
  private int Bjy;
  private int Bjz;
  int ark;
  private Paint mPaint;
  long mStartTime;
  int yGI;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80429);
    this.Bjt = -7829368;
    this.Bju = -65536;
    this.Bjv = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.Bjz = -1;
    AppMethodBeat.o(80429);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(80430);
    super.onDraw(paramCanvas);
    if (this.Bjx == this.Bjw) {
      this.Bjw -= 0.001F;
    }
    float f1 = this.Bjw;
    float f2 = this.Bjx;
    int i = this.Bjt;
    int j = this.Bju;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.BjB, this.mPaint);
    if ((this.BjA) && (this.Bjx > 0.0F))
    {
      this.Bjw -= this.Bjv;
      if (this.Bjw >= -this.Bjy) {
        break label211;
      }
      f1 = -this.Bjy;
      this.Bjw = f1;
      if (this.Bjz - this.Bjw >= this.Bjy) {
        break label219;
      }
    }
    label211:
    label219:
    for (f1 = this.Bjz;; f1 = this.Bjw + this.Bjy)
    {
      this.Bjx = f1;
      postInvalidateDelayed(this.yGI);
      AppMethodBeat.o(80430);
      return;
      f1 = this.Bjw;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80431);
    super.onMeasure(paramInt1, paramInt2);
    this.Bjz = View.MeasureSpec.getSize(paramInt1);
    this.BjB = new RectF(0.0F, 0.0F, this.Bjz, this.Bjz);
    this.Bjy = (this.Bjz / 2);
    vb(System.currentTimeMillis());
    AppMethodBeat.o(80431);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.Bju = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.Bjt = paramInt;
  }
  
  final void vb(long paramLong)
  {
    AppMethodBeat.i(80432);
    if (this.Bjz < 0)
    {
      ad.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.Bjz) });
      AppMethodBeat.o(80432);
      return;
    }
    this.Bjv = (this.Bjz * 2 / (this.ark / this.yGI));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.Bjz;
      this.Bjw = f;
      if (this.Bjz - this.Bjw >= this.Bjy) {
        break label188;
      }
    }
    label188:
    for (float f = this.Bjz;; f = this.Bjw + this.Bjy)
    {
      this.Bjx = f;
      AppMethodBeat.o(80432);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.yGI);
      this.Bjw = (this.Bjz - (i + 1) * this.Bjv);
      if (this.Bjw < -this.Bjy)
      {
        f = -this.Bjy;
        break;
      }
      f = this.Bjw;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */