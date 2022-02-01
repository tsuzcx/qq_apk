package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;

public final class o
  extends MAutoStorage<n>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105120);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(n.info, "EmotionRewardInfo") };
    AppMethodBeat.o(105120);
  }
  
  public o(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, n.info, "EmotionRewardInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final buj bxU(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(105119);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
      AppMethodBeat.o(105119);
      return null;
    }
    Cursor localCursor = this.db.query("EmotionRewardInfo", new String[] { "content" }, "productID=?", new String[] { paramString }, null, null, null, 2);
    paramString = localObject;
    if (localCursor != null)
    {
      paramString = localObject;
      if (!localCursor.moveToFirst()) {}
    }
    try
    {
      paramString = new buj();
      paramString.parseFrom(localCursor.getBlob(0));
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(105119);
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.o
 * JD-Core Version:    0.7.0.1
 */