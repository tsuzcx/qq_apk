package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.util.ArrayList;

final class l
  extends Instrumentation
{
  public Instrumentation XMV;
  
  public l(Instrumentation paramInstrumentation)
  {
    AppMethodBeat.i(40679);
    this.XMV = paramInstrumentation;
    iGj();
    AppMethodBeat.o(40679);
  }
  
  private void iGj()
  {
    AppMethodBeat.i(40681);
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(this.XMV);
      arrayOfField[i].set(this, localObject);
      i += 1;
    }
    AppMethodBeat.o(40681);
  }
  
  public final Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(40680);
    if (i.acAI != null) {
      i.acAI.iy(paramString);
    }
    if ((i.iVM()) && (!i.iVS().getCanonicalName().equals(paramString)) && (!i.buJ(paramString)) && (!ExtStorageMigrateAuxActivity.class.getName().equals(paramString)))
    {
      paramClassLoader = new j(q.shouldBlock(MMApplicationContext.getContext()));
      paramClassLoader.acBe = paramString;
      i.g("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", new Object[] { paramString });
      i.acAD.add(paramClassLoader);
      AppMethodBeat.o(40680);
      return paramClassLoader;
    }
    paramClassLoader = super.newActivity(paramClassLoader, paramString, paramIntent);
    Object localObject = i.hhy;
    if (localObject != null)
    {
      localObject = ((d)localObject).q(paramClassLoader);
      if (localObject != paramClassLoader)
      {
        i.g("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", new Object[] { paramString, localObject });
        paramClassLoader = (ClassLoader)localObject;
      }
    }
    for (;;)
    {
      if (k.iVZ())
      {
        i.g("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
        paramIntent.putExtra("splash-hack-activity-recreate", true);
      }
      AppMethodBeat.o(40680);
      return paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.splash.l
 * JD-Core Version:    0.7.0.1
 */