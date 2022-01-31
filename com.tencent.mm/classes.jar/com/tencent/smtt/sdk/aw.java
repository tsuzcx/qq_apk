package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class aw
  implements FileFilter
{
  aw(ao paramao) {}
  
  public boolean accept(File paramFile)
  {
    AppMethodBeat.i(64404);
    boolean bool = paramFile.getName().endsWith(".jar");
    AppMethodBeat.o(64404);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.aw
 * JD-Core Version:    0.7.0.1
 */