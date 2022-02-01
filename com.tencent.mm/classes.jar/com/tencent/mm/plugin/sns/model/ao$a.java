package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ao$a
  implements com.tencent.mm.ak.f, i
{
  public static int zCq = -1;
  private Map<i.a, String> hRs;
  public Map<String, Integer> zCA;
  private av zCB;
  private Map<String, Long> zCr;
  private Map<String, Integer> zCs;
  private Map<String, Long> zCt;
  private Map<String, Integer> zCu;
  private int zCv;
  public long zCw;
  public long zCx;
  private LinkedList<String> zCy;
  public Map<String, ArrayList<com.tencent.mm.plugin.sns.i.b>> zCz;
  
  public ao$a()
  {
    AppMethodBeat.i(95895);
    this.zCr = new HashMap();
    this.zCs = new HashMap();
    this.zCt = new HashMap();
    this.zCu = new HashMap();
    this.zCv = 0;
    this.zCw = 0L;
    this.zCx = 0L;
    this.hRs = new HashMap();
    this.zCy = new LinkedList();
    this.zCz = new HashMap();
    this.zCA = new HashMap();
    this.zCB = new av();
    AppMethodBeat.o(95895);
  }
  
  public static dgh a(p paramp, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(95909);
    paramp = b(paramp, paramInt1, paramString, null, 0, paramInt2, "");
    AppMethodBeat.o(95909);
    return paramp;
  }
  
  public static dgh a(p paramp, int paramInt1, String paramString1, dgh paramdgh, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(95910);
    paramp = b(paramp, paramInt1, paramString1, paramdgh, paramInt2, paramInt3, paramString2);
    AppMethodBeat.o(95910);
    return paramp;
  }
  
  public static dgh a(p paramp, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(95912);
    dgb localdgb = new dgb();
    localdgb.hFS = paramString1;
    localdgb.CreateTime = ((int)(bu.fpO() / 1000L));
    localdgb.HNh = v.aAE();
    localdgb.HzT = v.aAC();
    localdgb.ucK = paramInt2;
    localdgb.HNi = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramp.field_userName);
    localdgb.Gxp = paramp.field_userName;
    localdgb.nJA = paramInt1;
    dgc localdgc;
    String str;
    if (paramp.Rt(32))
    {
      localdgb.HNl = 0L;
      paramString1 = new dgb();
      paramString1.HzT = paramString2;
      if (!bu.isNullOrNil(paramString1.HzT)) {
        paramString1.HNh = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramString1.HzT);
      }
      localdgc = new dgc();
      localdgc.Id = paramp.field_snsId;
      localdgc.HNs = localdgb;
      localdgc.HNt = paramString1;
      str = "";
      if (paramp.Rt(32))
      {
        paramString1 = paramp.dVi();
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
        if (localdgb.nJA != 7) {
          break label398;
        }
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.ecz(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramp.ecz()) });
        str = paramString1;
      }
      label273:
      paramString2 = com.tencent.mm.b.g.getMessageDigest(bu.HQ().getBytes());
      paramString1 = paramString2;
      if (paramp.Rt(32)) {
        paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
      }
      if (!ah.dXD().a(paramString1, localdgc, str)) {
        break label490;
      }
      if (!af.aAk(paramString1)) {
        break label462;
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new k(localdgc, paramString1, str, 0), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(95912);
      return null;
      localdgb.HNj = 0;
      break;
      label382:
      paramString2 = paramString1.aQj;
      break label208;
      label390:
      paramString1 = paramString1.dGD;
      break label215;
      label398:
      str = paramString1;
      if (localdgb.nJA != 8) {
        break label273;
      }
      ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.ecz(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramp.ecz()) });
      str = paramString1;
      break label273;
      label462:
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new o(localdgc, paramString1), 0);
      continue;
      label490:
      ae.e("MicroMsg.SnsService", "can not add Comment");
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
    dgb localdgb = new dgb();
    localdgb.hFS = paramString2;
    localdgb.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    localdgb.HNh = v.aAE();
    localdgb.HzT = v.aAC();
    localdgb.ucK = paramInt2;
    localdgb.HNi = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramString1);
    localdgb.Gxp = paramString1;
    localdgb.nJA = paramInt1;
    paramString2 = new dgc();
    paramString2.Id = paramp.field_snsId;
    paramString2.HNs = localdgb;
    paramString2.HNt = new dgb();
    String str = com.tencent.mm.b.g.getMessageDigest(bu.HQ().getBytes());
    long l = paramp.field_snsId;
    try
    {
      ae.v("MicroMsg.SnsService", "comment stg inserted");
      paramp = new j();
      paramp.field_talker = paramString1;
      paramp.field_snsID = l;
      paramp.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
      paramp.field_curActionBuf = localdgb.toByteArray();
      paramp.field_type = paramInt1;
      paramp.field_isSend = true;
      paramp.field_isRead = 1;
      ah.dXJ().insert(paramp);
      ah.dXD().a(str, paramString2);
      AppMethodBeat.o(95913);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SnsService", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static void aAs(String paramString)
  {
    AppMethodBeat.i(95908);
    Object localObject = ah.dXD();
    if (bu.isNullOrNil(((af)localObject).fHO)) {
      ((af)localObject).fHO = v.aAC();
    }
    localObject = ((af)localObject).fHO;
    p localp = h.aBq(paramString);
    for (;;)
    {
      try
      {
        SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
        Iterator localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          dgh localdgh = (dgh)localIterator.next();
          if (!localdgh.Username.equals(localObject)) {
            continue;
          }
          localSnsObject.LikeUserList.remove(localdgh);
          localSnsObject.LikeCount -= 1;
          localp.field_attrBuf = localSnsObject.toByteArray();
          if (!localp.Rt(32)) {
            continue;
          }
          ah.dXH().replace(localp.ecy());
        }
      }
      catch (Exception localException)
      {
        continue;
        String str = localException.aQj;
        continue;
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new r(x.aze(paramString), 5), 0);
        AppMethodBeat.o(95908);
      }
      if (!ah.dXD().An(x.aze(paramString))) {
        continue;
      }
      if (!localp.Rt(32)) {
        continue;
      }
      localObject = localp.dVi();
      if (localObject != null) {
        continue;
      }
      localObject = "";
      ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, localp.ecz(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localp.ecz()) });
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new r(x.aze(paramString), 7), 0);
      AppMethodBeat.o(95908);
      return;
      ah.dXE().M(localp);
    }
  }
  
  private static dgh b(p paramp, int paramInt1, String paramString1, dgh paramdgh, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(95911);
    dgb localdgb = new dgb();
    localdgb.hFS = paramString1;
    localdgb.CreateTime = ((int)(bu.fpO() / 1000L));
    localdgb.HNh = v.aAE();
    localdgb.HzT = v.aAC();
    localdgb.ucK = 0;
    localdgb.HNi = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramp.field_userName);
    localdgb.Gxp = paramp.field_userName;
    localdgb.nJA = paramInt1;
    localdgb.HNo = paramInt2;
    long l;
    label189:
    dgc localdgc;
    int i;
    if (paramp.Rt(32)) {
      if (paramdgh == null)
      {
        l = 0L;
        localdgb.HNl = l;
        if (!bu.isNullOrNil(paramString2))
        {
          paramString1 = new dgn();
          paramString1.Md5 = paramString2;
          localdgb.HNp = new LinkedList();
          localdgb.HNp.add(paramString1);
          localdgb.HNq = 1;
        }
        paramString2 = new dgb();
        if (paramdgh != null) {
          break label686;
        }
        paramString1 = "";
        paramString2.HzT = paramString1;
        if (!bu.isNullOrNil(paramString2.HzT)) {
          paramString2.HNh = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramString2.HzT);
        }
        localdgc = new dgc();
        localdgc.Id = paramp.field_snsId;
        localdgc.HNs = localdgb;
        localdgc.HNt = paramString2;
        paramString1 = "";
        i = 0;
        if (paramp.Rt(32))
        {
          ae.i("MicroMsg.SnsService", "sendComment, sourceScene=" + paramInt3 + ", type=" + paramInt1 + ", flag=" + paramInt2);
          if (paramInt3 != 2) {
            break label694;
          }
          paramString1 = paramp.ebM();
          paramInt1 = 1;
          label334:
          if (paramString1 != null) {
            break label704;
          }
          paramdgh = "";
          label341:
          if (paramString1 != null) {
            break label712;
          }
          paramString1 = "";
          label348:
          if (localdgb.nJA != 7) {
            break label720;
          }
          ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.ecz(), new Object[] { Integer.valueOf(1), paramdgh, Integer.valueOf(paramp.ecz()) });
          label403:
          paramdgh = paramp.ecy();
          if (paramdgh == null) {
            break label1091;
          }
          if (paramdgh.field_firstControlTime == 0)
          {
            paramdgh.field_firstControlTime = localdgb.CreateTime;
            ah.dXH().b(paramdgh.field_snsId, paramdgh);
          }
          paramdgh = paramdgh.ebQ();
          if (paramInt3 != 2) {
            break label829;
          }
          if (paramdgh == null) {
            break label804;
          }
          localdgc.HNs.FOe = paramdgh.FMZ;
          if (paramdgh.FMZ == null) {
            break label778;
          }
          ae.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdgh.FMZ.HEZ), Integer.valueOf(paramdgh.FMZ.HEU) });
          if ((paramdgh.FMZ.HEZ != 0L) || (paramdgh.FMZ.HEU != 0)) {
            break label1091;
          }
          com.tencent.mm.plugin.report.service.g.yxI.dD(955, 9);
          i = paramInt1;
        }
        label549:
        paramString2 = com.tencent.mm.b.g.getMessageDigest(bu.HQ().getBytes());
        paramdgh = paramString2;
        if (paramp.Rt(32)) {
          paramdgh = "_AD_TAG_".concat(String.valueOf(paramString2));
        }
        if (!ah.dXD().a(paramdgh, localdgc)) {
          break label1125;
        }
        if (!af.aAk(paramdgh)) {
          break label1097;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new k(localdgc, paramdgh, paramString1, i), 0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95911);
      return null;
      l = paramdgh.HNm;
      break;
      if (paramdgh == null) {}
      for (i = 0;; i = paramdgh.HNk)
      {
        localdgb.HNj = i;
        break;
      }
      label686:
      paramString1 = paramdgh.Username;
      break label189;
      label694:
      paramString1 = paramp.dVi();
      paramInt1 = 0;
      break label334;
      label704:
      paramdgh = paramString1.aQj;
      break label341;
      label712:
      paramString1 = paramString1.dGD;
      break label348;
      label720:
      if (localdgb.nJA != 8) {
        break label403;
      }
      ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.ecz(), new Object[] { Integer.valueOf(2), paramdgh, Integer.valueOf(paramp.ecz()) });
      break label403;
      label778:
      com.tencent.mm.plugin.report.service.g.yxI.dD(955, 7);
      ae.i("MicroMsg.SnsService", "remindInfo is null!");
      i = paramInt1;
      break label549;
      label804:
      ae.i("MicroMsg.SnsService", "remindInfo group is null!");
      com.tencent.mm.plugin.report.service.g.yxI.dD(955, 5);
      i = paramInt1;
      break label549;
      label829:
      if (com.tencent.mm.plugin.sns.ui.widget.e.id(paramInt2, 8))
      {
        ae.i("MicroMsg.SnsService", "sendAtFriend");
        if (paramdgh != null)
        {
          if (paramdgh.FMY != null)
          {
            localdgc.HNs.FOe = paramdgh.FMY;
            ae.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdgh.FMY.HEZ), Integer.valueOf(paramdgh.FMY.HEU) });
            if ((paramdgh.FMY.HEZ != 0L) || (paramdgh.FMY.HEU != 0)) {
              break label1091;
            }
            com.tencent.mm.plugin.report.service.g.yxI.dD(955, 8);
            i = paramInt1;
            break label549;
          }
          if (paramdgh.FMZ != null)
          {
            localdgc.HNs.FOe = paramdgh.FMZ;
            ae.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdgh.FMZ.HEZ), Integer.valueOf(paramdgh.FMZ.HEU) });
            if ((paramdgh.FMZ.HEZ != 0L) || (paramdgh.FMZ.HEU != 0)) {
              break label1091;
            }
            com.tencent.mm.plugin.report.service.g.yxI.dD(955, 8);
            i = paramInt1;
            break label549;
          }
          com.tencent.mm.plugin.report.service.g.yxI.dD(955, 6);
          ae.i("MicroMsg.SnsService", "remindInfo is null!");
          i = paramInt1;
          break label549;
        }
        ae.i("MicroMsg.SnsService", "remindInfo group is null!");
        com.tencent.mm.plugin.report.service.g.yxI.dD(955, 5);
      }
      label1091:
      i = paramInt1;
      break label549;
      label1097:
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new o(localdgc, paramdgh), 0);
      continue;
      label1125:
      ae.e("MicroMsg.SnsService", "can not add Comment");
    }
  }
  
  public static int dYj()
  {
    AppMethodBeat.i(95906);
    if (zCq != -1)
    {
      i = zCq;
      AppMethodBeat.o(95906);
      return i;
    }
    zCq = com.tencent.mm.plugin.sns.data.r.dWm();
    ae.i("MicroMsg.SnsService", "getTimelineControlFlag %d", new Object[] { Integer.valueOf(zCq) });
    int i = zCq;
    AppMethodBeat.o(95906);
    return i;
  }
  
  public final void Ap(long paramLong)
  {
    AppMethodBeat.i(179094);
    ae.d("MicroMsg.SnsService", "setTimeFirstId %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong == 0L)
    {
      AppMethodBeat.o(179094);
      return;
    }
    this.zCx = paramLong;
    AppMethodBeat.o(179094);
  }
  
  public final void V(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95905);
    ae.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
    if (paramInt > 0)
    {
      this.zCv = paramInt;
      com.tencent.mm.plugin.sns.data.r.Qr(paramInt);
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(95905);
      return;
    }
    this.zCw = paramLong;
    AppMethodBeat.o(95905);
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(95902);
    ae.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (paramInt1 == 2)
    {
      if (!aa.aAh(paramString))
      {
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == av.zEa)
      {
        this.zCB.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == av.zEb)
      {
        av.b(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == av.zEc)
      {
        av.f(paramString, paramBoolean, paramInt3);
        AppMethodBeat.o(95902);
      }
    }
    else if (paramInt1 == 1)
    {
      if (!y.aAe("@__weixintimtline"))
      {
        AppMethodBeat.o(95902);
        return;
      }
      ah.dXN().zDB = paramInt2;
      if (paramInt2 == av.zEa)
      {
        this.zCB.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
        AppMethodBeat.o(95902);
        return;
      }
      if (paramInt2 == av.zEb)
      {
        ah.dXN().zDE = true;
        av.b(paramString, paramBoolean, paramInt3, this.zCx, paramInt1);
      }
    }
    AppMethodBeat.o(95902);
  }
  
  public final void a(int paramInt, String paramString, i.a arg3)
  {
    AppMethodBeat.i(95898);
    ae.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
    ah.dXD().fHO = v.aAC();
    ah.dXD().dXe();
    ah.dXA().dWc();
    if (this.hRs.isEmpty())
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(211, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(212, this);
    }
    if (!this.hRs.containsKey(???))
    {
      if (paramInt == 1) {
        this.hRs.put(???, "@__weixintimtline");
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
        this.hRs.put(???, paramString);
        break;
      }
      if (paramInt == 4)
      {
        this.hRs.put(???, "@__classify_timeline");
        break;
      }
      if (paramInt == 5)
      {
        this.hRs.put(???, "");
        break;
      }
      this.hRs.put(???, "");
      break;
      synchronized (this.zCr)
      {
        this.zCr.put(paramString, Long.valueOf(0L));
      }
      synchronized (this.zCs)
      {
        if (!this.zCs.containsKey(paramString)) {
          this.zCs.put(paramString, Integer.valueOf(dYi()));
        }
        aa.aAi(paramString);
        this.zCy.add(paramString);
        AppMethodBeat.o(95898);
        return;
        paramString = finally;
        AppMethodBeat.o(95898);
        throw paramString;
      }
      synchronized (this.zCt)
      {
        this.zCt.put(paramString, Long.valueOf(0L));
      }
      synchronized (this.zCu)
      {
        if (!this.zCu.containsKey(paramString)) {
          this.zCu.put(paramString, Integer.valueOf(dYi()));
        }
        aa.aAi(paramString);
        this.zCy.add(paramString);
        AppMethodBeat.o(95898);
        return;
        paramString = finally;
        AppMethodBeat.o(95898);
        throw paramString;
      }
      this.zCw = 0L;
      this.zCv = dYi();
      y.aAf("@__weixintimtline");
    }
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(95901);
    if (ac.iRo)
    {
      AppMethodBeat.o(95901);
      return;
    }
    ae.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (paramInt1 == 2)
    {
      if (!aa.aAh(paramString))
      {
        AppMethodBeat.o(95901);
        return;
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.ajQ().gDv;
      int j = av.zDZ;
      if (paramBoolean) {}
      for (int i = 4;; i = 8)
      {
        localq.a(new aa(paramString, 0L, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
        AppMethodBeat.o(95901);
        return;
      }
    }
    if (paramInt1 == 1)
    {
      if (!y.aAe("@__weixintimtline"))
      {
        AppMethodBeat.o(95901);
        return;
      }
      ah.dXN().zDB = av.zEc;
      ah.dXN().zDI = ah.dXE().g(0L, 1, true);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(68377, "");
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new y(0L, 0L, 0), 0);
      AppMethodBeat.o(95901);
      return;
    }
    if (paramInt1 != 3)
    {
      if (paramInt1 == 4)
      {
        if (!n.aAe("@__classify_timeline"))
        {
          AppMethodBeat.o(95901);
          return;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new n(""), 0);
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 == 10)
      {
        if (!aa.aAh(paramString))
        {
          AppMethodBeat.o(95901);
          return;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new aa(paramString, 0L, paramBoolean, paramInt2, av.zDZ, 1, 64, paramInt1), 0);
      }
    }
    AppMethodBeat.o(95901);
  }
  
  public final boolean a(i.a parama, int paramInt)
  {
    AppMethodBeat.i(95899);
    ae.d("MicroMsg.SnsService", "closeServer");
    this.hRs.remove(parama);
    if (((paramInt == 2) || (paramInt == 10)) && (this.zCy.size() > 0)) {
      this.zCy.removeLast();
    }
    if (this.hRs.isEmpty())
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(211, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(212, this);
      ap.release();
      p.release();
      new aq(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95894);
          ao.a.a(ao.a.this);
          AppMethodBeat.o(95894);
        }
      }, 5000L);
      al.dYa();
      ae.i("MicroMsg.SnsService", "close finish");
    }
    AppMethodBeat.o(95899);
    return true;
  }
  
  public final int aAr(String paramString)
  {
    AppMethodBeat.i(95903);
    synchronized (this.zCs)
    {
      if (this.zCs.containsKey(paramString))
      {
        i = ((Integer)this.zCs.get(paramString)).intValue();
        if (i > 0) {}
        for (;;)
        {
          AppMethodBeat.o(95903);
          return i;
          i = com.tencent.mm.plugin.sns.data.r.dWn();
        }
      }
      int i = com.tencent.mm.plugin.sns.data.r.dWn();
      AppMethodBeat.o(95903);
      return i;
    }
  }
  
  public final void azb(String paramString)
  {
    AppMethodBeat.i(95914);
    String str1 = ah.getAccSnsPath();
    String str2 = paramString + "bg_";
    String str3 = paramString + "tbg_";
    if (com.tencent.mm.vfs.o.fB(str2))
    {
      com.tencent.mm.vfs.o.deleteFile(ap.jv(str1, paramString) + str3);
      com.tencent.mm.vfs.o.bc(ap.jv(str1, paramString), str2, str3);
    }
    AppMethodBeat.o(95914);
  }
  
  public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(95900);
    if (ac.iRo)
    {
      AppMethodBeat.o(95900);
      return;
    }
    synchronized (this.zCr)
    {
      ae.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.zCw), this.zCr });
      if (paramInt1 != 2) {
        break label244;
      }
      if (!aa.aAh(paramString))
      {
        AppMethodBeat.o(95900);
        return;
      }
    }
    long l = 0L;
    synchronized (this.zCr)
    {
      if (this.zCr.containsKey(paramString)) {
        l = ((Long)this.zCr.get(paramString)).longValue();
      }
      if (l == 0L)
      {
        aa.aAi(paramString);
        AppMethodBeat.o(95900);
        return;
      }
    }
    com.tencent.mm.kernel.g.ajS();
    ??? = com.tencent.mm.kernel.g.ajQ().gDv;
    int j = av.zDZ;
    if (paramBoolean) {}
    for (int i = 4;; i = 8)
    {
      ((com.tencent.mm.ak.q)???).a(new aa(paramString, l, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
      AppMethodBeat.o(95900);
      return;
    }
    label244:
    if (paramInt1 == 1)
    {
      if (!y.aAe("@__weixintimtline"))
      {
        AppMethodBeat.o(95900);
        return;
      }
      if (this.zCw == 0L)
      {
        y.aAf("@__weixintimtline");
        AppMethodBeat.o(95900);
        return;
      }
      ah.dXN().zDB = av.zEc;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new y(this.zCw, 0L, 0), 0);
      AppMethodBeat.o(95900);
      return;
    }
    if (paramInt1 != 3)
    {
      if (paramInt1 == 4)
      {
        if (!n.aAe("@__classify_timeline"))
        {
          AppMethodBeat.o(95900);
          return;
        }
        if (this.zCw == 0L)
        {
          n.aAf("@__classify_timeline");
          AppMethodBeat.o(95900);
          return;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new n(""), 0);
        AppMethodBeat.o(95900);
        return;
      }
      if (paramInt1 == 10)
      {
        if (!aa.aAh(paramString))
        {
          AppMethodBeat.o(95900);
          return;
        }
        l = 0L;
        synchronized (this.zCt)
        {
          if (this.zCt.containsKey(paramString)) {
            l = ((Long)this.zCt.get(paramString)).longValue();
          }
          if (l == 0L)
          {
            aa.aAi(paramString);
            AppMethodBeat.o(95900);
            return;
          }
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new aa(paramString, l, paramBoolean, paramInt2, av.zDZ, 1, 64, paramInt1), 0);
      }
    }
    AppMethodBeat.o(95900);
  }
  
  public final int dYi()
  {
    AppMethodBeat.i(95904);
    if (this.zCv > 0)
    {
      i = this.zCv;
      AppMethodBeat.o(95904);
      return i;
    }
    int i = com.tencent.mm.plugin.sns.data.r.dWn();
    AppMethodBeat.o(95904);
    return i;
  }
  
  public final Intent f(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(95897);
    paramIntent.putExtra("sns_userName", paramString);
    if ((this.zCy != null) && (this.zCy.contains(paramString)))
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
    this.zCz.put(paramString, paramArrayList);
    AppMethodBeat.o(95896);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(95907);
    ae.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    if ((paramn != null) && ((paramn instanceof y)) && (((y)paramn).dXb())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.i("MicroMsg.SnsService", "skip by preload unread feeds");
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
      paramString = new ArrayList(this.hRs.keySet());
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
        if (this.hRs.containsKey(paramn))
        {
          ??? = (String)this.hRs.get(paramn);
          if ((localb.getUserName().equals(???)) && (localb.dVM()))
          {
            ??? = com.tencent.mm.plugin.sns.data.r.zW(al.zxX);
            str = com.tencent.mm.plugin.sns.data.r.zW(al.zxY);
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
        if (this.hRs.containsKey(???))
        {
          paramString = (String)this.hRs.get(???);
          if (localb.getUserName().equals(paramString))
          {
            ae.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
            if (localb.dVS() == 0L)
            {
              paramString = "";
              if (!localb.dVL()) {
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
                  ??? = (aa)paramn;
                  paramn = ((aa)???).userName;
                  l = ((aa)???).zxY;
                  i = ((aa)???).zya;
                  if (((aa)???).zzS == 10)
                  {
                    if (i > 0) {}
                    synchronized (this.zCu)
                    {
                      for (;;)
                      {
                        this.zCu.put(paramn, Integer.valueOf(i));
                        if (l == 0L) {
                          break;
                        }
                        synchronized (this.zCt)
                        {
                          this.zCt.put(paramn, Long.valueOf(l));
                        }
                      }
                    }
                  }
                }
                if (i > 0) {}
                synchronized (this.zCs)
                {
                  for (;;)
                  {
                    this.zCs.put(paramn, Integer.valueOf(i));
                    if (l == 0L) {
                      break;
                    }
                    synchronized (this.zCr)
                    {
                      this.zCr.put(paramn, Long.valueOf(l));
                    }
                  }
                }
              }
              paramn = (y)paramn;
              if (localb.dVM()) {
                Ap(paramn.zxX);
              }
              for (;;)
              {
                i = paramn.zyb;
                if (zCq != i) {
                  com.tencent.mm.plugin.sns.data.r.Qq(i);
                }
                ae.i("MicroMsg.SnsService", "updateTimelineControlFlag %d", new Object[] { Integer.valueOf(i) });
                zCq = i;
                break;
                V(paramn.zxY, paramn.zya);
              }
              paramString = com.tencent.mm.plugin.sns.data.r.zW(localb.dVS());
              break label566;
            }
            if (localb.dVM())
            {
              bool = false;
              if (localb.dVN() == av.zEa)
              {
                al.zCh = al.zxX;
                bool = true;
              }
              ae.i("MicroMsg.SnsService", "fetchType:%s, preUpReady:%s, firstPage:%s", new Object[] { Integer.valueOf(localb.dVN()), Boolean.valueOf(this.zCB.zEd), Boolean.valueOf(bool) });
              paramString = com.tencent.mm.plugin.sns.data.r.zW(al.zxX);
              str = com.tencent.mm.plugin.sns.data.r.zW(al.zxY);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao.a
 * JD-Core Version:    0.7.0.1
 */