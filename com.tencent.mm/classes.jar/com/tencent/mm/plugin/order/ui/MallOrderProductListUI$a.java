package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.order.c.b;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

final class MallOrderProductListUI$a
  extends BaseAdapter
{
  private MallOrderProductListUI$a(MallOrderProductListUI paramMallOrderProductListUI) {}
  
  private ProductSectionItem vJ(int paramInt)
  {
    return (ProductSectionItem)MallOrderProductListUI.a(this.mQI).get(paramInt);
  }
  
  public final int getCount()
  {
    return MallOrderProductListUI.a(this.mQI).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ProductSectionItem localProductSectionItem;
    if (paramView == null)
    {
      paramView = View.inflate(this.mQI, a.g.mall_order_product_list_item, null);
      paramViewGroup = new MallOrderProductListUI.b(this.mQI, (byte)0);
      paramViewGroup.iwn = ((ImageView)paramView.findViewById(a.f.item_product_logo_img));
      paramViewGroup.mQJ = ((TextView)paramView.findViewById(a.f.item_product_descript_tv));
      paramViewGroup.mQK = ((TextView)paramView.findViewById(a.f.item_product_catalog_tv));
      paramViewGroup.mQL = ((TextView)paramView.findViewById(a.f.item_product_price_tv));
      paramViewGroup.mQM = ((TextView)paramView.findViewById(a.f.item_product_count_tv));
      paramViewGroup.mQN = ((TextView)paramView.findViewById(a.f.item_product_seperator_tv));
      paramView.setTag(paramViewGroup);
      localProductSectionItem = vJ(paramInt);
      paramViewGroup.ilp = localProductSectionItem.iconUrl;
      if ((TextUtils.isEmpty(paramViewGroup.ilp)) || (!e.afi(paramViewGroup.ilp))) {
        break label272;
      }
      Bitmap localBitmap = x.a(new b(paramViewGroup.ilp));
      paramViewGroup.iwn.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      paramViewGroup.mQJ.setText(localProductSectionItem.name);
      paramViewGroup.mQK.setText(ProductSectionItem.Skus.bT(localProductSectionItem.mQm));
      paramViewGroup.mQL.setText(localProductSectionItem.mQn);
      paramViewGroup.mQM.setText("+" + localProductSectionItem.count);
      x.a(paramViewGroup);
      paramViewGroup.mQN.setVisibility(8);
      return paramView;
      paramViewGroup = (MallOrderProductListUI.b)paramView.getTag();
      break;
      label272:
      paramViewGroup.iwn.setImageResource(a.h.mall_order_detail_frame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI.a
 * JD-Core Version:    0.7.0.1
 */