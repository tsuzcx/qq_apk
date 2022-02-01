package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/SqlObj;", "Lcom/tencent/mm/sdk/sql/ISqlObj;", "sql", "", "params", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getParams", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSql", "()Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public class SqlObj
  implements ISqlObj
{
  private final String[] params;
  private final String sql;
  
  public SqlObj(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(187475);
    this.sql = paramString;
    this.params = paramArrayOfString;
    AppMethodBeat.o(187475);
  }
  
  public final String[] getParams()
  {
    return this.params;
  }
  
  public final String getSql()
  {
    return this.sql;
  }
  
  public String[] params()
  {
    return this.params;
  }
  
  public String toSql()
  {
    return this.sql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.SqlObj
 * JD-Core Version:    0.7.0.1
 */