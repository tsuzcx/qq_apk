package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import java.io.File;

final class FileExplorerUI$3
  implements View.OnClickListener
{
  FileExplorerUI$3(FileExplorerUI paramFileExplorerUI, File paramFile) {}
  
  public final void onClick(View paramView)
  {
    FileExplorerUI.a(this.slK, 0);
    FileExplorerUI.a(this.slK).eFm = this.slL.getPath();
    FileExplorerUI.a(this.slK).g(FileExplorerUI.e(this.slK).getParentFile(), FileExplorerUI.e(this.slK));
    FileExplorerUI.a(this.slK).notifyDataSetInvalidated();
    FileExplorerUI.a(this.slK).notifyDataSetChanged();
    FileExplorerUI.c(this.slK).setSelection(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.3
 * JD-Core Version:    0.7.0.1
 */