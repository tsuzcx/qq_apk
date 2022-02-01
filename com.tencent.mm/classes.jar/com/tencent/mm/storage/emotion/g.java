package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.emoji.a.b.c.a;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clear", "", "dump", "get", "desc", "getInfoFromDb", "set", "info", "Companion", "plugin-emojisdk_release"})
public final class g
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.emoji.a.b.c>
{
  public static final String HaS = "EmojiSuggestCacheInfo";
  public static final g.a HaT;
  private static final String TAG = "MicroMsg.EmojiSuggestCacheStorage";
  private static final String[] zCo;
  public final e db;
  public final com.tencent.mm.memory.a.c<String, com.tencent.mm.emoji.a.b.c> iuF;
  
  static
  {
    AppMethodBeat.i(209882);
    HaT = new g.a((byte)0);
    HaS = "EmojiSuggestCacheInfo";
    c.a locala = com.tencent.mm.emoji.a.b.c.fSG;
    zCo = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.emoji.a.b.c.access$getInfo$cp(), HaS) };
    TAG = "MicroMsg.EmojiSuggestCacheStorage";
    AppMethodBeat.o(209882);
  }
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.emoji.a.b.c.access$getInfo$cp(), "EmojiSuggestCacheInfo", null);
    AppMethodBeat.i(209881);
    this.db = parame;
    this.iuF = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(209881);
  }
  
  private com.tencent.mm.emoji.a.b.c aOZ(String paramString)
  {
    AppMethodBeat.i(209879);
    k.h(paramString, "desc");
    com.tencent.mm.emoji.a.b.c localc = new com.tencent.mm.emoji.a.b.c();
    localc.field_desc = paramString;
    super.get((com.tencent.mm.sdk.e.c)localc, new String[] { getPrimaryKey() });
    if (localc.isValid())
    {
      AppMethodBeat.o(209879);
      return localc;
    }
    AppMethodBeat.o(209879);
    return null;
  }
  
  public final void a(com.tencent.mm.emoji.a.b.c paramc)
  {
    AppMethodBeat.i(209878);
    k.h(paramc, "info");
    this.iuF.put(paramc.field_desc, paramc);
    super.replace((com.tencent.mm.sdk.e.c)paramc);
    AppMethodBeat.o(209878);
  }
  
  public final com.tencent.mm.emoji.a.b.c aOY(String paramString)
  {
    AppMethodBeat.i(209877);
    k.h(paramString, "desc");
    com.tencent.mm.emoji.a.b.c localc = (com.tencent.mm.emoji.a.b.c)this.iuF.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(209877);
      return localc;
    }
    paramString = aOZ(paramString);
    if (paramString != null) {
      this.iuF.put(paramString.field_desc, paramString);
    }
    AppMethodBeat.o(209877);
    return paramString;
  }
  
  public final void dump()
  {
    AppMethodBeat.i(209880);
    Cursor localCursor = this.db.a("select * from " + HaS, null, 2);
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
          Object localObject1 = new cmx();
          Object localObject3 = (a)localObject1;
          byte[] arrayOfByte = ((com.tencent.mm.emoji.a.b.c)localObject2).field_content;
          try
          {
            ((a)localObject3).parseFrom(arrayOfByte);
            localObject3 = TAG;
            localObject2 = new StringBuilder("dump: ").append(i).append(": ").append(((com.tencent.mm.emoji.a.b.c)localObject2).field_desc).append(", ").append(((com.tencent.mm.emoji.a.b.c)localObject2).field_updateTime).append("; ");
            localObject1 = ((cmx)localObject1).EOi;
            k.g(localObject1, "rsp.Emoji");
            ac.i((String)localObject3, d.a.j.a((Iterable)localObject1, null, null, null, 0, null, (b)b.HaU, 31));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.l("safeParser", "", new Object[] { localException });
            }
          }
        }
      }
      localCursor.close();
    }
    for (;;)
    {
      ac.i(TAG, "dump done: count ".concat(String.valueOf(i)));
      AppMethodBeat.o(209880);
      return;
      i = 0;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<cmr, String>
  {
    public static final b HaU;
    
    static
    {
      AppMethodBeat.i(209876);
      HaU = new b();
      AppMethodBeat.o(209876);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.g
 * JD-Core Version:    0.7.0.1
 */