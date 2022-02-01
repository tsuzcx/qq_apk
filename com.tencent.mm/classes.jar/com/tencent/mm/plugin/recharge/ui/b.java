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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<q> xDW;
  a xDX;
  private List<String> xDY;
  
  public b()
  {
    AppMethodBeat.i(67157);
    this.xDW = null;
    this.xDX = null;
    this.xDY = new ArrayList(bu.lV((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYS, ""), ","));
    AppMethodBeat.o(67157);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67158);
    if (this.xDW == null)
    {
      AppMethodBeat.o(67158);
      return 0;
    }
    int i = this.xDW.size();
    AppMethodBeat.o(67158);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67159);
    Object localObject = this.xDW.get(paramInt);
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
      paramView = z.jV(paramViewGroup.getContext()).inflate(2131495210, paramViewGroup, false);
      localb = new b((byte)0);
      localb.gXb = ((TextView)paramView.findViewById(2131298996));
      localb.fSj = ((TextView)paramView.findViewById(2131302654));
      localb.xEc = ((TextView)paramView.findViewById(2131303421));
      localb.xEd = ((ImageView)paramView.findViewById(2131303861));
      paramView.setTag(localb);
      localb.fSj.setText(localq.name);
      if (bu.isNullOrNil(localq.desc)) {
        break label657;
      }
      localb.gXb.setVisibility(0);
      localb.gXb.setText(localq.desc);
      label153:
      if (bu.isNullOrNil(localq.CZe)) {
        break label670;
      }
      localb.xEc.setVisibility(0);
      localb.xEc.setText(localq.CZe);
      label186:
      if (localq.status != 1) {
        break label683;
      }
      paramView.setEnabled(true);
      localb.gXb.setEnabled(true);
      localb.fSj.setEnabled(true);
      label218:
      if ((localq.CZi != 1) || (this.xDY.contains(localq.CZj))) {
        break label709;
      }
      ae.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localq.CZj });
      localb.xEd.setVisibility(0);
    }
    for (;;)
    {
      if ((localq.type == 1) && (localq.CZf.equals("1")) && (!localq.CZg.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cp(localq.CZg, false);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        Object localObject3 = new GradientDrawable();
        ((GradientDrawable)localObject3).setShape(0);
        ((GradientDrawable)localObject3).setCornerRadius(com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject3).setStroke(2, com.tencent.mm.cb.a.n((Context)localObject1, 2131099658));
        Object localObject4 = new GradientDrawable();
        ((GradientDrawable)localObject4).setShape(0);
        ((GradientDrawable)localObject4).setCornerRadius(com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject4).setColor(com.tencent.mm.cb.a.n((Context)localObject1, 2131100788));
        ((GradientDrawable)localObject4).setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, (Drawable)localObject3);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject4);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cp(localq.CZg, false);
        localObject2 = new int[] { 16842919 };
        localObject3 = new int[] { -16842910 };
        localObject4 = new int[0];
        int i = com.tencent.mm.cb.a.n(paramViewGroup, 2131101179);
        int j = com.tencent.mm.cb.a.n(paramViewGroup, 2131100786);
        paramViewGroup = new ColorStateList(new int[][] { localObject2, localObject3, localObject4 }, new int[] { i, j, paramInt });
        localb.gXb.setTextColor(paramViewGroup);
        localb.fSj.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67156);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (b.a(b.this) != null)
          {
            if (!b.b(b.this).contains(localq.CZj))
            {
              ae.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { localq.CZj });
              if (localq.CZj != null)
              {
                b.b(b.this).add(localq.CZj);
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYS, bu.m(b.b(b.this), ","));
                localb.xEd.setVisibility(8);
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
      label657:
      localb.gXb.setVisibility(8);
      break label153;
      label670:
      localb.xEc.setVisibility(8);
      break label186;
      label683:
      paramView.setEnabled(false);
      localb.gXb.setEnabled(false);
      localb.fSj.setEnabled(false);
      break label218;
      label709:
      localb.xEd.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
  }
  
  final class b
  {
    TextView fSj;
    TextView gXb;
    TextView xEc;
    ImageView xEd;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */