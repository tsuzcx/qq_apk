package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlTable;", "Lcom/tencent/mm/sdk/sql/ISqlObj;", "wechat-sdk_release"})
public abstract interface ISqlTable
  extends ISqlObj
{
  @l(iBK={1, 1, 16})
  public static final class DefaultImpls
  {
    public static String[] params(ISqlTable paramISqlTable)
    {
      AppMethodBeat.i(191986);
      paramISqlTable = ISqlObj.DefaultImpls.params((ISqlObj)paramISqlTable);
      AppMethodBeat.o(191986);
      return paramISqlTable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ISqlTable
 * JD-Core Version:    0.7.0.1
 */