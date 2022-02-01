package com.tenpay.ndk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FitScLibraryLoader
{
  private static ILoader sLoaderImpl = ILoader.DEFAULT;
  
  public static void load(String paramString)
  {
    AppMethodBeat.i(208514);
    sLoaderImpl.loadLibrary(paramString);
    AppMethodBeat.o(208514);
  }
  
  public static void setLoader(ILoader paramILoader)
  {
    if (paramILoader == null)
    {
      sLoaderImpl = ILoader.DEFAULT;
      return;
    }
    sLoaderImpl = paramILoader;
  }
  
  public static abstract interface ILoader
  {
    public static final ILoader DEFAULT = new ILoader()
    {
      private byte _hellAccFlag_;
      
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(208512);
        paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/tenpay/ndk/FitScLibraryLoader$ILoader$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramAnonymousString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tenpay/ndk/FitScLibraryLoader$ILoader$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(208512);
      }
    };
    
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tenpay.ndk.FitScLibraryLoader
 * JD-Core Version:    0.7.0.1
 */