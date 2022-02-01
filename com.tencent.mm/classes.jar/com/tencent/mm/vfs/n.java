package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class n
  extends FilterInputStream
{
  public n(k paramk)
  {
    super(o.b(paramk.mUri, paramk.fTe()));
    AppMethodBeat.i(13263);
    AppMethodBeat.o(13263);
  }
  
  public n(String paramString)
  {
    super(o.openRead(paramString));
    AppMethodBeat.i(13262);
    AppMethodBeat.o(13262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.n
 * JD-Core Version:    0.7.0.1
 */