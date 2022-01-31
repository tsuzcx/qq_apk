package com.tencent.mm.ui.bizchat;

import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.r.a;

final class BizChatFavUI$9
  implements r.a
{
  BizChatFavUI$9(BizChatFavUI paramBizChatFavUI) {}
  
  public final void Wp()
  {
    this.vfa.setMMTitle(r.gV(BizChatFavUI.a(this.vfa)));
    if (BizChatFavUI.c(this.vfa).getCount() <= 0)
    {
      BizChatFavUI.d(this.vfa).setVisibility(0);
      BizChatFavUI.e(this.vfa).setVisibility(8);
      return;
    }
    BizChatFavUI.d(this.vfa).setVisibility(8);
    BizChatFavUI.e(this.vfa).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.9
 * JD-Core Version:    0.7.0.1
 */