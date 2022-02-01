package com.tencent.mm.sdk.storage.sql;

import android.content.ContentValues;
import com.tencent.mm.sdk.sql.ISqlColumn;
import com.tencent.mm.sdk.sql.ISqlTable;
import com.tencent.mm.sdk.sql.ISqlTable.DefaultImpls;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/Table;", "Lcom/tencent/mm/sdk/sql/ISqlTable;", "()V", "delete", "Lcom/tencent/mm/sdk/storage/sql/DeleteSql$Builder;", "select", "Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder;", "columns", "", "Lcom/tencent/mm/sdk/sql/ISqlColumn;", "selectAll", "update", "Lcom/tencent/mm/sdk/storage/sql/UpdateSql$Builder;", "values", "Landroid/content/ContentValues;", "item", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "wechat-sdk_release"})
public abstract class Table
  implements ISqlTable
{
  public final DeleteSql.Builder delete()
  {
    return new DeleteSql.Builder(this);
  }
  
  public String[] params()
  {
    return ISqlTable.DefaultImpls.params(this);
  }
  
  public final SelectSql.Builder select(List<? extends ISqlColumn> paramList)
  {
    p.k(paramList, "columns");
    return new SelectSql.Builder(this, paramList);
  }
  
  public final SelectSql.Builder selectAll()
  {
    return new SelectSql.Builder(this, (List)v.aaAd);
  }
  
  public final UpdateSql.Builder update(ContentValues paramContentValues)
  {
    p.k(paramContentValues, "values");
    return new UpdateSql.Builder(this, paramContentValues);
  }
  
  public final UpdateSql.Builder update(IAutoDBItem paramIAutoDBItem)
  {
    p.k(paramIAutoDBItem, "item");
    paramIAutoDBItem = paramIAutoDBItem.convertTo();
    p.j(paramIAutoDBItem, "item.convertTo()");
    return new UpdateSql.Builder(this, paramIAutoDBItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Table
 * JD-Core Version:    0.7.0.1
 */