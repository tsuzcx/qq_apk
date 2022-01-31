package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class NewChattingTabUI$a
  implements Runnable
{
  int bpE;
  Intent cyu;
  int requestCode;
  int zep = 0;
  
  private NewChattingTabUI$a(NewChattingTabUI paramNewChattingTabUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29809);
    if ((aw.RG()) && (NewChattingTabUI.a(this.zei) != null))
    {
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.zep) });
      this.zei.startChatting(NewChattingTabUI.b(this.zei), null, false);
      al.d(new NewChattingTabUI.a.1(this));
      AppMethodBeat.o(29809);
      return;
    }
    if (this.zep >= 3)
    {
      ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
      AppMethodBeat.o(29809);
      return;
    }
    if (NewChattingTabUI.a(this.zei) != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.zep) });
      this.zep += 1;
      al.p(this, 300L);
      AppMethodBeat.o(29809);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29810);
    String str = super.toString() + "|PostSelectImageJob";
    AppMethodBeat.o(29810);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.a
 * JD-Core Version:    0.7.0.1
 */