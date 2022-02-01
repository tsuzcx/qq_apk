package com.tencent.tav.asset;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AssetUtils
{
  public static void getRotationMatrix(Matrix paramMatrix, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201327);
    int i = paramInt % 4;
    paramInt = i;
    if (i < 0) {
      paramInt = i + 4;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    switch (paramInt)
    {
    default: 
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      f1 = 1.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = 1.0F;
    }
    for (;;)
    {
      paramMatrix.setValues(new float[] { f4, f2, paramFloat2, f3, f1, paramFloat1, 0.0F, 0.0F, 1.0F });
      AppMethodBeat.o(201327);
      return;
      paramFloat1 = 0.0F;
      f1 = 0.0F;
      f2 = -1.0F;
      f3 = 1.0F;
      f4 = 0.0F;
      continue;
      f1 = paramFloat1;
      float f5 = -1.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = -1.0F;
      paramFloat1 = paramFloat2;
      paramFloat2 = f1;
      f1 = f5;
      continue;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f2 = 1.0F;
      f3 = -1.0F;
      f4 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.asset.AssetUtils
 * JD-Core Version:    0.7.0.1
 */