package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.he;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends he
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(79202);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "host";
    locala.IBN.put("host", "TEXT");
    localStringBuilder.append(" host TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "expireTime";
    locala.IBN.put("expireTime", "LONG");
    localStringBuilder.append(" expireTime LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(79202);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.i
 * JD-Core Version:    0.7.0.1
 */