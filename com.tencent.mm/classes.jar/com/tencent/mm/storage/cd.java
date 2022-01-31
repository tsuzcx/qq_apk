package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class cd
  extends j<cc>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(116827);
    SQL_CREATE = new String[] { j.getCreateSQLs(cc.info, "VoiceTransText") };
    AppMethodBeat.o(116827);
  }
  
  public cd(e parame)
  {
    this(parame, cc.info, "VoiceTransText");
  }
  
  private cd(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(cc paramcc)
  {
    AppMethodBeat.i(116824);
    if (paramcc == null)
    {
      AppMethodBeat.o(116824);
      return false;
    }
    paramcc = paramcc.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcc) >= 0L)
    {
      AppMethodBeat.o(116824);
      return true;
    }
    AppMethodBeat.o(116824);
    return false;
  }
  
  public final cc asI(String paramString)
  {
    AppMethodBeat.i(116825);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116825);
      return null;
    }
    cc localcc = new cc();
    paramString = this.db.a("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcc.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(116825);
    return localcc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cd
 * JD-Core Version:    0.7.0.1
 */