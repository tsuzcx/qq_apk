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
import com.tencent.mm.pluginsdk.j.d;
import com.tencent.mm.pluginsdk.j.d.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView
  extends FrameLayout
{
  b BMp;
  boolean BMq;
  boolean BMr;
  private a BMs;
  
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
    if (this.BMp != null)
    {
      b localb = this.BMp;
      ac.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.bXB();
      }
    }
    AppMethodBeat.o(71547);
  }
  
  public void setScratchShakeCallback(a parama)
  {
    this.BMs = parama;
  }
  
  public static abstract interface a
  {
    public abstract void euB();
    
    public abstract void tS(boolean paramBoolean);
  }
  
  final class b
    extends View
  {
    private float BMA;
    private int[] BMB;
    private int BMC = -1;
    boolean BMD;
    boolean BME;
    float BMF;
    float BMG;
    int BMH;
    private boolean BMI;
    boolean BMJ;
    private float BMK = 0.9F;
    private Canvas BMt;
    Drawable BMu;
    Paint BMv;
    Paint BMw;
    Path BMx;
    Path BMy;
    private float BMz;
    Paint aOk;
    private boolean isStartShake = false;
    private int kzc = 0;
    long lastShakeTime;
    int qc;
    d shakeSensor;
    private Bitmap yqx;
    
    public b(Context paramContext)
    {
      super();
    }
    
    static byte[] ao(Bitmap paramBitmap)
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
    
    private boolean euC()
    {
      AppMethodBeat.i(71539);
      if (this.BMG >= getHeight())
      {
        this.BMJ = true;
        if (!this.BME)
        {
          if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
            WalletScratchShakeView.a(WalletScratchShakeView.this).euB();
          }
          this.BME = true;
        }
        if (this.BMt != null)
        {
          this.BMy.reset();
          this.BMy.moveTo(0.0F, 0.0F);
          this.BMy.lineTo(getWidth(), 0.0F);
          this.BMy.lineTo(getWidth(), getHeight());
          this.BMy.lineTo(0.0F, getHeight());
          this.BMt.drawPath(this.BMy, this.BMw);
        }
        invalidate();
        AppMethodBeat.o(71539);
        return true;
      }
      AppMethodBeat.o(71539);
      return false;
    }
    
    private void euD()
    {
      AppMethodBeat.i(71540);
      if (this.BMt != null)
      {
        this.BMy.reset();
        this.BMy.moveTo(0.0F, this.BMG);
        this.BMy.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.BMF);
        this.BMy.lineTo(getWidth(), 0.0F);
        this.BMy.lineTo(0.0F, 0.0F);
        this.BMt.drawPath(this.BMy, this.BMw);
      }
      invalidate();
      AppMethodBeat.o(71540);
    }
    
    public final boolean X(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71543);
      if ((this.yqx != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
      {
        int i = getWidth();
        int j = getHeight();
        int k = (int)paramMotionEvent.getX();
        int m = (int)paramMotionEvent.getY();
        int n = m * i + k;
        int i1 = getWidth();
        int i2 = getHeight();
        ac.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1 * i2) });
        if ((n > 0) && (k > 0) && (m > 0) && (k < getWidth()) && (m < getHeight()))
        {
          if (this.yqx.getPixel(k, m) == 0)
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
      if (this.yqx == null)
      {
        int i = getWidth();
        int j = getHeight();
        ac.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.BMu });
        this.yqx = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.BMt = new Canvas(this.yqx);
        if (this.BMu != null)
        {
          Rect localRect = new Rect(0, 0, i, j);
          this.BMu.setBounds(localRect);
          this.BMu.draw(this.BMt);
        }
        this.BMB = new int[i * j];
      }
      paramCanvas.drawBitmap(this.yqx, 0.0F, 0.0F, this.aOk);
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
      while ((!this.BMJ) && (!X(paramMotionEvent)) && (i != 0))
      {
        AppMethodBeat.o(71542);
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.BMx.reset();
        this.BMx.moveTo(f1, f2);
        this.BMz = f1;
        this.BMA = f2;
        invalidate();
        if (!this.BMD)
        {
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71535);
              if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.this).tS(true);
              }
              AppMethodBeat.o(71535);
            }
          }, 50L);
          this.BMD = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.BMt != null)
          {
            i = (int)Math.abs(f1 - this.BMz);
            j = (int)Math.abs(f2 - this.BMA);
            if ((i >= this.qc) || (j >= this.qc))
            {
              this.BMz = f1;
              this.BMA = f2;
              this.BMx.quadTo((this.BMz + f1) / 2.0F, (this.BMA + f2) / 2.0F, f1, f2);
              this.BMt.drawPath(this.BMx, this.BMv);
              this.BMx.reset();
              this.BMx.moveTo(this.BMz, this.BMA);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.BMz = 0.0F;
          this.BMA = 0.0F;
          this.BMx.reset();
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