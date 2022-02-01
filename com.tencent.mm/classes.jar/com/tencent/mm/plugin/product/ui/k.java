package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.model.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class k
  extends BaseAdapter
{
  AdapterView.OnItemClickListener MTb;
  List<m> MTi;
  private Context mContext;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private m afC(int paramInt)
  {
    AppMethodBeat.i(67037);
    m localm = (m)this.MTi.get(paramInt);
    AppMethodBeat.o(67037);
    return localm;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67036);
    if (this.MTi != null)
    {
      int i = this.MTi.size();
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
    m localm = afC(paramInt);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new a();
      localView = View.inflate(this.mContext, a.g.product_sold_out_item, null);
      paramView.MTc = ((TextView)localView.findViewById(a.f.mall_product_sold_out_item_title));
      paramView.MTd = ((MaxGridView)localView.findViewById(a.f.mall_product_sold_out_item_gv));
      paramView.MTj = new l(this.mContext);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.MTc.setText(localm.name);
      paramViewGroup.MTd.setOnItemClickListener(this.MTb);
      paramViewGroup.MTj.MTl = localm.Mcs;
      paramViewGroup.MTj.notifyDataSetChanged();
      paramViewGroup.MTd.setAdapter(paramViewGroup.MTj);
      AppMethodBeat.o(67038);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  final class a
  {
    public TextView MTc = null;
    public MaxGridView MTd = null;
    public l MTj = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.k
 * JD-Core Version:    0.7.0.1
 */