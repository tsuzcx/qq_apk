package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class g$a$a
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(72740);
    if (Pattern.matches("cpu[0-9]", paramFile.getName()))
    {
      AppMethodBeat.o(72740);
      return true;
    }
    AppMethodBeat.o(72740);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g.a.a
 * JD-Core Version:    0.7.0.1
 */