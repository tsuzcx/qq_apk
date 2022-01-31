package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.i;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

final class h$b$1
  implements View.OnClickListener
{
  h$b$1(h.b paramb, String paramString, a.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81061);
    paramView = new i(this.lgI, this.qxB.qtW, this.qxB.type, this.lgI, this.qxC.getCount(), this.qxB.showType);
    g.Rc().a(paramView, 0);
    if (!bo.isNullOrNil(this.lgI))
    {
      paramView = new Intent();
      paramView.putExtra("key_Product_ID", this.lgI);
      d.b(this.qxC.qxA.mContext, "scanner", ".ui.ProductUI", paramView);
    }
    AppMethodBeat.o(81061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h.b.1
 * JD-Core Version:    0.7.0.1
 */