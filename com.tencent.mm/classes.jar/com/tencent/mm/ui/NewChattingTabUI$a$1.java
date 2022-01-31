package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class NewChattingTabUI$a$1
  implements Runnable
{
  NewChattingTabUI$a$1(NewChattingTabUI.a parama) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(29807);
    if (NewChattingTabUI.c(this.zeq.zei) == null) {}
    for (;;)
    {
      ab.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
      if (NewChattingTabUI.c(this.zeq.zei) != null)
      {
        ab.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
        NewChattingTabUI.c(this.zeq.zei).onActivityResult(this.zeq.requestCode & 0xFFFF, this.zeq.bpE, this.zeq.cyu);
      }
      AppMethodBeat.o(29807);
      return;
      bool = false;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29808);
    String str = super.toString() + "|PostSelectImageJob_onActivityResult";
    AppMethodBeat.o(29808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.a.1
 * JD-Core Version:    0.7.0.1
 */