package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.h.c.fc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends fc
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "host";
    locala.ujN.put("host", "TEXT");
    localStringBuilder.append(" host TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "expireTime";
    locala.ujN.put("expireTime", "LONG");
    localStringBuilder.append(" expireTime LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.i
 * JD-Core Version:    0.7.0.1
 */