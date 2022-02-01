package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/NullOrEmptyCondition;", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "column", "", "(Ljava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public class NullOrEmptyCondition
  extends SingleCondition
{
  private final String column;
  
  public NullOrEmptyCondition(String paramString)
  {
    AppMethodBeat.i(188431);
    this.column = paramString;
    AppMethodBeat.o(188431);
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
    AppMethodBeat.i(188426);
    String str = this.column + " is null OR " + this.column + " = ''";
    AppMethodBeat.o(188426);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.NullOrEmptyCondition
 * JD-Core Version:    0.7.0.1
 */