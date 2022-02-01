package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.product.model.m.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class l
  extends BaseAdapter
{
  List<m.a> MTl;
  private Context mContext;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private m.a afD(int paramInt)
  {
    AppMethodBeat.i(67041);
    m.a locala = (m.a)this.MTl.get(paramInt);
    AppMethodBeat.o(67041);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67040);
    if (this.MTl != null)
    {
      int i = this.MTl.size();
      AppMethodBeat.o(67040);
      return i;
    }
    AppMethodBeat.o(67040);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67042);
    Object localObject = afD(paramInt);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new m();
      paramView = View.inflate(this.mContext, a.g.product_sold_out_cell, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.mall_product_sold_out_cell_price_iv));
      paramViewGroup.lPb = ((ImageView)paramView.findViewById(a.f.mall_product_sold_out_cell_img_iv));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.MTm = ((m.a)localObject);
      paramViewGroup.titleTv.setText(((m.a)localObject).title);
      localObject = r.a(new c(((m.a)localObject).iconUrl));
      paramViewGroup.lPb.setImageBitmap((Bitmap)localObject);
      r.a(paramViewGroup);
      AppMethodBeat.o(67042);
      return paramView;
      paramViewGroup = (m)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.l
 * JD-Core Version:    0.7.0.1
 */