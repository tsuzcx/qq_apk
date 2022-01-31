package com.tencent.mm.plugin.remittance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends av
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(44703);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.yrM.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "msgId";
    locala.columns[1] = "transferId";
    locala.yrM.put("transferId", "TEXT");
    localStringBuilder.append(" transferId TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(44703);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.a
 * JD-Core Version:    0.7.0.1
 */