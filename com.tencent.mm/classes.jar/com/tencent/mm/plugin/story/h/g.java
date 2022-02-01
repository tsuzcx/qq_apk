package com.tencent.mm.plugin.story.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "db", "extLruMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "notifyListener", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "userUpdateMap", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "addStoryStatusNotifyListener", "", "listener", "droptable", "dumpinfo", "get", "userName", "getAllData", "", "getAllUserStatus", "getFavoriteMd5", "getFromCache", "username", "getFromDb", "getMd5", "getStoryStatus", "insertFavMd5", "", "md5", "insertMd5", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "removeStoryStatusNotifyListener", "replace", "", "item", "set", "info", "startNotifyListener", "stopNotifyListener", "updateByLocal", "id", "", "extinfo", "updateCache", "updatePreCache", "updateReadIdWithNotify", "storyId", "updateStoryUserInfo", "storyUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "updateSyncIdWithNotify", "syncId", "createTime", "thumb", "videoUrl", "duration", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends MAutoStorage<f>
  implements MStorage.IOnStorageChange
{
  private static final String[] SQL_CREATE;
  public static final g.a SsV;
  private static final String Sta;
  private static final String Stb;
  private static final String TAG;
  private static final String ptT;
  private final ISQLiteDatabase SsW;
  public final ArrayList<m> SsX;
  private final c<String, f> SsY;
  private c<String, f> SsZ;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119518);
    SsV = new g.a((byte)0);
    TAG = "MicroMsg.StoryExtInfoStorage";
    ptT = "StoryExtItem";
    f.a locala = f.SsS;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.access$getInfo$cp(), ptT) };
    Sta = "select *, rowid from " + ptT + ' ';
    Stb = s.X("select * from ", ptT);
    AppMethodBeat.o(119518);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.access$getInfo$cp(), ptT, hu.INDEX_CREATE);
    AppMethodBeat.i(119517);
    this.SsW = paramISQLiteDatabase;
    this.SsX = new ArrayList();
    this.SsY = new c(1000);
    this.SsZ = new c(1000);
    this.db = this.SsW;
    AppMethodBeat.o(119517);
  }
  
  private final void c(f paramf)
  {
    AppMethodBeat.i(119509);
    if (paramf != null)
    {
      CharSequence localCharSequence = (CharSequence)paramf.getUserName();
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label42;
      }
    }
    label42:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119509);
      return;
    }
    if (((n)h.ax(n.class)).bzA().bxr(paramf.getUserName()))
    {
      this.SsY.put(paramf.getUserName(), paramf);
      this.SsZ.remove(paramf.getUserName());
      AppMethodBeat.o(119509);
      return;
    }
    this.SsY.remove(paramf.getUserName());
    this.SsZ.put(paramf.getUserName(), paramf);
    AppMethodBeat.o(119509);
  }
  
  public final boolean a(long paramLong, f paramf)
  {
    AppMethodBeat.i(119504);
    s.u(paramf, "extinfo");
    if (b(paramLong, paramf) >= 0) {
      doNotify("notify_story_preload", 3, paramf);
    }
    AppMethodBeat.o(119504);
    return true;
  }
  
  public final String aZS(String paramString)
  {
    AppMethodBeat.i(119505);
    s.u(paramString, "userName");
    paramString = bck(paramString).field_md5;
    AppMethodBeat.o(119505);
    return paramString;
  }
  
  public final int b(long paramLong, f paramf)
  {
    AppMethodBeat.i(119514);
    s.u(paramf, "extinfo");
    ContentValues localContentValues = paramf.convertTo();
    localContentValues.remove("rowid");
    c(paramf);
    int i = this.db.update(ptT, localContentValues, "rowid=?", new String[] { s.X("", Long.valueOf(paramLong)) });
    AppMethodBeat.o(119514);
    return i;
  }
  
  public final boolean b(f paramf)
  {
    AppMethodBeat.i(119503);
    s.u(paramf, "info");
    c(paramf);
    boolean bool = super.replace((IAutoDBItem)paramf);
    AppMethodBeat.o(119503);
    return bool;
  }
  
  public final f bbJ(String paramString)
  {
    AppMethodBeat.i(119502);
    s.u(paramString, "userName");
    f localf = bcl(paramString);
    if (localf != null)
    {
      AppMethodBeat.o(119502);
      return localf;
    }
    paramString = bck(paramString);
    AppMethodBeat.o(119502);
    return paramString;
  }
  
  public final f bck(String paramString)
  {
    AppMethodBeat.i(119501);
    f localf = new f();
    localf.field_userName = paramString;
    super.get((IAutoDBItem)localf, new String[] { getPrimaryKey() });
    AppMethodBeat.o(119501);
    return localf;
  }
  
  public final f bcl(String paramString)
  {
    AppMethodBeat.i(119512);
    s.u(paramString, "username");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119512);
      return null;
    }
    f localf2 = (f)this.SsY.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf2 = (f)this.SsZ.get(paramString);
      localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = bck(paramString);
        c(localf1);
      }
    }
    AppMethodBeat.o(119512);
    return localf1;
  }
  
  public final f bcm(String paramString)
  {
    AppMethodBeat.i(119513);
    s.u(paramString, "username");
    f localf2 = (f)this.SsZ.get(paramString);
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = bck(paramString);
      s.s(localf1, "extinfo");
      c(localf1);
    }
    AppMethodBeat.o(119513);
    return localf1;
  }
  
  public final List<f> eZt()
  {
    AppMethodBeat.i(119511);
    Object localObject1 = new ArrayList();
    Object localObject2 = Stb;
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      s.s(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119511);
    return localObject1;
  }
  
  public final void gGK()
  {
    AppMethodBeat.i(119516);
    int i = this.db.delete(ptT, null, null);
    Log.i(TAG, s.X("dropTable ", Integer.valueOf(i)));
    AppMethodBeat.o(119516);
  }
  
  public final List<f> hzp()
  {
    AppMethodBeat.i(119510);
    Object localObject1 = new ArrayList();
    Object localObject2 = Sta;
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    ((Cursor)localObject2).moveToFirst();
    do
    {
      f localf = new f();
      s.s(localObject2, "cu");
      localf.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localf);
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(119510);
    return localObject1;
  }
  
  public final int mO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119506);
    s.u(paramString1, "userName");
    s.u(paramString2, "md5");
    paramString1 = bck(paramString1);
    paramString1.field_md5 = paramString2;
    super.replace((IAutoDBItem)paramString1);
    AppMethodBeat.o(119506);
    return 0;
  }
  
  public final int ng(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119507);
    s.u(paramString1, "userName");
    s.u(paramString2, "md5");
    paramString1 = bck(paramString1);
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
      if ((s.p(paramString, "notify_story_read")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.SsX).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).dl(paramString, true);
        }
        paramString = b.Sjr;
        b.hvo();
        AppMethodBeat.o(119515);
        return;
      }
      if ((s.p(paramString, "notify_story_unread")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.SsX).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).dl(paramString, false);
        }
        paramString = b.Sjr;
        b.hvo();
        AppMethodBeat.o(119515);
        return;
      }
      if ((s.p(paramString, "notify_story_invalid")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.SsX).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).dl(paramString, true);
        }
        paramString = b.Sjr;
        b.hvo();
        AppMethodBeat.o(119515);
        return;
      }
      if ((s.p(paramString, "notify_story_valid")) && ((paramMStorageEventData.obj instanceof f)))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119515);
          throw paramString;
        }
        paramString = ((f)paramString).getUserName();
        paramMStorageEventData = ((Iterable)this.SsX).iterator();
        while (paramMStorageEventData.hasNext()) {
          ((m)paramMStorageEventData.next()).dl(paramString, true);
        }
        paramString = b.Sjr;
        b.hvo();
        AppMethodBeat.o(119515);
        return;
      }
      Log.d(TAG, s.X("unknown event ", paramString));
    }
    AppMethodBeat.o(119515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.g
 * JD-Core Version:    0.7.0.1
 */