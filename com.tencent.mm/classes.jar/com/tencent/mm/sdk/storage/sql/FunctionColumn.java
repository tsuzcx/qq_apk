package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/FunctionColumn;", "Lcom/tencent/mm/sdk/storage/sql/Column;", "name", "", "dataType", "tableName", "referTo", "function", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFunction", "()Ljava/lang/String;", "tableColumnName", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FunctionColumn
  extends Column
{
  private final String function;
  
  public FunctionColumn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.i(244394);
    this.function = paramString5;
    AppMethodBeat.o(244394);
  }
  
  public final String getFunction()
  {
    return this.function;
  }
  
  public final String tableColumnName()
  {
    AppMethodBeat.i(244408);
    String str = this.function + '(' + super.tableColumnName() + ')';
    AppMethodBeat.o(244408);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.FunctionColumn
 * JD-Core Version:    0.7.0.1
 */