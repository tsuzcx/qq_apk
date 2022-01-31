package com.tencent.mm.pluginsdk.ui.tools;

import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class NewFileExplorerUI$7
  implements FileSelectorFolderView.a
{
  NewFileExplorerUI$7(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  public final void Ey(int paramInt)
  {
    y.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      this.smS.setMMTitle(R.l.file_explorer_mm_download_title);
      this.smS.setMMSubTitle(null);
      NewFileExplorerUI.a(this.smS, (TextView)this.smS.findViewById(R.h.file_explorer_folder_title_tv));
      NewFileExplorerUI.g(this.smS).setText(R.l.file_explorer_mm_download_title);
      NewFileExplorerUI.b(this.smS).c(new File(e.dzB), true);
      NewFileExplorerUI.b(this.smS).a(new File(e.dzB), null);
    }
    for (;;)
    {
      NewFileExplorerUI.b(this.smS).notifyDataSetChanged();
      NewFileExplorerUI.c(this.smS);
      return;
      NewFileExplorerUI.b(this.smS).c(new File(e.bkF), false);
      NewFileExplorerUI.b(this.smS).a(new File(e.bkF), null);
      this.smS.setMMTitle(R.l.file_explorer_mobile_dir_title);
      NewFileExplorerUI.g(this.smS).setText(R.l.file_explorer_mobile_dir_title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.7
 * JD-Core Version:    0.7.0.1
 */