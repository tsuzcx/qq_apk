package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fr;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends fr
{
  protected static c.a info;
  public int yvp;
  
  static
  {
    AppMethodBeat.i(97590);
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "logtime";
    locala.GvH.put("logtime", "LONG");
    localStringBuilder.append(" logtime LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "offset";
    locala.GvH.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "logsize";
    locala.GvH.put("logsize", "INTEGER");
    localStringBuilder.append(" logsize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "errorcount";
    locala.GvH.put("errorcount", "INTEGER");
    localStringBuilder.append(" errorcount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "value";
    locala.GvH.put("value", "BLOB");
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
      this.yvp = ((int)this.systemRowid);
      AppMethodBeat.o(97589);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      ac.e("MicroMsg.SnsKvReport", "error ".concat(String.valueOf(str)));
      if ((str != null) && (str.contains("Unable to convert"))) {
        af.dHW().duq();
      }
      try
      {
        AppMethodBeat.o(97589);
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        ac.printErrStackTrace("MicroMsg.SnsKvReport", paramCursor, "", new Object[0]);
        AppMethodBeat.o(97589);
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.r
 * JD-Core Version:    0.7.0.1
 */