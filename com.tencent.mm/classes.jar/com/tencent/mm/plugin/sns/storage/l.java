package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ep;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public final class l
  extends ep
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(37858);
    c.a locala = new c.a();
    locala.yrK = new Field[16];
    locala.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.yrM.put("userName", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "userName";
    locala.columns[1] = "md5";
    locala.yrM.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "newerIds";
    locala.yrM.put("newerIds", "TEXT");
    localStringBuilder.append(" newerIds TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "bgId";
    locala.yrM.put("bgId", "TEXT");
    localStringBuilder.append(" bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bgUrl";
    locala.yrM.put("bgUrl", "TEXT");
    localStringBuilder.append(" bgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "older_bgId";
    locala.yrM.put("older_bgId", "TEXT");
    localStringBuilder.append(" older_bgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "local_flag";
    locala.yrM.put("local_flag", "INTEGER");
    localStringBuilder.append(" local_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "istyle";
    locala.yrM.put("istyle", "INTEGER");
    localStringBuilder.append(" istyle INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "iFlag";
    locala.yrM.put("iFlag", "INTEGER");
    localStringBuilder.append(" iFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "icount";
    locala.yrM.put("icount", "INTEGER");
    localStringBuilder.append(" icount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "faultS";
    locala.yrM.put("faultS", "BLOB");
    localStringBuilder.append(" faultS BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "snsBgId";
    locala.yrM.put("snsBgId", "LONG");
    localStringBuilder.append(" snsBgId LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "snsuser";
    locala.yrM.put("snsuser", "BLOB");
    localStringBuilder.append(" snsuser BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "adsession";
    locala.yrM.put("adsession", "BLOB");
    localStringBuilder.append(" adsession BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "lastFirstPageRequestErrCode";
    locala.yrM.put("lastFirstPageRequestErrCode", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastFirstPageRequestErrType";
    locala.yrM.put("lastFirstPageRequestErrType", "INTEGER");
    localStringBuilder.append(" lastFirstPageRequestErrType INTEGER");
    locala.columns[16] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(37858);
  }
  
  public final void a(cfj paramcfj)
  {
    AppMethodBeat.i(37855);
    if (paramcfj == null)
    {
      AppMethodBeat.o(37855);
      return;
    }
    try
    {
      this.field_snsuser = paramcfj.toByteArray();
      AppMethodBeat.o(37855);
      return;
    }
    catch (Exception paramcfj)
    {
      AppMethodBeat.o(37855);
    }
  }
  
  public final void csv()
  {
    this.field_local_flag &= 0xFFFFFFFD;
  }
  
  public final boolean csw()
  {
    return (this.field_local_flag & 0x2) > 0;
  }
  
  public final cfj csx()
  {
    AppMethodBeat.i(37856);
    try
    {
      cfj localcfj = (cfj)new cfj().parseFrom(this.field_snsuser);
      AppMethodBeat.o(37856);
      return localcfj;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(37856);
    }
    return null;
  }
  
  public final abx csy()
  {
    AppMethodBeat.i(37857);
    new aei();
    localObject1 = new abx();
    Object localObject2 = localObject1;
    if (!bo.ce(this.field_faultS)) {}
    try
    {
      localObject2 = (aei)new aei().parseFrom(this.field_faultS);
      if (((aei)localObject2).wXm.size() <= 0) {
        break label89;
      }
      localObject2 = (abx)((aei)localObject2).wXm.getFirst();
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
    AppMethodBeat.o(37857);
    return localObject2;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.l
 * JD-Core Version:    0.7.0.1
 */