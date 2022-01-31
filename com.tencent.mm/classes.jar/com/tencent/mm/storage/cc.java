package com.tencent.mm.storage;

import com.tencent.mm.h.c.ep;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.reflect.Field;
import java.util.Map;

public final class cc
  extends ep
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.ujN.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "msgId";
    locala.columns[1] = "cmsgId";
    locala.ujN.put("cmsgId", "TEXT");
    localStringBuilder.append(" cmsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.ujN.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void acv(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.field_cmsgId = paramString;
  }
  
  protected final c.a rM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cc
 * JD-Core Version:    0.7.0.1
 */