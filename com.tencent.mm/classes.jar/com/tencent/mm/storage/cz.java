package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class cz
  extends MAutoStorage<cy>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(148677);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cy.info, "VoiceTransText") };
    AppMethodBeat.o(148677);
  }
  
  public cz(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, cy.info, "VoiceTransText");
  }
  
  private cz(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean b(cy paramcy)
  {
    AppMethodBeat.i(148674);
    if (paramcy == null)
    {
      AppMethodBeat.o(148674);
      return false;
    }
    paramcy = paramcy.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcy) >= 0L)
    {
      AppMethodBeat.o(148674);
      return true;
    }
    AppMethodBeat.o(148674);
    return false;
  }
  
  public final cy byR(String paramString)
  {
    AppMethodBeat.i(148675);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148675);
      return null;
    }
    cy localcy = new cy();
    paramString = this.db.query("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcy.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(148675);
    return localcy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cz
 * JD-Core Version:    0.7.0.1
 */