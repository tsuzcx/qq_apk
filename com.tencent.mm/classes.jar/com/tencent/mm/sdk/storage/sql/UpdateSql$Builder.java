package com.tencent.mm.sdk.storage.sql;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.ISqlCondition;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/UpdateSql$Builder;", "", "table", "Lcom/tencent/mm/sdk/storage/sql/Table;", "values", "Landroid/content/ContentValues;", "(Lcom/tencent/mm/sdk/storage/sql/Table;Landroid/content/ContentValues;)V", "condition", "Lcom/tencent/mm/sdk/sql/ISqlCondition;", "getTable", "()Lcom/tencent/mm/sdk/storage/sql/Table;", "getValues", "()Landroid/content/ContentValues;", "build", "Lcom/tencent/mm/sdk/storage/sql/UpdateSql;", "where", "wechat-sdk_release"})
public final class UpdateSql$Builder
{
  private ISqlCondition condition;
  private final Table table;
  private final ContentValues values;
  
  public UpdateSql$Builder(Table paramTable, ContentValues paramContentValues)
  {
    AppMethodBeat.i(193580);
    this.table = paramTable;
    this.values = paramContentValues;
    AppMethodBeat.o(193580);
  }
  
  public final UpdateSql build()
  {
    String[] arrayOfString = null;
    AppMethodBeat.i(193578);
    if ((this.table instanceof MultiTable))
    {
      localObject = (Throwable)new IllegalArgumentException("Not support multi table delete");
      AppMethodBeat.o(193578);
      throw ((Throwable)localObject);
    }
    String str = this.table.toSql();
    ContentValues localContentValues = this.values;
    Object localObject = this.condition;
    if (localObject != null) {}
    for (localObject = ((ISqlCondition)localObject).toSql();; localObject = null)
    {
      ISqlCondition localISqlCondition = this.condition;
      if (localISqlCondition != null) {
        arrayOfString = localISqlCondition.params();
      }
      localObject = new UpdateSql(str, localContentValues, (String)localObject, arrayOfString);
      AppMethodBeat.o(193578);
      return localObject;
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
    AppMethodBeat.i(193575);
    p.k(paramISqlCondition, "condition");
    this.condition = paramISqlCondition;
    AppMethodBeat.o(193575);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.UpdateSql.Builder
 * JD-Core Version:    0.7.0.1
 */