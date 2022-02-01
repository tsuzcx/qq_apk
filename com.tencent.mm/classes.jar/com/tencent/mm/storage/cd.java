package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;

public final class cd
  extends gc
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(148673);
    c.a locala = new c.a();
    locala.EYt = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.EYv.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "msgId";
    locala.columns[1] = "cmsgId";
    locala.EYv.put("cmsgId", "TEXT");
    localStringBuilder.append(" cmsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.EYv.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(148673);
  }
  
  public final void aJm(String paramString)
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
 * Qualified Name:     com.tencent.mm.storage.cd
 * JD-Core Version:    0.7.0.1
 */