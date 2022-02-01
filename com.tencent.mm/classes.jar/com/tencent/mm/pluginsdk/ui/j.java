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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public class j
  extends BitmapDrawable
  implements e.a
{
  protected static final aq hAA;
  protected boolean Flm;
  private int Fln;
  private int Flo;
  protected boolean Flp;
  protected float Flq;
  private PaintFlagsDrawFilter Flr;
  public c Fls;
  private Runnable hAC;
  protected final Paint hAz;
  private Path lP;
  private Paint paint;
  private Rect rect;
  protected String tag;
  protected boolean wdl;
  protected final a xnS;
  protected boolean yeT;
  
  static
  {
    AppMethodBeat.i(152146);
    hAA = new aq(Looper.getMainLooper());
    AppMethodBeat.o(152146);
  }
  
  public j(a parama, String paramString)
  {
    super(parama.LT());
    AppMethodBeat.i(152139);
    this.hAz = new Paint();
    this.wdl = false;
    this.Flm = false;
    this.Fln = 0;
    this.Flo = 0;
    this.Flq = 1.0F;
    this.rect = new Rect();
    this.Flr = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.lP = new Path();
    this.hAC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.hAz.setAntiAlias(true);
    this.hAz.setFilterBitmap(true);
    this.xnS = parama;
    this.tag = paramString;
    this.xnS.a(this);
    AppMethodBeat.o(152139);
  }
  
  public j(a parama, String paramString, byte paramByte)
  {
    super(parama.LT());
    AppMethodBeat.i(152140);
    this.hAz = new Paint();
    this.wdl = false;
    this.Flm = false;
    this.Fln = 0;
    this.Flo = 0;
    this.Flq = 1.0F;
    this.rect = new Rect();
    this.Flr = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.lP = new Path();
    this.hAC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.hAz.setAntiAlias(true);
    this.hAz.setFilterBitmap(true);
    this.wdl = false;
    this.xnS = parama;
    this.tag = paramString;
    this.xnS.a(this);
    AppMethodBeat.o(152140);
  }
  
  public void DG(String paramString)
  {
    AppMethodBeat.i(152143);
    if (this.Fls != null)
    {
      this.Fls.ait(paramString);
      AppMethodBeat.o(152143);
      return;
    }
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    ae.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    hAA.post(this.hAC);
    AppMethodBeat.o(152143);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152142);
    Bitmap localBitmap;
    if (this.Flm)
    {
      localBitmap = this.xnS.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.xnS.LT();
      if (!this.Flp) {
        break label207;
      }
      this.yeT = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.Flq > 1.0F) || (this.wdl))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.hAz);
      AppMethodBeat.o(152142);
      return;
      if (this.Flp)
      {
        localBitmap = this.xnS.fm(this.tag);
        break;
      }
      localBitmap = this.xnS.fl(this.tag);
      break;
      label207:
      this.yeT = false;
      continue;
      label215:
      this.yeT = false;
    }
  }
  
  public final void ffA()
  {
    AppMethodBeat.i(152144);
    if (!this.Flp)
    {
      AppMethodBeat.o(152144);
      return;
    }
    this.Flp = false;
    if (this.yeT)
    {
      this.yeT = false;
      invalidateSelf();
    }
    AppMethodBeat.o(152144);
  }
  
  public final void ffy()
  {
    AppMethodBeat.i(218901);
    hAA.post(this.hAC);
    AppMethodBeat.o(218901);
  }
  
  public final void ffz()
  {
    this.Flp = true;
  }
  
  public final String getTag()
  {
    return this.tag;
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(152145);
    if (paramBoolean)
    {
      this.Flp = true;
      AppMethodBeat.o(152145);
      return;
    }
    ffA();
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
      hAA.post(this.hAC);
    }
    AppMethodBeat.o(152141);
  }
  
  public final void vQ(boolean paramBoolean)
  {
    this.Flm = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap LT();
    
    public abstract Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(j paramj);
    
    public abstract Bitmap fl(String paramString);
    
    public abstract Bitmap fm(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract boolean ais(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract boolean ait(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.j
 * JD-Core Version:    0.7.0.1
 */