package com.tencent.mm.ui.bizchat;

import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.ui.p.a;

final class BizChatFavUI$9
  implements p.a
{
  BizChatFavUI$9(BizChatFavUI paramBizChatFavUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(30115);
    this.ztz.setMMTitle(s.nE(BizChatFavUI.a(this.ztz)));
    if (BizChatFavUI.c(this.ztz).getCount() <= 0)
    {
      BizChatFavUI.d(this.ztz).setVisibility(0);
      BizChatFavUI.e(this.ztz).setVisibility(8);
      AppMethodBeat.o(30115);
      return;
    }
    BizChatFavUI.d(this.ztz).setVisibility(8);
    BizChatFavUI.e(this.ztz).setVisibility(0);
    AppMethodBeat.o(30115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.9
 * JD-Core Version:    0.7.0.1
 */