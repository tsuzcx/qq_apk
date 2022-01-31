package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;

final class NoteEditorUI$1
  implements View.OnClickListener
{
  NoteEditorUI$1(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26994);
    if (NoteEditorUI.a(this.vCx) != null) {
      NoteEditorUI.a(this.vCx).vyE.dismiss();
    }
    NoteEditorUI.b(this.vCx).setVisibility(8);
    AppMethodBeat.o(26994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.1
 * JD-Core Version:    0.7.0.1
 */