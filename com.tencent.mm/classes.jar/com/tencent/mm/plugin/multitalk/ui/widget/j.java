package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.multitalk.model.a.b;
import com.tencent.mm.plugin.multitalk.model.ab;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.r;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
import d.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class j
  implements View.OnClickListener, e.a, com.tencent.mm.plugin.multitalk.model.b, f
{
  private av cjg;
  public TextView fTP;
  public boolean gFv;
  com.tencent.mm.ui.widget.a.d juf;
  private TextView titleTv;
  private RecyclerView wac;
  public com.tencent.mm.plugin.multitalk.model.a wbR;
  MultiTalkMainUI wfZ;
  private View wgA;
  public View wgB;
  private View wgC;
  public View wgD;
  public View wgE;
  public MultiTalkControlIconLayout wgF;
  public MultiTalkControlIconLayout wgG;
  public MultiTalkControlIconLayout wgH;
  private int wgI;
  private int wgJ;
  private RelativeLayout wgK;
  private RelativeLayout wgL;
  private LinearLayout wgM;
  private RelativeLayout wgN;
  private com.tencent.mm.plugin.voip.video.a wgO;
  private ObservableTextureView wgP;
  private CollapseView wgQ;
  private ArrayList<Integer> wgR;
  private boolean wgS;
  private boolean wgT;
  private boolean wgU;
  private int wgV;
  View.OnClickListener wgW;
  private boolean wgX;
  private boolean wgY;
  public long wgZ;
  private ImageButton wgg;
  private boolean wgh;
  private int wgi;
  private final View wgy;
  private GridLayoutManager wgz;
  a wha;
  
  public j(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114737);
    this.wgR = new ArrayList();
    this.wgS = false;
    this.wgT = false;
    this.wgU = true;
    this.wgV = (e.b.EJq * e.b.EJp);
    this.wgi = 0;
    this.wgW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178933);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        n.vue += 1;
        paramAnonymousView = j.this;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramAnonymousView.wfZ.getContext(), "android.permission.CAMERA", 22, "", "");
        ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), paramAnonymousView.wfZ.getContext() });
        if (!bool)
        {
          j.this.wgF.setChecked(false);
          n.dpv();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!z.dqx().dpM())
        {
          j.this.wgF.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!z.dqx().doZ())
        {
          j.this.wgF.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!ay.isNetworkConnected(j.this.wfZ))
        {
          com.tencent.mm.bi.e.a(j.this.wfZ, 2131764895, null);
          j.this.wgF.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.t.dqo())
        {
          Toast.makeText(j.this.wfZ, 2131761391, 1).show();
          j.this.wgF.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (j.this.wgF.wfu.isChecked())
        {
          j.this.wgF.setChecked(true);
          j.this.oZ(false);
          n.dpD();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
          j.this.wgF.setChecked(false);
          j.this.pa(false);
          z.dqx().KE(1);
          n.dpE();
        }
      }
    };
    this.wgX = false;
    this.wgY = false;
    this.cjg = new av("MultiTalkTimer", new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(206586);
        h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206585);
            j.d(j.this).setVisibility(8);
            j.e(j.this).setVisibility(0);
            AppMethodBeat.o(206585);
          }
        });
        AppMethodBeat.o(206586);
        return true;
      }
    }, false);
    this.wha = new a((byte)0);
    this.juf = null;
    this.gFv = true;
    this.wfZ = paramMultiTalkMainUI;
    this.wgI = com.tencent.mm.cc.a.ip(paramMultiTalkMainUI.getContext());
    this.wgJ = (this.wgI + com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 52) + al.jG(paramMultiTalkMainUI));
    this.fTP = ((TextView)paramMultiTalkMainUI.findViewById(2131305822));
    this.wgA = paramMultiTalkMainUI.findViewById(2131306007);
    this.titleTv = ((TextView)paramMultiTalkMainUI.findViewById(2131305948));
    this.wgB = paramMultiTalkMainUI.findViewById(2131305668);
    this.wgi = (com.tencent.mm.cc.a.iq(paramMultiTalkMainUI) - com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 285));
    this.wgK = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131298785));
    this.wgL = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131300676));
    this.wgM = ((LinearLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494971, null, false));
    this.wgN = ((RelativeLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494970, null, false));
    this.wgg = ((ImageButton)this.wgN.findViewById(2131305667));
    this.wac = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131305669));
    FrameLayout localFrameLayout = (FrameLayout)paramMultiTalkMainUI.findViewById(2131305665);
    this.wbR = z.dqx().dpT();
    this.wgy = paramMultiTalkMainUI.findViewById(2131306002);
    Object localObject1 = (RelativeLayout.LayoutParams)this.wgy.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).topMargin = (al.jG(paramMultiTalkMainUI) + com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 12));
    this.wgy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)localFrameLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).topMargin = (com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 52) + al.jG(paramMultiTalkMainUI));
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.wgz = new GridLayoutManager(3);
    localObject1 = new a(paramMultiTalkMainUI);
    this.wac.setLayoutManager(this.wgz);
    this.wgz.apF = new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(178928);
        if (this.whb.KJ(paramAnonymousInt))
        {
          paramAnonymousInt = j.a(j.this).apA;
          AppMethodBeat.o(178928);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(178928);
        return 1;
      }
    };
    Object localObject2 = (RelativeLayout.LayoutParams)this.wac.getLayoutParams();
    if (this.wgi > this.wgI)
    {
      ((RelativeLayout.LayoutParams)localObject2).width = this.wgI;
      ((RelativeLayout.LayoutParams)localObject2).height = this.wgJ;
    }
    for (;;)
    {
      this.wac.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((a)localObject1).wet = this.wbR;
      this.wac.setAdapter((RecyclerView.a)localObject1);
      this.wac.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt1);
          localb.mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousRecyclerView = j.this;
          if (paramAnonymousInt2 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            j.a(paramAnonymousRecyclerView, bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(178930);
            return;
          }
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(178929);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (j.b(j.this)))
          {
            j.c(j.this);
            n.oP(true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178929);
        }
      });
      localObject2 = this.wbR;
      localObject1 = this.wac;
      d.g.b.p.h(localObject1, "talkingAvatarContainer");
      d.g.b.p.h(localFrameLayout, "talkingBigAvatarLayout");
      d.g.b.p.h(paramMultiTalkMainUI, "mainUI");
      d.g.b.p.h(this, "uiCallback");
      ((com.tencent.mm.plugin.multitalk.model.a)localObject2).waf = this;
      ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wac = ((RecyclerView)localObject1);
      ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wad = localFrameLayout;
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 != null) {
        break;
      }
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutAdapter");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
      ((RelativeLayout.LayoutParams)localObject2).width = this.wgi;
      ((RelativeLayout.LayoutParams)localObject2).height = (this.wgi + com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 52) + al.jG(paramMultiTalkMainUI));
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    }
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wah = ((a)localObject1);
    localObject1 = c.weP;
    localObject1 = (Context)paramMultiTalkMainUI;
    Object localObject3 = (ViewGroup)localFrameLayout;
    Object localObject4 = (View.OnClickListener)localObject2;
    d.g.b.p.h(localObject1, "context");
    d.g.b.p.h(localObject3, "parent");
    d.g.b.p.h(localObject4, "clickListener");
    localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131494685, (ViewGroup)localObject3, false);
    if (localObject1 == null)
    {
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    localObject1 = (RelativeLayout)localObject1;
    localObject3 = new b((View)localObject1);
    Object localObject5 = ((RelativeLayout)localObject1).findViewById(2131305671);
    if (localObject5 == null)
    {
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).wex = ((MultiTalkVideoView)localObject5);
    localObject5 = ((b)localObject3).wex;
    if (localObject5 != null) {
      ((MultiTalkVideoView)localObject5).setIndex(0);
    }
    localObject5 = ((b)localObject3).wex;
    if (localObject5 != null) {
      ((MultiTalkVideoView)localObject5).setOnClickListener((View.OnClickListener)localObject4);
    }
    ((b)localObject3).gZU = ((RelativeLayout)localObject1).findViewById(2131302169);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131306487);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).wey = ((ImageView)localObject4);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131302597);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).wez = ((ImageView)localObject4);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131305577);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).weA = ((TextView)localObject4);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131301502);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).vzV = ((ImageView)localObject4);
    ((RelativeLayout)localObject1).setTag(localObject3);
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wae = ((RelativeLayout)localObject1);
    localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wae;
    if (localObject1 != null) {}
    for (localObject1 = ((RelativeLayout)localObject1).getTag(); localObject1 == null; localObject1 = null)
    {
      paramMultiTalkMainUI = new v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutHolder");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wag = ((b)localObject1);
    localFrameLayout.addView((View)((com.tencent.mm.plugin.multitalk.model.a)localObject2).wae);
    localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wae;
    if (localObject1 != null) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    localFrameLayout.setVisibility(8);
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).waj = ((com.tencent.mm.plugin.multitalk.model.i)new a.b((com.tencent.mm.plugin.multitalk.model.a)localObject2));
    localObject1 = z.dqx();
    d.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    ((o)localObject1).dpP().a(((com.tencent.mm.plugin.multitalk.model.a)localObject2).waj);
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).doJ();
    this.wgC = paramMultiTalkMainUI.findViewById(2131302582);
    this.wgD = paramMultiTalkMainUI.findViewById(2131302572);
    this.wgD.setBackground(ao.k(aj.getContext(), 2131690325, -1));
    this.wgF = ((MultiTalkControlIconLayout)this.wgM.findViewById(2131302594));
    this.wgF.setIconEnabled(z.dqx().doZ());
    this.wgF.setOnClickListener(this.wgW);
    this.wgG = ((MultiTalkControlIconLayout)this.wgM.findViewById(2131302583));
    this.wgG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178931);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        n.wbm += 1;
        paramAnonymousView = z.dqx();
        boolean bool = j.this.wgG.wfu.isChecked();
        z.dqw().wbf.zn(bool);
        paramAnonymousView.oG(bool);
        if (j.this.wgG.wfu.isChecked())
        {
          j.this.wgG.setChecked(true);
          n.dpz();
          z.dqw().oL(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178931);
          return;
          j.this.wgG.setChecked(false);
          n.dpA();
          z.dqw().oL(true);
        }
      }
    });
    this.wgH = ((MultiTalkControlIconLayout)this.wgM.findViewById(2131302579));
    this.wgH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178932);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (j.this.wgH.isEnabled())
        {
          n.wbn += 1;
          z.dqx().oU(j.this.wgH.wfu.isChecked());
          j.this.dqN();
          if (!j.this.wgH.wfu.isChecked()) {
            break label136;
          }
          j.this.wgH.setChecked(true);
          n.dpB();
          z.dqw().oK(true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178932);
          return;
          label136:
          j.this.wgH.setChecked(false);
          n.dpC();
          z.dqw().oK(false);
        }
      }
    });
    this.wgQ = ((CollapseView)paramMultiTalkMainUI.findViewById(2131300580));
    this.wgE = this.wgN.findViewById(2131302576);
    this.wgG.setChecked(z.dqx().fMP);
    this.wgH.setChecked(z.dqx().lbb);
    this.wgF.setChecked(com.tencent.mm.plugin.multitalk.model.t.KH(z.dqx().wbr));
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.wgJ) });
    this.wgg.setOnClickListener(this);
    this.wgC.bringToFront();
    this.wgC.setOnClickListener(this);
    this.wgC.setBackground(ao.k(aj.getContext(), 2131690328, -1));
    this.wgD.bringToFront();
    this.wgD.setOnClickListener(this);
    this.wgE.setOnClickListener(this);
    paramMultiTalkMainUI.findViewById(2131308161).setOnClickListener(this);
    com.tencent.mm.ak.p.aEk().a(this);
    if (com.tencent.mm.plugin.multitalk.model.t.KH(z.dqx().wbr)) {
      this.wgE.setVisibility(0);
    }
    for (;;)
    {
      dqN();
      AppMethodBeat.o(114737);
      return;
      this.wgE.setVisibility(8);
    }
  }
  
  private void al(ArrayList<MultiTalkGroupMember> paramArrayList)
  {
    AppMethodBeat.i(178937);
    int j = paramArrayList.size();
    int i = 3;
    if (j < 5) {
      i = 2;
    }
    Object localObject;
    if ((this.wfZ.bJP() != null) && (this.wfZ.bJP().findViewById(2131304253) != null))
    {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ar.ej(this.wfZ);
      this.wfZ.bJP().findViewById(2131304253).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.wac.removeAllViewsInLayout();
    if ((j > 9) || (this.wgS))
    {
      if ((!z.dqx().wbx) && (j > 12))
      {
        z.dqx().wbx = true;
        com.tencent.mm.ui.base.t.w(this.wfZ, this.wfZ.getResources().getString(2131761436), 2131690888);
      }
      dqL();
    }
    for (;;)
    {
      this.wgz.bV(i);
      this.wac.setLayoutManager(this.wgz);
      localObject = new HashSet(z.dqx().wbt);
      a locala = (a)this.wac.getAdapter();
      if (locala != null)
      {
        locala.weo = false;
        locala.d((HashSet)localObject);
        locala.a(paramArrayList, this.wbR);
      }
      if ((z.dqx().dpM()) && (this.wgF != null) && (!this.wgF.wfu.isChecked())) {
        z.dqx().KE(1);
      }
      AppMethodBeat.o(178937);
      return;
      dqK();
    }
  }
  
  private static int am(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(178939);
    if (paramArrayList.size() <= 0)
    {
      AppMethodBeat.o(178939);
      return -1;
    }
    int j = paramArrayList.size();
    int[] arrayOfInt = new int[j];
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      int k = ((Integer)paramArrayList.get(i)).intValue();
      localStringBuilder.append(k).append(",");
      arrayOfInt[i] = k;
      i += 1;
    }
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = ByteBuffer.allocate(j * 4);
    paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(arrayOfInt);
    paramArrayList = paramArrayList.array();
    i = z.dqw().wbf.setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
      n.dpw();
      AppMethodBeat.o(178939);
      return -1;
    }
    AppMethodBeat.o(178939);
    return i;
  }
  
  private void aq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(206598);
    this.titleTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.cjg.stopTimer();
      this.cjg.removeCallbacksAndMessages(null);
      if (paramBoolean) {
        this.cjg.az(5000L, 5000L);
      }
      this.fTP.setVisibility(8);
      AppMethodBeat.o(206598);
      return;
    }
    this.fTP.setVisibility(0);
    AppMethodBeat.o(206598);
  }
  
  private void dqK()
  {
    AppMethodBeat.i(206588);
    if (this.wgM.getParent() != null) {
      ((ViewGroup)this.wgM.getParent()).removeView(this.wgM);
    }
    if (this.wgN.getParent() != null) {
      ((ViewGroup)this.wgN.getParent()).removeView(this.wgN);
    }
    View localView = this.wfZ.findViewById(2131305666);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cc.a.iq(this.wfZ) * 3.6D / 100.0D));
      localView.setLayoutParams(localLayoutParams);
    }
    this.wgQ.setVisibility(4);
    this.wgK.addView(this.wgM);
    this.wgL.addView(this.wgN);
    AppMethodBeat.o(206588);
  }
  
  private void dqL()
  {
    AppMethodBeat.i(206589);
    if (this.wgS)
    {
      AppMethodBeat.o(206589);
      return;
    }
    this.wgS = true;
    this.wgQ.setVisibility(0);
    this.wgQ.setCollapseContent$53599cc9(this.wgN);
    this.wgQ.ak(this.wgM, this.wfZ.bJP().findViewById(2131305666).getHeight());
    Object localObject = (RelativeLayout.LayoutParams)this.wac.getLayoutParams();
    if (this.wgi > this.wgI) {}
    for (((RelativeLayout.LayoutParams)localObject).height = (this.wgI / 3 * 5 + com.tencent.mm.cc.a.fromDPToPix(this.wfZ, 52) + al.jG(this.wfZ));; ((RelativeLayout.LayoutParams)localObject).height = (this.wgi / 3 * 5 + al.jG(this.wfZ)))
    {
      this.wac.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.wgQ.findViewById(2131304240).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = ar.ej(this.wfZ);
      this.wgQ.findViewById(2131304240).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((z.dqx().dpM()) && (this.wgF != null) && (!this.wgF.wfu.isChecked())) {
        z.dqx().KE(1);
      }
      AppMethodBeat.o(206589);
      return;
    }
  }
  
  private void dqM()
  {
    int j = 0;
    AppMethodBeat.i(178938);
    ArrayList localArrayList;
    Object localObject1;
    int k;
    Object localObject2;
    if ((this.wac.getAdapter() != null) && (this.wgz != null))
    {
      localArrayList = new ArrayList();
      localArrayList.clear();
      localObject1 = (a)this.wac.getAdapter();
      i = this.wgz.kn();
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        k = this.wgz.kp() - ((a)localObject1).sWU - ((a)localObject1).wes;
        if ((i < 0) || (k < 0)) {
          break label335;
        }
        while (i <= k)
        {
          localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((a)localObject1).wen.get(i);
          localObject2 = this.wbR.aqY(((com.tencent.mm.plugin.multitalk.data.a)localObject2).vZZ.LJH);
          if ((localObject2 != null) && (((b)localObject2).wex != null) && ((((b)localObject2).wex.dqW()) || (((b)localObject2).wex.dqX())))
          {
            int m = com.tencent.mm.plugin.multitalk.c.e.arI(((b)localObject2).wex.getUsername());
            localArrayList.add(Integer.valueOf(m));
            ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(m) });
          }
          i += 1;
        }
        i -= ((a)localObject1).sWU;
      }
      am(localArrayList);
      if ((this.wgR == null) || (!localArrayList.containsAll(this.wgR)) || (!this.wgR.containsAll(localArrayList))) {
        break label536;
      }
    }
    label536:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        k = localArrayList.size();
        localObject1 = new ArrayList();
        i = j;
        for (;;)
        {
          if (i < k)
          {
            localObject2 = new a.ao();
            ((a.ao)localObject2).oWb = ((Integer)localArrayList.get(i)).intValue();
            ((List)localObject1).add(localObject2);
            i += 1;
            continue;
            label335:
            if (this.wac.getAdapter() == null) {
              break;
            }
            localObject1 = ((a)this.wac.getAdapter()).wen.iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
              if ((((com.tencent.mm.plugin.multitalk.data.a)localObject2).wab) && (i < this.wgV))
              {
                k = com.tencent.mm.plugin.multitalk.c.e.arI(((com.tencent.mm.plugin.multitalk.data.a)localObject2).vZZ.LJH);
                localArrayList.add(Integer.valueOf(k));
                ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(k) });
              }
              if (i >= this.wgV) {
                break;
              }
              i += 1;
            }
            am(localArrayList);
            break;
          }
        }
        if (z.dqx().dpM())
        {
          ad.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(localObject1)));
          ad.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(z.dqw().wbf.iP((List)localObject1))));
        }
      }
      this.wgR = localArrayList;
      AppMethodBeat.o(178938);
      return;
    }
  }
  
  private void j(Boolean paramBoolean)
  {
    AppMethodBeat.i(206592);
    if (paramBoolean.booleanValue())
    {
      this.wgC.setBackgroundResource(2131230851);
      this.wgA.getLayoutParams().height = (com.tencent.mm.cc.a.fromDPToPix(this.wfZ, 52) + al.jG(this.wfZ));
      this.wgA.setBackgroundColor(this.wfZ.getResources().getColor(2131100208));
      this.fTP.setVisibility(4);
      this.wgD.setVisibility(4);
      AppMethodBeat.o(206592);
      return;
    }
    this.wgC.setBackground(ao.k(aj.getContext(), 2131690328, -1));
    this.wgA.getLayoutParams().height = com.tencent.mm.cc.a.g(this.wfZ, this.wfZ.getResources().getDimension(2131166563));
    this.wgA.setBackground(this.wfZ.getResources().getDrawable(2131233387));
    this.fTP.setVisibility(0);
    this.wgD.setVisibility(0);
    AppMethodBeat.o(206592);
  }
  
  private void n(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(178936);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = null;
    Iterator localIterator = paramMultiTalkGroup.LJG.iterator();
    Object localObject2;
    int i;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
      {
        localObject2 = localMultiTalkGroupMember;
        if (!localMultiTalkGroupMember.LJH.equals(u.aAm()))
        {
          i = com.tencent.mm.plugin.multitalk.c.e.arI(localMultiTalkGroupMember.LJH);
          if (i == -1)
          {
            localArrayList2.add(localMultiTalkGroupMember);
            continue;
          }
          localArrayList1.add(new b(localMultiTalkGroupMember, i));
        }
      }
      else
      {
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      localArrayList2.add(localObject1);
    }
    localObject1 = new ArrayList();
    int j = 0;
    int k;
    if (j < localArrayList1.size())
    {
      i = 0;
      k = 0;
      label191:
      if (k < localArrayList1.size())
      {
        if (((b)localArrayList1.get(j)).oWb <= ((b)localArrayList1.get(k)).oWb) {
          break label423;
        }
        localObject2 = (b)localArrayList1.get(j);
        localArrayList1.set(j, localArrayList1.get(k));
        localArrayList1.set(k, localObject2);
        i = 1;
      }
    }
    label423:
    for (;;)
    {
      k += 1;
      break label191;
      if (i != 0)
      {
        j += 1;
        break;
      }
      i = localArrayList1.size() - 1;
      while (i >= 0)
      {
        ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { ((b)localArrayList1.get(i)).oWb + "/n" });
        ((ArrayList)localObject1).add(((b)localArrayList1.get(i)).whf);
        i -= 1;
      }
      if ((this.wgQ != null) && (!com.tencent.mm.plugin.multitalk.model.t.j(paramMultiTalkGroup).equals(paramMultiTalkGroup.LJD))) {
        this.wgQ.setRoomKey(com.tencent.mm.plugin.multitalk.model.t.j(paramMultiTalkGroup));
      }
      ((ArrayList)localObject1).addAll(localArrayList2);
      al((ArrayList)localObject1);
      AppMethodBeat.o(178936);
      return;
    }
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(114753);
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    com.tencent.mm.plugin.multitalk.model.a locala = this.wbR;
    d.g.b.p.h(paramString, "wxUserName");
    paramString = locala.aqY(paramString);
    if (paramString != null)
    {
      paramString = paramString.wex;
      if (paramString != null)
      {
        paramString.dqO();
        AppMethodBeat.o(114753);
        return;
      }
      AppMethodBeat.o(114753);
      return;
    }
    AppMethodBeat.o(114753);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114749);
    if (!z.dqx().dpM())
    {
      pa(false);
      AppMethodBeat.o(114749);
      return;
    }
    if (this.wha.whe == null)
    {
      this.wha.w = paramInt1;
      this.wha.h = paramInt2;
      this.wha.whe = new int[this.wha.w * this.wha.h];
    }
    if (!com.tencent.mm.plugin.multitalk.model.t.KH(z.dqx().wbr)) {
      z.dqx().KE(3);
    }
    long l1 = System.currentTimeMillis();
    z.dqx().wbs = this.wgO.eAm();
    int j;
    if (this.wgO.eAm())
    {
      j = OpenGlRender.FLAG_Mirror;
      if (!this.wgO.eAn()) {
        break label263;
      }
    }
    g localg;
    label263:
    for (int k = OpenGlRender.FLAG_Angle270;; k = OpenGlRender.FLAG_Angle90)
    {
      localg = z.dqw().wbf.a(paramArrayOfByte, (int)paramLong, this.wha.w, this.wha.h, paramInt3 + paramInt4 & 0x1F, this.wha.whe);
      if ((localg.ret >= 0) && (this.wha.whe != null) && (localg.LJR != 0) && (localg.LJS != 0)) {
        break label271;
      }
      ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[] { Integer.valueOf(localg.ret) });
      AppMethodBeat.o(114749);
      return;
      j = 0;
      break;
    }
    label271:
    long l2 = System.currentTimeMillis();
    int i;
    if (j == OpenGlRender.FLAG_Mirror)
    {
      i = 257;
      if (!z.dqx().wbJ) {
        break label508;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label502;
      }
      i = 259;
    }
    label502:
    label508:
    for (;;)
    {
      paramInt1 = z.dqx().dpQ().b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = System.currentTimeMillis();
      long l3 = paramLong - l1;
      if (l3 > 30L) {
        ad.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(localg.LJR), Integer.valueOf(localg.LJS), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(paramLong - l2) });
      }
      if (paramInt1 <= 0) {
        ad.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (this.wha.whe != null) {
        z.dqx().dpS().a(u.aAm(), this.wha.whe, localg.LJR, localg.LJS, j, k);
      }
      AppMethodBeat.o(114749);
      return;
      i = 1;
      break;
      i = 3;
    }
  }
  
  public final void bZW()
  {
    AppMethodBeat.i(114752);
    ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
    if (this.juf == null) {
      this.juf = com.tencent.mm.bi.e.a(this.wfZ, 2131764896, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206587);
          j.this.pa(false);
          AppMethodBeat.o(206587);
        }
      });
    }
    if (!this.juf.isShowing()) {
      this.juf.show();
    }
    z.dqx().KE(1);
    AppMethodBeat.o(114752);
  }
  
  public final void bx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206597);
    if (TextUtils.isEmpty(paramString))
    {
      aq(8, paramBoolean);
      AppMethodBeat.o(206597);
      return;
    }
    this.titleTv.setText(paramString);
    aq(0, paramBoolean);
    AppMethodBeat.o(206597);
  }
  
  public final int[] doN()
  {
    return new int[] { this.wgI, this.wgJ };
  }
  
  public final int doO()
  {
    AppMethodBeat.i(206602);
    int i = al.jG(this.wfZ);
    AppMethodBeat.o(206602);
    return i;
  }
  
  public final boolean doP()
  {
    AppMethodBeat.i(206601);
    if ((ay.is2G(this.wfZ)) || (ay.is3G(this.wfZ)))
    {
      AppMethodBeat.o(206601);
      return true;
    }
    AppMethodBeat.o(206601);
    return false;
  }
  
  public final void doQ()
  {
    AppMethodBeat.i(206590);
    this.wgD.setVisibility(0);
    this.wgC.setVisibility(0);
    AppMethodBeat.o(206590);
  }
  
  public final void doR()
  {
    AppMethodBeat.i(206591);
    this.wgD.setVisibility(8);
    this.wgC.setVisibility(8);
    AppMethodBeat.o(206591);
  }
  
  public final void doS()
  {
    AppMethodBeat.i(206595);
    j(Boolean.TRUE);
    dqL();
    this.wgF.setIconEnabled(false);
    this.wgF.setOnClickListener(null);
    this.wgE.setVisibility(4);
    AppMethodBeat.o(206595);
  }
  
  public final void doT()
  {
    AppMethodBeat.i(206596);
    j(Boolean.FALSE);
    this.wgF.setIconEnabled(true);
    this.wgF.setOnClickListener(this.wgW);
    this.wgE.setVisibility(0);
    AppMethodBeat.o(206596);
  }
  
  public final void doU()
  {
    AppMethodBeat.i(206594);
    if (this.wgU)
    {
      AppMethodBeat.o(206594);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation2.setDuration(150L);
    this.wgU = true;
    this.wgA.setAnimation(localAlphaAnimation1);
    this.wgA.setVisibility(0);
    this.wgy.setAnimation(localAlphaAnimation1);
    this.wgy.setVisibility(0);
    this.wgQ.setAnimation(localAlphaAnimation2);
    this.wgQ.setVisibility(0);
    AppMethodBeat.o(206594);
  }
  
  public final void doV()
  {
    AppMethodBeat.i(206593);
    if (!this.wgU)
    {
      AppMethodBeat.o(206593);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation1.setDuration(150L);
    this.wgU = false;
    this.wgA.setAnimation(localAlphaAnimation2);
    this.wgA.setVisibility(4);
    this.wgy.setAnimation(localAlphaAnimation2);
    this.wgy.setVisibility(4);
    this.wgQ.setAnimation(localAlphaAnimation1);
    this.wgQ.setVisibility(4);
    AppMethodBeat.o(206593);
  }
  
  public final boolean doW()
  {
    return this.wgO != null;
  }
  
  public final void dqN()
  {
    AppMethodBeat.i(114756);
    if (this.wgH.isEnabled()) {
      z.dqx().oW(this.wgH.wfu.isChecked());
    }
    AppMethodBeat.o(114756);
  }
  
  public final void e(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114744);
    this.wbR.n(paramHashSet);
    dqM();
    AppMethodBeat.o(114744);
  }
  
  public final void m(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114738);
    if (!this.wbR.doK())
    {
      this.wgB.setVisibility(0);
      this.wgF.setIconEnabled(z.dqx().doZ());
      this.wgD.setVisibility(0);
    }
    n(paramMultiTalkGroup);
    dqN();
    AppMethodBeat.o(114738);
  }
  
  public final void oZ(boolean paramBoolean)
  {
    AppMethodBeat.i(206599);
    if (!paramBoolean) {
      this.wgZ = System.currentTimeMillis();
    }
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    if (this.wgP == null)
    {
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
      this.wgP = new ObservableTextureView(this.wfZ);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(1, 1);
      this.wgP.setLayoutParams(localLayoutParams);
      this.wfZ.bJP().addView(this.wgP);
      this.wgP.setVisibility(0);
    }
    if (this.wgO == null)
    {
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
      this.wgO = new com.tencent.mm.plugin.voip.video.a(640, 480);
      this.wgO.a(this, z.dqx().wbs);
      this.wgO.a(this.wgP);
      this.wgO.eAk();
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.wgO.eAm()), Boolean.valueOf(this.wgO.eAn()) });
    }
    AppMethodBeat.o(206599);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114743);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    if (!this.gFv)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
    }
    if (paramView.getId() == 2131305667) {
      z.dqx().h(true, false, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
      Object localObject2;
      if (paramView.getId() == 2131302582)
      {
        if (this.wbR.doK())
        {
          doQ();
          paramView = this.wbR;
          localObject1 = paramView.wad;
          if ((localObject1 != null) && (((FrameLayout)localObject1).getVisibility() == 0))
          {
            localObject1 = paramView.wag;
            if (localObject1 != null)
            {
              localObject1 = ((b)localObject1).wex;
              if (localObject1 != null)
              {
                localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
                if (localObject1 != null)
                {
                  localObject2 = z.dqx();
                  d.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
                  localObject2 = ((o)localObject2).dpP();
                  d.g.b.p.g(localObject1, "it");
                  int i = ((r)localObject2).arA((String)localObject1);
                  if ((i == 103) || (i == 100)) {
                    paramView.doM();
                  } else {
                    paramView.eq((String)localObject1, 3);
                  }
                }
              }
            }
          }
        }
        else
        {
          n.wbl += 1;
          z.dqx().oT(true);
          n.dpG();
        }
      }
      else if (paramView.getId() == 2131302576)
      {
        if (this.wgO != null) {
          this.wgO.eAi();
        }
        n.dpF();
      }
      else if (paramView.getId() == 2131302572)
      {
        n.wbo += 1;
        paramView = this.wfZ;
        if (!paramView.wdU)
        {
          paramView.wdU = true;
          localObject1 = new Intent(paramView, MultiTalkAddMembersUI.class);
          localObject2 = new ArrayList();
          if (z.dqx().wbv != null)
          {
            Iterator localIterator = z.dqx().wbv.LJG.iterator();
            while (localIterator.hasNext())
            {
              MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
              if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
                ((List)localObject2).add(localMultiTalkGroupMember.LJH);
              }
            }
            ((Intent)localObject1).putExtra("titile", paramView.getString(2131761389));
            ((Intent)localObject1).putExtra("chatroomName", z.dqx().wbv.LJE);
            ((Intent)localObject1).putExtra("always_select_contact", bt.m((List)localObject2, ","));
            ((Intent)localObject1).putExtra("key_need_gallery", false);
            paramView.startActivityForResult((Intent)localObject1, 1);
          }
        }
      }
      else if (paramView.getId() == 2131308161)
      {
        if (!this.wgX)
        {
          this.wgX = true;
          z.dqx().dpQ().oX(false);
          if (this.wgO == null) {
            oZ(false);
          }
          this.wgO.eAj();
          z.dqx().dpP();
          r.KG(101);
        }
        else
        {
          this.wgX = false;
          z.dqx().dpQ().oX(true);
          pa(false);
          z.dqx().KE(1);
          z.dqx().dpP();
          r.KG(103);
        }
      }
    }
  }
  
  public final void pa(boolean paramBoolean)
  {
    AppMethodBeat.i(206600);
    if ((!paramBoolean) && (this.wgZ != 0L) && (System.currentTimeMillis() - this.wgZ > 0L) && (z.dqx().doZ()))
    {
      n.v(System.currentTimeMillis() - this.wgZ, com.tencent.mm.plugin.multitalk.model.t.dql());
      this.wgZ = 0L;
    }
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
    if (this.wgP != null)
    {
      ViewParent localViewParent = this.wgP.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.wgP);
      }
      this.wgP = null;
    }
    if (this.wgO != null)
    {
      this.wgO.eAl();
      this.wgO = null;
    }
    AppMethodBeat.o(206600);
  }
  
  public final void pb(boolean paramBoolean)
  {
    AppMethodBeat.i(114748);
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    this.cjg.stopTimer();
    this.cjg.removeCallbacksAndMessages(null);
    this.cjg.quitSafely();
    if (!paramBoolean)
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178935);
          j.e(j.this).setText(2131761392);
          AppMethodBeat.o(178935);
        }
      });
      z.dqx().dpP().close();
    }
    pa(false);
    this.wbR.gg(paramBoolean);
    com.tencent.mm.ak.p.aEk().b(this);
    ax localax = ax.aQz("multi_talk_config");
    if (localax.getBoolean("has_opened_screen_cast", false)) {
      localax.putBoolean("has_showed_tip_window", false);
    }
    AppMethodBeat.o(114748);
  }
  
  final class a
  {
    int h;
    int w;
    int[] whe;
    
    private a() {}
  }
  
  final class b
  {
    int oWb;
    MultiTalkGroupMember whf;
    
    b(MultiTalkGroupMember paramMultiTalkGroupMember, int paramInt)
    {
      this.whf = paramMultiTalkGroupMember;
      this.oWb = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */