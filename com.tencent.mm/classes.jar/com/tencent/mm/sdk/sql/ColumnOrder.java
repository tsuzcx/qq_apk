package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ColumnOrder;", "Lcom/tencent/mm/sdk/sql/ISqlOrder;", "column", "", "increase", "", "(Ljava/lang/String;Z)V", "getColumn", "()Ljava/lang/String;", "getIncrease", "()Z", "toSql", "wechat-sdk_release"})
public class ColumnOrder
  implements ISqlOrder
{
  private final String column;
  private final boolean increase;
  
  public ColumnOrder(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(187738);
    this.column = paramString;
    this.increase = paramBoolean;
    AppMethodBeat.o(187738);
  }
  
  public final String getColumn()
  {
    return this.column;
  }
  
  public final boolean getIncrease()
  {
    return this.increase;
  }
  
  public String[] params()
  {
    AppMethodBeat.i(187741);
    String[] arrayOfString = ISqlOrder.DefaultImpls.params(this);
    AppMethodBeat.o(187741);
    return arrayOfString;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(187731);
    StringBuilder localStringBuilder = new StringBuilder().append(this.column);
    if (this.increase) {}
    for (String str = "";; str = " DESC")
    {
      str = str;
      AppMethodBeat.o(187731);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ColumnOrder
 * JD-Core Version:    0.7.0.1
 */