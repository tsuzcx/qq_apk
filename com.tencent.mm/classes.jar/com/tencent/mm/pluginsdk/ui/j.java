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

public class j
  extends BitmapDrawable
  implements e.a
{
  protected static final ap hxM;
  protected boolean ESR;
  private int ESS;
  private int EST;
  protected boolean ESU;
  protected float ESV;
  private PaintFlagsDrawFilter ESW;
  public c ESX;
  protected final Paint hxL;
  private Runnable hxO;
  private Path lP;
  private Paint paint;
  private Rect rect;
  protected String tag;
  protected boolean vRh;
  protected final a wYb;
  protected boolean xPa;
  
  static
  {
    AppMethodBeat.i(152146);
    hxM = new ap(Looper.getMainLooper());
    AppMethodBeat.o(152146);
  }
  
  public j(a parama, String paramString)
  {
    super(parama.LL());
    AppMethodBeat.i(152139);
    this.hxL = new Paint();
    this.vRh = false;
    this.ESR = false;
    this.ESS = 0;
    this.EST = 0;
    this.ESV = 1.0F;
    this.rect = new Rect();
    this.ESW = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.lP = new Path();
    this.hxO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.hxL.setAntiAlias(true);
    this.hxL.setFilterBitmap(true);
    this.wYb = parama;
    this.tag = paramString;
    this.wYb.a(this);
    AppMethodBeat.o(152139);
  }
  
  public j(a parama, String paramString, byte paramByte)
  {
    super(parama.LL());
    AppMethodBeat.i(152140);
    this.hxL = new Paint();
    this.vRh = false;
    this.ESR = false;
    this.ESS = 0;
    this.EST = 0;
    this.ESV = 1.0F;
    this.rect = new Rect();
    this.ESW = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.lP = new Path();
    this.hxO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.hxL.setAntiAlias(true);
    this.hxL.setFilterBitmap(true);
    this.vRh = false;
    this.wYb = parama;
    this.tag = paramString;
    this.wYb.a(this);
    AppMethodBeat.o(152140);
  }
  
  public void De(String paramString)
  {
    AppMethodBeat.i(152143);
    if (this.ESX != null)
    {
      this.ESX.ahw(paramString);
      AppMethodBeat.o(152143);
      return;
    }
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    ad.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    hxM.post(this.hxO);
    AppMethodBeat.o(152143);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152142);
    Bitmap localBitmap;
    if (this.ESR)
    {
      localBitmap = this.wYb.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.wYb.LL();
      if (!this.ESU) {
        break label207;
      }
      this.xPa = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.ESV > 1.0F) || (this.vRh))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.hxL);
      AppMethodBeat.o(152142);
      return;
      if (this.ESU)
      {
        localBitmap = this.wYb.fh(this.tag);
        break;
      }
      localBitmap = this.wYb.fg(this.tag);
      break;
      label207:
      this.xPa = false;
      continue;
      label215:
      this.xPa = false;
    }
  }
  
  public final void fbK()
  {
    AppMethodBeat.i(195448);
    hxM.post(this.hxO);
    AppMethodBeat.o(195448);
  }
  
  public final void fbL()
  {
    this.ESU = true;
  }
  
  public final void fbM()
  {
    AppMethodBeat.i(152144);
    if (!this.ESU)
    {
      AppMethodBeat.o(152144);
      return;
    }
    this.ESU = false;
    if (this.xPa)
    {
      this.xPa = false;
      invalidateSelf();
    }
    AppMethodBeat.o(152144);
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
      this.ESU = true;
      AppMethodBeat.o(152145);
      return;
    }
    fbM();
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
      hxM.post(this.hxO);
    }
    AppMethodBeat.o(152141);
  }
  
  public final void vI(boolean paramBoolean)
  {
    this.ESR = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap LL();
    
    public abstract Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(j paramj);
    
    public abstract Bitmap fg(String paramString);
    
    public abstract Bitmap fh(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract boolean ahv(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract boolean ahw(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.j
 * JD-Core Version:    0.7.0.1
 */