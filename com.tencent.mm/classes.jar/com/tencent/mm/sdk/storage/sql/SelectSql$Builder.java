package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.sql.ISqlColumn;
import com.tencent.mm.sdk.sql.ISqlCondition;
import com.tencent.mm.sdk.sql.ISqlOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;", "", "table", "Lcom/tencent/mm/sdk/storage/sql/Table;", "columns", "", "Lcom/tencent/mm/sdk/sql/ISqlColumn;", "(Lcom/tencent/mm/sdk/storage/sql/Table;Ljava/util/List;)V", "getColumns", "()Ljava/util/List;", "condition", "Lcom/tencent/mm/sdk/sql/ISqlCondition;", "limit", "Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder$Limit;", "logTag", "", "orders", "Lcom/tencent/mm/sdk/sql/ISqlOrder;", "getTable", "()Lcom/tencent/mm/sdk/storage/sql/Table;", "build", "Lcom/tencent/mm/sdk/storage/sql/SelectSql;", "", "offset", "log", "tag", "orderBy", "where", "Limit", "wechat-sdk_release"})
public final class SelectSql$Builder
{
  private final List<ISqlColumn> columns;
  private ISqlCondition condition;
  private SelectSql.Builder.Limit limit;
  private String logTag;
  private List<? extends ISqlOrder> orders;
  private final Table table;
  
  public SelectSql$Builder(Table paramTable, List<? extends ISqlColumn> paramList)
  {
    AppMethodBeat.i(187540);
    this.table = paramTable;
    this.columns = paramList;
    AppMethodBeat.o(187540);
  }
  
  public final SelectSql build()
  {
    int j = 0;
    Object localObject5 = null;
    AppMethodBeat.i(187538);
    Object localObject1;
    String str;
    Object localObject2;
    if (this.columns.isEmpty()) {
      if ((this.table instanceof SingleTable))
      {
        localObject1 = "SELECT rowid, *";
        str = " FROM " + this.table.toSql();
        localObject2 = this.condition;
        if (localObject2 != null)
        {
          localObject2 = " WHERE " + ((ISqlCondition)localObject2).toSql();
          if (localObject2 != null) {
            break label550;
          }
        }
        localObject2 = "";
      }
    }
    label130:
    label544:
    label550:
    for (;;)
    {
      Object localObject3 = this.orders;
      int i;
      if (localObject3 != null)
      {
        if (((Collection)localObject3).isEmpty()) {
          break label466;
        }
        i = 1;
        if (i == 0) {
          break label471;
        }
      }
      Object localObject4;
      Object localObject6;
      for (;;)
      {
        if (localObject3 != null)
        {
          localObject4 = " ORDER BY " + j.a((Iterable)localObject3, (CharSequence)", ", null, null, 0, null, (b)build.orderClause.2.1.INSTANCE, 30);
          localObject3 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject3 = "";
        }
        localObject4 = this.limit;
        if (localObject4 != null)
        {
          localObject6 = " LIMIT " + ((SelectSql.Builder.Limit)localObject4).getLimit() + ", " + ((SelectSql.Builder.Limit)localObject4).getOffset();
          localObject4 = localObject6;
          if (localObject6 != null) {}
        }
        else
        {
          localObject4 = "";
        }
        localObject2 = (String)localObject1 + str + (String)localObject2 + (String)localObject3 + (String)localObject4 + ';';
        localObject3 = this.logTag;
        if (localObject3 == null) {
          break label499;
        }
        localObject4 = new StringBuilder("SelectSql.Builder: sql=").append((String)localObject2).append(" params=");
        localObject1 = this.condition;
        if (localObject1 == null) {
          break label544;
        }
        localObject1 = ((ISqlCondition)localObject1).params();
        if (localObject1 == null) {
          break label544;
        }
        localObject6 = (Collection)new ArrayList(localObject1.length);
        int k = localObject1.length;
        i = j;
        while (i < k)
        {
          ((Collection)localObject6).add(localObject1[i]);
          i += 1;
        }
        localObject1 = (Throwable)new IllegalArgumentException("Not support multi table select all");
        AppMethodBeat.o(187538);
        throw ((Throwable)localObject1);
        localObject1 = "SELECT " + j.a((Iterable)this.columns, (CharSequence)", ", null, null, 0, null, (b)build.selectClause.1.INSTANCE, 30);
        break;
        label466:
        i = 0;
        break label130;
        label471:
        localObject3 = null;
      }
      for (localObject1 = (List)localObject6;; localObject1 = null)
      {
        Log.i((String)localObject3, localObject1);
        label499:
        localObject3 = this.condition;
        localObject1 = localObject5;
        if (localObject3 != null) {
          localObject1 = ((ISqlCondition)localObject3).params();
        }
        localObject1 = new SelectSql((String)localObject2, (String[])localObject1);
        AppMethodBeat.o(187538);
        return localObject1;
      }
    }
  }
  
  public final List<ISqlColumn> getColumns()
  {
    return this.columns;
  }
  
  public final Table getTable()
  {
    return this.table;
  }
  
  public final Builder limit(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187534);
    this.limit = new SelectSql.Builder.Limit(paramInt1, paramInt2);
    AppMethodBeat.o(187534);
    return this;
  }
  
  public final Builder log(String paramString)
  {
    AppMethodBeat.i(187529);
    p.k(paramString, "tag");
    this.logTag = paramString;
    AppMethodBeat.o(187529);
    return this;
  }
  
  public final Builder orderBy(List<? extends ISqlOrder> paramList)
  {
    AppMethodBeat.i(187535);
    p.k(paramList, "orders");
    this.orders = paramList;
    AppMethodBeat.o(187535);
    return this;
  }
  
  public final Builder where(ISqlCondition paramISqlCondition)
  {
    this.condition = paramISqlCondition;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SelectSql.Builder
 * JD-Core Version:    0.7.0.1
 */