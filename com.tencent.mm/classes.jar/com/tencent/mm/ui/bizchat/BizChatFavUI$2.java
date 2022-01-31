package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class BizChatFavUI$2
  implements AdapterView.OnItemLongClickListener
{
  BizChatFavUI$2(BizChatFavUI paramBizChatFavUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(30108);
    if (paramInt < BizChatFavUI.e(this.ztz).getHeaderViewsCount())
    {
      ab.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
      AppMethodBeat.o(30108);
      return true;
    }
    this.jSq.a(paramView, paramInt, paramLong, this.ztz, BizChatFavUI.g(this.ztz));
    AppMethodBeat.o(30108);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.2
 * JD-Core Version:    0.7.0.1
 */