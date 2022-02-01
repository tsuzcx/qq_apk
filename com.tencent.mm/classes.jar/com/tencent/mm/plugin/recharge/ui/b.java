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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<q> BDV;
  a BDW;
  private List<String> BDX;
  
  public b()
  {
    AppMethodBeat.i(67157);
    this.BDV = null;
    this.BDW = null;
    this.BDX = new ArrayList(Util.stringToList((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ohp, ""), ","));
    AppMethodBeat.o(67157);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67158);
    if (this.BDV == null)
    {
      AppMethodBeat.o(67158);
      return 0;
    }
    int i = this.BDV.size();
    AppMethodBeat.o(67158);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67159);
    Object localObject = this.BDV.get(paramInt);
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
      paramView = aa.jQ(paramViewGroup.getContext()).inflate(2131496053, paramViewGroup, false);
      localb = new b((byte)0);
      localb.hPW = ((TextView)paramView.findViewById(2131299495));
      localb.gxs = ((TextView)paramView.findViewById(2131305208));
      localb.BEb = ((TextView)paramView.findViewById(2131306151));
      localb.BEc = ((ImageView)paramView.findViewById(2131306670));
      paramView.setTag(localb);
      localb.gxs.setText(localq.name);
      if (Util.isNullOrNil(localq.desc)) {
        break label649;
      }
      localb.hPW.setVisibility(0);
      localb.hPW.setText(localq.desc);
      label153:
      if (Util.isNullOrNil(localq.HES)) {
        break label662;
      }
      localb.BEb.setVisibility(0);
      localb.BEb.setText(localq.HES);
      label186:
      if (localq.status != 1) {
        break label675;
      }
      paramView.setEnabled(true);
      localb.hPW.setEnabled(true);
      localb.gxs.setEnabled(true);
      label218:
      if ((localq.HEW != 1) || (this.BDX.contains(localq.HEX))) {
        break label701;
      }
      Log.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localq.HEX });
      localb.BEc.setVisibility(0);
    }
    for (;;)
    {
      if ((localq.type == 1) && (localq.HET.equals("1")) && (!localq.HEU.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cI(localq.HEU, false);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        GradientDrawable localGradientDrawable1 = new GradientDrawable();
        localGradientDrawable1.setShape(0);
        localGradientDrawable1.setCornerRadius(com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 2));
        localGradientDrawable1.setStroke(2, com.tencent.mm.cb.a.n((Context)localObject1, 2131099660));
        GradientDrawable localGradientDrawable2 = new GradientDrawable();
        localGradientDrawable2.setShape(0);
        localGradientDrawable2.setCornerRadius(com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 2));
        localGradientDrawable2.setColor(com.tencent.mm.cb.a.n((Context)localObject1, 2131100984));
        localGradientDrawable2.setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, localGradientDrawable1);
        ((StateListDrawable)localObject1).addState(new int[0], localGradientDrawable2);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cI(localq.HEU, false);
        localObject2 = new int[0];
        int i = com.tencent.mm.cb.a.n(paramViewGroup, 2131101424);
        int j = com.tencent.mm.cb.a.n(paramViewGroup, 2131100982);
        paramViewGroup = new ColorStateList(new int[][] { { 16842919 }, { -16842910 }, localObject2 }, new int[] { i, j, paramInt });
        localb.hPW.setTextColor(paramViewGroup);
        localb.gxs.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67156);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.a(b.this) != null)
          {
            if (!b.b(b.this).contains(localq.HEX))
            {
              Log.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { localq.HEX });
              if (localq.HEX != null)
              {
                b.b(b.this).add(localq.HEX);
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohp, Util.listToString(b.b(b.this), ","));
                localb.BEc.setVisibility(8);
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
      label649:
      localb.hPW.setVisibility(8);
      break label153;
      label662:
      localb.BEb.setVisibility(8);
      break label186;
      label675:
      paramView.setEnabled(false);
      localb.hPW.setEnabled(false);
      localb.gxs.setEnabled(false);
      break label218;
      label701:
      localb.BEc.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
  }
  
  final class b
  {
    TextView BEb;
    ImageView BEc;
    TextView gxs;
    TextView hPW;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */