package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class ISqlCondition$DefaultImpls
{
  public static String[] params(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(244361);
    s.u(paramISqlCondition, "this");
    paramISqlCondition = ISqlObj.DefaultImpls.params((ISqlObj)paramISqlCondition);
    AppMethodBeat.o(244361);
    return paramISqlCondition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ISqlCondition.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */