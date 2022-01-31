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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class WalletScratchShakeView$b
  extends View
{
  Paint asJ;
  private int hSq = 0;
  private boolean isStartShake = false;
  long lastShakeTime;
  private Bitmap maskBitmap;
  int nwj;
  com.tencent.mm.pluginsdk.i.d shakeSensor;
  private Canvas uxc;
  Drawable uxd;
  Paint uxe;
  Paint uxf;
  Path uxg;
  Path uxh;
  private float uxi;
  private float uxj;
  private int[] uxk;
  private int uxl = -1;
  boolean uxm;
  boolean uxn;
  float uxo;
  float uxp;
  int uxq;
  private boolean uxr;
  boolean uxs;
  private float uxt = 0.9F;
  
  public WalletScratchShakeView$b(WalletScratchShakeView paramWalletScratchShakeView, Context paramContext)
  {
    super(paramContext);
  }
  
  static byte[] ab(Bitmap paramBitmap)
  {
    int i = 0;
    AppMethodBeat.i(47928);
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
    AppMethodBeat.o(47928);
    return paramBitmap;
  }
  
  private boolean cWN()
  {
    AppMethodBeat.i(47929);
    if (this.uxp >= getHeight())
    {
      this.uxs = true;
      if (!this.uxn)
      {
        if (WalletScratchShakeView.a(this.uxu) != null) {
          WalletScratchShakeView.a(this.uxu).cWM();
        }
        this.uxn = true;
      }
      if (this.uxc != null)
      {
        this.uxh.reset();
        this.uxh.moveTo(0.0F, 0.0F);
        this.uxh.lineTo(getWidth(), 0.0F);
        this.uxh.lineTo(getWidth(), getHeight());
        this.uxh.lineTo(0.0F, getHeight());
        this.uxc.drawPath(this.uxh, this.uxf);
      }
      invalidate();
      AppMethodBeat.o(47929);
      return true;
    }
    AppMethodBeat.o(47929);
    return false;
  }
  
  private void cWO()
  {
    AppMethodBeat.i(47930);
    if (this.uxc != null)
    {
      this.uxh.reset();
      this.uxh.moveTo(0.0F, this.uxp);
      this.uxh.cubicTo(getWidth() / 2, getHeight(), getWidth() / 2, 0.0F, getWidth(), this.uxo);
      this.uxh.lineTo(getWidth(), 0.0F);
      this.uxh.lineTo(0.0F, 0.0F);
      this.uxc.drawPath(this.uxh, this.uxf);
    }
    invalidate();
    AppMethodBeat.o(47930);
  }
  
  public final boolean O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(47933);
    if ((this.maskBitmap != null) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 0)))
    {
      int i = getWidth();
      int j = getHeight();
      int k = (int)paramMotionEvent.getX();
      int m = (int)paramMotionEvent.getY();
      int n = m * i + k;
      int i1 = getWidth();
      int i2 = getHeight();
      ab.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1 * i2) });
      if ((n > 0) && (k > 0) && (m > 0) && (k < getWidth()) && (m < getHeight()))
      {
        if (this.maskBitmap.getPixel(k, m) == 0)
        {
          AppMethodBeat.o(47933);
          return true;
        }
        AppMethodBeat.o(47933);
        return false;
      }
    }
    AppMethodBeat.o(47933);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(47931);
    paramCanvas.save();
    if (this.maskBitmap == null)
    {
      int i = getWidth();
      int j = getHeight();
      ab.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.uxd });
      this.maskBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.uxc = new Canvas(this.maskBitmap);
      if (this.uxd != null)
      {
        Rect localRect = new Rect(0, 0, i, j);
        this.uxd.setBounds(localRect);
        this.uxd.draw(this.uxc);
      }
      this.uxk = new int[i * j];
    }
    paramCanvas.drawBitmap(this.maskBitmap, 0.0F, 0.0F, this.asJ);
    paramCanvas.restore();
    AppMethodBeat.o(47931);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(47932);
    if (!WalletScratchShakeView.b(this.uxu))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(47932);
      return bool;
    }
    int j = paramMotionEvent.getAction();
    int i = 0;
    switch (j)
    {
    }
    while ((!this.uxs) && (!O(paramMotionEvent)) && (i != 0))
    {
      AppMethodBeat.o(47932);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.uxg.reset();
      this.uxg.moveTo(f1, f2);
      this.uxi = f1;
      this.uxj = f2;
      invalidate();
      if (!this.uxm)
      {
        al.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47925);
            if (WalletScratchShakeView.a(WalletScratchShakeView.b.this.uxu) != null) {
              WalletScratchShakeView.a(WalletScratchShakeView.b.this.uxu).nW(true);
            }
            AppMethodBeat.o(47925);
          }
        }, 50L);
        this.uxm = true;
        i = 1;
        continue;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if (this.uxc != null)
        {
          i = (int)Math.abs(f1 - this.uxi);
          j = (int)Math.abs(f2 - this.uxj);
          if ((i >= this.nwj) || (j >= this.nwj))
          {
            this.uxi = f1;
            this.uxj = f2;
            this.uxg.quadTo((this.uxi + f1) / 2.0F, (this.uxj + f2) / 2.0F, f1, f2);
            this.uxc.drawPath(this.uxg, this.uxe);
            this.uxg.reset();
            this.uxg.moveTo(this.uxi, this.uxj);
          }
        }
        invalidate();
        i = 1;
        continue;
        this.uxi = 0.0F;
        this.uxj = 0.0F;
        this.uxg.reset();
        com.tencent.mm.sdk.g.d.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47926);
            WalletScratchShakeView.b.e(WalletScratchShakeView.b.this);
            AppMethodBeat.o(47926);
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
    AppMethodBeat.o(47932);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b
 * JD-Core Version:    0.7.0.1
 */