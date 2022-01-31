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
import com.tencent.mm.sdk.platformtools.ab;

public class WebViewBagBgView
  extends View
{
  private RectF gM;
  int mDuration;
  private Paint mPaint;
  long mStartTime;
  int tal;
  private int vin;
  private int vio;
  private float vip;
  private float viq;
  private float vir;
  private int vis;
  private int vit;
  boolean viu;
  
  public WebViewBagBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8198);
    this.vin = -7829368;
    this.vio = -65536;
    this.vip = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.vit = -1;
    AppMethodBeat.o(8198);
  }
  
  final void nq(long paramLong)
  {
    AppMethodBeat.i(8201);
    if (this.vit < 0)
    {
      ab.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[] { Integer.valueOf(this.vit) });
      AppMethodBeat.o(8201);
      return;
    }
    this.vip = (this.vit * 2 / (this.mDuration / this.tal));
    if (paramLong - this.mStartTime <= 0L)
    {
      f = this.vit;
      this.viq = f;
      if (this.vit - this.viq >= this.vis) {
        break label191;
      }
    }
    label191:
    for (float f = this.vit;; f = this.viq + this.vis)
    {
      this.vir = f;
      AppMethodBeat.o(8201);
      return;
      int i = (int)((float)(paramLong - this.mStartTime) / this.tal);
      this.viq = (this.vit - (i + 1) * this.vip);
      if (this.viq < -this.vis)
      {
        f = -this.vis;
        break;
      }
      f = this.viq;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(8199);
    super.onDraw(paramCanvas);
    if (this.vir == this.viq) {
      this.viq -= 0.001F;
    }
    float f1 = this.viq;
    float f2 = this.vir;
    int i = this.vin;
    int j = this.vio;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j }, null, (Shader.TileMode)localObject);
    this.mPaint.setShader((Shader)localObject);
    paramCanvas.drawOval(this.gM, this.mPaint);
    if ((this.viu) && (this.vir > 0.0F))
    {
      this.viq -= this.vip;
      if (this.viq >= -this.vis) {
        break label213;
      }
      f1 = -this.vis;
      this.viq = f1;
      if (this.vit - this.viq >= this.vis) {
        break label221;
      }
    }
    label213:
    label221:
    for (f1 = this.vit;; f1 = this.viq + this.vis)
    {
      this.vir = f1;
      postInvalidateDelayed(this.tal);
      AppMethodBeat.o(8199);
      return;
      f1 = this.viq;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(8200);
    super.onMeasure(paramInt1, paramInt2);
    this.vit = View.MeasureSpec.getSize(paramInt1);
    this.gM = new RectF(0.0F, 0.0F, this.vit, this.vit);
    this.vis = (this.vit / 2);
    nq(System.currentTimeMillis());
    AppMethodBeat.o(8200);
  }
  
  public void setAngryColor(int paramInt)
  {
    this.vio = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.vin = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView
 * JD-Core Version:    0.7.0.1
 */