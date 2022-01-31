package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class WalletScratchShakeView$b
  extends View
{
  Paint aqq;
  private int gwv = 0;
  long iam;
  int kYl;
  c mBT;
  private Bitmap maskBitmap;
  private boolean qHX = false;
  private float qIA;
  private float qIB;
  private int[] qIC;
  private int qID = -1;
  boolean qIE;
  boolean qIF;
  float qIG;
  float qIH;
  int qII;
  private boolean qIJ;
  boolean qIK;
  private float qIL = 0.9F;
  private Canvas qIu;
  Drawable qIv;
  Paint qIw;
  Paint qIx;
  Path qIy;
  Path qIz;
  
  public WalletScratchShakeView$b(WalletScratchShakeView paramWalletScratchShakeView, Context paramContext)
  {
    super(paramContext);
  }
  
  static byte[] N(Bitmap paramBitmap)
  {
    int i = 0;
    int[] arrayOfInt1 = new int[4];
    arrayOfInt1[0] = 30;
    arrayOfInt1[1] = (paramBitmap.getWidth() / 3);
    arrayOfInt1[2] = (paramBitmap.getWidth() - paramBitmap.getWidth() / 3);
    arrayOfInt1[3] = (paramBitmap.getWidth() - 30);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = paramBitmap.getHeight();
    paramBitmap = ByteBuffer.allocate(92).order(ByteOrder.nativeOrder());
    paramBitmap.put((byte)1);
    paramBitmap.put((byte)4);
    paramBitmap.put((byte)2);
    paramBitmap.put((byte)9);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(arrayOfInt1[0]);
    paramBitmap.putInt(arrayOfInt1[1]);
    paramBitmap.putInt(arrayOfInt1[2]);
    paramBitmap.putInt(arrayOfInt1[3]);
    paramBitmap.putInt(arrayOfInt2[0]);
    paramBitmap.putInt(arrayOfInt2[1]);
    while (i < 9)
    {
      paramBitmap.putInt(1);
      i += 1;
    }
    return paramBitmap.array();
  }
  
  private boolean bXm()
  {
    if (this.qIH >= getHeight())
    {
      this.qIK = true;
      if (!this.qIF)
      {
        if (WalletScratchShakeView.a(this.qIM) != null) {
          WalletScratchShakeView.a(this.qIM).bXl();
        }
        this.qIF = true;
      }
      if (this.qIu != null)
      {
        this.qIz.reset();
        this.qIz.moveTo(0.0F, 0.0F);
        this.qIz.lineTo(getWidth(), 0.0F);
        this.qIz.lineTo(getWidth(), getHeight());
        this.qIz.lineTo(0.0F, getHeight());
        this.qIu.drawPath(this.qIz, this.qIx);
      }
      invalidate();
      return true;
    }
    return false;
  }
  
  private void bXn()
  {
    if (this.qIu != null)
    {
      this.qIz.reset();
      this.qIz.moveTo(0.0F, this.qIH);
      this.qIz.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.qIG);
      this.qIz.lineTo(getWidth(), 0.0F);
      this.qIz.lineTo(0.0F, 0.0F);
      this.qIu.drawPath(this.qIz, this.qIx);
    }
    invalidate();
  }
  
  public final boolean F(MotionEvent paramMotionEvent)
  {
    if ((this.maskBitmap != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
    {
      int i = getWidth();
      int j = getHeight();
      int k = (int)paramMotionEvent.getX();
      int m = (int)paramMotionEvent.getY();
      int n = m * i + k;
      int i1 = getWidth();
      int i2 = getHeight();
      y.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1 * i2) });
      if ((n > 0) && (k > 0) && (m > 0) && (k < getWidth()) && (m < getHeight())) {
        return this.maskBitmap.getPixel(k, m) == 0;
      }
    }
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.maskBitmap == null)
    {
      int i = getWidth();
      int j = getHeight();
      y.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.qIv });
      this.maskBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.qIu = new Canvas(this.maskBitmap);
      if (this.qIv != null)
      {
        Rect localRect = new Rect(0, 0, i, j);
        this.qIv.setBounds(localRect);
        this.qIv.draw(this.qIu);
      }
      this.qIC = new int[i * j];
    }
    paramCanvas.drawBitmap(this.maskBitmap, 0.0F, 0.0F, this.aqq);
    paramCanvas.restore();
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!WalletScratchShakeView.b(this.qIM)) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      int j = paramMotionEvent.getAction();
      int i = 0;
      switch (j)
      {
      }
      while ((this.qIK) || (F(paramMotionEvent)) || (i == 0))
      {
        return super.onTouchEvent(paramMotionEvent);
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.qIy.reset();
        this.qIy.moveTo(f1, f2);
        this.qIA = f1;
        this.qIB = f2;
        invalidate();
        if (!this.qIE)
        {
          ai.l(new Runnable()
          {
            public final void run()
            {
              if (WalletScratchShakeView.a(WalletScratchShakeView.b.this.qIM) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.b.this.qIM).kN(true);
              }
            }
          }, 50L);
          this.qIE = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.qIu != null)
          {
            i = (int)Math.abs(f1 - this.qIA);
            j = (int)Math.abs(f2 - this.qIB);
            if ((i >= this.kYl) || (j >= this.kYl))
            {
              this.qIA = f1;
              this.qIB = f2;
              this.qIy.quadTo((this.qIA + f1) / 2.0F, (this.qIB + f2) / 2.0F, f1, f2);
              this.qIu.drawPath(this.qIy, this.qIw);
              this.qIy.reset();
              this.qIy.moveTo(this.qIA, this.qIB);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.qIA = 0.0F;
          this.qIB = 0.0F;
          this.qIy.reset();
          e.post(new Runnable()
          {
            public final void run()
            {
              WalletScratchShakeView.b.e(WalletScratchShakeView.b.this);
            }
          }, "ScratchShakeView_calcErasePercentAndCallEnd");
          invalidate();
        }
        else
        {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b
 * JD-Core Version:    0.7.0.1
 */