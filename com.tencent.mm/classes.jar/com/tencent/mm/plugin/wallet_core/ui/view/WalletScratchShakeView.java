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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView
  extends FrameLayout
{
  b DEl;
  boolean DEm;
  boolean DEn;
  private a DEo;
  
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
    if (this.DEl != null)
    {
      b localb = this.DEl;
      ae.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.cdt();
      }
    }
    AppMethodBeat.o(71547);
  }
  
  public void setScratchShakeCallback(a parama)
  {
    this.DEo = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eMp();
    
    public abstract void uK(boolean paramBoolean);
  }
  
  final class b
    extends View
  {
    boolean DEA;
    float DEB;
    float DEC;
    int DED;
    private boolean DEE;
    boolean DEF;
    private float DEG = 0.9F;
    private Canvas DEp;
    Drawable DEq;
    Paint DEr;
    Paint DEs;
    Path DEt;
    Path DEu;
    private float DEv;
    private float DEw;
    private int[] DEx;
    private int DEy = -1;
    boolean DEz;
    Paint aYE;
    private boolean isStartShake = false;
    private int kYU = 0;
    long lastShakeTime;
    int rW;
    d shakeSensor;
    private Bitmap zYO;
    
    public b(Context paramContext)
    {
      super();
    }
    
    static byte[] ar(Bitmap paramBitmap)
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
    
    private boolean eMq()
    {
      AppMethodBeat.i(71539);
      if (this.DEC >= getHeight())
      {
        this.DEF = true;
        if (!this.DEA)
        {
          if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
            WalletScratchShakeView.a(WalletScratchShakeView.this).eMp();
          }
          this.DEA = true;
        }
        if (this.DEp != null)
        {
          this.DEu.reset();
          this.DEu.moveTo(0.0F, 0.0F);
          this.DEu.lineTo(getWidth(), 0.0F);
          this.DEu.lineTo(getWidth(), getHeight());
          this.DEu.lineTo(0.0F, getHeight());
          this.DEp.drawPath(this.DEu, this.DEs);
        }
        invalidate();
        AppMethodBeat.o(71539);
        return true;
      }
      AppMethodBeat.o(71539);
      return false;
    }
    
    private void eMr()
    {
      AppMethodBeat.i(71540);
      if (this.DEp != null)
      {
        this.DEu.reset();
        this.DEu.moveTo(0.0F, this.DEC);
        this.DEu.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.DEB);
        this.DEu.lineTo(getWidth(), 0.0F);
        this.DEu.lineTo(0.0F, 0.0F);
        this.DEp.drawPath(this.DEu, this.DEs);
      }
      invalidate();
      AppMethodBeat.o(71540);
    }
    
    public final boolean X(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71543);
      if ((this.zYO != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
      {
        int i = getWidth();
        int j = getHeight();
        int k = (int)paramMotionEvent.getX();
        int m = (int)paramMotionEvent.getY();
        int n = m * i + k;
        int i1 = getWidth();
        int i2 = getHeight();
        ae.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1 * i2) });
        if ((n > 0) && (k > 0) && (m > 0) && (k < getWidth()) && (m < getHeight()))
        {
          if (this.zYO.getPixel(k, m) == 0)
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
      if (this.zYO == null)
      {
        int i = getWidth();
        int j = getHeight();
        ae.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.DEq });
        this.zYO = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.DEp = new Canvas(this.zYO);
        if (this.DEq != null)
        {
          Rect localRect = new Rect(0, 0, i, j);
          this.DEq.setBounds(localRect);
          this.DEq.draw(this.DEp);
        }
        this.DEx = new int[i * j];
      }
      paramCanvas.drawBitmap(this.zYO, 0.0F, 0.0F, this.aYE);
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
      while ((!this.DEF) && (!X(paramMotionEvent)) && (i != 0))
      {
        AppMethodBeat.o(71542);
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.DEt.reset();
        this.DEt.moveTo(f1, f2);
        this.DEv = f1;
        this.DEw = f2;
        invalidate();
        if (!this.DEz)
        {
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71535);
              if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.this).uK(true);
              }
              AppMethodBeat.o(71535);
            }
          }, 50L);
          this.DEz = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.DEp != null)
          {
            i = (int)Math.abs(f1 - this.DEv);
            j = (int)Math.abs(f2 - this.DEw);
            if ((i >= this.rW) || (j >= this.rW))
            {
              this.DEv = f1;
              this.DEw = f2;
              this.DEt.quadTo((this.DEv + f1) / 2.0F, (this.DEw + f2) / 2.0F, f1, f2);
              this.DEp.drawPath(this.DEt, this.DEr);
              this.DEt.reset();
              this.DEt.moveTo(this.DEv, this.DEw);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.DEv = 0.0F;
          this.DEw = 0.0F;
          this.DEt.reset();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView
 * JD-Core Version:    0.7.0.1
 */