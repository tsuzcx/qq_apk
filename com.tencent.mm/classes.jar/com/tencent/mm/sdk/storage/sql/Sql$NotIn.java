package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Sql$NotIn;", "Lcom/tencent/mm/sdk/storage/sql/InCondition;", "column", "", "values", "", "(Ljava/lang/String;Ljava/util/List;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sql$NotIn
  extends InCondition
{
  public Sql$NotIn(String paramString, List<String> paramList)
  {
    super(paramString, true, paramList);
    AppMethodBeat.i(244410);
    AppMethodBeat.o(244410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Sql.NotIn
 * JD-Core Version:    0.7.0.1
 */