package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.c.i.a;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class am
{
  private static final int wIJ;
  
  static
  {
    AppMethodBeat.i(95919);
    wIJ = com.tencent.mm.m.g.Zd().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(95919);
  }
  
  public static boolean dtW()
  {
    AppMethodBeat.i(95917);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtM, Integer.valueOf(0))).intValue();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(wIJ) });
    if (i < wIJ)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtM, Integer.valueOf(i + 1));
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
        Object localObject = af.dtu().Ne(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((p)localObject).dxy();
          if ((localTimeLineObject != null) && (localTimeLineObject.Etm != null) && (localTimeLineObject.Etm.DaB == 26))
          {
            localTimeLineObject.Etm.DaE = paramString;
            af.dtu().b(i, (p)localObject);
            localObject = new qw();
            ((qw)localObject).dwz.dwA = i;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(95916);
  }
  
  public static boolean fK(Context paramContext)
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
      boolean bool2 = bt.kU(com.tencent.d.f.e.bytesToHexString(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
      if (!bool2) {
        break label87;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
      }
    }
    AppMethodBeat.o(95918);
    return bool1;
  }
  
  public static final class a
    implements com.tencent.mm.al.g, com.tencent.mm.plugin.sns.c.i
  {
    public static int wIK = -1;
    private Map<i.a, String> gVL;
    private Map<String, Long> wIL;
    private Map<String, Integer> wIM;
    private Map<String, Long> wIN;
    private Map<String, Integer> wIO;
    private int wIP;
    public long wIQ;
    public long wIR;
    private LinkedList<String> wIS;
    public Map<String, ArrayList<com.tencent.mm.plugin.sns.j.b>> wIT;
    public Map<String, Integer> wIU;
    private as wIV;
    
    public a()
    {
      AppMethodBeat.i(95895);
      this.wIL = new HashMap();
      this.wIM = new HashMap();
      this.wIN = new HashMap();
      this.wIO = new HashMap();
      this.wIP = 0;
      this.wIQ = 0L;
      this.wIR = 0L;
      this.gVL = new HashMap();
      this.wIS = new LinkedList();
      this.wIT = new HashMap();
      this.wIU = new HashMap();
      this.wIV = new as();
      AppMethodBeat.o(95895);
    }
    
    public static cuo a(p paramp, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(95909);
      paramp = b(paramp, paramInt1, paramString, null, 0, paramInt2, "");
      AppMethodBeat.o(95909);
      return paramp;
    }
    
    public static cuo a(p paramp, int paramInt1, String paramString1, cuo paramcuo, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95910);
      paramp = b(paramp, paramInt1, paramString1, paramcuo, paramInt2, paramInt3, paramString2);
      AppMethodBeat.o(95910);
      return paramp;
    }
    
    public static cuo a(p paramp, int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(95912);
      cui localcui = new cui();
      localcui.gKr = paramString1;
      localcui.CreateTime = ((int)(bt.eGO() / 1000L));
      localcui.ElX = u.aqI();
      localcui.DZr = u.aqG();
      localcui.rNz = paramInt2;
      localcui.ElY = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramp.field_userName);
      localcui.DdY = paramp.field_userName;
      localcui.mBH = paramInt1;
      cuj localcuj;
      String str;
      if (paramp.Nb(32))
      {
        localcui.Emb = 0L;
        paramString1 = new cui();
        paramString1.DZr = paramString2;
        if (!bt.isNullOrNil(paramString1.DZr)) {
          paramString1.ElX = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramString1.DZr);
        }
        localcuj = new cuj();
        localcuj.Id = paramp.field_snsId;
        localcuj.Emi = localcui;
        localcuj.Emj = paramString1;
        str = "";
        if (paramp.Nb(32))
        {
          paramString1 = paramp.dxu();
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
          if (localcui.mBH != 7) {
            break label398;
          }
          ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dyi(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramp.dyi()) });
          str = paramString1;
        }
        label273:
        paramString2 = com.tencent.mm.b.g.getMessageDigest(bt.GC().getBytes());
        paramString1 = paramString2;
        if (paramp.Nb(32)) {
          paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
        }
        if (!af.dtt().a(paramString1, localcuj, str)) {
          break label490;
        }
        if (!ad.aoC(paramString1)) {
          break label462;
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new j(localcuj, paramString1, str, 0), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(95912);
        return null;
        localcui.ElZ = 0;
        break;
        label382:
        paramString2 = paramString1.dAM;
        break label208;
        label390:
        paramString1 = paramString1.dvK;
        break label215;
        label398:
        str = paramString1;
        if (localcui.mBH != 8) {
          break label273;
        }
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dyi(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramp.dyi()) });
        str = paramString1;
        break label273;
        label462:
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new n(localcuj, paramString1), 0);
        continue;
        label490:
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsService", "can not add Comment");
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
      cui localcui = new cui();
      localcui.gKr = paramString2;
      localcui.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
      localcui.ElX = u.aqI();
      localcui.DZr = u.aqG();
      localcui.rNz = paramInt2;
      localcui.ElY = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramString1);
      localcui.DdY = paramString1;
      localcui.mBH = paramInt1;
      paramString2 = new cuj();
      paramString2.Id = paramp.field_snsId;
      paramString2.Emi = localcui;
      paramString2.Emj = new cui();
      String str = com.tencent.mm.b.g.getMessageDigest(bt.GC().getBytes());
      long l = paramp.field_snsId;
      try
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.SnsService", "comment stg inserted");
        paramp = new com.tencent.mm.plugin.sns.storage.j();
        paramp.field_talker = paramString1;
        paramp.field_snsID = l;
        paramp.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
        paramp.field_curActionBuf = localcui.toByteArray();
        paramp.field_type = paramInt1;
        paramp.field_isSend = true;
        paramp.field_isRead = 1;
        af.dtz().insert(paramp);
        af.dtt().a(str, paramString2);
        AppMethodBeat.o(95913);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsService", paramString1, "", new Object[0]);
        }
      }
    }
    
    public static void aoK(String paramString)
    {
      AppMethodBeat.i(95908);
      Object localObject = af.dtt();
      if (bt.isNullOrNil(((ad)localObject).fki)) {
        ((ad)localObject).fki = u.aqG();
      }
      localObject = ((ad)localObject).fki;
      p localp = com.tencent.mm.plugin.sns.storage.h.apJ(paramString);
      for (;;)
      {
        try
        {
          SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
          Iterator localIterator = localSnsObject.LikeUserList.iterator();
          if (localIterator.hasNext())
          {
            cuo localcuo = (cuo)localIterator.next();
            if (!localcuo.Username.equals(localObject)) {
              continue;
            }
            localSnsObject.LikeUserList.remove(localcuo);
            localSnsObject.LikeCount -= 1;
            localp.field_attrBuf = localSnsObject.toByteArray();
            if (!localp.Nb(32)) {
              continue;
            }
            af.dtx().replace(localp.dyh());
          }
        }
        catch (Exception localException)
        {
          continue;
          String str = localException.dAM;
          continue;
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new q(com.tencent.mm.plugin.sns.storage.x.anz(paramString), 5), 0);
          AppMethodBeat.o(95908);
        }
        if (!af.dtt().sN(com.tencent.mm.plugin.sns.storage.x.anz(paramString))) {
          continue;
        }
        if (!localp.Nb(32)) {
          continue;
        }
        localObject = localp.dxu();
        if (localObject != null) {
          continue;
        }
        localObject = "";
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, localp.dyi(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localp.dyi()) });
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new q(com.tencent.mm.plugin.sns.storage.x.anz(paramString), 7), 0);
        AppMethodBeat.o(95908);
        return;
        af.dtu().J(localp);
      }
    }
    
    private static cuo b(p paramp, int paramInt1, String paramString1, cuo paramcuo, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95911);
      cui localcui = new cui();
      localcui.gKr = paramString1;
      localcui.CreateTime = ((int)(bt.eGO() / 1000L));
      localcui.ElX = u.aqI();
      localcui.DZr = u.aqG();
      localcui.rNz = 0;
      localcui.ElY = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramp.field_userName);
      localcui.DdY = paramp.field_userName;
      localcui.mBH = paramInt1;
      localcui.Eme = paramInt2;
      long l;
      label189:
      cuj localcuj;
      int i;
      if (paramp.Nb(32)) {
        if (paramcuo == null)
        {
          l = 0L;
          localcui.Emb = l;
          if (!bt.isNullOrNil(paramString2))
          {
            paramString1 = new cuu();
            paramString1.Md5 = paramString2;
            localcui.Emf = new LinkedList();
            localcui.Emf.add(paramString1);
            localcui.Emg = 1;
          }
          paramString2 = new cui();
          if (paramcuo != null) {
            break label686;
          }
          paramString1 = "";
          paramString2.DZr = paramString1;
          if (!bt.isNullOrNil(paramString2.DZr)) {
            paramString2.ElX = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramString2.DZr);
          }
          localcuj = new cuj();
          localcuj.Id = paramp.field_snsId;
          localcuj.Emi = localcui;
          localcuj.Emj = paramString2;
          paramString1 = "";
          i = 0;
          if (paramp.Nb(32))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "sendComment, sourceScene=" + paramInt3 + ", type=" + paramInt1 + ", flag=" + paramInt2);
            if (paramInt3 != 2) {
              break label694;
            }
            paramString1 = paramp.dxv();
            paramInt1 = 1;
            label334:
            if (paramString1 != null) {
              break label704;
            }
            paramcuo = "";
            label341:
            if (paramString1 != null) {
              break label712;
            }
            paramString1 = "";
            label348:
            if (localcui.mBH != 7) {
              break label720;
            }
            ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dyi(), new Object[] { Integer.valueOf(1), paramcuo, Integer.valueOf(paramp.dyi()) });
            label403:
            paramcuo = paramp.dyh();
            if (paramcuo == null) {
              break label1091;
            }
            if (paramcuo.field_firstControlTime == 0)
            {
              paramcuo.field_firstControlTime = localcui.CreateTime;
              af.dtx().b(paramcuo.field_snsId, paramcuo);
            }
            paramcuo = paramcuo.dxz();
            if (paramInt3 != 2) {
              break label829;
            }
            if (paramcuo == null) {
              break label804;
            }
            localcuj.Emi.CxV = paramcuo.CwV;
            if (paramcuo.CwV == null) {
              break label778;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramcuo.CwV.Eem), Integer.valueOf(paramcuo.CwV.Eeh) });
            if ((paramcuo.CwV.Eem != 0L) || (paramcuo.CwV.Eeh != 0)) {
              break label1091;
            }
            com.tencent.mm.plugin.report.service.h.vKh.dB(955, 9);
            i = paramInt1;
          }
          label549:
          paramString2 = com.tencent.mm.b.g.getMessageDigest(bt.GC().getBytes());
          paramcuo = paramString2;
          if (paramp.Nb(32)) {
            paramcuo = "_AD_TAG_".concat(String.valueOf(paramString2));
          }
          if (!af.dtt().a(paramcuo, localcuj)) {
            break label1125;
          }
          if (!ad.aoC(paramcuo)) {
            break label1097;
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new j(localcuj, paramcuo, paramString1, i), 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(95911);
        return null;
        l = paramcuo.Emc;
        break;
        if (paramcuo == null) {}
        for (i = 0;; i = paramcuo.Ema)
        {
          localcui.ElZ = i;
          break;
        }
        label686:
        paramString1 = paramcuo.Username;
        break label189;
        label694:
        paramString1 = paramp.dxu();
        paramInt1 = 0;
        break label334;
        label704:
        paramcuo = paramString1.dAM;
        break label341;
        label712:
        paramString1 = paramString1.dvK;
        break label348;
        label720:
        if (localcui.mBH != 8) {
          break label403;
        }
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dyi(), new Object[] { Integer.valueOf(2), paramcuo, Integer.valueOf(paramp.dyi()) });
        break label403;
        label778:
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 7);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "remindInfo is null!");
        i = paramInt1;
        break label549;
        label804:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "remindInfo group is null!");
        com.tencent.mm.plugin.report.service.h.vKh.dB(955, 5);
        i = paramInt1;
        break label549;
        label829:
        if (com.tencent.mm.plugin.sns.ui.widget.e.hA(paramInt2, 8))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "sendAtFriend");
          if (paramcuo != null)
          {
            if (paramcuo.CwU != null)
            {
              localcuj.Emi.CxV = paramcuo.CwU;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramcuo.CwU.Eem), Integer.valueOf(paramcuo.CwU.Eeh) });
              if ((paramcuo.CwU.Eem != 0L) || (paramcuo.CwU.Eeh != 0)) {
                break label1091;
              }
              com.tencent.mm.plugin.report.service.h.vKh.dB(955, 8);
              i = paramInt1;
              break label549;
            }
            if (paramcuo.CwV != null)
            {
              localcuj.Emi.CxV = paramcuo.CwV;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramcuo.CwV.Eem), Integer.valueOf(paramcuo.CwV.Eeh) });
              if ((paramcuo.CwV.Eem != 0L) || (paramcuo.CwV.Eeh != 0)) {
                break label1091;
              }
              com.tencent.mm.plugin.report.service.h.vKh.dB(955, 8);
              i = paramInt1;
              break label549;
            }
            com.tencent.mm.plugin.report.service.h.vKh.dB(955, 6);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "remindInfo is null!");
            i = paramInt1;
            break label549;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "remindInfo group is null!");
          com.tencent.mm.plugin.report.service.h.vKh.dB(955, 5);
        }
        label1091:
        i = paramInt1;
        break label549;
        label1097:
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new n(localcuj, paramcuo), 0);
        continue;
        label1125:
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsService", "can not add Comment");
      }
    }
    
    public static int dtY()
    {
      AppMethodBeat.i(95906);
      if (wIK != -1)
      {
        i = wIK;
        AppMethodBeat.o(95906);
        return i;
      }
      wIK = com.tencent.mm.plugin.sns.data.q.dsa();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "getTimelineControlFlag %d", new Object[] { Integer.valueOf(wIK) });
      int i = wIK;
      AppMethodBeat.o(95906);
      return i;
    }
    
    public final void N(long paramLong, int paramInt)
    {
      AppMethodBeat.i(95905);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramInt > 0)
      {
        this.wIP = paramInt;
        com.tencent.mm.plugin.sns.data.q.Mb(paramInt);
      }
      if (paramLong == 0L)
      {
        AppMethodBeat.o(95905);
        return;
      }
      this.wIQ = paramLong;
      AppMethodBeat.o(95905);
    }
    
    public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
    {
      AppMethodBeat.i(95902);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (paramInt1 == 2)
      {
        if (!z.aoz(paramString))
        {
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == as.wKh)
        {
          this.wIV.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == as.wKi)
        {
          as.b(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == as.wKj)
        {
          as.f(paramString, paramBoolean, paramInt3);
          AppMethodBeat.o(95902);
        }
      }
      else if (paramInt1 == 1)
      {
        if (!x.aow("@__weixintimtline"))
        {
          AppMethodBeat.o(95902);
          return;
        }
        af.dtD().wJJ = paramInt2;
        if (paramInt2 == as.wKh)
        {
          this.wIV.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == as.wKi)
        {
          af.dtD().wJM = true;
          as.b(paramString, paramBoolean, paramInt3, this.wIR, paramInt1);
        }
      }
      AppMethodBeat.o(95902);
    }
    
    public final void a(int paramInt, String paramString, i.a arg3)
    {
      AppMethodBeat.i(95898);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
      af.dtt().fki = u.aqG();
      af.dtt().dsV();
      af.dtq().drS();
      if (this.gVL.isEmpty())
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(211, this);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(212, this);
      }
      if (!this.gVL.containsKey(???))
      {
        if (paramInt == 1) {
          this.gVL.put(???, "@__weixintimtline");
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
          this.gVL.put(???, paramString);
          break;
        }
        if (paramInt == 4)
        {
          this.gVL.put(???, "@__classify_timeline");
          break;
        }
        if (paramInt == 5)
        {
          this.gVL.put(???, "");
          break;
        }
        this.gVL.put(???, "");
        break;
        synchronized (this.wIL)
        {
          this.wIL.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.wIM)
        {
          if (!this.wIM.containsKey(paramString)) {
            this.wIM.put(paramString, Integer.valueOf(dtX()));
          }
          z.aoA(paramString);
          this.wIS.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        synchronized (this.wIN)
        {
          this.wIN.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.wIO)
        {
          if (!this.wIO.containsKey(paramString)) {
            this.wIO.put(paramString, Integer.valueOf(dtX()));
          }
          z.aoA(paramString);
          this.wIS.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        this.wIQ = 0L;
        this.wIP = dtX();
        x.aox("@__weixintimtline");
      }
    }
    
    public final void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95901);
      if (com.tencent.mm.platformtools.ab.hVj)
      {
        AppMethodBeat.o(95901);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
      if (paramInt1 == 2)
      {
        if (!z.aoz(paramString))
        {
          AppMethodBeat.o(95901);
          return;
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.afA().gcy;
        int j = as.wKg;
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
        if (!x.aow("@__weixintimtline"))
        {
          AppMethodBeat.o(95901);
          return;
        }
        af.dtD().wJJ = as.wKj;
        af.dtD().wJQ = af.dtu().g(0L, 1, true);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(68377, "");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new x(0L, 0L, 0), 0);
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!m.aow("@__classify_timeline"))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new m(""), 0);
          AppMethodBeat.o(95901);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!z.aoz(paramString))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new z(paramString, 0L, paramBoolean, paramInt2, as.wKg, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95901);
    }
    
    public final boolean a(i.a parama, int paramInt)
    {
      AppMethodBeat.i(95899);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsService", "closeServer");
      this.gVL.remove(parama);
      if (((paramInt == 2) || (paramInt == 10)) && (this.wIS.size() > 0)) {
        this.wIS.removeLast();
      }
      if (this.gVL.isEmpty())
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.b(211, this);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.b(212, this);
        an.release();
        p.release();
        new ap(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95894);
            am.a.a(am.a.this);
            AppMethodBeat.o(95894);
          }
        }, 5000L);
        aj.dtP();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "close finish");
      }
      AppMethodBeat.o(95899);
      return true;
    }
    
    public final void anw(String paramString)
    {
      AppMethodBeat.i(95914);
      String str1 = af.getAccSnsPath();
      String str2 = paramString + "bg_";
      String str3 = paramString + "tbg_";
      if (com.tencent.mm.vfs.i.eK(str2))
      {
        com.tencent.mm.vfs.i.deleteFile(an.iF(str1, paramString) + str3);
        com.tencent.mm.vfs.i.aQ(an.iF(str1, paramString), str2, str3);
      }
      AppMethodBeat.o(95914);
    }
    
    public final int aoJ(String paramString)
    {
      AppMethodBeat.i(95903);
      synchronized (this.wIM)
      {
        if (this.wIM.containsKey(paramString))
        {
          i = ((Integer)this.wIM.get(paramString)).intValue();
          if (i > 0) {}
          for (;;)
          {
            AppMethodBeat.o(95903);
            return i;
            i = com.tencent.mm.plugin.sns.data.q.dsb();
          }
        }
        int i = com.tencent.mm.plugin.sns.data.q.dsb();
        AppMethodBeat.o(95903);
        return i;
      }
    }
    
    public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95900);
      if (com.tencent.mm.platformtools.ab.hVj)
      {
        AppMethodBeat.o(95900);
        return;
      }
      synchronized (this.wIL)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.wIQ), this.wIL });
        if (paramInt1 != 2) {
          break label244;
        }
        if (!z.aoz(paramString))
        {
          AppMethodBeat.o(95900);
          return;
        }
      }
      long l = 0L;
      synchronized (this.wIL)
      {
        if (this.wIL.containsKey(paramString)) {
          l = ((Long)this.wIL.get(paramString)).longValue();
        }
        if (l == 0L)
        {
          z.aoA(paramString);
          AppMethodBeat.o(95900);
          return;
        }
      }
      com.tencent.mm.kernel.g.afC();
      ??? = com.tencent.mm.kernel.g.afA().gcy;
      int j = as.wKg;
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
        if (!x.aow("@__weixintimtline"))
        {
          AppMethodBeat.o(95900);
          return;
        }
        if (this.wIQ == 0L)
        {
          x.aox("@__weixintimtline");
          AppMethodBeat.o(95900);
          return;
        }
        af.dtD().wJJ = as.wKj;
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new x(this.wIQ, 0L, 0), 0);
        AppMethodBeat.o(95900);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!m.aow("@__classify_timeline"))
          {
            AppMethodBeat.o(95900);
            return;
          }
          if (this.wIQ == 0L)
          {
            m.aox("@__classify_timeline");
            AppMethodBeat.o(95900);
            return;
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new m(""), 0);
          AppMethodBeat.o(95900);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!z.aoz(paramString))
          {
            AppMethodBeat.o(95900);
            return;
          }
          l = 0L;
          synchronized (this.wIN)
          {
            if (this.wIN.containsKey(paramString)) {
              l = ((Long)this.wIN.get(paramString)).longValue();
            }
            if (l == 0L)
            {
              z.aoA(paramString);
              AppMethodBeat.o(95900);
              return;
            }
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new z(paramString, l, paramBoolean, paramInt2, as.wKg, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95900);
    }
    
    public final int dtX()
    {
      AppMethodBeat.i(95904);
      if (this.wIP > 0)
      {
        i = this.wIP;
        AppMethodBeat.o(95904);
        return i;
      }
      int i = com.tencent.mm.plugin.sns.data.q.dsb();
      AppMethodBeat.o(95904);
      return i;
    }
    
    public final Intent f(Intent paramIntent, String paramString)
    {
      AppMethodBeat.i(95897);
      paramIntent.putExtra("sns_userName", paramString);
      if ((this.wIS != null) && (this.wIS.contains(paramString)))
      {
        paramIntent.addFlags(536870912);
        paramIntent.addFlags(67108864);
        AppMethodBeat.o(95897);
        return paramIntent;
      }
      AppMethodBeat.o(95897);
      return paramIntent;
    }
    
    public final void i(String paramString, ArrayList<com.tencent.mm.plugin.sns.j.b> paramArrayList)
    {
      AppMethodBeat.i(95896);
      this.wIT.put(paramString, paramArrayList);
      AppMethodBeat.o(95896);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(95907);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
      if ((paramn != null) && ((paramn instanceof x)) && (((x)paramn).dsS())) {}
      for (int i = 1; i != 0; i = 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "skip by preload unread feeds");
        AppMethodBeat.o(95907);
        return;
      }
      label437:
      label566:
      label974:
      label980:
      if ((paramn.getType() == 212) || (paramn.getType() == 211))
      {
        com.tencent.mm.plugin.sns.c.b localb = (com.tencent.mm.plugin.sns.c.b)paramn;
        paramString = new ArrayList(this.gVL.keySet());
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
          if (this.gVL.containsKey(paramn))
          {
            ??? = (String)this.gVL.get(paramn);
            if ((localb.getUserName().equals(???)) && (localb.drC()))
            {
              ??? = com.tencent.mm.plugin.sns.data.q.su(aj.wET);
              str = com.tencent.mm.plugin.sns.data.q.su(aj.wEU);
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
          if (this.gVL.containsKey(???))
          {
            paramString = (String)this.gVL.get(???);
            if (localb.getUserName().equals(paramString))
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
              if (localb.drI() == 0L)
              {
                paramString = "";
                if (!localb.drB()) {
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
                    l = ((z)???).wEU;
                    i = ((z)???).wEW;
                    if (((z)???).wGp == 10)
                    {
                      if (i > 0) {}
                      synchronized (this.wIO)
                      {
                        for (;;)
                        {
                          this.wIO.put(paramn, Integer.valueOf(i));
                          if (l == 0L) {
                            break;
                          }
                          synchronized (this.wIN)
                          {
                            this.wIN.put(paramn, Long.valueOf(l));
                          }
                        }
                      }
                    }
                  }
                  if (i > 0) {}
                  synchronized (this.wIM)
                  {
                    for (;;)
                    {
                      this.wIM.put(paramn, Integer.valueOf(i));
                      if (l == 0L) {
                        break;
                      }
                      synchronized (this.wIL)
                      {
                        this.wIL.put(paramn, Long.valueOf(l));
                      }
                    }
                  }
                }
                paramn = (x)paramn;
                if (localb.drC()) {
                  sP(paramn.wET);
                }
                for (;;)
                {
                  i = paramn.wEX;
                  if (wIK != i) {
                    com.tencent.mm.plugin.sns.data.q.Ma(i);
                  }
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "updateTimelineControlFlag %d", new Object[] { Integer.valueOf(i) });
                  wIK = i;
                  break;
                  N(paramn.wEU, paramn.wEW);
                }
                paramString = com.tencent.mm.plugin.sns.data.q.su(localb.drI());
                break label566;
              }
              if (localb.drC())
              {
                bool = false;
                if (localb.drD() == as.wKh)
                {
                  aj.wIC = aj.wET;
                  bool = true;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsService", "fetchType:%s, preUpReady:%s, firstPage:%s", new Object[] { Integer.valueOf(localb.drD()), Boolean.valueOf(this.wIV.wKk), Boolean.valueOf(bool) });
                paramString = com.tencent.mm.plugin.sns.data.q.su(aj.wET);
                str = com.tencent.mm.plugin.sns.data.q.su(aj.wEU);
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
    
    public final void sP(long paramLong)
    {
      AppMethodBeat.i(179094);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsService", "setTimeFirstId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong == 0L)
      {
        AppMethodBeat.o(179094);
        return;
      }
      this.wIR = paramLong;
      AppMethodBeat.o(179094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am
 * JD-Core Version:    0.7.0.1
 */