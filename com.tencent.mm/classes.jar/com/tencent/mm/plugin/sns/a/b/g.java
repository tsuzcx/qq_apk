package com.tencent.mm.plugin.sns.a.b;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.kn;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class g
  implements b
{
  public static Map<String, Integer> olb = new HashMap();
  public Activity activity;
  long iaq = 0L;
  public HashMap<String, Long> okQ = new HashMap();
  public HashSet<Long> okR = new HashSet();
  private Map<String, Long> okS = new HashMap();
  private Map<String, Integer> okT = new HashMap();
  private Map<String, a> okU = new HashMap();
  public HashSet<Long> okV = new HashSet();
  public Map<Long, h> okW = new HashMap();
  public Map<Long, h> okX = new HashMap();
  public Map<String, g.a> okY = new HashMap();
  private LinkedList<String> okZ = new LinkedList();
  public int oki = 0;
  private Map<String, Integer> ola = new HashMap();
  private int olc = 0;
  public View old = null;
  public Map<Long, Integer> ole = new HashMap();
  public Map<Long, Integer> olf = new HashMap();
  private int olg = -1;
  public int source = 0;
  
  public g(int paramInt)
  {
    this.source = paramInt;
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(n paramn)
  {
    if (paramn != null)
    {
      if (this.source == 2) {
        return paramn.bGc();
      }
      return paramn.bGb();
    }
    return null;
  }
  
  private com.tencent.mm.bv.b g(n paramn)
  {
    if (paramn != null)
    {
      if (this.source == 2) {
        return paramn.bGN().bGi();
      }
      return paramn.bGN().bGg();
    }
    return null;
  }
  
  private com.tencent.mm.bv.b h(n paramn)
  {
    if (paramn != null)
    {
      if (this.source == 2) {
        return paramn.bGN().bGj();
      }
      return paramn.bGN().bGh();
    }
    return null;
  }
  
  public final void G(long paramLong1, long paramLong2)
  {
    ai.d(new g.3(this, paramLong1, paramLong2));
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, bto parambto, int paramInt2, int paramInt3)
  {
    this.okR.add(Long.valueOf(paramLong));
    this.okQ.put(paramString, Long.valueOf(paramLong));
    if (this.olg == -1) {
      if (this.activity != null) {
        break label73;
      }
    }
    n localn;
    label73:
    for (int i = -1;; i = ak.gz(this.activity))
    {
      this.olg = i;
      localn = af.bDF().OB(paramString);
      if (localn != null) {
        break;
      }
      y.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
      return;
    }
    Object localObject1 = (a)this.okU.get(paramString);
    Object localObject2 = f(localn);
    if (localObject2 != null) {}
    for (String str = ((com.tencent.mm.plugin.sns.storage.a)localObject2).fVM;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (af.ort))
      {
        paramView = new a((com.tencent.mm.plugin.sns.storage.a)localObject2, paramString, paramLong, paramView, this.oki, this.old, this.olg, paramInt3, parambto, paramInt1, localn.bFZ());
        paramView.okt = System.currentTimeMillis();
        af.aXq().post(new a.1(paramView));
        this.okU.put(paramString, paramView);
        if (!this.ole.containsKey(Long.valueOf(paramLong)))
        {
          parambto = this.ole;
          if (localn.field_likeFlag != 1) {
            break label475;
          }
          i = 1;
          parambto.put(Long.valueOf(paramLong), Integer.valueOf(i));
        }
      }
      for (;;)
      {
        label325:
        long l;
        if ((paramInt2 == 11) && (localn.bGe().tNr.sPJ.size() > 1))
        {
          if (this.okX.containsKey(Long.valueOf(paramLong)))
          {
            parambto = (h)this.okX.get(Long.valueOf(paramLong));
            parambto.olr = bk.UZ();
            this.okX.put(Long.valueOf(paramLong), parambto);
          }
        }
        else
        {
          if (!this.okS.containsKey(paramString)) {
            break label520;
          }
          l = bk.cp(((Long)this.okS.get(paramString)).longValue());
          if (l >= 1200000L) {
            break label878;
          }
          if (!this.okT.containsKey(paramString)) {
            break label496;
          }
        }
        label475:
        label496:
        for (i = ((Integer)this.okT.get(paramString)).intValue();; i = 0)
        {
          if (i < 2) {
            break label502;
          }
          y.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
          return;
          i = 0;
          break;
          parambto = new h("timeline");
          break label325;
        }
        label502:
        this.okT.put(paramString, Integer.valueOf(i + 1));
        label520:
        if (!this.okY.containsKey(paramString))
        {
          this.okY.put(paramString, new g.a(bk.UZ(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
          y.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean);
          if (paramInt2 != 9) {
            break label928;
          }
          if (!this.okW.containsKey(Long.valueOf(paramLong))) {
            break label913;
          }
          parambto = (h)this.okW.get(Long.valueOf(paramLong));
          label649:
          parambto.olr = bk.UZ();
          this.okW.put(Long.valueOf(paramLong), parambto);
          label674:
          if (!this.okZ.contains(paramString))
          {
            this.okZ.add(paramString);
            y.i("MicroMsg.SnsAdStatistic", "exposures item " + paramString);
            this.ola.put(paramString, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
          localObject1 = localn.bFZ();
          localObject2 = localn.bGe();
          parambto = null;
          paramString = parambto;
          if (paramView != null)
          {
            paramString = parambto;
            if (af.ort) {
              paramString = paramView.bCd();
            }
          }
          paramView = localn.bGN();
          paramInt1 = 0;
          if (this.source == 0)
          {
            paramInt1 = paramView.field_exposureCount + 1;
            paramView.field_exposureCount = paramInt1;
            af.bDI().c(paramView, new String[0]);
          }
          if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).bEI()) {
            break label1063;
          }
          paramString = new d(str, paramInt3, paramString, 3, paramInt1, localn.bGO(), g(localn), h(localn));
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
          return;
          label878:
          this.okS.put(paramString, Long.valueOf(bk.UZ()));
          this.okT.put(paramString, Integer.valueOf(0));
          break label520;
          break;
          label913:
          parambto = new h("timeline");
          break label649;
          label928:
          if ((paramInt2 != 11) || (localn.bGe().tNr.sPJ.size() <= 0) || (((awd)localn.bGe().tNr.sPJ.get(0)).hQR != 6)) {
            break label674;
          }
          if (this.okW.containsKey(Long.valueOf(paramLong))) {}
          for (parambto = (h)this.okW.get(Long.valueOf(paramLong));; parambto = new h("timeline"))
          {
            parambto.olr = bk.UZ();
            parambto.olw = true;
            this.okW.put(Long.valueOf(paramLong), parambto);
            break;
          }
          label1063:
          if (localn.bGQ())
          {
            i = localn.bGO();
            if (localn.field_likeFlag == 1) {}
            for (paramInt2 = 2;; paramInt2 = 1)
            {
              paramString = new d(str, paramInt3, 1, 0, null, paramString, 6, "", paramInt1, i, 0, 0, paramInt2, g(localn), h(localn));
              break;
            }
          }
          if ((localn.bEJ()) || (localn.bEK()))
          {
            if ((localObject2 != null) && (((bxk)localObject2).tNr.sPI == 15) && (((bxk)localObject2).tNy != 1)) {
              paramString = new d(str, paramInt3, paramString, 5, paramInt1, localn.bGO(), g(localn), h(localn));
            } else {
              paramString = new d(str, paramInt3, paramString, 4, paramInt1, localn.bGO(), g(localn), h(localn));
            }
          }
          else if (paramInt2 == 9) {
            paramString = new d(str, paramInt3, paramString, 2, paramInt1, localn.bGO(), g(localn), h(localn));
          } else {
            paramString = new d(str, paramInt3, paramString, 1, paramInt1, localn.bGO(), g(localn), h(localn));
          }
        }
        paramView = (View)localObject1;
      }
    }
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh;
    if (paramBoolean2) {
      if (this.okX.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.okX.get(Long.valueOf(paramLong));
        if (paramInt > 0)
        {
          localh.olz = paramInt;
          localh.olx.omw = paramInt;
        }
        if (!paramBoolean1) {
          break label161;
        }
      }
    }
    label161:
    for (paramInt = 1;; paramInt = 0)
    {
      localh.olp = paramInt;
      if (!paramBoolean2) {
        break label166;
      }
      this.okX.put(Long.valueOf(paramLong), localh);
      return;
      localh = new h("timeline");
      break;
      if (this.okW.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.okW.get(Long.valueOf(paramLong));
        break;
      }
      localh = new h("timeline");
      break;
    }
    label166:
    this.okW.put(Long.valueOf(paramLong), localh);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh;
    if (paramBoolean2) {
      if (this.okX.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.okX.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label150;
        }
      }
    }
    label150:
    for (localh.olx.omx = 2;; localh.olx.omx = 1)
    {
      localh.olx.omy = 1;
      if (!paramBoolean2) {
        break label162;
      }
      this.okX.put(Long.valueOf(paramLong), localh);
      return;
      localh = new h("timeline");
      break;
      if (this.okW.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.okW.get(Long.valueOf(paramLong));
        break;
      }
      localh = new h("timeline");
      break;
    }
    label162:
    this.okW.put(Long.valueOf(paramLong), localh);
  }
  
  public final void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ai.d(new g.4(this, paramLong1, paramLong2, paramBoolean));
  }
  
  public final void bCe()
  {
    Iterator localIterator = this.okU.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (af.ort))
      {
        locala.bCc();
        if ((!bk.bl(locala.bMB)) && (this.okY.get(locala.bMB) != null))
        {
          g.a locala1 = (g.a)this.okY.get(locala.bMB);
          if (locala.okM == 1) {}
          for (int i = 1;; i = 0)
          {
            if ((i == 0) || (locala1.oln != 0L)) {
              break label140;
            }
            locala1.oln = bk.UZ();
            break;
          }
          label140:
          if ((i == 0) && (locala1.oln > 0L))
          {
            locala1.olo += bk.cp(locala1.oln);
            locala1.oln = 0L;
          }
        }
      }
    }
  }
  
  public final void clear()
  {
    onResume();
    y.i("MicroMsg.SnsAdStatistic", "clean the adRemove" + this.okZ.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.okY.keySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add((String)((Iterator)localObject2).next());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (g.a)this.okY.get(localObject2);
      h(((g.a)localObject2).position, ((g.a)localObject2).can, ((g.a)localObject2).eAz);
    }
    localObject1 = this.okZ.iterator();
    e locale;
    n localn;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      locale = af.bDI().yq(v.OV((String)localObject2));
      if (locale != null)
      {
        localn = locale.bGl();
        locale.field_localFlag |= 0x80;
        i = (int)(System.currentTimeMillis() / 1000L);
        if (!this.ola.containsKey(localObject2)) {
          break label322;
        }
        i = ((Integer)this.ola.get(localObject2)).intValue();
      }
    }
    label322:
    for (;;)
    {
      if (locale.field_exposureTime <= 0) {
        locale.field_exposureTime = i;
      }
      localn.field_localFlag |= 0x80;
      af.bDF().b(localn.field_snsId, localn);
      af.bDI().b(locale.field_snsId, locale);
      break;
      this.okZ.clear();
      this.ola.clear();
      return;
    }
  }
  
  public final void d(long paramLong, int paramInt, boolean paramBoolean)
  {
    ai.d(new g.2(this, paramLong, paramInt, paramBoolean));
  }
  
  public final boolean fF(long paramLong)
  {
    return this.okR.contains(Long.valueOf(paramLong));
  }
  
  public final boolean fG(long paramLong)
  {
    return this.okV.contains(Long.valueOf(paramLong));
  }
  
  public final void fH(long paramLong)
  {
    int i = 0;
    if (this.ole.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.ole.get(Long.valueOf(paramLong))).intValue();
    }
    this.ole.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
  }
  
  public final void fI(long paramLong)
  {
    int i = 0;
    if (this.olf.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.olf.get(Long.valueOf(paramLong))).intValue();
    }
    this.olf.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
  }
  
  public final void h(int paramInt1, String paramString, int paramInt2)
  {
    long l1;
    if (this.okQ.containsKey(paramString))
    {
      l1 = ((Long)this.okQ.remove(paramString)).longValue();
      this.okR.remove(Long.valueOf(l1));
    }
    Object localObject3 = null;
    n localn = null;
    Object localObject4 = (a)this.okU.get(paramString);
    Object localObject2 = localObject3;
    Object localObject1 = localn;
    if (localObject4 != null)
    {
      localObject2 = localObject3;
      localObject1 = localn;
      if (af.ort)
      {
        ((a)localObject4).inQ = true;
        ((a)localObject4).oku = System.currentTimeMillis();
        if (((a)localObject4).okp < 0)
        {
          ((a)localObject4).okK = 2;
          if (((a)localObject4).okr >= 0) {
            break label1120;
          }
          ((a)localObject4).okL = 2;
          label130:
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(com.tencent.mm.plugin.sns.data.i.fN(((a)localObject4).okm) + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okl + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okK + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okL + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okH + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okI + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okJ + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okt + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).oku + ",");
          if ((((a)localObject4).okx > 0L) && (((a)localObject4).okA == 0L)) {
            ((a)localObject4).okA = System.currentTimeMillis();
          }
          ((StringBuilder)localObject1).append(((a)localObject4).okx + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okA + ",");
          if ((((a)localObject4).okD > 0L) && (((a)localObject4).okG == 0L)) {
            ((a)localObject4).okG = System.currentTimeMillis();
          }
          ((StringBuilder)localObject1).append(((a)localObject4).okD + ",");
          ((StringBuilder)localObject1).append(((a)localObject4).okG);
          f.a(((a)localObject4).okm, (StringBuilder)localObject1);
          y.i("MicroMsg.AdViewStatic", "report " + ((StringBuilder)localObject1).toString());
          localObject2 = new bf();
          ((bf)localObject2).suR = ((a)localObject4).okD;
          ((bf)localObject2).suS = ((a)localObject4).okG;
          ((bf)localObject2).okK = ((a)localObject4).okK;
          ((bf)localObject2).okL = ((a)localObject4).okL;
          ((bf)localObject2).suM = ((a)localObject4).okH;
          ((bf)localObject2).suN = ((a)localObject4).okI;
          ((bf)localObject2).suO = ((a)localObject4).okJ;
          ((bf)localObject2).suP = ((a)localObject4).okx;
          ((bf)localObject2).suQ = ((a)localObject4).okA;
          ((bf)localObject2).startTime = ((a)localObject4).okt;
          ((bf)localObject2).endTime = ((a)localObject4).oku;
          if ((((a)localObject4).oko == null) || (!((a)localObject4).oko.bEQ())) {
            break label1129;
          }
          af.bDz().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
          label768:
          localObject3 = com.tencent.mm.modelsns.b.jd(730);
          ((com.tencent.mm.modelsns.b)localObject3).ni(com.tencent.mm.plugin.sns.data.i.fN(((a)localObject4).okm)).ni(((a)localObject4).okl).jg(((a)localObject4).okK).jg(((a)localObject4).okL).jg(((a)localObject4).okH).jg(((a)localObject4).okI).jg(((a)localObject4).okJ).ni(((a)localObject4).okt).ni(((a)localObject4).oku).ni(((a)localObject4).okx).ni(((a)localObject4).okA).ni(((a)localObject4).okD).ni(((a)localObject4).okG);
          ((com.tencent.mm.modelsns.b)localObject3).QX();
          localObject3 = new kn();
          ((kn)localObject3).bTE.position = ((a)localObject4).position;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
          if (!ae.eTu) {
            break label1177;
          }
          j = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
          y.i("MicroMsg.AdViewStatic", "run on test kv " + j);
          i = 0;
          label1055:
          if (i >= j) {
            break label1177;
          }
          if ((((a)localObject4).oko == null) || (!((a)localObject4).oko.bEQ())) {
            break label1153;
          }
          af.bDz().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        for (;;)
        {
          i += 1;
          break label1055;
          ((a)localObject4).okK = 1;
          break;
          label1120:
          ((a)localObject4).okL = 1;
          break label130;
          label1129:
          af.bDz().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
          break label768;
          label1153:
          af.bDz().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        label1177:
        localObject1 = ((a)localObject4).bCd();
        this.okU.remove(paramString);
      }
    }
    int i = 0;
    int j = 0;
    localn = af.bDF().OB(paramString);
    label1316:
    int k;
    if (localn != null)
    {
      i = j;
      if (this.okX.containsKey(Long.valueOf(localn.field_snsId)))
      {
        i = j;
        if (localn.bGe().tNr.sPI == 27)
        {
          if (localn.field_likeFlag != 1) {
            break label1731;
          }
          i = 2;
          if (!this.olf.containsKey(Long.valueOf(localn.field_snsId))) {
            break label1737;
          }
          j = ((Integer)this.olf.get(Long.valueOf(localn.field_snsId))).intValue();
          if (!this.ole.containsKey(Long.valueOf(localn.field_snsId))) {
            break label1743;
          }
          k = ((Integer)this.ole.get(Long.valueOf(localn.field_snsId))).intValue();
          label1361:
          long l3 = 0L;
          long l2 = 0L;
          l1 = 0L;
          localObject3 = (h)this.okX.remove(Long.valueOf(localn.field_snsId));
          if (localObject3 != null)
          {
            ((h)localObject3).xx(0);
            ((h)localObject3).bCg();
            l3 = ((h)localObject3).olv;
            l2 = ((h)localObject3).olu;
            l1 = ((h)localObject3).olz * 1000L;
          }
          localObject4 = localn.bGe().lsK;
          localObject5 = localn.bGM();
          if (localn.field_likeFlag != 1) {
            break label1749;
          }
          localObject3 = "1";
          label1479:
          localObject3 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject4, localObject5, String.valueOf(paramInt2), String.valueOf(j), String.valueOf(k), String.valueOf(l3), String.valueOf(l2), String.valueOf(l1), localObject3 });
          com.tencent.mm.plugin.report.service.h.nFQ.aC(15155, (String)localObject3);
          y.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[] { localObject3 });
          this.okV.remove(Long.valueOf(localn.field_snsId));
          this.okV.remove(Long.valueOf(localn.field_snsId + 1L));
        }
      }
      this.olf.remove(Long.valueOf(localn.field_snsId));
      this.ole.remove(Long.valueOf(localn.field_snsId));
    }
    else
    {
      if (!this.okY.containsKey(paramString)) {
        break label2199;
      }
      localObject3 = "";
      if (f(localn) != null) {
        localObject3 = f(localn).fVM;
      }
      localObject4 = (g.a)this.okY.remove(paramString);
      this.okS.put(paramString, Long.valueOf(bk.UZ()));
      if (localObject4 != null) {
        break label1757;
      }
    }
    label1731:
    label1737:
    label1743:
    label1749:
    label1757:
    do
    {
      return;
      i = 1;
      break;
      j = 0;
      break label1316;
      k = 0;
      break label1361;
      localObject3 = "0";
      break label1479;
      l1 = bk.cp(((g.a)localObject4).time);
      if (((g.a)localObject4).oln > 0L)
      {
        ((g.a)localObject4).olo += bk.cp(((g.a)localObject4).oln);
        ((g.a)localObject4).oln = 0L;
      }
      y.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + paramInt1 + " " + paramString + " " + l1 + " ");
    } while (localn == null);
    paramString = "";
    Object localObject5 = localn.bGe();
    if (localn.bFZ().bEI())
    {
      paramInt1 = 3;
      paramString = "";
      paramString = new d((String)localObject3, paramInt2, 2, (int)l1, (bf)localObject2, (bi)localObject1, paramInt1, paramString, -1, localn.bGO(), (int)l1, (int)((g.a)localObject4).olo, i, g(localn), h(localn));
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
      return;
    }
    if (localn.bGQ())
    {
      paramInt1 = 6;
      paramString = (h)this.okW.remove(Long.valueOf(((g.a)localObject4).okm));
      if (paramString == null) {
        break label2232;
      }
      if (localn.field_likeFlag == 0) {
        paramString.xx(0);
      }
    }
    label2199:
    label2232:
    for (paramString = paramString.bCf();; paramString = "")
    {
      break;
      if ((localn.bEJ()) || (localn.bEK()))
      {
        if ((localObject5 != null) && (((bxk)localObject5).tNr.sPI == 15) && (((bxk)localObject5).tNy != 1))
        {
          paramInt1 = 5;
          localObject5 = (h)this.okW.remove(Long.valueOf(((g.a)localObject4).okm));
          if (localObject5 != null)
          {
            ((h)localObject5).xx(0);
            paramString = ((h)localObject5).bCf();
          }
          this.okV.remove(Long.valueOf(((g.a)localObject4).okm));
          break;
        }
        paramInt1 = 4;
        paramString = "";
        break;
      }
      if (((g.a)localObject4).ivk == 9)
      {
        paramInt1 = 2;
        localObject5 = (h)this.okW.remove(Long.valueOf(((g.a)localObject4).okm));
        if (localObject5 != null)
        {
          ((h)localObject5).xx(0);
          paramString = ((h)localObject5).bCf();
        }
        this.okV.remove(Long.valueOf(((g.a)localObject4).okm));
        break;
      }
      paramInt1 = 1;
      paramString = "";
      break;
      y.i("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + paramInt1 + " " + paramString);
      return;
    }
  }
  
  public final void onPause()
  {
    this.iaq = bk.UZ();
    Iterator localIterator = this.okY.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (g.a)this.okY.get(localObject);
      h localh = (h)this.okW.get(Long.valueOf(((g.a)localObject).okm));
      if (localh != null) {
        localh.eAF = bk.UZ();
      }
      localObject = (h)this.okX.get(Long.valueOf(((g.a)localObject).okm));
      if (localObject != null) {
        ((h)localObject).eAF = bk.UZ();
      }
    }
  }
  
  public final void onResume()
  {
    if (this.iaq <= 0L) {}
    for (;;)
    {
      return;
      long l = bk.cp(this.iaq);
      Iterator localIterator = this.okY.keySet().iterator();
      Object localObject1;
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        localObject2 = (g.a)this.okY.get(localObject1);
        y.i("MicroMsg.SnsAdStatistic", "before Key " + (String)localObject1 + " " + ((g.a)localObject2).time);
      }
      localIterator = this.okY.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        localObject1 = (g.a)this.okY.get(localObject1);
        ((g.a)localObject1).time += l;
        if (((g.a)localObject1).oln > 0L) {
          ((g.a)localObject1).oln += l;
        }
        localObject2 = (h)this.okW.get(Long.valueOf(((g.a)localObject1).okm));
        if (localObject2 != null) {
          ((h)localObject2).onResume();
        }
        localObject1 = (h)this.okX.get(Long.valueOf(((g.a)localObject1).okm));
        if (localObject1 != null) {
          ((h)localObject1).onResume();
        }
      }
      localIterator = this.okY.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        localObject2 = (g.a)this.okY.get(localObject1);
        y.i("MicroMsg.SnsAdStatistic", "update Key " + (String)localObject1 + " " + ((g.a)localObject2).time);
      }
    }
  }
  
  public final void q(long paramLong, boolean paramBoolean)
  {
    ai.d(new g.1(this, paramLong, paramBoolean));
  }
  
  public final void r(long paramLong, boolean paramBoolean)
  {
    a(paramLong, 0, paramBoolean, false);
  }
  
  public final void s(long paramLong, boolean paramBoolean)
  {
    a(paramLong, paramBoolean, false);
  }
  
  public final void t(long paramLong, boolean paramBoolean)
  {
    h localh;
    if (paramBoolean)
    {
      if (this.okX.containsKey(Long.valueOf(paramLong)))
      {
        localh = (h)this.okX.get(Long.valueOf(paramLong));
        localh.xx(0);
      }
      for (;;)
      {
        this.okX.put(Long.valueOf(paramLong), localh);
        return;
        localh = new h("timeline");
      }
    }
    if (this.okW.containsKey(Long.valueOf(paramLong)))
    {
      localh = (h)this.okW.get(Long.valueOf(paramLong));
      localh.xx(0);
    }
    for (;;)
    {
      this.okW.put(Long.valueOf(paramLong), localh);
      return;
      localh = new h("timeline");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g
 * JD-Core Version:    0.7.0.1
 */