package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends i<e>
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)" };
  public static final String[] dXp = { i.a(e.buS, "adsnsinfo") };
  private static final String oLn = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[] { "snsId", "createTime" });
  private com.tencent.mm.sdk.e.e dXw;
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.buS, "adsnsinfo", cqY);
    this.dXw = parame;
  }
  
  public final boolean a(long paramLong, e parame)
  {
    if (gl(paramLong)) {
      return b(paramLong, parame);
    }
    y.d("MicroMsg.AdSnsInfoStorage", "added PcId " + paramLong);
    y.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
    int i;
    if (parame == null) {
      i = -1;
    }
    while (i != -1)
    {
      return true;
      parame = parame.vf();
      i = (int)this.dXw.insert("AdSnsInfo", "", parame);
      y.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result" + i);
    }
    return false;
  }
  
  public final boolean b(long paramLong, e parame)
  {
    parame = parame.vf();
    parame.remove("rowid");
    return this.dXw.update("AdSnsInfo", parame, "snsId=?", new String[] { String.valueOf(paramLong) }) > 0;
  }
  
  public final Cursor dR(int paramInt1, int paramInt2)
  {
    String str = "select *,rowid from AdSnsInfo  where createTime > " + paramInt2 + " and createTime <= " + paramInt1 + " and " + o.oLM;
    str = str + " order by  createTime desc";
    y.d("MicroMsg.AdSnsInfoStorage", "getAdInTime " + str);
    return this.dXw.a(str, null, 2);
  }
  
  public final boolean delete(long paramLong)
  {
    int i = this.dXw.delete("AdSnsInfo", "snsId=?", new String[] { String.valueOf(paramLong) });
    y.i("MicroMsg.AdSnsInfoStorage", "del msg " + paramLong + " res " + i);
    return i > 0;
  }
  
  public final e gk(long paramLong)
  {
    e locale = new e();
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + paramLong;
    localObject = this.dXw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locale.d((Cursor)localObject);
      ((Cursor)localObject).close();
      return locale;
    }
    ((Cursor)localObject).close();
    return null;
  }
  
  public final boolean gl(long paramLong)
  {
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + paramLong;
    localObject = this.dXw.a((String)localObject, null, 2);
    boolean bool = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    return bool;
  }
  
  public final e yq(int paramInt)
  {
    e locale = new e();
    Object localObject = "select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=" + paramInt;
    localObject = this.dXw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locale.d((Cursor)localObject);
      ((Cursor)localObject).close();
      return locale;
    }
    ((Cursor)localObject).close();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.f
 * JD-Core Version:    0.7.0.1
 */