package com.tencent.mm.storage;

import com.tencent.mm.h.c.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends c
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "abtestkey";
    locala.ujN.put("abtestkey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "abtestkey";
    locala.columns[1] = "value";
    locala.ujN.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "expId";
    locala.ujN.put("expId", "TEXT");
    localStringBuilder.append(" expId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "sequence";
    locala.ujN.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "prioritylevel";
    locala.ujN.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "startTime";
    locala.ujN.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "endTime";
    locala.ujN.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "noReport";
    locala.ujN.put("noReport", "INTEGER");
    localStringBuilder.append(" noReport INTEGER");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final boolean isValid()
  {
    long l = bk.UX();
    return (l >= this.field_startTime) && (l < this.field_endTime);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.a
 * JD-Core Version:    0.7.0.1
 */