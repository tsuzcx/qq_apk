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
  int MhM;
  private int Qic;
  private int Qid;
  private float Qie;
  private float Qif;
  private float Qig;
  private int Qih;
  private int Qii;
  boolean Qij;
  private RectF Qik;
  int alM;
  private Paint mPaint;
  long mStartTime;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80429);
    this.Qic = -7829368;
    this.Qid = -65536;
    this.Qie = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.Qii = -1;
    AppMethodBeat.o(80429);
  }
  
  final void TG(long paramLong)
  {
    AppMethodBeat.i(80432);
    if (this.Qii < 0)
    {
      Log.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.Qii) });
      AppMethodBeat.o(80432);
      return;
    }
    this.Qie = (this.Qii * 2 / (this.alM / this.MhM));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.Qii;
      this.Qif = f;
      if (this.Qii - this.Qif >= this.Qih) {
        break label188;
      }
    }
    label188:
    for (float f = this.Qii;; f = this.Qif + this.Qih)
    {
      this.Qig = f;
      AppMethodBeat.o(80432);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.MhM);
      this.Qif = (this.Qii - (i + 1) * this.Qie);
      if (this.Qif < -this.Qih)
      {
        f = -this.Qih;
        break;
      }
      f = this.Qif;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(80430);
    super.onDraw(paramCanvas);
    if (this.Qig == this.Qif) {
      this.Qif -= 0.001F;
    }
    float f1 = this.Qif;
    float f2 = this.Qig;
    int i = this.Qic;
    int j = this.Qid;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.Qik, this.mPaint);
    if ((this.Qij) && (this.Qig > 0.0F))
    {
      this.Qif -= this.Qie;
      if (this.Qif >= -this.Qih) {
        break label211;
      }
      f1 = -this.Qih;
      this.Qif = f1;
      if (this.Qii - this.Qif >= this.Qih) {
        break label219;
      }
    }
    label211:
    label219:
    for (f1 = this.Qii;; f1 = this.Qif + this.Qih)
    {
      this.Qig = f1;
      postInvalidateDelayed(this.MhM);
      AppMethodBeat.o(80430);
      return;
      f1 = this.Qif;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80431);
    super.onMeasure(paramInt1, paramInt2);
    this.Qii = View.MeasureSpec.getSize(paramInt1);
    this.Qik = new RectF(0.0F, 0.0F, this.Qii, this.Qii);
    this.Qih = (this.Qii / 2);
    TG(System.currentTimeMillis());
    AppMethodBeat.o(80431);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.Qid = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.Qic = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */