package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class NativeCrash
{
  private static a IhQ;
  private static final Charset IhR;
  
  static
  {
    AppMethodBeat.i(40117);
    IhR = Charset.forName("UTF-8");
    AppMethodBeat.o(40117);
  }
  
  public static a a(a parama)
  {
    a locala = IhQ;
    IhQ = parama;
    return locala;
  }
  
  public static void aNu(String paramString)
  {
    AppMethodBeat.i(40113);
    if (!InitializationProbe.libLoaded) {
      System.loadLibrary("wechatcrash");
    }
    nativeInit(paramString, 1871, 2048);
    AppMethodBeat.o(40113);
  }
  
  public static void fkT()
  {
    AppMethodBeat.i(40115);
    nativeResetCustomInfo();
    AppMethodBeat.o(40115);
  }
  
  private static native void nativeCustomInfo(byte[] paramArrayOfByte);
  
  private static native void nativeInit(String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeResetCustomInfo();
  
  @Keep
  private static void onDumped(int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(40116);
    final Throwable[] arrayOfThrowable = new Throwable[1];
    paramString1 = new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40112);
        NativeCrash.a locala = NativeCrash.fkU();
        if (locala != null) {
          try
          {
            locala.h(this.hwJ, paramString1, paramString2);
            AppMethodBeat.o(40112);
            return;
          }
          catch (Throwable localThrowable)
          {
            arrayOfThrowable[0] = localThrowable;
          }
        }
        AppMethodBeat.o(40112);
      }
    }, "NativeCrash Dump Callback");
    paramString1.start();
    try
    {
      paramString1.join(5000L);
      label42:
      if (arrayOfThrowable[0] != null)
      {
        paramString1 = arrayOfThrowable[0];
        AppMethodBeat.o(40116);
        throw paramString1;
      }
      AppMethodBeat.o(40116);
      return;
    }
    catch (InterruptedException paramString1)
    {
      break label42;
    }
  }
  
  public static void pN(String paramString)
  {
    AppMethodBeat.i(40114);
    if (paramString == null)
    {
      AppMethodBeat.o(40114);
      return;
    }
    if (!paramString.endsWith("\n")) {}
    for (paramString = paramString + "";; paramString = paramString + '\000')
    {
      nativeCustomInfo(paramString.getBytes(IhR));
      AppMethodBeat.o(40114);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void h(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.nativecrash.NativeCrash
 * JD-Core Version:    0.7.0.1
 */