package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.go;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends go
  implements Cloneable
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public int Kzs;
  
  static
  {
    AppMethodBeat.i(97453);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "snsID";
    localMAutoDBInfo.colsMap.put("snsID", "LONG");
    localStringBuilder.append(" snsID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "parentID";
    localMAutoDBInfo.colsMap.put("parentID", "LONG");
    localStringBuilder.append(" parentID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER default 'false' ");
    localStringBuilder.append(" isSend INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "curActionBuf";
    localMAutoDBInfo.colsMap.put("curActionBuf", "BLOB");
    localStringBuilder.append(" curActionBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "refActionBuf";
    localMAutoDBInfo.colsMap.put("refActionBuf", "BLOB");
    localStringBuilder.append(" refActionBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "commentSvrID";
    localMAutoDBInfo.colsMap.put("commentSvrID", "LONG");
    localStringBuilder.append(" commentSvrID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "clientId";
    localMAutoDBInfo.colsMap.put("clientId", "TEXT");
    localStringBuilder.append(" clientId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "commentflag";
    localMAutoDBInfo.colsMap.put("commentflag", "INTEGER");
    localStringBuilder.append(" commentflag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "isSilence";
    localMAutoDBInfo.colsMap.put("isSilence", "INTEGER default '0' ");
    localStringBuilder.append(" isSilence INTEGER default '0' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(97453);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97450);
    try
    {
      super.convertFrom(paramCursor);
      this.Kzs = ((int)this.systemRowid);
      AppMethodBeat.o(97450);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      Log.e("MicroMsg.SnsComment", "error ".concat(String.valueOf(str)));
      if ((str != null) && (str.contains("Unable to convert"))) {
        aj.fON().fuU();
      }
      try
      {
        AppMethodBeat.o(97450);
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        Log.printErrStackTrace("MicroMsg.SnsComment", paramCursor, "", new Object[0]);
        AppMethodBeat.o(97450);
      }
    }
  }
  
  public final void fSx()
  {
    this.field_commentflag |= 0x1;
  }
  
  public final h fSy()
  {
    AppMethodBeat.i(97451);
    try
    {
      h localh = (h)super.clone();
      AppMethodBeat.o(97451);
      return localh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsComment", "snscomment clone error");
        Object localObject = null;
      }
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.h
 * JD-Core Version:    0.7.0.1
 */