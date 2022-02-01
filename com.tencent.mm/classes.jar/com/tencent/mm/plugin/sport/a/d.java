package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gd;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public final class d
  extends gd
  implements Comparable<d>
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(116812);
    c.a locala = new c.a();
    locala.IhA = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.IhC.put("id", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "id";
    locala.columns[1] = "date";
    locala.IhC.put("date", "TEXT");
    localStringBuilder.append(" date TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "step";
    locala.IhC.put("step", "INTEGER");
    localStringBuilder.append(" step INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "timestamp";
    locala.IhC.put("timestamp", "LONG");
    localStringBuilder.append(" timestamp LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(116812);
  }
  
  public final d a(diq paramdiq)
  {
    AppMethodBeat.i(161202);
    this.field_step = paramdiq.kuN;
    this.field_timestamp = (paramdiq.paX * 1000L);
    this.field_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.field_timestamp));
    AppMethodBeat.o(161202);
    return this;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.d
 * JD-Core Version:    0.7.0.1
 */