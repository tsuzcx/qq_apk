package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.ISqlCondition;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/DeleteSql$Builder;", "", "table", "Lcom/tencent/mm/sdk/storage/sql/Table;", "(Lcom/tencent/mm/sdk/storage/sql/Table;)V", "condition", "Lcom/tencent/mm/sdk/sql/ISqlCondition;", "logTag", "", "getTable", "()Lcom/tencent/mm/sdk/storage/sql/Table;", "build", "Lcom/tencent/mm/sdk/storage/sql/DeleteSql;", "log", "tag", "where", "wechat-sdk_release"})
public final class DeleteSql$Builder
{
  private ISqlCondition condition;
  private String logTag;
  private final Table table;
  
  public DeleteSql$Builder(Table paramTable)
  {
    AppMethodBeat.i(193954);
    this.table = paramTable;
    AppMethodBeat.o(193954);
  }
  
  public final DeleteSql build()
  {
    String[] arrayOfString = null;
    AppMethodBeat.i(193951);
    if ((this.table instanceof MultiTable))
    {
      localObject = (Throwable)new IllegalArgumentException("Not support multi table delete");
      AppMethodBeat.o(193951);
      throw ((Throwable)localObject);
    }
    String str = this.table.toSql();
    Object localObject = this.condition;
    if (localObject != null) {}
    for (localObject = ((ISqlCondition)localObject).toSql();; localObject = null)
    {
      ISqlCondition localISqlCondition = this.condition;
      if (localISqlCondition != null) {
        arrayOfString = localISqlCondition.params();
      }
      localObject = new DeleteSql(str, (String)localObject, arrayOfString);
      AppMethodBeat.o(193951);
      return localObject;
    }
  }
  
  public final Table getTable()
  {
    return this.table;
  }
  
  public final Builder log(String paramString)
  {
    AppMethodBeat.i(193947);
    p.k(paramString, "tag");
    this.logTag = paramString;
    AppMethodBeat.o(193947);
    return this;
  }
  
  public final Builder where(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(193950);
    p.k(paramISqlCondition, "condition");
    this.condition = paramISqlCondition;
    AppMethodBeat.o(193950);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.DeleteSql.Builder
 * JD-Core Version:    0.7.0.1
 */