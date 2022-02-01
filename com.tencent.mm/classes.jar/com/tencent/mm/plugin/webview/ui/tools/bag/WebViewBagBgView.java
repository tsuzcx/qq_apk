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
import com.tencent.mm.sdk.platformtools.ac;

public class WebViewBagBgView
  extends View
{
  private int CBG;
  private int CBH;
  private float CBI;
  private float CBJ;
  private float CBK;
  private int CBL;
  private int CBM;
  boolean CBN;
  private RectF CBO;
  int asf;
  private Paint mPaint;
  long mStartTime;
  int zTW;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80429);
    this.CBG = -7829368;
    this.CBH = -65536;
    this.CBI = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.CBM = -1;
    AppMethodBeat.o(80429);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(80430);
    super.onDraw(paramCanvas);
    if (this.CBK == this.CBJ) {
      this.CBJ -= 0.001F;
    }
    float f1 = this.CBJ;
    float f2 = this.CBK;
    int i = this.CBG;
    int j = this.CBH;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.CBO, this.mPaint);
    if ((this.CBN) && (this.CBK > 0.0F))
    {
      this.CBJ -= this.CBI;
      if (this.CBJ >= -this.CBL) {
        break label211;
      }
      f1 = -this.CBL;
      this.CBJ = f1;
      if (this.CBM - this.CBJ >= this.CBL) {
        break label219;
      }
    }
    label211:
    label219:
    for (f1 = this.CBM;; f1 = this.CBJ + this.CBL)
    {
      this.CBK = f1;
      postInvalidateDelayed(this.zTW);
      AppMethodBeat.o(80430);
      return;
      f1 = this.CBJ;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80431);
    super.onMeasure(paramInt1, paramInt2);
    this.CBM = View.MeasureSpec.getSize(paramInt1);
    this.CBO = new RectF(0.0F, 0.0F, this.CBM, this.CBM);
    this.CBL = (this.CBM / 2);
    zE(System.currentTimeMillis());
    AppMethodBeat.o(80431);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.CBH = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.CBG = paramInt;
  }
  
  final void zE(long paramLong)
  {
    AppMethodBeat.i(80432);
    if (this.CBM < 0)
    {
      ac.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.CBM) });
      AppMethodBeat.o(80432);
      return;
    }
    this.CBI = (this.CBM * 2 / (this.asf / this.zTW));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.CBM;
      this.CBJ = f;
      if (this.CBM - this.CBJ >= this.CBL) {
        break label188;
      }
    }
    label188:
    for (float f = this.CBM;; f = this.CBJ + this.CBL)
    {
      this.CBK = f;
      AppMethodBeat.o(80432);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.zTW);
      this.CBJ = (this.CBM - (i + 1) * this.CBI);
      if (this.CBJ < -this.CBL)
      {
        f = -this.CBL;
        break;
      }
      f = this.CBJ;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */