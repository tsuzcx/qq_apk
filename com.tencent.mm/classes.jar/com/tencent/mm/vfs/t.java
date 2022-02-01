package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class t
  extends FilterInputStream
{
  public t(q paramq)
  {
    super(u.b(paramq.mUri, paramq.ify()));
    AppMethodBeat.i(13263);
    AppMethodBeat.o(13263);
  }
  
  public t(String paramString)
  {
    super(u.Tf(paramString));
    AppMethodBeat.i(13262);
    AppMethodBeat.o(13262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.t
 * JD-Core Version:    0.7.0.1
 */