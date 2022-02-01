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
import com.tencent.mm.pluginsdk.m.d;
import com.tencent.mm.pluginsdk.m.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView
  extends FrameLayout
{
  b PfP;
  boolean PfQ;
  boolean PfR;
  private a PfS;
  
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
    if (this.PfP != null)
    {
      b localb = this.PfP;
      Log.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.cPS();
      }
    }
    AppMethodBeat.o(71547);
  }
  
  public void setScratchShakeCallback(a parama)
  {
    this.PfS = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Ct(boolean paramBoolean);
    
    public abstract void gMC();
  }
  
  final class b
    extends View
  {
    private Bitmap Kum;
    private Canvas PfT;
    Drawable PfU;
    Paint PfV;
    Paint PfW;
    Path PfX;
    Path PfY;
    private float PfZ;
    private float Pga;
    private int[] Pgb;
    private int Pgc = -1;
    boolean Pgd;
    boolean Pge;
    float Pgf;
    float Pgg;
    int Pgh;
    private boolean Pgi;
    boolean Pgj;
    private float Pgk = 0.9F;
    Paint aHU;
    int bvH;
    private boolean isStartShake = false;
    long lastShakeTime;
    private int pbZ = 0;
    d shakeSensor;
    
    public b(Context paramContext)
    {
      super();
    }
    
    static byte[] aA(Bitmap paramBitmap)
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
    
    private boolean gMD()
    {
      AppMethodBeat.i(71539);
      if (this.Pgg >= getHeight())
      {
        this.Pgj = true;
        if (!this.Pge)
        {
          if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
            WalletScratchShakeView.a(WalletScratchShakeView.this).gMC();
          }
          this.Pge = true;
        }
        if (this.PfT != null)
        {
          this.PfY.reset();
          this.PfY.moveTo(0.0F, 0.0F);
          this.PfY.lineTo(getWidth(), 0.0F);
          this.PfY.lineTo(getWidth(), getHeight());
          this.PfY.lineTo(0.0F, getHeight());
          this.PfT.drawPath(this.PfY, this.PfW);
        }
        invalidate();
        AppMethodBeat.o(71539);
        return true;
      }
      AppMethodBeat.o(71539);
      return false;
    }
    
    private void gME()
    {
      AppMethodBeat.i(71540);
      if (this.PfT != null)
      {
        this.PfY.reset();
        this.PfY.moveTo(0.0F, this.Pgg);
        this.PfY.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.Pgf);
        this.PfY.lineTo(getWidth(), 0.0F);
        this.PfY.lineTo(0.0F, 0.0F);
        this.PfT.drawPath(this.PfY, this.PfW);
      }
      invalidate();
      AppMethodBeat.o(71540);
    }
    
    public final boolean an(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71543);
      if ((this.Kum != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
      {
        int i = getWidth();
        int j = getHeight();
        int k = (int)paramMotionEvent.getX();
        int m = (int)paramMotionEvent.getY();
        int n = m * i + k;
        int i1 = getWidth();
        int i2 = getHeight();
        Log.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1 * i2) });
        if ((n > 0) && (k > 0) && (m > 0) && (k < getWidth()) && (m < getHeight()))
        {
          if (this.Kum.getPixel(k, m) == 0)
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
      if (this.Kum == null)
      {
        int i = getWidth();
        int j = getHeight();
        Log.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.PfU });
        this.Kum = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.PfT = new Canvas(this.Kum);
        if (this.PfU != null)
        {
          Rect localRect = new Rect(0, 0, i, j);
          this.PfU.setBounds(localRect);
          this.PfU.draw(this.PfT);
        }
        this.Pgb = new int[i * j];
      }
      paramCanvas.drawBitmap(this.Kum, 0.0F, 0.0F, this.aHU);
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
      while ((!this.Pgj) && (!an(paramMotionEvent)) && (i != 0))
      {
        AppMethodBeat.o(71542);
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.PfX.reset();
        this.PfX.moveTo(f1, f2);
        this.PfZ = f1;
        this.Pga = f2;
        invalidate();
        if (!this.Pgd)
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71535);
              if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.this).Ct(true);
              }
              AppMethodBeat.o(71535);
            }
          }, 50L);
          this.Pgd = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.PfT != null)
          {
            i = (int)Math.abs(f1 - this.PfZ);
            j = (int)Math.abs(f2 - this.Pga);
            if ((i >= this.bvH) || (j >= this.bvH))
            {
              this.PfZ = f1;
              this.Pga = f2;
              this.PfX.quadTo((this.PfZ + f1) / 2.0F, (this.Pga + f2) / 2.0F, f1, f2);
              this.PfT.drawPath(this.PfX, this.PfV);
              this.PfX.reset();
              this.PfX.moveTo(this.PfZ, this.Pga);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.PfZ = 0.0F;
          this.Pga = 0.0F;
          this.PfX.reset();
          ThreadPool.post(new Runnable()
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