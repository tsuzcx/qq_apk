package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class n$1
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(219328);
    paramFile = paramFile.getName();
    if ((!TextUtils.isEmpty(paramFile)) && (paramFile.endsWith(".dex")))
    {
      AppMethodBeat.o(219328);
      return true;
    }
    AppMethodBeat.o(219328);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.n.1
 * JD-Core Version:    0.7.0.1
 */