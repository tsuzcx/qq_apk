package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;

public final class cm
  extends gq
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(148673);
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IhC.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "msgId";
    locala.columns[1] = "cmsgId";
    locala.IhC.put("cmsgId", "TEXT");
    localStringBuilder.append(" cmsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.IhC.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(148673);
  }
  
  public final void aUz(String paramString)
  {
    AppMethodBeat.i(148672);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148672);
      return;
    }
    this.field_cmsgId = paramString;
    AppMethodBeat.o(148672);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.cm
 * JD-Core Version:    0.7.0.1
 */