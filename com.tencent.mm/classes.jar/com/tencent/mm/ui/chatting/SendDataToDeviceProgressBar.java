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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.ah;

class SendDataToDeviceProgressBar
  extends ImageView
{
  private int bottom = -1;
  private ah dPi;
  private int jCV = -1;
  private Runnable jCW = new SendDataToDeviceProgressBar.1(this);
  private int lcv = 10;
  private int left = -1;
  private Context mContext;
  private Paint mPaint;
  private int right = -1;
  private int startAngle = 2;
  private int top = -1;
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setImageResource(R.g.progressbar_background);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = this.mContext.getResources().getDimensionPixelSize(R.f.send_data_progress_bar_circle_margin);
    this.top = this.left;
    this.jCV = this.mContext.getResources().getDimensionPixelSize(R.f.send_data_progress_bar_circle_width);
    this.dPi = new ah(Looper.getMainLooper());
  }
  
  public final int getProgress()
  {
    return (int)(this.startAngle / 360.0F * 100.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    this.mPaint.setColor(this.mContext.getResources().getColor(R.e.progress_color));
    this.mPaint.setStrokeWidth(this.jCV);
    if (this.right == -1) {
      this.right = (i * 2 - this.left);
    }
    if (this.bottom == -1) {
      this.bottom = this.right;
    }
    RectF localRectF = new RectF(this.left, this.top, this.right, this.bottom);
    paramCanvas.drawArc(localRectF, 270.0F, this.startAngle, false, this.mPaint);
    int j = this.startAngle + 270;
    i = j;
    if (j > 360) {
      i = j - 360;
    }
    this.mPaint.setColor(this.mContext.getResources().getColor(R.e.progress_background));
    paramCanvas.drawArc(localRectF, i, 360 - this.startAngle, false, this.mPaint);
  }
  
  public final void setProgress(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= 100) {
      i = 100;
    }
    this.startAngle = ((int)(i / 100.0F * 360.0F));
    this.dPi.removeCallbacks(this.jCW);
    this.dPi.postDelayed(this.jCW, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar
 * JD-Core Version:    0.7.0.1
 */