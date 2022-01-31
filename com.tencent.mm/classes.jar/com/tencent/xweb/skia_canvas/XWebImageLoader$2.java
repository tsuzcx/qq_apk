package com.tencent.xweb.skia_canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

final class XWebImageLoader$2
  implements IXWebImageLoader.LoadImageCallback
{
  XWebImageLoader$2(String paramString) {}
  
  public final void onLoadImageCallback(Bitmap paramBitmap)
  {
    AppMethodBeat.i(154239);
    if (paramBitmap == null)
    {
      XWebImageLoader.access$100();
      XWebImageLoader.notifyImageLoad(this.val$path, new byte[0]);
      AppMethodBeat.o(154239);
      return;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    XWebImageLoader.access$100();
    String.format("loadImageAsync result:%d", new Object[] { Integer.valueOf(paramBitmap.length) });
    XWebImageLoader.notifyImageLoad(this.val$path, paramBitmap);
    AppMethodBeat.o(154239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebImageLoader.2
 * JD-Core Version:    0.7.0.1
 */