package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.czs;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  private static final String xPC;
  private static LinkedHashMap<Long, Integer> xPD;
  private static Comparator<daa> xPE;
  
  static
  {
    AppMethodBeat.i(95410);
    StringBuilder localStringBuilder = new StringBuilder();
    g.agS();
    xPC = g.agR().cachePath + "sns_recvd_ad";
    xPE = new Comparator() {};
    AppMethodBeat.o(95410);
  }
  
  private static int a(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95402);
    com.tencent.mm.plugin.sns.storage.p localp = af.dHR().xK(paramSnsObject.Id);
    if (localp == null)
    {
      i = paramSnsObject.CreateTime;
      AppMethodBeat.o(95402);
      return i;
    }
    int i = localp.field_createTime;
    AppMethodBeat.o(95402);
    return i;
  }
  
  private static di a(cmj paramcmj)
  {
    AppMethodBeat.i(95390);
    if (paramcmj != null)
    {
      di localdi = new di();
      localdi.DQp = paramcmj.FzG;
      if (localdi.DQp == null)
      {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
        AppMethodBeat.o(95390);
        return null;
      }
      localdi.DQo = b(paramcmj.FzF);
      AppMethodBeat.o(95390);
      return localdi;
    }
    AppMethodBeat.o(95390);
    return null;
  }
  
  private static String a(String paramString, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(95409);
    if ((paramSKBuiltinBuffer_t == null) || (paramString == null))
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
      AppMethodBeat.o(95409);
      return paramString;
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new ab();
        ((ab)localObject1).parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        Iterator localIterator;
        if (((ab)localObject1).DLx != null)
        {
          localObject2 = "";
          localIterator = ((ab)localObject1).DLx.iterator();
          paramSKBuiltinBuffer_t = paramString;
          localObject1 = paramSKBuiltinBuffer_t;
        }
        czs localczs;
        String str;
        Object localObject3;
        localObject2 = paramString;
      }
      catch (Exception paramSKBuiltinBuffer_t)
      {
        try
        {
          if (localIterator.hasNext())
          {
            localObject1 = paramSKBuiltinBuffer_t;
            localczs = (czs)localIterator.next();
            localObject1 = paramSKBuiltinBuffer_t;
            if (localczs.key == null) {
              break label355;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            str = String.format("<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))", new Object[] { localczs.key });
            localObject1 = paramSKBuiltinBuffer_t;
            localObject3 = Pattern.compile(str).matcher(paramSKBuiltinBuffer_t);
            localObject1 = paramSKBuiltinBuffer_t;
            if (!((Matcher)localObject3).find()) {
              break label355;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            localObject3 = ((Matcher)localObject3).group(2);
            if (localObject3 == null) {
              break label355;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            if (((String)localObject3).length() <= 0) {
              break label355;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.replaceAll(str + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[] { localObject3 }), String.format("<$1>%s</%s>", new Object[] { localczs.value, localObject3 }));
            localObject1 = paramSKBuiltinBuffer_t;
            localObject2 = (String)localObject2 + localczs.key + ":" + localczs.value + ";";
            localObject1 = localObject2;
            break label365;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", new Object[] { localObject2 });
          localObject2 = paramSKBuiltinBuffer_t;
          localObject1 = paramSKBuiltinBuffer_t;
          if (bv.L(paramString, "ADInfo") != null) {
            continue;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          ac.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
          AppMethodBeat.o(95409);
          return paramString;
        }
        catch (Exception paramString)
        {
          continue;
          localObject1 = localObject2;
        }
        paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t;
        localObject1 = paramString;
        paramString = paramSKBuiltinBuffer_t;
        ac.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramString, "replace error occurs!", new Object[0]);
        localObject2 = localObject1;
        AppMethodBeat.o(95409);
        return localObject2;
      }
      label355:
      continue;
      label365:
      Object localObject2 = localObject1;
    }
  }
  
  private static void a(long paramLong, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(95396);
    if ((!parama.yeY) || (bs.isNullOrNil(parama.yeX)))
    {
      AppMethodBeat.o(95396);
      return;
    }
    parama = new l(paramLong, 1, parama.yeX);
    g.agS();
    g.agQ().ghe.a(parama, 0);
    AppMethodBeat.o(95396);
  }
  
  public static void a(czp paramczp)
  {
    AppMethodBeat.i(95382);
    if (paramczp == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95382);
      return;
    }
    if (paramczp.FIN == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95382);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramczp);
    af.dHU().a(paramczp.FIN.Id, locale);
    AppMethodBeat.o(95382);
  }
  
  public static void a(czp paramczp, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(95380);
    if (paramczp == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95380);
      return;
    }
    if (paramczp.FIN == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95380);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramczp);
    if (locale == null)
    {
      AppMethodBeat.o(95380);
      return;
    }
    locale.field_adinfo = a(locale.field_adinfo, paramSKBuiltinBuffer_t);
    if (af.dHU().xC(paramczp.FIN.Id))
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + paramczp.FIN.Id);
      af.dHU().b(paramczp.FIN.Id, locale);
      AppMethodBeat.o(95380);
      return;
    }
    ac.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + paramczp.FIN.Id);
    AppMethodBeat.o(95380);
  }
  
  public static void a(dba paramdba)
  {
    AppMethodBeat.i(95381);
    a(b(paramdba));
    AppMethodBeat.o(95381);
  }
  
  private static void a(di paramdi, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95388);
    if (paramdi == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95388);
      return;
    }
    if ((paramdi.DQo == null) || (paramdi.DQo.FIN == null))
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95388);
      return;
    }
    SnsObject localSnsObject = paramdi.DQo.FIN;
    com.tencent.mm.plugin.sns.storage.e locale = b(paramdi.DQo);
    if (locale == null)
    {
      ac.w("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
      AppMethodBeat.o(95388);
      return;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.a(z.a(paramdi.DQp));
    TimeLineObject localTimeLineObject = locale.dLV();
    dcu localdcu = new dcu();
    localdcu.FMs = new dcv();
    localdcu.FMs.DHe = ((com.tencent.mm.plugin.sns.storage.a)localObject).dtx;
    localdcu.FMs.FMv = localTimeLineObject.Id;
    localdcu.FMs.dbL = locale.getSource();
    localdcu.FMs.yvb = com.tencent.mm.modelstat.p.a(localdcu.FMs);
    if (localTimeLineObject.FQo.Ety == 1) {
      localdcu.FMs.yft = 1;
    }
    for (;;)
    {
      localdcu.FMs.FMw = locale.dLU();
      try
      {
        localObject = Base64.encodeToString(localdcu.toByteArray(), 0).replace("\n", "");
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[] { localTimeLineObject.Id, localObject, localdcu.FMs.FMv, localdcu.FMs.DHe });
        localTimeLineObject.yAj = ((String)localObject);
        locale.f(localTimeLineObject);
        if (locale == null)
        {
          AppMethodBeat.o(95388);
          return;
          if (localTimeLineObject.FQo.Ety == 15)
          {
            localdcu.FMs.yft = 2;
            continue;
          }
          localdcu.FMs.yft = 0;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", localIOException, "", new Object[0]);
        }
        locale.field_createTime = paramInt1;
        locale.field_createAdTime = paramInt2;
        String str = z.a(paramdi.DQo.FIO);
        if (!bs.isNullOrNil(str)) {
          locale.field_recxml = str;
        }
        locale.field_adinfo = z.a(paramdi.DQp);
        locale.field_adxml = locale.field_recxml;
        af.dHU().a(localSnsObject.Id, locale);
        AppMethodBeat.o(95388);
      }
    }
  }
  
  public static boolean a(long paramLong, czv paramczv)
  {
    AppMethodBeat.i(95404);
    czu localczu = paramczv.FJh;
    if ((localczu.ndI != 7) && (localczu.ndI != 8) && (localczu.ndI != 16))
    {
      AppMethodBeat.o(95404);
      return false;
    }
    com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(paramLong);
    if (locale == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(95404);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localczu.ndI != 7) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdaa = (daa)localIterator.next();
          if ((localdaa.CreateTime != localczu.CreateTime) || (!localdaa.Username.equals(localczu.Fwn))) {
            continue;
          }
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localdaa.CreateTime + " ");
          AppMethodBeat.o(95404);
          return false;
        }
        localSnsObject.LikeUserList.add(ad.b(paramczv));
        locale.bB(localSnsObject.toByteArray());
        af.dHU().a(localSnsObject.Id, locale);
      }
      catch (Exception paramczv)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        daa localdaa;
        ac.e("MicroMsg.AdSnsInfoStorageLogic", "e " + paramczv.getMessage());
        ac.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramczv, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95404);
      return true;
      if ((localczu.ndI == 8) || (localczu.ndI == 16))
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localdaa = (daa)localIterator.next();
          if ((localdaa.CreateTime == localczu.CreateTime) && (localdaa.Username.equals(localczu.Fwn)))
          {
            ac.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localdaa.CreateTime + " ");
            AppMethodBeat.o(95404);
            return false;
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ad.b(paramczv));
        }
      }
    }
  }
  
  public static boolean a(long paramLong, czv paramczv, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(95403);
    Object localObject1;
    if (paramczv != null)
    {
      localObject1 = paramczv.FJh;
      if ((((czu)localObject1).ndI != 7) && (((czu)localObject1).ndI != 8) && (((czu)localObject1).ndI != 16))
      {
        AppMethodBeat.o(95403);
        return false;
      }
    }
    Object localObject3 = u.axw();
    if ((paramczv != null) && (paramczv.FJi != null) && (paramczv.FJi.Fwn != null) && (paramczv.FJi.Fwn.equals(localObject3)))
    {
      AppMethodBeat.o(95403);
      return true;
    }
    Object localObject2 = af.dHU().xB(paramLong);
    if (localObject2 == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(95403);
      return false;
    }
    int k;
    Object localObject4;
    long l;
    for (;;)
    {
      try
      {
        localObject1 = (SnsObject)new SnsObject().parseFrom(((com.tencent.mm.plugin.sns.storage.e)localObject2).field_attrBuf);
        ((SnsObject)localObject1).Id = paramLong;
        k = ((com.tencent.mm.plugin.sns.storage.e)localObject2).field_firstControlTime;
        paramczv = paramczv.FJh;
        if (paramczv.ndI != 7) {
          break;
        }
        if ((paramInt2 <= 0) || (k + paramInt2 >= paramczv.CreateTime)) {
          break label822;
        }
        if (paramBoolean)
        {
          if (af.dHR().auS(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
            break label497;
          }
          localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).dFQ();
          if (localObject4 == null) {
            continue;
          }
          localObject3 = (d)g.ab(d.class);
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          l = x.asL(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).dyy;
          if (((SnsObject)localObject1).LikeUserList != null)
          {
            paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
            if (((SnsObject)localObject1).CommentUserList == null) {
              continue;
            }
            paramInt3 = ((SnsObject)localObject1).CommentUserList.size();
            ((d)localObject3).a(13182, i, new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
          }
        }
        else
        {
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionLikeTimeLimit: " + paramInt2 + " curAction.createTime: " + paramczv.CreateTime + "is over the time limit!");
          AppMethodBeat.o(95403);
          return false;
        }
        paramInt1 = 0;
        continue;
        paramInt3 = 0;
        continue;
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        AppMethodBeat.o(95403);
      }
      catch (Exception paramczv)
      {
        ac.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramczv, "", new Object[0]);
      }
      return true;
      label497:
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
    }
    if (((paramczv.ndI == 8) || (paramczv.ndI == 16)) && (paramInt3 > 0) && (k + paramInt3 < paramczv.CreateTime))
    {
      if (paramBoolean)
      {
        if (af.dHR().auS(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
          break label811;
        }
        localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).dFQ();
        if (localObject4 == null) {
          break label800;
        }
        localObject3 = (d)g.ab(d.class);
        i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
        l = x.asL(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
        localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).dyy;
        if (((SnsObject)localObject1).LikeUserList == null) {
          break label789;
        }
        paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
        if (((SnsObject)localObject1).CommentUserList == null) {
          break label794;
        }
        paramInt2 = ((SnsObject)localObject1).CommentUserList.size();
        label644:
        ((d)localObject3).a(13182, i, new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
      }
      for (;;)
      {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionCommentTimeLimit: " + paramInt3 + " curAction.createTime: " + paramczv.CreateTime + "is over the time limit!");
        AppMethodBeat.o(95403);
        return false;
        label789:
        paramInt1 = 0;
        break;
        label794:
        paramInt2 = 0;
        break label644;
        label800:
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        label811:
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
      }
    }
    label822:
    int i = 0;
    paramczv = ((SnsObject)localObject1).LikeUserList.iterator();
    label834:
    int j;
    if (paramczv.hasNext())
    {
      localObject4 = (daa)paramczv.next();
      if (((daa)localObject4).CreateTime > k)
      {
        if ((localObject4 == null) || (((daa)localObject4).Username == null)) {
          break label1264;
        }
        if (!((daa)localObject4).Username.equals(localObject3)) {
          break label1264;
        }
      }
    }
    else
    {
      j = 0;
      paramczv = ((SnsObject)localObject1).CommentUserList.iterator();
    }
    label1145:
    label1279:
    for (;;)
    {
      if (paramczv.hasNext())
      {
        localObject4 = (daa)paramczv.next();
        if (((daa)localObject4).CreateTime > k)
        {
          if ((localObject4 == null) || (((daa)localObject4).Username == null)) {
            break label1273;
          }
          if (!((daa)localObject4).Username.equals(localObject3)) {
            break label1273;
          }
        }
      }
      else
      {
        i = i + 0 + j;
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i + " firstCreateTime " + k + " actionLimit: " + paramInt1 + " actionLikeTimeLimit: " + paramInt2 + " actionCommentTimeLimit: " + paramInt3);
        if (i < paramInt1) {
          break;
        }
        if (paramBoolean)
        {
          paramczv = af.dHR().auS(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          if (paramczv == null) {
            break label1247;
          }
          localObject3 = paramczv.dFQ();
          if (localObject3 == null) {
            break label1236;
          }
          paramczv = (d)g.ab(d.class);
          paramInt3 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          paramLong = x.asL(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).dyy;
          if (((SnsObject)localObject1).LikeUserList == null) {
            break label1225;
          }
          paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
          if (((SnsObject)localObject1).CommentUserList == null) {
            break label1230;
          }
          paramInt2 = ((SnsObject)localObject1).CommentUserList.size();
          paramczv.a(13182, paramInt3, new Object[] { Long.valueOf(paramLong), localObject2, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        }
        for (;;)
        {
          AppMethodBeat.o(95403);
          return false;
          paramInt1 = 0;
          break;
          paramInt2 = 0;
          break label1145;
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
          continue;
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
        }
      }
      break label1279;
      break label1270;
      i += 1;
      break label834;
      j += 1;
    }
  }
  
  private static boolean a(daa paramdaa, List<daa> paramList)
  {
    AppMethodBeat.i(95386);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      daa localdaa = (daa)paramList.next();
      if ((!bs.isNullOrNil(paramdaa.Username)) && (paramdaa.Username.equals(localdaa.Username)))
      {
        AppMethodBeat.o(95386);
        return true;
      }
    }
    AppMethodBeat.o(95386);
    return false;
  }
  
  private static LinkedList<di> aO(LinkedList<cmj> paramLinkedList)
  {
    AppMethodBeat.i(95393);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      di localdi = a((cmj)paramLinkedList.next());
      if (localdi != null) {
        localLinkedList.add(localdi);
      }
    }
    AppMethodBeat.o(95393);
    return localLinkedList;
  }
  
  public static void aP(LinkedList<cmj> paramLinkedList)
  {
    AppMethodBeat.i(95397);
    if ((paramLinkedList != null) && (!paramLinkedList.isEmpty()))
    {
      paramLinkedList = aO(paramLinkedList);
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      aQ(paramLinkedList);
    }
    AppMethodBeat.o(95397);
  }
  
  public static void aQ(LinkedList<di> paramLinkedList)
  {
    AppMethodBeat.i(95398);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(95398);
      return;
    }
    int i = 0;
    while (i < paramLinkedList.size())
    {
      c((di)paramLinkedList.get(i));
      i += 1;
    }
    AppMethodBeat.o(95398);
  }
  
  public static void aR(LinkedList<SnsObject> paramLinkedList)
  {
    AppMethodBeat.i(95400);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(95400);
      return;
    }
    com.tencent.mm.plugin.sns.storage.q localq = af.dHR();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      Object localObject = (SnsObject)paramLinkedList.get(i);
      if (localObject != null)
      {
        localObject = localq.xK(((SnsObject)localObject).Id);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.sns.storage.p)localObject).dLV();
          if ((localObject != null) && (!bs.isNullOrNil(((TimeLineObject)localObject).yCb))) {
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95377);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dLO().f("adId", this.xPG.yCb, "adxml", 0);
                AppMethodBeat.o(95377);
              }
            }, "preDownloadAdLandingPagesForSnsObject");
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(95400);
  }
  
  public static void ats(String paramString)
  {
    AppMethodBeat.i(95401);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95401);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95378);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dLO().f("adId", this.xPH, "adxml", 1);
        AppMethodBeat.o(95378);
      }
    }, "preDownloadAdLandingPagesForMsg");
    AppMethodBeat.o(95401);
  }
  
  private static com.tencent.mm.plugin.sns.storage.e b(czp paramczp)
  {
    AppMethodBeat.i(95385);
    com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(paramczp.FIN.Id);
    SnsObject localSnsObject = paramczp.FIN;
    Object localObject1 = null;
    if (locale == null) {
      locale = new com.tencent.mm.plugin.sns.storage.e();
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = z.b(localSnsObject.ObjectDesc);
      if (!bs.isNullOrNil((String)localObject2)) {
        break;
      }
      AppMethodBeat.o(95385);
      return null;
      localObject1 = locale.dLV().yAj;
    }
    if (!locale.auR((String)localObject2))
    {
      AppMethodBeat.o(95385);
      return null;
    }
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject2 = locale.dLV();
      ((TimeLineObject)localObject2).yAj = ((String)localObject1);
      locale.f((TimeLineObject)localObject2);
    }
    localSnsObject.ObjectOperations = aj.b(localSnsObject.ObjectOperations, locale.field_attrBuf);
    ac.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(localSnsObject.Id) });
    localSnsObject.ObjectDesc.setBuffer(new byte[0]);
    locale.field_userName = localSnsObject.Username;
    if (paramczp.FIO != null)
    {
      paramczp = z.a(paramczp.FIO);
      if (!bs.isNullOrNil(paramczp)) {
        locale.field_recxml = paramczp;
      }
      paramczp = locale.field_recxml;
      if ((!bs.isNullOrNil(paramczp)) && (!paramczp.equals(locale.field_adxml)))
      {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml ".concat(String.valueOf(paramczp)));
        locale.field_adxml = paramczp;
      }
    }
    locale.field_likeFlag = localSnsObject.LikeFlag;
    long l = localSnsObject.Id;
    locale.field_snsId = l;
    if (l != 0L)
    {
      locale.field_stringSeq = com.tencent.mm.plugin.sns.data.q.wW(l);
      locale.field_stringSeq = com.tencent.mm.plugin.sns.data.q.asY(locale.field_stringSeq);
      ac.d("MicroMsg.AdSnsInfo", l + " stringSeq " + locale.field_stringSeq);
    }
    locale.Pb(2);
    locale.Pb(32);
    try
    {
      if (locale.field_attrBuf == null)
      {
        paramczp = new SnsObject();
        if ((paramczp == null) || (paramczp.CommentUserList == null)) {
          break label891;
        }
        localObject1 = new LinkedList();
        localObject2 = localSnsObject.CommentUserList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label675;
          }
          localObject3 = (daa)((Iterator)localObject2).next();
          if (((daa)localObject3).DeleteFlag > 0)
          {
            ((List)localObject1).add(localObject3);
            localIterator = paramczp.CommentUserList.iterator();
            if (localIterator.hasNext())
            {
              localdaa = (daa)localIterator.next();
              if (localdaa.FJb != ((daa)localObject3).FJb) {
                break;
              }
              paramczp.CommentUserList.remove(localdaa);
            }
          }
        }
      }
    }
    catch (Exception paramczp)
    {
      for (;;)
      {
        Object localObject3;
        Iterator localIterator;
        daa localdaa;
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "error " + paramczp.getMessage());
        ac.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramczp, "", new Object[0]);
        try
        {
          for (;;)
          {
            locale.bB(localSnsObject.toByteArray());
            paramczp = locale.dLV();
            paramczp.ncR = localSnsObject.Username;
            locale.field_pravited = paramczp.Fjj;
            ac.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + localSnsObject.ExtFlag + " " + localSnsObject.CommentUserList.size() + " " + localSnsObject.LikeUserList.size());
            localObject1 = paramczp.FQo.Etz.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((btz)((Iterator)localObject1).next()).isAd = true;
            }
            paramczp = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
            break;
            label675:
            localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (daa)((Iterator)localObject2).next();
              localSnsObject.CommentUserList.remove(localObject3);
            }
            ((List)localObject1).clear();
            localObject1 = paramczp.CommentUserList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (daa)((Iterator)localObject1).next();
              if ((!b((daa)localObject2, localSnsObject.CommentUserList)) && (((daa)localObject2).FJb != 0L))
              {
                g.agS();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((daa)localObject2).Username);
                if ((localObject3 != null) && (com.tencent.mm.n.b.ln(((av)localObject3).field_type)) && (!((ai)localObject3).aaH()))
                {
                  localSnsObject.CommentUserList.add(localObject2);
                  localSnsObject.CommentUserListCount = localSnsObject.CommentUserList.size();
                }
                else
                {
                  ac.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + ((daa)localObject2).Username);
                }
              }
            }
            label891:
            Collections.sort(localSnsObject.CommentUserList, xPE);
            if (localSnsObject.LikeUserList != null)
            {
              localObject1 = new LinkedList();
              localObject2 = localSnsObject.LikeUserList.iterator();
              for (;;)
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break label1040;
                }
                localObject3 = (daa)((Iterator)localObject2).next();
                if (((daa)localObject3).DeleteFlag > 0)
                {
                  ((List)localObject1).add(localObject3);
                  localIterator = paramczp.LikeUserList.iterator();
                  if (localIterator.hasNext())
                  {
                    localdaa = (daa)localIterator.next();
                    if ((!bs.isNullOrNil(localdaa.Username)) && (!localdaa.Username.equals(((daa)localObject3).Username))) {
                      break;
                    }
                    paramczp.LikeUserList.remove(localdaa);
                  }
                }
              }
              label1040:
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (daa)((Iterator)localObject2).next();
                localSnsObject.LikeUserList.remove(localObject3);
              }
              ((List)localObject1).clear();
              if ((paramczp != null) && (paramczp.LikeUserList != null))
              {
                paramczp = paramczp.LikeUserList.iterator();
                while (paramczp.hasNext())
                {
                  localObject1 = (daa)paramczp.next();
                  if (!a((daa)localObject1, localSnsObject.LikeUserList))
                  {
                    g.agS();
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((daa)localObject1).Username);
                    if ((localObject2 != null) && (com.tencent.mm.n.b.ln(((av)localObject2).field_type)) && (!((ai)localObject2).aaH()))
                    {
                      localSnsObject.LikeUserList.add(localObject1);
                      localSnsObject.LikeUserListCount = localSnsObject.LikeUserList.size();
                    }
                    else
                    {
                      ac.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + ((daa)localObject1).Username);
                    }
                  }
                }
              }
              Collections.sort(localSnsObject.LikeUserList, xPE);
            }
          }
        }
        catch (Exception paramczp)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramczp, "", new Object[0]);
          }
          locale.f(paramczp);
          locale.field_type = paramczp.FQo.Ety;
          locale.field_subType = paramczp.FQo.EtA;
          AppMethodBeat.o(95385);
        }
      }
    }
    return locale;
  }
  
  private static czp b(dba paramdba)
  {
    AppMethodBeat.i(95389);
    if (paramdba != null)
    {
      czp localczp = new czp();
      localczp.FIO = paramdba.FKh;
      if (localczp.FIO == null) {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
      }
      localczp.FIN = paramdba.FIN;
      AppMethodBeat.o(95389);
      return localczp;
    }
    AppMethodBeat.o(95389);
    return null;
  }
  
  public static void b(cmj paramcmj)
  {
    AppMethodBeat.i(95391);
    paramcmj = a(paramcmj);
    if (paramcmj == null)
    {
      AppMethodBeat.o(95391);
      return;
    }
    com.tencent.mm.plugin.sns.storage.a locala = new com.tencent.mm.plugin.sns.storage.a(z.a(paramcmj.DQp));
    int j = locala.yew;
    Cursor localCursor;
    com.tencent.mm.plugin.sns.storage.p localp;
    if (j <= 0)
    {
      i = 1;
      int k = af.dHR().avj("");
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      localCursor = af.dHR().at("", k, i);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label298;
      }
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[] { Integer.valueOf(localCursor.getCount()) });
      localp = new com.tencent.mm.plugin.sns.storage.p();
      if (j >= 0) {
        break label275;
      }
      i = 0;
      label159:
      if (!localCursor.moveToPosition(i)) {
        break label280;
      }
      localp.convertFrom(localCursor);
    }
    label177:
    for (int i = localp.field_createTime + 1;; i = (int)bs.aNx())
    {
      localCursor.close();
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + paramcmj.DQo.FIN.Id + " ,createTime " + i);
      a(paramcmj, i, (int)bs.aNx());
      c(paramcmj);
      a(paramcmj.DQo.FIN.Id, locala);
      AppMethodBeat.o(95391);
      return;
      i = j + 1;
      break;
      i = j;
      break label159;
      localCursor.moveToLast();
      localp.convertFrom(localCursor);
      break label177;
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
    }
  }
  
  public static void b(di paramdi)
  {
    AppMethodBeat.i(95383);
    if (paramdi == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
      AppMethodBeat.o(95383);
      return;
    }
    if (paramdi.DQo == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
      AppMethodBeat.o(95383);
      return;
    }
    if (paramdi.DQo.FIN == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
      AppMethodBeat.o(95383);
      return;
    }
    Object localObject;
    if (!af.dHU().xC(paramdi.DQo.FIN.Id))
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "insert at adObject");
      int i = (int)(System.currentTimeMillis() / 1000L);
      if (paramdi.DQo.FIN.CommentUserListCount > 0) {
        i = ((daa)paramdi.DQo.FIN.CommentUserList.get(0)).CreateTime;
      }
      a(paramdi, i, i);
      localObject = af.dHU().xB(paramdi.DQo.FIN.Id);
      if (localObject != null)
      {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
        ((com.tencent.mm.plugin.sns.storage.e)localObject).field_localFlag |= 0x100;
        af.dHU().a(((com.tencent.mm.plugin.sns.storage.e)localObject).field_snsId, (com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(paramdi.DQo.FIN.Id);
      if (locale != null)
      {
        locale.field_atAdinfo = z.a(paramdi.DQp);
        ca localca = locale.dLW();
        localObject = localca;
        if (localca == null) {
          localObject = new ca();
        }
        ((ca)localObject).DPr = paramdi.DQr;
        if (((ca)localObject).DPr != null) {
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "update atFriend remindInfo, aid64 %d, aid %d", new Object[] { Long.valueOf(((ca)localObject).DPr.FBm), Integer.valueOf(((ca)localObject).DPr.FBh) });
        }
        locale.a((ca)localObject);
        af.dHU().a(locale.field_snsId, locale);
      }
      AppMethodBeat.o(95383);
      return;
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "just update at SnsAdObject");
      a(paramdi.DQo);
    }
  }
  
  private static boolean b(daa paramdaa, List<daa> paramList)
  {
    AppMethodBeat.i(95387);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      daa localdaa = (daa)paramList.next();
      if ((paramdaa.FJb == localdaa.FJb) && (localdaa.FJb != 0L))
      {
        AppMethodBeat.o(95387);
        return true;
      }
    }
    AppMethodBeat.o(95387);
    return false;
  }
  
  private static void c(di paramdi)
  {
    AppMethodBeat.i(95399);
    paramdi = z.a(paramdi.DQo.FIO);
    if ((!bs.isNullOrNil(paramdi)) && (new com.tencent.mm.plugin.sns.storage.b(paramdi).dJG())) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95376);
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dLO().f("adId", this.xPF, "adxml", 0);
          AppMethodBeat.o(95376);
        }
      }, "predownloadAdLandingPages");
    }
    AppMethodBeat.o(95399);
  }
  
  /* Error */
  private static void dHa()
  {
    // Byte code:
    //   0: ldc_w 954
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 956	com/tencent/mm/plugin/sns/model/a:xPD	Ljava/util/LinkedHashMap;
    //   9: ifnonnull +61 -> 70
    //   12: getstatic 61	com/tencent/mm/plugin/sns/model/a:xPC	Ljava/lang/String;
    //   15: invokestatic 962	com/tencent/mm/pluginsdk/h/a/d/a:aGK	(Ljava/lang/String;)[B
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +41 -> 61
    //   23: new 964	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 966	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: astore_0
    //   32: new 968	java/io/ObjectInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 971	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: invokeinterface 976 1 0
    //   49: checkcast 978	java/util/LinkedHashMap
    //   52: putstatic 956	com/tencent/mm/plugin/sns/model/a:xPD	Ljava/util/LinkedHashMap;
    //   55: aload_1
    //   56: invokeinterface 979 1 0
    //   61: getstatic 956	com/tencent/mm/plugin/sns/model/a:xPD	Ljava/util/LinkedHashMap;
    //   64: ifnonnull +6 -> 70
    //   67: invokestatic 982	com/tencent/mm/plugin/sns/model/a:dHb	()V
    //   70: ldc_w 954
    //   73: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: ldc 114
    //   84: aload_2
    //   85: invokestatic 986	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: ifnull -31 -> 61
    //   95: aload_1
    //   96: invokeinterface 979 1 0
    //   101: goto -40 -> 61
    //   104: astore_0
    //   105: goto -44 -> 61
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: astore_0
    //   113: ldc 114
    //   115: aload_2
    //   116: invokestatic 986	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   119: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_1
    //   123: ifnull -62 -> 61
    //   126: aload_1
    //   127: invokeinterface 979 1 0
    //   132: goto -71 -> 61
    //   135: astore_0
    //   136: goto -75 -> 61
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: astore_0
    //   144: ldc 114
    //   146: aload_2
    //   147: invokestatic 986	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   150: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: ifnull -93 -> 61
    //   157: aload_1
    //   158: invokeinterface 979 1 0
    //   163: goto -102 -> 61
    //   166: astore_0
    //   167: goto -106 -> 61
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_0
    //   173: aload_0
    //   174: ifnull +9 -> 183
    //   177: aload_0
    //   178: invokeinterface 979 1 0
    //   183: ldc_w 954
    //   186: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: athrow
    //   191: astore_0
    //   192: goto -131 -> 61
    //   195: astore_0
    //   196: goto -13 -> 183
    //   199: astore_1
    //   200: goto -27 -> 173
    //   203: astore_2
    //   204: goto -62 -> 142
    //   207: astore_2
    //   208: goto -97 -> 111
    //   211: astore_2
    //   212: goto -132 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	localObject1	Object
    //   104	1	0	localIOException1	IOException
    //   112	1	0	localObject2	Object
    //   135	1	0	localIOException2	IOException
    //   143	1	0	localObject3	Object
    //   166	1	0	localIOException3	IOException
    //   172	6	0	localObject4	Object
    //   191	1	0	localIOException4	IOException
    //   195	1	0	localIOException5	IOException
    //   40	118	1	localObjectInputStream	java.io.ObjectInputStream
    //   170	20	1	localObject5	Object
    //   199	1	1	localObject6	Object
    //   77	8	2	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   108	8	2	localIOException6	IOException
    //   139	8	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   203	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   207	1	2	localIOException7	IOException
    //   211	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    // Exception table:
    //   from	to	target	type
    //   32	41	77	java/io/StreamCorruptedException
    //   95	101	104	java/io/IOException
    //   32	41	108	java/io/IOException
    //   126	132	135	java/io/IOException
    //   32	41	139	java/lang/ClassNotFoundException
    //   157	163	166	java/io/IOException
    //   32	41	170	finally
    //   55	61	191	java/io/IOException
    //   177	183	195	java/io/IOException
    //   43	55	199	finally
    //   82	91	199	finally
    //   113	122	199	finally
    //   144	153	199	finally
    //   43	55	203	java/lang/ClassNotFoundException
    //   43	55	207	java/io/IOException
    //   43	55	211	java/io/StreamCorruptedException
  }
  
  private static void dHb()
  {
    AppMethodBeat.i(95407);
    xPD = new a.5((int)Math.ceil(666.66668701171875D) + 1);
    AppMethodBeat.o(95407);
  }
  
  public static void e(LinkedList<cmj> paramLinkedList, LinkedList<SnsObject> paramLinkedList1)
  {
    AppMethodBeat.i(95392);
    if (paramLinkedList != null)
    {
      paramLinkedList = aO(paramLinkedList);
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        di localdi = (di)localIterator.next();
        if (xa(localdi.DQo.FIN.Id))
        {
          ac.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + localdi.DQo.FIN.Id);
          localIterator.remove();
        }
      }
      w(paramLinkedList, paramLinkedList1);
    }
    AppMethodBeat.o(95392);
  }
  
  private static void w(List<di> paramList, List<SnsObject> paramList1)
  {
    AppMethodBeat.i(95394);
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      AppMethodBeat.o(95394);
      return;
    }
    int k = a((SnsObject)paramList1.get(paramList1.size() - 1));
    int i = 0;
    if (i < paramList.size())
    {
      di localdi = (di)paramList.get(i);
      if (localdi == null) {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
      }
      Object localObject;
      com.tencent.mm.plugin.sns.storage.a locala;
      for (;;)
      {
        i += 1;
        break;
        if (localdi.DQo == null)
        {
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
        }
        else if (localdi.DQo.FIN == null)
        {
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
        }
        else
        {
          localObject = z.a(localdi.DQp);
          String str1 = z.a(localdi.DQo.FIO);
          String str2 = z.b(localdi.DQo.FIN.ObjectDesc);
          locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject);
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "skXml ".concat(String.valueOf(localObject)));
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "adXml ".concat(String.valueOf(str1)));
          ac.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + str2 + "\r\n");
          localObject = new com.tencent.mm.plugin.sns.storage.b(str1);
          if ((((com.tencent.mm.plugin.sns.storage.b)localObject).yfR == 0L) || (!xa(((com.tencent.mm.plugin.sns.storage.b)localObject).yfR))) {
            break label309;
          }
          ac.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + ((com.tencent.mm.plugin.sns.storage.b)localObject).yfR);
        }
      }
      label309:
      int j = k + 1;
      if ((locala.yew < paramList1.size()) && (locala.yew >= 0))
      {
        j = a((SnsObject)paramList1.get(locala.yew)) + 1;
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.yew);
      }
      for (;;)
      {
        int m = (int)(System.currentTimeMillis() / 1000L);
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(m)));
        a(localdi, j, m);
        xb(localdi.DQo.FIN.Id);
        xb(((com.tencent.mm.plugin.sns.storage.b)localObject).yfR);
        a(localdi.DQo.FIN.Id, locala);
        break;
        ac.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.yew);
      }
    }
    AppMethodBeat.o(95394);
  }
  
  public static void wY(long paramLong)
  {
    AppMethodBeat.i(200108);
    com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(paramLong);
    if (locale == null)
    {
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
      AppMethodBeat.o(200108);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
      if (localSnsObject == null)
      {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "snsObject is null!");
        AppMethodBeat.o(200108);
        return;
      }
      boolean bool = com.tencent.mm.plugin.sns.data.j.a(localSnsObject, u.axw());
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAd, hasCommentLike %s , id %s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.plugin.sns.data.q.wW(paramLong) });
      if (!bool) {}
      try
      {
        h.a(0, paramLong, locale.dFQ(), locale.dFR());
        af.dHU().delete(paramLong);
        af.dHW().xF(paramLong);
        i.xE(paramLong);
        AppMethodBeat.o(200108);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.e("MicroMsg.AdSnsInfoStorageLogic", "reportAdDelException: " + localThrowable.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AdSnsInfoStorageLogic", "deleteAd， parse SnsObject error!:" + localException.toString());
      AppMethodBeat.o(200108);
    }
  }
  
  public static void wZ(long paramLong)
  {
    AppMethodBeat.i(200109);
    try
    {
      String str = com.tencent.mm.plugin.sns.data.q.wW(paramLong);
      com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(paramLong);
      if (locale == null)
      {
        ac.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, adSnsInfo is null, snsId=".concat(String.valueOf(str)));
        AppMethodBeat.o(200109);
        return;
      }
      ac.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=".concat(String.valueOf(str)));
      try
      {
        h.a(1, paramLong, locale.dFQ(), locale.dFR());
        af.dHU().delete(paramLong);
        af.dHW().xF(paramLong);
        i.xE(paramLong);
        AppMethodBeat.o(200109);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.e("MicroMsg.AdSnsInfoStorageLogic", "reportAdDelException: " + localThrowable.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=" + com.tencent.mm.plugin.sns.data.q.wW(paramLong) + ", exp=" + localException.toString());
      AppMethodBeat.o(200109);
    }
  }
  
  /* Error */
  public static void x(List<di> paramList, List<SnsObject> paramList1)
  {
    // Byte code:
    //   0: ldc_w 1111
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +16 -> 23
    //   10: aload_1
    //   11: ifnull +12 -> 23
    //   14: aload_1
    //   15: invokeinterface 1014 1 0
    //   20: ifne +10 -> 30
    //   23: ldc_w 1111
    //   26: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_1
    //   31: aload_1
    //   32: invokeinterface 1014 1 0
    //   37: iconst_1
    //   38: isub
    //   39: invokeinterface 1015 2 0
    //   44: checkcast 79	com/tencent/mm/protocal/protobuf/SnsObject
    //   47: invokestatic 1017	com/tencent/mm/plugin/sns/model/a:a	(Lcom/tencent/mm/protocal/protobuf/SnsObject;)I
    //   50: istore 5
    //   52: iconst_1
    //   53: istore_2
    //   54: new 31	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   61: astore 13
    //   63: aload 13
    //   65: ldc_w 1113
    //   68: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: iconst_0
    //   73: istore_3
    //   74: iload_3
    //   75: aload_0
    //   76: invokeinterface 1014 1 0
    //   81: if_icmpge +835 -> 916
    //   84: aload_0
    //   85: iload_3
    //   86: invokeinterface 1015 2 0
    //   91: checkcast 102	com/tencent/mm/protocal/protobuf/di
    //   94: astore 14
    //   96: aload 14
    //   98: ifnonnull +18 -> 116
    //   101: ldc 114
    //   103: ldc_w 1019
    //   106: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: iload_3
    //   110: iconst_1
    //   111: iadd
    //   112: istore_3
    //   113: goto -39 -> 74
    //   116: aload 14
    //   118: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   121: ifnonnull +14 -> 135
    //   124: ldc 114
    //   126: ldc_w 1021
    //   129: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -23 -> 109
    //   135: aload 14
    //   137: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   140: getfield 296	com/tencent/mm/protocal/protobuf/czp:FIN	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   143: ifnonnull +14 -> 157
    //   146: ldc 114
    //   148: ldc_w 1023
    //   151: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -45 -> 109
    //   157: aload 14
    //   159: getfield 112	com/tencent/mm/protocal/protobuf/di:DQp	Lcom/tencent/mm/protocal/protobuf/crm;
    //   162: invokestatic 348	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/crm;)Ljava/lang/String;
    //   165: astore 9
    //   167: aload 14
    //   169: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   172: getfield 439	com/tencent/mm/protocal/protobuf/czp:FIO	Lcom/tencent/mm/protocal/protobuf/crm;
    //   175: invokestatic 348	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/crm;)Ljava/lang/String;
    //   178: astore 10
    //   180: aload 14
    //   182: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   185: getfield 296	com/tencent/mm/protocal/protobuf/czp:FIN	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   188: getfield 679	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   191: invokestatic 682	com/tencent/mm/platformtools/z:b	(Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;)Ljava/lang/String;
    //   194: astore 11
    //   196: new 253	com/tencent/mm/plugin/sns/storage/a
    //   199: dup
    //   200: aload 9
    //   202: invokespecial 349	com/tencent/mm/plugin/sns/storage/a:<init>	(Ljava/lang/String;)V
    //   205: astore 15
    //   207: ldc 114
    //   209: ldc_w 1115
    //   212: iconst_3
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload 9
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload 10
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: aload 11
    //   230: aastore
    //   231: invokestatic 230	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: iload_2
    //   235: ifeq +812 -> 1047
    //   238: aload 14
    //   240: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   243: getfield 296	com/tencent/mm/protocal/protobuf/czp:FIN	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   246: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   249: lstore 7
    //   251: aload 15
    //   253: getfield 1118	com/tencent/mm/plugin/sns/storage/a:yeO	Ljava/lang/String;
    //   256: astore 16
    //   258: aload 15
    //   260: getfield 366	com/tencent/mm/plugin/sns/storage/a:dtx	Ljava/lang/String;
    //   263: astore 11
    //   265: aload 11
    //   267: ldc_w 1120
    //   270: invokestatic 1125	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   273: astore 9
    //   275: invokestatic 1130	com/tencent/mm/plugin/sns/data/f:dGv	()Ljava/lang/String;
    //   278: astore 10
    //   280: aload 10
    //   282: ldc_w 1120
    //   285: invokestatic 1125	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 12
    //   290: aload 12
    //   292: astore 10
    //   294: lload 7
    //   296: invokestatic 725	com/tencent/mm/plugin/sns/data/q:wW	(J)Ljava/lang/String;
    //   299: astore 12
    //   301: ldc_w 1132
    //   304: new 31	java/lang/StringBuilder
    //   307: dup
    //   308: ldc_w 1134
    //   311: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload 12
    //   316: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 1136
    //   322: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 16
    //   327: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 1138
    //   333: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 11
    //   338: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 1140
    //   344: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 10
    //   349: invokevirtual 210	java/lang/String:length	()I
    //   352: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: getstatic 1146	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   364: sipush 17763
    //   367: bipush 6
    //   369: anewarray 4	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: aload 12
    //   376: aastore
    //   377: dup
    //   378: iconst_1
    //   379: aload 16
    //   381: aastore
    //   382: dup
    //   383: iconst_2
    //   384: aload 9
    //   386: aastore
    //   387: dup
    //   388: iconst_3
    //   389: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   392: ldc2_w 587
    //   395: ldiv
    //   396: invokestatic 543	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   399: aastore
    //   400: dup
    //   401: iconst_4
    //   402: aload 10
    //   404: aastore
    //   405: dup
    //   406: iconst_5
    //   407: ldc 158
    //   409: aastore
    //   410: invokevirtual 1149	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   413: iconst_0
    //   414: istore_2
    //   415: aload 13
    //   417: aload 14
    //   419: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   422: getfield 296	com/tencent/mm/protocal/protobuf/czp:FIN	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   425: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   428: invokestatic 725	com/tencent/mm/plugin/sns/data/q:wW	(J)Ljava/lang/String;
    //   431: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 1151
    //   437: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 13
    //   443: aload 15
    //   445: getfield 847	com/tencent/mm/plugin/sns/storage/a:yew	I
    //   448: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: ldc_w 1153
    //   454: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: iload 5
    //   460: iconst_1
    //   461: iadd
    //   462: istore 4
    //   464: aload 15
    //   466: getfield 847	com/tencent/mm/plugin/sns/storage/a:yew	I
    //   469: aload_1
    //   470: invokeinterface 1014 1 0
    //   475: if_icmpge +412 -> 887
    //   478: aload 15
    //   480: getfield 847	com/tencent/mm/plugin/sns/storage/a:yew	I
    //   483: iflt +404 -> 887
    //   486: aload_1
    //   487: aload 15
    //   489: getfield 847	com/tencent/mm/plugin/sns/storage/a:yew	I
    //   492: invokeinterface 1015 2 0
    //   497: checkcast 79	com/tencent/mm/protocal/protobuf/SnsObject
    //   500: invokestatic 1017	com/tencent/mm/plugin/sns/model/a:a	(Lcom/tencent/mm/protocal/protobuf/SnsObject;)I
    //   503: iconst_1
    //   504: iadd
    //   505: istore 4
    //   507: ldc 114
    //   509: new 31	java/lang/StringBuilder
    //   512: dup
    //   513: ldc_w 1038
    //   516: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: iload 4
    //   521: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: ldc_w 1040
    //   527: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 15
    //   532: getfield 847	com/tencent/mm/plugin/sns/storage/a:yew	I
    //   535: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   547: ldc2_w 587
    //   550: ldiv
    //   551: l2i
    //   552: istore 6
    //   554: ldc 114
    //   556: ldc_w 1042
    //   559: iload 6
    //   561: invokestatic 1044	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   564: invokevirtual 472	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   567: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload 14
    //   572: iload 4
    //   574: iload 6
    //   576: invokestatic 884	com/tencent/mm/plugin/sns/model/a:a	(Lcom/tencent/mm/protocal/protobuf/di;II)V
    //   579: invokestatic 303	com/tencent/mm/plugin/sns/model/af:dHU	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   582: aload 14
    //   584: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   587: getfield 296	com/tencent/mm/protocal/protobuf/czp:FIN	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   590: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   593: invokevirtual 462	com/tencent/mm/plugin/sns/storage/f:xB	(J)Lcom/tencent/mm/plugin/sns/storage/e;
    //   596: astore 11
    //   598: aload 11
    //   600: ifnull +116 -> 716
    //   603: aload 11
    //   605: invokevirtual 912	com/tencent/mm/plugin/sns/storage/e:dLW	()Lcom/tencent/mm/protocal/protobuf/ca;
    //   608: astore 10
    //   610: aload 10
    //   612: astore 9
    //   614: aload 10
    //   616: ifnonnull +12 -> 628
    //   619: new 914	com/tencent/mm/protocal/protobuf/ca
    //   622: dup
    //   623: invokespecial 915	com/tencent/mm/protocal/protobuf/ca:<init>	()V
    //   626: astore 9
    //   628: aload 9
    //   630: aload 14
    //   632: getfield 919	com/tencent/mm/protocal/protobuf/di:DQr	Lcom/tencent/mm/protocal/protobuf/cob;
    //   635: putfield 1156	com/tencent/mm/protocal/protobuf/ca:DPq	Lcom/tencent/mm/protocal/protobuf/cob;
    //   638: aload 9
    //   640: getfield 1156	com/tencent/mm/protocal/protobuf/ca:DPq	Lcom/tencent/mm/protocal/protobuf/cob;
    //   643: ifnull +43 -> 686
    //   646: ldc 114
    //   648: ldc_w 1158
    //   651: iconst_2
    //   652: anewarray 4	java/lang/Object
    //   655: dup
    //   656: iconst_0
    //   657: aload 9
    //   659: getfield 1156	com/tencent/mm/protocal/protobuf/ca:DPq	Lcom/tencent/mm/protocal/protobuf/cob;
    //   662: getfield 929	com/tencent/mm/protocal/protobuf/cob:FBm	J
    //   665: invokestatic 543	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: aastore
    //   669: dup
    //   670: iconst_1
    //   671: aload 9
    //   673: getfield 1156	com/tencent/mm/protocal/protobuf/ca:DPq	Lcom/tencent/mm/protocal/protobuf/cob;
    //   676: getfield 932	com/tencent/mm/protocal/protobuf/cob:FBh	I
    //   679: invokestatic 580	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   682: aastore
    //   683: invokestatic 230	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   686: aload 11
    //   688: aload 9
    //   690: invokevirtual 935	com/tencent/mm/plugin/sns/storage/e:a	(Lcom/tencent/mm/protocal/protobuf/ca;)V
    //   693: aload 11
    //   695: aload 11
    //   697: getfield 905	com/tencent/mm/plugin/sns/storage/e:field_localFlag	I
    //   700: sipush -257
    //   703: iand
    //   704: putfield 905	com/tencent/mm/plugin/sns/storage/e:field_localFlag	I
    //   707: invokestatic 303	com/tencent/mm/plugin/sns/model/af:dHU	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   710: aload 11
    //   712: invokevirtual 1161	com/tencent/mm/plugin/sns/storage/f:replace	(Lcom/tencent/mm/sdk/e/c;)Z
    //   715: pop
    //   716: aload 14
    //   718: getfield 133	com/tencent/mm/protocal/protobuf/di:DQo	Lcom/tencent/mm/protocal/protobuf/czp;
    //   721: getfield 296	com/tencent/mm/protocal/protobuf/czp:FIN	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   724: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   727: aload 15
    //   729: invokestatic 886	com/tencent/mm/plugin/sns/model/a:a	(JLcom/tencent/mm/plugin/sns/storage/a;)V
    //   732: goto -623 -> 109
    //   735: astore 9
    //   737: ldc_w 1132
    //   740: new 31	java/lang/StringBuilder
    //   743: dup
    //   744: ldc_w 1163
    //   747: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   750: aload 9
    //   752: invokevirtual 1101	java/lang/Exception:toString	()Ljava/lang/String;
    //   755: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: ldc_w 1165
    //   761: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload 11
    //   766: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   775: aload 11
    //   777: astore 9
    //   779: goto -504 -> 275
    //   782: astore 12
    //   784: ldc_w 1132
    //   787: new 31	java/lang/StringBuilder
    //   790: dup
    //   791: ldc_w 1163
    //   794: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   797: aload 12
    //   799: invokevirtual 1101	java/lang/Exception:toString	()Ljava/lang/String;
    //   802: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: ldc_w 1165
    //   808: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload 10
    //   813: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: goto -528 -> 294
    //   825: astore 9
    //   827: ldc 114
    //   829: new 31	java/lang/StringBuilder
    //   832: dup
    //   833: ldc_w 1167
    //   836: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   839: aload 9
    //   841: invokevirtual 1101	java/lang/Exception:toString	()Ljava/lang/String;
    //   844: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   853: goto -440 -> 413
    //   856: astore 9
    //   858: ldc 114
    //   860: new 31	java/lang/StringBuilder
    //   863: dup
    //   864: ldc_w 1169
    //   867: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   870: aload 9
    //   872: invokevirtual 1101	java/lang/Exception:toString	()Ljava/lang/String;
    //   875: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: goto -426 -> 458
    //   887: ldc 114
    //   889: new 31	java/lang/StringBuilder
    //   892: dup
    //   893: ldc_w 1050
    //   896: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   899: aload 15
    //   901: getfield 847	com/tencent/mm/plugin/sns/storage/a:yew	I
    //   904: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   907: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 243	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   913: goto -369 -> 544
    //   916: aload 13
    //   918: ldc_w 1171
    //   921: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: iconst_0
    //   926: istore_2
    //   927: iload_2
    //   928: aload_1
    //   929: invokeinterface 1014 1 0
    //   934: if_icmpge +38 -> 972
    //   937: aload 13
    //   939: aload_1
    //   940: iload_2
    //   941: invokeinterface 1015 2 0
    //   946: checkcast 79	com/tencent/mm/protocal/protobuf/SnsObject
    //   949: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   952: invokestatic 725	com/tencent/mm/plugin/sns/data/q:wW	(J)Ljava/lang/String;
    //   955: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: ldc_w 1151
    //   961: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: iload_2
    //   966: iconst_1
    //   967: iadd
    //   968: istore_2
    //   969: goto -42 -> 927
    //   972: aload 13
    //   974: ldc_w 1173
    //   977: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: ldc 114
    //   983: new 31	java/lang/StringBuilder
    //   986: dup
    //   987: ldc_w 1175
    //   990: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   993: aload 13
    //   995: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: ldc_w 1111
    //   1010: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1013: return
    //   1014: astore_0
    //   1015: ldc 114
    //   1017: new 31	java/lang/StringBuilder
    //   1020: dup
    //   1021: ldc_w 1169
    //   1024: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1027: aload_0
    //   1028: invokevirtual 1101	java/lang/Exception:toString	()Ljava/lang/String;
    //   1031: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1040: ldc_w 1111
    //   1043: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1046: return
    //   1047: goto -632 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1050	0	paramList	List<di>
    //   0	1050	1	paramList1	List<SnsObject>
    //   53	916	2	i	int
    //   73	40	3	j	int
    //   462	111	4	k	int
    //   50	412	5	m	int
    //   552	23	6	n	int
    //   249	46	7	l	long
    //   165	524	9	localObject1	Object
    //   735	16	9	localException1	Exception
    //   777	1	9	localObject2	Object
    //   825	15	9	localException2	Exception
    //   856	15	9	localException3	Exception
    //   178	634	10	localObject3	Object
    //   194	582	11	localObject4	Object
    //   288	87	12	str1	String
    //   782	16	12	localException4	Exception
    //   61	933	13	localStringBuilder	StringBuilder
    //   94	623	14	localdi	di
    //   205	695	15	locala	com.tencent.mm.plugin.sns.storage.a
    //   256	124	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   265	275	735	java/lang/Exception
    //   280	290	782	java/lang/Exception
    //   238	265	825	java/lang/Exception
    //   275	280	825	java/lang/Exception
    //   294	413	825	java/lang/Exception
    //   737	775	825	java/lang/Exception
    //   784	822	825	java/lang/Exception
    //   415	458	856	java/lang/Exception
    //   916	925	1014	java/lang/Exception
    //   927	965	1014	java/lang/Exception
    //   972	1007	1014	java/lang/Exception
  }
  
  private static boolean xa(long paramLong)
  {
    AppMethodBeat.i(95405);
    dHa();
    if (xPD.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(95405);
      return true;
    }
    AppMethodBeat.o(95405);
    return false;
  }
  
  private static void xb(long paramLong)
  {
    AppMethodBeat.i(95408);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(95408);
      return;
    }
    if (xPD == null) {
      dHa();
    }
    xPD.put(Long.valueOf(paramLong), Integer.valueOf(0));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      Object localObject1 = new ObjectOutputStream(localByteArrayOutputStream);
      ((ObjectOutput)localObject1).writeObject(xPD);
      ((ObjectOutput)localObject1).flush();
      localObject1 = localByteArrayOutputStream.toByteArray();
      com.tencent.mm.pluginsdk.h.a.d.a.x(xPC, (byte[])localObject1);
      try
      {
        localByteArrayOutputStream.close();
        AppMethodBeat.o(95408);
        return;
      }
      catch (IOException localIOException1)
      {
        AppMethodBeat.o(95408);
        return;
      }
      try
      {
        localIOException2.close();
        AppMethodBeat.o(95408);
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        break label141;
      }
    }
    catch (IOException localIOException4)
    {
      localIOException4 = localIOException4;
      ac.e("MicroMsg.AdSnsInfoStorageLogic", bs.m(localIOException4));
      try
      {
        localIOException1.close();
        AppMethodBeat.o(95408);
        return;
      }
      catch (IOException localIOException2)
      {
        AppMethodBeat.o(95408);
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a
 * JD-Core Version:    0.7.0.1
 */