package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends ga
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(97471);
    c.a locala = new c.a();
    locala.IBL = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.IBN.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "userName";
    locala.columns[1] = "md5";
    locala.IBN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "newerIds";
    locala.IBN.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "bgId";
    locala.IBN.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bgUrl";
    locala.IBN.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "older_bgId";
    locala.IBN.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "local_flag";
    locala.IBN.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "istyle";
    locala.IBN.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "iFlag";
    locala.IBN.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "icount";
    locala.IBN.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "faultS";
    locala.IBN.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "snsBgId";
    locala.IBN.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "snsuser";
    locala.IBN.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "adsession";
    locala.IBN.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "lastFirstPageRequestErrCode";
    locala.IBN.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastFirstPageRequestErrType";
    locala.IBN.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "snsYearMonthInfo";
    locala.IBN.put("snsYearMonthInfo", "BLOB");
    localStringBuilder.append(" snsYearMonthInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "albumMd5";
    locala.IBN.put("albumMd5", "TEXT");
    localStringBuilder.append(" albumMd5 TEXT");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97471);
  }
  
  public final void a(dhz paramdhz)
  {
    AppMethodBeat.i(97467);
    if (paramdhz == null)
    {
      AppMethodBeat.o(97467);
      return;
    }
    try
    {
      this.field_snsYearMonthInfo = paramdhz.toByteArray();
      AppMethodBeat.o(97467);
      return;
    }
    catch (Exception paramdhz)
    {
      AppMethodBeat.o(97467);
    }
  }
  
  public final void a(dia paramdia)
  {
    AppMethodBeat.i(97468);
    if (paramdia == null)
    {
      AppMethodBeat.o(97468);
      return;
    }
    try
    {
      this.field_snsuser = paramdia.toByteArray();
      AppMethodBeat.o(97468);
      return;
    }
    catch (Exception paramdia)
    {
      AppMethodBeat.o(97468);
    }
  }
  
  public final void ecc()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final dhz ecd()
  {
    AppMethodBeat.i(97466);
    dhz localdhz = new dhz();
    if (!bu.cF(this.field_snsYearMonthInfo)) {}
    try
    {
      localdhz.parseFrom(this.field_snsYearMonthInfo);
      label32:
      AppMethodBeat.o(97466);
      return localdhz;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final boolean ece()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final dia ecf()
  {
    AppMethodBeat.i(97469);
    try
    {
      dia localdia = (dia)new dia().parseFrom(this.field_snsuser);
      AppMethodBeat.o(97469);
      return localdia;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97469);
    }
    return null;
  }
  
  public final aju ecg()
  {
    AppMethodBeat.i(97470);
    new auk();
    localObject1 = new aju();
    Object localObject2 = localObject1;
    if (!bu.cF(this.field_faultS)) {}
    try
    {
      localObject2 = (auk)new auk().parseFrom(this.field_faultS);
      if (((auk)localObject2).GLm.size() <= 0) {
        break label89;
      }
      localObject2 = (aju)((auk)localObject2).GLm.getFirst();
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