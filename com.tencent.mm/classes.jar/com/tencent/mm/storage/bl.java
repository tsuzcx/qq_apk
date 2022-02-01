package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bl
  extends cp
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(213448);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "encryptUsername";
    locala.IBN.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "encryptUsername";
    locala.columns[1] = "username";
    locala.IBN.put("username", "TEXT default '' ");
    localStringBuilder.append(" username TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "modifyTime";
    locala.IBN.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(213448);
  }
  
  public bl()
  {
    AppMethodBeat.i(213447);
    this.field_encryptUsername = "";
    this.field_username = "";
    AppMethodBeat.o(213447);
  }
  
  public bl(String paramString)
  {
    this();
    AppMethodBeat.i(213446);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.field_encryptUsername = str;
    this.field_modifyTime = System.currentTimeMillis();
    AppMethodBeat.o(213446);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bl
 * JD-Core Version:    0.7.0.1
 */