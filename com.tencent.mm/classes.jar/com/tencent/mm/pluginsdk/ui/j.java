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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class j
  extends BitmapDrawable
  implements e.a
{
  protected static final MMHandler nOB;
  protected boolean KYp;
  protected boolean NZh;
  protected final a Ngk;
  protected boolean XYQ;
  private int XYR;
  private int XYS;
  protected boolean XYT;
  protected float XYU;
  private PaintFlagsDrawFilter XYV;
  public c XYW;
  protected final Paint nOA;
  private Runnable nOD;
  private Paint paint;
  private Path path;
  private Rect rect;
  protected String tag;
  
  static
  {
    AppMethodBeat.i(152146);
    nOB = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(152146);
  }
  
  public j(a parama, String paramString)
  {
    super(parama.aCj());
    AppMethodBeat.i(152139);
    this.nOA = new Paint();
    this.KYp = false;
    this.XYQ = false;
    this.XYR = 0;
    this.XYS = 0;
    this.XYU = 1.0F;
    this.rect = new Rect();
    this.XYV = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.path = new Path();
    this.nOD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.nOA.setAntiAlias(true);
    this.nOA.setFilterBitmap(true);
    this.Ngk = parama;
    this.tag = paramString;
    this.Ngk.a(this);
    AppMethodBeat.o(152139);
  }
  
  public j(a parama, String paramString, byte paramByte)
  {
    super(parama.aCj());
    AppMethodBeat.i(152140);
    this.nOA = new Paint();
    this.KYp = false;
    this.XYQ = false;
    this.XYR = 0;
    this.XYS = 0;
    this.XYU = 1.0F;
    this.rect = new Rect();
    this.XYV = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.path = new Path();
    this.nOD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.nOA.setAntiAlias(true);
    this.nOA.setFilterBitmap(true);
    this.KYp = false;
    this.Ngk = parama;
    this.tag = paramString;
    this.Ngk.a(this);
    AppMethodBeat.o(152140);
  }
  
  public final void JB(boolean paramBoolean)
  {
    this.XYQ = paramBoolean;
  }
  
  public void LM(String paramString)
  {
    AppMethodBeat.i(152143);
    if ((this.XYW != null) && (this.XYW.ayJ(paramString)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    Log.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    nOB.post(this.nOD);
    AppMethodBeat.o(152143);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152142);
    Bitmap localBitmap;
    if (this.XYQ)
    {
      localBitmap = this.Ngk.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.Ngk.aCj();
      if (!this.XYT) {
        break label207;
      }
      this.NZh = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.XYU > 1.0F) || (this.KYp))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.nOA);
      AppMethodBeat.o(152142);
      return;
      if (this.XYT)
      {
        localBitmap = this.Ngk.ik(this.tag);
        break;
      }
      localBitmap = this.Ngk.loadBitmap(this.tag);
      break;
      label207:
      this.NZh = false;
      continue;
      label215:
      this.NZh = false;
    }
  }
  
  public final String getTag()
  {
    return this.tag;
  }
  
  public final void iKl()
  {
    AppMethodBeat.i(245077);
    nOB.post(this.nOD);
    AppMethodBeat.o(245077);
  }
  
  public final void iKm()
  {
    this.XYT = true;
  }
  
  public final void iKn()
  {
    AppMethodBeat.i(152144);
    if (!this.XYT)
    {
      AppMethodBeat.o(152144);
      return;
    }
    this.XYT = false;
    if (this.NZh)
    {
      this.NZh = false;
      invalidateSelf();
    }
    AppMethodBeat.o(152144);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(152145);
    if (paramBoolean)
    {
      this.XYT = true;
      AppMethodBeat.o(152145);
      return;
    }
    iKn();
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
      nOB.post(this.nOD);
    }
    AppMethodBeat.o(152141);
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj);
    
    public abstract Bitmap aCj();
    
    public abstract Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract Bitmap ik(String paramString);
    
    public abstract Bitmap loadBitmap(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract boolean ayI(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract boolean ayJ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.j
 * JD-Core Version:    0.7.0.1
 */