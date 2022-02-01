package com.tencent.mm.plugin.textstatus.b;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.an.h.a;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.g.e.b;
import com.tencent.mm.plugin.textstatus.g.j;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusDataManager;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "dataDB$delegate", "Lkotlin/Lazy;", "getOtherTopicInfoListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "getSelfTopicInfoListener", "getTopicInfoListener", "infoUpdateListener", "likeStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "getLikeStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "likeStorage$delegate", "referenceStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;", "getReferenceStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;", "referenceStorage$delegate", "storage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "getStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "storage$delegate", "userNameMapStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "getUserNameMapStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "userNameMapStorage$delegate", "convert", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "deleteByRowId", "", "rowId", "", "getOtherTopicInfoAsyn", "userName", "listerner", "getStatus", "username", "getTopicInfoAsyn", "topicIDs", "Ljava/util/LinkedList;", "isFriend", "listentoInfoUpdate", "onNewXmlReceived", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "self", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusInfo;", "update", "id", "state", "visibilityInfo", "updateSelfState", "(Ljava/lang/Long;I)Z", "Callback", "plugin-textstatus_release"})
public final class f
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.messenger.foundation.a.t, o
{
  private static WeakReference<a> MAg;
  private static WeakReference<a> MAh;
  private static final kotlin.f MAi;
  private static final kotlin.f MAj;
  private static final kotlin.f MAk;
  private static final kotlin.f MAl;
  public static final f MAm;
  private static final kotlin.f pTX;
  
  static
  {
    AppMethodBeat.i(234440);
    Object localObject = new f();
    MAm = (f)localObject;
    MAi = g.ar((kotlin.g.a.a)f.c.MAn);
    com.tencent.mm.kernel.h.aGY().a(6284, (com.tencent.mm.an.i)localObject);
    com.tencent.mm.kernel.h.aGY().a(5215, (com.tencent.mm.an.i)localObject);
    com.tencent.mm.kernel.h.aGY().a(6253, (com.tencent.mm.an.i)localObject);
    com.tencent.mm.kernel.h.aGY().a(4099, (com.tencent.mm.an.i)localObject);
    localObject = (a.a)new f.b();
    com.tencent.mm.aa.c.aFn().a((a.a)localObject);
    pTX = g.ar((kotlin.g.a.a)f.MAq);
    MAj = g.ar((kotlin.g.a.a)d.MAo);
    MAk = g.ar((kotlin.g.a.a)g.MAr);
    MAl = g.ar((kotlin.g.a.a)e.MAp);
    AppMethodBeat.o(234440);
  }
  
  public static long a(String paramString1, String paramString2, TextStatusExtInfo paramTextStatusExtInfo, int paramInt, String paramString3)
  {
    int j = 1;
    AppMethodBeat.i(234417);
    p.k(paramString1, "username");
    p.k(paramString2, "id");
    p.k(paramTextStatusExtInfo, "info");
    Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "username " + paramString1 + ' ' + paramString2 + ' ' + paramInt + ' ' + paramTextStatusExtInfo.mediaThumbUrl);
    Object localObject;
    int i;
    boolean bool;
    long l;
    if (p.h(paramString1, com.tencent.mm.plugin.auth.a.a.crN()))
    {
      localObject = gly().bey(paramString1);
      if (localObject == null)
      {
        localObject = new com.tencent.mm.plugin.textstatus.g.e.a();
        i = 0;
        ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_UserName = paramString1;
        ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_StatusID = paramString2;
        ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_state = paramInt;
        if ((p.h(paramString3, "NOT_SET") ^ true)) {
          ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_visibilityInfo = paramString3;
        }
        a((com.tencent.mm.plugin.textstatus.g.e.a)localObject, paramTextStatusExtInfo);
        if (i == 0) {
          break label364;
        }
      }
      label364:
      for (bool = gly().a((com.tencent.mm.plugin.textstatus.g.e.a)localObject, new String[0]);; bool = gly().a((com.tencent.mm.plugin.textstatus.g.e.a)localObject))
      {
        if (bool)
        {
          paramString2 = com.tencent.mm.plugin.textstatus.f.a.MCH;
          com.tencent.mm.plugin.textstatus.f.a.a(paramString1, (com.tencent.mm.plugin.textstatus.g.e.a)localObject);
          bool = gly().gu(paramString1, paramTextStatusExtInfo.createTime);
          Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "update deleteResult:" + bool + " create_time:" + paramTextStatusExtInfo.createTime);
        }
        l = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).systemRowid;
        AppMethodBeat.o(234417);
        return l;
        if (paramTextStatusExtInfo.createTime < ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_CreateTime)
        {
          Log.w("MicroMsg.TextStatus.TextStatusInfoManager", "current postInfo is new.(cur:" + ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_CreateTime + ", new:" + paramTextStatusExtInfo.createTime + ')');
          AppMethodBeat.o(234417);
          return -1L;
        }
        if ((paramTextStatusExtInfo.createTime == ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_CreateTime) || (p.h(paramString2, ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_StatusID)))
        {
          i = 1;
          break;
        }
        localObject = new com.tencent.mm.plugin.textstatus.g.e.a();
        i = 0;
        break;
      }
    }
    paramString3 = gly().bey(paramString1);
    if (paramString3 == null)
    {
      paramString3 = new com.tencent.mm.plugin.textstatus.g.e.a();
      com.tencent.mm.plugin.textstatus.k.f.a(com.tencent.mm.plugin.textstatus.k.f.MOw, paramString1);
    }
    for (;;)
    {
      paramString3.field_UserName = paramString1;
      paramString3.field_StatusID = paramString2;
      paramString3.field_state = paramInt;
      a(paramString3, paramTextStatusExtInfo);
      if (gly().b(paramString3))
      {
        paramString2 = com.tencent.mm.plugin.textstatus.f.a.MCH;
        com.tencent.mm.plugin.textstatus.f.a.a(paramString1, paramString3);
        bool = gly().gu(paramString1, paramTextStatusExtInfo.createTime);
        Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "update deleteResult:" + bool + " create_time:" + paramTextStatusExtInfo.createTime);
      }
      l = paramString3.systemRowid;
      AppMethodBeat.o(234417);
      return l;
      Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "last status:" + paramString3.field_StatusID + " state:" + paramString3.field_state + " createTime:" + paramString3.field_CreateTime + " mediaType:" + paramString3.field_MediaType + "  " + paramString3.field_MediaThumbUrl);
      p.k(paramString2, "newStatusId");
      p.k(paramTextStatusExtInfo, "newInfo");
      if (TextUtils.equals((CharSequence)paramString3.field_StatusID, (CharSequence)paramString2)) {
        break;
      }
      i = 7;
      if (i > 0)
      {
        localObject = com.tencent.mm.plugin.textstatus.k.f.MOw;
        com.tencent.mm.plugin.textstatus.k.f.gw(paramString1, i);
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
  
  public static void a(com.tencent.mm.plugin.textstatus.g.e.a parama, TextStatusExtInfo paramTextStatusExtInfo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(234437);
    p.k(parama, "item");
    p.k(paramTextStatusExtInfo, "info");
    parama.field_Description = paramTextStatusExtInfo.description;
    Object localObject1 = paramTextStatusExtInfo.topicInfo;
    if (localObject1 != null)
    {
      localObject1 = ((TextStatusTopicInfo)localObject1).iconId;
      parama.field_IconID = ((String)localObject1);
      localObject1 = paramTextStatusExtInfo.topicInfo;
      if (localObject1 == null) {
        break label247;
      }
    }
    label247:
    for (localObject1 = ((TextStatusTopicInfo)localObject1).topicId;; localObject1 = null)
    {
      parama.field_TopicId = ((String)localObject1);
      parama.field_MediaType = paramTextStatusExtInfo.mediaType;
      parama.field_MediaUrl = paramTextStatusExtInfo.mediaUrl;
      parama.field_MediaAESKey = paramTextStatusExtInfo.mediaAesKey;
      parama.field_MediaThumbUrl = paramTextStatusExtInfo.mediaThumbUrl;
      parama.field_MediaThumbAESKey = paramTextStatusExtInfo.mediaThumbAesKey;
      parama.field_PoiID = paramTextStatusExtInfo.poiId;
      parama.field_PoiName = paramTextStatusExtInfo.poiName;
      parama.field_Latitude = paramTextStatusExtInfo.latitude;
      parama.field_Longitude = paramTextStatusExtInfo.longitude;
      parama.field_Visibility = paramTextStatusExtInfo.visibility;
      parama.field_ExpireTime = paramTextStatusExtInfo.expireTime;
      parama.field_CreateTime = paramTextStatusExtInfo.createTime;
      parama.field_backgroundId = paramTextStatusExtInfo.backgroundId;
      parama.field_option = Long.valueOf(paramTextStatusExtInfo.option);
      parama.field_mediaWidth = paramTextStatusExtInfo.mediaWidth;
      parama.field_mediaHeight = paramTextStatusExtInfo.mediaHeight;
      parama.field_referenceUserName = paramTextStatusExtInfo.referenceUsername;
      parama.field_referenceTextStatusId = paramTextStatusExtInfo.referenceTextStatusId;
      localObject1 = paramTextStatusExtInfo.topicInfo;
      paramTextStatusExtInfo = localObject2;
      if (localObject1 != null) {
        paramTextStatusExtInfo = ((TextStatusTopicInfo)localObject1).toByteArray();
      }
      parama.field_TopicInfo = paramTextStatusExtInfo;
      AppMethodBeat.o(234437);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(234414);
    p.k(paramLinkedList, "topicIDs");
    p.k(parama, "listerner");
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new j(paramLinkedList));
    MAg = new WeakReference(parama);
    AppMethodBeat.o(234414);
  }
  
  public static com.tencent.mm.plugin.textstatus.g.e.a bep(String paramString)
  {
    AppMethodBeat.i(234413);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(234413);
      return null;
    }
    paramString = gly().bey(paramString);
    AppMethodBeat.o(234413);
    return paramString;
  }
  
  public static boolean c(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(234415);
    if (paramLong == null)
    {
      AppMethodBeat.o(234415);
      return false;
    }
    com.tencent.mm.plugin.textstatus.g.e.a locala = new com.tencent.mm.plugin.textstatus.g.e.a();
    if (gly().get(paramLong.longValue(), (IAutoDBItem)locala))
    {
      locala.field_state = paramInt;
      boolean bool = gly().b(locala);
      AppMethodBeat.o(234415);
      return bool;
    }
    AppMethodBeat.o(234415);
    return false;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(234407);
    com.tencent.mm.storagebase.h localh = (com.tencent.mm.storagebase.h)MAi.getValue();
    AppMethodBeat.o(234407);
    return localh;
  }
  
  public static com.tencent.mm.plugin.textstatus.g.e.h glA()
  {
    AppMethodBeat.i(234410);
    com.tencent.mm.plugin.textstatus.g.e.h localh = (com.tencent.mm.plugin.textstatus.g.e.h)MAk.getValue();
    AppMethodBeat.o(234410);
    return localh;
  }
  
  public static com.tencent.mm.plugin.textstatus.g.e.e glB()
  {
    AppMethodBeat.i(234412);
    com.tencent.mm.plugin.textstatus.g.e.e locale = (com.tencent.mm.plugin.textstatus.g.e.e)MAl.getValue();
    AppMethodBeat.o(234412);
    return locale;
  }
  
  public static com.tencent.mm.plugin.textstatus.g.e.f gly()
  {
    AppMethodBeat.i(234408);
    com.tencent.mm.plugin.textstatus.g.e.f localf = (com.tencent.mm.plugin.textstatus.g.e.f)pTX.getValue();
    AppMethodBeat.o(234408);
    return localf;
  }
  
  public static com.tencent.mm.plugin.textstatus.g.e.c glz()
  {
    AppMethodBeat.i(234409);
    com.tencent.mm.plugin.textstatus.g.e.c localc = (com.tencent.mm.plugin.textstatus.g.e.c)MAj.getValue();
    AppMethodBeat.o(234409);
    return localc;
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(234429);
    if (paramMap != null)
    {
      Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "subtype:" + paramString + ", values:" + paramMap);
      if (paramString == null)
      {
        AppMethodBeat.o(234429);
        return;
      }
    }
    Object localObject;
    int i;
    int j;
    label190:
    int k;
    label211:
    label238:
    long l1;
    label445:
    long l2;
    switch (paramString.hashCode())
    {
    default: 
    case -384935220: 
    case -1306850335: 
    case -1813338250: 
      label604:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      AppMethodBeat.o(234429);
                      return;
                    } while (!paramString.equals("textstatusreference"));
                    localObject = (String)paramMap.get(".sysmsg.textstatusreference.UserName");
                    parama = (String)paramMap.get(".sysmsg.textstatusreference.TextStatusID");
                    paramString = (String)paramMap.get(".sysmsg.textstatusreference.CreateTime");
                    if (paramString == null) {
                      break;
                    }
                    i = Integer.parseInt(paramString);
                    paramString = (String)paramMap.get(".sysmsg.textstatusreference.ReferenceCount");
                    if (paramString == null) {
                      break label1345;
                    }
                    j = Integer.parseInt(paramString);
                    paramString = (CharSequence)parama;
                    if ((paramString != null) && (paramString.length() != 0)) {
                      break label1351;
                    }
                    k = 1;
                  } while (k != 0);
                  paramString = (CharSequence)localObject;
                  if ((paramString != null) && (paramString.length() != 0)) {
                    break label1357;
                  }
                  k = 1;
                } while (k != 0);
                paramString = glB();
                p.k(parama, "textStatusId");
                p.k(localObject, "userName");
                paramMap = "select rowid, * from " + com.tencent.mm.plugin.textstatus.g.e.e.Alf + " where TextStatusId = ? and UserName = ? ";
                Cursor localCursor = paramString.db.rawQuery(paramMap, new String[] { Util.escapeSqlValue(parama), Util.escapeSqlValue((String)localObject) });
                p.j(localCursor, "db.rawQuery(sql, arrayOf…scapeSqlValue(userName)))");
                paramString = null;
                paramMap = null;
                if (localCursor != null)
                {
                  paramString = paramMap;
                  if (localCursor.moveToFirst())
                  {
                    paramString = new com.tencent.mm.plugin.textstatus.g.e.d();
                    paramString.convertFrom(localCursor);
                  }
                  localCursor.close();
                }
                paramMap = paramString;
                if (paramString == null) {
                  paramMap = new com.tencent.mm.plugin.textstatus.g.e.d();
                }
                paramMap.field_UserName = ((String)localObject);
                paramMap.field_TextStatusId = parama;
                paramMap.field_CreateTime = i;
                paramString = gly().bez(parama);
                if (paramString != null)
                {
                  paramMap.field_thumbUrl = paramString.field_MediaThumbUrl;
                  paramMap.field_TopicInfo = paramString.field_TopicInfo;
                }
                if ((int)paramMap.systemRowid != -1) {
                  break label1363;
                }
                glB().a(paramMap);
                paramString = com.tencent.mm.kernel.h.aHG();
                p.j(paramString, "MMKernel.storage()");
                l1 = paramString.aHp().a(ar.a.VDK, 0L);
                l2 = System.currentTimeMillis();
                com.tencent.mm.plugin.textstatus.a.t.glf();
                if (l2 - l1 > 0L) {
                  com.tencent.mm.aa.c.aFn().D(352280, true);
                }
                paramString = gly().bez(parama);
              } while (paramString == null);
              paramString.field_referenceCount = j;
              gly().b(paramString);
              AppMethodBeat.o(234429);
              return;
            } while (!paramString.equals("modtextstatus"));
            paramString = (String)paramMap.get(".sysmsg.modtextstatus.UserName");
            parama = (String)paramMap.get(".sysmsg.modtextstatus.TextStatusID");
            paramMap = (String)paramMap.get(".sysmsg.modtextstatus.TextStatusExtInfo");
            localObject = (CharSequence)paramString;
            if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
              break;
            }
            i = 1;
            if (i == 0) {
              break label837;
            }
            AppMethodBeat.o(234429);
            return;
          } while (!paramString.equals("textstatuslike"));
          localObject = (String)paramMap.get(".sysmsg.textstatuslike.HashUserName");
          parama = (String)paramMap.get(".sysmsg.textstatuslike.TextStatusID");
          paramString = (CharSequence)parama;
          if ((paramString != null) && (paramString.length() != 0)) {
            break label962;
          }
          i = 1;
        } while (i != 0);
        paramString = (CharSequence)localObject;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label968;
        }
        i = 1;
      } while (i != 0);
      label674:
      label701:
      paramString = (String)paramMap.get(".sysmsg.textstatuslike.DeleteFlag");
      if (paramString != null)
      {
        i = Integer.parseInt(paramString);
        label729:
        paramString = glz().lz(parama, (String)localObject);
        if ((i != 1) || (paramString == null)) {
          break label980;
        }
        glz().b(paramString, new String[0]);
      }
      break;
    }
    label837:
    label968:
    label980:
    while (i == 1)
    {
      paramString = gly().bez(parama);
      if (paramString == null) {
        break label1332;
      }
      paramString.field_LikeCount = Util.getInt((String)paramMap.get(".sysmsg.textstatuslike.LikeCount"), 0);
      gly().b(paramString);
      AppMethodBeat.o(234429);
      return;
      if (!paramString.equals("textstatusiconconfigrefresh")) {
        break;
      }
      com.tencent.mm.plugin.textstatus.k.c.gnz().gnx();
      AppMethodBeat.o(234429);
      return;
      i = 0;
      break label604;
      localObject = (CharSequence)parama;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0)
        {
          localObject = (CharSequence)paramMap;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label916;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label922;
        }
        gly().bex(paramString);
        AppMethodBeat.o(234429);
        return;
        i = 0;
        break;
      }
      localObject = new TextStatusExtInfo();
      ((TextStatusExtInfo)localObject).parseFrom(Base64.decode(paramMap, 0));
      a(this, paramString, parama, (TextStatusExtInfo)localObject, 4, null, 16);
      AppMethodBeat.o(234429);
      return;
      i = 0;
      break label674;
      i = 0;
      break label701;
      i = 0;
      break label729;
    }
    label916:
    label922:
    label962:
    if (paramString == null) {
      paramString = new b();
    }
    for (;;)
    {
      paramString.field_HashUserName = ((String)localObject);
      paramString.field_TextStatusId = parama;
      localObject = (String)paramMap.get(".sysmsg.textstatuslike.Type");
      if (localObject != null)
      {
        i = Integer.parseInt((String)localObject);
        label1035:
        paramString.field_Type = i;
        localObject = (String)paramMap.get(".sysmsg.textstatuslike.Notify");
        if (localObject == null) {
          break label1297;
        }
        i = Integer.parseInt((String)localObject);
        label1067:
        paramString.field_Notify = i;
        localObject = (String)paramMap.get(".sysmsg.textstatuslike.CreateTime");
        if (localObject == null) {
          break label1303;
        }
        i = Integer.parseInt((String)localObject);
        label1099:
        paramString.field_CreateTime = i;
        paramString.field_DisplayName = ((String)paramMap.get(".sysmsg.textstatuslike.NickName"));
        paramString.field_HeadImgUrl = ((String)paramMap.get(".sysmsg.textstatuslike.HeadImgUrl"));
        localObject = gly().bez(parama);
        if (localObject != null)
        {
          paramString.field_Description = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_Description;
          paramString.field_thumbUrl = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_MediaThumbUrl;
          paramString.field_TopicInfo = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_TopicInfo;
        }
        if ((int)paramString.systemRowid != -1) {
          break label1309;
        }
        glz().a(paramString);
        label1195:
        if (paramString.field_Notify == 1)
        {
          paramString = com.tencent.mm.kernel.h.aHG();
          p.j(paramString, "MMKernel.storage()");
          l1 = paramString.aHp().a(ar.a.VDK, 0L);
          l2 = System.currentTimeMillis();
          com.tencent.mm.plugin.textstatus.a.t.glf();
          if (l2 - l1 > 0L) {
            com.tencent.mm.aa.c.aFn().D(352280, true);
          }
        }
        boolean bool = com.tencent.mm.aa.c.aFn().aFk();
        paramString = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        if (!bool) {
          break label1324;
        }
      }
      label1297:
      label1303:
      label1309:
      label1324:
      for (l1 = 5L;; l1 = 6L)
      {
        com.tencent.mm.plugin.textstatus.h.a.a(l1, null, null, 0L, 14);
        break;
        i = 0;
        break label1035;
        i = 0;
        break label1067;
        i = 0;
        break label1099;
        glz().a(paramString, new String[0]);
        break label1195;
      }
      label1332:
      AppMethodBeat.o(234429);
      return;
      i = 0;
      break;
      label1345:
      j = 0;
      break label190;
      label1351:
      k = 0;
      break label211;
      label1357:
      k = 0;
      break label238;
      label1363:
      glB().a(paramMap, new String[0]);
      break label445;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(234433);
    if ((paramq instanceof j))
    {
      paramString = new HashMap();
      Object localObject = ((j)paramq).MDp.MFw.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        com.tencent.mm.plugin.textstatus.proto.ao localao = new com.tencent.mm.plugin.textstatus.proto.ao();
        localao.MFz = str;
        localao.MGG = "";
        localao.live_member_count = kotlin.k.i.a(new kotlin.k.e(0, 100), (kotlin.j.c)kotlin.j.c.aaBL);
        paramString.put(str, localao);
      }
      localObject = MAg;
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).ea(paramString);
        }
      }
      MAg = null;
    }
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.d))
    {
      paramString = new com.tencent.mm.plugin.textstatus.proto.n();
      paramString.MFm = new Random().nextBoolean();
      paramString.live_member_count = kotlin.k.i.a(new kotlin.k.e(0, 100), (kotlin.j.c)kotlin.j.c.aaBL);
      paramq = MAh;
      if (paramq != null)
      {
        paramq = (a)paramq.get();
        if (paramq != null) {
          paramq.ea(paramString);
        }
      }
      MAh = null;
    }
    AppMethodBeat.o(234433);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "", "onCall", "", "data", "plugin-textstatus_release"})
  public static abstract interface a
  {
    public abstract void ea(Object paramObject);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.g.e.c>
  {
    public static final d MAo;
    
    static
    {
      AppMethodBeat.i(236572);
      MAo = new d();
      AppMethodBeat.o(236572);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.g.e.e>
  {
    public static final e MAp;
    
    static
    {
      AppMethodBeat.i(232433);
      MAp = new e();
      AppMethodBeat.o(232433);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.g.e.f>
  {
    public static final f MAq;
    
    static
    {
      AppMethodBeat.i(234761);
      MAq = new f();
      AppMethodBeat.o(234761);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.textstatus.g.e.h>
  {
    public static final g MAr;
    
    static
    {
      AppMethodBeat.i(237429);
      MAr = new g();
      AppMethodBeat.o(237429);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.f
 * JD-Core Version:    0.7.0.1
 */