package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class i
  extends BitmapDrawable
  implements d.a
{
  protected static final ap gFd;
  private PaintFlagsDrawFilter BVA;
  protected boolean BVv;
  private int BVw;
  private int BVx;
  protected boolean BVy;
  protected float BVz;
  protected final Paint gFc;
  private Runnable gFf;
  private Path ja;
  private Paint paint;
  private Rect rect;
  protected boolean tFD;
  protected String tag;
  protected final a uIa;
  protected boolean vtv;
  
  static
  {
    AppMethodBeat.i(152146);
    gFd = new ap(Looper.getMainLooper());
    AppMethodBeat.o(152146);
  }
  
  public i(a parama, String paramString)
  {
    super(parama.Ky());
    AppMethodBeat.i(152139);
    this.gFc = new Paint();
    this.tFD = false;
    this.BVv = false;
    this.BVw = 0;
    this.BVx = 0;
    this.BVz = 1.0F;
    this.rect = new Rect();
    this.BVA = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.ja = new Path();
    this.gFf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        i.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.gFc.setAntiAlias(true);
    this.gFc.setFilterBitmap(true);
    this.uIa = parama;
    this.tag = paramString;
    this.uIa.a(this);
    AppMethodBeat.o(152139);
  }
  
  public i(a parama, String paramString, byte paramByte)
  {
    super(parama.Ky());
    AppMethodBeat.i(152140);
    this.gFc = new Paint();
    this.tFD = false;
    this.BVv = false;
    this.BVw = 0;
    this.BVx = 0;
    this.BVz = 1.0F;
    this.rect = new Rect();
    this.BVA = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.ja = new Path();
    this.gFf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        i.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.gFc.setAntiAlias(true);
    this.gFc.setFilterBitmap(true);
    this.tFD = false;
    this.uIa = parama;
    this.tag = paramString;
    this.uIa.a(this);
    AppMethodBeat.o(152140);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152142);
    Bitmap localBitmap;
    if (this.BVv)
    {
      localBitmap = this.uIa.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.uIa.Ky();
      if (!this.BVy) {
        break label207;
      }
      this.vtv = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.BVz > 1.0F) || (this.tFD))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.gFc);
      AppMethodBeat.o(152142);
      return;
      if (this.BVy)
      {
        localBitmap = this.uIa.ex(this.tag);
        break;
      }
      localBitmap = this.uIa.ew(this.tag);
      break;
      label207:
      this.vtv = false;
      continue;
      label215:
      this.vtv = false;
    }
  }
  
  public final void exs()
  {
    this.BVy = true;
  }
  
  public final void ext()
  {
    AppMethodBeat.i(152144);
    if (!this.BVy)
    {
      AppMethodBeat.o(152144);
      return;
    }
    this.BVy = false;
    if (this.vtv)
    {
      this.vtv = false;
      invalidateSelf();
    }
    AppMethodBeat.o(152144);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(152145);
    if (paramBoolean)
    {
      this.BVy = true;
      AppMethodBeat.o(152145);
      return;
    }
    ext();
    AppMethodBeat.o(152145);
  }
  
  public final void setTag(String paramString)
  {
    AppMethodBeat.i(152141);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(152141);
      return;
    }
    if (!paramString.equals(this.tag))
    {
      this.tag = paramString;
      gFd.post(this.gFf);
    }
    AppMethodBeat.o(152141);
  }
  
  public final void tW(boolean paramBoolean)
  {
    this.BVv = paramBoolean;
  }
  
  public void vZ(String paramString)
  {
    AppMethodBeat.i(152143);
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    ad.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    gFd.post(this.gFf);
    AppMethodBeat.o(152143);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Ky();
    
    public abstract Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(i parami);
    
    public abstract Bitmap ew(String paramString);
    
    public abstract Bitmap ex(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */