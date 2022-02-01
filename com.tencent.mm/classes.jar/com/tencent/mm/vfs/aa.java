package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;

public final class aa
  extends FilterOutputStream
{
  public aa(u paramu)
  {
    super(y.a(paramu.mUri, paramu.jKM(), false));
    AppMethodBeat.i(13306);
    AppMethodBeat.o(13306);
  }
  
  public aa(String paramString)
  {
    super(y.ev(paramString, false));
    AppMethodBeat.i(13305);
    AppMethodBeat.o(13305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.aa
 * JD-Core Version:    0.7.0.1
 */