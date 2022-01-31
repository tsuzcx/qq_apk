package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

final class bc
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    return !paramFile.getName().endsWith(".dex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.bc
 * JD-Core Version:    0.7.0.1
 */