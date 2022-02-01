package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.as;
import android.support.v4.app.at;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.aa;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.k;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.az;
import com.google.android.gms.internal.zzaaz;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  extends h
{
  private static final b IW = new b();
  public static final int IX = h.IX;
  
  public static Dialog a(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject).setIndeterminate(true);
    ((ProgressBar)localObject).setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView((View)localObject);
    localBuilder.setMessage(z.e(paramActivity, 18));
    localBuilder.setPositiveButton("", null);
    localObject = localBuilder.create();
    a(paramActivity, (Dialog)localObject, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return localObject;
  }
  
  private static Dialog a(Context paramContext, int paramInt, aa paramaa, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AlertDialog.Builder localBuilder = null;
    if (paramInt == 0) {
      return null;
    }
    Object localObject = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, (TypedValue)localObject, true);
    if ("Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(((TypedValue)localObject).resourceId))) {
      localBuilder = new AlertDialog.Builder(paramContext, 5);
    }
    localObject = localBuilder;
    if (localBuilder == null) {
      localObject = new AlertDialog.Builder(paramContext);
    }
    ((AlertDialog.Builder)localObject).setMessage(z.e(paramContext, paramInt));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = z.g(paramContext, paramInt);
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setPositiveButton(paramOnCancelListener, paramaa);
    }
    paramContext = z.c(paramContext, paramInt);
    if (paramContext != null) {
      ((AlertDialog.Builder)localObject).setTitle(paramContext);
    }
    return ((AlertDialog.Builder)localObject).create();
  }
  
  public static zzaaz a(Context paramContext, au paramau)
  {
    Object localObject = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addDataScheme("package");
    zzaaz localzzaaz = new zzaaz(paramau);
    paramContext.registerReceiver(localzzaaz, (IntentFilter)localObject);
    localzzaaz.setContext(paramContext);
    localObject = localzzaaz;
    if (!n.h(paramContext, "com.google.android.gms"))
    {
      paramau.in();
      localzzaaz.unregister();
      localObject = null;
    }
    return localObject;
  }
  
  private static void a(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).ah();
      e.b(paramDialog, paramOnCancelListener).a(paramActivity, paramString);
      return;
    }
    paramActivity = paramActivity.getFragmentManager();
    a.a(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
  }
  
  @TargetApi(20)
  private void a(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    if (paramInt == 18) {
      e(paramContext);
    }
    do
    {
      return;
      if (paramPendingIntent != null) {
        break;
      }
    } while (paramInt != 6);
    Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
    return;
    paramString = z.d(paramContext, paramInt);
    String str = z.f(paramContext, paramInt);
    Resources localResources = paramContext.getResources();
    if (g.k(paramContext))
    {
      com.google.android.gms.common.internal.d.y(k.id());
      paramString = new Notification.Builder(paramContext).setSmallIcon(paramContext.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(paramString).setStyle(new Notification.BigTextStyle().bigText(str)).addAction(com.google.android.gms.c.HG, localResources.getString(com.google.android.gms.d.HX), paramPendingIntent).build();
      switch (paramInt)
      {
      }
    }
    for (paramInt = 39789;; paramInt = 10436)
    {
      ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramString);
      return;
      paramString = new at(paramContext).t(17301642).d(localResources.getString(com.google.android.gms.d.HP)).a(System.currentTimeMillis()).aM().a(paramPendingIntent).b(paramString).c(str).aN().a(new as().a(str)).build();
      break;
      n.Nm.set(false);
    }
  }
  
  private void e(Context paramContext)
  {
    new c(this, paramContext).sendEmptyMessageDelayed(1, 120000L);
  }
  
  public static b gz()
  {
    return IW;
  }
  
  public final PendingIntent a(Context paramContext, int paramInt1, int paramInt2)
  {
    return super.a(paramContext, paramInt1, paramInt2);
  }
  
  public final PendingIntent a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return super.a(paramContext, paramInt1, paramInt2, paramString);
  }
  
  public final Intent a(Context paramContext, int paramInt, String paramString)
  {
    return super.a(paramContext, paramInt, paramString);
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null, a(paramContext, paramInt, 0, "n"));
  }
  
  public final boolean a(Activity paramActivity, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = a(paramActivity, paramInt, aa.a(paramActivity, super.a(paramActivity, paramInt, "d"), 2), paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    a(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public final boolean a(Activity paramActivity, az paramaz, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramaz = a(paramActivity, paramInt, aa.a(paramaz, super.a(paramActivity, paramInt, "d"), 2), paramOnCancelListener);
    if (paramaz == null) {
      return false;
    }
    a(paramActivity, paramaz, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public final boolean a(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    boolean bool = false;
    if (paramConnectionResult.gv()) {}
    for (PendingIntent localPendingIntent = paramConnectionResult.gx();; localPendingIntent = super.a(paramContext, paramConnectionResult.getErrorCode(), 0))
    {
      if (localPendingIntent != null)
      {
        a(paramContext, paramConnectionResult.getErrorCode(), null, GoogleApiActivity.a(paramContext, localPendingIntent, paramInt));
        bool = true;
      }
      return bool;
    }
  }
  
  public final boolean b(Context paramContext, int paramInt)
  {
    return super.b(paramContext, paramInt);
  }
  
  public final boolean bt(int paramInt)
  {
    return super.bt(paramInt);
  }
  
  @Deprecated
  public final Intent bu(int paramInt)
  {
    return super.bu(paramInt);
  }
  
  public final String bv(int paramInt)
  {
    return super.bv(paramInt);
  }
  
  public final int d(Context paramContext)
  {
    return super.d(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.b
 * JD-Core Version:    0.7.0.1
 */