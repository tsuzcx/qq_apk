package com.tencent.mm.plugin.wallet_core.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m.a;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

final class j$a
  extends BaseAdapter
{
  h qDA = null;
  m<String> qDB = new j.a.1(this);
  int qDy = -1;
  List<q> qDz = new LinkedList();
  
  public j$a(j paramj) {}
  
  public final int getCount()
  {
    return this.qDz.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.qDz.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3;
    label156:
    label187:
    Object localObject1;
    Object localObject2;
    int i;
    if (paramView == null)
    {
      paramView = j.c(this.qDx).inflate(a.g.wallet_coupon_item, paramViewGroup, false);
      paramViewGroup = new j.c();
      paramViewGroup.qDD = paramView.findViewById(a.f.wallet_coupon_section_title);
      paramViewGroup.haW = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_title));
      paramViewGroup.irN = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_subtitle));
      paramViewGroup.iIV = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_desc));
      paramViewGroup.qDF = ((CheckBox)paramView.findViewById(a.f.wallet_coupon_item_checkbox));
      paramViewGroup.qDE = ((ImageView)paramView.findViewById(a.f.wallet_coupon_divider));
      paramView.setTag(paramViewGroup);
      localObject3 = (q)getItem(paramInt);
      if ((paramInt != this.qDy) || (this.qDy <= 0)) {
        break label415;
      }
      paramViewGroup.qDD.setVisibility(0);
      paramViewGroup.qDE.setVisibility(8);
      if (bk.bl(((q)localObject3).qlN)) {
        break label435;
      }
      paramViewGroup.haW.setText(((q)localObject3).qlN);
      paramViewGroup.haW.setVisibility(0);
      localObject1 = ((q)localObject3).qkQ;
      if ((this.qDA == null) || (this.qDA.qlm == null)) {
        break label456;
      }
      localObject2 = this.qDA.qlm;
      i = 0;
      label223:
      if (i >= ((List)localObject2).size()) {
        break label456;
      }
      if (!((String)localObject1).equals(((e)((List)localObject2).get(i)).qkQ)) {
        break label447;
      }
      localObject1 = (e)((List)localObject2).get(i);
      label272:
      localObject2 = ((q)localObject3).qkR;
      localObject3 = ((q)localObject3).qkS;
      if (localObject1 == null) {
        break label522;
      }
      localObject3 = ((e)localObject1).qkR;
      localObject2 = ((e)localObject1).qkS;
      localObject1 = localObject3;
    }
    for (;;)
    {
      if (!bk.bl((String)localObject1))
      {
        paramViewGroup.irN.setText((CharSequence)localObject1);
        paramViewGroup.irN.setVisibility(0);
        label334:
        if (bk.bl((String)localObject2)) {
          break label474;
        }
        paramViewGroup.iIV.setText((CharSequence)localObject2);
        paramViewGroup.iIV.setVisibility(0);
      }
      for (;;)
      {
        localObject1 = ((m.b)this.qDB.qwa.get(paramInt)).qwi;
        if (localObject1 != m.a.qwd) {
          break label486;
        }
        paramViewGroup.qDF.setChecked(false);
        paramViewGroup.qDF.setEnabled(false);
        return paramView;
        paramViewGroup = (j.c)paramView.getTag();
        break;
        label415:
        paramViewGroup.qDD.setVisibility(8);
        paramViewGroup.qDE.setVisibility(0);
        break label156;
        label435:
        paramViewGroup.haW.setVisibility(8);
        break label187;
        label447:
        i += 1;
        break label223;
        label456:
        localObject1 = null;
        break label272;
        paramViewGroup.irN.setVisibility(8);
        break label334;
        label474:
        paramViewGroup.iIV.setVisibility(8);
      }
      label486:
      paramViewGroup.qDF.setEnabled(true);
      if (localObject1 == m.a.qwe)
      {
        paramViewGroup.qDF.setChecked(true);
        return paramView;
      }
      paramViewGroup.qDF.setChecked(false);
      return paramView;
      label522:
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j.a
 * JD-Core Version:    0.7.0.1
 */