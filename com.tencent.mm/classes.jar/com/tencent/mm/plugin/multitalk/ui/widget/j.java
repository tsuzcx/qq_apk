package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.multitalk.model.k;
import com.tencent.mm.plugin.multitalk.model.k.1;
import com.tencent.mm.plugin.multitalk.model.k.a;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.t;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class j
  implements View.OnClickListener, e.a, com.tencent.mm.plugin.voip.video.f
{
  public TextView fwS;
  public boolean ghf;
  com.tencent.mm.ui.widget.a.d iAV;
  public RecyclerView tSI;
  public FrameLayout tSJ;
  private GridLayoutManager tSK;
  public View tSL;
  private View tSM;
  public View tSN;
  public View tSO;
  public MultiTalkControlIconLayout tSP;
  public MultiTalkControlIconLayout tSQ;
  public MultiTalkControlIconLayout tSR;
  private int tSS;
  private int tST;
  private RelativeLayout tSU;
  private RelativeLayout tSV;
  private RelativeLayout tSW;
  private LinearLayout tSX;
  private RelativeLayout tSY;
  private com.tencent.mm.plugin.voip.video.a tSZ;
  MultiTalkMainUI tSj;
  private ImageButton tSq;
  private boolean tSr;
  private int tSs;
  private k tTa;
  private ObservableTextureView tTb;
  public String tTc;
  private CollapseView tTd;
  private ArrayList tTe;
  private boolean tTf;
  private boolean tTg;
  private int tTh;
  View.OnClickListener tTi;
  public long tTj;
  b tTk;
  
  public j(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114737);
    this.tTe = new ArrayList();
    this.tTf = false;
    this.tTg = false;
    this.tTh = (d.b.BNk * d.b.BNj);
    this.tSs = 0;
    this.tTi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178933);
        com.tencent.mm.plugin.multitalk.model.e.tji += 1;
        paramAnonymousView = j.this;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramAnonymousView.tSj.getContext(), "android.permission.CAMERA", 22, "", "");
        ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), paramAnonymousView.tSj.getContext() });
        if (!bool)
        {
          j.this.tSP.setChecked(false);
          com.tencent.mm.plugin.multitalk.model.e.cRU();
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.p.cSO().cSk())
        {
          j.this.tSP.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.p.cSO().cRD())
        {
          j.this.tSP.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (!ay.isNetworkConnected(j.this.tSj))
        {
          com.tencent.mm.bi.e.a(j.this.tSj, 2131764895, null);
          j.this.tSP.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.j.cSG())
        {
          Toast.makeText(j.this.tSj, 2131761391, 1).show();
          j.this.tSP.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (j.this.tSP.tRF.isChecked())
        {
          j.this.nG(false);
          com.tencent.mm.plugin.multitalk.model.e.cSc();
          AppMethodBeat.o(178933);
          return;
        }
        j.this.nH(false);
        com.tencent.mm.plugin.multitalk.model.p.cSO().Hi(1);
        com.tencent.mm.plugin.multitalk.model.e.cSd();
        AppMethodBeat.o(178933);
      }
    };
    this.tTk = new b((byte)0);
    this.iAV = null;
    this.ghf = true;
    this.tSj = paramMultiTalkMainUI;
    this.tSS = com.tencent.mm.cd.a.hV(paramMultiTalkMainUI.getContext());
    this.tST = (this.tSS + com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 52) + ai.iX(paramMultiTalkMainUI));
    this.fwS = ((TextView)paramMultiTalkMainUI.findViewById(2131305822));
    this.tSL = paramMultiTalkMainUI.findViewById(2131305668);
    this.tSs = (com.tencent.mm.cd.a.hW(paramMultiTalkMainUI) - com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 285));
    this.tSV = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131298785));
    this.tSW = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131300676));
    this.tSX = ((LinearLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494971, null, false));
    this.tSY = ((RelativeLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494970, null, false));
    this.tSq = ((ImageButton)this.tSY.findViewById(2131305667));
    this.tSI = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131305669));
    this.tSJ = ((FrameLayout)paramMultiTalkMainUI.findViewById(2131305665));
    Object localObject = paramMultiTalkMainUI.findViewById(2131306002);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin = (ai.iX(paramMultiTalkMainUI) + com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 12));
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.tSJ.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 52) + ai.iX(paramMultiTalkMainUI));
    this.tSJ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.tSK = new GridLayoutManager(3);
    localObject = new a(paramMultiTalkMainUI);
    this.tSI.setLayoutManager(this.tSK);
    this.tSK.amS = new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(178928);
        if (this.tTl.Hm(paramAnonymousInt))
        {
          paramAnonymousInt = j.a(j.this).amN;
          AppMethodBeat.o(178928);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(178928);
        return 1;
      }
    };
    localLayoutParams = (RelativeLayout.LayoutParams)this.tSI.getLayoutParams();
    if (this.tSs > this.tSS)
    {
      localLayoutParams.width = this.tSS;
      localLayoutParams.height = this.tST;
      this.tSI.setLayoutParams(localLayoutParams);
      this.tSI.setAdapter((RecyclerView.a)localObject);
      this.tSI.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(178930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt1);
          localb.lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
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
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          if ((paramAnonymousInt == 0) && (j.b(j.this)))
          {
            j.c(j.this);
            com.tencent.mm.plugin.multitalk.model.e.nz(true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(178929);
        }
      });
      this.tSM = paramMultiTalkMainUI.findViewById(2131302582);
      this.tSN = paramMultiTalkMainUI.findViewById(2131302572);
      this.tSN.setBackground(am.i(aj.getContext(), 2131690325, -1));
      this.tSP = ((MultiTalkControlIconLayout)this.tSX.findViewById(2131302594));
      this.tSP.setIconEnabled(com.tencent.mm.plugin.multitalk.model.p.cSO().cRD());
      this.tSP.setOnClickListener(this.tTi);
      this.tSQ = ((MultiTalkControlIconLayout)this.tSX.findViewById(2131302583));
      this.tSQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178931);
          com.tencent.mm.plugin.multitalk.model.e.tOy += 1;
          paramAnonymousView = com.tencent.mm.plugin.multitalk.model.p.cSO();
          boolean bool = j.this.tSQ.tRF.isChecked();
          com.tencent.mm.plugin.multitalk.model.p.cSN().tOr.xq(bool);
          paramAnonymousView.ns(bool);
          if (j.this.tSQ.tRF.isChecked())
          {
            com.tencent.mm.plugin.multitalk.model.e.cRY();
            AppMethodBeat.o(178931);
            return;
          }
          com.tencent.mm.plugin.multitalk.model.e.cRZ();
          AppMethodBeat.o(178931);
        }
      });
      this.tSR = ((MultiTalkControlIconLayout)this.tSX.findViewById(2131302579));
      this.tSR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178932);
          if (j.this.tSR.isEnabled())
          {
            com.tencent.mm.plugin.multitalk.model.e.tOz += 1;
            com.tencent.mm.plugin.multitalk.model.p.cSO().nD(j.this.tSR.tRF.isChecked());
            j.this.cTa();
            if (j.this.tSR.tRF.isChecked())
            {
              com.tencent.mm.plugin.multitalk.model.e.cSa();
              AppMethodBeat.o(178932);
              return;
            }
            com.tencent.mm.plugin.multitalk.model.e.cSb();
          }
          AppMethodBeat.o(178932);
        }
      });
      this.tTd = ((CollapseView)paramMultiTalkMainUI.findViewById(2131300580));
      this.tSO = this.tSY.findViewById(2131302576);
      this.tSQ.setChecked(com.tencent.mm.plugin.multitalk.model.p.cSO().fqj);
      this.tSR.setChecked(com.tencent.mm.plugin.multitalk.model.p.cSO().tOC);
      this.tSP.setChecked(com.tencent.mm.plugin.multitalk.model.j.Hj(com.tencent.mm.plugin.multitalk.model.p.cSO().tOE));
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.tST) });
      this.tSq.setOnClickListener(this);
      this.tSM.bringToFront();
      this.tSM.setOnClickListener(this);
      this.tSM.setBackground(am.i(aj.getContext(), 2131690328, -1));
      this.tSN.bringToFront();
      this.tSN.setOnClickListener(this);
      this.tSO.setOnClickListener(this);
      com.tencent.mm.ak.p.auq().a(this);
      if (this.tSJ != null)
      {
        paramMultiTalkMainUI = c.a(paramMultiTalkMainUI, this.tSJ, this);
        paramMultiTalkMainUI.setVisibility(8);
        this.tSU = paramMultiTalkMainUI;
        this.tSJ.addView(paramMultiTalkMainUI);
      }
      this.tSJ.setVisibility(8);
      if (!com.tencent.mm.plugin.multitalk.model.j.Hj(com.tencent.mm.plugin.multitalk.model.p.cSO().tOE)) {
        break label872;
      }
      this.tSO.setVisibility(0);
    }
    for (;;)
    {
      this.tTc = "";
      cTa();
      AppMethodBeat.o(114737);
      return;
      localLayoutParams.width = this.tSs;
      localLayoutParams.height = (this.tSs + com.tencent.mm.cd.a.fromDPToPix(paramMultiTalkMainUI, 52) + ai.iX(paramMultiTalkMainUI));
      localLayoutParams.addRule(14);
      break;
      label872:
      this.tSO.setVisibility(8);
    }
  }
  
  private static int J(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(114742);
    if (!paramBoolean) {}
    for (int i = -1;; i = paramInt)
    {
      Object localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
      localObject = ((ByteBuffer)localObject).array();
      int j = com.tencent.mm.plugin.multitalk.model.p.cSN().tOr.setAppCmd(22, (byte[])localObject, 4);
      if (j < 0)
      {
        ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        AppMethodBeat.o(114742);
        return -1;
      }
      AppMethodBeat.o(114742);
      return j;
    }
  }
  
  private void ab(ArrayList<MultiTalkGroupMember> paramArrayList)
  {
    AppMethodBeat.i(178937);
    int j = paramArrayList.size();
    if (j < 5) {}
    for (int i = 2;; i = 3)
    {
      Object localObject1;
      if ((this.tSj.byJ() != null) && (this.tSj.byJ().findViewById(2131304253) != null))
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ap.eb(this.tSj);
        this.tSj.byJ().findViewById(2131304253).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.tSI.removeAllViewsInLayout();
      if ((j > 9) || (this.tTf))
      {
        this.tTd.setVisibility(0);
        this.tTd.setCollapseContent$53599cc9(this.tSY);
        this.tTd.ai(this.tSX, this.tSj.byJ().findViewById(2131305666).getHeight());
        localObject1 = (RelativeLayout.LayoutParams)this.tSI.getLayoutParams();
        if (this.tSs > this.tSS)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = (this.tSS / 3 * 5 + com.tencent.mm.cd.a.fromDPToPix(this.tSj, 52) + ai.iX(this.tSj));
          this.tSI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.tTf = true;
          if ((!com.tencent.mm.plugin.multitalk.model.p.cSO().tOK) && (j > 12))
          {
            com.tencent.mm.plugin.multitalk.model.p.cSO().tOK = true;
            t.ch(this.tSj, this.tSj.getResources().getString(2131761436));
          }
          localObject1 = (LinearLayout.LayoutParams)this.tTd.findViewById(2131304240).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ap.eb(this.tSj);
          this.tTd.findViewById(2131304240).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.tSK.bV(i);
        this.tSI.setLayoutManager(this.tSK);
        localObject1 = new HashSet(com.tencent.mm.plugin.multitalk.model.p.cSO().tOG);
        if (com.tencent.mm.plugin.multitalk.model.j.Hj(com.tencent.mm.plugin.multitalk.model.p.cSO().tOE)) {
          ((HashSet)localObject1).add(u.aqG());
        }
        Object localObject2 = (a)this.tSI.getAdapter();
        if (localObject2 != null)
        {
          ((a)localObject2).tQM = false;
          ((a)localObject2).d((HashSet)localObject1);
          ((a)localObject2).a(paramArrayList, this);
        }
        if ((com.tencent.mm.plugin.multitalk.model.p.cSO().cSk()) && (this.tSP != null) && (!this.tSP.tRF.isChecked())) {
          com.tencent.mm.plugin.multitalk.model.p.cSO().Hi(1);
        }
        AppMethodBeat.o(178937);
        return;
        ((RelativeLayout.LayoutParams)localObject1).height = (this.tSs / 3 * 5 + ai.iX(this.tSj));
        break;
        if ((ViewGroup)this.tSX.getParent() != null) {
          ((ViewGroup)this.tSX.getParent()).removeView(this.tSX);
        }
        if ((ViewGroup)this.tSY.getParent() != null) {
          ((ViewGroup)this.tSY.getParent()).removeView(this.tSY);
        }
        localObject1 = this.tSj.findViewById(2131305666);
        if (localObject1 != null)
        {
          localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.cd.a.hW(this.tSj) * 3.6D / 100.0D));
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.tTd.setVisibility(4);
        this.tSV.addView(this.tSX);
        this.tSW.addView(this.tSY);
      }
    }
  }
  
  private static int ac(ArrayList paramArrayList)
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
    i = com.tencent.mm.plugin.multitalk.model.p.cSN().tOr.setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.e.cRV();
      AppMethodBeat.o(178939);
      return -1;
    }
    AppMethodBeat.o(178939);
    return i;
  }
  
  private void cSY()
  {
    int j = 0;
    AppMethodBeat.i(178938);
    ArrayList localArrayList;
    Object localObject1;
    int k;
    Object localObject2;
    if ((this.tSI.getAdapter() != null) && (this.tSK != null))
    {
      localArrayList = new ArrayList();
      localArrayList.clear();
      localObject1 = (a)this.tSI.getAdapter();
      i = this.tSK.jP();
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        k = this.tSK.jR() - ((a)localObject1).qYg - ((a)localObject1).tQP;
        if ((i < 0) || (k < 0)) {
          break label317;
        }
        while (i <= k)
        {
          localObject2 = ahL(((com.tencent.mm.plugin.multitalk.data.a)((a)localObject1).tQL.get(i)).tOo.Iol);
          if ((localObject2 != null) && (((b)localObject2).tQS != null) && (((b)localObject2).tQS.cTh()))
          {
            int m = com.tencent.mm.plugin.multitalk.c.c.ahO(((b)localObject2).tQS.getUsername());
            localArrayList.add(Integer.valueOf(m));
            ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(m) });
          }
          i += 1;
        }
        i -= ((a)localObject1).qYg;
      }
      ac(localArrayList);
      if ((this.tTe == null) || (!localArrayList.containsAll(this.tTe)) || (!this.tTe.containsAll(localArrayList))) {
        break label523;
      }
    }
    label523:
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
            ((a.ao)localObject2).nPB = ((Integer)localArrayList.get(i)).intValue();
            ((List)localObject1).add(localObject2);
            i += 1;
            continue;
            label317:
            if (this.tSI.getAdapter() == null) {
              break;
            }
            localArrayList.clear();
            localObject1 = ((a)this.tSI.getAdapter()).tQL.iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
              if ((((com.tencent.mm.plugin.multitalk.data.a)localObject2).tOq) && (i < this.tTh))
              {
                k = com.tencent.mm.plugin.multitalk.c.c.ahO(((com.tencent.mm.plugin.multitalk.data.a)localObject2).tOo.Iol);
                localArrayList.add(Integer.valueOf(k));
                ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(k) });
              }
              if (i >= this.tTh) {
                break;
              }
              i += 1;
            }
            ac(localArrayList);
            break;
          }
        }
        if (com.tencent.mm.plugin.multitalk.model.p.cSO().cSk())
        {
          ad.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(localObject1)));
          ad.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(com.tencent.mm.plugin.multitalk.model.p.cSN().tOr.io((List)localObject1))));
        }
      }
      this.tTe = localArrayList;
      AppMethodBeat.o(178938);
      return;
    }
  }
  
  private void n(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(178936);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = null;
    Iterator localIterator = paramMultiTalkGroup.Iok.iterator();
    Object localObject2;
    int i;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
      {
        localObject2 = localMultiTalkGroupMember;
        if (!localMultiTalkGroupMember.Iol.equals(u.aqG()))
        {
          i = com.tencent.mm.plugin.multitalk.c.c.ahO(localMultiTalkGroupMember.Iol);
          if (i == -1)
          {
            localArrayList2.add(localMultiTalkGroupMember);
            continue;
          }
          localArrayList1.add(new c(localMultiTalkGroupMember, i));
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
        if (((c)localArrayList1.get(j)).nPB <= ((c)localArrayList1.get(k)).nPB) {
          break label423;
        }
        localObject2 = (c)localArrayList1.get(j);
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
        ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { ((c)localArrayList1.get(i)).nPB + "/n" });
        ((ArrayList)localObject1).add(((c)localArrayList1.get(i)).tTo);
        i -= 1;
      }
      if ((this.tTd != null) && (!com.tencent.mm.plugin.multitalk.model.j.j(paramMultiTalkGroup).equals(paramMultiTalkGroup.Ioh))) {
        this.tTd.setRoomKey(com.tencent.mm.plugin.multitalk.model.j.j(paramMultiTalkGroup));
      }
      ((ArrayList)localObject1).addAll(localArrayList2);
      ab((ArrayList)localObject1);
      AppMethodBeat.o(178936);
      return;
    }
  }
  
  /* Error */
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 822
    //   5: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 222	com/tencent/mm/plugin/multitalk/ui/widget/j:tSJ	Landroid/widget/FrameLayout;
    //   12: invokevirtual 825	android/widget/FrameLayout:getVisibility	()I
    //   15: ifne +64 -> 79
    //   18: aload_0
    //   19: getfield 402	com/tencent/mm/plugin/multitalk/ui/widget/j:tSU	Landroid/widget/RelativeLayout;
    //   22: invokevirtual 828	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   25: checkcast 696	com/tencent/mm/plugin/multitalk/ui/widget/b
    //   28: astore 5
    //   30: aload 5
    //   32: ifnull +38 -> 70
    //   35: aload 5
    //   37: getfield 700	com/tencent/mm/plugin/multitalk/ui/widget/b:tQS	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   40: ifnull +30 -> 70
    //   43: aload_1
    //   44: aload 5
    //   46: getfield 700	com/tencent/mm/plugin/multitalk/ui/widget/b:tQS	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   49: invokevirtual 708	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:getUsername	()Ljava/lang/String;
    //   52: invokevirtual 789	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +15 -> 70
    //   58: aload 5
    //   60: getfield 700	com/tencent/mm/plugin/multitalk/ui/widget/b:tQS	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   63: aload_2
    //   64: iload 4
    //   66: iload_3
    //   67: invokevirtual 831	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:e	(Landroid/graphics/Bitmap;II)V
    //   70: ldc_w 822
    //   73: invokestatic 418	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 694	com/tencent/mm/plugin/multitalk/ui/widget/j:ahL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/multitalk/ui/widget/b;
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +21 -> 107
    //   89: aload_1
    //   90: getfield 700	com/tencent/mm/plugin/multitalk/ui/widget/b:tQS	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   93: ifnull +14 -> 107
    //   96: aload_1
    //   97: getfield 700	com/tencent/mm/plugin/multitalk/ui/widget/b:tQS	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   100: aload_2
    //   101: iload 4
    //   103: iload_3
    //   104: invokevirtual 831	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:e	(Landroid/graphics/Bitmap;II)V
    //   107: ldc_w 822
    //   110: invokestatic 418	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -37 -> 76
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	j
    //   0	121	1	paramString	String
    //   0	121	2	paramBitmap	Bitmap
    //   0	121	3	paramInt1	int
    //   0	121	4	paramInt2	int
    //   28	31	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	30	116	finally
    //   35	70	116	finally
    //   70	76	116	finally
    //   79	85	116	finally
    //   89	107	116	finally
    //   107	113	116	finally
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    b localb;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114750);
        if (this.tSJ.getVisibility() != 0) {
          break label134;
        }
        localb = (b)this.tSU.getTag();
        if ((localb != null) && (localb.tQS != null) && (paramString.equals(localb.tQS.getUsername())))
        {
          localb.tQS.b(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(114750);
          return;
        }
        if (localb != null)
        {
          ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", " render big video failed cause holder is null  %s,or multiTalkVideoView is null, and user name is %s", new Object[] { Boolean.valueOf(bool), paramString });
          AppMethodBeat.o(114750);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label134:
      localb = ahL(paramString);
      if ((localb == null) || (localb.tQS == null)) {
        break;
      }
      localb.tQS.b(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(114750);
    }
    if (localb != null) {}
    for (bool = true;; bool = false)
    {
      ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "holder is null  %s,or multiTalkVideoView is null and user name is %s", new Object[] { Boolean.valueOf(bool), paramString });
      paramString = (a)this.tSI.getAdapter();
      if (paramString != null)
      {
        paramString.aql.notifyChanged();
        AppMethodBeat.o(114750);
        break;
      }
      ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "avatar adapter is null");
      AppMethodBeat.o(114750);
      break;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114749);
    if (!com.tencent.mm.plugin.multitalk.model.p.cSO().cSk())
    {
      nH(false);
      AppMethodBeat.o(114749);
      return;
    }
    if (this.tTk.tPJ == null)
    {
      this.tTk.w = paramInt1;
      this.tTk.h = paramInt2;
      this.tTk.tPJ = new int[this.tTk.w * this.tTk.h];
    }
    if (!com.tencent.mm.plugin.multitalk.model.j.Hj(com.tencent.mm.plugin.multitalk.model.p.cSO().tOE)) {
      com.tencent.mm.plugin.multitalk.model.p.cSO().Hi(3);
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.plugin.multitalk.model.p.cSO().tOF = this.tSZ.dWW();
    int j;
    if (this.tSZ.dWW())
    {
      j = OpenGlRender.FLAG_Mirror;
      if (!this.tSZ.dWX()) {
        break label263;
      }
    }
    g localg;
    label263:
    for (int k = OpenGlRender.FLAG_Angle270;; k = OpenGlRender.FLAG_Angle90)
    {
      localg = com.tencent.mm.plugin.multitalk.model.p.cSN().tOr.a(paramArrayOfByte, (int)paramLong, this.tTk.w, this.tTk.h, paramInt3 + paramInt4 & 0x1F, this.tTk.tPJ);
      if ((localg.ret >= 0) && (this.tTk.tPJ != null) && (localg.Iot != 0) && (localg.Iou != 0)) {
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
      if (!com.tencent.mm.plugin.multitalk.model.p.cSO().tOX) {
        break label790;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label520;
      }
      i = 259;
    }
    label520:
    label790:
    for (;;)
    {
      paramInt1 = com.tencent.mm.plugin.multitalk.model.p.cSN().tOr.a(paramArrayOfByte, (short)(int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = System.currentTimeMillis();
      long l3 = paramLong - l1;
      if (l3 > 30L) {
        ad.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(localg.Iot), Integer.valueOf(localg.Iou), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(paramLong - l2) });
      }
      if (paramInt1 <= 0) {
        ad.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      if ((this.tTa != null) && (this.tTk.tPJ != null))
      {
        paramArrayOfByte = this.tTa;
        int[] arrayOfInt = this.tTk.tPJ;
        paramInt1 = localg.Iot;
        paramInt2 = localg.Iou;
        if (arrayOfInt == null)
        {
          ad.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
          AppMethodBeat.o(114749);
          return;
          i = 1;
          break;
          i = 3;
          continue;
        }
        if (paramArrayOfByte.tPF.fUH)
        {
          ad.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
          AppMethodBeat.o(114749);
          return;
        }
        if (paramArrayOfByte.tPF.tPJ == null) {
          paramArrayOfByte.tPF.tPJ = new int[arrayOfInt.length];
        }
        paramArrayOfByte.tPF.w = paramInt1;
        paramArrayOfByte.tPF.h = paramInt2;
        paramArrayOfByte.tPF.tPH = (paramInt3 + paramInt4);
        paramArrayOfByte.tPF.mirror = j;
        paramArrayOfByte.tPF.angle = k;
        paramLong = System.currentTimeMillis();
        paramInt1 = paramArrayOfByte.tPF.h;
        if (paramArrayOfByte.tPF.h > paramArrayOfByte.tPF.w) {
          paramInt1 = paramArrayOfByte.tPF.w;
        }
        if (paramArrayOfByte.tPF.rJR == null) {
          paramArrayOfByte.tPF.rJR = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.RGB_565);
        }
        if (paramArrayOfByte.tPF.rJR != null) {
          paramArrayOfByte.tPF.rJR.setPixels(arrayOfInt, paramArrayOfByte.tPF.w - paramArrayOfByte.tPF.h, paramArrayOfByte.tPF.w, 0, 0, paramInt1, paramInt1);
        }
        paramLong = System.currentTimeMillis() - paramLong;
        if (paramLong > 30L) {
          ad.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[] { Long.valueOf(paramLong) });
        }
        aq.f(new k.1(paramArrayOfByte));
      }
      AppMethodBeat.o(114749);
      return;
    }
  }
  
  public final b ahL(String paramString)
  {
    AppMethodBeat.i(178940);
    paramString = ahM(paramString);
    if (paramString != null)
    {
      paramString = this.tSI.bh(paramString);
      if ((paramString instanceof b))
      {
        paramString = (b)paramString;
        AppMethodBeat.o(178940);
        return paramString;
      }
    }
    AppMethodBeat.o(178940);
    return null;
  }
  
  public final View ahM(String paramString)
  {
    AppMethodBeat.i(178941);
    a locala = (a)this.tSI.getAdapter();
    if (locala != null)
    {
      int i = locala.ahJ(paramString);
      paramString = this.tSI.getChildAt(i);
      AppMethodBeat.o(178941);
      return paramString;
    }
    AppMethodBeat.o(178941);
    return null;
  }
  
  public final void bOf()
  {
    AppMethodBeat.i(114752);
    ad.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
    if (this.iAV == null) {
      this.iAV = com.tencent.mm.bi.e.a(this.tSj, 2131764896, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178935);
          j.this.nH(false);
          AppMethodBeat.o(178935);
        }
      });
    }
    if (!this.iAV.isShowing()) {
      this.iAV.show();
    }
    com.tencent.mm.plugin.multitalk.model.p.cSO().Hi(1);
    AppMethodBeat.o(114752);
  }
  
  public final boolean cRI()
  {
    return this.tSZ != null;
  }
  
  public final void cSZ()
  {
    AppMethodBeat.i(114745);
    Object localObject = (a)this.tSI.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(114745);
      return;
    }
    localObject = ((a)localObject).tQL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = ahL(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject).next()).tOo.Iol);
      if ((localb != null) && (localb.tQS != null) && (!u.aqG().equals(localb.tQS.getUsername())) && (localb.tQS.cTh())) {
        localb.tQS.cTc();
      }
    }
    AppMethodBeat.o(114745);
  }
  
  public final void cTa()
  {
    AppMethodBeat.i(114756);
    if (this.tSR.isEnabled()) {
      com.tencent.mm.plugin.multitalk.model.p.cSO().nF(this.tSR.tRF.isChecked());
    }
    AppMethodBeat.o(114756);
  }
  
  public final void e(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114744);
    Object localObject = (a)this.tSI.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(114744);
      return;
    }
    localObject = ((a)localObject).tQL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = ahL(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject).next()).tOo.Iol);
      if ((localb != null) && (localb.tQS != null) && (!u.aqG().equals(localb.tQS.getUsername()))) {
        if (paramHashSet.contains(localb.tQS.getUsername()))
        {
          if (!localb.tQS.cTh()) {
            localb.tQS.cTd();
          }
        }
        else if (localb.tQS.cTh())
        {
          localb.tQS.cTc();
          if ((localb.tQS.getUsername() != null) && (!localb.tQS.getUsername().equals(u.aqG())))
          {
            ad.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
            com.tencent.mm.plugin.multitalk.model.p.cSO().ahD("");
            J(false, -1);
          }
          if ((this.tTc.equals(localb.tQS.getUsername())) && (this.tSJ.getVisibility() == 0))
          {
            this.tTc = "";
            this.tSJ.setVisibility(8);
            this.tSI.setVisibility(0);
          }
        }
      }
    }
    cSY();
    AppMethodBeat.o(114744);
  }
  
  public final void m(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114738);
    this.tSL.setVisibility(0);
    this.tSP.setIconEnabled(com.tencent.mm.plugin.multitalk.model.p.cSO().cRD());
    this.tSN.setVisibility(0);
    n(paramMultiTalkGroup);
    cTa();
    AppMethodBeat.o(114738);
  }
  
  public final void nG(boolean paramBoolean)
  {
    AppMethodBeat.i(114746);
    if (!paramBoolean) {
      this.tTj = System.currentTimeMillis();
    }
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    if (this.tTb == null)
    {
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
      this.tTb = new ObservableTextureView(this.tSj);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(1, 1);
      this.tTb.setLayoutParams(localLayoutParams);
      this.tSj.byJ().addView(this.tTb);
      this.tTb.setVisibility(0);
    }
    if (this.tSZ == null)
    {
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
      this.tSZ = new com.tencent.mm.plugin.voip.video.a(640, 480);
      this.tSZ.a(this, com.tencent.mm.plugin.multitalk.model.p.cSO().tOF);
      this.tSZ.a(this.tTb);
      this.tSZ.dWU();
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.tSZ.dWW()), Boolean.valueOf(this.tSZ.dWX()) });
    }
    if (this.tTa == null)
    {
      this.tTa = new k(this.tSj);
      this.tTa.start();
    }
    AppMethodBeat.o(114746);
  }
  
  public final void nH(boolean paramBoolean)
  {
    AppMethodBeat.i(178942);
    if ((!paramBoolean) && (this.tTj != 0L) && (System.currentTimeMillis() - this.tTj > 0L) && (com.tencent.mm.plugin.multitalk.model.p.cSO().cRD()))
    {
      com.tencent.mm.plugin.multitalk.model.e.w(System.currentTimeMillis() - this.tTj, com.tencent.mm.plugin.multitalk.model.j.cSD());
      this.tTj = 0L;
    }
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
    if (this.tTb != null)
    {
      ViewParent localViewParent = this.tTb.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.tTb);
      }
      this.tTb = null;
    }
    if (this.tSZ != null)
    {
      this.tSZ.dWV();
      this.tSZ = null;
    }
    if (this.tTa != null)
    {
      this.tTa.stop();
      this.tTa = null;
    }
    AppMethodBeat.o(178942);
  }
  
  public final void nI(boolean paramBoolean)
  {
    AppMethodBeat.i(114748);
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    if (!paramBoolean) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178934);
          j.d(j.this).setText(2131761392);
          AppMethodBeat.o(178934);
        }
      });
    }
    nH(false);
    Object localObject = (a)this.tSI.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(114748);
      return;
    }
    localObject = ((a)localObject).tQL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = ahL(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject).next()).tOo.Iol);
      if ((localb != null) && (localb.tQS != null)) {
        localb.tQS.setSurfaceTextureListener(null);
      }
    }
    com.tencent.mm.ak.p.auq().b(this);
    AppMethodBeat.o(114748);
  }
  
  public final void onClick(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(114743);
    if (!this.ghf)
    {
      AppMethodBeat.o(114743);
      return;
    }
    Object localObject1;
    String str;
    Object localObject2;
    if ((paramView instanceof MultiTalkVideoView))
    {
      paramView = (MultiTalkVideoView)paramView;
      if (this.tSJ.getVisibility() == 8)
      {
        if (!paramView.cTh())
        {
          AppMethodBeat.o(114743);
          return;
        }
        this.tSN.setVisibility(8);
        this.tSM.setVisibility(8);
        this.tSJ.setVisibility(0);
        this.tSI.setVisibility(8);
        localObject1 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject1).width = this.tSS;
        ((FrameLayout.LayoutParams)localObject1).height = this.tSS;
        ((FrameLayout.LayoutParams)localObject1).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject1).topMargin = 0;
        this.tSU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        str = paramView.getUsername();
        localObject1 = null;
        paramView = null;
        if (com.tencent.mm.plugin.multitalk.model.p.cSO().tOI != null)
        {
          localObject2 = com.tencent.mm.plugin.multitalk.model.p.cSO().tOI.Iok.iterator();
          localObject1 = paramView;
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (MultiTalkGroupMember)((Iterator)localObject2).next();
            if (((((MultiTalkGroupMember)localObject1).status != 10) && (((MultiTalkGroupMember)localObject1).status != 1)) || (!((MultiTalkGroupMember)localObject1).Iol.equals(str))) {
              break label932;
            }
            paramView = (View)localObject1;
          }
        }
      }
    }
    label640:
    label651:
    label932:
    for (;;)
    {
      break;
      if (com.tencent.mm.plugin.multitalk.model.p.cSO().tOI != null)
      {
        paramView = com.tencent.mm.plugin.multitalk.model.p.cSO().tOI.Iog;
        paramView = com.tencent.wecall.talkroom.model.c.fpJ().aOp(paramView);
        if (paramView != null)
        {
          paramView = paramView.fpD().iterator();
          do
          {
            if (!paramView.hasNext()) {
              break;
            }
            localObject2 = (a.ay)paramView.next();
          } while (!((a.ay)localObject2).Imu.equals(str));
        }
      }
      for (int i = ((a.ay)localObject2).nPB;; i = 0)
      {
        if (!str.equals(u.aqG()))
        {
          ad.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.multitalk.model.p.cSO().ahD(str);
          J(true, i);
        }
        i = j;
        if (!ay.is2G(this.tSj))
        {
          if (ay.is3G(this.tSj)) {
            i = j;
          }
        }
        else
        {
          paramView = new HashSet();
          paramView.addAll(com.tencent.mm.plugin.multitalk.model.p.cSO().tOG);
          if (com.tencent.mm.plugin.multitalk.model.j.Hj(com.tencent.mm.plugin.multitalk.model.p.cSO().tOE)) {
            paramView.add(u.aqG());
          }
          localObject2 = (b)this.tSU.getTag();
          ((b)localObject2).tQS.dS(str, com.tencent.mm.plugin.multitalk.c.c.ahO(str));
          ((b)localObject2).tQS.a(ahL(str).tQS.getCurrentSnapShot());
          this.tSU.setTag(localObject2);
          localObject2 = (b)this.tSU.getTag();
          if (localObject1 == null) {
            break label651;
          }
          ((b)localObject2).tQS.dS(((MultiTalkGroupMember)localObject1).Iol, com.tencent.mm.plugin.multitalk.c.c.ahO(((MultiTalkGroupMember)localObject1).Iol));
          ((b)localObject2).tQS.setPosition(((b)localObject2).tQS.getIndex());
          if (((MultiTalkGroupMember)localObject1).status == 10) {
            break label622;
          }
          ((b)localObject2).lRB.setVisibility(0);
          c.a((b)localObject2);
          label569:
          if ((!paramView.contains(((MultiTalkGroupMember)localObject1).Iol)) || (i != 0)) {
            break label640;
          }
          ((b)localObject2).tQS.cTd();
        }
        for (;;)
        {
          this.tSU.setVisibility(0);
          this.tTc = str;
          com.tencent.mm.plugin.multitalk.model.e.cSg();
          AppMethodBeat.o(114743);
          return;
          i = 0;
          break;
          label622:
          ((b)localObject2).lRB.setVisibility(8);
          c.b((b)localObject2);
          break label569;
          ((b)localObject2).tQS.cTc();
          continue;
          ((b)localObject2).lRB.setVisibility(8);
          c.b((b)localObject2);
          ((b)localObject2).tQS.cTe();
        }
        if ((paramView.getUsername() != null) && (!paramView.getUsername().equals(u.aqG())))
        {
          ad.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
          com.tencent.mm.plugin.multitalk.model.p.cSO().ahD("");
          J(false, -1);
        }
        this.tSN.setVisibility(0);
        this.tSM.setVisibility(0);
        this.tSJ.setVisibility(8);
        this.tSI.setVisibility(0);
        if (this.tSU != null)
        {
          paramView = (b)this.tSU.getTag();
          if (paramView != null) {
            paramView.tQS.cTe();
          }
        }
        this.tTc = "";
        com.tencent.mm.plugin.multitalk.model.e.cSh();
        AppMethodBeat.o(114743);
        return;
        if (paramView.getId() == 2131305667)
        {
          com.tencent.mm.plugin.multitalk.model.p.cSO().g(true, false, false);
          AppMethodBeat.o(114743);
          return;
        }
        if (paramView.getId() == 2131302582)
        {
          com.tencent.mm.plugin.multitalk.model.e.tOx += 1;
          com.tencent.mm.plugin.multitalk.model.p.cSO().nC(true);
          com.tencent.mm.plugin.multitalk.model.e.cSf();
          AppMethodBeat.o(114743);
          return;
        }
        if (paramView.getId() == 2131302576)
        {
          if (this.tSZ != null) {
            this.tSZ.dWT();
          }
          com.tencent.mm.plugin.multitalk.model.e.cSe();
          AppMethodBeat.o(114743);
          return;
        }
        if (paramView.getId() == 2131302572)
        {
          com.tencent.mm.plugin.multitalk.model.e.tOA += 1;
          this.tSj.cST();
        }
        AppMethodBeat.o(114743);
        return;
      }
    }
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(114753);
    ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    paramString = ahL(paramString);
    if ((paramString != null) && (paramString.tQS != null)) {
      paramString.tQS.cTb();
    }
    AppMethodBeat.o(114753);
  }
  
  public final class a
    implements Runnable
  {
    b tTn;
    
    public a(b paramb)
    {
      this.tTn = paramb;
    }
    
    public final void run()
    {
      AppMethodBeat.i(114736);
      this.tTn.tQV.setVisibility(8);
      AppMethodBeat.o(114736);
    }
  }
  
  final class b
  {
    int h;
    int[] tPJ;
    int w;
    
    private b() {}
  }
  
  final class c
  {
    int nPB;
    MultiTalkGroupMember tTo;
    
    c(MultiTalkGroupMember paramMultiTalkGroupMember, int paramInt)
    {
      this.tTo = paramMultiTalkGroupMember;
      this.nPB = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */