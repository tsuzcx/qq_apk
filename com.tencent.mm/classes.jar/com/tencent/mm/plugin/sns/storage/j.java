package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fn;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends fn
  implements Cloneable
{
  protected static c.a info;
  public int yvt;
  
  static
  {
    AppMethodBeat.i(97453);
    c.a locala = new c.a();
    locala.GvF = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsID";
    locala.GvH.put("snsID", "LONG");
    localStringBuilder.append(" snsID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "parentID";
    locala.GvH.put("parentID", "LONG");
    localStringBuilder.append(" parentID LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "isRead";
    locala.GvH.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.GvH.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "talker";
    locala.GvH.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "isSend";
    locala.GvH.put("isSend", "INTEGER default 'false' ");
    localStringBuilder.append(" isSend INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "curActionBuf";
    locala.GvH.put("curActionBuf", "BLOB");
    localStringBuilder.append(" curActionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "refActionBuf";
    locala.GvH.put("refActionBuf", "BLOB");
    localStringBuilder.append(" refActionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "commentSvrID";
    locala.GvH.put("commentSvrID", "LONG");
    localStringBuilder.append(" commentSvrID LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "clientId";
    locala.GvH.put("clientId", "TEXT");
    localStringBuilder.append(" clientId TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "commentflag";
    locala.GvH.put("commentflag", "INTEGER");
    localStringBuilder.append(" commentflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "isSilence";
    locala.GvH.put("isSilence", "INTEGER default '0' ");
    localStringBuilder.append(" isSilence INTEGER default '0' ");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97453);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97450);
    try
    {
      super.convertFrom(paramCursor);
      this.yvt = ((int)this.systemRowid);
      AppMethodBeat.o(97450);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      ac.e("MicroMsg.SnsComment", "error ".concat(String.valueOf(str)));
      if ((str != null) && (str.contains("Unable to convert"))) {
        af.dHW().duq();
      }
      try
      {
        AppMethodBeat.o(97450);
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        ac.printErrStackTrace("MicroMsg.SnsComment", paramCursor, "", new Object[0]);
        AppMethodBeat.o(97450);
      }
    }
  }
  
  public final void dMd()
  {
    this.field_commentflag |= 0x1;
  }
  
  public final j dMe()
  {
    AppMethodBeat.i(97451);
    try
    {
      j localj = (j)super.clone();
      AppMethodBeat.o(97451);
      return localj;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SnsComment", "snscomment clone error");
        Object localObject = null;
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.j
 * JD-Core Version:    0.7.0.1
 */