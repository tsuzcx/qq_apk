package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends ai
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(36917);
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "canvasId";
    locala.yrM.put("canvasId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" canvasId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "canvasId";
    locala.columns[1] = "canvasXml";
    locala.yrM.put("canvasXml", "TEXT");
    localStringBuilder.append(" canvasXml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "createTime";
    locala.yrM.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(36917);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.c
 * JD-Core Version:    0.7.0.1
 */