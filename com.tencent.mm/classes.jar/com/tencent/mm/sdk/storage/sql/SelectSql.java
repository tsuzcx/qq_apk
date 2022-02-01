package com.tencent.mm.sdk.storage.sql;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/SelectSql;", "Lcom/tencent/mm/sdk/storage/sql/SqlObj;", "sql", "", "params", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "isExist", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "multiQuery", "", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "creator", "Lkotlin/Function1;", "Landroid/database/Cursor;", "Lkotlin/ParameterName;", "name", "cursor", "clazz", "Ljava/lang/Class;", "singleQuery", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lkotlin/jvm/functions/Function1;)Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Ljava/lang/Class;)Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Builder", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SelectSql
  extends SqlObj
{
  public SelectSql(String paramString, String[] paramArrayOfString)
  {
    super(paramString, paramArrayOfString);
    AppMethodBeat.i(244444);
    AppMethodBeat.o(244444);
  }
  
  public final boolean isExist(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(244473);
    if (paramISQLiteDatabase != null)
    {
      paramISQLiteDatabase = paramISQLiteDatabase.rawQuery(toSql(), params());
      if (paramISQLiteDatabase != null)
      {
        paramISQLiteDatabase = (Closeable)paramISQLiteDatabase;
        try
        {
          boolean bool = ((Cursor)paramISQLiteDatabase).moveToFirst();
          kotlin.f.b.a(paramISQLiteDatabase, null);
          AppMethodBeat.o(244473);
          return bool;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(244473);
            throw localThrowable;
          }
          finally
          {
            kotlin.f.b.a(paramISQLiteDatabase, localThrowable);
            AppMethodBeat.o(244473);
          }
        }
      }
    }
    AppMethodBeat.o(244473);
    return false;
  }
  
  public final <T extends IAutoDBItem> List<T> multiQuery(ISQLiteDatabase paramISQLiteDatabase, Class<T> paramClass)
  {
    AppMethodBeat.i(244462);
    s.u(paramClass, "clazz");
    ArrayList localArrayList = new ArrayList();
    if (paramISQLiteDatabase != null)
    {
      paramISQLiteDatabase = paramISQLiteDatabase.rawQuery(toSql(), params());
      if (paramISQLiteDatabase != null)
      {
        paramISQLiteDatabase = (Closeable)paramISQLiteDatabase;
        try
        {
          Cursor localCursor = (Cursor)paramISQLiteDatabase;
          while (localCursor.moveToNext())
          {
            IAutoDBItem localIAutoDBItem = (IAutoDBItem)paramClass.newInstance();
            localIAutoDBItem.convertFrom(localCursor);
            localArrayList.add(localIAutoDBItem);
          }
          paramISQLiteDatabase = (List)localObject;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(244462);
            throw paramClass;
          }
          finally
          {
            kotlin.f.b.a(paramISQLiteDatabase, paramClass);
            AppMethodBeat.o(244462);
          }
          paramClass = ah.aiuX;
          kotlin.f.b.a(paramISQLiteDatabase, null);
        }
      }
    }
    AppMethodBeat.o(244462);
    return paramISQLiteDatabase;
  }
  
  public final <T extends IAutoDBItem> List<T> multiQuery(ISQLiteDatabase paramISQLiteDatabase, kotlin.g.a.b<? super Cursor, ? extends T> paramb)
  {
    AppMethodBeat.i(244469);
    s.u(paramb, "creator");
    ArrayList localArrayList = new ArrayList();
    if (paramISQLiteDatabase != null)
    {
      paramISQLiteDatabase = paramISQLiteDatabase.rawQuery(toSql(), params());
      if (paramISQLiteDatabase != null)
      {
        paramISQLiteDatabase = (Closeable)paramISQLiteDatabase;
        try
        {
          Cursor localCursor = (Cursor)paramISQLiteDatabase;
          while (localCursor.moveToNext()) {
            localArrayList.add(paramb.invoke(localCursor));
          }
          paramISQLiteDatabase = (List)localObject;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(244469);
            throw paramb;
          }
          finally
          {
            kotlin.f.b.a(paramISQLiteDatabase, paramb);
            AppMethodBeat.o(244469);
          }
          paramb = ah.aiuX;
          kotlin.f.b.a(paramISQLiteDatabase, null);
        }
      }
    }
    AppMethodBeat.o(244469);
    return paramISQLiteDatabase;
  }
  
  public final <T extends IAutoDBItem> T singleQuery(ISQLiteDatabase paramISQLiteDatabase, Class<T> paramClass)
  {
    AppMethodBeat.i(244453);
    s.u(paramClass, "clazz");
    if (paramISQLiteDatabase != null)
    {
      paramISQLiteDatabase = paramISQLiteDatabase.rawQuery(toSql(), params());
      if (paramISQLiteDatabase != null) {
        paramISQLiteDatabase = (Closeable)paramISQLiteDatabase;
      }
    }
    try
    {
      Cursor localCursor = (Cursor)paramISQLiteDatabase;
      paramClass = (IAutoDBItem)paramClass.newInstance();
      if (localCursor.moveToNext())
      {
        paramClass.convertFrom(localCursor);
        kotlin.f.b.a(paramISQLiteDatabase, null);
        AppMethodBeat.o(244453);
        return paramClass;
      }
      paramClass = ah.aiuX;
      kotlin.f.b.a(paramISQLiteDatabase, null);
      AppMethodBeat.o(244453);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(244453);
        throw paramClass;
      }
      finally
      {
        kotlin.f.b.a(paramISQLiteDatabase, paramClass);
        AppMethodBeat.o(244453);
      }
    }
  }
  
  public final <T extends IAutoDBItem> T singleQuery(ISQLiteDatabase paramISQLiteDatabase, kotlin.g.a.b<? super Cursor, ? extends T> paramb)
  {
    AppMethodBeat.i(244466);
    s.u(paramb, "creator");
    if (paramISQLiteDatabase != null)
    {
      paramISQLiteDatabase = paramISQLiteDatabase.rawQuery(toSql(), params());
      if (paramISQLiteDatabase != null) {
        paramISQLiteDatabase = (Closeable)paramISQLiteDatabase;
      }
    }
    try
    {
      Cursor localCursor = (Cursor)paramISQLiteDatabase;
      if (localCursor.moveToNext())
      {
        paramb = (IAutoDBItem)paramb.invoke(localCursor);
        kotlin.f.b.a(paramISQLiteDatabase, null);
        AppMethodBeat.o(244466);
        return paramb;
      }
      paramb = ah.aiuX;
      kotlin.f.b.a(paramISQLiteDatabase, null);
      AppMethodBeat.o(244466);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(244466);
        throw paramb;
      }
      finally
      {
        kotlin.f.b.a(paramISQLiteDatabase, paramb);
        AppMethodBeat.o(244466);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;", "", "table", "Lcom/tencent/mm/sdk/storage/sql/Table;", "columns", "", "Lcom/tencent/mm/sdk/storage/sql/ISqlColumn;", "(Lcom/tencent/mm/sdk/storage/sql/Table;Ljava/util/List;)V", "getColumns", "()Ljava/util/List;", "condition", "Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "groupBy", "Lcom/tencent/mm/sdk/storage/sql/Column;", "limit", "Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder$Limit;", "logTag", "", "orders", "Lcom/tencent/mm/sdk/storage/sql/ISqlOrder;", "getTable", "()Lcom/tencent/mm/sdk/storage/sql/Table;", "build", "Lcom/tencent/mm/sdk/storage/sql/SelectSql;", "column", "groupByColumns", "", "offset", "log", "tag", "orderBy", "order", "where", "Limit", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Builder
  {
    private final List<ISqlColumn> columns;
    private ISqlCondition condition;
    private List<? extends Column> groupBy;
    private SelectSql.Builder.Limit limit;
    private String logTag;
    private List<? extends ISqlOrder> orders;
    private final Table table;
    
    public Builder(Table paramTable, List<? extends ISqlColumn> paramList)
    {
      AppMethodBeat.i(244338);
      this.table = paramTable;
      this.columns = paramList;
      AppMethodBeat.o(244338);
    }
    
    public final SelectSql build()
    {
      int j = 0;
      Object localObject6 = null;
      AppMethodBeat.i(244407);
      String str1;
      label64:
      Object localObject2;
      label73:
      label87:
      Object localObject3;
      label96:
      label110:
      Object localObject4;
      if (this.columns.isEmpty()) {
        if ((this.table instanceof SingleTable))
        {
          str1 = "SELECT rowid, *";
          String str2 = s.X(" FROM ", this.table.toSql());
          localObject1 = this.condition;
          if (localObject1 != null) {
            break label350;
          }
          localObject1 = null;
          if (localObject1 != null) {
            break label367;
          }
          localObject2 = "";
          localObject1 = this.groupBy;
          if (localObject1 != null) {
            break label374;
          }
          localObject1 = null;
          if (localObject1 != null) {
            break label450;
          }
          localObject3 = "";
          localObject1 = this.orders;
          if (localObject1 != null) {
            break label457;
          }
          localObject1 = null;
          localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = "";
          }
          localObject1 = this.limit;
          if (localObject1 != null) {
            break label533;
          }
          localObject1 = null;
          label137:
          Object localObject5 = localObject1;
          if (localObject1 == null) {
            localObject5 = "";
          }
          str1 = str1 + str2 + (String)localObject2 + (String)localObject3 + (String)localObject4 + (String)localObject5 + ';';
          localObject2 = this.logTag;
          if (localObject2 != null)
          {
            localObject3 = new StringBuilder("SelectSql.Builder: sql=").append(str1).append(" params=");
            localObject1 = this.condition;
            if (localObject1 != null) {
              break label571;
            }
            localObject1 = null;
            label243:
            Log.i((String)localObject2, localObject1);
          }
          localObject1 = this.condition;
          if (localObject1 != null) {
            break label646;
          }
        }
      }
      label389:
      label646:
      for (Object localObject1 = localObject6;; localObject1 = ((ISqlCondition)localObject1).params())
      {
        localObject1 = new SelectSql(str1, (String[])localObject1);
        AppMethodBeat.o(244407);
        return localObject1;
        localObject1 = new IllegalArgumentException("Not support multi table select all");
        AppMethodBeat.o(244407);
        throw ((Throwable)localObject1);
        str1 = s.X("SELECT ", p.a((Iterable)this.columns, (CharSequence)", ", null, null, 0, null, (kotlin.g.a.b)build.selectClause.1.INSTANCE, 30));
        break;
        label350:
        localObject1 = s.X(" WHERE ", ((ISqlCondition)localObject1).toSql());
        break label64;
        label367:
        localObject2 = localObject1;
        break label73;
        label374:
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label409;
          }
        }
        for (;;)
        {
          if (localObject1 != null) {
            break label415;
          }
          localObject1 = null;
          break;
          i = 0;
          break label389;
          label409:
          localObject1 = null;
        }
        label415:
        localObject1 = s.X(" GROUP BY ", p.a((Iterable)localObject1, (CharSequence)", ", null, null, 0, null, (kotlin.g.a.b)build.groupByClause.2.1.INSTANCE, 30));
        break label87;
        label450:
        localObject3 = localObject1;
        break label96;
        label457:
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          label472:
          if (i == 0) {
            break label492;
          }
        }
        for (;;)
        {
          if (localObject1 != null) {
            break label498;
          }
          localObject1 = null;
          break;
          i = 0;
          break label472;
          label492:
          localObject1 = null;
        }
        label498:
        localObject1 = s.X(" ORDER BY ", p.a((Iterable)localObject1, (CharSequence)", ", null, null, 0, null, (kotlin.g.a.b)build.orderClause.2.1.INSTANCE, 30));
        break label110;
        label533:
        localObject1 = " LIMIT " + ((SelectSql.Builder.Limit)localObject1).getLimit() + " OFFSET " + ((SelectSql.Builder.Limit)localObject1).getOffset();
        break label137;
        label571:
        localObject1 = ((ISqlCondition)localObject1).params();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label243;
        }
        localObject4 = (Collection)new ArrayList(localObject1.length);
        int k = localObject1.length;
        int i = j;
        while (i < k)
        {
          ((Collection)localObject4).add(localObject1[i]);
          i += 1;
        }
        localObject1 = (List)localObject4;
        break label243;
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
    
    public final Builder groupBy(Column paramColumn)
    {
      AppMethodBeat.i(244388);
      s.u(paramColumn, "column");
      this.groupBy = p.listOf(paramColumn);
      AppMethodBeat.o(244388);
      return this;
    }
    
    public final Builder groupBy(List<? extends Column> paramList)
    {
      AppMethodBeat.i(244382);
      s.u(paramList, "groupByColumns");
      this.groupBy = paramList;
      AppMethodBeat.o(244382);
      return this;
    }
    
    public final Builder limit(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244362);
      this.limit = new SelectSql.Builder.Limit(paramInt1, paramInt2);
      AppMethodBeat.o(244362);
      return this;
    }
    
    public final Builder log(String paramString)
    {
      AppMethodBeat.i(244349);
      s.u(paramString, "tag");
      this.logTag = paramString;
      AppMethodBeat.o(244349);
      return this;
    }
    
    public final Builder orderBy(ISqlOrder paramISqlOrder)
    {
      AppMethodBeat.i(244374);
      s.u(paramISqlOrder, "order");
      this.orders = p.listOf(paramISqlOrder);
      AppMethodBeat.o(244374);
      return this;
    }
    
    public final Builder orderBy(List<? extends ISqlOrder> paramList)
    {
      AppMethodBeat.i(244367);
      s.u(paramList, "orders");
      this.orders = paramList;
      AppMethodBeat.o(244367);
      return this;
    }
    
    public final Builder where(ISqlCondition paramISqlCondition)
    {
      this.condition = paramISqlCondition;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SelectSql
 * JD-Core Version:    0.7.0.1
 */