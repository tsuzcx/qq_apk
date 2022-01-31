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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class i
  extends BitmapDrawable
  implements d.a
{
  protected static final Paint dPt;
  protected static final ah dPu = new ah(Looper.getMainLooper());
  private Runnable dPw;
  private Paint gaZ = new Paint();
  protected boolean mlm = false;
  protected final a nav;
  protected boolean rZV = false;
  private int rZW = 0;
  private int rZX = 0;
  protected boolean rZY;
  protected boolean rZZ;
  private Rect rect = new Rect();
  protected float saa = 1.0F;
  private PaintFlagsDrawFilter sab = new PaintFlagsDrawFilter(0, 3);
  private Path sac;
  protected String tag;
  
  static
  {
    Paint localPaint = new Paint();
    dPt = localPaint;
    localPaint.setAntiAlias(true);
    dPt.setFilterBitmap(true);
  }
  
  public i(a parama, String paramString)
  {
    super(parama.sG());
    this.gaZ.setStyle(Paint.Style.STROKE);
    this.gaZ.setFlags(1);
    this.gaZ.setAntiAlias(true);
    this.sac = new Path();
    this.dPw = new Runnable()
    {
      public final void run()
      {
        i.this.invalidateSelf();
      }
    };
    this.nav = parama;
    this.tag = paramString;
    this.nav.a(this);
  }
  
  public i(a parama, String paramString, byte paramByte)
  {
    super(parama.sG());
    this.gaZ.setStyle(Paint.Style.STROKE);
    this.gaZ.setFlags(1);
    this.gaZ.setAntiAlias(true);
    this.sac = new Path();
    this.dPw = new Runnable()
    {
      public final void run()
      {
        i.this.invalidateSelf();
      }
    };
    this.mlm = false;
    this.nav = parama;
    this.tag = paramString;
    this.nav.a(this);
  }
  
  public final void Wt(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    while (paramString.equals(this.tag)) {
      return;
    }
    this.tag = paramString;
    dPu.post(this.dPw);
  }
  
  public final void cmj()
  {
    this.rZY = true;
  }
  
  public final void cmk()
  {
    if (!this.rZY) {}
    do
    {
      return;
      this.rZY = false;
    } while (!this.rZZ);
    this.rZZ = false;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap;
    if (this.rZV)
    {
      localBitmap = this.nav.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label204;
      }
      localBitmap = this.nav.sG();
      if (!this.rZY) {
        break label196;
      }
      this.rZZ = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.saa > 1.0F) || (this.mlm))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, dPt);
      return;
      if (this.rZY)
      {
        localBitmap = this.nav.ci(this.tag);
        break;
      }
      localBitmap = this.nav.ch(this.tag);
      break;
      label196:
      this.rZZ = false;
      continue;
      label204:
      this.rZZ = false;
    }
  }
  
  public void kk(String paramString)
  {
    if ((paramString == null) || (!paramString.equals(this.tag))) {
      return;
    }
    y.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    dPu.post(this.dPw);
  }
  
  public final void lP(boolean paramBoolean)
  {
    this.rZV = paramBoolean;
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.rZY = true;
      return;
    }
    cmk();
  }
  
  public static abstract interface a
  {
    public abstract void a(i parami);
    
    public abstract Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract Bitmap ch(String paramString);
    
    public abstract Bitmap ci(String paramString);
    
    public abstract Bitmap sG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */