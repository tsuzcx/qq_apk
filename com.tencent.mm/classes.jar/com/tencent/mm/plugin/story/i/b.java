package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gq;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_UNREAD", "", "commentFlagSet", "Ljava/util/ArrayList;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "buildLimitString", "data", "", "col", "reverse", "", "getAllData", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getAllUnreadSync", "getByStoryId", "storyId", "", "getORIntRange", "Companion", "plugin-story_release"})
public final class b
  extends MAutoStorage<gq>
{
  public static final String FvX = "select * from StoryCommentSync";
  public static final a FvY;
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryCommentStorage";
  private final ArrayList<Integer> FvV;
  public String FvW;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119478);
    FvY = new a((byte)0);
    TAG = "MicroMsg.StoryCommentStorage";
    c.a locala = c.FvZ;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.access$getInfo$cp(), "StoryCommentSync") };
    FvX = "select * from StoryCommentSync";
    AppMethodBeat.o(119478);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.access$getInfo$cp(), "StoryCommentSync", gq.INDEX_CREATE);
    AppMethodBeat.i(119477);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = a.b.FvF;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(a.b.frk()) });
    p.g(paramISQLiteDatabase, "Arrays.asList(ConstantsS…COMMENT_SYNC_FLAG_UNREAD)");
    p.h(paramISQLiteDatabase, "data");
    Object localObject2 = new ArrayList((Collection)paramISQLiteDatabase);
    paramISQLiteDatabase = new HashSet();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramISQLiteDatabase.iterator();
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        p.g(localObject3, "i");
        localArrayList.add(Integer.valueOf(i | ((Integer)localObject3).intValue()));
      }
      paramISQLiteDatabase.addAll((Collection)new HashSet((Collection)localArrayList));
      paramISQLiteDatabase.add(localObject3);
    }
    paramISQLiteDatabase.add(Integer.valueOf(0));
    ((ArrayList)localObject1).addAll((Collection)paramISQLiteDatabase);
    this.FvV = ((ArrayList)localObject1);
    this.FvW = "";
    paramISQLiteDatabase = new ArrayList();
    localObject1 = this.FvV.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue();
      localObject3 = a.b.FvF;
      if ((i & a.b.frk()) != 0) {
        paramISQLiteDatabase.add(localObject2);
      }
    }
    localObject1 = k.FwC;
    this.FvW = k.a.k((List)paramISQLiteDatabase, "commentFlag");
    AppMethodBeat.o(119477);
  }
  
  public final c Kw(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(119475);
    Object localObject3 = "select * from StoryCommentSync  where storyId = " + paramLong + ' ';
    localObject3 = this.db.rawQuery((String)localObject3, null);
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new c();
        ((c)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(119475);
    return localObject1;
  }
  
  public final List<c> frv()
  {
    AppMethodBeat.i(119476);
    Object localObject2 = FvX;
    Object localObject1 = new ArrayList();
    localObject2 = this.db.rawQuery((String)localObject2, null);
    if (localObject2 != null)
    {
      while (((Cursor)localObject2).moveToNext())
      {
        c localc = new c();
        localc.convertFrom((Cursor)localObject2);
        ((ArrayList)localObject1).add(localc);
      }
      ((Cursor)localObject2).close();
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119476);
    return localObject1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage$Companion;", "", "()V", "EventNotifyCommentRead", "", "EventNotifyCommentUnread", "NotifyCommentRead", "", "NotifyCommentUnread", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SqlSelectAll", "TAG", "Table", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.b
 * JD-Core Version:    0.7.0.1
 */