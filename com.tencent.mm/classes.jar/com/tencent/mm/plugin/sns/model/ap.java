package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.to;
import com.tencent.mm.f.a.xl;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.j.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ap
{
  private static final int JZr;
  
  static
  {
    AppMethodBeat.i(95919);
    JZr = com.tencent.mm.n.h.axc().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(95919);
  }
  
  public static boolean fPo()
  {
    AppMethodBeat.i(95917);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvx, Integer.valueOf(0))).intValue();
    Log.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(JZr) });
    if (i < JZr)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvx, Integer.valueOf(i + 1));
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(95917);
      return bool;
    }
  }
  
  public static void h(ArrayList<String> paramArrayList, String paramString)
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
        Object localObject = aj.fOI().agI(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
          if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.Sqq == 26))
          {
            localTimeLineObject.ContentObj.Sqt = paramString;
            aj.fOI().d(i, (SnsInfo)localObject);
            localObject = new to();
            ((to)localObject).fSW.fSX = i;
            EventCenter.instance.publish((IEvent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(95916);
  }
  
  public static boolean hS(Context paramContext)
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
      boolean bool2 = Util.isEqual(com.tencent.d.f.e.aC(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
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
    implements com.tencent.mm.an.i, j
  {
    public static int JZs = -1;
    private LinkedList<String> JZA;
    public Map<String, ArrayList<com.tencent.mm.plugin.sns.j.b>> JZB;
    private Map<String, Integer> JZC;
    private aw JZD;
    private Map<String, Long> JZt;
    private Map<String, Integer> JZu;
    private Map<String, Long> JZv;
    private Map<String, Integer> JZw;
    private int JZx;
    public long JZy;
    public long JZz;
    private Map<j.a, String> lCH;
    
    public a()
    {
      AppMethodBeat.i(95895);
      this.JZt = new HashMap();
      this.JZu = new HashMap();
      this.JZv = new HashMap();
      this.JZw = new HashMap();
      this.JZx = 0;
      this.JZy = 0L;
      this.JZz = 0L;
      this.lCH = new HashMap();
      this.JZA = new LinkedList();
      this.JZB = new HashMap();
      this.JZC = new HashMap();
      this.JZD = new aw();
      AppMethodBeat.o(95895);
    }
    
    public static ejo a(SnsInfo paramSnsInfo, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(95909);
      paramSnsInfo = b(paramSnsInfo, paramInt1, paramString, null, 0, paramInt2, "");
      AppMethodBeat.o(95909);
      return paramSnsInfo;
    }
    
    public static ejo a(SnsInfo paramSnsInfo, int paramInt1, String paramString1, ejo paramejo, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95910);
      paramSnsInfo = b(paramSnsInfo, paramInt1, paramString1, paramejo, paramInt2, paramInt3, paramString2);
      AppMethodBeat.o(95910);
      return paramSnsInfo;
    }
    
    public static ejo a(SnsInfo paramSnsInfo, int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(95912);
      eji localeji = new eji();
      localeji.lpy = paramString1;
      localeji.CreateTime = ((int)(Util.nowMilliSecond() / 1000L));
      localeji.Ulk = com.tencent.mm.model.z.bdb();
      localeji.TWw = com.tencent.mm.model.z.bcZ();
      localeji.Cqs = paramInt2;
      localeji.Ull = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramSnsInfo.getUserName());
      localeji.Svt = paramSnsInfo.getUserName();
      localeji.rWu = paramInt1;
      ejj localejj;
      String str;
      if (paramSnsInfo.isSourceExist(32))
      {
        localeji.Ulo = 0L;
        paramString1 = new eji();
        paramString1.TWw = paramString2;
        if (!Util.isNullOrNil(paramString1.TWw)) {
          paramString1.Ulk = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramString1.TWw);
        }
        localejj = new ejj();
        localejj.Id = paramSnsInfo.field_snsId;
        localejj.Ulv = localeji;
        localejj.Ulw = paramString1;
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
          if (localeji.rWu != 7) {
            break label396;
          }
          ((d)com.tencent.mm.kernel.h.ae(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
          str = paramString1;
        }
        label271:
        paramString2 = g.getMessageDigest(Util.currentTicks().getBytes());
        paramString1 = paramString2;
        if (paramSnsInfo.isSourceExist(32)) {
          paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
        }
        if (!aj.fOH().a(paramString1, localejj, str)) {
          break label490;
        }
        if (!ag.bab(paramString1)) {
          break label460;
        }
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new k(localejj, paramString1, str, 0), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(95912);
        return null;
        localeji.Ulm = 0;
        break;
        label380:
        paramString2 = paramString1.viewId;
        break label206;
        label388:
        paramString1 = paramString1.uxInfo;
        break label213;
        label396:
        str = paramString1;
        if (localeji.rWu != 8) {
          break label271;
        }
        ((d)com.tencent.mm.kernel.h.ae(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
        str = paramString1;
        break label271;
        label460:
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new p(localejj, paramString1, paramInt2), 0);
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
      eji localeji = new eji();
      localeji.lpy = paramString2;
      localeji.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
      localeji.Ulk = com.tencent.mm.model.z.bdb();
      localeji.TWw = com.tencent.mm.model.z.bcZ();
      localeji.Cqs = paramInt2;
      localeji.Ull = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramString1);
      localeji.Svt = paramString1;
      localeji.rWu = paramInt1;
      paramString2 = new ejj();
      paramString2.Id = paramSnsInfo.field_snsId;
      paramString2.Ulv = localeji;
      paramString2.Ulw = new eji();
      String str = g.getMessageDigest(Util.currentTicks().getBytes());
      long l = paramSnsInfo.field_snsId;
      try
      {
        Log.v("MicroMsg.SnsService", "comment stg inserted");
        paramSnsInfo = new com.tencent.mm.plugin.sns.storage.h();
        paramSnsInfo.field_talker = paramString1;
        paramSnsInfo.field_snsID = l;
        paramSnsInfo.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
        paramSnsInfo.field_curActionBuf = localeji.toByteArray();
        paramSnsInfo.field_type = paramInt1;
        paramSnsInfo.field_isSend = true;
        paramSnsInfo.field_isRead = 1;
        aj.fON().insert(paramSnsInfo);
        aj.fOH().a(str, paramString2);
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
    
    private static ejo b(SnsInfo paramSnsInfo, int paramInt1, String paramString1, ejo paramejo, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95911);
      eji localeji = new eji();
      localeji.lpy = paramString1;
      localeji.CreateTime = ((int)(Util.nowMilliSecond() / 1000L));
      localeji.Ulk = com.tencent.mm.model.z.bdb();
      localeji.TWw = com.tencent.mm.model.z.bcZ();
      localeji.Cqs = 0;
      localeji.Ull = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramSnsInfo.getUserName());
      localeji.Svt = paramSnsInfo.getUserName();
      localeji.rWu = paramInt1;
      localeji.Ulr = paramInt2;
      long l;
      label189:
      ejj localejj;
      int i;
      if (paramSnsInfo.isSourceExist(32)) {
        if (paramejo == null)
        {
          l = 0L;
          localeji.Ulo = l;
          if (!Util.isNullOrNil(paramString2))
          {
            paramString1 = new eju();
            paramString1.Md5 = paramString2;
            localeji.Uls = new LinkedList();
            localeji.Uls.add(paramString1);
            localeji.Ult = 1;
          }
          paramString2 = new eji();
          if (paramejo != null) {
            break label684;
          }
          paramString1 = "";
          paramString2.TWw = paramString1;
          if (!Util.isNullOrNil(paramString2.TWw)) {
            paramString2.Ulk = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramString2.TWw);
          }
          localejj = new ejj();
          localejj.Id = paramSnsInfo.field_snsId;
          localejj.Ulv = localeji;
          localejj.Ulw = paramString2;
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
            paramejo = "";
            label339:
            if (paramString1 != null) {
              break label710;
            }
            paramString1 = "";
            label346:
            if (localeji.rWu != 7) {
              break label718;
            }
            ((d)com.tencent.mm.kernel.h.ae(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(1), paramejo, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
            label401:
            paramejo = paramSnsInfo.getAdSnsInfo();
            if (paramejo == null) {
              break label1089;
            }
            if (paramejo.field_firstControlTime == 0)
            {
              paramejo.field_firstControlTime = localeji.CreateTime;
              aj.fOL().b(paramejo.field_snsId, paramejo);
            }
            paramejo = paramejo.getRemindInfoGroup();
            if (paramInt3 != 2) {
              break label827;
            }
            if (paramejo == null) {
              break label802;
            }
            localejj.Ulv.RJc = paramejo.RHY;
            if (paramejo.RHY == null) {
              break label776;
            }
            Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramejo.RHY.Ucl), Integer.valueOf(paramejo.RHY.Ucg) });
            if ((paramejo.RHY.Ucl != 0L) || (paramejo.RHY.Ucg != 0)) {
              break label1089;
            }
            com.tencent.mm.plugin.report.service.h.IzE.el(955, 9);
            i = paramInt1;
          }
          label547:
          paramString2 = g.getMessageDigest(Util.currentTicks().getBytes());
          paramejo = paramString2;
          if (paramSnsInfo.isSourceExist(32)) {
            paramejo = "_AD_TAG_".concat(String.valueOf(paramString2));
          }
          if (!aj.fOH().a(paramejo, localejj)) {
            break label1125;
          }
          if (!ag.bab(paramejo)) {
            break label1095;
          }
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new k(localejj, paramejo, paramString1, i), 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(95911);
        return null;
        l = paramejo.Ulp;
        break;
        if (paramejo == null) {}
        for (i = 0;; i = paramejo.Uln)
        {
          localeji.Ulm = i;
          break;
        }
        label684:
        paramString1 = paramejo.Username;
        break label189;
        label692:
        paramString1 = paramSnsInfo.getAdInfo();
        paramInt1 = 0;
        break label332;
        label702:
        paramejo = paramString1.viewId;
        break label339;
        label710:
        paramString1 = paramString1.uxInfo;
        break label346;
        label718:
        if (localeji.rWu != 8) {
          break label401;
        }
        ((d)com.tencent.mm.kernel.h.ae(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(2), paramejo, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
        break label401;
        label776:
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 7);
        Log.i("MicroMsg.SnsService", "remindInfo is null!");
        i = paramInt1;
        break label547;
        label802:
        Log.i("MicroMsg.SnsService", "remindInfo group is null!");
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 5);
        i = paramInt1;
        break label547;
        label827:
        if (com.tencent.mm.plugin.sns.ui.widget.e.ki(paramInt2, 8))
        {
          Log.i("MicroMsg.SnsService", "sendAtFriend");
          if (paramejo != null)
          {
            if (paramejo.RHX != null)
            {
              localejj.Ulv.RJc = paramejo.RHX;
              Log.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramejo.RHX.Ucl), Integer.valueOf(paramejo.RHX.Ucg) });
              if ((paramejo.RHX.Ucl != 0L) || (paramejo.RHX.Ucg != 0)) {
                break label1089;
              }
              com.tencent.mm.plugin.report.service.h.IzE.el(955, 8);
              i = paramInt1;
              break label547;
            }
            if (paramejo.RHY != null)
            {
              localejj.Ulv.RJc = paramejo.RHY;
              Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramejo.RHY.Ucl), Integer.valueOf(paramejo.RHY.Ucg) });
              if ((paramejo.RHY.Ucl != 0L) || (paramejo.RHY.Ucg != 0)) {
                break label1089;
              }
              com.tencent.mm.plugin.report.service.h.IzE.el(955, 8);
              i = paramInt1;
              break label547;
            }
            com.tencent.mm.plugin.report.service.h.IzE.el(955, 6);
            Log.i("MicroMsg.SnsService", "remindInfo is null!");
            i = paramInt1;
            break label547;
          }
          Log.i("MicroMsg.SnsService", "remindInfo group is null!");
          com.tencent.mm.plugin.report.service.h.IzE.el(955, 5);
        }
        label1089:
        i = paramInt1;
        break label547;
        label1095:
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new p(localejj, paramejo, paramInt3), 0);
        continue;
        label1125:
        Log.e("MicroMsg.SnsService", "can not add Comment");
      }
    }
    
    public static void bak(String paramString)
    {
      AppMethodBeat.i(95908);
      Object localObject = aj.fOH();
      if (Util.isNullOrNil(((ag)localObject).iRj)) {
        ((ag)localObject).iRj = com.tencent.mm.model.z.bcZ();
      }
      localObject = ((ag)localObject).iRj;
      SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.storage.f.bbk(paramString);
      for (;;)
      {
        try
        {
          SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
          Iterator localIterator = localSnsObject.LikeUserList.iterator();
          if (localIterator.hasNext())
          {
            ejo localejo = (ejo)localIterator.next();
            if (!localejo.Username.equals(localObject)) {
              continue;
            }
            localSnsObject.LikeUserList.remove(localejo);
            localSnsObject.LikeCount -= 1;
            localSnsInfo.field_attrBuf = localSnsObject.toByteArray();
            if (!localSnsInfo.isAd()) {
              continue;
            }
            aj.fOL().replace(localSnsInfo.getAdSnsInfo());
          }
        }
        catch (Exception localException)
        {
          continue;
          String str = localException.viewId;
          continue;
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new s(y.aYS(paramString), 5), 0);
          AppMethodBeat.o(95908);
        }
        if (!aj.fOH().QM(y.aYS(paramString))) {
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
        ((d)com.tencent.mm.kernel.h.ae(d.class)).b(11855, localSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localSnsInfo.getAdRecSrc()) });
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new s(y.aYS(paramString), 7), 0);
        AppMethodBeat.o(95908);
        return;
        aj.fOI().T(localSnsInfo);
      }
    }
    
    public static int fPq()
    {
      AppMethodBeat.i(95906);
      if (JZs != -1)
      {
        i = JZs;
        AppMethodBeat.o(95906);
        return i;
      }
      JZs = com.tencent.mm.plugin.sns.data.t.fNm();
      Log.i("MicroMsg.SnsService", "getTimelineControlFlag %d", new Object[] { Integer.valueOf(JZs) });
      int i = JZs;
      AppMethodBeat.o(95906);
      return i;
    }
    
    public final void QO(long paramLong)
    {
      AppMethodBeat.i(179094);
      Log.d("MicroMsg.SnsService", "setTimeFirstId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong == 0L)
      {
        AppMethodBeat.o(179094);
        return;
      }
      this.JZz = paramLong;
      AppMethodBeat.o(179094);
    }
    
    public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
    {
      AppMethodBeat.i(95902);
      Log.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (paramInt1 == 2)
      {
        if (!ab.aZY(paramString))
        {
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == aw.Kbj)
        {
          this.JZD.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == aw.Kbk)
        {
          aw.b(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == aw.Kbl)
        {
          aw.i(paramString, paramBoolean, paramInt3);
          AppMethodBeat.o(95902);
        }
      }
      else if (paramInt1 == 1)
      {
        if (!z.aZV("@__weixintimtline"))
        {
          AppMethodBeat.o(95902);
          return;
        }
        aj.fOT().KaH = paramInt2;
        if (paramInt2 == aw.Kbj)
        {
          this.JZD.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == aw.Kbk)
        {
          aj.fOT().KaK = true;
          aw.b(paramString, paramBoolean, paramInt3, this.JZz, paramInt1);
        }
      }
      AppMethodBeat.o(95902);
    }
    
    public final void a(int paramInt, String paramString, j.a arg3)
    {
      AppMethodBeat.i(95898);
      Log.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
      aj.fOH().iRj = com.tencent.mm.model.z.bcZ();
      aj.fOH().fOh();
      aj.fOE().fNd();
      if (this.lCH.isEmpty())
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(211, this);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(212, this);
      }
      if (!this.lCH.containsKey(???))
      {
        if (paramInt == 1) {
          this.lCH.put(???, "@__weixintimtline");
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
          this.lCH.put(???, paramString);
          break;
        }
        if (paramInt == 4)
        {
          this.lCH.put(???, "@__classify_timeline");
          break;
        }
        if (paramInt == 5)
        {
          this.lCH.put(???, "");
          break;
        }
        this.lCH.put(???, "");
        break;
        synchronized (this.JZt)
        {
          this.JZt.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.JZu)
        {
          if (!this.JZu.containsKey(paramString)) {
            this.JZu.put(paramString, Integer.valueOf(fPp()));
          }
          ab.aZZ(paramString);
          this.JZA.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        synchronized (this.JZv)
        {
          this.JZv.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.JZw)
        {
          if (!this.JZw.containsKey(paramString)) {
            this.JZw.put(paramString, Integer.valueOf(fPp()));
          }
          ab.aZZ(paramString);
          this.JZA.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        this.JZy = 0L;
        this.JZx = fPp();
        z.aZW("@__weixintimtline");
      }
    }
    
    public final void a(final int paramInt1, final String paramString, final boolean paramBoolean, final int paramInt2)
    {
      AppMethodBeat.i(95901);
      if (ac.mFr)
      {
        AppMethodBeat.o(95901);
        return;
      }
      Log.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
      xl localxl = new xl();
      localxl.fWs.state = 1;
      EventCenter.instance.publish(localxl);
      if (paramInt1 == 2)
      {
        aj.fwa().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216242);
            if (!ab.aZY(paramString))
            {
              AppMethodBeat.o(216242);
              return;
            }
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.an.t localt = com.tencent.mm.kernel.h.aHF().kcd;
            String str = paramString;
            boolean bool = paramBoolean;
            int j = paramInt2;
            int k = aw.Kbi;
            if (paramBoolean) {}
            for (int i = 4;; i = 8)
            {
              localt.a(new ab(str, 0L, bool, j, k, 0, i, paramInt1), 0);
              AppMethodBeat.o(216242);
              return;
            }
          }
        });
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 == 1)
      {
        if (!z.aZV("@__weixintimtline"))
        {
          AppMethodBeat.o(95901);
          return;
        }
        aj.fOT().KaH = aw.Kbl;
        aj.fOT().KaP = aj.fOI().h(0L, 1, true);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().i(68377, "");
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new z(0L, 0L, 0), 0);
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!o.aZV("@__classify_timeline"))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new o(""), 0);
          AppMethodBeat.o(95901);
          return;
        }
        if (paramInt1 == 10) {
          aj.fwa().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193697);
              if (!ab.aZY(paramString))
              {
                AppMethodBeat.o(193697);
                return;
              }
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(new ab(paramString, 0L, paramBoolean, paramInt2, aw.Kbi, 1, 64, paramInt1), 0);
              AppMethodBeat.o(193697);
            }
          });
        }
      }
      AppMethodBeat.o(95901);
    }
    
    public final boolean a(j.a parama, int paramInt)
    {
      AppMethodBeat.i(95899);
      Log.d("MicroMsg.SnsService", "closeServer");
      this.lCH.remove(parama);
      if (((paramInt == 2) || (paramInt == 10)) && (this.JZA.size() > 0)) {
        this.JZA.removeLast();
      }
      if (this.lCH.isEmpty())
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.b(211, this);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.b(212, this);
        aq.release();
        SnsInfo.release();
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95894);
            ap.a.a(ap.a.this);
            AppMethodBeat.o(95894);
          }
        }, 5000L);
        an.fPi();
        Log.i("MicroMsg.SnsService", "close finish");
      }
      AppMethodBeat.o(95899);
      return true;
    }
    
    public final void aYP(String paramString)
    {
      AppMethodBeat.i(95914);
      String str1 = aj.getAccSnsPath();
      String str2 = paramString + "bg_";
      String str3 = paramString + "tbg_";
      if (u.agG(str2))
      {
        u.deleteFile(aq.kD(str1, paramString) + str3);
        u.bj(aq.kD(str1, paramString), str2, str3);
      }
      AppMethodBeat.o(95914);
    }
    
    public final void af(long paramLong, int paramInt)
    {
      AppMethodBeat.i(95905);
      Log.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramInt > 0)
      {
        this.JZx = paramInt;
        com.tencent.mm.plugin.sns.data.t.afD(paramInt);
      }
      if (paramLong == 0L)
      {
        AppMethodBeat.o(95905);
        return;
      }
      this.JZy = paramLong;
      AppMethodBeat.o(95905);
    }
    
    public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95900);
      if (ac.mFr)
      {
        AppMethodBeat.o(95900);
        return;
      }
      synchronized (this.JZt)
      {
        Log.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.JZy), this.JZt });
        if (paramInt1 != 2) {
          break label244;
        }
        if (!ab.aZY(paramString))
        {
          AppMethodBeat.o(95900);
          return;
        }
      }
      long l = 0L;
      synchronized (this.JZt)
      {
        if (this.JZt.containsKey(paramString)) {
          l = ((Long)this.JZt.get(paramString)).longValue();
        }
        if (l == 0L)
        {
          ab.aZZ(paramString);
          AppMethodBeat.o(95900);
          return;
        }
      }
      com.tencent.mm.kernel.h.aHH();
      ??? = com.tencent.mm.kernel.h.aHF().kcd;
      int j = aw.Kbi;
      if (paramBoolean) {}
      for (int i = 4;; i = 8)
      {
        ((com.tencent.mm.an.t)???).a(new ab(paramString, l, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
        AppMethodBeat.o(95900);
        return;
      }
      label244:
      if (paramInt1 == 1)
      {
        if (!z.aZV("@__weixintimtline"))
        {
          AppMethodBeat.o(95900);
          return;
        }
        if (this.JZy == 0L)
        {
          z.aZW("@__weixintimtline");
          AppMethodBeat.o(95900);
          return;
        }
        aj.fOT().KaH = aw.Kbl;
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new z(this.JZy, 0L, 0), 0);
        AppMethodBeat.o(95900);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!o.aZV("@__classify_timeline"))
          {
            AppMethodBeat.o(95900);
            return;
          }
          if (this.JZy == 0L)
          {
            o.aZW("@__classify_timeline");
            AppMethodBeat.o(95900);
            return;
          }
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new o(""), 0);
          AppMethodBeat.o(95900);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!ab.aZY(paramString))
          {
            AppMethodBeat.o(95900);
            return;
          }
          l = 0L;
          synchronized (this.JZv)
          {
            if (this.JZv.containsKey(paramString)) {
              l = ((Long)this.JZv.get(paramString)).longValue();
            }
            if (l == 0L)
            {
              ab.aZZ(paramString);
              AppMethodBeat.o(95900);
              return;
            }
          }
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(new ab(paramString, l, paramBoolean, paramInt2, aw.Kbi, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95900);
    }
    
    public final void bai(String paramString)
    {
      AppMethodBeat.i(268477);
      this.JZB.remove(paramString);
      AppMethodBeat.o(268477);
    }
    
    public final int baj(String paramString)
    {
      AppMethodBeat.i(268481);
      synchronized (this.JZu)
      {
        if (this.JZu.containsKey(paramString))
        {
          i = ((Integer)this.JZu.get(paramString)).intValue();
          if (i > 0) {}
          for (;;)
          {
            AppMethodBeat.o(268481);
            return i;
            i = com.tencent.mm.plugin.sns.data.t.fNn();
          }
        }
        int i = com.tencent.mm.plugin.sns.data.t.fNn();
        AppMethodBeat.o(268481);
        return i;
      }
    }
    
    public final Intent f(Intent paramIntent, String paramString)
    {
      AppMethodBeat.i(95897);
      paramIntent.putExtra("sns_userName", paramString);
      if ((this.JZA != null) && (this.JZA.contains(paramString)))
      {
        paramIntent.addFlags(536870912);
        paramIntent.addFlags(67108864);
        AppMethodBeat.o(95897);
        return paramIntent;
      }
      AppMethodBeat.o(95897);
      return paramIntent;
    }
    
    public final int fPp()
    {
      AppMethodBeat.i(268482);
      if (this.JZx > 0)
      {
        i = this.JZx;
        AppMethodBeat.o(268482);
        return i;
      }
      int i = com.tencent.mm.plugin.sns.data.t.fNn();
      AppMethodBeat.o(268482);
      return i;
    }
    
    public final void n(String paramString, ArrayList<com.tencent.mm.plugin.sns.j.b> paramArrayList)
    {
      AppMethodBeat.i(95896);
      this.JZB.put(paramString, paramArrayList);
      AppMethodBeat.o(95896);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(95907);
      Log.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType());
      if ((paramq != null) && ((paramq instanceof z)) && (((z)paramq).fOd())) {}
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
        paramString = new ArrayList(this.lCH.keySet());
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
          paramq = (j.a)paramString.next();
          if (this.lCH.containsKey(paramq))
          {
            ??? = (String)this.lCH.get(paramq);
            if ((localb.getUserName().equals(???)) && (localb.fMM()))
            {
              ??? = com.tencent.mm.plugin.sns.data.t.Qv(an.JVf);
              str = com.tencent.mm.plugin.sns.data.t.Qv(an.JVg);
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
          ??? = (j.a)paramq.next();
          if (this.lCH.containsKey(???))
          {
            paramString = (String)this.lCH.get(???);
            if (localb.getUserName().equals(paramString))
            {
              Log.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
              if (localb.fMS() == 0L)
              {
                paramString = "";
                if (!localb.fML()) {
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
                    ((j.a)???).a(paramString, bool, paramInt2, localb);
                    break label470;
                    ??? = (ab)paramq;
                    paramq = ((ab)???).userName;
                    l = ((ab)???).JVg;
                    i = ((ab)???).JVi;
                    if (((ab)???).JWD == 10)
                    {
                      if (i > 0) {}
                      synchronized (this.JZw)
                      {
                        for (;;)
                        {
                          this.JZw.put(paramq, Integer.valueOf(i));
                          if (l == 0L) {
                            break;
                          }
                          synchronized (this.JZv)
                          {
                            this.JZv.put(paramq, Long.valueOf(l));
                          }
                        }
                      }
                    }
                  }
                  if (i > 0) {}
                  synchronized (this.JZu)
                  {
                    for (;;)
                    {
                      this.JZu.put(paramq, Integer.valueOf(i));
                      if (l == 0L) {
                        break;
                      }
                      synchronized (this.JZt)
                      {
                        this.JZt.put(paramq, Long.valueOf(l));
                      }
                    }
                  }
                }
                paramq = (z)paramq;
                if (localb.fMM()) {
                  QO(paramq.JVf);
                }
                for (;;)
                {
                  i = paramq.JVj;
                  if (JZs != i) {
                    com.tencent.mm.plugin.sns.data.t.afC(i);
                  }
                  Log.i("MicroMsg.SnsService", "updateTimelineControlFlag %d", new Object[] { Integer.valueOf(i) });
                  JZs = i;
                  break;
                  af(paramq.JVg, paramq.JVi);
                }
                paramString = com.tencent.mm.plugin.sns.data.t.Qv(localb.fMS());
                break label566;
              }
              if (localb.fMM())
              {
                bool = false;
                if (localb.fMN() == aw.Kbj)
                {
                  an.JZj = an.JVf;
                  bool = true;
                }
                Log.i("MicroMsg.SnsService", "fetchType:%s, preUpReady:%s, firstPage:%s", new Object[] { Integer.valueOf(localb.fMN()), Boolean.valueOf(this.JZD.Kbm), Boolean.valueOf(bool) });
                paramString = com.tencent.mm.plugin.sns.data.t.Qv(an.JVf);
                str = com.tencent.mm.plugin.sns.data.t.Qv(an.JVg);
                if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
                for (bool = true;; bool = false)
                {
                  ((j.a)???).a(paramString, str, bool, paramInt2, localb);
                  break;
                }
              }
              if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
              for (bool = true;; bool = false)
              {
                ((j.a)???).b(paramString, bool, paramInt2, localb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */