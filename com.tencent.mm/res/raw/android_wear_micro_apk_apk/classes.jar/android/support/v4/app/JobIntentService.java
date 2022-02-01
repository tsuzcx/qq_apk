package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService
  extends Service
{
  static final Object fZ = new Object();
  static final HashMap<ComponentName, Object> ga = new HashMap();
  boolean dL = false;
  boolean eo = false;
  boolean fX = false;
  final ArrayList<Object> fY;
  
  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.fY = null;
      return;
    }
    this.fY = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */