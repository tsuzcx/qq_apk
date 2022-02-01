package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.gz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "db", "extLruMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "notifyListener", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "userUpdateMap", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "addStoryStatusNotifyListener", "", "listener", "droptable", "dumpinfo", "get", "userName", "getAllData", "", "getAllUserStatus", "getFavoriteMd5", "getFromCache", "username", "getFromDb", "getMd5", "getStoryStatus", "insertFavMd5", "", "md5", "insertMd5", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "removeStoryStatusNotifyListener", "replace", "", "item", "set", "info", "startNotifyListener", "stopNotifyListener", "updateByLocal", "id", "", "extinfo", "updateCache", "updatePreCache", "updateReadIdWithNotify", "storyId", "updateStoryUserInfo", "storyUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "updateSyncIdWithNotify", "syncId", "createTime", "thumb", "videoUrl", "duration", "Companion", "plugin-story_release"})
public final class g
  extends MAutoStorage<f>
  implements MStorage.IOnStorageChange
{
  private static final String Alf = "StoryExtItem";
  private static final String LQn = "select *, rowid from StoryExtItem ";
  private static final String LQo = "select * from StoryExtItem";
  public static final a LQp;
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.StoryExtInfoStorage";
  public final ArrayList<m> LQj;
  private final c<String, f> LQk;
  private c<String, f> LQl;
  private final ISQLiteDatabase LQm;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119518);
    LQp = new a((byte)0);
    TAG = "MicroMsg.StoryExtInfoStorage";
    Alf = "StoryExtItem";
    f.a locala = f.LQh;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.access$getInfo$cp(), Alf) };
    LQn = "select *, rowid from " + Alf + ' ';
    LQo = "select * from " + Alf;
    AppMethodBeat.o(119518);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.access$getInfo$cp(), Alf, gz.INDEX_CREATE);
    AppMethodBeat.i(119517);
    this.LQm = paramISQLiteDatabase;
    this.LQj = new ArrayList();
    this.LQk = new c(1000);
    this.LQl = new c(1000);
    this.db = this.LQm;
    AppMethodBeat.o(119517);
  }
  
  private final void c(f paramf)
  {
    AppMethodBeat.i(119509);
    if (paramf != null)
    {
      localObject = (CharSequence)paramf.getUserName();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label42;
      }
    }
    label42:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119509);
      return;
    }
    Object localObject = h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    if (((n)localObject).bbL().bwd(paramf.getUserName()))
    {
      this.LQk.put(paramf.getUserName(), paramf);
      this.LQl.remove(paramf.getUserName());
      AppMethodBeat.o(119509);
      return;
    }
    this.LQk.remove(paramf.getUserName());
    this.LQl.put(paramf.getUserName(), paramf);
    AppMethodBeat.o(119509);
  }
  
  public final boolean a(long paramLong, f paramf)
  {
    AppMethodBeat.i(119504);
    p.k(paramf, "extinfo");
    if (b(paramLong, paramf) >= 0) {
      doNotify("notify_story_preload", 3, paramf);
    }
    AppMethodBeat.o(119504);
    return true;
  }
  
  public final int b(long paramLong, f paramf)
  {
    AppMethodBeat.i(119514);
    p.k(paramf, "extinfo");
    ContentValues localContentValues = paramf.convertTo();
    localContentValues.remove("rowid");
    c(paramf);
    int i = this.db.update(Alf, localContentValues, "rowid=?", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(119514);
    return i;
  }
  
  public final boolean b(f paramf)
  {
    AppMethodBeat.i(119503);
    p.k(paramf, "info");
    c(paramf);
    boolean bool = super.replace((IAutoDBItem)paramf);
    AppMethodBeat.o(119503);
    return bool;
  }
  
  public final f bcW(String paramString)
  {
    AppMethodBeat.i(119502);
    p.k(paramString, "userName");
    f localf = bdz(paramString);
    if (localf != null)
    {
      AppMethodBeat.o(119502);
      return localf;
    }
    paramString = bdx(paramString);
    AppMethodBeat.o(119502);
    return paramString;
  }
  
  public final f bdA(String paramString)
  {
    AppMethodBeat.i(119513);
    p.k(paramString, "username");
    f localf2 = (f)this.LQl.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = bdx(paramString);
      c(localf1);
    }
    AppMethodBeat.o(119513);
    return localf1;
  }
  
  public final f bdx(String paramString)
  {
    AppMethodBeat.i(119501);
    f localf = new f();
    localf.field_userName = paramString;
    super.get((IAutoDBItem)localf, new String[] { getPrimaryKey() });
    AppMethodBeat.o(119501);
    return localf;
  }
  
  public final String bdy(String paramString)
  {
    AppMethodBeat.i(119505);
    p.k(paramString, "userName");
    paramString = bdx(paramString).field_md5;
    AppMethodBeat.o(119505);
    return paramString;
  }
  
  public final f bdz(String paramString)
  {
    AppMethodBeat.i(119512);
    p.k(paramString, "username");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119512);
      return null;
    }
    f localf2 = (f)this.LQk.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf2 = (f)this.LQl.get(paramString);
      localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = bdx(paramString);
        c(localf1);
      }
    }
    AppMethodBeat.o(119512);
    return localf1;
  }
  
  public final void fuU()
  {
    AppMethodBeat.i(119516);
    int i = this.db.delete(Alf, null, null);
    Log.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119516);
  }
  
  public final List<f> gfR()
  {
    AppMethodBeat.i(119511);
    Object localObject1 = new ArrayList();
    Object localObject2 = LQo;
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      p.j(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119511);
    return localObject1;
  }
  
  public final List<f> gfY()
  {
    AppMethodBeat.i(119510);
    Object localObject1 = new ArrayList();
    Object localObject2 = LQn;
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      p.j(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119510);
    return localObject1;
  }
  
  public final int lf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119506);
    p.k(paramString1, "userName");
    p.k(paramString2, "md5");
    paramString1 = bdx(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace((IAutoDBItem)paramString1);
    AppMethodBeat.o(119506);
    return 0;
  }
  
  public final int ly(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119507);
    p.k(paramString1, "userName");
    p.k(paramString2, "md5");
    paramString1 = bdx(paramString1);
    paramString1.field_favoriteMd5 = paramString2;
    super.replace((IAutoDBItem)paramString1);
    AppMethodBeat.o(119507);
    return 0;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119515);
    if ((paramString != null) && (paramMStorageEventData != null))
    {
      if ((p.h(paramString, "notify_story_read")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.LQj).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cF(paramString, true);
        }
        paramString = b.LFJ;
        b.gbX();
        AppMethodBeat.o(119515);
        return;
      }
      if ((p.h(paramString, "notify_story_unread")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.LQj).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cF(paramString, false);
        }
        paramString = b.LFJ;
        b.gbX();
        AppMethodBeat.o(119515);
        return;
      }
      if ((p.h(paramString, "notify_story_invalid")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.LQj).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cF(paramString, true);
        }
        paramString = b.LFJ;
        b.gbX();
        AppMethodBeat.o(119515);
        return;
      }
      if ((p.h(paramString, "notify_story_valid")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.LQj).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).cF(paramString, true);
        }
        paramString = b.LFJ;
        b.gbX();
        AppMethodBeat.o(119515);
        return;
      }
      Log.d(TAG, "unknown event ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(119515);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage$Companion;", "", "()V", "EventNotifyStoryInvalid", "", "EventNotifyStoryPreLoad", "EventNotifyStoryRead", "EventNotifyStoryUnread", "EventNotifyStoryValid", "NotifyStoryInvalid", "", "NotifyStoryPreLoad", "NotifyStoryRead", "NotifyStoryUnread", "NotifyStoryValid", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "STORYEXT_SELECT_ALL_STATUS_BEGIN", "SelectAllData", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.g
 * JD-Core Version:    0.7.0.1
 */