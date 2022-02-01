package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ag
  extends fp
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(120859);
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "originMD5";
    locala.IBN.put("originMD5", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" originMD5 TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "originMD5";
    locala.columns[1] = "resultFile";
    locala.IBN.put("resultFile", "TEXT");
    localStringBuilder.append(" resultFile TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fromLang";
    locala.IBN.put("fromLang", "TEXT");
    localStringBuilder.append(" fromLang TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "toLang";
    locala.IBN.put("toLang", "TEXT");
    localStringBuilder.append(" toLang TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brand";
    locala.IBN.put("brand", "TEXT");
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
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ag
 * JD-Core Version:    0.7.0.1
 */