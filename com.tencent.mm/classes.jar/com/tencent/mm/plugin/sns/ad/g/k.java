package com.tencent.mm.plugin.sns.ad.g;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.d.a.c.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

public final class k
  implements e
{
  public static Map<String, Integer> Dvs;
  private int CHZ;
  private int DuA;
  public HashMap<String, Long> Dvh;
  public HashSet<Long> Dvi;
  private Map<String, Long> Dvj;
  private Map<String, Integer> Dvk;
  private Map<String, c> Dvl;
  public HashSet<Long> Dvm;
  public Map<Long, l> Dvn;
  public Map<Long, l> Dvo;
  public Map<String, d> Dvp;
  public Map<String, a> Dvq;
  private Map<String, Integer> Dvr;
  private int Dvt;
  private View Dvu;
  public Map<Long, Integer> Dvv;
  public Map<Long, Integer> Dvw;
  public HashSet<String> Dvx;
  private Activity activity;
  public int source;
  
  static
  {
    AppMethodBeat.i(95019);
    Dvs = new HashMap();
    AppMethodBeat.o(95019);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(94996);
    this.Dvh = new HashMap();
    this.Dvi = new HashSet();
    this.Dvj = new HashMap();
    this.Dvk = new HashMap();
    this.Dvl = new HashMap();
    this.Dvm = new HashSet();
    this.Dvn = new HashMap();
    this.Dvo = new HashMap();
    this.Dvp = new HashMap();
    this.Dvq = new HashMap();
    this.source = 0;
    this.Dvr = new HashMap();
    this.Dvt = 0;
    this.DuA = 0;
    this.Dvu = null;
    this.Dvv = new HashMap();
    this.Dvw = new HashMap();
    this.Dvx = new HashSet();
    this.CHZ = -1;
    this.source = paramInt;
    AppMethodBeat.o(94996);
  }
  
  private d aNM(String paramString)
  {
    AppMethodBeat.i(202050);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(202050);
        return null;
      }
      paramString = (d)this.Dvp.remove(paramString);
      AppMethodBeat.o(202050);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SnsAdStatistic", "removeAdRemovedListener exp= " + paramString.toString());
      AppMethodBeat.o(202050);
    }
    return null;
  }
  
  private ADInfo g(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95010);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        AppMethodBeat.o(95010);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdInfo();
      AppMethodBeat.o(95010);
      return paramSnsInfo;
    }
    AppMethodBeat.o(95010);
    return null;
  }
  
  private com.tencent.mm.bw.b h(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95011);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSourceInfo();
        AppMethodBeat.o(95011);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdSnsInfo().getTimelineRemindInfoSourceInfo();
      AppMethodBeat.o(95011);
      return paramSnsInfo;
    }
    AppMethodBeat.o(95011);
    return null;
  }
  
  private com.tencent.mm.bw.b i(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95012);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSelfInfo();
        AppMethodBeat.o(95012);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdSnsInfo().getTimelineRemindInfoSelfInfo();
      AppMethodBeat.o(95012);
      return paramSnsInfo;
    }
    AppMethodBeat.o(95012);
    return null;
  }
  
  public final void I(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(94999);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94990);
        if (k.this.IP(paramLong))
        {
          k localk = k.this;
          long l = paramLong;
          boolean bool = this.Dvz;
          l locall;
          if (bool) {
            if (localk.Dvo.containsKey(Long.valueOf(l))) {
              locall = (l)localk.Dvo.get(Long.valueOf(l));
            }
          }
          for (;;)
          {
            locall.DvO = 1;
            locall.DvW.DwX += 1;
            if (!bool) {
              break;
            }
            localk.Dvo.put(Long.valueOf(l), locall);
            AppMethodBeat.o(94990);
            return;
            locall = new l("timeline");
            continue;
            if (localk.Dvn.containsKey(Long.valueOf(l))) {
              locall = (l)localk.Dvn.get(Long.valueOf(l));
            } else {
              locall = new l("timeline");
            }
          }
          localk.Dvn.put(Long.valueOf(l), locall);
        }
        AppMethodBeat.o(94990);
      }
    });
    AppMethodBeat.o(94999);
  }
  
  public final boolean IP(long paramLong)
  {
    AppMethodBeat.i(94995);
    boolean bool = this.Dvi.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(94995);
    return bool;
  }
  
  public final boolean IQ(long paramLong)
  {
    AppMethodBeat.i(95006);
    if (this.Dvm.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95006);
      return true;
    }
    AppMethodBeat.o(95006);
    return false;
  }
  
  public final void IR(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = 0;
    if (this.Dvv.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.Dvv.get(Long.valueOf(paramLong))).intValue();
    }
    this.Dvv.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95017);
  }
  
  public final void IS(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = 0;
    if (this.Dvw.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.Dvw.get(Long.valueOf(paramLong))).intValue();
    }
    this.Dvw.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95018);
  }
  
  public final void IT(final long paramLong)
  {
    AppMethodBeat.i(202045);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202039);
        l locall = (l)k.this.Dvn.get(Long.valueOf(paramLong));
        if (locall != null) {
          locall.eXt();
        }
        AppMethodBeat.o(202039);
      }
    });
    AppMethodBeat.o(202045);
  }
  
  public final void IU(final long paramLong)
  {
    AppMethodBeat.i(202046);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202040);
        l locall = (l)k.this.Dvn.get(Long.valueOf(paramLong));
        if ((locall != null) && (!k.a(k.this))) {
          locall.eVQ();
        }
        AppMethodBeat.o(202040);
      }
    });
    AppMethodBeat.o(202046);
  }
  
  public final long IV(long paramLong)
  {
    AppMethodBeat.i(202048);
    try
    {
      l locall = (l)this.Dvn.get(Long.valueOf(paramLong));
      if (locall != null)
      {
        paramLong = locall.DvZ;
        AppMethodBeat.o(202048);
        return paramLong;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + localThrowable.toString());
      AppMethodBeat.o(202048);
    }
    return 0L;
  }
  
  public final void J(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95003);
    d(paramLong, paramBoolean, false);
    AppMethodBeat.o(95003);
  }
  
  public final void K(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95008);
    l locall;
    if (paramBoolean)
    {
      if (this.Dvo.containsKey(Long.valueOf(paramLong)))
      {
        locall = (l)this.Dvo.get(Long.valueOf(paramLong));
        locall.XK(0);
      }
      for (;;)
      {
        this.Dvo.put(Long.valueOf(paramLong), locall);
        AppMethodBeat.o(95008);
        return;
        locall = new l("timeline");
      }
    }
    if (this.Dvn.containsKey(Long.valueOf(paramLong)))
    {
      locall = (l)this.Dvn.get(Long.valueOf(paramLong));
      locall.XK(0);
    }
    for (;;)
    {
      this.Dvn.put(Long.valueOf(paramLong), locall);
      AppMethodBeat.o(95008);
      return;
      locall = new l("timeline");
    }
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.DuA = paramInt;
    this.Dvu = paramView;
    this.activity = paramActivity;
  }
  
  public final void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(202043);
    if (this.Dvh.containsKey(paramString))
    {
      l1 = ((Long)this.Dvh.remove(paramString)).longValue();
      this.Dvi.remove(Long.valueOf(l1));
    }
    Object localObject1 = null;
    String str = null;
    c localc = (c)this.Dvl.get(paramString);
    Object localObject3 = localObject1;
    Object localObject2 = str;
    label147:
    label879:
    int i;
    if (localc != null)
    {
      localObject3 = localObject1;
      localObject2 = str;
      if (aj.DKh)
      {
        localc.idt = true;
        localc.DuM = System.currentTimeMillis();
        localc.Dve = 0;
        uM(false);
        if (localc.DuH < 0)
        {
          localc.Dvc = 2;
          if (localc.DuJ >= 0) {
            break label1224;
          }
          localc.Dvd = 2;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(r.Jb(localc.DuE) + ",");
          ((StringBuilder)localObject1).append(localc.gTk + ",");
          ((StringBuilder)localObject1).append(localc.Dvc + ",");
          ((StringBuilder)localObject1).append(localc.Dvd + ",");
          ((StringBuilder)localObject1).append(localc.DuZ + ",");
          ((StringBuilder)localObject1).append(localc.Dva + ",");
          ((StringBuilder)localObject1).append(localc.Dvb + ",");
          ((StringBuilder)localObject1).append(localc.DuL + ",");
          ((StringBuilder)localObject1).append(localc.DuM + ",");
          if ((localc.DuP > 0L) && (localc.DuS == 0L))
          {
            localc.DuS = System.currentTimeMillis();
            Log.d("MicroMsg.AdViewStatic", "halfExposure old 2, end:" + (localc.DuS - localc.DuP) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.DuP + ",");
          ((StringBuilder)localObject1).append(localc.DuS + ",");
          if ((localc.DuV > 0L) && (localc.DuY == 0L))
          {
            localc.DuY = System.currentTimeMillis();
            Log.d("MicroMsg.AdViewStatic", "fullExposure old 2, end:" + (localc.DuY - localc.DuV) + ", hash=" + localc.hashCode());
          }
          ((StringBuilder)localObject1).append(localc.DuV + ",");
          ((StringBuilder)localObject1).append(localc.DuY);
          j.a(localc.DuE, (StringBuilder)localObject1);
          Log.i("MicroMsg.AdViewStatic", "report " + ((StringBuilder)localObject1).toString());
          localObject3 = new cc();
          ((cc)localObject3).KGh = localc.DuV;
          ((cc)localObject3).KGi = localc.DuY;
          ((cc)localObject3).Dvc = localc.Dvc;
          ((cc)localObject3).Dvd = localc.Dvd;
          ((cc)localObject3).KGc = localc.DuZ;
          ((cc)localObject3).KGd = localc.Dva;
          ((cc)localObject3).KGe = localc.Dvb;
          ((cc)localObject3).KGf = localc.DuP;
          ((cc)localObject3).KGg = localc.DuS;
          ((cc)localObject3).startTime = localc.DuL;
          ((cc)localObject3).endTime = localc.DuM;
          if ((localc.DuG == null) || (!localc.DuG.isRecExpAd())) {
            break label1233;
          }
          aj.faI().a(14648, new Object[] { ((StringBuilder)localObject1).toString() });
          localObject2 = com.tencent.mm.modelsns.k.tO(730);
          ((com.tencent.mm.modelsns.k)localObject2).PH(r.Jb(localc.DuE)).PH(localc.gTk).tR(localc.Dvc).tR(localc.Dvd).tR(localc.DuZ).tR(localc.Dva).tR(localc.Dvb).PH(localc.DuL).PH(localc.DuM).PH(localc.DuP).PH(localc.DuS).PH(localc.DuV).PH(localc.DuY);
          ((com.tencent.mm.modelsns.k)localObject2).bfK();
          localObject2 = new nq();
          ((nq)localObject2).dTN.position = localc.position;
          EventCenter.instance.publish((IEvent)localObject2);
          if (!ac.jPj) {
            break label1281;
          }
          j = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
          Log.i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(j)));
          i = 0;
          label1159:
          if (i >= j) {
            break label1281;
          }
          if ((localc.DuG == null) || (!localc.DuG.isRecExpAd())) {
            break label1257;
          }
          aj.faI().a(14648, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        for (;;)
        {
          i += 1;
          break label1159;
          localc.Dvc = 1;
          break;
          label1224:
          localc.Dvd = 1;
          break label147;
          label1233:
          aj.faI().a(12010, new Object[] { ((StringBuilder)localObject1).toString() });
          break label879;
          label1257:
          aj.faI().a(12010, new Object[] { ((StringBuilder)localObject1).toString() });
        }
        label1281:
        localObject2 = localc.eXo();
        this.Dvl.remove(paramString);
      }
    }
    this.Dvx.remove(paramString);
    int m = 0;
    int j = 0;
    SnsInfo localSnsInfo = aj.faO().aQm(paramString);
    label1429:
    int k;
    label1474:
    long l3;
    long l2;
    if (localSnsInfo != null)
    {
      i = j;
      if (this.Dvo.containsKey(Long.valueOf(localSnsInfo.field_snsId)))
      {
        i = j;
        if (localSnsInfo.getTimeLine().ContentObj.LoU == 27)
        {
          if (localSnsInfo.field_likeFlag != 1) {
            break label1855;
          }
          i = 2;
          if (!this.Dvw.containsKey(Long.valueOf(localSnsInfo.field_snsId))) {
            break label1861;
          }
          j = ((Integer)this.Dvw.get(Long.valueOf(localSnsInfo.field_snsId))).intValue();
          if (!this.Dvv.containsKey(Long.valueOf(localSnsInfo.field_snsId))) {
            break label1867;
          }
          k = ((Integer)this.Dvv.get(Long.valueOf(localSnsInfo.field_snsId))).intValue();
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          localObject1 = (l)this.Dvo.remove(Long.valueOf(localSnsInfo.field_snsId));
          if (localObject1 != null)
          {
            ((l)localObject1).XK(0);
            ((l)localObject1).eXs();
            l3 = ((l)localObject1).DvU;
            l2 = ((l)localObject1).DvT;
            l1 = ((l)localObject1).pLQ * 1000L;
          }
          str = localSnsInfo.getTimeLine().Id;
          localObject4 = localSnsInfo.getUxinfo();
          if (localSnsInfo.field_likeFlag != 1) {
            break label1873;
          }
        }
      }
    }
    a locala;
    label1855:
    label1861:
    label1867:
    label1873:
    for (localObject1 = "1";; localObject1 = "0")
    {
      localObject1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { str, localObject4, String.valueOf(paramInt2), String.valueOf(j), String.valueOf(k), String.valueOf(l3), String.valueOf(l2), String.valueOf(l1), localObject1 });
      h.CyF.kvStat(15155, (String)localObject1);
      Log.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[] { localObject1 });
      this.Dvm.remove(Long.valueOf(localSnsInfo.field_snsId));
      this.Dvm.remove(Long.valueOf(localSnsInfo.field_snsId + 1L));
      this.Dvw.remove(Long.valueOf(localSnsInfo.field_snsId));
      this.Dvv.remove(Long.valueOf(localSnsInfo.field_snsId));
      m = i;
      if (!this.Dvq.containsKey(paramString)) {
        break label3046;
      }
      str = "";
      if (g(localSnsInfo) != null) {
        str = g(localSnsInfo).viewId;
      }
      locala = (a)this.Dvq.remove(paramString);
      this.Dvj.put(paramString, Long.valueOf(Util.currentTicks()));
      if (locala != null) {
        break label1881;
      }
      AppMethodBeat.o(202043);
      return;
      i = 1;
      break;
      j = 0;
      break label1429;
      k = 0;
      break label1474;
    }
    label1881:
    long l1 = Util.ticksToNow(locala.DvF);
    if (locala.DvH > 0L) {
      locala.DvK += Util.ticksToNow(locala.DvH);
    }
    localObject1 = new StringBuilder("onAdRemoved ").append(paramInt1).append(" ").append(paramString).append(" ").append(l1).append(", snsId=").append(r.Jb(paramLong)).append(", snsInfo==null?");
    if (localSnsInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsAdStatistic", bool);
      if (localSnsInfo != null) {
        break;
      }
      AppMethodBeat.o(202043);
      return;
    }
    localObject1 = "";
    Object localObject4 = localSnsInfo.getTimeLine();
    label2066:
    Object localObject6;
    if (localSnsInfo.getAdXml().isLinkAd())
    {
      i = 3;
      localObject1 = "";
      localObject4 = g(localSnsInfo);
      if (localObject4 != null) {
        break label2998;
      }
      localObject4 = "";
      localObject6 = new b();
      ((b)localObject6).Dus = paramInt1;
      ((b)localObject6).DsC = localSnsInfo;
      if (localc == null) {
        break label3008;
      }
      paramInt1 = localc.gRE;
      label2099:
      ((b)localObject6).Dut = paramInt1;
      ((b)localObject6).Duv = locala.DvL;
      ((b)localObject6).Duu = locala.DvM;
      Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime result=" + locala.DvL + ", id=" + paramString);
      Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime result=" + locala.DvM + ", id=" + paramString);
      paramString = new g(str, paramInt2, 2, (int)l1, (cc)localObject3, (cf)localObject2, i, (String)localObject1, -1, localSnsInfo.getAdRecSrc(), (int)locala.DvK, (int)locala.DvL, m, h(localSnsInfo), i(localSnsInfo), (String)localObject4, (b)localObject6);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    }
    try
    {
      paramString = r.v(localSnsInfo);
      localObject1 = aNM(paramString);
      if (localObject1 != null) {
        ((d)localObject1).aNK(paramString);
      }
      AppMethodBeat.o(202043);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SnsAdStatistic", "callSnsAdRemovedListener exp= " + paramString.toString());
      AppMethodBeat.o(202043);
      return;
    }
    if (localSnsInfo.isTurnCardAd())
    {
      i = 6;
      localObject1 = (l)this.Dvn.remove(Long.valueOf(locala.DuE));
      if (localObject1 == null) {
        break label3115;
      }
      if (localSnsInfo.getLikeFlag() == 0) {
        ((l)localObject1).XK(0);
      }
    }
    label3107:
    label3115:
    for (localObject1 = ((l)localObject1).eXr();; localObject1 = "")
    {
      break;
      if ((localSnsInfo.isCardAd()) || (localSnsInfo.isFullCardAd())) {
        if ((localObject4 != null) && (((TimeLineObject)localObject4).ContentObj.LoU == 15) && (((TimeLineObject)localObject4).sightFolded != 1))
        {
          localObject4 = (l)this.Dvn.remove(Long.valueOf(locala.DuE));
          if (localObject4 == null) {
            break label3107;
          }
          ((l)localObject4).XK(0);
        }
      }
      for (localObject1 = ((l)localObject4).eXr();; localObject1 = "")
      {
        this.Dvm.remove(Long.valueOf(locala.DuE));
        if (localSnsInfo.isLongPressGestureAd())
        {
          i = 0;
          j = 0;
          if ((localObject4 != null) && (((l)localObject4).DvX != null) && (((l)localObject4).DvX.size() > 0)) {
            j = i;
          }
          for (;;)
          {
            try
            {
              n = ((l)localObject4).DvX.size() - 1;
              j = i;
              localObject6 = (com.tencent.mm.plugin.sns.ad.g.a.a)((l)localObject4).DvX.get(n);
              j = i;
              i = ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject6).DwX;
              j = i;
              k = ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject6).DwY;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                try
                {
                  int n;
                  Log.i("MicroMsg.SnsAdStatistic", "longPressGestureAd, playitems.size=" + ((l)localObject4).DvX.size() + ", lastIdx=" + n);
                  j = i;
                  i = k;
                  if (this.source == 0) {
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
                  ((JSONObject)localObject4).put("snsid", localSnsInfo.field_snsId);
                  ((JSONObject)localObject4).put("uxinfo", Util.nullAsNil(localSnsInfo.getAdInfo().uxInfo));
                  ((JSONObject)localObject4).put("scene", k);
                  localObject6 = new JSONObject();
                  ((JSONObject)localObject6).put("playCount", j);
                  ((JSONObject)localObject6).put("playTotalTime", i);
                  ((JSONObject)localObject4).put("extInfo", localObject6);
                  localObject4 = ((JSONObject)localObject4).toString();
                  com.tencent.mm.plugin.sns.data.k.jY("timeline_fullcard_longpress_exposure", (String)localObject4);
                  Log.i("SnsAdPressGestureCtrl", "reportVideoPlay, content=" + (String)localObject4 + ", channel=timeline_fullcard_longpress_exposure");
                  i = 5;
                }
                catch (Exception localException2)
                {
                  Log.i("SnsAdPressGestureCtrl", "reportVideoPlay, exp=" + localException2.toString());
                }
              }
              localException1 = localException1;
              k = 0;
            }
            Log.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, reportVideoPlay exp=" + localException1.toString());
            i = k;
            continue;
            Log.e("MicroMsg.SnsAdStatistic", "longPressGestureAd, advideo.playitems is Empty");
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
        if (localSnsInfo.isFinderTopicCardAd())
        {
          i = 9;
          localObject1 = "";
          break;
        }
        if ((locala.qcr == 9) || (locala.qcr == 19))
        {
          i = 2;
          localObject5 = (l)this.Dvn.remove(Long.valueOf(locala.DuE));
          if (localObject5 != null)
          {
            ((l)localObject5).XK(0);
            localObject1 = ((l)localObject5).eXr();
          }
          this.Dvm.remove(Long.valueOf(locala.DuE));
          break;
        }
        i = 1;
        localObject1 = "";
        break;
        label2998:
        localObject5 = ((ADInfo)localObject5).waidPkg;
        break label2066;
        label3008:
        paramInt1 = 0;
        break label2099;
        label3046:
        Log.w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + paramInt1 + " " + paramString + ", snsId=" + r.Jb(paramLong));
        AppMethodBeat.o(202043);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95013);
    this.Dvi.add(Long.valueOf(paramLong));
    this.Dvh.put(paramString, Long.valueOf(paramLong));
    if (this.CHZ == -1) {
      if (this.activity != null) {
        break label114;
      }
    }
    SnsInfo localSnsInfo;
    label114:
    for (int i = -1;; i = ao.jJ(this.activity))
    {
      this.CHZ = i;
      localSnsInfo = aj.faO().aQm(paramString);
      if (localSnsInfo != null) {
        break;
      }
      Log.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!, snsId=" + r.Jb(paramLong) + ", localId=" + paramString);
      AppMethodBeat.o(95013);
      return;
    }
    Object localObject1 = (c)this.Dvl.get(paramString);
    Object localObject2 = g(localSnsInfo);
    if (localObject2 != null) {}
    for (String str = ((ADInfo)localObject2).viewId;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (aj.DKh))
      {
        paramSnsObject = new c((ADInfo)localObject2, paramString, paramLong, paramView, this.DuA, this.Dvu, this.CHZ, paramInt3, paramSnsObject, paramInt1, localSnsInfo.getAdXml());
        paramSnsObject.DuL = System.currentTimeMillis();
        aj.dRd().post(new c.1(paramSnsObject));
        this.Dvl.put(paramString, paramSnsObject);
        paramView = paramSnsObject;
        if (!this.Dvv.containsKey(Long.valueOf(paramLong)))
        {
          paramView = this.Dvv;
          if (localSnsInfo.getLikeFlag() != 1) {
            break label614;
          }
          i = 1;
          paramView.put(Long.valueOf(paramLong), Integer.valueOf(i));
        }
      }
      for (paramView = paramSnsObject;; paramView = (View)localObject1)
      {
        if ((paramInt2 == 11) && (localSnsInfo.getTimeLine().ContentObj.LoV.size() > 1))
        {
          if (this.Dvo.containsKey(Long.valueOf(paramLong)))
          {
            paramSnsObject = (l)this.Dvo.get(Long.valueOf(paramLong));
            paramSnsObject.DvQ = Util.currentTicks();
            this.Dvo.put(Long.valueOf(paramLong), paramSnsObject);
          }
        }
        else if (!this.Dvx.contains(paramString))
        {
          this.Dvx.add(paramString);
          com.tencent.mm.plugin.sns.ad.e.e.f(localSnsInfo);
        }
        for (;;)
        {
          try
          {
            paramSnsObject = localSnsInfo.getAdInfo(this.source);
            com.tencent.mm.plugin.sns.ad.timeline.b.d.a(r.Jb(localSnsInfo.field_snsId), paramSnsObject);
            paramSnsObject = com.tencent.mm.plugin.sns.ad.d.a.eWI();
            i = this.source;
            try
            {
              localObject1 = paramSnsObject.Dsw;
              if (localSnsInfo != null) {
                continue;
              }
              paramSnsObject = null;
              ((com.tencent.mm.plugin.sns.ad.d.a.c)localObject1).c(paramSnsObject);
            }
            catch (Throwable paramSnsObject)
            {
              long l;
              label614:
              TimeLineObject localTimeLineObject;
              continue;
            }
            if (this.Dvj.containsKey(paramString))
            {
              l = Util.ticksToNow(((Long)this.Dvj.get(paramString)).longValue());
              if (l >= 1200000L) {
                break label1189;
              }
              if (this.Dvk.containsKey(paramString))
              {
                i = ((Integer)this.Dvk.get(paramString)).intValue();
                if (i < 100) {
                  continue;
                }
                Log.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
                AppMethodBeat.o(95013);
                return;
                i = 0;
                break;
                paramSnsObject = new l("timeline");
              }
            }
          }
          catch (Throwable paramSnsObject)
          {
            Log.e("MicroMsg.SnsAdStatistic", paramSnsObject.toString());
            continue;
            paramSnsObject = ((com.tencent.mm.plugin.sns.ad.d.a.c)localObject1).b(new c.b(localSnsInfo, i));
            continue;
            i = 0;
            continue;
            this.Dvk.put(paramString, Integer.valueOf(i + 1));
            if (!this.Dvq.containsKey(paramString))
            {
              this.Dvq.put(paramString, new a(Util.currentTicks(), System.currentTimeMillis(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
              Log.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean + ", snsId=" + r.Jb(paramLong) + ", expoureScene=" + paramInt3);
              if ((paramInt2 != 9) && (paramInt2 != 13) && (paramInt2 != 14) && (paramInt2 != 19)) {
                break label1239;
              }
              if (!this.Dvn.containsKey(Long.valueOf(paramLong))) {
                break label1224;
              }
              paramSnsObject = (l)this.Dvn.get(Long.valueOf(paramLong));
              paramSnsObject.DvQ = Util.currentTicks();
              this.Dvn.put(Long.valueOf(paramLong), paramSnsObject);
              if (!this.Dvr.containsKey(paramString))
              {
                i = (int)(System.currentTimeMillis() / 1000L);
                this.Dvr.put(paramString, Integer.valueOf(i));
                Log.i("MicroMsg.SnsAdStatistic", "exposures item " + paramString + ", snsId=" + r.Jb(paramLong) + ", time=" + i);
              }
              localObject1 = localSnsInfo.getAdXml();
              localTimeLineObject = localSnsInfo.getTimeLine();
              paramSnsObject = null;
              paramString = paramSnsObject;
              if (paramView != null)
              {
                paramString = paramSnsObject;
                if (aj.DKh) {
                  paramString = paramView.eXo();
                }
              }
              paramSnsObject = localSnsInfo.getAdSnsInfo();
              i = 0;
              if (this.source == 0)
              {
                i = paramSnsObject.field_exposureCount + 1;
                paramSnsObject.field_exposureCount = i;
                aj.faR().update(paramSnsObject, new String[0]);
              }
              if (localObject2 != null) {
                break label1374;
              }
              paramSnsObject = "";
              localObject2 = new b();
              ((b)localObject2).Dus = paramInt1;
              ((b)localObject2).DsC = localSnsInfo;
              if (paramView == null) {
                break label1384;
              }
              paramInt1 = paramView.gRE;
              ((b)localObject2).Dut = paramInt1;
              if (!((ADXml)localObject1).isLinkAd()) {
                break label1389;
              }
              paramInt1 = 3;
              paramString = new g(str, paramInt3, paramString, paramInt1, i, localSnsInfo.getAdRecSrc(), h(localSnsInfo), i(localSnsInfo), paramSnsObject, (b)localObject2);
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
            }
            AppMethodBeat.o(95013);
            return;
          }
          label1189:
          this.Dvj.put(paramString, Long.valueOf(Util.currentTicks()));
          this.Dvk.put(paramString, Integer.valueOf(0));
          continue;
          label1224:
          paramSnsObject = new l("timeline");
          continue;
          label1239:
          if ((paramInt2 == 11) && (localSnsInfo.getTimeLine().ContentObj.LoV.size() > 0) && (((cnb)localSnsInfo.getTimeLine().ContentObj.LoV.get(0)).oUv == 6))
          {
            if (this.Dvn.containsKey(Long.valueOf(paramLong))) {}
            for (paramSnsObject = (l)this.Dvn.get(Long.valueOf(paramLong));; paramSnsObject = new l("timeline"))
            {
              paramSnsObject.DvQ = Util.currentTicks();
              paramSnsObject.DvV = true;
              this.Dvn.put(Long.valueOf(paramLong), paramSnsObject);
              break;
            }
            label1374:
            paramSnsObject = ((ADInfo)localObject2).waidPkg;
            continue;
            label1384:
            paramInt1 = 0;
            continue;
            label1389:
            if (localSnsInfo.isTurnCardAd()) {
              paramInt1 = 6;
            } else if ((localSnsInfo.isCardAd()) || (localSnsInfo.isFullCardAd()))
            {
              if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj.LoU == 15) && (localTimeLineObject.sightFolded != 1)) {
                paramInt1 = 5;
              } else {
                paramInt1 = 4;
              }
            }
            else if (localSnsInfo.isFinderTopicCardAd()) {
              paramInt1 = 9;
            } else if ((paramInt2 == 9) || (paramInt2 == 19)) {
              paramInt1 = 2;
            } else {
              paramInt1 = 1;
            }
          }
        }
      }
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(202049);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        Log.d("MicroMsg.SnsAdStatistic", "the key or listener is null");
        AppMethodBeat.o(202049);
        return;
      }
      this.Dvp.put(paramString, paramd);
      AppMethodBeat.o(202049);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SnsAdStatistic", "addAdRemovedListener exp= " + paramString.toString());
      AppMethodBeat.o(202049);
    }
  }
  
  public final void an(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95005);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94992);
        if (k.this.IP(paramLong1))
        {
          k localk = k.this;
          long l = this.DvC;
          if (!localk.Dvm.contains(Long.valueOf(l))) {
            localk.Dvm.add(Long.valueOf(l));
          }
        }
        AppMethodBeat.o(94992);
      }
    });
    AppMethodBeat.o(95005);
  }
  
  public final void ao(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(202047);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202041);
        l locall = (l)k.this.Dvn.get(Long.valueOf(paramLong1));
        if (locall != null) {
          locall.DvZ = this.DvE;
        }
        AppMethodBeat.o(202041);
      }
    });
    AppMethodBeat.o(202047);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95002);
    l locall;
    if (paramBoolean2) {
      if (this.Dvo.containsKey(Long.valueOf(paramLong)))
      {
        locall = (l)this.Dvo.get(Long.valueOf(paramLong));
        Log.d("MicroMsg.SnsAdStatistic", "snsId=" + r.Jb(paramLong) + ", duration=" + paramInt);
        if (paramInt > 0) {
          locall.setDuration(paramInt);
        }
        if (!paramBoolean1) {
          break label198;
        }
      }
    }
    label198:
    for (paramInt = 1;; paramInt = 0)
    {
      locall.DvO = paramInt;
      if (!paramBoolean2) {
        break label203;
      }
      this.Dvo.put(Long.valueOf(paramLong), locall);
      AppMethodBeat.o(95002);
      return;
      locall = new l("timeline");
      break;
      if (this.Dvn.containsKey(Long.valueOf(paramLong)))
      {
        locall = (l)this.Dvn.get(Long.valueOf(paramLong));
        break;
      }
      locall = new l("timeline");
      break;
    }
    label203:
    this.Dvn.put(Long.valueOf(paramLong), locall);
    AppMethodBeat.o(95002);
  }
  
  public final void c(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(95007);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94993);
        if (k.this.IP(paramLong1))
        {
          k localk = k.this;
          long l1 = paramLong1;
          long l2 = paramBoolean;
          boolean bool = this.Dvz;
          l locall;
          if (bool) {
            if (localk.Dvo.containsKey(Long.valueOf(l1))) {
              locall = (l)localk.Dvo.get(Long.valueOf(l1));
            }
          }
          for (;;)
          {
            if (locall.DvW.Dxc == 0L) {
              locall.DvW.Dxc = l2;
            }
            if (!bool) {
              break;
            }
            localk.Dvo.put(Long.valueOf(l1), locall);
            AppMethodBeat.o(94993);
            return;
            locall = new l("timeline");
            continue;
            if (localk.Dvn.containsKey(Long.valueOf(l1))) {
              locall = (l)localk.Dvn.get(Long.valueOf(l1));
            } else {
              locall = new l("timeline");
            }
          }
          localk.Dvn.put(Long.valueOf(l1), locall);
        }
        AppMethodBeat.o(94993);
      }
    });
    AppMethodBeat.o(95007);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(95016);
    Log.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
    Object localObject1 = new HashSet(this.Dvq.keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.Dvq.get(localObject2);
      a(((a)localObject2).position, ((a)localObject2).ecF, ((a)localObject2).DuE, ((a)localObject2).jkT);
    }
    localObject1 = new HashMap(this.Dvr);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94994);
        Iterator localIterator = this.DvD.keySet().iterator();
        AdSnsInfo localAdSnsInfo;
        SnsInfo localSnsInfo;
        int j;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localAdSnsInfo = aj.faR().Zp(y.aQI(str));
          if (localAdSnsInfo != null)
          {
            localSnsInfo = localAdSnsInfo.convertToSnsInfo();
            localAdSnsInfo.setExposures();
            j = 0;
            i = (int)(System.currentTimeMillis() / 1000L);
            if (!this.DvD.containsKey(str)) {
              break label233;
            }
            i = ((Integer)this.DvD.get(str)).intValue();
            j = 1;
          }
        }
        label233:
        for (;;)
        {
          if (localAdSnsInfo.field_exposureTime <= 0)
          {
            localAdSnsInfo.field_exposureTime = i;
            Log.i("MicroMsg.SnsAdStatistic", "update Ad ExposureTime, snsId=" + r.Jb(localAdSnsInfo.field_snsId) + ", exposuretime=" + i + "， sys.currentTimeMis=" + System.currentTimeMillis() + ", type=" + j);
          }
          if (localSnsInfo != null) {
            localSnsInfo.setExposures();
          }
          aj.faO().b(localSnsInfo.field_snsId, localSnsInfo);
          aj.faR().b(localAdSnsInfo.field_snsId, localAdSnsInfo);
          break;
          AppMethodBeat.o(94994);
          return;
        }
      }
    });
    this.Dvq.clear();
    this.Dvr.clear();
    AppMethodBeat.o(95016);
  }
  
  public final void d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95004);
    l locall;
    if (paramBoolean2) {
      if (this.Dvo.containsKey(Long.valueOf(paramLong)))
      {
        locall = (l)this.Dvo.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label162;
        }
      }
    }
    label162:
    for (locall.DvW.Dxa = 2;; locall.DvW.Dxa = 1)
    {
      locall.DvW.Dxb = 1;
      if (!paramBoolean2) {
        break label174;
      }
      this.Dvo.put(Long.valueOf(paramLong), locall);
      AppMethodBeat.o(95004);
      return;
      locall = new l("timeline");
      break;
      if (this.Dvn.containsKey(Long.valueOf(paramLong)))
      {
        locall = (l)this.Dvn.get(Long.valueOf(paramLong));
        break;
      }
      locall = new l("timeline");
      break;
    }
    label174:
    this.Dvn.put(Long.valueOf(paramLong), locall);
    AppMethodBeat.o(95004);
  }
  
  public final void e(final long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95000);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94991);
        k.this.b(paramLong, this.moi, this.DvB, this.Dvz);
        AppMethodBeat.o(94991);
      }
    });
    AppMethodBeat.o(95000);
  }
  
  public final void eXq()
  {
    AppMethodBeat.i(258593);
    uM(false);
    AppMethodBeat.o(258593);
  }
  
  public final void f(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202042);
    b(paramLong, paramInt, paramBoolean, false);
    AppMethodBeat.o(202042);
  }
  
  public final long fr(String paramString, int paramInt)
  {
    AppMethodBeat.i(94997);
    c localc = (c)this.Dvl.get(paramString);
    if (localc != null) {}
    for (long l = localc.DuL;; l = 0L)
    {
      Log.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(94997);
      return l;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(95009);
    Iterator localIterator = this.Dvq.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.Dvq.get(localObject2);
      Log.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).DvK += Util.ticksToNow(((a)localObject1).DvH);
      ((a)localObject1).DvH = 0L;
      localObject2 = (l)this.Dvn.get(Long.valueOf(((a)localObject1).DuE));
      if (localObject2 != null) {
        ((l)localObject2).jkY = Util.currentTicks();
      }
      localObject1 = (l)this.Dvo.get(Long.valueOf(((a)localObject1).DuE));
      if (localObject1 != null) {
        ((l)localObject1).jkY = Util.currentTicks();
      }
    }
    localIterator = this.Dvl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (aj.DKh))
      {
        ((c)localObject1).uL(false);
        if ((!Util.isNullOrNil(((c)localObject1).dJX)) && (this.Dvq.get(((c)localObject1).dJX) != null))
        {
          localObject2 = (a)this.Dvq.get(((c)localObject1).dJX);
          long l;
          if (((a)localObject2).DvJ > 0L)
          {
            l = Util.ticksToNow(((a)localObject2).DvJ);
            ((a)localObject2).DvL += l;
            ((a)localObject2).DvJ = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).DvL + ", id=" + ((c)localObject1).dJX);
          }
          if (((a)localObject2).DvN > 0L)
          {
            l = Util.ticksToNow(((a)localObject2).DvN);
            ((a)localObject2).DvM += l;
            ((a)localObject2).DvN = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).DvM + ", id=" + ((c)localObject1).dJX);
          }
        }
      }
    }
    AppMethodBeat.o(95009);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(94998);
    long l = Util.currentTicks();
    Iterator localIterator = this.Dvq.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.Dvq.get(localObject2);
      Log.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).DvH = l;
      localObject2 = (l)this.Dvn.get(Long.valueOf(((a)localObject1).DuE));
      if (localObject2 != null) {
        ((l)localObject2).onResume();
      }
      localObject1 = (l)this.Dvo.get(Long.valueOf(((a)localObject1).DuE));
      if (localObject1 != null) {
        ((l)localObject1).onResume();
      }
    }
    localIterator = this.Dvl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (aj.DKh))
      {
        ((c)localObject1).uL(false);
        if ((!Util.isNullOrNil(((c)localObject1).dJX)) && (this.Dvq.get(((c)localObject1).dJX) != null))
        {
          localObject2 = (a)this.Dvq.get(((c)localObject1).dJX);
          if (((c)localObject1).eXp())
          {
            ((a)localObject2).DvJ = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + ((c)localObject1).dJX);
          }
          else if (((c)localObject1).Dvf)
          {
            ((a)localObject2).DvN = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + ((c)localObject1).dJX);
          }
        }
      }
    }
    AppMethodBeat.o(94998);
  }
  
  public final void uM(boolean paramBoolean)
  {
    AppMethodBeat.i(95015);
    Log.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.Dvl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localc != null) && (aj.DKh))
      {
        localc.uL(paramBoolean);
        if ((!Util.isNullOrNil(localc.dJX)) && (this.Dvq.get(localc.dJX) != null))
        {
          a locala = (a)this.Dvq.get(localc.dJX);
          boolean bool = localc.eXp();
          if ((bool) && (locala.DvJ == 0L))
          {
            locala.DvJ = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + localc.dJX);
          }
          long l;
          for (;;)
          {
            bool = localc.Dvf;
            if ((!bool) || (locala.DvN != 0L)) {
              break label326;
            }
            locala.DvN = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + localc.dJX);
            break;
            if ((!bool) && (locala.DvJ > 0L))
            {
              l = Util.ticksToNow(locala.DvJ);
              locala.DvL += l;
              locala.DvJ = 0L;
              Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + locala.DvL);
            }
          }
          label326:
          if ((!bool) && (locala.DvN > 0L))
          {
            l = Util.ticksToNow(locala.DvN);
            locala.DvM += l;
            locala.DvN = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + locala.DvM);
          }
        }
      }
    }
    AppMethodBeat.o(95015);
  }
  
  static final class a
  {
    public long DuE;
    public long DvF;
    public long DvG;
    public long DvH;
    public String DvI;
    public long DvJ;
    public long DvK;
    public long DvL;
    public long DvM;
    public long DvN;
    public String ecF;
    public int jkT;
    public int position;
    public int qcr;
    
    public a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3, int paramInt3)
    {
      this.DvF = paramLong1;
      this.DvG = paramLong2;
      this.DvH = paramLong1;
      this.ecF = paramString1;
      this.position = paramInt1;
      this.DvI = paramString2;
      this.DuE = paramLong3;
      this.qcr = paramInt2;
      this.jkT = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.k
 * JD-Core Version:    0.7.0.1
 */