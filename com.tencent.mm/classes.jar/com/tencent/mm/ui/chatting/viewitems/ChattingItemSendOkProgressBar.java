package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static SoftReference<Bitmap> aeVl;
  private static SoftReference<Bitmap> aeVm;
  private static SoftReference<Bitmap> aeVn;
  private static int aeVt;
  private static int aeVu;
  private int aeVh = 0;
  private int aeVi = 0;
  private boolean aeVj = false;
  private boolean aeVk = false;
  private Bitmap aeVo = null;
  private Bitmap aeVp = null;
  private Bitmap aeVq = null;
  private boolean aeVr = false;
  private a aeVs = null;
  private boolean oCI = false;
  private float rotation = 0.0F;
  
  static
  {
    AppMethodBeat.i(37374);
    aeVl = null;
    aeVm = null;
    aeVn = null;
    aeVt = 0;
    aeVu = 0;
    aeVt = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    aeVu = a.fromDPToPix(MMApplicationContext.getContext(), 6);
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
    return this.aeVs;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37373);
    if (!this.aeVr)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(37373);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.aeVo.getWidth(), this.aeVo.getHeight()), 255, 31);
    if (this.oCI)
    {
      if (!this.aeVj)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.aeVk))
        {
          this.aeVj = true;
          invalidate();
          AppMethodBeat.o(37373);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.aeVo.getWidth() / 2, this.aeVo.getHeight() / 2);
        paramCanvas.drawBitmap(this.aeVo, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      if (this.aeVh <= this.aeVp.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.aeVo.getWidth() / 2, this.aeVo.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.aeVo, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.aeVo.getWidth(), this.aeVo.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.aeVh, this.aeVp.getHeight());
        localObject2 = new Rect(aeVt, aeVu, this.aeVh + aeVt, this.aeVp.getHeight() + aeVu);
        paramCanvas.drawBitmap(this.aeVp, (Rect)localObject1, (Rect)localObject2, null);
        this.aeVh += 2;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      localObject1 = new Rect(0, 0, this.aeVp.getWidth(), this.aeVp.getHeight());
      localObject2 = new Rect(aeVt, aeVu, this.aeVp.getWidth() + aeVt, this.aeVp.getHeight() + aeVu);
      paramCanvas.drawBitmap(this.aeVp, (Rect)localObject1, (Rect)localObject2, null);
      if (this.aeVi < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.aeVi);
        paramCanvas.drawBitmap(this.aeVq, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.aeVi += 20;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      paramCanvas.drawBitmap(this.aeVq, (Rect)localObject1, (Rect)localObject2, null);
      this.oCI = false;
      this.rotation = 0.0F;
      this.aeVh = 0;
      this.aeVi = 0;
      this.aeVk = false;
      this.aeVj = false;
      AppMethodBeat.o(37373);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.aeVq.getWidth(), this.aeVq.getHeight());
    Object localObject2 = new Rect(aeVt, aeVu, this.aeVq.getWidth() + aeVt, this.aeVq.getHeight() + aeVu);
    paramCanvas.drawBitmap(this.aeVq, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(37373);
  }
  
  public void setDrawListener(a parama)
  {
    this.aeVs = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */