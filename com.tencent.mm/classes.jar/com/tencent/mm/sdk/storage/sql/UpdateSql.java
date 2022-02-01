package com.tencent.mm.sdk.storage.sql;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.SqlObj;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/UpdateSql;", "Lcom/tencent/mm/sdk/sql/SqlObj;", "table", "", "values", "Landroid/content/ContentValues;", "whereSql", "params", "", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V", "getTable", "()Ljava/lang/String;", "getValues", "()Landroid/content/ContentValues;", "getWhereSql", "executeUpdate", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "toSql", "Builder", "wechat-sdk_release"})
public final class UpdateSql
  extends SqlObj
{
  private final String table;
  private final ContentValues values;
  private final String whereSql;
  
  public UpdateSql(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    super("", paramArrayOfString);
    AppMethodBeat.i(187882);
    this.table = paramString1;
    this.values = paramContentValues;
    this.whereSql = paramString2;
    AppMethodBeat.o(187882);
  }
  
  public final int executeUpdate(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(187873);
    if (paramISQLiteDatabase != null)
    {
      int i = paramISQLiteDatabase.update(this.table, this.values, this.whereSql, params());
      AppMethodBeat.o(187873);
      return i;
    }
    AppMethodBeat.o(187873);
    return -1;
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
  
  public final String toSql()
  {
    int i = 0;
    AppMethodBeat.i(187871);
    Object localObject1 = this.values.keySet();
    p.j(localObject1, "values.keySet()");
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Object localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = (String)((Iterator)localObject3).next();
      Object localObject4 = this.values.get((String)localObject1);
      if ((localObject4 instanceof Number)) {}
      for (localObject1 = (String)localObject1 + " = " + localObject4;; localObject1 = (String)localObject1 + " = '" + localObject4 + '\'')
      {
        ((Collection)localObject2).add(localObject1);
        break;
      }
    }
    localObject3 = j.a((Iterable)localObject2, (CharSequence)", ", null, null, 0, null, null, 62);
    localObject1 = this.whereSql;
    if (localObject1 != null)
    {
      if (!n.ba((CharSequence)localObject1)) {
        i = 1;
      }
      if (i == 0) {
        break label282;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = " WHERE " + this.whereSql;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject1 = "UPDATE " + this.table + " SET " + (String)localObject3 + (String)localObject1;
      AppMethodBeat.o(187871);
      return localObject1;
      label282:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.UpdateSql
 * JD-Core Version:    0.7.0.1
 */