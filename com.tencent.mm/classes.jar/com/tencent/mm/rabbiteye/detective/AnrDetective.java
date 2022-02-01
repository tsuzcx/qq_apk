package com.tencent.mm.rabbiteye.detective;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.a.a;
import com.tencent.mm.rabbiteye.a.b;
import com.tencent.mm.rabbiteye.a.b;

public class AnrDetective
  extends a
{
  private static volatile AnrDetective UOq;
  private static a.b UOr;
  public static a.a UOs;
  
  static
  {
    AppMethodBeat.i(231738);
    UOq = new AnrDetective();
    AppMethodBeat.o(231738);
  }
  
  public static AnrDetective a(a.b paramb, a.a parama)
  {
    try
    {
      UOr = paramb;
      UOs = parama;
      paramb = UOq;
      return paramb;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public static void a()
  {
    com.tencent.mm.rabbiteye.a.a locala = com.tencent.mm.rabbiteye.a.a.UOB;
    if (!locala.e) {
      locala.e = true;
    }
  }
  
  public static void hpL()
  {
    AppMethodBeat.i(231734);
    nativePrintTrace();
    AppMethodBeat.o(231734);
  }
  
  private static native void nativceProduceNativeCrash();
  
  public static native void nativeInitAnr(String paramString1, String paramString2);
  
  private static native void nativePrintTrace();
  
  @Keep
  private static void onANRDumped(int paramInt, String paramString)
  {
    AppMethodBeat.i(231735);
    paramString = b.hpR();
    UOr.gP(paramString);
    AppMethodBeat.o(231735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.detective.AnrDetective
 * JD-Core Version:    0.7.0.1
 */