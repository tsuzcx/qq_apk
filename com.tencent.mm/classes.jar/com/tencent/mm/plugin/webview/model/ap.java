package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ap
  extends hf
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(79029);
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.IBN.put("recordId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "recordId";
    locala.columns[1] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "domin";
    locala.IBN.put("domin", "TEXT");
    localStringBuilder.append(" domin TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "key";
    locala.IBN.put("key", "TEXT");
    localStringBuilder.append(" key TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "value";
    locala.IBN.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(79029);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ap
 * JD-Core Version:    0.7.0.1
 */