package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;

final class MainUI$11
  implements Runnable
{
  int ePG = 0;
  
  MainUI$11(MainUI paramMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34503);
    if (MainUI.a(this.Alw) == null)
    {
      AppMethodBeat.o(34503);
      return;
    }
    int i = am.K(this.Alw.getContext(), -1);
    int j = f.di(MainUI.a(this.Alw).getContext());
    if ((i <= 0) || (j <= 0)) {
      if (this.ePG < 2)
      {
        ab.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
        MainUI.a(this.Alw).post(this);
        this.ePG += 1;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.ePG), Integer.valueOf(i) });
      AppMethodBeat.o(34503);
      return;
      ab.e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
      break;
      if (i != MainUI.a(this.Alw).getPaddingTop())
      {
        ab.i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(MainUI.a(this.Alw).getPaddingTop()) });
        MainUI.b(this.Alw, i);
      }
      else
      {
        ab.i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.11
 * JD-Core Version:    0.7.0.1
 */