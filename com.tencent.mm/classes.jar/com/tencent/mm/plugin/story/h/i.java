package com.tencent.mm.plugin.story.h;

import a.l;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.db;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByDate", "", "date", "", "getStoryHistoryByDate", "isDateExist", "onNotifyChange", "", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "replaceHistoryInfoByDate", "storyHistoryInfo", "set", "info", "Companion", "plugin-story_release"})
public final class i
  extends com.tencent.mm.sdk.e.j<h>
  implements k.a
{
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryHistoryInfoStorage";
  public static final String sGE = "MMStoryHistoryItem";
  private static final String sGG = "select * from MMStoryHistoryItem ";
  public static final i.a sGJ;
  public final e db;
  
  static
  {
    AppMethodBeat.i(109912);
    sGJ = new i.a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfoStorage";
    sGE = "MMStoryHistoryItem";
    h.a locala = h.sGI;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(h.cEM(), sGE) };
    sGG = "select * from " + sGE + ' ';
    AppMethodBeat.o(109912);
  }
  
  public i(e parame)
  {
    super(parame, h.cEM(), sGE, db.INDEX_CREATE);
    AppMethodBeat.i(109911);
    this.db = parame;
    AppMethodBeat.o(109911);
  }
  
  private boolean adD(String paramString)
  {
    AppMethodBeat.i(109908);
    a.f.b.j.q(paramString, "date");
    paramString = sGG + " WHERE " + sGE + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    a.f.b.j.p(paramString, "cu");
    int i = paramString.getCount();
    paramString.close();
    if (i > 0)
    {
      AppMethodBeat.o(109908);
      return true;
    }
    AppMethodBeat.o(109908);
    return false;
  }
  
  private boolean b(h paramh)
  {
    AppMethodBeat.i(109910);
    a.f.b.j.q(paramh, "info");
    boolean bool = super.replace((c)paramh);
    AppMethodBeat.o(109910);
    return bool;
  }
  
  public final void a(String paramString, m paramm) {}
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(109907);
    a.f.b.j.q(paramh, "storyHistoryInfo");
    if (adD(paramh.cEX()))
    {
      bool = update((c)paramh, new String[] { "date" });
      AppMethodBeat.o(109907);
      return bool;
    }
    boolean bool = b(paramh);
    AppMethodBeat.o(109907);
    return bool;
  }
  
  public final h adE(String paramString)
  {
    AppMethodBeat.i(109909);
    a.f.b.j.q(paramString, "date");
    paramString = sGG + " WHERE " + sGE + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToFirst())
    {
      h localh = new h();
      localh.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(109909);
      return localh;
    }
    paramString.close();
    AppMethodBeat.o(109909);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.i
 * JD-Core Version:    0.7.0.1
 */