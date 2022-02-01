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
  private static final d NU = new d();
  private final ArrayList<e> AV = new ArrayList();
  private final AtomicBoolean NV = new AtomicBoolean();
  private final AtomicBoolean NW = new AtomicBoolean();
  private boolean NX = false;
  
  private void A(boolean paramBoolean)
  {
    synchronized (NU)
    {
      Iterator localIterator = this.AV.iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).A(paramBoolean);
      }
    }
  }
  
  public static void a(Application paramApplication)
  {
    synchronized (NU)
    {
      if (!NU.NX)
      {
        paramApplication.registerActivityLifecycleCallbacks(NU);
        paramApplication.registerComponentCallbacks(NU);
        NU.NX = true;
      }
      return;
    }
  }
  
  public static d ik()
  {
    return NU;
  }
  
  public final void a(e parame)
  {
    synchronized (NU)
    {
      this.AV.add(parame);
      return;
    }
  }
  
  @TargetApi(16)
  public final boolean il()
  {
    boolean bool = true;
    if (!this.NW.get()) {
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
        if ((!this.NW.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
          this.NV.set(true);
        }
        bool = this.NV.get();
      }
      return bool;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this.NV.compareAndSet(true, false);
    this.NW.set(true);
    if (bool) {
      A(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this.NV.compareAndSet(true, false);
    this.NW.set(true);
    if (bool) {
      A(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this.NV.compareAndSet(false, true)))
    {
      this.NW.set(true);
      A(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.d
 * JD-Core Version:    0.7.0.1
 */