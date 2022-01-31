package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends com.tencent.mm.sdk.e.i<i>
  implements g.a
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(i.buS, "EmotionDetailInfo") };
  public e dXw;
  
  public j(e parame)
  {
    super(parame, i.buS, "EmotionDetailInfo", null);
    this.dXw = parame;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final i acI(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
      paramString = (String)localObject1;
    }
    Cursor localCursor;
    do
    {
      return paramString;
      localCursor = this.dXw.a("EmotionDetailInfo", new String[] { "content", "lan" }, "productID=?", new String[] { paramString }, null, null, null, 2);
      localObject1 = localObject2;
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = new i();
          ((i)localObject1).field_content = localCursor.getBlob(0);
          ((i)localObject1).field_lan = localCursor.getString(1);
          ((i)localObject1).field_productID = paramString;
        }
      }
      paramString = (String)localObject1;
    } while (localCursor == null);
    localCursor.close();
    return localObject1;
  }
  
  public final String getTableName()
  {
    return "EmotionDetailInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.j
 * JD-Core Version:    0.7.0.1
 */