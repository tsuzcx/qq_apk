package com.tencent.ttpic.baseutils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

final class FileUtils$1
  implements FilenameFilter
{
  FileUtils$1(String paramString) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(49671);
    if (TextUtils.isEmpty(this.val$suffix))
    {
      AppMethodBeat.o(49671);
      return true;
    }
    boolean bool = paramString.endsWith(this.val$suffix);
    AppMethodBeat.o(49671);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */