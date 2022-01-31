package com.tencent.mm.ui.conversation;

import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MainUI$12
  implements Runnable
{
  MainUI$12(MainUI paramMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34504);
    if (this.Alw.thisActivity() != null) {
      this.Alw.thisActivity().supportInvalidateOptionsMenu();
    }
    AppMethodBeat.o(34504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.12
 * JD-Core Version:    0.7.0.1
 */