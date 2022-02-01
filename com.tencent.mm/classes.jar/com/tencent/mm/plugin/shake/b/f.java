package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.a;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends a
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(28128);
    c.a locala = new c.a();
    locala.IhA = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "svrid";
    locala.IhC.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "svrid";
    locala.columns[1] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "subtype";
    locala.IhC.put("subtype", "INTEGER default '0' ");
    localStringBuilder.append(" subtype INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "createtime";
    locala.IhC.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "tag";
    locala.IhC.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "title";
    locala.IhC.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "desc";
    locala.IhC.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "thumburl";
    locala.IhC.put("thumburl", "TEXT");
    localStringBuilder.append(" thumburl TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "reserved1";
    locala.IhC.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved2";
    locala.IhC.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved3";
    locala.IhC.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reservedBuf";
    locala.IhC.put("reservedBuf", "BLOB");
    localStringBuilder.append(" reservedBuf BLOB");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(28128);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.f
 * JD-Core Version:    0.7.0.1
 */