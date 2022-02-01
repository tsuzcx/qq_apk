package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class NativeCrash
{
  private static c LDh;
  private static a LDi;
  private static final Charset LDj;
  
  static
  {
    AppMethodBeat.i(40117);
    LDj = Charset.forName("UTF-8");
    AppMethodBeat.o(40117);
  }
  
  public static a a(a parama)
  {
    a locala = LDi;
    LDi = parama;
    return locala;
  }
  
  public static c a(c paramc)
  {
    c localc = LDh;
    LDh = paramc;
    return localc;
  }
  
  public static void aYX(String paramString)
  {
    AppMethodBeat.i(186408);
    if (!InitializationProbe.libLoaded) {
      System.loadLibrary("wechatcrash");
    }
    nativeInit(paramString, 1871, 2048, true);
    AppMethodBeat.o(186408);
  }
  
  public static void fSA()
  {
    AppMethodBeat.i(40115);
    nativeResetCustomInfo();
    AppMethodBeat.o(40115);
  }
  
  public static c fSy()
  {
    return LDh;
  }
  
  public static a fSz()
  {
    return LDi;
  }
  
  private static native void nativeCustomInfo(byte[] paramArrayOfByte);
  
  private static native void nativeInit(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native void nativeResetCustomInfo();
  
  @Keep
  private static boolean onANRDumped(int paramInt, String paramString)
  {
    AppMethodBeat.i(186410);
    boolean bool = new b(true, paramInt, null, paramString).hZ();
    AppMethodBeat.o(186410);
    return bool;
  }
  
  @Keep
  private static boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186409);
    boolean bool = new b(false, paramInt, paramString1, paramString2).hZ();
    AppMethodBeat.o(186409);
    return bool;
  }
  
  public static void vN(String paramString)
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
      nativeCustomInfo(paramString.getBytes(LDj));
      AppMethodBeat.o(40114);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean adA();
  }
  
  static final class b
    implements Runnable
  {
    final NativeCrash.c LDh;
    final NativeCrash.a LDi;
    Throwable LDk;
    final String LDl;
    final String LDm;
    final int mStatus;
    boolean uYv;
    
    b(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(186405);
      this.uYv = false;
      this.LDk = null;
      if (paramBoolean) {
        this.LDh = null;
      }
      for (this.LDi = NativeCrash.fSz();; this.LDi = null)
      {
        this.mStatus = paramInt;
        this.LDl = paramString1;
        this.LDm = paramString2;
        AppMethodBeat.o(186405);
        return;
        this.LDh = NativeCrash.fSy();
      }
    }
    
    final boolean hZ()
    {
      AppMethodBeat.i(186406);
      if ((this.LDh == null) && (this.LDi == null))
      {
        AppMethodBeat.o(186406);
        return false;
      }
      Thread localThread = new Thread(this, "NativeCrash Dump Callback");
      localThread.start();
      localThread.join(5000L);
      boolean bool = this.uYv;
      AppMethodBeat.o(186406);
      return bool;
    }
    
    public final void run()
    {
      AppMethodBeat.i(186407);
      try
      {
        if (this.LDi != null)
        {
          this.uYv = this.LDi.adA();
          AppMethodBeat.o(186407);
          return;
        }
        if (this.LDh != null)
        {
          this.uYv = this.LDh.onCrashDumped(this.mStatus, this.LDl, this.LDm);
          AppMethodBeat.o(186407);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.LDk = localThrowable;
        AppMethodBeat.o(186407);
        return;
      }
      this.uYv = false;
      AppMethodBeat.o(186407);
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