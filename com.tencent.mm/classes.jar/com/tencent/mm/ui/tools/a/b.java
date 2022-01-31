package com.tencent.mm.ui.tools.a;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends a
{
  private String lWF;
  private int mHeight = 2048;
  public int mSize = 104857600;
  private int mWidth = 2048;
  public int wfI = 0;
  public int wfJ = 0;
  public int wfK = 0;
  private b.a wfL;
  
  private b(String paramString)
  {
    this.lWF = paramString;
  }
  
  public static b aen(String paramString)
  {
    return new b(paramString);
  }
  
  public final b If(int paramInt)
  {
    this.mWidth = paramInt;
    this.mHeight = paramInt;
    return this;
  }
  
  public final void a(b.a parama)
  {
    this.wfL = parama;
    cnV();
  }
  
  protected final int afv()
  {
    if (bk.bl(this.lWF)) {
      y.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
    }
    this.wfI = e.bJ(this.lWF);
    String str = this.lWF;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(str, localOptions);
    this.wfJ = localOptions.outWidth;
    this.wfK = localOptions.outHeight;
    if (this.wfI <= this.mSize)
    {
      if (this.wfI < 0)
      {
        i = 1;
        if (i == 0) {
          break label190;
        }
      }
    }
    else {
      y.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[] { Integer.valueOf(this.wfI) });
    }
    label190:
    for (int i = 0;; i = 1)
    {
      if ((this.wfJ > this.mWidth) || (this.wfK > this.mHeight))
      {
        y.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[] { Integer.valueOf(this.wfJ), Integer.valueOf(this.wfK) });
        i = 0;
      }
      if (i != 0)
      {
        y.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        return 0;
        i = 0;
        break;
      }
      return 1;
    }
  }
  
  protected final void cnV()
  {
    if (this.wfL == null)
    {
      y.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
      return;
    }
    switch (afv())
    {
    default: 
      return;
    case 0: 
      this.wfL.a(this);
      return;
    }
    this.wfL.aIT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a.b
 * JD-Core Version:    0.7.0.1
 */