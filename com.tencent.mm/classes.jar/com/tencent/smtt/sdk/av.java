package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

class av
  implements FileFilter
{
  av(ao paramao) {}
  
  public boolean accept(File paramFile)
  {
    AppMethodBeat.i(64403);
    if ((!paramFile.getName().endsWith(".dex")) && (!paramFile.getName().endsWith(".jar_is_first_load_dex_flag_file")))
    {
      AppMethodBeat.o(64403);
      return true;
    }
    AppMethodBeat.o(64403);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.av
 * JD-Core Version:    0.7.0.1
 */