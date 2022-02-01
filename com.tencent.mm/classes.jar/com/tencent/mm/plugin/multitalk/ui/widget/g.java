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
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ap;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements View.OnClickListener
{
  private TextView mTv;
  private MultiTalkMainUI tSj;
  private View tSk;
  private TextView tSl;
  private ImageView tSm;
  private RecyclerView tSn;
  private View tSo;
  private ImageButton tSp;
  private ImageButton tSq;
  private boolean tSr;
  private int tSs;
  
  public g(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114722);
    this.tSr = false;
    this.tSs = 0;
    this.tSj = paramMultiTalkMainUI;
    this.tSk = paramMultiTalkMainUI.findViewById(2131301066);
    this.tSo = paramMultiTalkMainUI.findViewById(2131304842);
    Object localObject1 = paramMultiTalkMainUI.findViewById(2131301068);
    Object localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(com.tencent.mm.cd.a.hW(paramMultiTalkMainUI) * 15.9D / 100.0D));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.tSl = ((TextView)paramMultiTalkMainUI.findViewById(2131301069));
    this.tSm = ((ImageView)paramMultiTalkMainUI.findViewById(2131301067));
    this.tSn = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131304843));
    this.tSs = (com.tencent.mm.cd.a.hW(paramMultiTalkMainUI) - com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 382) - (int)(com.tencent.mm.cd.a.hW(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    localObject1 = new LinearLayoutManager();
    localObject2 = (RelativeLayout.LayoutParams)this.tSn.getLayoutParams();
    if (this.tSs >= f.tRV * 3 + f.tRO * 2) {}
    for (((RelativeLayout.LayoutParams)localObject2).height = (f.tRV * 3 + f.tRO * 2);; ((RelativeLayout.LayoutParams)localObject2).height = this.tSs)
    {
      this.tSn.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.tSo.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.cd.a.hW(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
      this.tSo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramMultiTalkMainUI.findViewById(2131301048);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cd.a.hW(paramMultiTalkMainUI) * 3.6D / 100.0D));
      ((View)localObject2).setLayoutParams(localLayoutParams);
      this.tSn.setLayoutManager((RecyclerView.i)localObject1);
      this.tSn.setAdapter(new m(paramMultiTalkMainUI));
      this.tSn.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178926);
          b localb = new b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt1);
          localb.lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
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
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (g.a(g.this))) {
            e.nz(false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178925);
        }
      });
      this.mTv = ((TextView)paramMultiTalkMainUI.findViewById(2131301046));
      this.tSp = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301070));
      this.tSq = ((ImageButton)paramMultiTalkMainUI.findViewById(2131301065));
      this.tSp.setOnClickListener(this);
      this.tSq.setOnClickListener(this);
      AppMethodBeat.o(114722);
      return;
    }
  }
  
  public final void cSX()
  {
    AppMethodBeat.i(114724);
    this.tSk.setVisibility(8);
    this.tSj.byJ().removeView(this.tSk);
    AppMethodBeat.o(114724);
  }
  
  public final void l(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114723);
    this.tSk.setVisibility(0);
    String str = j.cSE();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!bt.isNullOrNil(str))
    {
      i = 0;
      while (i < paramMultiTalkGroup.Iok.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.Iok.get(i)).Iol.equals(str)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.Iok.get(i)).Iol);
        }
        i += 1;
      }
      this.tSl.setText(k.c(this.tSj, v.sh(str)));
      this.tSm.setContentDescription(k.c(this.tSj, v.sh(str)));
      a.b.a(this.tSm, str, 0.1F, true);
    }
    if ((this.tSj.byJ() != null) && (this.tSj.byJ().findViewById(2131304253) != null))
    {
      paramMultiTalkGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramMultiTalkGroup.bottomMargin = ap.eb(this.tSj);
      this.tSj.byJ().findViewById(2131304253).setLayoutParams(paramMultiTalkGroup);
    }
    if (localArrayList.size() > 0)
    {
      this.mTv.setVisibility(0);
      this.mTv.setText(2131761422);
      this.tSn.getLayoutParams();
      this.tSn.setVisibility(0);
      this.tSn.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        if (!((m)this.tSn.getAdapter()).ahN((String)localArrayList.get(i))) {
          ((m)this.tSn.getAdapter()).dT((String)localArrayList.get(i), i);
        }
        i += 1;
      }
      this.tSn.getAdapter().aql.notifyChanged();
      AppMethodBeat.o(114723);
      return;
    }
    this.mTv.setVisibility(8);
    this.tSn.setVisibility(8);
    AppMethodBeat.o(114723);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114725);
    if (paramView.getId() == 2131301065)
    {
      p.cSO().g(true, false, false);
      AppMethodBeat.o(114725);
      return;
    }
    if (paramView.getId() == 2131301070)
    {
      paramView = p.cSO();
      if (paramView.cRE())
      {
        ad.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%d", new Object[] { j.g(paramView.tOI), Integer.valueOf(v2protocal.dVB()) });
        p.cSN().tOr.b(paramView.tOI.Iog, paramView.tOI.IjW, paramView.tOI.Ioi, v2protocal.dVB());
        AppMethodBeat.o(114725);
        return;
      }
      ad.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
    }
    AppMethodBeat.o(114725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */