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
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.model.g.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bq;
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
  Map<Integer, Integer> AeZ;
  private Map<Integer, Integer> Afa;
  private int Afb;
  private int Afc;
  String AmT;
  private bq Asc;
  bg AyA;
  private c AyB;
  int AyC;
  int AyD;
  private long AyE;
  private long AyF;
  boolean AyG;
  private int AyH;
  private int AyI;
  int AyJ;
  protected View.OnClickListener AyK;
  private bk Ayv;
  private Map<Integer, Integer> Ayw;
  private f Ayx;
  boolean Ayy;
  bf Ayz;
  private String country;
  private boolean dsB;
  private Activity dtg;
  boolean isSearchMode;
  List<p> list;
  String rmb;
  private boolean uej;
  private String userName;
  private String vlG;
  long zzM;
  
  public be(Activity paramActivity, f paramf, String paramString, final c paramc)
  {
    AppMethodBeat.i(99037);
    this.userName = "";
    this.list = new ArrayList();
    this.AeZ = new HashMap();
    this.Afa = new HashMap();
    this.Ayw = new HashMap();
    this.Afb = 0;
    this.Afc = 0;
    this.dsB = false;
    this.AmT = "";
    this.Ayy = false;
    this.uej = false;
    this.zzM = 0L;
    this.rmb = "";
    this.Asc = null;
    this.vlG = "";
    this.AyC = 2147483647;
    this.AyD = 0;
    this.AyE = 0L;
    this.AyF = 0L;
    this.isSearchMode = false;
    this.AyG = false;
    this.AyH = 0;
    this.AyI = 0;
    this.AyJ = 0;
    this.AyK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219921);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
          if (be.aCi(paramAnonymousView.Id)) {
            break label162;
          }
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10090, "1,0");
          if ((!com.tencent.mm.r.a.ch(be.f(be.this))) && (!com.tencent.mm.r.a.cf(be.f(be.this))) && (!com.tencent.mm.r.a.cj(be.f(be.this))))
          {
            paramAnonymousView = h.a(ah.getAccPath(), paramAnonymousView, 8);
            paramAnonymousView.ikr = be.g(be.this);
            com.tencent.mm.ay.a.c(paramAnonymousView);
          }
        }
        for (;;)
        {
          be.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219921);
          return;
          label162:
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10231, "1");
          com.tencent.mm.ay.a.aJX();
        }
      }
    };
    this.userName = paramString;
    this.dtg = paramActivity;
    this.Ayx = paramf;
    this.AyB = paramc;
    this.Asc = ah.dXs();
    paramf = ad.f(this.dtg.getSharedPreferences(ak.fow(), 0));
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(paramf)));
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
    this.vlG = paramActivity;
    this.country = ad.f(this.dtg.getSharedPreferences(ak.fow(), 0));
    com.tencent.mm.kernel.g.ajS();
    paramActivity = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null);
    if (this.userName.equals(paramActivity)) {
      this.dsB = true;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.dsB) {
      this.Ayv = bk.fvp();
    }
    for (;;)
    {
      this.Ayz = new bf(new bf.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99016);
          if (!be.a(be.this))
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            be.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            paramAnonymousList = be.this;
            if (!be.b(be.this).isEmpty()) {
              break label77;
            }
          }
          label77:
          for (long l = 0L;; l = ((p)be.b(be.this).get(be.b(be.this).size() - 1)).field_snsId)
          {
            be.a(paramAnonymousList, r.zW(l));
            AppMethodBeat.o(99016);
            return;
          }
        }
        
        public final void egf()
        {
          AppMethodBeat.i(99017);
          if (!be.a(be.this))
          {
            be.c(be.this);
            be.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.egg();
            }
          }
          AppMethodBeat.o(99017);
        }
      }, paramString, this.dsB);
      this.AyA = new bg(new bf.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99018);
          if (be.a(be.this))
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            be.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            be.d(be.this);
          }
          AppMethodBeat.o(99018);
        }
        
        public final void egf()
        {
          AppMethodBeat.i(99019);
          if (be.a(be.this))
          {
            be.c(be.this);
            be.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.egg();
            }
          }
          AppMethodBeat.o(99019);
        }
      }, this.dsB);
      AN(0L);
      sa(false);
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
      com.tencent.mm.kernel.g.ajS();
      paramActivity = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
      if ((paramActivity != null) && (c.lO(paramActivity.field_type))) {
        this.Ayv = bk.fvo();
      } else {
        this.Ayv = bk.fvq();
      }
    }
  }
  
  private void AN(long paramLong)
  {
    AppMethodBeat.i(99050);
    Object localObject = r.zW(ah.dXE().b(paramLong, ah.dXu().aAr(this.userName), this.userName, this.dsB));
    if (this.AmT.equals("")) {}
    for (;;)
    {
      this.rmb = ((String)localObject);
      localObject = ah.dXI().aBw(this.userName).ecg();
      if (((aju)localObject).Gzo != 0L) {
        break;
      }
      AppMethodBeat.o(99050);
      return;
      if (((String)localObject).compareTo(this.AmT) >= 0) {
        localObject = this.AmT;
      }
    }
    localObject = r.zW(((aju)localObject).Gzo);
    if (this.rmb.equals(""))
    {
      this.rmb = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
    }
    if (((String)localObject).compareTo(this.rmb) > 0) {}
    for (;;)
    {
      this.rmb = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
      localObject = this.rmb;
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, d paramd, int paramInt3)
  {
    AppMethodBeat.i(99044);
    p localp = (p)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localp.ebP();
    SnsObject localSnsObject = al.v(localp);
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
    if ((this.dsB) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localp.field_userName)))
    {
      paramTextView3.setBackgroundResource(2131233602);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (al.aA(localp.field_localPrivate, this.dsB))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233596);
        localObject = this.Asc.BH(localp.field_userName);
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
      paramInt1 = localp.AdJ;
      paramTextView1 = new be.f.a();
      paramTextView1.dKr = paramInt1;
      if (this.Ayw.get(Integer.valueOf(paramInt3)) == null) {
        break label677;
      }
      paramTextView1.position = ((Integer)this.Ayw.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new bk(this.Ayv.tag);
      paramTextView1.heF = localp.field_createTime;
      if (localTimeLineObject.HUG.Gtw != 1) {
        break label685;
      }
      paramQFadeImageView.setVisibility(0);
      ah.dXB().a(localTimeLineObject.HUG.Gtx, paramQFadeImageView, this.dtg.hashCode(), g.a.zxH, paramTextView1);
      label367:
      if ((localp.dXn()) && (localp.ecq()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233594);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.HUG.Gtx == null) || (localTimeLineObject.HUG.Gtx.size() <= 1)) {
          break label808;
        }
        paramd.Azk.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.HUG.Gtx.size();
        paramTextView2.setText(this.dtg.getResources().getQuantityString(2131623966, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.HUD;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        paramd.Azk.setVisibility(0);
        paramd.Azf.setVisibility(0);
        paramd.Azf.aq(k.b(this.dtg, paramQFadeImageView, paramd.Azf.getTextSize()));
      }
      AppMethodBeat.o(99044);
      return;
      label559:
      localObject = ((c)localObject).adG();
      break;
      if (!al.aA(localp.field_localPrivate, this.dsB)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(2131233596);
      localObject = this.Asc.BH(localp.field_userName);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((c)localObject).adG())
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
      if (localTimeLineObject.HUG.Gtw == 2)
      {
        paramTextView4.setText(bu.bI(localTimeLineObject.HUG.Desc, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.HUG.Gtw != 21) {
        break label367;
      }
      localp.ech();
      boolean bool = true;
      if (this.dsB) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        ah.dXB().a(localTimeLineObject.HUG.Gtx, paramQFadeImageView, this.dtg.hashCode(), g.a.zxH, paramTextView1, bool);
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
    n(paramTextView);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (this.isSearchMode)
    {
      if ((i != 0) && (paramInt2 != i))
      {
        fi(paramTextView);
        paramTextView.setText(String.format(this.dtg.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        n(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (i == 0)
    {
      if (bj.getYear() != paramInt2)
      {
        fi(paramTextView);
        paramTextView.setText(String.format(this.dtg.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        n(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (paramInt2 != i)
    {
      fi(paramTextView);
      paramTextView.setText(String.format(this.dtg.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      n(paramTextView);
    }
    AppMethodBeat.o(99040);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(99039);
    Object localObject = this.dtg;
    if (!this.vlG.equals("en")) {}
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
      localObject[0] = bj.G(this.dtg, localObject[0], this.vlG);
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
  
  private boolean aB(int paramInt, long paramLong)
  {
    return (!this.isSearchMode) || ((paramInt == 0) && (this.zzM == paramLong)) || (paramInt > 0) || (this.AyG);
  }
  
  protected static boolean aCi(String paramString)
  {
    AppMethodBeat.i(99054);
    f localf = com.tencent.mm.ay.a.aKc();
    if ((localf != null) && (com.tencent.mm.ay.a.e(localf)) && (paramString.equals(localf.ijZ)) && (com.tencent.mm.ay.a.aJZ()))
    {
      AppMethodBeat.o(99054);
      return true;
    }
    AppMethodBeat.o(99054);
    return false;
  }
  
  private static boolean efq()
  {
    AppMethodBeat.i(163123);
    if ((ao.a.dYj() & 0x1) <= 0)
    {
      AppMethodBeat.o(163123);
      return true;
    }
    AppMethodBeat.o(163123);
    return false;
  }
  
  private void fi(View paramView)
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
      localLayoutParams.topMargin = this.dtg.getResources().getDimensionPixelSize(2131166851);
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
      localView = z.jV(this.dtg).inflate(2131495575, null);
      localb.AyO = localView.findViewById(2131298764);
      localb.AyQ = ((TextView)localView.findViewById(2131304967));
      localb.AyP = ((TextView)localView.findViewById(2131305007));
      localb.AyR = ((TextView)localView.findViewById(2131305106));
      localb.AyU = ((TextView)localView.findViewById(2131296470));
      localb.Afs = localView.findViewById(2131301422);
      localb.AyU = ((TextView)localView.findViewById(2131296470));
      localb.AyS = ((LinearLayout)localView.findViewById(2131301423));
      localb.AyT = ((ImageView)localView.findViewById(2131301549));
      localb.Afr = ((LinearLayout)localView.findViewById(2131301456));
      localb.ovu = ((MMNeat7extView)localView.findViewById(2131299008));
      localb.AyX = ((TagImageView)localView.findViewById(2131300948));
      localb.AfZ = ((ImageView)localView.findViewById(2131305185));
      localb.titleTv = ((TextView)localView.findViewById(2131305950));
      localb.AyZ = ((TextView)localView.findViewById(2131304202));
      localb.AyO.setOnClickListener(this.Ayx.Azs);
      localb.Aza = localView.findViewById(2131302207);
      localb.AyV = ((LinearLayout)localView.findViewById(2131300304));
      localb.AyW = ((TextView)localView.findViewById(2131305022));
      localb.AyW.setOnClickListener(new be.7(this));
      localView.setTag(localb);
      r.b(localb.AyX, this.dtg);
      localb.AyR.setTag(Integer.valueOf(paramInt));
      if (this.AeZ.get(Integer.valueOf(paramInt)) == null) {
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
    for (int i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.Afc) || (i == -1))
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
        al.aA(paramView.field_localPrivate, this.dsB);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.Afa.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.Afa.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject1 = (p)getItem(i);
        TimeLineObject localTimeLineObject = ((p)localObject1).ebP();
        label846:
        Object localObject2;
        if (((this.dsB) && (paramInt == 0)) || (j == -1) || (((p)localObject1).field_head != j))
        {
          if (aB(paramInt, ((p)localObject1).field_snsId))
          {
            long l = ((p)localObject1).field_createTime;
            a(localb.AyP, localb.AyQ, l);
          }
          if (localTimeLineObject.HUE != null)
          {
            if (!bu.isNullOrNil(localTimeLineObject.HUE.jGd)) {
              break label1037;
            }
            paramView = localTimeLineObject.HUE.jfX;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.AyU.setText(paramView);
              localb.AyU.setVisibility(0);
            }
          }
          localb.Afs.setVisibility(0);
        }
        else
        {
          a(localb.AyR, j, ((p)localObject1).field_head);
          if ((this.AyF == 0L) || (((p)localObject1).field_snsId != this.AyF)) {
            break label1049;
          }
          localb.AyV.setVisibility(0);
          paramView = new be.f.a();
          paramView.dKr = ((p)localObject1).AdJ;
          if (this.Ayw.get(Integer.valueOf(paramInt)) == null) {
            break label1062;
          }
          paramView.position = ((Integer)this.Ayw.get(Integer.valueOf(paramInt))).intValue();
          localb.AyO.setTag(paramView);
          if (bu.isNullOrNil(localTimeLineObject.HUD)) {
            break label1070;
          }
          localb.ovu.setVisibility(0);
          localb.ovu.aq(k.b(this.dtg, localTimeLineObject.HUD, localb.ovu.getTextSize()));
          localb.AyS.setVisibility(0);
          localb.ovu.setMaxLines(1);
          localb.ovu.getWrappedTextView().setSingleLine(true);
          localb.Aza.setVisibility(0);
          paramInt = localTimeLineObject.HUG.Gtw;
          localObject2 = new bk(this.Ayv.tag);
          ((bk)localObject2).heF = ((p)localObject1).field_createTime;
          if (paramInt != 2) {
            break label1083;
          }
          localb.ovu.setVisibility(0);
          localb.ovu.getWrappedTextView().setSingleLine(false);
          localb.ovu.setMaxLines(2);
          localb.Aza.setVisibility(8);
        }
        bzh localbzh;
        for (;;)
        {
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(163122);
          return localView;
          paramView = localTimeLineObject.HUE.jGd;
          break;
          localb.AyV.setVisibility(8);
          break label790;
          paramView.position = 0;
          break label846;
          localb.ovu.setVisibility(8);
          break label903;
          if (paramInt != 4) {
            break label1424;
          }
          if (!localTimeLineObject.HUG.Gtx.isEmpty())
          {
            localb.AyX.setVisibility(0);
            localb.AfZ.setVisibility(0);
            localb.Aza.setVisibility(0);
            localb.titleTv.setMaxLines(1);
            localb.titleTv.setTextColor(this.dtg.getResources().getColor(2131100914));
            localbzh = (bzh)localTimeLineObject.HUG.Gtx.get(0);
            ah.dXB().a(localbzh, localb.AyX, 2131689564, this.dtg.hashCode(), g.a.zxH, (bk)localObject2);
            localb.AfZ.setPressed(false);
            if (aCi(localTimeLineObject.Id))
            {
              localb.AfZ.setImageResource(2131233393);
              label1235:
              localb.AyX.setTag(localTimeLineObject);
              localb.AyX.setOnClickListener(this.AyK);
              localbzh.dKr = ((p)localObject1).AdJ;
              localb.Aza.setTag(localTimeLineObject);
              localObject1 = localbzh.Desc;
              if (bu.isNullOrNil((String)localObject1)) {
                break label1386;
              }
              localb.AyZ.setVisibility(0);
              localb.AyZ.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = localbzh.Title;
              if (bu.isNullOrNil((String)localObject1)) {
                break label1398;
              }
              localb.titleTv.setVisibility(0);
              localb.titleTv.setTag(paramView);
              localb.titleTv.setOnTouchListener(new ae());
              localb.titleTv.setText((CharSequence)localObject1);
              break;
              localb.AfZ.setImageResource(2131233395);
              break label1235;
              label1386:
              localb.AyZ.setVisibility(4);
            }
            label1398:
            localb.titleTv.setVisibility(8);
          }
          else
          {
            localb.Aza.setVisibility(8);
          }
        }
        localb.titleTv.setTextColor(this.dtg.getResources().getColor(2131099732));
        if (efq())
        {
          paramView = bh.aCj(localTimeLineObject.HUG.Url);
          localObject1 = localTimeLineObject.HUG.Title;
          if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
            break label1981;
          }
          localObject1 = ((String)localObject1).substring(0, 40) + "...";
        }
        for (;;)
        {
          if (localb.AyX != null) {
            localb.AyX.setOnClickListener(null);
          }
          localb.AfZ.setVisibility(8);
          if (!localTimeLineObject.HUG.Gtx.isEmpty())
          {
            localb.AyX.setVisibility(0);
            localbzh = (bzh)localTimeLineObject.HUG.Gtx.get(0);
            if (localTimeLineObject.HUG.Gtw == 5)
            {
              paramView = bh.aCj(localbzh.Url);
              localObject1 = localbzh.Title;
              localb.AfZ.setVisibility(0);
              ah.dXB().a(localbzh, localb.AyX, 2131689581, this.dtg.hashCode(), g.a.zxH, (bk)localObject2);
              label1649:
              localObject2 = paramView;
              if (localTimeLineObject.HUG.GtA != null)
              {
                localObject2 = paramView;
                if (localTimeLineObject.HUG.GtA.hBY == 1) {
                  localObject2 = ak.getContext().getString(2131761345);
                }
              }
              if (bu.isNullOrNil((String)localObject2)) {
                break label1930;
              }
              localb.AyZ.setVisibility(0);
              localb.AyZ.setText((CharSequence)localObject2);
              if (bu.isNullOrNil((String)localObject1)) {
                break label1968;
              }
              if (localb.AyZ.getVisibility() != 8) {
                break label1943;
              }
              localb.titleTv.setMaxLines(2);
              label1749:
              localb.titleTv.setVisibility(0);
              if ((localTimeLineObject.hCH & 0x1) <= 0) {
                break label1955;
              }
              localb.titleTv.setText(r.a((String)localObject1, this.dtg, localb.titleTv));
            }
          }
          for (;;)
          {
            if ((localTimeLineObject.HUM == null) || (localTimeLineObject.HUM.subType != 1)) {
              break label1979;
            }
            localb.AfZ.setVisibility(0);
            localb.AfZ.setImageDrawable(localb.AfZ.getContext().getResources().getDrawable(2131691166));
            break;
            paramView = "";
            break label1463;
            ah.dXB().a(localbzh, localb.AyX, this.dtg.hashCode(), g.a.zxH, (bk)localObject2);
            break label1649;
            if (localTimeLineObject.HUG.Gtw != 26)
            {
              localb.AyX.setVisibility(8);
              break label1649;
            }
            localb.AyX.setVisibility(0);
            localb.AyX.setImageResource(2131690949);
            break label1649;
            localb.AyZ.setVisibility(8);
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
    AppMethodBeat.i(219922);
    b localb;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof b)))
    {
      localb = new b();
      localView = z.jV(this.dtg).inflate(2131495575, null);
      localb.AyO = localView.findViewById(2131298764);
      localb.AyQ = ((TextView)localView.findViewById(2131304967));
      localb.AyP = ((TextView)localView.findViewById(2131305007));
      localb.AyR = ((TextView)localView.findViewById(2131305106));
      localb.AyU = ((TextView)localView.findViewById(2131296470));
      localb.Afs = localView.findViewById(2131301422);
      localb.AyU = ((TextView)localView.findViewById(2131296470));
      localb.AyS = ((LinearLayout)localView.findViewById(2131301423));
      localb.AyT = ((ImageView)localView.findViewById(2131301549));
      localb.Afr = ((LinearLayout)localView.findViewById(2131301456));
      localb.ovu = ((MMNeat7extView)localView.findViewById(2131299008));
      localb.AyX = ((TagImageView)localView.findViewById(2131300948));
      localb.AfZ = ((ImageView)localView.findViewById(2131305185));
      localb.titleTv = ((TextView)localView.findViewById(2131305950));
      localb.AyZ = ((TextView)localView.findViewById(2131304202));
      localb.AyO.setOnClickListener(this.Ayx.Azs);
      localb.Aza = localView.findViewById(2131302207);
      localb.AyY = ((TextView)localView.findViewById(2131298762));
      localb.AyV = ((LinearLayout)localView.findViewById(2131300304));
      localb.AyW = ((TextView)localView.findViewById(2131305022));
      localb.AyW.setOnClickListener(new be.9(this));
      localView.setTag(localb);
      r.b(localb.AyX, this.dtg);
      localb.AyR.setTag(Integer.valueOf(paramInt));
      if (this.AeZ.get(Integer.valueOf(paramInt)) == null) {
        break label1424;
      }
    }
    label770:
    label1424:
    for (int i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.Afc) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(219922);
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
        al.aA(paramView.field_localPrivate, this.dsB);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        p localp = (p)getItem(i);
        Object localObject = localp.ebP();
        if (((this.dsB) && (paramInt == 0)) || (j == -1) || (localp.field_head != j))
        {
          if (aB(paramInt, localp.field_snsId))
          {
            long l = localp.field_createTime;
            a(localb.AyP, localb.AyQ, l);
          }
          if (((TimeLineObject)localObject).HUE != null)
          {
            if (!bu.isNullOrNil(((TimeLineObject)localObject).HUE.jGd)) {
              break label967;
            }
            paramView = ((TimeLineObject)localObject).HUE.jfX;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.AyU.setText(paramView);
              localb.AyU.setVisibility(0);
            }
          }
          localb.Afs.setVisibility(0);
        }
        else
        {
          a(localb.AyR, j, localp.field_head);
          if ((this.AyF == 0L) || (localp.field_snsId != this.AyF)) {
            break label979;
          }
          localb.AyV.setVisibility(0);
          paramView = new be.f.a();
          paramView.dKr = localp.AdJ;
          if (this.Ayw.get(Integer.valueOf(paramInt)) == null) {
            break label992;
          }
          paramView.position = ((Integer)this.Ayw.get(Integer.valueOf(paramInt))).intValue();
          label826:
          localb.AyO.setTag(paramView);
          if (bu.isNullOrNil(((TimeLineObject)localObject).HUD)) {
            break label1000;
          }
          localb.ovu.setVisibility(0);
          localb.ovu.aq(k.b(this.dtg, ((TimeLineObject)localObject).HUD, localb.ovu.getTextSize()));
        }
        bk localbk;
        for (;;)
        {
          localb.AyS.setVisibility(0);
          localb.ovu.getWrappedTextView().setSingleLine(true);
          localb.Aza.setVisibility(0);
          localbk = new bk(this.Ayv.tag);
          localbk.heF = localp.field_createTime;
          if (((TimeLineObject)localObject).HUG.GtD != null) {
            break label1013;
          }
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
          AppMethodBeat.o(219922);
          return localView;
          label967:
          paramView = ((TimeLineObject)localObject).HUE.jGd;
          break;
          label979:
          localb.AyV.setVisibility(8);
          break label770;
          label992:
          paramView.position = 0;
          break label826;
          label1000:
          localb.ovu.setVisibility(8);
        }
        label1013:
        localb.titleTv.setTextColor(this.dtg.getResources().getColor(2131100711));
        paramView = "";
        if (((TimeLineObject)localObject).HUG.GtD != null)
        {
          localb.AyX.setVisibility(0);
          paramView = ((TimeLineObject)localObject).HUG.GtD.title;
          bzh localbzh = new bzh();
          localbzh.Url = ((TimeLineObject)localObject).HUG.GtD.hGe;
          localbzh.Hmj = ((TimeLineObject)localObject).HUG.GtD.hGe;
          localbzh.nJA = 2;
          localbzh.Hmk = 1;
          localbzh.Hmm = new bzj();
          localbzh.GXH = 1;
          localbzh.Hmm.Hna = ((TimeLineObject)localObject).HUG.GtD.width;
          localbzh.Hmm.Hnb = ((TimeLineObject)localObject).HUG.GtD.height;
          localbzh.Id = localp.getSnsId();
          ah.dXB().a(localbzh, localb.AyX, this.dtg.hashCode(), g.a.zxH, localbk);
        }
        localObject = paramView;
        if (paramView.length() > 40) {
          localObject = paramView.substring(0, 40) + "...";
        }
        if (localb.AyX != null) {
          localb.AyX.setOnClickListener(null);
        }
        localb.AfZ.setVisibility(0);
        localb.AfZ.setImageDrawable(ao.k(localb.AfZ.getContext(), 2131690672, -1));
        localb.AyZ.setVisibility(8);
        if (!bu.isNullOrNil((String)localObject)) {
          if (localb.AyZ.getVisibility() == 8)
          {
            localb.titleTv.setMaxLines(2);
            localb.titleTv.setText(k.c(this.dtg, (CharSequence)localObject));
            localb.titleTv.setVisibility(0);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.j.e.zKO.G(localp);
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(219922);
          return localView;
          localb.titleTv.setMaxLines(1);
          break;
          localb.titleTv.setVisibility(8);
        }
        j = -1;
      }
    }
  }
  
  private void n(final TextView paramTextView)
  {
    AppMethodBeat.i(99041);
    if (this.AyH <= 0) {
      paramTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99020);
          new Rect();
          paramTextView.measure(0, 0);
          be.a(be.this, paramTextView.getMeasuredHeight());
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", new Object[] { Integer.valueOf(be.e(be.this)) });
          AppMethodBeat.o(99020);
        }
      });
    }
    AppMethodBeat.o(99041);
  }
  
  private void sa(boolean paramBoolean)
  {
    AppMethodBeat.i(99046);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.rmb);
    if (this.Ayz != null)
    {
      if (this.isSearchMode)
      {
        this.AyA.ai(this.Ayy, paramBoolean);
        AppMethodBeat.o(99046);
        return;
      }
      this.Ayz.j(this.rmb, this.Ayy, paramBoolean);
    }
    AppMethodBeat.o(99046);
  }
  
  public final void AM(long paramLong)
  {
    if (0L != this.AyE) {
      return;
    }
    this.AyE = paramLong;
    this.AyF = 0L;
  }
  
  public final void a(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99045);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (this.AyB != null) {
        this.AyB.egg();
      }
      AppMethodBeat.o(99045);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    this.list.clear();
    this.AeZ.clear();
    this.Afa.clear();
    this.Ayw.clear();
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
      this.AeZ.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      this.Afa.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      this.Ayw.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (this.dsB)
    {
      if (this.list.size() <= 1) {}
      for (i = 2147483647;; i = ((p)this.list.get(1)).field_head)
      {
        this.AyC = 0;
        j = 0;
        while (j < this.list.size())
        {
          if ((!this.dsB) || (j != 0))
          {
            if (i != ((p)this.list.get(j)).field_head) {
              break;
            }
            this.AyC = Math.max(this.AyC, ((p)this.list.get(j)).field_createTime);
          }
          j += 1;
        }
      }
    }
    if (this.list.isEmpty()) {}
    for (i = 2147483647;; i = ((p)this.list.get(0)).field_head) {
      break;
    }
    if ((this.list.isEmpty()) || ((this.dsB) && (this.list.size() == 1))) {
      this.AyC = 2147483647;
    }
    if (this.list.isEmpty()) {}
    for (i = 0;; i = ((p)this.list.get(this.list.size() - 1)).field_head)
    {
      this.AyD = 2147483647;
      j = this.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((p)this.list.get(j)).field_head))
      {
        this.AyD = Math.min(this.AyD, ((p)this.list.get(j)).field_createTime);
        j -= 1;
      }
    }
    if (this.list.isEmpty()) {
      this.AyD = 0;
    }
    this.Afc = paramInt1;
    this.Afb = paramInt2;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + this.AyC + " edTIme " + this.AyD);
    notifyDataSetChanged();
    AppMethodBeat.o(99045);
  }
  
  public final void edu()
  {
    AppMethodBeat.i(99048);
    sa(true);
    notifyDataSetChanged();
    AppMethodBeat.o(99048);
  }
  
  public final void egd()
  {
    this.AyG = true;
    if (this.isSearchMode) {
      this.AyA.AzB = true;
    }
  }
  
  public final void ege()
  {
    AppMethodBeat.i(99049);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((p)this.list.get(this.list.size() - 1)).field_snsId)
    {
      AN(l);
      AppMethodBeat.o(99049);
      return;
    }
  }
  
  public final int getCount()
  {
    return this.Afb;
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
    if ((this.dsB) && (paramInt == 0) && ((!this.isSearchMode) || ((this.isSearchMode) && (this.AyG))))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(99043);
      return 0;
    }
    if (this.AeZ.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(99043);
        return 0;
      }
      p localp = (p)getItem(i);
      if (localp.ebP().HUG.Gtw == 1)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(99043);
        return 0;
      }
      if (localp.ebP().HUG.Gtw == 15)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(99043);
        return 2;
      }
      if (localp.ebP().HUG.Gtw == 21)
      {
        AppMethodBeat.o(99043);
        return 3;
      }
      if ((localp.ebP().HUG.Gtw == 28) || (localp.ebP().HUG.Gtw == 29))
      {
        AppMethodBeat.o(99043);
        return 4;
      }
      if (localp.ebP().HUG.Gtw == 33)
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(i)));
    Object localObject1;
    int j;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
      {
        paramViewGroup = new d();
        paramView = z.jV(this.dtg).inflate(2131495576, null);
        paramViewGroup.AyQ = ((TextView)paramView.findViewById(2131304967));
        paramViewGroup.AyP = ((TextView)paramView.findViewById(2131305007));
        paramViewGroup.AyR = ((TextView)paramView.findViewById(2131305106));
        paramViewGroup.Azb = ((MaskImageView)paramView.findViewById(2131300977));
        paramViewGroup.Azc = ((QFadeImageView)paramView.findViewById(2131305641));
        paramViewGroup.Azd = ((MaskImageView)paramView.findViewById(2131300978));
        paramViewGroup.Aze = ((MaskImageView)paramView.findViewById(2131300979));
        paramViewGroup.Azf = ((MMNeat7extView)paramView.findViewById(2131298996));
        paramViewGroup.Azg = ((TextView)paramView.findViewById(2131307000));
        paramViewGroup.Azh = ((TextView)paramView.findViewById(2131307001));
        paramViewGroup.Azi = ((TextView)paramView.findViewById(2131307002));
        paramViewGroup.Azj = ((TextView)paramView.findViewById(2131300986));
        paramViewGroup.Azk = paramView.findViewById(2131299002);
        paramViewGroup.AyU = ((TextView)paramView.findViewById(2131296470));
        paramViewGroup.AyS = ((LinearLayout)paramView.findViewById(2131301423));
        paramViewGroup.AyT = ((ImageView)paramView.findViewById(2131301549));
        paramViewGroup.Afr = ((LinearLayout)paramView.findViewById(2131301456));
        paramViewGroup.Afs = paramView.findViewById(2131301422);
        paramViewGroup.Azc.setOnClickListener(this.Ayx.Afi);
        paramViewGroup.Azb.setOnClickListener(this.Ayx.Afi);
        paramViewGroup.Azd.setOnClickListener(this.Ayx.Afj);
        paramViewGroup.Aze.setOnClickListener(this.Ayx.Afk);
        paramViewGroup.Azb.setOnLongClickListener(this.Ayx.Azv);
        paramViewGroup.Azd.setOnLongClickListener(this.Ayx.Azv);
        paramViewGroup.Aze.setOnLongClickListener(this.Ayx.Azv);
        paramViewGroup.Azl = ((TextView)paramView.findViewById(2131306862));
        paramViewGroup.Azm = ((TextView)paramView.findViewById(2131306863));
        paramViewGroup.Azn = ((TextView)paramView.findViewById(2131306864));
        paramViewGroup.Azo = ((TextView)paramView.findViewById(2131306096));
        paramViewGroup.Azp = ((TextView)paramView.findViewById(2131306097));
        paramViewGroup.Azq = ((TextView)paramView.findViewById(2131306098));
        paramViewGroup.Azr = ((MaskLinearLayout)paramView.findViewById(2131305003));
        paramViewGroup.Azr.b(paramViewGroup.Azb);
        paramViewGroup.AyV = ((LinearLayout)paramView.findViewById(2131300304));
        paramViewGroup.AyW = ((TextView)paramView.findViewById(2131305022));
        paramViewGroup.AyW.setOnClickListener(new be.6(this));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        ah.dXB().eQ(paramViewGroup.Azb);
        ah.dXB().eQ(paramViewGroup.Azd);
        ah.dXB().eQ(paramViewGroup.Aze);
        i = -1;
        if (this.AeZ.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.AyR.setTag(Integer.valueOf(paramInt));
        paramViewGroup.Azr.settouchEnable(false);
        paramViewGroup.Azr.setBackgroundResource(0);
        paramViewGroup.Azr.setDescendantFocusability(131072);
        paramViewGroup.Azr.setClickable(false);
        paramViewGroup.Azb.settouchEnable(true);
        paramViewGroup.Azb.setClickable(true);
        paramViewGroup.Azb.setLongClickable(false);
        paramViewGroup.Azd.setLongClickable(false);
        paramViewGroup.Aze.setLongClickable(false);
        paramViewGroup.Azr.setOnClickListener(null);
        paramViewGroup.Azr.setOnLongClickListener(null);
        paramViewGroup.Azr.setLongClickable(false);
        if ((i < this.Afc) && (i != -1)) {
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
      al.aA(((p)localObject1).field_localPrivate, this.dsB);
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
      if (this.Afa.get(Integer.valueOf(paramInt)) != null) {}
      label1319:
      label2857:
      for (int k = ((Integer)this.Afa.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        Object localObject2 = (p)getItem(i);
        localObject1 = ((p)localObject2).ebP();
        long l;
        if (((this.dsB) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
        {
          if (aB(paramInt, ((p)localObject2).field_snsId))
          {
            l = ((p)localObject2).field_createTime;
            a(paramViewGroup.AyP, paramViewGroup.AyQ, l);
          }
          if (((TimeLineObject)localObject1).HUE != null)
          {
            if (!bu.isNullOrNil(((TimeLineObject)localObject1).HUE.jGd)) {
              break label1287;
            }
            localObject1 = ((TimeLineObject)localObject1).HUE.jfX;
            if ((localObject1 != null) && (!((String)localObject1).equals("")))
            {
              paramViewGroup.AyU.setText((CharSequence)localObject1);
              paramViewGroup.AyU.setVisibility(0);
            }
          }
          paramViewGroup.Afs.setVisibility(0);
        }
        else
        {
          if ((this.AyF == 0L) || (((p)localObject2).field_snsId != this.AyF)) {
            break label1300;
          }
          paramViewGroup.AyV.setVisibility(0);
          label1094:
          paramViewGroup.AyS.setVisibility(0);
          if ((!this.dsB) || (paramInt != 0) || ((this.isSearchMode) && ((!this.isSearchMode) || (!this.AyG)))) {
            break label1319;
          }
          paramViewGroup.Azc.setVisibility(0);
          paramViewGroup.Azc.setContentDescription(this.dtg.getString(2131764020));
          paramViewGroup.Azb.setVisibility(8);
          localObject2 = paramViewGroup.Azf;
          if (this.Afb != 1) {
            break label1312;
          }
        }
        for (localObject1 = this.dtg.getString(2131764063);; localObject1 = "")
        {
          ((MMNeat7extView)localObject2).aq((CharSequence)localObject1);
          paramViewGroup.Azf.setVisibility(0);
          paramViewGroup.Azk.setVisibility(0);
          paramViewGroup.Azj.setVisibility(8);
          ah.dXB().d(paramViewGroup.Azc, 2131100942, 2131234148, this.dtg.hashCode());
          localObject1 = new be.f.a();
          ((be.f.a)localObject1).dKr = -1;
          ((be.f.a)localObject1).position = -1;
          paramViewGroup.Azc.setTag(localObject1);
          AppMethodBeat.o(99038);
          return paramView;
          localObject1 = ((TimeLineObject)localObject1).HUE.jGd;
          break;
          paramViewGroup.AyV.setVisibility(8);
          break label1094;
        }
        a(paramViewGroup.AyR, j, ((p)localObject2).field_head);
        if (k > 0)
        {
          a(i, paramViewGroup.Azb, paramViewGroup.Azg, paramViewGroup.Azj, paramViewGroup.Azl, paramViewGroup.Azo, 1, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.e.zKO.G((p)getItem(i));
        }
        if (k >= 2)
        {
          a(i + 1, paramViewGroup.Azd, paramViewGroup.Azh, paramViewGroup.Azj, paramViewGroup.Azm, paramViewGroup.Azp, 2, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.e.zKO.G((p)getItem(i + 1));
        }
        if (k >= 3)
        {
          a(i + 2, paramViewGroup.Aze, paramViewGroup.Azi, paramViewGroup.Azj, paramViewGroup.Azn, paramViewGroup.Azq, 3, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.e.zKO.G((p)getItem(i + 2));
        }
        if (k == 1)
        {
          localObject1 = (p)getItem(i);
          if ((!bu.isNullOrNil(((p)localObject1).ebP().HUD)) && (((p)localObject1).field_type == 1))
          {
            paramViewGroup.Azr.setDescendantFocusability(393216);
            paramViewGroup.Azr.setClickable(true);
            paramViewGroup.Azb.setClickable(false);
            paramViewGroup.Azb.settouchEnable(false);
            paramViewGroup.Azr.setOnClickListener(this.Ayx.Afi);
            paramViewGroup.Azr.settouchEnable(true);
            i = ((p)localObject2).AdJ;
            localObject2 = new be.f.a();
            ((be.f.a)localObject2).dKr = i;
            if (this.Ayw.get(Integer.valueOf(paramInt)) == null) {
              break label1702;
            }
          }
        }
        for (((be.f.a)localObject2).position = ((Integer)this.Ayw.get(Integer.valueOf(paramInt))).intValue();; ((be.f.a)localObject2).position = 0)
        {
          if ((((p)localObject1).dXn()) && (((p)localObject1).ecq())) {
            paramViewGroup.Azr.setOnLongClickListener(this.Ayx.Azv);
          }
          paramViewGroup.Azr.setTag(localObject2);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(99038);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
          {
            paramViewGroup = new e();
            paramView = z.jV(this.dtg).inflate(2131495590, null);
            paramViewGroup.AyQ = ((TextView)paramView.findViewById(2131304967));
            paramViewGroup.AyP = ((TextView)paramView.findViewById(2131305007));
            paramViewGroup.AyR = ((TextView)paramView.findViewById(2131305106));
            paramViewGroup.Azb = ((MaskImageView)paramView.findViewById(2131300977));
            paramViewGroup.AyU = ((TextView)paramView.findViewById(2131296470));
            paramViewGroup.AyS = ((LinearLayout)paramView.findViewById(2131301423));
            paramViewGroup.AyT = ((ImageView)paramView.findViewById(2131301549));
            paramViewGroup.Afr = ((LinearLayout)paramView.findViewById(2131301456));
            paramViewGroup.Afs = paramView.findViewById(2131301422);
            paramViewGroup.Azb.setOnClickListener(this.Ayx.Azu);
            paramViewGroup.Azl = ((TextView)paramView.findViewById(2131306862));
            paramViewGroup.Azr = ((MaskLinearLayout)paramView.findViewById(2131305003));
            paramViewGroup.Azr.b(paramViewGroup.Azb);
            paramViewGroup.Azf = ((MMNeat7extView)paramView.findViewById(2131298996));
            paramViewGroup.Azk = paramView.findViewById(2131299002);
            paramViewGroup.AyV = ((LinearLayout)paramView.findViewById(2131300304));
            paramViewGroup.AyW = ((TextView)paramView.findViewById(2131305022));
            paramViewGroup.AyW.setOnClickListener(new be.5(this));
            paramView.setTag(paramViewGroup);
            ah.dXB().eQ(paramViewGroup.Azb);
            if (this.AeZ.get(Integer.valueOf(paramInt)) == null) {
              break label6317;
            }
          }
        }
        label2476:
        label6317:
        for (i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.AyR.setTag(Integer.valueOf(paramInt));
          paramViewGroup.Azr.settouchEnable(false);
          paramViewGroup.Azr.setBackgroundResource(0);
          paramViewGroup.Azr.setDescendantFocusability(131072);
          paramViewGroup.Azr.setClickable(false);
          paramViewGroup.Azb.settouchEnable(true);
          paramViewGroup.Azb.setClickable(true);
          paramViewGroup.Azr.setOnClickListener(null);
          if ((i >= this.Afc) || (i == -1))
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
            al.aA(((p)localObject1).field_localPrivate, this.dsB);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.Afa.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.Afa.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject2 = (p)getItem(i);
            Object localObject3 = ((p)localObject2).ebP();
            if (((this.dsB) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
            {
              if (aB(paramInt, ((p)localObject2).field_snsId))
              {
                l = ((p)localObject2).field_createTime;
                a(paramViewGroup.AyP, paramViewGroup.AyQ, l);
              }
              if (((TimeLineObject)localObject3).HUE != null)
              {
                if (!bu.isNullOrNil(((TimeLineObject)localObject3).HUE.jGd)) {
                  break label2832;
                }
                localObject1 = ((TimeLineObject)localObject3).HUE.jfX;
                if ((localObject1 != null) && (!((String)localObject1).equals("")))
                {
                  paramViewGroup.AyU.setText((CharSequence)localObject1);
                  paramViewGroup.AyU.setVisibility(0);
                }
              }
              paramViewGroup.Afs.setVisibility(0);
            }
            else
            {
              a(paramViewGroup.AyR, j, ((p)localObject2).field_head);
              if ((this.AyF == 0L) || (((p)localObject2).field_snsId != this.AyF)) {
                break label2845;
              }
              paramViewGroup.AyV.setVisibility(0);
              paramViewGroup.AyS.setVisibility(0);
              localObject1 = new bk(this.Ayv.tag);
              ((bk)localObject1).heF = ((p)localObject2).field_createTime;
              paramViewGroup.Azb.setVisibility(0);
              ah.dXB().a(((TimeLineObject)localObject3).HUG.Gtx, paramViewGroup.Azb, this.dtg.hashCode(), g.a.zxH, (bk)localObject1);
              if (al.aA(((p)localObject2).field_localPrivate, this.dsB))
              {
                paramViewGroup.Azl.setVisibility(0);
                paramViewGroup.Azl.setBackgroundResource(2131233596);
                localObject1 = this.Asc.BH(((p)localObject2).field_userName);
                if (localObject1 != null) {
                  ((c)localObject1).adG();
                }
              }
              localObject1 = (p)getItem(i);
              localObject3 = ((p)localObject1).ebP().HUD;
              if ((localObject3 != null) && (!((String)localObject3).equals("")))
              {
                paramViewGroup.Azk.setVisibility(0);
                paramViewGroup.Azf.setVisibility(0);
                paramViewGroup.Azf.aq(k.b(this.dtg, (CharSequence)localObject3, paramViewGroup.Azf.getTextSize()));
              }
              paramViewGroup.Azr.setDescendantFocusability(393216);
              paramViewGroup.Azr.setClickable(true);
              paramViewGroup.Azb.setClickable(false);
              paramViewGroup.Azb.settouchEnable(false);
              paramViewGroup.Azr.setOnClickListener(this.Ayx.Azu);
              paramViewGroup.Azr.settouchEnable(true);
              i = ((p)localObject2).AdJ;
              localObject2 = new be.f.a();
              ((be.f.a)localObject2).dKr = i;
              if (this.Ayw.get(Integer.valueOf(paramInt)) == null) {
                break label2857;
              }
            }
            for (((be.f.a)localObject2).position = ((Integer)this.Ayw.get(Integer.valueOf(paramInt))).intValue();; ((be.f.a)localObject2).position = 0)
            {
              paramViewGroup.Azr.setTag(localObject2);
              paramView.setDrawingCacheEnabled(false);
              com.tencent.mm.plugin.sns.j.e.zKO.G((p)localObject1);
              AppMethodBeat.o(99038);
              return paramView;
              localObject1 = ((TimeLineObject)localObject3).HUE.jGd;
              break;
              paramViewGroup.AyV.setVisibility(8);
              break label2476;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
              {
                paramViewGroup = new d();
                paramView = z.jV(this.dtg).inflate(2131495576, null);
                paramViewGroup.AyQ = ((TextView)paramView.findViewById(2131304967));
                paramViewGroup.AyP = ((TextView)paramView.findViewById(2131305007));
                paramViewGroup.AyR = ((TextView)paramView.findViewById(2131305106));
                paramViewGroup.Azb = ((MaskImageView)paramView.findViewById(2131300977));
                paramViewGroup.Azc = ((QFadeImageView)paramView.findViewById(2131305641));
                paramViewGroup.Azd = ((MaskImageView)paramView.findViewById(2131300978));
                paramViewGroup.Aze = ((MaskImageView)paramView.findViewById(2131300979));
                paramViewGroup.Azf = ((MMNeat7extView)paramView.findViewById(2131298996));
                paramViewGroup.Azg = ((TextView)paramView.findViewById(2131307000));
                paramViewGroup.Azh = ((TextView)paramView.findViewById(2131307001));
                paramViewGroup.Azi = ((TextView)paramView.findViewById(2131307002));
                paramViewGroup.Azj = ((TextView)paramView.findViewById(2131300986));
                paramViewGroup.Azk = paramView.findViewById(2131299002);
                paramViewGroup.AyU = ((TextView)paramView.findViewById(2131296470));
                paramViewGroup.AyS = ((LinearLayout)paramView.findViewById(2131301423));
                paramViewGroup.AyT = ((ImageView)paramView.findViewById(2131301549));
                paramViewGroup.Afr = ((LinearLayout)paramView.findViewById(2131301456));
                paramViewGroup.Afs = paramView.findViewById(2131301422);
                paramViewGroup.Azc.setOnClickListener(this.Ayx.Azt);
                paramViewGroup.Azb.setOnClickListener(this.Ayx.Azt);
                paramViewGroup.Azl = ((TextView)paramView.findViewById(2131306862));
                paramViewGroup.Azm = ((TextView)paramView.findViewById(2131306863));
                paramViewGroup.Azn = ((TextView)paramView.findViewById(2131306864));
                paramViewGroup.Azo = ((TextView)paramView.findViewById(2131306096));
                paramViewGroup.Azp = ((TextView)paramView.findViewById(2131306097));
                paramViewGroup.Azq = ((TextView)paramView.findViewById(2131306098));
                paramViewGroup.Azr = ((MaskLinearLayout)paramView.findViewById(2131305003));
                paramViewGroup.Azr.b(paramViewGroup.Azb);
                paramViewGroup.AyV = ((LinearLayout)paramView.findViewById(2131300304));
                paramViewGroup.AyW = ((TextView)paramView.findViewById(2131305022));
                paramViewGroup.AyW.setOnClickListener(new be.10(this));
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                ah.dXB().eQ(paramViewGroup.Azb);
                ah.dXB().eQ(paramViewGroup.Azd);
                ah.dXB().eQ(paramViewGroup.Aze);
                i = -1;
                if (this.AeZ.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.AyR.setTag(Integer.valueOf(paramInt));
                paramViewGroup.Azr.settouchEnable(false);
                paramViewGroup.Azr.setBackgroundResource(0);
                paramViewGroup.Azr.setDescendantFocusability(131072);
                paramViewGroup.Azr.setClickable(false);
                paramViewGroup.Azb.settouchEnable(true);
                paramViewGroup.Azb.setClickable(true);
                paramViewGroup.Azr.setOnClickListener(null);
                if ((i < this.Afc) && (i != -1)) {
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
              al.aA(((p)localObject1).field_localPrivate, this.dsB);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject2 = (p)getItem(i);
              localObject1 = ((p)localObject2).ebP();
              if (((this.dsB) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
              {
                if (aB(paramInt, ((p)localObject2).field_snsId))
                {
                  l = ((p)localObject2).field_createTime;
                  a(paramViewGroup.AyP, paramViewGroup.AyQ, l);
                }
                if (((TimeLineObject)localObject1).HUE != null)
                {
                  if (!bu.isNullOrNil(((TimeLineObject)localObject1).HUE.jGd)) {
                    break label3972;
                  }
                  localObject1 = ((TimeLineObject)localObject1).HUE.jfX;
                  if ((localObject1 != null) && (!((String)localObject1).equals("")))
                  {
                    paramViewGroup.AyU.setText((CharSequence)localObject1);
                    paramViewGroup.AyU.setVisibility(0);
                  }
                }
                paramViewGroup.Afs.setVisibility(0);
              }
              else
              {
                a(paramViewGroup.AyR, j, ((p)localObject2).field_head);
                if ((this.AyF == 0L) || (((p)localObject2).field_snsId != this.AyF)) {
                  break label3985;
                }
                paramViewGroup.AyV.setVisibility(0);
                label3800:
                paramViewGroup.AyS.setVisibility(0);
                if ((!this.dsB) || (paramInt != 0)) {
                  break label4004;
                }
                paramViewGroup.Azc.setVisibility(0);
                paramViewGroup.Azc.setContentDescription(this.dtg.getString(2131764020));
                paramViewGroup.Azb.setVisibility(8);
                localObject2 = paramViewGroup.Azf;
                if (this.Afb != 1) {
                  break label3997;
                }
              }
              for (localObject1 = this.dtg.getString(2131764063);; localObject1 = "")
              {
                ((MMNeat7extView)localObject2).aq((CharSequence)localObject1);
                paramViewGroup.Azf.setVisibility(0);
                paramViewGroup.Azk.setVisibility(0);
                paramViewGroup.Azj.setVisibility(8);
                ah.dXB().d(paramViewGroup.Azc, 2131100942, 2131234148, this.dtg.hashCode());
                localObject1 = new be.f.a();
                ((be.f.a)localObject1).dKr = -1;
                ((be.f.a)localObject1).position = -1;
                paramViewGroup.Azc.setTag(localObject1);
                AppMethodBeat.o(99038);
                return paramView;
                localObject1 = ((TimeLineObject)localObject1).HUE.jGd;
                break;
                paramViewGroup.AyV.setVisibility(8);
                break label3800;
              }
              a(i, paramViewGroup.Azb, paramViewGroup.Azg, paramViewGroup.Azj, paramViewGroup.Azl, paramViewGroup.Azo, 1, paramViewGroup, paramInt);
              localObject1 = (p)getItem(i);
              if ((!bu.isNullOrNil(((p)localObject1).ebP().HUD)) && (((p)localObject1).field_type == 1))
              {
                paramViewGroup.Azr.setDescendantFocusability(393216);
                paramViewGroup.Azr.setClickable(true);
                paramViewGroup.Azb.setClickable(false);
                paramViewGroup.Azb.settouchEnable(false);
                paramViewGroup.Azr.setOnClickListener(this.Ayx.Azt);
                paramViewGroup.Azr.settouchEnable(true);
                i = ((p)localObject2).AdJ;
                localObject2 = new be.f.a();
                ((be.f.a)localObject2).dKr = i;
                if (this.Ayw.get(Integer.valueOf(paramInt)) == null) {
                  break label4216;
                }
              }
              label4216:
              for (((be.f.a)localObject2).position = ((Integer)this.Ayw.get(Integer.valueOf(paramInt))).intValue();; ((be.f.a)localObject2).position = 0)
              {
                paramViewGroup.Azr.setTag(localObject2);
                com.tencent.mm.plugin.sns.j.e.zKO.G((p)localObject1);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 4) {
                if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof b)))
                {
                  localObject1 = new b();
                  localObject2 = z.jV(this.dtg).inflate(2131495575, null);
                  ((b)localObject1).AyO = ((View)localObject2).findViewById(2131298764);
                  ((b)localObject1).AyQ = ((TextView)((View)localObject2).findViewById(2131304967));
                  ((b)localObject1).AyP = ((TextView)((View)localObject2).findViewById(2131305007));
                  ((b)localObject1).AyR = ((TextView)((View)localObject2).findViewById(2131305106));
                  ((b)localObject1).AyU = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).Afs = ((View)localObject2).findViewById(2131301422);
                  ((b)localObject1).AyU = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).AyS = ((LinearLayout)((View)localObject2).findViewById(2131301423));
                  ((b)localObject1).AyT = ((ImageView)((View)localObject2).findViewById(2131301549));
                  ((b)localObject1).Afr = ((LinearLayout)((View)localObject2).findViewById(2131301456));
                  ((b)localObject1).ovu = ((MMNeat7extView)((View)localObject2).findViewById(2131299008));
                  ((b)localObject1).AyX = ((TagImageView)((View)localObject2).findViewById(2131300948));
                  ((b)localObject1).AfZ = ((ImageView)((View)localObject2).findViewById(2131305185));
                  ((b)localObject1).titleTv = ((TextView)((View)localObject2).findViewById(2131305950));
                  ((b)localObject1).AyZ = ((TextView)((View)localObject2).findViewById(2131304202));
                  ((b)localObject1).AyO.setOnClickListener(this.Ayx.Azs);
                  ((b)localObject1).Aza = ((View)localObject2).findViewById(2131302207);
                  ((b)localObject1).AyY = ((TextView)((View)localObject2).findViewById(2131298762));
                  ((b)localObject1).AyV = ((LinearLayout)((View)localObject2).findViewById(2131300304));
                  ((b)localObject1).AyW = ((TextView)((View)localObject2).findViewById(2131305022));
                  ((b)localObject1).AyW.setOnClickListener(new be.8(this));
                  ((View)localObject2).setTag(localObject1);
                  r.b(((b)localObject1).AyX, this.dtg);
                  ((b)localObject1).AyR.setTag(Integer.valueOf(paramInt));
                  if (this.AeZ.get(Integer.valueOf(paramInt)) == null) {
                    break label6299;
                  }
                }
              }
              for (i = ((Integer)this.AeZ.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                ((b)localObject1).init();
                if ((i >= this.Afc) || (i == -1))
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
                  al.aA(paramView.field_localPrivate, this.dsB);
                }
                for (;;)
                {
                  ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  ((View)localObject2).setVisibility(0);
                  localObject3 = (p)getItem(i);
                  TimeLineObject localTimeLineObject = ((p)localObject3).ebP();
                  Object localObject4;
                  if (((this.dsB) && (paramInt == 0)) || (j == -1) || (((p)localObject3).field_head != j))
                  {
                    if (aB(paramInt, ((p)localObject3).field_snsId))
                    {
                      l = ((p)localObject3).field_createTime;
                      a(((b)localObject1).AyP, ((b)localObject1).AyQ, l);
                    }
                    if (localTimeLineObject.HUE != null)
                    {
                      if (!bu.isNullOrNil(localTimeLineObject.HUE.jGd)) {
                        break label5213;
                      }
                      paramView = localTimeLineObject.HUE.jfX;
                      if ((paramView != null) && (!paramView.equals("")))
                      {
                        ((b)localObject1).AyU.setText(paramView);
                        ((b)localObject1).AyU.setVisibility(0);
                      }
                    }
                    ((b)localObject1).Afs.setVisibility(0);
                  }
                  else
                  {
                    a(((b)localObject1).AyR, j, ((p)localObject3).field_head);
                    if ((this.AyF == 0L) || (((p)localObject3).field_snsId != this.AyF)) {
                      break label5225;
                    }
                    ((b)localObject1).AyV.setVisibility(0);
                    localObject4 = new be.f.a();
                    ((be.f.a)localObject4).dKr = ((p)localObject3).AdJ;
                    if (this.Ayw.get(Integer.valueOf(paramInt)) == null) {
                      break label5238;
                    }
                    ((be.f.a)localObject4).position = ((Integer)this.Ayw.get(Integer.valueOf(paramInt))).intValue();
                    label5060:
                    ((b)localObject1).AyO.setTag(localObject4);
                    if (bu.isNullOrNil(localTimeLineObject.HUD)) {
                      break label5247;
                    }
                    ((b)localObject1).ovu.setVisibility(0);
                    ((b)localObject1).ovu.aq(k.b(this.dtg, localTimeLineObject.HUD, ((b)localObject1).ovu.getTextSize()));
                  }
                  bk localbk;
                  for (;;)
                  {
                    ((b)localObject1).AyS.setVisibility(0);
                    ((b)localObject1).ovu.getWrappedTextView().setSingleLine(true);
                    ((b)localObject1).Aza.setVisibility(0);
                    localbk = new bk(this.Ayv.tag);
                    localbk.heF = ((p)localObject3).field_createTime;
                    if ((localTimeLineObject.HUG.GtB != null) || (localTimeLineObject.HUG.GtC != null)) {
                      break label5260;
                    }
                    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                    AppMethodBeat.o(99038);
                    return localObject2;
                    label5213:
                    paramView = localTimeLineObject.HUE.jGd;
                    break;
                    label5225:
                    ((b)localObject1).AyV.setVisibility(8);
                    break label5001;
                    label5238:
                    ((be.f.a)localObject4).position = 0;
                    break label5060;
                    label5247:
                    ((b)localObject1).ovu.setVisibility(8);
                  }
                  ((b)localObject1).titleTv.setTextColor(this.dtg.getResources().getColor(2131100711));
                  if (efq())
                  {
                    paramView = bh.aCj(localTimeLineObject.HUG.Url);
                    if (localTimeLineObject.HUG.GtB == null) {
                      break label5715;
                    }
                    paramView = this.dtg.getString(2131763973, new Object[] { localTimeLineObject.HUG.GtB.nickname });
                    if (localTimeLineObject.HUG.GtB.GIy != 4) {
                      break label5668;
                    }
                    paramView = this.dtg.getString(2131767187, new Object[] { localTimeLineObject.HUG.GtB.nickname });
                    if (bu.isNullOrNil(localTimeLineObject.HUG.GtB.nickname)) {
                      paramView = this.dtg.getResources().getString(2131759151);
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
                      if (((b)localObject1).AyX != null)
                      {
                        ((b)localObject1).AyX.setTag(localObject4);
                        ((b)localObject1).AyX.setOnClickListener(this.Ayx.Azs);
                      }
                      ((b)localObject1).AfZ.setVisibility(8);
                      if (localTimeLineObject.HUG.GtB != null) {
                        if (localTimeLineObject.HUG.GtB.GIy == 1)
                        {
                          ((b)localObject1).AyX.setVisibility(8);
                          ((b)localObject1).AyY.setVisibility(0);
                          ((b)localObject1).AyY.setText(localTimeLineObject.HUG.GtB.desc);
                          label5560:
                          if (bu.isNullOrNil(paramViewGroup)) {
                            break label6208;
                          }
                          ((b)localObject1).AyZ.setVisibility(0);
                          ((b)localObject1).AyZ.setText(paramViewGroup);
                          label5585:
                          if (bu.isNullOrNil(paramView)) {
                            break label6233;
                          }
                          if (((b)localObject1).AyZ.getVisibility() != 8) {
                            break label6221;
                          }
                          ((b)localObject1).titleTv.setMaxLines(2);
                          label5614:
                          ((b)localObject1).titleTv.setText(k.c(this.dtg, paramView));
                          ((b)localObject1).titleTv.setVisibility(0);
                        }
                      }
                      for (;;)
                      {
                        com.tencent.mm.plugin.sns.j.e.zKO.G((p)localObject3);
                        ((View)localObject2).setDrawingCacheEnabled(false);
                        AppMethodBeat.o(99038);
                        return localObject2;
                        paramView = "";
                        break;
                        if (localTimeLineObject.HUG.GtB.GIy != 2) {
                          break label5383;
                        }
                        paramView = this.dtg.getString(2131767186, new Object[] { localTimeLineObject.HUG.GtB.nickname });
                        break label5383;
                        label5715:
                        if (localTimeLineObject.HUG.GtC == null) {
                          break label6285;
                        }
                        if (localTimeLineObject.HUG.GtC.sXu == 1) {}
                        for (paramView = "#" + localTimeLineObject.HUG.GtC.dBe;; paramView = localTimeLineObject.HUG.GtC.dBe)
                        {
                          paramViewGroup = localTimeLineObject.HUG.GtC.desc;
                          break;
                        }
                        if (!localTimeLineObject.HUG.GtB.mediaList.isEmpty())
                        {
                          ((b)localObject1).AyX.setVisibility(0);
                          localObject4 = new bzh();
                          ((bzh)localObject4).Url = ((arx)localTimeLineObject.HUG.GtB.mediaList.get(0)).thumbUrl;
                          ((bzh)localObject4).Hmj = ((arx)localTimeLineObject.HUG.GtB.mediaList.get(0)).thumbUrl;
                          ((bzh)localObject4).nJA = 2;
                          ((bzh)localObject4).Hmk = 1;
                          ((bzh)localObject4).Hmm = new bzj();
                          ((bzh)localObject4).GXH = 1;
                          ((bzh)localObject4).Hmm.Hna = ((arx)localTimeLineObject.HUG.GtB.mediaList.get(0)).width;
                          ((bzh)localObject4).Hmm.Hnb = ((arx)localTimeLineObject.HUG.GtB.mediaList.get(0)).height;
                          ((bzh)localObject4).Id = ((p)localObject3).getSnsId();
                          ah.dXB().a((bzh)localObject4, ((b)localObject1).AyX, this.dtg.hashCode(), g.a.zxH, localbk);
                        }
                        if (localTimeLineObject.HUG.GtB.GIy != 4) {
                          break label5560;
                        }
                        ((b)localObject1).AfZ.setVisibility(0);
                        ((b)localObject1).AfZ.setImageDrawable(((b)localObject1).AfZ.getContext().getResources().getDrawable(2131691166));
                        break label5560;
                        if (localTimeLineObject.HUG.GtC == null) {
                          break label5560;
                        }
                        ((b)localObject1).AyX.setVisibility(0);
                        localObject4 = new bzh();
                        ((bzh)localObject4).Url = localTimeLineObject.HUG.GtC.iconUrl;
                        ((bzh)localObject4).Hmj = localTimeLineObject.HUG.GtC.iconUrl;
                        ((bzh)localObject4).nJA = 2;
                        ((bzh)localObject4).Hmk = 1;
                        ((bzh)localObject4).Hmm = new bzj();
                        ((bzh)localObject4).GXH = 1;
                        ((bzh)localObject4).Hmm.Hna = 0.0F;
                        ((bzh)localObject4).Hmm.Hnb = 0.0F;
                        ((bzh)localObject4).Id = ((p)localObject3).getSnsId();
                        ah.dXB().a((bzh)localObject4, ((b)localObject1).AyX, this.dtg.hashCode(), g.a.zxH, localbk);
                        break label5560;
                        label6208:
                        ((b)localObject1).AyZ.setVisibility(8);
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
  
  public final ArrayList<com.tencent.mm.plugin.sns.i.b> hR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99052);
    ArrayList localArrayList = new ArrayList();
    this.AyJ = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      p localp = (p)this.list.get(paramInt2);
      int j = localp.AdJ;
      if ((localp.ebP() != null) && (localp.ebP().HUG != null) && (localp.ebP().HUG.Gtx.size() != 0) && ((localp.ebP().HUG.Gtw == 1) || (localp.ebP().HUG.Gtw == 15)))
      {
        if (j == paramInt1) {
          this.AyJ = localArrayList.size();
        }
        Iterator localIterator = localp.ebP().HUG.Gtx.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          bzh localbzh = (bzh)localIterator.next();
          com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
          localb.dKe = localbzh;
          localb.parentId = x.bo("sns_table_", j);
          localb.icw = localp.field_createTime;
          localb.zHI = i;
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
    LinearLayout Afr;
    View Afs;
    View AyO;
    TextView AyP;
    TextView AyQ;
    TextView AyR;
    LinearLayout AyS;
    ImageView AyT;
    TextView AyU;
    LinearLayout AyV;
    TextView AyW;
    
    a() {}
    
    public void init()
    {
      AppMethodBeat.i(99026);
      this.AyP.setVisibility(8);
      this.AyQ.setVisibility(8);
      this.AyR.setVisibility(8);
      this.AyS.setVisibility(4);
      this.AyT.setVisibility(4);
      this.Afs.setVisibility(8);
      this.AyU.setVisibility(8);
      this.AyV.setVisibility(8);
      AppMethodBeat.o(99026);
    }
  }
  
  final class b
    extends be.a
  {
    ImageView AfZ;
    TagImageView AyX;
    TextView AyY;
    TextView AyZ;
    View Aza;
    MMNeat7extView ovu;
    TextView titleTv;
    
    b()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99027);
      super.init();
      this.ovu.setVisibility(8);
      this.AyX.setVisibility(8);
      if (this.AyY != null) {
        this.AyY.setVisibility(8);
      }
      this.AfZ.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.AyZ.setVisibility(8);
      AppMethodBeat.o(99027);
    }
  }
  
  public static abstract interface c
  {
    public abstract void egg();
  }
  
  final class d
    extends be.a
  {
    MaskImageView Azb;
    QFadeImageView Azc;
    QFadeImageView Azd;
    QFadeImageView Aze;
    MMNeat7extView Azf;
    TextView Azg;
    TextView Azh;
    TextView Azi;
    TextView Azj;
    View Azk;
    TextView Azl;
    TextView Azm;
    TextView Azn;
    TextView Azo;
    TextView Azp;
    TextView Azq;
    MaskLinearLayout Azr;
    
    d()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99028);
      super.init();
      this.Azb.setVisibility(8);
      this.Azd.setVisibility(8);
      this.Aze.setVisibility(8);
      this.Azf.setVisibility(8);
      this.Azg.setVisibility(8);
      this.Azh.setVisibility(8);
      this.Azi.setVisibility(8);
      this.Azj.setVisibility(8);
      this.Azk.setVisibility(8);
      this.Azc.setVisibility(8);
      this.Azl.setVisibility(8);
      this.Azm.setVisibility(8);
      this.Azn.setVisibility(8);
      this.Azo.setVisibility(8);
      this.Azp.setVisibility(8);
      this.Azq.setVisibility(8);
      if (com.tencent.mm.cb.a.ef(be.f(be.this)) > 1.0F) {
        this.Azf.setMaxLines(2);
      }
      AppMethodBeat.o(99028);
    }
  }
  
  final class e
    extends be.a
  {
    MaskImageView Azb;
    MMNeat7extView Azf;
    View Azk;
    TextView Azl;
    MaskLinearLayout Azr;
    
    e()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99029);
      super.init();
      this.Azb.setVisibility(8);
      this.Azf.setVisibility(8);
      this.Azl.setVisibility(8);
      this.Azk.setVisibility(8);
      if (com.tencent.mm.cb.a.ef(be.f(be.this)) > 1.0F) {
        this.Azf.setMaxLines(2);
      }
      AppMethodBeat.o(99029);
    }
  }
  
  static abstract class f
  {
    View.OnClickListener Afi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99030);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99030);
          return;
        }
        be.f.this.Azw = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Azw.dKr;
        int j = be.f.this.Azw.position;
        be.f.this.hS(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99030);
      }
    };
    View.OnClickListener Afj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99031);
          return;
        }
        be.f.this.Azw = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Azw.dKr;
        int j = be.f.this.Azw.position;
        be.f.this.hS(i, j + 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99031);
      }
    };
    View.OnClickListener Afk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99032);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99032);
          return;
        }
        be.f.this.Azw = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Azw.dKr;
        int j = be.f.this.Azw.position;
        be.f.this.hS(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99032);
      }
    };
    View.OnClickListener Azs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99033);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "sign click");
        be.f.this.Azw = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Azw.dKr;
        int j = be.f.this.Azw.position;
        be.f.this.hT(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99033);
      }
    };
    View.OnClickListener Azt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99034);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "sign click");
        be.f.this.Azw = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Azw.dKr;
        be.f.this.RT(i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99034);
      }
    };
    View.OnClickListener Azu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99035);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "snssight click");
        be.f.this.Azw = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Azw.dKr;
        int j = be.f.this.Azw.position;
        be.f.this.hT(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99035);
      }
    };
    View.OnLongClickListener Azv = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(99036);
          return true;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
        be.f.this.Azw = ((be.f.a)paramAnonymousView.getTag());
        int i = be.f.this.Azw.dKr;
        int j = be.f.this.Azw.position;
        be.f.this.hU(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(99036);
        return true;
      }
    };
    public a Azw = new a();
    
    public abstract void RT(int paramInt);
    
    public abstract void hS(int paramInt1, int paramInt2);
    
    public abstract void hT(int paramInt1, int paramInt2);
    
    public abstract void hU(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public int dKr;
      public int position;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be
 * JD-Core Version:    0.7.0.1
 */