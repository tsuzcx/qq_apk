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
  private a ajYo;
  
  public ScreenBroadcastReceiver(a parama)
  {
    this.ajYo = parama;
  }
  
  public static Context getApplicationContext()
  {
    AppMethodBeat.i(187304);
    try
    {
      Context localContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
      AppMethodBeat.o(187304);
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
    AppMethodBeat.i(187311);
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      this.ajYo.onScreenOn();
      AppMethodBeat.o(187311);
      return;
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      this.ajYo.onScreenOff();
    }
    AppMethodBeat.o(187311);
  }
  
  public static abstract interface a
  {
    public abstract void onScreenOff();
    
    public abstract void onScreenOn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.extra.tools.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */