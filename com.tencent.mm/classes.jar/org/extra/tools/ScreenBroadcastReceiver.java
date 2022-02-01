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
  private a abLv;
  
  public ScreenBroadcastReceiver(a parama)
  {
    this.abLv = parama;
  }
  
  public static Context getApplicationContext()
  {
    AppMethodBeat.i(194798);
    try
    {
      Context localContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
      AppMethodBeat.o(194798);
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
    AppMethodBeat.i(194796);
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      this.abLv.onScreenOn();
      AppMethodBeat.o(194796);
      return;
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      this.abLv.onScreenOff();
    }
    AppMethodBeat.o(194796);
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