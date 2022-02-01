package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.snackbar.b;

final class NoteEditorUI$8
  implements Runnable
{
  NoteEditorUI$8(NoteEditorUI paramNoteEditorUI, ca paramca, String paramString1, String paramString2, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(30697);
    sc localsc = new sc();
    localsc.fRw.type = 4;
    localsc.fRw.fNz = this.lru;
    localsc.fRw.toUser = this.ffX;
    localsc.fRw.fEh = this.HEr;
    EventCenter.instance.publish(localsc);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30696);
        NoteEditorUI.8.this.wJe.dismiss();
        b.r(NoteEditorUI.8.this.QJv, NoteEditorUI.8.this.QJv.getString(R.l.finish_sent));
        AppMethodBeat.o(30696);
      }
    });
    AppMethodBeat.o(30697);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30698);
    String str = super.toString() + "|onActivityResult";
    AppMethodBeat.o(30698);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.8
 * JD-Core Version:    0.7.0.1
 */