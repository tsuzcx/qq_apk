package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final com.tinkerboots.sdk.a.c.a MXy;
  
  private a(com.tinkerboots.sdk.a.c.a parama)
  {
    this.MXy = parama;
  }
  
  public static a giA()
  {
    AppMethodBeat.i(3438);
    Object localObject = new a();
    ((a)localObject).MXy = new com.tinkerboots.sdk.a.c.a();
    if (((a)localObject).MXy == null)
    {
      localObject = new RuntimeException("You need init conditions property");
      AppMethodBeat.o(3438);
      throw ((Throwable)localObject);
    }
    localObject = new a(((a)localObject).MXy);
    AppMethodBeat.o(3438);
    return localObject;
  }
  
  public final com.tinkerboots.sdk.a.c.a nu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3439);
    paramString1 = this.MXy.nv(paramString1, paramString2);
    AppMethodBeat.o(3439);
    return paramString1;
  }
  
  static final class a
  {
    com.tinkerboots.sdk.a.c.a MXy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.a.b.a
 * JD-Core Version:    0.7.0.1
 */