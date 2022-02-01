package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/Sql$MultiNotEqual;", "Lcom/tencent/mm/sdk/sql/MultiColumnValueCondition;", "column", "", "values", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "wechat-sdk_release"})
public final class Sql$MultiNotEqual
  extends MultiColumnValueCondition
{
  public Sql$MultiNotEqual(String paramString, String... paramVarArgs)
  {
    super(paramString, ISqlObj.ConditionOperation.NotEqual, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.i(189972);
    AppMethodBeat.o(189972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.Sql.MultiNotEqual
 * JD-Core Version:    0.7.0.1
 */