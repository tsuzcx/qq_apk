package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ek;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bs
  extends ek
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(32880);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.GvH.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "appId";
    locala.columns[1] = "packageName";
    locala.GvH.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "status";
    locala.GvH.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "sceneFlag";
    locala.GvH.put("sceneFlag", "INTEGER default '0' ");
    localStringBuilder.append(" sceneFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "msgTypeFlag";
    locala.GvH.put("msgTypeFlag", "INTEGER default '0' ");
    localStringBuilder.append(" msgTypeFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "msgState";
    locala.GvH.put("msgState", "INTEGER default '0' ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bs
 * JD-Core Version:    0.7.0.1
 */