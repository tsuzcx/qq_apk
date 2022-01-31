package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatFavUI$3
  implements AdapterView.OnItemClickListener
{
  BizChatFavUI$3(BizChatFavUI paramBizChatFavUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(30109);
    paramAdapterView = (com.tencent.mm.aj.a.c)BizChatFavUI.c(this.ztz).getItem(paramInt);
    BizChatFavUI.b(this.ztz, paramAdapterView.field_bizChatLocalId);
    AppMethodBeat.o(30109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.3
 * JD-Core Version:    0.7.0.1
 */