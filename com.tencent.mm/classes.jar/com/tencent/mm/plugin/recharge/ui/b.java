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
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  ArrayList<q> uXC;
  a uXD;
  private List<String> uXE;
  
  public b()
  {
    AppMethodBeat.i(67157);
    this.uXC = null;
    this.uXD = null;
    this.uXE = new ArrayList(bt.kS((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtU, ""), ","));
    AppMethodBeat.o(67157);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67158);
    if (this.uXC == null)
    {
      AppMethodBeat.o(67158);
      return 0;
    }
    int i = this.uXC.size();
    AppMethodBeat.o(67158);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(67159);
    Object localObject = this.uXC.get(paramInt);
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
      paramView = y.js(paramViewGroup.getContext()).inflate(2131495210, paramViewGroup, false);
      localb = new b((byte)0);
      localb.lEA = ((TextView)paramView.findViewById(2131298996));
      localb.ftj = ((TextView)paramView.findViewById(2131302654));
      localb.uXI = ((TextView)paramView.findViewById(2131303421));
      localb.uXJ = ((ImageView)paramView.findViewById(2131303861));
      paramView.setTag(localb);
      localb.ftj.setText(localq.name);
      if (bt.isNullOrNil(localq.desc)) {
        break label645;
      }
      localb.lEA.setVisibility(0);
      localb.lEA.setText(localq.desc);
      label153:
      if (bt.isNullOrNil(localq.zOQ)) {
        break label658;
      }
      localb.uXI.setVisibility(0);
      localb.uXI.setText(localq.zOQ);
      label186:
      if (localq.status != 1) {
        break label671;
      }
      paramView.setEnabled(true);
      localb.lEA.setEnabled(true);
      localb.ftj.setEnabled(true);
      label218:
      if ((localq.zOU != 1) || (this.uXE.contains(localq.zOV))) {
        break label697;
      }
      ad.d("MicroMsg.PhoneRechargeAdapter", "show recommendid: %s", new Object[] { localq.zOV });
      localb.uXJ.setVisibility(0);
    }
    for (;;)
    {
      if ((localq.type == 1) && (localq.zOR.equals("1")) && (!localq.zOS.equals("0")))
      {
        Object localObject = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.bW(localq.zOS, false);
        GradientDrawable localGradientDrawable1 = new GradientDrawable();
        localGradientDrawable1.setShape(0);
        localGradientDrawable1.setCornerRadius(a.fromDPToPix((Context)localObject, 2));
        localGradientDrawable1.setColor(paramInt);
        GradientDrawable localGradientDrawable2 = new GradientDrawable();
        localGradientDrawable2.setShape(0);
        localGradientDrawable2.setCornerRadius(a.fromDPToPix((Context)localObject, 2));
        localGradientDrawable2.setStroke(2, a.n((Context)localObject, 2131099658));
        GradientDrawable localGradientDrawable3 = new GradientDrawable();
        localGradientDrawable3.setShape(0);
        localGradientDrawable3.setCornerRadius(a.fromDPToPix((Context)localObject, 2));
        localGradientDrawable3.setColor(a.n((Context)localObject, 2131100788));
        localGradientDrawable3.setStroke(2, paramInt);
        localObject = new StateListDrawable();
        ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localGradientDrawable1);
        ((StateListDrawable)localObject).addState(new int[] { -16842910 }, localGradientDrawable2);
        ((StateListDrawable)localObject).addState(new int[0], localGradientDrawable3);
        paramViewGroup = paramViewGroup.getContext();
        paramInt = com.tencent.mm.plugin.wallet_core.utils.g.bW(localq.zOS, false);
        int i = a.n(paramViewGroup, 2131101179);
        int j = a.n(paramViewGroup, 2131100786);
        paramViewGroup = new ColorStateList(new int[][] { { 16842919 }, { -16842910 }, new int[0] }, new int[] { i, j, paramInt });
        localb.lEA.setTextColor(paramViewGroup);
        localb.ftj.setTextColor(paramViewGroup);
        paramView.setBackground((Drawable)localObject);
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67156);
          if (b.a(b.this) != null)
          {
            if (!b.b(b.this).contains(localq.zOV))
            {
              ad.i("MicroMsg.PhoneRechargeAdapter", "mark recommendid: %s", new Object[] { localq.zOV });
              if (localq.zOV != null)
              {
                b.b(b.this).add(localq.zOV);
                com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtU, bt.n(b.b(b.this), ","));
                localb.uXJ.setVisibility(8);
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
      label645:
      localb.lEA.setVisibility(8);
      break label153;
      label658:
      localb.uXI.setVisibility(8);
      break label186;
      label671:
      paramView.setEnabled(false);
      localb.lEA.setEnabled(false);
      localb.ftj.setEnabled(false);
      break label218;
      label697:
      localb.uXJ.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
  }
  
  final class b
  {
    TextView ftj;
    TextView lEA;
    TextView uXI;
    ImageView uXJ;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.b
 * JD-Core Version:    0.7.0.1
 */