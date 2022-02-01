package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/SingleTable;", "Lcom/tencent/mm/sdk/storage/sql/Table;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "innerJoin", "Lcom/tencent/mm/sdk/storage/sql/MultiTable;", "singleTable", "leftJoin", "rightJoin", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SingleTable
  extends Table
{
  private String name;
  
  public SingleTable(String paramString)
  {
    AppMethodBeat.i(244292);
    this.name = paramString;
    AppMethodBeat.o(244292);
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final MultiTable innerJoin(SingleTable paramSingleTable)
  {
    AppMethodBeat.i(244302);
    s.u(paramSingleTable, "singleTable");
    paramSingleTable = new MultiTable(this.name, paramSingleTable.name, ISqlObj.TableJoinOperation.InnerJoin);
    AppMethodBeat.o(244302);
    return paramSingleTable;
  }
  
  public final MultiTable leftJoin(SingleTable paramSingleTable)
  {
    AppMethodBeat.i(244308);
    s.u(paramSingleTable, "singleTable");
    paramSingleTable = new MultiTable(this.name, paramSingleTable.name, ISqlObj.TableJoinOperation.LeftJoin);
    AppMethodBeat.o(244308);
    return paramSingleTable;
  }
  
  public final MultiTable rightJoin(SingleTable paramSingleTable)
  {
    AppMethodBeat.i(244314);
    s.u(paramSingleTable, "singleTable");
    paramSingleTable = new MultiTable(this.name, paramSingleTable.name, ISqlObj.TableJoinOperation.RightJoin);
    AppMethodBeat.o(244314);
    return paramSingleTable;
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(244296);
    s.u(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(244296);
  }
  
  public final String toSql()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SingleTable
 * JD-Core Version:    0.7.0.1
 */