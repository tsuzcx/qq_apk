package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ap
  extends ay
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(32839);
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "labelID";
    locala.IBN.put("labelID", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" labelID INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "labelID";
    locala.columns[1] = "labelName";
    locala.IBN.put("labelName", "TEXT");
    localStringBuilder.append(" labelName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "labelPYFull";
    locala.IBN.put("labelPYFull", "TEXT");
    localStringBuilder.append(" labelPYFull TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "labelPYShort";
    locala.IBN.put("labelPYShort", "TEXT");
    localStringBuilder.append(" labelPYShort TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "isTemporary";
    locala.IBN.put("isTemporary", "INTEGER");
    localStringBuilder.append(" isTemporary INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(32839);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ap
 * JD-Core Version:    0.7.0.1
 */