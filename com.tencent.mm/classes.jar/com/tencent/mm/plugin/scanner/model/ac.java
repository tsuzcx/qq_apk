package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ac
  extends ff
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(120859);
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "originMD5";
    locala.GvH.put("originMD5", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" originMD5 TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "originMD5";
    locala.columns[1] = "resultFile";
    locala.GvH.put("resultFile", "TEXT");
    localStringBuilder.append(" resultFile TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fromLang";
    locala.GvH.put("fromLang", "TEXT");
    localStringBuilder.append(" fromLang TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "toLang";
    locala.GvH.put("toLang", "TEXT");
    localStringBuilder.append(" toLang TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brand";
    locala.GvH.put("brand", "TEXT");
    localStringBuilder.append(" brand TEXT");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(120859);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ac
 * JD-Core Version:    0.7.0.1
 */