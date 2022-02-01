package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends eb
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(66319);
    c.a locala = new c.a();
    locala.EYt = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "reqkey";
    locala.EYv.put("reqkey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqkey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "reqkey";
    locala.columns[1] = "ack_key";
    locala.EYv.put("ack_key", "TEXT");
    localStringBuilder.append(" ack_key TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "status";
    locala.EYv.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "receive_time";
    locala.EYv.put("receive_time", "LONG");
    localStringBuilder.append(" receive_time LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(66319);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.r
 * JD-Core Version:    0.7.0.1
 */