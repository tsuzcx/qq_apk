package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class r
  extends FilterInputStream
{
  public r(o paramo)
  {
    super(s.b(paramo.mUri, paramo.heo()));
    AppMethodBeat.i(13263);
    AppMethodBeat.o(13263);
  }
  
  public r(String paramString)
  {
    super(s.openRead(paramString));
    AppMethodBeat.i(13262);
    AppMethodBeat.o(13262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.r
 * JD-Core Version:    0.7.0.1
 */