package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;

public final class g
  extends InputStreamReader
{
  public g(b paramb)
  {
    super(e.b(paramb.mUri, paramb.dQG()));
    AppMethodBeat.i(54666);
    AppMethodBeat.o(54666);
  }
  
  public g(String paramString)
  {
    super(e.openRead(paramString));
    AppMethodBeat.i(54665);
    AppMethodBeat.o(54665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.g
 * JD-Core Version:    0.7.0.1
 */