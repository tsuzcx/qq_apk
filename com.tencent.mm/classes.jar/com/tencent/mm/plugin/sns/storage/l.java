package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class l
  extends fy
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(176284);
    c.a locala = new c.a();
    locala.IhA = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.IhC.put("key", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" key TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "key";
    locala.columns[1] = "timestamp";
    locala.IhC.put("timestamp", "LONG default '0' ");
    localStringBuilder.append(" timestamp LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "extFlag";
    locala.IhC.put("extFlag", "INTEGER default '0' ");
    localStringBuilder.append(" extFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "draft";
    locala.IhC.put("draft", "BLOB");
    localStringBuilder.append(" draft BLOB");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(176284);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.l
 * JD-Core Version:    0.7.0.1
 */