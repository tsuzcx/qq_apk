package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class NativeCrash
{
  private static c RAD;
  private static a RAE;
  private static final Charset RAF;
  
  static
  {
    AppMethodBeat.i(40117);
    RAF = Charset.forName("UTF-8");
    AppMethodBeat.o(40117);
  }
  
  public static void EJ(String paramString)
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
      nativeCustomInfo(paramString.getBytes(RAF));
      AppMethodBeat.o(40114);
      return;
    }
  }
  
  public static c a(c paramc)
  {
    c localc = RAD;
    RAD = paramc;
    return localc;
  }
  
  public static void bpJ(String paramString)
  {
    AppMethodBeat.i(196955);
    if (!InitializationProbe.libLoaded) {
      System.loadLibrary("wechatcrash");
    }
    nativeInit(paramString, 1871, 2048, false);
    AppMethodBeat.o(196955);
  }
  
  public static c hiC()
  {
    return RAD;
  }
  
  public static a hiD()
  {
    return RAE;
  }
  
  public static void hiE()
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
    AppMethodBeat.i(196957);
    boolean bool = new b(true, paramInt, null, paramString).ij();
    AppMethodBeat.o(196957);
    return bool;
  }
  
  @Keep
  private static boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(196956);
    boolean bool = new b(false, paramInt, paramString1, paramString2).ij();
    AppMethodBeat.o(196956);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean hiF();
  }
  
  static final class b
    implements Runnable
  {
    final NativeCrash.c RAD;
    final NativeCrash.a RAE;
    Throwable RAG;
    final String RAH;
    final String RAI;
    boolean cqT;
    final int mStatus;
    
    b(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(196952);
      this.cqT = false;
      this.RAG = null;
      if (paramBoolean) {
        this.RAD = null;
      }
      for (this.RAE = NativeCrash.hiD();; this.RAE = null)
      {
        this.mStatus = paramInt;
        this.RAH = paramString1;
        this.RAI = paramString2;
        AppMethodBeat.o(196952);
        return;
        this.RAD = NativeCrash.hiC();
      }
    }
    
    final boolean ij()
    {
      AppMethodBeat.i(196953);
      if ((this.RAD == null) && (this.RAE == null))
      {
        AppMethodBeat.o(196953);
        return false;
      }
      Object localObject = new Thread(this, "NativeCrash Dump Callback");
      ((Thread)localObject).start();
      ((Thread)localObject).join(5000L);
      if (this.RAG != null)
      {
        localObject = this.RAG;
        AppMethodBeat.o(196953);
        throw ((Throwable)localObject);
      }
      boolean bool = this.cqT;
      AppMethodBeat.o(196953);
      return bool;
    }
    
    public final void run()
    {
      AppMethodBeat.i(196954);
      try
      {
        if (this.RAE != null)
        {
          this.cqT = this.RAE.hiF();
          AppMethodBeat.o(196954);
          return;
        }
        if (this.RAD != null)
        {
          this.cqT = this.RAD.onCrashDumped(this.mStatus, this.RAH, this.RAI);
          AppMethodBeat.o(196954);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.RAG = localThrowable;
        AppMethodBeat.o(196954);
        return;
      }
      this.cqT = false;
      AppMethodBeat.o(196954);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean onCrashDumped(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.nativecrash.NativeCrash
 * JD-Core Version:    0.7.0.1
 */