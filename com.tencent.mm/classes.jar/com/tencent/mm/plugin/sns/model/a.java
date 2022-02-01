package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private static final String zwm;
  private static LinkedHashMap<Long, Integer> zwn;
  private static Comparator<dgh> zwo;
  
  static
  {
    AppMethodBeat.i(95410);
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajS();
    zwm = g.ajR().cachePath + "sns_recvd_ad";
    zwo = new Comparator() {};
    AppMethodBeat.o(95410);
  }
  
  public static void T(long paramLong, int paramInt)
  {
    AppMethodBeat.i(219329);
    try
    {
      String str = r.zV(paramLong);
      com.tencent.mm.plugin.sns.storage.e locale = ah.dXH().Ax(paramLong);
      if (locale == null)
      {
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, adSnsInfo is null, snsId=".concat(String.valueOf(str)));
        AppMethodBeat.o(219329);
        return;
      }
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=".concat(String.valueOf(str)));
      try
      {
        com.tencent.mm.plugin.sns.data.i.a(paramInt, paramLong, locale.dVi(), locale.dVj());
        ah.dXH().delete(paramLong);
        ah.dXJ().AB(paramLong);
        com.tencent.mm.plugin.sns.storage.i.AA(paramLong);
        AppMethodBeat.o(219329);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.e("MicroMsg.AdSnsInfoStorageLogic", "reportAdDelException: " + localThrowable.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=" + r.zV(paramLong) + ", exp=" + localException.toString());
      AppMethodBeat.o(219329);
    }
  }
  
  private static dj a(cse paramcse)
  {
    AppMethodBeat.i(95390);
    if (paramcse != null)
    {
      dj localdj = new dj();
      localdj.FOc = paramcse.HDo;
      if (localdj.FOc == null)
      {
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
        AppMethodBeat.o(95390);
        return null;
      }
      localdj.FOb = b(paramcse.HDn);
      AppMethodBeat.o(95390);
      return localdj;
    }
    AppMethodBeat.o(95390);
    return null;
  }
  
  private static String a(String paramString, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(95409);
    if ((paramSKBuiltinBuffer_t == null) || (paramString == null))
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
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
        if (((ab)localObject1).FJa != null)
        {
          localObject2 = "";
          localIterator = ((ab)localObject1).FJa.iterator();
          paramSKBuiltinBuffer_t = paramString;
          localObject1 = paramSKBuiltinBuffer_t;
        }
        dfz localdfz;
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
            localdfz = (dfz)localIterator.next();
            localObject1 = paramSKBuiltinBuffer_t;
            if (localdfz.key == null) {
              break label363;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            str = String.format("<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))", new Object[] { localdfz.key });
            localObject1 = paramSKBuiltinBuffer_t;
            localObject3 = Pattern.compile(str).matcher(paramSKBuiltinBuffer_t);
            localObject1 = paramSKBuiltinBuffer_t;
            if (!((Matcher)localObject3).find()) {
              break label363;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            localObject3 = ((Matcher)localObject3).group(2);
            if (localObject3 == null) {
              break label363;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            if (((String)localObject3).length() <= 0) {
              break label363;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.replaceAll(str + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[] { localObject3 }), String.format("<$1>%s</%s>", new Object[] { localdfz.value, localObject3 }));
            localObject1 = paramSKBuiltinBuffer_t;
            localObject2 = (String)localObject2 + localdfz.key + ":" + localdfz.value + ";";
            localObject1 = localObject2;
            break label373;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", new Object[] { localObject2 });
          localObject2 = paramSKBuiltinBuffer_t;
          localObject1 = paramSKBuiltinBuffer_t;
          if (bx.M(paramString, "ADInfo") != null) {
            continue;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          ae.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
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
        ae.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramString, "replace error occurs!", new Object[0]);
        localObject2 = localObject1;
        AppMethodBeat.o(95409);
        return localObject2;
      }
      label363:
      continue;
      label373:
      Object localObject2 = localObject1;
    }
  }
  
  private static void a(long paramLong, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(95396);
    if ((!parama.zMu) || (bu.isNullOrNil(parama.zMt)))
    {
      AppMethodBeat.o(95396);
      return;
    }
    parama = new m(paramLong, 1, parama.zMt);
    g.ajS();
    g.ajQ().gDv.a(parama, 0);
    AppMethodBeat.o(95396);
  }
  
  public static void a(dfw paramdfw)
  {
    AppMethodBeat.i(95382);
    if (paramdfw == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95382);
      return;
    }
    if (paramdfw.HMY == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95382);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramdfw);
    ah.dXH().a(paramdfw.HMY.Id, locale);
    AppMethodBeat.o(95382);
  }
  
  public static void a(dfw paramdfw, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(95380);
    if (paramdfw == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95380);
      return;
    }
    if (paramdfw.HMY == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95380);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramdfw);
    if (locale == null)
    {
      AppMethodBeat.o(95380);
      return;
    }
    locale.field_adinfo = a(locale.field_adinfo, paramSKBuiltinBuffer_t);
    if (ah.dXH().Ay(paramdfw.HMY.Id))
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + paramdfw.HMY.Id);
      ah.dXH().b(paramdfw.HMY.Id, locale);
      AppMethodBeat.o(95380);
      return;
    }
    ae.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + paramdfw.HMY.Id);
    AppMethodBeat.o(95380);
  }
  
  public static void a(dhh paramdhh)
  {
    AppMethodBeat.i(95381);
    a(b(paramdhh));
    AppMethodBeat.o(95381);
  }
  
  private static void a(dj paramdj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95388);
    if (paramdj == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95388);
      return;
    }
    if ((paramdj.FOb == null) || (paramdj.FOb.HMY == null))
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95388);
      return;
    }
    SnsObject localSnsObject = paramdj.FOb.HMY;
    com.tencent.mm.plugin.sns.storage.e locale = b(paramdj.FOb);
    if (locale == null)
    {
      ae.w("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
      AppMethodBeat.o(95388);
      return;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.a(z.a(paramdj.FOc));
    TimeLineObject localTimeLineObject = locale.ebP();
    djc localdjc = new djc();
    localdjc.HQJ = new djd();
    localdjc.HQJ.FEJ = ((com.tencent.mm.plugin.sns.storage.a)localObject).dGD;
    localdjc.HQJ.HQM = localTimeLineObject.Id;
    localdjc.HQJ.doj = locale.getSource();
    localdjc.HQJ.Adw = com.tencent.mm.modelstat.p.a(localdjc.HQJ);
    if (localTimeLineObject.HUG.Gtw == 1) {
      localdjc.HQJ.zMQ = 1;
    }
    for (;;)
    {
      localdjc.HQJ.HQN = locale.ebO();
      try
      {
        localObject = Base64.encodeToString(localdjc.toByteArray(), 0).replace("\n", "");
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[] { localTimeLineObject.Id, localObject, localdjc.HQJ.HQM, localdjc.HQJ.FEJ });
        localTimeLineObject.AiG = ((String)localObject);
        locale.f(localTimeLineObject);
        if (locale == null)
        {
          AppMethodBeat.o(95388);
          return;
          if (localTimeLineObject.HUG.Gtw == 15)
          {
            localdjc.HQJ.zMQ = 2;
            continue;
          }
          localdjc.HQJ.zMQ = 0;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", localIOException, "", new Object[0]);
        }
        locale.field_createTime = paramInt1;
        locale.field_createAdTime = paramInt2;
        String str = z.a(paramdj.FOb.HMZ);
        if (!bu.isNullOrNil(str)) {
          locale.field_recxml = str;
        }
        locale.field_adinfo = z.a(paramdj.FOc);
        locale.field_adxml = locale.field_recxml;
        ah.dXH().a(localSnsObject.Id, locale);
        AppMethodBeat.o(95388);
      }
    }
  }
  
  public static void a(List<dj> paramList, List<SnsObject> paramList1, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(219330);
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      AppMethodBeat.o(219330);
      return;
    }
    int m = b((SnsObject)paramList1.get(paramList1.size() - 1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adList[");
    int k = 0;
    int i = 0;
    if (k < paramList.size())
    {
      dj localdj = (dj)paramList.get(k);
      if (localdj == null) {
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
      }
      for (;;)
      {
        k += 1;
        break;
        if (localdj.FOb == null)
        {
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
        }
        else if (localdj.FOb.HMY == null)
        {
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
        }
        else
        {
          Object localObject1 = z.a(localdj.FOc);
          Object localObject2 = z.a(localdj.FOb.HMZ);
          Object localObject3 = z.b(localdj.FOb.HMY.ObjectDesc);
          com.tencent.mm.plugin.sns.storage.a locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject1);
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "skXml %s, adXml %s, snsXml %s", new Object[] { localObject1, localObject2, localObject3 });
          try
          {
            localStringBuilder.append(r.zV(localdj.FOb.HMY.Id)).append(",");
            localStringBuilder.append(locala.zLO).append("|");
            j = m + 1;
            if ((locala.zLO < paramList1.size()) && (locala.zLO >= 0))
            {
              j = b((SnsObject)paramList1.get(locala.zLO)) + 1;
              ae.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.zLO);
              int n = (int)(System.currentTimeMillis() / 1000L);
              ae.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(n)));
              a(localdj, j, n);
              localObject3 = ah.dXH().Ax(localdj.FOb.HMY.Id);
              j = i;
              if (localObject3 != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.storage.e)localObject3).ebQ();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ca();
                }
                ((ca)localObject1).FMY = localdj.FOe;
                if (((ca)localObject1).FMY != null) {
                  ae.i("MicroMsg.AdSnsInfoStorageLogic", "update timeline remind info , aid64:%d, aid:%d", new Object[] { Long.valueOf(((ca)localObject1).FMY.HEZ), Integer.valueOf(((ca)localObject1).FMY.HEU) });
                }
                ((com.tencent.mm.plugin.sns.storage.e)localObject3).a((ca)localObject1);
                ((com.tencent.mm.plugin.sns.storage.e)localObject3).field_localFlag &= 0xFFFFFEFF;
                ah.dXH().replace((com.tencent.mm.sdk.e.c)localObject3);
                localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject3).ebV();
                j = i;
                if (com.tencent.mm.plugin.sns.ad.timeline.a.a.j((com.tencent.mm.plugin.sns.storage.p)localObject1))
                {
                  j = 1;
                  ah.dXC().z((com.tencent.mm.plugin.sns.storage.p)localObject1);
                }
              }
              a(localdj.FOb.HMY.Id, locala);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              try
              {
                localObject1 = r.zV(localdj.FOb.HMY.Id);
                if (!com.tencent.mm.plugin.sns.ad.timeline.a.c.a(locala, (String)localObject1)) {
                  com.tencent.mm.plugin.sns.ad.timeline.a.c.a((String)localObject1, locala);
                }
                i = j;
              }
              catch (Throwable localThrowable)
              {
                int j;
                ae.e("MicroMsg.AdSnsInfoStorageLogic", localThrowable.toString());
                i = j;
              }
              localException = localException;
              ae.e("MicroMsg.AdSnsInfoStorageLogic", "log exp=" + localException.toString());
              continue;
              ae.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.zLO);
            }
          }
        }
      }
    }
    if (i != 0)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "the on line video preload start in AdSnsInfoStorageLogic ");
      ah.dXC().dYA();
    }
    for (;;)
    {
      try
      {
        localStringBuilder.append("], objList[");
        i = 0;
        if (i < paramList1.size()) {
          if (paramList1.size() > 0) {
            localStringBuilder.append(r.zV(((SnsObject)paramList1.get(i)).Id)).append("|").append(((SnsObject)paramList1.get(i)).Username).append(",");
          } else {
            localStringBuilder.append(r.zV(((SnsObject)paramList1.get(i)).Id)).append(",");
          }
        }
      }
      catch (Exception paramList)
      {
        ae.e("MicroMsg.AdSnsInfoStorageLogic", "log exp=" + paramList.toString());
        AppMethodBeat.o(219330);
        return;
      }
      localStringBuilder.append("], isFp:").append(paramBoolean).append(", pullType:").append(paramInt);
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "insert ad, " + localStringBuilder.toString());
      AppMethodBeat.o(219330);
      return;
      i += 1;
    }
  }
  
  public static boolean a(long paramLong, dgc paramdgc)
  {
    AppMethodBeat.i(95404);
    dgb localdgb = paramdgc.HNs;
    if ((localdgb.nJA != 7) && (localdgb.nJA != 8) && (localdgb.nJA != 16))
    {
      AppMethodBeat.o(95404);
      return false;
    }
    com.tencent.mm.plugin.sns.storage.e locale = ah.dXH().Ax(paramLong);
    if (locale == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(95404);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localdgb.nJA != 7) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdgh = (dgh)localIterator.next();
          if ((localdgh.CreateTime != localdgb.CreateTime) || (!localdgh.Username.equals(localdgb.HzT))) {
            continue;
          }
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localdgh.CreateTime + " ");
          AppMethodBeat.o(95404);
          return false;
        }
        localSnsObject.LikeUserList.add(af.b(paramdgc));
        locale.bL(localSnsObject.toByteArray());
        ah.dXH().a(localSnsObject.Id, locale);
      }
      catch (Exception paramdgc)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        dgh localdgh;
        ae.e("MicroMsg.AdSnsInfoStorageLogic", "e " + paramdgc.getMessage());
        ae.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramdgc, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95404);
      return true;
      if ((localdgb.nJA == 8) || (localdgb.nJA == 16))
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localdgh = (dgh)localIterator.next();
          if ((localdgh.CreateTime == localdgb.CreateTime) && (localdgh.Username.equals(localdgb.HzT)))
          {
            ae.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localdgh.CreateTime + " ");
            AppMethodBeat.o(95404);
            return false;
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(af.b(paramdgc));
        }
      }
    }
  }
  
  public static boolean a(long paramLong, dgc paramdgc, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(95403);
    Object localObject1;
    if (paramdgc != null)
    {
      localObject1 = paramdgc.HNs;
      if ((((dgb)localObject1).nJA != 7) && (((dgb)localObject1).nJA != 8) && (((dgb)localObject1).nJA != 16))
      {
        AppMethodBeat.o(95403);
        return false;
      }
    }
    Object localObject3 = v.aAC();
    if ((paramdgc != null) && (paramdgc.HNt != null) && (paramdgc.HNt.HzT != null) && (paramdgc.HNt.HzT.equals(localObject3)))
    {
      AppMethodBeat.o(95403);
      return true;
    }
    Object localObject2 = ah.dXH().Ax(paramLong);
    if (localObject2 == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", new Object[] { Long.valueOf(paramLong) });
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
        paramdgc = paramdgc.HNs;
        if (paramdgc.nJA != 7) {
          break;
        }
        if ((paramInt2 <= 0) || (k + paramInt2 >= paramdgc.CreateTime)) {
          break label822;
        }
        if (paramBoolean)
        {
          if (ah.dXE().aBq(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
            break label497;
          }
          localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).dVi();
          if (localObject4 == null) {
            continue;
          }
          localObject3 = (d)g.ab(d.class);
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          l = x.aze(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).aQj;
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
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionLikeTimeLimit: " + paramInt2 + " curAction.createTime: " + paramdgc.CreateTime + "is over the time limit!");
          AppMethodBeat.o(95403);
          return false;
        }
        paramInt1 = 0;
        continue;
        paramInt3 = 0;
        continue;
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        AppMethodBeat.o(95403);
      }
      catch (Exception paramdgc)
      {
        ae.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramdgc, "", new Object[0]);
      }
      return true;
      label497:
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
    }
    if (((paramdgc.nJA == 8) || (paramdgc.nJA == 16)) && (paramInt3 > 0) && (k + paramInt3 < paramdgc.CreateTime))
    {
      if (paramBoolean)
      {
        if (ah.dXE().aBq(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
          break label811;
        }
        localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).dVi();
        if (localObject4 == null) {
          break label800;
        }
        localObject3 = (d)g.ab(d.class);
        i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
        l = x.aze(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
        localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).aQj;
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
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionCommentTimeLimit: " + paramInt3 + " curAction.createTime: " + paramdgc.CreateTime + "is over the time limit!");
        AppMethodBeat.o(95403);
        return false;
        label789:
        paramInt1 = 0;
        break;
        label794:
        paramInt2 = 0;
        break label644;
        label800:
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        label811:
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
      }
    }
    label822:
    int i = 0;
    paramdgc = ((SnsObject)localObject1).LikeUserList.iterator();
    label834:
    int j;
    if (paramdgc.hasNext())
    {
      localObject4 = (dgh)paramdgc.next();
      if (((dgh)localObject4).CreateTime > k)
      {
        if ((localObject4 == null) || (((dgh)localObject4).Username == null)) {
          break label1264;
        }
        if (!((dgh)localObject4).Username.equals(localObject3)) {
          break label1264;
        }
      }
    }
    else
    {
      j = 0;
      paramdgc = ((SnsObject)localObject1).CommentUserList.iterator();
    }
    label1145:
    label1279:
    for (;;)
    {
      if (paramdgc.hasNext())
      {
        localObject4 = (dgh)paramdgc.next();
        if (((dgh)localObject4).CreateTime > k)
        {
          if ((localObject4 == null) || (((dgh)localObject4).Username == null)) {
            break label1273;
          }
          if (!((dgh)localObject4).Username.equals(localObject3)) {
            break label1273;
          }
        }
      }
      else
      {
        i = i + 0 + j;
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i + " firstCreateTime " + k + " actionLimit: " + paramInt1 + " actionLikeTimeLimit: " + paramInt2 + " actionCommentTimeLimit: " + paramInt3);
        if (i < paramInt1) {
          break;
        }
        if (paramBoolean)
        {
          paramdgc = ah.dXE().aBq(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          if (paramdgc == null) {
            break label1247;
          }
          localObject3 = paramdgc.dVi();
          if (localObject3 == null) {
            break label1236;
          }
          paramdgc = (d)g.ab(d.class);
          paramInt3 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          paramLong = x.aze(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).aQj;
          if (((SnsObject)localObject1).LikeUserList == null) {
            break label1225;
          }
          paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
          if (((SnsObject)localObject1).CommentUserList == null) {
            break label1230;
          }
          paramInt2 = ((SnsObject)localObject1).CommentUserList.size();
          paramdgc.a(13182, paramInt3, new Object[] { Long.valueOf(paramLong), localObject2, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        }
        for (;;)
        {
          AppMethodBeat.o(95403);
          return false;
          paramInt1 = 0;
          break;
          paramInt2 = 0;
          break label1145;
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
          continue;
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
        }
      }
      break label1279;
      break label1270;
      i += 1;
      break label834;
      j += 1;
    }
  }
  
  private static boolean a(dgh paramdgh, List<dgh> paramList)
  {
    AppMethodBeat.i(95386);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dgh localdgh = (dgh)paramList.next();
      if ((!bu.isNullOrNil(paramdgh.Username)) && (paramdgh.Username.equals(localdgh.Username)))
      {
        AppMethodBeat.o(95386);
        return true;
      }
    }
    AppMethodBeat.o(95386);
    return false;
  }
  
  private static LinkedList<dj> aQ(LinkedList<cse> paramLinkedList)
  {
    AppMethodBeat.i(95393);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dj localdj = a((cse)paramLinkedList.next());
      if (localdj != null) {
        localLinkedList.add(localdj);
      }
    }
    AppMethodBeat.o(95393);
    return localLinkedList;
  }
  
  public static void aR(LinkedList<cse> paramLinkedList)
  {
    AppMethodBeat.i(95397);
    if ((paramLinkedList != null) && (!paramLinkedList.isEmpty()))
    {
      paramLinkedList = aQ(paramLinkedList);
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      aS(paramLinkedList);
    }
    AppMethodBeat.o(95397);
  }
  
  public static void aS(LinkedList<dj> paramLinkedList)
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
      c((dj)paramLinkedList.get(i));
      i += 1;
    }
    AppMethodBeat.o(95398);
  }
  
  public static void aT(LinkedList<SnsObject> paramLinkedList)
  {
    AppMethodBeat.i(95400);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(95400);
      return;
    }
    com.tencent.mm.plugin.sns.storage.q localq = ah.dXE();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      Object localObject = (SnsObject)paramLinkedList.get(i);
      if (localObject != null)
      {
        localObject = localq.AG(((SnsObject)localObject).Id);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.sns.storage.p)localObject).ebP();
          if ((localObject != null) && (!bu.isNullOrNil(((TimeLineObject)localObject).AkC))) {
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95377);
                j.ebI().f("adId", this.zwq.AkC, "adxml", 0);
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
  
  public static void azO(String paramString)
  {
    AppMethodBeat.i(95401);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95401);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95378);
        j.ebI().f("adId", this.zwr, "adxml", 1);
        AppMethodBeat.o(95378);
      }
    }, "preDownloadAdLandingPagesForMsg");
    AppMethodBeat.o(95401);
  }
  
  private static int b(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95402);
    com.tencent.mm.plugin.sns.storage.p localp = ah.dXE().AG(paramSnsObject.Id);
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
  
  private static com.tencent.mm.plugin.sns.storage.e b(dfw paramdfw)
  {
    AppMethodBeat.i(95385);
    com.tencent.mm.plugin.sns.storage.e locale = ah.dXH().Ax(paramdfw.HMY.Id);
    SnsObject localSnsObject = paramdfw.HMY;
    Object localObject1 = null;
    if (locale == null) {
      locale = new com.tencent.mm.plugin.sns.storage.e();
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = z.b(localSnsObject.ObjectDesc);
      if (!bu.isNullOrNil((String)localObject2)) {
        break;
      }
      AppMethodBeat.o(95385);
      return null;
      localObject1 = locale.ebP().AiG;
    }
    if (!locale.aBp((String)localObject2))
    {
      AppMethodBeat.o(95385);
      return null;
    }
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject2 = locale.ebP();
      ((TimeLineObject)localObject2).AiG = ((String)localObject1);
      locale.f((TimeLineObject)localObject2);
    }
    localSnsObject.ObjectOperations = al.b(localSnsObject.ObjectOperations, locale.field_attrBuf);
    ae.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(localSnsObject.Id) });
    localSnsObject.ObjectDesc.setBuffer(new byte[0]);
    locale.field_userName = localSnsObject.Username;
    if (paramdfw.HMZ != null)
    {
      paramdfw = z.a(paramdfw.HMZ);
      if (!bu.isNullOrNil(paramdfw)) {
        locale.field_recxml = paramdfw;
      }
      paramdfw = locale.field_recxml;
      if ((!bu.isNullOrNil(paramdfw)) && (!paramdfw.equals(locale.field_adxml)))
      {
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml ".concat(String.valueOf(paramdfw)));
        locale.field_adxml = paramdfw;
      }
    }
    locale.field_likeFlag = localSnsObject.LikeFlag;
    long l = localSnsObject.Id;
    locale.field_snsId = l;
    if (l != 0L)
    {
      locale.field_stringSeq = r.zV(l);
      locale.field_stringSeq = r.azu(locale.field_stringSeq);
      ae.d("MicroMsg.AdSnsInfo", l + " stringSeq " + locale.field_stringSeq);
    }
    locale.Rq(2);
    locale.Rq(32);
    try
    {
      if (locale.field_attrBuf == null)
      {
        paramdfw = new SnsObject();
        if ((paramdfw == null) || (paramdfw.CommentUserList == null)) {
          break label891;
        }
        localObject1 = new LinkedList();
        localObject2 = localSnsObject.CommentUserList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label675;
          }
          localObject3 = (dgh)((Iterator)localObject2).next();
          if (((dgh)localObject3).DeleteFlag > 0)
          {
            ((List)localObject1).add(localObject3);
            localIterator = paramdfw.CommentUserList.iterator();
            if (localIterator.hasNext())
            {
              localdgh = (dgh)localIterator.next();
              if (localdgh.HNm != ((dgh)localObject3).HNm) {
                break;
              }
              paramdfw.CommentUserList.remove(localdgh);
            }
          }
        }
      }
    }
    catch (Exception paramdfw)
    {
      for (;;)
      {
        Object localObject3;
        Iterator localIterator;
        dgh localdgh;
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "error " + paramdfw.getMessage());
        ae.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramdfw, "", new Object[0]);
        try
        {
          for (;;)
          {
            locale.bL(localSnsObject.toByteArray());
            paramdfw = locale.ebP();
            paramdfw.nIJ = localSnsObject.Username;
            locale.field_pravited = paramdfw.Hml;
            ae.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + localSnsObject.ExtFlag + " " + localSnsObject.CommentUserList.size() + " " + localSnsObject.LikeUserList.size());
            localObject1 = paramdfw.HUG.Gtx.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((bzh)((Iterator)localObject1).next()).isAd = true;
            }
            paramdfw = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
            break;
            label675:
            localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (dgh)((Iterator)localObject2).next();
              localSnsObject.CommentUserList.remove(localObject3);
            }
            ((List)localObject1).clear();
            localObject1 = paramdfw.CommentUserList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (dgh)((Iterator)localObject1).next();
              if ((!b((dgh)localObject2, localSnsObject.CommentUserList)) && (((dgh)localObject2).HNm != 0L))
              {
                g.ajS();
                localObject3 = ((l)g.ab(l.class)).azF().BH(((dgh)localObject2).Username);
                if ((localObject3 != null) && (com.tencent.mm.contact.c.lO(((aw)localObject3).field_type)) && (!((an)localObject3).adv()))
                {
                  localSnsObject.CommentUserList.add(localObject2);
                  localSnsObject.CommentUserListCount = localSnsObject.CommentUserList.size();
                }
                else
                {
                  ae.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + ((dgh)localObject2).Username);
                }
              }
            }
            label891:
            Collections.sort(localSnsObject.CommentUserList, zwo);
            if (localSnsObject.LikeUserList != null)
            {
              localObject1 = new LinkedList();
              localObject2 = localSnsObject.LikeUserList.iterator();
              for (;;)
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break label1040;
                }
                localObject3 = (dgh)((Iterator)localObject2).next();
                if (((dgh)localObject3).DeleteFlag > 0)
                {
                  ((List)localObject1).add(localObject3);
                  localIterator = paramdfw.LikeUserList.iterator();
                  if (localIterator.hasNext())
                  {
                    localdgh = (dgh)localIterator.next();
                    if ((!bu.isNullOrNil(localdgh.Username)) && (!localdgh.Username.equals(((dgh)localObject3).Username))) {
                      break;
                    }
                    paramdfw.LikeUserList.remove(localdgh);
                  }
                }
              }
              label1040:
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (dgh)((Iterator)localObject2).next();
                localSnsObject.LikeUserList.remove(localObject3);
              }
              ((List)localObject1).clear();
              if ((paramdfw != null) && (paramdfw.LikeUserList != null))
              {
                paramdfw = paramdfw.LikeUserList.iterator();
                while (paramdfw.hasNext())
                {
                  localObject1 = (dgh)paramdfw.next();
                  if (!a((dgh)localObject1, localSnsObject.LikeUserList))
                  {
                    g.ajS();
                    localObject2 = ((l)g.ab(l.class)).azF().BH(((dgh)localObject1).Username);
                    if ((localObject2 != null) && (com.tencent.mm.contact.c.lO(((aw)localObject2).field_type)) && (!((an)localObject2).adv()))
                    {
                      localSnsObject.LikeUserList.add(localObject1);
                      localSnsObject.LikeUserListCount = localSnsObject.LikeUserList.size();
                    }
                    else
                    {
                      ae.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + ((dgh)localObject1).Username);
                    }
                  }
                }
              }
              Collections.sort(localSnsObject.LikeUserList, zwo);
            }
          }
        }
        catch (Exception paramdfw)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramdfw, "", new Object[0]);
          }
          locale.f(paramdfw);
          locale.field_type = paramdfw.HUG.Gtw;
          locale.field_subType = paramdfw.HUG.Gty;
          AppMethodBeat.o(95385);
        }
      }
    }
    return locale;
  }
  
  private static dfw b(dhh paramdhh)
  {
    AppMethodBeat.i(95389);
    if (paramdhh != null)
    {
      dfw localdfw = new dfw();
      localdfw.HMZ = paramdhh.HOs;
      if (localdfw.HMZ == null) {
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
      }
      localdfw.HMY = paramdhh.HMY;
      AppMethodBeat.o(95389);
      return localdfw;
    }
    AppMethodBeat.o(95389);
    return null;
  }
  
  public static void b(cse paramcse)
  {
    AppMethodBeat.i(95391);
    Object localObject = a(paramcse);
    if (localObject == null)
    {
      AppMethodBeat.o(95391);
      return;
    }
    paramcse = new com.tencent.mm.plugin.sns.storage.a(z.a(((dj)localObject).FOc));
    int j = paramcse.zLO;
    Cursor localCursor;
    com.tencent.mm.plugin.sns.storage.p localp;
    if (j <= 0)
    {
      i = 1;
      int k = ah.dXE().aBH("");
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      localCursor = ah.dXE().ax("", k, i);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label333;
      }
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[] { Integer.valueOf(localCursor.getCount()) });
      localp = new com.tencent.mm.plugin.sns.storage.p();
      if (j >= 0) {
        break label310;
      }
      i = 0;
      label160:
      if (!localCursor.moveToPosition(i)) {
        break label315;
      }
      localp.convertFrom(localCursor);
    }
    label178:
    for (int i = localp.field_createTime + 1;; i = (int)bu.aRi())
    {
      localCursor.close();
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + ((dj)localObject).FOb.HMY.Id + " ,createTime " + i);
      a((dj)localObject, i, (int)bu.aRi());
      c((dj)localObject);
      a(((dj)localObject).FOb.HMY.Id, paramcse);
      try
      {
        localObject = r.zV(((dj)localObject).FOb.HMY.Id);
        if (!com.tencent.mm.plugin.sns.ad.timeline.a.c.a(paramcse, (String)localObject)) {
          com.tencent.mm.plugin.sns.ad.timeline.a.c.a((String)localObject, paramcse);
        }
        AppMethodBeat.o(95391);
        return;
      }
      catch (Throwable paramcse)
      {
        ae.e("MicroMsg.AdSnsInfoStorageLogic", paramcse.toString());
        AppMethodBeat.o(95391);
      }
      i = j + 1;
      break;
      label310:
      i = j;
      break label160;
      label315:
      localCursor.moveToLast();
      localp.convertFrom(localCursor);
      break label178;
      label333:
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
    }
  }
  
  public static void b(dj paramdj)
  {
    AppMethodBeat.i(95383);
    if (paramdj == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
      AppMethodBeat.o(95383);
      return;
    }
    if (paramdj.FOb == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
      AppMethodBeat.o(95383);
      return;
    }
    if (paramdj.FOb.HMY == null)
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
      AppMethodBeat.o(95383);
      return;
    }
    Object localObject;
    if (!ah.dXH().Ay(paramdj.FOb.HMY.Id))
    {
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "insert at adObject");
      int i = (int)(System.currentTimeMillis() / 1000L);
      if (paramdj.FOb.HMY.CommentUserListCount > 0) {
        i = ((dgh)paramdj.FOb.HMY.CommentUserList.get(0)).CreateTime;
      }
      a(paramdj, i, i);
      localObject = ah.dXH().Ax(paramdj.FOb.HMY.Id);
      if (localObject != null)
      {
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
        ((com.tencent.mm.plugin.sns.storage.e)localObject).field_localFlag |= 0x100;
        ah.dXH().a(((com.tencent.mm.plugin.sns.storage.e)localObject).field_snsId, (com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.e locale = ah.dXH().Ax(paramdj.FOb.HMY.Id);
      if (locale != null)
      {
        locale.field_atAdinfo = z.a(paramdj.FOc);
        ca localca = locale.ebQ();
        localObject = localca;
        if (localca == null) {
          localObject = new ca();
        }
        ((ca)localObject).FMZ = paramdj.FOe;
        if (((ca)localObject).FMZ != null) {
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "update atFriend remindInfo, aid64 %d, aid %d", new Object[] { Long.valueOf(((ca)localObject).FMZ.HEZ), Integer.valueOf(((ca)localObject).FMZ.HEU) });
        }
        locale.a((ca)localObject);
        ah.dXH().a(locale.field_snsId, locale);
      }
      AppMethodBeat.o(95383);
      return;
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "just update at SnsAdObject");
      a(paramdj.FOb);
    }
  }
  
  private static boolean b(dgh paramdgh, List<dgh> paramList)
  {
    AppMethodBeat.i(95387);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dgh localdgh = (dgh)paramList.next();
      if ((paramdgh.HNm == localdgh.HNm) && (localdgh.HNm != 0L))
      {
        AppMethodBeat.o(95387);
        return true;
      }
    }
    AppMethodBeat.o(95387);
    return false;
  }
  
  private static void c(dj paramdj)
  {
    AppMethodBeat.i(95399);
    paramdj = z.a(paramdj.FOb.HMZ);
    if ((!bu.isNullOrNil(paramdj)) && (new com.tencent.mm.plugin.sns.storage.b(paramdj).dZv())) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95376);
          j.ebI().f("adId", this.zwp, "adxml", 0);
          AppMethodBeat.o(95376);
        }
      }, "predownloadAdLandingPages");
    }
    AppMethodBeat.o(95399);
  }
  
  /* Error */
  private static void dWN()
  {
    // Byte code:
    //   0: ldc_w 1080
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 1082	com/tencent/mm/plugin/sns/model/a:zwn	Ljava/util/LinkedHashMap;
    //   9: ifnonnull +61 -> 70
    //   12: getstatic 61	com/tencent/mm/plugin/sns/model/a:zwm	Ljava/lang/String;
    //   15: invokestatic 1088	com/tencent/mm/pluginsdk/j/a/d/a:aNG	(Ljava/lang/String;)[B
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +41 -> 61
    //   23: new 1090	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 1092	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: astore_0
    //   32: new 1094	java/io/ObjectInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 1097	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: invokeinterface 1102 1 0
    //   49: checkcast 1104	java/util/LinkedHashMap
    //   52: putstatic 1082	com/tencent/mm/plugin/sns/model/a:zwn	Ljava/util/LinkedHashMap;
    //   55: aload_1
    //   56: invokeinterface 1105 1 0
    //   61: getstatic 1082	com/tencent/mm/plugin/sns/model/a:zwn	Ljava/util/LinkedHashMap;
    //   64: ifnonnull +6 -> 70
    //   67: invokestatic 1108	com/tencent/mm/plugin/sns/model/a:dWO	()V
    //   70: ldc_w 1080
    //   73: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: ldc 95
    //   84: aload_2
    //   85: invokestatic 1111	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: ifnull -31 -> 61
    //   95: aload_1
    //   96: invokeinterface 1105 1 0
    //   101: goto -40 -> 61
    //   104: astore_0
    //   105: goto -44 -> 61
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: astore_0
    //   113: ldc 95
    //   115: aload_2
    //   116: invokestatic 1111	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   119: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_1
    //   123: ifnull -62 -> 61
    //   126: aload_1
    //   127: invokeinterface 1105 1 0
    //   132: goto -71 -> 61
    //   135: astore_0
    //   136: goto -75 -> 61
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: astore_0
    //   144: ldc 95
    //   146: aload_2
    //   147: invokestatic 1111	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   150: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: ifnull -93 -> 61
    //   157: aload_1
    //   158: invokeinterface 1105 1 0
    //   163: goto -102 -> 61
    //   166: astore_0
    //   167: goto -106 -> 61
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_0
    //   173: aload_0
    //   174: ifnull +9 -> 183
    //   177: aload_0
    //   178: invokeinterface 1105 1 0
    //   183: ldc_w 1080
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
  
  private static void dWO()
  {
    AppMethodBeat.i(95407);
    zwn = new a.5((int)Math.ceil(666.66668701171875D) + 1);
    AppMethodBeat.o(95407);
  }
  
  public static void e(LinkedList<cse> paramLinkedList, LinkedList<SnsObject> paramLinkedList1)
  {
    AppMethodBeat.i(95392);
    if (paramLinkedList != null)
    {
      paramLinkedList = aQ(paramLinkedList);
      ae.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dj localdj = (dj)localIterator.next();
        if (zX(localdj.FOb.HMY.Id))
        {
          ae.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + localdj.FOb.HMY.Id);
          localIterator.remove();
        }
      }
      x(paramLinkedList, paramLinkedList1);
    }
    AppMethodBeat.o(95392);
  }
  
  private static void x(List<dj> paramList, List<SnsObject> paramList1)
  {
    AppMethodBeat.i(95394);
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      AppMethodBeat.o(95394);
      return;
    }
    int k = b((SnsObject)paramList1.get(paramList1.size() - 1));
    int i = 0;
    if (i < paramList.size())
    {
      dj localdj = (dj)paramList.get(i);
      if (localdj == null) {
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
      }
      Object localObject;
      com.tencent.mm.plugin.sns.storage.a locala;
      for (;;)
      {
        i += 1;
        break;
        if (localdj.FOb == null)
        {
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
        }
        else if (localdj.FOb.HMY == null)
        {
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
        }
        else
        {
          localObject = z.a(localdj.FOc);
          String str1 = z.a(localdj.FOb.HMZ);
          String str2 = z.b(localdj.FOb.HMY.ObjectDesc);
          locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject);
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "skXml ".concat(String.valueOf(localObject)));
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "adXml ".concat(String.valueOf(str1)));
          ae.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + str2 + "\r\n");
          localObject = new com.tencent.mm.plugin.sns.storage.b(str1);
          if ((((com.tencent.mm.plugin.sns.storage.b)localObject).zNo == 0L) || (!zX(((com.tencent.mm.plugin.sns.storage.b)localObject).zNo))) {
            break label309;
          }
          ae.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + ((com.tencent.mm.plugin.sns.storage.b)localObject).zNo);
        }
      }
      label309:
      int j = k + 1;
      if ((locala.zLO < paramList1.size()) && (locala.zLO >= 0))
      {
        j = b((SnsObject)paramList1.get(locala.zLO)) + 1;
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.zLO);
      }
      for (;;)
      {
        int m = (int)(System.currentTimeMillis() / 1000L);
        ae.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(m)));
        a(localdj, j, m);
        zY(localdj.FOb.HMY.Id);
        zY(((com.tencent.mm.plugin.sns.storage.b)localObject).zNo);
        a(localdj.FOb.HMY.Id, locala);
        break;
        ae.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.zLO);
      }
    }
    AppMethodBeat.o(95394);
  }
  
  private static boolean zX(long paramLong)
  {
    AppMethodBeat.i(95405);
    dWN();
    if (zwn.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(95405);
      return true;
    }
    AppMethodBeat.o(95405);
    return false;
  }
  
  private static void zY(long paramLong)
  {
    AppMethodBeat.i(95408);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(95408);
      return;
    }
    if (zwn == null) {
      dWN();
    }
    zwn.put(Long.valueOf(paramLong), Integer.valueOf(0));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      Object localObject1 = new ObjectOutputStream(localByteArrayOutputStream);
      ((ObjectOutput)localObject1).writeObject(zwn);
      ((ObjectOutput)localObject1).flush();
      localObject1 = localByteArrayOutputStream.toByteArray();
      com.tencent.mm.pluginsdk.j.a.d.a.y(zwm, (byte[])localObject1);
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
      ae.e("MicroMsg.AdSnsInfoStorageLogic", bu.o(localIOException4));
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