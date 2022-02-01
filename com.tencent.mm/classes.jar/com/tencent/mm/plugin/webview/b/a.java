package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends hb
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(77827);
    c.a locala = new c.a();
    locala.IhA = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appIdKey";
    locala.IhC.put("appIdKey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "appIdKey";
    locala.columns[2] = "value";
    locala.IhC.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "weight";
    locala.IhC.put("weight", "TEXT");
    localStringBuilder.append(" weight TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "expireTime";
    locala.IhC.put("expireTime", "LONG");
    localStringBuilder.append(" expireTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "timeStamp";
    locala.IhC.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "size";
    locala.IhC.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "localFile";
    locala.IhC.put("localFile", "TEXT");
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