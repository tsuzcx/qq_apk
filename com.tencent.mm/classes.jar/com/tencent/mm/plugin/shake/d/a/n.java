package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends c
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(28347);
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[1] = "deeplink";
    locala.IhC.put("deeplink", "TEXT default '' ");
    localStringBuilder.append(" deeplink TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "title";
    locala.IhC.put("title", "TEXT default '' ");
    localStringBuilder.append(" title TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "iconurl";
    locala.IhC.put("iconurl", "TEXT default '' ");
    localStringBuilder.append(" iconurl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "createtime";
    locala.IhC.put("createtime", "LONG default '' ");
    localStringBuilder.append(" createtime LONG default '' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(28347);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.n
 * JD-Core Version:    0.7.0.1
 */