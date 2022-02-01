package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.ColumnOrder;
import com.tencent.mm.sdk.sql.ISqlColumn;
import com.tencent.mm.sdk.sql.ISqlColumn.DefaultImpls;
import com.tencent.mm.sdk.sql.ISqlOrder;
import com.tencent.mm.sdk.sql.SingleCondition;
import com.tencent.mm.sdk.sql.Sql.BitAndEqual;
import com.tencent.mm.sdk.sql.Sql.BitAndNotEqual;
import com.tencent.mm.sdk.sql.Sql.ColumnEqual;
import com.tencent.mm.sdk.sql.Sql.ColumnLargerThan;
import com.tencent.mm.sdk.sql.Sql.ColumnNotEqual;
import com.tencent.mm.sdk.sql.Sql.ColumnSmallerThan;
import com.tencent.mm.sdk.sql.Sql.Equal;
import com.tencent.mm.sdk.sql.Sql.In;
import com.tencent.mm.sdk.sql.Sql.LargerEqual;
import com.tencent.mm.sdk.sql.Sql.LargerThan;
import com.tencent.mm.sdk.sql.Sql.Like;
import com.tencent.mm.sdk.sql.Sql.NotEqual;
import com.tencent.mm.sdk.sql.Sql.NotIn;
import com.tencent.mm.sdk.sql.Sql.NotLike;
import com.tencent.mm.sdk.sql.Sql.Null;
import com.tencent.mm.sdk.sql.Sql.NullOrEmpty;
import com.tencent.mm.sdk.sql.Sql.SmallerEqual;
import com.tencent.mm.sdk.sql.Sql.SmallerThan;
import com.tencent.mm.sdk.sql.Sql.StringIn;
import com.tencent.mm.sdk.sql.Sql.StringNotIn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/Column;", "Lcom/tencent/mm/sdk/sql/ISqlColumn;", "name", "", "dataType", "tableName", "referTo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDataType", "()Ljava/lang/String;", "getName", "getReferTo", "getTableName", "setTableName", "(Ljava/lang/String;)V", "bitAndEqual", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "bitValue", "", "compareValue", "bitAndNotEqual", "count", "Lcom/tencent/mm/sdk/storage/sql/FunctionColumn;", "equal", "value", "inNumber", "numberList", "", "", "inString", "strList", "isNull", "isNullOrEmpty", "largerEqual", "largerThan", "like", "notEqual", "notInNumber", "notInString", "notLike", "orderDesc", "Lcom/tencent/mm/sdk/sql/ISqlOrder;", "orderInc", "smallerEqual", "smallerThan", "tableColumnName", "toSql", "wechat-sdk_release"})
public class Column
  implements ISqlColumn
{
  private final String dataType;
  private final String name;
  private final String referTo;
  private String tableName;
  
  public Column(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(186833);
    this.name = paramString1;
    this.dataType = paramString2;
    this.tableName = paramString3;
    this.referTo = paramString4;
    if (p.h(this.tableName, "Contact"))
    {
      this.tableName = "RContact";
      AppMethodBeat.o(186833);
      return;
    }
    if (p.h(this.tableName, "Conversation")) {
      this.tableName = "RConversation";
    }
    AppMethodBeat.o(186833);
  }
  
  public final SingleCondition bitAndEqual(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186802);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.BitAndEqual(tableColumnName(), paramInt1, paramInt2);
    AppMethodBeat.o(186802);
    return localSingleCondition;
  }
  
  public final SingleCondition bitAndNotEqual(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186800);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.BitAndNotEqual(tableColumnName(), paramInt1, paramInt2);
    AppMethodBeat.o(186800);
    return localSingleCondition;
  }
  
  public final FunctionColumn count()
  {
    AppMethodBeat.i(186817);
    FunctionColumn localFunctionColumn = new FunctionColumn(this.name, this.dataType, this.tableName, this.referTo, "count");
    AppMethodBeat.o(186817);
    return localFunctionColumn;
  }
  
  public final SingleCondition equal(Column paramColumn)
  {
    AppMethodBeat.i(186785);
    p.k(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnEqual(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(186785);
    return paramColumn;
  }
  
  public final SingleCondition equal(String paramString)
  {
    AppMethodBeat.i(186784);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.Equal(tableColumnName(), paramString);
    AppMethodBeat.o(186784);
    return paramString;
  }
  
  public final String getDataType()
  {
    return this.dataType;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final String getReferTo()
  {
    return this.referTo;
  }
  
  public final String getTableName()
  {
    return this.tableName;
  }
  
  public final SingleCondition inNumber(List<? extends Number> paramList)
  {
    AppMethodBeat.i(186767);
    p.k(paramList, "numberList");
    String str = tableColumnName();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(((Number)((Iterator)localObject).next()).toString());
    }
    paramList = (SingleCondition)new Sql.In(str, (List)paramList);
    AppMethodBeat.o(186767);
    return paramList;
  }
  
  public final SingleCondition inString(List<String> paramList)
  {
    AppMethodBeat.i(186769);
    p.k(paramList, "strList");
    paramList = (SingleCondition)new Sql.StringIn(tableColumnName(), paramList);
    AppMethodBeat.o(186769);
    return paramList;
  }
  
  public final SingleCondition isNull()
  {
    AppMethodBeat.i(186772);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.Null(tableColumnName());
    AppMethodBeat.o(186772);
    return localSingleCondition;
  }
  
  public final SingleCondition isNullOrEmpty()
  {
    AppMethodBeat.i(186773);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.NullOrEmpty(tableColumnName());
    AppMethodBeat.o(186773);
    return localSingleCondition;
  }
  
  public final SingleCondition largerEqual(String paramString)
  {
    AppMethodBeat.i(186797);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.LargerEqual(tableColumnName(), paramString);
    AppMethodBeat.o(186797);
    return paramString;
  }
  
  public final SingleCondition largerThan(Column paramColumn)
  {
    AppMethodBeat.i(186791);
    p.k(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnLargerThan(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(186791);
    return paramColumn;
  }
  
  public final SingleCondition largerThan(String paramString)
  {
    AppMethodBeat.i(186789);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.LargerThan(tableColumnName(), paramString);
    AppMethodBeat.o(186789);
    return paramString;
  }
  
  public final SingleCondition like(String paramString)
  {
    AppMethodBeat.i(186775);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.Like(tableColumnName(), paramString);
    AppMethodBeat.o(186775);
    return paramString;
  }
  
  public final SingleCondition notEqual(Column paramColumn)
  {
    AppMethodBeat.i(186788);
    p.k(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnNotEqual(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(186788);
    return paramColumn;
  }
  
  public final SingleCondition notEqual(String paramString)
  {
    AppMethodBeat.i(186787);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.NotEqual(tableColumnName(), paramString);
    AppMethodBeat.o(186787);
    return paramString;
  }
  
  public final SingleCondition notInNumber(List<? extends Number> paramList)
  {
    AppMethodBeat.i(186770);
    p.k(paramList, "numberList");
    String str = tableColumnName();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(((Number)((Iterator)localObject).next()).toString());
    }
    paramList = (SingleCondition)new Sql.NotIn(str, (List)paramList);
    AppMethodBeat.o(186770);
    return paramList;
  }
  
  public final SingleCondition notInString(List<String> paramList)
  {
    AppMethodBeat.i(186771);
    p.k(paramList, "numberList");
    paramList = (SingleCondition)new Sql.StringNotIn(tableColumnName(), paramList);
    AppMethodBeat.o(186771);
    return paramList;
  }
  
  public final SingleCondition notLike(String paramString)
  {
    AppMethodBeat.i(186777);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.NotLike(tableColumnName(), paramString);
    AppMethodBeat.o(186777);
    return paramString;
  }
  
  public final ISqlOrder orderDesc()
  {
    AppMethodBeat.i(186810);
    ISqlOrder localISqlOrder = (ISqlOrder)new ColumnOrder(tableColumnName(), false);
    AppMethodBeat.o(186810);
    return localISqlOrder;
  }
  
  public final ISqlOrder orderInc()
  {
    AppMethodBeat.i(186808);
    ISqlOrder localISqlOrder = (ISqlOrder)new ColumnOrder(tableColumnName(), true);
    AppMethodBeat.o(186808);
    return localISqlOrder;
  }
  
  public String[] params()
  {
    AppMethodBeat.i(186836);
    String[] arrayOfString = ISqlColumn.DefaultImpls.params(this);
    AppMethodBeat.o(186836);
    return arrayOfString;
  }
  
  public final void setTableName(String paramString)
  {
    AppMethodBeat.i(186828);
    p.k(paramString, "<set-?>");
    this.tableName = paramString;
    AppMethodBeat.o(186828);
  }
  
  public final SingleCondition smallerEqual(String paramString)
  {
    AppMethodBeat.i(186799);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.SmallerEqual(tableColumnName(), paramString);
    AppMethodBeat.o(186799);
    return paramString;
  }
  
  public final SingleCondition smallerThan(Column paramColumn)
  {
    AppMethodBeat.i(186796);
    p.k(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnSmallerThan(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(186796);
    return paramColumn;
  }
  
  public final SingleCondition smallerThan(String paramString)
  {
    AppMethodBeat.i(186795);
    p.k(paramString, "value");
    paramString = (SingleCondition)new Sql.SmallerThan(tableColumnName(), paramString);
    AppMethodBeat.o(186795);
    return paramString;
  }
  
  public String tableColumnName()
  {
    AppMethodBeat.i(186765);
    String str = this.tableName + '.' + this.name;
    AppMethodBeat.o(186765);
    return str;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(186822);
    String str = tableColumnName();
    AppMethodBeat.o(186822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Column
 * JD-Core Version:    0.7.0.1
 */