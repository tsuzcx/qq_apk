package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.y;

final class MallEditText$4
  implements AdapterView.OnItemClickListener
{
  MallEditText$4(MallEditText paramMallEditText) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    MallEditText.a(this.nqk, MallEditText.d(this.nqk).wu(paramInt));
    if (MallEditText.e(this.nqk) != null)
    {
      y.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(this.nqk).npv + ", record.name " + MallEditText.e(this.nqk).name);
      this.nqk.setInput(MallEditText.e(this.nqk));
    }
    MallEditText.a(this.nqk).dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.4
 * JD-Core Version:    0.7.0.1
 */