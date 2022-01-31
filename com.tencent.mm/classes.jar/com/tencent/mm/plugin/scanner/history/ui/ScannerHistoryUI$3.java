package com.tencent.mm.plugin.scanner.history.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ScannerHistoryUI$3
  implements AdapterView.OnItemLongClickListener
{
  ScannerHistoryUI$3(ScannerHistoryUI paramScannerHistoryUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(80802);
    if (paramInt == 0)
    {
      ab.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
      AppMethodBeat.o(80802);
      return true;
    }
    int i = paramInt;
    if (paramInt > 0) {
      i = paramInt - 1;
    }
    if (i >= ScannerHistoryUI.a(this.qtO).getCount())
    {
      AppMethodBeat.o(80802);
      return true;
    }
    ScannerHistoryUI.b(this.qtO, i);
    AppMethodBeat.o(80802);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.3
 * JD-Core Version:    0.7.0.1
 */