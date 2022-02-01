package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

public final class l
  extends OutputStreamWriter
{
  public l(e parame)
  {
    super(i.a(parame.mUri, parame.fhR(), false));
    AppMethodBeat.i(13320);
    AppMethodBeat.o(13320);
  }
  
  public l(e parame, boolean paramBoolean)
  {
    super(i.a(parame.mUri, parame.fhR(), paramBoolean));
    AppMethodBeat.i(170172);
    AppMethodBeat.o(170172);
  }
  
  public l(String paramString)
  {
    super(i.cM(paramString, false));
    AppMethodBeat.i(13319);
    AppMethodBeat.o(13319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.l
 * JD-Core Version:    0.7.0.1
 */