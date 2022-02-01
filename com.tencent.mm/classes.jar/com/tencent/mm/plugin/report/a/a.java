package com.tencent.mm.plugin.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.be;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends be
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(143779);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bakLogId";
    locala.IhC.put("bakLogId", "INTEGER");
    localStringBuilder.append(" bakLogId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "valueStr";
    locala.IhC.put("valueStr", "TEXT");
    localStringBuilder.append(" valueStr TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(143779);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a.a
 * JD-Core Version:    0.7.0.1
 */