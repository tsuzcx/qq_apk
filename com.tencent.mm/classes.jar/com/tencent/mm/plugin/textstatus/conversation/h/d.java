package com.tencent.mm.plugin.textstatus.conversation.h;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.plugin.textstatus.conversation.d.g;
import com.tencent.mm.plugin.textstatus.conversation.d.g.a;
import com.tencent.mm.plugin.textstatus.j.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "talkerToSessionInfoCache", "deleteSession", "", "sessionId", "isNotify", "getAllData", "", "getSessionId", "talker", "roleType", "", "getSessionInfoBySelfUserName", "Ljava/util/LinkedList;", "selfUserName", "getSessionInfoBySenderUserName", "senderUserName", "getSessionInfoBySessionId", "getSessionInfoByTalker", "getSessionSender", "getTalker", "isSessionRejectMsg", "replaceSessionInfo", "", "type", "enable_action", "rejectMsg", "canSendMsg", "testAllSessionInfo", "updateOpType", "updateOpTypeAndAction", "actionPermission", "usernameCacheKey", "selfUsername", "Companion", "ReplaceSource", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MAutoStorage<g>
{
  public static final a TjH;
  private static final String[] ptU;
  public final ConcurrentHashMap<String, g> FMm;
  public final ConcurrentHashMap<String, g> FMn;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(291103);
    TjH = new a((byte)0);
    g.a locala = g.Tji;
    ptU = new String[] { MAutoStorage.getCreateSQLs(g.access$getInfo$cp(), "TextStatusSessionInfo") };
    AppMethodBeat.o(291103);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.access$getInfo$cp(), "TextStatusSessionInfo", f.INDEX_CREATE);
    AppMethodBeat.i(291076);
    this.db = paramISQLiteDatabase;
    this.FMm = new ConcurrentHashMap();
    this.FMn = new ConcurrentHashMap();
    AppMethodBeat.o(291076);
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(291138);
    s.u(paramString1, "sessionId");
    s.u(paramString2, "talker");
    s.u(paramString3, "senderUserName");
    g localg = new g();
    localg.field_sessionId = paramString1;
    localg.field_talker = paramString2;
    localg.field_type = paramInt1;
    localg.field_updateTime = cn.bDw();
    localg.field_selfUsername = a.cUx();
    localg.field_actionPermission = paramInt2;
    localg.field_rejectMsg = paramInt3;
    localg.field_disableSendMsg = paramInt4;
    localg.field_senderUserName = paramString3;
    SystemClock.uptimeMillis();
    boolean bool = replace((IAutoDBItem)localg, false);
    if (bool)
    {
      this.FMm.remove(localg.field_talker + '_' + localg.field_senderUserName);
      this.FMn.remove(paramString1);
      doNotify(localg.field_sessionId);
    }
    Log.i("MicroMsg.TextStatus.TextStatusSessionInfoStorage", "[replaceSessionInfo]  ret=" + bool + ", sessionId=" + paramString1 + ", talker=" + paramString2 + ", actionPermission=" + paramInt2 + ", type=" + paramInt1);
    AppMethodBeat.o(291138);
  }
  
  public final g bdP(String paramString)
  {
    AppMethodBeat.i(291118);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new g();
      AppMethodBeat.o(291118);
      return paramString;
    }
    localObject1 = (g)this.FMn.get(paramString);
    if (localObject1 == null)
    {
      Object localObject3 = (d)this;
      Object localObject2 = "select * , rowid from TextStatusSessionInfo where sessionId = '" + paramString + "' ";
      localObject1 = new g();
      localObject2 = (Closeable)((d)localObject3).db.rawQuery((String)localObject2, null);
      try
      {
        Object localObject4 = (Cursor)localObject2;
        if (((Cursor)localObject4).moveToFirst()) {
          ((g)localObject1).convertFrom((Cursor)localObject4);
        }
        localObject4 = ah.aiuX;
        b.a((Closeable)localObject2, null);
        if (((g)localObject1).systemRowid > 0L)
        {
          ((Map)((d)localObject3).FMn).put(paramString, localObject1);
          paramString = (Map)((d)localObject3).FMm;
          localObject2 = ((g)localObject1).field_talker;
          s.s(localObject2, "cache.field_talker");
          localObject3 = ((g)localObject1).field_senderUserName;
          s.s(localObject3, "cache.field_senderUserName");
          paramString.put((String)localObject2 + '_' + (String)localObject3, localObject1);
        }
        AppMethodBeat.o(291118);
        return localObject1;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(291118);
          throw paramString;
        }
        finally
        {
          b.a((Closeable)localObject2, paramString);
          AppMethodBeat.o(291118);
        }
      }
    }
    AppMethodBeat.o(291118);
    return localg;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusSessionInfoStorage$Companion;", "", "()V", "TABLE", "", "TABLE_CREATE_SQL", "", "kotlin.jvm.PlatformType", "getTABLE_CREATE_SQL", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.h.d
 * JD-Core Version:    0.7.0.1
 */