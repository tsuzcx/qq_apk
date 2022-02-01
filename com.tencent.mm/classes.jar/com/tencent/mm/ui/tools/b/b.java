package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class b
  extends a
{
  private String IVe;
  public int IVf = 0;
  public int IVg = 0;
  public int IVh = 0;
  private a IVi;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.IVe = paramString;
  }
  
  public static b aRr(String paramString)
  {
    AppMethodBeat.i(143300);
    paramString = new b(paramString);
    AppMethodBeat.o(143300);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(143301);
    this.IVi = parama;
    cNZ();
    AppMethodBeat.o(143301);
  }
  
  public final b acv(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  protected final int bcE()
  {
    AppMethodBeat.i(143302);
    if (bs.isNullOrNil(this.IVe)) {
      ac.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.IVf = ((int)i.aSp(this.IVe));
    String str = this.IVe;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(str, localOptions);
    this.IVg = localOptions.outWidth;
    this.IVh = localOptions.outHeight;
    if (this.IVf <= this.mSize)
    {
      if (this.IVf < 0)
      {
        i = 1;
        if (i == 0) {
          break label206;
        }
      }
    }
    else {
      ac.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.IVf) });
    }
    label206:
    for (int i = 0;; i = 1)
    {
      if ((this.IVg > this.mWidth) || (this.IVh > this.mHeight))
      {
        ac.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.IVg), Integer.valueOf(this.IVh) });
        i = 0;
      }
      if (i != 0)
      {
        ac.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        AppMethodBeat.o(143302);
        return 0;
        i = 0;
        break;
      }
      AppMethodBeat.o(143302);
      return 1;
    }
  }
  
  protected final void cNZ()
  {
    AppMethodBeat.i(143303);
    if (this.IVi == null)
    {
      ac.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(143303);
      return;
    }
    switch (bcE())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143303);
      return;
      this.IVi.a(this);
      AppMethodBeat.o(143303);
      return;
      this.IVi.cdo();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void cdo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */