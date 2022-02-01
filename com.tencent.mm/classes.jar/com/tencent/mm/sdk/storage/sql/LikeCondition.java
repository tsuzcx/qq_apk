package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/LikeCondition;", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "column", "", "isNot", "", "likeValue", "(Ljava/lang/String;ZLjava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "()Z", "getLikeValue", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class LikeCondition
  extends SingleCondition
{
  private final String column;
  private final boolean isNot;
  private final String likeValue;
  
  public LikeCondition(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(244352);
    this.column = paramString1;
    this.isNot = paramBoolean;
    this.likeValue = paramString2;
    AppMethodBeat.o(244352);
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
    return null;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(244378);
    if (this.isNot)
    {
      str = this.column + " NOT LIKE " + this.likeValue;
      AppMethodBeat.o(244378);
      return str;
    }
    String str = this.column + " LIKE " + this.likeValue;
    AppMethodBeat.o(244378);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.LikeCondition
 * JD-Core Version:    0.7.0.1
 */