package com.tencent.mm.rabbiteye.detective;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.a.a;
import com.tencent.mm.rabbiteye.a.b;
import com.tencent.mm.rabbiteye.a.b;

public class AnrDetective
  extends a
{
  private static volatile AnrDetective NAN;
  private static a.b NAO;
  public static a.a NAP;
  
  static
  {
    AppMethodBeat.i(186290);
    NAN = new AnrDetective();
    AppMethodBeat.o(186290);
  }
  
  public static AnrDetective a(a.b paramb, a.a parama)
  {
    try
    {
      NAO = paramb;
      NAP = parama;
      paramb = NAN;
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
    com.tencent.mm.rabbiteye.a.a locala = com.tencent.mm.rabbiteye.a.a.NAY;
    if (!locala.e) {
      locala.e = true;
    }
  }
  
  private static native void nativceProduceNativeCrash();
  
  public static native void nativeInitAnr(String paramString);
  
  @Keep
  private static void onANRDumped(int paramInt, String paramString)
  {
    AppMethodBeat.i(186289);
    paramString = b.gut();
    NAO.gf(paramString);
    AppMethodBeat.o(186289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.detective.AnrDetective
 * JD-Core Version:    0.7.0.1
 */