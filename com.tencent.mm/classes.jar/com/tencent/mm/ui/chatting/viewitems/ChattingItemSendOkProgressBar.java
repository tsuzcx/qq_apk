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
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static SoftReference<Bitmap> zWE;
  private static SoftReference<Bitmap> zWF;
  private static SoftReference<Bitmap> zWG;
  private static int zWM;
  private static int zWN;
  private boolean fAK = false;
  private float rotation = 0.0F;
  private int zWA = 0;
  private int zWB = 0;
  private boolean zWC = false;
  private boolean zWD = false;
  private Bitmap zWH = null;
  private Bitmap zWI = null;
  private Bitmap zWJ = null;
  private boolean zWK = false;
  private a zWL = null;
  
  static
  {
    AppMethodBeat.i(33278);
    zWE = null;
    zWF = null;
    zWG = null;
    zWM = 0;
    zWN = 0;
    zWM = a.fromDPToPix(ah.getContext(), 1);
    zWN = a.fromDPToPix(ah.getContext(), 6);
    AppMethodBeat.o(33278);
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
    return this.zWL;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33277);
    if (!this.zWK)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(33277);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.zWH.getWidth(), this.zWH.getHeight()), 255, 31);
    if (this.fAK)
    {
      if (!this.zWC)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.zWD))
        {
          this.zWC = true;
          invalidate();
          AppMethodBeat.o(33277);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.zWH.getWidth() / 2, this.zWH.getHeight() / 2);
        paramCanvas.drawBitmap(this.zWH, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(33277);
        return;
      }
      if (this.zWA <= this.zWI.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.zWH.getWidth() / 2, this.zWH.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.zWH, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.zWH.getWidth(), this.zWH.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.zWA, this.zWI.getHeight());
        localObject2 = new Rect(zWM, zWN, this.zWA + zWM, this.zWI.getHeight() + zWN);
        paramCanvas.drawBitmap(this.zWI, (Rect)localObject1, (Rect)localObject2, null);
        this.zWA += 2;
        invalidate();
        AppMethodBeat.o(33277);
        return;
      }
      localObject1 = new Rect(0, 0, this.zWI.getWidth(), this.zWI.getHeight());
      localObject2 = new Rect(zWM, zWN, this.zWI.getWidth() + zWM, this.zWI.getHeight() + zWN);
      paramCanvas.drawBitmap(this.zWI, (Rect)localObject1, (Rect)localObject2, null);
      if (this.zWB < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.zWB);
        paramCanvas.drawBitmap(this.zWJ, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.zWB += 20;
        invalidate();
        AppMethodBeat.o(33277);
        return;
      }
      paramCanvas.drawBitmap(this.zWJ, (Rect)localObject1, (Rect)localObject2, null);
      this.fAK = false;
      this.rotation = 0.0F;
      this.zWA = 0;
      this.zWB = 0;
      this.zWD = false;
      this.zWC = false;
      AppMethodBeat.o(33277);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.zWJ.getWidth(), this.zWJ.getHeight());
    Object localObject2 = new Rect(zWM, zWN, this.zWJ.getWidth() + zWM, this.zWJ.getHeight() + zWN);
    paramCanvas.drawBitmap(this.zWJ, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(33277);
  }
  
  public void setDrawListener(a parama)
  {
    this.zWL = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */