package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.io.IOException;

public final class n
  extends j<m>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(105120);
    SQL_CREATE = new String[] { j.getCreateSQLs(m.info, "EmotionRewardInfo") };
    AppMethodBeat.o(105120);
  }
  
  public n(e parame)
  {
    super(parame, m.info, "EmotionRewardInfo", null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final GetEmotionRewardResponse aJF(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(105119);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
      AppMethodBeat.o(105119);
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
      AppMethodBeat.o(105119);
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[] { bt.m(paramString) });
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.n
 * JD-Core Version:    0.7.0.1
 */