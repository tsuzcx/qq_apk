package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/LikeCondition;", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "column", "", "isNot", "", "likeValue", "(Ljava/lang/String;ZLjava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "()Z", "getLikeValue", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public class LikeCondition
  extends SingleCondition
{
  private final String column;
  private final boolean isNot;
  private final String likeValue;
  
  public LikeCondition(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(192166);
    this.column = paramString1;
    this.isNot = paramBoolean;
    this.likeValue = paramString2;
    AppMethodBeat.o(192166);
  }
  
  public final String getColumn()
  {
    return this.column;
  }
  
  public final String getLikeValue()
  {
    return this.likeValue;
  }
  
  public final boolean isNot()
  {
    return this.isNot;
  }
  
  public String[] params()
  {
    AppMethodBeat.i(192154);
    AppMethodBeat.o(192154);
    return null;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(192151);
    if (this.isNot)
    {
      str = this.column + " NOT LIKE " + this.likeValue;
      AppMethodBeat.o(192151);
      return str;
    }
    String str = this.column + " LIKE " + this.likeValue;
    AppMethodBeat.o(192151);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.LikeCondition
 * JD-Core Version:    0.7.0.1
 */