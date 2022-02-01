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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static SoftReference<Bitmap> GOV;
  private static SoftReference<Bitmap> GOW;
  private static SoftReference<Bitmap> GOX;
  private static int GPd;
  private static int GPe;
  private int GOR = 0;
  private int GOS = 0;
  private boolean GOT = false;
  private boolean GOU = false;
  private Bitmap GOY = null;
  private Bitmap GOZ = null;
  private Bitmap GPa = null;
  private boolean GPb = false;
  private a GPc = null;
  private boolean hcP = false;
  private float rotation = 0.0F;
  
  static
  {
    AppMethodBeat.i(37374);
    GOV = null;
    GOW = null;
    GOX = null;
    GPd = 0;
    GPe = 0;
    GPd = a.fromDPToPix(aj.getContext(), 1);
    GPe = a.fromDPToPix(aj.getContext(), 6);
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
    return this.GPc;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37373);
    if (!this.GPb)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(37373);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.GOY.getWidth(), this.GOY.getHeight()), 255, 31);
    if (this.hcP)
    {
      if (!this.GOT)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.GOU))
        {
          this.GOT = true;
          invalidate();
          AppMethodBeat.o(37373);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.GOY.getWidth() / 2, this.GOY.getHeight() / 2);
        paramCanvas.drawBitmap(this.GOY, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      if (this.GOR <= this.GOZ.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.GOY.getWidth() / 2, this.GOY.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.GOY, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.GOY.getWidth(), this.GOY.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.GOR, this.GOZ.getHeight());
        localObject2 = new Rect(GPd, GPe, this.GOR + GPd, this.GOZ.getHeight() + GPe);
        paramCanvas.drawBitmap(this.GOZ, (Rect)localObject1, (Rect)localObject2, null);
        this.GOR += 2;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      localObject1 = new Rect(0, 0, this.GOZ.getWidth(), this.GOZ.getHeight());
      localObject2 = new Rect(GPd, GPe, this.GOZ.getWidth() + GPd, this.GOZ.getHeight() + GPe);
      paramCanvas.drawBitmap(this.GOZ, (Rect)localObject1, (Rect)localObject2, null);
      if (this.GOS < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.GOS);
        paramCanvas.drawBitmap(this.GPa, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.GOS += 20;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      paramCanvas.drawBitmap(this.GPa, (Rect)localObject1, (Rect)localObject2, null);
      this.hcP = false;
      this.rotation = 0.0F;
      this.GOR = 0;
      this.GOS = 0;
      this.GOU = false;
      this.GOT = false;
      AppMethodBeat.o(37373);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.GPa.getWidth(), this.GPa.getHeight());
    Object localObject2 = new Rect(GPd, GPe, this.GPa.getWidth() + GPd, this.GPa.getHeight() + GPe);
    paramCanvas.drawBitmap(this.GPa, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(37373);
  }
  
  public void setDrawListener(a parama)
  {
    this.GPc = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */