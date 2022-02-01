package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.Map;

public final class cg
  extends gg
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(148673);
    c.a locala = new c.a();
    locala.GvF = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.GvH.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "msgId";
    locala.columns[1] = "cmsgId";
    locala.GvH.put("cmsgId", "TEXT");
    localStringBuilder.append(" cmsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.GvH.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(148673);
  }
  
  public final void aOI(String paramString)
  {
    AppMethodBeat.i(148672);
    if (bs.isNullOrNil(paramString))
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
 * Qualified Name:     com.tencent.mm.storage.cg
 * JD-Core Version:    0.7.0.1
 */