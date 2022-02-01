package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gb;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends gb
{
  protected static c.a info;
  public int zMC;
  
  static
  {
    AppMethodBeat.i(97590);
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "logtime";
    locala.IhC.put("logtime", "LONG");
    localStringBuilder.append(" logtime LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "offset";
    locala.IhC.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "logsize";
    locala.IhC.put("logsize", "INTEGER");
    localStringBuilder.append(" logsize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "errorcount";
    locala.IhC.put("errorcount", "INTEGER");
    localStringBuilder.append(" errorcount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "value";
    locala.IhC.put("value", "BLOB");
    localStringBuilder.append(" value BLOB");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97590);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97589);
    try
    {
      super.convertFrom(paramCursor);
      this.zMC = ((int)this.systemRowid);
      AppMethodBeat.o(97589);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      ad.e("MicroMsg.SnsKvReport", "error ".concat(String.valueOf(str)));
      if ((str != null) && (str.contains("Unable to convert"))) {
        ag.dUj().dEM();
      }
      try
      {
        AppMethodBeat.o(97589);
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        ad.printErrStackTrace("MicroMsg.SnsKvReport", paramCursor, "", new Object[0]);
        AppMethodBeat.o(97589);
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.r
 * JD-Core Version:    0.7.0.1
 */