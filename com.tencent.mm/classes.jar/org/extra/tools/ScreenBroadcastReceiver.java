package org.extra.tools;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  private a Otc;
  
  public ScreenBroadcastReceiver(a parama)
  {
    this.Otc = parama;
  }
  
  public static Context getApplicationContext()
  {
    AppMethodBeat.i(216862);
    try
    {
      Context localContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
      AppMethodBeat.o(216862);
      return localContext;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(216861);
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      this.Otc.onScreenOn();
      AppMethodBeat.o(216861);
      return;
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      this.Otc.onScreenOff();
    }
    AppMethodBeat.o(216861);
  }
  
  public static abstract interface a
  {
    public abstract void onScreenOff();
    
    public abstract void onScreenOn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.tools.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */