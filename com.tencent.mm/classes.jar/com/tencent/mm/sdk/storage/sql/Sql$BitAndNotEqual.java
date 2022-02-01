package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Sql$BitAndNotEqual;", "Lcom/tencent/mm/sdk/storage/sql/ColumnBitValueCondition;", "column", "", "bitValue", "", "compareValue", "(Ljava/lang/String;II)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sql$BitAndNotEqual
  extends ColumnBitValueCondition
{
  public Sql$BitAndNotEqual(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1, ISqlObj.ConditionBitOperation.And, paramInt2, ISqlObj.ConditionOperation.NotEqual);
    AppMethodBeat.i(244376);
    AppMethodBeat.o(244376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Sql.BitAndNotEqual
 * JD-Core Version:    0.7.0.1
 */