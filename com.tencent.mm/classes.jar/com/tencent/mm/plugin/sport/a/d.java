package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public final class d
  extends fp
  implements Comparable<d>
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(116812);
    c.a locala = new c.a();
    locala.EYt = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.EYv.put("id", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "id";
    locala.columns[1] = "date";
    locala.EYv.put("date", "TEXT");
    localStringBuilder.append(" date TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "step";
    locala.EYv.put("step", "INTEGER");
    localStringBuilder.append(" step INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "timestamp";
    locala.EYv.put("timestamp", "LONG");
    localStringBuilder.append(" timestamp LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(116812);
  }
  
  public final d a(cxr paramcxr)
  {
    AppMethodBeat.i(161202);
    this.field_step = paramcxr.jzV;
    this.field_timestamp = (paramcxr.nUh * 1000L);
    this.field_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.field_timestamp));
    AppMethodBeat.o(161202);
    return this;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.d
 * JD-Core Version:    0.7.0.1
 */