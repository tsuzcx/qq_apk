package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectContactUI$12
  implements View.OnClickListener
{
  SelectContactUI$12(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33860);
    paramView = new Intent();
    paramView.setClassName(this.Afg, "com.tencent.mm.ui.contact.GroupCardSelectUI");
    paramView.putExtra("group_select_type", false);
    this.Afg.startActivityForResult(paramView, 1);
    AppMethodBeat.o(33860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.12
 * JD-Core Version:    0.7.0.1
 */