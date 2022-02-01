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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.i;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.model.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class bh
  extends BaseAdapter
{
  long DJx;
  private bv EBg;
  private bp EHN;
  private Map<Integer, Integer> EHO;
  private g EHP;
  boolean EHQ;
  bi EHR;
  bj EHS;
  private d EHT;
  int EHU;
  int EHV;
  private long EHW;
  private long EHX;
  boolean EHY;
  private int EHZ;
  private int EIa;
  int EIb;
  protected View.OnClickListener EIc;
  Map<Integer, Integer> Enw;
  private Map<Integer, Integer> Enx;
  private int Eny;
  private int Enz;
  String EvF;
  private String country;
  private boolean dJM;
  private Activity dKq;
  boolean isSearchMode;
  List<SnsInfo> list;
  String sNG;
  private String userName;
  private boolean xwi;
  private String yFy;
  
  public bh(Activity paramActivity, g paramg, String paramString, final d paramd)
  {
    AppMethodBeat.i(99037);
    this.userName = "";
    this.list = new ArrayList();
    this.Enw = new HashMap();
    this.Enx = new HashMap();
    this.EHO = new HashMap();
    this.Eny = 0;
    this.Enz = 0;
    this.dJM = false;
    this.EvF = "";
    this.EHQ = false;
    this.xwi = false;
    this.DJx = 0L;
    this.sNG = "";
    this.EBg = null;
    this.yFy = "";
    this.EHU = 2147483647;
    this.EHV = 0;
    this.EHW = 0L;
    this.EHX = 0L;
    this.isSearchMode = false;
    this.EHY = false;
    this.EHZ = 0;
    this.EIa = 0;
    this.EIb = 0;
    this.EIc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203630);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          localObject = (TimeLineObject)paramAnonymousView.getTag();
          if (bh.aRd(((TimeLineObject)localObject).Id)) {
            break label196;
          }
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10090, "1,0");
          if ((!com.tencent.mm.q.a.cC(bh.f(bh.this))) && (!com.tencent.mm.q.a.cA(bh.f(bh.this))) && (!com.tencent.mm.q.a.cE(bh.f(bh.this))))
          {
            String str1 = com.tencent.mm.plugin.sns.model.aj.getAccPath();
            String str2 = ((TimeLineObject)localObject).Id;
            if (((TimeLineObject)localObject).ContentObj == null) {
              break label191;
            }
            paramAnonymousView = ((TimeLineObject)localObject).ContentObj.jfy;
            paramAnonymousView = i.a(str1, (TimeLineObject)localObject, 8, com.tencent.mm.ay.h.a(str2, paramAnonymousView));
            paramAnonymousView.jfn = bh.g(bh.this);
            com.tencent.mm.ay.a.c(paramAnonymousView);
          }
        }
        for (;;)
        {
          bh.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203630);
          return;
          label191:
          paramAnonymousView = null;
          break;
          label196:
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10231, "1");
          com.tencent.mm.ay.a.bea();
        }
      }
    };
    this.userName = paramString;
    this.dKq = paramActivity;
    this.EHP = paramg;
    this.EHT = paramd;
    this.EBg = com.tencent.mm.plugin.sns.model.aj.faC();
    paramg = LocaleUtil.loadApplicationLanguage(this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.dKq);
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
    this.yFy = paramActivity;
    this.country = LocaleUtil.loadApplicationLanguage(this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.dKq);
    com.tencent.mm.kernel.g.aAi();
    paramActivity = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null);
    if (this.userName.equals(paramActivity)) {
      this.dJM = true;
    }
    Log.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.dJM) {
      this.EHN = bp.gCW();
    }
    for (;;)
    {
      this.EHR = new bi(new bi.a()
      {
        public final void b(List<SnsInfo> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99016);
          if (!bh.a(bh.this))
          {
            Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bh.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            paramAnonymousList = bh.this;
            if (!bh.b(bh.this).isEmpty()) {
              break label77;
            }
          }
          label77:
          for (long l = 0L;; l = ((SnsInfo)bh.b(bh.this).get(bh.b(bh.this).size() - 1)).field_snsId)
          {
            bh.a(paramAnonymousList, com.tencent.mm.plugin.sns.data.r.Jc(l));
            AppMethodBeat.o(99016);
            return;
          }
        }
        
        public final void fiF()
        {
          AppMethodBeat.i(99017);
          if (!bh.a(bh.this))
          {
            bh.c(bh.this);
            bh.this.notifyDataSetChanged();
            if (paramd != null) {
              paramd.fiG();
            }
          }
          AppMethodBeat.o(99017);
        }
      }, paramString, this.dJM);
      this.EHS = new bj(new bi.a()
      {
        public final void b(List<SnsInfo> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99018);
          if (bh.a(bh.this))
          {
            Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bh.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            bh.d(bh.this);
          }
          AppMethodBeat.o(99018);
        }
        
        public final void fiF()
        {
          AppMethodBeat.i(99019);
          if (bh.a(bh.this))
          {
            bh.c(bh.this);
            bh.this.notifyDataSetChanged();
            if (paramd != null) {
              paramd.fiG();
            }
          }
          AppMethodBeat.o(99019);
        }
      }, this.dJM);
      JS(0L);
      vw(false);
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
      com.tencent.mm.kernel.g.aAi();
      paramActivity = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
      if ((paramActivity != null) && (com.tencent.mm.contact.c.oR(paramActivity.field_type))) {
        this.EHN = bp.gCV();
      } else {
        this.EHN = bp.gCX();
      }
    }
  }
  
  private void JS(long paramLong)
  {
    AppMethodBeat.i(99050);
    Object localObject = com.tencent.mm.plugin.sns.data.r.Jc(com.tencent.mm.plugin.sns.model.aj.faO().b(paramLong, com.tencent.mm.plugin.sns.model.aj.faE().aPn(this.userName), this.userName, this.dJM));
    if (this.EvF.equals("")) {}
    for (;;)
    {
      this.sNG = ((String)localObject);
      localObject = com.tencent.mm.plugin.sns.model.aj.faS().aQr(this.userName).feM();
      if (((ami)localObject).Lvc != 0L) {
        break;
      }
      AppMethodBeat.o(99050);
      return;
      if (((String)localObject).compareTo(this.EvF) >= 0) {
        localObject = this.EvF;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.r.Jc(((ami)localObject).Lvc);
    if (this.sNG.equals(""))
    {
      this.sNG = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
    }
    if (((String)localObject).compareTo(this.sNG) > 0) {}
    for (;;)
    {
      this.sNG = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
      localObject = this.sNG;
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, e parame, int paramInt3)
  {
    AppMethodBeat.i(99044);
    SnsInfo localSnsInfo = (SnsInfo)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
    SnsObject localSnsObject = an.C(localSnsInfo);
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
    if ((this.dJM) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localSnsInfo.getUserName())))
    {
      paramTextView3.setBackgroundResource(2131234410);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (an.aQ(localSnsInfo.getLocalPrivate(), this.dJM))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131234404);
        localObject = this.EBg.Kn(localSnsInfo.getUserName());
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
      paramTextView1 = new bh.g.a();
      paramTextView1.ecf = paramInt1;
      if (this.EHO.get(Integer.valueOf(paramInt3)) == null) {
        break label677;
      }
      paramTextView1.position = ((Integer)this.EHO.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new bp(this.EHN.tag);
      paramTextView1.hXs = localSnsInfo.field_createTime;
      if (localTimeLineObject.ContentObj.LoU != 1) {
        break label685;
      }
      paramQFadeImageView.setVisibility(0);
      com.tencent.mm.plugin.sns.model.aj.faL().a(localTimeLineObject.ContentObj.LoV, paramQFadeImageView, this.dKq.hashCode(), g.a.DHQ, paramTextView1);
      label367:
      if ((localSnsInfo.isInValid()) && (localSnsInfo.isDieItem()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2131234402);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.ContentObj.LoV == null) || (localTimeLineObject.ContentObj.LoV.size() <= 1)) {
          break label808;
        }
        parame.EIE.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.ContentObj.LoV.size();
        paramTextView2.setText(this.dKq.getResources().getQuantityString(2131623966, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.ContentDesc;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        parame.EIE.setVisibility(0);
        parame.EIz.setVisibility(0);
        parame.EIz.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, paramQFadeImageView, parame.EIz.getTextSize()));
      }
      AppMethodBeat.o(99044);
      return;
      label559:
      localObject = ((com.tencent.mm.contact.c)localObject).arJ();
      break;
      if (!an.aQ(localSnsInfo.getLocalPrivate(), this.dJM)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(2131234404);
      localObject = this.EBg.Kn(localSnsInfo.getUserName());
      if (localObject == null) {}
      for (localObject = "";; localObject = ((com.tencent.mm.contact.c)localObject).arJ())
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
      if (localTimeLineObject.ContentObj.LoU == 2)
      {
        paramTextView4.setText(Util.nullAs(localTimeLineObject.ContentObj.Desc, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.ContentObj.LoU != 21) {
        break label367;
      }
      localSnsInfo.getPostInfo();
      boolean bool = true;
      if (this.dJM) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        com.tencent.mm.plugin.sns.model.aj.faL().a(localTimeLineObject.ContentObj.LoV, paramQFadeImageView, this.dKq.hashCode(), g.a.DHQ, paramTextView1, bool);
        break;
        if (com.tencent.mm.plugin.sns.lucky.a.m.a(localSnsInfo, localSnsObject)) {
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
    v(paramTextView);
    Log.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (this.isSearchMode)
    {
      if ((i != 0) && (paramInt2 != i))
      {
        fy(paramTextView);
        paramTextView.setText(String.format(this.dKq.getResources().getString(2131766301), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        v(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (i == 0)
    {
      if (bm.getYear() != paramInt2)
      {
        fy(paramTextView);
        paramTextView.setText(String.format(this.dKq.getResources().getString(2131766301), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        v(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (paramInt2 != i)
    {
      fy(paramTextView);
      paramTextView.setText(String.format(this.dKq.getResources().getString(2131766301), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      v(paramTextView);
    }
    AppMethodBeat.o(99040);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(99039);
    Object localObject = this.dKq;
    if (!this.yFy.equals("en")) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = (String)bm.a((Context)localObject, 1000L * paramLong, bool);
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
      localObject[0] = bm.K(this.dKq, localObject[0], this.yFy);
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
  
  private boolean aI(int paramInt, long paramLong)
  {
    return (!this.isSearchMode) || ((paramInt == 0) && (this.DJx == paramLong)) || (paramInt > 0) || (this.EHY);
  }
  
  protected static boolean aRd(String paramString)
  {
    AppMethodBeat.i(99054);
    f localf = com.tencent.mm.ay.a.bef();
    if ((localf != null) && (com.tencent.mm.ay.a.e(localf)) && (paramString.equals(localf.jeV)) && (com.tencent.mm.ay.a.bec()))
    {
      AppMethodBeat.o(99054);
      return true;
    }
    AppMethodBeat.o(99054);
    return false;
  }
  
  private static boolean fhO()
  {
    AppMethodBeat.i(163123);
    if ((aq.a.fbx() & 0x1) <= 0)
    {
      AppMethodBeat.o(163123);
      return true;
    }
    AppMethodBeat.o(163123);
    return false;
  }
  
  private void fy(View paramView)
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
      localLayoutParams.topMargin = this.dKq.getResources().getDimensionPixelSize(2131166978);
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(99042);
  }
  
  @SuppressLint({"ResourceType"})
  private View l(int paramInt, View paramView)
  {
    AppMethodBeat.i(203632);
    b localb;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localb = new b();
      localView = aa.jQ(this.dKq).inflate(2131496470, null);
      localb.EIg = localView.findViewById(2131299208);
      localb.EIi = ((TextView)localView.findViewById(2131308107));
      localb.EIh = ((TextView)localView.findViewById(2131308158));
      localb.EIj = ((TextView)localView.findViewById(2131308272));
      localb.EIm = ((TextView)localView.findViewById(2131296543));
      localb.EnP = localView.findViewById(2131303198);
      localb.EIm = ((TextView)localView.findViewById(2131296543));
      localb.EIk = ((LinearLayout)localView.findViewById(2131303199));
      localb.EIl = ((ImageView)localView.findViewById(2131303762));
      localb.EnO = ((LinearLayout)localView.findViewById(2131303241));
      localb.pIP = ((MMNeat7extView)localView.findViewById(2131299510));
      localb.EIp = ((MMRoundCornerImageView)localView.findViewById(2131305089));
      localb.titleTv = ((TextView)localView.findViewById(2131305116));
      localb.EIr = ((TextView)localView.findViewById(2131305090));
      localb.EIq = ((WeImageView)localView.findViewById(2131305099));
      localb.EIg.setOnClickListener(this.EHP.EIM);
      localb.EIs = localView.findViewById(2131304553);
      localb.EIn = ((LinearLayout)localView.findViewById(2131301795));
      localb.EIo = ((TextView)localView.findViewById(2131308173));
      localb.EIo.setOnClickListener(new bh.8(this));
      localView.setTag(localb);
      com.tencent.mm.plugin.sns.data.r.b(localb.EIp, this.dKq);
      localb.EIj.setTag(Integer.valueOf(paramInt));
      if (this.Enw.get(Integer.valueOf(paramInt)) == null) {
        break label1859;
      }
    }
    label790:
    label1727:
    label1859:
    for (int i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.Enz) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(203632);
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
        an.aQ(paramView.getLocalPrivate(), this.dJM);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.Enx.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.Enx.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject3 = (SnsInfo)getItem(i);
        TimeLineObject localTimeLineObject = ((SnsInfo)localObject3).getTimeLine();
        label846:
        Object localObject2;
        String str2;
        String str1;
        if (((this.dJM) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject3).getHead() != j))
        {
          if (aI(paramInt, ((SnsInfo)localObject3).field_snsId))
          {
            long l = ((SnsInfo)localObject3).getCreateTime();
            a(localb.EIh, localb.EIi, l);
          }
          if (localTimeLineObject.Location != null)
          {
            if (!Util.isNullOrNil(localTimeLineObject.Location.kHV)) {
              break label1524;
            }
            paramView = localTimeLineObject.Location.kea;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localb.EIm.setText(paramView);
              localb.EIm.setVisibility(0);
            }
          }
          localb.EnP.setVisibility(0);
        }
        else
        {
          a(localb.EIj, j, ((SnsInfo)localObject3).getHead());
          if ((this.EHX == 0L) || (((SnsInfo)localObject3).field_snsId != this.EHX)) {
            break label1536;
          }
          localb.EIn.setVisibility(0);
          paramView = new bh.g.a();
          paramView.ecf = ((SnsInfo)localObject3).localid;
          if (this.EHO.get(Integer.valueOf(paramInt)) == null) {
            break label1549;
          }
          paramView.position = ((Integer)this.EHO.get(Integer.valueOf(paramInt))).intValue();
          localb.EIg.setTag(paramView);
          if (Util.isNullOrNil(localTimeLineObject.ContentDesc)) {
            break label1557;
          }
          localb.pIP.setVisibility(0);
          localb.pIP.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, localTimeLineObject.ContentDesc, localb.pIP.getTextSize()));
          localb.EIk.setVisibility(0);
          localb.pIP.setMaxLines(1);
          localb.pIP.getWrappedTextView().setSingleLine(true);
          localb.EIs.setVisibility(0);
          new bp(this.EHN.tag).hXs = ((SnsInfo)localObject3).field_createTime;
          localObject2 = "";
          str2 = "";
          if ((localTimeLineObject.ContentObj == null) || (localTimeLineObject.ContentObj.jfy == null)) {
            break label1846;
          }
          str1 = localTimeLineObject.ContentObj.jfy.Ktq;
          if (!Util.isNullOrNil(str1))
          {
            Log.i("MicroMsg.SnsphotoAdapter", "has mvInfo:%s", new Object[] { str1 });
            localb.EIr.setVisibility(0);
            localb.EIr.setText(str1 + this.dKq.getString(2131763368));
          }
          localObject2 = localTimeLineObject.ContentObj.jfy.Ktp;
        }
        for (;;)
        {
          Object localObject1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            paramView = com.tencent.mm.plugin.music.h.b.aIf((String)localObject2);
            localObject1 = localObject2;
            label1105:
            Log.i("MicroMsg.SnsphotoAdapter", "coverInfo, posterInfo:%s, coverUrl: %s, coverPath: %s", new Object[] { str1, localObject1, paramView });
            if (Util.isNullOrNil((String)localObject1)) {
              break label1826;
            }
            localb.EIq.setVisibility(0);
            localb.EIs.setVisibility(0);
            localb.titleTv.setMaxLines(1);
            localb.titleTv.setTextColor(this.dKq.getResources().getColor(2131101131));
            str2 = "";
            if (localTimeLineObject.ContentObj.LoV.isEmpty()) {
              break label1839;
            }
            localObject2 = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
            ((cnb)localObject2).ecf = ((SnsInfo)localObject3).localid;
            str2 = ((cnb)localObject2).Desc;
          }
          for (localObject2 = ((cnb)localObject2).Title;; localObject2 = "")
          {
            localObject3 = new c.a();
            ((c.a)localObject3).fullPath = paramView;
            ((c.a)localObject3).jbf = true;
            ((c.a)localObject3).iaT = true;
            ((c.a)localObject3).jbd = true;
            ((c.a)localObject3).hZF = true;
            ((c.a)localObject3).jbx = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
            localObject3 = ((c.a)localObject3).bdv();
            com.tencent.mm.av.q.bcV().a((String)localObject1, localb.EIp, (com.tencent.mm.av.a.a.c)localObject3);
            localb.EIq.setPressed(false);
            if (aRd(localTimeLineObject.Id))
            {
              localb.EIq.setImageResource(2131690862);
              label1351:
              localb.EIq.setIconColor(MMApplicationContext.getContext().getResources().getColor(2131100044));
              localb.EIq.setTag(localTimeLineObject);
              localb.EIq.setOnClickListener(this.EIc);
              localb.EIs.setTag(localTimeLineObject);
              localb.titleTv.setVisibility(0);
              if (Util.isNullOrNil(str1)) {
                break label1727;
              }
              localObject1 = localObject2;
              if (!Util.isNullOrNil(str2)) {
                localObject1 = (String)localObject2 + String.format("·%s", new Object[] { str2 });
              }
              localb.titleTv.setText((CharSequence)localObject1);
              label1477:
              if (localTimeLineObject.ContentObj.jfy == null) {
                localTimeLineObject.ContentObj.jfy = new css();
              }
              localTimeLineObject.ContentObj.jfy.jfz = paramView;
            }
            for (;;)
            {
              AppMethodBeat.o(203632);
              return localView;
              label1524:
              paramView = localTimeLineObject.Location.kHV;
              break;
              localb.EIn.setVisibility(8);
              break label790;
              paramView.position = 0;
              break label846;
              localb.pIP.setVisibility(8);
              break label903;
              localObject1 = localObject2;
              paramView = str2;
              if (localTimeLineObject.ContentObj.LoV.isEmpty()) {
                break label1105;
              }
              cnb localcnb = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
              if ((localcnb != null) && (!Util.isNullOrNil(localcnb.Msz)))
              {
                localObject1 = localcnb.Msz;
                paramView = com.tencent.mm.plugin.music.h.b.aIf(localcnb.Msz);
                break label1105;
              }
              localObject1 = localObject2;
              paramView = str2;
              if (localcnb == null) {
                break label1105;
              }
              paramView = com.tencent.mm.plugin.sns.model.aj.faD().JK(localcnb.ecf);
              localObject1 = com.tencent.mm.plugin.sns.data.r.aOj(paramView.EmN);
              localObject1 = com.tencent.mm.plugin.sns.model.ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), paramView.EmN) + (String)localObject1;
              paramView = (View)localObject1;
              break label1105;
              localb.EIq.setImageResource(2131690885);
              break label1351;
              localb.titleTv.setText((CharSequence)localObject2);
              if ((localTimeLineObject.ContentObj.jfy != null) && (!Util.isNullOrNil(localTimeLineObject.ContentObj.jfy.singerName)))
              {
                localb.EIr.setVisibility(0);
                localb.EIr.setText(localTimeLineObject.ContentObj.jfy.singerName);
                break label1477;
              }
              if (Util.isNullOrNil(str2)) {
                break label1477;
              }
              localb.EIr.setVisibility(0);
              localb.EIr.setText(str2);
              break label1477;
              localb.EIs.setVisibility(8);
            }
          }
          str1 = "";
        }
        j = -1;
      }
    }
  }
  
  private View m(int paramInt, View paramView)
  {
    AppMethodBeat.i(163122);
    c localc;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localc = new c();
      localView = aa.jQ(this.dKq).inflate(2131496471, null);
      localc.EIg = localView.findViewById(2131299208);
      localc.EIi = ((TextView)localView.findViewById(2131308107));
      localc.EIh = ((TextView)localView.findViewById(2131308158));
      localc.EIj = ((TextView)localView.findViewById(2131308272));
      localc.EIm = ((TextView)localView.findViewById(2131296543));
      localc.EnP = localView.findViewById(2131303198);
      localc.EIm = ((TextView)localView.findViewById(2131296543));
      localc.EIk = ((LinearLayout)localView.findViewById(2131303199));
      localc.EIl = ((ImageView)localView.findViewById(2131303762));
      localc.EnO = ((LinearLayout)localView.findViewById(2131303241));
      localc.pIP = ((MMNeat7extView)localView.findViewById(2131299510));
      localc.EIt = ((TagImageView)localView.findViewById(2131302578));
      localc.uzC = ((ImageView)localView.findViewById(2131308376));
      localc.titleTv = ((TextView)localView.findViewById(2131309253));
      localc.EIr = ((TextView)localView.findViewById(2131307116));
      localc.EIg.setOnClickListener(this.EHP.EIM);
      localc.EIs = localView.findViewById(2131304553);
      localc.EIn = ((LinearLayout)localView.findViewById(2131301795));
      localc.EIo = ((TextView)localView.findViewById(2131308173));
      localc.EIo.setOnClickListener(new bh.9(this));
      localView.setTag(localc);
      com.tencent.mm.plugin.sns.data.r.b(localc.EIt, this.dKq);
      localc.EIj.setTag(Integer.valueOf(paramInt));
      if (this.Enw.get(Integer.valueOf(paramInt)) == null) {
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
    for (int i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localc.init();
      if ((i >= this.Enz) || (i == -1))
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
        an.aQ(paramView.getLocalPrivate(), this.dJM);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.Enx.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.Enx.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject1 = (SnsInfo)getItem(i);
        TimeLineObject localTimeLineObject = ((SnsInfo)localObject1).getTimeLine();
        label846:
        Object localObject2;
        if (((this.dJM) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject1).getHead() != j))
        {
          if (aI(paramInt, ((SnsInfo)localObject1).field_snsId))
          {
            long l = ((SnsInfo)localObject1).getCreateTime();
            a(localc.EIh, localc.EIi, l);
          }
          if (localTimeLineObject.Location != null)
          {
            if (!Util.isNullOrNil(localTimeLineObject.Location.kHV)) {
              break label1037;
            }
            paramView = localTimeLineObject.Location.kea;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localc.EIm.setText(paramView);
              localc.EIm.setVisibility(0);
            }
          }
          localc.EnP.setVisibility(0);
        }
        else
        {
          a(localc.EIj, j, ((SnsInfo)localObject1).getHead());
          if ((this.EHX == 0L) || (((SnsInfo)localObject1).field_snsId != this.EHX)) {
            break label1049;
          }
          localc.EIn.setVisibility(0);
          paramView = new bh.g.a();
          paramView.ecf = ((SnsInfo)localObject1).localid;
          if (this.EHO.get(Integer.valueOf(paramInt)) == null) {
            break label1062;
          }
          paramView.position = ((Integer)this.EHO.get(Integer.valueOf(paramInt))).intValue();
          localc.EIg.setTag(paramView);
          if (Util.isNullOrNil(localTimeLineObject.ContentDesc)) {
            break label1070;
          }
          localc.pIP.setVisibility(0);
          localc.pIP.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, localTimeLineObject.ContentDesc, localc.pIP.getTextSize()));
          localc.EIk.setVisibility(0);
          localc.pIP.setMaxLines(1);
          localc.pIP.getWrappedTextView().setSingleLine(true);
          localc.EIs.setVisibility(0);
          paramInt = localTimeLineObject.ContentObj.LoU;
          localObject2 = new bp(this.EHN.tag);
          ((bp)localObject2).hXs = ((SnsInfo)localObject1).field_createTime;
          if (paramInt != 2) {
            break label1083;
          }
          localc.pIP.setVisibility(0);
          localc.pIP.getWrappedTextView().setSingleLine(false);
          localc.pIP.setMaxLines(2);
          localc.EIs.setVisibility(8);
        }
        cnb localcnb;
        for (;;)
        {
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(163122);
          return localView;
          paramView = localTimeLineObject.Location.kHV;
          break;
          localc.EIn.setVisibility(8);
          break label790;
          paramView.position = 0;
          break label846;
          localc.pIP.setVisibility(8);
          break label903;
          if (paramInt != 4) {
            break label1424;
          }
          if (!localTimeLineObject.ContentObj.LoV.isEmpty())
          {
            localc.EIt.setVisibility(0);
            localc.uzC.setVisibility(0);
            localc.EIs.setVisibility(0);
            localc.titleTv.setMaxLines(1);
            localc.titleTv.setTextColor(this.dKq.getResources().getColor(2131101131));
            localcnb = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
            com.tencent.mm.plugin.sns.model.aj.faL().a(localcnb, localc.EIt, 2131689567, this.dKq.hashCode(), g.a.DHQ, (bp)localObject2);
            localc.uzC.setPressed(false);
            if (aRd(localTimeLineObject.Id))
            {
              localc.uzC.setImageResource(2131234170);
              label1235:
              localc.EIt.setTag(localTimeLineObject);
              localc.EIt.setOnClickListener(this.EIc);
              localcnb.ecf = ((SnsInfo)localObject1).localid;
              localc.EIs.setTag(localTimeLineObject);
              localObject1 = localcnb.Desc;
              if (Util.isNullOrNil((String)localObject1)) {
                break label1386;
              }
              localc.EIr.setVisibility(0);
              localc.EIr.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = localcnb.Title;
              if (Util.isNullOrNil((String)localObject1)) {
                break label1398;
              }
              localc.titleTv.setVisibility(0);
              localc.titleTv.setTag(paramView);
              localc.titleTv.setOnTouchListener(new af());
              localc.titleTv.setText((CharSequence)localObject1);
              break;
              localc.uzC.setImageResource(2131234185);
              break label1235;
              label1386:
              localc.EIr.setVisibility(4);
            }
            label1398:
            localc.titleTv.setVisibility(8);
          }
          else
          {
            localc.EIs.setVisibility(8);
          }
        }
        localc.titleTv.setTextColor(this.dKq.getResources().getColor(2131099746));
        if (fhO())
        {
          paramView = bk.aRf(localTimeLineObject.ContentObj.Url);
          localObject1 = localTimeLineObject.ContentObj.Title;
          if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
            break label1981;
          }
          localObject1 = ((String)localObject1).substring(0, 40) + "...";
        }
        for (;;)
        {
          if (localc.EIt != null) {
            localc.EIt.setOnClickListener(null);
          }
          localc.uzC.setVisibility(8);
          if (!localTimeLineObject.ContentObj.LoV.isEmpty())
          {
            localc.EIt.setVisibility(0);
            localcnb = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
            if (localTimeLineObject.ContentObj.LoU == 5)
            {
              paramView = bk.aRf(localcnb.Url);
              localObject1 = localcnb.Title;
              localc.uzC.setVisibility(0);
              com.tencent.mm.plugin.sns.model.aj.faL().a(localcnb, localc.EIt, 2131689584, this.dKq.hashCode(), g.a.DHQ, (bp)localObject2);
              label1649:
              localObject2 = paramView;
              if (localTimeLineObject.ContentObj.LoY != null)
              {
                localObject2 = paramView;
                if (localTimeLineObject.ContentObj.LoY.iwf == 1) {
                  localObject2 = MMApplicationContext.getContext().getString(2131763172);
                }
              }
              if (Util.isNullOrNil((String)localObject2)) {
                break label1930;
              }
              localc.EIr.setVisibility(0);
              localc.EIr.setText((CharSequence)localObject2);
              if (Util.isNullOrNil((String)localObject1)) {
                break label1968;
              }
              if (localc.EIr.getVisibility() != 8) {
                break label1943;
              }
              localc.titleTv.setMaxLines(2);
              label1749:
              localc.titleTv.setVisibility(0);
              if ((localTimeLineObject.contentattr & 0x1) <= 0) {
                break label1955;
              }
              localc.titleTv.setText(com.tencent.mm.plugin.sns.data.r.a((String)localObject1, this.dKq, localc.titleTv));
            }
          }
          for (;;)
          {
            if ((localTimeLineObject.weappInfo == null) || (localTimeLineObject.weappInfo.subType != 1)) {
              break label1979;
            }
            localc.uzC.setVisibility(0);
            localc.uzC.setImageDrawable(localc.uzC.getContext().getResources().getDrawable(2131691480));
            break;
            paramView = "";
            break label1463;
            com.tencent.mm.plugin.sns.model.aj.faL().a(localcnb, localc.EIt, this.dKq.hashCode(), g.a.DHQ, (bp)localObject2);
            break label1649;
            if (localTimeLineObject.ContentObj.LoU != 26)
            {
              localc.EIt.setVisibility(8);
              break label1649;
            }
            localc.EIt.setVisibility(0);
            localc.EIt.setImageResource(2131691246);
            break label1649;
            localc.EIr.setVisibility(8);
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
  
  private View n(int paramInt, View paramView)
  {
    AppMethodBeat.i(203633);
    c localc;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localc = new c();
      localView = aa.jQ(this.dKq).inflate(2131496471, null);
      localc.EIg = localView.findViewById(2131299208);
      localc.EIi = ((TextView)localView.findViewById(2131308107));
      localc.EIh = ((TextView)localView.findViewById(2131308158));
      localc.EIj = ((TextView)localView.findViewById(2131308272));
      localc.EIm = ((TextView)localView.findViewById(2131296543));
      localc.EnP = localView.findViewById(2131303198);
      localc.EIm = ((TextView)localView.findViewById(2131296543));
      localc.EIk = ((LinearLayout)localView.findViewById(2131303199));
      localc.EIl = ((ImageView)localView.findViewById(2131303762));
      localc.EnO = ((LinearLayout)localView.findViewById(2131303241));
      localc.pIP = ((MMNeat7extView)localView.findViewById(2131299510));
      localc.EIt = ((TagImageView)localView.findViewById(2131302578));
      localc.uzC = ((ImageView)localView.findViewById(2131308376));
      localc.titleTv = ((TextView)localView.findViewById(2131309253));
      localc.EIr = ((TextView)localView.findViewById(2131307116));
      localc.EIg.setOnClickListener(this.EHP.EIM);
      localc.EIs = localView.findViewById(2131304553);
      localc.EIu = ((TextView)localView.findViewById(2131299206));
      localc.EIn = ((LinearLayout)localView.findViewById(2131301795));
      localc.EIo = ((TextView)localView.findViewById(2131308173));
      localc.EIo.setOnClickListener(new bh.10(this));
      localView.setTag(localc);
      com.tencent.mm.plugin.sns.data.r.b(localc.EIt, this.dKq);
      localc.EIj.setTag(Integer.valueOf(paramInt));
      if (this.Enw.get(Integer.valueOf(paramInt)) == null) {
        break label3344;
      }
    }
    label770:
    label1038:
    label3344:
    for (int i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localc.init();
      if ((i >= this.Enz) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(203633);
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
        an.aQ(paramView.getLocalPrivate(), this.dJM);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        SnsInfo localSnsInfo = (SnsInfo)getItem(i);
        Object localObject3 = localSnsInfo.getTimeLine();
        Object localObject4;
        if (((this.dJM) && (paramInt == 0)) || (j == -1) || (localSnsInfo.getHead() != j))
        {
          if (aI(paramInt, localSnsInfo.field_snsId))
          {
            long l = localSnsInfo.getCreateTime();
            a(localc.EIh, localc.EIi, l);
          }
          if (((TimeLineObject)localObject3).Location != null)
          {
            if (!Util.isNullOrNil(((TimeLineObject)localObject3).Location.kHV)) {
              break label1026;
            }
            paramView = ((TimeLineObject)localObject3).Location.kea;
            if ((paramView != null) && (!paramView.equals("")))
            {
              localc.EIm.setText(paramView);
              localc.EIm.setVisibility(0);
            }
          }
          localc.EnP.setVisibility(0);
        }
        else
        {
          a(localc.EIj, j, localSnsInfo.getHead());
          if ((this.EHX == 0L) || (localSnsInfo.field_snsId != this.EHX)) {
            break label1038;
          }
          localc.EIn.setVisibility(0);
          localObject4 = new bh.g.a();
          ((bh.g.a)localObject4).ecf = localSnsInfo.localid;
          if (this.EHO.get(Integer.valueOf(paramInt)) == null) {
            break label1051;
          }
          ((bh.g.a)localObject4).position = ((Integer)this.EHO.get(Integer.valueOf(paramInt))).intValue();
          label829:
          localc.EIg.setTag(localObject4);
          if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentDesc)) {
            break label1060;
          }
          localc.pIP.setVisibility(0);
          localc.pIP.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, ((TimeLineObject)localObject3).ContentDesc, localc.pIP.getTextSize()));
        }
        bp localbp;
        for (;;)
        {
          localc.EIk.setVisibility(0);
          localc.pIP.getWrappedTextView().setSingleLine(true);
          localc.EIs.setVisibility(0);
          localbp = new bp(this.EHN.tag);
          localbp.hXs = localSnsInfo.field_createTime;
          if ((((TimeLineObject)localObject3).ContentObj.dME != null) || (((TimeLineObject)localObject3).ContentObj.Lpb != null) || (((TimeLineObject)localObject3).ContentObj.LoZ != null) || (((TimeLineObject)localObject3).ContentObj.Lpc != null) || (((TimeLineObject)localObject3).ContentObj.Lpd != null) || (((TimeLineObject)localObject3).ContentObj.Lpe != null)) {
            break label1073;
          }
          Log.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
          AppMethodBeat.o(203633);
          return localView;
          paramView = ((TimeLineObject)localObject3).Location.kHV;
          break;
          localc.EIn.setVisibility(8);
          break label770;
          label1051:
          ((bh.g.a)localObject4).position = 0;
          break label829;
          label1060:
          localc.pIP.setVisibility(8);
        }
        label1073:
        localc.titleTv.setTextColor(this.dKq.getResources().getColor(2131100904));
        Object localObject2;
        label1200:
        Object localObject1;
        if (fhO())
        {
          paramView = bk.aRf(((TimeLineObject)localObject3).ContentObj.Url);
          localObject2 = "";
          if (((TimeLineObject)localObject3).ContentObj.dME == null) {
            break label1535;
          }
          paramView = this.dKq.getString(2131766209, new Object[] { ((TimeLineObject)localObject3).ContentObj.dME.nickname });
          if (((TimeLineObject)localObject3).ContentObj.dME.vXJ != 4) {
            break label1488;
          }
          paramView = this.dKq.getString(2131766210, new Object[] { ((TimeLineObject)localObject3).ContentObj.dME.nickname });
          if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.dME.nickname)) {
            paramView = this.dKq.getResources().getString(2131759540);
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
            if (localc.EIt != null)
            {
              localc.EIt.setTag(localObject4);
              localc.EIt.setOnClickListener(this.EHP.EIM);
            }
            localc.uzC.setVisibility(8);
            if (((TimeLineObject)localObject3).ContentObj.dME != null) {
              if (((TimeLineObject)localObject3).ContentObj.dME.vXJ == 1)
              {
                localc.EIt.setVisibility(8);
                localc.EIu.setVisibility(0);
                localc.EIu.setText(((TimeLineObject)localObject3).ContentObj.dME.desc);
                label1378:
                if (Util.isNullOrNil((String)localObject1)) {
                  break label3288;
                }
                localc.EIr.setVisibility(0);
                localc.EIr.setText((CharSequence)localObject1);
                label1405:
                if (Util.isNullOrNil(paramView)) {
                  break label3313;
                }
                if (localc.EIr.getVisibility() != 8) {
                  break label3301;
                }
                localc.titleTv.setMaxLines(2);
                label1434:
                localc.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.dKq, paramView));
                localc.titleTv.setVisibility(0);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.N(localSnsInfo);
              localView.setDrawingCacheEnabled(false);
              AppMethodBeat.o(203633);
              return localView;
              paramView = "";
              break;
              label1488:
              if (((TimeLineObject)localObject3).ContentObj.dME.vXJ != 2) {
                break label1200;
              }
              paramView = this.dKq.getString(2131766208, new Object[] { ((TimeLineObject)localObject3).ContentObj.dME.nickname });
              break label1200;
              label1535:
              if (((TimeLineObject)localObject3).ContentObj.Lpb != null) {
                paramView = ((TimeLineObject)localObject3).ContentObj.Lpb.title;
              }
              for (;;)
              {
                localObject1 = "";
                break;
                if (((TimeLineObject)localObject3).ContentObj.LoZ != null)
                {
                  if (((TimeLineObject)localObject3).ContentObj.LoZ.tvC == 1) {
                    new StringBuilder("#").append(((TimeLineObject)localObject3).ContentObj.LoZ.dST);
                  }
                  if ((((TimeLineObject)localObject3).ContentObj.LoZ.tvC == 7) && (((TimeLineObject)localObject3).ContentObj.LoZ.LLD != null)) {}
                  for (paramView = MMApplicationContext.getContext().getString(2131766207, new Object[] { ((TimeLineObject)localObject3).ContentObj.LoZ.LLD.LAr, ((TimeLineObject)localObject3).ContentObj.LoZ.LLD.LAq });; paramView = ((TimeLineObject)localObject3).ContentObj.LoZ.dST)
                  {
                    localObject1 = ((TimeLineObject)localObject3).ContentObj.LoZ.desc;
                    break;
                  }
                }
                if (((TimeLineObject)localObject3).ContentObj.Lpe != null)
                {
                  if ((((TimeLineObject)localObject3).ContentObj.Lpe.tvC == 7) && (((TimeLineObject)localObject3).ContentObj.Lpe.LLD != null)) {}
                  for (paramView = MMApplicationContext.getContext().getString(2131766207, new Object[] { ((TimeLineObject)localObject3).ContentObj.Lpe.LLD.LAr, ((TimeLineObject)localObject3).ContentObj.Lpe.LLD.LAq });; paramView = ((TimeLineObject)localObject3).ContentObj.Lpe.dST)
                  {
                    localObject1 = ((TimeLineObject)localObject3).ContentObj.LoZ.desc;
                    break;
                  }
                }
                if (((TimeLineObject)localObject3).ContentObj.Lpc != null)
                {
                  if ((Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Lpc.nickName)) && (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Lpc.desc)))
                  {
                    localObject2 = ((TimeLineObject)localObject3).ContentObj.Lpc.desc;
                    localObject1 = paramView;
                    paramView = (View)localObject2;
                    break;
                  }
                  if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Lpc.desc))
                  {
                    localObject2 = ((TimeLineObject)localObject3).ContentObj.Lpc.nickName + ": " + ((TimeLineObject)localObject3).ContentObj.Lpc.desc;
                    localObject1 = paramView;
                    paramView = (View)localObject2;
                    break;
                  }
                  localObject2 = this.dKq.getString(2131766211, new Object[] { ((TimeLineObject)localObject3).ContentObj.Lpc.nickName });
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  break;
                }
                if (((TimeLineObject)localObject3).ContentObj.Lpd == null) {
                  break label3329;
                }
                paramView = this.dKq.getString(2131766210, new Object[] { ((TimeLineObject)localObject3).ContentObj.Lpd.nickname });
                if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Lpd.nickname)) {
                  paramView = this.dKq.getResources().getString(2131759540);
                }
              }
              if (!((TimeLineObject)localObject3).ContentObj.dME.mediaList.isEmpty())
              {
                localc.EIt.setVisibility(0);
                localObject2 = new cnb();
                ((cnb)localObject2).Url = ((bch)((TimeLineObject)localObject3).ContentObj.dME.mediaList.get(0)).thumbUrl;
                ((cnb)localObject2).Msz = ((bch)((TimeLineObject)localObject3).ContentObj.dME.mediaList.get(0)).thumbUrl;
                ((cnb)localObject2).oUv = 2;
                ((cnb)localObject2).MsA = 1;
                ((cnb)localObject2).MsB = new cnd();
                ((cnb)localObject2).Mcw = 1;
                ((cnb)localObject2).MsB.Mto = ((bch)((TimeLineObject)localObject3).ContentObj.dME.mediaList.get(0)).width;
                ((cnb)localObject2).MsB.Mtp = ((bch)((TimeLineObject)localObject3).ContentObj.dME.mediaList.get(0)).height;
                ((cnb)localObject2).Id = localSnsInfo.getSnsId();
                com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject2, localc.EIt, this.dKq.hashCode(), g.a.DHQ, localbp);
              }
              if (((TimeLineObject)localObject3).ContentObj.dME.vXJ != 4) {
                break label1378;
              }
              do
              {
                localc.uzC.setVisibility(0);
                localc.uzC.setImageDrawable(localc.uzC.getContext().getResources().getDrawable(2131691480));
                break;
                if (((TimeLineObject)localObject3).ContentObj.LoZ != null)
                {
                  localc.EIt.setVisibility(0);
                  localObject2 = new cnb();
                  ((cnb)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.LoZ.iconUrl;
                  ((cnb)localObject2).Msz = ((TimeLineObject)localObject3).ContentObj.LoZ.iconUrl;
                  ((cnb)localObject2).oUv = 2;
                  ((cnb)localObject2).MsA = 1;
                  ((cnb)localObject2).MsB = new cnd();
                  ((cnb)localObject2).Mcw = 1;
                  ((cnb)localObject2).MsB.Mto = 0.0F;
                  ((cnb)localObject2).MsB.Mtp = 0.0F;
                  ((cnb)localObject2).Id = localSnsInfo.getSnsId();
                  com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject2, localc.EIt, this.dKq.hashCode(), g.a.DHQ, localbp);
                  break;
                }
                if (((TimeLineObject)localObject3).ContentObj.Lpe != null)
                {
                  localc.EIt.setVisibility(0);
                  localObject2 = new cnb();
                  ((cnb)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.Lpe.iconUrl;
                  ((cnb)localObject2).Msz = ((TimeLineObject)localObject3).ContentObj.Lpe.iconUrl;
                  ((cnb)localObject2).oUv = 2;
                  ((cnb)localObject2).MsA = 1;
                  ((cnb)localObject2).MsB = new cnd();
                  ((cnb)localObject2).Mcw = 1;
                  ((cnb)localObject2).MsB.Mto = 0.0F;
                  ((cnb)localObject2).MsB.Mtp = 0.0F;
                  ((cnb)localObject2).Id = localSnsInfo.getSnsId();
                  com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject2, localc.EIt, this.dKq.hashCode(), g.a.DHQ, localbp);
                  break;
                }
                if (((TimeLineObject)localObject3).ContentObj.Lpb != null)
                {
                  localc.EIt.setVisibility(0);
                  localObject2 = new cnb();
                  localObject4 = (String)((TimeLineObject)localObject3).ContentObj.Lpb.LLt.get(0);
                  localObject3 = (String)((TimeLineObject)localObject3).ContentObj.Lpb.LLu.get(0);
                  ((cnb)localObject2).Url = ((String)localObject4 + (String)localObject3);
                  ((cnb)localObject2).Msz = ((cnb)localObject2).Url;
                  ((cnb)localObject2).oUv = 2;
                  ((cnb)localObject2).MsA = 1;
                  ((cnb)localObject2).MsB = new cnd();
                  ((cnb)localObject2).Mcw = 1;
                  ((cnb)localObject2).MsB.Mto = 0.0F;
                  ((cnb)localObject2).MsB.Mtp = 0.0F;
                  ((cnb)localObject2).Id = localSnsInfo.getSnsId();
                  com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject2, localc.EIt, this.dKq.hashCode(), g.a.DHQ, localbp);
                  break;
                }
                if (((TimeLineObject)localObject3).ContentObj.Lpc != null)
                {
                  if (((TimeLineObject)localObject3).ContentObj.Lpc.coverUrl.isEmpty()) {
                    break;
                  }
                  localc.EIt.setVisibility(0);
                  localObject2 = new cnb();
                  ((cnb)localObject2).Url = ((TimeLineObject)localObject3).ContentObj.Lpc.coverUrl;
                  ((cnb)localObject2).Msz = ((TimeLineObject)localObject3).ContentObj.Lpc.coverUrl;
                  ((cnb)localObject2).oUv = 2;
                  ((cnb)localObject2).MsA = 1;
                  ((cnb)localObject2).MsB = new cnd();
                  ((cnb)localObject2).Mcw = 1;
                  ((cnb)localObject2).MsB.Mto = ((TimeLineObject)localObject3).ContentObj.Lpc.width;
                  ((cnb)localObject2).MsB.Mtp = ((TimeLineObject)localObject3).ContentObj.Lpc.height;
                  ((cnb)localObject2).Id = localSnsInfo.getSnsId();
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImageForSns(((cnb)localObject2).Url, localc.EIt);
                  break;
                }
                if (((TimeLineObject)localObject3).ContentObj.Lpd == null) {
                  break;
                }
              } while (((TimeLineObject)localObject3).ContentObj.Lpd.mediaList.isEmpty());
              localc.EIt.setVisibility(0);
              localObject4 = new cnb();
              if (!Util.isNullOrNil(((cok)((TimeLineObject)localObject3).ContentObj.Lpd.mediaList.get(0)).coverUrl)) {}
              for (localObject2 = ((cok)((TimeLineObject)localObject3).ContentObj.Lpd.mediaList.get(0)).coverUrl;; localObject2 = ((cok)((TimeLineObject)localObject3).ContentObj.Lpd.mediaList.get(0)).thumbUrl)
              {
                ((cnb)localObject4).Url = ((String)localObject2);
                ((cnb)localObject4).Msz = ((String)localObject2);
                ((cnb)localObject4).oUv = 2;
                ((cnb)localObject4).MsA = 1;
                ((cnb)localObject4).MsB = new cnd();
                ((cnb)localObject4).Mcw = 1;
                ((cnb)localObject4).MsB.Mto = ((cok)((TimeLineObject)localObject3).ContentObj.Lpd.mediaList.get(0)).width;
                ((cnb)localObject4).MsB.Mtp = ((cok)((TimeLineObject)localObject3).ContentObj.Lpd.mediaList.get(0)).height;
                ((cnb)localObject4).Id = localSnsInfo.getSnsId();
                com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject4, localc.EIt, this.dKq.hashCode(), g.a.DHQ, localbp);
                break;
              }
              label3288:
              localc.EIr.setVisibility(8);
              break label1405;
              label3301:
              localc.titleTv.setMaxLines(1);
              break label1434;
              label3313:
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
  
  private void v(final TextView paramTextView)
  {
    AppMethodBeat.i(99041);
    if (this.EHZ <= 0) {
      paramTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99020);
          new Rect();
          paramTextView.measure(0, 0);
          bh.a(bh.this, paramTextView.getMeasuredHeight());
          Log.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", new Object[] { Integer.valueOf(bh.e(bh.this)) });
          AppMethodBeat.o(99020);
        }
      });
    }
    AppMethodBeat.o(99041);
  }
  
  private void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(99046);
    Log.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.sNG);
    if (this.EHR != null)
    {
      if (this.isSearchMode)
      {
        this.EHS.aq(this.EHQ, paramBoolean);
        AppMethodBeat.o(99046);
        return;
      }
      this.EHR.k(this.sNG, this.EHQ, paramBoolean);
    }
    AppMethodBeat.o(99046);
  }
  
  public final void JR(long paramLong)
  {
    if (0L != this.EHW) {
      return;
    }
    this.EHW = paramLong;
    this.EHX = 0L;
  }
  
  public final void a(List<SnsInfo> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99045);
    Log.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (this.EHT != null) {
        this.EHT.fiG();
      }
      AppMethodBeat.o(99045);
      return;
    }
    Log.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    this.list.clear();
    this.Enw.clear();
    this.Enx.clear();
    this.EHO.clear();
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
      this.Enw.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      this.Enx.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      this.EHO.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (this.dJM)
    {
      if (this.list.size() <= 1) {}
      for (i = 2147483647;; i = ((SnsInfo)this.list.get(1)).getHead())
      {
        this.EHU = 0;
        j = 0;
        while (j < this.list.size())
        {
          if ((!this.dJM) || (j != 0))
          {
            if (i != ((SnsInfo)this.list.get(j)).getHead()) {
              break;
            }
            this.EHU = Math.max(this.EHU, ((SnsInfo)this.list.get(j)).getCreateTime());
          }
          j += 1;
        }
      }
    }
    if (this.list.isEmpty()) {}
    for (i = 2147483647;; i = ((SnsInfo)this.list.get(0)).getHead()) {
      break;
    }
    if ((this.list.isEmpty()) || ((this.dJM) && (this.list.size() == 1))) {
      this.EHU = 2147483647;
    }
    if (this.list.isEmpty()) {}
    for (i = 0;; i = ((SnsInfo)this.list.get(this.list.size() - 1)).getHead())
    {
      this.EHV = 2147483647;
      j = this.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((SnsInfo)this.list.get(j)).getHead()))
      {
        this.EHV = Math.min(this.EHV, ((SnsInfo)this.list.get(j)).getCreateTime());
        j -= 1;
      }
    }
    if (this.list.isEmpty()) {
      this.EHV = 0;
    }
    this.Enz = paramInt1;
    this.Eny = paramInt2;
    Log.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + this.EHU + " edTIme " + this.EHV);
    notifyDataSetChanged();
    AppMethodBeat.o(99045);
  }
  
  public final void ffM()
  {
    AppMethodBeat.i(99048);
    vw(true);
    notifyDataSetChanged();
    AppMethodBeat.o(99048);
  }
  
  public final void fiD()
  {
    this.EHY = true;
    if (this.isSearchMode) {
      this.EHS.EIV = true;
    }
  }
  
  public final void fiE()
  {
    AppMethodBeat.i(99049);
    Log.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((SnsInfo)this.list.get(this.list.size() - 1)).field_snsId)
    {
      JS(l);
      AppMethodBeat.o(99049);
      return;
    }
  }
  
  public final int getCount()
  {
    return this.Eny;
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
    if ((this.dJM) && (paramInt == 0) && ((!this.isSearchMode) || ((this.isSearchMode) && (this.EHY))))
    {
      Log.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(99043);
      return 0;
    }
    if (this.Enw.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        Log.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(99043);
        return 0;
      }
      Object localObject = (SnsInfo)getItem(i);
      if (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 1)
      {
        Log.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(99043);
        return 0;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 15)
      {
        Log.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(99043);
        return 2;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 21)
      {
        AppMethodBeat.o(99043);
        return 3;
      }
      if ((((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 28) || (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 29) || (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 37) || (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 38) || (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 34) || (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 36))
      {
        AppMethodBeat.o(99043);
        return 4;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 33)
      {
        AppMethodBeat.o(99043);
        return 5;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 4) {
        if (((SnsInfo)localObject).getTimeLine().AppInfo == null) {
          break label564;
        }
      }
      label564:
      for (localObject = ((SnsInfo)localObject).getTimeLine().AppInfo.Id;; localObject = "")
      {
        com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.qCo;
        if (com.tencent.mm.plugin.comm.a.akQ((String)localObject))
        {
          AppMethodBeat.o(99043);
          return 6;
        }
        localObject = com.tencent.mm.plugin.comm.a.qCo;
        if (!com.tencent.mm.plugin.comm.a.cAI())
        {
          AppMethodBeat.o(99043);
          return 1;
        }
        AppMethodBeat.o(99043);
        return 1;
        if (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 42)
        {
          AppMethodBeat.o(99043);
          return 6;
        }
        if (((SnsInfo)localObject).getTimeLine().ContentObj.LoU == 39) {}
        switch (((SnsInfo)localObject).getTimeLine().ContentObj.izD)
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
        paramView = aa.jQ(this.dKq).inflate(2131496473, null);
        paramViewGroup.EIi = ((TextView)paramView.findViewById(2131308107));
        paramViewGroup.EIh = ((TextView)paramView.findViewById(2131308158));
        paramViewGroup.EIj = ((TextView)paramView.findViewById(2131308272));
        paramViewGroup.EIv = ((MaskImageView)paramView.findViewById(2131302614));
        paramViewGroup.EIw = ((QFadeImageView)paramView.findViewById(2131308885));
        paramViewGroup.EIx = ((MaskImageView)paramView.findViewById(2131302615));
        paramViewGroup.EIy = ((MaskImageView)paramView.findViewById(2131302616));
        paramViewGroup.EIz = ((MMNeat7extView)paramView.findViewById(2131299495));
        paramViewGroup.EIA = ((TextView)paramView.findViewById(2131310523));
        paramViewGroup.EIB = ((TextView)paramView.findViewById(2131310524));
        paramViewGroup.EIC = ((TextView)paramView.findViewById(2131310525));
        paramViewGroup.EID = ((TextView)paramView.findViewById(2131302625));
        paramViewGroup.EIE = paramView.findViewById(2131299504);
        paramViewGroup.EIm = ((TextView)paramView.findViewById(2131296543));
        paramViewGroup.EIk = ((LinearLayout)paramView.findViewById(2131303199));
        paramViewGroup.EIl = ((ImageView)paramView.findViewById(2131303762));
        paramViewGroup.EnO = ((LinearLayout)paramView.findViewById(2131303241));
        paramViewGroup.EnP = paramView.findViewById(2131303198);
        paramViewGroup.EIw.setOnClickListener(this.EHP.EnF);
        paramViewGroup.EIv.setOnClickListener(this.EHP.EnF);
        paramViewGroup.EIx.setOnClickListener(this.EHP.EnG);
        paramViewGroup.EIy.setOnClickListener(this.EHP.EnH);
        paramViewGroup.EIv.setOnLongClickListener(this.EHP.EIP);
        paramViewGroup.EIx.setOnLongClickListener(this.EHP.EIP);
        paramViewGroup.EIy.setOnLongClickListener(this.EHP.EIP);
        paramViewGroup.EIF = ((TextView)paramView.findViewById(2131310324));
        paramViewGroup.EIG = ((TextView)paramView.findViewById(2131310325));
        paramViewGroup.EIH = ((TextView)paramView.findViewById(2131310326));
        paramViewGroup.EII = ((TextView)paramView.findViewById(2131309439));
        paramViewGroup.EIJ = ((TextView)paramView.findViewById(2131309440));
        paramViewGroup.EIK = ((TextView)paramView.findViewById(2131309441));
        paramViewGroup.EIL = ((MaskLinearLayout)paramView.findViewById(2131308154));
        paramViewGroup.EIL.b(paramViewGroup.EIv);
        paramViewGroup.EIn = ((LinearLayout)paramView.findViewById(2131301795));
        paramViewGroup.EIo = ((TextView)paramView.findViewById(2131308173));
        paramViewGroup.EIo.setOnClickListener(new bh.7(this));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.model.aj.faL().ff(paramViewGroup.EIv);
        com.tencent.mm.plugin.sns.model.aj.faL().ff(paramViewGroup.EIx);
        com.tencent.mm.plugin.sns.model.aj.faL().ff(paramViewGroup.EIy);
        i = -1;
        if (this.Enw.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.EIj.setTag(Integer.valueOf(paramInt));
        paramViewGroup.EIL.settouchEnable(false);
        paramViewGroup.EIL.setBackgroundResource(0);
        paramViewGroup.EIL.setDescendantFocusability(131072);
        paramViewGroup.EIL.setClickable(false);
        paramViewGroup.EIv.settouchEnable(true);
        paramViewGroup.EIv.setClickable(true);
        paramViewGroup.EIv.setLongClickable(false);
        paramViewGroup.EIx.setLongClickable(false);
        paramViewGroup.EIy.setLongClickable(false);
        paramViewGroup.EIL.setOnClickListener(null);
        paramViewGroup.EIL.setOnLongClickListener(null);
        paramViewGroup.EIL.setLongClickable(false);
        if ((i < this.Enz) && (i != -1)) {
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
      an.aQ(((SnsInfo)localObject1).getLocalPrivate(), this.dJM);
    }
    label3972:
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.setVisibility(0);
      if (this.Enx.get(Integer.valueOf(paramInt)) != null) {}
      label1287:
      label1300:
      label5655:
      label5661:
      for (int k = ((Integer)this.Enx.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        Object localObject2 = (SnsInfo)getItem(i);
        localObject1 = ((SnsInfo)localObject2).getTimeLine();
        long l;
        if (((this.dJM) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject2).getHead() != j))
        {
          if (aI(paramInt, ((SnsInfo)localObject2).field_snsId))
          {
            l = ((SnsInfo)localObject2).getCreateTime();
            a(paramViewGroup.EIh, paramViewGroup.EIi, l);
          }
          if (((TimeLineObject)localObject1).Location != null)
          {
            if (!Util.isNullOrNil(((TimeLineObject)localObject1).Location.kHV)) {
              break label1287;
            }
            localObject1 = ((TimeLineObject)localObject1).Location.kea;
            if ((localObject1 != null) && (!((String)localObject1).equals("")))
            {
              paramViewGroup.EIm.setText((CharSequence)localObject1);
              paramViewGroup.EIm.setVisibility(0);
            }
          }
          paramViewGroup.EnP.setVisibility(0);
        }
        else
        {
          if ((this.EHX == 0L) || (((SnsInfo)localObject2).field_snsId != this.EHX)) {
            break label1300;
          }
          paramViewGroup.EIn.setVisibility(0);
          label1094:
          paramViewGroup.EIk.setVisibility(0);
          if ((!this.dJM) || (paramInt != 0) || ((this.isSearchMode) && ((!this.isSearchMode) || (!this.EHY)))) {
            break label1319;
          }
          paramViewGroup.EIw.setVisibility(0);
          paramViewGroup.EIw.setContentDescription(this.dKq.getString(2131766258));
          paramViewGroup.EIv.setVisibility(8);
          localObject2 = paramViewGroup.EIz;
          if (this.Eny != 1) {
            break label1312;
          }
        }
        label1312:
        for (localObject1 = this.dKq.getString(2131766303);; localObject1 = "")
        {
          ((MMNeat7extView)localObject2).aw((CharSequence)localObject1);
          paramViewGroup.EIz.setVisibility(0);
          paramViewGroup.EIE.setVisibility(0);
          paramViewGroup.EID.setVisibility(8);
          com.tencent.mm.plugin.sns.model.aj.faL().d(paramViewGroup.EIw, 2131101160, 2131235014, this.dKq.hashCode());
          localObject1 = new bh.g.a();
          ((bh.g.a)localObject1).ecf = -1;
          ((bh.g.a)localObject1).position = -1;
          paramViewGroup.EIw.setTag(localObject1);
          AppMethodBeat.o(99038);
          return paramView;
          localObject1 = ((TimeLineObject)localObject1).Location.kHV;
          break;
          paramViewGroup.EIn.setVisibility(8);
          break label1094;
        }
        label1319:
        a(paramViewGroup.EIj, j, ((SnsInfo)localObject2).getHead());
        if (k > 0)
        {
          a(i, paramViewGroup.EIv, paramViewGroup.EIA, paramViewGroup.EID, paramViewGroup.EIF, paramViewGroup.EII, 1, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo)getItem(i));
        }
        if (k >= 2)
        {
          a(i + 1, paramViewGroup.EIx, paramViewGroup.EIB, paramViewGroup.EID, paramViewGroup.EIG, paramViewGroup.EIJ, 2, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo)getItem(i + 1));
        }
        if (k >= 3)
        {
          a(i + 2, paramViewGroup.EIy, paramViewGroup.EIC, paramViewGroup.EID, paramViewGroup.EIH, paramViewGroup.EIK, 3, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo)getItem(i + 2));
        }
        if (k == 1)
        {
          localObject1 = (SnsInfo)getItem(i);
          if ((!Util.isNullOrNil(((SnsInfo)localObject1).getTimeLine().ContentDesc)) && (((SnsInfo)localObject1).getTypeFlag() == 1))
          {
            paramViewGroup.EIL.setDescendantFocusability(393216);
            paramViewGroup.EIL.setClickable(true);
            paramViewGroup.EIv.setClickable(false);
            paramViewGroup.EIv.settouchEnable(false);
            paramViewGroup.EIL.setOnClickListener(this.EHP.EnF);
            paramViewGroup.EIL.settouchEnable(true);
            i = ((SnsInfo)localObject2).localid;
            localObject2 = new bh.g.a();
            ((bh.g.a)localObject2).ecf = i;
            if (this.EHO.get(Integer.valueOf(paramInt)) == null) {
              break label1702;
            }
          }
        }
        label1702:
        for (((bh.g.a)localObject2).position = ((Integer)this.EHO.get(Integer.valueOf(paramInt))).intValue();; ((bh.g.a)localObject2).position = 0)
        {
          if ((((SnsInfo)localObject1).isInValid()) && (((SnsInfo)localObject1).isDieItem())) {
            paramViewGroup.EIL.setOnLongClickListener(this.EHP.EIP);
          }
          paramViewGroup.EIL.setTag(localObject2);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(99038);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof f)))
          {
            paramViewGroup = new f();
            paramView = aa.jQ(this.dKq).inflate(2131496489, null);
            paramViewGroup.EIi = ((TextView)paramView.findViewById(2131308107));
            paramViewGroup.EIh = ((TextView)paramView.findViewById(2131308158));
            paramViewGroup.EIj = ((TextView)paramView.findViewById(2131308272));
            paramViewGroup.EIv = ((MaskImageView)paramView.findViewById(2131302614));
            paramViewGroup.EIm = ((TextView)paramView.findViewById(2131296543));
            paramViewGroup.EIk = ((LinearLayout)paramView.findViewById(2131303199));
            paramViewGroup.EIl = ((ImageView)paramView.findViewById(2131303762));
            paramViewGroup.EnO = ((LinearLayout)paramView.findViewById(2131303241));
            paramViewGroup.EnP = paramView.findViewById(2131303198);
            paramViewGroup.EIv.setOnClickListener(this.EHP.EIO);
            paramViewGroup.EIF = ((TextView)paramView.findViewById(2131310324));
            paramViewGroup.EIL = ((MaskLinearLayout)paramView.findViewById(2131308154));
            paramViewGroup.EIL.b(paramViewGroup.EIv);
            paramViewGroup.EIz = ((MMNeat7extView)paramView.findViewById(2131299495));
            paramViewGroup.EIE = paramView.findViewById(2131299504);
            paramViewGroup.EIn = ((LinearLayout)paramView.findViewById(2131301795));
            paramViewGroup.EIo = ((TextView)paramView.findViewById(2131308173));
            paramViewGroup.EIo.setOnClickListener(new bh.6(this));
            paramView.setTag(paramViewGroup);
            com.tencent.mm.plugin.sns.model.aj.faL().ff(paramViewGroup.EIv);
            if (this.Enw.get(Integer.valueOf(paramInt)) == null) {
              break label5673;
            }
          }
        }
        label2845:
        label3997:
        label4004:
        label5673:
        for (i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.EIj.setTag(Integer.valueOf(paramInt));
          paramViewGroup.EIL.settouchEnable(false);
          paramViewGroup.EIL.setBackgroundResource(0);
          paramViewGroup.EIL.setDescendantFocusability(131072);
          paramViewGroup.EIL.setClickable(false);
          paramViewGroup.EIv.settouchEnable(true);
          paramViewGroup.EIv.setClickable(true);
          paramViewGroup.EIL.setOnClickListener(null);
          if ((i >= this.Enz) || (i == -1))
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
            an.aQ(((SnsInfo)localObject1).getLocalPrivate(), this.dJM);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.Enx.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.Enx.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject2 = (SnsInfo)getItem(i);
            Object localObject3 = ((SnsInfo)localObject2).getTimeLine();
            if (((this.dJM) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject2).getHead() != j))
            {
              if (aI(paramInt, ((SnsInfo)localObject2).field_snsId))
              {
                l = ((SnsInfo)localObject2).getCreateTime();
                a(paramViewGroup.EIh, paramViewGroup.EIi, l);
              }
              if (((TimeLineObject)localObject3).Location != null)
              {
                if (!Util.isNullOrNil(((TimeLineObject)localObject3).Location.kHV)) {
                  break label2832;
                }
                localObject1 = ((TimeLineObject)localObject3).Location.kea;
                if ((localObject1 != null) && (!((String)localObject1).equals("")))
                {
                  paramViewGroup.EIm.setText((CharSequence)localObject1);
                  paramViewGroup.EIm.setVisibility(0);
                }
              }
              paramViewGroup.EnP.setVisibility(0);
            }
            else
            {
              a(paramViewGroup.EIj, j, ((SnsInfo)localObject2).getHead());
              if ((this.EHX == 0L) || (((SnsInfo)localObject2).field_snsId != this.EHX)) {
                break label2845;
              }
              paramViewGroup.EIn.setVisibility(0);
              label2476:
              paramViewGroup.EIk.setVisibility(0);
              localObject1 = new bp(this.EHN.tag);
              ((bp)localObject1).hXs = ((SnsInfo)localObject2).field_createTime;
              paramViewGroup.EIv.setVisibility(0);
              com.tencent.mm.plugin.sns.model.aj.faL().a(((TimeLineObject)localObject3).ContentObj.LoV, paramViewGroup.EIv, this.dKq.hashCode(), g.a.DHQ, (bp)localObject1);
              if (an.aQ(((SnsInfo)localObject2).getLocalPrivate(), this.dJM))
              {
                paramViewGroup.EIF.setVisibility(0);
                paramViewGroup.EIF.setBackgroundResource(2131234404);
                localObject1 = this.EBg.Kn(((SnsInfo)localObject2).getUserName());
                if (localObject1 != null) {
                  ((com.tencent.mm.contact.c)localObject1).arJ();
                }
              }
              localObject1 = (SnsInfo)getItem(i);
              localObject3 = ((SnsInfo)localObject1).getTimeLine().ContentDesc;
              if ((localObject3 != null) && (!((String)localObject3).equals("")))
              {
                paramViewGroup.EIE.setVisibility(0);
                paramViewGroup.EIz.setVisibility(0);
                paramViewGroup.EIz.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, (CharSequence)localObject3, paramViewGroup.EIz.getTextSize()));
              }
              paramViewGroup.EIL.setDescendantFocusability(393216);
              paramViewGroup.EIL.setClickable(true);
              paramViewGroup.EIv.setClickable(false);
              paramViewGroup.EIv.settouchEnable(false);
              paramViewGroup.EIL.setOnClickListener(this.EHP.EIO);
              paramViewGroup.EIL.settouchEnable(true);
              i = ((SnsInfo)localObject2).localid;
              localObject2 = new bh.g.a();
              ((bh.g.a)localObject2).ecf = i;
              if (this.EHO.get(Integer.valueOf(paramInt)) == null) {
                break label2857;
              }
            }
            label2857:
            for (((bh.g.a)localObject2).position = ((Integer)this.EHO.get(Integer.valueOf(paramInt))).intValue();; ((bh.g.a)localObject2).position = 0)
            {
              paramViewGroup.EIL.setTag(localObject2);
              paramView.setDrawingCacheEnabled(false);
              com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo)localObject1);
              AppMethodBeat.o(99038);
              return paramView;
              localObject1 = ((TimeLineObject)localObject3).Location.kHV;
              break;
              paramViewGroup.EIn.setVisibility(8);
              break label2476;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
              {
                paramViewGroup = new e();
                paramView = aa.jQ(this.dKq).inflate(2131496473, null);
                paramViewGroup.EIi = ((TextView)paramView.findViewById(2131308107));
                paramViewGroup.EIh = ((TextView)paramView.findViewById(2131308158));
                paramViewGroup.EIj = ((TextView)paramView.findViewById(2131308272));
                paramViewGroup.EIv = ((MaskImageView)paramView.findViewById(2131302614));
                paramViewGroup.EIw = ((QFadeImageView)paramView.findViewById(2131308885));
                paramViewGroup.EIx = ((MaskImageView)paramView.findViewById(2131302615));
                paramViewGroup.EIy = ((MaskImageView)paramView.findViewById(2131302616));
                paramViewGroup.EIz = ((MMNeat7extView)paramView.findViewById(2131299495));
                paramViewGroup.EIA = ((TextView)paramView.findViewById(2131310523));
                paramViewGroup.EIB = ((TextView)paramView.findViewById(2131310524));
                paramViewGroup.EIC = ((TextView)paramView.findViewById(2131310525));
                paramViewGroup.EID = ((TextView)paramView.findViewById(2131302625));
                paramViewGroup.EIE = paramView.findViewById(2131299504);
                paramViewGroup.EIm = ((TextView)paramView.findViewById(2131296543));
                paramViewGroup.EIk = ((LinearLayout)paramView.findViewById(2131303199));
                paramViewGroup.EIl = ((ImageView)paramView.findViewById(2131303762));
                paramViewGroup.EnO = ((LinearLayout)paramView.findViewById(2131303241));
                paramViewGroup.EnP = paramView.findViewById(2131303198);
                paramViewGroup.EIw.setOnClickListener(this.EHP.EIN);
                paramViewGroup.EIv.setOnClickListener(this.EHP.EIN);
                paramViewGroup.EIF = ((TextView)paramView.findViewById(2131310324));
                paramViewGroup.EIG = ((TextView)paramView.findViewById(2131310325));
                paramViewGroup.EIH = ((TextView)paramView.findViewById(2131310326));
                paramViewGroup.EII = ((TextView)paramView.findViewById(2131309439));
                paramViewGroup.EIJ = ((TextView)paramView.findViewById(2131309440));
                paramViewGroup.EIK = ((TextView)paramView.findViewById(2131309441));
                paramViewGroup.EIL = ((MaskLinearLayout)paramView.findViewById(2131308154));
                paramViewGroup.EIL.b(paramViewGroup.EIv);
                paramViewGroup.EIn = ((LinearLayout)paramView.findViewById(2131301795));
                paramViewGroup.EIo = ((TextView)paramView.findViewById(2131308173));
                paramViewGroup.EIo.setOnClickListener(new bh.2(this));
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                com.tencent.mm.plugin.sns.model.aj.faL().ff(paramViewGroup.EIv);
                com.tencent.mm.plugin.sns.model.aj.faL().ff(paramViewGroup.EIx);
                com.tencent.mm.plugin.sns.model.aj.faL().ff(paramViewGroup.EIy);
                i = -1;
                if (this.Enw.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.EIj.setTag(Integer.valueOf(paramInt));
                paramViewGroup.EIL.settouchEnable(false);
                paramViewGroup.EIL.setBackgroundResource(0);
                paramViewGroup.EIL.setDescendantFocusability(131072);
                paramViewGroup.EIL.setClickable(false);
                paramViewGroup.EIv.settouchEnable(true);
                paramViewGroup.EIv.setClickable(true);
                paramViewGroup.EIL.setOnClickListener(null);
                if ((i < this.Enz) && (i != -1)) {
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
              an.aQ(((SnsInfo)localObject1).getLocalPrivate(), this.dJM);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject2 = (SnsInfo)getItem(i);
              localObject1 = ((SnsInfo)localObject2).getTimeLine();
              if (((this.dJM) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject2).getHead() != j))
              {
                if (aI(paramInt, ((SnsInfo)localObject2).field_snsId))
                {
                  l = ((SnsInfo)localObject2).getCreateTime();
                  a(paramViewGroup.EIh, paramViewGroup.EIi, l);
                }
                if (((TimeLineObject)localObject1).Location != null)
                {
                  if (!Util.isNullOrNil(((TimeLineObject)localObject1).Location.kHV)) {
                    break label3972;
                  }
                  localObject1 = ((TimeLineObject)localObject1).Location.kea;
                  if ((localObject1 != null) && (!((String)localObject1).equals("")))
                  {
                    paramViewGroup.EIm.setText((CharSequence)localObject1);
                    paramViewGroup.EIm.setVisibility(0);
                  }
                }
                paramViewGroup.EnP.setVisibility(0);
              }
              else
              {
                a(paramViewGroup.EIj, j, ((SnsInfo)localObject2).getHead());
                if ((this.EHX == 0L) || (((SnsInfo)localObject2).field_snsId != this.EHX)) {
                  break label3985;
                }
                paramViewGroup.EIn.setVisibility(0);
                label3800:
                paramViewGroup.EIk.setVisibility(0);
                if ((!this.dJM) || (paramInt != 0)) {
                  break label4004;
                }
                paramViewGroup.EIw.setVisibility(0);
                paramViewGroup.EIw.setContentDescription(this.dKq.getString(2131766258));
                paramViewGroup.EIv.setVisibility(8);
                localObject2 = paramViewGroup.EIz;
                if (this.Eny != 1) {
                  break label3997;
                }
              }
              for (localObject1 = this.dKq.getString(2131766303);; localObject1 = "")
              {
                ((MMNeat7extView)localObject2).aw((CharSequence)localObject1);
                paramViewGroup.EIz.setVisibility(0);
                paramViewGroup.EIE.setVisibility(0);
                paramViewGroup.EID.setVisibility(8);
                com.tencent.mm.plugin.sns.model.aj.faL().d(paramViewGroup.EIw, 2131101160, 2131235014, this.dKq.hashCode());
                localObject1 = new bh.g.a();
                ((bh.g.a)localObject1).ecf = -1;
                ((bh.g.a)localObject1).position = -1;
                paramViewGroup.EIw.setTag(localObject1);
                AppMethodBeat.o(99038);
                return paramView;
                localObject1 = ((TimeLineObject)localObject1).Location.kHV;
                break;
                paramViewGroup.EIn.setVisibility(8);
                break label3800;
              }
              a(i, paramViewGroup.EIv, paramViewGroup.EIA, paramViewGroup.EID, paramViewGroup.EIF, paramViewGroup.EII, 1, paramViewGroup, paramInt);
              localObject1 = (SnsInfo)getItem(i);
              if ((!Util.isNullOrNil(((SnsInfo)localObject1).getTimeLine().ContentDesc)) && (((SnsInfo)localObject1).getTypeFlag() == 1))
              {
                paramViewGroup.EIL.setDescendantFocusability(393216);
                paramViewGroup.EIL.setClickable(true);
                paramViewGroup.EIv.setClickable(false);
                paramViewGroup.EIv.settouchEnable(false);
                paramViewGroup.EIL.setOnClickListener(this.EHP.EIN);
                paramViewGroup.EIL.settouchEnable(true);
                i = ((SnsInfo)localObject2).localid;
                localObject2 = new bh.g.a();
                ((bh.g.a)localObject2).ecf = i;
                if (this.EHO.get(Integer.valueOf(paramInt)) == null) {
                  break label4216;
                }
              }
              label4216:
              for (((bh.g.a)localObject2).position = ((Integer)this.EHO.get(Integer.valueOf(paramInt))).intValue();; ((bh.g.a)localObject2).position = 0)
              {
                paramViewGroup.EIL.setTag(localObject2);
                com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo)localObject1);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 4)
              {
                paramView = n(paramInt, paramView);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 5) {
                if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
                {
                  paramViewGroup = new c();
                  localObject1 = aa.jQ(this.dKq).inflate(2131496471, null);
                  paramViewGroup.EIg = ((View)localObject1).findViewById(2131299208);
                  paramViewGroup.EIi = ((TextView)((View)localObject1).findViewById(2131308107));
                  paramViewGroup.EIh = ((TextView)((View)localObject1).findViewById(2131308158));
                  paramViewGroup.EIj = ((TextView)((View)localObject1).findViewById(2131308272));
                  paramViewGroup.EIm = ((TextView)((View)localObject1).findViewById(2131296543));
                  paramViewGroup.EnP = ((View)localObject1).findViewById(2131303198);
                  paramViewGroup.EIm = ((TextView)((View)localObject1).findViewById(2131296543));
                  paramViewGroup.EIk = ((LinearLayout)((View)localObject1).findViewById(2131303199));
                  paramViewGroup.EIl = ((ImageView)((View)localObject1).findViewById(2131303762));
                  paramViewGroup.EnO = ((LinearLayout)((View)localObject1).findViewById(2131303241));
                  paramViewGroup.pIP = ((MMNeat7extView)((View)localObject1).findViewById(2131299510));
                  paramViewGroup.EIt = ((TagImageView)((View)localObject1).findViewById(2131302578));
                  paramViewGroup.uzC = ((ImageView)((View)localObject1).findViewById(2131308376));
                  paramViewGroup.titleTv = ((TextView)((View)localObject1).findViewById(2131309253));
                  paramViewGroup.EIr = ((TextView)((View)localObject1).findViewById(2131307116));
                  paramViewGroup.EIg.setOnClickListener(this.EHP.EIM);
                  paramViewGroup.EIs = ((View)localObject1).findViewById(2131304553);
                  paramViewGroup.EIu = ((TextView)((View)localObject1).findViewById(2131299206));
                  paramViewGroup.EIn = ((LinearLayout)((View)localObject1).findViewById(2131301795));
                  paramViewGroup.EIo = ((TextView)((View)localObject1).findViewById(2131308173));
                  paramViewGroup.EIo.setOnClickListener(new bh.11(this));
                  ((View)localObject1).setTag(paramViewGroup);
                  com.tencent.mm.plugin.sns.data.r.b(paramViewGroup.EIt, this.dKq);
                  paramViewGroup.EIj.setTag(Integer.valueOf(paramInt));
                  if (this.Enw.get(Integer.valueOf(paramInt)) == null) {
                    break label5655;
                  }
                }
              }
              for (i = ((Integer)this.Enw.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                paramViewGroup.init();
                if ((i >= this.Enz) || (i == -1))
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
                  an.aQ(paramView.getLocalPrivate(), this.dJM);
                }
                for (;;)
                {
                  ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  ((View)localObject1).setVisibility(0);
                  localObject3 = (SnsInfo)getItem(i);
                  localObject2 = ((SnsInfo)localObject3).getTimeLine();
                  if (((this.dJM) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject3).getHead() != j))
                  {
                    if (aI(paramInt, ((SnsInfo)localObject3).field_snsId))
                    {
                      l = ((SnsInfo)localObject3).getCreateTime();
                      a(paramViewGroup.EIh, paramViewGroup.EIi, l);
                    }
                    if (((TimeLineObject)localObject2).Location != null)
                    {
                      if (!Util.isNullOrNil(((TimeLineObject)localObject2).Location.kHV)) {
                        break label5178;
                      }
                      paramView = ((TimeLineObject)localObject2).Location.kea;
                      if ((paramView != null) && (!paramView.equals("")))
                      {
                        paramViewGroup.EIm.setText(paramView);
                        paramViewGroup.EIm.setVisibility(0);
                      }
                    }
                    paramViewGroup.EnP.setVisibility(0);
                  }
                  else
                  {
                    a(paramViewGroup.EIj, j, ((SnsInfo)localObject3).getHead());
                    if ((this.EHX == 0L) || (((SnsInfo)localObject3).field_snsId != this.EHX)) {
                      break label5190;
                    }
                    paramViewGroup.EIn.setVisibility(0);
                    label4988:
                    paramView = new bh.g.a();
                    paramView.ecf = ((SnsInfo)localObject3).localid;
                    if (this.EHO.get(Integer.valueOf(paramInt)) == null) {
                      break label5202;
                    }
                    paramView.position = ((Integer)this.EHO.get(Integer.valueOf(paramInt))).intValue();
                    label5044:
                    paramViewGroup.EIg.setTag(paramView);
                    if (Util.isNullOrNil(((TimeLineObject)localObject2).ContentDesc)) {
                      break label5210;
                    }
                    paramViewGroup.pIP.setVisibility(0);
                    paramViewGroup.pIP.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, ((TimeLineObject)localObject2).ContentDesc, paramViewGroup.pIP.getTextSize()));
                  }
                  bp localbp;
                  for (;;)
                  {
                    paramViewGroup.EIk.setVisibility(0);
                    paramViewGroup.pIP.getWrappedTextView().setSingleLine(true);
                    paramViewGroup.EIs.setVisibility(0);
                    localbp = new bp(this.EHN.tag);
                    localbp.hXs = ((SnsInfo)localObject3).field_createTime;
                    if (((TimeLineObject)localObject2).ContentObj.Lpa != null) {
                      break label5222;
                    }
                    Log.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                    AppMethodBeat.o(99038);
                    return localObject1;
                    label5178:
                    paramView = ((TimeLineObject)localObject2).Location.kHV;
                    break;
                    label5190:
                    paramViewGroup.EIn.setVisibility(8);
                    break label4988;
                    label5202:
                    paramView.position = 0;
                    break label5044;
                    label5210:
                    paramViewGroup.pIP.setVisibility(8);
                  }
                  label5222:
                  paramViewGroup.titleTv.setTextColor(this.dKq.getResources().getColor(2131100904));
                  paramView = "";
                  if (((TimeLineObject)localObject2).ContentObj.Lpa != null)
                  {
                    paramViewGroup.EIt.setVisibility(0);
                    paramView = ((TimeLineObject)localObject2).ContentObj.Lpa.title;
                    cnb localcnb = new cnb();
                    localcnb.Url = ((TimeLineObject)localObject2).ContentObj.Lpa.iAo;
                    localcnb.Msz = ((TimeLineObject)localObject2).ContentObj.Lpa.iAo;
                    localcnb.oUv = 2;
                    localcnb.MsA = 1;
                    localcnb.MsB = new cnd();
                    localcnb.Mcw = 1;
                    localcnb.MsB.Mto = ((TimeLineObject)localObject2).ContentObj.Lpa.width;
                    localcnb.MsB.Mtp = ((TimeLineObject)localObject2).ContentObj.Lpa.height;
                    localcnb.Id = ((SnsInfo)localObject3).getSnsId();
                    com.tencent.mm.plugin.sns.model.aj.faL().a(localcnb, paramViewGroup.EIt, this.dKq.hashCode(), g.a.DHQ, localbp);
                  }
                  localObject2 = paramView;
                  if (paramView.length() > 40) {
                    localObject2 = paramView.substring(0, 40) + "...";
                  }
                  if (paramViewGroup.EIt != null) {
                    paramViewGroup.EIt.setOnClickListener(null);
                  }
                  paramViewGroup.uzC.setVisibility(0);
                  paramViewGroup.uzC.setImageDrawable(com.tencent.mm.ui.ar.m(paramViewGroup.uzC.getContext(), 2131690929, -1));
                  paramViewGroup.EIr.setVisibility(8);
                  if (!Util.isNullOrNil((String)localObject2)) {
                    if (paramViewGroup.EIr.getVisibility() == 8)
                    {
                      paramViewGroup.titleTv.setMaxLines(2);
                      paramViewGroup.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.dKq, (CharSequence)localObject2));
                      paramViewGroup.titleTv.setVisibility(0);
                    }
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo)localObject3);
                    ((View)localObject1).setDrawingCacheEnabled(false);
                    AppMethodBeat.o(99038);
                    return localObject1;
                    paramViewGroup.titleTv.setMaxLines(1);
                    break;
                    paramViewGroup.titleTv.setVisibility(8);
                  }
                  if (i == 6)
                  {
                    paramView = l(paramInt, paramView);
                    AppMethodBeat.o(99038);
                    return paramView;
                  }
                  paramView = m(paramInt, paramView);
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
  
  public final ArrayList<com.tencent.mm.plugin.sns.j.b> iM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99052);
    ArrayList localArrayList = new ArrayList();
    this.EIb = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      SnsInfo localSnsInfo = (SnsInfo)this.list.get(paramInt2);
      int j = localSnsInfo.localid;
      if ((localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (localSnsInfo.getTimeLine().ContentObj.LoV.size() != 0) && ((localSnsInfo.getTimeLine().ContentObj.LoU == 1) || (localSnsInfo.getTimeLine().ContentObj.LoU == 15)))
      {
        if (j == paramInt1) {
          this.EIb = localArrayList.size();
        }
        Iterator localIterator = localSnsInfo.getTimeLine().ContentObj.LoV.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          cnb localcnb = (cnb)localIterator.next();
          com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
          localb.ebR = localcnb;
          localb.parentId = y.bq("sns_table_", j);
          localb.iXu = localSnsInfo.getCreateTime();
          localb.DRJ = i;
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
    View EIg;
    TextView EIh;
    TextView EIi;
    TextView EIj;
    LinearLayout EIk;
    ImageView EIl;
    TextView EIm;
    LinearLayout EIn;
    TextView EIo;
    LinearLayout EnO;
    View EnP;
    
    a() {}
    
    public void init()
    {
      AppMethodBeat.i(99026);
      this.EIh.setVisibility(8);
      this.EIi.setVisibility(8);
      this.EIj.setVisibility(8);
      this.EIk.setVisibility(4);
      this.EIl.setVisibility(4);
      this.EnP.setVisibility(8);
      this.EIm.setVisibility(8);
      this.EIn.setVisibility(8);
      AppMethodBeat.o(99026);
    }
  }
  
  final class b
    extends bh.a
  {
    MMRoundCornerImageView EIp;
    WeImageView EIq;
    TextView EIr;
    View EIs;
    MMNeat7extView pIP;
    TextView titleTv;
    
    b()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(203631);
      super.init();
      this.pIP.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.EIr.setVisibility(8);
      AppMethodBeat.o(203631);
    }
  }
  
  final class c
    extends bh.a
  {
    TextView EIr;
    View EIs;
    TagImageView EIt;
    TextView EIu;
    MMNeat7extView pIP;
    TextView titleTv;
    ImageView uzC;
    
    c()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99027);
      super.init();
      this.pIP.setVisibility(8);
      this.EIt.setVisibility(8);
      if (this.EIu != null) {
        this.EIu.setVisibility(8);
      }
      this.uzC.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.EIr.setVisibility(8);
      AppMethodBeat.o(99027);
    }
  }
  
  public static abstract interface d
  {
    public abstract void fiG();
  }
  
  final class e
    extends bh.a
  {
    TextView EIA;
    TextView EIB;
    TextView EIC;
    TextView EID;
    View EIE;
    TextView EIF;
    TextView EIG;
    TextView EIH;
    TextView EII;
    TextView EIJ;
    TextView EIK;
    MaskLinearLayout EIL;
    MaskImageView EIv;
    QFadeImageView EIw;
    QFadeImageView EIx;
    QFadeImageView EIy;
    MMNeat7extView EIz;
    
    e()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99028);
      super.init();
      this.EIv.setVisibility(8);
      this.EIx.setVisibility(8);
      this.EIy.setVisibility(8);
      this.EIz.setVisibility(8);
      this.EIA.setVisibility(8);
      this.EIB.setVisibility(8);
      this.EIC.setVisibility(8);
      this.EID.setVisibility(8);
      this.EIE.setVisibility(8);
      this.EIw.setVisibility(8);
      this.EIF.setVisibility(8);
      this.EIG.setVisibility(8);
      this.EIH.setVisibility(8);
      this.EII.setVisibility(8);
      this.EIJ.setVisibility(8);
      this.EIK.setVisibility(8);
      if (com.tencent.mm.cb.a.ez(bh.f(bh.this)) > 1.0F) {
        this.EIz.setMaxLines(2);
      }
      AppMethodBeat.o(99028);
    }
  }
  
  final class f
    extends bh.a
  {
    View EIE;
    TextView EIF;
    MaskLinearLayout EIL;
    MaskImageView EIv;
    MMNeat7extView EIz;
    
    f()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99029);
      super.init();
      this.EIv.setVisibility(8);
      this.EIz.setVisibility(8);
      this.EIF.setVisibility(8);
      this.EIE.setVisibility(8);
      if (com.tencent.mm.cb.a.ez(bh.f(bh.this)) > 1.0F) {
        this.EIz.setMaxLines(2);
      }
      AppMethodBeat.o(99029);
    }
  }
  
  static abstract class g
  {
    View.OnClickListener EIM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99033);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "sign click");
        bh.g.this.EIQ = ((bh.g.a)paramAnonymousView.getTag());
        int i = bh.g.this.EIQ.ecf;
        int j = bh.g.this.EIQ.position;
        bh.g.this.iO(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99033);
      }
    };
    View.OnClickListener EIN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99034);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "sign click");
        bh.g.this.EIQ = ((bh.g.a)paramAnonymousView.getTag());
        int i = bh.g.this.EIQ.ecf;
        bh.g.this.ZP(i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99034);
      }
    };
    View.OnClickListener EIO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99035);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "snssight click");
        bh.g.this.EIQ = ((bh.g.a)paramAnonymousView.getTag());
        int i = bh.g.this.EIQ.ecf;
        int j = bh.g.this.EIQ.position;
        bh.g.this.iO(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99035);
      }
    };
    View.OnLongClickListener EIP = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(99036);
          return true;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
        bh.g.this.EIQ = ((bh.g.a)paramAnonymousView.getTag());
        int i = bh.g.this.EIQ.ecf;
        int j = bh.g.this.EIQ.position;
        bh.g.this.iP(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(99036);
        return true;
      }
    };
    public a EIQ = new a();
    View.OnClickListener EnF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99030);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99030);
          return;
        }
        bh.g.this.EIQ = ((bh.g.a)paramAnonymousView.getTag());
        int i = bh.g.this.EIQ.ecf;
        int j = bh.g.this.EIQ.position;
        bh.g.this.iN(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99030);
      }
    };
    View.OnClickListener EnG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99031);
          return;
        }
        bh.g.this.EIQ = ((bh.g.a)paramAnonymousView.getTag());
        int i = bh.g.this.EIQ.ecf;
        int j = bh.g.this.EIQ.position;
        bh.g.this.iN(i, j + 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99031);
      }
    };
    View.OnClickListener EnH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99032);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99032);
          return;
        }
        bh.g.this.EIQ = ((bh.g.a)paramAnonymousView.getTag());
        int i = bh.g.this.EIQ.ecf;
        int j = bh.g.this.EIQ.position;
        bh.g.this.iN(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99032);
      }
    };
    
    public abstract void ZP(int paramInt);
    
    public abstract void iN(int paramInt1, int paramInt2);
    
    public abstract void iO(int paramInt1, int paramInt2);
    
    public abstract void iP(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public int ecf;
      public int position;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh
 * JD-Core Version:    0.7.0.1
 */