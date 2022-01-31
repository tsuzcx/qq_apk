package com.tencent.xweb.skia_canvas;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class XWebImageLoader$1
  implements IXWebImageLoader
{
  public final Bitmap loadImage(String paramString)
  {
    return null;
  }
  
  public final void loadImageAsync(String paramString, IXWebImageLoader.LoadImageCallback paramLoadImageCallback)
  {
    AppMethodBeat.i(154238);
    if (paramLoadImageCallback != null) {
      paramLoadImageCallback.onLoadImageCallback(null);
    }
    AppMethodBeat.o(154238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebImageLoader.1
 * JD-Core Version:    0.7.0.1
 */