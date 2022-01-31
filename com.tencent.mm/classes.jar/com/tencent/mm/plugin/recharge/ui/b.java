package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<n> nqu = null;
  b.a nqv = null;
  private List<String> nqw = new ArrayList(bk.gg((String)g.DP().Dz().get(ac.a.uzQ, ""), ","));
  
  public final int getCount()
  {
    if (this.nqu == null) {
      return 0;
    }
    return this.nqu.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.nqu.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    n localn = (n)getItem(paramInt);
    b.b localb;
    if (paramView == null)
    {
      paramView = com.tencent.mm.ui.y.gt(paramViewGroup.getContext()).inflate(a.g.recharge_product_item, paramViewGroup, false);
      localb = new b.b(this, (byte)0);
      localb.gaI = ((TextView)paramView.findViewById(a.f.desc));
      localb.fdt = ((TextView)paramView.findViewById(a.f.name));
      localb.nqA = ((TextView)paramView.findViewById(a.f.product_attr));
      localb.nqB = ((ImageView)paramView.findViewById(a.f.recommend_iv));
      paramView.setTag(localb);
      localb.fdt.setText(localn.name);
      if (bk.bl(localn.desc)) {
        break label647;
      }
      localb.gaI.setVisibility(0);
      localb.gaI.setText(localn.desc);
      label153:
      if (bk.bl(localn.qlt)) {
        break label660;
      }
      localb.nqA.setVisibility(0);
      localb.nqA.setText(localn.qlt);
      label186:
      if (localn.status != 1) {
        break label673;
      }
      paramView.setEnabled(true);
      localb.gaI.setEnabled(true);
      localb.fdt.setEnabled(true);
    }
    for (;;)
    {
      if ((localn.qlx == 1) && (!this.nqw.contains(localn.qly)))
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localn.qly });
        localb.nqB.setVisibility(0);
      }
      if ((localn.type == 1) && (localn.qlu.equals("1")) && (!localn.qlv.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = Color.parseColor(localn.qlv);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        Object localObject3 = new GradientDrawable();
        ((GradientDrawable)localObject3).setShape(0);
        ((GradientDrawable)localObject3).setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject3).setStroke(2, a.i((Context)localObject1, a.c.recharge_product_item_bg_disable));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        localGradientDrawable.setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        localGradientDrawable.setColor(a.i((Context)localObject1, a.c.recharge_product_item_bg));
        localGradientDrawable.setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, (Drawable)localObject3);
        ((StateListDrawable)localObject1).addState(new int[0], localGradientDrawable);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = Color.parseColor(localn.qlv);
        localObject2 = new int[] { 16842919 };
        localObject3 = new int[] { -16842910 };
        int i = a.i(paramViewGroup, a.c.white);
        int j = a.i(paramViewGroup, a.c.recharge_item_text_color_disabled);
        paramViewGroup = new ColorStateList(new int[][] { localObject2, localObject3, new int[0] }, new int[] { i, j, paramInt });
        localb.gaI.setTextColor(paramViewGroup);
        localb.fdt.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new b.1(this, localn, localb));
      return paramView;
      localb = (b.b)paramView.getTag();
      break;
      label647:
      localb.gaI.setVisibility(8);
      break label153;
      label660:
      localb.nqA.setVisibility(8);
      break label186;
      label673:
      paramView.setEnabled(false);
      localb.gaI.setEnabled(false);
      localb.fdt.setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */