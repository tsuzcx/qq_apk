package com.tencent.mm.plugin.textstatus.conversation.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.conversation.d.a;
import com.tencent.mm.plugin.textstatus.j.c;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusGreetingItemStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteAll", "", "getByNewMsgId", "newMsgId", "", "getGreetingCnt", "", "getGreetingConversation", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "getList", "", "getUnreadCount", "afterTime", "insertItem", "map", "", "addBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "markRead", "pickFirst", "query", "offset", "nextCount", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<com.tencent.mm.plugin.textstatus.conversation.d.d>
{
  public static final b.a TjE;
  private static final String TjF;
  private static final String[] ptU;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(291078);
    TjE = new b.a((byte)0);
    com.tencent.mm.plugin.textstatus.conversation.d.d.a locala = com.tencent.mm.plugin.textstatus.conversation.d.d.TiW;
    ptU = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.textstatus.conversation.d.d.access$getInfo$cp(), "TextStatusGreetingItem") };
    TjF = "markUnread";
    AppMethodBeat.o(291078);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.textstatus.conversation.d.d.access$getInfo$cp(), "TextStatusGreetingItem", null);
    AppMethodBeat.i(291049);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(291049);
  }
  
  public static a hGE()
  {
    AppMethodBeat.i(291063);
    Object localObject = com.tencent.mm.plugin.textstatus.conversation.g.d.Tjx;
    if (com.tencent.mm.plugin.textstatus.conversation.g.d.hGA())
    {
      localObject = new a();
      ((a)localObject).nickname = MMApplicationContext.getContext().getString(a.h.TgF);
      ((a)localObject).field_sessionId = "textstatussayhisessionholder";
      AppMethodBeat.o(291063);
      return localObject;
    }
    AppMethodBeat.o(291063);
    return null;
  }
  
  public final com.tencent.mm.plugin.textstatus.conversation.d.d a(Map<String, String> paramMap, cy paramcy)
  {
    long l = 0L;
    AppMethodBeat.i(291091);
    s.u(paramMap, "map");
    s.u(paramcy, "addBypMsg");
    com.tencent.mm.plugin.textstatus.conversation.d.d locald = new com.tencent.mm.plugin.textstatus.conversation.d.d();
    locald.field_newMsgId = paramcy.YFg.Njv;
    locald.field_createTime = paramcy.YFg.CreateTime;
    locald.field_hash_username = ((String)paramMap.get(".statussquareprivatechatgreeting.hash_username"));
    locald.field_encUsername = ((String)paramMap.get(".statussquareprivatechatgreeting.enc_username"));
    locald.field_tag = ((String)paramMap.get(".statussquareprivatechatgreeting.tag"));
    locald.field_source_id = ((String)paramMap.get(".statussquareprivatechatgreeting.source_id"));
    locald.field_session_id = ((String)paramMap.get(".statussquareprivatechatgreeting.session_id"));
    locald.field_plain = ((String)paramMap.get(".statussquareprivatechatgreeting.plain"));
    paramcy = (String)paramMap.get(".statussquareprivatechatgreeting.card_key");
    int i;
    if (paramcy == null)
    {
      locald.field_card_key = l;
      locald.field_status_id = ((String)paramMap.get(".statussquareprivatechatgreeting.status_id"));
      paramMap = (String)paramMap.get(".statussquareprivatechatgreeting.modify_count");
      if (paramMap != null) {
        break label284;
      }
      i = 0;
    }
    for (;;)
    {
      locald.field_modify_count = i;
      locald.field_canChatting = 0;
      super.insert((IAutoDBItem)locald);
      Log.i("MicroMsg.TextStatus.TextStatusGreetingItemStorage", "insertItem: item:" + locald + ' ');
      AppMethodBeat.o(291091);
      return locald;
      paramcy = n.bJH(paramcy);
      if (paramcy == null) {
        break;
      }
      l = paramcy.longValue();
      break;
      label284:
      paramMap = n.bJF(paramMap);
      if (paramMap == null) {
        i = 0;
      } else {
        i = paramMap.intValue();
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.textstatus.conversation.d.d> fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(291114);
    Log.i("MicroMsg.TextStatus.TextStatusGreetingItemStorage", "query() called with: offset = " + paramInt1 + ", nextCount = " + paramInt2);
    List localList = c.TABLE.selectAll().orderBy(p.listOf(c.CREATETIME.orderDesc())).limit(paramInt2, paramInt1).build().multiQuery(this.db, com.tencent.mm.plugin.textstatus.conversation.d.d.class);
    AppMethodBeat.o(291114);
    return localList;
  }
  
  public final void hGD()
  {
    AppMethodBeat.i(291099);
    ISQLiteDatabase localISQLiteDatabase = this.db;
    com.tencent.mm.plugin.textstatus.h.f.d.a locala = com.tencent.mm.plugin.textstatus.h.f.d.TnL;
    localISQLiteDatabase.execSQL(com.tencent.mm.plugin.textstatus.h.f.d.gGG(), "update TextStatusGreetingItem set Read = 1 where Read != 1");
    doNotify(TjF, 6, null);
    AppMethodBeat.o(291099);
  }
  
  public final com.tencent.mm.plugin.textstatus.conversation.d.d hGF()
  {
    AppMethodBeat.i(291108);
    Object localObject = c.TABLE;
    s.s(localObject, "TABLE");
    localObject = (com.tencent.mm.plugin.textstatus.conversation.d.d)((SingleTable)localObject).selectAll().orderBy(p.listOf(c.CREATETIME.orderDesc())).limit(1, 0).build().singleQuery(this.db, com.tencent.mm.plugin.textstatus.conversation.d.d.class);
    AppMethodBeat.o(291108);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.h.b
 * JD-Core Version:    0.7.0.1
 */