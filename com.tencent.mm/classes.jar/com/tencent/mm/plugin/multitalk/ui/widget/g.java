package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.b.l;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.multitalk.b.p.21;
import com.tencent.mm.plugin.multitalk.b.p.22;
import com.tencent.mm.plugin.multitalk.b.p.24;
import com.tencent.mm.plugin.multitalk.b.p.25;
import com.tencent.mm.plugin.multitalk.b.p.26;
import com.tencent.mm.plugin.multitalk.b.p.b;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ar;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements View.OnClickListener
{
  private TextView ocU;
  private MultiTalkMainUI wvC;
  private View wvD;
  private TextView wvE;
  private ImageView wvF;
  private RecyclerView wvG;
  private View wvH;
  private ImageButton wvI;
  private ImageButton wvJ;
  private boolean wvK;
  private int wvL;
  
  public g(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114722);
    this.wvK = false;
    this.wvL = 0;
    this.wvC = paramMultiTalkMainUI;
    this.wvD = paramMultiTalkMainUI.findViewById(2131301066);
    this.wvH = paramMultiTalkMainUI.findViewById(2131304842);
    Object localObject1 = paramMultiTalkMainUI.findViewById(2131301068);
    Object localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(com.tencent.mm.cb.a.iv(paramMultiTalkMainUI) * 15.9D / 100.0D));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.wvE = ((TextView)paramMultiTalkMainUI.findViewById(2131301069));
    this.wvF = ((ImageView)paramMultiTalkMainUI.findViewById(2131301067));
    this.wvG = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131304843));
    this.wvL = (com.tencent.mm.cb.a.iv(paramMultiTalkMainUI) - com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 382) - (int)(com.tencent.mm.cb.a.iv(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    localObject1 = new LinearLayoutManager();
    localObject2 = (RelativeLayout.LayoutParams)this.wvG.getLayoutParams();
    if (this.wvL >= f.wvo * 3 + f.wvh * 2) {}
    for (((RelativeLayout.LayoutParams)localObject2).height = (f.wvo * 3 + f.wvh * 2);; ((RelativeLayout.LayoutParams)localObject2).height = this.wvL)
    {
      this.wvG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.wvH.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.cb.a.iv(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
      this.wvH.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramMultiTalkMainUI.findViewById(2131301048);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cb.a.iv(paramMultiTalkMainUI) * 3.6D / 100.0D));
      ((View)localObject2).setLayoutParams(localLayoutParams);
      this.wvG.setLayoutManager((RecyclerView.i)localObject1);
      this.wvG.setAdapter(new m(paramMultiTalkMainUI));
      this.wvG.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178926);
          b localb = new b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt1);
          localb.mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
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
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(178925);
          b localb = new b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (g.a(g.this))) {
            n.oW(false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178925);
        }
      });
      this.ocU = ((TextView)paramMultiTalkMainUI.findViewById(2131301046));
      this.wvI = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301070));
      this.wvJ = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301065));
      this.wvI.setOnClickListener(this);
      this.wvJ.setOnClickListener(this);
      AppMethodBeat.o(114722);
      return;
    }
  }
  
  public final void dtW()
  {
    AppMethodBeat.i(114724);
    this.wvD.setVisibility(8);
    this.wvC.bKN().removeView(this.wvD);
    AppMethodBeat.o(114724);
  }
  
  public final void m(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114723);
    this.wvD.setVisibility(0);
    String str = t.dtz();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!bu.isNullOrNil(str))
    {
      i = 0;
      while (i < paramMultiTalkGroup.MgI.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.MgI.get(i)).MgJ.equals(str)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.MgI.get(i)).MgJ);
        }
        i += 1;
      }
      this.wvE.setText(k.c(this.wvC, w.zP(str)));
      this.wvF.setContentDescription(k.c(this.wvC, w.zP(str)));
      a.b.a(this.wvF, str, 0.1F, true);
    }
    if ((this.wvC.bKN() != null) && (this.wvC.bKN().findViewById(2131304253) != null))
    {
      paramMultiTalkGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramMultiTalkGroup.bottomMargin = ar.en(this.wvC);
      this.wvC.bKN().findViewById(2131304253).setLayoutParams(paramMultiTalkGroup);
    }
    if (localArrayList.size() > 0)
    {
      this.ocU.setVisibility(0);
      this.ocU.setText(2131761422);
      this.wvG.getLayoutParams();
      this.wvG.setVisibility(0);
      this.wvG.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        if (!((m)this.wvG.getAdapter()).asU((String)localArrayList.get(i))) {
          ((m)this.wvG.getAdapter()).eA((String)localArrayList.get(i), i);
        }
        i += 1;
      }
      this.wvG.getAdapter().asY.notifyChanged();
      AppMethodBeat.o(114723);
      return;
    }
    this.ocU.setVisibility(8);
    this.wvG.setVisibility(8);
    AppMethodBeat.o(114723);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114725);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView.getId() == 2131301065) {
      z.dtK().j(true, false, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114725);
      return;
      if (paramView.getId() == 2131301070)
      {
        paramView = z.dtK();
        if (paramView.dsk())
        {
          boolean bool = paramView.asB(paramView.wqU.wmA);
          ae.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%d, isILink:%b", new Object[] { t.g(paramView.wqU), Integer.valueOf(v2protocal.eCg()), Boolean.valueOf(bool) });
          if (bool)
          {
            paramView = p.wmO;
            paramView.wnI = p.b.wpi;
            paramView.peE = false;
            paramView.wnt = new p.21(paramView);
            paramView.wnu = new p.22(paramView);
            paramView.wnh = new p.24(paramView);
            paramView.wni = new p.25(paramView);
            paramView.wmQ.a(14, paramView.wnt);
            paramView.wmQ.a(15, paramView.wnu);
            paramView.wmQ.a(21, paramView.wnh);
            paramView.wmQ.a(22, paramView.wni);
            paramView.cbp();
            if (com.tencent.mm.plugin.multitalk.b.m.KZ(paramView.pej) != 0)
            {
              paramView.gE(-10086, -4);
            }
            else
            {
              paramView.peJ = true;
              paramView.d(new p.26(paramView));
            }
          }
          else
          {
            z.dtJ().wqE.c(paramView.wqU.wmz, paramView.wqU.Mcu, paramView.wqU.wmA, v2protocal.eCg());
            paramView = com.tencent.mm.plugin.multitalk.d.d.wxl;
            com.tencent.mm.plugin.multitalk.d.d.reset();
          }
        }
        else
        {
          ae.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */