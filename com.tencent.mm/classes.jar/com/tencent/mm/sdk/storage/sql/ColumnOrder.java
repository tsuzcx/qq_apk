package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ColumnOrder;", "Lcom/tencent/mm/sdk/storage/sql/ISqlOrder;", "column", "", "increase", "", "(Ljava/lang/String;Z)V", "getColumn", "()Ljava/lang/String;", "getIncrease", "()Z", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ColumnOrder
  implements ISqlOrder
{
  private final String column;
  private final boolean increase;
  
  public ColumnOrder(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(244320);
    this.column = paramString;
    this.increase = paramBoolean;
    AppMethodBeat.o(244320);
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
    AppMethodBeat.i(244342);
    String[] arrayOfString = ISqlOrder.DefaultImpls.params((ISqlOrder)this);
    AppMethodBeat.o(244342);
    return arrayOfString;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(244337);
    String str2 = this.column;
    if (this.increase) {}
    for (String str1 = "";; str1 = " DESC")
    {
      str1 = s.X(str2, str1);
      AppMethodBeat.o(244337);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ColumnOrder
 * JD-Core Version:    0.7.0.1
 */