package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  e db;
  
  static
  {
    AppMethodBeat.i(151657);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "appattach") };
    AppMethodBeat.o(151657);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "appattach", null);
    this.db = parame;
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(151654);
    boolean bool = super.update(paramc, paramVarArgs);
    ac.d("MicroMsg.AppAttachInfoStorage", "update AppAttachInfo field_mediaId %s field_mediaSvrId %s ret %s %s", new Object[] { paramc.field_mediaId, paramc.field_mediaSvrId, Boolean.valueOf(bool), "" });
    AppMethodBeat.o(151654);
    return bool;
  }
  
  public final c aGd(String paramString)
  {
    AppMethodBeat.i(151653);
    c localc = new c();
    localc.field_mediaSvrId = paramString;
    if (get(localc, new String[] { "mediaSvrId" }))
    {
      AppMethodBeat.o(151653);
      return localc;
    }
    if (get(localc, new String[] { "mediaId" }))
    {
      AppMethodBeat.o(151653);
      return localc;
    }
    AppMethodBeat.o(151653);
    return null;
  }
  
  public final void zL(long paramLong)
  {
    AppMethodBeat.i(151652);
    String str = " update appattach set status = 198 , lastModifyTime = " + bs.aNx() + " where rowid = " + paramLong;
    this.db.execSQL("appattach", str);
    doNotify();
    AppMethodBeat.o(151652);
  }
  
  public final c zM(long paramLong)
  {
    AppMethodBeat.i(151655);
    c localc = new c();
    localc.field_msgInfoId = paramLong;
    if (get(localc, new String[] { "msgInfoId" }))
    {
      AppMethodBeat.o(151655);
      return localc;
    }
    AppMethodBeat.o(151655);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.d
 * JD-Core Version:    0.7.0.1
 */