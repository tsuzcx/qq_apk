package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

final class NewFileExplorerUI$a$5
  implements FilenameFilter
{
  NewFileExplorerUI$a$5(NewFileExplorerUI.a parama) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(28185);
    if (!paramString.startsWith("."))
    {
      AppMethodBeat.o(28185);
      return true;
    }
    AppMethodBeat.o(28185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.5
 * JD-Core Version:    0.7.0.1
 */