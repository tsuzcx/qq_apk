package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class x
  extends FilterInputStream
{
  public x(u paramu)
  {
    super(y.b(paramu.mUri, paramu.jKM()));
    AppMethodBeat.i(13263);
    AppMethodBeat.o(13263);
  }
  
  public x(String paramString)
  {
    super(y.Lh(paramString));
    AppMethodBeat.i(13262);
    AppMethodBeat.o(13262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.x
 * JD-Core Version:    0.7.0.1
 */