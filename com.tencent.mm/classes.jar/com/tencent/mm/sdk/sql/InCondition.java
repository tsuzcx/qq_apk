package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/InCondition;", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "column", "", "isNot", "", "isStringType", "values", "", "(Ljava/lang/String;ZZLjava/util/List;)V", "getColumn", "()Ljava/lang/String;", "()Z", "getValues", "()Ljava/util/List;", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public class InCondition
  extends SingleCondition
{
  private final String column;
  private final boolean isNot;
  private final boolean isStringType;
  private final List<String> values;
  
  public InCondition(String paramString, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList)
  {
    AppMethodBeat.i(186852);
    this.column = paramString;
    this.isNot = paramBoolean1;
    this.isStringType = paramBoolean2;
    this.values = paramList;
    AppMethodBeat.o(186852);
  }
  
  public final String getColumn()
  {
    return this.column;
  }
  
  public final List<String> getValues()
  {
    return this.values;
  }
  
  public final boolean isNot()
  {
    return this.isNot;
  }
  
  public final boolean isStringType()
  {
    return this.isStringType;
  }
  
  public String[] params()
  {
    return null;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(186845);
    CharSequence localCharSequence;
    if (this.isStringType)
    {
      localObject = (Iterable)this.values;
      localCharSequence = (CharSequence)"'";
    }
    for (Object localObject = j.a((Iterable)localObject, (CharSequence)"','", localCharSequence, (CharSequence)"'", 0, null, null, 56); this.isNot; localObject = j.a((Iterable)this.values, (CharSequence)",", null, null, 0, null, null, 62))
    {
      localObject = this.column + " NOT IN (" + (String)localObject + ')';
      AppMethodBeat.o(186845);
      return localObject;
    }
    localObject = this.column + " IN (" + (String)localObject + ')';
    AppMethodBeat.o(186845);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.InCondition
 * JD-Core Version:    0.7.0.1
 */