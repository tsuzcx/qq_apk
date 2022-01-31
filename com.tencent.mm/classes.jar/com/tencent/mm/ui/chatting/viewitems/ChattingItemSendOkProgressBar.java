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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static int vFA = a.fromDPToPix(ae.getContext(), 6);
  private static SoftReference<Bitmap> vFr = null;
  private static SoftReference<Bitmap> vFs = null;
  private static SoftReference<Bitmap> vFt = null;
  private static int vFz = 0;
  private boolean eku = false;
  private float rotation = 0.0F;
  private int vFn = 0;
  private int vFo = 0;
  private boolean vFp = false;
  private boolean vFq = false;
  private Bitmap vFu = null;
  private Bitmap vFv = null;
  private Bitmap vFw = null;
  private boolean vFx = false;
  private a vFy = null;
  
  static
  {
    vFA = 0;
    vFz = a.fromDPToPix(ae.getContext(), 1);
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
    return this.vFy;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.vFx)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.vFu.getWidth(), this.vFu.getHeight()), 255, 31);
    if (this.eku)
    {
      if (!this.vFp)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.vFq))
        {
          this.vFp = true;
          invalidate();
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.vFu.getWidth() / 2, this.vFu.getHeight() / 2);
        paramCanvas.drawBitmap(this.vFu, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        return;
      }
      if (this.vFn <= this.vFv.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.vFu.getWidth() / 2, this.vFu.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.vFu, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.vFu.getWidth(), this.vFu.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.vFn, this.vFv.getHeight());
        localObject2 = new Rect(vFz, vFA, this.vFn + vFz, this.vFv.getHeight() + vFA);
        paramCanvas.drawBitmap(this.vFv, (Rect)localObject1, (Rect)localObject2, null);
        this.vFn += 2;
        invalidate();
        return;
      }
      localObject1 = new Rect(0, 0, this.vFv.getWidth(), this.vFv.getHeight());
      localObject2 = new Rect(vFz, vFA, this.vFv.getWidth() + vFz, this.vFv.getHeight() + vFA);
      paramCanvas.drawBitmap(this.vFv, (Rect)localObject1, (Rect)localObject2, null);
      if (this.vFo < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.vFo);
        paramCanvas.drawBitmap(this.vFw, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.vFo += 20;
        invalidate();
        return;
      }
      paramCanvas.drawBitmap(this.vFw, (Rect)localObject1, (Rect)localObject2, null);
      this.eku = false;
      this.rotation = 0.0F;
      this.vFn = 0;
      this.vFo = 0;
      this.vFq = false;
      this.vFp = false;
      return;
    }
    Object localObject1 = new Rect(0, 0, this.vFw.getWidth(), this.vFw.getHeight());
    Object localObject2 = new Rect(vFz, vFA, this.vFw.getWidth() + vFz, this.vFw.getHeight() + vFA);
    paramCanvas.drawBitmap(this.vFw, (Rect)localObject1, (Rect)localObject2, null);
  }
  
  public void setDrawListener(a parama)
  {
    this.vFy = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */