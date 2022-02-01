package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.er;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteByDate", "", "date", "", "getStoryHistoryByDate", "isDateExist", "onNotifyChange", "", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "replaceHistoryInfoByDate", "storyHistoryInfo", "set", "info", "Companion", "plugin-story_release"})
public final class i
  extends MAutoStorage<h>
  implements MStorage.IOnStorageChange
{
  public static final String Alf = "MMStoryHistoryItem";
  private static final String LQo = "select * from MMStoryHistoryItem ";
  public static final a LQr;
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryHistoryInfoStorage";
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119529);
    LQr = new a((byte)0);
    TAG = "MicroMsg.StoryHistoryInfoStorage";
    Alf = "MMStoryHistoryItem";
    h.a locala = h.LQq;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(h.access$getInfo$cp(), Alf) };
    LQo = "select * from " + Alf + ' ';
    AppMethodBeat.o(119529);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.access$getInfo$cp(), Alf, er.INDEX_CREATE);
    AppMethodBeat.i(119528);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(119528);
  }
  
  private boolean b(h paramh)
  {
    AppMethodBeat.i(119527);
    p.k(paramh, "info");
    boolean bool = super.replace((IAutoDBItem)paramh);
    AppMethodBeat.o(119527);
    return bool;
  }
  
  private boolean bdB(String paramString)
  {
    AppMethodBeat.i(119525);
    p.k(paramString, "date");
    paramString = LQo + " WHERE " + Alf + ".date = '" + paramString + '\'';
    paramString = this.db.rawQuery(paramString, null);
    p.j(paramString, "cu");
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
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(119524);
    p.k(paramh, "storyHistoryInfo");
    if (bdB(paramh.gfZ()))
    {
      bool = update((IAutoDBItem)paramh, new String[] { "date" });
      AppMethodBeat.o(119524);
      return bool;
    }
    boolean bool = b(paramh);
    AppMethodBeat.o(119524);
    return bool;
  }
  
  public final h bdC(String paramString)
  {
    AppMethodBeat.i(119526);
    p.k(paramString, "date");
    paramString = LQo + " WHERE " + Alf + ".date = '" + paramString + '\'';
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
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.i
 * JD-Core Version:    0.7.0.1
 */