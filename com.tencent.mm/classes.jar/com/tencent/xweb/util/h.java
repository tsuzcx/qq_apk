package com.tencent.xweb.util;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;

public final class h
{
  private static ClassLoader a(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(183533);
    Object localObject = paramString1;
    if (Build.VERSION.SDK_INT >= 29)
    {
      localObject = paramString1;
      if (paramString1.endsWith("classes.dex"))
      {
        localObject = paramString1;
        if (!"true".equalsIgnoreCase(a.nb("NOT_USE_JAR_REPLACE_DEX", "tools")))
        {
          Log.i("XWebClassLoaderWrapper", "use .jar instead of .dex");
          String str = paramString1.replace("classes.dex", "classes.dex.jar");
          localObject = paramString1;
          if (new File(str).exists()) {
            localObject = str;
          }
        }
      }
    }
    paramString1 = new DexClassLoader((String)localObject, paramString2, paramString3, paramClassLoader);
    AppMethodBeat.o(183533);
    return paramString1;
  }
  
  public static ClassLoader bp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(183532);
    paramString1 = a(paramString1, paramString2, paramString3, ClassLoader.getSystemClassLoader());
    AppMethodBeat.o(183532);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.h
 * JD-Core Version:    0.7.0.1
 */