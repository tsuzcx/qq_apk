package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.ArrayList;

public class DexClassLoaderProviderService
  extends Service
{
  private static final String LOGTAG = "dexloader";
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    DexClassLoaderProvider.setForceLoadDexFlag(true, this);
  }
  
  public void onDestroy()
  {
    System.exit(0);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {}
    do
    {
      return 1;
      paramIntent = paramIntent.getStringArrayListExtra("dex2oat");
    } while (paramIntent == null);
    paramIntent.get(0);
    DexClassLoaderProvider.createDexClassLoader((String)paramIntent.get(1), (String)paramIntent.get(2), (String)paramIntent.get(3), getClassLoader(), getApplicationContext());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProviderService
 * JD-Core Version:    0.7.0.1
 */