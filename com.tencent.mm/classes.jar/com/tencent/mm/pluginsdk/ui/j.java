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
  protected static final MMHandler iuH;
  protected final a Boe;
  protected boolean CfV;
  protected boolean Kcf;
  private int Kcg;
  private int Kch;
  protected boolean Kci;
  protected float Kcj;
  private PaintFlagsDrawFilter Kck;
  public c Kcl;
  protected final Paint iuG;
  private Runnable iuJ;
  private Path lR;
  private Paint paint;
  private Rect rect;
  protected String tag;
  protected boolean zxm;
  
  static
  {
    AppMethodBeat.i(152146);
    iuH = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(152146);
  }
  
  public j(a parama, String paramString)
  {
    super(parama.Wg());
    AppMethodBeat.i(152139);
    this.iuG = new Paint();
    this.zxm = false;
    this.Kcf = false;
    this.Kcg = 0;
    this.Kch = 0;
    this.Kcj = 1.0F;
    this.rect = new Rect();
    this.Kck = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.lR = new Path();
    this.iuJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.iuG.setAntiAlias(true);
    this.iuG.setFilterBitmap(true);
    this.Boe = parama;
    this.tag = paramString;
    this.Boe.a(this);
    AppMethodBeat.o(152139);
  }
  
  public j(a parama, String paramString, byte paramByte)
  {
    super(parama.Wg());
    AppMethodBeat.i(152140);
    this.iuG = new Paint();
    this.zxm = false;
    this.Kcf = false;
    this.Kcg = 0;
    this.Kch = 0;
    this.Kcj = 1.0F;
    this.rect = new Rect();
    this.Kck = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.lR = new Path();
    this.iuJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.iuG.setAntiAlias(true);
    this.iuG.setFilterBitmap(true);
    this.zxm = false;
    this.Boe = parama;
    this.tag = paramString;
    this.Boe.a(this);
    AppMethodBeat.o(152140);
  }
  
  public void Mr(String paramString)
  {
    AppMethodBeat.i(152143);
    if (this.Kcl != null)
    {
      this.Kcl.auc(paramString);
      AppMethodBeat.o(152143);
      return;
    }
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    Log.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    iuH.post(this.iuJ);
    AppMethodBeat.o(152143);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152142);
    Bitmap localBitmap;
    if (this.Kcf)
    {
      localBitmap = this.Boe.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.Boe.Wg();
      if (!this.Kci) {
        break label207;
      }
      this.CfV = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.Kcj > 1.0F) || (this.zxm))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.iuG);
      AppMethodBeat.o(152142);
      return;
      if (this.Kci)
      {
        localBitmap = this.Boe.ga(this.tag);
        break;
      }
      localBitmap = this.Boe.fZ(this.tag);
      break;
      label207:
      this.CfV = false;
      continue;
      label215:
      this.CfV = false;
    }
  }
  
  public final String getTag()
  {
    return this.tag;
  }
  
  public final void goH()
  {
    AppMethodBeat.i(223847);
    iuH.post(this.iuJ);
    AppMethodBeat.o(223847);
  }
  
  public final void goI()
  {
    this.Kci = true;
  }
  
  public final void goJ()
  {
    AppMethodBeat.i(152144);
    if (!this.Kci)
    {
      AppMethodBeat.o(152144);
      return;
    }
    this.Kci = false;
    if (this.CfV)
    {
      this.CfV = false;
      invalidateSelf();
    }
    AppMethodBeat.o(152144);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(152145);
    if (paramBoolean)
    {
      this.Kci = true;
      AppMethodBeat.o(152145);
      return;
    }
    goJ();
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
      iuH.post(this.iuJ);
    }
    AppMethodBeat.o(152141);
  }
  
  public final void zO(boolean paramBoolean)
  {
    this.Kcf = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Wg();
    
    public abstract Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(j paramj);
    
    public abstract Bitmap fZ(String paramString);
    
    public abstract Bitmap ga(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract boolean aub(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract boolean auc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.j
 * JD-Core Version:    0.7.0.1
 */