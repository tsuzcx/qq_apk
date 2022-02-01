package com.tencent.mm.videocomposition.c;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/sdk/BitmapUtil;", "", "()V", "TAG", "", "calculateInSampleSize", "", "originWidth", "originHeight", "reqWidth", "reqHeight", "rotate", "Landroid/graphics/Bitmap;", "temBmp", "degree", "", "video_composition_release"})
public final class a
{
  public static final a Rig;
  
  static
  {
    AppMethodBeat.i(216860);
    Rig = new a();
    AppMethodBeat.o(216860);
  }
  
  public static int calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(216858);
    int j = 1;
    if ((paramInt1 > paramInt4) || (paramInt2 > paramInt3))
    {
      if (paramInt2 > paramInt1) {}
      for (int i = Math.round(paramInt1 / paramInt4 + 0.5F);; i = Math.round(paramInt2 / paramInt3 + 0.5F))
      {
        float f1 = paramInt2;
        float f2 = paramInt1;
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
    AppMethodBeat.o(216858);
    return j;
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(216859);
    if ((paramBitmap == null) || (paramFloat % 360.0F == 0.0F))
    {
      AppMethodBeat.o(216859);
      return paramBitmap;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    ((Matrix)localObject).setRotate(paramFloat, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    for (;;)
    {
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        StringBuilder localStringBuilder = new StringBuilder("resultBmp is null: ");
        if (localObject == null)
        {
          bool = true;
          b.d("BitmapUtil", bool + "  degree:" + paramFloat, new Object[0]);
          if ((p.j(paramBitmap, localObject) ^ true))
          {
            b.i("BitmapUtil", "rotate bitmap recycle ajsdfasdf adsf. %s", new Object[] { paramBitmap });
            paramBitmap.recycle();
          }
          AppMethodBeat.o(216859);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        b.d("BitmapUtil", "createBitmap failed : %s ", new Object[] { e.stackTraceToString(localThrowable) });
        AppMethodBeat.o(216859);
        return paramBitmap;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.a
 * JD-Core Version:    0.7.0.1
 */