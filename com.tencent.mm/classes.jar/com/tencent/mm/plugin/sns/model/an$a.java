package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class an$a
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.sns.b.h
{
  public static int ric = -1;
  private Map<h.a, String> ftE;
  private Map<String, Long> rid;
  private Map<String, Integer> rie;
  private int rif;
  public long rig;
  private LinkedList<String> rih;
  public Map<String, ArrayList<com.tencent.mm.plugin.sns.h.b>> rii;
  public Map<String, Integer> rij;
  
  public an$a()
  {
    AppMethodBeat.i(36572);
    this.rid = new HashMap();
    this.rie = new HashMap();
    this.rif = 0;
    this.rig = 0L;
    this.ftE = new HashMap();
    this.rih = new LinkedList();
    this.rii = new HashMap();
    this.rij = new HashMap();
    AppMethodBeat.o(36572);
  }
  
  public static cds a(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(36586);
    paramn = b(paramn, paramInt1, paramString, null, 0, paramInt2);
    AppMethodBeat.o(36586);
    return paramn;
  }
  
  public static cds a(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString, cds paramcds, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(36587);
    paramn = b(paramn, paramInt1, paramString, paramcds, paramInt2, paramInt3);
    AppMethodBeat.o(36587);
    return paramn;
  }
  
  public static cds a(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(36589);
    cdm localcdm = new cdm();
    localcdm.ntu = paramString1;
    localcdm.CreateTime = ((int)(bo.aoy() / 1000L));
    localcdm.xNV = com.tencent.mm.model.r.Zp();
    localcdm.xCG = com.tencent.mm.model.r.Zn();
    localcdm.niK = paramInt2;
    localcdm.xNW = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramn.field_userName);
    localcdm.wQO = paramn.field_userName;
    localcdm.jKs = paramInt1;
    cdn localcdn;
    String str;
    if (paramn.Ex(32))
    {
      localcdm.xNZ = 0L;
      paramString1 = new cdm();
      paramString1.xCG = paramString2;
      if (!bo.isNullOrNil(paramString1.xCG)) {
        paramString1.xNV = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramString1.xCG);
      }
      localcdn = new cdn();
      localcdn.Id = paramn.field_snsId;
      localcdn.xOe = localcdm;
      localcdn.xOf = paramString1;
      str = "";
      if (paramn.Ex(32))
      {
        paramString1 = paramn.csd();
        if (paramString1 != null) {
          break label381;
        }
        paramString2 = "";
        label208:
        if (paramString1 != null) {
          break label389;
        }
        paramString1 = "";
        label215:
        if (localcdm.jKs != 7) {
          break label397;
        }
        ((c)com.tencent.mm.kernel.g.E(c.class)).a(11855, paramn.csR(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramn.csR()) });
        str = paramString1;
      }
      label273:
      paramString2 = com.tencent.mm.a.g.w(bo.yB().getBytes());
      paramString1 = paramString2;
      if (paramn.Ex(32)) {
        paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
      }
      if (!ag.cpe().a(paramString1, localcdn, str)) {
        break label489;
      }
      if (!ae.aat(paramString1)) {
        break label461;
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new k(localcdn, paramString1, str), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(36589);
      return null;
      localcdm.xNX = 0;
      break;
      label381:
      paramString2 = paramString1.hpq;
      break label208;
      label389:
      paramString1 = paramString1.cFe;
      break label215;
      label397:
      str = paramString1;
      if (localcdm.jKs != 8) {
        break label273;
      }
      ((c)com.tencent.mm.kernel.g.E(c.class)).a(11855, paramn.csR(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramn.csR()) });
      str = paramString1;
      break label273;
      label461:
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new o(localcdn, paramString1), 0);
      continue;
      label489:
      ab.e("MicroMsg.SnsService", "can not add Comment");
    }
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, com.tencent.mm.plugin.sns.storage.n paramn, int paramInt2)
  {
    AppMethodBeat.i(36590);
    if ((paramInt1 != 3) && (paramInt1 != 5))
    {
      AppMethodBeat.o(36590);
      return;
    }
    cdm localcdm = new cdm();
    localcdm.ntu = paramString2;
    localcdm.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    localcdm.xNV = com.tencent.mm.model.r.Zp();
    localcdm.xCG = com.tencent.mm.model.r.Zn();
    localcdm.niK = paramInt2;
    localcdm.xNW = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramString1);
    localcdm.wQO = paramString1;
    localcdm.jKs = paramInt1;
    paramString2 = new cdn();
    paramString2.Id = paramn.field_snsId;
    paramString2.xOe = localcdm;
    paramString2.xOf = new cdm();
    String str = com.tencent.mm.a.g.w(bo.yB().getBytes());
    long l = paramn.field_snsId;
    try
    {
      ab.v("MicroMsg.SnsService", "comment stg inserted");
      paramn = new j();
      paramn.field_talker = paramString1;
      paramn.field_snsID = l;
      paramn.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
      paramn.field_curActionBuf = localcdm.toByteArray();
      paramn.field_type = paramInt1;
      paramn.field_isSend = true;
      paramn.field_isRead = 1;
      ag.cpk().insert(paramn);
      ag.cpe().a(str, paramString2);
      AppMethodBeat.o(36590);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SnsService", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static void aaC(String paramString)
  {
    AppMethodBeat.i(36585);
    Object localObject = ag.cpe();
    if (bo.isNullOrNil(((ae)localObject).dZZ)) {
      ((ae)localObject).dZZ = com.tencent.mm.model.r.Zn();
    }
    localObject = ((ae)localObject).dZZ;
    com.tencent.mm.plugin.sns.storage.n localn = com.tencent.mm.plugin.sns.storage.h.abu(paramString);
    for (;;)
    {
      try
      {
        SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localn.field_attrBuf);
        Iterator localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          cds localcds = (cds)localIterator.next();
          if (!localcds.Username.equals(localObject)) {
            continue;
          }
          localSnsObject.LikeUserList.remove(localcds);
          localSnsObject.LikeCount -= 1;
          localn.field_attrBuf = localSnsObject.toByteArray();
          if (!localn.Ex(32)) {
            continue;
          }
          ag.cpi().replace(localn.csQ());
        }
      }
      catch (Exception localException)
      {
        continue;
        String str = localException.hpq;
        continue;
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(new r(v.abO(paramString), 5), 0);
        AppMethodBeat.o(36585);
      }
      if (!ag.cpe().lK(v.abO(paramString))) {
        continue;
      }
      if (!localn.Ex(32)) {
        continue;
      }
      localObject = localn.csd();
      if (localObject != null) {
        continue;
      }
      localObject = "";
      ((c)com.tencent.mm.kernel.g.E(c.class)).a(11855, localn.csR(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localn.csR()) });
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new r(v.abO(paramString), 7), 0);
      AppMethodBeat.o(36585);
      return;
      ag.cpf().B(localn);
    }
  }
  
  private static cds b(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString, cds paramcds, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(36588);
    Object localObject1 = new cdm();
    ((cdm)localObject1).ntu = paramString;
    ((cdm)localObject1).CreateTime = ((int)(bo.aoy() / 1000L));
    ((cdm)localObject1).xNV = com.tencent.mm.model.r.Zp();
    ((cdm)localObject1).xCG = com.tencent.mm.model.r.Zn();
    ((cdm)localObject1).niK = 0;
    ((cdm)localObject1).xNW = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramn.field_userName);
    ((cdm)localObject1).wQO = paramn.field_userName;
    ((cdm)localObject1).jKs = paramInt1;
    ((cdm)localObject1).xOc = paramInt2;
    long l;
    label139:
    cdn localcdn;
    if (paramn.Ex(32)) {
      if (paramcds == null)
      {
        l = 0L;
        ((cdm)localObject1).xNZ = l;
        Object localObject2 = new cdm();
        if (paramcds != null) {
          break label572;
        }
        paramString = "";
        ((cdm)localObject2).xCG = paramString;
        if (!bo.isNullOrNil(((cdm)localObject2).xCG)) {
          ((cdm)localObject2).xNV = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(((cdm)localObject2).xCG);
        }
        localcdn = new cdn();
        localcdn.Id = paramn.field_snsId;
        localcdn.xOe = ((cdm)localObject1);
        localcdn.xOf = ((cdm)localObject2);
        paramcds = "";
        if (paramn.Ex(32))
        {
          if (paramInt3 != 2) {
            break label580;
          }
          paramString = paramn.cse();
          label234:
          if (paramString != null) {
            break label588;
          }
          paramcds = "";
          label241:
          if (paramString != null) {
            break label596;
          }
          paramString = "";
          label248:
          if (((cdm)localObject1).jKs != 7) {
            break label604;
          }
          ((c)com.tencent.mm.kernel.g.E(c.class)).a(11855, paramn.csR(), new Object[] { Integer.valueOf(1), paramcds, Integer.valueOf(paramn.csR()) });
          label303:
          localObject2 = paramn.csQ();
          paramcds = paramString;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.sns.storage.e)localObject2).field_firstControlTime == 0)
            {
              ((com.tencent.mm.plugin.sns.storage.e)localObject2).field_firstControlTime = ((cdm)localObject1).CreateTime;
              ag.cpi().b(((com.tencent.mm.plugin.sns.storage.e)localObject2).field_snsId, (com.tencent.mm.plugin.sns.storage.e)localObject2);
            }
            localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).csi();
            if (paramInt3 != 2) {
              break label702;
            }
            if (localObject1 == null) {
              break label678;
            }
            localcdn.xOe.wpo = ((bs)localObject1).won;
            if (((bs)localObject1).won == null) {
              break label662;
            }
            ab.i("MicroMsg.SnsService", "atFriend remindInfo aid %d", new Object[] { Integer.valueOf(((bs)localObject1).won.xGU) });
            paramcds = paramString;
            if (((bs)localObject1).won.xGU == 0)
            {
              com.tencent.mm.plugin.report.service.h.qsU.cT(955, 9);
              paramcds = paramString;
            }
          }
        }
        label440:
        localObject1 = com.tencent.mm.a.g.w(bo.yB().getBytes());
        paramString = (String)localObject1;
        if (paramn.Ex(32)) {
          paramString = "_AD_TAG_".concat(String.valueOf(localObject1));
        }
        if (!ag.cpe().a(paramString, localcdn)) {
          break label864;
        }
        if (!ae.aat(paramString)) {
          break label836;
        }
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(new k(localcdn, paramString, paramcds), 0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36588);
      return null;
      l = paramcds.xOa;
      break;
      if (paramcds == null) {}
      for (paramInt1 = 0;; paramInt1 = paramcds.xNY)
      {
        ((cdm)localObject1).xNX = paramInt1;
        break;
      }
      label572:
      paramString = paramcds.Username;
      break label139;
      label580:
      paramString = paramn.csd();
      break label234;
      label588:
      paramcds = paramString.hpq;
      break label241;
      label596:
      paramString = paramString.cFe;
      break label248;
      label604:
      if (((cdm)localObject1).jKs != 8) {
        break label303;
      }
      ((c)com.tencent.mm.kernel.g.E(c.class)).a(11855, paramn.csR(), new Object[] { Integer.valueOf(2), paramcds, Integer.valueOf(paramn.csR()) });
      break label303;
      label662:
      com.tencent.mm.plugin.report.service.h.qsU.cT(955, 7);
      paramcds = paramString;
      break label440;
      label678:
      ab.i("MicroMsg.SnsService", "remindInfo group is null!");
      com.tencent.mm.plugin.report.service.h.qsU.cT(955, 5);
      paramcds = paramString;
      break label440;
      label702:
      paramcds = paramString;
      if (!com.tencent.mm.plugin.sns.ui.widget.d.fS(paramInt2, 8)) {
        break label440;
      }
      if (localObject1 != null)
      {
        localcdn.xOe.wpo = ((bs)localObject1).wom;
        if (((bs)localObject1).wom != null)
        {
          ab.i("MicroMsg.SnsService", "timeline remindInfo aid %d", new Object[] { Integer.valueOf(((bs)localObject1).wom.xGU) });
          paramcds = paramString;
          if (((bs)localObject1).wom.xGU != 0) {
            break label440;
          }
          com.tencent.mm.plugin.report.service.h.qsU.cT(955, 8);
          paramcds = paramString;
          break label440;
        }
        com.tencent.mm.plugin.report.service.h.qsU.cT(955, 6);
        paramcds = paramString;
        break label440;
      }
      ab.i("MicroMsg.SnsService", "remindInfo group is null!");
      com.tencent.mm.plugin.report.service.h.qsU.cT(955, 5);
      paramcds = paramString;
      break label440;
      label836:
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new o(localcdn, paramString), 0);
      continue;
      label864:
      ab.e("MicroMsg.SnsService", "can not add Comment");
    }
  }
  
  public static int cpE()
  {
    AppMethodBeat.i(36583);
    if (ric != -1)
    {
      i = ric;
      AppMethodBeat.o(36583);
      return i;
    }
    int i = i.cnQ();
    ric = i;
    AppMethodBeat.o(36583);
    return i;
  }
  
  public final void E(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36582);
    ab.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
    if (paramInt > 0)
    {
      this.rif = paramInt;
      i.DC(paramInt);
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(36582);
      return;
    }
    this.rig = paramLong;
    AppMethodBeat.o(36582);
  }
  
  public final void Zw(String paramString)
  {
    AppMethodBeat.i(36591);
    String str1 = ag.getAccSnsPath();
    String str2 = paramString + "bg_";
    String str3 = paramString + "tbg_";
    if (com.tencent.mm.vfs.e.cN(str2))
    {
      com.tencent.mm.vfs.e.deleteFile(ao.gl(str1, paramString) + str3);
      com.tencent.mm.vfs.e.h(ao.gl(str1, paramString), str2, str3);
    }
    AppMethodBeat.o(36591);
  }
  
  public final void a(int paramInt, String paramString, h.a arg3)
  {
    AppMethodBeat.i(36576);
    ab.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
    ag.cpe().dZZ = com.tencent.mm.model.r.Zn();
    ag.cpe().coF();
    ag.cpb().cnP();
    if (this.ftE.isEmpty())
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(211, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(212, this);
    }
    if (!this.ftE.containsKey(???))
    {
      if (paramInt == 1) {
        this.ftE.put(???, "@__weixintimtline");
      }
    }
    else {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36576);
      return;
      if ((paramInt == 2) || (paramInt == 3))
      {
        this.ftE.put(???, paramString);
        break;
      }
      if (paramInt == 4)
      {
        this.ftE.put(???, "@__classify_timeline");
        break;
      }
      if (paramInt == 5)
      {
        this.ftE.put(???, "");
        break;
      }
      this.ftE.put(???, "");
      break;
      synchronized (this.rid)
      {
        this.rid.put(paramString, Long.valueOf(0L));
      }
      synchronized (this.rie)
      {
        if (!this.rie.containsKey(paramString)) {
          this.rie.put(paramString, Integer.valueOf(cpD()));
        }
        aa.aar(paramString);
        this.rih.add(paramString);
        AppMethodBeat.o(36576);
        return;
        paramString = finally;
        AppMethodBeat.o(36576);
        throw paramString;
      }
      this.rig = 0L;
      this.rif = cpD();
      y.aao("@__weixintimtline");
    }
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(36579);
    if (com.tencent.mm.platformtools.ae.gkr)
    {
      AppMethodBeat.o(36579);
      return;
    }
    ab.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (paramInt1 == 2)
    {
      if (!aa.aaq(paramString))
      {
        AppMethodBeat.o(36579);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new aa(paramString, 0L, paramBoolean, paramInt2), 0);
      AppMethodBeat.o(36579);
      return;
    }
    if (paramInt1 == 1)
    {
      if (!y.aan("@__weixintimtline"))
      {
        AppMethodBeat.o(36579);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(68377, "");
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new y(0L), 0);
      AppMethodBeat.o(36579);
      return;
    }
    if ((paramInt1 != 3) && (paramInt1 == 4))
    {
      if (!n.aan("@__classify_timeline"))
      {
        AppMethodBeat.o(36579);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new n(""), 0);
    }
    AppMethodBeat.o(36579);
  }
  
  public final boolean a(h.a parama, int paramInt)
  {
    AppMethodBeat.i(36577);
    ab.d("MicroMsg.SnsService", "closeServer");
    this.ftE.remove(parama);
    if ((paramInt == 2) && (this.rih.size() > 0)) {
      this.rih.removeLast();
    }
    if (this.ftE.isEmpty())
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(211, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(212, this);
      ao.release();
      com.tencent.mm.plugin.sns.storage.n.release();
      new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper()).postDelayed(new an.a.1(this), 5000L);
      ak.cpw();
      ab.i("MicroMsg.SnsService", "close finish");
    }
    AppMethodBeat.o(36577);
    return true;
  }
  
  public final int aaB(String paramString)
  {
    AppMethodBeat.i(36580);
    synchronized (this.rie)
    {
      if (this.rie.containsKey(paramString))
      {
        i = ((Integer)this.rie.get(paramString)).intValue();
        if (i > 0) {}
        for (;;)
        {
          AppMethodBeat.o(36580);
          return i;
          i = i.cnR();
        }
      }
      int i = i.cnR();
      AppMethodBeat.o(36580);
      return i;
    }
  }
  
  public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(36578);
    if (com.tencent.mm.platformtools.ae.gkr)
    {
      AppMethodBeat.o(36578);
      return;
    }
    synchronized (this.rid)
    {
      ab.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.rig), this.rid });
      if (paramInt1 != 2) {
        break label215;
      }
      if (!aa.aaq(paramString))
      {
        AppMethodBeat.o(36578);
        return;
      }
    }
    long l = 0L;
    synchronized (this.rid)
    {
      if (this.rid.containsKey(paramString)) {
        l = ((Long)this.rid.get(paramString)).longValue();
      }
      if (l == 0L)
      {
        aa.aar(paramString);
        AppMethodBeat.o(36578);
        return;
      }
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(new aa(paramString, l, paramBoolean, paramInt2), 0);
    AppMethodBeat.o(36578);
    return;
    label215:
    if (paramInt1 == 1)
    {
      if (!y.aan("@__weixintimtline"))
      {
        AppMethodBeat.o(36578);
        return;
      }
      if (this.rig == 0L)
      {
        y.aao("@__weixintimtline");
        AppMethodBeat.o(36578);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new y(this.rig), 0);
      AppMethodBeat.o(36578);
      return;
    }
    if ((paramInt1 != 3) && (paramInt1 == 4))
    {
      if (!n.aan("@__classify_timeline"))
      {
        AppMethodBeat.o(36578);
        return;
      }
      if (this.rig == 0L)
      {
        n.aao("@__classify_timeline");
        AppMethodBeat.o(36578);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new n(""), 0);
    }
    AppMethodBeat.o(36578);
  }
  
  public final int cpD()
  {
    AppMethodBeat.i(36581);
    if (this.rif > 0)
    {
      i = this.rif;
      AppMethodBeat.o(36581);
      return i;
    }
    int i = i.cnR();
    AppMethodBeat.o(36581);
    return i;
  }
  
  public final Intent e(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(36575);
    paramIntent.putExtra("sns_userName", paramString);
    if ((this.rih != null) && (this.rih.contains(paramString)))
    {
      paramIntent.addFlags(536870912);
      paramIntent.addFlags(67108864);
      AppMethodBeat.o(36575);
      return paramIntent;
    }
    AppMethodBeat.o(36575);
    return paramIntent;
  }
  
  public final void j(String paramString, ArrayList<com.tencent.mm.plugin.sns.h.b> paramArrayList)
  {
    AppMethodBeat.i(36573);
    this.rii.put(paramString, paramArrayList);
    AppMethodBeat.o(36573);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(36584);
    ab.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType());
    int i;
    if (((paramInt1 != 4) || (paramInt2 != 207)) && ((paramInt1 != 4) || (paramInt2 != 203))) {
      if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2005))) {
        i = 1;
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(36584);
      return;
      if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2003))) {
        i = 1;
      } else if ((paramInt1 != 0) || (paramInt2 != 0)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label642:
    label648:
    switch (paramm.getType())
    {
    default: 
      if ((paramm.getType() == 212) || (paramm.getType() == 211))
      {
        paramm = (d)paramm;
        ??? = new ArrayList(this.ftE.keySet()).iterator();
      }
      label346:
      break;
    case 212: 
    case 211: 
      label250:
      while (((Iterator)???).hasNext())
      {
        h.a locala = (h.a)((Iterator)???).next();
        if (this.ftE.containsKey(locala))
        {
          paramString = (String)this.ftE.get(locala);
          if (paramm.getUserName().equals(paramString))
          {
            ab.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
            boolean bool4;
            if (paramm.cor() == 0L)
            {
              paramString = "";
              if (!paramm.con()) {
                break label648;
              }
              bool2 = paramm.cop();
              bool3 = paramm.coo();
              bool4 = paramm.cos();
              if ((paramInt1 != 4) || ((paramInt2 != 2001) && (paramInt2 != 2004) && (paramInt2 != 2003) && (paramInt2 != 2005) && (paramInt2 != 203))) {
                break label642;
              }
            }
            for (boolean bool1 = true;; bool1 = false)
            {
              for (;;)
              {
                locala.a(bool2, bool3, paramString, bool4, bool1, paramInt2, paramm.cot(), paramm.cou());
                break label250;
                ??? = (aa)paramm;
                paramString = ((aa)???).userName;
                long l = ((aa)???).rey;
                i = ((aa)???).reA;
                if (i > 0) {}
                synchronized (this.rie)
                {
                  for (;;)
                  {
                    this.rie.put(paramString, Integer.valueOf(i));
                    if (l == 0L) {
                      break;
                    }
                    synchronized (this.rid)
                    {
                      this.rid.put(paramString, Long.valueOf(l));
                    }
                  }
                }
              }
              paramString = (y)paramm;
              E(paramString.rey, paramString.reA);
              i = paramString.reB;
              if (ric != i) {
                i.DB(i);
              }
              ric = i;
              break;
              paramString = i.lr(paramm.cor());
              break label346;
            }
            boolean bool2 = paramm.coo();
            boolean bool3 = paramm.coq();
            if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003) || (paramInt2 == 2005) || (paramInt2 == 203))) {}
            for (bool1 = true;; bool1 = false)
            {
              locala.a(bool2, paramString, bool3, bool1, paramInt2, paramm.cot(), paramm.cou());
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(36584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an.a
 * JD-Core Version:    0.7.0.1
 */