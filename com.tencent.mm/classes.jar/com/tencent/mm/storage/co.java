package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class co
  extends j<cn>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(148677);
    SQL_CREATE = new String[] { j.getCreateSQLs(cn.info, "VoiceTransText") };
    AppMethodBeat.o(148677);
  }
  
  public co(e parame)
  {
    this(parame, cn.info, "VoiceTransText");
  }
  
  private co(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(cn paramcn)
  {
    AppMethodBeat.i(148674);
    if (paramcn == null)
    {
      AppMethodBeat.o(148674);
      return false;
    }
    paramcn = paramcn.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcn) >= 0L)
    {
      AppMethodBeat.o(148674);
      return true;
    }
    AppMethodBeat.o(148674);
    return false;
  }
  
  public final cn aWb(String paramString)
  {
    AppMethodBeat.i(148675);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148675);
      return null;
    }
    cn localcn = new cn();
    paramString = this.db.a("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcn.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(148675);
    return localcn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.co
 * JD-Core Version:    0.7.0.1
 */