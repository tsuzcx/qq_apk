package com.tencent.mm.vending.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class a$1
  extends com.tencent.mm.vending.base.a<Object>
{
  a$1(a parama) {}
  
  public final Object aA(Class<?> paramClass)
  {
    AppMethodBeat.i(126094);
    a.a locala = (a.a)this.ANM.c.get(paramClass);
    Object localObject;
    if (locala != null)
    {
      locala.c = true;
      localObject = locala.aoU();
      locala.c = false;
      if (locala.b) {
        locala.ANN = defer(paramClass);
      }
    }
    else
    {
      AppMethodBeat.o(126094);
      return null;
    }
    AppMethodBeat.o(126094);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.app.a.1
 * JD-Core Version:    0.7.0.1
 */