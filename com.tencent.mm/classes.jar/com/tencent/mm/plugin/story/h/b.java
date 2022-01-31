package com.tencent.mm.plugin.story.h;

import a.l;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eu;
import com.tencent.mm.sdk.e.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_UNREAD", "", "commentFlagSet", "Ljava/util/ArrayList;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "buildLimitString", "data", "", "col", "reverse", "", "getAllData", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getAllUnreadSync", "getByStoryId", "storyId", "", "getORIntRange", "Companion", "plugin-story_release"})
public final class b
  extends com.tencent.mm.sdk.e.j<eu>
{
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryCommentStorage";
  public static final String sGr = "select * from StoryCommentSync";
  public static final b.a sGs;
  public final e db;
  private final ArrayList<Integer> sGp;
  public String sGq;
  
  static
  {
    AppMethodBeat.i(109858);
    sGs = new b.a((byte)0);
    TAG = "MicroMsg.StoryCommentStorage";
    c.a locala = c.sGt;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(c.cEM(), "StoryCommentSync") };
    sGr = "select * from StoryCommentSync";
    AppMethodBeat.o(109858);
  }
  
  public b(e parame)
  {
    super(parame, c.cEM(), "StoryCommentSync", eu.INDEX_CREATE);
    AppMethodBeat.i(109857);
    this.db = parame;
    parame = a.b.sFX;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(a.b.cEw()) });
    a.f.b.j.p(parame, "Arrays.asList(ConstantsS…COMMENT_SYNC_FLAG_UNREAD)");
    a.f.b.j.q(parame, "data");
    Object localObject2 = new ArrayList((Collection)parame);
    parame = new HashSet();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = parame.iterator();
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        a.f.b.j.p(localObject3, "i");
        localArrayList.add(Integer.valueOf(i | ((Integer)localObject3).intValue()));
      }
      parame.addAll((Collection)new HashSet((Collection)localArrayList));
      parame.add(localObject3);
    }
    parame.add(Integer.valueOf(0));
    ((ArrayList)localObject1).addAll((Collection)parame);
    this.sGp = ((ArrayList)localObject1);
    this.sGq = "";
    parame = new ArrayList();
    localObject1 = this.sGp.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue();
      localObject3 = a.b.sFX;
      if ((i & a.b.cEw()) != 0) {
        parame.add(localObject2);
      }
    }
    localObject1 = k.sGY;
    this.sGq = k.a.g((List)parame, "commentFlag");
    AppMethodBeat.o(109857);
  }
  
  public final List<c> cEJ()
  {
    AppMethodBeat.i(109856);
    Object localObject2 = sGr;
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
    AppMethodBeat.o(109856);
    return localObject1;
  }
  
  public final c mP(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(109855);
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
    AppMethodBeat.o(109855);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b
 * JD-Core Version:    0.7.0.1
 */