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
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar
  extends ProgressBar
{
  private static SoftReference<Bitmap> IoX;
  private static SoftReference<Bitmap> IoY;
  private static SoftReference<Bitmap> IoZ;
  private static int Ipf;
  private static int Ipg;
  private int IoT = 0;
  private int IoU = 0;
  private boolean IoV = false;
  private boolean IoW = false;
  private Bitmap Ipa = null;
  private Bitmap Ipb = null;
  private Bitmap Ipc = null;
  private boolean Ipd = false;
  private a Ipe = null;
  private boolean hDs = false;
  private float rotation = 0.0F;
  
  static
  {
    AppMethodBeat.i(37374);
    IoX = null;
    IoY = null;
    IoZ = null;
    Ipf = 0;
    Ipg = 0;
    Ipf = a.fromDPToPix(ai.getContext(), 1);
    Ipg = a.fromDPToPix(ai.getContext(), 6);
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
    return this.Ipe;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37373);
    if (!this.Ipd)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(37373);
      return;
    }
    paramCanvas.saveLayerAlpha(new RectF(0.0F, 0.0F, this.Ipa.getWidth(), this.Ipa.getHeight()), 255, 31);
    if (this.hDs)
    {
      if (!this.IoV)
      {
        if (((int)(this.rotation - 270.0F) % 360 == 0) && (this.IoW))
        {
          this.IoV = true;
          invalidate();
          AppMethodBeat.o(37373);
          return;
        }
        localObject1 = new Matrix();
        ((Matrix)localObject1).setRotate(this.rotation, this.Ipa.getWidth() / 2, this.Ipa.getHeight() / 2);
        paramCanvas.drawBitmap(this.Ipa, (Matrix)localObject1, null);
        this.rotation += 6.0F;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      if (this.IoT <= this.Ipb.getWidth())
      {
        localObject1 = new Matrix();
        this.rotation += 6.0F;
        ((Matrix)localObject1).setRotate(this.rotation, this.Ipa.getWidth() / 2, this.Ipa.getHeight() / 2);
        int j = (int)this.rotation % 360;
        int i = j;
        if (j < 270) {
          i = j + 360;
        }
        if ((i >= 270) && (i < 450))
        {
          localObject2 = new Paint();
          ((Paint)localObject2).setColor(-16776961);
          paramCanvas.drawBitmap(this.Ipa, (Matrix)localObject1, (Paint)localObject2);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
          paramCanvas.drawRect(0.0F, 0.0F, this.Ipa.getWidth(), this.Ipa.getHeight() / 2, (Paint)localObject2);
        }
        localObject1 = new Rect(0, 0, this.IoT, this.Ipb.getHeight());
        localObject2 = new Rect(Ipf, Ipg, this.IoT + Ipf, this.Ipb.getHeight() + Ipg);
        paramCanvas.drawBitmap(this.Ipb, (Rect)localObject1, (Rect)localObject2, null);
        this.IoT += 2;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      localObject1 = new Rect(0, 0, this.Ipb.getWidth(), this.Ipb.getHeight());
      localObject2 = new Rect(Ipf, Ipg, this.Ipb.getWidth() + Ipf, this.Ipb.getHeight() + Ipg);
      paramCanvas.drawBitmap(this.Ipb, (Rect)localObject1, (Rect)localObject2, null);
      if (this.IoU < 255)
      {
        Paint localPaint = new Paint();
        localPaint.setAlpha(this.IoU);
        paramCanvas.drawBitmap(this.Ipc, (Rect)localObject1, (Rect)localObject2, localPaint);
        this.IoU += 20;
        invalidate();
        AppMethodBeat.o(37373);
        return;
      }
      paramCanvas.drawBitmap(this.Ipc, (Rect)localObject1, (Rect)localObject2, null);
      this.hDs = false;
      this.rotation = 0.0F;
      this.IoT = 0;
      this.IoU = 0;
      this.IoW = false;
      this.IoV = false;
      AppMethodBeat.o(37373);
      return;
    }
    Object localObject1 = new Rect(0, 0, this.Ipc.getWidth(), this.Ipc.getHeight());
    Object localObject2 = new Rect(Ipf, Ipg, this.Ipc.getWidth() + Ipf, this.Ipc.getHeight() + Ipg);
    paramCanvas.drawBitmap(this.Ipc, (Rect)localObject1, (Rect)localObject2, null);
    AppMethodBeat.o(37373);
  }
  
  public void setDrawListener(a parama)
  {
    this.Ipe = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar
 * JD-Core Version:    0.7.0.1
 */