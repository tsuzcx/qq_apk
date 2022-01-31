package android.support.wearable.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.wearable.compat.WearableActivityController;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@TargetApi(21)
public abstract class WearableActivity
  extends Activity
{
  private static volatile boolean yC;
  private final String TAG = WearableActivity.class.getSimpleName() + "[" + getClass().getSimpleName() + "]";
  private WearableActivityController yD;
  private boolean yE;
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (this.yD != null) {
      this.yD.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void eE()
  {
    this.yE = true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 21) {
      try
      {
        Class.forName("com.google.android.wearable.compat.WearableActivityController");
        this.yD = new WearableActivityController(this.TAG, this, new a(this, (byte)0));
        if (!yC)
        {
          try
          {
            paramBundle = a.class.getDeclaredMethod("g", new Class[] { Bundle.class });
            if (!".onEnterAmbient".equals("." + paramBundle.getName())) {
              throw new NoSuchMethodException();
            }
          }
          catch (NoSuchMethodException paramBundle)
          {
            throw new IllegalStateException("Could not find a required method for ambient support, likely due to proguard optimization. Please add com.google.android.wearable:wearable jar to the list of library jars for your project");
          }
          yC = true;
        }
      }
      catch (ClassNotFoundException paramBundle)
      {
        throw new IllegalStateException("Could not find wearable shared library classes. Please add <uses-library android:name=\"com.google.android.wearable\" android:required=\"false\" /> to the application manifest");
      }
    }
    if (this.yD != null) {
      this.yD.onCreate();
    }
  }
  
  protected void onDestroy()
  {
    if (this.yD != null) {
      this.yD.onDestroy();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.yD != null) {
      this.yD.onPause();
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.yD != null) {
      this.yD.onResume();
    }
  }
  
  protected void onStop()
  {
    if (this.yD != null) {
      this.yD.onStop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.activity.WearableActivity
 * JD-Core Version:    0.7.0.1
 */