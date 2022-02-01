package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public final class ak
{
  public static long zhi;
  public static long zhj;
  public static final Map<Long, p> zkR;
  public static long zkS;
  public static int zkT;
  private static long zkU;
  private static Map<String, SnsObject> zkV;
  
  static
  {
    AppMethodBeat.i(95886);
    zkR = new TreeMap(new Comparator() {});
    zhi = 0L;
    zhj = 0L;
    zkS = 0L;
    zkT = 0;
    zkU = -1L;
    zkV = new ConcurrentHashMap();
    AppMethodBeat.o(95886);
  }
  
  public static List<p> B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(160673);
    com.tencent.mm.plugin.sns.storage.q localq = ag.dUe();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dZg();
    Object localObject1 = localObject2;
    if (com.tencent.mm.plugin.sns.storage.q.aAk(paramString)) {
      localObject1 = (String)localObject2 + " AND " + localq.aAl(paramString);
    }
    if (paramBoolean) {}
    for (paramString = (String)localObject1 + com.tencent.mm.plugin.sns.storage.q.zMY;; paramString = (String)localObject1 + com.tencent.mm.plugin.sns.storage.q.zMZ)
    {
      ad.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString)));
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
  
  public static boolean PW(int paramInt)
  {
    AppMethodBeat.i(95872);
    ad.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    p localp = ag.dUe().QP(paramInt);
    if (localp == null)
    {
      AppMethodBeat.o(95872);
      return false;
    }
    localp.dYN();
    localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    byq localbyq = null;
    for (;;)
    {
      try
      {
        localObject = (byo)new byo().parseFrom(localp.field_postBuf);
        ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((byo)localObject).hfV = 0;
          ((byo)localObject).GTk = System.currentTimeMillis();
          localp.field_postBuf = ((byo)localObject).toByteArray();
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
        localObject = localbyq;
      }
    }
    ag.dUe().b(paramInt, localp);
    paramInt = 0;
    if (paramInt < ((byo)localObject).GTh.size())
    {
      i = ((bvk)((byo)localObject).GTh.get(paramInt)).GPE;
      localt = ag.dTT().Aj(i);
      if (localt != null)
      {
        localt.offset = 0;
        try
        {
          localbyq = (byq)new byq().parseFrom(localt.zNr);
          if (localbyq.GPx == 0) {
            break label278;
          }
          localbyq.GPx = 2;
          localbyq.GTF = "";
          localt.zNr = localbyq.toByteArray();
          ag.dTT().a(i, localt);
        }
        catch (Exception localException1)
        {
          ad.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
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
  
  public static p PX(int paramInt)
  {
    AppMethodBeat.i(95876);
    p localp = new p();
    Object localObject1 = ag.dUe();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dZe();
    localObject2 = (String)localObject2 + " and createTime < " + paramInt;
    localObject2 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.q.zMV;
    localObject2 = (String)localObject2 + " LIMIT 1";
    ad.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[] { localObject2 });
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
  
  public static void PY(int paramInt)
  {
    AppMethodBeat.i(95882);
    ad.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    p localp = ag.dUe().QP(paramInt);
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
      ag.dUe().b(paramInt, localp);
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
    if (!ag.dUd().zM(((p)localObject).field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      ad.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + com.tencent.mm.plugin.sns.data.q.zw(paramSnsObject.Id));
      if (((p)localObject).QM(paramInt)) {
        break label924;
      }
      ((p)localObject).QJ(paramInt);
    }
    label924:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        ag.dUe().a(paramSnsObject.Id, (p)localObject);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
      paramp = paramSnsObject.CommentUserList;
      ad.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramp.size()), com.tencent.mm.plugin.sns.data.q.zw(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.getBuffer() == null))
      {
        ad.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramp = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
      ad.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
      if (bt.isNullOrNil(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      if (!((p)localObject).azY(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsObject.ObjectOperations = b(paramSnsObject.ObjectOperations, ((p)localObject).field_attrBuf);
      ad.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(paramSnsObject.Id) });
      paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
      ((p)localObject).field_userName = paramSnsObject.Username;
      ((p)localObject).setCreateTime(paramSnsObject.CreateTime);
      ((p)localObject).field_likeFlag = paramSnsObject.LikeFlag;
      ((p)localObject).Ae(paramSnsObject.Id);
      ((p)localObject).Ag(paramSnsObject.Id);
      ((p)localObject).QJ(paramInt);
      try
      {
        if (!((p)localObject).QM(32)) {
          c((p)localObject, paramSnsObject);
        }
        l = bt.HI();
      }
      catch (Exception paramp)
      {
        label563:
        int j;
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
          continue;
          i = 0;
          continue;
          ((p)localObject).dYI();
        }
        if ((j != 1) && ((paramString.equals(paramSnsObject.Username)) || (paramInt != 4))) {
          continue;
        }
        ((p)localObject).dYE();
        ((p)localObject).f(paramp);
        ((p)localObject).field_type = paramp.HAT.GaP;
        ((p)localObject).field_subType = paramp.HAT.GaR;
        ag.dUe().a(paramSnsObject.Id, (p)localObject);
        paramp = paramSnsObject.CommentUserList.iterator();
        if (!paramp.hasNext()) {
          continue;
        }
        paramString = ((dfn)paramp.next()).HtM.iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        localObject = a((dft)paramString.next());
        if (bd.frc().ILn.aUK(((EmojiInfo)localObject).field_md5) != null) {
          continue;
        }
        bd.frc().ILn.J((EmojiInfo)localObject);
        com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.giz;
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
          if ((paramp != null) && (paramp.PreDownloadInfo != null) && (paramp.PreDownloadInfo.HeQ > 0))
          {
            paramSnsObject.PreDownloadInfo = paramp.PreDownloadInfo;
            ad.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.HeQ), Integer.valueOf(paramSnsObject.PreDownloadInfo.HeR), paramSnsObject.PreDownloadInfo.HeS, Long.valueOf(bt.aO(l)) });
          }
        }
      }
      catch (Exception paramp)
      {
        ad.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[] { paramp.toString() });
        break label563;
      }
      ((p)localObject).bI(paramSnsObject.toByteArray());
      paramp = ((p)localObject).dYl();
      paramp.nDo = paramSnsObject.Username;
      j = paramp.GSK;
      ((p)localObject).field_pravited = j;
      ad.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsObject.ExtFlag) });
      if ((paramSnsObject.ExtFlag & 0x1) > 0)
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        ((p)localObject).dYH();
        if ((j != 1) || (paramInt == 4) || (paramInt == 16)) {
          continue;
        }
        ad.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        AppMethodBeat.o(95867);
        return 0L;
      }
    }
  }
  
  public static byn a(p paramp, String paramString)
  {
    AppMethodBeat.i(95879);
    paramp = paramp.dYl();
    if ((paramp.HAT == null) || (paramp.HAT.GaQ.size() == 0))
    {
      AppMethodBeat.o(95879);
      return null;
    }
    paramp = paramp.HAT.GaQ.iterator();
    while (paramp.hasNext())
    {
      byn localbyn = (byn)paramp.next();
      if (localbyn.Id.equals(paramString))
      {
        AppMethodBeat.o(95879);
        return localbyn;
      }
    }
    AppMethodBeat.o(95879);
    return null;
  }
  
  public static EmojiInfo a(dft paramdft)
  {
    AppMethodBeat.i(95868);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    if (paramdft == null)
    {
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    if (paramdft.Huf == null)
    {
      localEmojiInfo.field_md5 = paramdft.Md5;
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    try
    {
      agb localagb = new agb();
      localagb.parseFrom(paramdft.Huf.getBufferToBytes());
      com.tencent.mm.plugin.emoji.h.b.a(localagb, localEmojiInfo);
      localEmojiInfo.field_temp = 1;
      localEmojiInfo.field_catalog = EmojiInfo.OeN;
      label86:
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    catch (Exception paramdft)
    {
      break label86;
    }
  }
  
  public static List<p> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(95857);
    if (paramBoolean2) {}
    for (paramString1 = ag.dUe().b(paramString1, 10, paramBoolean1, paramString2);; paramString1 = ag.dUe().g(paramString1, paramBoolean1, paramString2))
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
  
  public static boolean a(long paramLong, dfi paramdfi)
  {
    AppMethodBeat.i(95865);
    dfh localdfh = paramdfi.HtP;
    if ((localdfh.nEf != 1) && (localdfh.nEf != 2))
    {
      AppMethodBeat.o(95865);
      return true;
    }
    p localp = ag.dUe().Ai(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(95865);
      return true;
    }
    if ((localp.field_type == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.dTd()))
    {
      ad.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
      AppMethodBeat.o(95865);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localdfh.nEf != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdfn = (dfn)localIterator.next();
          if (localdfn.CreateTime != localdfh.CreateTime) {
            continue;
          }
          bool = localdfn.Username.equals(localdfh.Hgt);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(95865);
          return true;
        }
        localSnsObject.LikeUserList.add(ae.b(paramdfi));
        localp.bI(localSnsObject.toByteArray());
        ag.dUe().a(localSnsObject.Id, localp);
      }
      catch (Exception paramdfi)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        dfn localdfn;
        boolean bool;
        ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdfi, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95865);
      return true;
      if (localdfh.nEf == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localdfn = (dfn)localIterator.next();
          if (localdfn.CreateTime == localdfh.CreateTime)
          {
            bool = localdfn.Username.equals(localdfh.Hgt);
            if (bool)
            {
              AppMethodBeat.o(95865);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ae.b(paramdfi));
        }
      }
    }
  }
  
  public static boolean aiX(String paramString)
  {
    AppMethodBeat.i(95873);
    boolean bool = com.tencent.mm.model.u.aAm().equals(paramString.trim());
    AppMethodBeat.o(95873);
    return bool;
  }
  
  public static boolean ax(int paramInt, boolean paramBoolean)
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
  
  public static p ayX(String paramString)
  {
    AppMethodBeat.i(95859);
    paramString = ag.dUe().b(paramString, 1, false, "");
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
  
  public static String ayY(String paramString)
  {
    AppMethodBeat.i(95875);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ag.dUk().getCursor();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        v localv = new v();
        localv.convertFrom((Cursor)localObject);
        localLinkedList.add(bt.bI(localv.field_tagName, ""));
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
  
  public static List<com.tencent.mm.plugin.sns.i.b> ayZ(String paramString)
  {
    AppMethodBeat.i(95880);
    ArrayList localArrayList = new ArrayList();
    if (ag.dTN())
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    Object localObject = h.aAa(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localObject = ((p)localObject).dYl();
    if ((((TimeLineObject)localObject).HAT == null) || (((TimeLineObject)localObject).HAT.GaQ.size() == 0))
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((TimeLineObject)localObject).HAT.GaQ.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      byn localbyn = (byn)localIterator.next();
      com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
      localb.dIQ = localbyn;
      localb.parentId = paramString;
      localb.hZE = ((TimeLineObject)localObject).CreateTime;
      localb.zqt = i;
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
        dgh localdgh = new dgh();
        paramArrayOfByte = localdgh;
        if (localSKBuiltinBuffer_t != null) {
          paramArrayOfByte = (dgh)localdgh.parseFrom(localSKBuiltinBuffer_t.getBufferToBytes());
        }
        paramSKBuiltinBuffer_t = (dgh)new dgh().parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        if (paramSKBuiltinBuffer_t.HuB == null) {
          paramSKBuiltinBuffer_t.HuB = paramArrayOfByte.HuB;
        }
        if (paramArrayOfByte.HuA == null)
        {
          paramSKBuiltinBuffer_t.HuA = null;
          paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.toByteArray();
          paramSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(paramSKBuiltinBuffer_t);
          AppMethodBeat.o(95869);
          return paramSKBuiltinBuffer_t;
        }
        if (paramSKBuiltinBuffer_t.HuA == null)
        {
          paramSKBuiltinBuffer_t.HuA = paramArrayOfByte.HuA;
          continue;
          localSKBuiltinBuffer_t = null;
        }
      }
      catch (Exception paramSKBuiltinBuffer_t)
      {
        ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSKBuiltinBuffer_t, "", new Object[0]);
        AppMethodBeat.o(95869);
        return null;
      }
    }
  }
  
  public static byn b(p paramp, int paramInt)
  {
    AppMethodBeat.i(95878);
    if (ag.dTN())
    {
      AppMethodBeat.o(95878);
      return null;
    }
    if (paramp == null)
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = paramp.dYl();
    if ((paramp.HAT == null) || (paramp.HAT.GaQ.size() == 0) || (paramp.HAT.GaQ.size() <= paramInt))
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = (byn)paramp.HAT.GaQ.get(paramInt);
    AppMethodBeat.o(95878);
    return paramp;
  }
  
  public static void b(long paramLong, dfi paramdfi)
  {
    AppMethodBeat.i(95863);
    paramdfi = paramdfi.HtP;
    if (paramdfi.nEf != 9)
    {
      AppMethodBeat.o(95863);
      return;
    }
    p localp = ag.dUe().Ai(paramLong);
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
        dfn localdfn = (dfn)localIterator.next();
        if ((localdfn.HtH == paramdfi.HtH) && (!bt.isNullOrNil(localdfn.Username)) && (localdfn.Username.equals(paramdfi.Hgt))) {
          localSnsObject.CommentUserList.remove(localdfn);
        }
      }
      localp.bI(localSnsObject.toByteArray());
      ag.dUe().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95863);
      return;
    }
    catch (Exception paramdfi)
    {
      ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdfi, "", new Object[0]);
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
    Object localObject3 = ag.dUe();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    Object localObject2;
    while (i < paramLinkedList.size())
    {
      SnsObject localSnsObject = (SnsObject)paramLinkedList.get(i);
      localObject2 = ((com.tencent.mm.plugin.sns.storage.q)localObject3).Ai(localSnsObject.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new p();
      }
      if (a((p)localObject1, localSnsObject, paramString1, paramInt) != 0L)
      {
        if ((localLinkedList.size() < 3) && ((((p)localObject1).field_type == 1) || (((p)localObject1).field_type == 15))) {
          localLinkedList.add(com.tencent.mm.plugin.sns.data.q.zw(((p)localObject1).field_snsId));
        }
        localArrayList.add(Long.valueOf(localSnsObject.Id));
      }
      i += 1;
    }
    if (((paramInt == 4) || (paramInt == 8)) && (paramString2.equals("")))
    {
      localObject1 = ag.dUi().aAf(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((n)localObject1).field_newerIds;
        localObject1 = bt.U(bt.bI((String)localObject1, "").split(","));
        ad.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + fJ(localLinkedList));
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
      ad.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + fJ(localLinkedList));
      ag.dUi().jP(paramString1, fJ(localLinkedList));
    }
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.ayd(com.tencent.mm.plugin.sns.data.q.zw(((SnsObject)paramLinkedList.getLast()).Id));
    ad.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString2 + "  -  " + (String)localObject1);
    if (paramInt == 2)
    {
      localObject2 = ag.dUe();
      paramLinkedList = com.tencent.mm.plugin.sns.storage.q.dZc();
      if (paramString2 != null)
      {
        paramString1 = paramLinkedList;
        if (paramString2.equals("")) {}
      }
      else
      {
        paramString1 = paramLinkedList + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).aAo(paramString2);
      }
      paramLinkedList = paramString1;
      if (com.tencent.mm.plugin.sns.storage.q.aAk((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).aAl((String)localObject1);
      }
      ad.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
      paramString1 = ((com.tencent.mm.plugin.sns.storage.q)localObject2).db.rawQuery(paramLinkedList, null);
    }
    while (paramString1 == null)
    {
      AppMethodBeat.o(95871);
      return;
      if (paramInt == 16)
      {
        paramString1 = ag.dUe().jQ(paramString2, (String)localObject1);
      }
      else
      {
        localObject2 = ag.dUe();
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          paramLinkedList = com.tencent.mm.plugin.sns.storage.q.bS(paramString1, bool);
          paramString1 = paramLinkedList;
          if (com.tencent.mm.plugin.sns.storage.q.aAk(paramString2)) {
            paramString1 = paramLinkedList + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).aAo(paramString2);
          }
          paramLinkedList = paramString1;
          if (com.tencent.mm.plugin.sns.storage.q.aAk((String)localObject1)) {
            paramLinkedList = paramString1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).aAl((String)localObject1);
          }
          ad.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
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
      if (paramLinkedList.dYL()) {
        ad.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        AppMethodBeat.o(95871);
        return;
        if (paramLinkedList.dYM())
        {
          ad.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!localArrayList.contains(Long.valueOf(l)))
        {
          paramLinkedList.QN(paramInt);
          ag.dUe().b(l, paramLinkedList);
          paramLinkedList = ag.dUn();
          ad.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", new Object[] { Long.valueOf(l) });
          ag.cVf().post(new at.3(paramLinkedList, l));
          ad.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt);
        }
      }
    }
  }
  
  public static void c(long paramLong, dfi paramdfi)
  {
    AppMethodBeat.i(197851);
    ad.i("MicroMsg.SnsInfoStorageLogic", "deleteComment");
    paramdfi = paramdfi.HtP;
    if (paramdfi.nEf != 9)
    {
      AppMethodBeat.o(197851);
      return;
    }
    p localp = ag.dUe().Ai(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(197851);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      dfn localdfn;
      while (localIterator.hasNext())
      {
        localdfn = (dfn)localIterator.next();
        if ((localdfn.HtH == paramdfi.HtH) && (!bt.isNullOrNil(localdfn.Username)))
        {
          if ((!localdfn.Username.equals(paramdfi.Hgt)) && (localdfn.Username.equals(com.tencent.mm.model.u.aAm()))) {
            break label241;
          }
          ad.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, removeComment:%s", new Object[] { localdfn.Username, paramdfi.Hgt, Integer.valueOf(localdfn.HtH) });
          localSnsObject.CommentUserList.remove(localdfn);
        }
      }
      for (;;)
      {
        localp.bI(localSnsObject.toByteArray());
        ag.dUe().a(localSnsObject.Id, localp);
        AppMethodBeat.o(197851);
        return;
        label241:
        if (localdfn.Username.equals(com.tencent.mm.model.u.aAm()))
        {
          ad.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, markDeleteFlag:%s", new Object[] { localdfn.Username, paramdfi.Hgt, Integer.valueOf(localdfn.HtH) });
          localdfn.DeleteFlag = 1;
        }
      }
      return;
    }
    catch (Exception paramdfi)
    {
      ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdfi, "", new Object[0]);
      AppMethodBeat.o(197851);
    }
  }
  
  public static void c(p paramp, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(197852);
    String str;
    long l;
    Object localObject2;
    Object localObject1;
    if (paramp != null)
    {
      try
      {
        if (paramp.field_attrBuf == null) {
          break label391;
        }
        if (zkU == -1L) {
          zkU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBr, 86400);
        }
        str = com.tencent.mm.model.u.aAm();
        l = cf.aCN();
        localObject2 = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
        if ((localObject2 == null) || (bt.hj(((SnsObject)localObject2).CommentUserList)) || (paramSnsObject == null)) {
          break label391;
        }
        paramp = new ArrayList();
        localObject1 = paramSnsObject.CommentUserList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramp.add(Integer.valueOf(((dfn)((Iterator)localObject1).next()).HtH));
        }
        localObject1 = new ArrayList();
      }
      catch (Exception paramp)
      {
        ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
        AppMethodBeat.o(197852);
        return;
      }
      localObject2 = ((SnsObject)localObject2).CommentUserList.iterator();
    }
    label391:
    label398:
    label401:
    for (;;)
    {
      dfn localdfn1;
      if (((Iterator)localObject2).hasNext())
      {
        localdfn1 = (dfn)((Iterator)localObject2).next();
        if (!bt.lQ(localdfn1.Username, str)) {
          continue;
        }
        if (localdfn1.DeleteFlag != 0) {
          break label398;
        }
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        dfn localdfn2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localdfn2 = (dfn)localIterator.next();
        } while (localdfn1.HtH != localdfn2.HtH);
      }
      for (int i = 0;; i = 1)
      {
        if ((i == 0) || (paramp.contains(Integer.valueOf(localdfn1.HtH))) || (l - localdfn1.CreateTime >= zkU)) {
          break label401;
        }
        ad.i("MicroMsg.SnsInfoStorageLogic", "mergeDeletedComment need insert oriCommentInfo:[%s,%s]", new Object[] { Integer.valueOf(localdfn1.HtH), localdfn1.Username });
        localdfn1.DeleteFlag = 1;
        ((List)localObject1).add(localdfn1);
        break;
        paramSnsObject.CommentUserList.addAll((Collection)localObject1);
        Collections.sort(paramSnsObject.CommentUserList, new Comparator() {});
        AppMethodBeat.o(197852);
        return;
      }
    }
  }
  
  public static long d(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95866);
    p localp2 = ag.dUe().Ai(paramSnsObject.Id);
    p localp1 = localp2;
    if (localp2 == null) {
      localp1 = new p();
    }
    long l = a(localp1, paramSnsObject, "", 0);
    AppMethodBeat.o(95866);
    return l;
  }
  
  public static void d(long paramLong, dfi paramdfi)
  {
    AppMethodBeat.i(95864);
    paramdfi = paramdfi.HtP;
    if (paramdfi.nEf != 13)
    {
      AppMethodBeat.o(95864);
      return;
    }
    p localp = ag.dUe().Ai(paramLong);
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
        localSnsObject.SnsRedEnvelops = new dgo();
      }
      if (paramdfi.nEf == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.HuR.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((dfw)((Iterator)localObject).next()).Username.equals(paramdfi.Hgt);
          if (bool)
          {
            AppMethodBeat.o(95864);
            return;
          }
        }
        localObject = new dfw();
        ((dfw)localObject).HtK = paramdfi.HtK;
        ((dfw)localObject).CreateTime = paramdfi.CreateTime;
        ((dfw)localObject).Username = paramdfi.Hgt;
        localSnsObject.SnsRedEnvelops.HuR.add(localObject);
        localSnsObject.SnsRedEnvelops.HuQ = localSnsObject.SnsRedEnvelops.HuR.size();
      }
      localp.bI(localSnsObject.toByteArray());
      ag.dUe().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95864);
      return;
    }
    catch (Exception paramdfi)
    {
      ad.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramdfi.getMessage());
      ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdfi, "", new Object[0]);
      AppMethodBeat.o(95864);
    }
  }
  
  public static void dUA()
  {
    AppMethodBeat.i(95860);
    if (zkV != null) {
      zkV.clear();
    }
    AppMethodBeat.o(95860);
  }
  
  public static List<p> dUB()
  {
    AppMethodBeat.i(95874);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ag.dUe();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dZd() + " AND " + com.tencent.mm.plugin.sns.storage.q.zNb + " AND  (snsId = 0  ) ";
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
  
  public static void dUC()
  {
    AppMethodBeat.i(95883);
    Cursor localCursor = ag.dUe().p("", "", 0, 0);
    if (localCursor != null)
    {
      ad.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
      while (localCursor.moveToNext())
      {
        p localp = new p();
        localp.convertFrom(localCursor);
        ad.i("MicroMsg.SnsInfoStorageLogic", localp.getSnsId());
      }
      ad.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
      localCursor.close();
    }
    AppMethodBeat.o(95883);
  }
  
  public static void dUD()
  {
    zhi = 0L;
    zhj = 0L;
  }
  
  private static String fJ(List<String> paramList)
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
  
  public static List<com.tencent.mm.plugin.sns.i.b> fK(List<String> paramList)
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
      byn localbyn = new byn();
      localbyn.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localb.dIQ = localbyn;
      localb.parentId = "";
      localb.zqt = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95881);
    return localArrayList;
  }
  
  public static void j(LinkedList<SnsObject> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(95885);
    if (paramInt == au.zmL)
    {
      zhi = ((SnsObject)paramLinkedList.getFirst()).Id;
      zhj = ((SnsObject)paramLinkedList.getLast()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == au.zmM)
    {
      zhi = ((SnsObject)paramLinkedList.getFirst()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == au.zmN) {
      zhj = ((SnsObject)paramLinkedList.getLast()).Id;
    }
    AppMethodBeat.o(95885);
  }
  
  public static List<com.tencent.mm.plugin.sns.i.b> jm(String paramString1, String paramString2)
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
      if (i.fv((String)localObject2))
      {
        paramString1 = i.aY((String)localObject2, 0, (int)i.aYo((String)localObject2));
        paramString1 = (dm)new dm().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        i.deleteFile((String)localObject2);
        paramString2 = a.azB(new String(i.aY((String)localObject3, 0, (int)i.aYo((String)localObject3))));
        i.f((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (bmq)paramString1.next();
        paramString2 = ((bmq)localObject1).Name;
        localObject1 = ((bmq)localObject1).GaQ.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (byn)((Iterator)localObject1).next();
          ((byn)localObject2).Desc = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.i.b();
          ((com.tencent.mm.plugin.sns.i.b)localObject3).dIQ = ((byn)localObject2);
          ((com.tencent.mm.plugin.sns.i.b)localObject3).parentId = "";
          ((com.tencent.mm.plugin.sns.i.b)localObject3).zqt = j;
          localArrayList.add(localObject3);
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
      AppMethodBeat.o(95877);
    }
  }
  
  public static List<p> jn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95884);
    paramString1 = ag.dUe().jQ(paramString1, paramString2);
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
  
  public static SnsObject u(p paramp)
  {
    AppMethodBeat.i(95861);
    try
    {
      paramp = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      paramp = ag.dUd().c(paramp);
      zkV.clear();
      AppMethodBeat.o(95861);
      return paramp;
    }
    catch (Exception paramp)
    {
      ad.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
      paramp = new SnsObject();
      AppMethodBeat.o(95861);
    }
    return paramp;
  }
  
  public static SnsObject v(p paramp)
  {
    AppMethodBeat.i(95862);
    try
    {
      if (paramp.zMB == null) {
        paramp.zMB = (com.tencent.mm.b.g.getMessageDigest(paramp.field_content) + com.tencent.mm.b.g.getMessageDigest(paramp.field_attrBuf));
      }
      if (zkV.containsKey(paramp.zMB))
      {
        localSnsObject = (SnsObject)zkV.get(paramp.zMB);
        if (localSnsObject != null)
        {
          ag.dUd().c(localSnsObject);
          AppMethodBeat.o(95862);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      zkV.put(paramp.zMB, localSnsObject);
      ag.dUd().c(localSnsObject);
      AppMethodBeat.o(95862);
      return localSnsObject;
    }
    catch (Exception paramp)
    {
      ad.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
      paramp = new SnsObject();
      AppMethodBeat.o(95862);
    }
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ak
 * JD-Core Version:    0.7.0.1
 */