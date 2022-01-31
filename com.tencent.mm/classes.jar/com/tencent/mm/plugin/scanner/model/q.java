package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class q
  extends eg
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(80885);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "originMD5";
    locala.yrM.put("originMD5", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" originMD5 TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "originMD5";
    locala.columns[1] = "resultFile";
    locala.yrM.put("resultFile", "TEXT");
    localStringBuilder.append(" resultFile TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fromLang";
    locala.yrM.put("fromLang", "TEXT");
    localStringBuilder.append(" fromLang TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "toLang";
    locala.yrM.put("toLang", "TEXT");
    localStringBuilder.append(" toLang TEXT");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(80885);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.q
 * JD-Core Version:    0.7.0.1
 */