package com.tencent.mm.plugin.msgquote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class b
  extends fj
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(88813);
    info = fj.aJm();
    AppMethodBeat.o(88813);
  }
  
  private b gdO()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.a.b
 * JD-Core Version:    0.7.0.1
 */