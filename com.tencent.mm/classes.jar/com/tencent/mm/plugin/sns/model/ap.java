package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.plugin.sns.storage.ae;
import com.tencent.mm.plugin.sns.storage.af;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.protocal.protobuf.fef;
import com.tencent.mm.protocal.protobuf.fer;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.protocal.protobuf.fgb;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.y;
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

public final class ap
{
  public static long Qsh;
  public static final Map<Long, SnsInfo> Qwr;
  public static long Qws;
  private static long Qwt;
  private static Map<String, SnsObject> Qwu;
  public static int afC;
  public static long maxId;
  
  static
  {
    AppMethodBeat.i(95886);
    Qwr = new TreeMap(new ap.1());
    maxId = 0L;
    Qsh = 0L;
    Qws = 0L;
    afC = 0;
    Qwt = -1L;
    Qwu = new ConcurrentHashMap();
    AppMethodBeat.o(95886);
  }
  
  public static SnsObject D(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95861);
    try
    {
      paramSnsInfo = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      paramSnsInfo = al.hgA().g(paramSnsInfo);
      Qwu.clear();
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
  
  public static SnsObject E(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95862);
    try
    {
      if (paramSnsInfo.contentByteMd5 == null) {
        paramSnsInfo.contentByteMd5 = (com.tencent.mm.b.g.getMessageDigest(paramSnsInfo.field_content) + com.tencent.mm.b.g.getMessageDigest(paramSnsInfo.field_attrBuf));
      }
      if (Qwu.containsKey(paramSnsInfo.contentByteMd5))
      {
        localSnsObject = (SnsObject)Qwu.get(paramSnsInfo.contentByteMd5);
        if (localSnsObject != null)
        {
          al.hgA().g(localSnsObject);
          AppMethodBeat.o(95862);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      Qwu.put(paramSnsInfo.contentByteMd5, localSnsObject);
      al.hgA().g(localSnsObject);
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
  
  public static boolean Iz(String paramString)
  {
    AppMethodBeat.i(95873);
    boolean bool = com.tencent.mm.model.z.bAM().equals(paramString.trim());
    AppMethodBeat.o(95873);
    return bool;
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
    if (!al.hgA().uP(((SnsInfo)localObject1).field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      Log.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + t.uA(paramSnsObject.Id));
      if (((SnsInfo)localObject1).isSourceExist(paramInt)) {
        break label1078;
      }
      ((SnsInfo)localObject1).addSourceFlag(paramInt);
    }
    label1072:
    label1078:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        al.hgB().a(paramSnsObject.Id, (SnsInfo)localObject1);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
      Log.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsObject.CommentUserList.size()), t.uA(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.aaxD == null))
      {
        Log.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsInfo = new String(paramSnsObject.ObjectDesc.aaxD.toByteArray());
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
      paramSnsObject.ObjectDesc.df(new byte[0]);
      ((SnsInfo)localObject1).setUserName(paramSnsObject.Username);
      ((SnsInfo)localObject1).setCreateTime(paramSnsObject.CreateTime);
      ((SnsInfo)localObject1).setLikeFlag(paramSnsObject.LikeFlag);
      ((SnsInfo)localObject1).setSnsId(paramSnsObject.Id);
      ((SnsInfo)localObject1).setStringSeq(paramSnsObject.Id);
      ((SnsInfo)localObject1).field_serverExtFlag = paramSnsObject.ExtFlag;
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
          fgb localfgb;
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
          ((SnsInfo)localObject1).setTypeFlag(paramSnsInfo.ContentObj.Zpq);
          ((SnsInfo)localObject1).setSubTypeFlag(paramSnsInfo.ContentObj.Zps);
          al.hgB().a(paramSnsObject.Id, (SnsInfo)localObject1);
          paramSnsInfo = paramSnsObject.CommentUserList.iterator();
          if (!paramSnsInfo.hasNext()) {
            continue;
          }
          paramString = ((fdv)paramSnsInfo.next()).abDm.iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          localObject1 = a((feb)paramString.next());
          if (bl.jba().adju.bza(((EmojiInfo)localObject1).field_md5) != null) {
            continue;
          }
          bl.jba().adju.L((EmojiInfo)localObject1);
          Object localObject2 = e.mgl;
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
            if ((paramSnsInfo != null) && (paramSnsInfo.PreDownloadInfo != null) && (paramSnsInfo.PreDownloadInfo.ablw > 0))
            {
              paramSnsObject.PreDownloadInfo = paramSnsInfo.PreDownloadInfo;
              Log.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.ablw), Integer.valueOf(paramSnsObject.PreDownloadInfo.ablx), paramSnsObject.PreDownloadInfo.ably, Long.valueOf(Util.ticksToNow(l)) });
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
          break label835;
        }
        ((SnsInfo)localObject1).setExtFlag();
        if (!akH(paramSnsObject.ExtFlag)) {
          break label880;
        }
        ((SnsInfo)localObject1).addSourceFlag(128);
        localObject2 = al.hgL().vn(paramSnsObject.Id);
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (!Util.isNullOrNil(((ae)localObject2).field_groupStrcut)) {
            localfgb = new fgb();
          }
        }
      }
      for (;;)
      {
        try
        {
          localfgb.parseFrom(((ae)localObject2).field_groupStrcut);
          boolean bool = Util.isNullOrNil(localfgb.abFY);
          if (bool) {
            break label1072;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          label835:
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
            break label888;
          }
          Log.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
          AppMethodBeat.o(95867);
          return 0L;
        }
        label880:
        label888:
        i = 0;
      }
    }
  }
  
  public static dmz a(SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(95879);
    paramSnsInfo = paramSnsInfo.getTimeLine();
    if ((paramSnsInfo.ContentObj == null) || (paramSnsInfo.ContentObj.Zpr.size() == 0))
    {
      AppMethodBeat.o(95879);
      return null;
    }
    paramSnsInfo = paramSnsInfo.ContentObj.Zpr.iterator();
    while (paramSnsInfo.hasNext())
    {
      dmz localdmz = (dmz)paramSnsInfo.next();
      if (localdmz.Id.equals(paramString))
      {
        AppMethodBeat.o(95879);
        return localdmz;
      }
    }
    AppMethodBeat.o(95879);
    return null;
  }
  
  public static EmojiInfo a(feb paramfeb)
  {
    AppMethodBeat.i(95868);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    if (paramfeb == null)
    {
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    if (paramfeb.abDF == null)
    {
      localEmojiInfo.field_md5 = paramfeb.Md5;
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    try
    {
      amn localamn = new amn();
      localamn.parseFrom(paramfeb.abDF.aaxD.Op);
      d.a(localamn, localEmojiInfo);
      localEmojiInfo.field_temp = 1;
      localEmojiInfo.field_catalog = EmojiInfo.aklG;
      label89:
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    catch (Exception paramfeb)
    {
      break label89;
    }
  }
  
  public static List<SnsInfo> a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(309426);
    w localw = al.hgB();
    paramString1 = "select *,rowid from SnsInfo " + w.dd(paramString1, paramBoolean);
    String str = paramString1 + " AND type in ( 1 , 15)";
    paramString1 = str;
    if (w.bad(paramString2)) {
      paramString1 = str + " AND " + localw.bah(paramString2);
    }
    paramString2 = paramString1;
    if (w.bad(paramString3)) {
      paramString2 = paramString1 + " AND " + localw.bae(paramString3);
    }
    if (paramBoolean) {}
    for (paramString1 = paramString2 + w.QYZ;; paramString1 = paramString2 + w.QZa)
    {
      paramString1 = paramString1 + " LIMIT 10";
      Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserNameLimitSeqInterval in gallery ".concat(String.valueOf(paramString1)));
      paramString1 = localw.QYR.rawQuery(paramString1, null);
      paramString2 = new ArrayList();
      if (paramString1.getCount() != 0) {
        break;
      }
      paramString1.close();
      AppMethodBeat.o(309426);
      return paramString2;
    }
    if (paramString1.moveToFirst()) {
      do
      {
        paramString3 = new SnsInfo();
        paramString3.convertFrom(paramString1);
        paramString2.add(paramString3);
      } while (paramString1.moveToNext());
    }
    paramString1.close();
    AppMethodBeat.o(309426);
    return paramString2;
  }
  
  public static List<SnsInfo> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(95857);
    if (paramBoolean2) {}
    for (paramString1 = al.hgB().a(false, paramString1, 10, paramBoolean1, paramString2, 0, 0);; paramString1 = al.hgB().j(paramString1, paramBoolean1, paramString2))
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
  
  private static void a(int paramInt, String paramString1, String paramString2, LinkedList<SnsObject> paramLinkedList, List<Long> paramList)
  {
    AppMethodBeat.i(309476);
    String str = t.aXy(t.uA(((SnsObject)paramLinkedList.getLast()).Id));
    Log.i("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString1 + "  -  " + str);
    w localw;
    if (paramInt == 2)
    {
      localw = al.hgB();
      paramLinkedList = w.hkY();
      if (paramString1 != null)
      {
        paramString2 = paramLinkedList;
        if (paramString1.equals("")) {}
      }
      else
      {
        paramString2 = paramLinkedList + " AND " + localw.bah(paramString1);
      }
      paramString1 = paramString2;
      if (w.bad(str)) {
        paramString1 = paramString2 + " AND " + localw.bae(str);
      }
      Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramString1)));
      paramString1 = localw.QYR.rawQuery(paramString1, null);
    }
    while (paramString1 == null)
    {
      AppMethodBeat.o(309476);
      return;
      if (paramInt == 16)
      {
        paramString1 = al.hgB().mQ(paramString1, str);
      }
      else if (paramInt == 128)
      {
        paramString1 = al.hgB().bc(null, paramString1, str);
      }
      else
      {
        localw = al.hgB();
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          paramLinkedList = w.de(paramString2, bool);
          paramString2 = paramLinkedList;
          if (w.bad(paramString1)) {
            paramString2 = paramLinkedList + " AND " + localw.bah(paramString1);
          }
          paramString1 = paramString2;
          if (w.bad(str)) {
            paramString1 = paramString2 + " AND " + localw.bae(str);
          }
          Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramString1)));
          paramString1 = localw.QYR.rawQuery(paramString1, null);
          break;
        }
      }
    }
    if (!paramString1.moveToFirst())
    {
      paramString1.close();
      AppMethodBeat.o(309476);
      return;
    }
    for (;;)
    {
      paramString2 = new SnsInfo();
      paramString2.convertFrom(paramString1);
      long l = paramString2.field_snsId;
      if (paramString2.isWaitPost()) {
        Log.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
      }
      while (!paramString1.moveToNext())
      {
        paramString1.close();
        AppMethodBeat.o(309476);
        return;
        if (paramString2.isDieItem())
        {
          Log.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!paramList.contains(Long.valueOf(l)))
        {
          paramString2.removeSourceFlag(paramInt);
          al.hgB().b(l, paramString2);
          if (paramInt == 2) {
            al.hgL().vo(l);
          }
          Log.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt + ", snsIdStr=" + t.uA(l));
        }
      }
    }
  }
  
  public static void a(String paramString1, int paramInt, LinkedList<SnsObject> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(95871);
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      AppMethodBeat.o(95871);
      return;
    }
    Object localObject3 = al.hgB();
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    int i;
    Object localObject2;
    Object localObject1;
    label263:
    while (localIterator.hasNext())
    {
      SnsObject localSnsObject = (SnsObject)localIterator.next();
      if (localSnsObject == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label263;
        }
        localObject2 = ((w)localObject3).vj(localSnsObject.Id);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SnsInfo();
        }
        if (a((SnsInfo)localObject1, localSnsObject, paramString1, paramInt) == 0L) {
          break;
        }
        if ((localLinkedList.size() < 3) && ((((SnsInfo)localObject1).getTypeFlag() == 1) || (((SnsInfo)localObject1).getTypeFlag() == 15))) {
          localLinkedList.add(t.uA(((SnsInfo)localObject1).field_snsId));
        }
        localArrayList.add(Long.valueOf(localSnsObject.Id));
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
      localObject1 = al.hgF().aZW(paramString1);
      if (localObject1 != null) {}
      for (localObject1 = ((u)localObject1).field_newerIds;; localObject1 = "")
      {
        localObject1 = Util.stringsToList(Util.nullAs((String)localObject1, "").split(","));
        Log.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + kz(localLinkedList));
        while ((localLinkedList.size() < 3) && (((List)localObject1).size() > 0))
        {
          localObject2 = (String)((List)localObject1).remove(0);
          if (localObject2 != null)
          {
            localObject3 = localLinkedList.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              i = ((String)localObject2).compareTo((String)((Iterator)localObject3).next());
              if (i != 0) {
                if (i > 0) {
                  localLinkedList.add(0, localObject2);
                }
              }
            }
            if (!localLinkedList.contains(localObject2)) {
              localLinkedList.add(localObject2);
            }
          }
        }
      }
      Log.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + kz(localLinkedList));
      al.hgF().mP(paramString1, kz(localLinkedList));
    }
    a(paramInt, paramString2, paramString1, paramLinkedList, localArrayList);
    paramString1 = al.hgN();
    Log.i("MicroMsg.SnsUnreadTipManager", "checkRemoveFeed");
    al.fAG().post(new ax.4(paramString1, localArrayList));
    AppMethodBeat.o(95871);
  }
  
  public static boolean a(long paramLong, fdq paramfdq)
  {
    AppMethodBeat.i(95865);
    fdp localfdp = paramfdq.abDp;
    if ((localfdp.vhJ != 1) && (localfdp.vhJ != 2))
    {
      AppMethodBeat.o(95865);
      return true;
    }
    SnsInfo localSnsInfo = al.hgB().vj(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95865);
      return true;
    }
    if ((localSnsInfo.getTypeFlag() == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.hfn()))
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
        if (localfdp.vhJ != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localfdv = (fdv)localIterator.next();
          if (localfdv.CreateTime != localfdp.CreateTime) {
            continue;
          }
          bool = localfdv.Username.equals(localfdp.abnl);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(95865);
          return true;
        }
        localSnsObject.LikeUserList.add(ai.b(paramfdq));
        localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
        al.hgB().a(localSnsObject.Id, localSnsInfo);
      }
      catch (Exception paramfdq)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        fdv localfdv;
        boolean bool;
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramfdq, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95865);
      return true;
      if (localfdp.vhJ == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localfdv = (fdv)localIterator.next();
          if (localfdv.CreateTime == localfdp.CreateTime)
          {
            bool = localfdv.Username.equals(localfdp.abnl);
            if (bool)
            {
              AppMethodBeat.o(95865);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ai.b(paramfdq));
        }
      }
    }
  }
  
  public static SnsInfo aYv(String paramString)
  {
    AppMethodBeat.i(95859);
    paramString = al.hgB().a(true, paramString, 1, false, "", 0, 0);
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
  
  public static String aYw(String paramString)
  {
    AppMethodBeat.i(95875);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = al.hgI().Fv();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        ac localac = new ac();
        localac.convertFrom((Cursor)localObject);
        localLinkedList.add(Util.nullAs(localac.field_tagName, ""));
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
  
  public static List<bzi> aYx(String paramString)
  {
    AppMethodBeat.i(95880);
    ArrayList localArrayList = new ArrayList();
    if (al.isInValid())
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    Object localObject1 = l.aZL(paramString);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    TimeLineObject localTimeLineObject = ((SnsInfo)localObject1).getTimeLine();
    if ((localTimeLineObject.ContentObj == null) || (localTimeLineObject.ContentObj.Zpr.size() == 0))
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localArrayList.clear();
    Object localObject3;
    if (((SnsInfo)localObject1).getTypeFlag() == 7)
    {
      localObject1 = null;
      Iterator localIterator = localTimeLineObject.ContentObj.Zpr.iterator();
      if (localIterator.hasNext())
      {
        localObject3 = (dmz)localIterator.next();
        if (((dmz)localObject3).vhJ != 2) {
          break label322;
        }
        localObject2 = localObject3;
        if (localObject1 != null) {
          if (((dmz)localObject3).aaTn.aaUc <= ((dmz)localObject1).aaTn.aaUc) {
            break label322;
          }
        }
      }
    }
    label322:
    for (Object localObject2 = localObject3;; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if (localObject1 != null)
      {
        localObject2 = new bzi();
        ((bzi)localObject2).ibT = ((dmz)localObject1);
        ((bzi)localObject2).parentId = paramString;
        ((bzi)localObject2).createTime = localTimeLineObject.CreateTime;
        ((bzi)localObject2).aaiz = 0;
        localArrayList.add(localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(95880);
        return localArrayList;
        localObject1 = localTimeLineObject.ContentObj.Zpr.iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dmz)((Iterator)localObject1).next();
          localObject3 = new bzi();
          ((bzi)localObject3).ibT = ((dmz)localObject2);
          ((bzi)localObject3).parentId = paramString;
          ((bzi)localObject3).createTime = localTimeLineObject.CreateTime;
          ((bzi)localObject3).aaiz = i;
          localArrayList.add(localObject3);
          i += 1;
        }
      }
    }
  }
  
  public static List<bzi> aYy(String paramString)
  {
    AppMethodBeat.i(309484);
    ArrayList localArrayList = new ArrayList();
    if (al.isInValid())
    {
      AppMethodBeat.o(309484);
      return localArrayList;
    }
    paramString = al.hgB().aZK(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(309484);
      return localArrayList;
    }
    TimeLineObject localTimeLineObject = paramString.getTimeLine();
    if ((localTimeLineObject.ContentObj == null) || (localTimeLineObject.ContentObj.Zpr.size() == 0))
    {
      AppMethodBeat.o(309484);
      return localArrayList;
    }
    localArrayList.clear();
    Object localObject2;
    if (paramString.getTypeFlag() == 7)
    {
      paramString = null;
      Iterator localIterator = localTimeLineObject.ContentObj.Zpr.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (dmz)localIterator.next();
        if (((dmz)localObject2).vhJ != 2) {
          break label316;
        }
        localObject1 = localObject2;
        if (paramString != null) {
          if (((dmz)localObject2).aaTn.aaUc <= paramString.aaTn.aaUc) {
            break label316;
          }
        }
      }
    }
    label316:
    for (Object localObject1 = localObject2;; localObject1 = paramString)
    {
      paramString = (String)localObject1;
      break;
      if (paramString != null)
      {
        localObject1 = new bzi();
        ((bzi)localObject1).ibT = paramString;
        ((bzi)localObject1).parentId = "";
        ((bzi)localObject1).createTime = localTimeLineObject.CreateTime;
        ((bzi)localObject1).aaiz = 0;
        localArrayList.add(localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(309484);
        return localArrayList;
        paramString = localTimeLineObject.ContentObj.Zpr.iterator();
        int i = 0;
        while (paramString.hasNext())
        {
          localObject1 = (dmz)paramString.next();
          localObject2 = new bzi();
          ((bzi)localObject2).ibT = ((dmz)localObject1);
          ((bzi)localObject2).parentId = "";
          ((bzi)localObject2).createTime = localTimeLineObject.CreateTime;
          ((bzi)localObject2).aaiz = i;
          localArrayList.add(localObject2);
          i += 1;
        }
      }
    }
  }
  
  public static boolean akH(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public static boolean akI(int paramInt)
  {
    AppMethodBeat.i(95872);
    Log.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    SnsInfo localSnsInfo = al.hgB().alB(paramInt);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95872);
      return false;
    }
    localSnsInfo.clearItemDie();
    localSnsInfo.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    dnc localdnc = null;
    for (;;)
    {
      try
      {
        localObject = (dna)new dna().parseFrom(localSnsInfo.getPostBuf());
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((dna)localObject).nrQ = 0;
          ((dna)localObject).aaTL = System.currentTimeMillis();
          localSnsInfo.setPostBuf(((dna)localObject).toByteArray());
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
            com.tencent.mm.plugin.sns.storage.z localz;
            continue;
            paramInt += 1;
          }
        }
        localException2 = localException2;
        localObject = localdnc;
      }
    }
    al.hgB().f(paramInt, localSnsInfo);
    paramInt = 0;
    if (paramInt < ((dna)localObject).aaTI.size())
    {
      i = ((djp)((dna)localObject).aaTI.get(paramInt)).aaPC;
      localz = al.hgq().vk(i);
      if (localz != null)
      {
        localz.offset = 0;
        try
        {
          localdnc = (dnc)new dnc().parseFrom(localz.QZv);
          if (localdnc.aaPu == 0) {
            break label284;
          }
          localdnc.aaPu = 2;
          localdnc.aaUh = "";
          localz.QZv = localdnc.toByteArray();
          al.hgq().a(i, localz);
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
  
  public static void akJ(int paramInt)
  {
    AppMethodBeat.i(95882);
    Log.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    SnsInfo localSnsInfo = al.hgB().alB(paramInt);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95882);
      return;
    }
    localSnsInfo.unsetOmittedFailResend();
    al.hgB().f(paramInt, localSnsInfo);
    AppMethodBeat.o(95882);
  }
  
  public static List<SnsInfo> ay(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(160673);
    w localw = al.hgB();
    Object localObject2 = w.hle();
    Object localObject1 = localObject2;
    if (w.bad(paramString)) {
      localObject1 = (String)localObject2 + " AND " + localw.bae(paramString);
    }
    if (paramBoolean) {}
    for (paramString = (String)localObject1 + w.QYZ;; paramString = (String)localObject1 + w.QZa)
    {
      Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString)));
      paramString = localw.QYR.rawQuery(paramString, null);
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
  
  public static gol b(gol paramgol, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95869);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        gol localgol = ((SnsObject)new SnsObject().parseFrom(paramArrayOfByte)).ObjectOperations;
        if (paramgol == null)
        {
          AppMethodBeat.o(95869);
          return localgol;
        }
        fer localfer = new fer();
        paramArrayOfByte = localfer;
        if (localgol != null) {
          paramArrayOfByte = (fer)localfer.parseFrom(localgol.aaxD.Op);
        }
        paramgol = (fer)new fer().parseFrom(paramgol.aaxD.Op);
        if (paramgol.abEg == null) {
          paramgol.abEg = paramArrayOfByte.abEg;
        }
        if (paramArrayOfByte.abEf == null)
        {
          paramgol.abEf = null;
          paramgol = paramgol.toByteArray();
          paramgol = new gol().df(paramgol);
          AppMethodBeat.o(95869);
          return paramgol;
        }
        if (paramgol.abEf == null)
        {
          paramgol.abEf = paramArrayOfByte.abEf;
          continue;
          localgol = null;
        }
      }
      catch (Exception paramgol)
      {
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramgol, "", new Object[0]);
        AppMethodBeat.o(95869);
        return null;
      }
    }
  }
  
  public static void b(long paramLong, fdq paramfdq)
  {
    AppMethodBeat.i(95863);
    paramfdq = paramfdq.abDp;
    if (paramfdq.vhJ != 9)
    {
      AppMethodBeat.o(95863);
      return;
    }
    SnsInfo localSnsInfo = al.hgB().vj(paramLong);
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
        fdv localfdv = (fdv)localIterator.next();
        if ((localfdv.abDh == paramfdq.abDh) && (!Util.isNullOrNil(localfdv.Username)) && (localfdv.Username.equals(paramfdq.abnl))) {
          localSnsObject.CommentUserList.remove(localfdv);
        }
      }
      localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
      al.hgB().a(localSnsObject.Id, localSnsInfo);
      AppMethodBeat.o(95863);
      return;
    }
    catch (Exception paramfdq)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramfdq, "", new Object[0]);
      AppMethodBeat.o(95863);
    }
  }
  
  public static boolean bG(int paramInt, boolean paramBoolean)
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
  
  public static void c(long paramLong, fdq paramfdq)
  {
    AppMethodBeat.i(309447);
    Log.i("MicroMsg.SnsInfoStorageLogic", "deleteComment");
    paramfdq = paramfdq.abDp;
    if (paramfdq.vhJ != 9)
    {
      AppMethodBeat.o(309447);
      return;
    }
    SnsInfo localSnsInfo = al.hgB().vj(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(309447);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      fdv localfdv;
      while (localIterator.hasNext())
      {
        localfdv = (fdv)localIterator.next();
        if ((localfdv.abDh == paramfdq.abDh) && (!Util.isNullOrNil(localfdv.Username)))
        {
          if ((!localfdv.Username.equals(paramfdq.abnl)) && (localfdv.Username.equals(com.tencent.mm.model.z.bAM()))) {
            break label241;
          }
          Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, removeComment:%s", new Object[] { localfdv.Username, paramfdq.abnl, Integer.valueOf(localfdv.abDh) });
          localSnsObject.CommentUserList.remove(localfdv);
        }
      }
      for (;;)
      {
        localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
        al.hgB().a(localSnsObject.Id, localSnsInfo);
        AppMethodBeat.o(309447);
        return;
        label241:
        if (localfdv.Username.equals(com.tencent.mm.model.z.bAM()))
        {
          Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, markDeleteFlag:%s", new Object[] { localfdv.Username, paramfdq.abnl, Integer.valueOf(localfdv.abDh) });
          localfdv.DeleteFlag = 1;
        }
      }
      return;
    }
    catch (Exception paramfdq)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramfdq, "", new Object[0]);
      AppMethodBeat.o(309447);
    }
  }
  
  private static void c(SnsInfo paramSnsInfo, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(309473);
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
        if (Qwt == -1L) {
          Qwt = ((c)h.ax(c.class)).a(c.a.zfk, 86400);
        }
        str = com.tencent.mm.model.z.bAM();
        l = cn.getSyncServerTimeSecond();
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
          paramSnsInfo.add(Integer.valueOf(((fdv)((Iterator)localObject1).next()).abDh));
        }
        localObject1 = new ArrayList();
      }
      catch (Exception paramSnsInfo)
      {
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSnsInfo, "", new Object[0]);
        AppMethodBeat.o(309473);
        return;
      }
      Object localObject2 = ((SnsObject)localObject2).CommentUserList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        fdv localfdv = (fdv)((Iterator)localObject2).next();
        if ((Util.isEqual(localfdv.Username, str)) && (localfdv.DeleteFlag > 0)) {
          if (l - localfdv.CreateTime > Qwt)
          {
            Log.i("MicroMsg.SnsInfoStorageLogic", "it's time to delete local comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localfdv.abDh), localfdv.Username });
          }
          else if (!paramSnsInfo.contains(Integer.valueOf(localfdv.abDh)))
          {
            Log.i("MicroMsg.SnsInfoStorageLogic", "insert a local fake comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localfdv.abDh), localfdv.Username });
            ((List)localObject1).add(localfdv);
          }
        }
      }
      if (!Util.isNullOrNil((List)localObject1)) {
        paramSnsObject.CommentUserList.addAll((Collection)localObject1);
      }
      Collections.sort(paramSnsObject.CommentUserList, new Comparator() {});
    }
    label395:
    AppMethodBeat.o(309473);
  }
  
  public static dmz d(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(95878);
    if (al.isInValid())
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
    if ((paramSnsInfo.ContentObj == null) || (paramSnsInfo.ContentObj.Zpr.size() == 0) || (paramSnsInfo.ContentObj.Zpr.size() <= paramInt))
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramSnsInfo = (dmz)paramSnsInfo.ContentObj.Zpr.get(paramInt);
    AppMethodBeat.o(95878);
    return paramSnsInfo;
  }
  
  public static void d(long paramLong, fdq paramfdq)
  {
    AppMethodBeat.i(95864);
    paramfdq = paramfdq.abDp;
    if (paramfdq.vhJ != 13)
    {
      AppMethodBeat.o(95864);
      return;
    }
    SnsInfo localSnsInfo = al.hgB().vj(paramLong);
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
        localSnsObject.SnsRedEnvelops = new fez();
      }
      if (paramfdq.vhJ == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.abEG.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((fef)((Iterator)localObject).next()).Username.equals(paramfdq.abnl);
          if (bool)
          {
            AppMethodBeat.o(95864);
            return;
          }
        }
        localObject = new fef();
        ((fef)localObject).abDk = paramfdq.abDk;
        ((fef)localObject).CreateTime = paramfdq.CreateTime;
        ((fef)localObject).Username = paramfdq.abnl;
        localSnsObject.SnsRedEnvelops.abEG.add(localObject);
        localSnsObject.SnsRedEnvelops.abEF = localSnsObject.SnsRedEnvelops.abEG.size();
      }
      localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
      al.hgB().a(localSnsObject.Id, localSnsInfo);
      AppMethodBeat.o(95864);
      return;
    }
    catch (Exception paramfdq)
    {
      Log.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramfdq.getMessage());
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramfdq, "", new Object[0]);
      AppMethodBeat.o(95864);
    }
  }
  
  public static long h(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95866);
    SnsInfo localSnsInfo2 = al.hgB().vj(paramSnsObject.Id);
    SnsInfo localSnsInfo1 = localSnsInfo2;
    if (localSnsInfo2 == null) {
      localSnsInfo1 = new SnsInfo();
    }
    long l = a(localSnsInfo1, paramSnsObject, "", 0);
    AppMethodBeat.o(95866);
    return l;
  }
  
  public static void hhb()
  {
    AppMethodBeat.i(95860);
    if (Qwu != null) {
      Qwu.clear();
    }
    AppMethodBeat.o(95860);
  }
  
  public static List<SnsInfo> hhc()
  {
    AppMethodBeat.i(309479);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = al.hgB();
    Object localObject2 = w.hla() + " AND " + w.QZd + " AND  (snsId = 0  ) ";
    localObject1 = ((w)localObject1).QYR.rawQuery((String)localObject2, null);
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(309479);
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
    AppMethodBeat.o(309479);
    return localArrayList;
  }
  
  public static void hhd()
  {
    AppMethodBeat.i(95883);
    Cursor localCursor = al.hgB().u("", "", 0, 0);
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
  
  public static void hhe()
  {
    maxId = 0L;
    Qsh = 0L;
  }
  
  public static List<bzi> kA(List<String> paramList)
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
      bzi localbzi = new bzi();
      dmz localdmz = new dmz();
      localdmz.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localbzi.ibT = localdmz;
      localbzi.parentId = "";
      localbzi.aaiz = i;
      localArrayList.add(localbzi);
      i += 1;
    }
    AppMethodBeat.o(95881);
    return localArrayList;
  }
  
  private static String kz(List<String> paramList)
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
  
  public static List<bzi> me(String paramString1, String paramString2)
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
      if (y.ZC((String)localObject2))
      {
        paramString1 = y.bi((String)localObject2, 0, (int)y.bEl((String)localObject2));
        paramString1 = (en)new en().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        y.deleteFile((String)localObject2);
        paramString2 = a.aZi(new String(y.bi((String)localObject3, 0, (int)y.bEl((String)localObject3))));
        y.f((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (cxu)paramString1.next();
        paramString2 = ((cxu)localObject1).IGU;
        localObject1 = ((cxu)localObject1).Zpr.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (dmz)((Iterator)localObject1).next();
          ((dmz)localObject2).IGG = paramString2;
          localObject3 = new bzi();
          ((bzi)localObject3).ibT = ((dmz)localObject2);
          ((bzi)localObject3).parentId = "";
          ((bzi)localObject3).aaiz = j;
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
  
  public static List<SnsInfo> mf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95884);
    paramString1 = al.hgB().mQ(paramString1, paramString2);
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
  
  public static void n(LinkedList<SnsObject> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(95885);
    if (paramInt == ay.Qyz)
    {
      maxId = ((SnsObject)paramLinkedList.getFirst()).Id;
      Qsh = ((SnsObject)paramLinkedList.getLast()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == ay.QyA)
    {
      maxId = ((SnsObject)paramLinkedList.getFirst()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == ay.QyB) {
      Qsh = ((SnsObject)paramLinkedList.getLast()).Id;
    }
    AppMethodBeat.o(95885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */