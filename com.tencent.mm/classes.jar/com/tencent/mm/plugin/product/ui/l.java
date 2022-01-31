package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class l
  extends BaseAdapter
{
  private Context mContext;
  List<n.a> mUI;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n.a vS(int paramInt)
  {
    return (n.a)this.mUI.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.mUI != null) {
      return this.mUI.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = vS(paramInt);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new m();
      paramView = View.inflate(this.mContext, a.g.product_sold_out_cell, null);
      paramViewGroup.eXr = ((TextView)paramView.findViewById(a.f.mall_product_sold_out_cell_price_iv));
      paramViewGroup.heN = ((ImageView)paramView.findViewById(a.f.mall_product_sold_out_cell_img_iv));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.mUJ = ((n.a)localObject);
      paramViewGroup.eXr.setText(((n.a)localObject).title);
      localObject = x.a(new c(((n.a)localObject).iconUrl));
      paramViewGroup.heN.setImageBitmap((Bitmap)localObject);
      x.a(paramViewGroup);
      return paramView;
      paramViewGroup = (m)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.l
 * JD-Core Version:    0.7.0.1
 */