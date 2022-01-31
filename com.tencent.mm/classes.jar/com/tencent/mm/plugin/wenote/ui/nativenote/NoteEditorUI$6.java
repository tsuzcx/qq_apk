package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bi;

final class NoteEditorUI$6
  implements Runnable
{
  NoteEditorUI$6(NoteEditorUI paramNoteEditorUI, bi parambi, String paramString1, String paramString2, Dialog paramDialog) {}
  
  public final void run()
  {
    nd localnd = new nd();
    localnd.bWJ.type = 4;
    localnd.bWJ.bWO = this.dUH;
    localnd.bWJ.toUser = this.bxX;
    localnd.bWJ.bNL = this.nub;
    a.udP.m(localnd);
    ai.d(new NoteEditorUI.6.1(this));
  }
  
  public final String toString()
  {
    return super.toString() + "|onActivityResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.6
 * JD-Core Version:    0.7.0.1
 */