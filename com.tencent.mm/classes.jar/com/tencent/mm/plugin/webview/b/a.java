package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fp
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(5623);
    c.a locala = new c.a();
    locala.yrK = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appIdKey";
    locala.yrM.put("appIdKey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "appIdKey";
    locala.columns[2] = "value";
    locala.yrM.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "weight";
    locala.yrM.put("weight", "TEXT");
    localStringBuilder.append(" weight TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "expireTime";
    locala.yrM.put("expireTime", "LONG");
    localStringBuilder.append(" expireTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "timeStamp";
    locala.yrM.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "size";
    locala.yrM.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(5623);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.a
 * JD-Core Version:    0.7.0.1
 */