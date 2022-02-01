package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class b
  extends a
{
  private String HuH;
  public int HuI = 0;
  public int HuJ = 0;
  public int HuK = 0;
  private a HuL;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.HuH = paramString;
  }
  
  public static b aLP(String paramString)
  {
    AppMethodBeat.i(143300);
    paramString = new b(paramString);
    AppMethodBeat.o(143300);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(143301);
    this.HuL = parama;
    cAQ();
    AppMethodBeat.o(143301);
  }
  
  protected final int aVG()
  {
    AppMethodBeat.i(143302);
    if (bt.isNullOrNil(this.HuH)) {
      ad.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.HuI = ((int)i.aMN(this.HuH));
    String str = this.HuH;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(str, localOptions);
    this.HuJ = localOptions.outWidth;
    this.HuK = localOptions.outHeight;
    if (this.HuI <= this.mSize)
    {
      if (this.HuI < 0)
      {
        i = 1;
        if (i == 0) {
          break label206;
        }
      }
    }
    else {
      ad.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.HuI) });
    }
    label206:
    for (int i = 0;; i = 1)
    {
      if ((this.HuJ > this.mWidth) || (this.HuK > this.mHeight))
      {
        ad.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.HuJ), Integer.valueOf(this.HuK) });
        i = 0;
      }
      if (i != 0)
      {
        ad.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        AppMethodBeat.o(143302);
        return 0;
        i = 0;
        break;
      }
      AppMethodBeat.o(143302);
      return 1;
    }
  }
  
  public final b aai(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  protected final void cAQ()
  {
    AppMethodBeat.i(143303);
    if (this.HuL == null)
    {
      ad.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(143303);
      return;
    }
    switch (aVG())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143303);
      return;
      this.HuL.a(this);
      AppMethodBeat.o(143303);
      return;
      this.HuL.bWb();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void bWb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */