package com.tencent.mm.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class SmileyGrid$1
  implements AdapterView.OnItemClickListener
{
  SmileyGrid$1(SmileyGrid paramSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (SmileyGrid.a(this.wvO))
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((SmileyGrid.a(this.wvO) == 25) && (paramInt == 0) && (this.wvO.hxH == 0) && (SmileyGrid.b(this.wvO) != ChatFooterPanel.rZw) && (SmileyGrid.b(this.wvO) != ChatFooterPanel.rZx))
            {
              SmileyGrid.c(this.wvO);
              return;
            }
            paramAdapterView = (EmojiInfo)this.wvO.NK.getItem(paramInt);
            SmileyGrid.a(this.wvO, paramAdapterView);
            return;
            if ((!(paramAdapterView.getAdapter() instanceof com.tencent.mm.view.a.d)) || (!((com.tencent.mm.view.a.d)paramAdapterView.getAdapter()).IP(paramInt))) {
              break;
            }
          } while (SmileyGrid.d(this.wvO) == null);
          SmileyGrid.d(this.wvO).asj();
          return;
          if (paramInt != this.wvO.NK.getCount() - 1) {
            break;
          }
        } while (SmileyGrid.d(this.wvO) == null);
        SmileyGrid.d(this.wvO).asj();
        return;
      } while (this.wvO.hxH * (this.wvO.wvJ - 1) + paramInt >= SmileyGrid.e(this.wvO));
      paramInt = this.wvO.hxH * (this.wvO.wvJ - 1) + paramInt;
      paramAdapterView = com.tencent.mm.cd.e.csH().mY(paramInt);
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().bv(paramAdapterView, paramInt);
    } while (SmileyGrid.d(this.wvO) == null);
    if (SmileyGrid.f(this.wvO)) {}
    for (paramAdapterView = com.tencent.mm.cd.e.csH().mX(paramInt);; paramAdapterView = com.tencent.mm.cd.e.csH().getText(paramInt))
    {
      SmileyGrid.d(this.wvO).append(paramAdapterView);
      h.nFQ.f(13470, new Object[] { paramAdapterView.replaceAll(",", " "), Integer.valueOf(SmileyGrid.b(this.wvO)), Integer.valueOf(0) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid.1
 * JD-Core Version:    0.7.0.1
 */