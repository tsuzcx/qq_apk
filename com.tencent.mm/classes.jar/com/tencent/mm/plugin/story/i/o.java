package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByStoryId", "", "storyId", "", "droptable", "dumpinfo", "", "getAllData", "", "getByStoryId", "insert", "", "item", "update", "Companion", "plugin-story_release"})
public final class o
  extends MAutoStorage<n>
{
  public static final a FwH;
  private static final String[] Fwb;
  private static final String TAG = "MicroMsg.StoryVideoCacheStorage";
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119610);
    FwH = new a((byte)0);
    n.a locala = n.FwG;
    Fwb = new String[] { MAutoStorage.getCreateSQLs(n.access$getInfo$cp(), "StoryVideoCacheInfo") };
    TAG = "MicroMsg.StoryVideoCacheStorage";
    AppMethodBeat.o(119610);
  }
  
  public o(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, n.access$getInfo$cp(), "StoryVideoCacheInfo", gu.INDEX_CREATE);
    AppMethodBeat.i(119609);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119609);
  }
  
  public final n KC(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(119607);
    if (paramLong == 0L)
    {
      Log.i(TAG, "Test get mediaId error " + paramLong + ' ' + Util.getStack());
      AppMethodBeat.o(119607);
      return null;
    }
    Object localObject3 = "select * from StoryVideoCacheInfo  where storyId = '" + paramLong + "' ";
    localObject3 = this.db.rawQuery((String)localObject3, null);
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new n();
        ((n)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(119607);
    return localObject1;
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(119604);
    p.h(paramn, "item");
    boolean bool = super.insert((IAutoDBItem)paramn);
    AppMethodBeat.o(119604);
    return bool;
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(119606);
    p.h(paramn, "item");
    boolean bool = super.update((IAutoDBItem)paramn, new String[0]);
    AppMethodBeat.o(119606);
    return bool;
  }
  
  public final void eIQ()
  {
    AppMethodBeat.i(119608);
    int i = this.db.delete("StoryVideoCacheInfo", null, null);
    Log.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119608);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage$Companion;", "", "()V", "SqlCreate", "", "", "kotlin.jvm.PlatformType", "getSqlCreate", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "getTAG", "()Ljava/lang/String;", "Table", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.o
 * JD-Core Version:    0.7.0.1
 */