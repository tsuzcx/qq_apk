package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Sql$MultiEqual;", "Lcom/tencent/mm/sdk/storage/sql/MultiColumnValueCondition;", "column", "", "values", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sql$MultiEqual
  extends MultiColumnValueCondition
{
  public Sql$MultiEqual(String paramString, String... paramVarArgs)
  {
    super(paramString, ISqlObj.ConditionOperation.Equal, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.i(244373);
    AppMethodBeat.o(244373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Sql.MultiEqual
 * JD-Core Version:    0.7.0.1
 */