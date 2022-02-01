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
import com.tencent.mm.sdk.platformtools.ae;

public class WebViewBagBgView
  extends View
{
  int BCZ;
  private int Exr;
  private int Exs;
  private float Ext;
  private float Exu;
  private float Exv;
  private int Exw;
  private int Exx;
  boolean Exy;
  private RectF Exz;
  int atW;
  private Paint mPaint;
  long mStartTime;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80429);
    this.Exr = -7829368;
    this.Exs = -65536;
    this.Ext = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.Exx = -1;
    AppMethodBeat.o(80429);
  }
  
  final void CR(long paramLong)
  {
    AppMethodBeat.i(80432);
    if (this.Exx < 0)
    {
      ae.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.Exx) });
      AppMethodBeat.o(80432);
      return;
    }
    this.Ext = (this.Exx * 2 / (this.atW / this.BCZ));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.Exx;
      this.Exu = f;
      if (this.Exx - this.Exu >= this.Exw) {
        break label188;
      }
    }
    label188:
    for (float f = this.Exx;; f = this.Exu + this.Exw)
    {
      this.Exv = f;
      AppMethodBeat.o(80432);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.BCZ);
      this.Exu = (this.Exx - (i + 1) * this.Ext);
      if (this.Exu < -this.Exw)
      {
        f = -this.Exw;
        break;
      }
      f = this.Exu;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(80430);
    super.onDraw(paramCanvas);
    if (this.Exv == this.Exu) {
      this.Exu -= 0.001F;
    }
    float f1 = this.Exu;
    float f2 = this.Exv;
    int i = this.Exr;
    int j = this.Exs;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.Exz, this.mPaint);
    if ((this.Exy) && (this.Exv > 0.0F))
    {
      this.Exu -= this.Ext;
      if (this.Exu >= -this.Exw) {
        break label211;
      }
      f1 = -this.Exw;
      this.Exu = f1;
      if (this.Exx - this.Exu >= this.Exw) {
        break label219;
      }
    }
    label211:
    label219:
    for (f1 = this.Exx;; f1 = this.Exu + this.Exw)
    {
      this.Exv = f1;
      postInvalidateDelayed(this.BCZ);
      AppMethodBeat.o(80430);
      return;
      f1 = this.Exu;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80431);
    super.onMeasure(paramInt1, paramInt2);
    this.Exx = View.MeasureSpec.getSize(paramInt1);
    this.Exz = new RectF(0.0F, 0.0F, this.Exx, this.Exx);
    this.Exw = (this.Exx / 2);
    CR(System.currentTimeMillis());
    AppMethodBeat.o(80431);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.Exs = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.Exr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */