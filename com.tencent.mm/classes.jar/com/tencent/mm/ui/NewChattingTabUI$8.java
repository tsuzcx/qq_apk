package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class NewChattingTabUI$8
  implements Runnable
{
  NewChattingTabUI$8(NewChattingTabUI paramNewChattingTabUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29805);
    long l = System.currentTimeMillis();
    aw.RO().dtd();
    al.Nf(0);
    NewChattingTabUI.g(this.zei).onSwipe(1.0F);
    if (NewChattingTabUI.d(this.zei) != null) {
      NewChattingTabUI.d(this.zei).dOc();
    }
    NewChattingTabUI.z(this.zei).onEnterEnd();
    NewChattingTabUI.y(this.zei);
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "doJobOnChattingAnimEnd cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(29805);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29806);
    String str = super.toString() + "|chattingView_onAnimationEnd";
    AppMethodBeat.o(29806);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.8
 * JD-Core Version:    0.7.0.1
 */