package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

class SendDataToDeviceProgressBar
  extends ImageView
{
  private int bottom;
  private ak faV;
  private int lMs;
  private int lMt;
  private Runnable lMu;
  private int left;
  private Context mContext;
  private Paint mPaint;
  private int nAq;
  private int right;
  private int top;
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(30999);
    this.lMs = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.lMt = -1;
    this.nAq = 10;
    this.lMu = new SendDataToDeviceProgressBar.1(this);
    setImageResource(2130840998);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = this.mContext.getResources().getDimensionPixelSize(2131428657);
    this.top = this.left;
    this.lMt = this.mContext.getResources().getDimensionPixelSize(2131428658);
    this.faV = new ak(Looper.getMainLooper());
    AppMethodBeat.o(30999);
  }
  
  private void dGX()
  {
    AppMethodBeat.i(31002);
    this.faV.removeCallbacks(this.lMu);
    this.faV.postDelayed(this.lMu, 0L);
    AppMethodBeat.o(31002);
  }
  
  public final void Px(int paramInt)
  {
    AppMethodBeat.i(31000);
    int i = paramInt;
    if (paramInt >= 100) {
      i = 100;
    }
    this.lMs = ((int)(i / 100.0F * 360.0F));
    dGX();
    AppMethodBeat.o(31000);
  }
  
  public final int getProgress()
  {
    return (int)(this.lMs / 360.0F * 100.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(31001);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    this.mPaint.setColor(this.mContext.getResources().getColor(2131690362));
    this.mPaint.setStrokeWidth(this.lMt);
    if (this.right == -1) {
      this.right = (i * 2 - this.left);
    }
    if (this.bottom == -1) {
      this.bottom = this.right;
    }
    RectF localRectF = new RectF(this.left, this.top, this.right, this.bottom);
    paramCanvas.drawArc(localRectF, 270.0F, this.lMs, false, this.mPaint);
    int j = this.lMs + 270;
    i = j;
    if (j > 360) {
      i = j - 360;
    }
    this.mPaint.setColor(this.mContext.getResources().getColor(2131690359));
    paramCanvas.drawArc(localRectF, i, 360 - this.lMs, false, this.mPaint);
    AppMethodBeat.o(31001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar
 * JD-Core Version:    0.7.0.1
 */