package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

public final class y
  extends OutputStreamWriter
{
  public y(q paramq)
  {
    super(u.a(paramq.mUri, paramq.ify(), false));
    AppMethodBeat.i(13320);
    AppMethodBeat.o(13320);
  }
  
  public y(q paramq, boolean paramBoolean)
  {
    super(u.a(paramq.mUri, paramq.ify(), paramBoolean));
    AppMethodBeat.i(170172);
    AppMethodBeat.o(170172);
  }
  
  public y(String paramString)
  {
    super(u.dI(paramString, false));
    AppMethodBeat.i(13319);
    AppMethodBeat.o(13319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.y
 * JD-Core Version:    0.7.0.1
 */