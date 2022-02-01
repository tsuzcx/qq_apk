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
  private boolean afA = false;
  private volatile long afB;
  private final int[] afC = new int[6];
  private float afD = 1.0F;
  private float afE = 1.0F;
  private boolean afF;
  private final Rect afG = new Rect();
  private int[] afH;
  private int afI = 0;
  private int afJ = -1;
  private float afK;
  private long afL = 0L;
  private long afM = 0L;
  private long afN = 0L;
  private long afO = 0L;
  private long afP;
  private long afQ = 0L;
  private com.tencent.mm.wear.a.b.a afR = new com.tencent.mm.wear.a.b.a();
  private final Runnable afS = new Runnable()
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
  private final com.tencent.mm.wear.app.g.a afT = new com.tencent.mm.wear.app.g.a()
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
  private final com.tencent.mm.wear.app.g.a afU = new com.tencent.mm.wear.app.g.a()
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
  private final com.tencent.mm.wear.app.g.a afV = new com.tencent.mm.wear.app.g.a()
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
  private final Runnable afW = new Runnable()
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
          d.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(b.j(b.this)), Long.valueOf(b.k(b.this)), Long.valueOf(b.e(b.this)), Long.valueOf(b.i(b.this)), Integer.valueOf(b.h(b.this)[5]) });
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
  private boolean afz = true;
  private final Paint pq = new Paint(6);
  
  private b(AssetFileDescriptor paramAssetFileDescriptor)
  {
    if (paramAssetFileDescriptor == null) {
      throw new NullPointerException("assert file descritptor is null.");
    }
    this.afB = MMGIFJNI.openByFileDescroptor(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), this.afC);
    no();
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
    this.afB = MMGIFJNI.openByInputStrem(paramInputStream, this.afC);
    no();
  }
  
  public b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file path is null.");
    }
    this.afB = MMGIFJNI.openByFilePath(paramString, this.afC);
    no();
  }
  
  public b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes is null.");
    }
    d.c("MicroMsg.GIF.MMGIFDrawable", "MMGIFDrawable: openByByteArray", new Object[0]);
    this.afB = MMGIFJNI.openByByteArray(paramArrayOfByte, this.afC);
    no();
  }
  
  private void no()
  {
    d.c("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.afB) });
    this.afI = this.afC[2];
    this.afH = new int[this.afC[0] * this.afC[1]];
    this.afK = com.tencent.mm.f.a.x(MMApplication.getContext());
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.afF)
    {
      this.afG.set(getBounds());
      this.afD = (this.afG.width() / this.afC[0]);
      this.afE = (this.afG.height() / this.afC[1]);
      this.afF = false;
    }
    if (this.pq.getShader() == null)
    {
      if (this.afO == 0L) {
        this.afO = System.currentTimeMillis();
      }
      paramCanvas.scale(this.afD, this.afE);
      int[] arrayOfInt = this.afH;
      if (arrayOfInt != null) {
        paramCanvas.drawBitmap(arrayOfInt, 0, this.afC[0], 0.0F, 0.0F, this.afC[0], this.afC[1], true, this.pq);
      }
      for (;;)
      {
        this.afP = (System.currentTimeMillis() - this.afO);
        if ((this.afC[4] < 0) || (this.afC[2] <= 0)) {
          break;
        }
        h.mS().o(this.afW);
        return;
        d.a("MicroMsg.GIF.MMGIFDrawable", "colors is null.", new Object[0]);
      }
      d.a("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post", new Object[] { Integer.valueOf(this.afC[2]), Integer.valueOf(this.afC[4]) });
      return;
    }
    d.c("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ", new Object[0]);
    paramCanvas.drawRect(this.afG, this.pq);
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
    return (int)(this.afC[1] * this.afK);
  }
  
  public final int getIntrinsicWidth()
  {
    return (int)(this.afC[0] * this.afK);
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final boolean isRunning()
  {
    return this.afz;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.afF = true;
  }
  
  public final void pause()
  {
    this.afz = false;
  }
  
  public final void recycle()
  {
    d.d("MicroMsg.GIF.MMGIFDrawable", "recycle", new Object[0]);
    this.afA = true;
    this.afz = false;
    long l = this.afB;
    this.afB = 0L;
    MMGIFJNI.recycle(l);
    this.afH = null;
  }
  
  public final void reset()
  {
    this.afA = false;
    this.afz = true;
    com.tencent.mm.wear.a.b.a.amv.postDelayed(this.afU, 300L);
  }
  
  public final void setAlpha(int paramInt)
  {
    this.pq.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.pq.setColorFilter(paramColorFilter);
  }
  
  public final void start()
  {
    this.afz = true;
    h.mS().o(this.afT);
  }
  
  public final void stop()
  {
    d.d("MicroMsg.GIF.MMGIFDrawable", "stop", new Object[0]);
    this.afz = false;
    h.mS().o(this.afV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.gif.b
 * JD-Core Version:    0.7.0.1
 */