package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.ui.base.h;

final class ReaderAppSubscribeUI$1
  implements AdapterView.OnItemClickListener
{
  ReaderAppSubscribeUI$1(ReaderAppSubscribeUI paramReaderAppSubscribeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = ReaderAppSubscribeUI.a(this.noI);
    if ((paramAdapterView.noK & paramAdapterView.noJ[paramInt]) != 0)
    {
      paramAdapterView.noK &= (paramAdapterView.noJ[paramInt] ^ 0xFFFFFFFF);
      paramAdapterView.noM -= 1;
      if (paramAdapterView.noM < 0) {
        paramAdapterView.noM = 0;
      }
      paramAdapterView.notifyDataSetChanged();
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt == 0) {
        h.h(this.noI, a.g.contact_info_readerappnews_subscribe_limit, a.g.app_tip);
      }
      return;
      if (paramAdapterView.noM < 3)
      {
        paramAdapterView.noK |= paramAdapterView.noJ[paramInt];
        paramAdapterView.noM += 1;
        if (paramAdapterView.noM > paramAdapterView.noJ.length) {
          paramAdapterView.noM = paramAdapterView.noJ.length;
        }
        paramAdapterView.notifyDataSetChanged();
        paramInt = i;
      }
      else
      {
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.1
 * JD-Core Version:    0.7.0.1
 */