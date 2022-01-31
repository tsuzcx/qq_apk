package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
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
  private static final String rcP;
  private static LinkedHashMap<Long, Integer> rcQ;
  private static Comparator<cds> rcR;
  
  static
  {
    AppMethodBeat.i(36096);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RM();
    rcP = g.RL().cachePath + "sns_recvd_ad";
    rcR = new a.1();
    AppMethodBeat.o(36096);
  }
  
  public static void ZZ(String paramString)
  {
    AppMethodBeat.i(36087);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36087);
      return;
    }
    d.post(new a.4(paramString), "preDownloadAdLandingPagesForMsg");
    AppMethodBeat.o(36087);
  }
  
  private static int a(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(36088);
    n localn = ag.cpf().lZ(paramSnsObject.Id);
    if (localn == null)
    {
      i = paramSnsObject.CreateTime;
      AppMethodBeat.o(36088);
      return i;
    }
    int i = localn.field_createTime;
    AppMethodBeat.o(36088);
    return i;
  }
  
  private static cy a(bsc parambsc)
  {
    AppMethodBeat.i(36076);
    if (parambsc != null)
    {
      cy localcy = new cy();
      localcy.wpm = parambsc.xFB;
      if (localcy.wpm == null)
      {
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
        AppMethodBeat.o(36076);
        return null;
      }
      localcy.wpl = b(parambsc.xFA);
      AppMethodBeat.o(36076);
      return localcy;
    }
    AppMethodBeat.o(36076);
    return null;
  }
  
  private static String a(String paramString, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(36095);
    if ((paramSKBuiltinBuffer_t == null) || (paramString == null))
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
      AppMethodBeat.o(36095);
      return paramString;
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new z();
        ((z)localObject1).parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        Iterator localIterator;
        if (((z)localObject1).wkS != null)
        {
          localObject2 = "";
          localIterator = ((z)localObject1).wkS.iterator();
          paramSKBuiltinBuffer_t = paramString;
          localObject1 = paramSKBuiltinBuffer_t;
        }
        cdk localcdk;
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
            localcdk = (cdk)localIterator.next();
            localObject1 = paramSKBuiltinBuffer_t;
            if (localcdk.key == null) {
              break label357;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            str = String.format("<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))", new Object[] { localcdk.key });
            localObject1 = paramSKBuiltinBuffer_t;
            localObject3 = Pattern.compile(str).matcher(paramSKBuiltinBuffer_t);
            localObject1 = paramSKBuiltinBuffer_t;
            if (!((Matcher)localObject3).find()) {
              break label357;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            localObject3 = ((Matcher)localObject3).group(2);
            if (localObject3 == null) {
              break label357;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            if (((String)localObject3).length() <= 0) {
              break label357;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.replaceAll(str + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[] { localObject3 }), String.format("<$1>%s</%s>", new Object[] { localcdk.value, localObject3 }));
            localObject1 = paramSKBuiltinBuffer_t;
            localObject2 = (String)localObject2 + localcdk.key + ":" + localcdk.value + ";";
            localObject1 = localObject2;
            break label367;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", new Object[] { localObject2 });
          localObject2 = paramSKBuiltinBuffer_t;
          localObject1 = paramSKBuiltinBuffer_t;
          if (br.F(paramString, "ADInfo") != null) {
            continue;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          ab.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
          AppMethodBeat.o(36095);
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
        ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramString, "replace error occurs!", new Object[0]);
        localObject2 = localObject1;
        AppMethodBeat.o(36095);
        return localObject2;
      }
      label357:
      continue;
      label367:
      Object localObject2 = localObject1;
    }
  }
  
  private static void a(long paramLong, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(36082);
    if ((!parama.rpF) || (bo.isNullOrNil(parama.rpE)))
    {
      AppMethodBeat.o(36082);
      return;
    }
    parama = new m(paramLong, 1, parama.rpE);
    g.RM();
    g.RK().eHt.a(parama, 0);
    AppMethodBeat.o(36082);
  }
  
  public static void a(cdh paramcdh)
  {
    AppMethodBeat.i(36068);
    if (paramcdh == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(36068);
      return;
    }
    if (paramcdh.xNM == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(36068);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramcdh);
    ag.cpi().a(paramcdh.xNM.Id, locale);
    AppMethodBeat.o(36068);
  }
  
  public static void a(cdh paramcdh, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(36066);
    if (paramcdh == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(36066);
      return;
    }
    if (paramcdh.xNM == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(36066);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramcdh);
    if (locale == null)
    {
      AppMethodBeat.o(36066);
      return;
    }
    locale.field_adinfo = a(locale.field_adinfo, paramSKBuiltinBuffer_t);
    if (ag.cpi().lR(paramcdh.xNM.Id))
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + paramcdh.xNM.Id);
      ag.cpi().b(paramcdh.xNM.Id, locale);
      AppMethodBeat.o(36066);
      return;
    }
    ab.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + paramcdh.xNM.Id);
    AppMethodBeat.o(36066);
  }
  
  public static void a(cer paramcer)
  {
    AppMethodBeat.i(36067);
    a(b(paramcer));
    AppMethodBeat.o(36067);
  }
  
  public static void a(cy paramcy)
  {
    AppMethodBeat.i(36069);
    if (paramcy == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
      AppMethodBeat.o(36069);
      return;
    }
    if (paramcy.wpl == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
      AppMethodBeat.o(36069);
      return;
    }
    if (paramcy.wpl.xNM == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject;
    if (!ag.cpi().lR(paramcy.wpl.xNM.Id))
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "insert at adObject");
      int i = (int)(System.currentTimeMillis() / 1000L);
      if (paramcy.wpl.xNM.CommentUserListCount > 0) {
        i = ((cds)paramcy.wpl.xNM.CommentUserList.get(0)).CreateTime;
      }
      a(paramcy, i, i);
      localObject = ag.cpi().lQ(paramcy.wpl.xNM.Id);
      if (localObject != null)
      {
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
        ((com.tencent.mm.plugin.sns.storage.e)localObject).field_localFlag |= 0x100;
        ag.cpi().a(((com.tencent.mm.plugin.sns.storage.e)localObject).field_snsId, (com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.e locale = ag.cpi().lQ(paramcy.wpl.xNM.Id);
      if (locale != null)
      {
        locale.field_atAdinfo = aa.a(paramcy.wpm);
        bs localbs = locale.csi();
        localObject = localbs;
        if (localbs == null) {
          localObject = new bs();
        }
        ((bs)localObject).won = paramcy.wpo;
        if (((bs)localObject).won != null) {
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "update atFriend remindInfo, aid %d", new Object[] { Integer.valueOf(((bs)localObject).won.xGU) });
        }
        locale.a((bs)localObject);
        ag.cpi().a(locale.field_snsId, locale);
      }
      AppMethodBeat.o(36069);
      return;
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "just update at SnsAdObject");
      a(paramcy.wpl);
    }
  }
  
  private static void a(cy paramcy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36074);
    if (paramcy == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(36074);
      return;
    }
    if ((paramcy.wpl == null) || (paramcy.wpl.xNM == null))
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(36074);
      return;
    }
    SnsObject localSnsObject = paramcy.wpl.xNM;
    com.tencent.mm.plugin.sns.storage.e locale = b(paramcy.wpl);
    if (locale == null)
    {
      ab.w("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
      AppMethodBeat.o(36074);
      return;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.a(aa.a(paramcy.wpm));
    TimeLineObject localTimeLineObject = locale.csh();
    cgh localcgh = new cgh();
    localcgh.xQY = new cgi();
    localcgh.xQY.xRc = ((com.tencent.mm.plugin.sns.storage.a)localObject).cFe;
    localcgh.xQY.xRb = localTimeLineObject.Id;
    localcgh.xQY.cpt = locale.getSource();
    localcgh.xQY.rCH = com.tencent.mm.modelstat.p.a(localcgh.xQY);
    if (localTimeLineObject.xTS.wNZ == 1) {
      localcgh.xQY.rpO = 1;
    }
    for (;;)
    {
      localcgh.xQY.xRd = locale.csg();
      try
      {
        localObject = Base64.encodeToString(localcgh.toByteArray(), 0).replace("\n", "");
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[] { localTimeLineObject.Id, localObject, localcgh.xQY.xRb, localcgh.xQY.xRc });
        localTimeLineObject.rHA = ((String)localObject);
        locale.c(localTimeLineObject);
        if (locale == null)
        {
          AppMethodBeat.o(36074);
          return;
          if (localTimeLineObject.xTS.wNZ == 15)
          {
            localcgh.xQY.rpO = 2;
            continue;
          }
          localcgh.xQY.rpO = 0;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", localIOException, "", new Object[0]);
        }
        locale.field_createTime = paramInt1;
        locale.field_createAdTime = paramInt2;
        String str = aa.a(paramcy.wpl.xNN);
        if (!bo.isNullOrNil(str)) {
          locale.field_recxml = str;
        }
        locale.field_adinfo = aa.a(paramcy.wpm);
        locale.field_adxml = locale.field_recxml;
        ag.cpi().a(localSnsObject.Id, locale);
        AppMethodBeat.o(36074);
      }
    }
  }
  
  public static boolean a(long paramLong, cdn paramcdn)
  {
    AppMethodBeat.i(36090);
    cdm localcdm = paramcdn.xOe;
    if ((localcdm.jKs != 7) && (localcdm.jKs != 8) && (localcdm.jKs != 16))
    {
      AppMethodBeat.o(36090);
      return false;
    }
    com.tencent.mm.plugin.sns.storage.e locale = ag.cpi().lQ(paramLong);
    if (locale == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(36090);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localcdm.jKs != 7) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localcds = (cds)localIterator.next();
          if ((localcds.CreateTime != localcdm.CreateTime) || (!localcds.Username.equals(localcdm.xCG))) {
            continue;
          }
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localcds.CreateTime + " ");
          AppMethodBeat.o(36090);
          return false;
        }
        localSnsObject.LikeUserList.add(ae.b(paramcdn));
        locale.bj(localSnsObject.toByteArray());
        ag.cpi().a(localSnsObject.Id, locale);
      }
      catch (Exception paramcdn)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        cds localcds;
        ab.e("MicroMsg.AdSnsInfoStorageLogic", "e " + paramcdn.getMessage());
        ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcdn, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(36090);
      return true;
      if ((localcdm.jKs == 8) || (localcdm.jKs == 16))
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localcds = (cds)localIterator.next();
          if ((localcds.CreateTime == localcdm.CreateTime) && (localcds.Username.equals(localcdm.xCG)))
          {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localcds.CreateTime + " ");
            AppMethodBeat.o(36090);
            return false;
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ae.b(paramcdn));
        }
      }
    }
  }
  
  public static boolean a(long paramLong, cdn paramcdn, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(36089);
    Object localObject1;
    if (paramcdn != null)
    {
      localObject1 = paramcdn.xOe;
      if ((((cdm)localObject1).jKs != 7) && (((cdm)localObject1).jKs != 8) && (((cdm)localObject1).jKs != 16))
      {
        AppMethodBeat.o(36089);
        return false;
      }
    }
    Object localObject3 = r.Zn();
    if ((paramcdn != null) && (paramcdn.xOf != null) && (paramcdn.xOf.xCG != null) && (paramcdn.xOf.xCG.equals(localObject3)))
    {
      AppMethodBeat.o(36089);
      return true;
    }
    Object localObject2 = ag.cpi().lQ(paramLong);
    if (localObject2 == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(36089);
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
        paramcdn = paramcdn.xOe;
        if (paramcdn.jKs != 7) {
          break;
        }
        if ((paramInt2 <= 0) || (k + paramInt2 >= paramcdn.CreateTime)) {
          break label822;
        }
        if (paramBoolean)
        {
          if (ag.cpf().abu(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
            break label497;
          }
          localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).csd();
          if (localObject4 == null) {
            continue;
          }
          localObject3 = (com.tencent.mm.plugin.sns.b.c)g.E(com.tencent.mm.plugin.sns.b.c.class);
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          l = v.abO(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).hpq;
          if (((SnsObject)localObject1).LikeUserList != null)
          {
            paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
            if (((SnsObject)localObject1).CommentUserList == null) {
              continue;
            }
            paramInt3 = ((SnsObject)localObject1).CommentUserList.size();
            ((com.tencent.mm.plugin.sns.b.c)localObject3).a(13182, i, new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
          }
        }
        else
        {
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionLikeTimeLimit: " + paramInt2 + " curAction.createTime: " + paramcdn.CreateTime + "is over the time limit!");
          AppMethodBeat.o(36089);
          return false;
        }
        paramInt1 = 0;
        continue;
        paramInt3 = 0;
        continue;
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        AppMethodBeat.o(36089);
      }
      catch (Exception paramcdn)
      {
        ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcdn, "", new Object[0]);
      }
      return true;
      label497:
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
    }
    if (((paramcdn.jKs == 8) || (paramcdn.jKs == 16)) && (paramInt3 > 0) && (k + paramInt3 < paramcdn.CreateTime))
    {
      if (paramBoolean)
      {
        if (ag.cpf().abu(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
          break label811;
        }
        localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).csd();
        if (localObject4 == null) {
          break label800;
        }
        localObject3 = (com.tencent.mm.plugin.sns.b.c)g.E(com.tencent.mm.plugin.sns.b.c.class);
        i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
        l = v.abO(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
        localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).hpq;
        if (((SnsObject)localObject1).LikeUserList == null) {
          break label789;
        }
        paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
        if (((SnsObject)localObject1).CommentUserList == null) {
          break label794;
        }
        paramInt2 = ((SnsObject)localObject1).CommentUserList.size();
        label644:
        ((com.tencent.mm.plugin.sns.b.c)localObject3).a(13182, i, new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
      }
      for (;;)
      {
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionCommentTimeLimit: " + paramInt3 + " curAction.createTime: " + paramcdn.CreateTime + "is over the time limit!");
        AppMethodBeat.o(36089);
        return false;
        label789:
        paramInt1 = 0;
        break;
        label794:
        paramInt2 = 0;
        break label644;
        label800:
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        label811:
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
      }
    }
    label822:
    int i = 0;
    paramcdn = ((SnsObject)localObject1).LikeUserList.iterator();
    label834:
    int j;
    if (paramcdn.hasNext())
    {
      localObject4 = (cds)paramcdn.next();
      if (((cds)localObject4).CreateTime > k)
      {
        if ((localObject4 == null) || (((cds)localObject4).Username == null)) {
          break label1264;
        }
        if (!((cds)localObject4).Username.equals(localObject3)) {
          break label1264;
        }
      }
    }
    else
    {
      j = 0;
      paramcdn = ((SnsObject)localObject1).CommentUserList.iterator();
    }
    label1145:
    label1279:
    for (;;)
    {
      if (paramcdn.hasNext())
      {
        localObject4 = (cds)paramcdn.next();
        if (((cds)localObject4).CreateTime > k)
        {
          if ((localObject4 == null) || (((cds)localObject4).Username == null)) {
            break label1273;
          }
          if (!((cds)localObject4).Username.equals(localObject3)) {
            break label1273;
          }
        }
      }
      else
      {
        i = i + 0 + j;
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i + " firstCreateTime " + k + " actionLimit: " + paramInt1 + " actionLikeTimeLimit: " + paramInt2 + " actionCommentTimeLimit: " + paramInt3);
        if (i < paramInt1) {
          break;
        }
        if (paramBoolean)
        {
          paramcdn = ag.cpf().abu(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          if (paramcdn == null) {
            break label1247;
          }
          localObject3 = paramcdn.csd();
          if (localObject3 == null) {
            break label1236;
          }
          paramcdn = (com.tencent.mm.plugin.sns.b.c)g.E(com.tencent.mm.plugin.sns.b.c.class);
          paramInt3 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          paramLong = v.abO(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).hpq;
          if (((SnsObject)localObject1).LikeUserList == null) {
            break label1225;
          }
          paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
          if (((SnsObject)localObject1).CommentUserList == null) {
            break label1230;
          }
          paramInt2 = ((SnsObject)localObject1).CommentUserList.size();
          paramcdn.a(13182, paramInt3, new Object[] { Long.valueOf(paramLong), localObject2, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        }
        for (;;)
        {
          AppMethodBeat.o(36089);
          return false;
          paramInt1 = 0;
          break;
          paramInt2 = 0;
          break label1145;
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
          continue;
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
        }
      }
      break label1279;
      break label1270;
      i += 1;
      break label834;
      j += 1;
    }
  }
  
  private static boolean a(cds paramcds, List<cds> paramList)
  {
    AppMethodBeat.i(36072);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cds localcds = (cds)paramList.next();
      if ((!bo.isNullOrNil(paramcds.Username)) && (paramcds.Username.equals(localcds.Username)))
      {
        AppMethodBeat.o(36072);
        return true;
      }
    }
    AppMethodBeat.o(36072);
    return false;
  }
  
  private static LinkedList<cy> aq(LinkedList<bsc> paramLinkedList)
  {
    AppMethodBeat.i(36079);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cy localcy = a((bsc)paramLinkedList.next());
      if (localcy != null) {
        localLinkedList.add(localcy);
      }
    }
    AppMethodBeat.o(36079);
    return localLinkedList;
  }
  
  public static void ar(LinkedList<bsc> paramLinkedList)
  {
    AppMethodBeat.i(36083);
    if ((paramLinkedList != null) && (!paramLinkedList.isEmpty()))
    {
      paramLinkedList = aq(paramLinkedList);
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      as(paramLinkedList);
    }
    AppMethodBeat.o(36083);
  }
  
  public static void as(LinkedList<cy> paramLinkedList)
  {
    AppMethodBeat.i(36084);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(36084);
      return;
    }
    int i = 0;
    while (i < paramLinkedList.size())
    {
      b((cy)paramLinkedList.get(i));
      i += 1;
    }
    AppMethodBeat.o(36084);
  }
  
  public static void at(LinkedList<SnsObject> paramLinkedList)
  {
    AppMethodBeat.i(36086);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(36086);
      return;
    }
    o localo = ag.cpf();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      Object localObject = (SnsObject)paramLinkedList.get(i);
      if (localObject != null)
      {
        localObject = localo.lZ(((SnsObject)localObject).Id);
        if (localObject != null)
        {
          localObject = ((n)localObject).csh();
          if ((localObject != null) && (!bo.isNullOrNil(((TimeLineObject)localObject).sbN))) {
            d.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36063);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.crY().f("adId", this.rcT.sbN, "adxml", 0);
                AppMethodBeat.o(36063);
              }
            }, "preDownloadAdLandingPagesForSnsObject");
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(36086);
  }
  
  private static com.tencent.mm.plugin.sns.storage.e b(cdh paramcdh)
  {
    AppMethodBeat.i(36071);
    com.tencent.mm.plugin.sns.storage.e locale = ag.cpi().lQ(paramcdh.xNM.Id);
    SnsObject localSnsObject = paramcdh.xNM;
    Object localObject1 = null;
    if (locale == null) {
      locale = new com.tencent.mm.plugin.sns.storage.e();
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = aa.b(localSnsObject.ObjectDesc);
      if (!bo.isNullOrNil((String)localObject2)) {
        break;
      }
      AppMethodBeat.o(36071);
      return null;
      localObject1 = locale.csh().rHA;
    }
    if (!locale.abt((String)localObject2))
    {
      AppMethodBeat.o(36071);
      return null;
    }
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject2 = locale.csh();
      ((TimeLineObject)localObject2).rHA = ((String)localObject1);
      locale.c((TimeLineObject)localObject2);
    }
    localSnsObject.ObjectOperations = ak.b(localSnsObject.ObjectOperations, locale.field_attrBuf);
    ab.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(localSnsObject.Id) });
    localSnsObject.ObjectDesc.setBuffer(new byte[0]);
    locale.field_userName = localSnsObject.Username;
    if (paramcdh.xNN != null)
    {
      paramcdh = aa.a(paramcdh.xNN);
      if (!bo.isNullOrNil(paramcdh)) {
        locale.field_recxml = paramcdh;
      }
      paramcdh = locale.field_recxml;
      if ((!bo.isNullOrNil(paramcdh)) && (!paramcdh.equals(locale.field_adxml)))
      {
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml ".concat(String.valueOf(paramcdh)));
        locale.field_adxml = paramcdh;
      }
    }
    locale.field_likeFlag = localSnsObject.LikeFlag;
    long l = localSnsObject.Id;
    locale.field_snsId = l;
    if (l != 0L)
    {
      locale.field_stringSeq = com.tencent.mm.plugin.sns.data.i.lq(l);
      locale.field_stringSeq = com.tencent.mm.plugin.sns.data.i.ZI(locale.field_stringSeq);
      ab.d("MicroMsg.AdSnsInfo", l + " stringSeq " + locale.field_stringSeq);
    }
    locale.Eu(2);
    locale.Eu(32);
    try
    {
      if (locale.field_attrBuf == null)
      {
        paramcdh = new SnsObject();
        if ((paramcdh == null) || (paramcdh.CommentUserList == null)) {
          break label891;
        }
        localObject1 = new LinkedList();
        localObject2 = localSnsObject.CommentUserList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label675;
          }
          localObject3 = (cds)((Iterator)localObject2).next();
          if (((cds)localObject3).DeleteFlag > 0)
          {
            ((List)localObject1).add(localObject3);
            localIterator = paramcdh.CommentUserList.iterator();
            if (localIterator.hasNext())
            {
              localcds = (cds)localIterator.next();
              if (localcds.xOa != ((cds)localObject3).xOa) {
                break;
              }
              paramcdh.CommentUserList.remove(localcds);
            }
          }
        }
      }
    }
    catch (Exception paramcdh)
    {
      for (;;)
      {
        Object localObject3;
        Iterator localIterator;
        cds localcds;
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "error " + paramcdh.getMessage());
        ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcdh, "", new Object[0]);
        try
        {
          for (;;)
          {
            locale.bj(localSnsObject.toByteArray());
            paramcdh = locale.csh();
            paramcdh.jJA = localSnsObject.Username;
            locale.field_pravited = paramcdh.xrU;
            ab.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + localSnsObject.ExtFlag + " " + localSnsObject.CommentUserList.size() + " " + localSnsObject.LikeUserList.size());
            localObject1 = paramcdh.xTS.wOa.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((bcs)((Iterator)localObject1).next()).raZ = true;
            }
            paramcdh = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
            break;
            label675:
            localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (cds)((Iterator)localObject2).next();
              localSnsObject.CommentUserList.remove(localObject3);
            }
            ((List)localObject1).clear();
            localObject1 = paramcdh.CommentUserList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (cds)((Iterator)localObject1).next();
              if ((!b((cds)localObject2, localSnsObject.CommentUserList)) && (((cds)localObject2).xOa != 0L))
              {
                g.RM();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(((cds)localObject2).Username);
                if ((localObject3 != null) && (com.tencent.mm.n.a.je(((aq)localObject3).field_type)) && (!((ad)localObject3).NW()))
                {
                  localSnsObject.CommentUserList.add(localObject2);
                  localSnsObject.CommentUserListCount = localSnsObject.CommentUserList.size();
                }
                else
                {
                  ab.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + ((cds)localObject2).Username);
                }
              }
            }
            label891:
            Collections.sort(localSnsObject.CommentUserList, rcR);
            if (localSnsObject.LikeUserList != null)
            {
              localObject1 = new LinkedList();
              localObject2 = localSnsObject.LikeUserList.iterator();
              for (;;)
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break label1040;
                }
                localObject3 = (cds)((Iterator)localObject2).next();
                if (((cds)localObject3).DeleteFlag > 0)
                {
                  ((List)localObject1).add(localObject3);
                  localIterator = paramcdh.LikeUserList.iterator();
                  if (localIterator.hasNext())
                  {
                    localcds = (cds)localIterator.next();
                    if ((!bo.isNullOrNil(localcds.Username)) && (!localcds.Username.equals(((cds)localObject3).Username))) {
                      break;
                    }
                    paramcdh.LikeUserList.remove(localcds);
                  }
                }
              }
              label1040:
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (cds)((Iterator)localObject2).next();
                localSnsObject.LikeUserList.remove(localObject3);
              }
              ((List)localObject1).clear();
              if ((paramcdh != null) && (paramcdh.LikeUserList != null))
              {
                paramcdh = paramcdh.LikeUserList.iterator();
                while (paramcdh.hasNext())
                {
                  localObject1 = (cds)paramcdh.next();
                  if (!a((cds)localObject1, localSnsObject.LikeUserList))
                  {
                    g.RM();
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(((cds)localObject1).Username);
                    if ((localObject2 != null) && (com.tencent.mm.n.a.je(((aq)localObject2).field_type)) && (!((ad)localObject2).NW()))
                    {
                      localSnsObject.LikeUserList.add(localObject1);
                      localSnsObject.LikeUserListCount = localSnsObject.LikeUserList.size();
                    }
                    else
                    {
                      ab.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + ((cds)localObject1).Username);
                    }
                  }
                }
              }
              Collections.sort(localSnsObject.LikeUserList, rcR);
            }
          }
        }
        catch (Exception paramcdh)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcdh, "", new Object[0]);
          }
          locale.c(paramcdh);
          locale.field_type = paramcdh.xTS.wNZ;
          locale.field_subType = paramcdh.xTS.wOb;
          AppMethodBeat.o(36071);
        }
      }
    }
    return locale;
  }
  
  private static cdh b(cer paramcer)
  {
    AppMethodBeat.i(36075);
    if (paramcer != null)
    {
      cdh localcdh = new cdh();
      localcdh.xNN = paramcer.xPc;
      if (localcdh.xNN == null) {
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
      }
      localcdh.xNM = paramcer.xNM;
      AppMethodBeat.o(36075);
      return localcdh;
    }
    AppMethodBeat.o(36075);
    return null;
  }
  
  public static void b(bsc parambsc)
  {
    AppMethodBeat.i(36077);
    parambsc = a(parambsc);
    if (parambsc == null)
    {
      AppMethodBeat.o(36077);
      return;
    }
    com.tencent.mm.plugin.sns.storage.a locala = new com.tencent.mm.plugin.sns.storage.a(aa.a(parambsc.wpm));
    int j = locala.rpd;
    Cursor localCursor;
    n localn;
    if (j <= 0)
    {
      i = 1;
      int k = ag.cpf().abI("");
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      localCursor = ag.cpf().at("", k, i);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label298;
      }
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[] { Integer.valueOf(localCursor.getCount()) });
      localn = new n();
      if (j >= 0) {
        break label275;
      }
      i = 0;
      label159:
      if (!localCursor.moveToPosition(i)) {
        break label280;
      }
      localn.convertFrom(localCursor);
    }
    label177:
    for (int i = localn.field_createTime + 1;; i = (int)bo.aox())
    {
      localCursor.close();
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + parambsc.wpl.xNM.Id + " ,createTime " + i);
      a(parambsc, i, (int)bo.aox());
      b(parambsc);
      a(parambsc.wpl.xNM.Id, locala);
      AppMethodBeat.o(36077);
      return;
      i = j + 1;
      break;
      i = j;
      break label159;
      localCursor.moveToLast();
      localn.convertFrom(localCursor);
      break label177;
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
    }
  }
  
  private static void b(cy paramcy)
  {
    AppMethodBeat.i(36085);
    paramcy = aa.a(paramcy.wpl.xNN);
    if ((!bo.isNullOrNil(paramcy)) && (new com.tencent.mm.plugin.sns.storage.b(paramcy).cqk())) {
      d.post(new a.2(paramcy), "predownloadAdLandingPages");
    }
    AppMethodBeat.o(36085);
  }
  
  private static boolean b(cds paramcds, List<cds> paramList)
  {
    AppMethodBeat.i(36073);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cds localcds = (cds)paramList.next();
      if ((paramcds.xOa == localcds.xOa) && (localcds.xOa != 0L))
      {
        AppMethodBeat.o(36073);
        return true;
      }
    }
    AppMethodBeat.o(36073);
    return false;
  }
  
  /* Error */
  private static void cog()
  {
    // Byte code:
    //   0: ldc_w 950
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 952	com/tencent/mm/plugin/sns/model/a:rcQ	Ljava/util/LinkedHashMap;
    //   9: ifnonnull +61 -> 70
    //   12: getstatic 55	com/tencent/mm/plugin/sns/model/a:rcP	Ljava/lang/String;
    //   15: invokestatic 958	com/tencent/mm/pluginsdk/g/a/d/a:alS	(Ljava/lang/String;)[B
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +41 -> 61
    //   23: new 960	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 962	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: astore_0
    //   32: new 964	java/io/ObjectInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 967	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: invokeinterface 972 1 0
    //   49: checkcast 974	java/util/LinkedHashMap
    //   52: putstatic 952	com/tencent/mm/plugin/sns/model/a:rcQ	Ljava/util/LinkedHashMap;
    //   55: aload_1
    //   56: invokeinterface 975 1 0
    //   61: getstatic 952	com/tencent/mm/plugin/sns/model/a:rcQ	Ljava/util/LinkedHashMap;
    //   64: ifnonnull +6 -> 70
    //   67: invokestatic 978	com/tencent/mm/plugin/sns/model/a:coh	()V
    //   70: ldc_w 950
    //   73: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: ldc 131
    //   84: aload_2
    //   85: invokestatic 982	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: invokestatic 604	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: ifnull -31 -> 61
    //   95: aload_1
    //   96: invokeinterface 975 1 0
    //   101: goto -40 -> 61
    //   104: astore_0
    //   105: goto -44 -> 61
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: astore_0
    //   113: ldc 131
    //   115: aload_2
    //   116: invokestatic 982	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   119: invokestatic 604	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_1
    //   123: ifnull -62 -> 61
    //   126: aload_1
    //   127: invokeinterface 975 1 0
    //   132: goto -71 -> 61
    //   135: astore_0
    //   136: goto -75 -> 61
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: astore_0
    //   144: ldc 131
    //   146: aload_2
    //   147: invokestatic 982	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   150: invokestatic 604	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: ifnull -93 -> 61
    //   157: aload_1
    //   158: invokeinterface 975 1 0
    //   163: goto -102 -> 61
    //   166: astore_0
    //   167: goto -106 -> 61
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_0
    //   173: aload_0
    //   174: ifnull +9 -> 183
    //   177: aload_0
    //   178: invokeinterface 975 1 0
    //   183: ldc_w 950
    //   186: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static void coh()
  {
    AppMethodBeat.i(36093);
    rcQ = new a.5((int)Math.ceil(666.66668701171875D) + 1);
    AppMethodBeat.o(36093);
  }
  
  public static void e(LinkedList<bsc> paramLinkedList, LinkedList<SnsObject> paramLinkedList1)
  {
    AppMethodBeat.i(36078);
    if (paramLinkedList != null)
    {
      paramLinkedList = aq(paramLinkedList);
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cy localcy = (cy)localIterator.next();
        if (lu(localcy.wpl.xNM.Id))
        {
          ab.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + localcy.wpl.xNM.Id);
          localIterator.remove();
        }
      }
      k(paramLinkedList, paramLinkedList1);
    }
    AppMethodBeat.o(36078);
  }
  
  private static void k(List<cy> paramList, List<SnsObject> paramList1)
  {
    AppMethodBeat.i(36080);
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      AppMethodBeat.o(36080);
      return;
    }
    int k = a((SnsObject)paramList1.get(paramList1.size() - 1));
    int i = 0;
    if (i < paramList.size())
    {
      cy localcy = (cy)paramList.get(i);
      if (localcy == null) {
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
      }
      Object localObject;
      com.tencent.mm.plugin.sns.storage.a locala;
      for (;;)
      {
        i += 1;
        break;
        if (localcy.wpl == null)
        {
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
        }
        else if (localcy.wpl.xNM == null)
        {
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
        }
        else
        {
          localObject = aa.a(localcy.wpm);
          String str1 = aa.a(localcy.wpl.xNN);
          String str2 = aa.b(localcy.wpl.xNM.ObjectDesc);
          locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject);
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "skXml ".concat(String.valueOf(localObject)));
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "adXml ".concat(String.valueOf(str1)));
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + str2 + "\r\n");
          localObject = new com.tencent.mm.plugin.sns.storage.b(str1);
          if ((((com.tencent.mm.plugin.sns.storage.b)localObject).rqm == 0L) || (!lu(((com.tencent.mm.plugin.sns.storage.b)localObject).rqm))) {
            break label309;
          }
          ab.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + ((com.tencent.mm.plugin.sns.storage.b)localObject).rqm);
        }
      }
      label309:
      int j = k + 1;
      if ((locala.rpd < paramList1.size()) && (locala.rpd >= 0))
      {
        j = a((SnsObject)paramList1.get(locala.rpd)) + 1;
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.rpd);
      }
      for (;;)
      {
        int m = (int)(System.currentTimeMillis() / 1000L);
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(m)));
        a(localcy, j, m);
        lv(localcy.wpl.xNM.Id);
        lv(((com.tencent.mm.plugin.sns.storage.b)localObject).rqm);
        a(localcy.wpl.xNM.Id, locala);
        break;
        ab.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.rpd);
      }
    }
    AppMethodBeat.o(36080);
  }
  
  public static void l(List<cy> paramList, List<SnsObject> paramList1)
  {
    int k = 0;
    AppMethodBeat.i(36081);
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      AppMethodBeat.o(36081);
      return;
    }
    int m = a((SnsObject)paramList1.get(paramList1.size() - 1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adList[");
    int i = 0;
    if (i < paramList.size())
    {
      cy localcy = (cy)paramList.get(i);
      if (localcy == null) {
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
      }
      for (;;)
      {
        i += 1;
        break;
        if (localcy.wpl == null)
        {
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
        }
        else if (localcy.wpl.xNM == null)
        {
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
        }
        else
        {
          Object localObject1 = aa.a(localcy.wpm);
          Object localObject2 = aa.a(localcy.wpl.xNN);
          Object localObject3 = aa.b(localcy.wpl.xNM.ObjectDesc);
          com.tencent.mm.plugin.sns.storage.a locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject1);
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "skXml %s, adXml %s, snsXml %s", new Object[] { localObject1, localObject2, localObject3 });
          try
          {
            localStringBuilder.append(com.tencent.mm.plugin.sns.data.i.lq(localcy.wpl.xNM.Id)).append(",");
            localStringBuilder.append(locala.rpd).append("|");
            int j = m + 1;
            if ((locala.rpd < paramList1.size()) && (locala.rpd >= 0))
            {
              j = a((SnsObject)paramList1.get(locala.rpd)) + 1;
              ab.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.rpd);
              int n = (int)(System.currentTimeMillis() / 1000L);
              ab.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(n)));
              a(localcy, j, n);
              localObject3 = ag.cpi().lQ(localcy.wpl.xNM.Id);
              if (localObject3 != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.storage.e)localObject3).csi();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new bs();
                }
                ((bs)localObject1).wom = localcy.wpo;
                if (((bs)localObject1).wom != null) {
                  ab.i("MicroMsg.AdSnsInfoStorageLogic", "update timeline remind info , aid:%d", new Object[] { Integer.valueOf(((bs)localObject1).wom.xGU) });
                }
                ((com.tencent.mm.plugin.sns.storage.e)localObject3).a((bs)localObject1);
                ((com.tencent.mm.plugin.sns.storage.e)localObject3).field_localFlag &= 0xFFFFFEFF;
                ag.cpi().replace((com.tencent.mm.sdk.e.c)localObject3);
              }
              a(localcy.wpl.xNM.Id, locala);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.e("MicroMsg.AdSnsInfoStorageLogic", "log exp=" + localException.toString());
              continue;
              ab.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.rpd);
            }
          }
        }
      }
    }
    try
    {
      localStringBuilder.append("], objList[");
      i = k;
      while (i < paramList1.size())
      {
        localStringBuilder.append(com.tencent.mm.plugin.sns.data.i.lq(((SnsObject)paramList1.get(i)).Id)).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "insert ad, " + localStringBuilder.toString());
      AppMethodBeat.o(36081);
      return;
    }
    catch (Exception paramList)
    {
      ab.e("MicroMsg.AdSnsInfoStorageLogic", "log exp=" + paramList.toString());
      AppMethodBeat.o(36081);
    }
  }
  
  public static void lt(long paramLong)
  {
    AppMethodBeat.i(36070);
    Object localObject1 = ag.cpi().lQ(paramLong);
    if (localObject1 == null)
    {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
      AppMethodBeat.o(36070);
      return;
    }
    label232:
    for (;;)
    {
      try
      {
        localObject1 = (SnsObject)new SnsObject().parseFrom(((com.tencent.mm.plugin.sns.storage.e)localObject1).field_attrBuf);
        if (localObject1 == null)
        {
          ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsObject is null!");
          AppMethodBeat.o(36070);
          return;
        }
        if (((SnsObject)localObject1).LikeFlag == 0)
        {
          Object localObject2 = ((SnsObject)localObject1).CommentUserList;
          localObject1 = r.Zn();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              cds localcds = (cds)((Iterator)localObject2).next();
              if ((localcds == null) || (bo.isNullOrNil(localcds.Username)) || (!localcds.Username.equals(localObject1))) {
                continue;
              }
              break label232;
              ab.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAd, hasCommentLike %s , id %s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.plugin.sns.data.i.lq(paramLong) });
              if (!bool)
              {
                ag.cpi().delete(paramLong);
                ag.cpk().lU(paramLong);
                com.tencent.mm.plugin.sns.storage.i.lT(paramLong);
              }
              AppMethodBeat.o(36070);
              return;
            }
          }
          bool = false;
          continue;
        }
        boolean bool = true;
      }
      catch (IOException localIOException)
      {
        ab.e("MicroMsg.AdSnsInfoStorageLogic", "parse SnsObject error!");
        AppMethodBeat.o(36070);
        return;
      }
    }
  }
  
  private static boolean lu(long paramLong)
  {
    AppMethodBeat.i(36091);
    cog();
    if (rcQ.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(36091);
      return true;
    }
    AppMethodBeat.o(36091);
    return false;
  }
  
  private static void lv(long paramLong)
  {
    AppMethodBeat.i(36094);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(36094);
      return;
    }
    if (rcQ == null) {
      cog();
    }
    rcQ.put(Long.valueOf(paramLong), Integer.valueOf(0));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      Object localObject1 = new ObjectOutputStream(localByteArrayOutputStream);
      ((ObjectOutput)localObject1).writeObject(rcQ);
      ((ObjectOutput)localObject1).flush();
      localObject1 = localByteArrayOutputStream.toByteArray();
      com.tencent.mm.pluginsdk.g.a.d.a.D(rcP, (byte[])localObject1);
      try
      {
        localByteArrayOutputStream.close();
        AppMethodBeat.o(36094);
        return;
      }
      catch (IOException localIOException1)
      {
        AppMethodBeat.o(36094);
        return;
      }
      try
      {
        localIOException2.close();
        AppMethodBeat.o(36094);
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
      ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(localIOException4));
      try
      {
        localIOException1.close();
        AppMethodBeat.o(36094);
        return;
      }
      catch (IOException localIOException2)
      {
        AppMethodBeat.o(36094);
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a
 * JD-Core Version:    0.7.0.1
 */