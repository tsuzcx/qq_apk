package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class b
  extends a
{
  private String BrW;
  public int XVL = 0;
  public int XVM = 0;
  public int XVN = 0;
  private a XVO;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  
  private b(String paramString)
  {
    this.BrW = paramString;
  }
  
  public static b bAJ(String paramString)
  {
    AppMethodBeat.i(143300);
    paramString = new b(paramString);
    AppMethodBeat.o(143300);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(143301);
    this.XVO = parama;
    euX();
    AppMethodBeat.o(143301);
  }
  
  public final b axw(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  protected final int bNF()
  {
    AppMethodBeat.i(143302);
    if (Util.isNullOrNil(this.BrW)) {
      Log.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.XVL = ((int)u.bBQ(this.BrW));
    String str = this.BrW;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(str, localOptions);
    this.XVM = localOptions.outWidth;
    this.XVN = localOptions.outHeight;
    if (this.XVL <= this.mSize)
    {
      if (this.XVL < 0)
      {
        i = 1;
        if (i == 0) {
          break label206;
        }
      }
    }
    else {
      Log.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.XVL) });
    }
    label206:
    for (int i = 0;; i = 1)
    {
      if ((this.XVM > this.mWidth) || (this.XVN > this.mHeight))
      {
        Log.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.XVM), Integer.valueOf(this.XVN) });
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
  
  protected final void euX()
  {
    AppMethodBeat.i(143303);
    if (this.XVO == null)
    {
      Log.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(143303);
      return;
    }
    switch (bNF())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143303);
      return;
      this.XVO.a(this);
      AppMethodBeat.o(143303);
      return;
      this.XVO.cVR();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void cVR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.b
 * JD-Core Version:    0.7.0.1
 */