package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class RechargeUI$15
  implements View.OnClickListener
{
  RechargeUI$15(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44321);
    paramView = c.cUX();
    Object localObject = RechargeUI.h(this.pWS).pUM;
    ab.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(localObject)));
    if ((!bo.isNullOrNil((String)localObject)) && (paramView.umy.containsKey(localObject)))
    {
      localObject = (MallNews)paramView.umy.get(localObject);
      if ("1".equals(((MallNews)localObject).umn))
      {
        ((MallNews)localObject).umn = "2";
        paramView.cbo();
      }
    }
    RechargeUI.i(this.pWS).setVisibility(8);
    AppMethodBeat.o(44321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.15
 * JD-Core Version:    0.7.0.1
 */