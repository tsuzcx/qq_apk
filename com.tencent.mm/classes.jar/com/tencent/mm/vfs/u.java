package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;

public final class u
  extends InputStreamReader
{
  public u(o paramo)
  {
    super(s.b(paramo.mUri, paramo.heo()));
    AppMethodBeat.i(13318);
    AppMethodBeat.o(13318);
  }
  
  public u(String paramString)
  {
    super(s.openRead(paramString));
    AppMethodBeat.i(13317);
    AppMethodBeat.o(13317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.u
 * JD-Core Version:    0.7.0.1
 */