package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends b
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(28145);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IBN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[1] = "lastshaketime";
    locala.IBN.put("lastshaketime", "INTEGER default '0' ");
    localStringBuilder.append(" lastshaketime INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "isshowed";
    locala.IBN.put("isshowed", "INTEGER default 'false' ");
    localStringBuilder.append(" isshowed INTEGER default 'false' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(28145);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.j
 * JD-Core Version:    0.7.0.1
 */