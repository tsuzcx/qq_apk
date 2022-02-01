package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ad
  extends gm
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70432);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mNativeUrl";
    locala.GvH.put("mNativeUrl", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "mNativeUrl";
    locala.columns[1] = "hbType";
    locala.GvH.put("hbType", "INTEGER");
    localStringBuilder.append(" hbType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "receiveAmount";
    locala.GvH.put("receiveAmount", "LONG");
    localStringBuilder.append(" receiveAmount LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "receiveTime";
    locala.GvH.put("receiveTime", "LONG");
    localStringBuilder.append(" receiveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "receiveStatus";
    locala.GvH.put("receiveStatus", "INTEGER");
    localStringBuilder.append(" receiveStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "hbStatus";
    locala.GvH.put("hbStatus", "INTEGER");
    localStringBuilder.append(" hbStatus INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70432);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70431);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(70431);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ad
 * JD-Core Version:    0.7.0.1
 */