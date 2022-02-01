package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fz;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends fz
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(97471);
    c.a locala = new c.a();
    locala.IhA = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.IhC.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "userName";
    locala.columns[1] = "md5";
    locala.IhC.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "newerIds";
    locala.IhC.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "bgId";
    locala.IhC.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bgUrl";
    locala.IhC.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "older_bgId";
    locala.IhC.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "local_flag";
    locala.IhC.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "istyle";
    locala.IhC.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "iFlag";
    locala.IhC.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "icount";
    locala.IhC.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "faultS";
    locala.IhC.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "snsBgId";
    locala.IhC.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "snsuser";
    locala.IhC.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "adsession";
    locala.IhC.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "lastFirstPageRequestErrCode";
    locala.IhC.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastFirstPageRequestErrType";
    locala.IhC.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "snsYearMonthInfo";
    locala.IhC.put("snsYearMonthInfo", "BLOB");
    localStringBuilder.append(" snsYearMonthInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "albumMd5";
    locala.IhC.put("albumMd5", "TEXT");
    localStringBuilder.append(" albumMd5 TEXT");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97471);
  }
  
  public final void a(dhf paramdhf)
  {
    AppMethodBeat.i(97467);
    if (paramdhf == null)
    {
      AppMethodBeat.o(97467);
      return;
    }
    try
    {
      this.field_snsYearMonthInfo = paramdhf.toByteArray();
      AppMethodBeat.o(97467);
      return;
    }
    catch (Exception paramdhf)
    {
      AppMethodBeat.o(97467);
    }
  }
  
  public final void a(dhg paramdhg)
  {
    AppMethodBeat.i(97468);
    if (paramdhg == null)
    {
      AppMethodBeat.o(97468);
      return;
    }
    try
    {
      this.field_snsuser = paramdhg.toByteArray();
      AppMethodBeat.o(97468);
      return;
    }
    catch (Exception paramdhg)
    {
      AppMethodBeat.o(97468);
    }
  }
  
  public final boolean dYA()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final dhg dYB()
  {
    AppMethodBeat.i(97469);
    try
    {
      dhg localdhg = (dhg)new dhg().parseFrom(this.field_snsuser);
      AppMethodBeat.o(97469);
      return localdhg;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97469);
    }
    return null;
  }
  
  public final ajk dYC()
  {
    AppMethodBeat.i(97470);
    new atu();
    localObject1 = new ajk();
    Object localObject2 = localObject1;
    if (!bt.cC(this.field_faultS)) {}
    try
    {
      localObject2 = (atu)new atu().parseFrom(this.field_faultS);
      if (((atu)localObject2).GrO.size() <= 0) {
        break label89;
      }
      localObject2 = (ajk)((atu)localObject2).GrO.getFirst();
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
  
  public final void dYy()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final dhf dYz()
  {
    AppMethodBeat.i(97466);
    dhf localdhf = new dhf();
    if (!bt.cC(this.field_snsYearMonthInfo)) {}
    try
    {
      localdhf.parseFrom(this.field_snsYearMonthInfo);
      label32:
      AppMethodBeat.o(97466);
      return localdhf;
    }
    catch (Exception localException)
    {
      break label32;
    }
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