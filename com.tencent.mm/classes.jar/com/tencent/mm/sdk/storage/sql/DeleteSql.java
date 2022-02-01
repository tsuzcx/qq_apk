package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.SqlObj;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/DeleteSql;", "Lcom/tencent/mm/sdk/sql/SqlObj;", "table", "", "whereSql", "params", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getTable", "()Ljava/lang/String;", "getWhereSql", "executeDelete", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "toSql", "Builder", "wechat-sdk_release"})
public final class DeleteSql
  extends SqlObj
{
  private final String table;
  private final String whereSql;
  
  public DeleteSql(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    super("", paramArrayOfString);
    AppMethodBeat.i(189881);
    this.table = paramString1;
    this.whereSql = paramString2;
    AppMethodBeat.o(189881);
  }
  
  public final int executeDelete(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(189877);
    if (paramISQLiteDatabase != null)
    {
      int i = paramISQLiteDatabase.delete(this.table, this.whereSql, params());
      AppMethodBeat.o(189877);
      return i;
    }
    AppMethodBeat.o(189877);
    return -1;
  }
  
  public final String getTable()
  {
    return this.table;
  }
  
  public final String getWhereSql()
  {
    return this.whereSql;
  }
  
  public final String toSql()
  {
    AppMethodBeat.i(189874);
    Object localObject = this.whereSql;
    int i;
    if (localObject != null)
    {
      if (n.ba((CharSequence)localObject)) {
        break label94;
      }
      i = 1;
      if (i == 0) {
        break label99;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        String str = " WHERE " + this.whereSql;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localObject = "DELETE FROM " + this.table + (String)localObject;
      AppMethodBeat.o(189874);
      return localObject;
      label94:
      i = 0;
      break;
      label99:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.DeleteSql
 * JD-Core Version:    0.7.0.1
 */