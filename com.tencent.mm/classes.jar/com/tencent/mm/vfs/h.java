package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;

public final class h
  extends FilterInputStream
{
  public h(e parame)
  {
    super(i.b(parame.mUri, parame.fxS()));
    AppMethodBeat.i(13263);
    AppMethodBeat.o(13263);
  }
  
  public h(String paramString)
  {
    super(i.openRead(paramString));
    AppMethodBeat.i(13262);
    AppMethodBeat.o(13262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vfs.h
 * JD-Core Version:    0.7.0.1
 */