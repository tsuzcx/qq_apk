package com.tencent.mm.pluginsdk.ui.tools;

import java.io.File;
import java.io.FilenameFilter;

final class NewFileExplorerUI$a$5
  implements FilenameFilter
{
  NewFileExplorerUI$a$5(NewFileExplorerUI.a parama) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    return !paramString.startsWith(".");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.5
 * JD-Core Version:    0.7.0.1
 */