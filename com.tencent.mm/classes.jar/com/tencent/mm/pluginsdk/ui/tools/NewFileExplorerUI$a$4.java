package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.gallery.ui.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.util.ArrayList;

final class NewFileExplorerUI$a$4
  implements View.OnClickListener
{
  NewFileExplorerUI$a$4(NewFileExplorerUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28184);
    int i = ((Integer)paramView.getTag()).intValue();
    File localFile = this.wfr.wer[i];
    paramView = (CheckBox)paramView.findViewById(2131824194);
    if (NewFileExplorerUI.a.a(this.wfr).contains(localFile))
    {
      NewFileExplorerUI.a.a(this.wfr).remove(localFile);
      paramView.setChecked(false);
    }
    for (;;)
    {
      NewFileExplorerUI.h(this.wfr.wfn);
      AppMethodBeat.o(28184);
      return;
      if (NewFileExplorerUI.a.a(this.wfr).size() >= 9)
      {
        t.makeText(this.wfr.wfn.getContext(), this.wfr.wfn.getString(2131299894, new Object[] { Integer.valueOf(9) }), 0).show();
        paramView.setChecked(false);
        AppMethodBeat.o(28184);
        return;
      }
      long l = Math.max(bo.getInt(g.Nq().getValue("InputLimitFileSize"), 104857600), 104857600);
      if (localFile.length() >= l)
      {
        t.makeText(this.wfr.wfn.getContext(), this.wfr.wfn.getString(2131299893, new Object[] { bo.hk(l) }), 0).show();
        paramView.setChecked(false);
        AppMethodBeat.o(28184);
        return;
      }
      if (NewFileExplorerUI.a.aH(localFile.getName()))
      {
        a locala = a.PK(localFile.getPath());
        locala.mSize = b.MY();
        if (locala.azZ() == 1)
        {
          t.makeText(this.wfr.wfn.getContext(), this.wfr.wfn.getString(2131304537, new Object[] { bo.hk(b.MY()) }), 0).show();
          paramView.setChecked(false);
          AppMethodBeat.o(28184);
          return;
        }
      }
      paramView.setChecked(true);
      NewFileExplorerUI.a.a(this.wfr).add(localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.4
 * JD-Core Version:    0.7.0.1
 */