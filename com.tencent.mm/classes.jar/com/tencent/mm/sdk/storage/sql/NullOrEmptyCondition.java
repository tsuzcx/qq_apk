package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/NullOrEmptyCondition;", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "column", "", "(Ljava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class NullOrEmptyCondition
  extends SingleCondition
{
  private final String column;
  
  public NullOrEmptyCondition(String paramString)
  {
    AppMethodBeat.i(244442);
    this.column = paramString;
    AppMethodBeat.o(244442);
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
    AppMethodBeat.i(244458);
    String str = this.column + " is null OR " + this.column + " = ''";
    AppMethodBeat.o(244458);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.NullOrEmptyCondition
 * JD-Core Version:    0.7.0.1
 */