package com.tencent.mm.plugin.sns.ad.e;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.ad.b.a.c.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

public final class j
  implements d
{
  public static Map<String, Integer> zph;
  private Activity activity;
  public int doj;
  public HashMap<String, Long> zoX;
  public HashSet<Long> zoY;
  private Map<String, Long> zoZ;
  private int zop;
  private Map<String, Integer> zpa;
  private Map<String, c> zpb;
  public HashSet<Long> zpc;
  public Map<Long, k> zpd;
  public Map<Long, k> zpe;
  public Map<String, a> zpf;
  private Map<String, Integer> zpg;
  private int zpi;
  private View zpj;
  public Map<Long, Integer> zpk;
  public Map<Long, Integer> zpl;
  public HashSet<String> zpm;
  private int zpn;
  
  static
  {
    AppMethodBeat.i(95019);
    zph = new HashMap();
    AppMethodBeat.o(95019);
  }
  
  public j(int paramInt)
  {
    AppMethodBeat.i(94996);
    this.zoX = new HashMap();
    this.zoY = new HashSet();
    this.zoZ = new HashMap();
    this.zpa = new HashMap();
    this.zpb = new HashMap();
    this.zpc = new HashSet();
    this.zpd = new HashMap();
    this.zpe = new HashMap();
    this.zpf = new HashMap();
    this.doj = 0;
    this.zpg = new HashMap();
    this.zpi = 0;
    this.zop = 0;
    this.zpj = null;
    this.zpk = new HashMap();
    this.zpl = new HashMap();
    this.zpm = new HashSet();
    this.zpn = -1;
    this.doj = paramInt;
    AppMethodBeat.o(94996);
  }
  
  private com.tencent.mm.plugin.sns.storage.a g(p paramp)
  {
    AppMethodBeat.i(95010);
    if (paramp != null)
    {
      if (this.doj == 2)
      {
        paramp = paramp.ebM();
        AppMethodBeat.o(95010);
        return paramp;
      }
      paramp = paramp.dVi();
      AppMethodBeat.o(95010);
      return paramp;
    }
    AppMethodBeat.o(95010);
    return null;
  }
  
  private com.tencent.mm.bw.b h(p paramp)
  {
    AppMethodBeat.i(95011);
    if (paramp != null)
    {
      if (this.doj == 2)
      {
        paramp = paramp.ecy().ebT();
        AppMethodBeat.o(95011);
        return paramp;
      }
      paramp = paramp.ecy().ebR();
      AppMethodBeat.o(95011);
      return paramp;
    }
    AppMethodBeat.o(95011);
    return null;
  }
  
  private com.tencent.mm.bw.b i(p paramp)
  {
    AppMethodBeat.i(95012);
    if (paramp != null)
    {
      if (this.doj == 2)
      {
        paramp = paramp.ecy().ebU();
        AppMethodBeat.o(95012);
        return paramp;
      }
      paramp = paramp.ecy().ebS();
      AppMethodBeat.o(95012);
      return paramp;
    }
    AppMethodBeat.o(95012);
    return null;
  }
  
  public final void C(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(94999);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94990);
        if (j.this.zK(paramLong))
        {
          j localj = j.this;
          long l = paramLong;
          boolean bool = this.zpp;
          k localk;
          if (bool) {
            if (localj.zpe.containsKey(Long.valueOf(l))) {
              localk = (k)localj.zpe.get(Long.valueOf(l));
            }
          }
          for (;;)
          {
            localk.zpF = 1;
            localk.zpN.zqO += 1;
            if (!bool) {
              break;
            }
            localj.zpe.put(Long.valueOf(l), localk);
            AppMethodBeat.o(94990);
            return;
            localk = new k("timeline");
            continue;
            if (localj.zpd.containsKey(Long.valueOf(l))) {
              localk = (k)localj.zpd.get(Long.valueOf(l));
            } else {
              localk = new k("timeline");
            }
          }
          localj.zpd.put(Long.valueOf(l), localk);
        }
        AppMethodBeat.o(94990);
      }
    });
    AppMethodBeat.o(94999);
  }
  
  public final void D(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95001);
    b(paramLong, 0, paramBoolean, false);
    AppMethodBeat.o(95001);
  }
  
  public final void E(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95003);
    c(paramLong, paramBoolean, false);
    AppMethodBeat.o(95003);
  }
  
  public final void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95008);
    k localk;
    if (paramBoolean)
    {
      if (this.zpe.containsKey(Long.valueOf(paramLong)))
      {
        localk = (k)this.zpe.get(Long.valueOf(paramLong));
        localk.Qf(0);
      }
      for (;;)
      {
        this.zpe.put(Long.valueOf(paramLong), localk);
        AppMethodBeat.o(95008);
        return;
        localk = new k("timeline");
      }
    }
    if (this.zpd.containsKey(Long.valueOf(paramLong)))
    {
      localk = (k)this.zpd.get(Long.valueOf(paramLong));
      localk.Qf(0);
    }
    for (;;)
    {
      this.zpd.put(Long.valueOf(paramLong), localk);
      AppMethodBeat.o(95008);
      return;
      localk = new k("timeline");
    }
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.zop = paramInt;
    this.zpj = paramView;
    this.activity = paramActivity;
  }
  
  public final void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(219071);
    if (this.zoX.containsKey(paramString))
    {
      l1 = ((Long)this.zoX.remove(paramString)).longValue();
      this.zoY.remove(Long.valueOf(l1));
    }
    Object localObject1 = null;
    String str = null;
    c localc = (c)this.zpb.get(paramString);
    Object localObject3 = localObject1;
    Object localObject2 = str;
    label146:
    label878:
    int i;
    if (localc != null)
    {
      localObject3 = localObject1;
      localObject2 = str;
      if (ah.zAr)
      {
        localc.hkx = true;
        localc.zoC = System.currentTimeMillis();
        localc.zoU = 0;
        rq(false);
        if (localc.zox < 0)
        {
          localc.zoS = 2;
          if (localc.zoz >= 0) {
            break label1223;
          }
          localc.zoT = 2;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(r.zV(localc.zou) + ",");
          ((StringBuilder)localObject1).append(localc.zot + ",");
          ((StringBuilder)localObject1).append(localc.zoS + ",");
          ((StringBuilder)localObject1).append(localc.zoT + ",");
          ((StringBuilder)localObject1).append(localc.zoP + ",");
          ((StringBuilder)localObject1).append(localc.zoQ + ",");
          ((StringBuilder)localObject1).append(localc.zoR + ",");
          ((StringBuilder)localObject1).append(localc.zoB + ",");
          ((StringBuilder)localObject1).append(localc.zoC + ",");
          if ((localc.zoF > 0L) && (localc.zoI == 0L))
          {
            localc.zoI = System.currentTimeMillis();
            ae.d("MicroMsg.AdViewStatic", "halfExposure old 2, end:" + (localc.zoI - localc.zoF) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.zoF + ",");
          ((StringBuilder)localObject1).append(localc.zoI + ",");
          if ((localc.zoL > 0L) && (localc.zoO == 0L))
          {
            localc.zoO = System.currentTimeMillis();
            ae.d("MicroMsg.AdViewStatic", "fullExposure old 2, end:" + (localc.zoO - localc.zoL) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.zoL + ",");
          ((StringBuilder)localObject1).append(localc.zoO);
          i.a(localc.zou, (StringBuilder)localObject1);
          ae.i("MicroMsg.AdViewStatic", "report " + ((StringBuilder)localObject1).toString());
          localObject3 = new bt();
          ((bt)localObject3).FMC = localc.zoL;
          ((bt)localObject3).FMD = localc.zoO;
          ((bt)localObject3).zoS = localc.zoS;
          ((bt)localObject3).zoT = localc.zoT;
          ((bt)localObject3).FMx = localc.zoP;
          ((bt)localObject3).FMy = localc.zoQ;
          ((bt)localObject3).FMz = localc.zoR;
          ((bt)localObject3).FMA = localc.zoF;
          ((bt)localObject3).FMB = localc.zoI;
          ((bt)localObject3).startTime = localc.zoB;
          ((bt)localObject3).endTime = localc.zoC;
          if ((localc.zow == null) || (!localc.zow.dZL())) {
            break label1232;
          }
          ah.dXy().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
          localObject2 = com.tencent.mm.modelsns.e.pY(730);
          ((com.tencent.mm.modelsns.e)localObject2).GU(r.zV(localc.zou)).GU(localc.zot).qb(localc.zoS).qb(localc.zoT).qb(localc.zoP).qb(localc.zoQ).qb(localc.zoR).GU(localc.zoB).GU(localc.zoC).GU(localc.zoF).GU(localc.zoI).GU(localc.zoL).GU(localc.zoO);
          ((com.tencent.mm.modelsns.e)localObject2).aLH();
          localObject2 = new mz();
          ((mz)localObject2).dBY.position = localc.position;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          if (!ac.iSo) {
            break label1280;
          }
          j = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
          ae.i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(j)));
          i = 0;
          label1158:
          if (i >= j) {
            break label1280;
          }
          if ((localc.zow == null) || (!localc.zow.dZL())) {
            break label1256;
          }
          ah.dXy().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        for (;;)
        {
          i += 1;
          break label1158;
          localc.zoS = 1;
          break;
          label1223:
          localc.zoT = 1;
          break label146;
          label1232:
          ah.dXy().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
          break label878;
          label1256:
          ah.dXy().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        label1280:
        localObject2 = localc.dUV();
        this.zpb.remove(paramString);
      }
    }
    this.zpm.remove(paramString);
    int m = 0;
    int j = 0;
    p localp = ah.dXE().aBr(paramString);
    label1428:
    int k;
    label1473:
    long l3;
    long l2;
    if (localp != null)
    {
      i = j;
      if (this.zpe.containsKey(Long.valueOf(localp.field_snsId)))
      {
        i = j;
        if (localp.ebP().HUG.Gtw == 27)
        {
          if (localp.field_likeFlag != 1) {
            break label1853;
          }
          i = 2;
          if (!this.zpl.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1859;
          }
          j = ((Integer)this.zpl.get(Long.valueOf(localp.field_snsId))).intValue();
          if (!this.zpk.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1865;
          }
          k = ((Integer)this.zpk.get(Long.valueOf(localp.field_snsId))).intValue();
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          localObject1 = (k)this.zpe.remove(Long.valueOf(localp.field_snsId));
          if (localObject1 != null)
          {
            ((k)localObject1).Qf(0);
            ((k)localObject1).dUY();
            l3 = ((k)localObject1).zpL;
            l2 = ((k)localObject1).zpK;
            l1 = ((k)localObject1).oym * 1000L;
          }
          str = localp.ebP().Id;
          localObject4 = localp.ecx();
          if (localp.field_likeFlag != 1) {
            break label1871;
          }
        }
      }
    }
    a locala;
    label1853:
    label1859:
    label1865:
    label1871:
    for (localObject1 = "1";; localObject1 = "0")
    {
      localObject1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, localObject4, String.valueOf(paramInt2), String.valueOf(j), String.valueOf(k), String.valueOf(l3), String.valueOf(l2), String.valueOf(l1), localObject1 });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(15155, (String)localObject1);
      ae.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[] { localObject1 });
      this.zpc.remove(Long.valueOf(localp.field_snsId));
      this.zpc.remove(Long.valueOf(localp.field_snsId + 1L));
      this.zpl.remove(Long.valueOf(localp.field_snsId));
      this.zpk.remove(Long.valueOf(localp.field_snsId));
      m = i;
      if (!this.zpf.containsKey(paramString)) {
        break label2953;
      }
      str = "";
      if (g(localp) != null) {
        str = g(localp).aQj;
      }
      locala = (a)this.zpf.remove(paramString);
      this.zoZ.put(paramString, Long.valueOf(bu.HQ()));
      if (locala != null) {
        break label1879;
      }
      AppMethodBeat.o(219071);
      return;
      i = 1;
      break;
      j = 0;
      break label1428;
      k = 0;
      break label1473;
    }
    label1879:
    long l1 = bu.aO(locala.zpw);
    if (locala.zpy > 0L) {
      locala.zpB += bu.aO(locala.zpy);
    }
    localObject1 = new StringBuilder("onAdRemoved ").append(paramInt1).append(" ").append(paramString).append(" ").append(l1).append(", snsId=").append(r.zV(paramLong)).append(", snsInfo==null?");
    if (localp == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.SnsAdStatistic", bool);
      if (localp != null) {
        break;
      }
      AppMethodBeat.o(219071);
      return;
    }
    localObject1 = "";
    Object localObject4 = localp.ebP();
    label2063:
    Object localObject6;
    if (localp.dVj().dZz())
    {
      i = 3;
      localObject1 = "";
      localObject4 = g(localp);
      if (localObject4 == null)
      {
        localObject4 = "";
        localObject6 = new b();
        ((b)localObject6).zog = paramInt1;
        ((b)localObject6).znm = localp;
        if (localc == null) {
          break label2948;
        }
        paramInt1 = localc.gim;
        label2096:
        ((b)localObject6).zoh = paramInt1;
        ((b)localObject6).zoj = locala.zpC;
        ((b)localObject6).zoi = locala.zpD;
        ae.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime result=" + locala.zpC + ", id=" + paramString);
        ae.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime result=" + locala.zpD + ", id=" + paramString);
        paramString = new f(str, paramInt2, 2, (int)l1, (bt)localObject3, (bw)localObject2, i, (String)localObject1, -1, localp.ecz(), (int)locala.zpB, (int)locala.zpC, m, h(localp), i(localp), (String)localObject4, (b)localObject6);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
        AppMethodBeat.o(219071);
      }
    }
    else if (localp.ecB())
    {
      i = 6;
      localObject1 = (k)this.zpd.remove(Long.valueOf(locala.zou));
      if (localObject1 == null) {
        break label3021;
      }
      if (localp.field_likeFlag == 0) {
        ((k)localObject1).Qf(0);
      }
    }
    label2948:
    label2953:
    label3013:
    label3021:
    for (localObject1 = ((k)localObject1).dUX();; localObject1 = "")
    {
      break;
      if ((localp.dZA()) || (localp.dZB())) {
        if ((localObject4 != null) && (((TimeLineObject)localObject4).HUG.Gtw == 15) && (((TimeLineObject)localObject4).HUN != 1))
        {
          localObject4 = (k)this.zpd.remove(Long.valueOf(locala.zou));
          if (localObject4 == null) {
            break label3013;
          }
          ((k)localObject4).Qf(0);
        }
      }
      for (localObject1 = ((k)localObject4).dUX();; localObject1 = "")
      {
        this.zpc.remove(Long.valueOf(locala.zou));
        if (localp.dZD())
        {
          i = 0;
          j = 0;
          if ((localObject4 != null) && (((k)localObject4).zpO != null) && (((k)localObject4).zpO.size() > 0)) {
            j = i;
          }
          for (;;)
          {
            try
            {
              n = ((k)localObject4).zpO.size() - 1;
              j = i;
              localObject6 = (com.tencent.mm.plugin.sns.ad.e.a.a)((k)localObject4).zpO.get(n);
              j = i;
              i = ((com.tencent.mm.plugin.sns.ad.e.a.a)localObject6).zqO;
              j = i;
              k = ((com.tencent.mm.plugin.sns.ad.e.a.a)localObject6).zqP;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                try
                {
                  int n;
                  ae.i("MicroMsg.SnsAdStatistic", "longPressGestureAd, playitems.size=" + ((k)localObject4).zpO.size() + ", lastIdx=" + n);
                  j = i;
                  i = k;
                  if (this.doj == 0) {
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
                  ((JSONObject)localObject4).put("uxinfo", bu.nullAsNil(localp.dVi().dGD));
                  ((JSONObject)localObject4).put("scene", k);
                  localObject6 = new JSONObject();
                  ((JSONObject)localObject6).put("playCount", j);
                  ((JSONObject)localObject6).put("playTotalTime", i);
                  ((JSONObject)localObject4).put("extInfo", localObject6);
                  localObject4 = ((JSONObject)localObject4).toString();
                  com.tencent.mm.plugin.sns.data.k.jm("timeline_fullcard_longpress_exposure", (String)localObject4);
                  ae.i("SnsAdPressGestureCtrl", "reportVideoPlay, content=" + (String)localObject4 + ", channel=timeline_fullcard_longpress_exposure");
                  i = 5;
                }
                catch (Exception localException2)
                {
                  ae.i("SnsAdPressGestureCtrl", "reportVideoPlay, exp=" + localException2.toString());
                }
              }
              localException1 = localException1;
              k = 0;
            }
            ae.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, reportVideoPlay exp=" + localException1.toString());
            i = k;
            continue;
            ae.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, advideo.playitems is Empty");
            i = 0;
            continue;
            k = 2;
          }
        }
        i = 5;
        break;
        i = 4;
        localObject1 = "";
        break;
        if (locala.oOD == 9)
        {
          i = 2;
          localObject5 = (k)this.zpd.remove(Long.valueOf(locala.zou));
          if (localObject5 != null)
          {
            ((k)localObject5).Qf(0);
            localObject1 = ((k)localObject5).dUX();
          }
          this.zpc.remove(Long.valueOf(locala.zou));
          break;
        }
        i = 1;
        localObject1 = "";
        break;
        localObject5 = ((com.tencent.mm.plugin.sns.storage.a)localObject5).zMw;
        break label2063;
        paramInt1 = 0;
        break label2096;
        ae.w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + paramInt1 + " " + paramString + ", snsId=" + r.zV(paramLong));
        AppMethodBeat.o(219071);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95013);
    this.zoY.add(Long.valueOf(paramLong));
    this.zoX.put(paramString, Long.valueOf(paramLong));
    if (this.zpn == -1) {
      if (this.activity != null) {
        break label114;
      }
    }
    p localp;
    label114:
    for (int i = -1;; i = al.jO(this.activity))
    {
      this.zpn = i;
      localp = ah.dXE().aBr(paramString);
      if (localp != null) {
        break;
      }
      ae.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!, snsId=" + r.zV(paramLong) + ", localId=" + paramString);
      AppMethodBeat.o(95013);
      return;
    }
    Object localObject1 = (c)this.zpb.get(paramString);
    Object localObject2 = g(localp);
    if (localObject2 != null) {}
    for (String str = ((com.tencent.mm.plugin.sns.storage.a)localObject2).aQj;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (ah.zAr))
      {
        paramSnsObject = new c((com.tencent.mm.plugin.sns.storage.a)localObject2, paramString, paramLong, paramView, this.zop, this.zpj, this.zpn, paramInt3, paramSnsObject, paramInt1, localp.dVj());
        paramSnsObject.zoB = System.currentTimeMillis();
        ah.cXK().post(new c.1(paramSnsObject));
        this.zpb.put(paramString, paramSnsObject);
        paramView = paramSnsObject;
        if (!this.zpk.containsKey(Long.valueOf(paramLong)))
        {
          paramView = this.zpk;
          if (localp.field_likeFlag != 1) {
            break label614;
          }
          i = 1;
          paramView.put(Long.valueOf(paramLong), Integer.valueOf(i));
        }
      }
      for (paramView = paramSnsObject;; paramView = (View)localObject1)
      {
        if ((paramInt2 == 11) && (localp.ebP().HUG.Gtx.size() > 1))
        {
          if (this.zpe.containsKey(Long.valueOf(paramLong)))
          {
            paramSnsObject = (k)this.zpe.get(Long.valueOf(paramLong));
            paramSnsObject.zpH = bu.HQ();
            this.zpe.put(Long.valueOf(paramLong), paramSnsObject);
          }
        }
        else if (!this.zpm.contains(paramString))
        {
          this.zpm.add(paramString);
          com.tencent.mm.plugin.sns.ad.c.c.f(localp);
        }
        for (;;)
        {
          try
          {
            paramSnsObject = localp.Rv(this.doj);
            com.tencent.mm.plugin.sns.ad.timeline.a.c.a(r.zV(localp.field_snsId), paramSnsObject);
            paramSnsObject = com.tencent.mm.plugin.sns.ad.b.a.dUG();
            i = this.doj;
            try
            {
              localObject1 = paramSnsObject.zng;
              if (localp != null) {
                continue;
              }
              paramSnsObject = null;
              ((com.tencent.mm.plugin.sns.ad.b.a.c)localObject1).b(paramSnsObject);
            }
            catch (Throwable paramSnsObject)
            {
              long l;
              label614:
              TimeLineObject localTimeLineObject;
              continue;
            }
            if (this.zoZ.containsKey(paramString))
            {
              l = bu.aO(((Long)this.zoZ.get(paramString)).longValue());
              if (l >= 1200000L) {
                break label1181;
              }
              if (this.zpa.containsKey(paramString))
              {
                i = ((Integer)this.zpa.get(paramString)).intValue();
                if (i < 100) {
                  continue;
                }
                ae.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
                AppMethodBeat.o(95013);
                return;
                i = 0;
                break;
                paramSnsObject = new k("timeline");
              }
            }
          }
          catch (Throwable paramSnsObject)
          {
            ae.e("MicroMsg.SnsAdStatistic", paramSnsObject.toString());
            continue;
            paramSnsObject = ((com.tencent.mm.plugin.sns.ad.b.a.c)localObject1).a(new c.b(localp, i));
            continue;
            i = 0;
            continue;
            this.zpa.put(paramString, Integer.valueOf(i + 1));
            if (!this.zpf.containsKey(paramString))
            {
              this.zpf.put(paramString, new a(bu.HQ(), System.currentTimeMillis(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
              ae.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean + ", snsId=" + r.zV(paramLong) + ", expoureScene=" + paramInt3);
              if ((paramInt2 != 9) && (paramInt2 != 13) && (paramInt2 != 14)) {
                break label1230;
              }
              if (!this.zpd.containsKey(Long.valueOf(paramLong))) {
                break label1216;
              }
              paramSnsObject = (k)this.zpd.get(Long.valueOf(paramLong));
              paramSnsObject.zpH = bu.HQ();
              this.zpd.put(Long.valueOf(paramLong), paramSnsObject);
              if (!this.zpg.containsKey(paramString))
              {
                i = (int)(System.currentTimeMillis() / 1000L);
                this.zpg.put(paramString, Integer.valueOf(i));
                ae.i("MicroMsg.SnsAdStatistic", "exposures item " + paramString + ", snsId=" + r.zV(paramLong) + ", time=" + i);
              }
              localObject1 = localp.dVj();
              localTimeLineObject = localp.ebP();
              paramSnsObject = null;
              paramString = paramSnsObject;
              if (paramView != null)
              {
                paramString = paramSnsObject;
                if (ah.zAr) {
                  paramString = paramView.dUV();
                }
              }
              paramSnsObject = localp.ecy();
              i = 0;
              if (this.doj == 0)
              {
                i = paramSnsObject.field_exposureCount + 1;
                paramSnsObject.field_exposureCount = i;
                ah.dXH().update(paramSnsObject, new String[0]);
              }
              if (localObject2 != null) {
                break label1364;
              }
              paramSnsObject = "";
              localObject2 = new b();
              ((b)localObject2).zog = paramInt1;
              ((b)localObject2).znm = localp;
              if (paramView == null) {
                break label1374;
              }
              paramInt1 = paramView.gim;
              ((b)localObject2).zoh = paramInt1;
              if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).dZz()) {
                break label1379;
              }
              paramInt1 = 3;
              paramString = new f(str, paramInt3, paramString, paramInt1, i, localp.ecz(), h(localp), i(localp), paramSnsObject, (b)localObject2);
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
            }
            AppMethodBeat.o(95013);
            return;
          }
          label1181:
          this.zoZ.put(paramString, Long.valueOf(bu.HQ()));
          this.zpa.put(paramString, Integer.valueOf(0));
          continue;
          label1216:
          paramSnsObject = new k("timeline");
          continue;
          label1230:
          if ((paramInt2 == 11) && (localp.ebP().HUG.Gtx.size() > 0) && (((bzh)localp.ebP().HUG.Gtx.get(0)).nJA == 6))
          {
            if (this.zpd.containsKey(Long.valueOf(paramLong))) {}
            for (paramSnsObject = (k)this.zpd.get(Long.valueOf(paramLong));; paramSnsObject = new k("timeline"))
            {
              paramSnsObject.zpH = bu.HQ();
              paramSnsObject.zpM = true;
              this.zpd.put(Long.valueOf(paramLong), paramSnsObject);
              break;
            }
            label1364:
            paramSnsObject = ((com.tencent.mm.plugin.sns.storage.a)localObject2).zMw;
            continue;
            label1374:
            paramInt1 = 0;
            continue;
            label1379:
            if (localp.ecB()) {
              paramInt1 = 6;
            } else if ((localp.dZA()) || (localp.dZB()))
            {
              if ((localTimeLineObject != null) && (localTimeLineObject.HUG.Gtw == 15) && (localTimeLineObject.HUN != 1)) {
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
  }
  
  public final void ai(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95005);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94992);
        if (j.this.zK(paramLong1))
        {
          j localj = j.this;
          long l = this.zps;
          if (!localj.zpc.contains(Long.valueOf(l))) {
            localj.zpc.add(Long.valueOf(l));
          }
        }
        AppMethodBeat.o(94992);
      }
    });
    AppMethodBeat.o(95005);
  }
  
  public final void aj(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219074);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219070);
        k localk = (k)j.this.zpd.get(Long.valueOf(paramLong1));
        if (localk != null) {
          localk.zpQ = this.zpv;
        }
        AppMethodBeat.o(219070);
      }
    });
    AppMethodBeat.o(219074);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95002);
    k localk;
    if (paramBoolean2) {
      if (this.zpe.containsKey(Long.valueOf(paramLong)))
      {
        localk = (k)this.zpe.get(Long.valueOf(paramLong));
        if (paramInt > 0) {
          localk.setDuration(paramInt);
        }
        if (!paramBoolean1) {
          break label161;
        }
      }
    }
    label161:
    for (paramInt = 1;; paramInt = 0)
    {
      localk.zpF = paramInt;
      if (!paramBoolean2) {
        break label166;
      }
      this.zpe.put(Long.valueOf(paramLong), localk);
      AppMethodBeat.o(95002);
      return;
      localk = new k("timeline");
      break;
      if (this.zpd.containsKey(Long.valueOf(paramLong)))
      {
        localk = (k)this.zpd.get(Long.valueOf(paramLong));
        break;
      }
      localk = new k("timeline");
      break;
    }
    label166:
    this.zpd.put(Long.valueOf(paramLong), localk);
    AppMethodBeat.o(95002);
  }
  
  public final void c(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95004);
    k localk;
    if (paramBoolean2) {
      if (this.zpe.containsKey(Long.valueOf(paramLong)))
      {
        localk = (k)this.zpe.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label160;
        }
      }
    }
    label160:
    for (localk.zpN.zqR = 2;; localk.zpN.zqR = 1)
    {
      localk.zpN.zqS = 1;
      if (!paramBoolean2) {
        break label172;
      }
      this.zpe.put(Long.valueOf(paramLong), localk);
      AppMethodBeat.o(95004);
      return;
      localk = new k("timeline");
      break;
      if (this.zpd.containsKey(Long.valueOf(paramLong)))
      {
        localk = (k)this.zpd.get(Long.valueOf(paramLong));
        break;
      }
      localk = new k("timeline");
      break;
    }
    label172:
    this.zpd.put(Long.valueOf(paramLong), localk);
    AppMethodBeat.o(95004);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(95016);
    ae.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
    Object localObject1 = new HashSet(this.zpf.keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.zpf.get(localObject2);
      a(((a)localObject2).position, ((a)localObject2).dKQ, ((a)localObject2).zou, ((a)localObject2).ipM);
    }
    localObject1 = new HashMap(this.zpg);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94994);
        Iterator localIterator = this.zpu.keySet().iterator();
        com.tencent.mm.plugin.sns.storage.e locale;
        p localp;
        int j;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          locale = ah.dXH().Rr(x.aBN(str));
          if (locale != null)
          {
            localp = locale.ebV();
            locale.field_localFlag |= 0x80;
            j = 0;
            i = (int)(System.currentTimeMillis() / 1000L);
            if (!this.zpu.containsKey(str)) {
              break label246;
            }
            i = ((Integer)this.zpu.get(str)).intValue();
            j = 1;
          }
        }
        label246:
        for (;;)
        {
          if (locale.field_exposureTime <= 0)
          {
            locale.field_exposureTime = i;
            ae.i("MicroMsg.SnsAdStatistic", "update Ad ExposureTime, snsId=" + r.zV(locale.field_snsId) + ", exposuretime=" + i + "， sys.currentTimeMis=" + System.currentTimeMillis() + ", type=" + j);
          }
          localp.field_localFlag |= 0x80;
          ah.dXE().b(localp.field_snsId, localp);
          ah.dXH().b(locale.field_snsId, locale);
          break;
          AppMethodBeat.o(94994);
          return;
        }
      }
    });
    this.zpf.clear();
    this.zpg.clear();
    AppMethodBeat.o(95016);
  }
  
  public final void d(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(95007);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94993);
        if (j.this.zK(paramLong1))
        {
          j localj = j.this;
          long l1 = paramLong1;
          long l2 = paramBoolean;
          boolean bool = this.zpp;
          k localk;
          if (bool) {
            if (localj.zpe.containsKey(Long.valueOf(l1))) {
              localk = (k)localj.zpe.get(Long.valueOf(l1));
            }
          }
          for (;;)
          {
            if (localk.zpN.zqT == 0L) {
              localk.zpN.zqT = l2;
            }
            if (!bool) {
              break;
            }
            localj.zpe.put(Long.valueOf(l1), localk);
            AppMethodBeat.o(94993);
            return;
            localk = new k("timeline");
            continue;
            if (localj.zpd.containsKey(Long.valueOf(l1))) {
              localk = (k)localj.zpd.get(Long.valueOf(l1));
            } else {
              localk = new k("timeline");
            }
          }
          localj.zpd.put(Long.valueOf(l1), localk);
        }
        AppMethodBeat.o(94993);
      }
    });
    AppMethodBeat.o(95007);
  }
  
  public final void e(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(95000);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94991);
        j.this.b(paramLong, paramBoolean, this.zpr, this.zpp);
        AppMethodBeat.o(94991);
      }
    });
    AppMethodBeat.o(95000);
  }
  
  public final long eY(String paramString, int paramInt)
  {
    AppMethodBeat.i(94997);
    c localc = (c)this.zpb.get(paramString);
    if (localc != null) {}
    for (long l = localc.zoB;; l = 0L)
    {
      ae.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(94997);
      return l;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(95009);
    Iterator localIterator = this.zpf.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.zpf.get(localObject2);
      ae.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).zpB += bu.aO(((a)localObject1).zpy);
      ((a)localObject1).zpy = 0L;
      localObject2 = (k)this.zpd.get(Long.valueOf(((a)localObject1).zou));
      if (localObject2 != null) {
        ((k)localObject2).ipR = bu.HQ();
      }
      localObject1 = (k)this.zpe.get(Long.valueOf(((a)localObject1).zou));
      if (localObject1 != null) {
        ((k)localObject1).ipR = bu.HQ();
      }
    }
    localIterator = this.zpb.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (ah.zAr))
      {
        ((c)localObject1).rp(false);
        if ((!bu.isNullOrNil(((c)localObject1).dsN)) && (this.zpf.get(((c)localObject1).dsN) != null))
        {
          localObject2 = (a)this.zpf.get(((c)localObject1).dsN);
          long l;
          if (((a)localObject2).zpA > 0L)
          {
            l = bu.aO(((a)localObject2).zpA);
            ((a)localObject2).zpC += l;
            ((a)localObject2).zpA = 0L;
            ae.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).zpC + ", id=" + ((c)localObject1).dsN);
          }
          if (((a)localObject2).zpE > 0L)
          {
            l = bu.aO(((a)localObject2).zpE);
            ((a)localObject2).zpD += l;
            ((a)localObject2).zpE = 0L;
            ae.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).zpD + ", id=" + ((c)localObject1).dsN);
          }
        }
      }
    }
    AppMethodBeat.o(95009);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(94998);
    long l = bu.HQ();
    Iterator localIterator = this.zpf.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.zpf.get(localObject2);
      ae.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).zpy = l;
      localObject2 = (k)this.zpd.get(Long.valueOf(((a)localObject1).zou));
      if (localObject2 != null) {
        ((k)localObject2).onResume();
      }
      localObject1 = (k)this.zpe.get(Long.valueOf(((a)localObject1).zou));
      if (localObject1 != null) {
        ((k)localObject1).onResume();
      }
    }
    localIterator = this.zpb.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (ah.zAr))
      {
        ((c)localObject1).rp(false);
        if ((!bu.isNullOrNil(((c)localObject1).dsN)) && (this.zpf.get(((c)localObject1).dsN) != null))
        {
          localObject2 = (a)this.zpf.get(((c)localObject1).dsN);
          if (((c)localObject1).dUW())
          {
            ((a)localObject2).zpA = bu.HQ();
            ae.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + ((c)localObject1).dsN);
          }
          else if (((c)localObject1).zoV)
          {
            ((a)localObject2).zpE = bu.HQ();
            ae.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + ((c)localObject1).dsN);
          }
        }
      }
    }
    AppMethodBeat.o(94998);
  }
  
  public final void rq(boolean paramBoolean)
  {
    AppMethodBeat.i(95015);
    ae.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.zpb.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localc != null) && (ah.zAr))
      {
        localc.rp(paramBoolean);
        if ((!bu.isNullOrNil(localc.dsN)) && (this.zpf.get(localc.dsN) != null))
        {
          a locala = (a)this.zpf.get(localc.dsN);
          boolean bool = localc.dUW();
          if ((bool) && (locala.zpA == 0L))
          {
            locala.zpA = bu.HQ();
            ae.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + localc.dsN);
          }
          long l;
          for (;;)
          {
            bool = localc.zoV;
            if ((!bool) || (locala.zpE != 0L)) {
              break label326;
            }
            locala.zpE = bu.HQ();
            ae.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + localc.dsN);
            break;
            if ((!bool) && (locala.zpA > 0L))
            {
              l = bu.aO(locala.zpA);
              locala.zpC += l;
              locala.zpA = 0L;
              ae.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + locala.zpC);
            }
          }
          label326:
          if ((!bool) && (locala.zpE > 0L))
          {
            l = bu.aO(locala.zpE);
            locala.zpD += l;
            locala.zpE = 0L;
            ae.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + locala.zpD);
          }
        }
      }
    }
    AppMethodBeat.o(95015);
  }
  
  public final boolean zK(long paramLong)
  {
    AppMethodBeat.i(94995);
    boolean bool = this.zoY.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(94995);
    return bool;
  }
  
  public final boolean zL(long paramLong)
  {
    AppMethodBeat.i(95006);
    if (this.zpc.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95006);
      return true;
    }
    AppMethodBeat.o(95006);
    return false;
  }
  
  public final void zM(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = 0;
    if (this.zpk.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.zpk.get(Long.valueOf(paramLong))).intValue();
    }
    this.zpk.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95017);
  }
  
  public final void zN(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = 0;
    if (this.zpl.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.zpl.get(Long.valueOf(paramLong))).intValue();
    }
    this.zpl.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95018);
  }
  
  public final void zO(final long paramLong)
  {
    AppMethodBeat.i(219072);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219068);
        k localk = (k)j.this.zpd.get(Long.valueOf(paramLong));
        if (localk != null) {
          localk.dUZ();
        }
        AppMethodBeat.o(219068);
      }
    });
    AppMethodBeat.o(219072);
  }
  
  public final void zP(final long paramLong)
  {
    AppMethodBeat.i(219073);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219069);
        k localk = (k)j.this.zpd.get(Long.valueOf(paramLong));
        if ((localk != null) && (!j.a(j.this))) {
          localk.dTQ();
        }
        AppMethodBeat.o(219069);
      }
    });
    AppMethodBeat.o(219073);
  }
  
  public final long zQ(long paramLong)
  {
    AppMethodBeat.i(219075);
    try
    {
      k localk = (k)this.zpd.get(Long.valueOf(paramLong));
      if (localk != null)
      {
        paramLong = localk.zpQ;
        AppMethodBeat.o(219075);
        return paramLong;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + localThrowable.toString());
      AppMethodBeat.o(219075);
    }
    return 0L;
  }
  
  static final class a
  {
    public String dKQ;
    public int ipM;
    public int oOD;
    public int position;
    public long zou;
    public long zpA;
    public long zpB;
    public long zpC;
    public long zpD;
    public long zpE;
    public long zpw;
    public long zpx;
    public long zpy;
    public String zpz;
    
    public a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3, int paramInt3)
    {
      this.zpw = paramLong1;
      this.zpx = paramLong2;
      this.zpy = paramLong1;
      this.dKQ = paramString1;
      this.position = paramInt1;
      this.zpz = paramString2;
      this.zou = paramLong3;
      this.oOD = paramInt2;
      this.ipM = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.j
 * JD-Core Version:    0.7.0.1
 */