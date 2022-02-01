package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.goe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class m
  extends MAutoStorage<l>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105117);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(l.info, "EmotionDetailInfo") };
    AppMethodBeat.o(105117);
  }
  
  public m(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, l.info, "EmotionDetailInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void a(String paramString1, goe paramgoe, String paramString2)
  {
    AppMethodBeat.i(183930);
    if ((Util.isNullOrNil(paramString1)) || (paramgoe == null)) {
      Log.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
    }
    try
    {
      l locall = new l();
      locall.field_productID = paramString1;
      locall.field_content = paramgoe.toByteArray();
      locall.field_lan = paramString2;
      paramgoe = locall.convertTo();
      if (this.db.replace("EmotionDetailInfo", "productID", paramgoe) > 0L)
      {
        Log.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[] { paramString1 });
        AppMethodBeat.o(183930);
        return;
      }
      Log.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(183930);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(183930);
    }
  }
  
  public final l bzj(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(105116);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
      AppMethodBeat.o(105116);
      return null;
    }
    Cursor localCursor = this.db.query("EmotionDetailInfo", new String[] { "content", "lan" }, "productID=?", new String[] { paramString }, null, null, null, 2);
    Object localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        localObject1 = new l();
        ((l)localObject1).field_content = localCursor.getBlob(0);
        ((l)localObject1).field_lan = localCursor.getString(1);
        ((l)localObject1).field_productID = paramString;
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(105116);
    return localObject1;
  }
  
  public final String getTableName()
  {
    return "EmotionDetailInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.m
 * JD-Core Version:    0.7.0.1
 */