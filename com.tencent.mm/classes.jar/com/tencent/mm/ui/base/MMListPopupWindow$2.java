package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class MMListPopupWindow$2
  implements AdapterView.OnItemSelectedListener
{
  MMListPopupWindow$2(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt != -1)
    {
      paramAdapterView = MMListPopupWindow.a(this.uWx);
      if (paramAdapterView != null) {
        MMListPopupWindow.a.a(paramAdapterView, false);
      }
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */