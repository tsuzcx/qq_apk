package com.tencent.xweb.skia_canvas;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class XWebImageLoader
{
  private static volatile IXWebImageLoader DEFAULT;
  private static final String TAG;
  private static volatile IXWebImageLoader mImageLoader;
  
  static
  {
    AppMethodBeat.i(4307);
    TAG = XWebImageLoader.class.getSimpleName();
    XWebImageLoaderAdapter local1 = new XWebImageLoaderAdapter()
    {
      public final Bitmap loadImage(String paramAnonymousString)
      {
        return null;
      }
      
      public final void loadImageAsync(String paramAnonymousString, IXWebImageLoader.LoadImageCallback paramAnonymousLoadImageCallback)
      {
        AppMethodBeat.i(4299);
        if (paramAnonymousLoadImageCallback != null) {
          paramAnonymousLoadImageCallback.onLoadImageCallback(null);
        }
        AppMethodBeat.o(4299);
      }
    };
    DEFAULT = local1;
    mImageLoader = local1;
    AppMethodBeat.o(4307);
  }
  
  public static void initAssetImageLoader(Context paramContext)
  {
    AppMethodBeat.i(4304);
    mImageLoader = new AssetImageLoader(paramContext, null);
    AppMethodBeat.o(4304);
  }
  
  public static void initImageLoader(IXWebImageLoader paramIXWebImageLoader)
  {
    mImageLoader = paramIXWebImageLoader;
  }
  
  public static byte[] loadImage(String paramString)
  {
    AppMethodBeat.i(4305);
    String.format("loadImage path:%s", new Object[] { paramString });
    paramString = mImageLoader.loadImage(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(4305);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramString = localByteArrayOutputStream.toByteArray();
    String.format("loadImage result:%d", new Object[] { Integer.valueOf(paramString.length) });
    AppMethodBeat.o(4305);
    return paramString;
  }
  
  public static void loadImageAsync(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189200);
    String.format("loadImage path:%s, referrerPolicy:%s", new Object[] { paramString1, paramString2 });
    mImageLoader.loadImageAsync(paramString1, paramString2, new IXWebImageLoader.LoadImageCallback()
    {
      public final void onLoadImageCallback(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(4300);
        if (paramAnonymousBitmap == null)
        {
          XWebImageLoader.notifyImageLoad(this.val$path, new byte[0]);
          AppMethodBeat.o(4300);
          return;
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramAnonymousBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        paramAnonymousBitmap = localByteArrayOutputStream.toByteArray();
        String.format("loadImageAsync result:%d", new Object[] { Integer.valueOf(paramAnonymousBitmap.length) });
        XWebImageLoader.notifyImageLoad(this.val$path, paramAnonymousBitmap);
        AppMethodBeat.o(4300);
      }
    });
    AppMethodBeat.o(189200);
  }
  
  public static native void notifyImageLoad(String paramString, byte[] paramArrayOfByte);
  
  public static void resetImageLoader()
  {
    mImageLoader = DEFAULT;
  }
  
  static class AssetImageLoader
    extends XWebImageLoaderAdapter
  {
    private Context mContext;
    
    private AssetImageLoader(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public Bitmap loadImage(String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(4302);
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
        AppMethodBeat.o(4302);
        return localObject;
        bool = false;
      }
    }
    
    public void loadImageAsync(final String paramString, final IXWebImageLoader.LoadImageCallback paramLoadImageCallback)
    {
      AppMethodBeat.i(4303);
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(4301);
          paramLoadImageCallback.onLoadImageCallback(XWebImageLoader.AssetImageLoader.this.loadImage(paramString));
          AppMethodBeat.o(4301);
        }
      });
      AppMethodBeat.o(4303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebImageLoader
 * JD-Core Version:    0.7.0.1
 */