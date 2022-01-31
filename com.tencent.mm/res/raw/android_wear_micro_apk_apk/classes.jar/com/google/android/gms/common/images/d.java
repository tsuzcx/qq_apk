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
  private final Uri IG;
  private final Bitmap IK;
  private final CountDownLatch IL;
  private boolean IM;
  
  public d(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.IG = paramUri;
    this.IK = paramBitmap;
    this.IM = paramBoolean;
    this.IL = paramCountDownLatch;
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
        locale.a(ImageManager.b(this.II), this.IK);
      }
      for (;;)
      {
        if (!(locale instanceof g)) {
          ImageManager.a(this.II).remove(locale);
        }
        i += 1;
        break;
        ImageManager.d(this.II).put(this.IG, Long.valueOf(SystemClock.elapsedRealtime()));
        Context localContext = ImageManager.b(this.II);
        ImageManager.c(this.II);
        locale.f(localContext);
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
    if (this.IK != null) {
      bool = true;
    }
    while (ImageManager.h(this.II) != null) {
      if (this.IM)
      {
        ImageManager.h(this.II).evictAll();
        System.gc();
        this.IM = false;
        ImageManager.g(this.II).post(this);
        return;
        bool = false;
      }
      else if (bool)
      {
        ImageManager.h(this.II).put(new f(this.IG), this.IK);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.e(this.II).remove(this.IG);
    if (??? != null) {
      a((ImageManager.ImageReceiver)???, bool);
    }
    this.IL.countDown();
    synchronized (ImageManager.gR())
    {
      ImageManager.gS().remove(this.IG);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.d
 * JD-Core Version:    0.7.0.1
 */