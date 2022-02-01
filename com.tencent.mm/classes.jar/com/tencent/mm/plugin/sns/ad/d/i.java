package com.tencent.mm.plugin.sns.ad.d;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.b.n;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

public final class i
  implements d
{
  public static Map<String, Integer> xJr;
  private Activity activity;
  public int dbL;
  private int xIz;
  public HashMap<String, Long> xJh;
  public HashSet<Long> xJi;
  private Map<String, Long> xJj;
  private Map<String, Integer> xJk;
  private Map<String, c> xJl;
  public HashSet<Long> xJm;
  public Map<Long, j> xJn;
  public Map<Long, j> xJo;
  public Map<String, a> xJp;
  private Map<String, Integer> xJq;
  private int xJs;
  private View xJt;
  public Map<Long, Integer> xJu;
  public Map<Long, Integer> xJv;
  public HashSet<String> xJw;
  private int xJx;
  
  static
  {
    AppMethodBeat.i(95019);
    xJr = new HashMap();
    AppMethodBeat.o(95019);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(94996);
    this.xJh = new HashMap();
    this.xJi = new HashSet();
    this.xJj = new HashMap();
    this.xJk = new HashMap();
    this.xJl = new HashMap();
    this.xJm = new HashSet();
    this.xJn = new HashMap();
    this.xJo = new HashMap();
    this.xJp = new HashMap();
    this.dbL = 0;
    this.xJq = new HashMap();
    this.xJs = 0;
    this.xIz = 0;
    this.xJt = null;
    this.xJu = new HashMap();
    this.xJv = new HashMap();
    this.xJw = new HashSet();
    this.xJx = -1;
    this.dbL = paramInt;
    AppMethodBeat.o(94996);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(p paramp)
  {
    AppMethodBeat.i(95010);
    if (paramp != null)
    {
      if (this.dbL == 2)
      {
        paramp = paramp.dLS();
        AppMethodBeat.o(95010);
        return paramp;
      }
      paramp = paramp.dFQ();
      AppMethodBeat.o(95010);
      return paramp;
    }
    AppMethodBeat.o(95010);
    return null;
  }
  
  private com.tencent.mm.bw.b g(p paramp)
  {
    AppMethodBeat.i(95011);
    if (paramp != null)
    {
      if (this.dbL == 2)
      {
        paramp = paramp.dME().dLZ();
        AppMethodBeat.o(95011);
        return paramp;
      }
      paramp = paramp.dME().dLX();
      AppMethodBeat.o(95011);
      return paramp;
    }
    AppMethodBeat.o(95011);
    return null;
  }
  
  private com.tencent.mm.bw.b h(p paramp)
  {
    AppMethodBeat.i(95012);
    if (paramp != null)
    {
      if (this.dbL == 2)
      {
        paramp = paramp.dME().dMa();
        AppMethodBeat.o(95012);
        return paramp;
      }
      paramp = paramp.dME().dLY();
      AppMethodBeat.o(95012);
      return paramp;
    }
    AppMethodBeat.o(95012);
    return null;
  }
  
  public final void A(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(94999);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94990);
        if (i.this.wL(paramLong))
        {
          i locali = i.this;
          long l = paramLong;
          boolean bool = this.xJz;
          j localj;
          if (bool) {
            if (locali.xJo.containsKey(Long.valueOf(l))) {
              localj = (j)locali.xJo.get(Long.valueOf(l));
            }
          }
          for (;;)
          {
            localj.xJP = 1;
            localj.xJX.xKY += 1;
            if (!bool) {
              break;
            }
            locali.xJo.put(Long.valueOf(l), localj);
            AppMethodBeat.o(94990);
            return;
            localj = new j("timeline");
            continue;
            if (locali.xJn.containsKey(Long.valueOf(l))) {
              localj = (j)locali.xJn.get(Long.valueOf(l));
            } else {
              localj = new j("timeline");
            }
          }
          locali.xJn.put(Long.valueOf(l), localj);
        }
        AppMethodBeat.o(94990);
      }
    });
    AppMethodBeat.o(94999);
  }
  
  public final void B(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95001);
    a(paramLong, 0, paramBoolean, false);
    AppMethodBeat.o(95001);
  }
  
  public final void C(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95003);
    c(paramLong, paramBoolean, false);
    AppMethodBeat.o(95003);
  }
  
  public final void D(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95008);
    j localj;
    if (paramBoolean)
    {
      if (this.xJo.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.xJo.get(Long.valueOf(paramLong));
        localj.NV(0);
      }
      for (;;)
      {
        this.xJo.put(Long.valueOf(paramLong), localj);
        AppMethodBeat.o(95008);
        return;
        localj = new j("timeline");
      }
    }
    if (this.xJn.containsKey(Long.valueOf(paramLong)))
    {
      localj = (j)this.xJn.get(Long.valueOf(paramLong));
      localj.NV(0);
    }
    for (;;)
    {
      this.xJn.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95008);
      return;
      localj = new j("timeline");
    }
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.xIz = paramInt;
    this.xJt = paramView;
    this.activity = paramActivity;
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95013);
    this.xJi.add(Long.valueOf(paramLong));
    this.xJh.put(paramString, Long.valueOf(paramLong));
    if (this.xJx == -1) {
      if (this.activity != null) {
        break label84;
      }
    }
    p localp;
    label84:
    for (int i = -1;; i = aj.jw(this.activity))
    {
      this.xJx = i;
      localp = af.dHR().auT(paramString);
      if (localp != null) {
        break;
      }
      ac.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
      AppMethodBeat.o(95013);
      return;
    }
    Object localObject1 = (c)this.xJl.get(paramString);
    Object localObject2 = f(localp);
    if (localObject2 != null) {}
    for (String str = ((com.tencent.mm.plugin.sns.storage.a)localObject2).dyy;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (af.xTh))
      {
        paramSnsObject = new c((com.tencent.mm.plugin.sns.storage.a)localObject2, paramString, paramLong, paramView, this.xIz, this.xJt, this.xJx, paramInt3, paramSnsObject, paramInt1, localp.dFR());
        paramSnsObject.xIL = System.currentTimeMillis();
        af.cMM().post(new c.1(paramSnsObject));
        this.xJl.put(paramString, paramSnsObject);
        paramView = paramSnsObject;
        if (!this.xJu.containsKey(Long.valueOf(paramLong)))
        {
          paramView = this.xJu;
          if (localp.field_likeFlag != 1) {
            break label526;
          }
          i = 1;
          paramView.put(Long.valueOf(paramLong), Integer.valueOf(i));
        }
      }
      for (paramView = paramSnsObject;; paramView = (View)localObject1)
      {
        label344:
        long l;
        if ((paramInt2 == 11) && (localp.dLV().FQo.Etz.size() > 1))
        {
          if (this.xJo.containsKey(Long.valueOf(paramLong)))
          {
            paramSnsObject = (j)this.xJo.get(Long.valueOf(paramLong));
            paramSnsObject.xJR = bs.Gn();
            this.xJo.put(Long.valueOf(paramLong), paramSnsObject);
          }
        }
        else
        {
          if (!this.xJw.contains(paramString))
          {
            this.xJw.add(paramString);
            com.tencent.mm.plugin.sns.data.q.m(localp);
          }
          if (!this.xJj.containsKey(paramString)) {
            break label570;
          }
          l = bs.aO(((Long)this.xJj.get(paramString)).longValue());
          if (l >= 1200000L) {
            break label995;
          }
          if (!this.xJk.containsKey(paramString)) {
            break label546;
          }
        }
        label526:
        label546:
        for (i = ((Integer)this.xJk.get(paramString)).intValue();; i = 0)
        {
          if (i < 100) {
            break label552;
          }
          ac.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
          AppMethodBeat.o(95013);
          return;
          i = 0;
          break;
          paramSnsObject = new j("timeline");
          break label344;
        }
        label552:
        this.xJk.put(paramString, Integer.valueOf(i + 1));
        label570:
        label716:
        label741:
        TimeLineObject localTimeLineObject;
        if (!this.xJp.containsKey(paramString))
        {
          this.xJp.put(paramString, new a(bs.Gn(), System.currentTimeMillis(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
          ac.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean);
          if ((paramInt2 != 9) && (paramInt2 != 13) && (paramInt2 != 14)) {
            break label1044;
          }
          if (!this.xJn.containsKey(Long.valueOf(paramLong))) {
            break label1030;
          }
          paramSnsObject = (j)this.xJn.get(Long.valueOf(paramLong));
          paramSnsObject.xJR = bs.Gn();
          this.xJn.put(Long.valueOf(paramLong), paramSnsObject);
          if (!this.xJq.containsKey(paramString))
          {
            ac.i("MicroMsg.SnsAdStatistic", "exposures item ".concat(String.valueOf(paramString)));
            this.xJq.put(paramString, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
          localObject1 = localp.dFR();
          localTimeLineObject = localp.dLV();
          paramSnsObject = null;
          paramString = paramSnsObject;
          if (paramView != null)
          {
            paramString = paramSnsObject;
            if (af.xTh) {
              paramString = paramView.dFF();
            }
          }
          paramSnsObject = localp.dME();
          i = 0;
          if (this.dbL == 0)
          {
            i = paramSnsObject.field_exposureCount + 1;
            paramSnsObject.field_exposureCount = i;
            af.dHU().update(paramSnsObject, new String[0]);
          }
          if (localObject2 != null) {
            break label1178;
          }
          paramSnsObject = "";
          label887:
          localObject2 = new b();
          ((b)localObject2).xIp = paramInt1;
          ((b)localObject2).xIq = localp;
          if (paramView == null) {
            break label1188;
          }
          paramInt1 = paramView.fMu;
          label920:
          ((b)localObject2).xIr = paramInt1;
          if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).dJK()) {
            break label1193;
          }
          paramInt1 = 3;
        }
        for (;;)
        {
          paramString = new f(str, paramInt3, paramString, paramInt1, i, localp.dMF(), g(localp), h(localp), paramSnsObject, (b)localObject2);
          g.agS();
          g.agQ().ghe.a(paramString, 0);
          AppMethodBeat.o(95013);
          return;
          label995:
          this.xJj.put(paramString, Long.valueOf(bs.Gn()));
          this.xJk.put(paramString, Integer.valueOf(0));
          break;
          label1030:
          paramSnsObject = new j("timeline");
          break label716;
          label1044:
          if ((paramInt2 != 11) || (localp.dLV().FQo.Etz.size() <= 0) || (((btz)localp.dLV().FQo.Etz.get(0)).ndI != 6)) {
            break label741;
          }
          if (this.xJn.containsKey(Long.valueOf(paramLong))) {}
          for (paramSnsObject = (j)this.xJn.get(Long.valueOf(paramLong));; paramSnsObject = new j("timeline"))
          {
            paramSnsObject.xJR = bs.Gn();
            paramSnsObject.xJW = true;
            this.xJn.put(Long.valueOf(paramLong), paramSnsObject);
            break;
          }
          label1178:
          paramSnsObject = ((com.tencent.mm.plugin.sns.storage.a)localObject2).yfa;
          break label887;
          label1188:
          paramInt1 = 0;
          break label920;
          label1193:
          if (localp.dMH()) {
            paramInt1 = 6;
          } else if ((localp.dJL()) || (localp.dJM()))
          {
            if ((localTimeLineObject != null) && (localTimeLineObject.FQo.Ety == 15) && (localTimeLineObject.FQv != 1)) {
              paramInt1 = 5;
            } else {
              paramInt1 = 4;
            }
          }
          else if (paramInt2 == 9) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
        }
      }
    }
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95002);
    j localj;
    if (paramBoolean2) {
      if (this.xJo.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.xJo.get(Long.valueOf(paramLong));
        if (paramInt > 0) {
          localj.setDuration(paramInt);
        }
        if (!paramBoolean1) {
          break label161;
        }
      }
    }
    label161:
    for (paramInt = 1;; paramInt = 0)
    {
      localj.xJP = paramInt;
      if (!paramBoolean2) {
        break label166;
      }
      this.xJo.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95002);
      return;
      localj = new j("timeline");
      break;
      if (this.xJn.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.xJn.get(Long.valueOf(paramLong));
        break;
      }
      localj = new j("timeline");
      break;
    }
    label166:
    this.xJn.put(Long.valueOf(paramLong), localj);
    AppMethodBeat.o(95002);
  }
  
  public final void ag(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95005);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94992);
        if (i.this.wL(paramLong1))
        {
          i locali = i.this;
          long l = this.xJC;
          if (!locali.xJm.contains(Long.valueOf(l))) {
            locali.xJm.add(Long.valueOf(l));
          }
        }
        AppMethodBeat.o(94992);
      }
    });
    AppMethodBeat.o(95005);
  }
  
  public final void ah(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(199964);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199961);
        j localj = (j)i.this.xJn.get(Long.valueOf(paramLong1));
        if (localj != null) {
          localj.xKa = this.xJF;
        }
        AppMethodBeat.o(199961);
      }
    });
    AppMethodBeat.o(199964);
  }
  
  public final void c(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95004);
    j localj;
    if (paramBoolean2) {
      if (this.xJo.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.xJo.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label160;
        }
      }
    }
    label160:
    for (localj.xJX.xLb = 2;; localj.xJX.xLb = 1)
    {
      localj.xJX.xLc = 1;
      if (!paramBoolean2) {
        break label172;
      }
      this.xJo.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95004);
      return;
      localj = new j("timeline");
      break;
      if (this.xJn.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.xJn.get(Long.valueOf(paramLong));
        break;
      }
      localj = new j("timeline");
      break;
    }
    label172:
    this.xJn.put(Long.valueOf(paramLong), localj);
    AppMethodBeat.o(95004);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(95016);
    ac.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
    Object localObject1 = new HashSet(this.xJp.keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.xJp.get(localObject2);
      q(((a)localObject2).position, ((a)localObject2).dxq, ((a)localObject2).hTy);
    }
    localObject1 = new HashMap(this.xJq);
    af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94994);
        Iterator localIterator = this.xJE.keySet().iterator();
        e locale;
        p localp;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          locale = af.dHU().Pc(x.avp(str));
          if (locale != null)
          {
            localp = locale.dMb();
            locale.field_localFlag |= 0x80;
            i = (int)(System.currentTimeMillis() / 1000L);
            if (!this.xJE.containsKey(str)) {
              break label181;
            }
            i = ((Integer)this.xJE.get(str)).intValue();
          }
        }
        label181:
        for (;;)
        {
          if (locale.field_exposureTime <= 0) {
            locale.field_exposureTime = i;
          }
          localp.field_localFlag |= 0x80;
          af.dHR().b(localp.field_snsId, localp);
          af.dHU().b(locale.field_snsId, locale);
          break;
          AppMethodBeat.o(94994);
          return;
        }
      }
    });
    this.xJp.clear();
    this.xJq.clear();
    AppMethodBeat.o(95016);
  }
  
  public final void d(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(95007);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94993);
        if (i.this.wL(paramLong1))
        {
          i locali = i.this;
          long l1 = paramLong1;
          long l2 = paramBoolean;
          boolean bool = this.xJz;
          j localj;
          if (bool) {
            if (locali.xJo.containsKey(Long.valueOf(l1))) {
              localj = (j)locali.xJo.get(Long.valueOf(l1));
            }
          }
          for (;;)
          {
            if (localj.xJX.xLd == 0L) {
              localj.xJX.xLd = l2;
            }
            if (!bool) {
              break;
            }
            locali.xJo.put(Long.valueOf(l1), localj);
            AppMethodBeat.o(94993);
            return;
            localj = new j("timeline");
            continue;
            if (locali.xJn.containsKey(Long.valueOf(l1))) {
              localj = (j)locali.xJn.get(Long.valueOf(l1));
            } else {
              localj = new j("timeline");
            }
          }
          locali.xJn.put(Long.valueOf(l1), localj);
        }
        AppMethodBeat.o(94993);
      }
    });
    AppMethodBeat.o(95007);
  }
  
  public final void e(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(95000);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94991);
        i.this.a(paramLong, paramBoolean, this.xJB, this.xJz);
        AppMethodBeat.o(94991);
      }
    });
    AppMethodBeat.o(95000);
  }
  
  public final long ex(String paramString, int paramInt)
  {
    AppMethodBeat.i(94997);
    c localc = (c)this.xJl.get(paramString);
    if (localc != null) {}
    for (long l = localc.xIL;; l = 0L)
    {
      ac.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(94997);
      return l;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(95009);
    Iterator localIterator = this.xJp.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.xJp.get(localObject2);
      ac.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).xJL += bs.aO(((a)localObject1).xJI);
      ((a)localObject1).xJI = 0L;
      localObject2 = (j)this.xJn.get(Long.valueOf(((a)localObject1).xIE));
      if (localObject2 != null) {
        ((j)localObject2).hTD = bs.Gn();
      }
      localObject1 = (j)this.xJo.get(Long.valueOf(((a)localObject1).xIE));
      if (localObject1 != null) {
        ((j)localObject1).hTD = bs.Gn();
      }
    }
    localIterator = this.xJl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (af.xTh))
      {
        ((c)localObject1).qF(false);
        if ((!bs.isNullOrNil(((c)localObject1).dgl)) && (this.xJp.get(((c)localObject1).dgl) != null))
        {
          localObject2 = (a)this.xJp.get(((c)localObject1).dgl);
          long l;
          if (((a)localObject2).xJK > 0L)
          {
            l = bs.aO(((a)localObject2).xJK);
            ((a)localObject2).xJM += l;
            ((a)localObject2).xJK = 0L;
            ac.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).xJM + ", id=" + ((c)localObject1).dgl);
          }
          if (((a)localObject2).xJO > 0L)
          {
            l = bs.aO(((a)localObject2).xJO);
            ((a)localObject2).xJN += l;
            ((a)localObject2).xJO = 0L;
            ac.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).xJN + ", id=" + ((c)localObject1).dgl);
          }
        }
      }
    }
    AppMethodBeat.o(95009);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(94998);
    long l = bs.Gn();
    Iterator localIterator = this.xJp.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.xJp.get(localObject2);
      ac.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).xJI = l;
      localObject2 = (j)this.xJn.get(Long.valueOf(((a)localObject1).xIE));
      if (localObject2 != null) {
        ((j)localObject2).onResume();
      }
      localObject1 = (j)this.xJo.get(Long.valueOf(((a)localObject1).xIE));
      if (localObject1 != null) {
        ((j)localObject1).onResume();
      }
    }
    localIterator = this.xJl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (af.xTh))
      {
        ((c)localObject1).qF(false);
        if ((!bs.isNullOrNil(((c)localObject1).dgl)) && (this.xJp.get(((c)localObject1).dgl) != null))
        {
          localObject2 = (a)this.xJp.get(((c)localObject1).dgl);
          if (((c)localObject1).dFG())
          {
            ((a)localObject2).xJK = bs.Gn();
            ac.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + ((c)localObject1).dgl);
          }
          else if (((c)localObject1).xJf)
          {
            ((a)localObject2).xJO = bs.Gn();
            ac.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + ((c)localObject1).dgl);
          }
        }
      }
    }
    AppMethodBeat.o(94998);
  }
  
  public final void q(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(95014);
    if (this.xJh.containsKey(paramString))
    {
      l1 = ((Long)this.xJh.remove(paramString)).longValue();
      this.xJi.remove(Long.valueOf(l1));
    }
    Object localObject1 = null;
    String str = null;
    c localc = (c)this.xJl.get(paramString);
    Object localObject3 = localObject1;
    Object localObject2 = str;
    label147:
    label879:
    int i;
    if (localc != null)
    {
      localObject3 = localObject1;
      localObject2 = str;
      if (af.xTh)
      {
        localc.gNN = true;
        localc.xIM = System.currentTimeMillis();
        localc.xJe = 0;
        qG(false);
        if (localc.xIH < 0)
        {
          localc.xJc = 2;
          if (localc.xIJ >= 0) {
            break label1224;
          }
          localc.xJd = 2;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(com.tencent.mm.plugin.sns.data.q.wW(localc.xIE) + ",");
          ((StringBuilder)localObject1).append(localc.xID + ",");
          ((StringBuilder)localObject1).append(localc.xJc + ",");
          ((StringBuilder)localObject1).append(localc.xJd + ",");
          ((StringBuilder)localObject1).append(localc.xIZ + ",");
          ((StringBuilder)localObject1).append(localc.xJa + ",");
          ((StringBuilder)localObject1).append(localc.xJb + ",");
          ((StringBuilder)localObject1).append(localc.xIL + ",");
          ((StringBuilder)localObject1).append(localc.xIM + ",");
          if ((localc.xIP > 0L) && (localc.xIS == 0L))
          {
            localc.xIS = System.currentTimeMillis();
            ac.d("MicroMsg.AdViewStatic", "halfExposure old 2, end:" + (localc.xIS - localc.xIP) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.xIP + ",");
          ((StringBuilder)localObject1).append(localc.xIS + ",");
          if ((localc.xIV > 0L) && (localc.xIY == 0L))
          {
            localc.xIY = System.currentTimeMillis();
            ac.d("MicroMsg.AdViewStatic", "fullExposure old 2, end:" + (localc.xIY - localc.xIV) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.xIV + ",");
          ((StringBuilder)localObject1).append(localc.xIY);
          h.a(localc.xIE, (StringBuilder)localObject1);
          ac.i("MicroMsg.AdViewStatic", "report " + ((StringBuilder)localObject1).toString());
          localObject3 = new bt();
          ((bt)localObject3).DOU = localc.xIV;
          ((bt)localObject3).DOV = localc.xIY;
          ((bt)localObject3).xJc = localc.xJc;
          ((bt)localObject3).xJd = localc.xJd;
          ((bt)localObject3).DOP = localc.xIZ;
          ((bt)localObject3).DOQ = localc.xJa;
          ((bt)localObject3).DOR = localc.xJb;
          ((bt)localObject3).DOS = localc.xIP;
          ((bt)localObject3).DOT = localc.xIS;
          ((bt)localObject3).startTime = localc.xIL;
          ((bt)localObject3).endTime = localc.xIM;
          if ((localc.xIG == null) || (!localc.xIG.dJU())) {
            break label1233;
          }
          af.dHL().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
          localObject2 = com.tencent.mm.modelsns.d.ps(730);
          ((com.tencent.mm.modelsns.d)localObject2).Dn(com.tencent.mm.plugin.sns.data.q.wW(localc.xIE)).Dn(localc.xID).pv(localc.xJc).pv(localc.xJd).pv(localc.xIZ).pv(localc.xJa).pv(localc.xJb).Dn(localc.xIL).Dn(localc.xIM).Dn(localc.xIP).Dn(localc.xIS).Dn(localc.xIV).Dn(localc.xIY);
          ((com.tencent.mm.modelsns.d)localObject2).aHZ();
          localObject2 = new mp();
          ((mp)localObject2).dpf.position = localc.position;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          if (!ab.iwn) {
            break label1281;
          }
          j = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
          ac.i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(j)));
          i = 0;
          label1159:
          if (i >= j) {
            break label1281;
          }
          if ((localc.xIG == null) || (!localc.xIG.dJU())) {
            break label1257;
          }
          af.dHL().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        for (;;)
        {
          i += 1;
          break label1159;
          localc.xJc = 1;
          break;
          label1224:
          localc.xJd = 1;
          break label147;
          label1233:
          af.dHL().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
          break label879;
          label1257:
          af.dHL().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        label1281:
        localObject2 = localc.dFF();
        this.xJl.remove(paramString);
      }
    }
    this.xJw.remove(paramString);
    int m = 0;
    int j = 0;
    p localp = af.dHR().auT(paramString);
    label1429:
    int k;
    label1474:
    long l3;
    long l2;
    if (localp != null)
    {
      i = j;
      if (this.xJo.containsKey(Long.valueOf(localp.field_snsId)))
      {
        i = j;
        if (localp.dLV().FQo.Ety == 27)
        {
          if (localp.field_likeFlag != 1) {
            break label1854;
          }
          i = 2;
          if (!this.xJv.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1860;
          }
          j = ((Integer)this.xJv.get(Long.valueOf(localp.field_snsId))).intValue();
          if (!this.xJu.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1866;
          }
          k = ((Integer)this.xJu.get(Long.valueOf(localp.field_snsId))).intValue();
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          localObject1 = (j)this.xJo.remove(Long.valueOf(localp.field_snsId));
          if (localObject1 != null)
          {
            ((j)localObject1).NV(0);
            ((j)localObject1).dFI();
            l3 = ((j)localObject1).xJV;
            l2 = ((j)localObject1).xJU;
            l1 = ((j)localObject1).urm * 1000L;
          }
          str = localp.dLV().Id;
          localObject4 = localp.dMD();
          if (localp.field_likeFlag != 1) {
            break label1872;
          }
        }
      }
    }
    a locala;
    label1854:
    label1860:
    label1866:
    label1872:
    for (localObject1 = "1";; localObject1 = "0")
    {
      localObject1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, localObject4, String.valueOf(paramInt2), String.valueOf(j), String.valueOf(k), String.valueOf(l3), String.valueOf(l2), String.valueOf(l1), localObject1 });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(15155, (String)localObject1);
      ac.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[] { localObject1 });
      this.xJm.remove(Long.valueOf(localp.field_snsId));
      this.xJm.remove(Long.valueOf(localp.field_snsId + 1L));
      this.xJv.remove(Long.valueOf(localp.field_snsId));
      this.xJu.remove(Long.valueOf(localp.field_snsId));
      m = i;
      if (!this.xJp.containsKey(paramString)) {
        break label3020;
      }
      str = "";
      if (f(localp) != null) {
        str = f(localp).dyy;
      }
      locala = (a)this.xJp.remove(paramString);
      this.xJj.put(paramString, Long.valueOf(bs.Gn()));
      if (locala != null) {
        break label1880;
      }
      AppMethodBeat.o(95014);
      return;
      i = 1;
      break;
      j = 0;
      break label1429;
      k = 0;
      break label1474;
    }
    label1880:
    long l1 = bs.aO(locala.xJG);
    if (locala.xJI > 0L) {
      locala.xJL += bs.aO(locala.xJI);
    }
    ac.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + paramInt1 + " " + paramString + " " + l1 + " ");
    if (localp == null)
    {
      AppMethodBeat.o(95014);
      return;
    }
    localObject1 = "";
    Object localObject4 = localp.dLV();
    label2029:
    Object localObject6;
    if (localp.dFR().dJK())
    {
      i = 3;
      localObject1 = "";
      localObject4 = f(localp);
      if (localObject4 == null)
      {
        localObject4 = "";
        localObject6 = new b();
        ((b)localObject6).xIp = paramInt1;
        ((b)localObject6).xIq = localp;
        if (localc == null) {
          break label3015;
        }
        paramInt1 = localc.fMu;
        label2062:
        ((b)localObject6).xIr = paramInt1;
        ((b)localObject6).xIt = locala.xJM;
        ((b)localObject6).xIs = locala.xJN;
        ac.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime result=" + locala.xJM + ", id=" + paramString);
        ac.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime result=" + locala.xJN + ", id=" + paramString);
        paramString = new f(str, paramInt2, 2, (int)l1, (bt)localObject3, (bw)localObject2, i, (String)localObject1, -1, localp.dMF(), (int)locala.xJL, (int)locala.xJM, m, g(localp), h(localp), (String)localObject4, (b)localObject6);
        g.agS();
        g.agQ().ghe.a(paramString, 0);
        AppMethodBeat.o(95014);
      }
    }
    else if (localp.dMH())
    {
      i = 6;
      localObject1 = (j)this.xJn.remove(Long.valueOf(locala.xIE));
      if (localObject1 == null) {
        break label3076;
      }
      if (localp.field_likeFlag == 0) {
        ((j)localObject1).NV(0);
      }
    }
    label2488:
    label2496:
    label3015:
    label3020:
    for (localObject1 = ((j)localObject1).dFH();; localObject1 = "")
    {
      break;
      if ((localp.dJL()) || (localp.dJM())) {
        if ((localObject4 != null) && (((TimeLineObject)localObject4).FQo.Ety == 15) && (((TimeLineObject)localObject4).FQv != 1))
        {
          localObject4 = (j)this.xJn.remove(Long.valueOf(locala.xIE));
          if (localObject4 == null) {
            break label3068;
          }
          ((j)localObject4).NV(0);
        }
      }
      label2905:
      label3068:
      for (localObject1 = ((j)localObject4).dFH();; localObject1 = "")
      {
        this.xJm.remove(Long.valueOf(locala.xIE));
        if (localp.dFR() != null)
        {
          localObject6 = localp.dFR();
          if ((((com.tencent.mm.plugin.sns.storage.b)localObject6).dJM()) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).ygn != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).ygn.yhh != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).ygn.yhh.yhy > 0) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).ygn.yhh.yhz > ((com.tencent.mm.plugin.sns.storage.b)localObject6).ygn.yhh.yhy))
          {
            i = 1;
            if (i == 0) {
              break label2812;
            }
            i = 1;
            if (i == 0) {
              break label2905;
            }
            i = 0;
            j = 0;
            if ((localObject4 == null) || (((j)localObject4).xJY == null) || (((j)localObject4).xJY.size() <= 0)) {
              break label2856;
            }
            j = i;
          }
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              n = ((j)localObject4).xJY.size() - 1;
              j = i;
              localObject6 = (com.tencent.mm.plugin.sns.ad.d.a.a)((j)localObject4).xJY.get(n);
              j = i;
              i = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject6).xKY;
              j = i;
              k = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject6).xKZ;
            }
            catch (Exception localException1)
            {
              int n;
              label2812:
              k = 0;
            }
            for (;;)
            {
              try
              {
                ac.i("MicroMsg.SnsAdStatistic", "longPressGestureAd, playitems.size=" + ((j)localObject4).xJY.size() + ", lastIdx=" + n);
                j = i;
                i = k;
                if (this.dbL == 0) {
                  k = 1;
                }
              }
              catch (Exception localException3)
              {
                Object localObject5;
                j = i;
                continue;
              }
              try
              {
                localObject4 = new JSONObject();
                ((JSONObject)localObject4).put("snsid", localp.field_snsId);
                ((JSONObject)localObject4).put("uxinfo", bs.nullAsNil(localp.dFQ().dtx));
                ((JSONObject)localObject4).put("scene", k);
                localObject6 = new JSONObject();
                ((JSONObject)localObject6).put("playCount", j);
                ((JSONObject)localObject6).put("playTotalTime", i);
                ((JSONObject)localObject4).put("extInfo", localObject6);
                localObject4 = ((JSONObject)localObject4).toString();
                com.tencent.mm.plugin.sns.data.j.iU("timeline_fullcard_longpress_exposure", (String)localObject4);
                ac.i("SnsAdPressGestureCtrl", "reportVideoPlay, content=" + (String)localObject4 + ", channel=timeline_fullcard_longpress_exposure");
                i = 5;
              }
              catch (Exception localException2)
              {
                ac.i("SnsAdPressGestureCtrl", "reportVideoPlay, exp=" + localException2.toString());
              }
            }
          }
          i = 0;
          break label2488;
          i = 0;
          break label2496;
          ac.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, reportVideoPlay exp=" + localException1.toString());
          i = k;
          continue;
          ac.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, advideo.playitems is Empty");
          i = 0;
          continue;
          k = 2;
        }
        i = 5;
        break;
        i = 4;
        localObject1 = "";
        break;
        if (locala.oeH == 9)
        {
          i = 2;
          localObject5 = (j)this.xJn.remove(Long.valueOf(locala.xIE));
          if (localObject5 != null)
          {
            ((j)localObject5).NV(0);
            localObject1 = ((j)localObject5).dFH();
          }
          this.xJm.remove(Long.valueOf(locala.xIE));
          break;
        }
        i = 1;
        localObject1 = "";
        break;
        localObject5 = ((com.tencent.mm.plugin.sns.storage.a)localObject5).yfa;
        break label2029;
        paramInt1 = 0;
        break label2062;
        ac.w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + paramInt1 + " " + paramString);
        AppMethodBeat.o(95014);
        return;
      }
    }
  }
  
  public final void qG(boolean paramBoolean)
  {
    AppMethodBeat.i(95015);
    ac.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.xJl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localc != null) && (af.xTh))
      {
        localc.qF(paramBoolean);
        if ((!bs.isNullOrNil(localc.dgl)) && (this.xJp.get(localc.dgl) != null))
        {
          a locala = (a)this.xJp.get(localc.dgl);
          boolean bool = localc.dFG();
          if ((bool) && (locala.xJK == 0L))
          {
            locala.xJK = bs.Gn();
            ac.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + localc.dgl);
          }
          long l;
          for (;;)
          {
            bool = localc.xJf;
            if ((!bool) || (locala.xJO != 0L)) {
              break label326;
            }
            locala.xJO = bs.Gn();
            ac.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + localc.dgl);
            break;
            if ((!bool) && (locala.xJK > 0L))
            {
              l = bs.aO(locala.xJK);
              locala.xJM += l;
              locala.xJK = 0L;
              ac.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + locala.xJM);
            }
          }
          label326:
          if ((!bool) && (locala.xJO > 0L))
          {
            l = bs.aO(locala.xJO);
            locala.xJN += l;
            locala.xJO = 0L;
            ac.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + locala.xJN);
          }
        }
      }
    }
    AppMethodBeat.o(95015);
  }
  
  public final boolean wL(long paramLong)
  {
    AppMethodBeat.i(94995);
    boolean bool = this.xJi.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(94995);
    return bool;
  }
  
  public final boolean wM(long paramLong)
  {
    AppMethodBeat.i(95006);
    if (this.xJm.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95006);
      return true;
    }
    AppMethodBeat.o(95006);
    return false;
  }
  
  public final void wN(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = 0;
    if (this.xJu.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.xJu.get(Long.valueOf(paramLong))).intValue();
    }
    this.xJu.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95017);
  }
  
  public final void wO(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = 0;
    if (this.xJv.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.xJv.get(Long.valueOf(paramLong))).intValue();
    }
    this.xJv.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95018);
  }
  
  public final void wP(final long paramLong)
  {
    AppMethodBeat.i(199962);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199959);
        j localj = (j)i.this.xJn.get(Long.valueOf(paramLong));
        if (localj != null) {
          localj.dFJ();
        }
        AppMethodBeat.o(199959);
      }
    });
    AppMethodBeat.o(199962);
  }
  
  public final void wQ(final long paramLong)
  {
    AppMethodBeat.i(199963);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199960);
        j localj = (j)i.this.xJn.get(Long.valueOf(paramLong));
        if ((localj != null) && (!i.a(i.this))) {
          localj.dER();
        }
        AppMethodBeat.o(199960);
      }
    });
    AppMethodBeat.o(199963);
  }
  
  public final long wR(long paramLong)
  {
    AppMethodBeat.i(199965);
    try
    {
      j localj = (j)this.xJn.get(Long.valueOf(paramLong));
      if (localj != null)
      {
        paramLong = localj.xKa;
        AppMethodBeat.o(199965);
        return paramLong;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + localThrowable.toString());
      AppMethodBeat.o(199965);
    }
    return 0L;
  }
  
  static final class a
  {
    public String dxq;
    public int hTy;
    public int oeH;
    public int position;
    public long xIE;
    public long xJG;
    public long xJH;
    public long xJI;
    public String xJJ;
    public long xJK;
    public long xJL;
    public long xJM;
    public long xJN;
    public long xJO;
    
    public a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3, int paramInt3)
    {
      this.xJG = paramLong1;
      this.xJH = paramLong2;
      this.xJI = paramLong1;
      this.dxq = paramString1;
      this.position = paramInt1;
      this.xJJ = paramString2;
      this.xIE = paramLong3;
      this.oeH = paramInt2;
      this.hTy = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.i
 * JD-Core Version:    0.7.0.1
 */