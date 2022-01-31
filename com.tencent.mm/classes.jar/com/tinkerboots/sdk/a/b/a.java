package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final com.tinkerboots.sdk.a.c.a BLI;
  
  private a(com.tinkerboots.sdk.a.c.a parama)
  {
    this.BLI = parama;
  }
  
  public static a eaL()
  {
    AppMethodBeat.i(65531);
    Object localObject = new a.a();
    ((a.a)localObject).BLI = new com.tinkerboots.sdk.a.c.a();
    if (((a.a)localObject).BLI == null)
    {
      localObject = new RuntimeException("You need init conditions property");
      AppMethodBeat.o(65531);
      throw ((Throwable)localObject);
    }
    localObject = new a(((a.a)localObject).BLI);
    AppMethodBeat.o(65531);
    return localObject;
  }
  
  public final com.tinkerboots.sdk.a.c.a jk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65532);
    paramString1 = this.BLI.jl(paramString1, paramString2);
    AppMethodBeat.o(65532);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tinkerboots.sdk.a.b.a
 * JD-Core Version:    0.7.0.1
 */