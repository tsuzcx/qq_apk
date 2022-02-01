package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWebLibraryLoader
{
  private static IXWebLibraryLoader DEFAULT;
  private static IXWebLibraryLoader sXWebLibraryLoader;
  
  static
  {
    AppMethodBeat.i(4312);
    IXWebLibraryLoader local1 = new IXWebLibraryLoader()
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
        AppMethodBeat.i(4308);
        try
        {
          com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/xweb/skia_canvas/XWebLibraryLoader$1", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
          System.loadLibrary((String)locala.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/xweb/skia_canvas/XWebLibraryLoader$1", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
          AppMethodBeat.o(4308);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            XWebLibraryLoader.class.getSimpleName();
            String.format("%s load fail %s", new Object[] { paramAnonymousString, localException });
          }
        }
      }
    };
    DEFAULT = local1;
    sXWebLibraryLoader = local1;
    AppMethodBeat.o(4312);
  }
  
  public static void afetrLoad()
  {
    AppMethodBeat.i(4311);
    sXWebLibraryLoader.afterLoad();
    AppMethodBeat.o(4311);
  }
  
  public static void beforeLoad()
  {
    AppMethodBeat.i(4310);
    sXWebLibraryLoader.beforeLoad();
    AppMethodBeat.o(4310);
  }
  
  public static void initXWebLibraryLoader(IXWebLibraryLoader paramIXWebLibraryLoader)
  {
    sXWebLibraryLoader = paramIXWebLibraryLoader;
  }
  
  public static boolean load(String paramString)
  {
    AppMethodBeat.i(4309);
    boolean bool = sXWebLibraryLoader.load(paramString);
    AppMethodBeat.o(4309);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebLibraryLoader
 * JD-Core Version:    0.7.0.1
 */