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
  private String KMi;
  public int KMj = 0;
  public int KMk = 0;
  public int KMl = 0;
  private a KMm;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.KMi = paramString;
  }
  
  public static b aXp(String paramString)
  {
    AppMethodBeat.i(143300);
    paramString = new b(paramString);
    AppMethodBeat.o(143300);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(143301);
    this.KMm = parama;
    cWs();
    AppMethodBeat.o(143301);
  }
  
  public final b aeT(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  protected final int bgi()
  {
    AppMethodBeat.i(143302);
    if (bt.isNullOrNil(this.KMi)) {
      ad.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.KMj = ((int)i.aYo(this.KMi));
    String str = this.KMi;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(str, localOptions);
    this.KMk = localOptions.outWidth;
    this.KMl = localOptions.outHeight;
    if (this.KMj <= this.mSize)
    {
      if (this.KMj < 0)
      {
        i = 1;
        if (i == 0) {
          break label206;
        }
      }
    }
    else {
      ad.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.KMj) });
    }
    label206:
    for (int i = 0;; i = 1)
    {
      if ((this.KMk > this.mWidth) || (this.KMl > this.mHeight))
      {
        ad.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.KMk), Integer.valueOf(this.KMl) });
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
  
  protected final void cWs()
  {
    AppMethodBeat.i(143303);
    if (this.KMm == null)
    {
      ad.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(143303);
      return;
    }
    switch (bgi())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143303);
      return;
      this.KMm.a(this);
      AppMethodBeat.o(143303);
      return;
      this.KMm.chR();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void chR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */