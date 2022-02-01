package com.tencent.mm.wear.app;

import android.app.Application;
import android.content.Context;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.b.h;

public class MMApplication
  extends Application
{
  private static final String TAG = "MicroMsg.MMApplcation";
  private static Context context;
  
  public static final Context getContext()
  {
    return context;
  }
  
  public void onCreate()
  {
    super.onCreate();
    d.c("MicroMsg.MMApplcation", "Create Application", new Object[0]);
    context = this;
    h.mL();
  }
  
  public void onTerminate()
  {
    d.d("MicroMsg.MMApplcation", "Terminate Application", new Object[0]);
    h.mM();
    super.onTerminate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.MMApplication
 * JD-Core Version:    0.7.0.1
 */