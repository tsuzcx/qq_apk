package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.wecoin.model.b;
import com.tencent.mm.plugin.wallet.wecoin.model.d;
import com.tencent.mm.plugin.wallet.wecoin.model.f;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dof;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"})
public final class a$j
  implements b
{
  a$j(String paramString, dof paramdof, a parama, d paramd) {}
  
  public final void a(dms paramdms)
  {
    AppMethodBeat.i(268484);
    if (paramdms != null)
    {
      if (paramdms.action == 3)
      {
        paramdms = (CharSequence)this.OGm;
        if ((paramdms != null) && (paramdms.length() != 0)) {
          break label80;
        }
      }
      label80:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          a.d(this.OGh).a((Activity)this.OGh.OGe, this.OGn, "release", this.OGm);
        }
        AppMethodBeat.o(268484);
        return;
      }
    }
    AppMethodBeat.o(268484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.a.j
 * JD-Core Version:    0.7.0.1
 */