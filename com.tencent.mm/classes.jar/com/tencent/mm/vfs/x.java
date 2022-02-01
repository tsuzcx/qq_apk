package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;

public final class x
  extends InputStreamReader
{
  public x(q paramq)
  {
    super(u.b(paramq.mUri, paramq.ify()));
    AppMethodBeat.i(13318);
    AppMethodBeat.o(13318);
  }
  
  public x(String paramString)
  {
    super(u.Tf(paramString));
    AppMethodBeat.i(13317);
    AppMethodBeat.o(13317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.x
 * JD-Core Version:    0.7.0.1
 */