package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  a HAa;
  private List<String> HAb;
  ArrayList<q> HzZ;
  
  public b()
  {
    AppMethodBeat.i(67157);
    this.HzZ = null;
    this.HAa = null;
    this.HAb = new ArrayList(Util.stringToList((String)h.aHG().aHp().get(ar.a.VvF, ""), ","));
    AppMethodBeat.o(67157);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67158);
    if (this.HzZ == null)
    {
      AppMethodBeat.o(67158);
      return 0;
    }
    int i = this.HzZ.size();
    AppMethodBeat.o(67158);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67159);
    Object localObject = this.HzZ.get(paramInt);
    AppMethodBeat.o(67159);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67160);
    final q localq = (q)getItem(paramInt);
    final b localb;
    if (paramView == null)
    {
      paramView = ad.kS(paramViewGroup.getContext()).inflate(a.g.recharge_product_item, paramViewGroup, false);
      localb = new b((byte)0);
      localb.kEs = ((TextView)paramView.findViewById(a.f.desc));
      localb.jbF = ((TextView)paramView.findViewById(a.f.name));
      localb.HAf = ((TextView)paramView.findViewById(a.f.product_attr));
      localb.HAg = ((ImageView)paramView.findViewById(a.f.recommend_iv));
      paramView.setTag(localb);
      localb.jbF.setText(localq.name);
      if (Util.isNullOrNil(localq.desc)) {
        break label663;
      }
      localb.kEs.setVisibility(0);
      localb.kEs.setText(localq.desc);
      label158:
      if (Util.isNullOrNil(localq.OwL)) {
        break label676;
      }
      localb.HAf.setVisibility(0);
      localb.HAf.setText(localq.OwL);
      label191:
      if (localq.status != 1) {
        break label689;
      }
      paramView.setEnabled(true);
      localb.kEs.setEnabled(true);
      localb.jbF.setEnabled(true);
      label223:
      if ((localq.OwP != 1) || (this.HAb.contains(localq.OwQ))) {
        break label715;
      }
      Log.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localq.OwQ });
      localb.HAg.setVisibility(0);
    }
    for (;;)
    {
      if ((localq.type == 1) && (localq.OwM.equals("1")) && (!localq.OwN.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = k.cW(localq.OwN, false);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.ci.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        Object localObject3 = new GradientDrawable();
        ((GradientDrawable)localObject3).setShape(0);
        ((GradientDrawable)localObject3).setCornerRadius(com.tencent.mm.ci.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject3).setStroke(2, com.tencent.mm.ci.a.w((Context)localObject1, a.c.BW_0_Alpha_0_2));
        Object localObject4 = new GradientDrawable();
        ((GradientDrawable)localObject4).setShape(0);
        ((GradientDrawable)localObject4).setCornerRadius(com.tencent.mm.ci.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject4).setColor(com.tencent.mm.ci.a.w((Context)localObject1, a.c.recharge_product_item_bg));
        ((GradientDrawable)localObject4).setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, (Drawable)localObject3);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject4);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = k.cW(localq.OwN, false);
        localObject2 = new int[] { 16842919 };
        localObject3 = new int[] { -16842910 };
        localObject4 = new int[0];
        int i = com.tencent.mm.ci.a.w(paramViewGroup, a.c.white);
        int j = com.tencent.mm.ci.a.w(paramViewGroup, a.c.recharge_item_text_color_disabled);
        paramViewGroup = new ColorStateList(new int[][] { localObject2, localObject3, localObject4 }, new int[] { i, j, paramInt });
        localb.kEs.setTextColor(paramViewGroup);
        localb.jbF.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67156);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.a(b.this) != null)
          {
            if (!b.b(b.this).contains(localq.OwQ))
            {
              Log.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { localq.OwQ });
              if (localq.OwQ != null)
              {
                b.b(b.this).add(localq.OwQ);
                h.aHG().aHp().set(ar.a.VvF, Util.listToString(b.b(b.this), ","));
                localb.HAg.setVisibility(8);
              }
            }
            b.a(b.this).a(localq);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67156);
        }
      });
      AppMethodBeat.o(67160);
      return paramView;
      localb = (b)paramView.getTag();
      break;
      label663:
      localb.kEs.setVisibility(8);
      break label158;
      label676:
      localb.HAf.setVisibility(8);
      break label191;
      label689:
      paramView.setEnabled(false);
      localb.kEs.setEnabled(false);
      localb.jbF.setEnabled(false);
      break label223;
      label715:
      localb.HAg.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
  }
  
  final class b
  {
    TextView HAf;
    ImageView HAg;
    TextView jbF;
    TextView kEs;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */