package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Map;

final class NoteEditorUI$23
  implements MenuItem.OnMenuItemClickListener
{
  NoteEditorUI$23(NoteEditorUI paramNoteEditorUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int j = 1;
    AppMethodBeat.i(27031);
    paramMenuItem = new com.tencent.mm.ui.widget.b.d(this.vCx.getContext(), 1, false);
    paramMenuItem.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(27019);
        if (NoteEditorUI.d(NoteEditorUI.23.this.vCx) == 1)
        {
          paramAnonymousl.e(4, NoteEditorUI.23.this.vCx.getString(2131299826));
          NoteEditorUI.a(NoteEditorUI.23.this.vCx, paramAnonymousl);
          paramAnonymousl.e(3, NoteEditorUI.23.this.vCx.getString(2131302102));
          AppMethodBeat.o(27019);
          return;
        }
        String str;
        if (NoteEditorUI.d(NoteEditorUI.23.this.vCx) == 2)
        {
          paramAnonymousl.e(0, NoteEditorUI.23.this.vCx.getString(2131299826));
          if (a.djK()) {
            paramAnonymousl.e(7, NoteEditorUI.23.this.vCx.getContext().getString(2131299779));
          }
          if (!NoteEditorUI.e(NoteEditorUI.23.this.vCx)) {
            paramAnonymousl.e(14, NoteEditorUI.23.this.vCx.getString(2131299814));
          }
          str = (String)com.tencent.mm.model.c.c.abU().me("100353").dvN().get("Close");
          if (bo.isNullOrNil(str)) {
            break label382;
          }
        }
        label382:
        for (int i = bo.getInt(str, 0);; i = 0)
        {
          if (i == 0) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              paramAnonymousl.e(8, NoteEditorUI.23.this.vCx.getContext().getString(2131301889));
            }
            NoteEditorUI.a(NoteEditorUI.23.this.vCx, paramAnonymousl);
            paramAnonymousl.e(1, NoteEditorUI.23.this.vCx.getString(2131299703));
            paramAnonymousl.e(2, NoteEditorUI.23.this.vCx.getContext().getString(2131296901));
            AppMethodBeat.o(27019);
            return;
          }
          if (NoteEditorUI.d(NoteEditorUI.23.this.vCx) == 4)
          {
            paramAnonymousl.e(9, NoteEditorUI.23.this.vCx.getString(2131299826));
            if (a.djK()) {
              paramAnonymousl.e(12, NoteEditorUI.23.this.vCx.getContext().getString(2131299779));
            }
            paramAnonymousl.e(10, NoteEditorUI.23.this.vCx.getString(2131302102));
          }
          AppMethodBeat.o(27019);
          return;
        }
      }
    };
    paramMenuItem.sap = new NoteEditorUI.23.2(this);
    if (NoteEditorUI.d(this.vCx) == 2)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din();
      int i = j;
      if (localc.vyh <= 0) {
        if (localc.vyg <= 0) {
          break label97;
        }
      }
      label97:
      for (i = j; i == 0; i = 0)
      {
        AppMethodBeat.o(27031);
        return false;
      }
    }
    if (NoteEditorUI.d(this.vCx) == 2)
    {
      this.vCx.dic();
      if (NoteEditorUI.a(this.vCx) != null) {
        NoteEditorUI.a(this.vCx).vyE.dismiss();
      }
      NoteEditorUI.b(this.vCx).setVisibility(8);
      if (NoteEditorUI.J(this.vCx)) {
        e.djc().djg();
      }
    }
    NoteEditorUI.A(this.vCx).postDelayed(new NoteEditorUI.23.3(this, paramMenuItem), 100L);
    AppMethodBeat.o(27031);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23
 * JD-Core Version:    0.7.0.1
 */