package com.tencent.mm.plugin.webview.modeltools;

import java.io.File;
import java.io.FilenameFilter;

final class h$a$1
  implements FilenameFilter
{
  h$a$1(h.a parama) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.matches(".+_.+.\\.jpg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h.a.1
 * JD-Core Version:    0.7.0.1
 */