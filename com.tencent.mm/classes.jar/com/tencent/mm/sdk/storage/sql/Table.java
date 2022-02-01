package com.tencent.mm.sdk.storage.sql;

import android.content.ContentValues;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Table;", "Lcom/tencent/mm/sdk/storage/sql/ISqlTable;", "()V", "delete", "Lcom/tencent/mm/sdk/storage/sql/DeleteSql$Builder;", "index", "Lcom/tencent/mm/sdk/storage/sql/IndexSql$Builder;", "name", "", "select", "Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;", "column", "Lcom/tencent/mm/sdk/storage/sql/Column;", "columns", "", "Lcom/tencent/mm/sdk/storage/sql/ISqlColumn;", "selectAll", "update", "Lcom/tencent/mm/sdk/storage/sql/UpdateSql$Builder;", "values", "Landroid/content/ContentValues;", "item", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class Table
  implements ISqlTable
{
  public final DeleteSql.Builder delete()
  {
    return new DeleteSql.Builder(this);
  }
  
  public final IndexSql.Builder index(String paramString)
  {
    s.u(paramString, "name");
    return new IndexSql.Builder(this, paramString);
  }
  
  public String[] params()
  {
    return ISqlTable.DefaultImpls.params((ISqlTable)this);
  }
  
  public final SelectSql.Builder select(Column paramColumn)
  {
    s.u(paramColumn, "column");
    return select(p.listOf(paramColumn));
  }
  
  public final SelectSql.Builder select(List<? extends ISqlColumn> paramList)
  {
    s.u(paramList, "columns");
    return new SelectSql.Builder(this, paramList);
  }
  
  public final SelectSql.Builder selectAll()
  {
    return new SelectSql.Builder(this, (List)ab.aivy);
  }
  
  public final UpdateSql.Builder update(ContentValues paramContentValues)
  {
    s.u(paramContentValues, "values");
    return new UpdateSql.Builder(this, paramContentValues);
  }
  
  public final UpdateSql.Builder update(IAutoDBItem paramIAutoDBItem)
  {
    s.u(paramIAutoDBItem, "item");
    paramIAutoDBItem = paramIAutoDBItem.convertTo();
    s.s(paramIAutoDBItem, "item.convertTo()");
    return new UpdateSql.Builder(this, paramIAutoDBItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Table
 * JD-Core Version:    0.7.0.1
 */