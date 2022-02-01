package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

public final class r
  extends OutputStreamWriter
{
  public r(k paramk)
  {
    super(o.a(paramk.mUri, paramk.fTe(), false));
    AppMethodBeat.i(13320);
    AppMethodBeat.o(13320);
  }
  
  public r(k paramk, boolean paramBoolean)
  {
    super(o.a(paramk.mUri, paramk.fTe(), paramBoolean));
    AppMethodBeat.i(170172);
    AppMethodBeat.o(170172);
  }
  
  public r(String paramString)
  {
    super(o.db(paramString, false));
    AppMethodBeat.i(13319);
    AppMethodBeat.o(13319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.r
 * JD-Core Version:    0.7.0.1
 */