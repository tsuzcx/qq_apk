package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

public final class rt
{
  public static rs a()
  {
    return a("marker.png");
  }
  
  public static rs a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new rs(paramBitmap);
  }
  
  public static rs a(String paramString)
  {
    try
    {
      paramString = rt.class.getResourceAsStream("/assets/" + paramString);
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      paramString = a(localBitmap);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rt
 * JD-Core Version:    0.7.0.1
 */