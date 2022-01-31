package com.tencent.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private static final float[] BzS = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private static final float[] BzT = { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
  public int height;
  public int texture = -20000;
  public int width;
  
  private f(int paramInt1, int paramInt2, int paramInt3)
  {
    this.texture = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
  }
  
  public static f as(Bitmap paramBitmap)
  {
    AppMethodBeat.i(86637);
    if (paramBitmap != null)
    {
      paramBitmap = new f(g.at(paramBitmap), paramBitmap.getWidth(), paramBitmap.getHeight());
      AppMethodBeat.o(86637);
      return paramBitmap;
    }
    AppMethodBeat.o(86637);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.view.f
 * JD-Core Version:    0.7.0.1
 */