package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class am
{
  private static final int xVe;
  
  static
  {
    AppMethodBeat.i(95919);
    xVe = com.tencent.mm.m.g.ZY().getInt("SnsUseWeiShiShootingEntranceDisplayTimes", 0);
    AppMethodBeat.o(95919);
  }
  
  public static boolean dIu()
  {
    AppMethodBeat.i(95917);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRG, Integer.valueOf(0))).intValue();
    ac.d("MicroMsg.SnsLogic", "checkWeishiExposeCount now=%d limit=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(xVe) });
    if (i < xVe)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRG, Integer.valueOf(i + 1));
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
      int i = bs.getInt((String)paramArrayList.next(), 0);
      if (i != 0)
      {
        Object localObject = af.dHR().Ph(i);
        if (localObject != null)
        {
          TimeLineObject localTimeLineObject = ((p)localObject).dLV();
          if ((localTimeLineObject != null) && (localTimeLineObject.FQo != null) && (localTimeLineObject.FQo.Ety == 26))
          {
            localTimeLineObject.FQo.EtB = paramString;
            af.dHR().b(i, (p)localObject);
            localObject = new rf();
            ((rf)localObject).dum.dun = i;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(95916);
  }
  
  public static boolean fV(Context paramContext)
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
      boolean bool2 = bs.lr(com.tencent.d.f.e.bytesToHexString(localMessageDigest.digest()), "2A281593D71DF33374E6124E9106DF08");
      if (!bool2) {
        break label87;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ac.w("MicroMsg.SnsLogic", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
      }
    }
    AppMethodBeat.o(95918);
    return bool1;
  }
  
  public static final class a
    implements com.tencent.mm.ak.g, com.tencent.mm.plugin.sns.b.i
  {
    public static int xVf = -1;
    private Map<i.a, String> hwk;
    private Map<String, Long> xVg;
    private Map<String, Integer> xVh;
    private Map<String, Long> xVi;
    private Map<String, Integer> xVj;
    private int xVk;
    public long xVl;
    public long xVm;
    private LinkedList<String> xVn;
    public Map<String, ArrayList<com.tencent.mm.plugin.sns.i.b>> xVo;
    public Map<String, Integer> xVp;
    private at xVq;
    
    public a()
    {
      AppMethodBeat.i(95895);
      this.xVg = new HashMap();
      this.xVh = new HashMap();
      this.xVi = new HashMap();
      this.xVj = new HashMap();
      this.xVk = 0;
      this.xVl = 0L;
      this.xVm = 0L;
      this.hwk = new HashMap();
      this.xVn = new LinkedList();
      this.xVo = new HashMap();
      this.xVp = new HashMap();
      this.xVq = new at();
      AppMethodBeat.o(95895);
    }
    
    public static daa a(p paramp, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(95909);
      paramp = b(paramp, paramInt1, paramString, null, 0, paramInt2, "");
      AppMethodBeat.o(95909);
      return paramp;
    }
    
    public static daa a(p paramp, int paramInt1, String paramString1, daa paramdaa, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95910);
      paramp = b(paramp, paramInt1, paramString1, paramdaa, paramInt2, paramInt3, paramString2);
      AppMethodBeat.o(95910);
      return paramp;
    }
    
    public static daa a(p paramp, int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(95912);
      czu localczu = new czu();
      localczu.hkR = paramString1;
      localczu.CreateTime = ((int)(bs.eWj() / 1000L));
      localczu.FIW = u.axy();
      localczu.Fwn = u.axw();
      localczu.sVo = paramInt2;
      localczu.FIX = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramp.field_userName);
      localczu.Exe = paramp.field_userName;
      localczu.ndI = paramInt1;
      czv localczv;
      String str;
      if (paramp.Pe(32))
      {
        localczu.FJa = 0L;
        paramString1 = new czu();
        paramString1.Fwn = paramString2;
        if (!bs.isNullOrNil(paramString1.Fwn)) {
          paramString1.FIW = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramString1.Fwn);
        }
        localczv = new czv();
        localczv.Id = paramp.field_snsId;
        localczv.FJh = localczu;
        localczv.FJi = paramString1;
        str = "";
        if (paramp.Pe(32))
        {
          paramString1 = paramp.dFQ();
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
          if (localczu.ndI != 7) {
            break label398;
          }
          ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dMF(), new Object[] { Integer.valueOf(1), paramString2, Integer.valueOf(paramp.dMF()) });
          str = paramString1;
        }
        label273:
        paramString2 = com.tencent.mm.b.g.getMessageDigest(bs.Gn().getBytes());
        paramString1 = paramString2;
        if (paramp.Pe(32)) {
          paramString1 = "_AD_TAG_".concat(String.valueOf(paramString2));
        }
        if (!af.dHQ().a(paramString1, localczv, str)) {
          break label490;
        }
        if (!ad.atO(paramString1)) {
          break label462;
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new j(localczv, paramString1, str, 0), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(95912);
        return null;
        localczu.FIY = 0;
        break;
        label382:
        paramString2 = paramString1.dyy;
        break label208;
        label390:
        paramString1 = paramString1.dtx;
        break label215;
        label398:
        str = paramString1;
        if (localczu.ndI != 8) {
          break label273;
        }
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dMF(), new Object[] { Integer.valueOf(2), paramString2, Integer.valueOf(paramp.dMF()) });
        str = paramString1;
        break label273;
        label462:
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new n(localczv, paramString1), 0);
        continue;
        label490:
        ac.e("MicroMsg.SnsService", "can not add Comment");
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
      czu localczu = new czu();
      localczu.hkR = paramString2;
      localczu.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
      localczu.FIW = u.axy();
      localczu.Fwn = u.axw();
      localczu.sVo = paramInt2;
      localczu.FIX = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramString1);
      localczu.Exe = paramString1;
      localczu.ndI = paramInt1;
      paramString2 = new czv();
      paramString2.Id = paramp.field_snsId;
      paramString2.FJh = localczu;
      paramString2.FJi = new czu();
      String str = com.tencent.mm.b.g.getMessageDigest(bs.Gn().getBytes());
      long l = paramp.field_snsId;
      try
      {
        ac.v("MicroMsg.SnsService", "comment stg inserted");
        paramp = new com.tencent.mm.plugin.sns.storage.j();
        paramp.field_talker = paramString1;
        paramp.field_snsID = l;
        paramp.field_createTime = ((int)(System.currentTimeMillis() / 1000L));
        paramp.field_curActionBuf = localczu.toByteArray();
        paramp.field_type = paramInt1;
        paramp.field_isSend = true;
        paramp.field_isRead = 1;
        af.dHW().insert(paramp);
        af.dHQ().a(str, paramString2);
        AppMethodBeat.o(95913);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.SnsService", paramString1, "", new Object[0]);
        }
      }
    }
    
    public static void atW(String paramString)
    {
      AppMethodBeat.i(95908);
      Object localObject = af.dHQ();
      if (bs.isNullOrNil(((ad)localObject).fnC)) {
        ((ad)localObject).fnC = u.axw();
      }
      localObject = ((ad)localObject).fnC;
      p localp = com.tencent.mm.plugin.sns.storage.h.auS(paramString);
      for (;;)
      {
        try
        {
          SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
          Iterator localIterator = localSnsObject.LikeUserList.iterator();
          if (localIterator.hasNext())
          {
            daa localdaa = (daa)localIterator.next();
            if (!localdaa.Username.equals(localObject)) {
              continue;
            }
            localSnsObject.LikeUserList.remove(localdaa);
            localSnsObject.LikeCount -= 1;
            localp.field_attrBuf = localSnsObject.toByteArray();
            if (!localp.Pe(32)) {
              continue;
            }
            af.dHU().replace(localp.dME());
          }
        }
        catch (Exception localException)
        {
          continue;
          String str = localException.dyy;
          continue;
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new q(com.tencent.mm.plugin.sns.storage.x.asL(paramString), 5), 0);
          AppMethodBeat.o(95908);
        }
        if (!af.dHQ().xq(com.tencent.mm.plugin.sns.storage.x.asL(paramString))) {
          continue;
        }
        if (!localp.Pe(32)) {
          continue;
        }
        localObject = localp.dFQ();
        if (localObject != null) {
          continue;
        }
        localObject = "";
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, localp.dMF(), new Object[] { Integer.valueOf(0), localObject, Integer.valueOf(localp.dMF()) });
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new q(com.tencent.mm.plugin.sns.storage.x.asL(paramString), 7), 0);
        AppMethodBeat.o(95908);
        return;
        af.dHR().K(localp);
      }
    }
    
    private static daa b(p paramp, int paramInt1, String paramString1, daa paramdaa, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(95911);
      czu localczu = new czu();
      localczu.hkR = paramString1;
      localczu.CreateTime = ((int)(bs.eWj() / 1000L));
      localczu.FIW = u.axy();
      localczu.Fwn = u.axw();
      localczu.sVo = 0;
      localczu.FIX = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramp.field_userName);
      localczu.Exe = paramp.field_userName;
      localczu.ndI = paramInt1;
      localczu.FJd = paramInt2;
      long l;
      label189:
      czv localczv;
      int i;
      if (paramp.Pe(32)) {
        if (paramdaa == null)
        {
          l = 0L;
          localczu.FJa = l;
          if (!bs.isNullOrNil(paramString2))
          {
            paramString1 = new dag();
            paramString1.Md5 = paramString2;
            localczu.FJe = new LinkedList();
            localczu.FJe.add(paramString1);
            localczu.FJf = 1;
          }
          paramString2 = new czu();
          if (paramdaa != null) {
            break label686;
          }
          paramString1 = "";
          paramString2.Fwn = paramString1;
          if (!bs.isNullOrNil(paramString2.Fwn)) {
            paramString2.FIW = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramString2.Fwn);
          }
          localczv = new czv();
          localczv.Id = paramp.field_snsId;
          localczv.FJh = localczu;
          localczv.FJi = paramString2;
          paramString1 = "";
          i = 0;
          if (paramp.Pe(32))
          {
            ac.i("MicroMsg.SnsService", "sendComment, sourceScene=" + paramInt3 + ", type=" + paramInt1 + ", flag=" + paramInt2);
            if (paramInt3 != 2) {
              break label694;
            }
            paramString1 = paramp.dLS();
            paramInt1 = 1;
            label334:
            if (paramString1 != null) {
              break label704;
            }
            paramdaa = "";
            label341:
            if (paramString1 != null) {
              break label712;
            }
            paramString1 = "";
            label348:
            if (localczu.ndI != 7) {
              break label720;
            }
            ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dMF(), new Object[] { Integer.valueOf(1), paramdaa, Integer.valueOf(paramp.dMF()) });
            label403:
            paramdaa = paramp.dME();
            if (paramdaa == null) {
              break label1091;
            }
            if (paramdaa.field_firstControlTime == 0)
            {
              paramdaa.field_firstControlTime = localczu.CreateTime;
              af.dHU().b(paramdaa.field_snsId, paramdaa);
            }
            paramdaa = paramdaa.dLW();
            if (paramInt3 != 2) {
              break label829;
            }
            if (paramdaa == null) {
              break label804;
            }
            localczv.FJh.DQr = paramdaa.DPr;
            if (paramdaa.DPr == null) {
              break label778;
            }
            ac.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdaa.DPr.FBm), Integer.valueOf(paramdaa.DPr.FBh) });
            if ((paramdaa.DPr.FBm != 0L) || (paramdaa.DPr.FBh != 0)) {
              break label1091;
            }
            com.tencent.mm.plugin.report.service.h.wUl.dB(955, 9);
            i = paramInt1;
          }
          label549:
          paramString2 = com.tencent.mm.b.g.getMessageDigest(bs.Gn().getBytes());
          paramdaa = paramString2;
          if (paramp.Pe(32)) {
            paramdaa = "_AD_TAG_".concat(String.valueOf(paramString2));
          }
          if (!af.dHQ().a(paramdaa, localczv)) {
            break label1125;
          }
          if (!ad.atO(paramdaa)) {
            break label1097;
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new j(localczv, paramdaa, paramString1, i), 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(95911);
        return null;
        l = paramdaa.FJb;
        break;
        if (paramdaa == null) {}
        for (i = 0;; i = paramdaa.FIZ)
        {
          localczu.FIY = i;
          break;
        }
        label686:
        paramString1 = paramdaa.Username;
        break label189;
        label694:
        paramString1 = paramp.dFQ();
        paramInt1 = 0;
        break label334;
        label704:
        paramdaa = paramString1.dyy;
        break label341;
        label712:
        paramString1 = paramString1.dtx;
        break label348;
        label720:
        if (localczu.ndI != 8) {
          break label403;
        }
        ((d)com.tencent.mm.kernel.g.ab(d.class)).a(11855, paramp.dMF(), new Object[] { Integer.valueOf(2), paramdaa, Integer.valueOf(paramp.dMF()) });
        break label403;
        label778:
        com.tencent.mm.plugin.report.service.h.wUl.dB(955, 7);
        ac.i("MicroMsg.SnsService", "remindInfo is null!");
        i = paramInt1;
        break label549;
        label804:
        ac.i("MicroMsg.SnsService", "remindInfo group is null!");
        com.tencent.mm.plugin.report.service.h.wUl.dB(955, 5);
        i = paramInt1;
        break label549;
        label829:
        if (com.tencent.mm.plugin.sns.ui.widget.e.hJ(paramInt2, 8))
        {
          ac.i("MicroMsg.SnsService", "sendAtFriend");
          if (paramdaa != null)
          {
            if (paramdaa.DPq != null)
            {
              localczv.FJh.DQr = paramdaa.DPq;
              ac.i("MicroMsg.SnsService", "timeline remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdaa.DPq.FBm), Integer.valueOf(paramdaa.DPq.FBh) });
              if ((paramdaa.DPq.FBm != 0L) || (paramdaa.DPq.FBh != 0)) {
                break label1091;
              }
              com.tencent.mm.plugin.report.service.h.wUl.dB(955, 8);
              i = paramInt1;
              break label549;
            }
            if (paramdaa.DPr != null)
            {
              localczv.FJh.DQr = paramdaa.DPr;
              ac.i("MicroMsg.SnsService", "atFriend remindInfo aid64 %d, aid %d", new Object[] { Long.valueOf(paramdaa.DPr.FBm), Integer.valueOf(paramdaa.DPr.FBh) });
              if ((paramdaa.DPr.FBm != 0L) || (paramdaa.DPr.FBh != 0)) {
                break label1091;
              }
              com.tencent.mm.plugin.report.service.h.wUl.dB(955, 8);
              i = paramInt1;
              break label549;
            }
            com.tencent.mm.plugin.report.service.h.wUl.dB(955, 6);
            ac.i("MicroMsg.SnsService", "remindInfo is null!");
            i = paramInt1;
            break label549;
          }
          ac.i("MicroMsg.SnsService", "remindInfo group is null!");
          com.tencent.mm.plugin.report.service.h.wUl.dB(955, 5);
        }
        label1091:
        i = paramInt1;
        break label549;
        label1097:
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new n(localczv, paramdaa), 0);
        continue;
        label1125:
        ac.e("MicroMsg.SnsService", "can not add Comment");
      }
    }
    
    public static int dIw()
    {
      AppMethodBeat.i(95906);
      if (xVf != -1)
      {
        i = xVf;
        AppMethodBeat.o(95906);
        return i;
      }
      xVf = com.tencent.mm.plugin.sns.data.q.dGz();
      ac.i("MicroMsg.SnsService", "getTimelineControlFlag %d", new Object[] { Integer.valueOf(xVf) });
      int i = xVf;
      AppMethodBeat.o(95906);
      return i;
    }
    
    public final void Q(long paramLong, int paramInt)
    {
      AppMethodBeat.i(95905);
      ac.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramInt > 0)
      {
        this.xVk = paramInt;
        com.tencent.mm.plugin.sns.data.q.Od(paramInt);
      }
      if (paramLong == 0L)
      {
        AppMethodBeat.o(95905);
        return;
      }
      this.xVl = paramLong;
      AppMethodBeat.o(95905);
    }
    
    public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
    {
      AppMethodBeat.i(95902);
      ac.d("MicroMsg.SnsService", "doOtherList fetchType:%s, type:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (paramInt1 == 2)
      {
        if (!z.atL(paramString))
        {
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == at.xWM)
        {
          this.xVq.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == at.xWN)
        {
          at.b(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == at.xWO)
        {
          at.f(paramString, paramBoolean, paramInt3);
          AppMethodBeat.o(95902);
        }
      }
      else if (paramInt1 == 1)
      {
        if (!x.atI("@__weixintimtline"))
        {
          AppMethodBeat.o(95902);
          return;
        }
        af.dIa().xWo = paramInt2;
        if (paramInt2 == at.xWM)
        {
          this.xVq.a(paramString, paramBoolean, paramInt3, paramLong, paramInt1);
          AppMethodBeat.o(95902);
          return;
        }
        if (paramInt2 == at.xWN)
        {
          af.dIa().xWr = true;
          at.b(paramString, paramBoolean, paramInt3, this.xVm, paramInt1);
        }
      }
      AppMethodBeat.o(95902);
    }
    
    public final void a(int paramInt, String paramString, i.a arg3)
    {
      AppMethodBeat.i(95898);
      ac.i("MicroMsg.SnsService", "startServer " + paramInt + " " + ???);
      af.dHQ().fnC = u.axw();
      af.dHQ().dHs();
      af.dHN().dGr();
      if (this.hwk.isEmpty())
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(211, this);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(212, this);
      }
      if (!this.hwk.containsKey(???))
      {
        if (paramInt == 1) {
          this.hwk.put(???, "@__weixintimtline");
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
          this.hwk.put(???, paramString);
          break;
        }
        if (paramInt == 4)
        {
          this.hwk.put(???, "@__classify_timeline");
          break;
        }
        if (paramInt == 5)
        {
          this.hwk.put(???, "");
          break;
        }
        this.hwk.put(???, "");
        break;
        synchronized (this.xVg)
        {
          this.xVg.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.xVh)
        {
          if (!this.xVh.containsKey(paramString)) {
            this.xVh.put(paramString, Integer.valueOf(dIv()));
          }
          z.atM(paramString);
          this.xVn.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        synchronized (this.xVi)
        {
          this.xVi.put(paramString, Long.valueOf(0L));
        }
        synchronized (this.xVj)
        {
          if (!this.xVj.containsKey(paramString)) {
            this.xVj.put(paramString, Integer.valueOf(dIv()));
          }
          z.atM(paramString);
          this.xVn.add(paramString);
          AppMethodBeat.o(95898);
          return;
          paramString = finally;
          AppMethodBeat.o(95898);
          throw paramString;
        }
        this.xVl = 0L;
        this.xVk = dIv();
        x.atJ("@__weixintimtline");
      }
    }
    
    public final void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95901);
      if (ab.ivn)
      {
        AppMethodBeat.o(95901);
        return;
      }
      ac.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
      if (paramInt1 == 2)
      {
        if (!z.atL(paramString))
        {
          AppMethodBeat.o(95901);
          return;
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.agQ().ghe;
        int j = at.xWL;
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
        if (!x.atI("@__weixintimtline"))
        {
          AppMethodBeat.o(95901);
          return;
        }
        af.dIa().xWo = at.xWO;
        af.dIa().xWv = af.dHR().g(0L, 1, true);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(68377, "");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new x(0L, 0L, 0), 0);
        AppMethodBeat.o(95901);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!m.atI("@__classify_timeline"))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new m(""), 0);
          AppMethodBeat.o(95901);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!z.atL(paramString))
          {
            AppMethodBeat.o(95901);
            return;
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new z(paramString, 0L, paramBoolean, paramInt2, at.xWL, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95901);
    }
    
    public final boolean a(i.a parama, int paramInt)
    {
      AppMethodBeat.i(95899);
      ac.d("MicroMsg.SnsService", "closeServer");
      this.hwk.remove(parama);
      if (((paramInt == 2) || (paramInt == 10)) && (this.xVn.size() > 0)) {
        this.xVn.removeLast();
      }
      if (this.hwk.isEmpty())
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.b(211, this);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.b(212, this);
        an.release();
        p.release();
        new ao(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95894);
            am.a.a(am.a.this);
            AppMethodBeat.o(95894);
          }
        }, 5000L);
        aj.dIn();
        ac.i("MicroMsg.SnsService", "close finish");
      }
      AppMethodBeat.o(95899);
      return true;
    }
    
    public final void asI(String paramString)
    {
      AppMethodBeat.i(95914);
      String str1 = af.getAccSnsPath();
      String str2 = paramString + "bg_";
      String str3 = paramString + "tbg_";
      if (com.tencent.mm.vfs.i.eA(str2))
      {
        com.tencent.mm.vfs.i.deleteFile(an.jc(str1, paramString) + str3);
        com.tencent.mm.vfs.i.aT(an.jc(str1, paramString), str2, str3);
      }
      AppMethodBeat.o(95914);
    }
    
    public final int atV(String paramString)
    {
      AppMethodBeat.i(95903);
      synchronized (this.xVh)
      {
        if (this.xVh.containsKey(paramString))
        {
          i = ((Integer)this.xVh.get(paramString)).intValue();
          if (i > 0) {}
          for (;;)
          {
            AppMethodBeat.o(95903);
            return i;
            i = com.tencent.mm.plugin.sns.data.q.dGA();
          }
        }
        int i = com.tencent.mm.plugin.sns.data.q.dGA();
        AppMethodBeat.o(95903);
        return i;
      }
    }
    
    public final void b(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(95900);
      if (ab.ivn)
      {
        AppMethodBeat.o(95900);
        return;
      }
      synchronized (this.xVg)
      {
        ac.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(this.xVl), this.xVg });
        if (paramInt1 != 2) {
          break label244;
        }
        if (!z.atL(paramString))
        {
          AppMethodBeat.o(95900);
          return;
        }
      }
      long l = 0L;
      synchronized (this.xVg)
      {
        if (this.xVg.containsKey(paramString)) {
          l = ((Long)this.xVg.get(paramString)).longValue();
        }
        if (l == 0L)
        {
          z.atM(paramString);
          AppMethodBeat.o(95900);
          return;
        }
      }
      com.tencent.mm.kernel.g.agS();
      ??? = com.tencent.mm.kernel.g.agQ().ghe;
      int j = at.xWL;
      if (paramBoolean) {}
      for (int i = 4;; i = 8)
      {
        ((com.tencent.mm.ak.q)???).a(new z(paramString, l, paramBoolean, paramInt2, j, 0, i, paramInt1), 0);
        AppMethodBeat.o(95900);
        return;
      }
      label244:
      if (paramInt1 == 1)
      {
        if (!x.atI("@__weixintimtline"))
        {
          AppMethodBeat.o(95900);
          return;
        }
        if (this.xVl == 0L)
        {
          x.atJ("@__weixintimtline");
          AppMethodBeat.o(95900);
          return;
        }
        af.dIa().xWo = at.xWO;
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new x(this.xVl, 0L, 0), 0);
        AppMethodBeat.o(95900);
        return;
      }
      if (paramInt1 != 3)
      {
        if (paramInt1 == 4)
        {
          if (!m.atI("@__classify_timeline"))
          {
            AppMethodBeat.o(95900);
            return;
          }
          if (this.xVl == 0L)
          {
            m.atJ("@__classify_timeline");
            AppMethodBeat.o(95900);
            return;
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new m(""), 0);
          AppMethodBeat.o(95900);
          return;
        }
        if (paramInt1 == 10)
        {
          if (!z.atL(paramString))
          {
            AppMethodBeat.o(95900);
            return;
          }
          l = 0L;
          synchronized (this.xVi)
          {
            if (this.xVi.containsKey(paramString)) {
              l = ((Long)this.xVi.get(paramString)).longValue();
            }
            if (l == 0L)
            {
              z.atM(paramString);
              AppMethodBeat.o(95900);
              return;
            }
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new z(paramString, l, paramBoolean, paramInt2, at.xWL, 1, 64, paramInt1), 0);
        }
      }
      AppMethodBeat.o(95900);
    }
    
    public final int dIv()
    {
      AppMethodBeat.i(95904);
      if (this.xVk > 0)
      {
        i = this.xVk;
        AppMethodBeat.o(95904);
        return i;
      }
      int i = com.tencent.mm.plugin.sns.data.q.dGA();
      AppMethodBeat.o(95904);
      return i;
    }
    
    public final Intent f(Intent paramIntent, String paramString)
    {
      AppMethodBeat.i(95897);
      paramIntent.putExtra("sns_userName", paramString);
      if ((this.xVn != null) && (this.xVn.contains(paramString)))
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
      this.xVo.put(paramString, paramArrayList);
      AppMethodBeat.o(95896);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(95907);
      ac.i("MicroMsg.SnsService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
      if ((paramn != null) && ((paramn instanceof x)) && (((x)paramn).dHp())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ac.i("MicroMsg.SnsService", "skip by preload unread feeds");
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
        paramString = new ArrayList(this.hwk.keySet());
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
          if (this.hwk.containsKey(paramn))
          {
            ??? = (String)this.hwk.get(paramn);
            if ((localb.getUserName().equals(???)) && (localb.dGb()))
            {
              ??? = com.tencent.mm.plugin.sns.data.q.wX(aj.xRo);
              str = com.tencent.mm.plugin.sns.data.q.wX(aj.xRp);
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
          if (this.hwk.containsKey(???))
          {
            paramString = (String)this.hwk.get(???);
            if (localb.getUserName().equals(paramString))
            {
              ac.d("MicroMsg.SnsService", "notify ui ".concat(String.valueOf(paramString)));
              if (localb.dGh() == 0L)
              {
                paramString = "";
                if (!localb.dGa()) {
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
                    l = ((z)???).xRp;
                    i = ((z)???).xRr;
                    if (((z)???).xSJ == 10)
                    {
                      if (i > 0) {}
                      synchronized (this.xVj)
                      {
                        for (;;)
                        {
                          this.xVj.put(paramn, Integer.valueOf(i));
                          if (l == 0L) {
                            break;
                          }
                          synchronized (this.xVi)
                          {
                            this.xVi.put(paramn, Long.valueOf(l));
                          }
                        }
                      }
                    }
                  }
                  if (i > 0) {}
                  synchronized (this.xVh)
                  {
                    for (;;)
                    {
                      this.xVh.put(paramn, Integer.valueOf(i));
                      if (l == 0L) {
                        break;
                      }
                      synchronized (this.xVg)
                      {
                        this.xVg.put(paramn, Long.valueOf(l));
                      }
                    }
                  }
                }
                paramn = (x)paramn;
                if (localb.dGb()) {
                  xs(paramn.xRo);
                }
                for (;;)
                {
                  i = paramn.xRs;
                  if (xVf != i) {
                    com.tencent.mm.plugin.sns.data.q.Oc(i);
                  }
                  ac.i("MicroMsg.SnsService", "updateTimelineControlFlag %d", new Object[] { Integer.valueOf(i) });
                  xVf = i;
                  break;
                  Q(paramn.xRp, paramn.xRr);
                }
                paramString = com.tencent.mm.plugin.sns.data.q.wX(localb.dGh());
                break label566;
              }
              if (localb.dGb())
              {
                bool = false;
                if (localb.dGc() == at.xWM)
                {
                  aj.xUX = aj.xRo;
                  bool = true;
                }
                ac.i("MicroMsg.SnsService", "fetchType:%s, preUpReady:%s, firstPage:%s", new Object[] { Integer.valueOf(localb.dGc()), Boolean.valueOf(this.xVq.xWP), Boolean.valueOf(bool) });
                paramString = com.tencent.mm.plugin.sns.data.q.wX(aj.xRo);
                str = com.tencent.mm.plugin.sns.data.q.wX(aj.xRp);
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
    
    public final void xs(long paramLong)
    {
      AppMethodBeat.i(179094);
      ac.d("MicroMsg.SnsService", "setTimeFirstId %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong == 0L)
      {
        AppMethodBeat.o(179094);
        return;
      }
      this.xVm = paramLong;
      AppMethodBeat.o(179094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am
 * JD-Core Version:    0.7.0.1
 */