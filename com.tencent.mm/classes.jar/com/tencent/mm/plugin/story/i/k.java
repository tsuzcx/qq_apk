package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.d;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "timeStamp", "excludePrivacy", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "id", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isStoryIdExist", "removeDelList", "set", "storyInfo", "update", "updateByLocal", "storyinfo", "updateSourceTypeBefore", "sourceType", "updateStoryFavorite", "favorite", "updateStoryLocalFlag", "localFlag", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"})
public final class k
  extends MAutoStorage<j>
{
  private static String EmE;
  private static String EmG;
  private static String Emu;
  private static String FwA;
  private static String FwB;
  public static final k.a FwC;
  private static final String Fww = "select count(*) from MMStoryInfo ";
  private static String Fwx;
  private static final String Fwy = " (storyID != 0  ) ";
  private static String Fwz;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final String TABLE = "MMStoryInfo";
  public static final String TAG = "MicroMsg.StoryInfoStorage";
  private String EmB;
  private final ArrayList<Integer> EmK;
  private String Emz;
  private ISQLiteDatabase Fwj;
  private final String Fwt;
  private final ArrayList<Integer> Fwu;
  private final List<String> Fwv;
  public final ISQLiteDatabase db;
  private final ArrayList<Integer> vDL;
  
  static
  {
    AppMethodBeat.i(119590);
    FwC = new k.a((byte)0);
    TAG = "MicroMsg.StoryInfoStorage";
    Fww = "select count(*) from MMStoryInfo ";
    TABLE = "MMStoryInfo";
    Emu = " order by " + TABLE + ".createTime desc";
    Fwx = " order by " + TABLE + ".favoriteTime asc";
    Fwy = " (storyID != 0  ) ";
    Object localObject1 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject2 = j.Fws;
    localObject1 = j.dyn() + " ON " + TABLE + " ( storyID )";
    localObject2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject3 = j.Fws;
    localObject2 = j.frN() + " ON " + TABLE + " (userName,storyID, createTime)";
    localObject3 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    j.a locala = j.Fws;
    INDEX_CREATE = new String[] { localObject1, localObject2, j.frO() + " ON " + TABLE + " (userName, createTime)" };
    localObject1 = j.Fws;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.access$getInfo$cp(), TABLE) };
    AppMethodBeat.o(119590);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.access$getInfo$cp(), TABLE, INDEX_CREATE);
    AppMethodBeat.i(119589);
    this.Fwj = paramISQLiteDatabase;
    this.Fwt = " (storyID != 0 ) ";
    paramISQLiteDatabase = a.d.FvM;
    int i = a.d.frm();
    paramISQLiteDatabase = a.d.FvM;
    int j = a.d.frn();
    paramISQLiteDatabase = a.d.FvM;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.d.fro()) });
    p.g(paramISQLiteDatabase, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
    this.vDL = k.a.eu(paramISQLiteDatabase);
    paramISQLiteDatabase = a.FvD;
    i = a.fqG();
    paramISQLiteDatabase = a.FvD;
    j = a.fqH();
    paramISQLiteDatabase = a.FvD;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.fqI()) });
    p.g(paramISQLiteDatabase, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
    this.EmK = k.a.eu(paramISQLiteDatabase);
    paramISQLiteDatabase = a.FvD;
    i = a.frf();
    paramISQLiteDatabase = a.FvD;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(a.frg()) });
    p.g(paramISQLiteDatabase, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
    this.Fwu = k.a.eu(paramISQLiteDatabase);
    this.db = this.Fwj;
    this.Fwv = Collections.synchronizedList((List)new ArrayList());
    paramISQLiteDatabase = new ArrayList();
    localObject1 = this.vDL.iterator();
    Integer localInteger;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.FvM;
      if ((i & a.d.frm()) != 0)
      {
        i = localInteger.intValue();
        localObject2 = a.d.FvM;
        if ((i & a.d.frn()) == 0) {
          paramISQLiteDatabase.add(localInteger);
        }
      }
    }
    this.Emz = k.a.k((List)paramISQLiteDatabase, "localFlag");
    paramISQLiteDatabase.clear();
    localObject1 = this.EmK.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.FvD;
      if ((i & a.fqG()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    EmE = k.a.k((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.EmK.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.FvD;
      if ((i & a.fqH()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    EmG = k.a.k((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.vDL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.FvM;
      if ((i & a.d.frn()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    this.EmB = k.a.k((List)paramISQLiteDatabase, "localFlag");
    paramISQLiteDatabase.clear();
    localObject1 = this.EmK.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.FvD;
      if ((i & a.fqI()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    FwA = k.a.k((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.Fwu.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.FvD;
      if ((i & a.frf()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    Fwz = k.a.b((List)paramISQLiteDatabase, "itemStoryFlag", true);
    paramISQLiteDatabase.clear();
    localObject1 = this.Fwu.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.FvD;
      if ((i & a.frg()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    FwB = k.a.k((List)paramISQLiteDatabase, "itemStoryFlag");
    AppMethodBeat.o(119589);
  }
  
  private j Ky(long paramLong)
  {
    AppMethodBeat.i(119564);
    if (paramLong >= 0L)
    {
      localj = aba((int)paramLong);
      AppMethodBeat.o(119564);
      return localj;
    }
    j localj = KA(paramLong);
    AppMethodBeat.o(119564);
    return localj;
  }
  
  private static String abb(int paramInt)
  {
    AppMethodBeat.i(119566);
    String str = TABLE + ".createTime>" + paramInt;
    AppMethodBeat.o(119566);
    return str;
  }
  
  private static String cn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119565);
    if (paramBoolean)
    {
      paramString = " WHERE " + EmE;
      AppMethodBeat.o(119565);
      return paramString;
    }
    paramString = " WHERE " + TABLE + ".userName='" + Util.escapeSqlValue(paramString) + "' AND " + EmG;
    AppMethodBeat.o(119565);
    return paramString;
  }
  
  private static String cv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119567);
    paramString = "select *,rowid from MMStoryInfo " + cn(paramString, paramBoolean);
    AppMethodBeat.o(119567);
    return paramString;
  }
  
  private long o(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119556);
    p.h(paramString, "baseSql");
    Object localObject = paramString;
    if (paramLong != 0L) {
      localObject = paramString + " AND " + TABLE + ".storyID < '" + paramLong + '\'';
    }
    paramString = (String)localObject + Emu + " limit " + paramInt;
    Log.d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(paramString)));
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToLast())
    {
      localObject = new j();
      p.g(paramString, "cu");
      ((j)localObject).convertFrom(paramString);
      paramString.close();
      paramLong = ((j)localObject).field_storyID;
      AppMethodBeat.o(119556);
      return paramLong;
    }
    paramString.close();
    AppMethodBeat.o(119556);
    return 0L;
  }
  
  public final j KA(long paramLong)
  {
    AppMethodBeat.i(119578);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  WHERE " + TABLE + ".storyID=" + paramLong;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      p.g(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119578);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119578);
    return null;
  }
  
  public final int KB(long paramLong)
  {
    AppMethodBeat.i(119584);
    j localj = Ky(paramLong);
    if (localj != null)
    {
      int i = localj.field_readCount;
      AppMethodBeat.o(119584);
      return i;
    }
    AppMethodBeat.o(119584);
    return 0;
  }
  
  public final j Kx(long paramLong)
  {
    AppMethodBeat.i(119560);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  where " + TABLE + ".storyID=" + paramLong + " limit 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      p.g(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119560);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119560);
    return null;
  }
  
  public final boolean Kz(long paramLong)
  {
    AppMethodBeat.i(119576);
    if (this.db.delete(TABLE, "storyID=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(119576);
      return true;
    }
    AppMethodBeat.o(119576);
    return false;
  }
  
  public final boolean M(long paramLong, String paramString)
  {
    AppMethodBeat.i(119577);
    p.h(paramString, "username");
    boolean bool = Kz(paramLong);
    j localj = new j();
    localj.field_userName = paramString;
    localj.field_storyID = paramLong;
    doNotify("notify_story_info_delete", 1, localj);
    AppMethodBeat.o(119577);
    return bool;
  }
  
  public final boolean Zs(int paramInt)
  {
    AppMethodBeat.i(119575);
    ISQLiteDatabase localISQLiteDatabase = this.db;
    String str = TABLE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.Fws;
    if (localISQLiteDatabase.delete(str, j.frM() + "=?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      AppMethodBeat.o(119575);
      return true;
    }
    AppMethodBeat.o(119575);
    return false;
  }
  
  public final int a(int paramInt, j paramj)
  {
    AppMethodBeat.i(119562);
    p.h(paramj, "storyinfo");
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    if (j.b.foc().aSA(paramInt + '_' + paramj.field_createTime))
    {
      AppMethodBeat.o(119562);
      return -1;
    }
    paramj = paramj.convertTo();
    paramj.remove("rowid");
    localObject = this.db;
    String str = TABLE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.Fws;
    paramInt = ((ISQLiteDatabase)localObject).update(str, paramj, j.frM() + "=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(119562);
    return paramInt;
  }
  
  public final long a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119582);
    p.h(paramString, "username");
    paramLong = o("select *,rowid from MMStoryInfo  " + cn(paramString, paramBoolean) + " AND " + FwB, paramLong, paramInt);
    AppMethodBeat.o(119582);
    return paramLong;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(119572);
    p.h(paramString, "userName");
    Object localObject1 = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + cn(paramString, paramBoolean1) + ' ';
    paramString = paramString + " AND " + abb(paramInt);
    Object localObject2 = new StringBuilder().append(paramString);
    if (paramBoolean1) {}
    for (paramString = Emu;; paramString = " AND " + Fwy + " AND " + Fwz + ' ' + Emu)
    {
      paramString = paramString;
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString == null) {
        break label212;
      }
      while (paramString.moveToNext())
      {
        localObject2 = new j();
        ((j)localObject2).convertFrom(paramString);
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramString.close();
    label212:
    if (paramBoolean1)
    {
      paramString = d.FlN;
      d.aaG(((ArrayList)localObject1).size());
    }
    if (paramBoolean2)
    {
      localObject1 = (Iterable)localObject1;
      paramString = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label311:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!((j)localObject2).frJ()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label311;
          }
          paramString.add(localObject2);
          break;
        }
      }
      paramString = (List)paramString;
      AppMethodBeat.o(119572);
      return paramString;
    }
    paramString = (List)localObject1;
    AppMethodBeat.o(119572);
    return paramString;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119587);
    p.h(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      Object localObject = "select *,rowid from MMStoryInfo  " + cn(paramString, paramBoolean) + " AND " + FwB + ' ';
      paramString = (String)localObject;
      if (paramLong < 0L) {
        paramString = (String)localObject + " AND storyID >= " + paramLong;
      }
      localObject = paramString + Emu;
      paramString = (String)localObject;
      if (paramInt > 0) {
        paramString = (String)localObject + " limit " + paramInt;
      }
      Log.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString != null)
      {
        for (;;)
        {
          if (paramString.moveToNext())
          {
            localObject = new j();
            ((j)localObject).convertFrom(paramString);
            localArrayList.add(localObject);
            continue;
            i = 0;
            break;
          }
        }
        paramString.close();
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(119587);
    return paramString;
  }
  
  public final boolean aSA(String paramString)
  {
    AppMethodBeat.i(119555);
    p.h(paramString, "localId");
    ??? = this.Fwv;
    p.g(???, "delList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (p.j((String)localIterator.next(), paramString))
        {
          Log.i(TAG, "wo wo wo ".concat(String.valueOf(paramString)));
          bool = true;
        }
      }
      paramString = x.SXb;
      AppMethodBeat.o(119555);
      return bool;
    }
  }
  
  public final void aSz(String paramString)
  {
    AppMethodBeat.i(119554);
    p.h(paramString, "localId");
    this.Fwv.add(paramString);
    AppMethodBeat.o(119554);
  }
  
  public final long ab(long paramLong, int paramInt)
  {
    AppMethodBeat.i(119581);
    paramLong = o("select *,rowid from MMStoryInfo  WHERE " + FwA, paramLong, paramInt);
    AppMethodBeat.o(119581);
    return paramLong;
  }
  
  public final j aba(int paramInt)
  {
    AppMethodBeat.i(119563);
    j localj = new j();
    Object localObject = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(TABLE).append('.');
    j.a locala = j.Fws;
    localObject = j.frM() + '=' + paramInt;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      p.g(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119563);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119563);
    return null;
  }
  
  public final long c(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119568);
    p.h(paramString, "username");
    paramLong = o(cv(paramString, paramBoolean), paramLong, paramInt);
    AppMethodBeat.o(119568);
    return paramLong;
  }
  
  public final List<j> cw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119569);
    p.h(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + cn(paramString, paramBoolean);
    Object localObject = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = Emu;; paramString = " AND " + Fwy + Emu)
    {
      paramString = paramString;
      paramString = this.db.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        localObject = new j();
        p.g(paramString, "cu");
        ((j)localObject).convertFrom(paramString);
        localArrayList.add(localObject);
      }
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119569);
    return paramString;
  }
  
  public final j cx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119583);
    p.h(paramString, "userName");
    j localj = new j();
    paramString = "select *,rowid from MMStoryInfo " + cn(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = Emu;; paramString = " AND " + Fwy + Emu)
    {
      paramString = paramString;
      paramString = paramString + " limit 1";
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString.moveToFirst())
      {
        p.g(paramString, "cu");
        localj.convertFrom(paramString);
      }
      paramString.close();
      AppMethodBeat.o(119583);
      return localj;
    }
  }
  
  public final ArrayList<j> cy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119586);
    p.h(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = "select *,rowid from MMStoryInfo  " + cn(paramString, paramBoolean) + " AND " + FwB + ' ' + Emu;
      Log.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString != null)
      {
        for (;;)
        {
          if (paramString.moveToNext())
          {
            j localj = new j();
            localj.convertFrom(paramString);
            localArrayList.add(localj);
            continue;
            i = 0;
            break;
          }
        }
        paramString.close();
      }
    }
    AppMethodBeat.o(119586);
    return localArrayList;
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(119557);
    p.h(paramj, "storyInfo");
    boolean bool = replace((IAutoDBItem)paramj);
    AppMethodBeat.o(119557);
    return bool;
  }
  
  public final void eIQ()
  {
    AppMethodBeat.i(119579);
    int i = this.db.delete(TABLE, null, null);
    Log.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119579);
  }
  
  public final int f(j paramj)
  {
    AppMethodBeat.i(119559);
    p.h(paramj, "storyInfo");
    Log.d(TAG, "storyInfo Insert");
    paramj = paramj.convertTo();
    int i = (int)this.db.insert(TABLE, "", paramj);
    Log.d(TAG, "StoryInfo Insert result ".concat(String.valueOf(i)));
    AppMethodBeat.o(119559);
    return i;
  }
  
  public final List<j> fN(String paramString, int paramInt)
  {
    AppMethodBeat.i(119580);
    p.h(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + cn(paramString, true);
    paramString = paramString + " AND createTime BETWEEN " + paramInt + " AND " + (86400 + paramInt - 1);
    paramString = paramString + Emu;
    paramString = this.db.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      j localj = new j();
      p.g(paramString, "cu");
      localj.convertFrom(paramString);
      localArrayList.add(localj);
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119580);
    return paramString;
  }
  
  public final j frP()
  {
    AppMethodBeat.i(119561);
    int i = cl.aWB();
    Object localObject1 = i.Fmb;
    int j = i.fnT();
    localObject1 = new j();
    Object localObject2 = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.Emz).append(" and createTime > ").append(i - j).append(" order by ").append(TABLE).append('.');
    Object localObject3 = j.Fws;
    localObject2 = j.frM() + " asc limit 1";
    localObject3 = this.db.rawQuery((String)localObject2, null, 2);
    Log.d(TAG, "getLastUpload ".concat(String.valueOf(localObject2)));
    if (!((Cursor)localObject3).moveToFirst())
    {
      ((Cursor)localObject3).close();
      AppMethodBeat.o(119561);
      return null;
    }
    p.g(localObject3, "cr");
    ((j)localObject1).convertFrom((Cursor)localObject3);
    ((Cursor)localObject3).close();
    AppMethodBeat.o(119561);
    return localObject1;
  }
  
  public final List<j> j(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119574);
    p.h(paramString, "userName");
    Object localObject1 = (Iterable)a(this, paramString, paramBoolean, paramInt);
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label99:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((j)localObject2).frG().NeD == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label99;
        }
        paramString.add(localObject2);
        break;
      }
    }
    paramString = (List)paramString;
    AppMethodBeat.o(119574);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.k
 * JD-Core Version:    0.7.0.1
 */