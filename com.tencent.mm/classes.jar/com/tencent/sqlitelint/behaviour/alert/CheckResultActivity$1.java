package com.tencent.sqlitelint.behaviour.alert;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;

class CheckResultActivity$1
  implements AdapterView.OnItemClickListener
{
  private byte _hellAccFlag_;
  
  CheckResultActivity$1(CheckResultActivity paramCheckResultActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(52880);
    paramView = (SQLiteLintIssue)paramAdapterView.getItemAtPosition(paramInt);
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("issue", paramView);
    paramAdapterView.setClass(this.this$0.getBaseContext(), IssueDetailActivity.class);
    paramView = this.this$0;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAdapterView);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramAdapterView.aYi(), "com/tencent/sqlitelint/behaviour/alert/CheckResultActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)paramAdapterView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/sqlitelint/behaviour/alert/CheckResultActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(52880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckResultActivity.1
 * JD-Core Version:    0.7.0.1
 */