package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.widget.snackbar.b;

final class NoteEditorUI$6$1
  implements Runnable
{
  NoteEditorUI$6$1(NoteEditorUI.6 param6) {}
  
  public final void run()
  {
    this.rLV.kbH.dismiss();
    b.h(this.rLV.rLT, this.rLV.rLT.getString(R.l.finish_sent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.6.1
 * JD-Core Version:    0.7.0.1
 */