package com.tencent.xweb.skia_canvas;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;

class XWebImageLoader$AssetImageLoader
  implements IXWebImageLoader
{
  private Context mContext;
  
  private XWebImageLoader$AssetImageLoader(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public Bitmap loadImage(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(154240);
    Object localObject = null;
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeStream(this.mContext.getAssets().open(paramString));
        localObject = localBitmap;
        XWebImageLoader.class.getSimpleName();
        if (localBitmap == null) {
          continue;
        }
        localObject = localBitmap;
        String.format("path:%s success:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        localObject = localBitmap;
      }
      catch (Exception paramString)
      {
        XWebImageLoader.class.getSimpleName();
        paramString.getMessage();
        continue;
      }
      AppMethodBeat.o(154240);
      return localObject;
      bool = false;
    }
  }
  
  public void loadImageAsync(String paramString, IXWebImageLoader.LoadImageCallback paramLoadImageCallback)
  {
    AppMethodBeat.i(154241);
    paramLoadImageCallback.onLoadImageCallback(loadImage(paramString));
    AppMethodBeat.o(154241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebImageLoader.AssetImageLoader
 * JD-Core Version:    0.7.0.1
 */