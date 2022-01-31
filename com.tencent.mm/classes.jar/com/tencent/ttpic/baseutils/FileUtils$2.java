package com.tencent.ttpic.baseutils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class FileUtils$2
  implements FileUtils.AssetFileComparator
{
  public final boolean equals(Context paramContext, String paramString, File paramFile)
  {
    AppMethodBeat.i(49672);
    long l = FileUtils.access$000(paramContext, paramString);
    if ((l != -1L) && (l == paramFile.length()))
    {
      AppMethodBeat.o(49672);
      return true;
    }
    AppMethodBeat.o(49672);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.FileUtils.2
 * JD-Core Version:    0.7.0.1
 */