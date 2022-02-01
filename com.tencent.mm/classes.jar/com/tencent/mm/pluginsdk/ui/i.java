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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public class i
  extends BitmapDrawable
  implements d.a
{
  protected static final ao hfE;
  protected boolean DnM;
  private int DnN;
  private int DnO;
  protected boolean DnP;
  protected float DnQ;
  private PaintFlagsDrawFilter DnR;
  protected final Paint hfD;
  private Runnable hfG;
  private Path jZ;
  private Paint paint;
  private Rect rect;
  protected String tag;
  protected boolean uNY;
  protected final a vQR;
  protected boolean wDv;
  
  static
  {
    AppMethodBeat.i(152146);
    hfE = new ao(Looper.getMainLooper());
    AppMethodBeat.o(152146);
  }
  
  public i(a parama, String paramString)
  {
    super(parama.Kj());
    AppMethodBeat.i(152139);
    this.hfD = new Paint();
    this.uNY = false;
    this.DnM = false;
    this.DnN = 0;
    this.DnO = 0;
    this.DnQ = 1.0F;
    this.rect = new Rect();
    this.DnR = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.jZ = new Path();
    this.hfG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        i.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.hfD.setAntiAlias(true);
    this.hfD.setFilterBitmap(true);
    this.vQR = parama;
    this.tag = paramString;
    this.vQR.a(this);
    AppMethodBeat.o(152139);
  }
  
  public i(a parama, String paramString, byte paramByte)
  {
    super(parama.Kj());
    AppMethodBeat.i(152140);
    this.hfD = new Paint();
    this.uNY = false;
    this.DnM = false;
    this.DnN = 0;
    this.DnO = 0;
    this.DnQ = 1.0F;
    this.rect = new Rect();
    this.DnR = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.jZ = new Path();
    this.hfG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        i.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.hfD.setAntiAlias(true);
    this.hfD.setFilterBitmap(true);
    this.uNY = false;
    this.vQR = parama;
    this.tag = paramString;
    this.vQR.a(this);
    AppMethodBeat.o(152140);
  }
  
  public void Af(String paramString)
  {
    AppMethodBeat.i(152143);
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    ac.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    hfE.post(this.hfG);
    AppMethodBeat.o(152143);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152142);
    Bitmap localBitmap;
    if (this.DnM)
    {
      localBitmap = this.vQR.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.vQR.Kj();
      if (!this.DnP) {
        break label207;
      }
      this.wDv = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.DnQ > 1.0F) || (this.uNY))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.hfD);
      AppMethodBeat.o(152142);
      return;
      if (this.DnP)
      {
        localBitmap = this.vQR.em(this.tag);
        break;
      }
      localBitmap = this.vQR.el(this.tag);
      break;
      label207:
      this.wDv = false;
      continue;
      label215:
      this.wDv = false;
    }
  }
  
  public final void eMM()
  {
    this.DnP = true;
  }
  
  public final void eMN()
  {
    AppMethodBeat.i(152144);
    if (!this.DnP)
    {
      AppMethodBeat.o(152144);
      return;
    }
    this.DnP = false;
    if (this.wDv)
    {
      this.wDv = false;
      invalidateSelf();
    }
    AppMethodBeat.o(152144);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(152145);
    if (paramBoolean)
    {
      this.DnP = true;
      AppMethodBeat.o(152145);
      return;
    }
    eMN();
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
      hfE.post(this.hfG);
    }
    AppMethodBeat.o(152141);
  }
  
  public final void uX(boolean paramBoolean)
  {
    this.DnM = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Kj();
    
    public abstract Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(i parami);
    
    public abstract Bitmap el(String paramString);
    
    public abstract Bitmap em(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */