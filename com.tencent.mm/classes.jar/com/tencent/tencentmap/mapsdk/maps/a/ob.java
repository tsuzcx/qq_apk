package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ob
  extends RuntimeException
{
  public ob(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ob(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage(), paramThrowable);
    AppMethodBeat.i(149595);
    AppMethodBeat.o(149595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ob
 * JD-Core Version:    0.7.0.1
 */