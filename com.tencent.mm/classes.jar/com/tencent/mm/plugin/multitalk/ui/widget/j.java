package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.multitalk.model.k;
import com.tencent.mm.plugin.multitalk.model.k.1;
import com.tencent.mm.plugin.multitalk.model.k.a;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
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
  private au bYO;
  public TextView fAz;
  public boolean glL;
  com.tencent.mm.ui.widget.a.d jaW;
  private TextView titleTv;
  MultiTalkMainUI vaQ;
  private ImageButton vaX;
  private boolean vaY;
  private int vaZ;
  private int vbA;
  private RelativeLayout vbB;
  private RelativeLayout vbC;
  private RelativeLayout vbD;
  private LinearLayout vbE;
  private RelativeLayout vbF;
  private com.tencent.mm.plugin.voip.video.a vbG;
  private k vbH;
  private ObservableTextureView vbI;
  public String vbJ;
  private CollapseView vbK;
  private ArrayList vbL;
  private boolean vbM;
  private boolean vbN;
  private int vbO;
  View.OnClickListener vbP;
  public long vbQ;
  b vbR;
  public RecyclerView vbp;
  public FrameLayout vbq;
  private GridLayoutManager vbr;
  public View vbs;
  private View vbt;
  public View vbu;
  public View vbv;
  public MultiTalkControlIconLayout vbw;
  public MultiTalkControlIconLayout vbx;
  public MultiTalkControlIconLayout vby;
  private int vbz;
  
  public j(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(114737);
    this.vbL = new ArrayList();
    this.vbM = false;
    this.vbN = false;
    this.vbO = (d.b.Dfu * d.b.Dft);
    this.vaZ = 0;
    this.vbP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178933);
        com.tencent.mm.plugin.multitalk.model.e.urB += 1;
        paramAnonymousView = j.this;
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramAnonymousView.vaQ.getContext(), "android.permission.CAMERA", 22, "", "");
        ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), paramAnonymousView.vaQ.getContext() });
        if (!bool)
        {
          j.this.vbw.setChecked(false);
          com.tencent.mm.plugin.multitalk.model.e.dfE();
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.p.dgx().dfU())
        {
          j.this.vbw.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.p.dgx().dfn())
        {
          j.this.vbw.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (!ax.isNetworkConnected(j.this.vaQ))
        {
          com.tencent.mm.bh.e.a(j.this.vaQ, 2131764895, null);
          j.this.vbw.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (!com.tencent.mm.plugin.multitalk.model.j.dgp())
        {
          Toast.makeText(j.this.vaQ, 2131761391, 1).show();
          j.this.vbw.setChecked(false);
          AppMethodBeat.o(178933);
          return;
        }
        if (j.this.vbw.van.isChecked())
        {
          j.this.oA(false);
          com.tencent.mm.plugin.multitalk.model.e.dfM();
          AppMethodBeat.o(178933);
          return;
        }
        j.this.oB(false);
        com.tencent.mm.plugin.multitalk.model.p.dgx().Jf(1);
        com.tencent.mm.plugin.multitalk.model.e.dfN();
        AppMethodBeat.o(178933);
      }
    };
    this.bYO = new au("MultiTalkTimer", new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(200698);
        h.JZN.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200697);
            j.d(j.this).setVisibility(8);
            j.e(j.this).setVisibility(0);
            AppMethodBeat.o(200697);
          }
        });
        AppMethodBeat.o(200698);
        return true;
      }
    }, false);
    this.vbR = new b((byte)0);
    this.jaW = null;
    this.glL = true;
    this.vaQ = paramMultiTalkMainUI;
    this.vbz = com.tencent.mm.cc.a.ig(paramMultiTalkMainUI.getContext());
    this.vbA = (this.vbz + com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 52) + aj.ji(paramMultiTalkMainUI));
    this.fAz = ((TextView)paramMultiTalkMainUI.findViewById(2131305822));
    this.titleTv = ((TextView)paramMultiTalkMainUI.findViewById(2131305948));
    this.vbs = paramMultiTalkMainUI.findViewById(2131305668);
    this.vaZ = (com.tencent.mm.cc.a.ih(paramMultiTalkMainUI) - com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 285));
    this.vbC = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131298785));
    this.vbD = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131300676));
    this.vbE = ((LinearLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494971, null, false));
    this.vbF = ((RelativeLayout)paramMultiTalkMainUI.getLayoutInflater().inflate(2131494970, null, false));
    this.vaX = ((ImageButton)this.vbF.findViewById(2131305667));
    this.vbp = ((RecyclerView)paramMultiTalkMainUI.findViewById(2131305669));
    this.vbq = ((FrameLayout)paramMultiTalkMainUI.findViewById(2131305665));
    Object localObject = paramMultiTalkMainUI.findViewById(2131306002);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin = (aj.ji(paramMultiTalkMainUI) + com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 12));
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.vbq.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 52) + aj.ji(paramMultiTalkMainUI));
    this.vbq.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vbr = new GridLayoutManager(3);
    localObject = new a(paramMultiTalkMainUI);
    this.vbp.setLayoutManager(this.vbr);
    this.vbr.anN = new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(178928);
        if (this.vbS.Jj(paramAnonymousInt))
        {
          paramAnonymousInt = j.a(j.this).anI;
          AppMethodBeat.o(178928);
          return paramAnonymousInt;
        }
        AppMethodBeat.o(178928);
        return 1;
      }
    };
    localLayoutParams = (RelativeLayout.LayoutParams)this.vbp.getLayoutParams();
    if (this.vaZ > this.vbz)
    {
      localLayoutParams.width = this.vbz;
      localLayoutParams.height = this.vbA;
      this.vbp.setLayoutParams(localLayoutParams);
      this.vbp.setAdapter((RecyclerView.a)localObject);
      this.vbp.setOnScrollListener(new j.2(this));
      this.vbt = paramMultiTalkMainUI.findViewById(2131302582);
      this.vbu = paramMultiTalkMainUI.findViewById(2131302572);
      this.vbu.setBackground(am.k(ai.getContext(), 2131690325, -1));
      this.vbw = ((MultiTalkControlIconLayout)this.vbE.findViewById(2131302594));
      this.vbw.setIconEnabled(com.tencent.mm.plugin.multitalk.model.p.dgx().dfn());
      this.vbw.setOnClickListener(this.vbP);
      this.vbx = ((MultiTalkControlIconLayout)this.vbE.findViewById(2131302583));
      this.vbx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178931);
          com.tencent.mm.plugin.multitalk.model.e.uXb += 1;
          paramAnonymousView = com.tencent.mm.plugin.multitalk.model.p.dgx();
          boolean bool = j.this.vbx.van.isChecked();
          com.tencent.mm.plugin.multitalk.model.p.dgw().uWU.yA(bool);
          paramAnonymousView.om(bool);
          if (j.this.vbx.van.isChecked())
          {
            com.tencent.mm.plugin.multitalk.model.e.dfI();
            AppMethodBeat.o(178931);
            return;
          }
          com.tencent.mm.plugin.multitalk.model.e.dfJ();
          AppMethodBeat.o(178931);
        }
      });
      this.vby = ((MultiTalkControlIconLayout)this.vbE.findViewById(2131302579));
      this.vby.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(178932);
          if (j.this.vby.isEnabled())
          {
            com.tencent.mm.plugin.multitalk.model.e.uXc += 1;
            com.tencent.mm.plugin.multitalk.model.p.dgx().ox(j.this.vby.van.isChecked());
            j.this.dgK();
            if (j.this.vby.van.isChecked())
            {
              com.tencent.mm.plugin.multitalk.model.e.dfK();
              AppMethodBeat.o(178932);
              return;
            }
            com.tencent.mm.plugin.multitalk.model.e.dfL();
          }
          AppMethodBeat.o(178932);
        }
      });
      this.vbK = ((CollapseView)paramMultiTalkMainUI.findViewById(2131300580));
      this.vbv = this.vbF.findViewById(2131302576);
      this.vbx.setChecked(com.tencent.mm.plugin.multitalk.model.p.dgx().ftN);
      this.vby.setChecked(com.tencent.mm.plugin.multitalk.model.p.dgx().kER);
      this.vbw.setChecked(com.tencent.mm.plugin.multitalk.model.j.Jg(com.tencent.mm.plugin.multitalk.model.p.dgx().uXg));
      ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.vbA) });
      this.vaX.setOnClickListener(this);
      this.vbt.bringToFront();
      this.vbt.setOnClickListener(this);
      this.vbt.setBackground(am.k(ai.getContext(), 2131690328, -1));
      this.vbu.bringToFront();
      this.vbu.setOnClickListener(this);
      this.vbv.setOnClickListener(this);
      com.tencent.mm.aj.p.aBh().a(this);
      if (this.vbq != null)
      {
        paramMultiTalkMainUI = c.a(paramMultiTalkMainUI, this.vbq, this);
        paramMultiTalkMainUI.setVisibility(8);
        this.vbB = paramMultiTalkMainUI;
        this.vbq.addView(paramMultiTalkMainUI);
      }
      this.vbq.setVisibility(8);
      if (!com.tencent.mm.plugin.multitalk.model.j.Jg(com.tencent.mm.plugin.multitalk.model.p.dgx().uXg)) {
        break label907;
      }
      this.vbv.setVisibility(0);
    }
    for (;;)
    {
      this.vbJ = "";
      dgK();
      AppMethodBeat.o(114737);
      return;
      localLayoutParams.width = this.vaZ;
      localLayoutParams.height = (this.vaZ + com.tencent.mm.cc.a.fromDPToPix(paramMultiTalkMainUI, 52) + aj.ji(paramMultiTalkMainUI));
      localLayoutParams.addRule(14);
      break;
      label907:
      this.vbv.setVisibility(8);
    }
  }
  
  private void Jn(int paramInt)
  {
    AppMethodBeat.i(200700);
    this.titleTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.bYO.stopTimer();
      this.bYO.removeCallbacksAndMessages(null);
      this.bYO.au(5000L, 5000L);
      this.fAz.setVisibility(8);
      AppMethodBeat.o(200700);
      return;
    }
    this.fAz.setVisibility(0);
    AppMethodBeat.o(200700);
  }
  
  private static int L(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(114742);
    if (!paramBoolean) {}
    for (int i = -1;; i = paramInt)
    {
      Object localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
      localObject = ((ByteBuffer)localObject).array();
      int j = com.tencent.mm.plugin.multitalk.model.p.dgw().uWU.setAppCmd(22, (byte[])localObject, 4);
      if (j < 0)
      {
        ac.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        AppMethodBeat.o(114742);
        return -1;
      }
      AppMethodBeat.o(114742);
      return j;
    }
  }
  
  private void am(ArrayList<MultiTalkGroupMember> paramArrayList)
  {
    AppMethodBeat.i(178937);
    int j = paramArrayList.size();
    if (j < 5) {}
    for (int i = 2;; i = 3)
    {
      Object localObject1;
      if ((this.vaQ.bFF() != null) && (this.vaQ.bFF().findViewById(2131304253) != null))
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.ap.ej(this.vaQ);
        this.vaQ.bFF().findViewById(2131304253).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.vbp.removeAllViewsInLayout();
      if ((j > 9) || (this.vbM))
      {
        this.vbK.setVisibility(0);
        this.vbK.setCollapseContent$53599cc9(this.vbF);
        this.vbK.aj(this.vbE, this.vaQ.bFF().findViewById(2131305666).getHeight());
        localObject1 = (RelativeLayout.LayoutParams)this.vbp.getLayoutParams();
        if (this.vaZ > this.vbz)
        {
          ((RelativeLayout.LayoutParams)localObject1).height = (this.vbz / 3 * 5 + com.tencent.mm.cc.a.fromDPToPix(this.vaQ, 52) + aj.ji(this.vaQ));
          this.vbp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.vbM = true;
          if ((!com.tencent.mm.plugin.multitalk.model.p.dgx().uXm) && (j > 12))
          {
            com.tencent.mm.plugin.multitalk.model.p.dgx().uXm = true;
            t.w(this.vaQ, this.vaQ.getResources().getString(2131761436), 2131690888);
          }
          localObject1 = (LinearLayout.LayoutParams)this.vbK.findViewById(2131304240).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.ap.ej(this.vaQ);
          this.vbK.findViewById(2131304240).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.vbr.bV(i);
        this.vbp.setLayoutManager(this.vbr);
        localObject1 = new HashSet(com.tencent.mm.plugin.multitalk.model.p.dgx().uXi);
        if (com.tencent.mm.plugin.multitalk.model.j.Jg(com.tencent.mm.plugin.multitalk.model.p.dgx().uXg)) {
          ((HashSet)localObject1).add(u.axw());
        }
        Object localObject2 = (a)this.vbp.getAdapter();
        if (localObject2 != null)
        {
          ((a)localObject2).uZm = false;
          ((a)localObject2).d((HashSet)localObject1);
          ((a)localObject2).a(paramArrayList, this);
        }
        if ((com.tencent.mm.plugin.multitalk.model.p.dgx().dfU()) && (this.vbw != null) && (!this.vbw.van.isChecked())) {
          com.tencent.mm.plugin.multitalk.model.p.dgx().Jf(1);
        }
        AppMethodBeat.o(178937);
        return;
        ((RelativeLayout.LayoutParams)localObject1).height = (this.vaZ / 3 * 5 + aj.ji(this.vaQ));
        break;
        if ((ViewGroup)this.vbE.getParent() != null) {
          ((ViewGroup)this.vbE.getParent()).removeView(this.vbE);
        }
        if ((ViewGroup)this.vbF.getParent() != null) {
          ((ViewGroup)this.vbF.getParent()).removeView(this.vbF);
        }
        localObject1 = this.vaQ.findViewById(2131305666);
        if (localObject1 != null)
        {
          localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(com.tencent.mm.cc.a.ih(this.vaQ) * 3.6D / 100.0D));
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.vbK.setVisibility(4);
        this.vbC.addView(this.vbE);
        this.vbD.addView(this.vbF);
      }
    }
  }
  
  private static int an(ArrayList paramArrayList)
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
    ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = ByteBuffer.allocate(j * 4);
    paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(arrayOfInt);
    paramArrayList = paramArrayList.array();
    i = com.tencent.mm.plugin.multitalk.model.p.dgw().uWU.setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      ac.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.e.dfF();
      AppMethodBeat.o(178939);
      return -1;
    }
    AppMethodBeat.o(178939);
    return i;
  }
  
  private void dgI()
  {
    int j = 0;
    AppMethodBeat.i(178938);
    ArrayList localArrayList;
    Object localObject1;
    int k;
    Object localObject2;
    if ((this.vbp.getAdapter() != null) && (this.vbr != null))
    {
      localArrayList = new ArrayList();
      localArrayList.clear();
      localObject1 = (a)this.vbp.getAdapter();
      i = this.vbr.jX();
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        k = this.vbr.jZ() - ((a)localObject1).rZI - ((a)localObject1).uZq;
        if ((i < 0) || (k < 0)) {
          break label317;
        }
        while (i <= k)
        {
          localObject2 = amG(((com.tencent.mm.plugin.multitalk.data.a)((a)localObject1).uZl.get(i)).uWR.JPW);
          if ((localObject2 != null) && (((b)localObject2).uZv != null) && (((b)localObject2).uZv.dgR()))
          {
            int m = com.tencent.mm.plugin.multitalk.c.c.amJ(((b)localObject2).uZv.getUsername());
            localArrayList.add(Integer.valueOf(m));
            ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(m) });
          }
          i += 1;
        }
        i -= ((a)localObject1).rZI;
      }
      an(localArrayList);
      if ((this.vbL == null) || (!localArrayList.containsAll(this.vbL)) || (!this.vbL.containsAll(localArrayList))) {
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
            ((a.ao)localObject2).osF = ((Integer)localArrayList.get(i)).intValue();
            ((List)localObject1).add(localObject2);
            i += 1;
            continue;
            label317:
            if (this.vbp.getAdapter() == null) {
              break;
            }
            localArrayList.clear();
            localObject1 = ((a)this.vbp.getAdapter()).uZl.iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
              if ((((com.tencent.mm.plugin.multitalk.data.a)localObject2).uWT) && (i < this.vbO))
              {
                k = com.tencent.mm.plugin.multitalk.c.c.amJ(((com.tencent.mm.plugin.multitalk.data.a)localObject2).uWR.JPW);
                localArrayList.add(Integer.valueOf(k));
                ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberIds is %s", new Object[] { Integer.valueOf(k) });
              }
              if (i >= this.vbO) {
                break;
              }
              i += 1;
            }
            an(localArrayList);
            break;
          }
        }
        if (com.tencent.mm.plugin.multitalk.model.p.dgx().dfU())
        {
          ac.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(localObject1)));
          ac.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(com.tencent.mm.plugin.multitalk.model.p.dgw().uWU.iB((List)localObject1))));
        }
      }
      this.vbL = localArrayList;
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
    Iterator localIterator = paramMultiTalkGroup.JPV.iterator();
    Object localObject2;
    int i;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1))
      {
        localObject2 = localMultiTalkGroupMember;
        if (!localMultiTalkGroupMember.JPW.equals(u.axw()))
        {
          i = com.tencent.mm.plugin.multitalk.c.c.amJ(localMultiTalkGroupMember.JPW);
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
        if (((c)localArrayList1.get(j)).osF <= ((c)localArrayList1.get(k)).osF) {
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
        ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "memberis is %s", new Object[] { ((c)localArrayList1.get(i)).osF + "/n" });
        ((ArrayList)localObject1).add(((c)localArrayList1.get(i)).vbW);
        i -= 1;
      }
      if ((this.vbK != null) && (!com.tencent.mm.plugin.multitalk.model.j.j(paramMultiTalkGroup).equals(paramMultiTalkGroup.JPS))) {
        this.vbK.setRoomKey(com.tencent.mm.plugin.multitalk.model.j.j(paramMultiTalkGroup));
      }
      ((ArrayList)localObject1).addAll(localArrayList2);
      am((ArrayList)localObject1);
      AppMethodBeat.o(178936);
      return;
    }
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(114753);
    ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    paramString = amG(paramString);
    if ((paramString != null) && (paramString.uZv != null)) {
      paramString.uZv.dgL();
    }
    AppMethodBeat.o(114753);
  }
  
  /* Error */
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 868
    //   5: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 240	com/tencent/mm/plugin/multitalk/ui/widget/j:vbq	Landroid/widget/FrameLayout;
    //   12: invokevirtual 871	android/widget/FrameLayout:getVisibility	()I
    //   15: ifne +64 -> 79
    //   18: aload_0
    //   19: getfield 423	com/tencent/mm/plugin/multitalk/ui/widget/j:vbB	Landroid/widget/RelativeLayout;
    //   22: invokevirtual 874	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   25: checkcast 736	com/tencent/mm/plugin/multitalk/ui/widget/b
    //   28: astore 5
    //   30: aload 5
    //   32: ifnull +38 -> 70
    //   35: aload 5
    //   37: getfield 740	com/tencent/mm/plugin/multitalk/ui/widget/b:uZv	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   40: ifnull +30 -> 70
    //   43: aload_1
    //   44: aload 5
    //   46: getfield 740	com/tencent/mm/plugin/multitalk/ui/widget/b:uZv	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   49: invokevirtual 748	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:getUsername	()Ljava/lang/String;
    //   52: invokevirtual 828	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +15 -> 70
    //   58: aload 5
    //   60: getfield 740	com/tencent/mm/plugin/multitalk/ui/widget/b:uZv	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   63: aload_2
    //   64: iload 4
    //   66: iload_3
    //   67: invokevirtual 877	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:e	(Landroid/graphics/Bitmap;II)V
    //   70: ldc_w 868
    //   73: invokestatic 439	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 734	com/tencent/mm/plugin/multitalk/ui/widget/j:amG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/multitalk/ui/widget/b;
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +21 -> 107
    //   89: aload_1
    //   90: getfield 740	com/tencent/mm/plugin/multitalk/ui/widget/b:uZv	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   93: ifnull +14 -> 107
    //   96: aload_1
    //   97: getfield 740	com/tencent/mm/plugin/multitalk/ui/widget/b:uZv	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   100: aload_2
    //   101: iload 4
    //   103: iload_3
    //   104: invokevirtual 877	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:e	(Landroid/graphics/Bitmap;II)V
    //   107: ldc_w 868
    //   110: invokestatic 439	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        if (this.vbq.getVisibility() != 0) {
          break label134;
        }
        localb = (b)this.vbB.getTag();
        if ((localb != null) && (localb.uZv != null) && (paramString.equals(localb.uZv.getUsername())))
        {
          localb.uZv.b(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
          AppMethodBeat.o(114750);
          return;
        }
        if (localb != null)
        {
          ac.e("MicroMsg.MT.MultiTalkTalkingUILogic", " render big video failed cause holder is null  %s,or multiTalkVideoView is null, and user name is %s", new Object[] { Boolean.valueOf(bool), paramString });
          AppMethodBeat.o(114750);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label134:
      localb = amG(paramString);
      if ((localb == null) || (localb.uZv == null)) {
        break;
      }
      localb.uZv.b(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(114750);
    }
    if (localb != null) {}
    for (bool = true;; bool = false)
    {
      ac.e("MicroMsg.MT.MultiTalkTalkingUILogic", "holder is null  %s,or multiTalkVideoView is null and user name is %s", new Object[] { Boolean.valueOf(bool), paramString });
      paramString = (a)this.vbp.getAdapter();
      if (paramString != null)
      {
        paramString.arg.notifyChanged();
        AppMethodBeat.o(114750);
        break;
      }
      ac.e("MicroMsg.MT.MultiTalkTalkingUILogic", "avatar adapter is null");
      AppMethodBeat.o(114750);
      break;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114749);
    if (!com.tencent.mm.plugin.multitalk.model.p.dgx().dfU())
    {
      oB(false);
      AppMethodBeat.o(114749);
      return;
    }
    if (this.vbR.uYj == null)
    {
      this.vbR.w = paramInt1;
      this.vbR.h = paramInt2;
      this.vbR.uYj = new int[this.vbR.w * this.vbR.h];
    }
    if (!com.tencent.mm.plugin.multitalk.model.j.Jg(com.tencent.mm.plugin.multitalk.model.p.dgx().uXg)) {
      com.tencent.mm.plugin.multitalk.model.p.dgx().Jf(3);
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.plugin.multitalk.model.p.dgx().uXh = this.vbG.emq();
    int j;
    if (this.vbG.emq())
    {
      j = OpenGlRender.FLAG_Mirror;
      if (!this.vbG.emr()) {
        break label263;
      }
    }
    g localg;
    label263:
    for (int k = OpenGlRender.FLAG_Angle270;; k = OpenGlRender.FLAG_Angle90)
    {
      localg = com.tencent.mm.plugin.multitalk.model.p.dgw().uWU.a(paramArrayOfByte, (int)paramLong, this.vbR.w, this.vbR.h, paramInt3 + paramInt4 & 0x1F, this.vbR.uYj);
      if ((localg.ret >= 0) && (this.vbR.uYj != null) && (localg.JQe != 0) && (localg.JQf != 0)) {
        break label271;
      }
      ac.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[] { Integer.valueOf(localg.ret) });
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
      if (!com.tencent.mm.plugin.multitalk.model.p.dgx().uXz) {
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
      paramInt1 = com.tencent.mm.plugin.multitalk.model.p.dgw().uWU.a(paramArrayOfByte, (short)(int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = System.currentTimeMillis();
      long l3 = paramLong - l1;
      if (l3 > 30L) {
        ac.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(localg.JQe), Integer.valueOf(localg.JQf), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(paramLong - l2) });
      }
      if (paramInt1 <= 0) {
        ac.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      if ((this.vbH != null) && (this.vbR.uYj != null))
      {
        paramArrayOfByte = this.vbH;
        int[] arrayOfInt = this.vbR.uYj;
        paramInt1 = localg.JQe;
        paramInt2 = localg.JQf;
        if (arrayOfInt == null)
        {
          ac.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
          AppMethodBeat.o(114749);
          return;
          i = 1;
          break;
          i = 3;
          continue;
        }
        if (paramArrayOfByte.uYg.fYC)
        {
          ac.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
          AppMethodBeat.o(114749);
          return;
        }
        if (paramArrayOfByte.uYg.uYj == null) {
          paramArrayOfByte.uYg.uYj = new int[arrayOfInt.length];
        }
        paramArrayOfByte.uYg.w = paramInt1;
        paramArrayOfByte.uYg.h = paramInt2;
        paramArrayOfByte.uYg.uYi = (paramInt3 + paramInt4);
        paramArrayOfByte.uYg.mirror = j;
        paramArrayOfByte.uYg.angle = k;
        paramLong = System.currentTimeMillis();
        paramInt1 = paramArrayOfByte.uYg.h;
        if (paramArrayOfByte.uYg.h > paramArrayOfByte.uYg.w) {
          paramInt1 = paramArrayOfByte.uYg.w;
        }
        if (paramArrayOfByte.uYg.sRG == null) {
          paramArrayOfByte.uYg.sRG = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.RGB_565);
        }
        if (paramArrayOfByte.uYg.sRG != null) {
          paramArrayOfByte.uYg.sRG.setPixels(arrayOfInt, paramArrayOfByte.uYg.w - paramArrayOfByte.uYg.h, paramArrayOfByte.uYg.w, 0, 0, paramInt1, paramInt1);
        }
        paramLong = System.currentTimeMillis() - paramLong;
        if (paramLong > 30L) {
          ac.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[] { Long.valueOf(paramLong) });
        }
        com.tencent.mm.sdk.platformtools.ap.f(new k.1(paramArrayOfByte));
      }
      AppMethodBeat.o(114749);
      return;
    }
  }
  
  public final b amG(String paramString)
  {
    AppMethodBeat.i(178940);
    paramString = amH(paramString);
    if (paramString != null)
    {
      paramString = this.vbp.bh(paramString);
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
  
  public final View amH(String paramString)
  {
    AppMethodBeat.i(178941);
    a locala = (a)this.vbp.getAdapter();
    if ((locala != null) && (paramString != null))
    {
      int i = locala.amE(paramString);
      paramString = this.vbp.getChildAt(i);
      AppMethodBeat.o(178941);
      return paramString;
    }
    AppMethodBeat.o(178941);
    return null;
  }
  
  public final void bVs()
  {
    AppMethodBeat.i(114752);
    ac.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
    if (this.jaW == null) {
      this.jaW = com.tencent.mm.bh.e.a(this.vaQ, 2131764896, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200699);
          j.this.oB(false);
          AppMethodBeat.o(200699);
        }
      });
    }
    if (!this.jaW.isShowing()) {
      this.jaW.show();
    }
    com.tencent.mm.plugin.multitalk.model.p.dgx().Jf(1);
    AppMethodBeat.o(114752);
  }
  
  public final boolean dfs()
  {
    return this.vbG != null;
  }
  
  public final void dgJ()
  {
    AppMethodBeat.i(114745);
    Object localObject = (a)this.vbp.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(114745);
      return;
    }
    localObject = ((a)localObject).uZl.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = amG(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject).next()).uWR.JPW);
      if ((localb != null) && (localb.uZv != null) && (!u.axw().equals(localb.uZv.getUsername())) && (localb.uZv.dgR())) {
        localb.uZv.dgM();
      }
    }
    AppMethodBeat.o(114745);
  }
  
  public final void dgK()
  {
    AppMethodBeat.i(114756);
    if (this.vby.isEnabled()) {
      com.tencent.mm.plugin.multitalk.model.p.dgx().oz(this.vby.van.isChecked());
    }
    AppMethodBeat.o(114756);
  }
  
  public final void e(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(114744);
    Object localObject = (a)this.vbp.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(114744);
      return;
    }
    localObject = ((a)localObject).uZl.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = amG(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject).next()).uWR.JPW);
      if ((localb != null) && (localb.uZv != null) && (!u.axw().equals(localb.uZv.getUsername()))) {
        if (paramHashSet.contains(localb.uZv.getUsername()))
        {
          if (!localb.uZv.dgR()) {
            localb.uZv.dgN();
          }
        }
        else if (localb.uZv.dgR())
        {
          localb.uZv.dgM();
          if ((localb.uZv.getUsername() != null) && (!localb.uZv.getUsername().equals(u.axw())))
          {
            ac.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
            com.tencent.mm.plugin.multitalk.model.p.dgx().amy("");
            L(false, -1);
          }
          if ((this.vbJ.equals(localb.uZv.getUsername())) && (this.vbq.getVisibility() == 0))
          {
            this.vbJ = "";
            this.vbq.setVisibility(8);
            this.vbp.setVisibility(0);
          }
        }
      }
    }
    dgI();
    AppMethodBeat.o(114744);
  }
  
  public final void m(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114738);
    this.vbs.setVisibility(0);
    this.vbw.setIconEnabled(com.tencent.mm.plugin.multitalk.model.p.dgx().dfn());
    this.vbu.setVisibility(0);
    n(paramMultiTalkGroup);
    dgK();
    AppMethodBeat.o(114738);
  }
  
  public final void oA(boolean paramBoolean)
  {
    AppMethodBeat.i(114746);
    if (!paramBoolean) {
      this.vbQ = System.currentTimeMillis();
    }
    ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    if (this.vbI == null)
    {
      ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
      this.vbI = new ObservableTextureView(this.vaQ);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(1, 1);
      this.vbI.setLayoutParams(localLayoutParams);
      this.vaQ.bFF().addView(this.vbI);
      this.vbI.setVisibility(0);
    }
    if (this.vbG == null)
    {
      ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
      this.vbG = new com.tencent.mm.plugin.voip.video.a(640, 480);
      this.vbG.a(this, com.tencent.mm.plugin.multitalk.model.p.dgx().uXh);
      this.vbG.a(this.vbI);
      this.vbG.emo();
      ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.vbG.emq()), Boolean.valueOf(this.vbG.emr()) });
    }
    if (this.vbH == null)
    {
      this.vbH = new k(this.vaQ);
      this.vbH.start();
    }
    AppMethodBeat.o(114746);
  }
  
  public final void oB(boolean paramBoolean)
  {
    AppMethodBeat.i(178942);
    if ((!paramBoolean) && (this.vbQ != 0L) && (System.currentTimeMillis() - this.vbQ > 0L) && (com.tencent.mm.plugin.multitalk.model.p.dgx().dfn()))
    {
      com.tencent.mm.plugin.multitalk.model.e.u(System.currentTimeMillis() - this.vbQ, com.tencent.mm.plugin.multitalk.model.j.dgm());
      this.vbQ = 0L;
    }
    ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
    if (this.vbI != null)
    {
      ViewParent localViewParent = this.vbI.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.vbI);
      }
      this.vbI = null;
    }
    if (this.vbG != null)
    {
      this.vbG.emp();
      this.vbG = null;
    }
    if (this.vbH != null)
    {
      this.vbH.stop();
      this.vbH = null;
    }
    AppMethodBeat.o(178942);
  }
  
  public final void oC(boolean paramBoolean)
  {
    AppMethodBeat.i(114748);
    ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    this.bYO.stopTimer();
    this.bYO.removeCallbacksAndMessages(null);
    this.bYO.quitSafely();
    if (!paramBoolean) {
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178935);
          j.e(j.this).setText(2131761392);
          AppMethodBeat.o(178935);
        }
      });
    }
    oB(false);
    Object localObject = (a)this.vbp.getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(114748);
      return;
    }
    localObject = ((a)localObject).uZl.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = amG(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject).next()).uWR.JPW);
      if ((localb != null) && (localb.uZv != null)) {
        localb.uZv.setSurfaceTextureListener(null);
      }
    }
    com.tencent.mm.aj.p.aBh().b(this);
    AppMethodBeat.o(114748);
  }
  
  public final void onClick(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(114743);
    if (!this.glL)
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
      if (this.vbq.getVisibility() == 8)
      {
        if (!paramView.dgR())
        {
          amG(paramView.getUsername()).b(null, false);
          AppMethodBeat.o(114743);
          return;
        }
        this.titleTv.setText(paramView.getNickName());
        Jn(0);
        this.vbu.setVisibility(8);
        this.vbt.setVisibility(8);
        this.vbq.setVisibility(0);
        this.vbp.setVisibility(8);
        localObject1 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject1).width = this.vbz;
        ((FrameLayout.LayoutParams)localObject1).height = this.vbz;
        ((FrameLayout.LayoutParams)localObject1).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject1).topMargin = 0;
        this.vbB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        str = paramView.getUsername();
        localObject1 = null;
        paramView = null;
        if (com.tencent.mm.plugin.multitalk.model.p.dgx().uXk != null)
        {
          localObject2 = com.tencent.mm.plugin.multitalk.model.p.dgx().uXk.JPV.iterator();
          localObject1 = paramView;
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (MultiTalkGroupMember)((Iterator)localObject2).next();
            if (((((MultiTalkGroupMember)localObject1).status != 10) && (((MultiTalkGroupMember)localObject1).status != 1)) || (!((MultiTalkGroupMember)localObject1).JPW.equals(str))) {
              break label967;
            }
            paramView = (View)localObject1;
          }
        }
      }
    }
    label651:
    label669:
    label680:
    label967:
    for (;;)
    {
      break;
      if (com.tencent.mm.plugin.multitalk.model.p.dgx().uXk != null)
      {
        paramView = com.tencent.mm.plugin.multitalk.model.p.dgx().uXk.JPR;
        paramView = com.tencent.wecall.talkroom.model.c.fIe().aUb(paramView);
        if (paramView != null)
        {
          paramView = paramView.fHY().iterator();
          do
          {
            if (!paramView.hasNext()) {
              break;
            }
            localObject2 = (a.ay)paramView.next();
          } while (!((a.ay)localObject2).dhV.equals(str));
        }
      }
      for (int i = ((a.ay)localObject2).osF;; i = 0)
      {
        if (!str.equals(u.axw()))
        {
          ac.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.multitalk.model.p.dgx().amy(str);
          L(true, i);
        }
        i = j;
        if (!ax.is2G(this.vaQ))
        {
          if (ax.is3G(this.vaQ)) {
            i = j;
          }
        }
        else
        {
          paramView = new HashSet();
          paramView.addAll(com.tencent.mm.plugin.multitalk.model.p.dgx().uXi);
          if (com.tencent.mm.plugin.multitalk.model.j.Jg(com.tencent.mm.plugin.multitalk.model.p.dgx().uXg)) {
            paramView.add(u.axw());
          }
          localObject2 = (b)this.vbB.getTag();
          ((b)localObject2).uZv.dZ(str, com.tencent.mm.plugin.multitalk.c.c.amJ(str));
          ((b)localObject2).uZv.a(amG(str).uZv.getCurrentSnapShot());
          this.vbB.setTag(localObject2);
          localObject2 = (b)this.vbB.getTag();
          if (localObject1 == null) {
            break label680;
          }
          ((b)localObject2).uZv.dZ(((MultiTalkGroupMember)localObject1).JPW, com.tencent.mm.plugin.multitalk.c.c.amJ(((MultiTalkGroupMember)localObject1).JPW));
          ((b)localObject2).uZv.setPosition(((b)localObject2).uZv.getIndex());
          if (((MultiTalkGroupMember)localObject1).status == 10) {
            break label651;
          }
          ((b)localObject2).gGk.setVisibility(0);
          c.e((b)localObject2);
          label598:
          if ((!paramView.contains(((MultiTalkGroupMember)localObject1).JPW)) || (i != 0)) {
            break label669;
          }
          ((b)localObject2).uZv.dgN();
        }
        for (;;)
        {
          this.vbB.setVisibility(0);
          this.vbJ = str;
          com.tencent.mm.plugin.multitalk.model.e.dfQ();
          AppMethodBeat.o(114743);
          return;
          i = 0;
          break;
          ((b)localObject2).gGk.setVisibility(8);
          c.f((b)localObject2);
          break label598;
          ((b)localObject2).uZv.dgM();
          continue;
          ((b)localObject2).gGk.setVisibility(8);
          c.f((b)localObject2);
          ((b)localObject2).uZv.dgO();
        }
        if ((paramView.getUsername() != null) && (!paramView.getUsername().equals(u.axw())))
        {
          ac.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
          com.tencent.mm.plugin.multitalk.model.p.dgx().amy("");
          L(false, -1);
        }
        this.vbu.setVisibility(0);
        this.vbt.setVisibility(0);
        this.vbq.setVisibility(8);
        this.vbp.setVisibility(0);
        if (this.vbB != null)
        {
          paramView = (b)this.vbB.getTag();
          if (paramView != null) {
            paramView.uZv.dgO();
          }
        }
        this.vbJ = "";
        com.tencent.mm.plugin.multitalk.model.e.dfR();
        Jn(8);
        AppMethodBeat.o(114743);
        return;
        if (paramView.getId() == 2131305667)
        {
          com.tencent.mm.plugin.multitalk.model.p.dgx().h(true, false, false);
          AppMethodBeat.o(114743);
          return;
        }
        if (paramView.getId() == 2131302582)
        {
          com.tencent.mm.plugin.multitalk.model.e.uXa += 1;
          com.tencent.mm.plugin.multitalk.model.p.dgx().ow(true);
          com.tencent.mm.plugin.multitalk.model.e.dfP();
          AppMethodBeat.o(114743);
          return;
        }
        if (paramView.getId() == 2131302576)
        {
          if (this.vbG != null) {
            this.vbG.emn();
          }
          com.tencent.mm.plugin.multitalk.model.e.dfO();
          AppMethodBeat.o(114743);
          return;
        }
        if (paramView.getId() == 2131302572)
        {
          com.tencent.mm.plugin.multitalk.model.e.uXd += 1;
          this.vaQ.dgC();
        }
        AppMethodBeat.o(114743);
        return;
      }
    }
  }
  
  public final class a
    implements Runnable
  {
    b vbV;
    
    public a(b paramb)
    {
      this.vbV = paramb;
    }
    
    public final void run()
    {
      AppMethodBeat.i(114736);
      this.vbV.uZy.setVisibility(8);
      AppMethodBeat.o(114736);
    }
  }
  
  final class b
  {
    int h;
    int[] uYj;
    int w;
    
    private b() {}
  }
  
  final class c
  {
    int osF;
    MultiTalkGroupMember vbW;
    
    c(MultiTalkGroupMember paramMultiTalkGroupMember, int paramInt)
    {
      this.vbW = paramMultiTalkGroupMember;
      this.osF = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */