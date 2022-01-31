package com.tencent.mm.plugin.scanner.history.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class ScannerHistoryUI$2
  implements AdapterView.OnItemClickListener
{
  ScannerHistoryUI$2(ScannerHistoryUI paramScannerHistoryUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0)
    {
      y.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
      return;
    }
    int i = paramInt;
    if (paramInt > 0) {
      i = paramInt - 1;
    }
    ScannerHistoryUI.a(this.nGx, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.2
 * JD-Core Version:    0.7.0.1
 */