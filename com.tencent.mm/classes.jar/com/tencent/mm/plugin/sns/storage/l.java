package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.gq;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.eli;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class l
  extends gq
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(97471);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userName";
    localMAutoDBInfo.columns[1] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "newerIds";
    localMAutoDBInfo.colsMap.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "bgId";
    localMAutoDBInfo.colsMap.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "bgUrl";
    localMAutoDBInfo.colsMap.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "older_bgId";
    localMAutoDBInfo.colsMap.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "local_flag";
    localMAutoDBInfo.colsMap.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "istyle";
    localMAutoDBInfo.colsMap.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "iFlag";
    localMAutoDBInfo.colsMap.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "icount";
    localMAutoDBInfo.colsMap.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "faultS";
    localMAutoDBInfo.colsMap.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "snsBgId";
    localMAutoDBInfo.colsMap.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "snsuser";
    localMAutoDBInfo.colsMap.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "adsession";
    localMAutoDBInfo.colsMap.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "lastFirstPageRequestErrCode";
    localMAutoDBInfo.colsMap.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "lastFirstPageRequestErrType";
    localMAutoDBInfo.colsMap.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "snsYearMonthInfo";
    localMAutoDBInfo.colsMap.put("snsYearMonthInfo", "BLOB");
    localStringBuilder.append(" snsYearMonthInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "albumMd5";
    localMAutoDBInfo.colsMap.put("albumMd5", "TEXT");
    localStringBuilder.append(" albumMd5 TEXT");
    localMAutoDBInfo.columns[18] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(97471);
  }
  
  public final void a(eli parameli)
  {
    AppMethodBeat.i(97467);
    if (parameli == null)
    {
      AppMethodBeat.o(97467);
      return;
    }
    try
    {
      this.field_snsYearMonthInfo = parameli.toByteArray();
      AppMethodBeat.o(97467);
      return;
    }
    catch (Exception parameli)
    {
      AppMethodBeat.o(97467);
    }
  }
  
  public final void a(elj paramelj)
  {
    AppMethodBeat.i(97468);
    if (paramelj == null)
    {
      AppMethodBeat.o(97468);
      return;
    }
    try
    {
      this.field_snsuser = paramelj.toByteArray();
      AppMethodBeat.o(97468);
      return;
    }
    catch (Exception paramelj)
    {
      AppMethodBeat.o(97468);
    }
  }
  
  public final void fSC()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final eli fSD()
  {
    AppMethodBeat.i(97466);
    eli localeli = new eli();
    if (!Util.isNullOrNil(this.field_snsYearMonthInfo)) {}
    try
    {
      localeli.parseFrom(this.field_snsYearMonthInfo);
      label32:
      AppMethodBeat.o(97466);
      return localeli;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final boolean fSE()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final elj fSF()
  {
    AppMethodBeat.i(97469);
    try
    {
      elj localelj = (elj)new elj().parseFrom(this.field_snsuser);
      AppMethodBeat.o(97469);
      return localelj;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97469);
    }
    return null;
  }
  
  public final anj fSG()
  {
    AppMethodBeat.i(97470);
    new bmt();
    localObject1 = new anj();
    Object localObject2 = localObject1;
    if (!Util.isNullOrNil(this.field_faultS)) {}
    try
    {
      localObject2 = (bmt)new bmt().parseFrom(this.field_faultS);
      if (((bmt)localObject2).SXE.size() <= 0) {
        break label89;
      }
      localObject2 = (anj)((bmt)localObject2).SXE.getFirst();
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
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.l
 * JD-Core Version:    0.7.0.1
 */