package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class ax
  implements FileFilter
{
  ax(ao paramao) {}
  
  public boolean accept(File paramFile)
  {
    AppMethodBeat.i(139274);
    boolean bool = paramFile.getName().endsWith(".jar");
    AppMethodBeat.o(139274);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ax
 * JD-Core Version:    0.7.0.1
 */