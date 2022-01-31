package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.order.c.b;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

final class MallOrderProductListUI$a
  extends BaseAdapter
{
  private MallOrderProductListUI$a(MallOrderProductListUI paramMallOrderProductListUI) {}
  
  private ProductSectionItem Bh(int paramInt)
  {
    AppMethodBeat.i(43837);
    ProductSectionItem localProductSectionItem = (ProductSectionItem)MallOrderProductListUI.a(this.pqV).get(paramInt);
    AppMethodBeat.o(43837);
    return localProductSectionItem;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(43836);
    int i = MallOrderProductListUI.a(this.pqV).size();
    AppMethodBeat.o(43836);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43838);
    ProductSectionItem localProductSectionItem;
    if (paramView == null)
    {
      paramView = View.inflate(this.pqV, 2130970109, null);
      paramViewGroup = new MallOrderProductListUI.b(this.pqV, (byte)0);
      paramViewGroup.kxr = ((ImageView)paramView.findViewById(2131826014));
      paramViewGroup.pqW = ((TextView)paramView.findViewById(2131826015));
      paramViewGroup.pqX = ((TextView)paramView.findViewById(2131826022));
      paramViewGroup.pqY = ((TextView)paramView.findViewById(2131826023));
      paramViewGroup.pqZ = ((TextView)paramView.findViewById(2131826024));
      paramViewGroup.pra = ((TextView)paramView.findViewById(2131826021));
      paramView.setTag(paramViewGroup);
      localProductSectionItem = Bh(paramInt);
      paramViewGroup.kmm = localProductSectionItem.iconUrl;
      if ((TextUtils.isEmpty(paramViewGroup.kmm)) || (!e.awb(paramViewGroup.kmm))) {
        break label275;
      }
      Bitmap localBitmap = x.a(new b(paramViewGroup.kmm));
      paramViewGroup.kxr.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      paramViewGroup.pqW.setText(localProductSectionItem.name);
      paramViewGroup.pqX.setText(ProductSectionItem.Skus.cr(localProductSectionItem.pqB));
      paramViewGroup.pqY.setText(localProductSectionItem.pqC);
      paramViewGroup.pqZ.setText("+" + localProductSectionItem.count);
      x.a(paramViewGroup);
      paramViewGroup.pra.setVisibility(8);
      AppMethodBeat.o(43838);
      return paramView;
      paramViewGroup = (MallOrderProductListUI.b)paramView.getTag();
      break;
      label275:
      paramViewGroup.kxr.setImageResource(2131231622);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI.a
 * JD-Core Version:    0.7.0.1
 */