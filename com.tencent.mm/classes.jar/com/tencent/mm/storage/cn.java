package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class cn
  extends j<cm>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(148677);
    SQL_CREATE = new String[] { j.getCreateSQLs(cm.info, "VoiceTransText") };
    AppMethodBeat.o(148677);
  }
  
  public cn(e parame)
  {
    this(parame, cm.info, "VoiceTransText");
  }
  
  private cn(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(cm paramcm)
  {
    AppMethodBeat.i(148674);
    if (paramcm == null)
    {
      AppMethodBeat.o(148674);
      return false;
    }
    paramcm = paramcm.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcm) >= 0L)
    {
      AppMethodBeat.o(148674);
      return true;
    }
    AppMethodBeat.o(148674);
    return false;
  }
  
  public final cm aUA(String paramString)
  {
    AppMethodBeat.i(148675);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148675);
      return null;
    }
    cm localcm = new cm();
    paramString = this.db.a("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcm.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(148675);
    return localcm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cn
 * JD-Core Version:    0.7.0.1
 */