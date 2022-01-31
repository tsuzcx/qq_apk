package com.tencent.smtt.export.external;

import android.app.Service;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.TimerTask;

final class DexClassLoaderProvider$2
  extends TimerTask
{
  DexClassLoaderProvider$2(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, String paramString4) {}
  
  public final void run()
  {
    boolean bool1 = true;
    AppMethodBeat.i(63722);
    try
    {
      Object localObject = new File(this.val$dexPath.replace(".jar", ".dex"));
      if ((((File)localObject).exists()) && (((File)localObject).length() != 0L)) {
        new StringBuilder().append(localObject).append(" existed!");
      }
      for (;;)
      {
        localObject = new File(this.val$optimizedDirectory);
        File localFile = new File(this.val$dexPath);
        boolean bool2 = ((File)localObject).exists();
        boolean bool3 = ((File)localObject).isDirectory();
        boolean bool4 = localFile.exists();
        if ((bool2) && (bool3) && (bool4)) {
          break;
        }
        new StringBuilder("dex loading exception(").append(bool2).append(", ").append(bool3).append(", ").append(bool4).append(")");
        AppMethodBeat.o(63722);
        return;
        new StringBuilder().append(localObject).append(" does not existed!");
        bool1 = false;
      }
      long l = System.currentTimeMillis();
      new DexClassLoader(this.val$dexPath, this.val$optimizedDirectory, this.val$libraryPath, this.val$parent);
      localObject = String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool1) });
      new StringBuilder().append((String)localObject);
      if ((DexClassLoaderProvider.access$100()) && ("tbs_jars_fusion_dex.jar".equals(this.val$dexName)))
      {
        new StringBuilder("Stop provider service after loading ").append(this.val$dexName);
        if (DexClassLoaderProvider.mService != null) {
          DexClassLoaderProvider.mService.stopSelf();
        }
      }
      AppMethodBeat.o(63722);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("@AsyncDexLoad task exception: ").append(localThrowable);
      AppMethodBeat.o(63722);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider.2
 * JD-Core Version:    0.7.0.1
 */