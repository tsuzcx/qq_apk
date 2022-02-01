package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.f.d;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/plugin/story/storage/IStoryStorage;", "vdb", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CON_POST", "", "CON_SERVER", "CON_TYPE_ERROR", "db", "delList", "", "kotlin.jvm.PlatformType", "", "itemFlagSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "localFlagSet", "sourceTypeSet", "getVdb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setVdb", "addDelList", "", "localId", "addReadCount", "storyId", "", "count", "conTimestampAfter", "limitTime", "conTimestampBefore", "conUserWhere", "userName", "isSelf", "", "deleteByLocalId", "deleteByStoryId", "deleteByStoryIdWithNotify", "username", "deleteByUsername", "droptable", "dumpinfo", "get", "getAlbumStoryAfterByStoryId", "minId", "limitCount", "getByLocalId", "getByStoryId", "getByUserName", "getByUserNameAfter", "timeStamp", "excludePrivacy", "getDiedStory", "getFavHistoryMinIdByLimit", "maxId", "getFavStoryByUsername", "getForSnsByUserNameAfter", "getHistoryMinIdByLimit", "getInfoBetweenDate", "createTime", "getLastStoryByName", "getLastUpload", "getMinIdByLimit", "baseSql", "conServer", "getStoryAfterByStoryId", "getStoryById", "id", "getStoryReadCount", "getUserMinIdByLimit", "getUserSql", "getBuf", "checkCount", "inDelList", "isStoryIdExist", "removeDelList", "set", "storyInfo", "update", "updateByLocal", "storyinfo", "updateSourceTypeBefore", "sourceType", "updateStoryFavorite", "favorite", "updateStoryLocalFlag", "localFlag", "updateStoryVisibility", "visibilitySelf", "Companion", "plugin-story_release"})
public final class k
  extends com.tencent.mm.sdk.e.j<j>
{
  private static final String AUi = "select count(*) from MMStoryInfo ";
  private static String AUj;
  private static final String AUk = " (storyID != 0  ) ";
  private static String AUl;
  private static String AUm;
  private static String AUn;
  public static final k.a AUo;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final String TABLE = "MMStoryInfo";
  public static final String TAG = "MicroMsg.StoryInfoStorage";
  private static String zMV;
  private static String zNe;
  private static String zNg;
  private e ATV;
  private final String AUf;
  private final ArrayList<Integer> AUg;
  private final List<String> AUh;
  public final e db;
  private final ArrayList<Integer> sxT;
  private String zNa;
  private String zNb;
  private final ArrayList<Integer> zNk;
  
  static
  {
    AppMethodBeat.i(119590);
    AUo = new k.a((byte)0);
    TAG = "MicroMsg.StoryInfoStorage";
    AUi = "select count(*) from MMStoryInfo ";
    TABLE = "MMStoryInfo";
    zMV = " order by " + TABLE + ".createTime desc";
    AUj = " order by " + TABLE + ".favoriteTime asc";
    AUk = " (storyID != 0  ) ";
    Object localObject1 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject2 = j.AUe;
    localObject1 = j.cIV() + " ON " + TABLE + " ( storyID )";
    localObject2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    Object localObject3 = j.AUe;
    localObject2 = j.elE() + " ON " + TABLE + " (userName,storyID, createTime)";
    localObject3 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    j.a locala = j.AUe;
    INDEX_CREATE = new String[] { localObject1, localObject2, j.elF() + " ON " + TABLE + " (userName, createTime)" };
    localObject1 = j.AUe;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(j.access$getInfo$cp(), TABLE) };
    AppMethodBeat.o(119590);
  }
  
  public k(e parame)
  {
    super(parame, j.access$getInfo$cp(), TABLE, INDEX_CREATE);
    AppMethodBeat.i(119589);
    this.ATV = parame;
    this.AUf = " (storyID != 0 ) ";
    parame = a.d.ATy;
    int i = a.d.eld();
    parame = a.d.ATy;
    int j = a.d.ele();
    parame = a.d.ATy;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.d.elf()) });
    p.g(parame, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
    this.sxT = k.a.fQ(parame);
    parame = a.ATp;
    i = a.ekx();
    parame = a.ATp;
    j = a.eky();
    parame = a.ATp;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(a.ekz()) });
    p.g(parame, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
    this.zNk = k.a.fQ(parame);
    parame = a.ATp;
    i = a.ekW();
    parame = a.ATp;
    parame = Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(a.ekX()) });
    p.g(parame, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
    this.AUg = k.a.fQ(parame);
    this.db = this.ATV;
    this.AUh = Collections.synchronizedList((List)new ArrayList());
    parame = new ArrayList();
    localObject1 = this.sxT.iterator();
    Integer localInteger;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.ATy;
      if ((i & a.d.eld()) != 0)
      {
        i = localInteger.intValue();
        localObject2 = a.d.ATy;
        if ((i & a.d.ele()) == 0) {
          parame.add(localInteger);
        }
      }
    }
    this.zNa = k.a.i((List)parame, "localFlag");
    parame.clear();
    localObject1 = this.zNk.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.ATp;
      if ((i & a.ekx()) != 0) {
        parame.add(localInteger);
      }
    }
    zNe = k.a.i((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.zNk.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.ATp;
      if ((i & a.eky()) != 0) {
        parame.add(localInteger);
      }
    }
    zNg = k.a.i((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.sxT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.d.ATy;
      if ((i & a.d.ele()) != 0) {
        parame.add(localInteger);
      }
    }
    this.zNb = k.a.i((List)parame, "localFlag");
    parame.clear();
    localObject1 = this.zNk.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.ATp;
      if ((i & a.ekz()) != 0) {
        parame.add(localInteger);
      }
    }
    AUm = k.a.i((List)parame, "sourceType");
    parame.clear();
    localObject1 = this.AUg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.ATp;
      if ((i & a.ekW()) != 0) {
        parame.add(localInteger);
      }
    }
    AUl = k.a.b((List)parame, "itemStoryFlag", true);
    parame.clear();
    localObject1 = this.AUg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      i = localInteger.intValue();
      localObject2 = a.ATp;
      if ((i & a.ekX()) != 0) {
        parame.add(localInteger);
      }
    }
    AUn = k.a.i((List)parame, "itemStoryFlag");
    AppMethodBeat.o(119589);
  }
  
  private j AV(long paramLong)
  {
    AppMethodBeat.i(119564);
    if (paramLong >= 0L)
    {
      localj = Sx((int)paramLong);
      AppMethodBeat.o(119564);
      return localj;
    }
    j localj = AX(paramLong);
    AppMethodBeat.o(119564);
    return localj;
  }
  
  private static String Sy(int paramInt)
  {
    AppMethodBeat.i(119566);
    String str = TABLE + ".createTime>" + paramInt;
    AppMethodBeat.o(119566);
    return str;
  }
  
  private static String bR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119565);
    if (paramBoolean)
    {
      paramString = " WHERE " + zNe;
      AppMethodBeat.o(119565);
      return paramString;
    }
    paramString = " WHERE " + TABLE + ".userName='" + bt.aQN(paramString) + "' AND " + zNg;
    AppMethodBeat.o(119565);
    return paramString;
  }
  
  private static String bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119567);
    paramString = "select *,rowid from MMStoryInfo " + bR(paramString, paramBoolean);
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
    paramString = (String)localObject + zMV + " limit " + paramInt;
    ad.d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(paramString)));
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
  
  public final j AU(long paramLong)
  {
    AppMethodBeat.i(119560);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  where " + TABLE + ".storyID=" + paramLong + " limit 1";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final boolean AW(long paramLong)
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
  
  public final j AX(long paramLong)
  {
    AppMethodBeat.i(119578);
    j localj = new j();
    Object localObject = "select *,rowid from MMStoryInfo  WHERE " + TABLE + ".storyID=" + paramLong;
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final int AY(long paramLong)
  {
    AppMethodBeat.i(119584);
    j localj = AV(paramLong);
    if (localj != null)
    {
      int i = localj.field_readCount;
      AppMethodBeat.o(119584);
      return i;
    }
    AppMethodBeat.o(119584);
    return 0;
  }
  
  public final boolean F(long paramLong, String paramString)
  {
    AppMethodBeat.i(119577);
    p.h(paramString, "username");
    boolean bool = AW(paramLong);
    j localj = new j();
    localj.field_userName = paramString;
    localj.field_storyID = paramLong;
    doNotify("notify_story_info_delete", 1, localj);
    AppMethodBeat.o(119577);
    return bool;
  }
  
  public final boolean QQ(int paramInt)
  {
    AppMethodBeat.i(119575);
    e locale = this.db;
    String str = TABLE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.AUe;
    if (locale.delete(str, j.elD() + "=?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      AppMethodBeat.o(119575);
      return true;
    }
    AppMethodBeat.o(119575);
    return false;
  }
  
  public final j Sx(int paramInt)
  {
    AppMethodBeat.i(119563);
    j localj = new j();
    Object localObject = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(TABLE).append('.');
    j.a locala = j.AUe;
    localObject = j.elD() + '=' + paramInt;
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final int a(int paramInt, j paramj)
  {
    AppMethodBeat.i(119562);
    p.h(paramj, "storyinfo");
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    if (j.b.ehT().aCm(paramInt + '_' + paramj.field_createTime))
    {
      AppMethodBeat.o(119562);
      return -1;
    }
    paramj = paramj.convertTo();
    paramj.remove("rowid");
    localObject = this.db;
    String str = TABLE;
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.AUe;
    paramInt = ((e)localObject).update(str, paramj, j.elD() + "=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(119562);
    return paramInt;
  }
  
  public final long a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119582);
    p.h(paramString, "username");
    paramLong = o("select *,rowid from MMStoryInfo  " + bR(paramString, paramBoolean) + " AND " + AUn, paramLong, paramInt);
    AppMethodBeat.o(119582);
    return paramLong;
  }
  
  public final List<j> a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(119572);
    p.h(paramString, "userName");
    Object localObject1 = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bR(paramString, paramBoolean1) + ' ';
    paramString = paramString + " AND " + Sy(paramInt);
    Object localObject2 = new StringBuilder().append(paramString);
    if (paramBoolean1) {}
    for (paramString = zMV;; paramString = " AND " + AUk + " AND " + AUl + ' ' + zMV)
    {
      paramString = paramString;
      paramString = this.db.a(paramString, null, 2);
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
      paramString = d.AJq;
      d.Sd(((ArrayList)localObject1).size());
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
        if (!((j)localObject2).elA()) {}
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
      Object localObject = "select *,rowid from MMStoryInfo  " + bR(paramString, paramBoolean) + " AND " + AUn + ' ';
      paramString = (String)localObject;
      if (paramLong < 0L) {
        paramString = (String)localObject + " AND storyID >= " + paramLong;
      }
      localObject = paramString + zMV;
      paramString = (String)localObject;
      if (paramInt > 0) {
        paramString = (String)localObject + " limit " + paramInt;
      }
      ad.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
      paramString = this.db.a(paramString, null, 2);
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
  
  public final void aCl(String paramString)
  {
    AppMethodBeat.i(119554);
    p.h(paramString, "localId");
    this.AUh.add(paramString);
    AppMethodBeat.o(119554);
  }
  
  public final boolean aCm(String paramString)
  {
    AppMethodBeat.i(119555);
    p.h(paramString, "localId");
    ??? = this.AUh;
    p.g(???, "delList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      boolean bool = false;
      while (localIterator.hasNext()) {
        if (p.i((String)localIterator.next(), paramString))
        {
          ad.i(TAG, "wo wo wo ".concat(String.valueOf(paramString)));
          bool = true;
        }
      }
      paramString = z.MKo;
      AppMethodBeat.o(119555);
      return bool;
    }
  }
  
  public final long aa(long paramLong, int paramInt)
  {
    AppMethodBeat.i(119581);
    paramLong = o("select *,rowid from MMStoryInfo  WHERE " + AUm, paramLong, paramInt);
    AppMethodBeat.o(119581);
    return paramLong;
  }
  
  public final long c(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119568);
    p.h(paramString, "username");
    paramLong = o(bZ(paramString, paramBoolean), paramLong, paramInt);
    AppMethodBeat.o(119568);
    return paramLong;
  }
  
  public final List<j> ca(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119569);
    p.h(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bR(paramString, paramBoolean);
    Object localObject = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = zMV;; paramString = " AND " + AUk + zMV)
    {
      paramString = paramString;
      paramString = this.db.a(paramString, null, 2);
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
  
  public final j cb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119583);
    p.h(paramString, "userName");
    j localj = new j();
    paramString = "select *,rowid from MMStoryInfo " + bR(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramBoolean) {}
    for (paramString = zMV;; paramString = " AND " + AUk + zMV)
    {
      paramString = paramString;
      paramString = paramString + " limit 1";
      paramString = this.db.a(paramString, null, 2);
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
  
  public final ArrayList<j> cc(String paramString, boolean paramBoolean)
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
      paramString = "select *,rowid from MMStoryInfo  " + bR(paramString, paramBoolean) + " AND " + AUn + ' ' + zMV;
      ad.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(paramString)));
      paramString = this.db.a(paramString, null, 2);
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
  
  public final void dEM()
  {
    AppMethodBeat.i(119579);
    int i = this.db.delete(TABLE, null, null);
    ad.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(119579);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(119557);
    p.h(paramj, "storyInfo");
    boolean bool = replace((c)paramj);
    AppMethodBeat.o(119557);
    return bool;
  }
  
  public final j elG()
  {
    AppMethodBeat.i(119561);
    int i = cf.aCN();
    Object localObject1 = i.AJE;
    int j = i.ehK();
    localObject1 = new j();
    Object localObject2 = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.zNa).append(" and createTime > ").append(i - j).append(" order by ").append(TABLE).append('.');
    Object localObject3 = j.AUe;
    localObject2 = j.elD() + " asc limit 1";
    localObject3 = this.db.a((String)localObject2, null, 2);
    ad.d(TAG, "getLastUpload ".concat(String.valueOf(localObject2)));
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
  
  public final int f(j paramj)
  {
    AppMethodBeat.i(119559);
    p.h(paramj, "storyInfo");
    ad.d(TAG, "storyInfo Insert");
    paramj = paramj.convertTo();
    int i = (int)this.db.insert(TABLE, "", paramj);
    ad.d(TAG, "StoryInfo Insert result ".concat(String.valueOf(i)));
    AppMethodBeat.o(119559);
    return i;
  }
  
  public final List<j> fg(String paramString, int paramInt)
  {
    AppMethodBeat.i(119580);
    p.h(paramString, "userName");
    ArrayList localArrayList = new ArrayList();
    paramString = "select *,rowid from MMStoryInfo " + bR(paramString, true);
    paramString = paramString + " AND createTime BETWEEN " + paramInt + " AND " + (86400 + paramInt - 1);
    paramString = paramString + zMV;
    paramString = this.db.a(paramString, null, 2);
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
      if (((j)localObject2).elx().HyP == 0) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.k
 * JD-Core Version:    0.7.0.1
 */