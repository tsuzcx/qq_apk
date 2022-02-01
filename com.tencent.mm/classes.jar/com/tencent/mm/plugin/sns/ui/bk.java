package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.aw.i;
import com.tencent.mm.contact.d;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.model.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
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

public final class bk
  extends BaseAdapter
{
  private boolean AXE;
  private String Kca;
  long QtD;
  Map<Integer, Integer> Ram;
  private Map<Integer, Integer> Ran;
  private int Rao;
  private int Rap;
  String RiY;
  private bx RoL;
  private br RvM;
  private Map<Integer, Integer> RvN;
  private g RvO;
  boolean RvP;
  bl RvQ;
  bm RvR;
  private d RvS;
  int RvT;
  int RvU;
  private long RvV;
  private long RvW;
  boolean RvX;
  private int RvY;
  private int RvZ;
  int Rwa;
  protected View.OnClickListener Rwb;
  private String country;
  private Activity hHU;
  private boolean hHq;
  boolean isSearchMode;
  List<SnsInfo> list;
  private String userName;
  String zPH;
  
  public bk(Activity paramActivity, g paramg, String paramString, final d paramd)
  {
    AppMethodBeat.i(99037);
    this.userName = "";
    this.list = new ArrayList();
    this.Ram = new HashMap();
    this.Ran = new HashMap();
    this.RvN = new HashMap();
    this.Rao = 0;
    this.Rap = 0;
    this.hHq = false;
    this.RiY = "";
    this.RvP = false;
    this.AXE = false;
    this.QtD = 0L;
    this.zPH = "";
    this.RoL = null;
    this.Kca = "";
    this.RvT = 2147483647;
    this.RvU = 0;
    this.RvV = 0L;
    this.RvW = 0L;
    this.isSearchMode = false;
    this.RvX = false;
    this.RvY = 0;
    this.RvZ = 0;
    this.Rwa = 0;
    this.Rwb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308558);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          localObject = (TimeLineObject)paramAnonymousView.getTag();
          if (bk.baK(((TimeLineObject)localObject).Id)) {
            break label196;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10090, "1,0");
          if ((!com.tencent.mm.n.a.dm(bk.f(bk.this))) && (!com.tencent.mm.n.a.dl(bk.f(bk.this))) && (!com.tencent.mm.n.a.dp(bk.f(bk.this))))
          {
            String str1 = al.getAccPath();
            String str2 = ((TimeLineObject)localObject).Id;
            if (((TimeLineObject)localObject).ContentObj == null) {
              break label191;
            }
            paramAnonymousView = ((TimeLineObject)localObject).ContentObj.oPb;
            paramAnonymousView = i.a(str1, (TimeLineObject)localObject, 8, com.tencent.mm.aw.h.a(str2, paramAnonymousView));
            paramAnonymousView.oON = bk.g(bk.this);
            com.tencent.mm.aw.a.c(paramAnonymousView);
          }
        }
        for (;;)
        {
          bk.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308558);
          return;
          label191:
          paramAnonymousView = null;
          break;
          label196:
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10231, "1");
          com.tencent.mm.aw.a.bLi();
        }
      }
    };
    this.userName = paramString;
    this.hHU = paramActivity;
    this.RvO = paramg;
    this.RvS = paramd;
    this.RoL = al.hgp();
    paramg = LocaleUtil.loadApplicationLanguage(this.hHU.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.hHU);
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
    this.Kca = paramActivity;
    this.country = LocaleUtil.loadApplicationLanguage(this.hHU.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.hHU);
    com.tencent.mm.kernel.h.baF();
    paramActivity = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
    if (this.userName.equals(paramActivity)) {
      this.hHq = true;
    }
    Log.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.hHq) {
      this.RvM = br.jbj();
    }
    for (;;)
    {
      this.RvQ = new bl(new bl.a()
      {
        public final void b(List<SnsInfo> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99016);
          if (!bk.a(bk.this))
          {
            Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bk.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            paramAnonymousList = bk.this;
            if (!bk.b(bk.this).isEmpty()) {
              break label119;
            }
          }
          label119:
          for (long l = 0L;; l = ((SnsInfo)bk.b(bk.this).get(bk.b(bk.this).size() - 1)).field_snsId)
          {
            bk.a(paramAnonymousList, t.uB(l));
            if (!bk.b(bk.this).isEmpty()) {
              bk.b(bk.this).get(bk.b(bk.this).size() - 1);
            }
            AppMethodBeat.o(99016);
            return;
          }
        }
        
        public final void hpm()
        {
          AppMethodBeat.i(99017);
          if (!bk.a(bk.this))
          {
            bk.c(bk.this);
            bk.this.notifyDataSetChanged();
            if (paramd != null) {
              paramd.hpn();
            }
          }
          AppMethodBeat.o(99017);
        }
      }, paramString, this.hHq);
      this.RvR = new bm(new bl.a()
      {
        public final void b(List<SnsInfo> paramAnonymousList, Map<Integer, Integer> paramAnonymousMap1, Map<Integer, Integer> paramAnonymousMap2, Map<Integer, Integer> paramAnonymousMap3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(99018);
          if (bk.a(bk.this))
          {
            Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
            bk.this.a(paramAnonymousList, paramAnonymousMap1, paramAnonymousMap2, paramAnonymousMap3, paramAnonymousInt1, paramAnonymousInt2);
            bk.d(bk.this);
          }
          AppMethodBeat.o(99018);
        }
        
        public final void hpm()
        {
          AppMethodBeat.i(99019);
          if (bk.a(bk.this))
          {
            bk.c(bk.this);
            bk.this.notifyDataSetChanged();
            if (paramd != null) {
              paramd.hpn();
            }
          }
          AppMethodBeat.o(99019);
        }
      }, this.hHq);
      vs(0L);
      Ek(false);
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
      com.tencent.mm.kernel.h.baF();
      paramActivity = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
      if ((paramActivity != null) && (d.rs(paramActivity.field_type))) {
        this.RvM = br.jbi();
      } else {
        this.RvM = br.jbk();
      }
    }
  }
  
  private void Ek(boolean paramBoolean)
  {
    AppMethodBeat.i(99046);
    Log.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.zPH);
    if (this.RvQ != null)
    {
      if (this.isSearchMode)
      {
        this.RvR.aX(this.RvP, paramBoolean);
        AppMethodBeat.o(99046);
        return;
      }
      this.RvQ.m(this.zPH, this.RvP, paramBoolean);
    }
    AppMethodBeat.o(99046);
  }
  
  private void G(final TextView paramTextView)
  {
    AppMethodBeat.i(99041);
    if (this.RvY <= 0) {
      paramTextView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99020);
          new Rect();
          paramTextView.measure(0, 0);
          bk.a(bk.this, paramTextView.getMeasuredHeight());
          Log.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", new Object[] { Integer.valueOf(bk.e(bk.this)) });
          AppMethodBeat.o(99020);
        }
      });
    }
    AppMethodBeat.o(99041);
  }
  
  private String a(int paramInt1, int paramInt2, PInt paramPInt)
  {
    AppMethodBeat.i(308349);
    Object localObject1 = "";
    Object localObject2;
    if (paramInt1 < this.list.size())
    {
      localObject2 = (SnsInfo)getItem(paramInt1);
      if (((SnsInfo)localObject2).getHead() != paramInt2)
      {
        AppMethodBeat.o(308349);
        return localObject1;
      }
      paramPInt.value += 1;
      if (!Util.isNullOrNil((String)localObject1)) {
        break label149;
      }
      localObject2 = ((SnsInfo)localObject2).getTimeLine();
      if (((TimeLineObject)localObject2).Location == null) {
        break label149;
      }
      if (Util.isNullOrNil(((TimeLineObject)localObject2).Location.poiName))
      {
        localObject2 = ((TimeLineObject)localObject2).Location.pSh;
        label108:
        if (Util.isNullOrNil((String)localObject2)) {
          break label149;
        }
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      localObject1 = localObject2;
      break;
      localObject2 = ((TimeLineObject)localObject2).Location.poiName;
      break label108;
      AppMethodBeat.o(308349);
      return localObject1;
      label149:
      localObject2 = localObject1;
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, e parame, int paramInt3)
  {
    AppMethodBeat.i(99044);
    SnsInfo localSnsInfo = (SnsInfo)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
    SnsObject localSnsObject = ap.E(localSnsInfo);
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
    if ((this.hHq) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localSnsInfo.getUserName())))
    {
      paramTextView3.setBackgroundResource(b.e.personactivity_sharephoto_icon);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (ap.bG(localSnsInfo.getLocalPrivate(), this.hHq))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(b.e.personactivity_keyphoto_icon);
        localObject = this.RoL.JE(localSnsInfo.getUserName());
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
      paramTextView1 = new bk.g.a();
      paramTextView1.icg = paramInt1;
      if (this.RvN.get(Integer.valueOf(paramInt3)) == null) {
        break label677;
      }
      paramTextView1.position = ((Integer)this.RvN.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new br(this.RvM.tag);
      paramTextView1.time = localSnsInfo.field_createTime;
      if (localTimeLineObject.ContentObj.Zpq != 1) {
        break label685;
      }
      paramQFadeImageView.setVisibility(0);
      al.hgy().a(localTimeLineObject.ContentObj.Zpr, paramQFadeImageView, this.hHU.hashCode(), g.a.QrR, paramTextView1);
      label367:
      if ((localSnsInfo.isInValid()) && (localSnsInfo.isDieItem()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(b.e.personactivity_failicon);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.ContentObj.Zpr == null) || (localTimeLineObject.ContentObj.Zpr.size() <= 1)) {
          break label808;
        }
        parame.RwD.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.ContentObj.Zpr.size();
        paramTextView2.setText(this.hHU.getResources().getQuantityString(b.h.sns_media_count, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.ContentDesc;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        parame.RwD.setVisibility(0);
        parame.Rwy.setVisibility(0);
        parame.Rwy.aZ(p.b(this.hHU, paramQFadeImageView, parame.Rwy.getTextSize()));
      }
      AppMethodBeat.o(99044);
      return;
      label559:
      localObject = ((d)localObject).aSV();
      break;
      if (!ap.bG(localSnsInfo.getLocalPrivate(), this.hHq)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(b.e.personactivity_keyphoto_icon);
      localObject = this.RoL.JE(localSnsInfo.getUserName());
      if (localObject == null) {}
      for (localObject = "";; localObject = ((d)localObject).aSV())
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
      if (localTimeLineObject.ContentObj.Zpq == 2)
      {
        paramTextView4.setText(Util.nullAs(localTimeLineObject.ContentObj.IGG, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.ContentObj.Zpq != 21) {
        break label367;
      }
      localSnsInfo.getPostInfo();
      boolean bool = true;
      if (this.hHq) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        al.hgy().a(localTimeLineObject.ContentObj.Zpr, paramQFadeImageView, this.hHU.hashCode(), g.a.QrR, paramTextView1, bool);
        break;
        if (m.a(localSnsInfo, localSnsObject)) {
          bool = false;
        }
      }
      label808:
      paramTextView2.setVisibility(8);
    }
  }
  
  private static void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(308334);
    paramView2.setContentDescription(paramString2);
    if (Util.isNullOrNil(paramString1))
    {
      paramView1.setContentDescription("");
      AppMethodBeat.o(308334);
      return;
    }
    paramView1.setContentDescription(paramString1 + "," + paramString2);
    AppMethodBeat.o(308334);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(99039);
    Object localObject = this.hHU;
    if (!this.Kca.equals("en")) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = (String)bp.b((Context)localObject, 1000L * paramLong, bool);
      paramTextView2.getParent();
      paramTextView2.setTextSize(0, com.tencent.mm.cd.a.bs(this.hHU, b.d.LargestTextSize));
      paramTextView1.setTextSize(0, com.tencent.mm.cd.a.bs(this.hHU, b.d.DescTextSize));
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
      paramTextView2.setContentDescription(String.format(this.hHU.getResources().getString(b.j.sns_album_month_day), new Object[] { localObject[0], localObject[1] }));
      AppMethodBeat.o(99039);
      return;
    }
    if (((String)localObject).indexOf("/") > 0)
    {
      localObject = ((String)localObject).split("/");
      if (localObject[1].length() < 2) {
        localObject[1] = ("0" + localObject[1]);
      }
      localObject[0] = bp.S(this.hHU, localObject[0], this.Kca);
      paramTextView1.setText(localObject[0]);
      paramTextView2.setText(localObject[1]);
      paramTextView2.setVisibility(0);
      paramTextView1.setVisibility(0);
      paramTextView2.setContentDescription(String.format(this.hHU.getResources().getString(b.j.sns_album_month_day), new Object[] { localObject[0], localObject[1] }));
      AppMethodBeat.o(99039);
      return;
    }
    paramTextView2.setContentDescription(String.valueOf(localObject));
    paramTextView2.setVisibility(0);
    paramTextView2.setText(String.valueOf(localObject));
    AppMethodBeat.o(99039);
  }
  
  protected static boolean baK(String paramString)
  {
    AppMethodBeat.i(99054);
    com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
    if ((localf != null) && (com.tencent.mm.aw.a.e(localf)) && (paramString.equals(localf.oOv)) && (com.tencent.mm.aw.a.bLk()))
    {
      AppMethodBeat.o(99054);
      return true;
    }
    AppMethodBeat.o(99054);
    return false;
  }
  
  private boolean bd(int paramInt, long paramLong)
  {
    return (!this.isSearchMode) || ((paramInt == 0) && (this.QtD == paramLong)) || (paramInt > 0) || (this.RvX);
  }
  
  private void c(TextView paramTextView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99040);
    int i = paramInt1 / 10000;
    paramInt2 /= 10000;
    G(paramTextView);
    Log.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if (this.isSearchMode)
    {
      if ((i != 0) && (paramInt2 != i))
      {
        jJ(paramTextView);
        paramTextView.setText(String.format(this.hHU.getResources().getString(b.j.sns_user_date_year), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        G(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (i == 0)
    {
      if (bp.getYear() != paramInt2)
      {
        jJ(paramTextView);
        paramTextView.setText(String.format(this.hHU.getResources().getString(b.j.sns_user_date_year), new Object[] { Integer.valueOf(paramInt2) }));
        paramTextView.setVisibility(0);
        G(paramTextView);
        AppMethodBeat.o(99040);
      }
    }
    else if (paramInt2 != i)
    {
      jJ(paramTextView);
      paramTextView.setText(String.format(this.hHU.getResources().getString(b.j.sns_user_date_year), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      G(paramTextView);
    }
    AppMethodBeat.o(99040);
  }
  
  private static boolean hop()
  {
    AppMethodBeat.i(163123);
    if ((ar.a.hhj() & 0x1) <= 0)
    {
      AppMethodBeat.o(163123);
      return true;
    }
    AppMethodBeat.o(163123);
    return false;
  }
  
  private void jJ(View paramView)
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
      localLayoutParams.topMargin = this.hHU.getResources().getDimensionPixelSize(b.d.sns_user_year_top_margin);
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(99042);
  }
  
  private static String jK(View paramView)
  {
    AppMethodBeat.i(308336);
    String str = null;
    if (paramView.getContentDescription() != null)
    {
      str = paramView.getContentDescription().toString();
      paramView.setContentDescription("");
    }
    AppMethodBeat.o(308336);
    return str;
  }
  
  private View v(int paramInt, View paramView)
  {
    AppMethodBeat.i(308339);
    b localb;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localb = new b();
      localView = af.mU(this.hHU).inflate(b.g.sns_photo_user_music_mv, null);
      localb.Rwf = localView.findViewById(b.f.content_ll);
      localb.Rwh = ((TextView)localView.findViewById(b.f.sns_day));
      localb.Rwg = ((TextView)localView.findViewById(b.f.sns_month));
      localb.Rwi = ((TextView)localView.findViewById(b.f.sns_year));
      localb.Rwl = ((TextView)localView.findViewById(b.f.address));
      localb.RaF = localView.findViewById(b.f.line_add);
      localb.Rwl = ((TextView)localView.findViewById(b.f.address));
      localb.Rwj = ((LinearLayout)localView.findViewById(b.f.line_add_item));
      localb.Rwk = ((ImageView)localView.findViewById(b.f.lock_line_add_item_b));
      localb.RaE = ((LinearLayout)localView.findViewById(b.f.listener_keeper));
      localb.Ilj = ((MMNeat7extView)localView.findViewById(b.f.desc_tv));
      localb.Rwo = ((MMRoundCornerImageView)localView.findViewById(b.f.music_cover_iv));
      localb.titleTv = ((TextView)localView.findViewById(b.f.music_title_tv));
      localb.Rwq = ((TextView)localView.findViewById(b.f.music_desc_tv));
      localb.Rwp = ((WeImageView)localView.findViewById(b.f.music_media_icon_iv));
      localb.Rwf.setOnClickListener(this.RvO.RwI);
      localb.Rwr = localView.findViewById(b.f.media_content_rl);
      localb.Rwm = ((LinearLayout)localView.findViewById(b.f.friends_limit));
      localb.Rwn = ((TextView)localView.findViewById(b.f.sns_no_see_tip_reset_tips_btn));
      localb.Rwn.setOnClickListener(new bk.8(this));
      localView.setTag(localb);
      localb.Rwi.setTag(Integer.valueOf(paramInt));
      if (this.Ram.get(Integer.valueOf(paramInt)) == null) {
        break label2107;
      }
    }
    label815:
    label1074:
    label2107:
    for (int i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localb.init();
      if ((i >= this.Rap) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(308339);
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
        ap.bG(paramView.getLocalPrivate(), this.hHq);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        if (this.Ran.get(Integer.valueOf(paramInt)) != null) {
          ((Integer)this.Ran.get(Integer.valueOf(paramInt))).intValue();
        }
        Object localObject3 = (SnsInfo)getItem(i);
        TimeLineObject localTimeLineObject = ((SnsInfo)localObject3).getTimeLine();
        if (((this.hHq) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject3).getHead() != j))
        {
          if (bd(paramInt, ((SnsInfo)localObject3).field_snsId))
          {
            long l = ((SnsInfo)localObject3).getCreateTime();
            a(localb.Rwg, localb.Rwh, l);
          }
          paramView = a(i, ((SnsInfo)localObject3).getHead(), new PInt());
          if (!Util.isNullOrNil(paramView))
          {
            localb.Rwl.setText(paramView);
            localb.Rwl.setVisibility(0);
          }
          localb.RaF.setVisibility(0);
        }
        c(localb.Rwi, j, ((SnsInfo)localObject3).getHead());
        label872:
        Object localObject1;
        String str2;
        String str1;
        if ((this.RvW != 0L) && (((SnsInfo)localObject3).field_snsId == this.RvW))
        {
          localb.Rwm.setVisibility(0);
          paramView = new bk.g.a();
          paramView.icg = ((SnsInfo)localObject3).localid;
          if (this.RvN.get(Integer.valueOf(paramInt)) == null) {
            break label1760;
          }
          paramView.position = ((Integer)this.RvN.get(Integer.valueOf(paramInt))).intValue();
          localb.Rwf.setTag(paramView);
          if (Util.isNullOrNil(localTimeLineObject.ContentDesc)) {
            break label1768;
          }
          localb.Ilj.setVisibility(0);
          localb.Ilj.aZ(p.b(this.hHU, localTimeLineObject.ContentDesc, localb.Ilj.getTextSize()));
          localb.Rwj.setVisibility(0);
          localb.Ilj.setMaxLines(1);
          localb.Ilj.getWrappedTextView().setSingleLine(true);
          localb.Rwr.setVisibility(0);
          new br(this.RvM.tag).time = ((SnsInfo)localObject3).field_createTime;
          localObject1 = "";
          str2 = "";
          if ((localTimeLineObject.ContentObj == null) || (localTimeLineObject.ContentObj.oPb == null)) {
            break label2094;
          }
          str1 = localTimeLineObject.ContentObj.oPb.YqQ;
          if (!Util.isNullOrNil(str1))
          {
            Log.i("MicroMsg.SnsphotoAdapter", "has mvInfo:%s", new Object[] { str1 });
            localb.Rwq.setVisibility(0);
            localb.Rwq.setText(str1 + this.hHU.getString(b.j.music_mv_info_share_suffix));
          }
          localObject1 = localTimeLineObject.ContentObj.oPb.YqP;
        }
        for (;;)
        {
          Object localObject2;
          if (!Util.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.music.h.b.aPp((String)localObject1);
            localObject2 = localObject1;
            Log.i("MicroMsg.SnsphotoAdapter", "coverInfo, posterInfo:%s, coverUrl: %s, coverPath: %s", new Object[] { str1, localObject2, paramView });
            localb.Rwo.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(b.e.music_mv_cover_empty_lightmode));
            if (aw.isDarkMode()) {
              localb.Rwo.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(b.e.music_mv_cover_empty_darkmode));
            }
            if (Util.isNullOrNil((String)localObject2)) {
              break label2071;
            }
            localb.Rwp.setVisibility(0);
            localb.Rwr.setVisibility(0);
            localb.titleTv.setMaxLines(1);
            localb.titleTv.setTextColor(this.hHU.getResources().getColor(b.c.sns_link_color));
            localObject1 = "";
            if (localTimeLineObject.ContentObj.Zpr.isEmpty()) {
              break label2087;
            }
            localObject1 = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
            ((dmz)localObject1).icg = ((SnsInfo)localObject3).localid;
            str2 = ((dmz)localObject1).IGG;
            localObject1 = ((dmz)localObject1).hAP;
          }
          for (;;)
          {
            localObject3 = new c.a();
            ((c.a)localObject3).fullPath = paramView;
            ((c.a)localObject3).oKp = true;
            ((c.a)localObject3).nrc = true;
            ((c.a)localObject3).oKn = true;
            ((c.a)localObject3).nqa = true;
            ((c.a)localObject3).oKI = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
            localObject3 = ((c.a)localObject3).bKx();
            r.bKe().a((String)localObject2, localb.Rwo, (c)localObject3);
            localb.Rwp.setPressed(false);
            if (baK(localTimeLineObject.Id))
            {
              localb.Rwp.setImageResource(b.i.icons_outlined_pause2);
              localb.Rwp.setContentDescription(this.hHU.getString(b.j.sns_stop_music));
              label1384:
              localb.Rwp.setIconColor(MMApplicationContext.getContext().getResources().getColor(b.c.black_color));
              localb.Rwp.setTag(localTimeLineObject);
              localb.Rwp.setOnClickListener(this.Rwb);
              localb.Rwr.setTag(localTimeLineObject);
              localb.titleTv.setVisibility(0);
              if (Util.isNullOrNil(str1)) {
                break label1960;
              }
              localObject2 = localObject1;
              if (!Util.isNullOrNil(str2)) {
                localObject2 = (String)localObject1 + String.format("·%s", new Object[] { str2 });
              }
              localb.titleTv.setText((CharSequence)localObject2);
              label1510:
              if (localTimeLineObject.ContentObj.oPb == null) {
                localTimeLineObject.ContentObj.oPb = new dtj();
              }
              localTimeLineObject.ContentObj.oPb.oPc = paramView;
              localObject1 = localTimeLineObject.ContentObj.oPb;
              paramView = new StringBuffer(this.hHU.getString(b.j.sns_link));
              if (!Util.isNullOrNil((String)localObject2)) {
                paramView.append((String)localObject2 + ",");
              }
              if (!Util.isNullOrNil(((dtj)localObject1).singerName)) {
                paramView.append(((dtj)localObject1).singerName + ",");
              }
              localObject1 = com.tencent.mm.plugin.sns.d.a.pFo.x(this.hHU, localTimeLineObject.AppInfo.Id);
              if (!Util.isNullOrNil((String)localObject1)) {
                paramView.append((String)localObject1);
              }
            }
            for (paramView = localTimeLineObject.ContentDesc + "，" + paramView;; paramView = "")
            {
              a(localb.RaE, localb.Rwr, jK(localb.Rwh), paramView);
              AppMethodBeat.o(308339);
              return localView;
              localb.Rwm.setVisibility(8);
              break;
              label1760:
              paramView.position = 0;
              break label815;
              label1768:
              localb.Ilj.setVisibility(8);
              break label872;
              localObject2 = localObject1;
              paramView = str2;
              if (localTimeLineObject.ContentObj.Zpr.isEmpty()) {
                break label1074;
              }
              dmz localdmz = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
              if ((localdmz != null) && (!Util.isNullOrNil(localdmz.aaTl)))
              {
                localObject2 = localdmz.aaTl;
                paramView = com.tencent.mm.plugin.music.h.b.aPp(localdmz.aaTl);
                break label1074;
              }
              localObject2 = localObject1;
              paramView = str2;
              if (localdmz == null) {
                break label1074;
              }
              paramView = al.hgq().vk(localdmz.icg);
              localObject1 = t.aXq(paramView.Oxm);
              localObject1 = as.mg(al.getAccSnsPath(), paramView.Oxm) + (String)localObject1;
              paramView = (View)localObject1;
              localObject2 = localObject1;
              break label1074;
              localb.Rwp.setImageResource(b.i.icons_outlined_play2);
              localb.Rwp.setContentDescription(this.hHU.getString(b.j.sns_play_music));
              break label1384;
              localb.titleTv.setText((CharSequence)localObject1);
              if ((localTimeLineObject.ContentObj.oPb != null) && (!Util.isNullOrNil(localTimeLineObject.ContentObj.oPb.singerName)))
              {
                localb.Rwq.setVisibility(0);
                localb.Rwq.setText(localTimeLineObject.ContentObj.oPb.singerName);
                localObject2 = localObject1;
                break label1510;
              }
              localObject2 = localObject1;
              if (Util.isNullOrNil(str2)) {
                break label1510;
              }
              localb.Rwq.setVisibility(0);
              localb.Rwq.setText(str2);
              localObject2 = localObject1;
              break label1510;
              localb.Rwr.setVisibility(8);
            }
            str2 = "";
          }
          str1 = "";
        }
        j = -1;
      }
    }
  }
  
  private void vs(long paramLong)
  {
    AppMethodBeat.i(99050);
    Object localObject = t.uB(al.hgB().a(paramLong, al.hgr().aYB(this.userName), this.userName, this.hHq));
    if (this.RiY.equals("")) {}
    for (;;)
    {
      this.zPH = ((String)localObject);
      localObject = al.hgF().aZW(this.userName).hkS();
      if (((arc)localObject).Zyu != 0L) {
        break;
      }
      AppMethodBeat.o(99050);
      return;
      if (((String)localObject).compareTo(this.RiY) >= 0) {
        localObject = this.RiY;
      }
    }
    localObject = t.uB(((arc)localObject).Zyu);
    if (this.zPH.equals(""))
    {
      this.zPH = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
    }
    if (((String)localObject).compareTo(this.zPH) > 0) {}
    for (;;)
    {
      this.zPH = ((String)localObject);
      AppMethodBeat.o(99050);
      return;
      localObject = this.zPH;
    }
  }
  
  private View w(int paramInt, View paramView)
  {
    AppMethodBeat.i(163122);
    c localc;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localc = new c();
      localView = af.mU(this.hHU).inflate(b.g.sns_photo_user_normal, null);
      localc.Rwf = localView.findViewById(b.f.content_ll);
      localc.Rwh = ((TextView)localView.findViewById(b.f.sns_day));
      localc.Rwg = ((TextView)localView.findViewById(b.f.sns_month));
      localc.Rwi = ((TextView)localView.findViewById(b.f.sns_year));
      localc.Rwl = ((TextView)localView.findViewById(b.f.address));
      localc.RaF = localView.findViewById(b.f.line_add);
      localc.Rwl = ((TextView)localView.findViewById(b.f.address));
      localc.Rwj = ((LinearLayout)localView.findViewById(b.f.line_add_item));
      localc.Rwk = ((ImageView)localView.findViewById(b.f.lock_line_add_item_b));
      localc.RaE = ((LinearLayout)localView.findViewById(b.f.listener_keeper));
      localc.Ilj = ((MMNeat7extView)localView.findViewById(b.f.desc_tv));
      localc.Rws = ((TagImageView)localView.findViewById(b.f.image_left));
      localc.DOt = ((ImageView)localView.findViewById(b.f.state));
      localc.titleTv = ((TextView)localView.findViewById(b.f.titletext));
      localc.Rwq = ((TextView)localView.findViewById(b.f.righttext));
      localc.Rwf.setOnClickListener(this.RvO.RwI);
      localc.Rwr = localView.findViewById(b.f.media_content_rl);
      localc.Rwm = ((LinearLayout)localView.findViewById(b.f.friends_limit));
      localc.Rwn = ((TextView)localView.findViewById(b.f.sns_no_see_tip_reset_tips_btn));
      localc.Rwn.setOnClickListener(new bk.9(this));
      localView.setTag(localc);
      t.c(localc.Rws, this.hHU);
      localc.Rwi.setTag(Integer.valueOf(paramInt));
      if (this.Ram.get(Integer.valueOf(paramInt)) == null) {
        break label2181;
      }
    }
    label810:
    label1211:
    label1220:
    label1233:
    label2134:
    label2146:
    for (int i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localc.init();
      if ((i >= this.Rap) || (i == -1))
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
      if (i - 1 >= 0) {}
      label868:
      label1643:
      label2159:
      for (int j = ((SnsInfo)getItem(i - 1)).getHead();; j = -1)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        paramView = (SnsInfo)getItem(i);
        TimeLineObject localTimeLineObject = paramView.getTimeLine();
        Object localObject1;
        Object localObject2;
        if (((this.hHq) && (paramInt == 0)) || (j == -1) || (paramView.getHead() != j))
        {
          if (bd(paramInt, paramView.field_snsId))
          {
            long l = paramView.getCreateTime();
            a(localc.Rwg, localc.Rwh, l);
          }
          localObject1 = new PInt();
          localObject2 = a(i, paramView.getHead(), (PInt)localObject1);
          if (!Util.isNullOrNil((String)localObject2))
          {
            localc.Rwl.setText((CharSequence)localObject2);
            localc.Rwl.setVisibility(0);
            if ((((PInt)localObject1).value == 1) && (paramView.getTimeLine().ContentObj.Zpq == 2)) {
              localc.Rwl.setMaxLines(1);
            }
          }
          localc.RaF.setVisibility(0);
        }
        c(localc.Rwi, j, paramView.getHead());
        if ((this.RvW != 0L) && (paramView.field_snsId == this.RvW))
        {
          localc.Rwm.setVisibility(0);
          localObject1 = new bk.g.a();
          ((bk.g.a)localObject1).icg = paramView.localid;
          if (this.RvN.get(Integer.valueOf(paramInt)) == null) {
            break label1211;
          }
          ((bk.g.a)localObject1).position = ((Integer)this.RvN.get(Integer.valueOf(paramInt))).intValue();
          localc.Rwf.setTag(localObject1);
          if (Util.isNullOrNil(localTimeLineObject.ContentDesc)) {
            break label1220;
          }
          localc.Ilj.setVisibility(0);
          localc.Ilj.aZ(p.b(this.hHU, localTimeLineObject.ContentDesc, localc.Ilj.getTextSize()));
          localc.Rwj.setVisibility(0);
          localc.Ilj.setMaxLines(1);
          localc.Ilj.getWrappedTextView().setSingleLine(true);
          localc.Rwr.setVisibility(0);
          paramInt = localTimeLineObject.ContentObj.Zpq;
          localObject2 = new br(this.RvM.tag);
          ((br)localObject2).time = paramView.field_createTime;
          if (paramInt != 2) {
            break label1233;
          }
          localc.Ilj.setVisibility(0);
          localc.Ilj.getWrappedTextView().setSingleLine(false);
          localc.Ilj.setMaxLines(2);
          localc.Rwr.setVisibility(8);
        }
        dmz localdmz;
        for (;;)
        {
          localObject1 = localTimeLineObject.ContentDesc;
          paramView = (View)localObject1;
          if (localc.titleTv.getVisibility() == 0)
          {
            localc.Ilj.setImportantForAccessibility(2);
            paramView = (String)localObject1 + "," + this.hHU.getString(b.j.sns_link) + "," + localc.titleTv.getText();
          }
          localObject1 = paramView;
          if (localc.Rwq.getVisibility() == 0) {
            localObject1 = paramView + localc.Rwq.getText();
          }
          a(localc.RaE, localc.Rwr, jK(localc.Rwh), (String)localObject1);
          if (localc.titleTv.getVisibility() != 0)
          {
            localc.Ilj.setImportantForAccessibility(1);
            localc.RaE.setContentDescription(localc.Ilj.jPy());
            ((View)localc.RaE.getParent()).setImportantForAccessibility(2);
          }
          localView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(163122);
          return localView;
          localc.Rwm.setVisibility(8);
          break;
          ((bk.g.a)localObject1).position = 0;
          break label810;
          localc.Ilj.setVisibility(8);
          break label868;
          if (paramInt != 4) {
            break label1604;
          }
          if (!localTimeLineObject.ContentObj.Zpr.isEmpty())
          {
            localc.Rws.setVisibility(0);
            localc.DOt.setVisibility(0);
            localc.Rwr.setVisibility(0);
            localc.titleTv.setMaxLines(1);
            localc.titleTv.setTextColor(this.hHU.getResources().getColor(b.c.sns_link_color));
            localdmz = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
            al.hgy().a(localdmz, localc.Rws, b.i.app_attach_file_icon_music, this.hHU.hashCode(), g.a.QrR, (br)localObject2);
            localc.DOt.setPressed(false);
            if (baK(localTimeLineObject.Id))
            {
              localc.DOt.setImageResource(b.e.music_pauseicon);
              localc.DOt.setContentDescription(this.hHU.getString(b.j.sns_stop_music));
              label1403:
              localc.Rws.setTag(localTimeLineObject);
              localc.Rws.setOnClickListener(this.Rwb);
              localdmz.icg = paramView.localid;
              localc.Rwr.setTag(localTimeLineObject);
              paramView = localdmz.IGG;
              if (Util.isNullOrNil(paramView)) {
                break label1566;
              }
              localc.Rwq.setVisibility(0);
              localc.Rwq.setText(paramView);
            }
            for (;;)
            {
              paramView = localdmz.hAP;
              if (Util.isNullOrNil(paramView)) {
                break label1578;
              }
              localc.titleTv.setVisibility(0);
              localc.titleTv.setTag(localObject1);
              localc.titleTv.setOnTouchListener(new ai());
              localc.titleTv.setText(paramView);
              break;
              localc.DOt.setImageResource(b.e.music_playicon);
              localc.DOt.setContentDescription(this.hHU.getString(b.j.sns_play_music));
              break label1403;
              localc.Rwq.setVisibility(4);
            }
            localc.titleTv.setVisibility(8);
          }
          else
          {
            localc.Rwr.setVisibility(8);
          }
        }
        localc.titleTv.setTextColor(this.hHU.getResources().getColor(b.c.FG_0));
        if (hop())
        {
          paramView = bn.baM(localTimeLineObject.ContentObj.Url);
          localObject1 = localTimeLineObject.ContentObj.hAP;
          if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
            break label2172;
          }
          com.tencent.mm.smiley.j.iVg();
          paramInt = com.tencent.mm.smiley.j.iE((String)localObject1, 40);
          localObject1 = ((String)localObject1).substring(0, paramInt) + "...";
        }
        label1910:
        label2170:
        label2172:
        for (;;)
        {
          if (localc.Rws != null) {
            localc.Rws.setOnClickListener(null);
          }
          localc.DOt.setVisibility(8);
          if (!localTimeLineObject.ContentObj.Zpr.isEmpty())
          {
            localc.Rws.setVisibility(0);
            localdmz = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
            if (localTimeLineObject.ContentObj.Zpq == 5)
            {
              paramView = bn.baM(localdmz.Url);
              localObject1 = localdmz.hAP;
              localc.DOt.setVisibility(0);
              al.hgy().a(localdmz, localc.Rws, b.i.app_attach_file_icon_video, this.hHU.hashCode(), g.a.QrR, (br)localObject2);
              localObject2 = paramView;
              if (localTimeLineObject.ContentObj.Zpu != null)
              {
                localObject2 = paramView;
                if (localTimeLineObject.ContentObj.Zpu.nQp == 1) {
                  localObject2 = MMApplicationContext.getContext().getString(b.j.mp_pay_content);
                }
              }
              if (Util.isNullOrNil((String)localObject2)) {
                break label2121;
              }
              localc.Rwq.setVisibility(0);
              localc.Rwq.setText((CharSequence)localObject2);
              if (Util.isNullOrNil((String)localObject1)) {
                break label2159;
              }
              if (localc.Rwq.getVisibility() != 8) {
                break label2134;
              }
              localc.titleTv.setMaxLines(2);
              localc.titleTv.setVisibility(0);
              if ((localTimeLineObject.contentattr & 0x1) <= 0) {
                break label2146;
              }
              localc.titleTv.setText(t.a((String)localObject1, this.hHU, localc.titleTv));
            }
          }
          for (;;)
          {
            if ((localTimeLineObject.weappInfo == null) || (localTimeLineObject.weappInfo.subType != 1)) {
              break label2170;
            }
            localc.DOt.setVisibility(0);
            localc.DOt.setImageDrawable(localc.DOt.getContext().getResources().getDrawable(b.i.shortvideo_play_btn));
            break;
            paramView = "";
            break label1643;
            al.hgy().a(localdmz, localc.Rws, this.hHU.hashCode(), g.a.QrR, (br)localObject2);
            break label1840;
            if (localTimeLineObject.ContentObj.Zpq != 26)
            {
              localc.Rws.setVisibility(8);
              break label1840;
            }
            localc.Rws.setVisibility(0);
            localc.Rws.setImageResource(b.i.note_sns_link_default);
            break label1840;
            localc.Rwq.setVisibility(8);
            break label1910;
            localc.titleTv.setMaxLines(1);
            break label1940;
            localc.titleTv.setText((CharSequence)localObject1);
            continue;
            localc.titleTv.setVisibility(8);
          }
          break;
        }
      }
    }
  }
  
  private View x(int paramInt, View paramView)
  {
    AppMethodBeat.i(308359);
    c localc;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
    {
      localc = new c();
      localView = af.mU(this.hHU).inflate(b.g.sns_photo_user_normal, null);
      localc.Rwf = localView.findViewById(b.f.content_ll);
      localc.Rwh = ((TextView)localView.findViewById(b.f.sns_day));
      localc.Rwg = ((TextView)localView.findViewById(b.f.sns_month));
      localc.Rwi = ((TextView)localView.findViewById(b.f.sns_year));
      localc.Rwl = ((TextView)localView.findViewById(b.f.address));
      localc.RaF = localView.findViewById(b.f.line_add);
      localc.Rwl = ((TextView)localView.findViewById(b.f.address));
      localc.Rwj = ((LinearLayout)localView.findViewById(b.f.line_add_item));
      localc.Rwk = ((ImageView)localView.findViewById(b.f.lock_line_add_item_b));
      localc.RaE = ((LinearLayout)localView.findViewById(b.f.listener_keeper));
      localc.Ilj = ((MMNeat7extView)localView.findViewById(b.f.desc_tv));
      localc.Rws = ((TagImageView)localView.findViewById(b.f.image_left));
      localc.DOt = ((ImageView)localView.findViewById(b.f.state));
      localc.titleTv = ((TextView)localView.findViewById(b.f.titletext));
      localc.Rwq = ((TextView)localView.findViewById(b.f.righttext));
      localc.Rwf.setOnClickListener(this.RvO.RwI);
      localc.Rwr = localView.findViewById(b.f.media_content_rl);
      localc.Rwt = ((TextView)localView.findViewById(b.f.content_left));
      localc.Rwm = ((LinearLayout)localView.findViewById(b.f.friends_limit));
      localc.Rwn = ((TextView)localView.findViewById(b.f.sns_no_see_tip_reset_tips_btn));
      localc.Rwn.setOnClickListener(new bk.10(this));
      localView.setTag(localc);
      t.c(localc.Rws, this.hHU);
      localc.Rwi.setTag(Integer.valueOf(paramInt));
      if (this.Ram.get(Integer.valueOf(paramInt)) == null) {
        break label3678;
      }
    }
    label810:
    label1215:
    label1358:
    label3407:
    label3678:
    for (int i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      localc.init();
      if ((i >= this.Rap) || (i == -1))
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        localView.setVisibility(8);
        AppMethodBeat.o(308359);
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
        ap.bG(paramView.getLocalPrivate(), this.hHq);
      }
      for (;;)
      {
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localView.setVisibility(0);
        SnsInfo localSnsInfo = (SnsInfo)getItem(i);
        TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
        if (((this.hHq) && (paramInt == 0)) || (j == -1) || (localSnsInfo.getHead() != j))
        {
          if (bd(paramInt, localSnsInfo.field_snsId))
          {
            long l = localSnsInfo.getCreateTime();
            a(localc.Rwg, localc.Rwh, l);
          }
          paramView = a(i, localSnsInfo.getHead(), new PInt());
          if (!Util.isNullOrNil(paramView))
          {
            localc.Rwl.setText(paramView);
            localc.Rwl.setVisibility(0);
          }
          localc.RaF.setVisibility(0);
        }
        c(localc.Rwi, j, localSnsInfo.getHead());
        Object localObject3;
        if ((this.RvW != 0L) && (localSnsInfo.field_snsId == this.RvW))
        {
          localc.Rwm.setVisibility(0);
          localObject3 = new bk.g.a();
          ((bk.g.a)localObject3).icg = localSnsInfo.localid;
          if (this.RvN.get(Integer.valueOf(paramInt)) == null) {
            break label1031;
          }
          ((bk.g.a)localObject3).position = ((Integer)this.RvN.get(Integer.valueOf(paramInt))).intValue();
          localc.Rwf.setTag(localObject3);
          if (Util.isNullOrNil(localTimeLineObject.ContentDesc)) {
            break label1040;
          }
          localc.Ilj.setVisibility(0);
          localc.Ilj.aZ(p.b(this.hHU, localTimeLineObject.ContentDesc, localc.Ilj.getTextSize()));
        }
        br localbr;
        for (;;)
        {
          localc.Rwj.setVisibility(0);
          localc.Ilj.getWrappedTextView().setSingleLine(true);
          localc.Rwr.setVisibility(0);
          localbr = new br(this.RvM.tag);
          localbr.time = localSnsInfo.field_createTime;
          if ((localTimeLineObject.ContentObj.hKU != null) || (localTimeLineObject.ContentObj.Zpx != null) || (localTimeLineObject.ContentObj.Zpv != null) || (localTimeLineObject.ContentObj.DHa != null) || (localTimeLineObject.ContentObj.Zpy != null) || (localTimeLineObject.ContentObj.Zpz != null) || (localTimeLineObject.ContentObj.ZpA != null)) {
            break label1053;
          }
          Log.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
          AppMethodBeat.o(308359);
          return localView;
          localc.Rwm.setVisibility(8);
          break;
          ((bk.g.a)localObject3).position = 0;
          break label810;
          localc.Ilj.setVisibility(8);
        }
        localc.titleTv.setTextColor(this.hHU.getResources().getColor(b.c.normal_text_color));
        Object localObject2;
        Object localObject1;
        if (hop())
        {
          paramView = bn.baM(localTimeLineObject.ContentObj.Url);
          localObject2 = "";
          if (localTimeLineObject.ContentObj.hKU == null) {
            break label1594;
          }
          paramView = this.hHU.getString(b.j.sns_share_finder_feed_title, new Object[] { t.e(localTimeLineObject.ContentObj.hKU) });
          if (localTimeLineObject.ContentObj.hKU.GfT != 4) {
            break label1547;
          }
          paramView = this.hHU.getString(b.j.sns_share_finder_feed_video_title, new Object[] { t.e(localTimeLineObject.ContentObj.hKU) });
          if (Util.isNullOrNil(t.e(localTimeLineObject.ContentObj.hKU))) {
            paramView = this.hHU.getResources().getString(b.j.finder_app_name);
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
            if (localc.Rws != null)
            {
              localc.Rws.setTag(localObject3);
              localc.Rws.setOnClickListener(this.RvO.RwI);
            }
            localc.DOt.setVisibility(8);
            if (localTimeLineObject.ContentObj.hKU != null) {
              if (localTimeLineObject.ContentObj.hKU.GfT == 1)
              {
                localc.Rws.setVisibility(8);
                localc.Rwt.setVisibility(0);
                localc.Rwt.setText(localTimeLineObject.ContentObj.hKU.desc);
                if (Util.isNullOrNil((String)localObject1)) {
                  break label3622;
                }
                localc.Rwq.setVisibility(0);
                localc.Rwq.setText((CharSequence)localObject1);
                label1385:
                if (Util.isNullOrNil(paramView)) {
                  break label3647;
                }
                if (localc.Rwq.getVisibility() != 8) {
                  break label3635;
                }
                localc.titleTv.setMaxLines(2);
                localc.titleTv.setText(p.b(this.hHU, paramView));
                localc.titleTv.setVisibility(0);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.sns.statistics.j.QFS.Q(localSnsInfo);
              localView.setDrawingCacheEnabled(false);
              localc.Ilj.setImportantForAccessibility(2);
              localc.Rws.setImportantForAccessibility(2);
              a(localc.RaE, localc.Rwf, jK(localc.Rwh), localTimeLineObject.ContentDesc + "，" + localc.titleTv.getText().toString());
              AppMethodBeat.o(308359);
              return localView;
              paramView = "";
              break;
              if (localTimeLineObject.ContentObj.hKU.GfT != 2) {
                break label1180;
              }
              paramView = this.hHU.getString(b.j.sns_share_finder_feed_photo_title, new Object[] { t.e(localTimeLineObject.ContentObj.hKU) });
              break label1180;
              if (localTimeLineObject.ContentObj.Zpx != null)
              {
                paramView = localTimeLineObject.ContentObj.Zpx.title;
                localObject1 = "";
                break label1215;
              }
              if (localTimeLineObject.ContentObj.Zpv != null)
              {
                if (localTimeLineObject.ContentObj.Zpv.Auy == 1) {
                  new StringBuilder("#").append(localTimeLineObject.ContentObj.Zpv.topic);
                }
                if ((localTimeLineObject.ContentObj.Zpv.Auy == 7) && (localTimeLineObject.ContentObj.Zpv.aade != null)) {}
                for (paramView = o.a(localTimeLineObject.ContentObj.Zpv.aade);; paramView = localTimeLineObject.ContentObj.Zpv.topic)
                {
                  localObject1 = localTimeLineObject.ContentObj.Zpv.desc;
                  break;
                }
              }
              if (localTimeLineObject.ContentObj.Zpz != null)
              {
                if ((localTimeLineObject.ContentObj.Zpz.Auy == 7) && (localTimeLineObject.ContentObj.Zpz.aade != null)) {}
                for (paramView = o.a(localTimeLineObject.ContentObj.Zpv.aade);; paramView = localTimeLineObject.ContentObj.Zpz.topic)
                {
                  localObject1 = localTimeLineObject.ContentObj.Zpv.desc;
                  break;
                }
              }
              if (localTimeLineObject.ContentObj.DHa != null)
              {
                if ((Util.isNullOrNil(localTimeLineObject.ContentObj.DHa.nickName)) && (!Util.isNullOrNil(localTimeLineObject.ContentObj.DHa.desc)))
                {
                  localObject2 = localTimeLineObject.ContentObj.DHa.desc;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  break label1215;
                }
                if (!Util.isNullOrNil(localTimeLineObject.ContentObj.DHa.desc))
                {
                  localObject2 = localTimeLineObject.ContentObj.DHa.nickName + ": " + localTimeLineObject.ContentObj.DHa.desc;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  break label1215;
                }
                localObject2 = this.hHU.getString(b.j.sns_share_finder_live_title, new Object[] { localTimeLineObject.ContentObj.DHa.nickName });
                localObject1 = paramView;
                paramView = (View)localObject2;
                break label1215;
              }
              if (localTimeLineObject.ContentObj.Zpy != null)
              {
                paramView = this.hHU.getString(b.j.sns_share_finder_feed_video_title, new Object[] { localTimeLineObject.ContentObj.Zpy.nickname });
                if (Util.isNullOrNil(localTimeLineObject.ContentObj.Zpy.nickname)) {
                  paramView = this.hHU.getResources().getString(b.j.finder_app_name);
                }
                localObject1 = "";
                break label1215;
              }
              if ((localTimeLineObject.ContentObj.ZpA == null) || (Util.isNullOrNil(localTimeLineObject.ContentObj.ZpA.poiName))) {
                break label3663;
              }
              paramView = localTimeLineObject.ContentObj.ZpA.poiName;
              localObject1 = localTimeLineObject.ContentObj.ZpA.AXm;
              break label1215;
              if (!localTimeLineObject.ContentObj.hKU.mediaList.isEmpty())
              {
                localc.Rws.setVisibility(0);
                localObject2 = new dmz();
                ((dmz)localObject2).Url = ((bvj)localTimeLineObject.ContentObj.hKU.mediaList.get(0)).thumbUrl;
                ((dmz)localObject2).aaTl = ((bvj)localTimeLineObject.ContentObj.hKU.mediaList.get(0)).thumbUrl;
                ((dmz)localObject2).vhJ = 2;
                ((dmz)localObject2).aaTm = 1;
                ((dmz)localObject2).aaTn = new dnb();
                ((dmz)localObject2).aazR = 1;
                ((dmz)localObject2).aaTn.aaUb = ((bvj)localTimeLineObject.ContentObj.hKU.mediaList.get(0)).width;
                ((dmz)localObject2).aaTn.aaUc = ((bvj)localTimeLineObject.ContentObj.hKU.mediaList.get(0)).height;
                ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                al.hgy().a((dmz)localObject2, localc.Rws, this.hHU.hashCode(), g.a.QrR, localbr);
              }
              if (localTimeLineObject.ContentObj.hKU.GfT != 4) {
                break label1358;
              }
              localc.DOt.setVisibility(0);
              localc.DOt.setImageDrawable(localc.DOt.getContext().getResources().getDrawable(b.i.shortvideo_play_btn));
              break label1358;
              if (localTimeLineObject.ContentObj.Zpz != null)
              {
                localc.Rws.setVisibility(0);
                if (!Util.isNullOrNil(localTimeLineObject.ContentObj.Zpz.iconUrl))
                {
                  localObject2 = new dmz();
                  ((dmz)localObject2).Url = localTimeLineObject.ContentObj.Zpz.iconUrl;
                  ((dmz)localObject2).aaTl = localTimeLineObject.ContentObj.Zpz.iconUrl;
                  ((dmz)localObject2).vhJ = 2;
                  ((dmz)localObject2).aaTm = 1;
                  ((dmz)localObject2).aaTn = new dnb();
                  ((dmz)localObject2).aazR = 1;
                  ((dmz)localObject2).aaTn.aaUb = 0.0F;
                  ((dmz)localObject2).aaTn.aaUc = 0.0F;
                  ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                  localc.Rws.setScaleType(QImageView.a.afVc);
                  ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImageForSns(localTimeLineObject.ContentObj.Zpz.iconUrl, localc.Rws);
                  break label1358;
                }
                al.hgy().c(localc.Rws, -1, b.i.icon_filled_activity, this.hHU.hashCode());
                break label1358;
              }
              if (localTimeLineObject.ContentObj.Zpv != null)
              {
                localc.Rws.setVisibility(0);
                localObject2 = new dmz();
                ((dmz)localObject2).Url = localTimeLineObject.ContentObj.Zpv.iconUrl;
                ((dmz)localObject2).aaTl = localTimeLineObject.ContentObj.Zpv.iconUrl;
                ((dmz)localObject2).vhJ = 2;
                ((dmz)localObject2).aaTm = 1;
                ((dmz)localObject2).aaTn = new dnb();
                ((dmz)localObject2).aazR = 1;
                ((dmz)localObject2).aaTn.aaUb = 0.0F;
                ((dmz)localObject2).aaTn.aaUc = 0.0F;
                ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                al.hgy().a((dmz)localObject2, localc.Rws, this.hHU.hashCode(), g.a.QrR, localbr);
                break label1358;
              }
              if (localTimeLineObject.ContentObj.Zpx != null)
              {
                localc.Rws.setVisibility(0);
                localObject2 = new dmz();
                localObject3 = (String)localTimeLineObject.ContentObj.Zpx.aacP.get(0);
                String str = (String)localTimeLineObject.ContentObj.Zpx.aacQ.get(0);
                ((dmz)localObject2).Url = ((String)localObject3 + str);
                ((dmz)localObject2).aaTl = ((dmz)localObject2).Url;
                ((dmz)localObject2).vhJ = 2;
                ((dmz)localObject2).aaTm = 1;
                ((dmz)localObject2).aaTn = new dnb();
                ((dmz)localObject2).aazR = 1;
                ((dmz)localObject2).aaTn.aaUb = 0.0F;
                ((dmz)localObject2).aaTn.aaUc = 0.0F;
                ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                al.hgy().a((dmz)localObject2, localc.Rws, this.hHU.hashCode(), g.a.QrR, localbr);
                break label1358;
              }
              if (localTimeLineObject.ContentObj.DHa != null)
              {
                if (localTimeLineObject.ContentObj.DHa.coverUrl.isEmpty()) {
                  break label1358;
                }
                localc.Rws.setVisibility(0);
                localObject2 = new dmz();
                ((dmz)localObject2).Url = localTimeLineObject.ContentObj.DHa.coverUrl;
                ((dmz)localObject2).aaTl = localTimeLineObject.ContentObj.DHa.coverUrl;
                ((dmz)localObject2).vhJ = 2;
                ((dmz)localObject2).aaTm = 1;
                ((dmz)localObject2).aaTn = new dnb();
                ((dmz)localObject2).aazR = 1;
                ((dmz)localObject2).aaTn.aaUb = localTimeLineObject.ContentObj.DHa.width;
                ((dmz)localObject2).aaTn.aaUc = localTimeLineObject.ContentObj.DHa.height;
                ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImageForSns(((dmz)localObject2).Url, localc.Rws);
                break label1358;
              }
              if (localTimeLineObject.ContentObj.Zpy != null)
              {
                if (!localTimeLineObject.ContentObj.Zpy.mediaList.isEmpty())
                {
                  localc.Rws.setVisibility(0);
                  localObject3 = new dmz();
                  if (Util.isNullOrNil(((dob)localTimeLineObject.ContentObj.Zpy.mediaList.get(0)).coverUrl)) {
                    break label3407;
                  }
                }
                for (localObject2 = ((dob)localTimeLineObject.ContentObj.Zpy.mediaList.get(0)).coverUrl;; localObject2 = ((dob)localTimeLineObject.ContentObj.Zpy.mediaList.get(0)).thumbUrl)
                {
                  ((dmz)localObject3).Url = ((String)localObject2);
                  ((dmz)localObject3).aaTl = ((String)localObject2);
                  ((dmz)localObject3).vhJ = 2;
                  ((dmz)localObject3).aaTm = 1;
                  ((dmz)localObject3).aaTn = new dnb();
                  ((dmz)localObject3).aazR = 1;
                  ((dmz)localObject3).aaTn.aaUb = ((dob)localTimeLineObject.ContentObj.Zpy.mediaList.get(0)).width;
                  ((dmz)localObject3).aaTn.aaUc = ((dob)localTimeLineObject.ContentObj.Zpy.mediaList.get(0)).height;
                  ((dmz)localObject3).Id = localSnsInfo.getSnsId();
                  al.hgy().a((dmz)localObject3, localc.Rws, this.hHU.hashCode(), g.a.QrR, localbr);
                  localc.DOt.setVisibility(0);
                  localc.DOt.setImageDrawable(localc.DOt.getContext().getResources().getDrawable(b.i.shortvideo_play_btn));
                  break;
                }
              }
              if (localTimeLineObject.ContentObj.ZpA == null) {
                break label1358;
              }
              localc.Rws.setVisibility(0);
              if (!Util.isNullOrNil(localTimeLineObject.ContentObj.ZpA.XOv))
              {
                localObject2 = new dmz();
                ((dmz)localObject2).Url = localTimeLineObject.ContentObj.ZpA.XOv;
                ((dmz)localObject2).aaTl = localTimeLineObject.ContentObj.ZpA.XOv;
                ((dmz)localObject2).vhJ = 2;
                ((dmz)localObject2).aaTm = 1;
                ((dmz)localObject2).aaTn = new dnb();
                ((dmz)localObject2).aazR = 1;
                ((dmz)localObject2).aaTn.aaUb = 0.0F;
                ((dmz)localObject2).aaTn.aaUc = 0.0F;
                ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                al.hgy().a((dmz)localObject2, localc.Rws, this.hHU.hashCode(), g.a.QrR, localbr);
                break label1358;
              }
              al.hgy().c(localc.Rws, -1, b.i.icons_outlined_location, this.hHU.hashCode());
              break label1358;
              localc.Rwq.setVisibility(8);
              break label1385;
              localc.titleTv.setMaxLines(1);
              break label1414;
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
  
  public final void a(List<SnsInfo> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99045);
    Log.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (this.RvS != null) {
        this.RvS.hpn();
      }
      AppMethodBeat.o(99045);
      return;
    }
    Log.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    this.list.clear();
    this.Ram.clear();
    this.Ran.clear();
    this.RvN.clear();
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
      this.Ram.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      this.Ran.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      this.RvN.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (this.hHq)
    {
      if (this.list.size() <= 1) {}
      for (i = 2147483647;; i = ((SnsInfo)this.list.get(1)).getHead())
      {
        this.RvT = 0;
        j = 0;
        while (j < this.list.size())
        {
          if ((!this.hHq) || (j != 0))
          {
            if (i != ((SnsInfo)this.list.get(j)).getHead()) {
              break;
            }
            this.RvT = Math.max(this.RvT, ((SnsInfo)this.list.get(j)).getCreateTime());
          }
          j += 1;
        }
      }
    }
    if (this.list.isEmpty()) {}
    for (i = 2147483647;; i = ((SnsInfo)this.list.get(0)).getHead()) {
      break;
    }
    if ((this.list.isEmpty()) || ((this.hHq) && (this.list.size() == 1))) {
      this.RvT = 2147483647;
    }
    if (this.list.isEmpty()) {}
    for (i = 0;; i = ((SnsInfo)this.list.get(this.list.size() - 1)).getHead())
    {
      this.RvU = 2147483647;
      j = this.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((SnsInfo)this.list.get(j)).getHead()))
      {
        this.RvU = Math.min(this.RvU, ((SnsInfo)this.list.get(j)).getCreateTime());
        j -= 1;
      }
    }
    if (this.list.isEmpty()) {
      this.RvU = 0;
    }
    this.Rap = paramInt1;
    this.Rao = paramInt2;
    Log.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + this.RvT + " edTIme " + this.RvU);
    notifyDataSetChanged();
    AppMethodBeat.o(99045);
  }
  
  public final int getCount()
  {
    return this.Rao;
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
    if ((this.hHq) && (paramInt == 0) && ((!this.isSearchMode) || ((this.isSearchMode) && (this.RvX))))
    {
      Log.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(99043);
      return 0;
    }
    if (this.Ram.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        Log.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(99043);
        return 0;
      }
      Object localObject = (SnsInfo)getItem(i);
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 1)
      {
        Log.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(99043);
        return 0;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 15)
      {
        Log.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(99043);
        return 2;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 21)
      {
        AppMethodBeat.o(99043);
        return 3;
      }
      if ((((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 28) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 29) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 37) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 38) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 34) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 45) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 43) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 36) || (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 44))
      {
        AppMethodBeat.o(99043);
        return 4;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 33)
      {
        AppMethodBeat.o(99043);
        return 5;
      }
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 4) {
        if (((SnsInfo)localObject).getTimeLine().AppInfo == null) {
          break label612;
        }
      }
      label612:
      for (localObject = ((SnsInfo)localObject).getTimeLine().AppInfo.Id;; localObject = "")
      {
        com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.xeG;
        if (com.tencent.mm.plugin.comm.a.aml((String)localObject))
        {
          AppMethodBeat.o(99043);
          return 6;
        }
        localObject = com.tencent.mm.plugin.comm.a.xeG;
        if (!com.tencent.mm.plugin.comm.a.dsO())
        {
          AppMethodBeat.o(99043);
          return 1;
        }
        AppMethodBeat.o(99043);
        return 1;
        if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 42)
        {
          AppMethodBeat.o(99043);
          return 6;
        }
        if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 39) {}
        switch (((SnsInfo)localObject).getTimeLine().ContentObj.nUa)
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
    int j;
    Object localObject1;
    int k;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
      {
        paramViewGroup = new e();
        paramView = af.mU(this.hHU).inflate(b.g.sns_photo_user_photo, null);
        paramViewGroup.Rwh = ((TextView)paramView.findViewById(b.f.sns_day));
        paramViewGroup.Rwg = ((TextView)paramView.findViewById(b.f.sns_month));
        paramViewGroup.Rwi = ((TextView)paramView.findViewById(b.f.sns_year));
        paramViewGroup.Rwu = ((MaskImageView)paramView.findViewById(b.f.img1));
        paramViewGroup.Rwv = ((QFadeImageView)paramView.findViewById(b.f.take_photo));
        paramViewGroup.Rww = ((MaskImageView)paramView.findViewById(b.f.img2));
        paramViewGroup.Rwx = ((MaskImageView)paramView.findViewById(b.f.img3));
        paramViewGroup.Rwy = ((MMNeat7extView)paramView.findViewById(b.f.desc));
        paramViewGroup.Rwz = ((TextView)paramView.findViewById(b.f.with_username1));
        paramViewGroup.RwA = ((TextView)paramView.findViewById(b.f.with_username2));
        paramViewGroup.RwB = ((TextView)paramView.findViewById(b.f.with_username3));
        paramViewGroup.RwC = ((TextView)paramView.findViewById(b.f.img_count));
        paramViewGroup.RwD = paramView.findViewById(b.f.desc_count);
        paramViewGroup.Rwl = ((TextView)paramView.findViewById(b.f.address));
        paramViewGroup.Rwj = ((LinearLayout)paramView.findViewById(b.f.line_add_item));
        paramViewGroup.Rwk = ((ImageView)paramView.findViewById(b.f.lock_line_add_item_b));
        paramViewGroup.RaE = ((LinearLayout)paramView.findViewById(b.f.listener_keeper));
        paramViewGroup.RaF = paramView.findViewById(b.f.line_add);
        paramViewGroup.Rwv.setOnClickListener(this.RvO.Rav);
        paramViewGroup.Rwu.setOnClickListener(this.RvO.Rav);
        paramViewGroup.Rww.setOnClickListener(this.RvO.Raw);
        paramViewGroup.Rwx.setOnClickListener(this.RvO.Rax);
        paramViewGroup.Rwu.setOnLongClickListener(this.RvO.RwL);
        paramViewGroup.Rww.setOnLongClickListener(this.RvO.RwL);
        paramViewGroup.Rwx.setOnLongClickListener(this.RvO.RwL);
        paramViewGroup.RwE = ((TextView)paramView.findViewById(b.f.warn1));
        paramViewGroup.RwF = ((TextView)paramView.findViewById(b.f.warn2));
        paramViewGroup.RwG = ((TextView)paramView.findViewById(b.f.warn3));
        paramViewGroup.JfT = ((TextView)paramView.findViewById(b.f.tv1));
        paramViewGroup.JfU = ((TextView)paramView.findViewById(b.f.tv2));
        paramViewGroup.JfV = ((TextView)paramView.findViewById(b.f.tv3));
        paramViewGroup.RwH = ((MaskLinearLayout)paramView.findViewById(b.f.sns_line_blackground));
        paramViewGroup.RwH.b(paramViewGroup.Rwu);
        paramViewGroup.Rwm = ((LinearLayout)paramView.findViewById(b.f.friends_limit));
        paramViewGroup.Rwn = ((TextView)paramView.findViewById(b.f.sns_no_see_tip_reset_tips_btn));
        paramViewGroup.Rwn.setOnClickListener(new bk.7(this));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        al.hgy().jq(paramViewGroup.Rwu);
        al.hgy().jq(paramViewGroup.Rww);
        al.hgy().jq(paramViewGroup.Rwx);
        j = -1;
        if (this.Ram.get(Integer.valueOf(paramInt)) != null) {
          j = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.Rwi.setTag(Integer.valueOf(paramInt));
        paramViewGroup.RwH.settouchEnable(false);
        paramViewGroup.RwH.setBackgroundResource(0);
        paramViewGroup.RwH.setDescendantFocusability(131072);
        paramViewGroup.RwH.setClickable(false);
        paramViewGroup.Rwu.settouchEnable(true);
        paramViewGroup.Rwu.setClickable(true);
        paramViewGroup.Rwu.setLongClickable(false);
        paramViewGroup.Rww.setLongClickable(false);
        paramViewGroup.Rwx.setLongClickable(false);
        paramViewGroup.RwH.setOnClickListener(null);
        paramViewGroup.RwH.setOnLongClickListener(null);
        paramViewGroup.RwH.setLongClickable(false);
        if ((j < this.Rap) && (j != -1)) {
          break;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(99038);
        return paramView;
        paramViewGroup = (e)paramView.getTag();
      }
      if (j - 1 < 0) {
        break label5821;
      }
      localObject1 = (SnsInfo)getItem(j - 1);
      k = ((SnsInfo)localObject1).getHead();
      ap.bG(((SnsInfo)localObject1).getLocalPrivate(), this.hHq);
    }
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.setVisibility(0);
      if (this.Ran.get(Integer.valueOf(paramInt)) != null) {}
      for (i = ((Integer)this.Ran.get(Integer.valueOf(paramInt))).intValue();; i = 1)
      {
        Object localObject2 = (SnsInfo)getItem(j);
        localObject1 = ((SnsInfo)localObject2).getTimeLine();
        long l;
        Object localObject3;
        if (((this.hHq) && (paramInt == 0)) || (k == -1) || (((SnsInfo)localObject2).getHead() != k))
        {
          if (bd(paramInt, ((SnsInfo)localObject2).field_snsId))
          {
            l = ((SnsInfo)localObject2).getCreateTime();
            a(paramViewGroup.Rwg, paramViewGroup.Rwh, l);
          }
          localObject3 = a(j, ((SnsInfo)localObject2).getHead(), new PInt());
          if (!Util.isNullOrNil((String)localObject3))
          {
            paramViewGroup.Rwl.setText((CharSequence)localObject3);
            paramViewGroup.Rwl.setVisibility(0);
          }
          paramViewGroup.RaF.setVisibility(0);
        }
        label1175:
        Object localObject4;
        if ((this.RvW != 0L) && (((SnsInfo)localObject2).field_snsId == this.RvW))
        {
          paramViewGroup.Rwm.setVisibility(0);
          paramViewGroup.Rwj.setVisibility(0);
          if ((!this.hHq) || (paramInt != 0) || ((this.isSearchMode) && ((!this.isSearchMode) || (!this.RvX)))) {
            break label1358;
          }
          paramViewGroup.Rwv.setVisibility(0);
          paramViewGroup.Rwv.setContentDescription(this.hHU.getString(b.j.sns_take_photo));
          paramViewGroup.Rwu.setVisibility(8);
          localObject2 = paramViewGroup.Rwy;
          if (this.Rao != 1) {
            break label1344;
          }
          localObject1 = this.hHU.getString(b.j.sns_user_start);
          ((MMNeat7extView)localObject2).aZ((CharSequence)localObject1);
          paramViewGroup.Rwy.setVisibility(0);
          paramViewGroup.RwD.setVisibility(0);
          paramViewGroup.RwC.setVisibility(8);
          al.hgy().c(paramViewGroup.Rwv, b.c.sns_user_take_photo_bg, b.e.sns_takephoto_icon, this.hHU.hashCode());
          localObject1 = new bk.g.a();
          ((bk.g.a)localObject1).icg = -1;
          ((bk.g.a)localObject1).position = -1;
          paramViewGroup.Rwv.setTag(localObject1);
          localObject2 = paramViewGroup.RaE;
          localObject3 = paramViewGroup.RwH;
          localObject4 = jK(paramViewGroup.Rwh);
          if (paramViewGroup.Rwv.getContentDescription() == null) {
            break label1351;
          }
        }
        label1344:
        label1351:
        for (localObject1 = paramViewGroup.Rwv.getContentDescription().toString();; localObject1 = "")
        {
          a((View)localObject2, (View)localObject3, (String)localObject4, (String)localObject1);
          paramViewGroup.RwH.setImportantForAccessibility(2);
          AppMethodBeat.o(99038);
          return paramView;
          paramViewGroup.Rwm.setVisibility(8);
          break;
          localObject1 = "";
          break label1175;
        }
        label1358:
        c(paramViewGroup.Rwi, k, ((SnsInfo)localObject2).getHead());
        if (i > 0)
        {
          a(j, paramViewGroup.Rwu, paramViewGroup.Rwz, paramViewGroup.RwC, paramViewGroup.RwE, paramViewGroup.JfT, 1, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.statistics.j.QFS.Q((SnsInfo)getItem(j));
        }
        if (i >= 2)
        {
          a(j + 1, paramViewGroup.Rww, paramViewGroup.RwA, paramViewGroup.RwC, paramViewGroup.RwF, paramViewGroup.JfU, 2, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.statistics.j.QFS.Q((SnsInfo)getItem(j + 1));
        }
        if (i >= 3)
        {
          a(j + 2, paramViewGroup.Rwx, paramViewGroup.RwB, paramViewGroup.RwC, paramViewGroup.RwG, paramViewGroup.JfV, 3, paramViewGroup, paramInt);
          com.tencent.mm.plugin.sns.statistics.j.QFS.Q((SnsInfo)getItem(j + 2));
        }
        if (i == 1)
        {
          localObject3 = (SnsInfo)getItem(j);
          if ((!Util.isNullOrNil(((SnsInfo)localObject3).getTimeLine().ContentDesc)) && (((SnsInfo)localObject3).getTypeFlag() == 1))
          {
            paramViewGroup.RwH.setDescendantFocusability(393216);
            paramViewGroup.RwH.setClickable(true);
            paramViewGroup.Rwu.setClickable(false);
            paramViewGroup.Rwu.settouchEnable(false);
            paramViewGroup.RwH.setOnClickListener(this.RvO.Rav);
            paramViewGroup.RwH.settouchEnable(true);
            j = ((SnsInfo)localObject2).localid;
            localObject2 = new bk.g.a();
            ((bk.g.a)localObject2).icg = j;
            if (this.RvN.get(Integer.valueOf(paramInt)) == null) {
              break label1855;
            }
            ((bk.g.a)localObject2).position = ((Integer)this.RvN.get(Integer.valueOf(paramInt))).intValue();
            if ((((SnsInfo)localObject3).isInValid()) && (((SnsInfo)localObject3).isDieItem())) {
              paramViewGroup.RwH.setOnLongClickListener(this.RvO.RwL);
            }
            paramViewGroup.RwH.setTag(localObject2);
          }
        }
        paramInt = i;
        if (((TimeLineObject)localObject1).ContentObj != null)
        {
          paramInt = i;
          if (((TimeLineObject)localObject1).ContentObj.Zpr != null) {
            paramInt = Math.max(((TimeLineObject)localObject1).ContentObj.Zpr.size(), i);
          }
        }
        localObject2 = new StringBuilder().append(((TimeLineObject)localObject1).ContentDesc).append("，");
        if (paramInt > 1) {}
        for (localObject1 = this.hHU.getString(b.j.contains_photos_desc);; localObject1 = this.hHU.getString(b.j.contains_one_photo_desc))
        {
          localObject1 = (String)localObject1;
          a(paramViewGroup.RaE, paramViewGroup.RwH, jK(paramViewGroup.Rwh), (String)localObject1);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(99038);
          return paramView;
          label1855:
          ((bk.g.a)localObject2).position = 0;
          break;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof f)))
          {
            paramViewGroup = new f();
            paramView = af.mU(this.hHU).inflate(b.g.sns_sight_user, null);
            paramViewGroup.Rwh = ((TextView)paramView.findViewById(b.f.sns_day));
            paramViewGroup.Rwg = ((TextView)paramView.findViewById(b.f.sns_month));
            paramViewGroup.Rwi = ((TextView)paramView.findViewById(b.f.sns_year));
            paramViewGroup.Rwu = ((MaskImageView)paramView.findViewById(b.f.img1));
            paramViewGroup.Rwl = ((TextView)paramView.findViewById(b.f.address));
            paramViewGroup.Rwj = ((LinearLayout)paramView.findViewById(b.f.line_add_item));
            paramViewGroup.Rwk = ((ImageView)paramView.findViewById(b.f.lock_line_add_item_b));
            paramViewGroup.RaE = ((LinearLayout)paramView.findViewById(b.f.listener_keeper));
            paramViewGroup.RaF = paramView.findViewById(b.f.line_add);
            paramViewGroup.Rwu.setOnClickListener(this.RvO.RwK);
            paramViewGroup.RwE = ((TextView)paramView.findViewById(b.f.warn1));
            paramViewGroup.RwH = ((MaskLinearLayout)paramView.findViewById(b.f.sns_line_blackground));
            paramViewGroup.RwH.b(paramViewGroup.Rwu);
            paramViewGroup.Rwy = ((MMNeat7extView)paramView.findViewById(b.f.desc));
            paramViewGroup.RwD = paramView.findViewById(b.f.desc_count);
            paramViewGroup.Rwm = ((LinearLayout)paramView.findViewById(b.f.friends_limit));
            paramViewGroup.Rwn = ((TextView)paramView.findViewById(b.f.sns_no_see_tip_reset_tips_btn));
            paramViewGroup.Rwn.setOnClickListener(new bk.6(this));
            paramView.setTag(paramViewGroup);
            al.hgy().jq(paramViewGroup.Rwu);
            if (this.Ram.get(Integer.valueOf(paramInt)) == null) {
              break label5809;
            }
          }
        }
        label4382:
        label5791:
        label5797:
        label5809:
        for (i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.Rwi.setTag(Integer.valueOf(paramInt));
          paramViewGroup.RwH.settouchEnable(false);
          paramViewGroup.RwH.setBackgroundResource(0);
          paramViewGroup.RwH.setDescendantFocusability(131072);
          paramViewGroup.RwH.setClickable(false);
          paramViewGroup.Rwu.settouchEnable(true);
          paramViewGroup.Rwu.setClickable(true);
          paramViewGroup.RwH.setOnClickListener(null);
          if ((i >= this.Rap) || (i == -1))
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
            ap.bG(((SnsInfo)localObject1).getLocalPrivate(), this.hHq);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.Ran.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.Ran.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject2 = (SnsInfo)getItem(i);
            localObject1 = ((SnsInfo)localObject2).getTimeLine();
            if (((this.hHq) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject2).getHead() != j))
            {
              if (bd(paramInt, ((SnsInfo)localObject2).field_snsId))
              {
                l = ((SnsInfo)localObject2).getCreateTime();
                a(paramViewGroup.Rwg, paramViewGroup.Rwh, l);
              }
              localObject3 = a(i, ((SnsInfo)localObject2).getHead(), new PInt());
              if (!Util.isNullOrNil((String)localObject3))
              {
                paramViewGroup.Rwl.setText((CharSequence)localObject3);
                paramViewGroup.Rwl.setVisibility(0);
              }
              paramViewGroup.RaF.setVisibility(0);
            }
            c(paramViewGroup.Rwi, j, ((SnsInfo)localObject2).getHead());
            if ((this.RvW != 0L) && (((SnsInfo)localObject2).field_snsId == this.RvW))
            {
              paramViewGroup.Rwm.setVisibility(0);
              paramViewGroup.Rwj.setVisibility(0);
              localObject3 = new br(this.RvM.tag);
              ((br)localObject3).time = ((SnsInfo)localObject2).field_createTime;
              paramViewGroup.Rwu.setVisibility(0);
              al.hgy().a(((TimeLineObject)localObject1).ContentObj.Zpr, paramViewGroup.Rwu, this.hHU.hashCode(), g.a.QrR, (br)localObject3);
              if (ap.bG(((SnsInfo)localObject2).getLocalPrivate(), this.hHq))
              {
                paramViewGroup.RwE.setVisibility(0);
                paramViewGroup.RwE.setBackgroundResource(b.e.personactivity_keyphoto_icon);
                localObject3 = this.RoL.JE(((SnsInfo)localObject2).getUserName());
                if (localObject3 != null) {
                  ((d)localObject3).aSV();
                }
              }
              localObject3 = (SnsInfo)getItem(i);
              localObject4 = ((SnsInfo)localObject3).getTimeLine().ContentDesc;
              if ((localObject4 != null) && (!((String)localObject4).equals("")))
              {
                paramViewGroup.RwD.setVisibility(0);
                paramViewGroup.Rwy.setVisibility(0);
                paramViewGroup.Rwy.aZ(p.b(this.hHU, (CharSequence)localObject4, paramViewGroup.Rwy.getTextSize()));
              }
              paramViewGroup.RwH.setDescendantFocusability(393216);
              paramViewGroup.RwH.setClickable(true);
              paramViewGroup.Rwu.setClickable(false);
              paramViewGroup.Rwu.settouchEnable(false);
              paramViewGroup.RwH.setOnClickListener(this.RvO.RwK);
              paramViewGroup.RwH.settouchEnable(true);
              i = ((SnsInfo)localObject2).localid;
              localObject2 = new bk.g.a();
              ((bk.g.a)localObject2).icg = i;
              if (this.RvN.get(Integer.valueOf(paramInt)) == null) {
                break label3056;
              }
            }
            label3056:
            for (((bk.g.a)localObject2).position = ((Integer)this.RvN.get(Integer.valueOf(paramInt))).intValue();; ((bk.g.a)localObject2).position = 0)
            {
              paramViewGroup.RwH.setTag(localObject2);
              paramView.setDrawingCacheEnabled(false);
              com.tencent.mm.plugin.sns.statistics.j.QFS.Q((SnsInfo)localObject3);
              paramViewGroup.Rwy.setImportantForAccessibility(2);
              a(paramViewGroup.RaE, paramViewGroup.RwH, jK(paramViewGroup.Rwh), ((TimeLineObject)localObject1).ContentDesc + "," + this.hHU.getString(b.j.contains_sight_desc));
              AppMethodBeat.o(99038);
              return paramView;
              paramViewGroup.Rwm.setVisibility(8);
              break;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
              {
                paramViewGroup = new e();
                paramView = af.mU(this.hHU).inflate(b.g.sns_photo_user_photo, null);
                paramViewGroup.Rwh = ((TextView)paramView.findViewById(b.f.sns_day));
                paramViewGroup.Rwg = ((TextView)paramView.findViewById(b.f.sns_month));
                paramViewGroup.Rwi = ((TextView)paramView.findViewById(b.f.sns_year));
                paramViewGroup.Rwu = ((MaskImageView)paramView.findViewById(b.f.img1));
                paramViewGroup.Rwv = ((QFadeImageView)paramView.findViewById(b.f.take_photo));
                paramViewGroup.Rww = ((MaskImageView)paramView.findViewById(b.f.img2));
                paramViewGroup.Rwx = ((MaskImageView)paramView.findViewById(b.f.img3));
                paramViewGroup.Rwy = ((MMNeat7extView)paramView.findViewById(b.f.desc));
                paramViewGroup.Rwz = ((TextView)paramView.findViewById(b.f.with_username1));
                paramViewGroup.RwA = ((TextView)paramView.findViewById(b.f.with_username2));
                paramViewGroup.RwB = ((TextView)paramView.findViewById(b.f.with_username3));
                paramViewGroup.RwC = ((TextView)paramView.findViewById(b.f.img_count));
                paramViewGroup.RwD = paramView.findViewById(b.f.desc_count);
                paramViewGroup.Rwl = ((TextView)paramView.findViewById(b.f.address));
                paramViewGroup.Rwj = ((LinearLayout)paramView.findViewById(b.f.line_add_item));
                paramViewGroup.Rwk = ((ImageView)paramView.findViewById(b.f.lock_line_add_item_b));
                paramViewGroup.RaE = ((LinearLayout)paramView.findViewById(b.f.listener_keeper));
                paramViewGroup.RaF = paramView.findViewById(b.f.line_add);
                paramViewGroup.Rwv.setOnClickListener(this.RvO.RwJ);
                paramViewGroup.Rwu.setOnClickListener(this.RvO.RwJ);
                paramViewGroup.RwE = ((TextView)paramView.findViewById(b.f.warn1));
                paramViewGroup.RwF = ((TextView)paramView.findViewById(b.f.warn2));
                paramViewGroup.RwG = ((TextView)paramView.findViewById(b.f.warn3));
                paramViewGroup.JfT = ((TextView)paramView.findViewById(b.f.tv1));
                paramViewGroup.JfU = ((TextView)paramView.findViewById(b.f.tv2));
                paramViewGroup.JfV = ((TextView)paramView.findViewById(b.f.tv3));
                paramViewGroup.RwH = ((MaskLinearLayout)paramView.findViewById(b.f.sns_line_blackground));
                paramViewGroup.RwH.b(paramViewGroup.Rwu);
                paramViewGroup.Rwm = ((LinearLayout)paramView.findViewById(b.f.friends_limit));
                paramViewGroup.Rwn = ((TextView)paramView.findViewById(b.f.sns_no_see_tip_reset_tips_btn));
                paramViewGroup.Rwn.setOnClickListener(new bk.2(this));
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                al.hgy().jq(paramViewGroup.Rwu);
                al.hgy().jq(paramViewGroup.Rww);
                al.hgy().jq(paramViewGroup.Rwx);
                i = -1;
                if (this.Ram.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.Rwi.setTag(Integer.valueOf(paramInt));
                paramViewGroup.RwH.settouchEnable(false);
                paramViewGroup.RwH.setBackgroundResource(0);
                paramViewGroup.RwH.setDescendantFocusability(131072);
                paramViewGroup.RwH.setClickable(false);
                paramViewGroup.Rwu.settouchEnable(true);
                paramViewGroup.Rwu.setClickable(true);
                paramViewGroup.RwH.setOnClickListener(null);
                if ((i < this.Rap) && (i != -1)) {
                  break;
                }
                paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                paramView.setVisibility(8);
                AppMethodBeat.o(99038);
                return paramView;
                paramViewGroup = (e)paramView.getTag();
              }
              if (i - 1 < 0) {
                break label5797;
              }
              localObject1 = (SnsInfo)getItem(i - 1);
              j = ((SnsInfo)localObject1).getHead();
              ap.bG(((SnsInfo)localObject1).getLocalPrivate(), this.hHq);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject1 = (SnsInfo)getItem(i);
              ((SnsInfo)localObject1).getTimeLine();
              if (((this.hHq) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject1).getHead() != j))
              {
                if (bd(paramInt, ((SnsInfo)localObject1).field_snsId))
                {
                  l = ((SnsInfo)localObject1).getCreateTime();
                  a(paramViewGroup.Rwg, paramViewGroup.Rwh, l);
                }
                localObject2 = a(i, ((SnsInfo)localObject1).getHead(), new PInt());
                if (!Util.isNullOrNil((String)localObject2))
                {
                  paramViewGroup.Rwl.setText((CharSequence)localObject2);
                  paramViewGroup.Rwl.setVisibility(0);
                }
                paramViewGroup.RaF.setVisibility(0);
              }
              c(paramViewGroup.Rwi, j, ((SnsInfo)localObject1).getHead());
              if ((this.RvW != 0L) && (((SnsInfo)localObject1).field_snsId == this.RvW))
              {
                paramViewGroup.Rwm.setVisibility(0);
                paramViewGroup.Rwj.setVisibility(0);
                if ((!this.hHq) || (paramInt != 0)) {
                  break label4170;
                }
                paramViewGroup.Rwv.setVisibility(0);
                paramViewGroup.Rwv.setContentDescription(this.hHU.getString(b.j.sns_take_photo));
                paramViewGroup.Rwu.setVisibility(8);
                localObject2 = paramViewGroup.Rwy;
                if (this.Rao != 1) {
                  break label4163;
                }
              }
              label4163:
              for (localObject1 = this.hHU.getString(b.j.sns_user_start);; localObject1 = "")
              {
                ((MMNeat7extView)localObject2).aZ((CharSequence)localObject1);
                paramViewGroup.Rwy.setVisibility(0);
                paramViewGroup.RwD.setVisibility(0);
                paramViewGroup.RwC.setVisibility(8);
                al.hgy().c(paramViewGroup.Rwv, b.c.sns_user_take_photo_bg, b.e.sns_takephoto_icon, this.hHU.hashCode());
                localObject1 = new bk.g.a();
                ((bk.g.a)localObject1).icg = -1;
                ((bk.g.a)localObject1).position = -1;
                paramViewGroup.Rwv.setTag(localObject1);
                AppMethodBeat.o(99038);
                return paramView;
                paramViewGroup.Rwm.setVisibility(8);
                break;
              }
              label4170:
              a(i, paramViewGroup.Rwu, paramViewGroup.Rwz, paramViewGroup.RwC, paramViewGroup.RwE, paramViewGroup.JfT, 1, paramViewGroup, paramInt);
              localObject2 = (SnsInfo)getItem(i);
              if ((!Util.isNullOrNil(((SnsInfo)localObject2).getTimeLine().ContentDesc)) && (((SnsInfo)localObject2).getTypeFlag() == 1))
              {
                paramViewGroup.RwH.setDescendantFocusability(393216);
                paramViewGroup.RwH.setClickable(true);
                paramViewGroup.Rwu.setClickable(false);
                paramViewGroup.Rwu.settouchEnable(false);
                paramViewGroup.RwH.setOnClickListener(this.RvO.RwJ);
                paramViewGroup.RwH.settouchEnable(true);
                i = ((SnsInfo)localObject1).localid;
                localObject1 = new bk.g.a();
                ((bk.g.a)localObject1).icg = i;
                if (this.RvN.get(Integer.valueOf(paramInt)) == null) {
                  break label4382;
                }
              }
              for (((bk.g.a)localObject1).position = ((Integer)this.RvN.get(Integer.valueOf(paramInt))).intValue();; ((bk.g.a)localObject1).position = 0)
              {
                paramViewGroup.RwH.setTag(localObject1);
                com.tencent.mm.plugin.sns.statistics.j.QFS.Q((SnsInfo)localObject2);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 4)
              {
                paramView = x(paramInt, paramView);
                AppMethodBeat.o(99038);
                return paramView;
              }
              if (i == 5) {
                if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof c)))
                {
                  paramViewGroup = new c();
                  localObject1 = af.mU(this.hHU).inflate(b.g.sns_photo_user_normal, null);
                  paramViewGroup.Rwf = ((View)localObject1).findViewById(b.f.content_ll);
                  paramViewGroup.Rwh = ((TextView)((View)localObject1).findViewById(b.f.sns_day));
                  paramViewGroup.Rwg = ((TextView)((View)localObject1).findViewById(b.f.sns_month));
                  paramViewGroup.Rwi = ((TextView)((View)localObject1).findViewById(b.f.sns_year));
                  paramViewGroup.Rwl = ((TextView)((View)localObject1).findViewById(b.f.address));
                  paramViewGroup.RaF = ((View)localObject1).findViewById(b.f.line_add);
                  paramViewGroup.Rwl = ((TextView)((View)localObject1).findViewById(b.f.address));
                  paramViewGroup.Rwj = ((LinearLayout)((View)localObject1).findViewById(b.f.line_add_item));
                  paramViewGroup.Rwk = ((ImageView)((View)localObject1).findViewById(b.f.lock_line_add_item_b));
                  paramViewGroup.RaE = ((LinearLayout)((View)localObject1).findViewById(b.f.listener_keeper));
                  paramViewGroup.Ilj = ((MMNeat7extView)((View)localObject1).findViewById(b.f.desc_tv));
                  paramViewGroup.Rws = ((TagImageView)((View)localObject1).findViewById(b.f.image_left));
                  paramViewGroup.DOt = ((ImageView)((View)localObject1).findViewById(b.f.state));
                  paramViewGroup.titleTv = ((TextView)((View)localObject1).findViewById(b.f.titletext));
                  paramViewGroup.Rwq = ((TextView)((View)localObject1).findViewById(b.f.righttext));
                  paramViewGroup.Rwf.setOnClickListener(this.RvO.RwI);
                  paramViewGroup.Rwr = ((View)localObject1).findViewById(b.f.media_content_rl);
                  paramViewGroup.Rwt = ((TextView)((View)localObject1).findViewById(b.f.content_left));
                  paramViewGroup.Rwm = ((LinearLayout)((View)localObject1).findViewById(b.f.friends_limit));
                  paramViewGroup.Rwn = ((TextView)((View)localObject1).findViewById(b.f.sns_no_see_tip_reset_tips_btn));
                  paramViewGroup.Rwn.setOnClickListener(new bk.11(this));
                  ((View)localObject1).setTag(paramViewGroup);
                  t.c(paramViewGroup.Rws, this.hHU);
                  paramViewGroup.Rwi.setTag(Integer.valueOf(paramInt));
                  if (this.Ram.get(Integer.valueOf(paramInt)) == null) {
                    break label5791;
                  }
                }
              }
              for (i = ((Integer)this.Ram.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                paramViewGroup.init();
                if ((i >= this.Rap) || (i == -1))
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
                  ap.bG(paramView.getLocalPrivate(), this.hHq);
                }
                for (;;)
                {
                  ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  ((View)localObject1).setVisibility(0);
                  localObject3 = (SnsInfo)getItem(i);
                  localObject2 = ((SnsInfo)localObject3).getTimeLine();
                  if (((this.hHq) && (paramInt == 0)) || (j == -1) || (((SnsInfo)localObject3).getHead() != j))
                  {
                    if (bd(paramInt, ((SnsInfo)localObject3).field_snsId))
                    {
                      l = ((SnsInfo)localObject3).getCreateTime();
                      a(paramViewGroup.Rwg, paramViewGroup.Rwh, l);
                    }
                    paramView = a(i, ((SnsInfo)localObject3).getHead(), new PInt());
                    if (!Util.isNullOrNil(paramView))
                    {
                      paramViewGroup.Rwl.setText(paramView);
                      paramViewGroup.Rwl.setVisibility(0);
                    }
                    paramViewGroup.RaF.setVisibility(0);
                  }
                  c(paramViewGroup.Rwi, j, ((SnsInfo)localObject3).getHead());
                  if ((this.RvW != 0L) && (((SnsInfo)localObject3).field_snsId == this.RvW))
                  {
                    paramViewGroup.Rwm.setVisibility(0);
                    paramView = new bk.g.a();
                    paramView.icg = ((SnsInfo)localObject3).localid;
                    if (this.RvN.get(Integer.valueOf(paramInt)) == null) {
                      break label5338;
                    }
                    paramView.position = ((Integer)this.RvN.get(Integer.valueOf(paramInt))).intValue();
                    label5192:
                    paramViewGroup.Rwf.setTag(paramView);
                    if (Util.isNullOrNil(((TimeLineObject)localObject2).ContentDesc)) {
                      break label5346;
                    }
                    paramViewGroup.Ilj.setVisibility(0);
                    paramViewGroup.Ilj.aZ(p.b(this.hHU, ((TimeLineObject)localObject2).ContentDesc, paramViewGroup.Ilj.getTextSize()));
                  }
                  for (;;)
                  {
                    paramViewGroup.Rwj.setVisibility(0);
                    paramViewGroup.Ilj.getWrappedTextView().setSingleLine(true);
                    paramViewGroup.Rwr.setVisibility(0);
                    localObject4 = new br(this.RvM.tag);
                    ((br)localObject4).time = ((SnsInfo)localObject3).field_createTime;
                    if (((TimeLineObject)localObject2).ContentObj.Zpw != null) {
                      break label5358;
                    }
                    Log.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                    AppMethodBeat.o(99038);
                    return localObject1;
                    paramViewGroup.Rwm.setVisibility(8);
                    break;
                    label5338:
                    paramView.position = 0;
                    break label5192;
                    label5346:
                    paramViewGroup.Ilj.setVisibility(8);
                  }
                  label5358:
                  paramViewGroup.titleTv.setTextColor(this.hHU.getResources().getColor(b.c.normal_text_color));
                  paramView = "";
                  if (((TimeLineObject)localObject2).ContentObj.Zpw != null)
                  {
                    paramViewGroup.Rws.setVisibility(0);
                    paramView = ((TimeLineObject)localObject2).ContentObj.Zpw.title;
                    dmz localdmz = new dmz();
                    localdmz.Url = ((TimeLineObject)localObject2).ContentObj.Zpw.nUM;
                    localdmz.aaTl = ((TimeLineObject)localObject2).ContentObj.Zpw.nUM;
                    localdmz.vhJ = 2;
                    localdmz.aaTm = 1;
                    localdmz.aaTn = new dnb();
                    localdmz.aazR = 1;
                    localdmz.aaTn.aaUb = ((TimeLineObject)localObject2).ContentObj.Zpw.width;
                    localdmz.aaTn.aaUc = ((TimeLineObject)localObject2).ContentObj.Zpw.height;
                    localdmz.Id = ((SnsInfo)localObject3).getSnsId();
                    al.hgy().a(localdmz, paramViewGroup.Rws, this.hHU.hashCode(), g.a.QrR, (br)localObject4);
                  }
                  localObject2 = paramView;
                  if (paramView.length() > 40) {
                    localObject2 = paramView.substring(0, 40) + "...";
                  }
                  if (paramViewGroup.Rws != null) {
                    paramViewGroup.Rws.setOnClickListener(null);
                  }
                  paramViewGroup.DOt.setVisibility(0);
                  paramViewGroup.DOt.setImageDrawable(bb.m(paramViewGroup.DOt.getContext(), b.i.icons_outlined_video_call, -1));
                  paramViewGroup.Rwq.setVisibility(8);
                  if (!Util.isNullOrNil((String)localObject2)) {
                    if (paramViewGroup.Rwq.getVisibility() == 8)
                    {
                      paramViewGroup.titleTv.setMaxLines(2);
                      paramViewGroup.titleTv.setText(p.b(this.hHU, (CharSequence)localObject2));
                      paramViewGroup.titleTv.setVisibility(0);
                    }
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.sns.statistics.j.QFS.Q((SnsInfo)localObject3);
                    ((View)localObject1).setDrawingCacheEnabled(false);
                    AppMethodBeat.o(99038);
                    return localObject1;
                    paramViewGroup.titleTv.setMaxLines(1);
                    break;
                    paramViewGroup.titleTv.setVisibility(8);
                  }
                  if (i == 6)
                  {
                    paramView = v(paramInt, paramView);
                    AppMethodBeat.o(99038);
                    return paramView;
                  }
                  paramView = w(paramInt, paramView);
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
      label5821:
      k = -1;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void hmc()
  {
    AppMethodBeat.i(99048);
    Ek(true);
    notifyDataSetChanged();
    AppMethodBeat.o(99048);
  }
  
  public final void hpk()
  {
    this.RvX = true;
    if (this.isSearchMode) {
      this.RvR.RwR = true;
    }
  }
  
  public final void hpl()
  {
    AppMethodBeat.i(99049);
    Log.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((SnsInfo)this.list.get(this.list.size() - 1)).field_snsId)
    {
      vs(l);
      AppMethodBeat.o(99049);
      return;
    }
  }
  
  public final ArrayList<bzi> lH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99052);
    ArrayList localArrayList = new ArrayList();
    this.Rwa = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      SnsInfo localSnsInfo = (SnsInfo)this.list.get(paramInt2);
      int j = localSnsInfo.localid;
      if ((localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null) && (localSnsInfo.getTimeLine().ContentObj.Zpr.size() != 0) && ((localSnsInfo.getTimeLine().ContentObj.Zpq == 1) || (localSnsInfo.getTimeLine().ContentObj.Zpq == 15)))
      {
        if (j == paramInt1) {
          this.Rwa = localArrayList.size();
        }
        Iterator localIterator = localSnsInfo.getTimeLine().ContentObj.Zpr.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          dmz localdmz = (dmz)localIterator.next();
          bzi localbzi = new bzi();
          localbzi.ibT = localdmz;
          localbzi.parentId = com.tencent.mm.plugin.sns.storage.ai.bF("sns_table_", j);
          localbzi.createTime = localSnsInfo.getCreateTime();
          localbzi.aaiz = i;
          localArrayList.add(localbzi);
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
  
  public final void vr(long paramLong)
  {
    if (0L != this.RvV) {
      return;
    }
    this.RvV = paramLong;
    this.RvW = 0L;
  }
  
  class a
  {
    LinearLayout RaE;
    View RaF;
    View Rwf;
    TextView Rwg;
    TextView Rwh;
    TextView Rwi;
    LinearLayout Rwj;
    ImageView Rwk;
    TextView Rwl;
    LinearLayout Rwm;
    TextView Rwn;
    
    a() {}
    
    public void init()
    {
      AppMethodBeat.i(99026);
      this.Rwg.setVisibility(8);
      this.Rwh.setVisibility(8);
      this.Rwi.setVisibility(8);
      this.Rwj.setVisibility(4);
      this.Rwk.setVisibility(4);
      this.RaF.setVisibility(8);
      this.Rwl.setVisibility(8);
      this.Rwm.setVisibility(8);
      AppMethodBeat.o(99026);
    }
  }
  
  final class b
    extends bk.a
  {
    MMNeat7extView Ilj;
    MMRoundCornerImageView Rwo;
    WeImageView Rwp;
    TextView Rwq;
    View Rwr;
    TextView titleTv;
    
    b()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(308231);
      super.init();
      this.Ilj.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.Rwq.setVisibility(8);
      AppMethodBeat.o(308231);
    }
  }
  
  final class c
    extends bk.a
  {
    ImageView DOt;
    MMNeat7extView Ilj;
    TextView Rwq;
    View Rwr;
    TagImageView Rws;
    TextView Rwt;
    TextView titleTv;
    
    c()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99027);
      super.init();
      this.Ilj.setVisibility(8);
      this.Rws.setVisibility(8);
      if (this.Rwt != null) {
        this.Rwt.setVisibility(8);
      }
      this.DOt.setVisibility(8);
      this.titleTv.setVisibility(8);
      this.Rwq.setVisibility(8);
      AppMethodBeat.o(99027);
    }
  }
  
  public static abstract interface d
  {
    public abstract void hpn();
  }
  
  final class e
    extends bk.a
  {
    TextView JfT;
    TextView JfU;
    TextView JfV;
    TextView RwA;
    TextView RwB;
    TextView RwC;
    View RwD;
    TextView RwE;
    TextView RwF;
    TextView RwG;
    MaskLinearLayout RwH;
    MaskImageView Rwu;
    QFadeImageView Rwv;
    QFadeImageView Rww;
    QFadeImageView Rwx;
    MMNeat7extView Rwy;
    TextView Rwz;
    
    e()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99028);
      super.init();
      this.Rwu.setVisibility(8);
      this.Rww.setVisibility(8);
      this.Rwx.setVisibility(8);
      this.Rwy.setVisibility(8);
      this.Rwz.setVisibility(8);
      this.RwA.setVisibility(8);
      this.RwB.setVisibility(8);
      this.RwC.setVisibility(8);
      this.RwD.setVisibility(8);
      this.Rwv.setVisibility(8);
      this.RwE.setVisibility(8);
      this.RwF.setVisibility(8);
      this.RwG.setVisibility(8);
      this.JfT.setVisibility(8);
      this.JfU.setVisibility(8);
      this.JfV.setVisibility(8);
      if (com.tencent.mm.cd.a.getScaleSize(bk.f(bk.this)) > 1.0F) {
        this.Rwy.setMaxLines(2);
      }
      AppMethodBeat.o(99028);
    }
  }
  
  final class f
    extends bk.a
  {
    View RwD;
    TextView RwE;
    MaskLinearLayout RwH;
    MaskImageView Rwu;
    MMNeat7extView Rwy;
    
    f()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(99029);
      super.init();
      this.Rwu.setVisibility(8);
      this.Rwy.setVisibility(8);
      this.RwE.setVisibility(8);
      this.RwD.setVisibility(8);
      if (com.tencent.mm.cd.a.getScaleSize(bk.f(bk.this)) > 1.0F) {
        this.Rwy.setMaxLines(2);
      }
      AppMethodBeat.o(99029);
    }
  }
  
  static abstract class g
  {
    View.OnClickListener Rav = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99030);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99030);
          return;
        }
        bk.g.this.RwM = ((bk.g.a)paramAnonymousView.getTag());
        int i = bk.g.this.RwM.icg;
        int j = bk.g.this.RwM.position;
        bk.g.this.lI(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99030);
      }
    };
    View.OnClickListener Raw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99031);
          return;
        }
        bk.g.this.RwM = ((bk.g.a)paramAnonymousView.getTag());
        int i = bk.g.this.RwM.icg;
        int j = bk.g.this.RwM.position;
        bk.g.this.lI(i, j + 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99031);
      }
    };
    View.OnClickListener Rax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99032);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99032);
          return;
        }
        bk.g.this.RwM = ((bk.g.a)paramAnonymousView.getTag());
        int i = bk.g.this.RwM.icg;
        int j = bk.g.this.RwM.position;
        bk.g.this.lI(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99032);
      }
    };
    View.OnClickListener RwI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99033);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "sign click");
        bk.g.this.RwM = ((bk.g.a)paramAnonymousView.getTag());
        int i = bk.g.this.RwM.icg;
        int j = bk.g.this.RwM.position;
        bk.g.this.lJ(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99033);
      }
    };
    View.OnClickListener RwJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99034);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99034);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "sign click");
        bk.g.this.RwM = ((bk.g.a)paramAnonymousView.getTag());
        int i = bk.g.this.RwM.icg;
        bk.g.this.amg(i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99034);
      }
    };
    View.OnClickListener RwK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99035);
          return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "snssight click");
        bk.g.this.RwM = ((bk.g.a)paramAnonymousView.getTag());
        int i = bk.g.this.RwM.icg;
        int j = bk.g.this.RwM.position;
        bk.g.this.lJ(i, j + 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99035);
      }
    };
    View.OnLongClickListener RwL = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (paramAnonymousView.getTag() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(99036);
          return true;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
        bk.g.this.RwM = ((bk.g.a)paramAnonymousView.getTag());
        int i = bk.g.this.RwM.icg;
        int j = bk.g.this.RwM.position;
        bk.g.this.lK(i, j);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(99036);
        return true;
      }
    };
    public a RwM = new a();
    
    public abstract void amg(int paramInt);
    
    public abstract void lI(int paramInt1, int paramInt2);
    
    public abstract void lJ(int paramInt1, int paramInt2);
    
    public abstract void lK(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public int icg;
      public int position;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bk
 * JD-Core Version:    0.7.0.1
 */