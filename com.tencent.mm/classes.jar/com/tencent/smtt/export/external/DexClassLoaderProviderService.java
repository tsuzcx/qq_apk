package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.io.File;
import java.util.ArrayList;

public class DexClassLoaderProviderService
  extends Service
{
  private static final String LOGTAG = "dexloader";
  private byte _hellAccFlag_;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(53132);
    super.onCreate();
    DexClassLoaderProvider.setForceLoadDexFlag(true, this);
    AppMethodBeat.o(53132);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53134);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/smtt/export/external/DexClassLoaderProviderService", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)locala.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/smtt/export/external/DexClassLoaderProviderService", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(53134);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53133);
    new StringBuilder("DexClassLoaderProviderService -- onStartCommand(").append(paramIntent).append(")");
    if (paramIntent == null)
    {
      AppMethodBeat.o(53133);
      return 1;
    }
    try
    {
      Object localObject1 = paramIntent.getStringArrayListExtra("dex2oat");
      if (localObject1 == null)
      {
        AppMethodBeat.o(53133);
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
    AppMethodBeat.o(53133);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProviderService
 * JD-Core Version:    0.7.0.1
 */