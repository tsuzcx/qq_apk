package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class am$a
  implements com.tencent.mm.ah.f, com.tencent.mm.plugin.sns.b.h
{
  public static int otk = -1;
  private Map<h.a, String> edB = new HashMap();
  private Map<String, Long> otl = new HashMap();
  private Map<String, Integer> otm = new HashMap();
  private int otn = 0;
  public long oto = 0L;
  private LinkedList<String> otp = new LinkedList();
  public Map<String, ArrayList<com.tencent.mm.plugin.sns.g.b>> otq = new HashMap();
  public Map<String, Integer> otr = new HashMap();
  
  public static void NI(String paramString)
  {
    Object localObject = af.bDE();
    if (bk.bl(((ad)localObject).diG)) {
      ((ad)localObject).diG = q.Gj();
    }
    localObject = ((ad)localObject).diG;
    com.tencent.mm.plugin.sns.storage.n localn = com.tencent.mm.plugin.sns.storage.h.OA(paramString);
    for (;;)
    {
      try
      {
        bto localbto = (bto)new bto().aH(localn.field_attrBuf);
        Iterator localIterator = localbto.tJY.iterator();
        if (localIterator.hasNext())
        {
          btd localbtd = (btd)localIterator.next();
          if (!localbtd.sxM.equals(localObject)) {
            continue;
          }
          localbto.tJY.remove(localbtd);
          localbto.tJW -= 1;
          localn.field_attrBuf = localbto.toByteArray();
          if (!localn.yr(32)) {
            continue;
          }
          af.bDI().a(localn.bGN());
        }
      }
      catch (Exception localException)
      {
        continue;
        String str = localException.fVM;
        continue;
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new r(v.OU(paramString), 5), 0);
      }
      if (af.bDE().gf(v.OU(paramString)))
      {
        if (!localn.yr(32)) {
          continue;
        }
        localObject = localn.bGb();
        if (localObject != null) {
          continue;
        }
        localObject = "";
        ((c)com.tencent.mm.kernel.g.r(c.class)).a(11855, localn.bGO(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localn.bGO()) });
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new r(v.OU(paramString), 7), 0);
      }
      return;
      af.bDF().C(localn);
    }
  }
  
  public static btd a(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString, int paramInt2)
  {
    return b(paramn, paramInt1, paramString, null, 0, paramInt2);
  }
  
  public static btd a(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString, btd parambtd, int paramInt2, int paramInt3)
  {
    return b(paramn, paramInt1, paramString, parambtd, paramInt2, paramInt3);
  }
  
  public static btd a(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    bsx localbsx = new bsx();
    localbsx.kVs = paramString1;
    localbsx.mPL = ((int)(bk.UY() / 1000L));
    localbsx.tJr = q.Gl();
    localbsx.tAY = q.Gj();
    localbsx.swS = paramInt2;
    localbsx.tJs = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(paramn.field_userName);
    localbsx.sSS = paramn.field_userName;
    localbsx.hQR = paramInt1;
    bsy localbsy;
    String str;
    if (paramn.yr(32))
    {
      localbsx.tJw = 0L;
      paramString1 = new bsx();
      paramString1.tAY = paramString2;
      if (!bk.bl(paramString1.tAY)) {
        paramString1.tJr = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(paramString1.tAY);
      }
      localbsy = new bsy();
      localbsy.sGd = paramn.field_snsId;
      localbsy.tJB = localbsx;
      localbsy.tJC = paramString1;
      str = "";
      if (paramn.yr(32))
      {
        paramString1 = paramn.bGb();
        if (paramString1 != null) {
          break label381;
        }
        paramString2 = "";
        label205:
        if (paramString1 != null) {
          break label389;
        }
        paramString1 = "";
        label212:
        if (localbsx.hQR != 7) {
          break label397;
        }
        ((c)com.tencent.mm.kernel.g.r(c.class)).a(11855, paramn.bGO(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramn.bGO()) });
        str = paramString1;
      }
      label270:
      paramString2 = com.tencent.mm.a.g.o(bk.UZ().getBytes());
      paramString1 = paramString2;
      if (paramn.yr(32)) {
        paramString1 = "_AD_TAG_" + paramString2;
      }
      if (!af.bDE().a(paramString1, localbsy, str)) {
        break label489;
      }
      if (!ad.Nz(paramString1)) {
        break label461;
      }
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new k(localbsy, paramString1, str), 0);
    }
    for (;;)
    {
      return null;
      localbsx.tJt = 0;
      break;
      label381:
      paramString2 = paramString1.fVM;
      break label205;
      label389:
      paramString1 = paramString1.ovV;
      break label212;
      label397:
      str = paramString1;
      if (localbsx.hQR != 8) {
        break label270;
      }
      ((c)com.tencent.mm.kernel.g.r(c.class)).a(11855, paramn.bGO(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramn.bGO()) });
      str = paramString1;
      break label270;
      label461:
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new o(localbsy, paramString1), 0);
      continue;
      label489:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsService", "can not add Comment");
    }
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, com.tencent.mm.plugin.sns.storage.n paramn, int paramInt2)
  {
    if ((paramInt1 != 3) && (paramInt1 != 5)) {
      return;
    }
    bsx localbsx = new bsx();
    localbsx.kVs = paramString2;
    localbsx.mPL = ((int)(System.currentTimeMillis() / 1000L));
    localbsx.tJr = q.Gl();
    localbsx.tAY = q.Gj();
    localbsx.swS = paramInt2;
    localbsx.tJs = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(paramString1);
    localbsx.sSS = paramString1;
    localbsx.hQR = paramInt1;
    paramString2 = new bsy();
    paramString2.sGd = paramn.field_snsId;
    paramString2.tJB = localbsx;
    paramString2.tJC = new bsx();
    String str = com.tencent.mm.a.g.o(bk.UZ().getBytes());
    long l = paramn.field_snsId;
    try
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SnsService", "comment stg inserted");
      paramn = new j();
      paramn.field_talker = paramString1;
      paramn.field_snsID = l;
      paramn.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
      paramn.field_curActionBuf = localbsx.toByteArray();
      paramn.field_type = paramInt1;
      paramn.field_isSend = true;
      paramn.field_isRead = 1;
      af.bDK().b(paramn);
      af.bDE().a(str, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SnsService", paramString1, "", new Object[0]);
      }
    }
  }
  
  private static btd b(com.tencent.mm.plugin.sns.storage.n paramn, int paramInt1, String paramString, btd parambtd, int paramInt2, int paramInt3)
  {
    Object localObject1 = new bsx();
    ((bsx)localObject1).kVs = paramString;
    ((bsx)localObject1).mPL = ((int)(bk.UY() / 1000L));
    ((bsx)localObject1).tJr = q.Gl();
    ((bsx)localObject1).tAY = q.Gj();
    ((bsx)localObject1).swS = 0;
    ((bsx)localObject1).tJs = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(paramn.field_userName);
    ((bsx)localObject1).sSS = paramn.field_userName;
    ((bsx)localObject1).hQR = paramInt1;
    ((bsx)localObject1).tJz = paramInt2;
    long l;
    label134:
    bsy localbsy;
    if (paramn.yr(32)) {
      if (parambtd == null)
      {
        l = 0L;
        ((bsx)localObject1).tJw = l;
        Object localObject2 = new bsx();
        if (parambtd != null) {
          break label522;
        }
        paramString = "";
        ((bsx)localObject2).tAY = paramString;
        if (!bk.bl(((bsx)localObject2).tAY)) {
          ((bsx)localObject2).tJr = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(((bsx)localObject2).tAY);
        }
        localbsy = new bsy();
        localbsy.sGd = paramn.field_snsId;
        localbsy.tJB = ((bsx)localObject1);
        localbsy.tJC = ((bsx)localObject2);
        parambtd = "";
        if (paramn.yr(32))
        {
          if (paramInt3 != 2) {
            break label530;
          }
          paramString = paramn.bGc();
          label230:
          if (paramString != null) {
            break label538;
          }
          parambtd = "";
          label237:
          if (paramString != null) {
            break label546;
          }
          paramString = "";
          label244:
          if (((bsx)localObject1).hQR != 7) {
            break label554;
          }
          ((c)com.tencent.mm.kernel.g.r(c.class)).a(11855, paramn.bGO(), new Object[] { Integer.valueOf(1), parambtd, Integer.valueOf(paramn.bGO()) });
          label299:
          localObject2 = paramn.bGN();
          parambtd = paramString;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.sns.storage.e)localObject2).field_firstControlTime == 0)
            {
              ((com.tencent.mm.plugin.sns.storage.e)localObject2).field_firstControlTime = ((bsx)localObject1).mPL;
              af.bDI().b(((com.tencent.mm.plugin.sns.storage.e)localObject2).field_snsId, (com.tencent.mm.plugin.sns.storage.e)localObject2);
            }
            parambtd = paramString;
            if (paramInt2 == 8)
            {
              localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).bGf();
              parambtd = paramString;
              if (localObject1 != null)
              {
                if (paramInt3 != 2) {
                  break label612;
                }
                localbsy.tJB.swb = ((bm)localObject1).svh;
                parambtd = paramString;
              }
            }
          }
        }
        label388:
        localObject1 = com.tencent.mm.a.g.o(bk.UZ().getBytes());
        paramString = (String)localObject1;
        if (paramn.yr(32)) {
          paramString = "_AD_TAG_" + (String)localObject1;
        }
        if (!af.bDE().a(paramString, localbsy)) {
          break label658;
        }
        if (!ad.Nz(paramString)) {
          break label630;
        }
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new k(localbsy, paramString, parambtd), 0);
      }
    }
    for (;;)
    {
      return null;
      l = parambtd.tJx;
      break;
      if (parambtd == null) {}
      for (paramInt1 = 0;; paramInt1 = parambtd.tJu)
      {
        ((bsx)localObject1).tJt = paramInt1;
        break;
      }
      label522:
      paramString = parambtd.sxM;
      break label134;
      label530:
      paramString = paramn.bGb();
      break label230;
      label538:
      parambtd = paramString.fVM;
      break label237;
      label546:
      paramString = paramString.ovV;
      break label244;
      label554:
      if (((bsx)localObject1).hQR != 8) {
        break label299;
      }
      ((c)com.tencent.mm.kernel.g.r(c.class)).a(11855, paramn.bGO(), new Object[] { Integer.valueOf(2), parambtd, Integer.valueOf(paramn.bGO()) });
      break label299;
      label612:
      localbsy.tJB.swb = ((bm)localObject1).svg;
      parambtd = paramString;
      break label388;
      label630:
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new o(localbsy, paramString), 0);
      continue;
      label658:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsService", "can not add Comment");
    }
  }
  
  public static int bEf()
  {
    if (otk != -1) {
      return otk;
    }
    int i = i.bCq();
    otk = i;
    return i;
  }
  
  public final void MP(String paramString)
  {
    String str1 = af.getAccSnsPath();
    String str2 = paramString + "bg_";
    String str3 = paramString + "tbg_";
    if (com.tencent.mm.vfs.e.bK(str2))
    {
      com.tencent.mm.vfs.e.deleteFile(an.eJ(str1, paramString) + str3);
      com.tencent.mm.vfs.e.f(an.eJ(str1, paramString), str2, str3);
    }
  }
  
  public final int NH(String paramString)
  {
    synchronized (this.otm)
    {
      if (this.otm.containsKey(paramString))
      {
        int i = ((Integer)this.otm.get(paramString)).intValue();
        if (i > 0) {}
        for (;;)
        {
          return i;
          i = i.bCr();
        }
      }
      return i.bCr();
    }
  }
  
  public final void a(int paramInt, String paramString, h.a arg3)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
    af.bDE().diG = q.Gj();
    af.bDE().bDg();
    af.bDB().bCp();
    if (this.edB.isEmpty())
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(211, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(212, this);
    }
    if (!this.edB.containsKey(???))
    {
      if (paramInt != 1) {
        break label157;
      }
      this.edB.put(???, "@__weixintimtline");
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
        label157:
        if ((paramInt == 2) || (paramInt == 3)) {
          this.edB.put(???, paramString);
        } else if (paramInt == 4) {
          this.edB.put(???, "@__classify_timeline");
        } else if (paramInt == 5) {
          this.edB.put(???, "");
        } else {
          this.edB.put(???, "");
        }
        break;
      }
    }
    synchronized (this.otl)
    {
      this.otl.put(paramString, Long.valueOf(0L));
    }
    synchronized (this.otm)
    {
      if (!this.otm.containsKey(paramString)) {
        this.otm.put(paramString, Integer.valueOf(bEe()));
      }
      aa.Ny(paramString);
      this.otp.add(paramString);
      return;
      paramString = finally;
      throw paramString;
    }
    this.oto = 0L;
    this.otn = bEe();
    y.Nv("@__weixintimtline");
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    if (ae.eSw) {}
    do
    {
      do
      {
        do
        {
          return;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          if (paramInt1 != 2) {
            break;
          }
        } while (!aa.Nx(paramString));
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new aa(paramString, 0L, paramBoolean, paramInt2), 0);
        return;
        if (paramInt1 != 1) {
          break;
        }
      } while (!y.Nu("@__weixintimtline"));
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(68377, "");
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new y(0L), 0);
      return;
    } while ((paramInt1 == 3) || (paramInt1 != 4) || (!n.Nu("@__classify_timeline")));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(new n(""), 0);
  }
  
  public final boolean a(h.a parama, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsService", "closeServer");
    this.edB.remove(parama);
    if ((paramInt == 2) && (this.otp.size() > 0)) {
      this.otp.removeLast();
    }
    if (this.edB.isEmpty())
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(211, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(212, this);
      an.release();
      com.tencent.mm.plugin.sns.storage.n.release();
      new ah(Looper.getMainLooper()).postDelayed(new am.a.1(this), 5000L);
      aj.bDX();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsService", "close finish");
    }
    return true;
  }
  
  public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    if (ae.eSw) {}
    do
    {
      do
      {
        long l;
        for (;;)
        {
          return;
          synchronized (this.otl)
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.oto), this.otl });
            if (paramInt1 != 2) {
              break;
            }
            if (aa.Nx(paramString)) {
              l = 0L;
            }
          }
        }
        synchronized (this.otl)
        {
          if (this.otl.containsKey(paramString)) {
            l = ((Long)this.otl.get(paramString)).longValue();
          }
          if (l == 0L)
          {
            y.Nv(paramString);
            return;
            paramString = finally;
            throw paramString;
          }
        }
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new aa(paramString, l, paramBoolean, paramInt2), 0);
        return;
        if (paramInt1 != 1) {
          break;
        }
      } while (!y.Nu("@__weixintimtline"));
      if (this.oto == 0L)
      {
        y.Nv("@__weixintimtline");
        return;
      }
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(new y(this.oto), 0);
      return;
    } while ((paramInt1 == 3) || (paramInt1 != 4) || (!n.Nu("@__classify_timeline")));
    if (this.oto == 0L)
    {
      n.Nv("@__classify_timeline");
      return;
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(new n(""), 0);
  }
  
  public final int bEe()
  {
    if (this.otn > 0) {
      return this.otn;
    }
    return i.bCr();
  }
  
  public final Intent e(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("sns_userName", paramString);
    if ((this.otp != null) && (this.otp.contains(paramString)))
    {
      paramIntent.addFlags(536870912);
      paramIntent.addFlags(67108864);
    }
    return paramIntent;
  }
  
  public final void h(String paramString, ArrayList<com.tencent.mm.plugin.sns.g.b> paramArrayList)
  {
    this.otq.put(paramString, paramArrayList);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType());
    int i;
    if (((paramInt1 != 4) || (paramInt2 != 207)) && ((paramInt1 != 4) || (paramInt2 != 203))) {
      if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004))) {
        i = 1;
      }
    }
    while (i == 0)
    {
      return;
      if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2003))) {
        i = 1;
      } else if ((paramInt1 != 0) || (paramInt2 != 0)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label180:
    label230:
    h.a locala;
    label333:
    boolean bool4;
    switch (paramm.getType())
    {
    default: 
      if ((paramm.getType() == 212) || (paramm.getType() == 211))
      {
        paramm = (d)paramm;
        ??? = new ArrayList(this.edB.keySet()).iterator();
        do
        {
          do
          {
            if (!((Iterator)???).hasNext()) {
              break;
            }
            locala = (h.a)((Iterator)???).next();
          } while (!this.edB.containsKey(locala));
          paramString = (String)this.edB.get(locala);
        } while (!paramm.getUserName().equals(paramString));
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsService", "notify ui " + paramString);
        if (paramm.bCQ() != 0L) {
          break label582;
        }
        paramString = "";
        if (!paramm.bCM()) {
          break label602;
        }
        bool2 = paramm.bCO();
        bool3 = paramm.bCN();
        bool4 = paramm.bCR();
        if ((paramInt1 != 4) || ((paramInt2 != 2001) && (paramInt2 != 2004) && (paramInt2 != 2003))) {
          break label596;
        }
      }
      break;
    }
    label582:
    label596:
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        locala.a(bool2, bool3, paramString, bool4, bool1, paramInt2, paramm.bCS());
        break label230;
        ??? = (aa)paramm;
        paramString = ((aa)???).userName;
        long l = ((aa)???).opR;
        i = ((aa)???).opT;
        if (i > 0) {}
        synchronized (this.otm)
        {
          for (;;)
          {
            this.otm.put(paramString, Integer.valueOf(i));
            if (l == 0L) {
              break;
            }
            synchronized (this.otl)
            {
              this.otl.put(paramString, Long.valueOf(l));
            }
          }
        }
      }
      paramString = (y)paramm;
      x(paramString.opR, paramString.opT);
      i = paramString.opU;
      if (otk != i) {
        i.xB(i);
      }
      otk = i;
      break label180;
      break;
      paramString = i.fO(paramm.bCQ());
      break label333;
    }
    label602:
    boolean bool2 = paramm.bCN();
    boolean bool3 = paramm.bCP();
    if ((paramInt1 == 4) && ((paramInt2 == 2001) || (paramInt2 == 2004) || (paramInt2 == 2003))) {}
    for (bool1 = true;; bool1 = false)
    {
      locala.a(bool2, paramString, bool3, bool1, paramInt2, paramm.bCS());
      break;
    }
  }
  
  public final void x(long paramLong, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
    if (paramInt > 0)
    {
      this.otn = paramInt;
      i.xC(paramInt);
    }
    if (paramLong == 0L) {
      return;
    }
    this.oto = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am.a
 * JD-Core Version:    0.7.0.1
 */