package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class at
  implements FileFilter
{
  at(as paramas) {}
  
  public boolean accept(File paramFile)
  {
    AppMethodBeat.i(64400);
    boolean bool = paramFile.getName().endsWith(".dex");
    AppMethodBeat.o(64400);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.at
 * JD-Core Version:    0.7.0.1
 */