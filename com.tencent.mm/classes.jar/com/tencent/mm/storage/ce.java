package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class ce
  extends j<cd>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(148677);
    SQL_CREATE = new String[] { j.getCreateSQLs(cd.info, "VoiceTransText") };
    AppMethodBeat.o(148677);
  }
  
  public ce(e parame)
  {
    this(parame, cd.info, "VoiceTransText");
  }
  
  private ce(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(cd paramcd)
  {
    AppMethodBeat.i(148674);
    if (paramcd == null)
    {
      AppMethodBeat.o(148674);
      return false;
    }
    paramcd = paramcd.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcd) >= 0L)
    {
      AppMethodBeat.o(148674);
      return true;
    }
    AppMethodBeat.o(148674);
    return false;
  }
  
  public final cd aJn(String paramString)
  {
    AppMethodBeat.i(148675);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148675);
      return null;
    }
    cd localcd = new cd();
    paramString = this.db.a("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcd.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(148675);
    return localcd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ce
 * JD-Core Version:    0.7.0.1
 */