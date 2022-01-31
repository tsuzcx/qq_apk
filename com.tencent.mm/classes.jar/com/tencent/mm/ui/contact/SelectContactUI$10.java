package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;

final class SelectContactUI$10
  implements View.OnClickListener
{
  SelectContactUI$10(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33858);
    paramView = new Intent();
    paramView.setClassName(this.Afg, "com.tencent.mm.ui.contact.GroupCardSelectUI");
    paramView.putExtra("group_select_type", true);
    boolean bool = t.hI(SelectContactUI.b(this.Afg), 16384);
    paramView.putExtra("group_select_need_result", bool);
    if (bool)
    {
      if (SelectContactUI.c(this.Afg) == 14)
      {
        paramView.putExtra("group_multi_select", true);
        paramView.putExtra("already_select_contact", ah.d(SelectContactUI.a(this.Afg, true), ","));
        paramView.putExtra("max_limit_num", this.Afg.getIntent().getIntExtra("max_limit_num", 9));
        this.Afg.startActivityForResult(paramView, 4);
        AppMethodBeat.o(33858);
        return;
      }
      this.Afg.startActivityForResult(paramView, 0);
      AppMethodBeat.o(33858);
      return;
    }
    this.Afg.startActivity(paramView);
    AppMethodBeat.o(33858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.10
 * JD-Core Version:    0.7.0.1
 */