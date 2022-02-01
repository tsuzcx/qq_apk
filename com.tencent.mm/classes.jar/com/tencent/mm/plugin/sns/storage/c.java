package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ao;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends ao
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(96280);
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "canvasId";
    locala.IhC.put("canvasId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" canvasId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "canvasId";
    locala.columns[1] = "canvasXml";
    locala.IhC.put("canvasXml", "TEXT");
    localStringBuilder.append(" canvasXml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "createTime";
    locala.IhC.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(96280);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.c
 * JD-Core Version:    0.7.0.1
 */