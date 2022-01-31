package com.tencent.mm.plugin.order.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

final class MallOrderDetailInfoUI$1
  implements View.OnClickListener
{
  MallOrderDetailInfoUI$1(MallOrderDetailInfoUI paramMallOrderDetailInfoUI) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.f.order_latest_status_info_layout) {
      if (this.mQG.mPG.mOx != null)
      {
        c.aD(this.mQG, this.mQG.mPG.mOx.kRP);
        MallOrderDetailInfoUI.a(this.mQG, this.mQG.mPG.mOx.mOF);
      }
    }
    do
    {
      return;
      if ((paramView.getId() != a.f.order_product_item_text_x4) && (paramView.getId() != a.f.order_product_item_text_x1)) {
        break;
      }
    } while ((this.mQG.mPG.mOy == null) || (this.mQG.mPG.mOy.size() <= 0));
    if (!TextUtils.isEmpty(((ProductSectionItem)this.mQG.mPG.mOy.get(0)).jumpUrl)) {}
    for (boolean bool = c.aD(this.mQG, ((ProductSectionItem)this.mQG.mPG.mOy.get(0)).jumpUrl);; bool = false)
    {
      if (!bool) {
        c.aE(this.mQG, ((ProductSectionItem)this.mQG.mPG.mOy.get(0)).mQo);
      }
      MallOrderDetailInfoUI.a(this.mQG, ((ProductSectionItem)this.mQG.mPG.mOy.get(0)).name);
      return;
      if (paramView.getId() == a.f.order_product_item_icon_text_x4)
      {
        paramView = this.mQG.BX;
        paramView.putParcelableArrayList("order_product_list", this.mQG.mPG.mOy);
        paramView.putInt("key_enter_id", 0);
        paramView.putString("key_trans_id", MallOrderDetailInfoUI.a(this.mQG));
        paramView.putString("appname", this.mQG.mPG.bNZ);
        a.j(this.mQG, new Bundle());
        MallOrderDetailInfoUI.a(this.mQG, this.mQG.getResources().getString(a.i.mall_order_products_list_ui_title));
        return;
      }
      if (paramView.getId() == a.f.order_transaction_info_parent_layout)
      {
        paramView = this.mQG.BX.getString("key_trans_id");
        Bundle localBundle = this.mQG.BX;
        localBundle.putString("key_trans_id", paramView);
        localBundle.putInt("key_enter_id", 1);
        if (this.mQG.mPG != null) {
          localBundle.putParcelable("transaction_data", this.mQG.mPG.mOw);
        }
        a.j(this.mQG, localBundle);
        MallOrderDetailInfoUI.a(this.mQG, this.mQG.getResources().getString(a.i.mall_order_merchant_info_text));
        return;
      }
      if (paramView.getId() == a.f.order_confirm_result_btn)
      {
        MallOrderDetailInfoUI.b(this.mQG);
        return;
      }
      if (paramView.getId() == a.f.hot_contact_phone_title_tv)
      {
        if ((this.mQG.mPG == null) || (this.mQG.mPG.mOD == null)) {
          break;
        }
        this.mQG.mQr = this.mQG.mPG.mOD;
        MallOrderDetailInfoUI.c(this.mQG);
        MallOrderDetailInfoUI.a(this.mQG, this.mQG.getResources().getString(a.i.mall_order_hot_phone_text));
        return;
      }
      if (paramView.getId() != a.f.wx_contact_service_title_tv) {
        break;
      }
      e.ab(this.mQG, this.mQG.mPG.bNZ);
      MallOrderDetailInfoUI.a(this.mQG, this.mQG.getResources().getString(a.i.mall_order_wx_service_text));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.1
 * JD-Core Version:    0.7.0.1
 */