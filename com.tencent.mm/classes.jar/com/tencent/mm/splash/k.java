package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;

final class k
  extends Instrumentation
{
  public Instrumentation yvZ;
  
  public k(Instrumentation paramInstrumentation)
  {
    AppMethodBeat.i(114885);
    this.yvZ = paramInstrumentation;
    brK();
    AppMethodBeat.o(114885);
  }
  
  private void brK()
  {
    AppMethodBeat.i(114887);
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(this.yvZ);
      arrayOfField[i].set(this, localObject);
      i += 1;
    }
    AppMethodBeat.o(114887);
  }
  
  public final Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(114886);
    if (h.yvp != null) {
      h.yvp.dD(paramString);
    }
    if ((h.dvu()) && (!h.dvA().getCanonicalName().equals(paramString)))
    {
      paramClassLoader = new i();
      paramClassLoader.yvL = paramString;
      h.c("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", new Object[] { paramString });
      h.yvj.add(paramClassLoader);
      AppMethodBeat.o(114886);
      return paramClassLoader;
    }
    paramClassLoader = super.newActivity(paramClassLoader, paramString, paramIntent);
    Object localObject = h.bYM;
    if (localObject != null)
    {
      localObject = ((d)localObject).l(paramClassLoader);
      if (localObject != paramClassLoader)
      {
        h.c("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", new Object[] { paramString, localObject });
        paramClassLoader = (ClassLoader)localObject;
      }
    }
    for (;;)
    {
      if (j.dvI())
      {
        h.c("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
        paramIntent.putExtra("splash-hack-activity-recreate", true);
      }
      AppMethodBeat.o(114886);
      return paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.k
 * JD-Core Version:    0.7.0.1
 */