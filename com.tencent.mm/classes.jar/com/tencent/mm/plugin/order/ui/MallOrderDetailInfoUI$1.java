package com.tencent.mm.plugin.order.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

final class MallOrderDetailInfoUI$1
  implements View.OnClickListener
{
  MallOrderDetailInfoUI$1(MallOrderDetailInfoUI paramMallOrderDetailInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43798);
    if (paramView.getId() == 2131825982)
    {
      if (this.pqU.ppW.poN != null)
      {
        c.aM(this.pqU, this.pqU.ppW.poN.npR);
        MallOrderDetailInfoUI.a(this.pqU, this.pqU.ppW.poN.poV);
        AppMethodBeat.o(43798);
      }
    }
    else if ((paramView.getId() == 2131825984) || (paramView.getId() == 2131825986))
    {
      if ((this.pqU.ppW.poO == null) || (this.pqU.ppW.poO.size() <= 0)) {
        break label598;
      }
      if (TextUtils.isEmpty(((ProductSectionItem)this.pqU.ppW.poO.get(0)).jumpUrl)) {
        break label604;
      }
    }
    label598:
    label604:
    for (boolean bool = c.aM(this.pqU, ((ProductSectionItem)this.pqU.ppW.poO.get(0)).jumpUrl);; bool = false)
    {
      if (!bool) {
        c.aN(this.pqU, ((ProductSectionItem)this.pqU.ppW.poO.get(0)).pqD);
      }
      MallOrderDetailInfoUI.a(this.pqU, ((ProductSectionItem)this.pqU.ppW.poO.get(0)).name);
      AppMethodBeat.o(43798);
      return;
      if (paramView.getId() == 2131825985)
      {
        paramView = this.pqU.getInput();
        paramView.putParcelableArrayList("order_product_list", this.pqU.ppW.poO);
        paramView.putInt("key_enter_id", 0);
        paramView.putString("key_trans_id", MallOrderDetailInfoUI.a(this.pqU));
        paramView.putString("appname", this.pqU.ppW.cvr);
        a.j(this.pqU, new Bundle());
        MallOrderDetailInfoUI.a(this.pqU, this.pqU.getResources().getString(2131301464));
        AppMethodBeat.o(43798);
        return;
      }
      if (paramView.getId() == 2131825987)
      {
        paramView = this.pqU.getInput().getString("key_trans_id");
        Bundle localBundle = this.pqU.getInput();
        localBundle.putString("key_trans_id", paramView);
        localBundle.putInt("key_enter_id", 1);
        if (this.pqU.ppW != null) {
          localBundle.putParcelable("transaction_data", this.pqU.ppW.poM);
        }
        a.j(this.pqU, localBundle);
        MallOrderDetailInfoUI.a(this.pqU, this.pqU.getResources().getString(2131301461));
        AppMethodBeat.o(43798);
        return;
      }
      if (paramView.getId() == 2131826001)
      {
        MallOrderDetailInfoUI.b(this.pqU);
        AppMethodBeat.o(43798);
        return;
      }
      if (paramView.getId() == 2131825992)
      {
        if ((this.pqU.ppW != null) && (this.pqU.ppW.poT != null))
        {
          this.pqU.pqF = this.pqU.ppW.poT;
          MallOrderDetailInfoUI.c(this.pqU);
          MallOrderDetailInfoUI.a(this.pqU, this.pqU.getResources().getString(2131301459));
          AppMethodBeat.o(43798);
        }
      }
      else if (paramView.getId() == 2131825994)
      {
        e.ae(this.pqU, this.pqU.ppW.cvr);
        MallOrderDetailInfoUI.a(this.pqU, this.pqU.getResources().getString(2131301470));
      }
      AppMethodBeat.o(43798);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.1
 * JD-Core Version:    0.7.0.1
 */