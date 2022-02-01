package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/DeleteSql;", "Lcom/tencent/mm/sdk/storage/sql/SqlObj;", "table", "", "whereSql", "params", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getTable", "()Ljava/lang/String;", "getWhereSql", "run", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "toSql", "Builder", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DeleteSql
  extends SqlObj
{
  private final String table;
  private final String whereSql;
  
  public DeleteSql(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    super("", paramArrayOfString);
    AppMethodBeat.i(244301);
    this.table = paramString1;
    this.whereSql = paramString2;
    AppMethodBeat.o(244301);
  }
  
  public final String getTable()
  {
    return this.table;
  }
  
  public final String getWhereSql()
  {
    return this.whereSql;
  }
  
  public final int run(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(244325);
    if (paramISQLiteDatabase == null)
    {
      AppMethodBeat.o(244325);
      return -1;
    }
    int i = paramISQLiteDatabase.delete(this.table, this.whereSql, params());
    AppMethodBeat.o(244325);
    return i;
  }
  
  public final String toSql()
  {
    AppMethodBeat.i(244319);
    String str1 = this.whereSql;
    if (str1 == null) {
      str1 = null;
    }
    for (;;)
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = "";
      }
      str1 = "DELETE FROM " + this.table + str2;
      AppMethodBeat.o(244319);
      return str1;
      int i;
      if (!n.bp((CharSequence)str1))
      {
        i = 1;
        label68:
        if (i == 0) {
          break label86;
        }
      }
      for (;;)
      {
        if (str1 != null) {
          break label91;
        }
        str1 = null;
        break;
        i = 0;
        break label68;
        label86:
        str1 = null;
      }
      label91:
      str1 = s.X(" WHERE ", getWhereSql());
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/DeleteSql$Builder;", "", "table", "Lcom/tencent/mm/sdk/storage/sql/Table;", "(Lcom/tencent/mm/sdk/storage/sql/Table;)V", "condition", "Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "logTag", "", "getTable", "()Lcom/tencent/mm/sdk/storage/sql/Table;", "build", "Lcom/tencent/mm/sdk/storage/sql/DeleteSql;", "log", "tag", "where", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Builder
  {
    private ISqlCondition condition;
    private String logTag;
    private final Table table;
    
    public Builder(Table paramTable)
    {
      AppMethodBeat.i(244372);
      this.table = paramTable;
      AppMethodBeat.o(244372);
    }
    
    public final DeleteSql build()
    {
      String[] arrayOfString = null;
      AppMethodBeat.i(244398);
      if ((this.table instanceof MultiTable))
      {
        localObject = new IllegalArgumentException("Not support multi table delete");
        AppMethodBeat.o(244398);
        throw ((Throwable)localObject);
      }
      String str = this.table.toSql();
      Object localObject = this.condition;
      ISqlCondition localISqlCondition;
      if (localObject == null)
      {
        localObject = null;
        localISqlCondition = this.condition;
        if (localISqlCondition != null) {
          break label92;
        }
      }
      for (;;)
      {
        localObject = new DeleteSql(str, (String)localObject, arrayOfString);
        AppMethodBeat.o(244398);
        return localObject;
        localObject = ((ISqlCondition)localObject).toSql();
        break;
        label92:
        arrayOfString = localISqlCondition.params();
      }
    }
    
    public final Table getTable()
    {
      return this.table;
    }
    
    public final Builder log(String paramString)
    {
      AppMethodBeat.i(244384);
      s.u(paramString, "tag");
      this.logTag = paramString;
      AppMethodBeat.o(244384);
      return this;
    }
    
    public final Builder where(ISqlCondition paramISqlCondition)
    {
      AppMethodBeat.i(244390);
      s.u(paramISqlCondition, "condition");
      this.condition = paramISqlCondition;
      AppMethodBeat.o(244390);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.DeleteSql
 * JD-Core Version:    0.7.0.1
 */