package com.tencent.mm.ui.chatting.c;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;

final class t$2
  implements View.OnClickListener
{
  t$2(t paramt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31475);
    if (!this.zGC.caz.zJz.isScreenEnable())
    {
      ab.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
      AppMethodBeat.o(31475);
      return;
    }
    paramView.setSelected(false);
    paramView.setPressed(false);
    paramView.clearFocus();
    paramView.invalidate();
    paramView.post(new t.2.1(this));
    AppMethodBeat.o(31475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.2
 * JD-Core Version:    0.7.0.1
 */