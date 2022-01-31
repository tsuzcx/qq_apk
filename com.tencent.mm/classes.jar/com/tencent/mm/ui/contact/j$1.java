package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33709);
    Intent localIntent = new Intent();
    localIntent.putExtra("enterprise_from_scene", 2);
    localIntent.putExtra("enterprise_biz_name", j.a(this.AcL));
    d.b(paramView.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
    AppMethodBeat.o(33709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.j.1
 * JD-Core Version:    0.7.0.1
 */