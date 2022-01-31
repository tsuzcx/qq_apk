package com.tencent.xweb.skia_canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class XWebImageLoader
{
  private static volatile IXWebImageLoader DEFAULT;
  private static final String TAG;
  private static volatile IXWebImageLoader mImageLoader;
  
  static
  {
    AppMethodBeat.i(154245);
    TAG = XWebImageLoader.class.getSimpleName();
    XWebImageLoader.1 local1 = new XWebImageLoader.1();
    DEFAULT = local1;
    mImageLoader = local1;
    AppMethodBeat.o(154245);
  }
  
  public static void initAssetImageLoader(Context paramContext)
  {
    AppMethodBeat.i(154242);
    mImageLoader = new XWebImageLoader.AssetImageLoader(paramContext, null);
    AppMethodBeat.o(154242);
  }
  
  public static void initImageLoader(IXWebImageLoader paramIXWebImageLoader)
  {
    mImageLoader = paramIXWebImageLoader;
  }
  
  public static byte[] loadImage(String paramString)
  {
    AppMethodBeat.i(154243);
    String.format("loadImage path:%s", new Object[] { paramString });
    paramString = mImageLoader.loadImage(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(154243);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramString = localByteArrayOutputStream.toByteArray();
    String.format("loadImage result:%d", new Object[] { Integer.valueOf(paramString.length) });
    AppMethodBeat.o(154243);
    return paramString;
  }
  
  public static void loadImageAsync(String paramString)
  {
    AppMethodBeat.i(154244);
    String.format("loadImage path:%s", new Object[] { paramString });
    mImageLoader.loadImageAsync(paramString, new XWebImageLoader.2(paramString));
    AppMethodBeat.o(154244);
  }
  
  public static native void notifyImageLoad(String paramString, byte[] paramArrayOfByte);
  
  public static void resetImageLoader()
  {
    mImageLoader = DEFAULT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebImageLoader
 * JD-Core Version:    0.7.0.1
 */