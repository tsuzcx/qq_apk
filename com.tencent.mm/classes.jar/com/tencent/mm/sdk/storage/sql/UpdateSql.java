package com.tencent.mm.sdk.storage.sql;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/UpdateSql;", "Lcom/tencent/mm/sdk/storage/sql/SqlObj;", "table", "", "values", "Landroid/content/ContentValues;", "whereSql", "params", "", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V", "getTable", "()Ljava/lang/String;", "getValues", "()Landroid/content/ContentValues;", "getWhereSql", "run", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "toSql", "Builder", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UpdateSql
  extends SqlObj
{
  private final String table;
  private final ContentValues values;
  private final String whereSql;
  
  public UpdateSql(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    super("", paramArrayOfString);
    AppMethodBeat.i(244370);
    this.table = paramString1;
    this.values = paramContentValues;
    this.whereSql = paramString2;
    AppMethodBeat.o(244370);
  }
  
  public final String getTable()
  {
    return this.table;
  }
  
  public final ContentValues getValues()
  {
    return this.values;
  }
  
  public final String getWhereSql()
  {
    return this.whereSql;
  }
  
  public final int run(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(244428);
    if (paramISQLiteDatabase == null)
    {
      AppMethodBeat.o(244428);
      return -1;
    }
    int i = paramISQLiteDatabase.update(this.table, this.values, this.whereSql, params());
    AppMethodBeat.o(244428);
    return i;
  }
  
  public final String toSql()
  {
    int i = 0;
    AppMethodBeat.i(244416);
    Object localObject1 = this.values.keySet();
    s.s(localObject1, "values.keySet()");
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    Object localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = (String)((Iterator)localObject3).next();
      Object localObject4 = getValues().get((String)localObject1);
      if ((localObject4 instanceof Number)) {}
      for (localObject1 = localObject1 + " = " + localObject4;; localObject1 = localObject1 + " = '" + localObject4 + '\'')
      {
        ((Collection)localObject2).add(localObject1);
        break;
      }
    }
    localObject3 = p.a((Iterable)localObject2, (CharSequence)", ", null, null, 0, null, null, 62);
    localObject1 = this.whereSql;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = "UPDATE " + this.table + " SET " + (String)localObject3 + (String)localObject2;
      AppMethodBeat.o(244416);
      return localObject1;
      if (!n.bp((CharSequence)localObject1)) {
        i = 1;
      }
      if (i != 0) {}
      for (;;)
      {
        if (localObject1 != null) {
          break label274;
        }
        localObject1 = null;
        break;
        localObject1 = null;
      }
      label274:
      localObject1 = s.X(" WHERE ", getWhereSql());
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/UpdateSql$Builder;", "", "table", "Lcom/tencent/mm/sdk/storage/sql/Table;", "values", "Landroid/content/ContentValues;", "(Lcom/tencent/mm/sdk/storage/sql/Table;Landroid/content/ContentValues;)V", "condition", "Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "getTable", "()Lcom/tencent/mm/sdk/storage/sql/Table;", "getValues", "()Landroid/content/ContentValues;", "build", "Lcom/tencent/mm/sdk/storage/sql/UpdateSql;", "where", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Builder
  {
    private ISqlCondition condition;
    private final Table table;
    private final ContentValues values;
    
    public Builder(Table paramTable, ContentValues paramContentValues)
    {
      AppMethodBeat.i(244426);
      this.table = paramTable;
      this.values = paramContentValues;
      AppMethodBeat.o(244426);
    }
    
    public final UpdateSql build()
    {
      String[] arrayOfString = null;
      AppMethodBeat.i(244452);
      if ((this.table instanceof MultiTable))
      {
        localObject = new IllegalArgumentException("Not support multi table delete");
        AppMethodBeat.o(244452);
        throw ((Throwable)localObject);
      }
      String str = this.table.toSql();
      ContentValues localContentValues = this.values;
      Object localObject = this.condition;
      ISqlCondition localISqlCondition;
      if (localObject == null)
      {
        localObject = null;
        localISqlCondition = this.condition;
        if (localISqlCondition != null) {
          break label100;
        }
      }
      for (;;)
      {
        localObject = new UpdateSql(str, localContentValues, (String)localObject, arrayOfString);
        AppMethodBeat.o(244452);
        return localObject;
        localObject = ((ISqlCondition)localObject).toSql();
        break;
        label100:
        arrayOfString = localISqlCondition.params();
      }
    }
    
    public final Table getTable()
    {
      return this.table;
    }
    
    public final ContentValues getValues()
    {
      return this.values;
    }
    
    public final Builder where(ISqlCondition paramISqlCondition)
    {
      AppMethodBeat.i(244443);
      s.u(paramISqlCondition, "condition");
      this.condition = paramISqlCondition;
      AppMethodBeat.o(244443);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.UpdateSql
 * JD-Core Version:    0.7.0.1
 */