package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppGrid$2
  implements AdapterView.OnItemLongClickListener
{
  AppGrid$2(AppGrid paramAppGrid) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(27728);
    paramAdapterView = AppGrid.c(this.vUL);
    int i = AppGrid.c(this.vUL).Mf(AppGrid.a(this.vUL) * AppGrid.b(this.vUL) + paramInt);
    AppGrid.d(this.vUL).Gn(paramInt);
    paramAdapterView.Mg(i);
    AppMethodBeat.o(27728);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid.2
 * JD-Core Version:    0.7.0.1
 */