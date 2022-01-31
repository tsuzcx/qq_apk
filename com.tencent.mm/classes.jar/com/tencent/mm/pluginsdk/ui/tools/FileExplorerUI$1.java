package com.tencent.mm.pluginsdk.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;
import java.io.File;

final class FileExplorerUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FileExplorerUI$1(FileExplorerUI paramFileExplorerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(105840);
    if (FileExplorerUI.a.a(FileExplorerUI.a(this.wem)) != null)
    {
      if (1 == FileExplorerUI.b(this.wem)) {
        FileExplorerUI.a(this.wem, FileExplorerUI.a.a(FileExplorerUI.a(this.wem)));
      }
      for (;;)
      {
        FileExplorerUI.a(this.wem).g(FileExplorerUI.a.a(FileExplorerUI.a(this.wem)).getParentFile(), FileExplorerUI.a.a(FileExplorerUI.a(this.wem)));
        FileExplorerUI.a(this.wem).notifyDataSetChanged();
        FileExplorerUI.c(this.wem).setSelection(0);
        FileExplorerUI.dpv();
        AppMethodBeat.o(105840);
        return true;
        if (FileExplorerUI.b(this.wem) == 0) {
          FileExplorerUI.b(this.wem, FileExplorerUI.a.a(FileExplorerUI.a(this.wem)));
        }
      }
    }
    g.RL().Ru().set(131074, FileExplorerUI.d(this.wem).getAbsolutePath());
    g.RL().Ru().set(131073, FileExplorerUI.e(this.wem).getAbsolutePath());
    this.wem.finish();
    AppMethodBeat.o(105840);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.1
 * JD-Core Version:    0.7.0.1
 */