package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.d;
import java.util.Collections;
import java.util.List;

public final class a
{
  private static a KY;
  private static final Object Kp = new Object();
  private final List<String> KZ = Collections.EMPTY_LIST;
  private final List<String> La = Collections.EMPTY_LIST;
  private final List<String> Lb = Collections.EMPTY_LIST;
  private final List<String> Lc = Collections.EMPTY_LIST;
  
  @SuppressLint({"UntrackedBindService"})
  public static void a(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
  }
  
  @SuppressLint({"UntrackedBindService"})
  public static boolean a(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName == null) {}
    for (boolean bool = false; bool; bool = d.f(paramContext, localComponentName.getPackageName()))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    return paramContext.bindService(paramIntent, paramServiceConnection, 129);
  }
  
  public static a hR()
  {
    synchronized (Kp)
    {
      if (KY == null) {
        KY = new a();
      }
      return KY;
    }
  }
  
  public static void hS() {}
  
  public static void hT() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.stats.a
 * JD-Core Version:    0.7.0.1
 */