package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.dnm;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
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
  public static long JVf;
  public static long JVg;
  public static final Map<Long, SnsInfo> JZi;
  public static long JZj;
  public static int JZk;
  private static long JZl;
  private static Map<String, SnsObject> JZm;
  
  static
  {
    AppMethodBeat.i(95886);
    JZi = new TreeMap(new an.1());
    JVf = 0L;
    JVg = 0L;
    JZj = 0L;
    JZk = 0;
    JZl = -1L;
    JZm = new ConcurrentHashMap();
    AppMethodBeat.o(95886);
  }
  
  public static SnsObject C(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95861);
    try
    {
      paramSnsInfo = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      paramSnsInfo = aj.fOH().f(paramSnsInfo);
      JZm.clear();
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
  
  public static SnsObject D(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95862);
    try
    {
      if (paramSnsInfo.contentByteMd5 == null) {
        paramSnsInfo.contentByteMd5 = (com.tencent.mm.b.g.getMessageDigest(paramSnsInfo.field_content) + com.tencent.mm.b.g.getMessageDigest(paramSnsInfo.field_attrBuf));
      }
      if (JZm.containsKey(paramSnsInfo.contentByteMd5))
      {
        localSnsObject = (SnsObject)JZm.get(paramSnsInfo.contentByteMd5);
        if (localSnsObject != null)
        {
          aj.fOH().f(localSnsObject);
          AppMethodBeat.o(95862);
          return localSnsObject;
        }
      }
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      JZm.put(paramSnsInfo.contentByteMd5, localSnsObject);
      aj.fOH().f(localSnsObject);
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
  
  public static List<SnsInfo> J(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(160673);
    n localn = aj.fOI();
    Object localObject2 = n.fSS();
    Object localObject1 = localObject2;
    if (n.bbw(paramString)) {
      localObject1 = (String)localObject2 + " AND " + localn.bbx(paramString);
    }
    if (paramBoolean) {}
    for (paramString = (String)localObject1 + n.KzG;; paramString = (String)localObject1 + n.KzH)
    {
      Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(paramString)));
      paramString = localn.lvy.rawQuery(paramString, null);
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
  
  public static boolean PE(String paramString)
  {
    AppMethodBeat.i(95873);
    boolean bool = z.bcZ().equals(paramString.trim());
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
    if (!aj.fOH().QJ(((SnsInfo)localObject1).field_snsId))
    {
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
    }
    if (paramSnsObject.NoChange != 0)
    {
      Log.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + paramSnsObject.Id + "  " + com.tencent.mm.plugin.sns.data.t.Qu(paramSnsObject.Id));
      if (((SnsInfo)localObject1).isSourceExist(paramInt)) {
        break label1075;
      }
      ((SnsInfo)localObject1).addSourceFlag(paramInt);
    }
    label1069:
    label1075:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0) {
        aj.fOI().a(paramSnsObject.Id, (SnsInfo)localObject1);
      }
      l = paramSnsObject.Id;
      AppMethodBeat.o(95867);
      return l;
      paramSnsInfo = paramSnsObject.CommentUserList;
      Log.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[] { Long.valueOf(paramSnsObject.Id), Integer.valueOf(paramSnsInfo.size()), com.tencent.mm.plugin.sns.data.t.Qu(paramSnsObject.Id) });
      if ((paramSnsObject.ObjectDesc == null) || (paramSnsObject.ObjectDesc.Tkb == null))
      {
        Log.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
        l = paramSnsObject.Id;
        AppMethodBeat.o(95867);
        return l;
      }
      paramSnsInfo = new String(paramSnsObject.ObjectDesc.Tkb.toByteArray());
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
      paramSnsObject.ObjectDesc.dc(new byte[0]);
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
          eln localeln;
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
          ((SnsInfo)localObject1).setTypeFlag(paramSnsInfo.ContentObj.Sqq);
          ((SnsInfo)localObject1).setSubTypeFlag(paramSnsInfo.ContentObj.Sqs);
          aj.fOI().a(paramSnsObject.Id, (SnsInfo)localObject1);
          paramSnsInfo = paramSnsObject.CommentUserList.iterator();
          if (!paramSnsInfo.hasNext()) {
            continue;
          }
          paramString = ((ejo)paramSnsInfo.next()).Uls.iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          localObject1 = a((eju)paramString.next());
          if (bj.hyV().VFH.bxK(((EmojiInfo)localObject1).field_md5) != null) {
            continue;
          }
          bj.hyV().VFH.L((EmojiInfo)localObject1);
          Object localObject2 = e.jGI;
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
            if ((paramSnsInfo != null) && (paramSnsInfo.PreDownloadInfo != null) && (paramSnsInfo.PreDownloadInfo.TUL > 0))
            {
              paramSnsObject.PreDownloadInfo = paramSnsInfo.PreDownloadInfo;
              Log.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[] { Integer.valueOf(paramSnsObject.PreDownloadInfo.TUL), Integer.valueOf(paramSnsObject.PreDownloadInfo.TUM), paramSnsObject.PreDownloadInfo.TUN, Long.valueOf(Util.ticksToNow(l)) });
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
          break label832;
        }
        ((SnsInfo)localObject1).setExtFlag();
        if (!afS(paramSnsObject.ExtFlag)) {
          break label877;
        }
        ((SnsInfo)localObject1).addSourceFlag(128);
        localObject2 = aj.fOR().Rh(paramSnsObject.Id);
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.u)localObject2).field_groupStrcut)) {
            localeln = new eln();
          }
        }
      }
      for (;;)
      {
        try
        {
          localeln.parseFrom(((com.tencent.mm.plugin.sns.storage.u)localObject2).field_groupStrcut);
          boolean bool = Util.isNullOrNil(localeln.UnE);
          if (bool) {
            break label1069;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          label832:
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
            break label885;
          }
          Log.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
          AppMethodBeat.o(95867);
          return 0L;
        }
        label877:
        label885:
        i = 0;
      }
    }
  }
  
  public static cvt a(SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(95879);
    paramSnsInfo = paramSnsInfo.getTimeLine();
    if ((paramSnsInfo.ContentObj == null) || (paramSnsInfo.ContentObj.Sqr.size() == 0))
    {
      AppMethodBeat.o(95879);
      return null;
    }
    paramSnsInfo = paramSnsInfo.ContentObj.Sqr.iterator();
    while (paramSnsInfo.hasNext())
    {
      cvt localcvt = (cvt)paramSnsInfo.next();
      if (localcvt.Id.equals(paramString))
      {
        AppMethodBeat.o(95879);
        return localcvt;
      }
    }
    AppMethodBeat.o(95879);
    return null;
  }
  
  public static EmojiInfo a(eju parameju)
  {
    AppMethodBeat.i(95868);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    if (parameju == null)
    {
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    if (parameju.UlK == null)
    {
      localEmojiInfo.field_md5 = parameju.Md5;
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    try
    {
      aji localaji = new aji();
      localaji.parseFrom(parameju.UlK.Tkb.UH);
      com.tencent.mm.plugin.emoji.i.b.a(localaji, localEmojiInfo);
      localEmojiInfo.field_temp = 1;
      localEmojiInfo.field_catalog = EmojiInfo.YCx;
      label89:
      AppMethodBeat.o(95868);
      return localEmojiInfo;
    }
    catch (Exception parameju)
    {
      break label89;
    }
  }
  
  public static List<SnsInfo> a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(95857);
    if (paramBoolean2) {}
    for (paramString1 = aj.fOI().a(false, paramString1, 10, paramBoolean1, paramString2);; paramString1 = aj.fOI().f(paramString1, paramBoolean1, paramString2))
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
    AppMethodBeat.i(197576);
    String str = com.tencent.mm.plugin.sns.data.t.aZn(com.tencent.mm.plugin.sns.data.t.Qu(((SnsObject)paramLinkedList.getLast()).Id));
    Log.i("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + paramString1 + "  -  " + str);
    n localn;
    if (paramInt == 2)
    {
      localn = aj.fOI();
      paramLinkedList = n.fSM();
      if (paramString1 != null)
      {
        paramString2 = paramLinkedList;
        if (paramString1.equals("")) {}
      }
      else
      {
        paramString2 = paramLinkedList + " AND " + localn.bbA(paramString1);
      }
      paramString1 = paramString2;
      if (n.bbw(str)) {
        paramString1 = paramString2 + " AND " + localn.bbx(str);
      }
      Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramString1)));
      paramString1 = localn.lvy.rawQuery(paramString1, null);
    }
    while (paramString1 == null)
    {
      AppMethodBeat.o(197576);
      return;
      if (paramInt == 16)
      {
        paramString1 = aj.fOI().lh(paramString1, str);
      }
      else if (paramInt == 128)
      {
        paramString1 = aj.fOI().aK(null, paramString1, str);
      }
      else
      {
        localn = aj.fOI();
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          paramLinkedList = n.cB(paramString2, bool);
          paramString2 = paramLinkedList;
          if (n.bbw(paramString1)) {
            paramString2 = paramLinkedList + " AND " + localn.bbA(paramString1);
          }
          paramString1 = paramString2;
          if (n.bbw(str)) {
            paramString1 = paramString2 + " AND " + localn.bbx(str);
          }
          Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(paramString1)));
          paramString1 = localn.lvy.rawQuery(paramString1, null);
          break;
        }
      }
    }
    if (!paramString1.moveToFirst())
    {
      paramString1.close();
      AppMethodBeat.o(197576);
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
        AppMethodBeat.o(197576);
        return;
        if (paramString2.isDieItem())
        {
          Log.d("MicroMsg.SnsInfoStorageLogic", "die one ");
        }
        else if (!paramList.contains(Long.valueOf(l)))
        {
          paramString2.removeSourceFlag(paramInt);
          aj.fOI().b(l, paramString2);
          if (paramInt == 2) {
            aj.fOR().Ri(l);
          }
          Log.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + l + " source " + paramInt + ", snsIdStr=" + com.tencent.mm.plugin.sns.data.t.Qu(l));
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
    Object localObject3 = aj.fOI();
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
        localObject2 = ((n)localObject3).Rd(localSnsObject.Id);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SnsInfo();
        }
        if (a((SnsInfo)localObject1, localSnsObject, paramString1, paramInt) == 0L) {
          break;
        }
        if ((localLinkedList.size() < 3) && ((((SnsInfo)localObject1).getTypeFlag() == 1) || (((SnsInfo)localObject1).getTypeFlag() == 15))) {
          localLinkedList.add(com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject1).field_snsId));
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
      localObject1 = aj.fOM().bbr(paramString1);
      if (localObject1 != null) {}
      for (localObject1 = ((l)localObject1).field_newerIds;; localObject1 = "")
      {
        localObject1 = Util.stringsToList(Util.nullAs((String)localObject1, "").split(","));
        Log.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + hy(localLinkedList));
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
      Log.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + hy(localLinkedList));
      aj.fOM().lg(paramString1, hy(localLinkedList));
    }
    a(paramInt, paramString2, paramString1, paramLinkedList, localArrayList);
    paramString1 = aj.fOT();
    Log.i("MicroMsg.SnsUnreadTipManager", "checkRemoveFeed");
    aj.etE().post(new av.4(paramString1, localArrayList));
    AppMethodBeat.o(95871);
  }
  
  public static boolean a(long paramLong, ejj paramejj)
  {
    AppMethodBeat.i(95865);
    eji localeji = paramejj.Ulv;
    if ((localeji.rWu != 1) && (localeji.rWu != 2))
    {
      AppMethodBeat.o(95865);
      return true;
    }
    SnsInfo localSnsInfo = aj.fOI().Rd(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95865);
      return true;
    }
    if ((localSnsInfo.getTypeFlag() == 21) && (!com.tencent.mm.plugin.sns.lucky.a.g.fNC()))
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
        if (localeji.rWu != 1) {
          continue;
        }
        localIterator = localSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localejo = (ejo)localIterator.next();
          if (localejo.CreateTime != localeji.CreateTime) {
            continue;
          }
          bool = localejo.Username.equals(localeji.TWw);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(95865);
          return true;
        }
        localSnsObject.LikeUserList.add(ag.b(paramejj));
        localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
        aj.fOI().a(localSnsObject.Id, localSnsInfo);
      }
      catch (Exception paramejj)
      {
        SnsObject localSnsObject;
        Iterator localIterator;
        ejo localejo;
        boolean bool;
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramejj, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(95865);
      return true;
      if (localeji.rWu == 2)
      {
        localIterator = localSnsObject.CommentUserList.iterator();
        if (localIterator.hasNext())
        {
          localejo = (ejo)localIterator.next();
          if (localejo.CreateTime == localeji.CreateTime)
          {
            bool = localejo.Username.equals(localeji.TWw);
            if (bool)
            {
              AppMethodBeat.o(95865);
              return true;
            }
          }
        }
        else
        {
          localSnsObject.CommentUserList.add(ag.b(paramejj));
        }
      }
    }
  }
  
  public static boolean aZ(int paramInt, boolean paramBoolean)
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
  
  public static boolean afS(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public static boolean afT(int paramInt)
  {
    AppMethodBeat.i(95872);
    Log.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(paramInt)));
    SnsInfo localSnsInfo = aj.fOI().agI(paramInt);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95872);
      return false;
    }
    localSnsInfo.clearItemDie();
    localSnsInfo.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    cvw localcvw = null;
    for (;;)
    {
      try
      {
        localObject = (cvu)new cvu().parseFrom(localSnsInfo.getPostBuf());
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", localException2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          ((cvu)localObject).kQn = 0;
          ((cvu)localObject).TEf = System.currentTimeMillis();
          localSnsInfo.setPostBuf(((cvu)localObject).toByteArray());
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
        localObject = localcvw;
      }
    }
    aj.fOI().d(paramInt, localSnsInfo);
    paramInt = 0;
    if (paramInt < ((cvu)localObject).TEc.size())
    {
      i = ((csn)((cvu)localObject).TEc.get(paramInt)).TAo;
      localq = aj.fOx().Re(i);
      if (localq != null)
      {
        localq.offset = 0;
        try
        {
          localcvw = (cvw)new cvw().parseFrom(localq.KAa);
          if (localcvw.TAg == 0) {
            break label284;
          }
          localcvw.TAg = 2;
          localcvw.TEA = "";
          localq.KAa = localcvw.toByteArray();
          aj.fOx().a(i, localq);
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
  
  public static void afU(int paramInt)
  {
    AppMethodBeat.i(95882);
    Log.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(paramInt)));
    SnsInfo localSnsInfo = aj.fOI().agI(paramInt);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(95882);
      return;
    }
    localSnsInfo.unsetOmittedFailResend();
    aj.fOI().d(paramInt, localSnsInfo);
    AppMethodBeat.o(95882);
  }
  
  public static eae b(eae parameae, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95869);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        eae localeae = ((SnsObject)new SnsObject().parseFrom(paramArrayOfByte)).ObjectOperations;
        if (parameae == null)
        {
          AppMethodBeat.o(95869);
          return localeae;
        }
        ekj localekj = new ekj();
        paramArrayOfByte = localekj;
        if (localeae != null) {
          paramArrayOfByte = (ekj)localekj.parseFrom(localeae.Tkb.UH);
        }
        parameae = (ekj)new ekj().parseFrom(parameae.Tkb.UH);
        if (parameae.Umf == null) {
          parameae.Umf = paramArrayOfByte.Umf;
        }
        if (paramArrayOfByte.Ume == null)
        {
          parameae.Ume = null;
          parameae = parameae.toByteArray();
          parameae = new eae().dc(parameae);
          AppMethodBeat.o(95869);
          return parameae;
        }
        if (parameae.Ume == null)
        {
          parameae.Ume = paramArrayOfByte.Ume;
          continue;
          localeae = null;
        }
      }
      catch (Exception parameae)
      {
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", parameae, "", new Object[0]);
        AppMethodBeat.o(95869);
        return null;
      }
    }
  }
  
  public static void b(long paramLong, ejj paramejj)
  {
    AppMethodBeat.i(95863);
    paramejj = paramejj.Ulv;
    if (paramejj.rWu != 9)
    {
      AppMethodBeat.o(95863);
      return;
    }
    SnsInfo localSnsInfo = aj.fOI().Rd(paramLong);
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
        ejo localejo = (ejo)localIterator.next();
        if ((localejo.Uln == paramejj.Uln) && (!Util.isNullOrNil(localejo.Username)) && (localejo.Username.equals(paramejj.TWw))) {
          localSnsObject.CommentUserList.remove(localejo);
        }
      }
      localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
      aj.fOI().a(localSnsObject.Id, localSnsInfo);
      AppMethodBeat.o(95863);
      return;
    }
    catch (Exception paramejj)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramejj, "", new Object[0]);
      AppMethodBeat.o(95863);
    }
  }
  
  public static SnsInfo baf(String paramString)
  {
    AppMethodBeat.i(95859);
    paramString = aj.fOI().a(true, paramString, 1, false, "");
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
  
  public static String bag(String paramString)
  {
    AppMethodBeat.i(95875);
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = aj.fOO().hK();
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        s locals = new s();
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
  
  public static List<com.tencent.mm.plugin.sns.j.b> bah(String paramString)
  {
    AppMethodBeat.i(95880);
    ArrayList localArrayList = new ArrayList();
    if (aj.isInValid())
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    Object localObject = com.tencent.mm.plugin.sns.storage.f.bbl(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localObject = ((SnsInfo)localObject).getTimeLine();
    if ((((TimeLineObject)localObject).ContentObj == null) || (((TimeLineObject)localObject).ContentObj.Sqr.size() == 0))
    {
      AppMethodBeat.o(95880);
      return localArrayList;
    }
    localArrayList.clear();
    Iterator localIterator = ((TimeLineObject)localObject).ContentObj.Sqr.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      cvt localcvt = (cvt)localIterator.next();
      com.tencent.mm.plugin.sns.j.b localb = new com.tencent.mm.plugin.sns.j.b();
      localb.fVT = localcvt;
      localb.parentId = paramString;
      localb.createTime = ((TimeLineObject)localObject).CreateTime;
      localb.KeQ = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95880);
    return localArrayList;
  }
  
  public static cvt c(SnsInfo paramSnsInfo, int paramInt)
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
    if ((paramSnsInfo.ContentObj == null) || (paramSnsInfo.ContentObj.Sqr.size() == 0) || (paramSnsInfo.ContentObj.Sqr.size() <= paramInt))
    {
      AppMethodBeat.o(95878);
      return null;
    }
    paramSnsInfo = (cvt)paramSnsInfo.ContentObj.Sqr.get(paramInt);
    AppMethodBeat.o(95878);
    return paramSnsInfo;
  }
  
  public static void c(long paramLong, ejj paramejj)
  {
    AppMethodBeat.i(197518);
    Log.i("MicroMsg.SnsInfoStorageLogic", "deleteComment");
    paramejj = paramejj.Ulv;
    if (paramejj.rWu != 9)
    {
      AppMethodBeat.o(197518);
      return;
    }
    SnsInfo localSnsInfo = aj.fOI().Rd(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(197518);
      return;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
      localSnsObject.Id = paramLong;
      Iterator localIterator = localSnsObject.CommentUserList.iterator();
      ejo localejo;
      while (localIterator.hasNext())
      {
        localejo = (ejo)localIterator.next();
        if ((localejo.Uln == paramejj.Uln) && (!Util.isNullOrNil(localejo.Username)))
        {
          if ((!localejo.Username.equals(paramejj.TWw)) && (localejo.Username.equals(z.bcZ()))) {
            break label241;
          }
          Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, removeComment:%s", new Object[] { localejo.Username, paramejj.TWw, Integer.valueOf(localejo.Uln) });
          localSnsObject.CommentUserList.remove(localejo);
        }
      }
      for (;;)
      {
        localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
        aj.fOI().a(localSnsObject.Id, localSnsInfo);
        AppMethodBeat.o(197518);
        return;
        label241:
        if (localejo.Username.equals(z.bcZ()))
        {
          Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, markDeleteFlag:%s", new Object[] { localejo.Username, paramejj.TWw, Integer.valueOf(localejo.Uln) });
          localejo.DeleteFlag = 1;
        }
      }
      return;
    }
    catch (Exception paramejj)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramejj, "", new Object[0]);
      AppMethodBeat.o(197518);
    }
  }
  
  private static void c(SnsInfo paramSnsInfo, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(197565);
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
        if (JZl == -1L) {
          JZl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNl, 86400);
        }
        str = z.bcZ();
        l = cm.bfF();
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
          paramSnsInfo.add(Integer.valueOf(((ejo)((Iterator)localObject1).next()).Uln));
        }
        localObject1 = new ArrayList();
      }
      catch (Exception paramSnsInfo)
      {
        Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramSnsInfo, "", new Object[0]);
        AppMethodBeat.o(197565);
        return;
      }
      Object localObject2 = ((SnsObject)localObject2).CommentUserList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ejo localejo = (ejo)((Iterator)localObject2).next();
        if ((Util.isEqual(localejo.Username, str)) && (localejo.DeleteFlag > 0)) {
          if (l - localejo.CreateTime > JZl)
          {
            Log.i("MicroMsg.SnsInfoStorageLogic", "it's time to delete local comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localejo.Uln), localejo.Username });
          }
          else if (!paramSnsInfo.contains(Integer.valueOf(localejo.Uln)))
          {
            Log.i("MicroMsg.SnsInfoStorageLogic", "insert a local fake comment deleted tip:[%s,%s]", new Object[] { Integer.valueOf(localejo.Uln), localejo.Username });
            ((List)localObject1).add(localejo);
          }
        }
      }
      if (!Util.isNullOrNil((List)localObject1)) {
        paramSnsObject.CommentUserList.addAll((Collection)localObject1);
      }
      Collections.sort(paramSnsObject.CommentUserList, new Comparator() {});
    }
    label395:
    AppMethodBeat.o(197565);
  }
  
  public static void d(long paramLong, ejj paramejj)
  {
    AppMethodBeat.i(95864);
    paramejj = paramejj.Ulv;
    if (paramejj.rWu != 13)
    {
      AppMethodBeat.o(95864);
      return;
    }
    SnsInfo localSnsInfo = aj.fOI().Rd(paramLong);
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
        localSnsObject.SnsRedEnvelops = new ekr();
      }
      if (paramejj.rWu == 13)
      {
        Object localObject = localSnsObject.SnsRedEnvelops.Umz.iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((ejx)((Iterator)localObject).next()).Username.equals(paramejj.TWw);
          if (bool)
          {
            AppMethodBeat.o(95864);
            return;
          }
        }
        localObject = new ejx();
        ((ejx)localObject).Ulq = paramejj.Ulq;
        ((ejx)localObject).CreateTime = paramejj.CreateTime;
        ((ejx)localObject).Username = paramejj.TWw;
        localSnsObject.SnsRedEnvelops.Umz.add(localObject);
        localSnsObject.SnsRedEnvelops.Umy = localSnsObject.SnsRedEnvelops.Umz.size();
      }
      localSnsInfo.setAttrBuf(localSnsObject.toByteArray());
      aj.fOI().a(localSnsObject.Id, localSnsInfo);
      AppMethodBeat.o(95864);
      return;
    }
    catch (Exception paramejj)
    {
      Log.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + paramejj.getMessage());
      Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", paramejj, "", new Object[0]);
      AppMethodBeat.o(95864);
    }
  }
  
  public static void fPi()
  {
    AppMethodBeat.i(95860);
    if (JZm != null) {
      JZm.clear();
    }
    AppMethodBeat.o(95860);
  }
  
  public static List<SnsInfo> fPj()
  {
    AppMethodBeat.i(95874);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = aj.fOI();
    Object localObject2 = n.fSO() + " AND " + n.KzK + " AND  (snsId = 0  ) ";
    localObject1 = ((n)localObject1).lvy.rawQuery((String)localObject2, null);
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
  
  public static void fPk()
  {
    AppMethodBeat.i(95883);
    Cursor localCursor = aj.fOI().q("", "", 0, 0);
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
  
  public static void fPl()
  {
    JVf = 0L;
    JVg = 0L;
  }
  
  public static long g(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95866);
    SnsInfo localSnsInfo2 = aj.fOI().Rd(paramSnsObject.Id);
    SnsInfo localSnsInfo1 = localSnsInfo2;
    if (localSnsInfo2 == null) {
      localSnsInfo1 = new SnsInfo();
    }
    long l = a(localSnsInfo1, paramSnsObject, "", 0);
    AppMethodBeat.o(95866);
    return l;
  }
  
  private static String hy(List<String> paramList)
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
  
  public static List<com.tencent.mm.plugin.sns.j.b> hz(List<String> paramList)
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
      cvt localcvt = new cvt();
      localcvt.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
      localb.fVT = localcvt;
      localb.parentId = "";
      localb.KeQ = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(95881);
    return localArrayList;
  }
  
  public static void k(LinkedList<SnsObject> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(95885);
    if (paramInt == aw.Kbj)
    {
      JVf = ((SnsObject)paramLinkedList.getFirst()).Id;
      JVg = ((SnsObject)paramLinkedList.getLast()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == aw.Kbk)
    {
      JVf = ((SnsObject)paramLinkedList.getFirst()).Id;
      AppMethodBeat.o(95885);
      return;
    }
    if (paramInt == aw.Kbl) {
      JVg = ((SnsObject)paramLinkedList.getLast()).Id;
    }
    AppMethodBeat.o(95885);
  }
  
  public static List<com.tencent.mm.plugin.sns.j.b> kB(String paramString1, String paramString2)
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
      if (com.tencent.mm.vfs.u.agG((String)localObject2))
      {
        paramString1 = com.tencent.mm.vfs.u.aY((String)localObject2, 0, (int)com.tencent.mm.vfs.u.bBQ((String)localObject2));
        paramString1 = (dw)new dw().parseFrom(paramString1);
      }
      paramString2 = paramString1;
      if (paramString1 == null)
      {
        com.tencent.mm.vfs.u.deleteFile((String)localObject2);
        paramString2 = a.baL(new String(com.tencent.mm.vfs.u.aY((String)localObject3, 0, (int)com.tencent.mm.vfs.u.bBQ((String)localObject3))));
        com.tencent.mm.vfs.u.f((String)localObject2, paramString2.toByteArray(), -1);
      }
      paramString1 = paramString2.GroupList.iterator();
      if (paramString1.hasNext())
      {
        localObject1 = (chu)paramString1.next();
        paramString2 = ((chu)localObject1).CMP;
        localObject1 = ((chu)localObject1).Sqr.iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (cvt)((Iterator)localObject1).next();
          ((cvt)localObject2).CMB = paramString2;
          localObject3 = new com.tencent.mm.plugin.sns.j.b();
          ((com.tencent.mm.plugin.sns.j.b)localObject3).fVT = ((cvt)localObject2);
          ((com.tencent.mm.plugin.sns.j.b)localObject3).parentId = "";
          ((com.tencent.mm.plugin.sns.j.b)localObject3).KeQ = j;
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
  
  public static List<SnsInfo> kC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95884);
    paramString1 = aj.fOI().lh(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an
 * JD-Core Version:    0.7.0.1
 */