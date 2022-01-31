package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SelectScanModePanel$3
  implements AdapterView.OnItemClickListener
{
  SelectScanModePanel$3(SelectScanModePanel paramSelectScanModePanel) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = true;
    AppMethodBeat.i(81333);
    if ((paramAdapterView == null) || (SelectScanModePanel.e(this.qBF) == null))
    {
      paramView = new StringBuilder("parent == null ? ");
      if (paramAdapterView == null)
      {
        bool1 = true;
        paramAdapterView = paramView.append(bool1).append(", context == null ? ");
        if (SelectScanModePanel.e(this.qBF) != null) {
          break label91;
        }
      }
      label91:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ab.e("MicroMsg.scanner.SelectScanModePanel", bool1);
        AppMethodBeat.o(81333);
        return;
        bool1 = false;
        break;
      }
    }
    paramView = (SelectScanModeGrid.b)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      ab.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
      AppMethodBeat.o(81333);
      return;
    }
    ((SelectScanModeGrid.a)paramAdapterView.getAdapter()).qBf = paramInt;
    ab.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramInt), paramView.title });
    if ((SelectScanModePanel.f(this.qBF) != null) && (paramView != null)) {
      SelectScanModePanel.f(this.qBF).CH(paramView.qBk);
    }
    this.qBF.setSelectedMode(paramView.qBk);
    AppMethodBeat.o(81333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel.3
 * JD-Core Version:    0.7.0.1
 */