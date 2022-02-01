package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

public final class p
  extends FilterOutputStream
{
  public p(String paramString)
  {
    super(o.db(paramString, false));
    AppMethodBeat.i(13305);
    AppMethodBeat.o(13305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vfs.p
 * JD-Core Version:    0.7.0.1
 */