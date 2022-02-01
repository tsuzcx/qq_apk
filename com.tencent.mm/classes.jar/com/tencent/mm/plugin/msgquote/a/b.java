package com.tencent.mm.plugin.msgquote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ep
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(88813);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "quotedMsgId";
    localMAutoDBInfo.colsMap.put("quotedMsgId", "LONG");
    localStringBuilder.append(" quotedMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "quotedMsgSvrId";
    localMAutoDBInfo.colsMap.put("quotedMsgSvrId", "LONG");
    localStringBuilder.append(" quotedMsgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(88813);
  }
  
  private b els()
  {
    AppMethodBeat.i(88811);
    b localb = new b();
    try
    {
      localb.systemRowid = this.systemRowid;
      localb.field_msgId = this.field_msgId;
      localb.field_msgSvrId = this.field_msgSvrId;
      localb.field_quotedMsgId = this.field_quotedMsgId;
      localb.field_quotedMsgSvrId = this.field_quotedMsgSvrId;
      localb.field_status = this.field_status;
      AppMethodBeat.o(88811);
      return localb;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.msgquote.MsgQute", "clone() Exception:%s %s", new Object[] { localException.getClass(), localException.getMessage() });
      }
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(88810);
    String str = "MsgQute{field_msgId=" + this.field_msgId + ", field_msgSvrId=" + this.field_msgSvrId + ", field_quotedMsgId=" + this.field_quotedMsgId + ", field_quotedMsgSvrId=" + this.field_quotedMsgSvrId + ", field_status=" + this.field_status + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(88810);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.a.b
 * JD-Core Version:    0.7.0.1
 */