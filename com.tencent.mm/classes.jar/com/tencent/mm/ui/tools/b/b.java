package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class b
  extends a
{
  private String GYs;
  public int afMa = 0;
  public int afMb = 0;
  public int afMc = 0;
  private a afMd;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.GYs = paramString;
  }
  
  public static b bCH(String paramString)
  {
    AppMethodBeat.i(143300);
    paramString = new b(paramString);
    AppMethodBeat.o(143300);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(143301);
    this.afMd = parama;
    fBQ();
    AppMethodBeat.o(143301);
  }
  
  public final b aEf(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  protected final int cnU()
  {
    AppMethodBeat.i(143302);
    if (Util.isNullOrNil(this.GYs)) {
      Log.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.afMa = ((int)y.bEl(this.GYs));
    String str = this.GYs;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(str, localOptions);
    this.afMb = localOptions.outWidth;
    this.afMc = localOptions.outHeight;
    if (this.afMa <= this.mSize)
    {
      if (this.afMa < 0)
      {
        i = 1;
        if (i == 0) {
          break label206;
        }
      }
    }
    else {
      Log.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.afMa) });
    }
    label206:
    for (int i = 0;; i = 1)
    {
      if ((this.afMb > this.mWidth) || (this.afMc > this.mHeight))
      {
        Log.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.afMb), Integer.valueOf(this.afMc) });
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
  
  protected final void fBQ()
  {
    AppMethodBeat.i(143303);
    if (this.afMd == null)
    {
      Log.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(143303);
      return;
    }
    switch (cnU())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143303);
      return;
      this.afMd.a(this);
      AppMethodBeat.o(143303);
      return;
      this.afMd.dBw();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void dBw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */