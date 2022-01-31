package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NoteEditorUI$21
  implements Runnable
{
  NoteEditorUI$21(NoteEditorUI paramNoteEditorUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(27017);
    ImageButton localImageButton = (ImageButton)NoteEditorUI.P(this.vCx).findViewById(2131826567);
    View localView = NoteEditorUI.P(this.vCx).findViewById(2131826568);
    switch (this.DS)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27017);
      return;
      NoteEditorUI.af(this.vCx).setVisibility(8);
      if (!NoteEditorUI.f(this.vCx).vCY)
      {
        NoteEditorUI.P(this.vCx).setVisibility(8);
        AppMethodBeat.o(27017);
        return;
      }
      NoteEditorUI.P(this.vCx).setVisibility(0);
      AppMethodBeat.o(27017);
      return;
      localImageButton.setImageResource(2131231782);
      localView.setVisibility(8);
      NoteEditorUI.P(this.vCx).setVisibility(0);
      NoteEditorUI.af(this.vCx).setVisibility(8);
      AppMethodBeat.o(27017);
      return;
      NoteEditorUI.P(this.vCx).setVisibility(0);
      NoteEditorUI.af(this.vCx).setVisibility(8);
      AppMethodBeat.o(27017);
      return;
      localImageButton.setImageResource(2131231781);
      localView.setVisibility(0);
      NoteEditorUI.P(this.vCx).setVisibility(0);
      NoteEditorUI.af(this.vCx).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.21
 * JD-Core Version:    0.7.0.1
 */