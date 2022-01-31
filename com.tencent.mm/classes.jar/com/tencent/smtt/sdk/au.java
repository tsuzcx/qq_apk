package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class au
  implements FileFilter
{
  au(an paraman) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".dex")) && (!paramFile.getName().endsWith(".jar_is_first_load_dex_flag_file"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.au
 * JD-Core Version:    0.7.0.1
 */