package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByStoryId", "", "storyId", "", "droptable", "dumpinfo", "", "getAllData", "", "getByStoryId", "insert", "", "item", "update", "Companion", "plugin-story_release"})
public final class o
  extends j<n>
{
  private static final String TAG = "MicroMsg.StoryVideoCacheStorage";
  public static final o.a zCU;
  private static final String[] zCo;
  public final e db;
  
  static
  {
    AppMethodBeat.i(119610);
    zCU = new o.a((byte)0);
    n.a locala = n.zCT;
    zCo = new String[] { j.getCreateSQLs(n.access$getInfo$cp(), "StoryVideoCacheInfo") };
    TAG = "MicroMsg.StoryVideoCacheStorage";
    AppMethodBeat.o(119610);
  }
  
  public o(e parame)
  {
    super(parame, n.access$getInfo$cp(), "StoryVideoCacheInfo", fy.INDEX_CREATE);
    AppMethodBeat.i(119609);
    this.db = parame;
    AppMethodBeat.o(119609);
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(119604);
    k.h(paramn, "item");
    boolean bool = super.insert((c)paramn);
    AppMethodBeat.o(119604);
    return bool;
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(119606);
    k.h(paramn, "item");
    boolean bool = super.update((c)paramn, new String[0]);
    AppMethodBeat.o(119606);
    return bool;
  }
  
  public final void duq()
  {
    AppMethodBeat.i(119608);
    int i = this.db.delete("StoryVideoCacheInfo", null, null);
    ac.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119608);
  }
  
  public final n yB(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(119607);
    if (paramLong == 0L)
    {
      ac.i(TAG, "Test get mediaId error " + paramLong + ' ' + bs.eWi());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.o
 * JD-Core Version:    0.7.0.1
 */