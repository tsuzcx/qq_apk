package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;

final class NoteEditorUI$1
  implements View.OnClickListener
{
  NoteEditorUI$1(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onClick(View paramView)
  {
    if (NoteEditorUI.a(this.rLT) != null) {
      NoteEditorUI.a(this.rLT).rHY.dismiss();
    }
    NoteEditorUI.b(this.rLT).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.1
 * JD-Core Version:    0.7.0.1
 */