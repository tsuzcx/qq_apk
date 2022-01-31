package com.tencent.mm.view;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.u.a.a;

final class SmileyGrid$2
  implements AdapterView.OnItemClickListener
{
  SmileyGrid$2(SmileyGrid paramSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView instanceof a))
    {
      paramInt = ((a)paramAdapterView).position;
      paramAdapterView = com.tencent.mm.cd.e.csH().mY(paramInt);
      ((d)g.t(d.class)).getProvider().bv(paramAdapterView, paramInt);
      if (SmileyGrid.d(this.wvO) != null) {
        if (!SmileyGrid.f(this.wvO)) {
          break label140;
        }
      }
    }
    label140:
    for (paramAdapterView = com.tencent.mm.cd.e.csH().mX(paramInt);; paramAdapterView = com.tencent.mm.cd.e.csH().getText(paramInt))
    {
      SmileyGrid.d(this.wvO).append(paramAdapterView);
      h.nFQ.f(13470, new Object[] { paramAdapterView.replaceAll(",", " "), Integer.valueOf(SmileyGrid.b(this.wvO)), Integer.valueOf(1) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid.2
 * JD-Core Version:    0.7.0.1
 */