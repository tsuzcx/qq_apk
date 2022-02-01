package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

final class k
  extends Instrumentation
{
  public Instrumentation IFw;
  
  public k(Instrumentation paramInstrumentation)
  {
    AppMethodBeat.i(40679);
    this.IFw = paramInstrumentation;
    frx();
    AppMethodBeat.o(40679);
  }
  
  private void frx()
  {
    AppMethodBeat.i(40681);
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(this.IFw);
      arrayOfField[i].set(this, localObject);
      i += 1;
    }
    AppMethodBeat.o(40681);
  }
  
  public final Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(40680);
    if (h.IEN != null) {
      h.IEN.fA(paramString);
    }
    if ((h.frj()) && (!h.frp().getCanonicalName().equals(paramString)) && (!h.aTs(paramString)) && (!ExtStorageMigrateAuxActivity.class.getName().equals(paramString)))
    {
      paramClassLoader = new i();
      paramClassLoader.IFj = paramString;
      h.b("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", new Object[] { paramString });
      h.IEI.add(paramClassLoader);
      AppMethodBeat.o(40680);
      return paramClassLoader;
    }
    paramClassLoader = super.newActivity(paramClassLoader, paramString, paramIntent);
    Object localObject = h.cVK;
    if (localObject != null)
    {
      localObject = ((d)localObject).q(paramClassLoader);
      if (localObject != paramClassLoader)
      {
        h.b("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", new Object[] { paramString, localObject });
        paramClassLoader = (ClassLoader)localObject;
      }
    }
    for (;;)
    {
      if (j.frw())
      {
        h.b("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
        paramIntent.putExtra("splash-hack-activity-recreate", true);
      }
      AppMethodBeat.o(40680);
      return paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.k
 * JD-Core Version:    0.7.0.1
 */