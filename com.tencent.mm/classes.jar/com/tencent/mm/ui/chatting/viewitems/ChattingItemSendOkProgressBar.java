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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static SoftReference<Bitmap> POA;
  private static int POG;
  private static int POH;
  private static SoftReference<Bitmap> POy;
  private static SoftReference<Bitmap> POz;
  private Bitmap POB = null;
  private Bitmap POC = null;
  private Bitmap POD = null;
  private boolean POE = false;
  private a POF = null;
  private int POu = 0;
  private int POv = 0;
  private boolean POw = false;
  private boolean POx = false;
  private boolean iTN = false;
  private float rotation = 0.0F;
  
  static
  {
    AppMethodBeat.i(37374);
    POy = null;
    POz = null;
    POA = null;
    POG = 0;
    POH = 0;
    POG = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    POH = a.fromDPToPix(MMApplicationContext.getContext(), 6);
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
    return this.POF;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37373);
    if (!this.POE)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(37373);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.POB.getWidth(), this.POB.getHeight()), 255, 31);
    if (this.iTN)
    {
      if (!this.POw)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.POx))
        {
          this.POw = true;
          invalidate();
          AppMethodBeat.o(37373);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.POB.getWidth() / 2, this.POB.getHeight() / 2);
        paramCanvas.drawBitmap(this.POB, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      if (this.POu <= this.POC.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.POB.getWidth() / 2, this.POB.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.POB, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.POB.getWidth(), this.POB.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.POu, this.POC.getHeight());
        localObject2 = new Rect(POG, POH, this.POu + POG, this.POC.getHeight() + POH);
        paramCanvas.drawBitmap(this.POC, (Rect)localObject1, (Rect)localObject2, null);
        this.POu += 2;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      localObject1 = new Rect(0, 0, this.POC.getWidth(), this.POC.getHeight());
      localObject2 = new Rect(POG, POH, this.POC.getWidth() + POG, this.POC.getHeight() + POH);
      paramCanvas.drawBitmap(this.POC, (Rect)localObject1, (Rect)localObject2, null);
      if (this.POv < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.POv);
        paramCanvas.drawBitmap(this.POD, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.POv += 20;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      paramCanvas.drawBitmap(this.POD, (Rect)localObject1, (Rect)localObject2, null);
      this.iTN = false;
      this.rotation = 0.0F;
      this.POu = 0;
      this.POv = 0;
      this.POx = false;
      this.POw = false;
      AppMethodBeat.o(37373);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.POD.getWidth(), this.POD.getHeight());
    Object localObject2 = new Rect(POG, POH, this.POD.getWidth() + POG, this.POD.getHeight() + POH);
    paramCanvas.drawBitmap(this.POD, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(37373);
  }
  
  public void setDrawListener(a parama)
  {
    this.POF = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */