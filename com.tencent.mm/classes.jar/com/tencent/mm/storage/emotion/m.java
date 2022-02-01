package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class m
  extends j<l>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(105117);
    SQL_CREATE = new String[] { j.getCreateSQLs(l.info, "EmotionDetailInfo") };
    AppMethodBeat.o(105117);
  }
  
  public m(e parame)
  {
    super(parame, l.info, "EmotionDetailInfo", null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final void a(String paramString1, GetEmotionDetailResponse paramGetEmotionDetailResponse, String paramString2)
  {
    AppMethodBeat.i(183930);
    if ((bu.isNullOrNil(paramString1)) || (paramGetEmotionDetailResponse == null)) {
      ae.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
    }
    try
    {
      l locall = new l();
      locall.field_productID = paramString1;
      locall.field_content = paramGetEmotionDetailResponse.toByteArray();
      locall.field_lan = paramString2;
      paramGetEmotionDetailResponse = locall.convertTo();
      if (this.db.replace("EmotionDetailInfo", "productID", paramGetEmotionDetailResponse) > 0L)
      {
        ae.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[] { paramString1 });
        AppMethodBeat.o(183930);
        return;
      }
      ae.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[] { paramString1 });
      AppMethodBeat.o(183930);
      return;
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bu.o(paramString1) });
      AppMethodBeat.o(183930);
    }
  }
  
  public final l aWu(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(105116);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
      AppMethodBeat.o(105116);
      return null;
    }
    Cursor localCursor = this.db.a("EmotionDetailInfo", new String[] { "content", "lan" }, "productID=?", new String[] { paramString }, null, null, null, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.m
 * JD-Core Version:    0.7.0.1
 */