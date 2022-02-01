package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fq;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_UNREAD", "", "commentFlagSet", "Ljava/util/ArrayList;", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "buildLimitString", "data", "", "col", "reverse", "", "getAllData", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getAllUnreadSync", "getByStoryId", "storyId", "", "getORIntRange", "Companion", "plugin-story_release"})
public final class b
  extends j<fq>
{
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryCommentStorage";
  public static final String yoL = "select * from StoryCommentSync";
  public static final a yoM;
  public final e db;
  private final ArrayList<Integer> yoJ;
  public String yoK;
  
  static
  {
    AppMethodBeat.i(119478);
    yoM = new a((byte)0);
    TAG = "MicroMsg.StoryCommentStorage";
    c.a locala = c.yoN;
    SQL_CREATE = new String[] { j.getCreateSQLs(c.access$getInfo$cp(), "StoryCommentSync") };
    yoL = "select * from StoryCommentSync";
    AppMethodBeat.o(119478);
  }
  
  public b(e parame)
  {
    super(parame, c.access$getInfo$cp(), "StoryCommentSync", fq.INDEX_CREATE);
    AppMethodBeat.i(119477);
    this.db = parame;
    parame = a.b.yot;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(a.b.dKl()) });
    d.g.b.k.g(parame, "Arrays.asList(ConstantsS…COMMENT_SYNC_FLAG_UNREAD)");
    d.g.b.k.h(parame, "data");
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
        d.g.b.k.g(localObject3, "i");
        localArrayList.add(Integer.valueOf(i | ((Integer)localObject3).intValue()));
      }
      parame.addAll((Collection)new HashSet((Collection)localArrayList));
      parame.add(localObject3);
    }
    parame.add(Integer.valueOf(0));
    ((ArrayList)localObject1).addAll((Collection)parame);
    this.yoJ = ((ArrayList)localObject1);
    this.yoK = "";
    parame = new ArrayList();
    localObject1 = this.yoJ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue();
      localObject3 = a.b.yot;
      if ((i & a.b.dKl()) != 0) {
        parame.add(localObject2);
      }
    }
    localObject1 = k.ypq;
    this.yoK = k.a.j((List)parame, "commentFlag");
    AppMethodBeat.o(119477);
  }
  
  public final List<c> dKw()
  {
    AppMethodBeat.i(119476);
    Object localObject2 = yoL;
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
  
  public final c tS(long paramLong)
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage$Companion;", "", "()V", "EventNotifyCommentRead", "", "EventNotifyCommentUnread", "NotifyCommentRead", "", "NotifyCommentUnread", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SqlSelectAll", "TAG", "Table", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.b
 * JD-Core Version:    0.7.0.1
 */