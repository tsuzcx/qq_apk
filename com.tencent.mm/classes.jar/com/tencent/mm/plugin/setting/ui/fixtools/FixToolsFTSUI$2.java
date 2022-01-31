package com.tencent.mm.plugin.setting.ui.fixtools;

import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.b;

final class FixToolsFTSUI$2
  implements View.OnClickListener
{
  FixToolsFTSUI$2(FixToolsFTSUI paramFixToolsFTSUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155884);
    d.i("MicroMsg.FTS.FixToolsFTSUI", "delete fts db, and kill process");
    com.tencent.mm.plugin.fts.a.e.wq(24);
    paramView = new b(g.RL().cachePath, "FTS5IndexMicroMsg_encrypt.db");
    if (paramView.exists()) {
      paramView.delete();
    }
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(155884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsFTSUI.2
 * JD-Core Version:    0.7.0.1
 */