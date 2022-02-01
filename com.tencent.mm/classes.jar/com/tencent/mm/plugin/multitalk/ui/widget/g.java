package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ap;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements View.OnClickListener
{
  private TextView nvN;
  private MultiTalkMainUI vaQ;
  private View vaR;
  private TextView vaS;
  private ImageView vaT;
  private RecyclerView vaU;
  private View vaV;
  private ImageButton vaW;
  private ImageButton vaX;
  private boolean vaY;
  private int vaZ;
  
  public g(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114722);
    this.vaY = false;
    this.vaZ = 0;
    this.vaQ = paramMultiTalkMainUI;
    this.vaR = paramMultiTalkMainUI.findViewById(2131301066);
    this.vaV = paramMultiTalkMainUI.findViewById(2131304842);
    Object localObject1 = paramMultiTalkMainUI.findViewById(2131301068);
    Object localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(a.ih(paramMultiTalkMainUI) * 15.9D / 100.0D));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.vaS = ((TextView)paramMultiTalkMainUI.findViewById(2131301069));
    this.vaT = ((ImageView)paramMultiTalkMainUI.findViewById(2131301067));
    this.vaU = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131304843));
    this.vaZ = (a.ih(paramMultiTalkMainUI) - a.fromDPToPix(paramMultiTalkMainUI, 382) - (int)(a.ih(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    localObject1 = new LinearLayoutManager();
    localObject2 = (RelativeLayout.LayoutParams)this.vaU.getLayoutParams();
    if (this.vaZ >= f.vaC * 3 + f.vav * 2) {}
    for (((RelativeLayout.LayoutParams)localObject2).height = (f.vaC * 3 + f.vav * 2);; ((RelativeLayout.LayoutParams)localObject2).height = this.vaZ)
    {
      this.vaU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.vaV.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(a.ih(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
      this.vaV.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramMultiTalkMainUI.findViewById(2131301048);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(a.ih(paramMultiTalkMainUI) * 3.6D / 100.0D));
      ((View)localObject2).setLayoutParams(localLayoutParams);
      this.vaU.setLayoutManager((RecyclerView.i)localObject1);
      this.vaU.setAdapter(new m(paramMultiTalkMainUI));
      this.vaU.setOnScrollListener(new g.1(this));
      this.nvN = ((TextView)paramMultiTalkMainUI.findViewById(2131301046));
      this.vaW = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301070));
      this.vaX = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301065));
      this.vaW.setOnClickListener(this);
      this.vaX.setOnClickListener(this);
      AppMethodBeat.o(114722);
      return;
    }
  }
  
  public final void dgH()
  {
    AppMethodBeat.i(114724);
    this.vaR.setVisibility(8);
    this.vaQ.bFF().removeView(this.vaR);
    AppMethodBeat.o(114724);
  }
  
  public final void l(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114723);
    this.vaR.setVisibility(0);
    String str = j.dgn();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!bs.isNullOrNil(str))
    {
      i = 0;
      while (i < paramMultiTalkGroup.JPV.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.JPV.get(i)).JPW.equals(str)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.JPV.get(i)).JPW);
        }
        i += 1;
      }
      this.vaS.setText(k.c(this.vaQ, v.wk(str)));
      this.vaT.setContentDescription(k.c(this.vaQ, v.wk(str)));
      a.b.a(this.vaT, str, 0.1F, true);
    }
    if ((this.vaQ.bFF() != null) && (this.vaQ.bFF().findViewById(2131304253) != null))
    {
      paramMultiTalkGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramMultiTalkGroup.bottomMargin = ap.ej(this.vaQ);
      this.vaQ.bFF().findViewById(2131304253).setLayoutParams(paramMultiTalkGroup);
    }
    if (localArrayList.size() > 0)
    {
      this.nvN.setVisibility(0);
      this.nvN.setText(2131761422);
      this.vaU.getLayoutParams();
      this.vaU.setVisibility(0);
      this.vaU.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        if (!((m)this.vaU.getAdapter()).amI((String)localArrayList.get(i))) {
          ((m)this.vaU.getAdapter()).ea((String)localArrayList.get(i), i);
        }
        i += 1;
      }
      this.vaU.getAdapter().arg.notifyChanged();
      AppMethodBeat.o(114723);
      return;
    }
    this.nvN.setVisibility(8);
    this.vaU.setVisibility(8);
    AppMethodBeat.o(114723);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114725);
    if (paramView.getId() == 2131301065)
    {
      p.dgx().h(true, false, false);
      AppMethodBeat.o(114725);
      return;
    }
    if (paramView.getId() == 2131301070)
    {
      paramView = p.dgx();
      if (paramView.dfo())
      {
        ac.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%d", new Object[] { j.g(paramView.uXk), Integer.valueOf(v2protocal.ekN()) });
        p.dgw().uWU.b(paramView.uXk.JPR, paramView.uXk.JLH, paramView.uXk.JPT, v2protocal.ekN());
        AppMethodBeat.o(114725);
        return;
      }
      ac.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
    }
    AppMethodBeat.o(114725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */