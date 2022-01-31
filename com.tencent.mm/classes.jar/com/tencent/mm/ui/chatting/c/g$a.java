package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class g$a
{
  public Class<? extends v> aqP;
  public Class<? extends v> zEO;
  
  public g$a(Class<? extends v> paramClass1, Class<? extends v> paramClass2)
  {
    this.aqP = paramClass1;
    this.zEO = paramClass2;
  }
  
  public final v dHT()
  {
    AppMethodBeat.i(31287);
    try
    {
      v localv = (v)this.zEO.newInstance();
      AppMethodBeat.o(31287);
      return localv;
    }
    catch (InstantiationException localInstantiationException)
    {
      ab.printErrStackTrace("ChattingComponentFactory", localInstantiationException, "", new Object[0]);
      AppMethodBeat.o(31287);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        ab.printErrStackTrace("ChattingComponentFactory", localIllegalAccessException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.g.a
 * JD-Core Version:    0.7.0.1
 */