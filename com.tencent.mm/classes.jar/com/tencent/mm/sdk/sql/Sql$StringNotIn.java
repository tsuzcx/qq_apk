package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/Sql$StringNotIn;", "Lcom/tencent/mm/sdk/sql/InCondition;", "column", "", "values", "", "(Ljava/lang/String;Ljava/util/List;)V", "wechat-sdk_release"})
public final class Sql$StringNotIn
  extends InCondition
{
  public Sql$StringNotIn(String paramString, List<String> paramList)
  {
    super(paramString, true, true, paramList);
    AppMethodBeat.i(186366);
    AppMethodBeat.o(186366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.Sql.StringNotIn
 * JD-Core Version:    0.7.0.1
 */