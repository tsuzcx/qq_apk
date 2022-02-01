package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlColumn;", "Lcom/tencent/mm/sdk/sql/ISqlObj;", "wechat-sdk_release"})
public abstract interface ISqlColumn
  extends ISqlObj
{
  @l(iBK={1, 1, 16})
  public static final class DefaultImpls
  {
    public static String[] params(ISqlColumn paramISqlColumn)
    {
      AppMethodBeat.i(190739);
      paramISqlColumn = ISqlObj.DefaultImpls.params((ISqlObj)paramISqlColumn);
      AppMethodBeat.o(190739);
      return paramISqlColumn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ISqlColumn
 * JD-Core Version:    0.7.0.1
 */