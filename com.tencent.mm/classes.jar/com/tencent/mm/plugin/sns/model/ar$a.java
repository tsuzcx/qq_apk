package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ze;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.h.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ar$a
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.sns.c.k
{
  public static int QwA = -1;
  private Map<String, Long> QwB;
  private Map<String, Integer> QwC;
  private Map<String, Long> QwD;
  private Map<String, Integer> QwE;
  private int QwF;
  public long QwG;
  public long QwH;
  private LinkedList<String> QwI;
  private Map<String, ArrayList<bzi>> QwJ;
  private Map<String, Integer> QwK;
  private ay QwL;
  private Map<k.a, String> our;
  
  public ar$a()
  {
    AppMethodBeat.i(95895);
    this.QwB = new HashMap();
    this.QwC = new HashMap();
    this.QwD = new HashMap();
    this.QwE = new HashMap();
    this.QwF = 0;
    this.QwG = 0L;
    this.QwH = 0L;
    this.our = new HashMap();
    this.QwI = new LinkedList();
    this.QwJ = new HashMap();
    this.QwK = new HashMap();
    this.QwL = new ay();
    AppMethodBeat.o(95895);
  }
  
  public static fdv a(SnsInfo paramSnsInfo, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(95909);
    paramSnsInfo = b(paramSnsInfo, paramInt1, paramString, null, 0, paramInt2, "");
    AppMethodBeat.o(95909);
    return paramSnsInfo;
  }
  
  public static fdv a(SnsInfo paramSnsInfo, int paramInt1, String paramString1, fdv paramfdv, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(95910);
    paramSnsInfo = b(paramSnsInfo, paramInt1, paramString1, paramfdv, paramInt2, paramInt3, paramString2);
    AppMethodBeat.o(95910);
    return paramSnsInfo;
  }
  
  public static fdv a(SnsInfo paramSnsInfo, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(95912);
    fdp localfdp = new fdp();
    localfdp.nUB = paramString1;
    localfdp.CreateTime = ((int)(Util.nowMilliSecond() / 1000L));
    localfdp.abDe = com.tencent.mm.model.z.bAO();
    localfdp.abnl = com.tencent.mm.model.z.bAM();
    localfdp.IcB = paramInt2;
    localfdp.abDf = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramSnsInfo.getUserName());
    localfdp.Zvy = paramSnsInfo.getUserName();
    localfdp.vhJ = paramInt1;
    fdq localfdq;
    String str;
    if (paramSnsInfo.isSourceExist(32))
    {
      localfdp.abDi = 0L;
      paramString1 = new fdp();
      paramString1.abnl = paramString2;
      if (!Util.isNullOrNil(paramString1.abnl)) {
        paramString1.abDe = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1.abnl);
      }
      localfdq = new fdq();
      localfdq.Id = paramSnsInfo.field_snsId;
      localfdq.abDp = localfdp;
      localfdq.abDq = paramString1;
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
        if (localfdp.vhJ != 7) {
          break label396;
        }
        ((d)com.tencent.mm.kernel.h.ax(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
        str = paramString1;
      }
      label271:
      paramString2 = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
      paramString1 = paramString2;
      if (paramSnsInfo.isSourceExist(32)) {
        paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
      }
      if (!al.hgA().a(paramString1, localfdq, str)) {
        break label490;
      }
      if (!ai.aYr(paramString1)) {
        break label460;
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new k(localfdq, paramString1, str, 0), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(95912);
      return null;
      localfdp.abDg = 0;
      break;
      label380:
      paramString2 = paramString1.viewId;
      break label206;
      label388:
      paramString1 = paramString1.uxInfo;
      break label213;
      label396:
      str = paramString1;
      if (localfdp.vhJ != 8) {
        break label271;
      }
      ((d)com.tencent.mm.kernel.h.ax(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
      str = paramString1;
      break label271;
      label460:
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new p(localfdq, paramString1, paramInt2), 0);
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
    fdp localfdp = new fdp();
    localfdp.nUB = paramString2;
    localfdp.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    localfdp.abDe = com.tencent.mm.model.z.bAO();
    localfdp.abnl = com.tencent.mm.model.z.bAM();
    localfdp.IcB = paramInt2;
    localfdp.abDf = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1);
    localfdp.Zvy = paramString1;
    localfdp.vhJ = paramInt1;
    paramString2 = new fdq();
    paramString2.Id = paramSnsInfo.field_snsId;
    paramString2.abDp = localfdp;
    paramString2.abDq = new fdp();
    String str = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
    long l = paramSnsInfo.field_snsId;
    try
    {
      Log.v("MicroMsg.SnsService", "comment stg inserted");
      paramSnsInfo = new com.tencent.mm.plugin.sns.storage.o();
      paramSnsInfo.field_talker = paramString1;
      paramSnsInfo.field_snsID = l;
      paramSnsInfo.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
      paramSnsInfo.field_curActionBuf = localfdp.toByteArray();
      paramSnsInfo.field_type = paramInt1;
      paramSnsInfo.field_isSend = true;
      paramSnsInfo.field_isRead = 1;
      al.hgH().insert(paramSnsInfo);
      al.hgA().a(str, paramString2);
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
  
  public static void aYC(String paramString)
  {
    AppMethodBeat.i(95908);
    Object localObject = al.hgA();
    if (Util.isNullOrNil(((ai)localObject).ltf)) {
      ((ai)localObject).ltf = com.tencent.mm.model.z.bAM();
    }
    localObject = ((ai)localObject).ltf;
    SnsInfo localSnsInfo = l.aZK(paramString);
    for (;;)
    {
      try
      {
        SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
        Iterator localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          fdv localfdv = (fdv)localIterator.next();
          if (!localfdv.Username.equals(localObject)) {
            continue;
          }
          localSnsObject.LikeUserList.remove(localfdv);
          localSnsObject.LikeCount -= 1;
          localSnsInfo.field_attrBuf = localSnsObject.toByteArray();
          if (!localSnsInfo.isAd()) {
            continue;
          }
          al.hgE().replace(localSnsInfo.getAdSnsInfo());
        }
      }
      catch (Exception localException)
      {
        continue;
        String str = localException.viewId;
        continue;
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new s(com.tencent.mm.plugin.sns.storage.ai.aXe(paramString), 5), 0);
        AppMethodBeat.o(95908);
      }
      if (!al.hgA().uS(com.tencent.mm.plugin.sns.storage.ai.aXe(paramString))) {
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
      ((d)com.tencent.mm.kernel.h.ax(d.class)).b(11855, localSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localSnsInfo.getAdRecSrc()) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new s(com.tencent.mm.plugin.sns.storage.ai.aXe(paramString), 7), 0);
      AppMethodBeat.o(95908);
      return;
      al.hgB().V(localSnsInfo);
    }
  }
  
  private static fdv b(SnsInfo paramSnsInfo, int paramInt1, String paramString1, fdv paramfdv, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(95911);
    fdp localfdp = new fdp();
    localfdp.nUB = paramString1;
    localfdp.CreateTime = ((int)(Util.nowMilliSecond() / 1000L));
    localfdp.abDe = com.tencent.mm.model.z.bAO();
    localfdp.abnl = com.tencent.mm.model.z.bAM();
    localfdp.IcB = 0;
    localfdp.abDf = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramSnsInfo.getUserName());
    localfdp.Zvy = paramSnsInfo.getUserName();
    localfdp.vhJ = paramInt1;
    localfdp.abDl = paramInt2;
    long l;
    label189:
    fdq localfdq;
    int i;
    if (paramSnsInfo.isSourceExist(32)) {
      if (paramfdv == null)
      {
        l = 0L;
        localfdp.abDi = l;
        if (!Util.isNullOrNil(paramString2))
        {
          paramString1 = new feb();
          paramString1.Md5 = paramString2;
          localfdp.abDm = new LinkedList();
          localfdp.abDm.add(paramString1);
          localfdp.abDn = 1;
        }
        paramString2 = new fdp();
        if (paramfdv != null) {
          break label684;
        }
        paramString1 = "";
        paramString2.abnl = paramString1;
        if (!Util.isNullOrNil(paramString2.abnl)) {
          paramString2.abDe = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString2.abnl);
        }
        localfdq = new fdq();
        localfdq.Id = paramSnsInfo.field_snsId;
        localfdq.abDp = localfdp;
        localfdq.abDq = paramString2;
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
          paramfdv = "";
          label339:
          if (paramString1 != null) {
            break label710;
          }
          paramString1 = "";
          label346:
          if (localfdp.vhJ != 7) {
            break label718;
          }
          ((d)com.tencent.mm.kernel.h.ax(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(1), paramfdv, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
          label401:
          paramfdv = paramSnsInfo.getAdSnsInfo();
          if (paramfdv == null) {
            break label1089;
          }
          if (paramfdv.field_firstControlTime == 0)
          {
            paramfdv.field_firstControlTime = localfdp.CreateTime;
            al.hgE().b(paramfdv.field_snsId, paramfdv);
          }
          paramfdv = paramfdv.getRemindInfoGroup();
          if (paramInt3 != 2) {
            break label827;
          }
          if (paramfdv == null) {
            break label802;
          }
          localfdq.abDp.YGq = paramfdv.YFa;
          if (paramfdv.YFa == null) {
            break label776;
          }
          Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramfdv.YFa.abtD), Integer.valueOf(paramfdv.YFa.abty) });
          if ((paramfdv.YFa.abtD != 0L) || (paramfdv.YFa.abty != 0)) {
            break label1089;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 9);
          i = paramInt1;
        }
        label547:
        paramString2 = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
        paramfdv = paramString2;
        if (paramSnsInfo.isSourceExist(32)) {
          paramfdv = "_AD_TAG_".concat(String.valueOf(paramString2));
        }
        if (!al.hgA().a(paramfdv, localfdq)) {
          break label1125;
        }
        if (!ai.aYr(paramfdv)) {
          break label1095;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new k(localfdq, paramfdv, paramString1, i), 0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95911);
      return null;
      l = paramfdv.abDj;
      break;
      if (paramfdv == null) {}
      for (i = 0;; i = paramfdv.abDh)
      {
        localfdp.abDg = i;
        break;
      }
      label684:
      paramString1 = paramfdv.Username;
      break label189;
      label692:
      paramString1 = paramSnsInfo.getAdInfo();
      paramInt1 = 0;
      break label332;
      label702:
      paramfdv = paramString1.viewId;
      break label339;
      label710:
      paramString1 = paramString1.uxInfo;
      break label346;
      label718:
      if (localfdp.vhJ != 8) {
        break label401;
      }
      ((d)com.tencent.mm.kernel.h.ax(d.class)).b(11855, paramSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(2), paramfdv, Integer.valueOf(paramSnsInfo.getAdRecSrc()) });
      break label401;
      label776:
      com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 7);
      Log.i("MicroMsg.SnsService", "remindInfo is null!");
      i = paramInt1;
      break label547;
      label802:
      Log.i("MicroMsg.SnsService", "remindInfo group is null!");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 5);
      i = paramInt1;
      break label547;
      label827:
      if (com.tencent.mm.plugin.sns.ui.widget.g.lU(paramInt2, 8))
      {
        Log.i("MicroMsg.SnsService", "sendAtFriend");
        if (paramfdv != null)
        {
          if (paramfdv.YEZ != null)
          {
            localfdq.abDp.YGq = paramfdv.YEZ;
            Log.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramfdv.YEZ.abtD), Integer.valueOf(paramfdv.YEZ.abty) });
            if ((paramfdv.YEZ.abtD != 0L) || (paramfdv.YEZ.abty != 0)) {
              break label1089;
            }
            com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 8);
            i = paramInt1;
            break label547;
          }
          if (paramfdv.YFa != null)
          {
            localfdq.abDp.YGq = paramfdv.YFa;
            Log.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramfdv.YFa.abtD), Integer.valueOf(paramfdv.YFa.abty) });
            if ((paramfdv.YFa.abtD != 0L) || (paramfdv.YFa.abty != 0)) {
              break label1089;
            }
            com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 8);
            i = paramInt1;
            break label547;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 6);
          Log.i("MicroMsg.SnsService", "remindInfo is null!");
          i = paramInt1;
          break label547;
        }
        Log.i("MicroMsg.SnsService", "remindInfo group is null!");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 5);
      }
      label1089:
      i = paramInt1;
      break label547;
      label1095:
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new p(localfdq, paramfdv, paramInt3), 0);
      continue;
      label1125:
      Log.e("MicroMsg.SnsService", "can not add Comment");
    }
  }
  
  private void b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309553);
    if (paramInt2 == 10)
    {
      if (paramInt1 > 0) {}
      synchronized (this.QwE)
      {
        this.QwE.put(paramString, Integer.valueOf(paramInt1));
        if (paramLong == 0L)
        {
          AppMethodBeat.o(309553);
          return;
        }
      }
      synchronized (this.QwD)
      {
        this.QwD.put(paramString, Long.valueOf(paramLong));
        AppMethodBeat.o(309553);
        return;
      }
    }
    if (paramInt1 > 0) {}
    synchronized (this.QwC)
    {
      this.QwC.put(paramString, Integer.valueOf(paramInt1));
      if (paramLong == 0L)
      {
        AppMethodBeat.o(309553);
        return;
      }
    }
    synchronized (this.QwB)
    {
      this.QwB.put(paramString, Long.valueOf(paramLong));
      AppMethodBeat.o(309553);
      return;
    }
  }
  
  public static int hhj()
  {
    AppMethodBeat.i(95906);
    if (QwA != -1)
    {
      i = QwA;
      AppMethodBeat.o(95906);
      return i;
    }
    QwA = t.heO();
    Log.i("MicroMsg.SnsService", "getTimelineControlFlag %d", new Object[] { Integer.valueOf(QwA) });
    int i = QwA;
    AppMethodBeat.o(95906);
    return i;
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(95902);
    Log.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (paramInt1 == 2)
    {
      if (!ab.aYm(paramString))
      {
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == ay.Qyz)
      {
        this.QwL.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == ay.QyA)
      {
        ay.b(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == ay.QyB)
      {
        ay.h(paramString, paramBoolean, paramInt3);
        AppMethodBeat.o(95902);
      }
    }
    else if (paramInt1 == 1)
    {
      if (!z.aYj("@__weixintimtline"))
      {
        AppMethodBeat.o(95902);
        return;
      }
      al.hgN().QxQ = paramInt2;
      if (paramInt2 == ay.Qyz)
      {
        this.QwL.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == ay.QyA)
      {
        al.hgN().QxT = true;
        ay.b(paramString, paramBoolean, paramInt3, this.QwH, paramInt1);
      }
    }
    AppMethodBeat.o(95902);
  }
  
  public final void a(int paramInt, String paramString, k.a arg3)
  {
    AppMethodBeat.i(95898);
    Log.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
    boolean bool = au.bwO(paramString);
    al.hgA().ltf = com.tencent.mm.model.z.bAM();
    al.hgA().hfT();
    al.hgx().hej();
    if (this.our.isEmpty())
    {
      if (!bool)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(211, this);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(212, this);
      }
    }
    else
    {
      if (!this.our.containsKey(???))
      {
        if (paramInt != 1) {
          break label211;
        }
        this.our.put(???, "@__weixintimtline");
      }
      label149:
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95898);
      return;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(5203, this);
      break;
      label211:
      if ((paramInt == 2) || (paramInt == 3) || (paramInt == 10))
      {
        this.our.put(???, paramString);
        break label149;
      }
      if (paramInt == 4)
      {
        this.our.put(???, "@__classify_timeline");
        break label149;
      }
      if (paramInt == 5)
      {
        this.our.put(???, "");
        break label149;
      }
      this.our.put(???, "");
      break label149;
      synchronized (this.QwB)
      {
        this.QwB.put(paramString, Long.valueOf(0L));
      }
      for (;;)
      {
        synchronized (this.QwC)
        {
          if (!this.QwC.containsKey(paramString)) {
            this.QwC.put(paramString, Integer.valueOf(hhi()));
          }
          if (!bool)
          {
            ab.aYn(paramString);
            this.QwI.add(paramString);
            AppMethodBeat.o(95898);
            return;
            paramString = finally;
            AppMethodBeat.o(95898);
            throw paramString;
          }
        }
        ad.aYp(paramString);
      }
      synchronized (this.QwD)
      {
        this.QwD.put(paramString, Long.valueOf(0L));
      }
      for (;;)
      {
        synchronized (this.QwE)
        {
          if (!this.QwE.containsKey(paramString)) {
            this.QwE.put(paramString, Integer.valueOf(hhi()));
          }
          if (!bool)
          {
            ab.aYn(paramString);
            this.QwI.add(paramString);
            AppMethodBeat.o(95898);
            return;
            paramString = finally;
            AppMethodBeat.o(95898);
            throw paramString;
          }
        }
        ad.aYp(paramString);
      }
      this.QwG = 0L;
      this.QwF = hhi();
      z.aYk("@__weixintimtline");
    }
  }
  
  public final void a(final int paramInt1, final String paramString, final boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(95901);
    if (com.tencent.mm.platformtools.z.pBS)
    {
      AppMethodBeat.o(95901);
      return;
    }
    boolean bool = au.bwO(paramString);
    Log.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    ze localze = new ze();
    localze.icr.state = 1;
    localze.publish();
    if (paramInt1 == 2)
    {
      if (!bool)
      {
        al.gHI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309500);
            if (!ab.aYm(paramString))
            {
              AppMethodBeat.o(309500);
              return;
            }
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
            String str = paramString;
            boolean bool = paramBoolean;
            int j = paramInt2;
            int k = ay.Qyy;
            if (paramBoolean) {}
            for (int i = 4;; i = 8)
            {
              locals.a(new ab(str, 0L, bool, j, k, 0, i, paramInt1), 0);
              AppMethodBeat.o(309500);
              return;
            }
          }
        });
        AppMethodBeat.o(95901);
        return;
      }
      al.gHI().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(309499);
          if (!ad.aYo(paramString))
          {
            AppMethodBeat.o(309499);
            return;
          }
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
          String str = paramString;
          boolean bool = paramBoolean;
          int j = paramInt2;
          int k = ay.Qyy;
          if (paramBoolean) {}
          for (int i = 4;; i = 8)
          {
            locals.a(new ad(str, 0L, bool, j, k, 0, i, paramInt1), 0);
            AppMethodBeat.o(309499);
            return;
          }
        }
      });
      AppMethodBeat.o(95901);
      return;
    }
    if (paramInt1 == 1)
    {
      if (!z.aYj("@__weixintimtline"))
      {
        AppMethodBeat.o(95901);
        return;
      }
      al.hgN().QxQ = ay.QyB;
      al.hgN().QxY = al.hgB().i(0L, 1, true);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(68377, "");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new z(0L, 0L, 0), 0);
      AppMethodBeat.o(95901);
      return;
    }
    if (paramInt1 != 3)
    {
      if (paramInt1 == 4)
      {
        if (!o.aYj("@__classify_timeline"))
        {
          AppMethodBeat.o(95901);
          return;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new o(""), 0);
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 == 10)
      {
        if (!bool)
        {
          al.gHI().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(309503);
              if (!ab.aYm(paramString))
              {
                AppMethodBeat.o(309503);
                return;
              }
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(new ab(paramString, 0L, paramBoolean, paramInt2, ay.Qyy, 1, 64, paramInt1), 0);
              AppMethodBeat.o(309503);
            }
          });
          AppMethodBeat.o(95901);
          return;
        }
        al.gHI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309502);
            if (!ad.aYo(paramString))
            {
              AppMethodBeat.o(309502);
              return;
            }
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(new ad(paramString, 0L, paramBoolean, paramInt2, ay.Qyy, 1, 64, paramInt1), 0);
            AppMethodBeat.o(309502);
          }
        });
      }
    }
    AppMethodBeat.o(95901);
  }
  
  public final boolean a(k.a parama, int paramInt)
  {
    AppMethodBeat.i(95899);
    Log.d("MicroMsg.SnsService", "closeServer");
    this.our.remove(parama);
    if (((paramInt == 2) || (paramInt == 10)) && (this.QwI.size() > 0)) {
      this.QwI.removeLast();
    }
    if (this.our.isEmpty())
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(211, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(212, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(5203, this);
      as.release();
      SnsInfo.release();
      new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95894);
          ar.a.a(ar.a.this);
          AppMethodBeat.o(95894);
        }
      }, 5000L);
      ap.hhb();
      Log.i("MicroMsg.SnsService", "close finish");
    }
    AppMethodBeat.o(95899);
    return true;
  }
  
  public final void aWX(String paramString)
  {
    AppMethodBeat.i(95914);
    String str1 = al.getAccSnsPath();
    String str2 = paramString + "bg_";
    String str3 = paramString + "tbg_";
    if (y.ZC(str2))
    {
      y.deleteFile(as.mg(str1, paramString) + str3);
      y.bF(as.mg(str1, paramString), str2, str3);
    }
    AppMethodBeat.o(95914);
  }
  
  public final ArrayList<bzi> aYA(String paramString)
  {
    AppMethodBeat.i(309626);
    paramString = (ArrayList)this.QwJ.get(paramString);
    AppMethodBeat.o(309626);
    return paramString;
  }
  
  public final int aYB(String paramString)
  {
    AppMethodBeat.i(309723);
    synchronized (this.QwC)
    {
      if (this.QwC.containsKey(paramString))
      {
        i = ((Integer)this.QwC.get(paramString)).intValue();
        if (i > 0) {}
        for (;;)
        {
          AppMethodBeat.o(309723);
          return i;
          i = t.heP();
        }
      }
      int i = t.heP();
      AppMethodBeat.o(309723);
      return i;
    }
  }
  
  public final void aYz(String paramString)
  {
    AppMethodBeat.i(309609);
    this.QwJ.remove(paramString);
    AppMethodBeat.o(309609);
  }
  
  public final void ax(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95905);
    Log.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
    if (paramInt > 0)
    {
      this.QwF = paramInt;
      t.aks(paramInt);
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(95905);
      return;
    }
    this.QwG = paramLong;
    AppMethodBeat.o(95905);
  }
  
  public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(95900);
    if (com.tencent.mm.platformtools.z.pBS)
    {
      AppMethodBeat.o(95900);
      return;
    }
    boolean bool;
    synchronized (this.QwB)
    {
      Log.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.QwG), this.QwB });
      bool = au.bwO(paramString);
      if (paramInt1 != 2) {
        break label410;
      }
      if (bool) {
        break label255;
      }
      if (!ab.aYm(paramString))
      {
        AppMethodBeat.o(95900);
        return;
      }
    }
    long l = 0L;
    synchronized (this.QwB)
    {
      if (this.QwB.containsKey(paramString)) {
        l = ((Long)this.QwB.get(paramString)).longValue();
      }
      if (l == 0L)
      {
        ab.aYn(paramString);
        AppMethodBeat.o(95900);
        return;
      }
    }
    com.tencent.mm.kernel.h.baF();
    ??? = com.tencent.mm.kernel.h.baD().mCm;
    int j = ay.Qyy;
    if (paramBoolean) {}
    for (int i = 4;; i = 8)
    {
      ((com.tencent.mm.am.s)???).a(new ab(paramString, l, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
      AppMethodBeat.o(95900);
      return;
    }
    label255:
    if (!ad.aYo(paramString))
    {
      AppMethodBeat.o(95900);
      return;
    }
    l = 0L;
    synchronized (this.QwB)
    {
      if (this.QwB.containsKey(paramString)) {
        l = ((Long)this.QwB.get(paramString)).longValue();
      }
      if (l == 0L)
      {
        ad.aYp(paramString);
        AppMethodBeat.o(95900);
        return;
      }
    }
    com.tencent.mm.kernel.h.baF();
    ??? = com.tencent.mm.kernel.h.baD().mCm;
    j = ay.Qyy;
    if (paramBoolean) {}
    for (i = 4;; i = 8)
    {
      ((com.tencent.mm.am.s)???).a(new ad(paramString, l, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
      AppMethodBeat.o(95900);
      return;
    }
    label410:
    if (paramInt1 == 1)
    {
      if (!z.aYj("@__weixintimtline"))
      {
        AppMethodBeat.o(95900);
        return;
      }
      if (this.QwG == 0L)
      {
        z.aYk("@__weixintimtline");
        AppMethodBeat.o(95900);
        return;
      }
      al.hgN().QxQ = ay.QyB;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new z(this.QwG, 0L, 0), 0);
      AppMethodBeat.o(95900);
      return;
    }
    if (paramInt1 != 3)
    {
      if (paramInt1 == 4)
      {
        if (!o.aYj("@__classify_timeline"))
        {
          AppMethodBeat.o(95900);
          return;
        }
        if (this.QwG == 0L)
        {
          o.aYk("@__classify_timeline");
          AppMethodBeat.o(95900);
          return;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new o(""), 0);
        AppMethodBeat.o(95900);
        return;
      }
      if (paramInt1 == 10)
      {
        if (!bool)
        {
          if (!ab.aYm(paramString))
          {
            AppMethodBeat.o(95900);
            return;
          }
          l = 0L;
          synchronized (this.QwD)
          {
            if (this.QwD.containsKey(paramString)) {
              l = ((Long)this.QwD.get(paramString)).longValue();
            }
            if (l == 0L)
            {
              ab.aYn(paramString);
              AppMethodBeat.o(95900);
              return;
            }
          }
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(new ab(paramString, l, paramBoolean, paramInt2, ay.Qyy, 1, 64, paramInt1), 0);
          AppMethodBeat.o(95900);
          return;
        }
        if (!ad.aYo(paramString))
        {
          AppMethodBeat.o(95900);
          return;
        }
        l = 0L;
        synchronized (this.QwD)
        {
          if (this.QwD.containsKey(paramString)) {
            l = ((Long)this.QwD.get(paramString)).longValue();
          }
          if (l == 0L)
          {
            ad.aYp(paramString);
            AppMethodBeat.o(95900);
            return;
          }
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new ad(paramString, l, paramBoolean, paramInt2, ay.Qyy, 1, 64, paramInt1), 0);
      }
    }
    AppMethodBeat.o(95900);
  }
  
  public final Intent h(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(95897);
    paramIntent.putExtra("sns_userName", paramString);
    if ((this.QwI != null) && (this.QwI.contains(paramString)))
    {
      paramIntent.addFlags(536870912);
      paramIntent.addFlags(67108864);
      AppMethodBeat.o(95897);
      return paramIntent;
    }
    AppMethodBeat.o(95897);
    return paramIntent;
  }
  
  public final int hhi()
  {
    AppMethodBeat.i(309729);
    if (this.QwF > 0)
    {
      i = this.QwF;
      AppMethodBeat.o(309729);
      return i;
    }
    int i = t.heP();
    AppMethodBeat.o(309729);
    return i;
  }
  
  public final void o(String paramString, ArrayList<bzi> paramArrayList)
  {
    AppMethodBeat.i(95896);
    this.QwJ.put(paramString, paramArrayList);
    AppMethodBeat.o(95896);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(95907);
    Log.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType());
    if ((paramp != null) && ((paramp instanceof z)) && (((z)paramp).hfQ())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.SnsService", "skip by preload unread feeds");
      AppMethodBeat.o(95907);
      return;
    }
    label449:
    label590:
    label849:
    label855:
    label861:
    if ((paramp.getType() == 212) || (paramp.getType() == 5203) || (paramp.getType() == 211))
    {
      com.tencent.mm.plugin.sns.c.b localb = (com.tencent.mm.plugin.sns.c.b)paramp;
      paramString = new ArrayList(this.our.keySet());
      if (((paramInt1 != 4) || (paramInt2 != 207)) && ((paramInt1 != 4) || (paramInt2 != 203))) {
        if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2005)))
        {
          i = 1;
          if (i != 0) {
            break label449;
          }
          paramString = paramString.iterator();
        }
      }
      label237:
      Object localObject;
      String str;
      boolean bool1;
      while (paramString.hasNext())
      {
        paramp = (k.a)paramString.next();
        if (this.our.containsKey(paramp))
        {
          localObject = (String)this.our.get(paramp);
          if ((localb.getUserName().equals(localObject)) && (localb.hdS()))
          {
            localObject = t.uB(ap.maxId);
            str = t.uB(ap.Qsh);
            if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
            for (bool1 = true;; bool1 = false)
            {
              paramp.a((String)localObject, str, bool1, paramInt2, localb, false);
              break label237;
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
      switch (paramp.getType())
      {
      default: 
        paramp = paramString.iterator();
      }
      label494:
      while (paramp.hasNext())
      {
        localObject = (k.a)paramp.next();
        if (this.our.containsKey(localObject))
        {
          paramString = (String)this.our.get(localObject);
          if (localb.getUserName().equals(paramString))
          {
            Log.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
            if (localb.hdY() == 0L)
            {
              paramString = "";
              if (!localb.hdR()) {
                break label892;
              }
              if ((paramInt1 != 4) || ((paramInt2 != 2001) && (paramInt2 != 2004) && (paramInt2 != 2003) && (paramInt2 != 2005) && (paramInt2 != 203))) {
                break label886;
              }
            }
            label753:
            label886:
            for (bool1 = true;; bool1 = false)
            {
              ((k.a)localObject).a(paramString, bool1, paramInt2, localb);
              break label494;
              paramp = (ab)paramp;
              b(paramp.userName, paramp.Qsh, paramp.Qsj, paramp.QtJ);
              break;
              paramp = (ad)paramp;
              b(paramp.userName, paramp.Qsh, paramp.Qsj, paramp.QtJ);
              break;
              paramp = (z)paramp;
              int k;
              int j;
              if (localb.hdS())
              {
                uU(paramp.maxId);
                k = paramp.Qsk;
                if (QwA != k)
                {
                  t.akr(k);
                  if ((QwA & 0x4) <= 0) {
                    break label849;
                  }
                  i = 1;
                  if ((k & 0x4) <= 0) {
                    break label855;
                  }
                  j = 1;
                  if (j == 0) {
                    break label861;
                  }
                  a.stop();
                }
              }
              for (;;)
              {
                Log.i("MicroMsg.SnsService", "updateTimelineControlFlag %d", new Object[] { Integer.valueOf(k) });
                QwA = k;
                break;
                ax(paramp.Qsh, paramp.Qsj);
                break label753;
                i = 0;
                break label785;
                j = 0;
                break label795;
                if (i != 0) {
                  a.hff();
                }
              }
              paramString = t.uB(localb.hdY());
              break label590;
            }
            label892:
            if (localb.hdS())
            {
              bool1 = false;
              if (localb.hdT() == ay.Qyz)
              {
                ap.Qws = ap.maxId;
                bool1 = true;
              }
              Log.i("MicroMsg.SnsService", "fetchType:%s, preUpReady:%s, firstPage:%s", new Object[] { Integer.valueOf(localb.hdT()), Boolean.valueOf(this.QwL.QyC), Boolean.valueOf(bool1) });
              paramString = t.uB(ap.maxId);
              str = t.uB(ap.Qsh);
              if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
              for (boolean bool2 = true;; bool2 = false)
              {
                ((k.a)localObject).a(paramString, str, bool2, paramInt2, localb, bool1);
                break;
              }
            }
            if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
            for (bool1 = true;; bool1 = false)
            {
              ((k.a)localObject).b(paramString, bool1, paramInt2, localb);
              break;
            }
          }
        }
      }
    }
    label785:
    label795:
    AppMethodBeat.o(95907);
  }
  
  public final void uU(long paramLong)
  {
    AppMethodBeat.i(179094);
    Log.d("MicroMsg.SnsService", "setTimeFirstId %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong == 0L)
    {
      AppMethodBeat.o(179094);
      return;
    }
    this.QwH = paramLong;
    AppMethodBeat.o(179094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar.a
 * JD-Core Version:    0.7.0.1
 */