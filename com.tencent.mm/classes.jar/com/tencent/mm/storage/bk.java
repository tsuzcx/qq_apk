package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bk
  extends cp
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(192572);
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "encryptUsername";
    locala.IhC.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "encryptUsername";
    locala.columns[1] = "username";
    locala.IhC.put("username", "TEXT default '' ");
    localStringBuilder.append(" username TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "modifyTime";
    locala.IhC.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(192572);
  }
  
  public bk()
  {
    AppMethodBeat.i(192571);
    this.field_encryptUsername = "";
    this.field_username = "";
    AppMethodBeat.o(192571);
  }
  
  public bk(String paramString)
  {
    this();
    AppMethodBeat.i(192570);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.field_encryptUsername = str;
    this.field_modifyTime = System.currentTimeMillis();
    AppMethodBeat.o(192570);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bk
 * JD-Core Version:    0.7.0.1
 */