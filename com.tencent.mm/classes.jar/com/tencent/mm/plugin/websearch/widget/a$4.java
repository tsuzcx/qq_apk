package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class a$4
  implements FileFilter
{
  a$4(a parama, String paramString) {}
  
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(91394);
    if (paramFile.getAbsolutePath().equals(this.uMb))
    {
      AppMethodBeat.o(91394);
      return false;
    }
    AppMethodBeat.o(91394);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.4
 * JD-Core Version:    0.7.0.1
 */