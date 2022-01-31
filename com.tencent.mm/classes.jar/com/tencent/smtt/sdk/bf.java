package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class bf
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(139381);
    if (!paramFile.getName().endsWith(".dex"))
    {
      AppMethodBeat.o(139381);
      return true;
    }
    AppMethodBeat.o(139381);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.bf
 * JD-Core Version:    0.7.0.1
 */