package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f
  extends MAutoStorage<AdSnsInfo>
{
  public static final String[] INDEX_CREATE;
  private static final String QYf;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(97443);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(AdSnsInfo.info, "adsnsinfo") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)" };
    QYf = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[] { "snsId", "createTime" });
    AppMethodBeat.o(97443);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, AdSnsInfo.info, "adsnsinfo", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  private int a(AdSnsInfo paramAdSnsInfo)
  {
    AppMethodBeat.i(97439);
    Log.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
    if (paramAdSnsInfo == null)
    {
      AppMethodBeat.o(97439);
      return -1;
    }
    paramAdSnsInfo = paramAdSnsInfo.convertTo();
    int i = (int)this.db.insert("AdSnsInfo", "", paramAdSnsInfo);
    Log.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result".concat(String.valueOf(i)));
    AppMethodBeat.o(97439);
    return i;
  }
  
  public final boolean a(long paramLong, AdSnsInfo paramAdSnsInfo)
  {
    AppMethodBeat.i(97436);
    if (ve(paramLong))
    {
      boolean bool = b(paramLong, paramAdSnsInfo);
      AppMethodBeat.o(97436);
      return bool;
    }
    Log.d("MicroMsg.AdSnsInfoStorage", "added PcId ".concat(String.valueOf(paramLong)));
    if (a(paramAdSnsInfo) != -1)
    {
      AppMethodBeat.o(97436);
      return true;
    }
    AppMethodBeat.o(97436);
    return false;
  }
  
  public final AdSnsInfo alz(int paramInt)
  {
    AppMethodBeat.i(97435);
    AdSnsInfo localAdSnsInfo = new AdSnsInfo();
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=".concat(String.valueOf(paramInt));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localAdSnsInfo.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(97435);
      return localAdSnsInfo;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(97435);
    return null;
  }
  
  public final boolean b(long paramLong, AdSnsInfo paramAdSnsInfo)
  {
    AppMethodBeat.i(97437);
    paramAdSnsInfo = paramAdSnsInfo.convertTo();
    paramAdSnsInfo.remove("rowid");
    if (this.db.update("AdSnsInfo", paramAdSnsInfo, "snsId=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(97437);
      return true;
    }
    AppMethodBeat.o(97437);
    return false;
  }
  
  public final boolean delete(long paramLong)
  {
    AppMethodBeat.i(97440);
    a.aWe(t.uA(paramLong));
    int i = this.db.delete("AdSnsInfo", "snsId=?", new String[] { String.valueOf(paramLong) });
    Log.i("MicroMsg.AdSnsInfoStorage", "del msg " + paramLong + " res " + i);
    if (i > 0)
    {
      AppMethodBeat.o(97440);
      return true;
    }
    AppMethodBeat.o(97440);
    return false;
  }
  
  public final Cursor lB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97441);
    Object localObject = "select *,rowid from AdSnsInfo  where createTime > " + paramInt2 + " and createTime <= " + paramInt1 + " and " + w.QZi;
    localObject = (String)localObject + " order by  createTime desc";
    Log.d("MicroMsg.AdSnsInfoStorage", "getAdInTime ".concat(String.valueOf(localObject)));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    AppMethodBeat.o(97441);
    return localObject;
  }
  
  public final AdSnsInfo vd(long paramLong)
  {
    AppMethodBeat.i(97434);
    AdSnsInfo localAdSnsInfo = new AdSnsInfo();
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localAdSnsInfo.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(97434);
      return localAdSnsInfo;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(97434);
    return null;
  }
  
  public final boolean ve(long paramLong)
  {
    AppMethodBeat.i(97438);
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    boolean bool = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    AppMethodBeat.o(97438);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.f
 * JD-Core Version:    0.7.0.1
 */