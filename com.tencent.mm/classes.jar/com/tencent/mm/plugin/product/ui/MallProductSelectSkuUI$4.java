package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class MallProductSelectSkuUI$4
  implements View.OnClickListener
{
  MallProductSelectSkuUI$4(MallProductSelectSkuUI paramMallProductSelectSkuUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44109);
    f localf = MallProductSelectSkuUI.d(this.pwB);
    if (localf.pvP)
    {
      t.makeText(localf.gQx, 2131301472, 1).show();
      AppMethodBeat.o(44109);
      return;
    }
    if (localf.pvR.cbh())
    {
      if (localf.pvR.puc != null)
      {
        g.RM();
        g.RK().eHt.a(new j(localf.pvR.cbj(), f.mScene), 0);
        AppMethodBeat.o(44109);
        return;
      }
      d.c(localf.gQx, "address", ".ui.WalletAddAddressUI", 2);
      AppMethodBeat.o(44109);
      return;
    }
    paramView = localf.pvR;
    com.tencent.mm.plugin.product.c.m localm;
    if ((paramView.pui != null) && (paramView.pui.size() < paramView.pug) && (paramView.pug > 0))
    {
      Iterator localIterator = paramView.ptU.puA.puU.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      } while (paramView.pui.containsKey(localm.pvf));
    }
    for (paramView = localm.pvg;; paramView = null)
    {
      if (!bo.isNullOrNil(paramView)) {
        t.makeText(localf.gQx, localf.gQx.getString(2131301481, new Object[] { paramView }), 0).show();
      }
      AppMethodBeat.o(44109);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.4
 * JD-Core Version:    0.7.0.1
 */