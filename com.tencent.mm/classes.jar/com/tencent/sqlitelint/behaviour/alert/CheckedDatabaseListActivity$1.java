package com.tencent.sqlitelint.behaviour.alert;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

class CheckedDatabaseListActivity$1
  implements AdapterView.OnItemClickListener
{
  private byte _hellAccFlag_;
  
  CheckedDatabaseListActivity$1(CheckedDatabaseListActivity paramCheckedDatabaseListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(52890);
    paramView = (String)paramAdapterView.getItemAtPosition(paramInt);
    if (SQLiteLintUtil.isNullOrNil(paramView))
    {
      AppMethodBeat.o(52890);
      return;
    }
    paramAdapterView = new Intent();
    paramAdapterView.setClass(this.this$0, CheckResultActivity.class);
    paramAdapterView.putExtra("db_label", paramView);
    paramView = this.this$0;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAdapterView);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramAdapterView.aYi(), "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)paramAdapterView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(52890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckedDatabaseListActivity.1
 * JD-Core Version:    0.7.0.1
 */