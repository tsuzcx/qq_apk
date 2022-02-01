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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ar;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements View.OnClickListener
{
  private TextView nXl;
  private MultiTalkMainUI wfZ;
  private View wga;
  private TextView wgb;
  private ImageView wgc;
  private RecyclerView wgd;
  private View wge;
  private ImageButton wgf;
  private ImageButton wgg;
  private boolean wgh;
  private int wgi;
  
  public g(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114722);
    this.wgh = false;
    this.wgi = 0;
    this.wfZ = paramMultiTalkMainUI;
    this.wga = paramMultiTalkMainUI.findViewById(2131301066);
    this.wge = paramMultiTalkMainUI.findViewById(2131304842);
    Object localObject1 = paramMultiTalkMainUI.findViewById(2131301068);
    Object localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(com.tencent.mm.cc.a.iq(paramMultiTalkMainUI) * 15.9D / 100.0D));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.wgb = ((TextView)paramMultiTalkMainUI.findViewById(2131301069));
    this.wgc = ((ImageView)paramMultiTalkMainUI.findViewById(2131301067));
    this.wgd = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131304843));
    this.wgi = (com.tencent.mm.cc.a.iq(paramMultiTalkMainUI) - com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 382) - (int)(com.tencent.mm.cc.a.iq(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    localObject1 = new LinearLayoutManager();
    localObject2 = (RelativeLayout.LayoutParams)this.wgd.getLayoutParams();
    if (this.wgi >= f.wfL * 3 + f.wfE * 2) {}
    for (((RelativeLayout.LayoutParams)localObject2).height = (f.wfL * 3 + f.wfE * 2);; ((RelativeLayout.LayoutParams)localObject2).height = this.wgi)
    {
      this.wgd.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.wge.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.cc.a.iq(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
      this.wge.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramMultiTalkMainUI.findViewById(2131301048);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cc.a.iq(paramMultiTalkMainUI) * 3.6D / 100.0D));
      ((View)localObject2).setLayoutParams(localLayoutParams);
      this.wgd.setLayoutManager((RecyclerView.i)localObject1);
      this.wgd.setAdapter(new m(paramMultiTalkMainUI));
      this.wgd.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178926);
          b localb = new b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt1);
          localb.mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
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
          localb.mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (g.a(g.this))) {
            n.oP(false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178925);
        }
      });
      this.nXl = ((TextView)paramMultiTalkMainUI.findViewById(2131301046));
      this.wgf = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301070));
      this.wgg = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301065));
      this.wgf.setOnClickListener(this);
      this.wgg.setOnClickListener(this);
      AppMethodBeat.o(114722);
      return;
    }
  }
  
  public final void dqJ()
  {
    AppMethodBeat.i(114724);
    this.wga.setVisibility(8);
    this.wfZ.bJP().removeView(this.wga);
    AppMethodBeat.o(114724);
  }
  
  public final void l(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114723);
    this.wga.setVisibility(0);
    String str = t.dqm();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!bt.isNullOrNil(str))
    {
      i = 0;
      while (i < paramMultiTalkGroup.LJG.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.LJG.get(i)).LJH.equals(str)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.LJG.get(i)).LJH);
        }
        i += 1;
      }
      this.wgb.setText(k.c(this.wfZ, v.zf(str)));
      this.wgc.setContentDescription(k.c(this.wfZ, v.zf(str)));
      a.b.a(this.wgc, str, 0.1F, true);
    }
    if ((this.wfZ.bJP() != null) && (this.wfZ.bJP().findViewById(2131304253) != null))
    {
      paramMultiTalkGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramMultiTalkGroup.bottomMargin = ar.ej(this.wfZ);
      this.wfZ.bJP().findViewById(2131304253).setLayoutParams(paramMultiTalkGroup);
    }
    if (localArrayList.size() > 0)
    {
      this.nXl.setVisibility(0);
      this.nXl.setText(2131761422);
      this.wgd.getLayoutParams();
      this.wgd.setVisibility(0);
      this.wgd.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        if (!((m)this.wgd.getAdapter()).arH((String)localArrayList.get(i))) {
          ((m)this.wgd.getAdapter()).es((String)localArrayList.get(i), i);
        }
        i += 1;
      }
      this.wgd.getAdapter().asY.notifyChanged();
      AppMethodBeat.o(114723);
      return;
    }
    this.nXl.setVisibility(8);
    this.wgd.setVisibility(8);
    AppMethodBeat.o(114723);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114725);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView.getId() == 2131301065) {
      z.dqx().h(true, false, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114725);
      return;
      if (paramView.getId() == 2131301070)
      {
        paramView = z.dqx();
        if (paramView.dpa())
        {
          ad.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%d", new Object[] { t.g(paramView.wbv), Integer.valueOf(v2protocal.eyy()) });
          z.dqw().wbf.c(paramView.wbv.LJC, paramView.wbv.LFq, paramView.wbv.LJE, v2protocal.eyy());
          paramView = com.tencent.mm.plugin.multitalk.c.d.whH;
          com.tencent.mm.plugin.multitalk.c.d.reset();
        }
        else
        {
          ad.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */