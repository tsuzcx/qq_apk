package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class MMGridPaperGridView$1
  implements AdapterView.OnItemClickListener
{
  MMGridPaperGridView$1(MMGridPaperGridView paramMMGridPaperGridView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (MMGridPaperGridView.a(this.uVU) == null) {
      y.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView.1
 * JD-Core Version:    0.7.0.1
 */