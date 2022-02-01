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
  protected static final MMHandler ljQ;
  protected boolean FcG;
  protected final a Hix;
  protected boolean IcL;
  protected boolean RcK;
  private int RcL;
  private int RcM;
  protected boolean RcN;
  protected float RcO;
  private PaintFlagsDrawFilter RcP;
  public c RcQ;
  private Path aBZ;
  private Rect byG;
  protected final Paint ljP;
  private Runnable ljS;
  private Paint paint;
  protected String tag;
  
  static
  {
    AppMethodBeat.i(152146);
    ljQ = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(152146);
  }
  
  public j(a parama, String paramString)
  {
    super(parama.aaC());
    AppMethodBeat.i(152139);
    this.ljP = new Paint();
    this.FcG = false;
    this.RcK = false;
    this.RcL = 0;
    this.RcM = 0;
    this.RcO = 1.0F;
    this.byG = new Rect();
    this.RcP = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.aBZ = new Path();
    this.ljS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.ljP.setAntiAlias(true);
    this.ljP.setFilterBitmap(true);
    this.Hix = parama;
    this.tag = paramString;
    this.Hix.a(this);
    AppMethodBeat.o(152139);
  }
  
  public j(a parama, String paramString, byte paramByte)
  {
    super(parama.aaC());
    AppMethodBeat.i(152140);
    this.ljP = new Paint();
    this.FcG = false;
    this.RcK = false;
    this.RcL = 0;
    this.RcM = 0;
    this.RcO = 1.0F;
    this.byG = new Rect();
    this.RcP = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.aBZ = new Path();
    this.ljS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152138);
        j.this.invalidateSelf();
        AppMethodBeat.o(152138);
      }
    };
    this.ljP.setAntiAlias(true);
    this.ljP.setFilterBitmap(true);
    this.FcG = false;
    this.Hix = parama;
    this.tag = paramString;
    this.Hix.a(this);
    AppMethodBeat.o(152140);
  }
  
  public final void DT(boolean paramBoolean)
  {
    this.RcK = paramBoolean;
  }
  
  public void TM(String paramString)
  {
    AppMethodBeat.i(152143);
    if (this.RcQ != null)
    {
      this.RcQ.aDo(paramString);
      AppMethodBeat.o(152143);
      return;
    }
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(152143);
      return;
    }
    Log.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    ljQ.post(this.ljS);
    AppMethodBeat.o(152143);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152142);
    Bitmap localBitmap;
    if (this.RcK)
    {
      localBitmap = this.Hix.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.Hix.aaC();
      if (!this.RcN) {
        break label207;
      }
      this.IcL = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.RcO > 1.0F) || (this.FcG))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.ljP);
      AppMethodBeat.o(152142);
      return;
      if (this.RcN)
      {
        localBitmap = this.Hix.gK(this.tag);
        break;
      }
      localBitmap = this.Hix.gJ(this.tag);
      break;
      label207:
      this.IcL = false;
      continue;
      label215:
      this.IcL = false;
    }
  }
  
  public final String getTag()
  {
    return this.tag;
  }
  
  public final void hjt()
  {
    AppMethodBeat.i(220468);
    ljQ.post(this.ljS);
    AppMethodBeat.o(220468);
  }
  
  public final void hju()
  {
    this.RcN = true;
  }
  
  public final void hjv()
  {
    AppMethodBeat.i(152144);
    if (!this.RcN)
    {
      AppMethodBeat.o(152144);
      return;
    }
    this.RcN = false;
    if (this.IcL)
    {
      this.IcL = false;
      invalidateSelf();
    }
    AppMethodBeat.o(152144);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(152145);
    if (paramBoolean)
    {
      this.RcN = true;
      AppMethodBeat.o(152145);
      return;
    }
    hjv();
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
      ljQ.post(this.ljS);
    }
    AppMethodBeat.o(152141);
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj);
    
    public abstract Bitmap aaC();
    
    public abstract Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract Bitmap gJ(String paramString);
    
    public abstract Bitmap gK(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract boolean aDn(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract boolean aDo(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.j
 * JD-Core Version:    0.7.0.1
 */