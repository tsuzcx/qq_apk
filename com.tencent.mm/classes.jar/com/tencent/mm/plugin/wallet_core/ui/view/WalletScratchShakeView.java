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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView
  extends FrameLayout
{
  b VWD;
  boolean VWE;
  boolean VWF;
  private a VWG;
  
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
    if (this.VWD != null)
    {
      b localb = this.VWD;
      Log.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.cuD();
      }
    }
    AppMethodBeat.o(71547);
  }
  
  public void setScratchShakeCallback(a parama)
  {
    this.VWG = parama;
  }
  
  public static abstract interface a
  {
    public abstract void HY(boolean paramBoolean);
    
    public abstract void ilQ();
  }
  
  final class b
    extends View
  {
    private Bitmap QSM;
    private Canvas VWH;
    Drawable VWI;
    Paint VWJ;
    Paint VWK;
    Path VWL;
    Path VWM;
    private float VWN;
    private float VWO;
    private int[] VWP;
    private int VWQ = -1;
    boolean VWR;
    boolean VWS;
    float VWT;
    float VWU;
    int VWV;
    private boolean VWW;
    boolean VWX;
    private float VWY = 0.9F;
    Paint bitmapPaint;
    int doK;
    private boolean isStartShake = false;
    long lastShakeTime;
    d shakeSensor;
    private int shn = 0;
    
    public b(Context paramContext)
    {
      super();
    }
    
    static byte[] aS(Bitmap paramBitmap)
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
    
    private boolean ilR()
    {
      AppMethodBeat.i(71539);
      if (this.VWU >= getHeight())
      {
        this.VWX = true;
        if (!this.VWS)
        {
          if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
            WalletScratchShakeView.a(WalletScratchShakeView.this).ilQ();
          }
          this.VWS = true;
        }
        if (this.VWH != null)
        {
          this.VWM.reset();
          this.VWM.moveTo(0.0F, 0.0F);
          this.VWM.lineTo(getWidth(), 0.0F);
          this.VWM.lineTo(getWidth(), getHeight());
          this.VWM.lineTo(0.0F, getHeight());
          this.VWH.drawPath(this.VWM, this.VWK);
        }
        invalidate();
        AppMethodBeat.o(71539);
        return true;
      }
      AppMethodBeat.o(71539);
      return false;
    }
    
    private void ilS()
    {
      AppMethodBeat.i(71540);
      if (this.VWH != null)
      {
        this.VWM.reset();
        this.VWM.moveTo(0.0F, this.VWU);
        this.VWM.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.VWT);
        this.VWM.lineTo(getWidth(), 0.0F);
        this.VWM.lineTo(0.0F, 0.0F);
        this.VWH.drawPath(this.VWM, this.VWK);
      }
      invalidate();
      AppMethodBeat.o(71540);
    }
    
    public final boolean aq(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71543);
      if ((this.QSM != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
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
          if (this.QSM.getPixel(k, m) == 0)
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
      if (this.QSM == null)
      {
        int i = getWidth();
        int j = getHeight();
        Log.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.VWI });
        this.QSM = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.VWH = new Canvas(this.QSM);
        if (this.VWI != null)
        {
          Rect localRect = new Rect(0, 0, i, j);
          this.VWI.setBounds(localRect);
          this.VWI.draw(this.VWH);
        }
        this.VWP = new int[i * j];
      }
      paramCanvas.drawBitmap(this.QSM, 0.0F, 0.0F, this.bitmapPaint);
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
      while ((!this.VWX) && (!aq(paramMotionEvent)) && (i != 0))
      {
        AppMethodBeat.o(71542);
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.VWL.reset();
        this.VWL.moveTo(f1, f2);
        this.VWN = f1;
        this.VWO = f2;
        invalidate();
        if (!this.VWR)
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71535);
              if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.this).HY(true);
              }
              AppMethodBeat.o(71535);
            }
          }, 50L);
          this.VWR = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.VWH != null)
          {
            i = (int)Math.abs(f1 - this.VWN);
            j = (int)Math.abs(f2 - this.VWO);
            if ((i >= this.doK) || (j >= this.doK))
            {
              this.VWN = f1;
              this.VWO = f2;
              this.VWL.quadTo((this.VWN + f1) / 2.0F, (this.VWO + f2) / 2.0F, f1, f2);
              this.VWH.drawPath(this.VWL, this.VWJ);
              this.VWL.reset();
              this.VWL.moveTo(this.VWN, this.VWO);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.VWN = 0.0F;
          this.VWO = 0.0F;
          this.VWL.reset();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView
 * JD-Core Version:    0.7.0.1
 */