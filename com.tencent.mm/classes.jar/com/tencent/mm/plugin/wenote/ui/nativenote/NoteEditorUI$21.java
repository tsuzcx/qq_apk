package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;

final class NoteEditorUI$21
  implements Runnable
{
  NoteEditorUI$21(NoteEditorUI paramNoteEditorUI, int paramInt) {}
  
  public final void run()
  {
    ImageButton localImageButton = (ImageButton)NoteEditorUI.P(this.rLT).findViewById(R.h.wenote_h5_footer_words_style);
    View localView = NoteEditorUI.P(this.rLT).findViewById(R.h.wenote_h5_footer_words_style_underline);
    switch (this.Dj)
    {
    default: 
      return;
    case 0: 
      NoteEditorUI.af(this.rLT).setVisibility(8);
      if (!NoteEditorUI.f(this.rLT).rMu)
      {
        NoteEditorUI.P(this.rLT).setVisibility(8);
        return;
      }
      NoteEditorUI.P(this.rLT).setVisibility(0);
      return;
    case 1: 
      localImageButton.setImageResource(R.k.note_style_unpress);
      localView.setVisibility(8);
      NoteEditorUI.P(this.rLT).setVisibility(0);
      NoteEditorUI.af(this.rLT).setVisibility(8);
      return;
    case 2: 
      NoteEditorUI.P(this.rLT).setVisibility(0);
      NoteEditorUI.af(this.rLT).setVisibility(8);
      return;
    }
    localImageButton.setImageResource(R.k.note_style_press);
    localView.setVisibility(0);
    NoteEditorUI.P(this.rLT).setVisibility(0);
    NoteEditorUI.af(this.rLT).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.21
 * JD-Core Version:    0.7.0.1
 */