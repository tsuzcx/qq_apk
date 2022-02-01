package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bg;
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
  private static final String wDh;
  private static LinkedHashMap<Long, Integer> wDi;
  private static Comparator<cuo> wDj;
  
  static
  {
    AppMethodBeat.i(95410);
    StringBuilder localStringBuilder = new StringBuilder();
    g.afC();
    wDh = g.afB().cachePath + "sns_recvd_ad";
    wDj = new Comparator() {};
    AppMethodBeat.o(95410);
  }
  
  private static int a(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95402);
    com.tencent.mm.plugin.sns.storage.p localp = af.dtu().th(paramSnsObject.Id);
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
  
  private static dg a(chg paramchg)
  {
    AppMethodBeat.i(95390);
    if (paramchg != null)
    {
      dg localdg = new dg();
      localdg.CxT = paramchg.EcL;
      if (localdg.CxT == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
        AppMethodBeat.o(95390);
        return null;
      }
      localdg.CxS = b(paramchg.EcK);
      AppMethodBeat.o(95390);
      return localdg;
    }
    AppMethodBeat.o(95390);
    return null;
  }
  
  private static String a(String paramString, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(95409);
    if ((paramSKBuiltinBuffer_t == null) || (paramString == null))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
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
        if (((ab)localObject1).Ctg != null)
        {
          localObject2 = "";
          localIterator = ((ab)localObject1).Ctg.iterator();
          paramSKBuiltinBuffer_t = paramString;
          localObject1 = paramSKBuiltinBuffer_t;
        }
        cug localcug;
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
            localcug = (cug)localIterator.next();
            localObject1 = paramSKBuiltinBuffer_t;
            if (localcug.key == null) {
              break label355;
            }
            localObject1 = paramSKBuiltinBuffer_t;
            str = String.format("<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))", new Object[] { localcug.key });
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
            paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.replaceAll(str + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[] { localObject3 }), String.format("<$1>%s</%s>", new Object[] { localcug.value, localObject3 }));
            localObject1 = paramSKBuiltinBuffer_t;
            localObject2 = (String)localObject2 + localcug.key + ":" + localcug.value + ";";
            localObject1 = localObject2;
            break label365;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", new Object[] { localObject2 });
          localObject2 = paramSKBuiltinBuffer_t;
          localObject1 = paramSKBuiltinBuffer_t;
          if (bw.K(paramString, "ADInfo") != null) {
            continue;
          }
          localObject1 = paramSKBuiltinBuffer_t;
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramString, "replace error occurs!", new Object[0]);
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
    if ((!parama.wSs) || (bt.isNullOrNil(parama.wSr)))
    {
      AppMethodBeat.o(95396);
      return;
    }
    parama = new l(paramLong, 1, parama.wSr);
    g.afC();
    g.afA().gcy.a(parama, 0);
    AppMethodBeat.o(95396);
  }
  
  public static void a(cud paramcud)
  {
    AppMethodBeat.i(95382);
    if (paramcud == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95382);
      return;
    }
    if (paramcud.ElO == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95382);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramcud);
    af.dtx().a(paramcud.ElO.Id, locale);
    AppMethodBeat.o(95382);
  }
  
  public static void a(cud paramcud, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(95380);
    if (paramcud == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95380);
      return;
    }
    if (paramcud.ElO == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95380);
      return;
    }
    com.tencent.mm.plugin.sns.storage.e locale = b(paramcud);
    if (locale == null)
    {
      AppMethodBeat.o(95380);
      return;
    }
    locale.field_adinfo = a(locale.field_adinfo, paramSKBuiltinBuffer_t);
    if (af.dtx().sZ(paramcud.ElO.Id))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + paramcud.ElO.Id);
      af.dtx().b(paramcud.ElO.Id, locale);
      AppMethodBeat.o(95380);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + paramcud.ElO.Id);
    AppMethodBeat.o(95380);
  }
  
  public static void a(cvo paramcvo)
  {
    AppMethodBeat.i(95381);
    a(b(paramcvo));
    AppMethodBeat.o(95381);
  }
  
  private static void a(dg paramdg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95388);
    if (paramdg == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95388);
      return;
    }
    if ((paramdg.CxS == null) || (paramdg.CxS.ElO == null))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
      AppMethodBeat.o(95388);
      return;
    }
    SnsObject localSnsObject = paramdg.CxS.ElO;
    com.tencent.mm.plugin.sns.storage.e locale = b(paramdg.CxS);
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
      AppMethodBeat.o(95388);
      return;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.a(z.a(paramdg.CxT));
    TimeLineObject localTimeLineObject = locale.dxy();
    cxi localcxi = new cxi();
    localcxi.Ept = new cxj();
    localcxi.Ept.CoM = ((com.tencent.mm.plugin.sns.storage.a)localObject).dvK;
    localcxi.Ept.Epw = localTimeLineObject.Id;
    localcxi.Ept.dep = locale.getSource();
    localcxi.Ept.xin = com.tencent.mm.modelstat.p.a(localcxi.Ept);
    if (localTimeLineObject.Etm.DaB == 1) {
      localcxi.Ept.wSJ = 1;
    }
    for (;;)
    {
      localcxi.Ept.Epx = locale.dxx();
      try
      {
        localObject = Base64.encodeToString(localcxi.toByteArray(), 0).replace("\n", "");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[] { localTimeLineObject.Id, localObject, localcxi.Ept.Epw, localcxi.Ept.CoM });
        localTimeLineObject.xns = ((String)localObject);
        locale.g(localTimeLineObject);
        if (locale == null)
        {
          AppMethodBeat.o(95388);
          return;
          if (localTimeLineObject.Etm.DaB == 15)
          {
            localcxi.Ept.wSJ = 2;
            continue;
          }
          localcxi.Ept.wSJ = 0;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", localIOException, "", new Object[0]);
        }
        locale.field_createTime = paramInt1;
        locale.field_createAdTime = paramInt2;
        String str = z.a(paramdg.CxS.ElP);
        if (!bt.isNullOrNil(str)) {
          locale.field_recxml = str;
        }
        locale.field_adinfo = z.a(paramdg.CxT);
        locale.field_adxml = locale.field_recxml;
        af.dtx().a(localSnsObject.Id, locale);
        AppMethodBeat.o(95388);
      }
    }
  }
  
  public static boolean a(long paramLong, cuj paramcuj)
  {
    AppMethodBeat.i(95404);
    cui localcui = paramcuj.Emi;
    if ((localcui.mBH != 7) && (localcui.mBH != 8) && (localcui.mBH != 16))
    {
      AppMethodBeat.o(95404);
      return false;
    }
    com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(paramLong);
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(95404);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localcui.mBH != 7) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localcuo = (cuo)localIterator.next();
          if ((localcuo.CreateTime != localcui.CreateTime) || (!localcuo.Username.equals(localcui.DZr))) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localcuo.CreateTime + " ");
          AppMethodBeat.o(95404);
          return false;
        }
        localSnsObject.LikeUserList.add(ad.b(paramcuj));
        locale.bC(localSnsObject.toByteArray());
        af.dtx().a(localSnsObject.Id, locale);
      }
      catch (Exception paramcuj)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        cuo localcuo;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdSnsInfoStorageLogic", "e " + paramcuj.getMessage());
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcuj, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95404);
      return true;
      if ((localcui.mBH == 8) || (localcui.mBH == 16))
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localcuo = (cuo)localIterator.next();
          if ((localcuo.CreateTime == localcui.CreateTime) && (localcuo.Username.equals(localcui.DZr)))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + localcuo.CreateTime + " ");
            AppMethodBeat.o(95404);
            return false;
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ad.b(paramcuj));
        }
      }
    }
  }
  
  public static boolean a(long paramLong, cuj paramcuj, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(95403);
    Object localObject1;
    if (paramcuj != null)
    {
      localObject1 = paramcuj.Emi;
      if ((((cui)localObject1).mBH != 7) && (((cui)localObject1).mBH != 8) && (((cui)localObject1).mBH != 16))
      {
        AppMethodBeat.o(95403);
        return false;
      }
    }
    Object localObject3 = u.aqG();
    if ((paramcuj != null) && (paramcuj.Emj != null) && (paramcuj.Emj.DZr != null) && (paramcuj.Emj.DZr.equals(localObject3)))
    {
      AppMethodBeat.o(95403);
      return true;
    }
    Object localObject2 = af.dtx().sY(paramLong);
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", new Object[] { Long.valueOf(paramLong) });
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
        paramcuj = paramcuj.Emi;
        if (paramcuj.mBH != 7) {
          break;
        }
        if ((paramInt2 <= 0) || (k + paramInt2 >= paramcuj.CreateTime)) {
          break label822;
        }
        if (paramBoolean)
        {
          if (af.dtu().apJ(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
            break label497;
          }
          localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).dxu();
          if (localObject4 == null) {
            continue;
          }
          localObject3 = (d)g.ab(d.class);
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          l = x.anz(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).dAM;
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionLikeTimeLimit: " + paramInt2 + " curAction.createTime: " + paramcuj.CreateTime + "is over the time limit!");
          AppMethodBeat.o(95403);
          return false;
        }
        paramInt1 = 0;
        continue;
        paramInt3 = 0;
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        AppMethodBeat.o(95403);
      }
      catch (Exception paramcuj)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcuj, "", new Object[0]);
      }
      return true;
      label497:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
    }
    if (((paramcuj.mBH == 8) || (paramcuj.mBH == 16)) && (paramInt3 > 0) && (k + paramInt3 < paramcuj.CreateTime))
    {
      if (paramBoolean)
      {
        if (af.dtu().apJ(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId()) == null) {
          break label811;
        }
        localObject4 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).dxu();
        if (localObject4 == null) {
          break label800;
        }
        localObject3 = (d)g.ab(d.class);
        i = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
        l = x.anz(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
        localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject4).dAM;
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + paramLong + " firstCreateTime " + k + " actionCommentTimeLimit: " + paramInt3 + " curAction.createTime: " + paramcuj.CreateTime + "is over the time limit!");
        AppMethodBeat.o(95403);
        return false;
        label789:
        paramInt1 = 0;
        break;
        label794:
        paramInt2 = 0;
        break label644;
        label800:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
        continue;
        label811:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
      }
    }
    label822:
    int i = 0;
    paramcuj = ((SnsObject)localObject1).LikeUserList.iterator();
    label834:
    int j;
    if (paramcuj.hasNext())
    {
      localObject4 = (cuo)paramcuj.next();
      if (((cuo)localObject4).CreateTime > k)
      {
        if ((localObject4 == null) || (((cuo)localObject4).Username == null)) {
          break label1264;
        }
        if (!((cuo)localObject4).Username.equals(localObject3)) {
          break label1264;
        }
      }
    }
    else
    {
      j = 0;
      paramcuj = ((SnsObject)localObject1).CommentUserList.iterator();
    }
    label1145:
    label1279:
    for (;;)
    {
      if (paramcuj.hasNext())
      {
        localObject4 = (cuo)paramcuj.next();
        if (((cuo)localObject4).CreateTime > k)
        {
          if ((localObject4 == null) || (((cuo)localObject4).Username == null)) {
            break label1273;
          }
          if (!((cuo)localObject4).Username.equals(localObject3)) {
            break label1273;
          }
        }
      }
      else
      {
        i = i + 0 + j;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i + " firstCreateTime " + k + " actionLimit: " + paramInt1 + " actionLikeTimeLimit: " + paramInt2 + " actionCommentTimeLimit: " + paramInt3);
        if (i < paramInt1) {
          break;
        }
        if (paramBoolean)
        {
          paramcuj = af.dtu().apJ(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          if (paramcuj == null) {
            break label1247;
          }
          localObject3 = paramcuj.dxu();
          if (localObject3 == null) {
            break label1236;
          }
          paramcuj = (d)g.ab(d.class);
          paramInt3 = ((com.tencent.mm.plugin.sns.storage.e)localObject2).getSource();
          paramLong = x.anz(((com.tencent.mm.plugin.sns.storage.e)localObject2).getSnsId());
          localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).dAM;
          if (((SnsObject)localObject1).LikeUserList == null) {
            break label1225;
          }
          paramInt1 = ((SnsObject)localObject1).LikeUserList.size();
          if (((SnsObject)localObject1).CommentUserList == null) {
            break label1230;
          }
          paramInt2 = ((SnsObject)localObject1).CommentUserList.size();
          paramcuj.a(13182, paramInt3, new Object[] { Long.valueOf(paramLong), localObject2, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        }
        for (;;)
        {
          AppMethodBeat.o(95403);
          return false;
          paramInt1 = 0;
          break;
          paramInt2 = 0;
          break label1145;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
          continue;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
        }
      }
      break label1279;
      break label1270;
      i += 1;
      break label834;
      j += 1;
    }
  }
  
  private static boolean a(cuo paramcuo, List<cuo> paramList)
  {
    AppMethodBeat.i(95386);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cuo localcuo = (cuo)paramList.next();
      if ((!bt.isNullOrNil(paramcuo.Username)) && (paramcuo.Username.equals(localcuo.Username)))
      {
        AppMethodBeat.o(95386);
        return true;
      }
    }
    AppMethodBeat.o(95386);
    return false;
  }
  
  private static LinkedList<dg> aH(LinkedList<chg> paramLinkedList)
  {
    AppMethodBeat.i(95393);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dg localdg = a((chg)paramLinkedList.next());
      if (localdg != null) {
        localLinkedList.add(localdg);
      }
    }
    AppMethodBeat.o(95393);
    return localLinkedList;
  }
  
  public static void aI(LinkedList<chg> paramLinkedList)
  {
    AppMethodBeat.i(95397);
    if ((paramLinkedList != null) && (!paramLinkedList.isEmpty()))
    {
      paramLinkedList = aH(paramLinkedList);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      aJ(paramLinkedList);
    }
    AppMethodBeat.o(95397);
  }
  
  public static void aJ(LinkedList<dg> paramLinkedList)
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
      c((dg)paramLinkedList.get(i));
      i += 1;
    }
    AppMethodBeat.o(95398);
  }
  
  public static void aK(LinkedList<SnsObject> paramLinkedList)
  {
    AppMethodBeat.i(95400);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(95400);
      return;
    }
    com.tencent.mm.plugin.sns.storage.q localq = af.dtu();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      Object localObject = (SnsObject)paramLinkedList.get(i);
      if (localObject != null)
      {
        localObject = localq.th(((SnsObject)localObject).Id);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.sns.storage.p)localObject).dxy();
          if ((localObject != null) && (!bt.isNullOrNil(((TimeLineObject)localObject).xpl))) {
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95377);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dxp().f("adId", this.wDl.xpl, "adxml", 0);
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
  
  public static void aog(String paramString)
  {
    AppMethodBeat.i(95401);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95401);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95378);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dxp().f("adId", this.wDm, "adxml", 1);
        AppMethodBeat.o(95378);
      }
    }, "preDownloadAdLandingPagesForMsg");
    AppMethodBeat.o(95401);
  }
  
  private static com.tencent.mm.plugin.sns.storage.e b(cud paramcud)
  {
    AppMethodBeat.i(95385);
    com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(paramcud.ElO.Id);
    SnsObject localSnsObject = paramcud.ElO;
    Object localObject1 = null;
    if (locale == null) {
      locale = new com.tencent.mm.plugin.sns.storage.e();
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = z.b(localSnsObject.ObjectDesc);
      if (!bt.isNullOrNil((String)localObject2)) {
        break;
      }
      AppMethodBeat.o(95385);
      return null;
      localObject1 = locale.dxy().xns;
    }
    if (!locale.apI((String)localObject2))
    {
      AppMethodBeat.o(95385);
      return null;
    }
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = locale.dxy();
      ((TimeLineObject)localObject2).xns = ((String)localObject1);
      locale.g((TimeLineObject)localObject2);
    }
    localSnsObject.ObjectOperations = aj.b(localSnsObject.ObjectOperations, locale.field_attrBuf);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(localSnsObject.Id) });
    localSnsObject.ObjectDesc.setBuffer(new byte[0]);
    locale.field_userName = localSnsObject.Username;
    if (paramcud.ElP != null)
    {
      paramcud = z.a(paramcud.ElP);
      if (!bt.isNullOrNil(paramcud)) {
        locale.field_recxml = paramcud;
      }
      paramcud = locale.field_recxml;
      if ((!bt.isNullOrNil(paramcud)) && (!paramcud.equals(locale.field_adxml)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml ".concat(String.valueOf(paramcud)));
        locale.field_adxml = paramcud;
      }
    }
    locale.field_likeFlag = localSnsObject.LikeFlag;
    long l = localSnsObject.Id;
    locale.field_snsId = l;
    if (l != 0L)
    {
      locale.field_stringSeq = com.tencent.mm.plugin.sns.data.q.st(l);
      locale.field_stringSeq = com.tencent.mm.plugin.sns.data.q.anM(locale.field_stringSeq);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdSnsInfo", l + " stringSeq " + locale.field_stringSeq);
    }
    locale.MY(2);
    locale.MY(32);
    try
    {
      if (locale.field_attrBuf == null)
      {
        paramcud = new SnsObject();
        if ((paramcud == null) || (paramcud.CommentUserList == null)) {
          break label891;
        }
        localObject1 = new LinkedList();
        localObject2 = localSnsObject.CommentUserList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label675;
          }
          localObject3 = (cuo)((Iterator)localObject2).next();
          if (((cuo)localObject3).DeleteFlag > 0)
          {
            ((List)localObject1).add(localObject3);
            localIterator = paramcud.CommentUserList.iterator();
            if (localIterator.hasNext())
            {
              localcuo = (cuo)localIterator.next();
              if (localcuo.Emc != ((cuo)localObject3).Emc) {
                break;
              }
              paramcud.CommentUserList.remove(localcuo);
            }
          }
        }
      }
    }
    catch (Exception paramcud)
    {
      for (;;)
      {
        Object localObject3;
        Iterator localIterator;
        cuo localcuo;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "error " + paramcud.getMessage());
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcud, "", new Object[0]);
        try
        {
          for (;;)
          {
            locale.bC(localSnsObject.toByteArray());
            paramcud = locale.dxy();
            paramcud.mAQ = localSnsObject.Username;
            locale.field_pravited = paramcud.DMS;
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + localSnsObject.ExtFlag + " " + localSnsObject.CommentUserList.size() + " " + localSnsObject.LikeUserList.size());
            localObject1 = paramcud.Etm.DaC.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((bpi)((Iterator)localObject1).next()).isAd = true;
            }
            paramcud = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
            break;
            label675:
            localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (cuo)((Iterator)localObject2).next();
              localSnsObject.CommentUserList.remove(localObject3);
            }
            ((List)localObject1).clear();
            localObject1 = paramcud.CommentUserList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (cuo)((Iterator)localObject1).next();
              if ((!b((cuo)localObject2, localSnsObject.CommentUserList)) && (((cuo)localObject2).Emc != 0L))
              {
                g.afC();
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(((cuo)localObject2).Username);
                if ((localObject3 != null) && (com.tencent.mm.n.b.ls(((au)localObject3).field_type)) && (!((com.tencent.mm.storage.af)localObject3).ZM()))
                {
                  localSnsObject.CommentUserList.add(localObject2);
                  localSnsObject.CommentUserListCount = localSnsObject.CommentUserList.size();
                }
                else
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + ((cuo)localObject2).Username);
                }
              }
            }
            label891:
            Collections.sort(localSnsObject.CommentUserList, wDj);
            if (localSnsObject.LikeUserList != null)
            {
              localObject1 = new LinkedList();
              localObject2 = localSnsObject.LikeUserList.iterator();
              for (;;)
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break label1040;
                }
                localObject3 = (cuo)((Iterator)localObject2).next();
                if (((cuo)localObject3).DeleteFlag > 0)
                {
                  ((List)localObject1).add(localObject3);
                  localIterator = paramcud.LikeUserList.iterator();
                  if (localIterator.hasNext())
                  {
                    localcuo = (cuo)localIterator.next();
                    if ((!bt.isNullOrNil(localcuo.Username)) && (!localcuo.Username.equals(((cuo)localObject3).Username))) {
                      break;
                    }
                    paramcud.LikeUserList.remove(localcuo);
                  }
                }
              }
              label1040:
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (cuo)((Iterator)localObject2).next();
                localSnsObject.LikeUserList.remove(localObject3);
              }
              ((List)localObject1).clear();
              if ((paramcud != null) && (paramcud.LikeUserList != null))
              {
                paramcud = paramcud.LikeUserList.iterator();
                while (paramcud.hasNext())
                {
                  localObject1 = (cuo)paramcud.next();
                  if (!a((cuo)localObject1, localSnsObject.LikeUserList))
                  {
                    g.afC();
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(((cuo)localObject1).Username);
                    if ((localObject2 != null) && (com.tencent.mm.n.b.ls(((au)localObject2).field_type)) && (!((com.tencent.mm.storage.af)localObject2).ZM()))
                    {
                      localSnsObject.LikeUserList.add(localObject1);
                      localSnsObject.LikeUserListCount = localSnsObject.LikeUserList.size();
                    }
                    else
                    {
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + ((cuo)localObject1).Username);
                    }
                  }
                }
              }
              Collections.sort(localSnsObject.LikeUserList, wDj);
            }
          }
        }
        catch (Exception paramcud)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", paramcud, "", new Object[0]);
          }
          locale.g(paramcud);
          locale.field_type = paramcud.Etm.DaB;
          locale.field_subType = paramcud.Etm.DaD;
          AppMethodBeat.o(95385);
        }
      }
    }
    return locale;
  }
  
  private static cud b(cvo paramcvo)
  {
    AppMethodBeat.i(95389);
    if (paramcvo != null)
    {
      cud localcud = new cud();
      localcud.ElP = paramcvo.Eni;
      if (localcud.ElP == null) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
      }
      localcud.ElO = paramcvo.ElO;
      AppMethodBeat.o(95389);
      return localcud;
    }
    AppMethodBeat.o(95389);
    return null;
  }
  
  public static void b(chg paramchg)
  {
    AppMethodBeat.i(95391);
    paramchg = a(paramchg);
    if (paramchg == null)
    {
      AppMethodBeat.o(95391);
      return;
    }
    com.tencent.mm.plugin.sns.storage.a locala = new com.tencent.mm.plugin.sns.storage.a(z.a(paramchg.CxT));
    int j = locala.wRQ;
    Cursor localCursor;
    com.tencent.mm.plugin.sns.storage.p localp;
    if (j <= 0)
    {
      i = 1;
      int k = af.dtu().aqa("");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      localCursor = af.dtu().au("", k, i);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label298;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[] { Integer.valueOf(localCursor.getCount()) });
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
    for (int i = localp.field_createTime + 1;; i = (int)bt.aGK())
    {
      localCursor.close();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + paramchg.CxS.ElO.Id + " ,createTime " + i);
      a(paramchg, i, (int)bt.aGK());
      c(paramchg);
      a(paramchg.CxS.ElO.Id, locala);
      AppMethodBeat.o(95391);
      return;
      i = j + 1;
      break;
      i = j;
      break label159;
      localCursor.moveToLast();
      localp.convertFrom(localCursor);
      break label177;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
    }
  }
  
  public static void b(dg paramdg)
  {
    AppMethodBeat.i(95383);
    if (paramdg == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
      AppMethodBeat.o(95383);
      return;
    }
    if (paramdg.CxS == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
      AppMethodBeat.o(95383);
      return;
    }
    if (paramdg.CxS.ElO == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
      AppMethodBeat.o(95383);
      return;
    }
    Object localObject;
    if (!af.dtx().sZ(paramdg.CxS.ElO.Id))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "insert at adObject");
      int i = (int)(System.currentTimeMillis() / 1000L);
      if (paramdg.CxS.ElO.CommentUserListCount > 0) {
        i = ((cuo)paramdg.CxS.ElO.CommentUserList.get(0)).CreateTime;
      }
      a(paramdg, i, i);
      localObject = af.dtx().sY(paramdg.CxS.ElO.Id);
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
        ((com.tencent.mm.plugin.sns.storage.e)localObject).field_localFlag |= 0x100;
        af.dtx().a(((com.tencent.mm.plugin.sns.storage.e)localObject).field_snsId, (com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(paramdg.CxS.ElO.Id);
      if (locale != null)
      {
        locale.field_atAdinfo = z.a(paramdg.CxT);
        by localby = locale.dxz();
        localObject = localby;
        if (localby == null) {
          localObject = new by();
        }
        ((by)localObject).CwV = paramdg.CxV;
        if (((by)localObject).CwV != null) {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "update atFriend remindInfo, aid64 %d, aid %d", new Object[] { Long.valueOf(((by)localObject).CwV.Eem), Integer.valueOf(((by)localObject).CwV.Eeh) });
        }
        locale.a((by)localObject);
        af.dtx().a(locale.field_snsId, locale);
      }
      AppMethodBeat.o(95383);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "just update at SnsAdObject");
      a(paramdg.CxS);
    }
  }
  
  private static boolean b(cuo paramcuo, List<cuo> paramList)
  {
    AppMethodBeat.i(95387);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cuo localcuo = (cuo)paramList.next();
      if ((paramcuo.Emc == localcuo.Emc) && (localcuo.Emc != 0L))
      {
        AppMethodBeat.o(95387);
        return true;
      }
    }
    AppMethodBeat.o(95387);
    return false;
  }
  
  private static void c(dg paramdg)
  {
    AppMethodBeat.i(95399);
    paramdg = z.a(paramdg.CxS.ElP);
    if ((!bt.isNullOrNil(paramdg)) && (new com.tencent.mm.plugin.sns.storage.b(paramdg).dvh())) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95376);
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dxp().f("adId", this.wDk, "adxml", 0);
          AppMethodBeat.o(95376);
        }
      }, "predownloadAdLandingPages");
    }
    AppMethodBeat.o(95399);
  }
  
  /* Error */
  private static void dsC()
  {
    // Byte code:
    //   0: ldc_w 954
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 956	com/tencent/mm/plugin/sns/model/a:wDi	Ljava/util/LinkedHashMap;
    //   9: ifnonnull +61 -> 70
    //   12: getstatic 61	com/tencent/mm/plugin/sns/model/a:wDh	Ljava/lang/String;
    //   15: invokestatic 962	com/tencent/mm/pluginsdk/h/a/d/a:aBs	(Ljava/lang/String;)[B
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
    //   52: putstatic 956	com/tencent/mm/plugin/sns/model/a:wDi	Ljava/util/LinkedHashMap;
    //   55: aload_1
    //   56: invokeinterface 979 1 0
    //   61: getstatic 956	com/tencent/mm/plugin/sns/model/a:wDi	Ljava/util/LinkedHashMap;
    //   64: ifnonnull +6 -> 70
    //   67: invokestatic 982	com/tencent/mm/plugin/sns/model/a:dsD	()V
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
    //   85: invokestatic 986	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   116: invokestatic 986	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   119: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   147: invokestatic 986	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   150: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private static void dsD()
  {
    AppMethodBeat.i(95407);
    wDi = new a.5((int)Math.ceil(666.66668701171875D) + 1);
    AppMethodBeat.o(95407);
  }
  
  public static void e(LinkedList<chg> paramLinkedList, LinkedList<SnsObject> paramLinkedList1)
  {
    AppMethodBeat.i(95392);
    if (paramLinkedList != null)
    {
      paramLinkedList = aH(paramLinkedList);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + paramLinkedList.size() + " recObj to AdvertiseObj");
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dg localdg = (dg)localIterator.next();
        if (sx(localdg.CxS.ElO.Id))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + localdg.CxS.ElO.Id);
          localIterator.remove();
        }
      }
      x(paramLinkedList, paramLinkedList1);
    }
    AppMethodBeat.o(95392);
  }
  
  public static void sv(long paramLong)
  {
    AppMethodBeat.i(187322);
    com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(paramLong);
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
      AppMethodBeat.o(187322);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
      if (localSnsObject == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "snsObject is null!");
        AppMethodBeat.o(187322);
        return;
      }
      boolean bool = com.tencent.mm.plugin.sns.data.j.a(localSnsObject, u.aqG());
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAd, hasCommentLike %s , id %s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.plugin.sns.data.q.st(paramLong) });
      if (!bool) {}
      try
      {
        h.a(0, paramLong, locale.dxu(), locale.dxs());
        af.dtx().delete(paramLong);
        af.dtz().tc(paramLong);
        i.tb(paramLong);
        AppMethodBeat.o(187322);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdSnsInfoStorageLogic", "reportAdDelException: " + localThrowable.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdSnsInfoStorageLogic", "deleteAd， parse SnsObject error!:" + localException.toString());
      AppMethodBeat.o(187322);
    }
  }
  
  public static void sw(long paramLong)
  {
    AppMethodBeat.i(187323);
    try
    {
      String str = com.tencent.mm.plugin.sns.data.q.st(paramLong);
      com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(paramLong);
      if (locale == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, adSnsInfo is null, snsId=".concat(String.valueOf(str)));
        AppMethodBeat.o(187323);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=".concat(String.valueOf(str)));
      try
      {
        h.a(1, paramLong, locale.dxu(), locale.dxs());
        af.dtx().delete(paramLong);
        af.dtz().tc(paramLong);
        i.tb(paramLong);
        AppMethodBeat.o(187323);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdSnsInfoStorageLogic", "reportAdDelException: " + localThrowable.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=" + com.tencent.mm.plugin.sns.data.q.st(paramLong) + ", exp=" + localException.toString());
      AppMethodBeat.o(187323);
    }
  }
  
  private static boolean sx(long paramLong)
  {
    AppMethodBeat.i(95405);
    dsC();
    if (wDi.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(95405);
      return true;
    }
    AppMethodBeat.o(95405);
    return false;
  }
  
  private static void sy(long paramLong)
  {
    AppMethodBeat.i(95408);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(95408);
      return;
    }
    if (wDi == null) {
      dsC();
    }
    wDi.put(Long.valueOf(paramLong), Integer.valueOf(0));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      Object localObject1 = new ObjectOutputStream(localByteArrayOutputStream);
      ((ObjectOutput)localObject1).writeObject(wDi);
      ((ObjectOutput)localObject1).flush();
      localObject1 = localByteArrayOutputStream.toByteArray();
      com.tencent.mm.pluginsdk.h.a.d.a.x(wDh, (byte[])localObject1);
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdSnsInfoStorageLogic", bt.m(localIOException4));
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
  
  private static void x(List<dg> paramList, List<SnsObject> paramList1)
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
      dg localdg = (dg)paramList.get(i);
      if (localdg == null) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
      }
      Object localObject;
      com.tencent.mm.plugin.sns.storage.a locala;
      for (;;)
      {
        i += 1;
        break;
        if (localdg.CxS == null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
        }
        else if (localdg.CxS.ElO == null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
        }
        else
        {
          localObject = z.a(localdg.CxT);
          String str1 = z.a(localdg.CxS.ElP);
          String str2 = z.b(localdg.CxS.ElO.ObjectDesc);
          locala = new com.tencent.mm.plugin.sns.storage.a((String)localObject);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "skXml ".concat(String.valueOf(localObject)));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "adXml ".concat(String.valueOf(str1)));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + str2 + "\r\n");
          localObject = new com.tencent.mm.plugin.sns.storage.b(str1);
          if ((((com.tencent.mm.plugin.sns.storage.b)localObject).wTh == 0L) || (!sx(((com.tencent.mm.plugin.sns.storage.b)localObject).wTh))) {
            break label309;
          }
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + ((com.tencent.mm.plugin.sns.storage.b)localObject).wTh);
        }
      }
      label309:
      int j = k + 1;
      if ((locala.wRQ < paramList1.size()) && (locala.wRQ >= 0))
      {
        j = a((SnsObject)paramList1.get(locala.wRQ)) + 1;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + j + " pos " + locala.wRQ);
      }
      for (;;)
      {
        int m = (int)(System.currentTimeMillis() / 1000L);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(m)));
        a(localdg, j, m);
        sy(localdg.CxS.ElO.Id);
        sy(((com.tencent.mm.plugin.sns.storage.b)localObject).wTh);
        a(localdg.CxS.ElO.Id, locala);
        break;
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + locala.wRQ);
      }
    }
    AppMethodBeat.o(95394);
  }
  
  /* Error */
  public static void y(List<dg> paramList, List<SnsObject> paramList1)
  {
    // Byte code:
    //   0: ldc_w 1145
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +16 -> 23
    //   10: aload_1
    //   11: ifnull +12 -> 23
    //   14: aload_1
    //   15: invokeinterface 1108 1 0
    //   20: ifne +10 -> 30
    //   23: ldc_w 1145
    //   26: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_1
    //   31: aload_1
    //   32: invokeinterface 1108 1 0
    //   37: iconst_1
    //   38: isub
    //   39: invokeinterface 1109 2 0
    //   44: checkcast 79	com/tencent/mm/protocal/protobuf/SnsObject
    //   47: invokestatic 1111	com/tencent/mm/plugin/sns/model/a:a	(Lcom/tencent/mm/protocal/protobuf/SnsObject;)I
    //   50: istore 5
    //   52: iconst_1
    //   53: istore_2
    //   54: new 31	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   61: astore 13
    //   63: aload 13
    //   65: ldc_w 1147
    //   68: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: iconst_0
    //   73: istore_3
    //   74: iload_3
    //   75: aload_0
    //   76: invokeinterface 1108 1 0
    //   81: if_icmpge +835 -> 916
    //   84: aload_0
    //   85: iload_3
    //   86: invokeinterface 1109 2 0
    //   91: checkcast 102	com/tencent/mm/protocal/protobuf/dg
    //   94: astore 14
    //   96: aload 14
    //   98: ifnonnull +18 -> 116
    //   101: ldc 114
    //   103: ldc_w 1113
    //   106: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: iload_3
    //   110: iconst_1
    //   111: iadd
    //   112: istore_3
    //   113: goto -39 -> 74
    //   116: aload 14
    //   118: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   121: ifnonnull +14 -> 135
    //   124: ldc 114
    //   126: ldc_w 1115
    //   129: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -23 -> 109
    //   135: aload 14
    //   137: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   140: getfield 296	com/tencent/mm/protocal/protobuf/cud:ElO	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   143: ifnonnull +14 -> 157
    //   146: ldc 114
    //   148: ldc_w 1117
    //   151: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -45 -> 109
    //   157: aload 14
    //   159: getfield 112	com/tencent/mm/protocal/protobuf/dg:CxT	Lcom/tencent/mm/protocal/protobuf/cmf;
    //   162: invokestatic 348	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/cmf;)Ljava/lang/String;
    //   165: astore 9
    //   167: aload 14
    //   169: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   172: getfield 439	com/tencent/mm/protocal/protobuf/cud:ElP	Lcom/tencent/mm/protocal/protobuf/cmf;
    //   175: invokestatic 348	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/cmf;)Ljava/lang/String;
    //   178: astore 10
    //   180: aload 14
    //   182: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   185: getfield 296	com/tencent/mm/protocal/protobuf/cud:ElO	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   188: getfield 679	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   191: invokestatic 682	com/tencent/mm/platformtools/z:b	(Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;)Ljava/lang/String;
    //   194: astore 11
    //   196: new 253	com/tencent/mm/plugin/sns/storage/a
    //   199: dup
    //   200: aload 9
    //   202: invokespecial 349	com/tencent/mm/plugin/sns/storage/a:<init>	(Ljava/lang/String;)V
    //   205: astore 15
    //   207: ldc 114
    //   209: ldc_w 1149
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
    //   231: invokestatic 230	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: iload_2
    //   235: ifeq +812 -> 1047
    //   238: aload 14
    //   240: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   243: getfield 296	com/tencent/mm/protocal/protobuf/cud:ElO	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   246: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   249: lstore 7
    //   251: aload 15
    //   253: getfield 1152	com/tencent/mm/plugin/sns/storage/a:wSi	Ljava/lang/String;
    //   256: astore 16
    //   258: aload 15
    //   260: getfield 366	com/tencent/mm/plugin/sns/storage/a:dvK	Ljava/lang/String;
    //   263: astore 11
    //   265: aload 11
    //   267: ldc_w 1154
    //   270: invokestatic 1159	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   273: astore 9
    //   275: invokestatic 1164	com/tencent/mm/plugin/sns/data/f:drW	()Ljava/lang/String;
    //   278: astore 10
    //   280: aload 10
    //   282: ldc_w 1154
    //   285: invokestatic 1159	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 12
    //   290: aload 12
    //   292: astore 10
    //   294: lload 7
    //   296: invokestatic 725	com/tencent/mm/plugin/sns/data/q:st	(J)Ljava/lang/String;
    //   299: astore 12
    //   301: ldc_w 1166
    //   304: new 31	java/lang/StringBuilder
    //   307: dup
    //   308: ldc_w 1168
    //   311: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload 12
    //   316: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 1170
    //   322: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 16
    //   327: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 1172
    //   333: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 11
    //   338: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 1174
    //   344: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 10
    //   349: invokevirtual 210	java/lang/String:length	()I
    //   352: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: getstatic 1180	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
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
    //   410: invokevirtual 1184	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   413: iconst_0
    //   414: istore_2
    //   415: aload 13
    //   417: aload 14
    //   419: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   422: getfield 296	com/tencent/mm/protocal/protobuf/cud:ElO	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   425: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   428: invokestatic 725	com/tencent/mm/plugin/sns/data/q:st	(J)Ljava/lang/String;
    //   431: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 1186
    //   437: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 13
    //   443: aload 15
    //   445: getfield 847	com/tencent/mm/plugin/sns/storage/a:wRQ	I
    //   448: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: ldc_w 1188
    //   454: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: iload 5
    //   460: iconst_1
    //   461: iadd
    //   462: istore 4
    //   464: aload 15
    //   466: getfield 847	com/tencent/mm/plugin/sns/storage/a:wRQ	I
    //   469: aload_1
    //   470: invokeinterface 1108 1 0
    //   475: if_icmpge +412 -> 887
    //   478: aload 15
    //   480: getfield 847	com/tencent/mm/plugin/sns/storage/a:wRQ	I
    //   483: iflt +404 -> 887
    //   486: aload_1
    //   487: aload 15
    //   489: getfield 847	com/tencent/mm/plugin/sns/storage/a:wRQ	I
    //   492: invokeinterface 1109 2 0
    //   497: checkcast 79	com/tencent/mm/protocal/protobuf/SnsObject
    //   500: invokestatic 1111	com/tencent/mm/plugin/sns/model/a:a	(Lcom/tencent/mm/protocal/protobuf/SnsObject;)I
    //   503: iconst_1
    //   504: iadd
    //   505: istore 4
    //   507: ldc 114
    //   509: new 31	java/lang/StringBuilder
    //   512: dup
    //   513: ldc_w 1132
    //   516: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: iload 4
    //   521: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: ldc_w 1134
    //   527: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 15
    //   532: getfield 847	com/tencent/mm/plugin/sns/storage/a:wRQ	I
    //   535: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   547: ldc2_w 587
    //   550: ldiv
    //   551: l2i
    //   552: istore 6
    //   554: ldc 114
    //   556: ldc_w 1136
    //   559: iload 6
    //   561: invokestatic 1138	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   564: invokevirtual 472	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   567: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload 14
    //   572: iload 4
    //   574: iload 6
    //   576: invokestatic 884	com/tencent/mm/plugin/sns/model/a:a	(Lcom/tencent/mm/protocal/protobuf/dg;II)V
    //   579: invokestatic 303	com/tencent/mm/plugin/sns/model/af:dtx	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   582: aload 14
    //   584: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   587: getfield 296	com/tencent/mm/protocal/protobuf/cud:ElO	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   590: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   593: invokevirtual 462	com/tencent/mm/plugin/sns/storage/f:sY	(J)Lcom/tencent/mm/plugin/sns/storage/e;
    //   596: astore 11
    //   598: aload 11
    //   600: ifnull +116 -> 716
    //   603: aload 11
    //   605: invokevirtual 912	com/tencent/mm/plugin/sns/storage/e:dxz	()Lcom/tencent/mm/protocal/protobuf/by;
    //   608: astore 10
    //   610: aload 10
    //   612: astore 9
    //   614: aload 10
    //   616: ifnonnull +12 -> 628
    //   619: new 914	com/tencent/mm/protocal/protobuf/by
    //   622: dup
    //   623: invokespecial 915	com/tencent/mm/protocal/protobuf/by:<init>	()V
    //   626: astore 9
    //   628: aload 9
    //   630: aload 14
    //   632: getfield 919	com/tencent/mm/protocal/protobuf/dg:CxV	Lcom/tencent/mm/protocal/protobuf/ciu;
    //   635: putfield 1191	com/tencent/mm/protocal/protobuf/by:CwU	Lcom/tencent/mm/protocal/protobuf/ciu;
    //   638: aload 9
    //   640: getfield 1191	com/tencent/mm/protocal/protobuf/by:CwU	Lcom/tencent/mm/protocal/protobuf/ciu;
    //   643: ifnull +43 -> 686
    //   646: ldc 114
    //   648: ldc_w 1193
    //   651: iconst_2
    //   652: anewarray 4	java/lang/Object
    //   655: dup
    //   656: iconst_0
    //   657: aload 9
    //   659: getfield 1191	com/tencent/mm/protocal/protobuf/by:CwU	Lcom/tencent/mm/protocal/protobuf/ciu;
    //   662: getfield 929	com/tencent/mm/protocal/protobuf/ciu:Eem	J
    //   665: invokestatic 543	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: aastore
    //   669: dup
    //   670: iconst_1
    //   671: aload 9
    //   673: getfield 1191	com/tencent/mm/protocal/protobuf/by:CwU	Lcom/tencent/mm/protocal/protobuf/ciu;
    //   676: getfield 932	com/tencent/mm/protocal/protobuf/ciu:Eeh	I
    //   679: invokestatic 580	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   682: aastore
    //   683: invokestatic 230	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   686: aload 11
    //   688: aload 9
    //   690: invokevirtual 935	com/tencent/mm/plugin/sns/storage/e:a	(Lcom/tencent/mm/protocal/protobuf/by;)V
    //   693: aload 11
    //   695: aload 11
    //   697: getfield 905	com/tencent/mm/plugin/sns/storage/e:field_localFlag	I
    //   700: sipush -257
    //   703: iand
    //   704: putfield 905	com/tencent/mm/plugin/sns/storage/e:field_localFlag	I
    //   707: invokestatic 303	com/tencent/mm/plugin/sns/model/af:dtx	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   710: aload 11
    //   712: invokevirtual 1196	com/tencent/mm/plugin/sns/storage/f:replace	(Lcom/tencent/mm/sdk/e/c;)Z
    //   715: pop
    //   716: aload 14
    //   718: getfield 133	com/tencent/mm/protocal/protobuf/dg:CxS	Lcom/tencent/mm/protocal/protobuf/cud;
    //   721: getfield 296	com/tencent/mm/protocal/protobuf/cud:ElO	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   724: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   727: aload 15
    //   729: invokestatic 886	com/tencent/mm/plugin/sns/model/a:a	(JLcom/tencent/mm/plugin/sns/storage/a;)V
    //   732: goto -623 -> 109
    //   735: astore 9
    //   737: ldc_w 1166
    //   740: new 31	java/lang/StringBuilder
    //   743: dup
    //   744: ldc_w 1198
    //   747: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   750: aload 9
    //   752: invokevirtual 1064	java/lang/Exception:toString	()Ljava/lang/String;
    //   755: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: ldc_w 1200
    //   761: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload 11
    //   766: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   775: aload 11
    //   777: astore 9
    //   779: goto -504 -> 275
    //   782: astore 12
    //   784: ldc_w 1166
    //   787: new 31	java/lang/StringBuilder
    //   790: dup
    //   791: ldc_w 1198
    //   794: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   797: aload 12
    //   799: invokevirtual 1064	java/lang/Exception:toString	()Ljava/lang/String;
    //   802: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: ldc_w 1200
    //   808: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload 10
    //   813: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: goto -528 -> 294
    //   825: astore 9
    //   827: ldc 114
    //   829: new 31	java/lang/StringBuilder
    //   832: dup
    //   833: ldc_w 1202
    //   836: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   839: aload 9
    //   841: invokevirtual 1064	java/lang/Exception:toString	()Ljava/lang/String;
    //   844: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   853: goto -440 -> 413
    //   856: astore 9
    //   858: ldc 114
    //   860: new 31	java/lang/StringBuilder
    //   863: dup
    //   864: ldc_w 1204
    //   867: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   870: aload 9
    //   872: invokevirtual 1064	java/lang/Exception:toString	()Ljava/lang/String;
    //   875: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: goto -426 -> 458
    //   887: ldc 114
    //   889: new 31	java/lang/StringBuilder
    //   892: dup
    //   893: ldc_w 1142
    //   896: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   899: aload 15
    //   901: getfield 847	com/tencent/mm/plugin/sns/storage/a:wRQ	I
    //   904: invokevirtual 500	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   907: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 243	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   913: goto -369 -> 544
    //   916: aload 13
    //   918: ldc_w 1206
    //   921: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: iconst_0
    //   926: istore_2
    //   927: iload_2
    //   928: aload_1
    //   929: invokeinterface 1108 1 0
    //   934: if_icmpge +38 -> 972
    //   937: aload 13
    //   939: aload_1
    //   940: iload_2
    //   941: invokeinterface 1109 2 0
    //   946: checkcast 79	com/tencent/mm/protocal/protobuf/SnsObject
    //   949: getfield 83	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
    //   952: invokestatic 725	com/tencent/mm/plugin/sns/data/q:st	(J)Ljava/lang/String;
    //   955: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: ldc_w 1186
    //   961: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: iload_2
    //   966: iconst_1
    //   967: iadd
    //   968: istore_2
    //   969: goto -42 -> 927
    //   972: aload 13
    //   974: ldc_w 1208
    //   977: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: ldc 114
    //   983: new 31	java/lang/StringBuilder
    //   986: dup
    //   987: ldc_w 1210
    //   990: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   993: aload 13
    //   995: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: ldc_w 1145
    //   1010: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1013: return
    //   1014: astore_0
    //   1015: ldc 114
    //   1017: new 31	java/lang/StringBuilder
    //   1020: dup
    //   1021: ldc_w 1204
    //   1024: invokespecial 326	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1027: aload_0
    //   1028: invokevirtual 1064	java/lang/Exception:toString	()Ljava/lang/String;
    //   1031: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 526	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1040: ldc_w 1145
    //   1043: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1046: return
    //   1047: goto -632 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1050	0	paramList	List<dg>
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
    //   94	623	14	localdg	dg
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a
 * JD-Core Version:    0.7.0.1
 */