package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends a
{
  public int AyA = 0;
  public int AyB = 0;
  private b.a AyC;
  private String Ayy;
  public int Ayz = 0;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.Ayy = paramString;
  }
  
  public static b auW(String paramString)
  {
    AppMethodBeat.i(107829);
    paramString = new b(paramString);
    AppMethodBeat.o(107829);
    return paramString;
  }
  
  public final b QR(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(107830);
    this.AyC = parama;
    bEI();
    AppMethodBeat.o(107830);
  }
  
  protected final int azZ()
  {
    AppMethodBeat.i(107831);
    if (bo.isNullOrNil(this.Ayy)) {
      ab.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.Ayz = e.cM(this.Ayy);
    String str = this.Ayy;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(str, localOptions);
    this.AyA = localOptions.outWidth;
    this.AyB = localOptions.outHeight;
    if (this.Ayz <= this.mSize)
    {
      if (this.Ayz < 0)
      {
        i = 1;
        if (i == 0) {
          break label205;
        }
      }
    }
    else {
      ab.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.Ayz) });
    }
    label205:
    for (int i = 0;; i = 1)
    {
      if ((this.AyA > this.mWidth) || (this.AyB > this.mHeight))
      {
        ab.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.AyA), Integer.valueOf(this.AyB) });
        i = 0;
      }
      if (i != 0)
      {
        ab.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        AppMethodBeat.o(107831);
        return 0;
        i = 0;
        break;
      }
      AppMethodBeat.o(107831);
      return 1;
    }
  }
  
  protected final void bEI()
  {
    AppMethodBeat.i(107832);
    if (this.AyC == null)
    {
      ab.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(107832);
      return;
    }
    switch (azZ())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107832);
      return;
      this.AyC.a(this);
      AppMethodBeat.o(107832);
      return;
      this.AyC.bmr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */