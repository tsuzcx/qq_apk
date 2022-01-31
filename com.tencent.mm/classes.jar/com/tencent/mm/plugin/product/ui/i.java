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
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  extends BaseAdapter
{
  private Context mContext;
  private c mTL;
  LinkedList<m> mUw;
  AdapterView.OnItemClickListener mUx;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
    com.tencent.mm.plugin.product.a.a.brN();
    this.mTL = com.tencent.mm.plugin.product.a.a.brO();
  }
  
  private m vP(int paramInt)
  {
    return (m)this.mUw.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.mUw != null) {
      return this.mUw.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    m localm = vP(paramInt);
    Object localObject2;
    Object localObject1;
    label161:
    int i;
    float f1;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new i.a(this);
      paramView = View.inflate(this.mContext, a.g.product_select_sku_item, null);
      paramViewGroup.mUy = ((TextView)paramView.findViewById(a.f.mall_product_sku_title_tv));
      paramViewGroup.mUz = ((MaxGridView)paramView.findViewById(a.f.mall_product_sku_gv));
      paramViewGroup.mUB = new j(this.mContext);
      paramView.setTag(paramViewGroup);
      paramViewGroup.mUy.setText(localm.mTa);
      paramViewGroup.mUz.setOnItemClickListener(this.mUx);
      localObject2 = paramViewGroup.mUB;
      localObject1 = this.mTL;
      Object localObject3 = localm.mSZ;
      if (!((c)localObject1).mSb.containsKey(localObject3)) {
        break label302;
      }
      localObject1 = (String)((c)localObject1).mSb.get(localObject3);
      ((j)localObject2).mUD = localm;
      ((j)localObject2).mUE = ((String)localObject1);
      localObject1 = this.mContext;
      localObject3 = localm.mTb;
      i = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 16) * 2;
      localObject2 = ((TextView)((LayoutInflater)((Context)localObject1).getSystemService("layout_inflater")).inflate(a.g.product_select_sku_cell, null)).getPaint();
      f1 = 0.0F;
      localObject3 = ((LinkedList)localObject3).iterator();
      label246:
      if (!((Iterator)localObject3).hasNext()) {
        break label308;
      }
      float f2 = ((TextPaint)localObject2).measureText(((h)((Iterator)localObject3).next()).name);
      if (f1 >= f2) {
        break label508;
      }
      f1 = f2;
    }
    label302:
    label308:
    label508:
    for (;;)
    {
      break label246;
      paramViewGroup = (i.a)paramView.getTag();
      break;
      localObject1 = null;
      break label161;
      int j = (int)f1;
      int k = com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 10);
      localObject2 = new int[4];
      int m = com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 12);
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
        y.d("MicroMsg.MallProductImageAdapter", localm.mTa + " numColumns = " + localObject1);
        paramViewGroup.mUz.setColumnWidth(((Integer)((Pair)localObject1).second).intValue());
        paramViewGroup.mUB.notifyDataSetChanged();
        paramViewGroup.mUz.setAdapter(paramViewGroup.mUB);
        return paramView;
        paramInt -= 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.i
 * JD-Core Version:    0.7.0.1
 */