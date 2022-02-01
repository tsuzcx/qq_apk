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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static SoftReference<Bitmap> XkA;
  private static SoftReference<Bitmap> XkB;
  private static int XkH;
  private static int XkI;
  private static SoftReference<Bitmap> Xkz;
  private Bitmap XkC = null;
  private Bitmap XkD = null;
  private Bitmap XkE = null;
  private boolean XkF = false;
  private a XkG = null;
  private int Xkv = 0;
  private int Xkw = 0;
  private boolean Xkx = false;
  private boolean Xky = false;
  private boolean lKg = false;
  private float rotation = 0.0F;
  
  static
  {
    AppMethodBeat.i(37374);
    Xkz = null;
    XkA = null;
    XkB = null;
    XkH = 0;
    XkI = 0;
    XkH = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    XkI = a.fromDPToPix(MMApplicationContext.getContext(), 6);
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
    return this.XkG;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37373);
    if (!this.XkF)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(37373);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.XkC.getWidth(), this.XkC.getHeight()), 255, 31);
    if (this.lKg)
    {
      if (!this.Xkx)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.Xky))
        {
          this.Xkx = true;
          invalidate();
          AppMethodBeat.o(37373);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.XkC.getWidth() / 2, this.XkC.getHeight() / 2);
        paramCanvas.drawBitmap(this.XkC, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      if (this.Xkv <= this.XkD.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.XkC.getWidth() / 2, this.XkC.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.XkC, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.XkC.getWidth(), this.XkC.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.Xkv, this.XkD.getHeight());
        localObject2 = new Rect(XkH, XkI, this.Xkv + XkH, this.XkD.getHeight() + XkI);
        paramCanvas.drawBitmap(this.XkD, (Rect)localObject1, (Rect)localObject2, null);
        this.Xkv += 2;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      localObject1 = new Rect(0, 0, this.XkD.getWidth(), this.XkD.getHeight());
      localObject2 = new Rect(XkH, XkI, this.XkD.getWidth() + XkH, this.XkD.getHeight() + XkI);
      paramCanvas.drawBitmap(this.XkD, (Rect)localObject1, (Rect)localObject2, null);
      if (this.Xkw < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.Xkw);
        paramCanvas.drawBitmap(this.XkE, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.Xkw += 20;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      paramCanvas.drawBitmap(this.XkE, (Rect)localObject1, (Rect)localObject2, null);
      this.lKg = false;
      this.rotation = 0.0F;
      this.Xkv = 0;
      this.Xkw = 0;
      this.Xky = false;
      this.Xkx = false;
      AppMethodBeat.o(37373);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.XkE.getWidth(), this.XkE.getHeight());
    Object localObject2 = new Rect(XkH, XkI, this.XkE.getWidth() + XkH, this.XkE.getHeight() + XkI);
    paramCanvas.drawBitmap(this.XkE, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(37373);
  }
  
  public void setDrawListener(a parama)
  {
    this.XkG = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */