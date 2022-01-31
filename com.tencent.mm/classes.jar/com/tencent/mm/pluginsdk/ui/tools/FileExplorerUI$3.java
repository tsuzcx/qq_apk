package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class FileExplorerUI$3
  implements View.OnClickListener
{
  FileExplorerUI$3(FileExplorerUI paramFileExplorerUI, File paramFile) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105842);
    FileExplorerUI.a(this.wem, 0);
    FileExplorerUI.a(this.wem).fVd = this.wen.getPath();
    FileExplorerUI.a(this.wem).g(FileExplorerUI.e(this.wem).getParentFile(), FileExplorerUI.e(this.wem));
    FileExplorerUI.a(this.wem).notifyDataSetInvalidated();
    FileExplorerUI.a(this.wem).notifyDataSetChanged();
    FileExplorerUI.c(this.wem).setSelection(0);
    AppMethodBeat.o(105842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.3
 * JD-Core Version:    0.7.0.1
 */