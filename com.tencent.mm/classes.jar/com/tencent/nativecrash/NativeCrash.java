package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class NativeCrash
{
  private static final Charset JJA;
  private static c JJy;
  private static a JJz;
  
  static
  {
    AppMethodBeat.i(40117);
    JJA = Charset.forName("UTF-8");
    AppMethodBeat.o(40117);
  }
  
  public static a a(a parama)
  {
    a locala = JJz;
    JJz = parama;
    return locala;
  }
  
  public static c a(c paramc)
  {
    c localc = JJy;
    JJy = paramc;
    return localc;
  }
  
  public static void aSX(String paramString)
  {
    AppMethodBeat.i(198541);
    if (!InitializationProbe.libLoaded) {
      System.loadLibrary("wechatcrash");
    }
    nativeInit(paramString, 1871, 2048, true);
    AppMethodBeat.o(198541);
  }
  
  public static c fBj()
  {
    return JJy;
  }
  
  public static a fBk()
  {
    return JJz;
  }
  
  public static void fBl()
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
    AppMethodBeat.i(198543);
    boolean bool = new b(true, paramInt, null, paramString).hJ();
    AppMethodBeat.o(198543);
    return bool;
  }
  
  @Keep
  private static boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(198542);
    boolean bool = new b(false, paramInt, paramString1, paramString2).hJ();
    AppMethodBeat.o(198542);
    return bool;
  }
  
  public static void sY(String paramString)
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
      nativeCustomInfo(paramString.getBytes(JJA));
      AppMethodBeat.o(40114);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean aaX();
  }
  
  static final class b
    implements Runnable
  {
    Throwable JJB;
    final String JJC;
    final String JJD;
    final NativeCrash.c JJy;
    final NativeCrash.a JJz;
    final int mStatus;
    boolean tVR;
    
    b(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(198538);
      this.tVR = false;
      this.JJB = null;
      if (paramBoolean) {
        this.JJy = null;
      }
      for (this.JJz = NativeCrash.fBk();; this.JJz = null)
      {
        this.mStatus = paramInt;
        this.JJC = paramString1;
        this.JJD = paramString2;
        AppMethodBeat.o(198538);
        return;
        this.JJy = NativeCrash.fBj();
      }
    }
    
    final boolean hJ()
    {
      AppMethodBeat.i(198539);
      if ((this.JJy == null) && (this.JJz == null))
      {
        AppMethodBeat.o(198539);
        return false;
      }
      Thread localThread = new Thread(this, "NativeCrash Dump Callback");
      localThread.start();
      localThread.join(5000L);
      boolean bool = this.tVR;
      AppMethodBeat.o(198539);
      return bool;
    }
    
    public final void run()
    {
      AppMethodBeat.i(198540);
      try
      {
        if (this.JJz != null)
        {
          this.tVR = this.JJz.aaX();
          AppMethodBeat.o(198540);
          return;
        }
        if (this.JJy != null)
        {
          this.tVR = this.JJy.onCrashDumped(this.mStatus, this.JJC, this.JJD);
          AppMethodBeat.o(198540);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.JJB = localThrowable;
        AppMethodBeat.o(198540);
        return;
      }
      this.tVR = false;
      AppMethodBeat.o(198540);
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