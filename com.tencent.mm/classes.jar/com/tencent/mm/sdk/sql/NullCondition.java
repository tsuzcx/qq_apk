package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/NullCondition;", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "column", "", "(Ljava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public class NullCondition
  extends SingleCondition
{
  private final String column;
  
  public NullCondition(String paramString)
  {
    AppMethodBeat.i(191745);
    this.column = paramString;
    AppMethodBeat.o(191745);
  }
  
  public final String getColumn()
  {
    return this.column;
  }
  
  public String[] params()
  {
    return null;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(191740);
    String str = this.column + " is null";
    AppMethodBeat.o(191740);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.NullCondition
 * JD-Core Version:    0.7.0.1
 */