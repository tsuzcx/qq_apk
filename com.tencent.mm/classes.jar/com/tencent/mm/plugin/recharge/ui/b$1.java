package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, q paramq, b.b paramb1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44247);
    if (b.a(this.pVN) != null)
    {
      if (!b.b(this.pVN).contains(this.pVL.tUK))
      {
        ab.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { this.pVL.tUK });
        if (this.pVL.tUK != null)
        {
          b.b(this.pVN).add(this.pVL.tUK);
          g.RL().Ru().set(ac.a.yKI, bo.d(b.b(this.pVN), ","));
          this.pVM.pVP.setVisibility(8);
        }
      }
      b.a(this.pVN).a(this.pVL);
    }
    AppMethodBeat.o(44247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b.1
 * JD-Core Version:    0.7.0.1
 */