package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/SqlObj;", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj;", "sql", "", "params", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getParams", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSql", "()Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class SqlObj
  implements ISqlObj
{
  private final String[] params;
  private final String sql;
  
  public SqlObj(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(244324);
    this.sql = paramString;
    this.params = paramArrayOfString;
    AppMethodBeat.o(244324);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SqlObj
 * JD-Core Version:    0.7.0.1
 */