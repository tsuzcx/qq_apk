package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.emoji.c.c.c.a;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearAll", "", "dump", "get", "desc", "getInfoFromDb", "set", "info", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends MAutoStorage<com.tencent.mm.emoji.c.c.c>
{
  private static final String[] SsR;
  private static final String TAG;
  public static final g.a admB;
  public static final String admC;
  public final ISQLiteDatabase db;
  public final com.tencent.mm.memory.a.c<String, com.tencent.mm.emoji.c.c.c> pBj;
  
  static
  {
    AppMethodBeat.i(248969);
    admB = new g.a((byte)0);
    admC = "EmojiSuggestCacheInfo";
    c.a locala = com.tencent.mm.emoji.c.c.c.mjO;
    SsR = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.emoji.c.c.c.access$getInfo$cp(), admC) };
    TAG = "MicroMsg.EmojiSuggestCacheStorage";
    AppMethodBeat.o(248969);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.emoji.c.c.c.access$getInfo$cp(), "EmojiSuggestCacheInfo", null);
    AppMethodBeat.i(248957);
    this.db = paramISQLiteDatabase;
    this.pBj = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(248957);
  }
  
  private com.tencent.mm.emoji.c.c.c bzg(String paramString)
  {
    AppMethodBeat.i(248961);
    s.u(paramString, "desc");
    com.tencent.mm.emoji.c.c.c localc = new com.tencent.mm.emoji.c.c.c();
    localc.field_desc = paramString;
    super.get((IAutoDBItem)localc, new String[] { getPrimaryKey() });
    if (localc.isValid())
    {
      AppMethodBeat.o(248961);
      return localc;
    }
    AppMethodBeat.o(248961);
    return null;
  }
  
  public final void a(com.tencent.mm.emoji.c.c.c paramc)
  {
    AppMethodBeat.i(248976);
    s.u(paramc, "info");
    this.pBj.put(paramc.field_desc, paramc);
    super.replace((IAutoDBItem)paramc);
    AppMethodBeat.o(248976);
  }
  
  public final void aQ()
  {
    AppMethodBeat.i(248982);
    Cursor localCursor = this.db.rawQuery(s.X("select * from ", admC), null, 2);
    int i;
    if (localCursor != null)
    {
      i = 0;
      for (;;)
      {
        if (localCursor.moveToNext())
        {
          Object localObject2 = new com.tencent.mm.emoji.c.c.c();
          ((com.tencent.mm.emoji.c.c.c)localObject2).convertFrom(localCursor);
          Object localObject1 = new enr();
          Object localObject3 = (a)localObject1;
          byte[] arrayOfByte = ((com.tencent.mm.emoji.c.c.c)localObject2).field_content;
          try
          {
            ((a)localObject3).parseFrom(arrayOfByte);
            localObject3 = TAG;
            localObject2 = new StringBuilder("dump: ").append(i).append(": ").append(((com.tencent.mm.emoji.c.c.c)localObject2).field_desc).append(", ").append(((com.tencent.mm.emoji.c.c.c)localObject2).field_updateTime).append("; ");
            localObject1 = ((enr)localObject1).aaqZ;
            s.s(localObject1, "rsp.Emoji");
            Log.i((String)localObject3, p.a((Iterable)localObject1, null, null, null, 0, null, (b)b.admD, 31));
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
      Log.i(TAG, s.X("dump done: count ", Integer.valueOf(i)));
      AppMethodBeat.o(248982);
      return;
      i = 0;
    }
  }
  
  public final com.tencent.mm.emoji.c.c.c bzf(String paramString)
  {
    AppMethodBeat.i(248973);
    s.u(paramString, "desc");
    com.tencent.mm.emoji.c.c.c localc = (com.tencent.mm.emoji.c.c.c)this.pBj.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(248973);
      return localc;
    }
    paramString = bzg(paramString);
    if (paramString != null) {
      this.pBj.put(paramString.field_desc, paramString);
    }
    AppMethodBeat.o(248973);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<eng, CharSequence>
  {
    public static final b admD;
    
    static
    {
      AppMethodBeat.i(248993);
      admD = new b();
      AppMethodBeat.o(248993);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.g
 * JD-Core Version:    0.7.0.1
 */