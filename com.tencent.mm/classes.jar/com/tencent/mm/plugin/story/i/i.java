package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByDate", "", "date", "", "getStoryHistoryByDate", "isDateExist", "onNotifyChange", "", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "replaceHistoryInfoByDate", "storyHistoryInfo", "set", "info", "Companion", "plugin-story_release"})
public final class i
  extends j<h>
  implements k.a
{
  private static final String[] SQL_CREATE;
  public static final String TABLE = "MMStoryHistoryItem";
  private static final String TAG = "MicroMsg.StoryHistoryInfoStorage";
  public static final i.a zCB;
  private static final String zCy = "select * from MMStoryHistoryItem ";
  public final e db;
  
  static
  {
    AppMethodBeat.i(119529);
    zCB = new i.a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfoStorage";
    TABLE = "MMStoryHistoryItem";
    h.a locala = h.zCA;
    SQL_CREATE = new String[] { j.getCreateSQLs(h.access$getInfo$cp(), TABLE) };
    zCy = "select * from " + TABLE + ' ';
    AppMethodBeat.o(119529);
  }
  
  public i(e parame)
  {
    super(parame, h.access$getInfo$cp(), TABLE, dw.INDEX_CREATE);
    AppMethodBeat.i(119528);
    this.db = parame;
    AppMethodBeat.o(119528);
  }
  
  private boolean axf(String paramString)
  {
    AppMethodBeat.i(119525);
    k.h(paramString, "date");
    paramString = zCy + " WHERE " + TABLE + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    k.g(paramString, "cu");
    int i = paramString.getCount();
    paramString.close();
    if (i > 0)
    {
      AppMethodBeat.o(119525);
      return true;
    }
    AppMethodBeat.o(119525);
    return false;
  }
  
  private boolean b(h paramh)
  {
    AppMethodBeat.i(119527);
    k.h(paramh, "info");
    boolean bool = super.replace((c)paramh);
    AppMethodBeat.o(119527);
    return bool;
  }
  
  public final void a(String paramString, m paramm) {}
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(119524);
    k.h(paramh, "storyHistoryInfo");
    if (axf(paramh.dZf()))
    {
      bool = update((c)paramh, new String[] { "date" });
      AppMethodBeat.o(119524);
      return bool;
    }
    boolean bool = b(paramh);
    AppMethodBeat.o(119524);
    return bool;
  }
  
  public final h axg(String paramString)
  {
    AppMethodBeat.i(119526);
    k.h(paramString, "date");
    paramString = zCy + " WHERE " + TABLE + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToFirst())
    {
      h localh = new h();
      localh.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(119526);
      return localh;
    }
    paramString.close();
    AppMethodBeat.o(119526);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.i
 * JD-Core Version:    0.7.0.1
 */