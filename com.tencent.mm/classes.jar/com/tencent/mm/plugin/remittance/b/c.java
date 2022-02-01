package com.tencent.mm.plugin.remittance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fa;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends fa
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(67619);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "transferId";
    locala.GvH.put("transferId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" transferId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "transferId";
    locala.columns[1] = "locaMsgId";
    locala.GvH.put("locaMsgId", "LONG");
    localStringBuilder.append(" locaMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "receiveStatus";
    locala.GvH.put("receiveStatus", "INTEGER default '-1' ");
    localStringBuilder.append(" receiveStatus INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "isSend";
    locala.GvH.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "talker";
    locala.GvH.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "invalidtime";
    locala.GvH.put("invalidtime", "LONG");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.c
 * JD-Core Version:    0.7.0.1
 */