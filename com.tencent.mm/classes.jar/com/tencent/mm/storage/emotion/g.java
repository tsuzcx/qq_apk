package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.emoji.b.c.c.a;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clear", "", "dump", "get", "desc", "getInfoFromDb", "set", "info", "Companion", "plugin-emojisdk_release"})
public final class g
  extends MAutoStorage<com.tencent.mm.emoji.b.c.c>
{
  private static final String[] Fwb;
  public static final String OsG = "EmojiSuggestCacheInfo";
  public static final a OsH;
  private static final String TAG = "MicroMsg.EmojiSuggestCacheStorage";
  public final ISQLiteDatabase db;
  public final com.tencent.mm.memory.a.c<String, com.tencent.mm.emoji.b.c.c> jNx;
  
  static
  {
    AppMethodBeat.i(200101);
    OsH = new a((byte)0);
    OsG = "EmojiSuggestCacheInfo";
    c.a locala = com.tencent.mm.emoji.b.c.c.gZz;
    Fwb = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.emoji.b.c.c.access$getInfo$cp(), OsG) };
    TAG = "MicroMsg.EmojiSuggestCacheStorage";
    AppMethodBeat.o(200101);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.emoji.b.c.c.access$getInfo$cp(), "EmojiSuggestCacheInfo", null);
    AppMethodBeat.i(200100);
    this.db = paramISQLiteDatabase;
    this.jNx = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(200100);
  }
  
  private com.tencent.mm.emoji.b.c.c blq(String paramString)
  {
    AppMethodBeat.i(200098);
    p.h(paramString, "desc");
    com.tencent.mm.emoji.b.c.c localc = new com.tencent.mm.emoji.b.c.c();
    localc.field_desc = paramString;
    super.get((IAutoDBItem)localc, new String[] { getPrimaryKey() });
    if (localc.isValid())
    {
      AppMethodBeat.o(200098);
      return localc;
    }
    AppMethodBeat.o(200098);
    return null;
  }
  
  public final void a(com.tencent.mm.emoji.b.c.c paramc)
  {
    AppMethodBeat.i(200097);
    p.h(paramc, "info");
    this.jNx.put(paramc.field_desc, paramc);
    super.replace((IAutoDBItem)paramc);
    AppMethodBeat.o(200097);
  }
  
  public final com.tencent.mm.emoji.b.c.c blp(String paramString)
  {
    AppMethodBeat.i(200096);
    p.h(paramString, "desc");
    com.tencent.mm.emoji.b.c.c localc = (com.tencent.mm.emoji.b.c.c)this.jNx.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(200096);
      return localc;
    }
    paramString = blq(paramString);
    if (paramString != null) {
      this.jNx.put(paramString.field_desc, paramString);
    }
    AppMethodBeat.o(200096);
    return paramString;
  }
  
  public final void dump()
  {
    AppMethodBeat.i(200099);
    Cursor localCursor = this.db.rawQuery("select * from " + OsG, null, 2);
    int i;
    if (localCursor != null)
    {
      i = 0;
      for (;;)
      {
        if (localCursor.moveToNext())
        {
          Object localObject2 = new com.tencent.mm.emoji.b.c.c();
          ((com.tencent.mm.emoji.b.c.c)localObject2).convertFrom(localCursor);
          Object localObject1 = new dld();
          Object localObject3 = (a)localObject1;
          byte[] arrayOfByte = ((com.tencent.mm.emoji.b.c.c)localObject2).field_content;
          try
          {
            ((a)localObject3).parseFrom(arrayOfByte);
            localObject3 = TAG;
            localObject2 = new StringBuilder("dump: ").append(i).append(": ").append(((com.tencent.mm.emoji.b.c.c)localObject2).field_desc).append(", ").append(((com.tencent.mm.emoji.b.c.c)localObject2).field_updateTime).append("; ");
            localObject1 = ((dld)localObject1).LVc;
            p.g(localObject1, "rsp.Emoji");
            Log.i((String)localObject3, j.a((Iterable)localObject1, null, null, null, 0, null, (b)b.OsI, 31));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { localException });
            }
          }
        }
      }
      localCursor.close();
    }
    for (;;)
    {
      Log.i(TAG, "dump done: count ".concat(String.valueOf(i)));
      AppMethodBeat.o(200099);
      return;
      i = 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "getTable", "()Ljava/lang/String;", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements b<dkt, String>
  {
    public static final b OsI;
    
    static
    {
      AppMethodBeat.i(200095);
      OsI = new b();
      AppMethodBeat.o(200095);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.g
 * JD-Core Version:    0.7.0.1
 */