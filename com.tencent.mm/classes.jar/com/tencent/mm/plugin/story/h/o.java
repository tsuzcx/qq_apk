package com.tencent.mm.plugin.story.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByStoryId", "", "storyId", "", "droptable", "dumpinfo", "", "getAllData", "", "getByStoryId", "insert", "", "item", "update", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends MAutoStorage<n>
{
  private static final String[] SsR;
  public static final o.a Stv;
  private static final String TAG;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119610);
    Stv = new o.a((byte)0);
    n.a locala = n.Stu;
    SsR = new String[] { MAutoStorage.getCreateSQLs(n.access$getInfo$cp(), "StoryVideoCacheInfo") };
    TAG = "MicroMsg.StoryVideoCacheStorage";
    AppMethodBeat.o(119610);
  }
  
  public o(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, n.access$getInfo$cp(), "StoryVideoCacheInfo", hw.INDEX_CREATE);
    AppMethodBeat.i(119609);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119609);
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(119604);
    s.u(paramn, "item");
    boolean bool = super.insert((IAutoDBItem)paramn);
    AppMethodBeat.o(119604);
    return bool;
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(119606);
    s.u(paramn, "item");
    boolean bool = super.update((IAutoDBItem)paramn, new String[0]);
    AppMethodBeat.o(119606);
    return bool;
  }
  
  public final void gGK()
  {
    AppMethodBeat.i(119608);
    int i = this.db.delete("StoryVideoCacheInfo", null, null);
    Log.i(TAG, s.X("dropTable ", Integer.valueOf(i)));
    AppMethodBeat.o(119608);
  }
  
  public final n wf(long paramLong)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.o
 * JD-Core Version:    0.7.0.1
 */