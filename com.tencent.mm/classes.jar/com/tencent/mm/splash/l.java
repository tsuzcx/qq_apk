package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateAuxActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

final class l
  extends Instrumentation
{
  public Instrumentation UZZ;
  
  public l(Instrumentation paramInstrumentation)
  {
    AppMethodBeat.i(40679);
    this.UZZ = paramInstrumentation;
    hux();
    AppMethodBeat.o(40679);
  }
  
  private void hux()
  {
    AppMethodBeat.i(40681);
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(this.UZZ);
      arrayOfField[i].set(this, localObject);
      i += 1;
    }
    AppMethodBeat.o(40681);
  }
  
  public final Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(40680);
    if (i.UZq != null) {
      i.UZq.gX(paramString);
    }
    if ((i.huj()) && (!i.hup().getCanonicalName().equals(paramString)) && (!i.buD(paramString)) && (!ExtStorageMigrateAuxActivity.class.getName().equals(paramString)))
    {
      paramClassLoader = new j();
      paramClassLoader.UZM = paramString;
      i.g("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", new Object[] { paramString });
      i.UZl.add(paramClassLoader);
      AppMethodBeat.o(40680);
      return paramClassLoader;
    }
    paramClassLoader = super.newActivity(paramClassLoader, paramString, paramIntent);
    Object localObject = i.fdI;
    if (localObject != null)
    {
      localObject = ((d)localObject).p(paramClassLoader);
      if (localObject != paramClassLoader)
      {
        i.g("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", new Object[] { paramString, localObject });
        paramClassLoader = (ClassLoader)localObject;
      }
    }
    for (;;)
    {
      if (k.huw())
      {
        i.g("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
        paramIntent.putExtra("splash-hack-activity-recreate", true);
      }
      AppMethodBeat.o(40680);
      return paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.splash.l
 * JD-Core Version:    0.7.0.1
 */