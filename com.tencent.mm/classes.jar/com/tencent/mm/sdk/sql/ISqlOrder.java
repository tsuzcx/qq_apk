package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlOrder;", "Lcom/tencent/mm/sdk/sql/ISqlObj;", "wechat-sdk_release"})
public abstract interface ISqlOrder
  extends ISqlObj
{
  @l(iBK={1, 1, 16})
  public static final class DefaultImpls
  {
    public static String[] params(ISqlOrder paramISqlOrder)
    {
      AppMethodBeat.i(189363);
      paramISqlOrder = ISqlObj.DefaultImpls.params((ISqlObj)paramISqlOrder);
      AppMethodBeat.o(189363);
      return paramISqlOrder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ISqlOrder
 * JD-Core Version:    0.7.0.1
 */