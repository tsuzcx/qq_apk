package com.tencent.skyline.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkylineLibraryLoader
{
  private static ISkylineLibraryLoader DEFAULT;
  private static ISkylineLibraryLoader sSkylineLibraryLoader;
  
  static
  {
    AppMethodBeat.i(210713);
    ISkylineLibraryLoader local1 = new ISkylineLibraryLoader()
    {
      private byte _hellAccFlag_;
      
      public final boolean afterLoad()
      {
        return false;
      }
      
      public final boolean beforeLoad()
      {
        return false;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(210721);
        try
        {
          com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/skyline/jni/SkylineLibraryLoader$1", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
          System.loadLibrary((String)locala.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/skyline/jni/SkylineLibraryLoader$1", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
          AppMethodBeat.o(210721);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            SkylineLibraryLoader.class.getSimpleName();
            String.format("%s load fail %s", new Object[] { paramAnonymousString, localException });
          }
        }
      }
    };
    DEFAULT = local1;
    sSkylineLibraryLoader = local1;
    AppMethodBeat.o(210713);
  }
  
  public static void afterLoad()
  {
    AppMethodBeat.i(210707);
    sSkylineLibraryLoader.afterLoad();
    AppMethodBeat.o(210707);
  }
  
  public static void beforeLoad()
  {
    AppMethodBeat.i(210700);
    sSkylineLibraryLoader.beforeLoad();
    AppMethodBeat.o(210700);
  }
  
  public static void initXWebLibraryLoader(ISkylineLibraryLoader paramISkylineLibraryLoader)
  {
    sSkylineLibraryLoader = paramISkylineLibraryLoader;
  }
  
  public static boolean load(String paramString)
  {
    AppMethodBeat.i(210693);
    boolean bool = sSkylineLibraryLoader.load(paramString);
    AppMethodBeat.o(210693);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.skyline.jni.SkylineLibraryLoader
 * JD-Core Version:    0.7.0.1
 */