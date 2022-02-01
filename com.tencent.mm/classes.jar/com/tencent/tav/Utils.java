package com.tencent.tav;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Utils
{
  public static Bitmap flipYBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(201316);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, -1.0F, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
    AppMethodBeat.o(201316);
    return paramBitmap;
  }
  
  public static String getPhoneName()
  {
    AppMethodBeat.i(201317);
    String str = Build.MANUFACTURER.toUpperCase() + " " + Build.MODEL;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(201317);
      return "";
    }
    str = str.replace(" ", "_").replace("+", "").replace("(t)", "");
    AppMethodBeat.o(201317);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.Utils
 * JD-Core Version:    0.7.0.1
 */