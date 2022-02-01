package com.tencent.mm.plugin.sns.a.b;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
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
  public static Map<String, Integer> wxQ;
  private Activity activity;
  public int dep;
  private int wwY;
  public HashMap<String, Long> wxG;
  public HashSet<Long> wxH;
  private Map<String, Long> wxI;
  private Map<String, Integer> wxJ;
  private Map<String, c> wxK;
  public HashSet<Long> wxL;
  public Map<Long, j> wxM;
  public Map<Long, j> wxN;
  public Map<String, a> wxO;
  private Map<String, Integer> wxP;
  private int wxR;
  private View wxS;
  public Map<Long, Integer> wxT;
  public Map<Long, Integer> wxU;
  public HashSet<String> wxV;
  private int wxW;
  
  static
  {
    AppMethodBeat.i(95019);
    wxQ = new HashMap();
    AppMethodBeat.o(95019);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(94996);
    this.wxG = new HashMap();
    this.wxH = new HashSet();
    this.wxI = new HashMap();
    this.wxJ = new HashMap();
    this.wxK = new HashMap();
    this.wxL = new HashSet();
    this.wxM = new HashMap();
    this.wxN = new HashMap();
    this.wxO = new HashMap();
    this.dep = 0;
    this.wxP = new HashMap();
    this.wxR = 0;
    this.wwY = 0;
    this.wxS = null;
    this.wxT = new HashMap();
    this.wxU = new HashMap();
    this.wxV = new HashSet();
    this.wxW = -1;
    this.dep = paramInt;
    AppMethodBeat.o(94996);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(p paramp)
  {
    AppMethodBeat.i(95010);
    if (paramp != null)
    {
      if (this.dep == 2)
      {
        paramp = paramp.dxv();
        AppMethodBeat.o(95010);
        return paramp;
      }
      paramp = paramp.dxu();
      AppMethodBeat.o(95010);
      return paramp;
    }
    AppMethodBeat.o(95010);
    return null;
  }
  
  private com.tencent.mm.bx.b g(p paramp)
  {
    AppMethodBeat.i(95011);
    if (paramp != null)
    {
      if (this.dep == 2)
      {
        paramp = paramp.dyh().dxC();
        AppMethodBeat.o(95011);
        return paramp;
      }
      paramp = paramp.dyh().dxA();
      AppMethodBeat.o(95011);
      return paramp;
    }
    AppMethodBeat.o(95011);
    return null;
  }
  
  private com.tencent.mm.bx.b h(p paramp)
  {
    AppMethodBeat.i(95012);
    if (paramp != null)
    {
      if (this.dep == 2)
      {
        paramp = paramp.dyh().dxD();
        AppMethodBeat.o(95012);
        return paramp;
      }
      paramp = paramp.dyh().dxB();
      AppMethodBeat.o(95012);
      return paramp;
    }
    AppMethodBeat.o(95012);
    return null;
  }
  
  public final void A(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(94999);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94990);
        if (i.this.si(paramLong))
        {
          i locali = i.this;
          long l = paramLong;
          boolean bool = this.wxY;
          j localj;
          if (bool) {
            if (locali.wxN.containsKey(Long.valueOf(l))) {
              localj = (j)locali.wxN.get(Long.valueOf(l));
            }
          }
          for (;;)
          {
            localj.wyo = 1;
            localj.wyw.wzx += 1;
            if (!bool) {
              break;
            }
            locali.wxN.put(Long.valueOf(l), localj);
            AppMethodBeat.o(94990);
            return;
            localj = new j("timeline");
            continue;
            if (locali.wxM.containsKey(Long.valueOf(l))) {
              localj = (j)locali.wxM.get(Long.valueOf(l));
            } else {
              localj = new j("timeline");
            }
          }
          locali.wxM.put(Long.valueOf(l), localj);
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
    e(paramLong, paramBoolean, false);
    AppMethodBeat.o(95003);
  }
  
  public final void D(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95008);
    j localj;
    if (paramBoolean)
    {
      if (this.wxN.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.wxN.get(Long.valueOf(paramLong));
        localj.LV(0);
      }
      for (;;)
      {
        this.wxN.put(Long.valueOf(paramLong), localj);
        AppMethodBeat.o(95008);
        return;
        localj = new j("timeline");
      }
    }
    if (this.wxM.containsKey(Long.valueOf(paramLong)))
    {
      localj = (j)this.wxM.get(Long.valueOf(paramLong));
      localj.LV(0);
    }
    for (;;)
    {
      this.wxM.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95008);
      return;
      localj = new j("timeline");
    }
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.wwY = paramInt;
    this.wxS = paramView;
    this.activity = paramActivity;
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95013);
    this.wxH.add(Long.valueOf(paramLong));
    this.wxG.put(paramString, Long.valueOf(paramLong));
    if (this.wxW == -1) {
      if (this.activity != null) {
        break label84;
      }
    }
    p localp;
    label84:
    for (int i = -1;; i = ai.jl(this.activity))
    {
      this.wxW = i;
      localp = af.dtu().apK(paramString);
      if (localp != null) {
        break;
      }
      ad.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
      AppMethodBeat.o(95013);
      return;
    }
    Object localObject1 = (c)this.wxK.get(paramString);
    Object localObject2 = f(localp);
    if (localObject2 != null) {}
    for (String str = ((com.tencent.mm.plugin.sns.storage.a)localObject2).dAM;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (af.wGN))
      {
        paramSnsObject = new c((com.tencent.mm.plugin.sns.storage.a)localObject2, paramString, paramLong, paramView, this.wwY, this.wxS, this.wxW, paramInt3, paramSnsObject, paramInt1, localp.dxs());
        paramSnsObject.wxk = System.currentTimeMillis();
        af.czA().post(new c.1(paramSnsObject));
        this.wxK.put(paramString, paramSnsObject);
        paramView = paramSnsObject;
        if (!this.wxT.containsKey(Long.valueOf(paramLong)))
        {
          paramView = this.wxT;
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
        if ((paramInt2 == 11) && (localp.dxy().Etm.DaC.size() > 1))
        {
          if (this.wxN.containsKey(Long.valueOf(paramLong)))
          {
            paramSnsObject = (j)this.wxN.get(Long.valueOf(paramLong));
            paramSnsObject.wyq = bt.GC();
            this.wxN.put(Long.valueOf(paramLong), paramSnsObject);
          }
        }
        else
        {
          if (!this.wxV.contains(paramString))
          {
            this.wxV.add(paramString);
            com.tencent.mm.plugin.sns.data.q.m(localp);
          }
          if (!this.wxI.containsKey(paramString)) {
            break label570;
          }
          l = bt.aS(((Long)this.wxI.get(paramString)).longValue());
          if (l >= 1200000L) {
            break label995;
          }
          if (!this.wxJ.containsKey(paramString)) {
            break label546;
          }
        }
        label526:
        label546:
        for (i = ((Integer)this.wxJ.get(paramString)).intValue();; i = 0)
        {
          if (i < 100) {
            break label552;
          }
          ad.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
          AppMethodBeat.o(95013);
          return;
          i = 0;
          break;
          paramSnsObject = new j("timeline");
          break label344;
        }
        label552:
        this.wxJ.put(paramString, Integer.valueOf(i + 1));
        label570:
        label716:
        label741:
        TimeLineObject localTimeLineObject;
        if (!this.wxO.containsKey(paramString))
        {
          this.wxO.put(paramString, new a(bt.GC(), System.currentTimeMillis(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
          ad.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean);
          if ((paramInt2 != 9) && (paramInt2 != 13) && (paramInt2 != 14)) {
            break label1044;
          }
          if (!this.wxM.containsKey(Long.valueOf(paramLong))) {
            break label1030;
          }
          paramSnsObject = (j)this.wxM.get(Long.valueOf(paramLong));
          paramSnsObject.wyq = bt.GC();
          this.wxM.put(Long.valueOf(paramLong), paramSnsObject);
          if (!this.wxP.containsKey(paramString))
          {
            ad.i("MicroMsg.SnsAdStatistic", "exposures item ".concat(String.valueOf(paramString)));
            this.wxP.put(paramString, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
          localObject1 = localp.dxs();
          localTimeLineObject = localp.dxy();
          paramSnsObject = null;
          paramString = paramSnsObject;
          if (paramView != null)
          {
            paramString = paramSnsObject;
            if (af.wGN) {
              paramString = paramView.drt();
            }
          }
          paramSnsObject = localp.dyh();
          i = 0;
          if (this.dep == 0)
          {
            i = paramSnsObject.field_exposureCount + 1;
            paramSnsObject.field_exposureCount = i;
            af.dtx().update(paramSnsObject, new String[0]);
          }
          if (localObject2 != null) {
            break label1178;
          }
          paramSnsObject = "";
          label887:
          localObject2 = new b();
          ((b)localObject2).wwO = paramInt1;
          ((b)localObject2).wwP = localp;
          if (paramView == null) {
            break label1188;
          }
          paramInt1 = paramView.fIO;
          label920:
          ((b)localObject2).wwQ = paramInt1;
          if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).dvl()) {
            break label1193;
          }
          paramInt1 = 3;
        }
        for (;;)
        {
          paramString = new f(str, paramInt3, paramString, paramInt1, i, localp.dyi(), g(localp), h(localp), paramSnsObject, (b)localObject2);
          g.afC();
          g.afA().gcy.a(paramString, 0);
          AppMethodBeat.o(95013);
          return;
          label995:
          this.wxI.put(paramString, Long.valueOf(bt.GC()));
          this.wxJ.put(paramString, Integer.valueOf(0));
          break;
          label1030:
          paramSnsObject = new j("timeline");
          break label716;
          label1044:
          if ((paramInt2 != 11) || (localp.dxy().Etm.DaC.size() <= 0) || (((bpi)localp.dxy().Etm.DaC.get(0)).mBH != 6)) {
            break label741;
          }
          if (this.wxM.containsKey(Long.valueOf(paramLong))) {}
          for (paramSnsObject = (j)this.wxM.get(Long.valueOf(paramLong));; paramSnsObject = new j("timeline"))
          {
            paramSnsObject.wyq = bt.GC();
            paramSnsObject.wyv = true;
            this.wxM.put(Long.valueOf(paramLong), paramSnsObject);
            break;
          }
          label1178:
          paramSnsObject = ((com.tencent.mm.plugin.sns.storage.a)localObject2).wSu;
          break label887;
          label1188:
          paramInt1 = 0;
          break label920;
          label1193:
          if (localp.dyk()) {
            paramInt1 = 6;
          } else if ((localp.dvm()) || (localp.dvn()))
          {
            if ((localTimeLineObject != null) && (localTimeLineObject.Etm.DaB == 15) && (localTimeLineObject.Ett != 1)) {
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
      if (this.wxN.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.wxN.get(Long.valueOf(paramLong));
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
      localj.wyo = paramInt;
      if (!paramBoolean2) {
        break label166;
      }
      this.wxN.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95002);
      return;
      localj = new j("timeline");
      break;
      if (this.wxM.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.wxM.get(Long.valueOf(paramLong));
        break;
      }
      localj = new j("timeline");
      break;
    }
    label166:
    this.wxM.put(Long.valueOf(paramLong), localj);
    AppMethodBeat.o(95002);
  }
  
  public final void aj(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95005);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94992);
        if (i.this.si(paramLong1))
        {
          i locali = i.this;
          long l = this.wyb;
          if (!locali.wxL.contains(Long.valueOf(l))) {
            locali.wxL.add(Long.valueOf(l));
          }
        }
        AppMethodBeat.o(94992);
      }
    });
    AppMethodBeat.o(95005);
  }
  
  public final void ak(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187238);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187235);
        j localj = (j)i.this.wxM.get(Long.valueOf(paramLong1));
        if (localj != null) {
          localj.wyz = this.wye;
        }
        AppMethodBeat.o(187235);
      }
    });
    AppMethodBeat.o(187238);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(95016);
    ad.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
    Object localObject1 = new HashSet(this.wxO.keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.wxO.get(localObject2);
      o(((a)localObject2).position, ((a)localObject2).dzE, ((a)localObject2).hsW);
    }
    localObject1 = new HashMap(this.wxP);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94994);
        Iterator localIterator = this.wyd.keySet().iterator();
        e locale;
        p localp;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          locale = af.dtx().MZ(x.aqg(str));
          if (locale != null)
          {
            localp = locale.dxE();
            locale.field_localFlag |= 0x80;
            i = (int)(System.currentTimeMillis() / 1000L);
            if (!this.wyd.containsKey(str)) {
              break label181;
            }
            i = ((Integer)this.wyd.get(str)).intValue();
          }
        }
        label181:
        for (;;)
        {
          if (locale.field_exposureTime <= 0) {
            locale.field_exposureTime = i;
          }
          localp.field_localFlag |= 0x80;
          af.dtu().b(localp.field_snsId, localp);
          af.dtx().b(locale.field_snsId, locale);
          break;
          AppMethodBeat.o(94994);
          return;
        }
      }
    });
    this.wxO.clear();
    this.wxP.clear();
    AppMethodBeat.o(95016);
  }
  
  public final void d(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(95007);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94993);
        if (i.this.si(paramLong1))
        {
          i locali = i.this;
          long l1 = paramLong1;
          long l2 = paramBoolean;
          boolean bool = this.wxY;
          j localj;
          if (bool) {
            if (locali.wxN.containsKey(Long.valueOf(l1))) {
              localj = (j)locali.wxN.get(Long.valueOf(l1));
            }
          }
          for (;;)
          {
            if (localj.wyw.wzC == 0L) {
              localj.wyw.wzC = l2;
            }
            if (!bool) {
              break;
            }
            locali.wxN.put(Long.valueOf(l1), localj);
            AppMethodBeat.o(94993);
            return;
            localj = new j("timeline");
            continue;
            if (locali.wxM.containsKey(Long.valueOf(l1))) {
              localj = (j)locali.wxM.get(Long.valueOf(l1));
            } else {
              localj = new j("timeline");
            }
          }
          locali.wxM.put(Long.valueOf(l1), localj);
        }
        AppMethodBeat.o(94993);
      }
    });
    AppMethodBeat.o(95007);
  }
  
  public final void e(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(95000);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94991);
        i.this.a(paramLong, paramBoolean, this.wya, this.wxY);
        AppMethodBeat.o(94991);
      }
    });
    AppMethodBeat.o(95000);
  }
  
  public final void e(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95004);
    j localj;
    if (paramBoolean2) {
      if (this.wxN.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.wxN.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label160;
        }
      }
    }
    label160:
    for (localj.wyw.wzA = 2;; localj.wyw.wzA = 1)
    {
      localj.wyw.wzB = 1;
      if (!paramBoolean2) {
        break label172;
      }
      this.wxN.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95004);
      return;
      localj = new j("timeline");
      break;
      if (this.wxM.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.wxM.get(Long.valueOf(paramLong));
        break;
      }
      localj = new j("timeline");
      break;
    }
    label172:
    this.wxM.put(Long.valueOf(paramLong), localj);
    AppMethodBeat.o(95004);
  }
  
  public final long ep(String paramString, int paramInt)
  {
    AppMethodBeat.i(94997);
    c localc = (c)this.wxK.get(paramString);
    if (localc != null) {}
    for (long l = localc.wxk;; l = 0L)
    {
      ad.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(94997);
      return l;
    }
  }
  
  public final void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(95014);
    if (this.wxG.containsKey(paramString))
    {
      l1 = ((Long)this.wxG.remove(paramString)).longValue();
      this.wxH.remove(Long.valueOf(l1));
    }
    Object localObject1 = null;
    String str = null;
    c localc = (c)this.wxK.get(paramString);
    Object localObject3 = localObject1;
    Object localObject2 = str;
    label147:
    label879:
    int i;
    if (localc != null)
    {
      localObject3 = localObject1;
      localObject2 = str;
      if (af.wGN)
      {
        localc.gna = true;
        localc.wxl = System.currentTimeMillis();
        localc.wxD = 0;
        pH(false);
        if (localc.wxg < 0)
        {
          localc.wxB = 2;
          if (localc.wxi >= 0) {
            break label1224;
          }
          localc.wxC = 2;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(com.tencent.mm.plugin.sns.data.q.st(localc.wxd) + ",");
          ((StringBuilder)localObject1).append(localc.wxc + ",");
          ((StringBuilder)localObject1).append(localc.wxB + ",");
          ((StringBuilder)localObject1).append(localc.wxC + ",");
          ((StringBuilder)localObject1).append(localc.wxy + ",");
          ((StringBuilder)localObject1).append(localc.wxz + ",");
          ((StringBuilder)localObject1).append(localc.wxA + ",");
          ((StringBuilder)localObject1).append(localc.wxk + ",");
          ((StringBuilder)localObject1).append(localc.wxl + ",");
          if ((localc.wxo > 0L) && (localc.wxr == 0L))
          {
            localc.wxr = System.currentTimeMillis();
            ad.d("MicroMsg.AdViewStatic", "halfExposure old 2, end:" + (localc.wxr - localc.wxo) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.wxo + ",");
          ((StringBuilder)localObject1).append(localc.wxr + ",");
          if ((localc.wxu > 0L) && (localc.wxx == 0L))
          {
            localc.wxx = System.currentTimeMillis();
            ad.d("MicroMsg.AdViewStatic", "fullExposure old 2, end:" + (localc.wxx - localc.wxu) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.wxu + ",");
          ((StringBuilder)localObject1).append(localc.wxx);
          h.a(localc.wxd, (StringBuilder)localObject1);
          ad.i("MicroMsg.AdViewStatic", "report " + ((StringBuilder)localObject1).toString());
          localObject3 = new br();
          ((br)localObject3).Cwy = localc.wxu;
          ((br)localObject3).Cwz = localc.wxx;
          ((br)localObject3).wxB = localc.wxB;
          ((br)localObject3).wxC = localc.wxC;
          ((br)localObject3).Cwt = localc.wxy;
          ((br)localObject3).Cwu = localc.wxz;
          ((br)localObject3).Cwv = localc.wxA;
          ((br)localObject3).Cww = localc.wxo;
          ((br)localObject3).Cwx = localc.wxr;
          ((br)localObject3).startTime = localc.wxk;
          ((br)localObject3).endTime = localc.wxl;
          if ((localc.wxf == null) || (!localc.wxf.dvv())) {
            break label1233;
          }
          af.dto().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
          localObject2 = com.tencent.mm.modelsns.d.oE(730);
          ((com.tencent.mm.modelsns.d)localObject2).zi(com.tencent.mm.plugin.sns.data.q.st(localc.wxd)).zi(localc.wxc).oH(localc.wxB).oH(localc.wxC).oH(localc.wxy).oH(localc.wxz).oH(localc.wxA).zi(localc.wxk).zi(localc.wxl).zi(localc.wxo).zi(localc.wxr).zi(localc.wxu).zi(localc.wxx);
          ((com.tencent.mm.modelsns.d)localObject2).aBj();
          localObject2 = new mg();
          ((mg)localObject2).dru.position = localc.position;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          if (!ab.hWj) {
            break label1281;
          }
          j = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
          ad.i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(j)));
          i = 0;
          label1159:
          if (i >= j) {
            break label1281;
          }
          if ((localc.wxf == null) || (!localc.wxf.dvv())) {
            break label1257;
          }
          af.dto().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        for (;;)
        {
          i += 1;
          break label1159;
          localc.wxB = 1;
          break;
          label1224:
          localc.wxC = 1;
          break label147;
          label1233:
          af.dto().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
          break label879;
          label1257:
          af.dto().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        label1281:
        localObject2 = localc.drt();
        this.wxK.remove(paramString);
      }
    }
    this.wxV.remove(paramString);
    int m = 0;
    int j = 0;
    p localp = af.dtu().apK(paramString);
    label1429:
    int k;
    label1474:
    long l3;
    long l2;
    if (localp != null)
    {
      i = j;
      if (this.wxN.containsKey(Long.valueOf(localp.field_snsId)))
      {
        i = j;
        if (localp.dxy().Etm.DaB == 27)
        {
          if (localp.field_likeFlag != 1) {
            break label1854;
          }
          i = 2;
          if (!this.wxU.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1860;
          }
          j = ((Integer)this.wxU.get(Long.valueOf(localp.field_snsId))).intValue();
          if (!this.wxT.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1866;
          }
          k = ((Integer)this.wxT.get(Long.valueOf(localp.field_snsId))).intValue();
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          localObject1 = (j)this.wxN.remove(Long.valueOf(localp.field_snsId));
          if (localObject1 != null)
          {
            ((j)localObject1).LV(0);
            ((j)localObject1).drw();
            l3 = ((j)localObject1).wyu;
            l2 = ((j)localObject1).wyt;
            l1 = ((j)localObject1).tiV * 1000L;
          }
          str = localp.dxy().Id;
          localObject4 = localp.dyg();
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
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(15155, (String)localObject1);
      ad.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[] { localObject1 });
      this.wxL.remove(Long.valueOf(localp.field_snsId));
      this.wxL.remove(Long.valueOf(localp.field_snsId + 1L));
      this.wxU.remove(Long.valueOf(localp.field_snsId));
      this.wxT.remove(Long.valueOf(localp.field_snsId));
      m = i;
      if (!this.wxO.containsKey(paramString)) {
        break label3020;
      }
      str = "";
      if (f(localp) != null) {
        str = f(localp).dAM;
      }
      locala = (a)this.wxO.remove(paramString);
      this.wxI.put(paramString, Long.valueOf(bt.GC()));
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
    long l1 = bt.aS(locala.wyf);
    if (locala.wyh > 0L) {
      locala.wyk += bt.aS(locala.wyh);
    }
    ad.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + paramInt1 + " " + paramString + " " + l1 + " ");
    if (localp == null)
    {
      AppMethodBeat.o(95014);
      return;
    }
    localObject1 = "";
    Object localObject4 = localp.dxy();
    label2029:
    Object localObject6;
    if (localp.dxs().dvl())
    {
      i = 3;
      localObject1 = "";
      localObject4 = f(localp);
      if (localObject4 == null)
      {
        localObject4 = "";
        localObject6 = new b();
        ((b)localObject6).wwO = paramInt1;
        ((b)localObject6).wwP = localp;
        if (localc == null) {
          break label3015;
        }
        paramInt1 = localc.fIO;
        label2062:
        ((b)localObject6).wwQ = paramInt1;
        ((b)localObject6).wwS = locala.wyl;
        ((b)localObject6).wwR = locala.wym;
        ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime result=" + locala.wyl + ", id=" + paramString);
        ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime result=" + locala.wym + ", id=" + paramString);
        paramString = new f(str, paramInt2, 2, (int)l1, (br)localObject3, (bu)localObject2, i, (String)localObject1, -1, localp.dyi(), (int)locala.wyk, (int)locala.wyl, m, g(localp), h(localp), (String)localObject4, (b)localObject6);
        g.afC();
        g.afA().gcy.a(paramString, 0);
        AppMethodBeat.o(95014);
      }
    }
    else if (localp.dyk())
    {
      i = 6;
      localObject1 = (j)this.wxM.remove(Long.valueOf(locala.wxd));
      if (localObject1 == null) {
        break label3076;
      }
      if (localp.field_likeFlag == 0) {
        ((j)localObject1).LV(0);
      }
    }
    label2488:
    label2496:
    label3015:
    label3020:
    for (localObject1 = ((j)localObject1).drv();; localObject1 = "")
    {
      break;
      if ((localp.dvm()) || (localp.dvn())) {
        if ((localObject4 != null) && (((TimeLineObject)localObject4).Etm.DaB == 15) && (((TimeLineObject)localObject4).Ett != 1))
        {
          localObject4 = (j)this.wxM.remove(Long.valueOf(locala.wxd));
          if (localObject4 == null) {
            break label3068;
          }
          ((j)localObject4).LV(0);
        }
      }
      label2905:
      label3068:
      for (localObject1 = ((j)localObject4).drv();; localObject1 = "")
      {
        this.wxL.remove(Long.valueOf(locala.wxd));
        if (localp.dxs() != null)
        {
          localObject6 = localp.dxs();
          if ((((com.tencent.mm.plugin.sns.storage.b)localObject6).dvn()) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).wTD != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).wTD.wUt != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).wTD.wUt.wUK > 0) && (((com.tencent.mm.plugin.sns.storage.b)localObject6).wTD.wUt.wUL > ((com.tencent.mm.plugin.sns.storage.b)localObject6).wTD.wUt.wUK))
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
            if ((localObject4 == null) || (((j)localObject4).wyx == null) || (((j)localObject4).wyx.size() <= 0)) {
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
              n = ((j)localObject4).wyx.size() - 1;
              j = i;
              localObject6 = (com.tencent.mm.plugin.sns.a.b.a.a)((j)localObject4).wyx.get(n);
              j = i;
              i = ((com.tencent.mm.plugin.sns.a.b.a.a)localObject6).wzx;
              j = i;
              k = ((com.tencent.mm.plugin.sns.a.b.a.a)localObject6).wzy;
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
                ad.i("MicroMsg.SnsAdStatistic", "longPressGestureAd, playitems.size=" + ((j)localObject4).wyx.size() + ", lastIdx=" + n);
                j = i;
                i = k;
                if (this.dep == 0) {
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
                ((JSONObject)localObject4).put("uxinfo", bt.nullAsNil(localp.dxu().dvK));
                ((JSONObject)localObject4).put("scene", k);
                localObject6 = new JSONObject();
                ((JSONObject)localObject6).put("playCount", j);
                ((JSONObject)localObject6).put("playTotalTime", i);
                ((JSONObject)localObject4).put("extInfo", localObject6);
                localObject4 = ((JSONObject)localObject4).toString();
                com.tencent.mm.plugin.sns.data.j.ix("timeline_fullcard_longpress_exposure", (String)localObject4);
                ad.i("SnsAdPressGestureCtrl", "reportVideoPlay, content=" + (String)localObject4 + ", channel=timeline_fullcard_longpress_exposure");
                i = 5;
              }
              catch (Exception localException2)
              {
                ad.i("SnsAdPressGestureCtrl", "reportVideoPlay, exp=" + localException2.toString());
              }
            }
          }
          i = 0;
          break label2488;
          i = 0;
          break label2496;
          ad.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, reportVideoPlay exp=" + localException1.toString());
          i = k;
          continue;
          ad.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, advideo.playitems is Empty");
          i = 0;
          continue;
          k = 2;
        }
        i = 5;
        break;
        i = 4;
        localObject1 = "";
        break;
        if (locala.nBH == 9)
        {
          i = 2;
          localObject5 = (j)this.wxM.remove(Long.valueOf(locala.wxd));
          if (localObject5 != null)
          {
            ((j)localObject5).LV(0);
            localObject1 = ((j)localObject5).drv();
          }
          this.wxL.remove(Long.valueOf(locala.wxd));
          break;
        }
        i = 1;
        localObject1 = "";
        break;
        localObject5 = ((com.tencent.mm.plugin.sns.storage.a)localObject5).wSu;
        break label2029;
        paramInt1 = 0;
        break label2062;
        ad.w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + paramInt1 + " " + paramString);
        AppMethodBeat.o(95014);
        return;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(95009);
    Iterator localIterator = this.wxO.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.wxO.get(localObject2);
      ad.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).wyk += bt.aS(((a)localObject1).wyh);
      ((a)localObject1).wyh = 0L;
      localObject2 = (j)this.wxM.get(Long.valueOf(((a)localObject1).wxd));
      if (localObject2 != null) {
        ((j)localObject2).htb = bt.GC();
      }
      localObject1 = (j)this.wxN.get(Long.valueOf(((a)localObject1).wxd));
      if (localObject1 != null) {
        ((j)localObject1).htb = bt.GC();
      }
    }
    localIterator = this.wxK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (af.wGN))
      {
        ((c)localObject1).pG(false);
        if ((!bt.isNullOrNil(((c)localObject1).diQ)) && (this.wxO.get(((c)localObject1).diQ) != null))
        {
          localObject2 = (a)this.wxO.get(((c)localObject1).diQ);
          long l;
          if (((a)localObject2).wyj > 0L)
          {
            l = bt.aS(((a)localObject2).wyj);
            ((a)localObject2).wyl += l;
            ((a)localObject2).wyj = 0L;
            ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).wyl + ", id=" + ((c)localObject1).diQ);
          }
          if (((a)localObject2).wyn > 0L)
          {
            l = bt.aS(((a)localObject2).wyn);
            ((a)localObject2).wym += l;
            ((a)localObject2).wyn = 0L;
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).wym + ", id=" + ((c)localObject1).diQ);
          }
        }
      }
    }
    AppMethodBeat.o(95009);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(94998);
    long l = bt.GC();
    Iterator localIterator = this.wxO.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.wxO.get(localObject2);
      ad.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).wyh = l;
      localObject2 = (j)this.wxM.get(Long.valueOf(((a)localObject1).wxd));
      if (localObject2 != null) {
        ((j)localObject2).onResume();
      }
      localObject1 = (j)this.wxN.get(Long.valueOf(((a)localObject1).wxd));
      if (localObject1 != null) {
        ((j)localObject1).onResume();
      }
    }
    localIterator = this.wxK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (af.wGN))
      {
        ((c)localObject1).pG(false);
        if ((!bt.isNullOrNil(((c)localObject1).diQ)) && (this.wxO.get(((c)localObject1).diQ) != null))
        {
          localObject2 = (a)this.wxO.get(((c)localObject1).diQ);
          if (((c)localObject1).dru())
          {
            ((a)localObject2).wyj = bt.GC();
            ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + ((c)localObject1).diQ);
          }
          else if (((c)localObject1).wxE)
          {
            ((a)localObject2).wyn = bt.GC();
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + ((c)localObject1).diQ);
          }
        }
      }
    }
    AppMethodBeat.o(94998);
  }
  
  public final void pH(boolean paramBoolean)
  {
    AppMethodBeat.i(95015);
    ad.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.wxK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localc != null) && (af.wGN))
      {
        localc.pG(paramBoolean);
        if ((!bt.isNullOrNil(localc.diQ)) && (this.wxO.get(localc.diQ) != null))
        {
          a locala = (a)this.wxO.get(localc.diQ);
          boolean bool = localc.dru();
          if ((bool) && (locala.wyj == 0L))
          {
            locala.wyj = bt.GC();
            ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + localc.diQ);
          }
          long l;
          for (;;)
          {
            bool = localc.wxE;
            if ((!bool) || (locala.wyn != 0L)) {
              break label326;
            }
            locala.wyn = bt.GC();
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + localc.diQ);
            break;
            if ((!bool) && (locala.wyj > 0L))
            {
              l = bt.aS(locala.wyj);
              locala.wyl += l;
              locala.wyj = 0L;
              ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + locala.wyl);
            }
          }
          label326:
          if ((!bool) && (locala.wyn > 0L))
          {
            l = bt.aS(locala.wyn);
            locala.wym += l;
            locala.wyn = 0L;
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + locala.wym);
          }
        }
      }
    }
    AppMethodBeat.o(95015);
  }
  
  public final boolean si(long paramLong)
  {
    AppMethodBeat.i(94995);
    boolean bool = this.wxH.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(94995);
    return bool;
  }
  
  public final boolean sj(long paramLong)
  {
    AppMethodBeat.i(95006);
    if (this.wxL.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95006);
      return true;
    }
    AppMethodBeat.o(95006);
    return false;
  }
  
  public final void sk(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = 0;
    if (this.wxT.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.wxT.get(Long.valueOf(paramLong))).intValue();
    }
    this.wxT.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95017);
  }
  
  public final void sl(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = 0;
    if (this.wxU.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.wxU.get(Long.valueOf(paramLong))).intValue();
    }
    this.wxU.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95018);
  }
  
  public final void sm(final long paramLong)
  {
    AppMethodBeat.i(187236);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187233);
        j localj = (j)i.this.wxM.get(Long.valueOf(paramLong));
        if (localj != null) {
          localj.drx();
        }
        AppMethodBeat.o(187233);
      }
    });
    AppMethodBeat.o(187236);
  }
  
  public final void sn(final long paramLong)
  {
    AppMethodBeat.i(187237);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187234);
        j localj = (j)i.this.wxM.get(Long.valueOf(paramLong));
        if ((localj != null) && (!i.a(i.this))) {
          localj.dqI();
        }
        AppMethodBeat.o(187234);
      }
    });
    AppMethodBeat.o(187237);
  }
  
  public final long so(long paramLong)
  {
    AppMethodBeat.i(187239);
    try
    {
      j localj = (j)this.wxM.get(Long.valueOf(paramLong));
      if (localj != null)
      {
        paramLong = localj.wyz;
        AppMethodBeat.o(187239);
        return paramLong;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + localThrowable.toString());
      AppMethodBeat.o(187239);
    }
    return 0L;
  }
  
  static final class a
  {
    public String dzE;
    public int hsW;
    public int nBH;
    public int position;
    public long wxd;
    public long wyf;
    public long wyg;
    public long wyh;
    public String wyi;
    public long wyj;
    public long wyk;
    public long wyl;
    public long wym;
    public long wyn;
    
    public a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3, int paramInt3)
    {
      this.wyf = paramLong1;
      this.wyg = paramLong2;
      this.wyh = paramLong1;
      this.dzE = paramString1;
      this.position = paramInt1;
      this.wyi = paramString2;
      this.wxd = paramLong3;
      this.nBH = paramInt2;
      this.hsW = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.i
 * JD-Core Version:    0.7.0.1
 */