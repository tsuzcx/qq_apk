package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.di;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends di
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(43420);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "reqkey";
    locala.yrM.put("reqkey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqkey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "reqkey";
    locala.columns[1] = "ack_key";
    locala.yrM.put("ack_key", "TEXT");
    localStringBuilder.append(" ack_key TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "receive_time";
    locala.yrM.put("receive_time", "LONG");
    localStringBuilder.append(" receive_time LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43420);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.r
 * JD-Core Version:    0.7.0.1
 */