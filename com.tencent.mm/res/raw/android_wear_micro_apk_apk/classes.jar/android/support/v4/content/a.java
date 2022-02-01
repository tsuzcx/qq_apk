package android.support.v4.content;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.File;

public class a
{
  private static final Object fZ = new Object();
  
  public static File[] a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(null);
    }
    return new File[] { paramContext.getExternalFilesDir(null) };
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  public static File[] b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.content.a
 * JD-Core Version:    0.7.0.1
 */