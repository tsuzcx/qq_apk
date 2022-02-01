package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final com.tinkerboots.sdk.a.c.a aisn;
  
  private a(com.tinkerboots.sdk.a.c.a parama)
  {
    this.aisn = parama;
  }
  
  public static a kku()
  {
    AppMethodBeat.i(3438);
    Object localObject = new a();
    ((a)localObject).aisn = new com.tinkerboots.sdk.a.c.a();
    if (((a)localObject).aisn == null)
    {
      localObject = new RuntimeException("You need init conditions property");
      AppMethodBeat.o(3438);
      throw ((Throwable)localObject);
    }
    localObject = new a(((a)localObject).aisn);
    AppMethodBeat.o(3438);
    return localObject;
  }
  
  public final com.tinkerboots.sdk.a.c.a ri(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3439);
    paramString1 = this.aisn.rj(paramString1, paramString2);
    AppMethodBeat.o(3439);
    return paramString1;
  }
  
  static final class a
  {
    com.tinkerboots.sdk.a.c.a aisn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tinkerboots.sdk.a.b.a
 * JD-Core Version:    0.7.0.1
 */