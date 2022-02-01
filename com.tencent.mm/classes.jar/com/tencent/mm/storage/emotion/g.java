package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.emoji.a.c.c.a;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clear", "", "dump", "get", "desc", "getInfoFromDb", "set", "info", "Companion", "plugin-emojisdk_release"})
public final class g
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.emoji.a.c.c>
{
  private static final String[] Bll;
  public static final String JiO = "EmojiSuggestCacheInfo";
  public static final a JiP;
  private static final String TAG = "MicroMsg.EmojiSuggestCacheStorage";
  public final e db;
  public final com.tencent.mm.memory.a.c<String, com.tencent.mm.emoji.a.c.c> iQC;
  
  static
  {
    AppMethodBeat.i(188630);
    JiP = new a((byte)0);
    JiO = "EmojiSuggestCacheInfo";
    c.a locala = com.tencent.mm.emoji.a.c.c.goG;
    Bll = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.emoji.a.c.c.access$getInfo$cp(), JiO) };
    TAG = "MicroMsg.EmojiSuggestCacheStorage";
    AppMethodBeat.o(188630);
  }
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.emoji.a.c.c.access$getInfo$cp(), "EmojiSuggestCacheInfo", null);
    AppMethodBeat.i(188629);
    this.db = parame;
    this.iQC = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(188629);
  }
  
  private com.tencent.mm.emoji.a.c.c aWr(String paramString)
  {
    AppMethodBeat.i(188627);
    p.h(paramString, "desc");
    com.tencent.mm.emoji.a.c.c localc = new com.tencent.mm.emoji.a.c.c();
    localc.field_desc = paramString;
    super.get((com.tencent.mm.sdk.e.c)localc, new String[] { getPrimaryKey() });
    if (localc.isValid())
    {
      AppMethodBeat.o(188627);
      return localc;
    }
    AppMethodBeat.o(188627);
    return null;
  }
  
  public final void a(com.tencent.mm.emoji.a.c.c paramc)
  {
    AppMethodBeat.i(188626);
    p.h(paramc, "info");
    this.iQC.put(paramc.field_desc, paramc);
    super.replace((com.tencent.mm.sdk.e.c)paramc);
    AppMethodBeat.o(188626);
  }
  
  public final com.tencent.mm.emoji.a.c.c aWq(String paramString)
  {
    AppMethodBeat.i(188625);
    p.h(paramString, "desc");
    com.tencent.mm.emoji.a.c.c localc = (com.tencent.mm.emoji.a.c.c)this.iQC.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(188625);
      return localc;
    }
    paramString = aWr(paramString);
    if (paramString != null) {
      this.iQC.put(paramString.field_desc, paramString);
    }
    AppMethodBeat.o(188625);
    return paramString;
  }
  
  public final void dump()
  {
    AppMethodBeat.i(188628);
    Cursor localCursor = this.db.a("select * from " + JiO, null, 2);
    int i;
    if (localCursor != null)
    {
      i = 0;
      for (;;)
      {
        if (localCursor.moveToNext())
        {
          Object localObject2 = new com.tencent.mm.emoji.a.c.c();
          ((com.tencent.mm.emoji.a.c.c)localObject2).convertFrom(localCursor);
          Object localObject1 = new csu();
          Object localObject3 = (a)localObject1;
          byte[] arrayOfByte = ((com.tencent.mm.emoji.a.c.c)localObject2).field_content;
          try
          {
            ((a)localObject3).parseFrom(arrayOfByte);
            localObject3 = TAG;
            localObject2 = new StringBuilder("dump: ").append(i).append(": ").append(((com.tencent.mm.emoji.a.c.c)localObject2).field_desc).append(", ").append(((com.tencent.mm.emoji.a.c.c)localObject2).field_updateTime).append("; ");
            localObject1 = ((csu)localObject1).GQM;
            p.g(localObject1, "rsp.Emoji");
            ae.i((String)localObject3, d.a.j.a((Iterable)localObject1, null, null, null, 0, null, (b)b.JiQ, 31));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.l("safeParser", "", new Object[] { localException });
            }
          }
        }
      }
      localCursor.close();
    }
    for (;;)
    {
      ae.i(TAG, "dump done: count ".concat(String.valueOf(i)));
      AppMethodBeat.o(188628);
      return;
      i = 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/emotion/EmojiSuggestCacheStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "getTable", "()Ljava/lang/String;", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements b<cso, String>
  {
    public static final b JiQ;
    
    static
    {
      AppMethodBeat.i(188624);
      JiQ = new b();
      AppMethodBeat.o(188624);
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