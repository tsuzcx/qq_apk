package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.shake.a.a.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends c
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "username";
    locala.columns[1] = "deeplink";
    locala.ujN.put("deeplink", "TEXT default '' ");
    localStringBuilder.append(" deeplink TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "title";
    locala.ujN.put("title", "TEXT default '' ");
    localStringBuilder.append(" title TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "iconurl";
    locala.ujN.put("iconurl", "TEXT default '' ");
    localStringBuilder.append(" iconurl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "createtime";
    locala.ujN.put("createtime", "LONG default '' ");
    localStringBuilder.append(" createtime LONG default '' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.n
 * JD-Core Version:    0.7.0.1
 */