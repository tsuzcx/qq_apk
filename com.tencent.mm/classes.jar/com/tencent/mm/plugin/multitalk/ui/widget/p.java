package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.b.p.34;
import com.tencent.mm.plugin.multitalk.b.p.35;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.model.x;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class p
  implements View.OnClickListener, e.a, com.tencent.mm.plugin.multitalk.model.b
{
  private MTimerHandler cve;
  public boolean huQ;
  public TextView timeTV;
  private TextView titleTv;
  public RecyclerView zKN;
  public FrameLayout zKO;
  public com.tencent.mm.plugin.multitalk.model.a zMZ;
  public MultiTalkMainUI zSH;
  private ImageButton zSP;
  private boolean zSQ;
  private int zSR;
  public CollapseView zUA;
  private ArrayList<Integer> zUB;
  private ArrayList<Integer> zUC;
  public boolean zUD;
  private boolean zUE;
  private boolean zUF;
  private int zUG;
  RelativeLayout zUH;
  public com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a zUI;
  View.OnClickListener zUJ;
  private boolean zUK;
  public long zUL;
  public final View zUi;
  private RelativeLayout zUj;
  public GridLayoutManager zUk;
  public View zUl;
  public View zUm;
  private View zUn;
  private View zUo;
  private View zUp;
  public View zUq;
  public MultiTalkControlIconLayout zUr;
  MultiTalkControlIconLayout zUs;
  public MultiTalkControlIconLayout zUt;
  private int zUu;
  private int zUv;
  private RelativeLayout zUw;
  private RelativeLayout zUx;
  private LinearLayout zUy;
  private RelativeLayout zUz;
  
  public p(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114737);
    this.zUB = new ArrayList();
    this.zUC = new ArrayList();
    this.zUD = false;
    this.zUE = false;
    this.zUF = true;
    this.zUG = (e.b.JSI * e.b.JSH);
    this.zSR = 0;
    this.zUJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178933);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.multitalk.model.p.zbi += 1;
        paramAnonymousView = p.this;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramAnonymousView.zSH.getContext(), "android.permission.CAMERA", 22, "", "");
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), paramAnonymousView.zSH.getContext() });
        if (!bool)
        {
          p.this.zUr.setChecked(false);
          com.tencent.mm.plugin.multitalk.model.p.emY();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!ac.eom().ent())
        {
          p.this.zUr.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!ac.eom().emr())
        {
          p.this.zUr.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!NetStatusUtil.isNetworkConnected(p.this.zSH))
        {
          com.tencent.mm.bh.e.a(p.this.zSH, 2131767334, null);
          p.this.zUr.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (!v.enZ())
        {
          Toast.makeText(p.this.zSH, 2131763246, 1).show();
          p.this.zUr.setChecked(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
        }
        if (p.this.zUr.zRU.isChecked())
        {
          p.this.zUr.setChecked(true);
          p.this.rZ(false);
          ac.eom().enN();
          com.tencent.mm.plugin.multitalk.model.p.enh();
          paramAnonymousView = com.tencent.mm.plugin.multitalk.b.p.zHS;
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStart");
          paramAnonymousView.aj(new p.34(paramAnonymousView));
        }
        for (ac.eon().zTR = true;; ac.eon().zTR = false)
        {
          if (ac.eom().enA().emb()) {
            com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 0, 9, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178933);
          return;
          p.this.sa(false);
          ac.eom().aF(1, ac.eom().zMz);
          com.tencent.mm.plugin.multitalk.model.p.eni();
          paramAnonymousView = com.tencent.mm.plugin.multitalk.b.p.zHS;
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStop");
          paramAnonymousView.aj(new p.35(paramAnonymousView));
        }
      }
    };
    this.zUK = false;
    this.cve = new MTimerHandler("MultiTalkTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(239465);
        h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(239464);
            p.h(p.this).setVisibility(8);
            p.i(p.this).setVisibility(0);
            AppMethodBeat.o(239464);
          }
        });
        AppMethodBeat.o(239465);
        return true;
      }
    }, false);
    this.huQ = true;
    this.zSH = paramMultiTalkMainUI;
    this.zUu = com.tencent.mm.cb.a.jn(paramMultiTalkMainUI.getContext());
    this.zUv = (this.zUu + com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 52) + ao.getStatusBarHeight(paramMultiTalkMainUI));
    this.timeTV = ((TextView)paramMultiTalkMainUI.findViewById(2131309101));
    this.zUl = paramMultiTalkMainUI.findViewById(2131309316);
    this.titleTv = ((TextView)paramMultiTalkMainUI.findViewById(2131309249));
    this.zUm = paramMultiTalkMainUI.findViewById(2131308913);
    this.zSR = (com.tencent.mm.cb.a.jo(paramMultiTalkMainUI) - com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 285));
    this.zUw = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131299235));
    this.zUx = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131302245));
    this.zUy = ((LinearLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131495724, null, false));
    this.zUz = ((RelativeLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131495723, null, false));
    this.zSP = ((ImageButton)this.zUz.findViewById(2131308912));
    this.zKN = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131308914));
    this.zUj = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131308915));
    this.zKO = ((FrameLayout)paramMultiTalkMainUI.findViewById(2131308910));
    this.zMZ = ac.eom().enA();
    this.zUH = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131307303));
    this.zUi = paramMultiTalkMainUI.findViewById(2131309311);
    Object localObject = (RelativeLayout.LayoutParams)this.zUi.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (ao.getStatusBarHeight(paramMultiTalkMainUI) + com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 12));
    this.zUi.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((RelativeLayout.LayoutParams)this.zKO.getLayoutParams()).topMargin = (com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 52) + ao.getStatusBarHeight(paramMultiTalkMainUI));
    this.zUk = new GridLayoutManager(3);
    localObject = new a(paramMultiTalkMainUI);
    this.zKN.setLayoutManager(this.zUk);
    this.zUk.apR = new GridLayoutManager.b()
    {
      public final int bX(int paramAnonymousInt)
      {
        AppMethodBeat.i(178928);
        if (this.zUM.Rn(paramAnonymousInt))
        {
          paramAnonymousInt = p.a(p.this).apM;
          AppMethodBeat.o(178928);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(178928);
        return 1;
      }
    };
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.zKN.getLayoutParams();
    if (this.zSR > this.zUu)
    {
      localLayoutParams.width = this.zUu;
      localLayoutParams.height = this.zUv;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "mAvatarLastHeight is %s and talkingAvatarContainerWidth is %s", new Object[] { Integer.valueOf(this.zSR), Integer.valueOf(this.zUu) });
      this.zKN.setLayoutParams(localLayoutParams);
      ((a)localObject).zQP = this.zMZ;
      this.zKN.setAdapter((RecyclerView.a)localObject);
      this.zKN.setOnScrollListener(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(178929);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (p.b(p.this)))
          {
            p.this.rY(false);
            com.tencent.mm.plugin.multitalk.model.p.rE(true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178929);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousRecyclerView = p.this;
          if (paramAnonymousInt2 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            p.a(paramAnonymousRecyclerView, bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(178930);
            return;
          }
        }
      });
      this.zMZ.a(this.zKN, this.zKO, paramMultiTalkMainUI, this);
      this.zUn = paramMultiTalkMainUI.findViewById(2131305039);
      this.zUo = paramMultiTalkMainUI.findViewById(2131305026);
      this.zUo.setBackground(ar.m(MMApplicationContext.getContext(), 2131690727, -1));
      this.zUp = paramMultiTalkMainUI.findViewById(2131305054);
      this.zUp.setBackground(ar.m(paramMultiTalkMainUI, 2131690749, paramMultiTalkMainUI.getResources().getColor(2131099844)));
      if (!com.tencent.mm.plugin.multitalk.d.e.eqa()) {
        break label1038;
      }
      this.zUp.setVisibility(0);
      label677:
      this.zUo.bringToFront();
      this.zUo.setOnClickListener(this);
      this.zUr = ((MultiTalkControlIconLayout)this.zUy.findViewById(2131305069));
      this.zUr.setIconEnabled(ac.eom().emr());
      this.zUr.setOnClickListener(this.zUJ);
      this.zUs = ((MultiTalkControlIconLayout)this.zUy.findViewById(2131305044));
      this.zUs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178931);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.multitalk.model.p.zMo += 1;
          ac.eom().rK(p.this.zUs.zRU.isChecked());
          if (p.this.zUs.zRU.isChecked())
          {
            p.this.zUs.setChecked(true);
            com.tencent.mm.plugin.multitalk.model.p.enc();
            ac.eol().rA(false);
            ac.eon().zTS = true;
          }
          for (;;)
          {
            if (ac.eom().enA().emb()) {
              com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 0, 5, 2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178931);
            return;
            p.this.zUs.setChecked(false);
            ac.eon().zTS = false;
            com.tencent.mm.plugin.multitalk.model.p.ene();
            ac.eol().rA(true);
          }
        }
      });
      this.zUt = ((MultiTalkControlIconLayout)this.zUy.findViewById(2131305033));
      this.zUt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178932);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (p.this.zUt.isEnabled())
          {
            com.tencent.mm.plugin.multitalk.model.p.zMp += 1;
            ac.eom().rJ(p.this.zUt.zRU.isChecked());
            p.this.eoW();
            if (!p.this.zUt.zRU.isChecked()) {
              break label164;
            }
            p.this.zUt.setChecked(true);
            com.tencent.mm.plugin.multitalk.model.p.enf();
            ac.eol().rz(true);
          }
          for (;;)
          {
            if (ac.eom().enA().emb()) {
              com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 0, 6, 2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178932);
            return;
            label164:
            p.this.zUt.setChecked(false);
            com.tencent.mm.plugin.multitalk.model.p.eng();
            ac.eol().rz(false);
          }
        }
      });
      this.zUA = ((CollapseView)paramMultiTalkMainUI.findViewById(2131302115));
      this.zUq = this.zUz.findViewById(2131305031);
      this.zUs.setChecked(ac.eom().guh);
      this.zUt.setChecked(ac.eom().mkd);
      this.zUr.setChecked(v.Rl(ac.eom().zMx));
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.zUv) });
      this.zSP.setOnClickListener(this);
      this.zUn.bringToFront();
      this.zUn.setOnClickListener(this);
      this.zUn.setBackground(ar.m(MMApplicationContext.getContext(), 2131690835, -1));
      this.zUp.bringToFront();
      this.zUp.setOnClickListener(this);
      this.zUq.setOnClickListener(this);
      paramMultiTalkMainUI.findViewById(2131305061).setOnClickListener(this);
      com.tencent.mm.aj.p.aYn().a(this);
      if (!v.Rl(ac.eom().zMx)) {
        break label1050;
      }
      this.zUq.setVisibility(0);
    }
    for (;;)
    {
      eoW();
      AppMethodBeat.o(114737);
      return;
      localLayoutParams.width = this.zSR;
      localLayoutParams.height = (this.zSR + com.tencent.mm.cb.a.fromDPToPix(paramMultiTalkMainUI, 52) + ao.getStatusBarHeight(paramMultiTalkMainUI));
      localLayoutParams.addRule(14);
      break;
      label1038:
      this.zUp.setVisibility(8);
      break label677;
      label1050:
      this.zUq.setVisibility(8);
    }
  }
  
  private static int aB(ArrayList<Integer> paramArrayList)
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
    i = ac.eol().zMd.setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      Log.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.p.emZ();
      AppMethodBeat.o(178939);
      return -1;
    }
    AppMethodBeat.o(178939);
    return i;
  }
  
  private void aC(ArrayList<MultiTalkGroupMember> paramArrayList)
  {
    AppMethodBeat.i(178937);
    int j = paramArrayList.size();
    int i = 3;
    if (j < 5) {
      i = 2;
    }
    Object localObject;
    if ((this.zSH.chG() != null) && (this.zSH.chG().findViewById(2131307175) != null))
    {
      Log.printInfoStack("MicroMsg.MT.MultiTalkTalkingUILogic", "inflateLineUser", new Object[0]);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = au.aD(this.zSH);
      this.zSH.chG().findViewById(2131307175).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.zKN.removeAllViewsInLayout();
    if ((j > 9) || (this.zUD))
    {
      if ((!ac.eom().zMG) && (j > 12))
      {
        ac.eom().zMG = true;
        com.tencent.mm.ui.base.u.u(this.zSH, this.zSH.getResources().getString(2131763296), 2131691177);
      }
      eoT();
    }
    for (;;)
    {
      this.zUk.bW(i);
      this.zKN.setLayoutManager(this.zUk);
      localObject = new HashSet(ac.eom().zMC);
      ArrayList localArrayList = new ArrayList(ac.eom().enw().enV());
      a locala = (a)this.zKN.getAdapter();
      if (locala != null)
      {
        locala.zQJ = false;
        locala.c((HashSet)localObject);
        locala.aA(localArrayList);
        locala.a(paramArrayList, this.zMZ);
      }
      if ((ac.eom().ent()) && (this.zUr != null) && (!this.zUr.zRU.isChecked())) {
        ac.eom().aF(1, ac.eom().zMz);
      }
      if (v.Rm(ac.eom().zMx))
      {
        this.zMZ.q((Set)localObject);
        rY(false);
      }
      AppMethodBeat.o(178937);
      return;
      eoR();
    }
  }
  
  private void aG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239481);
    this.titleTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.cve.stopTimer();
      this.cve.removeCallbacksAndMessages(null);
      if (paramBoolean) {
        this.cve.startTimer(5000L);
      }
      this.timeTV.setVisibility(8);
      AppMethodBeat.o(239481);
      return;
    }
    this.timeTV.setVisibility(0);
    AppMethodBeat.o(239481);
  }
  
  public static void eoQ()
  {
    AppMethodBeat.i(239467);
    q localq = ac.eom();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = localq.zMC.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!z.aTY().equals(str)) {
        localHashSet.add(str);
      }
    }
    localq.zMC.clear();
    localq.zMC = localHashSet;
    if (localq.zLR != null) {
      localq.zLR.emu();
    }
    AppMethodBeat.o(239467);
  }
  
  private void eoR()
  {
    AppMethodBeat.i(239468);
    if (this.zUy.getParent() != null) {
      ((ViewGroup)this.zUy.getParent()).removeView(this.zUy);
    }
    if (this.zUz.getParent() != null) {
      ((ViewGroup)this.zUz.getParent()).removeView(this.zUz);
    }
    View localView = this.zSH.findViewById(2131308911);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)(com.tencent.mm.cb.a.jo(this.zSH) * 3.6D / 100.0D));
      localView.setLayoutParams(localLayoutParams);
    }
    this.zUA.setVisibility(4);
    this.zUw.addView(this.zUy);
    this.zUx.addView(this.zUz);
    AppMethodBeat.o(239468);
  }
  
  private void eoT()
  {
    AppMethodBeat.i(239470);
    if (this.zUD)
    {
      AppMethodBeat.o(239470);
      return;
    }
    this.zUD = true;
    this.zUA.setVisibility(0);
    this.zUA.setCollapseContent$53599cc9(this.zUz);
    this.zUA.am(this.zUy, this.zSH.chG().findViewById(2131308911).getHeight());
    Object localObject = (RelativeLayout.LayoutParams)this.zKN.getLayoutParams();
    if (this.zSR > this.zUu) {}
    for (((RelativeLayout.LayoutParams)localObject).height = (this.zUu / 3 * 5 + com.tencent.mm.cb.a.fromDPToPix(this.zSH, 52) + ao.getStatusBarHeight(this.zSH));; ((RelativeLayout.LayoutParams)localObject).height = (this.zSR / 3 * 5 + ao.getStatusBarHeight(this.zSH)))
    {
      this.zKN.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.zUA.findViewById(2131307159).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = au.aD(this.zSH);
      this.zUA.findViewById(2131307159).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((ac.eom().ent()) && (this.zUr != null) && (!this.zUr.zRU.isChecked())) {
        ac.eom().aF(1, ac.eom().zMz);
      }
      AppMethodBeat.o(239470);
      return;
    }
  }
  
  private void m(Boolean paramBoolean)
  {
    AppMethodBeat.i(239475);
    if (paramBoolean.booleanValue())
    {
      this.zUn.setBackgroundResource(2131230864);
      this.zUl.getLayoutParams().height = (com.tencent.mm.cb.a.fromDPToPix(this.zSH, 52) + ao.getStatusBarHeight(this.zSH));
      this.zUl.setBackgroundColor(this.zSH.getResources().getColor(2131100241));
      this.timeTV.setVisibility(4);
      this.zUo.setVisibility(4);
      this.zUp.setVisibility(4);
      AppMethodBeat.o(239475);
      return;
    }
    this.zUn.setBackground(ar.m(MMApplicationContext.getContext(), 2131690835, -1));
    this.zUl.getLayoutParams().height = com.tencent.mm.cb.a.fromDPToPix(this.zSH, this.zSH.getResources().getDimension(2131166678));
    this.zUl.setBackground(this.zSH.getResources().getDrawable(2131234087));
    this.timeTV.setVisibility(0);
    this.zUo.setVisibility(0);
    if (com.tencent.mm.plugin.multitalk.d.e.eqa())
    {
      this.zUp.setVisibility(0);
      AppMethodBeat.o(239475);
      return;
    }
    this.zUp.setVisibility(8);
    AppMethodBeat.o(239475);
  }
  
  private void o(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(178936);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = null;
    Iterator localIterator = paramMultiTalkGroup.RHa.iterator();
    Object localObject2;
    int i;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
      {
        localObject2 = localMultiTalkGroupMember;
        if (!localMultiTalkGroupMember.RHb.equals(z.aTY()))
        {
          i = com.tencent.mm.plugin.multitalk.d.e.aGF(localMultiTalkGroupMember.RHb);
          if (i == -1)
          {
            localArrayList2.add(localMultiTalkGroupMember);
            continue;
          }
          localArrayList1.add(new a(localMultiTalkGroupMember, i));
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
        if (((a)localArrayList1.get(j)).qrD <= ((a)localArrayList1.get(k)).qrD) {
          break label407;
        }
        localObject2 = (a)localArrayList1.get(j);
        localArrayList1.set(j, localArrayList1.get(k));
        localArrayList1.set(k, localObject2);
        i = 1;
      }
    }
    label407:
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
        Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { Integer.valueOf(((a)localArrayList1.get(i)).qrD) });
        ((ArrayList)localObject1).add(((a)localArrayList1.get(i)).zUQ);
        i -= 1;
      }
      if ((this.zUA != null) && (!v.k(paramMultiTalkGroup).equals(paramMultiTalkGroup.RGY))) {
        this.zUA.setRoomKey(v.k(paramMultiTalkGroup));
      }
      ((ArrayList)localObject1).addAll(localArrayList2);
      aC((ArrayList)localObject1);
      AppMethodBeat.o(178936);
      return;
    }
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(114753);
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    com.tencent.mm.plugin.multitalk.model.a locala = this.zMZ;
    kotlin.g.b.p.h(paramString, "wxUserName");
    paramString = locala.aFA(paramString);
    if (paramString != null)
    {
      paramString = paramString.zQT;
      if (paramString != null)
      {
        paramString.eoX();
        AppMethodBeat.o(114753);
        return;
      }
      AppMethodBeat.o(114753);
      return;
    }
    AppMethodBeat.o(114753);
  }
  
  public final void Rv(int paramInt)
  {
    AppMethodBeat.i(239490);
    if (this.zUI != null)
    {
      this.zUI.setOrientation(paramInt);
      if (this.zUA != null) {
        this.zUA.Rr(paramInt);
      }
      if (this.zUq != null) {
        this.zUq.setRotation(paramInt);
      }
      if (this.zUr != null) {
        this.zUr.Rr(paramInt);
      }
      if (this.zUt != null) {
        this.zUt.Rr(paramInt);
      }
      if (this.zUs != null) {
        this.zUs.Rr(paramInt);
      }
    }
    AppMethodBeat.o(239490);
  }
  
  public final void bQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(239480);
    if (TextUtils.isEmpty(paramString))
    {
      aG(8, paramBoolean);
      AppMethodBeat.o(239480);
      return;
    }
    this.titleTv.setText(paramString);
    aG(0, paramBoolean);
    AppMethodBeat.o(239480);
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114744);
    this.zMZ.p(paramHashSet);
    rY(false);
    AppMethodBeat.o(114744);
  }
  
  public final int deu()
  {
    AppMethodBeat.i(239489);
    int i = ao.getStatusBarHeight(this.zSH);
    AppMethodBeat.o(239489);
    return i;
  }
  
  public final int[] eme()
  {
    return new int[] { this.zUu, this.zUv };
  }
  
  public final boolean emf()
  {
    AppMethodBeat.i(239488);
    if ((NetStatusUtil.is2G(this.zSH)) || (NetStatusUtil.is3G(this.zSH)))
    {
      AppMethodBeat.o(239488);
      return true;
    }
    AppMethodBeat.o(239488);
    return false;
  }
  
  public final void emg()
  {
    AppMethodBeat.i(239472);
    this.zUo.setVisibility(0);
    this.zUn.setVisibility(0);
    if (com.tencent.mm.plugin.multitalk.d.e.eqa()) {
      this.zUp.setVisibility(0);
    }
    AppMethodBeat.o(239472);
  }
  
  public final void emh()
  {
    AppMethodBeat.i(239473);
    this.zUo.setVisibility(8);
    this.zUp.setVisibility(8);
    this.zUn.setVisibility(8);
    AppMethodBeat.o(239473);
  }
  
  public final void emi()
  {
    AppMethodBeat.i(239478);
    m(Boolean.TRUE);
    eoT();
    AppMethodBeat.o(239478);
  }
  
  public final void emj()
  {
    AppMethodBeat.i(239479);
    m(Boolean.FALSE);
    AppMethodBeat.o(239479);
  }
  
  public final void emk()
  {
    AppMethodBeat.i(239477);
    if (this.zUF)
    {
      AppMethodBeat.o(239477);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation2.setDuration(150L);
    this.zUF = true;
    this.zUl.setAnimation(localAlphaAnimation1);
    this.zUl.setVisibility(0);
    this.zUi.setAnimation(localAlphaAnimation1);
    this.zUi.setVisibility(0);
    this.zUA.setAnimation(localAlphaAnimation2);
    this.zUA.setVisibility(0);
    AppMethodBeat.o(239477);
  }
  
  public final void eml()
  {
    AppMethodBeat.i(239476);
    if (!this.zUF)
    {
      AppMethodBeat.o(239476);
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation1.setDuration(150L);
    this.zUF = false;
    this.zUl.setAnimation(localAlphaAnimation2);
    this.zUl.setVisibility(4);
    this.zUi.setAnimation(localAlphaAnimation2);
    this.zUi.setVisibility(4);
    this.zUA.setAnimation(localAlphaAnimation1);
    this.zUA.setVisibility(4);
    this.zUp.setVisibility(4);
    AppMethodBeat.o(239476);
  }
  
  public final void emm()
  {
    AppMethodBeat.i(239485);
    this.zUI = new com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a(this.zSH);
    Object localObject = this.zUI;
    RelativeLayout localRelativeLayout = this.zUH;
    kotlin.g.b.p.h(localRelativeLayout, "rootView");
    localRelativeLayout.removeAllViews();
    localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a)localObject).zYA;
    if (localObject != null)
    {
      ((j)localObject).A(localRelativeLayout);
      AppMethodBeat.o(239485);
      return;
    }
    AppMethodBeat.o(239485);
  }
  
  public final void emn()
  {
    AppMethodBeat.i(239486);
    if (this.zUI != null)
    {
      Rv(0);
      Object localObject = this.zUI.zYA;
      if (localObject != null) {
        ((j)localObject).zWE.release();
      }
      localObject = this.zUI;
      RelativeLayout localRelativeLayout = this.zUH;
      kotlin.g.b.p.h(localRelativeLayout, "rootView");
      localRelativeLayout.removeAllViews();
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a)localObject).zYA;
      if (localObject != null) {
        ((j)localObject).sf(false);
      }
      this.zUI = null;
    }
    AppMethodBeat.o(239486);
  }
  
  public final boolean emo()
  {
    AppMethodBeat.i(239484);
    boolean bool = ac.eoo().emo();
    AppMethodBeat.o(239484);
    return bool;
  }
  
  public final void eoS()
  {
    AppMethodBeat.i(239469);
    this.zUA.setVisibility(4);
    AppMethodBeat.o(239469);
  }
  
  public final void eoU()
  {
    AppMethodBeat.i(239474);
    this.zUm.setVisibility(8);
    this.zUl.setVisibility(8);
    AppMethodBeat.o(239474);
  }
  
  public final void eoV()
  {
    AppMethodBeat.i(239487);
    this.zUm.setVisibility(8);
    this.zUo.setVisibility(8);
    this.zUp.setVisibility(8);
    AppMethodBeat.o(239487);
  }
  
  final void eoW()
  {
    AppMethodBeat.i(114756);
    if (this.zUt.isEnabled()) {
      ac.eom().rN(this.zUt.zRU.isChecked());
    }
    AppMethodBeat.o(114756);
  }
  
  public final void n(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114738);
    if (!this.zSH.eov()) {
      if (!this.zMZ.emb())
      {
        this.zUm.setVisibility(0);
        this.zUr.setIconEnabled(ac.eom().emr());
        this.zUo.setVisibility(0);
        if (!ac.eom().emr()) {
          break label125;
        }
        if (this.zSH.eov()) {
          break label104;
        }
        if (com.tencent.mm.plugin.multitalk.d.e.eqa()) {
          this.zUp.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      o(paramMultiTalkGroup);
      eoW();
      AppMethodBeat.o(114738);
      return;
      label104:
      this.zUp.setVisibility(8);
      this.zUo.setVisibility(8);
      continue;
      label125:
      this.zUp.setVisibility(8);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114743);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (!this.huQ)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
    }
    if (paramView.getId() == 2131308912) {
      ac.eom().j(true, false, false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(114743);
      return;
      if (paramView.getId() == 2131305039)
      {
        if (this.zMZ.emb())
        {
          emg();
          this.zUA.eoD();
          this.zMZ.ema();
        }
        else
        {
          com.tencent.mm.plugin.multitalk.model.p.zMn += 1;
          ac.eom().rI(true);
          com.tencent.mm.plugin.multitalk.model.p.enk();
        }
      }
      else if (paramView.getId() == 2131305031)
      {
        paramView = ac.eoo();
        paramView.zLS = 0L;
        paramView = paramView.zLT;
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
          kotlin.g.b.p.g(localObject, "VoipCameraCompatible.gVoipCameraInfo");
          if (((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).gFx < 2)
          {
            paramView = new StringBuilder("ExchangeCapture...gCameraNum= ");
            localObject = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
            kotlin.g.b.p.g(localObject, "VoipCameraCompatible.gVoipCameraInfo");
            Log.e("MicroMsg.Voip.CaptureRender", ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).gFx);
          }
        }
        else
        {
          com.tencent.mm.plugin.multitalk.model.p.enj();
          continue;
        }
        localObject = new StringBuilder("ExchangeCapture start, gCameraNum= ");
        com.tencent.mm.plugin.voip.video.camera.prev.b localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
        kotlin.g.b.p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
        Log.i("MicroMsg.Voip.CaptureRender", localb.gFx);
        paramView.eoc();
        localObject = paramView.zOe;
        if (!paramView.zNU) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.a((com.tencent.mm.plugin.voip.video.camera.a.b)localObject, bool);
          paramView.eob();
          com.tencent.mm.plugin.voip.c.fFg().adn(paramView.zNX);
          paramView.imy = true;
          break;
        }
      }
      else if (paramView.getId() == 2131305026)
      {
        com.tencent.mm.plugin.multitalk.model.p.zMq += 1;
        this.zSH.eou();
      }
      else if (paramView.getId() == 2131305054)
      {
        paramView = new com.tencent.mm.ui.widget.a.e(this.zSH, 1, true);
        paramView.hbr();
        paramView.V(View.inflate(this.zSH, 2131495751, null), false);
        paramView.HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
          {
            AppMethodBeat.i(239462);
            paramAnonymousm.a(0, p.g(p.this).getResources().getColor(2131099844), p.g(p.this).getResources().getString(2131765005));
            if (com.tencent.mm.plugin.multitalk.d.e.eqb()) {
              paramAnonymousm.a(1, p.g(p.this).getResources().getColor(2131099844), p.g(p.this).getResources().getString(2131765003));
            }
            AppMethodBeat.o(239462);
          }
        };
        paramView.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(239463);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(239463);
              return;
              if (p.f(p.this).zRU.isChecked())
              {
                p.this.sa(false);
                ac.eom().aF(1, ac.eom().zMz);
                com.tencent.mm.plugin.multitalk.model.p.eni();
                ac.eon().zTR = false;
              }
              com.tencent.mm.plugin.multitalk.model.p.zMr += 1;
              if (ac.eom().zME != null) {
                com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 1, 1, 1);
              }
              paramAnonymousMenuItem = f.zZd;
              f.eqj();
              paramAnonymousMenuItem = p.g(p.this);
              if ((!paramAnonymousMenuItem.zPT) && (ac.eom().zME != null))
              {
                paramAnonymousMenuItem.zPT = true;
                Intent localIntent = new Intent();
                localIntent.putExtra("kintent_talker", ac.eom().zME.zHE);
                localIntent.putExtra("key_media_type", 2);
                localIntent.putExtra("scene", 3);
                com.tencent.mm.br.c.c(paramAnonymousMenuItem, "com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI", localIntent, 3);
              }
              AppMethodBeat.o(239463);
              return;
              if (p.f(p.this).zRU.isChecked())
              {
                p.this.sa(false);
                ac.eom().aF(1, ac.eom().zMz);
                com.tencent.mm.plugin.multitalk.model.p.eni();
                ac.eon().zTR = false;
              }
              if (ac.eom().zME != null) {
                com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 2, 1, 1);
              }
              paramAnonymousMenuItem = f.zZd;
              f.eqk();
              paramAnonymousMenuItem = p.g(p.this);
              paramAnonymousMenuItem.zPK.Rs(3);
              if (paramAnonymousMenuItem.zPK.isShown())
              {
                paramAnonymousMenuItem.zPI.eoG();
                paramAnonymousMenuItem.zPJ.eoS();
                paramAnonymousMenuItem.zPJ.emh();
                paramAnonymousMenuItem.zPJ.eoV();
                paramAnonymousMenuItem.zPJ.eoU();
                paramAnonymousMenuItem.zPT = false;
                AppMethodBeat.o(239463);
                return;
              }
              paramAnonymousMenuItem.zPI.eoG();
              paramAnonymousMenuItem.zPJ.n(ac.eom().zME);
            }
          }
        };
        paramView.dGm();
      }
    }
  }
  
  public final void rY(boolean paramBoolean)
  {
    AppMethodBeat.i(239471);
    boolean bool = ac.eom().ens();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Object localObject1;
    int i;
    int k;
    label115:
    Object localObject2;
    int j;
    if ((this.zKN.getAdapter() != null) && (this.zUk != null))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1.clear();
      localArrayList2.clear();
      localObject1 = (a)this.zKN.getAdapter();
      i = this.zUk.kt();
      int m;
      if (i == 0)
      {
        i = 0;
        k = this.zUk.kv() - ((a)localObject1).wqJ - ((a)localObject1).zQO;
        if ((i < 0) || (k < 0)) {
          break label454;
        }
        if (i > k) {
          break label293;
        }
        localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((a)localObject1).zQI.get(i);
        localObject2 = this.zMZ.aFA(((com.tencent.mm.plugin.multitalk.data.a)localObject2).zHg.RHb);
        if ((localObject2 != null) && (((b)localObject2).zQT != null) && ((((b)localObject2).zQT.enp()) || (((b)localObject2).zQT.epd())))
        {
          m = com.tencent.mm.plugin.multitalk.d.e.aGF(((b)localObject2).zQT.getUsername());
          localArrayList1.add(Integer.valueOf(m));
          if (bool)
          {
            j = com.tencent.mm.plugin.multitalk.b.p.zHS.QY(m);
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
        i -= ((a)localObject1).wqJ;
        break;
      }
      label293:
      if (!bool) {
        aB(localArrayList1);
      }
      j = 0;
      if (!bool) {
        break label639;
      }
      i = j;
      if (!paramBoolean)
      {
        i = j;
        if (this.zUB != null)
        {
          i = j;
          if (localArrayList1.containsAll(this.zUB))
          {
            i = j;
            if (this.zUB.containsAll(localArrayList1))
            {
              i = j;
              if (localArrayList2.containsAll(this.zUC))
              {
                i = j;
                if (this.zUC.containsAll(localArrayList2)) {
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
        if (!ac.eom().enA().emb())
        {
          com.tencent.mm.plugin.multitalk.b.p.zHS.az(localArrayList1);
          Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "ilink subscribeByUserMids ok, mids:".concat(String.valueOf(localArrayList1)));
        }
      }
    }
    for (;;)
    {
      this.zUB = localArrayList1;
      if (bool) {
        this.zUC = localArrayList2;
      }
      AppMethodBeat.o(239471);
      return;
      label454:
      if (this.zKN.getAdapter() == null) {
        break;
      }
      i = 0;
      localObject1 = ((a)this.zKN.getAdapter()).zQI.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
        if ((((com.tencent.mm.plugin.multitalk.data.a)localObject2).zHi) && (i < this.zUG))
        {
          k = com.tencent.mm.plugin.multitalk.d.e.aGF(((com.tencent.mm.plugin.multitalk.data.a)localObject2).zHg.RHb);
          localArrayList1.add(Integer.valueOf(k));
          if (bool)
          {
            j = com.tencent.mm.plugin.multitalk.b.p.zHS.QY(k);
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
          if (i >= this.zUG) {
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
      aB(localArrayList1);
      break;
      label639:
      i = j;
      if (paramBoolean) {
        break label384;
      }
      i = j;
      if (this.zUB == null) {
        break label384;
      }
      i = j;
      if (!localArrayList1.containsAll(this.zUB)) {
        break label384;
      }
      i = j;
      if (!this.zUB.containsAll(localArrayList1)) {
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
        localObject2 = new a.ar();
        ((a.ar)localObject2).qrD = ((Integer)localArrayList1.get(i)).intValue();
        ((List)localObject1).add(localObject2);
        i += 1;
      }
      ac.eom().fB((List)localObject1);
    }
  }
  
  public final void rZ(boolean paramBoolean)
  {
    AppMethodBeat.i(239482);
    if (!paramBoolean) {
      this.zUL = System.currentTimeMillis();
    }
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    ac.eoo().emF();
    AppMethodBeat.o(239482);
  }
  
  public final void sa(boolean paramBoolean)
  {
    AppMethodBeat.i(239483);
    if ((!paramBoolean) && (this.zUL != 0L) && (System.currentTimeMillis() - this.zUL > 0L) && (ac.eom().emr()))
    {
      com.tencent.mm.plugin.multitalk.model.p.A(System.currentTimeMillis() - this.zUL, v.enW());
      this.zUL = 0L;
    }
    if (!paramBoolean) {
      ac.eoo().release();
    }
    AppMethodBeat.o(239483);
  }
  
  public final void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(114748);
    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    if (this.zMZ.emb())
    {
      emg();
      this.zUA.eoD();
      this.zMZ.ema();
    }
    this.cve.stopTimer();
    this.cve.removeCallbacksAndMessages(null);
    this.cve.quitSafely();
    if (!paramBoolean)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239461);
          p.i(p.this).setText(2131763247);
          AppMethodBeat.o(239461);
        }
      });
      ac.eom().enw().close();
    }
    this.zMZ.hb(paramBoolean);
    com.tencent.mm.aj.p.aYn().b(this);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("multi_talk_config");
    if (localMultiProcessMMKV.getBoolean("has_opened_screen_cast", false)) {
      localMultiProcessMMKV.putBoolean("has_showed_tip_window", false);
    }
    AppMethodBeat.o(114748);
  }
  
  final class a
  {
    int qrD;
    MultiTalkGroupMember zUQ;
    
    a(MultiTalkGroupMember paramMultiTalkGroupMember, int paramInt)
    {
      this.zUQ = paramMultiTalkGroupMember;
      this.qrD = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.p
 * JD-Core Version:    0.7.0.1
 */