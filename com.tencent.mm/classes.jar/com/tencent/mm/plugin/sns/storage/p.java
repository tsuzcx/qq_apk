package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.h.c.ef;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;

public final class p
  extends ef
{
  protected static c.a buS;
  public int oLk;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "logtime";
    locala.ujN.put("logtime", "LONG");
    localStringBuilder.append(" logtime LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "offset";
    locala.ujN.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "logsize";
    locala.ujN.put("logsize", "INTEGER");
    localStringBuilder.append(" logsize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "errorcount";
    locala.ujN.put("errorcount", "INTEGER");
    localStringBuilder.append(" errorcount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "value";
    locala.ujN.put("value", "BLOB");
    localStringBuilder.append(" value BLOB");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void d(Cursor paramCursor)
  {
    try
    {
      super.d(paramCursor);
      this.oLk = ((int)this.ujK);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      y.e("MicroMsg.SnsKvReport", "error " + str);
      if ((str != null) && (str.contains("Unable to convert"))) {
        af.bDK().bGr();
      }
      try
      {
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        y.printErrStackTrace("MicroMsg.SnsKvReport", paramCursor, "", new Object[0]);
      }
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.p
 * JD-Core Version:    0.7.0.1
 */