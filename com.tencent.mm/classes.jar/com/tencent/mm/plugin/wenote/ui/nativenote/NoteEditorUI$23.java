package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class NoteEditorUI$23
  implements MenuItem.OnMenuItemClickListener
{
  NoteEditorUI$23(NoteEditorUI paramNoteEditorUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int j = 1;
    paramMenuItem = new d(this.rLT.mController.uMN, 1, false);
    paramMenuItem.phH = new NoteEditorUI.23.1(this);
    paramMenuItem.phI = new NoteEditorUI.23.2(this);
    if (NoteEditorUI.d(this.rLT) == 2)
    {
      c localc = c.chX();
      int i = j;
      if (localc.rHA <= 0) {
        if (localc.rHz <= 0) {
          break label88;
        }
      }
      label88:
      for (i = j; i == 0; i = 0) {
        return false;
      }
    }
    if (NoteEditorUI.d(this.rLT) == 2)
    {
      this.rLT.chM();
      if (NoteEditorUI.a(this.rLT) != null) {
        NoteEditorUI.a(this.rLT).rHY.dismiss();
      }
      NoteEditorUI.b(this.rLT).setVisibility(8);
      if (NoteEditorUI.J(this.rLT)) {
        e.ciJ().ciN();
      }
    }
    NoteEditorUI.A(this.rLT).postDelayed(new NoteEditorUI.23.3(this, paramMenuItem), 100L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23
 * JD-Core Version:    0.7.0.1
 */