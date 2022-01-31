package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;

final class MoreTabUI$8
  implements View.OnClickListener
{
  MoreTabUI$8(MoreTabUI paramMoreTabUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29699);
    h.qsU.e(11264, new Object[] { Integer.valueOf(1) });
    this.zdu.startActivity(new Intent(this.zdu.getContext(), SelfQRCodeUI.class));
    AppMethodBeat.o(29699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.8
 * JD-Core Version:    0.7.0.1
 */