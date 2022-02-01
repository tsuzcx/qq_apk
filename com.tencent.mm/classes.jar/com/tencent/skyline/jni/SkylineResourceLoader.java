package com.tencent.skyline.jni;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SkylineResourceLoader
{
  private static final String TAG = "SkylineResourceLoader";
  private static ISkylineResourceLoader mDelegate;
  
  public static void initResourceLoader(ISkylineResourceLoader paramISkylineResourceLoader)
  {
    mDelegate = paramISkylineResourceLoader;
  }
  
  public static Bitmap loadBitmap(String paramString)
  {
    AppMethodBeat.i(210723);
    if (mDelegate != null)
    {
      paramString = mDelegate.loadBitmap(paramString);
      AppMethodBeat.o(210723);
      return paramString;
    }
    AppMethodBeat.o(210723);
    return null;
  }
  
  public static void loadBitmapAsync(int paramInt, String paramString)
  {
    AppMethodBeat.i(210727);
    if (mDelegate != null)
    {
      mDelegate.loadBitmapAsync(paramString, new ISkylineResourceLoader.BitmapLoadCallback()
      {
        public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(210692);
          if (paramAnonymousBitmap == null)
          {
            new StringBuilder("requestId:").append(this.val$requestId).append(" resource is null, return");
            SkylineResourceLoader.access$100(this.val$requestId, null, 0, 0);
            AppMethodBeat.o(210692);
            return;
          }
          SkylineResourceLoader.access$100(this.val$requestId, paramAnonymousBitmap, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
          AppMethodBeat.o(210692);
        }
      });
      AppMethodBeat.o(210727);
      return;
    }
    nativeNotifyBitmapLoad(paramInt, null, 0, 0);
    AppMethodBeat.o(210727);
  }
  
  public static byte[] loadResource(String paramString)
  {
    AppMethodBeat.i(210706);
    if (mDelegate != null)
    {
      paramString = mDelegate.loadResource(paramString);
      AppMethodBeat.o(210706);
      return paramString;
    }
    AppMethodBeat.o(210706);
    return null;
  }
  
  public static void loadResourceAsync(int paramInt, String paramString)
  {
    AppMethodBeat.i(210712);
    if (mDelegate != null)
    {
      mDelegate.loadResourceAsync(paramString, new ISkylineResourceLoader.ResourceLoadCallback()
      {
        public final void onResourceLoaded(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(210698);
          if (paramAnonymousArrayOfByte == null)
          {
            new StringBuilder("requestId:").append(this.val$requestId).append(" resource is null, return");
            SkylineResourceLoader.access$000(this.val$requestId, new byte[0]);
            AppMethodBeat.o(210698);
            return;
          }
          SkylineResourceLoader.access$000(this.val$requestId, paramAnonymousArrayOfByte);
          AppMethodBeat.o(210698);
        }
      });
      AppMethodBeat.o(210712);
      return;
    }
    nativeNotifyResourceLoad(paramInt, new byte[0]);
    AppMethodBeat.o(210712);
  }
  
  private static native void nativeNotifyBitmapLoad(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  private static native void nativeNotifyResourceLoad(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.skyline.jni.SkylineResourceLoader
 * JD-Core Version:    0.7.0.1
 */