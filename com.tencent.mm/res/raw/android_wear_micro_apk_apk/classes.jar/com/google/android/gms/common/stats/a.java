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
  private static a MN;
  private static final Object Me = new Object();
  private final List<String> MO = Collections.EMPTY_LIST;
  private final List<String> MP = Collections.EMPTY_LIST;
  private final List<String> MQ = Collections.EMPTY_LIST;
  private final List<String> MR = Collections.EMPTY_LIST;
  
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
  
  public static a ib()
  {
    synchronized (Me)
    {
      if (MN == null) {
        MN = new a();
      }
      return MN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.stats.a
 * JD-Core Version:    0.7.0.1
 */