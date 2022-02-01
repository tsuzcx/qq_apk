package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Sql$In;", "Lcom/tencent/mm/sdk/storage/sql/InCondition;", "column", "", "values", "", "(Ljava/lang/String;Ljava/util/List;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sql$In
  extends InCondition
{
  public Sql$In(String paramString, List<String> paramList)
  {
    super(paramString, false, paramList);
    AppMethodBeat.i(244419);
    AppMethodBeat.o(244419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Sql.In
 * JD-Core Version:    0.7.0.1
 */