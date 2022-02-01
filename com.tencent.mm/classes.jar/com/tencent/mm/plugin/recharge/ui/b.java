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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<q> xnZ;
  a xoa;
  private List<String> xob;
  
  public b()
  {
    AppMethodBeat.i(67157);
    this.xnZ = null;
    this.xoa = null;
    this.xob = new ArrayList(bt.lO((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEs, ""), ","));
    AppMethodBeat.o(67157);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67158);
    if (this.xnZ == null)
    {
      AppMethodBeat.o(67158);
      return 0;
    }
    int i = this.xnZ.size();
    AppMethodBeat.o(67158);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67159);
    Object localObject = this.xnZ.get(paramInt);
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
      paramView = z.jO(paramViewGroup.getContext()).inflate(2131495210, paramViewGroup, false);
      localb = new b((byte)0);
      localb.gUs = ((TextView)paramView.findViewById(2131298996));
      localb.fQd = ((TextView)paramView.findViewById(2131302654));
      localb.xof = ((TextView)paramView.findViewById(2131303421));
      localb.xog = ((ImageView)paramView.findViewById(2131303861));
      paramView.setTag(localb);
      localb.fQd.setText(localq.name);
      if (bt.isNullOrNil(localq.desc)) {
        break label649;
      }
      localb.gUs.setVisibility(0);
      localb.gUs.setText(localq.desc);
      label153:
      if (bt.isNullOrNil(localq.CHy)) {
        break label662;
      }
      localb.xof.setVisibility(0);
      localb.xof.setText(localq.CHy);
      label186:
      if (localq.status != 1) {
        break label675;
      }
      paramView.setEnabled(true);
      localb.gUs.setEnabled(true);
      localb.fQd.setEnabled(true);
      label218:
      if ((localq.CHC != 1) || (this.xob.contains(localq.CHD))) {
        break label701;
      }
      ad.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localq.CHD });
      localb.xog.setVisibility(0);
    }
    for (;;)
    {
      if ((localq.type == 1) && (localq.CHz.equals("1")) && (!localq.CHA.equals("0")))
      {
        Object localObject1 = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cl(localq.CHA, false);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.cc.a.fromDPToPix((Context)localObject1, 2));
        ((GradientDrawable)localObject2).setColor(paramInt);
        GradientDrawable localGradientDrawable1 = new GradientDrawable();
        localGradientDrawable1.setShape(0);
        localGradientDrawable1.setCornerRadius(com.tencent.mm.cc.a.fromDPToPix((Context)localObject1, 2));
        localGradientDrawable1.setStroke(2, com.tencent.mm.cc.a.n((Context)localObject1, 2131099658));
        GradientDrawable localGradientDrawable2 = new GradientDrawable();
        localGradientDrawable2.setShape(0);
        localGradientDrawable2.setCornerRadius(com.tencent.mm.cc.a.fromDPToPix((Context)localObject1, 2));
        localGradientDrawable2.setColor(com.tencent.mm.cc.a.n((Context)localObject1, 2131100788));
        localGradientDrawable2.setStroke(2, paramInt);
        localObject1 = new StateListDrawable();
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject1).addState(new int[] { -16842910 }, localGradientDrawable1);
        ((StateListDrawable)localObject1).addState(new int[0], localGradientDrawable2);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cl(localq.CHA, false);
        localObject2 = new int[] { 16842919 };
        int i = com.tencent.mm.cc.a.n(paramViewGroup, 2131101179);
        int j = com.tencent.mm.cc.a.n(paramViewGroup, 2131100786);
        paramViewGroup = new ColorStateList(new int[][] { localObject2, { -16842910 }, new int[0] }, new int[] { i, j, paramInt });
        localb.gUs.setTextColor(paramViewGroup);
        localb.fQd.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject1);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67156);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (b.a(b.this) != null)
          {
            if (!b.b(b.this).contains(localq.CHD))
            {
              ad.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { localq.CHD });
              if (localq.CHD != null)
              {
                b.b(b.this).add(localq.CHD);
                com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEs, bt.m(b.b(b.this), ","));
                localb.xog.setVisibility(8);
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
      localb.gUs.setVisibility(8);
      break label153;
      label662:
      localb.xof.setVisibility(8);
      break label186;
      label675:
      paramView.setEnabled(false);
      localb.gUs.setEnabled(false);
      localb.fQd.setEnabled(false);
      break label218;
      label701:
      localb.xog.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
  }
  
  final class b
  {
    TextView fQd;
    TextView gUs;
    TextView xof;
    ImageView xog;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */