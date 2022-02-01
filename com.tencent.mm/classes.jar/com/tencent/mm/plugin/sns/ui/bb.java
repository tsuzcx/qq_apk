package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.f.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.e.i;
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
public final class bb
  extends BaseAdapter
{
  private String country;
  private boolean dfZ;
  private Activity dgE;
  boolean isSearchMode;
  List<p> list;
  String qui;
  private boolean sWJ;
  private String tWM;
  private String userName;
  long xSD;
  String yEq;
  private bj yJv;
  private bf yPN;
  private Map<Integer, Integer> yPO;
  private bb.f yPP;
  boolean yPQ;
  bc yPR;
  bd yPS;
  private c yPT;
  int yPU;
  int yPV;
  private long yPW;
  private long yPX;
  boolean yPY;
  private int yPZ;
  private int yQa;
  int yQb;
  protected View.OnClickListener yQc;
  Map<Integer, Integer> ywG;
  private Map<Integer, Integer> ywH;
  private int ywI;
  private int ywJ;
  
  public bb(Activity paramActivity, bb.f paramf, String paramString, final c paramc)
  {
    AppMethodBeat.i(99037);
    this.userName = "";
    this.list = new ArrayList();
    this.ywG = new HashMap();
    this.ywH = new HashMap();
    this.yPO = new HashMap();
    this.ywI = 0;
    this.ywJ = 0;
    this.dfZ = false;
    this.yEq = "";
    this.yPQ = false;
    this.sWJ = false;
    this.xSD = 0L;
    this.qui = "";
    this.yJv = null;
    this.tWM = "";
    this.yPU = 2147483647;
    this.yPV = 0;
    this.yPW = 0L;
    this.yPX = 0L;
    this.isSearchMode = false;
    this.yPY = false;
    this.yPZ = 0;
    this.yQa = 0;
    this.yQb = 0;
    this.yQc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163121);
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
          if (bb.avK(paramAnonymousView.Id)) {
            break label121;
          }
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10090, "1,0");
          if ((!com.tencent.mm.r.a.ci(bb.f(bb.this))) && (!com.tencent.mm.r.a.cf(bb.f(bb.this))) && (!com.tencent.mm.r.a.ck(bb.f(bb.this))))
          {
            paramAnonymousView = com.tencent.mm.ay.h.a(af.getAccPath(), paramAnonymousView, 8);
            paramAnonymousView.hOk = bb.g(bb.this);
            com.tencent.mm.ay.a.c(paramAnonymousView);
          }
        }
        for (;;)
        {
          bb.this.notifyDataSetChanged();
          AppMethodBeat.o(163121);
          return;
          label121:
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10231, "1");
          com.tencent.mm.ay.a.aGt();
        }
      }
    };
    this.userName = paramString;
    this.dgE = paramActivity;
    this.yPP = paramf;
    this.yPT = paramc;
    this.yJv = af.dHF();
    paramf = ab.f(this.dgE.getSharedPreferences(ai.eUX(), 0));
    ac.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(paramf)));
    paramActivity = paramf;
    if (!paramf.equals("zh_CN"))
    {
      paramActivity = paramf;
      if (!paramf.equals("en"))
      {
        if (!paramf.equals("zh_TW")) {
          break label436;
        }
        paramActivity = paramf;
      }
    }
    this.tWM = paramActivity;
    this.country = ab.f(this.dgE.getSharedPreferences(ai.eUX(), 0));
    g.agS();
    paramActivity = (String)g.agR().agA().get(2, null);
    if (this.userName.equals(paramActivity)) {
      this.dfZ = true;
    }
    ac.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.dfZ) {
      this.yPN = bf.fbm();
    }
    for (;;)
    {
      this.yPR = new bc(new bc.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99016);
          if (!bb.a(bb.this))
          {
            ac.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bb.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            paramAnonymousList = bb.this;
            if (!bb.b(bb.this).isEmpty()) {
              break label77;
            }
          }
          label77:
          for (long l = 0L;; l = ((p)bb.b(bb.this).get(bb.b(bb.this).size() - 1)).field_snsId)
          {
            bb.a(paramAnonymousList, com.tencent.mm.plugin.sns.data.q.wX(l));
            AppMethodBeat.o(99016);
            return;
          }
        }
        
        public final void dQi()
        {
          AppMethodBeat.i(99017);
          if (!bb.a(bb.this))
          {
            bb.c(bb.this);
            bb.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.dQj();
            }
          }
          AppMethodBeat.o(99017);
        }
      }, paramString, this.dfZ);
      this.yPS = new bd(new bc.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99018);
          if (bb.a(bb.this))
          {
            ac.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bb.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            bb.d(bb.this);
          }
          AppMethodBeat.o(99018);
        }
        
        public final void dQi()
        {
          AppMethodBeat.i(99019);
          if (bb.a(bb.this))
          {
            bb.c(bb.this);
            bb.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.dQj();
            }
          }
          AppMethodBeat.o(99019);
        }
      }, this.dfZ);
      xR(0L);
      rp(false);
      AppMethodBeat.o(99037);
      return;
      label436:
      if (paramf.equals("zh_HK"))
      {
        paramActivity = "zh_TW";
        break;
      }
      paramActivity = "en";
      break;
      g.agS();
      paramActivity = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
      if ((paramActivity != null) && (com.tencent.mm.n.b.ln(paramActivity.field_type))) {
        this.yPN = bf.fbl();
      } else {
        this.yPN = bf.fbn();
      }
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, d paramd, int paramInt3)
  {
    AppMethodBeat.i(99044);
    p localp = (p)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localp.dLV();
    SnsObject localSnsObject = aj.t(localp);
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
    if ((this.dfZ) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localp.field_userName)))
    {
      paramTextView3.setBackgroundResource(2131233602);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (aj.as(localp.field_localPrivate, this.dfZ))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233596);
        localObject = this.yJv.aNt(localp.field_userName);
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
      paramInt1 = localp.yvp;
      paramTextView1 = new f.a();
      paramTextView1.dwR = paramInt1;
      if (this.yPO.get(Integer.valueOf(paramInt3)) == null) {
        break label677;
      }
      paramTextView1.position = ((Integer)this.yPO.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new bf(this.yPN.tag);
      paramTextView1.gIh = localp.field_createTime;
      if (localTimeLineObject.FQo.Ety != 1) {
        break label685;
      }
      paramQFadeImageView.setVisibility(0);
      af.dHO().a(localTimeLineObject.FQo.Etz, paramQFadeImageView, this.dgE.hashCode(), f.a.xQX, paramTextView1);
      label367:
      if ((localp.dHA()) && (localp.dMw()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233594);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.FQo.Etz == null) || (localTimeLineObject.FQo.Etz.size() <= 1)) {
          break label808;
        }
        paramd.yQC.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.FQo.Etz.size();
        paramTextView2.setText(this.dgE.getResources().getQuantityString(2131623966, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.FQl;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        paramd.yQC.setVisibility(0);
        paramd.yQx.setVisibility(0);
        paramd.yQx.ar(com.tencent.mm.pluginsdk.ui.span.k.b(this.dgE, paramQFadeImageView, paramd.yQx.getTextSize()));
      }
      AppMethodBeat.o(99044);
      return;
      label559:
      localObject = ((com.tencent.mm.n.b)localObject).aaS();
      break;
      if (!aj.as(localp.field_localPrivate, this.dfZ)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(2131233596);
      localObject = this.yJv.aNt(localp.field_userName);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((com.tencent.mm.n.b)localObject).aaS())
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
      if (localTimeLineObject.FQo.Ety == 2)
      {
        paramTextView4.setText(bs.bG(localTimeLineObject.FQo.Desc, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.FQo.Ety != 21) {
        break label367;
      }
      localp.dMn();
      boolean bool = true;
      if (this.dfZ) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        af.dHO().a(localTimeLineObject.FQo.Etz, paramQFadeImageView, this.dgE.hashCode(), f.a.xQX, paramTextView1, bool);
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
    ac.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (this.isSearchMode)
    {
      if ((i != 0) && (paramInt2 != i))
      {
        eU(paramTextView);
        paramTextView.setText(String.format(this.dgE.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        p(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (i == 0)
    {
      if (bg.getYear() != paramInt2)
      {
        eU(paramTextView);
        paramTextView.setText(String.format(this.dgE.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        p(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (paramInt2 != i)
    {
      eU(paramTextView);
      paramTextView.setText(String.format(this.dgE.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      p(paramTextView);
    }
    AppMethodBeat.o(99040);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(99039);
    Object localObject = this.dgE;
    if (!this.tWM.equals("en")) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = (String)bg.a((Context)localObject, 1000L * paramLong, bool);
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
      localObject[0] = bg.D(this.dgE, localObject[0], this.tWM);
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
  
  private boolean au(int paramInt, long paramLong)
  {
    return (!this.isSearchMode) || ((paramInt == 0) && (this.xSD == paramLong)) || (paramInt > 0) || (this.yPY);
  }
  
  protected static boolean avK(String paramString)
  {
    AppMethodBeat.i(99054);
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
    if ((localf != null) && (com.tencent.mm.ay.a.e(localf)) && (paramString.equals(localf.hNS)) && (com.tencent.mm.ay.a.aGv()))
    {
      AppMethodBeat.o(99054);
      return true;
    }
    AppMethodBeat.o(99054);
    return false;
  }
  
  private static boolean dPs()
  {
    AppMethodBeat.i(163123);
    if ((am.a.dIw() & 0x1) <= 0)
    {
      AppMethodBeat.o(163123);
      return true;
    }
    AppMethodBeat.o(163123);
    return false;
  }
  
  private void eU(View paramView)
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
      localLayoutParams.topMargin = this.dgE.getResources().getDimensionPixelSize(2131166851);
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
      localView = z.jD(this.dgE).inflate(2131495575, null);
      localb.yQg = localView.findViewById(2131298764);
      localb.yQi = ((TextView)localView.findViewById(2131304967));
      localb.yQh = ((TextView)localView.findViewById(2131305007));
      localb.yQj = ((TextView)localView.findViewById(2131305106));
      localb.yQm = ((TextView)localView.findViewById(2131296470));
      localb.ywZ = localView.findViewById(2131301422);
      localb.yQm = ((TextView)localView.findViewById(2131296470));
      localb.yQk = ((LinearLayout)localView.findViewById(2131301423));
      localb.yQl = ((ImageView)localView.findViewById(2131301549));
      localb.ywY = ((LinearLayout)localView.findViewById(2131301456));
      localb.nMW = ((MMNeat7extView)localView.findViewById(2131299008));
      localb.yQp = ((TagImageView)localView.findViewById(2131300948));
      localb.yxG = ((ImageView)localView.findViewById(2131305185));
      localb.titleTv = ((TextView)localView.findViewById(2131305950));
      localb.yQr = ((TextView)localView.findViewById(2131304202));
      localb.yQg.setOnClickListener(this.yPP.yQK);
      localb.yQs = localView.findViewById(2131302207);
      localb.yQn = ((LinearLayout)localView.findViewById(2131300304));
      localb.yQo = ((TextView)localView.findViewById(2131305022));
      localb.yQo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99023);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("enter_scene", e.i.Hho);
          d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(99023);
        }
      });
      localView.setTag(localb);
      com.tencent.mm.plugin.sns.data.q.b(localb.yQp, this.dgE);
      localb.yQj.setTag(Integer.valueOf(paramInt));
      if (this.ywG.get(Integer.valueOf(paramInt)) == null) {
        break label1976;
      }
    }
    label790:
    label1049:
    label1062:
    label1070:
    label1463:
    label1976:
    for (int i = ((Integer)this.ywG.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.ywJ) || (i == -1))
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
        aj.as(paramView.field_localPrivate, this.dfZ);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.ywH.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.ywH.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject1 = (p)getItem(i);
        TimeLineObject localTimeLineObject = ((p)localObject1).dLV();
        label846:
        Object localObject2;
        if (((this.dfZ) && (paramInt == 0)) || (j == -1) || (((p)localObject1).field_head != j))
        {
          if (au(paramInt, ((p)localObject1).field_snsId))
          {
            long l = ((p)localObject1).field_createTime;
            a(localb.yQh, localb.yQi, l);
          }
          if (localTimeLineObject.FQm != null)
          {
            if (!bs.isNullOrNil(localTimeLineObject.FQm.gPy)) {
              break label1037;
            }
            paramView = localTimeLineObject.FQm.iJV;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.yQm.setText(paramView);
              localb.yQm.setVisibility(0);
            }
          }
          localb.ywZ.setVisibility(0);
        }
        else
        {
          a(localb.yQj, j, ((p)localObject1).field_head);
          if ((this.yPX == 0L) || (((p)localObject1).field_snsId != this.yPX)) {
            break label1049;
          }
          localb.yQn.setVisibility(0);
          paramView = new f.a();
          paramView.dwR = ((p)localObject1).yvp;
          if (this.yPO.get(Integer.valueOf(paramInt)) == null) {
            break label1062;
          }
          paramView.position = ((Integer)this.yPO.get(Integer.valueOf(paramInt))).intValue();
          localb.yQg.setTag(paramView);
          if (bs.isNullOrNil(localTimeLineObject.FQl)) {
            break label1070;
          }
          localb.nMW.setVisibility(0);
          localb.nMW.ar(com.tencent.mm.pluginsdk.ui.span.k.b(this.dgE, localTimeLineObject.FQl, localb.nMW.getTextSize()));
          localb.yQk.setVisibility(0);
          localb.nMW.setMaxLines(1);
          localb.nMW.getWrappedTextView().setSingleLine(true);
          localb.yQs.setVisibility(0);
          paramInt = localTimeLineObject.FQo.Ety;
          localObject2 = new bf(this.yPN.tag);
          ((bf)localObject2).gIh = ((p)localObject1).field_createTime;
          if (paramInt != 2) {
            break label1083;
          }
          localb.nMW.setVisibility(0);
          localb.nMW.getWrappedTextView().setSingleLine(false);
          localb.nMW.setMaxLines(2);
          localb.yQs.setVisibility(8);
        }
        label1083:
        btz localbtz;
        for (;;)
        {
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(163122);
          return localView;
          paramView = localTimeLineObject.FQm.gPy;
          break;
          localb.yQn.setVisibility(8);
          break label790;
          paramView.position = 0;
          break label846;
          localb.nMW.setVisibility(8);
          break label903;
          if (paramInt != 4) {
            break label1424;
          }
          if (!localTimeLineObject.FQo.Etz.isEmpty())
          {
            localb.yQp.setVisibility(0);
            localb.yxG.setVisibility(0);
            localb.yQs.setVisibility(0);
            localb.titleTv.setMaxLines(1);
            localb.titleTv.setTextColor(this.dgE.getResources().getColor(2131100914));
            localbtz = (btz)localTimeLineObject.FQo.Etz.get(0);
            af.dHO().a(localbtz, localb.yQp, 2131689564, this.dgE.hashCode(), f.a.xQX, (bf)localObject2);
            localb.yxG.setPressed(false);
            if (avK(localTimeLineObject.Id))
            {
              localb.yxG.setImageResource(2131233393);
              label1235:
              localb.yQp.setTag(localTimeLineObject);
              localb.yQp.setOnClickListener(this.yQc);
              localbtz.dwR = ((p)localObject1).yvp;
              localb.yQs.setTag(localTimeLineObject);
              localObject1 = localbtz.Desc;
              if (bs.isNullOrNil((String)localObject1)) {
                break label1386;
              }
              localb.yQr.setVisibility(0);
              localb.yQr.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = localbtz.Title;
              if (bs.isNullOrNil((String)localObject1)) {
                break label1398;
              }
              localb.titleTv.setVisibility(0);
              localb.titleTv.setTag(paramView);
              localb.titleTv.setOnTouchListener(new ad());
              localb.titleTv.setText((CharSequence)localObject1);
              break;
              localb.yxG.setImageResource(2131233395);
              break label1235;
              label1386:
              localb.yQr.setVisibility(4);
            }
            label1398:
            localb.titleTv.setVisibility(8);
          }
          else
          {
            localb.yQs.setVisibility(8);
          }
        }
        localb.titleTv.setTextColor(this.dgE.getResources().getColor(2131099732));
        if (dPs())
        {
          paramView = be.avL(localTimeLineObject.FQo.Url);
          localObject1 = localTimeLineObject.FQo.Title;
          if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
            break label1967;
          }
          localObject1 = ((String)localObject1).substring(0, 40) + "...";
        }
        for (;;)
        {
          if (localb.yQp != null) {
            localb.yQp.setOnClickListener(null);
          }
          localb.yxG.setVisibility(8);
          if (!localTimeLineObject.FQo.Etz.isEmpty())
          {
            localb.yQp.setVisibility(0);
            localbtz = (btz)localTimeLineObject.FQo.Etz.get(0);
            if (localTimeLineObject.FQo.Ety == 5)
            {
              paramView = be.avL(localbtz.Url);
              localObject1 = localbtz.Title;
              localb.yxG.setVisibility(0);
              af.dHO().a(localbtz, localb.yQp, 2131689581, this.dgE.hashCode(), f.a.xQX, (bf)localObject2);
              label1649:
              localObject2 = paramView;
              if (localTimeLineObject.FQo.EtC != null)
              {
                localObject2 = paramView;
                if (localTimeLineObject.FQo.EtC.hhb == 1) {
                  localObject2 = ai.getContext().getString(2131761345);
                }
              }
              if (bs.isNullOrNil((String)localObject2)) {
                break label1916;
              }
              localb.yQr.setVisibility(0);
              localb.yQr.setText((CharSequence)localObject2);
              if (bs.isNullOrNil((String)localObject1)) {
                break label1954;
              }
              if (localb.yQr.getVisibility() != 8) {
                break label1929;
              }
              localb.titleTv.setMaxLines(2);
              label1749:
              localb.titleTv.setVisibility(0);
              if ((localTimeLineObject.hhK & 0x1) <= 0) {
                break label1941;
              }
              localb.titleTv.setText(com.tencent.mm.plugin.sns.data.q.a((String)localObject1, this.dgE, localb.titleTv));
            }
          }
          for (;;)
          {
            if ((localTimeLineObject.FQu == null) || (localTimeLineObject.FQu.subType != 1)) {
              break label1965;
            }
            localb.yxG.setVisibility(0);
            localb.yxG.setImageResource(2131234474);
            break;
            paramView = "";
            break label1463;
            af.dHO().a(localbtz, localb.yQp, this.dgE.hashCode(), f.a.xQX, (bf)localObject2);
            break label1649;
            if (localTimeLineObject.FQo.Ety != 26)
            {
              localb.yQp.setVisibility(8);
              break label1649;
            }
            localb.yQp.setVisibility(0);
            localb.yQp.setImageResource(2131690949);
            break label1649;
            label1916:
            localb.yQr.setVisibility(8);
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
  
  private void p(final TextView paramTextView)
  {
    AppMethodBeat.i(99041);
    if (this.yPZ <= 0) {
      paramTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99020);
          new Rect();
          paramTextView.measure(0, 0);
          bb.a(bb.this, paramTextView.getMeasuredHeight());
          ac.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", new Object[] { Integer.valueOf(bb.e(bb.this)) });
          AppMethodBeat.o(99020);
        }
      });
    }
    AppMethodBeat.o(99041);
  }
  
  private void rp(boolean paramBoolean)
  {
    AppMethodBeat.i(99046);
    ac.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.qui);
    if (this.yPR != null)
    {
      if (this.isSearchMode)
      {
        this.yPS.af(this.yPQ, paramBoolean);
        AppMethodBeat.o(99046);
        return;
      }
      this.yPR.h(this.qui, this.yPQ, paramBoolean);
    }
    AppMethodBeat.o(99046);
  }
  
  private void xR(long paramLong)
  {
    AppMethodBeat.i(99050);
    Object localObject = com.tencent.mm.plugin.sns.data.q.wX(af.dHR().b(paramLong, af.dHH().atV(this.userName), this.userName, this.dfZ));
    if (this.yEq.equals("")) {}
    for (;;)
    {
      this.qui = ((String)localObject);
      localObject = af.dHV().auY(this.userName).dMm();
      if (((agu)localObject).EyT != 0L) {
        break;
      }
      AppMethodBeat.o(99050);
      return;
      if (((String)localObject).compareTo(this.yEq) >= 0) {
        localObject = this.yEq;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.wX(((agu)localObject).EyT);
    if (this.qui.equals(""))
    {
      this.qui = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
    }
    if (((String)localObject).compareTo(this.qui) > 0) {}
    for (;;)
    {
      this.qui = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
      localObject = this.qui;
    }
  }
  
  public final void a(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99045);
    ac.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (this.yPT != null) {
        this.yPT.dQj();
      }
      AppMethodBeat.o(99045);
      return;
    }
    ac.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    this.list.clear();
    this.ywG.clear();
    this.ywH.clear();
    this.yPO.clear();
    int i = 0;
    while (i < j)
    {
      p localp = p.I((p)paramList.get(i));
      this.list.add(localp);
      i += 1;
    }
    paramList = paramMap1.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
      this.ywG.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      this.ywH.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      this.yPO.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (this.dfZ)
    {
      if (this.list.size() <= 1) {}
      for (i = 2147483647;; i = ((p)this.list.get(1)).field_head)
      {
        this.yPU = 0;
        j = 0;
        while (j < this.list.size())
        {
          if ((!this.dfZ) || (j != 0))
          {
            if (i != ((p)this.list.get(j)).field_head) {
              break;
            }
            this.yPU = Math.max(this.yPU, ((p)this.list.get(j)).field_createTime);
          }
          j += 1;
        }
      }
    }
    if (this.list.isEmpty()) {}
    for (i = 2147483647;; i = ((p)this.list.get(0)).field_head) {
      break;
    }
    if ((this.list.isEmpty()) || ((this.dfZ) && (this.list.size() == 1))) {
      this.yPU = 2147483647;
    }
    if (this.list.isEmpty()) {}
    for (i = 0;; i = ((p)this.list.get(this.list.size() - 1)).field_head)
    {
      this.yPV = 2147483647;
      j = this.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((p)this.list.get(j)).field_head))
      {
        this.yPV = Math.min(this.yPV, ((p)this.list.get(j)).field_createTime);
        j -= 1;
      }
    }
    if (this.list.isEmpty()) {
      this.yPV = 0;
    }
    this.ywJ = paramInt1;
    this.ywI = paramInt2;
    ac.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + this.yPU + " edTIme " + this.yPV);
    notifyDataSetChanged();
    AppMethodBeat.o(99045);
  }
  
  public final void dNz()
  {
    AppMethodBeat.i(99048);
    rp(true);
    notifyDataSetChanged();
    AppMethodBeat.o(99048);
  }
  
  public final void dQg()
  {
    this.yPY = true;
    if (this.isSearchMode) {
      this.yPS.yQU = true;
    }
  }
  
  public final void dQh()
  {
    AppMethodBeat.i(99049);
    ac.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((p)this.list.get(this.list.size() - 1)).field_snsId)
    {
      xR(l);
      AppMethodBeat.o(99049);
      return;
    }
  }
  
  public final int getCount()
  {
    return this.ywI;
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
    if ((this.dfZ) && (paramInt == 0) && ((!this.isSearchMode) || ((this.isSearchMode) && (this.yPY))))
    {
      ac.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(99043);
      return 0;
    }
    if (this.ywG.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.ywG.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        ac.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(99043);
        return 0;
      }
      p localp = (p)getItem(i);
      if (localp.dLV().FQo.Ety == 1)
      {
        ac.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(99043);
        return 0;
      }
      if (localp.dLV().FQo.Ety == 15)
      {
        ac.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(99043);
        return 2;
      }
      if (localp.dLV().FQo.Ety == 21)
      {
        AppMethodBeat.o(99043);
        return 3;
      }
      if ((localp.dLV().FQo.Ety == 28) || (localp.dLV().FQo.Ety == 29))
      {
        AppMethodBeat.o(99043);
        return 4;
      }
      AppMethodBeat.o(99043);
      return 1;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99038);
    int i = getItemViewType(paramInt);
    ac.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(i)));
    Object localObject1;
    int j;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
      {
        paramViewGroup = new d();
        paramView = z.jD(this.dgE).inflate(2131495576, null);
        paramViewGroup.yQi = ((TextView)paramView.findViewById(2131304967));
        paramViewGroup.yQh = ((TextView)paramView.findViewById(2131305007));
        paramViewGroup.yQj = ((TextView)paramView.findViewById(2131305106));
        paramViewGroup.yQt = ((MaskImageView)paramView.findViewById(2131300977));
        paramViewGroup.yQu = ((QFadeImageView)paramView.findViewById(2131305641));
        paramViewGroup.yQv = ((MaskImageView)paramView.findViewById(2131300978));
        paramViewGroup.yQw = ((MaskImageView)paramView.findViewById(2131300979));
        paramViewGroup.yQx = ((MMNeat7extView)paramView.findViewById(2131298996));
        paramViewGroup.yQy = ((TextView)paramView.findViewById(2131307000));
        paramViewGroup.yQz = ((TextView)paramView.findViewById(2131307001));
        paramViewGroup.yQA = ((TextView)paramView.findViewById(2131307002));
        paramViewGroup.yQB = ((TextView)paramView.findViewById(2131300986));
        paramViewGroup.yQC = paramView.findViewById(2131299002);
        paramViewGroup.yQm = ((TextView)paramView.findViewById(2131296470));
        paramViewGroup.yQk = ((LinearLayout)paramView.findViewById(2131301423));
        paramViewGroup.yQl = ((ImageView)paramView.findViewById(2131301549));
        paramViewGroup.ywY = ((LinearLayout)paramView.findViewById(2131301456));
        paramViewGroup.ywZ = paramView.findViewById(2131301422);
        paramViewGroup.yQu.setOnClickListener(this.yPP.ywP);
        paramViewGroup.yQt.setOnClickListener(this.yPP.ywP);
        paramViewGroup.yQv.setOnClickListener(this.yPP.ywQ);
        paramViewGroup.yQw.setOnClickListener(this.yPP.ywR);
        paramViewGroup.yQt.setOnLongClickListener(this.yPP.yQN);
        paramViewGroup.yQv.setOnLongClickListener(this.yPP.yQN);
        paramViewGroup.yQw.setOnLongClickListener(this.yPP.yQN);
        paramViewGroup.yQD = ((TextView)paramView.findViewById(2131306862));
        paramViewGroup.yQE = ((TextView)paramView.findViewById(2131306863));
        paramViewGroup.yQF = ((TextView)paramView.findViewById(2131306864));
        paramViewGroup.yQG = ((TextView)paramView.findViewById(2131306096));
        paramViewGroup.yQH = ((TextView)paramView.findViewById(2131306097));
        paramViewGroup.yQI = ((TextView)paramView.findViewById(2131306098));
        paramViewGroup.yQJ = ((MaskLinearLayout)paramView.findViewById(2131305003));
        paramViewGroup.yQJ.b(paramViewGroup.yQt);
        paramViewGroup.yQn = ((LinearLayout)paramView.findViewById(2131300304));
        paramViewGroup.yQo = ((TextView)paramView.findViewById(2131305022));
        paramViewGroup.yQo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99022);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("enter_scene", e.i.Hho);
            d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(8) });
            AppMethodBeat.o(99022);
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        af.dHO().eB(paramViewGroup.yQt);
        af.dHO().eB(paramViewGroup.yQv);
        af.dHO().eB(paramViewGroup.yQw);
        i = -1;
        if (this.ywG.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.ywG.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.yQj.setTag(Integer.valueOf(paramInt));
        paramViewGroup.yQJ.settouchEnable(false);
        paramViewGroup.yQJ.setBackgroundResource(0);
        paramViewGroup.yQJ.setDescendantFocusability(131072);
        paramViewGroup.yQJ.setClickable(false);
        paramViewGroup.yQt.settouchEnable(true);
        paramViewGroup.yQt.setClickable(true);
        paramViewGroup.yQt.setLongClickable(false);
        paramViewGroup.yQv.setLongClickable(false);
        paramViewGroup.yQw.setLongClickable(false);
        paramViewGroup.yQJ.setOnClickListener(null);
        paramViewGroup.yQJ.setOnLongClickListener(null);
        paramViewGroup.yQJ.setLongClickable(false);
        if ((i < this.ywJ) && (i != -1)) {
          break;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(99038);
        return paramView;
        paramViewGroup = (d)paramView.getTag();
      }
      if (i - 1 < 0) {
        break label6245;
      }
      localObject1 = (p)getItem(i - 1);
      j = ((p)localObject1).field_head;
      aj.as(((p)localObject1).field_localPrivate, this.dfZ);
    }
    label1287:
    label1300:
    label1312:
    label1319:
    label2476:
    label6201:
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.setVisibility(0);
      if (this.ywH.get(Integer.valueOf(paramInt)) != null) {}
      label1094:
      label6215:
      label6221:
      for (int k = ((Integer)this.ywH.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        Object localObject2 = (p)getItem(i);
        localObject1 = ((p)localObject2).dLV();
        long l;
        if (((this.dfZ) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
        {
          if (au(paramInt, ((p)localObject2).field_snsId))
          {
            l = ((p)localObject2).field_createTime;
            a(paramViewGroup.yQh, paramViewGroup.yQi, l);
          }
          if (((TimeLineObject)localObject1).FQm != null)
          {
            if (!bs.isNullOrNil(((TimeLineObject)localObject1).FQm.gPy)) {
              break label1287;
            }
            localObject1 = ((TimeLineObject)localObject1).FQm.iJV;
            if ((localObject1 != null) && (!((String)localObject1).equals("")))
            {
              paramViewGroup.yQm.setText((CharSequence)localObject1);
              paramViewGroup.yQm.setVisibility(0);
            }
          }
          paramViewGroup.ywZ.setVisibility(0);
        }
        else
        {
          if ((this.yPX == 0L) || (((p)localObject2).field_snsId != this.yPX)) {
            break label1300;
          }
          paramViewGroup.yQn.setVisibility(0);
          paramViewGroup.yQk.setVisibility(0);
          if ((!this.dfZ) || (paramInt != 0) || ((this.isSearchMode) && ((!this.isSearchMode) || (!this.yPY)))) {
            break label1319;
          }
          paramViewGroup.yQu.setVisibility(0);
          paramViewGroup.yQu.setContentDescription(this.dgE.getString(2131764020));
          paramViewGroup.yQt.setVisibility(8);
          localObject2 = paramViewGroup.yQx;
          if (this.ywI != 1) {
            break label1312;
          }
        }
        for (localObject1 = this.dgE.getString(2131764063);; localObject1 = "")
        {
          ((MMNeat7extView)localObject2).ar((CharSequence)localObject1);
          paramViewGroup.yQx.setVisibility(0);
          paramViewGroup.yQC.setVisibility(0);
          paramViewGroup.yQB.setVisibility(8);
          af.dHO().c(paramViewGroup.yQu, 2131100942, 2131234148, this.dgE.hashCode());
          localObject1 = new f.a();
          ((f.a)localObject1).dwR = -1;
          ((f.a)localObject1).position = -1;
          paramViewGroup.yQu.setTag(localObject1);
          AppMethodBeat.o(99038);
          return paramView;
          localObject1 = ((TimeLineObject)localObject1).FQm.gPy;
          break;
          paramViewGroup.yQn.setVisibility(8);
          break label1094;
        }
        a(paramViewGroup.yQj, j, ((p)localObject2).field_head);
        if (k > 0)
        {
          a(i, paramViewGroup.yQt, paramViewGroup.yQy, paramViewGroup.yQB, paramViewGroup.yQD, paramViewGroup.yQG, 1, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.f.ydE.E((p)getItem(i));
        }
        if (k >= 2)
        {
          a(i + 1, paramViewGroup.yQv, paramViewGroup.yQz, paramViewGroup.yQB, paramViewGroup.yQE, paramViewGroup.yQH, 2, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.f.ydE.E((p)getItem(i + 1));
        }
        if (k >= 3)
        {
          a(i + 2, paramViewGroup.yQw, paramViewGroup.yQA, paramViewGroup.yQB, paramViewGroup.yQF, paramViewGroup.yQI, 3, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.j.f.ydE.E((p)getItem(i + 2));
        }
        if (k == 1)
        {
          localObject1 = (p)getItem(i);
          if ((!bs.isNullOrNil(((p)localObject1).dLV().FQl)) && (((p)localObject1).field_type == 1))
          {
            paramViewGroup.yQJ.setDescendantFocusability(393216);
            paramViewGroup.yQJ.setClickable(true);
            paramViewGroup.yQt.setClickable(false);
            paramViewGroup.yQt.settouchEnable(false);
            paramViewGroup.yQJ.setOnClickListener(this.yPP.ywP);
            paramViewGroup.yQJ.settouchEnable(true);
            i = ((p)localObject2).yvp;
            localObject2 = new f.a();
            ((f.a)localObject2).dwR = i;
            if (this.yPO.get(Integer.valueOf(paramInt)) == null) {
              break label1702;
            }
          }
        }
        for (((f.a)localObject2).position = ((Integer)this.yPO.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject2).position = 0)
        {
          if ((((p)localObject1).dHA()) && (((p)localObject1).dMw())) {
            paramViewGroup.yQJ.setOnLongClickListener(this.yPP.yQN);
          }
          paramViewGroup.yQJ.setTag(localObject2);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(99038);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
          {
            paramViewGroup = new e();
            paramView = z.jD(this.dgE).inflate(2131495590, null);
            paramViewGroup.yQi = ((TextView)paramView.findViewById(2131304967));
            paramViewGroup.yQh = ((TextView)paramView.findViewById(2131305007));
            paramViewGroup.yQj = ((TextView)paramView.findViewById(2131305106));
            paramViewGroup.yQt = ((MaskImageView)paramView.findViewById(2131300977));
            paramViewGroup.yQm = ((TextView)paramView.findViewById(2131296470));
            paramViewGroup.yQk = ((LinearLayout)paramView.findViewById(2131301423));
            paramViewGroup.yQl = ((ImageView)paramView.findViewById(2131301549));
            paramViewGroup.ywY = ((LinearLayout)paramView.findViewById(2131301456));
            paramViewGroup.ywZ = paramView.findViewById(2131301422);
            paramViewGroup.yQt.setOnClickListener(this.yPP.yQM);
            paramViewGroup.yQD = ((TextView)paramView.findViewById(2131306862));
            paramViewGroup.yQJ = ((MaskLinearLayout)paramView.findViewById(2131305003));
            paramViewGroup.yQJ.b(paramViewGroup.yQt);
            paramViewGroup.yQx = ((MMNeat7extView)paramView.findViewById(2131298996));
            paramViewGroup.yQC = paramView.findViewById(2131299002);
            paramViewGroup.yQn = ((LinearLayout)paramView.findViewById(2131300304));
            paramViewGroup.yQo = ((TextView)paramView.findViewById(2131305022));
            paramViewGroup.yQo.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(99021);
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("enter_scene", e.i.Hho);
                d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(99021);
              }
            });
            paramView.setTag(paramViewGroup);
            af.dHO().eB(paramViewGroup.yQt);
            if (this.ywG.get(Integer.valueOf(paramInt)) == null) {
              break label6233;
            }
          }
        }
        label3800:
        label5592:
        label6233:
        for (i = ((Integer)this.ywG.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.yQj.setTag(Integer.valueOf(paramInt));
          paramViewGroup.yQJ.settouchEnable(false);
          paramViewGroup.yQJ.setBackgroundResource(0);
          paramViewGroup.yQJ.setDescendantFocusability(131072);
          paramViewGroup.yQJ.setClickable(false);
          paramViewGroup.yQt.settouchEnable(true);
          paramViewGroup.yQt.setClickable(true);
          paramViewGroup.yQJ.setOnClickListener(null);
          if ((i >= this.ywJ) || (i == -1))
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
            aj.as(((p)localObject1).field_localPrivate, this.dfZ);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.ywH.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.ywH.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject2 = (p)getItem(i);
            Object localObject3 = ((p)localObject2).dLV();
            if (((this.dfZ) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
            {
              if (au(paramInt, ((p)localObject2).field_snsId))
              {
                l = ((p)localObject2).field_createTime;
                a(paramViewGroup.yQh, paramViewGroup.yQi, l);
              }
              if (((TimeLineObject)localObject3).FQm != null)
              {
                if (!bs.isNullOrNil(((TimeLineObject)localObject3).FQm.gPy)) {
                  break label2832;
                }
                localObject1 = ((TimeLineObject)localObject3).FQm.iJV;
                if ((localObject1 != null) && (!((String)localObject1).equals("")))
                {
                  paramViewGroup.yQm.setText((CharSequence)localObject1);
                  paramViewGroup.yQm.setVisibility(0);
                }
              }
              paramViewGroup.ywZ.setVisibility(0);
            }
            else
            {
              a(paramViewGroup.yQj, j, ((p)localObject2).field_head);
              if ((this.yPX == 0L) || (((p)localObject2).field_snsId != this.yPX)) {
                break label2845;
              }
              paramViewGroup.yQn.setVisibility(0);
              paramViewGroup.yQk.setVisibility(0);
              localObject1 = new bf(this.yPN.tag);
              ((bf)localObject1).gIh = ((p)localObject2).field_createTime;
              paramViewGroup.yQt.setVisibility(0);
              af.dHO().a(((TimeLineObject)localObject3).FQo.Etz, paramViewGroup.yQt, this.dgE.hashCode(), f.a.xQX, (bf)localObject1);
              if (aj.as(((p)localObject2).field_localPrivate, this.dfZ))
              {
                paramViewGroup.yQD.setVisibility(0);
                paramViewGroup.yQD.setBackgroundResource(2131233596);
                localObject1 = this.yJv.aNt(((p)localObject2).field_userName);
                if (localObject1 != null) {
                  ((com.tencent.mm.n.b)localObject1).aaS();
                }
              }
              localObject1 = (p)getItem(i);
              localObject3 = ((p)localObject1).dLV().FQl;
              if ((localObject3 != null) && (!((String)localObject3).equals("")))
              {
                paramViewGroup.yQC.setVisibility(0);
                paramViewGroup.yQx.setVisibility(0);
                paramViewGroup.yQx.ar(com.tencent.mm.pluginsdk.ui.span.k.b(this.dgE, (CharSequence)localObject3, paramViewGroup.yQx.getTextSize()));
              }
              paramViewGroup.yQJ.setDescendantFocusability(393216);
              paramViewGroup.yQJ.setClickable(true);
              paramViewGroup.yQt.setClickable(false);
              paramViewGroup.yQt.settouchEnable(false);
              paramViewGroup.yQJ.setOnClickListener(this.yPP.yQM);
              paramViewGroup.yQJ.settouchEnable(true);
              i = ((p)localObject2).yvp;
              localObject2 = new f.a();
              ((f.a)localObject2).dwR = i;
              if (this.yPO.get(Integer.valueOf(paramInt)) == null) {
                break label2857;
              }
            }
            for (((f.a)localObject2).position = ((Integer)this.yPO.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject2).position = 0)
            {
              paramViewGroup.yQJ.setTag(localObject2);
              paramView.setDrawingCacheEnabled(false);
              com.tencent.mm.plugin.sns.j.f.ydE.E((p)localObject1);
              AppMethodBeat.o(99038);
              return paramView;
              localObject1 = ((TimeLineObject)localObject3).FQm.gPy;
              break;
              paramViewGroup.yQn.setVisibility(8);
              break label2476;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
              {
                paramViewGroup = new d();
                paramView = z.jD(this.dgE).inflate(2131495576, null);
                paramViewGroup.yQi = ((TextView)paramView.findViewById(2131304967));
                paramViewGroup.yQh = ((TextView)paramView.findViewById(2131305007));
                paramViewGroup.yQj = ((TextView)paramView.findViewById(2131305106));
                paramViewGroup.yQt = ((MaskImageView)paramView.findViewById(2131300977));
                paramViewGroup.yQu = ((QFadeImageView)paramView.findViewById(2131305641));
                paramViewGroup.yQv = ((MaskImageView)paramView.findViewById(2131300978));
                paramViewGroup.yQw = ((MaskImageView)paramView.findViewById(2131300979));
                paramViewGroup.yQx = ((MMNeat7extView)paramView.findViewById(2131298996));
                paramViewGroup.yQy = ((TextView)paramView.findViewById(2131307000));
                paramViewGroup.yQz = ((TextView)paramView.findViewById(2131307001));
                paramViewGroup.yQA = ((TextView)paramView.findViewById(2131307002));
                paramViewGroup.yQB = ((TextView)paramView.findViewById(2131300986));
                paramViewGroup.yQC = paramView.findViewById(2131299002);
                paramViewGroup.yQm = ((TextView)paramView.findViewById(2131296470));
                paramViewGroup.yQk = ((LinearLayout)paramView.findViewById(2131301423));
                paramViewGroup.yQl = ((ImageView)paramView.findViewById(2131301549));
                paramViewGroup.ywY = ((LinearLayout)paramView.findViewById(2131301456));
                paramViewGroup.ywZ = paramView.findViewById(2131301422);
                paramViewGroup.yQu.setOnClickListener(this.yPP.yQL);
                paramViewGroup.yQt.setOnClickListener(this.yPP.yQL);
                paramViewGroup.yQD = ((TextView)paramView.findViewById(2131306862));
                paramViewGroup.yQE = ((TextView)paramView.findViewById(2131306863));
                paramViewGroup.yQF = ((TextView)paramView.findViewById(2131306864));
                paramViewGroup.yQG = ((TextView)paramView.findViewById(2131306096));
                paramViewGroup.yQH = ((TextView)paramView.findViewById(2131306097));
                paramViewGroup.yQI = ((TextView)paramView.findViewById(2131306098));
                paramViewGroup.yQJ = ((MaskLinearLayout)paramView.findViewById(2131305003));
                paramViewGroup.yQJ.b(paramViewGroup.yQt);
                paramViewGroup.yQn = ((LinearLayout)paramView.findViewById(2131300304));
                paramViewGroup.yQo = ((TextView)paramView.findViewById(2131305022));
                paramViewGroup.yQo.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(99025);
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("enter_scene", e.i.Hho);
                    d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                    com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(8) });
                    AppMethodBeat.o(99025);
                  }
                });
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                af.dHO().eB(paramViewGroup.yQt);
                af.dHO().eB(paramViewGroup.yQv);
                af.dHO().eB(paramViewGroup.yQw);
                i = -1;
                if (this.ywG.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.ywG.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.yQj.setTag(Integer.valueOf(paramInt));
                paramViewGroup.yQJ.settouchEnable(false);
                paramViewGroup.yQJ.setBackgroundResource(0);
                paramViewGroup.yQJ.setDescendantFocusability(131072);
                paramViewGroup.yQJ.setClickable(false);
                paramViewGroup.yQt.settouchEnable(true);
                paramViewGroup.yQt.setClickable(true);
                paramViewGroup.yQJ.setOnClickListener(null);
                if ((i < this.ywJ) && (i != -1)) {
                  break;
                }
                paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                paramView.setVisibility(8);
                AppMethodBeat.o(99038);
                return paramView;
                paramViewGroup = (d)paramView.getTag();
              }
              if (i - 1 < 0) {
                break label6221;
              }
              localObject1 = (p)getItem(i - 1);
              j = ((p)localObject1).field_head;
              aj.as(((p)localObject1).field_localPrivate, this.dfZ);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject2 = (p)getItem(i);
              localObject1 = ((p)localObject2).dLV();
              if (((this.dfZ) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
              {
                if (au(paramInt, ((p)localObject2).field_snsId))
                {
                  l = ((p)localObject2).field_createTime;
                  a(paramViewGroup.yQh, paramViewGroup.yQi, l);
                }
                if (((TimeLineObject)localObject1).FQm != null)
                {
                  if (!bs.isNullOrNil(((TimeLineObject)localObject1).FQm.gPy)) {
                    break label3972;
                  }
                  localObject1 = ((TimeLineObject)localObject1).FQm.iJV;
                  if ((localObject1 != null) && (!((String)localObject1).equals("")))
                  {
                    paramViewGroup.yQm.setText((CharSequence)localObject1);
                    paramViewGroup.yQm.setVisibility(0);
                  }
                }
                paramViewGroup.ywZ.setVisibility(0);
              }
              else
              {
                a(paramViewGroup.yQj, j, ((p)localObject2).field_head);
                if ((this.yPX == 0L) || (((p)localObject2).field_snsId != this.yPX)) {
                  break label3985;
                }
                paramViewGroup.yQn.setVisibility(0);
                paramViewGroup.yQk.setVisibility(0);
                if ((!this.dfZ) || (paramInt != 0)) {
                  break label4004;
                }
                paramViewGroup.yQu.setVisibility(0);
                paramViewGroup.yQu.setContentDescription(this.dgE.getString(2131764020));
                paramViewGroup.yQt.setVisibility(8);
                localObject2 = paramViewGroup.yQx;
                if (this.ywI != 1) {
                  break label3997;
                }
              }
              for (localObject1 = this.dgE.getString(2131764063);; localObject1 = "")
              {
                ((MMNeat7extView)localObject2).ar((CharSequence)localObject1);
                paramViewGroup.yQx.setVisibility(0);
                paramViewGroup.yQC.setVisibility(0);
                paramViewGroup.yQB.setVisibility(8);
                af.dHO().c(paramViewGroup.yQu, 2131100942, 2131234148, this.dgE.hashCode());
                localObject1 = new f.a();
                ((f.a)localObject1).dwR = -1;
                ((f.a)localObject1).position = -1;
                paramViewGroup.yQu.setTag(localObject1);
                AppMethodBeat.o(99038);
                return paramView;
                localObject1 = ((TimeLineObject)localObject1).FQm.gPy;
                break;
                paramViewGroup.yQn.setVisibility(8);
                break label3800;
              }
              a(i, paramViewGroup.yQt, paramViewGroup.yQy, paramViewGroup.yQB, paramViewGroup.yQD, paramViewGroup.yQG, 1, paramViewGroup, paramInt);
              localObject1 = (p)getItem(i);
              if ((!bs.isNullOrNil(((p)localObject1).dLV().FQl)) && (((p)localObject1).field_type == 1))
              {
                paramViewGroup.yQJ.setDescendantFocusability(393216);
                paramViewGroup.yQJ.setClickable(true);
                paramViewGroup.yQt.setClickable(false);
                paramViewGroup.yQt.settouchEnable(false);
                paramViewGroup.yQJ.setOnClickListener(this.yPP.yQL);
                paramViewGroup.yQJ.settouchEnable(true);
                i = ((p)localObject2).yvp;
                localObject2 = new f.a();
                ((f.a)localObject2).dwR = i;
                if (this.yPO.get(Integer.valueOf(paramInt)) == null) {
                  break label4216;
                }
              }
              label4216:
              for (((f.a)localObject2).position = ((Integer)this.yPO.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject2).position = 0)
              {
                paramViewGroup.yQJ.setTag(localObject2);
                com.tencent.mm.plugin.sns.j.f.ydE.E((p)localObject1);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 4) {
                if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof b)))
                {
                  localObject1 = new b();
                  localObject2 = z.jD(this.dgE).inflate(2131495575, null);
                  ((b)localObject1).yQg = ((View)localObject2).findViewById(2131298764);
                  ((b)localObject1).yQi = ((TextView)((View)localObject2).findViewById(2131304967));
                  ((b)localObject1).yQh = ((TextView)((View)localObject2).findViewById(2131305007));
                  ((b)localObject1).yQj = ((TextView)((View)localObject2).findViewById(2131305106));
                  ((b)localObject1).yQm = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).ywZ = ((View)localObject2).findViewById(2131301422);
                  ((b)localObject1).yQm = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).yQk = ((LinearLayout)((View)localObject2).findViewById(2131301423));
                  ((b)localObject1).yQl = ((ImageView)((View)localObject2).findViewById(2131301549));
                  ((b)localObject1).ywY = ((LinearLayout)((View)localObject2).findViewById(2131301456));
                  ((b)localObject1).nMW = ((MMNeat7extView)((View)localObject2).findViewById(2131299008));
                  ((b)localObject1).yQp = ((TagImageView)((View)localObject2).findViewById(2131300948));
                  ((b)localObject1).yxG = ((ImageView)((View)localObject2).findViewById(2131305185));
                  ((b)localObject1).titleTv = ((TextView)((View)localObject2).findViewById(2131305950));
                  ((b)localObject1).yQr = ((TextView)((View)localObject2).findViewById(2131304202));
                  ((b)localObject1).yQg.setOnClickListener(this.yPP.yQK);
                  ((b)localObject1).yQs = ((View)localObject2).findViewById(2131302207);
                  ((b)localObject1).yQq = ((TextView)((View)localObject2).findViewById(2131298762));
                  ((b)localObject1).yQn = ((LinearLayout)((View)localObject2).findViewById(2131300304));
                  ((b)localObject1).yQo = ((TextView)((View)localObject2).findViewById(2131305022));
                  ((b)localObject1).yQo.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(99024);
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("enter_scene", e.i.Hho);
                      d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.wUl.f(14098, new Object[] { Integer.valueOf(8) });
                      AppMethodBeat.o(99024);
                    }
                  });
                  ((View)localObject2).setTag(localObject1);
                  com.tencent.mm.plugin.sns.data.q.b(((b)localObject1).yQp, this.dgE);
                  ((b)localObject1).yQj.setTag(Integer.valueOf(paramInt));
                  if (this.ywG.get(Integer.valueOf(paramInt)) == null) {
                    break label6215;
                  }
                }
              }
              for (i = ((Integer)this.ywG.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                ((b)localObject1).init();
                if ((i >= this.ywJ) || (i == -1))
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
                  aj.as(paramView.field_localPrivate, this.dfZ);
                }
                for (;;)
                {
                  ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  ((View)localObject2).setVisibility(0);
                  p localp = (p)getItem(i);
                  TimeLineObject localTimeLineObject = localp.dLV();
                  if (((this.dfZ) && (paramInt == 0)) || (j == -1) || (localp.field_head != j))
                  {
                    if (au(paramInt, localp.field_snsId))
                    {
                      l = localp.field_createTime;
                      a(((b)localObject1).yQh, ((b)localObject1).yQi, l);
                    }
                    if (localTimeLineObject.FQm != null)
                    {
                      if (!bs.isNullOrNil(localTimeLineObject.FQm.gPy)) {
                        break label5209;
                      }
                      paramView = localTimeLineObject.FQm.iJV;
                      if ((paramView != null) && (!paramView.equals("")))
                      {
                        ((b)localObject1).yQm.setText(paramView);
                        ((b)localObject1).yQm.setVisibility(0);
                      }
                    }
                    ((b)localObject1).ywZ.setVisibility(0);
                  }
                  else
                  {
                    a(((b)localObject1).yQj, j, localp.field_head);
                    if ((this.yPX == 0L) || (localp.field_snsId != this.yPX)) {
                      break label5221;
                    }
                    ((b)localObject1).yQn.setVisibility(0);
                    paramView = new f.a();
                    paramView.dwR = localp.yvp;
                    if (this.yPO.get(Integer.valueOf(paramInt)) == null) {
                      break label5234;
                    }
                    paramView.position = ((Integer)this.yPO.get(Integer.valueOf(paramInt))).intValue();
                    ((b)localObject1).yQg.setTag(paramView);
                    if (bs.isNullOrNil(localTimeLineObject.FQl)) {
                      break label5242;
                    }
                    ((b)localObject1).nMW.setVisibility(0);
                    ((b)localObject1).nMW.ar(com.tencent.mm.pluginsdk.ui.span.k.b(this.dgE, localTimeLineObject.FQl, ((b)localObject1).nMW.getTextSize()));
                  }
                  bf localbf;
                  for (;;)
                  {
                    ((b)localObject1).yQk.setVisibility(0);
                    ((b)localObject1).nMW.getWrappedTextView().setSingleLine(true);
                    ((b)localObject1).yQs.setVisibility(0);
                    localbf = new bf(this.yPN.tag);
                    localbf.gIh = localp.field_createTime;
                    if ((localTimeLineObject.FQo.EtD != null) || (localTimeLineObject.FQo.EtE != null)) {
                      break label5255;
                    }
                    ac.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                    AppMethodBeat.o(99038);
                    return localObject2;
                    label5209:
                    paramView = localTimeLineObject.FQm.gPy;
                    break;
                    label5221:
                    ((b)localObject1).yQn.setVisibility(8);
                    break label5001;
                    label5234:
                    paramView.position = 0;
                    break label5057;
                    label5242:
                    ((b)localObject1).nMW.setVisibility(8);
                  }
                  ((b)localObject1).titleTv.setTextColor(this.dgE.getResources().getColor(2131100711));
                  if (dPs())
                  {
                    paramView = be.avL(localTimeLineObject.FQo.Url);
                    if (localTimeLineObject.FQo.EtD == null) {
                      break label5701;
                    }
                    if ((!bs.isNullOrNil(localTimeLineObject.FQo.EtD.nickname)) || (bs.isNullOrNil(localTimeLineObject.FQo.EtD.desc))) {
                      break label5592;
                    }
                    localObject3 = localTimeLineObject.FQo.EtD.desc;
                    paramViewGroup = paramView;
                    paramView = (View)localObject3;
                  }
                  for (;;)
                  {
                    label5357:
                    if (paramView.length() > 40) {
                      paramView = paramView.substring(0, 40) + "...";
                    }
                    for (;;)
                    {
                      if (((b)localObject1).yQp != null) {
                        ((b)localObject1).yQp.setOnClickListener(null);
                      }
                      ((b)localObject1).yxG.setVisibility(8);
                      if (localTimeLineObject.FQo.EtD != null) {
                        if (localTimeLineObject.FQo.EtD.EGJ == 1)
                        {
                          ((b)localObject1).yQp.setVisibility(8);
                          ((b)localObject1).yQq.setVisibility(0);
                          ((b)localObject1).yQq.setText(localTimeLineObject.FQo.EtD.desc);
                          label5484:
                          if (bs.isNullOrNil(paramViewGroup)) {
                            break label6145;
                          }
                          ((b)localObject1).yQr.setVisibility(0);
                          ((b)localObject1).yQr.setText(paramViewGroup);
                          if (bs.isNullOrNil(paramView)) {
                            break label6170;
                          }
                          if (((b)localObject1).yQr.getVisibility() != 8) {
                            break label6158;
                          }
                          ((b)localObject1).titleTv.setMaxLines(2);
                          ((b)localObject1).titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.dgE, paramView));
                          ((b)localObject1).titleTv.setVisibility(0);
                        }
                      }
                      for (;;)
                      {
                        com.tencent.mm.plugin.sns.j.f.ydE.E(localp);
                        ((View)localObject2).setDrawingCacheEnabled(false);
                        AppMethodBeat.o(99038);
                        return localObject2;
                        paramView = "";
                        break;
                        if (!bs.isNullOrNil(localTimeLineObject.FQo.EtD.desc))
                        {
                          localObject3 = localTimeLineObject.FQo.EtD.nickname + ": " + localTimeLineObject.FQo.EtD.desc;
                          paramViewGroup = paramView;
                          paramView = (View)localObject3;
                          break label5357;
                        }
                        localObject3 = this.dgE.getString(2131763973, new Object[] { localTimeLineObject.FQo.EtD.nickname });
                        paramViewGroup = paramView;
                        paramView = (View)localObject3;
                        break label5357;
                        if (localTimeLineObject.FQo.EtE == null) {
                          break label6201;
                        }
                        if (localTimeLineObject.FQo.EtE.rPI == 1) {}
                        for (paramView = "#" + localTimeLineObject.FQo.EtE.dol;; paramView = localTimeLineObject.FQo.EtE.dol)
                        {
                          paramViewGroup = localTimeLineObject.FQo.EtE.desc;
                          break;
                        }
                        if (localTimeLineObject.FQo.EtD.mediaList.isEmpty()) {
                          break label5484;
                        }
                        ((b)localObject1).yQp.setVisibility(0);
                        localObject3 = new btz();
                        ((btz)localObject3).Url = ((anw)localTimeLineObject.FQo.EtD.mediaList.get(0)).thumbUrl;
                        ((btz)localObject3).Fjh = ((anw)localTimeLineObject.FQo.EtD.mediaList.get(0)).thumbUrl;
                        ((btz)localObject3).ndI = 2;
                        ((btz)localObject3).Fji = 1;
                        ((btz)localObject3).Fjk = new bub();
                        ((btz)localObject3).EUH = 1;
                        ((btz)localObject3).Fjk.FjY = ((anw)localTimeLineObject.FQo.EtD.mediaList.get(0)).width;
                        ((btz)localObject3).Fjk.FjZ = ((anw)localTimeLineObject.FQo.EtD.mediaList.get(0)).height;
                        ((btz)localObject3).Id = localp.getSnsId();
                        af.dHO().a((btz)localObject3, ((b)localObject1).yQp, this.dgE.hashCode(), f.a.xQX, localbf);
                        break label5484;
                        if (localTimeLineObject.FQo.EtE == null) {
                          break label5484;
                        }
                        ((b)localObject1).yQp.setVisibility(0);
                        localObject3 = new btz();
                        ((btz)localObject3).Url = localTimeLineObject.FQo.EtE.iconUrl;
                        ((btz)localObject3).Fjh = localTimeLineObject.FQo.EtE.iconUrl;
                        ((btz)localObject3).ndI = 2;
                        ((btz)localObject3).Fji = 1;
                        ((btz)localObject3).Fjk = new bub();
                        ((btz)localObject3).EUH = 1;
                        ((btz)localObject3).Fjk.FjY = 0.0F;
                        ((btz)localObject3).Fjk.FjZ = 0.0F;
                        ((btz)localObject3).Id = localp.getSnsId();
                        af.dHO().a((btz)localObject3, ((b)localObject1).yQp, this.dgE.hashCode(), f.a.xQX, localbf);
                        break label5484;
                        ((b)localObject1).yQr.setVisibility(8);
                        break label5509;
                        ((b)localObject1).titleTv.setMaxLines(1);
                        break label5538;
                        ((b)localObject1).titleTv.setVisibility(8);
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
      label5057:
      label5701:
      label6245:
      j = -1;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 5;
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.i.b> hx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99052);
    ArrayList localArrayList = new ArrayList();
    this.yQb = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      p localp = (p)this.list.get(paramInt2);
      int j = localp.yvp;
      if ((localp.dLV() != null) && (localp.dLV().FQo != null) && (localp.dLV().FQo.Etz.size() != 0) && ((localp.dLV().FQo.Ety == 1) || (localp.dLV().FQo.Ety == 15)))
      {
        if (j == paramInt1) {
          this.yQb = localArrayList.size();
        }
        Iterator localIterator = localp.dLV().FQo.Etz.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          btz localbtz = (btz)localIterator.next();
          com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
          localb.dwE = localbtz;
          localb.yav = x.bk("sns_table_", j);
          localb.hGU = localp.field_createTime;
          localb.yax = i;
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
  
  public final void xQ(long paramLong)
  {
    if (0L != this.yPW) {
      return;
    }
    this.yPW = paramLong;
    this.yPX = 0L;
  }
  
  class a
  {
    View yQg;
    TextView yQh;
    TextView yQi;
    TextView yQj;
    LinearLayout yQk;
    ImageView yQl;
    TextView yQm;
    LinearLayout yQn;
    TextView yQo;
    LinearLayout ywY;
    View ywZ;
    
    a() {}
    
    public void init()
    {
      AppMethodBeat.i(99026);
      this.yQh.setVisibility(8);
      this.yQi.setVisibility(8);
      this.yQj.setVisibility(8);
      this.yQk.setVisibility(4);
      this.yQl.setVisibility(4);
      this.ywZ.setVisibility(8);
      this.yQm.setVisibility(8);
      this.yQn.setVisibility(8);
      AppMethodBeat.o(99026);
    }
  }
  
  final class b
    extends bb.a
  {
    MMNeat7extView nMW;
    TextView titleTv;
    TagImageView yQp;
    TextView yQq;
    TextView yQr;
    View yQs;
    ImageView yxG;
    
    b()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99027);
      super.init();
      this.nMW.setVisibility(8);
      this.yQp.setVisibility(8);
      if (this.yQq != null) {
        this.yQq.setVisibility(8);
      }
      this.yxG.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.yQr.setVisibility(8);
      AppMethodBeat.o(99027);
    }
  }
  
  public static abstract interface c
  {
    public abstract void dQj();
  }
  
  final class d
    extends bb.a
  {
    TextView yQA;
    TextView yQB;
    View yQC;
    TextView yQD;
    TextView yQE;
    TextView yQF;
    TextView yQG;
    TextView yQH;
    TextView yQI;
    MaskLinearLayout yQJ;
    MaskImageView yQt;
    QFadeImageView yQu;
    QFadeImageView yQv;
    QFadeImageView yQw;
    MMNeat7extView yQx;
    TextView yQy;
    TextView yQz;
    
    d()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99028);
      super.init();
      this.yQt.setVisibility(8);
      this.yQv.setVisibility(8);
      this.yQw.setVisibility(8);
      this.yQx.setVisibility(8);
      this.yQy.setVisibility(8);
      this.yQz.setVisibility(8);
      this.yQA.setVisibility(8);
      this.yQB.setVisibility(8);
      this.yQC.setVisibility(8);
      this.yQu.setVisibility(8);
      this.yQD.setVisibility(8);
      this.yQE.setVisibility(8);
      this.yQF.setVisibility(8);
      this.yQG.setVisibility(8);
      this.yQH.setVisibility(8);
      this.yQI.setVisibility(8);
      if (com.tencent.mm.cc.a.eb(bb.f(bb.this)) > 1.0F) {
        this.yQx.setMaxLines(2);
      }
      AppMethodBeat.o(99028);
    }
  }
  
  final class e
    extends bb.a
  {
    View yQC;
    TextView yQD;
    MaskLinearLayout yQJ;
    MaskImageView yQt;
    MMNeat7extView yQx;
    
    e()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99029);
      super.init();
      this.yQt.setVisibility(8);
      this.yQx.setVisibility(8);
      this.yQD.setVisibility(8);
      this.yQC.setVisibility(8);
      if (com.tencent.mm.cc.a.eb(bb.f(bb.this)) > 1.0F) {
        this.yQx.setMaxLines(2);
      }
      AppMethodBeat.o(99029);
    }
  }
  
  public static final class f$a
  {
    public int dwR;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb
 * JD-Core Version:    0.7.0.1
 */