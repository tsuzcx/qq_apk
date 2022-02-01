package com.tencent.mm.plugin.textstatus.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.f.f.b;
import com.tencent.mm.plugin.textstatus.f.f.d;
import com.tencent.mm.plugin.textstatus.g.o;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.plugin.textstatus.g.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.y.a.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusDataManager;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "dataDB$delegate", "Lkotlin/Lazy;", "getOtherTopicInfoListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "getSelfTopicInfoListener", "getTopicInfoListener", "infoUpdateListener", "likeStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "getLikeStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "likeStorage$delegate", "storage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "getStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "storage$delegate", "userNameMapStorage", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "getUserNameMapStorage", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMapStorage;", "userNameMapStorage$delegate", "convert", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "deleteByRowId", "", "rowId", "", "getOtherTopicInfoAsyn", "userName", "listerner", "getStatus", "username", "getTopicInfoAsyn", "topicIDs", "Ljava/util/LinkedList;", "isFriend", "listentoInfoUpdate", "onNewXmlReceived", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "self", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusInfo;", "update", "id", "state", "updateSelfState", "(Ljava/lang/Long;I)Z", "Callback", "plugin-textstatus_release"})
public final class f
  implements i, com.tencent.mm.plugin.messenger.foundation.a.q, k
{
  private static WeakReference<a> FXE;
  private static WeakReference<a> FXF;
  private static final kotlin.f FXG;
  private static final kotlin.f FXH;
  private static final kotlin.f FXI;
  public static final f FXJ;
  private static final kotlin.f nDW;
  
  static
  {
    AppMethodBeat.i(216093);
    Object localObject = new f();
    FXJ = (f)localObject;
    FXG = kotlin.g.ah((kotlin.g.a.a)f.b.FXK);
    com.tencent.mm.kernel.g.azz().a(6284, (i)localObject);
    com.tencent.mm.kernel.g.azz().a(5215, (i)localObject);
    com.tencent.mm.kernel.g.azz().a(6253, (i)localObject);
    com.tencent.mm.kernel.g.azz().a(4099, (i)localObject);
    localObject = (a.a)new f.f();
    com.tencent.mm.y.c.axV().a((a.a)localObject);
    nDW = kotlin.g.ah((kotlin.g.a.a)f.d.FXM);
    FXH = kotlin.g.ah((kotlin.g.a.a)f.c.FXL);
    FXI = kotlin.g.ah((kotlin.g.a.a)f.e.FXN);
    AppMethodBeat.o(216093);
  }
  
  public static long a(String paramString1, String paramString2, com.tencent.mm.plugin.textstatus.g.g paramg, int paramInt)
  {
    AppMethodBeat.i(216088);
    kotlin.g.b.p.h(paramString1, "username");
    kotlin.g.b.p.h(paramString2, "id");
    kotlin.g.b.p.h(paramg, "info");
    Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "username " + paramString1 + ' ' + paramString2 + ' ' + paramInt + ' ' + paramg.Gax);
    Object localObject1;
    boolean bool;
    long l;
    if (kotlin.g.b.p.j(paramString1, com.tencent.mm.plugin.auth.a.a.ceA()))
    {
      localObject2 = fvM().aTl(paramString1);
      localObject1 = new com.tencent.mm.plugin.textstatus.f.f.a();
      ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_UserName = paramString1;
      ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_StatusID = paramString2;
      ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_state = paramInt;
      a((com.tencent.mm.plugin.textstatus.f.f.a)localObject1, paramg);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_CreateTime > ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_CreateTime))
      {
        Log.w("MicroMsg.TxtStatus.TextStatusInfoManager", "current postInfo is new.(cur:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_CreateTime + ", new:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_CreateTime + ')');
        AppMethodBeat.o(216088);
        return -1L;
      }
      if (fvM().b((com.tencent.mm.plugin.textstatus.f.f.a)localObject1))
      {
        paramString2 = com.tencent.mm.plugin.textstatus.e.a.FYI;
        com.tencent.mm.plugin.textstatus.e.a.c(paramString1, (com.tencent.mm.plugin.textstatus.f.f.a)localObject1);
        bool = fvM().ie(paramString1, paramg.Gaz);
        Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "update deleteResult:" + bool + " create_time:" + paramg.Gaz);
      }
      l = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).systemRowid;
      AppMethodBeat.o(216088);
      return l;
    }
    Object localObject2 = fvM().aTl(paramString1);
    if (localObject2 == null)
    {
      localObject1 = new com.tencent.mm.plugin.textstatus.f.f.a();
      localObject2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      com.tencent.mm.plugin.textstatus.j.a.amg(paramString1);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_UserName = paramString1;
      ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_StatusID = paramString2;
      ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_state = paramInt;
      a((com.tencent.mm.plugin.textstatus.f.f.a)localObject1, paramg);
      if (fvM().c((com.tencent.mm.plugin.textstatus.f.f.a)localObject1))
      {
        paramString2 = com.tencent.mm.plugin.textstatus.e.a.FYI;
        com.tencent.mm.plugin.textstatus.e.a.c(paramString1, (com.tencent.mm.plugin.textstatus.f.f.a)localObject1);
        bool = fvM().ie(paramString1, paramg.Gaz);
        Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "update deleteResult:" + bool + " create_time:" + paramg.Gaz);
      }
      l = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).systemRowid;
      AppMethodBeat.o(216088);
      return l;
      Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "last status:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_StatusID + " state:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_state + " createTime:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_CreateTime + " mediaType:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_MediaType + "  " + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_MediaThumbUrl);
      localObject1 = localObject2;
      if (!Util.isEqual(((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_StatusID, paramString2))
      {
        localObject1 = com.tencent.mm.plugin.textstatus.j.a.GfU;
        com.tencent.mm.plugin.textstatus.j.a.amg(paramString1);
        localObject1 = localObject2;
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.textstatus.f.f.a parama, com.tencent.mm.plugin.textstatus.g.g paramg)
  {
    AppMethodBeat.i(216091);
    kotlin.g.b.p.h(parama, "item");
    kotlin.g.b.p.h(paramg, "info");
    parama.field_Description = paramg.description;
    parama.field_IconID = paramg.Gau.Gan;
    parama.field_TopicId = paramg.Gau.GaI;
    parama.field_MediaType = paramg.Gat;
    parama.field_MediaUrl = paramg.Gav;
    parama.field_MediaAESKey = paramg.Gaw;
    parama.field_MediaThumbUrl = paramg.Gax;
    parama.field_MediaThumbAESKey = paramg.Gay;
    parama.field_PoiID = paramg.GaA;
    parama.field_PoiName = paramg.iUX;
    parama.field_Latitude = paramg.latitude;
    parama.field_Longitude = paramg.longitude;
    parama.field_Visibility = paramg.visibility;
    parama.field_ExpireTime = paramg.pRN;
    parama.field_CreateTime = paramg.Gaz;
    parama.field_backgroundId = paramg.GaC;
    parama.field_option = Long.valueOf(paramg.GaB);
    parama.field_mediaWidth = paramg.zGN;
    parama.field_mediaHeight = paramg.zGO;
    paramg = paramg.Gau;
    if (paramg != null) {}
    for (paramg = paramg.toByteArray();; paramg = null)
    {
      parama.field_TopicInfo = paramg;
      AppMethodBeat.o(216091);
      return;
    }
  }
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(216086);
    kotlin.g.b.p.h(paramLinkedList, "topicIDs");
    kotlin.g.b.p.h(parama, "listerner");
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.textstatus.f.h(paramLinkedList));
    FXE = new WeakReference(parama);
    AppMethodBeat.o(216086);
  }
  
  public static com.tencent.mm.plugin.textstatus.f.f.a aTf(String paramString)
  {
    AppMethodBeat.i(216085);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aL(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216085);
      return null;
    }
    paramString = fvM().aTl(paramString);
    AppMethodBeat.o(216085);
    return paramString;
  }
  
  public static boolean c(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(216087);
    if (paramLong == null)
    {
      AppMethodBeat.o(216087);
      return false;
    }
    com.tencent.mm.plugin.textstatus.f.f.a locala = new com.tencent.mm.plugin.textstatus.f.f.a();
    if (fvM().get(paramLong.longValue(), (IAutoDBItem)locala))
    {
      locala.field_state = paramInt;
      boolean bool = fvM().c(locala);
      AppMethodBeat.o(216087);
      return bool;
    }
    AppMethodBeat.o(216087);
    return false;
  }
  
  public static d fvM()
  {
    AppMethodBeat.i(216082);
    d locald = (d)nDW.getValue();
    AppMethodBeat.o(216082);
    return locald;
  }
  
  public static com.tencent.mm.plugin.textstatus.f.f.c fvN()
  {
    AppMethodBeat.i(216083);
    com.tencent.mm.plugin.textstatus.f.f.c localc = (com.tencent.mm.plugin.textstatus.f.f.c)FXH.getValue();
    AppMethodBeat.o(216083);
    return localc;
  }
  
  public static com.tencent.mm.plugin.textstatus.f.f.f fvO()
  {
    AppMethodBeat.i(216084);
    com.tencent.mm.plugin.textstatus.f.f.f localf = (com.tencent.mm.plugin.textstatus.f.f.f)FXI.getValue();
    AppMethodBeat.o(216084);
    return localf;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(216081);
    com.tencent.mm.storagebase.h localh = (com.tencent.mm.storagebase.h)FXG.getValue();
    AppMethodBeat.o(216081);
    return localh;
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    int j = 1;
    AppMethodBeat.i(216090);
    if (paramMap != null)
    {
      Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "subtype:" + paramString + ", values:" + paramMap);
      if (paramString == null)
      {
        AppMethodBeat.o(216090);
        return;
      }
      switch (paramString.hashCode())
      {
      }
    }
    int i;
    label168:
    do
    {
      do
      {
        AppMethodBeat.o(216090);
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
        break label378;
      }
      AppMethodBeat.o(216090);
      return;
    } while (!paramString.equals("textstatuslike"));
    Object localObject = (String)paramMap.get(".sysmsg.textstatuslike.HashUserName");
    parama = (String)paramMap.get(".sysmsg.textstatuslike.TextStatusID");
    paramString = (CharSequence)parama;
    if ((paramString == null) || (paramString.length() == 0))
    {
      i = 1;
      label238:
      if (i != 0) {
        break label508;
      }
      paramString = (CharSequence)localObject;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label510;
      }
      i = 1;
      label265:
      if (i != 0) {
        break label514;
      }
      paramString = (String)paramMap.get(".sysmsg.textstatuslike.DeleteFlag");
      if (paramString == null) {
        break label516;
      }
      i = Integer.parseInt(paramString);
      label293:
      paramString = fvN().lc(parama, (String)localObject);
      if ((i != 1) || (paramString == null)) {
        break label522;
      }
      fvN().b(paramString, new String[0]);
    }
    label378:
    label508:
    label510:
    while (i == 1)
    {
      paramString = fvM().aTm(parama);
      if (paramString == null) {
        break;
      }
      paramString.field_LikeCount = Util.getInt((String)paramMap.get(".sysmsg.textstatuslike.LikeCount"), 0);
      fvM().c(paramString);
      AppMethodBeat.o(216090);
      return;
      i = 0;
      break label168;
      localObject = (CharSequence)parama;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0)
        {
          localObject = (CharSequence)paramMap;
          i = j;
          if (localObject != null) {
            if (((CharSequence)localObject).length() != 0) {
              break label462;
            }
          }
        }
      }
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label468;
        }
        fvM().aTk(paramString);
        AppMethodBeat.o(216090);
        return;
        i = 0;
        break;
      }
      localObject = new com.tencent.mm.plugin.textstatus.g.g();
      ((com.tencent.mm.plugin.textstatus.g.g)localObject).parseFrom(Base64.decode(paramMap, 0));
      a(paramString, parama, (com.tencent.mm.plugin.textstatus.g.g)localObject, 4);
      AppMethodBeat.o(216090);
      return;
      i = 0;
      break label238;
      break;
      i = 0;
      break label265;
      break;
      i = 0;
      break label293;
    }
    label462:
    label468:
    if (paramString == null) {
      paramString = new b();
    }
    for (;;)
    {
      label514:
      label516:
      label522:
      paramString.field_HashUserName = ((String)localObject);
      paramString.field_TextStatusId = parama;
      localObject = (String)paramMap.get(".sysmsg.textstatuslike.Type");
      if (localObject != null)
      {
        i = Integer.parseInt((String)localObject);
        label577:
        paramString.field_Type = i;
        localObject = (String)paramMap.get(".sysmsg.textstatuslike.Notify");
        if (localObject == null) {
          break label817;
        }
        i = Integer.parseInt((String)localObject);
        label609:
        paramString.field_Notify = i;
        localObject = (String)paramMap.get(".sysmsg.textstatuslike.CreateTime");
        if (localObject == null) {
          break label823;
        }
        i = Integer.parseInt((String)localObject);
        label641:
        paramString.field_CreateTime = i;
        paramString.field_DisplayName = ((String)paramMap.get(".sysmsg.textstatuslike.NickName"));
        paramString.field_HeadImgUrl = ((String)paramMap.get(".sysmsg.textstatuslike.HeadImgUrl"));
        localObject = fvM().aTm(parama);
        if (localObject != null) {
          paramString.field_Description = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_Description;
        }
        if ((int)paramString.systemRowid != -1) {
          break label829;
        }
        fvN().a(paramString);
        label719:
        boolean bool = com.tencent.mm.y.c.axV().axS();
        localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
        if (!bool) {
          break label844;
        }
      }
      label817:
      label823:
      label829:
      label844:
      for (long l1 = 5L;; l1 = 6L)
      {
        com.tencent.mm.plugin.textstatus.k.a.Rk(l1);
        if (paramString.field_Notify != 1) {
          break;
        }
        paramString = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(paramString, "MMKernel.storage()");
        l1 = paramString.azQ().a(ar.a.Uui, 0L);
        long l2 = System.currentTimeMillis();
        com.tencent.mm.plugin.textstatus.a.p.gWK();
        if (l2 - l1 <= 0L) {
          break;
        }
        com.tencent.mm.y.c.axV().B(352280, true);
        break;
        i = 0;
        break label577;
        i = 0;
        break label609;
        i = 0;
        break label641;
        fvN().a(paramString, new String[0]);
        break label719;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216092);
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.h))
    {
      paramString = new HashMap();
      Object localObject = ((com.tencent.mm.plugin.textstatus.f.h)paramq).FZb.GaL.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        x localx = new x();
        localx.GaI = str;
        localx.Gbg = "";
        localx.GaE = j.a(new kotlin.k.f(0, 100), (kotlin.j.c)kotlin.j.c.SYP);
        paramString.put(str, localx);
      }
      localObject = FXE;
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).dW(paramString);
        }
      }
      FXE = null;
    }
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.c))
    {
      paramString = new com.tencent.mm.plugin.textstatus.g.h();
      paramString.GaD = new Random().nextBoolean();
      paramString.GaE = j.a(new kotlin.k.f(0, 100), (kotlin.j.c)kotlin.j.c.SYP);
      paramq = FXF;
      if (paramq != null)
      {
        paramq = (a)paramq.get();
        if (paramq != null) {
          paramq.dW(paramString);
        }
      }
      FXF = null;
    }
    AppMethodBeat.o(216092);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "", "onCall", "", "data", "plugin-textstatus_release"})
  public static abstract interface a
  {
    public abstract void dW(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.f
 * JD-Core Version:    0.7.0.1
 */