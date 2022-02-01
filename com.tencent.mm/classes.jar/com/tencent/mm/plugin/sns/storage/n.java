package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fl;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.cwg;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends fl
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(97471);
    c.a locala = new c.a();
    locala.EYt = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.EYv.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "userName";
    locala.columns[1] = "md5";
    locala.EYv.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "newerIds";
    locala.EYv.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "bgId";
    locala.EYv.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bgUrl";
    locala.EYv.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "older_bgId";
    locala.EYv.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "local_flag";
    locala.EYv.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "istyle";
    locala.EYv.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "iFlag";
    locala.EYv.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "icount";
    locala.EYv.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "faultS";
    locala.EYv.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "snsBgId";
    locala.EYv.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "snsuser";
    locala.EYv.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "adsession";
    locala.EYv.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "lastFirstPageRequestErrCode";
    locala.EYv.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastFirstPageRequestErrType";
    locala.EYv.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "snsYearMonthInfo";
    locala.EYv.put("snsYearMonthInfo", "BLOB");
    localStringBuilder.append(" snsYearMonthInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "albumMd5";
    locala.EYv.put("albumMd5", "TEXT");
    localStringBuilder.append(" albumMd5 TEXT");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97471);
  }
  
  public final void a(cwg paramcwg)
  {
    AppMethodBeat.i(97467);
    if (paramcwg == null)
    {
      AppMethodBeat.o(97467);
      return;
    }
    try
    {
      this.field_snsYearMonthInfo = paramcwg.toByteArray();
      AppMethodBeat.o(97467);
      return;
    }
    catch (Exception paramcwg)
    {
      AppMethodBeat.o(97467);
    }
  }
  
  public final void a(cwh paramcwh)
  {
    AppMethodBeat.i(97468);
    if (paramcwh == null)
    {
      AppMethodBeat.o(97468);
      return;
    }
    try
    {
      this.field_snsuser = paramcwh.toByteArray();
      AppMethodBeat.o(97468);
      return;
    }
    catch (Exception paramcwh)
    {
      AppMethodBeat.o(97468);
    }
  }
  
  public final void dxL()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final cwg dxM()
  {
    AppMethodBeat.i(97466);
    cwg localcwg = new cwg();
    if (!bt.cw(this.field_snsYearMonthInfo)) {}
    try
    {
      localcwg.parseFrom(this.field_snsYearMonthInfo);
      label32:
      AppMethodBeat.o(97466);
      return localcwg;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final boolean dxN()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final cwh dxO()
  {
    AppMethodBeat.i(97469);
    try
    {
      cwh localcwh = (cwh)new cwh().parseFrom(this.field_snsuser);
      AppMethodBeat.o(97469);
      return localcwh;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97469);
    }
    return null;
  }
  
  public final afv dxP()
  {
    AppMethodBeat.i(97470);
    new amw();
    localObject1 = new afv();
    Object localObject2 = localObject1;
    if (!bt.cw(this.field_faultS)) {}
    try
    {
      localObject2 = (amw)new amw().parseFrom(this.field_faultS);
      if (((amw)localObject2).DnX.size() <= 0) {
        break label89;
      }
      localObject2 = (afv)((amw)localObject2).DnX.getFirst();
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