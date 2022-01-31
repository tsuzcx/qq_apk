package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class MMGridPaperGridView$2
  implements AdapterView.OnItemLongClickListener
{
  MMGridPaperGridView$2(MMGridPaperGridView paramMMGridPaperGridView) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (MMGridPaperGridView.a(this.uVU) == null) {
      y.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView.2
 * JD-Core Version:    0.7.0.1
 */