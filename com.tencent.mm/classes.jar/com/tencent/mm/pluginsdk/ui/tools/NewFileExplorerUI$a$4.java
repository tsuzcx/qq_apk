package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;

final class NewFileExplorerUI$a$4
  implements View.OnClickListener
{
  NewFileExplorerUI$a$4(NewFileExplorerUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31988);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    int i = ((Integer)paramView.getTag()).intValue();
    localObject = this.FkL.FjG[i];
    paramView = (CheckBox)paramView.findViewById(2131301186);
    if (NewFileExplorerUI.a.a(this.FkL).contains(localObject))
    {
      NewFileExplorerUI.a.a(this.FkL).remove(localObject);
      paramView.setChecked(false);
    }
    for (;;)
    {
      NewFileExplorerUI.h(this.FkL.FkH);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(31988);
      return;
      if (NewFileExplorerUI.a.a(this.FkL).size() >= 9)
      {
        t.makeText(this.FkL.FkH.getContext(), this.FkL.FkH.getString(2131759077, new Object[] { Integer.valueOf(9) }), 0).show();
        paramView.setChecked(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31988);
        return;
      }
      long l = com.tencent.mm.n.b.aci();
      if (((e)localObject).length() >= l)
      {
        t.makeText(this.FkL.FkH.getContext(), this.FkL.FkH.getString(2131759076, new Object[] { bt.sy(l) }), 0).show();
        paramView.setChecked(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31988);
        return;
      }
      if (NewFileExplorerUI.a.by(((e)localObject).getName()))
      {
        com.tencent.mm.plugin.gallery.ui.a.a locala = com.tencent.mm.plugin.gallery.ui.a.a.ale(q.B(((e)localObject).mUri));
        locala.mSize = com.tencent.mm.n.b.ach();
        if (locala.bgi() == 1)
        {
          t.makeText(this.FkL.FkH.getContext(), this.FkL.FkH.getString(2131764700, new Object[] { bt.sy(com.tencent.mm.n.b.ach()) }), 0).show();
          paramView.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31988);
          return;
        }
      }
      paramView.setChecked(true);
      NewFileExplorerUI.a.a(this.FkL).add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.4
 * JD-Core Version:    0.7.0.1
 */