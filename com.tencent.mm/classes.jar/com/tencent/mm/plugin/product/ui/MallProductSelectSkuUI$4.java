package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class MallProductSelectSkuUI$4
  implements View.OnClickListener
{
  MallProductSelectSkuUI$4(MallProductSelectSkuUI paramMallProductSelectSkuUI) {}
  
  public final void onClick(View paramView)
  {
    f localf = MallProductSelectSkuUI.d(this.mUv);
    if (localf.mTJ) {
      s.makeText(localf.fyk, a.i.mall_product_data_loading, 1).show();
    }
    for (;;)
    {
      return;
      if (localf.mTL.bsb())
      {
        if (localf.mTL.mRV != null)
        {
          g.DQ();
          g.DO().dJT.a(new j(localf.mTL.bsd(), f.fzn), 0);
          return;
        }
        d.c(localf.fyk, "address", ".ui.WalletAddAddressUI", 2);
        return;
      }
      paramView = localf.mTL;
      com.tencent.mm.plugin.product.c.m localm;
      if ((paramView.mSb != null) && (paramView.mSb.size() < paramView.mRZ) && (paramView.mRZ > 0))
      {
        Iterator localIterator = paramView.mRP.mSu.mSO.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localm = (com.tencent.mm.plugin.product.c.m)localIterator.next();
        } while (paramView.mSb.containsKey(localm.mSZ));
      }
      for (paramView = localm.mTa; !bk.bl(paramView); paramView = null)
      {
        s.makeText(localf.fyk, localf.fyk.getString(a.i.mall_product_select_sku_err, new Object[] { paramView }), 0).show();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.4
 * JD-Core Version:    0.7.0.1
 */