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
  int BlA;
  private int Efo;
  private int Efp;
  private float Efq;
  private float Efr;
  private float Efs;
  private int Eft;
  private int Efu;
  boolean Efv;
  private RectF Efw;
  int atW;
  private Paint mPaint;
  long mStartTime;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80429);
    this.Efo = -7829368;
    this.Efp = -65536;
    this.Efq = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.Efu = -1;
    AppMethodBeat.o(80429);
  }
  
  final void Ct(long paramLong)
  {
    AppMethodBeat.i(80432);
    if (this.Efu < 0)
    {
      ad.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.Efu) });
      AppMethodBeat.o(80432);
      return;
    }
    this.Efq = (this.Efu * 2 / (this.atW / this.BlA));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.Efu;
      this.Efr = f;
      if (this.Efu - this.Efr >= this.Eft) {
        break label188;
      }
    }
    label188:
    for (float f = this.Efu;; f = this.Efr + this.Eft)
    {
      this.Efs = f;
      AppMethodBeat.o(80432);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.BlA);
      this.Efr = (this.Efu - (i + 1) * this.Efq);
      if (this.Efr < -this.Eft)
      {
        f = -this.Eft;
        break;
      }
      f = this.Efr;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(80430);
    super.onDraw(paramCanvas);
    if (this.Efs == this.Efr) {
      this.Efr -= 0.001F;
    }
    float f1 = this.Efr;
    float f2 = this.Efs;
    int i = this.Efo;
    int j = this.Efp;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.Efw, this.mPaint);
    if ((this.Efv) && (this.Efs > 0.0F))
    {
      this.Efr -= this.Efq;
      if (this.Efr >= -this.Eft) {
        break label211;
      }
      f1 = -this.Eft;
      this.Efr = f1;
      if (this.Efu - this.Efr >= this.Eft) {
        break label219;
      }
    }
    label211:
    label219:
    for (f1 = this.Efu;; f1 = this.Efr + this.Eft)
    {
      this.Efs = f1;
      postInvalidateDelayed(this.BlA);
      AppMethodBeat.o(80430);
      return;
      f1 = this.Efr;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80431);
    super.onMeasure(paramInt1, paramInt2);
    this.Efu = View.MeasureSpec.getSize(paramInt1);
    this.Efw = new RectF(0.0F, 0.0F, this.Efu, this.Efu);
    this.Eft = (this.Efu / 2);
    Ct(System.currentTimeMillis());
    AppMethodBeat.o(80431);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.Efp = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.Efo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */