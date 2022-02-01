package com.tencent.mm.plugin.remittance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends fk
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(67619);
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "transferId";
    locala.IhC.put("transferId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" transferId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "transferId";
    locala.columns[1] = "locaMsgId";
    locala.IhC.put("locaMsgId", "LONG");
    localStringBuilder.append(" locaMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "receiveStatus";
    locala.IhC.put("receiveStatus", "INTEGER default '-1' ");
    localStringBuilder.append(" receiveStatus INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "isSend";
    locala.IhC.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "talker";
    locala.IhC.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "invalidtime";
    locala.IhC.put("invalidtime", "LONG");
    localStringBuilder.append(" invalidtime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(67619);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.c
 * JD-Core Version:    0.7.0.1
 */