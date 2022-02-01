package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.ISqlCondition;
import com.tencent.mm.sdk.sql.ISqlObj.TableJoinOperation;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/MultiTable;", "Lcom/tencent/mm/sdk/storage/sql/Table;", "table1", "", "table2", "operation", "Lcom/tencent/mm/sdk/sql/ISqlObj$TableJoinOperation;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sdk/sql/ISqlObj$TableJoinOperation;)V", "onCondition", "Lcom/tencent/mm/sdk/sql/ISqlCondition;", "getOnCondition", "()Lcom/tencent/mm/sdk/sql/ISqlCondition;", "setOnCondition", "(Lcom/tencent/mm/sdk/sql/ISqlCondition;)V", "getOperation", "()Lcom/tencent/mm/sdk/sql/ISqlObj$TableJoinOperation;", "getTable1", "()Ljava/lang/String;", "getTable2", "on", "", "condition", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public final class MultiTable
  extends Table
{
  private ISqlCondition onCondition;
  private final ISqlObj.TableJoinOperation operation;
  private final String table1;
  private final String table2;
  
  public MultiTable(String paramString1, String paramString2, ISqlObj.TableJoinOperation paramTableJoinOperation)
  {
    AppMethodBeat.i(186394);
    this.table1 = paramString1;
    this.table2 = paramString2;
    this.operation = paramTableJoinOperation;
    AppMethodBeat.o(186394);
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
  
  public final void on(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(186387);
    p.k(paramISqlCondition, "condition");
    this.onCondition = paramISqlCondition;
    AppMethodBeat.o(186387);
  }
  
  public final String[] params()
  {
    AppMethodBeat.i(186389);
    Object localObject = this.onCondition;
    if (localObject != null)
    {
      localObject = ((ISqlCondition)localObject).params();
      AppMethodBeat.o(186389);
      return localObject;
    }
    AppMethodBeat.o(186389);
    return null;
  }
  
  public final void setOnCondition(ISqlCondition paramISqlCondition)
  {
    this.onCondition = paramISqlCondition;
  }
  
  public final String toSql()
  {
    AppMethodBeat.i(186383);
    Object localObject1 = this.onCondition;
    if (localObject1 != null)
    {
      localObject2 = " ON (" + ((ISqlCondition)localObject1).toSql() + ')';
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = this.operation;
    switch (MultiTable.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    default: 
      localObject1 = new m();
      AppMethodBeat.o(186383);
      throw ((Throwable)localObject1);
    case 1: 
      localObject1 = this.table1 + " INNER JOIN " + this.table2 + (String)localObject1;
      AppMethodBeat.o(186383);
      return localObject1;
    case 2: 
      localObject1 = this.table1 + " LEFT JOIN " + this.table2 + (String)localObject1;
      AppMethodBeat.o(186383);
      return localObject1;
    }
    localObject1 = this.table1 + " RIGHT JOIN " + this.table2 + (String)localObject1;
    AppMethodBeat.o(186383);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.MultiTable
 * JD-Core Version:    0.7.0.1
 */