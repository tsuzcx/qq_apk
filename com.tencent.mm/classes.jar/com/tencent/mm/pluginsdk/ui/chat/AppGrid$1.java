package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppGrid$1
  implements AdapterView.OnItemClickListener
{
  AppGrid$1(AppGrid paramAppGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(27727);
    AppGrid.c(this.vUL).a(AppGrid.c(this.vUL).Mf(AppGrid.a(this.vUL) * AppGrid.b(this.vUL) + paramInt), AppGrid.d(this.vUL).Gn(paramInt));
    AppMethodBeat.o(27727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid.1
 * JD-Core Version:    0.7.0.1
 */