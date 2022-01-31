package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bm
  extends dh
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(80286);
    c.a locala = new c.a();
    locala.yrK = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tipId";
    locala.yrM.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "tipId";
    locala.columns[1] = "tipVersion";
    locala.yrM.put("tipVersion", "INTEGER");
    localStringBuilder.append(" tipVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "tipkey";
    locala.yrM.put("tipkey", "TEXT");
    localStringBuilder.append(" tipkey TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "tipType";
    locala.yrM.put("tipType", "INTEGER");
    localStringBuilder.append(" tipType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isExit";
    locala.yrM.put("isExit", "INTEGER");
    localStringBuilder.append(" isExit INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "hadRead";
    locala.yrM.put("hadRead", "INTEGER");
    localStringBuilder.append(" hadRead INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "isReject";
    locala.yrM.put("isReject", "INTEGER");
    localStringBuilder.append(" isReject INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "beginShowTime";
    locala.yrM.put("beginShowTime", "LONG");
    localStringBuilder.append(" beginShowTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "disappearTime";
    locala.yrM.put("disappearTime", "LONG");
    localStringBuilder.append(" disappearTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "overdueTime";
    locala.yrM.put("overdueTime", "LONG");
    localStringBuilder.append(" overdueTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "tipsShowInfo";
    locala.yrM.put("tipsShowInfo", "BLOB");
    localStringBuilder.append(" tipsShowInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "extInfo";
    locala.yrM.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "pagestaytime";
    locala.yrM.put("pagestaytime", "LONG");
    localStringBuilder.append(" pagestaytime LONG");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(80286);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bm
 * JD-Core Version:    0.7.0.1
 */