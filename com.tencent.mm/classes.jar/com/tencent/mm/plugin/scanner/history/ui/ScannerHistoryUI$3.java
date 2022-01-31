package com.tencent.mm.plugin.scanner.history.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class ScannerHistoryUI$3
  implements AdapterView.OnItemLongClickListener
{
  ScannerHistoryUI$3(ScannerHistoryUI paramScannerHistoryUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      y.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
    }
    int i;
    do
    {
      return true;
      i = paramInt;
      if (paramInt > 0) {
        i = paramInt - 1;
      }
    } while (i >= ScannerHistoryUI.a(this.nGx).getCount());
    ScannerHistoryUI.b(this.nGx, i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.3
 * JD-Core Version:    0.7.0.1
 */