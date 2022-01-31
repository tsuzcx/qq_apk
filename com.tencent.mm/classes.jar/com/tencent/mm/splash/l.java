package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import java.lang.reflect.Field;
import java.util.ArrayList;

final class l
  extends Instrumentation
{
  public Instrumentation umt;
  
  public l(Instrumentation paramInstrumentation)
  {
    this.umt = paramInstrumentation;
    ctm();
  }
  
  private void ctm()
  {
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(this.umt);
      arrayOfField[i].set(this, localObject);
      i += 1;
    }
  }
  
  public final Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    if (i.ulK != null) {
      i.ulK.cr(paramString);
    }
    if ((i.csW()) && (!i.ctd().getCanonicalName().equals(paramString)))
    {
      paramClassLoader = new j();
      paramClassLoader.umf = paramString;
      i.c("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", new Object[] { paramString });
      i.ulE.add(paramClassLoader);
      paramString = paramClassLoader;
      return paramString;
    }
    paramClassLoader = super.newActivity(paramClassLoader, paramString, paramIntent);
    Object localObject = i.bwZ;
    if (localObject != null)
    {
      localObject = ((d)localObject).k(paramClassLoader);
      if (localObject != paramClassLoader)
      {
        i.c("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", new Object[] { paramString, localObject });
        paramClassLoader = (ClassLoader)localObject;
      }
    }
    for (;;)
    {
      paramString = paramClassLoader;
      if (!k.ctl()) {
        break;
      }
      i.c("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
      paramIntent.putExtra("splash-hack-activity-recreate", true);
      return paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.l
 * JD-Core Version:    0.7.0.1
 */