package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ge;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_UNREAD", "", "commentFlagSet", "Ljava/util/ArrayList;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "buildLimitString", "data", "", "col", "reverse", "", "getAllData", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getAllUnreadSync", "getByStoryId", "storyId", "", "getORIntRange", "Companion", "plugin-story_release"})
public final class b
  extends j<ge>
{
  public static final String ATJ = "select * from StoryCommentSync";
  public static final a ATK;
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryCommentStorage";
  private final ArrayList<Integer> ATH;
  public String ATI;
  public final e db;
  
  static
  {
    AppMethodBeat.i(119478);
    ATK = new a((byte)0);
    TAG = "MicroMsg.StoryCommentStorage";
    c.a locala = c.ATL;
    SQL_CREATE = new String[] { j.getCreateSQLs(c.access$getInfo$cp(), "StoryCommentSync") };
    ATJ = "select * from StoryCommentSync";
    AppMethodBeat.o(119478);
  }
  
  public b(e parame)
  {
    super(parame, c.access$getInfo$cp(), "StoryCommentSync", ge.INDEX_CREATE);
    AppMethodBeat.i(119477);
    this.db = parame;
    parame = a.b.ATr;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(a.b.elb()) });
    p.g(parame, "Arrays.asList(ConstantsS…COMMENT_SYNC_FLAG_UNREAD)");
    p.h(parame, "data");
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
        p.g(localObject3, "i");
        localArrayList.add(Integer.valueOf(i | ((Integer)localObject3).intValue()));
      }
      parame.addAll((Collection)new HashSet((Collection)localArrayList));
      parame.add(localObject3);
    }
    parame.add(Integer.valueOf(0));
    ((ArrayList)localObject1).addAll((Collection)parame);
    this.ATH = ((ArrayList)localObject1);
    this.ATI = "";
    parame = new ArrayList();
    localObject1 = this.ATH.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue();
      localObject3 = a.b.ATr;
      if ((i & a.b.elb()) != 0) {
        parame.add(localObject2);
      }
    }
    localObject1 = k.AUo;
    this.ATI = k.a.i((List)parame, "commentFlag");
    AppMethodBeat.o(119477);
  }
  
  public final c AT(long paramLong)
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
  
  public final List<c> elm()
  {
    AppMethodBeat.i(119476);
    Object localObject2 = ATJ;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage$Companion;", "", "()V", "EventNotifyCommentRead", "", "EventNotifyCommentUnread", "NotifyCommentRead", "", "NotifyCommentUnread", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SqlSelectAll", "TAG", "Table", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.b
 * JD-Core Version:    0.7.0.1
 */