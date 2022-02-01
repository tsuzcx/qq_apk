package com.tencent.qbar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/qbar/util/ScanBitmapUtil;", "", "()V", "TAG", "", "calculateInSampleSize", "", "imageWidth", "imageHeight", "reqWidth", "reqHeight", "scan-sdk_release"})
public final class a
{
  public static final a LLd;
  
  static
  {
    AppMethodBeat.i(218772);
    LLd = new a();
    AppMethodBeat.o(218772);
  }
  
  public static final int O(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(218771);
    int j = 1;
    if ((paramInt2 > paramInt4) || (paramInt1 > paramInt3))
    {
      if (paramInt1 > paramInt2) {}
      for (int i = Math.round(paramInt2 / paramInt4 + 0.5F);; i = Math.round(paramInt1 / paramInt3 + 0.5F))
      {
        float f1 = paramInt1;
        float f2 = paramInt2;
        float f3 = paramInt3 * paramInt4;
        for (;;)
        {
          j = i;
          if (f1 * f2 / (i * i) <= f3 * 2.0F) {
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(218771);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qbar.b.a
 * JD-Core Version:    0.7.0.1
 */