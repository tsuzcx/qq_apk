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
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<q> wgr;
  a wgs;
  private List<String> wgt;
  
  public b()
  {
    AppMethodBeat.i(67157);
    this.wgr = null;
    this.wgs = null;
    this.wgt = new ArrayList(bs.lp((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRO, ""), ","));
    AppMethodBeat.o(67157);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67158);
    if (this.wgr == null)
    {
      AppMethodBeat.o(67158);
      return 0;
    }
    int i = this.wgr.size();
    AppMethodBeat.o(67158);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67159);
    Object localObject = this.wgr.get(paramInt);
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
      paramView = z.jD(paramViewGroup.getContext()).inflate(2131495210, paramViewGroup, false);
      localb = new b((byte)0);
      localb.gAI = ((TextView)paramView.findViewById(2131298996));
      localb.fwQ = ((TextView)paramView.findViewById(2131302654));
      localb.wgx = ((TextView)paramView.findViewById(2131303421));
      localb.wgy = ((ImageView)paramView.findViewById(2131303861));
      paramView.setTag(localb);
      localb.fwQ.setText(localq.name);
      if (bs.isNullOrNil(localq.desc)) {
        break label657;
      }
      localb.gAI.setVisibility(0);
      localb.gAI.setText(localq.desc);
      label153:
      if (bs.isNullOrNil(localq.Bhk)) {
        break label670;
      }
      localb.wgx.setVisibility(0);
      localb.wgx.setText(localq.Bhk);
      label186:
      if (localq.status != 1) {
        break label683;
      }
      paramView.setEnabled(true);
      localb.gAI.setEnabled(true);
      localb.fwQ.setEnabled(true);
      label218:
      if ((localq.Bho != 1) || (this.wgt.contains(localq.Bhp))) {
        break label709;
      }
      ac.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localq.Bhp });
      localb.wgy.setVisibility(0);
    }
    for (;;)
    {
      if ((localq.type == 1) && (localq.Bhl.equals("1")) && (!localq.Bhm.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cd(localq.Bhm, false);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        Object localObject3 = new GradientDrawable();
        ((GradientDrawable)localObject3).setShape(0);
        ((GradientDrawable)localObject3).setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject3).setStroke(2, a.n((Context)localObject1, 2131099658));
        Object localObject4 = new GradientDrawable();
        ((GradientDrawable)localObject4).setShape(0);
        ((GradientDrawable)localObject4).setCornerRadius(a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject4).setColor(a.n((Context)localObject1, 2131100788));
        ((GradientDrawable)localObject4).setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, (Drawable)localObject3);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject4);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cd(localq.Bhm, false);
        localObject2 = new int[] { 16842919 };
        localObject3 = new int[] { -16842910 };
        localObject4 = new int[0];
        int i = a.n(paramViewGroup, 2131101179);
        int j = a.n(paramViewGroup, 2131100786);
        paramViewGroup = new ColorStateList(new int[][] { localObject2, localObject3, localObject4 }, new int[] { i, j, paramInt });
        localb.gAI.setTextColor(paramViewGroup);
        localb.fwQ.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67156);
          if (b.a(b.this) != null)
          {
            if (!b.b(b.this).contains(localq.Bhp))
            {
              ac.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { localq.Bhp });
              if (localq.Bhp != null)
              {
                b.b(b.this).add(localq.Bhp);
                com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRO, bs.n(b.b(b.this), ","));
                localb.wgy.setVisibility(8);
              }
            }
            b.a(b.this).a(localq);
          }
          AppMethodBeat.o(67156);
        }
      });
      AppMethodBeat.o(67160);
      return paramView;
      localb = (b)paramView.getTag();
      break;
      label657:
      localb.gAI.setVisibility(8);
      break label153;
      label670:
      localb.wgx.setVisibility(8);
      break label186;
      label683:
      paramView.setEnabled(false);
      localb.gAI.setEnabled(false);
      localb.fwQ.setEnabled(false);
      break label218;
      label709:
      localb.wgy.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
  }
  
  final class b
  {
    TextView fwQ;
    TextView gAI;
    TextView wgx;
    ImageView wgy;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */