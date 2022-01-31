package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.h.c.ed;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class l
  extends ed
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[16];
    locala.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.ujN.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "userName";
    locala.columns[1] = "md5";
    locala.ujN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "newerIds";
    locala.ujN.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "bgId";
    locala.ujN.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bgUrl";
    locala.ujN.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "older_bgId";
    locala.ujN.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "local_flag";
    locala.ujN.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "istyle";
    locala.ujN.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "iFlag";
    locala.ujN.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "icount";
    locala.ujN.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "faultS";
    locala.ujN.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "snsBgId";
    locala.ujN.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "snsuser";
    locala.ujN.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "adsession";
    locala.ujN.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "lastFirstPageRequestErrCode";
    locala.ujN.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastFirstPageRequestErrType";
    locala.ujN.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    locala.columns[16] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void bGs()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final boolean bGt()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final but bGu()
  {
    try
    {
      but localbut = (but)new but().aH(this.field_snsuser);
      return localbut;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final xs bGv()
  {
    new zq();
    Object localObject1 = new xs();
    Object localObject2 = localObject1;
    if (!bk.bE(this.field_faultS)) {}
    for (;;)
    {
      try
      {
        localObject2 = (zq)new zq().aH(this.field_faultS);
        if (((zq)localObject2).sYR.size() > 0)
        {
          localObject2 = (xs)((zq)localObject2).sYR.getFirst();
          localObject1 = localObject2;
          localObject2 = localObject1;
          return localObject2;
        }
      }
      catch (Exception localException)
      {
        return localObject1;
      }
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.l
 * JD-Core Version:    0.7.0.1
 */