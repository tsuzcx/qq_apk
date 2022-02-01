package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

public final class j
  extends FilterOutputStream
{
  public j(String paramString)
  {
    super(i.cX(paramString, false));
    AppMethodBeat.i(13305);
    AppMethodBeat.o(13305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vfs.j
 * JD-Core Version:    0.7.0.1
 */