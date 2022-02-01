package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.d.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView
  extends FrameLayout
{
  b DmH;
  boolean DmI;
  boolean DmJ;
  private a DmK;
  
  public WalletScratchShakeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WalletScratchShakeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(71547);
    if (this.DmH != null)
    {
      b localb = this.DmH;
      ad.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.cce();
      }
    }
    AppMethodBeat.o(71547);
  }
  
  public void setScratchShakeCallback(a parama)
  {
    this.DmK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eIH();
    
    public abstract void uC(boolean paramBoolean);
  }
  
  final class b
    extends View
  {
    private Canvas DmL;
    Drawable DmM;
    Paint DmN;
    Paint DmO;
    Path DmP;
    Path DmQ;
    private float DmR;
    private float DmS;
    private int[] DmT;
    private int DmU = -1;
    boolean DmV;
    boolean DmW;
    float DmX;
    float DmY;
    int DmZ;
    private boolean Dna;
    boolean Dnb;
    private float Dnc = 0.9F;
    Paint aYE;
    private boolean isStartShake = false;
    private int kVm = 0;
    long lastShakeTime;
    int rW;
    d shakeSensor;
    private Bitmap zHH;
    
    public b(Context paramContext)
    {
      super();
    }
    
    static byte[] aq(Bitmap paramBitmap)
    {
      int i = 0;
      AppMethodBeat.i(71538);
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
      paramBitmap = paramBitmap.array();
      AppMethodBeat.o(71538);
      return paramBitmap;
    }
    
    private boolean eII()
    {
      AppMethodBeat.i(71539);
      if (this.DmY >= getHeight())
      {
        this.Dnb = true;
        if (!this.DmW)
        {
          if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
            WalletScratchShakeView.a(WalletScratchShakeView.this).eIH();
          }
          this.DmW = true;
        }
        if (this.DmL != null)
        {
          this.DmQ.reset();
          this.DmQ.moveTo(0.0F, 0.0F);
          this.DmQ.lineTo(getWidth(), 0.0F);
          this.DmQ.lineTo(getWidth(), getHeight());
          this.DmQ.lineTo(0.0F, getHeight());
          this.DmL.drawPath(this.DmQ, this.DmO);
        }
        invalidate();
        AppMethodBeat.o(71539);
        return true;
      }
      AppMethodBeat.o(71539);
      return false;
    }
    
    private void eIJ()
    {
      AppMethodBeat.i(71540);
      if (this.DmL != null)
      {
        this.DmQ.reset();
        this.DmQ.moveTo(0.0F, this.DmY);
        this.DmQ.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.DmX);
        this.DmQ.lineTo(getWidth(), 0.0F);
        this.DmQ.lineTo(0.0F, 0.0F);
        this.DmL.drawPath(this.DmQ, this.DmO);
      }
      invalidate();
      AppMethodBeat.o(71540);
    }
    
    public final boolean Z(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71543);
      if ((this.zHH != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
      {
        int i = getWidth();
        int j = getHeight();
        int k = (int)paramMotionEvent.getX();
        int m = (int)paramMotionEvent.getY();
        int n = m * i + k;
        int i1 = getWidth();
        int i2 = getHeight();
        ad.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1 * i2) });
        if ((n > 0) && (k > 0) && (m > 0) && (k < getWidth()) && (m < getHeight()))
        {
          if (this.zHH.getPixel(k, m) == 0)
          {
            AppMethodBeat.o(71543);
            return true;
          }
          AppMethodBeat.o(71543);
          return false;
        }
      }
      AppMethodBeat.o(71543);
      return false;
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(71541);
      paramCanvas.save();
      if (this.zHH == null)
      {
        int i = getWidth();
        int j = getHeight();
        ad.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.DmM });
        this.zHH = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.DmL = new Canvas(this.zHH);
        if (this.DmM != null)
        {
          Rect localRect = new Rect(0, 0, i, j);
          this.DmM.setBounds(localRect);
          this.DmM.draw(this.DmL);
        }
        this.DmT = new int[i * j];
      }
      paramCanvas.drawBitmap(this.zHH, 0.0F, 0.0F, this.aYE);
      paramCanvas.restore();
      AppMethodBeat.o(71541);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71542);
      if (!WalletScratchShakeView.b(WalletScratchShakeView.this))
      {
        bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(71542);
        return bool;
      }
      int j = paramMotionEvent.getAction();
      int i = 0;
      switch (j)
      {
      }
      while ((!this.Dnb) && (!Z(paramMotionEvent)) && (i != 0))
      {
        AppMethodBeat.o(71542);
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.DmP.reset();
        this.DmP.moveTo(f1, f2);
        this.DmR = f1;
        this.DmS = f2;
        invalidate();
        if (!this.DmV)
        {
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71535);
              if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.this).uC(true);
              }
              AppMethodBeat.o(71535);
            }
          }, 50L);
          this.DmV = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.DmL != null)
          {
            i = (int)Math.abs(f1 - this.DmR);
            j = (int)Math.abs(f2 - this.DmS);
            if ((i >= this.rW) || (j >= this.rW))
            {
              this.DmR = f1;
              this.DmS = f2;
              this.DmP.quadTo((this.DmR + f1) / 2.0F, (this.DmS + f2) / 2.0F, f1, f2);
              this.DmL.drawPath(this.DmP, this.DmN);
              this.DmP.reset();
              this.DmP.moveTo(this.DmR, this.DmS);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.DmR = 0.0F;
          this.DmS = 0.0F;
          this.DmP.reset();
          b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71536);
              WalletScratchShakeView.b.e(WalletScratchShakeView.b.this);
              AppMethodBeat.o(71536);
            }
          }, "ScratchShakeView_calcErasePercentAndCallEnd");
          invalidate();
        }
        else
        {
          i = 1;
        }
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(71542);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView
 * JD-Core Version:    0.7.0.1
 */