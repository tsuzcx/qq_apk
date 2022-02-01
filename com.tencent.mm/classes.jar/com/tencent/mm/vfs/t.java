package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

public final class t
  extends FilterOutputStream
{
  public t(String paramString)
  {
    super(s.dw(paramString, false));
    AppMethodBeat.i(13305);
    AppMethodBeat.o(13305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.t
 * JD-Core Version:    0.7.0.1
 */