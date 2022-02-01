package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.multitalk.b.m;
import com.tencent.mm.plugin.multitalk.b.p.22;
import com.tencent.mm.plugin.multitalk.b.p.24;
import com.tencent.mm.plugin.multitalk.b.p.25;
import com.tencent.mm.plugin.multitalk.b.p.26;
import com.tencent.mm.plugin.multitalk.b.p.27;
import com.tencent.mm.plugin.multitalk.b.p.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements View.OnClickListener
{
  private TextView pnR;
  private MultiTalkMainUI zSH;
  private View zSI;
  private View zSJ;
  private TextView zSK;
  private ImageView zSL;
  private RecyclerView zSM;
  private View zSN;
  private ImageButton zSO;
  private ImageButton zSP;
  private boolean zSQ;
  private int zSR;
  
  public g(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114722);
    this.zSQ = false;
    this.zSR = 0;
    this.zSH = paramMultiTalkMainUI;
    this.zSI = paramMultiTalkMainUI.findViewById(2131302720);
    this.zSN = paramMultiTalkMainUI.findViewById(2131307928);
    Object localObject1 = paramMultiTalkMainUI.findViewById(2131302722);
    Object localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(com.tencent.mm.cb.a.jo(paramMultiTalkMainUI) * 15.9D / 100.0D));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.zSK = ((TextView)paramMultiTalkMainUI.findViewById(2131302723));
    this.zSL = ((ImageView)paramMultiTalkMainUI.findViewById(2131302721));
    this.zSM = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131307929));
    this.zSJ = paramMultiTalkMainUI.findViewById(2131305039);
    this.zSR = (com.tencent.mm.cb.a.jo(paramMultiTalkMainUI) - com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 382) - (int)(com.tencent.mm.cb.a.jo(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    localObject1 = new LinearLayoutManager();
    localObject2 = (RelativeLayout.LayoutParams)this.zSM.getLayoutParams();
    if (this.zSR >= f.zSo * 3 + f.zSg * 2) {}
    for (((RelativeLayout.LayoutParams)localObject2).height = (f.zSo * 3 + f.zSg * 2);; ((RelativeLayout.LayoutParams)localObject2).height = this.zSR)
    {
      this.zSM.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.zSN.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.cb.a.jo(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
      this.zSN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramMultiTalkMainUI.findViewById(2131302702);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cb.a.jo(paramMultiTalkMainUI) * 3.6D / 100.0D));
      ((View)localObject2).setLayoutParams(localLayoutParams);
      this.zSM.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      this.zSM.setAdapter(new s(paramMultiTalkMainUI));
      this.zSM.setOnScrollListener(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(178925);
          b localb = new b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (g.a(g.this))) {
            com.tencent.mm.plugin.multitalk.model.p.rE(false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178925);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178926);
          b localb = new b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousRecyclerView = g.this;
          if (paramAnonymousInt2 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            g.a(paramAnonymousRecyclerView, bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(178926);
            return;
          }
        }
      });
      this.pnR = ((TextView)paramMultiTalkMainUI.findViewById(2131302700));
      this.zSO = ((ImageButton)paramMultiTalkMainUI.findViewById(2131302724));
      this.zSP = ((ImageButton)paramMultiTalkMainUI.findViewById(2131302719));
      this.zSO.setOnClickListener(this);
      this.zSP.setOnClickListener(this);
      AppMethodBeat.o(114722);
      return;
    }
  }
  
  public final void eoG()
  {
    AppMethodBeat.i(114724);
    this.zSI.setVisibility(8);
    this.zSH.chG().removeView(this.zSI);
    AppMethodBeat.o(114724);
  }
  
  public final void m(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114723);
    this.zSI.setVisibility(0);
    this.zSJ.setVisibility(0);
    String str = v.enX();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!Util.isNullOrNil(str))
    {
      i = 0;
      while (i < paramMultiTalkGroup.RHa.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.RHa.get(i)).RHb.equals(str)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.RHa.get(i)).RHb);
        }
        i += 1;
      }
      this.zSK.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.zSH, aa.getDisplayName(str)));
      this.zSL.setContentDescription(com.tencent.mm.pluginsdk.ui.span.l.c(this.zSH, aa.getDisplayName(str)));
      a.b.a(this.zSL, str, 0.1F, true);
    }
    if ((this.zSH.chG() != null) && (this.zSH.chG().findViewById(2131307175) != null))
    {
      paramMultiTalkGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramMultiTalkGroup.bottomMargin = au.aD(this.zSH);
      this.zSH.chG().findViewById(2131307175).setLayoutParams(paramMultiTalkGroup);
    }
    if (localArrayList.size() > 0)
    {
      this.pnR.setVisibility(0);
      this.pnR.setText(2131763277);
      this.zSM.getLayoutParams();
      this.zSM.setVisibility(0);
      this.zSM.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        if (!((s)this.zSM.getAdapter()).aGC((String)localArrayList.get(i))) {
          ((s)this.zSM.getAdapter()).eO((String)localArrayList.get(i), i);
        }
        i += 1;
      }
      this.zSM.getAdapter().atj.notifyChanged();
      AppMethodBeat.o(114723);
      return;
    }
    this.pnR.setVisibility(8);
    this.zSM.setVisibility(8);
    AppMethodBeat.o(114723);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114725);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131302719) {
      ac.eom().j(true, false, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114725);
      return;
      if (paramView.getId() == 2131302724)
      {
        paramView = ac.eom();
        if (paramView.ems())
        {
          boolean bool = paramView.aFW(paramView.zME.zHE);
          Log.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%d, isILink:%b", new Object[] { v.g(paramView.zME), Integer.valueOf(v2protocal.fJa()), Boolean.valueOf(bool) });
          if (bool)
          {
            paramView = com.tencent.mm.plugin.multitalk.b.p.zHS;
            if (paramView.qtM)
            {
              Log.i("MicroMsg.Multitalk.ILinkService", "steve: already accept!!!");
            }
            else
            {
              paramView.zIP = p.b.zKv;
              paramView.qtH = false;
              paramView.zIy = new p.22(paramView);
              paramView.zIz = new p.24(paramView);
              paramView.zIm = new p.25(paramView);
              paramView.zIn = new p.26(paramView);
              paramView.zHU.a(14, paramView.zIy);
              paramView.zHU.a(15, paramView.zIz);
              paramView.zHU.a(22, paramView.zIm);
              paramView.zHU.a(23, paramView.zIn);
              paramView.czf();
              paramView.elV();
              if (m.elJ() != 0)
              {
                paramView.hg(-10086, -4);
              }
              else
              {
                paramView.qtM = true;
                paramView.d(new p.27(paramView));
              }
            }
          }
          else
          {
            ac.eol().zMd.c(paramView.zME.zHD, paramView.zME.RCJ, paramView.zME.zHE, v2protocal.fJa());
            paramView = com.tencent.mm.plugin.multitalk.d.d.zZa;
            com.tencent.mm.plugin.multitalk.d.d.reset();
          }
        }
        else
        {
          Log.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */