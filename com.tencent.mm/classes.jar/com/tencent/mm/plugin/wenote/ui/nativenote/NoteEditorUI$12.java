package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class NoteEditorUI$12
  implements View.OnClickListener
{
  NoteEditorUI$12(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30702);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    NoteEditorUI.gkh();
    a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.12
 * JD-Core Version:    0.7.0.1
 */