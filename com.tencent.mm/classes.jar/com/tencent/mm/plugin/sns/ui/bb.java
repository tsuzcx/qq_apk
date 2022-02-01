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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.f.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.y;
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
  private boolean diE;
  private Activity djj;
  boolean isSearchMode;
  List<p> list;
  String pLA;
  private boolean rOT;
  private String sOz;
  private String userName;
  long wGj;
  private com.tencent.mm.storage.bc xCZ;
  private Map<Integer, Integer> xDa;
  private bb.f xDb;
  boolean xDc;
  bc xDd;
  bd xDe;
  private c xDf;
  int xDg;
  int xDh;
  private long xDi;
  private long xDj;
  boolean xDk;
  private int xDl;
  private int xDm;
  int xDn;
  protected View.OnClickListener xDo;
  Map<Integer, Integer> xjN;
  private Map<Integer, Integer> xjO;
  private int xjP;
  private int xjQ;
  String xrA;
  private com.tencent.mm.storage.bg xwF;
  
  public bb(Activity paramActivity, bb.f paramf, String paramString, final c paramc)
  {
    AppMethodBeat.i(99037);
    this.userName = "";
    this.list = new ArrayList();
    this.xjN = new HashMap();
    this.xjO = new HashMap();
    this.xDa = new HashMap();
    this.xjP = 0;
    this.xjQ = 0;
    this.diE = false;
    this.xrA = "";
    this.xDc = false;
    this.rOT = false;
    this.wGj = 0L;
    this.pLA = "";
    this.xwF = null;
    this.sOz = "";
    this.xDg = 2147483647;
    this.xDh = 0;
    this.xDi = 0L;
    this.xDj = 0L;
    this.isSearchMode = false;
    this.xDk = false;
    this.xDl = 0;
    this.xDm = 0;
    this.xDn = 0;
    this.xDo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163121);
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
          if (bb.aqB(paramAnonymousView.Id)) {
            break label108;
          }
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10090, "1,0");
          if ((!com.tencent.mm.r.a.ce(bb.f(bb.this))) && (!com.tencent.mm.r.a.cc(bb.f(bb.this))))
          {
            paramAnonymousView = com.tencent.mm.az.h.a(af.getAccPath(), paramAnonymousView, 8);
            paramAnonymousView.hnH = bb.g(bb.this);
            com.tencent.mm.az.a.c(paramAnonymousView);
          }
        }
        for (;;)
        {
          bb.this.notifyDataSetChanged();
          AppMethodBeat.o(163121);
          return;
          label108:
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10231, "1");
          com.tencent.mm.az.a.azD();
        }
      }
    };
    this.userName = paramString;
    this.djj = paramActivity;
    this.xDb = paramf;
    this.xDf = paramc;
    this.xwF = af.dti();
    paramf = ac.f(this.djj.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0));
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(paramf)));
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
    this.sOz = paramActivity;
    this.country = ac.f(this.djj.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0));
    g.afC();
    paramActivity = (String)g.afB().afk().get(2, null);
    if (this.userName.equals(paramActivity)) {
      this.diE = true;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.diE) {
      this.xCZ = com.tencent.mm.storage.bc.eLI();
    }
    for (;;)
    {
      this.xDd = new bc(new bc.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99016);
          if (!bb.a(bb.this))
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bb.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            paramAnonymousList = bb.this;
            if (!bb.b(bb.this).isEmpty()) {
              break label77;
            }
          }
          label77:
          for (long l = 0L;; l = ((p)bb.b(bb.this).get(bb.b(bb.this).size() - 1)).field_snsId)
          {
            bb.a(paramAnonymousList, com.tencent.mm.plugin.sns.data.q.su(l));
            AppMethodBeat.o(99016);
            return;
          }
        }
        
        public final void dBL()
        {
          AppMethodBeat.i(99017);
          if (!bb.a(bb.this))
          {
            bb.c(bb.this);
            bb.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.dBM();
            }
          }
          AppMethodBeat.o(99017);
        }
      }, paramString, this.diE);
      this.xDe = new bd(new bc.a()
      {
        public final void b(List<p> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99018);
          if (bb.a(bb.this))
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bb.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            bb.d(bb.this);
          }
          AppMethodBeat.o(99018);
        }
        
        public final void dBL()
        {
          AppMethodBeat.i(99019);
          if (bb.a(bb.this))
          {
            bb.c(bb.this);
            bb.this.notifyDataSetChanged();
            if (paramc != null) {
              paramc.dBM();
            }
          }
          AppMethodBeat.o(99019);
        }
      }, this.diE);
      to(0L);
      qr(false);
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
      g.afC();
      paramActivity = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
      if ((paramActivity != null) && (com.tencent.mm.n.b.ls(paramActivity.field_type))) {
        this.xCZ = com.tencent.mm.storage.bc.eLH();
      } else {
        this.xCZ = com.tencent.mm.storage.bc.eLJ();
      }
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, d paramd, int paramInt3)
  {
    AppMethodBeat.i(99044);
    p localp = (p)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localp.dxy();
    SnsObject localSnsObject = com.tencent.mm.plugin.sns.model.aj.t(localp);
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
    if ((this.diE) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localp.field_userName)))
    {
      paramTextView3.setBackgroundResource(2131233602);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (com.tencent.mm.plugin.sns.model.aj.ap(localp.field_localPrivate, this.diE))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233596);
        localObject = this.xwF.aHY(localp.field_userName);
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
      paramInt1 = localp.xiB;
      paramTextView1 = new f.a();
      paramTextView1.dzf = paramInt1;
      if (this.xDa.get(Integer.valueOf(paramInt3)) == null) {
        break label677;
      }
      paramTextView1.position = ((Integer)this.xDa.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new com.tencent.mm.storage.bc(this.xCZ.tag);
      paramTextView1.tGD = localp.field_createTime;
      if (localTimeLineObject.Etm.DaB != 1) {
        break label685;
      }
      paramQFadeImageView.setVisibility(0);
      af.dtr().a(localTimeLineObject.Etm.DaC, paramQFadeImageView, this.djj.hashCode(), f.a.wEC, paramTextView1);
      label367:
      if ((localp.dtd()) && (localp.dxZ()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131233594);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.Etm.DaC == null) || (localTimeLineObject.Etm.DaC.size() <= 1)) {
          break label808;
        }
        paramd.xDO.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.Etm.DaC.size();
        paramTextView2.setText(this.djj.getResources().getQuantityString(2131623966, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.Etj;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        paramd.xDO.setVisibility(0);
        paramd.xDJ.setVisibility(0);
        paramd.xDJ.aq(com.tencent.mm.pluginsdk.ui.span.k.b(this.djj, paramQFadeImageView, paramd.xDJ.getTextSize()));
      }
      AppMethodBeat.o(99044);
      return;
      label559:
      localObject = ((com.tencent.mm.n.b)localObject).ZX();
      break;
      if (!com.tencent.mm.plugin.sns.model.aj.ap(localp.field_localPrivate, this.diE)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(2131233596);
      localObject = this.xwF.aHY(localp.field_userName);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((com.tencent.mm.n.b)localObject).ZX())
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
      if (localTimeLineObject.Etm.DaB == 2)
      {
        paramTextView4.setText(bt.by(localTimeLineObject.Etm.Desc, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.Etm.DaB != 21) {
        break label367;
      }
      localp.dxQ();
      boolean bool = true;
      if (this.diE) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        af.dtr().a(localTimeLineObject.Etm.DaC, paramQFadeImageView, this.djj.hashCode(), f.a.wEC, paramTextView1, bool);
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (this.isSearchMode)
    {
      if ((i != 0) && (paramInt2 != i))
      {
        eH(paramTextView);
        paramTextView.setText(String.format(this.djj.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        p(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (i == 0)
    {
      if (bg.getYear() != paramInt2)
      {
        eH(paramTextView);
        paramTextView.setText(String.format(this.djj.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        p(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (paramInt2 != i)
    {
      eH(paramTextView);
      paramTextView.setText(String.format(this.djj.getResources().getString(2131764061), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      p(paramTextView);
    }
    AppMethodBeat.o(99040);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(99039);
    Object localObject = this.djj;
    if (!this.sOz.equals("en")) {}
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
      localObject[0] = bg.E(this.djj, localObject[0], this.sOz);
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
  
  protected static boolean aqB(String paramString)
  {
    AppMethodBeat.i(99054);
    com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
    if ((localf != null) && (com.tencent.mm.az.a.e(localf)) && (paramString.equals(localf.hnp)) && (com.tencent.mm.az.a.azF()))
    {
      AppMethodBeat.o(99054);
      return true;
    }
    AppMethodBeat.o(99054);
    return false;
  }
  
  private boolean av(int paramInt, long paramLong)
  {
    return (!this.isSearchMode) || ((paramInt == 0) && (this.wGj == paramLong)) || (paramInt > 0) || (this.xDk);
  }
  
  private static boolean dAV()
  {
    AppMethodBeat.i(163123);
    if ((am.a.dtY() & 0x1) <= 0)
    {
      AppMethodBeat.o(163123);
      return true;
    }
    AppMethodBeat.o(163123);
    return false;
  }
  
  private void eH(View paramView)
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
      localLayoutParams.topMargin = this.djj.getResources().getDimensionPixelSize(2131166851);
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
      localView = y.js(this.djj).inflate(2131495575, null);
      localb.xDs = localView.findViewById(2131298764);
      localb.xDu = ((TextView)localView.findViewById(2131304967));
      localb.xDt = ((TextView)localView.findViewById(2131305007));
      localb.xDv = ((TextView)localView.findViewById(2131305106));
      localb.xDy = ((TextView)localView.findViewById(2131296470));
      localb.xkg = localView.findViewById(2131301422);
      localb.xDy = ((TextView)localView.findViewById(2131296470));
      localb.xDw = ((LinearLayout)localView.findViewById(2131301423));
      localb.xDx = ((ImageView)localView.findViewById(2131301549));
      localb.xkf = ((LinearLayout)localView.findViewById(2131301456));
      localb.nkd = ((MMNeat7extView)localView.findViewById(2131299008));
      localb.xDB = ((TagImageView)localView.findViewById(2131300948));
      localb.xkO = ((ImageView)localView.findViewById(2131305185));
      localb.titleTv = ((TextView)localView.findViewById(2131305950));
      localb.xDD = ((TextView)localView.findViewById(2131304202));
      localb.xDs.setOnClickListener(this.xDb.xDW);
      localb.xDE = localView.findViewById(2131302207);
      localb.xDz = ((LinearLayout)localView.findViewById(2131300304));
      localb.xDA = ((TextView)localView.findViewById(2131305022));
      localb.xDA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99023);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("enter_scene", e.i.FIg);
          d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(8) });
          AppMethodBeat.o(99023);
        }
      });
      localView.setTag(localb);
      com.tencent.mm.plugin.sns.data.q.b(localb.xDB, this.djj);
      localb.xDv.setTag(Integer.valueOf(paramInt));
      if (this.xjN.get(Integer.valueOf(paramInt)) == null) {
        break label1976;
      }
    }
    label790:
    label1049:
    label1062:
    label1070:
    label1463:
    label1976:
    for (int i = ((Integer)this.xjN.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.xjQ) || (i == -1))
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
        com.tencent.mm.plugin.sns.model.aj.ap(paramView.field_localPrivate, this.diE);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.xjO.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.xjO.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject1 = (p)getItem(i);
        TimeLineObject localTimeLineObject = ((p)localObject1).dxy();
        label846:
        Object localObject2;
        if (((this.diE) && (paramInt == 0)) || (j == -1) || (((p)localObject1).field_head != j))
        {
          if (av(paramInt, ((p)localObject1).field_snsId))
          {
            long l = ((p)localObject1).field_createTime;
            a(localb.xDt, localb.xDu, l);
          }
          if (localTimeLineObject.Etk != null)
          {
            if (!bt.isNullOrNil(localTimeLineObject.Etk.goQ)) {
              break label1037;
            }
            paramView = localTimeLineObject.Etk.ijO;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.xDy.setText(paramView);
              localb.xDy.setVisibility(0);
            }
          }
          localb.xkg.setVisibility(0);
        }
        else
        {
          a(localb.xDv, j, ((p)localObject1).field_head);
          if ((this.xDj == 0L) || (((p)localObject1).field_snsId != this.xDj)) {
            break label1049;
          }
          localb.xDz.setVisibility(0);
          paramView = new f.a();
          paramView.dzf = ((p)localObject1).xiB;
          if (this.xDa.get(Integer.valueOf(paramInt)) == null) {
            break label1062;
          }
          paramView.position = ((Integer)this.xDa.get(Integer.valueOf(paramInt))).intValue();
          localb.xDs.setTag(paramView);
          if (bt.isNullOrNil(localTimeLineObject.Etj)) {
            break label1070;
          }
          localb.nkd.setVisibility(0);
          localb.nkd.aq(com.tencent.mm.pluginsdk.ui.span.k.b(this.djj, localTimeLineObject.Etj, localb.nkd.getTextSize()));
          localb.xDw.setVisibility(0);
          localb.nkd.setMaxLines(1);
          localb.nkd.getWrappedTextView().setSingleLine(true);
          localb.xDE.setVisibility(0);
          paramInt = localTimeLineObject.Etm.DaB;
          localObject2 = new com.tencent.mm.storage.bc(this.xCZ.tag);
          ((com.tencent.mm.storage.bc)localObject2).tGD = ((p)localObject1).field_createTime;
          if (paramInt != 2) {
            break label1083;
          }
          localb.nkd.setVisibility(0);
          localb.nkd.getWrappedTextView().setSingleLine(false);
          localb.nkd.setMaxLines(2);
          localb.xDE.setVisibility(8);
        }
        label1083:
        bpi localbpi;
        for (;;)
        {
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(163122);
          return localView;
          paramView = localTimeLineObject.Etk.goQ;
          break;
          localb.xDz.setVisibility(8);
          break label790;
          paramView.position = 0;
          break label846;
          localb.nkd.setVisibility(8);
          break label903;
          if (paramInt != 4) {
            break label1424;
          }
          if (!localTimeLineObject.Etm.DaC.isEmpty())
          {
            localb.xDB.setVisibility(0);
            localb.xkO.setVisibility(0);
            localb.xDE.setVisibility(0);
            localb.titleTv.setMaxLines(1);
            localb.titleTv.setTextColor(this.djj.getResources().getColor(2131100914));
            localbpi = (bpi)localTimeLineObject.Etm.DaC.get(0);
            af.dtr().a(localbpi, localb.xDB, 2131689564, this.djj.hashCode(), f.a.wEC, (com.tencent.mm.storage.bc)localObject2);
            localb.xkO.setPressed(false);
            if (aqB(localTimeLineObject.Id))
            {
              localb.xkO.setImageResource(2131233393);
              label1235:
              localb.xDB.setTag(localTimeLineObject);
              localb.xDB.setOnClickListener(this.xDo);
              localbpi.dzf = ((p)localObject1).xiB;
              localb.xDE.setTag(localTimeLineObject);
              localObject1 = localbpi.Desc;
              if (bt.isNullOrNil((String)localObject1)) {
                break label1386;
              }
              localb.xDD.setVisibility(0);
              localb.xDD.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = localbpi.Title;
              if (bt.isNullOrNil((String)localObject1)) {
                break label1398;
              }
              localb.titleTv.setVisibility(0);
              localb.titleTv.setTag(paramView);
              localb.titleTv.setOnTouchListener(new ad());
              localb.titleTv.setText((CharSequence)localObject1);
              break;
              localb.xkO.setImageResource(2131233395);
              break label1235;
              label1386:
              localb.xDD.setVisibility(4);
            }
            label1398:
            localb.titleTv.setVisibility(8);
          }
          else
          {
            localb.xDE.setVisibility(8);
          }
        }
        localb.titleTv.setTextColor(this.djj.getResources().getColor(2131099732));
        if (dAV())
        {
          paramView = be.aqC(localTimeLineObject.Etm.Url);
          localObject1 = localTimeLineObject.Etm.Title;
          if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
            break label1967;
          }
          localObject1 = ((String)localObject1).substring(0, 40) + "...";
        }
        for (;;)
        {
          if (localb.xDB != null) {
            localb.xDB.setOnClickListener(null);
          }
          localb.xkO.setVisibility(8);
          if (!localTimeLineObject.Etm.DaC.isEmpty())
          {
            localb.xDB.setVisibility(0);
            localbpi = (bpi)localTimeLineObject.Etm.DaC.get(0);
            if (localTimeLineObject.Etm.DaB == 5)
            {
              paramView = be.aqC(localbpi.Url);
              localObject1 = localbpi.Title;
              localb.xkO.setVisibility(0);
              af.dtr().a(localbpi, localb.xDB, 2131689581, this.djj.hashCode(), f.a.wEC, (com.tencent.mm.storage.bc)localObject2);
              label1649:
              localObject2 = paramView;
              if (localTimeLineObject.Etm.DaF != null)
              {
                localObject2 = paramView;
                if (localTimeLineObject.Etm.DaF.gGA == 1) {
                  localObject2 = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131761345);
                }
              }
              if (bt.isNullOrNil((String)localObject2)) {
                break label1916;
              }
              localb.xDD.setVisibility(0);
              localb.xDD.setText((CharSequence)localObject2);
              if (bt.isNullOrNil((String)localObject1)) {
                break label1954;
              }
              if (localb.xDD.getVisibility() != 8) {
                break label1929;
              }
              localb.titleTv.setMaxLines(2);
              label1749:
              localb.titleTv.setVisibility(0);
              if ((localTimeLineObject.gHj & 0x1) <= 0) {
                break label1941;
              }
              localb.titleTv.setText(com.tencent.mm.plugin.sns.data.q.a((String)localObject1, this.djj, localb.titleTv));
            }
          }
          for (;;)
          {
            if ((localTimeLineObject.Ets == null) || (localTimeLineObject.Ets.subType != 1)) {
              break label1965;
            }
            localb.xkO.setVisibility(0);
            localb.xkO.setImageResource(2131234474);
            break;
            paramView = "";
            break label1463;
            af.dtr().a(localbpi, localb.xDB, this.djj.hashCode(), f.a.wEC, (com.tencent.mm.storage.bc)localObject2);
            break label1649;
            if (localTimeLineObject.Etm.DaB != 26)
            {
              localb.xDB.setVisibility(8);
              break label1649;
            }
            localb.xDB.setVisibility(0);
            localb.xDB.setImageResource(2131690949);
            break label1649;
            label1916:
            localb.xDD.setVisibility(8);
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
    if (this.xDl <= 0) {
      paramTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99020);
          new Rect();
          paramTextView.measure(0, 0);
          bb.a(bb.this, paramTextView.getMeasuredHeight());
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", new Object[] { Integer.valueOf(bb.e(bb.this)) });
          AppMethodBeat.o(99020);
        }
      });
    }
    AppMethodBeat.o(99041);
  }
  
  private void qr(boolean paramBoolean)
  {
    AppMethodBeat.i(99046);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.pLA);
    if (this.xDd != null)
    {
      if (this.isSearchMode)
      {
        this.xDe.ac(this.xDc, paramBoolean);
        AppMethodBeat.o(99046);
        return;
      }
      this.xDd.g(this.pLA, this.xDc, paramBoolean);
    }
    AppMethodBeat.o(99046);
  }
  
  private void to(long paramLong)
  {
    AppMethodBeat.i(99050);
    Object localObject = com.tencent.mm.plugin.sns.data.q.su(af.dtu().a(paramLong, af.dtk().aoJ(this.userName), this.userName, this.diE));
    if (this.xrA.equals("")) {}
    for (;;)
    {
      this.pLA = ((String)localObject);
      localObject = af.dty().apP(this.userName).dxP();
      if (((afv)localObject).DfN != 0L) {
        break;
      }
      AppMethodBeat.o(99050);
      return;
      if (((String)localObject).compareTo(this.xrA) >= 0) {
        localObject = this.xrA;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.su(((afv)localObject).DfN);
    if (this.pLA.equals(""))
    {
      this.pLA = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
    }
    if (((String)localObject).compareTo(this.pLA) > 0) {}
    for (;;)
    {
      this.pLA = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
      localObject = this.pLA;
    }
  }
  
  public final void a(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99045);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (this.xDf != null) {
        this.xDf.dBM();
      }
      AppMethodBeat.o(99045);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    this.list.clear();
    this.xjN.clear();
    this.xjO.clear();
    this.xDa.clear();
    int i = 0;
    while (i < j)
    {
      p localp = p.H((p)paramList.get(i));
      this.list.add(localp);
      i += 1;
    }
    paramList = paramMap1.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
      this.xjN.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      this.xjO.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      this.xDa.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (this.diE)
    {
      if (this.list.size() <= 1) {}
      for (i = 2147483647;; i = ((p)this.list.get(1)).field_head)
      {
        this.xDg = 0;
        j = 0;
        while (j < this.list.size())
        {
          if ((!this.diE) || (j != 0))
          {
            if (i != ((p)this.list.get(j)).field_head) {
              break;
            }
            this.xDg = Math.max(this.xDg, ((p)this.list.get(j)).field_createTime);
          }
          j += 1;
        }
      }
    }
    if (this.list.isEmpty()) {}
    for (i = 2147483647;; i = ((p)this.list.get(0)).field_head) {
      break;
    }
    if ((this.list.isEmpty()) || ((this.diE) && (this.list.size() == 1))) {
      this.xDg = 2147483647;
    }
    if (this.list.isEmpty()) {}
    for (i = 0;; i = ((p)this.list.get(this.list.size() - 1)).field_head)
    {
      this.xDh = 2147483647;
      j = this.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((p)this.list.get(j)).field_head))
      {
        this.xDh = Math.min(this.xDh, ((p)this.list.get(j)).field_createTime);
        j -= 1;
      }
    }
    if (this.list.isEmpty()) {
      this.xDh = 0;
    }
    this.xjQ = paramInt1;
    this.xjP = paramInt2;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + this.xDg + " edTIme " + this.xDh);
    notifyDataSetChanged();
    AppMethodBeat.o(99045);
  }
  
  public final void dBJ()
  {
    this.xDk = true;
    if (this.isSearchMode) {
      this.xDe.xEg = true;
    }
  }
  
  public final void dBK()
  {
    AppMethodBeat.i(99049);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((p)this.list.get(this.list.size() - 1)).field_snsId)
    {
      to(l);
      AppMethodBeat.o(99049);
      return;
    }
  }
  
  public final void dzc()
  {
    AppMethodBeat.i(99048);
    qr(true);
    notifyDataSetChanged();
    AppMethodBeat.o(99048);
  }
  
  public final int getCount()
  {
    return this.xjP;
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
    if ((this.diE) && (paramInt == 0) && ((!this.isSearchMode) || ((this.isSearchMode) && (this.xDk))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(99043);
      return 0;
    }
    if (this.xjN.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.xjN.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(99043);
        return 0;
      }
      p localp = (p)getItem(i);
      if (localp.dxy().Etm.DaB == 1)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(99043);
        return 0;
      }
      if (localp.dxy().Etm.DaB == 15)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(99043);
        return 2;
      }
      if (localp.dxy().Etm.DaB == 21)
      {
        AppMethodBeat.o(99043);
        return 3;
      }
      if ((localp.dxy().Etm.DaB == 28) || (localp.dxy().Etm.DaB == 29))
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(i)));
    Object localObject1;
    int j;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
      {
        paramViewGroup = new d();
        paramView = y.js(this.djj).inflate(2131495576, null);
        paramViewGroup.xDu = ((TextView)paramView.findViewById(2131304967));
        paramViewGroup.xDt = ((TextView)paramView.findViewById(2131305007));
        paramViewGroup.xDv = ((TextView)paramView.findViewById(2131305106));
        paramViewGroup.xDF = ((MaskImageView)paramView.findViewById(2131300977));
        paramViewGroup.xDG = ((QFadeImageView)paramView.findViewById(2131305641));
        paramViewGroup.xDH = ((MaskImageView)paramView.findViewById(2131300978));
        paramViewGroup.xDI = ((MaskImageView)paramView.findViewById(2131300979));
        paramViewGroup.xDJ = ((MMNeat7extView)paramView.findViewById(2131298996));
        paramViewGroup.xDK = ((TextView)paramView.findViewById(2131307000));
        paramViewGroup.xDL = ((TextView)paramView.findViewById(2131307001));
        paramViewGroup.xDM = ((TextView)paramView.findViewById(2131307002));
        paramViewGroup.xDN = ((TextView)paramView.findViewById(2131300986));
        paramViewGroup.xDO = paramView.findViewById(2131299002);
        paramViewGroup.xDy = ((TextView)paramView.findViewById(2131296470));
        paramViewGroup.xDw = ((LinearLayout)paramView.findViewById(2131301423));
        paramViewGroup.xDx = ((ImageView)paramView.findViewById(2131301549));
        paramViewGroup.xkf = ((LinearLayout)paramView.findViewById(2131301456));
        paramViewGroup.xkg = paramView.findViewById(2131301422);
        paramViewGroup.xDG.setOnClickListener(this.xDb.xjW);
        paramViewGroup.xDF.setOnClickListener(this.xDb.xjW);
        paramViewGroup.xDH.setOnClickListener(this.xDb.xjX);
        paramViewGroup.xDI.setOnClickListener(this.xDb.xjY);
        paramViewGroup.xDF.setOnLongClickListener(this.xDb.xDZ);
        paramViewGroup.xDH.setOnLongClickListener(this.xDb.xDZ);
        paramViewGroup.xDI.setOnLongClickListener(this.xDb.xDZ);
        paramViewGroup.xDP = ((TextView)paramView.findViewById(2131306862));
        paramViewGroup.xDQ = ((TextView)paramView.findViewById(2131306863));
        paramViewGroup.xDR = ((TextView)paramView.findViewById(2131306864));
        paramViewGroup.xDS = ((TextView)paramView.findViewById(2131306096));
        paramViewGroup.xDT = ((TextView)paramView.findViewById(2131306097));
        paramViewGroup.xDU = ((TextView)paramView.findViewById(2131306098));
        paramViewGroup.xDV = ((MaskLinearLayout)paramView.findViewById(2131305003));
        paramViewGroup.xDV.b(paramViewGroup.xDF);
        paramViewGroup.xDz = ((LinearLayout)paramView.findViewById(2131300304));
        paramViewGroup.xDA = ((TextView)paramView.findViewById(2131305022));
        paramViewGroup.xDA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99022);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("enter_scene", e.i.FIg);
            d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(8) });
            AppMethodBeat.o(99022);
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        af.dtr().eo(paramViewGroup.xDF);
        af.dtr().eo(paramViewGroup.xDH);
        af.dtr().eo(paramViewGroup.xDI);
        i = -1;
        if (this.xjN.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.xjN.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.xDv.setTag(Integer.valueOf(paramInt));
        paramViewGroup.xDV.settouchEnable(false);
        paramViewGroup.xDV.setBackgroundResource(0);
        paramViewGroup.xDV.setDescendantFocusability(131072);
        paramViewGroup.xDV.setClickable(false);
        paramViewGroup.xDF.settouchEnable(true);
        paramViewGroup.xDF.setClickable(true);
        paramViewGroup.xDF.setLongClickable(false);
        paramViewGroup.xDH.setLongClickable(false);
        paramViewGroup.xDI.setLongClickable(false);
        paramViewGroup.xDV.setOnClickListener(null);
        paramViewGroup.xDV.setOnLongClickListener(null);
        paramViewGroup.xDV.setLongClickable(false);
        if ((i < this.xjQ) && (i != -1)) {
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
      com.tencent.mm.plugin.sns.model.aj.ap(((p)localObject1).field_localPrivate, this.diE);
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
      if (this.xjO.get(Integer.valueOf(paramInt)) != null) {}
      label1094:
      label6215:
      label6221:
      for (int k = ((Integer)this.xjO.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        Object localObject2 = (p)getItem(i);
        localObject1 = ((p)localObject2).dxy();
        long l;
        if (((this.diE) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
        {
          if (av(paramInt, ((p)localObject2).field_snsId))
          {
            l = ((p)localObject2).field_createTime;
            a(paramViewGroup.xDt, paramViewGroup.xDu, l);
          }
          if (((TimeLineObject)localObject1).Etk != null)
          {
            if (!bt.isNullOrNil(((TimeLineObject)localObject1).Etk.goQ)) {
              break label1287;
            }
            localObject1 = ((TimeLineObject)localObject1).Etk.ijO;
            if ((localObject1 != null) && (!((String)localObject1).equals("")))
            {
              paramViewGroup.xDy.setText((CharSequence)localObject1);
              paramViewGroup.xDy.setVisibility(0);
            }
          }
          paramViewGroup.xkg.setVisibility(0);
        }
        else
        {
          if ((this.xDj == 0L) || (((p)localObject2).field_snsId != this.xDj)) {
            break label1300;
          }
          paramViewGroup.xDz.setVisibility(0);
          paramViewGroup.xDw.setVisibility(0);
          if ((!this.diE) || (paramInt != 0) || ((this.isSearchMode) && ((!this.isSearchMode) || (!this.xDk)))) {
            break label1319;
          }
          paramViewGroup.xDG.setVisibility(0);
          paramViewGroup.xDG.setContentDescription(this.djj.getString(2131764020));
          paramViewGroup.xDF.setVisibility(8);
          localObject2 = paramViewGroup.xDJ;
          if (this.xjP != 1) {
            break label1312;
          }
        }
        for (localObject1 = this.djj.getString(2131764063);; localObject1 = "")
        {
          ((MMNeat7extView)localObject2).aq((CharSequence)localObject1);
          paramViewGroup.xDJ.setVisibility(0);
          paramViewGroup.xDO.setVisibility(0);
          paramViewGroup.xDN.setVisibility(8);
          af.dtr().c(paramViewGroup.xDG, 2131100942, 2131234148, this.djj.hashCode());
          localObject1 = new f.a();
          ((f.a)localObject1).dzf = -1;
          ((f.a)localObject1).position = -1;
          paramViewGroup.xDG.setTag(localObject1);
          AppMethodBeat.o(99038);
          return paramView;
          localObject1 = ((TimeLineObject)localObject1).Etk.goQ;
          break;
          paramViewGroup.xDz.setVisibility(8);
          break label1094;
        }
        a(paramViewGroup.xDv, j, ((p)localObject2).field_head);
        if (k > 0)
        {
          a(i, paramViewGroup.xDF, paramViewGroup.xDK, paramViewGroup.xDN, paramViewGroup.xDP, paramViewGroup.xDS, 1, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.f.wQY.D((p)getItem(i));
        }
        if (k >= 2)
        {
          a(i + 1, paramViewGroup.xDH, paramViewGroup.xDL, paramViewGroup.xDN, paramViewGroup.xDQ, paramViewGroup.xDT, 2, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.f.wQY.D((p)getItem(i + 1));
        }
        if (k >= 3)
        {
          a(i + 2, paramViewGroup.xDI, paramViewGroup.xDM, paramViewGroup.xDN, paramViewGroup.xDR, paramViewGroup.xDU, 3, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.f.wQY.D((p)getItem(i + 2));
        }
        if (k == 1)
        {
          localObject1 = (p)getItem(i);
          if ((!bt.isNullOrNil(((p)localObject1).dxy().Etj)) && (((p)localObject1).field_type == 1))
          {
            paramViewGroup.xDV.setDescendantFocusability(393216);
            paramViewGroup.xDV.setClickable(true);
            paramViewGroup.xDF.setClickable(false);
            paramViewGroup.xDF.settouchEnable(false);
            paramViewGroup.xDV.setOnClickListener(this.xDb.xjW);
            paramViewGroup.xDV.settouchEnable(true);
            i = ((p)localObject2).xiB;
            localObject2 = new f.a();
            ((f.a)localObject2).dzf = i;
            if (this.xDa.get(Integer.valueOf(paramInt)) == null) {
              break label1702;
            }
          }
        }
        for (((f.a)localObject2).position = ((Integer)this.xDa.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject2).position = 0)
        {
          if ((((p)localObject1).dtd()) && (((p)localObject1).dxZ())) {
            paramViewGroup.xDV.setOnLongClickListener(this.xDb.xDZ);
          }
          paramViewGroup.xDV.setTag(localObject2);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(99038);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
          {
            paramViewGroup = new e();
            paramView = y.js(this.djj).inflate(2131495590, null);
            paramViewGroup.xDu = ((TextView)paramView.findViewById(2131304967));
            paramViewGroup.xDt = ((TextView)paramView.findViewById(2131305007));
            paramViewGroup.xDv = ((TextView)paramView.findViewById(2131305106));
            paramViewGroup.xDF = ((MaskImageView)paramView.findViewById(2131300977));
            paramViewGroup.xDy = ((TextView)paramView.findViewById(2131296470));
            paramViewGroup.xDw = ((LinearLayout)paramView.findViewById(2131301423));
            paramViewGroup.xDx = ((ImageView)paramView.findViewById(2131301549));
            paramViewGroup.xkf = ((LinearLayout)paramView.findViewById(2131301456));
            paramViewGroup.xkg = paramView.findViewById(2131301422);
            paramViewGroup.xDF.setOnClickListener(this.xDb.xDY);
            paramViewGroup.xDP = ((TextView)paramView.findViewById(2131306862));
            paramViewGroup.xDV = ((MaskLinearLayout)paramView.findViewById(2131305003));
            paramViewGroup.xDV.b(paramViewGroup.xDF);
            paramViewGroup.xDJ = ((MMNeat7extView)paramView.findViewById(2131298996));
            paramViewGroup.xDO = paramView.findViewById(2131299002);
            paramViewGroup.xDz = ((LinearLayout)paramView.findViewById(2131300304));
            paramViewGroup.xDA = ((TextView)paramView.findViewById(2131305022));
            paramViewGroup.xDA.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(99021);
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("enter_scene", e.i.FIg);
                d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(8) });
                AppMethodBeat.o(99021);
              }
            });
            paramView.setTag(paramViewGroup);
            af.dtr().eo(paramViewGroup.xDF);
            if (this.xjN.get(Integer.valueOf(paramInt)) == null) {
              break label6233;
            }
          }
        }
        label3800:
        label5592:
        label6233:
        for (i = ((Integer)this.xjN.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.xDv.setTag(Integer.valueOf(paramInt));
          paramViewGroup.xDV.settouchEnable(false);
          paramViewGroup.xDV.setBackgroundResource(0);
          paramViewGroup.xDV.setDescendantFocusability(131072);
          paramViewGroup.xDV.setClickable(false);
          paramViewGroup.xDF.settouchEnable(true);
          paramViewGroup.xDF.setClickable(true);
          paramViewGroup.xDV.setOnClickListener(null);
          if ((i >= this.xjQ) || (i == -1))
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
            com.tencent.mm.plugin.sns.model.aj.ap(((p)localObject1).field_localPrivate, this.diE);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.xjO.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.xjO.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject2 = (p)getItem(i);
            Object localObject3 = ((p)localObject2).dxy();
            if (((this.diE) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
            {
              if (av(paramInt, ((p)localObject2).field_snsId))
              {
                l = ((p)localObject2).field_createTime;
                a(paramViewGroup.xDt, paramViewGroup.xDu, l);
              }
              if (((TimeLineObject)localObject3).Etk != null)
              {
                if (!bt.isNullOrNil(((TimeLineObject)localObject3).Etk.goQ)) {
                  break label2832;
                }
                localObject1 = ((TimeLineObject)localObject3).Etk.ijO;
                if ((localObject1 != null) && (!((String)localObject1).equals("")))
                {
                  paramViewGroup.xDy.setText((CharSequence)localObject1);
                  paramViewGroup.xDy.setVisibility(0);
                }
              }
              paramViewGroup.xkg.setVisibility(0);
            }
            else
            {
              a(paramViewGroup.xDv, j, ((p)localObject2).field_head);
              if ((this.xDj == 0L) || (((p)localObject2).field_snsId != this.xDj)) {
                break label2845;
              }
              paramViewGroup.xDz.setVisibility(0);
              paramViewGroup.xDw.setVisibility(0);
              localObject1 = new com.tencent.mm.storage.bc(this.xCZ.tag);
              ((com.tencent.mm.storage.bc)localObject1).tGD = ((p)localObject2).field_createTime;
              paramViewGroup.xDF.setVisibility(0);
              af.dtr().a(((TimeLineObject)localObject3).Etm.DaC, paramViewGroup.xDF, this.djj.hashCode(), f.a.wEC, (com.tencent.mm.storage.bc)localObject1);
              if (com.tencent.mm.plugin.sns.model.aj.ap(((p)localObject2).field_localPrivate, this.diE))
              {
                paramViewGroup.xDP.setVisibility(0);
                paramViewGroup.xDP.setBackgroundResource(2131233596);
                localObject1 = this.xwF.aHY(((p)localObject2).field_userName);
                if (localObject1 != null) {
                  ((com.tencent.mm.n.b)localObject1).ZX();
                }
              }
              localObject1 = (p)getItem(i);
              localObject3 = ((p)localObject1).dxy().Etj;
              if ((localObject3 != null) && (!((String)localObject3).equals("")))
              {
                paramViewGroup.xDO.setVisibility(0);
                paramViewGroup.xDJ.setVisibility(0);
                paramViewGroup.xDJ.aq(com.tencent.mm.pluginsdk.ui.span.k.b(this.djj, (CharSequence)localObject3, paramViewGroup.xDJ.getTextSize()));
              }
              paramViewGroup.xDV.setDescendantFocusability(393216);
              paramViewGroup.xDV.setClickable(true);
              paramViewGroup.xDF.setClickable(false);
              paramViewGroup.xDF.settouchEnable(false);
              paramViewGroup.xDV.setOnClickListener(this.xDb.xDY);
              paramViewGroup.xDV.settouchEnable(true);
              i = ((p)localObject2).xiB;
              localObject2 = new f.a();
              ((f.a)localObject2).dzf = i;
              if (this.xDa.get(Integer.valueOf(paramInt)) == null) {
                break label2857;
              }
            }
            for (((f.a)localObject2).position = ((Integer)this.xDa.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject2).position = 0)
            {
              paramViewGroup.xDV.setTag(localObject2);
              paramView.setDrawingCacheEnabled(false);
              com.tencent.mm.plugin.sns.k.f.wQY.D((p)localObject1);
              AppMethodBeat.o(99038);
              return paramView;
              localObject1 = ((TimeLineObject)localObject3).Etk.goQ;
              break;
              paramViewGroup.xDz.setVisibility(8);
              break label2476;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof d)))
              {
                paramViewGroup = new d();
                paramView = y.js(this.djj).inflate(2131495576, null);
                paramViewGroup.xDu = ((TextView)paramView.findViewById(2131304967));
                paramViewGroup.xDt = ((TextView)paramView.findViewById(2131305007));
                paramViewGroup.xDv = ((TextView)paramView.findViewById(2131305106));
                paramViewGroup.xDF = ((MaskImageView)paramView.findViewById(2131300977));
                paramViewGroup.xDG = ((QFadeImageView)paramView.findViewById(2131305641));
                paramViewGroup.xDH = ((MaskImageView)paramView.findViewById(2131300978));
                paramViewGroup.xDI = ((MaskImageView)paramView.findViewById(2131300979));
                paramViewGroup.xDJ = ((MMNeat7extView)paramView.findViewById(2131298996));
                paramViewGroup.xDK = ((TextView)paramView.findViewById(2131307000));
                paramViewGroup.xDL = ((TextView)paramView.findViewById(2131307001));
                paramViewGroup.xDM = ((TextView)paramView.findViewById(2131307002));
                paramViewGroup.xDN = ((TextView)paramView.findViewById(2131300986));
                paramViewGroup.xDO = paramView.findViewById(2131299002);
                paramViewGroup.xDy = ((TextView)paramView.findViewById(2131296470));
                paramViewGroup.xDw = ((LinearLayout)paramView.findViewById(2131301423));
                paramViewGroup.xDx = ((ImageView)paramView.findViewById(2131301549));
                paramViewGroup.xkf = ((LinearLayout)paramView.findViewById(2131301456));
                paramViewGroup.xkg = paramView.findViewById(2131301422);
                paramViewGroup.xDG.setOnClickListener(this.xDb.xDX);
                paramViewGroup.xDF.setOnClickListener(this.xDb.xDX);
                paramViewGroup.xDP = ((TextView)paramView.findViewById(2131306862));
                paramViewGroup.xDQ = ((TextView)paramView.findViewById(2131306863));
                paramViewGroup.xDR = ((TextView)paramView.findViewById(2131306864));
                paramViewGroup.xDS = ((TextView)paramView.findViewById(2131306096));
                paramViewGroup.xDT = ((TextView)paramView.findViewById(2131306097));
                paramViewGroup.xDU = ((TextView)paramView.findViewById(2131306098));
                paramViewGroup.xDV = ((MaskLinearLayout)paramView.findViewById(2131305003));
                paramViewGroup.xDV.b(paramViewGroup.xDF);
                paramViewGroup.xDz = ((LinearLayout)paramView.findViewById(2131300304));
                paramViewGroup.xDA = ((TextView)paramView.findViewById(2131305022));
                paramViewGroup.xDA.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(99025);
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("enter_scene", e.i.FIg);
                    d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                    com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(8) });
                    AppMethodBeat.o(99025);
                  }
                });
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                af.dtr().eo(paramViewGroup.xDF);
                af.dtr().eo(paramViewGroup.xDH);
                af.dtr().eo(paramViewGroup.xDI);
                i = -1;
                if (this.xjN.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.xjN.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.xDv.setTag(Integer.valueOf(paramInt));
                paramViewGroup.xDV.settouchEnable(false);
                paramViewGroup.xDV.setBackgroundResource(0);
                paramViewGroup.xDV.setDescendantFocusability(131072);
                paramViewGroup.xDV.setClickable(false);
                paramViewGroup.xDF.settouchEnable(true);
                paramViewGroup.xDF.setClickable(true);
                paramViewGroup.xDV.setOnClickListener(null);
                if ((i < this.xjQ) && (i != -1)) {
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
              com.tencent.mm.plugin.sns.model.aj.ap(((p)localObject1).field_localPrivate, this.diE);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject2 = (p)getItem(i);
              localObject1 = ((p)localObject2).dxy();
              if (((this.diE) && (paramInt == 0)) || (j == -1) || (((p)localObject2).field_head != j))
              {
                if (av(paramInt, ((p)localObject2).field_snsId))
                {
                  l = ((p)localObject2).field_createTime;
                  a(paramViewGroup.xDt, paramViewGroup.xDu, l);
                }
                if (((TimeLineObject)localObject1).Etk != null)
                {
                  if (!bt.isNullOrNil(((TimeLineObject)localObject1).Etk.goQ)) {
                    break label3972;
                  }
                  localObject1 = ((TimeLineObject)localObject1).Etk.ijO;
                  if ((localObject1 != null) && (!((String)localObject1).equals("")))
                  {
                    paramViewGroup.xDy.setText((CharSequence)localObject1);
                    paramViewGroup.xDy.setVisibility(0);
                  }
                }
                paramViewGroup.xkg.setVisibility(0);
              }
              else
              {
                a(paramViewGroup.xDv, j, ((p)localObject2).field_head);
                if ((this.xDj == 0L) || (((p)localObject2).field_snsId != this.xDj)) {
                  break label3985;
                }
                paramViewGroup.xDz.setVisibility(0);
                paramViewGroup.xDw.setVisibility(0);
                if ((!this.diE) || (paramInt != 0)) {
                  break label4004;
                }
                paramViewGroup.xDG.setVisibility(0);
                paramViewGroup.xDG.setContentDescription(this.djj.getString(2131764020));
                paramViewGroup.xDF.setVisibility(8);
                localObject2 = paramViewGroup.xDJ;
                if (this.xjP != 1) {
                  break label3997;
                }
              }
              for (localObject1 = this.djj.getString(2131764063);; localObject1 = "")
              {
                ((MMNeat7extView)localObject2).aq((CharSequence)localObject1);
                paramViewGroup.xDJ.setVisibility(0);
                paramViewGroup.xDO.setVisibility(0);
                paramViewGroup.xDN.setVisibility(8);
                af.dtr().c(paramViewGroup.xDG, 2131100942, 2131234148, this.djj.hashCode());
                localObject1 = new f.a();
                ((f.a)localObject1).dzf = -1;
                ((f.a)localObject1).position = -1;
                paramViewGroup.xDG.setTag(localObject1);
                AppMethodBeat.o(99038);
                return paramView;
                localObject1 = ((TimeLineObject)localObject1).Etk.goQ;
                break;
                paramViewGroup.xDz.setVisibility(8);
                break label3800;
              }
              a(i, paramViewGroup.xDF, paramViewGroup.xDK, paramViewGroup.xDN, paramViewGroup.xDP, paramViewGroup.xDS, 1, paramViewGroup, paramInt);
              localObject1 = (p)getItem(i);
              if ((!bt.isNullOrNil(((p)localObject1).dxy().Etj)) && (((p)localObject1).field_type == 1))
              {
                paramViewGroup.xDV.setDescendantFocusability(393216);
                paramViewGroup.xDV.setClickable(true);
                paramViewGroup.xDF.setClickable(false);
                paramViewGroup.xDF.settouchEnable(false);
                paramViewGroup.xDV.setOnClickListener(this.xDb.xDX);
                paramViewGroup.xDV.settouchEnable(true);
                i = ((p)localObject2).xiB;
                localObject2 = new f.a();
                ((f.a)localObject2).dzf = i;
                if (this.xDa.get(Integer.valueOf(paramInt)) == null) {
                  break label4216;
                }
              }
              label4216:
              for (((f.a)localObject2).position = ((Integer)this.xDa.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject2).position = 0)
              {
                paramViewGroup.xDV.setTag(localObject2);
                com.tencent.mm.plugin.sns.k.f.wQY.D((p)localObject1);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 4) {
                if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof b)))
                {
                  localObject1 = new b();
                  localObject2 = y.js(this.djj).inflate(2131495575, null);
                  ((b)localObject1).xDs = ((View)localObject2).findViewById(2131298764);
                  ((b)localObject1).xDu = ((TextView)((View)localObject2).findViewById(2131304967));
                  ((b)localObject1).xDt = ((TextView)((View)localObject2).findViewById(2131305007));
                  ((b)localObject1).xDv = ((TextView)((View)localObject2).findViewById(2131305106));
                  ((b)localObject1).xDy = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).xkg = ((View)localObject2).findViewById(2131301422);
                  ((b)localObject1).xDy = ((TextView)((View)localObject2).findViewById(2131296470));
                  ((b)localObject1).xDw = ((LinearLayout)((View)localObject2).findViewById(2131301423));
                  ((b)localObject1).xDx = ((ImageView)((View)localObject2).findViewById(2131301549));
                  ((b)localObject1).xkf = ((LinearLayout)((View)localObject2).findViewById(2131301456));
                  ((b)localObject1).nkd = ((MMNeat7extView)((View)localObject2).findViewById(2131299008));
                  ((b)localObject1).xDB = ((TagImageView)((View)localObject2).findViewById(2131300948));
                  ((b)localObject1).xkO = ((ImageView)((View)localObject2).findViewById(2131305185));
                  ((b)localObject1).titleTv = ((TextView)((View)localObject2).findViewById(2131305950));
                  ((b)localObject1).xDD = ((TextView)((View)localObject2).findViewById(2131304202));
                  ((b)localObject1).xDs.setOnClickListener(this.xDb.xDW);
                  ((b)localObject1).xDE = ((View)localObject2).findViewById(2131302207);
                  ((b)localObject1).xDC = ((TextView)((View)localObject2).findViewById(2131298762));
                  ((b)localObject1).xDz = ((LinearLayout)((View)localObject2).findViewById(2131300304));
                  ((b)localObject1).xDA = ((TextView)((View)localObject2).findViewById(2131305022));
                  ((b)localObject1).xDA.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(99024);
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("enter_scene", e.i.FIg);
                      d.b(bb.f(bb.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.vKh.f(14098, new Object[] { Integer.valueOf(8) });
                      AppMethodBeat.o(99024);
                    }
                  });
                  ((View)localObject2).setTag(localObject1);
                  com.tencent.mm.plugin.sns.data.q.b(((b)localObject1).xDB, this.djj);
                  ((b)localObject1).xDv.setTag(Integer.valueOf(paramInt));
                  if (this.xjN.get(Integer.valueOf(paramInt)) == null) {
                    break label6215;
                  }
                }
              }
              for (i = ((Integer)this.xjN.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                ((b)localObject1).init();
                if ((i >= this.xjQ) || (i == -1))
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
                  com.tencent.mm.plugin.sns.model.aj.ap(paramView.field_localPrivate, this.diE);
                }
                for (;;)
                {
                  ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  ((View)localObject2).setVisibility(0);
                  p localp = (p)getItem(i);
                  TimeLineObject localTimeLineObject = localp.dxy();
                  if (((this.diE) && (paramInt == 0)) || (j == -1) || (localp.field_head != j))
                  {
                    if (av(paramInt, localp.field_snsId))
                    {
                      l = localp.field_createTime;
                      a(((b)localObject1).xDt, ((b)localObject1).xDu, l);
                    }
                    if (localTimeLineObject.Etk != null)
                    {
                      if (!bt.isNullOrNil(localTimeLineObject.Etk.goQ)) {
                        break label5209;
                      }
                      paramView = localTimeLineObject.Etk.ijO;
                      if ((paramView != null) && (!paramView.equals("")))
                      {
                        ((b)localObject1).xDy.setText(paramView);
                        ((b)localObject1).xDy.setVisibility(0);
                      }
                    }
                    ((b)localObject1).xkg.setVisibility(0);
                  }
                  else
                  {
                    a(((b)localObject1).xDv, j, localp.field_head);
                    if ((this.xDj == 0L) || (localp.field_snsId != this.xDj)) {
                      break label5221;
                    }
                    ((b)localObject1).xDz.setVisibility(0);
                    paramView = new f.a();
                    paramView.dzf = localp.xiB;
                    if (this.xDa.get(Integer.valueOf(paramInt)) == null) {
                      break label5234;
                    }
                    paramView.position = ((Integer)this.xDa.get(Integer.valueOf(paramInt))).intValue();
                    ((b)localObject1).xDs.setTag(paramView);
                    if (bt.isNullOrNil(localTimeLineObject.Etj)) {
                      break label5242;
                    }
                    ((b)localObject1).nkd.setVisibility(0);
                    ((b)localObject1).nkd.aq(com.tencent.mm.pluginsdk.ui.span.k.b(this.djj, localTimeLineObject.Etj, ((b)localObject1).nkd.getTextSize()));
                  }
                  com.tencent.mm.storage.bc localbc;
                  for (;;)
                  {
                    ((b)localObject1).xDw.setVisibility(0);
                    ((b)localObject1).nkd.getWrappedTextView().setSingleLine(true);
                    ((b)localObject1).xDE.setVisibility(0);
                    localbc = new com.tencent.mm.storage.bc(this.xCZ.tag);
                    localbc.tGD = localp.field_createTime;
                    if ((localTimeLineObject.Etm.DaG != null) || (localTimeLineObject.Etm.DaH != null)) {
                      break label5255;
                    }
                    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                    AppMethodBeat.o(99038);
                    return localObject2;
                    label5209:
                    paramView = localTimeLineObject.Etk.goQ;
                    break;
                    label5221:
                    ((b)localObject1).xDz.setVisibility(8);
                    break label5001;
                    label5234:
                    paramView.position = 0;
                    break label5057;
                    label5242:
                    ((b)localObject1).nkd.setVisibility(8);
                  }
                  ((b)localObject1).titleTv.setTextColor(this.djj.getResources().getColor(2131100711));
                  if (dAV())
                  {
                    paramView = be.aqC(localTimeLineObject.Etm.Url);
                    if (localTimeLineObject.Etm.DaG == null) {
                      break label5701;
                    }
                    if ((!bt.isNullOrNil(localTimeLineObject.Etm.DaG.nickname)) || (bt.isNullOrNil(localTimeLineObject.Etm.DaG.desc))) {
                      break label5592;
                    }
                    localObject3 = localTimeLineObject.Etm.DaG.desc;
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
                      if (((b)localObject1).xDB != null) {
                        ((b)localObject1).xDB.setOnClickListener(null);
                      }
                      ((b)localObject1).xkO.setVisibility(8);
                      if (localTimeLineObject.Etm.DaG != null) {
                        if (localTimeLineObject.Etm.DaG.Dmx == 1)
                        {
                          ((b)localObject1).xDB.setVisibility(8);
                          ((b)localObject1).xDC.setVisibility(0);
                          ((b)localObject1).xDC.setText(localTimeLineObject.Etm.DaG.desc);
                          label5484:
                          if (bt.isNullOrNil(paramViewGroup)) {
                            break label6145;
                          }
                          ((b)localObject1).xDD.setVisibility(0);
                          ((b)localObject1).xDD.setText(paramViewGroup);
                          if (bt.isNullOrNil(paramView)) {
                            break label6170;
                          }
                          if (((b)localObject1).xDD.getVisibility() != 8) {
                            break label6158;
                          }
                          ((b)localObject1).titleTv.setMaxLines(2);
                          ((b)localObject1).titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.djj, paramView));
                          ((b)localObject1).titleTv.setVisibility(0);
                        }
                      }
                      for (;;)
                      {
                        com.tencent.mm.plugin.sns.k.f.wQY.D(localp);
                        ((View)localObject2).setDrawingCacheEnabled(false);
                        AppMethodBeat.o(99038);
                        return localObject2;
                        paramView = "";
                        break;
                        if (!bt.isNullOrNil(localTimeLineObject.Etm.DaG.desc))
                        {
                          localObject3 = localTimeLineObject.Etm.DaG.nickname + ": " + localTimeLineObject.Etm.DaG.desc;
                          paramViewGroup = paramView;
                          paramView = (View)localObject3;
                          break label5357;
                        }
                        localObject3 = this.djj.getString(2131763973, new Object[] { localTimeLineObject.Etm.DaG.nickname });
                        paramViewGroup = paramView;
                        paramView = (View)localObject3;
                        break label5357;
                        if (localTimeLineObject.Etm.DaH == null) {
                          break label6201;
                        }
                        if (localTimeLineObject.Etm.DaH.qSS == 1) {}
                        for (paramView = "#" + localTimeLineObject.Etm.DaH.dqA;; paramView = localTimeLineObject.Etm.DaH.dqA)
                        {
                          paramViewGroup = localTimeLineObject.Etm.DaH.desc;
                          break;
                        }
                        if (localTimeLineObject.Etm.DaG.mediaList.isEmpty()) {
                          break label5484;
                        }
                        ((b)localObject1).xDB.setVisibility(0);
                        localObject3 = new bpi();
                        ((bpi)localObject3).Url = ((alc)localTimeLineObject.Etm.DaG.mediaList.get(0)).thumbUrl;
                        ((bpi)localObject3).DMQ = ((alc)localTimeLineObject.Etm.DaG.mediaList.get(0)).thumbUrl;
                        ((bpi)localObject3).mBH = 2;
                        ((bpi)localObject3).DMR = 1;
                        ((bpi)localObject3).DMT = new bpk();
                        ((bpi)localObject3).Dzl = 1;
                        ((bpi)localObject3).DMT.DNH = ((alc)localTimeLineObject.Etm.DaG.mediaList.get(0)).width;
                        ((bpi)localObject3).DMT.DNI = ((alc)localTimeLineObject.Etm.DaG.mediaList.get(0)).height;
                        ((bpi)localObject3).Id = localp.getSnsId();
                        af.dtr().a((bpi)localObject3, ((b)localObject1).xDB, this.djj.hashCode(), f.a.wEC, localbc);
                        break label5484;
                        if (localTimeLineObject.Etm.DaH == null) {
                          break label5484;
                        }
                        ((b)localObject1).xDB.setVisibility(0);
                        localObject3 = new bpi();
                        ((bpi)localObject3).Url = localTimeLineObject.Etm.DaH.iconUrl;
                        ((bpi)localObject3).DMQ = localTimeLineObject.Etm.DaH.iconUrl;
                        ((bpi)localObject3).mBH = 2;
                        ((bpi)localObject3).DMR = 1;
                        ((bpi)localObject3).DMT = new bpk();
                        ((bpi)localObject3).Dzl = 1;
                        ((bpi)localObject3).DMT.DNH = 0.0F;
                        ((bpi)localObject3).DMT.DNI = 0.0F;
                        ((bpi)localObject3).Id = localp.getSnsId();
                        af.dtr().a((bpi)localObject3, ((b)localObject1).xDB, this.djj.hashCode(), f.a.wEC, localbc);
                        break label5484;
                        ((b)localObject1).xDD.setVisibility(8);
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
  
  public final ArrayList<com.tencent.mm.plugin.sns.j.b> ho(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99052);
    ArrayList localArrayList = new ArrayList();
    this.xDn = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      p localp = (p)this.list.get(paramInt2);
      int j = localp.xiB;
      if ((localp.dxy() != null) && (localp.dxy().Etm != null) && (localp.dxy().Etm.DaC.size() != 0) && ((localp.dxy().Etm.DaB == 1) || (localp.dxy().Etm.DaB == 15)))
      {
        if (j == paramInt1) {
          this.xDn = localArrayList.size();
        }
        Iterator localIterator = localp.dxy().Etm.DaC.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          bpi localbpi = (bpi)localIterator.next();
          com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
          localb.dyS = localbpi;
          localb.wNP = x.bi("sns_table_", j);
          localb.hgr = localp.field_createTime;
          localb.wNQ = i;
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
  
  public final void tn(long paramLong)
  {
    if (0L != this.xDi) {
      return;
    }
    this.xDi = paramLong;
    this.xDj = 0L;
  }
  
  class a
  {
    TextView xDA;
    View xDs;
    TextView xDt;
    TextView xDu;
    TextView xDv;
    LinearLayout xDw;
    ImageView xDx;
    TextView xDy;
    LinearLayout xDz;
    LinearLayout xkf;
    View xkg;
    
    a() {}
    
    public void init()
    {
      AppMethodBeat.i(99026);
      this.xDt.setVisibility(8);
      this.xDu.setVisibility(8);
      this.xDv.setVisibility(8);
      this.xDw.setVisibility(4);
      this.xDx.setVisibility(4);
      this.xkg.setVisibility(8);
      this.xDy.setVisibility(8);
      this.xDz.setVisibility(8);
      AppMethodBeat.o(99026);
    }
  }
  
  final class b
    extends bb.a
  {
    MMNeat7extView nkd;
    TextView titleTv;
    TagImageView xDB;
    TextView xDC;
    TextView xDD;
    View xDE;
    ImageView xkO;
    
    b()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99027);
      super.init();
      this.nkd.setVisibility(8);
      this.xDB.setVisibility(8);
      if (this.xDC != null) {
        this.xDC.setVisibility(8);
      }
      this.xkO.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.xDD.setVisibility(8);
      AppMethodBeat.o(99027);
    }
  }
  
  public static abstract interface c
  {
    public abstract void dBM();
  }
  
  final class d
    extends bb.a
  {
    MaskImageView xDF;
    QFadeImageView xDG;
    QFadeImageView xDH;
    QFadeImageView xDI;
    MMNeat7extView xDJ;
    TextView xDK;
    TextView xDL;
    TextView xDM;
    TextView xDN;
    View xDO;
    TextView xDP;
    TextView xDQ;
    TextView xDR;
    TextView xDS;
    TextView xDT;
    TextView xDU;
    MaskLinearLayout xDV;
    
    d()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99028);
      super.init();
      this.xDF.setVisibility(8);
      this.xDH.setVisibility(8);
      this.xDI.setVisibility(8);
      this.xDJ.setVisibility(8);
      this.xDK.setVisibility(8);
      this.xDL.setVisibility(8);
      this.xDM.setVisibility(8);
      this.xDN.setVisibility(8);
      this.xDO.setVisibility(8);
      this.xDG.setVisibility(8);
      this.xDP.setVisibility(8);
      this.xDQ.setVisibility(8);
      this.xDR.setVisibility(8);
      this.xDS.setVisibility(8);
      this.xDT.setVisibility(8);
      this.xDU.setVisibility(8);
      if (com.tencent.mm.cd.a.dT(bb.f(bb.this)) > 1.0F) {
        this.xDJ.setMaxLines(2);
      }
      AppMethodBeat.o(99028);
    }
  }
  
  final class e
    extends bb.a
  {
    MaskImageView xDF;
    MMNeat7extView xDJ;
    View xDO;
    TextView xDP;
    MaskLinearLayout xDV;
    
    e()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99029);
      super.init();
      this.xDF.setVisibility(8);
      this.xDJ.setVisibility(8);
      this.xDP.setVisibility(8);
      this.xDO.setVisibility(8);
      if (com.tencent.mm.cd.a.dT(bb.f(bb.this)) > 1.0F) {
        this.xDJ.setMaxLines(2);
      }
      AppMethodBeat.o(99029);
    }
  }
  
  public static final class f$a
  {
    public int dzf;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb
 * JD-Core Version:    0.7.0.1
 */