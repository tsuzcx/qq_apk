package com.tencent.mm.wear.app.emoji.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.h;
import java.io.InputStream;

public final class b
  extends Drawable
  implements Animatable
{
  private boolean abY = true;
  private boolean abZ = false;
  private volatile long aca;
  private final int[] acb = new int[6];
  private float acc = 1.0F;
  private float acd = 1.0F;
  private boolean ace;
  private final Rect acf = new Rect();
  private int[] acg;
  private int ach = 0;
  private int aci = -1;
  private float acj;
  private long ack = 0L;
  private long acl = 0L;
  private long acm = 0L;
  private long acn = 0L;
  private long aco;
  private long acp = 0L;
  private com.tencent.mm.wear.a.b.a acq = new com.tencent.mm.wear.a.b.a();
  private final Runnable acr = new Runnable()
  {
    public final void run()
    {
      if (((b.this.isRunning()) || (b.a(b.this) == 0)) && (SystemClock.uptimeMillis() >= b.b(b.this)))
      {
        b.a(b.this, System.currentTimeMillis());
        b.this.invalidateSelf();
      }
    }
  };
  private final com.tencent.mm.wear.app.g.a acs = new com.tencent.mm.wear.app.g.a()
  {
    protected final void execute()
    {
      MMGIFJNI.restoreRemainder(b.c(b.this));
      b.a(b.this, b.d(b.this), b.e(b.this));
    }
    
    protected final String getName()
    {
      return "StartTask";
    }
  };
  private final com.tencent.mm.wear.app.g.a act = new com.tencent.mm.wear.app.g.a()
  {
    protected final void execute()
    {
      MMGIFJNI.reset(b.c(b.this));
    }
    
    protected final String getName()
    {
      return "ResetTask";
    }
  };
  private final com.tencent.mm.wear.app.g.a acu = new com.tencent.mm.wear.app.g.a()
  {
    protected final void execute()
    {
      MMGIFJNI.saveRemainder(b.c(b.this));
    }
    
    protected final String getName()
    {
      return "SaveRemainderTask";
    }
  };
  private final Runnable acv = new Runnable()
  {
    public final void run()
    {
      long l1 = 0L;
      long l2 = System.currentTimeMillis();
      if (b.a(b.this) + 1 > b.f(b.this) - 1) {
        b.a(b.this, -1);
      }
      b.a(b.this, b.a(b.this) + 1);
      MMGIFJNI.drawFramePixels(b.c(b.this), b.g(b.this), b.h(b.this));
      b.b(b.this, System.currentTimeMillis() - l2);
      if (b.i(b.this) != 0L)
      {
        b.c(b.this, b.i(b.this) - b.j(b.this) - b.k(b.this));
        if (b.e(b.this) < 0L) {
          d.e("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(b.j(b.this)), Long.valueOf(b.k(b.this)), Long.valueOf(b.e(b.this)), Long.valueOf(b.i(b.this)), Integer.valueOf(b.h(b.this)[5]) });
        }
      }
      b localb = b.this;
      Runnable localRunnable = b.d(b.this);
      if (b.e(b.this) > 0L) {
        l1 = b.e(b.this);
      }
      b.a(localb, localRunnable, l1);
      b.d(b.this, b.h(b.this)[4]);
    }
  };
  private final Paint nC = new Paint(6);
  
  private b(AssetFileDescriptor paramAssetFileDescriptor)
  {
    if (paramAssetFileDescriptor == null) {
      throw new NullPointerException("assert file descritptor is null.");
    }
    this.aca = MMGIFJNI.openByFileDescroptor(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), this.acb);
    mC();
  }
  
  public b(Resources paramResources, int paramInt)
  {
    this(paramResources.openRawResourceFd(paramInt));
  }
  
  public b(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      throw new NullPointerException("input stream is null.");
    }
    this.aca = MMGIFJNI.openByInputStrem(paramInputStream, this.acb);
    mC();
  }
  
  public b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file path is null.");
    }
    this.aca = MMGIFJNI.openByFilePath(paramString, this.acb);
    mC();
  }
  
  public b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes is null.");
    }
    d.c("MicroMsg.GIF.MMGIFDrawable", "MMGIFDrawable: openByByteArray", new Object[0]);
    this.aca = MMGIFJNI.openByByteArray(paramArrayOfByte, this.acb);
    mC();
  }
  
  private void mC()
  {
    d.c("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.aca) });
    this.ach = this.acb[2];
    this.acg = new int[this.acb[0] * this.acb[1]];
    this.acj = com.tencent.mm.f.a.w(MMApplication.getContext());
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.ace)
    {
      this.acf.set(getBounds());
      this.acc = (this.acf.width() / this.acb[0]);
      this.acd = (this.acf.height() / this.acb[1]);
      this.ace = false;
    }
    if (this.nC.getShader() == null)
    {
      if (this.acn == 0L) {
        this.acn = System.currentTimeMillis();
      }
      paramCanvas.scale(this.acc, this.acd);
      int[] arrayOfInt = this.acg;
      if (arrayOfInt != null) {
        paramCanvas.drawBitmap(arrayOfInt, 0, this.acb[0], 0.0F, 0.0F, this.acb[0], this.acb[1], true, this.nC);
      }
      for (;;)
      {
        this.aco = (System.currentTimeMillis() - this.acn);
        if ((this.acb[4] < 0) || (this.acb[2] <= 0)) {
          break;
        }
        h.mf().e(this.acv);
        return;
        d.a("MicroMsg.GIF.MMGIFDrawable", "colors is null.", new Object[0]);
      }
      d.a("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post", new Object[] { Integer.valueOf(this.acb[2]), Integer.valueOf(this.acb[4]) });
      return;
    }
    d.c("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ", new Object[0]);
    paramCanvas.drawRect(this.acf, this.nC);
  }
  
  protected final void finalize()
  {
    try
    {
      stop();
      recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)(this.acb[1] * this.acj);
  }
  
  public final int getIntrinsicWidth()
  {
    return (int)(this.acb[0] * this.acj);
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final boolean isRunning()
  {
    return this.abY;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.ace = true;
  }
  
  public final void pause()
  {
    this.abY = false;
  }
  
  public final void recycle()
  {
    d.e("MicroMsg.GIF.MMGIFDrawable", "recycle", new Object[0]);
    this.abZ = true;
    this.abY = false;
    long l = this.aca;
    this.aca = 0L;
    MMGIFJNI.recycle(l);
    this.acg = null;
  }
  
  public final void reset()
  {
    this.abZ = false;
    this.abY = true;
    com.tencent.mm.wear.a.b.a.aiT.postDelayed(this.act, 300L);
  }
  
  public final void setAlpha(int paramInt)
  {
    this.nC.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.nC.setColorFilter(paramColorFilter);
  }
  
  public final void start()
  {
    this.abY = true;
    h.mf().e(this.acs);
  }
  
  public final void stop()
  {
    d.e("MicroMsg.GIF.MMGIFDrawable", "stop", new Object[0]);
    this.abY = false;
    h.mf().e(this.acu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.gif.b
 * JD-Core Version:    0.7.0.1
 */