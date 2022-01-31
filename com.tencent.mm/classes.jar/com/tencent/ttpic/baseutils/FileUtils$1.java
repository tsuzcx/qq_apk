package com.tencent.ttpic.baseutils;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class FileUtils$1
  implements FilenameFilter
{
  FileUtils$1(String paramString) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    if (TextUtils.isEmpty(this.val$suffix)) {
      return true;
    }
    return paramString.endsWith(this.val$suffix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */