package com.tencent.mm.plugin.textstatus.b;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.am.g.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.textstatus.h.b.a.b;
import com.tencent.mm.plugin.textstatus.h.f.i;
import com.tencent.mm.plugin.textstatus.proto.TextStatusEmojiInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storagebase.h.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "conversationStorage", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusConversationStorage;", "getConversationStorage", "()Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusConversationStorage;", "conversationStorage$delegate", "Lkotlin/Lazy;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "dataDB$delegate", "getOtherTopicInfoListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "getSelfTopicInfoListener", "getTopicInfoListener", "greetingItemStorage", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusGreetingItemStorage;", "getGreetingItemStorage", "()Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusGreetingItemStorage;", "greetingItemStorage$delegate", "infoUpdateListener", "lastMarkConvTabTime", "", "getLastMarkConvTabTime", "()I", "lastMarkConvUnread", "getLastMarkConvUnread", "lastMarkLikeTabTime", "getLastMarkLikeTabTime", "lastNotifyShownTime", "getLastNotifyShownTime", "likeStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "getLikeStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "likeStorage$delegate", "messageStorage", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusMessageStorage;", "getMessageStorage", "()Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusMessageStorage;", "messageStorage$delegate", "referenceStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;", "getReferenceStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;", "referenceStorage$delegate", "sessionInfoStorage", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusSessionInfoStorage;", "sessionInfoStorage$delegate", "storage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "getStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "storage$delegate", "strangerContactStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContactStorage;", "strangerContactStorage$delegate", "deleteByRowId", "", "rowId", "", "getLatestNewMsgItem", "Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo$NewMsgInfo;", "afterTime", "getLatestNotifyUsr", "getLatestRedDotConversation", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "getLatestUnreadGreetingItem", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "getNotifyShowInfo", "Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo;", "getOtherTopicInfoAsyn", "", "userName", "listerner", "getStatus", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "username", "getTopicInfoAsyn", "topicIDs", "Ljava/util/LinkedList;", "getUnReadLikeCnt", "getUnreadCnt", "hasStatus", "isFriend", "listentoInfoUpdate", "markConvTabShown", "time", "markConvUnread", "markLikeTabShown", "markNotifyShown", "onNewXmlReceived", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "update", "id", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "state", "visibilityInfo", "updateRed", "updateSelfState", "(Ljava/lang/Long;I)Z", "fillByExtInfo", "toNewMsgInfo", "Callback", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements com.tencent.mm.am.h, t
{
  private static final j ADQ;
  private static final j AFU;
  private static final j Tbu;
  public static final f TjQ;
  private static WeakReference<Object> TjR;
  private static final j TjS;
  private static final j TjT;
  private static final j TjU;
  private static final j TjV;
  private static final j TjW;
  private static final j sZg;
  
  static
  {
    AppMethodBeat.i(290482);
    TjQ = new f();
    TjS = kotlin.k.cm((kotlin.g.a.a)c.TjY);
    com.tencent.mm.kernel.h.aZW().a(6284, (com.tencent.mm.am.h)TjQ);
    com.tencent.mm.kernel.h.aZW().a(5215, (com.tencent.mm.am.h)TjQ);
    com.tencent.mm.kernel.h.aZW().a(6253, (com.tencent.mm.am.h)TjQ);
    com.tencent.mm.kernel.h.aZW().a(4099, (com.tencent.mm.am.h)TjQ);
    a.a locala = (a.a)new f.a();
    com.tencent.mm.aa.c.aYo().a(locala);
    sZg = kotlin.k.cm((kotlin.g.a.a)f.i.Tke);
    TjT = kotlin.k.cm((kotlin.g.a.a)e.Tka);
    TjU = kotlin.k.cm((kotlin.g.a.a)g.Tkc);
    ADQ = kotlin.k.cm((kotlin.g.a.a)j.Tkf);
    Tbu = kotlin.k.cm((kotlin.g.a.a)f.f.Tkb);
    TjV = kotlin.k.cm((kotlin.g.a.a)b.TjX);
    AFU = kotlin.k.cm((kotlin.g.a.a)f.h.Tkd);
    TjW = kotlin.k.cm((kotlin.g.a.a)d.TjZ);
    AppMethodBeat.o(290482);
  }
  
  public static long a(String paramString1, String paramString2, TextStatusExtInfo paramTextStatusExtInfo, int paramInt, String paramString3)
  {
    int j = 1;
    AppMethodBeat.i(290455);
    kotlin.g.b.s.u(paramString1, "username");
    kotlin.g.b.s.u(paramString2, "id");
    kotlin.g.b.s.u(paramTextStatusExtInfo, "info");
    Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "username " + paramString1 + ' ' + paramString2 + ' ' + paramInt + ' ' + paramTextStatusExtInfo.mediaThumbUrl);
    Object localObject;
    int i;
    boolean bool;
    long l;
    if (kotlin.g.b.s.p(paramString1, com.tencent.mm.plugin.auth.a.a.cUx()))
    {
      localObject = hGH().bdY(paramString1);
      if (localObject == null)
      {
        localObject = new com.tencent.mm.plugin.textstatus.h.f.b();
        i = 0;
        ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_UserName = paramString1;
        ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_StatusID = paramString2;
        ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_state = paramInt;
        if (!kotlin.g.b.s.p(paramString3, "NOT_SET")) {
          ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_visibilityInfo = paramString3;
        }
        a((com.tencent.mm.plugin.textstatus.h.f.b)localObject, paramTextStatusExtInfo);
        if (i == 0) {
          break label373;
        }
      }
      label373:
      for (bool = hGH().a((com.tencent.mm.plugin.textstatus.h.f.b)localObject, new String[0]);; bool = hGH().c((com.tencent.mm.plugin.textstatus.h.f.b)localObject))
      {
        if (bool)
        {
          paramString2 = com.tencent.mm.plugin.textstatus.g.a.Tmr;
          com.tencent.mm.plugin.textstatus.g.a.a(paramString1, (com.tencent.mm.plugin.textstatus.h.f.b)localObject);
          bool = hGH().hq(paramString1, paramTextStatusExtInfo.createTime);
          Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "update deleteResult:" + bool + " create_time:" + paramTextStatusExtInfo.createTime);
        }
        l = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).systemRowid;
        AppMethodBeat.o(290455);
        return l;
        if (paramTextStatusExtInfo.createTime < ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime)
        {
          Log.w("MicroMsg.TextStatus.TextStatusInfoManager", "current postInfo is new.(cur:" + ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime + ", new:" + paramTextStatusExtInfo.createTime + ')');
          AppMethodBeat.o(290455);
          return -1L;
        }
        if ((paramTextStatusExtInfo.createTime == ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime) || (kotlin.g.b.s.p(paramString2, ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_StatusID)))
        {
          i = 1;
          break;
        }
        localObject = new com.tencent.mm.plugin.textstatus.h.f.b();
        i = 0;
        break;
      }
    }
    paramString3 = hGH().bdY(paramString1);
    if (paramString3 == null)
    {
      paramString3 = new com.tencent.mm.plugin.textstatus.h.f.b();
      com.tencent.mm.plugin.textstatus.util.e.a(com.tencent.mm.plugin.textstatus.util.e.TAU, paramString1);
    }
    for (;;)
    {
      paramString3.field_UserName = paramString1;
      paramString3.field_StatusID = paramString2;
      paramString3.field_state = paramInt;
      a(paramString3, paramTextStatusExtInfo);
      if (hGH().e(paramString3))
      {
        paramString2 = com.tencent.mm.plugin.textstatus.g.a.Tmr;
        com.tencent.mm.plugin.textstatus.g.a.a(paramString1, paramString3);
        bool = hGH().hq(paramString1, paramTextStatusExtInfo.createTime);
        Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "update deleteResult:" + bool + " create_time:" + paramTextStatusExtInfo.createTime);
      }
      l = paramString3.systemRowid;
      AppMethodBeat.o(290455);
      return l;
      Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "last status:" + paramString3.field_StatusID + " state:" + paramString3.field_state + " createTime:" + paramString3.field_CreateTime + " mediaType:" + paramString3.field_MediaType + "  " + paramString3.field_MediaThumbUrl);
      kotlin.g.b.s.u(paramString2, "newStatusId");
      kotlin.g.b.s.u(paramTextStatusExtInfo, "newInfo");
      if (TextUtils.equals((CharSequence)paramString3.field_StatusID, (CharSequence)paramString2)) {
        break;
      }
      i = 7;
      if (i > 0)
      {
        localObject = com.tencent.mm.plugin.textstatus.util.e.TAU;
        com.tencent.mm.plugin.textstatus.util.e.ht(paramString1, i);
      }
    }
    if (!TextUtils.equals((CharSequence)paramString3.field_MediaThumbUrl, (CharSequence)paramTextStatusExtInfo.mediaThumbUrl)) {}
    for (;;)
    {
      i = j;
      if (TextUtils.equals((CharSequence)paramString3.field_MediaUrl, (CharSequence)paramTextStatusExtInfo.mediaUrl)) {
        break;
      }
      i = j | 0x2 | 0x4;
      break;
      j = 0;
    }
  }
  
  public static void a(com.tencent.mm.plugin.textstatus.h.f.b paramb, TextStatusExtInfo paramTextStatusExtInfo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(290474);
    kotlin.g.b.s.u(paramb, "<this>");
    kotlin.g.b.s.u(paramTextStatusExtInfo, "info");
    paramb.field_Description = paramTextStatusExtInfo.description;
    Object localObject1 = paramTextStatusExtInfo.topicInfo;
    if (localObject1 == null)
    {
      localObject1 = null;
      paramb.field_IconID = ((String)localObject1);
      localObject1 = paramTextStatusExtInfo.topicInfo;
      if (localObject1 != null) {
        break label272;
      }
      localObject1 = null;
      label57:
      paramb.field_TopicId = ((String)localObject1);
      paramb.field_MediaType = paramTextStatusExtInfo.mediaType;
      paramb.field_MediaUrl = paramTextStatusExtInfo.mediaUrl;
      paramb.field_MediaAESKey = paramTextStatusExtInfo.mediaAesKey;
      paramb.field_MediaThumbUrl = paramTextStatusExtInfo.mediaThumbUrl;
      paramb.field_MediaThumbAESKey = paramTextStatusExtInfo.mediaThumbAesKey;
      paramb.field_PoiID = paramTextStatusExtInfo.poiId;
      paramb.field_PoiName = paramTextStatusExtInfo.poiName;
      paramb.field_Latitude = paramTextStatusExtInfo.latitude;
      paramb.field_Longitude = paramTextStatusExtInfo.longitude;
      paramb.field_Visibility = paramTextStatusExtInfo.visibility;
      paramb.field_ExpireTime = paramTextStatusExtInfo.expireTime;
      paramb.field_CreateTime = paramTextStatusExtInfo.createTime;
      paramb.field_backgroundId = paramTextStatusExtInfo.backgroundId;
      paramb.field_option = Long.valueOf(paramTextStatusExtInfo.option);
      paramb.field_mediaWidth = paramTextStatusExtInfo.mediaWidth;
      paramb.field_mediaHeight = paramTextStatusExtInfo.mediaHeight;
      paramb.field_referenceUserName = paramTextStatusExtInfo.referenceUsername;
      paramb.field_referenceTextStatusId = paramTextStatusExtInfo.referenceTextStatusId;
      paramb.field_duplicateUserName = paramTextStatusExtInfo.duplicateUsername;
      paramb.field_duplicateTextStatusId = paramTextStatusExtInfo.duplicateTextStatusId;
      localObject1 = paramTextStatusExtInfo.topicInfo;
      if (localObject1 != null) {
        break label280;
      }
      localObject1 = null;
      label236:
      paramb.field_TopicInfo = ((byte[])localObject1);
      paramTextStatusExtInfo = paramTextStatusExtInfo.emojiInfo;
      if (paramTextStatusExtInfo != null) {
        break label288;
      }
    }
    label272:
    label280:
    label288:
    for (paramTextStatusExtInfo = localObject2;; paramTextStatusExtInfo = paramTextStatusExtInfo.toByteArray())
    {
      paramb.field_EmojiInfo = paramTextStatusExtInfo;
      AppMethodBeat.o(290474);
      return;
      localObject1 = ((TextStatusTopicInfo)localObject1).iconId;
      break;
      localObject1 = ((TextStatusTopicInfo)localObject1).topicId;
      break label57;
      localObject1 = ((TextStatusTopicInfo)localObject1).toByteArray();
      break label236;
    }
  }
  
  private static void aon(int paramInt)
  {
    AppMethodBeat.i(290356);
    Log.d("MicroMsg.TextStatus.TextStatusInfoManager", "markLikeTabShown() called");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhh, Integer.valueOf(paramInt));
    AppMethodBeat.o(290356);
  }
  
  private static void aoo(int paramInt)
  {
    AppMethodBeat.i(290364);
    Log.d("MicroMsg.TextStatus.TextStatusInfoManager", "markConvTabShown() called");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhi, Integer.valueOf(paramInt));
    AppMethodBeat.o(290364);
  }
  
  public static a.b aop(int paramInt)
  {
    AppMethodBeat.i(290407);
    Object localObject1 = hGN().hGF();
    int i;
    label24:
    Object localObject3;
    if (localObject1 == null)
    {
      i = -1;
      if (i <= paramInt) {
        break label196;
      }
      localObject2 = hGL();
      localObject3 = "select *, rowid from TextStatusConversation where isRedDot = 1 and updateTime > " + paramInt * 1000L + " ORDER BY updateTime DESC";
      localObject3 = ((com.tencent.mm.plugin.textstatus.conversation.h.a)localObject2).db.rawQuery((String)localObject3, null);
      if (localObject3 == null) {
        break label208;
      }
      if (!((Cursor)localObject3).moveToFirst()) {
        break label201;
      }
      localObject2 = new com.tencent.mm.plugin.textstatus.conversation.d.a();
      ((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject2).convertFrom((Cursor)localObject3);
      label101:
      localObject3 = ((Iterable)kotlin.a.p.listOf(new IAutoDBItem[] { (IAutoDBItem)localObject1, (IAutoDBItem)localObject2 })).iterator();
      if (((Iterator)localObject3).hasNext()) {
        break label213;
      }
      localObject1 = null;
    }
    label196:
    label201:
    label208:
    label213:
    do
    {
      localObject1 = (IAutoDBItem)localObject1;
      if (!(localObject1 instanceof com.tencent.mm.plugin.textstatus.conversation.d.a)) {
        break label369;
      }
      localObject1 = (com.tencent.mm.plugin.textstatus.conversation.d.a)localObject1;
      kotlin.g.b.s.u(localObject1, "<this>");
      localObject1 = new a.b(((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject1).field_sessionId);
      AppMethodBeat.o(290407);
      return localObject1;
      i = ((com.tencent.mm.plugin.textstatus.conversation.d.d)localObject1).field_createTime;
      break;
      localObject1 = null;
      break label24;
      ((Cursor)localObject3).close();
      localObject2 = null;
      break label101;
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    Object localObject2 = (IAutoDBItem)localObject1;
    label259:
    label261:
    IAutoDBItem localIAutoDBItem;
    if ((localObject2 instanceof com.tencent.mm.plugin.textstatus.conversation.d.a))
    {
      paramInt = (int)(((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject2).field_updateTime / 1000L);
      i = paramInt;
      localObject2 = ((Iterator)localObject3).next();
      localIAutoDBItem = (IAutoDBItem)localObject2;
      if (!(localIAutoDBItem instanceof com.tencent.mm.plugin.textstatus.conversation.d.a)) {
        break label342;
      }
      paramInt = (int)(((com.tencent.mm.plugin.textstatus.conversation.d.a)localIAutoDBItem).field_updateTime / 1000L);
      label297:
      if (i >= paramInt) {
        break label421;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext())
      {
        break;
        if ((localObject2 instanceof com.tencent.mm.plugin.textstatus.conversation.d.d))
        {
          paramInt = ((com.tencent.mm.plugin.textstatus.conversation.d.d)localObject2).field_createTime;
          break label259;
        }
        paramInt = -2147483648;
        break label259;
        label342:
        if ((localIAutoDBItem instanceof com.tencent.mm.plugin.textstatus.conversation.d.d))
        {
          paramInt = ((com.tencent.mm.plugin.textstatus.conversation.d.d)localIAutoDBItem).field_createTime;
          break label297;
        }
        paramInt = -2147483648;
        break label297;
        label369:
        if ((localObject1 instanceof com.tencent.mm.plugin.textstatus.conversation.d.d))
        {
          localObject1 = (com.tencent.mm.plugin.textstatus.conversation.d.d)localObject1;
          kotlin.g.b.s.u(localObject1, "<this>");
          localObject1 = new a.b(((com.tencent.mm.plugin.textstatus.conversation.d.d)localObject1).field_session_id);
          AppMethodBeat.o(290407);
          return localObject1;
        }
        AppMethodBeat.o(290407);
        return null;
      }
      i = paramInt;
      break label261;
      label421:
      paramInt = i;
    }
  }
  
  public static com.tencent.mm.plugin.textstatus.h.f.b bdN(String paramString)
  {
    AppMethodBeat.i(290431);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290431);
      return null;
    }
    localObject = com.tencent.mm.plugin.expansions.b.yFu;
    if (!com.tencent.mm.plugin.expansions.b.isInstalled("xlab"))
    {
      AppMethodBeat.o(290431);
      return null;
    }
    if (au.bwY(paramString))
    {
      localObject = com.tencent.mm.plugin.textstatus.conversation.g.g.TjC;
      paramString = com.tencent.mm.plugin.textstatus.conversation.g.g.bdN(paramString);
      AppMethodBeat.o(290431);
      return paramString;
    }
    paramString = hGH().bdY(paramString);
    AppMethodBeat.o(290431);
    return paramString;
  }
  
  public static boolean d(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(290439);
    if (paramLong == null)
    {
      AppMethodBeat.o(290439);
      return false;
    }
    com.tencent.mm.plugin.textstatus.h.f.b localb = new com.tencent.mm.plugin.textstatus.h.f.b();
    if (hGH().get(paramLong.longValue(), (IAutoDBItem)localb))
    {
      localb.field_state = paramInt;
      boolean bool = hGH().e(localb);
      AppMethodBeat.o(290439);
      return bool;
    }
    AppMethodBeat.o(290439);
    return false;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(290291);
    com.tencent.mm.storagebase.h localh = (com.tencent.mm.storagebase.h)TjS.getValue();
    AppMethodBeat.o(290291);
    return localh;
  }
  
  public static com.tencent.mm.plugin.textstatus.h.f.g hGH()
  {
    AppMethodBeat.i(290299);
    com.tencent.mm.plugin.textstatus.h.f.g localg = (com.tencent.mm.plugin.textstatus.h.f.g)sZg.getValue();
    AppMethodBeat.o(290299);
    return localg;
  }
  
  public static com.tencent.mm.plugin.textstatus.h.f.d hGI()
  {
    AppMethodBeat.i(290303);
    com.tencent.mm.plugin.textstatus.h.f.d locald = (com.tencent.mm.plugin.textstatus.h.f.d)TjT.getValue();
    AppMethodBeat.o(290303);
    return locald;
  }
  
  public static com.tencent.mm.plugin.textstatus.h.f.f hGJ()
  {
    AppMethodBeat.i(290307);
    com.tencent.mm.plugin.textstatus.h.f.f localf = (com.tencent.mm.plugin.textstatus.h.f.f)TjU.getValue();
    AppMethodBeat.o(290307);
    return localf;
  }
  
  public static i hGK()
  {
    AppMethodBeat.i(290315);
    i locali = (i)ADQ.getValue();
    AppMethodBeat.o(290315);
    return locali;
  }
  
  public static com.tencent.mm.plugin.textstatus.conversation.h.a hGL()
  {
    AppMethodBeat.i(290322);
    com.tencent.mm.plugin.textstatus.conversation.h.a locala = (com.tencent.mm.plugin.textstatus.conversation.h.a)TjV.getValue();
    AppMethodBeat.o(290322);
    return locala;
  }
  
  public static com.tencent.mm.plugin.textstatus.conversation.h.d hGM()
  {
    AppMethodBeat.i(290327);
    com.tencent.mm.plugin.textstatus.conversation.h.d locald = (com.tencent.mm.plugin.textstatus.conversation.h.d)AFU.getValue();
    AppMethodBeat.o(290327);
    return locald;
  }
  
  public static com.tencent.mm.plugin.textstatus.conversation.h.b hGN()
  {
    AppMethodBeat.i(290334);
    com.tencent.mm.plugin.textstatus.conversation.h.b localb = (com.tencent.mm.plugin.textstatus.conversation.h.b)TjW.getValue();
    AppMethodBeat.o(290334);
    return localb;
  }
  
  public static void hGO()
  {
    AppMethodBeat.i(290342);
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.adgL, 0L);
    com.tencent.mm.plugin.textstatus.ui.f.a locala = com.tencent.mm.plugin.textstatus.ui.f.Tww;
    if (com.tencent.mm.plugin.textstatus.ui.f.hIw() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((Math.abs(System.currentTimeMillis() - l) > com.tencent.mm.plugin.textstatus.a.ac.hFZ()) && (i == 0)) {
        com.tencent.mm.aa.c.aYo().R(352280, true);
      }
      AppMethodBeat.o(290342);
      return;
    }
  }
  
  public static int hGP()
  {
    AppMethodBeat.i(290348);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adhh, null);
    if ((localObject instanceof Integer))
    {
      localObject = (Integer)localObject;
      if (localObject != null) {
        break label69;
      }
    }
    label69:
    for (int i = 0;; i = ((Integer)localObject).intValue())
    {
      int j = hGI().aor(i);
      i = hGJ().aor(i);
      AppMethodBeat.o(290348);
      return i + j;
      localObject = null;
      break;
    }
  }
  
  public static void hGQ()
  {
    AppMethodBeat.i(290354);
    Log.d("MicroMsg.TextStatus.TextStatusInfoManager", "markNotifyShown() called");
    int i = cn.getSyncServerTimeSecond();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhg, Integer.valueOf(i));
    aon(i);
    aoo(i);
    AppMethodBeat.o(290354);
  }
  
  public static int hGT()
  {
    AppMethodBeat.i(290372);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adhi, null);
    if ((localObject instanceof Integer)) {}
    for (localObject = (Integer)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(290372);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(290372);
    return i;
  }
  
  public static void hGU()
  {
    AppMethodBeat.i(290378);
    int i = com.tencent.mm.plugin.textstatus.conversation.h.a.a(hGL());
    Log.d("MicroMsg.TextStatus.TextStatusInfoManager", kotlin.g.b.s.X("markConvTabUnread() called  unreadCnt = ", Integer.valueOf(i)));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhj, Integer.valueOf(i));
    AppMethodBeat.o(290378);
  }
  
  public static int hGV()
  {
    AppMethodBeat.i(290382);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adhj, null);
    if ((localObject instanceof Integer)) {}
    for (localObject = (Integer)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(290382);
      return 0;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(290382);
    return i;
  }
  
  public static com.tencent.mm.plugin.textstatus.h.b.a hGW()
  {
    AppMethodBeat.i(290395);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adhg, null);
    int i;
    if ((localObject instanceof Integer))
    {
      localObject = (Integer)localObject;
      if (localObject != null) {
        break label174;
      }
      i = 0;
      label43:
      localObject = new com.tencent.mm.plugin.textstatus.h.b.a();
      int j = hGI().aor(i);
      int k = hGJ().aor(i);
      int m = hGL().hGB();
      int n = j + k + m;
      Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "handleNotify, unreadCnt:" + n + " likeUnreadCnt:" + j + " refUnreadCnt:" + k + " convUnreadCnt:" + m);
      ((com.tencent.mm.plugin.textstatus.h.b.a)localObject).Tno = n;
      if (((com.tencent.mm.plugin.textstatus.h.b.a)localObject).Tno <= 0) {
        break label183;
      }
      ((com.tencent.mm.plugin.textstatus.h.b.a)localObject).Tnp = hGX();
    }
    for (;;)
    {
      AppMethodBeat.o(290395);
      return localObject;
      localObject = null;
      break;
      label174:
      i = ((Integer)localObject).intValue();
      break label43;
      label183:
      ((com.tencent.mm.plugin.textstatus.h.b.a)localObject).Tnn = aop(i);
    }
  }
  
  private static String hGX()
  {
    Object localObject2 = null;
    AppMethodBeat.i(290425);
    Object localObject1 = hGI().db.rawQuery("select rowid, * from TextStatusLike order by CreateTime DESC LIMIT 1", null);
    kotlin.g.b.s.s(localObject1, "db.rawQuery(sql, null)");
    Object localObject4 = new com.tencent.mm.plugin.textstatus.h.f.c();
    if (((Cursor)localObject1).moveToNext()) {
      ((com.tencent.mm.plugin.textstatus.h.f.c)localObject4).convertFrom((Cursor)localObject1);
    }
    ((Cursor)localObject1).close();
    localObject1 = hGJ().db.rawQuery("select rowid, * from TextStatusReference order by CreateTime DESC LIMIT 1", null);
    kotlin.g.b.s.s(localObject1, "db.rawQuery(sql, null)");
    com.tencent.mm.plugin.textstatus.h.f.e locale = new com.tencent.mm.plugin.textstatus.h.f.e();
    if (((Cursor)localObject1).moveToNext()) {
      locale.convertFrom((Cursor)localObject1);
    }
    ((Cursor)localObject1).close();
    localObject1 = hGL();
    com.tencent.mm.plugin.textstatus.conversation.d.a locala = (com.tencent.mm.plugin.textstatus.conversation.d.a)com.tencent.mm.plugin.textstatus.j.b.TABLE.selectAll().orderBy(kotlin.a.p.listOf(com.tencent.mm.plugin.textstatus.j.b.UPDATETIME.orderDesc())).limit(1, 0).build().singleQuery(((com.tencent.mm.plugin.textstatus.conversation.h.a)localObject1).db, com.tencent.mm.plugin.textstatus.conversation.d.a.class);
    Iterator localIterator = ((Iterable)kotlin.a.p.listOf(new IAutoDBItem[] { (IAutoDBItem)localObject4, (IAutoDBItem)locale, (IAutoDBItem)locala })).iterator();
    if (!localIterator.hasNext()) {
      localObject1 = null;
    }
    label268:
    label319:
    do
    {
      localObject3 = (IAutoDBItem)localObject1;
      if (!(localObject3 instanceof com.tencent.mm.plugin.textstatus.h.f.c)) {
        break;
      }
      localObject1 = new r(((com.tencent.mm.plugin.hashinfo.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.hashinfo.a.a.class)).getUserNameByHash(((com.tencent.mm.plugin.textstatus.h.f.c)localObject3).field_HashUserName, 1), Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.c)localObject3).field_CreateTime));
      localObject4 = new StringBuilder("lastLike:").append(Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.c)localObject4).field_CreateTime)).append(" lastRef:").append(Integer.valueOf(locale.field_CreateTime)).append(" + lastConv:");
      if (locala != null) {
        break label658;
      }
      Log.d("MicroMsg.TextStatus.TextStatusInfoManager", localObject2 + " latestUser:" + localObject3 + ' ' + localObject1);
      if (localObject1 != null) {
        break label670;
      }
      AppMethodBeat.o(290425);
      return "";
      localObject1 = localIterator.next();
    } while (!localIterator.hasNext());
    Object localObject3 = (IAutoDBItem)localObject1;
    int i;
    label412:
    int j;
    label414:
    IAutoDBItem localIAutoDBItem;
    if ((localObject3 instanceof com.tencent.mm.plugin.textstatus.h.f.c))
    {
      i = ((com.tencent.mm.plugin.textstatus.h.f.c)localObject3).field_CreateTime;
      j = i;
      localObject3 = localIterator.next();
      localIAutoDBItem = (IAutoDBItem)localObject3;
      if (!(localIAutoDBItem instanceof com.tencent.mm.plugin.textstatus.h.f.c)) {
        break label520;
      }
      i = ((com.tencent.mm.plugin.textstatus.h.f.c)localIAutoDBItem).field_CreateTime;
      label447:
      if (j >= i) {
        break label705;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        break;
        if ((localObject3 instanceof com.tencent.mm.plugin.textstatus.h.f.e))
        {
          i = ((com.tencent.mm.plugin.textstatus.h.f.e)localObject3).field_CreateTime;
          break label412;
        }
        if ((localObject3 instanceof com.tencent.mm.plugin.textstatus.conversation.d.a))
        {
          i = (int)(((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject3).field_updateTime / 1000L);
          break label412;
        }
        i = -2147483648;
        break label412;
        label520:
        if ((localIAutoDBItem instanceof com.tencent.mm.plugin.textstatus.h.f.e))
        {
          i = ((com.tencent.mm.plugin.textstatus.h.f.e)localIAutoDBItem).field_CreateTime;
          break label447;
        }
        if ((localIAutoDBItem instanceof com.tencent.mm.plugin.textstatus.conversation.d.a))
        {
          i = (int)(((com.tencent.mm.plugin.textstatus.conversation.d.a)localIAutoDBItem).field_updateTime / 1000L);
          break label447;
        }
        i = -2147483648;
        break label447;
        if ((localObject3 instanceof com.tencent.mm.plugin.textstatus.h.f.e))
        {
          localObject1 = new r(((com.tencent.mm.plugin.textstatus.h.f.e)localObject3).field_UserName, Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.e)localObject3).field_CreateTime));
          break label268;
        }
        if ((localObject3 instanceof com.tencent.mm.plugin.textstatus.conversation.d.a))
        {
          localObject1 = new r(((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject3).field_sessionId, Integer.valueOf((int)(((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject3).field_updateTime / 1000L)));
          break label268;
        }
        localObject1 = null;
        break label268;
        label658:
        localObject2 = Long.valueOf(locala.field_updateTime);
        break label319;
        label670:
        localObject1 = (String)((r)localObject1).bsC;
        if (localObject1 == null)
        {
          AppMethodBeat.o(290425);
          return "";
        }
        AppMethodBeat.o(290425);
        return localObject1;
      }
      j = i;
      break label414;
      label705:
      i = j;
    }
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(290496);
    if (paramMap != null)
    {
      Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "subtype:" + paramString + ", values:" + paramMap);
      if (paramString != null) {
        switch (paramString.hashCode())
        {
        }
      }
    }
    Object localObject1;
    int i;
    label333:
    label339:
    label478:
    Object localObject2;
    label427:
    label453:
    label584:
    label586:
    label595:
    label618:
    label875:
    int j;
    label532:
    label578:
    label580:
    label842:
    label851:
    label860:
    int k;
    label649:
    label675:
    label950:
    label1082:
    for (;;)
    {
      AppMethodBeat.o(290496);
      return;
      if (!paramString.equals("textstatusreference"))
      {
        AppMethodBeat.o(290496);
        return;
        if (!paramString.equals("modtextstatus"))
        {
          AppMethodBeat.o(290496);
          return;
          if (!paramString.equals("textstatuslike"))
          {
            AppMethodBeat.o(290496);
            return;
            if (!paramString.equals("textstatusiconconfigrefresh")) {
              continue;
            }
            com.tencent.mm.plugin.textstatus.util.a.a(com.tencent.mm.plugin.textstatus.util.b.hKh());
            AppMethodBeat.o(290496);
          }
        }
        else
        {
          paramString = (String)paramMap.get(".sysmsg.modtextstatus.UserName");
          parama = (String)paramMap.get(".sysmsg.modtextstatus.TextStatusID");
          paramMap = (String)paramMap.get(".sysmsg.modtextstatus.TextStatusExtInfo");
          localObject1 = (CharSequence)paramString;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(290496);
            return;
          }
          localObject1 = (CharSequence)parama;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
          {
            i = 1;
            if (i == 0)
            {
              localObject1 = (CharSequence)paramMap;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label333;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label339;
            }
            hGH().bdX(paramString);
            AppMethodBeat.o(290496);
            return;
            i = 0;
            break;
          }
          localObject1 = new TextStatusExtInfo();
          ((TextStatusExtInfo)localObject1).parseFrom(Base64.decode(paramMap, 0));
          a(paramString, parama, (TextStatusExtInfo)localObject1, 4, null, 16);
          AppMethodBeat.o(290496);
          return;
        }
        parama = (String)paramMap.get(".sysmsg.textstatuslike.HashUserName");
        localObject1 = (String)paramMap.get(".sysmsg.textstatuslike.TextStatusID");
        paramString = (CharSequence)localObject1;
        if ((paramString == null) || (paramString.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label578;
          }
          paramString = (CharSequence)parama;
          if ((paramString != null) && (paramString.length() != 0)) {
            break label580;
          }
          i = 1;
          if (i != 0) {
            break label584;
          }
          paramString = (String)paramMap.get(".sysmsg.textstatuslike.DeleteFlag");
          if (paramString != null) {
            break label586;
          }
          i = 0;
          paramString = hGI().ni((String)localObject1, parama);
          localObject2 = hGH();
          kotlin.g.b.s.u(localObject1, "statusId");
          localObject2 = ((com.tencent.mm.plugin.textstatus.h.f.g)localObject2).bdZ((String)localObject1);
          if ((i != 1) || (paramString == null)) {
            break label595;
          }
          hGI().b(paramString, new String[0]);
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_LikeCount = Util.getInt((String)paramMap.get(".sysmsg.textstatuslike.LikeCount"), 0);
            hGH().d((com.tencent.mm.plugin.textstatus.h.f.b)localObject2);
            AppMethodBeat.o(290496);
            return;
            i = 0;
            break label427;
            break;
            i = 0;
            break label453;
            break;
            i = Integer.parseInt(paramString);
            break label478;
            if ((i != 1) && (localObject2 != null))
            {
              if (paramString != null) {
                break label830;
              }
              paramString = new com.tencent.mm.plugin.textstatus.h.f.c();
              paramString.field_HashUserName = parama;
              paramString.field_TextStatusId = ((String)localObject1);
              parama = (String)paramMap.get(".sysmsg.textstatuslike.Type");
              if (parama != null) {
                break label833;
              }
              i = 0;
              paramString.field_Type = i;
              parama = (String)paramMap.get(".sysmsg.textstatuslike.Notify");
              if (parama != null) {
                break label842;
              }
              i = 0;
              paramString.field_Notify = i;
              parama = (String)paramMap.get(".sysmsg.textstatuslike.CreateTime");
              if (parama != null) {
                break label851;
              }
              i = 0;
              label701:
              paramString.field_CreateTime = i;
              paramString.field_DisplayName = ((String)paramMap.get(".sysmsg.textstatuslike.NickName"));
              paramString.field_HeadImgUrl = ((String)paramMap.get(".sysmsg.textstatuslike.HeadImgUrl"));
              paramString.field_Description = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_Description;
              paramString.field_thumbUrl = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaThumbUrl;
              paramString.field_TopicInfo = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_TopicInfo;
              if ((int)paramString.systemRowid != -1) {
                break label860;
              }
              hGI().a(paramString);
              if (paramString.field_Notify == 1) {
                hGO();
              }
              boolean bool = com.tencent.mm.aa.c.aYo().aYl();
              paramString = com.tencent.mm.plugin.textstatus.i.b.Trt;
              if (!bool) {
                break label875;
              }
            }
          }
        }
        for (long l = 5L;; l = 6L)
        {
          com.tencent.mm.plugin.textstatus.i.b.a(l, null, null, 0L, null, 30);
          break label532;
          break;
          label830:
          break label618;
          label833:
          i = Integer.parseInt(parama);
          break label649;
          i = Integer.parseInt(parama);
          break label675;
          i = Integer.parseInt(parama);
          break label701;
          hGI().a(paramString, new String[0]);
          break label783;
        }
      }
      else
      {
        parama = (String)paramMap.get(".sysmsg.textstatusreference.UserName");
        localObject1 = (String)paramMap.get(".sysmsg.textstatusreference.TextStatusID");
        paramString = (String)paramMap.get(".sysmsg.textstatusreference.CreateTime");
        if (paramString == null)
        {
          i = 0;
          paramString = (String)paramMap.get(".sysmsg.textstatusreference.ReferenceCount");
          if (paramString != null) {
            break label1054;
          }
          j = 0;
          paramString = (String)paramMap.get(".sysmsg.textstatusreference.ShowType");
          if (paramString != null) {
            break label1063;
          }
          k = 0;
          label970:
          paramString = (CharSequence)localObject1;
          if ((paramString != null) && (paramString.length() != 0)) {
            break label1072;
          }
          m = 1;
          label992:
          if (m != 0) {
            break label1076;
          }
          paramString = (CharSequence)parama;
          if ((paramString != null) && (paramString.length() != 0)) {
            break label1078;
          }
        }
        for (int m = 1;; m = 0)
        {
          if (m != 0) {
            break label1082;
          }
          localObject2 = hGH().bdZ((String)localObject1);
          if (localObject2 != null) {
            break label1084;
          }
          AppMethodBeat.o(290496);
          return;
          i = Integer.parseInt(paramString);
          break label930;
          j = Integer.parseInt(paramString);
          break label950;
          k = Integer.parseInt(paramString);
          break label970;
          m = 0;
          break label992;
          break;
        }
      }
    }
    label783:
    label930:
    label1063:
    label1072:
    label1076:
    label1078:
    label1084:
    paramString = hGJ();
    label1054:
    kotlin.g.b.s.u(localObject1, "textStatusId");
    kotlin.g.b.s.u(parama, "userName");
    paramMap = "select rowid, * from " + com.tencent.mm.plugin.textstatus.h.f.f.ptT + " where TextStatusId = ? and UserName = ? ";
    paramMap = paramString.db.rawQuery(paramMap, new String[] { Util.escapeSqlValue((String)localObject1), Util.escapeSqlValue(parama) });
    kotlin.g.b.s.s(paramMap, "db.rawQuery(sql, arrayOf…scapeSqlValue(userName)))");
    paramString = null;
    if (paramMap.moveToFirst())
    {
      paramString = new com.tencent.mm.plugin.textstatus.h.f.e();
      paramString.convertFrom(paramMap);
    }
    paramMap.close();
    paramMap = paramString;
    if (paramString == null) {
      paramMap = new com.tencent.mm.plugin.textstatus.h.f.e();
    }
    paramMap.field_UserName = parama;
    paramMap.field_TextStatusId = ((String)localObject1);
    paramMap.field_CreateTime = i;
    paramMap.field_ShowType = k;
    paramMap.field_thumbUrl = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaThumbUrl;
    paramMap.field_TopicInfo = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_TopicInfo;
    paramMap.field_Description = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_Description;
    if ((int)paramMap.systemRowid == -1) {
      hGJ().a(paramMap);
    }
    for (;;)
    {
      hGO();
      paramString = hGH().bdZ((String)localObject1);
      if (paramString == null) {
        break;
      }
      paramString.field_referenceCount = j;
      hGH().e(paramString);
      break;
      hGJ().a(paramMap, new String[0]);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(290503);
    if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.k))
    {
      new HashMap();
      AppMethodBeat.o(290503);
      throw null;
    }
    if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.e))
    {
      paramString = new com.tencent.mm.plugin.textstatus.proto.ac();
      paramString.Tpy = new Random().nextBoolean();
      paramString.live_member_count = kotlin.k.k.a(new kotlin.k.g(0, 100), (kotlin.j.c)kotlin.j.c.aixl);
      paramString = TjR;
      if (paramString != null) {
        paramString.get();
      }
      TjR = null;
    }
    AppMethodBeat.o(290503);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusConversationStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.conversation.h.a>
  {
    public static final b TjX;
    
    static
    {
      AppMethodBeat.i(290194);
      TjX = new b();
      AppMethodBeat.o(290194);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/storagebase/SqliteDB;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.storagebase.h>
  {
    public static final c TjY;
    
    static
    {
      AppMethodBeat.i(290208);
      TjY = new c();
      AppMethodBeat.o(290208);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusGreetingItemStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.conversation.h.b>
  {
    public static final d TjZ;
    
    static
    {
      AppMethodBeat.i(290197);
      TjZ = new d();
      AppMethodBeat.o(290197);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.h.f.d>
  {
    public static final e Tka;
    
    static
    {
      AppMethodBeat.i(290205);
      Tka = new e();
      AppMethodBeat.o(290205);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.h.f.f>
  {
    public static final g Tkc;
    
    static
    {
      AppMethodBeat.i(290189);
      Tkc = new g();
      AppMethodBeat.o(290189);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContactStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<i>
  {
    public static final j Tkf;
    
    static
    {
      AppMethodBeat.i(290190);
      Tkf = new j();
      AppMethodBeat.o(290190);
    }
    
    j()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.f
 * JD-Core Version:    0.7.0.1
 */