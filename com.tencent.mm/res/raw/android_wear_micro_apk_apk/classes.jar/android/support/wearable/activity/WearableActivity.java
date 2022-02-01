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
  private static volatile boolean Ar;
  private WearableActivityController As;
  private boolean At;
  private final String TAG = WearableActivity.class.getSimpleName() + "[" + getClass().getSimpleName() + "]";
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (this.As != null) {
      this.As.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void eU()
  {
    this.At = true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 21) {
      try
      {
        Class.forName("com.google.android.wearable.compat.WearableActivityController");
        this.As = new WearableActivityController(this.TAG, this, new a(this, (byte)0));
        if (!Ar)
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
          Ar = true;
        }
      }
      catch (ClassNotFoundException paramBundle)
      {
        throw new IllegalStateException("Could not find wearable shared library classes. Please add <uses-library android:name=\"com.google.android.wearable\" android:required=\"false\" /> to the application manifest");
      }
    }
    if (this.As != null) {
      this.As.onCreate();
    }
  }
  
  protected void onDestroy()
  {
    if (this.As != null) {
      this.As.onDestroy();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.As != null) {
      this.As.onPause();
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.As != null) {
      this.As.onResume();
    }
  }
  
  protected void onStop()
  {
    if (this.As != null) {
      this.As.onStop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.activity.WearableActivity
 * JD-Core Version:    0.7.0.1
 */