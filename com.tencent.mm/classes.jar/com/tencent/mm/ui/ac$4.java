package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;

final class ac$4
  implements View.OnClickListener
{
  ac$4(ac paramac) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11264, new Object[] { Integer.valueOf(1) });
    this.uPi.startActivity(new Intent(this.uPi.getContext(), SelfQRCodeUI.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ac.4
 * JD-Core Version:    0.7.0.1
 */