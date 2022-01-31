package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

public final class f
  extends FilterOutputStream
{
  public f(b paramb)
  {
    super(e.a(paramb.mUri, paramb.dQG(), false));
    AppMethodBeat.i(54664);
    AppMethodBeat.o(54664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.f
 * JD-Core Version:    0.7.0.1
 */