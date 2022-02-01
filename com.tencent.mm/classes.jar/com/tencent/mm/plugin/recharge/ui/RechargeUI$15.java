package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class RechargeUI$15
  implements View.OnClickListener
{
  RechargeUI$15(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67229);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = c.eGT();
    localObject = RechargeUI.h(this.xpj).jDb;
    ad.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(localObject)));
    if ((!bt.isNullOrNil((String)localObject)) && (paramView.DbG.containsKey(localObject)))
    {
      localObject = (MallNews)paramView.DbG.get(localObject);
      if ("1".equals(((MallNews)localObject).Dbv))
      {
        ((MallNews)localObject).Dbv = "2";
        paramView.dzN();
      }
    }
    RechargeUI.i(this.xpj).setVisibility(8);
    a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.15
 * JD-Core Version:    0.7.0.1
 */