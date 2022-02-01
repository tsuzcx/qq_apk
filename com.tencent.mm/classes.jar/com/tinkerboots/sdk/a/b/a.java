package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final com.tinkerboots.sdk.a.c.a KJE;
  
  private a(com.tinkerboots.sdk.a.c.a parama)
  {
    this.KJE = parama;
  }
  
  public static a fMA()
  {
    AppMethodBeat.i(3438);
    Object localObject = new a();
    ((a)localObject).KJE = new com.tinkerboots.sdk.a.c.a();
    if (((a)localObject).KJE == null)
    {
      localObject = new RuntimeException("You need init conditions property");
      AppMethodBeat.o(3438);
      throw ((Throwable)localObject);
    }
    localObject = new a(((a)localObject).KJE);
    AppMethodBeat.o(3438);
    return localObject;
  }
  
  public final com.tinkerboots.sdk.a.c.a mQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3439);
    paramString1 = this.KJE.mR(paramString1, paramString2);
    AppMethodBeat.o(3439);
    return paramString1;
  }
  
  static final class a
  {
    com.tinkerboots.sdk.a.c.a KJE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tinkerboots.sdk.a.b.a
 * JD-Core Version:    0.7.0.1
 */