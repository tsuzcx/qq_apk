package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends j<e>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private static final String xiE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(97443);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "adsnsinfo") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)" };
    xiE = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[] { "snsId", "createTime" });
    AppMethodBeat.o(97443);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.info, "adsnsinfo", INDEX_CREATE);
    this.db = parame;
  }
  
  private int a(e parame)
  {
    AppMethodBeat.i(97439);
    ad.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
    if (parame == null)
    {
      AppMethodBeat.o(97439);
      return -1;
    }
    parame = parame.convertTo();
    int i = (int)this.db.insert("AdSnsInfo", "", parame);
    ad.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result".concat(String.valueOf(i)));
    AppMethodBeat.o(97439);
    return i;
  }
  
  public final e MZ(int paramInt)
  {
    AppMethodBeat.i(97435);
    e locale = new e();
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=".concat(String.valueOf(paramInt));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locale.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(97435);
      return locale;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(97435);
    return null;
  }
  
  public final boolean a(long paramLong, e parame)
  {
    AppMethodBeat.i(97436);
    if (sZ(paramLong))
    {
      boolean bool = b(paramLong, parame);
      AppMethodBeat.o(97436);
      return bool;
    }
    ad.d("MicroMsg.AdSnsInfoStorage", "added PcId ".concat(String.valueOf(paramLong)));
    if (a(parame) != -1)
    {
      AppMethodBeat.o(97436);
      return true;
    }
    AppMethodBeat.o(97436);
    return false;
  }
  
  public final boolean b(long paramLong, e parame)
  {
    AppMethodBeat.i(97437);
    parame = parame.convertTo();
    parame.remove("rowid");
    if (this.db.update("AdSnsInfo", parame, "snsId=?", new String[] { String.valueOf(paramLong) }) > 0)
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
    int i = this.db.delete("AdSnsInfo", "snsId=?", new String[] { String.valueOf(paramLong) });
    ad.i("MicroMsg.AdSnsInfoStorage", "del msg " + paramLong + " res " + i);
    if (i > 0)
    {
      AppMethodBeat.o(97440);
      return true;
    }
    AppMethodBeat.o(97440);
    return false;
  }
  
  public final Cursor hj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97441);
    Object localObject = "select *,rowid from AdSnsInfo  where createTime > " + paramInt2 + " and createTime <= " + paramInt1 + " and " + q.xje;
    localObject = (String)localObject + " order by  createTime desc";
    ad.d("MicroMsg.AdSnsInfoStorage", "getAdInTime ".concat(String.valueOf(localObject)));
    localObject = this.db.a((String)localObject, null, 2);
    AppMethodBeat.o(97441);
    return localObject;
  }
  
  public final e sY(long paramLong)
  {
    AppMethodBeat.i(97434);
    e locale = new e();
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locale.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(97434);
      return locale;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(97434);
    return null;
  }
  
  public final boolean sZ(long paramLong)
  {
    AppMethodBeat.i(97438);
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
    boolean bool = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    AppMethodBeat.o(97438);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.f
 * JD-Core Version:    0.7.0.1
 */