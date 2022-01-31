package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class au
  implements FileFilter
{
  au(as paramas) {}
  
  public boolean accept(File paramFile)
  {
    AppMethodBeat.i(64402);
    boolean bool = paramFile.getName().endsWith("tbs.conf");
    AppMethodBeat.o(64402);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.au
 * JD-Core Version:    0.7.0.1
 */