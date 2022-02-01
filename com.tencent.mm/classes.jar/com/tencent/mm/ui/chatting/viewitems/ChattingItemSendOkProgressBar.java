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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static int KfF;
  private static int KfG;
  private static SoftReference<Bitmap> Kfx;
  private static SoftReference<Bitmap> Kfy;
  private static SoftReference<Bitmap> Kfz;
  private Bitmap KfA = null;
  private Bitmap KfB = null;
  private Bitmap KfC = null;
  private boolean KfD = false;
  private a KfE = null;
  private int Kft = 0;
  private int Kfu = 0;
  private boolean Kfv = false;
  private boolean Kfw = false;
  private boolean hVX = false;
  private float rotation = 0.0F;
  
  static
  {
    AppMethodBeat.i(37374);
    Kfx = null;
    Kfy = null;
    Kfz = null;
    KfF = 0;
    KfG = 0;
    KfF = a.fromDPToPix(aj.getContext(), 1);
    KfG = a.fromDPToPix(aj.getContext(), 6);
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
    return this.KfE;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37373);
    if (!this.KfD)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(37373);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.KfA.getWidth(), this.KfA.getHeight()), 255, 31);
    if (this.hVX)
    {
      if (!this.Kfv)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.Kfw))
        {
          this.Kfv = true;
          invalidate();
          AppMethodBeat.o(37373);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.KfA.getWidth() / 2, this.KfA.getHeight() / 2);
        paramCanvas.drawBitmap(this.KfA, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      if (this.Kft <= this.KfB.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.KfA.getWidth() / 2, this.KfA.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.KfA, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.KfA.getWidth(), this.KfA.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.Kft, this.KfB.getHeight());
        localObject2 = new Rect(KfF, KfG, this.Kft + KfF, this.KfB.getHeight() + KfG);
        paramCanvas.drawBitmap(this.KfB, (Rect)localObject1, (Rect)localObject2, null);
        this.Kft += 2;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      localObject1 = new Rect(0, 0, this.KfB.getWidth(), this.KfB.getHeight());
      localObject2 = new Rect(KfF, KfG, this.KfB.getWidth() + KfF, this.KfB.getHeight() + KfG);
      paramCanvas.drawBitmap(this.KfB, (Rect)localObject1, (Rect)localObject2, null);
      if (this.Kfu < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.Kfu);
        paramCanvas.drawBitmap(this.KfC, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.Kfu += 20;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      paramCanvas.drawBitmap(this.KfC, (Rect)localObject1, (Rect)localObject2, null);
      this.hVX = false;
      this.rotation = 0.0F;
      this.Kft = 0;
      this.Kfu = 0;
      this.Kfw = false;
      this.Kfv = false;
      AppMethodBeat.o(37373);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.KfC.getWidth(), this.KfC.getHeight());
    Object localObject2 = new Rect(KfF, KfG, this.KfC.getWidth() + KfF, this.KfC.getHeight() + KfG);
    paramCanvas.drawBitmap(this.KfC, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(37373);
  }
  
  public void setDrawListener(a parama)
  {
    this.KfE = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */