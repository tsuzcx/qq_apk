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
import com.tencent.mm.sdk.platformtools.Log;

public class WebViewBagBgView
  extends View
{
  int FNL;
  private int JkK;
  private int JkL;
  private float JkM;
  private float JkN;
  private float JkO;
  private int JkP;
  private int JkQ;
  boolean JkR;
  private RectF JkS;
  int atU;
  private Paint mPaint;
  long mStartTime;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80429);
    this.JkK = -7829368;
    this.JkL = -65536;
    this.JkM = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.JkQ = -1;
    AppMethodBeat.o(80429);
  }
  
  final void Mg(long paramLong)
  {
    AppMethodBeat.i(80432);
    if (this.JkQ < 0)
    {
      Log.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.JkQ) });
      AppMethodBeat.o(80432);
      return;
    }
    this.JkM = (this.JkQ * 2 / (this.atU / this.FNL));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.JkQ;
      this.JkN = f;
      if (this.JkQ - this.JkN >= this.JkP) {
        break label188;
      }
    }
    label188:
    for (float f = this.JkQ;; f = this.JkN + this.JkP)
    {
      this.JkO = f;
      AppMethodBeat.o(80432);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.FNL);
      this.JkN = (this.JkQ - (i + 1) * this.JkM);
      if (this.JkN < -this.JkP)
      {
        f = -this.JkP;
        break;
      }
      f = this.JkN;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(80430);
    super.onDraw(paramCanvas);
    if (this.JkO == this.JkN) {
      this.JkN -= 0.001F;
    }
    float f1 = this.JkN;
    float f2 = this.JkO;
    int i = this.JkK;
    int j = this.JkL;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.JkS, this.mPaint);
    if ((this.JkR) && (this.JkO > 0.0F))
    {
      this.JkN -= this.JkM;
      if (this.JkN >= -this.JkP) {
        break label211;
      }
      f1 = -this.JkP;
      this.JkN = f1;
      if (this.JkQ - this.JkN >= this.JkP) {
        break label219;
      }
    }
    label211:
    label219:
    for (f1 = this.JkQ;; f1 = this.JkN + this.JkP)
    {
      this.JkO = f1;
      postInvalidateDelayed(this.FNL);
      AppMethodBeat.o(80430);
      return;
      f1 = this.JkN;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80431);
    super.onMeasure(paramInt1, paramInt2);
    this.JkQ = View.MeasureSpec.getSize(paramInt1);
    this.JkS = new RectF(0.0F, 0.0F, this.JkQ, this.JkQ);
    this.JkP = (this.JkQ / 2);
    Mg(System.currentTimeMillis());
    AppMethodBeat.o(80431);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.JkL = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.JkK = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */