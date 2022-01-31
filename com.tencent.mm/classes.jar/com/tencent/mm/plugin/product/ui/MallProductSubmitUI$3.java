package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.protocal.c.bsn;

final class MallProductSubmitUI$3
  implements View.OnClickListener
{
  MallProductSubmitUI$3(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = MallProductSubmitUI.d(this.mUW);
    if (paramView.mTL.bsc()) {
      if (paramView.mTL.brT() != 0) {
        break label78;
      }
    }
    label78:
    for (int i = 1; i != 0; i = 0)
    {
      g.DQ();
      p localp = g.DO().dJT;
      bsn localbsn = paramView.mTL.bse();
      paramView.mTL.getAppId();
      localp.a(new k(localbsn), 0);
      return;
    }
    g.DQ();
    g.DO().dJT.a(new l(paramView.mTL.bse(), paramView.mTL.getAppId()), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.3
 * JD-Core Version:    0.7.0.1
 */