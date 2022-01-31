package com.tencent.mm.storage;

import com.tencent.mm.h.c.d;
import com.tencent.mm.model.c.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends d
  implements Serializable
{
  protected static c.a buS;
  private Map<String, String> umO = null;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "layerId";
    locala.ujN.put("layerId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" layerId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "layerId";
    locala.columns[1] = "business";
    locala.ujN.put("business", "TEXT");
    localStringBuilder.append(" business TEXT");
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
    locala.ujN.put("prioritylevel", "INTEGER default '0' ");
    localStringBuilder.append(" prioritylevel INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "startTime";
    locala.ujN.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "endTime";
    locala.ujN.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "needReport";
    locala.ujN.put("needReport", "INTEGER");
    localStringBuilder.append(" needReport INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "rawXML";
    locala.ujN.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final Map<String, String> ctr()
  {
    if (this.umO == null) {
      this.umO = a.jk(this.field_rawXML);
    }
    return this.umO;
  }
  
  public final boolean isValid()
  {
    long l = bk.UX();
    return (l >= this.field_startTime) && (l <= this.field_endTime);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.c
 * JD-Core Version:    0.7.0.1
 */