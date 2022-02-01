package com.tencent.mm.plugin.msgquote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ej;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ej
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(88813);
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IhC.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "msgSvrId";
    locala.IhC.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "quotedMsgId";
    locala.IhC.put("quotedMsgId", "LONG");
    localStringBuilder.append(" quotedMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "quotedMsgSvrId";
    locala.IhC.put("quotedMsgSvrId", "LONG");
    localStringBuilder.append(" quotedMsgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(88813);
  }
  
  private b doA()
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
        ad.i("MicroMsg.msgquote.MsgQute", "clone() Exception:%s %s", new Object[] { localException.getClass(), localException.getMessage() });
      }
    }
  }
  
  public final c.a getDBInfo()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.a.b
 * JD-Core Version:    0.7.0.1
 */