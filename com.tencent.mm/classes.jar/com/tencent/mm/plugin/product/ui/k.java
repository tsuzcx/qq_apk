package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class k
  extends BaseAdapter
{
  List<n> GVG;
  AdapterView.OnItemClickListener GVz;
  private Context mContext;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n abj(int paramInt)
  {
    AppMethodBeat.i(67037);
    n localn = (n)this.GVG.get(paramInt);
    AppMethodBeat.o(67037);
    return localn;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67036);
    if (this.GVG != null)
    {
      int i = this.GVG.size();
      AppMethodBeat.o(67036);
      return i;
    }
    AppMethodBeat.o(67036);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67038);
    n localn = abj(paramInt);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new a();
      localView = View.inflate(this.mContext, a.g.product_sold_out_item, null);
      paramView.GVA = ((TextView)localView.findViewById(a.f.mall_product_sold_out_item_title));
      paramView.GVB = ((MaxGridView)localView.findViewById(a.f.mall_product_sold_out_item_gv));
      paramView.GVH = new l(this.mContext);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.GVA.setText(localn.name);
      paramViewGroup.GVB.setOnItemClickListener(this.GVz);
      paramViewGroup.GVH.GVJ = localn.GTF;
      paramViewGroup.GVH.notifyDataSetChanged();
      paramViewGroup.GVB.setAdapter(paramViewGroup.GVH);
      AppMethodBeat.o(67038);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  final class a
  {
    public TextView GVA = null;
    public MaxGridView GVB = null;
    public l GVH = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.k
 * JD-Core Version:    0.7.0.1
 */