package com.tencent.mm.plugin.story.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hs;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_UNREAD", "", "commentFlagSet", "Ljava/util/ArrayList;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "buildLimitString", "data", "", "col", "reverse", "", "getAllData", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getAllUnreadSync", "getByStoryId", "storyId", "", "getORIntRange", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<hs>
{
  private static final String[] SQL_CREATE;
  public static final b.a SsK;
  public static final String SsN;
  private static final String TAG;
  private final ArrayList<Integer> SsL;
  public String SsM;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119478);
    SsK = new b.a((byte)0);
    TAG = "MicroMsg.StoryCommentStorage";
    c.a locala = c.SsO;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.access$getInfo$cp(), "StoryCommentSync") };
    SsN = "select * from StoryCommentSync";
    AppMethodBeat.o(119478);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.access$getInfo$cp(), "StoryCommentSync", hs.INDEX_CREATE);
    AppMethodBeat.i(119477);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = a.b.Sst;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(a.b.hyY()) });
    s.s(paramISQLiteDatabase, "asList(ConstantsStory.St…COMMENT_SYNC_FLAG_UNREAD)");
    s.u(paramISQLiteDatabase, "data");
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
        s.s(localObject3, "i");
        localArrayList.add(Integer.valueOf(i | ((Integer)localObject3).intValue()));
      }
      paramISQLiteDatabase.addAll((Collection)new HashSet((Collection)localArrayList));
      paramISQLiteDatabase.add(localObject3);
    }
    paramISQLiteDatabase.add(Integer.valueOf(0));
    ((ArrayList)localObject1).addAll((Collection)paramISQLiteDatabase);
    this.SsL = ((ArrayList)localObject1);
    this.SsM = "";
    paramISQLiteDatabase = new ArrayList();
    localObject1 = this.SsL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue();
      localObject3 = a.b.Sst;
      if ((i & a.b.hyY()) != 0) {
        paramISQLiteDatabase.add(localObject2);
      }
    }
    localObject1 = k.Sth;
    this.SsM = k.a.t((List)paramISQLiteDatabase, "commentFlag");
    AppMethodBeat.o(119477);
  }
  
  public final List<c> eZt()
  {
    AppMethodBeat.i(119476);
    Object localObject2 = SsN;
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
  
  public final c vZ(long paramLong)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */