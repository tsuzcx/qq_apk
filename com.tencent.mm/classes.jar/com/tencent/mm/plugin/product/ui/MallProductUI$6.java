package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.t;

final class MallProductUI$6
  implements View.OnClickListener
{
  MallProductUI$6(MallProductUI paramMallProductUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44162);
    paramView = MallProductUI.e(this.pxl);
    if (paramView.pvR.cbg())
    {
      paramView.gQx.startActivity(new Intent(paramView.gQx, MallProductSelectSkuUI.class));
      h.qsU.e(11008, new Object[] { paramView.pvR.cbc(), paramView.pvR.ptU.puw, Integer.valueOf(f.mScene), Integer.valueOf(1) });
      AppMethodBeat.o(44162);
      return;
    }
    t.makeText(paramView.gQx, 2131301472, 1).show();
    AppMethodBeat.o(44162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.6
 * JD-Core Version:    0.7.0.1
 */