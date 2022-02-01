package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class an
{
  private static final int zla;
  
  static
  {
    AppMethodBeat.i(95919);
    zla = com.tencent.mm.n.g.acA().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(95919);
  }
  
  public static boolean dUH()
  {
    AppMethodBeat.i(95917);
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEk, Integer.valueOf(0))).intValue();
    ad.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(zla) });
    if (i < zla)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEk, Integer.valueOf(i + 1));
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(95917);
      return bool;
    }
  }
  
  public static void f(ArrayList<String> paramArrayList, String paramString)
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
      int i = bt.getInt((String)paramArrayList.next(), 0);
      if (i != 0)
      {
        Object localObject = ag.dUe().QP(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((p)localObject).dYl();
          if ((localTimeLineObject != null) && (localTimeLineObject.HAT != null) && (localTimeLineObject.HAT.GaP == 26))
          {
            localTimeLineObject.HAT.GaS = paramString;
            ag.dUe().b(i, (p)localObject);
            localObject = new rq();
            ((rq)localObject).dGm.dGn = i;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(95916);
  }
  
  public static boolean ga(Context paramContext)
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
      boolean bool2 = bt.lQ(com.tencent.d.f.e.bytesToHexString(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
      if (!bool2) {
        break label87;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
      }
    }
    AppMethodBeat.o(95918);
    return bool1;
  }
  
  public static final class a
    implements com.tencent.mm.al.f, com.tencent.mm.plugin.sns.b.i
  {
    public static int zlb = -1;
    private Map<i.a, String> hOz;
    private Map<String, Long> zlc;
    private Map<String, Integer> zld;
    private Map<String, Long> zle;
    private Map<String, Integer> zlf;
    private int zlg;
    public long zlh;
    public long zli;
    private LinkedList<String> zlj;
    public Map<String, ArrayList<com.tencent.mm.plugin.sns.i.b>> zlk;
    public Map<String, Integer> zll;
    private au zlm;
    
    public a()
    {
      AppMethodBeat.i(95895);
      this.zlc = new HashMap();
      this.zld = new HashMap();
      this.zle = new HashMap();
      this.zlf = new HashMap();
      this.zlg = 0;
      this.zlh = 0L;
      this.zli = 0L;
      this.hOz = new HashMap();
      this.zlj = new LinkedList();
      this.zlk = new HashMap();
      this.zll = new HashMap();
      this.zlm = new au();
      AppMethodBeat.o(95895);
    }
    
    public static dfn a(p paramp, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(95909);
      paramp = b(paramp, paramInt1, paramString, null, 0, paramInt2, "");
      AppMethodBeat.o(95909);
      return paramp;
    }
    
    public static dfn a(p paramp, int paramInt1, String paramString1, dfn paramdfn, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95910);
      paramp = b(paramp, paramInt1, paramString1, paramdfn, paramInt2, paramInt3, paramString2);
      AppMethodBeat.o(95910);
      return paramp;
    }
    
    public static dfn a(p paramp, int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(95912);
      dfh localdfh = new dfh();
      localdfh.hDa = paramString1;
      localdfh.CreateTime = ((int)(bt.flT() / 1000L));
      localdfh.HtE = u.aAo();
      localdfh.Hgt = u.aAm();
      localdfh.tRT = paramInt2;
      localdfh.HtF = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramp.field_userName);
      localdfh.GeH = paramp.field_userName;
      localdfh.nEf = paramInt1;
      dfi localdfi;
      String str;
      if (paramp.QM(32))
      {
        localdfh.HtI = 0L;
        paramString1 = new dfh();
        paramString1.Hgt = paramString2;
        if (!bt.isNullOrNil(paramString1.Hgt)) {
          paramString1.HtE = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramString1.Hgt);
        }
        localdfi = new dfi();
        localdfi.Id = paramp.field_snsId;
        localdfi.HtP = localdfh;
        localdfi.HtQ = paramString1;
        str = "";
        if (paramp.QM(32))
        {
          paramString1 = paramp.dRK();
          if (paramString1 != null) {
            break label382;
          }
          paramString2 = "";
          label208:
          if (paramString1 != null) {
            break label390;
          }
          paramString1 = "";
          label215:
          if (localdfh.nEf != 7) {
            break label398;
          }
          ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dYV(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramp.dYV()) });
          str = paramString1;
        }
        label273:
        paramString2 = com.tencent.mm.b.g.getMessageDigest(bt.HI().getBytes());
        paramString1 = paramString2;
        if (paramp.QM(32)) {
          paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
        }
        if (!ag.dUd().a(paramString1, localdfi, str)) {
          break label490;
        }
        if (!ae.ayT(paramString1)) {
          break label462;
        }
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new j(localdfi, paramString1, str, 0), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(95912);
        return null;
        localdfh.HtG = 0;
        break;
        label382:
        paramString2 = paramString1.aQj;
        break label208;
        label390:
        paramString1 = paramString1.dFy;
        break label215;
        label398:
        str = paramString1;
        if (localdfh.nEf != 8) {
          break label273;
        }
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dYV(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramp.dYV()) });
        str = paramString1;
        break label273;
        label462:
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new n(localdfi, paramString1), 0);
        continue;
        label490:
        ad.e("MicroMsg.SnsService", "can not add Comment");
      }
    }
    
    public static void a(String paramString1, int paramInt1, String paramString2, p paramp, int paramInt2)
    {
      AppMethodBeat.i(95913);
      if ((paramInt1 != 3) && (paramInt1 != 5))
      {
        AppMethodBeat.o(95913);
        return;
      }
      dfh localdfh = new dfh();
      localdfh.hDa = paramString2;
      localdfh.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
      localdfh.HtE = u.aAo();
      localdfh.Hgt = u.aAm();
      localdfh.tRT = paramInt2;
      localdfh.HtF = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramString1);
      localdfh.GeH = paramString1;
      localdfh.nEf = paramInt1;
      paramString2 = new dfi();
      paramString2.Id = paramp.field_snsId;
      paramString2.HtP = localdfh;
      paramString2.HtQ = new dfh();
      String str = com.tencent.mm.b.g.getMessageDigest(bt.HI().getBytes());
      long l = paramp.field_snsId;
      try
      {
        ad.v("MicroMsg.SnsService", "comment stg inserted");
        paramp = new com.tencent.mm.plugin.sns.storage.j();
        paramp.field_talker = paramString1;
        paramp.field_snsID = l;
        paramp.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
        paramp.field_curActionBuf = localdfh.toByteArray();
        paramp.field_type = paramInt1;
        paramp.field_isSend = true;
        paramp.field_isRead = 1;
        ag.dUj().insert(paramp);
        ag.dUd().a(str, paramString2);
        AppMethodBeat.o(95913);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SnsService", paramString1, "", new Object[0]);
        }
      }
    }
    
    public static void azb(String paramString)
    {
      AppMethodBeat.i(95908);
      Object localObject = ag.dUd();
      if (bt.isNullOrNil(((ae)localObject).fFK)) {
        ((ae)localObject).fFK = u.aAm();
      }
      localObject = ((ae)localObject).fFK;
      p localp = h.azZ(paramString);
      for (;;)
      {
        try
        {
          SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
          Iterator localIterator = localSnsObject.LikeUserList.iterator();
          if (localIterator.hasNext())
          {
            dfn localdfn = (dfn)localIterator.next();
            if (!localdfn.Username.equals(localObject)) {
              continue;
            }
            localSnsObject.LikeUserList.remove(localdfn);
            localSnsObject.LikeCount -= 1;
            localp.field_attrBuf = localSnsObject.toByteArray();
            if (!localp.QM(32)) {
              continue;
            }
            ag.dUh().replace(localp.dYU());
          }
        }
        catch (Exception localException)
        {
          continue;
          String str = localException.aQj;
          continue;
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new q(com.tencent.mm.plugin.sns.storage.x.axN(paramString), 5), 0);
          AppMethodBeat.o(95908);
        }
        if (!ag.dUd().zP(com.tencent.mm.plugin.sns.storage.x.axN(paramString))) {
          continue;
        }
        if (!localp.QM(32)) {
          continue;
        }
        localObject = localp.dRK();
        if (localObject != null) {
          continue;
        }
        localObject = "";
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, localp.dYV(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localp.dYV()) });
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new q(com.tencent.mm.plugin.sns.storage.x.axN(paramString), 7), 0);
        AppMethodBeat.o(95908);
        return;
        ag.dUe().M(localp);
      }
    }
    
    private static dfn b(p paramp, int paramInt1, String paramString1, dfn paramdfn, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95911);
      dfh localdfh = new dfh();
      localdfh.hDa = paramString1;
      localdfh.CreateTime = ((int)(bt.flT() / 1000L));
      localdfh.HtE = u.aAo();
      localdfh.Hgt = u.aAm();
      localdfh.tRT = 0;
      localdfh.HtF = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramp.field_userName);
      localdfh.GeH = paramp.field_userName;
      localdfh.nEf = paramInt1;
      localdfh.HtL = paramInt2;
      long l;
      label189:
      dfi localdfi;
      int i;
      if (paramp.QM(32)) {
        if (paramdfn == null)
        {
          l = 0L;
          localdfh.HtI = l;
          if (!bt.isNullOrNil(paramString2))
          {
            paramString1 = new dft();
            paramString1.Md5 = paramString2;
            localdfh.HtM = new LinkedList();
            localdfh.HtM.add(paramString1);
            localdfh.HtN = 1;
          }
          paramString2 = new dfh();
          if (paramdfn != null) {
            break label686;
          }
          paramString1 = "";
          paramString2.Hgt = paramString1;
          if (!bt.isNullOrNil(paramString2.Hgt)) {
            paramString2.HtE = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramString2.Hgt);
          }
          localdfi = new dfi();
          localdfi.Id = paramp.field_snsId;
          localdfi.HtP = localdfh;
          localdfi.HtQ = paramString2;
          paramString1 = "";
          i = 0;
          if (paramp.QM(32))
          {
            ad.i("MicroMsg.SnsService", "sendComment, sourceScene=" + paramInt3 + ", type=" + paramInt1 + ", flag=" + paramInt2);
            if (paramInt3 != 2) {
              break label694;
            }
            paramString1 = paramp.dYi();
            paramInt1 = 1;
            label334:
            if (paramString1 != null) {
              break label704;
            }
            paramdfn = "";
            label341:
            if (paramString1 != null) {
              break label712;
            }
            paramString1 = "";
            label348:
            if (localdfh.nEf != 7) {
              break label720;
            }
            ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dYV(), new Object[] { Integer.valueOf(1), paramdfn, Integer.valueOf(paramp.dYV()) });
            label403:
            paramdfn = paramp.dYU();
            if (paramdfn == null) {
              break label1091;
            }
            if (paramdfn.field_firstControlTime == 0)
            {
              paramdfn.field_firstControlTime = localdfh.CreateTime;
              ag.dUh().b(paramdfn.field_snsId, paramdfn);
            }
            paramdfn = paramdfn.dYm();
            if (paramInt3 != 2) {
              break label829;
            }
            if (paramdfn == null) {
              break label804;
            }
            localdfi.HtP.FvG = paramdfn.FuB;
            if (paramdfn.FuB == null) {
              break label778;
            }
            ad.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdfn.FuB.Hlz), Integer.valueOf(paramdfn.FuB.Hlu) });
            if ((paramdfn.FuB.Hlz != 0L) || (paramdfn.FuB.Hlu != 0)) {
              break label1091;
            }
            com.tencent.mm.plugin.report.service.g.yhR.dD(955, 9);
            i = paramInt1;
          }
          label549:
          paramString2 = com.tencent.mm.b.g.getMessageDigest(bt.HI().getBytes());
          paramdfn = paramString2;
          if (paramp.QM(32)) {
            paramdfn = "_AD_TAG_".concat(String.valueOf(paramString2));
          }
          if (!ag.dUd().a(paramdfn, localdfi)) {
            break label1125;
          }
          if (!ae.ayT(paramdfn)) {
            break label1097;
          }
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new j(localdfi, paramdfn, paramString1, i), 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(95911);
        return null;
        l = paramdfn.HtJ;
        break;
        if (paramdfn == null) {}
        for (i = 0;; i = paramdfn.HtH)
        {
          localdfh.HtG = i;
          break;
        }
        label686:
        paramString1 = paramdfn.Username;
        break label189;
        label694:
        paramString1 = paramp.dRK();
        paramInt1 = 0;
        break label334;
        label704:
        paramdfn = paramString1.aQj;
        break label341;
        label712:
        paramString1 = paramString1.dFy;
        break label348;
        label720:
        if (localdfh.nEf != 8) {
          break label403;
        }
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dYV(), new Object[] { Integer.valueOf(2), paramdfn, Integer.valueOf(paramp.dYV()) });
        break label403;
        label778:
        com.tencent.mm.plugin.report.service.g.yhR.dD(955, 7);
        ad.i("MicroMsg.SnsService", "remindInfo is null!");
        i = paramInt1;
        break label549;
        label804:
        ad.i("MicroMsg.SnsService", "remindInfo group is null!");
        com.tencent.mm.plugin.report.service.g.yhR.dD(955, 5);
        i = paramInt1;
        break label549;
        label829:
        if (com.tencent.mm.plugin.sns.ui.widget.e.ia(paramInt2, 8))
        {
          ad.i("MicroMsg.SnsService", "sendAtFriend");
          if (paramdfn != null)
          {
            if (paramdfn.FuA != null)
            {
              localdfi.HtP.FvG = paramdfn.FuA;
              ad.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdfn.FuA.Hlz), Integer.valueOf(paramdfn.FuA.Hlu) });
              if ((paramdfn.FuA.Hlz != 0L) || (paramdfn.FuA.Hlu != 0)) {
                break label1091;
              }
              com.tencent.mm.plugin.report.service.g.yhR.dD(955, 8);
              i = paramInt1;
              break label549;
            }
            if (paramdfn.FuB != null)
            {
              localdfi.HtP.FvG = paramdfn.FuB;
              ad.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdfn.FuB.Hlz), Integer.valueOf(paramdfn.FuB.Hlu) });
              if ((paramdfn.FuB.Hlz != 0L) || (paramdfn.FuB.Hlu != 0)) {
                break label1091;
              }
              com.tencent.mm.plugin.report.service.g.yhR.dD(955, 8);
              i = paramInt1;
              break label549;
            }
            com.tencent.mm.plugin.report.service.g.yhR.dD(955, 6);
            ad.i("MicroMsg.SnsService", "remindInfo is null!");
            i = paramInt1;
            break label549;
          }
          ad.i("MicroMsg.SnsService", "remindInfo group is null!");
          com.tencent.mm.plugin.report.service.g.yhR.dD(955, 5);
        }
        label1091:
        i = paramInt1;
        break label549;
        label1097:
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new n(localdfi, paramdfn), 0);
        continue;
        label1125:
        ad.e("MicroMsg.SnsService", "can not add Comment");
      }
    }
    
    public static int dUJ()
    {
      AppMethodBeat.i(95906);
      if (zlb != -1)
      {
        i = zlb;
        AppMethodBeat.o(95906);
        return i;
      }
      zlb = com.tencent.mm.plugin.sns.data.q.dSM();
      ad.i("MicroMsg.SnsService", "getTimelineControlFlag %d", new Object[] { Integer.valueOf(zlb) });
      int i = zlb;
      AppMethodBeat.o(95906);
      return i;
    }
    
    public final void V(long paramLong, int paramInt)
    {
      AppMethodBeat.i(95905);
      ad.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramInt > 0)
      {
        this.zlg = paramInt;
        com.tencent.mm.plugin.sns.data.q.PK(paramInt);
      }
      if (paramLong == 0L)
      {
        AppMethodBeat.o(95905);
        return;
      }
      this.zlh = paramLong;
      AppMethodBeat.o(95905);
    }
    
    public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
    {
      AppMethodBeat.i(95902);
      ad.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (paramInt1 == 2)
      {
        if (!z.ayQ(paramString))
        {
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == au.zmL)
        {
          this.zlm.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == au.zmM)
        {
          au.b(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == au.zmN)
        {
          au.f(paramString, paramBoolean, paramInt3);
          AppMethodBeat.o(95902);
        }
      }
      else if (paramInt1 == 1)
      {
        if (!x.ayN("@__weixintimtline"))
        {
          AppMethodBeat.o(95902);
          return;
        }
        ag.dUn().zmm = paramInt2;
        if (paramInt2 == au.zmL)
        {
          this.zlm.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == au.zmM)
        {
          ag.dUn().zmp = true;
          au.b(paramString, paramBoolean, paramInt3, this.zli, paramInt1);
        }
      }
      AppMethodBeat.o(95902);
    }
    
    public final void a(int paramInt, String paramString, i.a arg3)
    {
      AppMethodBeat.i(95898);
      ad.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
      ag.dUd().fFK = u.aAm();
      ag.dUd().dTE();
      ag.dUa().dSE();
      if (this.hOz.isEmpty())
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(211, this);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(212, this);
      }
      if (!this.hOz.containsKey(???))
      {
        if (paramInt == 1) {
          this.hOz.put(???, "@__weixintimtline");
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
          this.hOz.put(???, paramString);
          break;
        }
        if (paramInt == 4)
        {
          this.hOz.put(???, "@__classify_timeline");
          break;
        }
        if (paramInt == 5)
        {
          this.hOz.put(???, "");
          break;
        }
        this.hOz.put(???, "");
        break;
        synchronized (this.zlc)
        {
          this.zlc.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.zld)
        {
          if (!this.zld.containsKey(paramString)) {
            this.zld.put(paramString, Integer.valueOf(dUI()));
          }
          z.ayR(paramString);
          this.zlj.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        synchronized (this.zle)
        {
          this.zle.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.zlf)
        {
          if (!this.zlf.containsKey(paramString)) {
            this.zlf.put(paramString, Integer.valueOf(dUI()));
          }
          z.ayR(paramString);
          this.zlj.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        this.zlh = 0L;
        this.zlg = dUI();
        x.ayO("@__weixintimtline");
      }
    }
    
    public final void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95901);
      if (ac.iOu)
      {
        AppMethodBeat.o(95901);
        return;
      }
      ad.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
      if (paramInt1 == 2)
      {
        if (!z.ayQ(paramString))
        {
          AppMethodBeat.o(95901);
          return;
        }
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.ajB().gAO;
        int j = au.zmK;
        if (paramBoolean) {}
        for (int i = 4;; i = 8)
        {
          localq.a(new z(paramString, 0L, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
          AppMethodBeat.o(95901);
          return;
        }
      }
      if (paramInt1 == 1)
      {
        if (!x.ayN("@__weixintimtline"))
        {
          AppMethodBeat.o(95901);
          return;
        }
        ag.dUn().zmm = au.zmN;
        ag.dUn().zmt = ag.dUe().g(0L, 1, true);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(68377, "");
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new x(0L, 0L, 0), 0);
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!m.ayN("@__classify_timeline"))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new m(""), 0);
          AppMethodBeat.o(95901);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!z.ayQ(paramString))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new z(paramString, 0L, paramBoolean, paramInt2, au.zmK, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95901);
    }
    
    public final boolean a(i.a parama, int paramInt)
    {
      AppMethodBeat.i(95899);
      ad.d("MicroMsg.SnsService", "closeServer");
      this.hOz.remove(parama);
      if (((paramInt == 2) || (paramInt == 10)) && (this.zlj.size() > 0)) {
        this.zlj.removeLast();
      }
      if (this.hOz.isEmpty())
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.b(211, this);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.b(212, this);
        ao.release();
        p.release();
        new ap(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95894);
            an.a.a(an.a.this);
            AppMethodBeat.o(95894);
          }
        }, 5000L);
        ak.dUA();
        ad.i("MicroMsg.SnsService", "close finish");
      }
      AppMethodBeat.o(95899);
      return true;
    }
    
    public final void axK(String paramString)
    {
      AppMethodBeat.i(95914);
      String str1 = ag.getAccSnsPath();
      String str2 = paramString + "bg_";
      String str3 = paramString + "tbg_";
      if (com.tencent.mm.vfs.i.fv(str2))
      {
        com.tencent.mm.vfs.i.deleteFile(ao.jo(str1, paramString) + str3);
        com.tencent.mm.vfs.i.bb(ao.jo(str1, paramString), str2, str3);
      }
      AppMethodBeat.o(95914);
    }
    
    public final int aza(String paramString)
    {
      AppMethodBeat.i(95903);
      synchronized (this.zld)
      {
        if (this.zld.containsKey(paramString))
        {
          i = ((Integer)this.zld.get(paramString)).intValue();
          if (i > 0) {}
          for (;;)
          {
            AppMethodBeat.o(95903);
            return i;
            i = com.tencent.mm.plugin.sns.data.q.dSN();
          }
        }
        int i = com.tencent.mm.plugin.sns.data.q.dSN();
        AppMethodBeat.o(95903);
        return i;
      }
    }
    
    public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95900);
      if (ac.iOu)
      {
        AppMethodBeat.o(95900);
        return;
      }
      synchronized (this.zlc)
      {
        ad.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.zlh), this.zlc });
        if (paramInt1 != 2) {
          break label244;
        }
        if (!z.ayQ(paramString))
        {
          AppMethodBeat.o(95900);
          return;
        }
      }
      long l = 0L;
      synchronized (this.zlc)
      {
        if (this.zlc.containsKey(paramString)) {
          l = ((Long)this.zlc.get(paramString)).longValue();
        }
        if (l == 0L)
        {
          z.ayR(paramString);
          AppMethodBeat.o(95900);
          return;
        }
      }
      com.tencent.mm.kernel.g.ajD();
      ??? = com.tencent.mm.kernel.g.ajB().gAO;
      int j = au.zmK;
      if (paramBoolean) {}
      for (int i = 4;; i = 8)
      {
        ((com.tencent.mm.al.q)???).a(new z(paramString, l, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
        AppMethodBeat.o(95900);
        return;
      }
      label244:
      if (paramInt1 == 1)
      {
        if (!x.ayN("@__weixintimtline"))
        {
          AppMethodBeat.o(95900);
          return;
        }
        if (this.zlh == 0L)
        {
          x.ayO("@__weixintimtline");
          AppMethodBeat.o(95900);
          return;
        }
        ag.dUn().zmm = au.zmN;
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new x(this.zlh, 0L, 0), 0);
        AppMethodBeat.o(95900);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!m.ayN("@__classify_timeline"))
          {
            AppMethodBeat.o(95900);
            return;
          }
          if (this.zlh == 0L)
          {
            m.ayO("@__classify_timeline");
            AppMethodBeat.o(95900);
            return;
          }
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new m(""), 0);
          AppMethodBeat.o(95900);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!z.ayQ(paramString))
          {
            AppMethodBeat.o(95900);
            return;
          }
          l = 0L;
          synchronized (this.zle)
          {
            if (this.zle.containsKey(paramString)) {
              l = ((Long)this.zle.get(paramString)).longValue();
            }
            if (l == 0L)
            {
              z.ayR(paramString);
              AppMethodBeat.o(95900);
              return;
            }
          }
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new z(paramString, l, paramBoolean, paramInt2, au.zmK, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95900);
    }
    
    public final int dUI()
    {
      AppMethodBeat.i(95904);
      if (this.zlg > 0)
      {
        i = this.zlg;
        AppMethodBeat.o(95904);
        return i;
      }
      int i = com.tencent.mm.plugin.sns.data.q.dSN();
      AppMethodBeat.o(95904);
      return i;
    }
    
    public final Intent f(Intent paramIntent, String paramString)
    {
      AppMethodBeat.i(95897);
      paramIntent.putExtra("sns_userName", paramString);
      if ((this.zlj != null) && (this.zlj.contains(paramString)))
      {
        paramIntent.addFlags(536870912);
        paramIntent.addFlags(67108864);
        AppMethodBeat.o(95897);
        return paramIntent;
      }
      AppMethodBeat.o(95897);
      return paramIntent;
    }
    
    public final void i(String paramString, ArrayList<com.tencent.mm.plugin.sns.i.b> paramArrayList)
    {
      AppMethodBeat.i(95896);
      this.zlk.put(paramString, paramArrayList);
      AppMethodBeat.o(95896);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(95907);
      ad.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
      if ((paramn != null) && ((paramn instanceof x)) && (((x)paramn).dTB())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ad.i("MicroMsg.SnsService", "skip by preload unread feeds");
        AppMethodBeat.o(95907);
        return;
      }
      label437:
      label566:
      label974:
      label980:
      if ((paramn.getType() == 212) || (paramn.getType() == 211))
      {
        com.tencent.mm.plugin.sns.b.b localb = (com.tencent.mm.plugin.sns.b.b)paramn;
        paramString = new ArrayList(this.hOz.keySet());
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
          paramn = (i.a)paramString.next();
          if (this.hOz.containsKey(paramn))
          {
            ??? = (String)this.hOz.get(paramn);
            if ((localb.getUserName().equals(???)) && (localb.dSo()))
            {
              ??? = com.tencent.mm.plugin.sns.data.q.zx(ak.zhi);
              str = com.tencent.mm.plugin.sns.data.q.zx(ak.zhj);
              if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
              for (bool = true;; bool = false)
              {
                paramn.a((String)???, str, bool, paramInt2, localb);
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
        switch (paramn.getType())
        {
        default: 
          paramn = paramString.iterator();
        }
        label470:
        while (paramn.hasNext())
        {
          ??? = (i.a)paramn.next();
          if (this.hOz.containsKey(???))
          {
            paramString = (String)this.hOz.get(???);
            if (localb.getUserName().equals(paramString))
            {
              ad.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
              if (localb.dSu() == 0L)
              {
                paramString = "";
                if (!localb.dSn()) {
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
                    ??? = (z)paramn;
                    paramn = ((z)???).userName;
                    l = ((z)???).zhj;
                    i = ((z)???).zhl;
                    if (((z)???).ziD == 10)
                    {
                      if (i > 0) {}
                      synchronized (this.zlf)
                      {
                        for (;;)
                        {
                          this.zlf.put(paramn, Integer.valueOf(i));
                          if (l == 0L) {
                            break;
                          }
                          synchronized (this.zle)
                          {
                            this.zle.put(paramn, Long.valueOf(l));
                          }
                        }
                      }
                    }
                  }
                  if (i > 0) {}
                  synchronized (this.zld)
                  {
                    for (;;)
                    {
                      this.zld.put(paramn, Integer.valueOf(i));
                      if (l == 0L) {
                        break;
                      }
                      synchronized (this.zlc)
                      {
                        this.zlc.put(paramn, Long.valueOf(l));
                      }
                    }
                  }
                }
                paramn = (x)paramn;
                if (localb.dSo()) {
                  zR(paramn.zhi);
                }
                for (;;)
                {
                  i = paramn.zhm;
                  if (zlb != i) {
                    com.tencent.mm.plugin.sns.data.q.PJ(i);
                  }
                  ad.i("MicroMsg.SnsService", "updateTimelineControlFlag %d", new Object[] { Integer.valueOf(i) });
                  zlb = i;
                  break;
                  V(paramn.zhj, paramn.zhl);
                }
                paramString = com.tencent.mm.plugin.sns.data.q.zx(localb.dSu());
                break label566;
              }
              if (localb.dSo())
              {
                bool = false;
                if (localb.dSp() == au.zmL)
                {
                  ak.zkS = ak.zhi;
                  bool = true;
                }
                ad.i("MicroMsg.SnsService", "fetchType:%s, preUpReady:%s, firstPage:%s", new Object[] { Integer.valueOf(localb.dSp()), Boolean.valueOf(this.zlm.zmO), Boolean.valueOf(bool) });
                paramString = com.tencent.mm.plugin.sns.data.q.zx(ak.zhi);
                str = com.tencent.mm.plugin.sns.data.q.zx(ak.zhj);
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
    
    public final void zR(long paramLong)
    {
      AppMethodBeat.i(179094);
      ad.d("MicroMsg.SnsService", "setTimeFirstId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong == 0L)
      {
        AppMethodBeat.o(179094);
        return;
      }
      this.zli = paramLong;
      AppMethodBeat.o(179094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an
 * JD-Core Version:    0.7.0.1
 */