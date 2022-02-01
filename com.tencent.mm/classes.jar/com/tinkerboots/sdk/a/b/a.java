package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final com.tinkerboots.sdk.a.c.a IWt;
  
  private a(com.tinkerboots.sdk.a.c.a parama)
  {
    this.IWt = parama;
  }
  
  public static a ftP()
  {
    AppMethodBeat.i(3438);
    Object localObject = new a();
    ((a)localObject).IWt = new com.tinkerboots.sdk.a.c.a();
    if (((a)localObject).IWt == null)
    {
      localObject = new RuntimeException("You need init conditions property");
      AppMethodBeat.o(3438);
      throw ((Throwable)localObject);
    }
    localObject = new a(((a)localObject).IWt);
    AppMethodBeat.o(3438);
    return localObject;
  }
  
  public final com.tinkerboots.sdk.a.c.a mp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3439);
    paramString1 = this.IWt.mq(paramString1, paramString2);
    AppMethodBeat.o(3439);
    return paramString1;
  }
  
  static final class a
  {
    com.tinkerboots.sdk.a.c.a IWt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.a.b.a
 * JD-Core Version:    0.7.0.1
 */