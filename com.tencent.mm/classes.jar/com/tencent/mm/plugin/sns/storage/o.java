package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gl;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class o
  extends gl
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public int localid;
  
  static
  {
    AppMethodBeat.i(97590);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "logtime";
    localMAutoDBInfo.colsMap.put("logtime", "LONG");
    localStringBuilder.append(" logtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "logsize";
    localMAutoDBInfo.colsMap.put("logsize", "INTEGER");
    localStringBuilder.append(" logsize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "errorcount";
    localMAutoDBInfo.colsMap.put("errorcount", "INTEGER");
    localStringBuilder.append(" errorcount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "value";
    localMAutoDBInfo.colsMap.put("value", "BLOB");
    localStringBuilder.append(" value BLOB");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(97590);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97589);
    try
    {
      super.convertFrom(paramCursor);
      this.localid = ((int)this.systemRowid);
      AppMethodBeat.o(97589);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      Log.e("MicroMsg.SnsKvReport", "error ".concat(String.valueOf(str)));
      if ((str != null) && (str.contains("Unable to convert"))) {
        aj.faT().eIQ();
      }
      try
      {
        AppMethodBeat.o(97589);
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        Log.printErrStackTrace("MicroMsg.SnsKvReport", paramCursor, "", new Object[0]);
        AppMethodBeat.o(97589);
      }
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.o
 * JD-Core Version:    0.7.0.1
 */