package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class l
  extends i<k>
  implements g.a
{
  public static final String[] dXp = { i.a(k.buS, "EmotionRewardInfo") };
  public e dXw;
  
  public l(e parame)
  {
    super(parame, k.buS, "EmotionRewardInfo", null);
    this.dXw = parame;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final afk acJ(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
      localObject = localCursor;
    }
    for (;;)
    {
      return localObject;
      localCursor = this.dXw.a("EmotionRewardInfo", new String[] { "content" }, "productID=?", new String[] { paramString }, null, null, null, 2);
      paramString = (String)localObject;
      if (localCursor != null)
      {
        paramString = (String)localObject;
        if (!localCursor.moveToFirst()) {}
      }
      try
      {
        paramString = new afk();
        paramString.aH(localCursor.getBlob(0));
        localObject = paramString;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        return paramString;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          y.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[] { bk.j(paramString) });
          paramString = (String)localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.l
 * JD-Core Version:    0.7.0.1
 */