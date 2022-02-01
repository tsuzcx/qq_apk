package com.tencent.mm.plugin.textstatus.conversation.h;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearUnreadCount", "", "sessionId", "", "genSceneTypeIndex", "", "get", "getAliasConvCount", "", "scene", "getGreetConvCount", "getLatest", "getLatestRedConv", "afterTime", "getNotifyShowUnreadCount", "getTopPlaceCount", "type", "getUnreadCount", "isExit", "query", "", "offset", "nextCount", "", "queryLimit", "limitCount", "types", "replace", "item", "isNotify", "setEditing", "editing", "setTopPlace", "isTopPlace", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MAutoStorage<com.tencent.mm.plugin.textstatus.conversation.d.a>
{
  public static final a.a TjD;
  private static final String[] ptU;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(291093);
    TjD = new a.a((byte)0);
    com.tencent.mm.plugin.textstatus.conversation.d.a.a locala = com.tencent.mm.plugin.textstatus.conversation.d.a.TiP;
    ptU = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.textstatus.conversation.d.a.access$getInfo$cp(), "TextStatusConversation") };
    AppMethodBeat.o(291093);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.textstatus.conversation.d.a.access$getInfo$cp(), "TextStatusConversation", com.tencent.mm.plugin.textstatus.j.b.INDEX_CREATE);
    AppMethodBeat.i(291051);
    this.db = paramISQLiteDatabase;
    this.db.execSQL("TextStatusConversation", "CREATE INDEX IF NOT EXISTS TextStatusConversation_type_scene_index ON TextStatusConversation(scene,type)");
    AppMethodBeat.o(291051);
  }
  
  /* Error */
  private boolean aAA(String paramString)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 136
    //   8: invokestatic 106	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: invokestatic 142	android/os/SystemClock:uptimeMillis	()J
    //   14: pop2
    //   15: new 144	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 146
    //   21: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 155
    //   30: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 117	com/tencent/mm/plugin/textstatus/conversation/h/a:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   41: aload_1
    //   42: aconst_null
    //   43: invokeinterface 163 3 0
    //   48: checkcast 165	java/io/Closeable
    //   51: astore_1
    //   52: aload_1
    //   53: checkcast 167	android/database/Cursor
    //   56: invokeinterface 170 1 0
    //   61: istore_2
    //   62: iload_2
    //   63: ifle +17 -> 80
    //   66: iconst_1
    //   67: istore_3
    //   68: aload_1
    //   69: aconst_null
    //   70: invokestatic 175	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   73: ldc 135
    //   75: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iload_3
    //   79: ireturn
    //   80: iconst_0
    //   81: istore_3
    //   82: goto -14 -> 68
    //   85: astore 4
    //   87: ldc 135
    //   89: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload 4
    //   94: athrow
    //   95: astore 5
    //   97: aload_1
    //   98: aload 4
    //   100: invokestatic 175	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   103: ldc 135
    //   105: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload 5
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	a
    //   0	111	1	paramString	String
    //   61	2	2	i	int
    //   67	15	3	bool	boolean
    //   85	14	4	localThrowable	Throwable
    //   95	14	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	62	85	finally
    //   87	95	95	finally
  }
  
  private int hGC()
  {
    AppMethodBeat.i(291071);
    SystemClock.uptimeMillis();
    Closeable localCloseable = (Closeable)this.db.rawQuery("select sum(unReadCount) from TextStatusConversation", null);
    try
    {
      Object localObject1 = (Cursor)localCloseable;
      if ((((Cursor)localObject1).moveToFirst()) && (!((Cursor)localObject1).isAfterLast()))
      {
        i = ((Cursor)localObject1).getInt(0);
        localObject1 = ah.aiuX;
        kotlin.f.b.a(localCloseable, null);
        Log.i("MicroMsg.TextStatus.TextStatusConversationStorage", s.X("[getUnreadCount] count=", Integer.valueOf(i)));
        AppMethodBeat.o(291071);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(291071);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, localThrowable);
          AppMethodBeat.o(291071);
        }
        int i = 0;
      }
    }
  }
  
  private final List<com.tencent.mm.plugin.textstatus.conversation.d.a> mf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(291067);
    LinkedList localLinkedList = new LinkedList();
    localObject1 = "select *, rowid from TextStatusConversation ORDER BY placedFlag DESC, updateTime DESC limit " + paramInt2 + " offset " + paramInt1;
    SystemClock.uptimeMillis();
    localObject1 = (Closeable)this.db.rawQuery((String)localObject1, null);
    try
    {
      Cursor localCursor = (Cursor)localObject1;
      if (localCursor.moveToFirst()) {
        while (!localCursor.isAfterLast())
        {
          com.tencent.mm.plugin.textstatus.conversation.d.a locala = new com.tencent.mm.plugin.textstatus.conversation.d.a();
          locala.convertFrom(localCursor);
          locala.prepare();
          localLinkedList.add(locala);
          localCursor.moveToNext();
        }
      }
      ah localah;
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(291067);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(291067);
      }
      localah = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      localObject1 = (List)localThrowable;
      AppMethodBeat.o(291067);
    }
  }
  
  public final boolean aAB(String paramString)
  {
    AppMethodBeat.i(291131);
    s.u(paramString, "sessionId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291131);
      return false;
    }
    com.tencent.mm.plugin.textstatus.conversation.d.a locala = bdO(paramString);
    i = locala.field_unReadCount;
    locala.field_unReadCount = 0;
    locala.field_readStatus = 1;
    locala.field_isRedDot = 0;
    boolean bool = update(locala.systemRowid, (IAutoDBItem)locala);
    doNotify(locala.field_sessionId, 5, locala);
    Log.i("MicroMsg.TextStatus.TextStatusConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + locala.field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(291131);
    return bool;
  }
  
  public final int aAs(String paramString)
  {
    AppMethodBeat.i(291123);
    s.u(paramString, "sessionId");
    SystemClock.uptimeMillis();
    Object localObject1 = s.X("select unReadCount, sum(unReadCount) from TextStatusConversation WHERE sessionId=", paramString);
    localObject1 = (Closeable)this.db.rawQuery((String)localObject1, null);
    try
    {
      Object localObject2 = (Cursor)localObject1;
      if ((((Cursor)localObject2).moveToFirst()) && (!((Cursor)localObject2).isAfterLast()))
      {
        i = ((Cursor)localObject2).getInt(1);
        localObject2 = ah.aiuX;
        kotlin.f.b.a((Closeable)localObject1, null);
        Log.i("MicroMsg.TextStatus.TextStatusConversationStorage", "[getUnreadCount] sessionId=" + paramString + ' ' + i);
        AppMethodBeat.o(291123);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(291123);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject1, paramString);
          AppMethodBeat.o(291123);
        }
        int i = 0;
      }
    }
  }
  
  public final com.tencent.mm.plugin.textstatus.conversation.d.a bdO(String paramString)
  {
    AppMethodBeat.i(291110);
    s.u(paramString, "sessionId");
    Object localObject = "select *, rowid from TextStatusConversation where sessionId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    com.tencent.mm.plugin.textstatus.conversation.d.a locala = new com.tencent.mm.plugin.textstatus.conversation.d.a();
    locala.field_sessionId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        locala.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(291110);
    return locala;
  }
  
  public final List<com.tencent.mm.plugin.textstatus.conversation.d.a> bf(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(291104);
    List localList = mf(paramInt1, paramInt2);
    Log.i("MicroMsg.TextStatus.TextStatusConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " type=" + null + " list size=" + localList.size() + ", scene=" + paramInt3);
    AppMethodBeat.o(291104);
    return localList;
  }
  
  public final int hGB()
  {
    AppMethodBeat.i(291116);
    int i = hGC();
    f localf = f.TjQ;
    int j = f.hGV();
    AppMethodBeat.o(291116);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.h.a
 * JD-Core Version:    0.7.0.1
 */