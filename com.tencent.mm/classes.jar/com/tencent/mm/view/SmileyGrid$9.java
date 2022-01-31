package com.tencent.mm.view;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;

final class SmileyGrid$9
  implements AdapterView.OnItemClickListener
{
  SmileyGrid$9(SmileyGrid paramSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62906);
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    int i;
    if ((paramAdapterView instanceof i))
    {
      i = ((i)paramAdapterView).position;
      paramAdapterView = com.tencent.mm.cd.e.dve().qC(i);
      ((d)g.G(d.class)).getProvider().cb(paramAdapterView, i);
      if (SmileyGrid.d(this.AQO) != null) {
        if (!SmileyGrid.f(this.AQO)) {
          break label126;
        }
      }
    }
    label126:
    for (paramAdapterView = com.tencent.mm.cd.e.dve().qB(i);; paramAdapterView = com.tencent.mm.cd.e.dve().getText(i))
    {
      SmileyGrid.d(this.AQO).append(paramAdapterView);
      b.Pa().a(paramAdapterView.replaceAll(",", " "), true, paramInt);
      AppMethodBeat.o(62906);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid.9
 * JD-Core Version:    0.7.0.1
 */