package com.tencent.mm.pluginsdk.ui.tools;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class NewFileExplorerUI$7
  implements FileSelectorFolderView.a
{
  NewFileExplorerUI$7(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  public final void Mw(int paramInt)
  {
    AppMethodBeat.i(28181);
    ab.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      this.wfn.setMMTitle(2131299878);
      this.wfn.setMMSubTitle(null);
      NewFileExplorerUI.a(this.wfn, (TextView)this.wfn.findViewById(2131826539));
      NewFileExplorerUI.g(this.wfn).setText(2131299878);
      NewFileExplorerUI.b(this.wfn).c(new File(e.esq), true);
      NewFileExplorerUI.b(this.wfn).a(new File(e.esq), null);
    }
    for (;;)
    {
      NewFileExplorerUI.b(this.wfn).notifyDataSetChanged();
      NewFileExplorerUI.c(this.wfn);
      AppMethodBeat.o(28181);
      return;
      NewFileExplorerUI.b(this.wfn).c(new File(e.eQx), false);
      NewFileExplorerUI.b(this.wfn).a(new File(e.eQx), null);
      this.wfn.setMMTitle(2131299879);
      NewFileExplorerUI.g(this.wfn).setText(2131299879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.7
 * JD-Core Version:    0.7.0.1
 */