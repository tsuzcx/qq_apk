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
import com.tencent.mm.sdk.platformtools.ao;

class SendDataToDeviceProgressBar
  extends ImageView
{
  private int bottom;
  private ao gox;
  private int left;
  private Context mContext;
  private Paint mPaint;
  private int pGo;
  private int pGp;
  private Runnable pGq;
  private int rPJ;
  private int right;
  private int top;
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(34884);
    this.pGo = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.pGp = -1;
    this.rPJ = 10;
    this.pGq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34883);
        SendDataToDeviceProgressBar.this.invalidate();
        AppMethodBeat.o(34883);
      }
    };
    setImageResource(2131233688);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = this.mContext.getResources().getDimensionPixelSize(2131166783);
    this.top = this.left;
    this.pGp = this.mContext.getResources().getDimensionPixelSize(2131166784);
    this.gox = new ao(Looper.getMainLooper());
    AppMethodBeat.o(34884);
  }
  
  private void flQ()
  {
    AppMethodBeat.i(34887);
    this.gox.removeCallbacks(this.pGq);
    this.gox.postDelayed(this.pGq, 0L);
    AppMethodBeat.o(34887);
  }
  
  public final void aaN(int paramInt)
  {
    AppMethodBeat.i(34885);
    int i = paramInt;
    if (paramInt >= 100) {
      i = 100;
    }
    this.pGo = ((int)(i / 100.0F * 360.0F));
    flQ();
    AppMethodBeat.o(34885);
  }
  
  public final int getProgress()
  {
    return (int)(this.pGo / 360.0F * 100.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(34886);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    this.mPaint.setColor(this.mContext.getResources().getColor(2131100770));
    this.mPaint.setStrokeWidth(this.pGp);
    if (this.right == -1) {
      this.right = (i * 2 - this.left);
    }
    if (this.bottom == -1) {
      this.bottom = this.right;
    }
    RectF localRectF = new RectF(this.left, this.top, this.right, this.bottom);
    paramCanvas.drawArc(localRectF, 270.0F, this.pGo, false, this.mPaint);
    int j = this.pGo + 270;
    i = j;
    if (j > 360) {
      i = j - 360;
    }
    this.mPaint.setColor(this.mContext.getResources().getColor(2131100767));
    paramCanvas.drawArc(localRectF, i, 360 - this.pGo, false, this.mPaint);
    AppMethodBeat.o(34886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar
 * JD-Core Version:    0.7.0.1
 */