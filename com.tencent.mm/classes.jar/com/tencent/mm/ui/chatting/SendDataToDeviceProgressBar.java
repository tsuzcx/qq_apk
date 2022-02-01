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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.MMHandler;

class SendDataToDeviceProgressBar
  extends ImageView
{
  private int ALs;
  private int bottom;
  private int left;
  private Context mContext;
  private Paint mPaint;
  private MMHandler mRi;
  private int right;
  private int startAngle;
  private int top;
  private int yzQ;
  private Runnable yzR;
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(34884);
    this.startAngle = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.yzQ = -1;
    this.ALs = 10;
    this.yzR = new SendDataToDeviceProgressBar.1(this);
    setImageResource(R.g.foT);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = this.mContext.getResources().getDimensionPixelSize(R.f.send_data_progress_bar_circle_margin);
    this.top = this.left;
    this.yzQ = this.mContext.getResources().getDimensionPixelSize(R.f.send_data_progress_bar_circle_width);
    this.mRi = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(34884);
  }
  
  private void jqg()
  {
    AppMethodBeat.i(34887);
    this.mRi.removeCallbacks(this.yzR);
    this.mRi.postDelayed(this.yzR, 0L);
    AppMethodBeat.o(34887);
  }
  
  public final void aBT(int paramInt)
  {
    AppMethodBeat.i(34885);
    int i = paramInt;
    if (paramInt >= 100) {
      i = 100;
    }
    this.startAngle = ((int)(i / 100.0F * 360.0F));
    jqg();
    AppMethodBeat.o(34885);
  }
  
  public final int getProgress()
  {
    return (int)(this.startAngle / 360.0F * 100.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(34886);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    this.mPaint.setColor(this.mContext.getResources().getColor(R.e.fkV));
    this.mPaint.setStrokeWidth(this.yzQ);
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
    this.mPaint.setColor(this.mContext.getResources().getColor(R.e.fkU));
    paramCanvas.drawArc(localRectF, i, 360 - this.startAngle, false, this.mPaint);
    AppMethodBeat.o(34886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar
 * JD-Core Version:    0.7.0.1
 */