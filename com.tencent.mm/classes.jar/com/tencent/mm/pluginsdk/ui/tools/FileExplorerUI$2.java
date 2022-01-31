package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;
import java.io.File;

final class FileExplorerUI$2
  implements AdapterView.OnItemClickListener
{
  FileExplorerUI$2(FileExplorerUI paramFileExplorerUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (File)FileExplorerUI.a(this.slK).getItem(paramInt);
    if (1 == FileExplorerUI.b(this.slK)) {
      if (paramAdapterView.isFile())
      {
        g.DP().Dz().o(131074, FileExplorerUI.a.b(FileExplorerUI.a(this.slK)).getAbsolutePath());
        g.DP().Dz().o(131073, FileExplorerUI.e(this.slK).getAbsolutePath());
        if (paramAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(this.slK))) {
          break label239;
        }
        FileExplorerUI.a(this.slK).g(FileExplorerUI.a.a(FileExplorerUI.a(this.slK)).getParentFile(), FileExplorerUI.a.a(FileExplorerUI.a(this.slK)));
      }
    }
    for (;;)
    {
      FileExplorerUI.cog();
      FileExplorerUI.a(this.slK).notifyDataSetChanged();
      FileExplorerUI.c(this.slK).setSelection(0);
      return;
      FileExplorerUI.a(this.slK, paramAdapterView);
      break;
      if (FileExplorerUI.b(this.slK) != 0) {
        break;
      }
      if (paramAdapterView.isFile())
      {
        g.DP().Dz().o(131073, FileExplorerUI.a.b(FileExplorerUI.a(this.slK)).getAbsolutePath());
        g.DP().Dz().o(131074, FileExplorerUI.d(this.slK).getAbsolutePath());
        break;
      }
      FileExplorerUI.b(this.slK, paramAdapterView);
      break;
      label239:
      if (paramAdapterView.isDirectory())
      {
        FileExplorerUI.a(this.slK).g(FileExplorerUI.a.b(FileExplorerUI.a(this.slK)), paramAdapterView);
      }
      else if (paramAdapterView.isFile())
      {
        this.slK.setResult(-1, new Intent().putExtra("choosed_file_path", paramAdapterView.getAbsolutePath()));
        this.slK.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.2
 * JD-Core Version:    0.7.0.1
 */