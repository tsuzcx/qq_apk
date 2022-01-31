package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class u
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(65300);
    paramFile = paramFile.getName();
    if ((!TextUtils.isEmpty(paramFile)) && (paramFile.endsWith(".dex")))
    {
      AppMethodBeat.o(65300);
      return true;
    }
    AppMethodBeat.o(65300);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.utils.u
 * JD-Core Version:    0.7.0.1
 */