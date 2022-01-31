package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.h.c.ec;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends ec
{
  protected static c.a buS;
  public int oLo;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsID";
    locala.ujN.put("snsID", "LONG");
    localStringBuilder.append(" snsID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "parentID";
    locala.ujN.put("parentID", "LONG");
    localStringBuilder.append(" parentID LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "isRead";
    locala.ujN.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.ujN.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "talker";
    locala.ujN.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "isSend";
    locala.ujN.put("isSend", "INTEGER default 'false' ");
    localStringBuilder.append(" isSend INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "curActionBuf";
    locala.ujN.put("curActionBuf", "BLOB");
    localStringBuilder.append(" curActionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "refActionBuf";
    locala.ujN.put("refActionBuf", "BLOB");
    localStringBuilder.append(" refActionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "commentSvrID";
    locala.ujN.put("commentSvrID", "LONG");
    localStringBuilder.append(" commentSvrID LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "clientId";
    locala.ujN.put("clientId", "TEXT");
    localStringBuilder.append(" clientId TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "commentflag";
    locala.ujN.put("commentflag", "INTEGER");
    localStringBuilder.append(" commentflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "isSilence";
    locala.ujN.put("isSilence", "INTEGER default '0' ");
    localStringBuilder.append(" isSilence INTEGER default '0' ");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void bGn()
  {
    this.field_commentflag |= 0x1;
  }
  
  public final void d(Cursor paramCursor)
  {
    try
    {
      super.d(paramCursor);
      this.oLo = ((int)this.ujK);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      y.e("MicroMsg.SnsComment", "error " + str);
      if ((str != null) && (str.contains("Unable to convert"))) {
        af.bDK().bGr();
      }
      try
      {
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        y.printErrStackTrace("MicroMsg.SnsComment", paramCursor, "", new Object[0]);
      }
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.j
 * JD-Core Version:    0.7.0.1
 */