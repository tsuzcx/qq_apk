package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;

final class NewFileExplorerUI$a$1
  implements g
{
  NewFileExplorerUI$a$1(NewFileExplorerUI.a parama) {}
  
  public final boolean accept(e parame)
  {
    AppMethodBeat.i(169795);
    if (parame.isHidden())
    {
      AppMethodBeat.o(169795);
      return false;
    }
    if ((NewFileExplorerUI.a.d(this.FkL)) && (parame.isDirectory()))
    {
      AppMethodBeat.o(169795);
      return false;
    }
    AppMethodBeat.o(169795);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.1
 * JD-Core Version:    0.7.0.1
 */