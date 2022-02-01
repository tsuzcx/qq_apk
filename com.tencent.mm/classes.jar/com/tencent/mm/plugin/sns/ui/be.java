package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.f.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class be
  extends BaseAdapter
{
  private bp AaP;
  private com.tencent.mm.storage.bj Ahj;
  private Map<Integer, Integer> Ahk;
  private f Ahl;
  boolean Ahm;
  bf Ahn;
  bg Aho;
  private c Ahp;
  int Ahq;
  int Ahr;
  private long Ahs;
  private long Aht;
  boolean Ahu;
  private int Ahv;
  private int Ahw;
  int Ahx;
  protected View.OnClickListener Ahy;
  private String country;
  private boolean drv;
  private Activity dsa;
  boolean isSearchMode;
  List<p> list;
  String rdV;
  private boolean tTr;
  private String uZv;
  private String userName;
  Map<Integer, Integer> zNS;
  private Map<Integer, Integer> zNT;
  private int zNU;
  private int zNV;
  String zVL;
  long zix;
  
  public be(Activity paramActivity, f paramf, String paramString, final c paramc)
  {
    AppMethodBeat.i(99037);
    this.userName = "";
    this.list = new ArrayList();
    this.zNS = new HashMap();
    this.zNT = new HashMap();
    this.Ahk = new HashMap();
    this.zNU = 0;
    this.zNV = 0;
    this.drv = false;
    this.zVL = "";
    this.Ahm = false;
    this.tTr = false;
    this.zix = 0L;
    this.rdV = "";
    this.AaP = null;
    this.uZv = "";
    this.Ahq = 2147483647;
    this.Ahr = 0;
    this.Ahs = 0L;
    this.Aht = 0L;
    this.isSearchMode = false;
    this.Ahu = false;
    this.Ahv = 0;
    this.Ahw = 0;
    this.Ahx = 0;
    this.Ahy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
          if (be.aAR(paramAnonymousView.Id)) {
            break label162;
          }
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10090, "1,0");
          if ((!com.tencent.mm.s.a.cf(be.f(be.this))) && (!com.tencent.mm.s.a.cd(be.f(be.this))) && (!com.tencent.mm.s.a.ch(be.f(be.this))))
          {
            paramAnonymousView = h.a(ag.getAccPath(), paramAnonymousView, 8);
            paramAnonymousView.ihy = be.g(be.this);
            com.tencent.mm.az.a.c(paramAnonymousView);
          }
        }
        for (;;)
        {
          be.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198380);
          return;
          label162:
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10231, "1");
          com.tencent.mm.az.a.aJE();
        }
      }
    };
    this.userName = paramString;
    this.dsa = paramActivity;
    this.Ahl = paramf;
    this.Ahp = paramc;
    this.AaP = ag.dTS();
    paramf = ac.f(this.dsa.getSharedPreferences(aj.fkC(), 0));
    ad.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(paramf)));
    paramActivity = paramf;
    if (!paramf.equals("zh_CN"))
    {
      paramActivity = paramf;
      if (!paramf.equals("en"))
      {
        if (!paramf.equals("zh_TW")) {
          break label437;
        }
        paramActivity = paramf;
      }
    }
    this.uZv = paramActivity;
    this.country = ac.f(this.dsa.getSharedPreferences(aj.fkC(), 0));
    com.tencent.mm.kernel.g.ajD();
    paramActivity = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null);
    if (this.userName.equals(paramActivity)) {
      this.drv = true;
    }
    ad.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.drv) {
      this.Ahj = com.tencent.mm.storage.bj.frp();
    }
    for (;;)
    {
      this.Ahn = new bf(new bf.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99016);
          if (!be.a(be.this))
          {
            ad.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            be.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            paramAnonymousList = be.this;
            if (!be.b(be.this).isEmpty()) {
              break label77;
            }
          }
          label77:
          for (long l = 0L;; l = ((p)be.b(be.this).get(be.b(be.this).size() - 1)).field_snsId)
          {
            be.a(paramAnonymousList, com.tencent.mm.plugin.sns.data.q.zx(l));
            AppMethodBeat.o(99016);
            return;
          }
        }
        
        public final void ecy()
        {
          AppMethodBeat.i(99017);
          if (!be.a(be.this))
          {
            be.c(be.this);
            be.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.ecz();
            }
          }
          AppMethodBeat.o(99017);
        }
      }, paramString, this.drv);
      this.Aho = new bg(new bf.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99018);
          if (be.a(be.this))
          {
            ad.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            be.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            be.d(be.this);
          }
          AppMethodBeat.o(99018);
        }
        
        public final void ecy()
        {
          AppMethodBeat.i(99019);
          if (be.a(be.this))
          {
            be.c(be.this);
            be.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.ecz();
            }
          }
          AppMethodBeat.o(99019);
        }
      }, this.drv);
      Ap(0L);
      rT(false);
      AppMethodBeat.o(99037);
      return;
      label437:
      if (paramf.equals("zh_HK"))
      {
        paramActivity = "zh_TW";
        break;
      }
      paramActivity = "en";
      break;
      com.tencent.mm.kernel.g.ajD();
      paramActivity = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString);
      if ((paramActivity != null) && (com.tencent.mm.o.b.lM(paramActivity.field_type))) {
        this.Ahj = com.tencent.mm.storage.bj.fro();
      } else {
        this.Ahj = com.tencent.mm.storage.bj.frq();
      }
    }
  }
  
  private void Ap(long paramLong)
  {
    AppMethodBeat.i(99050);
    Object localObject = com.tencent.mm.plugin.sns.data.q.zx(ag.dUe().b(paramLong, ag.dTU().aza(this.userName), this.userName, this.drv));
    if (this.zVL.equals("")) {}
    for (;;)
    {
      this.rdV = ((String)localObject);
      localObject = ag.dUi().aAf(this.userName).dYC();
      if (((ajk)localObject).GgF != 0L) {
        break;
      }
      AppMethodBeat.o(99050);
      return;
      if (((String)localObject).compareTo(this.zVL) >= 0) {
        localObject = this.zVL;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.zx(((ajk)localObject).GgF);
    if (this.rdV.equals(""))
    {
      this.rdV = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
    }
    if (((String)localObject).compareTo(this.rdV) > 0) {}
    for (;;)
    {
      this.rdV = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
      localObject = this.rdV;
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, d paramd, int paramInt3)
  {
    AppMethodBeat.i(99044);
    p localp = (p)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localp.dYl();
    SnsObject localSnsObject = ak.v(localp);
    int i = 0;
    paramInt1 = i;
    if (localSnsObject != null) {
      if (((localSnsObject.ExtFlag & 0x2) != 2) || (localSnsObject.BlackList == null))
      {
        paramInt1 = i;
        if ((localSnsObject.ExtFlag & 0x4) == 4)
        {
          paramInt1 = i;
          if (localSnsObject.GroupUser == null) {}
        }
      }
      else
      {
        paramInt1 = 1;
      }
    }
    if ((this.drv) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localp.field_userName)))
    {
      paramTextView3.setBackgroundResource(2131233602);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (ak.ax(localp.field_localPrivate, this.drv))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233596);
        localObject = this.AaP.Bf(localp.field_userName);
        if (localObject != null) {
          break label559;
        }
        localObject = "";
        if ((!((String)localObject).equals("")) && (!this.userName.equals(localp.field_userName)))
        {
          paramTextView1.setVisibility(0);
          paramTextView1.setText((CharSequence)localObject);
        }
      }
      label235:
      paramInt1 = localp.zMC;
      paramTextView1 = new be.f.a();
      paramTextView1.dJd = paramInt1;
      if (this.Ahk.get(Integer.valueOf(paramInt3)) == null) {
        break label677;
      }
      paramTextView1.position = ((Integer)this.Ahk.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new com.tencent.mm.storage.bj(this.Ahj.tag);
      paramTextView1.hbR = localp.field_createTime;
      if (localTimeLineObject.HAT.GaP != 1) {
        break label685;
      }
      paramQFadeImageView.setVisibility(0);
      ag.dUb().a(localTimeLineObject.HAT.GaQ, paramQFadeImageView, this.dsa.hashCode(), f.a.zgR, paramTextView1);
      label367:
      if ((localp.dTN()) && (localp.dYM()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233594);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.HAT.GaQ == null) || (localTimeLineObject.HAT.GaQ.size() <= 1)) {
          break label808;
        }
        paramd.AhY.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.HAT.GaQ.size();
        paramTextView2.setText(this.dsa.getResources().getQuantityString(2131623966, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.HAQ;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        paramd.AhY.setVisibility(0);
        paramd.AhT.setVisibility(0);
        paramd.AhT.ar(k.b(this.dsa, paramQFadeImageView, paramd.AhT.getTextSize()));
      }
      AppMethodBeat.o(99044);
      return;
      label559:
      localObject = ((com.tencent.mm.o.b)localObject).adv();
      break;
      if (!ak.ax(localp.field_localPrivate, this.drv)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(2131233596);
      localObject = this.AaP.Bf(localp.field_userName);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((com.tencent.mm.o.b)localObject).adv())
      {
        if ((localObject == null) || (((String)localObject).equals("")) || (this.userName.equals(localp.field_userName))) {
          break label675;
        }
        paramTextView1.setVisibility(0);
        paramTextView1.setText((CharSequence)localObject);
        break;
      }
      label675:
      break label235;
      label677:
      paramTextView1.position = 0;
      break label295;
      label685:
      if (localTimeLineObject.HAT.GaP == 2)
      {
        paramTextView4.setText(bt.bI(localTimeLineObject.HAT.Desc, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.HAT.GaP != 21) {
        break label367;
      }
      localp.dYD();
      boolean bool = true;
      if (this.drv) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        ag.dUb().a(localTimeLineObject.HAT.GaQ, paramQFadeImageView, this.dsa.hashCode(), f.a.zgR, paramTextView1, bool);
        break;
        if (m.a(localp, localSnsObject)) {
          bool = false;
        }
      }
      label808:
      paramTextView2.setVisibility(8);
    }
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99040);
    int i = paramInt1 / 10000;
    paramInt2 /= 10000;
    p(paramTextView);
    ad.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (this.isSearchMode)
    {
      if ((i != 0) && (paramInt2 != i))
      {
        fj(paramTextView);
        paramTextView.setText(String.format(this.dsa.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        p(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (i == 0)
    {
      if (bj.getYear() != paramInt2)
      {
        fj(paramTextView);
        paramTextView.setText(String.format(this.dsa.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        p(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (paramInt2 != i)
    {
      fj(paramTextView);
      paramTextView.setText(String.format(this.dsa.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      p(paramTextView);
    }
    AppMethodBeat.o(99040);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(99039);
    Object localObject = this.dsa;
    if (!this.uZv.equals("en")) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = (String)bj.a((Context)localObject, 1000L * paramLong, bool);
      if (((String)localObject).indexOf(":") <= 0) {
        break;
      }
      localObject = ((String)localObject).split(":");
      if (localObject[1].length() < 2) {
        localObject[1] = ("0" + localObject[1]);
      }
      paramTextView1.setText(localObject[0]);
      paramTextView2.setText(localObject[1]);
      paramTextView2.setVisibility(0);
      paramTextView1.setVisibility(0);
      AppMethodBeat.o(99039);
      return;
    }
    if (((String)localObject).indexOf("/") > 0)
    {
      localObject = ((String)localObject).split("/");
      if (localObject[1].length() < 2) {
        localObject[1] = ("0" + localObject[1]);
      }
      localObject[0] = bj.G(this.dsa, localObject[0], this.uZv);
      paramTextView1.setText(localObject[0]);
      paramTextView2.setText(localObject[1]);
      paramTextView2.setVisibility(0);
      paramTextView1.setVisibility(0);
      AppMethodBeat.o(99039);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(String.valueOf(localObject));
    AppMethodBeat.o(99039);
  }
  
  protected static boolean aAR(String paramString)
  {
    AppMethodBeat.i(99054);
    com.tencent.mm.az.f localf = com.tencent.mm.az.a.aJJ();
    if ((localf != null) && (com.tencent.mm.az.a.e(localf)) && (paramString.equals(localf.ihg)) && (com.tencent.mm.az.a.aJG()))
    {
      AppMethodBeat.o(99054);
      return true;
    }
    AppMethodBeat.o(99054);
    return false;
  }
  
  private boolean aB(int paramInt, long paramLong)
  {
    return (!this.isSearchMode) || ((paramInt == 0) && (this.zix == paramLong)) || (paramInt > 0) || (this.Ahu);
  }
  
  private static boolean ebJ()
  {
    AppMethodBeat.i(163123);
    if ((an.a.dUJ() & 0x1) <= 0)
    {
      AppMethodBeat.o(163123);
      return true;
    }
    AppMethodBeat.o(163123);
    return false;
  }
  
  private void fj(View paramView)
  {
    AppMethodBeat.i(99042);
    int i = ((Integer)paramView.getTag()).intValue();
    if ((paramView.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if (i == 0)
      {
        localLayoutParams.topMargin = 0;
        paramView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(99042);
        return;
      }
      localLayoutParams.topMargin = this.dsa.getResources().getDimensionPixelSize(2131166851);
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(99042);
  }
  
  private View k(int paramInt, View paramView)
  {
    AppMethodBeat.i(163122);
    b localb;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof b)))
    {
      localb = new b();
      localView = z.jO(this.dsa).inflate(2131495575, null);
      localb.AhC = localView.findViewById(2131298764);
      localb.AhE = ((TextView)localView.findViewById(2131304967));
      localb.AhD = ((TextView)localView.findViewById(2131305007));
      localb.AhF = ((TextView)localView.findViewById(2131305106));
      localb.AhI = ((TextView)localView.findViewById(2131296470));
      localb.zOl = localView.findViewById(2131301422);
      localb.AhI = ((TextView)localView.findViewById(2131296470));
      localb.AhG = ((LinearLayout)localView.findViewById(2131301423));
      localb.AhH = ((ImageView)localView.findViewById(2131301549));
      localb.zOk = ((LinearLayout)localView.findViewById(2131301456));
      localb.opC = ((MMNeat7extView)localView.findViewById(2131299008));
      localb.AhL = ((TagImageView)localView.findViewById(2131300948));
      localb.zOS = ((ImageView)localView.findViewById(2131305185));
      localb.titleTv = ((TextView)localView.findViewById(2131305950));
      localb.AhN = ((TextView)localView.findViewById(2131304202));
      localb.AhC.setOnClickListener(this.Ahl.Aig);
      localb.AhO = localView.findViewById(2131302207);
      localb.AhJ = ((LinearLayout)localView.findViewById(2131300304));
      localb.AhK = ((TextView)localView.findViewById(2131305022));
      localb.AhK.setOnClickListener(new be.7(this));
      localView.setTag(localb);
      com.tencent.mm.plugin.sns.data.q.b(localb.AhL, this.dsa);
      localb.AhF.setTag(Integer.valueOf(paramInt));
      if (this.zNS.get(Integer.valueOf(paramInt)) == null) {
        break label1990;
      }
    }
    label790:
    label1049:
    label1062:
    label1070:
    label1083:
    label1979:
    label1981:
    label1990:
    for (int i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.zNV) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(163122);
        return localView;
        localb = (b)paramView.getTag();
        localView = paramView;
        break;
      }
      localView.setVisibility(0);
      int j;
      if (i - 1 >= 0)
      {
        paramView = (p)getItem(i - 1);
        j = paramView.field_head;
        ak.ax(paramView.field_localPrivate, this.drv);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.zNT.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.zNT.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject1 = (p)getItem(i);
        TimeLineObject localTimeLineObject = ((p)localObject1).dYl();
        label846:
        Object localObject2;
        if (((this.drv) && (paramInt == 0)) || (j == -1) || (((p)localObject1).field_head != j))
        {
          if (aB(paramInt, ((p)localObject1).field_snsId))
          {
            long l = ((p)localObject1).field_createTime;
            a(localb.AhD, localb.AhE, l);
          }
          if (localTimeLineObject.HAR != null)
          {
            if (!bt.isNullOrNil(localTimeLineObject.HAR.jDf)) {
              break label1037;
            }
            paramView = localTimeLineObject.HAR.jde;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.AhI.setText(paramView);
              localb.AhI.setVisibility(0);
            }
          }
          localb.zOl.setVisibility(0);
        }
        else
        {
          a(localb.AhF, j, ((p)localObject1).field_head);
          if ((this.Aht == 0L) || (((p)localObject1).field_snsId != this.Aht)) {
            break label1049;
          }
          localb.AhJ.setVisibility(0);
          paramView = new be.f.a();
          paramView.dJd = ((p)localObject1).zMC;
          if (this.Ahk.get(Integer.valueOf(paramInt)) == null) {
            break label1062;
          }
          paramView.position = ((Integer)this.Ahk.get(Integer.valueOf(paramInt))).intValue();
          localb.AhC.setTag(paramView);
          if (bt.isNullOrNil(localTimeLineObject.HAQ)) {
            break label1070;
          }
          localb.opC.setVisibility(0);
          localb.opC.ar(k.b(this.dsa, localTimeLineObject.HAQ, localb.opC.getTextSize()));
          localb.AhG.setVisibility(0);
          localb.opC.setMaxLines(1);
          localb.opC.getWrappedTextView().setSingleLine(true);
          localb.AhO.setVisibility(0);
          paramInt = localTimeLineObject.HAT.GaP;
          localObject2 = new com.tencent.mm.storage.bj(this.Ahj.tag);
          ((com.tencent.mm.storage.bj)localObject2).hbR = ((p)localObject1).field_createTime;
          if (paramInt != 2) {
            break label1083;
          }
          localb.opC.setVisibility(0);
          localb.opC.getWrappedTextView().setSingleLine(false);
          localb.opC.setMaxLines(2);
          localb.AhO.setVisibility(8);
        }
        byn localbyn;
        for (;;)
        {
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(163122);
          return localView;
          paramView = localTimeLineObject.HAR.jDf;
          break;
          localb.AhJ.setVisibility(8);
          break label790;
          paramView.position = 0;
          break label846;
          localb.opC.setVisibility(8);
          break label903;
          if (paramInt != 4) {
            break label1424;
          }
          if (!localTimeLineObject.HAT.GaQ.isEmpty())
          {
            localb.AhL.setVisibility(0);
            localb.zOS.setVisibility(0);
            localb.AhO.setVisibility(0);
            localb.titleTv.setMaxLines(1);
            localb.titleTv.setTextColor(this.dsa.getResources().getColor(2131100914));
            localbyn = (byn)localTimeLineObject.HAT.GaQ.get(0);
            ag.dUb().a(localbyn, localb.AhL, 2131689564, this.dsa.hashCode(), f.a.zgR, (com.tencent.mm.storage.bj)localObject2);
            localb.zOS.setPressed(false);
            if (aAR(localTimeLineObject.Id))
            {
              localb.zOS.setImageResource(2131233393);
              label1235:
              localb.AhL.setTag(localTimeLineObject);
              localb.AhL.setOnClickListener(this.Ahy);
              localbyn.dJd = ((p)localObject1).zMC;
              localb.AhO.setTag(localTimeLineObject);
              localObject1 = localbyn.Desc;
              if (bt.isNullOrNil((String)localObject1)) {
                break label1386;
              }
              localb.AhN.setVisibility(0);
              localb.AhN.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = localbyn.Title;
              if (bt.isNullOrNil((String)localObject1)) {
                break label1398;
              }
              localb.titleTv.setVisibility(0);
              localb.titleTv.setTag(paramView);
              localb.titleTv.setOnTouchListener(new ae());
              localb.titleTv.setText((CharSequence)localObject1);
              break;
              localb.zOS.setImageResource(2131233395);
              break label1235;
              label1386:
              localb.AhN.setVisibility(4);
            }
            label1398:
            localb.titleTv.setVisibility(8);
          }
          else
          {
            localb.AhO.setVisibility(8);
          }
        }
        localb.titleTv.setTextColor(this.dsa.getResources().getColor(2131099732));
        if (ebJ())
        {
          paramView = bh.aAS(localTimeLineObject.HAT.Url);
          localObject1 = localTimeLineObject.HAT.Title;
          if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
            break label1981;
          }
          localObject1 = ((String)localObject1).substring(0, 40) + "...";
        }
        for (;;)
        {
          if (localb.AhL != null) {
            localb.AhL.setOnClickListener(null);
          }
          localb.zOS.setVisibility(8);
          if (!localTimeLineObject.HAT.GaQ.isEmpty())
          {
            localb.AhL.setVisibility(0);
            localbyn = (byn)localTimeLineObject.HAT.GaQ.get(0);
            if (localTimeLineObject.HAT.GaP == 5)
            {
              paramView = bh.aAS(localbyn.Url);
              localObject1 = localbyn.Title;
              localb.zOS.setVisibility(0);
              ag.dUb().a(localbyn, localb.AhL, 2131689581, this.dsa.hashCode(), f.a.zgR, (com.tencent.mm.storage.bj)localObject2);
              label1649:
              localObject2 = paramView;
              if (localTimeLineObject.HAT.GaT != null)
              {
                localObject2 = paramView;
                if (localTimeLineObject.HAT.GaT.hzk == 1) {
                  localObject2 = aj.getContext().getString(2131761345);
                }
              }
              if (bt.isNullOrNil((String)localObject2)) {
                break label1930;
              }
              localb.AhN.setVisibility(0);
              localb.AhN.setText((CharSequence)localObject2);
              if (bt.isNullOrNil((String)localObject1)) {
                break label1968;
              }
              if (localb.AhN.getVisibility() != 8) {
                break label1943;
              }
              localb.titleTv.setMaxLines(2);
              label1749:
              localb.titleTv.setVisibility(0);
              if ((localTimeLineObject.hzT & 0x1) <= 0) {
                break label1955;
              }
              localb.titleTv.setText(com.tencent.mm.plugin.sns.data.q.a((String)localObject1, this.dsa, localb.titleTv));
            }
          }
          for (;;)
          {
            if ((localTimeLineObject.HAZ == null) || (localTimeLineObject.HAZ.subType != 1)) {
              break label1979;
            }
            localb.zOS.setVisibility(0);
            localb.zOS.setImageDrawable(localb.zOS.getContext().getResources().getDrawable(2131691166));
            break;
            paramView = "";
            break label1463;
            ag.dUb().a(localbyn, localb.AhL, this.dsa.hashCode(), f.a.zgR, (com.tencent.mm.storage.bj)localObject2);
            break label1649;
            if (localTimeLineObject.HAT.GaP != 26)
            {
              localb.AhL.setVisibility(8);
              break label1649;
            }
            localb.AhL.setVisibility(0);
            localb.AhL.setImageResource(2131690949);
            break label1649;
            localb.AhN.setVisibility(8);
            break label1719;
            localb.titleTv.setMaxLines(1);
            break label1749;
            localb.titleTv.setText((CharSequence)localObject1);
            continue;
            localb.titleTv.setVisibility(8);
          }
          break;
        }
        j = -1;
      }
    }
  }
  
  private View l(int paramInt, View paramView)
  {
    AppMethodBeat.i(198381);
    b localb;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof b)))
    {
      localb = new b();
      localView = z.jO(this.dsa).inflate(2131495575, null);
      localb.AhC = localView.findViewById(2131298764);
      localb.AhE = ((TextView)localView.findViewById(2131304967));
      localb.AhD = ((TextView)localView.findViewById(2131305007));
      localb.AhF = ((TextView)localView.findViewById(2131305106));
      localb.AhI = ((TextView)localView.findViewById(2131296470));
      localb.zOl = localView.findViewById(2131301422);
      localb.AhI = ((TextView)localView.findViewById(2131296470));
      localb.AhG = ((LinearLayout)localView.findViewById(2131301423));
      localb.AhH = ((ImageView)localView.findViewById(2131301549));
      localb.zOk = ((LinearLayout)localView.findViewById(2131301456));
      localb.opC = ((MMNeat7extView)localView.findViewById(2131299008));
      localb.AhL = ((TagImageView)localView.findViewById(2131300948));
      localb.zOS = ((ImageView)localView.findViewById(2131305185));
      localb.titleTv = ((TextView)localView.findViewById(2131305950));
      localb.AhN = ((TextView)localView.findViewById(2131304202));
      localb.AhC.setOnClickListener(this.Ahl.Aig);
      localb.AhO = localView.findViewById(2131302207);
      localb.AhM = ((TextView)localView.findViewById(2131298762));
      localb.AhJ = ((LinearLayout)localView.findViewById(2131300304));
      localb.AhK = ((TextView)localView.findViewById(2131305022));
      localb.AhK.setOnClickListener(new be.9(this));
      localView.setTag(localb);
      com.tencent.mm.plugin.sns.data.q.b(localb.AhL, this.dsa);
      localb.AhF.setTag(Integer.valueOf(paramInt));
      if (this.zNS.get(Integer.valueOf(paramInt)) == null) {
        break label1424;
      }
    }
    label770:
    label1424:
    for (int i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.zNV) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(198381);
        return localView;
        localb = (b)paramView.getTag();
        localView = paramView;
        break;
      }
      localView.setVisibility(0);
      int j;
      if (i - 1 >= 0)
      {
        paramView = (p)getItem(i - 1);
        j = paramView.field_head;
        ak.ax(paramView.field_localPrivate, this.drv);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        p localp = (p)getItem(i);
        Object localObject = localp.dYl();
        if (((this.drv) && (paramInt == 0)) || (j == -1) || (localp.field_head != j))
        {
          if (aB(paramInt, localp.field_snsId))
          {
            long l = localp.field_createTime;
            a(localb.AhD, localb.AhE, l);
          }
          if (((TimeLineObject)localObject).HAR != null)
          {
            if (!bt.isNullOrNil(((TimeLineObject)localObject).HAR.jDf)) {
              break label967;
            }
            paramView = ((TimeLineObject)localObject).HAR.jde;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.AhI.setText(paramView);
              localb.AhI.setVisibility(0);
            }
          }
          localb.zOl.setVisibility(0);
        }
        else
        {
          a(localb.AhF, j, localp.field_head);
          if ((this.Aht == 0L) || (localp.field_snsId != this.Aht)) {
            break label979;
          }
          localb.AhJ.setVisibility(0);
          paramView = new be.f.a();
          paramView.dJd = localp.zMC;
          if (this.Ahk.get(Integer.valueOf(paramInt)) == null) {
            break label992;
          }
          paramView.position = ((Integer)this.Ahk.get(Integer.valueOf(paramInt))).intValue();
          label826:
          localb.AhC.setTag(paramView);
          if (bt.isNullOrNil(((TimeLineObject)localObject).HAQ)) {
            break label1000;
          }
          localb.opC.setVisibility(0);
          localb.opC.ar(k.b(this.dsa, ((TimeLineObject)localObject).HAQ, localb.opC.getTextSize()));
        }
        com.tencent.mm.storage.bj localbj;
        for (;;)
        {
          localb.AhG.setVisibility(0);
          localb.opC.getWrappedTextView().setSingleLine(true);
          localb.AhO.setVisibility(0);
          localbj = new com.tencent.mm.storage.bj(this.Ahj.tag);
          localbj.hbR = localp.field_createTime;
          if (((TimeLineObject)localObject).HAT.GaW != null) {
            break label1013;
          }
          ad.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
          AppMethodBeat.o(198381);
          return localView;
          label967:
          paramView = ((TimeLineObject)localObject).HAR.jDf;
          break;
          label979:
          localb.AhJ.setVisibility(8);
          break label770;
          label992:
          paramView.position = 0;
          break label826;
          label1000:
          localb.opC.setVisibility(8);
        }
        label1013:
        localb.titleTv.setTextColor(this.dsa.getResources().getColor(2131100711));
        paramView = "";
        if (((TimeLineObject)localObject).HAT.GaW != null)
        {
          localb.AhL.setVisibility(0);
          paramView = ((TimeLineObject)localObject).HAT.GaW.title;
          byn localbyn = new byn();
          localbyn.Url = ((TimeLineObject)localObject).HAT.GaW.hDm;
          localbyn.GSI = ((TimeLineObject)localObject).HAT.GaW.hDm;
          localbyn.nEf = 2;
          localbyn.GSJ = 1;
          localbyn.GSL = new byp();
          localbyn.GEe = 1;
          localbyn.GSL.GTz = ((TimeLineObject)localObject).HAT.GaW.width;
          localbyn.GSL.GTA = ((TimeLineObject)localObject).HAT.GaW.height;
          localbyn.Id = localp.getSnsId();
          ag.dUb().a(localbyn, localb.AhL, this.dsa.hashCode(), f.a.zgR, localbj);
        }
        localObject = paramView;
        if (paramView.length() > 40) {
          localObject = paramView.substring(0, 40) + "...";
        }
        if (localb.AhL != null) {
          localb.AhL.setOnClickListener(null);
        }
        localb.zOS.setVisibility(0);
        localb.zOS.setImageDrawable(ao.k(localb.zOS.getContext(), 2131690672, -1));
        localb.AhN.setVisibility(8);
        if (!bt.isNullOrNil((String)localObject)) {
          if (localb.AhN.getVisibility() == 8)
          {
            localb.titleTv.setMaxLines(2);
            localb.titleTv.setText(k.c(this.dsa, (CharSequence)localObject));
            localb.titleTv.setVisibility(0);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.j.e.ztz.G(localp);
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(198381);
          return localView;
          localb.titleTv.setMaxLines(1);
          break;
          localb.titleTv.setVisibility(8);
        }
        j = -1;
      }
    }
  }
  
  private void p(final TextView paramTextView)
  {
    AppMethodBeat.i(99041);
    if (this.Ahv <= 0) {
      paramTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99020);
          new Rect();
          paramTextView.measure(0, 0);
          be.a(be.this, paramTextView.getMeasuredHeight());
          ad.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", new Object[] { Integer.valueOf(be.e(be.this)) });
          AppMethodBeat.o(99020);
        }
      });
    }
    AppMethodBeat.o(99041);
  }
  
  private void rT(boolean paramBoolean)
  {
    AppMethodBeat.i(99046);
    ad.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.rdV);
    if (this.Ahn != null)
    {
      if (this.isSearchMode)
      {
        this.Aho.aj(this.Ahm, paramBoolean);
        AppMethodBeat.o(99046);
        return;
      }
      this.Ahn.j(this.rdV, this.Ahm, paramBoolean);
    }
    AppMethodBeat.o(99046);
  }
  
  public final void Ao(long paramLong)
  {
    if (0L != this.Ahs) {
      return;
    }
    this.Ahs = paramLong;
    this.Aht = 0L;
  }
  
  public final void a(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99045);
    ad.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (this.Ahp != null) {
        this.Ahp.ecz();
      }
      AppMethodBeat.o(99045);
      return;
    }
    ad.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    this.list.clear();
    this.zNS.clear();
    this.zNT.clear();
    this.Ahk.clear();
    int i = 0;
    while (i < j)
    {
      p localp = p.K((p)paramList.get(i));
      this.list.add(localp);
      i += 1;
    }
    paramList = paramMap1.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
      this.zNS.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      this.zNT.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      this.Ahk.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (this.drv)
    {
      if (this.list.size() <= 1) {}
      for (i = 2147483647;; i = ((p)this.list.get(1)).field_head)
      {
        this.Ahq = 0;
        j = 0;
        while (j < this.list.size())
        {
          if ((!this.drv) || (j != 0))
          {
            if (i != ((p)this.list.get(j)).field_head) {
              break;
            }
            this.Ahq = Math.max(this.Ahq, ((p)this.list.get(j)).field_createTime);
          }
          j += 1;
        }
      }
    }
    if (this.list.isEmpty()) {}
    for (i = 2147483647;; i = ((p)this.list.get(0)).field_head) {
      break;
    }
    if ((this.list.isEmpty()) || ((this.drv) && (this.list.size() == 1))) {
      this.Ahq = 2147483647;
    }
    if (this.list.isEmpty()) {}
    for (i = 0;; i = ((p)this.list.get(this.list.size() - 1)).field_head)
    {
      this.Ahr = 2147483647;
      j = this.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((p)this.list.get(j)).field_head))
      {
        this.Ahr = Math.min(this.Ahr, ((p)this.list.get(j)).field_createTime);
        j -= 1;
      }
    }
    if (this.list.isEmpty()) {
      this.Ahr = 0;
    }
    this.zNV = paramInt1;
    this.zNU = paramInt2;
    ad.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + this.Ahq + " edTIme " + this.Ahr);
    notifyDataSetChanged();
    AppMethodBeat.o(99045);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(99048);
    rT(true);
    notifyDataSetChanged();
    AppMethodBeat.o(99048);
  }
  
  public final void ecw()
  {
    this.Ahu = true;
    if (this.isSearchMode) {
      this.Aho.Aip = true;
    }
  }
  
  public final void ecx()
  {
    AppMethodBeat.i(99049);
    ad.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((p)this.list.get(this.list.size() - 1)).field_snsId)
    {
      Ap(l);
      AppMethodBeat.o(99049);
      return;
    }
  }
  
  public final int getCount()
  {
    return this.zNU;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(99051);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(99051);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99043);
    if ((this.drv) && (paramInt == 0) && ((!this.isSearchMode) || ((this.isSearchMode) && (this.Ahu))))
    {
      ad.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(99043);
      return 0;
    }
    if (this.zNS.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        ad.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(99043);
        return 0;
      }
      p localp = (p)getItem(i);
      if (localp.dYl().HAT.GaP == 1)
      {
        ad.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(99043);
        return 0;
      }
      if (localp.dYl().HAT.GaP == 15)
      {
        ad.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(99043);
        return 2;
      }
      if (localp.dYl().HAT.GaP == 21)
      {
        AppMethodBeat.o(99043);
        return 3;
      }
      if ((localp.dYl().HAT.GaP == 28) || (localp.dYl().HAT.GaP == 29))
      {
        AppMethodBeat.o(99043);
        return 4;
      }
      if (localp.dYl().HAT.GaP == 33)
      {
        AppMethodBeat.o(99043);
        return 5;
      }
      AppMethodBeat.o(99043);
      return 1;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99038);
    int i = getItemViewType(paramInt);
    ad.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(i)));
    Object localObject1;
    int j;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
      {
        paramViewGroup = new d();
        paramView = z.jO(this.dsa).inflate(2131495576, null);
        paramViewGroup.AhE = ((TextView)paramView.findViewById(2131304967));
        paramViewGroup.AhD = ((TextView)paramView.findViewById(2131305007));
        paramViewGroup.AhF = ((TextView)paramView.findViewById(2131305106));
        paramViewGroup.AhP = ((MaskImageView)paramView.findViewById(2131300977));
        paramViewGroup.AhQ = ((QFadeImageView)paramView.findViewById(2131305641));
        paramViewGroup.AhR = ((MaskImageView)paramView.findViewById(2131300978));
        paramViewGroup.AhS = ((MaskImageView)paramView.findViewById(2131300979));
        paramViewGroup.AhT = ((MMNeat7extView)paramView.findViewById(2131298996));
        paramViewGroup.AhU = ((TextView)paramView.findViewById(2131307000));
        paramViewGroup.AhV = ((TextView)paramView.findViewById(2131307001));
        paramViewGroup.AhW = ((TextView)paramView.findViewById(2131307002));
        paramViewGroup.AhX = ((TextView)paramView.findViewById(2131300986));
        paramViewGroup.AhY = paramView.findViewById(2131299002);
        paramViewGroup.AhI = ((TextView)paramView.findViewById(2131296470));
        paramViewGroup.AhG = ((LinearLayout)paramView.findViewById(2131301423));
        paramViewGroup.AhH = ((ImageView)paramView.findViewById(2131301549));
        paramViewGroup.zOk = ((LinearLayout)paramView.findViewById(2131301456));
        paramViewGroup.zOl = paramView.findViewById(2131301422);
        paramViewGroup.AhQ.setOnClickListener(this.Ahl.zOb);
        paramViewGroup.AhP.setOnClickListener(this.Ahl.zOb);
        paramViewGroup.AhR.setOnClickListener(this.Ahl.zOc);
        paramViewGroup.AhS.setOnClickListener(this.Ahl.zOd);
        paramViewGroup.AhP.setOnLongClickListener(this.Ahl.Aij);
        paramViewGroup.AhR.setOnLongClickListener(this.Ahl.Aij);
        paramViewGroup.AhS.setOnLongClickListener(this.Ahl.Aij);
        paramViewGroup.AhZ = ((TextView)paramView.findViewById(2131306862));
        paramViewGroup.Aia = ((TextView)paramView.findViewById(2131306863));
        paramViewGroup.Aib = ((TextView)paramView.findViewById(2131306864));
        paramViewGroup.Aic = ((TextView)paramView.findViewById(2131306096));
        paramViewGroup.Aid = ((TextView)paramView.findViewById(2131306097));
        paramViewGroup.Aie = ((TextView)paramView.findViewById(2131306098));
        paramViewGroup.Aif = ((MaskLinearLayout)paramView.findViewById(2131305003));
        paramViewGroup.Aif.b(paramViewGroup.AhP);
        paramViewGroup.AhJ = ((LinearLayout)paramView.findViewById(2131300304));
        paramViewGroup.AhK = ((TextView)paramView.findViewById(2131305022));
        paramViewGroup.AhK.setOnClickListener(new be.6(this));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        ag.dUb().eR(paramViewGroup.AhP);
        ag.dUb().eR(paramViewGroup.AhR);
        ag.dUb().eR(paramViewGroup.AhS);
        i = -1;
        if (this.zNS.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.AhF.setTag(Integer.valueOf(paramInt));
        paramViewGroup.Aif.settouchEnable(false);
        paramViewGroup.Aif.setBackgroundResource(0);
        paramViewGroup.Aif.setDescendantFocusability(131072);
        paramViewGroup.Aif.setClickable(false);
        paramViewGroup.AhP.settouchEnable(true);
        paramViewGroup.AhP.setClickable(true);
        paramViewGroup.AhP.setLongClickable(false);
        paramViewGroup.AhR.setLongClickable(false);
        paramViewGroup.AhS.setLongClickable(false);
        paramViewGroup.Aif.setOnClickListener(null);
        paramViewGroup.Aif.setOnLongClickListener(null);
        paramViewGroup.Aif.setLongClickable(false);
        if ((i < this.zNV) && (i != -1)) {
          break;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(99038);
        return paramView;
        paramViewGroup = (d)paramView.getTag();
      }
      if (i - 1 < 0) {
        break label6329;
      }
      localObject1 = (p)getItem(i - 1);
      j = ((p)localObject1).field_head;
      ak.ax(((p)localObject1).field_localPrivate, this.drv);
    }
    label1287:
    label1300:
    label1312:
    label4004:
    label5668:
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.setVisibility(0);
      if (this.zNT.get(Integer.valueOf(paramInt)) != null) {}
      label1319:
      label2857:
      for (int k = ((Integer)this.zNT.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        Object localObject2 = (p)getItem(i);
        localObject1 = ((p)localObject2).dYl();
        long l;
        if (((this.drv) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
        {
          if (aB(paramInt, ((p)localObject2).field_snsId))
          {
            l = ((p)localObject2).field_createTime;
            a(paramViewGroup.AhD, paramViewGroup.AhE, l);
          }
          if (((TimeLineObject)localObject1).HAR != null)
          {
            if (!bt.isNullOrNil(((TimeLineObject)localObject1).HAR.jDf)) {
              break label1287;
            }
            localObject1 = ((TimeLineObject)localObject1).HAR.jde;
            if ((localObject1 != null) && (!((String)localObject1).equals("")))
            {
              paramViewGroup.AhI.setText((CharSequence)localObject1);
              paramViewGroup.AhI.setVisibility(0);
            }
          }
          paramViewGroup.zOl.setVisibility(0);
        }
        else
        {
          if ((this.Aht == 0L) || (((p)localObject2).field_snsId != this.Aht)) {
            break label1300;
          }
          paramViewGroup.AhJ.setVisibility(0);
          label1094:
          paramViewGroup.AhG.setVisibility(0);
          if ((!this.drv) || (paramInt != 0) || ((this.isSearchMode) && ((!this.isSearchMode) || (!this.Ahu)))) {
            break label1319;
          }
          paramViewGroup.AhQ.setVisibility(0);
          paramViewGroup.AhQ.setContentDescription(this.dsa.getString(2131764020));
          paramViewGroup.AhP.setVisibility(8);
          localObject2 = paramViewGroup.AhT;
          if (this.zNU != 1) {
            break label1312;
          }
        }
        for (localObject1 = this.dsa.getString(2131764063);; localObject1 = "")
        {
          ((MMNeat7extView)localObject2).ar((CharSequence)localObject1);
          paramViewGroup.AhT.setVisibility(0);
          paramViewGroup.AhY.setVisibility(0);
          paramViewGroup.AhX.setVisibility(8);
          ag.dUb().d(paramViewGroup.AhQ, 2131100942, 2131234148, this.dsa.hashCode());
          localObject1 = new be.f.a();
          ((be.f.a)localObject1).dJd = -1;
          ((be.f.a)localObject1).position = -1;
          paramViewGroup.AhQ.setTag(localObject1);
          AppMethodBeat.o(99038);
          return paramView;
          localObject1 = ((TimeLineObject)localObject1).HAR.jDf;
          break;
          paramViewGroup.AhJ.setVisibility(8);
          break label1094;
        }
        a(paramViewGroup.AhF, j, ((p)localObject2).field_head);
        if (k > 0)
        {
          a(i, paramViewGroup.AhP, paramViewGroup.AhU, paramViewGroup.AhX, paramViewGroup.AhZ, paramViewGroup.Aic, 1, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.e.ztz.G((p)getItem(i));
        }
        if (k >= 2)
        {
          a(i + 1, paramViewGroup.AhR, paramViewGroup.AhV, paramViewGroup.AhX, paramViewGroup.Aia, paramViewGroup.Aid, 2, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.e.ztz.G((p)getItem(i + 1));
        }
        if (k >= 3)
        {
          a(i + 2, paramViewGroup.AhS, paramViewGroup.AhW, paramViewGroup.AhX, paramViewGroup.Aib, paramViewGroup.Aie, 3, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.e.ztz.G((p)getItem(i + 2));
        }
        if (k == 1)
        {
          localObject1 = (p)getItem(i);
          if ((!bt.isNullOrNil(((p)localObject1).dYl().HAQ)) && (((p)localObject1).field_type == 1))
          {
            paramViewGroup.Aif.setDescendantFocusability(393216);
            paramViewGroup.Aif.setClickable(true);
            paramViewGroup.AhP.setClickable(false);
            paramViewGroup.AhP.settouchEnable(false);
            paramViewGroup.Aif.setOnClickListener(this.Ahl.zOb);
            paramViewGroup.Aif.settouchEnable(true);
            i = ((p)localObject2).zMC;
            localObject2 = new be.f.a();
            ((be.f.a)localObject2).dJd = i;
            if (this.Ahk.get(Integer.valueOf(paramInt)) == null) {
              break label1702;
            }
          }
        }
        for (((be.f.a)localObject2).position = ((Integer)this.Ahk.get(Integer.valueOf(paramInt))).intValue();; ((be.f.a)localObject2).position = 0)
        {
          if ((((p)localObject1).dTN()) && (((p)localObject1).dYM())) {
            paramViewGroup.Aif.setOnLongClickListener(this.Ahl.Aij);
          }
          paramViewGroup.Aif.setTag(localObject2);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(99038);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
          {
            paramViewGroup = new e();
            paramView = z.jO(this.dsa).inflate(2131495590, null);
            paramViewGroup.AhE = ((TextView)paramView.findViewById(2131304967));
            paramViewGroup.AhD = ((TextView)paramView.findViewById(2131305007));
            paramViewGroup.AhF = ((TextView)paramView.findViewById(2131305106));
            paramViewGroup.AhP = ((MaskImageView)paramView.findViewById(2131300977));
            paramViewGroup.AhI = ((TextView)paramView.findViewById(2131296470));
            paramViewGroup.AhG = ((LinearLayout)paramView.findViewById(2131301423));
            paramViewGroup.AhH = ((ImageView)paramView.findViewById(2131301549));
            paramViewGroup.zOk = ((LinearLayout)paramView.findViewById(2131301456));
            paramViewGroup.zOl = paramView.findViewById(2131301422);
            paramViewGroup.AhP.setOnClickListener(this.Ahl.Aii);
            paramViewGroup.AhZ = ((TextView)paramView.findViewById(2131306862));
            paramViewGroup.Aif = ((MaskLinearLayout)paramView.findViewById(2131305003));
            paramViewGroup.Aif.b(paramViewGroup.AhP);
            paramViewGroup.AhT = ((MMNeat7extView)paramView.findViewById(2131298996));
            paramViewGroup.AhY = paramView.findViewById(2131299002);
            paramViewGroup.AhJ = ((LinearLayout)paramView.findViewById(2131300304));
            paramViewGroup.AhK = ((TextView)paramView.findViewById(2131305022));
            paramViewGroup.AhK.setOnClickListener(new be.5(this));
            paramView.setTag(paramViewGroup);
            ag.dUb().eR(paramViewGroup.AhP);
            if (this.zNS.get(Integer.valueOf(paramInt)) == null) {
              break label6317;
            }
          }
        }
        label2476:
        label6317:
        for (i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.AhF.setTag(Integer.valueOf(paramInt));
          paramViewGroup.Aif.settouchEnable(false);
          paramViewGroup.Aif.setBackgroundResource(0);
          paramViewGroup.Aif.setDescendantFocusability(131072);
          paramViewGroup.Aif.setClickable(false);
          paramViewGroup.AhP.settouchEnable(true);
          paramViewGroup.AhP.setClickable(true);
          paramViewGroup.Aif.setOnClickListener(null);
          if ((i >= this.zNV) || (i == -1))
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            paramView.setVisibility(8);
            AppMethodBeat.o(99038);
            return paramView;
            paramViewGroup = (e)paramView.getTag();
            break;
          }
          if (i - 1 >= 0)
          {
            localObject1 = (p)getItem(i - 1);
            j = ((p)localObject1).field_head;
            ak.ax(((p)localObject1).field_localPrivate, this.drv);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.zNT.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.zNT.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject2 = (p)getItem(i);
            Object localObject3 = ((p)localObject2).dYl();
            if (((this.drv) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
            {
              if (aB(paramInt, ((p)localObject2).field_snsId))
              {
                l = ((p)localObject2).field_createTime;
                a(paramViewGroup.AhD, paramViewGroup.AhE, l);
              }
              if (((TimeLineObject)localObject3).HAR != null)
              {
                if (!bt.isNullOrNil(((TimeLineObject)localObject3).HAR.jDf)) {
                  break label2832;
                }
                localObject1 = ((TimeLineObject)localObject3).HAR.jde;
                if ((localObject1 != null) && (!((String)localObject1).equals("")))
                {
                  paramViewGroup.AhI.setText((CharSequence)localObject1);
                  paramViewGroup.AhI.setVisibility(0);
                }
              }
              paramViewGroup.zOl.setVisibility(0);
            }
            else
            {
              a(paramViewGroup.AhF, j, ((p)localObject2).field_head);
              if ((this.Aht == 0L) || (((p)localObject2).field_snsId != this.Aht)) {
                break label2845;
              }
              paramViewGroup.AhJ.setVisibility(0);
              paramViewGroup.AhG.setVisibility(0);
              localObject1 = new com.tencent.mm.storage.bj(this.Ahj.tag);
              ((com.tencent.mm.storage.bj)localObject1).hbR = ((p)localObject2).field_createTime;
              paramViewGroup.AhP.setVisibility(0);
              ag.dUb().a(((TimeLineObject)localObject3).HAT.GaQ, paramViewGroup.AhP, this.dsa.hashCode(), f.a.zgR, (com.tencent.mm.storage.bj)localObject1);
              if (ak.ax(((p)localObject2).field_localPrivate, this.drv))
              {
                paramViewGroup.AhZ.setVisibility(0);
                paramViewGroup.AhZ.setBackgroundResource(2131233596);
                localObject1 = this.AaP.Bf(((p)localObject2).field_userName);
                if (localObject1 != null) {
                  ((com.tencent.mm.o.b)localObject1).adv();
                }
              }
              localObject1 = (p)getItem(i);
              localObject3 = ((p)localObject1).dYl().HAQ;
              if ((localObject3 != null) && (!((String)localObject3).equals("")))
              {
                paramViewGroup.AhY.setVisibility(0);
                paramViewGroup.AhT.setVisibility(0);
                paramViewGroup.AhT.ar(k.b(this.dsa, (CharSequence)localObject3, paramViewGroup.AhT.getTextSize()));
              }
              paramViewGroup.Aif.setDescendantFocusability(393216);
              paramViewGroup.Aif.setClickable(true);
              paramViewGroup.AhP.setClickable(false);
              paramViewGroup.AhP.settouchEnable(false);
              paramViewGroup.Aif.setOnClickListener(this.Ahl.Aii);
              paramViewGroup.Aif.settouchEnable(true);
              i = ((p)localObject2).zMC;
              localObject2 = new be.f.a();
              ((be.f.a)localObject2).dJd = i;
              if (this.Ahk.get(Integer.valueOf(paramInt)) == null) {
                break label2857;
              }
            }
            for (((be.f.a)localObject2).position = ((Integer)this.Ahk.get(Integer.valueOf(paramInt))).intValue();; ((be.f.a)localObject2).position = 0)
            {
              paramViewGroup.Aif.setTag(localObject2);
              paramView.setDrawingCacheEnabled(false);
              com.tencent.mm.plugin.sns.j.e.ztz.G((p)localObject1);
              AppMethodBeat.o(99038);
              return paramView;
              localObject1 = ((TimeLineObject)localObject3).HAR.jDf;
              break;
              paramViewGroup.AhJ.setVisibility(8);
              break label2476;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
              {
                paramViewGroup = new d();
                paramView = z.jO(this.dsa).inflate(2131495576, null);
                paramViewGroup.AhE = ((TextView)paramView.findViewById(2131304967));
                paramViewGroup.AhD = ((TextView)paramView.findViewById(2131305007));
                paramViewGroup.AhF = ((TextView)paramView.findViewById(2131305106));
                paramViewGroup.AhP = ((MaskImageView)paramView.findViewById(2131300977));
                paramViewGroup.AhQ = ((QFadeImageView)paramView.findViewById(2131305641));
                paramViewGroup.AhR = ((MaskImageView)paramView.findViewById(2131300978));
                paramViewGroup.AhS = ((MaskImageView)paramView.findViewById(2131300979));
                paramViewGroup.AhT = ((MMNeat7extView)paramView.findViewById(2131298996));
                paramViewGroup.AhU = ((TextView)paramView.findViewById(2131307000));
                paramViewGroup.AhV = ((TextView)paramView.findViewById(2131307001));
                paramViewGroup.AhW = ((TextView)paramView.findViewById(2131307002));
                paramViewGroup.AhX = ((TextView)paramView.findViewById(2131300986));
                paramViewGroup.AhY = paramView.findViewById(2131299002);
                paramViewGroup.AhI = ((TextView)paramView.findViewById(2131296470));
                paramViewGroup.AhG = ((LinearLayout)paramView.findViewById(2131301423));
                paramViewGroup.AhH = ((ImageView)paramView.findViewById(2131301549));
                paramViewGroup.zOk = ((LinearLayout)paramView.findViewById(2131301456));
                paramViewGroup.zOl = paramView.findViewById(2131301422);
                paramViewGroup.AhQ.setOnClickListener(this.Ahl.Aih);
                paramViewGroup.AhP.setOnClickListener(this.Ahl.Aih);
                paramViewGroup.AhZ = ((TextView)paramView.findViewById(2131306862));
                paramViewGroup.Aia = ((TextView)paramView.findViewById(2131306863));
                paramViewGroup.Aib = ((TextView)paramView.findViewById(2131306864));
                paramViewGroup.Aic = ((TextView)paramView.findViewById(2131306096));
                paramViewGroup.Aid = ((TextView)paramView.findViewById(2131306097));
                paramViewGroup.Aie = ((TextView)paramView.findViewById(2131306098));
                paramViewGroup.Aif = ((MaskLinearLayout)paramView.findViewById(2131305003));
                paramViewGroup.Aif.b(paramViewGroup.AhP);
                paramViewGroup.AhJ = ((LinearLayout)paramView.findViewById(2131300304));
                paramViewGroup.AhK = ((TextView)paramView.findViewById(2131305022));
                paramViewGroup.AhK.setOnClickListener(new be.10(this));
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                ag.dUb().eR(paramViewGroup.AhP);
                ag.dUb().eR(paramViewGroup.AhR);
                ag.dUb().eR(paramViewGroup.AhS);
                i = -1;
                if (this.zNS.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.AhF.setTag(Integer.valueOf(paramInt));
                paramViewGroup.Aif.settouchEnable(false);
                paramViewGroup.Aif.setBackgroundResource(0);
                paramViewGroup.Aif.setDescendantFocusability(131072);
                paramViewGroup.Aif.setClickable(false);
                paramViewGroup.AhP.settouchEnable(true);
                paramViewGroup.AhP.setClickable(true);
                paramViewGroup.Aif.setOnClickListener(null);
                if ((i < this.zNV) && (i != -1)) {
                  break;
                }
                paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                paramView.setVisibility(8);
                AppMethodBeat.o(99038);
                return paramView;
                paramViewGroup = (d)paramView.getTag();
              }
              if (i - 1 < 0) {
                break label6305;
              }
              localObject1 = (p)getItem(i - 1);
              j = ((p)localObject1).field_head;
              ak.ax(((p)localObject1).field_localPrivate, this.drv);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject2 = (p)getItem(i);
              localObject1 = ((p)localObject2).dYl();
              if (((this.drv) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
              {
                if (aB(paramInt, ((p)localObject2).field_snsId))
                {
                  l = ((p)localObject2).field_createTime;
                  a(paramViewGroup.AhD, paramViewGroup.AhE, l);
                }
                if (((TimeLineObject)localObject1).HAR != null)
                {
                  if (!bt.isNullOrNil(((TimeLineObject)localObject1).HAR.jDf)) {
                    break label3972;
                  }
                  localObject1 = ((TimeLineObject)localObject1).HAR.jde;
                  if ((localObject1 != null) && (!((String)localObject1).equals("")))
                  {
                    paramViewGroup.AhI.setText((CharSequence)localObject1);
                    paramViewGroup.AhI.setVisibility(0);
                  }
                }
                paramViewGroup.zOl.setVisibility(0);
              }
              else
              {
                a(paramViewGroup.AhF, j, ((p)localObject2).field_head);
                if ((this.Aht == 0L) || (((p)localObject2).field_snsId != this.Aht)) {
                  break label3985;
                }
                paramViewGroup.AhJ.setVisibility(0);
                label3800:
                paramViewGroup.AhG.setVisibility(0);
                if ((!this.drv) || (paramInt != 0)) {
                  break label4004;
                }
                paramViewGroup.AhQ.setVisibility(0);
                paramViewGroup.AhQ.setContentDescription(this.dsa.getString(2131764020));
                paramViewGroup.AhP.setVisibility(8);
                localObject2 = paramViewGroup.AhT;
                if (this.zNU != 1) {
                  break label3997;
                }
              }
              for (localObject1 = this.dsa.getString(2131764063);; localObject1 = "")
              {
                ((MMNeat7extView)localObject2).ar((CharSequence)localObject1);
                paramViewGroup.AhT.setVisibility(0);
                paramViewGroup.AhY.setVisibility(0);
                paramViewGroup.AhX.setVisibility(8);
                ag.dUb().d(paramViewGroup.AhQ, 2131100942, 2131234148, this.dsa.hashCode());
                localObject1 = new be.f.a();
                ((be.f.a)localObject1).dJd = -1;
                ((be.f.a)localObject1).position = -1;
                paramViewGroup.AhQ.setTag(localObject1);
                AppMethodBeat.o(99038);
                return paramView;
                localObject1 = ((TimeLineObject)localObject1).HAR.jDf;
                break;
                paramViewGroup.AhJ.setVisibility(8);
                break label3800;
              }
              a(i, paramViewGroup.AhP, paramViewGroup.AhU, paramViewGroup.AhX, paramViewGroup.AhZ, paramViewGroup.Aic, 1, paramViewGroup, paramInt);
              localObject1 = (p)getItem(i);
              if ((!bt.isNullOrNil(((p)localObject1).dYl().HAQ)) && (((p)localObject1).field_type == 1))
              {
                paramViewGroup.Aif.setDescendantFocusability(393216);
                paramViewGroup.Aif.setClickable(true);
                paramViewGroup.AhP.setClickable(false);
                paramViewGroup.AhP.settouchEnable(false);
                paramViewGroup.Aif.setOnClickListener(this.Ahl.Aih);
                paramViewGroup.Aif.settouchEnable(true);
                i = ((p)localObject2).zMC;
                localObject2 = new be.f.a();
                ((be.f.a)localObject2).dJd = i;
                if (this.Ahk.get(Integer.valueOf(paramInt)) == null) {
                  break label4216;
                }
              }
              label4216:
              for (((be.f.a)localObject2).position = ((Integer)this.Ahk.get(Integer.valueOf(paramInt))).intValue();; ((be.f.a)localObject2).position = 0)
              {
                paramViewGroup.Aif.setTag(localObject2);
                com.tencent.mm.plugin.sns.j.e.ztz.G((p)localObject1);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 4) {
                if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof b)))
                {
                  localObject1 = new b();
                  localObject2 = z.jO(this.dsa).inflate(2131495575, null);
                  ((b)localObject1).AhC = ((View)localObject2).findViewById(2131298764);
                  ((b)localObject1).AhE = ((TextView)((View)localObject2).findViewById(2131304967));
                  ((b)localObject1).AhD = ((TextView)((View)localObject2).findViewById(2131305007));
                  ((b)localObject1).AhF = ((TextView)((View)localObject2).findViewById(2131305106));
                  ((b)localObject1).AhI = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).zOl = ((View)localObject2).findViewById(2131301422);
                  ((b)localObject1).AhI = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).AhG = ((LinearLayout)((View)localObject2).findViewById(2131301423));
                  ((b)localObject1).AhH = ((ImageView)((View)localObject2).findViewById(2131301549));
                  ((b)localObject1).zOk = ((LinearLayout)((View)localObject2).findViewById(2131301456));
                  ((b)localObject1).opC = ((MMNeat7extView)((View)localObject2).findViewById(2131299008));
                  ((b)localObject1).AhL = ((TagImageView)((View)localObject2).findViewById(2131300948));
                  ((b)localObject1).zOS = ((ImageView)((View)localObject2).findViewById(2131305185));
                  ((b)localObject1).titleTv = ((TextView)((View)localObject2).findViewById(2131305950));
                  ((b)localObject1).AhN = ((TextView)((View)localObject2).findViewById(2131304202));
                  ((b)localObject1).AhC.setOnClickListener(this.Ahl.Aig);
                  ((b)localObject1).AhO = ((View)localObject2).findViewById(2131302207);
                  ((b)localObject1).AhM = ((TextView)((View)localObject2).findViewById(2131298762));
                  ((b)localObject1).AhJ = ((LinearLayout)((View)localObject2).findViewById(2131300304));
                  ((b)localObject1).AhK = ((TextView)((View)localObject2).findViewById(2131305022));
                  ((b)localObject1).AhK.setOnClickListener(new be.8(this));
                  ((View)localObject2).setTag(localObject1);
                  com.tencent.mm.plugin.sns.data.q.b(((b)localObject1).AhL, this.dsa);
                  ((b)localObject1).AhF.setTag(Integer.valueOf(paramInt));
                  if (this.zNS.get(Integer.valueOf(paramInt)) == null) {
                    break label6299;
                  }
                }
              }
              for (i = ((Integer)this.zNS.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                ((b)localObject1).init();
                if ((i >= this.zNV) || (i == -1))
                {
                  ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                  ((View)localObject2).setVisibility(8);
                  AppMethodBeat.o(99038);
                  return localObject2;
                  localObject1 = (b)paramView.getTag();
                  localObject2 = paramView;
                  break;
                }
                ((View)localObject2).setVisibility(0);
                if (i - 1 >= 0)
                {
                  paramView = (p)getItem(i - 1);
                  j = paramView.field_head;
                  ak.ax(paramView.field_localPrivate, this.drv);
                }
                for (;;)
                {
                  ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  ((View)localObject2).setVisibility(0);
                  localObject3 = (p)getItem(i);
                  TimeLineObject localTimeLineObject = ((p)localObject3).dYl();
                  Object localObject4;
                  if (((this.drv) && (paramInt == 0)) || (j == -1) || (((p)localObject3).field_head != j))
                  {
                    if (aB(paramInt, ((p)localObject3).field_snsId))
                    {
                      l = ((p)localObject3).field_createTime;
                      a(((b)localObject1).AhD, ((b)localObject1).AhE, l);
                    }
                    if (localTimeLineObject.HAR != null)
                    {
                      if (!bt.isNullOrNil(localTimeLineObject.HAR.jDf)) {
                        break label5213;
                      }
                      paramView = localTimeLineObject.HAR.jde;
                      if ((paramView != null) && (!paramView.equals("")))
                      {
                        ((b)localObject1).AhI.setText(paramView);
                        ((b)localObject1).AhI.setVisibility(0);
                      }
                    }
                    ((b)localObject1).zOl.setVisibility(0);
                  }
                  else
                  {
                    a(((b)localObject1).AhF, j, ((p)localObject3).field_head);
                    if ((this.Aht == 0L) || (((p)localObject3).field_snsId != this.Aht)) {
                      break label5225;
                    }
                    ((b)localObject1).AhJ.setVisibility(0);
                    localObject4 = new be.f.a();
                    ((be.f.a)localObject4).dJd = ((p)localObject3).zMC;
                    if (this.Ahk.get(Integer.valueOf(paramInt)) == null) {
                      break label5238;
                    }
                    ((be.f.a)localObject4).position = ((Integer)this.Ahk.get(Integer.valueOf(paramInt))).intValue();
                    label5060:
                    ((b)localObject1).AhC.setTag(localObject4);
                    if (bt.isNullOrNil(localTimeLineObject.HAQ)) {
                      break label5247;
                    }
                    ((b)localObject1).opC.setVisibility(0);
                    ((b)localObject1).opC.ar(k.b(this.dsa, localTimeLineObject.HAQ, ((b)localObject1).opC.getTextSize()));
                  }
                  com.tencent.mm.storage.bj localbj;
                  for (;;)
                  {
                    ((b)localObject1).AhG.setVisibility(0);
                    ((b)localObject1).opC.getWrappedTextView().setSingleLine(true);
                    ((b)localObject1).AhO.setVisibility(0);
                    localbj = new com.tencent.mm.storage.bj(this.Ahj.tag);
                    localbj.hbR = ((p)localObject3).field_createTime;
                    if ((localTimeLineObject.HAT.GaU != null) || (localTimeLineObject.HAT.GaV != null)) {
                      break label5260;
                    }
                    ad.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                    AppMethodBeat.o(99038);
                    return localObject2;
                    label5213:
                    paramView = localTimeLineObject.HAR.jDf;
                    break;
                    label5225:
                    ((b)localObject1).AhJ.setVisibility(8);
                    break label5001;
                    label5238:
                    ((be.f.a)localObject4).position = 0;
                    break label5060;
                    label5247:
                    ((b)localObject1).opC.setVisibility(8);
                  }
                  ((b)localObject1).titleTv.setTextColor(this.dsa.getResources().getColor(2131100711));
                  if (ebJ())
                  {
                    paramView = bh.aAS(localTimeLineObject.HAT.Url);
                    if (localTimeLineObject.HAT.GaU == null) {
                      break label5715;
                    }
                    paramView = this.dsa.getString(2131763973, new Object[] { localTimeLineObject.HAT.GaU.nickname });
                    if (localTimeLineObject.HAT.GaU.Gpi != 4) {
                      break label5668;
                    }
                    paramView = this.dsa.getString(2131767187, new Object[] { localTimeLineObject.HAT.GaU.nickname });
                    if (bt.isNullOrNil(localTimeLineObject.HAT.GaU.nickname)) {
                      paramView = this.dsa.getResources().getString(2131759151);
                    }
                    paramViewGroup = "";
                  }
                  for (;;)
                  {
                    if (paramView.length() > 40) {
                      paramView = paramView.substring(0, 40) + "...";
                    }
                    for (;;)
                    {
                      if (((b)localObject1).AhL != null)
                      {
                        ((b)localObject1).AhL.setTag(localObject4);
                        ((b)localObject1).AhL.setOnClickListener(this.Ahl.Aig);
                      }
                      ((b)localObject1).zOS.setVisibility(8);
                      if (localTimeLineObject.HAT.GaU != null) {
                        if (localTimeLineObject.HAT.GaU.Gpi == 1)
                        {
                          ((b)localObject1).AhL.setVisibility(8);
                          ((b)localObject1).AhM.setVisibility(0);
                          ((b)localObject1).AhM.setText(localTimeLineObject.HAT.GaU.desc);
                          label5560:
                          if (bt.isNullOrNil(paramViewGroup)) {
                            break label6208;
                          }
                          ((b)localObject1).AhN.setVisibility(0);
                          ((b)localObject1).AhN.setText(paramViewGroup);
                          label5585:
                          if (bt.isNullOrNil(paramView)) {
                            break label6233;
                          }
                          if (((b)localObject1).AhN.getVisibility() != 8) {
                            break label6221;
                          }
                          ((b)localObject1).titleTv.setMaxLines(2);
                          label5614:
                          ((b)localObject1).titleTv.setText(k.c(this.dsa, paramView));
                          ((b)localObject1).titleTv.setVisibility(0);
                        }
                      }
                      for (;;)
                      {
                        com.tencent.mm.plugin.sns.j.e.ztz.G((p)localObject3);
                        ((View)localObject2).setDrawingCacheEnabled(false);
                        AppMethodBeat.o(99038);
                        return localObject2;
                        paramView = "";
                        break;
                        if (localTimeLineObject.HAT.GaU.Gpi != 2) {
                          break label5383;
                        }
                        paramView = this.dsa.getString(2131767186, new Object[] { localTimeLineObject.HAT.GaU.nickname });
                        break label5383;
                        label5715:
                        if (localTimeLineObject.HAT.GaV == null) {
                          break label6285;
                        }
                        if (localTimeLineObject.HAT.GaV.sMj == 1) {}
                        for (paramView = "#" + localTimeLineObject.HAT.GaV.dzZ;; paramView = localTimeLineObject.HAT.GaV.dzZ)
                        {
                          paramViewGroup = localTimeLineObject.HAT.GaV.desc;
                          break;
                        }
                        if (!localTimeLineObject.HAT.GaU.mediaList.isEmpty())
                        {
                          ((b)localObject1).AhL.setVisibility(0);
                          localObject4 = new byn();
                          ((byn)localObject4).Url = ((ari)localTimeLineObject.HAT.GaU.mediaList.get(0)).thumbUrl;
                          ((byn)localObject4).GSI = ((ari)localTimeLineObject.HAT.GaU.mediaList.get(0)).thumbUrl;
                          ((byn)localObject4).nEf = 2;
                          ((byn)localObject4).GSJ = 1;
                          ((byn)localObject4).GSL = new byp();
                          ((byn)localObject4).GEe = 1;
                          ((byn)localObject4).GSL.GTz = ((ari)localTimeLineObject.HAT.GaU.mediaList.get(0)).width;
                          ((byn)localObject4).GSL.GTA = ((ari)localTimeLineObject.HAT.GaU.mediaList.get(0)).height;
                          ((byn)localObject4).Id = ((p)localObject3).getSnsId();
                          ag.dUb().a((byn)localObject4, ((b)localObject1).AhL, this.dsa.hashCode(), f.a.zgR, localbj);
                        }
                        if (localTimeLineObject.HAT.GaU.Gpi != 4) {
                          break label5560;
                        }
                        ((b)localObject1).zOS.setVisibility(0);
                        ((b)localObject1).zOS.setImageDrawable(((b)localObject1).zOS.getContext().getResources().getDrawable(2131691166));
                        break label5560;
                        if (localTimeLineObject.HAT.GaV == null) {
                          break label5560;
                        }
                        ((b)localObject1).AhL.setVisibility(0);
                        localObject4 = new byn();
                        ((byn)localObject4).Url = localTimeLineObject.HAT.GaV.iconUrl;
                        ((byn)localObject4).GSI = localTimeLineObject.HAT.GaV.iconUrl;
                        ((byn)localObject4).nEf = 2;
                        ((byn)localObject4).GSJ = 1;
                        ((byn)localObject4).GSL = new byp();
                        ((byn)localObject4).GEe = 1;
                        ((byn)localObject4).GSL.GTz = 0.0F;
                        ((byn)localObject4).GSL.GTA = 0.0F;
                        ((byn)localObject4).Id = ((p)localObject3).getSnsId();
                        ag.dUb().a((byn)localObject4, ((b)localObject1).AhL, this.dsa.hashCode(), f.a.zgR, localbj);
                        break label5560;
                        label6208:
                        ((b)localObject1).AhN.setVisibility(8);
                        break label5585;
                        label6221:
                        ((b)localObject1).titleTv.setMaxLines(1);
                        break label5614;
                        label6233:
                        ((b)localObject1).titleTv.setVisibility(8);
                      }
                      if (i == 5)
                      {
                        paramView = l(paramInt, paramView);
                        AppMethodBeat.o(99038);
                        return paramView;
                      }
                      paramView = k(paramInt, paramView);
                      AppMethodBeat.o(99038);
                      return paramView;
                    }
                    paramViewGroup = paramView;
                    paramView = "";
                  }
                  j = -1;
                }
              }
              j = -1;
            }
            j = -1;
          }
        }
      }
      label1702:
      label6329:
      j = -1;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 6;
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.i.b> hO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99052);
    ArrayList localArrayList = new ArrayList();
    this.Ahx = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      p localp = (p)this.list.get(paramInt2);
      int j = localp.zMC;
      if ((localp.dYl() != null) && (localp.dYl().HAT != null) && (localp.dYl().HAT.GaQ.size() != 0) && ((localp.dYl().HAT.GaP == 1) || (localp.dYl().HAT.GaP == 15)))
      {
        if (j == paramInt1) {
          this.Ahx = localArrayList.size();
        }
        Iterator localIterator = localp.dYl().HAT.GaQ.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          byn localbyn = (byn)localIterator.next();
          com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
          localb.dIQ = localbyn;
          localb.parentId = x.bn("sns_table_", j);
          localb.hZE = localp.field_createTime;
          localb.zqt = i;
          localArrayList.add(localb);
          i += 1;
        }
      }
      paramInt2 += 1;
    }
    AppMethodBeat.o(99052);
    return localArrayList;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(99047);
    super.notifyDataSetChanged();
    AppMethodBeat.o(99047);
  }
  
  class a
  {
    View AhC;
    TextView AhD;
    TextView AhE;
    TextView AhF;
    LinearLayout AhG;
    ImageView AhH;
    TextView AhI;
    LinearLayout AhJ;
    TextView AhK;
    LinearLayout zOk;
    View zOl;
    
    a() {}
    
    public void init()
    {
      AppMethodBeat.i(99026);
      this.AhD.setVisibility(8);
      this.AhE.setVisibility(8);
      this.AhF.setVisibility(8);
      this.AhG.setVisibility(4);
      this.AhH.setVisibility(4);
      this.zOl.setVisibility(8);
      this.AhI.setVisibility(8);
      this.AhJ.setVisibility(8);
      AppMethodBeat.o(99026);
    }
  }
  
  final class b
    extends be.a
  {
    TagImageView AhL;
    TextView AhM;
    TextView AhN;
    View AhO;
    MMNeat7extView opC;
    TextView titleTv;
    ImageView zOS;
    
    b()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99027);
      super.init();
      this.opC.setVisibility(8);
      this.AhL.setVisibility(8);
      if (this.AhM != null) {
        this.AhM.setVisibility(8);
      }
      this.zOS.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.AhN.setVisibility(8);
      AppMethodBeat.o(99027);
    }
  }
  
  public static abstract interface c
  {
    public abstract void ecz();
  }
  
  final class d
    extends be.a
  {
    MaskImageView AhP;
    QFadeImageView AhQ;
    QFadeImageView AhR;
    QFadeImageView AhS;
    MMNeat7extView AhT;
    TextView AhU;
    TextView AhV;
    TextView AhW;
    TextView AhX;
    View AhY;
    TextView AhZ;
    TextView Aia;
    TextView Aib;
    TextView Aic;
    TextView Aid;
    TextView Aie;
    MaskLinearLayout Aif;
    
    d()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99028);
      super.init();
      this.AhP.setVisibility(8);
      this.AhR.setVisibility(8);
      this.AhS.setVisibility(8);
      this.AhT.setVisibility(8);
      this.AhU.setVisibility(8);
      this.AhV.setVisibility(8);
      this.AhW.setVisibility(8);
      this.AhX.setVisibility(8);
      this.AhY.setVisibility(8);
      this.AhQ.setVisibility(8);
      this.AhZ.setVisibility(8);
      this.Aia.setVisibility(8);
      this.Aib.setVisibility(8);
      this.Aic.setVisibility(8);
      this.Aid.setVisibility(8);
      this.Aie.setVisibility(8);
      if (com.tencent.mm.cc.a.eb(be.f(be.this)) > 1.0F) {
        this.AhT.setMaxLines(2);
      }
      AppMethodBeat.o(99028);
    }
  }
  
  final class e
    extends be.a
  {
    MaskImageView AhP;
    MMNeat7extView AhT;
    View AhY;
    TextView AhZ;
    MaskLinearLayout Aif;
    
    e()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99029);
      super.init();
      this.AhP.setVisibility(8);
      this.AhT.setVisibility(8);
      this.AhZ.setVisibility(8);
      this.AhY.setVisibility(8);
      if (com.tencent.mm.cc.a.eb(be.f(be.this)) > 1.0F) {
        this.AhT.setMaxLines(2);
      }
      AppMethodBeat.o(99029);
    }
  }
  
  static abstract class f
  {
    View.OnClickListener Aig = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99033);
          return;
        }
        ad.d("MicroMsg.SnsphotoAdapter", "sign click");
        be.f.this.Aik = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Aik.dJd;
        int j = be.f.this.Aik.position;
        be.f.this.hQ(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99033);
      }
    };
    View.OnClickListener Aih = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99034);
          return;
        }
        ad.d("MicroMsg.SnsphotoAdapter", "sign click");
        be.f.this.Aik = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Aik.dJd;
        be.f.this.Rm(i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99034);
      }
    };
    View.OnClickListener Aii = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99035);
          return;
        }
        ad.d("MicroMsg.SnsphotoAdapter", "snssight click");
        be.f.this.Aik = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Aik.dJd;
        int j = be.f.this.Aik.position;
        be.f.this.hQ(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99035);
      }
    };
    View.OnLongClickListener Aij = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(99036);
          return true;
        }
        ad.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
        be.f.this.Aik = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Aik.dJd;
        int j = be.f.this.Aik.position;
        be.f.this.hR(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(99036);
        return true;
      }
    };
    public a Aik = new a();
    View.OnClickListener zOb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99030);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99030);
          return;
        }
        be.f.this.Aik = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Aik.dJd;
        int j = be.f.this.Aik.position;
        be.f.this.hP(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99030);
      }
    };
    View.OnClickListener zOc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99031);
          return;
        }
        be.f.this.Aik = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Aik.dJd;
        int j = be.f.this.Aik.position;
        be.f.this.hP(i, j + 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99031);
      }
    };
    View.OnClickListener zOd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99032);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99032);
          return;
        }
        be.f.this.Aik = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Aik.dJd;
        int j = be.f.this.Aik.position;
        be.f.this.hP(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99032);
      }
    };
    
    public abstract void Rm(int paramInt);
    
    public abstract void hP(int paramInt1, int paramInt2);
    
    public abstract void hQ(int paramInt1, int paramInt2);
    
    public abstract void hR(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public int dJd;
      public int position;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be
 * JD-Core Version:    0.7.0.1
 */