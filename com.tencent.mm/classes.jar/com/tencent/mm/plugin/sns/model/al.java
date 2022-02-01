package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
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

public final class al
{
  public static final Map<Long, p> zCg;
  public static long zCh;
  public static int zCi;
  private static long zCj;
  private static Map<String, SnsObject> zCk;
  public static long zxX;
  public static long zxY;
  
  static
  {
    AppMethodBeat.i(95886);
    zCg = new TreeMap(new al.1());
    zxX = 0L;
    zxY = 0L;
    zCh = 0L;
    zCi = 0;
    zCj = -1L;
    zCk = new ConcurrentHashMap();
    AppMethodBeat.o(95886);
  }
  
  public static List<p> D(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(160673);
    q localq = ah.dXE();
    Object localObject2 = q.ecL();
    Object localObject1 = localObject2;
    if (q.aBB(paramString)) {
      localObject1 = (String)localObject2 + " AND " + localq.aBC(paramString);
    }
    if (paramBoolean) {}
    for (paramString = (String)localObject1 + q.Aef;; paramString = (String)localObject1 + q.Aeg)
    {
      ae.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString)));
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
  
  public static boolean QD(int paramInt)
  {
    AppMethodBeat.i(95872);
    ae.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    p localp = ah.dXE().Rw(paramInt);
    if (localp == null)
    {
      AppMethodBeat.o(95872);
      return false;
    }
    localp.ecr();
    localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    bzk localbzk = null;
    for (;;)
    {
      try
      {
        localObject = (bzi)new bzi().parseFrom(localp.field_postBuf);
        ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((bzi)localObject).hiJ = 0;
          ((bzi)localObject).HmL = System.currentTimeMillis();
          localp.field_postBuf = ((bzi)localObject).toByteArray();
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
        localObject = localbzk;
      }
    }
    ah.dXE().b(paramInt, localp);
    paramInt = 0;
    if (paramInt < ((bzi)localObject).HmI.size())
    {
      i = ((bwe)((bzi)localObject).HmI.get(paramInt)).Hjg;
      localt = ah.dXt().AH(i);
      if (localt != null)
      {
        localt.offset = 0;
        try
        {
          localbzk = (bzk)new bzk().parseFrom(localt.Aey);
          if (localbzk.HiZ == 0) {
            break label278;
          }
          localbzk.HiZ = 2;
          localbzk.Hng = "";
          localt.Aey = localbzk.toByteArray();
          ah.dXt().a(i, localt);
        }
        catch (Exception localException1)
        {
          ae.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
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
  
  public static p QE(int paramInt)
  {
    AppMethodBeat.i(95876);
    p localp = new p();
    Object localObject1 = ah.dXE();
    Object localObject2 = q.ecJ();
    localObject2 = (String)localObject2 + " and createTime < " + paramInt;
    localObject2 = (String)localObject2 + q.Aec;
    localObject2 = (String)localObject2 + " LIMIT 1";
    ae.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[] { localObject2 });
    localObject2 = ((q)localObject1).db.rawQuery((String)localObject2, null);
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
  
  public static void QF(int paramInt)
  {
    AppMethodBeat.i(95882);
    ae.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    p localp = ah.dXE().Rw(paramInt);
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
      ah.dXE().b(paramInt, localp);
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
    if (!ah.dXD().Ak(((p)localObject).field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      ae.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + r.zV(paramSnsObject.Id));
      if (((p)localObject).Rt(paramInt)) {
        break label924;
      }
      ((p)localObject).Rq(paramInt);
    }
    label924:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        ah.dXE().a(paramSnsObject.Id, (p)localObject);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
      paramp = paramSnsObject.CommentUserList;
      ae.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramp.size()), r.zV(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.getBuffer() == null))
      {
        ae.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramp = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
      ae.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
      if (bu.isNullOrNil(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      if (!((p)localObject).aBp(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsObject.ObjectOperations = b(paramSnsObject.ObjectOperations, ((p)localObject).field_attrBuf);
      ae.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(paramSnsObject.Id) });
      paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
      ((p)localObject).field_userName = paramSnsObject.Username;
      ((p)localObject).setCreateTime(paramSnsObject.CreateTime);
      ((p)localObject).field_likeFlag = paramSnsObject.LikeFlag;
      ((p)localObject).AC(paramSnsObject.Id);
      ((p)localObject).AE(paramSnsObject.Id);
      ((p)localObject).Rq(paramInt);
      try
      {
        if (!((p)localObject).Rt(32)) {
          c((p)localObject, paramSnsObject);
        }
        l = bu.HQ();
      }
      catch (Exception paramp)
      {
        label563:
        int j;
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
          continue;
          i = 0;
          continue;
          ((p)localObject).ecm();
        }
        if ((j != 1) && ((paramString.equals(paramSnsObject.Username)) || (paramInt != 4))) {
          continue;
        }
        ((p)localObject).eci();
        ((p)localObject).f(paramp);
        ((p)localObject).field_type = paramp.HUG.Gtw;
        ((p)localObject).field_subType = paramp.HUG.Gty;
        ah.dXE().a(paramSnsObject.Id, (p)localObject);
        paramp = paramSnsObject.CommentUserList.iterator();
        if (!paramp.hasNext()) {
          continue;
        }
        paramString = ((dgh)paramp.next()).HNp.iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        localObject = a((dgn)paramString.next());
        if (be.fvc().JfU.aWl(((EmojiInfo)localObject).field_md5) != null) {
          continue;
        }
        be.fvc().JfU.J((EmojiInfo)localObject);
        com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.gkR;
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
          if ((paramp != null) && (paramp.PreDownloadInfo != null) && (paramp.PreDownloadInfo.Hyq > 0))
          {
            paramSnsObject.PreDownloadInfo = paramp.PreDownloadInfo;
            ae.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.Hyq), Integer.valueOf(paramSnsObject.PreDownloadInfo.Hyr), paramSnsObject.PreDownloadInfo.Hys, Long.valueOf(bu.aO(l)) });
          }
        }
      }
      catch (Exception paramp)
      {
        ae.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[] { paramp.toString() });
        break label563;
      }
      ((p)localObject).bL(paramSnsObject.toByteArray());
      paramp = ((p)localObject).ebP();
      paramp.nIJ = paramSnsObject.Username;
      j = paramp.Hml;
      ((p)localObject).field_pravited = j;
      ae.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsObject.ExtFlag) });
      if ((paramSnsObject.ExtFlag & 0x1) > 0)
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        ((p)localObject).ecl();
        if ((j != 1) || (paramInt == 4) || (paramInt == 16)) {
          continue;
        }
        ae.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        AppMethodBeat.o(95867);
        return 0L;
      }
    }
  }
  
  public static bzh a(p paramp, String paramString)
  {
    AppMethodBeat.i(95879);
    paramp = paramp.ebP();
    if ((paramp.HUG == null) || (paramp.HUG.Gtx.size() == 0))
    {
      AppMethodBeat.o(95879);
      return null;
    }
    paramp = paramp.HUG.Gtx.iterator();
    while (paramp.hasNext())
    {
      bzh localbzh = (bzh)paramp.next();
      if (localbzh.Id.equals(paramString))
      {
        AppMethodBeat.o(95879);
        return localbzh;
      }
    }
    AppMethodBeat.o(95879);
    return null;
  }
  
  public static EmojiInfo a(dgn paramdgn)
  {
    AppMethodBeat.i(95868);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    if (paramdgn == null)
    {
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    if (paramdgn.HNI == null)
    {
      localEmojiInfo.field_md5 = paramdgn.Md5;
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    try
    {
      agk localagk = new agk();
      localagk.parseFrom(paramdgn.HNI.getBufferToBytes());
      com.tencent.mm.plugin.emoji.h.b.a(localagk, localEmojiInfo);
      localEmojiInfo.field_temp = 1;
      localEmojiInfo.field_catalog = EmojiInfo.OzU;
      label86:
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    catch (Exception paramdgn)
    {
      break label86;
    }
  }
  
  public static List<p> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(95857);
    if (paramBoolean2) {}
    for (paramString1 = ah.dXE().b(paramString1, 10, paramBoolean1, paramString2);; paramString1 = ah.dXE().g(paramString1, paramBoolean1, paramString2))
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
  
  public static boolean a(long paramLong, dgc paramdgc)
  {
    AppMethodBeat.i(95865);
    dgb localdgb = paramdgc.HNs;
    if ((localdgb.nJA != 1) && (localdgb.nJA != 2))
    {
      AppMethodBeat.o(95865);
      return true;
    }
    p localp = ah.dXE().AG(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(95865);
      return true;
    }
    if ((localp.field_type == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.dWD()))
    {
      ae.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
      AppMethodBeat.o(95865);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localdgb.nJA != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdgh = (dgh)localIterator.next();
          if (localdgh.CreateTime != localdgb.CreateTime) {
            continue;
          }
          bool = localdgh.Username.equals(localdgb.HzT);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(95865);
          return true;
        }
        localSnsObject.LikeUserList.add(af.b(paramdgc));
        localp.bL(localSnsObject.toByteArray());
        ah.dXE().a(localSnsObject.Id, localp);
      }
      catch (Exception paramdgc)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        dgh localdgh;
        boolean bool;
        ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdgc, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95865);
      return true;
      if (localdgb.nJA == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localdgh = (dgh)localIterator.next();
          if (localdgh.CreateTime == localdgb.CreateTime)
          {
            bool = localdgh.Username.equals(localdgb.HzT);
            if (bool)
            {
              AppMethodBeat.o(95865);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(af.b(paramdgc));
        }
      }
    }
  }
  
  public static boolean aA(int paramInt, boolean paramBoolean)
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
  
  public static p aAo(String paramString)
  {
    AppMethodBeat.i(95859);
    paramString = ah.dXE().b(paramString, 1, false, "");
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
  
  public static String aAp(String paramString)
  {
    AppMethodBeat.i(95875);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ah.dXK().getCursor();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        com.tencent.mm.plugin.sns.storage.v localv = new com.tencent.mm.plugin.sns.storage.v();
        localv.convertFrom((Cursor)localObject);
        localLinkedList.add(bu.bI(localv.field_tagName, ""));
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
  
  public static List<com.tencent.mm.plugin.sns.i.b> aAq(String paramString)
  {
    AppMethodBeat.i(95880);
    ArrayList localArrayList = new ArrayList();
    if (ah.dXn())
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    Object localObject = h.aBr(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localObject = ((p)localObject).ebP();
    if ((((TimeLineObject)localObject).HUG == null) || (((TimeLineObject)localObject).HUG.Gtx.size() == 0))
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((TimeLineObject)localObject).HUG.Gtx.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      bzh localbzh = (bzh)localIterator.next();
      com.tencent.mm.plugin.sns.i.b localb = new com.tencent.mm.plugin.sns.i.b();
      localb.dKe = localbzh;
      localb.parentId = paramString;
      localb.icw = ((TimeLineObject)localObject).CreateTime;
      localb.zHI = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95880);
    return localArrayList;
  }
  
  public static boolean ajU(String paramString)
  {
    AppMethodBeat.i(95873);
    boolean bool = com.tencent.mm.model.v.aAC().equals(paramString.trim());
    AppMethodBeat.o(95873);
    return bool;
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
        dhb localdhb = new dhb();
        paramArrayOfByte = localdhb;
        if (localSKBuiltinBuffer_t != null) {
          paramArrayOfByte = (dhb)localdhb.parseFrom(localSKBuiltinBuffer_t.getBufferToBytes());
        }
        paramSKBuiltinBuffer_t = (dhb)new dhb().parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        if (paramSKBuiltinBuffer_t.HOe == null) {
          paramSKBuiltinBuffer_t.HOe = paramArrayOfByte.HOe;
        }
        if (paramArrayOfByte.HOd == null)
        {
          paramSKBuiltinBuffer_t.HOd = null;
          paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.toByteArray();
          paramSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(paramSKBuiltinBuffer_t);
          AppMethodBeat.o(95869);
          return paramSKBuiltinBuffer_t;
        }
        if (paramSKBuiltinBuffer_t.HOd == null)
        {
          paramSKBuiltinBuffer_t.HOd = paramArrayOfByte.HOd;
          continue;
          localSKBuiltinBuffer_t = null;
        }
      }
      catch (Exception paramSKBuiltinBuffer_t)
      {
        ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSKBuiltinBuffer_t, "", new Object[0]);
        AppMethodBeat.o(95869);
        return null;
      }
    }
  }
  
  public static bzh b(p paramp, int paramInt)
  {
    AppMethodBeat.i(95878);
    if (ah.dXn())
    {
      AppMethodBeat.o(95878);
      return null;
    }
    if (paramp == null)
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = paramp.ebP();
    if ((paramp.HUG == null) || (paramp.HUG.Gtx.size() == 0) || (paramp.HUG.Gtx.size() <= paramInt))
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = (bzh)paramp.HUG.Gtx.get(paramInt);
    AppMethodBeat.o(95878);
    return paramp;
  }
  
  public static void b(long paramLong, dgc paramdgc)
  {
    AppMethodBeat.i(95863);
    paramdgc = paramdgc.HNs;
    if (paramdgc.nJA != 9)
    {
      AppMethodBeat.o(95863);
      return;
    }
    p localp = ah.dXE().AG(paramLong);
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
        dgh localdgh = (dgh)localIterator.next();
        if ((localdgh.HNk == paramdgc.HNk) && (!bu.isNullOrNil(localdgh.Username)) && (localdgh.Username.equals(paramdgc.HzT))) {
          localSnsObject.CommentUserList.remove(localdgh);
        }
      }
      localp.bL(localSnsObject.toByteArray());
      ah.dXE().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95863);
      return;
    }
    catch (Exception paramdgc)
    {
      ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdgc, "", new Object[0]);
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
    Object localObject3 = ah.dXE();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    Object localObject2;
    while (i < paramLinkedList.size())
    {
      SnsObject localSnsObject = (SnsObject)paramLinkedList.get(i);
      localObject2 = ((q)localObject3).AG(localSnsObject.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new p();
      }
      if (a((p)localObject1, localSnsObject, paramString1, paramInt) != 0L)
      {
        if ((localLinkedList.size() < 3) && ((((p)localObject1).field_type == 1) || (((p)localObject1).field_type == 15))) {
          localLinkedList.add(r.zV(((p)localObject1).field_snsId));
        }
        localArrayList.add(Long.valueOf(localSnsObject.Id));
      }
      i += 1;
    }
    if (((paramInt == 4) || (paramInt == 8)) && (paramString2.equals("")))
    {
      localObject1 = ah.dXI().aBw(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((n)localObject1).field_newerIds;
        localObject1 = bu.U(bu.bI((String)localObject1, "").split(","));
        ae.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + fS(localLinkedList));
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
      ae.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + fS(localLinkedList));
      ah.dXI().jW(paramString1, fS(localLinkedList));
    }
    Object localObject1 = r.azu(r.zV(((SnsObject)paramLinkedList.getLast()).Id));
    ae.i("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString2 + "  -  " + (String)localObject1);
    if (paramInt == 2)
    {
      localObject2 = ah.dXE();
      paramLinkedList = q.ecH();
      if (paramString2 != null)
      {
        paramString1 = paramLinkedList;
        if (paramString2.equals("")) {}
      }
      else
      {
        paramString1 = paramLinkedList + " AND " + ((q)localObject2).aBF(paramString2);
      }
      paramLinkedList = paramString1;
      if (q.aBB((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((q)localObject2).aBC((String)localObject1);
      }
      ae.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
      paramString1 = ((q)localObject2).db.rawQuery(paramLinkedList, null);
    }
    while (paramString1 == null)
    {
      AppMethodBeat.o(95871);
      return;
      if (paramInt == 16)
      {
        paramString1 = ah.dXE().jX(paramString2, (String)localObject1);
      }
      else
      {
        localObject2 = ah.dXE();
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          paramLinkedList = q.bW(paramString1, bool);
          paramString1 = paramLinkedList;
          if (q.aBB(paramString2)) {
            paramString1 = paramLinkedList + " AND " + ((q)localObject2).aBF(paramString2);
          }
          paramLinkedList = paramString1;
          if (q.aBB((String)localObject1)) {
            paramLinkedList = paramString1 + " AND " + ((q)localObject2).aBC((String)localObject1);
          }
          ae.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
          paramString1 = ((q)localObject2).db.rawQuery(paramLinkedList, null);
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
      if (paramLinkedList.ecp()) {
        ae.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        AppMethodBeat.o(95871);
        return;
        if (paramLinkedList.ecq())
        {
          ae.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!localArrayList.contains(Long.valueOf(l)))
        {
          paramLinkedList.Ru(paramInt);
          ah.dXE().b(l, paramLinkedList);
          paramLinkedList = ah.dXN();
          ae.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", new Object[] { Long.valueOf(l) });
          ah.cXK().post(new au.3(paramLinkedList, l));
          ae.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt + ", snsIdStr=" + r.zV(l));
        }
      }
    }
  }
  
  public static void c(long paramLong, dgc paramdgc)
  {
    AppMethodBeat.i(219344);
    ae.i("MicroMsg.SnsInfoStorageLogic", "deleteComment");
    paramdgc = paramdgc.HNs;
    if (paramdgc.nJA != 9)
    {
      AppMethodBeat.o(219344);
      return;
    }
    p localp = ah.dXE().AG(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(219344);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      dgh localdgh;
      while (localIterator.hasNext())
      {
        localdgh = (dgh)localIterator.next();
        if ((localdgh.HNk == paramdgc.HNk) && (!bu.isNullOrNil(localdgh.Username)))
        {
          if ((!localdgh.Username.equals(paramdgc.HzT)) && (localdgh.Username.equals(com.tencent.mm.model.v.aAC()))) {
            break label241;
          }
          ae.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, removeComment:%s", new Object[] { localdgh.Username, paramdgc.HzT, Integer.valueOf(localdgh.HNk) });
          localSnsObject.CommentUserList.remove(localdgh);
        }
      }
      for (;;)
      {
        localp.bL(localSnsObject.toByteArray());
        ah.dXE().a(localSnsObject.Id, localp);
        AppMethodBeat.o(219344);
        return;
        label241:
        if (localdgh.Username.equals(com.tencent.mm.model.v.aAC()))
        {
          ae.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, markDeleteFlag:%s", new Object[] { localdgh.Username, paramdgc.HzT, Integer.valueOf(localdgh.HNk) });
          localdgh.DeleteFlag = 1;
        }
      }
      return;
    }
    catch (Exception paramdgc)
    {
      ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdgc, "", new Object[0]);
      AppMethodBeat.o(219344);
    }
  }
  
  private static void c(p paramp, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(219345);
    if (paramp != null)
    {
      String str;
      long l;
      Object localObject1;
      try
      {
        if (paramp.field_attrBuf == null) {
          break label395;
        }
        if (zCj == -1L) {
          zCj = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIK, 86400);
        }
        str = com.tencent.mm.model.v.aAC();
        l = ch.aDd();
        localObject2 = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
        if ((localObject2 == null) || (bu.ht(((SnsObject)localObject2).CommentUserList)) || (paramSnsObject == null)) {
          break label395;
        }
        paramp = new ArrayList();
        if (paramSnsObject.CommentUserList == null) {
          paramSnsObject.CommentUserList = new LinkedList();
        }
        localObject1 = paramSnsObject.CommentUserList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramp.add(Integer.valueOf(((dgh)((Iterator)localObject1).next()).HNk));
        }
        localObject1 = new ArrayList();
      }
      catch (Exception paramp)
      {
        ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
        AppMethodBeat.o(219345);
        return;
      }
      Object localObject2 = ((SnsObject)localObject2).CommentUserList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        dgh localdgh = (dgh)((Iterator)localObject2).next();
        if ((bu.lX(localdgh.Username, str)) && (localdgh.DeleteFlag > 0)) {
          if (l - localdgh.CreateTime > zCj)
          {
            ae.i("MicroMsg.SnsInfoStorageLogic", "it's time to delete local comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localdgh.HNk), localdgh.Username });
          }
          else if (!paramp.contains(Integer.valueOf(localdgh.HNk)))
          {
            ae.i("MicroMsg.SnsInfoStorageLogic", "insert a local fake comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localdgh.HNk), localdgh.Username });
            ((List)localObject1).add(localdgh);
          }
        }
      }
      if (!bu.ht((List)localObject1)) {
        paramSnsObject.CommentUserList.addAll((Collection)localObject1);
      }
      Collections.sort(paramSnsObject.CommentUserList, new Comparator() {});
    }
    label395:
    AppMethodBeat.o(219345);
  }
  
  public static void d(long paramLong, dgc paramdgc)
  {
    AppMethodBeat.i(95864);
    paramdgc = paramdgc.HNs;
    if (paramdgc.nJA != 13)
    {
      AppMethodBeat.o(95864);
      return;
    }
    p localp = ah.dXE().AG(paramLong);
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
        localSnsObject.SnsRedEnvelops = new dhi();
      }
      if (paramdgc.nJA == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.HOu.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((dgq)((Iterator)localObject).next()).Username.equals(paramdgc.HzT);
          if (bool)
          {
            AppMethodBeat.o(95864);
            return;
          }
        }
        localObject = new dgq();
        ((dgq)localObject).HNn = paramdgc.HNn;
        ((dgq)localObject).CreateTime = paramdgc.CreateTime;
        ((dgq)localObject).Username = paramdgc.HzT;
        localSnsObject.SnsRedEnvelops.HOu.add(localObject);
        localSnsObject.SnsRedEnvelops.HOt = localSnsObject.SnsRedEnvelops.HOu.size();
      }
      localp.bL(localSnsObject.toByteArray());
      ah.dXE().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95864);
      return;
    }
    catch (Exception paramdgc)
    {
      ae.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramdgc.getMessage());
      ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdgc, "", new Object[0]);
      AppMethodBeat.o(95864);
    }
  }
  
  public static void dYa()
  {
    AppMethodBeat.i(95860);
    if (zCk != null) {
      zCk.clear();
    }
    AppMethodBeat.o(95860);
  }
  
  public static List<p> dYb()
  {
    AppMethodBeat.i(95874);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ah.dXE();
    Object localObject2 = q.ecI() + " AND " + q.Aei + " AND  (snsId = 0  ) ";
    localObject1 = ((q)localObject1).db.rawQuery((String)localObject2, null);
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
  
  public static void dYc()
  {
    AppMethodBeat.i(95883);
    Cursor localCursor = ah.dXE().q("", "", 0, 0);
    if (localCursor != null)
    {
      ae.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
      while (localCursor.moveToNext())
      {
        p localp = new p();
        localp.convertFrom(localCursor);
        ae.i("MicroMsg.SnsInfoStorageLogic", localp.getSnsId());
      }
      ae.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
      localCursor.close();
    }
    AppMethodBeat.o(95883);
  }
  
  public static void dYd()
  {
    zxX = 0L;
    zxY = 0L;
  }
  
  public static long e(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95866);
    p localp2 = ah.dXE().AG(paramSnsObject.Id);
    p localp1 = localp2;
    if (localp2 == null) {
      localp1 = new p();
    }
    long l = a(localp1, paramSnsObject, "", 0);
    AppMethodBeat.o(95866);
    return l;
  }
  
  private static String fS(List<String> paramList)
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
  
  public static List<com.tencent.mm.plugin.sns.i.b> fT(List<String> paramList)
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
      bzh localbzh = new bzh();
      localbzh.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localb.dKe = localbzh;
      localb.parentId = "";
      localb.zHI = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95881);
    return localArrayList;
  }
  
  public static List<com.tencent.mm.plugin.sns.i.b> jt(String paramString1, String paramString2)
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
      if (com.tencent.mm.vfs.o.fB((String)localObject2))
      {
        paramString1 = com.tencent.mm.vfs.o.bb((String)localObject2, 0, (int)com.tencent.mm.vfs.o.aZR((String)localObject2));
        paramString1 = (dm)new dm().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        com.tencent.mm.vfs.o.deleteFile((String)localObject2);
        paramString2 = a.aAS(new String(com.tencent.mm.vfs.o.bb((String)localObject3, 0, (int)com.tencent.mm.vfs.o.aZR((String)localObject3))));
        com.tencent.mm.vfs.o.f((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (bni)paramString1.next();
        paramString2 = ((bni)localObject1).Name;
        localObject1 = ((bni)localObject1).Gtx.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (bzh)((Iterator)localObject1).next();
          ((bzh)localObject2).Desc = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.i.b();
          ((com.tencent.mm.plugin.sns.i.b)localObject3).dKe = ((bzh)localObject2);
          ((com.tencent.mm.plugin.sns.i.b)localObject3).parentId = "";
          ((com.tencent.mm.plugin.sns.i.b)localObject3).zHI = j;
          localArrayList.add(localObject3);
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
      AppMethodBeat.o(95877);
    }
  }
  
  public static List<p> ju(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95884);
    paramString1 = ah.dXE().jX(paramString1, paramString2);
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
  
  public static void k(LinkedList<SnsObject> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(95885);
    if (paramInt == av.zEa)
    {
      zxX = ((SnsObject)paramLinkedList.getFirst()).Id;
      zxY = ((SnsObject)paramLinkedList.getLast()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == av.zEb)
    {
      zxX = ((SnsObject)paramLinkedList.getFirst()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == av.zEc) {
      zxY = ((SnsObject)paramLinkedList.getLast()).Id;
    }
    AppMethodBeat.o(95885);
  }
  
  public static SnsObject u(p paramp)
  {
    AppMethodBeat.i(95861);
    try
    {
      paramp = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      paramp = ah.dXD().d(paramp);
      zCk.clear();
      AppMethodBeat.o(95861);
      return paramp;
    }
    catch (Exception paramp)
    {
      ae.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
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
      if (paramp.AdI == null) {
        paramp.AdI = (com.tencent.mm.b.g.getMessageDigest(paramp.field_content) + com.tencent.mm.b.g.getMessageDigest(paramp.field_attrBuf));
      }
      if (zCk.containsKey(paramp.AdI))
      {
        localSnsObject = (SnsObject)zCk.get(paramp.AdI);
        if (localSnsObject != null)
        {
          ah.dXD().d(localSnsObject);
          AppMethodBeat.o(95862);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      zCk.put(paramp.AdI, localSnsObject);
      ah.dXD().d(localSnsObject);
      AppMethodBeat.o(95862);
      return localSnsObject;
    }
    catch (Exception paramp)
    {
      ae.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      ae.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
      paramp = new SnsObject();
      AppMethodBeat.o(95862);
    }
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.al
 * JD-Core Version:    0.7.0.1
 */