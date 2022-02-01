package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.ISqlObj.TableJoinOperation;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/SingleTable;", "Lcom/tencent/mm/sdk/storage/sql/Table;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "innerJoin", "Lcom/tencent/mm/sdk/storage/sql/MultiTable;", "singleTable", "leftJoin", "rightJoin", "toSql", "wechat-sdk_release"})
public final class SingleTable
  extends Table
{
  private String name;
  
  public SingleTable(String paramString)
  {
    AppMethodBeat.i(187966);
    this.name = paramString;
    if (p.h(this.name, "Contact"))
    {
      this.name = "RContact";
      AppMethodBeat.o(187966);
      return;
    }
    if (p.h(this.name, "Conversation")) {
      this.name = "RConversation";
    }
    AppMethodBeat.o(187966);
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final MultiTable innerJoin(SingleTable paramSingleTable)
  {
    AppMethodBeat.i(187949);
    p.k(paramSingleTable, "singleTable");
    paramSingleTable = new MultiTable(this.name, paramSingleTable.name, ISqlObj.TableJoinOperation.InnerJoin);
    AppMethodBeat.o(187949);
    return paramSingleTable;
  }
  
  public final MultiTable leftJoin(SingleTable paramSingleTable)
  {
    AppMethodBeat.i(187953);
    p.k(paramSingleTable, "singleTable");
    paramSingleTable = new MultiTable(this.name, paramSingleTable.name, ISqlObj.TableJoinOperation.LeftJoin);
    AppMethodBeat.o(187953);
    return paramSingleTable;
  }
  
  public final MultiTable rightJoin(SingleTable paramSingleTable)
  {
    AppMethodBeat.i(187957);
    p.k(paramSingleTable, "singleTable");
    paramSingleTable = new MultiTable(this.name, paramSingleTable.name, ISqlObj.TableJoinOperation.RightJoin);
    AppMethodBeat.o(187957);
    return paramSingleTable;
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(187961);
    p.k(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(187961);
  }
  
  public final String toSql()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SingleTable
 * JD-Core Version:    0.7.0.1
 */