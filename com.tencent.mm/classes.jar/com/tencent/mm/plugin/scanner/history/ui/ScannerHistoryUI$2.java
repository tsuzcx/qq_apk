package com.tencent.mm.plugin.scanner.history.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ScannerHistoryUI$2
  implements AdapterView.OnItemClickListener
{
  ScannerHistoryUI$2(ScannerHistoryUI paramScannerHistoryUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(80801);
    if (paramInt == 0)
    {
      ab.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
      AppMethodBeat.o(80801);
      return;
    }
    int i = paramInt;
    if (paramInt > 0) {
      i = paramInt - 1;
    }
    ScannerHistoryUI.a(this.qtO, i);
    AppMethodBeat.o(80801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.2
 * JD-Core Version:    0.7.0.1
 */