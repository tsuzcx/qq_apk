package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class d
  implements Runnable
{
  private final CountDownLatch KA;
  private boolean KB;
  private final Uri Kv;
  private final Bitmap Kz;
  
  public d(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.Kv = paramUri;
    this.Kz = paramBitmap;
    this.KB = paramBoolean;
    this.KA = paramCountDownLatch;
  }
  
  private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    paramImageReceiver = ImageManager.ImageReceiver.a(paramImageReceiver);
    int j = paramImageReceiver.size();
    int i = 0;
    if (i < j)
    {
      e locale = (e)paramImageReceiver.get(i);
      if (paramBoolean) {
        locale.a(ImageManager.b(this.Kx), this.Kz);
      }
      for (;;)
      {
        if (!(locale instanceof g)) {
          ImageManager.a(this.Kx).remove(locale);
        }
        i += 1;
        break;
        ImageManager.d(this.Kx).put(this.Kv, Long.valueOf(SystemClock.elapsedRealtime()));
        Context localContext = ImageManager.b(this.Kx);
        ImageManager.c(this.Kx);
        locale.g(localContext);
      }
    }
  }
  
  public final void run()
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      ??? = String.valueOf(Thread.currentThread());
      String str = String.valueOf(Looper.getMainLooper().getThread());
      Log.e("Asserts", String.valueOf(???).length() + 57 + String.valueOf(str).length() + "checkMainThread: current thread " + (String)??? + " IS NOT the main thread " + str + "!");
      throw new IllegalStateException("OnBitmapLoadedRunnable must be executed in the main thread");
    }
    boolean bool;
    if (this.Kz != null) {
      bool = true;
    }
    while (ImageManager.h(this.Kx) != null) {
      if (this.KB)
      {
        ImageManager.h(this.Kx).evictAll();
        System.gc();
        this.KB = false;
        ImageManager.g(this.Kx).post(this);
        return;
        bool = false;
      }
      else if (bool)
      {
        ImageManager.h(this.Kx).put(new f(this.Kv), this.Kz);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.e(this.Kx).remove(this.Kv);
    if (??? != null) {
      a((ImageManager.ImageReceiver)???, bool);
    }
    this.KA.countDown();
    synchronized (ImageManager.hb())
    {
      ImageManager.hc().remove(this.Kv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.d
 * JD-Core Version:    0.7.0.1
 */