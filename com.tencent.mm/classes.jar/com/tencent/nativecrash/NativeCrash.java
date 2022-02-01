package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class NativeCrash
{
  private static c Mal;
  private static a Mam;
  private static final Charset Man;
  
  static
  {
    AppMethodBeat.i(40117);
    Man = Charset.forName("UTF-8");
    AppMethodBeat.o(40117);
  }
  
  public static a a(a parama)
  {
    a locala = Mam;
    Mam = parama;
    return locala;
  }
  
  public static c a(c paramc)
  {
    c localc = Mal;
    Mal = paramc;
    return localc;
  }
  
  public static void baA(String paramString)
  {
    AppMethodBeat.i(194923);
    if (!InitializationProbe.libLoaded) {
      System.loadLibrary("wechatcrash");
    }
    nativeInit(paramString, 1871, 2048, true);
    AppMethodBeat.o(194923);
  }
  
  public static c fWY()
  {
    return Mal;
  }
  
  public static a fWZ()
  {
    return Mam;
  }
  
  public static void fXa()
  {
    AppMethodBeat.i(40115);
    nativeResetCustomInfo();
    AppMethodBeat.o(40115);
  }
  
  private static native void nativeCustomInfo(byte[] paramArrayOfByte);
  
  private static native void nativeInit(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native void nativeResetCustomInfo();
  
  @Keep
  private static boolean onANRDumped(int paramInt, String paramString)
  {
    AppMethodBeat.i(194925);
    boolean bool = new b(true, paramInt, null, paramString).hZ();
    AppMethodBeat.o(194925);
    return bool;
  }
  
  @Keep
  private static boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194924);
    boolean bool = new b(false, paramInt, paramString1, paramString2).hZ();
    AppMethodBeat.o(194924);
    return bool;
  }
  
  public static void wu(String paramString)
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
      nativeCustomInfo(paramString.getBytes(Man));
      AppMethodBeat.o(40114);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean adM();
  }
  
  static final class b
    implements Runnable
  {
    final NativeCrash.c Mal;
    final NativeCrash.a Mam;
    Throwable Mao;
    final String Map;
    final String Maq;
    final int mStatus;
    boolean vkk;
    
    b(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(194920);
      this.vkk = false;
      this.Mao = null;
      if (paramBoolean) {
        this.Mal = null;
      }
      for (this.Mam = NativeCrash.fWZ();; this.Mam = null)
      {
        this.mStatus = paramInt;
        this.Map = paramString1;
        this.Maq = paramString2;
        AppMethodBeat.o(194920);
        return;
        this.Mal = NativeCrash.fWY();
      }
    }
    
    final boolean hZ()
    {
      AppMethodBeat.i(194921);
      if ((this.Mal == null) && (this.Mam == null))
      {
        AppMethodBeat.o(194921);
        return false;
      }
      Thread localThread = new Thread(this, "NativeCrash Dump Callback");
      localThread.start();
      localThread.join(5000L);
      boolean bool = this.vkk;
      AppMethodBeat.o(194921);
      return bool;
    }
    
    public final void run()
    {
      AppMethodBeat.i(194922);
      try
      {
        if (this.Mam != null)
        {
          this.vkk = this.Mam.adM();
          AppMethodBeat.o(194922);
          return;
        }
        if (this.Mal != null)
        {
          this.vkk = this.Mal.onCrashDumped(this.mStatus, this.Map, this.Maq);
          AppMethodBeat.o(194922);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.Mao = localThrowable;
        AppMethodBeat.o(194922);
        return;
      }
      this.vkk = false;
      AppMethodBeat.o(194922);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean onCrashDumped(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.nativecrash.NativeCrash
 * JD-Core Version:    0.7.0.1
 */