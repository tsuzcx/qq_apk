package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.emoji.b.c.c.a;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clear", "", "dump", "get", "desc", "getInfoFromDb", "set", "info", "Companion", "plugin-emojisdk_release"})
public final class g
  extends MAutoStorage<com.tencent.mm.emoji.b.c.c>
{
  private static final String[] LQe;
  private static final String TAG = "MicroMsg.EmojiSuggestCacheStorage";
  public static final String VIF = "EmojiSuggestCacheInfo";
  public static final g.a VIG;
  public final ISQLiteDatabase db;
  public final com.tencent.mm.memory.a.c<String, com.tencent.mm.emoji.b.c.c> mEF;
  
  static
  {
    AppMethodBeat.i(228254);
    VIG = new g.a((byte)0);
    VIF = "EmojiSuggestCacheInfo";
    c.a locala = com.tencent.mm.emoji.b.c.c.jKA;
    LQe = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.emoji.b.c.c.access$getInfo$cp(), VIF) };
    TAG = "MicroMsg.EmojiSuggestCacheStorage";
    AppMethodBeat.o(228254);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.emoji.b.c.c.access$getInfo$cp(), "EmojiSuggestCacheInfo", null);
    AppMethodBeat.i(228252);
    this.db = paramISQLiteDatabase;
    this.mEF = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(228252);
  }
  
  private com.tencent.mm.emoji.b.c.c bxQ(String paramString)
  {
    AppMethodBeat.i(228247);
    p.k(paramString, "desc");
    com.tencent.mm.emoji.b.c.c localc = new com.tencent.mm.emoji.b.c.c();
    localc.field_desc = paramString;
    super.get((IAutoDBItem)localc, new String[] { getPrimaryKey() });
    if (localc.isValid())
    {
      AppMethodBeat.o(228247);
      return localc;
    }
    AppMethodBeat.o(228247);
    return null;
  }
  
  public final void Y()
  {
    AppMethodBeat.i(228250);
    Cursor localCursor = this.db.rawQuery("select * from " + VIF, null, 2);
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
          Object localObject1 = new dut();
          Object localObject3 = (a)localObject1;
          byte[] arrayOfByte = ((com.tencent.mm.emoji.b.c.c)localObject2).field_content;
          try
          {
            ((a)localObject3).parseFrom(arrayOfByte);
            localObject3 = TAG;
            localObject2 = new StringBuilder("dump: ").append(i).append(": ").append(((com.tencent.mm.emoji.b.c.c)localObject2).field_desc).append(", ").append(((com.tencent.mm.emoji.b.c.c)localObject2).field_updateTime).append("; ");
            localObject1 = ((dut)localObject1).TdL;
            p.j(localObject1, "rsp.Emoji");
            Log.i((String)localObject3, j.a((Iterable)localObject1, null, null, null, 0, null, (b)g.b.VIH, 31));
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
      AppMethodBeat.o(228250);
      return;
      i = 0;
    }
  }
  
  public final void a(com.tencent.mm.emoji.b.c.c paramc)
  {
    AppMethodBeat.i(228244);
    p.k(paramc, "info");
    this.mEF.put(paramc.field_desc, paramc);
    super.replace((IAutoDBItem)paramc);
    AppMethodBeat.o(228244);
  }
  
  public final com.tencent.mm.emoji.b.c.c bxP(String paramString)
  {
    AppMethodBeat.i(228243);
    p.k(paramString, "desc");
    com.tencent.mm.emoji.b.c.c localc = (com.tencent.mm.emoji.b.c.c)this.mEF.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(228243);
      return localc;
    }
    paramString = bxQ(paramString);
    if (paramString != null) {
      this.mEF.put(paramString.field_desc, paramString);
    }
    AppMethodBeat.o(228243);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.g
 * JD-Core Version:    0.7.0.1
 */