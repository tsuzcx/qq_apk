package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final com.tinkerboots.sdk.a.c.a aamA;
  
  private a(com.tinkerboots.sdk.a.c.a parama)
  {
    this.aamA = parama;
  }
  
  public static a izZ()
  {
    AppMethodBeat.i(3438);
    Object localObject = new a();
    ((a)localObject).aamA = new com.tinkerboots.sdk.a.c.a();
    if (((a)localObject).aamA == null)
    {
      localObject = new RuntimeException("You need init conditions property");
      AppMethodBeat.o(3438);
      throw ((Throwable)localObject);
    }
    localObject = new a(((a)localObject).aamA);
    AppMethodBeat.o(3438);
    return localObject;
  }
  
  public final com.tinkerboots.sdk.a.c.a pj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3439);
    paramString1 = this.aamA.pk(paramString1, paramString2);
    AppMethodBeat.o(3439);
    return paramString1;
  }
  
  static final class a
  {
    com.tinkerboots.sdk.a.c.a aamA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tinkerboots.sdk.a.b.a
 * JD-Core Version:    0.7.0.1
 */