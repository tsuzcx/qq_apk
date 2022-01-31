package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class SelectContactUI$12
  implements View.OnClickListener
{
  SelectContactUI$12(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClassName(this.vNB, "com.tencent.mm.ui.contact.GroupCardSelectUI");
    paramView.putExtra("group_select_type", false);
    this.vNB.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.12
 * JD-Core Version:    0.7.0.1
 */