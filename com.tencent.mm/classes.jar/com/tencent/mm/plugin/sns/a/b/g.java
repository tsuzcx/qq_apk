package com.tencent.mm.plugin.sns.a.b;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.af;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class g
  implements b
{
  public static Map<String, Integer> qZj;
  private Activity activity;
  public int cpt;
  public HashMap<String, Long> qYZ;
  private int qYs;
  public HashSet<Long> qZa;
  private Map<String, Long> qZb;
  private Map<String, Integer> qZc;
  private Map<String, a> qZd;
  public HashSet<Long> qZe;
  public Map<Long, h> qZf;
  public Map<Long, h> qZg;
  public Map<String, g.a> qZh;
  private Map<String, Integer> qZi;
  private int qZk;
  private View qZl;
  public Map<Long, Integer> qZm;
  public Map<Long, Integer> qZn;
  private int qZo;
  
  static
  {
    AppMethodBeat.i(35743);
    qZj = new HashMap();
    AppMethodBeat.o(35743);
  }
  
  public g(int paramInt)
  {
    AppMethodBeat.i(35721);
    this.qYZ = new HashMap();
    this.qZa = new HashSet();
    this.qZb = new HashMap();
    this.qZc = new HashMap();
    this.qZd = new HashMap();
    this.qZe = new HashSet();
    this.qZf = new HashMap();
    this.qZg = new HashMap();
    this.qZh = new HashMap();
    this.cpt = 0;
    this.qZi = new HashMap();
    this.qZk = 0;
    this.qYs = 0;
    this.qZl = null;
    this.qZm = new HashMap();
    this.qZn = new HashMap();
    this.qZo = -1;
    this.cpt = paramInt;
    AppMethodBeat.o(35721);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(n paramn)
  {
    AppMethodBeat.i(35734);
    if (paramn != null)
    {
      if (this.cpt == 2)
      {
        paramn = paramn.cse();
        AppMethodBeat.o(35734);
        return paramn;
      }
      paramn = paramn.csd();
      AppMethodBeat.o(35734);
      return paramn;
    }
    AppMethodBeat.o(35734);
    return null;
  }
  
  private com.tencent.mm.bv.b g(n paramn)
  {
    AppMethodBeat.i(35735);
    if (paramn != null)
    {
      if (this.cpt == 2)
      {
        paramn = paramn.csQ().csl();
        AppMethodBeat.o(35735);
        return paramn;
      }
      paramn = paramn.csQ().csj();
      AppMethodBeat.o(35735);
      return paramn;
    }
    AppMethodBeat.o(35735);
    return null;
  }
  
  private com.tencent.mm.bv.b h(n paramn)
  {
    AppMethodBeat.i(35736);
    if (paramn != null)
    {
      if (this.cpt == 2)
      {
        paramn = paramn.csQ().csm();
        AppMethodBeat.o(35736);
        return paramn;
      }
      paramn = paramn.csQ().csk();
      AppMethodBeat.o(35736);
      return paramn;
    }
    AppMethodBeat.o(35736);
    return null;
  }
  
  public final void V(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(35729);
    al.d(new g.3(this, paramLong1, paramLong2));
    AppMethodBeat.o(35729);
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.qYs = paramInt;
    this.qZl = paramView;
    this.activity = paramActivity;
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35737);
    this.qZa.add(Long.valueOf(paramLong));
    this.qYZ.put(paramString, Long.valueOf(paramLong));
    if (this.qZo == -1) {
      if (this.activity != null) {
        break label83;
      }
    }
    n localn;
    label83:
    for (int i = -1;; i = af.hT(this.activity))
    {
      this.qZo = i;
      localn = ag.cpf().abv(paramString);
      if (localn != null) {
        break;
      }
      ab.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
      AppMethodBeat.o(35737);
      return;
    }
    Object localObject1 = (a)this.qZd.get(paramString);
    Object localObject2 = f(localn);
    if (localObject2 != null) {}
    for (String str = ((com.tencent.mm.plugin.sns.storage.a)localObject2).hpq;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (ag.rgi))
      {
        paramView = new a((com.tencent.mm.plugin.sns.storage.a)localObject2, paramString, paramLong, paramView, this.qYs, this.qZl, this.qZo, paramInt3, paramSnsObject, paramInt1, localn.csb());
        paramView.qYE = System.currentTimeMillis();
        ag.bEf().post(new a.1(paramView));
        this.qZd.put(paramString, paramView);
        if (!this.qZm.containsKey(Long.valueOf(paramLong)))
        {
          paramSnsObject = this.qZm;
          if (localn.field_likeFlag != 1) {
            break label490;
          }
          i = 1;
          paramSnsObject.put(Long.valueOf(paramLong), Integer.valueOf(i));
        }
      }
      for (;;)
      {
        label335:
        long l;
        if ((paramInt2 == 11) && (localn.csh().xTS.wOa.size() > 1))
        {
          if (this.qZg.containsKey(Long.valueOf(paramLong)))
          {
            paramSnsObject = (h)this.qZg.get(Long.valueOf(paramLong));
            paramSnsObject.qZD = com.tencent.mm.sdk.platformtools.bo.yB();
            this.qZg.put(Long.valueOf(paramLong), paramSnsObject);
          }
        }
        else
        {
          if (!this.qZb.containsKey(paramString)) {
            break label535;
          }
          l = com.tencent.mm.sdk.platformtools.bo.av(((Long)this.qZb.get(paramString)).longValue());
          if (l >= 1200000L) {
            break label887;
          }
          if (!this.qZc.containsKey(paramString)) {
            break label511;
          }
        }
        label490:
        label511:
        for (i = ((Integer)this.qZc.get(paramString)).intValue();; i = 0)
        {
          if (i < 2) {
            break label517;
          }
          ab.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
          AppMethodBeat.o(35737);
          return;
          i = 0;
          break;
          paramSnsObject = new h("timeline");
          break label335;
        }
        label517:
        this.qZc.put(paramString, Integer.valueOf(i + 1));
        label535:
        if (!this.qZh.containsKey(paramString))
        {
          this.qZh.put(paramString, new g.a(com.tencent.mm.sdk.platformtools.bo.yB(), System.currentTimeMillis(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
          ab.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean);
          if (paramInt2 != 9) {
            break label937;
          }
          if (!this.qZf.containsKey(Long.valueOf(paramLong))) {
            break label922;
          }
          paramSnsObject = (h)this.qZf.get(Long.valueOf(paramLong));
          label667:
          paramSnsObject.qZD = com.tencent.mm.sdk.platformtools.bo.yB();
          this.qZf.put(Long.valueOf(paramLong), paramSnsObject);
          label692:
          if (!this.qZi.containsKey(paramString))
          {
            ab.i("MicroMsg.SnsAdStatistic", "exposures item ".concat(String.valueOf(paramString)));
            this.qZi.put(paramString, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
          localObject1 = localn.csb();
          localObject2 = localn.csh();
          paramSnsObject = null;
          paramString = paramSnsObject;
          if (paramView != null)
          {
            paramString = paramSnsObject;
            if (ag.rgi) {
              paramString = paramView.cnD();
            }
          }
          paramView = localn.csQ();
          paramInt1 = 0;
          if (this.cpt == 0)
          {
            paramInt1 = paramView.field_exposureCount + 1;
            paramView.field_exposureCount = paramInt1;
            ag.cpi().update(paramView, new String[0]);
          }
          if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).cqo()) {
            break label1072;
          }
          paramString = new d(str, paramInt3, paramString, 3, paramInt1, localn.csR(), g(localn), h(localn));
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
          AppMethodBeat.o(35737);
          return;
          label887:
          this.qZb.put(paramString, Long.valueOf(com.tencent.mm.sdk.platformtools.bo.yB()));
          this.qZc.put(paramString, Integer.valueOf(0));
          break;
          label922:
          paramSnsObject = new h("timeline");
          break label667;
          label937:
          if ((paramInt2 != 11) || (localn.csh().xTS.wOa.size() <= 0) || (((bcs)localn.csh().xTS.wOa.get(0)).jKs != 6)) {
            break label692;
          }
          if (this.qZf.containsKey(Long.valueOf(paramLong))) {}
          for (paramSnsObject = (h)this.qZf.get(Long.valueOf(paramLong));; paramSnsObject = new h("timeline"))
          {
            paramSnsObject.qZD = com.tencent.mm.sdk.platformtools.bo.yB();
            paramSnsObject.qZI = true;
            this.qZf.put(Long.valueOf(paramLong), paramSnsObject);
            break;
          }
          label1072:
          if (localn.csT())
          {
            i = localn.csR();
            if (localn.field_likeFlag == 1) {}
            for (paramInt2 = 2;; paramInt2 = 1)
            {
              paramString = new d(str, paramInt3, 1, 0, null, paramString, 6, "", paramInt1, i, 0, 0, paramInt2, g(localn), h(localn));
              break;
            }
          }
          if ((localn.cqp()) || (localn.cqq()))
          {
            if ((localObject2 != null) && (((TimeLineObject)localObject2).xTS.wNZ == 15) && (((TimeLineObject)localObject2).xTZ != 1)) {
              paramString = new d(str, paramInt3, paramString, 5, paramInt1, localn.csR(), g(localn), h(localn));
            } else {
              paramString = new d(str, paramInt3, paramString, 4, paramInt1, localn.csR(), g(localn), h(localn));
            }
          }
          else if (paramInt2 == 9) {
            paramString = new d(str, paramInt3, paramString, 2, paramInt1, localn.csR(), g(localn), h(localn));
          } else {
            paramString = new d(str, paramInt3, paramString, 1, paramInt1, localn.csR(), g(localn), h(localn));
          }
        }
        paramView = (View)localObject1;
      }
    }
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35726);
    h localh;
    if (paramBoolean2) {
      if (this.qZg.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.qZg.get(Long.valueOf(paramLong));
        if (paramInt > 0) {
          localh.setDuration(paramInt);
        }
        if (!paramBoolean1) {
          break label163;
        }
      }
    }
    label163:
    for (paramInt = 1;; paramInt = 0)
    {
      localh.qZB = paramInt;
      if (!paramBoolean2) {
        break label168;
      }
      this.qZg.put(Long.valueOf(paramLong), localh);
      AppMethodBeat.o(35726);
      return;
      localh = new h("timeline");
      break;
      if (this.qZf.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.qZf.get(Long.valueOf(paramLong));
        break;
      }
      localh = new h("timeline");
      break;
    }
    label168:
    this.qZf.put(Long.valueOf(paramLong), localh);
    AppMethodBeat.o(35726);
  }
  
  public final void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(35731);
    al.d(new g.4(this, paramLong1, paramLong2, paramBoolean));
    AppMethodBeat.o(35731);
  }
  
  public final void c(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(35728);
    h localh;
    if (paramBoolean2) {
      if (this.qZg.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.qZg.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label162;
        }
      }
    }
    label162:
    for (localh.qZJ.raL = 2;; localh.qZJ.raL = 1)
    {
      localh.qZJ.raM = 1;
      if (!paramBoolean2) {
        break label174;
      }
      this.qZg.put(Long.valueOf(paramLong), localh);
      AppMethodBeat.o(35728);
      return;
      localh = new h("timeline");
      break;
      if (this.qZf.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.qZf.get(Long.valueOf(paramLong));
        break;
      }
      localh = new h("timeline");
      break;
    }
    label174:
    this.qZf.put(Long.valueOf(paramLong), localh);
    AppMethodBeat.o(35728);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35740);
    ab.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
    Iterator localIterator = new HashSet(this.qZh.keySet()).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localObject = (g.a)this.qZh.get(localObject);
      k(((g.a)localObject).position, ((g.a)localObject).cIN, ((g.a)localObject).fQs);
    }
    localIterator = this.qZi.keySet().iterator();
    e locale;
    n localn;
    int i;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      locale = ag.cpi().Ev(v.abP((String)localObject));
      if (locale != null)
      {
        localn = locale.csn();
        locale.field_localFlag |= 0x80;
        i = (int)(System.currentTimeMillis() / 1000L);
        if (!this.qZi.containsKey(localObject)) {
          break label283;
        }
        i = ((Integer)this.qZi.get(localObject)).intValue();
      }
    }
    label283:
    for (;;)
    {
      if (locale.field_exposureTime <= 0) {
        locale.field_exposureTime = i;
      }
      localn.field_localFlag |= 0x80;
      ag.cpf().b(localn.field_snsId, localn);
      ag.cpi().b(locale.field_snsId, locale);
      break;
      this.qZh.clear();
      this.qZi.clear();
      AppMethodBeat.o(35740);
      return;
    }
  }
  
  public final long di(String paramString, int paramInt)
  {
    AppMethodBeat.i(145238);
    a locala = (a)this.qZd.get(paramString);
    if (locala != null) {}
    for (long l = locala.qYE;; l = 0L)
    {
      ab.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(145238);
      return l;
    }
  }
  
  public final void f(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35724);
    al.d(new g.2(this, paramLong, paramInt, paramBoolean));
    AppMethodBeat.o(35724);
  }
  
  public final void k(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(35738);
    if (this.qYZ.containsKey(paramString))
    {
      l1 = ((Long)this.qYZ.remove(paramString)).longValue();
      this.qZa.remove(Long.valueOf(l1));
    }
    Object localObject3 = null;
    n localn = null;
    Object localObject4 = (a)this.qZd.get(paramString);
    Object localObject2 = localObject3;
    Object localObject1 = localn;
    if (localObject4 != null)
    {
      localObject2 = localObject3;
      localObject1 = localn;
      if (ag.rgi)
      {
        ((a)localObject4).eRq = true;
        ((a)localObject4).qYF = System.currentTimeMillis();
        ((a)localObject4).qYX = 0;
        kZ(false);
        if (((a)localObject4).qYA < 0)
        {
          ((a)localObject4).qYV = 2;
          if (((a)localObject4).qYC >= 0) {
            break label1130;
          }
          ((a)localObject4).qYW = 2;
          label147:
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(com.tencent.mm.plugin.sns.data.i.lq(((a)localObject4).qYx) + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYw + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYV + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYW + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYS + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYT + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYU + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYE + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYF + ",");
          if ((((a)localObject4).qYI > 0L) && (((a)localObject4).qYL == 0L)) {
            ((a)localObject4).qYL = System.currentTimeMillis();
          }
          ((StringBuilder)localObject1).append(((a)localObject4).qYI + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYL + ",");
          if ((((a)localObject4).qYO > 0L) && (((a)localObject4).qYR == 0L)) {
            ((a)localObject4).qYR = System.currentTimeMillis();
          }
          ((StringBuilder)localObject1).append(((a)localObject4).qYO + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).qYR);
          f.a(((a)localObject4).qYx, (StringBuilder)localObject1);
          ab.i("MicroMsg.AdViewStatic", "report " + ((StringBuilder)localObject1).toString());
          localObject2 = new bl();
          ((bl)localObject2).wnW = ((a)localObject4).qYO;
          ((bl)localObject2).wnX = ((a)localObject4).qYR;
          ((bl)localObject2).qYV = ((a)localObject4).qYV;
          ((bl)localObject2).qYW = ((a)localObject4).qYW;
          ((bl)localObject2).wnR = ((a)localObject4).qYS;
          ((bl)localObject2).wnS = ((a)localObject4).qYT;
          ((bl)localObject2).wnT = ((a)localObject4).qYU;
          ((bl)localObject2).wnU = ((a)localObject4).qYI;
          ((bl)localObject2).wnV = ((a)localObject4).qYL;
          ((bl)localObject2).startTime = ((a)localObject4).qYE;
          ((bl)localObject2).endTime = ((a)localObject4).qYF;
          if ((((a)localObject4).qYz == null) || (!((a)localObject4).qYz.cqx())) {
            break label1139;
          }
          ag.coZ().e(14648, new Object[] { ((StringBuilder)localObject1).toString() });
          label785:
          localObject3 = com.tencent.mm.modelsns.b.lV(730);
          ((com.tencent.mm.modelsns.b)localObject3).uv(com.tencent.mm.plugin.sns.data.i.lq(((a)localObject4).qYx)).uv(((a)localObject4).qYw).lY(((a)localObject4).qYV).lY(((a)localObject4).qYW).lY(((a)localObject4).qYS).lY(((a)localObject4).qYT).lY(((a)localObject4).qYU).uv(((a)localObject4).qYE).uv(((a)localObject4).qYF).uv(((a)localObject4).qYI).uv(((a)localObject4).qYL).uv(((a)localObject4).qYO).uv(((a)localObject4).qYR);
          ((com.tencent.mm.modelsns.b)localObject3).ake();
          localObject3 = new lb();
          ((lb)localObject3).cBl.position = ((a)localObject4).position;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
          if (!ae.glp) {
            break label1187;
          }
          j = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
          ab.i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(j)));
          i = 0;
          label1065:
          if (i >= j) {
            break label1187;
          }
          if ((((a)localObject4).qYz == null) || (!((a)localObject4).qYz.cqx())) {
            break label1163;
          }
          ag.coZ().e(14648, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        for (;;)
        {
          i += 1;
          break label1065;
          ((a)localObject4).qYV = 1;
          break;
          label1130:
          ((a)localObject4).qYW = 1;
          break label147;
          label1139:
          ag.coZ().e(12010, new Object[] { ((StringBuilder)localObject1).toString() });
          break label785;
          label1163:
          ag.coZ().e(12010, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        label1187:
        localObject1 = ((a)localObject4).cnD();
        this.qZd.remove(paramString);
      }
    }
    int i = 0;
    int j = 0;
    localn = ag.cpf().abv(paramString);
    label1326:
    int k;
    label1371:
    long l3;
    long l2;
    if (localn != null)
    {
      i = j;
      if (this.qZg.containsKey(Long.valueOf(localn.field_snsId)))
      {
        i = j;
        if (localn.csh().xTS.wNZ == 27)
        {
          if (localn.field_likeFlag != 1) {
            break label1747;
          }
          i = 2;
          if (!this.qZn.containsKey(Long.valueOf(localn.field_snsId))) {
            break label1753;
          }
          j = ((Integer)this.qZn.get(Long.valueOf(localn.field_snsId))).intValue();
          if (!this.qZm.containsKey(Long.valueOf(localn.field_snsId))) {
            break label1759;
          }
          k = ((Integer)this.qZm.get(Long.valueOf(localn.field_snsId))).intValue();
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          localObject3 = (h)this.qZg.remove(Long.valueOf(localn.field_snsId));
          if (localObject3 != null)
          {
            ((h)localObject3).Dx(0);
            ((h)localObject3).cnG();
            l3 = ((h)localObject3).qZH;
            l2 = ((h)localObject3).qZG;
            l1 = ((h)localObject3).qZL * 1000L;
          }
          localObject4 = localn.csh().Id;
          localObject5 = localn.csP();
          if (localn.field_likeFlag != 1) {
            break label1765;
          }
        }
      }
    }
    label1747:
    label1753:
    label1759:
    label1765:
    for (localObject3 = "1";; localObject3 = "0")
    {
      localObject3 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject4, localObject5, String.valueOf(paramInt2), String.valueOf(j), String.valueOf(k), String.valueOf(l3), String.valueOf(l2), String.valueOf(l1), localObject3 });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(15155, (String)localObject3);
      ab.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[] { localObject3 });
      this.qZe.remove(Long.valueOf(localn.field_snsId));
      this.qZe.remove(Long.valueOf(localn.field_snsId + 1L));
      this.qZn.remove(Long.valueOf(localn.field_snsId));
      this.qZm.remove(Long.valueOf(localn.field_snsId));
      if (!this.qZh.containsKey(paramString)) {
        break label2225;
      }
      localObject3 = "";
      if (f(localn) != null) {
        localObject3 = f(localn).hpq;
      }
      localObject4 = (g.a)this.qZh.remove(paramString);
      this.qZb.put(paramString, Long.valueOf(com.tencent.mm.sdk.platformtools.bo.yB()));
      if (localObject4 != null) {
        break label1773;
      }
      AppMethodBeat.o(35738);
      return;
      i = 1;
      break;
      j = 0;
      break label1326;
      k = 0;
      break label1371;
    }
    label1773:
    long l1 = com.tencent.mm.sdk.platformtools.bo.av(((g.a)localObject4).qZu);
    if (((g.a)localObject4).qZw > 0L) {
      ((g.a)localObject4).qZz += com.tencent.mm.sdk.platformtools.bo.av(((g.a)localObject4).qZw);
    }
    ab.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + paramInt1 + " " + paramString + " " + l1 + " ");
    if (localn == null)
    {
      AppMethodBeat.o(35738);
      return;
    }
    paramString = "";
    Object localObject5 = localn.csh();
    if (localn.csb().cqo())
    {
      paramInt1 = 3;
      paramString = "";
      paramString = new d((String)localObject3, paramInt2, 2, (int)l1, (bl)localObject2, (com.tencent.mm.protocal.protobuf.bo)localObject1, paramInt1, paramString, -1, localn.csR(), (int)((g.a)localObject4).qZz, (int)((g.a)localObject4).qZA, i, g(localn), h(localn));
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
      AppMethodBeat.o(35738);
      return;
    }
    if (localn.csT())
    {
      paramInt1 = 6;
      paramString = (h)this.qZf.remove(Long.valueOf(((g.a)localObject4).qYx));
      if (paramString == null) {
        break label2264;
      }
      if (localn.field_likeFlag == 0) {
        paramString.Dx(0);
      }
    }
    label2225:
    label2264:
    for (paramString = paramString.cnF();; paramString = "")
    {
      break;
      if ((localn.cqp()) || (localn.cqq()))
      {
        if ((localObject5 != null) && (((TimeLineObject)localObject5).xTS.wNZ == 15) && (((TimeLineObject)localObject5).xTZ != 1))
        {
          paramInt1 = 5;
          localObject5 = (h)this.qZf.remove(Long.valueOf(((g.a)localObject4).qYx));
          if (localObject5 != null)
          {
            ((h)localObject5).Dx(0);
            paramString = ((h)localObject5).cnF();
          }
          this.qZe.remove(Long.valueOf(((g.a)localObject4).qYx));
          break;
        }
        paramInt1 = 4;
        paramString = "";
        break;
      }
      if (((g.a)localObject4).kwo == 9)
      {
        paramInt1 = 2;
        localObject5 = (h)this.qZf.remove(Long.valueOf(((g.a)localObject4).qYx));
        if (localObject5 != null)
        {
          ((h)localObject5).Dx(0);
          paramString = ((h)localObject5).cnF();
        }
        this.qZe.remove(Long.valueOf(((g.a)localObject4).qYx));
        break;
      }
      paramInt1 = 1;
      paramString = "";
      break;
      ab.w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + paramInt1 + " " + paramString);
      AppMethodBeat.o(35738);
      return;
    }
  }
  
  public final void kZ(boolean paramBoolean)
  {
    AppMethodBeat.i(35739);
    ab.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.qZd.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (ag.rgi))
      {
        locala.kY(paramBoolean);
        if ((!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(locala.ctV)) && (this.qZh.get(locala.ctV) != null))
        {
          g.a locala1 = (g.a)this.qZh.get(locala.ctV);
          boolean bool = locala.cnE();
          if ((bool) && (locala1.qZy == 0L))
          {
            locala1.qZy = com.tencent.mm.sdk.platformtools.bo.yB();
          }
          else if ((!bool) && (locala1.qZy > 0L))
          {
            locala1.qZA += com.tencent.mm.sdk.platformtools.bo.av(locala1.qZy);
            locala1.qZy = 0L;
          }
        }
      }
    }
    AppMethodBeat.o(35739);
  }
  
  public final boolean li(long paramLong)
  {
    AppMethodBeat.i(35720);
    boolean bool = this.qZa.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(35720);
    return bool;
  }
  
  public final boolean lj(long paramLong)
  {
    AppMethodBeat.i(35730);
    if (this.qZe.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(35730);
      return true;
    }
    AppMethodBeat.o(35730);
    return false;
  }
  
  public final void lk(long paramLong)
  {
    AppMethodBeat.i(35741);
    int i = 0;
    if (this.qZm.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.qZm.get(Long.valueOf(paramLong))).intValue();
    }
    this.qZm.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(35741);
  }
  
  public final void ll(long paramLong)
  {
    AppMethodBeat.i(35742);
    int i = 0;
    if (this.qZn.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.qZn.get(Long.valueOf(paramLong))).intValue();
    }
    this.qZn.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(35742);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(35733);
    Iterator localIterator = this.qZh.keySet().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      localObject1 = (g.a)this.qZh.get(localObject2);
      ab.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((g.a)localObject1).qZz += com.tencent.mm.sdk.platformtools.bo.av(((g.a)localObject1).qZw);
      ((g.a)localObject1).qZw = 0L;
      localObject2 = (h)this.qZf.get(Long.valueOf(((g.a)localObject1).qYx));
      if (localObject2 != null) {
        ((h)localObject2).fQx = com.tencent.mm.sdk.platformtools.bo.yB();
      }
      localObject1 = (h)this.qZg.get(Long.valueOf(((g.a)localObject1).qYx));
      if (localObject1 != null) {
        ((h)localObject1).fQx = com.tencent.mm.sdk.platformtools.bo.yB();
      }
    }
    localIterator = this.qZd.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (a)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (ag.rgi))
      {
        ((a)localObject1).kY(false);
        if ((!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(((a)localObject1).ctV)) && (this.qZh.get(((a)localObject1).ctV) != null))
        {
          localObject1 = (g.a)this.qZh.get(((a)localObject1).ctV);
          if (((g.a)localObject1).qZy > 0L)
          {
            ((g.a)localObject1).qZA += com.tencent.mm.sdk.platformtools.bo.av(((g.a)localObject1).qZy);
            ((g.a)localObject1).qZy = 0L;
          }
        }
      }
    }
    AppMethodBeat.o(35733);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(35722);
    long l = com.tencent.mm.sdk.platformtools.bo.yB();
    Iterator localIterator = this.qZh.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (g.a)this.qZh.get(localObject2);
      ab.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((g.a)localObject1).qZw = l;
      localObject2 = (h)this.qZf.get(Long.valueOf(((g.a)localObject1).qYx));
      if (localObject2 != null) {
        ((h)localObject2).onResume();
      }
      localObject1 = (h)this.qZg.get(Long.valueOf(((g.a)localObject1).qYx));
      if (localObject1 != null) {
        ((h)localObject1).onResume();
      }
    }
    localIterator = this.qZd.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (a)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (ag.rgi))
      {
        ((a)localObject1).kY(false);
        if ((!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(((a)localObject1).ctV)) && (this.qZh.get(((a)localObject1).ctV) != null))
        {
          localObject2 = (g.a)this.qZh.get(((a)localObject1).ctV);
          if (((a)localObject1).cnE()) {
            ((g.a)localObject2).qZy = com.tencent.mm.sdk.platformtools.bo.yB();
          }
        }
      }
    }
    AppMethodBeat.o(35722);
  }
  
  public final void v(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35723);
    al.d(new g.1(this, paramLong, paramBoolean));
    AppMethodBeat.o(35723);
  }
  
  public final void w(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35725);
    a(paramLong, 0, paramBoolean, false);
    AppMethodBeat.o(35725);
  }
  
  public final void x(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35727);
    c(paramLong, paramBoolean, false);
    AppMethodBeat.o(35727);
  }
  
  public final void y(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35732);
    h localh;
    if (paramBoolean)
    {
      if (this.qZg.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.qZg.get(Long.valueOf(paramLong));
        localh.Dx(0);
      }
      for (;;)
      {
        this.qZg.put(Long.valueOf(paramLong), localh);
        AppMethodBeat.o(35732);
        return;
        localh = new h("timeline");
      }
    }
    if (this.qZf.containsKey(Long.valueOf(paramLong)))
    {
      localh = (h)this.qZf.get(Long.valueOf(paramLong));
      localh.Dx(0);
    }
    for (;;)
    {
      this.qZf.put(Long.valueOf(paramLong), localh);
      AppMethodBeat.o(35732);
      return;
      localh = new h("timeline");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g
 * JD-Core Version:    0.7.0.1
 */