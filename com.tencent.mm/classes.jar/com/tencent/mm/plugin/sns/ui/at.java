package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.g.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class at
  extends BaseAdapter
{
  private String country;
  boolean ctJ;
  private Activity cup;
  List<n> list;
  String meP;
  private String nZZ;
  Map<Integer, Integer> rEd;
  Map<Integer, Integer> rEe;
  int rEf;
  int rEg;
  String rKW;
  private bd rOH;
  int rUA;
  private long rUB;
  private long rUC;
  int rUD;
  protected View.OnClickListener rUE;
  private az rUt;
  Map<Integer, Integer> rUu;
  private at.f rUv;
  boolean rUw;
  au rUx;
  private at.c rUy;
  int rUz;
  private String userName;
  
  public at(Activity paramActivity, at.f paramf, String paramString, at.c paramc)
  {
    AppMethodBeat.i(39218);
    this.userName = "";
    this.list = new ArrayList();
    this.rEd = new HashMap();
    this.rEe = new HashMap();
    this.rUu = new HashMap();
    this.rEf = 0;
    this.rEg = 0;
    this.ctJ = false;
    this.rKW = "";
    this.rUw = false;
    this.meP = "";
    this.rOH = null;
    this.nZZ = "";
    this.rUz = 2147483647;
    this.rUA = 0;
    this.rUB = 0L;
    this.rUC = 0L;
    this.rUD = 0;
    this.rUE = new at.6(this);
    this.userName = paramString;
    this.cup = paramActivity;
    this.rUv = paramf;
    this.rUy = paramc;
    this.rOH = ag.coT();
    paramf = com.tencent.mm.sdk.platformtools.aa.f(this.cup.getSharedPreferences(ah.dsP(), 0));
    ab.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(paramf)));
    paramActivity = paramf;
    if (!paramf.equals("zh_CN"))
    {
      paramActivity = paramf;
      if (!paramf.equals("en"))
      {
        if (!paramf.equals("zh_TW")) {
          break label380;
        }
        paramActivity = paramf;
      }
    }
    this.nZZ = paramActivity;
    this.country = com.tencent.mm.sdk.platformtools.aa.f(this.cup.getSharedPreferences(ah.dsP(), 0));
    com.tencent.mm.kernel.g.RM();
    paramActivity = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, null);
    if (this.userName.equals(paramActivity)) {
      this.ctJ = true;
    }
    ab.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.ctJ) {
      this.rUt = az.dxD();
    }
    for (;;)
    {
      this.rUx = new au(new at.1(this, paramc), paramString, this.ctJ);
      mf(0L);
      lE(false);
      AppMethodBeat.o(39218);
      return;
      label380:
      if (paramf.equals("zh_HK"))
      {
        paramActivity = "zh_TW";
        break;
      }
      paramActivity = "en";
      break;
      com.tencent.mm.kernel.g.RM();
      paramActivity = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
      if ((paramActivity != null) && (com.tencent.mm.n.a.je(paramActivity.field_type))) {
        this.rUt = az.dxC();
      } else {
        this.rUt = az.dxE();
      }
    }
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, at.d paramd, int paramInt3)
  {
    AppMethodBeat.i(39224);
    n localn = (n)getItem(paramInt1);
    TimeLineObject localTimeLineObject = localn.csh();
    SnsObject localSnsObject = ak.q(localn);
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
    if ((this.ctJ) && (localSnsObject != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localn.field_userName)))
    {
      paramTextView3.setBackgroundResource(2130839936);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (ak.ad(localn.field_localPrivate, this.ctJ))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2130839930);
        localObject = this.rOH.arw(localn.field_userName);
        if (localObject != null) {
          break label571;
        }
        localObject = "";
        if ((!((String)localObject).equals("")) && (!this.userName.equals(localn.field_userName)))
        {
          paramTextView1.setVisibility(0);
          paramTextView1.setText((CharSequence)localObject);
        }
      }
      label235:
      paramInt1 = localn.rCV;
      paramTextView1 = new at.f.a();
      paramTextView1.cIp = paramInt1;
      if (this.rUu.get(Integer.valueOf(paramInt3)) == null) {
        break label689;
      }
      paramTextView1.position = ((Integer)this.rUu.get(Integer.valueOf(paramInt3))).intValue();
      label295:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new az(this.rUt.tag);
      paramTextView1.oLs = localn.field_createTime;
      if (localTimeLineObject.xTS.wNZ != 1) {
        break label697;
      }
      paramQFadeImageView.setVisibility(0);
      ag.cpc().a(localTimeLineObject.xTS.wOa, paramQFadeImageView, this.cup.hashCode(), g.a.reb, paramTextView1);
      label367:
      if ((localn.coN()) && (localn.csJ()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(2130839928);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localTimeLineObject.xTS.wOa == null) || (localTimeLineObject.xTS.wOa.size() <= 1)) {
          break label820;
        }
        paramd.rVb.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localTimeLineObject.xTS.wOa.size();
        paramTextView2.setText(this.cup.getResources().getQuantityString(2131361820, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localTimeLineObject.xTP;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        paramd.rVb.setVisibility(0);
        paramd.ruR.setVisibility(0);
        paramd.ruR.setText(String.valueOf(paramQFadeImageView));
        paramd.ruR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.cup, paramQFadeImageView, paramd.ruR.getTextSize()));
      }
      AppMethodBeat.o(39224);
      return;
      label571:
      localObject = ((com.tencent.mm.n.a)localObject).Of();
      break;
      if (!ak.ad(localn.field_localPrivate, this.ctJ)) {
        break label235;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(2130839930);
      localObject = this.rOH.arw(localn.field_userName);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((com.tencent.mm.n.a)localObject).Of())
      {
        if ((localObject == null) || (((String)localObject).equals("")) || (this.userName.equals(localn.field_userName))) {
          break label687;
        }
        paramTextView1.setVisibility(0);
        paramTextView1.setText((CharSequence)localObject);
        break;
      }
      label687:
      break label235;
      label689:
      paramTextView1.position = 0;
      break label295;
      label697:
      if (localTimeLineObject.xTS.wNZ == 2)
      {
        paramTextView4.setText(bo.bf(localTimeLineObject.xTS.Desc, ""));
        paramTextView4.setVisibility(0);
        break label367;
      }
      if (localTimeLineObject.xTS.wNZ != 21) {
        break label367;
      }
      localn.csz();
      boolean bool = true;
      if (this.ctJ) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        ag.cpc().a(localTimeLineObject.xTS.wOa, paramQFadeImageView, this.cup.hashCode(), g.a.reb, paramTextView1, bool);
        break;
        if (com.tencent.mm.plugin.sns.lucky.a.m.a(localn, localSnsObject)) {
          bool = false;
        }
      }
      label820:
      paramTextView2.setVisibility(8);
    }
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39221);
    int i = paramInt1 / 10000;
    paramInt2 /= 10000;
    ab.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    if ((i == 0) || (paramInt2 != i))
    {
      dQ(paramTextView);
      paramTextView.setText(String.format(this.cup.getResources().getString(2131304040), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
    }
    AppMethodBeat.o(39221);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    AppMethodBeat.i(39220);
    Object localObject = this.cup;
    if (!this.nZZ.equals("en")) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = (String)ax.a((Context)localObject, 1000L * paramLong, bool);
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
      AppMethodBeat.o(39220);
      return;
    }
    if (((String)localObject).indexOf("/") > 0)
    {
      localObject = ((String)localObject).split("/");
      if (localObject[1].length() < 2) {
        localObject[1] = ("0" + localObject[1]);
      }
      localObject[0] = ax.x(this.cup, localObject[0], this.nZZ);
      paramTextView1.setText(localObject[0]);
      paramTextView2.setText(localObject[1]);
      paramTextView2.setVisibility(0);
      paramTextView1.setVisibility(0);
      AppMethodBeat.o(39220);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(String.valueOf(localObject));
    AppMethodBeat.o(39220);
  }
  
  protected static boolean aci(String paramString)
  {
    AppMethodBeat.i(39232);
    com.tencent.mm.aw.e locale = com.tencent.mm.aw.a.aiz();
    if ((locale != null) && (com.tencent.mm.aw.a.d(locale)) && (paramString.equals(locale.fKj)) && (com.tencent.mm.aw.a.aiw()))
    {
      AppMethodBeat.o(39232);
      return true;
    }
    AppMethodBeat.o(39232);
    return false;
  }
  
  private void dQ(View paramView)
  {
    AppMethodBeat.i(39222);
    int i = ((Integer)paramView.getTag()).intValue();
    if ((paramView.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if (i == 0)
      {
        localLayoutParams.topMargin = 0;
        paramView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(39222);
        return;
      }
      localLayoutParams.topMargin = this.cup.getResources().getDimensionPixelSize(2131428724);
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(39222);
  }
  
  private void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(39225);
    ab.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.meP);
    if (this.rUx != null) {
      this.rUx.h(this.meP, this.rUw, paramBoolean);
    }
    AppMethodBeat.o(39225);
  }
  
  private void mf(long paramLong)
  {
    AppMethodBeat.i(39229);
    Object localObject = i.lr(ag.cpf().a(paramLong, ag.coV().aaB(this.userName), this.userName, this.ctJ));
    if (this.rKW.equals("")) {}
    for (;;)
    {
      this.meP = ((String)localObject);
      localObject = ag.cpj().abz(this.userName).csy();
      if (((abx)localObject).wSq != 0L) {
        break;
      }
      AppMethodBeat.o(39229);
      return;
      if (((String)localObject).compareTo(this.rKW) >= 0) {
        localObject = this.rKW;
      }
    }
    localObject = i.lr(((abx)localObject).wSq);
    if (this.meP.equals(""))
    {
      this.meP = ((String)localObject);
      AppMethodBeat.o(39229);
      return;
    }
    if (((String)localObject).compareTo(this.meP) > 0) {}
    for (;;)
    {
      this.meP = ((String)localObject);
      AppMethodBeat.o(39229);
      return;
      localObject = this.meP;
    }
  }
  
  public final void ctD()
  {
    AppMethodBeat.i(39227);
    lE(true);
    notifyDataSetChanged();
    AppMethodBeat.o(39227);
  }
  
  public final void cvL()
  {
    AppMethodBeat.i(39228);
    ab.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((n)this.list.get(this.list.size() - 1)).field_snsId)
    {
      mf(l);
      AppMethodBeat.o(39228);
      return;
    }
  }
  
  public final ArrayList<b> fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39231);
    ArrayList localArrayList = new ArrayList();
    this.rUD = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      n localn = (n)this.list.get(paramInt2);
      int j = localn.rCV;
      if ((localn.csh() != null) && (localn.csh().xTS != null) && (localn.csh().xTS.wOa.size() != 0) && ((localn.csh().xTS.wNZ == 1) || (localn.csh().xTS.wNZ == 15)))
      {
        if (j == paramInt1) {
          this.rUD = localArrayList.size();
        }
        Iterator localIterator = localn.csh().xTS.wOa.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          bcs localbcs = (bcs)localIterator.next();
          b localb = new b();
          localb.cIc = localbcs;
          localb.rlJ = v.aF("sns_table_", j);
          localb.fDT = localn.field_createTime;
          localb.rlK = i;
          localArrayList.add(localb);
          i += 1;
        }
      }
      paramInt2 += 1;
    }
    AppMethodBeat.o(39231);
    return localArrayList;
  }
  
  public final int getCount()
  {
    return this.rEf;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(39230);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(39230);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39223);
    if ((this.ctJ) && (paramInt == 0))
    {
      ab.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      AppMethodBeat.o(39223);
      return 0;
    }
    if (this.rEd.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.rEd.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        ab.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i)));
        AppMethodBeat.o(39223);
        return 0;
      }
      n localn = (n)getItem(i);
      if (localn.csh().xTS.wNZ == 1)
      {
        ab.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        AppMethodBeat.o(39223);
        return 0;
      }
      if (localn.csh().xTS.wNZ == 15)
      {
        ab.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        AppMethodBeat.o(39223);
        return 2;
      }
      if (localn.csh().xTS.wNZ == 21)
      {
        AppMethodBeat.o(39223);
        return 3;
      }
      AppMethodBeat.o(39223);
      return 1;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39219);
    int i = getItemViewType(paramInt);
    ab.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(i)));
    Object localObject1;
    int j;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof at.d)))
      {
        paramViewGroup = new at.d(this);
        paramView = w.hM(this.cup).inflate(2130970852, null);
        paramViewGroup.rUJ = ((TextView)paramView.findViewById(2131828184));
        paramViewGroup.rUI = ((TextView)paramView.findViewById(2131828185));
        paramViewGroup.rUK = ((TextView)paramView.findViewById(2131828186));
        paramViewGroup.rUT = ((MaskImageView)paramView.findViewById(2131827913));
        paramViewGroup.rUU = ((QFadeImageView)paramView.findViewById(2131828053));
        paramViewGroup.rUV = ((MaskImageView)paramView.findViewById(2131827914));
        paramViewGroup.rUW = ((MaskImageView)paramView.findViewById(2131827915));
        paramViewGroup.ruR = ((TextView)paramView.findViewById(2131821115));
        paramViewGroup.rUX = ((TextView)paramView.findViewById(2131828054));
        paramViewGroup.rUY = ((TextView)paramView.findViewById(2131828059));
        paramViewGroup.rUZ = ((TextView)paramView.findViewById(2131828062));
        paramViewGroup.rVa = ((TextView)paramView.findViewById(2131828057));
        paramViewGroup.rVb = paramView.findViewById(2131828056);
        paramViewGroup.rUN = ((TextView)paramView.findViewById(2131820735));
        paramViewGroup.rUL = ((LinearLayout)paramView.findViewById(2131828049));
        paramViewGroup.rUM = ((ImageView)paramView.findViewById(2131828050));
        paramViewGroup.rEv = ((LinearLayout)paramView.findViewById(2131827910));
        paramViewGroup.rEw = paramView.findViewById(2131827909);
        paramViewGroup.rUU.setOnClickListener(this.rUv.rEm);
        paramViewGroup.rUT.setOnClickListener(this.rUv.rEm);
        paramViewGroup.rUV.setOnClickListener(this.rUv.rEn);
        paramViewGroup.rUW.setOnClickListener(this.rUv.rEo);
        paramViewGroup.rUT.setOnLongClickListener(this.rUv.rVm);
        paramViewGroup.rUV.setOnLongClickListener(this.rUv.rVm);
        paramViewGroup.rUW.setOnLongClickListener(this.rUv.rVm);
        paramViewGroup.rVc = ((TextView)paramView.findViewById(2131828055));
        paramViewGroup.rVd = ((TextView)paramView.findViewById(2131828060));
        paramViewGroup.rVe = ((TextView)paramView.findViewById(2131828063));
        paramViewGroup.rVf = ((TextView)paramView.findViewById(2131828052));
        paramViewGroup.rVg = ((TextView)paramView.findViewById(2131828058));
        paramViewGroup.rVh = ((TextView)paramView.findViewById(2131828061));
        paramViewGroup.rVi = ((MaskLinearLayout)paramView.findViewById(2131828051));
        paramViewGroup.rVi.b(paramViewGroup.rUT);
        paramViewGroup.rUO = ((LinearLayout)paramView.findViewById(2131828047));
        paramViewGroup.rUP = ((TextView)paramView.findViewById(2131828048));
        paramViewGroup.rUP.setOnClickListener(new at.3(this));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        ag.cpc().dC(paramViewGroup.rUT);
        ag.cpc().dC(paramViewGroup.rUV);
        ag.cpc().dC(paramViewGroup.rUW);
        i = -1;
        if (this.rEd.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.rEd.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.rUK.setTag(Integer.valueOf(paramInt));
        paramViewGroup.rVi.settouchEnable(false);
        paramViewGroup.rVi.setBackgroundResource(0);
        paramViewGroup.rVi.setDescendantFocusability(131072);
        paramViewGroup.rVi.setClickable(false);
        paramViewGroup.rUT.settouchEnable(true);
        paramViewGroup.rUT.setClickable(true);
        paramViewGroup.rUT.setLongClickable(false);
        paramViewGroup.rUV.setLongClickable(false);
        paramViewGroup.rUW.setLongClickable(false);
        paramViewGroup.rVi.setOnClickListener(null);
        paramViewGroup.rVi.setOnLongClickListener(null);
        paramViewGroup.rVi.setLongClickable(false);
        if ((i < this.rEg) && (i != -1)) {
          break;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        AppMethodBeat.o(39219);
        return paramView;
        paramViewGroup = (at.d)paramView.getTag();
      }
      if (i - 1 < 0) {
        break label6097;
      }
      localObject1 = (n)getItem(i - 1);
      j = ((n)localObject1).field_head;
      ak.ad(((n)localObject1).field_localPrivate, this.ctJ);
    }
    label1317:
    label1324:
    label5549:
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.setVisibility(0);
      if (this.rEe.get(Integer.valueOf(paramInt)) != null) {}
      label4536:
      label6073:
      for (int k = ((Integer)this.rEe.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        localObject1 = (n)getItem(i);
        Object localObject2 = ((n)localObject1).csh();
        long l;
        if (((this.ctJ) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
        {
          l = ((n)localObject1).field_createTime;
          a(paramViewGroup.rUI, paramViewGroup.rUJ, l);
          if (((TimeLineObject)localObject2).xTQ != null)
          {
            localObject2 = ((TimeLineObject)localObject2).xTQ.gwR;
            if ((localObject2 != null) && (!((String)localObject2).equals("")))
            {
              paramViewGroup.rUN.setText((CharSequence)localObject2);
              paramViewGroup.rUN.setVisibility(0);
            }
          }
          paramViewGroup.rEw.setVisibility(0);
        }
        a(paramViewGroup.rUK, j, ((n)localObject1).field_head);
        if ((this.rUC != 0L) && (((n)localObject1).field_snsId == this.rUC))
        {
          paramViewGroup.rUO.setVisibility(0);
          paramViewGroup.rUL.setVisibility(0);
          if ((!this.ctJ) || (paramInt != 0)) {
            break label1324;
          }
          paramViewGroup.rUU.setVisibility(0);
          paramViewGroup.rUU.setContentDescription(this.cup.getString(2131304003));
          paramViewGroup.rUT.setVisibility(8);
          localObject2 = paramViewGroup.ruR;
          if (this.rEf != 1) {
            break label1317;
          }
        }
        for (localObject1 = this.cup.getString(2131304041);; localObject1 = "")
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          paramViewGroup.ruR.setVisibility(0);
          paramViewGroup.rVb.setVisibility(0);
          paramViewGroup.rVa.setVisibility(8);
          ag.cpc().a(paramViewGroup.rUU, 2131690515, 2130840426, this.cup.hashCode());
          localObject1 = new at.f.a();
          ((at.f.a)localObject1).cIp = -1;
          ((at.f.a)localObject1).position = -1;
          paramViewGroup.rUU.setTag(localObject1);
          AppMethodBeat.o(39219);
          return paramView;
          if ((this.rUC == 0L) && (this.rUB != 0L) && (((n)localObject1).field_snsId <= this.rUB))
          {
            paramViewGroup.rUO.setVisibility(0);
            this.rUC = ((n)localObject1).field_snsId;
            break;
          }
          paramViewGroup.rUO.setVisibility(8);
          break;
        }
        if (k > 0) {
          a(i, paramViewGroup.rUT, paramViewGroup.rUX, paramViewGroup.rVa, paramViewGroup.rVc, paramViewGroup.rVf, 1, paramViewGroup, paramInt);
        }
        if (k >= 2) {
          a(i + 1, paramViewGroup.rUV, paramViewGroup.rUY, paramViewGroup.rVa, paramViewGroup.rVd, paramViewGroup.rVg, 2, paramViewGroup, paramInt);
        }
        if (k >= 3) {
          a(i + 2, paramViewGroup.rUW, paramViewGroup.rUZ, paramViewGroup.rVa, paramViewGroup.rVe, paramViewGroup.rVh, 3, paramViewGroup, paramInt);
        }
        if (k == 1)
        {
          localObject2 = (n)getItem(i);
          if ((!bo.isNullOrNil(((n)localObject2).csh().xTP)) && (((n)localObject2).field_type == 1))
          {
            paramViewGroup.rVi.setDescendantFocusability(393216);
            paramViewGroup.rVi.setClickable(true);
            paramViewGroup.rUT.setClickable(false);
            paramViewGroup.rUT.settouchEnable(false);
            paramViewGroup.rVi.setOnClickListener(this.rUv.rEm);
            paramViewGroup.rVi.settouchEnable(true);
            i = ((n)localObject1).rCV;
            localObject1 = new at.f.a();
            ((at.f.a)localObject1).cIp = i;
            if (this.rUu.get(Integer.valueOf(paramInt)) == null) {
              break label1643;
            }
          }
        }
        label1643:
        for (((at.f.a)localObject1).position = ((Integer)this.rUu.get(Integer.valueOf(paramInt))).intValue();; ((at.f.a)localObject1).position = 0)
        {
          if ((((n)localObject2).coN()) && (((n)localObject2).csJ())) {
            paramViewGroup.rVi.setOnLongClickListener(this.rUv.rVm);
          }
          paramViewGroup.rVi.setTag(localObject1);
          paramView.setDrawingCacheEnabled(false);
          AppMethodBeat.o(39219);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof at.e)))
          {
            paramViewGroup = new at.e(this);
            paramView = w.hM(this.cup).inflate(2130970865, null);
            paramViewGroup.rUJ = ((TextView)paramView.findViewById(2131828184));
            paramViewGroup.rUI = ((TextView)paramView.findViewById(2131828185));
            paramViewGroup.rUK = ((TextView)paramView.findViewById(2131828186));
            paramViewGroup.rUT = ((MaskImageView)paramView.findViewById(2131827913));
            paramViewGroup.rUN = ((TextView)paramView.findViewById(2131820735));
            paramViewGroup.rUL = ((LinearLayout)paramView.findViewById(2131828049));
            paramViewGroup.rUM = ((ImageView)paramView.findViewById(2131828050));
            paramViewGroup.rEv = ((LinearLayout)paramView.findViewById(2131827910));
            paramViewGroup.rEw = paramView.findViewById(2131827909);
            paramViewGroup.rUT.setOnClickListener(this.rUv.rVl);
            paramViewGroup.rVc = ((TextView)paramView.findViewById(2131828055));
            paramViewGroup.rVi = ((MaskLinearLayout)paramView.findViewById(2131828051));
            paramViewGroup.rVi.b(paramViewGroup.rUT);
            paramViewGroup.ruR = ((TextView)paramView.findViewById(2131821115));
            paramViewGroup.rVb = paramView.findViewById(2131828056);
            paramViewGroup.rUO = ((LinearLayout)paramView.findViewById(2131828047));
            paramViewGroup.rUP = ((TextView)paramView.findViewById(2131828048));
            paramViewGroup.rUP.setOnClickListener(new at.2(this));
            paramView.setTag(paramViewGroup);
            ag.cpc().dC(paramViewGroup.rUT);
            if (this.rEd.get(Integer.valueOf(paramInt)) == null) {
              break label6085;
            }
          }
        }
        label5561:
        label5820:
        label6085:
        for (i = ((Integer)this.rEd.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.rUK.setTag(Integer.valueOf(paramInt));
          paramViewGroup.rVi.settouchEnable(false);
          paramViewGroup.rVi.setBackgroundResource(0);
          paramViewGroup.rVi.setDescendantFocusability(131072);
          paramViewGroup.rVi.setClickable(false);
          paramViewGroup.rUT.settouchEnable(true);
          paramViewGroup.rUT.setClickable(true);
          paramViewGroup.rVi.setOnClickListener(null);
          if ((i >= this.rEg) || (i == -1))
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            paramView.setVisibility(8);
            AppMethodBeat.o(39219);
            return paramView;
            paramViewGroup = (at.e)paramView.getTag();
            break;
          }
          if (i - 1 >= 0)
          {
            localObject1 = (n)getItem(i - 1);
            j = ((n)localObject1).field_head;
            ak.ad(((n)localObject1).field_localPrivate, this.ctJ);
          }
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.rEe.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.rEe.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject1 = (n)getItem(i);
            localObject2 = ((n)localObject1).csh();
            Object localObject3;
            if (((this.ctJ) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
            {
              l = ((n)localObject1).field_createTime;
              a(paramViewGroup.rUI, paramViewGroup.rUJ, l);
              if (((TimeLineObject)localObject2).xTQ != null)
              {
                localObject3 = ((TimeLineObject)localObject2).xTQ.gwR;
                if ((localObject3 != null) && (!((String)localObject3).equals("")))
                {
                  paramViewGroup.rUN.setText((CharSequence)localObject3);
                  paramViewGroup.rUN.setVisibility(0);
                }
              }
              paramViewGroup.rEw.setVisibility(0);
            }
            a(paramViewGroup.rUK, j, ((n)localObject1).field_head);
            if ((this.rUC != 0L) && (((n)localObject1).field_snsId == this.rUC))
            {
              paramViewGroup.rUO.setVisibility(0);
              paramViewGroup.rUL.setVisibility(0);
              localObject3 = new az(this.rUt.tag);
              ((az)localObject3).oLs = ((n)localObject1).field_createTime;
              paramViewGroup.rUT.setVisibility(0);
              ag.cpc().a(((TimeLineObject)localObject2).xTS.wOa, paramViewGroup.rUT, this.cup.hashCode(), g.a.reb, (az)localObject3);
              if (ak.ad(((n)localObject1).field_localPrivate, this.ctJ))
              {
                paramViewGroup.rVc.setVisibility(0);
                paramViewGroup.rVc.setBackgroundResource(2130839930);
                localObject2 = this.rOH.arw(((n)localObject1).field_userName);
                if (localObject2 != null) {
                  ((com.tencent.mm.n.a)localObject2).Of();
                }
              }
              localObject2 = ((n)getItem(i)).csh().xTP;
              if ((localObject2 != null) && (!((String)localObject2).equals("")))
              {
                paramViewGroup.rVb.setVisibility(0);
                paramViewGroup.ruR.setVisibility(0);
                paramViewGroup.ruR.setText(String.valueOf(localObject2));
                paramViewGroup.ruR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.cup, (CharSequence)localObject2, paramViewGroup.ruR.getTextSize()));
              }
              paramViewGroup.rVi.setDescendantFocusability(393216);
              paramViewGroup.rVi.setClickable(true);
              paramViewGroup.rUT.setClickable(false);
              paramViewGroup.rUT.settouchEnable(false);
              paramViewGroup.rVi.setOnClickListener(this.rUv.rVl);
              paramViewGroup.rVi.settouchEnable(true);
              i = ((n)localObject1).rCV;
              localObject1 = new at.f.a();
              ((at.f.a)localObject1).cIp = i;
              if (this.rUu.get(Integer.valueOf(paramInt)) == null) {
                break label2809;
              }
            }
            label2809:
            for (((at.f.a)localObject1).position = ((Integer)this.rUu.get(Integer.valueOf(paramInt))).intValue();; ((at.f.a)localObject1).position = 0)
            {
              paramViewGroup.rVi.setTag(localObject1);
              paramView.setDrawingCacheEnabled(false);
              AppMethodBeat.o(39219);
              return paramView;
              if ((this.rUC == 0L) && (this.rUB != 0L) && (((n)localObject1).field_snsId <= this.rUB))
              {
                paramViewGroup.rUO.setVisibility(0);
                this.rUC = ((n)localObject1).field_snsId;
                break;
              }
              paramViewGroup.rUO.setVisibility(8);
              break;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof at.d)))
              {
                paramViewGroup = new at.d(this);
                paramView = w.hM(this.cup).inflate(2130970852, null);
                paramViewGroup.rUJ = ((TextView)paramView.findViewById(2131828184));
                paramViewGroup.rUI = ((TextView)paramView.findViewById(2131828185));
                paramViewGroup.rUK = ((TextView)paramView.findViewById(2131828186));
                paramViewGroup.rUT = ((MaskImageView)paramView.findViewById(2131827913));
                paramViewGroup.rUU = ((QFadeImageView)paramView.findViewById(2131828053));
                paramViewGroup.rUV = ((MaskImageView)paramView.findViewById(2131827914));
                paramViewGroup.rUW = ((MaskImageView)paramView.findViewById(2131827915));
                paramViewGroup.ruR = ((TextView)paramView.findViewById(2131821115));
                paramViewGroup.rUX = ((TextView)paramView.findViewById(2131828054));
                paramViewGroup.rUY = ((TextView)paramView.findViewById(2131828059));
                paramViewGroup.rUZ = ((TextView)paramView.findViewById(2131828062));
                paramViewGroup.rVa = ((TextView)paramView.findViewById(2131828057));
                paramViewGroup.rVb = paramView.findViewById(2131828056);
                paramViewGroup.rUN = ((TextView)paramView.findViewById(2131820735));
                paramViewGroup.rUL = ((LinearLayout)paramView.findViewById(2131828049));
                paramViewGroup.rUM = ((ImageView)paramView.findViewById(2131828050));
                paramViewGroup.rEv = ((LinearLayout)paramView.findViewById(2131827910));
                paramViewGroup.rEw = paramView.findViewById(2131827909);
                paramViewGroup.rUU.setOnClickListener(this.rUv.rVk);
                paramViewGroup.rUT.setOnClickListener(this.rUv.rVk);
                paramViewGroup.rVc = ((TextView)paramView.findViewById(2131828055));
                paramViewGroup.rVd = ((TextView)paramView.findViewById(2131828060));
                paramViewGroup.rVe = ((TextView)paramView.findViewById(2131828063));
                paramViewGroup.rVf = ((TextView)paramView.findViewById(2131828052));
                paramViewGroup.rVg = ((TextView)paramView.findViewById(2131828058));
                paramViewGroup.rVh = ((TextView)paramView.findViewById(2131828061));
                paramViewGroup.rVi = ((MaskLinearLayout)paramView.findViewById(2131828051));
                paramViewGroup.rVi.b(paramViewGroup.rUT);
                paramViewGroup.rUO = ((LinearLayout)paramView.findViewById(2131828047));
                paramViewGroup.rUP = ((TextView)paramView.findViewById(2131828048));
                paramViewGroup.rUP.setOnClickListener(new at.5(this));
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                ag.cpc().dC(paramViewGroup.rUT);
                ag.cpc().dC(paramViewGroup.rUV);
                ag.cpc().dC(paramViewGroup.rUW);
                i = -1;
                if (this.rEd.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.rEd.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.rUK.setTag(Integer.valueOf(paramInt));
                paramViewGroup.rVi.settouchEnable(false);
                paramViewGroup.rVi.setBackgroundResource(0);
                paramViewGroup.rVi.setDescendantFocusability(131072);
                paramViewGroup.rVi.setClickable(false);
                paramViewGroup.rUT.settouchEnable(true);
                paramViewGroup.rUT.setClickable(true);
                paramViewGroup.rVi.setOnClickListener(null);
                if ((i < this.rEg) && (i != -1)) {
                  break;
                }
                paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                paramView.setVisibility(8);
                AppMethodBeat.o(39219);
                return paramView;
                paramViewGroup = (at.d)paramView.getTag();
              }
              if (i - 1 < 0) {
                break label6073;
              }
              localObject1 = (n)getItem(i - 1);
              j = ((n)localObject1).field_head;
              ak.ad(((n)localObject1).field_localPrivate, this.ctJ);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject1 = (n)getItem(i);
              localObject2 = ((n)localObject1).csh();
              if (((this.ctJ) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
              {
                l = ((n)localObject1).field_createTime;
                a(paramViewGroup.rUI, paramViewGroup.rUJ, l);
                if (((TimeLineObject)localObject2).xTQ != null)
                {
                  localObject2 = ((TimeLineObject)localObject2).xTQ.gwR;
                  if ((localObject2 != null) && (!((String)localObject2).equals("")))
                  {
                    paramViewGroup.rUN.setText((CharSequence)localObject2);
                    paramViewGroup.rUN.setVisibility(0);
                  }
                }
                paramViewGroup.rEw.setVisibility(0);
              }
              a(paramViewGroup.rUK, j, ((n)localObject1).field_head);
              if ((this.rUC != 0L) && (((n)localObject1).field_snsId == this.rUC))
              {
                paramViewGroup.rUO.setVisibility(0);
                paramViewGroup.rUL.setVisibility(0);
                if ((!this.ctJ) || (paramInt != 0)) {
                  break label3967;
                }
                paramViewGroup.rUU.setVisibility(0);
                paramViewGroup.rUU.setContentDescription(this.cup.getString(2131304003));
                paramViewGroup.rUT.setVisibility(8);
                localObject2 = paramViewGroup.ruR;
                if (this.rEf != 1) {
                  break label3960;
                }
              }
              label3960:
              for (localObject1 = this.cup.getString(2131304041);; localObject1 = "")
              {
                ((TextView)localObject2).setText((CharSequence)localObject1);
                paramViewGroup.ruR.setVisibility(0);
                paramViewGroup.rVb.setVisibility(0);
                paramViewGroup.rVa.setVisibility(8);
                ag.cpc().a(paramViewGroup.rUU, 2131690515, 2130840426, this.cup.hashCode());
                localObject1 = new at.f.a();
                ((at.f.a)localObject1).cIp = -1;
                ((at.f.a)localObject1).position = -1;
                paramViewGroup.rUU.setTag(localObject1);
                AppMethodBeat.o(39219);
                return paramView;
                if ((this.rUC == 0L) && (this.rUB != 0L) && (((n)localObject1).field_snsId <= this.rUB))
                {
                  paramViewGroup.rUO.setVisibility(0);
                  this.rUC = ((n)localObject1).field_snsId;
                  break;
                }
                paramViewGroup.rUO.setVisibility(8);
                break;
              }
              label3967:
              a(i, paramViewGroup.rUT, paramViewGroup.rUX, paramViewGroup.rVa, paramViewGroup.rVc, paramViewGroup.rVf, 1, paramViewGroup, paramInt);
              localObject2 = (n)getItem(i);
              if ((!bo.isNullOrNil(((n)localObject2).csh().xTP)) && (((n)localObject2).field_type == 1))
              {
                paramViewGroup.rVi.setDescendantFocusability(393216);
                paramViewGroup.rVi.setClickable(true);
                paramViewGroup.rUT.setClickable(false);
                paramViewGroup.rUT.settouchEnable(false);
                paramViewGroup.rVi.setOnClickListener(this.rUv.rVk);
                paramViewGroup.rVi.settouchEnable(true);
                i = ((n)localObject1).rCV;
                localObject1 = new at.f.a();
                ((at.f.a)localObject1).cIp = i;
                if (this.rUu.get(Integer.valueOf(paramInt)) == null) {
                  break label4171;
                }
              }
              label4171:
              for (((at.f.a)localObject1).position = ((Integer)this.rUu.get(Integer.valueOf(paramInt))).intValue();; ((at.f.a)localObject1).position = 0)
              {
                paramViewGroup.rVi.setTag(localObject1);
                paramView.setDrawingCacheEnabled(false);
                AppMethodBeat.o(39219);
                return paramView;
              }
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof at.b)))
              {
                localObject2 = new at.b(this);
                paramView = w.hM(this.cup).inflate(2130970851, null);
                ((at.b)localObject2).rUH = paramView.findViewById(2131821888);
                ((at.b)localObject2).rUJ = ((TextView)paramView.findViewById(2131828184));
                ((at.b)localObject2).rUI = ((TextView)paramView.findViewById(2131828185));
                ((at.b)localObject2).rUK = ((TextView)paramView.findViewById(2131828186));
                ((at.b)localObject2).rUN = ((TextView)paramView.findViewById(2131820735));
                ((at.b)localObject2).rEw = paramView.findViewById(2131827909);
                ((at.b)localObject2).rUN = ((TextView)paramView.findViewById(2131820735));
                ((at.b)localObject2).rUL = ((LinearLayout)paramView.findViewById(2131828049));
                ((at.b)localObject2).rUM = ((ImageView)paramView.findViewById(2131828050));
                ((at.b)localObject2).rEv = ((LinearLayout)paramView.findViewById(2131827910));
                ((at.b)localObject2).hsI = ((TextView)paramView.findViewById(2131821007));
                ((at.b)localObject2).rUQ = ((TagImageView)paramView.findViewById(2131825855));
                ((at.b)localObject2).rFb = ((ImageView)paramView.findViewById(2131824765));
                ((at.b)localObject2).titleTv = ((TextView)paramView.findViewById(2131825857));
                ((at.b)localObject2).rUR = ((TextView)paramView.findViewById(2131825858));
                ((at.b)localObject2).rUH.setOnClickListener(this.rUv.rVj);
                ((at.b)localObject2).rUS = paramView.findViewById(2131828028);
                ((at.b)localObject2).rUO = ((LinearLayout)paramView.findViewById(2131828047));
                ((at.b)localObject2).rUP = ((TextView)paramView.findViewById(2131828048));
                ((at.b)localObject2).rUP.setOnClickListener(new at.4(this));
                paramView.setTag(localObject2);
                i.b(((at.b)localObject2).rUQ, this.cup);
                ((at.b)localObject2).rUK.setTag(Integer.valueOf(paramInt));
                if (this.rEd.get(Integer.valueOf(paramInt)) == null) {
                  break label6067;
                }
              }
              for (i = ((Integer)this.rEd.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                ((at.b)localObject2).init();
                if ((i >= this.rEg) || (i == -1))
                {
                  paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                  paramView.setVisibility(8);
                  AppMethodBeat.o(39219);
                  return paramView;
                  localObject2 = (at.b)paramView.getTag();
                  break label4536;
                }
                paramView.setVisibility(0);
                if (i - 1 >= 0)
                {
                  paramViewGroup = (n)getItem(i - 1);
                  j = paramViewGroup.field_head;
                  ak.ad(paramViewGroup.field_localPrivate, this.ctJ);
                }
                for (;;)
                {
                  paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  paramView.setVisibility(0);
                  if (this.rEe.get(Integer.valueOf(paramInt)) != null) {
                    ((Integer)this.rEe.get(Integer.valueOf(paramInt))).intValue();
                  }
                  localObject1 = (n)getItem(i);
                  localObject3 = ((n)localObject1).csh();
                  if (((this.ctJ) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
                  {
                    l = ((n)localObject1).field_createTime;
                    a(((at.b)localObject2).rUI, ((at.b)localObject2).rUJ, l);
                    if (((TimeLineObject)localObject3).xTQ != null)
                    {
                      paramViewGroup = ((TimeLineObject)localObject3).xTQ.gwR;
                      if ((paramViewGroup != null) && (!paramViewGroup.equals("")))
                      {
                        ((at.b)localObject2).rUN.setText(paramViewGroup);
                        ((at.b)localObject2).rUN.setVisibility(0);
                      }
                    }
                    ((at.b)localObject2).rEw.setVisibility(0);
                  }
                  a(((at.b)localObject2).rUK, j, ((n)localObject1).field_head);
                  if ((this.rUC != 0L) && (((n)localObject1).field_snsId == this.rUC))
                  {
                    ((at.b)localObject2).rUO.setVisibility(0);
                    paramViewGroup = new at.f.a();
                    paramViewGroup.cIp = ((n)localObject1).rCV;
                    if (this.rUu.get(Integer.valueOf(paramInt)) == null) {
                      break label5225;
                    }
                    paramViewGroup.position = ((Integer)this.rUu.get(Integer.valueOf(paramInt))).intValue();
                    label4970:
                    ((at.b)localObject2).rUH.setTag(paramViewGroup);
                    if (bo.isNullOrNil(((TimeLineObject)localObject3).xTP)) {
                      break label5233;
                    }
                    ((at.b)localObject2).hsI.setVisibility(0);
                    ((at.b)localObject2).hsI.setText(((TimeLineObject)localObject3).xTP);
                    ((at.b)localObject2).hsI.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.cup, ((TimeLineObject)localObject3).xTP, ((at.b)localObject2).hsI.getTextSize()));
                  }
                  az localaz;
                  for (;;)
                  {
                    ((at.b)localObject2).rUL.setVisibility(0);
                    ((at.b)localObject2).hsI.setSingleLine(true);
                    ((at.b)localObject2).rUS.setVisibility(0);
                    paramInt = ((TimeLineObject)localObject3).xTS.wNZ;
                    localaz = new az(this.rUt.tag);
                    localaz.oLs = ((n)localObject1).field_createTime;
                    if (paramInt != 2) {
                      break label5246;
                    }
                    ((at.b)localObject2).hsI.setVisibility(0);
                    ((at.b)localObject2).hsI.setSingleLine(false);
                    ((at.b)localObject2).hsI.setMaxLines(2);
                    ((at.b)localObject2).rUS.setVisibility(8);
                    break;
                    if ((this.rUC == 0L) && (this.rUB != 0L) && (((n)localObject1).field_snsId <= this.rUB))
                    {
                      ((at.b)localObject2).rUO.setVisibility(0);
                      this.rUC = ((n)localObject1).field_snsId;
                      break label4914;
                    }
                    ((at.b)localObject2).rUO.setVisibility(8);
                    break label4914;
                    label5225:
                    paramViewGroup.position = 0;
                    break label4970;
                    label5233:
                    ((at.b)localObject2).hsI.setVisibility(8);
                  }
                  label5246:
                  bcs localbcs;
                  if (paramInt == 4)
                  {
                    if (!((TimeLineObject)localObject3).xTS.wOa.isEmpty())
                    {
                      ((at.b)localObject2).rUQ.setVisibility(0);
                      ((at.b)localObject2).rFb.setVisibility(0);
                      ((at.b)localObject2).rUS.setVisibility(0);
                      ((at.b)localObject2).titleTv.setMaxLines(1);
                      ((at.b)localObject2).titleTv.setTextColor(this.cup.getResources().getColor(2131690489));
                      localbcs = (bcs)((TimeLineObject)localObject3).xTS.wOa.get(0);
                      ag.cpc().a(localbcs, ((at.b)localObject2).rUQ, 2131230809, this.cup.hashCode(), g.a.reb, localaz);
                      ((at.b)localObject2).rFb.setPressed(false);
                      if (aci(((TimeLineObject)localObject3).Id))
                      {
                        ((at.b)localObject2).rFb.setImageResource(2130839751);
                        ((at.b)localObject2).rUQ.setTag(localObject3);
                        ((at.b)localObject2).rUQ.setOnClickListener(this.rUE);
                        localbcs.cIp = ((n)localObject1).rCV;
                        ((at.b)localObject2).rUS.setTag(localObject3);
                        localObject1 = localbcs.Desc;
                        if (bo.isNullOrNil((String)localObject1)) {
                          break label5549;
                        }
                        ((at.b)localObject2).rUR.setVisibility(0);
                        ((at.b)localObject2).rUR.setText((CharSequence)localObject1);
                      }
                      for (;;)
                      {
                        localObject1 = localbcs.Title;
                        if (bo.isNullOrNil((String)localObject1)) {
                          break label5561;
                        }
                        ((at.b)localObject2).titleTv.setVisibility(0);
                        ((at.b)localObject2).titleTv.setTag(paramViewGroup);
                        ((at.b)localObject2).titleTv.setOnTouchListener(new aa());
                        ((at.b)localObject2).titleTv.setText((CharSequence)localObject1);
                        break;
                        ((at.b)localObject2).rFb.setImageResource(2130839753);
                        break label5398;
                        ((at.b)localObject2).rUR.setVisibility(4);
                      }
                      ((at.b)localObject2).titleTv.setVisibility(8);
                      break;
                    }
                    ((at.b)localObject2).rUS.setVisibility(8);
                    break;
                  }
                  ((at.b)localObject2).titleTv.setTextColor(this.cup.getResources().getColor(2131690434));
                  if ((an.a.cpE() & 0x1) <= 0)
                  {
                    paramInt = 1;
                    label5618:
                    if (paramInt == 0) {
                      break label5924;
                    }
                    paramViewGroup = av.acj(((TimeLineObject)localObject3).xTS.Url);
                    localObject1 = ((TimeLineObject)localObject3).xTS.Title;
                    if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
                      break label6058;
                    }
                    localObject1 = ((String)localObject1).substring(0, 40) + "...";
                  }
                  for (;;)
                  {
                    if (((at.b)localObject2).rUQ != null) {
                      ((at.b)localObject2).rUQ.setOnClickListener(null);
                    }
                    ((at.b)localObject2).rFb.setVisibility(8);
                    if (!((TimeLineObject)localObject3).xTS.wOa.isEmpty())
                    {
                      ((at.b)localObject2).rUQ.setVisibility(0);
                      localbcs = (bcs)((TimeLineObject)localObject3).xTS.wOa.get(0);
                      if (((TimeLineObject)localObject3).xTS.wNZ == 5)
                      {
                        paramViewGroup = av.acj(localbcs.Url);
                        localObject1 = localbcs.Title;
                        ((at.b)localObject2).rFb.setVisibility(0);
                        ag.cpc().a(localbcs, ((at.b)localObject2).rUQ, 2131230826, this.cup.hashCode(), g.a.reb, localaz);
                        if (bo.isNullOrNil(paramViewGroup)) {
                          break label6007;
                        }
                        ((at.b)localObject2).rUR.setVisibility(0);
                        ((at.b)localObject2).rUR.setText(paramViewGroup);
                        label5845:
                        if (bo.isNullOrNil((String)localObject1)) {
                          break label6045;
                        }
                        if (((at.b)localObject2).rUR.getVisibility() != 8) {
                          break label6020;
                        }
                        ((at.b)localObject2).titleTv.setMaxLines(2);
                      }
                    }
                    for (;;)
                    {
                      ((at.b)localObject2).titleTv.setVisibility(0);
                      if ((((TimeLineObject)localObject3).fgB & 0x1) <= 0) {
                        break label6032;
                      }
                      ((at.b)localObject2).titleTv.setText(i.a((String)localObject1, this.cup, ((at.b)localObject2).titleTv));
                      break;
                      paramInt = 0;
                      break label5618;
                      paramViewGroup = "";
                      break label5634;
                      ag.cpc().a(localbcs, ((at.b)localObject2).rUQ, this.cup.hashCode(), g.a.reb, localaz);
                      break label5820;
                      if (((TimeLineObject)localObject3).xTS.wNZ != 26)
                      {
                        ((at.b)localObject2).rUQ.setVisibility(8);
                        break label5820;
                      }
                      ((at.b)localObject2).rUQ.setVisibility(0);
                      ((at.b)localObject2).rUQ.setImageResource(2131231779);
                      break label5820;
                      label6007:
                      ((at.b)localObject2).rUR.setVisibility(8);
                      break label5845;
                      ((at.b)localObject2).titleTv.setMaxLines(1);
                    }
                    ((at.b)localObject2).titleTv.setText((CharSequence)localObject1);
                    break;
                    ((at.b)localObject2).titleTv.setVisibility(8);
                    break;
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
      label4914:
      label6067:
      label6097:
      j = -1;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
  
  public final void me(long paramLong)
  {
    if (0L != this.rUB) {
      return;
    }
    this.rUB = paramLong;
    this.rUC = 0L;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(39226);
    super.notifyDataSetChanged();
    AppMethodBeat.o(39226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at
 * JD-Core Version:    0.7.0.1
 */