package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStreamWriter;

public final class h
  extends OutputStreamWriter
{
  public h(b paramb)
  {
    super(e.a(paramb.mUri, paramb.dQG(), false));
    AppMethodBeat.i(54668);
    AppMethodBeat.o(54668);
  }
  
  public h(String paramString)
  {
    super(e.M(paramString, false));
    AppMethodBeat.i(54667);
    AppMethodBeat.o(54667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.h
 * JD-Core Version:    0.7.0.1
 */