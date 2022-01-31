package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class NearbyFriendsUI$c
  extends BaseAdapter
{
  private final Context context;
  b gxo;
  private b.b gxp;
  
  public NearbyFriendsUI$c(NearbyFriendsUI paramNearbyFriendsUI, Context paramContext)
  {
    AppMethodBeat.i(55462);
    this.gxo = new b(new NearbyFriendsUI.c.1(this));
    this.gxp = null;
    this.context = paramContext;
    AppMethodBeat.o(55462);
  }
  
  public final azr AB(int paramInt)
  {
    AppMethodBeat.i(55465);
    azr localazr = (azr)NearbyFriendsUI.s(this.pdm).get(paramInt);
    AppMethodBeat.o(55465);
    return localazr;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(55463);
    int i = NearbyFriendsUI.s(this.pdm).size();
    AppMethodBeat.o(55463);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(55464);
    if (this.gxp == null) {
      this.gxp = new b.b()
      {
        public final int aqn()
        {
          AppMethodBeat.i(55461);
          int i = NearbyFriendsUI.c.this.getCount();
          AppMethodBeat.o(55461);
          return i;
        }
        
        public final String mS(int paramAnonymousInt)
        {
          AppMethodBeat.i(55460);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= NearbyFriendsUI.c.this.getCount()))
          {
            ab.e("MicroMsg.NearbyFriend", "pos is invalid");
            AppMethodBeat.o(55460);
            return null;
          }
          Object localObject = NearbyFriendsUI.c.this.AB(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(55460);
            return null;
          }
          localObject = ((azr)localObject).jJA;
          AppMethodBeat.o(55460);
          return localObject;
        }
      };
    }
    if (this.gxo != null) {
      this.gxo.a(paramInt, this.gxp);
    }
    Object localObject1;
    label365:
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new NearbyFriendsUI.e();
      paramView = View.inflate(this.context, 2130970345, null);
      paramViewGroup.gvI = ((TextView)paramView.findViewById(2131823732));
      paramViewGroup.pdB = ((TextView)paramView.findViewById(2131826501));
      paramViewGroup.pdA = ((TextView)paramView.findViewById(2131826495));
      paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131823731));
      paramViewGroup.gxt = ((TextView)paramView.findViewById(2131826492));
      paramViewGroup.pdC = ((ImageView)paramView.findViewById(2131826494));
      paramViewGroup.pdD = ((ImageView)paramView.findViewById(2131826496));
      paramViewGroup.pdF = ((ImageView)paramView.findViewById(2131826497));
      paramViewGroup.pdG = ((ImageView)paramView.findViewById(2131826498));
      paramViewGroup.pdH = ((ImageView)paramView.findViewById(2131826499));
      paramViewGroup.pdI = ((ImageView)paramView.findViewById(2131826502));
      localObject1 = paramViewGroup.pdD.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.ao(this.context, 2131427808);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.ao(this.context, 2131427808);
      paramViewGroup.pdD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.pdE = ((ImageView)paramView.findViewById(2131826493));
      paramView.setTag(paramViewGroup);
      localObject1 = (azr)NearbyFriendsUI.s(this.pdm).get(paramInt);
      paramViewGroup.gvI.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, ((azr)localObject1).jKG, paramViewGroup.gvI.getTextSize()));
      if (NearbyFriendsUI.h(this.pdm) != 1) {
        break label859;
      }
      switch (((azr)localObject1).gwP)
      {
      default: 
        paramViewGroup.pdE.setVisibility(8);
        if (((azr)localObject1).xpe != 0)
        {
          paramViewGroup.pdC.setVisibility(0);
          localObject2 = BackwardSupportUtil.b.k(ao.a.flK.kx(((azr)localObject1).xpe), 2.0F);
          paramViewGroup.pdC.setImageBitmap((Bitmap)localObject2);
          paramViewGroup.pdE.setVisibility(8);
          label418:
          paramViewGroup.pdA.setText(((azr)localObject1).xpd);
          paramViewGroup.pdF.setVisibility(8);
          paramViewGroup.pdG.setVisibility(8);
          paramViewGroup.pdH.setVisibility(8);
          paramViewGroup.pdI.setVisibility(8);
          if ((localObject1 instanceof com.tencent.mm.plugin.nearby.a.a))
          {
            localObject2 = ((com.tencent.mm.plugin.nearby.a.a)localObject1).pcn;
            if ((localObject2 == null) || (((LinkedList)localObject2).size() != 1)) {
              break label883;
            }
            paramViewGroup.pdF.setVisibility(0);
            NearbyFriendsUI.p(paramViewGroup.pdF, (String)((LinkedList)localObject2).get(0));
            label522:
            localObject2 = (NearbyFriendsUI.a)NearbyFriendsUI.t(this.pdm).get(((azr)localObject1).jJA);
            if (localObject2 != null)
            {
              if (((NearbyFriendsUI.a)localObject2).pdw != -1) {
                break label1037;
              }
              paramInt = 0;
              label560:
              ((NearbyFriendsUI.a)localObject2).pdw = paramInt;
              if (((NearbyFriendsUI.a)localObject2).pdr > 0) {
                paramViewGroup.pdI.setVisibility(0);
              }
            }
            paramViewGroup.pdI.setOnClickListener(new NearbyFriendsUI.c.3(this, (azr)localObject1));
          }
          if ((((azr)localObject1).gwS != null) && (!((azr)localObject1).gwS.trim().equals(""))) {
            break label1046;
          }
          paramViewGroup.pdB.setVisibility(8);
          label633:
          if ((((azr)localObject1).xpk == null) || ((((azr)localObject1).xpk.gxa & 0x1) <= 0)) {
            break label1083;
          }
          paramViewGroup.pdD.setVisibility(0);
          label662:
          if (!NearbyFriendsUI.d.AC(((azr)localObject1).gwP)) {
            break label1095;
          }
          paramViewGroup.gxs.setImageBitmap(null);
          localObject2 = new c.a();
          ((c.a)localObject2).eNP = com.tencent.mm.plugin.i.c.YK();
          ((c.a)localObject2).eNM = true;
          ((c.a)localObject2).eOe = true;
          localObject2 = ((c.a)localObject2).ahY();
          o.ahG().a(((azr)localObject1).wJr, paramViewGroup.gxs, (com.tencent.mm.at.a.a.c)localObject2);
          if (bo.isNullOrNil(((azr)localObject1).gwU)) {
            break label1283;
          }
          paramViewGroup.gxt.setText(((azr)localObject1).gwU);
          paramViewGroup.gxt.setVisibility(0);
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(55464);
      return paramView;
      paramViewGroup = (NearbyFriendsUI.e)paramView.getTag();
      break;
      paramViewGroup.pdE.setVisibility(0);
      paramViewGroup.pdE.setImageResource(2131231426);
      paramViewGroup.pdE.setContentDescription(this.context.getString(2131301431));
      break label365;
      paramViewGroup.pdE.setVisibility(0);
      paramViewGroup.pdE.setImageResource(2131231425);
      paramViewGroup.pdE.setContentDescription(this.context.getString(2131299866));
      break label365;
      label859:
      paramViewGroup.pdE.setVisibility(8);
      break label365;
      paramViewGroup.pdC.setVisibility(8);
      break label418;
      label883:
      if ((localObject2 != null) && (((LinkedList)localObject2).size() == 2))
      {
        paramViewGroup.pdF.setVisibility(0);
        paramViewGroup.pdG.setVisibility(0);
        NearbyFriendsUI.p(paramViewGroup.pdF, (String)((LinkedList)localObject2).get(0));
        NearbyFriendsUI.p(paramViewGroup.pdG, (String)((LinkedList)localObject2).get(1));
        break label522;
      }
      if ((localObject2 == null) || (((LinkedList)localObject2).size() < 3)) {
        break label522;
      }
      paramViewGroup.pdF.setVisibility(0);
      paramViewGroup.pdG.setVisibility(0);
      paramViewGroup.pdH.setVisibility(0);
      NearbyFriendsUI.p(paramViewGroup.pdF, (String)((LinkedList)localObject2).get(0));
      NearbyFriendsUI.p(paramViewGroup.pdG, (String)((LinkedList)localObject2).get(1));
      NearbyFriendsUI.p(paramViewGroup.pdH, (String)((LinkedList)localObject2).get(2));
      break label522;
      label1037:
      paramInt = ((NearbyFriendsUI.a)localObject2).pdw;
      break label560;
      label1046:
      paramViewGroup.pdB.setVisibility(0);
      paramViewGroup.pdB.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, ((azr)localObject1).gwS, paramViewGroup.pdB.getTextSize()));
      break label633;
      label1083:
      paramViewGroup.pdD.setVisibility(8);
      break label662;
      label1095:
      a.b.c(paramViewGroup.gxs, ((azr)localObject1).jJA);
      if (((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arr(((azr)localObject1).jJA))
      {
        paramViewGroup.gxt.setVisibility(0);
        if (ad.Nt(((azr)localObject1).xpe))
        {
          paramViewGroup.gxt.setText(this.pdm.getString(2131301755));
        }
        else
        {
          ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(((azr)localObject1).jJA);
          Context localContext;
          if (localad != null)
          {
            localObject2 = paramViewGroup.gvI;
            localContext = this.context;
            if (!bo.isNullOrNil(localad.Of())) {
              break label1273;
            }
          }
          label1273:
          for (localObject1 = ((azr)localObject1).jKG;; localObject1 = localad.Of())
          {
            ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.d.j.b(localContext, (CharSequence)localObject1, paramViewGroup.gvI.getTextSize()));
            paramViewGroup.gxt.setText(this.pdm.getString(2131301760));
            break;
          }
        }
      }
      else
      {
        label1283:
        paramViewGroup.gxt.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c
 * JD-Core Version:    0.7.0.1
 */