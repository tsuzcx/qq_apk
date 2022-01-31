package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ak
{
  private static Map<String, SnsObject> rhW;
  
  static
  {
    AppMethodBeat.i(36563);
    rhW = new ConcurrentHashMap();
    AppMethodBeat.o(36563);
  }
  
  public static boolean DN(int paramInt)
  {
    AppMethodBeat.i(36551);
    ab.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    n localn = ag.cpf().Ez(paramInt);
    if (localn == null)
    {
      AppMethodBeat.o(36551);
      return false;
    }
    localn.csK();
    localn.lp((int)(System.currentTimeMillis() / 1000L));
    bcv localbcv = null;
    for (;;)
    {
      try
      {
        localObject = (bct)new bct().parseFrom(localn.field_postBuf);
        ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((bct)localObject).ePG = 0;
          ((bct)localObject).xst = System.currentTimeMillis();
          localn.field_postBuf = ((bct)localObject).toByteArray();
          if (localObject != null) {
            break;
          }
          AppMethodBeat.o(36551);
          return false;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Object localObject;
            int i;
            com.tencent.mm.plugin.sns.storage.r localr;
            continue;
            paramInt += 1;
          }
        }
        localException2 = localException2;
        localObject = localbcv;
      }
    }
    ag.cpf().b(paramInt, localn);
    paramInt = 0;
    if (paramInt < ((bct)localObject).xsq.size())
    {
      i = ((bam)((bct)localObject).xsq.get(paramInt)).xpE;
      localr = ag.coU().ma(i);
      if (localr != null)
      {
        localr.offset = 0;
        try
        {
          localbcv = (bcv)new bcv().parseFrom(localr.rDG);
          if (localbcv.nkT == 0) {
            break label277;
          }
          localbcv.nkT = 2;
          localbcv.xsN = "";
          localr.rDG = localbcv.toByteArray();
          ag.coU().a(i, localr);
        }
        catch (Exception localException1)
        {
          ab.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          AppMethodBeat.o(36551);
          return false;
        }
      }
    }
    else
    {
      AppMethodBeat.o(36551);
      return true;
    }
  }
  
  public static n DO(int paramInt)
  {
    AppMethodBeat.i(36555);
    n localn = new n();
    Object localObject1 = ag.cpf();
    Object localObject2 = o.cta();
    localObject2 = (String)localObject2 + " and createTime < " + paramInt;
    localObject2 = (String)localObject2 + o.rDl;
    localObject2 = (String)localObject2 + " LIMIT 1";
    ab.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[] { localObject2 });
    localObject2 = ((o)localObject1).db.rawQuery((String)localObject2, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(36555);
      return null;
    }
    if (((Cursor)localObject1).moveToFirst())
    {
      localn.convertFrom((Cursor)localObject1);
      ((Cursor)localObject1).close();
      AppMethodBeat.o(36555);
      return localn;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(36555);
    return null;
  }
  
  public static void DP(int paramInt)
  {
    AppMethodBeat.i(36561);
    ab.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    n localn = ag.cpf().Ez(paramInt);
    if (localn == null)
    {
      AppMethodBeat.o(36561);
      return;
    }
    if ((localn.field_localFlag & 0x40) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localn.field_localFlag &= 0xFFFFFFBF;
      }
      ag.cpf().b(paramInt, localn);
      AppMethodBeat.o(36561);
      return;
    }
  }
  
  private static long a(n paramn, SnsObject paramSnsObject, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(36547);
    n localn = paramn;
    if (paramn == null) {
      localn = new n();
    }
    long l;
    if (!ag.cpe().lH(localn.field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(36547);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      ab.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + i.lq(paramSnsObject.Id));
      if (localn.Ex(paramInt)) {
        break label794;
      }
      localn.Eu(paramInt);
    }
    label794:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        ag.cpf().a(paramSnsObject.Id, localn);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(36547);
      return l;
      paramn = paramSnsObject.CommentUserList;
      ab.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramn.size()), i.lq(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.getBuffer() == null))
      {
        ab.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(36547);
        return l;
      }
      paramn = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
      ab.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
      if (bo.isNullOrNil(paramn))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(36547);
        return l;
      }
      if (!localn.abt(paramn))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(36547);
        return l;
      }
      paramSnsObject.ObjectOperations = b(paramSnsObject.ObjectOperations, localn.field_attrBuf);
      ab.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(paramSnsObject.Id) });
      paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
      localn.field_userName = paramSnsObject.Username;
      localn.lp(paramSnsObject.CreateTime);
      localn.field_likeFlag = paramSnsObject.LikeFlag;
      localn.lV(paramSnsObject.Id);
      localn.lX(paramSnsObject.Id);
      localn.Eu(paramInt);
      try
      {
        l = bo.yB();
      }
      catch (Exception paramn)
      {
        label541:
        int j;
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramn, "", new Object[0]);
          continue;
          i = 0;
          continue;
          localn.csF();
        }
        if ((j != 1) && ((paramString.equals(paramSnsObject.Username)) || (paramInt != 4))) {
          continue;
        }
        localn.csB();
        localn.c(paramn);
        localn.field_type = paramn.xTS.wNZ;
        localn.field_subType = paramn.xTS.wOb;
        ag.cpf().a(paramSnsObject.Id, localn);
        l = paramSnsObject.Id;
        AppMethodBeat.o(36547);
        return l;
      }
      try
      {
        if (localn.field_type == 15)
        {
          paramn = (SnsObject)new SnsObject().parseFrom(localn.field_attrBuf);
          if ((paramn != null) && (paramn.PreDownloadInfo != null) && (paramn.PreDownloadInfo.xBv > 0))
          {
            paramSnsObject.PreDownloadInfo = paramn.PreDownloadInfo;
            ab.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.xBv), Integer.valueOf(paramSnsObject.PreDownloadInfo.xBw), paramSnsObject.PreDownloadInfo.xBx, Long.valueOf(bo.av(l)) });
          }
        }
      }
      catch (Exception paramn)
      {
        ab.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[] { paramn.toString() });
        break label541;
      }
      localn.bj(paramSnsObject.toByteArray());
      paramn = localn.csh();
      paramn.jJA = paramSnsObject.Username;
      j = paramn.xrU;
      localn.field_pravited = j;
      ab.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsObject.ExtFlag) });
      if ((paramSnsObject.ExtFlag & 0x1) > 0)
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        localn.csE();
        if ((j != 1) || (paramInt == 4)) {
          continue;
        }
        ab.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        AppMethodBeat.o(36547);
        return 0L;
      }
    }
  }
  
  public static bcs a(n paramn, int paramInt)
  {
    AppMethodBeat.i(36557);
    if (ag.coN())
    {
      AppMethodBeat.o(36557);
      return null;
    }
    if (paramn == null)
    {
      AppMethodBeat.o(36557);
      return null;
    }
    paramn = paramn.csh();
    if ((paramn.xTS == null) || (paramn.xTS.wOa.size() == 0) || (paramn.xTS.wOa.size() <= paramInt))
    {
      AppMethodBeat.o(36557);
      return null;
    }
    paramn = (bcs)paramn.xTS.wOa.get(paramInt);
    AppMethodBeat.o(36557);
    return paramn;
  }
  
  public static bcs a(n paramn, String paramString)
  {
    AppMethodBeat.i(36558);
    paramn = paramn.csh();
    if ((paramn.xTS == null) || (paramn.xTS.wOa.size() == 0))
    {
      AppMethodBeat.o(36558);
      return null;
    }
    paramn = paramn.xTS.wOa.iterator();
    while (paramn.hasNext())
    {
      bcs localbcs = (bcs)paramn.next();
      if (localbcs.Id.equals(paramString))
      {
        AppMethodBeat.o(36558);
        return localbcs;
      }
    }
    AppMethodBeat.o(36558);
    return null;
  }
  
  public static List<n> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(36537);
    if (paramBoolean2) {}
    for (paramString1 = ag.cpf().b(paramString1, 10, paramBoolean1, paramString2);; paramString1 = ag.cpf().e(paramString1, paramBoolean1, paramString2))
    {
      paramString2 = new ArrayList();
      if (paramString1.getCount() != 0) {
        break;
      }
      paramString1.close();
      AppMethodBeat.o(36537);
      return paramString2;
    }
    if (paramString1.moveToFirst()) {
      do
      {
        n localn = new n();
        localn.convertFrom(paramString1);
        paramString2.add(localn);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    AppMethodBeat.o(36537);
    return paramString2;
  }
  
  public static boolean a(long paramLong, cdn paramcdn)
  {
    AppMethodBeat.i(36545);
    cdm localcdm = paramcdn.xOe;
    if ((localcdm.jKs != 1) && (localcdm.jKs != 2))
    {
      AppMethodBeat.o(36545);
      return true;
    }
    n localn = ag.cpf().lZ(paramLong);
    if (localn == null)
    {
      AppMethodBeat.o(36545);
      return true;
    }
    if ((localn.field_type == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.cnX()))
    {
      ab.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
      AppMethodBeat.o(36545);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(localn.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localcdm.jKs != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localcds = (cds)localIterator.next();
          if (localcds.CreateTime != localcdm.CreateTime) {
            continue;
          }
          bool = localcds.Username.equals(localcdm.xCG);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(36545);
          return true;
        }
        localSnsObject.LikeUserList.add(ae.b(paramcdn));
        localn.bj(localSnsObject.toByteArray());
        ag.cpf().a(localSnsObject.Id, localn);
      }
      catch (Exception paramcdn)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        cds localcds;
        boolean bool;
        ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramcdn, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(36545);
      return true;
      if (localcdm.jKs == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localcds = (cds)localIterator.next();
          if (localcds.CreateTime == localcdm.CreateTime)
          {
            bool = localcds.Username.equals(localcdm.xCG);
            if (bool)
            {
              AppMethodBeat.o(36545);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ae.b(paramcdn));
        }
      }
    }
  }
  
  public static List<com.tencent.mm.plugin.sns.h.b> aaA(String paramString)
  {
    AppMethodBeat.i(36559);
    ArrayList localArrayList = new ArrayList();
    if (ag.coN())
    {
      AppMethodBeat.o(36559);
      return localArrayList;
    }
    Object localObject = h.abv(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36559);
      return localArrayList;
    }
    localObject = ((n)localObject).csh();
    if ((((TimeLineObject)localObject).xTS == null) || (((TimeLineObject)localObject).xTS.wOa.size() == 0))
    {
      AppMethodBeat.o(36559);
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((TimeLineObject)localObject).xTS.wOa.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      bcs localbcs = (bcs)localIterator.next();
      com.tencent.mm.plugin.sns.h.b localb = new com.tencent.mm.plugin.sns.h.b();
      localb.cIc = localbcs;
      localb.rlJ = paramString;
      localb.fDT = ((TimeLineObject)localObject).CreateTime;
      localb.rlK = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(36559);
    return localArrayList;
  }
  
  public static n aax(String paramString)
  {
    AppMethodBeat.i(36539);
    paramString = ag.cpf().b(paramString, 1, false, "");
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(36539);
      return null;
    }
    paramString.moveToFirst();
    n localn = new n();
    localn.convertFrom(paramString);
    if (!paramString.isClosed()) {
      paramString.close();
    }
    AppMethodBeat.o(36539);
    return localn;
  }
  
  public static boolean aay(String paramString)
  {
    AppMethodBeat.i(36552);
    boolean bool = com.tencent.mm.model.r.Zn().equals(paramString.trim());
    AppMethodBeat.o(36552);
    return bool;
  }
  
  public static String aaz(String paramString)
  {
    AppMethodBeat.i(36554);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ag.cpl().getCursor();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        t localt = new t();
        localt.convertFrom((Cursor)localObject);
        localLinkedList.add(bo.bf(localt.field_tagName, ""));
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    localObject = paramString;
    while (localLinkedList.contains(localObject))
    {
      localObject = paramString + i;
      i += 1;
    }
    AppMethodBeat.o(36554);
    return localObject;
  }
  
  public static boolean ad(int paramInt, boolean paramBoolean)
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
  
  public static SKBuiltinBuffer_t b(SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36548);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((SnsObject)new SnsObject().parseFrom(paramArrayOfByte)).ObjectOperations;
        if (paramSKBuiltinBuffer_t == null)
        {
          AppMethodBeat.o(36548);
          return localSKBuiltinBuffer_t;
        }
        cel localcel = new cel();
        paramArrayOfByte = localcel;
        if (localSKBuiltinBuffer_t != null) {
          paramArrayOfByte = (cel)localcel.parseFrom(localSKBuiltinBuffer_t.getBufferToBytes());
        }
        paramSKBuiltinBuffer_t = (cel)new cel().parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        if (paramSKBuiltinBuffer_t.xOP == null) {
          paramSKBuiltinBuffer_t.xOP = paramArrayOfByte.xOP;
        }
        if (paramArrayOfByte.xOO == null)
        {
          paramSKBuiltinBuffer_t.xOO = null;
          paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.toByteArray();
          paramSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(paramSKBuiltinBuffer_t);
          AppMethodBeat.o(36548);
          return paramSKBuiltinBuffer_t;
        }
        if (paramSKBuiltinBuffer_t.xOO == null)
        {
          paramSKBuiltinBuffer_t.xOO = paramArrayOfByte.xOO;
          continue;
          localSKBuiltinBuffer_t = null;
        }
      }
      catch (Exception paramSKBuiltinBuffer_t)
      {
        ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSKBuiltinBuffer_t, "", new Object[0]);
        AppMethodBeat.o(36548);
        return null;
      }
    }
  }
  
  public static void b(long paramLong, cdn paramcdn)
  {
    AppMethodBeat.i(36543);
    paramcdn = paramcdn.xOe;
    if (paramcdn.jKs != 9)
    {
      AppMethodBeat.o(36543);
      return;
    }
    n localn = ag.cpf().lZ(paramLong);
    if (localn == null)
    {
      AppMethodBeat.o(36543);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localn.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      while (localIterator.hasNext())
      {
        cds localcds = (cds)localIterator.next();
        if ((localcds.xNY == paramcdn.xNY) && (!bo.isNullOrNil(localcds.Username)) && (localcds.Username.equals(paramcdn.xCG))) {
          localSnsObject.CommentUserList.remove(localcds);
        }
      }
      localn.bj(localSnsObject.toByteArray());
      ag.cpf().a(localSnsObject.Id, localn);
      AppMethodBeat.o(36543);
      return;
    }
    catch (Exception paramcdn)
    {
      ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramcdn, "", new Object[0]);
      AppMethodBeat.o(36543);
    }
  }
  
  public static void b(String paramString1, int paramInt, LinkedList<SnsObject> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(36550);
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      AppMethodBeat.o(36550);
      return;
    }
    Object localObject3 = ag.cpf();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    Object localObject2;
    while (i < paramLinkedList.size())
    {
      SnsObject localSnsObject = (SnsObject)paramLinkedList.get(i);
      localObject2 = ((o)localObject3).lZ(localSnsObject.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new n();
      }
      if (a((n)localObject1, localSnsObject, paramString1, paramInt) != 0L)
      {
        if ((localLinkedList.size() < 3) && ((((n)localObject1).field_type == 1) || (((n)localObject1).field_type == 15))) {
          localLinkedList.add(i.lq(((n)localObject1).field_snsId));
        }
        localArrayList.add(Long.valueOf(localSnsObject.Id));
      }
      i += 1;
    }
    if (((paramInt == 4) || (paramInt == 8)) && (paramString2.equals("")))
    {
      localObject1 = ag.cpj().abz(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((l)localObject1).field_newerIds;
        localObject1 = bo.P(bo.bf((String)localObject1, "").split(","));
        ab.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + da(localLinkedList));
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
      ab.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + da(localLinkedList));
      ag.cpj().gF(paramString1, da(localLinkedList));
    }
    Object localObject1 = i.ZI(i.lq(((SnsObject)paramLinkedList.getLast()).Id));
    ab.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString2 + "  -  " + (String)localObject1);
    if (paramInt == 2)
    {
      localObject2 = ag.cpf();
      paramLinkedList = o.csY();
      if (paramString2 != null)
      {
        paramString1 = paramLinkedList;
        if (paramString2.equals("")) {}
      }
      else
      {
        paramString1 = paramLinkedList + " AND " + ((o)localObject2).abH(paramString2);
      }
      paramLinkedList = paramString1;
      if (o.abD((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((o)localObject2).abE((String)localObject1);
      }
      ab.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
      paramString1 = ((o)localObject2).db.rawQuery(paramLinkedList, null);
      if (paramString1 == null) {
        AppMethodBeat.o(36550);
      }
    }
    else
    {
      localObject2 = ag.cpf();
      if (paramInt == 4) {}
      for (boolean bool = true;; bool = false)
      {
        paramLinkedList = o.bt(paramString1, bool);
        paramString1 = paramLinkedList;
        if (o.abD(paramString2)) {
          paramString1 = paramLinkedList + " AND " + ((o)localObject2).abH(paramString2);
        }
        paramLinkedList = paramString1;
        if (o.abD((String)localObject1)) {
          paramLinkedList = paramString1 + " AND " + ((o)localObject2).abE((String)localObject1);
        }
        ab.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
        paramString1 = ((o)localObject2).db.rawQuery(paramLinkedList, null);
        break;
      }
    }
    if (!paramString1.moveToFirst())
    {
      paramString1.close();
      AppMethodBeat.o(36550);
      return;
    }
    for (;;)
    {
      paramLinkedList = new n();
      paramLinkedList.convertFrom(paramString1);
      long l = paramLinkedList.field_snsId;
      if (paramLinkedList.csI()) {
        ab.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        AppMethodBeat.o(36550);
        return;
        if (paramLinkedList.csJ())
        {
          ab.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!localArrayList.contains(Long.valueOf(l)))
        {
          paramLinkedList.Ey(paramInt);
          ag.cpf().b(l, paramLinkedList);
          ab.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt);
        }
      }
    }
  }
  
  public static List<n> c(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(36538);
    o localo = ag.cpf();
    Object localObject = o.bv(paramString1, paramBoolean);
    paramString1 = (String)localObject;
    if (o.abD(paramString2)) {
      paramString1 = (String)localObject + " AND " + localo.abE(paramString2);
    }
    if (paramBoolean) {}
    for (paramString1 = paramString1 + o.rDo;; paramString1 = paramString1 + o.rDp)
    {
      ab.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString1)));
      paramString1 = localo.db.rawQuery(paramString1, null);
      paramString2 = new ArrayList();
      if (paramString1.getCount() != 0) {
        break;
      }
      paramString1.close();
      AppMethodBeat.o(36538);
      return paramString2;
    }
    if (paramString1.moveToFirst()) {
      do
      {
        localObject = new n();
        ((n)localObject).convertFrom(paramString1);
        paramString2.add(localObject);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    AppMethodBeat.o(36538);
    return paramString2;
  }
  
  public static void c(long paramLong, cdn paramcdn)
  {
    AppMethodBeat.i(36544);
    paramcdn = paramcdn.xOe;
    if (paramcdn.jKs != 13)
    {
      AppMethodBeat.o(36544);
      return;
    }
    n localn = ag.cpf().lZ(paramLong);
    if (localn == null)
    {
      AppMethodBeat.o(36544);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localn.field_attrBuf);
      localSnsObject.Id = paramLong;
      if (localSnsObject.SnsRedEnvelops == null) {
        localSnsObject.SnsRedEnvelops = new ces();
      }
      if (paramcdn.jKs == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.xPe.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((cea)((Iterator)localObject).next()).Username.equals(paramcdn.xCG);
          if (bool)
          {
            AppMethodBeat.o(36544);
            return;
          }
        }
        localObject = new cea();
        ((cea)localObject).xOb = paramcdn.xOb;
        ((cea)localObject).CreateTime = paramcdn.CreateTime;
        ((cea)localObject).Username = paramcdn.xCG;
        localSnsObject.SnsRedEnvelops.xPe.add(localObject);
        localSnsObject.SnsRedEnvelops.xPd = localSnsObject.SnsRedEnvelops.xPe.size();
      }
      localn.bj(localSnsObject.toByteArray());
      ag.cpf().a(localSnsObject.Id, localn);
      AppMethodBeat.o(36544);
      return;
    }
    catch (Exception paramcdn)
    {
      ab.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramcdn.getMessage());
      ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramcdn, "", new Object[0]);
      AppMethodBeat.o(36544);
    }
  }
  
  public static void cpw()
  {
    AppMethodBeat.i(36540);
    if (rhW != null) {
      rhW.clear();
    }
    AppMethodBeat.o(36540);
  }
  
  public static List<n> cpx()
  {
    AppMethodBeat.i(36553);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ag.cpf();
    Object localObject2 = o.csZ() + " AND " + o.rDr + " AND  (snsId = 0  ) ";
    localObject1 = ((o)localObject1).db.rawQuery((String)localObject2, null);
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(36553);
      return localArrayList;
    }
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject2 = new n();
      ((n)localObject2).convertFrom((Cursor)localObject1);
      localArrayList.add(localObject2);
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(36553);
    return localArrayList;
  }
  
  public static void cpy()
  {
    AppMethodBeat.i(36562);
    Cursor localCursor = ag.cpf().dr("", 0);
    if (localCursor != null)
    {
      ab.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
      while (localCursor.moveToNext())
      {
        n localn = new n();
        localn.convertFrom(localCursor);
        ab.i("MicroMsg.SnsInfoStorageLogic", localn.getSnsId());
      }
      ab.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
      localCursor.close();
    }
    AppMethodBeat.o(36562);
  }
  
  public static long d(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(36546);
    n localn2 = ag.cpf().lZ(paramSnsObject.Id);
    n localn1 = localn2;
    if (localn2 == null) {
      localn1 = new n();
    }
    long l = a(localn1, paramSnsObject, "", 0);
    AppMethodBeat.o(36546);
    return l;
  }
  
  private static String da(List<String> paramList)
  {
    AppMethodBeat.i(36549);
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
    AppMethodBeat.o(36549);
    return paramList;
  }
  
  public static List<com.tencent.mm.plugin.sns.h.b> db(List<String> paramList)
  {
    AppMethodBeat.i(36560);
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      AppMethodBeat.o(36560);
      return localArrayList;
    }
    localArrayList.clear();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      com.tencent.mm.plugin.sns.h.b localb = new com.tencent.mm.plugin.sns.h.b();
      bcs localbcs = new bcs();
      localbcs.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localb.cIc = localbcs;
      localb.rlJ = "";
      localb.rlK = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(36560);
    return localArrayList;
  }
  
  public static List<com.tencent.mm.plugin.sns.h.b> gk(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(36556);
    localArrayList = new ArrayList();
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramString2 + paramString1 + "_ARTISTF.mm";
      Object localObject3 = paramString2 + paramString1 + "_ARTIST.mm";
      paramString1 = (String)localObject1;
      if (com.tencent.mm.vfs.e.cN((String)localObject2))
      {
        paramString1 = com.tencent.mm.vfs.e.i((String)localObject2, 0, (int)com.tencent.mm.vfs.e.avI((String)localObject2));
        paramString1 = (db)new db().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        com.tencent.mm.vfs.e.deleteFile((String)localObject2);
        paramString2 = a.abc(new String(com.tencent.mm.vfs.e.i((String)localObject3, 0, (int)com.tencent.mm.vfs.e.avI((String)localObject3))));
        com.tencent.mm.vfs.e.b((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (atp)paramString1.next();
        paramString2 = ((atp)localObject1).Name;
        localObject1 = ((atp)localObject1).wOa.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (bcs)((Iterator)localObject1).next();
          ((bcs)localObject2).Desc = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.h.b();
          ((com.tencent.mm.plugin.sns.h.b)localObject3).cIc = ((bcs)localObject2);
          ((com.tencent.mm.plugin.sns.h.b)localObject3).rlJ = "";
          ((com.tencent.mm.plugin.sns.h.b)localObject3).rlK = j;
          localArrayList.add(localObject3);
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
      AppMethodBeat.o(36556);
    }
  }
  
  public static SnsObject p(n paramn)
  {
    AppMethodBeat.i(36541);
    try
    {
      paramn = (SnsObject)new SnsObject().parseFrom(paramn.field_attrBuf);
      paramn = ag.cpe().c(paramn);
      rhW.clear();
      AppMethodBeat.o(36541);
      return paramn;
    }
    catch (Exception paramn)
    {
      ab.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramn, "", new Object[0]);
      paramn = new SnsObject();
      AppMethodBeat.o(36541);
    }
    return paramn;
  }
  
  public static SnsObject q(n paramn)
  {
    AppMethodBeat.i(36542);
    try
    {
      if (paramn.rCU == null) {
        paramn.rCU = (com.tencent.mm.a.g.w(paramn.field_content) + com.tencent.mm.a.g.w(paramn.field_attrBuf));
      }
      if (rhW.containsKey(paramn.rCU))
      {
        localSnsObject = (SnsObject)rhW.get(paramn.rCU);
        if (localSnsObject != null)
        {
          ag.cpe().c(localSnsObject);
          AppMethodBeat.o(36542);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramn.field_attrBuf);
      rhW.put(paramn.rCU, localSnsObject);
      ag.cpe().c(localSnsObject);
      AppMethodBeat.o(36542);
      return localSnsObject;
    }
    catch (Exception paramn)
    {
      ab.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramn, "", new Object[0]);
      paramn = new SnsObject();
      AppMethodBeat.o(36542);
    }
    return paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ak
 * JD-Core Version:    0.7.0.1
 */