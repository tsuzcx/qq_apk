package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class aq
{
  private static final int DMp;
  
  static
  {
    AppMethodBeat.i(95919);
    DMp = com.tencent.mm.n.h.aqJ().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(95919);
  }
  
  public static boolean fbv()
  {
    AppMethodBeat.i(95917);
    com.tencent.mm.kernel.g.aAi();
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ohh, Integer.valueOf(0))).intValue();
    Log.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(DMp) });
    if (i < DMp)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohh, Integer.valueOf(i + 1));
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(95917);
      return bool;
    }
  }
  
  public static void g(ArrayList<String> paramArrayList, String paramString)
  {
    AppMethodBeat.i(95916);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(95916);
      return;
    }
    paramArrayList = new ArrayList(paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      int i = Util.getInt((String)paramArrayList.next(), 0);
      if (i != 0)
      {
        Object localObject = aj.faO().Zr(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
          if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.LoU == 26))
          {
            localTimeLineObject.ContentObj.LoX = paramString;
            aj.faO().d(i, (SnsInfo)localObject);
            localObject = new sn();
            ((sn)localObject).dZd.dZe = i;
            EventCenter.instance.publish((IEvent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(95916);
  }
  
  public static boolean gQ(Context paramContext)
  {
    bool1 = true;
    AppMethodBeat.i(95918);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
      if (paramContext == null) {
        break label87;
      }
      paramContext = paramContext.signatures[0].toByteArray();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramContext);
      boolean bool2 = Util.isEqual(com.tencent.e.f.e.bytesToHexString(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
      if (!bool2) {
        break label87;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
      }
    }
    AppMethodBeat.o(95918);
    return bool1;
  }
  
  public static final class a
    implements com.tencent.mm.ak.i, com.tencent.mm.plugin.sns.b.i
  {
    public static int DMq = -1;
    public Map<String, Integer> DMA;
    private ax DMB;
    private Map<String, Long> DMr;
    private Map<String, Integer> DMs;
    private Map<String, Long> DMt;
    private Map<String, Integer> DMu;
    private int DMv;
    public long DMw;
    public long DMx;
    private LinkedList<String> DMy;
    public Map<String, ArrayList<com.tencent.mm.plugin.sns.j.b>> DMz;
    private Map<i.a, String> iMA;
    
    public a()
    {
      AppMethodBeat.i(95895);
      this.DMr = new HashMap();
      this.DMs = new HashMap();
      this.DMt = new HashMap();
      this.DMu = new HashMap();
      this.DMv = 0;
      this.DMw = 0L;
      this.DMx = 0L;
      this.iMA = new HashMap();
      this.DMy = new LinkedList();
      this.DMz = new HashMap();
      this.DMA = new HashMap();
      this.DMB = new ax();
      AppMethodBeat.o(95895);
    }
    
    public static dzo a(SnsInfo paramSnsInfo, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(95909);
      paramSnsInfo = b(paramSnsInfo, paramInt1, paramString, null, 0, paramInt2, "");
      AppMethodBeat.o(95909);
      return paramSnsInfo;
    }
    
    public static dzo a(SnsInfo paramSnsInfo, int paramInt1, String paramString1, dzo paramdzo, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95910);
      paramSnsInfo = b(paramSnsInfo, paramInt1, paramString1, paramdzo, paramInt2, paramInt3, paramString2);
      AppMethodBeat.o(95910);
      return paramSnsInfo;
    }
    
    public static dzo a(SnsInfo paramSnsInfo, int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(95912);
      dzi localdzi = new dzi();
      localdzi.iAc = paramString1;
      localdzi.CreateTime = ((int)(Util.nowMilliSecond() / 1000L));
      localdzi.MYQ = com.tencent.mm.model.z.aUa();
      localdzi.MKC = com.tencent.mm.model.z.aTY();
      localdzi.xub = paramInt2;
      localdzi.MYR = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramSnsInfo.getUserName());
      localdzi.LsY = paramSnsInfo.getUserName();
      localdzi.oUv = paramInt1;
      dzj localdzj;
      String str;
      if (paramSnsInfo.isSourceExist(32))
      {
        localdzi.MYU = 0L;
        paramString1 = new dzi();
        paramString1.MKC = paramString2;
        if (!Util.isNullOrNil(paramString1.MKC)) {
          paramString1.MYQ = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1.MKC);
        }
        localdzj = new dzj();
        localdzj.Id = paramSnsInfo.field_snsId;
        localdzj.MZb = localdzi;
        localdzj.MZc = paramString1;
        str = "";
        if (paramSnsInfo.isAd())
        {
          paramString1 = paramSnsInfo.getAdInfo();
          if (paramString1 != null) {
            break label380;
          }
          paramString2 = "";
          label206:
          if (paramString1 != null) {
            break label388;
          }
          paramString1 = "";
          label213:
          if (localdzi.oUv != 7) {
            break label396;
          }
          ((d)com.tencent.mm.kernel.g.af(d.class)).a(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
          str = paramString1;
        }
        label271:
        paramString2 = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
        paramString1 = paramString2;
        if (paramSnsInfo.isSourceExist(32)) {
          paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
        }
        if (!aj.faN().a(paramString1, localdzj, str)) {
          break label490;
        }
        if (!ag.aPg(paramString1)) {
          break label460;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new k(localdzj, paramString1, str, 0), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(95912);
        return null;
        localdzi.MYS = 0;
        break;
        label380:
        paramString2 = paramString1.viewId;
        break label206;
        label388:
        paramString1 = paramString1.uxInfo;
        break label213;
        label396:
        str = paramString1;
        if (localdzi.oUv != 8) {
          break label271;
        }
        ((d)com.tencent.mm.kernel.g.af(d.class)).a(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
        str = paramString1;
        break label271;
        label460:
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new p(localdzj, paramString1, paramInt2), 0);
        continue;
        label490:
        Log.e("MicroMsg.SnsService", "can not add Comment");
      }
    }
    
    public static void a(String paramString1, int paramInt1, String paramString2, SnsInfo paramSnsInfo, int paramInt2)
    {
      AppMethodBeat.i(95913);
      if ((paramInt1 != 3) && (paramInt1 != 5))
      {
        AppMethodBeat.o(95913);
        return;
      }
      dzi localdzi = new dzi();
      localdzi.iAc = paramString2;
      localdzi.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
      localdzi.MYQ = com.tencent.mm.model.z.aUa();
      localdzi.MKC = com.tencent.mm.model.z.aTY();
      localdzi.xub = paramInt2;
      localdzi.MYR = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1);
      localdzi.LsY = paramString1;
      localdzi.oUv = paramInt1;
      paramString2 = new dzj();
      paramString2.Id = paramSnsInfo.field_snsId;
      paramString2.MZb = localdzi;
      paramString2.MZc = new dzi();
      String str = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
      long l = paramSnsInfo.field_snsId;
      try
      {
        Log.v("MicroMsg.SnsService", "comment stg inserted");
        paramSnsInfo = new com.tencent.mm.plugin.sns.storage.h();
        paramSnsInfo.field_talker = paramString1;
        paramSnsInfo.field_snsID = l;
        paramSnsInfo.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
        paramSnsInfo.field_curActionBuf = localdzi.toByteArray();
        paramSnsInfo.field_type = paramInt1;
        paramSnsInfo.field_isSend = true;
        paramSnsInfo.field_isRead = 1;
        aj.faT().insert(paramSnsInfo);
        aj.faN().a(str, paramString2);
        AppMethodBeat.o(95913);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SnsService", paramString1, "", new Object[0]);
        }
      }
    }
    
    public static void aPo(String paramString)
    {
      AppMethodBeat.i(95908);
      Object localObject = aj.faN();
      if (Util.isNullOrNil(((ag)localObject).gna)) {
        ((ag)localObject).gna = com.tencent.mm.model.z.aTY();
      }
      localObject = ((ag)localObject).gna;
      SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.storage.f.aQl(paramString);
      for (;;)
      {
        try
        {
          SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
          Iterator localIterator = localSnsObject.LikeUserList.iterator();
          if (localIterator.hasNext())
          {
            dzo localdzo = (dzo)localIterator.next();
            if (!localdzo.Username.equals(localObject)) {
              continue;
            }
            localSnsObject.LikeUserList.remove(localdzo);
            localSnsObject.LikeCount -= 1;
            localSnsInfo.field_attrBuf = localSnsObject.toByteArray();
            if (!localSnsInfo.isAd()) {
              continue;
            }
            aj.faR().replace(localSnsInfo.getAdSnsInfo());
          }
        }
        catch (Exception localException)
        {
          continue;
          String str = localException.viewId;
          continue;
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new s(y.aOa(paramString), 5), 0);
          AppMethodBeat.o(95908);
        }
        if (!aj.faN().Jt(y.aOa(paramString))) {
          continue;
        }
        if (!localSnsInfo.isAd()) {
          continue;
        }
        localObject = localSnsInfo.getAdInfo();
        if (localObject != null) {
          continue;
        }
        localObject = "";
        ((d)com.tencent.mm.kernel.g.af(d.class)).a(11855, localSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localSnsInfo.getAdRecSrc()) });
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new s(y.aOa(paramString), 7), 0);
        AppMethodBeat.o(95908);
        return;
        aj.faO().S(localSnsInfo);
      }
    }
    
    private static dzo b(SnsInfo paramSnsInfo, int paramInt1, String paramString1, dzo paramdzo, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95911);
      dzi localdzi = new dzi();
      localdzi.iAc = paramString1;
      localdzi.CreateTime = ((int)(Util.nowMilliSecond() / 1000L));
      localdzi.MYQ = com.tencent.mm.model.z.aUa();
      localdzi.MKC = com.tencent.mm.model.z.aTY();
      localdzi.xub = 0;
      localdzi.MYR = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramSnsInfo.getUserName());
      localdzi.LsY = paramSnsInfo.getUserName();
      localdzi.oUv = paramInt1;
      localdzi.MYX = paramInt2;
      long l;
      label189:
      dzj localdzj;
      int i;
      if (paramSnsInfo.isSourceExist(32)) {
        if (paramdzo == null)
        {
          l = 0L;
          localdzi.MYU = l;
          if (!Util.isNullOrNil(paramString2))
          {
            paramString1 = new dzu();
            paramString1.Md5 = paramString2;
            localdzi.MYY = new LinkedList();
            localdzi.MYY.add(paramString1);
            localdzi.MYZ = 1;
          }
          paramString2 = new dzi();
          if (paramdzo != null) {
            break label684;
          }
          paramString1 = "";
          paramString2.MKC = paramString1;
          if (!Util.isNullOrNil(paramString2.MKC)) {
            paramString2.MYQ = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString2.MKC);
          }
          localdzj = new dzj();
          localdzj.Id = paramSnsInfo.field_snsId;
          localdzj.MZb = localdzi;
          localdzj.MZc = paramString2;
          paramString1 = "";
          i = 0;
          if (paramSnsInfo.isAd())
          {
            Log.i("MicroMsg.SnsService", "sendComment, sourceScene=" + paramInt3 + ", type=" + paramInt1 + ", flag=" + paramInt2);
            if (paramInt3 != 2) {
              break label692;
            }
            paramString1 = paramSnsInfo.getAtAdInfo();
            paramInt1 = 1;
            label332:
            if (paramString1 != null) {
              break label702;
            }
            paramdzo = "";
            label339:
            if (paramString1 != null) {
              break label710;
            }
            paramString1 = "";
            label346:
            if (localdzi.oUv != 7) {
              break label718;
            }
            ((d)com.tencent.mm.kernel.g.af(d.class)).a(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(1), paramdzo, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
            label401:
            paramdzo = paramSnsInfo.getAdSnsInfo();
            if (paramdzo == null) {
              break label1089;
            }
            if (paramdzo.field_firstControlTime == 0)
            {
              paramdzo.field_firstControlTime = localdzi.CreateTime;
              aj.faR().b(paramdzo.field_snsId, paramdzo);
            }
            paramdzo = paramdzo.getRemindInfoGroup();
            if (paramInt3 != 2) {
              break label827;
            }
            if (paramdzo == null) {
              break label802;
            }
            localdzj.MZb.KHJ = paramdzo.KGE;
            if (paramdzo.KGE == null) {
              break label776;
            }
            Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdzo.KGE.MQh), Integer.valueOf(paramdzo.KGE.MQc) });
            if ((paramdzo.KGE.MQh != 0L) || (paramdzo.KGE.MQc != 0)) {
              break label1089;
            }
            com.tencent.mm.plugin.report.service.h.CyF.dN(955, 9);
            i = paramInt1;
          }
          label547:
          paramString2 = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
          paramdzo = paramString2;
          if (paramSnsInfo.isSourceExist(32)) {
            paramdzo = "_AD_TAG_".concat(String.valueOf(paramString2));
          }
          if (!aj.faN().a(paramdzo, localdzj)) {
            break label1125;
          }
          if (!ag.aPg(paramdzo)) {
            break label1095;
          }
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new k(localdzj, paramdzo, paramString1, i), 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(95911);
        return null;
        l = paramdzo.MYV;
        break;
        if (paramdzo == null) {}
        for (i = 0;; i = paramdzo.MYT)
        {
          localdzi.MYS = i;
          break;
        }
        label684:
        paramString1 = paramdzo.Username;
        break label189;
        label692:
        paramString1 = paramSnsInfo.getAdInfo();
        paramInt1 = 0;
        break label332;
        label702:
        paramdzo = paramString1.viewId;
        break label339;
        label710:
        paramString1 = paramString1.uxInfo;
        break label346;
        label718:
        if (localdzi.oUv != 8) {
          break label401;
        }
        ((d)com.tencent.mm.kernel.g.af(d.class)).a(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(2), paramdzo, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
        break label401;
        label776:
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 7);
        Log.i("MicroMsg.SnsService", "remindInfo is null!");
        i = paramInt1;
        break label547;
        label802:
        Log.i("MicroMsg.SnsService", "remindInfo group is null!");
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 5);
        i = paramInt1;
        break label547;
        label827:
        if (com.tencent.mm.plugin.sns.ui.widget.e.iY(paramInt2, 8))
        {
          Log.i("MicroMsg.SnsService", "sendAtFriend");
          if (paramdzo != null)
          {
            if (paramdzo.KGD != null)
            {
              localdzj.MZb.KHJ = paramdzo.KGD;
              Log.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdzo.KGD.MQh), Integer.valueOf(paramdzo.KGD.MQc) });
              if ((paramdzo.KGD.MQh != 0L) || (paramdzo.KGD.MQc != 0)) {
                break label1089;
              }
              com.tencent.mm.plugin.report.service.h.CyF.dN(955, 8);
              i = paramInt1;
              break label547;
            }
            if (paramdzo.KGE != null)
            {
              localdzj.MZb.KHJ = paramdzo.KGE;
              Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdzo.KGE.MQh), Integer.valueOf(paramdzo.KGE.MQc) });
              if ((paramdzo.KGE.MQh != 0L) || (paramdzo.KGE.MQc != 0)) {
                break label1089;
              }
              com.tencent.mm.plugin.report.service.h.CyF.dN(955, 8);
              i = paramInt1;
              break label547;
            }
            com.tencent.mm.plugin.report.service.h.CyF.dN(955, 6);
            Log.i("MicroMsg.SnsService", "remindInfo is null!");
            i = paramInt1;
            break label547;
          }
          Log.i("MicroMsg.SnsService", "remindInfo group is null!");
          com.tencent.mm.plugin.report.service.h.CyF.dN(955, 5);
        }
        label1089:
        i = paramInt1;
        break label547;
        label1095:
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new p(localdzj, paramdzo, paramInt3), 0);
        continue;
        label1125:
        Log.e("MicroMsg.SnsService", "can not add Comment");
      }
    }
    
    public static int fbx()
    {
      AppMethodBeat.i(95906);
      if (DMq != -1)
      {
        i = DMq;
        AppMethodBeat.o(95906);
        return i;
      }
      DMq = r.eZu();
      Log.i("MicroMsg.SnsService", "getTimelineControlFlag %d", new Object[] { Integer.valueOf(DMq) });
      int i = DMq;
      AppMethodBeat.o(95906);
      return i;
    }
    
    public final void Jv(long paramLong)
    {
      AppMethodBeat.i(179094);
      Log.d("MicroMsg.SnsService", "setTimeFirstId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong == 0L)
      {
        AppMethodBeat.o(179094);
        return;
      }
      this.DMx = paramLong;
      AppMethodBeat.o(179094);
    }
    
    public final void W(long paramLong, int paramInt)
    {
      AppMethodBeat.i(95905);
      Log.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramInt > 0)
      {
        this.DMv = paramInt;
        r.Ym(paramInt);
      }
      if (paramLong == 0L)
      {
        AppMethodBeat.o(95905);
        return;
      }
      this.DMw = paramLong;
      AppMethodBeat.o(95905);
    }
    
    public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
    {
      AppMethodBeat.i(95902);
      Log.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (paramInt1 == 2)
      {
        if (!ab.aPd(paramString))
        {
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == ax.DOd)
        {
          this.DMB.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == ax.DOe)
        {
          ax.b(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == ax.DOf)
        {
          ax.f(paramString, paramBoolean, paramInt3);
          AppMethodBeat.o(95902);
        }
      }
      else if (paramInt1 == 1)
      {
        if (!z.aPa("@__weixintimtline"))
        {
          AppMethodBeat.o(95902);
          return;
        }
        aj.faZ().DNF = paramInt2;
        if (paramInt2 == ax.DOd)
        {
          this.DMB.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == ax.DOe)
        {
          aj.faZ().DNI = true;
          ax.b(paramString, paramBoolean, paramInt3, this.DMx, paramInt1);
        }
      }
      AppMethodBeat.o(95902);
    }
    
    public final void a(int paramInt, String paramString, i.a arg3)
    {
      AppMethodBeat.i(95898);
      Log.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
      aj.faN().gna = com.tencent.mm.model.z.aTY();
      aj.faN().fan();
      aj.faK().eZn();
      if (this.iMA.isEmpty())
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(211, this);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(212, this);
      }
      if (!this.iMA.containsKey(???))
      {
        if (paramInt == 1) {
          this.iMA.put(???, "@__weixintimtline");
        }
      }
      else {
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(95898);
        return;
        if ((paramInt == 2) || (paramInt == 3) || (paramInt == 10))
        {
          this.iMA.put(???, paramString);
          break;
        }
        if (paramInt == 4)
        {
          this.iMA.put(???, "@__classify_timeline");
          break;
        }
        if (paramInt == 5)
        {
          this.iMA.put(???, "");
          break;
        }
        this.iMA.put(???, "");
        break;
        synchronized (this.DMr)
        {
          this.DMr.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.DMs)
        {
          if (!this.DMs.containsKey(paramString)) {
            this.DMs.put(paramString, Integer.valueOf(fbw()));
          }
          ab.aPe(paramString);
          this.DMy.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        synchronized (this.DMt)
        {
          this.DMt.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.DMu)
        {
          if (!this.DMu.containsKey(paramString)) {
            this.DMu.put(paramString, Integer.valueOf(fbw()));
          }
          ab.aPe(paramString);
          this.DMy.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        this.DMw = 0L;
        this.DMv = fbw();
        z.aPb("@__weixintimtline");
      }
    }
    
    public final void a(final int paramInt1, final String paramString, final boolean paramBoolean, final int paramInt2)
    {
      AppMethodBeat.i(95901);
      if (ac.jOi)
      {
        AppMethodBeat.o(95901);
        return;
      }
      Log.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
      wg localwg = new wg();
      localwg.ecq.state = 1;
      EventCenter.instance.publish(localwg);
      if (paramInt1 == 2)
      {
        aj.eJP().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(202777);
            if (!ab.aPd(paramString))
            {
              AppMethodBeat.o(202777);
              return;
            }
            com.tencent.mm.kernel.g.aAi();
            t localt = com.tencent.mm.kernel.g.aAg().hqi;
            String str = paramString;
            boolean bool = paramBoolean;
            int j = paramInt2;
            int k = ax.DOc;
            if (paramBoolean) {}
            for (int i = 4;; i = 8)
            {
              localt.a(new ab(str, 0L, bool, j, k, 0, i, paramInt1), 0);
              AppMethodBeat.o(202777);
              return;
            }
          }
        });
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 == 1)
      {
        if (!z.aPa("@__weixintimtline"))
        {
          AppMethodBeat.o(95901);
          return;
        }
        aj.faZ().DNF = ax.DOf;
        aj.faZ().DNM = aj.faO().h(0L, 1, true);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(68377, "");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new z(0L, 0L, 0), 0);
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!o.aPa("@__classify_timeline"))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new o(""), 0);
          AppMethodBeat.o(95901);
          return;
        }
        if (paramInt1 == 10) {
          aj.eJP().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202778);
              if (!ab.aPd(paramString))
              {
                AppMethodBeat.o(202778);
                return;
              }
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a(new ab(paramString, 0L, paramBoolean, paramInt2, ax.DOc, 1, 64, paramInt1), 0);
              AppMethodBeat.o(202778);
            }
          });
        }
      }
      AppMethodBeat.o(95901);
    }
    
    public final boolean a(i.a parama, int paramInt)
    {
      AppMethodBeat.i(95899);
      Log.d("MicroMsg.SnsService", "closeServer");
      this.iMA.remove(parama);
      if (((paramInt == 2) || (paramInt == 10)) && (this.DMy.size() > 0)) {
        this.DMy.removeLast();
      }
      if (this.iMA.isEmpty())
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(211, this);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(212, this);
        ar.release();
        SnsInfo.release();
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95894);
            aq.a.a(aq.a.this);
            AppMethodBeat.o(95894);
          }
        }, 5000L);
        an.fbo();
        Log.i("MicroMsg.SnsService", "close finish");
      }
      AppMethodBeat.o(95899);
      return true;
    }
    
    public final void aNX(String paramString)
    {
      AppMethodBeat.i(95914);
      String str1 = aj.getAccSnsPath();
      String str2 = paramString + "bg_";
      String str3 = paramString + "tbg_";
      if (com.tencent.mm.vfs.s.YS(str2))
      {
        com.tencent.mm.vfs.s.deleteFile(ar.ki(str1, paramString) + str3);
        com.tencent.mm.vfs.s.bo(ar.ki(str1, paramString), str2, str3);
      }
      AppMethodBeat.o(95914);
    }
    
    public final int aPn(String paramString)
    {
      AppMethodBeat.i(95903);
      synchronized (this.DMs)
      {
        if (this.DMs.containsKey(paramString))
        {
          i = ((Integer)this.DMs.get(paramString)).intValue();
          if (i > 0) {}
          for (;;)
          {
            AppMethodBeat.o(95903);
            return i;
            i = r.eZv();
          }
        }
        int i = r.eZv();
        AppMethodBeat.o(95903);
        return i;
      }
    }
    
    public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95900);
      if (ac.jOi)
      {
        AppMethodBeat.o(95900);
        return;
      }
      synchronized (this.DMr)
      {
        Log.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.DMw), this.DMr });
        if (paramInt1 != 2) {
          break label244;
        }
        if (!ab.aPd(paramString))
        {
          AppMethodBeat.o(95900);
          return;
        }
      }
      long l = 0L;
      synchronized (this.DMr)
      {
        if (this.DMr.containsKey(paramString)) {
          l = ((Long)this.DMr.get(paramString)).longValue();
        }
        if (l == 0L)
        {
          ab.aPe(paramString);
          AppMethodBeat.o(95900);
          return;
        }
      }
      com.tencent.mm.kernel.g.aAi();
      ??? = com.tencent.mm.kernel.g.aAg().hqi;
      int j = ax.DOc;
      if (paramBoolean) {}
      for (int i = 4;; i = 8)
      {
        ((t)???).a(new ab(paramString, l, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
        AppMethodBeat.o(95900);
        return;
      }
      label244:
      if (paramInt1 == 1)
      {
        if (!z.aPa("@__weixintimtline"))
        {
          AppMethodBeat.o(95900);
          return;
        }
        if (this.DMw == 0L)
        {
          z.aPb("@__weixintimtline");
          AppMethodBeat.o(95900);
          return;
        }
        aj.faZ().DNF = ax.DOf;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new z(this.DMw, 0L, 0), 0);
        AppMethodBeat.o(95900);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!o.aPa("@__classify_timeline"))
          {
            AppMethodBeat.o(95900);
            return;
          }
          if (this.DMw == 0L)
          {
            o.aPb("@__classify_timeline");
            AppMethodBeat.o(95900);
            return;
          }
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new o(""), 0);
          AppMethodBeat.o(95900);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!ab.aPd(paramString))
          {
            AppMethodBeat.o(95900);
            return;
          }
          l = 0L;
          synchronized (this.DMt)
          {
            if (this.DMt.containsKey(paramString)) {
              l = ((Long)this.DMt.get(paramString)).longValue();
            }
            if (l == 0L)
            {
              ab.aPe(paramString);
              AppMethodBeat.o(95900);
              return;
            }
          }
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new ab(paramString, l, paramBoolean, paramInt2, ax.DOc, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95900);
    }
    
    public final int fbw()
    {
      AppMethodBeat.i(95904);
      if (this.DMv > 0)
      {
        i = this.DMv;
        AppMethodBeat.o(95904);
        return i;
      }
      int i = r.eZv();
      AppMethodBeat.o(95904);
      return i;
    }
    
    public final Intent g(Intent paramIntent, String paramString)
    {
      AppMethodBeat.i(95897);
      paramIntent.putExtra("sns_userName", paramString);
      if ((this.DMy != null) && (this.DMy.contains(paramString)))
      {
        paramIntent.addFlags(536870912);
        paramIntent.addFlags(67108864);
        AppMethodBeat.o(95897);
        return paramIntent;
      }
      AppMethodBeat.o(95897);
      return paramIntent;
    }
    
    public final void l(String paramString, ArrayList<com.tencent.mm.plugin.sns.j.b> paramArrayList)
    {
      AppMethodBeat.i(95896);
      this.DMz.put(paramString, paramArrayList);
      AppMethodBeat.o(95896);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(95907);
      Log.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType());
      if ((paramq != null) && ((paramq instanceof z)) && (((z)paramq).fak())) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.SnsService", "skip by preload unread feeds");
        AppMethodBeat.o(95907);
        return;
      }
      label437:
      label566:
      label974:
      label980:
      if ((paramq.getType() == 212) || (paramq.getType() == 211))
      {
        com.tencent.mm.plugin.sns.b.b localb = (com.tencent.mm.plugin.sns.b.b)paramq;
        paramString = new ArrayList(this.iMA.keySet());
        if (((paramInt1 != 4) || (paramInt2 != 207)) && ((paramInt1 != 4) || (paramInt2 != 203))) {
          if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2005)))
          {
            i = 1;
            if (i != 0) {
              break label437;
            }
            paramString = paramString.iterator();
          }
        }
        label226:
        String str;
        boolean bool;
        while (paramString.hasNext())
        {
          paramq = (i.a)paramString.next();
          if (this.iMA.containsKey(paramq))
          {
            ??? = (String)this.iMA.get(paramq);
            if ((localb.getUserName().equals(???)) && (localb.eYX()))
            {
              ??? = r.Jc(an.DIf);
              str = r.Jc(an.DIg);
              if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
              for (bool = true;; bool = false)
              {
                paramq.a((String)???, str, bool, paramInt2, localb);
                break label226;
                if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2003)))
                {
                  i = 1;
                  break;
                }
                if ((paramInt1 != 0) || (paramInt2 != 0))
                {
                  i = 0;
                  break;
                }
                i = 1;
                break;
              }
            }
          }
        }
        AppMethodBeat.o(95907);
        return;
        switch (paramq.getType())
        {
        default: 
          paramq = paramString.iterator();
        }
        label470:
        while (paramq.hasNext())
        {
          ??? = (i.a)paramq.next();
          if (this.iMA.containsKey(???))
          {
            paramString = (String)this.iMA.get(???);
            if (localb.getUserName().equals(paramString))
            {
              Log.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
              if (localb.eZd() == 0L)
              {
                paramString = "";
                if (!localb.eYW()) {
                  break label980;
                }
                if ((paramInt1 != 4) || ((paramInt2 != 2001) && (paramInt2 != 2004) && (paramInt2 != 2003) && (paramInt2 != 2005) && (paramInt2 != 203))) {
                  break label974;
                }
              }
              for (bool = true;; bool = false)
              {
                for (;;)
                {
                  long l;
                  for (;;)
                  {
                    ((i.a)???).a(paramString, bool, paramInt2, localb);
                    break label470;
                    ??? = (ab)paramq;
                    paramq = ((ab)???).userName;
                    l = ((ab)???).DIg;
                    i = ((ab)???).DIi;
                    if (((ab)???).DJD == 10)
                    {
                      if (i > 0) {}
                      synchronized (this.DMu)
                      {
                        for (;;)
                        {
                          this.DMu.put(paramq, Integer.valueOf(i));
                          if (l == 0L) {
                            break;
                          }
                          synchronized (this.DMt)
                          {
                            this.DMt.put(paramq, Long.valueOf(l));
                          }
                        }
                      }
                    }
                  }
                  if (i > 0) {}
                  synchronized (this.DMs)
                  {
                    for (;;)
                    {
                      this.DMs.put(paramq, Integer.valueOf(i));
                      if (l == 0L) {
                        break;
                      }
                      synchronized (this.DMr)
                      {
                        this.DMr.put(paramq, Long.valueOf(l));
                      }
                    }
                  }
                }
                paramq = (z)paramq;
                if (localb.eYX()) {
                  Jv(paramq.DIf);
                }
                for (;;)
                {
                  i = paramq.DIj;
                  if (DMq != i) {
                    r.Yl(i);
                  }
                  Log.i("MicroMsg.SnsService", "updateTimelineControlFlag %d", new Object[] { Integer.valueOf(i) });
                  DMq = i;
                  break;
                  W(paramq.DIg, paramq.DIi);
                }
                paramString = r.Jc(localb.eZd());
                break label566;
              }
              if (localb.eYX())
              {
                bool = false;
                if (localb.eYY() == ax.DOd)
                {
                  an.DMh = an.DIf;
                  bool = true;
                }
                Log.i("MicroMsg.SnsService", "fetchType:%s, preUpReady:%s, firstPage:%s", new Object[] { Integer.valueOf(localb.eYY()), Boolean.valueOf(this.DMB.DOg), Boolean.valueOf(bool) });
                paramString = r.Jc(an.DIf);
                str = r.Jc(an.DIg);
                if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
                for (bool = true;; bool = false)
                {
                  ((i.a)???).a(paramString, str, bool, paramInt2, localb);
                  break;
                }
              }
              if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
              for (bool = true;; bool = false)
              {
                ((i.a)???).b(paramString, bool, paramInt2, localb);
                break;
              }
            }
          }
        }
      }
      AppMethodBeat.o(95907);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */