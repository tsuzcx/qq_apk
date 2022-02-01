package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends hc
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(77827);
    c.a locala = new c.a();
    locala.IBL = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appIdKey";
    locala.IBN.put("appIdKey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appIdKey";
    locala.columns[2] = "value";
    locala.IBN.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "weight";
    locala.IBN.put("weight", "TEXT");
    localStringBuilder.append(" weight TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "expireTime";
    locala.IBN.put("expireTime", "LONG");
    localStringBuilder.append(" expireTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "timeStamp";
    locala.IBN.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "size";
    locala.IBN.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "localFile";
    locala.IBN.put("localFile", "TEXT");
    localStringBuilder.append(" localFile TEXT");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(77827);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.a
 * JD-Core Version:    0.7.0.1
 */