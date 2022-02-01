package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.go;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class aa
  extends go
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(97651);
    c.a locala = new c.a();
    locala.IBL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "canvasId";
    locala.IBN.put("canvasId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" canvasId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "canvasId";
    locala.columns[1] = "canvasXml";
    locala.IBN.put("canvasXml", "TEXT");
    localStringBuilder.append(" canvasXml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "canvasExt";
    locala.IBN.put("canvasExt", "TEXT");
    localStringBuilder.append(" canvasExt TEXT");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97651);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.aa
 * JD-Core Version:    0.7.0.1
 */