package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ISqlOrder;", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj;", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ISqlOrder
  extends ISqlObj
{
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class DefaultImpls
  {
    public static String[] params(ISqlOrder paramISqlOrder)
    {
      AppMethodBeat.i(244425);
      s.u(paramISqlOrder, "this");
      paramISqlOrder = ISqlObj.DefaultImpls.params((ISqlObj)paramISqlOrder);
      AppMethodBeat.o(244425);
      return paramISqlOrder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ISqlOrder
 * JD-Core Version:    0.7.0.1
 */