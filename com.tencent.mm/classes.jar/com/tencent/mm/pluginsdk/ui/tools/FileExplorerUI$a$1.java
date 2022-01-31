package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class FileExplorerUI$a$1
  implements FileFilter
{
  FileExplorerUI$a$1(FileExplorerUI.a parama) {}
  
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(105844);
    if (paramFile.isHidden())
    {
      AppMethodBeat.o(105844);
      return false;
    }
    AppMethodBeat.o(105844);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a.1
 * JD-Core Version:    0.7.0.1
 */