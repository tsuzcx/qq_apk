package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.Intent;
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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.c.o.37;
import com.tencent.mm.plugin.multitalk.e.f;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.w;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.video.camera.a.b.a;
import com.tencent.mm.plugin.voip.video.camera.a.c;
import com.tencent.mm.plugin.voip.widget.MMCheckBox;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.ag.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
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
  implements View.OnClickListener, AvatarStorage.a, com.tencent.mm.plugin.multitalk.model.b, b.a
{
  protected TextView JQB;
  public RecyclerView Lmp;
  public FrameLayout Lmq;
  public com.tencent.mm.plugin.multitalk.model.a LoH;
  protected ImageView Ltg;
  private ImageButton LuD;
  private boolean LuE;
  private int LuF;
  public MultiTalkMainUI Luv;
  public final View LvP;
  private RelativeLayout LvQ;
  public GridLayoutManager LvR;
  public View LvS;
  protected boolean LvT;
  public View LvU;
  private WeImageButton LvV;
  private WeImageView LvW;
  private View LvX;
  private View LvY;
  private View LvZ;
  public View Lwa;
  private com.tencent.mm.plugin.multitalk.ui.b.a Lwb;
  public MultiTalkControlIconLayout Lwc;
  MultiTalkControlIconLayout Lwd;
  MultiTalkControlIconLayout Lwe;
  private int Lwf;
  private int Lwg;
  private RelativeLayout Lwh;
  private RelativeLayout Lwi;
  private ConstraintLayout Lwj;
  private RelativeLayout Lwk;
  public CollapseView Lwl;
  private ArrayList<Integer> Lwm;
  private ArrayList<Integer> Lwn;
  public boolean Lwo;
  private boolean Lwp;
  private boolean Lwq;
  private int Lwr;
  RelativeLayout Lws;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a Lwt;
  View.OnClickListener Lwu;
  private Runnable Lwv;
  private boolean Lww;
  public long Lwx;
  private com.tencent.mm.plugin.voip.video.camera.a.b Lwy;
  private MTimerHandler eln;
  public boolean mHf;
  private int nHi;
  public TextView timeTV;
  private TextView titleTv;
  
  public p(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114737);
    this.LvT = false;
    this.Lwm = new ArrayList();
    this.Lwn = new ArrayList();
    this.Lwo = false;
    this.Lwp = false;
    this.Lwq = true;
    this.Lwr = (e.b.XNB * e.b.XNA);
    this.LuF = 0;
    this.Lwu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178933);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.multitalk.model.o.KyL += 1;
        paramAnonymousView = p.this;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramAnonymousView.Luv.getContext(), "android.permission.CAMERA", 22, "");
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), paramAnonymousView.Luv.getContext() });
        if (!bool)
        {
          p.this.Lwc.setChecked(false);
          com.tencent.mm.plugin.multitalk.model.o.gfH();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!ac.ggS().gfW())
        {
          p.this.Lwc.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!ac.ggS().geW())
        {
          p.this.Lwc.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!NetStatusUtil.isNetworkConnected(p.this.Luv))
        {
          com.tencent.mm.bc.e.a(p.this.Luv, a.h.voip_net_unavailable, null);
          p.this.Lwc.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        long l = com.tencent.mm.plugin.multitalk.model.u.ggE();
        if (l > 0L)
        {
          Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onClickVideoAction, isOverLoadFail is true! videoWaitMills:%s", new Object[] { Long.valueOf(l) });
          int i = (int)Math.ceil((float)l / 1000.0F);
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.h.multitalk_overload_fail_seconds_tips, new Object[] { Integer.valueOf(i) }), 0).show();
          p.this.Lwc.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        paramAnonymousView = com.tencent.mm.plugin.multitalk.e.d.LAq;
        com.tencent.mm.plugin.multitalk.e.d.zA(p.this.Lwc.LtJ.isChecked());
        if (p.this.Lwc.LtJ.isChecked())
        {
          p.this.zp(false);
          ac.ggS().ggt();
          com.tencent.mm.plugin.multitalk.model.o.gfP();
          paramAnonymousView = com.tencent.mm.plugin.multitalk.c.o.Ljn;
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStart");
          paramAnonymousView.au(new o.37(paramAnonymousView));
        }
        for (ac.ggT().LvB = true;; ac.ggT().LvB = false)
        {
          if (ac.ggS().ggg().geG())
          {
            ac.ggS();
            com.tencent.mm.plugin.multitalk.model.o.gfF();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
          p.this.zq(false);
          ac.ggS().bl(1, ac.ggS().Lof);
          com.tencent.mm.plugin.multitalk.model.o.gfQ();
          com.tencent.mm.plugin.multitalk.c.o.Ljn.drn();
        }
      }
    };
    this.Lwv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285543);
        if ((p.f(p.this) == null) || (p.f(p.this).isFinishing()))
        {
          AppMethodBeat.o(285543);
          return;
        }
        if (p.f(p.this).findViewById(a.e.net_tip_layout) != null) {
          p.f(p.this).findViewById(a.e.net_tip_layout).setOnClickListener(null);
        }
        if (p.g(p.this) != null) {
          p.g(p.this).setLinkToAutoMobileListener(null);
        }
        p.this.LvT = false;
        p.this.JQB.setVisibility(8);
        p.this.Ltg.setVisibility(8);
        AppMethodBeat.o(285543);
      }
    };
    this.Lww = false;
    this.eln = new MTimerHandler("MultiTalkTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(285564);
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(285608);
            p.i(p.this).setVisibility(8);
            p.j(p.this).setVisibility(0);
            AppMethodBeat.o(285608);
          }
        });
        AppMethodBeat.o(285564);
        return true;
      }
    }, false);
    this.nHi = 0;
    this.mHf = true;
    this.Luv = paramMultiTalkMainUI;
    Object localObject = aw.bf(paramMultiTalkMainUI);
    RelativeLayout.LayoutParams localLayoutParams;
    if (localObject != null)
    {
      this.Lwf = ((Point)localObject).x;
      this.Lwg = (this.Lwf + com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 52) + aw.getStatusBarHeight(paramMultiTalkMainUI));
      this.timeTV = ((TextView)paramMultiTalkMainUI.findViewById(a.e.time_tv));
      this.LvS = paramMultiTalkMainUI.findViewById(a.e.top_gradient);
      this.titleTv = ((TextView)paramMultiTalkMainUI.findViewById(a.e.title_tv));
      this.LvU = paramMultiTalkMainUI.findViewById(a.e.talking_layout);
      this.LuF = (com.tencent.mm.cd.a.mt(paramMultiTalkMainUI) - com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 285));
      this.Lwh = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.control_icon_layout));
      this.Lwi = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.hangup_icon_layout));
      this.Lwj = ((ConstraintLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(a.f.multitalk_control_expand, null, false));
      this.Lwk = ((RelativeLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(a.f.multitalk_control_collapse, null, false));
      this.LuD = ((ImageButton)this.Lwk.findViewById(a.e.talking_hangup_btn));
      this.Lmp = ((RecyclerView)paramMultiTalkMainUI.findViewById(a.e.talking_main_avatar_layout));
      this.LvQ = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.talking_main_top));
      this.Lmq = ((FrameLayout)paramMultiTalkMainUI.findViewById(a.e.talking_big_avatar_layout));
      this.LoH = ac.ggS().ggg();
      this.Lws = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.e.screen_cast_plugin_layout));
      this.LvP = paramMultiTalkMainUI.findViewById(a.e.top_control_layout);
      localObject = (RelativeLayout.LayoutParams)this.LvP.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = (aw.getStatusBarHeight(paramMultiTalkMainUI) + com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 12));
      this.LvP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((RelativeLayout.LayoutParams)this.Lmq.getLayoutParams()).topMargin = (com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 52) + aw.getStatusBarHeight(paramMultiTalkMainUI));
      this.LvR = new GridLayoutManager(3);
      localObject = new a(paramMultiTalkMainUI);
      this.Lmp.setLayoutManager(this.LvR);
      this.LvR.bWq = new GridLayoutManager.b()
      {
        public final int fJ(int paramAnonymousInt)
        {
          AppMethodBeat.i(178928);
          if (this.Lwz.abM(paramAnonymousInt))
          {
            paramAnonymousInt = p.a(p.this).bWl;
            AppMethodBeat.o(178928);
            return paramAnonymousInt;
          }
          AppMethodBeat.o(178928);
          return 1;
        }
      };
      localLayoutParams = (RelativeLayout.LayoutParams)this.Lmp.getLayoutParams();
      if (this.LuF <= this.Lwf) {
        break label1197;
      }
      localLayoutParams.width = this.Lwf;
      localLayoutParams.height = this.Lwg;
      label553:
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "mAvatarLastHeight is %s and talkingAvatarContainerWidth is %s", new Object[] { Integer.valueOf(this.LuF), Integer.valueOf(this.Lwf) });
      this.Lmp.setLayoutParams(localLayoutParams);
      ((a)localObject).LsE = this.LoH;
      this.Lmp.setAdapter((RecyclerView.a)localObject);
      this.Lmp.setOnScrollListener(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(285514);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (p.b(p.this)))
          {
            p.this.zo(false);
            com.tencent.mm.plugin.multitalk.model.o.yW(true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(285514);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(285522);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt1);
          localb.sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousRecyclerView = p.this;
          if (paramAnonymousInt2 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            p.a(paramAnonymousRecyclerView, bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(285522);
            return;
          }
        }
      });
      this.LoH.a(this.Lmp, this.Lmq, paramMultiTalkMainUI, this);
      this.LvV = ((WeImageButton)paramMultiTalkMainUI.findViewById(a.e.multitalk_mini_action));
      this.LvW = ((WeImageView)paramMultiTalkMainUI.findViewById(a.e.btn_split));
      this.LvX = paramMultiTalkMainUI.findViewById(a.e.multitalk_addmembers_action);
      this.LvX.setBackground(bb.m(MMApplicationContext.getContext(), a.g.icons_outlined_add, -1));
      this.LvY = paramMultiTalkMainUI.findViewById(a.e.multitalk_screen_projector_action);
      this.LvZ = paramMultiTalkMainUI.findViewById(a.e.multi_screen_project_red_dot);
      this.Lwb = new com.tencent.mm.plugin.multitalk.ui.b.a(paramMultiTalkMainUI, this.LvY, "screenShare", this.LvZ);
      this.LvY.setBackground(bb.m(paramMultiTalkMainUI, a.g.icons_outlined_board, paramMultiTalkMainUI.getResources().getColor(a.b.White)));
      this.LvX.bringToFront();
      this.LvX.setOnClickListener(this);
      this.Lwc = ((MultiTalkControlIconLayout)this.Lwj.findViewById(a.e.multitalk_video_action));
      this.Lwc.setIconEnabled(ac.ggS().geW());
      this.Lwc.setOnClickListener(this.Lwu);
      this.Lwd = ((MultiTalkControlIconLayout)this.Lwj.findViewById(a.e.multitalk_mute_action));
      this.Lwd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178931);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.multitalk.model.o.LnU += 1;
          paramAnonymousView = ac.ggS();
          boolean bool;
          if (!p.this.Lwd.LtJ.isChecked())
          {
            bool = true;
            paramAnonymousView.zc(bool);
            if (!p.this.Lwd.LtJ.isChecked()) {
              break label157;
            }
            p.this.Lwd.setChecked(false);
            com.tencent.mm.plugin.multitalk.model.o.gfL();
            ac.ggR().yS(true);
            ac.ggT().LvC = true;
          }
          for (;;)
          {
            if (ac.ggS().ggg().geG())
            {
              paramAnonymousView = com.tencent.mm.plugin.multitalk.e.d.LAq;
              com.tencent.mm.plugin.multitalk.e.d.jT(5, 2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178931);
            return;
            bool = false;
            break;
            label157:
            p.this.Lwd.setChecked(true);
            ac.ggT().LvC = false;
            com.tencent.mm.plugin.multitalk.model.o.gfM();
            ac.ggR().yS(false);
          }
        }
      });
      this.Lwe = ((MultiTalkControlIconLayout)this.Lwj.findViewById(a.e.multitalk_handsfree_action));
      this.Lwe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178932);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (p.this.Lwe.isEnabled())
          {
            com.tencent.mm.plugin.multitalk.model.o.LnV += 1;
            ac.ggS().zb(p.this.Lwe.LtJ.isChecked());
            p.this.ghI();
            if (!p.this.Lwe.LtJ.isChecked()) {
              break label158;
            }
            p.this.Lwe.setChecked(true);
            com.tencent.mm.plugin.multitalk.model.o.gfN();
            ac.ggR().yR(true);
          }
          for (;;)
          {
            if (ac.ggS().ggg().geG())
            {
              paramAnonymousView = com.tencent.mm.plugin.multitalk.e.d.LAq;
              com.tencent.mm.plugin.multitalk.e.d.jT(6, 2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178932);
            return;
            label158:
            p.this.Lwe.setChecked(false);
            com.tencent.mm.plugin.multitalk.model.o.gfO();
            ac.ggR().yR(false);
          }
        }
      });
      this.Lwl = ((CollapseView)paramMultiTalkMainUI.findViewById(a.e.general_collapse_layout));
      this.Lwa = this.Lwk.findViewById(a.e.multitalk_convert_camera_btn);
      localObject = this.Lwd;
      if (ac.ggS().lAj) {
        break label1237;
      }
      bool1 = true;
      label935:
      ((MultiTalkControlIconLayout)localObject).setChecked(bool1);
      this.Lwe.setChecked(ac.ggS().snA);
      this.Lwc.setChecked(com.tencent.mm.plugin.multitalk.model.u.abK(ac.ggS().Lod));
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.Lwg) });
      this.LuD.setOnClickListener(this);
      this.LvV.bringToFront();
      this.LvV.setOnClickListener(this);
      this.LvV.setImageDrawable(bb.m(MMApplicationContext.getContext(), a.g.icons_outlined_min_window, -1));
      this.LvV.setIconColor(-1);
      this.LvY.setOnClickListener(this);
      this.Lwa.setOnClickListener(this);
      q.bFp().a(this);
      this.LvW.setOnClickListener(this);
      if ((aw.jkS()) || (aj.aAy(paramMultiTalkMainUI.getTaskId()))) {
        this.LvW.setVisibility(0);
      }
      if (!aw.aAj(paramMultiTalkMainUI.getTaskId())) {
        break label1242;
      }
      this.LvW.setBackground(bb.m(MMApplicationContext.getContext(), a.g.icons_outlined_merge, -1));
      label1123:
      if (!com.tencent.mm.plugin.multitalk.model.u.abK(ac.ggS().Lod)) {
        break label1262;
      }
      this.Lwa.setVisibility(0);
      ghJ();
      label1147:
      if (ac.ggS().LoD != null)
      {
        ac.ggS();
        if (com.tencent.mm.plugin.multitalk.b.b.gdX()) {
          break label1274;
        }
      }
    }
    label1197:
    label1237:
    label1242:
    label1262:
    label1274:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      yP(bool1);
      ghI();
      AppMethodBeat.o(114737);
      return;
      this.Lwf = com.tencent.mm.cd.a.ms(paramMultiTalkMainUI.getContext());
      break;
      localLayoutParams.width = this.LuF;
      localLayoutParams.height = (this.LuF + com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 52) + aw.getStatusBarHeight(paramMultiTalkMainUI));
      localLayoutParams.addRule(14);
      break label553;
      bool1 = false;
      break label935;
      this.LvW.setBackground(bb.m(MMApplicationContext.getContext(), a.g.icons_outlined_sperated, -1));
      break label1123;
      this.Lwa.setVisibility(8);
      break label1147;
    }
  }
  
  private void C(Boolean paramBoolean)
  {
    AppMethodBeat.i(285507);
    if (paramBoolean.booleanValue())
    {
      this.LvV.setImageDrawable(bb.m(MMApplicationContext.getContext(), a.g.icons_filled_back, -1));
      this.LvV.setIconColor(-1);
      this.LvS.getLayoutParams().height = (com.tencent.mm.cd.a.fromDPToPix(this.Luv, 52) + aw.getStatusBarHeight(this.Luv));
      this.LvS.setBackgroundColor(this.Luv.getResources().getColor(a.b.default_bg_color));
      this.timeTV.setVisibility(4);
      this.LvX.setVisibility(4);
      this.LvY.setVisibility(4);
      AppMethodBeat.o(285507);
      return;
    }
    this.LvV.setImageDrawable(bb.m(MMApplicationContext.getContext(), a.g.icons_outlined_min_window, -1));
    this.LvV.setIconColor(-1);
    this.LvS.getLayoutParams().height = com.tencent.mm.cd.a.fromDPToPix(this.Luv, this.Luv.getResources().getDimension(a.c.main_ui_statusbar_height));
    this.LvS.setBackground(this.Luv.getResources().getDrawable(a.d.multitalk_status_bar));
    this.timeTV.setVisibility(0);
    this.LvX.setVisibility(0);
    if (f.giX())
    {
      this.LvY.setVisibility(0);
      if (!f.giT())
      {
        com.tencent.mm.plugin.newtips.a.gtf().h(this.Lwb);
        AppMethodBeat.o(285507);
        return;
      }
      this.LvZ.setVisibility(8);
      AppMethodBeat.o(285507);
      return;
    }
    this.LvY.setVisibility(8);
    this.LvZ.setVisibility(8);
    AppMethodBeat.o(285507);
  }
  
  private void a(MultiTalkGroup paramMultiTalkGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(285467);
    if (paramMultiTalkGroup != null)
    {
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = null;
      Iterator localIterator = paramMultiTalkGroup.ahhh.iterator();
      while (localIterator.hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
        if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
        {
          localObject2 = localMultiTalkGroupMember;
          if (!localMultiTalkGroupMember.ahhi.equals(z.bAM()))
          {
            i = f.aNL(localMultiTalkGroupMember.ahhi);
            if (i == -1)
            {
              localArrayList1.add(localMultiTalkGroupMember);
              continue;
            }
            localArrayList2.add(new a(localMultiTalkGroupMember, i));
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
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { Integer.valueOf(((a)localArrayList2.get(i)).wTC) });
        ((ArrayList)localObject1).add((a)localArrayList2.get(i));
        i -= 1;
      }
      Collections.sort((List)localObject1, Collections.reverseOrder());
      Object localObject2 = new ArrayList();
      i = ((ArrayList)localObject1).size() - 1;
      while (i >= 0)
      {
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { Integer.valueOf(((a)((ArrayList)localObject1).get(i)).wTC) });
        ((ArrayList)localObject2).add(((a)((ArrayList)localObject1).get(i)).LwD);
        i -= 1;
      }
      if ((this.Lwl != null) && (!com.tencent.mm.plugin.multitalk.model.u.k(paramMultiTalkGroup).equals(paramMultiTalkGroup.ahhf))) {
        this.Lwl.setRoomKey(com.tencent.mm.plugin.multitalk.model.u.k(paramMultiTalkGroup));
      }
      ((ArrayList)localObject2).addAll(localArrayList1);
      f((ArrayList)localObject2, paramBoolean);
    }
    AppMethodBeat.o(285467);
  }
  
  private static int bd(ArrayList<Integer> paramArrayList)
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
    i = ac.ggR().LnJ.setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      Log.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.o.gfI();
      AppMethodBeat.o(178939);
      return -1;
    }
    AppMethodBeat.o(178939);
    return i;
  }
  
  private void bm(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(285515);
    this.titleTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.eln.stopTimer();
      this.eln.removeCallbacksAndMessages(null);
      if (paramBoolean) {
        this.eln.startTimer(5000L);
      }
      this.timeTV.setVisibility(8);
      AppMethodBeat.o(285515);
      return;
    }
    this.timeTV.setVisibility(0);
    AppMethodBeat.o(285515);
  }
  
  private void f(ArrayList<MultiTalkGroupMember> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(285480);
    int j = paramArrayList.size();
    int i = 3;
    if (j < 5) {
      i = 2;
    }
    Object localObject;
    if ((this.Luv.cXB() != null) && (this.Luv.cXB().findViewById(a.e.rootview) != null))
    {
      Log.printInfoStack("MicroMsg.MT.MultiTalkTalkingUILogic", "inflateLineUser", new Object[0]);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = bf.bk(this.Luv);
      this.Luv.cXB().findViewById(a.e.rootview).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.Lmp.removeAllViewsInLayout();
    if ((j > 9) || (this.Lwo))
    {
      if ((!ac.ggS().Lon) && (j > 12))
      {
        ac.ggS().Lon = true;
        aa.y(this.Luv, this.Luv.getResources().getString(a.h.multitalk_scroll_dialog), a.g.multitalk_icons_scrool);
      }
      ghF();
    }
    for (;;)
    {
      this.LvR.fI(i);
      this.Lmp.setLayoutManager(this.LvR);
      localObject = new HashSet(ac.ggS().Loj);
      ArrayList localArrayList = new ArrayList(ac.ggS().ggc().ggA());
      a locala = (a)this.Lmp.getAdapter();
      if (locala != null)
      {
        locala.Lsy = false;
        locala.e((HashSet)localObject);
        locala.bb(localArrayList);
        locala.a(paramArrayList, this.LoH);
      }
      if ((ac.ggS().gfW()) && (this.Lwc != null) && (!this.Lwc.LtJ.isChecked())) {
        ac.ggS().bl(1, ac.ggS().Lof);
      }
      if (com.tencent.mm.plugin.multitalk.model.u.abL(ac.ggS().Lod))
      {
        if (paramBoolean) {
          this.LoH.y((Set)localObject);
        }
        zo(false);
      }
      AppMethodBeat.o(285480);
      return;
      ghD();
    }
  }
  
  public static void ghC()
  {
    AppMethodBeat.i(285485);
    com.tencent.mm.plugin.multitalk.model.p localp = ac.ggS();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localp.Loj.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!z.bAM().equals(str)) {
        localHashSet.add(str);
      }
    }
    localp.Loj.clear();
    localp.Loj = localHashSet;
    if (localp.Lnt != null) {
      localp.Lnt.geZ();
    }
    AppMethodBeat.o(285485);
  }
  
  private void ghD()
  {
    AppMethodBeat.i(285490);
    if (this.Lwj.getParent() != null) {
      ((ViewGroup)this.Lwj.getParent()).removeView(this.Lwj);
    }
    if (this.Lwk.getParent() != null) {
      ((ViewGroup)this.Lwk.getParent()).removeView(this.Lwk);
    }
    Object localObject = this.Luv.findViewById(a.e.talking_bottom_action_layout);
    if (localObject != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cd.a.mt(this.Luv) * 3.6D / 100.0D));
      ((View)localObject).setLayoutParams(localLayoutParams);
    }
    this.Lwl.setVisibility(4);
    if (this.Lwh != null)
    {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.Lwh.addView(this.Lwj, (ViewGroup.LayoutParams)localObject);
    }
    this.Lwi.addView(this.Lwk);
    this.JQB = ((TextView)this.Luv.findViewById(a.e.voip_net_status_hint));
    this.Ltg = ((ImageView)this.Luv.findViewById(a.e.link_arrow));
    if (this.Ltg != null) {
      this.Ltg.setImageDrawable(bb.m(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
    }
    AppMethodBeat.o(285490);
  }
  
  private void ghF()
  {
    AppMethodBeat.i(285498);
    Object localObject;
    if (!this.Lwo)
    {
      this.Lwo = true;
      this.Lwl.setVisibility(0);
      this.Lwl.id(this.Lwk);
      this.Lwl.aI(this.Lwj, this.Luv.cXB().findViewById(a.e.talking_bottom_action_layout).getHeight());
      localObject = (RelativeLayout.LayoutParams)this.Lmp.getLayoutParams();
      if (this.LuF <= this.Lwf) {
        break label287;
      }
    }
    label287:
    for (((RelativeLayout.LayoutParams)localObject).height = (this.Lwf / 3 * 5 + com.tencent.mm.cd.a.fromDPToPix(this.Luv, 52) + aw.getStatusBarHeight(this.Luv));; ((RelativeLayout.LayoutParams)localObject).height = (this.LuF / 3 * 5 + aw.getStatusBarHeight(this.Luv)))
    {
      this.Lmp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.Lwl.findViewById(a.e.rootView).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = bf.bk(this.Luv);
      this.Lwl.findViewById(a.e.rootView).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((ac.ggS().gfW()) && (this.Lwc != null) && (!this.Lwc.LtJ.isChecked())) {
        ac.ggS().bl(1, ac.ggS().Lof);
      }
      if (this.JQB != null) {
        this.JQB.setVisibility(8);
      }
      if (this.Ltg != null) {
        this.Ltg.setVisibility(8);
      }
      this.JQB = this.Lwl.JQB;
      this.Ltg = this.Lwl.Ltg;
      this.Ltg.setImageDrawable(bb.m(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
      AppMethodBeat.o(285498);
      return;
    }
  }
  
  public final void Jd(int paramInt)
  {
    AppMethodBeat.i(285725);
    this.nHi = paramInt;
    if (ac.ggU().bsA()) {
      ac.ggU();
    }
    AppMethodBeat.o(285725);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(114753);
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    com.tencent.mm.plugin.multitalk.model.a locala = this.LoH;
    kotlin.g.b.s.u(paramString, "wxUserName");
    paramString = locala.aMG(paramString);
    if (paramString != null)
    {
      paramString = paramString.LsI;
      if (paramString != null) {
        paramString.ghL();
      }
    }
    AppMethodBeat.o(114753);
  }
  
  public final void abU(int paramInt)
  {
    AppMethodBeat.i(285584);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.Luv.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (localDisplayMetrics.heightPixels / localDisplayMetrics.density <= 540.0F)
    {
      aa.da(this.Luv, this.Luv.getString(a.h.voip_auduo_auto_switch_to_mobile_net));
      AppMethodBeat.o(285584);
      return;
    }
    if (this.JQB != null)
    {
      this.LvT = true;
      if (this.Luv.findViewById(a.e.net_tip_layout) != null) {
        this.Luv.findViewById(a.e.net_tip_layout).setOnClickListener(null);
      }
      if (this.Lwl != null) {
        this.Lwl.setLinkToAutoMobileListener(null);
      }
      if (!this.Lwo) {
        break label214;
      }
      this.Lwl.setLinkToAutoMobileListener(new CollapseView.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(285548);
          p.f(p.this).VW(1);
          AppMethodBeat.o(285548);
        }
      });
    }
    for (;;)
    {
      this.Ltg.setVisibility(0);
      this.JQB.setVisibility(0);
      this.JQB.setText(a.h.voip_auduo_auto_switch_to_mobile_net);
      this.Luv.aL(this.Lwv);
      this.Luv.n(this.Lwv, paramInt * 1000);
      AppMethodBeat.o(285584);
      return;
      label214:
      if (this.Luv.findViewById(a.e.net_tip_layout) != null) {
        this.Luv.findViewById(a.e.net_tip_layout).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(285550);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (p.this.Luv.findViewById(a.e.net_tip_layout) != null) {
              p.this.Luv.VW(1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(285550);
          }
        });
      }
    }
  }
  
  public final void abV(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(285592);
    if ((com.tencent.mm.plugin.multitalk.c.o.Ljn.Ljx >= 3600) && (!com.tencent.mm.plugin.multitalk.c.o.Ljy)) {
      com.tencent.mm.plugin.multitalk.c.o.Ljy = true;
    }
    while (i != 0)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)this.Luv.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      if (localDisplayMetrics.heightPixels / localDisplayMetrics.density <= 540.0F)
      {
        aa.da(this.Luv, this.Luv.getString(a.h.voip_audio_network_data_cost_max));
        AppMethodBeat.o(285592);
        return;
        i = 0;
      }
      else
      {
        if (this.Luv.findViewById(a.e.net_tip_layout) != null) {
          this.Luv.findViewById(a.e.net_tip_layout).setOnClickListener(null);
        }
        if (this.Lwl != null) {
          this.Lwl.setLinkToAutoMobileListener(null);
        }
        if (!this.Lwo) {
          break label236;
        }
        this.Lwl.setLinkToAutoMobileListener(new CollapseView.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(285524);
            p.f(p.this).VW(2);
            AppMethodBeat.o(285524);
          }
        });
      }
    }
    for (;;)
    {
      this.Ltg.setVisibility(8);
      this.JQB.setVisibility(0);
      this.JQB.setText(a.h.voip_audio_network_data_cost_max);
      this.Luv.aL(this.Lwv);
      this.Luv.n(this.Lwv, paramInt * 1000);
      AppMethodBeat.o(285592);
      return;
      label236:
      if (this.Luv.findViewById(a.e.net_tip_layout) != null) {
        this.Luv.findViewById(a.e.net_tip_layout).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(285541);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (p.this.Luv.findViewById(a.e.net_tip_layout) != null) {
              p.this.Luv.VW(2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(285541);
          }
        });
      }
    }
  }
  
  public final void abW(int paramInt)
  {
    AppMethodBeat.i(285824);
    if (this.Lwt != null)
    {
      this.Lwt.setOrientation(paramInt);
      if (this.Lwl != null) {
        this.Lwl.abQ(paramInt);
      }
      if (this.Lwa != null) {
        this.Lwa.setRotation(paramInt);
      }
      if (this.Lwc != null) {
        this.Lwc.abQ(paramInt);
      }
      if (this.Lwe != null) {
        this.Lwe.abQ(paramInt);
      }
      if (this.Lwd != null) {
        this.Lwd.abQ(paramInt);
      }
    }
    AppMethodBeat.o(285824);
  }
  
  public final boolean bsA()
  {
    AppMethodBeat.i(285745);
    boolean bool = ac.ggU().bsA();
    AppMethodBeat.o(285745);
    return bool;
  }
  
  public final void bty()
  {
    AppMethodBeat.i(285604);
    if ((this.Lwc != null) && (this.Lwc.LtJ.isChecked()))
    {
      zq(false);
      ac.ggS().bl(1, ac.ggS().Lof);
      com.tencent.mm.plugin.multitalk.model.o.gfQ();
      com.tencent.mm.plugin.multitalk.c.o.Ljn.drn();
      com.tencent.mm.plugin.multitalk.e.d locald = com.tencent.mm.plugin.multitalk.e.d.LAq;
      com.tencent.mm.plugin.multitalk.e.d.zA(false);
      aa.showTextToast(this.Luv, this.Luv.getResources().getString(a.h.screen_project_close_camera));
      ac.ggT().LvB = false;
    }
    AppMethodBeat.o(285604);
  }
  
  public final void ct(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(285692);
    if (TextUtils.isEmpty(paramString))
    {
      bm(8, paramBoolean);
      AppMethodBeat.o(285692);
      return;
    }
    this.titleTv.setText(paramString);
    bm(0, paramBoolean);
    AppMethodBeat.o(285692);
  }
  
  public final int efM()
  {
    AppMethodBeat.i(285817);
    int i = aw.getStatusBarHeight(this.Luv);
    AppMethodBeat.o(285817);
    return i;
  }
  
  public final void f(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114744);
    this.LoH.x(paramHashSet);
    zo(false);
    AppMethodBeat.o(114744);
  }
  
  public final void gau()
  {
    AppMethodBeat.i(285707);
    if (ac.ggS().LoD != null)
    {
      ac.ggS();
      if (com.tencent.mm.plugin.multitalk.b.b.gdX()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      yP(bool);
      AppMethodBeat.o(285707);
      return;
    }
  }
  
  public final int[] geK()
  {
    return new int[] { this.Lwf, this.Lwg };
  }
  
  public final boolean geL()
  {
    AppMethodBeat.i(285813);
    if ((NetStatusUtil.is2G(this.Luv)) || (NetStatusUtil.is3G(this.Luv)))
    {
      AppMethodBeat.o(285813);
      return true;
    }
    AppMethodBeat.o(285813);
    return false;
  }
  
  public final void geM()
  {
    AppMethodBeat.i(285641);
    this.LvX.setVisibility(0);
    this.LvV.setVisibility(0);
    if ((aw.jkS()) || (aj.aAy(this.Luv.getTaskId()))) {
      this.LvW.setVisibility(0);
    }
    if (f.giX())
    {
      this.LvY.setVisibility(0);
      if (!f.giT())
      {
        com.tencent.mm.plugin.newtips.a.gtf().h(this.Lwb);
        AppMethodBeat.o(285641);
        return;
      }
      this.LvZ.setVisibility(8);
    }
    AppMethodBeat.o(285641);
  }
  
  public final void geN()
  {
    AppMethodBeat.i(285647);
    this.LvX.setVisibility(8);
    this.LvY.setVisibility(8);
    this.LvZ.setVisibility(8);
    this.LvV.setVisibility(8);
    this.LvW.setVisibility(8);
    AppMethodBeat.o(285647);
  }
  
  public final void geO()
  {
    AppMethodBeat.i(285672);
    C(Boolean.TRUE);
    ghF();
    if ((this.Lwl != null) && (this.Lwo))
    {
      CollapseView localCollapseView = this.Lwl;
      localCollapseView.HAo.setTag(Boolean.TRUE);
      localCollapseView.ig(localCollapseView.Ltf);
      localCollapseView.HAo.animate().setDuration(localCollapseView.duration).rotation(270.0F);
      localCollapseView.Ltl.setTag(Boolean.TRUE);
      localCollapseView.ie(localCollapseView.Ltl);
    }
    AppMethodBeat.o(285672);
  }
  
  public final void geP()
  {
    AppMethodBeat.i(285683);
    C(Boolean.FALSE);
    a(ac.ggS().Lol, false);
    AppMethodBeat.o(285683);
  }
  
  public final void geQ()
  {
    AppMethodBeat.i(285667);
    if (this.Lwq)
    {
      AppMethodBeat.o(285667);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation2.setDuration(150L);
    this.Lwq = true;
    this.LvS.setAnimation(localAlphaAnimation1);
    this.LvS.setVisibility(0);
    this.LvP.setAnimation(localAlphaAnimation1);
    this.LvP.setVisibility(0);
    this.Lwl.setAnimation(localAlphaAnimation2);
    this.Lwl.setVisibility(0);
    AppMethodBeat.o(285667);
  }
  
  public final void geR()
  {
    AppMethodBeat.i(285658);
    if (!this.Lwq)
    {
      AppMethodBeat.o(285658);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation1.setDuration(150L);
    this.Lwq = false;
    this.LvS.setAnimation(localAlphaAnimation2);
    this.LvS.setVisibility(4);
    this.LvP.setAnimation(localAlphaAnimation2);
    this.LvP.setVisibility(4);
    this.Lwl.setAnimation(localAlphaAnimation1);
    this.Lwl.setVisibility(4);
    this.LvY.setVisibility(4);
    this.LvZ.setVisibility(8);
    AppMethodBeat.o(285658);
  }
  
  public final void geS()
  {
    AppMethodBeat.i(285755);
    this.Lwt = new com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a(this.Luv);
    Object localObject = this.Lwt;
    RelativeLayout localRelativeLayout = this.Lws;
    kotlin.g.b.s.u(localRelativeLayout, "rootView");
    localRelativeLayout.removeAllViews();
    localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a)localObject).LzU;
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.i)localObject).Q(localRelativeLayout);
    }
    AppMethodBeat.o(285755);
  }
  
  public final void geT()
  {
    AppMethodBeat.i(285763);
    if (this.Lwt != null)
    {
      abW(0);
      Object localObject = this.Lwt.LzU;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.i)localObject).Lyk.release();
      }
      localObject = this.Lwt;
      RelativeLayout localRelativeLayout = this.Lws;
      kotlin.g.b.s.u(localRelativeLayout, "rootView");
      localRelativeLayout.removeAllViews();
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a)localObject).LzU;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.i)localObject).zv(false);
      }
      this.Lwt = null;
      zo(true);
    }
    AppMethodBeat.o(285763);
  }
  
  public final void ghE()
  {
    AppMethodBeat.i(285598);
    this.Lwl.setVisibility(4);
    AppMethodBeat.o(285598);
  }
  
  public final void ghG()
  {
    AppMethodBeat.i(285651);
    this.LvU.setVisibility(8);
    this.LvS.setVisibility(8);
    AppMethodBeat.o(285651);
  }
  
  public final void ghH()
  {
    AppMethodBeat.i(285780);
    this.LvU.setVisibility(8);
    this.LvX.setVisibility(8);
    this.LvY.setVisibility(8);
    this.LvZ.setVisibility(8);
    AppMethodBeat.o(285780);
  }
  
  final void ghI()
  {
    AppMethodBeat.i(114756);
    if (this.Lwe.isEnabled()) {
      ac.ggS().ze(this.Lwe.LtJ.isChecked());
    }
    AppMethodBeat.o(114756);
  }
  
  public final void ghJ()
  {
    AppMethodBeat.i(285832);
    if (ac.ggU().gfn())
    {
      this.Lwa.setContentDescription(this.Luv.getString(a.h.multitalk_fore_camera_desc));
      AppMethodBeat.o(285832);
      return;
    }
    this.Lwa.setContentDescription(this.Luv.getString(a.h.multitalk_back_camera_desc));
    AppMethodBeat.o(285832);
  }
  
  public final void o(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114738);
    if ((!this.Luv.ghh()) && (!this.LoH.geG())) {
      if (!this.LoH.geG())
      {
        this.LvU.setVisibility(0);
        this.Lwc.setIconEnabled(ac.ggS().geW());
        this.LvX.setVisibility(0);
        if (!ac.ggS().geW()) {
          break label193;
        }
        if (this.Luv.ghh()) {
          break label163;
        }
        if (f.giX())
        {
          this.LvY.setVisibility(0);
          if (f.giT()) {
            break label151;
          }
          com.tencent.mm.plugin.newtips.a.gtf().h(this.Lwb);
        }
      }
    }
    for (;;)
    {
      a(paramMultiTalkGroup, true);
      this.LoH.a(this.Lmp, this.Lmq, this.Luv, this);
      ghI();
      AppMethodBeat.o(114738);
      return;
      label151:
      this.LvZ.setVisibility(8);
      continue;
      label163:
      this.LvY.setVisibility(8);
      this.LvZ.setVisibility(8);
      this.LvX.setVisibility(8);
      continue;
      label193:
      this.LvY.setVisibility(8);
      this.LvZ.setVisibility(8);
    }
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(114743);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (!this.mHf)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
    }
    if (paramView.getId() == a.e.talking_hangup_btn)
    {
      ac.ggS().j(true, false, false);
      paramView = paramView.getContext();
      if ((paramView != null) && (!com.tencent.mm.compatible.e.b.dh(paramView))) {
        com.tencent.threadpool.h.ahAA.o(new p.3(this), 2000L);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
      if (paramView.getId() == a.e.multitalk_mini_action)
      {
        if (this.LoH.geG())
        {
          geM();
          this.Lwl.exz();
          this.LoH.geF();
          zo(true);
        }
        else
        {
          com.tencent.mm.plugin.multitalk.model.o.LnT += 1;
          ac.ggS().za(true);
          com.tencent.mm.plugin.multitalk.model.o.gfS();
        }
      }
      else if (paramView.getId() == a.e.multitalk_convert_camera_btn)
      {
        paramView = ac.ggU();
        paramView.Lnu = 0L;
        paramView = paramView.Lnv;
        if (paramView != null)
        {
          if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP < 2) {
            Log.e("MicroMsg.Voip.CaptureRender", kotlin.g.b.s.X("ExchangeCapture...gCameraNum= ", Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP)));
          }
        }
        else
        {
          ac.ggU();
          com.tencent.mm.plugin.multitalk.model.o.gfR();
          ghJ();
          continue;
        }
        Log.i("MicroMsg.Voip.CaptureRender", kotlin.g.b.s.X("ExchangeCapture start, gCameraNum= ", Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP)));
        paramView.ggH();
        localObject = paramView.LpV;
        if (!paramView.LpL) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.a((c)localObject, bool);
          paramView.ggG();
          if (!w.drd()) {
            SubCoreVoip.hVp().aqt(paramView.LpO);
          }
          paramView.nGD = true;
          break;
        }
      }
      else if (paramView.getId() == a.e.multitalk_addmembers_action)
      {
        com.tencent.mm.plugin.multitalk.model.o.LnW += 1;
        paramView = this.Luv;
        if (!paramView.LrH)
        {
          paramView.LrH = true;
          localObject = new Intent(paramView, MultiTalkAddMembersUI.class);
          ArrayList localArrayList = new ArrayList();
          if (ac.ggS().Lol != null)
          {
            Iterator localIterator = ac.ggS().Lol.ahhh.iterator();
            while (localIterator.hasNext())
            {
              MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
              if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
                localArrayList.add(localMultiTalkGroupMember.ahhi);
              }
            }
            ((Intent)localObject).putExtra("titile", paramView.getString(a.h.multitalk_add_contact));
            ((Intent)localObject).putExtra("chatroomName", ac.ggS().Lol.LiV);
            ((Intent)localObject).putExtra("always_select_contact", Util.listToString(localArrayList, ","));
            ((Intent)localObject).putExtra("key_need_gallery", false);
            paramView.startActivityForResult((Intent)localObject, 1);
          }
        }
      }
      else if (paramView.getId() == a.e.multitalk_screen_projector_action)
      {
        paramView = com.tencent.mm.plugin.multitalk.e.d.LAq;
        com.tencent.mm.plugin.multitalk.e.d.sessionId = System.currentTimeMillis();
        com.tencent.mm.plugin.multitalk.e.d.ace(1);
        if (!f.giT())
        {
          if (this.LvZ.getVisibility() != 0)
          {
            paramView = new j(this.Luv, 2, 3, false);
            paramView.au(this.Luv.getResources().getString(a.h.app_i_know));
            paramView.aFe(1);
            paramView.aFc(Color.parseColor("#07C160"));
            paramView.aFf(a.f.screen_project_education_page);
            paramView.agfR = new j.a()
            {
              public final void onClick()
              {
                AppMethodBeat.i(285557);
                paramView.cyW();
                com.tencent.mm.plugin.multitalk.model.o.LnX += 1;
                if (ac.ggS().Lol != null)
                {
                  ac.ggS();
                  com.tencent.mm.plugin.multitalk.model.o.gfF();
                }
                g localg = g.LAS;
                g.gjf();
                p.f(p.this).ghg();
                AppMethodBeat.o(285557);
              }
            };
            paramView.dDn();
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.gtf().aeI(35);
            f.giU();
            break;
            this.LvZ.setVisibility(8);
            paramView = new j(this.Luv, 1, 3, false);
            paramView.d(this.Luv.getResources().getString(a.h.app_cancel), this.Luv.getResources().getString(a.h.screen_project_show_ok_btn));
            paramView.aFb(Color.parseColor("#07C160"));
            paramView.aFd(0);
            paramView.aFf(a.f.screen_project_education_page);
            paramView.a(new p.5(this, paramView), new j.a()
            {
              public final void onClick()
              {
                AppMethodBeat.i(285572);
                paramView.cyW();
                com.tencent.mm.plugin.multitalk.model.o.LnX += 1;
                if (ac.ggS().Lol != null)
                {
                  ac.ggS();
                  com.tencent.mm.plugin.multitalk.model.o.gfF();
                }
                g localg = g.LAS;
                g.gjf();
                p.f(p.this).ghg();
                AppMethodBeat.o(285572);
              }
            });
            paramView.dDn();
          }
        }
        com.tencent.mm.plugin.multitalk.model.o.LnX += 1;
        if (ac.ggS().Lol != null)
        {
          ac.ggS();
          com.tencent.mm.plugin.multitalk.model.o.gfF();
        }
        paramView = g.LAS;
        g.gjf();
        this.Luv.ghg();
      }
      else if (paramView.getId() == a.e.btn_split)
      {
        ag.a(this.Luv.getTaskId(), new ag.a()
        {
          public final void fnV()
          {
            AppMethodBeat.i(285561);
            p.h(p.this).setBackgroundResource(a.g.icons_outlined_merge);
            AppMethodBeat.o(285561);
          }
          
          public final void fnW()
          {
            AppMethodBeat.i(285568);
            p.h(p.this).setBackgroundResource(a.g.icons_outlined_sperated);
            AppMethodBeat.o(285568);
          }
        });
        MultiTalkMainUI.ghi();
      }
    }
  }
  
  public final void yP(boolean paramBoolean)
  {
    AppMethodBeat.i(285793);
    if (this.Lwe != null)
    {
      this.Lwe.setEnabled(paramBoolean);
      this.Lwe.setIconEnabled(paramBoolean);
    }
    AppMethodBeat.o(285793);
  }
  
  public final void zo(boolean paramBoolean)
  {
    AppMethodBeat.i(285618);
    boolean bool = ac.ggS().gfV();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Object localObject1;
    int i;
    int k;
    label115:
    Object localObject2;
    int j;
    if ((this.Lmp.getAdapter() != null) && (this.LvR != null))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1.clear();
      localArrayList2.clear();
      localObject1 = (a)this.Lmp.getAdapter();
      i = this.LvR.Jv();
      int m;
      if (i == 0)
      {
        i = 0;
        k = this.LvR.Jx() - ((a)localObject1).xZt - ((a)localObject1).LsD;
        if ((i < 0) || (k < 0)) {
          break label454;
        }
        if (i > k) {
          break label293;
        }
        localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((a)localObject1).Lsx.get(i);
        localObject2 = this.LoH.aMG(((com.tencent.mm.plugin.multitalk.data.a)localObject2).Liv.ahhi);
        if ((localObject2 != null) && (((b)localObject2).LsI != null) && ((((b)localObject2).LsI.gfU()) || (((b)localObject2).LsI.ghR())))
        {
          m = f.aNL(((b)localObject2).LsI.getUsername());
          localArrayList1.add(Integer.valueOf(m));
          if (bool)
          {
            j = com.tencent.mm.plugin.multitalk.c.o.Ljn.abo(m);
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
        i -= ((a)localObject1).xZt;
        break;
      }
      label293:
      if (!bool) {
        bd(localArrayList1);
      }
      j = 0;
      if (!bool) {
        break label639;
      }
      i = j;
      if (!paramBoolean)
      {
        i = j;
        if (this.Lwm != null)
        {
          i = j;
          if (localArrayList1.containsAll(this.Lwm))
          {
            i = j;
            if (this.Lwm.containsAll(localArrayList1))
            {
              i = j;
              if (localArrayList2.containsAll(this.Lwn))
              {
                i = j;
                if (this.Lwn.containsAll(localArrayList2)) {
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
        if (!ac.ggS().ggg().geG())
        {
          com.tencent.mm.plugin.multitalk.c.o.Ljn.ba(localArrayList1);
          Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "ilink subscribeByUserMids ok, mids:".concat(String.valueOf(localArrayList1)));
        }
      }
    }
    for (;;)
    {
      this.Lwm = localArrayList1;
      if (bool) {
        this.Lwn = localArrayList2;
      }
      AppMethodBeat.o(285618);
      return;
      label454:
      if (this.Lmp.getAdapter() == null) {
        break;
      }
      i = 0;
      localObject1 = ((a)this.Lmp.getAdapter()).Lsx.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
        if ((((com.tencent.mm.plugin.multitalk.data.a)localObject2).Liw) && (i < this.Lwr))
        {
          k = f.aNL(((com.tencent.mm.plugin.multitalk.data.a)localObject2).Liv.ahhi);
          localArrayList1.add(Integer.valueOf(k));
          if (bool)
          {
            j = com.tencent.mm.plugin.multitalk.c.o.Ljn.abo(k);
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
          if (i >= this.Lwr) {
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
      bd(localArrayList1);
      break;
      label639:
      i = j;
      if (paramBoolean) {
        break label384;
      }
      i = j;
      if (this.Lwm == null) {
        break label384;
      }
      i = j;
      if (!localArrayList1.containsAll(this.Lwm)) {
        break label384;
      }
      i = j;
      if (!this.Lwm.containsAll(localArrayList1)) {
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
        ((a.aq)localObject2).wTC = ((Integer)localArrayList1.get(i)).intValue();
        ((List)localObject1).add(localObject2);
        i += 1;
      }
      ac.ggS().ja((List)localObject1);
    }
  }
  
  public final void zp(boolean paramBoolean)
  {
    AppMethodBeat.i(285715);
    if (!paramBoolean) {
      this.Lwx = System.currentTimeMillis();
    }
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    ac.ggU().gfo();
    if (this.Lwy == null) {
      this.Lwy = new com.tencent.mm.plugin.voip.video.camera.a.b(this);
    }
    ac.ggU();
    AppMethodBeat.o(285715);
  }
  
  public final void zq(boolean paramBoolean)
  {
    AppMethodBeat.i(285736);
    if ((!paramBoolean) && (this.Lwx != 0L) && (System.currentTimeMillis() - this.Lwx > 0L) && (ac.ggS().geW()))
    {
      com.tencent.mm.plugin.multitalk.model.o.V(System.currentTimeMillis() - this.Lwx, com.tencent.mm.plugin.multitalk.model.u.ggB());
      this.Lwx = 0L;
    }
    if (!paramBoolean) {
      ac.ggU().gfp();
    }
    AppMethodBeat.o(285736);
  }
  
  public final void zr(boolean paramBoolean)
  {
    AppMethodBeat.i(114748);
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    if (this.LoH.geG())
    {
      geM();
      this.Lwl.exz();
      this.LoH.geF();
    }
    this.eln.stopTimer();
    this.eln.removeCallbacksAndMessages(null);
    this.eln.quitSafely();
    if (!paramBoolean)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(285510);
          p.j(p.this).setText(a.h.multitalk_end_wording);
          AppMethodBeat.o(285510);
        }
      });
      ac.ggS().ggc().close();
    }
    this.LoH.iR(paramBoolean);
    if (this.Lwy != null)
    {
      this.Lwy.unInit();
      this.Lwy = null;
    }
    q.bFp().b(this);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("multi_talk_config");
    if (localMultiProcessMMKV.getBoolean("has_opened_screen_cast", false)) {
      localMultiProcessMMKV.putBoolean("has_showed_tip_window", false);
    }
    com.tencent.mm.plugin.newtips.a.gtf();
    com.tencent.mm.plugin.newtips.a.i.i(this.Lwb);
    AppMethodBeat.o(114748);
  }
  
  final class a
    implements Comparable
  {
    MultiTalkGroupMember LwD;
    int wTC;
    
    a(MultiTalkGroupMember paramMultiTalkGroupMember, int paramInt)
    {
      this.LwD = paramMultiTalkGroupMember;
      this.wTC = paramInt;
    }
    
    public final int compareTo(Object paramObject)
    {
      AppMethodBeat.i(285487);
      paramObject = (a)paramObject;
      int i = Integer.compare(this.wTC, paramObject.wTC);
      AppMethodBeat.o(285487);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(285482);
      String str = this.LwD + ":" + this.wTC;
      AppMethodBeat.o(285482);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.p
 * JD-Core Version:    0.7.0.1
 */