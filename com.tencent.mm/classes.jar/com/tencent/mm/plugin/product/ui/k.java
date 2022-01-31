package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class k
  extends BaseAdapter
{
  private Context mContext;
  List<n> mUF;
  AdapterView.OnItemClickListener mUx;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n vR(int paramInt)
  {
    return (n)this.mUF.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.mUF != null) {
      return this.mUF.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    n localn = vR(paramInt);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new k.a(this);
      localView = View.inflate(this.mContext, a.g.product_sold_out_item, null);
      paramView.mUy = ((TextView)localView.findViewById(a.f.mall_product_sold_out_item_title));
      paramView.mUz = ((MaxGridView)localView.findViewById(a.f.mall_product_sold_out_item_gv));
      paramView.mUG = new l(this.mContext);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.mUy.setText(localn.name);
      paramViewGroup.mUz.setOnItemClickListener(this.mUx);
      paramViewGroup.mUG.mUI = localn.mSB;
      paramViewGroup.mUG.notifyDataSetChanged();
      paramViewGroup.mUz.setAdapter(paramViewGroup.mUG);
      return localView;
      paramViewGroup = (k.a)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.k
 * JD-Core Version:    0.7.0.1
 */