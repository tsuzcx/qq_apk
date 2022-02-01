package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Column;", "Lcom/tencent/mm/sdk/storage/sql/ISqlColumn;", "name", "", "dataType", "tableName", "referTo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDataType", "()Ljava/lang/String;", "getName", "getReferTo", "getTableName", "bitAndEqual", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "bitValue", "", "compareValue", "bitAndNotEqual", "count", "Lcom/tencent/mm/sdk/storage/sql/FunctionColumn;", "equal", "value", "", "inNumber", "numberList", "", "inString", "strList", "isNull", "isNullOrEmpty", "largerEqual", "largerThan", "like", "max", "min", "notEqual", "notInNumber", "notInString", "notLike", "orderDesc", "Lcom/tencent/mm/sdk/storage/sql/ISqlOrder;", "orderInc", "smallerEqual", "smallerThan", "tableColumnName", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class Column
  implements ISqlColumn
{
  private final String dataType;
  private final String name;
  private final String referTo;
  private final String tableName;
  
  public Column(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(244281);
    this.name = paramString1;
    this.dataType = paramString2;
    this.tableName = paramString3;
    this.referTo = paramString4;
    AppMethodBeat.o(244281);
  }
  
  public final SingleCondition bitAndEqual(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244459);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.BitAndEqual(tableColumnName(), paramInt1, paramInt2);
    AppMethodBeat.o(244459);
    return localSingleCondition;
  }
  
  public final SingleCondition bitAndNotEqual(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244454);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.BitAndNotEqual(tableColumnName(), paramInt1, paramInt2);
    AppMethodBeat.o(244454);
    return localSingleCondition;
  }
  
  public final FunctionColumn count()
  {
    AppMethodBeat.i(244470);
    FunctionColumn localFunctionColumn = new FunctionColumn(this.name, this.dataType, this.tableName, this.referTo, "count");
    AppMethodBeat.o(244470);
    return localFunctionColumn;
  }
  
  public final SingleCondition equal(Column paramColumn)
  {
    AppMethodBeat.i(244364);
    s.u(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnEqual(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(244364);
    return paramColumn;
  }
  
  public final SingleCondition equal(Number paramNumber)
  {
    AppMethodBeat.i(244351);
    s.u(paramNumber, "value");
    paramNumber = (SingleCondition)new Sql.Equal(tableColumnName(), paramNumber.toString());
    AppMethodBeat.o(244351);
    return paramNumber;
  }
  
  public final SingleCondition equal(String paramString)
  {
    AppMethodBeat.i(244358);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.Equal(tableColumnName(), paramString);
    AppMethodBeat.o(244358);
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
    AppMethodBeat.i(244315);
    s.u(paramList, "numberList");
    String str = tableColumnName();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(((Number)((Iterator)localObject).next()).toString());
    }
    paramList = (SingleCondition)new Sql.In(str, (List)paramList);
    AppMethodBeat.o(244315);
    return paramList;
  }
  
  public final SingleCondition inString(List<String> paramList)
  {
    AppMethodBeat.i(244318);
    s.u(paramList, "strList");
    paramList = (SingleCondition)new Sql.In(tableColumnName(), paramList);
    AppMethodBeat.o(244318);
    return paramList;
  }
  
  public final SingleCondition isNull()
  {
    AppMethodBeat.i(244333);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.Null(tableColumnName());
    AppMethodBeat.o(244333);
    return localSingleCondition;
  }
  
  public final SingleCondition isNullOrEmpty()
  {
    AppMethodBeat.i(244339);
    SingleCondition localSingleCondition = (SingleCondition)new Sql.NullOrEmpty(tableColumnName());
    AppMethodBeat.o(244339);
    return localSingleCondition;
  }
  
  public final SingleCondition largerEqual(Column paramColumn)
  {
    AppMethodBeat.i(244430);
    s.u(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.LargerEqual(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(244430);
    return paramColumn;
  }
  
  public final SingleCondition largerEqual(Number paramNumber)
  {
    AppMethodBeat.i(244420);
    s.u(paramNumber, "value");
    paramNumber = (SingleCondition)new Sql.LargerEqual(tableColumnName(), paramNumber.toString());
    AppMethodBeat.o(244420);
    return paramNumber;
  }
  
  public final SingleCondition largerEqual(String paramString)
  {
    AppMethodBeat.i(244423);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.LargerEqual(tableColumnName(), paramString);
    AppMethodBeat.o(244423);
    return paramString;
  }
  
  public final SingleCondition largerThan(Column paramColumn)
  {
    AppMethodBeat.i(244397);
    s.u(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnLargerThan(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(244397);
    return paramColumn;
  }
  
  public final SingleCondition largerThan(Number paramNumber)
  {
    AppMethodBeat.i(244386);
    s.u(paramNumber, "value");
    paramNumber = (SingleCondition)new Sql.LargerThan(tableColumnName(), paramNumber.toString());
    AppMethodBeat.o(244386);
    return paramNumber;
  }
  
  public final SingleCondition largerThan(String paramString)
  {
    AppMethodBeat.i(244393);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.LargerThan(tableColumnName(), paramString);
    AppMethodBeat.o(244393);
    return paramString;
  }
  
  public final SingleCondition like(String paramString)
  {
    AppMethodBeat.i(244343);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.Like(tableColumnName(), paramString);
    AppMethodBeat.o(244343);
    return paramString;
  }
  
  public final FunctionColumn max()
  {
    AppMethodBeat.i(244476);
    FunctionColumn localFunctionColumn = new FunctionColumn(this.name, this.dataType, this.tableName, this.referTo, "max");
    AppMethodBeat.o(244476);
    return localFunctionColumn;
  }
  
  public final FunctionColumn min()
  {
    AppMethodBeat.i(244472);
    FunctionColumn localFunctionColumn = new FunctionColumn(this.name, this.dataType, this.tableName, this.referTo, "min");
    AppMethodBeat.o(244472);
    return localFunctionColumn;
  }
  
  public final SingleCondition notEqual(Column paramColumn)
  {
    AppMethodBeat.i(244381);
    s.u(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnNotEqual(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(244381);
    return paramColumn;
  }
  
  public final SingleCondition notEqual(Number paramNumber)
  {
    AppMethodBeat.i(244369);
    s.u(paramNumber, "value");
    paramNumber = (SingleCondition)new Sql.NotEqual(tableColumnName(), paramNumber.toString());
    AppMethodBeat.o(244369);
    return paramNumber;
  }
  
  public final SingleCondition notEqual(String paramString)
  {
    AppMethodBeat.i(244375);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.NotEqual(tableColumnName(), paramString);
    AppMethodBeat.o(244375);
    return paramString;
  }
  
  public final SingleCondition notInNumber(List<? extends Number> paramList)
  {
    AppMethodBeat.i(244327);
    s.u(paramList, "numberList");
    String str = tableColumnName();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(((Number)((Iterator)localObject).next()).toString());
    }
    paramList = (SingleCondition)new Sql.NotIn(str, (List)paramList);
    AppMethodBeat.o(244327);
    return paramList;
  }
  
  public final SingleCondition notInString(List<String> paramList)
  {
    AppMethodBeat.i(244330);
    s.u(paramList, "numberList");
    paramList = (SingleCondition)new Sql.NotIn(tableColumnName(), paramList);
    AppMethodBeat.o(244330);
    return paramList;
  }
  
  public final SingleCondition notLike(String paramString)
  {
    AppMethodBeat.i(244346);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.NotLike(tableColumnName(), paramString);
    AppMethodBeat.o(244346);
    return paramString;
  }
  
  public final ISqlOrder orderDesc()
  {
    AppMethodBeat.i(244467);
    ISqlOrder localISqlOrder = (ISqlOrder)new ColumnOrder(tableColumnName(), false);
    AppMethodBeat.o(244467);
    return localISqlOrder;
  }
  
  public final ISqlOrder orderInc()
  {
    AppMethodBeat.i(244464);
    ISqlOrder localISqlOrder = (ISqlOrder)new ColumnOrder(tableColumnName(), true);
    AppMethodBeat.o(244464);
    return localISqlOrder;
  }
  
  public String[] params()
  {
    AppMethodBeat.i(244480);
    String[] arrayOfString = ISqlColumn.DefaultImpls.params((ISqlColumn)this);
    AppMethodBeat.o(244480);
    return arrayOfString;
  }
  
  public final SingleCondition smallerEqual(Column paramColumn)
  {
    AppMethodBeat.i(244447);
    s.u(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.SmallerEqual(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(244447);
    return paramColumn;
  }
  
  public final SingleCondition smallerEqual(Number paramNumber)
  {
    AppMethodBeat.i(244435);
    s.u(paramNumber, "value");
    paramNumber = (SingleCondition)new Sql.SmallerEqual(tableColumnName(), paramNumber.toString());
    AppMethodBeat.o(244435);
    return paramNumber;
  }
  
  public final SingleCondition smallerEqual(String paramString)
  {
    AppMethodBeat.i(244441);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.SmallerEqual(tableColumnName(), paramString);
    AppMethodBeat.o(244441);
    return paramString;
  }
  
  public final SingleCondition smallerThan(Column paramColumn)
  {
    AppMethodBeat.i(244413);
    s.u(paramColumn, "value");
    paramColumn = (SingleCondition)new Sql.ColumnSmallerThan(tableColumnName(), paramColumn.tableColumnName());
    AppMethodBeat.o(244413);
    return paramColumn;
  }
  
  public final SingleCondition smallerThan(Number paramNumber)
  {
    AppMethodBeat.i(244402);
    s.u(paramNumber, "value");
    paramNumber = (SingleCondition)new Sql.SmallerThan(tableColumnName(), paramNumber.toString());
    AppMethodBeat.o(244402);
    return paramNumber;
  }
  
  public final SingleCondition smallerThan(String paramString)
  {
    AppMethodBeat.i(244406);
    s.u(paramString, "value");
    paramString = (SingleCondition)new Sql.SmallerThan(tableColumnName(), paramString);
    AppMethodBeat.o(244406);
    return paramString;
  }
  
  public String tableColumnName()
  {
    AppMethodBeat.i(244305);
    String str = this.tableName + '.' + this.name;
    AppMethodBeat.o(244305);
    return str;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(244478);
    String str = tableColumnName();
    AppMethodBeat.o(244478);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Column
 * JD-Core Version:    0.7.0.1
 */