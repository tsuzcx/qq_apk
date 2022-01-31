package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, n paramn, b.b paramb1) {}
  
  public final void onClick(View paramView)
  {
    if (b.a(this.nqz) != null)
    {
      if (!b.b(this.nqz).contains(this.nqx.qly))
      {
        y.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { this.nqx.qly });
        b.b(this.nqz).add(this.nqx.qly);
        g.DP().Dz().c(ac.a.uzQ, bk.c(b.b(this.nqz), ","));
        this.nqy.nqB.setVisibility(8);
      }
      b.a(this.nqz).a(this.nqx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b.1
 * JD-Core Version:    0.7.0.1
 */