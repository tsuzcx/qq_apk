package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class af
  extends av
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(189893);
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "createTime";
    locala.IhC.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "modifyTime";
    locala.IhC.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "deleteTime";
    locala.IhC.put("deleteTime", "LONG default '0' ");
    localStringBuilder.append(" deleteTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "id";
    locala.IhC.put("id", "TEXT default '' ");
    localStringBuilder.append(" id TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "saveTime";
    locala.IhC.put("saveTime", "LONG default '0' ");
    localStringBuilder.append(" saveTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "size";
    locala.IhC.put("size", "LONG default '0' ");
    localStringBuilder.append(" size LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "flags";
    locala.IhC.put("flags", "LONG default '0' ");
    localStringBuilder.append(" flags LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(189893);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.af
 * JD-Core Version:    0.7.0.1
 */