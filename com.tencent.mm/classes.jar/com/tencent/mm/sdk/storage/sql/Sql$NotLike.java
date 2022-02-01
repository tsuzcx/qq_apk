package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Sql$NotLike;", "Lcom/tencent/mm/sdk/storage/sql/LikeCondition;", "column", "", "likeValue", "(Ljava/lang/String;Ljava/lang/String;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sql$NotLike
  extends LikeCondition
{
  public Sql$NotLike(String paramString1, String paramString2)
  {
    super(paramString1, true, paramString2);
    AppMethodBeat.i(244395);
    AppMethodBeat.o(244395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Sql.NotLike
 * JD-Core Version:    0.7.0.1
 */