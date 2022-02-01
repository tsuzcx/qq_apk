package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.b.o.36;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.model.x;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.camera.a.b.a;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class p
  implements View.OnClickListener, f.a, com.tencent.mm.plugin.multitalk.model.b, b.a
{
  protected TextView DZt;
  public MultiTalkControlIconLayout FAa;
  private int FAb;
  private int FAc;
  private RelativeLayout FAd;
  private RelativeLayout FAe;
  private LinearLayout FAf;
  private RelativeLayout FAg;
  public CollapseView FAh;
  private ArrayList<Integer> FAi;
  private ArrayList<Integer> FAj;
  public boolean FAk;
  private boolean FAl;
  private boolean FAm;
  private int FAn;
  RelativeLayout FAo;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a FAp;
  View.OnClickListener FAq;
  private Runnable FAr;
  private boolean FAs;
  public long FAt;
  private com.tencent.mm.plugin.voip.video.camera.a.b FAu;
  public RecyclerView Fqe;
  public FrameLayout Fqf;
  public com.tencent.mm.plugin.multitalk.model.a Fst;
  protected ImageView FwW;
  public MultiTalkMainUI Fyj;
  private ImageButton Fyr;
  private boolean Fys;
  private int Fyt;
  public final View FzL;
  private RelativeLayout FzM;
  public GridLayoutManager FzN;
  public View FzO;
  protected boolean FzP;
  public View FzQ;
  private WeImageButton FzR;
  private WeImageView FzS;
  private View FzT;
  private View FzU;
  private View FzV;
  public View FzW;
  private com.tencent.mm.plugin.multitalk.ui.b.a FzX;
  public MultiTalkControlIconLayout FzY;
  MultiTalkControlIconLayout FzZ;
  private MTimerHandler cts;
  public boolean kgM;
  private int lcs;
  public TextView timeTV;
  private TextView titleTv;
  
  public p(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114737);
    this.FzP = false;
    this.FAi = new ArrayList();
    this.FAj = new ArrayList();
    this.FAk = false;
    this.FAl = false;
    this.FAm = true;
    this.FAn = (e.b.QRN * e.b.QRM);
    this.Fyt = 0;
    this.FAq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178933);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.multitalk.model.p.EFF += 1;
        paramAnonymousView = p.this;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramAnonymousView.Fyj.getContext(), "android.permission.CAMERA", 22, "", "");
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), paramAnonymousView.Fyj.getContext() });
        if (!bool)
        {
          p.this.FzY.setChecked(false);
          com.tencent.mm.plugin.multitalk.model.p.eWN();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!ad.eYc().eXh())
        {
          p.this.FzY.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!ad.eYc().eWf())
        {
          p.this.FzY.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!NetStatusUtil.isNetworkConnected(p.this.Fyj))
        {
          com.tencent.mm.bj.e.a(p.this.Fyj, a.h.voip_net_unavailable, null);
          p.this.FzY.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!v.eXP())
        {
          Toast.makeText(p.this.Fyj, a.h.multitalk_disabled, 1).show();
          p.this.FzY.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (p.this.FzY.Fxz.isChecked())
        {
          p.this.FzY.setChecked(true);
          p.this.vb(false);
          ad.eYc().eXD();
          com.tencent.mm.plugin.multitalk.model.p.eWV();
          paramAnonymousView = com.tencent.mm.plugin.multitalk.b.o.Fne;
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStart");
          paramAnonymousView.am(new o.36(paramAnonymousView));
        }
        for (ad.eYd().Fzt = true;; ad.eYd().Fzt = false)
        {
          if (ad.eYc().eXq().eVP()) {
            com.tencent.mm.plugin.multitalk.model.p.q(ad.eYc().FrY.FmO, 0, 9, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
          p.this.vc(false);
          ad.eYc().aK(1, ad.eYc().FrS);
          com.tencent.mm.plugin.multitalk.model.p.eWW();
          com.tencent.mm.plugin.multitalk.b.o.Fne.cNH();
        }
      }
    };
    this.FAr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197213);
        if ((p.f(p.this) == null) || (p.f(p.this).isFinishing()))
        {
          AppMethodBeat.o(197213);
          return;
        }
        if (p.f(p.this).findViewById(a.e.net_tip_layout) != null) {
          p.f(p.this).findViewById(a.e.net_tip_layout).setOnClickListener(null);
        }
        if (p.g(p.this) != null) {
          p.g(p.this).setLinkToAutoMobileListener(null);
        }
        p.this.FzP = false;
        p.this.DZt.setVisibility(8);
        p.this.FwW.setVisibility(8);
        AppMethodBeat.o(197213);
      }
    };
    this.FAs = false;
    this.cts = new MTimerHandler("MultiTalkTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(207315);
        h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205653);
            p.h(p.this).setVisibility(8);
            p.i(p.this).setVisibility(0);
            AppMethodBeat.o(205653);
          }
        });
        AppMethodBeat.o(207315);
        return true;
      }
    }, false);
    this.lcs = 0;
    this.kgM = true;
    this.Fyj = paramMultiTalkMainUI;
    this.FAb = ar.au(paramMultiTalkMainUI).x;
    this.FAc = (this.FAb + com.tencent.mm.ci.a.fromDPToPix(paramMultiTalkMainUI, 52) + ar.getStatusBarHeight(paramMultiTalkMainUI));
    this.timeTV = ((TextView)paramMultiTalkMainUI.findViewById(a.e.time_tv));
    this.FzO = paramMultiTalkMainUI.findViewById(a.e.top_gradient);
    this.titleTv = ((TextView)paramMultiTalkMainUI.findViewById(a.e.title_tv));
    this.FzQ = paramMultiTalkMainUI.findViewById(a.e.talking_layout);
    this.Fyt = (com.tencent.mm.ci.a.ks(paramMultiTalkMainUI) - com.tencent.mm.ci.a.fromDPToPix(paramMultiTalkMainUI, 285));
    this.FAd = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.control_icon_layout));
    this.FAe = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.hangup_icon_layout));
    this.FAf = ((LinearLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(a.f.multitalk_control_expand, null, false));
    this.FAg = ((RelativeLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(a.f.multitalk_control_collapse, null, false));
    this.Fyr = ((ImageButton)this.FAg.findViewById(a.e.talking_hangup_btn));
    this.Fqe = ((RecyclerView)paramMultiTalkMainUI.findViewById(a.e.talking_main_avatar_layout));
    this.FzM = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.talking_main_top));
    this.Fqf = ((FrameLayout)paramMultiTalkMainUI.findViewById(a.e.talking_big_avatar_layout));
    this.Fst = ad.eYc().eXq();
    this.FAo = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.screen_cast_plugin_layout));
    this.FzL = paramMultiTalkMainUI.findViewById(a.e.top_control_layout);
    Object localObject = (RelativeLayout.LayoutParams)this.FzL.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (ar.getStatusBarHeight(paramMultiTalkMainUI) + com.tencent.mm.ci.a.fromDPToPix(paramMultiTalkMainUI, 12));
    this.FzL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((RelativeLayout.LayoutParams)this.Fqf.getLayoutParams()).topMargin = (com.tencent.mm.ci.a.fromDPToPix(paramMultiTalkMainUI, 52) + ar.getStatusBarHeight(paramMultiTalkMainUI));
    this.FzN = new GridLayoutManager(3);
    localObject = new a(paramMultiTalkMainUI);
    this.Fqe.setLayoutManager(this.FzN);
    this.FzN.ahK = new GridLayoutManager.b()
    {
      public final int cx(int paramAnonymousInt)
      {
        AppMethodBeat.i(178928);
        if (this.FAv.XC(paramAnonymousInt))
        {
          paramAnonymousInt = p.a(p.this).ahF;
          AppMethodBeat.o(178928);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(178928);
        return 1;
      }
    };
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Fqe.getLayoutParams();
    if (this.Fyt > this.FAb)
    {
      localLayoutParams.width = this.FAb;
      localLayoutParams.height = this.FAc;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "mAvatarLastHeight is %s and talkingAvatarContainerWidth is %s", new Object[] { Integer.valueOf(this.Fyt), Integer.valueOf(this.FAb) });
      this.Fqe.setLayoutParams(localLayoutParams);
      ((a)localObject).Fws = this.Fst;
      this.Fqe.setAdapter((RecyclerView.a)localObject);
      this.Fqe.setOnScrollListener(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(200104);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (p.b(p.this)))
          {
            p.this.va(false);
            com.tencent.mm.plugin.multitalk.model.p.uH(true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(200104);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(200105);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt1);
          localb.sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousRecyclerView = p.this;
          if (paramAnonymousInt2 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            p.a(paramAnonymousRecyclerView, bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(200105);
            return;
          }
        }
      });
      this.Fst.a(this.Fqe, this.Fqf, paramMultiTalkMainUI, this);
      this.FzR = ((WeImageButton)paramMultiTalkMainUI.findViewById(a.e.multitalk_mini_action));
      this.FzS = ((WeImageView)paramMultiTalkMainUI.findViewById(a.e.btn_split));
      this.FzT = paramMultiTalkMainUI.findViewById(a.e.multitalk_addmembers_action);
      this.FzT.setBackground(au.o(MMApplicationContext.getContext(), a.g.icons_outlined_add, -1));
      this.FzU = paramMultiTalkMainUI.findViewById(a.e.multitalk_screen_projector_action);
      this.FzV = paramMultiTalkMainUI.findViewById(a.e.multi_screen_project_red_dot);
      this.FzX = new com.tencent.mm.plugin.multitalk.ui.b.a(paramMultiTalkMainUI, this.FzU, "screenShare", this.FzV);
      this.FzU.setBackground(au.o(paramMultiTalkMainUI, a.g.icons_outlined_board, paramMultiTalkMainUI.getResources().getColor(a.b.White)));
      this.FzT.bringToFront();
      this.FzT.setOnClickListener(this);
      this.FzY = ((MultiTalkControlIconLayout)this.FAf.findViewById(a.e.multitalk_video_action));
      this.FzY.setIconEnabled(ad.eYc().eWf());
      this.FzY.setOnClickListener(this.FAq);
      this.FzZ = ((MultiTalkControlIconLayout)this.FAf.findViewById(a.e.multitalk_mute_action));
      this.FzZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178931);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.multitalk.model.p.FrH += 1;
          ad.eYc().uN(p.this.FzZ.Fxz.isChecked());
          if (p.this.FzZ.Fxz.isChecked())
          {
            p.this.FzZ.setChecked(true);
            com.tencent.mm.plugin.multitalk.model.p.eWR();
            ad.eYb().uD(false);
            ad.eYd().Fzu = true;
          }
          for (;;)
          {
            if (ad.eYc().eXq().eVP()) {
              com.tencent.mm.plugin.multitalk.model.p.q(ad.eYc().FrY.FmO, 0, 5, 2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178931);
            return;
            p.this.FzZ.setChecked(false);
            ad.eYd().Fzu = false;
            com.tencent.mm.plugin.multitalk.model.p.eWS();
            ad.eYb().uD(true);
          }
        }
      });
      this.FAa = ((MultiTalkControlIconLayout)this.FAf.findViewById(a.e.multitalk_handsfree_action));
      this.FAa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178932);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (p.this.FAa.isEnabled())
          {
            com.tencent.mm.plugin.multitalk.model.p.FrI += 1;
            ad.eYc().uM(p.this.FAa.Fxz.isChecked());
            p.this.eYM();
            if (!p.this.FAa.Fxz.isChecked()) {
              break label164;
            }
            p.this.FAa.setChecked(true);
            com.tencent.mm.plugin.multitalk.model.p.eWT();
            ad.eYb().uC(true);
          }
          for (;;)
          {
            if (ad.eYc().eXq().eVP()) {
              com.tencent.mm.plugin.multitalk.model.p.q(ad.eYc().FrY.FmO, 0, 6, 2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178932);
            return;
            label164:
            p.this.FAa.setChecked(false);
            com.tencent.mm.plugin.multitalk.model.p.eWU();
            ad.eYb().uC(false);
          }
        }
      });
      this.FAh = ((CollapseView)paramMultiTalkMainUI.findViewById(a.e.general_collapse_layout));
      this.FzW = this.FAg.findViewById(a.e.multitalk_convert_camera_btn);
      this.FzZ.setChecked(ad.eYc().iYs);
      this.FAa.setChecked(ad.eYc().pih);
      this.FzY.setChecked(v.Xz(ad.eYc().FrQ));
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.FAc) });
      this.Fyr.setOnClickListener(this);
      this.FzR.bringToFront();
      this.FzR.setOnClickListener(this);
      this.FzR.setImageDrawable(au.o(MMApplicationContext.getContext(), a.g.icons_outlined_min_window, -1));
      this.FzR.setIconColor(-1);
      this.FzU.bringToFront();
      this.FzU.setOnClickListener(this);
      this.FzW.setOnClickListener(this);
      com.tencent.mm.am.q.bhz().a(this);
      this.FzS.setOnClickListener(this);
      if (ar.hIH()) {
        this.FzS.setVisibility(0);
      }
      if (!ar.atR(paramMultiTalkMainUI.getTaskId())) {
        break label1148;
      }
      this.FzS.setBackgroundResource(a.g.icons_outlined_merge);
      label1081:
      if (!v.Xz(ad.eYc().FrQ)) {
        break label1161;
      }
      this.FzW.setVisibility(0);
    }
    for (;;)
    {
      eYM();
      AppMethodBeat.o(114737);
      return;
      localLayoutParams.width = this.Fyt;
      localLayoutParams.height = (this.Fyt + com.tencent.mm.ci.a.fromDPToPix(paramMultiTalkMainUI, 52) + ar.getStatusBarHeight(paramMultiTalkMainUI));
      localLayoutParams.addRule(14);
      break;
      label1148:
      this.FzS.setBackgroundResource(a.g.icons_outlined_sperated);
      break label1081;
      label1161:
      this.FzW.setVisibility(8);
    }
  }
  
  private void a(MultiTalkGroup paramMultiTalkGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(197838);
    if (paramMultiTalkGroup != null)
    {
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = null;
      Iterator localIterator = paramMultiTalkGroup.ZiG.iterator();
      while (localIterator.hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
        if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
        {
          localObject2 = localMultiTalkGroupMember;
          if (!localMultiTalkGroupMember.ZiH.equals(z.bcZ()))
          {
            i = com.tencent.mm.plugin.multitalk.d.e.aQT(localMultiTalkGroupMember.ZiH);
            if (i == -1)
            {
              localArrayList1.add(localMultiTalkGroupMember);
              continue;
            }
            localArrayList2.add(new p.a(this, localMultiTalkGroupMember, i));
          }
        }
        else
        {
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        localArrayList1.add(localObject1);
      }
      localObject1 = new ArrayList();
      int i = localArrayList2.size() - 1;
      while (i >= 0)
      {
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { Integer.valueOf(((p.a)localArrayList2.get(i)).tQm) });
        ((ArrayList)localObject1).add(localArrayList2.get(i));
        i -= 1;
      }
      Collections.sort((List)localObject1, Collections.reverseOrder());
      Object localObject2 = new ArrayList();
      i = ((ArrayList)localObject1).size() - 1;
      while (i >= 0)
      {
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { Integer.valueOf(((p.a)((ArrayList)localObject1).get(i)).tQm) });
        ((ArrayList)localObject2).add(((p.a)((ArrayList)localObject1).get(i)).FAz);
        i -= 1;
      }
      if ((this.FAh != null) && (!v.k(paramMultiTalkGroup).equals(paramMultiTalkGroup.ZiE))) {
        this.FAh.setRoomKey(v.k(paramMultiTalkGroup));
      }
      ((ArrayList)localObject2).addAll(localArrayList1);
      e((ArrayList)localObject2, paramBoolean);
    }
    AppMethodBeat.o(197838);
  }
  
  private static int aJ(ArrayList<Integer> paramArrayList)
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
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = ByteBuffer.allocate(j * 4);
    paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(arrayOfInt);
    paramArrayList = paramArrayList.array();
    i = ad.eYb().Frw.setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      Log.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.p.eWO();
      AppMethodBeat.o(178939);
      return -1;
    }
    AppMethodBeat.o(178939);
    return i;
  }
  
  private void aL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(197931);
    this.titleTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.cts.stopTimer();
      this.cts.removeCallbacksAndMessages(null);
      if (paramBoolean) {
        this.cts.startTimer(5000L);
      }
      this.timeTV.setVisibility(8);
      AppMethodBeat.o(197931);
      return;
    }
    this.timeTV.setVisibility(0);
    AppMethodBeat.o(197931);
  }
  
  private void e(ArrayList<MultiTalkGroupMember> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(197868);
    int j = paramArrayList.size();
    int i = 3;
    if (j < 5) {
      i = 2;
    }
    Object localObject;
    if ((this.Fyj.cuR() != null) && (this.Fyj.cuR().findViewById(a.e.rootview) != null))
    {
      Log.printInfoStack("MicroMsg.MT.MultiTalkTalkingUILogic", "inflateLineUser", new Object[0]);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ax.aB(this.Fyj);
      this.Fyj.cuR().findViewById(a.e.rootview).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.Fqe.removeAllViewsInLayout();
    if ((j > 9) || (this.FAk))
    {
      if ((!ad.eYc().Fsa) && (j > 12))
      {
        ad.eYc().Fsa = true;
        w.w(this.Fyj, this.Fyj.getResources().getString(a.h.multitalk_scroll_dialog), a.g.multitalk_icons_scrool);
      }
      eYJ();
    }
    for (;;)
    {
      this.FzN.cw(i);
      this.Fqe.setLayoutManager(this.FzN);
      localObject = new HashSet(ad.eYc().FrW);
      ArrayList localArrayList = new ArrayList(ad.eYc().eXm().eXL());
      a locala = (a)this.Fqe.getAdapter();
      if (locala != null)
      {
        locala.Fwm = false;
        locala.c((HashSet)localObject);
        locala.aH(localArrayList);
        locala.a(paramArrayList, this.Fst);
      }
      if ((ad.eYc().eXh()) && (this.FzY != null) && (!this.FzY.Fxz.isChecked())) {
        ad.eYc().aK(1, ad.eYc().FrS);
      }
      if (v.XA(ad.eYc().FrQ))
      {
        if (paramBoolean) {
          this.Fst.q((Set)localObject);
        }
        va(false);
      }
      AppMethodBeat.o(197868);
      return;
      eYH();
    }
  }
  
  public static void eYG()
  {
    AppMethodBeat.i(197872);
    com.tencent.mm.plugin.multitalk.model.q localq = ad.eYc();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localq.FrW.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!z.bcZ().equals(str)) {
        localHashSet.add(str);
      }
    }
    localq.FrW.clear();
    localq.FrW = localHashSet;
    if (localq.Fri != null) {
      localq.Fri.eWi();
    }
    AppMethodBeat.o(197872);
  }
  
  private void eYH()
  {
    AppMethodBeat.i(197877);
    if (this.FAf.getParent() != null) {
      ((ViewGroup)this.FAf.getParent()).removeView(this.FAf);
    }
    if (this.FAg.getParent() != null) {
      ((ViewGroup)this.FAg.getParent()).removeView(this.FAg);
    }
    View localView = this.Fyj.findViewById(a.e.talking_bottom_action_layout);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.ci.a.ks(this.Fyj) * 3.6D / 100.0D));
      localView.setLayoutParams(localLayoutParams);
    }
    this.FAh.setVisibility(4);
    if (this.FAd != null) {
      this.FAd.addView(this.FAf);
    }
    this.FAe.addView(this.FAg);
    this.DZt = ((TextView)this.Fyj.findViewById(a.e.voip_net_status_hint));
    this.FwW = ((ImageView)this.Fyj.findViewById(a.e.link_arrow));
    if (this.FwW != null) {
      this.FwW.setImageDrawable(au.o(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
    }
    AppMethodBeat.o(197877);
  }
  
  private void eYJ()
  {
    AppMethodBeat.i(197888);
    Object localObject;
    if (!this.FAk)
    {
      this.FAk = true;
      this.FAh.setVisibility(0);
      this.FAh.fq(this.FAg);
      this.FAh.aq(this.FAf, this.Fyj.cuR().findViewById(a.e.talking_bottom_action_layout).getHeight());
      localObject = (RelativeLayout.LayoutParams)this.Fqe.getLayoutParams();
      if (this.Fyt <= this.FAb) {
        break label287;
      }
    }
    label287:
    for (((RelativeLayout.LayoutParams)localObject).height = (this.FAb / 3 * 5 + com.tencent.mm.ci.a.fromDPToPix(this.Fyj, 52) + ar.getStatusBarHeight(this.Fyj));; ((RelativeLayout.LayoutParams)localObject).height = (this.Fyt / 3 * 5 + ar.getStatusBarHeight(this.Fyj)))
    {
      this.Fqe.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.FAh.findViewById(a.e.rootView).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = ax.aB(this.Fyj);
      this.FAh.findViewById(a.e.rootView).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((ad.eYc().eXh()) && (this.FzY != null) && (!this.FzY.Fxz.isChecked())) {
        ad.eYc().aK(1, ad.eYc().FrS);
      }
      if (this.DZt != null) {
        this.DZt.setVisibility(8);
      }
      if (this.FwW != null) {
        this.FwW.setVisibility(8);
      }
      this.DZt = this.FAh.DZt;
      this.FwW = this.FAh.FwW;
      this.FwW.setImageDrawable(au.o(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
      AppMethodBeat.o(197888);
      return;
    }
  }
  
  private void u(Boolean paramBoolean)
  {
    AppMethodBeat.i(197918);
    if (paramBoolean.booleanValue())
    {
      this.FzR.setImageDrawable(au.o(MMApplicationContext.getContext(), a.g.icons_filled_back, -1));
      this.FzR.setIconColor(-1);
      this.FzO.getLayoutParams().height = (com.tencent.mm.ci.a.fromDPToPix(this.Fyj, 52) + ar.getStatusBarHeight(this.Fyj));
      this.FzO.setBackgroundColor(this.Fyj.getResources().getColor(a.b.default_bg_color));
      this.timeTV.setVisibility(4);
      this.FzT.setVisibility(4);
      this.FzU.setVisibility(4);
      AppMethodBeat.o(197918);
      return;
    }
    this.FzR.setImageDrawable(au.o(MMApplicationContext.getContext(), a.g.icons_outlined_min_window, -1));
    this.FzR.setIconColor(-1);
    this.FzO.getLayoutParams().height = com.tencent.mm.ci.a.fromDPToPix(this.Fyj, this.Fyj.getResources().getDimension(a.c.main_ui_statusbar_height));
    this.FzO.setBackground(this.Fyj.getResources().getDrawable(a.d.multitalk_status_bar));
    this.timeTV.setVisibility(0);
    this.FzT.setVisibility(0);
    if (com.tencent.mm.plugin.multitalk.d.e.eZS())
    {
      this.FzU.setVisibility(0);
      if (!com.tencent.mm.plugin.multitalk.d.e.eZO())
      {
        com.tencent.mm.plugin.newtips.a.fiO().h(this.FzX);
        AppMethodBeat.o(197918);
        return;
      }
      this.FzV.setVisibility(8);
      AppMethodBeat.o(197918);
      return;
    }
    this.FzU.setVisibility(8);
    this.FzV.setVisibility(8);
    AppMethodBeat.o(197918);
  }
  
  public final void IA(int paramInt)
  {
    AppMethodBeat.i(197937);
    this.lcs = paramInt;
    if (ad.eYe().aXN()) {
      ad.eYe();
    }
    AppMethodBeat.o(197937);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(114753);
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    com.tencent.mm.plugin.multitalk.model.a locala = this.Fst;
    kotlin.g.b.p.k(paramString, "wxUserName");
    paramString = locala.aPL(paramString);
    if (paramString != null)
    {
      paramString = paramString.Fww;
      if (paramString != null)
      {
        paramString.eYN();
        AppMethodBeat.o(114753);
        return;
      }
      AppMethodBeat.o(114753);
      return;
    }
    AppMethodBeat.o(114753);
  }
  
  public final void XK(int paramInt)
  {
    AppMethodBeat.i(197846);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.Fyj.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (localDisplayMetrics.heightPixels / localDisplayMetrics.density <= 540.0F)
    {
      w.cQ(this.Fyj, this.Fyj.getString(a.h.voip_auduo_auto_switch_to_mobile_net));
      AppMethodBeat.o(197846);
      return;
    }
    if (this.DZt != null)
    {
      this.FzP = true;
      if (this.Fyj.findViewById(a.e.net_tip_layout) != null) {
        this.Fyj.findViewById(a.e.net_tip_layout).setOnClickListener(null);
      }
      if (this.FAh != null) {
        this.FAh.setLinkToAutoMobileListener(null);
      }
      if (!this.FAk) {
        break label214;
      }
      this.FAh.setLinkToAutoMobileListener(new CollapseView.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(202655);
          p.f(p.this).XB(1);
          AppMethodBeat.o(202655);
        }
      });
    }
    for (;;)
    {
      this.FwW.setVisibility(0);
      this.DZt.setVisibility(0);
      this.DZt.setText(a.h.voip_auduo_auto_switch_to_mobile_net);
      this.Fyj.aC(this.FAr);
      this.Fyj.m(this.FAr, paramInt * 1000);
      AppMethodBeat.o(197846);
      return;
      label214:
      if (this.Fyj.findViewById(a.e.net_tip_layout) != null) {
        this.Fyj.findViewById(a.e.net_tip_layout).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(204671);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (p.this.Fyj.findViewById(a.e.net_tip_layout) != null) {
              p.this.Fyj.XB(1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(204671);
          }
        });
      }
    }
  }
  
  public final void XL(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(197853);
    if ((com.tencent.mm.plugin.multitalk.b.o.Fne.Fno >= 3600) && (!com.tencent.mm.plugin.multitalk.b.o.Fnp)) {
      com.tencent.mm.plugin.multitalk.b.o.Fnp = true;
    }
    while (i != 0)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)this.Fyj.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      if (localDisplayMetrics.heightPixels / localDisplayMetrics.density <= 540.0F)
      {
        w.cQ(this.Fyj, this.Fyj.getString(a.h.voip_audio_network_data_cost_max));
        AppMethodBeat.o(197853);
        return;
        i = 0;
      }
      else
      {
        if (this.Fyj.findViewById(a.e.net_tip_layout) != null) {
          this.Fyj.findViewById(a.e.net_tip_layout).setOnClickListener(null);
        }
        if (this.FAh != null) {
          this.FAh.setLinkToAutoMobileListener(null);
        }
        if (!this.FAk) {
          break label236;
        }
        this.FAh.setLinkToAutoMobileListener(new CollapseView.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(196665);
            p.f(p.this).XB(2);
            AppMethodBeat.o(196665);
          }
        });
      }
    }
    for (;;)
    {
      this.FwW.setVisibility(8);
      this.DZt.setVisibility(0);
      this.DZt.setText(a.h.voip_audio_network_data_cost_max);
      this.Fyj.aC(this.FAr);
      this.Fyj.m(this.FAr, paramInt * 1000);
      AppMethodBeat.o(197853);
      return;
      label236:
      if (this.Fyj.findViewById(a.e.net_tip_layout) != null) {
        this.Fyj.findViewById(a.e.net_tip_layout).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(200478);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (p.this.Fyj.findViewById(a.e.net_tip_layout) != null) {
              p.this.Fyj.XB(2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(200478);
          }
        });
      }
    }
  }
  
  public final void XM(int paramInt)
  {
    AppMethodBeat.i(197983);
    if (this.FAp != null)
    {
      this.FAp.setOrientation(paramInt);
      if (this.FAh != null) {
        this.FAh.XG(paramInt);
      }
      if (this.FzW != null) {
        this.FzW.setRotation(paramInt);
      }
      if (this.FzY != null) {
        this.FzY.XG(paramInt);
      }
      if (this.FAa != null) {
        this.FAa.XG(paramInt);
      }
      if (this.FzZ != null) {
        this.FzZ.XG(paramInt);
      }
    }
    AppMethodBeat.o(197983);
  }
  
  public final boolean aXN()
  {
    AppMethodBeat.i(197940);
    boolean bool = ad.eYe().aXN();
    AppMethodBeat.o(197940);
    return bool;
  }
  
  public final void aYA()
  {
    AppMethodBeat.i(197881);
    if ((this.FzY != null) && (this.FzY.Fxz.isChecked()))
    {
      vc(false);
      ad.eYc().aK(1, ad.eYc().FrS);
      com.tencent.mm.plugin.multitalk.model.p.eWW();
      com.tencent.mm.plugin.multitalk.b.o.Fne.cNH();
      w.cP(this.Fyj, this.Fyj.getResources().getString(a.h.screen_project_close_camera));
      ad.eYd().Fzt = false;
    }
    AppMethodBeat.o(197881);
  }
  
  public final void bX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197928);
    if (TextUtils.isEmpty(paramString))
    {
      aL(8, paramBoolean);
      AppMethodBeat.o(197928);
      return;
    }
    this.titleTv.setText(paramString);
    aL(0, paramBoolean);
    AppMethodBeat.o(197928);
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114744);
    this.Fst.p(paramHashSet);
    va(false);
    AppMethodBeat.o(114744);
  }
  
  public final int dvN()
  {
    AppMethodBeat.i(197973);
    int i = ar.getStatusBarHeight(this.Fyj);
    AppMethodBeat.o(197973);
    return i;
  }
  
  public final int[] eVT()
  {
    return new int[] { this.FAb, this.FAc };
  }
  
  public final boolean eVU()
  {
    AppMethodBeat.i(197969);
    if ((NetStatusUtil.is2G(this.Fyj)) || (NetStatusUtil.is3G(this.Fyj)))
    {
      AppMethodBeat.o(197969);
      return true;
    }
    AppMethodBeat.o(197969);
    return false;
  }
  
  public final void eVV()
  {
    AppMethodBeat.i(197909);
    this.FzT.setVisibility(0);
    this.FzR.setVisibility(0);
    if (ar.hIH()) {
      this.FzS.setVisibility(0);
    }
    if (com.tencent.mm.plugin.multitalk.d.e.eZS())
    {
      this.FzU.setVisibility(0);
      if (!com.tencent.mm.plugin.multitalk.d.e.eZO())
      {
        com.tencent.mm.plugin.newtips.a.fiO().h(this.FzX);
        AppMethodBeat.o(197909);
        return;
      }
      this.FzV.setVisibility(8);
    }
    AppMethodBeat.o(197909);
  }
  
  public final void eVW()
  {
    AppMethodBeat.i(197912);
    this.FzT.setVisibility(8);
    this.FzU.setVisibility(8);
    this.FzV.setVisibility(8);
    this.FzR.setVisibility(8);
    this.FzS.setVisibility(8);
    AppMethodBeat.o(197912);
  }
  
  public final void eVX()
  {
    AppMethodBeat.i(197926);
    u(Boolean.TRUE);
    eYJ();
    if ((this.FAh != null) && (this.FAk))
    {
      CollapseView localCollapseView = this.FAh;
      localCollapseView.BOy.setTag(Boolean.TRUE);
      localCollapseView.fu(localCollapseView.FwV);
      localCollapseView.BOy.animate().setDuration(localCollapseView.duration).rotation(270.0F);
      localCollapseView.Fxb.setTag(Boolean.TRUE);
      localCollapseView.fr(localCollapseView.Fxb);
    }
    AppMethodBeat.o(197926);
  }
  
  public final void eVY()
  {
    AppMethodBeat.i(197927);
    u(Boolean.FALSE);
    a(ad.eYc().FrY, false);
    AppMethodBeat.o(197927);
  }
  
  public final void eVZ()
  {
    AppMethodBeat.i(197923);
    if (this.FAm)
    {
      AppMethodBeat.o(197923);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation2.setDuration(150L);
    this.FAm = true;
    this.FzO.setAnimation(localAlphaAnimation1);
    this.FzO.setVisibility(0);
    this.FzL.setAnimation(localAlphaAnimation1);
    this.FzL.setVisibility(0);
    this.FAh.setAnimation(localAlphaAnimation2);
    this.FAh.setVisibility(0);
    AppMethodBeat.o(197923);
  }
  
  public final void eWa()
  {
    AppMethodBeat.i(197920);
    if (!this.FAm)
    {
      AppMethodBeat.o(197920);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation1.setDuration(150L);
    this.FAm = false;
    this.FzO.setAnimation(localAlphaAnimation2);
    this.FzO.setVisibility(4);
    this.FzL.setAnimation(localAlphaAnimation2);
    this.FzL.setVisibility(4);
    this.FAh.setAnimation(localAlphaAnimation1);
    this.FAh.setVisibility(4);
    this.FzU.setVisibility(4);
    this.FzV.setVisibility(8);
    AppMethodBeat.o(197920);
  }
  
  public final void eWb()
  {
    AppMethodBeat.i(197944);
    this.FAp = new com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a(this.Fyj);
    Object localObject = this.FAp;
    RelativeLayout localRelativeLayout = this.FAo;
    kotlin.g.b.p.k(localRelativeLayout, "rootView");
    localRelativeLayout.removeAllViews();
    localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a)localObject).FEl;
    if (localObject != null)
    {
      ((j)localObject).G(localRelativeLayout);
      AppMethodBeat.o(197944);
      return;
    }
    AppMethodBeat.o(197944);
  }
  
  public final void eWc()
  {
    AppMethodBeat.i(197946);
    if (this.FAp != null)
    {
      XM(0);
      Object localObject = this.FAp.FEl;
      if (localObject != null) {
        ((j)localObject).FCm.release();
      }
      localObject = this.FAp;
      RelativeLayout localRelativeLayout = this.FAo;
      kotlin.g.b.p.k(localRelativeLayout, "rootView");
      localRelativeLayout.removeAllViews();
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a)localObject).FEl;
      if (localObject != null) {
        ((j)localObject).vh(false);
      }
      this.FAp = null;
      va(true);
    }
    AppMethodBeat.o(197946);
  }
  
  public final void eYI()
  {
    AppMethodBeat.i(197878);
    this.FAh.setVisibility(4);
    AppMethodBeat.o(197878);
  }
  
  public final void eYK()
  {
    AppMethodBeat.i(197913);
    this.FzQ.setVisibility(8);
    this.FzO.setVisibility(8);
    AppMethodBeat.o(197913);
  }
  
  public final void eYL()
  {
    AppMethodBeat.i(197955);
    this.FzQ.setVisibility(8);
    this.FzT.setVisibility(8);
    this.FzU.setVisibility(8);
    this.FzV.setVisibility(8);
    AppMethodBeat.o(197955);
  }
  
  final void eYM()
  {
    AppMethodBeat.i(114756);
    if (this.FAa.isEnabled()) {
      ad.eYc().uQ(this.FAa.Fxz.isChecked());
    }
    AppMethodBeat.o(114756);
  }
  
  public final void n(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114738);
    if ((!this.Fyj.eYm()) && (!this.Fst.eVP())) {
      if (!this.Fst.eVP())
      {
        this.FzQ.setVisibility(0);
        this.FzY.setIconEnabled(ad.eYc().eWf());
        this.FzT.setVisibility(0);
        if (!ad.eYc().eWf()) {
          break label193;
        }
        if (this.Fyj.eYm()) {
          break label163;
        }
        if (com.tencent.mm.plugin.multitalk.d.e.eZS())
        {
          this.FzU.setVisibility(0);
          if (com.tencent.mm.plugin.multitalk.d.e.eZO()) {
            break label151;
          }
          com.tencent.mm.plugin.newtips.a.fiO().h(this.FzX);
        }
      }
    }
    for (;;)
    {
      a(paramMultiTalkGroup, true);
      this.Fst.a(this.Fqe, this.Fqf, this.Fyj, this);
      eYM();
      AppMethodBeat.o(114738);
      return;
      label151:
      this.FzV.setVisibility(8);
      continue;
      label163:
      this.FzU.setVisibility(8);
      this.FzV.setVisibility(8);
      this.FzT.setVisibility(8);
      continue;
      label193:
      this.FzU.setVisibility(8);
      this.FzV.setVisibility(8);
    }
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(114743);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (!this.kgM)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
    }
    if (paramView.getId() == a.e.talking_hangup_btn) {
      ad.eYc().i(true, false, false);
    }
    do
    {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(114743);
        return;
        if (paramView.getId() == a.e.multitalk_mini_action)
        {
          if (this.Fst.eVP())
          {
            eVV();
            this.FAh.dGn();
            this.Fst.eVO();
            va(true);
          }
          else
          {
            com.tencent.mm.plugin.multitalk.model.p.FrG += 1;
            ad.eYc().uL(true);
            com.tencent.mm.plugin.multitalk.model.p.eWY();
          }
        }
        else if (paramView.getId() == a.e.multitalk_convert_camera_btn)
        {
          paramView = ad.eYe();
          paramView.Frj = 0L;
          paramView = paramView.Frk;
          if (paramView != null)
          {
            localObject = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
            kotlin.g.b.p.j(localObject, "VoipCameraCompatible.gVoipCameraInfo");
            if (((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).jpH < 2)
            {
              paramView = new StringBuilder("ExchangeCapture...gCameraNum= ");
              localObject = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
              kotlin.g.b.p.j(localObject, "VoipCameraCompatible.gVoipCameraInfo");
              Log.e("MicroMsg.Voip.CaptureRender", ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).jpH);
            }
          }
          else
          {
            ad.eYe();
            com.tencent.mm.plugin.multitalk.model.p.eWX();
            continue;
          }
          localObject = new StringBuilder("ExchangeCapture start, gCameraNum= ");
          com.tencent.mm.plugin.voip.video.camera.prev.b localb = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
          kotlin.g.b.p.j(localb, "VoipCameraCompatible.gVoipCameraInfo");
          Log.i("MicroMsg.Voip.CaptureRender", localb.jpH);
          paramView.eXS();
          localObject = paramView.FtB;
          if (!paramView.Ftr) {}
          for (boolean bool = true;; bool = false)
          {
            paramView.a((com.tencent.mm.plugin.voip.video.camera.a.c)localObject, bool);
            paramView.eXR();
            com.tencent.mm.plugin.voip.c.gxs().akX(paramView.Ftu);
            paramView.lbz = true;
            break;
          }
        }
        else if (paramView.getId() == a.e.multitalk_addmembers_action)
        {
          com.tencent.mm.plugin.multitalk.model.p.FrJ += 1;
          this.Fyj.eYk();
        }
        else
        {
          if (paramView.getId() != a.e.multitalk_screen_projector_action) {
            break;
          }
          if (!com.tencent.mm.plugin.multitalk.d.e.eZO())
          {
            if (this.FzV.getVisibility() != 0)
            {
              paramView = new g(this.Fyj, 2, 3, false);
              paramView.ah(this.Fyj.getResources().getString(a.h.app_i_know));
              paramView.ayu(1);
              int i = Color.parseColor("#07C160");
              if (paramView.OEq != null) {
                paramView.OEq.setTextColor(i);
              }
              paramView.ayv(a.f.screen_project_education_page);
              paramView.YnF = new g.a()
              {
                public final void onClick()
                {
                  AppMethodBeat.i(196291);
                  paramView.bYF();
                  com.tencent.mm.plugin.multitalk.model.p.FrK += 1;
                  if (ad.eYc().FrY != null) {
                    com.tencent.mm.plugin.multitalk.model.p.q(ad.eYc().FrY.FmO, 1, 1, 1);
                  }
                  com.tencent.mm.plugin.multitalk.d.f localf = com.tencent.mm.plugin.multitalk.d.f.FEQ;
                  com.tencent.mm.plugin.multitalk.d.f.faa();
                  p.f(p.this).eYl();
                  AppMethodBeat.o(196291);
                }
              };
              paramView.eik();
            }
            for (;;)
            {
              com.tencent.mm.plugin.newtips.a.fiO().aap(35);
              com.tencent.mm.plugin.multitalk.d.e.eZP();
              break;
              this.FzV.setVisibility(8);
              paramView = new g(this.Fyj, 1, 3, false);
              paramView.d(this.Fyj.getResources().getString(a.h.app_cancel), this.Fyj.getResources().getString(a.h.screen_project_show_ok_btn));
              paramView.ays(Color.parseColor("#07C160"));
              paramView.ayt(0);
              paramView.ayv(a.f.screen_project_education_page);
              paramView.a(new g.a()new g.a
              {
                public final void onClick()
                {
                  AppMethodBeat.i(200124);
                  paramView.bYF();
                  AppMethodBeat.o(200124);
                }
              }, new g.a()
              {
                public final void onClick()
                {
                  AppMethodBeat.i(205852);
                  paramView.bYF();
                  com.tencent.mm.plugin.multitalk.model.p.FrK += 1;
                  if (ad.eYc().FrY != null) {
                    com.tencent.mm.plugin.multitalk.model.p.q(ad.eYc().FrY.FmO, 1, 1, 1);
                  }
                  com.tencent.mm.plugin.multitalk.d.f localf = com.tencent.mm.plugin.multitalk.d.f.FEQ;
                  com.tencent.mm.plugin.multitalk.d.f.faa();
                  p.f(p.this).eYl();
                  AppMethodBeat.o(205852);
                }
              });
              paramView.eik();
            }
          }
          com.tencent.mm.plugin.multitalk.model.p.FrK += 1;
          if (ad.eYc().FrY != null) {
            com.tencent.mm.plugin.multitalk.model.p.q(ad.eYc().FrY.FmO, 1, 1, 1);
          }
          paramView = com.tencent.mm.plugin.multitalk.d.f.FEQ;
          com.tencent.mm.plugin.multitalk.d.f.faa();
          this.Fyj.eYl();
        }
      }
    } while (paramView.getId() != a.e.btn_split);
    if (ar.atR(this.Fyj.getTaskId()))
    {
      az.a(az.hXf(), this.Fyj.getTaskId(), 0);
      com.tencent.mm.ui.u.a(com.tencent.mm.ui.u.hHB(), this.Fyj.getTaskId(), 0);
      this.FzS.setBackgroundResource(a.g.icons_outlined_sperated);
    }
    for (;;)
    {
      MultiTalkMainUI.eYn();
      break;
      az.a(az.hXf(), this.Fyj.getTaskId(), 2);
      com.tencent.mm.ui.u.a(com.tencent.mm.ui.u.hHB(), this.Fyj.getTaskId(), 2);
      this.FzS.setBackgroundResource(a.g.icons_outlined_merge);
    }
  }
  
  public final void va(boolean paramBoolean)
  {
    AppMethodBeat.i(197899);
    boolean bool = ad.eYc().eXg();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Object localObject1;
    int i;
    int k;
    label115:
    Object localObject2;
    int j;
    if ((this.Fqe.getAdapter() != null) && (this.FzN != null))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1.clear();
      localArrayList2.clear();
      localObject1 = (a)this.Fqe.getAdapter();
      i = this.FzN.kK();
      int m;
      if (i == 0)
      {
        i = 0;
        k = this.FzN.kM() - ((a)localObject1).BcO - ((a)localObject1).Fwr;
        if ((i < 0) || (k < 0)) {
          break label454;
        }
        if (i > k) {
          break label293;
        }
        localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((a)localObject1).Fwl.get(i);
        localObject2 = this.Fst.aPL(((com.tencent.mm.plugin.multitalk.data.a)localObject2).Fmr.ZiH);
        if ((localObject2 != null) && (((b)localObject2).Fww != null) && ((((b)localObject2).Fww.eXd()) || (((b)localObject2).Fww.eYT())))
        {
          m = com.tencent.mm.plugin.multitalk.d.e.aQT(((b)localObject2).Fww.getUsername());
          localArrayList1.add(Integer.valueOf(m));
          if (bool)
          {
            j = com.tencent.mm.plugin.multitalk.b.o.Fne.Xm(m);
            if ((j != 102) && (j != 101)) {
              break label288;
            }
          }
        }
      }
      label288:
      for (j = 1;; j = 0)
      {
        localArrayList2.add(Integer.valueOf(j));
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(m) });
        i += 1;
        break label115;
        i -= ((a)localObject1).BcO;
        break;
      }
      label293:
      if (!bool) {
        aJ(localArrayList1);
      }
      j = 0;
      if (!bool) {
        break label639;
      }
      i = j;
      if (!paramBoolean)
      {
        i = j;
        if (this.FAi != null)
        {
          i = j;
          if (localArrayList1.containsAll(this.FAi))
          {
            i = j;
            if (this.FAi.containsAll(localArrayList1))
            {
              i = j;
              if (localArrayList2.containsAll(this.FAj))
              {
                i = j;
                if (this.FAj.containsAll(localArrayList2)) {
                  i = 1;
                }
              }
            }
          }
        }
      }
      label384:
      if (i == 0)
      {
        if (!bool) {
          break label687;
        }
        if (!ad.eYc().eXq().eVP())
        {
          com.tencent.mm.plugin.multitalk.b.o.Fne.aG(localArrayList1);
          Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "ilink subscribeByUserMids ok, mids:".concat(String.valueOf(localArrayList1)));
        }
      }
    }
    for (;;)
    {
      this.FAi = localArrayList1;
      if (bool) {
        this.FAj = localArrayList2;
      }
      AppMethodBeat.o(197899);
      return;
      label454:
      if (this.Fqe.getAdapter() == null) {
        break;
      }
      i = 0;
      localObject1 = ((a)this.Fqe.getAdapter()).Fwl.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
        if ((((com.tencent.mm.plugin.multitalk.data.a)localObject2).Fmt) && (i < this.FAn))
        {
          k = com.tencent.mm.plugin.multitalk.d.e.aQT(((com.tencent.mm.plugin.multitalk.data.a)localObject2).Fmr.ZiH);
          localArrayList1.add(Integer.valueOf(k));
          if (bool)
          {
            j = com.tencent.mm.plugin.multitalk.b.o.Fne.Xm(k);
            if ((j != 102) && (j != 101)) {
              break label620;
            }
          }
        }
        label620:
        for (j = 1;; j = 0)
        {
          localArrayList2.add(Integer.valueOf(j));
          Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(k) });
          if (i >= this.FAn) {
            break label625;
          }
          i += 1;
          break;
        }
      }
      label625:
      if (bool) {
        break;
      }
      aJ(localArrayList1);
      break;
      label639:
      i = j;
      if (paramBoolean) {
        break label384;
      }
      i = j;
      if (this.FAi == null) {
        break label384;
      }
      i = j;
      if (!localArrayList1.containsAll(this.FAi)) {
        break label384;
      }
      i = j;
      if (!this.FAi.containsAll(localArrayList1)) {
        break label384;
      }
      i = 1;
      break label384;
      label687:
      j = localArrayList1.size();
      localObject1 = new ArrayList();
      i = 0;
      while (i < j)
      {
        localObject2 = new a.aq();
        ((a.aq)localObject2).tQm = ((Integer)localArrayList1.get(i)).intValue();
        ((List)localObject1).add(localObject2);
        i += 1;
      }
      ad.eYc().gd((List)localObject1);
    }
  }
  
  public final void vb(boolean paramBoolean)
  {
    AppMethodBeat.i(197935);
    if (!paramBoolean) {
      this.FAt = System.currentTimeMillis();
    }
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    ad.eYe().eWt();
    if (this.FAu == null) {
      this.FAu = new com.tencent.mm.plugin.voip.video.camera.a.b(this);
    }
    ad.eYe();
    AppMethodBeat.o(197935);
  }
  
  public final void vc(boolean paramBoolean)
  {
    AppMethodBeat.i(197938);
    if ((!paramBoolean) && (this.FAt != 0L) && (System.currentTimeMillis() - this.FAt > 0L) && (ad.eYc().eWf()))
    {
      com.tencent.mm.plugin.multitalk.model.p.H(System.currentTimeMillis() - this.FAt, v.eXM());
      this.FAt = 0L;
    }
    if (!paramBoolean) {
      ad.eYe().release();
    }
    AppMethodBeat.o(197938);
  }
  
  public final void vd(boolean paramBoolean)
  {
    AppMethodBeat.i(114748);
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    if (this.Fst.eVP())
    {
      eVV();
      this.FAh.dGn();
      this.Fst.eVO();
    }
    this.cts.stopTimer();
    this.cts.removeCallbacksAndMessages(null);
    this.cts.quitSafely();
    if (!paramBoolean)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200618);
          p.i(p.this).setText(a.h.multitalk_end_wording);
          AppMethodBeat.o(200618);
        }
      });
      ad.eYc().eXm().close();
    }
    this.Fst.hS(paramBoolean);
    if (this.FAu != null)
    {
      this.FAu.unInit();
      this.FAu = null;
    }
    com.tencent.mm.am.q.bhz().b(this);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("multi_talk_config");
    if (localMultiProcessMMKV.getBoolean("has_opened_screen_cast", false)) {
      localMultiProcessMMKV.putBoolean("has_showed_tip_window", false);
    }
    com.tencent.mm.plugin.newtips.a.fiO();
    com.tencent.mm.plugin.newtips.a.i.i(this.FzX);
    AppMethodBeat.o(114748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.p
 * JD-Core Version:    0.7.0.1
 */