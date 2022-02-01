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
  private int Xag;
  private int Xah;
  private float Xai;
  private float Xaj;
  private float Xak;
  private int Xal;
  private int Xam;
  boolean Xan;
  private RectF Xao;
  int cam;
  int cqG;
  private Paint mPaint;
  long mStartTime;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80429);
    this.Xag = -7829368;
    this.Xah = -65536;
    this.Xai = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.Xam = -1;
    AppMethodBeat.o(80429);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(80430);
    super.onDraw(paramCanvas);
    if (this.Xak == this.Xaj) {
      this.Xaj -= 0.001F;
    }
    float f1 = this.Xaj;
    float f2 = this.Xak;
    int i = this.Xag;
    int j = this.Xah;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.Xao, this.mPaint);
    if ((this.Xan) && (this.Xak > 0.0F))
    {
      this.Xaj -= this.Xai;
      if (this.Xaj >= -this.Xal) {
        break label211;
      }
      f1 = -this.Xal;
      this.Xaj = f1;
      if (this.Xam - this.Xaj >= this.Xal) {
        break label219;
      }
    }
    label211:
    label219:
    for (f1 = this.Xam;; f1 = this.Xaj + this.Xal)
    {
      this.Xak = f1;
      postInvalidateDelayed(this.cqG);
      AppMethodBeat.o(80430);
      return;
      f1 = this.Xaj;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80431);
    super.onMeasure(paramInt1, paramInt2);
    this.Xam = View.MeasureSpec.getSize(paramInt1);
    this.Xao = new RectF(0.0F, 0.0F, this.Xam, this.Xam);
    this.Xal = (this.Xam / 2);
    xP(System.currentTimeMillis());
    AppMethodBeat.o(80431);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.Xah = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.Xag = paramInt;
  }
  
  final void xP(long paramLong)
  {
    AppMethodBeat.i(80432);
    if (this.Xam < 0)
    {
      Log.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.Xam) });
      AppMethodBeat.o(80432);
      return;
    }
    this.Xai = (this.Xam * 2 / (this.cam / this.cqG));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.Xam;
      this.Xaj = f;
      if (this.Xam - this.Xaj >= this.Xal) {
        break label188;
      }
    }
    label188:
    for (float f = this.Xam;; f = this.Xaj + this.Xal)
    {
      this.Xak = f;
      AppMethodBeat.o(80432);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.cqG);
      this.Xaj = (this.Xam - (i + 1) * this.Xai);
      if (this.Xaj < -this.Xal)
      {
        f = -this.Xal;
        break;
      }
      f = this.Xaj;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */