package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends fp
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(97471);
    c.a locala = new c.a();
    locala.GvF = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.GvH.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "userName";
    locala.columns[1] = "md5";
    locala.GvH.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "newerIds";
    locala.GvH.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "bgId";
    locala.GvH.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bgUrl";
    locala.GvH.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "older_bgId";
    locala.GvH.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "local_flag";
    locala.GvH.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "istyle";
    locala.GvH.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "iFlag";
    locala.GvH.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "icount";
    locala.GvH.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "faultS";
    locala.GvH.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "snsBgId";
    locala.GvH.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "snsuser";
    locala.GvH.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "adsession";
    locala.GvH.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "lastFirstPageRequestErrCode";
    locala.GvH.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastFirstPageRequestErrType";
    locala.GvH.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "snsYearMonthInfo";
    locala.GvH.put("snsYearMonthInfo", "BLOB");
    localStringBuilder.append(" snsYearMonthInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "albumMd5";
    locala.GvH.put("albumMd5", "TEXT");
    localStringBuilder.append(" albumMd5 TEXT");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97471);
  }
  
  public final void a(dbs paramdbs)
  {
    AppMethodBeat.i(97467);
    if (paramdbs == null)
    {
      AppMethodBeat.o(97467);
      return;
    }
    try
    {
      this.field_snsYearMonthInfo = paramdbs.toByteArray();
      AppMethodBeat.o(97467);
      return;
    }
    catch (Exception paramdbs)
    {
      AppMethodBeat.o(97467);
    }
  }
  
  public final void a(dbt paramdbt)
  {
    AppMethodBeat.i(97468);
    if (paramdbt == null)
    {
      AppMethodBeat.o(97468);
      return;
    }
    try
    {
      this.field_snsuser = paramdbt.toByteArray();
      AppMethodBeat.o(97468);
      return;
    }
    catch (Exception paramdbt)
    {
      AppMethodBeat.o(97468);
    }
  }
  
  public final void dMi()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final dbs dMj()
  {
    AppMethodBeat.i(97466);
    dbs localdbs = new dbs();
    if (!bs.cv(this.field_snsYearMonthInfo)) {}
    try
    {
      localdbs.parseFrom(this.field_snsYearMonthInfo);
      label32:
      AppMethodBeat.o(97466);
      return localdbs;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final boolean dMk()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final dbt dMl()
  {
    AppMethodBeat.i(97469);
    try
    {
      dbt localdbt = (dbt)new dbt().parseFrom(this.field_snsuser);
      AppMethodBeat.o(97469);
      return localdbt;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97469);
    }
    return null;
  }
  
  public final agu dMm()
  {
    AppMethodBeat.i(97470);
    new aqa();
    localObject1 = new agu();
    Object localObject2 = localObject1;
    if (!bs.cv(this.field_faultS)) {}
    try
    {
      localObject2 = (aqa)new aqa().parseFrom(this.field_faultS);
      if (((aqa)localObject2).EIX.size() <= 0) {
        break label89;
      }
      localObject2 = (agu)((aqa)localObject2).EIX.getFirst();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
    localObject2 = localObject1;
    AppMethodBeat.o(97470);
    return localObject2;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.n
 * JD-Core Version:    0.7.0.1
 */