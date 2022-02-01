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
import com.tencent.mm.aj.e.a;
import com.tencent.mm.plugin.multitalk.b.p.31;
import com.tencent.mm.plugin.multitalk.b.p.33;
import com.tencent.mm.plugin.multitalk.b.p.34;
import com.tencent.mm.plugin.multitalk.b.u;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
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
  private aw cji;
  public TextView fVV;
  public boolean gIc;
  com.tencent.mm.ui.widget.a.d jxa;
  private TextView titleTv;
  private RecyclerView wpB;
  public com.tencent.mm.plugin.multitalk.model.a wrp;
  MultiTalkMainUI wvC;
  private ImageButton wvJ;
  private boolean wvK;
  private int wvL;
  private boolean wwA;
  private boolean wwB;
  public long wwC;
  a wwD;
  private final View wwb;
  private GridLayoutManager wwc;
  private View wwd;
  public View wwe;
  private View wwf;
  public View wwg;
  public View wwh;
  public MultiTalkControlIconLayout wwi;
  public MultiTalkControlIconLayout wwj;
  public MultiTalkControlIconLayout wwk;
  private int wwl;
  private int wwm;
  private RelativeLayout wwn;
  private RelativeLayout wwo;
  private LinearLayout wwp;
  private RelativeLayout wwq;
  private com.tencent.mm.plugin.voip.video.a wwr;
  private ObservableTextureView wws;
  private CollapseView wwt;
  private ArrayList<Integer> wwu;
  private boolean wwv;
  private boolean www;
  private boolean wwx;
  private int wwy;
  View.OnClickListener wwz;
  
  public j(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114737);
    this.wwu = new ArrayList();
    this.wwv = false;
    this.www = false;
    this.wwx = true;
    this.wwy = (e.b.FbO * e.b.FbN);
    this.wvL = 0;
    this.wwz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178933);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        n.vGi += 1;
        paramAnonymousView = j.this;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramAnonymousView.wvC.getContext(), "android.permission.CAMERA", 22, "", "");
        ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), paramAnonymousView.wvC.getContext() });
        if (!bool)
        {
          j.this.wwi.setChecked(false);
          n.dsG();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!z.dtK().dsY())
        {
          j.this.wwi.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!z.dtK().dsj())
        {
          j.this.wwi.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!az.isNetworkConnected(j.this.wvC))
        {
          com.tencent.mm.bh.e.a(j.this.wvC, 2131764895, null);
          j.this.wwi.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.t.dtB())
        {
          Toast.makeText(j.this.wvC, 2131761391, 1).show();
          j.this.wwi.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (j.this.wwi.wuX.isChecked())
        {
          j.this.wwi.setChecked(true);
          j.this.ph(false);
          n.dsO();
          paramAnonymousView = com.tencent.mm.plugin.multitalk.b.p.wmO;
          ae.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStart");
          paramAnonymousView.ad(new p.33(paramAnonymousView));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
          j.this.wwi.setChecked(false);
          j.this.pi(false);
          z.dtK().Lj(1);
          n.dsP();
          paramAnonymousView = com.tencent.mm.plugin.multitalk.b.p.wmO;
          ae.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStop");
          paramAnonymousView.ad(new p.34(paramAnonymousView));
        }
      }
    };
    this.wwA = false;
    this.wwB = false;
    this.cji = new aw("MultiTalkTimer", new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(190817);
        h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190816);
            j.c(j.this).setVisibility(8);
            j.d(j.this).setVisibility(0);
            AppMethodBeat.o(190816);
          }
        });
        AppMethodBeat.o(190817);
        return true;
      }
    }, false);
    this.wwD = new a((byte)0);
    this.jxa = null;
    this.gIc = true;
    this.wvC = paramMultiTalkMainUI;
    this.wwl = com.tencent.mm.cb.a.iu(paramMultiTalkMainUI.getContext());
    this.wwm = (this.wwl + com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 52) + al.jN(paramMultiTalkMainUI));
    this.fVV = ((TextView)paramMultiTalkMainUI.findViewById(2131305822));
    this.wwd = paramMultiTalkMainUI.findViewById(2131306007);
    this.titleTv = ((TextView)paramMultiTalkMainUI.findViewById(2131305948));
    this.wwe = paramMultiTalkMainUI.findViewById(2131305668);
    this.wvL = (com.tencent.mm.cb.a.iv(paramMultiTalkMainUI) - com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 285));
    this.wwn = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131298785));
    this.wwo = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131300676));
    this.wwp = ((LinearLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494971, null, false));
    this.wwq = ((RelativeLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494970, null, false));
    this.wvJ = ((ImageButton)this.wwq.findViewById(2131305667));
    this.wpB = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131305669));
    FrameLayout localFrameLayout = (FrameLayout)paramMultiTalkMainUI.findViewById(2131305665);
    this.wrp = z.dtK().dtf();
    this.wwb = paramMultiTalkMainUI.findViewById(2131306002);
    Object localObject1 = (RelativeLayout.LayoutParams)this.wwb.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).topMargin = (al.jN(paramMultiTalkMainUI) + com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 12));
    this.wwb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)localFrameLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).topMargin = (com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 52) + al.jN(paramMultiTalkMainUI));
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.wwc = new GridLayoutManager(3);
    localObject1 = new a(paramMultiTalkMainUI);
    this.wpB.setLayoutManager(this.wwc);
    this.wwc.apF = new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(178928);
        if (this.wwE.Lo(paramAnonymousInt))
        {
          paramAnonymousInt = j.a(j.this).apA;
          AppMethodBeat.o(178928);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(178928);
        return 1;
      }
    };
    Object localObject2 = (RelativeLayout.LayoutParams)this.wpB.getLayoutParams();
    if (this.wvL > this.wwl)
    {
      ((RelativeLayout.LayoutParams)localObject2).width = this.wwl;
      ((RelativeLayout.LayoutParams)localObject2).height = this.wwm;
    }
    for (;;)
    {
      this.wpB.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((a)localObject1).wtW = this.wrp;
      this.wpB.setAdapter((RecyclerView.a)localObject1);
      this.wpB.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt1);
          localb.mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
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
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (j.b(j.this)))
          {
            j.this.pg(false);
            n.oW(true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178929);
        }
      });
      localObject2 = this.wrp;
      localObject1 = this.wpB;
      d.g.b.p.h(localObject1, "talkingAvatarContainer");
      d.g.b.p.h(localFrameLayout, "talkingBigAvatarLayout");
      d.g.b.p.h(paramMultiTalkMainUI, "mainUI");
      d.g.b.p.h(this, "uiCallback");
      ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpE = this;
      ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpB = ((RecyclerView)localObject1);
      ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpC = localFrameLayout;
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 != null) {
        break;
      }
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutAdapter");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
      ((RelativeLayout.LayoutParams)localObject2).width = this.wvL;
      ((RelativeLayout.LayoutParams)localObject2).height = (this.wvL + com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 52) + al.jN(paramMultiTalkMainUI));
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    }
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpG = ((a)localObject1);
    localObject1 = c.wus;
    localObject1 = (Context)paramMultiTalkMainUI;
    Object localObject3 = (ViewGroup)localFrameLayout;
    Object localObject4 = (View.OnClickListener)localObject2;
    d.g.b.p.h(localObject1, "context");
    d.g.b.p.h(localObject3, "parent");
    d.g.b.p.h(localObject4, "clickListener");
    localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131494685, (ViewGroup)localObject3, false);
    if (localObject1 == null)
    {
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    localObject1 = (RelativeLayout)localObject1;
    localObject3 = new b((View)localObject1);
    Object localObject5 = ((RelativeLayout)localObject1).findViewById(2131305671);
    if (localObject5 == null)
    {
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).wua = ((MultiTalkVideoView)localObject5);
    localObject5 = ((b)localObject3).wua;
    if (localObject5 != null) {
      ((MultiTalkVideoView)localObject5).setIndex(0);
    }
    localObject5 = ((b)localObject3).wua;
    if (localObject5 != null) {
      ((MultiTalkVideoView)localObject5).setOnClickListener((View.OnClickListener)localObject4);
    }
    ((b)localObject3).hcH = ((RelativeLayout)localObject1).findViewById(2131302169);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131306487);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).wub = ((ImageView)localObject4);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131302597);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).wuc = ((ImageView)localObject4);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131305577);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).wud = ((TextView)localObject4);
    localObject4 = ((RelativeLayout)localObject1).findViewById(2131301502);
    if (localObject4 == null)
    {
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((b)localObject3).vLZ = ((ImageView)localObject4);
    ((RelativeLayout)localObject1).setTag(localObject3);
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpD = ((RelativeLayout)localObject1);
    localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpD;
    if (localObject1 != null) {}
    for (localObject1 = ((RelativeLayout)localObject1).getTag(); localObject1 == null; localObject1 = null)
    {
      paramMultiTalkMainUI = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.AvatarLayoutHolder");
      AppMethodBeat.o(114737);
      throw paramMultiTalkMainUI;
    }
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpF = ((b)localObject1);
    localFrameLayout.addView((View)((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpD);
    localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpD;
    if (localObject1 != null) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    localFrameLayout.setVisibility(8);
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpI = ((com.tencent.mm.plugin.multitalk.model.i)new a.b((com.tencent.mm.plugin.multitalk.model.a)localObject2));
    localObject1 = z.dtK();
    d.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    ((o)localObject1).dtb().a(((com.tencent.mm.plugin.multitalk.model.a)localObject2).wpI);
    ((com.tencent.mm.plugin.multitalk.model.a)localObject2).drS();
    this.wwf = paramMultiTalkMainUI.findViewById(2131302582);
    this.wwg = paramMultiTalkMainUI.findViewById(2131302572);
    this.wwg.setBackground(ao.k(ak.getContext(), 2131690325, -1));
    this.wwi = ((MultiTalkControlIconLayout)this.wwp.findViewById(2131302594));
    this.wwi.setIconEnabled(z.dtK().dsj());
    this.wwi.setOnClickListener(this.wwz);
    this.wwj = ((MultiTalkControlIconLayout)this.wwp.findViewById(2131302583));
    this.wwj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178931);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        n.wqL += 1;
        paramAnonymousView = z.dtK();
        boolean bool = j.this.wwj.wuX.isChecked();
        if (paramAnonymousView.dsX())
        {
          localObject = com.tencent.mm.plugin.multitalk.b.p.wmO;
          ae.i("MicroMsg.Multitalk.ILinkService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(bool) });
          ((com.tencent.mm.plugin.multitalk.b.p)localObject).ad(new p.31((com.tencent.mm.plugin.multitalk.b.p)localObject, bool));
          paramAnonymousView.oN(bool);
          if (!j.this.wwj.wuX.isChecked()) {
            break label177;
          }
          j.this.wwj.setChecked(true);
          n.dsK();
          z.dtJ().oS(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178931);
          return;
          z.dtJ().wqE.zB(bool);
          break;
          label177:
          j.this.wwj.setChecked(false);
          n.dsL();
          z.dtJ().oS(true);
        }
      }
    });
    this.wwk = ((MultiTalkControlIconLayout)this.wwp.findViewById(2131302579));
    this.wwk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178932);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (j.this.wwk.isEnabled())
        {
          n.wqM += 1;
          z.dtK().pb(j.this.wwk.wuX.isChecked());
          j.this.dtZ();
          if (!j.this.wwk.wuX.isChecked()) {
            break label136;
          }
          j.this.wwk.setChecked(true);
          n.dsM();
          z.dtJ().oR(true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178932);
          return;
          label136:
          j.this.wwk.setChecked(false);
          n.dsN();
          z.dtJ().oR(false);
        }
      }
    });
    this.wwt = ((CollapseView)paramMultiTalkMainUI.findViewById(2131300580));
    this.wwh = this.wwq.findViewById(2131302576);
    this.wwj.setChecked(z.dtK().fOX);
    this.wwk.setChecked(z.dtK().leL);
    this.wwi.setChecked(com.tencent.mm.plugin.multitalk.model.t.Lm(z.dtK().wqQ));
    ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.wwm) });
    this.wvJ.setOnClickListener(this);
    this.wwf.bringToFront();
    this.wwf.setOnClickListener(this);
    this.wwf.setBackground(ao.k(ak.getContext(), 2131690328, -1));
    this.wwg.bringToFront();
    this.wwg.setOnClickListener(this);
    this.wwh.setOnClickListener(this);
    paramMultiTalkMainUI.findViewById(2131308161).setOnClickListener(this);
    com.tencent.mm.aj.p.aEA().a(this);
    if (com.tencent.mm.plugin.multitalk.model.t.Lm(z.dtK().wqQ)) {
      this.wwh.setVisibility(0);
    }
    for (;;)
    {
      dtZ();
      AppMethodBeat.o(114737);
      return;
      this.wwh.setVisibility(8);
    }
  }
  
  private void am(ArrayList<MultiTalkGroupMember> paramArrayList)
  {
    AppMethodBeat.i(178937);
    int j = paramArrayList.size();
    int i = 3;
    if (j < 5) {
      i = 2;
    }
    Object localObject;
    if ((this.wvC.bKN() != null) && (this.wvC.bKN().findViewById(2131304253) != null))
    {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.ui.ar.en(this.wvC);
      this.wvC.bKN().findViewById(2131304253).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.wpB.removeAllViewsInLayout();
    if ((j > 9) || (this.wwv))
    {
      if ((!z.dtK().wqW) && (j > 12))
      {
        z.dtK().wqW = true;
        com.tencent.mm.ui.base.t.v(this.wvC, this.wvC.getResources().getString(2131761436), 2131690888);
      }
      dtY();
    }
    for (;;)
    {
      this.wwc.bV(i);
      this.wpB.setLayoutManager(this.wwc);
      localObject = new HashSet(z.dtK().wqS);
      a locala = (a)this.wpB.getAdapter();
      if (locala != null)
      {
        locala.wtR = false;
        locala.d((HashSet)localObject);
        locala.a(paramArrayList, this.wrp);
      }
      if ((z.dtK().dsY()) && (this.wwi != null) && (!this.wwi.wuX.isChecked())) {
        z.dtK().Lj(1);
      }
      AppMethodBeat.o(178937);
      return;
      dtX();
    }
  }
  
  private static int an(ArrayList<Integer> paramArrayList)
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
    ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = ByteBuffer.allocate(j * 4);
    paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(arrayOfInt);
    paramArrayList = paramArrayList.array();
    i = z.dtJ().wqE.setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      ae.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
      n.dsH();
      AppMethodBeat.o(178939);
      return -1;
    }
    AppMethodBeat.o(178939);
    return i;
  }
  
  private void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190830);
    this.titleTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.cji.stopTimer();
      this.cji.removeCallbacksAndMessages(null);
      if (paramBoolean) {
        this.cji.ay(5000L, 5000L);
      }
      this.fVV.setVisibility(8);
      AppMethodBeat.o(190830);
      return;
    }
    this.fVV.setVisibility(0);
    AppMethodBeat.o(190830);
  }
  
  private void dtX()
  {
    AppMethodBeat.i(190819);
    if (this.wwp.getParent() != null) {
      ((ViewGroup)this.wwp.getParent()).removeView(this.wwp);
    }
    if (this.wwq.getParent() != null) {
      ((ViewGroup)this.wwq.getParent()).removeView(this.wwq);
    }
    View localView = this.wvC.findViewById(2131305666);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cb.a.iv(this.wvC) * 3.6D / 100.0D));
      localView.setLayoutParams(localLayoutParams);
    }
    this.wwt.setVisibility(4);
    this.wwn.addView(this.wwp);
    this.wwo.addView(this.wwq);
    AppMethodBeat.o(190819);
  }
  
  private void dtY()
  {
    AppMethodBeat.i(190820);
    if (this.wwv)
    {
      AppMethodBeat.o(190820);
      return;
    }
    this.wwv = true;
    this.wwt.setVisibility(0);
    this.wwt.setCollapseContent$53599cc9(this.wwq);
    this.wwt.ak(this.wwp, this.wvC.bKN().findViewById(2131305666).getHeight());
    Object localObject = (RelativeLayout.LayoutParams)this.wpB.getLayoutParams();
    if (this.wvL > this.wwl) {}
    for (((RelativeLayout.LayoutParams)localObject).height = (this.wwl / 3 * 5 + com.tencent.mm.cb.a.fromDPToPix(this.wvC, 52) + al.jN(this.wvC));; ((RelativeLayout.LayoutParams)localObject).height = (this.wvL / 3 * 5 + al.jN(this.wvC)))
    {
      this.wpB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.wwt.findViewById(2131304240).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.ui.ar.en(this.wvC);
      this.wwt.findViewById(2131304240).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((z.dtK().dsY()) && (this.wwi != null) && (!this.wwi.wuX.isChecked())) {
        z.dtK().Lj(1);
      }
      AppMethodBeat.o(190820);
      return;
    }
  }
  
  private void j(Boolean paramBoolean)
  {
    AppMethodBeat.i(190824);
    if (paramBoolean.booleanValue())
    {
      this.wwf.setBackgroundResource(2131230851);
      this.wwd.getLayoutParams().height = (com.tencent.mm.cb.a.fromDPToPix(this.wvC, 52) + al.jN(this.wvC));
      this.wwd.setBackgroundColor(this.wvC.getResources().getColor(2131100208));
      this.fVV.setVisibility(4);
      this.wwg.setVisibility(4);
      AppMethodBeat.o(190824);
      return;
    }
    this.wwf.setBackground(ao.k(ak.getContext(), 2131690328, -1));
    this.wwd.getLayoutParams().height = com.tencent.mm.cb.a.h(this.wvC, this.wvC.getResources().getDimension(2131166563));
    this.wwd.setBackground(this.wvC.getResources().getDrawable(2131233387));
    this.fVV.setVisibility(0);
    this.wwg.setVisibility(0);
    AppMethodBeat.o(190824);
  }
  
  private void o(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(178936);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = null;
    Iterator localIterator = paramMultiTalkGroup.MgI.iterator();
    Object localObject2;
    int i;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
      {
        localObject2 = localMultiTalkGroupMember;
        if (!localMultiTalkGroupMember.MgJ.equals(com.tencent.mm.model.v.aAC()))
        {
          i = com.tencent.mm.plugin.multitalk.d.e.asV(localMultiTalkGroupMember.MgJ);
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
        if (((b)localArrayList1.get(j)).pcE <= ((b)localArrayList1.get(k)).pcE) {
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
        ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { ((b)localArrayList1.get(i)).pcE + "/n" });
        ((ArrayList)localObject1).add(((b)localArrayList1.get(i)).wwI);
        i -= 1;
      }
      if ((this.wwt != null) && (!com.tencent.mm.plugin.multitalk.model.t.k(paramMultiTalkGroup).equals(paramMultiTalkGroup.MgG))) {
        this.wwt.setRoomKey(com.tencent.mm.plugin.multitalk.model.t.k(paramMultiTalkGroup));
      }
      ((ArrayList)localObject1).addAll(localArrayList2);
      am((ArrayList)localObject1);
      AppMethodBeat.o(178936);
      return;
    }
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(114753);
    ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    com.tencent.mm.plugin.multitalk.model.a locala = this.wrp;
    d.g.b.p.h(paramString, "wxUserName");
    paramString = locala.asg(paramString);
    if (paramString != null)
    {
      paramString = paramString.wua;
      if (paramString != null)
      {
        paramString.dua();
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
    if (!z.dtK().dsY())
    {
      pi(false);
      AppMethodBeat.o(114749);
      return;
    }
    if (this.wwD.wwH == null)
    {
      this.wwD.w = paramInt1;
      this.wwD.h = paramInt2;
      this.wwD.wwH = new int[this.wwD.w * this.wwD.h];
    }
    boolean bool = z.dtK().dsX();
    if (!com.tencent.mm.plugin.multitalk.model.t.Lm(z.dtK().wqQ)) {
      z.dtK().Lj(3);
    }
    long l2 = System.currentTimeMillis();
    z.dtK().wqR = this.wwr.eDU();
    int j;
    int k;
    if (this.wwr.eDU())
    {
      j = OpenGlRender.FLAG_Mirror;
      if (!this.wwr.eDV()) {
        break label273;
      }
      k = OpenGlRender.FLAG_Angle270;
    }
    label273:
    int i;
    for (;;)
    {
      if (bool)
      {
        localObject = com.tencent.mm.plugin.multitalk.b.p.wmO;
        localObject = com.tencent.mm.plugin.multitalk.b.p.a(paramArrayOfByte, (int)paramLong, this.wwD.w, this.wwD.h, paramInt3 + paramInt4 & 0x1F, this.wwD.wwH);
        if ((((u)localObject).ret < 0) || (this.wwD.wwH == null) || (((u)localObject).wpy == 0) || (((u)localObject).wpz == 0))
        {
          ae.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ilink mv ret: %d", new Object[] { Integer.valueOf(((u)localObject).ret) });
          AppMethodBeat.o(114749);
          return;
          j = 0;
          break;
          k = OpenGlRender.FLAG_Angle90;
          continue;
        }
        i = ((u)localObject).wpy;
        m = ((u)localObject).wpz;
        if (!com.tencent.mm.plugin.multitalk.b.p.wmO.wmS.isStarted())
        {
          AppMethodBeat.o(114749);
          return;
        }
        paramLong = System.currentTimeMillis();
        paramInt2 = com.tencent.mm.plugin.multitalk.b.p.wmO.g(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
        paramInt1 = m;
        paramInt3 = i;
        l1 = System.currentTimeMillis();
        long l3 = l1 - l2;
        if (l3 > 30L) {
          ae.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Long.valueOf(l3), Long.valueOf(paramLong - l2), Long.valueOf(l1 - paramLong) });
        }
        if (paramInt2 <= 0) {
          ae.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[] { Integer.valueOf(paramInt2) });
        }
        if (this.wwD.wwH != null) {
          z.dtK().dte().a(com.tencent.mm.model.v.aAC(), this.wwD.wwH, paramInt3, paramInt1, j, k);
        }
        AppMethodBeat.o(114749);
        return;
      }
    }
    Object localObject = z.dtJ().wqE.b(paramArrayOfByte, (int)paramLong, this.wwD.w, this.wwD.h, paramInt3 + paramInt4 & 0x1F, this.wwD.wwH);
    if ((((g)localObject).ret < 0) || (this.wwD.wwH == null) || (((g)localObject).wpy == 0) || (((g)localObject).wpz == 0))
    {
      ae.e("MicroMsg.MT.MultiTalkTalkingUILogic", "mv ret: %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      AppMethodBeat.o(114749);
      return;
    }
    int m = ((g)localObject).wpy;
    int n = ((g)localObject).wpz;
    long l1 = System.currentTimeMillis();
    if (j == OpenGlRender.FLAG_Mirror)
    {
      i = 257;
      label634:
      if (!z.dtK().wrh) {
        break label708;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label702;
      }
      i = 259;
    }
    label702:
    label708:
    for (;;)
    {
      paramInt2 = z.dtK().dtc().b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = l1;
      paramInt1 = n;
      paramInt3 = m;
      break;
      i = 1;
      break label634;
      i = 3;
    }
  }
  
  public final void bB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(190829);
    if (TextUtils.isEmpty(paramString))
    {
      at(8, paramBoolean);
      AppMethodBeat.o(190829);
      return;
    }
    this.titleTv.setText(paramString);
    at(0, paramBoolean);
    AppMethodBeat.o(190829);
  }
  
  public final void cbl()
  {
    AppMethodBeat.i(114752);
    ae.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
    if (this.jxa == null) {
      this.jxa = com.tencent.mm.bh.e.a(this.wvC, 2131764896, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190818);
          j.this.pi(false);
          AppMethodBeat.o(190818);
        }
      });
    }
    if (!this.jxa.isShowing()) {
      this.jxa.show();
    }
    z.dtK().Lj(1);
    AppMethodBeat.o(114752);
  }
  
  public final int[] drX()
  {
    return new int[] { this.wwl, this.wwm };
  }
  
  public final int drY()
  {
    AppMethodBeat.i(190834);
    int i = al.jN(this.wvC);
    AppMethodBeat.o(190834);
    return i;
  }
  
  public final boolean drZ()
  {
    AppMethodBeat.i(190833);
    if ((az.is2G(this.wvC)) || (az.is3G(this.wvC)))
    {
      AppMethodBeat.o(190833);
      return true;
    }
    AppMethodBeat.o(190833);
    return false;
  }
  
  public final void dsa()
  {
    AppMethodBeat.i(190822);
    this.wwg.setVisibility(0);
    this.wwf.setVisibility(0);
    AppMethodBeat.o(190822);
  }
  
  public final void dsb()
  {
    AppMethodBeat.i(190823);
    this.wwg.setVisibility(8);
    this.wwf.setVisibility(8);
    AppMethodBeat.o(190823);
  }
  
  public final void dsc()
  {
    AppMethodBeat.i(190827);
    j(Boolean.TRUE);
    dtY();
    this.wwi.setIconEnabled(false);
    this.wwi.setOnClickListener(null);
    this.wwh.setVisibility(4);
    AppMethodBeat.o(190827);
  }
  
  public final void dsd()
  {
    AppMethodBeat.i(190828);
    j(Boolean.FALSE);
    this.wwi.setIconEnabled(true);
    this.wwi.setOnClickListener(this.wwz);
    this.wwh.setVisibility(0);
    AppMethodBeat.o(190828);
  }
  
  public final void dse()
  {
    AppMethodBeat.i(190826);
    if (this.wwx)
    {
      AppMethodBeat.o(190826);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation2.setDuration(150L);
    this.wwx = true;
    this.wwd.setAnimation(localAlphaAnimation1);
    this.wwd.setVisibility(0);
    this.wwb.setAnimation(localAlphaAnimation1);
    this.wwb.setVisibility(0);
    this.wwt.setAnimation(localAlphaAnimation2);
    this.wwt.setVisibility(0);
    AppMethodBeat.o(190826);
  }
  
  public final void dsf()
  {
    AppMethodBeat.i(190825);
    if (!this.wwx)
    {
      AppMethodBeat.o(190825);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation1.setDuration(150L);
    this.wwx = false;
    this.wwd.setAnimation(localAlphaAnimation2);
    this.wwd.setVisibility(4);
    this.wwb.setAnimation(localAlphaAnimation2);
    this.wwb.setVisibility(4);
    this.wwt.setAnimation(localAlphaAnimation1);
    this.wwt.setVisibility(4);
    AppMethodBeat.o(190825);
  }
  
  public final boolean dsg()
  {
    return this.wwr != null;
  }
  
  public final void dtZ()
  {
    AppMethodBeat.i(114756);
    if (this.wwk.isEnabled()) {
      z.dtK().pd(this.wwk.wuX.isChecked());
    }
    AppMethodBeat.o(114756);
  }
  
  public final void e(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114744);
    this.wrp.n(paramHashSet);
    pg(false);
    AppMethodBeat.o(114744);
  }
  
  public final void n(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114738);
    if (!this.wrp.drT())
    {
      this.wwe.setVisibility(0);
      this.wwi.setIconEnabled(z.dtK().dsj());
      this.wwg.setVisibility(0);
    }
    o(paramMultiTalkGroup);
    dtZ();
    AppMethodBeat.o(114738);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114743);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    if (!this.gIc)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
    }
    if (paramView.getId() == 2131305667) {
      z.dtK().j(true, false, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
      Object localObject2;
      if (paramView.getId() == 2131302582)
      {
        if (this.wrp.drT())
        {
          dsa();
          paramView = this.wrp;
          localObject1 = paramView.wpC;
          if ((localObject1 != null) && (((FrameLayout)localObject1).getVisibility() == 0))
          {
            localObject1 = paramView.wpF;
            if (localObject1 != null)
            {
              localObject1 = ((b)localObject1).wua;
              if (localObject1 != null)
              {
                localObject1 = ((MultiTalkVideoView)localObject1).getUsername();
                if (localObject1 != null)
                {
                  localObject2 = z.dtK();
                  d.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
                  localObject2 = ((o)localObject2).dtb();
                  d.g.b.p.g(localObject1, "it");
                  int i = ((r)localObject2).asL((String)localObject1);
                  if ((i == 103) || (i == 100)) {
                    paramView.drW();
                  } else {
                    paramView.ex((String)localObject1, 3);
                  }
                }
              }
            }
          }
        }
        else
        {
          n.wqK += 1;
          z.dtK().pa(true);
          n.dsR();
        }
      }
      else if (paramView.getId() == 2131302576)
      {
        if (this.wwr != null) {
          this.wwr.eDQ();
        }
        n.dsQ();
      }
      else if (paramView.getId() == 2131302572)
      {
        n.wqN += 1;
        paramView = this.wvC;
        if (!paramView.wtx)
        {
          paramView.wtx = true;
          localObject1 = new Intent(paramView, MultiTalkAddMembersUI.class);
          localObject2 = new ArrayList();
          if (z.dtK().wqU != null)
          {
            Iterator localIterator = z.dtK().wqU.MgI.iterator();
            while (localIterator.hasNext())
            {
              MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
              if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
                ((List)localObject2).add(localMultiTalkGroupMember.MgJ);
              }
            }
            ((Intent)localObject1).putExtra("titile", paramView.getString(2131761389));
            ((Intent)localObject1).putExtra("chatroomName", z.dtK().wqU.wmA);
            ((Intent)localObject1).putExtra("always_select_contact", bu.m((List)localObject2, ","));
            ((Intent)localObject1).putExtra("key_need_gallery", false);
            paramView.startActivityForResult((Intent)localObject1, 1);
          }
        }
      }
      else if (paramView.getId() == 2131308161)
      {
        if (!this.wwA)
        {
          this.wwA = true;
          z.dtK().dtc().pe(false);
          if (this.wwr == null) {
            ph(false);
          }
          this.wwr.eDR();
          z.dtK().dtb();
          r.Ll(101);
        }
        else
        {
          this.wwA = false;
          z.dtK().dtc().pe(true);
          pi(false);
          z.dtK().Lj(1);
          z.dtK().dtb();
          r.Ll(103);
        }
      }
    }
  }
  
  public final void pg(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(190821);
    boolean bool = z.dtK().dsX();
    ArrayList localArrayList;
    Object localObject1;
    int k;
    Object localObject2;
    if ((this.wpB.getAdapter() != null) && (this.wwc != null))
    {
      localArrayList = new ArrayList();
      localArrayList.clear();
      localObject1 = (a)this.wpB.getAdapter();
      i = this.wwc.kn();
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        k = this.wwc.kp() - ((a)localObject1).tii - ((a)localObject1).wtV;
        if ((i < 0) || (k < 0)) {
          break label333;
        }
        while (i <= k)
        {
          localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((a)localObject1).wtQ.get(i);
          localObject2 = this.wrp.asg(((com.tencent.mm.plugin.multitalk.data.a)localObject2).wmd.MgJ);
          if ((localObject2 != null) && (((b)localObject2).wua != null) && ((((b)localObject2).wua.dui()) || (((b)localObject2).wua.duj())))
          {
            int m = com.tencent.mm.plugin.multitalk.d.e.asV(((b)localObject2).wua.getUsername());
            localArrayList.add(Integer.valueOf(m));
            ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(m) });
          }
          i += 1;
        }
        i -= ((a)localObject1).tii;
      }
      if (!bool) {
        an(localArrayList);
      }
      if ((paramBoolean) || (this.wwu == null) || (!localArrayList.containsAll(this.wwu)) || (!this.wwu.containsAll(localArrayList))) {
        break label554;
      }
    }
    label554:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (!bool) {
          break label475;
        }
        com.tencent.mm.plugin.multitalk.b.p.wmO.al(localArrayList);
        ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "ilink subscribeByUserMids ok, mids:".concat(String.valueOf(localArrayList)));
      }
      for (;;)
      {
        this.wwu = localArrayList;
        AppMethodBeat.o(190821);
        return;
        label333:
        if (this.wpB.getAdapter() == null) {
          break;
        }
        localObject1 = ((a)this.wpB.getAdapter()).wtQ.iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
          if ((((com.tencent.mm.plugin.multitalk.data.a)localObject2).wmf) && (i < this.wwy))
          {
            k = com.tencent.mm.plugin.multitalk.d.e.asV(((com.tencent.mm.plugin.multitalk.data.a)localObject2).wmd.MgJ);
            localArrayList.add(Integer.valueOf(k));
            ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(k) });
          }
          if (i >= this.wwy) {
            break;
          }
          i += 1;
        }
        if (bool) {
          break;
        }
        an(localArrayList);
        break;
        label475:
        k = localArrayList.size();
        localObject1 = new ArrayList();
        i = j;
        while (i < k)
        {
          localObject2 = new a.ao();
          ((a.ao)localObject2).pcE = ((Integer)localArrayList.get(i)).intValue();
          ((List)localObject1).add(localObject2);
          i += 1;
        }
        z.dtK().eG((List)localObject1);
      }
    }
  }
  
  public final void ph(boolean paramBoolean)
  {
    AppMethodBeat.i(190831);
    if (!paramBoolean) {
      this.wwC = System.currentTimeMillis();
    }
    ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    if (this.wws == null)
    {
      ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
      this.wws = new ObservableTextureView(this.wvC);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(1, 1);
      this.wws.setLayoutParams(localLayoutParams);
      this.wvC.bKN().addView(this.wws);
      this.wws.setVisibility(0);
    }
    if (this.wwr == null)
    {
      ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
      this.wwr = new com.tencent.mm.plugin.voip.video.a(640, 480);
      this.wwr.a(this, z.dtK().wqR);
      this.wwr.a(this.wws);
      this.wwr.eDS();
      ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.wwr.eDU()), Boolean.valueOf(this.wwr.eDV()) });
    }
    AppMethodBeat.o(190831);
  }
  
  public final void pi(boolean paramBoolean)
  {
    AppMethodBeat.i(190832);
    if ((!paramBoolean) && (this.wwC != 0L) && (System.currentTimeMillis() - this.wwC > 0L) && (z.dtK().dsj()))
    {
      n.w(System.currentTimeMillis() - this.wwC, com.tencent.mm.plugin.multitalk.model.t.dty());
      this.wwC = 0L;
    }
    ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
    if (this.wws != null)
    {
      ViewParent localViewParent = this.wws.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.wws);
      }
      this.wws = null;
    }
    if (this.wwr != null)
    {
      this.wwr.eDT();
      this.wwr = null;
    }
    AppMethodBeat.o(190832);
  }
  
  public final void pj(boolean paramBoolean)
  {
    AppMethodBeat.i(114748);
    ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    this.cji.stopTimer();
    this.cji.removeCallbacksAndMessages(null);
    this.cji.quitSafely();
    if (!paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178935);
          j.d(j.this).setText(2131761392);
          AppMethodBeat.o(178935);
        }
      });
      z.dtK().dtb().close();
    }
    pi(false);
    this.wrp.ge(paramBoolean);
    com.tencent.mm.aj.p.aEA().b(this);
    ay localay = ay.aRW("multi_talk_config");
    if (localay.getBoolean("has_opened_screen_cast", false)) {
      localay.putBoolean("has_showed_tip_window", false);
    }
    AppMethodBeat.o(114748);
  }
  
  final class a
  {
    int h;
    int w;
    int[] wwH;
    
    private a() {}
  }
  
  final class b
  {
    int pcE;
    MultiTalkGroupMember wwI;
    
    b(MultiTalkGroupMember paramMultiTalkGroupMember, int paramInt)
    {
      this.wwI = paramMultiTalkGroupMember;
      this.pcE = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */