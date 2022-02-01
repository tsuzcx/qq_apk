package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ah$c
  extends RuntimeException
{
  ah$c(Class<?> paramClass, int paramInt1, int paramInt2)
  {
    super("Version mismatch when unmarhelling " + paramClass.getName() + " (" + paramInt2 + " expected, " + paramInt1 + " got");
    AppMethodBeat.i(13322);
    AppMethodBeat.o(13322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ah.c
 * JD-Core Version:    0.7.0.1
 */