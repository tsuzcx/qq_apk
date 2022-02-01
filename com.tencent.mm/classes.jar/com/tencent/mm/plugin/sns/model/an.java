package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.ddw;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storagebase.h;
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

public final class an
{
  public static long DIf;
  public static long DIg;
  public static final Map<Long, SnsInfo> DMg;
  public static long DMh;
  public static int DMi;
  private static long DMj;
  private static Map<String, SnsObject> DMk;
  
  static
  {
    AppMethodBeat.i(95886);
    DMg = new TreeMap(new an.1());
    DIf = 0L;
    DIg = 0L;
    DMh = 0L;
    DMi = 0;
    DMj = -1L;
    DMk = new ConcurrentHashMap();
    AppMethodBeat.o(95886);
  }
  
  public static SnsObject B(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95861);
    try
    {
      paramSnsInfo = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      paramSnsInfo = aj.faN().d(paramSnsInfo);
      DMk.clear();
      AppMethodBeat.o(95861);
      return paramSnsInfo;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSnsInfo, "", new Object[0]);
      paramSnsInfo = new SnsObject();
      AppMethodBeat.o(95861);
    }
    return paramSnsInfo;
  }
  
  public static SnsObject C(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95862);
    try
    {
      if (paramSnsInfo.contentByteMd5 == null) {
        paramSnsInfo.contentByteMd5 = (com.tencent.mm.b.g.getMessageDigest(paramSnsInfo.field_content) + com.tencent.mm.b.g.getMessageDigest(paramSnsInfo.field_attrBuf));
      }
      if (DMk.containsKey(paramSnsInfo.contentByteMd5))
      {
        localSnsObject = (SnsObject)DMk.get(paramSnsInfo.contentByteMd5);
        if (localSnsObject != null)
        {
          aj.faN().d(localSnsObject);
          AppMethodBeat.o(95862);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      DMk.put(paramSnsInfo.contentByteMd5, localSnsObject);
      aj.faN().d(localSnsObject);
      AppMethodBeat.o(95862);
      return localSnsObject;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSnsInfo, "", new Object[0]);
      paramSnsInfo = new SnsObject();
      AppMethodBeat.o(95862);
    }
    return paramSnsInfo;
  }
  
  public static List<SnsInfo> E(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(160673);
    n localn = aj.faO();
    Object localObject2 = n.feX();
    Object localObject1 = localObject2;
    if (n.aQw(paramString)) {
      localObject1 = (String)localObject2 + " AND " + localn.aQx(paramString);
    }
    if (paramBoolean) {}
    for (paramString = (String)localObject1 + n.Emx;; paramString = (String)localObject1 + n.Emy)
    {
      Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString)));
      paramString = localn.iFy.rawQuery(paramString, null);
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
        localObject2 = new SnsInfo();
        ((SnsInfo)localObject2).convertFrom(paramString);
        ((List)localObject1).add(localObject2);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(160673);
    return localObject1;
  }
  
  public static boolean In(String paramString)
  {
    AppMethodBeat.i(95873);
    boolean bool = z.aTY().equals(paramString.trim());
    AppMethodBeat.o(95873);
    return bool;
  }
  
  public static boolean YA(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public static boolean YB(int paramInt)
  {
    AppMethodBeat.i(95872);
    Log.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    SnsInfo localSnsInfo = aj.faO().Zr(paramInt);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95872);
      return false;
    }
    localSnsInfo.clearItemDie();
    localSnsInfo.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    cne localcne = null;
    for (;;)
    {
      try
      {
        localObject = (cnc)new cnc().parseFrom(localSnsInfo.getPostBuf());
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((cnc)localObject).ibG = 0;
          ((cnc)localObject).MsZ = System.currentTimeMillis();
          localSnsInfo.setPostBuf(((cnc)localObject).toByteArray());
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
            q localq;
            continue;
            paramInt += 1;
          }
        }
        localException2 = localException2;
        localObject = localcne;
      }
    }
    aj.faO().d(paramInt, localSnsInfo);
    paramInt = 0;
    if (paramInt < ((cnc)localObject).MsW.size())
    {
      i = ((cjs)((cnc)localObject).MsW.get(paramInt)).Mpj;
      localq = aj.faD().JK(i);
      if (localq != null)
      {
        localq.offset = 0;
        try
        {
          localcne = (cne)new cne().parseFrom(localq.EmR);
          if (localcne.Mpa == 0) {
            break label278;
          }
          localcne.Mpa = 2;
          localcne.Mtu = "";
          localq.EmR = localcne.toByteArray();
          aj.faD().a(i, localq);
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
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
  
  public static SnsInfo YC(int paramInt)
  {
    AppMethodBeat.i(95876);
    SnsInfo localSnsInfo = new SnsInfo();
    Object localObject1 = aj.faO();
    Object localObject2 = n.feU();
    localObject2 = (String)localObject2 + " and createTime < " + paramInt;
    localObject2 = (String)localObject2 + n.Emu;
    localObject2 = (String)localObject2 + " LIMIT 1";
    Log.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[] { localObject2 });
    localObject2 = ((n)localObject1).iFy.rawQuery((String)localObject2, null);
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
      localSnsInfo.convertFrom((Cursor)localObject1);
      ((Cursor)localObject1).close();
      AppMethodBeat.o(95876);
      return localSnsInfo;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(95876);
    return null;
  }
  
  public static void YD(int paramInt)
  {
    AppMethodBeat.i(95882);
    Log.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    SnsInfo localSnsInfo = aj.faO().Zr(paramInt);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95882);
      return;
    }
    localSnsInfo.unsetOmittedFailResend();
    aj.faO().d(paramInt, localSnsInfo);
    AppMethodBeat.o(95882);
  }
  
  private static long a(SnsInfo paramSnsInfo, SnsObject paramSnsObject, String paramString, int paramInt)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(95867);
    Object localObject1 = paramSnsInfo;
    if (paramSnsInfo == null) {
      localObject1 = new SnsInfo();
    }
    long l;
    if (!aj.faN().Jq(((SnsInfo)localObject1).field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      Log.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + com.tencent.mm.plugin.sns.data.r.Jb(paramSnsObject.Id));
      if (((SnsInfo)localObject1).isSourceExist(paramInt)) {
        break label1083;
      }
      ((SnsInfo)localObject1).addSourceFlag(paramInt);
    }
    label1077:
    label1083:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        aj.faO().a(paramSnsObject.Id, (SnsInfo)localObject1);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
      paramSnsInfo = paramSnsObject.CommentUserList;
      Log.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsInfo.size()), com.tencent.mm.plugin.sns.data.r.Jb(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.getBuffer() == null))
      {
        Log.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsInfo = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
      Log.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
      if (Util.isNullOrNil(paramSnsInfo))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      if (!((SnsInfo)localObject1).setContent(paramSnsInfo))
      {
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsObject.ObjectOperations = b(paramSnsObject.ObjectOperations, ((SnsInfo)localObject1).field_attrBuf);
      Log.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[] { Long.valueOf(paramSnsObject.Id) });
      paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
      ((SnsInfo)localObject1).setUserName(paramSnsObject.Username);
      ((SnsInfo)localObject1).setCreateTime(paramSnsObject.CreateTime);
      ((SnsInfo)localObject1).setLikeFlag(paramSnsObject.LikeFlag);
      ((SnsInfo)localObject1).setSnsId(paramSnsObject.Id);
      ((SnsInfo)localObject1).setStringSeq(paramSnsObject.Id);
      ((SnsInfo)localObject1).addSourceFlag(paramInt);
      for (;;)
      {
        try
        {
          if (!((SnsInfo)localObject1).isAd()) {
            c((SnsInfo)localObject1, paramSnsObject);
          }
          l = Util.currentTicks();
        }
        catch (Exception paramSnsInfo)
        {
          int k;
          ebn localebn;
          Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSnsInfo, "", new Object[0]);
          continue;
          i = 0;
          continue;
          ((SnsInfo)localObject1).unSetExtFlag();
          continue;
          ((SnsInfo)localObject1).cleanWsFoldFlag();
          continue;
          if ((k != 1) && ((paramString.equals(paramSnsObject.Username)) || (paramInt != 4))) {
            continue;
          }
          ((SnsInfo)localObject1).setLocalPrivate();
          ((SnsInfo)localObject1).setTimeLine(paramSnsInfo);
          ((SnsInfo)localObject1).setTypeFlag(paramSnsInfo.ContentObj.LoU);
          ((SnsInfo)localObject1).setSubTypeFlag(paramSnsInfo.ContentObj.LoW);
          aj.faO().a(paramSnsObject.Id, (SnsInfo)localObject1);
          paramSnsInfo = paramSnsObject.CommentUserList.iterator();
          if (!paramSnsInfo.hasNext()) {
            continue;
          }
          paramString = ((dzo)paramSnsInfo.next()).MYY.iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          localObject1 = a((dzu)paramString.next());
          if (bj.gCJ().OpN.blk(((EmojiInfo)localObject1).field_md5) != null) {
            continue;
          }
          bj.gCJ().OpN.K((EmojiInfo)localObject1);
          Object localObject2 = e.gVM;
          e.a((EmojiInfo)localObject1, null);
          continue;
          continue;
          l = paramSnsObject.Id;
          AppMethodBeat.o(95867);
          return l;
        }
        try
        {
          if (((SnsInfo)localObject1).getTypeFlag() == 15)
          {
            paramSnsInfo = (SnsObject)new SnsObject().parseFrom(((SnsInfo)localObject1).field_attrBuf);
            if ((paramSnsInfo != null) && (paramSnsInfo.PreDownloadInfo != null) && (paramSnsInfo.PreDownloadInfo.MIW > 0))
            {
              paramSnsObject.PreDownloadInfo = paramSnsInfo.PreDownloadInfo;
              Log.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.MIW), Integer.valueOf(paramSnsObject.PreDownloadInfo.MIX), paramSnsObject.PreDownloadInfo.MIY, Long.valueOf(Util.ticksToNow(l)) });
            }
          }
        }
        catch (Exception paramSnsInfo)
        {
          Log.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[] { paramSnsInfo.toString() });
        }
      }
      ((SnsInfo)localObject1).setAttrBuf(paramSnsObject.toByteArray());
      paramSnsInfo = ((SnsInfo)localObject1).getTimeLine();
      paramSnsInfo.UserName = paramSnsObject.Username;
      k = paramSnsInfo.Privated;
      ((SnsInfo)localObject1).setPravited(k);
      Log.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsObject.ExtFlag) });
      if ((paramSnsObject.ExtFlag & 0x1) > 0)
      {
        i = 1;
        if (i == 0) {
          break label839;
        }
        ((SnsInfo)localObject1).setExtFlag();
        if (!YA(paramSnsObject.ExtFlag)) {
          break label884;
        }
        ((SnsInfo)localObject1).addSourceFlag(128);
        localObject2 = aj.faX().JN(paramSnsObject.Id);
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (!Util.isNullOrNil(((u)localObject2).field_groupStrcut)) {
            localebn = new ebn();
          }
        }
      }
      for (;;)
      {
        try
        {
          localebn.parseFrom(((u)localObject2).field_groupStrcut);
          boolean bool = Util.isNullOrNil(localebn.Nbk);
          if (bool) {
            break label1077;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          label839:
          Log.w("MicroMsg.SnsInfoStorageLogic", "parse SnsWsGroupStruct fail:%s", new Object[] { localException.getMessage() });
          i = j;
          continue;
          ((SnsInfo)localObject1).cleanWsFoldFlag();
          continue;
        }
        if ((localObject2 != null) && (i != 0))
        {
          ((SnsInfo)localObject1).setWsFoldFlag();
          if ((k != 1) || (paramInt == 4) || (paramInt == 16)) {
            break label892;
          }
          Log.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
          AppMethodBeat.o(95867);
          return 0L;
        }
        label884:
        label892:
        i = 0;
      }
    }
  }
  
  public static cnb a(SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(95879);
    paramSnsInfo = paramSnsInfo.getTimeLine();
    if ((paramSnsInfo.ContentObj == null) || (paramSnsInfo.ContentObj.LoV.size() == 0))
    {
      AppMethodBeat.o(95879);
      return null;
    }
    paramSnsInfo = paramSnsInfo.ContentObj.LoV.iterator();
    while (paramSnsInfo.hasNext())
    {
      cnb localcnb = (cnb)paramSnsInfo.next();
      if (localcnb.Id.equals(paramString))
      {
        AppMethodBeat.o(95879);
        return localcnb;
      }
    }
    AppMethodBeat.o(95879);
    return null;
  }
  
  public static EmojiInfo a(dzu paramdzu)
  {
    AppMethodBeat.i(95868);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    if (paramdzu == null)
    {
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    if (paramdzu.MZq == null)
    {
      localEmojiInfo.field_md5 = paramdzu.Md5;
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    try
    {
      ait localait = new ait();
      localait.parseFrom(paramdzu.MZq.getBufferToBytes());
      com.tencent.mm.plugin.emoji.h.b.a(localait, localEmojiInfo);
      localEmojiInfo.field_temp = 1;
      localEmojiInfo.field_catalog = EmojiInfo.Uup;
      label86:
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    catch (Exception paramdzu)
    {
      break label86;
    }
  }
  
  public static List<SnsInfo> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(95857);
    if (paramBoolean2) {}
    for (paramString1 = aj.faO().a(false, paramString1, 10, paramBoolean1, paramString2);; paramString1 = aj.faO().g(paramString1, paramBoolean1, paramString2))
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
        SnsInfo localSnsInfo = new SnsInfo();
        localSnsInfo.convertFrom(paramString1);
        paramString2.add(localSnsInfo);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    AppMethodBeat.o(95857);
    return paramString2;
  }
  
  public static void a(String paramString1, int paramInt, LinkedList<SnsObject> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(95871);
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      AppMethodBeat.o(95871);
      return;
    }
    Object localObject3 = aj.faO();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    int j = 0;
    int i;
    Object localObject2;
    if (j < paramLinkedList.size())
    {
      SnsObject localSnsObject = (SnsObject)paramLinkedList.get(j);
      if (localSnsObject == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject2 = ((n)localObject3).JJ(localSnsObject.Id);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new SnsInfo();
          }
          if (a((SnsInfo)localObject1, localSnsObject, paramString1, paramInt) != 0L)
          {
            if ((localLinkedList.size() < 3) && ((((SnsInfo)localObject1).getTypeFlag() == 1) || (((SnsInfo)localObject1).getTypeFlag() == 15))) {
              localLinkedList.add(com.tencent.mm.plugin.sns.data.r.Jb(((SnsInfo)localObject1).field_snsId));
            }
            localArrayList.add(Long.valueOf(localSnsObject.Id));
          }
        }
        j += 1;
        break;
        if (Util.isNullOrNil(localSnsObject.Username))
        {
          Log.e("MicroMsg.SnsInfoStorageLogic", "snsObject username invalid");
          i = 0;
        }
        else if (localSnsObject.CreateTime <= 0)
        {
          Log.e("MicroMsg.SnsInfoStorageLogic", "sns CreateTime error:%s", new Object[] { Integer.valueOf(localSnsObject.CreateTime) });
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
    if (((paramInt == 4) || (paramInt == 8)) && (paramString2.equals("")))
    {
      localObject1 = aj.faS().aQr(paramString1);
      if (localObject1 != null)
      {
        localObject1 = ((l)localObject1).field_newerIds;
        localObject1 = Util.stringsToList(Util.nullAs((String)localObject1, "").split(","));
        Log.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + gP(localLinkedList));
        label351:
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
              break label481;
            }
            localLinkedList.add(0, localObject2);
          }
        }
        if (localLinkedList.contains(localObject2)) {
          break label351;
        }
        localLinkedList.add(localObject2);
        break label351;
        localObject1 = "";
        break;
        label481:
        i += 1;
      }
      Log.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + gP(localLinkedList));
      aj.faS().kK(paramString1, gP(localLinkedList));
    }
    Object localObject1 = com.tencent.mm.plugin.sns.data.r.aOr(com.tencent.mm.plugin.sns.data.r.Jb(((SnsObject)paramLinkedList.getLast()).Id));
    Log.i("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString2 + "  -  " + (String)localObject1);
    if (paramInt == 2)
    {
      localObject2 = aj.faO();
      paramLinkedList = n.feR();
      if (paramString2 != null)
      {
        paramString1 = paramLinkedList;
        if (paramString2.equals("")) {}
      }
      else
      {
        paramString1 = paramLinkedList + " AND " + ((n)localObject2).aQA(paramString2);
      }
      paramLinkedList = paramString1;
      if (n.aQw((String)localObject1)) {
        paramLinkedList = paramString1 + " AND " + ((n)localObject2).aQx((String)localObject1);
      }
      Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
      paramString1 = ((n)localObject2).iFy.rawQuery(paramLinkedList, null);
    }
    while (paramString1 == null)
    {
      AppMethodBeat.o(95871);
      return;
      if (paramInt == 16)
      {
        paramString1 = aj.faO().kL(paramString2, (String)localObject1);
      }
      else if (paramInt == 128)
      {
        paramString1 = aj.faO().aQ(null, paramString2, (String)localObject1);
      }
      else
      {
        localObject2 = aj.faO();
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          paramLinkedList = n.co(paramString1, bool);
          paramString1 = paramLinkedList;
          if (n.aQw(paramString2)) {
            paramString1 = paramLinkedList + " AND " + ((n)localObject2).aQA(paramString2);
          }
          paramLinkedList = paramString1;
          if (n.aQw((String)localObject1)) {
            paramLinkedList = paramString1 + " AND " + ((n)localObject2).aQx((String)localObject1);
          }
          Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramLinkedList)));
          paramString1 = ((n)localObject2).iFy.rawQuery(paramLinkedList, null);
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
      paramLinkedList = new SnsInfo();
      paramLinkedList.convertFrom(paramString1);
      long l = paramLinkedList.field_snsId;
      if (paramLinkedList.isWaitPost()) {
        Log.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        paramString1 = aj.faZ();
        Log.i("MicroMsg.SnsUnreadTipManager", "checkRemoveFeed");
        aj.dRd().post(new aw.3(paramString1, localArrayList));
        AppMethodBeat.o(95871);
        return;
        if (paramLinkedList.isDieItem())
        {
          Log.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!localArrayList.contains(Long.valueOf(l)))
        {
          paramLinkedList.removeSourceFlag(paramInt);
          aj.faO().b(l, paramLinkedList);
          if (paramInt == 2) {
            aj.faX().JO(l);
          }
          Log.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt + ", snsIdStr=" + com.tencent.mm.plugin.sns.data.r.Jb(l));
        }
      }
    }
  }
  
  public static boolean a(long paramLong, dzj paramdzj)
  {
    AppMethodBeat.i(95865);
    dzi localdzi = paramdzj.MZb;
    if ((localdzi.oUv != 1) && (localdzi.oUv != 2))
    {
      AppMethodBeat.o(95865);
      return true;
    }
    SnsInfo localSnsInfo = aj.faO().JJ(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95865);
      return true;
    }
    if ((localSnsInfo.getTypeFlag() == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.eZL()))
    {
      Log.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
      AppMethodBeat.o(95865);
      return false;
    }
    for (;;)
    {
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
        localSnsObject.Id = paramLong;
        if (localdzi.oUv != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdzo = (dzo)localIterator.next();
          if (localdzo.CreateTime != localdzi.CreateTime) {
            continue;
          }
          bool = localdzo.Username.equals(localdzi.MKC);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(95865);
          return true;
        }
        localSnsObject.LikeUserList.add(ag.b(paramdzj));
        localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
        aj.faO().a(localSnsObject.Id, localSnsInfo);
      }
      catch (Exception paramdzj)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        dzo localdzo;
        boolean bool;
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdzj, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95865);
      return true;
      if (localdzi.oUv == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localdzo = (dzo)localIterator.next();
          if (localdzo.CreateTime == localdzi.CreateTime)
          {
            bool = localdzo.Username.equals(localdzi.MKC);
            if (bool)
            {
              AppMethodBeat.o(95865);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ag.b(paramdzj));
        }
      }
    }
  }
  
  public static SnsInfo aPk(String paramString)
  {
    AppMethodBeat.i(95859);
    paramString = aj.faO().a(true, paramString, 1, false, "");
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(95859);
      return null;
    }
    paramString.moveToFirst();
    SnsInfo localSnsInfo = new SnsInfo();
    localSnsInfo.convertFrom(paramString);
    if (!paramString.isClosed()) {
      paramString.close();
    }
    AppMethodBeat.o(95859);
    return localSnsInfo;
  }
  
  public static String aPl(String paramString)
  {
    AppMethodBeat.i(95875);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = aj.faU().getCursor();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        com.tencent.mm.plugin.sns.storage.s locals = new com.tencent.mm.plugin.sns.storage.s();
        locals.convertFrom((Cursor)localObject);
        localLinkedList.add(Util.nullAs(locals.field_tagName, ""));
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
  
  public static List<com.tencent.mm.plugin.sns.j.b> aPm(String paramString)
  {
    AppMethodBeat.i(95880);
    ArrayList localArrayList = new ArrayList();
    if (aj.isInValid())
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    Object localObject = com.tencent.mm.plugin.sns.storage.f.aQm(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localObject = ((SnsInfo)localObject).getTimeLine();
    if ((((TimeLineObject)localObject).ContentObj == null) || (((TimeLineObject)localObject).ContentObj.LoV.size() == 0))
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((TimeLineObject)localObject).ContentObj.LoV.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      cnb localcnb = (cnb)localIterator.next();
      com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
      localb.ebR = localcnb;
      localb.parentId = paramString;
      localb.iXu = ((TimeLineObject)localObject).CreateTime;
      localb.DRJ = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95880);
    return localArrayList;
  }
  
  public static boolean aQ(int paramInt, boolean paramBoolean)
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
        eaj localeaj = new eaj();
        paramArrayOfByte = localeaj;
        if (localSKBuiltinBuffer_t != null) {
          paramArrayOfByte = (eaj)localeaj.parseFrom(localSKBuiltinBuffer_t.getBufferToBytes());
        }
        paramSKBuiltinBuffer_t = (eaj)new eaj().parseFrom(paramSKBuiltinBuffer_t.getBufferToBytes());
        if (paramSKBuiltinBuffer_t.MZL == null) {
          paramSKBuiltinBuffer_t.MZL = paramArrayOfByte.MZL;
        }
        if (paramArrayOfByte.MZK == null)
        {
          paramSKBuiltinBuffer_t.MZK = null;
          paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.toByteArray();
          paramSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(paramSKBuiltinBuffer_t);
          AppMethodBeat.o(95869);
          return paramSKBuiltinBuffer_t;
        }
        if (paramSKBuiltinBuffer_t.MZK == null)
        {
          paramSKBuiltinBuffer_t.MZK = paramArrayOfByte.MZK;
          continue;
          localSKBuiltinBuffer_t = null;
        }
      }
      catch (Exception paramSKBuiltinBuffer_t)
      {
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSKBuiltinBuffer_t, "", new Object[0]);
        AppMethodBeat.o(95869);
        return null;
      }
    }
  }
  
  public static cnb b(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(95878);
    if (aj.isInValid())
    {
      AppMethodBeat.o(95878);
      return null;
    }
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramSnsInfo = paramSnsInfo.getTimeLine();
    if ((paramSnsInfo.ContentObj == null) || (paramSnsInfo.ContentObj.LoV.size() == 0) || (paramSnsInfo.ContentObj.LoV.size() <= paramInt))
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramSnsInfo = (cnb)paramSnsInfo.ContentObj.LoV.get(paramInt);
    AppMethodBeat.o(95878);
    return paramSnsInfo;
  }
  
  public static void b(long paramLong, dzj paramdzj)
  {
    AppMethodBeat.i(95863);
    paramdzj = paramdzj.MZb;
    if (paramdzj.oUv != 9)
    {
      AppMethodBeat.o(95863);
      return;
    }
    SnsInfo localSnsInfo = aj.faO().JJ(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95863);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      while (localIterator.hasNext())
      {
        dzo localdzo = (dzo)localIterator.next();
        if ((localdzo.MYT == paramdzj.MYT) && (!Util.isNullOrNil(localdzo.Username)) && (localdzo.Username.equals(paramdzj.MKC))) {
          localSnsObject.CommentUserList.remove(localdzo);
        }
      }
      localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
      aj.faO().a(localSnsObject.Id, localSnsInfo);
      AppMethodBeat.o(95863);
      return;
    }
    catch (Exception paramdzj)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdzj, "", new Object[0]);
      AppMethodBeat.o(95863);
    }
  }
  
  public static void c(long paramLong, dzj paramdzj)
  {
    AppMethodBeat.i(202775);
    Log.i("MicroMsg.SnsInfoStorageLogic", "deleteComment");
    paramdzj = paramdzj.MZb;
    if (paramdzj.oUv != 9)
    {
      AppMethodBeat.o(202775);
      return;
    }
    SnsInfo localSnsInfo = aj.faO().JJ(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(202775);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      dzo localdzo;
      while (localIterator.hasNext())
      {
        localdzo = (dzo)localIterator.next();
        if ((localdzo.MYT == paramdzj.MYT) && (!Util.isNullOrNil(localdzo.Username)))
        {
          if ((!localdzo.Username.equals(paramdzj.MKC)) && (localdzo.Username.equals(z.aTY()))) {
            break label241;
          }
          Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, removeComment:%s", new Object[] { localdzo.Username, paramdzj.MKC, Integer.valueOf(localdzo.MYT) });
          localSnsObject.CommentUserList.remove(localdzo);
        }
      }
      for (;;)
      {
        localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
        aj.faO().a(localSnsObject.Id, localSnsInfo);
        AppMethodBeat.o(202775);
        return;
        label241:
        if (localdzo.Username.equals(z.aTY()))
        {
          Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, markDeleteFlag:%s", new Object[] { localdzo.Username, paramdzj.MKC, Integer.valueOf(localdzo.MYT) });
          localdzo.DeleteFlag = 1;
        }
      }
      return;
    }
    catch (Exception paramdzj)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdzj, "", new Object[0]);
      AppMethodBeat.o(202775);
    }
  }
  
  private static void c(SnsInfo paramSnsInfo, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(202776);
    if (paramSnsInfo != null)
    {
      String str;
      long l;
      Object localObject1;
      try
      {
        if (paramSnsInfo.field_attrBuf == null) {
          break label395;
        }
        if (DMj == -1L) {
          DMj = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdR, 86400);
        }
        str = z.aTY();
        l = cl.aWB();
        localObject2 = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
        if ((localObject2 == null) || (Util.isNullOrNil(((SnsObject)localObject2).CommentUserList)) || (paramSnsObject == null)) {
          break label395;
        }
        paramSnsInfo = new ArrayList();
        if (paramSnsObject.CommentUserList == null) {
          paramSnsObject.CommentUserList = new LinkedList();
        }
        localObject1 = paramSnsObject.CommentUserList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramSnsInfo.add(Integer.valueOf(((dzo)((Iterator)localObject1).next()).MYT));
        }
        localObject1 = new ArrayList();
      }
      catch (Exception paramSnsInfo)
      {
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSnsInfo, "", new Object[0]);
        AppMethodBeat.o(202776);
        return;
      }
      Object localObject2 = ((SnsObject)localObject2).CommentUserList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        dzo localdzo = (dzo)((Iterator)localObject2).next();
        if ((Util.isEqual(localdzo.Username, str)) && (localdzo.DeleteFlag > 0)) {
          if (l - localdzo.CreateTime > DMj)
          {
            Log.i("MicroMsg.SnsInfoStorageLogic", "it's time to delete local comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localdzo.MYT), localdzo.Username });
          }
          else if (!paramSnsInfo.contains(Integer.valueOf(localdzo.MYT)))
          {
            Log.i("MicroMsg.SnsInfoStorageLogic", "insert a local fake comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localdzo.MYT), localdzo.Username });
            ((List)localObject1).add(localdzo);
          }
        }
      }
      if (!Util.isNullOrNil((List)localObject1)) {
        paramSnsObject.CommentUserList.addAll((Collection)localObject1);
      }
      Collections.sort(paramSnsObject.CommentUserList, new Comparator() {});
    }
    label395:
    AppMethodBeat.o(202776);
  }
  
  public static void d(long paramLong, dzj paramdzj)
  {
    AppMethodBeat.i(95864);
    paramdzj = paramdzj.MZb;
    if (paramdzj.oUv != 13)
    {
      AppMethodBeat.o(95864);
      return;
    }
    SnsInfo localSnsInfo = aj.faO().JJ(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95864);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
      localSnsObject.Id = paramLong;
      if (localSnsObject.SnsRedEnvelops == null) {
        localSnsObject.SnsRedEnvelops = new ear();
      }
      if (paramdzj.oUv == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.Naf.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((dzx)((Iterator)localObject).next()).Username.equals(paramdzj.MKC);
          if (bool)
          {
            AppMethodBeat.o(95864);
            return;
          }
        }
        localObject = new dzx();
        ((dzx)localObject).MYW = paramdzj.MYW;
        ((dzx)localObject).CreateTime = paramdzj.CreateTime;
        ((dzx)localObject).Username = paramdzj.MKC;
        localSnsObject.SnsRedEnvelops.Naf.add(localObject);
        localSnsObject.SnsRedEnvelops.Nae = localSnsObject.SnsRedEnvelops.Naf.size();
      }
      localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
      aj.faO().a(localSnsObject.Id, localSnsInfo);
      AppMethodBeat.o(95864);
      return;
    }
    catch (Exception paramdzj)
    {
      Log.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramdzj.getMessage());
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramdzj, "", new Object[0]);
      AppMethodBeat.o(95864);
    }
  }
  
  public static long e(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95866);
    SnsInfo localSnsInfo2 = aj.faO().JJ(paramSnsObject.Id);
    SnsInfo localSnsInfo1 = localSnsInfo2;
    if (localSnsInfo2 == null) {
      localSnsInfo1 = new SnsInfo();
    }
    long l = a(localSnsInfo1, paramSnsObject, "", 0);
    AppMethodBeat.o(95866);
    return l;
  }
  
  public static void fbo()
  {
    AppMethodBeat.i(95860);
    if (DMk != null) {
      DMk.clear();
    }
    AppMethodBeat.o(95860);
  }
  
  public static List<SnsInfo> fbp()
  {
    AppMethodBeat.i(95874);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = aj.faO();
    Object localObject2 = n.feT() + " AND " + n.EmB + " AND  (snsId = 0  ) ";
    localObject1 = ((n)localObject1).iFy.rawQuery((String)localObject2, null);
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(95874);
      return localArrayList;
    }
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject2 = new SnsInfo();
      ((SnsInfo)localObject2).convertFrom((Cursor)localObject1);
      localArrayList.add(localObject2);
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(95874);
    return localArrayList;
  }
  
  public static void fbq()
  {
    AppMethodBeat.i(95883);
    Cursor localCursor = aj.faO().q("", "", 0, 0);
    if (localCursor != null)
    {
      Log.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
      while (localCursor.moveToNext())
      {
        SnsInfo localSnsInfo = new SnsInfo();
        localSnsInfo.convertFrom(localCursor);
        Log.i("MicroMsg.SnsInfoStorageLogic", localSnsInfo.getSnsId());
      }
      Log.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
      localCursor.close();
    }
    AppMethodBeat.o(95883);
  }
  
  public static void fbr()
  {
    DIf = 0L;
    DIg = 0L;
  }
  
  private static String gP(List<String> paramList)
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
  
  public static List<com.tencent.mm.plugin.sns.j.b> gQ(List<String> paramList)
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
      cnb localcnb = new cnb();
      localcnb.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localb.ebR = localcnb;
      localb.parentId = "";
      localb.DRJ = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95881);
    return localArrayList;
  }
  
  public static void j(LinkedList<SnsObject> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(95885);
    if (paramInt == ax.DOd)
    {
      DIf = ((SnsObject)paramLinkedList.getFirst()).Id;
      DIg = ((SnsObject)paramLinkedList.getLast()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == ax.DOe)
    {
      DIf = ((SnsObject)paramLinkedList.getFirst()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == ax.DOf) {
      DIg = ((SnsObject)paramLinkedList.getLast()).Id;
    }
    AppMethodBeat.o(95885);
  }
  
  public static List<com.tencent.mm.plugin.sns.j.b> kg(String paramString1, String paramString2)
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
      if (com.tencent.mm.vfs.s.YS((String)localObject2))
      {
        paramString1 = com.tencent.mm.vfs.s.aW((String)localObject2, 0, (int)com.tencent.mm.vfs.s.boW((String)localObject2));
        paramString1 = (dw)new dw().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        com.tencent.mm.vfs.s.deleteFile((String)localObject2);
        paramString2 = a.aPO(new String(com.tencent.mm.vfs.s.aW((String)localObject3, 0, (int)com.tencent.mm.vfs.s.boW((String)localObject3))));
        com.tencent.mm.vfs.s.f((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (bzz)paramString1.next();
        paramString2 = ((bzz)localObject1).Name;
        localObject1 = ((bzz)localObject1).LoV.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (cnb)((Iterator)localObject1).next();
          ((cnb)localObject2).Desc = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.j.b();
          ((com.tencent.mm.plugin.sns.j.b)localObject3).ebR = ((cnb)localObject2);
          ((com.tencent.mm.plugin.sns.j.b)localObject3).parentId = "";
          ((com.tencent.mm.plugin.sns.j.b)localObject3).DRJ = j;
          localArrayList.add(localObject3);
          j += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
      AppMethodBeat.o(95877);
    }
  }
  
  public static List<SnsInfo> kh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95884);
    paramString1 = aj.faO().kL(paramString1, paramString2);
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
        SnsInfo localSnsInfo = new SnsInfo();
        localSnsInfo.convertFrom(paramString1);
        paramString2.add(localSnsInfo);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    AppMethodBeat.o(95884);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an
 * JD-Core Version:    0.7.0.1
 */