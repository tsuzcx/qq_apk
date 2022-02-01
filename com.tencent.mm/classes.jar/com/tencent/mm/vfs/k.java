package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;

public final class k
  extends InputStreamReader
{
  public k(e parame)
  {
    super(i.b(parame.mUri, parame.fhR()));
    AppMethodBeat.i(13318);
    AppMethodBeat.o(13318);
  }
  
  public k(String paramString)
  {
    super(i.openRead(paramString));
    AppMethodBeat.i(13317);
    AppMethodBeat.o(13317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.k
 * JD-Core Version:    0.7.0.1
 */