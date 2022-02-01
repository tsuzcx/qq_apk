package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  extends BaseAdapter
{
  private c GUN;
  LinkedList<m> GVy;
  AdapterView.OnItemClickListener GVz;
  private Context mContext;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(67026);
    this.mContext = paramContext;
    com.tencent.mm.plugin.product.a.a.foU();
    this.GUN = com.tencent.mm.plugin.product.a.a.foV();
    AppMethodBeat.o(67026);
  }
  
  private m abh(int paramInt)
  {
    AppMethodBeat.i(67028);
    m localm = (m)this.GVy.get(paramInt);
    AppMethodBeat.o(67028);
    return localm;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67027);
    if (this.GVy != null)
    {
      int i = this.GVy.size();
      AppMethodBeat.o(67027);
      return i;
    }
    AppMethodBeat.o(67027);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67029);
    m localm = abh(paramInt);
    Object localObject2;
    Object localObject1;
    label166:
    int i;
    float f1;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.mContext, a.g.product_select_sku_item, null);
      paramViewGroup.GVA = ((TextView)paramView.findViewById(a.f.mall_product_sku_title_tv));
      paramViewGroup.GVB = ((MaxGridView)paramView.findViewById(a.f.mall_product_sku_gv));
      paramViewGroup.GVC = new j(this.mContext);
      paramView.setTag(paramViewGroup);
      paramViewGroup.GVA.setText(localm.GUd);
      paramViewGroup.GVB.setOnItemClickListener(this.GVz);
      localObject2 = paramViewGroup.GVC;
      localObject1 = this.GUN;
      Object localObject3 = localm.GUc;
      if (!((c)localObject1).GTh.containsKey(localObject3)) {
        break label307;
      }
      localObject1 = (String)((c)localObject1).GTh.get(localObject3);
      ((j)localObject2).GVE = localm;
      ((j)localObject2).GVF = ((String)localObject1);
      localObject1 = this.mContext;
      localObject3 = localm.GUe;
      i = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - com.tencent.mm.ci.a.fromDPToPix((Context)localObject1, 16) * 2;
      localObject2 = ((TextView)((LayoutInflater)((Context)localObject1).getSystemService("layout_inflater")).inflate(a.g.product_select_sku_cell, null)).getPaint();
      f1 = 0.0F;
      localObject3 = ((LinkedList)localObject3).iterator();
      label251:
      if (!((Iterator)localObject3).hasNext()) {
        break label313;
      }
      float f2 = ((TextPaint)localObject2).measureText(((h)((Iterator)localObject3).next()).name);
      if (f1 >= f2) {
        break label519;
      }
      f1 = f2;
    }
    label519:
    for (;;)
    {
      break label251;
      paramViewGroup = (a)paramView.getTag();
      break;
      label307:
      localObject1 = null;
      break label166;
      label313:
      int j = (int)f1;
      int k = com.tencent.mm.ci.a.fromDPToPix((Context)localObject1, 10);
      localObject2 = new int[4];
      int m = com.tencent.mm.ci.a.fromDPToPix((Context)localObject1, 12);
      paramInt = 0;
      while (paramInt < 4)
      {
        localObject2[paramInt] = ((i - m * paramInt) / (paramInt + 1));
        paramInt += 1;
      }
      paramInt = 4;
      if (paramInt > 0) {
        if (j + k * 2 >= localObject2[(paramInt - 1)]) {}
      }
      for (localObject1 = new Pair(Integer.valueOf(paramInt), Integer.valueOf(localObject2[(paramInt - 1)]));; localObject1 = new Pair(Integer.valueOf(1), Integer.valueOf(i)))
      {
        Log.d("MicroMsg.MallProductImageAdapter", localm.GUd + " numColumns = " + localObject1);
        paramViewGroup.GVB.setColumnWidth(((Integer)((Pair)localObject1).second).intValue());
        paramViewGroup.GVC.notifyDataSetChanged();
        paramViewGroup.GVB.setAdapter(paramViewGroup.GVC);
        AppMethodBeat.o(67029);
        return paramView;
        paramInt -= 1;
        break;
      }
    }
  }
  
  final class a
  {
    public TextView GVA = null;
    public MaxGridView GVB = null;
    public j GVC = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.i
 * JD-Core Version:    0.7.0.1
 */