package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;

final class SnsSelectContactDialog$1
  implements AdapterView.OnItemClickListener
{
  SnsSelectContactDialog$1(SnsSelectContactDialog paramSnsSelectContactDialog) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == SnsSelectContactDialog.a(this.pbH).getCount() - 1) {
      SnsSelectContactDialog.b(this.pbH);
    }
    for (;;)
    {
      SnsSelectContactDialog.a(this.pbH).refresh();
      return;
      SnsSelectContactDialog.c(this.pbH).remove(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog.1
 * JD-Core Version:    0.7.0.1
 */