package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class SelectScanModePanel$3
  implements AdapterView.OnItemClickListener
{
  SelectScanModePanel$3(SelectScanModePanel paramSelectScanModePanel) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = true;
    if ((paramAdapterView == null) || (SelectScanModePanel.e(this.nNV) == null))
    {
      paramView = new StringBuilder("parent == null ? ");
      if (paramAdapterView == null)
      {
        bool1 = true;
        paramAdapterView = paramView.append(bool1).append(", context == null ? ");
        if (SelectScanModePanel.e(this.nNV) != null) {
          break label81;
        }
      }
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        y.e("MicroMsg.scanner.SelectScanModePanel", bool1);
        return;
        bool1 = false;
        break;
      }
    }
    paramView = (SelectScanModeGrid.b)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      y.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
      return;
    }
    ((SelectScanModeGrid.a)paramAdapterView.getAdapter()).nNu = paramInt;
    y.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramInt), paramView.title });
    if ((SelectScanModePanel.f(this.nNV) != null) && (paramView != null)) {
      SelectScanModePanel.f(this.nNV).wQ(paramView.nNz);
    }
    this.nNV.setSelectedMode(paramView.nNz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel.3
 * JD-Core Version:    0.7.0.1
 */