package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class cw
  extends MAutoStorage<cv>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(148677);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(cv.info, "VoiceTransText") };
    AppMethodBeat.o(148677);
  }
  
  public cw(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, cv.info, "VoiceTransText", null);
  }
  
  public cw(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean b(cv paramcv)
  {
    AppMethodBeat.i(148674);
    if (paramcv == null)
    {
      AppMethodBeat.o(148674);
      return false;
    }
    paramcv = paramcv.convertTo();
    if (this.db.replace("VoiceTransText", "msgId", paramcv) >= 0L)
    {
      AppMethodBeat.o(148674);
      return true;
    }
    AppMethodBeat.o(148674);
    return false;
  }
  
  public final cv bxz(String paramString)
  {
    AppMethodBeat.i(148675);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148675);
      return null;
    }
    cv localcv = new cv();
    paramString = this.db.query("VoiceTransText", null, "cmsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localcv.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(148675);
    return localcv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cw
 * JD-Core Version:    0.7.0.1
 */