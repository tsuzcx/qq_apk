package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public final class a
  extends android.support.v4.content.a
{
  private static c bw;
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(final Activity paramActivity, String[] paramArrayOfString)
  {
    if ((bw != null) && (bw.A())) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((paramActivity instanceof d)) {
          ((d)paramActivity).j(0);
        }
        paramActivity.requestPermissions(paramArrayOfString, 0);
        return;
      }
    } while (!(paramActivity instanceof b));
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        int[] arrayOfInt = new int[a.this.length];
        PackageManager localPackageManager = paramActivity.getPackageManager();
        String str = paramActivity.getPackageName();
        int j = a.this.length;
        int i = 0;
        while (i < j)
        {
          arrayOfInt[i] = localPackageManager.checkPermission(a.this[i], str);
          i += 1;
        }
        ((b)paramActivity).onRequestPermissionsResult(this.bz, a.this, arrayOfInt);
      }
    });
  }
  
  public static c z()
  {
    return bw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.a
 * JD-Core Version:    0.7.0.1
 */