package com.tencent.mm.plugin.sns.ad.d;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.my;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
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

public final class i
  implements d
{
  public static Map<String, Integer> yYG;
  private Activity activity;
  public int dnh;
  private int yXO;
  private Map<String, c> yYA;
  public HashSet<Long> yYB;
  public Map<Long, j> yYC;
  public Map<Long, j> yYD;
  public Map<String, a> yYE;
  private Map<String, Integer> yYF;
  private int yYH;
  private View yYI;
  public Map<Long, Integer> yYJ;
  public Map<Long, Integer> yYK;
  public HashSet<String> yYL;
  private int yYM;
  public HashMap<String, Long> yYw;
  public HashSet<Long> yYx;
  private Map<String, Long> yYy;
  private Map<String, Integer> yYz;
  
  static
  {
    AppMethodBeat.i(95019);
    yYG = new HashMap();
    AppMethodBeat.o(95019);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(94996);
    this.yYw = new HashMap();
    this.yYx = new HashSet();
    this.yYy = new HashMap();
    this.yYz = new HashMap();
    this.yYA = new HashMap();
    this.yYB = new HashSet();
    this.yYC = new HashMap();
    this.yYD = new HashMap();
    this.yYE = new HashMap();
    this.dnh = 0;
    this.yYF = new HashMap();
    this.yYH = 0;
    this.yXO = 0;
    this.yYI = null;
    this.yYJ = new HashMap();
    this.yYK = new HashMap();
    this.yYL = new HashSet();
    this.yYM = -1;
    this.dnh = paramInt;
    AppMethodBeat.o(94996);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(p paramp)
  {
    AppMethodBeat.i(95010);
    if (paramp != null)
    {
      if (this.dnh == 2)
      {
        paramp = paramp.dYi();
        AppMethodBeat.o(95010);
        return paramp;
      }
      paramp = paramp.dRK();
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
      if (this.dnh == 2)
      {
        paramp = paramp.dYU().dYp();
        AppMethodBeat.o(95011);
        return paramp;
      }
      paramp = paramp.dYU().dYn();
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
      if (this.dnh == 2)
      {
        paramp = paramp.dYU().dYq();
        AppMethodBeat.o(95012);
        return paramp;
      }
      paramp = paramp.dYU().dYo();
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
        if (i.this.zl(paramLong))
        {
          i locali = i.this;
          long l = paramLong;
          boolean bool = this.yYO;
          j localj;
          if (bool) {
            if (locali.yYD.containsKey(Long.valueOf(l))) {
              localj = (j)locali.yYD.get(Long.valueOf(l));
            }
          }
          for (;;)
          {
            localj.yZe = 1;
            localj.yZm.zan += 1;
            if (!bool) {
              break;
            }
            locali.yYD.put(Long.valueOf(l), localj);
            AppMethodBeat.o(94990);
            return;
            localj = new j("timeline");
            continue;
            if (locali.yYC.containsKey(Long.valueOf(l))) {
              localj = (j)locali.yYC.get(Long.valueOf(l));
            } else {
              localj = new j("timeline");
            }
          }
          locali.yYC.put(Long.valueOf(l), localj);
        }
        AppMethodBeat.o(94990);
      }
    });
    AppMethodBeat.o(94999);
  }
  
  public final void B(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95001);
    b(paramLong, 0, paramBoolean, false);
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
      if (this.yYD.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.yYD.get(Long.valueOf(paramLong));
        localj.Py(0);
      }
      for (;;)
      {
        this.yYD.put(Long.valueOf(paramLong), localj);
        AppMethodBeat.o(95008);
        return;
        localj = new j("timeline");
      }
    }
    if (this.yYC.containsKey(Long.valueOf(paramLong)))
    {
      localj = (j)this.yYC.get(Long.valueOf(paramLong));
      localj.Py(0);
    }
    for (;;)
    {
      this.yYC.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95008);
      return;
      localj = new j("timeline");
    }
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.yXO = paramInt;
    this.yYI = paramView;
    this.activity = paramActivity;
  }
  
  public final void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(197605);
    if (this.yYw.containsKey(paramString))
    {
      l1 = ((Long)this.yYw.remove(paramString)).longValue();
      this.yYx.remove(Long.valueOf(l1));
    }
    Object localObject1 = null;
    String str = null;
    c localc = (c)this.yYA.get(paramString);
    Object localObject3 = localObject1;
    Object localObject2 = str;
    label146:
    label878:
    int i;
    if (localc != null)
    {
      localObject3 = localObject1;
      localObject2 = str;
      if (ag.zjc)
      {
        localc.hhJ = true;
        localc.yYb = System.currentTimeMillis();
        localc.yYt = 0;
        rj(false);
        if (localc.yXW < 0)
        {
          localc.yYr = 2;
          if (localc.yXY >= 0) {
            break label1223;
          }
          localc.yYs = 2;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(com.tencent.mm.plugin.sns.data.q.zw(localc.yXT) + ",");
          ((StringBuilder)localObject1).append(localc.yXS + ",");
          ((StringBuilder)localObject1).append(localc.yYr + ",");
          ((StringBuilder)localObject1).append(localc.yYs + ",");
          ((StringBuilder)localObject1).append(localc.yYo + ",");
          ((StringBuilder)localObject1).append(localc.yYp + ",");
          ((StringBuilder)localObject1).append(localc.yYq + ",");
          ((StringBuilder)localObject1).append(localc.yYa + ",");
          ((StringBuilder)localObject1).append(localc.yYb + ",");
          if ((localc.yYe > 0L) && (localc.yYh == 0L))
          {
            localc.yYh = System.currentTimeMillis();
            ad.d("MicroMsg.AdViewStatic", "halfExposure old 2, end:" + (localc.yYh - localc.yYe) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.yYe + ",");
          ((StringBuilder)localObject1).append(localc.yYh + ",");
          if ((localc.yYk > 0L) && (localc.yYn == 0L))
          {
            localc.yYn = System.currentTimeMillis();
            ad.d("MicroMsg.AdViewStatic", "fullExposure old 2, end:" + (localc.yYn - localc.yYk) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.yYk + ",");
          ((StringBuilder)localObject1).append(localc.yYn);
          h.a(localc.yXT, (StringBuilder)localObject1);
          ad.i("MicroMsg.AdViewStatic", "report " + ((StringBuilder)localObject1).toString());
          localObject3 = new com.tencent.mm.protocal.protobuf.bt();
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).Fue = localc.yYk;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).Fuf = localc.yYn;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).yYr = localc.yYr;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).yYs = localc.yYs;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).FtZ = localc.yYo;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).Fua = localc.yYp;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).Fub = localc.yYq;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).Fuc = localc.yYe;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).Fud = localc.yYh;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).startTime = localc.yYa;
          ((com.tencent.mm.protocal.protobuf.bt)localObject3).endTime = localc.yYb;
          if ((localc.yXV == null) || (!localc.yXV.dWk())) {
            break label1232;
          }
          ag.dTY().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
          localObject2 = com.tencent.mm.modelsns.e.pV(730);
          ((com.tencent.mm.modelsns.e)localObject2).Gs(com.tencent.mm.plugin.sns.data.q.zw(localc.yXT)).Gs(localc.yXS).pY(localc.yYr).pY(localc.yYs).pY(localc.yYo).pY(localc.yYp).pY(localc.yYq).Gs(localc.yYa).Gs(localc.yYb).Gs(localc.yYe).Gs(localc.yYh).Gs(localc.yYk).Gs(localc.yYn);
          ((com.tencent.mm.modelsns.e)localObject2).aLk();
          localObject2 = new my();
          ((my)localObject2).dAT.position = localc.position;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          if (!ac.iPu) {
            break label1280;
          }
          j = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
          ad.i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(j)));
          i = 0;
          label1158:
          if (i >= j) {
            break label1280;
          }
          if ((localc.yXV == null) || (!localc.yXV.dWk())) {
            break label1256;
          }
          ag.dTY().f(14648, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        for (;;)
        {
          i += 1;
          break label1158;
          localc.yYr = 1;
          break;
          label1223:
          localc.yYs = 1;
          break label146;
          label1232:
          ag.dTY().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
          break label878;
          label1256:
          ag.dTY().f(12010, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        label1280:
        localObject2 = localc.dRx();
        this.yYA.remove(paramString);
      }
    }
    this.yYL.remove(paramString);
    int m = 0;
    int j = 0;
    p localp = ag.dUe().aAa(paramString);
    label1428:
    int k;
    label1473:
    long l3;
    long l2;
    if (localp != null)
    {
      i = j;
      if (this.yYD.containsKey(Long.valueOf(localp.field_snsId)))
      {
        i = j;
        if (localp.dYl().HAT.GaP == 27)
        {
          if (localp.field_likeFlag != 1) {
            break label1853;
          }
          i = 2;
          if (!this.yYK.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1859;
          }
          j = ((Integer)this.yYK.get(Long.valueOf(localp.field_snsId))).intValue();
          if (!this.yYJ.containsKey(Long.valueOf(localp.field_snsId))) {
            break label1865;
          }
          k = ((Integer)this.yYJ.get(Long.valueOf(localp.field_snsId))).intValue();
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          localObject1 = (j)this.yYD.remove(Long.valueOf(localp.field_snsId));
          if (localObject1 != null)
          {
            ((j)localObject1).Py(0);
            ((j)localObject1).dRA();
            l3 = ((j)localObject1).yZk;
            l2 = ((j)localObject1).yZj;
            l1 = ((j)localObject1).vtP * 1000L;
          }
          str = localp.dYl().Id;
          localObject4 = localp.dYT();
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
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(15155, (String)localObject1);
      ad.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[] { localObject1 });
      this.yYB.remove(Long.valueOf(localp.field_snsId));
      this.yYB.remove(Long.valueOf(localp.field_snsId + 1L));
      this.yYK.remove(Long.valueOf(localp.field_snsId));
      this.yYJ.remove(Long.valueOf(localp.field_snsId));
      m = i;
      if (!this.yYE.containsKey(paramString)) {
        break label2953;
      }
      str = "";
      if (f(localp) != null) {
        str = f(localp).aQj;
      }
      locala = (a)this.yYE.remove(paramString);
      this.yYy.put(paramString, Long.valueOf(com.tencent.mm.sdk.platformtools.bt.HI()));
      if (locala != null) {
        break label1879;
      }
      AppMethodBeat.o(197605);
      return;
      i = 1;
      break;
      j = 0;
      break label1428;
      k = 0;
      break label1473;
    }
    label1879:
    long l1 = com.tencent.mm.sdk.platformtools.bt.aO(locala.yYV);
    if (locala.yYX > 0L) {
      locala.yZa += com.tencent.mm.sdk.platformtools.bt.aO(locala.yYX);
    }
    localObject1 = new StringBuilder("onAdRemoved ").append(paramInt1).append(" ").append(paramString).append(" ").append(l1).append(", snsId=").append(com.tencent.mm.plugin.sns.data.q.zw(paramLong)).append(", snsInfo==null?");
    if (localp == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsAdStatistic", bool);
      if (localp != null) {
        break;
      }
      AppMethodBeat.o(197605);
      return;
    }
    localObject1 = "";
    Object localObject4 = localp.dYl();
    label2063:
    Object localObject6;
    if (localp.dRL().dVY())
    {
      i = 3;
      localObject1 = "";
      localObject4 = f(localp);
      if (localObject4 == null)
      {
        localObject4 = "";
        localObject6 = new b();
        ((b)localObject6).yXE = paramInt1;
        ((b)localObject6).yXF = localp;
        if (localc == null) {
          break label2948;
        }
        paramInt1 = localc.gfU;
        label2096:
        ((b)localObject6).yXG = paramInt1;
        ((b)localObject6).yXI = locala.yZb;
        ((b)localObject6).yXH = locala.yZc;
        ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime result=" + locala.yZb + ", id=" + paramString);
        ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime result=" + locala.yZc + ", id=" + paramString);
        paramString = new f(str, paramInt2, 2, (int)l1, (com.tencent.mm.protocal.protobuf.bt)localObject3, (bw)localObject2, i, (String)localObject1, -1, localp.dYV(), (int)locala.yZa, (int)locala.yZb, m, g(localp), h(localp), (String)localObject4, (b)localObject6);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
        AppMethodBeat.o(197605);
      }
    }
    else if (localp.dYX())
    {
      i = 6;
      localObject1 = (j)this.yYC.remove(Long.valueOf(locala.yXT));
      if (localObject1 == null) {
        break label3021;
      }
      if (localp.field_likeFlag == 0) {
        ((j)localObject1).Py(0);
      }
    }
    label2948:
    label2953:
    label3013:
    label3021:
    for (localObject1 = ((j)localObject1).dRz();; localObject1 = "")
    {
      break;
      if ((localp.dVZ()) || (localp.dWa())) {
        if ((localObject4 != null) && (((TimeLineObject)localObject4).HAT.GaP == 15) && (((TimeLineObject)localObject4).HBa != 1))
        {
          localObject4 = (j)this.yYC.remove(Long.valueOf(locala.yXT));
          if (localObject4 == null) {
            break label3013;
          }
          ((j)localObject4).Py(0);
        }
      }
      for (localObject1 = ((j)localObject4).dRz();; localObject1 = "")
      {
        this.yYB.remove(Long.valueOf(locala.yXT));
        if (localp.dWc())
        {
          i = 0;
          j = 0;
          if ((localObject4 != null) && (((j)localObject4).yZn != null) && (((j)localObject4).yZn.size() > 0)) {
            j = i;
          }
          for (;;)
          {
            try
            {
              n = ((j)localObject4).yZn.size() - 1;
              j = i;
              localObject6 = (com.tencent.mm.plugin.sns.ad.d.a.a)((j)localObject4).yZn.get(n);
              j = i;
              i = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject6).zan;
              j = i;
              k = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject6).zao;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                try
                {
                  int n;
                  ad.i("MicroMsg.SnsAdStatistic", "longPressGestureAd, playitems.size=" + ((j)localObject4).yZn.size() + ", lastIdx=" + n);
                  j = i;
                  i = k;
                  if (this.dnh == 0) {
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
                  ((JSONObject)localObject4).put("uxinfo", com.tencent.mm.sdk.platformtools.bt.nullAsNil(localp.dRK().dFy));
                  ((JSONObject)localObject4).put("scene", k);
                  localObject6 = new JSONObject();
                  ((JSONObject)localObject6).put("playCount", j);
                  ((JSONObject)localObject6).put("playTotalTime", i);
                  ((JSONObject)localObject4).put("extInfo", localObject6);
                  localObject4 = ((JSONObject)localObject4).toString();
                  com.tencent.mm.plugin.sns.data.j.jf("timeline_fullcard_longpress_exposure", (String)localObject4);
                  ad.i("SnsAdPressGestureCtrl", "reportVideoPlay, content=" + (String)localObject4 + ", channel=timeline_fullcard_longpress_exposure");
                  i = 5;
                }
                catch (Exception localException2)
                {
                  ad.i("SnsAdPressGestureCtrl", "reportVideoPlay, exp=" + localException2.toString());
                }
              }
              localException1 = localException1;
              k = 0;
            }
            ad.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, reportVideoPlay exp=" + localException1.toString());
            i = k;
            continue;
            ad.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, advideo.playitems is Empty");
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
        if (locala.oIb == 9)
        {
          i = 2;
          localObject5 = (j)this.yYC.remove(Long.valueOf(locala.yXT));
          if (localObject5 != null)
          {
            ((j)localObject5).Py(0);
            localObject1 = ((j)localObject5).dRz();
          }
          this.yYB.remove(Long.valueOf(locala.yXT));
          break;
        }
        i = 1;
        localObject1 = "";
        break;
        localObject5 = ((com.tencent.mm.plugin.sns.storage.a)localObject5).zvb;
        break label2063;
        paramInt1 = 0;
        break label2096;
        ad.w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + paramInt1 + " " + paramString + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zw(paramLong));
        AppMethodBeat.o(197605);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95013);
    this.yYx.add(Long.valueOf(paramLong));
    this.yYw.put(paramString, Long.valueOf(paramLong));
    if (this.yYM == -1) {
      if (this.activity != null) {
        break label114;
      }
    }
    p localp;
    label114:
    for (int i = -1;; i = al.jH(this.activity))
    {
      this.yYM = i;
      localp = ag.dUe().aAa(paramString);
      if (localp != null) {
        break;
      }
      ad.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!, snsId=" + com.tencent.mm.plugin.sns.data.q.zw(paramLong) + ", localId=" + paramString);
      AppMethodBeat.o(95013);
      return;
    }
    Object localObject1 = (c)this.yYA.get(paramString);
    Object localObject2 = f(localp);
    if (localObject2 != null) {}
    for (String str = ((com.tencent.mm.plugin.sns.storage.a)localObject2).aQj;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (ag.zjc))
      {
        paramSnsObject = new c((com.tencent.mm.plugin.sns.storage.a)localObject2, paramString, paramLong, paramView, this.yXO, this.yYI, this.yYM, paramInt3, paramSnsObject, paramInt1, localp.dRL());
        paramSnsObject.yYa = System.currentTimeMillis();
        ag.cVf().post(new c.1(paramSnsObject));
        this.yYA.put(paramString, paramSnsObject);
        paramView = paramSnsObject;
        if (!this.yYJ.containsKey(Long.valueOf(paramLong)))
        {
          paramView = this.yYJ;
          if (localp.field_likeFlag != 1) {
            break label557;
          }
          i = 1;
          paramView.put(Long.valueOf(paramLong), Integer.valueOf(i));
        }
      }
      for (paramView = paramSnsObject;; paramView = (View)localObject1)
      {
        label374:
        long l;
        if ((paramInt2 == 11) && (localp.dYl().HAT.GaQ.size() > 1))
        {
          if (this.yYD.containsKey(Long.valueOf(paramLong)))
          {
            paramSnsObject = (j)this.yYD.get(Long.valueOf(paramLong));
            paramSnsObject.yZg = com.tencent.mm.sdk.platformtools.bt.HI();
            this.yYD.put(Long.valueOf(paramLong), paramSnsObject);
          }
        }
        else
        {
          if (!this.yYL.contains(paramString))
          {
            this.yYL.add(paramString);
            com.tencent.mm.plugin.sns.data.q.o(localp);
          }
          if (!this.yYy.containsKey(paramString)) {
            break label601;
          }
          l = com.tencent.mm.sdk.platformtools.bt.aO(((Long)this.yYy.get(paramString)).longValue());
          if (l >= 1200000L) {
            break label1088;
          }
          if (!this.yYz.containsKey(paramString)) {
            break label577;
          }
        }
        label557:
        label577:
        for (i = ((Integer)this.yYz.get(paramString)).intValue();; i = 0)
        {
          if (i < 100) {
            break label583;
          }
          ad.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
          AppMethodBeat.o(95013);
          return;
          i = 0;
          break;
          paramSnsObject = new j("timeline");
          break label374;
        }
        label583:
        this.yYz.put(paramString, Integer.valueOf(i + 1));
        label601:
        TimeLineObject localTimeLineObject;
        if (!this.yYE.containsKey(paramString))
        {
          this.yYE.put(paramString, new a(com.tencent.mm.sdk.platformtools.bt.HI(), System.currentTimeMillis(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
          ad.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zw(paramLong) + ", expoureScene=" + paramInt3);
          if ((paramInt2 != 9) && (paramInt2 != 13) && (paramInt2 != 14)) {
            break label1137;
          }
          if (!this.yYC.containsKey(Long.valueOf(paramLong))) {
            break label1123;
          }
          paramSnsObject = (j)this.yYC.get(Long.valueOf(paramLong));
          label772:
          paramSnsObject.yZg = com.tencent.mm.sdk.platformtools.bt.HI();
          this.yYC.put(Long.valueOf(paramLong), paramSnsObject);
          label797:
          if (!this.yYF.containsKey(paramString))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            this.yYF.put(paramString, Integer.valueOf(i));
            ad.i("MicroMsg.SnsAdStatistic", "exposures item " + paramString + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zw(paramLong) + ", time=" + i);
          }
          localObject1 = localp.dRL();
          localTimeLineObject = localp.dYl();
          paramSnsObject = null;
          paramString = paramSnsObject;
          if (paramView != null)
          {
            paramString = paramSnsObject;
            if (ag.zjc) {
              paramString = paramView.dRx();
            }
          }
          paramSnsObject = localp.dYU();
          i = 0;
          if (this.dnh == 0)
          {
            i = paramSnsObject.field_exposureCount + 1;
            paramSnsObject.field_exposureCount = i;
            ag.dUh().update(paramSnsObject, new String[0]);
          }
          if (localObject2 != null) {
            break label1271;
          }
          paramSnsObject = "";
          label979:
          localObject2 = new b();
          ((b)localObject2).yXE = paramInt1;
          ((b)localObject2).yXF = localp;
          if (paramView == null) {
            break label1281;
          }
          paramInt1 = paramView.gfU;
          label1012:
          ((b)localObject2).yXG = paramInt1;
          if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).dVY()) {
            break label1286;
          }
          paramInt1 = 3;
        }
        for (;;)
        {
          paramString = new f(str, paramInt3, paramString, paramInt1, i, localp.dYV(), g(localp), h(localp), paramSnsObject, (b)localObject2);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
          AppMethodBeat.o(95013);
          return;
          label1088:
          this.yYy.put(paramString, Long.valueOf(com.tencent.mm.sdk.platformtools.bt.HI()));
          this.yYz.put(paramString, Integer.valueOf(0));
          break;
          label1123:
          paramSnsObject = new j("timeline");
          break label772;
          label1137:
          if ((paramInt2 != 11) || (localp.dYl().HAT.GaQ.size() <= 0) || (((byn)localp.dYl().HAT.GaQ.get(0)).nEf != 6)) {
            break label797;
          }
          if (this.yYC.containsKey(Long.valueOf(paramLong))) {}
          for (paramSnsObject = (j)this.yYC.get(Long.valueOf(paramLong));; paramSnsObject = new j("timeline"))
          {
            paramSnsObject.yZg = com.tencent.mm.sdk.platformtools.bt.HI();
            paramSnsObject.yZl = true;
            this.yYC.put(Long.valueOf(paramLong), paramSnsObject);
            break;
          }
          label1271:
          paramSnsObject = ((com.tencent.mm.plugin.sns.storage.a)localObject2).zvb;
          break label979;
          label1281:
          paramInt1 = 0;
          break label1012;
          label1286:
          if (localp.dYX()) {
            paramInt1 = 6;
          } else if ((localp.dVZ()) || (localp.dWa()))
          {
            if ((localTimeLineObject != null) && (localTimeLineObject.HAT.GaP == 15) && (localTimeLineObject.HBa != 1)) {
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
  
  public final void aj(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95005);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94992);
        if (i.this.zl(paramLong1))
        {
          i locali = i.this;
          long l = this.yYR;
          if (!locali.yYB.contains(Long.valueOf(l))) {
            locali.yYB.add(Long.valueOf(l));
          }
        }
        AppMethodBeat.o(94992);
      }
    });
    AppMethodBeat.o(95005);
  }
  
  public final void ak(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(197608);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197604);
        j localj = (j)i.this.yYC.get(Long.valueOf(paramLong1));
        if (localj != null) {
          localj.yZp = this.yYU;
        }
        AppMethodBeat.o(197604);
      }
    });
    AppMethodBeat.o(197608);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95002);
    j localj;
    if (paramBoolean2) {
      if (this.yYD.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.yYD.get(Long.valueOf(paramLong));
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
      localj.yZe = paramInt;
      if (!paramBoolean2) {
        break label166;
      }
      this.yYD.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95002);
      return;
      localj = new j("timeline");
      break;
      if (this.yYC.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.yYC.get(Long.valueOf(paramLong));
        break;
      }
      localj = new j("timeline");
      break;
    }
    label166:
    this.yYC.put(Long.valueOf(paramLong), localj);
    AppMethodBeat.o(95002);
  }
  
  public final void c(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95004);
    j localj;
    if (paramBoolean2) {
      if (this.yYD.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.yYD.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label160;
        }
      }
    }
    label160:
    for (localj.yZm.zaq = 2;; localj.yZm.zaq = 1)
    {
      localj.yZm.zar = 1;
      if (!paramBoolean2) {
        break label172;
      }
      this.yYD.put(Long.valueOf(paramLong), localj);
      AppMethodBeat.o(95004);
      return;
      localj = new j("timeline");
      break;
      if (this.yYC.containsKey(Long.valueOf(paramLong)))
      {
        localj = (j)this.yYC.get(Long.valueOf(paramLong));
        break;
      }
      localj = new j("timeline");
      break;
    }
    label172:
    this.yYC.put(Long.valueOf(paramLong), localj);
    AppMethodBeat.o(95004);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(95016);
    ad.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
    Object localObject1 = new HashSet(this.yYE.keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.yYE.get(localObject2);
      a(((a)localObject2).position, ((a)localObject2).dJC, ((a)localObject2).yXT, ((a)localObject2).imS);
    }
    localObject1 = new HashMap(this.yYF);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94994);
        Iterator localIterator = this.yYT.keySet().iterator();
        com.tencent.mm.plugin.sns.storage.e locale;
        p localp;
        int j;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          locale = ag.dUh().QK(x.aAw(str));
          if (locale != null)
          {
            localp = locale.dYr();
            locale.field_localFlag |= 0x80;
            j = 0;
            i = (int)(System.currentTimeMillis() / 1000L);
            if (!this.yYT.containsKey(str)) {
              break label246;
            }
            i = ((Integer)this.yYT.get(str)).intValue();
            j = 1;
          }
        }
        label246:
        for (;;)
        {
          if (locale.field_exposureTime <= 0)
          {
            locale.field_exposureTime = i;
            ad.i("MicroMsg.SnsAdStatistic", "update Ad ExposureTime, snsId=" + com.tencent.mm.plugin.sns.data.q.zw(locale.field_snsId) + ", exposuretime=" + i + "， sys.currentTimeMis=" + System.currentTimeMillis() + ", type=" + j);
          }
          localp.field_localFlag |= 0x80;
          ag.dUe().b(localp.field_snsId, localp);
          ag.dUh().b(locale.field_snsId, locale);
          break;
          AppMethodBeat.o(94994);
          return;
        }
      }
    });
    this.yYE.clear();
    this.yYF.clear();
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
        if (i.this.zl(paramLong1))
        {
          i locali = i.this;
          long l1 = paramLong1;
          long l2 = paramBoolean;
          boolean bool = this.yYO;
          j localj;
          if (bool) {
            if (locali.yYD.containsKey(Long.valueOf(l1))) {
              localj = (j)locali.yYD.get(Long.valueOf(l1));
            }
          }
          for (;;)
          {
            if (localj.yZm.zas == 0L) {
              localj.yZm.zas = l2;
            }
            if (!bool) {
              break;
            }
            locali.yYD.put(Long.valueOf(l1), localj);
            AppMethodBeat.o(94993);
            return;
            localj = new j("timeline");
            continue;
            if (locali.yYC.containsKey(Long.valueOf(l1))) {
              localj = (j)locali.yYC.get(Long.valueOf(l1));
            } else {
              localj = new j("timeline");
            }
          }
          locali.yYC.put(Long.valueOf(l1), localj);
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
        i.this.b(paramLong, paramBoolean, this.yYQ, this.yYO);
        AppMethodBeat.o(94991);
      }
    });
    AppMethodBeat.o(95000);
  }
  
  public final long eP(String paramString, int paramInt)
  {
    AppMethodBeat.i(94997);
    c localc = (c)this.yYA.get(paramString);
    if (localc != null) {}
    for (long l = localc.yYa;; l = 0L)
    {
      ad.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(94997);
      return l;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(95009);
    Iterator localIterator = this.yYE.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.yYE.get(localObject2);
      ad.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).yZa += com.tencent.mm.sdk.platformtools.bt.aO(((a)localObject1).yYX);
      ((a)localObject1).yYX = 0L;
      localObject2 = (j)this.yYC.get(Long.valueOf(((a)localObject1).yXT));
      if (localObject2 != null) {
        ((j)localObject2).imX = com.tencent.mm.sdk.platformtools.bt.HI();
      }
      localObject1 = (j)this.yYD.get(Long.valueOf(((a)localObject1).yXT));
      if (localObject1 != null) {
        ((j)localObject1).imX = com.tencent.mm.sdk.platformtools.bt.HI();
      }
    }
    localIterator = this.yYA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (ag.zjc))
      {
        ((c)localObject1).ri(false);
        if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((c)localObject1).drH)) && (this.yYE.get(((c)localObject1).drH) != null))
        {
          localObject2 = (a)this.yYE.get(((c)localObject1).drH);
          long l;
          if (((a)localObject2).yYZ > 0L)
          {
            l = com.tencent.mm.sdk.platformtools.bt.aO(((a)localObject2).yYZ);
            ((a)localObject2).yZb += l;
            ((a)localObject2).yYZ = 0L;
            ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).yZb + ", id=" + ((c)localObject1).drH);
          }
          if (((a)localObject2).yZd > 0L)
          {
            l = com.tencent.mm.sdk.platformtools.bt.aO(((a)localObject2).yZd);
            ((a)localObject2).yZc += l;
            ((a)localObject2).yZd = 0L;
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).yZc + ", id=" + ((c)localObject1).drH);
          }
        }
      }
    }
    AppMethodBeat.o(95009);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(94998);
    long l = com.tencent.mm.sdk.platformtools.bt.HI();
    Iterator localIterator = this.yYE.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.yYE.get(localObject2);
      ad.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).yYX = l;
      localObject2 = (j)this.yYC.get(Long.valueOf(((a)localObject1).yXT));
      if (localObject2 != null) {
        ((j)localObject2).onResume();
      }
      localObject1 = (j)this.yYD.get(Long.valueOf(((a)localObject1).yXT));
      if (localObject1 != null) {
        ((j)localObject1).onResume();
      }
    }
    localIterator = this.yYA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (ag.zjc))
      {
        ((c)localObject1).ri(false);
        if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((c)localObject1).drH)) && (this.yYE.get(((c)localObject1).drH) != null))
        {
          localObject2 = (a)this.yYE.get(((c)localObject1).drH);
          if (((c)localObject1).dRy())
          {
            ((a)localObject2).yYZ = com.tencent.mm.sdk.platformtools.bt.HI();
            ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + ((c)localObject1).drH);
          }
          else if (((c)localObject1).yYu)
          {
            ((a)localObject2).yZd = com.tencent.mm.sdk.platformtools.bt.HI();
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + ((c)localObject1).drH);
          }
        }
      }
    }
    AppMethodBeat.o(94998);
  }
  
  public final void rj(boolean paramBoolean)
  {
    AppMethodBeat.i(95015);
    ad.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.yYA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localc != null) && (ag.zjc))
      {
        localc.ri(paramBoolean);
        if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(localc.drH)) && (this.yYE.get(localc.drH) != null))
        {
          a locala = (a)this.yYE.get(localc.drH);
          boolean bool = localc.dRy();
          if ((bool) && (locala.yYZ == 0L))
          {
            locala.yYZ = com.tencent.mm.sdk.platformtools.bt.HI();
            ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + localc.drH);
          }
          long l;
          for (;;)
          {
            bool = localc.yYu;
            if ((!bool) || (locala.yZd != 0L)) {
              break label326;
            }
            locala.yZd = com.tencent.mm.sdk.platformtools.bt.HI();
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + localc.drH);
            break;
            if ((!bool) && (locala.yYZ > 0L))
            {
              l = com.tencent.mm.sdk.platformtools.bt.aO(locala.yYZ);
              locala.yZb += l;
              locala.yYZ = 0L;
              ad.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + locala.yZb);
            }
          }
          label326:
          if ((!bool) && (locala.yZd > 0L))
          {
            l = com.tencent.mm.sdk.platformtools.bt.aO(locala.yZd);
            locala.yZc += l;
            locala.yZd = 0L;
            ad.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + locala.yZc);
          }
        }
      }
    }
    AppMethodBeat.o(95015);
  }
  
  public final boolean zl(long paramLong)
  {
    AppMethodBeat.i(94995);
    boolean bool = this.yYx.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(94995);
    return bool;
  }
  
  public final boolean zm(long paramLong)
  {
    AppMethodBeat.i(95006);
    if (this.yYB.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95006);
      return true;
    }
    AppMethodBeat.o(95006);
    return false;
  }
  
  public final void zn(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = 0;
    if (this.yYJ.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.yYJ.get(Long.valueOf(paramLong))).intValue();
    }
    this.yYJ.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95017);
  }
  
  public final void zo(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = 0;
    if (this.yYK.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.yYK.get(Long.valueOf(paramLong))).intValue();
    }
    this.yYK.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95018);
  }
  
  public final void zp(final long paramLong)
  {
    AppMethodBeat.i(197606);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197602);
        j localj = (j)i.this.yYC.get(Long.valueOf(paramLong));
        if (localj != null) {
          localj.dRB();
        }
        AppMethodBeat.o(197602);
      }
    });
    AppMethodBeat.o(197606);
  }
  
  public final void zq(final long paramLong)
  {
    AppMethodBeat.i(197607);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197603);
        j localj = (j)i.this.yYC.get(Long.valueOf(paramLong));
        if ((localj != null) && (!i.a(i.this))) {
          localj.dQt();
        }
        AppMethodBeat.o(197603);
      }
    });
    AppMethodBeat.o(197607);
  }
  
  public final long zr(long paramLong)
  {
    AppMethodBeat.i(197609);
    try
    {
      j localj = (j)this.yYC.get(Long.valueOf(paramLong));
      if (localj != null)
      {
        paramLong = localj.yZp;
        AppMethodBeat.o(197609);
        return paramLong;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + localThrowable.toString());
      AppMethodBeat.o(197609);
    }
    return 0L;
  }
  
  static final class a
  {
    public String dJC;
    public int imS;
    public int oIb;
    public int position;
    public long yXT;
    public long yYV;
    public long yYW;
    public long yYX;
    public String yYY;
    public long yYZ;
    public long yZa;
    public long yZb;
    public long yZc;
    public long yZd;
    
    public a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3, int paramInt3)
    {
      this.yYV = paramLong1;
      this.yYW = paramLong2;
      this.yYX = paramLong1;
      this.dJC = paramString1;
      this.position = paramInt1;
      this.yYY = paramString2;
      this.yXT = paramLong3;
      this.oIb = paramInt2;
      this.imS = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.i
 * JD-Core Version:    0.7.0.1
 */