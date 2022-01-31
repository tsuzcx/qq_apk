package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    paramView = ((LayoutInflater)this.nLL.nLB.getContext().getSystemService("layout_inflater")).inflate(R.i.scan_bank_card_declare, null);
    Activity localActivity = this.nLL.nLB.getContext();
    h.a(localActivity, localActivity.getString(R.l.scan_bank_card_declare_title), localActivity.getString(R.l.scan_bank_card_declare_ok), paramView, new j.1.1(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.j.1
 * JD-Core Version:    0.7.0.1
 */