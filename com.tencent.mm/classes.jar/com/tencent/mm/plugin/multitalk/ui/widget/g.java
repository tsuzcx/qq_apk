package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.b.k;
import com.tencent.mm.plugin.multitalk.b.o.22;
import com.tencent.mm.plugin.multitalk.b.o.24;
import com.tencent.mm.plugin.multitalk.b.o.25;
import com.tencent.mm.plugin.multitalk.b.o.26;
import com.tencent.mm.plugin.multitalk.b.o.27;
import com.tencent.mm.plugin.multitalk.b.o.b;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements View.OnClickListener
{
  private MultiTalkMainUI Fyj;
  private View Fyk;
  private View Fyl;
  private TextView Fym;
  private ImageView Fyn;
  private RecyclerView Fyo;
  private View Fyp;
  private ImageButton Fyq;
  private ImageButton Fyr;
  private boolean Fys;
  private int Fyt;
  private TextView swR;
  
  public g(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114722);
    this.Fys = false;
    this.Fyt = 0;
    this.Fyj = paramMultiTalkMainUI;
    this.Fyk = paramMultiTalkMainUI.findViewById(a.e.invite_layout);
    this.Fyp = paramMultiTalkMainUI.findViewById(a.e.small_avatar_introduce_layout);
    Object localObject1 = paramMultiTalkMainUI.findViewById(a.e.invite_main_layout);
    Object localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(com.tencent.mm.ci.a.ks(paramMultiTalkMainUI) * 15.9D / 100.0D));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.Fym = ((TextView)paramMultiTalkMainUI.findViewById(a.e.invite_main_nickname_tv));
    this.Fyn = ((ImageView)paramMultiTalkMainUI.findViewById(a.e.invite_main_avatar_iv));
    this.Fyo = ((RecyclerView)paramMultiTalkMainUI.findViewById(a.e.small_avatar_iv_container));
    this.Fyl = paramMultiTalkMainUI.findViewById(a.e.multitalk_mini_action);
    this.Fyt = (com.tencent.mm.ci.a.ks(paramMultiTalkMainUI) - com.tencent.mm.ci.a.fromDPToPix(paramMultiTalkMainUI, 382) - (int)(com.tencent.mm.ci.a.ks(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
    localObject1 = new LinearLayoutManager();
    localObject2 = (RelativeLayout.LayoutParams)this.Fyo.getLayoutParams();
    if (this.Fyt >= f.FxQ * 3 + f.FxI * 2) {}
    for (((RelativeLayout.LayoutParams)localObject2).height = (f.FxQ * 3 + f.FxI * 2);; ((RelativeLayout.LayoutParams)localObject2).height = this.Fyt)
    {
      this.Fyo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.Fyp.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.ci.a.ks(paramMultiTalkMainUI) * 21.899999999999999D / 100.0D));
      this.Fyp.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramMultiTalkMainUI.findViewById(a.e.invite_control_layout);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.ci.a.ks(paramMultiTalkMainUI) * 3.6D / 100.0D));
      ((View)localObject2).setLayoutParams(localLayoutParams);
      this.Fyo.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      this.Fyo.setAdapter(new s(paramMultiTalkMainUI));
      this.Fyo.setOnScrollListener(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(204922);
          b localb = new b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (g.a(g.this))) {
            p.uH(false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(204922);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(204923);
          b localb = new b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt1);
          localb.sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousRecyclerView = g.this;
          if (paramAnonymousInt2 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            g.a(paramAnonymousRecyclerView, bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(204923);
            return;
          }
        }
      });
      this.swR = ((TextView)paramMultiTalkMainUI.findViewById(a.e.introduce_tv));
      this.Fyq = ((ImageButton)paramMultiTalkMainUI.findViewById(a.e.invite_pickup_btn));
      this.Fyr = ((ImageButton)paramMultiTalkMainUI.findViewById(a.e.invite_hangup_btn));
      this.Fyq.setOnClickListener(this);
      this.Fyr.setOnClickListener(this);
      AppMethodBeat.o(114722);
      return;
    }
  }
  
  public final void eYx()
  {
    AppMethodBeat.i(114724);
    this.Fyk.setVisibility(8);
    this.Fyj.cuR().removeView(this.Fyk);
    AppMethodBeat.o(114724);
  }
  
  public final void m(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114723);
    this.Fyk.setVisibility(0);
    this.Fyl.setVisibility(0);
    String str = v.eXN();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!Util.isNullOrNil(str))
    {
      i = 0;
      while (i < paramMultiTalkGroup.ZiG.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.ZiG.get(i)).ZiH.equals(str)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.ZiG.get(i)).ZiH);
        }
        i += 1;
      }
      this.Fym.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.Fyj, aa.PJ(str)));
      this.Fyn.setContentDescription(com.tencent.mm.pluginsdk.ui.span.l.c(this.Fyj, aa.PJ(str)));
      a.b.a(this.Fyn, str, 0.1F, true);
    }
    if ((this.Fyj.cuR() != null) && (this.Fyj.cuR().findViewById(a.e.rootview) != null))
    {
      paramMultiTalkGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramMultiTalkGroup.bottomMargin = ax.aB(this.Fyj);
      this.Fyj.cuR().findViewById(a.e.rootview).setLayoutParams(paramMultiTalkGroup);
    }
    if (localArrayList.size() > 0)
    {
      this.swR.setVisibility(0);
      this.swR.setText(a.h.multitalk_member_wording);
      this.Fyo.getLayoutParams();
      this.Fyo.setVisibility(0);
      this.Fyo.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        if (!((s)this.Fyo.getAdapter()).aQR((String)localArrayList.get(i))) {
          ((s)this.Fyo.getAdapter()).fp((String)localArrayList.get(i), i);
        }
        i += 1;
      }
      this.Fyo.getAdapter().alc.notifyChanged();
      AppMethodBeat.o(114723);
      return;
    }
    this.swR.setVisibility(8);
    this.Fyo.setVisibility(8);
    AppMethodBeat.o(114723);
  }
  
  public final void onClick(View arg1)
  {
    AppMethodBeat.i(114725);
    Object localObject = new b();
    ((b)localObject).bn(???);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if (???.getId() == a.e.invite_hangup_btn) {
      ad.eYc().i(true, false, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114725);
      return;
      if (???.getId() == a.e.invite_pickup_btn)
      {
        ??? = ad.eYc();
        if (???.eWg())
        {
          boolean bool = ???.aQj(???.FrY.FmP);
          Log.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%s, isILink:%b", new Object[] { v.g(???.FrY), v2protocal.gBp(), Boolean.valueOf(bool) });
          if (bool) {
            for (;;)
            {
              synchronized (???.Fsv)
              {
                localObject = com.tencent.mm.plugin.multitalk.b.o.Fne;
                if (((com.tencent.mm.plugin.multitalk.b.o)localObject).tSy) {
                  Log.i("MicroMsg.Multitalk.ILinkService", "steve: already accept!!!");
                }
              }
              localo.Fod = o.b.FpN;
              localo.tSt = false;
              localo.FnM = new o.22(localo);
              localo.FnN = new o.24(localo);
              localo.FnA = new o.25(localo);
              localo.FnB = new o.26(localo);
              localo.Fng.a(14, localo.FnM);
              localo.Fng.a(15, localo.FnN);
              localo.Fng.a(22, localo.FnA);
              localo.Fng.a(23, localo.FnB);
              localo.cNE();
              if (c.gxv()) {
                localo.eVI();
              }
              if (com.tencent.mm.plugin.multitalk.b.l.eVv() != 0)
              {
                localo.il(-10086, -4);
              }
              else
              {
                localo.tSy = true;
                localo.d(new o.27(localo));
              }
            }
          }
          ad.eYb().Frw.o(???.FrY.FmO, ???.FrY.Zel, ???.FrY.FmP, v2protocal.gBp());
          ??? = com.tencent.mm.plugin.multitalk.d.d.FEN;
          com.tencent.mm.plugin.multitalk.d.d.reset();
        }
        else
        {
          Log.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */