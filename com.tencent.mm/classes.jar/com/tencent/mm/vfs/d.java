package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class d
  extends FilterInputStream
{
  public d(b paramb)
  {
    super(e.b(paramb.mUri, paramb.dQG()));
    AppMethodBeat.i(54624);
    AppMethodBeat.o(54624);
  }
  
  public d(String paramString)
  {
    super(e.openRead(paramString));
    AppMethodBeat.i(54623);
    AppMethodBeat.o(54623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.d
 * JD-Core Version:    0.7.0.1
 */