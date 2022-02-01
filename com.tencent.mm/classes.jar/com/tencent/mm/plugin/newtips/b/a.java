package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.en;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends en
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(127262);
    c.a locala = new c.a();
    locala.IBL = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tipId";
    locala.IBN.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "tipId";
    locala.columns[1] = "tipVersion";
    locala.IBN.put("tipVersion", "INTEGER");
    localStringBuilder.append(" tipVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "tipkey";
    locala.IBN.put("tipkey", "TEXT");
    localStringBuilder.append(" tipkey TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "tipType";
    locala.IBN.put("tipType", "INTEGER");
    localStringBuilder.append(" tipType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isExit";
    locala.IBN.put("isExit", "INTEGER");
    localStringBuilder.append(" isExit INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "hadRead";
    locala.IBN.put("hadRead", "INTEGER");
    localStringBuilder.append(" hadRead INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "isReject";
    locala.IBN.put("isReject", "INTEGER");
    localStringBuilder.append(" isReject INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "beginShowTime";
    locala.IBN.put("beginShowTime", "LONG");
    localStringBuilder.append(" beginShowTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "disappearTime";
    locala.IBN.put("disappearTime", "LONG");
    localStringBuilder.append(" disappearTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "overdueTime";
    locala.IBN.put("overdueTime", "LONG");
    localStringBuilder.append(" overdueTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "tipsShowInfo";
    locala.IBN.put("tipsShowInfo", "BLOB");
    localStringBuilder.append(" tipsShowInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "extInfo";
    locala.IBN.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "pagestaytime";
    locala.IBN.put("pagestaytime", "LONG");
    localStringBuilder.append(" pagestaytime LONG");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(127262);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.a
 * JD-Core Version:    0.7.0.1
 */