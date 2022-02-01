package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.e;

public abstract class AbstractResultService
  extends IntentService
{
  public AbstractResultService()
  {
    super("TinkerResultService");
  }
  
  public static void a(Context paramContext, a parama, String paramString)
  {
    if (paramString == null) {
      throw new TinkerRuntimeException("resultServiceClass is null.");
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, paramString);
      localIntent.putExtra("result_extra", parama);
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      com.tencent.tinker.lib.e.a.a("Tinker.AbstractResultService", "run result service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
  }
  
  public abstract void a(a parama);
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      com.tencent.tinker.lib.e.a.a("Tinker.AbstractResultService", "AbstractResultService received a null intent, ignoring.", new Object[0]);
      return;
    }
    a((a)e.c(paramIntent, "result_extra"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.AbstractResultService
 * JD-Core Version:    0.7.0.1
 */