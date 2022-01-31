package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class l
  extends j<k>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(62861);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "EmotionRewardInfo") };
    AppMethodBeat.o(62861);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "EmotionRewardInfo", null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final GetEmotionRewardResponse asX(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(62860);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
      AppMethodBeat.o(62860);
      return null;
    }
    Cursor localCursor = this.db.a("EmotionRewardInfo", new String[] { "content" }, "productID=?", new String[] { paramString }, null, null, null, 2);
    paramString = localObject;
    if (localCursor != null)
    {
      paramString = localObject;
      if (!localCursor.moveToFirst()) {}
    }
    try
    {
      paramString = new GetEmotionRewardResponse();
      paramString.parseFrom(localCursor.getBlob(0));
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(62860);
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[] { bo.l(paramString) });
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.l
 * JD-Core Version:    0.7.0.1
 */