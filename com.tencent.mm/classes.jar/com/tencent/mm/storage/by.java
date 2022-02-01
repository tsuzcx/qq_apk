package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class by
  extends eu
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(32880);
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IhC.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "appId";
    locala.columns[1] = "packageName";
    locala.IhC.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "status";
    locala.IhC.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "sceneFlag";
    locala.IhC.put("sceneFlag", "INTEGER default '0' ");
    localStringBuilder.append(" sceneFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "msgTypeFlag";
    locala.IhC.put("msgTypeFlag", "INTEGER default '0' ");
    localStringBuilder.append(" msgTypeFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "msgState";
    locala.IhC.put("msgState", "INTEGER default '0' ");
    localStringBuilder.append(" msgState INTEGER default '0' ");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(32880);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.by
 * JD-Core Version:    0.7.0.1
 */