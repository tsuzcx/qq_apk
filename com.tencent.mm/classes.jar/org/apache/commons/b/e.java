package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public static final e.a CPt;
  
  static
  {
    AppMethodBeat.i(142949);
    CPt = new e.a();
    AppMethodBeat.o(142949);
  }
  
  public static void a(StringBuffer paramStringBuffer, Object paramObject)
  {
    AppMethodBeat.i(142948);
    if (paramObject == null)
    {
      paramStringBuffer = new NullPointerException("Cannot get the toString of a null identity");
      AppMethodBeat.o(142948);
      throw paramStringBuffer;
    }
    paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
    AppMethodBeat.o(142948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.apache.commons.b.e
 * JD-Core Version:    0.7.0.1
 */