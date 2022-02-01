package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.m;

final class NewFileExplorerUI$a$5
  implements m
{
  NewFileExplorerUI$a$5(NewFileExplorerUI.a parama) {}
  
  public final boolean wY(String paramString)
  {
    AppMethodBeat.i(169796);
    if (!paramString.startsWith("."))
    {
      AppMethodBeat.o(169796);
      return true;
    }
    AppMethodBeat.o(169796);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.5
 * JD-Core Version:    0.7.0.1
 */