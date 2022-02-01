package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

public final class ac
  extends OutputStreamWriter
{
  public ac(u paramu)
  {
    super(y.a(paramu.mUri, paramu.jKM(), false));
    AppMethodBeat.i(13320);
    AppMethodBeat.o(13320);
  }
  
  public ac(u paramu, boolean paramBoolean)
  {
    super(y.a(paramu.mUri, paramu.jKM(), paramBoolean));
    AppMethodBeat.i(170172);
    AppMethodBeat.o(170172);
  }
  
  public ac(String paramString)
  {
    super(y.ev(paramString, false));
    AppMethodBeat.i(13319);
    AppMethodBeat.o(13319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ac
 * JD-Core Version:    0.7.0.1
 */