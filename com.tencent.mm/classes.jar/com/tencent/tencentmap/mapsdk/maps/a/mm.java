package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class mm
  implements ml
{
  public final <T, S extends mq> mg<T, S> a(mq parammq, List<? extends mg<T, S>> paramList)
  {
    AppMethodBeat.i(149323);
    parammq = (mg)Collections.min(paramList, mb.a(new Comparator[] { mb.a(parammq.a()), mb.b(parammq.a()) }));
    AppMethodBeat.o(149323);
    return parammq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mm
 * JD-Core Version:    0.7.0.1
 */