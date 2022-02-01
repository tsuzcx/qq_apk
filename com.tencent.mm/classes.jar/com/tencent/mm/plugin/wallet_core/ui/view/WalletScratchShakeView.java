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
  private a InA;
  b Inx;
  boolean Iny;
  boolean Inz;
  
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
    if (this.Inx != null)
    {
      b localb = this.Inx;
      Log.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.cBo();
      }
    }
    AppMethodBeat.o(71547);
  }
  
  public void setScratchShakeCallback(a parama)
  {
    this.InA = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fTW();
    
    public abstract void yy(boolean paramBoolean);
  }
  
  final class b
    extends View
  {
    private Bitmap Ehf;
    private Canvas InB;
    Drawable InC;
    Paint InD;
    Paint InE;
    Path InF;
    Path InG;
    private float InH;
    private float InI;
    private int[] InJ;
    private int InK = -1;
    boolean InL;
    boolean InM;
    float InN;
    float InO;
    int InP;
    private boolean InQ;
    boolean InR;
    private float InS = 0.9F;
    Paint aYz;
    private boolean isStartShake = false;
    long lastShakeTime;
    private int meh = 0;
    int rZ;
    d shakeSensor;
    
    public b(Context paramContext)
    {
      super();
    }
    
    static byte[] aD(Bitmap paramBitmap)
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
    
    private boolean fTX()
    {
      AppMethodBeat.i(71539);
      if (this.InO >= getHeight())
      {
        this.InR = true;
        if (!this.InM)
        {
          if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
            WalletScratchShakeView.a(WalletScratchShakeView.this).fTW();
          }
          this.InM = true;
        }
        if (this.InB != null)
        {
          this.InG.reset();
          this.InG.moveTo(0.0F, 0.0F);
          this.InG.lineTo(getWidth(), 0.0F);
          this.InG.lineTo(getWidth(), getHeight());
          this.InG.lineTo(0.0F, getHeight());
          this.InB.drawPath(this.InG, this.InE);
        }
        invalidate();
        AppMethodBeat.o(71539);
        return true;
      }
      AppMethodBeat.o(71539);
      return false;
    }
    
    private void fTY()
    {
      AppMethodBeat.i(71540);
      if (this.InB != null)
      {
        this.InG.reset();
        this.InG.moveTo(0.0F, this.InO);
        this.InG.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.InN);
        this.InG.lineTo(getWidth(), 0.0F);
        this.InG.lineTo(0.0F, 0.0F);
        this.InB.drawPath(this.InG, this.InE);
      }
      invalidate();
      AppMethodBeat.o(71540);
    }
    
    public final boolean ae(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71543);
      if ((this.Ehf != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
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
          if (this.Ehf.getPixel(k, m) == 0)
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
      if (this.Ehf == null)
      {
        int i = getWidth();
        int j = getHeight();
        Log.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.InC });
        this.Ehf = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.InB = new Canvas(this.Ehf);
        if (this.InC != null)
        {
          Rect localRect = new Rect(0, 0, i, j);
          this.InC.setBounds(localRect);
          this.InC.draw(this.InB);
        }
        this.InJ = new int[i * j];
      }
      paramCanvas.drawBitmap(this.Ehf, 0.0F, 0.0F, this.aYz);
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
      while ((!this.InR) && (!ae(paramMotionEvent)) && (i != 0))
      {
        AppMethodBeat.o(71542);
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.InF.reset();
        this.InF.moveTo(f1, f2);
        this.InH = f1;
        this.InI = f2;
        invalidate();
        if (!this.InL)
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71535);
              if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.this).yy(true);
              }
              AppMethodBeat.o(71535);
            }
          }, 50L);
          this.InL = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.InB != null)
          {
            i = (int)Math.abs(f1 - this.InH);
            j = (int)Math.abs(f2 - this.InI);
            if ((i >= this.rZ) || (j >= this.rZ))
            {
              this.InH = f1;
              this.InI = f2;
              this.InF.quadTo((this.InH + f1) / 2.0F, (this.InI + f2) / 2.0F, f1, f2);
              this.InB.drawPath(this.InF, this.InD);
              this.InF.reset();
              this.InF.moveTo(this.InH, this.InI);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.InH = 0.0F;
          this.InI = 0.0F;
          this.InF.reset();
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