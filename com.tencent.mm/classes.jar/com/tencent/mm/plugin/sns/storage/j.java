package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fj;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends fj
  implements Cloneable
{
  protected static c.a info;
  public int xiF;
  
  static
  {
    AppMethodBeat.i(97453);
    c.a locala = new c.a();
    locala.EYt = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "snsID";
    locala.EYv.put("snsID", "LONG");
    localStringBuilder.append(" snsID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "parentID";
    locala.EYv.put("parentID", "LONG");
    localStringBuilder.append(" parentID LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "isRead";
    locala.EYv.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.EYv.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "talker";
    locala.EYv.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "isSend";
    locala.EYv.put("isSend", "INTEGER default 'false' ");
    localStringBuilder.append(" isSend INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "curActionBuf";
    locala.EYv.put("curActionBuf", "BLOB");
    localStringBuilder.append(" curActionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "refActionBuf";
    locala.EYv.put("refActionBuf", "BLOB");
    localStringBuilder.append(" refActionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "commentSvrID";
    locala.EYv.put("commentSvrID", "LONG");
    localStringBuilder.append(" commentSvrID LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "clientId";
    locala.EYv.put("clientId", "TEXT");
    localStringBuilder.append(" clientId TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "commentflag";
    locala.EYv.put("commentflag", "INTEGER");
    localStringBuilder.append(" commentflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "isSilence";
    locala.EYv.put("isSilence", "INTEGER default '0' ");
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
      this.xiF = ((int)this.systemRowid);
      AppMethodBeat.o(97450);
      return;
    }
    catch (Exception paramCursor)
    {
      String str = paramCursor.getMessage();
      ad.e("MicroMsg.SnsComment", "error ".concat(String.valueOf(str)));
      if ((str != null) && (str.contains("Unable to convert"))) {
        af.dtz().dgI();
      }
      try
      {
        AppMethodBeat.o(97450);
        throw paramCursor;
      }
      catch (Exception paramCursor)
      {
        ad.printErrStackTrace("MicroMsg.SnsComment", paramCursor, "", new Object[0]);
        AppMethodBeat.o(97450);
      }
    }
  }
  
  public final void dxG()
  {
    this.field_commentflag |= 0x1;
  }
  
  public final j dxH()
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
        ad.e("MicroMsg.SnsComment", "snscomment clone error");
        Object localObject = null;
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.j
 * JD-Core Version:    0.7.0.1
 */