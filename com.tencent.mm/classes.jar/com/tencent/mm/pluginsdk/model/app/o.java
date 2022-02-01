package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class o
  extends aa
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(31043);
    c.a locala = new c.a();
    locala.GvF = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "flag";
    locala.GvH.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "appId";
    locala.GvH.put("appId", "TEXT default '' ");
    localStringBuilder.append(" appId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "sortId";
    locala.GvH.put("sortId", "INTEGER default '0' ");
    localStringBuilder.append(" sortId INTEGER default '0' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(31043);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.o
 * JD-Core Version:    0.7.0.1
 */