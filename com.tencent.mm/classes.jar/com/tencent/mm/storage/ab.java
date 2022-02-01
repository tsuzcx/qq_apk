package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ab
  extends au
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(206928);
    c.a locala = new c.a();
    locala.GvF = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "createTime";
    locala.GvH.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "modifyTime";
    locala.GvH.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "deleteTime";
    locala.GvH.put("deleteTime", "LONG default '0' ");
    localStringBuilder.append(" deleteTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "id";
    locala.GvH.put("id", "TEXT default '' ");
    localStringBuilder.append(" id TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "saveTime";
    locala.GvH.put("saveTime", "LONG default '0' ");
    localStringBuilder.append(" saveTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "size";
    locala.GvH.put("size", "LONG default '0' ");
    localStringBuilder.append(" size LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "flags";
    locala.GvH.put("flags", "LONG default '0' ");
    localStringBuilder.append(" flags LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(206928);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ab
 * JD-Core Version:    0.7.0.1
 */