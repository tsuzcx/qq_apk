package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$1
  extends eb<Class>
{
  public final Class a(ff paramff)
  {
    AppMethodBeat.i(147744);
    paramff = new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    AppMethodBeat.o(147744);
    throw paramff;
  }
  
  public final void a(fh paramfh, Class paramClass)
  {
    AppMethodBeat.i(147743);
    paramfh = new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramClass.getName() + ". Forgot to register a type adapter?");
    AppMethodBeat.o(147743);
    throw paramfh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.1
 * JD-Core Version:    0.7.0.1
 */