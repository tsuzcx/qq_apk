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
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.bb.i;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.f.m;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class bj
  extends BaseAdapter
{
  private boolean CAd;
  private String Ejr;
  long JWx;
  Map<Integer, Integer> KAF;
  private Map<Integer, Integer> KAG;
  private int KAH;
  private int KAI;
  String KJw;
  private bv KOY;
  private bp KVP;
  private Map<Integer, Integer> KVQ;
  private g KVR;
  boolean KVS;
  bk KVT;
  bl KVU;
  private d KVV;
  int KVW;
  int KVX;
  private long KVY;
  private long KVZ;
  boolean KWa;
  private int KWb;
  private int KWc;
  int KWd;
  protected View.OnClickListener KWe;
  private String country;
  private boolean fCB;
  private Activity fDf;
  boolean isSearchMode;
  List<SnsInfo> list;
  private String userName;
  String wtB;
  
  public bj(Activity paramActivity, g paramg, String paramString, final d paramd)
  {
    AppMethodBeat.i(99037);
    this.userName = "";
    this.list = new ArrayList();
    this.KAF = new HashMap();
    this.KAG = new HashMap();
    this.KVQ = new HashMap();
    this.KAH = 0;
    this.KAI = 0;
    this.fCB = false;
    this.KJw = "";
    this.KVS = false;
    this.CAd = false;
    this.JWx = 0L;
    this.wtB = "";
    this.KOY = null;
    this.Ejr = "";
    this.KVW = 2147483647;
    this.KVX = 0;
    this.KVY = 0L;
    this.KVZ = 0L;
    this.isSearchMode = false;
    this.KWa = false;
    this.KWb = 0;
    this.KWc = 0;
    this.KWd = 0;
    this.KWe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193763);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          localObject = (TimeLineObject)paramAnonymousView.getTag();
          if (bj.bce(((TimeLineObject)localObject).Id)) {
            break label196;
          }
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10090, "1,0");
          if ((!com.tencent.mm.q.a.cy(bj.f(bj.this))) && (!com.tencent.mm.q.a.cw(bj.f(bj.this))) && (!com.tencent.mm.q.a.cB(bj.f(bj.this))))
          {
            String str1 = aj.getAccPath();
            String str2 = ((TimeLineObject)localObject).Id;
            if (((TimeLineObject)localObject).ContentObj == null) {
              break label191;
            }
            paramAnonymousView = ((TimeLineObject)localObject).ContentObj.lVY;
            paramAnonymousView = i.a(str1, (TimeLineObject)localObject, 8, com.tencent.mm.bb.h.a(str2, paramAnonymousView));
            paramAnonymousView.lVL = bj.g(bj.this);
            com.tencent.mm.bb.a.c(paramAnonymousView);
          }
        }
        for (;;)
        {
          bj.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(193763);
          return;
          label191:
          paramAnonymousView = null;
          break;
          label196:
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10231, "1");
          com.tencent.mm.bb.a.bnv();
        }
      }
    };
    this.userName = paramString;
    this.fDf = paramActivity;
    this.KVR = paramg;
    this.KVV = paramd;
    this.KOY = aj.fOw();
    paramg = LocaleUtil.loadApplicationLanguage(this.fDf.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.fDf);
    Log.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(paramg)));
    paramActivity = paramg;
    if (!paramg.equals("zh_CN"))
    {
      paramActivity = paramg;
      if (!paramg.equals("en"))
      {
        if (!paramg.equals("zh_TW")) {
          break label445;
        }
        paramActivity = paramg;
      }
    }
    this.Ejr = paramActivity;
    this.country = LocaleUtil.loadApplicationLanguage(this.fDf.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.fDf);
    com.tencent.mm.kernel.h.aHH();
    paramActivity = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
    if (this.userName.equals(paramActivity)) {
      this.fCB = true;
    }
    Log.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.fCB) {
      this.KVP = bp.hzj();
    }
    for (;;)
    {
      this.KVT = new bk(new bk.a()
      {
        public final void b(List<SnsInfo> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99016);
          if (!bj.a(bj.this))
          {
            Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bj.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            paramAnonymousList = bj.this;
            if (!bj.b(bj.this).isEmpty()) {
              break label77;
            }
          }
          label77:
          for (long l = 0L;; l = ((SnsInfo)bj.b(bj.this).get(bj.b(bj.this).size() - 1)).field_snsId)
          {
            bj.a(paramAnonymousList, t.Qv(l));
            AppMethodBeat.o(99016);
            return;
          }
        }
        
        public final void fWT()
        {
          AppMethodBeat.i(99017);
          if (!bj.a(bj.this))
          {
            bj.c(bj.this);
            bj.this.notifyDataSetChanged();
            if (paramd != null) {
              paramd.fWU();
            }
          }
          AppMethodBeat.o(99017);
        }
      }, paramString, this.fCB);
      this.KVU = new bl(new bk.a()
      {
        public final void b(List<SnsInfo> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99018);
          if (bj.a(bj.this))
          {
            Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bj.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            bj.d(bj.this);
          }
          AppMethodBeat.o(99018);
        }
        
        public final void fWT()
        {
          AppMethodBeat.i(99019);
          if (bj.a(bj.this))
          {
            bj.c(bj.this);
            bj.this.notifyDataSetChanged();
            if (paramd != null) {
              paramd.fWU();
            }
          }
          AppMethodBeat.o(99019);
        }
      }, this.fCB);
      Rm(0L);
      za(false);
      AppMethodBeat.o(99037);
      return;
      label445:
      if (paramg.equals("zh_HK"))
      {
        paramActivity = "zh_TW";
        break;
      }
      paramActivity = "en";
      break;
      com.tencent.mm.kernel.h.aHH();
      paramActivity = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString);
      if ((paramActivity != null) && (d.rk(paramActivity.field_type))) {
        this.KVP = bp.hzi();
      } else {
        this.KVP = bp.hzk();
      }
    }
  }
  
  private void D(final TextView paramTextView)
  {
    AppMethodBeat.i(99041);
    if (this.KWb <= 0) {
      paramTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99020);
          new Rect();
          paramTextView.measure(0, 0);
          bj.a(bj.this, paramTextView.getMeasuredHeight());
          Log.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", new Object[] { Integer.valueOf(bj.e(bj.this)) });
          AppMethodBeat.o(99020);
        }
      });
    }
    AppMethodBeat.o(99041);
  }
  
  private void Rm(long paramLong)
  {
    AppMethodBeat.i(99050);
    Object localObject = t.Qv(aj.fOI().a(paramLong, aj.fOy().baj(this.userName), this.userName, this.fCB));
    if (this.KJw.equals("")) {}
    for (;;)
    {
      this.wtB = ((String)localObject);
      localObject = aj.fOM().bbr(this.userName).fSG();
      if (((anj)localObject).SxC != 0L) {
        break;
      }
      AppMethodBeat.o(99050);
      return;
      if (((String)localObject).compareTo(this.KJw) >= 0) {
        localObject = this.KJw;
      }
    }
    localObject = t.Qv(((anj)localObject).SxC);
    if (this.wtB.equals(""))
    {
      this.wtB = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
    }
    if (((String)localObject).compareTo(this.wtB) > 0) {}
    for (;;)
    {
      this.wtB = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
      localObject = this.wtB;
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, e parame, int paramInt3)
  {
    AppMethodBeat.i(99044);
    SnsInfo localSnsInfo = (SnsInfo)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
    SnsObject localSnsObject = an.D(localSnsInfo);
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
    if ((this.fCB) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localSnsInfo.getUserName())))
    {
      paramTextView3.setBackgroundResource(i.e.personactivity_sharephoto_icon);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (an.aZ(localSnsInfo.getLocalPrivate(), this.fCB))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(i.e.personactivity_keyphoto_icon);
        localObject = this.KOY.RG(localSnsInfo.getUserName());
        if (localObject != null) {
          break label559;
        }
        localObject = "";
        if ((!((String)localObject).equals("")) && (!this.userName.equals(localSnsInfo.getUserName())))
        {
          paramTextView1.setVisibility(0);
          paramTextView1.setText((CharSequence)localObject);
        }
      }
      label235:
      paramInt1 = localSnsInfo.localid;
      paramTextView1 = new bj.g.a();
      paramTextView1.fWh = paramInt1;
      if (this.KVQ.get(Integer.valueOf(paramInt3)) == null) {
        break label677;
      }
      paramTextView1.position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new bp(this.KVP.tag);
      paramTextView1.time = localSnsInfo.field_createTime;
      if (localTimeLineObject.ContentObj.Sqq != 1) {
        break label685;
      }
      paramQFadeImageView.setVisibility(0);
      aj.fOF().a(localTimeLineObject.ContentObj.Sqr, paramQFadeImageView, this.fDf.hashCode(), g.a.JUP, paramTextView1);
      label367:
      if ((localSnsInfo.isInValid()) && (localSnsInfo.isDieItem()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(i.e.personactivity_failicon);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.ContentObj.Sqr == null) || (localTimeLineObject.ContentObj.Sqr.size() <= 1)) {
          break label808;
        }
        parame.KWG.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.ContentObj.Sqr.size();
        paramTextView2.setText(this.fDf.getResources().getQuantityString(i.h.sns_media_count, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.ContentDesc;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        parame.KWG.setVisibility(0);
        parame.KWB.setVisibility(0);
        parame.KWB.aL(com.tencent.mm.pluginsdk.ui.span.l.b(this.fDf, paramQFadeImageView, parame.KWB.getTextSize()));
      }
      AppMethodBeat.o(99044);
      return;
      label559:
      localObject = ((d)localObject).ays();
      break;
      if (!an.aZ(localSnsInfo.getLocalPrivate(), this.fCB)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(i.e.personactivity_keyphoto_icon);
      localObject = this.KOY.RG(localSnsInfo.getUserName());
      if (localObject == null) {}
      for (localObject = "";; localObject = ((d)localObject).ays())
      {
        if ((localObject == null) || (((String)localObject).equals("")) || (this.userName.equals(localSnsInfo.getUserName()))) {
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
      if (localTimeLineObject.ContentObj.Sqq == 2)
      {
        paramTextView4.setText(Util.nullAs(localTimeLineObject.ContentObj.CMB, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.ContentObj.Sqq != 21) {
        break label367;
      }
      localSnsInfo.getPostInfo();
      boolean bool = true;
      if (this.fCB) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        aj.fOF().a(localTimeLineObject.ContentObj.Sqr, paramQFadeImageView, this.fDf.hashCode(), g.a.JUP, paramTextView1, bool);
        break;
        if (com.tencent.mm.plugin.sns.lucky.a.m.a(localSnsInfo, localSnsObject)) {
          bool = false;
        }
      }
      label808:
      paramTextView2.setVisibility(8);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(99039);
    Object localObject = this.fDf;
    if (!this.Ejr.equals("en")) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = (String)bo.b((Context)localObject, 1000L * paramLong, bool);
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
      localObject[0] = bo.R(this.fDf, localObject[0], this.Ejr);
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
  
  private boolean aV(int paramInt, long paramLong)
  {
    return (!this.isSearchMode) || ((paramInt == 0) && (this.JWx == paramLong)) || (paramInt > 0) || (this.KWa);
  }
  
  private void b(TextView paramTextView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99040);
    int i = paramInt1 / 10000;
    paramInt2 /= 10000;
    D(paramTextView);
    Log.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (this.isSearchMode)
    {
      if ((i != 0) && (paramInt2 != i))
      {
        gF(paramTextView);
        paramTextView.setText(String.format(this.fDf.getResources().getString(i.j.sns_user_date_year), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        D(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (i == 0)
    {
      if (bo.getYear() != paramInt2)
      {
        gF(paramTextView);
        paramTextView.setText(String.format(this.fDf.getResources().getString(i.j.sns_user_date_year), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        D(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (paramInt2 != i)
    {
      gF(paramTextView);
      paramTextView.setText(String.format(this.fDf.getResources().getString(i.j.sns_user_date_year), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      D(paramTextView);
    }
    AppMethodBeat.o(99040);
  }
  
  protected static boolean bce(String paramString)
  {
    AppMethodBeat.i(99054);
    com.tencent.mm.bb.f localf = com.tencent.mm.bb.a.bnA();
    if ((localf != null) && (com.tencent.mm.bb.a.e(localf)) && (paramString.equals(localf.lVt)) && (com.tencent.mm.bb.a.bnx()))
    {
      AppMethodBeat.o(99054);
      return true;
    }
    AppMethodBeat.o(99054);
    return false;
  }
  
  private static boolean fWb()
  {
    AppMethodBeat.i(163123);
    if ((ap.a.fPq() & 0x1) <= 0)
    {
      AppMethodBeat.o(163123);
      return true;
    }
    AppMethodBeat.o(163123);
    return false;
  }
  
  private void gF(View paramView)
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
      localLayoutParams.topMargin = this.fDf.getResources().getDimensionPixelSize(i.d.sns_user_year_top_margin);
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(99042);
  }
  
  @SuppressLint({"ResourceType"})
  private View o(int paramInt, View paramView)
  {
    AppMethodBeat.i(227552);
    b localb;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localb = new b();
      localView = ad.kS(this.fDf).inflate(i.g.sns_photo_user_music_mv, null);
      localb.KWi = localView.findViewById(i.f.content_ll);
      localb.KWk = ((TextView)localView.findViewById(i.f.sns_day));
      localb.KWj = ((TextView)localView.findViewById(i.f.sns_month));
      localb.KWl = ((TextView)localView.findViewById(i.f.sns_year));
      localb.KWo = ((TextView)localView.findViewById(i.f.address));
      localb.KAY = localView.findViewById(i.f.line_add);
      localb.KWo = ((TextView)localView.findViewById(i.f.address));
      localb.KWm = ((LinearLayout)localView.findViewById(i.f.line_add_item));
      localb.KWn = ((ImageView)localView.findViewById(i.f.lock_line_add_item_b));
      localb.KAX = ((LinearLayout)localView.findViewById(i.f.listener_keeper));
      localb.HdL = ((MMNeat7extView)localView.findViewById(i.f.desc_tv));
      localb.KWr = ((MMRoundCornerImageView)localView.findViewById(i.f.music_cover_iv));
      localb.titleTv = ((TextView)localView.findViewById(i.f.music_title_tv));
      localb.KWt = ((TextView)localView.findViewById(i.f.music_desc_tv));
      localb.KWs = ((WeImageView)localView.findViewById(i.f.music_media_icon_iv));
      localb.KWi.setOnClickListener(this.KVR.KWO);
      localb.KWu = localView.findViewById(i.f.media_content_rl);
      localb.KWp = ((LinearLayout)localView.findViewById(i.f.friends_limit));
      localb.KWq = ((TextView)localView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
      localb.KWq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99023);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("enter_scene", f.m.VSz);
          com.tencent.mm.by.c.b(bj.f(bj.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(8) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99023);
        }
      });
      localView.setTag(localb);
      localb.KWl.setTag(Integer.valueOf(paramInt));
      if (this.KAF.get(Integer.valueOf(paramInt)) == null) {
        break label1893;
      }
    }
    label778:
    label834:
    label1093:
    label1761:
    label1893:
    for (int i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.KAI) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(227552);
        return localView;
        localb = (b)paramView.getTag();
        localView = paramView;
        break;
      }
      localView.setVisibility(0);
      int j;
      if (i - 1 >= 0)
      {
        paramView = (SnsInfo)getItem(i - 1);
        j = paramView.getHead();
        an.aZ(paramView.getLocalPrivate(), this.fCB);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.KAG.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.KAG.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject3 = (SnsInfo)getItem(i);
        TimeLineObject localTimeLineObject = ((SnsInfo)localObject3).getTimeLine();
        label891:
        Object localObject2;
        String str2;
        String str1;
        if (((this.fCB) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject3).getHead() != j))
        {
          if (aV(paramInt, ((SnsInfo)localObject3).field_snsId))
          {
            long l = ((SnsInfo)localObject3).getCreateTime();
            a(localb.KWj, localb.KWk, l);
          }
          if (localTimeLineObject.Location != null)
          {
            if (!Util.isNullOrNil(localTimeLineObject.Location.poiName)) {
              break label1558;
            }
            paramView = localTimeLineObject.Location.mVA;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.KWo.setText(paramView);
              localb.KWo.setVisibility(0);
            }
          }
          localb.KAY.setVisibility(0);
        }
        else
        {
          b(localb.KWl, j, ((SnsInfo)localObject3).getHead());
          if ((this.KVZ == 0L) || (((SnsInfo)localObject3).field_snsId != this.KVZ)) {
            break label1570;
          }
          localb.KWp.setVisibility(0);
          paramView = new bj.g.a();
          paramView.fWh = ((SnsInfo)localObject3).localid;
          if (this.KVQ.get(Integer.valueOf(paramInt)) == null) {
            break label1583;
          }
          paramView.position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt))).intValue();
          localb.KWi.setTag(paramView);
          if (Util.isNullOrNil(localTimeLineObject.ContentDesc)) {
            break label1591;
          }
          localb.HdL.setVisibility(0);
          localb.HdL.aL(com.tencent.mm.pluginsdk.ui.span.l.b(this.fDf, localTimeLineObject.ContentDesc, localb.HdL.getTextSize()));
          localb.KWm.setVisibility(0);
          localb.HdL.setMaxLines(1);
          localb.HdL.getWrappedTextView().setSingleLine(true);
          localb.KWu.setVisibility(0);
          new bp(this.KVP.tag).time = ((SnsInfo)localObject3).field_createTime;
          localObject2 = "";
          str2 = "";
          if ((localTimeLineObject.ContentObj == null) || (localTimeLineObject.ContentObj.lVY == null)) {
            break label1880;
          }
          str1 = localTimeLineObject.ContentObj.lVY.Rux;
          if (!Util.isNullOrNil(str1))
          {
            Log.i("MicroMsg.SnsphotoAdapter", "has mvInfo:%s", new Object[] { str1 });
            localb.KWt.setVisibility(0);
            localb.KWt.setText(str1 + this.fDf.getString(i.j.music_mv_info_share_suffix));
          }
          localObject2 = localTimeLineObject.ContentObj.lVY.Ruw;
        }
        for (;;)
        {
          Object localObject1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            paramView = com.tencent.mm.plugin.music.h.b.aSv((String)localObject2);
            localObject1 = localObject2;
            Log.i("MicroMsg.SnsphotoAdapter", "coverInfo, posterInfo:%s, coverUrl: %s, coverPath: %s", new Object[] { str1, localObject1, paramView });
            localb.KWr.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(i.e.music_mv_cover_empty_lightmode));
            if (ar.isDarkMode()) {
              localb.KWr.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(i.e.music_mv_cover_empty_darkmode));
            }
            if (Util.isNullOrNil((String)localObject1)) {
              break label1860;
            }
            localb.KWs.setVisibility(0);
            localb.KWu.setVisibility(0);
            localb.titleTv.setMaxLines(1);
            localb.titleTv.setTextColor(this.fDf.getResources().getColor(i.c.sns_link_color));
            str2 = "";
            if (localTimeLineObject.ContentObj.Sqr.isEmpty()) {
              break label1873;
            }
            localObject2 = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
            ((cvt)localObject2).fWh = ((SnsInfo)localObject3).localid;
            str2 = ((cvt)localObject2).CMB;
          }
          for (localObject2 = ((cvt)localObject2).fwr;; localObject2 = "")
          {
            localObject3 = new c.a();
            ((c.a)localObject3).fullPath = paramView;
            ((c.a)localObject3).lRD = true;
            ((c.a)localObject3).kPz = true;
            ((c.a)localObject3).lRB = true;
            ((c.a)localObject3).kOl = true;
            ((c.a)localObject3).lRW = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
            localObject3 = ((c.a)localObject3).bmL();
            com.tencent.mm.ay.q.bml().a((String)localObject1, localb.KWr, (com.tencent.mm.ay.a.a.c)localObject3);
            localb.KWs.setPressed(false);
            if (bce(localTimeLineObject.Id))
            {
              localb.KWs.setImageResource(i.i.icons_outlined_pause2);
              label1385:
              localb.KWs.setIconColor(MMApplicationContext.getContext().getResources().getColor(i.c.black_color));
              localb.KWs.setTag(localTimeLineObject);
              localb.KWs.setOnClickListener(this.KWe);
              localb.KWu.setTag(localTimeLineObject);
              localb.titleTv.setVisibility(0);
              if (Util.isNullOrNil(str1)) {
                break label1761;
              }
              localObject1 = localObject2;
              if (!Util.isNullOrNil(str2)) {
                localObject1 = (String)localObject2 + String.format("·%s", new Object[] { str2 });
              }
              localb.titleTv.setText((CharSequence)localObject1);
              label1511:
              if (localTimeLineObject.ContentObj.lVY == null) {
                localTimeLineObject.ContentObj.lVY = new dbr();
              }
              localTimeLineObject.ContentObj.lVY.lVZ = paramView;
            }
            for (;;)
            {
              AppMethodBeat.o(227552);
              return localView;
              paramView = localTimeLineObject.Location.poiName;
              break;
              localb.KWp.setVisibility(8);
              break label778;
              paramView.position = 0;
              break label834;
              localb.HdL.setVisibility(8);
              break label891;
              localObject1 = localObject2;
              paramView = str2;
              if (localTimeLineObject.ContentObj.Sqr.isEmpty()) {
                break label1093;
              }
              cvt localcvt = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
              if ((localcvt != null) && (!Util.isNullOrNil(localcvt.TDF)))
              {
                localObject1 = localcvt.TDF;
                paramView = com.tencent.mm.plugin.music.h.b.aSv(localcvt.TDF);
                break label1093;
              }
              localObject1 = localObject2;
              paramView = str2;
              if (localcvt == null) {
                break label1093;
              }
              paramView = aj.fOx().Re(localcvt.fWh);
              localObject1 = t.aZf(paramView.KzW);
              localObject1 = aq.kD(aj.getAccSnsPath(), paramView.KzW) + (String)localObject1;
              paramView = (View)localObject1;
              break label1093;
              localb.KWs.setImageResource(i.i.icons_outlined_play2);
              break label1385;
              localb.titleTv.setText((CharSequence)localObject2);
              if ((localTimeLineObject.ContentObj.lVY != null) && (!Util.isNullOrNil(localTimeLineObject.ContentObj.lVY.singerName)))
              {
                localb.KWt.setVisibility(0);
                localb.KWt.setText(localTimeLineObject.ContentObj.lVY.singerName);
                break label1511;
              }
              if (Util.isNullOrNil(str2)) {
                break label1511;
              }
              localb.KWt.setVisibility(0);
              localb.KWt.setText(str2);
              break label1511;
              localb.KWu.setVisibility(8);
            }
          }
          str1 = "";
        }
        j = -1;
      }
    }
  }
  
  private View p(int paramInt, View paramView)
  {
    AppMethodBeat.i(163122);
    c localc;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localc = new c();
      localView = ad.kS(this.fDf).inflate(i.g.sns_photo_user_normal, null);
      localc.KWi = localView.findViewById(i.f.content_ll);
      localc.KWk = ((TextView)localView.findViewById(i.f.sns_day));
      localc.KWj = ((TextView)localView.findViewById(i.f.sns_month));
      localc.KWl = ((TextView)localView.findViewById(i.f.sns_year));
      localc.KWo = ((TextView)localView.findViewById(i.f.address));
      localc.KAY = localView.findViewById(i.f.line_add);
      localc.KWo = ((TextView)localView.findViewById(i.f.address));
      localc.KWm = ((LinearLayout)localView.findViewById(i.f.line_add_item));
      localc.KWn = ((ImageView)localView.findViewById(i.f.lock_line_add_item_b));
      localc.KAX = ((LinearLayout)localView.findViewById(i.f.listener_keeper));
      localc.HdL = ((MMNeat7extView)localView.findViewById(i.f.desc_tv));
      localc.KWv = ((TagImageView)localView.findViewById(i.f.image_left));
      localc.yVe = ((ImageView)localView.findViewById(i.f.state));
      localc.titleTv = ((TextView)localView.findViewById(i.f.titletext));
      localc.KWt = ((TextView)localView.findViewById(i.f.righttext));
      localc.KWi.setOnClickListener(this.KVR.KWO);
      localc.KWu = localView.findViewById(i.f.media_content_rl);
      localc.KWp = ((LinearLayout)localView.findViewById(i.f.friends_limit));
      localc.KWq = ((TextView)localView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
      localc.KWq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99024);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("enter_scene", f.m.VSz);
          com.tencent.mm.by.c.b(bj.f(bj.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(8) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99024);
        }
      });
      localView.setTag(localc);
      t.b(localc.KWv, this.fDf);
      localc.KWl.setTag(Integer.valueOf(paramInt));
      if (this.KAF.get(Integer.valueOf(paramInt)) == null) {
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
    for (int i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localc.init();
      if ((i >= this.KAI) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(163122);
        return localView;
        localc = (c)paramView.getTag();
        localView = paramView;
        break;
      }
      localView.setVisibility(0);
      int j;
      if (i - 1 >= 0)
      {
        paramView = (SnsInfo)getItem(i - 1);
        j = paramView.getHead();
        an.aZ(paramView.getLocalPrivate(), this.fCB);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.KAG.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.KAG.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject1 = (SnsInfo)getItem(i);
        TimeLineObject localTimeLineObject = ((SnsInfo)localObject1).getTimeLine();
        label846:
        Object localObject2;
        if (((this.fCB) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject1).getHead() != j))
        {
          if (aV(paramInt, ((SnsInfo)localObject1).field_snsId))
          {
            long l = ((SnsInfo)localObject1).getCreateTime();
            a(localc.KWj, localc.KWk, l);
          }
          if (localTimeLineObject.Location != null)
          {
            if (!Util.isNullOrNil(localTimeLineObject.Location.poiName)) {
              break label1037;
            }
            paramView = localTimeLineObject.Location.mVA;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localc.KWo.setText(paramView);
              localc.KWo.setVisibility(0);
            }
          }
          localc.KAY.setVisibility(0);
        }
        else
        {
          b(localc.KWl, j, ((SnsInfo)localObject1).getHead());
          if ((this.KVZ == 0L) || (((SnsInfo)localObject1).field_snsId != this.KVZ)) {
            break label1049;
          }
          localc.KWp.setVisibility(0);
          paramView = new bj.g.a();
          paramView.fWh = ((SnsInfo)localObject1).localid;
          if (this.KVQ.get(Integer.valueOf(paramInt)) == null) {
            break label1062;
          }
          paramView.position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt))).intValue();
          localc.KWi.setTag(paramView);
          if (Util.isNullOrNil(localTimeLineObject.ContentDesc)) {
            break label1070;
          }
          localc.HdL.setVisibility(0);
          localc.HdL.aL(com.tencent.mm.pluginsdk.ui.span.l.b(this.fDf, localTimeLineObject.ContentDesc, localc.HdL.getTextSize()));
          localc.KWm.setVisibility(0);
          localc.HdL.setMaxLines(1);
          localc.HdL.getWrappedTextView().setSingleLine(true);
          localc.KWu.setVisibility(0);
          paramInt = localTimeLineObject.ContentObj.Sqq;
          localObject2 = new bp(this.KVP.tag);
          ((bp)localObject2).time = ((SnsInfo)localObject1).field_createTime;
          if (paramInt != 2) {
            break label1083;
          }
          localc.HdL.setVisibility(0);
          localc.HdL.getWrappedTextView().setSingleLine(false);
          localc.HdL.setMaxLines(2);
          localc.KWu.setVisibility(8);
        }
        cvt localcvt;
        for (;;)
        {
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(163122);
          return localView;
          paramView = localTimeLineObject.Location.poiName;
          break;
          localc.KWp.setVisibility(8);
          break label790;
          paramView.position = 0;
          break label846;
          localc.HdL.setVisibility(8);
          break label903;
          if (paramInt != 4) {
            break label1424;
          }
          if (!localTimeLineObject.ContentObj.Sqr.isEmpty())
          {
            localc.KWv.setVisibility(0);
            localc.yVe.setVisibility(0);
            localc.KWu.setVisibility(0);
            localc.titleTv.setMaxLines(1);
            localc.titleTv.setTextColor(this.fDf.getResources().getColor(i.c.sns_link_color));
            localcvt = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
            aj.fOF().a(localcvt, localc.KWv, i.i.app_attach_file_icon_music, this.fDf.hashCode(), g.a.JUP, (bp)localObject2);
            localc.yVe.setPressed(false);
            if (bce(localTimeLineObject.Id))
            {
              localc.yVe.setImageResource(i.e.music_pauseicon);
              label1235:
              localc.KWv.setTag(localTimeLineObject);
              localc.KWv.setOnClickListener(this.KWe);
              localcvt.fWh = ((SnsInfo)localObject1).localid;
              localc.KWu.setTag(localTimeLineObject);
              localObject1 = localcvt.CMB;
              if (Util.isNullOrNil((String)localObject1)) {
                break label1386;
              }
              localc.KWt.setVisibility(0);
              localc.KWt.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = localcvt.fwr;
              if (Util.isNullOrNil((String)localObject1)) {
                break label1398;
              }
              localc.titleTv.setVisibility(0);
              localc.titleTv.setTag(paramView);
              localc.titleTv.setOnTouchListener(new ah());
              localc.titleTv.setText((CharSequence)localObject1);
              break;
              localc.yVe.setImageResource(i.e.music_playicon);
              break label1235;
              label1386:
              localc.KWt.setVisibility(4);
            }
            label1398:
            localc.titleTv.setVisibility(8);
          }
          else
          {
            localc.KWu.setVisibility(8);
          }
        }
        localc.titleTv.setTextColor(this.fDf.getResources().getColor(i.c.FG_0));
        if (fWb())
        {
          paramView = bm.bcg(localTimeLineObject.ContentObj.Url);
          localObject1 = localTimeLineObject.ContentObj.fwr;
          if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
            break label1981;
          }
          localObject1 = ((String)localObject1).substring(0, 40) + "...";
        }
        for (;;)
        {
          if (localc.KWv != null) {
            localc.KWv.setOnClickListener(null);
          }
          localc.yVe.setVisibility(8);
          if (!localTimeLineObject.ContentObj.Sqr.isEmpty())
          {
            localc.KWv.setVisibility(0);
            localcvt = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
            if (localTimeLineObject.ContentObj.Sqq == 5)
            {
              paramView = bm.bcg(localcvt.Url);
              localObject1 = localcvt.fwr;
              localc.yVe.setVisibility(0);
              aj.fOF().a(localcvt, localc.KWv, i.i.app_attach_file_icon_video, this.fDf.hashCode(), g.a.JUP, (bp)localObject2);
              label1649:
              localObject2 = paramView;
              if (localTimeLineObject.ContentObj.Squ != null)
              {
                localObject2 = paramView;
                if (localTimeLineObject.ContentObj.Squ.lls == 1) {
                  localObject2 = MMApplicationContext.getContext().getString(i.j.mp_pay_content);
                }
              }
              if (Util.isNullOrNil((String)localObject2)) {
                break label1930;
              }
              localc.KWt.setVisibility(0);
              localc.KWt.setText((CharSequence)localObject2);
              if (Util.isNullOrNil((String)localObject1)) {
                break label1968;
              }
              if (localc.KWt.getVisibility() != 8) {
                break label1943;
              }
              localc.titleTv.setMaxLines(2);
              label1749:
              localc.titleTv.setVisibility(0);
              if ((localTimeLineObject.contentattr & 0x1) <= 0) {
                break label1955;
              }
              localc.titleTv.setText(t.a((String)localObject1, this.fDf, localc.titleTv));
            }
          }
          for (;;)
          {
            if ((localTimeLineObject.weappInfo == null) || (localTimeLineObject.weappInfo.subType != 1)) {
              break label1979;
            }
            localc.yVe.setVisibility(0);
            localc.yVe.setImageDrawable(localc.yVe.getContext().getResources().getDrawable(i.i.shortvideo_play_btn));
            break;
            paramView = "";
            break label1463;
            aj.fOF().a(localcvt, localc.KWv, this.fDf.hashCode(), g.a.JUP, (bp)localObject2);
            break label1649;
            if (localTimeLineObject.ContentObj.Sqq != 26)
            {
              localc.KWv.setVisibility(8);
              break label1649;
            }
            localc.KWv.setVisibility(0);
            localc.KWv.setImageResource(i.i.note_sns_link_default);
            break label1649;
            localc.KWt.setVisibility(8);
            break label1719;
            localc.titleTv.setMaxLines(1);
            break label1749;
            localc.titleTv.setText((CharSequence)localObject1);
            continue;
            localc.titleTv.setVisibility(8);
          }
          break;
        }
        j = -1;
      }
    }
  }
  
  private View q(int paramInt, View paramView)
  {
    AppMethodBeat.i(227635);
    c localc;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localc = new c();
      localView = ad.kS(this.fDf).inflate(i.g.sns_photo_user_normal, null);
      localc.KWi = localView.findViewById(i.f.content_ll);
      localc.KWk = ((TextView)localView.findViewById(i.f.sns_day));
      localc.KWj = ((TextView)localView.findViewById(i.f.sns_month));
      localc.KWl = ((TextView)localView.findViewById(i.f.sns_year));
      localc.KWo = ((TextView)localView.findViewById(i.f.address));
      localc.KAY = localView.findViewById(i.f.line_add);
      localc.KWo = ((TextView)localView.findViewById(i.f.address));
      localc.KWm = ((LinearLayout)localView.findViewById(i.f.line_add_item));
      localc.KWn = ((ImageView)localView.findViewById(i.f.lock_line_add_item_b));
      localc.KAX = ((LinearLayout)localView.findViewById(i.f.listener_keeper));
      localc.HdL = ((MMNeat7extView)localView.findViewById(i.f.desc_tv));
      localc.KWv = ((TagImageView)localView.findViewById(i.f.image_left));
      localc.yVe = ((ImageView)localView.findViewById(i.f.state));
      localc.titleTv = ((TextView)localView.findViewById(i.f.titletext));
      localc.KWt = ((TextView)localView.findViewById(i.f.righttext));
      localc.KWi.setOnClickListener(this.KVR.KWO);
      localc.KWu = localView.findViewById(i.f.media_content_rl);
      localc.KWw = ((TextView)localView.findViewById(i.f.content_left));
      localc.KWp = ((LinearLayout)localView.findViewById(i.f.friends_limit));
      localc.KWq = ((TextView)localView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
      localc.KWq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99025);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("enter_scene", f.m.VSz);
          com.tencent.mm.by.c.b(bj.f(bj.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
          com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(8) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99025);
        }
      });
      localView.setTag(localc);
      t.b(localc.KWv, this.fDf);
      localc.KWl.setTag(Integer.valueOf(paramInt));
      if (this.KAF.get(Integer.valueOf(paramInt)) == null) {
        break label3696;
      }
    }
    label770:
    label829:
    label1246:
    label1389:
    label3696:
    for (int i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localc.init();
      if ((i >= this.KAI) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(227635);
        return localView;
        localc = (c)paramView.getTag();
        localView = paramView;
        break;
      }
      localView.setVisibility(0);
      int j;
      if (i - 1 >= 0)
      {
        paramView = (SnsInfo)getItem(i - 1);
        j = paramView.getHead();
        an.aZ(paramView.getLocalPrivate(), this.fCB);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        SnsInfo localSnsInfo = (SnsInfo)getItem(i);
        Object localObject3 = localSnsInfo.getTimeLine();
        Object localObject4;
        if (((this.fCB) && (paramInt == 0)) || (j == -1) || (localSnsInfo.getHead() != j))
        {
          if (aV(paramInt, localSnsInfo.field_snsId))
          {
            long l = localSnsInfo.getCreateTime();
            a(localc.KWj, localc.KWk, l);
          }
          if (((TimeLineObject)localObject3).Location != null)
          {
            if (!Util.isNullOrNil(((TimeLineObject)localObject3).Location.poiName)) {
              break label1037;
            }
            paramView = ((TimeLineObject)localObject3).Location.mVA;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localc.KWo.setText(paramView);
              localc.KWo.setVisibility(0);
            }
          }
          localc.KAY.setVisibility(0);
        }
        else
        {
          b(localc.KWl, j, localSnsInfo.getHead());
          if ((this.KVZ == 0L) || (localSnsInfo.field_snsId != this.KVZ)) {
            break label1049;
          }
          localc.KWp.setVisibility(0);
          localObject4 = new bj.g.a();
          ((bj.g.a)localObject4).fWh = localSnsInfo.localid;
          if (this.KVQ.get(Integer.valueOf(paramInt)) == null) {
            break label1062;
          }
          ((bj.g.a)localObject4).position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt))).intValue();
          localc.KWi.setTag(localObject4);
          if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentDesc)) {
            break label1071;
          }
          localc.HdL.setVisibility(0);
          localc.HdL.aL(com.tencent.mm.pluginsdk.ui.span.l.b(this.fDf, ((TimeLineObject)localObject3).ContentDesc, localc.HdL.getTextSize()));
        }
        bp localbp;
        for (;;)
        {
          localc.KWm.setVisibility(0);
          localc.HdL.getWrappedTextView().setSingleLine(true);
          localc.KWu.setVisibility(0);
          localbp = new bp(this.KVP.tag);
          localbp.time = localSnsInfo.field_createTime;
          if ((((TimeLineObject)localObject3).ContentObj.fFJ != null) || (((TimeLineObject)localObject3).ContentObj.Sqx != null) || (((TimeLineObject)localObject3).ContentObj.Sqv != null) || (((TimeLineObject)localObject3).ContentObj.yNL != null) || (((TimeLineObject)localObject3).ContentObj.Sqy != null) || (((TimeLineObject)localObject3).ContentObj.Sqz != null) || (((TimeLineObject)localObject3).ContentObj.SqA != null)) {
            break label1084;
          }
          Log.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
          AppMethodBeat.o(227635);
          return localView;
          paramView = ((TimeLineObject)localObject3).Location.poiName;
          break;
          localc.KWp.setVisibility(8);
          break label770;
          ((bj.g.a)localObject4).position = 0;
          break label829;
          localc.HdL.setVisibility(8);
        }
        localc.titleTv.setTextColor(this.fDf.getResources().getColor(i.c.normal_text_color));
        Object localObject2;
        Object localObject1;
        if (fWb())
        {
          paramView = bm.bcg(((TimeLineObject)localObject3).ContentObj.Url);
          localObject2 = "";
          if (((TimeLineObject)localObject3).ContentObj.fFJ == null) {
            break label1546;
          }
          paramView = this.fDf.getString(i.j.sns_share_finder_feed_title, new Object[] { ((TimeLineObject)localObject3).ContentObj.fFJ.nickname });
          if (((TimeLineObject)localObject3).ContentObj.fFJ.ACQ != 4) {
            break label1499;
          }
          paramView = this.fDf.getString(i.j.sns_share_finder_feed_video_title, new Object[] { ((TimeLineObject)localObject3).ContentObj.fFJ.nickname });
          if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.fFJ.nickname)) {
            paramView = this.fDf.getResources().getString(i.j.finder_app_name);
          }
          localObject1 = "";
        }
        for (;;)
        {
          if (paramView.length() > 40) {
            paramView = paramView.substring(0, 40) + "...";
          }
          for (;;)
          {
            if (localc.KWv != null)
            {
              localc.KWv.setTag(localObject4);
              localc.KWv.setOnClickListener(this.KVR.KWO);
            }
            localc.yVe.setVisibility(8);
            if (((TimeLineObject)localObject3).ContentObj.fFJ != null) {
              if (((TimeLineObject)localObject3).ContentObj.fFJ.ACQ == 1)
              {
                localc.KWv.setVisibility(8);
                localc.KWw.setVisibility(0);
                localc.KWw.setText(((TimeLineObject)localObject3).ContentObj.fFJ.desc);
                if (Util.isNullOrNil((String)localObject1)) {
                  break label3640;
                }
                localc.KWt.setVisibility(0);
                localc.KWt.setText((CharSequence)localObject1);
                if (Util.isNullOrNil(paramView)) {
                  break label3665;
                }
                if (localc.KWt.getVisibility() != 8) {
                  break label3653;
                }
                localc.titleTv.setMaxLines(2);
                localc.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.fDf, paramView));
                localc.titleTv.setVisibility(0);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.sns.k.g.Kia.O(localSnsInfo);
              localView.setDrawingCacheEnabled(false);
              AppMethodBeat.o(227635);
              return localView;
              paramView = "";
              break;
              if (((TimeLineObject)localObject3).ContentObj.fFJ.ACQ != 2) {
                break label1211;
              }
              paramView = this.fDf.getString(i.j.sns_share_finder_feed_photo_title, new Object[] { ((TimeLineObject)localObject3).ContentObj.fFJ.nickname });
              break label1211;
              if (((TimeLineObject)localObject3).ContentObj.Sqx != null)
              {
                paramView = ((TimeLineObject)localObject3).ContentObj.Sqx.title;
                localObject1 = "";
                break label1246;
              }
              if (((TimeLineObject)localObject3).ContentObj.Sqv != null)
              {
                if (((TimeLineObject)localObject3).ContentObj.Sqv.wXA == 1) {
                  new StringBuilder("#").append(((TimeLineObject)localObject3).ContentObj.Sqv.topic);
                }
                if ((((TimeLineObject)localObject3).ContentObj.Sqv.wXA == 7) && (((TimeLineObject)localObject3).ContentObj.Sqv.STw != null)) {}
                for (paramView = MMApplicationContext.getContext().getString(i.j.sns_share_finder_activity_card, new Object[] { ((TimeLineObject)localObject3).ContentObj.Sqv.STw.SCS, ((TimeLineObject)localObject3).ContentObj.Sqv.STw.SCR });; paramView = ((TimeLineObject)localObject3).ContentObj.Sqv.topic)
                {
                  localObject1 = ((TimeLineObject)localObject3).ContentObj.Sqv.desc;
                  break;
                }
              }
              if (((TimeLineObject)localObject3).ContentObj.Sqz != null)
              {
                if ((((TimeLineObject)localObject3).ContentObj.Sqz.wXA == 7) && (((TimeLineObject)localObject3).ContentObj.Sqz.STw != null)) {}
                for (paramView = MMApplicationContext.getContext().getString(i.j.sns_share_finder_activity_card, new Object[] { ((TimeLineObject)localObject3).ContentObj.Sqz.STw.SCS, ((TimeLineObject)localObject3).ContentObj.Sqz.STw.SCR });; paramView = ((TimeLineObject)localObject3).ContentObj.Sqz.topic)
                {
                  localObject1 = ((TimeLineObject)localObject3).ContentObj.Sqv.desc;
                  break;
                }
              }
              if (((TimeLineObject)localObject3).ContentObj.yNL != null)
              {
                if ((Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.yNL.nickName)) && (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.yNL.desc)))
                {
                  localObject2 = ((TimeLineObject)localObject3).ContentObj.yNL.desc;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  break label1246;
                }
                if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.yNL.desc))
                {
                  localObject2 = ((TimeLineObject)localObject3).ContentObj.yNL.nickName + ": " + ((TimeLineObject)localObject3).ContentObj.yNL.desc;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  break label1246;
                }
                localObject2 = this.fDf.getString(i.j.sns_share_finder_live_title, new Object[] { ((TimeLineObject)localObject3).ContentObj.yNL.nickName });
                localObject1 = paramView;
                paramView = (View)localObject2;
                break label1246;
              }
              if (((TimeLineObject)localObject3).ContentObj.Sqy != null)
              {
                paramView = this.fDf.getString(i.j.sns_share_finder_feed_video_title, new Object[] { ((TimeLineObject)localObject3).ContentObj.Sqy.nickname });
                if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Sqy.nickname)) {
                  paramView = this.fDf.getResources().getString(i.j.finder_app_name);
                }
                localObject1 = "";
                break label1246;
              }
              if ((((TimeLineObject)localObject3).ContentObj.SqA == null) || (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.SqA.poiName))) {
                break label3681;
              }
              paramView = ((TimeLineObject)localObject3).ContentObj.SqA.poiName;
              localObject1 = ((TimeLineObject)localObject3).ContentObj.SqA.xzN;
              break label1246;
              if (!((TimeLineObject)localObject3).ContentObj.fFJ.mediaList.isEmpty())
              {
                localc.KWv.setVisibility(0);
                localObject2 = new cvt();
                ((cvt)localObject2).Url = ((bjc)((TimeLineObject)localObject3).ContentObj.fFJ.mediaList.get(0)).thumbUrl;
                ((cvt)localObject2).TDF = ((bjc)((TimeLineObject)localObject3).ContentObj.fFJ.mediaList.get(0)).thumbUrl;
                ((cvt)localObject2).rWu = 2;
                ((cvt)localObject2).TDG = 1;
                ((cvt)localObject2).TDH = new cvv();
                ((cvt)localObject2).TlV = 1;
                ((cvt)localObject2).TDH.TEu = ((bjc)((TimeLineObject)localObject3).ContentObj.fFJ.mediaList.get(0)).width;
                ((cvt)localObject2).TDH.TEv = ((bjc)((TimeLineObject)localObject3).ContentObj.fFJ.mediaList.get(0)).height;
                ((cvt)localObject2).Id = localSnsInfo.getSnsId();
                aj.fOF().a((cvt)localObject2, localc.KWv, this.fDf.hashCode(), g.a.JUP, localbp);
              }
              if (((TimeLineObject)localObject3).ContentObj.fFJ.ACQ != 4) {
                break label1389;
              }
              localc.yVe.setVisibility(0);
              localc.yVe.setImageDrawable(localc.yVe.getContext().getResources().getDrawable(i.i.shortvideo_play_btn));
              break label1389;
              if (((TimeLineObject)localObject3).ContentObj.Sqz != null)
              {
                localc.KWv.setVisibility(0);
                if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Sqz.iconUrl))
                {
                  localObject2 = new cvt();
                  ((cvt)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.Sqz.iconUrl;
                  ((cvt)localObject2).TDF = ((TimeLineObject)localObject3).ContentObj.Sqz.iconUrl;
                  ((cvt)localObject2).rWu = 2;
                  ((cvt)localObject2).TDG = 1;
                  ((cvt)localObject2).TDH = new cvv();
                  ((cvt)localObject2).TlV = 1;
                  ((cvt)localObject2).TDH.TEu = 0.0F;
                  ((cvt)localObject2).TDH.TEv = 0.0F;
                  ((cvt)localObject2).Id = localSnsInfo.getSnsId();
                  localc.KWv.setScaleType(QImageView.a.Ydm);
                  ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImageForSns(((TimeLineObject)localObject3).ContentObj.Sqz.iconUrl, localc.KWv);
                  break label1389;
                }
                aj.fOF().d(localc.KWv, -1, i.i.icon_filled_activity, this.fDf.hashCode());
                break label1389;
              }
              if (((TimeLineObject)localObject3).ContentObj.Sqv != null)
              {
                localc.KWv.setVisibility(0);
                localObject2 = new cvt();
                ((cvt)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.Sqv.iconUrl;
                ((cvt)localObject2).TDF = ((TimeLineObject)localObject3).ContentObj.Sqv.iconUrl;
                ((cvt)localObject2).rWu = 2;
                ((cvt)localObject2).TDG = 1;
                ((cvt)localObject2).TDH = new cvv();
                ((cvt)localObject2).TlV = 1;
                ((cvt)localObject2).TDH.TEu = 0.0F;
                ((cvt)localObject2).TDH.TEv = 0.0F;
                ((cvt)localObject2).Id = localSnsInfo.getSnsId();
                aj.fOF().a((cvt)localObject2, localc.KWv, this.fDf.hashCode(), g.a.JUP, localbp);
                break label1389;
              }
              if (((TimeLineObject)localObject3).ContentObj.Sqx != null)
              {
                localc.KWv.setVisibility(0);
                localObject2 = new cvt();
                localObject4 = (String)((TimeLineObject)localObject3).ContentObj.Sqx.STk.get(0);
                localObject3 = (String)((TimeLineObject)localObject3).ContentObj.Sqx.STl.get(0);
                ((cvt)localObject2).Url = ((String)localObject4 + (String)localObject3);
                ((cvt)localObject2).TDF = ((cvt)localObject2).Url;
                ((cvt)localObject2).rWu = 2;
                ((cvt)localObject2).TDG = 1;
                ((cvt)localObject2).TDH = new cvv();
                ((cvt)localObject2).TlV = 1;
                ((cvt)localObject2).TDH.TEu = 0.0F;
                ((cvt)localObject2).TDH.TEv = 0.0F;
                ((cvt)localObject2).Id = localSnsInfo.getSnsId();
                aj.fOF().a((cvt)localObject2, localc.KWv, this.fDf.hashCode(), g.a.JUP, localbp);
                break label1389;
              }
              if (((TimeLineObject)localObject3).ContentObj.yNL != null)
              {
                if (((TimeLineObject)localObject3).ContentObj.yNL.coverUrl.isEmpty()) {
                  break label1389;
                }
                localc.KWv.setVisibility(0);
                localObject2 = new cvt();
                ((cvt)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.yNL.coverUrl;
                ((cvt)localObject2).TDF = ((TimeLineObject)localObject3).ContentObj.yNL.coverUrl;
                ((cvt)localObject2).rWu = 2;
                ((cvt)localObject2).TDG = 1;
                ((cvt)localObject2).TDH = new cvv();
                ((cvt)localObject2).TlV = 1;
                ((cvt)localObject2).TDH.TEu = ((TimeLineObject)localObject3).ContentObj.yNL.width;
                ((cvt)localObject2).TDH.TEv = ((TimeLineObject)localObject3).ContentObj.yNL.height;
                ((cvt)localObject2).Id = localSnsInfo.getSnsId();
                ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImageForSns(((cvt)localObject2).Url, localc.KWv);
                break label1389;
              }
              if (((TimeLineObject)localObject3).ContentObj.Sqy != null)
              {
                if (!((TimeLineObject)localObject3).ContentObj.Sqy.mediaList.isEmpty())
                {
                  localc.KWv.setVisibility(0);
                  localObject4 = new cvt();
                  if (Util.isNullOrNil(((cww)((TimeLineObject)localObject3).ContentObj.Sqy.mediaList.get(0)).coverUrl)) {
                    break label3425;
                  }
                }
                for (localObject2 = ((cww)((TimeLineObject)localObject3).ContentObj.Sqy.mediaList.get(0)).coverUrl;; localObject2 = ((cww)((TimeLineObject)localObject3).ContentObj.Sqy.mediaList.get(0)).thumbUrl)
                {
                  ((cvt)localObject4).Url = ((String)localObject2);
                  ((cvt)localObject4).TDF = ((String)localObject2);
                  ((cvt)localObject4).rWu = 2;
                  ((cvt)localObject4).TDG = 1;
                  ((cvt)localObject4).TDH = new cvv();
                  ((cvt)localObject4).TlV = 1;
                  ((cvt)localObject4).TDH.TEu = ((cww)((TimeLineObject)localObject3).ContentObj.Sqy.mediaList.get(0)).width;
                  ((cvt)localObject4).TDH.TEv = ((cww)((TimeLineObject)localObject3).ContentObj.Sqy.mediaList.get(0)).height;
                  ((cvt)localObject4).Id = localSnsInfo.getSnsId();
                  aj.fOF().a((cvt)localObject4, localc.KWv, this.fDf.hashCode(), g.a.JUP, localbp);
                  localc.yVe.setVisibility(0);
                  localc.yVe.setImageDrawable(localc.yVe.getContext().getResources().getDrawable(i.i.shortvideo_play_btn));
                  break;
                }
              }
              if (((TimeLineObject)localObject3).ContentObj.SqA == null) {
                break label1389;
              }
              localc.KWv.setVisibility(0);
              if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.SqA.QSw))
              {
                localObject2 = new cvt();
                ((cvt)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.SqA.QSw;
                ((cvt)localObject2).TDF = ((TimeLineObject)localObject3).ContentObj.SqA.QSw;
                ((cvt)localObject2).rWu = 2;
                ((cvt)localObject2).TDG = 1;
                ((cvt)localObject2).TDH = new cvv();
                ((cvt)localObject2).TlV = 1;
                ((cvt)localObject2).TDH.TEu = 0.0F;
                ((cvt)localObject2).TDH.TEv = 0.0F;
                ((cvt)localObject2).Id = localSnsInfo.getSnsId();
                aj.fOF().a((cvt)localObject2, localc.KWv, this.fDf.hashCode(), g.a.JUP, localbp);
                break label1389;
              }
              aj.fOF().d(localc.KWv, -1, i.i.icons_outlined_location, this.fDf.hashCode());
              break label1389;
              localc.KWt.setVisibility(8);
              break label1416;
              localc.titleTv.setMaxLines(1);
              break label1445;
              localc.titleTv.setVisibility(8);
            }
          }
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
        j = -1;
      }
    }
  }
  
  private void za(boolean paramBoolean)
  {
    AppMethodBeat.i(99046);
    Log.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.wtB);
    if (this.KVT != null)
    {
      if (this.isSearchMode)
      {
        this.KVU.aC(this.KVS, paramBoolean);
        AppMethodBeat.o(99046);
        return;
      }
      this.KVT.k(this.wtB, this.KVS, paramBoolean);
    }
    AppMethodBeat.o(99046);
  }
  
  public final void Rl(long paramLong)
  {
    if (0L != this.KVY) {
      return;
    }
    this.KVY = paramLong;
    this.KVZ = 0L;
  }
  
  public final void a(List<SnsInfo> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99045);
    Log.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (this.KVV != null) {
        this.KVV.fWU();
      }
      AppMethodBeat.o(99045);
      return;
    }
    Log.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    this.list.clear();
    this.KAF.clear();
    this.KAG.clear();
    this.KVQ.clear();
    int i = 0;
    while (i < j)
    {
      SnsInfo localSnsInfo = SnsInfo.getNewSnsInfo((SnsInfo)paramList.get(i));
      this.list.add(localSnsInfo);
      i += 1;
    }
    paramList = paramMap1.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
      this.KAF.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      this.KAG.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      this.KVQ.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (this.fCB)
    {
      if (this.list.size() <= 1) {}
      for (i = 2147483647;; i = ((SnsInfo)this.list.get(1)).getHead())
      {
        this.KVW = 0;
        j = 0;
        while (j < this.list.size())
        {
          if ((!this.fCB) || (j != 0))
          {
            if (i != ((SnsInfo)this.list.get(j)).getHead()) {
              break;
            }
            this.KVW = Math.max(this.KVW, ((SnsInfo)this.list.get(j)).getCreateTime());
          }
          j += 1;
        }
      }
    }
    if (this.list.isEmpty()) {}
    for (i = 2147483647;; i = ((SnsInfo)this.list.get(0)).getHead()) {
      break;
    }
    if ((this.list.isEmpty()) || ((this.fCB) && (this.list.size() == 1))) {
      this.KVW = 2147483647;
    }
    if (this.list.isEmpty()) {}
    for (i = 0;; i = ((SnsInfo)this.list.get(this.list.size() - 1)).getHead())
    {
      this.KVX = 2147483647;
      j = this.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((SnsInfo)this.list.get(j)).getHead()))
      {
        this.KVX = Math.min(this.KVX, ((SnsInfo)this.list.get(j)).getCreateTime());
        j -= 1;
      }
    }
    if (this.list.isEmpty()) {
      this.KVX = 0;
    }
    this.KAI = paramInt1;
    this.KAH = paramInt2;
    Log.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + this.KVW + " edTIme " + this.KVX);
    notifyDataSetChanged();
    AppMethodBeat.o(99045);
  }
  
  public final void fTJ()
  {
    AppMethodBeat.i(99048);
    za(true);
    notifyDataSetChanged();
    AppMethodBeat.o(99048);
  }
  
  public final void fWR()
  {
    this.KWa = true;
    if (this.isSearchMode) {
      this.KVU.KWX = true;
    }
  }
  
  public final void fWS()
  {
    AppMethodBeat.i(99049);
    Log.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((SnsInfo)this.list.get(this.list.size() - 1)).field_snsId)
    {
      Rm(l);
      AppMethodBeat.o(99049);
      return;
    }
  }
  
  public final int getCount()
  {
    return this.KAH;
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
    if ((this.fCB) && (paramInt == 0) && ((!this.isSearchMode) || ((this.isSearchMode) && (this.KWa))))
    {
      Log.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(99043);
      return 0;
    }
    if (this.KAF.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        Log.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(99043);
        return 0;
      }
      Object localObject = (SnsInfo)getItem(i);
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 1)
      {
        Log.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(99043);
        return 0;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 15)
      {
        Log.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(99043);
        return 2;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 21)
      {
        AppMethodBeat.o(99043);
        return 3;
      }
      if ((((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 28) || (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 29) || (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 37) || (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 38) || (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 34) || (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 43) || (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 36) || (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 44))
      {
        AppMethodBeat.o(99043);
        return 4;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 33)
      {
        AppMethodBeat.o(99043);
        return 5;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 4) {
        if (((SnsInfo)localObject).getTimeLine().AppInfo == null) {
          break label596;
        }
      }
      label596:
      for (localObject = ((SnsInfo)localObject).getTimeLine().AppInfo.Id;; localObject = "")
      {
        com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.ubo;
        if (com.tencent.mm.plugin.comm.a.asG((String)localObject))
        {
          AppMethodBeat.o(99043);
          return 6;
        }
        localObject = com.tencent.mm.plugin.comm.a.ubo;
        if (!com.tencent.mm.plugin.comm.a.cPi())
        {
          AppMethodBeat.o(99043);
          return 1;
        }
        AppMethodBeat.o(99043);
        return 1;
        if (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 42)
        {
          AppMethodBeat.o(99043);
          return 6;
        }
        if (((SnsInfo)localObject).getTimeLine().ContentObj.Sqq == 39) {}
        switch (((SnsInfo)localObject).getTimeLine().ContentObj.loX)
        {
        default: 
          AppMethodBeat.o(99043);
          return 1;
        }
        AppMethodBeat.o(99043);
        return 4;
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99038);
    int i = getItemViewType(paramInt);
    Log.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(i)));
    Object localObject1;
    int j;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
      {
        paramViewGroup = new e();
        paramView = ad.kS(this.fDf).inflate(i.g.sns_photo_user_photo, null);
        paramViewGroup.KWk = ((TextView)paramView.findViewById(i.f.sns_day));
        paramViewGroup.KWj = ((TextView)paramView.findViewById(i.f.sns_month));
        paramViewGroup.KWl = ((TextView)paramView.findViewById(i.f.sns_year));
        paramViewGroup.KWx = ((MaskImageView)paramView.findViewById(i.f.img1));
        paramViewGroup.KWy = ((QFadeImageView)paramView.findViewById(i.f.take_photo));
        paramViewGroup.KWz = ((MaskImageView)paramView.findViewById(i.f.img2));
        paramViewGroup.KWA = ((MaskImageView)paramView.findViewById(i.f.img3));
        paramViewGroup.KWB = ((MMNeat7extView)paramView.findViewById(i.f.desc));
        paramViewGroup.KWC = ((TextView)paramView.findViewById(i.f.with_username1));
        paramViewGroup.KWD = ((TextView)paramView.findViewById(i.f.with_username2));
        paramViewGroup.KWE = ((TextView)paramView.findViewById(i.f.with_username3));
        paramViewGroup.KWF = ((TextView)paramView.findViewById(i.f.img_count));
        paramViewGroup.KWG = paramView.findViewById(i.f.desc_count);
        paramViewGroup.KWo = ((TextView)paramView.findViewById(i.f.address));
        paramViewGroup.KWm = ((LinearLayout)paramView.findViewById(i.f.line_add_item));
        paramViewGroup.KWn = ((ImageView)paramView.findViewById(i.f.lock_line_add_item_b));
        paramViewGroup.KAX = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
        paramViewGroup.KAY = paramView.findViewById(i.f.line_add);
        paramViewGroup.KWy.setOnClickListener(this.KVR.KAO);
        paramViewGroup.KWx.setOnClickListener(this.KVR.KAO);
        paramViewGroup.KWz.setOnClickListener(this.KVR.KAP);
        paramViewGroup.KWA.setOnClickListener(this.KVR.KAQ);
        paramViewGroup.KWx.setOnLongClickListener(this.KVR.KWR);
        paramViewGroup.KWz.setOnLongClickListener(this.KVR.KWR);
        paramViewGroup.KWA.setOnLongClickListener(this.KVR.KWR);
        paramViewGroup.KWH = ((TextView)paramView.findViewById(i.f.warn1));
        paramViewGroup.KWI = ((TextView)paramView.findViewById(i.f.warn2));
        paramViewGroup.KWJ = ((TextView)paramView.findViewById(i.f.warn3));
        paramViewGroup.KWK = ((TextView)paramView.findViewById(i.f.tv1));
        paramViewGroup.KWL = ((TextView)paramView.findViewById(i.f.tv2));
        paramViewGroup.KWM = ((TextView)paramView.findViewById(i.f.tv3));
        paramViewGroup.KWN = ((MaskLinearLayout)paramView.findViewById(i.f.sns_line_blackground));
        paramViewGroup.KWN.b(paramViewGroup.KWx);
        paramViewGroup.KWp = ((LinearLayout)paramView.findViewById(i.f.friends_limit));
        paramViewGroup.KWq = ((TextView)paramView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
        paramViewGroup.KWq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99022);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("enter_scene", f.m.VSz);
            com.tencent.mm.by.c.b(bj.f(bj.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(8) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99022);
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        aj.fOF().gm(paramViewGroup.KWx);
        aj.fOF().gm(paramViewGroup.KWz);
        aj.fOF().gm(paramViewGroup.KWA);
        i = -1;
        if (this.KAF.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.KWl.setTag(Integer.valueOf(paramInt));
        paramViewGroup.KWN.settouchEnable(false);
        paramViewGroup.KWN.setBackgroundResource(0);
        paramViewGroup.KWN.setDescendantFocusability(131072);
        paramViewGroup.KWN.setClickable(false);
        paramViewGroup.KWx.settouchEnable(true);
        paramViewGroup.KWx.setClickable(true);
        paramViewGroup.KWx.setLongClickable(false);
        paramViewGroup.KWz.setLongClickable(false);
        paramViewGroup.KWA.setLongClickable(false);
        paramViewGroup.KWN.setOnClickListener(null);
        paramViewGroup.KWN.setOnLongClickListener(null);
        paramViewGroup.KWN.setLongClickable(false);
        if ((i < this.KAI) && (i != -1)) {
          break;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(99038);
        return paramView;
        paramViewGroup = (e)paramView.getTag();
      }
      if (i - 1 < 0) {
        break label5685;
      }
      localObject1 = (SnsInfo)getItem(i - 1);
      j = ((SnsInfo)localObject1).getHead();
      an.aZ(((SnsInfo)localObject1).getLocalPrivate(), this.fCB);
    }
    label3972:
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.setVisibility(0);
      if (this.KAG.get(Integer.valueOf(paramInt)) != null) {}
      label1287:
      label1300:
      label5655:
      label5661:
      for (int k = ((Integer)this.KAG.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        Object localObject2 = (SnsInfo)getItem(i);
        localObject1 = ((SnsInfo)localObject2).getTimeLine();
        long l;
        if (((this.fCB) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject2).getHead() != j))
        {
          if (aV(paramInt, ((SnsInfo)localObject2).field_snsId))
          {
            l = ((SnsInfo)localObject2).getCreateTime();
            a(paramViewGroup.KWj, paramViewGroup.KWk, l);
          }
          if (((TimeLineObject)localObject1).Location != null)
          {
            if (!Util.isNullOrNil(((TimeLineObject)localObject1).Location.poiName)) {
              break label1287;
            }
            localObject1 = ((TimeLineObject)localObject1).Location.mVA;
            if ((localObject1 != null) && (!((String)localObject1).equals("")))
            {
              paramViewGroup.KWo.setText((CharSequence)localObject1);
              paramViewGroup.KWo.setVisibility(0);
            }
          }
          paramViewGroup.KAY.setVisibility(0);
        }
        else
        {
          if ((this.KVZ == 0L) || (((SnsInfo)localObject2).field_snsId != this.KVZ)) {
            break label1300;
          }
          paramViewGroup.KWp.setVisibility(0);
          label1094:
          paramViewGroup.KWm.setVisibility(0);
          if ((!this.fCB) || (paramInt != 0) || ((this.isSearchMode) && ((!this.isSearchMode) || (!this.KWa)))) {
            break label1319;
          }
          paramViewGroup.KWy.setVisibility(0);
          paramViewGroup.KWy.setContentDescription(this.fDf.getString(i.j.sns_take_photo));
          paramViewGroup.KWx.setVisibility(8);
          localObject2 = paramViewGroup.KWB;
          if (this.KAH != 1) {
            break label1312;
          }
        }
        label1312:
        for (localObject1 = this.fDf.getString(i.j.sns_user_start);; localObject1 = "")
        {
          ((MMNeat7extView)localObject2).aL((CharSequence)localObject1);
          paramViewGroup.KWB.setVisibility(0);
          paramViewGroup.KWG.setVisibility(0);
          paramViewGroup.KWF.setVisibility(8);
          aj.fOF().d(paramViewGroup.KWy, i.c.sns_user_take_photo_bg, i.e.sns_takephoto_icon, this.fDf.hashCode());
          localObject1 = new bj.g.a();
          ((bj.g.a)localObject1).fWh = -1;
          ((bj.g.a)localObject1).position = -1;
          paramViewGroup.KWy.setTag(localObject1);
          AppMethodBeat.o(99038);
          return paramView;
          localObject1 = ((TimeLineObject)localObject1).Location.poiName;
          break;
          paramViewGroup.KWp.setVisibility(8);
          break label1094;
        }
        label1319:
        b(paramViewGroup.KWl, j, ((SnsInfo)localObject2).getHead());
        if (k > 0)
        {
          a(i, paramViewGroup.KWx, paramViewGroup.KWC, paramViewGroup.KWF, paramViewGroup.KWH, paramViewGroup.KWK, 1, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.g.Kia.O((SnsInfo)getItem(i));
        }
        if (k >= 2)
        {
          a(i + 1, paramViewGroup.KWz, paramViewGroup.KWD, paramViewGroup.KWF, paramViewGroup.KWI, paramViewGroup.KWL, 2, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.g.Kia.O((SnsInfo)getItem(i + 1));
        }
        if (k >= 3)
        {
          a(i + 2, paramViewGroup.KWA, paramViewGroup.KWE, paramViewGroup.KWF, paramViewGroup.KWJ, paramViewGroup.KWM, 3, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.g.Kia.O((SnsInfo)getItem(i + 2));
        }
        if (k == 1)
        {
          localObject1 = (SnsInfo)getItem(i);
          if ((!Util.isNullOrNil(((SnsInfo)localObject1).getTimeLine().ContentDesc)) && (((SnsInfo)localObject1).getTypeFlag() == 1))
          {
            paramViewGroup.KWN.setDescendantFocusability(393216);
            paramViewGroup.KWN.setClickable(true);
            paramViewGroup.KWx.setClickable(false);
            paramViewGroup.KWx.settouchEnable(false);
            paramViewGroup.KWN.setOnClickListener(this.KVR.KAO);
            paramViewGroup.KWN.settouchEnable(true);
            i = ((SnsInfo)localObject2).localid;
            localObject2 = new bj.g.a();
            ((bj.g.a)localObject2).fWh = i;
            if (this.KVQ.get(Integer.valueOf(paramInt)) == null) {
              break label1702;
            }
          }
        }
        label1702:
        for (((bj.g.a)localObject2).position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt))).intValue();; ((bj.g.a)localObject2).position = 0)
        {
          if ((((SnsInfo)localObject1).isInValid()) && (((SnsInfo)localObject1).isDieItem())) {
            paramViewGroup.KWN.setOnLongClickListener(this.KVR.KWR);
          }
          paramViewGroup.KWN.setTag(localObject2);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(99038);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof f)))
          {
            paramViewGroup = new f();
            paramView = ad.kS(this.fDf).inflate(i.g.sns_sight_user, null);
            paramViewGroup.KWk = ((TextView)paramView.findViewById(i.f.sns_day));
            paramViewGroup.KWj = ((TextView)paramView.findViewById(i.f.sns_month));
            paramViewGroup.KWl = ((TextView)paramView.findViewById(i.f.sns_year));
            paramViewGroup.KWx = ((MaskImageView)paramView.findViewById(i.f.img1));
            paramViewGroup.KWo = ((TextView)paramView.findViewById(i.f.address));
            paramViewGroup.KWm = ((LinearLayout)paramView.findViewById(i.f.line_add_item));
            paramViewGroup.KWn = ((ImageView)paramView.findViewById(i.f.lock_line_add_item_b));
            paramViewGroup.KAX = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
            paramViewGroup.KAY = paramView.findViewById(i.f.line_add);
            paramViewGroup.KWx.setOnClickListener(this.KVR.KWQ);
            paramViewGroup.KWH = ((TextView)paramView.findViewById(i.f.warn1));
            paramViewGroup.KWN = ((MaskLinearLayout)paramView.findViewById(i.f.sns_line_blackground));
            paramViewGroup.KWN.b(paramViewGroup.KWx);
            paramViewGroup.KWB = ((MMNeat7extView)paramView.findViewById(i.f.desc));
            paramViewGroup.KWG = paramView.findViewById(i.f.desc_count);
            paramViewGroup.KWp = ((LinearLayout)paramView.findViewById(i.f.friends_limit));
            paramViewGroup.KWq = ((TextView)paramView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
            paramViewGroup.KWq.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(99021);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("enter_scene", f.m.VSz);
                com.tencent.mm.by.c.b(bj.f(bj.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(8) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99021);
              }
            });
            paramView.setTag(paramViewGroup);
            aj.fOF().gm(paramViewGroup.KWx);
            if (this.KAF.get(Integer.valueOf(paramInt)) == null) {
              break label5673;
            }
          }
        }
        label2845:
        label3997:
        label4004:
        label5673:
        for (i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.KWl.setTag(Integer.valueOf(paramInt));
          paramViewGroup.KWN.settouchEnable(false);
          paramViewGroup.KWN.setBackgroundResource(0);
          paramViewGroup.KWN.setDescendantFocusability(131072);
          paramViewGroup.KWN.setClickable(false);
          paramViewGroup.KWx.settouchEnable(true);
          paramViewGroup.KWx.setClickable(true);
          paramViewGroup.KWN.setOnClickListener(null);
          if ((i >= this.KAI) || (i == -1))
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            paramView.setVisibility(8);
            AppMethodBeat.o(99038);
            return paramView;
            paramViewGroup = (f)paramView.getTag();
            break;
          }
          if (i - 1 >= 0)
          {
            localObject1 = (SnsInfo)getItem(i - 1);
            j = ((SnsInfo)localObject1).getHead();
            an.aZ(((SnsInfo)localObject1).getLocalPrivate(), this.fCB);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.KAG.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.KAG.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject2 = (SnsInfo)getItem(i);
            Object localObject3 = ((SnsInfo)localObject2).getTimeLine();
            if (((this.fCB) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject2).getHead() != j))
            {
              if (aV(paramInt, ((SnsInfo)localObject2).field_snsId))
              {
                l = ((SnsInfo)localObject2).getCreateTime();
                a(paramViewGroup.KWj, paramViewGroup.KWk, l);
              }
              if (((TimeLineObject)localObject3).Location != null)
              {
                if (!Util.isNullOrNil(((TimeLineObject)localObject3).Location.poiName)) {
                  break label2832;
                }
                localObject1 = ((TimeLineObject)localObject3).Location.mVA;
                if ((localObject1 != null) && (!((String)localObject1).equals("")))
                {
                  paramViewGroup.KWo.setText((CharSequence)localObject1);
                  paramViewGroup.KWo.setVisibility(0);
                }
              }
              paramViewGroup.KAY.setVisibility(0);
            }
            else
            {
              b(paramViewGroup.KWl, j, ((SnsInfo)localObject2).getHead());
              if ((this.KVZ == 0L) || (((SnsInfo)localObject2).field_snsId != this.KVZ)) {
                break label2845;
              }
              paramViewGroup.KWp.setVisibility(0);
              label2476:
              paramViewGroup.KWm.setVisibility(0);
              localObject1 = new bp(this.KVP.tag);
              ((bp)localObject1).time = ((SnsInfo)localObject2).field_createTime;
              paramViewGroup.KWx.setVisibility(0);
              aj.fOF().a(((TimeLineObject)localObject3).ContentObj.Sqr, paramViewGroup.KWx, this.fDf.hashCode(), g.a.JUP, (bp)localObject1);
              if (an.aZ(((SnsInfo)localObject2).getLocalPrivate(), this.fCB))
              {
                paramViewGroup.KWH.setVisibility(0);
                paramViewGroup.KWH.setBackgroundResource(i.e.personactivity_keyphoto_icon);
                localObject1 = this.KOY.RG(((SnsInfo)localObject2).getUserName());
                if (localObject1 != null) {
                  ((d)localObject1).ays();
                }
              }
              localObject1 = (SnsInfo)getItem(i);
              localObject3 = ((SnsInfo)localObject1).getTimeLine().ContentDesc;
              if ((localObject3 != null) && (!((String)localObject3).equals("")))
              {
                paramViewGroup.KWG.setVisibility(0);
                paramViewGroup.KWB.setVisibility(0);
                paramViewGroup.KWB.aL(com.tencent.mm.pluginsdk.ui.span.l.b(this.fDf, (CharSequence)localObject3, paramViewGroup.KWB.getTextSize()));
              }
              paramViewGroup.KWN.setDescendantFocusability(393216);
              paramViewGroup.KWN.setClickable(true);
              paramViewGroup.KWx.setClickable(false);
              paramViewGroup.KWx.settouchEnable(false);
              paramViewGroup.KWN.setOnClickListener(this.KVR.KWQ);
              paramViewGroup.KWN.settouchEnable(true);
              i = ((SnsInfo)localObject2).localid;
              localObject2 = new bj.g.a();
              ((bj.g.a)localObject2).fWh = i;
              if (this.KVQ.get(Integer.valueOf(paramInt)) == null) {
                break label2857;
              }
            }
            label2857:
            for (((bj.g.a)localObject2).position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt))).intValue();; ((bj.g.a)localObject2).position = 0)
            {
              paramViewGroup.KWN.setTag(localObject2);
              paramView.setDrawingCacheEnabled(false);
              com.tencent.mm.plugin.sns.k.g.Kia.O((SnsInfo)localObject1);
              AppMethodBeat.o(99038);
              return paramView;
              localObject1 = ((TimeLineObject)localObject3).Location.poiName;
              break;
              paramViewGroup.KWp.setVisibility(8);
              break label2476;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
              {
                paramViewGroup = new e();
                paramView = ad.kS(this.fDf).inflate(i.g.sns_photo_user_photo, null);
                paramViewGroup.KWk = ((TextView)paramView.findViewById(i.f.sns_day));
                paramViewGroup.KWj = ((TextView)paramView.findViewById(i.f.sns_month));
                paramViewGroup.KWl = ((TextView)paramView.findViewById(i.f.sns_year));
                paramViewGroup.KWx = ((MaskImageView)paramView.findViewById(i.f.img1));
                paramViewGroup.KWy = ((QFadeImageView)paramView.findViewById(i.f.take_photo));
                paramViewGroup.KWz = ((MaskImageView)paramView.findViewById(i.f.img2));
                paramViewGroup.KWA = ((MaskImageView)paramView.findViewById(i.f.img3));
                paramViewGroup.KWB = ((MMNeat7extView)paramView.findViewById(i.f.desc));
                paramViewGroup.KWC = ((TextView)paramView.findViewById(i.f.with_username1));
                paramViewGroup.KWD = ((TextView)paramView.findViewById(i.f.with_username2));
                paramViewGroup.KWE = ((TextView)paramView.findViewById(i.f.with_username3));
                paramViewGroup.KWF = ((TextView)paramView.findViewById(i.f.img_count));
                paramViewGroup.KWG = paramView.findViewById(i.f.desc_count);
                paramViewGroup.KWo = ((TextView)paramView.findViewById(i.f.address));
                paramViewGroup.KWm = ((LinearLayout)paramView.findViewById(i.f.line_add_item));
                paramViewGroup.KWn = ((ImageView)paramView.findViewById(i.f.lock_line_add_item_b));
                paramViewGroup.KAX = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
                paramViewGroup.KAY = paramView.findViewById(i.f.line_add);
                paramViewGroup.KWy.setOnClickListener(this.KVR.KWP);
                paramViewGroup.KWx.setOnClickListener(this.KVR.KWP);
                paramViewGroup.KWH = ((TextView)paramView.findViewById(i.f.warn1));
                paramViewGroup.KWI = ((TextView)paramView.findViewById(i.f.warn2));
                paramViewGroup.KWJ = ((TextView)paramView.findViewById(i.f.warn3));
                paramViewGroup.KWK = ((TextView)paramView.findViewById(i.f.tv1));
                paramViewGroup.KWL = ((TextView)paramView.findViewById(i.f.tv2));
                paramViewGroup.KWM = ((TextView)paramView.findViewById(i.f.tv3));
                paramViewGroup.KWN = ((MaskLinearLayout)paramView.findViewById(i.f.sns_line_blackground));
                paramViewGroup.KWN.b(paramViewGroup.KWx);
                paramViewGroup.KWp = ((LinearLayout)paramView.findViewById(i.f.friends_limit));
                paramViewGroup.KWq = ((TextView)paramView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
                paramViewGroup.KWq.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(268013);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("enter_scene", f.m.VSz);
                    com.tencent.mm.by.c.b(bj.f(bj.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                    com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(8) });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(268013);
                  }
                });
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                aj.fOF().gm(paramViewGroup.KWx);
                aj.fOF().gm(paramViewGroup.KWz);
                aj.fOF().gm(paramViewGroup.KWA);
                i = -1;
                if (this.KAF.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.KWl.setTag(Integer.valueOf(paramInt));
                paramViewGroup.KWN.settouchEnable(false);
                paramViewGroup.KWN.setBackgroundResource(0);
                paramViewGroup.KWN.setDescendantFocusability(131072);
                paramViewGroup.KWN.setClickable(false);
                paramViewGroup.KWx.settouchEnable(true);
                paramViewGroup.KWx.setClickable(true);
                paramViewGroup.KWN.setOnClickListener(null);
                if ((i < this.KAI) && (i != -1)) {
                  break;
                }
                paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                paramView.setVisibility(8);
                AppMethodBeat.o(99038);
                return paramView;
                paramViewGroup = (e)paramView.getTag();
              }
              if (i - 1 < 0) {
                break label5661;
              }
              localObject1 = (SnsInfo)getItem(i - 1);
              j = ((SnsInfo)localObject1).getHead();
              an.aZ(((SnsInfo)localObject1).getLocalPrivate(), this.fCB);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject2 = (SnsInfo)getItem(i);
              localObject1 = ((SnsInfo)localObject2).getTimeLine();
              if (((this.fCB) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject2).getHead() != j))
              {
                if (aV(paramInt, ((SnsInfo)localObject2).field_snsId))
                {
                  l = ((SnsInfo)localObject2).getCreateTime();
                  a(paramViewGroup.KWj, paramViewGroup.KWk, l);
                }
                if (((TimeLineObject)localObject1).Location != null)
                {
                  if (!Util.isNullOrNil(((TimeLineObject)localObject1).Location.poiName)) {
                    break label3972;
                  }
                  localObject1 = ((TimeLineObject)localObject1).Location.mVA;
                  if ((localObject1 != null) && (!((String)localObject1).equals("")))
                  {
                    paramViewGroup.KWo.setText((CharSequence)localObject1);
                    paramViewGroup.KWo.setVisibility(0);
                  }
                }
                paramViewGroup.KAY.setVisibility(0);
              }
              else
              {
                b(paramViewGroup.KWl, j, ((SnsInfo)localObject2).getHead());
                if ((this.KVZ == 0L) || (((SnsInfo)localObject2).field_snsId != this.KVZ)) {
                  break label3985;
                }
                paramViewGroup.KWp.setVisibility(0);
                label3800:
                paramViewGroup.KWm.setVisibility(0);
                if ((!this.fCB) || (paramInt != 0)) {
                  break label4004;
                }
                paramViewGroup.KWy.setVisibility(0);
                paramViewGroup.KWy.setContentDescription(this.fDf.getString(i.j.sns_take_photo));
                paramViewGroup.KWx.setVisibility(8);
                localObject2 = paramViewGroup.KWB;
                if (this.KAH != 1) {
                  break label3997;
                }
              }
              for (localObject1 = this.fDf.getString(i.j.sns_user_start);; localObject1 = "")
              {
                ((MMNeat7extView)localObject2).aL((CharSequence)localObject1);
                paramViewGroup.KWB.setVisibility(0);
                paramViewGroup.KWG.setVisibility(0);
                paramViewGroup.KWF.setVisibility(8);
                aj.fOF().d(paramViewGroup.KWy, i.c.sns_user_take_photo_bg, i.e.sns_takephoto_icon, this.fDf.hashCode());
                localObject1 = new bj.g.a();
                ((bj.g.a)localObject1).fWh = -1;
                ((bj.g.a)localObject1).position = -1;
                paramViewGroup.KWy.setTag(localObject1);
                AppMethodBeat.o(99038);
                return paramView;
                localObject1 = ((TimeLineObject)localObject1).Location.poiName;
                break;
                paramViewGroup.KWp.setVisibility(8);
                break label3800;
              }
              a(i, paramViewGroup.KWx, paramViewGroup.KWC, paramViewGroup.KWF, paramViewGroup.KWH, paramViewGroup.KWK, 1, paramViewGroup, paramInt);
              localObject1 = (SnsInfo)getItem(i);
              if ((!Util.isNullOrNil(((SnsInfo)localObject1).getTimeLine().ContentDesc)) && (((SnsInfo)localObject1).getTypeFlag() == 1))
              {
                paramViewGroup.KWN.setDescendantFocusability(393216);
                paramViewGroup.KWN.setClickable(true);
                paramViewGroup.KWx.setClickable(false);
                paramViewGroup.KWx.settouchEnable(false);
                paramViewGroup.KWN.setOnClickListener(this.KVR.KWP);
                paramViewGroup.KWN.settouchEnable(true);
                i = ((SnsInfo)localObject2).localid;
                localObject2 = new bj.g.a();
                ((bj.g.a)localObject2).fWh = i;
                if (this.KVQ.get(Integer.valueOf(paramInt)) == null) {
                  break label4216;
                }
              }
              label4216:
              for (((bj.g.a)localObject2).position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt))).intValue();; ((bj.g.a)localObject2).position = 0)
              {
                paramViewGroup.KWN.setTag(localObject2);
                com.tencent.mm.plugin.sns.k.g.Kia.O((SnsInfo)localObject1);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 4)
              {
                paramView = q(paramInt, paramView);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 5) {
                if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
                {
                  paramViewGroup = new c();
                  localObject1 = ad.kS(this.fDf).inflate(i.g.sns_photo_user_normal, null);
                  paramViewGroup.KWi = ((View)localObject1).findViewById(i.f.content_ll);
                  paramViewGroup.KWk = ((TextView)((View)localObject1).findViewById(i.f.sns_day));
                  paramViewGroup.KWj = ((TextView)((View)localObject1).findViewById(i.f.sns_month));
                  paramViewGroup.KWl = ((TextView)((View)localObject1).findViewById(i.f.sns_year));
                  paramViewGroup.KWo = ((TextView)((View)localObject1).findViewById(i.f.address));
                  paramViewGroup.KAY = ((View)localObject1).findViewById(i.f.line_add);
                  paramViewGroup.KWo = ((TextView)((View)localObject1).findViewById(i.f.address));
                  paramViewGroup.KWm = ((LinearLayout)((View)localObject1).findViewById(i.f.line_add_item));
                  paramViewGroup.KWn = ((ImageView)((View)localObject1).findViewById(i.f.lock_line_add_item_b));
                  paramViewGroup.KAX = ((LinearLayout)((View)localObject1).findViewById(i.f.listener_keeper));
                  paramViewGroup.HdL = ((MMNeat7extView)((View)localObject1).findViewById(i.f.desc_tv));
                  paramViewGroup.KWv = ((TagImageView)((View)localObject1).findViewById(i.f.image_left));
                  paramViewGroup.yVe = ((ImageView)((View)localObject1).findViewById(i.f.state));
                  paramViewGroup.titleTv = ((TextView)((View)localObject1).findViewById(i.f.titletext));
                  paramViewGroup.KWt = ((TextView)((View)localObject1).findViewById(i.f.righttext));
                  paramViewGroup.KWi.setOnClickListener(this.KVR.KWO);
                  paramViewGroup.KWu = ((View)localObject1).findViewById(i.f.media_content_rl);
                  paramViewGroup.KWw = ((TextView)((View)localObject1).findViewById(i.f.content_left));
                  paramViewGroup.KWp = ((LinearLayout)((View)localObject1).findViewById(i.f.friends_limit));
                  paramViewGroup.KWq = ((TextView)((View)localObject1).findViewById(i.f.sns_no_see_tip_reset_tips_btn));
                  paramViewGroup.KWq.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(163121);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bn(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                      paramAnonymousView = new Intent();
                      paramAnonymousView.putExtra("enter_scene", f.m.VSz);
                      com.tencent.mm.by.c.b(bj.f(bj.this), "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.IzE.a(14098, new Object[] { Integer.valueOf(8) });
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(163121);
                    }
                  });
                  ((View)localObject1).setTag(paramViewGroup);
                  t.b(paramViewGroup.KWv, this.fDf);
                  paramViewGroup.KWl.setTag(Integer.valueOf(paramInt));
                  if (this.KAF.get(Integer.valueOf(paramInt)) == null) {
                    break label5655;
                  }
                }
              }
              for (i = ((Integer)this.KAF.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                paramViewGroup.init();
                if ((i >= this.KAI) || (i == -1))
                {
                  ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                  ((View)localObject1).setVisibility(8);
                  AppMethodBeat.o(99038);
                  return localObject1;
                  paramViewGroup = (c)paramView.getTag();
                  localObject1 = paramView;
                  break;
                }
                ((View)localObject1).setVisibility(0);
                if (i - 1 >= 0)
                {
                  paramView = (SnsInfo)getItem(i - 1);
                  j = paramView.getHead();
                  an.aZ(paramView.getLocalPrivate(), this.fCB);
                }
                for (;;)
                {
                  ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  ((View)localObject1).setVisibility(0);
                  localObject3 = (SnsInfo)getItem(i);
                  localObject2 = ((SnsInfo)localObject3).getTimeLine();
                  if (((this.fCB) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject3).getHead() != j))
                  {
                    if (aV(paramInt, ((SnsInfo)localObject3).field_snsId))
                    {
                      l = ((SnsInfo)localObject3).getCreateTime();
                      a(paramViewGroup.KWj, paramViewGroup.KWk, l);
                    }
                    if (((TimeLineObject)localObject2).Location != null)
                    {
                      if (!Util.isNullOrNil(((TimeLineObject)localObject2).Location.poiName)) {
                        break label5178;
                      }
                      paramView = ((TimeLineObject)localObject2).Location.mVA;
                      if ((paramView != null) && (!paramView.equals("")))
                      {
                        paramViewGroup.KWo.setText(paramView);
                        paramViewGroup.KWo.setVisibility(0);
                      }
                    }
                    paramViewGroup.KAY.setVisibility(0);
                  }
                  else
                  {
                    b(paramViewGroup.KWl, j, ((SnsInfo)localObject3).getHead());
                    if ((this.KVZ == 0L) || (((SnsInfo)localObject3).field_snsId != this.KVZ)) {
                      break label5190;
                    }
                    paramViewGroup.KWp.setVisibility(0);
                    label4988:
                    paramView = new bj.g.a();
                    paramView.fWh = ((SnsInfo)localObject3).localid;
                    if (this.KVQ.get(Integer.valueOf(paramInt)) == null) {
                      break label5202;
                    }
                    paramView.position = ((Integer)this.KVQ.get(Integer.valueOf(paramInt))).intValue();
                    label5044:
                    paramViewGroup.KWi.setTag(paramView);
                    if (Util.isNullOrNil(((TimeLineObject)localObject2).ContentDesc)) {
                      break label5210;
                    }
                    paramViewGroup.HdL.setVisibility(0);
                    paramViewGroup.HdL.aL(com.tencent.mm.pluginsdk.ui.span.l.b(this.fDf, ((TimeLineObject)localObject2).ContentDesc, paramViewGroup.HdL.getTextSize()));
                  }
                  bp localbp;
                  for (;;)
                  {
                    paramViewGroup.KWm.setVisibility(0);
                    paramViewGroup.HdL.getWrappedTextView().setSingleLine(true);
                    paramViewGroup.KWu.setVisibility(0);
                    localbp = new bp(this.KVP.tag);
                    localbp.time = ((SnsInfo)localObject3).field_createTime;
                    if (((TimeLineObject)localObject2).ContentObj.Sqw != null) {
                      break label5222;
                    }
                    Log.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                    AppMethodBeat.o(99038);
                    return localObject1;
                    label5178:
                    paramView = ((TimeLineObject)localObject2).Location.poiName;
                    break;
                    label5190:
                    paramViewGroup.KWp.setVisibility(8);
                    break label4988;
                    label5202:
                    paramView.position = 0;
                    break label5044;
                    label5210:
                    paramViewGroup.HdL.setVisibility(8);
                  }
                  label5222:
                  paramViewGroup.titleTv.setTextColor(this.fDf.getResources().getColor(i.c.normal_text_color));
                  paramView = "";
                  if (((TimeLineObject)localObject2).ContentObj.Sqw != null)
                  {
                    paramViewGroup.KWv.setVisibility(0);
                    paramView = ((TimeLineObject)localObject2).ContentObj.Sqw.title;
                    cvt localcvt = new cvt();
                    localcvt.Url = ((TimeLineObject)localObject2).ContentObj.Sqw.lpK;
                    localcvt.TDF = ((TimeLineObject)localObject2).ContentObj.Sqw.lpK;
                    localcvt.rWu = 2;
                    localcvt.TDG = 1;
                    localcvt.TDH = new cvv();
                    localcvt.TlV = 1;
                    localcvt.TDH.TEu = ((TimeLineObject)localObject2).ContentObj.Sqw.width;
                    localcvt.TDH.TEv = ((TimeLineObject)localObject2).ContentObj.Sqw.height;
                    localcvt.Id = ((SnsInfo)localObject3).getSnsId();
                    aj.fOF().a(localcvt, paramViewGroup.KWv, this.fDf.hashCode(), g.a.JUP, localbp);
                  }
                  localObject2 = paramView;
                  if (paramView.length() > 40) {
                    localObject2 = paramView.substring(0, 40) + "...";
                  }
                  if (paramViewGroup.KWv != null) {
                    paramViewGroup.KWv.setOnClickListener(null);
                  }
                  paramViewGroup.yVe.setVisibility(0);
                  paramViewGroup.yVe.setImageDrawable(au.o(paramViewGroup.yVe.getContext(), i.i.icons_outlined_video_call, -1));
                  paramViewGroup.KWt.setVisibility(8);
                  if (!Util.isNullOrNil((String)localObject2)) {
                    if (paramViewGroup.KWt.getVisibility() == 8)
                    {
                      paramViewGroup.titleTv.setMaxLines(2);
                      paramViewGroup.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.fDf, (CharSequence)localObject2));
                      paramViewGroup.titleTv.setVisibility(0);
                    }
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.sns.k.g.Kia.O((SnsInfo)localObject3);
                    ((View)localObject1).setDrawingCacheEnabled(false);
                    AppMethodBeat.o(99038);
                    return localObject1;
                    paramViewGroup.titleTv.setMaxLines(1);
                    break;
                    paramViewGroup.titleTv.setVisibility(8);
                  }
                  if (i == 6)
                  {
                    paramView = o(paramInt, paramView);
                    AppMethodBeat.o(99038);
                    return paramView;
                  }
                  paramView = p(paramInt, paramView);
                  AppMethodBeat.o(99038);
                  return paramView;
                  j = -1;
                }
              }
              j = -1;
            }
            j = -1;
          }
        }
      }
      label2832:
      label3985:
      label5685:
      j = -1;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final ArrayList<com.tencent.mm.plugin.sns.j.b> jV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99052);
    ArrayList localArrayList = new ArrayList();
    this.KWd = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      SnsInfo localSnsInfo = (SnsInfo)this.list.get(paramInt2);
      int j = localSnsInfo.localid;
      if ((localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (localSnsInfo.getTimeLine().ContentObj.Sqr.size() != 0) && ((localSnsInfo.getTimeLine().ContentObj.Sqq == 1) || (localSnsInfo.getTimeLine().ContentObj.Sqq == 15)))
      {
        if (j == paramInt1) {
          this.KWd = localArrayList.size();
        }
        Iterator localIterator = localSnsInfo.getTimeLine().ContentObj.Sqr.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          cvt localcvt = (cvt)localIterator.next();
          com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
          localb.fVT = localcvt;
          localb.parentId = y.bt("sns_table_", j);
          localb.createTime = localSnsInfo.getCreateTime();
          localb.KeQ = i;
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
    LinearLayout KAX;
    View KAY;
    View KWi;
    TextView KWj;
    TextView KWk;
    TextView KWl;
    LinearLayout KWm;
    ImageView KWn;
    TextView KWo;
    LinearLayout KWp;
    TextView KWq;
    
    a() {}
    
    public void init()
    {
      AppMethodBeat.i(99026);
      this.KWj.setVisibility(8);
      this.KWk.setVisibility(8);
      this.KWl.setVisibility(8);
      this.KWm.setVisibility(4);
      this.KWn.setVisibility(4);
      this.KAY.setVisibility(8);
      this.KWo.setVisibility(8);
      this.KWp.setVisibility(8);
      AppMethodBeat.o(99026);
    }
  }
  
  final class b
    extends bj.a
  {
    MMNeat7extView HdL;
    MMRoundCornerImageView KWr;
    WeImageView KWs;
    TextView KWt;
    View KWu;
    TextView titleTv;
    
    b()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(201161);
      super.init();
      this.HdL.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.KWt.setVisibility(8);
      AppMethodBeat.o(201161);
    }
  }
  
  final class c
    extends bj.a
  {
    MMNeat7extView HdL;
    TextView KWt;
    View KWu;
    TagImageView KWv;
    TextView KWw;
    TextView titleTv;
    ImageView yVe;
    
    c()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99027);
      super.init();
      this.HdL.setVisibility(8);
      this.KWv.setVisibility(8);
      if (this.KWw != null) {
        this.KWw.setVisibility(8);
      }
      this.yVe.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.KWt.setVisibility(8);
      AppMethodBeat.o(99027);
    }
  }
  
  public static abstract interface d
  {
    public abstract void fWU();
  }
  
  final class e
    extends bj.a
  {
    QFadeImageView KWA;
    MMNeat7extView KWB;
    TextView KWC;
    TextView KWD;
    TextView KWE;
    TextView KWF;
    View KWG;
    TextView KWH;
    TextView KWI;
    TextView KWJ;
    TextView KWK;
    TextView KWL;
    TextView KWM;
    MaskLinearLayout KWN;
    MaskImageView KWx;
    QFadeImageView KWy;
    QFadeImageView KWz;
    
    e()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99028);
      super.init();
      this.KWx.setVisibility(8);
      this.KWz.setVisibility(8);
      this.KWA.setVisibility(8);
      this.KWB.setVisibility(8);
      this.KWC.setVisibility(8);
      this.KWD.setVisibility(8);
      this.KWE.setVisibility(8);
      this.KWF.setVisibility(8);
      this.KWG.setVisibility(8);
      this.KWy.setVisibility(8);
      this.KWH.setVisibility(8);
      this.KWI.setVisibility(8);
      this.KWJ.setVisibility(8);
      this.KWK.setVisibility(8);
      this.KWL.setVisibility(8);
      this.KWM.setVisibility(8);
      if (com.tencent.mm.ci.a.ez(bj.f(bj.this)) > 1.0F) {
        this.KWB.setMaxLines(2);
      }
      AppMethodBeat.o(99028);
    }
  }
  
  final class f
    extends bj.a
  {
    MMNeat7extView KWB;
    View KWG;
    TextView KWH;
    MaskLinearLayout KWN;
    MaskImageView KWx;
    
    f()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99029);
      super.init();
      this.KWx.setVisibility(8);
      this.KWB.setVisibility(8);
      this.KWH.setVisibility(8);
      this.KWG.setVisibility(8);
      if (com.tencent.mm.ci.a.ez(bj.f(bj.this)) > 1.0F) {
        this.KWB.setMaxLines(2);
      }
      AppMethodBeat.o(99029);
    }
  }
  
  static abstract class g
  {
    View.OnClickListener KAO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99030);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99030);
          return;
        }
        bj.g.this.KWS = ((bj.g.a)paramAnonymousView.getTag());
        int i = bj.g.this.KWS.fWh;
        int j = bj.g.this.KWS.position;
        bj.g.this.jW(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99030);
      }
    };
    View.OnClickListener KAP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99031);
          return;
        }
        bj.g.this.KWS = ((bj.g.a)paramAnonymousView.getTag());
        int i = bj.g.this.KWS.fWh;
        int j = bj.g.this.KWS.position;
        bj.g.this.jW(i, j + 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99031);
      }
    };
    View.OnClickListener KAQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99032);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99032);
          return;
        }
        bj.g.this.KWS = ((bj.g.a)paramAnonymousView.getTag());
        int i = bj.g.this.KWS.fWh;
        int j = bj.g.this.KWS.position;
        bj.g.this.jW(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99032);
      }
    };
    View.OnClickListener KWO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99033);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "sign click");
        bj.g.this.KWS = ((bj.g.a)paramAnonymousView.getTag());
        int i = bj.g.this.KWS.fWh;
        int j = bj.g.this.KWS.position;
        bj.g.this.jX(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99033);
      }
    };
    View.OnClickListener KWP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99034);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "sign click");
        bj.g.this.KWS = ((bj.g.a)paramAnonymousView.getTag());
        int i = bj.g.this.KWS.fWh;
        bj.g.this.ahm(i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99034);
      }
    };
    View.OnClickListener KWQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99035);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "snssight click");
        bj.g.this.KWS = ((bj.g.a)paramAnonymousView.getTag());
        int i = bj.g.this.KWS.fWh;
        int j = bj.g.this.KWS.position;
        bj.g.this.jX(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99035);
      }
    };
    View.OnLongClickListener KWR = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(99036);
          return true;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
        bj.g.this.KWS = ((bj.g.a)paramAnonymousView.getTag());
        int i = bj.g.this.KWS.fWh;
        int j = bj.g.this.KWS.position;
        bj.g.this.jY(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(99036);
        return true;
      }
    };
    public a KWS = new a();
    
    public abstract void ahm(int paramInt);
    
    public abstract void jW(int paramInt1, int paramInt2);
    
    public abstract void jX(int paramInt1, int paramInt2);
    
    public abstract void jY(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public int fWh;
      public int position;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bj
 * JD-Core Version:    0.7.0.1
 */