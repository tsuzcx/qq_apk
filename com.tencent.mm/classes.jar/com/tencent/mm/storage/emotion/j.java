package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
  extends com.tencent.mm.sdk.e.j<i>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(62858);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(i.info, "EmotionDetailInfo") };
    AppMethodBeat.o(62858);
  }
  
  public j(e parame)
  {
    super(parame, i.info, "EmotionDetailInfo", null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final i asW(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(62857);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
      AppMethodBeat.o(62857);
      return null;
    }
    Cursor localCursor = this.db.a("EmotionDetailInfo", new String[] { "content", "lan" }, "productID=?", new String[] { paramString }, null, null, null, 2);
    Object localObject1 = localObject2;
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
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(62857);
    return localObject1;
  }
  
  public final String getTableName()
  {
    return "EmotionDetailInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.j
 * JD-Core Version:    0.7.0.1
 */