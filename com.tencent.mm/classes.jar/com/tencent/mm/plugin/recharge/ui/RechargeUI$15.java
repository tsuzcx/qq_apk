package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class RechargeUI$15
  implements View.OnClickListener
{
  RechargeUI$15(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = c.bWg();
    Object localObject = RechargeUI.h(this.nrE).npy;
    y.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + (String)localObject);
    if ((!bk.bl((String)localObject)) && (paramView.qzO.containsKey(localObject)))
    {
      localObject = (MallNews)paramView.qzO.get(localObject);
      if ("1".equals(((MallNews)localObject).qzD))
      {
        ((MallNews)localObject).qzD = "2";
        paramView.bsi();
      }
    }
    RechargeUI.i(this.nrE).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.15
 * JD-Core Version:    0.7.0.1
 */