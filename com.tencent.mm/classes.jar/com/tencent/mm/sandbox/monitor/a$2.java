package com.tencent.mm.sandbox.monitor;

import java.io.File;
import java.io.FilenameFilter;

final class a$2
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".crashlog");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a.2
 * JD-Core Version:    0.7.0.1
 */