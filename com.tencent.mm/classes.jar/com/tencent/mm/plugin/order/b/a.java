package com.tencent.mm.plugin.order.b;

import com.tencent.mm.h.c.dc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends dc
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.ujN.put("msgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "msgId";
    locala.columns[1] = "msgContentXml";
    locala.ujN.put("msgContentXml", "TEXT");
    localStringBuilder.append(" msgContentXml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "isRead";
    locala.ujN.put("isRead", "TEXT");
    localStringBuilder.append(" isRead TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.b.a
 * JD-Core Version:    0.7.0.1
 */