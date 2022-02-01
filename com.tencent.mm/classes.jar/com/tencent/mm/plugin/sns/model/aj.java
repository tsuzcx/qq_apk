package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.j.a;
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
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
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
  public static long wET;
  public static long wEU;
  public static final Map<Long, p> wIB;
  public static long wIC;
  public static int wID;
  private static Map<String, SnsObject> wIE;
  
  static
  {
    AppMethodBeat.i(95886);
    wIB = new TreeMap(new aj.1());
    wET = 0L;
    wEU = 0L;
    wIC = 0L;
    wID = 0;
    wIE = new ConcurrentHashMap();
    AppMethodBeat.o(95886);
  }
  
  public static boolean Mn(int paramInt)
  {
    AppMethodBeat.i(95872);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    p localp = af.dtu().Ne(paramInt);
    if (localp == null)
    {
      AppMethodBeat.o(95872);
      return false;
    }
    localp.dya();
    localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    bpl localbpl = null;
    for (;;)
    {
      try
      {
        localObject = (bpj)new bpj().parseFrom(localp.field_postBuf);
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((bpj)localObject).gll = 0;
          ((bpj)localObject).DNs = System.currentTimeMillis();
          localp.field_postBuf = ((bpj)localObject).toByteArray();
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
        localObject = localbpl;
      }
    }
    af.dtu().b(paramInt, localp);
    paramInt = 0;
    if (paramInt < ((bpj)localObject).DNp.size())
    {
      i = ((bmh)((bpj)localObject).DNp.get(paramInt)).DJN;
      localt = af.dtj().ti(i);
      if (localt != null)
      {
        localt.offset = 0;
        try
        {
          localbpl = (bpl)new bpl().parseFrom(localt.xjn);
          if (localbpl.DJF == 0) {
            break label277;
          }
          localbpl.DJF = 2;
          localbpl.DNN = "";
          localt.xjn = localbpl.toByteArray();
          af.dtj().a(i, localt);
        }
        catch (Exception localException1)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
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
  
  public static p Mo(int paramInt)
  {
    AppMethodBeat.i(95876);
    p localp = new p();
    Object localObject1 = af.dtu();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dys();
    localObject2 = (String)localObject2 + " and createTime < " + paramInt;
    localObject2 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.q.xiR;
    localObject2 = (String)localObject2 + " LIMIT 1";
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[] { localObject2 });
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
  
  public static void Mp(int paramInt)
  {
    AppMethodBeat.i(95882);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    p localp = af.dtu().Ne(paramInt);
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
      af.dtu().b(paramInt, localp);
      AppMethodBeat.o(95882);
      return;
    }
  }
  
  public static boolean ZR(String paramString)
  {
    AppMethodBeat.i(95873);
    boolean bool = com.tencent.mm.model.u.aqG().equals(paramString.trim());
    AppMethodBeat.o(95873);
    return bool;
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
    if (!af.dtt().sK(((p)localObject).field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + com.tencent.mm.plugin.sns.data.q.st(paramSnsObject.Id));
      if (((p)localObject).Nb(paramInt)) {
        break label908;
      }
      ((p)localObject).MY(paramInt);
    }
    label908:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        af.dtu().a(paramSnsObject.Id, (p)localObject);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
      paramp = paramSnsObject.CommentUserList;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramp.size()), com.tencent.mm.plugin.sns.data.q.st(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.getBuffer() == null))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramp = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
      if (bt.isNullOrNil(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      if (!((p)localObject).apI(paramp))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsObject.ObjectOperations = b(paramSnsObject.ObjectOperations, ((p)localObject).field_attrBuf);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(paramSnsObject.Id) });
      paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
      ((p)localObject).field_userName = paramSnsObject.Username;
      ((p)localObject).setCreateTime(paramSnsObject.CreateTime);
      ((p)localObject).field_likeFlag = paramSnsObject.LikeFlag;
      ((p)localObject).td(paramSnsObject.Id);
      ((p)localObject).tf(paramSnsObject.Id);
      ((p)localObject).MY(paramInt);
      try
      {
        l = bt.GC();
      }
      catch (Exception paramp)
      {
        label547:
        int j;
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
          continue;
          i = 0;
          continue;
          ((p)localObject).dxV();
        }
        if ((j != 1) && ((paramString.equals(paramSnsObject.Username)) || (paramInt != 4))) {
          continue;
        }
        ((p)localObject).dxR();
        ((p)localObject).g(paramp);
        ((p)localObject).field_type = paramp.Etm.DaB;
        ((p)localObject).field_subType = paramp.Etm.DaD;
        af.dtu().a(paramSnsObject.Id, (p)localObject);
        paramp = paramSnsObject.CommentUserList.iterator();
        if (!paramp.hasNext()) {
          continue;
        }
        paramString = ((cuo)paramp.next()).Emf.iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        localObject = a((cuu)paramString.next());
        if (aw.eLx().FyY.aJx(((EmojiInfo)localObject).field_md5) != null) {
          continue;
        }
        aw.eLx().FyY.K((EmojiInfo)localObject);
        com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.fLn;
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
          if ((paramp != null) && (paramp.PreDownloadInfo != null) && (paramp.PreDownloadInfo.DXR > 0))
          {
            paramSnsObject.PreDownloadInfo = paramp.PreDownloadInfo;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.DXR), Integer.valueOf(paramSnsObject.PreDownloadInfo.DXS), paramSnsObject.PreDownloadInfo.DXT, Long.valueOf(bt.aS(l)) });
          }
        }
      }
      catch (Exception paramp)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[] { paramp.toString() });
        break label547;
      }
      ((p)localObject).bC(paramSnsObject.toByteArray());
      paramp = ((p)localObject).dxy();
      paramp.mAQ = paramSnsObject.Username;
      j = paramp.DMS;
      ((p)localObject).field_pravited = j;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsObject.ExtFlag) });
      if ((paramSnsObject.ExtFlag & 0x1) > 0)
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        ((p)localObject).dxU();
        if ((j != 1) || (paramInt == 4) || (paramInt == 16)) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        AppMethodBeat.o(95867);
        return 0L;
      }
    }
  }
  
  public static bpi a(p paramp, int paramInt)
  {
    AppMethodBeat.i(95878);
    if (af.dtd())
    {
      AppMethodBeat.o(95878);
      return null;
    }
    if (paramp == null)
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = paramp.dxy();
    if ((paramp.Etm == null) || (paramp.Etm.DaC.size() == 0) || (paramp.Etm.DaC.size() <= paramInt))
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramp = (bpi)paramp.Etm.DaC.get(paramInt);
    AppMethodBeat.o(95878);
    return paramp;
  }
  
  public static bpi a(p paramp, String paramString)
  {
    AppMethodBeat.i(95879);
    paramp = paramp.dxy();
    if ((paramp.Etm == null) || (paramp.Etm.DaC.size() == 0))
    {
      AppMethodBeat.o(95879);
      return null;
    }
    paramp = paramp.Etm.DaC.iterator();
    while (paramp.hasNext())
    {
      bpi localbpi = (bpi)paramp.next();
      if (localbpi.Id.equals(paramString))
      {
        AppMethodBeat.o(95879);
        return localbpi;
      }
    }
    AppMethodBeat.o(95879);
    return null;
  }
  
  public static EmojiInfo a(cuu paramcuu)
  {
    AppMethodBeat.i(95868);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    if (paramcuu == null)
    {
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    if (paramcuu.Emy == null)
    {
      localEmojiInfo.field_md5 = paramcuu.Md5;
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    try
    {
      act localact = new act();
      localact.parseFrom(paramcuu.Emy.getBufferToBytes());
      com.tencent.mm.plugin.emoji.h.b.a(localact, localEmojiInfo);
      localEmojiInfo.field_temp = 1;
      localEmojiInfo.field_catalog = EmojiInfo.LBQ;
      label86:
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    catch (Exception paramcuu)
    {
      break label86;
    }
  }
  
  public static List<p> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(95857);
    if (paramBoolean2) {}
    for (paramString1 = af.dtu().b(paramString1, 10, paramBoolean1, paramString2);; paramString1 = af.dtu().g(paramString1, paramBoolean1, paramString2))
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
  
  public static boolean a(long paramLong, cuj paramcuj)
  {
    AppMethodBeat.i(95865);
    cui localcui = paramcuj.Emi;
    if ((localcui.mBH != 1) && (localcui.mBH != 2))
    {
      AppMethodBeat.o(95865);
      return true;
    }
    p localp = af.dtu().th(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(95865);
      return true;
    }
    if ((localp.field_type == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.dsr()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
      AppMethodBeat.o(95865);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localcui.mBH != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localcuo = (cuo)localIterator.next();
          if (localcuo.CreateTime != localcui.CreateTime) {
            continue;
          }
          bool = localcuo.Username.equals(localcui.DZr);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(95865);
          return true;
        }
        localSnsObject.LikeUserList.add(ad.b(paramcuj));
        localp.bC(localSnsObject.toByteArray());
        af.dtu().a(localSnsObject.Id, localp);
      }
      catch (Exception paramcuj)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        cuo localcuo;
        boolean bool;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramcuj, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95865);
      return true;
      if (localcui.mBH == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localcuo = (cuo)localIterator.next();
          if (localcuo.CreateTime == localcui.CreateTime)
          {
            bool = localcuo.Username.equals(localcui.DZr);
            if (bool)
            {
              AppMethodBeat.o(95865);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ad.b(paramcuj));
        }
      }
    }
  }
  
  public static p aoG(String paramString)
  {
    AppMethodBeat.i(95859);
    paramString = af.dtu().b(paramString, 1, false, "");
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
  
  public static String aoH(String paramString)
  {
    AppMethodBeat.i(95875);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = af.dtA().getCursor();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        v localv = new v();
        localv.convertFrom((Cursor)localObject);
        localLinkedList.add(bt.by(localv.field_tagName, ""));
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
  
  public static List<com.tencent.mm.plugin.sns.j.b> aoI(String paramString)
  {
    AppMethodBeat.i(95880);
    ArrayList localArrayList = new ArrayList();
    if (af.dtd())
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    Object localObject = h.apK(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localObject = ((p)localObject).dxy();
    if ((((TimeLineObject)localObject).Etm == null) || (((TimeLineObject)localObject).Etm.DaC.size() == 0))
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((TimeLineObject)localObject).Etm.DaC.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      bpi localbpi = (bpi)localIterator.next();
      com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
      localb.dyS = localbpi;
      localb.wNP = paramString;
      localb.hgr = ((TimeLineObject)localObject).CreateTime;
      localb.wNQ = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95880);
    return localArrayList;
  }
  
  public static boolean ap(int paramInt, boolean paramBoolean)
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
        cvi localcvi = new cvi();
        paramArrayOfByte = localcvi;
        if (localSKBuiltinBuffer_t != null) {
          paramArrayOfByte = (cvi)localcvi.parseFrom(localSKBuiltinBuffer_t.getBufferToBytes());
        }
        paramSKBuiltinBuffer_t = (cvi)new cvi().parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        if (paramSKBuiltinBuffer_t.EmU == null) {
          paramSKBuiltinBuffer_t.EmU = paramArrayOfByte.EmU;
        }
        if (paramArrayOfByte.EmT == null)
        {
          paramSKBuiltinBuffer_t.EmT = null;
          paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.toByteArray();
          paramSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(paramSKBuiltinBuffer_t);
          AppMethodBeat.o(95869);
          return paramSKBuiltinBuffer_t;
        }
        if (paramSKBuiltinBuffer_t.EmT == null)
        {
          paramSKBuiltinBuffer_t.EmT = paramArrayOfByte.EmT;
          continue;
          localSKBuiltinBuffer_t = null;
        }
      }
      catch (Exception paramSKBuiltinBuffer_t)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSKBuiltinBuffer_t, "", new Object[0]);
        AppMethodBeat.o(95869);
        return null;
      }
    }
  }
  
  public static void b(long paramLong, cuj paramcuj)
  {
    AppMethodBeat.i(95863);
    paramcuj = paramcuj.Emi;
    if (paramcuj.mBH != 9)
    {
      AppMethodBeat.o(95863);
      return;
    }
    p localp = af.dtu().th(paramLong);
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
        cuo localcuo = (cuo)localIterator.next();
        if ((localcuo.Ema == paramcuj.Ema) && (!bt.isNullOrNil(localcuo.Username)) && (localcuo.Username.equals(paramcuj.DZr))) {
          localSnsObject.CommentUserList.remove(localcuo);
        }
      }
      localp.bC(localSnsObject.toByteArray());
      af.dtu().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95863);
      return;
    }
    catch (Exception paramcuj)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramcuj, "", new Object[0]);
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
    Object localObject3 = af.dtu();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    Object localObject2;
    while (i < paramLinkedList.size())
    {
      SnsObject localSnsObject = (SnsObject)paramLinkedList.get(i);
      localObject2 = ((com.tencent.mm.plugin.sns.storage.q)localObject3).th(localSnsObject.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new p();
      }
      if (a((p)localObject1, localSnsObject, paramString1, paramInt) != 0L)
      {
        if ((localLinkedList.size() < 3) && ((((p)localObject1).field_type == 1) || (((p)localObject1).field_type == 15))) {
          localLinkedList.add(com.tencent.mm.plugin.sns.data.q.st(((p)localObject1).field_snsId));
        }
        localArrayList.add(Long.valueOf(localSnsObject.Id));
      }
      i += 1;
    }
    if (((paramInt == 4) || (paramInt == 8)) && (paramString2.equals("")))
    {
      localObject1 = af.dty().apP(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((n)localObject1).field_newerIds;
        localObject1 = bt.S(bt.by((String)localObject1, "").split(","));
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + fo(localLinkedList));
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + fo(localLinkedList));
      af.dty().je(paramString1, fo(localLinkedList));
    }
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.anM(com.tencent.mm.plugin.sns.data.q.st(((SnsObject)paramLinkedList.getLast()).Id));
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString2 + "  -  " + (String)localObject1);
    if (paramInt == 2)
    {
      localObject2 = af.dtu();
      paramLinkedList = com.tencent.mm.plugin.sns.storage.q.dyq();
      if (paramString2 != null)
      {
        paramString1 = paramLinkedList;
        if (paramString2.equals("")) {}
      }
      else
      {
        paramString1 = paramLinkedList + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).apY(paramString2);
      }
      paramLinkedList = paramString1;
      if (com.tencent.mm.plugin.sns.storage.q.apU((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).apV((String)localObject1);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
      paramString1 = ((com.tencent.mm.plugin.sns.storage.q)localObject2).db.rawQuery(paramLinkedList, null);
    }
    while (paramString1 == null)
    {
      AppMethodBeat.o(95871);
      return;
      if (paramInt == 16)
      {
        paramString1 = af.dtu().jf(paramString2, (String)localObject1);
      }
      else
      {
        localObject2 = af.dtu();
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          paramLinkedList = com.tencent.mm.plugin.sns.storage.q.bE(paramString1, bool);
          paramString1 = paramLinkedList;
          if (com.tencent.mm.plugin.sns.storage.q.apU(paramString2)) {
            paramString1 = paramLinkedList + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).apY(paramString2);
          }
          paramLinkedList = paramString1;
          if (com.tencent.mm.plugin.sns.storage.q.apU((String)localObject1)) {
            paramLinkedList = paramString1 + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject2).apV((String)localObject1);
          }
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
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
      if (paramLinkedList.dxY()) {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        AppMethodBeat.o(95871);
        return;
        if (paramLinkedList.dxZ())
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!localArrayList.contains(Long.valueOf(l)))
        {
          paramLinkedList.Nc(paramInt);
          af.dtu().b(l, paramLinkedList);
          af.dtD().sR(l);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt);
        }
      }
    }
  }
  
  public static void c(long paramLong, cuj paramcuj)
  {
    AppMethodBeat.i(95864);
    paramcuj = paramcuj.Emi;
    if (paramcuj.mBH != 13)
    {
      AppMethodBeat.o(95864);
      return;
    }
    p localp = af.dtu().th(paramLong);
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
        localSnsObject.SnsRedEnvelops = new cvp();
      }
      if (paramcuj.mBH == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.Enk.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((cux)((Iterator)localObject).next()).Username.equals(paramcuj.DZr);
          if (bool)
          {
            AppMethodBeat.o(95864);
            return;
          }
        }
        localObject = new cux();
        ((cux)localObject).Emd = paramcuj.Emd;
        ((cux)localObject).CreateTime = paramcuj.CreateTime;
        ((cux)localObject).Username = paramcuj.DZr;
        localSnsObject.SnsRedEnvelops.Enk.add(localObject);
        localSnsObject.SnsRedEnvelops.Enj = localSnsObject.SnsRedEnvelops.Enk.size();
      }
      localp.bC(localSnsObject.toByteArray());
      af.dtu().a(localSnsObject.Id, localp);
      AppMethodBeat.o(95864);
      return;
    }
    catch (Exception paramcuj)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramcuj.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramcuj, "", new Object[0]);
      AppMethodBeat.o(95864);
    }
  }
  
  public static long d(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95866);
    p localp2 = af.dtu().th(paramSnsObject.Id);
    p localp1 = localp2;
    if (localp2 == null) {
      localp1 = new p();
    }
    long l = a(localp1, paramSnsObject, "", 0);
    AppMethodBeat.o(95866);
    return l;
  }
  
  public static void dtP()
  {
    AppMethodBeat.i(95860);
    if (wIE != null) {
      wIE.clear();
    }
    AppMethodBeat.o(95860);
  }
  
  public static List<p> dtQ()
  {
    AppMethodBeat.i(95874);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = af.dtu();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dyr() + " AND " + com.tencent.mm.plugin.sns.storage.q.xiX + " AND  (snsId = 0  ) ";
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
  
  public static void dtR()
  {
    AppMethodBeat.i(95883);
    Cursor localCursor = af.dtu().p("", "", 0, 0);
    if (localCursor != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
      while (localCursor.moveToNext())
      {
        p localp = new p();
        localp.convertFrom(localCursor);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", localp.getSnsId());
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
      localCursor.close();
    }
    AppMethodBeat.o(95883);
  }
  
  public static void dtS()
  {
    wET = 0L;
    wEU = 0L;
  }
  
  private static String fo(List<String> paramList)
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
  
  public static List<com.tencent.mm.plugin.sns.j.b> fp(List<String> paramList)
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
      com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
      bpi localbpi = new bpi();
      localbpi.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localb.dyS = localbpi;
      localb.wNP = "";
      localb.wNQ = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95881);
    return localArrayList;
  }
  
  public static List<com.tencent.mm.plugin.sns.j.b> iD(String paramString1, String paramString2)
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
      if (i.eK((String)localObject2))
      {
        paramString1 = i.aR((String)localObject2, 0, (int)i.aMN((String)localObject2));
        paramString1 = (dj)new dj().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        i.deleteFile((String)localObject2);
        paramString2 = a.apj(new String(i.aR((String)localObject3, 0, (int)i.aMN((String)localObject3))));
        i.f((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (beq)paramString1.next();
        paramString2 = ((beq)localObject1).Name;
        localObject1 = ((beq)localObject1).DaC.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (bpi)((Iterator)localObject1).next();
          ((bpi)localObject2).Desc = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.j.b();
          ((com.tencent.mm.plugin.sns.j.b)localObject3).dyS = ((bpi)localObject2);
          ((com.tencent.mm.plugin.sns.j.b)localObject3).wNP = "";
          ((com.tencent.mm.plugin.sns.j.b)localObject3).wNQ = j;
          localArrayList.add(localObject3);
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
      AppMethodBeat.o(95877);
    }
  }
  
  public static List<p> iE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95884);
    paramString1 = af.dtu().jf(paramString1, paramString2);
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
  
  public static void j(LinkedList<SnsObject> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(95885);
    if (paramInt == as.wKh)
    {
      wET = ((SnsObject)paramLinkedList.getFirst()).Id;
      wEU = ((SnsObject)paramLinkedList.getLast()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == as.wKi)
    {
      wET = ((SnsObject)paramLinkedList.getFirst()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == as.wKj) {
      wEU = ((SnsObject)paramLinkedList.getLast()).Id;
    }
    AppMethodBeat.o(95885);
  }
  
  public static SnsObject s(p paramp)
  {
    AppMethodBeat.i(95861);
    try
    {
      paramp = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      paramp = af.dtt().c(paramp);
      wIE.clear();
      AppMethodBeat.o(95861);
      return paramp;
    }
    catch (Exception paramp)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
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
      if (paramp.xiA == null) {
        paramp.xiA = (com.tencent.mm.b.g.getMessageDigest(paramp.field_content) + com.tencent.mm.b.g.getMessageDigest(paramp.field_attrBuf));
      }
      if (wIE.containsKey(paramp.xiA))
      {
        localSnsObject = (SnsObject)wIE.get(paramp.xiA);
        if (localSnsObject != null)
        {
          af.dtt().c(localSnsObject);
          AppMethodBeat.o(95862);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      wIE.put(paramp.xiA, localSnsObject);
      af.dtt().c(localSnsObject);
      AppMethodBeat.o(95862);
      return localSnsObject;
    }
    catch (Exception paramp)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramp, "", new Object[0]);
      paramp = new SnsObject();
      AppMethodBeat.o(95862);
    }
    return paramp;
  }
  
  public static List<p> v(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(160673);
    com.tencent.mm.plugin.sns.storage.q localq = af.dtu();
    Object localObject2 = com.tencent.mm.plugin.sns.storage.q.dyu();
    Object localObject1 = localObject2;
    if (com.tencent.mm.plugin.sns.storage.q.apU(paramString)) {
      localObject1 = (String)localObject2 + " AND " + localq.apV(paramString);
    }
    if (paramBoolean) {}
    for (paramString = (String)localObject1 + com.tencent.mm.plugin.sns.storage.q.xiU;; paramString = (String)localObject1 + com.tencent.mm.plugin.sns.storage.q.xiV)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString)));
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