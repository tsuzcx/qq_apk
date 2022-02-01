package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/NullCondition;", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "column", "", "(Ljava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class NullCondition
  extends SingleCondition
{
  private final String column;
  
  public NullCondition(String paramString)
  {
    AppMethodBeat.i(244433);
    this.column = paramString;
    AppMethodBeat.o(244433);
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
    AppMethodBeat.i(244445);
    String str = s.X(this.column, " is null");
    AppMethodBeat.o(244445);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.NullCondition
 * JD-Core Version:    0.7.0.1
 */