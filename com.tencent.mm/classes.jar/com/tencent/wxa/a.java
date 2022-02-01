package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.b;
import java.util.HashSet;
import java.util.Iterator;

final class a
{
  public static void a(io.flutter.embedding.engine.a parama, HashSet<io.flutter.embedding.engine.plugins.a> paramHashSet)
  {
    AppMethodBeat.i(224752);
    if (paramHashSet != null)
    {
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        io.flutter.embedding.engine.plugins.a locala = (io.flutter.embedding.engine.plugins.a)paramHashSet.next();
        if (parama.aapV.bK(locala.getClass())) {
          parama.aapV.bM(locala.getClass());
        }
        parama.aapV.a(locala);
      }
    }
    AppMethodBeat.o(224752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.a
 * JD-Core Version:    0.7.0.1
 */