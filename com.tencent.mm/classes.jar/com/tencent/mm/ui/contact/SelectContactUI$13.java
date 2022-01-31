package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class SelectContactUI$13
  implements View.OnClickListener
{
  SelectContactUI$13(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("list_attr", 16384);
    d.b(this.vNB, "brandservice", ".ui.BrandServiceIndexUI", paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.13
 * JD-Core Version:    0.7.0.1
 */