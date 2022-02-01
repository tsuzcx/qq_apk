package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/FunctionColumn;", "Lcom/tencent/mm/sdk/storage/sql/Column;", "name", "", "dataType", "tableName", "referTo", "function", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFunction", "()Ljava/lang/String;", "tableColumnName", "wechat-sdk_release"})
public final class FunctionColumn
  extends Column
{
  private final String function;
  
  public FunctionColumn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.i(192950);
    this.function = paramString5;
    AppMethodBeat.o(192950);
  }
  
  public final String getFunction()
  {
    return this.function;
  }
  
  public final String tableColumnName()
  {
    AppMethodBeat.i(192943);
    String str = this.function + '(' + super.tableColumnName() + ')';
    AppMethodBeat.o(192943);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.FunctionColumn
 * JD-Core Version:    0.7.0.1
 */