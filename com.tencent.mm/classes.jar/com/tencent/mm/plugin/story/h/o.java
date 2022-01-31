package com.tencent.mm.plugin.story.h;

import a.l;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ey;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByStoryId", "", "storyId", "", "droptable", "dumpinfo", "", "getAllData", "", "getByStoryId", "insert", "", "item", "update", "Companion", "plugin-story_release"})
public final class o
  extends com.tencent.mm.sdk.e.j<n>
{
  private static final String TAG = "MicroMsg.StoryVideoCacheStorage";
  private static final String[] sGv;
  public static final o.a sHd;
  public final e db;
  
  static
  {
    AppMethodBeat.i(109985);
    sHd = new o.a((byte)0);
    n.a locala = n.sHc;
    sGv = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(n.cEM(), "StoryVideoCacheInfo") };
    TAG = "MicroMsg.StoryVideoCacheStorage";
    AppMethodBeat.o(109985);
  }
  
  public o(e parame)
  {
    super(parame, n.cEM(), "StoryVideoCacheInfo", ey.INDEX_CREATE);
    AppMethodBeat.i(109984);
    this.db = parame;
    AppMethodBeat.o(109984);
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(109979);
    a.f.b.j.q(paramn, "item");
    boolean bool = super.insert((c)paramn);
    AppMethodBeat.o(109979);
    return bool;
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(109981);
    a.f.b.j.q(paramn, "item");
    boolean bool = super.update((c)paramn, new String[0]);
    AppMethodBeat.o(109981);
    return bool;
  }
  
  public final void csu()
  {
    AppMethodBeat.i(109983);
    int i = this.db.delete("StoryVideoCacheInfo", null, null);
    ab.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(109983);
  }
  
  public final n mX(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(109982);
    if (paramLong == 0L)
    {
      ab.i(TAG, "Test get mediaId error " + paramLong + ' ' + bo.dtY());
      AppMethodBeat.o(109982);
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
    AppMethodBeat.o(109982);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.o
 * JD-Core Version:    0.7.0.1
 */