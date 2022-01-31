package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final d Mf = new d();
  private final AtomicBoolean Mg = new AtomicBoolean();
  private final AtomicBoolean Mh = new AtomicBoolean();
  private boolean Mi = false;
  private final ArrayList<e> zg = new ArrayList();
  
  public static void a(Application paramApplication)
  {
    synchronized (Mf)
    {
      if (!Mf.Mi)
      {
        paramApplication.registerActivityLifecycleCallbacks(Mf);
        paramApplication.registerComponentCallbacks(Mf);
        Mf.Mi = true;
      }
      return;
    }
  }
  
  public static d ic()
  {
    return Mf;
  }
  
  private void x(boolean paramBoolean)
  {
    synchronized (Mf)
    {
      Iterator localIterator = this.zg.iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).x(paramBoolean);
      }
    }
  }
  
  public final void a(e parame)
  {
    synchronized (Mf)
    {
      this.zg.add(parame);
      return;
    }
  }
  
  @TargetApi(16)
  public final boolean id()
  {
    boolean bool = true;
    if (!this.Mh.get()) {
      if (Build.VERSION.SDK_INT < 16) {
        break label76;
      }
    }
    label76:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
        if ((!this.Mh.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
          this.Mg.set(true);
        }
        bool = this.Mg.get();
      }
      return bool;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this.Mg.compareAndSet(true, false);
    this.Mh.set(true);
    if (bool) {
      x(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this.Mg.compareAndSet(true, false);
    this.Mh.set(true);
    if (bool) {
      x(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this.Mg.compareAndSet(false, true)))
    {
      this.Mh.set(true);
      x(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.d
 * JD-Core Version:    0.7.0.1
 */