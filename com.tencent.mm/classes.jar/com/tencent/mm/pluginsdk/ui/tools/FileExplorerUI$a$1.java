package com.tencent.mm.pluginsdk.ui.tools;

import java.io.File;
import java.io.FileFilter;

final class FileExplorerUI$a$1
  implements FileFilter
{
  FileExplorerUI$a$1(FileExplorerUI.a parama) {}
  
  public final boolean accept(File paramFile)
  {
    return !paramFile.isHidden();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a.1
 * JD-Core Version:    0.7.0.1
 */