package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class cv
  extends MAutoStorage<cu>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(148677);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cu.info, "VoiceTransText") };
    AppMethodBeat.o(148677);
  }
  
  public cv(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, cu.info, "VoiceTransText");
  }
  
  private cv(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(cu paramcu)
  {
    AppMethodBeat.i(148674);
    if (paramcu == null)
    {
      AppMethodBeat.o(148674);
      return false;
    }
    paramcu = paramcu.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcu) >= 0L)
    {
      AppMethodBeat.o(148674);
      return true;
    }
    AppMethodBeat.o(148674);
    return false;
  }
  
  public final cu bkZ(String paramString)
  {
    AppMethodBeat.i(148675);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148675);
      return null;
    }
    cu localcu = new cu();
    paramString = this.db.query("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcu.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(148675);
    return localcu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.cv
 * JD-Core Version:    0.7.0.1
 */