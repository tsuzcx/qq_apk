package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class NativeCrash
{
  private static b Zcj;
  private static a Zck;
  private static final Charset Zcl;
  
  static
  {
    AppMethodBeat.i(40117);
    Zcl = Charset.forName("UTF-8");
    AppMethodBeat.o(40117);
  }
  
  public static void LC(String paramString)
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
      nativeCustomInfo(paramString.getBytes(Zcl));
      AppMethodBeat.o(40114);
      return;
    }
  }
  
  public static b a(b paramb)
  {
    b localb = Zcj;
    Zcj = paramb;
    return localb;
  }
  
  public static void bCG(String paramString)
  {
    AppMethodBeat.i(258697);
    if (!InitializationProbe.libLoaded) {
      System.loadLibrary("wechatcrash");
    }
    nativeInit(paramString, 1871, 2048, false);
    AppMethodBeat.o(258697);
  }
  
  public static void ikn()
  {
    AppMethodBeat.i(40115);
    nativeResetCustomInfo();
    AppMethodBeat.o(40115);
  }
  
  private static native void nativeCustomInfo(byte[] paramArrayOfByte);
  
  private static native void nativeInit(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native void nativeInitFd(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  private static native void nativeResetCustomInfo();
  
  @Keep
  private static boolean onANRDumped(int paramInt, String paramString)
  {
    AppMethodBeat.i(258701);
    try
    {
      if ((Zck != null) && (Zck.iko()))
      {
        AppMethodBeat.o(258701);
        return true;
      }
      AppMethodBeat.o(258701);
      return false;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(258701);
      throw paramString;
    }
  }
  
  @Keep
  private static boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(258700);
    try
    {
      if (Zcj != null) {
        Zcj.onCrashDumped(paramInt, paramString1, paramString2);
      }
      AppMethodBeat.o(258700);
      return false;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(258700);
      throw paramString1;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean iko();
  }
  
  public static abstract interface b
  {
    public abstract boolean onCrashDumped(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.nativecrash.NativeCrash
 * JD-Core Version:    0.7.0.1
 */