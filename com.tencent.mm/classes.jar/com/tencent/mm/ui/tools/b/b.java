package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class b
  extends a
{
  private String QxF;
  public int QxG = 0;
  public int QxH = 0;
  public int QxI = 0;
  private a QxJ;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.QxF = paramString;
  }
  
  public static b bnW(String paramString)
  {
    AppMethodBeat.i(143300);
    paramString = new b(paramString);
    AppMethodBeat.o(143300);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(143301);
    this.QxJ = parama;
    dSw();
    AppMethodBeat.o(143301);
  }
  
  public final b aop(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  protected final int bCj()
  {
    AppMethodBeat.i(143302);
    if (Util.isNullOrNil(this.QxF)) {
      Log.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.QxG = ((int)s.boW(this.QxF));
    String str = this.QxF;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(str, localOptions);
    this.QxH = localOptions.outWidth;
    this.QxI = localOptions.outHeight;
    if (this.QxG <= this.mSize)
    {
      if (this.QxG < 0)
      {
        i = 1;
        if (i == 0) {
          break label206;
        }
      }
    }
    else {
      Log.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.QxG) });
    }
    label206:
    for (int i = 0;; i = 1)
    {
      if ((this.QxH > this.mWidth) || (this.QxI > this.mHeight))
      {
        Log.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.QxH), Integer.valueOf(this.QxI) });
        i = 0;
      }
      if (i != 0)
      {
        Log.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        AppMethodBeat.o(143302);
        return 0;
        i = 0;
        break;
      }
      AppMethodBeat.o(143302);
      return 1;
    }
  }
  
  protected final void dSw()
  {
    AppMethodBeat.i(143303);
    if (this.QxJ == null)
    {
      Log.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(143303);
      return;
    }
    switch (bCj())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143303);
      return;
      this.QxJ.a(this);
      AppMethodBeat.o(143303);
      return;
      this.QxJ.cHf();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void cHf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */