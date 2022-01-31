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
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.g.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class as
  extends BaseAdapter
{
  private Activity bMV;
  boolean bMo = false;
  private String country;
  String jKL = "";
  private String lCN = "";
  List<n> list = new ArrayList();
  Map<Integer, Integer> oMs = new HashMap();
  Map<Integer, Integer> oMt = new HashMap();
  int oMu = 0;
  int oMv = 0;
  String oSZ = "";
  private bd oWj = null;
  private az pbJ;
  Map<Integer, Integer> pbK = new HashMap();
  private as.f pbL;
  boolean pbM = false;
  at pbN;
  private as.c pbO;
  int pbP = 2147483647;
  int pbQ = 0;
  private long pbR = 0L;
  private long pbS = 0L;
  int pbT = 0;
  protected View.OnClickListener pbU = new as.6(this);
  private String userName = "";
  
  public as(Activity paramActivity, as.f paramf, String paramString, as.c paramc)
  {
    this.userName = paramString;
    this.bMV = paramActivity;
    this.pbL = paramf;
    this.pbO = paramc;
    this.oWj = af.bDt();
    paramf = x.d(this.bMV.getSharedPreferences(ae.cqR(), 0));
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "filterLan temp " + paramf);
    paramActivity = paramf;
    if (!paramf.equals("zh_CN"))
    {
      paramActivity = paramf;
      if (!paramf.equals("en"))
      {
        if (!paramf.equals("zh_TW")) {
          break label377;
        }
        paramActivity = paramf;
      }
    }
    this.lCN = paramActivity;
    this.country = x.d(this.bMV.getSharedPreferences(ae.cqR(), 0));
    com.tencent.mm.kernel.g.DQ();
    paramActivity = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, null);
    if (this.userName.equals(paramActivity)) {
      this.bMo = true;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
    if (this.bMo) {
      this.pbJ = az.cva();
    }
    for (;;)
    {
      this.pbN = new at(new as.1(this, paramc), paramString, this.bMo);
      gz(0L);
      jy(false);
      return;
      label377:
      if (paramf.equals("zh_HK"))
      {
        paramActivity = "zh_TW";
        break;
      }
      paramActivity = "en";
      break;
      com.tencent.mm.kernel.g.DQ();
      paramActivity = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
      if ((paramActivity != null) && (com.tencent.mm.n.a.gR(paramActivity.field_type))) {
        this.pbJ = az.cuZ();
      } else {
        this.pbJ = az.cvb();
      }
    }
  }
  
  protected static boolean Pp(String paramString)
  {
    com.tencent.mm.av.e locale = com.tencent.mm.av.a.Pw();
    return (locale != null) && (com.tencent.mm.av.a.d(locale)) && (paramString.equals(locale.eux)) && (com.tencent.mm.av.a.Pu());
  }
  
  private void a(int paramInt1, QFadeImageView paramQFadeImageView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, int paramInt2, as.d paramd, int paramInt3)
  {
    n localn = (n)getItem(paramInt1);
    bxk localbxk = localn.bGe();
    bto localbto = aj.q(localn);
    int i = 0;
    paramInt1 = i;
    if (localbto != null) {
      if (((localbto.ttI & 0x2) != 2) || (localbto.tKj == null))
      {
        paramInt1 = i;
        if ((localbto.ttI & 0x4) == 4)
        {
          paramInt1 = i;
          if (localbto.tsx == null) {}
        }
      }
      else
      {
        paramInt1 = 1;
      }
    }
    if ((this.bMo) && (localbto != null) && (paramInt1 != 0) && (this.userName != null) && (this.userName.equals(localn.field_userName)))
    {
      paramTextView3.setBackgroundResource(i.e.personactivity_sharephoto_icon);
      paramTextView3.setVisibility(0);
    }
    Object localObject;
    if (paramInt2 == 1)
    {
      if (aj.U(localn.field_localPrivate, this.bMo))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(i.e.personactivity_keyphoto_icon);
        localObject = this.oWj.abl(localn.field_userName);
        if (localObject != null) {
          break label556;
        }
        localObject = "";
        if ((!((String)localObject).equals("")) && (!this.userName.equals(localn.field_userName)))
        {
          paramTextView1.setVisibility(0);
          paramTextView1.setText((CharSequence)localObject);
        }
      }
      label229:
      paramInt1 = localn.oLk;
      paramTextView1 = new f.a();
      paramTextView1.onc = paramInt1;
      if (this.pbK.get(Integer.valueOf(paramInt3)) == null) {
        break label674;
      }
      paramTextView1.position = ((Integer)this.pbK.get(Integer.valueOf(paramInt3))).intValue();
      label289:
      paramQFadeImageView.setTag(paramTextView1);
      paramTextView1 = new az(this.pbJ.tag);
      paramTextView1.time = localn.field_createTime;
      if (localbxk.tNr.sPI != 1) {
        break label682;
      }
      paramQFadeImageView.setVisibility(0);
      af.bDC().a(localbxk.tNr.sPJ, paramQFadeImageView, this.bMV.hashCode(), g.a.opz, paramTextView1);
      label361:
      if ((localn.bDo()) && (localn.bGG()))
      {
        paramTextView3.setVisibility(0);
        paramTextView3.setBackgroundResource(i.e.personactivity_failicon);
        paramQFadeImageView.setLongClickable(true);
      }
      if (paramInt2 == 1)
      {
        if ((localbxk.tNr.sPJ == null) || (localbxk.tNr.sPJ.size() <= 1)) {
          break label805;
        }
        paramd.pcr.setVisibility(0);
        paramTextView2.setVisibility(0);
        paramInt1 = localbxk.tNr.sPJ.size();
        paramTextView2.setText(this.bMV.getResources().getQuantityString(i.h.sns_media_count, paramInt1, new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
    for (;;)
    {
      paramQFadeImageView = localbxk.tNo;
      if ((paramQFadeImageView != null) && (!paramQFadeImageView.equals("")))
      {
        paramd.pcr.setVisibility(0);
        paramd.oFq.setVisibility(0);
        paramd.oFq.setText(paramQFadeImageView);
        paramd.oFq.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bMV, paramQFadeImageView, paramd.oFq.getTextSize()));
      }
      return;
      label556:
      localObject = ((com.tencent.mm.n.a)localObject).Bq();
      break;
      if (!aj.U(localn.field_localPrivate, this.bMo)) {
        break label229;
      }
      paramTextView3.setVisibility(0);
      paramTextView3.setBackgroundResource(i.e.personactivity_keyphoto_icon);
      localObject = this.oWj.abl(localn.field_userName);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((com.tencent.mm.n.a)localObject).Bq())
      {
        if ((localObject == null) || (((String)localObject).equals("")) || (this.userName.equals(localn.field_userName))) {
          break label672;
        }
        paramTextView1.setVisibility(0);
        paramTextView1.setText((CharSequence)localObject);
        break;
      }
      label672:
      break label229;
      label674:
      paramTextView1.position = 0;
      break label289;
      label682:
      if (localbxk.tNr.sPI == 2)
      {
        paramTextView4.setText(bk.aM(localbxk.tNr.kRN, ""));
        paramTextView4.setVisibility(0);
        break label361;
      }
      if (localbxk.tNr.sPI != 21) {
        break label361;
      }
      localn.bGw();
      boolean bool = true;
      if (this.bMo) {
        bool = true;
      }
      for (;;)
      {
        paramQFadeImageView.setVisibility(0);
        af.bDC().a(localbxk.tNr.sPJ, paramQFadeImageView, this.bMV.hashCode(), g.a.opz, paramTextView1, bool);
        break;
        if (com.tencent.mm.plugin.sns.lucky.a.m.a(localn, localbto)) {
          bool = false;
        }
      }
      label805:
      paramTextView2.setVisibility(8);
    }
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    int i = paramInt1 / 10000;
    paramInt2 /= 10000;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
    LinearLayout.LayoutParams localLayoutParams;
    if ((i == 0) || (paramInt2 != i))
    {
      paramInt1 = ((Integer)paramTextView.getTag()).intValue();
      if ((paramTextView.getLayoutParams() instanceof LinearLayout.LayoutParams))
      {
        localLayoutParams = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
        if (paramInt1 != 0) {
          break label134;
        }
        localLayoutParams.topMargin = 0;
        paramTextView.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      paramTextView.setText(String.format(this.bMV.getResources().getString(i.j.sns_user_date_year), new Object[] { Integer.valueOf(paramInt2) }));
      paramTextView.setVisibility(0);
      return;
      label134:
      localLayoutParams.topMargin = this.bMV.getResources().getDimensionPixelSize(i.d.sns_user_year_top_margin);
      paramTextView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    Object localObject = this.bMV;
    if (!this.lCN.equals("en")) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = (String)ay.a((Context)localObject, 1000L * paramLong, bool);
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
      return;
    }
    if (((String)localObject).indexOf("/") > 0)
    {
      localObject = ((String)localObject).split("/");
      if (localObject[1].length() < 2) {
        localObject[1] = ("0" + localObject[1]);
      }
      localObject[0] = ay.s(this.bMV, localObject[0], this.lCN);
      paramTextView1.setText(localObject[0]);
      paramTextView2.setText(localObject[1]);
      paramTextView2.setVisibility(0);
      paramTextView1.setVisibility(0);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText((CharSequence)localObject);
  }
  
  private void gz(long paramLong)
  {
    Object localObject = i.fO(af.bDF().a(paramLong, af.bDv().NH(this.userName), this.userName, this.bMo));
    if (this.oSZ.equals("")) {}
    for (;;)
    {
      this.jKL = ((String)localObject);
      localObject = af.bDJ().OF(this.userName).bGv();
      if (((xs)localObject).sUt != 0L) {
        break;
      }
      return;
      if (((String)localObject).compareTo(this.oSZ) >= 0) {
        localObject = this.oSZ;
      }
    }
    localObject = i.fO(((xs)localObject).sUt);
    if (this.jKL.equals(""))
    {
      this.jKL = ((String)localObject);
      return;
    }
    if (((String)localObject).compareTo(this.jKL) > 0) {}
    for (;;)
    {
      this.jKL = ((String)localObject);
      return;
      localObject = this.jKL;
    }
  }
  
  private void jy(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.jKL);
    if (this.pbN != null) {
      this.pbN.e(this.jKL, this.pbM, paramBoolean);
    }
  }
  
  public final void bHx()
  {
    jy(true);
    notifyDataSetChanged();
  }
  
  public final void bJj()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "i addSize ");
    if (this.list.isEmpty()) {}
    for (long l = 0L;; l = ((n)this.list.get(this.list.size() - 1)).field_snsId)
    {
      gz(l);
      return;
    }
  }
  
  public final ArrayList<b> dW(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    this.pbT = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < this.list.size())
    {
      n localn = (n)this.list.get(paramInt2);
      int j = localn.oLk;
      if ((localn.bGe() != null) && (localn.bGe().tNr != null) && (localn.bGe().tNr.sPJ.size() != 0) && ((localn.bGe().tNr.sPI == 1) || (localn.bGe().tNr.sPI == 15)))
      {
        if (j == paramInt1) {
          this.pbT = localArrayList.size();
        }
        Iterator localIterator = localn.bGe().tNr.sPJ.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          awd localawd = (awd)localIterator.next();
          b localb = new b();
          localb.bZK = localawd;
          localb.owP = v.al("sns_table_", j);
          localb.enw = localn.field_createTime;
          localb.owQ = i;
          localArrayList.add(localb);
          i += 1;
        }
      }
      paramInt2 += 1;
    }
    return localArrayList;
  }
  
  public final int getCount()
  {
    return this.oMu;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.bMo) && (paramInt == 0))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "position isSelf " + paramInt + " - 0");
      return 0;
    }
    if (this.oMs.get(Integer.valueOf(paramInt)) != null) {}
    for (int i = ((Integer)this.oMs.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      if (i == -1)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsphotoAdapter", "unknow error " + i);
        return 0;
      }
      n localn = (n)getItem(i);
      if (localn.bGe().tNr.sPI == 1)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 0");
        return 0;
      }
      if (localn.bGe().tNr.sPI == 15)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsphotoAdapter", "position " + paramInt + " - 2");
        return 2;
      }
      if (localn.bGe().tNr.sPI == 21) {
        return 3;
      }
      return 1;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsphotoAdapter", "position " + i);
    Object localObject1;
    int j;
    if (i == 0)
    {
      if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof as.d)))
      {
        paramViewGroup = new as.d(this);
        paramView = com.tencent.mm.ui.y.gt(this.bMV).inflate(i.g.sns_photo_user_photo, null);
        paramViewGroup.pbZ = ((TextView)paramView.findViewById(i.f.sns_day));
        paramViewGroup.pbY = ((TextView)paramView.findViewById(i.f.sns_month));
        paramViewGroup.pca = ((TextView)paramView.findViewById(i.f.sns_year));
        paramViewGroup.pcj = ((MaskImageView)paramView.findViewById(i.f.img1));
        paramViewGroup.pck = ((QFadeImageView)paramView.findViewById(i.f.take_photo));
        paramViewGroup.pcl = ((MaskImageView)paramView.findViewById(i.f.img2));
        paramViewGroup.pcm = ((MaskImageView)paramView.findViewById(i.f.img3));
        paramViewGroup.oFq = ((TextView)paramView.findViewById(i.f.desc));
        paramViewGroup.pcn = ((TextView)paramView.findViewById(i.f.with_username1));
        paramViewGroup.pco = ((TextView)paramView.findViewById(i.f.with_username2));
        paramViewGroup.pcp = ((TextView)paramView.findViewById(i.f.with_username3));
        paramViewGroup.pcq = ((TextView)paramView.findViewById(i.f.img_count));
        paramViewGroup.pcr = paramView.findViewById(i.f.desc_count);
        paramViewGroup.pcd = ((TextView)paramView.findViewById(i.f.address));
        paramViewGroup.pcb = ((LinearLayout)paramView.findViewById(i.f.line_add_item));
        paramViewGroup.pcc = ((ImageView)paramView.findViewById(i.f.lock_line_add_item_b));
        paramViewGroup.oMK = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
        paramViewGroup.oML = paramView.findViewById(i.f.line_add);
        paramViewGroup.pck.setOnClickListener(this.pbL.oMB);
        paramViewGroup.pcj.setOnClickListener(this.pbL.oMB);
        paramViewGroup.pcl.setOnClickListener(this.pbL.oMC);
        paramViewGroup.pcm.setOnClickListener(this.pbL.oMD);
        paramViewGroup.pcj.setOnLongClickListener(this.pbL.pcC);
        paramViewGroup.pcl.setOnLongClickListener(this.pbL.pcC);
        paramViewGroup.pcm.setOnLongClickListener(this.pbL.pcC);
        paramViewGroup.pcs = ((TextView)paramView.findViewById(i.f.warn1));
        paramViewGroup.pct = ((TextView)paramView.findViewById(i.f.warn2));
        paramViewGroup.pcu = ((TextView)paramView.findViewById(i.f.warn3));
        paramViewGroup.pcv = ((TextView)paramView.findViewById(i.f.tv1));
        paramViewGroup.pcw = ((TextView)paramView.findViewById(i.f.tv2));
        paramViewGroup.pcx = ((TextView)paramView.findViewById(i.f.tv3));
        paramViewGroup.pcy = ((MaskLinearLayout)paramView.findViewById(i.f.sns_line_blackground));
        paramViewGroup.pcy.b(paramViewGroup.pcj);
        paramViewGroup.pce = ((LinearLayout)paramView.findViewById(i.f.friends_limit));
        paramViewGroup.pcf = ((TextView)paramView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
        paramViewGroup.pcf.setOnClickListener(new as.3(this));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        af.bDC().cM(paramViewGroup.pcj);
        af.bDC().cM(paramViewGroup.pcl);
        af.bDC().cM(paramViewGroup.pcm);
        i = -1;
        if (this.oMs.get(Integer.valueOf(paramInt)) != null) {
          i = ((Integer)this.oMs.get(Integer.valueOf(paramInt))).intValue();
        }
        paramViewGroup.init();
        paramViewGroup.pca.setTag(Integer.valueOf(paramInt));
        paramViewGroup.pcy.settouchEnable(false);
        paramViewGroup.pcy.setBackgroundResource(0);
        paramViewGroup.pcy.setDescendantFocusability(131072);
        paramViewGroup.pcy.setClickable(false);
        paramViewGroup.pcj.settouchEnable(true);
        paramViewGroup.pcj.setClickable(true);
        paramViewGroup.pcj.setLongClickable(false);
        paramViewGroup.pcl.setLongClickable(false);
        paramViewGroup.pcm.setLongClickable(false);
        paramViewGroup.pcy.setOnClickListener(null);
        paramViewGroup.pcy.setOnLongClickListener(null);
        paramViewGroup.pcy.setLongClickable(false);
        if ((i < this.oMv) && (i != -1)) {
          break;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        return paramView;
        paramViewGroup = (as.d)paramView.getTag();
      }
      if (i - 1 < 0) {
        break label6041;
      }
      localObject1 = (n)getItem(i - 1);
      j = ((n)localObject1).field_head;
      aj.U(((n)localObject1).field_localPrivate, this.bMo);
    }
    label4486:
    label6029:
    label6041:
    for (;;)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.setVisibility(0);
      if (this.oMt.get(Integer.valueOf(paramInt)) != null) {}
      label1306:
      label5789:
      for (int k = ((Integer)this.oMt.get(Integer.valueOf(paramInt))).intValue();; k = 1)
      {
        localObject1 = (n)getItem(i);
        Object localObject2 = ((n)localObject1).bGe();
        long l;
        if (((this.bMo) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
        {
          l = ((n)localObject1).field_createTime;
          a(paramViewGroup.pbY, paramViewGroup.pbZ, l);
          if (((bxk)localObject2).tNp != null)
          {
            localObject2 = ((bxk)localObject2).tNp.ffj;
            if ((localObject2 != null) && (!((String)localObject2).equals("")))
            {
              paramViewGroup.pcd.setText((CharSequence)localObject2);
              paramViewGroup.pcd.setVisibility(0);
            }
          }
          paramViewGroup.oML.setVisibility(0);
        }
        a(paramViewGroup.pca, j, ((n)localObject1).field_head);
        if ((this.pbS != 0L) && (((n)localObject1).field_snsId == this.pbS))
        {
          paramViewGroup.pce.setVisibility(0);
          paramViewGroup.pcb.setVisibility(0);
          if ((!this.bMo) || (paramInt != 0)) {
            break label1313;
          }
          paramViewGroup.pck.setVisibility(0);
          paramViewGroup.pck.setContentDescription(this.bMV.getString(i.j.sns_take_photo));
          paramViewGroup.pcj.setVisibility(8);
          localObject2 = paramViewGroup.oFq;
          if (this.oMu != 1) {
            break label1306;
          }
        }
        for (localObject1 = this.bMV.getString(i.j.sns_user_start);; localObject1 = "")
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          paramViewGroup.oFq.setVisibility(0);
          paramViewGroup.pcr.setVisibility(0);
          paramViewGroup.pcq.setVisibility(8);
          af.bDC().a(paramViewGroup.pck, i.c.sns_user_take_photo_bg, i.e.sns_takephoto_icon, this.bMV.hashCode());
          localObject1 = new f.a();
          ((f.a)localObject1).onc = -1;
          ((f.a)localObject1).position = -1;
          paramViewGroup.pck.setTag(localObject1);
          return paramView;
          if ((this.pbS == 0L) && (this.pbR != 0L) && (((n)localObject1).field_snsId <= this.pbR))
          {
            paramViewGroup.pce.setVisibility(0);
            this.pbS = ((n)localObject1).field_snsId;
            break;
          }
          paramViewGroup.pce.setVisibility(8);
          break;
        }
        label1313:
        if (k > 0) {
          a(i, paramViewGroup.pcj, paramViewGroup.pcn, paramViewGroup.pcq, paramViewGroup.pcs, paramViewGroup.pcv, 1, paramViewGroup, paramInt);
        }
        if (k >= 2) {
          a(i + 1, paramViewGroup.pcl, paramViewGroup.pco, paramViewGroup.pcq, paramViewGroup.pct, paramViewGroup.pcw, 2, paramViewGroup, paramInt);
        }
        if (k >= 3) {
          a(i + 2, paramViewGroup.pcm, paramViewGroup.pcp, paramViewGroup.pcq, paramViewGroup.pcu, paramViewGroup.pcx, 3, paramViewGroup, paramInt);
        }
        if (k == 1)
        {
          localObject2 = (n)getItem(i);
          if ((!bk.bl(((n)localObject2).bGe().tNo)) && (((n)localObject2).field_type == 1))
          {
            paramViewGroup.pcy.setDescendantFocusability(393216);
            paramViewGroup.pcy.setClickable(true);
            paramViewGroup.pcj.setClickable(false);
            paramViewGroup.pcj.settouchEnable(false);
            paramViewGroup.pcy.setOnClickListener(this.pbL.oMB);
            paramViewGroup.pcy.settouchEnable(true);
            i = ((n)localObject1).oLk;
            localObject1 = new f.a();
            ((f.a)localObject1).onc = i;
            if (this.pbK.get(Integer.valueOf(paramInt)) == null) {
              break label1626;
            }
          }
        }
        label1626:
        for (((f.a)localObject1).position = ((Integer)this.pbK.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject1).position = 0)
        {
          if ((((n)localObject2).bDo()) && (((n)localObject2).bGG())) {
            paramViewGroup.pcy.setOnLongClickListener(this.pbL.pcC);
          }
          paramViewGroup.pcy.setTag(localObject1);
          paramView.setDrawingCacheEnabled(false);
          return paramView;
        }
        if (i == 2) {
          if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof as.e)))
          {
            paramViewGroup = new as.e(this);
            paramView = com.tencent.mm.ui.y.gt(this.bMV).inflate(i.g.sns_sight_user, null);
            paramViewGroup.pbZ = ((TextView)paramView.findViewById(i.f.sns_day));
            paramViewGroup.pbY = ((TextView)paramView.findViewById(i.f.sns_month));
            paramViewGroup.pca = ((TextView)paramView.findViewById(i.f.sns_year));
            paramViewGroup.pcj = ((MaskImageView)paramView.findViewById(i.f.img1));
            paramViewGroup.pcd = ((TextView)paramView.findViewById(i.f.address));
            paramViewGroup.pcb = ((LinearLayout)paramView.findViewById(i.f.line_add_item));
            paramViewGroup.pcc = ((ImageView)paramView.findViewById(i.f.lock_line_add_item_b));
            paramViewGroup.oMK = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
            paramViewGroup.oML = paramView.findViewById(i.f.line_add);
            paramViewGroup.pcj.setOnClickListener(this.pbL.pcB);
            paramViewGroup.pcs = ((TextView)paramView.findViewById(i.f.warn1));
            paramViewGroup.pcy = ((MaskLinearLayout)paramView.findViewById(i.f.sns_line_blackground));
            paramViewGroup.pcy.b(paramViewGroup.pcj);
            paramViewGroup.oFq = ((TextView)paramView.findViewById(i.f.desc));
            paramViewGroup.pcr = paramView.findViewById(i.f.desc_count);
            paramViewGroup.pce = ((LinearLayout)paramView.findViewById(i.f.friends_limit));
            paramViewGroup.pcf = ((TextView)paramView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
            paramViewGroup.pcf.setOnClickListener(new as.2(this));
            paramView.setTag(paramViewGroup);
            af.bDC().cM(paramViewGroup.pcj);
            if (this.oMs.get(Integer.valueOf(paramInt)) == null) {
              break label6029;
            }
          }
        }
        label5169:
        for (i = ((Integer)this.oMs.get(Integer.valueOf(paramInt))).intValue();; i = -1)
        {
          paramViewGroup.init();
          paramViewGroup.pca.setTag(Integer.valueOf(paramInt));
          paramViewGroup.pcy.settouchEnable(false);
          paramViewGroup.pcy.setBackgroundResource(0);
          paramViewGroup.pcy.setDescendantFocusability(131072);
          paramViewGroup.pcy.setClickable(false);
          paramViewGroup.pcj.settouchEnable(true);
          paramViewGroup.pcj.setClickable(true);
          paramViewGroup.pcy.setOnClickListener(null);
          if ((i >= this.oMv) || (i == -1))
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            paramView.setVisibility(8);
            return paramView;
            paramViewGroup = (as.e)paramView.getTag();
            break;
          }
          if (i - 1 >= 0)
          {
            localObject1 = (n)getItem(i - 1);
            j = ((n)localObject1).field_head;
            aj.U(((n)localObject1).field_localPrivate, this.bMo);
          }
          label4914:
          label5177:
          label5562:
          label5951:
          for (;;)
          {
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            paramView.setVisibility(0);
            if (this.oMt.get(Integer.valueOf(paramInt)) != null) {
              ((Integer)this.oMt.get(Integer.valueOf(paramInt))).intValue();
            }
            localObject1 = (n)getItem(i);
            localObject2 = ((n)localObject1).bGe();
            Object localObject3;
            if (((this.bMo) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
            {
              l = ((n)localObject1).field_createTime;
              a(paramViewGroup.pbY, paramViewGroup.pbZ, l);
              if (((bxk)localObject2).tNp != null)
              {
                localObject3 = ((bxk)localObject2).tNp.ffj;
                if ((localObject3 != null) && (!((String)localObject3).equals("")))
                {
                  paramViewGroup.pcd.setText((CharSequence)localObject3);
                  paramViewGroup.pcd.setVisibility(0);
                }
              }
              paramViewGroup.oML.setVisibility(0);
            }
            a(paramViewGroup.pca, j, ((n)localObject1).field_head);
            if ((this.pbS != 0L) && (((n)localObject1).field_snsId == this.pbS))
            {
              paramViewGroup.pce.setVisibility(0);
              paramViewGroup.pcb.setVisibility(0);
              localObject3 = new az(this.pbJ.tag);
              ((az)localObject3).time = ((n)localObject1).field_createTime;
              paramViewGroup.pcj.setVisibility(0);
              af.bDC().a(((bxk)localObject2).tNr.sPJ, paramViewGroup.pcj, this.bMV.hashCode(), g.a.opz, (az)localObject3);
              if (aj.U(((n)localObject1).field_localPrivate, this.bMo))
              {
                paramViewGroup.pcs.setVisibility(0);
                paramViewGroup.pcs.setBackgroundResource(i.e.personactivity_keyphoto_icon);
                localObject2 = this.oWj.abl(((n)localObject1).field_userName);
                if (localObject2 != null) {
                  ((com.tencent.mm.n.a)localObject2).Bq();
                }
              }
              localObject2 = ((n)getItem(i)).bGe().tNo;
              if ((localObject2 != null) && (!((String)localObject2).equals("")))
              {
                paramViewGroup.pcr.setVisibility(0);
                paramViewGroup.oFq.setVisibility(0);
                paramViewGroup.oFq.setText((CharSequence)localObject2);
                paramViewGroup.oFq.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bMV, (CharSequence)localObject2, paramViewGroup.oFq.getTextSize()));
              }
              paramViewGroup.pcy.setDescendantFocusability(393216);
              paramViewGroup.pcy.setClickable(true);
              paramViewGroup.pcj.setClickable(false);
              paramViewGroup.pcj.settouchEnable(false);
              paramViewGroup.pcy.setOnClickListener(this.pbL.pcB);
              paramViewGroup.pcy.settouchEnable(true);
              i = ((n)localObject1).oLk;
              localObject1 = new f.a();
              ((f.a)localObject1).onc = i;
              if (this.pbK.get(Integer.valueOf(paramInt)) == null) {
                break label2777;
              }
            }
            label2777:
            for (((f.a)localObject1).position = ((Integer)this.pbK.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject1).position = 0)
            {
              paramViewGroup.pcy.setTag(localObject1);
              paramView.setDrawingCacheEnabled(false);
              return paramView;
              if ((this.pbS == 0L) && (this.pbR != 0L) && (((n)localObject1).field_snsId <= this.pbR))
              {
                paramViewGroup.pce.setVisibility(0);
                this.pbS = ((n)localObject1).field_snsId;
                break;
              }
              paramViewGroup.pce.setVisibility(8);
              break;
            }
            if (i == 3)
            {
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof as.d)))
              {
                paramViewGroup = new as.d(this);
                paramView = com.tencent.mm.ui.y.gt(this.bMV).inflate(i.g.sns_photo_user_photo, null);
                paramViewGroup.pbZ = ((TextView)paramView.findViewById(i.f.sns_day));
                paramViewGroup.pbY = ((TextView)paramView.findViewById(i.f.sns_month));
                paramViewGroup.pca = ((TextView)paramView.findViewById(i.f.sns_year));
                paramViewGroup.pcj = ((MaskImageView)paramView.findViewById(i.f.img1));
                paramViewGroup.pck = ((QFadeImageView)paramView.findViewById(i.f.take_photo));
                paramViewGroup.pcl = ((MaskImageView)paramView.findViewById(i.f.img2));
                paramViewGroup.pcm = ((MaskImageView)paramView.findViewById(i.f.img3));
                paramViewGroup.oFq = ((TextView)paramView.findViewById(i.f.desc));
                paramViewGroup.pcn = ((TextView)paramView.findViewById(i.f.with_username1));
                paramViewGroup.pco = ((TextView)paramView.findViewById(i.f.with_username2));
                paramViewGroup.pcp = ((TextView)paramView.findViewById(i.f.with_username3));
                paramViewGroup.pcq = ((TextView)paramView.findViewById(i.f.img_count));
                paramViewGroup.pcr = paramView.findViewById(i.f.desc_count);
                paramViewGroup.pcd = ((TextView)paramView.findViewById(i.f.address));
                paramViewGroup.pcb = ((LinearLayout)paramView.findViewById(i.f.line_add_item));
                paramViewGroup.pcc = ((ImageView)paramView.findViewById(i.f.lock_line_add_item_b));
                paramViewGroup.oMK = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
                paramViewGroup.oML = paramView.findViewById(i.f.line_add);
                paramViewGroup.pck.setOnClickListener(this.pbL.pcA);
                paramViewGroup.pcj.setOnClickListener(this.pbL.pcA);
                paramViewGroup.pcs = ((TextView)paramView.findViewById(i.f.warn1));
                paramViewGroup.pct = ((TextView)paramView.findViewById(i.f.warn2));
                paramViewGroup.pcu = ((TextView)paramView.findViewById(i.f.warn3));
                paramViewGroup.pcv = ((TextView)paramView.findViewById(i.f.tv1));
                paramViewGroup.pcw = ((TextView)paramView.findViewById(i.f.tv2));
                paramViewGroup.pcx = ((TextView)paramView.findViewById(i.f.tv3));
                paramViewGroup.pcy = ((MaskLinearLayout)paramView.findViewById(i.f.sns_line_blackground));
                paramViewGroup.pcy.b(paramViewGroup.pcj);
                paramViewGroup.pce = ((LinearLayout)paramView.findViewById(i.f.friends_limit));
                paramViewGroup.pcf = ((TextView)paramView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
                paramViewGroup.pcf.setOnClickListener(new as.5(this));
                paramView.setTag(paramViewGroup);
              }
              for (;;)
              {
                af.bDC().cM(paramViewGroup.pcj);
                af.bDC().cM(paramViewGroup.pcl);
                af.bDC().cM(paramViewGroup.pcm);
                i = -1;
                if (this.oMs.get(Integer.valueOf(paramInt)) != null) {
                  i = ((Integer)this.oMs.get(Integer.valueOf(paramInt))).intValue();
                }
                paramViewGroup.init();
                paramViewGroup.pca.setTag(Integer.valueOf(paramInt));
                paramViewGroup.pcy.settouchEnable(false);
                paramViewGroup.pcy.setBackgroundResource(0);
                paramViewGroup.pcy.setDescendantFocusability(131072);
                paramViewGroup.pcy.setClickable(false);
                paramViewGroup.pcj.settouchEnable(true);
                paramViewGroup.pcj.setClickable(true);
                paramViewGroup.pcy.setOnClickListener(null);
                if ((i < this.oMv) && (i != -1)) {
                  break;
                }
                paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                paramView.setVisibility(8);
                return paramView;
                paramViewGroup = (as.d)paramView.getTag();
              }
              if (i - 1 < 0) {
                break label6017;
              }
              localObject1 = (n)getItem(i - 1);
              j = ((n)localObject1).field_head;
              aj.U(((n)localObject1).field_localPrivate, this.bMo);
            }
            label3916:
            label3923:
            label5342:
            label5868:
            label6002:
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
              paramView.setVisibility(0);
              localObject1 = (n)getItem(i);
              localObject2 = ((n)localObject1).bGe();
              if (((this.bMo) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
              {
                l = ((n)localObject1).field_createTime;
                a(paramViewGroup.pbY, paramViewGroup.pbZ, l);
                if (((bxk)localObject2).tNp != null)
                {
                  localObject2 = ((bxk)localObject2).tNp.ffj;
                  if ((localObject2 != null) && (!((String)localObject2).equals("")))
                  {
                    paramViewGroup.pcd.setText((CharSequence)localObject2);
                    paramViewGroup.pcd.setVisibility(0);
                  }
                }
                paramViewGroup.oML.setVisibility(0);
              }
              a(paramViewGroup.pca, j, ((n)localObject1).field_head);
              if ((this.pbS != 0L) && (((n)localObject1).field_snsId == this.pbS))
              {
                paramViewGroup.pce.setVisibility(0);
                paramViewGroup.pcb.setVisibility(0);
                if ((!this.bMo) || (paramInt != 0)) {
                  break label3923;
                }
                paramViewGroup.pck.setVisibility(0);
                paramViewGroup.pck.setContentDescription(this.bMV.getString(i.j.sns_take_photo));
                paramViewGroup.pcj.setVisibility(8);
                localObject2 = paramViewGroup.oFq;
                if (this.oMu != 1) {
                  break label3916;
                }
              }
              for (localObject1 = this.bMV.getString(i.j.sns_user_start);; localObject1 = "")
              {
                ((TextView)localObject2).setText((CharSequence)localObject1);
                paramViewGroup.oFq.setVisibility(0);
                paramViewGroup.pcr.setVisibility(0);
                paramViewGroup.pcq.setVisibility(8);
                af.bDC().a(paramViewGroup.pck, i.c.sns_user_take_photo_bg, i.e.sns_takephoto_icon, this.bMV.hashCode());
                localObject1 = new f.a();
                ((f.a)localObject1).onc = -1;
                ((f.a)localObject1).position = -1;
                paramViewGroup.pck.setTag(localObject1);
                return paramView;
                if ((this.pbS == 0L) && (this.pbR != 0L) && (((n)localObject1).field_snsId <= this.pbR))
                {
                  paramViewGroup.pce.setVisibility(0);
                  this.pbS = ((n)localObject1).field_snsId;
                  break;
                }
                paramViewGroup.pce.setVisibility(8);
                break;
              }
              a(i, paramViewGroup.pcj, paramViewGroup.pcn, paramViewGroup.pcq, paramViewGroup.pcs, paramViewGroup.pcv, 1, paramViewGroup, paramInt);
              localObject2 = (n)getItem(i);
              if ((!bk.bl(((n)localObject2).bGe().tNo)) && (((n)localObject2).field_type == 1))
              {
                paramViewGroup.pcy.setDescendantFocusability(393216);
                paramViewGroup.pcy.setClickable(true);
                paramViewGroup.pcj.setClickable(false);
                paramViewGroup.pcj.settouchEnable(false);
                paramViewGroup.pcy.setOnClickListener(this.pbL.pcA);
                paramViewGroup.pcy.settouchEnable(true);
                i = ((n)localObject1).oLk;
                localObject1 = new f.a();
                ((f.a)localObject1).onc = i;
                if (this.pbK.get(Integer.valueOf(paramInt)) == null) {
                  break label4121;
                }
              }
              for (((f.a)localObject1).position = ((Integer)this.pbK.get(Integer.valueOf(paramInt))).intValue();; ((f.a)localObject1).position = 0)
              {
                paramViewGroup.pcy.setTag(localObject1);
                paramView.setDrawingCacheEnabled(false);
                return paramView;
              }
              if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof as.b)))
              {
                localObject2 = new as.b(this);
                paramView = com.tencent.mm.ui.y.gt(this.bMV).inflate(i.g.sns_photo_user_normal, null);
                ((as.b)localObject2).pbX = paramView.findViewById(i.f.content_ll);
                ((as.b)localObject2).pbZ = ((TextView)paramView.findViewById(i.f.sns_day));
                ((as.b)localObject2).pbY = ((TextView)paramView.findViewById(i.f.sns_month));
                ((as.b)localObject2).pca = ((TextView)paramView.findViewById(i.f.sns_year));
                ((as.b)localObject2).pcd = ((TextView)paramView.findViewById(i.f.address));
                ((as.b)localObject2).oML = paramView.findViewById(i.f.line_add);
                ((as.b)localObject2).pcd = ((TextView)paramView.findViewById(i.f.address));
                ((as.b)localObject2).pcb = ((LinearLayout)paramView.findViewById(i.f.line_add_item));
                ((as.b)localObject2).pcc = ((ImageView)paramView.findViewById(i.f.lock_line_add_item_b));
                ((as.b)localObject2).oMK = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
                ((as.b)localObject2).gaI = ((TextView)paramView.findViewById(i.f.desc_tv));
                ((as.b)localObject2).pcg = ((TagImageView)paramView.findViewById(i.f.image_left));
                ((as.b)localObject2).oNr = ((ImageView)paramView.findViewById(i.f.state));
                ((as.b)localObject2).eXr = ((TextView)paramView.findViewById(i.f.titletext));
                ((as.b)localObject2).pch = ((TextView)paramView.findViewById(i.f.righttext));
                ((as.b)localObject2).pbX.setOnClickListener(this.pbL.pcz);
                ((as.b)localObject2).pci = paramView.findViewById(i.f.media_content_rl);
                ((as.b)localObject2).pce = ((LinearLayout)paramView.findViewById(i.f.friends_limit));
                ((as.b)localObject2).pcf = ((TextView)paramView.findViewById(i.f.sns_no_see_tip_reset_tips_btn));
                ((as.b)localObject2).pcf.setOnClickListener(new as.4(this));
                paramView.setTag(localObject2);
                i.b(((as.b)localObject2).pcg, this.bMV);
                ((as.b)localObject2).pca.setTag(Integer.valueOf(paramInt));
                if (this.oMs.get(Integer.valueOf(paramInt)) == null) {
                  break label6011;
                }
              }
              label4858:
              label6011:
              for (i = ((Integer)this.oMs.get(Integer.valueOf(paramInt))).intValue();; i = -1)
              {
                ((as.b)localObject2).init();
                if ((i >= this.oMv) || (i == -1))
                {
                  paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                  paramView.setVisibility(8);
                  return paramView;
                  localObject2 = (as.b)paramView.getTag();
                  break label4486;
                }
                paramView.setVisibility(0);
                if (i - 1 >= 0)
                {
                  paramViewGroup = (n)getItem(i - 1);
                  j = paramViewGroup.field_head;
                  aj.U(paramViewGroup.field_localPrivate, this.bMo);
                }
                for (;;)
                {
                  paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                  paramView.setVisibility(0);
                  if (this.oMt.get(Integer.valueOf(paramInt)) != null) {
                    ((Integer)this.oMt.get(Integer.valueOf(paramInt))).intValue();
                  }
                  localObject1 = (n)getItem(i);
                  localObject3 = ((n)localObject1).bGe();
                  if (((this.bMo) && (paramInt == 0)) || (j == -1) || (((n)localObject1).field_head != j))
                  {
                    l = ((n)localObject1).field_createTime;
                    a(((as.b)localObject2).pbY, ((as.b)localObject2).pbZ, l);
                    if (((bxk)localObject3).tNp != null)
                    {
                      paramViewGroup = ((bxk)localObject3).tNp.ffj;
                      if ((paramViewGroup != null) && (!paramViewGroup.equals("")))
                      {
                        ((as.b)localObject2).pcd.setText(paramViewGroup);
                        ((as.b)localObject2).pcd.setVisibility(0);
                      }
                    }
                    ((as.b)localObject2).oML.setVisibility(0);
                  }
                  a(((as.b)localObject2).pca, j, ((n)localObject1).field_head);
                  if ((this.pbS != 0L) && (((n)localObject1).field_snsId == this.pbS))
                  {
                    ((as.b)localObject2).pce.setVisibility(0);
                    paramViewGroup = new f.a();
                    paramViewGroup.onc = ((n)localObject1).oLk;
                    if (this.pbK.get(Integer.valueOf(paramInt)) == null) {
                      break label5169;
                    }
                    paramViewGroup.position = ((Integer)this.pbK.get(Integer.valueOf(paramInt))).intValue();
                    ((as.b)localObject2).pbX.setTag(paramViewGroup);
                    if (bk.bl(((bxk)localObject3).tNo)) {
                      break label5177;
                    }
                    ((as.b)localObject2).gaI.setVisibility(0);
                    ((as.b)localObject2).gaI.setText(((bxk)localObject3).tNo);
                    ((as.b)localObject2).gaI.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bMV, ((bxk)localObject3).tNo, ((as.b)localObject2).gaI.getTextSize()));
                  }
                  az localaz;
                  for (;;)
                  {
                    ((as.b)localObject2).pcb.setVisibility(0);
                    ((as.b)localObject2).gaI.setSingleLine(true);
                    ((as.b)localObject2).pci.setVisibility(0);
                    paramInt = ((bxk)localObject3).tNr.sPI;
                    localaz = new az(this.pbJ.tag);
                    localaz.time = ((n)localObject1).field_createTime;
                    if (paramInt != 2) {
                      break label5190;
                    }
                    ((as.b)localObject2).gaI.setVisibility(0);
                    ((as.b)localObject2).gaI.setSingleLine(false);
                    ((as.b)localObject2).gaI.setMaxLines(2);
                    ((as.b)localObject2).pci.setVisibility(8);
                    break;
                    if ((this.pbS == 0L) && (this.pbR != 0L) && (((n)localObject1).field_snsId <= this.pbR))
                    {
                      ((as.b)localObject2).pce.setVisibility(0);
                      this.pbS = ((n)localObject1).field_snsId;
                      break label4858;
                    }
                    ((as.b)localObject2).pce.setVisibility(8);
                    break label4858;
                    paramViewGroup.position = 0;
                    break label4914;
                    ((as.b)localObject2).gaI.setVisibility(8);
                  }
                  awd localawd;
                  if (paramInt == 4)
                  {
                    if (!((bxk)localObject3).tNr.sPJ.isEmpty())
                    {
                      ((as.b)localObject2).pcg.setVisibility(0);
                      ((as.b)localObject2).oNr.setVisibility(0);
                      ((as.b)localObject2).pci.setVisibility(0);
                      ((as.b)localObject2).eXr.setMaxLines(1);
                      ((as.b)localObject2).eXr.setTextColor(this.bMV.getResources().getColor(i.c.sns_link_color));
                      localawd = (awd)((bxk)localObject3).tNr.sPJ.get(0);
                      af.bDC().a(localawd, ((as.b)localObject2).pcg, i.i.app_attach_file_icon_music, this.bMV.hashCode(), g.a.opz, localaz);
                      ((as.b)localObject2).oNr.setPressed(false);
                      if (Pp(((bxk)localObject3).lsK))
                      {
                        ((as.b)localObject2).oNr.setImageResource(i.e.music_pauseicon);
                        ((as.b)localObject2).pcg.setTag(localObject3);
                        ((as.b)localObject2).pcg.setOnClickListener(this.pbU);
                        localawd.onc = ((n)localObject1).oLk;
                        ((as.b)localObject2).pci.setTag(localObject3);
                        localObject1 = localawd.kRN;
                        if (bk.bl((String)localObject1)) {
                          break label5493;
                        }
                        ((as.b)localObject2).pch.setVisibility(0);
                        ((as.b)localObject2).pch.setText((CharSequence)localObject1);
                      }
                      for (;;)
                      {
                        localObject1 = localawd.bGw;
                        if (bk.bl((String)localObject1)) {
                          break label5505;
                        }
                        ((as.b)localObject2).eXr.setVisibility(0);
                        ((as.b)localObject2).eXr.setTag(paramViewGroup);
                        ((as.b)localObject2).eXr.setOnTouchListener(new aa());
                        ((as.b)localObject2).eXr.setText((CharSequence)localObject1);
                        break;
                        ((as.b)localObject2).oNr.setImageResource(i.e.music_playicon);
                        break label5342;
                        ((as.b)localObject2).pch.setVisibility(4);
                      }
                      ((as.b)localObject2).eXr.setVisibility(8);
                      break;
                    }
                    ((as.b)localObject2).pci.setVisibility(8);
                    break;
                  }
                  ((as.b)localObject2).eXr.setTextColor(this.bMV.getResources().getColor(i.c.self_sns_link));
                  if ((am.a.bEf() & 0x1) <= 0)
                  {
                    paramInt = 1;
                    if (paramInt == 0) {
                      break label5868;
                    }
                    paramViewGroup = au.Pq(((bxk)localObject3).tNr.kSC);
                    localObject1 = ((bxk)localObject3).tNr.bGw;
                    if ((localObject1 == null) || (((String)localObject1).length() <= 40)) {
                      break label6002;
                    }
                    localObject1 = ((String)localObject1).substring(0, 40) + "...";
                  }
                  for (;;)
                  {
                    if (((as.b)localObject2).pcg != null) {
                      ((as.b)localObject2).pcg.setOnClickListener(null);
                    }
                    ((as.b)localObject2).oNr.setVisibility(8);
                    if (!((bxk)localObject3).tNr.sPJ.isEmpty())
                    {
                      ((as.b)localObject2).pcg.setVisibility(0);
                      localawd = (awd)((bxk)localObject3).tNr.sPJ.get(0);
                      if (((bxk)localObject3).tNr.sPI == 5)
                      {
                        paramViewGroup = au.Pq(localawd.kSC);
                        localObject1 = localawd.bGw;
                        ((as.b)localObject2).oNr.setVisibility(0);
                        af.bDC().a(localawd, ((as.b)localObject2).pcg, i.i.app_attach_file_icon_video, this.bMV.hashCode(), g.a.opz, localaz);
                        if (bk.bl(paramViewGroup)) {
                          break label5951;
                        }
                        ((as.b)localObject2).pch.setVisibility(0);
                        ((as.b)localObject2).pch.setText(paramViewGroup);
                        if (bk.bl((String)localObject1)) {
                          break label5989;
                        }
                        if (((as.b)localObject2).pch.getVisibility() != 8) {
                          break label5964;
                        }
                        ((as.b)localObject2).eXr.setMaxLines(2);
                      }
                    }
                    for (;;)
                    {
                      ((as.b)localObject2).eXr.setVisibility(0);
                      if ((((bxk)localObject3).dQA & 0x1) <= 0) {
                        break label5976;
                      }
                      ((as.b)localObject2).eXr.setText(i.a((String)localObject1, this.bMV, ((as.b)localObject2).eXr));
                      break;
                      paramInt = 0;
                      break label5562;
                      paramViewGroup = "";
                      break label5578;
                      af.bDC().a(localawd, ((as.b)localObject2).pcg, this.bMV.hashCode(), g.a.opz, localaz);
                      break label5764;
                      if (((bxk)localObject3).tNr.sPI != 26)
                      {
                        ((as.b)localObject2).pcg.setVisibility(8);
                        break label5764;
                      }
                      ((as.b)localObject2).pcg.setVisibility(0);
                      ((as.b)localObject2).pcg.setImageResource(i.i.note_sns_link_default);
                      break label5764;
                      ((as.b)localObject2).pch.setVisibility(8);
                      break label5789;
                      ((as.b)localObject2).eXr.setMaxLines(1);
                    }
                    ((as.b)localObject2).eXr.setText((CharSequence)localObject1);
                    break;
                    ((as.b)localObject2).eXr.setVisibility(8);
                    break;
                  }
                  j = -1;
                }
              }
              label5493:
              j = -1;
            }
            label5190:
            label5578:
            label5964:
            label5976:
            label5989:
            j = -1;
          }
        }
      }
      label4121:
      j = -1;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
  
  public final void gy(long paramLong)
  {
    if (0L != this.pbR) {
      return;
    }
    this.pbR = paramLong;
    this.pbS = 0L;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public static final class f$a
  {
    public int onc;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as
 * JD-Core Version:    0.7.0.1
 */