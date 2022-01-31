package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.h.c.cx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends cx
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "reqkey";
    locala.ujN.put("reqkey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqkey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "reqkey";
    locala.columns[1] = "ack_key";
    locala.ujN.put("ack_key", "TEXT");
    localStringBuilder.append(" ack_key TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "receive_time";
    locala.ujN.put("receive_time", "LONG");
    localStringBuilder.append(" receive_time LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.r
 * JD-Core Version:    0.7.0.1
 */