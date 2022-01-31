package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.plugin.record.b.h;
import java.util.List;

final class RecordMsgImageUI$1
  implements AdapterView.OnItemSelectedListener
{
  RecordMsgImageUI$1(RecordMsgImageUI paramRecordMsgImageUI) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (h.d(RecordMsgImageUI.a(this.nuo).wC(paramInt), RecordMsgImageUI.b(this.nuo)))
    {
      this.nuo.setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(RecordMsgImageUI.c(this.nuo).size()) }));
      this.nuo.enableOptionMenu(true);
      return;
    }
    this.nuo.enableOptionMenu(false);
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.1
 * JD-Core Version:    0.7.0.1
 */