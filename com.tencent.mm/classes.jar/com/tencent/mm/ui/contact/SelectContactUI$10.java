package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.ah;

final class SelectContactUI$10
  implements View.OnClickListener
{
  SelectContactUI$10(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClassName(this.vNB, "com.tencent.mm.ui.contact.GroupCardSelectUI");
    paramView.putExtra("group_select_type", true);
    boolean bool = s.fA(SelectContactUI.a(this.vNB), 16384);
    paramView.putExtra("group_select_need_result", bool);
    if (bool)
    {
      if (SelectContactUI.b(this.vNB) == 14)
      {
        paramView.putExtra("group_multi_select", true);
        paramView.putExtra("already_select_contact", ah.c(SelectContactUI.a(this.vNB, true), ","));
        paramView.putExtra("max_limit_num", this.vNB.getIntent().getIntExtra("max_limit_num", 9));
        this.vNB.startActivityForResult(paramView, 4);
        return;
      }
      this.vNB.startActivityForResult(paramView, 0);
      return;
    }
    this.vNB.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.10
 * JD-Core Version:    0.7.0.1
 */