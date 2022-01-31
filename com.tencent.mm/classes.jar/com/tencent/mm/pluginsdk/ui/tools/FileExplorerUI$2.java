package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(105841);
    paramAdapterView = (File)FileExplorerUI.a(this.wem).getItem(paramInt);
    if (1 == FileExplorerUI.b(this.wem)) {
      if (paramAdapterView.isFile())
      {
        g.RL().Ru().set(131074, FileExplorerUI.a.b(FileExplorerUI.a(this.wem)).getAbsolutePath());
        g.RL().Ru().set(131073, FileExplorerUI.e(this.wem).getAbsolutePath());
        if (paramAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(this.wem))) {
          break label249;
        }
        FileExplorerUI.a(this.wem).g(FileExplorerUI.a.a(FileExplorerUI.a(this.wem)).getParentFile(), FileExplorerUI.a.a(FileExplorerUI.a(this.wem)));
      }
    }
    for (;;)
    {
      FileExplorerUI.dpv();
      FileExplorerUI.a(this.wem).notifyDataSetChanged();
      FileExplorerUI.c(this.wem).setSelection(0);
      AppMethodBeat.o(105841);
      return;
      FileExplorerUI.a(this.wem, paramAdapterView);
      break;
      if (FileExplorerUI.b(this.wem) != 0) {
        break;
      }
      if (paramAdapterView.isFile())
      {
        g.RL().Ru().set(131073, FileExplorerUI.a.b(FileExplorerUI.a(this.wem)).getAbsolutePath());
        g.RL().Ru().set(131074, FileExplorerUI.d(this.wem).getAbsolutePath());
        break;
      }
      FileExplorerUI.b(this.wem, paramAdapterView);
      break;
      label249:
      if (paramAdapterView.isDirectory())
      {
        FileExplorerUI.a(this.wem).g(FileExplorerUI.a.b(FileExplorerUI.a(this.wem)), paramAdapterView);
      }
      else if (paramAdapterView.isFile())
      {
        this.wem.setResult(-1, new Intent().putExtra("choosed_file_path", paramAdapterView.getAbsolutePath()));
        this.wem.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.2
 * JD-Core Version:    0.7.0.1
 */