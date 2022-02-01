package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(151657);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "appattach") };
    INDEX_CREATE = new String[] { "DROP INDEX IF EXISTS statusIndex", "CREATE INDEX IF NOT EXISTS msgInfoIdIndex ON appattach ( msgInfoId )", "CREATE INDEX IF NOT EXISTS appattach_statusIndex ON appattach ( status )" };
    AppMethodBeat.o(151657);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "appattach", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final void TQ(long paramLong)
  {
    AppMethodBeat.i(151652);
    String str = " update appattach set status = 198 , lastModifyTime = " + Util.nowSecond() + " where rowid = " + paramLong;
    this.db.execSQL("appattach", str);
    doNotify();
    AppMethodBeat.o(151652);
  }
  
  public final c TR(long paramLong)
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
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(151654);
    boolean bool = super.update(paramc, paramVarArgs);
    Log.d("MicroMsg.AppAttachInfoStorage", "update AppAttachInfo field_mediaId %s field_mediaSvrId %s ret %s %s", new Object[] { paramc.field_mediaId, paramc.field_mediaSvrId, Boolean.valueOf(bool), "" });
    AppMethodBeat.o(151654);
    return bool;
  }
  
  public final c bpR(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.d
 * JD-Core Version:    0.7.0.1
 */