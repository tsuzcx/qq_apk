package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class ch
  extends j<cg>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(148677);
    SQL_CREATE = new String[] { j.getCreateSQLs(cg.info, "VoiceTransText") };
    AppMethodBeat.o(148677);
  }
  
  public ch(e parame)
  {
    this(parame, cg.info, "VoiceTransText");
  }
  
  private ch(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(cg paramcg)
  {
    AppMethodBeat.i(148674);
    if (paramcg == null)
    {
      AppMethodBeat.o(148674);
      return false;
    }
    paramcg = paramcg.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcg) >= 0L)
    {
      AppMethodBeat.o(148674);
      return true;
    }
    AppMethodBeat.o(148674);
    return false;
  }
  
  public final cg aOJ(String paramString)
  {
    AppMethodBeat.i(148675);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148675);
      return null;
    }
    cg localcg = new cg();
    paramString = this.db.a("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(148675);
    return localcg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ch
 * JD-Core Version:    0.7.0.1
 */