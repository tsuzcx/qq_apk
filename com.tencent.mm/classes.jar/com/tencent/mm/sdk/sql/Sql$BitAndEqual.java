package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/Sql$BitAndEqual;", "Lcom/tencent/mm/sdk/sql/ColumnBitValueCondition;", "column", "", "bitValue", "", "compareValue", "(Ljava/lang/String;II)V", "wechat-sdk_release"})
public final class Sql$BitAndEqual
  extends ColumnBitValueCondition
{
  public Sql$BitAndEqual(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1, ISqlObj.ConditionBitOperation.And, paramInt2, ISqlObj.ConditionOperation.Equal);
    AppMethodBeat.i(188677);
    AppMethodBeat.o(188677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.Sql.BitAndEqual
 * JD-Core Version:    0.7.0.1
 */