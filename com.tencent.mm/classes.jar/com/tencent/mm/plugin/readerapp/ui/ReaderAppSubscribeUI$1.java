package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ReaderAppSubscribeUI$1
  implements AdapterView.OnItemClickListener
{
  ReaderAppSubscribeUI$1(ReaderAppSubscribeUI paramReaderAppSubscribeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(76802);
    paramAdapterView = ReaderAppSubscribeUI.a(this.pTW);
    if ((paramAdapterView.pTY & paramAdapterView.pTX[paramInt]) != 0)
    {
      paramAdapterView.pTY &= (paramAdapterView.pTX[paramInt] ^ 0xFFFFFFFF);
      paramAdapterView.pUa -= 1;
      if (paramAdapterView.pUa < 0) {
        paramAdapterView.pUa = 0;
      }
      paramAdapterView.notifyDataSetChanged();
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt == 0) {
        h.h(this.pTW, 2131298718, 2131297087);
      }
      AppMethodBeat.o(76802);
      return;
      if (paramAdapterView.pUa < 3)
      {
        paramAdapterView.pTY |= paramAdapterView.pTX[paramInt];
        paramAdapterView.pUa += 1;
        if (paramAdapterView.pUa > paramAdapterView.pTX.length) {
          paramAdapterView.pUa = paramAdapterView.pTX.length;
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