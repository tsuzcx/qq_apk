package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bss;
import com.tencent.mm.protocal.c.bsv;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.z;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static Comparator<btd> ooA = new a.1();
  private static final String ooy;
  private static LinkedHashMap<Long, Integer> ooz;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g.DQ();
    ooy = g.DP().cachePath + "sns_recvd_ad";
  }
  
  public static void Nl(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.bFV().f("adId", paramString, "adxml", 1);
  }
  
  private static int a(bto parambto)
  {
    n localn = af.bDF().gt(parambto.sGd);
    if (localn == null) {
      return parambto.mPL;
    }
    return localn.field_createTime;
  }
  
  private static cn a(bjk parambjk)
  {
    cn localcn;
    if (parambjk != null)
    {
      localcn = new cn();
      localcn.svZ = parambjk.tDl;
      if (localcn.svZ == null) {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
      }
    }
    else
    {
      return null;
    }
    localcn.svY = b(parambjk.tDk);
    return localcn;
  }
  
  private static String a(String paramString, bmk parambmk)
  {
    if ((parambmk == null) || (paramString == null))
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
      return paramString;
    }
    try
    {
      localObject1 = new z();
      ((z)localObject1).aH(parambmk.tFM.oY);
      if (((z)localObject1).ssm == null) {
        break label343;
      }
      localObject2 = "";
      localIterator = ((z)localObject1).ssm.iterator();
      parambmk = paramString;
    }
    catch (Exception parambmk)
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject1 = paramString;
        paramString = parambmk;
        continue;
        localObject1 = localObject2;
        break label348;
        Object localObject2 = paramString;
        continue;
        localObject2 = localObject1;
      }
    }
    localObject1 = parambmk;
    try
    {
      if (localIterator.hasNext())
      {
        localObject1 = parambmk;
        bsv localbsv = (bsv)localIterator.next();
        localObject1 = parambmk;
        if (localbsv.key == null) {
          break label338;
        }
        localObject1 = parambmk;
        String str = String.format("<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))", new Object[] { localbsv.key });
        localObject1 = parambmk;
        Object localObject3 = Pattern.compile(str).matcher(parambmk);
        localObject1 = parambmk;
        if (!((Matcher)localObject3).find()) {
          break label338;
        }
        localObject1 = parambmk;
        localObject3 = ((Matcher)localObject3).group(2);
        if (localObject3 == null) {
          break label338;
        }
        localObject1 = parambmk;
        if (((String)localObject3).length() <= 0) {
          break label338;
        }
        localObject1 = parambmk;
        parambmk = parambmk.replaceAll(str + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[] { localObject3 }), String.format("<$1>%s</%s>", new Object[] { localbsv.value, localObject3 }));
        localObject1 = parambmk;
        localObject2 = (String)localObject2 + localbsv.key + ":" + localbsv.value + ";";
        localObject1 = localObject2;
        break label348;
      }
      localObject1 = parambmk;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", new Object[] { localObject2 });
      localObject1 = parambmk;
      localObject2 = parambmk;
      if (bn.s(paramString, "ADInfo") != null) {
        break label328;
      }
      localObject1 = parambmk;
      y.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
      return paramString;
    }
    catch (Exception paramString) {}
    y.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramString, "replace error occurs!", new Object[0]);
    localObject2 = localObject1;
    label328:
    return localObject2;
  }
  
  private static void a(long paramLong, com.tencent.mm.plugin.sns.storage.a parama)
  {
    if ((!parama.oAv) || (bk.bl(parama.oAu))) {
      return;
    }
    parama = new m(paramLong, 1, parama.oAu);
    g.DQ();
    g.DO().dJT.a(parama, 0);
  }
  
  public static void a(bss parambss)
  {
    if (parambss == null)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      return;
    }
    if (parambss.tJi == null)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(parambss);
    af.bDI().a(parambss.tJi.sGd, locale);
  }
  
  public static void a(bss parambss, bmk parambmk)
  {
    if (parambss == null) {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
    }
    com.tencent.mm.plugin.sns.storage.e locale;
    do
    {
      return;
      if (parambss.tJi == null)
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        return;
      }
      locale = b(parambss);
    } while (locale == null);
    locale.field_adinfo = a(locale.field_adinfo, parambmk);
    if (af.bDI().gl(parambss.tJi.sGd))
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + parambss.tJi.sGd);
      af.bDI().b(parambss.tJi.sGd, locale);
      return;
    }
    y.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + parambss.tJi.sGd);
  }
  
  public static void a(buc parambuc)
  {
    a(b(parambuc));
  }
  
  public static void a(cn paramcn)
  {
    if (paramcn == null)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
      return;
    }
    if (paramcn.svY == null)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
      return;
    }
    if (paramcn.svY.tJi == null)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
      return;
    }
    Object localObject;
    if (!af.bDI().gl(paramcn.svY.tJi.sGd))
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "insert at adObject");
      int i = (int)(System.currentTimeMillis() / 1000L);
      if (paramcn.svY.tJi.tKa > 0) {
        i = ((btd)paramcn.svY.tJi.tKb.get(0)).mPL;
      }
      a(paramcn, i, i);
      localObject = af.bDI().gk(paramcn.svY.tJi.sGd);
      if (localObject != null)
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
        ((com.tencent.mm.plugin.sns.storage.e)localObject).field_localFlag |= 0x100;
        af.bDI().a(((com.tencent.mm.plugin.sns.storage.e)localObject).field_snsId, (com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "update at_adInfo and remindInfo");
      com.tencent.mm.plugin.sns.storage.e locale = af.bDI().gk(paramcn.svY.tJi.sGd);
      if (locale == null) {
        break;
      }
      locale.field_atAdinfo = aa.a(paramcn.svZ);
      bm localbm = locale.bGf();
      localObject = localbm;
      if (localbm == null) {
        localObject = new bm();
      }
      ((bm)localObject).svh = paramcn.swb;
      locale.a((bm)localObject);
      af.bDI().a(locale.field_snsId, locale);
      return;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "just update at SnsAdObject");
      a(paramcn.svY);
    }
  }
  
  private static void a(cn paramcn, int paramInt1, int paramInt2)
  {
    if (paramcn == null) {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
    }
    for (;;)
    {
      return;
      if ((paramcn.svY == null) || (paramcn.svY.tJi == null))
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        return;
      }
      bto localbto = paramcn.svY.tJi;
      com.tencent.mm.plugin.sns.storage.e locale = b(paramcn.svY);
      Object localObject2 = new com.tencent.mm.plugin.sns.storage.a(aa.a(paramcn.svZ));
      Object localObject1 = locale.bGe();
      bvo localbvo = new bvo();
      localbvo.tMm = new bvp();
      localbvo.tMm.tMq = ((com.tencent.mm.plugin.sns.storage.a)localObject2).ovV;
      localbvo.tMm.tMp = ((bxk)localObject1).lsK;
      localbvo.tMm.source = locale.getSource();
      localbvo.tMm.oKX = com.tencent.mm.modelstat.p.a(localbvo.tMm);
      label177:
      com.tencent.mm.plugin.sns.storage.b localb;
      int i;
      if (((bxk)localObject1).tNr.sPI == 1)
      {
        localbvo.tMm.oAE = 1;
        localObject2 = localbvo.tMm;
        localb = locale.bGa();
        if (localb != null) {
          break label402;
        }
        i = 0;
        ((bvp)localObject2).tMr = i;
      }
      try
      {
        localObject2 = Base64.encodeToString(localbvo.toByteArray(), 0).replace("\n", "");
        y.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[] { ((bxk)localObject1).lsK, localObject2, localbvo.tMm.tMp, localbvo.tMm.tMq });
        ((bxk)localObject1).oPO = ((String)localObject2);
        locale.c((bxk)localObject1);
        if (locale == null) {
          continue;
        }
        locale.field_createTime = paramInt1;
        locale.field_createAdTime = paramInt2;
        localObject1 = aa.a(paramcn.svY.tJj);
        if (!bk.bl((String)localObject1)) {
          locale.field_recxml = ((String)localObject1);
        }
        locale.field_adinfo = aa.a(paramcn.svZ);
        locale.field_adxml = locale.field_recxml;
        af.bDI().a(localbto.sGd, locale);
        return;
        if (((bxk)localObject1).tNr.sPI == 15)
        {
          localbvo.tMm.oAE = 2;
          break label177;
        }
        localbvo.tMm.oAE = 0;
        break label177;
        label402:
        i = localb.oBb;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public static boolean a(long paramLong, bsy parambsy)
  {
    bsx localbsx = parambsy.tJB;
    if ((localbsx.hQR != 7) && (localbsx.hQR != 8) && (localbsx.hQR != 16)) {
      return false;
    }
    com.tencent.mm.plugin.sns.storage.e locale = af.bDI().gk(paramLong);
    if (locale == null)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null " + paramLong);
      return false;
    }
    try
    {
      bto localbto = (bto)new bto().aH(locale.field_attrBuf);
      localbto.sGd = paramLong;
      Iterator localIterator;
      btd localbtd;
      if (localbsx.hQR == 7)
      {
        localIterator = localbto.tJY.iterator();
        while (localIterator.hasNext())
        {
          localbtd = (btd)localIterator.next();
          if ((localbtd.mPL == localbsx.mPL) && (localbtd.sxM.equals(localbsx.tAY)))
          {
            y.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localbtd.mPL + " ");
            return false;
          }
        }
        localbto.tJY.add(ad.b(parambsy));
      }
      for (;;)
      {
        locale.aL(localbto.toByteArray());
        af.bDI().a(localbto.sGd, locale);
        break;
        if ((localbsx.hQR == 8) || (localbsx.hQR == 16))
        {
          localIterator = localbto.tKb.iterator();
          while (localIterator.hasNext())
          {
            localbtd = (btd)localIterator.next();
            if ((localbtd.mPL == localbsx.mPL) && (localbtd.sxM.equals(localbsx.tAY)))
            {
              y.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localbtd.mPL + " ");
              return false;
            }
          }
          localbto.tKb.add(ad.b(parambsy));
        }
      }
      return true;
    }
    catch (Exception parambsy)
    {
      y.e("MicroMsg.AdSnsInfoStorageLogic", "e " + parambsy.getMessage());
      y.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", parambsy, "", new Object[0]);
    }
  }
  
  public static boolean a(long paramLong, bsy parambsy, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1;
    if (parambsy != null)
    {
      localObject1 = parambsy.tJB;
      if ((((bsx)localObject1).hQR != 7) && (((bsx)localObject1).hQR != 8) && (((bsx)localObject1).hQR != 16)) {
        return false;
      }
    }
    Object localObject3 = q.Gj();
    if ((parambsy != null) && (parambsy.tJC != null) && (parambsy.tJC.tAY != null) && (parambsy.tJC.tAY.equals(localObject3))) {
      return true;
    }
    Object localObject2 = af.bDI().gk(paramLong);
    if (localObject2 == null)
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    int k;
    Object localObject4;
    int i;
    long l;
    try
    {
      localObject1 = (bto)new bto().aH(((com.tencent.mm.plugin.sns.storage.e)localObject2).field_attrBuf);
      ((bto)localObject1).sGd = paramLong;
      k = ((com.tencent.mm.plugin.sns.storage.e)localObject2).field_firstControlTime;
      parambsy = parambsy.tJB;
      if (parambsy.hQR == 7)
      {
        if ((paramInt2 <= 0) || (k + paramInt2 >= parambsy.mPL)) {
          break label758;
        }
        if (paramBoolean)
        {
          if (af.bDF().OA(((com.tencent.mm.plugin.sns.storage.e)localObject2).bGk()) == null) {
            break label450;
          }
          localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).bGb();
          if (localObject4 == null) {
            break label424;
          }
          localObject3 = (com.tencent.mm.plugin.sns.b.c)g.r(com.tencent.mm.plugin.sns.b.c.class);
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          l = v.OU(((com.tencent.mm.plugin.sns.storage.e)localObject2).bGk());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).fVM;
          if (((bto)localObject1).tJY == null) {
            break label1184;
          }
          paramInt1 = ((bto)localObject1).tJY.size();
          if (((bto)localObject1).tKb == null) {
            break label1189;
          }
          paramInt3 = ((bto)localObject1).tKb.size();
          label285:
          ((com.tencent.mm.plugin.sns.b.c)localObject3).a(13182, i, new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        }
        for (;;)
        {
          y.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionLikeTimeLimit: " + paramInt2 + " curAction.createTime: " + parambsy.mPL + "is over the time limit!");
          return false;
          label424:
          y.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        }
        return true;
      }
    }
    catch (Exception parambsy)
    {
      y.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", parambsy, "", new Object[0]);
    }
    label450:
    label579:
    label597:
    label736:
    label747:
    label758:
    int j;
    label770:
    label841:
    do
    {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
      break;
      if (((parambsy.hQR == 8) || (parambsy.hQR == 16)) && (paramInt3 > 0) && (k + paramInt3 < parambsy.mPL))
      {
        if (paramBoolean)
        {
          if (af.bDF().OA(((com.tencent.mm.plugin.sns.storage.e)localObject2).bGk()) == null) {
            break label747;
          }
          localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).bGb();
          if (localObject4 == null) {
            break label736;
          }
          localObject3 = (com.tencent.mm.plugin.sns.b.c)g.r(com.tencent.mm.plugin.sns.b.c.class);
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          l = v.OU(((com.tencent.mm.plugin.sns.storage.e)localObject2).bGk());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).fVM;
          if (((bto)localObject1).tJY == null) {
            break label1195;
          }
          paramInt1 = ((bto)localObject1).tJY.size();
          if (((bto)localObject1).tKb == null) {
            break label1200;
          }
          paramInt2 = ((bto)localObject1).tKb.size();
          ((com.tencent.mm.plugin.sns.b.c)localObject3).a(13182, i, new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        }
        for (;;)
        {
          y.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionCommentTimeLimit: " + paramInt3 + " curAction.createTime: " + parambsy.mPL + "is over the time limit!");
          return false;
          y.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
          continue;
          y.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
        }
      }
      i = 0;
      parambsy = ((bto)localObject1).tJY.iterator();
      if (parambsy.hasNext())
      {
        localObject4 = (btd)parambsy.next();
        if (((btd)localObject4).mPL <= k) {
          break label1181;
        }
        if ((localObject4 == null) || (((btd)localObject4).sxM == null)) {
          break label1206;
        }
        if (((btd)localObject4).sxM.equals(localObject3)) {
          break label1181;
        }
        break label1206;
      }
      j = 0;
      parambsy = ((bto)localObject1).tKb.iterator();
      if (parambsy.hasNext())
      {
        localObject4 = (btd)parambsy.next();
        if (((btd)localObject4).mPL <= k) {
          break label1178;
        }
        if ((localObject4 == null) || (((btd)localObject4).sxM == null)) {
          break label1215;
        }
        if (((btd)localObject4).sxM.equals(localObject3)) {
          break label1178;
        }
        break label1215;
      }
      i = i + 0 + j;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i + " firstCreateTime " + k + " actionLimit: " + paramInt1 + " actionLikeTimeLimit: " + paramInt2 + " actionCommentTimeLimit: " + paramInt3);
    } while (i < paramInt1);
    if (paramBoolean)
    {
      parambsy = af.bDF().OA(((com.tencent.mm.plugin.sns.storage.e)localObject2).bGk());
      if (parambsy != null)
      {
        localObject3 = parambsy.bGb();
        if (localObject3 != null)
        {
          parambsy = (com.tencent.mm.plugin.sns.b.c)g.r(com.tencent.mm.plugin.sns.b.c.class);
          paramInt3 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          paramLong = v.OU(((com.tencent.mm.plugin.sns.storage.e)localObject2).bGk());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).fVM;
          if (((bto)localObject1).tJY == null) {
            break label1226;
          }
          paramInt1 = ((bto)localObject1).tJY.size();
          label1063:
          if (((bto)localObject1).tKb == null) {
            break label1231;
          }
        }
      }
    }
    label1178:
    label1181:
    label1184:
    label1189:
    label1195:
    label1200:
    label1206:
    label1212:
    label1215:
    label1221:
    label1224:
    label1226:
    label1231:
    for (paramInt2 = ((bto)localObject1).tKb.size();; paramInt2 = 0)
    {
      parambsy.a(13182, paramInt3, new Object[] { Long.valueOf(paramLong), localObject2, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
      break label1224;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
      break label1224;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
      break label1224;
      break label1221;
      break label1212;
      paramInt1 = 0;
      break;
      paramInt3 = 0;
      break label285;
      paramInt1 = 0;
      break label579;
      paramInt2 = 0;
      break label597;
      i += 1;
      break label770;
      j += 1;
      break label841;
      return false;
      paramInt1 = 0;
      break label1063;
    }
  }
  
  private static boolean a(btd parambtd, List<btd> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      btd localbtd = (btd)paramList.next();
      if ((!bk.bl(parambtd.sxM)) && (parambtd.sxM.equals(localbtd.sxM))) {
        return true;
      }
    }
    return false;
  }
  
  private static LinkedList<cn> ah(LinkedList<bjk> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cn localcn = a((bjk)paramLinkedList.next());
      if (localcn != null) {
        localLinkedList.add(localcn);
      }
    }
    return localLinkedList;
  }
  
  public static void ai(LinkedList<bjk> paramLinkedList)
  {
    if ((paramLinkedList != null) && (!paramLinkedList.isEmpty()))
    {
      paramLinkedList = ah(paramLinkedList);
      y.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      aj(paramLinkedList);
    }
  }
  
  public static void aj(LinkedList<cn> paramLinkedList)
  {
    if (paramLinkedList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramLinkedList.size())
      {
        b((cn)paramLinkedList.get(i));
        i += 1;
      }
    }
  }
  
  public static void ak(LinkedList<bto> paramLinkedList)
  {
    if (paramLinkedList == null) {}
    for (;;)
    {
      return;
      o localo = af.bDF();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        Object localObject = (bto)paramLinkedList.get(i);
        if (localObject != null)
        {
          localObject = localo.gt(((bto)localObject).sGd);
          if (localObject != null)
          {
            localObject = ((n)localObject).bGe();
            if ((localObject != null) && (!bk.bl(((bxk)localObject).pjl))) {
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.bFV().f("adId", ((bxk)localObject).pjl, "adxml", 0);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static com.tencent.mm.plugin.sns.storage.e b(bss parambss)
  {
    com.tencent.mm.plugin.sns.storage.e locale = af.bDI().gk(parambss.tJi.sGd);
    bto localbto = parambss.tJi;
    Object localObject1 = null;
    if (locale == null) {
      locale = new com.tencent.mm.plugin.sns.storage.e();
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = aa.b(localbto.tJU);
      if (!bk.bl((String)localObject2)) {
        break;
      }
      return null;
      localObject1 = locale.bGe().oPO;
    }
    if (!locale.Oz((String)localObject2)) {
      return null;
    }
    if (!bk.bl((String)localObject1))
    {
      localObject2 = locale.bGe();
      ((bxk)localObject2).oPO = ((String)localObject1);
      locale.c((bxk)localObject2);
    }
    localbto.tKl = aj.b(localbto.tKl, locale.field_attrBuf);
    y.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(localbto.sGd) });
    localbto.tJU.bs(new byte[0]);
    locale.field_userName = localbto.sxM;
    if (parambss.tJj != null)
    {
      parambss = aa.a(parambss.tJj);
      if (!bk.bl(parambss)) {
        locale.field_recxml = parambss;
      }
      parambss = locale.field_recxml;
      if ((!bk.bl(parambss)) && (!parambss.equals(locale.field_adxml)))
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml " + parambss);
        locale.field_adxml = parambss;
      }
    }
    locale.field_likeFlag = localbto.tJV;
    long l = localbto.sGd;
    locale.field_snsId = l;
    if (l != 0L)
    {
      locale.field_stringSeq = i.fN(l);
      locale.field_stringSeq = i.Nb(locale.field_stringSeq);
      y.d("MicroMsg.AdSnsInfo", l + " stringSeq " + locale.field_stringSeq);
    }
    locale.yp(2);
    locale.yp(32);
    try
    {
      if (locale.field_attrBuf == null)
      {
        parambss = new bto();
        if ((parambss == null) || (parambss.tKb == null)) {
          break label880;
        }
        localObject1 = new LinkedList();
        localObject2 = localbto.tKb.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label664;
          }
          localObject3 = (btd)((Iterator)localObject2).next();
          if (((btd)localObject3).ttD > 0)
          {
            ((List)localObject1).add(localObject3);
            localIterator = parambss.tKb.iterator();
            if (localIterator.hasNext())
            {
              localbtd = (btd)localIterator.next();
              if (localbtd.tJx != ((btd)localObject3).tJx) {
                break;
              }
              parambss.tKb.remove(localbtd);
            }
          }
        }
      }
    }
    catch (Exception parambss)
    {
      for (;;)
      {
        Object localObject3;
        Iterator localIterator;
        btd localbtd;
        y.i("MicroMsg.AdSnsInfoStorageLogic", "error " + parambss.getMessage());
        y.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", parambss, "", new Object[0]);
        try
        {
          for (;;)
          {
            locale.aL(localbto.toByteArray());
            parambss = locale.bGe();
            parambss.hPY = localbto.sxM;
            locale.field_pravited = parambss.trR;
            y.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + localbto.ttI + " " + localbto.tKb.size() + " " + localbto.tJY.size());
            localObject1 = parambss.tNr.sPJ.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((awd)((Iterator)localObject1).next()).omL = true;
            }
            parambss = (bto)new bto().aH(locale.field_attrBuf);
            break;
            label664:
            localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (btd)((Iterator)localObject2).next();
              localbto.tKb.remove(localObject3);
            }
            ((List)localObject1).clear();
            localObject1 = parambss.tKb.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (btd)((Iterator)localObject1).next();
              if ((!b((btd)localObject2, localbto.tKb)) && (((btd)localObject2).tJx != 0L))
              {
                g.DQ();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((btd)localObject2).sxM);
                if ((localObject3 != null) && (com.tencent.mm.n.a.gR(((ao)localObject3).field_type)) && (!((com.tencent.mm.storage.ad)localObject3).Bg()))
                {
                  localbto.tKb.add(localObject2);
                  localbto.tKa = localbto.tKb.size();
                }
                else
                {
                  y.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + ((btd)localObject2).sxM);
                }
              }
            }
            label880:
            Collections.sort(localbto.tKb, ooA);
            if (localbto.tJY != null)
            {
              localObject1 = new LinkedList();
              localObject2 = localbto.tJY.iterator();
              for (;;)
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break label1029;
                }
                localObject3 = (btd)((Iterator)localObject2).next();
                if (((btd)localObject3).ttD > 0)
                {
                  ((List)localObject1).add(localObject3);
                  localIterator = parambss.tJY.iterator();
                  if (localIterator.hasNext())
                  {
                    localbtd = (btd)localIterator.next();
                    if ((!bk.bl(localbtd.sxM)) && (!localbtd.sxM.equals(((btd)localObject3).sxM))) {
                      break;
                    }
                    parambss.tJY.remove(localbtd);
                  }
                }
              }
              label1029:
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (btd)((Iterator)localObject2).next();
                localbto.tJY.remove(localObject3);
              }
              ((List)localObject1).clear();
              if ((parambss != null) && (parambss.tJY != null))
              {
                parambss = parambss.tJY.iterator();
                while (parambss.hasNext())
                {
                  localObject1 = (btd)parambss.next();
                  if (!a((btd)localObject1, localbto.tJY))
                  {
                    g.DQ();
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((btd)localObject1).sxM);
                    if ((localObject2 != null) && (com.tencent.mm.n.a.gR(((ao)localObject2).field_type)) && (!((com.tencent.mm.storage.ad)localObject2).Bg()))
                    {
                      localbto.tJY.add(localObject1);
                      localbto.tJX = localbto.tJY.size();
                    }
                    else
                    {
                      y.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + ((btd)localObject1).sxM);
                    }
                  }
                }
              }
              Collections.sort(localbto.tJY, ooA);
            }
          }
        }
        catch (Exception parambss)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", parambss, "", new Object[0]);
          }
          locale.c(parambss);
          locale.field_type = parambss.tNr.sPI;
          locale.field_subType = parambss.tNr.sPK;
        }
      }
    }
    return locale;
  }
  
  private static bss b(buc parambuc)
  {
    if (parambuc != null)
    {
      bss localbss = new bss();
      localbss.tJj = parambuc.tKN;
      if (localbss.tJj == null) {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
      }
      localbss.tJi = parambuc.tJi;
      return localbss;
    }
    return null;
  }
  
  public static void b(bjk parambjk)
  {
    parambjk = a(parambjk);
    if (parambjk == null) {
      return;
    }
    com.tencent.mm.plugin.sns.storage.a locala = new com.tencent.mm.plugin.sns.storage.a(aa.a(parambjk.svZ));
    int j = locala.ozT;
    Cursor localCursor;
    n localn;
    if (j <= 0)
    {
      i = 1;
      int k = af.bDF().OO("");
      y.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      localCursor = af.bDF().ac("", k, i);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label280;
      }
      y.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[] { Integer.valueOf(localCursor.getCount()) });
      localn = new n();
      if (j >= 0) {
        break label257;
      }
      i = 0;
      label147:
      if (!localCursor.moveToPosition(i)) {
        break label262;
      }
      localn.d(localCursor);
    }
    label165:
    for (int i = localn.field_createTime + 1;; i = (int)bk.UX())
    {
      localCursor.close();
      y.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + parambjk.svY.tJi.sGd + " ,createTime " + i);
      a(parambjk, i, (int)bk.UX());
      b(parambjk);
      a(parambjk.svY.tJi.sGd, locala);
      return;
      i = j + 1;
      break;
      i = j;
      break label147;
      localCursor.moveToLast();
      localn.d(localCursor);
      break label165;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
    }
  }
  
  private static void b(cn paramcn)
  {
    paramcn = aa.a(paramcn.svY.tJj);
    if ((!bk.bl(paramcn)) && (new com.tencent.mm.plugin.sns.storage.b(paramcn).bEE())) {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.bFV().f("adId", paramcn, "adxml", 0);
    }
  }
  
  private static boolean b(btd parambtd, List<btd> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      btd localbtd = (btd)paramList.next();
      if ((parambtd.tJx == localbtd.tJx) && (localbtd.tJx != 0L)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static void bCH()
  {
    // Byte code:
    //   0: getstatic 909	com/tencent/mm/plugin/sns/model/a:ooz	Ljava/util/LinkedHashMap;
    //   3: ifnonnull +77 -> 80
    //   6: getstatic 46	com/tencent/mm/plugin/sns/model/a:ooy	Ljava/lang/String;
    //   9: invokestatic 915	com/tencent/mm/pluginsdk/g/a/d/a:Wo	(Ljava/lang/String;)[B
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +41 -> 55
    //   17: new 917	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 919	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: astore_0
    //   26: new 921	java/io/ObjectInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 924	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokeinterface 929 1 0
    //   43: checkcast 931	java/util/LinkedHashMap
    //   46: putstatic 909	com/tencent/mm/plugin/sns/model/a:ooz	Ljava/util/LinkedHashMap;
    //   49: aload_1
    //   50: invokeinterface 932 1 0
    //   55: getstatic 909	com/tencent/mm/plugin/sns/model/a:ooz	Ljava/util/LinkedHashMap;
    //   58: ifnonnull +22 -> 80
    //   61: new 934	com/tencent/mm/plugin/sns/model/a$2
    //   64: dup
    //   65: ldc2_w 935
    //   68: invokestatic 942	java/lang/Math:ceil	(D)D
    //   71: d2i
    //   72: iconst_1
    //   73: iadd
    //   74: invokespecial 944	com/tencent/mm/plugin/sns/model/a$2:<init>	(I)V
    //   77: putstatic 909	com/tencent/mm/plugin/sns/model/a:ooz	Ljava/util/LinkedHashMap;
    //   80: return
    //   81: astore_2
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: ldc 118
    //   88: aload_2
    //   89: invokestatic 948	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   92: invokestatic 578	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_1
    //   96: ifnull -41 -> 55
    //   99: aload_1
    //   100: invokeinterface 932 1 0
    //   105: goto -50 -> 55
    //   108: astore_0
    //   109: goto -54 -> 55
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: astore_0
    //   117: ldc 118
    //   119: aload_2
    //   120: invokestatic 948	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   123: invokestatic 578	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: ifnull -72 -> 55
    //   130: aload_1
    //   131: invokeinterface 932 1 0
    //   136: goto -81 -> 55
    //   139: astore_0
    //   140: goto -85 -> 55
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: astore_0
    //   148: ldc 118
    //   150: aload_2
    //   151: invokestatic 948	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   154: invokestatic 578	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_1
    //   158: ifnull -103 -> 55
    //   161: aload_1
    //   162: invokeinterface 932 1 0
    //   167: goto -112 -> 55
    //   170: astore_0
    //   171: goto -116 -> 55
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: ifnull +9 -> 187
    //   181: aload_0
    //   182: invokeinterface 932 1 0
    //   187: aload_1
    //   188: athrow
    //   189: astore_0
    //   190: goto -135 -> 55
    //   193: astore_0
    //   194: goto -7 -> 187
    //   197: astore_1
    //   198: goto -21 -> 177
    //   201: astore_2
    //   202: goto -56 -> 146
    //   205: astore_2
    //   206: goto -91 -> 115
    //   209: astore_2
    //   210: goto -126 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	74	0	localObject1	Object
    //   108	1	0	localIOException1	IOException
    //   116	1	0	localObject2	Object
    //   139	1	0	localIOException2	IOException
    //   147	1	0	localObject3	Object
    //   170	1	0	localIOException3	IOException
    //   176	6	0	localObject4	Object
    //   189	1	0	localIOException4	IOException
    //   193	1	0	localIOException5	IOException
    //   34	128	1	localObjectInputStream	java.io.ObjectInputStream
    //   174	14	1	localObject5	Object
    //   197	1	1	localObject6	Object
    //   81	8	2	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   112	8	2	localIOException6	IOException
    //   143	8	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   201	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   205	1	2	localIOException7	IOException
    //   209	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    // Exception table:
    //   from	to	target	type
    //   26	35	81	java/io/StreamCorruptedException
    //   99	105	108	java/io/IOException
    //   26	35	112	java/io/IOException
    //   130	136	139	java/io/IOException
    //   26	35	143	java/lang/ClassNotFoundException
    //   161	167	170	java/io/IOException
    //   26	35	174	finally
    //   49	55	189	java/io/IOException
    //   181	187	193	java/io/IOException
    //   37	49	197	finally
    //   86	95	197	finally
    //   117	126	197	finally
    //   148	157	197	finally
    //   37	49	201	java/lang/ClassNotFoundException
    //   37	49	205	java/io/IOException
    //   37	49	209	java/io/StreamCorruptedException
  }
  
  public static void d(LinkedList<bjk> paramLinkedList, LinkedList<bto> paramLinkedList1)
  {
    if (paramLinkedList != null)
    {
      paramLinkedList = ah(paramLinkedList);
      y.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cn localcn = (cn)localIterator.next();
        if (fP(localcn.svY.tJi.sGd))
        {
          y.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + localcn.svY.tJi.sGd);
          localIterator.remove();
        }
      }
      i(paramLinkedList, paramLinkedList1);
    }
  }
  
  private static boolean fP(long paramLong)
  {
    bCH();
    return ooz.get(Long.valueOf(paramLong)) != null;
  }
  
  private static void fQ(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (ooz == null) {
      bCH();
    }
    ooz.put(Long.valueOf(paramLong), Integer.valueOf(0));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      Object localObject1 = new ObjectOutputStream(localByteArrayOutputStream);
      ((ObjectOutput)localObject1).writeObject(ooz);
      ((ObjectOutput)localObject1).flush();
      localObject1 = localByteArrayOutputStream.toByteArray();
      com.tencent.mm.pluginsdk.g.a.d.a.v(ooy, (byte[])localObject1);
      try
      {
        localByteArrayOutputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        return;
      }
      try
      {
        localIOException2.close();
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        break label105;
      }
    }
    catch (IOException localIOException4)
    {
      localIOException4 = localIOException4;
      y.e("MicroMsg.AdSnsInfoStorageLogic", bk.j(localIOException4));
      try
      {
        localIOException1.close();
        return;
      }
      catch (IOException localIOException2) {}
    }
    finally {}
  }
  
  private static void i(List<cn> paramList, List<bto> paramList1)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0)) {
      return;
    }
    int k = a((bto)paramList1.get(paramList1.size() - 1));
    int i = 0;
    label42:
    cn localcn;
    if (i < paramList.size())
    {
      localcn = (cn)paramList.get(i);
      if (localcn != null) {
        break label84;
      }
      y.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
    }
    label84:
    Object localObject;
    com.tencent.mm.plugin.sns.storage.a locala;
    for (;;)
    {
      i += 1;
      break label42;
      break;
      if (localcn.svY == null)
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
      }
      else if (localcn.svY.tJi == null)
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
      }
      else
      {
        localObject = aa.a(localcn.svZ);
        String str1 = aa.a(localcn.svY.tJj);
        String str2 = aa.b(localcn.svY.tJi.tJU);
        locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject);
        y.i("MicroMsg.AdSnsInfoStorageLogic", "skXml " + (String)localObject);
        y.i("MicroMsg.AdSnsInfoStorageLogic", "adXml " + str1);
        y.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + str2 + "\r\n");
        localObject = new com.tencent.mm.plugin.sns.storage.b(str1);
        if ((((com.tencent.mm.plugin.sns.storage.b)localObject).oBc == 0L) || (!fP(((com.tencent.mm.plugin.sns.storage.b)localObject).oBc))) {
          break label311;
        }
        y.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + ((com.tencent.mm.plugin.sns.storage.b)localObject).oBc);
      }
    }
    label311:
    int j = k + 1;
    if ((locala.ozT < paramList1.size()) && (locala.ozT >= 0))
    {
      j = a((bto)paramList1.get(locala.ozT)) + 1;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.ozT);
    }
    for (;;)
    {
      int m = (int)(System.currentTimeMillis() / 1000L);
      y.i("MicroMsg.AdSnsInfoStorageLogic", "gettime " + m);
      a(localcn, j, m);
      fQ(localcn.svY.tJi.sGd);
      fQ(((com.tencent.mm.plugin.sns.storage.b)localObject).oBc);
      a(localcn.svY.tJi.sGd, locala);
      break;
      y.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.ozT);
    }
  }
  
  public static void j(List<cn> paramList, List<bto> paramList1)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0)) {
      return;
    }
    int k = a((bto)paramList1.get(paramList1.size() - 1));
    int i = 0;
    label42:
    cn localcn;
    if (i < paramList.size())
    {
      localcn = (cn)paramList.get(i);
      if (localcn != null) {
        break label84;
      }
      y.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
    }
    for (;;)
    {
      i += 1;
      break label42;
      break;
      label84:
      if (localcn.svY == null)
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
      }
      else
      {
        if (localcn.svY.tJi != null) {
          break label125;
        }
        y.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
      }
    }
    label125:
    Object localObject1 = aa.a(localcn.svZ);
    Object localObject2 = aa.a(localcn.svY.tJj);
    Object localObject3 = aa.b(localcn.svY.tJi.tJU);
    com.tencent.mm.plugin.sns.storage.a locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject1);
    y.i("MicroMsg.AdSnsInfoStorageLogic", "skXml %s, adXml %s, snsXml %s", new Object[] { localObject1, localObject2, localObject3 });
    int j = k + 1;
    if ((locala.ozT < paramList1.size()) && (locala.ozT >= 0))
    {
      j = a((bto)paramList1.get(locala.ozT)) + 1;
      y.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.ozT);
    }
    for (;;)
    {
      int m = (int)(System.currentTimeMillis() / 1000L);
      y.i("MicroMsg.AdSnsInfoStorageLogic", "gettime " + m);
      a(localcn, j, m);
      localObject3 = af.bDI().gk(localcn.svY.tJi.sGd);
      if (localObject3 != null)
      {
        y.i("MicroMsg.AdSnsInfoStorageLogic", "update remind info");
        localObject2 = ((com.tencent.mm.plugin.sns.storage.e)localObject3).bGf();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new bm();
        }
        ((bm)localObject1).svg = localcn.swb;
        ((com.tencent.mm.plugin.sns.storage.e)localObject3).a((bm)localObject1);
        ((com.tencent.mm.plugin.sns.storage.e)localObject3).field_localFlag &= 0xFFFFFEFF;
        af.bDI().a((com.tencent.mm.sdk.e.c)localObject3);
      }
      a(localcn.svY.tJi.sGd, locala);
      break;
      y.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.ozT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a
 * JD-Core Version:    0.7.0.1
 */