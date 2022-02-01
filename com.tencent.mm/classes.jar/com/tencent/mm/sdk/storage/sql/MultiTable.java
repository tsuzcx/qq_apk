package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/MultiTable;", "Lcom/tencent/mm/sdk/storage/sql/Table;", "table1", "", "table2", "operation", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj$TableJoinOperation;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sdk/storage/sql/ISqlObj$TableJoinOperation;)V", "onCondition", "Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "getOnCondition", "()Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "setOnCondition", "(Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;)V", "getOperation", "()Lcom/tencent/mm/sdk/storage/sql/ISqlObj$TableJoinOperation;", "getTable1", "()Ljava/lang/String;", "getTable2", "on", "condition", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiTable
  extends Table
{
  private ISqlCondition onCondition;
  private final ISqlObj.TableJoinOperation operation;
  private final String table1;
  private final String table2;
  
  public MultiTable(String paramString1, String paramString2, ISqlObj.TableJoinOperation paramTableJoinOperation)
  {
    AppMethodBeat.i(244434);
    this.table1 = paramString1;
    this.table2 = paramString2;
    this.operation = paramTableJoinOperation;
    AppMethodBeat.o(244434);
  }
  
  public final ISqlCondition getOnCondition()
  {
    return this.onCondition;
  }
  
  public final ISqlObj.TableJoinOperation getOperation()
  {
    return this.operation;
  }
  
  public final String getTable1()
  {
    return this.table1;
  }
  
  public final String getTable2()
  {
    return this.table2;
  }
  
  public final MultiTable on(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(244471);
    s.u(paramISqlCondition, "condition");
    this.onCondition = paramISqlCondition;
    AppMethodBeat.o(244471);
    return this;
  }
  
  public final String[] params()
  {
    AppMethodBeat.i(244474);
    Object localObject = this.onCondition;
    if (localObject == null)
    {
      AppMethodBeat.o(244474);
      return null;
    }
    localObject = ((ISqlCondition)localObject).params();
    AppMethodBeat.o(244474);
    return localObject;
  }
  
  public final void setOnCondition(ISqlCondition paramISqlCondition)
  {
    this.onCondition = paramISqlCondition;
  }
  
  public final String toSql()
  {
    AppMethodBeat.i(244460);
    Object localObject1 = this.onCondition;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = this.operation;
      switch (WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      default: 
        localObject1 = new p();
        AppMethodBeat.o(244460);
        throw ((Throwable)localObject1);
        localObject2 = " ON (" + ((ISqlCondition)localObject1).toSql() + ')';
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        break;
      }
    }
    localObject1 = this.table1 + " INNER JOIN " + this.table2 + (String)localObject1;
    AppMethodBeat.o(244460);
    return localObject1;
    localObject1 = this.table1 + " LEFT JOIN " + this.table2 + (String)localObject1;
    AppMethodBeat.o(244460);
    return localObject1;
    localObject1 = this.table1 + " RIGHT JOIN " + this.table2 + (String)localObject1;
    AppMethodBeat.o(244460);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.MultiTable
 * JD-Core Version:    0.7.0.1
 */