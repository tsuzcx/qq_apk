package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class BizChatFavUI$2
  implements AdapterView.OnItemLongClickListener
{
  BizChatFavUI$2(BizChatFavUI paramBizChatFavUI, j paramj) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < BizChatFavUI.e(this.vfa).getHeaderViewsCount())
    {
      y.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
      return true;
    }
    this.hZt.a(paramView, paramInt, paramLong, this.vfa, BizChatFavUI.g(this.vfa));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.2
 * JD-Core Version:    0.7.0.1
 */