package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class an
  extends fs
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(6736);
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.yrM.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "recordId";
    locala.columns[1] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "domin";
    locala.yrM.put("domin", "TEXT");
    localStringBuilder.append(" domin TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "key";
    locala.yrM.put("key", "TEXT");
    localStringBuilder.append(" key TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "value";
    locala.yrM.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(6736);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an
 * JD-Core Version:    0.7.0.1
 */