package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final com.tinkerboots.sdk.a.c.a SKG;
  
  private a(com.tinkerboots.sdk.a.c.a parama)
  {
    this.SKG = parama;
  }
  
  public static a hwa()
  {
    AppMethodBeat.i(3438);
    Object localObject = new a();
    ((a)localObject).SKG = new com.tinkerboots.sdk.a.c.a();
    if (((a)localObject).SKG == null)
    {
      localObject = new RuntimeException("You need init conditions property");
      AppMethodBeat.o(3438);
      throw ((Throwable)localObject);
    }
    localObject = new a(((a)localObject).SKG);
    AppMethodBeat.o(3438);
    return localObject;
  }
  
  public final com.tinkerboots.sdk.a.c.a on(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3439);
    paramString1 = this.SKG.oo(paramString1, paramString2);
    AppMethodBeat.o(3439);
    return paramString1;
  }
  
  static final class a
  {
    com.tinkerboots.sdk.a.c.a SKG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.a.b.a
 * JD-Core Version:    0.7.0.1
 */