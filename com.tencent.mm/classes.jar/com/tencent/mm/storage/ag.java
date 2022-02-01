package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ag
  extends av
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(193611);
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "createTime";
    locala.IBN.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "modifyTime";
    locala.IBN.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "deleteTime";
    locala.IBN.put("deleteTime", "LONG default '0' ");
    localStringBuilder.append(" deleteTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "id";
    locala.IBN.put("id", "TEXT default '' ");
    localStringBuilder.append(" id TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "saveTime";
    locala.IBN.put("saveTime", "LONG default '0' ");
    localStringBuilder.append(" saveTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "size";
    locala.IBN.put("size", "LONG default '0' ");
    localStringBuilder.append(" size LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "flags";
    locala.IBN.put("flags", "LONG default '0' ");
    localStringBuilder.append(" flags LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(193611);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ag
 * JD-Core Version:    0.7.0.1
 */