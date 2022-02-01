package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class b
  extends a
{
  private String LiG;
  public int LiH = 0;
  public int LiI = 0;
  public int LiJ = 0;
  private a LiK;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.LiG = paramString;
  }
  
  public static b aYR(String paramString)
  {
    AppMethodBeat.i(143300);
    paramString = new b(paramString);
    AppMethodBeat.o(143300);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(143301);
    this.LiK = parama;
    cYX();
    AppMethodBeat.o(143301);
  }
  
  public final b afC(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  protected final int bgQ()
  {
    AppMethodBeat.i(143302);
    if (bu.isNullOrNil(this.LiG)) {
      ae.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.LiH = ((int)o.aZR(this.LiG));
    String str = this.LiG;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(str, localOptions);
    this.LiI = localOptions.outWidth;
    this.LiJ = localOptions.outHeight;
    if (this.LiH <= this.mSize)
    {
      if (this.LiH < 0)
      {
        i = 1;
        if (i == 0) {
          break label206;
        }
      }
    }
    else {
      ae.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.LiH) });
    }
    label206:
    for (int i = 0;; i = 1)
    {
      if ((this.LiI > this.mWidth) || (this.LiJ > this.mHeight))
      {
        ae.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.LiI), Integer.valueOf(this.LiJ) });
        i = 0;
      }
      if (i != 0)
      {
        ae.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        AppMethodBeat.o(143302);
        return 0;
        i = 0;
        break;
      }
      AppMethodBeat.o(143302);
      return 1;
    }
  }
  
  protected final void cYX()
  {
    AppMethodBeat.i(143303);
    if (this.LiK == null)
    {
      ae.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(143303);
      return;
    }
    switch (bgQ())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143303);
      return;
      this.LiK.a(this);
      AppMethodBeat.o(143303);
      return;
      this.LiK.cjh();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void cjh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */