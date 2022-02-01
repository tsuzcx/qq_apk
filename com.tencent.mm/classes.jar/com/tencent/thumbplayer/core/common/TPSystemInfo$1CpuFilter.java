package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class TPSystemInfo$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    AppMethodBeat.i(227718);
    boolean bool = Pattern.matches("cpu[0-9]", paramFile.getName());
    AppMethodBeat.o(227718);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPSystemInfo.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */