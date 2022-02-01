package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public final class aj
{
  public static long xRo;
  public static long xRp;
  public static final Map<Long, p> xUW;
  public static long xUX;
  public static int xUY;
  private static Map<String, SnsObject> xUZ;
  
  static
  {
    AppMethodBeat.i(95886);
    xUW = new TreeMap(new aj.1());
    xRo = 0L;
    xRp = 0L;
    xUX = 0L;
    xUY = 0;
    xUZ = new ConcurrentHashMap();
    AppMethodBeat.o(95886);
  }
  
  public static boolean Op(int paramInt)
  {
    AppMethodBeat.i(95872);
    ac.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    p localp = af.dHR().Ph(paramInt);
    if (localp == null)
    {
      AppMethodBeat.o(95872);
      return false;
    }
    localp.dMx();
    localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    buc localbuc = null;
    for (;;)
    {
      try
      {
        localObject = (bua)new bua().parseFrom(localp.field_postBuf);
        ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((bua)localObject).gLY = 0;
          ((bua)localObject).FjJ = System.currentTimeMillis();
          localp.field_postBuf = ((bua)localObject).toByteArray();
          if (localObject != null) {
            break;
          }
          AppMethodBeat.o(95872);
          return false;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Object localObject;
            int i;
            t localt;
            continue;
            paramInt += 1;
          }
        }
        localException2 = localException2;
        localObject = localbuc;
      }
    }
    af.dHR().b(paramInt, localp);
    paramInt = 0;
    if (paramInt < ((bua)localObject).FjG.size())
    {
      i = ((bqx)((bua)localObject).FjG.get(paramInt)).Fgc;
      localt = af.dHG().xL(i);
      if (localt != null)
      {
        localt.offset = 0;
        try
        {
          localbuc = (buc)new buc().parseFrom(localt.ywe);
          if (localbuc.FfT == 0) {
            break label277;
          }
          localbuc.FfT = 2;
          localbuc.Fke = "";
          localt.ywe = localbuc.toByteArray();
          af.dHG().a(i, localt);
        }
        catch (Exception localException1)
        {
          ac.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          AppMethodBeat.o(95872);
          return false;
        }
      }
    }
    else
    {
      AppMethodBeat.o(95872);
      return true;
    }
  }
  
  public static p Oq(int paramInt)
  {
    AppMethodBeat.i(95876);
    p localp = new p();
    Object localObject1 = af.dHR();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dMP();
    localObject2 = (String)localObject2 + " and createTime < " + paramInt;
    localObject2 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.q.yvI;
    localObject2 = (String)localObject2 + " LIMIT 1";
    ac.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[] { localObject2 });
    localObject2 = ((com.tencent.mm.plugin.sns.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(95876);
      return null;
    }
    if (((Cursor)localObject1).moveToFirst())
    {
      localp.convertFrom((Cursor)localObject1);
      ((Cursor)localObject1).close();
      AppMethodBeat.o(95876);
      return localp;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(95876);
    return null;
  }
  
  public static void Or(int paramInt)
  {
    AppMethodBeat.i(95882);
    ac.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    p localp = af.dHR().Ph(paramInt);
    if (localp == null)
    {
      AppMethodBeat.o(95882);
      return;
    }
    if ((localp.field_localFlag & 0x40) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localp.field_localFlag &= 0xFFFFFFBF;
      }
      af.dHR().b(paramInt, localp);
      AppMethodBeat.o(95882);
      return;
    }
  }
  
  private static long a(p paramp, SnsObject paramSnsObject, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(95867);
    Object localObject = paramp;
    if (paramp == null) {
      localObject = new p();
    }
    long l;
    if (!af.dHQ().xn(((p)localObject).field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      ac.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + com.tencent.mm.plugin.sns.data.q.wW(paramSnsObject.Id));
      if (((p)localObject).Pe(paramInt)) {
        break label908;
      }
      ((p)localObject).Pb(paramInt);
    }
    label908:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        af.dHR().a(paramSnsObject.Id, (p)localObject);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
      paramp = paramSnsObject.CommentUserList;
      ac.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramp.size()), com.tencent.mm.plugin.sns.data.q.wW(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.getBuffer() == null))
      {
        ac.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramp = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
      ac.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
      if (bs.isNullOrNil(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      if (!((p)localObject).auR(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsObject.ObjectOperations = b(paramSnsObject.ObjectOperations, ((p)localObject).field_attrBuf);
      ac.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(paramSnsObject.Id) });
      paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
      ((p)localObject).field_userName = paramSnsObject.Username;
      ((p)localObject).setCreateTime(paramSnsObject.CreateTime);
      ((p)localObject).field_likeFlag = paramSnsObject.LikeFlag;
      ((p)localObject).xG(paramSnsObject.Id);
      ((p)localObject).xI(paramSnsObject.Id);
      ((p)localObject).Pb(paramInt);
      try
      {
        l = bs.Gn();
      }
      catch (Exception paramp)
      {
        label547:
        int j;
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
          continue;
          i = 0;
          continue;
          ((p)localObject).dMs();
        }
        if ((j != 1) && ((paramString.equals(paramSnsObject.Username)) || (paramInt != 4))) {
          continue;
        }
        ((p)localObject).dMo();
        ((p)localObject).f(paramp);
        ((p)localObject).field_type = paramp.FQo.Ety;
        ((p)localObject).field_subType = paramp.FQo.EtA;
        af.dHR().a(paramSnsObject.Id, (p)localObject);
        paramp = paramSnsObject.CommentUserList.iterator();
        if (!paramp.hasNext()) {
          continue;
        }
        paramString = ((daa)paramp.next()).FJe.iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        localObject = a((dag)paramString.next());
        if (az.faZ().GXZ.aOT(((EmojiInfo)localObject).field_md5) != null) {
          continue;
        }
        az.faZ().GXZ.K((EmojiInfo)localObject);
        com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.fOZ;
        com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject, null);
        continue;
        continue;
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      try
      {
        if (((p)localObject).field_type == 15)
        {
          paramp = (SnsObject)new SnsObject().parseFrom(((p)localObject).field_attrBuf);
          if ((paramp != null) && (paramp.PreDownloadInfo != null) && (paramp.PreDownloadInfo.FuL > 0))
          {
            paramSnsObject.PreDownloadInfo = paramp.PreDownloadInfo;
            ac.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.FuL), Integer.valueOf(paramSnsObject.PreDownloadInfo.FuM), paramSnsObject.PreDownloadInfo.FuN, Long.valueOf(bs.aO(l)) });
          }
        }
      }
      catch (Exception paramp)
      {
        ac.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[] { paramp.toString() });
        break label547;
      }
      ((p)localObject).bB(paramSnsObject.toByteArray());
      paramp = ((p)localObject).dLV();
      paramp.ncR = paramSnsObject.Username;
      j = paramp.Fjj;
      ((p)localObject).field_pravited = j;
      ac.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsObject.ExtFlag) });
      if ((paramSnsObject.ExtFlag & 0x1) > 0)
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        ((p)localObject).dMr();
        if ((j != 1) || (paramInt == 4) || (paramInt == 16)) {
          continue;
        }
        ac.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        AppMethodBeat.o(95867);
        return 0L;
      }
    }
  }
  
  public static btz a(p paramp, int paramInt)
  {
    AppMethodBeat.i(95878);
    if (af.dHA())
    {
      AppMethodBeat.o(95878);
      return null;
    }
    if (paramp == null)
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = paramp.dLV();
    if ((paramp.FQo == null) || (paramp.FQo.Etz.size() == 0) || (paramp.FQo.Etz.size() <= paramInt))
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = (btz)paramp.FQo.Etz.get(paramInt);
    AppMethodBeat.o(95878);
    return paramp;
  }
  
  public static btz a(p paramp, String paramString)
  {
    AppMethodBeat.i(95879);
    paramp = paramp.dLV();
    if ((paramp.FQo == null) || (paramp.FQo.Etz.size() == 0))
    {
      AppMethodBeat.o(95879);
      return null;
    }
    paramp = paramp.FQo.Etz.iterator();
    while (paramp.hasNext())
    {
      btz localbtz = (btz)paramp.next();
      if (localbtz.Id.equals(paramString))
      {
        AppMethodBeat.o(95879);
        return localbtz;
      }
    }
    AppMethodBeat.o(95879);
    return null;
  }
  
  public static EmojiInfo a(dag paramdag)
  {
    AppMethodBeat.i(95868);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    if (paramdag == null)
    {
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    if (paramdag.FJx == null)
    {
      localEmojiInfo.field_md5 = paramdag.Md5;
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    try
    {
      ads localads = new ads();
      localads.parseFrom(paramdag.FJx.getBufferToBytes());
      com.tencent.mm.plugin.emoji.h.b.a(localads, localEmojiInfo);
      localEmojiInfo.field_temp = 1;
      localEmojiInfo.field_catalog = EmojiInfo.Jss;
      label86:
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    catch (Exception paramdag)
    {
      break label86;
    }
  }
  
  public static List<p> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(95857);
    if (paramBoolean2) {}
    for (paramString1 = af.dHR().b(paramString1, 10, paramBoolean1, paramString2);; paramString1 = af.dHR().g(paramString1, paramBoolean1, paramString2))
    {
      paramString2 = new ArrayList();
      if (paramString1.getCount() != 0) {
        break;
      }
      paramString1.close();
      AppMethodBeat.o(95857);
      return paramString2;
    }
    if (paramString1.moveToFirst()) {
      do
      {
        p localp = new p();
        localp.convertFrom(paramString1);
        paramString2.add(localp);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    AppMethodBeat.o(95857);
    return paramString2;
  }
  
  public static boolean a(long paramLong, czv paramczv)
  {
    AppMethodBeat.i(95865);
    czu localczu = paramczv.FJh;
    if ((localczu.ndI != 1) && (localczu.ndI != 2))
    {
      AppMethodBeat.o(95865);
      return true;
    }
    p localp = af.dHR().xK(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(95865);
      return true;
    }
    if ((localp.field_type == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.dGQ()))
    {
      ac.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
      AppMethodBeat.o(95865);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localczu.ndI != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdaa = (daa)localIterator.next();
          if (localdaa.CreateTime != localczu.CreateTime) {
            continue;
          }
          bool = localdaa.Username.equals(localczu.Fwn);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(95865);
          return true;
        }
        localSnsObject.LikeUserList.add(ad.b(paramczv));
        localp.bB(localSnsObject.toByteArray());
        af.dHR().a(localSnsObject.Id, localp);
      }
      catch (Exception paramczv)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        daa localdaa;
        boolean bool;
        ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramczv, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95865);
      return true;
      if (localczu.ndI == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localdaa = (daa)localIterator.next();
          if (localdaa.CreateTime == localczu.CreateTime)
          {
            bool = localdaa.Username.equals(localczu.Fwn);
            if (bool)
            {
              AppMethodBeat.o(95865);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ad.b(paramczv));
        }
      }
    }
  }
  
  public static boolean aeD(String paramString)
  {
    AppMethodBeat.i(95873);
    boolean bool = com.tencent.mm.model.u.axw().equals(paramString.trim());
    AppMethodBeat.o(95873);
    return bool;
  }
  
  public static boolean as(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (paramInt > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static p atS(String paramString)
  {
    AppMethodBeat.i(95859);
    paramString = af.dHR().b(paramString, 1, false, "");
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(95859);
      return null;
    }
    paramString.moveToFirst();
    p localp = new p();
    localp.convertFrom(paramString);
    if (!paramString.isClosed()) {
      paramString.close();
    }
    AppMethodBeat.o(95859);
    return localp;
  }
  
  public static String atT(String paramString)
  {
    AppMethodBeat.i(95875);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = af.dHX().getCursor();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        v localv = new v();
        localv.convertFrom((Cursor)localObject);
        localLinkedList.add(bs.bG(localv.field_tagName, ""));
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    localObject = paramString;
    while (localLinkedList.contains(localObject))
    {
      localObject = paramString + i;
      i += 1;
    }
    AppMethodBeat.o(95875);
    return localObject;
  }
  
  public static List<com.tencent.mm.plugin.sns.i.b> atU(String paramString)
  {
    AppMethodBeat.i(95880);
    ArrayList localArrayList = new ArrayList();
    if (af.dHA())
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    Object localObject = h.auT(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localObject = ((p)localObject).dLV();
    if ((((TimeLineObject)localObject).FQo == null) || (((TimeLineObject)localObject).FQo.Etz.size() == 0))
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((TimeLineObject)localObject).FQo.Etz.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      btz localbtz = (btz)localIterator.next();
      com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
      localb.dwE = localbtz;
      localb.yav = paramString;
      localb.hGU = ((TimeLineObject)localObject).CreateTime;
      localb.yax = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95880);
    return localArrayList;
  }
  
  public static SKBuiltinBuffer_t b(SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95869);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((SnsObject)new SnsObject().parseFrom(paramArrayOfByte)).ObjectOperations;
        if (paramSKBuiltinBuffer_t == null)
        {
          AppMethodBeat.o(95869);
          return localSKBuiltinBuffer_t;
        }
        dau localdau = new dau();
        paramArrayOfByte = localdau;
        if (localSKBuiltinBuffer_t != null) {
          paramArrayOfByte = (dau)localdau.parseFrom(localSKBuiltinBuffer_t.getBufferToBytes());
        }
        paramSKBuiltinBuffer_t = (dau)new dau().parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        if (paramSKBuiltinBuffer_t.FJT == null) {
          paramSKBuiltinBuffer_t.FJT = paramArrayOfByte.FJT;
        }
        if (paramArrayOfByte.FJS == null)
        {
          paramSKBuiltinBuffer_t.FJS = null;
          paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.toByteArray();
          paramSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(paramSKBuiltinBuffer_t);
          AppMethodBeat.o(95869);
          return paramSKBuiltinBuffer_t;
        }
        if (paramSKBuiltinBuffer_t.FJS == null)
        {
          paramSKBuiltinBuffer_t.FJS = paramArrayOfByte.FJS;
          continue;
          localSKBuiltinBuffer_t = null;
        }
      }
      catch (Exception paramSKBuiltinBuffer_t)
      {
        ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSKBuiltinBuffer_t, "", new Object[0]);
        AppMethodBeat.o(95869);
        return null;
      }
    }
  }
  
  public static void b(long paramLong, czv paramczv)
  {
    AppMethodBeat.i(95863);
    paramczv = paramczv.FJh;
    if (paramczv.ndI != 9)
    {
      AppMethodBeat.o(95863);
      return;
    }
    p localp = af.dHR().xK(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(95863);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      while (localIterator.hasNext())
      {
        daa localdaa = (daa)localIterator.next();
        if ((localdaa.FIZ == paramczv.FIZ) && (!bs.isNullOrNil(localdaa.Username)) && (localdaa.Username.equals(paramczv.Fwn))) {
          localSnsObject.CommentUserList.remove(localdaa);
        }
      }
      localp.bB(localSnsObject.toByteArray());
      af.dHR().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95863);
      return;
    }
    catch (Exception paramczv)
    {
      ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramczv, "", new Object[0]);
      AppMethodBeat.o(95863);
    }
  }
  
  public static void b(String paramString1, int paramInt, LinkedList<SnsObject> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(95871);
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      AppMethodBeat.o(95871);
      return;
    }
    Object localObject3 = af.dHR();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    Object localObject2;
    while (i < paramLinkedList.size())
    {
      SnsObject localSnsObject = (SnsObject)paramLinkedList.get(i);
      localObject2 = ((com.tencent.mm.plugin.sns.storage.q)localObject3).xK(localSnsObject.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new p();
      }
      if (a((p)localObject1, localSnsObject, paramString1, paramInt) != 0L)
      {
        if ((localLinkedList.size() < 3) && ((((p)localObject1).field_type == 1) || (((p)localObject1).field_type == 15))) {
          localLinkedList.add(com.tencent.mm.plugin.sns.data.q.wW(((p)localObject1).field_snsId));
        }
        localArrayList.add(Long.valueOf(localSnsObject.Id));
      }
      i += 1;
    }
    if (((paramInt == 4) || (paramInt == 8)) && (paramString2.equals("")))
    {
      localObject1 = af.dHV().auY(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((n)localObject1).field_newerIds;
        localObject1 = bs.S(bs.bG((String)localObject1, "").split(","));
        ac.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + fw(localLinkedList));
        label270:
        do
        {
          if ((localLinkedList.size() >= 3) || (((List)localObject1).size() <= 0)) {
            break;
          }
          localObject2 = (String)((List)localObject1).remove(0);
        } while (localObject2 == null);
        i = 0;
      }
      for (;;)
      {
        if (i < localLinkedList.size())
        {
          localObject3 = (String)localLinkedList.get(i);
          if (((String)localObject2).compareTo((String)localObject3) != 0)
          {
            if (((String)localObject2).compareTo((String)localObject3) <= 0) {
              break label400;
            }
            localLinkedList.add(0, localObject2);
          }
        }
        if (localLinkedList.contains(localObject2)) {
          break label270;
        }
        localLinkedList.add(localObject2);
        break label270;
        localObject1 = "";
        break;
        label400:
        i += 1;
      }
      ac.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + fw(localLinkedList));
      af.dHV().jC(paramString1, fw(localLinkedList));
    }
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.asY(com.tencent.mm.plugin.sns.data.q.wW(((SnsObject)paramLinkedList.getLast()).Id));
    ac.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString2 + "  -  " + (String)localObject1);
    if (paramInt == 2)
    {
      localObject2 = af.dHR();
      paramLinkedList = com.tencent.mm.plugin.sns.storage.q.dMN();
      if (paramString2 != null)
      {
        paramString1 = paramLinkedList;
        if (paramString2.equals("")) {}
      }
      else
      {
        paramString1 = paramLinkedList + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).avh(paramString2);
      }
      paramLinkedList = paramString1;
      if (com.tencent.mm.plugin.sns.storage.q.avd((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).ave((String)localObject1);
      }
      ac.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
      paramString1 = ((com.tencent.mm.plugin.sns.storage.q)localObject2).db.rawQuery(paramLinkedList, null);
    }
    while (paramString1 == null)
    {
      AppMethodBeat.o(95871);
      return;
      if (paramInt == 16)
      {
        paramString1 = af.dHR().jD(paramString2, (String)localObject1);
      }
      else
      {
        localObject2 = af.dHR();
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          paramLinkedList = com.tencent.mm.plugin.sns.storage.q.bL(paramString1, bool);
          paramString1 = paramLinkedList;
          if (com.tencent.mm.plugin.sns.storage.q.avd(paramString2)) {
            paramString1 = paramLinkedList + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).avh(paramString2);
          }
          paramLinkedList = paramString1;
          if (com.tencent.mm.plugin.sns.storage.q.avd((String)localObject1)) {
            paramLinkedList = paramString1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).ave((String)localObject1);
          }
          ac.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
          paramString1 = ((com.tencent.mm.plugin.sns.storage.q)localObject2).db.rawQuery(paramLinkedList, null);
          break;
        }
      }
    }
    if (!paramString1.moveToFirst())
    {
      paramString1.close();
      AppMethodBeat.o(95871);
      return;
    }
    for (;;)
    {
      paramLinkedList = new p();
      paramLinkedList.convertFrom(paramString1);
      long l = paramLinkedList.field_snsId;
      if (paramLinkedList.dMv()) {
        ac.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        AppMethodBeat.o(95871);
        return;
        if (paramLinkedList.dMw())
        {
          ac.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!localArrayList.contains(Long.valueOf(l)))
        {
          paramLinkedList.Pf(paramInt);
          af.dHR().b(l, paramLinkedList);
          paramLinkedList = af.dIa();
          ac.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", new Object[] { Long.valueOf(l) });
          af.cMM().post(new as.3(paramLinkedList, l));
          ac.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt);
        }
      }
    }
  }
  
  public static void c(long paramLong, czv paramczv)
  {
    AppMethodBeat.i(95864);
    paramczv = paramczv.FJh;
    if (paramczv.ndI != 13)
    {
      AppMethodBeat.o(95864);
      return;
    }
    p localp = af.dHR().xK(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(95864);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
      localSnsObject.Id = paramLong;
      if (localSnsObject.SnsRedEnvelops == null) {
        localSnsObject.SnsRedEnvelops = new dbb();
      }
      if (paramczv.ndI == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.FKj.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((daj)((Iterator)localObject).next()).Username.equals(paramczv.Fwn);
          if (bool)
          {
            AppMethodBeat.o(95864);
            return;
          }
        }
        localObject = new daj();
        ((daj)localObject).FJc = paramczv.FJc;
        ((daj)localObject).CreateTime = paramczv.CreateTime;
        ((daj)localObject).Username = paramczv.Fwn;
        localSnsObject.SnsRedEnvelops.FKj.add(localObject);
        localSnsObject.SnsRedEnvelops.FKi = localSnsObject.SnsRedEnvelops.FKj.size();
      }
      localp.bB(localSnsObject.toByteArray());
      af.dHR().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95864);
      return;
    }
    catch (Exception paramczv)
    {
      ac.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramczv.getMessage());
      ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramczv, "", new Object[0]);
      AppMethodBeat.o(95864);
    }
  }
  
  public static long d(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95866);
    p localp2 = af.dHR().xK(paramSnsObject.Id);
    p localp1 = localp2;
    if (localp2 == null) {
      localp1 = new p();
    }
    long l = a(localp1, paramSnsObject, "", 0);
    AppMethodBeat.o(95866);
    return l;
  }
  
  public static void dIn()
  {
    AppMethodBeat.i(95860);
    if (xUZ != null) {
      xUZ.clear();
    }
    AppMethodBeat.o(95860);
  }
  
  public static List<p> dIo()
  {
    AppMethodBeat.i(95874);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = af.dHR();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dMO() + " AND " + com.tencent.mm.plugin.sns.storage.q.yvO + " AND  (snsId = 0  ) ";
    localObject1 = ((com.tencent.mm.plugin.sns.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(95874);
      return localArrayList;
    }
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject2 = new p();
      ((p)localObject2).convertFrom((Cursor)localObject1);
      localArrayList.add(localObject2);
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(95874);
    return localArrayList;
  }
  
  public static void dIp()
  {
    AppMethodBeat.i(95883);
    Cursor localCursor = af.dHR().p("", "", 0, 0);
    if (localCursor != null)
    {
      ac.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
      while (localCursor.moveToNext())
      {
        p localp = new p();
        localp.convertFrom(localCursor);
        ac.i("MicroMsg.SnsInfoStorageLogic", localp.getSnsId());
      }
      ac.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
      localCursor.close();
    }
    AppMethodBeat.o(95883);
  }
  
  public static void dIq()
  {
    xRo = 0L;
    xRp = 0L;
  }
  
  private static String fw(List<String> paramList)
  {
    AppMethodBeat.i(95870);
    Iterator localIterator = paramList.iterator();
    paramList = "";
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramList.length() == 0) {
        paramList = str;
      } else {
        paramList = paramList + "," + str;
      }
    }
    AppMethodBeat.o(95870);
    return paramList;
  }
  
  public static List<com.tencent.mm.plugin.sns.i.b> fx(List<String> paramList)
  {
    AppMethodBeat.i(95881);
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      AppMethodBeat.o(95881);
      return localArrayList;
    }
    localArrayList.clear();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
      btz localbtz = new btz();
      localbtz.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localb.dwE = localbtz;
      localb.yav = "";
      localb.yax = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95881);
    return localArrayList;
  }
  
  public static void j(LinkedList<SnsObject> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(95885);
    if (paramInt == at.xWM)
    {
      xRo = ((SnsObject)paramLinkedList.getFirst()).Id;
      xRp = ((SnsObject)paramLinkedList.getLast()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == at.xWN)
    {
      xRo = ((SnsObject)paramLinkedList.getFirst()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == at.xWO) {
      xRp = ((SnsObject)paramLinkedList.getLast()).Id;
    }
    AppMethodBeat.o(95885);
  }
  
  public static List<com.tencent.mm.plugin.sns.i.b> ja(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(95877);
    localArrayList = new ArrayList();
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramString2 + paramString1 + "_ARTISTF.mm";
      Object localObject3 = paramString2 + paramString1 + "_ARTIST.mm";
      paramString1 = (String)localObject1;
      if (i.eA((String)localObject2))
      {
        paramString1 = i.aU((String)localObject2, 0, (int)i.aSp((String)localObject2));
        paramString1 = (dl)new dl().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        i.deleteFile((String)localObject2);
        paramString2 = a.auv(new String(i.aU((String)localObject3, 0, (int)i.aSp((String)localObject3))));
        i.f((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (bii)paramString1.next();
        paramString2 = ((bii)localObject1).Name;
        localObject1 = ((bii)localObject1).Etz.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (btz)((Iterator)localObject1).next();
          ((btz)localObject2).Desc = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.i.b();
          ((com.tencent.mm.plugin.sns.i.b)localObject3).dwE = ((btz)localObject2);
          ((com.tencent.mm.plugin.sns.i.b)localObject3).yav = "";
          ((com.tencent.mm.plugin.sns.i.b)localObject3).yax = j;
          localArrayList.add(localObject3);
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
      AppMethodBeat.o(95877);
    }
  }
  
  public static List<p> jb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95884);
    paramString1 = af.dHR().jD(paramString1, paramString2);
    paramString2 = new ArrayList();
    if (paramString1.getCount() == 0)
    {
      paramString1.close();
      AppMethodBeat.o(95884);
      return paramString2;
    }
    if (paramString1.moveToFirst()) {
      do
      {
        p localp = new p();
        localp.convertFrom(paramString1);
        paramString2.add(localp);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    AppMethodBeat.o(95884);
    return paramString2;
  }
  
  public static SnsObject s(p paramp)
  {
    AppMethodBeat.i(95861);
    try
    {
      paramp = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      paramp = af.dHQ().c(paramp);
      xUZ.clear();
      AppMethodBeat.o(95861);
      return paramp;
    }
    catch (Exception paramp)
    {
      ac.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
      paramp = new SnsObject();
      AppMethodBeat.o(95861);
    }
    return paramp;
  }
  
  public static SnsObject t(p paramp)
  {
    AppMethodBeat.i(95862);
    try
    {
      if (paramp.yvo == null) {
        paramp.yvo = (com.tencent.mm.b.g.getMessageDigest(paramp.field_content) + com.tencent.mm.b.g.getMessageDigest(paramp.field_attrBuf));
      }
      if (xUZ.containsKey(paramp.yvo))
      {
        localSnsObject = (SnsObject)xUZ.get(paramp.yvo);
        if (localSnsObject != null)
        {
          af.dHQ().c(localSnsObject);
          AppMethodBeat.o(95862);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      xUZ.put(paramp.yvo, localSnsObject);
      af.dHQ().c(localSnsObject);
      AppMethodBeat.o(95862);
      return localSnsObject;
    }
    catch (Exception paramp)
    {
      ac.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ac.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
      paramp = new SnsObject();
      AppMethodBeat.o(95862);
    }
    return paramp;
  }
  
  public static List<p> w(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(160673);
    com.tencent.mm.plugin.sns.storage.q localq = af.dHR();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dMR();
    Object localObject1 = localObject2;
    if (com.tencent.mm.plugin.sns.storage.q.avd(paramString)) {
      localObject1 = (String)localObject2 + " AND " + localq.ave(paramString);
    }
    if (paramBoolean) {}
    for (paramString = (String)localObject1 + com.tencent.mm.plugin.sns.storage.q.yvL;; paramString = (String)localObject1 + com.tencent.mm.plugin.sns.storage.q.yvM)
    {
      ac.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString)));
      paramString = localq.db.rawQuery(paramString, null);
      localObject1 = new ArrayList();
      if (paramString.getCount() != 0) {
        break;
      }
      paramString.close();
      AppMethodBeat.o(160673);
      return localObject1;
    }
    if (paramString.moveToFirst()) {
      do
      {
        localObject2 = new p();
        ((p)localObject2).convertFrom(paramString);
        ((List)localObject1).add(localObject2);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(160673);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */