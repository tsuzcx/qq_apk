package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class c
  implements Runnable
{
  private final Uri IG;
  private final ParcelFileDescriptor IJ;
  
  public c(ImageManager paramImageManager, Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.IG = paramUri;
    this.IJ = paramParcelFileDescriptor;
  }
  
  public final void run()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      localObject1 = String.valueOf(Thread.currentThread());
      localObject3 = String.valueOf(Looper.getMainLooper().getThread());
      Log.e("Asserts", String.valueOf(localObject1).length() + 56 + String.valueOf(localObject3).length() + "checkNotMainThread: current thread " + (String)localObject1 + " IS the main thread " + (String)localObject3 + "!");
      throw new IllegalStateException("LoadBitmapFromDiskRunnable can't be executed in the main thread");
    }
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject1 = null;
    Object localObject3 = null;
    if (this.IJ != null) {}
    try
    {
      localObject1 = BitmapFactory.decodeFileDescriptor(this.IJ.getFileDescriptor());
      bool1 = bool2;
      String str2;
      Object localObject2;
      String str1;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        for (;;)
        {
          this.IJ.close();
          localObject3 = new CountDownLatch(1);
          ImageManager.g(this.II).post(new d(this.II, this.IG, (Bitmap)localObject1, bool1, (CountDownLatch)localObject3));
          try
          {
            ((CountDownLatch)localObject3).await();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            str1 = String.valueOf(this.IG);
            Log.w("ImageManager", String.valueOf(str1).length() + 32 + "Latch interrupted while posting " + str1);
          }
          localOutOfMemoryError = localOutOfMemoryError;
          str2 = String.valueOf(this.IG);
          Log.e("ImageManager", String.valueOf(str2).length() + 34 + "OOM while loading bitmap for uri: " + str2, localOutOfMemoryError);
          bool1 = true;
          localObject2 = localObject3;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("ImageManager", "closed failed", localIOException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.c
 * JD-Core Version:    0.7.0.1
 */