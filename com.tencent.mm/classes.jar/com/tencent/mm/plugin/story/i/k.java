package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.f.d;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.eol;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "timeStamp", "excludePrivacy", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "id", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isStoryIdExist", "removeDelList", "set", "storyInfo", "update", "updateByLocal", "storyinfo", "updateSourceTypeBefore", "sourceType", "updateStoryFavorite", "favorite", "updateStoryLocalFlag", "localFlag", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"})
public final class k
  extends MAutoStorage<j>
{
  public static final String Alf = "MMStoryInfo";
  private static final String[] INDEX_CREATE;
  private static String KzD;
  private static String KzN;
  private static String KzP;
  private static final String LQA = " (storyID != 0  ) ";
  private static String LQB;
  private static String LQC;
  private static String LQD;
  public static final k.a LQE;
  private static final String LQy = "select count(*) from MMStoryInfo ";
  private static String LQz;
  private static final String[] SQL_CREATE;
  public static final String TAG = "MicroMsg.StoryInfoStorage";
  private final ArrayList<Integer> Ali;
  private String KzI;
  private String KzK;
  private final ArrayList<Integer> KzT;
  private ISQLiteDatabase LQm;
  private final String LQv;
  private final ArrayList<Integer> LQw;
  private final List<String> LQx;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(119590);
    LQE = new k.a((byte)0);
    TAG = "MicroMsg.StoryInfoStorage";
    LQy = "select count(*) from MMStoryInfo ";
    Alf = "MMStoryInfo";
    KzD = " order by " + Alf + ".createTime desc";
    LQz = " order by " + Alf + ".favoriteTime asc";
    LQA = " (storyID != 0  ) ";
    Object localObject1 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject2 = j.LQu;
    localObject1 = j.dZl() + " ON " + Alf + " ( storyID )";
    localObject2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject3 = j.LQu;
    localObject2 = j.ggj() + " ON " + Alf + " (userName,storyID, createTime)";
    localObject3 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    j.a locala = j.LQu;
    INDEX_CREATE = new String[] { localObject1, localObject2, j.ggk() + " ON " + Alf + " (userName, createTime)" };
    localObject1 = j.LQu;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.access$getInfo$cp(), Alf) };
    AppMethodBeat.o(119590);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.access$getInfo$cp(), Alf, INDEX_CREATE);
    AppMethodBeat.i(119589);
    this.LQm = paramISQLiteDatabase;
    this.LQv = " (storyID != 0 ) ";
    paramISQLiteDatabase = a.d.LPP;
    int i = a.d.gfI();
    paramISQLiteDatabase = a.d.LPP;
    int j = a.d.gfJ();
    paramISQLiteDatabase = a.d.LPP;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.d.gfK()) });
    p.j(paramISQLiteDatabase, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
    this.Ali = k.a.eO(paramISQLiteDatabase);
    paramISQLiteDatabase = a.LPG;
    i = a.gfc();
    paramISQLiteDatabase = a.LPG;
    j = a.gfd();
    paramISQLiteDatabase = a.LPG;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.gfe()) });
    p.j(paramISQLiteDatabase, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
    this.KzT = k.a.eO(paramISQLiteDatabase);
    paramISQLiteDatabase = a.LPG;
    i = a.gfB();
    paramISQLiteDatabase = a.LPG;
    paramISQLiteDatabase = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(a.gfC()) });
    p.j(paramISQLiteDatabase, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
    this.LQw = k.a.eO(paramISQLiteDatabase);
    this.db = this.LQm;
    this.LQx = Collections.synchronizedList((List)new ArrayList());
    paramISQLiteDatabase = new ArrayList();
    localObject1 = this.Ali.iterator();
    Integer localInteger;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.LPP;
      if ((i & a.d.gfI()) != 0)
      {
        i = localInteger.intValue();
        localObject2 = a.d.LPP;
        if ((i & a.d.gfJ()) == 0) {
          paramISQLiteDatabase.add(localInteger);
        }
      }
    }
    this.KzI = k.a.m((List)paramISQLiteDatabase, "localFlag");
    paramISQLiteDatabase.clear();
    localObject1 = this.KzT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.LPG;
      if ((i & a.gfc()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    KzN = k.a.m((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.KzT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.LPG;
      if ((i & a.gfd()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    KzP = k.a.m((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.Ali.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.LPP;
      if ((i & a.d.gfJ()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    this.KzK = k.a.m((List)paramISQLiteDatabase, "localFlag");
    paramISQLiteDatabase.clear();
    localObject1 = this.KzT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.LPG;
      if ((i & a.gfe()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    LQC = k.a.m((List)paramISQLiteDatabase, "sourceType");
    paramISQLiteDatabase.clear();
    localObject1 = this.LQw.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.LPG;
      if ((i & a.gfB()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    LQB = k.a.b((List)paramISQLiteDatabase, "itemStoryFlag", true);
    paramISQLiteDatabase.clear();
    localObject1 = this.LQw.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.LPG;
      if ((i & a.gfC()) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    LQD = k.a.m((List)paramISQLiteDatabase, "itemStoryFlag");
    AppMethodBeat.o(119589);
  }
  
  private j RS(long paramLong)
  {
    AppMethodBeat.i(119564);
    if (paramLong >= 0L)
    {
      localj = aiv((int)paramLong);
      AppMethodBeat.o(119564);
      return localj;
    }
    j localj = RU(paramLong);
    AppMethodBeat.o(119564);
    return localj;
  }
  
  private static String aiw(int paramInt)
  {
    AppMethodBeat.i(119566);
    String str = Alf + ".createTime>" + paramInt;
    AppMethodBeat.o(119566);
    return str;
  }
  
  private static String cA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119565);
    if (paramBoolean)
    {
      paramString = " WHERE " + KzN;
      AppMethodBeat.o(119565);
      return paramString;
    }
    paramString = " WHERE " + Alf + ".userName='" + Util.escapeSqlValue(paramString) + "' AND " + KzP;
    AppMethodBeat.o(119565);
    return paramString;
  }
  
  private static String cJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119567);
    paramString = "select *,rowid from MMStoryInfo " + cA(paramString, paramBoolean);
    AppMethodBeat.o(119567);
    return paramString;
  }
  
  private long p(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(119556);
    p.k(paramString, "baseSql");
    Object localObject = paramString;
    if (paramLong != 0L) {
      localObject = paramString + " AND " + Alf + ".storyID < '" + paramLong + '\'';
    }
    paramString = (String)localObject + KzD + " limit " + paramInt;
    Log.d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(paramString)));
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToLast())
    {
      localObject = new j();
      p.j(paramString, "cu");
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
  
  public final j RR(long paramLong)
  {
    AppMethodBeat.i(119560);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  where " + Alf + ".storyID=" + paramLong + " limit 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      p.j(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119560);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119560);
    return null;
  }
  
  public final boolean RT(long paramLong)
  {
    AppMethodBeat.i(119576);
    if (this.db.delete(Alf, "storyID=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(119576);
      return true;
    }
    AppMethodBeat.o(119576);
    return false;
  }
  
  public final j RU(long paramLong)
  {
    AppMethodBeat.i(119578);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  WHERE " + Alf + ".storyID=" + paramLong;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      p.j(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119578);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119578);
    return null;
  }
  
  public final int RV(long paramLong)
  {
    AppMethodBeat.i(119584);
    j localj = RS(paramLong);
    if (localj != null)
    {
      int i = localj.field_readCount;
      AppMethodBeat.o(119584);
      return i;
    }
    AppMethodBeat.o(119584);
    return 0;
  }
  
  public final boolean U(long paramLong, String paramString)
  {
    AppMethodBeat.i(119577);
    p.k(paramString, "username");
    boolean bool = RT(paramLong);
    j localj = new j();
    localj.field_userName = paramString;
    localj.field_storyID = paramLong;
    doNotify("notify_story_info_delete", 1, localj);
    AppMethodBeat.o(119577);
    return bool;
  }
  
  public final int a(int paramInt, j paramj)
  {
    AppMethodBeat.i(119562);
    p.k(paramj, "storyinfo");
    Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
    if (j.b.gcw().bdE(paramInt + '_' + paramj.field_createTime))
    {
      AppMethodBeat.o(119562);
      return -1;
    }
    paramj = paramj.convertTo();
    paramj.remove("rowid");
    localObject = this.db;
    String str = Alf;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.LQu;
    paramInt = ((ISQLiteDatabase)localObject).update(str, paramj, j.ggi() + "=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(119562);
    return paramInt;
  }
  
  public final long a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119582);
    p.k(paramString, "username");
    paramLong = p("select *,rowid from MMStoryInfo  " + cA(paramString, paramBoolean) + " AND " + LQD, paramLong, paramInt);
    AppMethodBeat.o(119582);
    return paramLong;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(119572);
    p.k(paramString, "userName");
    Object localObject1 = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + cA(paramString, paramBoolean1) + ' ';
    paramString = paramString + " AND " + aiw(paramInt);
    Object localObject2 = new StringBuilder().append(paramString);
    if (paramBoolean1) {}
    for (paramString = KzD;; paramString = " AND " + LQA + " AND " + LQB + ' ' + KzD)
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
      paramString = d.LFP;
      d.aib(((ArrayList)localObject1).size());
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
        if (!((j)localObject2).ggf()) {}
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
    p.k(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      Object localObject = "select *,rowid from MMStoryInfo  " + cA(paramString, paramBoolean) + " AND " + LQD + ' ';
      paramString = (String)localObject;
      if (paramLong < 0L) {
        paramString = (String)localObject + " AND storyID >= " + paramLong;
      }
      localObject = paramString + KzD;
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
  
  public final boolean agJ(int paramInt)
  {
    AppMethodBeat.i(119575);
    ISQLiteDatabase localISQLiteDatabase = this.db;
    String str = Alf;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.LQu;
    if (localISQLiteDatabase.delete(str, j.ggi() + "=?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      AppMethodBeat.o(119575);
      return true;
    }
    AppMethodBeat.o(119575);
    return false;
  }
  
  public final j aiv(int paramInt)
  {
    AppMethodBeat.i(119563);
    j localj = new j();
    Object localObject = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(Alf).append('.');
    j.a locala = j.LQu;
    localObject = j.ggi() + '=' + paramInt;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      p.j(localObject, "cu");
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(119563);
      return localj;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(119563);
    return null;
  }
  
  public final long ak(long paramLong, int paramInt)
  {
    AppMethodBeat.i(119581);
    paramLong = p("select *,rowid from MMStoryInfo  WHERE " + LQC, paramLong, paramInt);
    AppMethodBeat.o(119581);
    return paramLong;
  }
  
  public final long b(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119568);
    p.k(paramString, "username");
    paramLong = p(cJ(paramString, paramBoolean), paramLong, paramInt);
    AppMethodBeat.o(119568);
    return paramLong;
  }
  
  public final void bdD(String paramString)
  {
    AppMethodBeat.i(119554);
    p.k(paramString, "localId");
    this.LQx.add(paramString);
    AppMethodBeat.o(119554);
  }
  
  public final boolean bdE(String paramString)
  {
    AppMethodBeat.i(119555);
    p.k(paramString, "localId");
    ??? = this.LQx;
    p.j(???, "delList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (p.h((String)localIterator.next(), paramString))
        {
          Log.i(TAG, "wo wo wo ".concat(String.valueOf(paramString)));
          bool = true;
        }
      }
      paramString = x.aazN;
      AppMethodBeat.o(119555);
      return bool;
    }
  }
  
  public final List<j> cK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119569);
    p.k(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + cA(paramString, paramBoolean);
    Object localObject = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = KzD;; paramString = " AND " + LQA + KzD)
    {
      paramString = paramString;
      paramString = this.db.rawQuery(paramString, null, 2);
      while (paramString.moveToNext())
      {
        localObject = new j();
        p.j(paramString, "cu");
        ((j)localObject).convertFrom(paramString);
        localArrayList.add(localObject);
      }
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119569);
    return paramString;
  }
  
  public final j cL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119583);
    p.k(paramString, "userName");
    j localj = new j();
    paramString = "select *,rowid from MMStoryInfo " + cA(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = KzD;; paramString = " AND " + LQA + KzD)
    {
      paramString = paramString;
      paramString = paramString + " limit 1";
      paramString = this.db.rawQuery(paramString, null, 2);
      if (paramString.moveToFirst())
      {
        p.j(paramString, "cu");
        localj.convertFrom(paramString);
      }
      paramString.close();
      AppMethodBeat.o(119583);
      return localj;
    }
  }
  
  public final ArrayList<j> cM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119586);
    p.k(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = "select *,rowid from MMStoryInfo  " + cA(paramString, paramBoolean) + " AND " + LQD + ' ' + KzD;
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
    p.k(paramj, "storyInfo");
    boolean bool = replace((IAutoDBItem)paramj);
    AppMethodBeat.o(119557);
    return bool;
  }
  
  public final int f(j paramj)
  {
    AppMethodBeat.i(119559);
    p.k(paramj, "storyInfo");
    Log.d(TAG, "storyInfo Insert");
    paramj = paramj.convertTo();
    int i = (int)this.db.insert(Alf, "", paramj);
    Log.d(TAG, "StoryInfo Insert result ".concat(String.valueOf(i)));
    AppMethodBeat.o(119559);
    return i;
  }
  
  public final void fuU()
  {
    AppMethodBeat.i(119579);
    int i = this.db.delete(Alf, null, null);
    Log.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119579);
  }
  
  public final j ggl()
  {
    AppMethodBeat.i(119561);
    int i = cm.bfF();
    Object localObject1 = i.LGd;
    int j = i.gcn();
    localObject1 = new j();
    Object localObject2 = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.KzI).append(" and createTime > ").append(i - j).append(" order by ").append(Alf).append('.');
    Object localObject3 = j.LQu;
    localObject2 = j.ggi() + " asc limit 1";
    localObject3 = this.db.rawQuery((String)localObject2, null, 2);
    Log.d(TAG, "getLastUpload ".concat(String.valueOf(localObject2)));
    if (!((Cursor)localObject3).moveToFirst())
    {
      ((Cursor)localObject3).close();
      AppMethodBeat.o(119561);
      return null;
    }
    p.j(localObject3, "cr");
    ((j)localObject1).convertFrom((Cursor)localObject3);
    ((Cursor)localObject3).close();
    AppMethodBeat.o(119561);
    return localObject1;
  }
  
  public final List<j> gr(String paramString, int paramInt)
  {
    AppMethodBeat.i(119580);
    p.k(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + cA(paramString, true);
    paramString = paramString + " AND createTime BETWEEN " + paramInt + " AND " + (86400 + paramInt - 1);
    paramString = paramString + KzD;
    paramString = this.db.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      j localj = new j();
      p.j(paramString, "cu");
      localj.convertFrom(paramString);
      localArrayList.add(localj);
    }
    paramString.close();
    paramString = (List)localArrayList;
    AppMethodBeat.o(119580);
    return paramString;
  }
  
  public final List<j> m(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119574);
    p.k(paramString, "userName");
    Object localObject1 = (Iterable)a(this, paramString, paramBoolean, paramInt);
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label99:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((j)localObject2).ggc().Urc == 0) {}
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