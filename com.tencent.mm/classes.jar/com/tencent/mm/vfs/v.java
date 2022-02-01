package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

public final class v
  extends OutputStreamWriter
{
  public v(o paramo)
  {
    super(s.a(paramo.mUri, paramo.heo(), false));
    AppMethodBeat.i(13320);
    AppMethodBeat.o(13320);
  }
  
  public v(o paramo, boolean paramBoolean)
  {
    super(s.a(paramo.mUri, paramo.heo(), paramBoolean));
    AppMethodBeat.i(170172);
    AppMethodBeat.o(170172);
  }
  
  public v(String paramString)
  {
    super(s.dw(paramString, false));
    AppMethodBeat.i(13319);
    AppMethodBeat.o(13319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.v
 * JD-Core Version:    0.7.0.1
 */