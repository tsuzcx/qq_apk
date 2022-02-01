package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.emoji.a.b.c.a;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clear", "", "dump", "get", "desc", "getInfoFromDb", "set", "info", "Companion", "plugin-emojisdk_release"})
public final class g
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.emoji.a.b.c>
{
  private static final String[] ATN;
  public static final String IOi = "EmojiSuggestCacheInfo";
  public static final a IOj;
  private static final String TAG = "MicroMsg.EmojiSuggestCacheStorage";
  public final e db;
  public final com.tencent.mm.memory.a.c<String, com.tencent.mm.emoji.a.b.c> iNI;
  
  static
  {
    AppMethodBeat.i(219008);
    IOj = new a((byte)0);
    IOi = "EmojiSuggestCacheInfo";
    c.a locala = com.tencent.mm.emoji.a.b.c.gmk;
    ATN = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.emoji.a.b.c.access$getInfo$cp(), IOi) };
    TAG = "MicroMsg.EmojiSuggestCacheStorage";
    AppMethodBeat.o(219008);
  }
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.emoji.a.b.c.access$getInfo$cp(), "EmojiSuggestCacheInfo", null);
    AppMethodBeat.i(219007);
    this.db = parame;
    this.iNI = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(219007);
  }
  
  private com.tencent.mm.emoji.a.b.c aUQ(String paramString)
  {
    AppMethodBeat.i(219005);
    p.h(paramString, "desc");
    com.tencent.mm.emoji.a.b.c localc = new com.tencent.mm.emoji.a.b.c();
    localc.field_desc = paramString;
    super.get((com.tencent.mm.sdk.e.c)localc, new String[] { getPrimaryKey() });
    if (localc.isValid())
    {
      AppMethodBeat.o(219005);
      return localc;
    }
    AppMethodBeat.o(219005);
    return null;
  }
  
  public final void a(com.tencent.mm.emoji.a.b.c paramc)
  {
    AppMethodBeat.i(219004);
    p.h(paramc, "info");
    this.iNI.put(paramc.field_desc, paramc);
    super.replace((com.tencent.mm.sdk.e.c)paramc);
    AppMethodBeat.o(219004);
  }
  
  public final com.tencent.mm.emoji.a.b.c aUP(String paramString)
  {
    AppMethodBeat.i(219003);
    p.h(paramString, "desc");
    com.tencent.mm.emoji.a.b.c localc = (com.tencent.mm.emoji.a.b.c)this.iNI.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(219003);
      return localc;
    }
    paramString = aUQ(paramString);
    if (paramString != null) {
      this.iNI.put(paramString.field_desc, paramString);
    }
    AppMethodBeat.o(219003);
    return paramString;
  }
  
  public final void dump()
  {
    AppMethodBeat.i(219006);
    Cursor localCursor = this.db.a("select * from " + IOi, null, 2);
    int i;
    if (localCursor != null)
    {
      i = 0;
      for (;;)
      {
        if (localCursor.moveToNext())
        {
          Object localObject2 = new com.tencent.mm.emoji.a.b.c();
          ((com.tencent.mm.emoji.a.b.c)localObject2).convertFrom(localCursor);
          Object localObject1 = new csa();
          Object localObject3 = (a)localObject1;
          byte[] arrayOfByte = ((com.tencent.mm.emoji.a.b.c)localObject2).field_content;
          try
          {
            ((a)localObject3).parseFrom(arrayOfByte);
            localObject3 = TAG;
            localObject2 = new StringBuilder("dump: ").append(i).append(": ").append(((com.tencent.mm.emoji.a.b.c)localObject2).field_desc).append(", ").append(((com.tencent.mm.emoji.a.b.c)localObject2).field_updateTime).append("; ");
            localObject1 = ((csa)localObject1).Gxm;
            p.g(localObject1, "rsp.Emoji");
            ad.i((String)localObject3, d.a.j.a((Iterable)localObject1, null, null, null, 0, null, (b)b.IOk, 31));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.l("safeParser", "", new Object[] { localException });
            }
          }
        }
      }
      localCursor.close();
    }
    for (;;)
    {
      ad.i(TAG, "dump done: count ".concat(String.valueOf(i)));
      AppMethodBeat.o(219006);
      return;
      i = 0;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "getTable", "()Ljava/lang/String;", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements b<cru, String>
  {
    public static final b IOk;
    
    static
    {
      AppMethodBeat.i(219002);
      IOk = new b();
      AppMethodBeat.o(219002);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.g
 * JD-Core Version:    0.7.0.1
 */