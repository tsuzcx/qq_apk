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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView
  extends FrameLayout
{
  b AtV;
  boolean AtW;
  boolean AtX;
  private a AtY;
  
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
    if (this.AtV != null)
    {
      b localb = this.AtV;
      ad.i("MicroMsg.WalletScratchShakeView", "onDestroy");
      if (localb.shakeSensor != null) {
        localb.shakeSensor.bQk();
      }
    }
    AppMethodBeat.o(71547);
  }
  
  public void setScratchShakeCallback(a parama)
  {
    this.AtY = parama;
  }
  
  public static abstract interface a
  {
    public abstract void efg();
    
    public abstract void sR(boolean paramBoolean);
  }
  
  final class b
    extends View
  {
    private Canvas AtZ;
    Drawable Aua;
    Paint Aub;
    Paint Auc;
    Path Aud;
    Path Aue;
    private float Auf;
    private float Aug;
    private int[] Auh;
    private int Aui = -1;
    boolean Auj;
    boolean Auk;
    float Aul;
    float Aum;
    int Aun;
    private boolean Auo;
    boolean Aup;
    private float Auq = 0.9F;
    Paint aNu;
    private boolean isStartShake = false;
    private int jYq = 0;
    long lastShakeTime;
    int pd;
    d shakeSensor;
    private Bitmap xdI;
    
    public b(Context paramContext)
    {
      super();
    }
    
    static byte[] an(Bitmap paramBitmap)
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
    
    private boolean efh()
    {
      AppMethodBeat.i(71539);
      if (this.Aum >= getHeight())
      {
        this.Aup = true;
        if (!this.Auk)
        {
          if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
            WalletScratchShakeView.a(WalletScratchShakeView.this).efg();
          }
          this.Auk = true;
        }
        if (this.AtZ != null)
        {
          this.Aue.reset();
          this.Aue.moveTo(0.0F, 0.0F);
          this.Aue.lineTo(getWidth(), 0.0F);
          this.Aue.lineTo(getWidth(), getHeight());
          this.Aue.lineTo(0.0F, getHeight());
          this.AtZ.drawPath(this.Aue, this.Auc);
        }
        invalidate();
        AppMethodBeat.o(71539);
        return true;
      }
      AppMethodBeat.o(71539);
      return false;
    }
    
    private void efi()
    {
      AppMethodBeat.i(71540);
      if (this.AtZ != null)
      {
        this.Aue.reset();
        this.Aue.moveTo(0.0F, this.Aum);
        this.Aue.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.Aul);
        this.Aue.lineTo(getWidth(), 0.0F);
        this.Aue.lineTo(0.0F, 0.0F);
        this.AtZ.drawPath(this.Aue, this.Auc);
      }
      invalidate();
      AppMethodBeat.o(71540);
    }
    
    public final boolean X(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(71543);
      if ((this.xdI != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
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
          if (this.xdI.getPixel(k, m) == 0)
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
      if (this.xdI == null)
      {
        int i = getWidth();
        int j = getHeight();
        ad.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.Aua });
        this.xdI = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.AtZ = new Canvas(this.xdI);
        if (this.Aua != null)
        {
          Rect localRect = new Rect(0, 0, i, j);
          this.Aua.setBounds(localRect);
          this.Aua.draw(this.AtZ);
        }
        this.Auh = new int[i * j];
      }
      paramCanvas.drawBitmap(this.xdI, 0.0F, 0.0F, this.aNu);
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
      while ((!this.Aup) && (!X(paramMotionEvent)) && (i != 0))
      {
        AppMethodBeat.o(71542);
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.Aud.reset();
        this.Aud.moveTo(f1, f2);
        this.Auf = f1;
        this.Aug = f2;
        invalidate();
        if (!this.Auj)
        {
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(71535);
              if (WalletScratchShakeView.a(WalletScratchShakeView.this) != null) {
                WalletScratchShakeView.a(WalletScratchShakeView.this).sR(true);
              }
              AppMethodBeat.o(71535);
            }
          }, 50L);
          this.Auj = true;
          i = 1;
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if (this.AtZ != null)
          {
            i = (int)Math.abs(f1 - this.Auf);
            j = (int)Math.abs(f2 - this.Aug);
            if ((i >= this.pd) || (j >= this.pd))
            {
              this.Auf = f1;
              this.Aug = f2;
              this.Aud.quadTo((this.Auf + f1) / 2.0F, (this.Aug + f2) / 2.0F, f1, f2);
              this.AtZ.drawPath(this.Aud, this.Aub);
              this.Aud.reset();
              this.Aud.moveTo(this.Auf, this.Aug);
            }
          }
          invalidate();
          i = 1;
          continue;
          this.Auf = 0.0F;
          this.Aug = 0.0F;
          this.Aud.reset();
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