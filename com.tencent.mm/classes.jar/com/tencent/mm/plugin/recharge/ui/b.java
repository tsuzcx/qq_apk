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
import com.tencent.mm.plugin.wallet.model.o;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<o> NxC;
  a NxD;
  private List<String> NxE;
  
  public b()
  {
    AppMethodBeat.i(67157);
    this.NxC = null;
    this.NxD = null;
    this.NxE = new ArrayList(Util.stringToList((String)h.baE().ban().get(at.a.acXo, ""), ","));
    AppMethodBeat.o(67157);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67158);
    if (this.NxC == null)
    {
      AppMethodBeat.o(67158);
      return 0;
    }
    int i = this.NxC.size();
    AppMethodBeat.o(67158);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67159);
    Object localObject = this.NxC.get(paramInt);
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
    final o localo = (o)getItem(paramInt);
    final b localb;
    if (paramView == null)
    {
      paramView = af.mU(paramViewGroup.getContext()).inflate(a.g.recharge_product_item, paramViewGroup, false);
      localb = new b((byte)0);
      localb.descTv = ((TextView)paramView.findViewById(a.f.desc));
      localb.lDF = ((TextView)paramView.findViewById(a.f.name));
      localb.NxI = ((TextView)paramView.findViewById(a.f.product_attr));
      localb.NxJ = ((ImageView)paramView.findViewById(a.f.recommend_iv));
      paramView.setTag(localb);
      localb.lDF.setText(localo.name);
      if (Util.isNullOrNil(localo.desc)) {
        break label663;
      }
      localb.descTv.setVisibility(0);
      localb.descTv.setText(localo.desc);
      label158:
      if (Util.isNullOrNil(localo.VlW)) {
        break label676;
      }
      localb.NxI.setVisibility(0);
      localb.NxI.setText(localo.VlW);
      label191:
      if (localo.status != 1) {
        break label689;
      }
      paramView.setEnabled(true);
      localb.descTv.setEnabled(true);
      localb.lDF.setEnabled(true);
      label223:
      if ((localo.Vma != 1) || (this.NxE.contains(localo.Vmb))) {
        break label715;
      }
      Log.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localo.Vmb });
      localb.NxJ.setVisibility(0);
    }
    for (;;)
    {
      if ((localo.type == 1) && (localo.VlX.equals("1")) && (!localo.VlY.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = n.dE(localo.VlY, false);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        Object localObject3 = new GradientDrawable();
        ((GradientDrawable)localObject3).setShape(0);
        ((GradientDrawable)localObject3).setCornerRadius(com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject3).setStroke(2, com.tencent.mm.cd.a.w((Context)localObject1, a.c.BW_0_Alpha_0_2));
        Object localObject4 = new GradientDrawable();
        ((GradientDrawable)localObject4).setShape(0);
        ((GradientDrawable)localObject4).setCornerRadius(com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject4).setColor(com.tencent.mm.cd.a.w((Context)localObject1, a.c.recharge_product_item_bg));
        ((GradientDrawable)localObject4).setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, (Drawable)localObject3);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject4);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = n.dE(localo.VlY, false);
        localObject2 = new int[] { 16842919 };
        localObject3 = new int[] { -16842910 };
        localObject4 = new int[0];
        int i = com.tencent.mm.cd.a.w(paramViewGroup, a.c.white);
        int j = com.tencent.mm.cd.a.w(paramViewGroup, a.c.recharge_item_text_color_disabled);
        paramViewGroup = new ColorStateList(new int[][] { localObject2, localObject3, localObject4 }, new int[] { i, j, paramInt });
        localb.descTv.setTextColor(paramViewGroup);
        localb.lDF.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67156);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.a(b.this) != null)
          {
            if (!b.b(b.this).contains(localo.Vmb))
            {
              Log.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { localo.Vmb });
              if (localo.Vmb != null)
              {
                b.b(b.this).add(localo.Vmb);
                h.baE().ban().set(at.a.acXo, Util.listToString(b.b(b.this), ","));
                localb.NxJ.setVisibility(8);
              }
            }
            b.a(b.this).a(localo);
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
      localb.descTv.setVisibility(8);
      break label158;
      label676:
      localb.NxI.setVisibility(8);
      break label191;
      label689:
      paramView.setEnabled(false);
      localb.descTv.setEnabled(false);
      localb.lDF.setEnabled(false);
      break label223;
      label715:
      localb.NxJ.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(o paramo);
  }
  
  final class b
  {
    TextView NxI;
    ImageView NxJ;
    TextView descTv;
    TextView lDF;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */