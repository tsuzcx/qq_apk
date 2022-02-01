package org.apache.commons.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public static final e.a ajVF;
  
  static
  {
    AppMethodBeat.i(40736);
    ajVF = new e.a();
    AppMethodBeat.o(40736);
  }
  
  public static void a(StringBuffer paramStringBuffer, Object paramObject)
  {
    AppMethodBeat.i(40734);
    if (paramObject == null)
    {
      paramStringBuffer = new NullPointerException("Cannot get the toString of a null identity");
      AppMethodBeat.o(40734);
      throw paramStringBuffer;
    }
    paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
    AppMethodBeat.o(40734);
  }
  
  public static String ca(Object paramObject)
  {
    AppMethodBeat.i(40735);
    if (paramObject == null)
    {
      AppMethodBeat.o(40735);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(40735);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.apache.commons.c.e
 * JD-Core Version:    0.7.0.1
 */