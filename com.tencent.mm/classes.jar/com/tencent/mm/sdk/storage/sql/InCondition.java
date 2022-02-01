package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/InCondition;", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "column", "", "isNot", "", "values", "", "(Ljava/lang/String;ZLjava/util/List;)V", "getColumn", "()Ljava/lang/String;", "()Z", "questionMarks", "getQuestionMarks", "()Ljava/util/List;", "getValues", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class InCondition
  extends SingleCondition
{
  private final String column;
  private final boolean isNot;
  private final List<String> questionMarks;
  private final List<String> values;
  
  public InCondition(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(244353);
    this.column = paramString;
    this.isNot = paramBoolean;
    this.values = paramList;
    paramList = (Iterable)this.values;
    paramString = (Collection)new ArrayList(p.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramList.next();
      paramString.add("?");
    }
    this.questionMarks = ((List)paramString);
    AppMethodBeat.o(244353);
  }
  
  public final String getColumn()
  {
    return this.column;
  }
  
  public final List<String> getQuestionMarks()
  {
    return this.questionMarks;
  }
  
  public final List<String> getValues()
  {
    return this.values;
  }
  
  public final boolean isNot()
  {
    return this.isNot;
  }
  
  public String[] params()
  {
    AppMethodBeat.i(244389);
    Object localObject = ((Collection)this.values).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(244389);
      throw ((Throwable)localObject);
    }
    localObject = (String[])localObject;
    AppMethodBeat.o(244389);
    return localObject;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(244383);
    String str = p.a((Iterable)this.questionMarks, (CharSequence)",", null, null, 0, null, null, 62);
    if (this.isNot)
    {
      str = this.column + " NOT IN (" + str + ')';
      AppMethodBeat.o(244383);
      return str;
    }
    str = this.column + " IN (" + str + ')';
    AppMethodBeat.o(244383);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.InCondition
 * JD-Core Version:    0.7.0.1
 */