package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class o$2
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(55045);
    paramFile = paramFile.getName();
    if (paramFile == null)
    {
      AppMethodBeat.o(55045);
      return false;
    }
    if (paramFile.endsWith(".jar_is_first_load_dex_flag_file"))
    {
      AppMethodBeat.o(55045);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramFile.endsWith(".dex")))
    {
      AppMethodBeat.o(55045);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (paramFile.endsWith(".prof")))
    {
      AppMethodBeat.o(55045);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (paramFile.equals("oat")))
    {
      AppMethodBeat.o(55045);
      return false;
    }
    AppMethodBeat.o(55045);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.o.2
 * JD-Core Version:    0.7.0.1
 */