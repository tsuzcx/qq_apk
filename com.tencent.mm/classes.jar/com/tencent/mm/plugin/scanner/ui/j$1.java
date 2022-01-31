package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81158);
    paramView = ((LayoutInflater)this.qzs.qzg.getContext().getSystemService("layout_inflater")).inflate(2130970599, null);
    Activity localActivity = this.qzs.qzg.getContext();
    h.a(localActivity, localActivity.getString(2131302884), localActivity.getString(2131302883), paramView, new j.1.1(this)).show();
    AppMethodBeat.o(81158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.j.1
 * JD-Core Version:    0.7.0.1
 */