package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
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
    AppMethodBeat.i(63752);
    super.onCreate();
    DexClassLoaderProvider.setForceLoadDexFlag(true, this);
    AppMethodBeat.o(63752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63754);
    System.exit(0);
    AppMethodBeat.o(63754);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63753);
    new StringBuilder("DexClassLoaderProviderService -- onStartCommand(").append(paramIntent).append(")");
    if (paramIntent == null)
    {
      AppMethodBeat.o(63753);
      return 1;
    }
    try
    {
      Object localObject1 = paramIntent.getStringArrayListExtra("dex2oat");
      if (localObject1 == null)
      {
        AppMethodBeat.o(63753);
        return 1;
      }
      Object localObject2 = (String)((ArrayList)localObject1).get(0);
      paramIntent = (String)((ArrayList)localObject1).get(1);
      String str = (String)((ArrayList)localObject1).get(2);
      localObject1 = (String)((ArrayList)localObject1).get(3);
      new StringBuilder("DexClassLoaderProviderService -- onStartCommand(").append((String)localObject2).append(")");
      localObject2 = getClassLoader();
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      DexClassLoaderProvider.createDexClassLoader(paramIntent, str, (String)localObject1, (ClassLoader)localObject2, getApplicationContext());
    }
    catch (Exception paramIntent)
    {
      label164:
      break label164;
    }
    AppMethodBeat.o(63753);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProviderService
 * JD-Core Version:    0.7.0.1
 */