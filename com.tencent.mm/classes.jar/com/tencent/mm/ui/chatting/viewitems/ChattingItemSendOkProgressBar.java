package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static SoftReference<Bitmap> KBQ;
  private static SoftReference<Bitmap> KBR;
  private static SoftReference<Bitmap> KBS;
  private static int KBY;
  private static int KBZ;
  private int KBM = 0;
  private int KBN = 0;
  private boolean KBO = false;
  private boolean KBP = false;
  private Bitmap KBT = null;
  private Bitmap KBU = null;
  private Bitmap KBV = null;
  private boolean KBW = false;
  private a KBX = null;
  private boolean hYP = false;
  private float rotation = 0.0F;
  
  static
  {
    AppMethodBeat.i(37374);
    KBQ = null;
    KBR = null;
    KBS = null;
    KBY = 0;
    KBZ = 0;
    KBY = a.fromDPToPix(ak.getContext(), 1);
    KBZ = a.fromDPToPix(ak.getContext(), 6);
    AppMethodBeat.o(37374);
  }
  
  public ChattingItemSendOkProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChattingItemSendOkProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public a getDrawListener()
  {
    return this.KBX;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37373);
    if (!this.KBW)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(37373);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.KBT.getWidth(), this.KBT.getHeight()), 255, 31);
    if (this.hYP)
    {
      if (!this.KBO)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.KBP))
        {
          this.KBO = true;
          invalidate();
          AppMethodBeat.o(37373);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.KBT.getWidth() / 2, this.KBT.getHeight() / 2);
        paramCanvas.drawBitmap(this.KBT, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      if (this.KBM <= this.KBU.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.KBT.getWidth() / 2, this.KBT.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.KBT, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.KBT.getWidth(), this.KBT.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.KBM, this.KBU.getHeight());
        localObject2 = new Rect(KBY, KBZ, this.KBM + KBY, this.KBU.getHeight() + KBZ);
        paramCanvas.drawBitmap(this.KBU, (Rect)localObject1, (Rect)localObject2, null);
        this.KBM += 2;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      localObject1 = new Rect(0, 0, this.KBU.getWidth(), this.KBU.getHeight());
      localObject2 = new Rect(KBY, KBZ, this.KBU.getWidth() + KBY, this.KBU.getHeight() + KBZ);
      paramCanvas.drawBitmap(this.KBU, (Rect)localObject1, (Rect)localObject2, null);
      if (this.KBN < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.KBN);
        paramCanvas.drawBitmap(this.KBV, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.KBN += 20;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      paramCanvas.drawBitmap(this.KBV, (Rect)localObject1, (Rect)localObject2, null);
      this.hYP = false;
      this.rotation = 0.0F;
      this.KBM = 0;
      this.KBN = 0;
      this.KBP = false;
      this.KBO = false;
      AppMethodBeat.o(37373);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.KBV.getWidth(), this.KBV.getHeight());
    Object localObject2 = new Rect(KBY, KBZ, this.KBV.getWidth() + KBY, this.KBV.getHeight() + KBZ);
    paramCanvas.drawBitmap(this.KBV, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(37373);
  }
  
  public void setDrawListener(a parama)
  {
    this.KBX = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */